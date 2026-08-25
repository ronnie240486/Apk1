package com.rencia.universal;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Lifecycle coordinator for the PDF contract. It intentionally never executes an
 * arbitrary command: the host application must implement the supported-command handler.
 */
public final class UniversalRuntime {
    public static final long POLL_INTERVAL_SECONDS = 60L;

    public interface StateStore {
        String get(String key);
        void put(String key, String value);
    }

    public interface Listener {
        void onConfig(UniversalContract.ConfigResponse config);
        void onBlocked(String title, String message, String renewButtonText, String renewButtonUrl);
        void onPendingRegistration();
        void onPlaylistSyncRequested(UniversalContract.ConfigResponse config, String reason);
        void onExpirationModal(UniversalContract.Expiration expiration);
        boolean onNotification(UniversalContract.Notification notification);
        CommandResult onSupportedCommand(UniversalContract.RemoteCommand command);
        void onHeartbeatError(Exception error);
        void onPlaybackUnavailable(String message);

        /** Called when the server says the primary list has been restored. */
        default void onPrimaryListRestored() { }
    }

    public static final class CommandResult {
        public final String status;
        public final String message;

        private CommandResult(String status, String message) {
            this.status = status;
            this.message = message;
        }

        public static CommandResult executed(String message) {
            return new CommandResult("executed", message);
        }

        public static CommandResult failed(String message) {
            return new CommandResult("failed", message);
        }
    }

    private final UniversalApiClient api;
    private final String mac;
    private final Listener listener;
    private final StateStore state;
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private volatile String currentContent = "";
    private volatile int activeListNumber = 1;
    private volatile UniversalContract.ConfigResponse currentConfig;
    private volatile boolean started;

    public UniversalRuntime(UniversalApiClient api, String mac, Listener listener, StateStore state) {
        if (api == null || listener == null || state == null) {
            throw new IllegalArgumentException("api, listener and state are required");
        }
        this.api = api;
        this.mac = mac;
        this.listener = listener;
        this.state = state;
        this.activeListNumber = parsePositiveInt(state.get("active_list_number"), 1);
    }

    /** Run once immediately, then poll heartbeat and notifications every 60 seconds. */
    public synchronized void start() {
        if (started) return;
        started = true;
        executor.execute(new Runnable() {
            @Override public void run() {
                refreshConfiguration("startup");
                poll();
            }
        });
        executor.scheduleAtFixedRate(new Runnable() {
            @Override public void run() { poll(); }
        }, POLL_INTERVAL_SECONDS, POLL_INTERVAL_SECONDS, TimeUnit.SECONDS);
    }

    public void setCurrentContent(String content) {
        currentContent = content == null ? "" : content;
        executor.execute(new Runnable() {
            @Override public void run() { sendHeartbeat(); }
        });
    }

    /** Invoke this only for a real network/timeout/list-unavailable playback failure. */
    public void reportRealPlaybackFailure() {
        executor.execute(new Runnable() {
            @Override public void run() {
                try {
                    UniversalContract.PlaybackFailureResponse response =
                            api.reportPlaybackFailure(mac, activeListNumber);
                    if (response.switchApplied || response.playlistSyncRequired) {
                        refreshConfiguration("playback-failure");
                    } else if ("primary_restored".equals(response.failoverState)) {
                        listener.onPrimaryListRestored();
                        refreshConfiguration("primary-restored");
                    } else if (response.message != null && !response.message.isEmpty()) {
                        listener.onPlaybackUnavailable(response.message);
                    }
                } catch (Exception error) {
                    listener.onHeartbeatError(error);
                }
            }
        });
    }

    public synchronized void stop() {
        started = false;
        executor.shutdownNow();
    }

    private void poll() {
        if (!started) return;
        sendHeartbeat();
        try {
            UniversalContract.NotificationResponse response = api.getNotifications(mac);
            handleNotifications(response);
            if (response.playlistSyncRequired) {
                refreshConfiguration("notification-sync");
            }
            if ("primary_restored".equals(response.failoverState)) {
                listener.onPrimaryListRestored();
                refreshConfiguration("primary-restored");
            }
            handleRemoteCommands();
        } catch (Exception error) {
            listener.onHeartbeatError(error);
        }
    }

    private void sendHeartbeat() {
        try {
            api.heartbeat(mac, currentContent);
        } catch (Exception error) {
            listener.onHeartbeatError(error);
        }
    }

    private void refreshConfiguration(String reason) {
        try {
            UniversalContract.ConfigResponse config = api.getConfig(mac);
            currentConfig = config;
            activeListNumber = config.activeListNumber > 0 ? config.activeListNumber : activeListNumber;
            state.put("active_list_number", String.valueOf(activeListNumber));
            listener.onConfig(config);
            if (!config.registered) {
                listener.onPendingRegistration();
                return;
            }
            if (!config.allowed) {
                listener.onBlocked(config.blockTitle, config.blockMessage,
                        config.renewButtonText, config.renewButtonUrl);
                return;
            }
            if (config.playlistSyncRequired || !"startup".equals(reason)) {
                listener.onPlaylistSyncRequested(config, reason);
            }
            showExpirationOnce(config.expirationShowModal, config.expirationModalKey,
                    config.expirationModalTitle, config.expirationModalMessage);
        } catch (Exception error) {
            listener.onHeartbeatError(error);
        }
    }

    private void handleNotifications(UniversalContract.NotificationResponse response) {
        UniversalContract.Expiration expiration = response.expiration;
        if (expiration != null) {
            showExpirationOnce(expiration.showModal, expiration.modalKey,
                    expiration.title, expiration.message);
        }
        List<UniversalContract.Notification> notifications = response.notifications;
        for (UniversalContract.Notification notification : notifications) {
            if (notification.acknowledged || notification.id == null || notification.id.isEmpty()) continue;
            try {
                if (listener.onNotification(notification)) {
                    api.acknowledgeNotification(mac, notification.id);
                }
            } catch (Exception error) {
                listener.onHeartbeatError(error);
            }
        }
        if (response.activeListNumber > 0) {
            activeListNumber = response.activeListNumber;
            state.put("active_list_number", String.valueOf(activeListNumber));
        }
    }

    private void handleRemoteCommands() throws IOException, JSONException {
        UniversalContract.RemoteCommandsResponse response = api.getRemoteCommands(mac);
        for (UniversalContract.RemoteCommand command : response.commands) {
            if (command.id == null || command.id.isEmpty()) continue;
            CommandResult result;
            try {
                result = listener.onSupportedCommand(command);
                if (result == null) result = CommandResult.failed("Command was not supported");
            } catch (Exception error) {
                result = CommandResult.failed("Supported command failed");
            }
            // Only the two statuses defined by the PDF can reach the server.
            api.acknowledgeCommand(mac, command.id, result.status, result.message);
        }
    }

    private void showExpirationOnce(boolean show, String key, String title, String message) {
        if (!show || key == null || key.isEmpty()) return;
        String previous = state.get("expiration_modal_key");
        if (key.equals(previous)) return;
        state.put("expiration_modal_key", key);
        UniversalContract.Expiration expiration = new UniversalContract.Expiration();
        expiration.showModal = true;
        expiration.modalKey = key;
        expiration.title = title;
        expiration.message = message;
        listener.onExpirationModal(expiration);
    }

    private static int parsePositiveInt(String value, int fallback) {
        try {
            int parsed = Integer.parseInt(value);
            return parsed > 0 ? parsed : fallback;
        } catch (Exception ignored) {
            return fallback;
        }
    }
}

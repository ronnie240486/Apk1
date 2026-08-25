package com.rencia.universal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** JSON contract defined by main(3).pdf. Android supplies org.json. */
public final class UniversalContract {
    private UniversalContract() { }

    public static final class AppId {
        private AppId() { }

        public static boolean isSupported(String appId) {
            return "prestige".equals(appId) || "optimus".equals(appId)
                    || "imperio".equals(appId) || "infinitus".equals(appId)
                    || "supremus".equals(appId) || "evolux".equals(appId)
                    || "nexus".equals(appId);
        }

        public static void requireSupported(String appId) {
            if (!isSupported(appId)) {
                throw new IllegalArgumentException(
                        "Unsupported universal appId: " + appId
                                + ". Configure the APK family explicitly; P2Server is not listed in the PDF.");
            }
        }
    }

    public static final class ConfigResponse {
        public String appId;
        public String appName;
        public boolean registered;
        public boolean allowed;
        public String status;
        public String expirationDate;
        public boolean expirationShowModal;
        public String expirationModalKey;
        public String expirationModalTitle;
        public String expirationModalMessage;
        public String messageTitle;
        public String messageText;
        public String serverApiUrl;
        public String blockTitle;
        public String blockMessage;
        public String renewButtonText;
        public String renewButtonUrl;
        public String logoUrl;
        public String bannerUrl;
        public String backgroundUrl;
        public String messageImageUrl;
        public String liveTvIconUrl;
        public String moviesIconUrl;
        public String seriesIconUrl;
        public PlayerOptions player = new PlayerOptions();
        public List<String> playlistUrls = Collections.emptyList();
        public String activeListName;
        public int activeListNumber = 1;
        public boolean playlistSyncRequired;

        public static ConfigResponse fromJson(String body) throws JSONException {
            JSONObject json = new JSONObject(body);
            ConfigResponse out = new ConfigResponse();
            out.appId = optString(json, "app_id");
            out.appName = optString(json, "app_name");
            out.registered = json.optBoolean("registered", false);
            out.allowed = json.optBoolean("allowed", false);
            out.status = optString(json, "status");
            out.expirationDate = optString(json, "expiration_date");
            out.expirationShowModal = json.optBoolean("expiration_show_modal", false);
            out.expirationModalKey = optString(json, "expiration_modal_key");
            out.expirationModalTitle = optString(json, "expiration_modal_title");
            out.expirationModalMessage = optString(json, "expiration_modal_message");
            out.messageTitle = optString(json, "message_title");
            out.messageText = optString(json, "message_text");
            out.serverApiUrl = optString(json, "server_api_url");
            out.blockTitle = optString(json, "block_title");
            out.blockMessage = optString(json, "block_message");
            out.renewButtonText = optString(json, "renew_button_text");
            out.renewButtonUrl = optString(json, "renew_button_url");
            out.logoUrl = optString(json, "logo_url");
            out.bannerUrl = optString(json, "banner_url");
            out.backgroundUrl = optString(json, "background_url");
            out.messageImageUrl = optString(json, "message_image_url");
            JSONObject icons = json.optJSONObject("icons");
            if (icons != null) {
                out.liveTvIconUrl = optString(icons, "live_tv");
                out.moviesIconUrl = optString(icons, "movies");
                out.seriesIconUrl = optString(icons, "series");
            }
            out.player = PlayerOptions.fromJson(json.optJSONObject("player"));
            out.playlistUrls = strings(json.optJSONArray("playlist_urls"));
            out.activeListName = optString(json, "active_list_name");
            out.activeListNumber = json.optInt("active_list_number", 1);
            out.playlistSyncRequired = json.optBoolean("playlist_sync_required", false);
            return out;
        }
    }

    public static final class PlayerOptions {
        public boolean autoplay;
        public int rotation;
        public String quality;
        public int retries;
        public String language;
        public boolean subtitles;

        static PlayerOptions fromJson(JSONObject json) {
            PlayerOptions out = new PlayerOptions();
            if (json == null) return out;
            out.autoplay = json.optBoolean("autoplay", false);
            out.rotation = json.optInt("rotation", 0);
            out.quality = optString(json, "quality");
            out.retries = json.optInt("retries", 0);
            out.language = optString(json, "language");
            out.subtitles = json.optBoolean("subtitles", false);
            return out;
        }
    }

    public static final class UpdateResponse {
        public String version;
        public String url;
        public String apkLink;
        public boolean forceUpdate;
        public boolean updateAvailable;
        public String releaseNotes;

        static UpdateResponse fromJson(String body) throws JSONException {
            JSONObject json = new JSONObject(body);
            UpdateResponse out = new UpdateResponse();
            out.version = optString(json, "version");
            out.url = optString(json, "url");
            out.apkLink = optString(json, "apk_link");
            out.forceUpdate = json.optBoolean("force_update", false);
            out.updateAvailable = json.optBoolean("update_available", false);
            out.releaseNotes = optString(json, "release_notes");
            return out;
        }
    }

    public static final class HeartbeatResponse {
        public boolean success;
        public boolean contentUpdated;
        public String timestamp;
        public String command;

        static HeartbeatResponse fromJson(String body) throws JSONException {
            JSONObject json = new JSONObject(body);
            HeartbeatResponse out = new HeartbeatResponse();
            out.success = json.optBoolean("success", false);
            out.contentUpdated = json.optBoolean("contentUpdated", false);
            out.timestamp = optString(json, "timestamp");
            out.command = optString(json, "command");
            return out;
        }
    }

    public static final class NotificationResponse {
        public List<Notification> notifications = Collections.emptyList();
        public Expiration expiration = new Expiration();
        public boolean failoverActive;
        public String failoverState;
        public String activeListName;
        public int activeListNumber = 1;
        public boolean playlistSyncRequired;
        public String playlistSyncMode;
        public String playlistSyncMessage;
        public String failoverTransitionId;

        static NotificationResponse fromJson(String body) throws JSONException {
            JSONObject json = new JSONObject(body);
            NotificationResponse out = new NotificationResponse();
            JSONArray items = json.optJSONArray("notifications");
            if (items != null) {
                ArrayList<Notification> list = new ArrayList<>();
                for (int i = 0; i < items.length(); i++) {
                    JSONObject item = items.optJSONObject(i);
                    if (item != null) list.add(Notification.fromJson(item));
                }
                out.notifications = list;
            }
            JSONObject expiration = json.optJSONObject("expiration");
            if (expiration != null) out.expiration = Expiration.fromJson(expiration);
            out.failoverActive = json.optBoolean("failover_active", false);
            out.failoverState = optString(json, "failover_state");
            out.activeListName = optString(json, "active_list_name");
            out.activeListNumber = json.optInt("active_list_number", 1);
            out.playlistSyncRequired = json.optBoolean("playlist_sync_required", false);
            out.playlistSyncMode = optString(json, "playlist_sync_mode");
            out.playlistSyncMessage = optString(json, "playlist_sync_message");
            out.failoverTransitionId = optString(json, "failover_transition_id");
            return out;
        }
    }

    public static final class Notification {
        public String id;
        public String status;
        public String severity;
        public String title;
        public String message;
        public String createdAt;
        public boolean acknowledged;

        static Notification fromJson(JSONObject json) {
            Notification out = new Notification();
            out.id = optString(json, "id");
            out.status = optString(json, "status");
            out.severity = optString(json, "severity");
            out.title = optString(json, "title");
            out.message = optString(json, "message");
            out.createdAt = optString(json, "created_at");
            out.acknowledged = json.optBoolean("acknowledged", false);
            return out;
        }
    }

    public static final class Expiration {
        public String date;
        public int daysRemaining;
        public String state;
        public String modalKey;
        public String title;
        public String message;
        public boolean showModal;

        static Expiration fromJson(JSONObject json) {
            Expiration out = new Expiration();
            out.date = optString(json, "date");
            out.daysRemaining = json.optInt("days_remaining", 0);
            out.state = optString(json, "state");
            out.modalKey = optString(json, "expiration_modal_key");
            out.title = optString(json, "expiration_modal_title");
            out.message = optString(json, "expiration_modal_message");
            out.showModal = json.optBoolean("expiration_show_modal", false);
            return out;
        }
    }

    public static final class PlaybackFailureResponse {
        public boolean switchApplied;
        public String message;
        public boolean failoverActive;
        public int activeListNumber = 1;
        public boolean playlistSyncRequired;
        public String failoverTransitionId;
        public String failoverState;

        static PlaybackFailureResponse fromJson(String body) throws JSONException {
            JSONObject json = new JSONObject(body);
            PlaybackFailureResponse out = new PlaybackFailureResponse();
            out.switchApplied = json.optBoolean("switch_applied", false);
            out.message = optString(json, "message");
            out.failoverActive = json.optBoolean("failover_active", false);
            out.activeListNumber = json.optInt("active_list_number", 1);
            out.playlistSyncRequired = json.optBoolean("playlist_sync_required", false);
            out.failoverTransitionId = optString(json, "failover_transition_id");
            out.failoverState = optString(json, "failover_state");
            return out;
        }
    }

    public static final class RemoteCommand {
        public String id;
        public String type;
        public JSONObject payload;

        static RemoteCommand fromJson(JSONObject json) {
            RemoteCommand out = new RemoteCommand();
            out.id = optString(json, "command_id");
            if (out.id.isEmpty()) out.id = optString(json, "id");
            out.type = optString(json, "type");
            out.payload = json.optJSONObject("payload");
            return out;
        }
    }

    public static final class RemoteCommandsResponse {
        public List<RemoteCommand> commands = Collections.emptyList();

        static RemoteCommandsResponse fromJson(String body) throws JSONException {
            JSONObject json = new JSONObject(body);
            JSONArray items = json.optJSONArray("commands");
            ArrayList<RemoteCommand> list = new ArrayList<>();
            if (items != null) {
                for (int i = 0; i < items.length(); i++) {
                    JSONObject item = items.optJSONObject(i);
                    if (item != null) list.add(RemoteCommand.fromJson(item));
                }
            }
            RemoteCommandsResponse out = new RemoteCommandsResponse();
            out.commands = list;
            return out;
        }
    }

    public static final class LoginResponse {
        public boolean authenticated;
        public boolean registered;
        public boolean allowed;
        public String status;
        public String expirationDate;
        public String dnsHost;
        public String dnsUrl;
        public String playlistUrl;
        public List<String> playlists = Collections.emptyList();
        public ConfigResponse config;

        static LoginResponse fromJson(String body) throws JSONException {
            JSONObject json = new JSONObject(body);
            LoginResponse out = new LoginResponse();
            out.authenticated = json.optBoolean("authenticated", false);
            out.registered = json.optBoolean("registered", false);
            out.allowed = json.optBoolean("allowed", false);
            out.status = optString(json, "status");
            out.expirationDate = optString(json, "expiration_date");
            out.dnsHost = optString(json, "dns_host");
            out.dnsUrl = optString(json, "dns_url");
            out.playlistUrl = optString(json, "playlist_url");
            out.playlists = strings(json.optJSONArray("playlists"));
            JSONObject visual = json.optJSONObject("config");
            if (visual != null) out.config = ConfigResponse.fromJson(visual.toString());
            return out;
        }
    }

    static String optString(JSONObject json, String key) {
        String value = json.optString(key, "");
        return "null".equals(value) ? "" : value;
    }

    private static List<String> strings(JSONArray array) {
        if (array == null) return Collections.emptyList();
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            String value = array.optString(i, "");
            if (!value.isEmpty()) result.add(value);
        }
        return result;
    }
}

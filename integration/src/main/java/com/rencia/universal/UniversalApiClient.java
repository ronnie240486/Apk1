package com.rencia.universal;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/** Small synchronous client for the universal Rencia App contract. Run off the UI thread. */
public final class UniversalApiClient {
    public static final String DEFAULT_BASE_URL = "https://renciaapp.manus.space";
    private static final int CONNECT_TIMEOUT_MS = 10_000;
    private static final int READ_TIMEOUT_MS = 15_000;

    private final String baseUrl;
    private final String appId;

    public UniversalApiClient(String appId) {
        this(DEFAULT_BASE_URL, appId);
    }

    public UniversalApiClient(String baseUrl, String appId) {
        if (baseUrl == null || !baseUrl.toLowerCase().startsWith("https://")) {
            throw new IllegalArgumentException("The universal API must use HTTPS");
        }
        UniversalContract.AppId.requireSupported(appId);
        this.baseUrl = trimTrailingSlash(baseUrl);
        this.appId = appId;
    }

    public UniversalContract.ConfigResponse getConfig(String mac) throws IOException, JSONException {
        return UniversalContract.ConfigResponse.fromJson(
                get("/api/v5/apps/" + path(appId) + "/config?mac=" + query(mac)).body);
    }

    public UniversalContract.UpdateResponse getUpdate(String mac) throws IOException, JSONException {
        return UniversalContract.UpdateResponse.fromJson(
                get("/api/v5/apps/" + path(appId) + "/update?mac=" + query(mac)).body);
    }

    public UniversalContract.HeartbeatResponse heartbeat(String mac, String currentContent)
            throws IOException, JSONException {
        StringBuilder endpoint = new StringBuilder("/api/v5/heartbeat?mac=").append(query(mac));
        if (currentContent != null && !currentContent.isEmpty()) {
            endpoint.append("&current_content=").append(query(currentContent));
        }
        return UniversalContract.HeartbeatResponse.fromJson(get(endpoint.toString()).body);
    }

    public UniversalContract.NotificationResponse getNotifications(String mac)
            throws IOException, JSONException {
        return UniversalContract.NotificationResponse.fromJson(
                get("/api/v5/list-notifications?mac=" + query(mac)).body);
    }

    public UniversalContract.PlaybackFailureResponse reportPlaybackFailure(
            String mac, int activeListNumber) throws IOException, JSONException {
        JSONObject body = new JSONObject();
        body.put("mac", requireMac(mac));
        body.put("active_list_number", activeListNumber);
        return UniversalContract.PlaybackFailureResponse.fromJson(
                postJson("/api/v5/playback-failure", body).body);
    }

    public boolean acknowledgeNotification(String mac, String alertId)
            throws IOException, JSONException {
        JSONObject body = new JSONObject();
        body.put("mac", requireMac(mac));
        body.put("alert_id", requireNonEmpty(alertId, "alertId"));
        return postJson("/api/v5/list-notifications/ack", body).json.optBoolean("success", false);
    }

    public UniversalContract.RemoteCommandsResponse getRemoteCommands(String mac)
            throws IOException, JSONException {
        return UniversalContract.RemoteCommandsResponse.fromJson(
                get("/api/v5/remote-commands?mac=" + query(mac)).body);
    }

    public boolean acknowledgeCommand(String mac, String commandId, String status, String resultMessage)
            throws IOException, JSONException {
        if (!"executed".equals(status) && !"failed".equals(status)) {
            throw new IllegalArgumentException("Command ACK status must be executed or failed");
        }
        JSONObject body = new JSONObject();
        body.put("mac", requireMac(mac));
        body.put("command_id", requireNonEmpty(commandId, "commandId"));
        body.put("status", status);
        if (resultMessage != null && !resultMessage.isEmpty()) {
            body.put("result_message", resultMessage);
        }
        return postJson("/api/v5/remote-commands/ack", body).json.optBoolean("success", false);
    }

    public UniversalContract.LoginResponse login(
            String username, String password, String mac) throws IOException, JSONException {
        JSONObject body = new JSONObject();
        body.put("username", requireNonEmpty(username, "username"));
        // Do not log this object or expose it in exception messages.
        body.put("password", requireNonEmpty(password, "password"));
        body.put("appId", appId);
        if (mac != null && !mac.isEmpty()) body.put("mac", requireMac(mac));
        return UniversalContract.LoginResponse.fromJson(
                postJson("/api/v5/app-login", body).body);
    }

    private HttpResult get(String path) throws IOException, JSONException {
        return request("GET", path, null);
    }

    private HttpResult postJson(String path, JSONObject body) throws IOException, JSONException {
        return request("POST", path, body.toString());
    }

    private HttpResult request(String method, String path, String body) throws IOException, JSONException {
        HttpURLConnection connection = (HttpURLConnection) new URL(baseUrl + path).openConnection();
        connection.setRequestMethod(method);
        connection.setConnectTimeout(CONNECT_TIMEOUT_MS);
        connection.setReadTimeout(READ_TIMEOUT_MS);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Cache-Control", "no-cache, no-store");
        connection.setRequestProperty("Pragma", "no-cache");
        connection.setRequestProperty("Accept-Charset", "UTF-8");
        if (body != null) {
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
            connection.setFixedLengthStreamingMode(bytes.length);
            try (OutputStream output = connection.getOutputStream()) {
                output.write(bytes);
            }
        }
        try {
            int status = connection.getResponseCode();
            String responseBody = read(status >= 400 ? connection.getErrorStream() : connection.getInputStream());
            if (status < 200 || status >= 300) {
                throw new IOException("Universal API HTTP status " + status);
            }
            return new HttpResult(status, responseBody, new JSONObject(responseBody));
        } finally {
            connection.disconnect();
        }
    }

    private static String read(InputStream stream) throws IOException {
        if (stream == null) return "{}";
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(stream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) result.append(line);
        }
        return result.toString();
    }

    private static String query(String value) {
        try {
            return URLEncoder.encode(requireMac(value), "UTF-8");
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid MAC", e);
        }
    }

    private static String path(String value) {
        try {
            return URLEncoder.encode(value, "UTF-8");
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid path value", e);
        }
    }

    private static String requireMac(String mac) {
        String value = requireNonEmpty(mac, "mac").trim().toUpperCase();
        if (!value.matches("[0-9A-F]{2}(:[0-9A-F]{2}){5}")) {
            throw new IllegalArgumentException("MAC must use AA:BB:CC:DD:EE:FF format");
        }
        return value;
    }

    private static String requireNonEmpty(String value, String name) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(name + " cannot be empty");
        }
        return value;
    }

    private static String trimTrailingSlash(String value) {
        while (value.endsWith("/")) value = value.substring(0, value.length() - 1);
        return value;
    }

    private static final class HttpResult {
        final int status;
        final String body;
        final JSONObject json;

        HttpResult(int status, String body, JSONObject json) {
            this.status = status;
            this.body = body;
            this.json = json;
        }
    }
}

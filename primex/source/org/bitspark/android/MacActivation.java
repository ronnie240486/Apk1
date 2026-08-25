package org.bitspark.android;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/** Polls the Prestige panel using only the device MAC/ID. */
public final class MacActivation {
    private static final String BASE_URL = "https://renciaapp.manus.space";
    private static final String APP_ID = "prestige";
    private static final long POLL_MS = 5_000L;
    private static volatile boolean running;
    private static volatile Thread worker;

    private MacActivation() { }

    public static synchronized void start(Context context, Spark spark, String mac) {
        start(context, spark, mac, null);
    }

    public static synchronized void start(Context context, Spark spark, String mac,
                                          TextView statusView) {
        if (context == null || spark == null || mac == null || mac.length() == 0) return;
        if (worker != null && worker.isAlive()) return;
        running = true;
        worker = new Thread(new Poller(spark, mac, statusView), "PrimeX-Prestige-Poll");
        worker.setDaemon(true);
        worker.start();
    }

    public static synchronized void stop() {
        running = false;
        worker = null;
    }

    private static final class Poller implements Runnable {
        private final Spark spark;
        private final String mac;
        private final TextView statusView;

        Poller(Spark spark, String mac, TextView statusView) {
            this.spark = spark;
            this.mac = mac;
            this.statusView = statusView;
        }

        @Override public void run() {
            updateStatus("Iniciando analisador...");
            while (running) {
                final String playlist = authorizedPlaylist();
                if (playlist != null && playlist.length() > 0) {
                    running = false;
                    updateStatus("AUTORIZADO\nHTTP 200 | registered=true | allowed=true\n"
                            + "Lista encontrada: SIM\nAbrindo automaticamente...");
                    spark.runOnUiThread(new Runnable() {
                        @Override public void run() {
                            Spark.G(spark, playlist);
                            Spark.H(spark, playlist);
                        }
                    });
                    return;
                }
                try {
                    Thread.sleep(POLL_MS);
                } catch (InterruptedException interrupted) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }

        private String authorizedPlaylist() {
            HttpURLConnection connection = null;
            int status = -1;
            try {
                String encodedMac = URLEncoder.encode(mac, "UTF-8");
                URL url = new URL(BASE_URL + "/api/v5/apps/" + APP_ID
                        + "/config?mac=" + encodedMac);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(8_000);
                connection.setReadTimeout(12_000);
                connection.setUseCaches(false);
                connection.setInstanceFollowRedirects(true);
                connection.setRequestProperty("Accept", "application/json");
                connection.setRequestProperty("Cache-Control", "no-cache, no-store");
                status = connection.getResponseCode();
                if (status < 200 || status >= 300) {
                    String errorBody = MacActivation.readQuiet(connection.getErrorStream());
                    String detail = MacActivation.jsonError(errorBody);
                    updateStatus("HTTP " + status + " | registered=false | allowed=false\n"
                            + "Lista encontrada: NÃO\nErro: " + detail);
                    return null;
                }
                String body = read(connection.getInputStream());
                JSONObject root = new JSONObject(body);
                JSONObject payload = payload(root);
                boolean registered = readBoolean(payload, "registered");
                boolean allowed = readBoolean(payload, "allowed");
                String playlist = firstPlaylist(payload);
                updateStatus("HTTP " + status + " | registered=" + registered
                        + " | allowed=" + allowed + "\nLista encontrada: "
                        + ((playlist == null || playlist.length() == 0) ? "NÃO" : "SIM"));
                if (!registered || !allowed) return null;
                return playlist;
            } catch (Throwable error) {
                String name = error.getClass().getSimpleName();
                String message = error.getMessage();
                if (message == null || message.length() == 0) message = name;
                if (message.length() > 96) message = message.substring(0, 96);
                updateStatus("HTTP " + (status < 0 ? "--" : status)
                        + " | registered=-- | allowed=--\nLista encontrada: NÃO\n"
                        + "Erro: " + message);
                return null;
            } finally {
                if (connection != null) connection.disconnect();
            }
        }

        private void updateStatus(final String result) {
            if (statusView == null) return;
            final String stamp = new SimpleDateFormat("HH:mm:ss", Locale.US)
                    .format(new Date());
            final String text = "Analisador Prestige • consulta a cada 5 segundos\n"
                    + "MAC enviado: " + mac + "\n"
                    + "Última consulta: " + stamp + "\n" + result;
            spark.runOnUiThread(new Runnable() {
                @Override public void run() {
                    statusView.setText(text);
                    statusView.setVisibility(View.VISIBLE);
                }
            });
        }
    }

    private static JSONObject payload(JSONObject root) {
        JSONObject data = root.optJSONObject("data");
        if (data != null && (data.has("registered") || data.has("allowed")
                || data.has("playlist_urls") || data.has("playlist_url"))) {
            return data;
        }
        return root;
    }

    private static String read(InputStream stream) throws Exception {
        if (stream == null) return "";
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(stream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) result.append(line);
        }
        return result.toString();
    }

    private static String readQuiet(InputStream stream) {
        try {
            return read(stream);
        } catch (Throwable ignored) {
            return "";
        }
    }

    private static String jsonError(String body) {
        try {
            JSONObject object = new JSONObject(body);
            String error = object.optString("error", "");
            if (error.length() > 0) return error;
            String message = object.optString("message", "");
            if (message.length() > 0) return message;
        } catch (Throwable ignored) {
            // Fall through to a stable diagnostic.
        }
        return "resposta não autorizada ou MAC não cadastrado";
    }

    private static boolean readBoolean(JSONObject object, String key) {
        Object value = object.opt(key);
        if (value instanceof Boolean) return (Boolean) value;
        if (value instanceof Number) return ((Number) value).intValue() != 0;
        String text = String.valueOf(value);
        return "true".equalsIgnoreCase(text) || "1".equals(text);
    }

    private static String firstPlaylist(JSONObject object) {
        JSONArray values = object.optJSONArray("playlist_urls");
        if (values != null) {
            for (int i = 0; i < values.length(); i++) {
                String value = values.optString(i, "");
                if (value != null && value.length() > 0) return value;
            }
        }
        String single = object.optString("playlist_url", "");
        return single.length() == 0 ? null : single;
    }
}

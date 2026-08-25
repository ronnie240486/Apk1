package org.bitspark.android;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/** Polls the Prestige panel using only the device MAC/ID. */
public final class MacActivation {
    private static final String BASE_URL = "https://renciaapp.manus.space";
    private static final String APP_ID = "prestige";
    private static final long POLL_MS = 5_000L;
    private static volatile boolean running;
    private static volatile Thread worker;

    private MacActivation() { }

    public static synchronized void start(Context context, Spark spark, String mac) {
        if (context == null || spark == null || mac == null || mac.length() == 0) return;
        if (worker != null && worker.isAlive()) return;
        running = true;
        worker = new Thread(new Poller(spark, mac), "PrimeX-Prestige-Poll");
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

        Poller(Spark spark, String mac) {
            this.spark = spark;
            this.mac = mac;
        }

        @Override public void run() {
            while (running) {
                final String playlist = authorizedPlaylist();
                if (playlist != null && playlist.length() > 0) {
                    running = false;
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
            try {
                String encodedMac = URLEncoder.encode(mac, "UTF-8");
                URL url = new URL(BASE_URL + "/api/v5/apps/" + APP_ID
                        + "/config?mac=" + encodedMac);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(8_000);
                connection.setReadTimeout(12_000);
                connection.setUseCaches(false);
                connection.setRequestProperty("Accept", "application/json");
                connection.setRequestProperty("Cache-Control", "no-cache, no-store");
                int status = connection.getResponseCode();
                if (status < 200 || status >= 300) return null;
                String body = read(connection.getInputStream());
                if (!readBoolean(body, "registered") || !readBoolean(body, "allowed")) return null;
                return firstPlaylist(body);
            } catch (Throwable ignored) {
                return null;
            } finally {
                if (connection != null) connection.disconnect();
            }
        }
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

    private static boolean readBoolean(String json, String key) {
        if (json == null) return false;
        String marker = "\"" + key + "\"";
        int position = json.indexOf(marker);
        if (position < 0) return false;
        position = json.indexOf(':', position + marker.length());
        if (position < 0) return false;
        position++;
        while (position < json.length() && Character.isWhitespace(json.charAt(position))) position++;
        return json.regionMatches(true, position, "true", 0, 4);
    }

    private static String firstPlaylist(String json) {
        if (json == null) return null;
        int array = json.indexOf("\"playlist_urls\"");
        if (array >= 0) {
            int open = json.indexOf('[', array);
            int quote = open < 0 ? -1 : json.indexOf('"', open + 1);
            if (quote >= 0) {
                int end = json.indexOf('"', quote + 1);
                if (end > quote + 1) return json.substring(quote + 1, end);
            }
        }
        int single = json.indexOf("\"playlist_url\"");
        if (single >= 0) {
            int colon = json.indexOf(':', single);
            int quote = colon < 0 ? -1 : json.indexOf('"', colon + 1);
            int end = quote < 0 ? -1 : json.indexOf('"', quote + 1);
            if (quote >= 0 && end > quote + 1) return json.substring(quote + 1, end);
        }
        return null;
    }
}

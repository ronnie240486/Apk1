package org.bitspark.android;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;

import java.util.Locale;

/**
 * Returns a 12-hexadecimal device identifier. A real Wi-Fi MAC is preferred
 * when Android exposes it; modern Android versions may return a placeholder,
 * so Android ID is used as a stable fallback.
 */
public final class MacId {
    private MacId() { }

    public static String get12(Context context) {
        try {
            WifiManager manager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            if (manager != null) {
                WifiInfo info = manager.getConnectionInfo();
                if (info != null) {
                    String mac = normalize(info.getMacAddress());
                    if (mac.length() == 12 && !"020000000000".equals(mac)) return mac;
                }
            }
        } catch (Throwable ignored) {
            // Fall through to the stable Android ID fallback.
        }
        String androidId = Settings.Secure.getString(
                context.getContentResolver(), Settings.Secure.ANDROID_ID);
        String normalized = normalize(androidId);
        if (normalized.length() > 12) return normalized.substring(0, 12);
        StringBuilder padded = new StringBuilder(normalized);
        while (padded.length() < 12) padded.append('0');
        return padded.toString();
    }

    private static String normalize(String value) {
        if (value == null) return "";
        return value.replace(":", "")
                .replace("-", "")
                .toUpperCase(Locale.US);
    }
}

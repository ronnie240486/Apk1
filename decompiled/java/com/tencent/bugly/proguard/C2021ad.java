package com.tencent.bugly.proguard;

import android.util.Pair;
import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class C2021ad {
    public static Pair<Integer, String> m4581a(List<String> list) {
        try {
            HashMap map = new HashMap();
            map.put("Atta-Type", "batch-report");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("attaid", "0d000062340").put("token", "2273782735").put(SessionDescription.ATTR_TYPE, "batch").put("version", "v1.0.0");
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put("datas", jSONArray);
            return m4580a("https://h.trace.qq.com/kv", jSONObject.toString(), map);
        } catch (Throwable th) {
            C2029al.m4643b(th);
            return new Pair<>(-1, th.getMessage());
        }
    }

    private static Pair<Integer, String> m4580a(String str, String str2, Map<String, String> map) {
        InputStream inputStream;
        DataOutputStream dataOutputStream;
        String string;
        InputStream inputStream2;
        HttpURLConnection httpURLConnection = null;
        int responseCode = -1;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setRequestMethod(HlsMediaPlaylist.Interstitial.CUE_TRIGGER_POST);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                m4583a(httpURLConnection2, map);
                httpURLConnection2.setConnectTimeout(5000);
                httpURLConnection2.setReadTimeout(5000);
                httpURLConnection2.connect();
                byte[] bytes = str2.getBytes("UTF-8");
                dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                try {
                    dataOutputStream.write(bytes);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    responseCode = httpURLConnection2.getResponseCode();
                    if (responseCode >= 400) {
                        inputStream2 = httpURLConnection2.getErrorStream();
                    } else {
                        inputStream2 = httpURLConnection2.getInputStream();
                    }
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream2, "UTF-8"));
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line);
                            sb.append("\r\n");
                        }
                        bufferedReader.close();
                        string = sb.toString();
                        m4582a((Closeable) null);
                        m4582a(inputStream2);
                        httpURLConnection2.disconnect();
                    } catch (Throwable th) {
                        httpURLConnection = httpURLConnection2;
                        inputStream = inputStream2;
                        th = th;
                        dataOutputStream = null;
                        try {
                            C2029al.m4643b(th);
                            String message = th.getMessage();
                            m4582a(dataOutputStream);
                            m4582a(inputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            string = message;
                        } catch (Throwable th2) {
                            m4582a(dataOutputStream);
                            m4582a(inputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnection2;
                    inputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
                dataOutputStream = null;
                httpURLConnection = httpURLConnection2;
                inputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            dataOutputStream = null;
        }
        return new Pair<>(Integer.valueOf(responseCode), string);
    }

    private static void m4583a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (httpURLConnection == null || map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private static void m4582a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e5) {
            C2029al.m4643b(e5);
        }
    }
}

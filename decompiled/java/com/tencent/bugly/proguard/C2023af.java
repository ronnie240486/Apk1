package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public final class C2023af {

    static C2023af f7264a;

    protected Context f7265b;

    public Map<String, String> f7266c = null;

    public C2023af(Context context) {
        this.f7265b = context;
    }

    private static byte[] m4593b(HttpURLConnection httpURLConnection) {
        BufferedInputStream bufferedInputStream;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int i6 = bufferedInputStream.read(bArr);
                    if (i6 <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i6);
                }
                byteArrayOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    bufferedInputStream.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                return byteArray;
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (!C2029al.m4641a(th)) {
                        th.printStackTrace();
                    }
                    return null;
                } finally {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = null;
        }
    }

    public final byte[] m4594a(String str, byte[] bArr, RunnableC2027aj runnableC2027aj, Map<String, String> map) {
        int i6;
        Throwable th;
        int i10 = 1;
        byte[] bArr2 = null;
        int i11 = 0;
        if (str == null) {
            C2029al.m4646e("Failed for no URL.", new Object[0]);
            return null;
        }
        long length = bArr == null ? 0L : bArr.length;
        C2029al.m4644c("request: %s, send: %d (pid=%d | tid=%d)", str, Long.valueOf(length), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        String str2 = str;
        int i12 = 0;
        int i13 = 0;
        boolean z7 = false;
        while (i12 <= 0 && i13 <= 0) {
            if (z7) {
                i6 = i12;
                z7 = false;
            } else {
                int i14 = i12 + i10;
                if (i14 > i10) {
                    C2029al.m4644c("try time: ".concat(String.valueOf(i14)), new Object[i11]);
                    SystemClock.sleep(((long) new Random(System.currentTimeMillis()).nextInt(10000)) + Renderer.DEFAULT_DURATION_TO_PROGRESS_US);
                }
                i6 = i14;
            }
            String strM4551c = C2019ab.m4551c(this.f7265b);
            if (strM4551c == null) {
                C2029al.m4645d("Failed to request for network not avail", new Object[i11]);
                length = length;
            } else {
                runnableC2027aj.m4629a(length);
                HttpURLConnection httpURLConnectionM4591a = m4591a(str2, bArr, strM4551c, map);
                if (httpURLConnectionM4591a != null) {
                    try {
                        try {
                            int responseCode = httpURLConnectionM4591a.getResponseCode();
                            C2029al.m4644c("response code ".concat(String.valueOf(responseCode)), new Object[i11]);
                            if (responseCode == 200) {
                                this.f7266c = m4592a(httpURLConnectionM4591a);
                                byte[] bArrM4593b = m4593b(httpURLConnectionM4591a);
                                runnableC2027aj.m4630b(bArrM4593b == null ? 0L : bArrM4593b.length);
                                try {
                                    httpURLConnectionM4591a.disconnect();
                                } catch (Throwable th2) {
                                    if (!C2029al.m4641a(th2)) {
                                        th2.printStackTrace();
                                    }
                                }
                                return bArrM4593b;
                            }
                            if (responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307) {
                                try {
                                    String headerField = httpURLConnectionM4591a.getHeaderField("Location");
                                    if (headerField == null) {
                                        C2029al.m4646e("Failed to redirect: %d".concat(String.valueOf(responseCode)), new Object[0]);
                                        try {
                                            httpURLConnectionM4591a.disconnect();
                                            return null;
                                        } catch (Throwable th3) {
                                            if (C2029al.m4641a(th3)) {
                                                return null;
                                            }
                                            th3.printStackTrace();
                                            return null;
                                        }
                                    }
                                    i13++;
                                    try {
                                        C2029al.m4644c("redirect code: %d ,to:%s", Integer.valueOf(responseCode), headerField);
                                        str2 = headerField;
                                        i6 = 0;
                                        z7 = true;
                                    } catch (IOException e5) {
                                        e = e5;
                                        str2 = headerField;
                                        i6 = 0;
                                        z7 = true;
                                    }
                                } catch (IOException e10) {
                                    e = e10;
                                }
                                z7 = true;
                            }
                            try {
                                length = length;
                                long contentLength = httpURLConnectionM4591a.getContentLength();
                                if (contentLength < 0) {
                                    contentLength = 0;
                                }
                                try {
                                    runnableC2027aj.m4630b(contentLength);
                                    try {
                                        httpURLConnectionM4591a.disconnect();
                                    } catch (Throwable th4) {
                                        th = th4;
                                        if (!C2029al.m4641a(th)) {
                                            th.printStackTrace();
                                        }
                                    }
                                } catch (IOException e11) {
                                    e = e11;
                                    if (!C2029al.m4641a(e)) {
                                        e.printStackTrace();
                                    }
                                    httpURLConnectionM4591a.disconnect();
                                }
                            } catch (IOException e12) {
                                e = e12;
                                length = length;
                            }
                        } catch (Throwable th5) {
                            try {
                                httpURLConnectionM4591a.disconnect();
                                throw th5;
                            } catch (Throwable th6) {
                                if (C2029al.m4641a(th6)) {
                                    throw th5;
                                }
                                th6.printStackTrace();
                                throw th5;
                            }
                        }
                    } catch (IOException e13) {
                        e = e13;
                        length = length;
                    }
                    if (!C2029al.m4641a(e)) {
                        e.printStackTrace();
                    }
                    try {
                        httpURLConnectionM4591a.disconnect();
                    } catch (Throwable th7) {
                        th = th7;
                        if (!C2029al.m4641a(th)) {
                            th.printStackTrace();
                        }
                    }
                } else {
                    length = length;
                    C2029al.m4644c("Failed to execute post.", new Object[0]);
                    runnableC2027aj.m4630b(0L);
                }
            }
            i12 = i6;
            length = length;
            i10 = 1;
            bArr2 = null;
            i11 = 0;
        }
        return bArr2;
    }

    private static Map<String, String> m4592a(HttpURLConnection httpURLConnection) {
        HashMap map = new HashMap();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null || headerFields.size() == 0) {
            return null;
        }
        for (String str : headerFields.keySet()) {
            List<String> list = headerFields.get(str);
            if (list.size() > 0) {
                map.put(str, list.get(0));
            }
        }
        return map;
    }

    private static HttpURLConnection m4591a(String str, byte[] bArr, String str2, Map<String, String> map) {
        if (str == null) {
            C2029al.m4646e("destUrl is null.", new Object[0]);
            return null;
        }
        HttpURLConnection httpURLConnectionM4590a = m4590a(str2, str);
        if (httpURLConnectionM4590a == null) {
            C2029al.m4646e("Failed to get HttpURLConnection object.", new Object[0]);
            return null;
        }
        try {
            httpURLConnectionM4590a.setRequestProperty("wup_version", "3.0");
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnectionM4590a.setRequestProperty(entry.getKey(), URLEncoder.encode(entry.getValue(), "utf-8"));
                }
            }
            httpURLConnectionM4590a.setRequestProperty("A37", URLEncoder.encode(str2, "utf-8"));
            httpURLConnectionM4590a.setRequestProperty("A38", URLEncoder.encode(str2, "utf-8"));
            OutputStream outputStream = httpURLConnectionM4590a.getOutputStream();
            if (bArr == null) {
                outputStream.write(0);
            } else {
                outputStream.write(bArr);
            }
            return httpURLConnectionM4590a;
        } catch (Throwable th) {
            if (!C2029al.m4641a(th)) {
                th.printStackTrace();
            }
            C2029al.m4646e("Failed to upload, please check your network.", new Object[0]);
            return null;
        }
    }

    private static HttpURLConnection m4590a(String str, String str2) {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(str2);
            Proxy proxy = C2031an.f7317a;
            if (proxy != null) {
                httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
            } else if (str != null && str.toLowerCase(Locale.US).contains("wap")) {
                httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(System.getProperty("http.proxyHost"), Integer.parseInt(System.getProperty("http.proxyPort")))));
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod(HlsMediaPlaylist.Interstitial.CUE_TRIGGER_POST);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(false);
            return httpURLConnection;
        } catch (Throwable th) {
            if (C2029al.m4641a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}

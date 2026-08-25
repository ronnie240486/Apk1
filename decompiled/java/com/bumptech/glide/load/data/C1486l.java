package com.bumptech.glide.load.data;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.EnumC1469g;
import com.google.android.gms.internal.cast.C1549e7;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import p016b3.C1278k;
import p055ea.AbstractC2460q;
import p186r3.AbstractC3604h;
import p186r3.C3599c;

public final class C1486l implements InterfaceC1479e {

    public final C1278k f4490a;

    public final int f4491b;

    public HttpURLConnection f4492c;

    public InputStream f4493d;

    public volatile boolean f4494e;

    public C1486l(C1278k c1278k, int i6) {
        this.f4490a = c1278k;
        this.f4491b = i6;
    }

    public static int m3555c(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e5) {
            if (!Log.isLoggable("HttpUrlFetcher", 3)) {
                return -1;
            }
            Log.d("HttpUrlFetcher", "Failed to get a response code", e5);
            return -1;
        }
    }

    @Override
    public final Class mo3151a() {
        return InputStream.class;
    }

    @Override
    public final void mo3152b() {
        InputStream inputStream = this.f4493d;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f4492c;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f4492c = null;
    }

    @Override
    public final void cancel() {
        this.f4494e = true;
    }

    @Override
    public final int mo3153d() {
        return 2;
    }

    public final InputStream m3556e(URL url, int i6, URL url2, Map map) throws C1549e7 {
        if (i6 >= 5) {
            throw new C1549e7("Too many (> 5) redirects!", -1, null);
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new C1549e7("In re-direct loop", -1, null);
                }
            } catch (URISyntaxException unused) {
            }
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            for (Map.Entry entry : map.entrySet()) {
                httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            int i10 = this.f4491b;
            httpURLConnection.setConnectTimeout(i10);
            httpURLConnection.setReadTimeout(i10);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setInstanceFollowRedirects(false);
            this.f4492c = httpURLConnection;
            try {
                httpURLConnection.connect();
                this.f4493d = this.f4492c.getInputStream();
                if (this.f4494e) {
                    return null;
                }
                int iM3555c = m3555c(this.f4492c);
                int i11 = iM3555c / 100;
                if (i11 == 2) {
                    HttpURLConnection httpURLConnection2 = this.f4492c;
                    try {
                        if (TextUtils.isEmpty(httpURLConnection2.getContentEncoding())) {
                            this.f4493d = new C3599c(httpURLConnection2.getInputStream(), httpURLConnection2.getContentLength());
                        } else {
                            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection2.getContentEncoding());
                            }
                            this.f4493d = httpURLConnection2.getInputStream();
                        }
                        return this.f4493d;
                    } catch (IOException e5) {
                        throw new C1549e7("Failed to obtain InputStream", m3555c(httpURLConnection2), e5);
                    }
                }
                if (i11 != 3) {
                    if (iM3555c == -1) {
                        throw new C1549e7("Http request failed", iM3555c, null);
                    }
                    try {
                        throw new C1549e7(this.f4492c.getResponseMessage(), iM3555c, null);
                    } catch (IOException e10) {
                        throw new C1549e7("Failed to get a response message", iM3555c, e10);
                    }
                }
                String headerField = this.f4492c.getHeaderField("Location");
                if (TextUtils.isEmpty(headerField)) {
                    throw new C1549e7("Received empty or null redirect url", iM3555c, null);
                }
                try {
                    URL url3 = new URL(url, headerField);
                    mo3152b();
                    return m3556e(url3, i6 + 1, url, map);
                } catch (MalformedURLException e11) {
                    throw new C1549e7(AbstractC2460q.m5501o("Bad redirect url: ", headerField), iM3555c, e11);
                }
            } catch (IOException e12) {
                throw new C1549e7("Failed to connect or obtain data", m3555c(this.f4492c), e12);
            }
        } catch (IOException e13) {
            throw new C1549e7("URL.openConnection threw", 0, e13);
        }
    }

    @Override
    public final void mo3154f(EnumC1469g enumC1469g, InterfaceC1478d interfaceC1478d) {
        StringBuilder sb;
        C1278k c1278k = this.f4490a;
        int i6 = AbstractC3604h.f12101b;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        try {
            if (c1278k.f4036f == null) {
                c1278k.f4036f = new URL(c1278k.m3162d());
            }
            interfaceC1478d.mo3173e(m3556e(c1278k.f4036f, 0, null, c1278k.f4032b.m3164b()));
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder("Finished http url fetcher fetch in ");
                sb.append(AbstractC3604h.m7226a(jElapsedRealtimeNanos));
                String string = sb.toString();
            }
        } catch (IOException e5) {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Failed to load data for url", e5);
            }
            interfaceC1478d.mo3172c(e5);
            if (!Log.isLoggable("HttpUrlFetcher", 2)) {
            } else {
                sb = new StringBuilder("Finished http url fetcher fetch in ");
            }
        } finally {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + AbstractC3604h.m7226a(jElapsedRealtimeNanos));
            }
        }
    }
}

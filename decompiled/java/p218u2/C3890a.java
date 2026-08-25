package p218u2;

import android.util.Log;
import com.bumptech.glide.EnumC1469g;
import com.bumptech.glide.load.data.InterfaceC1478d;
import com.bumptech.glide.load.data.InterfaceC1479e;
import com.google.android.gms.internal.cast.C1549e7;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import p016b3.C1278k;
import p186r3.AbstractC3602f;
import p186r3.C3599c;

public final class C3890a implements InterfaceC1479e, Callback {

    public final OkHttpClient f13076a;

    public final C1278k f13077b;

    public C3599c f13078c;

    public ResponseBody f13079d;

    public InterfaceC1478d f13080e;

    public volatile Call f13081f;

    public C3890a(OkHttpClient okHttpClient, C1278k c1278k) {
        this.f13076a = okHttpClient;
        this.f13077b = c1278k;
    }

    @Override
    public final Class mo3151a() {
        return InputStream.class;
    }

    @Override
    public final void mo3152b() {
        try {
            C3599c c3599c = this.f13078c;
            if (c3599c != null) {
                c3599c.close();
            }
        } catch (IOException unused) {
        }
        ResponseBody responseBody = this.f13079d;
        if (responseBody != null) {
            responseBody.close();
        }
        this.f13080e = null;
    }

    @Override
    public final void cancel() {
        Call call = this.f13081f;
        if (call != null) {
            call.cancel();
        }
    }

    @Override
    public final int mo3153d() {
        return 2;
    }

    @Override
    public final void mo3154f(EnumC1469g enumC1469g, InterfaceC1478d interfaceC1478d) {
        Request.Builder builderUrl = new Request.Builder().url(this.f13077b.m3162d());
        for (Map.Entry entry : this.f13077b.f4032b.m3164b().entrySet()) {
            builderUrl.addHeader((String) entry.getKey(), (String) entry.getValue());
        }
        Request requestBuild = builderUrl.build();
        this.f13080e = interfaceC1478d;
        this.f13081f = this.f13076a.newCall(requestBuild);
        this.f13081f.enqueue(this);
    }

    @Override
    public final void onFailure(Call call, IOException iOException) {
        if (Log.isLoggable("OkHttpFetcher", 3)) {
            Log.d("OkHttpFetcher", "OkHttp failed to obtain result", iOException);
        }
        this.f13080e.mo3172c(iOException);
    }

    @Override
    public final void onResponse(Call call, Response response) {
        this.f13079d = response.body();
        if (!response.isSuccessful()) {
            this.f13080e.mo3172c(new C1549e7(response.message(), response.code(), null));
            return;
        }
        ResponseBody responseBody = this.f13079d;
        AbstractC3602f.m7225c(responseBody, "Argument must not be null");
        C3599c c3599c = new C3599c(this.f13079d.byteStream(), responseBody.contentLength());
        this.f13078c = c3599c;
        this.f13080e.mo3173e(c3599c);
    }
}

package p185r2;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import p091i9.InterfaceC2724l;
import p156o9.AbstractC3280d;
import p213t9.C3827e;
import p243w8.C4070l;

public final class C3588g implements Callback, InterfaceC2724l {

    public final Call f12068a;

    public final C3827e f12069b;

    public C3588g(Call call, C3827e c3827e) {
        this.f12068a = call;
        this.f12069b = c3827e;
    }

    @Override
    public final Object invoke(Object obj) {
        try {
            this.f12068a.cancel();
        } catch (Throwable unused) {
        }
        return C4070l.f13734a;
    }

    @Override
    public final void onFailure(Call call, IOException iOException) {
        if (call.isCanceled()) {
            return;
        }
        this.f12069b.resumeWith(AbstractC3280d.m6588f(iOException));
    }

    @Override
    public final void onResponse(Call call, Response response) {
        this.f12069b.resumeWith(response);
    }
}

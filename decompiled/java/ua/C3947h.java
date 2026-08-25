package ua;

import android.os.Handler;
import android.os.Looper;
import p086i3.C2692h;

public final class C3947h {

    public static C3947h f13272b;

    public final Object f13273a;

    public C3947h(Object obj) {
        this.f13273a = obj;
    }

    public void m7876a() {
        synchronized (this.f13273a) {
        }
    }

    public C3947h() {
        this.f13273a = new Object();
        new Handler(Looper.getMainLooper(), new C2692h(1, this));
    }
}

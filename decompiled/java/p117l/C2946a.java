package p117l;

import android.os.Looper;
import p123l5.AbstractC2973a;

public final class C2946a extends AbstractC2973a {

    public static volatile C2946a f10114s;

    public final C2949d f10115r = new C2949d();

    public static C2946a m5967V() {
        if (f10114s != null) {
            return f10114s;
        }
        synchronized (C2946a.class) {
            try {
                if (f10114s == null) {
                    f10114s = new C2946a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f10114s;
    }

    public final void m5968W(Runnable runnable) {
        C2949d c2949d = this.f10115r;
        if (c2949d.f10120t == null) {
            synchronized (c2949d.f10118r) {
                try {
                    if (c2949d.f10120t == null) {
                        c2949d.f10120t = C2949d.m5970V(Looper.getMainLooper());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        c2949d.f10120t.post(runnable);
    }
}

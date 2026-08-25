package p123l5;

import android.content.Context;
import p005a4.C0052k;

public final class C2974b {

    public static final C2974b f10190b;

    public C0052k f10191a;

    static {
        C2974b c2974b = new C2974b();
        c2974b.f10191a = null;
        f10190b = c2974b;
    }

    public static C0052k m6025a(Context context) {
        C0052k c0052k;
        C2974b c2974b = f10190b;
        synchronized (c2974b) {
            try {
                if (c2974b.f10191a == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    c2974b.f10191a = new C0052k(context, 3);
                }
                c0052k = c2974b.f10191a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0052k;
    }
}

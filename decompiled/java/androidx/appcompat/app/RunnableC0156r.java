package androidx.appcompat.app;

import android.view.ViewGroup;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;
import p138n0.C3102a1;

public final class RunnableC0156r implements Runnable {

    public final int f425a;

    public final LayoutInflaterFactory2C0135g0 f426b;

    public RunnableC0156r(LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0, int i6) {
        this.f425a = i6;
        this.f426b = layoutInflaterFactory2C0135g0;
    }

    @Override
    public final void run() {
        boolean z7;
        ViewGroup viewGroup;
        LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0 = this.f426b;
        switch (this.f425a) {
            case 0:
                if ((1 & layoutInflaterFactory2C0135g0.f332b0) != 0) {
                    layoutInflaterFactory2C0135g0.m408v(0);
                }
                if ((layoutInflaterFactory2C0135g0.f332b0 & 4096) != 0) {
                    layoutInflaterFactory2C0135g0.m408v(108);
                }
                layoutInflaterFactory2C0135g0.f331Z = false;
                layoutInflaterFactory2C0135g0.f332b0 = 0;
                break;
            default:
                layoutInflaterFactory2C0135g0.f353w.showAtLocation(layoutInflaterFactory2C0135g0.f352v, 55, 0, 0);
                C3102a1 c3102a1 = layoutInflaterFactory2C0135g0.f355y;
                if (c3102a1 != null) {
                    c3102a1.m6122b();
                }
                if (layoutInflaterFactory2C0135g0.f306A && (viewGroup = layoutInflaterFactory2C0135g0.f307B) != null) {
                    WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                    z7 = viewGroup.isLaidOut();
                }
                if (!z7) {
                    layoutInflaterFactory2C0135g0.f352v.setAlpha(1.0f);
                    layoutInflaterFactory2C0135g0.f352v.setVisibility(0);
                } else {
                    layoutInflaterFactory2C0135g0.f352v.setAlpha(0.0f);
                    C3102a1 c3102a1M6331a = AbstractC3155s0.m6331a(layoutInflaterFactory2C0135g0.f352v);
                    c3102a1M6331a.m6121a(1.0f);
                    layoutInflaterFactory2C0135g0.f355y = c3102a1M6331a;
                    c3102a1M6331a.m6124d(new C0160t(0, this));
                }
                break;
        }
    }
}

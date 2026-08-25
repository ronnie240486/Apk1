package p138n0;

import android.view.WindowInsets;
import p056f0.C2480c;

public class C3132k1 extends C3129j1 {

    public C2480c f10621m;

    public C3132k1(C3153r1 c3153r1, WindowInsets windowInsets) {
        super(c3153r1, windowInsets);
        this.f10621m = null;
    }

    @Override
    public C3153r1 mo6236b() {
        return C3153r1.m6324h(this.f10615c.consumeStableInsets(), null);
    }

    @Override
    public C3153r1 mo6237c() {
        return C3153r1.m6324h(this.f10615c.consumeSystemWindowInsets(), null);
    }

    @Override
    public final C2480c mo6238i() {
        if (this.f10621m == null) {
            WindowInsets windowInsets = this.f10615c;
            this.f10621m = C2480c.m5515a(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.f10621m;
    }

    @Override
    public boolean mo6239n() {
        return this.f10615c.isConsumed();
    }

    @Override
    public void mo6240s(C2480c c2480c) {
        this.f10621m = c2480c;
    }

    public C3132k1(C3153r1 c3153r1, C3132k1 c3132k1) {
        super(c3153r1, c3132k1);
        this.f10621m = null;
        this.f10621m = c3132k1.f10621m;
    }
}

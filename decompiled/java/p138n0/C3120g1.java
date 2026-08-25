package p138n0;

import android.view.WindowInsets;
import p056f0.C2480c;

public class C3120g1 extends AbstractC3126i1 {

    public final WindowInsets.Builder f10601a;

    public C3120g1() {
        this.f10601a = AbstractC3117f1.m6139d();
    }

    @Override
    public C3153r1 mo6132b() {
        m6199a();
        C3153r1 c3153r1M6324h = C3153r1.m6324h(this.f10601a.build(), null);
        c3153r1M6324h.f10641a.mo6232p(null);
        return c3153r1M6324h;
    }

    @Override
    public void mo6133c(C2480c c2480c) {
        this.f10601a.setStableInsets(c2480c.m5517c());
    }

    @Override
    public void mo6134d(C2480c c2480c) {
        this.f10601a.setSystemWindowInsets(c2480c.m5517c());
    }

    public C3120g1(C3153r1 c3153r1) {
        WindowInsets.Builder builderM6139d;
        super(c3153r1);
        WindowInsets windowInsetsM6330g = c3153r1.m6330g();
        if (windowInsetsM6330g != null) {
            builderM6139d = AbstractC3117f1.m6140e(windowInsetsM6330g);
        } else {
            builderM6139d = AbstractC3117f1.m6139d();
        }
        this.f10601a = builderM6139d;
    }
}

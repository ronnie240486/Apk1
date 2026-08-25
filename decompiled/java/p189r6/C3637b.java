package p189r6;

import android.graphics.Typeface;
import p046e0.AbstractC2343b;
import p123l5.AbstractC2973a;

public final class C3637b extends AbstractC2343b {

    public final AbstractC2973a f12207h;

    public final C3639d f12208i;

    public C3637b(C3639d c3639d, AbstractC2973a abstractC2973a) {
        this.f12208i = c3639d;
        this.f12207h = abstractC2973a;
    }

    @Override
    public final void mo757i(int i6) {
        this.f12208i.f12225m = true;
        this.f12207h.mo4282D(i6);
    }

    @Override
    public final void mo758j(Typeface typeface) {
        C3639d c3639d = this.f12208i;
        c3639d.f12226n = Typeface.create(typeface, c3639d.f12215c);
        c3639d.f12225m = true;
        this.f12207h.mo4283E(c3639d.f12226n, false);
    }
}

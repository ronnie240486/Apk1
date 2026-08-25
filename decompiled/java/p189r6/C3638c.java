package p189r6;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import p123l5.AbstractC2973a;

public final class C3638c extends AbstractC2973a {

    public final Context f12209r;

    public final TextPaint f12210s;

    public final AbstractC2973a f12211t;

    public final C3639d f12212u;

    public C3638c(C3639d c3639d, Context context, TextPaint textPaint, AbstractC2973a abstractC2973a) {
        this.f12212u = c3639d;
        this.f12209r = context;
        this.f12210s = textPaint;
        this.f12211t = abstractC2973a;
    }

    @Override
    public final void mo4282D(int i6) {
        this.f12211t.mo4282D(i6);
    }

    @Override
    public final void mo4283E(Typeface typeface, boolean z7) {
        this.f12212u.m7369g(this.f12209r, this.f12210s, typeface);
        this.f12211t.mo4283E(typeface, z7);
    }
}

package p189r6;

import android.graphics.Typeface;
import com.google.android.material.internal.C1814c;
import p123l5.AbstractC2973a;

public final class C3636a extends AbstractC2973a {

    public final Typeface f12204r;

    public final C1814c f12205s;

    public boolean f12206t;

    public C3636a(C1814c c1814c, Typeface typeface) {
        this.f12204r = typeface;
        this.f12205s = c1814c;
    }

    @Override
    public final void mo4282D(int i6) {
        if (this.f12206t) {
            return;
        }
        this.f12205s.m4253a(this.f12204r);
    }

    @Override
    public final void mo4283E(Typeface typeface, boolean z7) {
        if (this.f12206t) {
            return;
        }
        this.f12205s.m4253a(typeface);
    }
}

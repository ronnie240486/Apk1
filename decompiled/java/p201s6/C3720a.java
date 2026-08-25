package p201s6;

import android.graphics.drawable.Drawable;
import p221u6.C3908h;

public final class C3720a extends Drawable.ConstantState {

    public C3908h f12472a;

    public boolean f12473b;

    public C3720a(C3720a c3720a) {
        this.f12472a = (C3908h) c3720a.f12472a.f13126a.newDrawable();
        this.f12473b = c3720a.f12473b;
    }

    @Override
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override
    public final Drawable newDrawable() {
        return new C3721b(new C3720a(this));
    }
}

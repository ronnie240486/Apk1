package p130m2;

import android.graphics.drawable.Drawable;
import p103j9.AbstractC2796i;

public final class C3057e extends AbstractC3062j {

    public final Drawable f10438a;

    public final C3061i f10439b;

    public final Throwable f10440c;

    public C3057e(Drawable drawable, C3061i c3061i, Throwable th) {
        this.f10438a = drawable;
        this.f10439b = c3061i;
        this.f10440c = th;
    }

    @Override
    public final Drawable mo6107a() {
        return this.f10438a;
    }

    @Override
    public final C3061i mo6108b() {
        return this.f10439b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C3057e) {
            C3057e c3057e = (C3057e) obj;
            if (AbstractC2796i.m5780a(this.f10438a, c3057e.f10438a)) {
                if (AbstractC2796i.m5780a(this.f10439b, c3057e.f10439b) && AbstractC2796i.m5780a(this.f10440c, c3057e.f10440c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Drawable drawable = this.f10438a;
        return this.f10440c.hashCode() + ((this.f10439b.hashCode() + ((drawable != null ? drawable.hashCode() : 0) * 31)) * 31);
    }
}

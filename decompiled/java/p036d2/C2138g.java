package p036d2;

import android.graphics.drawable.BitmapDrawable;

public final class C2138g {

    public final BitmapDrawable f7765a;

    public final boolean f7766b;

    public C2138g(BitmapDrawable bitmapDrawable, boolean z7) {
        this.f7765a = bitmapDrawable;
        this.f7766b = z7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2138g) {
            C2138g c2138g = (C2138g) obj;
            if (this.f7765a.equals(c2138g.f7765a) && this.f7766b == c2138g.f7766b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f7765a.hashCode() * 31) + (this.f7766b ? 1231 : 1237);
    }
}

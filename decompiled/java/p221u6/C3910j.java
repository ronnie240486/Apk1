package p221u6;

import android.graphics.RectF;
import java.util.Arrays;

public final class C3910j implements InterfaceC3903c {

    public final float f13150a;

    public C3910j(float f) {
        this.f13150a = f;
    }

    @Override
    public final float mo7794a(RectF rectF) {
        return rectF.height() * this.f13150a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C3910j) && this.f13150a == ((C3910j) obj).f13150a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f13150a)});
    }
}

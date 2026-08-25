package p221u6;

import android.graphics.RectF;
import java.util.Arrays;

public final class C3902b implements InterfaceC3903c {

    public final InterfaceC3903c f13102a;

    public final float f13103b;

    public C3902b(float f, InterfaceC3903c interfaceC3903c) {
        while (interfaceC3903c instanceof C3902b) {
            interfaceC3903c = ((C3902b) interfaceC3903c).f13102a;
            f += ((C3902b) interfaceC3903c).f13103b;
        }
        this.f13102a = interfaceC3903c;
        this.f13103b = f;
    }

    @Override
    public final float mo7794a(RectF rectF) {
        return Math.max(0.0f, this.f13102a.mo7794a(rectF) + this.f13103b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3902b)) {
            return false;
        }
        C3902b c3902b = (C3902b) obj;
        return this.f13102a.equals(c3902b.f13102a) && this.f13103b == c3902b.f13103b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f13102a, Float.valueOf(this.f13103b)});
    }
}

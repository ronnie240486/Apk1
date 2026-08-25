package p221u6;

import android.graphics.RectF;
import java.util.Arrays;

public final class C3901a implements InterfaceC3903c {

    public final float f13101a;

    public C3901a(float f) {
        this.f13101a = f;
    }

    @Override
    public final float mo7794a(RectF rectF) {
        return this.f13101a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C3901a) && this.f13101a == ((C3901a) obj).f13101a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f13101a)});
    }
}

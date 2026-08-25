package p138n0;

import android.view.DisplayCutout;
import java.util.Objects;

public final class C3130k {

    public final DisplayCutout f10620a;

    public C3130k(DisplayCutout displayCutout) {
        this.f10620a = displayCutout;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C3130k.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f10620a, ((C3130k) obj).f10620a);
    }

    public final int hashCode() {
        return this.f10620a.hashCode();
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f10620a + "}";
    }
}

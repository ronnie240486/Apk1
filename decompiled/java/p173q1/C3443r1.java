package p173q1;

import android.text.TextUtils;
import java.util.Objects;

public final class C3443r1 {

    public final String f11648a;

    public final int f11649b;

    public C3443r1(C3440q1 c3440q1) {
        this.f11648a = c3440q1.f11640b;
        this.f11649b = c3440q1.f11639a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3443r1)) {
            return false;
        }
        C3443r1 c3443r1 = (C3443r1) obj;
        return this.f11648a.equals(c3443r1.f11648a) && this.f11649b == c3443r1.f11649b && TextUtils.equals(null, null);
    }

    public final int hashCode() {
        return Objects.hash(this.f11648a, Integer.valueOf(this.f11649b), 0, 0, null);
    }
}

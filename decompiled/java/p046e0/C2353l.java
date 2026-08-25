package p046e0;

import android.content.res.Resources;
import java.util.Objects;

public final class C2353l {

    public final Resources f8207a;

    public final Resources.Theme f8208b;

    public C2353l(Resources resources, Resources.Theme theme) {
        this.f8207a = resources;
        this.f8208b = theme;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2353l.class != obj.getClass()) {
            return false;
        }
        C2353l c2353l = (C2353l) obj;
        return this.f8207a.equals(c2353l.f8207a) && Objects.equals(this.f8208b, c2353l.f8208b);
    }

    public final int hashCode() {
        return Objects.hash(this.f8207a, this.f8208b);
    }
}

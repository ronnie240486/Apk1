package p129m1;

import android.text.TextUtils;
import java.util.Objects;

public class C3047s {

    public final String f10401a;

    public final int f10402b;

    public final int f10403c;

    public C3047s(String str, int i6, int i10) {
        this.f10401a = str;
        this.f10402b = i6;
        this.f10403c = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3047s)) {
            return false;
        }
        C3047s c3047s = (C3047s) obj;
        int i6 = this.f10403c;
        String str = this.f10401a;
        int i10 = this.f10402b;
        if (i10 < 0 || c3047s.f10402b < 0) {
            return TextUtils.equals(str, c3047s.f10401a) && i6 == c3047s.f10403c;
        }
        return TextUtils.equals(str, c3047s.f10401a) && i10 == c3047s.f10402b && i6 == c3047s.f10403c;
    }

    public final int hashCode() {
        return Objects.hash(this.f10401a, Integer.valueOf(this.f10403c));
    }
}

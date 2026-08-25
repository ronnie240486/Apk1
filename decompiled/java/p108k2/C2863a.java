package p108k2;

import android.graphics.Bitmap;
import java.util.Map;
import p103j9.AbstractC2796i;

public final class C2863a {

    public final Bitmap f9790a;

    public final Map f9791b;

    public C2863a(Bitmap bitmap, Map map) {
        this.f9790a = bitmap;
        this.f9791b = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2863a) {
            C2863a c2863a = (C2863a) obj;
            if (AbstractC2796i.m5780a(this.f9790a, c2863a.f9790a) && AbstractC2796i.m5780a(this.f9791b, c2863a.f9791b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f9791b.hashCode() + (this.f9790a.hashCode() * 31);
    }

    public final String toString() {
        return "Value(bitmap=" + this.f9790a + ", extras=" + this.f9791b + ')';
    }
}

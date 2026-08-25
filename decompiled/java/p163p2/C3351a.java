package p163p2;

public final class C3351a {

    public final float f11339a;

    public final float f11340b;

    public final float f11341c;

    public final float f11342d;

    public final String f11343e;

    public C3351a(float f) {
        this.f11339a = f;
        this.f11340b = f;
        this.f11341c = f;
        this.f11342d = f;
        if (f < 0.0f || f < 0.0f || f < 0.0f || f < 0.0f) {
            throw new IllegalArgumentException("All radii must be >= 0.");
        }
        this.f11343e = C3351a.class.getName() + '-' + f + ',' + f + ',' + f + ',' + f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C3351a) {
            C3351a c3351a = (C3351a) obj;
            if (this.f11339a == c3351a.f11339a && this.f11340b == c3351a.f11340b && this.f11341c == c3351a.f11341c && this.f11342d == c3351a.f11342d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f11342d) + ((Float.floatToIntBits(this.f11341c) + ((Float.floatToIntBits(this.f11340b) + (Float.floatToIntBits(this.f11339a) * 31)) * 31)) * 31);
    }
}

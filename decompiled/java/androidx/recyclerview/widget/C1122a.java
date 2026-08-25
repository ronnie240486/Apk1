package androidx.recyclerview.widget;

public final class C1122a {

    public int f3510a;

    public int f3511b;

    public Object f3512c;

    public int f3513d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1122a)) {
            return false;
        }
        C1122a c1122a = (C1122a) obj;
        int i6 = this.f3510a;
        if (i6 != c1122a.f3510a) {
            return false;
        }
        if (i6 == 8 && Math.abs(this.f3513d - this.f3511b) == 1 && this.f3513d == c1122a.f3511b && this.f3511b == c1122a.f3513d) {
            return true;
        }
        if (this.f3513d != c1122a.f3513d || this.f3511b != c1122a.f3511b) {
            return false;
        }
        Object obj2 = this.f3512c;
        if (obj2 != null) {
            if (!obj2.equals(c1122a.f3512c)) {
                return false;
            }
        } else if (c1122a.f3512c != null) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (((this.f3510a * 31) + this.f3511b) * 31) + this.f3513d;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[");
        int i6 = this.f3510a;
        if (i6 == 1) {
            str = "add";
        } else if (i6 == 2) {
            str = "rm";
        } else if (i6 != 4) {
            str = i6 != 8 ? "??" : "mv";
        } else {
            str = "up";
        }
        sb.append(str);
        sb.append(",s:");
        sb.append(this.f3511b);
        sb.append("c:");
        sb.append(this.f3513d);
        sb.append(",p:");
        sb.append(this.f3512c);
        sb.append("]");
        return sb.toString();
    }
}

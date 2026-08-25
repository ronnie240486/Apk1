package p056f0;

import android.graphics.Insets;

public final class C2480c {

    public static final C2480c f8680e = new C2480c(0, 0, 0, 0);

    public final int f8681a;

    public final int f8682b;

    public final int f8683c;

    public final int f8684d;

    public C2480c(int i6, int i10, int i11, int i12) {
        this.f8681a = i6;
        this.f8682b = i10;
        this.f8683c = i11;
        this.f8684d = i12;
    }

    public static C2480c m5515a(int i6, int i10, int i11, int i12) {
        return (i6 == 0 && i10 == 0 && i11 == 0 && i12 == 0) ? f8680e : new C2480c(i6, i10, i11, i12);
    }

    public static C2480c m5516b(Insets insets) {
        return m5515a(insets.left, insets.top, insets.right, insets.bottom);
    }

    public final Insets m5517c() {
        return AbstractC2479b.m5514a(this.f8681a, this.f8682b, this.f8683c, this.f8684d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2480c.class != obj.getClass()) {
            return false;
        }
        C2480c c2480c = (C2480c) obj;
        return this.f8684d == c2480c.f8684d && this.f8681a == c2480c.f8681a && this.f8683c == c2480c.f8683c && this.f8682b == c2480c.f8682b;
    }

    public final int hashCode() {
        return (((((this.f8681a * 31) + this.f8682b) * 31) + this.f8683c) * 31) + this.f8684d;
    }

    public final String toString() {
        return "Insets{left=" + this.f8681a + ", top=" + this.f8682b + ", right=" + this.f8683c + ", bottom=" + this.f8684d + '}';
    }
}

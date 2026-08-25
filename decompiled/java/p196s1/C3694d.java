package p196s1;

import android.graphics.Color;
import java.util.Arrays;
import p056f0.AbstractC2478a;

public final class C3694d {

    public final int f12360a;

    public final int f12361b;

    public final int f12362c;

    public final int f12363d;

    public final int f12364e;

    public boolean f12365f;

    public int f12366g;

    public int f12367h;

    public float[] f12368i;

    public C3694d(int i6, int i10) {
        this.f12360a = Color.red(i6);
        this.f12361b = Color.green(i6);
        this.f12362c = Color.blue(i6);
        this.f12363d = i6;
        this.f12364e = i10;
    }

    public final void m7447a() {
        if (this.f12365f) {
            return;
        }
        int i6 = this.f12363d;
        int iM5510e = AbstractC2478a.m5510e(4.5f, -1, i6);
        int iM5510e2 = AbstractC2478a.m5510e(3.0f, -1, i6);
        if (iM5510e != -1 && iM5510e2 != -1) {
            this.f12367h = AbstractC2478a.m5513h(-1, iM5510e);
            this.f12366g = AbstractC2478a.m5513h(-1, iM5510e2);
            this.f12365f = true;
            return;
        }
        int iM5510e3 = AbstractC2478a.m5510e(4.5f, -16777216, i6);
        int iM5510e4 = AbstractC2478a.m5510e(3.0f, -16777216, i6);
        if (iM5510e3 == -1 || iM5510e4 == -1) {
            this.f12367h = iM5510e != -1 ? AbstractC2478a.m5513h(-1, iM5510e) : AbstractC2478a.m5513h(-16777216, iM5510e3);
            this.f12366g = iM5510e2 != -1 ? AbstractC2478a.m5513h(-1, iM5510e2) : AbstractC2478a.m5513h(-16777216, iM5510e4);
            this.f12365f = true;
        } else {
            this.f12367h = AbstractC2478a.m5513h(-16777216, iM5510e3);
            this.f12366g = AbstractC2478a.m5513h(-16777216, iM5510e4);
            this.f12365f = true;
        }
    }

    public final float[] m7448b() {
        if (this.f12368i == null) {
            this.f12368i = new float[3];
        }
        AbstractC2478a.m5506a(this.f12360a, this.f12361b, this.f12362c, this.f12368i);
        return this.f12368i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C3694d.class != obj.getClass()) {
            return false;
        }
        C3694d c3694d = (C3694d) obj;
        return this.f12364e == c3694d.f12364e && this.f12363d == c3694d.f12363d;
    }

    public final int hashCode() {
        return (this.f12363d * 31) + this.f12364e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C3694d.class.getSimpleName());
        sb.append(" [RGB: #");
        sb.append(Integer.toHexString(this.f12363d));
        sb.append("] [HSL: ");
        sb.append(Arrays.toString(m7448b()));
        sb.append("] [Population: ");
        sb.append(this.f12364e);
        sb.append("] [Title Text: #");
        m7447a();
        sb.append(Integer.toHexString(this.f12366g));
        sb.append("] [Body Text: #");
        m7447a();
        sb.append(Integer.toHexString(this.f12367h));
        sb.append(']');
        return sb.toString();
    }
}

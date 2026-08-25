package p221u6;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;

public final class C3923w {

    public float f13206a;

    public float f13207b;

    public float f13208c;

    public float f13209d;

    public float f13210e;

    public float f13211f;

    public final ArrayList f13212g = new ArrayList();

    public final ArrayList f13213h = new ArrayList();

    public C3923w() {
        m7836e(0.0f, 0.0f, 270.0f, 0.0f);
    }

    public final void m7832a(float f, float f3, float f4, float f5, float f10, float f11) {
        C3919s c3919s = new C3919s(f, f3, f4, f5);
        c3919s.f13200f = f10;
        c3919s.f13201g = f11;
        this.f13212g.add(c3919s);
        C3917q c3917q = new C3917q(c3919s);
        float f12 = f10 + f11;
        boolean z7 = f11 < 0.0f;
        if (z7) {
            f10 = (f10 + 180.0f) % 360.0f;
        }
        float f13 = z7 ? (180.0f + f12) % 360.0f : f12;
        m7833b(f10);
        this.f13213h.add(c3917q);
        this.f13210e = f13;
        double d = f12;
        this.f13208c = (((f4 - f) / 2.0f) * ((float) Math.cos(Math.toRadians(d)))) + ((f + f4) * 0.5f);
        this.f13209d = (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d)))) + ((f3 + f5) * 0.5f);
    }

    public final void m7833b(float f) {
        float f3 = this.f13210e;
        if (f3 == f) {
            return;
        }
        float f4 = ((f - f3) + 360.0f) % 360.0f;
        if (f4 > 180.0f) {
            return;
        }
        float f5 = this.f13208c;
        float f10 = this.f13209d;
        C3919s c3919s = new C3919s(f5, f10, f5, f10);
        c3919s.f13200f = this.f13210e;
        c3919s.f13201g = f4;
        this.f13213h.add(new C3917q(c3919s));
        this.f13210e = f;
    }

    public final void m7834c(Matrix matrix, Path path) {
        ArrayList arrayList = this.f13212g;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((AbstractC3921u) arrayList.get(i6)).mo7831a(matrix, path);
        }
    }

    public final void m7835d(float f, float f3) {
        C3920t c3920t = new C3920t();
        c3920t.f13202b = f;
        c3920t.f13203c = f3;
        this.f13212g.add(c3920t);
        C3918r c3918r = new C3918r(c3920t, this.f13208c, this.f13209d);
        float fM7830b = c3918r.m7830b() + 270.0f;
        float fM7830b2 = c3918r.m7830b() + 270.0f;
        m7833b(fM7830b);
        this.f13213h.add(c3918r);
        this.f13210e = fM7830b2;
        this.f13208c = f;
        this.f13209d = f3;
    }

    public final void m7836e(float f, float f3, float f4, float f5) {
        this.f13206a = f;
        this.f13207b = f3;
        this.f13208c = f;
        this.f13209d = f3;
        this.f13210e = f4;
        this.f13211f = (f4 + f5) % 360.0f;
        this.f13212g.clear();
        this.f13213h.clear();
    }
}

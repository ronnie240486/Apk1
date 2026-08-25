package p002a1;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import java.util.ArrayList;
import p000a.AbstractC0004e;
import p178q6.C3512i;
import p178q6.C3513j;

public final class C0030f {

    public static final C0028d f65n = new C0028d();

    public static final C0028d f66o = new C0028d();

    public static final C0028d f67p = new C0028d();

    public static final C0028d f68q = new C0028d();

    public static final C0028d f69r = new C0028d();

    public static final C0028d f70s = new C0028d();

    public float f71a;

    public float f72b;

    public boolean f73c;

    public final C3513j f74d;

    public final C3512i f75e;

    public boolean f76f;

    public long f77g;

    public final float f78h;

    public final ArrayList f79i;

    public final ArrayList f80j;

    public C0031g f81k;

    public float f82l;

    public boolean f83m;

    public C0030f(C3513j c3513j) {
        C3512i c3512i = C3513j.f11834q;
        this.f71a = 0.0f;
        this.f72b = Float.MAX_VALUE;
        this.f73c = false;
        this.f76f = false;
        this.f77g = 0L;
        this.f79i = new ArrayList();
        this.f80j = new ArrayList();
        this.f74d = c3513j;
        this.f75e = c3512i;
        if (c3512i == f67p || c3512i == f68q || c3512i == f69r) {
            this.f78h = 0.1f;
        } else if (c3512i == f70s || c3512i == f65n || c3512i == f66o) {
            this.f78h = 0.00390625f;
        } else {
            this.f78h = 1.0f;
        }
        this.f81k = null;
        this.f82l = Float.MAX_VALUE;
        this.f83m = false;
    }

    public final void m146a(float f) {
        this.f75e.getClass();
        C3513j c3513j = this.f74d;
        c3513j.f11838o = f / 10000.0f;
        c3513j.invalidateSelf();
        int i6 = 0;
        while (true) {
            ArrayList arrayList = this.f80j;
            if (i6 >= arrayList.size()) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (arrayList.get(size) == null) {
                        arrayList.remove(size);
                    }
                }
                return;
            }
            if (arrayList.get(i6) != null) {
                throw AbstractC0004e.m17k(i6, arrayList);
            }
            i6++;
        }
    }

    public final void m147b() {
        if (this.f81k.f85b <= 0.0d) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f76f) {
            this.f83m = true;
        }
    }
}

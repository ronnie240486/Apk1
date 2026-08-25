package p138n0;

import android.os.Build;
import android.view.View;
import java.util.Objects;
import p056f0.C2480c;

public class C3144o1 {

    public static final C3153r1 f10631b;

    public final C3153r1 f10632a;

    static {
        AbstractC3126i1 c3120g1;
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 30) {
            c3120g1 = new C3123h1();
        } else {
            c3120g1 = i6 >= 29 ? new C3120g1() : new C3114e1();
        }
        f10631b = c3120g1.mo6132b().f10641a.mo6251a().f10641a.mo6236b().f10641a.mo6237c();
    }

    public C3144o1(C3153r1 c3153r1) {
        this.f10632a = c3153r1;
    }

    public C3153r1 mo6251a() {
        return this.f10632a;
    }

    public C3153r1 mo6236b() {
        return this.f10632a;
    }

    public C3153r1 mo6237c() {
        return this.f10632a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3144o1)) {
            return false;
        }
        C3144o1 c3144o1 = (C3144o1) obj;
        return mo6231o() == c3144o1.mo6231o() && mo6239n() == c3144o1.mo6239n() && Objects.equals(mo6229k(), c3144o1.mo6229k()) && Objects.equals(mo6238i(), c3144o1.mo6238i()) && Objects.equals(mo6252f(), c3144o1.mo6252f());
    }

    public C3130k mo6252f() {
        return null;
    }

    public C2480c mo6228g(int i6) {
        return C2480c.f8680e;
    }

    public C2480c mo6272h() {
        return mo6229k();
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(mo6231o()), Boolean.valueOf(mo6239n()), mo6229k(), mo6238i(), mo6252f());
    }

    public C2480c mo6238i() {
        return C2480c.f8680e;
    }

    public C2480c mo6273j() {
        return mo6229k();
    }

    public C2480c mo6229k() {
        return C2480c.f8680e;
    }

    public C2480c mo6274l() {
        return mo6229k();
    }

    public C3153r1 mo6230m(int i6, int i10, int i11, int i12) {
        return f10631b;
    }

    public boolean mo6239n() {
        return false;
    }

    public boolean mo6231o() {
        return false;
    }

    public void mo6226d(View view) {
    }

    public void mo6227e(C3153r1 c3153r1) {
    }

    public void mo6232p(C2480c[] c2480cArr) {
    }

    public void mo6233q(C2480c c2480c) {
    }

    public void mo6234r(C3153r1 c3153r1) {
    }

    public void mo6240s(C2480c c2480c) {
    }
}

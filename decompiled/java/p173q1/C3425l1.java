package p173q1;

import android.content.Intent;
import android.os.Bundle;

public final class C3425l1 extends AbstractC3397c0 implements InterfaceC3416i1 {

    public final String f11570a;

    public final String f11571b;

    public final C3400d0 f11572c;

    public boolean f11573d;

    public int f11574e = -1;

    public int f11575f;

    public C3413h1 f11576g;

    public int f11577h;

    public final ServiceConnectionC3428m1 f11578i;

    public C3425l1(ServiceConnectionC3428m1 serviceConnectionC3428m1, String str, String str2, C3400d0 c3400d0) {
        this.f11578i = serviceConnectionC3428m1;
        this.f11570a = str;
        this.f11571b = str2;
        this.f11572c = c3400d0;
    }

    @Override
    public final int mo6961a() {
        return this.f11577h;
    }

    @Override
    public final void mo6962b(C3413h1 c3413h1) {
        this.f11576g = c3413h1;
        int i6 = c3413h1.f11520e;
        c3413h1.f11520e = i6 + 1;
        Bundle bundle = new Bundle();
        bundle.putString("routeId", this.f11570a);
        bundle.putString("routeGroupId", this.f11571b);
        bundle.putParcelable("routeControllerOptions", this.f11572c.f11444a);
        int i10 = c3413h1.f11519d;
        c3413h1.f11519d = i10 + 1;
        c3413h1.m6955b(3, i10, i6, null, bundle);
        this.f11577h = i6;
        if (this.f11573d) {
            c3413h1.m6954a(i6);
            int i11 = this.f11574e;
            if (i11 >= 0) {
                c3413h1.m6956c(this.f11577h, i11);
                this.f11574e = -1;
            }
            int i12 = this.f11575f;
            if (i12 != 0) {
                c3413h1.m6957d(this.f11577h, i12);
                this.f11575f = 0;
            }
        }
    }

    @Override
    public final void mo6963c() {
        C3413h1 c3413h1 = this.f11576g;
        if (c3413h1 != null) {
            int i6 = this.f11577h;
            int i10 = c3413h1.f11519d;
            c3413h1.f11519d = i10 + 1;
            c3413h1.m6955b(4, i10, i6, null, null);
            this.f11576g = null;
            this.f11577h = 0;
        }
    }

    @Override
    public final boolean mo6896d(Intent intent, AbstractC3433o0 abstractC3433o0) {
        C3413h1 c3413h1 = this.f11576g;
        if (c3413h1 == null) {
            return false;
        }
        int i6 = this.f11577h;
        int i10 = c3413h1.f11519d;
        c3413h1.f11519d = i10 + 1;
        if (!c3413h1.m6955b(9, i10, i6, intent, null)) {
            return false;
        }
        if (abstractC3433o0 != null) {
            c3413h1.f11523h.put(i10, abstractC3433o0);
        }
        return true;
    }

    @Override
    public final void mo6897e() {
        ServiceConnectionC3428m1 serviceConnectionC3428m1 = this.f11578i;
        serviceConnectionC3428m1.f11584k.remove(this);
        mo6963c();
        serviceConnectionC3428m1.m7007l();
    }

    @Override
    public final void mo6898f() {
        this.f11573d = true;
        C3413h1 c3413h1 = this.f11576g;
        if (c3413h1 != null) {
            c3413h1.m6954a(this.f11577h);
        }
    }

    @Override
    public final void mo6894g(int i6) {
        C3413h1 c3413h1 = this.f11576g;
        if (c3413h1 != null) {
            c3413h1.m6956c(this.f11577h, i6);
        } else {
            this.f11574e = i6;
            this.f11575f = 0;
        }
    }

    @Override
    public final void mo6899h() {
        mo6900i(0);
    }

    @Override
    public final void mo6900i(int i6) {
        this.f11573d = false;
        C3413h1 c3413h1 = this.f11576g;
        if (c3413h1 != null) {
            int i10 = this.f11577h;
            Bundle bundle = new Bundle();
            bundle.putInt("unselectReason", i6);
            int i11 = c3413h1.f11519d;
            c3413h1.f11519d = i11 + 1;
            c3413h1.m6955b(6, i11, i10, null, bundle);
        }
    }

    @Override
    public final void mo6895j(int i6) {
        C3413h1 c3413h1 = this.f11576g;
        if (c3413h1 != null) {
            c3413h1.m6957d(this.f11577h, i6);
        } else {
            this.f11575f += i6;
        }
    }
}

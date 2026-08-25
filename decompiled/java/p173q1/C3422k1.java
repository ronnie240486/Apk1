package p173q1;

import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public final class C3422k1 extends AbstractC3394b0 implements InterfaceC3416i1 {

    public final String f11546f;

    public final C3400d0 f11547g;

    public String f11548h;

    public String f11549i;

    public boolean f11550j;

    public int f11552l;

    public C3413h1 f11553m;

    public final ServiceConnectionC3428m1 f11555o;

    public int f11551k = -1;

    public int f11554n = -1;

    public C3422k1(ServiceConnectionC3428m1 serviceConnectionC3428m1, String str, C3400d0 c3400d0) {
        this.f11555o = serviceConnectionC3428m1;
        this.f11546f = str;
        this.f11547g = c3400d0;
    }

    @Override
    public final int mo6961a() {
        return this.f11554n;
    }

    @Override
    public final void mo6962b(C3413h1 c3413h1) {
        C3419j1 c3419j1 = new C3419j1(this);
        this.f11553m = c3413h1;
        int i6 = c3413h1.f11520e;
        c3413h1.f11520e = i6 + 1;
        int i10 = c3413h1.f11519d;
        c3413h1.f11519d = i10 + 1;
        Bundle bundle = new Bundle();
        bundle.putString("memberRouteId", this.f11546f);
        bundle.putParcelable("routeControllerOptions", this.f11547g.f11444a);
        c3413h1.m6955b(11, i10, i6, null, bundle);
        c3413h1.f11523h.put(i10, c3419j1);
        this.f11554n = i6;
        if (this.f11550j) {
            c3413h1.m6954a(i6);
            int i11 = this.f11551k;
            if (i11 >= 0) {
                c3413h1.m6956c(this.f11554n, i11);
                this.f11551k = -1;
            }
            int i12 = this.f11552l;
            if (i12 != 0) {
                c3413h1.m6957d(this.f11554n, i12);
                this.f11552l = 0;
            }
        }
    }

    @Override
    public final void mo6963c() {
        C3413h1 c3413h1 = this.f11553m;
        if (c3413h1 != null) {
            int i6 = this.f11554n;
            int i10 = c3413h1.f11519d;
            c3413h1.f11519d = i10 + 1;
            c3413h1.m6955b(4, i10, i6, null, null);
            this.f11553m = null;
            this.f11554n = 0;
        }
    }

    @Override
    public final boolean mo6896d(Intent intent, AbstractC3433o0 abstractC3433o0) {
        C3413h1 c3413h1 = this.f11553m;
        if (c3413h1 == null) {
            return false;
        }
        int i6 = this.f11554n;
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
        ServiceConnectionC3428m1 serviceConnectionC3428m1 = this.f11555o;
        serviceConnectionC3428m1.f11584k.remove(this);
        mo6963c();
        serviceConnectionC3428m1.m7007l();
    }

    @Override
    public final void mo6898f() {
        this.f11550j = true;
        C3413h1 c3413h1 = this.f11553m;
        if (c3413h1 != null) {
            c3413h1.m6954a(this.f11554n);
        }
    }

    @Override
    public final void mo6894g(int i6) {
        C3413h1 c3413h1 = this.f11553m;
        if (c3413h1 != null) {
            c3413h1.m6956c(this.f11554n, i6);
        } else {
            this.f11551k = i6;
            this.f11552l = 0;
        }
    }

    @Override
    public final void mo6899h() {
        mo6900i(0);
    }

    @Override
    public final void mo6900i(int i6) {
        this.f11550j = false;
        C3413h1 c3413h1 = this.f11553m;
        if (c3413h1 != null) {
            int i10 = this.f11554n;
            Bundle bundle = new Bundle();
            bundle.putInt("unselectReason", i6);
            int i11 = c3413h1.f11519d;
            c3413h1.f11519d = i11 + 1;
            c3413h1.m6955b(6, i11, i10, null, bundle);
        }
    }

    @Override
    public final void mo6895j(int i6) {
        C3413h1 c3413h1 = this.f11553m;
        if (c3413h1 != null) {
            c3413h1.m6957d(this.f11554n, i6);
        } else {
            this.f11552l += i6;
        }
    }

    @Override
    public final String mo6887k() {
        return this.f11548h;
    }

    @Override
    public final String mo6888l() {
        return this.f11549i;
    }

    @Override
    public final void mo6890n(String str) {
        C3413h1 c3413h1 = this.f11553m;
        if (c3413h1 != null) {
            int i6 = this.f11554n;
            c3413h1.getClass();
            Bundle bundle = new Bundle();
            bundle.putString("memberRouteId", str);
            int i10 = c3413h1.f11519d;
            c3413h1.f11519d = i10 + 1;
            c3413h1.m6955b(12, i10, i6, null, bundle);
        }
    }

    @Override
    public final void mo6891o(String str) {
        C3413h1 c3413h1 = this.f11553m;
        if (c3413h1 != null) {
            int i6 = this.f11554n;
            c3413h1.getClass();
            Bundle bundle = new Bundle();
            bundle.putString("memberRouteId", str);
            int i10 = c3413h1.f11519d;
            c3413h1.f11519d = i10 + 1;
            c3413h1.m6955b(13, i10, i6, null, bundle);
        }
    }

    @Override
    public final void mo6892p(List list) {
        C3413h1 c3413h1 = this.f11553m;
        if (c3413h1 != null) {
            int i6 = this.f11554n;
            c3413h1.getClass();
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("memberRouteIds", new ArrayList<>(list));
            int i10 = c3413h1.f11519d;
            c3413h1.f11519d = i10 + 1;
            c3413h1.m6955b(14, i10, i6, null, bundle);
        }
    }
}

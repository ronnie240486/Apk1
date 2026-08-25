package androidx.recyclerview.widget;

import android.view.View;

public final class C1193w {

    public AbstractC1135d0 f3719a;

    public int f3720b;

    public int f3721c;

    public boolean f3722d;

    public boolean f3723e;

    public C1193w() {
        m2998d();
    }

    public final void m2995a() {
        this.f3721c = this.f3722d ? this.f3719a.mo2888g() : this.f3719a.mo2892k();
    }

    public final void m2996b(int i6, View view) {
        if (this.f3722d) {
            this.f3721c = this.f3719a.m2922m() + this.f3719a.mo2883b(view);
        } else {
            this.f3721c = this.f3719a.mo2886e(view);
        }
        this.f3720b = i6;
    }

    public final void m2997c(int i6, View view) {
        int iM2922m = this.f3719a.m2922m();
        if (iM2922m >= 0) {
            m2996b(i6, view);
            return;
        }
        this.f3720b = i6;
        if (!this.f3722d) {
            int iMo2886e = this.f3719a.mo2886e(view);
            int iMo2892k = iMo2886e - this.f3719a.mo2892k();
            this.f3721c = iMo2886e;
            if (iMo2892k > 0) {
                int iMo2888g = (this.f3719a.mo2888g() - Math.min(0, (this.f3719a.mo2888g() - iM2922m) - this.f3719a.mo2883b(view))) - (this.f3719a.mo2884c(view) + iMo2886e);
                if (iMo2888g < 0) {
                    this.f3721c -= Math.min(iMo2892k, -iMo2888g);
                    return;
                }
                return;
            }
            return;
        }
        int iMo2888g2 = (this.f3719a.mo2888g() - iM2922m) - this.f3719a.mo2883b(view);
        this.f3721c = this.f3719a.mo2888g() - iMo2888g2;
        if (iMo2888g2 > 0) {
            int iMo2884c = this.f3721c - this.f3719a.mo2884c(view);
            int iMo2892k2 = this.f3719a.mo2892k();
            int iMin = iMo2884c - (Math.min(this.f3719a.mo2886e(view) - iMo2892k2, 0) + iMo2892k2);
            if (iMin < 0) {
                this.f3721c = Math.min(iMo2888g2, -iMin) + this.f3721c;
            }
        }
    }

    public final void m2998d() {
        this.f3720b = -1;
        this.f3721c = Integer.MIN_VALUE;
        this.f3722d = false;
        this.f3723e = false;
    }

    public final String toString() {
        return "AnchorInfo{mPosition=" + this.f3720b + ", mCoordinate=" + this.f3721c + ", mLayoutFromEnd=" + this.f3722d + ", mValid=" + this.f3723e + '}';
    }
}

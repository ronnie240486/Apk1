package androidx.leanback.widget;

import android.view.View;
import com.google.android.gms.cast.framework.internal.featurehighlight.C1498f;
import p138n0.C3153r1;
import p138n0.InterfaceC3154s;
import p171q.C3388b;

public final class C0476j1 implements InterfaceC3154s {

    public int f2351a;

    public int f2352b;

    public Object f2353c;

    public void m1441a() {
        int i6;
        int i10 = this.f2351a;
        if (i10 != 2) {
            if (i10 != 3 && i10 != 1) {
                this.f2353c = null;
                return;
            }
            C1498f c1498f = (C1498f) this.f2353c;
            if (c1498f == null || c1498f.m3613c() != Integer.MAX_VALUE) {
                this.f2353c = new C1498f(Integer.MAX_VALUE);
                return;
            }
            return;
        }
        if (this.f2352b <= 0) {
            throw new IllegalArgumentException();
        }
        C1498f c1498f2 = (C1498f) this.f2353c;
        if (c1498f2 != null) {
            synchronized (((C3388b) c1498f2.f4831g)) {
                i6 = c1498f2.f4826b;
            }
            if (i6 == this.f2352b) {
                return;
            }
        }
        this.f2353c = new C1498f(this.f2352b);
    }

    @Override
    public C3153r1 onApplyWindowInsets(View view, C3153r1 c3153r1) {
        int i6 = c3153r1.f10641a.mo6228g(7).f8682b;
        View view2 = (View) this.f2353c;
        int i10 = this.f2351a;
        if (i10 >= 0) {
            view2.getLayoutParams().height = i10 + i6;
            view2.setLayoutParams(view2.getLayoutParams());
        }
        view2.setPadding(view2.getPaddingLeft(), this.f2352b + i6, view2.getPaddingRight(), view2.getPaddingBottom());
        return c3153r1;
    }
}

package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;

public abstract class AbstractC1135d0 {

    public final AbstractC1197x0 f3538a;

    public int f3539b = Integer.MIN_VALUE;

    public final Rect f3540c = new Rect();

    public AbstractC1135d0(AbstractC1197x0 abstractC1197x0) {
        this.f3538a = abstractC1197x0;
    }

    public static AbstractC1135d0 m2921a(AbstractC1197x0 abstractC1197x0, int i6) {
        if (i6 == 0) {
            return new C1127b0(abstractC1197x0);
        }
        if (i6 == 1) {
            return new C1131c0(abstractC1197x0);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public abstract int mo2883b(View view);

    public abstract int mo2884c(View view);

    public abstract int mo2885d(View view);

    public abstract int mo2886e(View view);

    public abstract int mo2887f();

    public abstract int mo2888g();

    public abstract int mo2889h();

    public abstract int mo2890i();

    public abstract int mo2891j();

    public abstract int mo2892k();

    public abstract int mo2893l();

    public final int m2922m() {
        if (Integer.MIN_VALUE == this.f3539b) {
            return 0;
        }
        return mo2893l() - this.f3539b;
    }

    public abstract int mo2894n(View view);

    public abstract int mo2895o(View view);

    public abstract void mo2896p(int i6);
}

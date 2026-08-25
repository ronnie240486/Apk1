package androidx.recyclerview.widget;

import android.view.View;
import java.util.ArrayList;

public abstract class AbstractC1182s0 {

    public InterfaceC1176q0 f3687a;

    public ArrayList f3688b;

    public long f3689c;

    public long f3690d;

    public long f3691e;

    public long f3692f;

    public static void m2989b(AbstractC1174p1 abstractC1174p1) {
        int i6 = abstractC1174p1.mFlags;
        if (!abstractC1174p1.isInvalid() && (i6 & 4) == 0) {
            abstractC1174p1.getOldPosition();
            abstractC1174p1.getAbsoluteAdapterPosition();
        }
    }

    public abstract boolean mo2953a(AbstractC1174p1 abstractC1174p1, AbstractC1174p1 abstractC1174p2, C1179r0 c1179r0, C1179r0 c1179r1);

    public final void m2990c(AbstractC1174p1 abstractC1174p1) {
        InterfaceC1176q0 interfaceC1176q0 = this.f3687a;
        if (interfaceC1176q0 != null) {
            C1152i0 c1152i0 = (C1152i0) interfaceC1176q0;
            c1152i0.getClass();
            abstractC1174p1.setIsRecyclable(true);
            if (abstractC1174p1.mShadowedHolder != null && abstractC1174p1.mShadowingHolder == null) {
                abstractC1174p1.mShadowedHolder = null;
            }
            abstractC1174p1.mShadowingHolder = null;
            if (abstractC1174p1.shouldBeKeptAsChild()) {
                return;
            }
            View view = abstractC1174p1.itemView;
            RecyclerView recyclerView = (RecyclerView) c1152i0.f3584a;
            if (recyclerView.removeAnimatingView(view) || !abstractC1174p1.isTmpDetached()) {
                return;
            }
            recyclerView.removeDetachedView(abstractC1174p1.itemView, false);
        }
    }

    public abstract void mo2954d(AbstractC1174p1 abstractC1174p1);

    public abstract void mo2955e();

    public abstract boolean mo2956f();
}

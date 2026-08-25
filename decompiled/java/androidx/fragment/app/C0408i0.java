package androidx.fragment.app;

import java.util.ArrayList;

public final class C0408i0 implements InterfaceC0406h0 {

    public final int f1851a;

    public final AbstractC0410j0 f1852b;

    public C0408i0(AbstractC0410j0 abstractC0410j0, int i6) {
        this.f1852b = abstractC0410j0;
        this.f1851a = i6;
    }

    @Override
    public final boolean mo1186a(ArrayList arrayList, ArrayList arrayList2) {
        AbstractC0410j0 abstractC0410j0 = this.f1852b;
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = abstractC0410j0.f1877q;
        int i6 = this.f1851a;
        if (abstractComponentCallbacksC0427s == null || i6 >= 0 || !abstractComponentCallbacksC0427s.m1320i().m1225L()) {
            return abstractC0410j0.m1226M(arrayList, arrayList2, i6, 1);
        }
        return false;
    }
}

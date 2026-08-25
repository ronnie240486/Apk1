package androidx.recyclerview.widget;

import android.view.View;

public final class C1129b2 {

    public final InterfaceC1125a2 f3520a;

    public final C1204z1 f3521b;

    public C1129b2(InterfaceC1125a2 interfaceC1125a2) {
        this.f3520a = interfaceC1125a2;
        C1204z1 c1204z1 = new C1204z1();
        c1204z1.f3748a = 0;
        this.f3521b = c1204z1;
    }

    public final View m2897a(int i6, int i10, int i11, int i12) {
        InterfaceC1125a2 interfaceC1125a2 = this.f3520a;
        int iMo2869d = interfaceC1125a2.mo2869d();
        int iMo2866a = interfaceC1125a2.mo2866a();
        int i13 = i10 > i6 ? 1 : -1;
        View view = null;
        while (i6 != i10) {
            View viewMo2868c = interfaceC1125a2.mo2868c(i6);
            int iMo2867b = interfaceC1125a2.mo2867b(viewMo2868c);
            int iMo2870e = interfaceC1125a2.mo2870e(viewMo2868c);
            C1204z1 c1204z1 = this.f3521b;
            c1204z1.f3749b = iMo2869d;
            c1204z1.f3750c = iMo2866a;
            c1204z1.f3751d = iMo2867b;
            c1204z1.f3752e = iMo2870e;
            if (i11 != 0) {
                c1204z1.f3748a = i11;
                if (c1204z1.m3026a()) {
                    return viewMo2868c;
                }
            }
            if (i12 != 0) {
                c1204z1.f3748a = i12;
                if (c1204z1.m3026a()) {
                    view = viewMo2868c;
                }
            }
            i6 += i13;
        }
        return view;
    }

    public final boolean m2898b(View view) {
        InterfaceC1125a2 interfaceC1125a2 = this.f3520a;
        int iMo2869d = interfaceC1125a2.mo2869d();
        int iMo2866a = interfaceC1125a2.mo2866a();
        int iMo2867b = interfaceC1125a2.mo2867b(view);
        int iMo2870e = interfaceC1125a2.mo2870e(view);
        C1204z1 c1204z1 = this.f3521b;
        c1204z1.f3749b = iMo2869d;
        c1204z1.f3750c = iMo2866a;
        c1204z1.f3751d = iMo2867b;
        c1204z1.f3752e = iMo2870e;
        c1204z1.f3748a = 24579;
        return c1204z1.m3026a();
    }
}

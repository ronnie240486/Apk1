package p076h2;

import p008a9.InterfaceC0074d;
import p021b9.EnumC1367a;
import p025c2.C1382c;
import p025c2.C1383d;
import p030c9.AbstractC1439i;
import p067g2.C2606m;
import p091i9.InterfaceC2728p;
import p103j9.C2801n;
import p130m2.C3061i;
import p130m2.C3065m;
import p156o9.AbstractC3280d;
import p213t9.InterfaceC3861s;
import p243w8.C4070l;

public final class C2643d extends AbstractC1439i implements InterfaceC2728p {

    public int f9195b;

    public final C2648i f9196c;

    public final C2801n f9197d;

    public final C2801n f9198e;

    public final C3061i f9199f;

    public final Object f9200g;

    public final C2801n f9201h;

    public final C1383d f9202i;

    public C2643d(C2648i c2648i, C2801n c2801n, C2801n c2801n2, C3061i c3061i, Object obj, C2801n c2801n3, C1383d c1383d, InterfaceC0074d interfaceC0074d) {
        super(interfaceC0074d);
        this.f9196c = c2648i;
        this.f9197d = c2801n;
        this.f9198e = c2801n2;
        this.f9199f = c3061i;
        this.f9200g = obj;
        this.f9201h = c2801n3;
        this.f9202i = c1383d;
    }

    @Override
    public final InterfaceC0074d create(Object obj, InterfaceC0074d interfaceC0074d) {
        return new C2643d(this.f9196c, this.f9197d, this.f9198e, this.f9199f, this.f9200g, this.f9201h, this.f9202i, interfaceC0074d);
    }

    @Override
    public final Object invoke(Object obj, Object obj2) {
        return ((C2643d) create((InterfaceC3861s) obj, (InterfaceC0074d) obj2)).invokeSuspend(C4070l.f13734a);
    }

    @Override
    public final Object invokeSuspend(Object obj) throws Throwable {
        EnumC1367a enumC1367a = EnumC1367a.f4179a;
        int i6 = this.f9195b;
        if (i6 == 0) {
            AbstractC3280d.m6570I(obj);
            C2606m c2606m = (C2606m) this.f9197d.f9540a;
            C1382c c1382c = (C1382c) this.f9198e.f9540a;
            C3065m c3065m = (C3065m) this.f9201h.f9540a;
            this.f9195b = 1;
            obj = C2648i.m5661a(this.f9196c, c2606m, c1382c, this.f9199f, this.f9200g, c3065m, this.f9202i, this);
            if (obj == enumC1367a) {
                return enumC1367a;
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC3280d.m6570I(obj);
        }
        return obj;
    }
}

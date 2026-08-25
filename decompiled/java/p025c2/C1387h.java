package p025c2;

import p008a9.InterfaceC0074d;
import p021b9.EnumC1367a;
import p030c9.AbstractC1439i;
import p091i9.InterfaceC2728p;
import p130m2.AbstractC3062j;
import p130m2.C3057e;
import p130m2.C3061i;
import p156o9.AbstractC3280d;
import p213t9.InterfaceC3861s;
import p243w8.C4070l;

public final class C1387h extends AbstractC1439i implements InterfaceC2728p {

    public int f4215b;

    public final C1391l f4216c;

    public final C3061i f4217d;

    public C1387h(C1391l c1391l, C3061i c3061i, InterfaceC0074d interfaceC0074d) {
        super(interfaceC0074d);
        this.f4216c = c1391l;
        this.f4217d = c3061i;
    }

    @Override
    public final InterfaceC0074d create(Object obj, InterfaceC0074d interfaceC0074d) {
        return new C1387h(this.f4216c, this.f4217d, interfaceC0074d);
    }

    @Override
    public final Object invoke(Object obj, Object obj2) {
        return ((C1387h) create((InterfaceC3861s) obj, (InterfaceC0074d) obj2)).invokeSuspend(C4070l.f13734a);
    }

    @Override
    public final Object invokeSuspend(Object obj) {
        EnumC1367a enumC1367a = EnumC1367a.f4179a;
        int i6 = this.f4215b;
        C1391l c1391l = this.f4216c;
        if (i6 == 0) {
            AbstractC3280d.m6570I(obj);
            this.f4215b = 1;
            obj = C1391l.m3264a(c1391l, this.f4217d, this);
            if (obj == enumC1367a) {
                return enumC1367a;
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC3280d.m6570I(obj);
        }
        if (((AbstractC3062j) obj) instanceof C3057e) {
            c1391l.getClass();
        }
        return obj;
    }
}

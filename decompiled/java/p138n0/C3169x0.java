package p138n0;

import android.view.View;
import android.view.ViewGroup;
import p008a9.InterfaceC0074d;
import p021b9.EnumC1367a;
import p030c9.AbstractC1438h;
import p091i9.InterfaceC2728p;
import p103j9.C2788a;
import p156o9.AbstractC3280d;
import p181q9.AbstractC3547e;
import p181q9.C3546d;
import p243w8.C4070l;

public final class C3169x0 extends AbstractC1438h implements InterfaceC2728p {

    public int f10659a;

    public Object f10660b;

    public final View f10661c;

    public C3169x0(View view, InterfaceC0074d interfaceC0074d) {
        super(interfaceC0074d);
        this.f10661c = view;
    }

    @Override
    public final InterfaceC0074d create(Object obj, InterfaceC0074d interfaceC0074d) {
        C3169x0 c3169x0 = new C3169x0(this.f10661c, interfaceC0074d);
        c3169x0.f10660b = obj;
        return c3169x0;
    }

    @Override
    public final Object invoke(Object obj, Object obj2) {
        return ((C3169x0) create((AbstractC3547e) obj, (InterfaceC0074d) obj2)).invokeSuspend(C4070l.f13734a);
    }

    @Override
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        EnumC1367a enumC1367a = EnumC1367a.f4179a;
        int i6 = this.f10659a;
        View view = this.f10661c;
        if (i6 == 0) {
            AbstractC3280d.m6570I(obj);
            AbstractC3547e abstractC3547e = (AbstractC3547e) this.f10660b;
            this.f10660b = abstractC3547e;
            this.f10659a = 1;
            C3546d c3546d = (C3546d) abstractC3547e;
            c3546d.f11948b = view;
            c3546d.f11947a = 3;
            c3546d.f11950d = this;
            return enumC1367a;
        }
        C4070l c4070l = C4070l.f13734a;
        if (i6 == 1) {
            AbstractC3547e abstractC3547e2 = (AbstractC3547e) this.f10660b;
            AbstractC3280d.m6570I(obj);
            if (view instanceof ViewGroup) {
                this.f10660b = null;
                this.f10659a = 2;
                abstractC3547e2.getClass();
                C3168x c3168x = new C3168x(new C2788a(1, (ViewGroup) view));
                C3546d c3546d2 = (C3546d) abstractC3547e2;
                if (c3168x.f10657b.hasNext()) {
                    c3546d2.f11949c = c3168x;
                    c3546d2.f11947a = 2;
                    c3546d2.f11950d = this;
                    obj2 = enumC1367a;
                } else {
                    obj2 = c4070l;
                }
                if (obj2 != enumC1367a) {
                    obj2 = c4070l;
                }
                if (obj2 == enumC1367a) {
                    return enumC1367a;
                }
            }
        } else {
            if (i6 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC3280d.m6570I(obj);
        }
        return c4070l;
    }
}

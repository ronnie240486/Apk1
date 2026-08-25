package p025c2;

import android.graphics.Bitmap;
import java.util.ArrayList;
import p008a9.InterfaceC0074d;
import p021b9.EnumC1367a;
import p030c9.AbstractC1439i;
import p076h2.C2650k;
import p091i9.InterfaceC2728p;
import p130m2.C3061i;
import p140n2.C3183h;
import p156o9.AbstractC3280d;
import p213t9.InterfaceC3861s;
import p243w8.C4070l;

public final class C1389j extends AbstractC1439i implements InterfaceC2728p {

    public int f4226b;

    public final C3061i f4227c;

    public final C1391l f4228d;

    public final C3183h f4229e;

    public final C1383d f4230f;

    public final Bitmap f4231g;

    public C1389j(C3061i c3061i, C1391l c1391l, C3183h c3183h, C1383d c1383d, Bitmap bitmap, InterfaceC0074d interfaceC0074d) {
        super(interfaceC0074d);
        this.f4227c = c3061i;
        this.f4228d = c1391l;
        this.f4229e = c3183h;
        this.f4230f = c1383d;
        this.f4231g = bitmap;
    }

    @Override
    public final InterfaceC0074d create(Object obj, InterfaceC0074d interfaceC0074d) {
        return new C1389j(this.f4227c, this.f4228d, this.f4229e, this.f4230f, this.f4231g, interfaceC0074d);
    }

    @Override
    public final Object invoke(Object obj, Object obj2) {
        return ((C1389j) create((InterfaceC3861s) obj, (InterfaceC0074d) obj2)).invokeSuspend(C4070l.f13734a);
    }

    @Override
    public final Object invokeSuspend(Object obj) throws Throwable {
        EnumC1367a enumC1367a = EnumC1367a.f4179a;
        int i6 = this.f4226b;
        if (i6 == 0) {
            AbstractC3280d.m6570I(obj);
            ArrayList arrayList = this.f4228d.f4240h;
            boolean z7 = this.f4231g != null;
            C3061i c3061i = this.f4227c;
            C2650k c2650k = new C2650k(c3061i, arrayList, 0, c3061i, this.f4229e, this.f4230f, z7);
            this.f4226b = 1;
            obj = c2650k.m5666b(c3061i, this);
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

package p076h2;

import android.content.Context;
import java.util.ArrayList;
import p021b9.EnumC1367a;
import p025c2.C1383d;
import p030c9.AbstractC1433c;
import p130m2.AbstractC3062j;
import p130m2.C3061i;
import p130m2.C3063k;
import p140n2.C3183h;
import p156o9.AbstractC3280d;

public final class C2650k {

    public final C3061i f9247a;

    public final ArrayList f9248b;

    public final int f9249c;

    public final C3061i f9250d;

    public final C3183h f9251e;

    public final C1383d f9252f;

    public final boolean f9253g;

    public C2650k(C3061i c3061i, ArrayList arrayList, int i6, C3061i c3061i2, C3183h c3183h, C1383d c1383d, boolean z7) {
        this.f9247a = c3061i;
        this.f9248b = arrayList;
        this.f9249c = i6;
        this.f9250d = c3061i2;
        this.f9251e = c3183h;
        this.f9252f = c1383d;
        this.f9253g = z7;
    }

    public final void m5665a(C3061i c3061i, C2648i c2648i) {
        Context context = c3061i.f10468a;
        C3061i c3061i2 = this.f9247a;
        if (context != c3061i2.f10468a) {
            throw new IllegalStateException(("Interceptor '" + c2648i + "' cannot modify the request's context.").toString());
        }
        if (c3061i.f10469b == C3063k.f10494b) {
            throw new IllegalStateException(("Interceptor '" + c2648i + "' cannot set the request's data to null.").toString());
        }
        if (c3061i.f10470c != c3061i2.f10470c) {
            throw new IllegalStateException(("Interceptor '" + c2648i + "' cannot modify the request's target.").toString());
        }
        if (c3061i.f10488u != c3061i2.f10488u) {
            throw new IllegalStateException(("Interceptor '" + c2648i + "' cannot modify the request's lifecycle.").toString());
        }
        if (c3061i.f10489v == c3061i2.f10489v) {
            return;
        }
        throw new IllegalStateException(("Interceptor '" + c2648i + "' cannot modify the request's size resolver. Use `Interceptor.Chain.withSize` instead.").toString());
    }

    public final Object m5666b(C3061i c3061i, AbstractC1433c abstractC1433c) throws Throwable {
        C2649j c2649j;
        C2650k c2650k;
        C2648i c2648i;
        if (abstractC1433c instanceof C2649j) {
            c2649j = (C2649j) abstractC1433c;
            int i6 = c2649j.f9246e;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                c2649j.f9246e = i6 - Integer.MIN_VALUE;
            } else {
                c2649j = new C2649j(this, abstractC1433c);
            }
        } else {
            c2649j = new C2649j(this, abstractC1433c);
        }
        Object objM5664d = c2649j.f9244c;
        EnumC1367a enumC1367a = EnumC1367a.f4179a;
        int i10 = c2649j.f9246e;
        if (i10 == 0) {
            AbstractC3280d.m6570I(objM5664d);
            ArrayList arrayList = this.f9248b;
            int i11 = this.f9249c;
            if (i11 > 0) {
                m5665a(c3061i, (C2648i) arrayList.get(i11 - 1));
            }
            C2648i c2648i2 = (C2648i) arrayList.get(i11);
            C2650k c2650k2 = new C2650k(this.f9247a, arrayList, i11 + 1, c3061i, this.f9251e, this.f9252f, this.f9253g);
            c2649j.f9242a = this;
            c2649j.f9243b = c2648i2;
            c2649j.f9246e = 1;
            objM5664d = c2648i2.m5664d(c2650k2, c2649j);
            if (objM5664d == enumC1367a) {
                return enumC1367a;
            }
            c2650k = this;
            c2648i = c2648i2;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c2648i = c2649j.f9243b;
            c2650k = c2649j.f9242a;
            AbstractC3280d.m6570I(objM5664d);
        }
        AbstractC3062j abstractC3062j = (AbstractC3062j) objM5664d;
        c2650k.m5665a(abstractC3062j.mo6108b(), c2648i);
        return abstractC3062j;
    }
}

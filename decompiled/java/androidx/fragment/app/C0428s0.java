package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.appcompat.widget.C0280v;
import androidx.lifecycle.AbstractC0541p;
import androidx.lifecycle.C0548s0;
import androidx.lifecycle.C0559y;
import androidx.lifecycle.C0562z0;
import androidx.lifecycle.EnumC0537n;
import androidx.lifecycle.InterfaceC0512a1;
import androidx.lifecycle.InterfaceC0529j;
import androidx.lifecycle.InterfaceC0560y0;
import p041d7.AbstractC2177c2;
import p095j1.C2767a;
import p109k3.C2888t;
import p227v1.InterfaceC3973e;

public final class C0428s0 implements InterfaceC0529j, InterfaceC3973e, InterfaceC0512a1 {

    public final AbstractComponentCallbacksC0427s f1990a;

    public final C0562z0 f1991b;

    public InterfaceC0560y0 f1992c;

    public C0559y f1993d = null;

    public C2888t f1994e = null;

    public C0428s0(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s, C0562z0 c0562z0) {
        this.f1990a = abstractComponentCallbacksC0427s;
        this.f1991b = c0562z0;
    }

    @Override
    public final C0280v mo356a() {
        m1334g();
        return (C0280v) this.f1994e.f9833d;
    }

    public final void m1333b(EnumC0537n enumC0537n) {
        this.f1993d.m1521f(enumC0537n);
    }

    @Override
    public final InterfaceC0560y0 mo357c() {
        Application application;
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = this.f1990a;
        InterfaceC0560y0 interfaceC0560y0Mo357c = abstractComponentCallbacksC0427s.mo357c();
        if (!interfaceC0560y0Mo357c.equals(abstractComponentCallbacksC0427s.f1961P)) {
            this.f1992c = interfaceC0560y0Mo357c;
            return interfaceC0560y0Mo357c;
        }
        if (this.f1992c == null) {
            Context applicationContext = abstractComponentCallbacksC0427s.m1312K().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            this.f1992c = new C0548s0(application, this, abstractComponentCallbacksC0427s.f1970g);
        }
        return this.f1992c;
    }

    @Override
    public final AbstractC2177c2 mo358d() {
        return C2767a.f9482b;
    }

    @Override
    public final C0562z0 mo359e() {
        m1334g();
        return this.f1991b;
    }

    @Override
    public final AbstractC0541p mo360f() {
        m1334g();
        return this.f1993d;
    }

    public final void m1334g() {
        if (this.f1993d == null) {
            this.f1993d = new C0559y(this);
            this.f1994e = new C2888t(this);
        }
    }
}

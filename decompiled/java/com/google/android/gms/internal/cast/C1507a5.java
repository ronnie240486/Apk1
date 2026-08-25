package com.google.android.gms.internal.cast;

import android.text.TextUtils;
import p018b5.AbstractC1312l;
import p025c2.C1381b;
import p176q4.AbstractC3481g;
import p176q4.C3475c;
import p176q4.InterfaceC3483i;

public final class C1507a5 implements InterfaceC3483i {

    public final C1381b f5205a;

    public C1507a5(C1381b c1381b) {
        this.f5205a = c1381b;
    }

    @Override
    public void mo3717a(AbstractC3481g abstractC3481g, int i6) {
        C1552f0 c1552f0 = new C1552f0(5);
        c1552f0.f5292b = Integer.valueOf(i6);
        C1562g0 c1562g0 = new C1562g0(c1552f0);
        C1381b c1381b = this.f5205a;
        C1381b.m3250k(c1381b, c1562g0);
        c1381b.m3262m();
    }

    @Override
    public void mo3718d(AbstractC3481g abstractC3481g, boolean z7) {
        C1562g0 c1562g0 = new C1562g0(new C1552f0(4));
        C1381b c1381b = this.f5205a;
        C1381b.m3250k(c1381b, c1562g0);
        C1540d8 c1540d8 = (C1540d8) c1381b.f4201e;
        AbstractC1312l.m3198e(c1540d8);
        c1540d8.m3805a((C3475c) abstractC3481g);
    }

    @Override
    public void mo3719g(AbstractC3481g abstractC3481g, int i6) {
        C1552f0 c1552f0 = new C1552f0(6);
        c1552f0.f5292b = Integer.valueOf(i6);
        C1562g0 c1562g0 = new C1562g0(c1552f0);
        C1381b c1381b = this.f5205a;
        C1381b.m3250k(c1381b, c1562g0);
        C1540d8 c1540d8 = (C1540d8) c1381b.f4201e;
        AbstractC1312l.m3198e(c1540d8);
        c1540d8.m3805a((C3475c) abstractC3481g);
    }

    @Override
    public void mo3720h(AbstractC3481g abstractC3481g, String str) {
        C1562g0 c1562g0 = new C1562g0(new C1552f0(4));
        C1381b c1381b = this.f5205a;
        C1381b.m3250k(c1381b, c1562g0);
        C1540d8 c1540d8 = (C1540d8) c1381b.f4201e;
        AbstractC1312l.m3198e(c1540d8);
        c1540d8.m3805a((C3475c) abstractC3481g);
        C1540d8 c1540d9 = (C1540d8) c1381b.f4201e;
        AbstractC1312l.m3198e(c1540d9);
        String str2 = c1540d9.f5266k;
        if (str2 == null) {
            c1540d9.f5266k = str;
        } else {
            if (TextUtils.equals(str, str2)) {
                return;
            }
            c1540d9.m3806b(4);
        }
    }

    @Override
    public void mo3721i(AbstractC3481g abstractC3481g, int i6) {
        C1552f0 c1552f0 = new C1552f0(8);
        c1552f0.f5292b = Integer.valueOf(i6);
        C1562g0 c1562g0 = new C1562g0(c1552f0);
        C1381b c1381b = this.f5205a;
        C1381b.m3250k(c1381b, c1562g0);
        c1381b.m3262m();
    }

    @Override
    public void mo3722k(AbstractC3481g abstractC3481g, String str) {
        C1562g0 c1562g0 = new C1562g0(new C1552f0(7));
        C1381b c1381b = this.f5205a;
        C1381b.m3250k(c1381b, c1562g0);
        C1540d8 c1540d8 = (C1540d8) c1381b.f4201e;
        AbstractC1312l.m3198e(c1540d8);
        c1540d8.m3805a((C3475c) abstractC3481g);
        C1540d8 c1540d9 = (C1540d8) c1381b.f4201e;
        AbstractC1312l.m3198e(c1540d9);
        String str2 = c1540d9.f5266k;
        if (str2 == null) {
            c1540d9.f5266k = str;
        } else {
            if (TextUtils.equals(str, str2)) {
                return;
            }
            c1540d9.m3806b(4);
        }
    }

    @Override
    public void mo3723l(AbstractC3481g abstractC3481g) {
    }

    @Override
    public void mo3724m(AbstractC3481g abstractC3481g, int i6) {
        C1552f0 c1552f0 = new C1552f0(9);
        c1552f0.f5292b = Integer.valueOf(i6);
        C1381b c1381b = this.f5205a;
        c1552f0.f5293c = Boolean.valueOf(((BinderC1571h) c1381b.f4199c).f5332f == 2);
        C1381b.m3250k(c1381b, new C1562g0(c1552f0));
        c1381b.m3262m();
    }

    @Override
    public void mo3725n(AbstractC3481g abstractC3481g) {
        C3475c c3475c = (C3475c) abstractC3481g;
        C1552f0 c1552f0 = new C1552f0(2);
        C1381b c1381b = this.f5205a;
        c1552f0.f5293c = Boolean.valueOf(((BinderC1571h) c1381b.f4199c).f5332f == 2);
        C1381b.m3250k(c1381b, new C1562g0(c1552f0));
        C1540d8 c1540d8 = (C1540d8) c1381b.f4201e;
        AbstractC1312l.m3198e(c1540d8);
        c1540d8.m3805a(c3475c);
        c3475c.f11765l = (C1507a5) c1381b.f4202f;
    }
}

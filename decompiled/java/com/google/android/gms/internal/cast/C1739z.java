package com.google.android.gms.internal.cast;

import p018b5.AbstractC1312l;
import p230v4.C3988b;
import p242w5.C4056d;
import p242w5.InterfaceC4054b;
import p242w5.InterfaceC4055c;

public final class C1739z implements InterfaceC4055c, InterfaceC4054b {

    public final C4056d f5741a;

    public C1739z(C4056d c4056d) {
        this.f5741a = c4056d;
    }

    @Override
    public void mo2899a(Exception exc) {
        C1512b0.f5213d.m7974a(exc, "get checkbox consent failed", new Object[0]);
        this.f5741a.m8061d(Boolean.FALSE);
    }

    @Override
    public void onSuccess(Object obj) {
        C1533d1 c1533d1 = (C1533d1) obj;
        C3988b c3988b = C1512b0.f5213d;
        boolean z7 = false;
        if (c1533d1 != null) {
            zzfk zzfkVar = c1533d1.f5243a.f5343a;
            AbstractC1312l.m3198e(zzfkVar);
            if (zzfkVar.f5761a == 1) {
                z7 = true;
            }
        }
        this.f5741a.m8061d(Boolean.valueOf(z7));
    }
}

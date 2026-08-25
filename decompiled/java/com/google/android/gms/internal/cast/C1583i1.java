package com.google.android.gms.internal.cast;

import com.google.android.gms.common.api.Status;
import p018b5.AbstractC1312l;
import p261y4.InterfaceC4264l;

public final class C1583i1 implements InterfaceC4264l {

    public final zzfk f5343a;

    public C1583i1(zzfk zzfkVar) {
        this.f5343a = zzfkVar;
    }

    @Override
    public final Status mo3637h() {
        return Status.f4991e;
    }

    public final String toString() {
        zzfk zzfkVar = this.f5343a;
        AbstractC1312l.m3198e(zzfkVar);
        return "OptInOptionsResultImpl[" + (zzfkVar.f5761a == 1) + "]";
    }
}

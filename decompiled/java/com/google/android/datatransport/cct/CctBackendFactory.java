package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import p017b4.AbstractC1296c;
import p017b4.C1295b;
import p017b4.InterfaceC1300g;
import p260y3.C4252d;

@Keep
public class CctBackendFactory {
    public InterfaceC1300g create(AbstractC1296c abstractC1296c) {
        C1295b c1295b = (C1295b) abstractC1296c;
        return new C4252d(c1295b.f4068a, c1295b.f4069b, c1295b.f4070c);
    }
}

package com.bumptech.glide;

import java.util.HashSet;
import java.util.Set;
import p109k3.C2888t;
import p109k3.InterfaceC2869a;
import p141n3.InterfaceC3189c;
import p186r3.AbstractC3610n;

public final class C1490n implements InterfaceC2869a {

    public final C2888t f4499a;

    public final ComponentCallbacks2C1491o f4500b;

    public C1490n(ComponentCallbacks2C1491o componentCallbacks2C1491o, C2888t c2888t) {
        this.f4500b = componentCallbacks2C1491o;
        this.f4499a = c2888t;
    }

    @Override
    public final void mo3567a(boolean z7) {
        if (z7) {
            synchronized (this.f4500b) {
                C2888t c2888t = this.f4499a;
                for (InterfaceC3189c interfaceC3189c : AbstractC3610n.m7237e((Set) c2888t.f9832c)) {
                    if (!interfaceC3189c.mo6409i() && !interfaceC3189c.mo6402b()) {
                        interfaceC3189c.clear();
                        if (c2888t.f9831b) {
                            ((HashSet) c2888t.f9833d).add(interfaceC3189c);
                        } else {
                            interfaceC3189c.mo6405e();
                        }
                    }
                }
            }
        }
    }
}

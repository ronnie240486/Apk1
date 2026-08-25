package com.google.android.gms.internal.cast;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import java.util.List;
import java.util.Map;
import p002a1.C0026b;
import p109k3.RunnableC2885q;
import p186r3.AbstractC3610n;

public final class C1668r0 extends ConnectivityManager.NetworkCallback {

    public final int f5574a;

    public final Object f5575b;

    public C1668r0(int i6, Object obj) {
        this.f5574a = i6;
        this.f5575b = obj;
    }

    @Override
    public final void onAvailable(Network network) {
        switch (this.f5574a) {
            case 0:
                break;
            case 1:
                AbstractC3610n.m7238f().post(new RunnableC2885q(0, this, true));
                break;
            default:
                C0026b.m114c((C0026b) this.f5575b, network, true);
                break;
        }
    }

    @Override
    public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
        switch (this.f5574a) {
            case 0:
                ((C1677s0) this.f5575b).m4013b(network, linkProperties);
                break;
            default:
                super.onLinkPropertiesChanged(network, linkProperties);
                break;
        }
    }

    @Override
    public final void onLost(Network network) {
        List list;
        switch (this.f5574a) {
            case 0:
                C1677s0 c1677s0 = (C1677s0) this.f5575b;
                synchronized (c1677s0.f5600h) {
                    try {
                        Map map = c1677s0.f5596d;
                        if (map != null && (list = c1677s0.f5597e) != null) {
                            C1677s0.f5592j.m7975b("the network is lost", new Object[0]);
                            if (list.remove(network)) {
                                map.remove(network);
                            }
                            c1677s0.m4014c();
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            case 1:
                AbstractC3610n.m7238f().post(new RunnableC2885q(0, this, false));
                return;
            default:
                C0026b.m114c((C0026b) this.f5575b, network, false);
                return;
        }
    }

    @Override
    public void onUnavailable() {
        List list;
        switch (this.f5574a) {
            case 0:
                C1677s0 c1677s0 = (C1677s0) this.f5575b;
                synchronized (c1677s0.f5600h) {
                    Map map = c1677s0.f5596d;
                    if (map != null && (list = c1677s0.f5597e) != null) {
                        C1677s0.f5592j.m7975b("all networks are unavailable.", new Object[0]);
                        map.clear();
                        list.clear();
                        c1677s0.m4014c();
                        return;
                    }
                    return;
                }
            default:
                super.onUnavailable();
                return;
        }
    }

    private final void m3988a(Network network) {
    }
}

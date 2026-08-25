package com.google.android.gms.internal.cast;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p222u7.AbstractC3928d;
import p230v4.C3988b;

public final class C1677s0 implements InterfaceC1659q0 {

    public static final C3988b f5592j = new C3988b("ConnectivityMonitor", null);

    public final InterfaceExecutorServiceC1665q6 f5593a;

    public final ConnectivityManager f5595c;

    public boolean f5598f;

    public final Context f5599g;

    public final Object f5600h = new Object();

    public final Set f5601i = Collections.synchronizedSet(new HashSet());

    public final Map f5596d = Collections.synchronizedMap(new HashMap());

    public final List f5597e = Collections.synchronizedList(new ArrayList());

    public final C1668r0 f5594b = new C1668r0(0, this);

    public C1677s0(Context context, InterfaceExecutorServiceC1665q6 interfaceExecutorServiceC1665q6) {
        this.f5593a = interfaceExecutorServiceC1665q6;
        this.f5599g = context;
        this.f5595c = (ConnectivityManager) context.getSystemService("connectivity");
    }

    @Override
    public final void mo3972a() {
        ConnectivityManager connectivityManager;
        LinkProperties linkProperties;
        f5592j.m7975b("Start monitoring connectivity changes", new Object[0]);
        if (this.f5598f || (connectivityManager = this.f5595c) == null || AbstractC3928d.m7841b(this.f5599g, "android.permission.ACCESS_NETWORK_STATE") != 0) {
            return;
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork != null && (linkProperties = connectivityManager.getLinkProperties(activeNetwork)) != null) {
            m4013b(activeNetwork, linkProperties);
        }
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addTransportType(1).build(), this.f5594b);
        this.f5598f = true;
    }

    public final void m4013b(Network network, LinkProperties linkProperties) {
        List list;
        synchronized (this.f5600h) {
            try {
                Map map = this.f5596d;
                if (map != null && (list = this.f5597e) != null) {
                    f5592j.m7975b("a new network is available", new Object[0]);
                    if (map.containsKey(network)) {
                        list.remove(network);
                    }
                    map.put(network, linkProperties);
                    list.add(network);
                    m4014c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m4014c() {
        InterfaceExecutorServiceC1665q6 interfaceExecutorServiceC1665q6 = this.f5593a;
        if (interfaceExecutorServiceC1665q6 == null) {
            return;
        }
        Set set = this.f5601i;
        synchronized (set) {
            try {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    C1674r6 c1674r6 = (C1674r6) interfaceExecutorServiceC1665q6;
                    if (!c1674r6.f5587a.isShutdown()) {
                        c1674r6.execute(new RunnableC1502a0(1, this));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

package com.google.android.gms.internal.cast;

import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

public final class C1738y7 {

    public static final C1738y7 f5738c = new C1738y7();

    public final ConcurrentHashMap f5740b = new ConcurrentHashMap();

    public final C1675r7 f5739a = new C1675r7();

    public final InterfaceC1520b8 m4060a(Class cls) {
        Charset charset = AbstractC1639n7.f5472a;
        if (cls == null) {
            throw new NullPointerException("messageType");
        }
        ConcurrentHashMap concurrentHashMap = this.f5740b;
        InterfaceC1520b8 interfaceC1520b8M4038k = (InterfaceC1520b8) concurrentHashMap.get(cls);
        if (interfaceC1520b8M4038k == null) {
            C1675r7 c1675r7 = this.f5739a;
            c1675r7.getClass();
            C1661q2 c1661q2 = AbstractC1530c8.f5236a;
            AbstractC1589i7.class.isAssignableFrom(cls);
            C1510a8 c1510a8Mo3975c = ((C1675r7) c1675r7.f5590b).mo3975c(cls);
            if ((c1510a8Mo3975c.f5212d & 2) == 2) {
                C1661q2 c1661q3 = AbstractC1530c8.f5236a;
                C1661q2 c1661q4 = AbstractC1559f7.f5301a;
                interfaceC1520b8M4038k = new C1720w7(c1661q3, c1510a8Mo3975c.f5209a);
            } else {
                int i6 = AbstractC1729x7.f5726a;
                int i10 = AbstractC1657p7.f5542a;
                C1661q2 c1661q5 = AbstractC1530c8.f5236a;
                C1661q2 c1661q6 = c1510a8Mo3975c.m3727b() + (-1) != 1 ? AbstractC1559f7.f5301a : null;
                int i11 = AbstractC1684s7.f5675a;
                interfaceC1520b8M4038k = C1711v7.m4038k(c1510a8Mo3975c, c1661q5, c1661q6);
            }
            InterfaceC1520b8 interfaceC1520b8 = (InterfaceC1520b8) concurrentHashMap.putIfAbsent(cls, interfaceC1520b8M4038k);
            if (interfaceC1520b8 != null) {
                return interfaceC1520b8;
            }
        }
        return interfaceC1520b8M4038k;
    }
}

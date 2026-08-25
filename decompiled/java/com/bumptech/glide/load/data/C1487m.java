package com.bumptech.glide.load.data;

import java.io.InputStream;
import p259y2.C4243f;

public final class C1487m implements InterfaceC1480f {

    public final C4243f f4495a;

    public C1487m(C4243f c4243f) {
        this.f4495a = c4243f;
    }

    @Override
    public final Class mo3548a() {
        return InputStream.class;
    }

    @Override
    public final InterfaceC1481g mo3549b(Object obj) {
        return new C1483i((InputStream) obj, this.f4495a);
    }
}

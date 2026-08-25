package com.bumptech.glide.load.data;

import android.os.ParcelFileDescriptor;
import java.nio.ByteBuffer;
import p049e3.C2392j;

public final class C1482h implements InterfaceC1480f {

    public final int f4481a;

    public C1482h(int i6) {
        this.f4481a = i6;
    }

    @Override
    public final Class mo3548a() {
        switch (this.f4481a) {
            case 0:
                throw new UnsupportedOperationException("Not implemented");
            case 1:
                return ParcelFileDescriptor.class;
            default:
                return ByteBuffer.class;
        }
    }

    @Override
    public final InterfaceC1481g mo3549b(Object obj) {
        switch (this.f4481a) {
            case 0:
                return new C1483i(obj);
            case 1:
                return new C1483i((ParcelFileDescriptor) obj);
            default:
                return new C2392j((ByteBuffer) obj, 4);
        }
    }
}

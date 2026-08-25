package com.bumptech.glide.load.data;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.util.HashMap;
import p049e3.C2405w;
import p259y2.C4243f;

public final class C1483i implements InterfaceC1481g {

    public static final C1482h f4482c = new C1482h(0);

    public final int f4483a;

    public final Object f4484b;

    public C1483i() {
        this.f4483a = 0;
        this.f4484b = new HashMap();
    }

    @Override
    public void mo3550b() {
        switch (this.f4483a) {
            case 1:
            case 2:
                break;
            default:
                ((C2405w) this.f4484b).m5441b();
                break;
        }
    }

    public ParcelFileDescriptor m3554d() {
        return ((ParcelFileDescriptorRewinder$InternalRewinder) this.f4484b).rewind();
    }

    @Override
    public Object mo3551e() {
        switch (this.f4483a) {
            case 1:
                return ((ParcelFileDescriptorRewinder$InternalRewinder) this.f4484b).rewind();
            case 2:
                return this.f4484b;
            default:
                C2405w c2405w = (C2405w) this.f4484b;
                c2405w.reset();
                return c2405w;
        }
    }

    public C1483i(InputStream inputStream, C4243f c4243f) {
        this.f4483a = 3;
        C2405w c2405w = new C2405w(inputStream, c4243f);
        this.f4484b = c2405w;
        c2405w.mark(5242880);
    }

    public C1483i(ParcelFileDescriptor parcelFileDescriptor) {
        this.f4483a = 1;
        this.f4484b = new ParcelFileDescriptorRewinder$InternalRewinder(parcelFileDescriptor);
    }

    public C1483i(Object obj) {
        this.f4483a = 2;
        this.f4484b = obj;
    }

    private final void m3552a() {
    }

    private final void m3553c() {
    }
}

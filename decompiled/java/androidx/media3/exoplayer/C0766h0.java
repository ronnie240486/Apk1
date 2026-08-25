package androidx.media3.exoplayer;

import java.util.concurrent.atomic.AtomicBoolean;
import p020b7.InterfaceC1339e0;

public final class C0766h0 implements InterfaceC1339e0 {

    public final int f2854a;

    public final Object f2855b;

    public C0766h0(int i6, Object obj) {
        this.f2854a = i6;
        this.f2855b = obj;
    }

    @Override
    public final Object get() {
        switch (this.f2854a) {
            case 0:
                return ((ExoPlayerImplInternal) this.f2855b).lambda$release$0();
            default:
                return Boolean.valueOf(((AtomicBoolean) this.f2855b).get());
        }
    }
}

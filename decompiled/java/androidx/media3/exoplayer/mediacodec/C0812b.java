package androidx.media3.exoplayer.mediacodec;

import com.google.common.util.concurrent.Striped;
import p020b7.InterfaceC1339e0;

public final class C0812b implements InterfaceC1339e0 {

    public final int f2894a;

    public final int f2895b;

    public C0812b(int i6, int i10) {
        this.f2894a = i10;
        this.f2895b = i6;
    }

    @Override
    public final Object get() {
        switch (this.f2894a) {
            case 0:
                return AsynchronousMediaCodecAdapter.Factory.lambda$new$0(this.f2895b);
            case 1:
                return AsynchronousMediaCodecAdapter.Factory.lambda$new$1(this.f2895b);
            case 2:
                return Striped.lambda$semaphore$1(this.f2895b);
            default:
                return Striped.lambda$lazyWeakSemaphore$2(this.f2895b);
        }
    }
}

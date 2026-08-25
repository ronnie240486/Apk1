package p016b3;

import android.util.Log;
import com.bumptech.glide.EnumC1469g;
import com.bumptech.glide.load.data.InterfaceC1478d;
import com.bumptech.glide.load.data.InterfaceC1479e;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import p186r3.AbstractC3597a;

public final class C1267e implements InterfaceC1479e {

    public final int f4006a;

    public final Object f4007b;

    public C1267e(int i6, Object obj) {
        this.f4006a = i6;
        this.f4007b = obj;
    }

    @Override
    public final Class mo3151a() {
        switch (this.f4006a) {
            case 0:
                return ByteBuffer.class;
            default:
                return this.f4007b.getClass();
        }
    }

    @Override
    public final void mo3152b() {
        int i6 = this.f4006a;
    }

    @Override
    public final void cancel() {
        int i6 = this.f4006a;
    }

    @Override
    public final int mo3153d() {
        switch (this.f4006a) {
        }
        return 1;
    }

    @Override
    public final void mo3154f(EnumC1469g enumC1469g, InterfaceC1478d interfaceC1478d) {
        switch (this.f4006a) {
            case 0:
                try {
                    interfaceC1478d.mo3173e(AbstractC3597a.m7217a((File) this.f4007b));
                } catch (IOException e5) {
                    if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                        Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e5);
                    }
                    interfaceC1478d.mo3172c(e5);
                    return;
                }
                break;
            default:
                interfaceC1478d.mo3173e(this.f4007b);
                break;
        }
    }

    private final void m3147c() {
    }

    private final void m3148e() {
    }

    private final void m3149g() {
    }

    private final void m3150h() {
    }
}

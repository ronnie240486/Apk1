package p086i3;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import p151o3.AbstractC3248b;
import p164p3.InterfaceC3354c;

public final class C2690f extends AbstractC3248b {

    public final Handler f9348d;

    public final int f9349e;

    public final long f9350f;

    public Bitmap f9351g;

    public C2690f(Handler handler, int i6, long j10) {
        this.f9348d = handler;
        this.f9349e = i6;
        this.f9350f = j10;
    }

    @Override
    public final void mo3560d(Object obj, InterfaceC3354c interfaceC3354c) {
        this.f9351g = (Bitmap) obj;
        Handler handler = this.f9348d;
        handler.sendMessageAtTime(handler.obtainMessage(1, this), this.f9350f);
    }

    @Override
    public final void mo3564h(Drawable drawable) {
        this.f9351g = null;
    }
}

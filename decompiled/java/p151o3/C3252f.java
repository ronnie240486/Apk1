package p151o3;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.ComponentCallbacks2C1491o;
import p141n3.InterfaceC3189c;
import p164p3.InterfaceC3354c;

public final class C3252f extends AbstractC3248b {

    public static final Handler f10885e = new Handler(Looper.getMainLooper(), new C3251e(0));

    public final ComponentCallbacks2C1491o f10886d;

    public C3252f(ComponentCallbacks2C1491o componentCallbacks2C1491o) {
        this.f10886d = componentCallbacks2C1491o;
    }

    @Override
    public final void mo3560d(Object obj, InterfaceC3354c interfaceC3354c) {
        InterfaceC3189c interfaceC3189c = this.f10877c;
        if (interfaceC3189c == null || !interfaceC3189c.mo6409i()) {
            return;
        }
        f10885e.obtainMessage(1, this).sendToTarget();
    }

    @Override
    public final void mo3564h(Drawable drawable) {
    }
}

package p000a;

import android.window.OnBackInvokedCallback;
import androidx.appcompat.app.LayoutInflaterFactory2C0135g0;

public final class C0012m implements OnBackInvokedCallback {

    public final int f23a;

    public final Object f24b;

    public C0012m(int i6, Object obj) {
        this.f23a = i6;
        this.f24b = obj;
    }

    @Override
    public final void onBackInvoked() {
        switch (this.f23a) {
            case 0:
                ((Runnable) this.f24b).run();
                break;
            default:
                ((LayoutInflaterFactory2C0135g0) this.f24b).m387E();
                break;
        }
    }
}

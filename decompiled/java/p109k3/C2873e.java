package p109k3;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public final class C2873e implements InterfaceC2874f {

    public final Set f9806a = Collections.newSetFromMap(new WeakHashMap());

    public volatile boolean f9807b;

    @Override
    public final void mo5860a(FragmentActivity fragmentActivity) {
        if (!this.f9807b && this.f9806a.add(fragmentActivity)) {
            View decorView = fragmentActivity.getWindow().getDecorView();
            decorView.getViewTreeObserver().addOnDrawListener(new ViewTreeObserverOnDrawListenerC2872d(this, decorView));
        }
    }
}

package p138n0;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.WeakHashMap;

public final class ViewOnApplyWindowInsetsListenerC3116f0 implements View.OnApplyWindowInsetsListener {

    public C3153r1 f10597a = null;

    public final View f10598b;

    public final InterfaceC3154s f10599c;

    public ViewOnApplyWindowInsetsListenerC3116f0(View view, InterfaceC3154s interfaceC3154s) {
        this.f10598b = view;
        this.f10599c = interfaceC3154s;
    }

    @Override
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        C3153r1 c3153r1M6324h = C3153r1.m6324h(windowInsets, view);
        int i6 = Build.VERSION.SDK_INT;
        InterfaceC3154s interfaceC3154s = this.f10599c;
        if (i6 < 30) {
            AbstractC3119g0.m6162a(windowInsets, this.f10598b);
            if (c3153r1M6324h.equals(this.f10597a)) {
                return interfaceC3154s.onApplyWindowInsets(view, c3153r1M6324h).m6330g();
            }
        }
        this.f10597a = c3153r1M6324h;
        C3153r1 c3153r1OnApplyWindowInsets = interfaceC3154s.onApplyWindowInsets(view, c3153r1M6324h);
        if (i6 >= 30) {
            return c3153r1OnApplyWindowInsets.m6330g();
        }
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        AbstractC3113e0.m6130c(view);
        return c3153r1OnApplyWindowInsets.m6330g();
    }
}

package androidx.appcompat.app;

import android.app.Activity;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.media3.common.PlaybackException;
import java.util.Objects;
import p000a.AbstractC0010k;
import p000a.C0012m;

public abstract class AbstractC0170y {
    public static OnBackInvokedDispatcher m522a(Activity activity) {
        return activity.getOnBackInvokedDispatcher();
    }

    public static OnBackInvokedCallback m523b(Object obj, LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0) {
        Objects.requireNonNull(layoutInflaterFactory2C0135g0);
        C0012m c0012m = new C0012m(1, layoutInflaterFactory2C0135g0);
        AbstractC0010k.m40e(obj).registerOnBackInvokedCallback(PlaybackException.CUSTOM_ERROR_CODE_BASE, c0012m);
        return c0012m;
    }

    public static void m524c(Object obj, Object obj2) {
        AbstractC0010k.m40e(obj).unregisterOnBackInvokedCallback(AbstractC0010k.m37b(obj2));
    }
}

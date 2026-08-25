package androidx.appcompat.widget;

import android.view.View;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.media3.common.PlaybackException;
import java.util.Objects;
import p000a.C0012m;

public abstract class AbstractC0254p3 {
    public static OnBackInvokedDispatcher m753a(View view) {
        return view.findOnBackInvokedDispatcher();
    }

    public static OnBackInvokedCallback m754b(Runnable runnable) {
        Objects.requireNonNull(runnable);
        return new C0012m(0, runnable);
    }

    public static void m755c(Object obj, Object obj2) {
        ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(PlaybackException.CUSTOM_ERROR_CODE_BASE, (OnBackInvokedCallback) obj2);
    }

    public static void m756d(Object obj, Object obj2) {
        ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
    }
}

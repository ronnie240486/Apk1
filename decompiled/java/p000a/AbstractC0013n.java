package p000a;

import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.Objects;

public abstract class AbstractC0013n {
    public static OnBackInvokedCallback m45a(Runnable runnable) {
        Objects.requireNonNull(runnable);
        return new C0012m(0, runnable);
    }

    public static void m46b(Object obj, int i6, Object obj2) {
        ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i6, (OnBackInvokedCallback) obj2);
    }

    public static void m47c(Object obj, Object obj2) {
        ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
    }
}

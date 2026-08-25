package p138n0;

import android.view.View;
import com.p2serv.android.p032ds.R;
import java.util.Objects;
import p160p.C3347k;
import p172q0.AbstractC3389a;

public abstract class AbstractC3134l0 {
    public static void m6241a(View view, InterfaceC3149q0 interfaceC3149q0) {
        C3347k c3347k = (C3347k) view.getTag(R.id.tag_unhandled_key_listeners);
        if (c3347k == null) {
            c3347k = new C3347k(0);
            view.setTag(R.id.tag_unhandled_key_listeners, c3347k);
        }
        Objects.requireNonNull(interfaceC3149q0);
        View.OnUnhandledKeyEventListener viewOnUnhandledKeyEventListenerC3131k0 = new ViewOnUnhandledKeyEventListenerC3131k0();
        c3347k.put(interfaceC3149q0, viewOnUnhandledKeyEventListenerC3131k0);
        view.addOnUnhandledKeyEventListener(viewOnUnhandledKeyEventListenerC3131k0);
    }

    public static CharSequence m6242b(View view) {
        return view.getAccessibilityPaneTitle();
    }

    public static boolean m6243c(View view) {
        return view.isAccessibilityHeading();
    }

    public static boolean m6244d(View view) {
        return view.isScreenReaderFocusable();
    }

    public static void m6245e(View view, InterfaceC3149q0 interfaceC3149q0) {
        View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
        C3347k c3347k = (C3347k) view.getTag(R.id.tag_unhandled_key_listeners);
        if (c3347k == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) c3347k.get(interfaceC3149q0)) == null) {
            return;
        }
        view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
    }

    public static <T> T m6246f(View view, int i6) {
        return (T) view.requireViewById(i6);
    }

    public static void m6247g(View view, boolean z7) {
        view.setAccessibilityHeading(z7);
    }

    public static void m6248h(View view, CharSequence charSequence) {
        view.setAccessibilityPaneTitle(charSequence);
    }

    public static void m6249i(View view, AbstractC3389a abstractC3389a) {
        view.setAutofillId(null);
    }

    public static void m6250j(View view, boolean z7) {
        view.setScreenReaderFocusable(z7);
    }
}

package p138n0;

import android.view.View;
import java.lang.ref.WeakReference;
import p007a7.C0067d;

public final class C3102a1 {

    public final WeakReference f10574a;

    public C3102a1(View view) {
        this.f10574a = new WeakReference(view);
    }

    public final void m6121a(float f) {
        View view = (View) this.f10574a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
    }

    public final void m6122b() {
        View view = (View) this.f10574a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void m6123c(long j10) {
        View view = (View) this.f10574a.get();
        if (view != null) {
            view.animate().setDuration(j10);
        }
    }

    public final void m6124d(InterfaceC3105b1 interfaceC3105b1) {
        View view = (View) this.f10574a.get();
        if (view != null) {
            if (interfaceC3105b1 != null) {
                view.animate().setListener(new C0067d(interfaceC3105b1, 3, view));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    public final void m6125e(float f) {
        View view = (View) this.f10574a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
    }
}

package androidx.fragment.app;

import android.animation.Animator;
import android.util.Log;
import android.view.View;
import androidx.lifecycle.InterfaceC0520e0;
import androidx.lifecycle.InterfaceC0555w;
import p094j0.InterfaceC2756d;

public final class C0397d implements InterfaceC2756d, InterfaceC0520e0 {

    public final int f1832a;

    public final Object f1833b;

    public C0397d(int i6, Object obj) {
        this.f1832a = i6;
        this.f1833b = obj;
    }

    @Override
    public void mo125a() {
        switch (this.f1832a) {
            case 0:
                ((Animator) this.f1833b).end();
                break;
            default:
                ((C0434v0) this.f1833b).m1336a();
                break;
        }
    }

    public void m1199b() {
        ((C0433v) this.f1833b).f2005i.m1224K();
    }

    @Override
    public void mo1200c(Object obj) {
        if (((InterfaceC0555w) obj) != null) {
            DialogInterfaceOnCancelListenerC0415m dialogInterfaceOnCancelListenerC0415m = (DialogInterfaceOnCancelListenerC0415m) this.f1833b;
            if (dialogInterfaceOnCancelListenerC0415m.f1904b0) {
                View viewM1313L = dialogInterfaceOnCancelListenerC0415m.m1313L();
                if (viewM1313L.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                if (dialogInterfaceOnCancelListenerC0415m.f1908f0 != null) {
                    if (Log.isLoggable("FragmentManager", 3)) {
                        Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + dialogInterfaceOnCancelListenerC0415m.f1908f0);
                    }
                    dialogInterfaceOnCancelListenerC0415m.f1908f0.setContentView(viewM1313L);
                }
            }
        }
    }
}

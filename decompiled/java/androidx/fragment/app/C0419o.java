package androidx.fragment.app;

import android.view.View;
import androidx.lifecycle.EnumC0537n;
import androidx.lifecycle.InterfaceC0551u;
import androidx.lifecycle.InterfaceC0555w;

public final class C0419o implements InterfaceC0551u {

    public final AbstractComponentCallbacksC0427s f1918a;

    public C0419o(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        this.f1918a = abstractComponentCallbacksC0427s;
    }

    @Override
    public final void onStateChanged(InterfaceC0555w interfaceC0555w, EnumC0537n enumC0537n) {
        View view;
        if (enumC0537n != EnumC0537n.ON_STOP || (view = this.f1918a.f1951F) == null) {
            return;
        }
        view.cancelPendingInputEvents();
    }
}

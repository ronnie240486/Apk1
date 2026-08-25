package p105k;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.DialogInterfaceC0140j;

public final class DialogInterfaceOnKeyListenerC2839m implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, InterfaceC2850x {

    public SubMenuC2831e0 f9711a;

    public DialogInterfaceC0140j f9712b;

    public C2834h f9713c;

    @Override
    public final void mo86b(MenuC2838l menuC2838l, boolean z7) {
        DialogInterfaceC0140j dialogInterfaceC0140j;
        if ((z7 || menuC2838l == this.f9711a) && (dialogInterfaceC0140j = this.f9712b) != null) {
            dialogInterfaceC0140j.dismiss();
        }
    }

    @Override
    public final boolean mo90f(MenuC2838l menuC2838l) {
        return false;
    }

    @Override
    public final void onClick(DialogInterface dialogInterface, int i6) {
        C2834h c2834h = this.f9713c;
        if (c2834h.f9679f == null) {
            c2834h.f9679f = new C2833g(c2834h);
        }
        this.f9711a.m5832q(c2834h.f9679f.getItem(i6), null, 0);
    }

    @Override
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f9713c.mo707b(this.f9711a, true);
    }

    @Override
    public final boolean onKey(DialogInterface dialogInterface, int i6, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        SubMenuC2831e0 subMenuC2831e0 = this.f9711a;
        if (i6 == 82 || i6 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f9712b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f9712b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                subMenuC2831e0.m5827c(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return subMenuC2831e0.performShortcut(i6, keyEvent, 0);
    }
}

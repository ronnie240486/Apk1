package androidx.fragment.app;

public final class RunnableC0399e implements Runnable {

    public final int f1836a;

    public final Object f1837b;

    public RunnableC0399e(int i6, Object obj) {
        this.f1836a = i6;
        this.f1837b = obj;
    }

    @Override
    public final void run() {
        switch (this.f1836a) {
            case 0:
                AnimationAnimationListenerC0401f animationAnimationListenerC0401f = (AnimationAnimationListenerC0401f) this.f1837b;
                animationAnimationListenerC0401f.f1839a.endViewTransition(animationAnimationListenerC0401f.f1840b);
                animationAnimationListenerC0401f.f1841c.m373d();
                break;
            case 1:
                DialogInterfaceOnCancelListenerC0415m dialogInterfaceOnCancelListenerC0415m = (DialogInterfaceOnCancelListenerC0415m) this.f1837b;
                dialogInterfaceOnCancelListenerC0415m.f1900W.onDismiss(dialogInterfaceOnCancelListenerC0415m.f1908f0);
                break;
            default:
                ((AbstractC0410j0) this.f1837b).m1259u(true);
                break;
        }
    }
}

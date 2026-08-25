package androidx.appcompat.widget;

public final class RunnableC0184c implements Runnable {

    public final int f875a;

    public final ActionBarOverlayLayout f876b;

    public RunnableC0184c(ActionBarOverlayLayout actionBarOverlayLayout, int i6) {
        this.f875a = i6;
        this.f876b = actionBarOverlayLayout;
    }

    @Override
    public final void run() {
        switch (this.f875a) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = this.f876b;
                actionBarOverlayLayout.m549d();
                actionBarOverlayLayout.f570w = actionBarOverlayLayout.f551d.animate().translationY(0.0f).setListener(actionBarOverlayLayout.f571x);
                break;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.f876b;
                actionBarOverlayLayout2.m549d();
                actionBarOverlayLayout2.f570w = actionBarOverlayLayout2.f551d.animate().translationY(-actionBarOverlayLayout2.f551d.getHeight()).setListener(actionBarOverlayLayout2.f571x);
                break;
        }
    }
}

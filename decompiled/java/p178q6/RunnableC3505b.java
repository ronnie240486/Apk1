package p178q6;

import android.os.SystemClock;

public final class RunnableC3505b implements Runnable {

    public final int f11794a;

    public final AbstractC3507d f11795b;

    public RunnableC3505b(AbstractC3507d abstractC3507d, int i6) {
        this.f11794a = i6;
        this.f11795b = abstractC3507d;
    }

    @Override
    public final void run() {
        switch (this.f11794a) {
            case 0:
                AbstractC3507d abstractC3507d = this.f11795b;
                if (abstractC3507d.f11801d > 0) {
                    SystemClock.uptimeMillis();
                }
                abstractC3507d.setVisibility(0);
                break;
            default:
                AbstractC3507d abstractC3507d2 = this.f11795b;
                ((AbstractC3515l) abstractC3507d2.getCurrentDrawable()).m7166e(false, false, true);
                if ((abstractC3507d2.getProgressDrawable() == null || !abstractC3507d2.getProgressDrawable().isVisible()) && (abstractC3507d2.getIndeterminateDrawable() == null || !abstractC3507d2.getIndeterminateDrawable().isVisible())) {
                    abstractC3507d2.setVisibility(4);
                }
                abstractC3507d2.getClass();
                break;
        }
    }
}

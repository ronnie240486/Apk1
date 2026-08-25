package p205t;

import android.view.ViewGroup;

public final class RunnableC3777q implements Runnable {

    public final ViewGroup f12696a;

    public RunnableC3777q(ViewGroup viewGroup) {
        this.f12696a = viewGroup;
    }

    @Override
    public final void run() {
        this.f12696a.setNestedScrollingEnabled(true);
    }
}

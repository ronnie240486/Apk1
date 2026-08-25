package androidx.media3.p011ui;

import android.view.View;

public final class RunnableC1056a implements Runnable {

    public final int f3115a;

    public final View f3116b;

    public RunnableC1056a(View view, int i6) {
        this.f3115a = i6;
        this.f3116b = view;
    }

    @Override
    public final void run() {
        switch (this.f3115a) {
            case 0:
                ((DefaultTimeBar) this.f3116b).lambda$new$0();
                break;
            case 1:
                ((PlayerControlView) this.f3116b).updateProgress();
                break;
            default:
                ((PlayerView) this.f3116b).invalidate();
                break;
        }
    }
}

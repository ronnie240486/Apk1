package p005a4;

import android.os.Process;
import android.util.Log;

public final class RunnableC0058q implements Runnable {

    public final int f165a;

    public final Runnable f166b;

    public RunnableC0058q(Runnable runnable, int i6) {
        this.f165a = i6;
        this.f166b = runnable;
    }

    @Override
    public final void run() {
        switch (this.f165a) {
            case 0:
                try {
                    this.f166b.run();
                } catch (Exception e5) {
                    Log.e("TransportRuntime.".concat("Executor"), "Background execution failure.", e5);
                    return;
                }
                break;
            default:
                Process.setThreadPriority(10);
                this.f166b.run();
                break;
        }
    }
}

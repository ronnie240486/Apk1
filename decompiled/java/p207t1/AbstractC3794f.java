package p207t1;

import android.view.Choreographer;

public abstract class AbstractC3794f {
    public static void m7563a(final Runnable runnable) {
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
            @Override
            public final void doFrame(long j10) {
                runnable.run();
            }
        });
    }
}

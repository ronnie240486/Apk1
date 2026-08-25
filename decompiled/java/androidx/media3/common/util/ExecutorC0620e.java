package androidx.media3.common.util;

import android.os.Handler;
import java.util.concurrent.Executor;

public final class ExecutorC0620e implements Executor {

    public final Handler f2644a;

    @Override
    public final void execute(Runnable runnable) {
        this.f2644a.post(runnable);
    }
}

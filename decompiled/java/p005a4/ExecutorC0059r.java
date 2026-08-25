package p005a4;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.cast.HandlerC1731y0;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

public final class ExecutorC0059r implements Executor {

    public final int f167a;

    public final Object f168b;

    public ExecutorC0059r(int i6, Object obj) {
        this.f167a = i6;
        this.f168b = obj;
    }

    @Override
    public final void execute(Runnable runnable) {
        switch (this.f167a) {
            case 0:
                ((ExecutorService) this.f168b).execute(new RunnableC0058q(runnable, 0));
                return;
            case 1:
                runnable.getClass();
                Handler handler = (Handler) this.f168b;
                if (handler.post(runnable)) {
                    return;
                }
                throw new RejectedExecutionException(handler + " is shutting down");
            case 2:
                ((HandlerC1731y0) this.f168b).post(runnable);
                return;
            default:
                ((HandlerC1731y0) this.f168b).post(runnable);
                return;
        }
    }

    public ExecutorC0059r() {
        this.f167a = 2;
        HandlerC1731y0 handlerC1731y0 = new HandlerC1731y0(Looper.getMainLooper(), 6, false);
        Looper.getMainLooper();
        this.f168b = handlerC1731y0;
    }
}

package p119l1;

import android.util.Log;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public final class C2962c extends FutureTask {

    public final RunnableC2960a f10147a;

    public C2962c(RunnableC2960a runnableC2960a, CallableC2961b callableC2961b) {
        super(callableC2961b);
        this.f10147a = runnableC2960a;
    }

    @Override
    public final void done() {
        RunnableC2960a runnableC2960a = this.f10147a;
        try {
            Object obj = get();
            if (runnableC2960a.f10143b.get()) {
                return;
            }
            runnableC2960a.m6003a(obj);
        } catch (InterruptedException e5) {
            Log.w("AsyncTask", e5);
        } catch (CancellationException unused) {
            if (runnableC2960a.f10143b.get()) {
                return;
            }
            runnableC2960a.m6003a(null);
        } catch (ExecutionException e10) {
            throw new RuntimeException("An error occurred while executing doInBackground()", e10.getCause());
        } catch (Throwable th) {
            throw new RuntimeException("An error occurred while executing doInBackground()", th);
        }
    }
}

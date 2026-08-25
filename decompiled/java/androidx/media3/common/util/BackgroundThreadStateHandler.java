package androidx.media3.common.util;

import android.os.Looper;
import p020b7.InterfaceC1346i;

@UnstableApi
public final class BackgroundThreadStateHandler<T> {
    private final HandlerWrapper backgroundHandler;
    private T backgroundState;
    private final HandlerWrapper foregroundHandler;
    private T foregroundState;
    private final StateChangeListener<T> onStateChanged;
    private int pendingOperations;

    public interface StateChangeListener<T> {
        void onStateChanged(T t5, T t8);
    }

    public BackgroundThreadStateHandler(T t5, Looper looper, Looper looper2, Clock clock, StateChangeListener<T> stateChangeListener) {
        this.backgroundHandler = clock.createHandler(looper, null);
        this.foregroundHandler = clock.createHandler(looper2, null);
        this.foregroundState = t5;
        this.backgroundState = t5;
        this.onStateChanged = stateChangeListener;
    }

    public void lambda$setStateInBackground$2(Object obj) {
        if (this.pendingOperations == 0) {
            updateStateInForeground(obj);
        }
    }

    public void lambda$updateStateAsync$0(Object obj) {
        int i6 = this.pendingOperations - 1;
        this.pendingOperations = i6;
        if (i6 == 0) {
            updateStateInForeground(obj);
        }
    }

    public void lambda$updateStateAsync$1(InterfaceC1346i interfaceC1346i) {
        T t5 = (T) interfaceC1346i.apply(this.backgroundState);
        this.backgroundState = t5;
        this.foregroundHandler.post(new RunnableC0616a(this, t5, 1));
    }

    private void updateStateInForeground(T t5) {
        T t8 = this.foregroundState;
        this.foregroundState = t5;
        if (t8.equals(t5)) {
            return;
        }
        this.onStateChanged.onStateChanged(t8, t5);
    }

    public T get() {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == this.foregroundHandler.getLooper()) {
            return this.foregroundState;
        }
        Assertions.checkState(looperMyLooper == this.backgroundHandler.getLooper());
        return this.backgroundState;
    }

    public void runInBackground(Runnable runnable) {
        this.backgroundHandler.post(runnable);
    }

    public void setStateInBackground(T t5) {
        this.backgroundState = t5;
        this.foregroundHandler.post(new RunnableC0616a(this, t5, 0));
    }

    public void updateStateAsync(InterfaceC1346i interfaceC1346i, InterfaceC1346i interfaceC1346i2) {
        Assertions.checkState(Looper.myLooper() == this.foregroundHandler.getLooper());
        this.pendingOperations++;
        this.backgroundHandler.post(new RunnableC0622g(this, 1, interfaceC1346i2));
        updateStateInForeground(interfaceC1346i.apply(this.foregroundState));
    }
}

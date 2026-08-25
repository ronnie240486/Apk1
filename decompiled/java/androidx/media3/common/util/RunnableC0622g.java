package androidx.media3.common.util;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import p020b7.InterfaceC1346i;

public final class RunnableC0622g implements Runnable {

    public final int f2646a;

    public final Object f2647b;

    public final Object f2648c;

    public RunnableC0622g(Object obj, int i6, Object obj2) {
        this.f2646a = i6;
        this.f2647b = obj;
        this.f2648c = obj2;
    }

    @Override
    public final void run() {
        switch (this.f2646a) {
            case 0:
                ((NetworkTypeObserver.Receiver) this.f2647b).lambda$onReceive$0((Context) this.f2648c);
                break;
            case 1:
                ((BackgroundThreadStateHandler) this.f2647b).lambda$updateStateAsync$1((InterfaceC1346i) this.f2648c);
                break;
            case 2:
                ((NetworkTypeObserver) this.f2647b).lambda$new$0((Context) this.f2648c);
                break;
            default:
                Util.lambda$transformFutureAsync$1((SettableFuture) this.f2647b, (ListenableFuture) this.f2648c);
                break;
        }
    }
}

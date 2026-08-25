package p109k3;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import androidx.appcompat.app.C0125b0;
import java.util.concurrent.Executor;
import p012b.C1224a;

public final class C2887s implements InterfaceC2883o {

    public static final Executor f9822g = AsyncTask.SERIAL_EXECUTOR;

    public final Context f9823a;

    public final C2882n f9824b;

    public final C1224a f9825c;

    public volatile boolean f9826d;

    public volatile boolean f9827e;

    public final C0125b0 f9828f = new C0125b0(2, this);

    public C2887s(Context context, C1224a c1224a, C2882n c2882n) {
        this.f9823a = context.getApplicationContext();
        this.f9825c = c1224a;
        this.f9824b = c2882n;
    }

    @Override
    public final void mo5379a() {
        f9822g.execute(new RunnableC2886r(this, 1));
    }

    @Override
    public final boolean mo5380b() {
        f9822g.execute(new RunnableC2886r(this, 0));
        return true;
    }

    public final boolean m5883c() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f9825c.get()).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e5) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e5);
            }
            return true;
        }
    }
}

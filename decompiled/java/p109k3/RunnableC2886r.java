package p109k3;

import android.content.IntentFilter;
import android.util.Log;
import p186r3.AbstractC3610n;

public final class RunnableC2886r implements Runnable {

    public final int f9820a;

    public final C2887s f9821b;

    public RunnableC2886r(C2887s c2887s, int i6) {
        this.f9820a = i6;
        this.f9821b = c2887s;
    }

    @Override
    public final void run() {
        switch (this.f9820a) {
            case 0:
                C2887s c2887s = this.f9821b;
                c2887s.f9826d = c2887s.m5883c();
                try {
                    C2887s c2887s2 = this.f9821b;
                    c2887s2.f9823a.registerReceiver(c2887s2.f9828f, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    this.f9821b.f9827e = true;
                } catch (SecurityException e5) {
                    if (Log.isLoggable("ConnectivityMonitor", 5)) {
                        Log.w("ConnectivityMonitor", "Failed to register", e5);
                    }
                    this.f9821b.f9827e = false;
                    return;
                }
                break;
            case 1:
                if (this.f9821b.f9827e) {
                    this.f9821b.f9827e = false;
                    C2887s c2887s3 = this.f9821b;
                    c2887s3.f9823a.unregisterReceiver(c2887s3.f9828f);
                    break;
                }
                break;
            default:
                boolean z7 = this.f9821b.f9826d;
                C2887s c2887s4 = this.f9821b;
                c2887s4.f9826d = c2887s4.m5883c();
                if (z7 != this.f9821b.f9826d) {
                    if (Log.isLoggable("ConnectivityMonitor", 3)) {
                        Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + this.f9821b.f9826d);
                    }
                    C2887s c2887s5 = this.f9821b;
                    AbstractC3610n.m7238f().post(new RunnableC2885q(1, c2887s5, c2887s5.f9826d));
                }
                break;
        }
    }
}

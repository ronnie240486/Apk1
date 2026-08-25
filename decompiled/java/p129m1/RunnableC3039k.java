package p129m1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;
import p000a.AbstractC0004e;
import p101j7.C2782c;

public final class RunnableC3039k implements Runnable {

    public final C3044p f10375a;

    public final String f10376b;

    public final int f10377c;

    public final int f10378d;

    public final C2782c f10379e;

    public RunnableC3039k(int i6, int i10, Bundle bundle, C2782c c2782c, String str, C3044p c3044p) {
        this.f10379e = c2782c;
        this.f10375a = c3044p;
        this.f10376b = str;
        this.f10377c = i6;
        this.f10378d = i10;
    }

    @Override
    public final void run() {
        C3044p c3044p = this.f10375a;
        Messenger messenger = c3044p.f10399a;
        IBinder binder = messenger.getBinder();
        C2782c c2782c = this.f10379e;
        ((MediaBrowserServiceCompat) c2782c.f9501b).f2574d.remove(binder);
        String str = this.f10376b;
        new C3030b((MediaBrowserServiceCompat) c2782c.f9501b, str, this.f10377c, this.f10378d, c3044p);
        MediaBrowserServiceCompat mediaBrowserServiceCompat = (MediaBrowserServiceCompat) c2782c.f9501b;
        mediaBrowserServiceCompat.getClass();
        mediaBrowserServiceCompat.m1531a();
        StringBuilder sbM30x = AbstractC0004e.m30x("No root for client ", str, " from service ");
        sbM30x.append(RunnableC3039k.class.getName());
        Log.i("MBServiceCompat", sbM30x.toString());
        try {
            Message messageObtain = Message.obtain();
            messageObtain.what = 2;
            messageObtain.arg1 = 2;
            messageObtain.setData(null);
            messenger.send(messageObtain);
        } catch (RemoteException unused) {
            Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=".concat(str));
        }
    }
}

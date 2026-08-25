package p173q1;

import android.media.MediaRouter2;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

public final class C3426m extends AbstractC3397c0 {

    public final String f11579a;

    public final C3423l f11580b;

    public C3426m(String str, C3423l c3423l) {
        this.f11579a = str;
        this.f11580b = c3423l;
    }

    @Override
    public final void mo6894g(int i6) {
        C3423l c3423l;
        MediaRouter2.RoutingController routingController;
        Messenger messenger;
        String str = this.f11579a;
        if (str == null || (c3423l = this.f11580b) == null || (routingController = c3423l.f11557g) == null || routingController.isReleased() || (messenger = c3423l.f11558h) == null) {
            return;
        }
        int andIncrement = c3423l.f11562l.getAndIncrement();
        Message messageObtain = Message.obtain();
        messageObtain.what = 7;
        messageObtain.arg1 = andIncrement;
        Bundle bundle = new Bundle();
        bundle.putInt("volume", i6);
        bundle.putString("routeId", str);
        messageObtain.setData(bundle);
        messageObtain.replyTo = c3423l.f11559i;
        try {
            messenger.send(messageObtain);
        } catch (DeadObjectException unused) {
        } catch (RemoteException e5) {
            Log.e("MR2Provider", "Could not send control request to service.", e5);
        }
    }

    @Override
    public final void mo6895j(int i6) {
        C3423l c3423l;
        MediaRouter2.RoutingController routingController;
        Messenger messenger;
        String str = this.f11579a;
        if (str == null || (c3423l = this.f11580b) == null || (routingController = c3423l.f11557g) == null || routingController.isReleased() || (messenger = c3423l.f11558h) == null) {
            return;
        }
        int andIncrement = c3423l.f11562l.getAndIncrement();
        Message messageObtain = Message.obtain();
        messageObtain.what = 8;
        messageObtain.arg1 = andIncrement;
        Bundle bundle = new Bundle();
        bundle.putInt("volume", i6);
        bundle.putString("routeId", str);
        messageObtain.setData(bundle);
        messageObtain.replyTo = c3423l.f11559i;
        try {
            messenger.send(messageObtain);
        } catch (DeadObjectException unused) {
        } catch (RemoteException e5) {
            Log.e("MR2Provider", "Could not send control request to service.", e5);
        }
    }
}

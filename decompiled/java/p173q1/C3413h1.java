package p173q1;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import androidx.appcompat.app.HandlerC0132f;

public final class C3413h1 implements IBinder.DeathRecipient {

    public final Messenger f11516a;

    public final HandlerC0132f f11517b;

    public final Messenger f11518c;

    public int f11521f;

    public int f11522g;

    public final ServiceConnectionC3428m1 f11524i;

    public int f11519d = 1;

    public int f11520e = 1;

    public final SparseArray f11523h = new SparseArray();

    public C3413h1(ServiceConnectionC3428m1 serviceConnectionC3428m1, Messenger messenger) {
        this.f11524i = serviceConnectionC3428m1;
        this.f11516a = messenger;
        HandlerC0132f handlerC0132f = new HandlerC0132f(this);
        this.f11517b = handlerC0132f;
        this.f11518c = new Messenger(handlerC0132f);
    }

    public final void m6954a(int i6) {
        int i10 = this.f11519d;
        this.f11519d = i10 + 1;
        m6955b(5, i10, i6, null, null);
    }

    public final boolean m6955b(int i6, int i10, int i11, Object obj, Bundle bundle) {
        Message messageObtain = Message.obtain();
        messageObtain.what = i6;
        messageObtain.arg1 = i10;
        messageObtain.arg2 = i11;
        messageObtain.obj = obj;
        messageObtain.setData(bundle);
        messageObtain.replyTo = this.f11518c;
        try {
            this.f11516a.send(messageObtain);
            return true;
        } catch (DeadObjectException unused) {
            return false;
        } catch (RemoteException e5) {
            if (i6 == 2) {
                return false;
            }
            Log.e("MediaRouteProviderProxy", "Could not send message to service.", e5);
            return false;
        }
    }

    @Override
    public final void binderDied() {
        this.f11524i.f11583j.post(new RunnableC3410g1(this, 1));
    }

    public final void m6956c(int i6, int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt("volume", i10);
        int i11 = this.f11519d;
        this.f11519d = i11 + 1;
        m6955b(7, i11, i6, null, bundle);
    }

    public final void m6957d(int i6, int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt("volume", i10);
        int i11 = this.f11519d;
        this.f11519d = i11 + 1;
        m6955b(8, i11, i6, null, bundle);
    }
}

package p018b5;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.AbstractC1500a;
import com.google.android.gms.internal.cast.HandlerC1731y0;
import p000a.AbstractC0004e;
import p261y4.InterfaceC4260h;

public final class HandlerC1314n extends HandlerC1731y0 {

    public final AbstractC1500a f4102b;

    public HandlerC1314n(AbstractC1500a abstractC1500a, Looper looper) {
        super(looper, 5);
        this.f4102b = abstractC1500a;
    }

    @Override
    public final void handleMessage(Message message) {
        Boolean bool;
        if (this.f4102b.f5091w.get() != message.arg1) {
            int i6 = message.what;
            if (i6 == 2 || i6 == 1 || i6 == 7) {
                AbstractC1309i abstractC1309i = (AbstractC1309i) message.obj;
                abstractC1309i.getClass();
                abstractC1309i.m3190d();
                return;
            }
            return;
        }
        int i10 = message.what;
        if (i10 != 1 && i10 != 7) {
            if (i10 == 4) {
                this.f4102b.getClass();
            } else if (i10 == 5) {
            }
            if (!this.f4102b.mo3652e()) {
                AbstractC1309i abstractC1309i2 = (AbstractC1309i) message.obj;
                abstractC1309i2.getClass();
                abstractC1309i2.m3190d();
                return;
            }
        } else if (!this.f4102b.mo3652e()) {
            AbstractC1309i abstractC1309i3 = (AbstractC1309i) message.obj;
            abstractC1309i3.getClass();
            abstractC1309i3.m3190d();
            return;
        }
        int i11 = message.what;
        if (i11 == 4) {
            AbstractC1500a abstractC1500a = this.f4102b;
            abstractC1500a.f5088t = new ConnectionResult(message.arg2);
            if (!abstractC1500a.f5089u && !TextUtils.isEmpty(abstractC1500a.mo3664q()) && !TextUtils.isEmpty(null)) {
                try {
                    Class.forName(abstractC1500a.mo3664q());
                    AbstractC1500a abstractC1500a2 = this.f4102b;
                    if (!abstractC1500a2.f5089u) {
                        abstractC1500a2.m3670y(3, null);
                        return;
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
            AbstractC1500a abstractC1500a3 = this.f4102b;
            ConnectionResult connectionResult = abstractC1500a3.f5088t;
            if (connectionResult == null) {
                connectionResult = new ConnectionResult(8);
            }
            abstractC1500a3.f5078j.mo48a(connectionResult);
            this.f4102b.mo3667t(connectionResult);
            return;
        }
        if (i11 == 5) {
            AbstractC1500a abstractC1500a4 = this.f4102b;
            ConnectionResult connectionResult2 = abstractC1500a4.f5088t;
            if (connectionResult2 == null) {
                connectionResult2 = new ConnectionResult(8);
            }
            abstractC1500a4.f5078j.mo48a(connectionResult2);
            this.f4102b.mo3667t(connectionResult2);
            return;
        }
        if (i11 == 3) {
            Object obj = message.obj;
            ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            this.f4102b.f5078j.mo48a(connectionResult3);
            this.f4102b.mo3667t(connectionResult3);
            return;
        }
        if (i11 == 6) {
            this.f4102b.m3670y(5, null);
            C1304d c1304d = this.f4102b.f5083o;
            if (c1304d != null) {
                ((InterfaceC4260h) c1304d.f4084a).mo8307g(message.arg2);
            }
            this.f4102b.getClass();
            System.currentTimeMillis();
            AbstractC1500a.m3648x(this.f4102b, 5, 1, null);
            return;
        }
        if (i11 == 2 && !this.f4102b.isConnected()) {
            AbstractC1309i abstractC1309i4 = (AbstractC1309i) message.obj;
            abstractC1309i4.getClass();
            abstractC1309i4.m3190d();
            return;
        }
        int i12 = message.what;
        if (i12 != 2 && i12 != 1 && i12 != 7) {
            Log.wtf("GmsClient", AbstractC0004e.m20n(i12, "Don't know how to handle message: "), new Exception());
            return;
        }
        AbstractC1309i abstractC1309i5 = (AbstractC1309i) message.obj;
        synchronized (abstractC1309i5) {
            try {
                bool = abstractC1309i5.f4091a;
                if (abstractC1309i5.f4092b) {
                    Log.w("GmsClient", "Callback proxy " + abstractC1309i5.toString() + " being reused. This is not safe.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bool != null) {
            AbstractC1500a abstractC1500a5 = abstractC1309i5.f4096f;
            int i13 = abstractC1309i5.f4094d;
            if (i13 != 0) {
                abstractC1500a5.m3670y(1, null);
                Bundle bundle = abstractC1309i5.f4095e;
                abstractC1309i5.mo3187a(new ConnectionResult(i13, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
            } else if (!abstractC1309i5.mo3188b()) {
                abstractC1500a5.m3670y(1, null);
                abstractC1309i5.mo3187a(new ConnectionResult(8, null));
            }
        }
        synchronized (abstractC1309i5) {
            abstractC1309i5.f4092b = true;
        }
        abstractC1309i5.m3190d();
    }
}

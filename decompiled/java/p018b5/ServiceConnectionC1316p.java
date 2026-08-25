package p018b5;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.internal.AbstractC1500a;

public final class ServiceConnectionC1316p implements ServiceConnection {

    public final int f4105a;

    public final AbstractC1500a f4106b;

    public ServiceConnectionC1316p(AbstractC1500a abstractC1500a, int i6) {
        this.f4106b = abstractC1500a;
        this.f4105a = i6;
    }

    @Override
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AbstractC1500a abstractC1500a = this.f4106b;
        if (iBinder == null) {
            AbstractC1500a.m3647w(abstractC1500a);
            return;
        }
        synchronized (abstractC1500a.f5076h) {
            try {
                AbstractC1500a abstractC1500a2 = this.f4106b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                abstractC1500a2.f5077i = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof C1311k)) ? new C1311k(iBinder) : (C1311k) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        AbstractC1500a abstractC1500a3 = this.f4106b;
        int i6 = this.f4105a;
        abstractC1500a3.getClass();
        C1318r c1318r = new C1318r(abstractC1500a3, 0, null);
        HandlerC1314n handlerC1314n = abstractC1500a3.f5074f;
        handlerC1314n.sendMessage(handlerC1314n.obtainMessage(7, i6, -1, c1318r));
    }

    @Override
    public final void onServiceDisconnected(ComponentName componentName) {
        AbstractC1500a abstractC1500a;
        synchronized (this.f4106b.f5076h) {
            abstractC1500a = this.f4106b;
            abstractC1500a.f5077i = null;
        }
        int i6 = this.f4105a;
        HandlerC1314n handlerC1314n = abstractC1500a.f5074f;
        handlerC1314n.sendMessage(handlerC1314n.obtainMessage(6, i6, 1));
    }
}

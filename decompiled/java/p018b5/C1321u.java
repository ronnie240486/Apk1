package p018b5;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public final class C1321u implements Handler.Callback {

    public final C1322v f4121a;

    public C1321u(C1322v c1322v) {
        this.f4121a = c1322v;
    }

    @Override
    public final boolean handleMessage(Message message) {
        int i6 = message.what;
        if (i6 == 0) {
            synchronized (this.f4121a.f4125a) {
                try {
                    C1319s c1319s = (C1319s) message.obj;
                    ServiceConnectionC1320t serviceConnectionC1320t = (ServiceConnectionC1320t) this.f4121a.f4125a.get(c1319s);
                    if (serviceConnectionC1320t != null && serviceConnectionC1320t.f4114a.isEmpty()) {
                        if (serviceConnectionC1320t.f4116c) {
                            serviceConnectionC1320t.f4120g.f4127c.removeMessages(1, serviceConnectionC1320t.f4118e);
                            C1322v c1322v = serviceConnectionC1320t.f4120g;
                            c1322v.f4128d.m5747a(c1322v.f4126b, serviceConnectionC1320t);
                            serviceConnectionC1320t.f4116c = false;
                            serviceConnectionC1320t.f4115b = 2;
                        }
                        this.f4121a.f4125a.remove(c1319s);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }
        if (i6 != 1) {
            return false;
        }
        synchronized (this.f4121a.f4125a) {
            try {
                C1319s c1319s2 = (C1319s) message.obj;
                ServiceConnectionC1320t serviceConnectionC1320t2 = (ServiceConnectionC1320t) this.f4121a.f4125a.get(c1319s2);
                if (serviceConnectionC1320t2 != null && serviceConnectionC1320t2.f4115b == 3) {
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback ".concat(String.valueOf(c1319s2)), new Exception());
                    ComponentName componentName = serviceConnectionC1320t2.f4119f;
                    if (componentName == null) {
                        c1319s2.getClass();
                        componentName = null;
                    }
                    if (componentName == null) {
                        String str = c1319s2.f4112b;
                        AbstractC1312l.m3198e(str);
                        componentName = new ComponentName(str, "unknown");
                    }
                    serviceConnectionC1320t2.onServiceDisconnected(componentName);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return true;
    }
}

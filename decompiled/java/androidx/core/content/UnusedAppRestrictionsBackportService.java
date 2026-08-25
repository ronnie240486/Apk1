package androidx.core.content;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import p034d0.BinderC2122h;

public abstract class UnusedAppRestrictionsBackportService extends Service {

    public final BinderC2122h f1605a = new BinderC2122h(this);

    public abstract void m1083a();

    @Override
    public final IBinder onBind(Intent intent) {
        return this.f1605a;
    }
}

package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import p002a1.C0026b;
import p103j9.AbstractC2796i;

public class LifecycleService extends Service implements InterfaceC0555w {

    public final C0026b f2457a = new C0026b(this);

    @Override
    public final AbstractC0541p mo360f() {
        return (C0559y) this.f2457a.f54b;
    }

    @Override
    public final IBinder onBind(Intent intent) {
        AbstractC2796i.m5785f(intent, "intent");
        this.f2457a.m119E(EnumC0537n.ON_START);
        return null;
    }

    @Override
    public final void onCreate() {
        this.f2457a.m119E(EnumC0537n.ON_CREATE);
        super.onCreate();
    }

    @Override
    public final void onDestroy() {
        EnumC0537n enumC0537n = EnumC0537n.ON_STOP;
        C0026b c0026b = this.f2457a;
        c0026b.m119E(enumC0537n);
        c0026b.m119E(EnumC0537n.ON_DESTROY);
        super.onDestroy();
    }

    @Override
    public final void onStart(Intent intent, int i6) {
        this.f2457a.m119E(EnumC0537n.ON_START);
        super.onStart(intent, i6);
    }
}

package p018b5;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.zax;
import java.util.concurrent.atomic.AtomicBoolean;
import p000a.AbstractC0004e;
import p132m5.BinderC3079b;
import p132m5.C3080c;
import p231v5.C4010a;
import p249x4.AbstractC4111d;
import p261y4.InterfaceC4261i;

public final class C1304d implements InterfaceC1302b {

    public static C1304d f4081b;

    public static final RootTelemetryConfiguration f4082c = new RootTelemetryConfiguration(0, false, false, 0, 0);

    public static final C1304d f4083d = new C1304d();

    public Object f4084a;

    public C1304d(Object obj) {
        this.f4084a = obj;
    }

    public static synchronized C1304d m3176b() {
        try {
            if (f4081b == null) {
                f4081b = new C1304d();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f4081b;
    }

    public static View m3177e(Context context, int i6, int i10) throws C3080c {
        C1304d c1304d = f4083d;
        try {
            zax zaxVar = new zax(1, i6, i10, null);
            return (View) BinderC3079b.m6112y(((C1308h) c1304d.m3179d(context)).m3186z(new BinderC3079b(context), zaxVar));
        } catch (Exception e5) {
            throw new C3080c(AbstractC0004e.m19m(i6, i10, "Could not get button with size ", " and color "), e5);
        }
    }

    @Override
    public void mo48a(ConnectionResult connectionResult) {
        boolean z7 = connectionResult.f4971b == 0;
        C4010a c4010a = (C4010a) this.f4084a;
        if (z7) {
            c4010a.mo3650b(null, c4010a.f5092x);
            return;
        }
        C1304d c1304d = c4010a.f5084p;
        if (c1304d != null) {
            ((InterfaceC4261i) c1304d.f4084a).mo8308l(connectionResult);
        }
    }

    public C1308h m3178c(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        return iInterfaceQueryLocalInterface instanceof C1308h ? (C1308h) iInterfaceQueryLocalInterface : new C1308h(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator", 1);
    }

    public Object m3179d(Context context) throws C3080c {
        Context contextCreatePackageContext;
        if (((C1308h) this.f4084a) == null) {
            AbstractC1312l.m3198e(context);
            AtomicBoolean atomicBoolean = AbstractC4111d.f13936a;
            try {
                contextCreatePackageContext = context.createPackageContext("com.google.android.gms", 3);
            } catch (PackageManager.NameNotFoundException unused) {
                contextCreatePackageContext = null;
            }
            if (contextCreatePackageContext == null) {
                throw new C3080c("Could not get remote context.");
            }
            try {
                this.f4084a = m3178c((IBinder) contextCreatePackageContext.getClassLoader().loadClass("com.google.android.gms.common.ui.SignInButtonCreatorImpl").newInstance());
            } catch (ClassNotFoundException e5) {
                throw new C3080c("Could not load creator class.", e5);
            } catch (IllegalAccessException e10) {
                throw new C3080c("Could not access creator.", e10);
            } catch (InstantiationException e11) {
                throw new C3080c("Could not instantiate creator.", e11);
            }
        }
        return (C1308h) this.f4084a;
    }
}

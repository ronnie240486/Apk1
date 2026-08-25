package p271z4;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.internal.cast.HandlerC1731y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ComponentCallbacks2C4332c implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    public static final ComponentCallbacks2C4332c f14689e = new ComponentCallbacks2C4332c();

    public final AtomicBoolean f14690a = new AtomicBoolean();

    public final AtomicBoolean f14691b = new AtomicBoolean();

    public final ArrayList f14692c = new ArrayList();

    public boolean f14693d = false;

    public final void m8356a(C4342m c4342m) {
        synchronized (f14689e) {
            this.f14692c.add(c4342m);
        }
    }

    public final void m8357b(boolean z7) {
        synchronized (f14689e) {
            try {
                Iterator it = this.f14692c.iterator();
                while (it.hasNext()) {
                    HandlerC1731y0 handlerC1731y0 = ((C4342m) it.next()).f14719a.f14710m;
                    handlerC1731y0.sendMessage(handlerC1731y0.obtainMessage(1, Boolean.valueOf(z7)));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AtomicBoolean atomicBoolean = this.f14691b;
        boolean zCompareAndSet = this.f14690a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (zCompareAndSet) {
            m8357b(false);
        }
    }

    @Override
    public final void onActivityResumed(Activity activity) {
        AtomicBoolean atomicBoolean = this.f14691b;
        boolean zCompareAndSet = this.f14690a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (zCompareAndSet) {
            m8357b(false);
        }
    }

    @Override
    public final void onTrimMemory(int i6) {
        if (i6 == 20 && this.f14690a.compareAndSet(false, true)) {
            this.f14691b.set(true);
            m8357b(true);
        }
    }

    @Override
    public final void onLowMemory() {
    }

    @Override
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override
    public final void onActivityPaused(Activity activity) {
    }

    @Override
    public final void onActivityStarted(Activity activity) {
    }

    @Override
    public final void onActivityStopped(Activity activity) {
    }

    @Override
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}

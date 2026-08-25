package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import p004a3.RunnableC0038c;

public final class C0322d implements Application.ActivityLifecycleCallbacks {

    public Object f1487a;

    public Activity f1488b;

    public final int f1489c;

    public boolean f1490d = false;

    public boolean f1491e = false;

    public boolean f1492f = false;

    public C0322d(Activity activity) {
        this.f1488b = activity;
        this.f1489c = activity.hashCode();
    }

    @Override
    public final void onActivityDestroyed(Activity activity) {
        if (this.f1488b == activity) {
            this.f1488b = null;
            this.f1491e = true;
        }
    }

    @Override
    public final void onActivityPaused(Activity activity) {
        if (!this.f1491e || this.f1492f || this.f1490d) {
            return;
        }
        Object obj = this.f1487a;
        try {
            Object obj2 = AbstractC0324e.f1495c.get(activity);
            if (obj2 == obj && activity.hashCode() == this.f1489c) {
                AbstractC0324e.f1499g.postAtFrontOfQueue(new RunnableC0038c(4, AbstractC0324e.f1494b.get(activity), obj2, false));
                this.f1492f = true;
                this.f1487a = null;
            }
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
        }
    }

    @Override
    public final void onActivityStarted(Activity activity) {
        if (this.f1488b == activity) {
            this.f1490d = true;
        }
    }

    @Override
    public final void onActivityResumed(Activity activity) {
    }

    @Override
    public final void onActivityStopped(Activity activity) {
    }

    @Override
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}

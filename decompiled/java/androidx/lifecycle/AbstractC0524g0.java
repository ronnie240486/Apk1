package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import p103j9.AbstractC2796i;

public abstract class AbstractC0524g0 {
    public static final void m1494a(Activity activity, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        AbstractC2796i.m5785f(activity, "activity");
        AbstractC2796i.m5785f(activityLifecycleCallbacks, "callback");
        activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }
}

package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import p103j9.AbstractC2796i;

public abstract class AbstractC0525h implements Application.ActivityLifecycleCallbacks {
    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        AbstractC2796i.m5785f(activity, "activity");
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        AbstractC2796i.m5785f(activity, "activity");
    }

    @Override
    public void onActivityPaused(Activity activity) {
        AbstractC2796i.m5785f(activity, "activity");
    }

    @Override
    public void onActivityResumed(Activity activity) {
        AbstractC2796i.m5785f(activity, "activity");
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        AbstractC2796i.m5785f(activity, "activity");
        AbstractC2796i.m5785f(bundle, "outState");
    }

    @Override
    public void onActivityStarted(Activity activity) {
        AbstractC2796i.m5785f(activity, "activity");
    }

    @Override
    public void onActivityStopped(Activity activity) {
        AbstractC2796i.m5785f(activity, "activity");
    }
}

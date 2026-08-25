package p061f8;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import p009aa.C0083c;
import p103j9.AbstractC2796i;

public final class C2503c implements Application.ActivityLifecycleCallbacks {

    public final C0083c f8737a;

    public C2503c(C0083c c0083c) {
        this.f8737a = c0083c;
    }

    @Override
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AbstractC2796i.m5786g(activity, "activity");
        this.f8737a.invoke(activity);
    }

    @Override
    public final void onActivityDestroyed(Activity activity) {
        AbstractC2796i.m5786g(activity, "activity");
    }

    @Override
    public final void onActivityPaused(Activity activity) {
        AbstractC2796i.m5786g(activity, "activity");
    }

    @Override
    public final void onActivityResumed(Activity activity) {
        AbstractC2796i.m5786g(activity, "activity");
    }

    @Override
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        AbstractC2796i.m5786g(activity, "activity");
        AbstractC2796i.m5786g(bundle, "outState");
    }

    @Override
    public final void onActivityStarted(Activity activity) {
        AbstractC2796i.m5786g(activity, "activity");
    }

    @Override
    public final void onActivityStopped(Activity activity) {
        AbstractC2796i.m5786g(activity, "activity");
    }
}

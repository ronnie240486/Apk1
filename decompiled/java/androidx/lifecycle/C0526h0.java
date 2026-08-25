package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import p103j9.AbstractC2796i;

public final class C0526h0 extends AbstractC0525h {
    final C0528i0 this$0;

    public static final class a extends AbstractC0525h {
        final C0528i0 this$0;

        public a(C0528i0 c0528i0) {
            this.this$0 = c0528i0;
        }

        @Override
        public void onActivityPostResumed(Activity activity) {
            AbstractC2796i.m5785f(activity, "activity");
            this.this$0.m1495b();
        }

        @Override
        public void onActivityPostStarted(Activity activity) {
            AbstractC2796i.m5785f(activity, "activity");
            C0528i0 c0528i0 = this.this$0;
            int i6 = c0528i0.f2487a + 1;
            c0528i0.f2487a = i6;
            if (i6 == 1 && c0528i0.f2490d) {
                c0528i0.f2492f.m1521f(EnumC0537n.ON_START);
                c0528i0.f2490d = false;
            }
        }
    }

    public C0526h0(C0528i0 c0528i0) {
        this.this$0 = c0528i0;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        AbstractC2796i.m5785f(activity, "activity");
        if (Build.VERSION.SDK_INT < 29) {
            int i6 = FragmentC0534l0.f2495b;
            Fragment fragmentFindFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            AbstractC2796i.m5783d(fragmentFindFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            ((FragmentC0534l0) fragmentFindFragmentByTag).f2496a = this.this$0.f2494h;
        }
    }

    @Override
    public void onActivityPaused(Activity activity) {
        AbstractC2796i.m5785f(activity, "activity");
        C0528i0 c0528i0 = this.this$0;
        int i6 = c0528i0.f2488b - 1;
        c0528i0.f2488b = i6;
        if (i6 == 0) {
            Handler handler = c0528i0.f2491e;
            AbstractC2796i.m5782c(handler);
            handler.postDelayed(c0528i0.f2493g, 700L);
        }
    }

    @Override
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        AbstractC2796i.m5785f(activity, "activity");
        AbstractC0524g0.m1494a(activity, new a(this.this$0));
    }

    @Override
    public void onActivityStopped(Activity activity) {
        AbstractC2796i.m5785f(activity, "activity");
        C0528i0 c0528i0 = this.this$0;
        int i6 = c0528i0.f2487a - 1;
        c0528i0.f2487a = i6;
        if (i6 == 0 && c0528i0.f2489c) {
            c0528i0.f2492f.m1521f(EnumC0537n.ON_STOP);
            c0528i0.f2490d = true;
        }
    }
}

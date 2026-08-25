package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import p001a0.C0019b;
import p103j9.AbstractC2796i;

public class FragmentC0534l0 extends Fragment {

    public static final int f2495b = 0;

    public C0019b f2496a;

    public static final class a implements Application.ActivityLifecycleCallbacks {
        public static final C0532k0 Companion = new C0532k0();

        public static final void registerIn(Activity activity) {
            Companion.getClass();
            AbstractC2796i.m5785f(activity, "activity");
            activity.registerActivityLifecycleCallbacks(new a());
        }

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
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            AbstractC2796i.m5785f(activity, "activity");
            int i6 = FragmentC0534l0.f2495b;
            AbstractC0530j0.m1496a(activity, EnumC0537n.ON_CREATE);
        }

        @Override
        public void onActivityPostResumed(Activity activity) {
            AbstractC2796i.m5785f(activity, "activity");
            int i6 = FragmentC0534l0.f2495b;
            AbstractC0530j0.m1496a(activity, EnumC0537n.ON_RESUME);
        }

        @Override
        public void onActivityPostStarted(Activity activity) {
            AbstractC2796i.m5785f(activity, "activity");
            int i6 = FragmentC0534l0.f2495b;
            AbstractC0530j0.m1496a(activity, EnumC0537n.ON_START);
        }

        @Override
        public void onActivityPreDestroyed(Activity activity) {
            AbstractC2796i.m5785f(activity, "activity");
            int i6 = FragmentC0534l0.f2495b;
            AbstractC0530j0.m1496a(activity, EnumC0537n.ON_DESTROY);
        }

        @Override
        public void onActivityPrePaused(Activity activity) {
            AbstractC2796i.m5785f(activity, "activity");
            int i6 = FragmentC0534l0.f2495b;
            AbstractC0530j0.m1496a(activity, EnumC0537n.ON_PAUSE);
        }

        @Override
        public void onActivityPreStopped(Activity activity) {
            AbstractC2796i.m5785f(activity, "activity");
            int i6 = FragmentC0534l0.f2495b;
            AbstractC0530j0.m1496a(activity, EnumC0537n.ON_STOP);
        }

        @Override
        public void onActivityResumed(Activity activity) {
            AbstractC2796i.m5785f(activity, "activity");
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            AbstractC2796i.m5785f(activity, "activity");
            AbstractC2796i.m5785f(bundle, "bundle");
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

    public final void m1499a(EnumC0537n enumC0537n) {
        if (Build.VERSION.SDK_INT < 29) {
            Activity activity = getActivity();
            AbstractC2796i.m5784e(activity, "activity");
            AbstractC0530j0.m1496a(activity, enumC0537n);
        }
    }

    @Override
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m1499a(EnumC0537n.ON_CREATE);
    }

    @Override
    public final void onDestroy() {
        super.onDestroy();
        m1499a(EnumC0537n.ON_DESTROY);
        this.f2496a = null;
    }

    @Override
    public final void onPause() {
        super.onPause();
        m1499a(EnumC0537n.ON_PAUSE);
    }

    @Override
    public final void onResume() {
        super.onResume();
        C0019b c0019b = this.f2496a;
        if (c0019b != null) {
            ((C0528i0) c0019b.f38b).m1495b();
        }
        m1499a(EnumC0537n.ON_RESUME);
    }

    @Override
    public final void onStart() {
        super.onStart();
        C0019b c0019b = this.f2496a;
        if (c0019b != null) {
            C0528i0 c0528i0 = (C0528i0) c0019b.f38b;
            int i6 = c0528i0.f2487a + 1;
            c0528i0.f2487a = i6;
            if (i6 == 1 && c0528i0.f2490d) {
                c0528i0.f2492f.m1521f(EnumC0537n.ON_START);
                c0528i0.f2490d = false;
            }
        }
        m1499a(EnumC0537n.ON_START);
    }

    @Override
    public final void onStop() {
        super.onStop();
        m1499a(EnumC0537n.ON_STOP);
    }
}

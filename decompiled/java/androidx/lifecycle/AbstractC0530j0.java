package androidx.lifecycle;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;
import p103j9.AbstractC2796i;

public abstract class AbstractC0530j0 {
    public static void m1496a(Activity activity, EnumC0537n enumC0537n) {
        AbstractC2796i.m5785f(activity, "activity");
        AbstractC2796i.m5785f(enumC0537n, "event");
        if (activity instanceof InterfaceC0555w) {
            AbstractC0541p abstractC0541pMo360f = ((InterfaceC0555w) activity).mo360f();
            if (abstractC0541pMo360f instanceof C0559y) {
                ((C0559y) abstractC0541pMo360f).m1521f(enumC0537n);
            }
        }
    }

    public static void m1497b(Activity activity) {
        AbstractC2796i.m5785f(activity, "activity");
        if (Build.VERSION.SDK_INT >= 29) {
            FragmentC0534l0.a.Companion.getClass();
            activity.registerActivityLifecycleCallbacks(new FragmentC0534l0.a());
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new FragmentC0534l0(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }
}

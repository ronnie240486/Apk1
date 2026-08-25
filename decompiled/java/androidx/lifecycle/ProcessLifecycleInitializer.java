package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import java.util.List;
import p103j9.AbstractC2796i;
import p238w1.C4046a;
import p238w1.InterfaceC4047b;
import p253x8.C4155r;

public final class ProcessLifecycleInitializer implements InterfaceC4047b {
    @Override
    public final List mo1180a() {
        return C4155r.f14074a;
    }

    @Override
    public final Object mo1181b(Context context) {
        AbstractC2796i.m5785f(context, "context");
        C4046a c4046aM8050c = C4046a.m8050c(context);
        AbstractC2796i.m5784e(c4046aM8050c, "getInstance(context)");
        if (!c4046aM8050c.f13706b.contains(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
        }
        if (!AbstractC0549t.f2533a.getAndSet(true)) {
            Context applicationContext = context.getApplicationContext();
            AbstractC2796i.m5783d(applicationContext, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext).registerActivityLifecycleCallbacks(new C0547s());
        }
        C0528i0 c0528i0 = C0528i0.f2486i;
        c0528i0.getClass();
        c0528i0.f2491e = new Handler();
        c0528i0.f2492f.m1521f(EnumC0537n.ON_CREATE);
        Context applicationContext2 = context.getApplicationContext();
        AbstractC2796i.m5783d(applicationContext2, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext2).registerActivityLifecycleCallbacks(new C0526h0(c0528i0));
        return c0528i0;
    }
}

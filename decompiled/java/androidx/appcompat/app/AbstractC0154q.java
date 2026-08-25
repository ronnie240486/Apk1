package androidx.appcompat.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import p094j0.C2761i;
import p160p.C3337a;
import p160p.C3342f;

public abstract class AbstractC0154q {

    public static final ExecutorC0149n0 f415a = new ExecutorC0149n0(new ExecutorC0151o0());

    public static final int f416b = -100;

    public static C2761i f417c = null;

    public static C2761i f418d = null;

    public static Boolean f419e = null;

    public static boolean f420f = false;

    public static final C3342f f421g = new C3342f(0);

    public static final Object f422h = new Object();

    public static final Object f423i = new Object();

    public static boolean m437c(Context context) {
        if (f419e == null) {
            try {
                int i6 = AppLocalesMetadataHolderService.f254a;
                Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) AppLocalesMetadataHolderService.class), Build.VERSION.SDK_INT >= 24 ? AbstractC0145l0.m431a() | 128 : 640).metaData;
                if (bundle != null) {
                    f419e = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f419e = Boolean.FALSE;
            }
        }
        return f419e.booleanValue();
    }

    public static void m438f(LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0) {
        synchronized (f422h) {
            try {
                C3342f c3342f = f421g;
                c3342f.getClass();
                C3337a c3337a = new C3337a(c3342f);
                while (c3337a.hasNext()) {
                    AbstractC0154q abstractC0154q = (AbstractC0154q) ((WeakReference) c3337a.next()).get();
                    if (abstractC0154q == layoutInflaterFactory2C0135g0 || abstractC0154q == null) {
                        c3337a.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void mo393a();

    public abstract void mo394b();

    public abstract void mo395d();

    public abstract void mo396e();

    public abstract boolean mo397g(int i6);

    public abstract void mo398h(int i6);

    public abstract void mo399i(View view);

    public abstract void mo400k(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void mo401l(CharSequence charSequence);
}

package androidx.appcompat.app;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import androidx.media3.exoplayer.hls.offline.ExecutorC0785a;
import java.lang.ref.WeakReference;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p094j0.AbstractC2754b;
import p094j0.C2761i;
import p094j0.C2764l;
import p143n5.AbstractC3198d;
import p160p.C3337a;
import p160p.C3342f;
import p207t1.AbstractC3792d;

public final class RunnableC0148n implements Runnable {

    public final int f409a;

    public final Context f410b;

    public RunnableC0148n(Context context, int i6) {
        this.f409a = i6;
        this.f410b = context;
    }

    @Override
    public final void run() throws Throwable {
        C2761i c2761i;
        Object systemService;
        Context context;
        switch (this.f409a) {
            case 0:
                if (Build.VERSION.SDK_INT >= 33) {
                    Context context2 = this.f410b;
                    ComponentName componentName = new ComponentName(context2, "androidx.appcompat.app.AppLocalesMetadataHolderService");
                    if (context2.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                        if (AbstractC2754b.m5721a()) {
                            C3342f c3342f = AbstractC0154q.f421g;
                            c3342f.getClass();
                            C3337a c3337a = new C3337a(c3342f);
                            while (true) {
                                if (c3337a.hasNext()) {
                                    AbstractC0154q abstractC0154q = (AbstractC0154q) ((WeakReference) c3337a.next()).get();
                                    if (abstractC0154q != null && (context = ((LayoutInflaterFactory2C0135g0) abstractC0154q).f341k) != null) {
                                        systemService = context.getSystemService("locale");
                                    }
                                } else {
                                    systemService = null;
                                }
                            }
                            if (systemService != null) {
                                c2761i = new C2761i(new C2764l(AbstractC0152p.m434a(systemService)));
                            } else {
                                c2761i = C2761i.f9474b;
                            }
                        } else {
                            c2761i = AbstractC0154q.f417c;
                            if (c2761i == null) {
                                c2761i = C2761i.f9474b;
                            }
                        }
                        if (c2761i.f9475a.isEmpty()) {
                            String strM6437L = AbstractC3198d.m6437L(context2);
                            Object systemService2 = context2.getSystemService("locale");
                            if (systemService2 != null) {
                                AbstractC0152p.m435b(systemService2, AbstractC0150o.m433a(strM6437L));
                            }
                        }
                        context2.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
                    }
                }
                AbstractC0154q.f420f = true;
                break;
            case 1:
                new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new RunnableC0148n(this.f410b, 2));
                break;
            default:
                AbstractC3792d.m7560s(this.f410b, new ExecutorC0785a(), AbstractC3792d.f12774a, false);
                break;
        }
    }
}

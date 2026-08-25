package p000a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Trace;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AbstractDialogC0139i0;
import androidx.core.app.AbstractC0324e;
import androidx.core.app.C0322d;
import androidx.lifecycle.C0528i0;
import androidx.lifecycle.C0559y;
import androidx.lifecycle.EnumC0537n;
import androidx.media3.common.C0628x;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;
import androidx.media3.exoplayer.smoothstreaming.SsMediaSource;
import androidx.media3.exoplayer.source.preload.DefaultPreloadManager;
import com.bumptech.glide.AbstractC1465c;
import com.tencent.mars.xlog.Log;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.util.concurrent.TimeUnit;
import la.RunnableC3015b;
import la.ViewOnClickListenerC3017d;
import okhttp3.Request;
import org.bitspark.android.Spark;
import org.bitspark.android.utils.AbstractC3329k;
import org.bitspark.android.utils.AbstractC3331m;
import org.bitspark.android.utils.C3334p;
import org.bitspark.android.utils.C3335q;
import p001a0.C0023f;
import p003a2.AbstractC0032a;
import p004a3.RunnableC0038c;
import p014b1.C1241o;
import p056f0.AbstractC2484g;
import p077h4.C2660j;
import p087i4.C2702g;
import p094j0.AbstractC2766n;
import p101j7.C2782c;
import p103j9.AbstractC2796i;
import p106k0.C2859g;
import p116ka.RunnableC2942w;
import p116ka.ViewOnKeyListenerC2944y;
import p143n5.AbstractC3198d;
import p173q1.C3411h;
import p173q1.C3423l;
import p173q1.C3439q0;
import p249x4.C4112e;

public final class RunnableC0001b implements Runnable {

    public final int f0a;

    public final Object f1b;

    public RunnableC0001b(int i6, Object obj) {
        this.f0a = i6;
        this.f1b = obj;
    }

    @Override
    public final void run() {
        Object obj;
        int i6 = 2;
        boolean z7 = false;
        switch (this.f0a) {
            case 0:
                ((ComponentActivity) this.f1b).invalidateOptionsMenu();
                return;
            case 1:
                AbstractDialogC0139i0.m418b((AbstractDialogC0139i0) this.f1b);
                return;
            case 2:
                ((C0016q) this.f1b).m50c();
                return;
            case 3:
                Activity activity = (Activity) this.f1b;
                if (activity.isFinishing()) {
                    return;
                }
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 28) {
                    Class cls = AbstractC0324e.f1493a;
                    activity.recreate();
                    return;
                }
                Class cls2 = AbstractC0324e.f1493a;
                boolean z10 = i10 == 26 || i10 == 27;
                Method method = AbstractC0324e.f1498f;
                if ((!z10 || method != null) && (AbstractC0324e.f1497e != null || AbstractC0324e.f1496d != null)) {
                    try {
                        Object obj2 = AbstractC0324e.f1495c.get(activity);
                        if (obj2 != null && (obj = AbstractC0324e.f1494b.get(activity)) != null) {
                            Application application = activity.getApplication();
                            C0322d c0322d = new C0322d(activity);
                            application.registerActivityLifecycleCallbacks(c0322d);
                            Handler handler = AbstractC0324e.f1499g;
                            handler.post(new RunnableC0038c(i6, c0322d, obj2, z7));
                            try {
                                if (i10 == 26 || i10 == 27) {
                                    Boolean bool = Boolean.FALSE;
                                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                                } else {
                                    activity.recreate();
                                }
                                handler.post(new RunnableC0038c(3, application, c0322d, z7));
                                return;
                            } catch (Throwable th) {
                                handler.post(new RunnableC0038c(3, application, c0322d, z7));
                                throw th;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                activity.recreate();
                return;
            case 4:
                C0528i0 c0528i0 = (C0528i0) this.f1b;
                AbstractC2796i.m5785f(c0528i0, "this$0");
                int i11 = c0528i0.f2488b;
                C0559y c0559y = c0528i0.f2492f;
                if (i11 == 0) {
                    c0528i0.f2489c = true;
                    c0559y.m1521f(EnumC0537n.ON_PAUSE);
                }
                if (c0528i0.f2487a == 0 && c0528i0.f2489c) {
                    c0559y.m1521f(EnumC0537n.ON_STOP);
                    c0528i0.f2490d = true;
                    return;
                }
                return;
            case 5:
                ((DefaultAnalyticsCollector) this.f1b).releaseInternal();
                return;
            case 6:
                ((SsMediaSource) this.f1b).startLoadingManifest();
                return;
            case 7:
                ((DefaultPreloadManager) this.f1b).lambda$releaseInternal$1();
                return;
            case 8:
                C1241o c1241o = (C1241o) this.f1b;
                synchronized (c1241o.f3950d) {
                    try {
                        if (c1241o.f3954h == null) {
                            return;
                        }
                        try {
                            C2859g c2859gM3122d = c1241o.m3122d();
                            int i12 = c2859gM3122d.f9786e;
                            if (i12 == 2) {
                                synchronized (c1241o.f3950d) {
                                }
                            }
                            if (i12 != 0) {
                                throw new RuntimeException("fetchFonts result is not OK. (" + i12 + ")");
                            }
                            try {
                                Method method2 = AbstractC2766n.f9481b;
                                Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                                C4112e c4112e = c1241o.f3949c;
                                Context context = c1241o.f3947a;
                                c4112e.getClass();
                                Typeface typefaceMo5526m = AbstractC2484g.f8688a.mo5526m(context, new C2859g[]{c2859gM3122d}, 0);
                                MappedByteBuffer mappedByteBufferM6429D = AbstractC3198d.m6429D(c1241o.f3947a, c2859gM3122d.f9782a);
                                if (mappedByteBufferM6429D == null || typefaceMo5526m == null) {
                                    throw new RuntimeException("Unable to open file.");
                                }
                                try {
                                    Trace.beginSection("EmojiCompat.MetadataRepo.create");
                                    C0023f c0023f = new C0023f(typefaceMo5526m, AbstractC1465c.m3476k(mappedByteBufferM6429D));
                                    Trace.endSection();
                                    Trace.endSection();
                                    synchronized (c1241o.f3950d) {
                                        try {
                                            AbstractC0032a abstractC0032a = c1241o.f3954h;
                                            if (abstractC0032a != null) {
                                                abstractC0032a.mo175I(c0023f);
                                            }
                                        } catch (Throwable th2) {
                                            throw th2;
                                        }
                                        break;
                                    }
                                    c1241o.m3120b();
                                    return;
                                } catch (Throwable th3) {
                                    Method method3 = AbstractC2766n.f9481b;
                                    Trace.endSection();
                                    throw th3;
                                }
                            } catch (Throwable th4) {
                                Method method4 = AbstractC2766n.f9481b;
                                Trace.endSection();
                                throw th4;
                            }
                            break;
                        } catch (Throwable th5) {
                            synchronized (c1241o.f3950d) {
                                try {
                                    AbstractC0032a abstractC0032a2 = c1241o.f3954h;
                                    if (abstractC0032a2 != null) {
                                        abstractC0032a2.mo174H(th5);
                                    }
                                    c1241o.m3120b();
                                    return;
                                } catch (Throwable th6) {
                                    throw th6;
                                }
                            }
                        }
                    } catch (Throwable th7) {
                        throw th7;
                    }
                }
            case 9:
                ((Spark) this.f1b).f11122j0.setVisibility(8);
                return;
            case 10:
                C2660j c2660j = (C2660j) this.f1b;
                c2660j.getClass();
                ((C2702g) c2660j.f9289d).m5700e(new C0628x(14, c2660j));
                return;
            case 11:
                String strM6748d = AbstractC3329k.m6748d(0L, 1L, false);
                C2782c c2782c = (C2782c) this.f1b;
                switch (c2782c.f9500a) {
                    case 6:
                        ViewOnKeyListenerC2944y viewOnKeyListenerC2944y = ((RunnableC2942w) c2782c.f9501b).f10028b;
                        viewOnKeyListenerC2944y.getClass();
                        viewOnKeyListenerC2944y.m5966Q(strM6748d);
                        return;
                    default:
                        ViewOnClickListenerC3017d viewOnClickListenerC3017d = ((RunnableC3015b) c2782c.f9501b).f10307b;
                        viewOnClickListenerC3017d.getClass();
                        viewOnClickListenerC3017d.m6093T(strM6748d);
                        return;
                }
            case 12:
                C3335q c3335q = (C3335q) this.f1b;
                c3335q.getClass();
                String str = C3335q.f11257d;
                try {
                    TimeUnit.SECONDS.sleep(6L);
                    String strM165s = AbstractC0032a.m165s("8BjZR57x9tTWFNRP3rG9\n", "on26KPCfk7c=\n");
                    boolean z11 = AbstractC3331m.f11244b;
                    Log.m5049i(str, strM165s);
                    String str2 = c3335q.f11260c;
                    c3335q.f11260c = str2;
                    c3335q.f11259b.newWebSocket(new Request.Builder().url(c3335q.f11258a).build(), new C3334p(c3335q, str2));
                    return;
                } catch (InterruptedException e5) {
                    String str3 = AbstractC0032a.m165s("sgzl2AbgspuUSe/ZHOulipUZ8tIMtPc=\n", "4GmGt2iO1/g=\n") + e5.getMessage();
                    boolean z12 = AbstractC3331m.f11244b;
                    Log.m5049i(str, str3);
                    return;
                }
            case 13:
                ((C3411h) this.f1b).m6945l();
                return;
            case 14:
                ((C3423l) this.f1b).f11564n = -1;
                return;
            default:
                ((C3439q0) this.f1b).m7017a();
                return;
        }
    }
}

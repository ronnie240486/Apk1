package p271z4;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseIntArray;
import androidx.media3.common.C0565C;
import androidx.media3.exoplayer.Renderer;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC1500a;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.internal.cast.HandlerC1731y0;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import p005a4.ExecutorC0059r;
import p007a7.C0069f;
import p018b5.C1304d;
import p018b5.C1322v;
import p039d5.C2155b;
import p109k3.C2888t;
import p123l5.AbstractC2973a;
import p156o9.AbstractC3281e;
import p160p.C3342f;
import p176q4.C3477d;
import p177q5.AbstractC3503c;
import p222u7.AbstractC3928d;
import p242w5.C4056d;
import p242w5.C4058f;
import p249x4.C4109b;
import p261y4.AbstractC4259g;
import p261y4.InterfaceC4255c;

public final class C4334e implements Handler.Callback {

    public static final Status f14694o = new Status(4, "Sign-out occurred while this API call was in progress.", null, null);

    public static final Status f14695p = new Status(4, "The user must be signed in to make this API call.", null, null);

    public static final Object f14696q = new Object();

    public static C4334e f14697r;

    public long f14698a;

    public boolean f14699b;

    public TelemetryData f14700c;

    public C2155b f14701d;

    public final Context f14702e;

    public final C4109b f14703f;

    public final C0069f f14704g;

    public final AtomicInteger f14705h;

    public final AtomicInteger f14706i;

    public final ConcurrentHashMap f14707j;

    public final C3342f f14708k;

    public final C3342f f14709l;

    public final HandlerC1731y0 f14710m;

    public volatile boolean f14711n;

    public C4334e(Context context, Looper looper) {
        C4109b c4109b = C4109b.f13933d;
        this.f14698a = Renderer.DEFAULT_DURATION_TO_PROGRESS_US;
        this.f14699b = false;
        this.f14705h = new AtomicInteger(1);
        this.f14706i = new AtomicInteger(0);
        this.f14707j = new ConcurrentHashMap(5, 0.75f, 1);
        this.f14708k = new C3342f(0);
        this.f14709l = new C3342f(0);
        this.f14711n = true;
        this.f14702e = context;
        HandlerC1731y0 handlerC1731y0 = new HandlerC1731y0(looper, this, 4);
        Looper.getMainLooper();
        this.f14710m = handlerC1731y0;
        this.f14703f = c4109b;
        this.f14704g = new C0069f(10);
        PackageManager packageManager = context.getPackageManager();
        if (AbstractC3281e.f10987d == null) {
            AbstractC3281e.f10987d = Boolean.valueOf(AbstractC3928d.m7856t() && packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        if (AbstractC3281e.f10987d.booleanValue()) {
            this.f14711n = false;
        }
        handlerC1731y0.sendMessage(handlerC1731y0.obtainMessage(6));
    }

    public static Status m8358c(C4331b c4331b, ConnectionResult connectionResult) {
        return new Status(17, "API: " + ((String) c4331b.f14686b.f10226c) + " is not available on this device. Connection failed with: " + String.valueOf(connectionResult), connectionResult.f4972c, connectionResult);
    }

    public static C4334e m8359f(Context context) {
        C4334e c4334e;
        synchronized (f14696q) {
            try {
                if (f14697r == null) {
                    Looper looper = C1322v.m3205a().getLooper();
                    Context applicationContext = context.getApplicationContext();
                    Object obj = C4109b.f13932c;
                    f14697r = new C4334e(applicationContext, looper);
                }
                c4334e = f14697r;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c4334e;
    }

    public final boolean m8360a() {
        if (this.f14699b) {
            return false;
        }
        RootTelemetryConfiguration rootTelemetryConfiguration = (RootTelemetryConfiguration) C1304d.m3176b().f4084a;
        if (rootTelemetryConfiguration != null && !rootTelemetryConfiguration.f5062b) {
            return false;
        }
        int i6 = ((SparseIntArray) this.f14704g.f196b).get(203400000, -1);
        return i6 == -1 || i6 == 0;
    }

    public final boolean m8361b(ConnectionResult connectionResult, int i6) {
        PendingIntent activity;
        boolean zBooleanValue;
        PendingIntent pendingIntent;
        Boolean bool;
        C4109b c4109b = this.f14703f;
        Context context = this.f14702e;
        c4109b.getClass();
        synchronized (AbstractC2973a.class) {
            try {
                Context applicationContext = context.getApplicationContext();
                Context context2 = AbstractC2973a.f10173a;
                activity = null;
                if (context2 == null || (bool = AbstractC2973a.f10174b) == null || context2 != applicationContext) {
                    AbstractC2973a.f10174b = null;
                    if (AbstractC3928d.m7856t()) {
                        AbstractC2973a.f10174b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
                    } else {
                        try {
                            context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                            AbstractC2973a.f10174b = Boolean.TRUE;
                        } catch (ClassNotFoundException unused) {
                            AbstractC2973a.f10174b = Boolean.FALSE;
                        }
                    }
                    AbstractC2973a.f10173a = applicationContext;
                    zBooleanValue = AbstractC2973a.f10174b.booleanValue();
                } else {
                    zBooleanValue = bool.booleanValue();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zBooleanValue) {
            return false;
        }
        int i10 = connectionResult.f4971b;
        if (i10 == 0 || (pendingIntent = connectionResult.f4972c) == null) {
            Intent intentM8128a = c4109b.m8128a(context, i10, null);
            if (intentM8128a != null) {
                activity = PendingIntent.getActivity(context, 0, intentM8128a, Build.VERSION.SDK_INT >= 23 ? 201326592 : C0565C.BUFFER_FLAG_FIRST_SAMPLE);
            }
            pendingIntent = activity;
        }
        if (pendingIntent == null) {
            return false;
        }
        int i11 = connectionResult.f4971b;
        int i12 = GoogleApiActivity.f4987b;
        Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i6);
        intent.putExtra("notify_manager", true);
        c4109b.m8126f(context, i11, PendingIntent.getActivity(context, 0, intent, AbstractC3503c.f11793a | C0565C.BUFFER_FLAG_FIRST_SAMPLE));
        return true;
    }

    public final C4343n m8362d(AbstractC4259g abstractC4259g) {
        ConcurrentHashMap concurrentHashMap = this.f14707j;
        C4331b c4331b = abstractC4259g.f14461e;
        C4343n c4343n = (C4343n) concurrentHashMap.get(c4331b);
        if (c4343n == null) {
            c4343n = new C4343n(this, abstractC4259g);
            concurrentHashMap.put(c4331b, c4343n);
        }
        if (c4343n.f14721d.mo3658k()) {
            this.f14709l.add(c4331b);
        }
        c4343n.m8377m();
        return c4343n;
    }

    public final void m8363e(C4056d c4056d, int i6, AbstractC4259g abstractC4259g) {
        C4347r c4347r;
        if (i6 != 0) {
            C4331b c4331b = abstractC4259g.f14461e;
            if (m8360a()) {
                RootTelemetryConfiguration rootTelemetryConfiguration = (RootTelemetryConfiguration) C1304d.m3176b().f4084a;
                boolean z7 = true;
                if (rootTelemetryConfiguration != null) {
                    if (rootTelemetryConfiguration.f5062b) {
                        C4343n c4343n = (C4343n) this.f14707j.get(c4331b);
                        if (c4343n != null) {
                            InterfaceC4255c interfaceC4255c = c4343n.f14721d;
                            if (interfaceC4255c instanceof AbstractC1500a) {
                                AbstractC1500a abstractC1500a = (AbstractC1500a) interfaceC4255c;
                                if (abstractC1500a.f5090v == null || abstractC1500a.mo3652e()) {
                                    z7 = rootTelemetryConfiguration.f5063c;
                                } else {
                                    ConnectionTelemetryConfiguration connectionTelemetryConfigurationM8389a = C4347r.m8389a(c4343n, abstractC1500a, i6);
                                    if (connectionTelemetryConfigurationM8389a != null) {
                                        c4343n.f14731n++;
                                        z7 = connectionTelemetryConfigurationM8389a.f5032c;
                                    }
                                }
                            }
                        } else {
                            z7 = rootTelemetryConfiguration.f5063c;
                        }
                    }
                    c4347r = null;
                }
                c4347r = new C4347r(this, i6, c4331b, z7 ? System.currentTimeMillis() : 0L, z7 ? SystemClock.elapsedRealtime() : 0L);
            } else {
                c4347r = null;
            }
            if (c4347r != null) {
                C3477d c3477d = c4056d.f13720a;
                HandlerC1731y0 handlerC1731y0 = this.f14710m;
                handlerC1731y0.getClass();
                ExecutorC0059r executorC0059r = new ExecutorC0059r(3, handlerC1731y0);
                c3477d.getClass();
                ((C2888t) c3477d.f11770c).m5891h(new C4058f(executorC0059r, c4347r));
                c3477d.m7134g();
            }
        }
    }

    public final void m8364g(ConnectionResult connectionResult, int i6) {
        if (m8361b(connectionResult, i6)) {
            return;
        }
        HandlerC1731y0 handlerC1731y0 = this.f14710m;
        handlerC1731y0.sendMessage(handlerC1731y0.obtainMessage(5, i6, 0, connectionResult));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r2v7 z4.n, still in use, count: 2, list:
          (r2v7 z4.n) from 0x03de: IGET (r2v7 z4.n) A[WRAPPED] (LINE:991) z4.n.i int
          (r2v7 z4.n) from 0x03e4: PHI (r2 I:??) = (r2v4 z4.n), (r2v7 z4.n) binds: [B:164:0x03e3, B:216:0x03e4] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    @Override
    public final boolean handleMessage(android.os.Message r13) {
        /*
            Method dump skipped, instruction units count: 1284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p271z4.C4334e.handleMessage(android.os.Message):boolean");
    }
}

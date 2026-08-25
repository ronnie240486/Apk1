package p004a3;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.app.AbstractC0324e;
import androidx.core.app.C0322d;
import androidx.fragment.app.C0412k0;
import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.framework.media.widget.ExpandedControllerActivity;
import com.google.android.gms.cast.internal.zza;
import com.google.android.gms.cast.internal.zzac;
import com.google.android.gms.cast.zzat;
import com.google.android.gms.internal.cast.C1602k0;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.textfield.C1864b;
import com.google.android.material.textfield.C1867e;
import com.google.android.material.textfield.C1871i;
import com.google.android.material.textfield.C1875m;
import com.google.android.material.textfield.C1879q;
import com.p2serv.android.p032ds.R;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.proguard.C2026ai;
import com.tencent.bugly.proguard.C2029al;
import com.tencent.bugly.proguard.C2034aq;
import com.tencent.bugly.proguard.C2042ay;
import com.tencent.bugly.proguard.C2099s;
import com.tencent.bugly.proguard.FileObserverC2085k0;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import ma.C3091a;
import na.C3222a;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.beans.VodMenu;
import org.bitspark.android.utils.AbstractC3331m;
import p001a0.C0019b;
import p003a2.AbstractC0032a;
import p046e0.AbstractC2343b;
import p049e3.C2404v;
import p055ea.C2448k;
import p055ea.HandlerC2468u;
import p063fa.C2543m0;
import p063fa.ViewOnTouchListenerC2534j0;
import p106k0.C2856d;
import p109k3.ViewTreeObserverOnDrawListenerC2872d;
import p116ka.C2918f0;
import p116ka.C2924i0;
import p116ka.ViewOnKeyListenerC2932m0;
import p138n0.AbstractC3155s0;
import p143n5.AbstractC3198d;
import p156o9.AbstractC3280d;
import p165p4.BinderC3369n;
import p165p4.C3370o;
import p169p8.C3381f;
import p169p8.C3382g;
import p186r3.AbstractC3610n;
import p187r4.C3616f;
import p193ra.C3663f;
import p219u4.C3896d;
import p226v0.C3968d;
import p230v4.AbstractC3987a;
import p230v4.C3988b;
import sa.C3741l;
import sa.C3745p;

public final class RunnableC0038c implements Runnable {

    public final int f107a;

    public final Object f108b;

    public final Object f109c;

    public RunnableC0038c(int i6, Object obj, Object obj2, boolean z7) {
        this.f107a = i6;
        this.f108b = obj;
        this.f109c = obj2;
    }

    private final void m191a() {
        try {
            C2029al.m4639a(C2034aq.f7341d.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
            synchronized (((C2034aq) this.f108b)) {
                ((C2034aq) this.f109c).f7343b.registerReceiver(C2034aq.f7341d, ((C2034aq) this.f109c).f7342a, "com.tencent.bugly.BuglyBroadcastReceiver.permission", null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override
    public final void run() {
        Spark spark;
        boolean z7;
        boolean z10;
        boolean z11;
        boolean z12;
        int i6 = 0;
        switch (this.f107a) {
            case 0:
                ThreadFactoryC0039d threadFactoryC0039d = (ThreadFactoryC0039d) this.f109c;
                if (threadFactoryC0039d.f113d) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    ((Runnable) this.f108b).run();
                    return;
                } catch (Throwable th) {
                    threadFactoryC0039d.f112c.getClass();
                    if (Log.isLoggable("GlideExecutor", 6)) {
                        Log.e("GlideExecutor", "Request threw uncaught throwable", th);
                        return;
                    }
                    return;
                }
            case 1:
                C3968d c3968d = ((SwipeDismissBehavior) this.f109c).f5904a;
                if (c3968d == null || !c3968d.m7952g()) {
                    return;
                }
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                ((View) this.f108b).postOnAnimation(this);
                return;
            case 2:
                ((C0322d) this.f108b).f1487a = this.f109c;
                return;
            case 3:
                ((Application) this.f108b).unregisterActivityLifecycleCallbacks((C0322d) this.f109c);
                return;
            case 4:
                try {
                    Method method = AbstractC0324e.f1496d;
                    Object obj = this.f109c;
                    Object obj2 = this.f108b;
                    if (method != null) {
                        method.invoke(obj2, obj, Boolean.FALSE, "AppCompat recreation");
                    } else {
                        AbstractC0324e.f1497e.invoke(obj2, obj, Boolean.FALSE);
                    }
                    return;
                } catch (RuntimeException e5) {
                    if (e5.getClass() == RuntimeException.class && e5.getMessage() != null && e5.getMessage().startsWith("Unable to stop")) {
                        throw e5;
                    }
                    return;
                } catch (Throwable th2) {
                    Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th2);
                    return;
                }
            case 5:
                C1864b c1864b = (C1864b) this.f109c;
                ((EditText) this.f108b).removeTextChangedListener(((C1867e) c1864b.f6830b).f6835e);
                ((C1867e) c1864b.f6830b).m4381e(true);
                return;
            case 6:
                boolean zIsPopupShowing = ((AutoCompleteTextView) this.f108b).isPopupShowing();
                C1871i c1871i = (C1871i) this.f109c;
                ((C1875m) c1871i.f6845b).m4392i(zIsPopupShowing);
                ((C1875m) c1871i.f6845b).f6859l = zIsPopupShowing;
                return;
            case 7:
                ((AutoCompleteTextView) this.f108b).removeTextChangedListener(((C1875m) ((C1864b) this.f109c).f6830b).f6852e);
                return;
            case 8:
                ((EditText) this.f108b).removeTextChangedListener(((C1879q) ((C1864b) this.f109c).f6830b).f6894e);
                return;
            case 9:
                ((Runnable) this.f108b).run();
                synchronized (((C2026ai) this.f109c).f7289j) {
                    C2026ai.m4614b((C2026ai) this.f109c);
                    break;
                }
                return;
            case 10:
                m191a();
                return;
            case 11:
                C2042ay c2042ay = ((FileObserverC2085k0) this.f109c).f7640b;
                String str = (String) this.f108b;
                if (c2042ay.m4814a(true)) {
                    try {
                        C2029al.m4644c("read trace first dump for create time!", new Object[0]);
                        TraceFileHelper.C2010a firstDumpInfo = TraceFileHelper.readFirstDumpInfo(str, false);
                        long jCurrentTimeMillis = firstDumpInfo != null ? firstDumpInfo.f7147c : -1L;
                        if (jCurrentTimeMillis == -1) {
                            C2029al.m4645d("trace dump fail could not get time!", new Object[0]);
                            jCurrentTimeMillis = System.currentTimeMillis();
                        }
                        if (c2042ay.m4813a(jCurrentTimeMillis)) {
                            return;
                        }
                        c2042ay.m4812a(jCurrentTimeMillis, str);
                        return;
                    } catch (Throwable th3) {
                        if (!C2029al.m4641a(th3)) {
                            th3.printStackTrace();
                        }
                        C2029al.m4646e("handle anr error %s", th3.getClass().toString());
                        return;
                    }
                }
                return;
            case 12:
                C2099s.m4981c((Context) this.f108b, (BuglyStrategy) this.f109c);
                return;
            case 13:
                C2448k c2448k = (C2448k) this.f109c;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c2448k.f8630b.f11140s0.getLayoutParams();
                if (((String) this.f108b).equals(c2448k.f8630b.getString(R.string.Top))) {
                    layoutParams.gravity = 48;
                } else {
                    layoutParams.gravity = 80;
                }
                c2448k.f8630b.f11140s0.setLayoutParams(layoutParams);
                return;
            case 14:
                ChannelBean channelBean = C3663f.m7415b().f12272e;
                Spark spark2 = (Spark) this.f109c;
                if (channelBean == null || channelBean.getLevel() < 18) {
                    spark2.f11139r1.setProgress((int) AbstractC3331m.m6760j((Long) this.f108b));
                } else {
                    spark2.f11139r1.setMax(100);
                    spark2.f11139r1.setProgress(100);
                }
                ViewOnKeyListenerC2932m0.f9950E0.postDelayed(this, 1000L);
                return;
            case 15:
                break;
            case 16:
                HandlerC2468u handlerC2468u = Spark.f11002X1;
                ((Spark) this.f109c).m6720l0((Bundle) this.f108b);
                return;
            case 17:
                AbstractC2343b abstractC2343b = (AbstractC2343b) ((C0019b) this.f108b).f38b;
                if (abstractC2343b != null) {
                    abstractC2343b.mo758j((Typeface) this.f109c);
                    return;
                }
                return;
            case 18:
                ((C2856d) this.f108b).accept(this.f109c);
                return;
            case 19:
                C2404v c2404vM5436a = C2404v.m5436a();
                c2404vM5436a.getClass();
                AbstractC3610n.m7233a();
                c2404vM5436a.f8388d.set(true);
                ((ViewTreeObserverOnDrawListenerC2872d) this.f109c).f9805b.f9807b = true;
                ((ViewTreeObserverOnDrawListenerC2872d) this.f109c).f9804a.getViewTreeObserver().removeOnDrawListener((ViewTreeObserverOnDrawListenerC2872d) this.f108b);
                ((ViewTreeObserverOnDrawListenerC2872d) this.f109c).f9805b.f9806a.clear();
                return;
            case 20:
                C2918f0 c2918f0 = (C2918f0) this.f109c;
                C0412k0 c0412k0M1184k = c2918f0.f9898a.m1319h().m1184k();
                String str2 = (String) this.f108b;
                if (((C3741l) c0412k0M1184k.m1264z(str2)) != null) {
                    c2918f0.f9898a.m5916R(str2);
                    return;
                }
                String strM165s = AbstractC0032a.m165s("2z/SOSdSnoDhFsQcJUuah/k=\n", "jVC2fUIm/+k=\n");
                String strM165s2 = AbstractC0032a.m165s("dROu8HErNefh/m8u6Xlt1r0=\n", "B2bAylHDin8=\n");
                boolean z13 = AbstractC3331m.f11244b;
                com.tencent.mars.xlog.Log.m5049i(strM165s, strM165s2);
                return;
            case 21:
                C2924i0 c2924i0 = (C2924i0) this.f109c;
                if (c2924i0.f9923g0 != null) {
                    int iM7735e = c2924i0.f9912U.m7735e(((C2543m0) this.f108b).f8866d);
                    if (iM7735e == -1) {
                        AbstractC3280d.m6607z(c2924i0.f9923g0, 0);
                        return;
                    } else {
                        AbstractC3280d.m6607z(c2924i0.f9923g0, iM7735e);
                        return;
                    }
                }
                return;
            case 22:
                ViewOnKeyListenerC2932m0.m5927Q((ViewOnKeyListenerC2932m0) this.f109c, (RecyclerView) this.f108b, 0, 0);
                return;
            case 23:
                ViewOnTouchListenerC2534j0 viewOnTouchListenerC2534j0 = (ViewOnTouchListenerC2534j0) this.f109c;
                C3091a c3091a = (C3091a) viewOnTouchListenerC2534j0.f8826d;
                c3091a.f10561l = true;
                C3222a c3222a = c3091a.f10555f;
                if (c3222a != null) {
                    c3222a.m6507a((View) this.f108b, viewOnTouchListenerC2534j0.f8824b, true);
                    return;
                }
                return;
            case 24:
                C3370o c3370o = ((BinderC3369n) this.f108b).f11371d;
                C3988b c3988b = C3370o.f11372F;
                zzac zzacVar = (zzac) this.f109c;
                ApplicationMetadata applicationMetadata = zzacVar.f4959d;
                boolean zM7972e = AbstractC3987a.m7972e(applicationMetadata, c3370o.f11388s);
                C1602k0 c1602k0 = c3370o.f11376C;
                if (!zM7972e) {
                    c3370o.f11388s = applicationMetadata;
                    c1602k0.m3908e(applicationMetadata);
                }
                double d = zzacVar.f4956a;
                if (Double.isNaN(d) || Math.abs(d - c3370o.f11390u) <= 1.0E-7d) {
                    z7 = false;
                } else {
                    c3370o.f11390u = d;
                    z7 = true;
                }
                boolean z14 = c3370o.f11391v;
                boolean z15 = zzacVar.f4957b;
                if (z15 != z14) {
                    c3370o.f11391v = z15;
                    z7 = true;
                }
                Object[] objArr = {Boolean.valueOf(z7), Boolean.valueOf(c3370o.f11381l)};
                C3988b c3988b2 = C3370o.f11372F;
                c3988b2.m7975b("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", objArr);
                if (c1602k0 != null && (z7 || c3370o.f11381l)) {
                    c1602k0.m3915l();
                }
                Double.isNaN(zzacVar.f4962g);
                int i10 = c3370o.f11392w;
                int i11 = zzacVar.f4958c;
                if (i11 != i10) {
                    c3370o.f11392w = i11;
                    z10 = true;
                } else {
                    z10 = false;
                }
                c3988b2.m7975b("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z10), Boolean.valueOf(c3370o.f11381l));
                if (c1602k0 != null && (z10 || c3370o.f11381l)) {
                    c1602k0.m3904a(c3370o.f11392w);
                }
                int i12 = c3370o.f11393x;
                int i13 = zzacVar.f4960e;
                if (i13 != i12) {
                    c3370o.f11393x = i13;
                    z11 = true;
                } else {
                    z11 = false;
                }
                c3988b2.m7975b("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z11), Boolean.valueOf(c3370o.f11381l));
                if (c1602k0 != null && (z11 || c3370o.f11381l)) {
                    c1602k0.m3913j(c3370o.f11393x);
                }
                zzat zzatVar = c3370o.f11394y;
                zzat zzatVar2 = zzacVar.f4961f;
                if (!AbstractC3987a.m7972e(zzatVar, zzatVar2)) {
                    c3370o.f11394y = zzatVar2;
                }
                c3370o.f11381l = false;
                return;
            case 25:
                C3370o c3370o2 = ((BinderC3369n) this.f108b).f11371d;
                C3988b c3988b3 = C3370o.f11372F;
                String str3 = ((zza) this.f109c).f4946a;
                if (AbstractC3987a.m7972e(str3, c3370o2.f11389t)) {
                    z12 = false;
                } else {
                    c3370o2.f11389t = str3;
                    z12 = true;
                }
                C3370o.f11372F.m7975b("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z12), Boolean.valueOf(c3370o2.f11382m));
                C1602k0 c1602k1 = c3370o2.f11376C;
                if (c1602k1 != null && (z12 || c3370o2.f11382m)) {
                    c1602k1.m3910g();
                }
                c3370o2.f11382m = false;
                return;
            case 26:
                ((C3382g) this.f109c).f11404j.m6608F((C3381f) this.f108b);
                return;
            case 27:
                RecyclerView recyclerView = (RecyclerView) this.f108b;
                int width = recyclerView.getWidth();
                C3741l c3741l = (C3741l) this.f109c;
                float fM6469q = width / AbstractC3198d.m6469q(c3741l.m1319h(), 84);
                if (fM6469q >= 7.0f) {
                    c3741l.f12542W = 7;
                } else {
                    c3741l.f12542W = (int) fM6469q;
                }
                if (c3741l.f12542W != 0) {
                    if (c3741l.f12541V.m7738h()) {
                        recyclerView.setLayoutManager(new GridLayoutManager(c3741l.f12542W));
                    } else {
                        ((VerticalGridView) recyclerView).setNumColumns(c3741l.f12542W);
                    }
                }
                c3741l.f12540U.setVisibility(0);
                return;
            case 28:
                TextView textView = ((C3745p) this.f109c).f12549m0;
                if (textView != null) {
                    textView.setText((String) this.f108b);
                    return;
                }
                return;
            default:
                ExpandedControllerActivity expandedControllerActivity = ((C3896d) this.f109c).f13096b;
                int i14 = ExpandedControllerActivity.f4902n0;
                expandedControllerActivity.m3630r((C3616f) this.f108b);
                return;
        }
        while (true) {
            spark = (Spark) this.f109c;
            if (i6 < spark.f11120i0.f12988E.size()) {
                if (((VodMenu) spark.f11120i0.f12988E.get(i6)).getName().equals((String) this.f108b)) {
                    spark.f11120i0.f13011x = i6;
                } else {
                    i6++;
                }
            }
        }
        if (spark.m6713d0()) {
            AbstractC3280d.m6607z(spark.f11157z0, spark.f11120i0.f13011x);
        }
    }

    public RunnableC0038c(Object obj, int i6, Object obj2) {
        this.f107a = i6;
        this.f109c = obj;
        this.f108b = obj2;
    }

    public RunnableC0038c(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z7) {
        this.f107a = 1;
        this.f109c = swipeDismissBehavior;
        this.f108b = view;
    }
}

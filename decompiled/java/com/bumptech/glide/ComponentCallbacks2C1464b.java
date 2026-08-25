package com.bumptech.glide;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Looper;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.AbstractC0410j0;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p001a0.C0019b;
import p004a3.ExecutorServiceC0041f;
import p004a3.ThreadFactoryC0037b;
import p004a3.ThreadFactoryC0039d;
import p005a4.C0052k;
import p016b3.C1291x;
import p109k3.C2880l;
import p109k3.C2888t;
import p116ka.C2924i0;
import p121l3.InterfaceC2971a;
import p143n5.AbstractC3198d;
import p143n5.C3196b;
import p156o9.AbstractC3280d;
import p160p.C3341e;
import p173q1.C3406f0;
import p186r3.AbstractC3602f;
import p186r3.AbstractC3610n;
import p221u6.C3905e;
import p247x2.C4090l;
import p249x4.C4112e;
import p259y2.C4243f;
import p259y2.C4244g;
import p259y2.InterfaceC4238a;
import p269z2.C4303d;
import p269z2.C4304e;
import p269z2.C4305f;

public final class ComponentCallbacks2C1464b implements ComponentCallbacks2 {

    public static volatile ComponentCallbacks2C1464b f4404h;

    public static volatile boolean f4405i;

    public final InterfaceC4238a f4406a;

    public final C4304e f4407b;

    public final C1468f f4408c;

    public final C4243f f4409d;

    public final C2880l f4410e;

    public final C3905e f4411f;

    public final ArrayList f4412g = new ArrayList();

    public ComponentCallbacks2C1464b(Context context, C4090l c4090l, C4304e c4304e, InterfaceC4238a interfaceC4238a, C4243f c4243f, C2880l c2880l, C3905e c3905e, int i6, C3905e c3905e2, C3341e c3341e, List list, ArrayList arrayList, AbstractC3198d abstractC3198d, C0019b c0019b) {
        this.f4406a = interfaceC4238a;
        this.f4409d = c4243f;
        this.f4407b = c4304e;
        this.f4410e = c2880l;
        this.f4411f = c3905e;
        this.f4408c = new C1468f(context, c4243f, new C2888t(this, arrayList, abstractC3198d), new C4112e(28), c3905e2, c3341e, list, c4090l, c0019b, i6);
    }

    public static ComponentCallbacks2C1464b m3461a(Context context) {
        GeneratedAppGlideModule generatedAppGlideModule;
        if (f4404h == null) {
            try {
                generatedAppGlideModule = (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext().getApplicationContext());
            } catch (ClassNotFoundException unused) {
                if (Log.isLoggable("Glide", 5)) {
                    Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
                }
                generatedAppGlideModule = null;
            } catch (IllegalAccessException e5) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e5);
            } catch (InstantiationException e10) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e10);
            } catch (NoSuchMethodException e11) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e11);
            } catch (InvocationTargetException e12) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e12);
            }
            synchronized (ComponentCallbacks2C1464b.class) {
                if (f4404h == null) {
                    if (f4405i) {
                        throw new IllegalStateException("Glide has been called recursively, this is probably an internal library error!");
                    }
                    f4405i = true;
                    try {
                        m3463c(context, generatedAppGlideModule);
                        f4405i = false;
                    } catch (Throwable th) {
                        f4405i = false;
                        throw th;
                    }
                }
            }
        }
        return f4404h;
    }

    public static C2880l m3462b(Context context) {
        AbstractC3602f.m7225c(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return m3461a(context).f4410e;
    }

    public static void m3463c(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        C1467e c1467e = new C1467e();
        Context applicationContext = context.getApplicationContext();
        Collections.emptyList();
        if (Log.isLoggable("ManifestParser", 3)) {
            Log.d("ManifestParser", "Loading Glide modules");
        }
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                if (Log.isLoggable("ManifestParser", 2)) {
                    Log.v("ManifestParser", "Got app info metadata: " + applicationInfo.metaData);
                }
                for (String str : applicationInfo.metaData.keySet()) {
                    if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                        arrayList.add(AbstractC3280d.m6604w(str));
                        if (Log.isLoggable("ManifestParser", 3)) {
                            Log.d("ManifestParser", "Loaded Glide module: " + str);
                        }
                    }
                }
                if (Log.isLoggable("ManifestParser", 3)) {
                    Log.d("ManifestParser", "Finished loading Glide modules");
                }
            } else if (Log.isLoggable("ManifestParser", 3)) {
                Log.d("ManifestParser", "Got null app info metadata");
            }
        } catch (PackageManager.NameNotFoundException e5) {
            if (Log.isLoggable("ManifestParser", 6)) {
                Log.e("ManifestParser", "Failed to parse glide modules", e5);
            }
        }
        if (generatedAppGlideModule != null && !new HashSet().isEmpty()) {
            HashSet hashSet = new HashSet();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                InterfaceC2971a interfaceC2971a = (InterfaceC2971a) it.next();
                if (hashSet.contains(interfaceC2971a.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + interfaceC2971a);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + ((InterfaceC2971a) it2.next()).getClass());
            }
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            ((InterfaceC2971a) it3.next()).mo3520b(applicationContext, c1467e);
        }
        if (c1467e.f4421g == null) {
            ThreadFactoryC0037b threadFactoryC0037b = new ThreadFactoryC0037b();
            if (ExecutorServiceC0041f.f117c == 0) {
                ExecutorServiceC0041f.f117c = Math.min(4, Runtime.getRuntime().availableProcessors());
            }
            int i6 = ExecutorServiceC0041f.f117c;
            if (TextUtils.isEmpty("source")) {
                throw new IllegalArgumentException("Name must be non-null and non-empty, but given: source");
            }
            c1467e.f4421g = new ExecutorServiceC0041f(new ThreadPoolExecutor(i6, i6, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0039d(threadFactoryC0037b, "source", false)));
        }
        if (c1467e.f4422h == null) {
            int i10 = ExecutorServiceC0041f.f117c;
            ThreadFactoryC0037b threadFactoryC0037b2 = new ThreadFactoryC0037b();
            if (TextUtils.isEmpty("disk-cache")) {
                throw new IllegalArgumentException("Name must be non-null and non-empty, but given: disk-cache");
            }
            c1467e.f4422h = new ExecutorServiceC0041f(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0039d(threadFactoryC0037b2, "disk-cache", true)));
        }
        if (c1467e.f4428n == null) {
            if (ExecutorServiceC0041f.f117c == 0) {
                ExecutorServiceC0041f.f117c = Math.min(4, Runtime.getRuntime().availableProcessors());
            }
            int i11 = ExecutorServiceC0041f.f117c >= 4 ? 2 : 1;
            ThreadFactoryC0037b threadFactoryC0037b3 = new ThreadFactoryC0037b();
            if (TextUtils.isEmpty("animation")) {
                throw new IllegalArgumentException("Name must be non-null and non-empty, but given: animation");
            }
            c1467e.f4428n = new ExecutorServiceC0041f(new ThreadPoolExecutor(i11, i11, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0039d(threadFactoryC0037b3, "animation", true)));
        }
        if (c1467e.f4424j == null) {
            C4305f c4305f = new C4305f(applicationContext);
            C3196b c3196b = new C3196b();
            Context context2 = c4305f.f14604a;
            ActivityManager activityManager = c4305f.f14605b;
            int i12 = activityManager.isLowRamDevice() ? 2097152 : 4194304;
            c3196b.f10754c = i12;
            int iRound = Math.round(activityManager.getMemoryClass() * ProgressiveMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES * (activityManager.isLowRamDevice() ? 0.33f : 0.4f));
            DisplayMetrics displayMetrics = (DisplayMetrics) c4305f.f14606c.f12182b;
            float f = displayMetrics.widthPixels * displayMetrics.heightPixels * 4;
            float f3 = c4305f.f14607d;
            int iRound2 = Math.round(f * f3);
            int iRound3 = Math.round(f * 2.0f);
            int i13 = iRound - i12;
            int i14 = iRound3 + iRound2;
            if (i14 <= i13) {
                c3196b.f10753b = iRound3;
                c3196b.f10752a = iRound2;
            } else {
                float f4 = i13 / (f3 + 2.0f);
                c3196b.f10753b = Math.round(2.0f * f4);
                c3196b.f10752a = Math.round(f4 * f3);
            }
            if (Log.isLoggable("MemorySizeCalculator", 3)) {
                StringBuilder sb = new StringBuilder("Calculation complete, Calculated memory cache size: ");
                sb.append(Formatter.formatFileSize(context2, c3196b.f10753b));
                sb.append(", pool size: ");
                sb.append(Formatter.formatFileSize(context2, c3196b.f10752a));
                sb.append(", byte array size: ");
                sb.append(Formatter.formatFileSize(context2, i12));
                sb.append(", memory class limited? ");
                sb.append(i14 > iRound);
                sb.append(", max size: ");
                sb.append(Formatter.formatFileSize(context2, iRound));
                sb.append(", memoryClass: ");
                sb.append(activityManager.getMemoryClass());
                sb.append(", isLowMemoryDevice: ");
                sb.append(activityManager.isLowRamDevice());
                Log.d("MemorySizeCalculator", sb.toString());
            }
            c1467e.f4424j = c3196b;
        }
        if (c1467e.f4425k == null) {
            c1467e.f4425k = new C3905e(16);
        }
        if (c1467e.f4418d == null) {
            int i15 = c1467e.f4424j.f10752a;
            if (i15 > 0) {
                c1467e.f4418d = new C4244g(i15);
            } else {
                c1467e.f4418d = new C3406f0(10);
            }
        }
        if (c1467e.f4419e == null) {
            c1467e.f4419e = new C4243f(c1467e.f4424j.f10754c);
        }
        if (c1467e.f4420f == null) {
            c1467e.f4420f = new C4304e(c1467e.f4424j.f10753b);
        }
        if (c1467e.f4423i == null) {
            c1467e.f4423i = new C4303d(new C0052k(applicationContext, 5), 262144000L);
        }
        if (c1467e.f4417c == null) {
            c1467e.f4417c = new C4090l(c1467e.f4420f, c1467e.f4423i, c1467e.f4422h, c1467e.f4421g, new ExecutorServiceC0041f(new ThreadPoolExecutor(0, Integer.MAX_VALUE, ExecutorServiceC0041f.f116b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadFactoryC0039d(new ThreadFactoryC0037b(), "source-unlimited", false))), c1467e.f4428n);
        }
        List list = c1467e.f4429o;
        if (list == null) {
            c1467e.f4429o = Collections.emptyList();
        } else {
            c1467e.f4429o = Collections.unmodifiableList(list);
        }
        C1291x c1291x = c1467e.f4416b;
        c1291x.getClass();
        ComponentCallbacks2C1464b componentCallbacks2C1464b = new ComponentCallbacks2C1464b(applicationContext, c1467e.f4417c, c1467e.f4420f, c1467e.f4418d, c1467e.f4419e, new C2880l(), c1467e.f4425k, c1467e.f4426l, c1467e.f4427m, c1467e.f4415a, c1467e.f4429o, arrayList, generatedAppGlideModule, new C0019b(c1291x));
        applicationContext.registerComponentCallbacks(componentCallbacks2C1464b);
        f4404h = componentCallbacks2C1464b;
    }

    public static ComponentCallbacks2C1491o m3464e(Context context) {
        return m3462b(context).m5864b(context);
    }

    public static ComponentCallbacks2C1491o m3465f(C2924i0 c2924i0) {
        View view;
        C2880l c2880lM3462b = m3462b(c2924i0.m1321j());
        c2880lM3462b.getClass();
        AbstractC3602f.m7225c(c2924i0.m1321j(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        char[] cArr = AbstractC3610n.f12112a;
        if (!(Looper.myLooper() == Looper.getMainLooper())) {
            return c2880lM3462b.m5864b(c2924i0.m1321j().getApplicationContext());
        }
        if (c2924i0.m1319h() != null) {
            c2880lM3462b.f9814b.mo5860a(c2924i0.m1319h());
        }
        AbstractC0410j0 abstractC0410j0M1320i = c2924i0.m1320i();
        Context contextM1321j = c2924i0.m1321j();
        return c2880lM3462b.f9815c.m220C(contextM1321j, m3461a(contextM1321j.getApplicationContext()), c2924i0.f1958M, abstractC0410j0M1320i, (!c2924i0.m1326o() || c2924i0.f1989z || (view = c2924i0.f1951F) == null || view.getWindowToken() == null || c2924i0.f1951F.getVisibility() != 0) ? false : true);
    }

    public final void m3466d(ComponentCallbacks2C1491o componentCallbacks2C1491o) {
        synchronized (this.f4412g) {
            try {
                if (!this.f4412g.contains(componentCallbacks2C1491o)) {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
                this.f4412g.remove(componentCallbacks2C1491o);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final void onLowMemory() {
        AbstractC3610n.m7233a();
        this.f4407b.m7230e(0L);
        this.f4406a.mo6927j();
        this.f4409d.m8284a();
    }

    @Override
    public final void onTrimMemory(int i6) {
        AbstractC3610n.m7233a();
        synchronized (this.f4412g) {
            try {
                Iterator it = this.f4412g.iterator();
                while (it.hasNext()) {
                    ((ComponentCallbacks2C1491o) it.next()).getClass();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f4407b.m8354f(i6);
        this.f4406a.mo6922a(i6);
        this.f4409d.m8292i(i6);
    }

    @Override
    public final void onConfigurationChanged(Configuration configuration) {
    }
}

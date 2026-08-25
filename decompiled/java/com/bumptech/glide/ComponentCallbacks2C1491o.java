package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.Log;
import android.widget.ImageView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import p000a.RunnableC0005f;
import p086i3.C2688d;
import p109k3.C2871c;
import p109k3.C2879k;
import p109k3.C2888t;
import p109k3.C2889u;
import p109k3.InterfaceC2870b;
import p109k3.InterfaceC2875g;
import p109k3.InterfaceC2877i;
import p109k3.InterfaceC2881m;
import p141n3.C3191e;
import p141n3.InterfaceC3189c;
import p151o3.InterfaceC3254h;
import p175q3.AbstractC3468b;
import p175q3.C3467a;
import p175q3.C3470d;
import p186r3.AbstractC3610n;
import p221u6.C3905e;
import p222u7.AbstractC3928d;
import p228v2.InterfaceC3978e;

public final class ComponentCallbacks2C1491o implements ComponentCallbacks2, InterfaceC2877i {

    public static final C3191e f4501k;

    public final ComponentCallbacks2C1464b f4502a;

    public final Context f4503b;

    public final InterfaceC2875g f4504c;

    public final C2888t f4505d;

    public final InterfaceC2881m f4506e;

    public final C2889u f4507f;

    public final RunnableC0005f f4508g;

    public final InterfaceC2870b f4509h;

    public final CopyOnWriteArrayList f4510i;

    public C3191e f4511j;

    static {
        C3191e c3191e = (C3191e) new C3191e().m6382c(Bitmap.class);
        c3191e.f10701o = true;
        f4501k = c3191e;
        ((C3191e) new C3191e().m6382c(C2688d.class)).f10701o = true;
    }

    public ComponentCallbacks2C1491o(ComponentCallbacks2C1464b componentCallbacks2C1464b, InterfaceC2875g interfaceC2875g, InterfaceC2881m interfaceC2881m, Context context) {
        C2888t c2888t = new C2888t(3);
        C3905e c3905e = componentCallbacks2C1464b.f4411f;
        this.f4507f = new C2889u();
        RunnableC0005f runnableC0005f = new RunnableC0005f(9, this);
        this.f4508g = runnableC0005f;
        this.f4502a = componentCallbacks2C1464b;
        this.f4504c = interfaceC2875g;
        this.f4506e = interfaceC2881m;
        this.f4505d = c2888t;
        this.f4503b = context;
        Context applicationContext = context.getApplicationContext();
        C1490n c1490n = new C1490n(this, c2888t);
        c3905e.getClass();
        boolean z7 = AbstractC3928d.m7841b(applicationContext, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", z7 ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        InterfaceC2870b c2871c = z7 ? new C2871c(applicationContext, c1490n) : new C2879k();
        this.f4509h = c2871c;
        synchronized (componentCallbacks2C1464b.f4412g) {
            if (componentCallbacks2C1464b.f4412g.contains(this)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            componentCallbacks2C1464b.f4412g.add(this);
        }
        char[] cArr = AbstractC3610n.f12112a;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            interfaceC2875g.mo5862h(this);
        } else {
            AbstractC3610n.m7238f().post(runnableC0005f);
        }
        interfaceC2875g.mo5862h(c2871c);
        this.f4510i = new CopyOnWriteArrayList(componentCallbacks2C1464b.f4408c.f4435e);
        m3575r(componentCallbacks2C1464b.f4408c.m3517a());
    }

    @Override
    public final synchronized void mo3559c() {
        this.f4507f.mo3559c();
        m3573p();
    }

    @Override
    public final synchronized void mo3565i() {
        m3574q();
        this.f4507f.mo3565i();
    }

    @Override
    public final synchronized void mo3566j() {
        this.f4507f.mo3566j();
        m3570m();
        C2888t c2888t = this.f4505d;
        Iterator it = AbstractC3610n.m7237e((Set) c2888t.f9832c).iterator();
        while (it.hasNext()) {
            c2888t.m5885a((InterfaceC3189c) it.next());
        }
        ((HashSet) c2888t.f9833d).clear();
        this.f4504c.mo5861g(this);
        this.f4504c.mo5861g(this.f4509h);
        AbstractC3610n.m7238f().removeCallbacks(this.f4508g);
        this.f4502a.m3466d(this);
    }

    public final void m3568k(ImageView imageView) {
        m3569l(new C1489m(imageView));
    }

    public final void m3569l(InterfaceC3254h interfaceC3254h) {
        if (interfaceC3254h == null) {
            return;
        }
        boolean zM3576s = m3576s(interfaceC3254h);
        InterfaceC3189c request = interfaceC3254h.getRequest();
        if (zM3576s) {
            return;
        }
        ComponentCallbacks2C1464b componentCallbacks2C1464b = this.f4502a;
        synchronized (componentCallbacks2C1464b.f4412g) {
            try {
                Iterator it = componentCallbacks2C1464b.f4412g.iterator();
                while (it.hasNext()) {
                    if (((ComponentCallbacks2C1491o) it.next()).m3576s(interfaceC3254h)) {
                    }
                }
                if (request != null) {
                    interfaceC3254h.mo3557a(null);
                    request.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void m3570m() {
        try {
            Iterator it = AbstractC3610n.m7237e(this.f4507f.f9834a).iterator();
            while (it.hasNext()) {
                m3569l((InterfaceC3254h) it.next());
            }
            this.f4507f.f9834a.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final C1474l m3571n(Integer num) {
        PackageInfo packageInfo;
        C1474l c1474l = new C1474l(this.f4502a, this, Drawable.class, this.f4503b);
        C1474l c1474lM3535C = c1474l.m3535C(num);
        Context context = c1474l.f4463t;
        C1474l c1474l2 = (C1474l) c1474lM3535C.m6396r(context.getTheme());
        ConcurrentHashMap concurrentHashMap = AbstractC3468b.f11733a;
        String packageName = context.getPackageName();
        ConcurrentHashMap concurrentHashMap2 = AbstractC3468b.f11733a;
        InterfaceC3978e interfaceC3978e = (InterfaceC3978e) concurrentHashMap2.get(packageName);
        if (interfaceC3978e == null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e5) {
                Log.e("AppVersionSignature", "Cannot resolve info for" + context.getPackageName(), e5);
                packageInfo = null;
            }
            C3470d c3470d = new C3470d(packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString());
            interfaceC3978e = (InterfaceC3978e) concurrentHashMap2.putIfAbsent(packageName, c3470d);
            if (interfaceC3978e == null) {
                interfaceC3978e = c3470d;
            }
        }
        return (C1474l) c1474l2.m6394p(new C3467a(context.getResources().getConfiguration().uiMode & 48, interfaceC3978e));
    }

    public final C1474l m3572o(String str) {
        return new C1474l(this.f4502a, this, Drawable.class, this.f4503b).m3535C(str);
    }

    public final synchronized void m3573p() {
        C2888t c2888t = this.f4505d;
        c2888t.f9831b = true;
        for (InterfaceC3189c interfaceC3189c : AbstractC3610n.m7237e((Set) c2888t.f9832c)) {
            if (interfaceC3189c.isRunning()) {
                interfaceC3189c.pause();
                ((HashSet) c2888t.f9833d).add(interfaceC3189c);
            }
        }
    }

    public final synchronized void m3574q() {
        C2888t c2888t = this.f4505d;
        c2888t.f9831b = false;
        for (InterfaceC3189c interfaceC3189c : AbstractC3610n.m7237e((Set) c2888t.f9832c)) {
            if (!interfaceC3189c.mo6409i() && !interfaceC3189c.isRunning()) {
                interfaceC3189c.mo6405e();
            }
        }
        ((HashSet) c2888t.f9833d).clear();
    }

    public final synchronized void m3575r(C3191e c3191e) {
        C3191e c3191e2 = (C3191e) c3191e.clone();
        if (c3191e2.f10701o && !c3191e2.f10703q) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        c3191e2.f10703q = true;
        c3191e2.f10701o = true;
        this.f4511j = c3191e2;
    }

    public final synchronized boolean m3576s(InterfaceC3254h interfaceC3254h) {
        InterfaceC3189c request = interfaceC3254h.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.f4505d.m5885a(request)) {
            return false;
        }
        this.f4507f.f9834a.remove(interfaceC3254h);
        interfaceC3254h.mo3557a(null);
        return true;
    }

    public final synchronized String toString() {
        return super.toString() + "{tracker=" + this.f4505d + ", treeNode=" + this.f4506e + "}";
    }

    @Override
    public final void onLowMemory() {
    }

    @Override
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override
    public final void onTrimMemory(int i6) {
    }
}

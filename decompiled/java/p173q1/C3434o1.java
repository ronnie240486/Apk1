package p173q1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import androidx.appcompat.app.C0125b0;
import androidx.media3.common.C0628x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public final class C3434o1 {

    public final Context f11600a;

    public final C3411h f11601b;

    public final PackageManager f11603d;

    public boolean f11605f;

    public boolean f11606g;

    public final ArrayList f11604e = new ArrayList();

    public final C0125b0 f11607h = new C0125b0(3, this);

    public final RunnableC3431n1 f11608i = new RunnableC3431n1(0, this);

    public final Handler f11602c = new Handler();

    public C3434o1(Context context, C3411h c3411h) {
        this.f11600a = context;
        this.f11601b = c3411h;
        this.f11603d = context.getPackageManager();
    }

    public final void m7009a() {
        ArrayList arrayList;
        C3411h c3411h;
        int i6;
        if (this.f11606g) {
            ArrayList arrayList2 = new ArrayList();
            int i10 = Build.VERSION.SDK_INT;
            Context context = this.f11600a;
            PackageManager packageManager = this.f11603d;
            if (i10 >= 30) {
                Intent intent = new Intent("android.media.MediaRoute2ProviderService");
                ArrayList arrayList3 = new ArrayList();
                Iterator<ResolveInfo> it = packageManager.queryIntentServices(intent, 0).iterator();
                while (it.hasNext()) {
                    ServiceInfo serviceInfo = it.next().serviceInfo;
                    if (!this.f11605f || TextUtils.equals(context.getPackageName(), serviceInfo.packageName)) {
                        arrayList3.add(serviceInfo);
                    }
                }
                arrayList2 = arrayList3;
            }
            Iterator<ResolveInfo> it2 = packageManager.queryIntentServices(new Intent("android.media.MediaRouteProviderService"), 0).iterator();
            int i11 = 0;
            while (true) {
                boolean zHasNext = it2.hasNext();
                arrayList = this.f11604e;
                boolean z7 = true;
                c3411h = this.f11601b;
                if (!zHasNext) {
                    break;
                }
                ServiceInfo serviceInfo2 = it2.next().serviceInfo;
                if (serviceInfo2 != null) {
                    if ((C3451u0.f11687c == null ? false : C3451u0.m7068c().m6941h()) && !arrayList2.isEmpty()) {
                        Iterator it3 = arrayList2.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                ServiceInfo serviceInfo3 = (ServiceInfo) it3.next();
                                if (!serviceInfo2.packageName.equals(serviceInfo3.packageName) || !serviceInfo2.name.equals(serviceInfo3.name)) {
                                }
                            }
                        }
                    }
                    String str = serviceInfo2.packageName;
                    String str2 = serviceInfo2.name;
                    int size = arrayList.size();
                    int i12 = 0;
                    while (true) {
                        if (i12 >= size) {
                            i12 = -1;
                            break;
                        }
                        ComponentName componentName = ((ServiceConnectionC3428m1) arrayList.get(i12)).f11582i;
                        if (componentName.getPackageName().equals(str) && componentName.getClassName().equals(str2)) {
                            break;
                        } else {
                            i12++;
                        }
                    }
                    if (i12 < 0) {
                        ServiceConnectionC3428m1 serviceConnectionC3428m1 = new ServiceConnectionC3428m1(context, new ComponentName(serviceInfo2.packageName, serviceInfo2.name));
                        serviceConnectionC3428m1.f11589p = new C0628x(this, serviceConnectionC3428m1);
                        if (!serviceConnectionC3428m1.f11585l) {
                            serviceConnectionC3428m1.f11585l = true;
                            serviceConnectionC3428m1.m7007l();
                        }
                        i6 = i11 + 1;
                        arrayList.add(i11, serviceConnectionC3428m1);
                        c3411h.m6934a(serviceConnectionC3428m1, false);
                    } else if (i12 >= i11) {
                        ServiceConnectionC3428m1 serviceConnectionC3428m2 = (ServiceConnectionC3428m1) arrayList.get(i12);
                        if (!serviceConnectionC3428m2.f11585l) {
                            serviceConnectionC3428m2.f11585l = true;
                            serviceConnectionC3428m2.m7007l();
                        }
                        if (serviceConnectionC3428m2.f11587n == null) {
                            if (!serviceConnectionC3428m2.f11585l || (serviceConnectionC3428m2.f11454e == null && serviceConnectionC3428m2.f11584k.isEmpty())) {
                                z7 = false;
                            }
                            if (z7) {
                                serviceConnectionC3428m2.m7006k();
                                serviceConnectionC3428m2.m7003h();
                            }
                        }
                        i6 = i11 + 1;
                        Collections.swap(arrayList, i12, i11);
                    }
                    i11 = i6;
                }
            }
            if (i11 < arrayList.size()) {
                for (int size2 = arrayList.size() - 1; size2 >= i11; size2--) {
                    ServiceConnectionC3428m1 serviceConnectionC3428m3 = (ServiceConnectionC3428m1) arrayList.get(size2);
                    C3442r0 c3442r0M6937d = c3411h.m6937d(serviceConnectionC3428m3);
                    if (c3442r0M6937d != null) {
                        serviceConnectionC3428m3.getClass();
                        C3451u0.m7067b();
                        serviceConnectionC3428m3.f11453d = null;
                        serviceConnectionC3428m3.m6908g(null);
                        c3411h.m6947n(c3442r0M6937d, null);
                        c3411h.f11488a.m6886b(514, c3442r0M6937d);
                        c3411h.f11499l.remove(c3442r0M6937d);
                    }
                    arrayList.remove(serviceConnectionC3428m3);
                    serviceConnectionC3428m3.f11589p = null;
                    if (serviceConnectionC3428m3.f11585l) {
                        serviceConnectionC3428m3.f11585l = false;
                        serviceConnectionC3428m3.m7007l();
                    }
                }
            }
        }
    }
}

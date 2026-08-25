package com.tencent.bugly.proguard;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.RunnableC0552u0;

public final class C2093o0 implements Application.ActivityLifecycleCallbacks {
    @Override
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        String name = activity.getClass().getName();
        if (C2099s.f7684l == null || C2099s.f7684l.getName().equals(name)) {
            C2029al.m4644c(">>> %s onCreated <<<", name);
            C2018aa c2018aaM4509b = C2018aa.m4509b();
            if (c2018aaM4509b != null) {
                c2018aaM4509b.f7187L.add(C2099s.m4970a(name, "onCreated"));
            }
        }
    }

    @Override
    public final void onActivityDestroyed(Activity activity) {
        String name = activity.getClass().getName();
        if (C2099s.f7684l == null || C2099s.f7684l.getName().equals(name)) {
            C2029al.m4644c(">>> %s onDestroyed <<<", name);
            C2018aa c2018aaM4509b = C2018aa.m4509b();
            if (c2018aaM4509b != null) {
                c2018aaM4509b.f7187L.add(C2099s.m4970a(name, "onDestroyed"));
            }
        }
    }

    @Override
    public final void onActivityPaused(Activity activity) {
        String name = activity.getClass().getName();
        if (C2099s.f7684l == null || C2099s.f7684l.getName().equals(name)) {
            C2029al.m4644c(">>> %s onPaused <<<", name);
            C2018aa c2018aaM4509b = C2018aa.m4509b();
            if (c2018aaM4509b == null) {
                return;
            }
            c2018aaM4509b.f7187L.add(C2099s.m4970a(name, "onPaused"));
            long jCurrentTimeMillis = System.currentTimeMillis();
            c2018aaM4509b.f7176A = jCurrentTimeMillis;
            c2018aaM4509b.f7177B = jCurrentTimeMillis - c2018aaM4509b.f7250z;
            long unused = C2099s.f7680h = jCurrentTimeMillis;
            if (c2018aaM4509b.f7177B < 0) {
                c2018aaM4509b.f7177B = 0L;
            }
            c2018aaM4509b.f7249y = "background";
        }
    }

    @Override
    public final void onActivityResumed(Activity activity) {
        String name = activity.getClass().getName();
        if (C2099s.f7684l == null || C2099s.f7684l.getName().equals(name)) {
            C2029al.m4644c(">>> %s onResumed <<<", name);
            C2018aa c2018aaM4509b = C2018aa.m4509b();
            if (c2018aaM4509b == null) {
                return;
            }
            c2018aaM4509b.f7187L.add(C2099s.m4970a(name, "onResumed"));
            c2018aaM4509b.f7249y = name;
            long jCurrentTimeMillis = System.currentTimeMillis();
            c2018aaM4509b.f7250z = jCurrentTimeMillis;
            c2018aaM4509b.f7178C = jCurrentTimeMillis - C2099s.f7681i;
            long j10 = c2018aaM4509b.f7250z - C2099s.f7680h;
            if (j10 > (C2099s.f7678f > 0 ? C2099s.f7678f : C2099s.f7677e)) {
                c2018aaM4509b.m4518c();
                C2099s.m4985g();
                C2029al.m4640a("[session] launch app one times (app in background %d seconds and over %d seconds)", Long.valueOf(j10 / 1000), Long.valueOf(C2099s.f7677e / 1000));
                if (C2099s.f7679g % C2099s.f7675c == 0) {
                    C2099s.f7674b.m4967a(4, C2099s.f7685m);
                    return;
                }
                C2099s.f7674b.m4967a(4, false);
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (jCurrentTimeMillis2 - C2099s.f7682j > C2099s.f7676d) {
                    long unused = C2099s.f7682j = jCurrentTimeMillis2;
                    C2029al.m4640a("add a timer to upload hot start user info", new Object[0]);
                    if (C2099s.f7685m) {
                        C2028ak.m4631a().m4634a(new RunnableC0552u0(C2099s.f7674b, null, true), C2099s.f7676d);
                    }
                }
            }
        }
    }

    @Override
    public final void onActivityStarted(Activity activity) {
        C2029al.m4644c(">>> %s onStart <<<", activity.getClass().getName());
        C2018aa.m4509b().m4512a(activity.hashCode(), true);
    }

    @Override
    public final void onActivityStopped(Activity activity) {
        C2029al.m4644c(">>> %s onStop <<<", activity.getClass().getName());
        C2018aa.m4509b().m4512a(activity.hashCode(), false);
    }

    @Override
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}

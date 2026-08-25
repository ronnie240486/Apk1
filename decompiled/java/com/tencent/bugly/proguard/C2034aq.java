package com.tencent.bugly.proguard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.media3.exoplayer.smoothstreaming.SsMediaSource;
import p004a3.RunnableC0038c;

public final class C2034aq extends BroadcastReceiver {

    private static C2034aq f7341d;

    private Context f7343b;

    private String f7344c;

    private boolean f7345e = true;

    private IntentFilter f7342a = new IntentFilter();

    @Override
    public final void onReceive(Context context, Intent intent) {
        try {
            m4714a(context, intent);
        } catch (Throwable th) {
            if (C2029al.m4641a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public static synchronized C2034aq m4713a() {
        try {
            if (f7341d == null) {
                f7341d = new C2034aq();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7341d;
    }

    public final synchronized void m4719b(Context context) {
        try {
            C2029al.m4639a(C2034aq.class, "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.f7343b = context;
        } catch (Throwable th) {
            if (C2029al.m4641a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final synchronized void m4718a(String str) {
        try {
            if (!this.f7342a.hasAction(str)) {
                this.f7342a.addAction(str);
            }
            C2029al.m4644c("add action %s", str);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void m4717a(Context context) {
        this.f7343b = context;
        C2033ap.m4691a(new RunnableC0038c(this, 10, this));
    }

    private synchronized boolean m4714a(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.f7345e) {
                    this.f7345e = false;
                    return true;
                }
                String strM4551c = C2019ab.m4551c(this.f7343b);
                C2029al.m4644c("is Connect BC ".concat(String.valueOf(strM4551c)), new Object[0]);
                C2029al.m4640a("network %s changed to %s", this.f7344c, String.valueOf(strM4551c));
                if (strM4551c == null) {
                    this.f7344c = null;
                    return true;
                }
                String str = this.f7344c;
                this.f7344c = strM4551c;
                long jCurrentTimeMillis = System.currentTimeMillis();
                C2020ac c2020acM4570a = C2020ac.m4570a();
                C2026ai c2026aiM4605a = C2026ai.m4605a();
                C2018aa c2018aaM4507a = C2018aa.m4507a(context);
                if (c2020acM4570a != null && c2026aiM4605a != null && c2018aaM4507a != null) {
                    if (!strM4551c.equals(str) && jCurrentTimeMillis - c2026aiM4605a.m4616a(C2037at.f7365a) > SsMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_MS) {
                        C2029al.m4640a("try to upload crash on network changed.", new Object[0]);
                        C2037at c2037atM4762a = C2037at.m4762a();
                        if (c2037atM4762a != null) {
                            c2037atM4762a.m4766a(0L);
                        }
                        C2029al.m4640a("try to upload userinfo on network changed.", new Object[0]);
                        C2099s.f7674b.m4969b();
                    }
                    return true;
                }
                C2029al.m4645d("not inited BC not work", new Object[0]);
                return true;
            }
        }
        return false;
    }
}

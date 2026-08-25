package com.google.android.gms.cast;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.appcompat.app.AbstractC0168x;
import com.google.android.gms.internal.cast.HandlerC1731y0;
import com.p2serv.android.p032ds.R;
import java.util.concurrent.atomic.AtomicBoolean;
import p000a.RunnableC0005f;
import p165p4.AbstractC3359d;
import p165p4.AbstractC3361f;
import p165p4.BinderC3364i;
import p165p4.C3360e;
import p165p4.C3363h;
import p222u7.AbstractC3928d;
import p230v4.C3988b;
import p261y4.C4258f;
import p261y4.InterfaceC4254b;

@SuppressLint({"ForegroundServiceType"})
@Deprecated
public abstract class CastRemoteDisplayLocalService extends Service {

    public static final C3988b f4620d = new C3988b("CastRDLocalService", null);

    public static final Object f4621e = null;

    public boolean f4622a = false;

    public C3360e f4623b;

    public final BinderC3364i f4624c;

    static {
        new AtomicBoolean(false);
    }

    public CastRemoteDisplayLocalService() {
        new C3363h(this);
        this.f4624c = new BinderC3364i();
    }

    public final void m3589a(String str) {
        f4620d.m7975b("[Instance: %s] %s", this, str);
    }

    @Override
    public final IBinder onBind(Intent intent) {
        m3589a("onBind");
        return this.f4624c;
    }

    @Override
    public final void onCreate() {
        m3589a("onCreate");
        super.onCreate();
        new HandlerC1731y0(getMainLooper(), 0).postDelayed(new RunnableC0005f(28, this), 100L);
        if (this.f4623b == null) {
            int i6 = AbstractC3359d.f11351a;
            C3360e c3360e = new C3360e(this, C3360e.f11352j, InterfaceC4254b.f14452a0, C4258f.f14454c);
            new C3988b("CastRemoteDisplay", null);
            this.f4623b = c3360e;
        }
        if (AbstractC3928d.m7856t()) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
            AbstractC0168x.m509s();
            NotificationChannel notificationChannelM6826b = AbstractC3361f.m6826b(getString(R.string.cast_notification_default_channel_name));
            notificationChannelM6826b.setShowBadge(false);
            notificationManager.createNotificationChannel(notificationChannelM6826b);
        }
    }

    @Override
    public final int onStartCommand(Intent intent, int i6, int i10) {
        m3589a("onStartCommand");
        this.f4622a = true;
        return 2;
    }
}

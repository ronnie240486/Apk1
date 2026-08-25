package com.google.android.gms.internal.cast;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.mediarouter.media.MediaTransferReceiver;
import com.google.android.gms.cast.framework.CastOptions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import p173q1.AbstractC3427m0;
import p173q1.C3402e;
import p173q1.C3411h;
import p173q1.C3424l0;
import p173q1.C3451u0;
import p230v4.C3988b;
import p230v4.C4004r;

public final class BinderC1703v extends AbstractBinderC1611l {

    public static final C3988b f5691l = new C3988b("MediaRouterProxy", null);

    public final C3451u0 f5692e;

    public final CastOptions f5693f;

    public final HashMap f5694g;

    public final C1730y f5695h;

    public final boolean f5696i;

    public boolean f5697j;

    public boolean f5698k;

    public BinderC1703v(Context context, C3451u0 c3451u0, CastOptions castOptions, C4004r c4004r) {
        super("com.google.android.gms.cast.framework.internal.IMediaRouter", 0);
        this.f5694g = new HashMap();
        this.f5692e = c3451u0;
        this.f5693f = castOptions;
        if (Build.VERSION.SDK_INT < 33) {
            return;
        }
        f5691l.m7975b("Set up MediaRouterParams based on module flag and CastOptions for Android T or above", new Object[0]);
        this.f5695h = new C1730y(castOptions);
        Intent intent = new Intent(context, (Class<?>) MediaTransferReceiver.class);
        intent.setPackage(context.getPackageName());
        this.f5696i = !context.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty();
        this.f5697j = true;
        c4004r.m8001d(new String[]{"com.google.android.gms.cast.FLAG_OUTPUT_SWITCHER_ENABLED"}).m7128a(new C1675r7(1, this));
    }

    public final void m4028A(C3424l0 c3424l0) {
        Set set = (Set) this.f5694g.get(c3424l0);
        if (set == null) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            this.f5692e.m7075h((AbstractC3427m0) it.next());
        }
    }

    public final void m4029x(MediaSessionCompat mediaSessionCompat) {
        this.f5692e.getClass();
        C3451u0.m7067b();
        C3411h c3411hM7068c = C3451u0.m7068c();
        c3411hM7068c.f11486D = mediaSessionCompat;
        C3402e c3402e = mediaSessionCompat != null ? new C3402e(c3411hM7068c, mediaSessionCompat) : null;
        C3402e c3402e2 = c3411hM7068c.f11485C;
        if (c3402e2 != null) {
            c3402e2.m6901a();
        }
        c3411hM7068c.f11485C = c3402e;
        if (c3402e != null) {
            c3411hM7068c.m6946m();
        }
    }

    public final boolean m4030y() {
        CastOptions castOptions;
        return this.f5696i && this.f5697j && (castOptions = this.f5693f) != null && castOptions.f4775m;
    }

    public final void m4031z(C3424l0 c3424l0, int i6) {
        Set set = (Set) this.f5694g.get(c3424l0);
        if (set == null) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            this.f5692e.m7074a(c3424l0, (AbstractC3427m0) it.next(), i6);
        }
    }
}

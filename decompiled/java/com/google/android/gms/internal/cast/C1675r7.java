package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.media.widget.ExpandedControllerActivity;
import java.nio.charset.Charset;
import java.util.List;
import p018b5.AbstractC1312l;
import p173q1.C3390a;
import p173q1.C3411h;
import p173q1.C3434o1;
import p173q1.C3435p;
import p173q1.C3442r0;
import p173q1.C3451u0;
import p173q1.C3455w0;
import p173q1.C3457x0;
import p173q1.HandlerC3393b;
import p176q4.AbstractC3481g;
import p176q4.C3473b;
import p176q4.C3475c;
import p176q4.C3477d;
import p176q4.InterfaceC3483i;
import p199s4.InterfaceC3707a;
import p219u4.C3895c;
import p230v4.C3988b;
import p242w5.InterfaceC4053a;

public final class C1675r7 implements InterfaceC4053a, InterfaceC3483i, InterfaceC3707a, InterfaceC1693t7 {

    public static final C1661q2 f5588c = new C1661q2(25);

    public final int f5589a;

    public final Object f5590b;

    public C1675r7(int i6, Object obj) {
        this.f5589a = i6;
        this.f5590b = obj;
    }

    public void m3992A(int i6, Object obj, InterfaceC1520b8 interfaceC1520b8) throws C1549e7 {
        C1539d7 c1539d7 = (C1539d7) this.f5590b;
        c1539d7.m3794D(i6, 3);
        interfaceC1520b8.mo3735a((AbstractC1728x6) obj, c1539d7.f5249d);
        c1539d7.m3794D(i6, 4);
    }

    public void m3993B(int i6, int i10) throws C1549e7 {
        ((C1539d7) this.f5590b).m3791A(i6, i10);
    }

    public void m3994C(int i6, long j10) throws C1549e7 {
        ((C1539d7) this.f5590b).m3797G(i6, j10);
    }

    public void m3995D(int i6, Object obj, InterfaceC1520b8 interfaceC1520b8) throws C1549e7 {
        AbstractC1728x6 abstractC1728x6 = (AbstractC1728x6) obj;
        C1539d7 c1539d7 = (C1539d7) this.f5590b;
        c1539d7.m3796F((i6 << 3) | 2);
        c1539d7.m3796F(abstractC1728x6.mo3866a(interfaceC1520b8));
        interfaceC1520b8.mo3735a(abstractC1728x6, c1539d7.f5249d);
    }

    public void m3996E(int i6, int i10) throws C1549e7 {
        ((C1539d7) this.f5590b).m3801w(i6, i10);
    }

    public void m3997F(int i6, long j10) throws C1549e7 {
        ((C1539d7) this.f5590b).m3803y(i6, j10);
    }

    @Override
    public void mo3717a(AbstractC3481g abstractC3481g, int i6) {
        switch (this.f5589a) {
            case 2:
                break;
            default:
                C1624m2 c1624m2 = (C1624m2) this.f5590b;
                c1624m2.f5415h = (C3475c) abstractC3481g;
                C1624m2.m3932a(c1624m2, i6);
                break;
        }
    }

    @Override
    public void mo3998b(C3477d c3477d) {
        CastOptions castOptions;
        boolean z7 = false;
        boolean zM7132e = c3477d.m7132e();
        C3988b c3988b = BinderC1703v.f5691l;
        BinderC1703v binderC1703v = (BinderC1703v) this.f5590b;
        if (zM7132e) {
            Bundle bundle = (Bundle) c3477d.m7131d();
            boolean z10 = bundle != null && bundle.containsKey("com.google.android.gms.cast.FLAG_OUTPUT_SWITCHER_ENABLED");
            c3988b.m7975b("The module-to-client output switcher flag %s", true != z10 ? "not existed" : "existed");
            if (z10) {
                binderC1703v.f5697j = bundle.getBoolean("com.google.android.gms.cast.FLAG_OUTPUT_SWITCHER_ENABLED");
            }
        }
        boolean z11 = binderC1703v.f5697j;
        if (binderC1703v.f5692e == null || (castOptions = binderC1703v.f5693f) == null) {
            return;
        }
        boolean z12 = z11 && castOptions.f4775m;
        C3455w0 c3455w0 = new C3455w0();
        int i6 = Build.VERSION.SDK_INT;
        c3455w0.f11702a = i6 >= 30;
        if (i6 >= 30) {
            c3455w0.f11702a = z12;
        }
        boolean z13 = castOptions.f4773k;
        if (i6 >= 30) {
            c3455w0.f11704c = z13;
        }
        boolean z14 = castOptions.f4772j;
        if (i6 >= 30) {
            c3455w0.f11703b = z14;
        }
        if (i6 >= 30) {
            c3455w0.f11705d = castOptions.f4780r;
        }
        C3457x0 c3457x0 = new C3457x0(c3455w0);
        C3451u0.m7067b();
        C3411h c3411hM7068c = C3451u0.m7068c();
        C3457x0 c3457x1 = c3411hM7068c.f11508u;
        c3411hM7068c.f11508u = c3457x0;
        boolean zM6941h = c3411hM7068c.m6941h();
        HandlerC3393b handlerC3393b = c3411hM7068c.f11488a;
        if (zM6941h) {
            if (c3411hM7068c.f11505r == null) {
                C3435p c3435p = new C3435p(c3411hM7068c.f11494g, new C3390a(c3411hM7068c));
                c3411hM7068c.f11505r = c3435p;
                c3411hM7068c.m6934a(c3435p, true);
                c3411hM7068c.m6945l();
            }
            C3435p c3435p2 = c3411hM7068c.f11505r;
            boolean z15 = c3457x0.f11711d;
            c3435p2.f11617p = z15;
            c3435p2.m7011i();
            C3434o1 c3434o1 = c3411hM7068c.f11490c;
            c3434o1.f11605f = z15;
            c3434o1.f11602c.post(c3434o1.f11608i);
            if ((c3457x1 != null && c3457x1.f11710c) != c3457x0.f11710c) {
                C3435p c3435p3 = c3411hM7068c.f11505r;
                c3435p3.f11454e = c3411hM7068c.f11483A;
                if (!c3435p3.f11455f) {
                    c3435p3.f11455f = true;
                    c3435p3.f11452c.sendEmptyMessage(2);
                }
            }
        } else {
            C3435p c3435p4 = c3411hM7068c.f11505r;
            if (c3435p4 != null) {
                C3442r0 c3442r0M6937d = c3411hM7068c.m6937d(c3435p4);
                if (c3442r0M6937d != null) {
                    C3451u0.m7067b();
                    c3435p4.f11453d = null;
                    c3435p4.m6908g(null);
                    c3411hM7068c.m6947n(c3442r0M6937d, null);
                    handlerC3393b.m6886b(514, c3442r0M6937d);
                    c3411hM7068c.f11499l.remove(c3442r0M6937d);
                }
                c3411hM7068c.f11505r = null;
                C3434o1 c3434o2 = c3411hM7068c.f11490c;
                c3434o2.f11602c.post(c3434o2.f11608i);
            }
        }
        handlerC3393b.m6886b(769, c3457x0);
        boolean z16 = binderC1703v.f5696i;
        Log.i(c3988b.f13521a, c3988b.m7977d("media transfer = %b, session transfer = %b, transfer to local = %b, in-app output switcher = %b", Boolean.valueOf(z16), Boolean.valueOf(z12), Boolean.valueOf(z13), Boolean.valueOf(z14)));
        C1730y c1730y = binderC1703v.f5695h;
        if (c1730y != null) {
            if (z16 && z12) {
                z7 = true;
            }
            c1730y.f5732e = z7;
        }
        if (z16 && z12) {
            C1670r2.m3989a(EnumC1679s2.CAST_OUTPUT_SWITCHER_ENABLED);
        }
        if (z13) {
            C1670r2.m3989a(EnumC1679s2.CAST_TRANSFER_TO_LOCAL_ENABLED);
        }
    }

    @Override
    public C1510a8 mo3975c(Class cls) {
        for (int i6 = 0; i6 < 2; i6++) {
            InterfaceC1693t7 interfaceC1693t7 = ((InterfaceC1693t7[]) this.f5590b)[i6];
            if (interfaceC1693t7.mo3976e(cls)) {
                return interfaceC1693t7.mo3975c(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override
    public void mo3718d(AbstractC3481g abstractC3481g, boolean z7) {
        switch (this.f5589a) {
            case 2:
                break;
            default:
                C1624m2.f5407i.m7975b("onSessionResumed with wasSuspended = %b", Boolean.valueOf(z7));
                C1624m2 c1624m2 = (C1624m2) this.f5590b;
                c1624m2.f5415h = (C3475c) abstractC3481g;
                c1624m2.m3934c();
                AbstractC1312l.m3198e(c1624m2.f5414g);
                C1575h3 c1575h3M3971b = c1624m2.f5410c.m3971b(c1624m2.f5414g);
                C1515b3 c1515b3M3745m = C1525c3.m3745m(c1575h3M3971b.m3837d());
                c1515b3M3745m.m3841c();
                C1525c3.m3752t((C1525c3) c1515b3M3745m.f5338b, z7);
                c1575h3M3971b.m3841c();
                C1585i3.m3852q((C1585i3) c1575h3M3971b.f5338b, (C1525c3) c1515b3M3745m.m3839a());
                c1624m2.f5408a.m4015a((C1585i3) c1575h3M3971b.m3839a(), 227);
                C1624m2.m3933b(c1624m2);
                c1624m2.m3936e();
                break;
        }
    }

    @Override
    public boolean mo3976e(Class cls) {
        for (int i6 = 0; i6 < 2; i6++) {
            if (((InterfaceC1693t7[]) this.f5590b)[i6].mo3976e(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void mo3999f(Bitmap bitmap) {
        if (bitmap != null) {
            C1592j0 c1592j0 = (C1592j0) this.f5590b;
            View view = (View) c1592j0.f5359e;
            if (view != null) {
                view.setVisibility(4);
            }
            ImageView imageView = c1592j0.f5357c;
            imageView.setVisibility(0);
            imageView.setImageBitmap(bitmap);
            C3895c c3895c = (C3895c) c1592j0.f5360f;
            if (c3895c != null) {
                c3895c.getClass();
                int i6 = ExpandedControllerActivity.f4902n0;
                c3895c.f13094a.m3633u();
            }
        }
    }

    @Override
    public void mo3719g(AbstractC3481g abstractC3481g, int i6) {
        switch (this.f5589a) {
            case 2:
                break;
            default:
                C1624m2.f5407i.m7975b("onSessionSuspended with reason = %d", Integer.valueOf(i6));
                C1624m2 c1624m2 = (C1624m2) this.f5590b;
                c1624m2.f5415h = (C3475c) abstractC3481g;
                c1624m2.m3934c();
                AbstractC1312l.m3198e(c1624m2.f5414g);
                c1624m2.f5408a.m4015a(c1624m2.f5410c.m3970a(c1624m2.f5414g, i6), 225);
                C1624m2.m3933b(c1624m2);
                c1624m2.f5412e.removeCallbacks(c1624m2.f5411d);
                break;
        }
    }

    @Override
    public void mo3720h(AbstractC3481g abstractC3481g, String str) {
        Object obj = this.f5590b;
        switch (this.f5589a) {
            case 2:
                C3988b c3988b = C1730y.f5727g;
                C1730y c1730y = (C1730y) obj;
                c1730y.getClass();
                c3988b.m7975b("onSessionStarted with transferType = %d", 0);
                if (c1730y.f5732e) {
                    boolean z7 = c1730y.f5728a.f4779q;
                }
                c1730y.m4055a();
                break;
            default:
                C1624m2.f5407i.m7975b("onSessionStarted with sessionId = %s", str);
                C1624m2 c1624m2 = (C1624m2) obj;
                c1624m2.f5415h = (C3475c) abstractC3481g;
                c1624m2.m3934c();
                C1634n2 c1634n2 = c1624m2.f5414g;
                c1634n2.f5431f = str;
                c1624m2.f5408a.m4015a((C1585i3) c1624m2.f5410c.m3971b(c1634n2).m3839a(), 222);
                C1624m2.m3933b(c1624m2);
                c1624m2.m3936e();
                break;
        }
    }

    @Override
    public void mo3721i(AbstractC3481g abstractC3481g, int i6) {
        switch (this.f5589a) {
            case 2:
                break;
            default:
                C1624m2 c1624m2 = (C1624m2) this.f5590b;
                c1624m2.f5415h = (C3475c) abstractC3481g;
                C1624m2.m3932a(c1624m2, i6);
                break;
        }
    }

    public void m4000j(int i6, int i10) throws C1549e7 {
        ((C1539d7) this.f5590b).m3795E(i6, (i10 >> 31) ^ (i10 + i10));
    }

    @Override
    public void mo3722k(AbstractC3481g abstractC3481g, String str) {
        C1634n2 c1634n2;
        C3475c c3475c;
        boolean z7 = false;
        switch (this.f5589a) {
            case 2:
                break;
            default:
                C3988b c3988b = C1624m2.f5407i;
                c3988b.m7975b("onSessionResuming with sessionId = %s", str);
                C1624m2 c1624m2 = (C1624m2) this.f5590b;
                c1624m2.f5415h = (C3475c) abstractC3481g;
                if (c1624m2.m3939h(str)) {
                    c3988b.m7975b("Use the existing ApplicationAnalyticsSession if it is available and valid.", new Object[0]);
                    AbstractC1312l.m3198e(c1624m2.f5414g);
                } else {
                    SharedPreferences sharedPreferences = c1624m2.f5413f;
                    BinderC1571h binderC1571h = c1624m2.f5409b;
                    if (sharedPreferences == null) {
                        C3988b c3988b2 = C1634n2.f5424q;
                    } else {
                        c1634n2 = new C1634n2(binderC1571h);
                        c1634n2.f5440o = sharedPreferences.getBoolean("is_output_switcher_enabled", false);
                        if (sharedPreferences.contains("application_id")) {
                            c1634n2.f5427b = sharedPreferences.getString("application_id", "");
                            if (sharedPreferences.contains("receiver_metrics_id")) {
                                c1634n2.f5428c = sharedPreferences.getString("receiver_metrics_id", "");
                                if (sharedPreferences.contains("analytics_session_id")) {
                                    c1634n2.f5429d = sharedPreferences.getLong("analytics_session_id", 0L);
                                    if (sharedPreferences.contains("event_sequence_number")) {
                                        c1634n2.f5430e = sharedPreferences.getInt("event_sequence_number", 0);
                                        if (sharedPreferences.contains("receiver_session_id")) {
                                            c1634n2.f5431f = sharedPreferences.getString("receiver_session_id", "");
                                            c1634n2.f5432g = sharedPreferences.getInt("device_capabilities", 0);
                                            c1634n2.f5433h = sharedPreferences.getString("device_model_name", "");
                                            c1634n2.f5434i = sharedPreferences.getString("manufacturer", "");
                                            c1634n2.f5435j = sharedPreferences.getString("product_name", "");
                                            c1634n2.f5436k = sharedPreferences.getString("build_type", "");
                                            c1634n2.f5437l = sharedPreferences.getString("cast_build_version", "");
                                            c1634n2.f5438m = sharedPreferences.getString("system_build_number", "");
                                            c1634n2.f5439n = sharedPreferences.getInt("device_category", 0);
                                            c1634n2.f5441p = sharedPreferences.getInt("analytics_session_start_type", 0);
                                        }
                                    }
                                }
                            }
                        }
                        c1624m2.f5414g = c1634n2;
                        if (c1624m2.m3939h(str)) {
                            c3988b.m7975b("Use the restored ApplicationAnalyticsSession if it is valid.", new Object[0]);
                            AbstractC1312l.m3198e(c1624m2.f5414g);
                            C1634n2.f5425r = c1624m2.f5414g.f5429d + 1;
                        } else {
                            c3988b.m7975b("The restored ApplicationAnalyticsSession is not valid, create a new one.", new Object[0]);
                            C1634n2 c1634n3 = new C1634n2(binderC1571h);
                            C1634n2.f5425r++;
                            c1624m2.f5414g = c1634n3;
                            c3475c = c1624m2.f5415h;
                            if (c3475c != null && c3475c.f11760g.m4030y()) {
                                z7 = true;
                            }
                            c1634n3.f5440o = z7;
                            C1634n2 c1634n4 = c1624m2.f5414g;
                            AbstractC1312l.m3198e(c1634n4);
                            C3988b c3988b3 = C3473b.f11740k;
                            AbstractC1312l.m3195b("Must be called from the main thread.");
                            C3473b c3473b = C3473b.f11742m;
                            AbstractC1312l.m3198e(c3473b);
                            AbstractC1312l.m3195b("Must be called from the main thread.");
                            c1634n4.f5427b = c3473b.f11747e.f4763a;
                            C1634n2 c1634n5 = c1624m2.f5414g;
                            AbstractC1312l.m3198e(c1634n5);
                            c1634n5.f5431f = str;
                        }
                    }
                    c1634n2 = null;
                    c1624m2.f5414g = c1634n2;
                    if (c1624m2.m3939h(str)) {
                        c3988b.m7975b("Use the restored ApplicationAnalyticsSession if it is valid.", new Object[0]);
                        AbstractC1312l.m3198e(c1624m2.f5414g);
                        C1634n2.f5425r = c1624m2.f5414g.f5429d + 1;
                    } else {
                        c3988b.m7975b("The restored ApplicationAnalyticsSession is not valid, create a new one.", new Object[0]);
                        C1634n2 c1634n6 = new C1634n2(binderC1571h);
                        C1634n2.f5425r++;
                        c1624m2.f5414g = c1634n6;
                        c3475c = c1624m2.f5415h;
                        if (c3475c != null) {
                            z7 = true;
                        }
                        c1634n6.f5440o = z7;
                        C1634n2 c1634n7 = c1624m2.f5414g;
                        AbstractC1312l.m3198e(c1634n7);
                        C3988b c3988b4 = C3473b.f11740k;
                        AbstractC1312l.m3195b("Must be called from the main thread.");
                        C3473b c3473b2 = C3473b.f11742m;
                        AbstractC1312l.m3198e(c3473b2);
                        AbstractC1312l.m3195b("Must be called from the main thread.");
                        c1634n7.f5427b = c3473b2.f11747e.f4763a;
                        C1634n2 c1634n8 = c1624m2.f5414g;
                        AbstractC1312l.m3198e(c1634n8);
                        c1634n8.f5431f = str;
                    }
                }
                AbstractC1312l.m3198e(c1624m2.f5414g);
                C1575h3 c1575h3M3971b = c1624m2.f5410c.m3971b(c1624m2.f5414g);
                C1515b3 c1515b3M3745m = C1525c3.m3745m(c1575h3M3971b.m3837d());
                c1515b3M3745m.m3841c();
                C1525c3.m3753u((C1525c3) c1515b3M3745m.f5338b, 10);
                c1575h3M3971b.m3838e((C1525c3) c1515b3M3745m.m3839a());
                C1515b3 c1515b3M3745m2 = C1525c3.m3745m(c1575h3M3971b.m3837d());
                c1515b3M3745m2.m3841c();
                C1525c3.m3752t((C1525c3) c1515b3M3745m2.f5338b, true);
                c1575h3M3971b.m3841c();
                C1585i3.m3852q((C1585i3) c1575h3M3971b.f5338b, (C1525c3) c1515b3M3745m2.m3839a());
                c1624m2.f5408a.m4015a((C1585i3) c1575h3M3971b.m3839a(), 226);
                break;
        }
    }

    @Override
    public void mo3723l(AbstractC3481g abstractC3481g) {
        switch (this.f5589a) {
            case 2:
                break;
            default:
                ((C1624m2) this.f5590b).f5415h = (C3475c) abstractC3481g;
                break;
        }
    }

    @Override
    public void mo3724m(AbstractC3481g abstractC3481g, int i6) {
        Object obj = this.f5590b;
        switch (this.f5589a) {
            case 2:
                C3988b c3988b = C1730y.f5727g;
                c3988b.m7975b("onSessionEnded with error = %d", Integer.valueOf(i6));
                C1730y c1730y = (C1730y) obj;
                c1730y.getClass();
                c3988b.m7975b("No need to notify transferred if the transfer type is unknown", new Object[0]);
                c1730y.m4055a();
                break;
            default:
                C1624m2 c1624m2 = (C1624m2) obj;
                c1624m2.f5415h = (C3475c) abstractC3481g;
                C1624m2.m3932a(c1624m2, i6);
                break;
        }
    }

    @Override
    public void mo3725n(AbstractC3481g abstractC3481g) {
        switch (this.f5589a) {
            case 2:
                break;
            default:
                C3988b c3988b = C1624m2.f5407i;
                c3988b.m7975b("onSessionStarting", new Object[0]);
                C1624m2 c1624m2 = (C1624m2) this.f5590b;
                c1624m2.f5415h = (C3475c) abstractC3481g;
                if (c1624m2.f5414g != null) {
                    Log.w(c3988b.f13521a, c3988b.m7977d("Start a session while there's already an active session. Create a new one.", new Object[0]));
                }
                c1624m2.m3935d();
                C1634n2 c1634n2 = c1624m2.f5414g;
                C1575h3 c1575h3M3971b = c1624m2.f5410c.m3971b(c1634n2);
                if (c1634n2.f5441p == 1) {
                    C1515b3 c1515b3M3745m = C1525c3.m3745m(c1575h3M3971b.m3837d());
                    c1515b3M3745m.m3841c();
                    C1525c3.m3753u((C1525c3) c1515b3M3745m.f5338b, 17);
                    c1575h3M3971b.m3838e((C1525c3) c1515b3M3745m.m3839a());
                }
                c1624m2.f5408a.m4015a((C1585i3) c1575h3M3971b.m3839a(), 221);
                break;
        }
    }

    public void m4001o(int i6, long j10) throws C1549e7 {
        ((C1539d7) this.f5590b).m3797G(i6, (j10 >> 63) ^ (j10 + j10));
    }

    public void m4002p(int i6, List list) throws C1549e7 {
        for (int i10 = 0; i10 < list.size(); i10++) {
            ((C1539d7) this.f5590b).m3793C(i6, (String) list.get(i10));
        }
    }

    public void m4003q(int i6, int i10) throws C1549e7 {
        ((C1539d7) this.f5590b).m3795E(i6, i10);
    }

    public void m4004r(int i6, long j10) throws C1549e7 {
        ((C1539d7) this.f5590b).m3797G(i6, j10);
    }

    public void m4005s(int i6, boolean z7) throws C1549e7 {
        IndexOutOfBoundsException indexOutOfBoundsException;
        C1539d7 c1539d7 = (C1539d7) this.f5590b;
        c1539d7.m3796F(i6 << 3);
        int i10 = c1539d7.f5252g;
        try {
            int i11 = i10 + 1;
            try {
                c1539d7.f5250e[i10] = z7 ? (byte) 1 : (byte) 0;
                c1539d7.f5252g = i11;
            } catch (IndexOutOfBoundsException e5) {
                indexOutOfBoundsException = e5;
                i10 = i11;
                throw new C1549e7(i10, c1539d7.f5251f, 1, indexOutOfBoundsException);
            }
        } catch (IndexOutOfBoundsException e10) {
            indexOutOfBoundsException = e10;
        }
    }

    public void m4006t(int i6, C1529c7 c1529c7) throws C1549e7 {
        ((C1539d7) this.f5590b).m3800v(i6, c1529c7);
    }

    public void m4007u(int i6, List list) throws C1549e7 {
        for (int i10 = 0; i10 < list.size(); i10++) {
            ((C1539d7) this.f5590b).m3800v(i6, (C1529c7) list.get(i10));
        }
    }

    public void m4008v(int i6, double d) throws C1549e7 {
        ((C1539d7) this.f5590b).m3803y(i6, Double.doubleToRawLongBits(d));
    }

    public void m4009w(int i6, int i10) throws C1549e7 {
        ((C1539d7) this.f5590b).m3791A(i6, i10);
    }

    public void m4010x(int i6, int i10) throws C1549e7 {
        ((C1539d7) this.f5590b).m3801w(i6, i10);
    }

    public void m4011y(int i6, long j10) throws C1549e7 {
        ((C1539d7) this.f5590b).m3803y(i6, j10);
    }

    public void m4012z(int i6, float f) throws C1549e7 {
        ((C1539d7) this.f5590b).m3801w(i6, Float.floatToRawIntBits(f));
    }

    public C1675r7() {
        this.f5589a = 0;
        C1738y7 c1738y7 = C1738y7.f5738c;
        C1675r7 c1675r7 = new C1675r7(6, new InterfaceC1693t7[]{C1661q2.f5564p, f5588c});
        Charset charset = AbstractC1639n7.f5472a;
        this.f5590b = c1675r7;
    }

    public C1675r7(C1539d7 c1539d7) {
        this.f5589a = 5;
        Charset charset = AbstractC1639n7.f5472a;
        this.f5590b = c1539d7;
        c1539d7.f5249d = this;
    }
}

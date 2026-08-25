package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.internal.zzaa;
import p018b5.AbstractC1312l;
import p176q4.C3473b;
import p176q4.C3475c;
import p230v4.C3988b;

public final class C1624m2 {

    public static final C3988b f5407i = new C3988b("ApplicationAnalytics", null);

    public final C1678s1 f5408a;

    public final BinderC1571h f5409b;

    public final C1652p2 f5410c;

    public final SharedPreferences f5413f;

    public C1634n2 f5414g;

    public C3475c f5415h;

    public final HandlerC1731y0 f5412e = new HandlerC1731y0(Looper.getMainLooper(), 0);

    public final RunnableC1502a0 f5411d = new RunnableC1502a0(2, this);

    public C1624m2(SharedPreferences sharedPreferences, C1678s1 c1678s1, BinderC1571h binderC1571h, Bundle bundle, String str) {
        this.f5413f = sharedPreferences;
        this.f5408a = c1678s1;
        this.f5409b = binderC1571h;
        this.f5410c = new C1652p2(str, bundle);
    }

    public static void m3932a(C1624m2 c1624m2, int i6) {
        f5407i.m7975b("log session ended with error = %d", Integer.valueOf(i6));
        c1624m2.m3934c();
        c1624m2.f5408a.m4015a(c1624m2.f5410c.m3970a(c1624m2.f5414g, i6), 228);
        c1624m2.f5412e.removeCallbacks(c1624m2.f5411d);
        c1624m2.f5414g = null;
    }

    public static void m3933b(C1624m2 c1624m2) {
        C1634n2 c1634n2 = c1624m2.f5414g;
        c1634n2.getClass();
        SharedPreferences sharedPreferences = c1624m2.f5413f;
        if (sharedPreferences == null) {
            return;
        }
        C1634n2.f5424q.m7975b("Save the ApplicationAnalyticsSession to SharedPreferences %s", sharedPreferences);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("application_id", c1634n2.f5427b);
        editorEdit.putString("receiver_metrics_id", c1634n2.f5428c);
        editorEdit.putLong("analytics_session_id", c1634n2.f5429d);
        editorEdit.putInt("event_sequence_number", c1634n2.f5430e);
        editorEdit.putString("receiver_session_id", c1634n2.f5431f);
        editorEdit.putInt("device_capabilities", c1634n2.f5432g);
        editorEdit.putString("device_model_name", c1634n2.f5433h);
        editorEdit.putString("manufacturer", c1634n2.f5434i);
        editorEdit.putString("product_name", c1634n2.f5435j);
        editorEdit.putString("build_type", c1634n2.f5436k);
        editorEdit.putString("cast_build_version", c1634n2.f5437l);
        editorEdit.putString("system_build_number", c1634n2.f5438m);
        editorEdit.putInt("device_category", c1634n2.f5439n);
        editorEdit.putInt("analytics_session_start_type", c1634n2.f5441p);
        editorEdit.putBoolean("is_output_switcher_enabled", c1634n2.f5440o);
        editorEdit.apply();
    }

    public final void m3934c() {
        if (!m3938g()) {
            C3988b c3988b = f5407i;
            Log.w(c3988b.f13521a, c3988b.m7977d("The analyticsSession should not be null for logging. Create a dummy one.", new Object[0]));
            m3935d();
        } else {
            C3475c c3475c = this.f5415h;
            CastDevice castDeviceM7124e = c3475c != null ? c3475c.m7124e() : null;
            if (castDeviceM7124e != null && !TextUtils.equals(this.f5414g.f5428c, castDeviceM7124e.f4611l)) {
                m3937f(castDeviceM7124e);
            }
            AbstractC1312l.m3198e(this.f5414g);
        }
    }

    public final void m3935d() {
        f5407i.m7975b("Create a new ApplicationAnalyticsSession based on CastSession", new Object[0]);
        C1634n2 c1634n2 = new C1634n2(this.f5409b);
        C1634n2.f5425r++;
        this.f5414g = c1634n2;
        C3475c c3475c = this.f5415h;
        c1634n2.f5440o = c3475c != null && c3475c.f11760g.m4030y();
        C1634n2 c1634n3 = this.f5414g;
        AbstractC1312l.m3198e(c1634n3);
        C3988b c3988b = C3473b.f11740k;
        AbstractC1312l.m3195b("Must be called from the main thread.");
        C3473b c3473b = C3473b.f11742m;
        AbstractC1312l.m3198e(c3473b);
        AbstractC1312l.m3195b("Must be called from the main thread.");
        c1634n3.f5427b = c3473b.f11747e.f4763a;
        C3475c c3475c2 = this.f5415h;
        CastDevice castDeviceM7124e = c3475c2 == null ? null : c3475c2.m7124e();
        if (castDeviceM7124e != null) {
            m3937f(castDeviceM7124e);
        }
        C1634n2 c1634n4 = this.f5414g;
        AbstractC1312l.m3198e(c1634n4);
        C3475c c3475c3 = this.f5415h;
        c1634n4.f5441p = c3475c3 != null ? c3475c3.m7138c() : 0;
        AbstractC1312l.m3198e(this.f5414g);
    }

    public final void m3936e() {
        HandlerC1731y0 handlerC1731y0 = this.f5412e;
        AbstractC1312l.m3198e(handlerC1731y0);
        RunnableC1502a0 runnableC1502a0 = this.f5411d;
        AbstractC1312l.m3198e(runnableC1502a0);
        handlerC1731y0.postDelayed(runnableC1502a0, 300000L);
    }

    public final void m3937f(CastDevice castDevice) {
        C1634n2 c1634n2 = this.f5414g;
        if (c1634n2 == null) {
            return;
        }
        c1634n2.f5428c = castDevice.f4611l;
        c1634n2.f5432g = castDevice.f4608i.f2374a;
        c1634n2.f5433h = castDevice.f4604e;
        c1634n2.f5439n = castDevice.m3586m();
        zzaa zzaaVarM3587n = castDevice.m3587n();
        if (zzaaVarM3587n != null) {
            String str = zzaaVarM3587n.f4950d;
            if (str != null) {
                c1634n2.f5434i = str;
            }
            String str2 = zzaaVarM3587n.f4951e;
            if (str2 != null) {
                c1634n2.f5435j = str2;
            }
            String str3 = zzaaVarM3587n.f4952f;
            if (str3 != null) {
                c1634n2.f5436k = str3;
            }
            String str4 = zzaaVarM3587n.f4953g;
            if (str4 != null) {
                c1634n2.f5437l = str4;
            }
            String str5 = zzaaVarM3587n.f4954h;
            if (str5 != null) {
                c1634n2.f5438m = str5;
            }
        }
    }

    public final boolean m3938g() {
        String str;
        C1634n2 c1634n2 = this.f5414g;
        C3988b c3988b = f5407i;
        if (c1634n2 == null) {
            c3988b.m7975b("The analytics session is null when matching with application ID.", new Object[0]);
            return false;
        }
        C3988b c3988b2 = C3473b.f11740k;
        AbstractC1312l.m3195b("Must be called from the main thread.");
        C3473b c3473b = C3473b.f11742m;
        AbstractC1312l.m3198e(c3473b);
        AbstractC1312l.m3195b("Must be called from the main thread.");
        String str2 = c3473b.f11747e.f4763a;
        if (str2 == null || (str = this.f5414g.f5427b) == null || !TextUtils.equals(str, str2)) {
            c3988b.m7975b("The analytics session doesn't match the application ID %s", str2);
            return false;
        }
        AbstractC1312l.m3198e(this.f5414g);
        return true;
    }

    public final boolean m3939h(String str) {
        String str2;
        if (!m3938g()) {
            return false;
        }
        AbstractC1312l.m3198e(this.f5414g);
        if (str != null && (str2 = this.f5414g.f5431f) != null && TextUtils.equals(str2, str)) {
            return true;
        }
        f5407i.m7975b("The analytics session doesn't match the receiver session ID %s.", str);
        return false;
    }
}

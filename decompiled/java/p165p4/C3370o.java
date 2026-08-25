package p165p4;

import android.content.Context;
import android.os.Handler;
import androidx.leanback.widget.C0486o;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.zzat;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.cast.C1543e1;
import com.google.android.gms.internal.cast.C1602k0;
import com.google.android.gms.internal.cast.HandlerC1731y0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import p018b5.AbstractC1312l;
import p028c6.C1400c;
import p124l6.C2982h;
import p176q4.C3477d;
import p221u6.C3905e;
import p230v4.AbstractC3994h;
import p230v4.C3988b;
import p230v4.InterfaceC3992f;
import p242w5.C4056d;
import p261y4.AbstractC4259g;
import p261y4.C4257e;
import p261y4.C4258f;
import p271z4.C4334e;
import p271z4.C4336g;
import p271z4.C4349t;
import p271z4.C4353x;

public final class C3370o extends AbstractC4259g {

    public static final C3988b f11372F = new C3988b("CastClient", null);

    public static final C2982h f11373G = new C2982h("Cast.API_CXLESS", new C1543e1(3), AbstractC3994h.f13524a);

    public final HashMap f11374A;

    public final HashMap f11375B;

    public final C1602k0 f11376C;

    public final List f11377D;

    public int f11378E;

    public final BinderC3369n f11379j;

    public HandlerC1731y0 f11380k;

    public boolean f11381l;

    public boolean f11382m;

    public C4056d f11383n;

    public C4056d f11384o;

    public final AtomicLong f11385p;

    public final Object f11386q;

    public final Object f11387r;

    public ApplicationMetadata f11388s;

    public String f11389t;

    public double f11390u;

    public boolean f11391v;

    public int f11392w;

    public int f11393x;

    public zzat f11394y;

    public final CastDevice f11395z;

    public C3370o(Context context, C3356a c3356a) {
        super(context, f11373G, c3356a, C4258f.f14454c);
        this.f11379j = new BinderC3369n(this);
        this.f11386q = new Object();
        this.f11387r = new Object();
        this.f11377D = Collections.synchronizedList(new ArrayList());
        this.f11376C = c3356a.f11347b;
        this.f11395z = c3356a.f11346a;
        this.f11374A = new HashMap();
        this.f11375B = new HashMap();
        this.f11385p = new AtomicLong(0L);
        this.f11378E = 1;
        m6866k();
    }

    public static void m6858d(C3370o c3370o, long j10, int i6) {
        C4056d c4056d;
        HashMap map = c3370o.f11374A;
        synchronized (map) {
            Long lValueOf = Long.valueOf(j10);
            c4056d = (C4056d) map.get(lValueOf);
            map.remove(lValueOf);
        }
        if (c4056d != null) {
            if (i6 == 0) {
                c4056d.m8059b(null);
            } else {
                c4056d.m8058a(new C4257e(new Status(i6, null, null, null)));
            }
        }
    }

    public static void m6859e(C3370o c3370o, int i6) {
        synchronized (c3370o.f11387r) {
            try {
                C4056d c4056d = c3370o.f11384o;
                if (c4056d == null) {
                    return;
                }
                if (i6 == 0) {
                    c4056d.m8059b(new Status(0, null, null, null));
                } else {
                    c4056d.m8058a(new C4257e(new Status(i6, null, null, null)));
                }
                c3370o.f11384o = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Handler m6860l(C3370o c3370o) {
        if (c3370o.f11380k == null) {
            c3370o.f11380k = new HandlerC1731y0(c3370o.f14462f, 0);
        }
        return c3370o.f11380k;
    }

    public final C3477d m6861f(InterfaceC3992f interfaceC3992f) {
        C4336g c4336g = m8305b(interfaceC3992f).f14713a;
        AbstractC1312l.m3199f(c4336g, "Key must not be null");
        C4334e c4334e = this.f14465i;
        c4334e.getClass();
        C4056d c4056d = new C4056d();
        c4334e.m8363e(c4056d, 8415, this);
        C4349t c4349t = new C4349t(new C4353x(c4336g, c4056d), c4334e.f14706i.get(), this);
        HandlerC1731y0 handlerC1731y0 = c4334e.f14710m;
        handlerC1731y0.sendMessage(handlerC1731y0.obtainMessage(13, c4349t));
        return c4056d.f13720a;
    }

    public final void m6862g() {
        f11372F.m7975b("removing all MessageReceivedCallbacks", new Object[0]);
        HashMap map = this.f11375B;
        synchronized (map) {
            map.clear();
        }
    }

    public final void m6863h(int i6) {
        synchronized (this.f11386q) {
            try {
                C4056d c4056d = this.f11383n;
                if (c4056d != null) {
                    c4056d.m8058a(new C4257e(new Status(i6, null, null, null)));
                }
                this.f11383n = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final C3477d m6864i() {
        C1400c c1400cM3273c = C1400c.m3273c();
        c1400cM3273c.f4265c = new C3905e(29);
        c1400cM3273c.f4263a = 8403;
        C3477d c3477dM8306c = m8306c(1, c1400cM3273c.m3275b());
        m6862g();
        m6861f(this.f11379j);
        return c3477dM8306c;
    }

    public final boolean m6865j() {
        return this.f11378E == 3;
    }

    public final void m6866k() {
        CastDevice castDevice = this.f11395z;
        if (castDevice.f4608i.m1446a(2048)) {
            return;
        }
        C0486o c0486o = castDevice.f4608i;
        if (!c0486o.m1446a(4) || c0486o.m1446a(1)) {
            return;
        }
        "Chromecast Audio".equals(castDevice.f4604e);
    }
}

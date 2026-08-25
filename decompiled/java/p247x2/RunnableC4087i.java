package p247x2;

import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.C1468f;
import com.bumptech.glide.EnumC1469g;
import com.bumptech.glide.load.data.InterfaceC1479e;
import com.bumptech.glide.load.data.InterfaceC1481g;
import java.util.ArrayList;
import java.util.Collections;
import p000a.AbstractC0004e;
import p012b.C1224a;
import p028c6.C1399b;
import p049e3.C2398p;
import p055ea.AbstractC2460q;
import p186r3.AbstractC3604h;
import p186r3.C3598b;
import p187r4.C3621k;
import p198s3.C3706d;
import p198s3.InterfaceC3704b;
import p215u.AbstractC3885h;
import p228v2.C3980g;
import p228v2.C3981h;
import p228v2.InterfaceC3978e;
import p228v2.InterfaceC3984k;

public final class RunnableC4087i implements InterfaceC4083e, Runnable, Comparable, InterfaceC3704b {

    public volatile boolean f13793A;

    public boolean f13794B;

    public int f13795C;

    public int f13796D;

    public int f13797E;

    public final C1224a f13801d;

    public final C3621k f13802e;

    public C1468f f13805h;

    public InterfaceC3978e f13806i;

    public EnumC1469g f13807j;

    public C4095q f13808k;

    public int f13809l;

    public int f13810m;

    public C4089k f13811n;

    public C3981h f13812o;

    public C4094p f13813p;

    public int f13814q;

    public long f13815r;

    public Object f13816s;

    public Thread f13817t;

    public InterfaceC3978e f13818u;

    public InterfaceC3978e f13819v;

    public Object f13820w;

    public InterfaceC1479e f13821x;

    public volatile InterfaceC4084f f13822y;

    public volatile boolean f13823z;

    public final C4085g f13798a = new C4085g();

    public final ArrayList f13799b = new ArrayList();

    public final C3706d f13800c = new C3706d();

    public final C3621k f13803f = new C3621k(6);

    public final C4086h f13804g = new C4086h();

    public RunnableC4087i(C1224a c1224a, C3621k c3621k) {
        this.f13801d = c1224a;
        this.f13802e = c3621k;
    }

    @Override
    public final void mo8067a(InterfaceC3978e interfaceC3978e, Exception exc, InterfaceC1479e interfaceC1479e, int i6) {
        interfaceC1479e.mo3152b();
        C4098t c4098t = new C4098t("Fetching data failed", Collections.singletonList(exc));
        Class clsMo3151a = interfaceC1479e.mo3151a();
        c4098t.f13890b = interfaceC3978e;
        c4098t.f13891c = i6;
        c4098t.f13892d = clsMo3151a;
        this.f13799b.add(c4098t);
        if (Thread.currentThread() != this.f13817t) {
            m8088o(2);
        } else {
            m8089p();
        }
    }

    @Override
    public final C3706d mo7466b() {
        return this.f13800c;
    }

    @Override
    public final void mo8069c(InterfaceC3978e interfaceC3978e, Object obj, InterfaceC1479e interfaceC1479e, int i6, InterfaceC3978e interfaceC3978e2) {
        this.f13818u = interfaceC3978e;
        this.f13820w = obj;
        this.f13821x = interfaceC1479e;
        this.f13797E = i6;
        this.f13819v = interfaceC3978e2;
        this.f13794B = interfaceC3978e != this.f13798a.m8071a().get(0);
        if (Thread.currentThread() != this.f13817t) {
            m8088o(3);
        } else {
            m8079f();
        }
    }

    @Override
    public final int compareTo(Object obj) {
        RunnableC4087i runnableC4087i = (RunnableC4087i) obj;
        int iOrdinal = this.f13807j.ordinal() - runnableC4087i.f13807j.ordinal();
        return iOrdinal == 0 ? this.f13814q - runnableC4087i.f13814q : iOrdinal;
    }

    public final InterfaceC4102x m8077d(InterfaceC1479e interfaceC1479e, Object obj, int i6) {
        if (obj == null) {
            interfaceC1479e.mo3152b();
            return null;
        }
        try {
            int i10 = AbstractC3604h.f12101b;
            long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            InterfaceC4102x interfaceC4102xM8078e = m8078e(i6, obj);
            if (Log.isLoggable("DecodeJob", 2)) {
                m8082i(jElapsedRealtimeNanos, "Decoded result " + interfaceC4102xM8078e, null);
            }
            return interfaceC4102xM8078e;
        } finally {
            interfaceC1479e.mo3152b();
        }
    }

    public final InterfaceC4102x m8078e(int i6, Object obj) {
        Class<?> cls = obj.getClass();
        C4085g c4085g = this.f13798a;
        C4100v c4100vM8073c = c4085g.m8073c(cls);
        C3981h c3981h = this.f13812o;
        if (Build.VERSION.SDK_INT >= 26) {
            boolean z7 = i6 == 4 || c4085g.f13789r;
            C3980g c3980g = C2398p.f8368i;
            Boolean bool = (Boolean) c3981h.m7967c(c3980g);
            if (bool == null || (bool.booleanValue() && !z7)) {
                c3981h = new C3981h();
                C3981h c3981h2 = this.f13812o;
                C3598b c3598b = c3981h.f13515b;
                c3598b.mo6813g(c3981h2.f13515b);
                c3598b.put(c3980g, Boolean.valueOf(z7));
            }
        }
        C3981h c3981h3 = c3981h;
        InterfaceC1481g interfaceC1481gM3528h = this.f13805h.m3518b().m3528h(obj);
        try {
            return c4100vM8073c.m8121a(this.f13809l, this.f13810m, new C1399b(i6, this), interfaceC1481gM3528h, c3981h3);
        } finally {
            interfaceC1481gM3528h.mo3550b();
        }
    }

    public final void m8079f() {
        InterfaceC4102x interfaceC4102xM8077d;
        if (Log.isLoggable("DecodeJob", 2)) {
            m8082i(this.f13815r, "Retrieved data", "data: " + this.f13820w + ", cache key: " + this.f13818u + ", fetcher: " + this.f13821x);
        }
        C4101w c4101w = null;
        try {
            interfaceC4102xM8077d = m8077d(this.f13821x, this.f13820w, this.f13797E);
        } catch (C4098t e5) {
            InterfaceC3978e interfaceC3978e = this.f13819v;
            int i6 = this.f13797E;
            e5.f13890b = interfaceC3978e;
            e5.f13891c = i6;
            e5.f13892d = null;
            this.f13799b.add(e5);
            interfaceC4102xM8077d = null;
        }
        if (interfaceC4102xM8077d == null) {
            m8089p();
            return;
        }
        int i10 = this.f13797E;
        boolean z7 = this.f13794B;
        if (interfaceC4102xM8077d instanceof InterfaceC4099u) {
            ((InterfaceC4099u) interfaceC4102xM8077d).initialize();
        }
        boolean z10 = true;
        if (((C4101w) this.f13803f.f12172d) != null) {
            c4101w = (C4101w) C4101w.f13897e.m7329f();
            c4101w.f13901d = false;
            c4101w.f13900c = true;
            c4101w.f13899b = interfaceC4102xM8077d;
            interfaceC4102xM8077d = c4101w;
        }
        m8091r();
        C4094p c4094p = this.f13813p;
        synchronized (c4094p) {
            c4094p.f13861n = interfaceC4102xM8077d;
            c4094p.f13862o = i10;
            c4094p.f13869v = z7;
        }
        c4094p.m8110h();
        this.f13795C = 5;
        try {
            C3621k c3621k = this.f13803f;
            if (((C4101w) c3621k.f12172d) == null) {
                z10 = false;
            }
            if (z10) {
                C1224a c1224a = this.f13801d;
                C3981h c3981h = this.f13812o;
                c3621k.getClass();
                try {
                    c1224a.m3103a().mo6923c((InterfaceC3978e) c3621k.f12170b, new C3621k((InterfaceC3984k) c3621k.f12171c, (C4101w) c3621k.f12172d, c3981h, 5));
                    ((C4101w) c3621k.f12172d).m8122e();
                } catch (Throwable th) {
                    ((C4101w) c3621k.f12172d).m8122e();
                    throw th;
                }
            }
            if (c4101w != null) {
                c4101w.m8122e();
            }
            m8084k();
        } catch (Throwable th2) {
            if (c4101w != null) {
                c4101w.m8122e();
            }
            throw th2;
        }
    }

    public final InterfaceC4084f m8080g() {
        int iM7785a = AbstractC3885h.m7785a(this.f13795C);
        C4085g c4085g = this.f13798a;
        if (iM7785a == 1) {
            return new C4103y(c4085g, this);
        }
        if (iM7785a == 2) {
            return new C4081c(c4085g.m8071a(), c4085g, this);
        }
        if (iM7785a == 3) {
            return new C4079a0(c4085g, this);
        }
        if (iM7785a == 5) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: ".concat(AbstractC2460q.m5505s(this.f13795C)));
    }

    public final int m8081h(int i6) {
        boolean z7;
        boolean z10;
        int iM7785a = AbstractC3885h.m7785a(i6);
        if (iM7785a == 0) {
            switch (this.f13811n.f13832a) {
                case 0:
                case 1:
                    z7 = false;
                    break;
                default:
                    z7 = true;
                    break;
            }
            if (z7) {
                return 2;
            }
            return m8081h(2);
        }
        if (iM7785a != 1) {
            if (iM7785a == 2) {
                return 4;
            }
            if (iM7785a == 3 || iM7785a == 5) {
                return 6;
            }
            throw new IllegalArgumentException("Unrecognized stage: ".concat(AbstractC2460q.m5505s(i6)));
        }
        switch (this.f13811n.f13832a) {
            case 0:
                z10 = false;
                break;
            case 1:
            default:
                z10 = true;
                break;
        }
        if (z10) {
            return 3;
        }
        return m8081h(3);
    }

    public final void m8082i(long j10, String str, String str2) {
        StringBuilder sbM29w = AbstractC0004e.m29w(str, " in ");
        sbM29w.append(AbstractC3604h.m7226a(j10));
        sbM29w.append(", load key: ");
        sbM29w.append(this.f13808k);
        sbM29w.append(str2 != null ? ", ".concat(str2) : "");
        sbM29w.append(", thread: ");
        sbM29w.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sbM29w.toString());
    }

    public final void m8083j() {
        m8091r();
        C4098t c4098t = new C4098t("Failed to load resource", new ArrayList(this.f13799b));
        C4094p c4094p = this.f13813p;
        synchronized (c4094p) {
            c4094p.f13864q = c4098t;
        }
        c4094p.m8109g();
        m8085l();
    }

    public final void m8084k() {
        boolean zM8076a;
        C4086h c4086h = this.f13804g;
        synchronized (c4086h) {
            c4086h.f13791b = true;
            zM8076a = c4086h.m8076a();
        }
        if (zM8076a) {
            m8087n();
        }
    }

    public final void m8085l() {
        boolean zM8076a;
        C4086h c4086h = this.f13804g;
        synchronized (c4086h) {
            c4086h.f13792c = true;
            zM8076a = c4086h.m8076a();
        }
        if (zM8076a) {
            m8087n();
        }
    }

    public final void m8086m() {
        boolean zM8076a;
        C4086h c4086h = this.f13804g;
        synchronized (c4086h) {
            c4086h.f13790a = true;
            zM8076a = c4086h.m8076a();
        }
        if (zM8076a) {
            m8087n();
        }
    }

    public final void m8087n() {
        C4086h c4086h = this.f13804g;
        synchronized (c4086h) {
            c4086h.f13791b = false;
            c4086h.f13790a = false;
            c4086h.f13792c = false;
        }
        C3621k c3621k = this.f13803f;
        c3621k.f12170b = null;
        c3621k.f12171c = null;
        c3621k.f12172d = null;
        C4085g c4085g = this.f13798a;
        c4085g.f13774c = null;
        c4085g.f13775d = null;
        c4085g.f13785n = null;
        c4085g.f13778g = null;
        c4085g.f13782k = null;
        c4085g.f13780i = null;
        c4085g.f13786o = null;
        c4085g.f13781j = null;
        c4085g.f13787p = null;
        c4085g.f13772a.clear();
        c4085g.f13783l = false;
        c4085g.f13773b.clear();
        c4085g.f13784m = false;
        this.f13823z = false;
        this.f13805h = null;
        this.f13806i = null;
        this.f13812o = null;
        this.f13807j = null;
        this.f13808k = null;
        this.f13813p = null;
        this.f13795C = 0;
        this.f13822y = null;
        this.f13817t = null;
        this.f13818u = null;
        this.f13820w = null;
        this.f13797E = 0;
        this.f13821x = null;
        this.f13815r = 0L;
        this.f13793A = false;
        this.f13799b.clear();
        this.f13802e.m7334k(this);
    }

    public final void m8088o(int i6) {
        this.f13796D = i6;
        C4094p c4094p = this.f13813p;
        (c4094p.f13860m ? c4094p.f13856i : c4094p.f13855h).execute(this);
    }

    public final void m8089p() {
        this.f13817t = Thread.currentThread();
        int i6 = AbstractC3604h.f12101b;
        this.f13815r = SystemClock.elapsedRealtimeNanos();
        boolean zMo8068b = false;
        while (!this.f13793A && this.f13822y != null && !(zMo8068b = this.f13822y.mo8068b())) {
            this.f13795C = m8081h(this.f13795C);
            this.f13822y = m8080g();
            if (this.f13795C == 4) {
                m8088o(2);
                return;
            }
        }
        if ((this.f13795C == 6 || this.f13793A) && !zMo8068b) {
            m8083j();
        }
    }

    public final void m8090q() {
        String str;
        int iM7785a = AbstractC3885h.m7785a(this.f13796D);
        if (iM7785a == 0) {
            this.f13795C = m8081h(1);
            this.f13822y = m8080g();
            m8089p();
        } else {
            if (iM7785a == 1) {
                m8089p();
                return;
            }
            if (iM7785a == 2) {
                m8079f();
                return;
            }
            int i6 = this.f13796D;
            if (i6 == 1) {
                str = "INITIALIZE";
            } else if (i6 != 2) {
                str = i6 != 3 ? "null" : "DECODE_DATA";
            } else {
                str = "SWITCH_TO_SOURCE_SERVICE";
            }
            throw new IllegalStateException("Unrecognized run reason: ".concat(str));
        }
    }

    public final void m8091r() {
        this.f13800c.m7468a();
        if (this.f13823z) {
            throw new IllegalStateException("Already notified", this.f13799b.isEmpty() ? null : (Throwable) AbstractC2460q.m5491e(1, this.f13799b));
        }
        this.f13823z = true;
    }

    @Override
    public final void run() {
        InterfaceC1479e interfaceC1479e = this.f13821x;
        try {
            try {
                if (this.f13793A) {
                    m8083j();
                    if (interfaceC1479e != null) {
                        interfaceC1479e.mo3152b();
                        return;
                    }
                    return;
                }
                m8090q();
                if (interfaceC1479e != null) {
                    interfaceC1479e.mo3152b();
                }
            } catch (Throwable th) {
                if (interfaceC1479e != null) {
                    interfaceC1479e.mo3152b();
                }
                throw th;
            }
        } catch (C4080b e5) {
            throw e5;
        } catch (Throwable th2) {
            if (Log.isLoggable("DecodeJob", 3)) {
                Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.f13793A + ", stage: " + AbstractC2460q.m5505s(this.f13795C), th2);
            }
            if (this.f13795C != 5) {
                this.f13799b.add(th2);
                m8083j();
            }
            if (!this.f13793A) {
                throw th2;
            }
            throw th2;
        }
    }
}

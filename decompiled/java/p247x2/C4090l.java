package p247x2;

import android.os.SystemClock;
import android.util.Log;
import androidx.appcompat.app.C0157r0;
import androidx.appcompat.widget.C0304z3;
import com.bumptech.glide.C1468f;
import com.bumptech.glide.EnumC1469g;
import com.google.android.gms.internal.cast.C1552f0;
import java.util.HashMap;
import p000a.AbstractC0004e;
import p001a0.C0023f;
import p004a3.ExecutorServiceC0041f;
import p012b.C1224a;
import p016b3.C1291x;
import p141n3.C3192f;
import p171q.C3388b;
import p186r3.AbstractC3604h;
import p186r3.C3598b;
import p186r3.C3605i;
import p186r3.ExecutorC3601e;
import p187r4.C3621k;
import p187r4.C3624n;
import p198s3.AbstractC3705c;
import p228v2.C3981h;
import p228v2.InterfaceC3978e;
import p269z2.C4303d;
import p269z2.C4304e;

public final class C4090l {

    public static final boolean f13833h = Log.isLoggable("Engine", 2);

    public final C1291x f13834a;

    public final C3388b f13835b;

    public final C4304e f13836c;

    public final C0304z3 f13837d;

    public final C0157r0 f13838e;

    public final C1552f0 f13839f;

    public final C0023f f13840g;

    public C4090l(C4304e c4304e, C4303d c4303d, ExecutorServiceC0041f executorServiceC0041f, ExecutorServiceC0041f executorServiceC0041f2, ExecutorServiceC0041f executorServiceC0041f3, ExecutorServiceC0041f executorServiceC0041f4) {
        this.f13836c = c4304e;
        C1224a c1224a = new C1224a(c4303d);
        C0023f c0023f = new C0023f(11);
        this.f13840g = c0023f;
        synchronized (this) {
            synchronized (c0023f) {
                c0023f.f47e = this;
            }
        }
        this.f13835b = new C3388b(9);
        this.f13834a = new C1291x(2);
        C0304z3 c0304z3 = new C0304z3();
        c0304z3.f1161g = AbstractC3705c.m7467a(150, new C3624n(9, c0304z3));
        c0304z3.f1155a = executorServiceC0041f;
        c0304z3.f1156b = executorServiceC0041f2;
        c0304z3.f1157c = executorServiceC0041f3;
        c0304z3.f1158d = executorServiceC0041f4;
        c0304z3.f1159e = this;
        c0304z3.f1160f = this;
        this.f13837d = c0304z3;
        C1552f0 c1552f0 = new C1552f0();
        c1552f0.f5293c = AbstractC3705c.m7467a(150, new C3624n(8, c1552f0));
        c1552f0.f5292b = c1224a;
        this.f13839f = c1552f0;
        this.f13838e = new C0157r0();
        c4304e.f14602d = this;
    }

    public static void m8095d(String str, long j10, C4095q c4095q) {
        StringBuilder sbM29w = AbstractC0004e.m29w(str, " in ");
        sbM29w.append(AbstractC3604h.m7226a(j10));
        sbM29w.append("ms, key: ");
        sbM29w.append(c4095q);
        Log.v("Engine", sbM29w.toString());
    }

    public static void m8096g(InterfaceC4102x interfaceC4102x) {
        if (!(interfaceC4102x instanceof C4096r)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((C4096r) interfaceC4102x).m8115e();
    }

    public final C3621k m8097a(C1468f c1468f, Object obj, InterfaceC3978e interfaceC3978e, int i6, int i10, Class cls, Class cls2, EnumC1469g enumC1469g, C4089k c4089k, C3598b c3598b, boolean z7, boolean z10, C3981h c3981h, boolean z11, boolean z12, C3192f c3192f, ExecutorC3601e executorC3601e) {
        long jElapsedRealtimeNanos;
        if (f13833h) {
            int i11 = AbstractC3604h.f12101b;
            jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        } else {
            jElapsedRealtimeNanos = 0;
        }
        long j10 = jElapsedRealtimeNanos;
        this.f13835b.getClass();
        C4095q c4095q = new C4095q(obj, interfaceC3978e, i6, i10, c3598b, cls, cls2, c3981h);
        synchronized (this) {
            try {
                C4096r c4096rM8099c = m8099c(c4095q, z11, j10);
                if (c4096rM8099c == null) {
                    return m8102h(c1468f, obj, interfaceC3978e, i6, i10, cls, cls2, enumC1469g, c4089k, c3598b, z7, z10, c3981h, z11, z12, c3192f, executorC3601e, c4095q, j10);
                }
                c3192f.m6416k(c4096rM8099c, 5, false);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final C4096r m8098b(C4095q c4095q) {
        C4096r c4096r;
        Object obj;
        C4304e c4304e = this.f13836c;
        synchronized (c4304e) {
            C3605i c3605i = (C3605i) c4304e.f12104a.remove(c4095q);
            c4096r = null;
            if (c3605i == null) {
                obj = null;
            } else {
                c4304e.f12106c -= (long) c3605i.f12103b;
                obj = c3605i.f12102a;
            }
        }
        InterfaceC4102x interfaceC4102x = (InterfaceC4102x) obj;
        if (interfaceC4102x != null) {
            c4096r = interfaceC4102x instanceof C4096r ? (C4096r) interfaceC4102x : new C4096r(interfaceC4102x, true, true, c4095q, this);
        }
        if (c4096r != null) {
            c4096r.m8114b();
            this.f13840g.m101a(c4095q, c4096r);
        }
        return c4096r;
    }

    public final C4096r m8099c(C4095q c4095q, boolean z7, long j10) {
        C4096r c4096r;
        if (!z7) {
            return null;
        }
        C0023f c0023f = this.f13840g;
        synchronized (c0023f) {
            C4078a c4078a = (C4078a) ((HashMap) c0023f.f45c).get(c4095q);
            if (c4078a == null) {
                c4096r = null;
            } else {
                c4096r = (C4096r) c4078a.get();
                if (c4096r == null) {
                    c0023f.m104d(c4078a);
                }
            }
        }
        if (c4096r != null) {
            c4096r.m8114b();
        }
        if (c4096r != null) {
            if (f13833h) {
                m8095d("Loaded resource from active resources", j10, c4095q);
            }
            return c4096r;
        }
        C4096r c4096rM8098b = m8098b(c4095q);
        if (c4096rM8098b == null) {
            return null;
        }
        if (f13833h) {
            m8095d("Loaded resource from cache", j10, c4095q);
        }
        return c4096rM8098b;
    }

    public final synchronized void m8100e(C4094p c4094p, C4095q c4095q, C4096r c4096r) {
        if (c4096r != null) {
            try {
                if (c4096r.f13879a) {
                    this.f13840g.m101a(c4095q, c4096r);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        C1291x c1291x = this.f13834a;
        c1291x.getClass();
        c4094p.getClass();
        HashMap map = c1291x.f4056a;
        if (c4094p.equals(map.get(c4095q))) {
            map.remove(c4095q);
        }
    }

    public final void m8101f(C4095q c4095q, C4096r c4096r) {
        C0023f c0023f = this.f13840g;
        synchronized (c0023f) {
            C4078a c4078a = (C4078a) ((HashMap) c0023f.f45c).remove(c4095q);
            if (c4078a != null) {
                c4078a.f13753c = null;
                c4078a.clear();
            }
        }
        if (c4096r.f13879a) {
        } else {
            this.f13838e.m442e(c4096r, false);
        }
    }

    public final C3621k m8102h(C1468f c1468f, Object obj, InterfaceC3978e interfaceC3978e, int i6, int i10, Class cls, Class cls2, EnumC1469g enumC1469g, C4089k c4089k, C3598b c3598b, boolean z7, boolean z10, C3981h c3981h, boolean z11, boolean z12, C3192f c3192f, ExecutorC3601e executorC3601e, C4095q c4095q, long j10) {
        C4094p c4094p = (C4094p) this.f13834a.f4056a.get(c4095q);
        if (c4094p != null) {
            c4094p.m8104a(c3192f, executorC3601e);
            if (f13833h) {
                m8095d("Added to existing load", j10, c4095q);
            }
            return new C3621k(this, c3192f, c4094p);
        }
        C4094p c4094p2 = (C4094p) ((C3621k) this.f13837d.f1161g).m7329f();
        synchronized (c4094p2) {
            c4094p2.f13858k = c4095q;
            c4094p2.f13859l = z11;
            c4094p2.f13860m = z12;
        }
        C1552f0 c1552f0 = this.f13839f;
        RunnableC4087i runnableC4087i = (RunnableC4087i) ((C3621k) c1552f0.f5293c).m7329f();
        int i11 = c1552f0.f5291a;
        c1552f0.f5291a = i11 + 1;
        C4085g c4085g = runnableC4087i.f13798a;
        c4085g.f13774c = c1468f;
        c4085g.f13775d = obj;
        c4085g.f13785n = interfaceC3978e;
        c4085g.f13776e = i6;
        c4085g.f13777f = i10;
        c4085g.f13787p = c4089k;
        c4085g.f13778g = cls;
        c4085g.f13779h = runnableC4087i.f13801d;
        c4085g.f13782k = cls2;
        c4085g.f13786o = enumC1469g;
        c4085g.f13780i = c3981h;
        c4085g.f13781j = c3598b;
        c4085g.f13788q = z7;
        c4085g.f13789r = z10;
        runnableC4087i.f13805h = c1468f;
        runnableC4087i.f13806i = interfaceC3978e;
        runnableC4087i.f13807j = enumC1469g;
        runnableC4087i.f13808k = c4095q;
        runnableC4087i.f13809l = i6;
        runnableC4087i.f13810m = i10;
        runnableC4087i.f13811n = c4089k;
        runnableC4087i.f13812o = c3981h;
        runnableC4087i.f13813p = c4094p2;
        runnableC4087i.f13814q = i11;
        runnableC4087i.f13796D = 1;
        runnableC4087i.f13816s = obj;
        C1291x c1291x = this.f13834a;
        c1291x.getClass();
        c1291x.f4056a.put(c4095q, c4094p2);
        c4094p2.m8104a(c3192f, executorC3601e);
        c4094p2.m8113k(runnableC4087i);
        if (f13833h) {
            m8095d("Started new load", j10, c4095q);
        }
        return new C3621k(this, c3192f, c4094p2);
    }
}

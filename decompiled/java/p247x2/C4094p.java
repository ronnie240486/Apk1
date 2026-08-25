package p247x2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import p004a3.ExecutorServiceC0041f;
import p016b3.C1291x;
import p141n3.C3192f;
import p173q1.C3406f0;
import p186r3.AbstractC3602f;
import p186r3.AbstractC3610n;
import p186r3.ExecutorC3601e;
import p187r4.C3621k;
import p198s3.C3706d;
import p198s3.InterfaceC3704b;

public final class C4094p implements InterfaceC3704b {

    public static final C3406f0 f13847w = new C3406f0(8);

    public final C4093o f13848a;

    public final C3706d f13849b;

    public final C4090l f13850c;

    public final C3621k f13851d;

    public final C3406f0 f13852e;

    public final C4090l f13853f;

    public final ExecutorServiceC0041f f13854g;

    public final ExecutorServiceC0041f f13855h;

    public final ExecutorServiceC0041f f13856i;

    public final AtomicInteger f13857j;

    public C4095q f13858k;

    public boolean f13859l;

    public boolean f13860m;

    public InterfaceC4102x f13861n;

    public int f13862o;

    public boolean f13863p;

    public C4098t f13864q;

    public boolean f13865r;

    public C4096r f13866s;

    public RunnableC4087i f13867t;

    public volatile boolean f13868u;

    public boolean f13869v;

    public C4094p(ExecutorServiceC0041f executorServiceC0041f, ExecutorServiceC0041f executorServiceC0041f2, ExecutorServiceC0041f executorServiceC0041f3, ExecutorServiceC0041f executorServiceC0041f4, C4090l c4090l, C4090l c4090l2, C3621k c3621k) {
        C3406f0 c3406f0 = f13847w;
        this.f13848a = new C4093o(new ArrayList(2));
        this.f13849b = new C3706d();
        this.f13857j = new AtomicInteger();
        this.f13854g = executorServiceC0041f;
        this.f13855h = executorServiceC0041f2;
        this.f13856i = executorServiceC0041f4;
        this.f13853f = c4090l;
        this.f13850c = c4090l2;
        this.f13851d = c3621k;
        this.f13852e = c3406f0;
    }

    public final synchronized void m8104a(C3192f c3192f, ExecutorC3601e executorC3601e) {
        try {
            this.f13849b.m7468a();
            C4093o c4093o = this.f13848a;
            c4093o.getClass();
            c4093o.f13846a.add(new C4092n(c3192f, executorC3601e));
            if (this.f13863p) {
                m8107e(1);
                RunnableC4091m runnableC4091m = new RunnableC4091m(this, c3192f, 1);
                executorC3601e.getClass();
                AbstractC3610n.m7242j(runnableC4091m);
            } else if (this.f13865r) {
                m8107e(1);
                RunnableC4091m runnableC4091m2 = new RunnableC4091m(this, c3192f, 0);
                executorC3601e.getClass();
                AbstractC3610n.m7242j(runnableC4091m2);
            } else {
                AbstractC3602f.m7223a("Cannot add callbacks to a cancelled EngineJob", !this.f13868u);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override
    public final C3706d mo7466b() {
        return this.f13849b;
    }

    public final void m8105c() {
        if (m8108f()) {
            return;
        }
        this.f13868u = true;
        RunnableC4087i runnableC4087i = this.f13867t;
        runnableC4087i.f13793A = true;
        InterfaceC4084f interfaceC4084f = runnableC4087i.f13822y;
        if (interfaceC4084f != null) {
            interfaceC4084f.cancel();
        }
        C4090l c4090l = this.f13853f;
        C4095q c4095q = this.f13858k;
        synchronized (c4090l) {
            C1291x c1291x = c4090l.f13834a;
            c1291x.getClass();
            HashMap map = c1291x.f4056a;
            if (equals(map.get(c4095q))) {
                map.remove(c4095q);
            }
        }
    }

    public final void m8106d() {
        C4096r c4096r;
        synchronized (this) {
            try {
                this.f13849b.m7468a();
                AbstractC3602f.m7223a("Not yet complete!", m8108f());
                int iDecrementAndGet = this.f13857j.decrementAndGet();
                AbstractC3602f.m7223a("Can't decrement below 0", iDecrementAndGet >= 0);
                if (iDecrementAndGet == 0) {
                    c4096r = this.f13866s;
                    m8111i();
                } else {
                    c4096r = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (c4096r != null) {
            c4096r.m8115e();
        }
    }

    public final synchronized void m8107e(int i6) {
        C4096r c4096r;
        AbstractC3602f.m7223a("Not yet complete!", m8108f());
        if (this.f13857j.getAndAdd(i6) == 0 && (c4096r = this.f13866s) != null) {
            c4096r.m8114b();
        }
    }

    public final boolean m8108f() {
        return this.f13865r || this.f13863p || this.f13868u;
    }

    public final void m8109g() {
        synchronized (this) {
            try {
                this.f13849b.m7468a();
                if (this.f13868u) {
                    m8111i();
                    return;
                }
                if (this.f13848a.f13846a.isEmpty()) {
                    throw new IllegalStateException("Received an exception without any callbacks to notify");
                }
                if (this.f13865r) {
                    throw new IllegalStateException("Already failed once");
                }
                this.f13865r = true;
                C4095q c4095q = this.f13858k;
                C4093o c4093o = this.f13848a;
                c4093o.getClass();
                ArrayList<C4092n> arrayList = new ArrayList(c4093o.f13846a);
                m8107e(arrayList.size() + 1);
                this.f13853f.m8100e(this, c4095q, null);
                for (C4092n c4092n : arrayList) {
                    c4092n.f13845b.execute(new RunnableC4091m(this, c4092n.f13844a, 0));
                }
                m8106d();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m8110h() {
        synchronized (this) {
            try {
                this.f13849b.m7468a();
                if (this.f13868u) {
                    this.f13861n.mo5405d();
                    m8111i();
                    return;
                }
                if (this.f13848a.f13846a.isEmpty()) {
                    throw new IllegalStateException("Received a resource without any callbacks to notify");
                }
                if (this.f13863p) {
                    throw new IllegalStateException("Already have resource");
                }
                C3406f0 c3406f0 = this.f13852e;
                InterfaceC4102x interfaceC4102x = this.f13861n;
                boolean z7 = this.f13859l;
                C4095q c4095q = this.f13858k;
                C4090l c4090l = this.f13850c;
                c3406f0.getClass();
                this.f13866s = new C4096r(interfaceC4102x, z7, true, c4095q, c4090l);
                this.f13863p = true;
                C4093o c4093o = this.f13848a;
                c4093o.getClass();
                ArrayList<C4092n> arrayList = new ArrayList(c4093o.f13846a);
                m8107e(arrayList.size() + 1);
                this.f13853f.m8100e(this, this.f13858k, this.f13866s);
                for (C4092n c4092n : arrayList) {
                    c4092n.f13845b.execute(new RunnableC4091m(this, c4092n.f13844a, 1));
                }
                m8106d();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void m8111i() {
        if (this.f13858k == null) {
            throw new IllegalArgumentException();
        }
        this.f13848a.f13846a.clear();
        this.f13858k = null;
        this.f13866s = null;
        this.f13861n = null;
        this.f13865r = false;
        this.f13868u = false;
        this.f13863p = false;
        this.f13869v = false;
        this.f13867t.m8086m();
        this.f13867t = null;
        this.f13864q = null;
        this.f13862o = 0;
        this.f13851d.m7334k(this);
    }

    public final synchronized void m8112j(C3192f c3192f) {
        try {
            this.f13849b.m7468a();
            C4093o c4093o = this.f13848a;
            c4093o.f13846a.remove(new C4092n(c3192f, AbstractC3602f.f12099b));
            if (this.f13848a.f13846a.isEmpty()) {
                m8105c();
                if (this.f13863p || this.f13865r) {
                    if (this.f13857j.get() == 0) {
                        m8111i();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void m8113k(RunnableC4087i runnableC4087i) {
        ExecutorServiceC0041f executorServiceC0041f;
        this.f13867t = runnableC4087i;
        int iM8081h = runnableC4087i.m8081h(1);
        if (iM8081h == 2 || iM8081h == 3) {
            executorServiceC0041f = this.f13854g;
        } else {
            executorServiceC0041f = this.f13860m ? this.f13856i : this.f13855h;
        }
        executorServiceC0041f.execute(runnableC4087i);
    }
}

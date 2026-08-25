package p247x2;

import p173q1.C3406f0;
import p187r4.C3621k;
import p198s3.AbstractC3705c;
import p198s3.C3706d;
import p198s3.InterfaceC3704b;

public final class C4101w implements InterfaceC4102x, InterfaceC3704b {

    public static final C3621k f13897e = AbstractC3705c.m7467a(20, new C3406f0(9));

    public final C3706d f13898a = new C3706d();

    public InterfaceC4102x f13899b;

    public boolean f13900c;

    public boolean f13901d;

    @Override
    public final int mo5403a() {
        return this.f13899b.mo5403a();
    }

    @Override
    public final C3706d mo7466b() {
        return this.f13898a;
    }

    @Override
    public final Class mo5404c() {
        return this.f13899b.mo5404c();
    }

    @Override
    public final synchronized void mo5405d() {
        this.f13898a.m7468a();
        this.f13901d = true;
        if (!this.f13900c) {
            this.f13899b.mo5405d();
            this.f13899b = null;
            f13897e.m7334k(this);
        }
    }

    public final synchronized void m8122e() {
        this.f13898a.m7468a();
        if (!this.f13900c) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f13900c = false;
        if (this.f13901d) {
            mo5405d();
        }
    }

    @Override
    public final Object get() {
        return this.f13899b.get();
    }
}

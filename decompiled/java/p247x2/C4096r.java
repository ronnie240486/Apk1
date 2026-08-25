package p247x2;

import p186r3.AbstractC3602f;

public final class C4096r implements InterfaceC4102x {

    public final boolean f13879a;

    public final boolean f13880b;

    public final InterfaceC4102x f13881c;

    public final C4090l f13882d;

    public final C4095q f13883e;

    public int f13884f;

    public boolean f13885g;

    public C4096r(InterfaceC4102x interfaceC4102x, boolean z7, boolean z10, C4095q c4095q, C4090l c4090l) {
        AbstractC3602f.m7225c(interfaceC4102x, "Argument must not be null");
        this.f13881c = interfaceC4102x;
        this.f13879a = z7;
        this.f13880b = z10;
        this.f13883e = c4095q;
        AbstractC3602f.m7225c(c4090l, "Argument must not be null");
        this.f13882d = c4090l;
    }

    @Override
    public final int mo5403a() {
        return this.f13881c.mo5403a();
    }

    public final synchronized void m8114b() {
        if (this.f13885g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f13884f++;
    }

    @Override
    public final Class mo5404c() {
        return this.f13881c.mo5404c();
    }

    @Override
    public final synchronized void mo5405d() {
        if (this.f13884f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f13885g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f13885g = true;
        if (this.f13880b) {
            this.f13881c.mo5405d();
        }
    }

    public final void m8115e() {
        boolean z7;
        synchronized (this) {
            int i6 = this.f13884f;
            if (i6 <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z7 = true;
            int i10 = i6 - 1;
            this.f13884f = i10;
            if (i10 != 0) {
                z7 = false;
            }
        }
        if (z7) {
            this.f13882d.m8101f(this.f13883e, this);
        }
    }

    @Override
    public final Object get() {
        return this.f13881c.get();
    }

    public final synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f13879a + ", listener=" + this.f13882d + ", key=" + this.f13883e + ", acquired=" + this.f13884f + ", isRecycled=" + this.f13885g + ", resource=" + this.f13881c + '}';
    }
}

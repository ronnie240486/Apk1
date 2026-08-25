package p029c7;

import java.lang.ref.ReferenceQueue;

public final class C1428x extends C1430z {

    public final int f4354d;

    public volatile long f4355e;

    public InterfaceC1406c0 f4356f;

    public InterfaceC1406c0 f4357g;

    public C1428x(ReferenceQueue referenceQueue, Object obj, int i6, InterfaceC1406c0 interfaceC1406c0, int i10) {
        super(referenceQueue, obj, i6, interfaceC1406c0);
        this.f4354d = i10;
    }

    @Override
    public void mo3285d(long j10) {
        switch (this.f4354d) {
            case 1:
                this.f4355e = j10;
                break;
            default:
                super.mo3285d(j10);
                break;
        }
    }

    @Override
    public InterfaceC1406c0 mo3286e() {
        switch (this.f4354d) {
            case 0:
                return this.f4357g;
            default:
                return super.mo3286e();
        }
    }

    @Override
    public void mo3287f(InterfaceC1406c0 interfaceC1406c0) {
        switch (this.f4354d) {
            case 1:
                this.f4356f = interfaceC1406c0;
                break;
            default:
                super.mo3287f(interfaceC1406c0);
                break;
        }
    }

    @Override
    public void mo3288g(InterfaceC1406c0 interfaceC1406c0) {
        switch (this.f4354d) {
            case 1:
                this.f4357g = interfaceC1406c0;
                break;
            default:
                super.mo3288g(interfaceC1406c0);
                break;
        }
    }

    @Override
    public void mo3289h(InterfaceC1406c0 interfaceC1406c0) {
        switch (this.f4354d) {
            case 0:
                this.f4356f = interfaceC1406c0;
                break;
            default:
                super.mo3289h(interfaceC1406c0);
                break;
        }
    }

    @Override
    public InterfaceC1406c0 mo3290i() {
        switch (this.f4354d) {
            case 0:
                return this.f4356f;
            default:
                return super.mo3290i();
        }
    }

    @Override
    public long mo3292k() {
        switch (this.f4354d) {
            case 1:
                return this.f4355e;
            default:
                return super.mo3292k();
        }
    }

    @Override
    public void mo3293l(long j10) {
        switch (this.f4354d) {
            case 0:
                this.f4355e = j10;
                break;
            default:
                super.mo3293l(j10);
                break;
        }
    }

    @Override
    public InterfaceC1406c0 mo3294m() {
        switch (this.f4354d) {
            case 1:
                return this.f4357g;
            default:
                return super.mo3294m();
        }
    }

    @Override
    public void mo3295n(InterfaceC1406c0 interfaceC1406c0) {
        switch (this.f4354d) {
            case 0:
                this.f4357g = interfaceC1406c0;
                break;
            default:
                super.mo3295n(interfaceC1406c0);
                break;
        }
    }

    @Override
    public InterfaceC1406c0 mo3296o() {
        switch (this.f4354d) {
            case 1:
                return this.f4356f;
            default:
                return super.mo3296o();
        }
    }

    @Override
    public long mo3297p() {
        switch (this.f4354d) {
            case 0:
                return this.f4355e;
            default:
                return super.mo3297p();
        }
    }
}

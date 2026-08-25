package p029c7;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class C1430z extends WeakReference implements InterfaceC1406c0 {

    public final int f4364a;

    public final InterfaceC1406c0 f4365b;

    public volatile InterfaceC1426v f4366c;

    public C1430z(ReferenceQueue referenceQueue, Object obj, int i6, InterfaceC1406c0 interfaceC1406c0) {
        super(obj, referenceQueue);
        this.f4366c = ConcurrentMapC1404b0.f4272s;
        this.f4364a = i6;
        this.f4365b = interfaceC1406c0;
    }

    @Override
    public final InterfaceC1426v mo3282a() {
        return this.f4366c;
    }

    @Override
    public final InterfaceC1406c0 mo3283b() {
        return this.f4365b;
    }

    @Override
    public final int mo3284c() {
        return this.f4364a;
    }

    public void mo3285d(long j10) {
        throw new UnsupportedOperationException();
    }

    public InterfaceC1406c0 mo3286e() {
        throw new UnsupportedOperationException();
    }

    public void mo3287f(InterfaceC1406c0 interfaceC1406c0) {
        throw new UnsupportedOperationException();
    }

    public void mo3288g(InterfaceC1406c0 interfaceC1406c0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final Object getKey() {
        return get();
    }

    public void mo3289h(InterfaceC1406c0 interfaceC1406c0) {
        throw new UnsupportedOperationException();
    }

    public InterfaceC1406c0 mo3290i() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void mo3291j(InterfaceC1426v interfaceC1426v) {
        this.f4366c = interfaceC1426v;
    }

    public long mo3292k() {
        throw new UnsupportedOperationException();
    }

    public void mo3293l(long j10) {
        throw new UnsupportedOperationException();
    }

    public InterfaceC1406c0 mo3294m() {
        throw new UnsupportedOperationException();
    }

    public void mo3295n(InterfaceC1406c0 interfaceC1406c0) {
        throw new UnsupportedOperationException();
    }

    public InterfaceC1406c0 mo3296o() {
        throw new UnsupportedOperationException();
    }

    public long mo3297p() {
        throw new UnsupportedOperationException();
    }
}

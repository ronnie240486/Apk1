package p029c7;

public class C1424t extends AbstractC1411g {

    public final Object f4347a;

    public final int f4348b;

    public final InterfaceC1406c0 f4349c;

    public volatile InterfaceC1426v f4350d = ConcurrentMapC1404b0.f4272s;

    public C1424t(Object obj, int i6, InterfaceC1406c0 interfaceC1406c0) {
        this.f4347a = obj;
        this.f4348b = i6;
        this.f4349c = interfaceC1406c0;
    }

    @Override
    public final InterfaceC1426v mo3282a() {
        return this.f4350d;
    }

    @Override
    public final InterfaceC1406c0 mo3283b() {
        return this.f4349c;
    }

    @Override
    public final int mo3284c() {
        return this.f4348b;
    }

    @Override
    public final Object getKey() {
        return this.f4347a;
    }

    @Override
    public final void mo3291j(InterfaceC1426v interfaceC1426v) {
        this.f4350d = interfaceC1426v;
    }
}

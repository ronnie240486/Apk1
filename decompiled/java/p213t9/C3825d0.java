package p213t9;

public final class C3825d0 implements InterfaceC3846k0 {

    public final boolean f12904a;

    public C3825d0(boolean z7) {
        this.f12904a = z7;
    }

    @Override
    public final C3876z0 mo7647c() {
        return null;
    }

    @Override
    public final boolean isActive() {
        return this.f12904a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Empty{");
        sb.append(this.f12904a ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}

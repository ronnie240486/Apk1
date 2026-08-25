package p103j9;

public final class C2798k implements InterfaceC2791d {

    public final Class f9537a;

    public C2798k(Class cls) {
        this.f9537a = cls;
    }

    @Override
    public final Class mo5777a() {
        return this.f9537a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C2798k) {
            if (AbstractC2796i.m5780a(this.f9537a, ((C2798k) obj).f9537a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f9537a.hashCode();
    }

    public final String toString() {
        return this.f9537a + " (Kotlin reflection is not available)";
    }
}

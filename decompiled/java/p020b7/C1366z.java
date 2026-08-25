package p020b7;

import p041d7.AbstractC2211h1;

public final class C1366z extends AbstractC1353m {

    public final Iterable f4178a;

    public C1366z(Iterable iterable) {
        this.f4178a = iterable;
    }

    @Override
    public final Object mo3209a(AbstractC2211h1 abstractC2211h1) {
        return this.f4178a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1366z) {
            return this.f4178a.equals(((C1366z) obj).f4178a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f4178a.hashCode() + 1502476572;
    }

    public final String toString() {
        return "Optional.of(" + this.f4178a + ")";
    }
}

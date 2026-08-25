package p270z3;

public final class C4320n extends AbstractC4328v {

    public final EnumC4327u f14675a;

    public final EnumC4326t f14676b;

    public C4320n(EnumC4327u enumC4327u, EnumC4326t enumC4326t) {
        this.f14675a = enumC4327u;
        this.f14676b = enumC4326t;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4328v)) {
            return false;
        }
        AbstractC4328v abstractC4328v = (AbstractC4328v) obj;
        EnumC4327u enumC4327u = this.f14675a;
        if (enumC4327u != null ? enumC4327u.equals(((C4320n) abstractC4328v).f14675a) : ((C4320n) abstractC4328v).f14675a == null) {
            EnumC4326t enumC4326t = this.f14676b;
            if (enumC4326t == null) {
                if (((C4320n) abstractC4328v).f14676b == null) {
                    return true;
                }
            } else if (enumC4326t.equals(((C4320n) abstractC4328v).f14676b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        EnumC4327u enumC4327u = this.f14675a;
        int iHashCode = ((enumC4327u == null ? 0 : enumC4327u.hashCode()) ^ 1000003) * 1000003;
        EnumC4326t enumC4326t = this.f14676b;
        return (enumC4326t != null ? enumC4326t.hashCode() : 0) ^ iHashCode;
    }

    public final String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f14675a + ", mobileSubtype=" + this.f14676b + "}";
    }
}

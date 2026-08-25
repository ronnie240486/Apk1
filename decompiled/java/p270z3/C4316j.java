package p270z3;

public final class C4316j extends AbstractC4323q {

    public final C4314h f14660a;

    public C4316j(C4314h c4314h) {
        this.f14660a = c4314h;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4323q)) {
            return false;
        }
        AbstractC4323q abstractC4323q = (AbstractC4323q) obj;
        Object obj2 = EnumC4322p.f14677a;
        ((C4316j) abstractC4323q).getClass();
        return obj2.equals(obj2) && this.f14660a.equals(((C4316j) abstractC4323q).f14660a);
    }

    public final int hashCode() {
        return ((EnumC4322p.f14677a.hashCode() ^ 1000003) * 1000003) ^ this.f14660a.hashCode();
    }

    public final String toString() {
        return "ClientInfo{clientType=" + EnumC4322p.f14677a + ", androidClientInfo=" + this.f14660a + "}";
    }
}

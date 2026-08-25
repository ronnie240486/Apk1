package p248x3;

import com.google.android.gms.internal.cast.C1585i3;

public final class C4105a {

    public final Integer f13921a;

    public final C1585i3 f13922b;

    public final EnumC4107c f13923c;

    public C4105a(Integer num, C1585i3 c1585i3, EnumC4107c enumC4107c) {
        this.f13921a = num;
        this.f13922b = c1585i3;
        this.f13923c = enumC4107c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C4105a)) {
            return false;
        }
        C4105a c4105a = (C4105a) obj;
        if (this.f13921a.equals(c4105a.f13921a)) {
            if (this.f13922b.equals(c4105a.f13922b) && this.f13923c.equals(c4105a.f13923c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f13921a.hashCode() ^ 1000003) * 1000003) ^ this.f13922b.hashCode()) * 1000003) ^ this.f13923c.hashCode();
    }

    public final String toString() {
        return "Event{code=" + this.f13921a + ", payload=" + this.f13922b + ", priority=" + this.f13923c + "}";
    }
}

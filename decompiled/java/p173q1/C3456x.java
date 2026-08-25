package p173q1;

import android.os.Bundle;

public final class C3456x {

    public final Bundle f11706a;

    public C3424l0 f11707b;

    public C3456x(C3424l0 c3424l0, boolean z7) {
        if (c3424l0 == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        Bundle bundle = new Bundle();
        this.f11706a = bundle;
        this.f11707b = c3424l0;
        bundle.putBundle("selector", c3424l0.f11568a);
        bundle.putBoolean("activeScan", z7);
    }

    public final void m7095a() {
        if (this.f11707b == null) {
            C3424l0 c3424l0M6999b = C3424l0.m6999b(this.f11706a.getBundle("selector"));
            this.f11707b = c3424l0M6999b;
            if (c3424l0M6999b == null) {
                this.f11707b = C3424l0.f11567c;
            }
        }
    }

    public final boolean m7096b() {
        return this.f11706a.getBoolean("activeScan");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C3456x)) {
            return false;
        }
        C3456x c3456x = (C3456x) obj;
        m7095a();
        C3424l0 c3424l0 = this.f11707b;
        c3456x.m7095a();
        return c3424l0.equals(c3456x.f11707b) && m7096b() == c3456x.m7096b();
    }

    public final int hashCode() {
        m7095a();
        return (this.f11707b.hashCode() ^ (m7096b() ? 1 : 0)) == true ? 1 : 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DiscoveryRequest{ selector=");
        m7095a();
        sb.append(this.f11707b);
        sb.append(", activeScan=");
        sb.append(m7096b());
        sb.append(", isValid=");
        m7095a();
        C3424l0 c3424l0 = this.f11707b;
        c3424l0.m7000a();
        sb.append(!c3424l0.f11569b.contains(null));
        sb.append(" }");
        return sb.toString();
    }

    public C3456x(Bundle bundle) {
        this.f11706a = bundle;
    }
}

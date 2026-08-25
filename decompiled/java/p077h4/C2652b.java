package p077h4;

import java.util.HashMap;
import p110k4.InterfaceC2890a;
import p248x3.EnumC4107c;

public final class C2652b {

    public final InterfaceC2890a f9254a;

    public final HashMap f9255b;

    public C2652b(InterfaceC2890a interfaceC2890a, HashMap map) {
        this.f9254a = interfaceC2890a;
        this.f9255b = map;
    }

    public final long m5667a(EnumC4107c enumC4107c, long j10, int i6) {
        long jMo5893c = j10 - this.f9254a.mo5893c();
        C2653c c2653c = (C2653c) this.f9255b.get(enumC4107c);
        long j11 = c2653c.f9256a;
        int i10 = i6 - 1;
        return Math.min(Math.max((long) (Math.pow(3.0d, i10) * j11 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j11 > 1 ? j11 : 2L) * ((long) i10)))), jMo5893c), c2653c.f9257b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2652b)) {
            return false;
        }
        C2652b c2652b = (C2652b) obj;
        return this.f9254a.equals(c2652b.f9254a) && this.f9255b.equals(c2652b.f9255b);
    }

    public final int hashCode() {
        return ((this.f9254a.hashCode() ^ 1000003) * 1000003) ^ this.f9255b.hashCode();
    }

    public final String toString() {
        return "SchedulerConfig{clock=" + this.f9254a + ", values=" + this.f9255b + "}";
    }
}

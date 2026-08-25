package p165p4;

import java.util.Arrays;
import p018b5.AbstractC1312l;

public final class C3362g {

    public final long f11353a;

    public final boolean f11354b;

    public C3362g(long j10, boolean z7) {
        this.f11353a = j10;
        this.f11354b = z7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3362g)) {
            return false;
        }
        C3362g c3362g = (C3362g) obj;
        return this.f11353a == c3362g.f11353a && this.f11354b == c3362g.f11354b && AbstractC1312l.m3201h(null, null);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f11353a), 0, Boolean.valueOf(this.f11354b), null});
    }
}

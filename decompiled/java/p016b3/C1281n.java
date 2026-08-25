package p016b3;

import p000a.AbstractC0004e;

public final class C1281n {

    public final String f4041a;

    public C1281n(String str) {
        this.f4041a = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1281n) {
            return this.f4041a.equals(((C1281n) obj).f4041a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f4041a.hashCode();
    }

    public final String toString() {
        return AbstractC0004e.m26t(new StringBuilder("StringHeaderFactory{value='"), this.f4041a, "'}");
    }
}

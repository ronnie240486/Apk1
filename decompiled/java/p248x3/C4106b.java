package p248x3;

import p000a.AbstractC0004e;

public final class C4106b {

    public final String f13924a;

    public C4106b(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f13924a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4106b)) {
            return false;
        }
        return this.f13924a.equals(((C4106b) obj).f13924a);
    }

    public final int hashCode() {
        return this.f13924a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return AbstractC0004e.m26t(new StringBuilder("Encoding{name=\""), this.f13924a, "\"}");
    }
}

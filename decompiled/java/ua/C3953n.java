package ua;

import org.bitspark.android.Spark;

public final class C3953n {

    public final Spark f13289a;

    public final C3951l f13290b;

    public volatile boolean f13291c = true;

    public C3953n(Spark spark, C3951l c3951l) {
        this.f13289a = spark;
        this.f13290b = c3951l;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C3953n)) {
            return false;
        }
        C3953n c3953n = (C3953n) obj;
        return this.f13289a == c3953n.f13289a && this.f13290b.equals(c3953n.f13290b);
    }

    public final int hashCode() {
        return this.f13290b.f13286f.hashCode() + this.f13289a.hashCode();
    }
}

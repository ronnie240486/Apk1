package p247x2;

import java.util.concurrent.Executor;
import p141n3.C3192f;

public final class C4092n {

    public final C3192f f13844a;

    public final Executor f13845b;

    public C4092n(C3192f c3192f, Executor executor) {
        this.f13844a = c3192f;
        this.f13845b = executor;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C4092n) {
            return this.f13844a.equals(((C4092n) obj).f13844a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f13844a.hashCode();
    }
}

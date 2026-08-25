package p041d7;

import androidx.media3.exoplayer.trackselection.C0939a;
import java.io.Serializable;

public final class C2238l0 extends AbstractC2173b5 implements Serializable {

    public final C0939a f7981a;

    public C2238l0(C0939a c0939a) {
        this.f7981a = c0939a;
    }

    @Override
    public final int compare(Object obj, Object obj2) {
        return this.f7981a.compare(obj, obj2);
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2238l0) {
            return this.f7981a.equals(((C2238l0) obj).f7981a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f7981a.hashCode();
    }

    public final String toString() {
        return this.f7981a.toString();
    }
}

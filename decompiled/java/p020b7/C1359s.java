package p020b7;

import com.google.common.util.concurrent.Service;
import java.io.Serializable;

public final class C1359s implements InterfaceC1354n, Serializable {

    public final Service.State f4174a;

    public C1359s(Service.State state) {
        this.f4174a = state;
    }

    @Override
    public final boolean apply(Object obj) {
        return this.f4174a.equals(obj);
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj instanceof C1359s) {
            return this.f4174a.equals(((C1359s) obj).f4174a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f4174a.hashCode();
    }

    public final String toString() {
        return "Predicates.equalTo(" + this.f4174a + ")";
    }
}

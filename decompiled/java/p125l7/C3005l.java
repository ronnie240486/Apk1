package p125l7;

import java.util.ArrayList;
import java.util.Iterator;

public final class C3005l extends AbstractC3006m implements Iterable {

    public final ArrayList f10301a = new ArrayList();

    public final boolean equals(Object obj) {
        return obj == this || ((obj instanceof C3005l) && ((C3005l) obj).f10301a.equals(this.f10301a));
    }

    public final int hashCode() {
        return this.f10301a.hashCode();
    }

    @Override
    public final Iterator iterator() {
        return this.f10301a.iterator();
    }
}

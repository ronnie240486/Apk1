package p041d7;

import java.util.Collection;
import java.util.Set;

public abstract class AbstractC2253n1 extends AbstractC2218i1 implements Set {
    public abstract Set mo5100c();

    @Override
    public final boolean equals(Object obj) {
        return obj == this || mo5100c().equals(obj);
    }

    @Override
    public final int hashCode() {
        return mo5100c().hashCode();
    }

    @Override
    public final boolean standardRemoveAll(Collection collection) {
        collection.getClass();
        return AbstractC2182d0.m5161x(this, collection);
    }
}

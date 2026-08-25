package p041d7;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public final class C2162a1 extends AbstractC2253n1 {

    public final int f7825a;

    public final Object f7826b;

    public C2162a1(int i6, Object obj) {
        this.f7825a = i6;
        this.f7826b = obj;
    }

    @Override
    public boolean add(Object obj) {
        switch (this.f7825a) {
            case 0:
                throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f7826b);
            default:
                return super.add(obj);
        }
    }

    @Override
    public boolean addAll(Collection collection) {
        switch (this.f7825a) {
            case 0:
                collection.getClass();
                throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f7826b);
            default:
                return super.addAll(collection);
        }
    }

    @Override
    public final Set mo5100c() {
        switch (this.f7825a) {
            case 0:
                return Collections.emptySet();
            default:
                return (C2257n5) ((C2242l4) this.f7826b).f7990g;
        }
    }

    @Override
    public final Object delegate() {
        switch (this.f7825a) {
            case 0:
                return Collections.emptySet();
            default:
                return (C2257n5) ((C2242l4) this.f7826b).f7990g;
        }
    }

    @Override
    public Iterator iterator() {
        switch (this.f7825a) {
            case 1:
                return new C2282r2(this, ((C2257n5) ((C2242l4) this.f7826b).f7990g).iterator());
            default:
                return super.iterator();
        }
    }

    @Override
    public final Collection delegate() {
        switch (this.f7825a) {
            case 0:
                return Collections.emptySet();
            default:
                return (C2257n5) ((C2242l4) this.f7826b).f7990g;
        }
    }
}

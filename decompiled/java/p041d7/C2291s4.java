package p041d7;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

public final class C2291s4 extends AbstractC2286s implements InterfaceC2243l5 {

    public transient C2277q4 f8055h;

    @Override
    public final Collection mo5108a() {
        return (Set) super.mo5108a();
    }

    @Override
    public final Collection get(Object obj) {
        return (Set) super.get(obj);
    }

    @Override
    public final Map mo5112i() {
        return m5260p();
    }

    @Override
    public final Set mo5114k() {
        return m5261q();
    }

    @Override
    public final Collection mo5099o() {
        return C2231k0.m5226d(this.f8055h.f8032b);
    }

    @Override
    public final Collection mo5104r(Collection collection) {
        if (collection instanceof NavigableSet) {
            return AbstractC2182d0.m5137I((NavigableSet) collection);
        }
        return collection instanceof SortedSet ? Collections.unmodifiableSortedSet((SortedSet) collection) : Collections.unmodifiableSet((Set) collection);
    }

    @Override
    public final Collection mo5105s(Collection collection, Object obj) {
        if (collection instanceof NavigableSet) {
            return new C2265p(this, obj, (NavigableSet) collection, null);
        }
        return collection instanceof SortedSet ? new C2279r(this, obj, (SortedSet) collection, null) : new C2272q(this, obj, (Set) collection);
    }

    @Override
    public final Set mo5108a() {
        return (Set) super.mo5108a();
    }

    @Override
    public final Set get(Object obj) {
        return (Set) super.get(obj);
    }
}

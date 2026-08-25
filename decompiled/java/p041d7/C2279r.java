package p041d7;

import java.util.Comparator;
import java.util.SortedSet;

public class C2279r extends AbstractC2244m implements SortedSet {

    public final C2291s4 f8036f;

    public C2279r(C2291s4 c2291s4, Object obj, SortedSet sortedSet, AbstractC2244m abstractC2244m) {
        super(c2291s4, obj, sortedSet, abstractC2244m);
        this.f8036f = c2291s4;
    }

    @Override
    public final Comparator comparator() {
        return mo5251f().comparator();
    }

    public SortedSet mo5251f() {
        return (SortedSet) this.f7992b;
    }

    @Override
    public final Object first() {
        m5241d();
        return mo5251f().first();
    }

    @Override
    public final SortedSet headSet(Object obj) {
        m5241d();
        SortedSet sortedSetHeadSet = mo5251f().headSet(obj);
        AbstractC2244m abstractC2244m = this.f7993c;
        if (abstractC2244m == null) {
            abstractC2244m = this;
        }
        return new C2279r(this.f8036f, this.f7991a, sortedSetHeadSet, abstractC2244m);
    }

    @Override
    public final Object last() {
        m5241d();
        return mo5251f().last();
    }

    @Override
    public final SortedSet subSet(Object obj, Object obj2) {
        m5241d();
        SortedSet sortedSetSubSet = mo5251f().subSet(obj, obj2);
        AbstractC2244m abstractC2244m = this.f7993c;
        if (abstractC2244m == null) {
            abstractC2244m = this;
        }
        return new C2279r(this.f8036f, this.f7991a, sortedSetSubSet, abstractC2244m);
    }

    @Override
    public final SortedSet tailSet(Object obj) {
        m5241d();
        SortedSet sortedSetTailSet = mo5251f().tailSet(obj);
        AbstractC2244m abstractC2244m = this.f7993c;
        if (abstractC2244m == null) {
            abstractC2244m = this;
        }
        return new C2279r(this.f8036f, this.f7991a, sortedSetTailSet, abstractC2244m);
    }
}

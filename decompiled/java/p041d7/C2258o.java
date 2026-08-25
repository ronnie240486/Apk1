package p041d7;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class C2258o extends AbstractC2244m implements List {

    public final AbstractC2286s f8010f;

    public C2258o(AbstractC2286s abstractC2286s, Object obj, List list, AbstractC2244m abstractC2244m) {
        super(abstractC2286s, obj, list, abstractC2244m);
        this.f8010f = abstractC2286s;
    }

    @Override
    public final void add(int i6, Object obj) {
        m5241d();
        boolean zIsEmpty = this.f7992b.isEmpty();
        ((List) this.f7992b).add(i6, obj);
        this.f8010f.f8046g++;
        if (zIsEmpty) {
            m5240c();
        }
    }

    @Override
    public final boolean addAll(int i6, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = ((List) this.f7992b).addAll(i6, collection);
        if (zAddAll) {
            this.f8010f.f8046g += this.f7992b.size() - size;
            if (size == 0) {
                m5240c();
            }
        }
        return zAddAll;
    }

    @Override
    public final Object get(int i6) {
        m5241d();
        return ((List) this.f7992b).get(i6);
    }

    @Override
    public final int indexOf(Object obj) {
        m5241d();
        return ((List) this.f7992b).indexOf(obj);
    }

    @Override
    public final int lastIndexOf(Object obj) {
        m5241d();
        return ((List) this.f7992b).lastIndexOf(obj);
    }

    @Override
    public final ListIterator listIterator() {
        m5241d();
        return new C2251n(this);
    }

    @Override
    public final Object remove(int i6) {
        m5241d();
        Object objRemove = ((List) this.f7992b).remove(i6);
        this.f8010f.f8046g--;
        m5242e();
        return objRemove;
    }

    @Override
    public final Object set(int i6, Object obj) {
        m5241d();
        return ((List) this.f7992b).set(i6, obj);
    }

    @Override
    public final List subList(int i6, int i10) {
        m5241d();
        List listSubList = ((List) this.f7992b).subList(i6, i10);
        AbstractC2244m abstractC2244m = this.f7993c;
        if (abstractC2244m == null) {
            abstractC2244m = this;
        }
        AbstractC2286s abstractC2286s = this.f8010f;
        abstractC2286s.getClass();
        boolean z7 = listSubList instanceof RandomAccess;
        Object obj = this.f7991a;
        return z7 ? new C2223j(abstractC2286s, obj, listSubList, abstractC2244m) : new C2258o(abstractC2286s, obj, listSubList, abstractC2244m);
    }

    @Override
    public final ListIterator listIterator(int i6) {
        m5241d();
        return new C2251n(this, i6);
    }
}

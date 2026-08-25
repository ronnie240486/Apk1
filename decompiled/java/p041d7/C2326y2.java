package p041d7;

import java.util.AbstractList;
import java.util.ListIterator;
import p020b7.InterfaceC1346i;

public final class C2326y2 extends AbstractC2285r5 implements ListIterator {

    public final int f8105b;

    public final AbstractList f8106c;

    public C2326y2(AbstractList abstractList, ListIterator listIterator, int i6) {
        super(listIterator);
        this.f8105b = i6;
        this.f8106c = abstractList;
    }

    @Override
    public final Object mo5172a(Object obj) {
        switch (this.f8105b) {
            case 0:
                return ((InterfaceC1346i) ((C2320x2) this.f8106c).f8094c).apply(obj);
            default:
                return ((C2332z2) this.f8106c).f8116b.apply(obj);
        }
    }

    @Override
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean hasPrevious() {
        return ((ListIterator) this.f8044a).hasPrevious();
    }

    @Override
    public final int nextIndex() {
        return ((ListIterator) this.f8044a).nextIndex();
    }

    @Override
    public final Object previous() {
        return mo5172a(((ListIterator) this.f8044a).previous());
    }

    @Override
    public final int previousIndex() {
        return ((ListIterator) this.f8044a).previousIndex();
    }

    @Override
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}

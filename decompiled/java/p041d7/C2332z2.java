package p041d7;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;
import p020b7.InterfaceC1346i;

public final class C2332z2 extends AbstractSequentialList implements Serializable {

    public final List f8115a;

    public final InterfaceC1346i f8116b;

    public C2332z2(List list, InterfaceC1346i interfaceC1346i) {
        list.getClass();
        this.f8115a = list;
        this.f8116b = interfaceC1346i;
    }

    @Override
    public final boolean isEmpty() {
        return this.f8115a.isEmpty();
    }

    @Override
    public final ListIterator listIterator(int i6) {
        return new C2326y2(this, this.f8115a.listIterator(i6), 1);
    }

    @Override
    public final void removeRange(int i6, int i10) {
        this.f8115a.subList(i6, i10).clear();
    }

    @Override
    public final int size() {
        return this.f8115a.size();
    }
}

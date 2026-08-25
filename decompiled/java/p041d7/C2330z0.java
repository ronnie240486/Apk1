package p041d7;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import p020b7.AbstractC1332b;

public final class C2330z0 extends AbstractC2218i1 implements List {

    public final Object f8111a;

    public C2330z0(Object obj) {
        this.f8111a = obj;
    }

    @Override
    public final boolean add(Object obj) {
        add(0, obj);
        throw null;
    }

    @Override
    public final boolean addAll(Collection collection) {
        addAll(0, collection);
        throw null;
    }

    @Override
    public final Object delegate() {
        return Collections.emptyList();
    }

    @Override
    public final boolean equals(Object obj) {
        return obj == this || Collections.emptyList().equals(obj);
    }

    @Override
    public final Object get(int i6) {
        return Collections.emptyList().get(i6);
    }

    @Override
    public final int hashCode() {
        return Collections.emptyList().hashCode();
    }

    @Override
    public final int indexOf(Object obj) {
        return Collections.emptyList().indexOf(obj);
    }

    @Override
    public final int lastIndexOf(Object obj) {
        return Collections.emptyList().lastIndexOf(obj);
    }

    @Override
    public final ListIterator listIterator() {
        return Collections.emptyList().listIterator();
    }

    @Override
    public final Object remove(int i6) {
        return Collections.emptyList().remove(i6);
    }

    @Override
    public final Object set(int i6, Object obj) {
        return Collections.emptyList().set(i6, obj);
    }

    @Override
    public final List subList(int i6, int i10) {
        return Collections.emptyList().subList(i6, i10);
    }

    @Override
    public final void add(int i6, Object obj) {
        AbstractC1332b.m3220k(i6, 0);
        throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f8111a);
    }

    @Override
    public final boolean addAll(int i6, Collection collection) {
        collection.getClass();
        AbstractC1332b.m3220k(i6, 0);
        throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f8111a);
    }

    @Override
    public final Collection delegate() {
        return Collections.emptyList();
    }

    @Override
    public final ListIterator listIterator(int i6) {
        return Collections.emptyList().listIterator(i6);
    }
}

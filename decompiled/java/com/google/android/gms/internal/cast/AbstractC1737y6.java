package com.google.android.gms.internal.cast;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

public abstract class AbstractC1737y6 extends AbstractList implements InterfaceC1629m7 {

    public boolean f5737a;

    public AbstractC1737y6(boolean z7) {
        this.f5737a = z7;
    }

    @Override
    public final boolean addAll(int i6, Collection collection) {
        m4058c();
        return super.addAll(i6, collection);
    }

    public final void m4058c() {
        if (!this.f5737a) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public final void clear() {
        m4058c();
        super.clear();
    }

    public final void m4059d() {
        if (this.f5737a) {
            this.f5737a = false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i6 = 0; i6 < size; i6++) {
            if (!get(i6).equals(list.get(i6))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i6 = 0; i6 < size; i6++) {
            iHashCode = (iHashCode * 31) + get(i6).hashCode();
        }
        return iHashCode;
    }

    @Override
    public abstract Object remove(int i6);

    @Override
    public final boolean remove(Object obj) {
        m4058c();
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override
    public final boolean removeAll(Collection collection) {
        m4058c();
        return super.removeAll(collection);
    }

    @Override
    public final boolean retainAll(Collection collection) {
        m4058c();
        return super.retainAll(collection);
    }

    @Override
    public boolean addAll(Collection collection) {
        m4058c();
        return super.addAll(collection);
    }
}

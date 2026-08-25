package p160p;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import p103j9.AbstractC2796i;

public final class C3339c implements Iterator, Map.Entry {

    public int f11307a;

    public int f11308b = -1;

    public boolean f11309c;

    public final C3341e f11310d;

    public C3339c(C3341e c3341e) {
        this.f11310d = c3341e;
        this.f11307a = c3341e.f11334c - 1;
    }

    @Override
    public final boolean equals(Object obj) {
        if (!this.f11309c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        int i6 = this.f11308b;
        C3341e c3341e = this.f11310d;
        return AbstractC2796i.m5780a(key, c3341e.m6812f(i6)) && AbstractC2796i.m5780a(entry.getValue(), c3341e.m6816j(this.f11308b));
    }

    @Override
    public final Object getKey() {
        if (this.f11309c) {
            return this.f11310d.m6812f(this.f11308b);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override
    public final Object getValue() {
        if (this.f11309c) {
            return this.f11310d.m6816j(this.f11308b);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override
    public final boolean hasNext() {
        return this.f11308b < this.f11307a;
    }

    @Override
    public final int hashCode() {
        if (!this.f11309c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        int i6 = this.f11308b;
        C3341e c3341e = this.f11310d;
        Object objM6812f = c3341e.m6812f(i6);
        Object objM6816j = c3341e.m6816j(this.f11308b);
        return (objM6812f == null ? 0 : objM6812f.hashCode()) ^ (objM6816j != null ? objM6816j.hashCode() : 0);
    }

    @Override
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f11308b++;
        this.f11309c = true;
        return this;
    }

    @Override
    public final void remove() {
        if (!this.f11309c) {
            throw new IllegalStateException();
        }
        this.f11310d.mo6814h(this.f11308b);
        this.f11308b--;
        this.f11307a--;
        this.f11309c = false;
    }

    @Override
    public final Object setValue(Object obj) {
        if (this.f11309c) {
            return this.f11310d.mo6815i(this.f11308b, obj);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}

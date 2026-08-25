package p160p;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p041d7.C2203g0;

public class C3341e extends C3347k implements Map {

    public C2203g0 f11312d;

    public C3338b f11313e;

    public C3340d f11314f;

    public C3341e(C3341e c3341e) {
        super(0);
        mo6813g(c3341e);
    }

    @Override
    public final Set entrySet() {
        C2203g0 c2203g0 = this.f11312d;
        if (c2203g0 != null) {
            return c2203g0;
        }
        C2203g0 c2203g1 = new C2203g0(this, 2);
        this.f11312d = c2203g1;
        return c2203g1;
    }

    public final boolean m6782k(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!super.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final Set keySet() {
        C3338b c3338b = this.f11313e;
        if (c3338b != null) {
            return c3338b;
        }
        C3338b c3338b2 = new C3338b(this);
        this.f11313e = c3338b2;
        return c3338b2;
    }

    public final boolean m6783l(Collection collection) {
        int i6 = this.f11334c;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            super.remove(it.next());
        }
        return i6 != this.f11334c;
    }

    @Override
    public final void putAll(Map map) {
        m6808b(map.size() + this.f11334c);
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public final Collection values() {
        C3340d c3340d = this.f11314f;
        if (c3340d != null) {
            return c3340d;
        }
        C3340d c3340d2 = new C3340d(this);
        this.f11314f = c3340d2;
        return c3340d2;
    }
}

package p041d7;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public final class C2174c implements Iterator {

    public final Iterator f7840a;

    public Object f7841b = null;

    public Collection f7842c = null;

    public Iterator f7843d = EnumC2302u2.f8070a;

    public final AbstractC2286s f7844e;

    public final int f7845f;

    public C2174c(AbstractC2286s abstractC2286s, int i6) {
        this.f7845f = i6;
        this.f7844e = abstractC2286s;
        this.f7840a = abstractC2286s.f8045f.entrySet().iterator();
    }

    @Override
    public final boolean hasNext() {
        return this.f7840a.hasNext() || this.f7843d.hasNext();
    }

    @Override
    public final Object next() {
        if (!this.f7843d.hasNext()) {
            Map.Entry entry = (Map.Entry) this.f7840a.next();
            this.f7841b = entry.getKey();
            Collection collection = (Collection) entry.getValue();
            this.f7842c = collection;
            this.f7843d = collection.iterator();
        }
        Object obj = this.f7841b;
        Object next = this.f7843d.next();
        switch (this.f7845f) {
            case 0:
                return next;
            default:
                return new C2281r1(obj, next);
        }
    }

    @Override
    public final void remove() {
        this.f7843d.remove();
        Collection collection = this.f7842c;
        Objects.requireNonNull(collection);
        if (collection.isEmpty()) {
            this.f7840a.remove();
        }
        this.f7844e.f8046g--;
    }
}

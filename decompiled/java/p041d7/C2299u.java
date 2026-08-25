package p041d7;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

public class C2299u extends AbstractCollection {

    public final int f8066a;

    public final AbstractC2286s f8067b;

    public C2299u(AbstractC2286s abstractC2286s, int i6) {
        this.f8066a = i6;
        this.f8067b = abstractC2286s;
    }

    @Override
    public final void clear() {
        switch (this.f8066a) {
            case 0:
                this.f8067b.clear();
                break;
            default:
                this.f8067b.clear();
                break;
        }
    }

    @Override
    public final boolean contains(Object obj) {
        switch (this.f8066a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return this.f8067b.m5285g(entry.getKey(), entry.getValue());
            default:
                return this.f8067b.mo5175h(obj);
        }
    }

    @Override
    public final Iterator iterator() {
        switch (this.f8066a) {
            case 0:
                return new C2174c(this.f8067b, 1);
            default:
                return new C2174c(this.f8067b, 0);
        }
    }

    @Override
    public boolean remove(Object obj) {
        switch (this.f8066a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return this.f8067b.remove(entry.getKey(), entry.getValue());
            default:
                return super.remove(obj);
        }
    }

    @Override
    public final int size() {
        switch (this.f8066a) {
            case 0:
                break;
        }
        return this.f8067b.f8046g;
    }
}

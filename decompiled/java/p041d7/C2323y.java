package p041d7;

import java.util.Collection;
import java.util.Iterator;
import p020b7.C1357q;
import p020b7.C1360t;

public final class C2323y extends AbstractC2228j4 {

    public final int f8098b;

    public final AbstractC2329z f8099c;

    public C2323y(AbstractC2329z abstractC2329z, int i6) {
        super(1);
        this.f8098b = i6;
        this.f8099c = abstractC2329z;
    }

    @Override
    public final InterfaceC2310v4 mo5225d() {
        switch (this.f8098b) {
            case 0:
                return this.f8099c;
            default:
                return (C2312w0) this.f8099c;
        }
    }

    @Override
    public final Iterator iterator() {
        switch (this.f8098b) {
            case 0:
                return this.f8099c.mo5283g();
            default:
                return ((C2312w0) this.f8099c).mo5283g();
        }
    }

    @Override
    public boolean removeAll(Collection collection) {
        switch (this.f8098b) {
            case 1:
                return ((C2312w0) this.f8099c).f8083d.m5290p(new C2306v0(new C1357q(collection)));
            default:
                return super.removeAll(collection);
        }
    }

    @Override
    public boolean retainAll(Collection collection) {
        switch (this.f8098b) {
            case 1:
                return ((C2312w0) this.f8099c).f8083d.m5290p(new C2306v0(new C1360t(new C1357q(collection))));
            default:
                return super.retainAll(collection);
        }
    }

    @Override
    public final int size() {
        switch (this.f8098b) {
            case 0:
                return this.f8099c.mo5281e();
            default:
                return ((C2312w0) this.f8099c).f8083d.keySet().size();
        }
    }
}

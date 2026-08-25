package p041d7;

import java.util.Iterator;
import java.util.Map;

public final class C2247m2 extends AbstractC2233k2 {

    public final int f7996d = 0;

    public final transient Object f7997e;

    public C2247m2(C2254n2 c2254n2) {
        this.f7997e = c2254n2;
    }

    @Override
    public AbstractC2301u1 mo5167c() {
        switch (this.f7996d) {
            case 1:
                return AbstractC2301u1.m5275r(this.f7997e);
            default:
                return super.mo5167c();
        }
    }

    @Override
    public final boolean contains(Object obj) {
        switch (this.f7996d) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return ((C2254n2) this.f7997e).m5285g(entry.getKey(), entry.getValue());
            default:
                return this.f7997e.equals(obj);
        }
    }

    @Override
    public int mo5123d(Object[] objArr, int i6) {
        switch (this.f7996d) {
            case 1:
                objArr[i6] = this.f7997e;
                return i6 + 1;
            default:
                return super.mo5123d(objArr, i6);
        }
    }

    @Override
    public final boolean mo5127h() {
        switch (this.f7996d) {
        }
        return false;
    }

    @Override
    public int hashCode() {
        switch (this.f7996d) {
            case 1:
                return this.f7997e.hashCode();
            default:
                return super.hashCode();
        }
    }

    @Override
    public final AbstractC2292s5 iterator() {
        switch (this.f7996d) {
            case 0:
                C2254n2 c2254n2 = (C2254n2) this.f7997e;
                c2254n2.getClass();
                return new C2163a2(c2254n2);
            default:
                return new C2308v2(this.f7997e);
        }
    }

    @Override
    public Iterator iterator() {
        switch (this.f7996d) {
            case 0:
                C2254n2 c2254n2 = (C2254n2) this.f7997e;
                c2254n2.getClass();
                return new C2163a2(c2254n2);
            default:
                return super.iterator();
        }
    }

    @Override
    public final int size() {
        switch (this.f7996d) {
            case 0:
                return ((C2254n2) this.f7997e).f7908g;
            default:
                return 1;
        }
    }

    @Override
    public String toString() {
        switch (this.f7996d) {
            case 1:
                return "[" + this.f7997e.toString() + ']';
            default:
                return super.toString();
        }
    }

    public C2247m2(Object obj) {
        obj.getClass();
        this.f7997e = obj;
    }
}

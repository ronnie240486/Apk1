package p041d7;

import java.util.Iterator;

public final class C2197f1 extends AbstractC2211h1 {

    public final int f7895b = 0;

    public final Object f7896c;

    public C2197f1(Iterable iterable, Iterable iterable2) {
        super(iterable);
        this.f7896c = iterable2;
    }

    @Override
    public final Iterator iterator() {
        switch (this.f7895b) {
            case 0:
                return ((Iterable) this.f7896c).iterator();
            default:
                C2204g1 c2204g1 = new C2204g1(this, ((Iterable[]) this.f7896c).length);
                C2296t2 c2296t2 = new C2296t2();
                c2296t2.f8061b = C2289s2.f8052d;
                c2296t2.f8062c = c2204g1;
                return c2296t2;
        }
    }

    public C2197f1(Iterable[] iterableArr) {
        this.f7896c = iterableArr;
    }
}

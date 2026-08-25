package p041d7;

import java.util.NoSuchElementException;

public final class C2308v2 extends AbstractC2292s5 {

    public final Object f8075a;

    public boolean f8076b;

    public C2308v2(Object obj) {
        this.f8075a = obj;
    }

    @Override
    public final boolean hasNext() {
        return !this.f8076b;
    }

    @Override
    public final Object next() {
        if (this.f8076b) {
            throw new NoSuchElementException();
        }
        this.f8076b = true;
        return this.f8075a;
    }
}

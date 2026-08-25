package p156o9;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p115k9.InterfaceC2905a;

public final class C3283g implements Iterator, InterfaceC2905a {

    public final int f10992a;

    public final int f10993b;

    public boolean f10994c;

    public int f10995d;

    public C3283g(int i6, int i10, int i11) {
        this.f10992a = i11;
        this.f10993b = i10;
        boolean z7 = false;
        if (i11 <= 0 ? i6 >= i10 : i6 <= i10) {
            z7 = true;
        }
        this.f10994c = z7;
        this.f10995d = z7 ? i6 : i10;
    }

    @Override
    public final boolean hasNext() {
        return this.f10994c;
    }

    @Override
    public final Object next() {
        int i6 = this.f10995d;
        if (i6 != this.f10993b) {
            this.f10995d = this.f10992a + i6;
        } else {
            if (!this.f10994c) {
                throw new NoSuchElementException();
            }
            this.f10994c = false;
        }
        return Integer.valueOf(i6);
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

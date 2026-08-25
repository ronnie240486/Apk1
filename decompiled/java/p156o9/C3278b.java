package p156o9;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p103j9.AbstractC2796i;
import p115k9.InterfaceC2905a;

public final class C3278b implements Iterator, InterfaceC2905a {

    public final int f10970a;

    public final int f10971b;

    public boolean f10972c;

    public int f10973d;

    public C3278b(char c5, int i6) {
        this.f10970a = i6;
        this.f10971b = c5;
        boolean z7 = false;
        if (i6 <= 0 ? AbstractC2796i.m5787h(1, c5) >= 0 : AbstractC2796i.m5787h(1, c5) <= 0) {
            z7 = true;
        }
        this.f10972c = z7;
        this.f10973d = z7 ? (char) 1 : c5;
    }

    @Override
    public final boolean hasNext() {
        return this.f10972c;
    }

    @Override
    public final Object next() {
        int i6 = this.f10973d;
        if (i6 != this.f10971b) {
            this.f10973d = this.f10970a + i6;
        } else {
            if (!this.f10972c) {
                throw new NoSuchElementException();
            }
            this.f10972c = false;
        }
        return Character.valueOf((char) i6);
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

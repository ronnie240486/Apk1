package p181q9;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p008a9.C0080j;
import p008a9.InterfaceC0074d;
import p008a9.InterfaceC0079i;
import p103j9.AbstractC2796i;
import p115k9.InterfaceC2905a;
import p156o9.AbstractC3280d;
import p243w8.C4070l;

public final class C3546d extends AbstractC3547e implements Iterator, InterfaceC0074d, InterfaceC2905a {

    public int f11947a;

    public Object f11948b;

    public Iterator f11949c;

    public InterfaceC0074d f11950d;

    public final RuntimeException m7171a() {
        int i6 = this.f11947a;
        if (i6 == 4) {
            return new NoSuchElementException();
        }
        if (i6 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f11947a);
    }

    @Override
    public final InterfaceC0079i getContext() {
        return C0080j.f206a;
    }

    @Override
    public final boolean hasNext() {
        while (true) {
            int i6 = this.f11947a;
            if (i6 != 0) {
                if (i6 != 1) {
                    if (i6 == 2 || i6 == 3) {
                        return true;
                    }
                    if (i6 == 4) {
                        return false;
                    }
                    throw m7171a();
                }
                Iterator it = this.f11949c;
                AbstractC2796i.m5782c(it);
                if (it.hasNext()) {
                    this.f11947a = 2;
                    return true;
                }
                this.f11949c = null;
            }
            this.f11947a = 5;
            InterfaceC0074d interfaceC0074d = this.f11950d;
            AbstractC2796i.m5782c(interfaceC0074d);
            this.f11950d = null;
            interfaceC0074d.resumeWith(C4070l.f13734a);
        }
    }

    @Override
    public final Object next() {
        int i6 = this.f11947a;
        if (i6 == 0 || i6 == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        }
        if (i6 == 2) {
            this.f11947a = 1;
            Iterator it = this.f11949c;
            AbstractC2796i.m5782c(it);
            return it.next();
        }
        if (i6 != 3) {
            throw m7171a();
        }
        this.f11947a = 0;
        Object obj = this.f11948b;
        this.f11948b = null;
        return obj;
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final void resumeWith(Object obj) {
        AbstractC3280d.m6570I(obj);
        this.f11947a = 4;
    }
}

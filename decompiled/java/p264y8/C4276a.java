package p264y8;

import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import p103j9.AbstractC2796i;
import p115k9.InterfaceC2905a;
import p253x8.AbstractC4143f;

public final class C4276a implements ListIterator, InterfaceC2905a {

    public final int f14486a = 0;

    public int f14487b;

    public int f14488c;

    public int f14489d;

    public final AbstractC4143f f14490e;

    public C4276a(C4278c c4278c, int i6) {
        AbstractC2796i.m5785f(c4278c, "list");
        this.f14490e = c4278c;
        this.f14487b = i6;
        this.f14488c = -1;
        this.f14489d = ((AbstractList) c4278c).modCount;
    }

    public void m8324a() {
        if (((AbstractList) ((C4277b) this.f14490e).f14495e).modCount != this.f14489d) {
            throw new ConcurrentModificationException();
        }
    }

    @Override
    public final void add(Object obj) {
        switch (this.f14486a) {
            case 0:
                m8324a();
                int i6 = this.f14487b;
                this.f14487b = i6 + 1;
                C4277b c4277b = (C4277b) this.f14490e;
                c4277b.add(i6, obj);
                this.f14488c = -1;
                this.f14489d = ((AbstractList) c4277b).modCount;
                break;
            default:
                m8325b();
                int i10 = this.f14487b;
                this.f14487b = i10 + 1;
                C4278c c4278c = (C4278c) this.f14490e;
                c4278c.add(i10, obj);
                this.f14488c = -1;
                this.f14489d = ((AbstractList) c4278c).modCount;
                break;
        }
    }

    public void m8325b() {
        if (((AbstractList) ((C4278c) this.f14490e)).modCount != this.f14489d) {
            throw new ConcurrentModificationException();
        }
    }

    @Override
    public final boolean hasNext() {
        switch (this.f14486a) {
            case 0:
                return this.f14487b < ((C4277b) this.f14490e).f14493c;
            default:
                return this.f14487b < ((C4278c) this.f14490e).f14498b;
        }
    }

    @Override
    public final boolean hasPrevious() {
        switch (this.f14486a) {
            case 0:
                return this.f14487b > 0;
            default:
                return this.f14487b > 0;
        }
    }

    @Override
    public final Object next() {
        switch (this.f14486a) {
            case 0:
                m8324a();
                int i6 = this.f14487b;
                C4277b c4277b = (C4277b) this.f14490e;
                if (i6 >= c4277b.f14493c) {
                    throw new NoSuchElementException();
                }
                this.f14487b = i6 + 1;
                this.f14488c = i6;
                return c4277b.f14491a[c4277b.f14492b + i6];
            default:
                m8325b();
                int i10 = this.f14487b;
                C4278c c4278c = (C4278c) this.f14490e;
                if (i10 >= c4278c.f14498b) {
                    throw new NoSuchElementException();
                }
                this.f14487b = i10 + 1;
                this.f14488c = i10;
                return c4278c.f14497a[i10];
        }
    }

    @Override
    public final int nextIndex() {
        switch (this.f14486a) {
            case 0:
                break;
        }
        return this.f14487b;
    }

    @Override
    public final Object previous() {
        switch (this.f14486a) {
            case 0:
                m8324a();
                int i6 = this.f14487b;
                if (i6 <= 0) {
                    throw new NoSuchElementException();
                }
                int i10 = i6 - 1;
                this.f14487b = i10;
                this.f14488c = i10;
                C4277b c4277b = (C4277b) this.f14490e;
                return c4277b.f14491a[c4277b.f14492b + i10];
            default:
                m8325b();
                int i11 = this.f14487b;
                if (i11 <= 0) {
                    throw new NoSuchElementException();
                }
                int i12 = i11 - 1;
                this.f14487b = i12;
                this.f14488c = i12;
                return ((C4278c) this.f14490e).f14497a[i12];
        }
    }

    @Override
    public final int previousIndex() {
        switch (this.f14486a) {
            case 0:
                break;
        }
        return this.f14487b - 1;
    }

    @Override
    public final void remove() {
        switch (this.f14486a) {
            case 0:
                m8324a();
                int i6 = this.f14488c;
                if (i6 == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                C4277b c4277b = (C4277b) this.f14490e;
                c4277b.mo8161d(i6);
                this.f14487b = this.f14488c;
                this.f14488c = -1;
                this.f14489d = ((AbstractList) c4277b).modCount;
                return;
            default:
                m8325b();
                int i10 = this.f14488c;
                if (i10 == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                C4278c c4278c = (C4278c) this.f14490e;
                c4278c.mo8161d(i10);
                this.f14487b = this.f14488c;
                this.f14488c = -1;
                this.f14489d = ((AbstractList) c4278c).modCount;
                return;
        }
    }

    @Override
    public final void set(Object obj) {
        switch (this.f14486a) {
            case 0:
                m8324a();
                int i6 = this.f14488c;
                if (i6 == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                ((C4277b) this.f14490e).set(i6, obj);
                return;
            default:
                m8325b();
                int i10 = this.f14488c;
                if (i10 == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                ((C4278c) this.f14490e).set(i10, obj);
                return;
        }
    }

    public C4276a(C4277b c4277b, int i6) {
        AbstractC2796i.m5785f(c4277b, "list");
        this.f14490e = c4277b;
        this.f14487b = i6;
        this.f14488c = -1;
        this.f14489d = ((AbstractList) c4277b).modCount;
    }
}

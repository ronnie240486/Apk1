package p156o9;

import java.util.Iterator;
import p115k9.InterfaceC2905a;

public class C3282f implements Iterable, InterfaceC2905a {

    public final int f10989a;

    public final int f10990b;

    public final int f10991c;

    public C3282f(int i6, int i10, int i11) {
        if (i11 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i11 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f10989a = i6;
        this.f10990b = AbstractC3280d.m6598p(i6, i10, i11);
        this.f10991c = i11;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C3282f) {
            if (!isEmpty() || !((C3282f) obj).isEmpty()) {
                C3282f c3282f = (C3282f) obj;
                if (this.f10989a != c3282f.f10989a || this.f10990b != c3282f.f10990b || this.f10991c != c3282f.f10991c) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f10989a * 31) + this.f10990b) * 31) + this.f10991c;
    }

    public boolean isEmpty() {
        int i6 = this.f10991c;
        int i10 = this.f10990b;
        int i11 = this.f10989a;
        if (i6 > 0) {
            if (i11 <= i10) {
                return false;
            }
        } else if (i11 >= i10) {
            return false;
        }
        return true;
    }

    @Override
    public final Iterator iterator() {
        return new C3283g(this.f10989a, this.f10990b, this.f10991c);
    }

    public String toString() {
        StringBuilder sb;
        int i6 = this.f10990b;
        int i10 = this.f10989a;
        int i11 = this.f10991c;
        if (i11 > 0) {
            sb = new StringBuilder();
            sb.append(i10);
            sb.append("..");
            sb.append(i6);
            sb.append(" step ");
            sb.append(i11);
        } else {
            sb = new StringBuilder();
            sb.append(i10);
            sb.append(" downTo ");
            sb.append(i6);
            sb.append(" step ");
            sb.append(-i11);
        }
        return sb.toString();
    }
}

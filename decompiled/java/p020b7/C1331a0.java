package p020b7;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p001a0.C0019b;
import p215u.AbstractC3885h;

public final class C1331a0 implements Iterator {

    public String f4140b;

    public final CharSequence f4141c;

    public final C1338e f4142d;

    public int f4144f;

    public final C0019b f4145g;

    public int f4139a = 2;

    public int f4143e = 0;

    public C1331a0(C0019b c0019b, C1333b0 c1333b0, CharSequence charSequence) {
        this.f4145g = c0019b;
        this.f4142d = c1333b0.f4146a;
        this.f4144f = c1333b0.f4148c;
        this.f4141c = charSequence;
    }

    @Override
    public final boolean hasNext() {
        String string;
        AbstractC1332b.m3224o(this.f4139a != 4);
        int iM7785a = AbstractC3885h.m7785a(this.f4139a);
        if (iM7785a == 0) {
            return true;
        }
        if (iM7785a == 2) {
            return false;
        }
        this.f4139a = 4;
        int i6 = this.f4143e;
        while (true) {
            int length = this.f4143e;
            if (length == -1) {
                this.f4139a = 3;
                string = null;
                break;
            }
            C1336d c1336d = (C1336d) this.f4145g.f38b;
            CharSequence charSequence = this.f4141c;
            int length2 = charSequence.length();
            AbstractC1332b.m3220k(length, length2);
            while (true) {
                if (length >= length2) {
                    length = -1;
                    break;
                }
                if (c1336d.mo3235a(charSequence.charAt(length))) {
                    break;
                }
                length++;
            }
            if (length == -1) {
                length = charSequence.length();
                this.f4143e = -1;
            } else {
                this.f4143e = length + 1;
            }
            int i10 = this.f4143e;
            if (i10 != i6) {
                C1338e c1338e = this.f4142d;
                if (i6 < length) {
                    charSequence.charAt(i6);
                    c1338e.getClass();
                }
                if (length > i6) {
                    charSequence.charAt(length - 1);
                    c1338e.getClass();
                }
                int i11 = this.f4144f;
                if (i11 == 1) {
                    length = charSequence.length();
                    this.f4143e = -1;
                    if (length > i6) {
                        charSequence.charAt(length - 1);
                        c1338e.getClass();
                    }
                } else {
                    this.f4144f = i11 - 1;
                }
                string = charSequence.subSequence(i6, length).toString();
                break;
            }
            int i12 = i10 + 1;
            this.f4143e = i12;
            if (i12 > charSequence.length()) {
                this.f4143e = -1;
            }
        }
        this.f4140b = string;
        if (this.f4139a == 3) {
            return false;
        }
        this.f4139a = 1;
        return true;
    }

    @Override
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f4139a = 2;
        String str = this.f4140b;
        this.f4140b = null;
        return str;
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

package p192r9;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p103j9.AbstractC2796i;
import p115k9.InterfaceC2905a;

public final class C3646d implements Iterator, InterfaceC2905a {

    public final String f12249a;

    public int f12250b;

    public int f12251c;

    public int f12252d;

    public int f12253e;

    public C3646d(String str) {
        AbstractC2796i.m5785f(str, "string");
        this.f12249a = str;
    }

    @Override
    public final boolean hasNext() {
        int i6;
        int i10;
        int i11 = this.f12250b;
        if (i11 != 0) {
            return i11 == 1;
        }
        if (this.f12253e < 0) {
            this.f12250b = 2;
            return false;
        }
        String str = this.f12249a;
        int length = str.length();
        int length2 = str.length();
        for (int i12 = this.f12251c; i12 < length2; i12++) {
            char cCharAt = str.charAt(i12);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i6 = (cCharAt == '\r' && (i10 = i12 + 1) < str.length() && str.charAt(i10) == '\n') ? 2 : 1;
                length = i12;
                this.f12250b = 1;
                this.f12253e = i6;
                this.f12252d = length;
                return true;
            }
        }
        i6 = -1;
        this.f12250b = 1;
        this.f12253e = i6;
        this.f12252d = length;
        return true;
    }

    @Override
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f12250b = 0;
        int i6 = this.f12252d;
        int i10 = this.f12251c;
        this.f12251c = this.f12253e + i6;
        return this.f12249a.subSequence(i10, i6).toString();
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

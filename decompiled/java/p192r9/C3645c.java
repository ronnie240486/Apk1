package p192r9;

import java.util.Iterator;
import p103j9.AbstractC2796i;
import p181q9.InterfaceC3545c;

public final class C3645c implements InterfaceC3545c {

    public final String f12245a;

    public final int f12246b;

    public final int f12247c;

    public final C3657o f12248d;

    public C3645c(String str, int i6, int i10, C3657o c3657o) {
        AbstractC2796i.m5785f(str, "input");
        this.f12245a = str;
        this.f12246b = i6;
        this.f12247c = i10;
        this.f12248d = c3657o;
    }

    @Override
    public final Iterator iterator() {
        return new C3644b(this);
    }
}

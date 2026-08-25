package p181q9;

import java.util.Iterator;
import p115k9.InterfaceC2905a;
import p192r9.C3644b;
import p192r9.C3645c;

public final class C3551i implements Iterable, InterfaceC2905a {

    public final C3645c f11953a;

    public C3551i(C3645c c3645c) {
        this.f11953a = c3645c;
    }

    @Override
    public final Iterator iterator() {
        return new C3644b(this.f11953a);
    }
}

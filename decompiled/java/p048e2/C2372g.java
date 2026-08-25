package p048e2;

import java.io.IOException;
import okio.Okio;
import p008a9.InterfaceC0074d;
import p030c9.AbstractC1439i;
import p091i9.InterfaceC2728p;
import p156o9.AbstractC3280d;
import p213t9.InterfaceC3861s;
import p243w8.C4070l;

public final class C2372g extends AbstractC1439i implements InterfaceC2728p {

    public final C2373h f8302b;

    public C2372g(C2373h c2373h, InterfaceC0074d interfaceC0074d) {
        super(interfaceC0074d);
        this.f8302b = c2373h;
    }

    @Override
    public final InterfaceC0074d create(Object obj, InterfaceC0074d interfaceC0074d) {
        return new C2372g(this.f8302b, interfaceC0074d);
    }

    @Override
    public final Object invoke(Object obj, Object obj2) {
        return ((C2372g) create((InterfaceC3861s) obj, (InterfaceC0074d) obj2)).invokeSuspend(C4070l.f13734a);
    }

    @Override
    public final Object invokeSuspend(Object obj) {
        AbstractC3280d.m6570I(obj);
        C2373h c2373h = this.f8302b;
        synchronized (c2373h) {
            if (!c2373h.f8315l || c2373h.f8316m) {
                return C4070l.f13734a;
            }
            try {
                c2373h.m5396j();
            } catch (IOException unused) {
                c2373h.f8317n = true;
            }
            try {
                if (c2373h.f8312i >= 2000) {
                    c2373h.m5397l();
                }
            } catch (IOException unused2) {
                c2373h.f8318o = true;
                c2373h.f8313j = Okio.buffer(Okio.blackhole());
            }
            return C4070l.f13734a;
        }
    }
}

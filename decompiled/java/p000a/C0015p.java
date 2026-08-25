package p000a;

import androidx.fragment.app.C0394b0;
import java.util.ArrayDeque;
import p094j0.AbstractC2754b;

public final class C0015p implements InterfaceC0000a {

    public final C0394b0 f29a;

    public final C0016q f30b;

    public C0015p(C0016q c0016q, C0394b0 c0394b0) {
        this.f30b = c0016q;
        this.f29a = c0394b0;
    }

    @Override
    public final void cancel() {
        C0016q c0016q = this.f30b;
        ArrayDeque arrayDeque = (ArrayDeque) c0016q.f33c;
        C0394b0 c0394b0 = this.f29a;
        arrayDeque.remove(c0394b0);
        c0394b0.f1824b.remove(this);
        if (AbstractC2754b.m5721a()) {
            c0394b0.f1825c = null;
            c0016q.m51d();
        }
    }
}

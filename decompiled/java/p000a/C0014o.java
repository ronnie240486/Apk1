package p000a;

import androidx.fragment.app.C0394b0;
import androidx.lifecycle.AbstractC0541p;
import androidx.lifecycle.EnumC0537n;
import androidx.lifecycle.InterfaceC0551u;
import androidx.lifecycle.InterfaceC0555w;
import java.util.ArrayDeque;
import p094j0.AbstractC2754b;

public final class C0014o implements InterfaceC0551u, InterfaceC0000a {

    public final AbstractC0541p f25a;

    public final C0394b0 f26b;

    public C0015p f27c;

    public final C0016q f28d;

    public C0014o(C0016q c0016q, AbstractC0541p abstractC0541p, C0394b0 c0394b0) {
        this.f28d = c0016q;
        this.f25a = abstractC0541p;
        this.f26b = c0394b0;
        abstractC0541p.mo1508a(this);
    }

    @Override
    public final void cancel() {
        this.f25a.mo1510c(this);
        this.f26b.f1824b.remove(this);
        C0015p c0015p = this.f27c;
        if (c0015p != null) {
            c0015p.cancel();
            this.f27c = null;
        }
    }

    @Override
    public final void onStateChanged(InterfaceC0555w interfaceC0555w, EnumC0537n enumC0537n) {
        if (enumC0537n != EnumC0537n.ON_START) {
            if (enumC0537n != EnumC0537n.ON_STOP) {
                if (enumC0537n == EnumC0537n.ON_DESTROY) {
                    cancel();
                    return;
                }
                return;
            } else {
                C0015p c0015p = this.f27c;
                if (c0015p != null) {
                    c0015p.cancel();
                    return;
                }
                return;
            }
        }
        C0016q c0016q = this.f28d;
        ArrayDeque arrayDeque = (ArrayDeque) c0016q.f33c;
        C0394b0 c0394b0 = this.f26b;
        arrayDeque.add(c0394b0);
        C0015p c0015p2 = new C0015p(c0016q, c0394b0);
        c0394b0.f1824b.add(c0015p2);
        if (AbstractC2754b.m5721a()) {
            c0016q.m51d();
            c0394b0.f1825c = (C0011l) c0016q.f34d;
        }
        this.f27c = c0015p2;
    }
}

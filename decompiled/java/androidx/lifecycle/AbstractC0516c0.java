package androidx.lifecycle;

import androidx.fragment.app.FragmentActivity;

public abstract class AbstractC0516c0 {

    public final InterfaceC0520e0 f2464a;

    public boolean f2465b;

    public int f2466c = -1;

    public final C0518d0 f2467d;

    public AbstractC0516c0(C0518d0 c0518d0, InterfaceC0520e0 interfaceC0520e0) {
        this.f2467d = c0518d0;
        this.f2464a = interfaceC0520e0;
    }

    public final void m1478d(boolean z7) {
        if (z7 == this.f2465b) {
            return;
        }
        this.f2465b = z7;
        int i6 = z7 ? 1 : -1;
        C0518d0 c0518d0 = this.f2467d;
        int i10 = c0518d0.f2474c;
        c0518d0.f2474c = i6 + i10;
        if (!c0518d0.f2475d) {
            c0518d0.f2475d = true;
            while (true) {
                try {
                    int i11 = c0518d0.f2474c;
                    if (i10 == i11) {
                        break;
                    }
                    boolean z10 = i10 == 0 && i11 > 0;
                    boolean z11 = i10 > 0 && i11 == 0;
                    if (z10) {
                        c0518d0.getClass();
                    } else if (z11) {
                        c0518d0.getClass();
                    }
                    i10 = i11;
                } catch (Throwable th) {
                    c0518d0.f2475d = false;
                    throw th;
                }
            }
            c0518d0.f2475d = false;
        }
        if (this.f2465b) {
            c0518d0.m1483c(this);
        }
    }

    public boolean mo1477h(FragmentActivity fragmentActivity) {
        return false;
    }

    public abstract boolean mo1474i();

    public void mo1476g() {
    }
}

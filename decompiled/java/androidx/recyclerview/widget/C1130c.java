package androidx.recyclerview.widget;

import java.util.Iterator;
import p187r4.C3616f;
import p187r4.C3621k;
import p230v4.C4000n;
import p242w5.InterfaceC4054b;
import p261y4.C4257e;

public final class C1130c implements InterfaceC4054b {

    public final int f3522a;

    public long f3523b;

    public Object f3524c;

    public C1130c(C3621k c3621k, long j10) {
        this.f3522a = 1;
        this.f3524c = c3621k;
        this.f3523b = j10;
    }

    @Override
    public void mo2899a(Exception exc) {
        int i6 = exc instanceof C4257e ? ((C4257e) exc).f14453a.f4994a : 13;
        Iterator it = ((C3616f) ((C3621k) this.f3524c).f12172d).f12150c.f13560d.iterator();
        while (it.hasNext()) {
            ((C4000n) it.next()).m7993b(this.f3523b, i6, null);
        }
    }

    public void m2900b(int i6) {
        if (i6 < 64) {
            this.f3523b &= ~(1 << i6);
            return;
        }
        C1130c c1130c = (C1130c) this.f3524c;
        if (c1130c != null) {
            c1130c.m2900b(i6 - 64);
        }
    }

    public int m2901c(int i6) {
        C1130c c1130c = (C1130c) this.f3524c;
        if (c1130c == null) {
            return i6 >= 64 ? Long.bitCount(this.f3523b) : Long.bitCount(this.f3523b & ((1 << i6) - 1));
        }
        if (i6 < 64) {
            return Long.bitCount(this.f3523b & ((1 << i6) - 1));
        }
        return Long.bitCount(this.f3523b) + c1130c.m2901c(i6 - 64);
    }

    public void m2902d() {
        if (((C1130c) this.f3524c) == null) {
            this.f3524c = new C1130c();
        }
    }

    public boolean m2903e(int i6) {
        if (i6 < 64) {
            return (this.f3523b & (1 << i6)) != 0;
        }
        m2902d();
        return ((C1130c) this.f3524c).m2903e(i6 - 64);
    }

    public void m2904f(int i6, boolean z7) {
        if (i6 >= 64) {
            m2902d();
            ((C1130c) this.f3524c).m2904f(i6 - 64, z7);
            return;
        }
        long j10 = this.f3523b;
        boolean z10 = (Long.MIN_VALUE & j10) != 0;
        long j11 = (1 << i6) - 1;
        this.f3523b = ((j10 & (~j11)) << 1) | (j10 & j11);
        if (z7) {
            m2907i(i6);
        } else {
            m2900b(i6);
        }
        if (z10 || ((C1130c) this.f3524c) != null) {
            m2902d();
            ((C1130c) this.f3524c).m2904f(0, z10);
        }
    }

    public boolean m2905g(int i6) {
        if (i6 >= 64) {
            m2902d();
            return ((C1130c) this.f3524c).m2905g(i6 - 64);
        }
        long j10 = 1 << i6;
        long j11 = this.f3523b;
        boolean z7 = (j11 & j10) != 0;
        long j12 = j11 & (~j10);
        this.f3523b = j12;
        long j13 = j10 - 1;
        this.f3523b = (j12 & j13) | Long.rotateRight((~j13) & j12, 1);
        C1130c c1130c = (C1130c) this.f3524c;
        if (c1130c != null) {
            if (c1130c.m2903e(0)) {
                m2907i(63);
            }
            ((C1130c) this.f3524c).m2905g(0);
        }
        return z7;
    }

    public void m2906h() {
        this.f3523b = 0L;
        C1130c c1130c = (C1130c) this.f3524c;
        if (c1130c != null) {
            c1130c.m2906h();
        }
    }

    public void m2907i(int i6) {
        if (i6 < 64) {
            this.f3523b |= 1 << i6;
        } else {
            m2902d();
            ((C1130c) this.f3524c).m2907i(i6 - 64);
        }
    }

    public String toString() {
        switch (this.f3522a) {
            case 0:
                if (((C1130c) this.f3524c) == null) {
                    return Long.toBinaryString(this.f3523b);
                }
                return ((C1130c) this.f3524c).toString() + "xx" + Long.toBinaryString(this.f3523b);
            default:
                return super.toString();
        }
    }

    public C1130c() {
        this.f3522a = 0;
        this.f3523b = 0L;
    }
}

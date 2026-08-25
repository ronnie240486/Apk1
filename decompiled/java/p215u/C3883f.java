package p215u;

import p000a.AbstractC0004e;
import p055ea.AbstractC2460q;

public final class C3883f implements Comparable {

    public C3886i f13045a;

    public final C3884g f13046b;

    public C3883f(C3884g c3884g) {
        this.f13046b = c3884g;
    }

    @Override
    public final int compareTo(Object obj) {
        return this.f13045a.f13052b - ((C3886i) obj).f13052b;
    }

    public final String toString() {
        String string = "[ ";
        if (this.f13045a != null) {
            for (int i6 = 0; i6 < 9; i6++) {
                StringBuilder sbM5498l = AbstractC2460q.m5498l(string);
                sbM5498l.append(this.f13045a.f13058h[i6]);
                sbM5498l.append(" ");
                string = sbM5498l.toString();
            }
        }
        StringBuilder sbM29w = AbstractC0004e.m29w(string, "] ");
        sbM29w.append(this.f13045a);
        return sbM29w.toString();
    }
}

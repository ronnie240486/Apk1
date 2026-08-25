package p041d7;

import java.util.Collection;
import java.util.Set;
import p020b7.AbstractC1332b;

public class C2254n2 extends AbstractC2205g2 implements InterfaceC2243l5 {

    public final transient AbstractC2233k2 f8005h;

    public transient C2247m2 f8006i;

    public C2254n2(C2215h5 c2215h5, int i6) {
        super(c2215h5, i6);
        int i10 = AbstractC2233k2.f7972c;
        this.f8005h = C2222i5.f7947j;
    }

    @Override
    public final Collection mo5108a() {
        C2247m2 c2247m2 = this.f8006i;
        if (c2247m2 != null) {
            return c2247m2;
        }
        C2247m2 c2247m3 = new C2247m2(this);
        this.f8006i = c2247m3;
        return c2247m3;
    }

    @Override
    public final Collection get(Object obj) {
        return (AbstractC2233k2) AbstractC1332b.m3227r((AbstractC2233k2) this.f7907f.get(obj), this.f8005h);
    }

    @Override
    public final AbstractC2274q1 mo5108a() {
        C2247m2 c2247m2 = this.f8006i;
        if (c2247m2 != null) {
            return c2247m2;
        }
        C2247m2 c2247m3 = new C2247m2(this);
        this.f8006i = c2247m3;
        return c2247m3;
    }

    @Override
    public final Set mo5108a() {
        C2247m2 c2247m2 = this.f8006i;
        if (c2247m2 != null) {
            return c2247m2;
        }
        C2247m2 c2247m3 = new C2247m2(this);
        this.f8006i = c2247m3;
        return c2247m3;
    }

    @Override
    public final Set get(Object obj) {
        return (AbstractC2233k2) AbstractC1332b.m3227r((AbstractC2233k2) this.f7907f.get(obj), this.f8005h);
    }
}

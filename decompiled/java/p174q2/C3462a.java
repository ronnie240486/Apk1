package p174q2;

import p028c6.C1400c;
import p036d2.EnumC2137f;
import p130m2.AbstractC3062j;
import p130m2.C3069q;
import p150o2.C3246a;

public final class C3462a implements InterfaceC3465d {

    public final int f11726b;

    public final boolean f11727c = false;

    public C3462a(int i6) {
        this.f11726b = i6;
        if (i6 <= 0) {
            throw new IllegalArgumentException("durationMillis must be > 0.");
        }
    }

    @Override
    public final InterfaceC3466e mo7097a(C3246a c3246a, AbstractC3062j abstractC3062j) {
        if (!(abstractC3062j instanceof C3069q)) {
            return new C3464c(c3246a, abstractC3062j);
        }
        if (((C3069q) abstractC3062j).f10516c == EnumC2137f.f7760a) {
            return new C3464c(c3246a, abstractC3062j);
        }
        int i6 = this.f11726b;
        boolean z7 = this.f11727c;
        C1400c c1400c = new C1400c();
        c1400c.f4265c = c3246a;
        c1400c.f4266d = abstractC3062j;
        c1400c.f4263a = i6;
        c1400c.f4264b = z7;
        if (i6 > 0) {
            return c1400c;
        }
        throw new IllegalArgumentException("durationMillis must be > 0.");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C3462a) {
            C3462a c3462a = (C3462a) obj;
            if (this.f11726b == c3462a.f11726b && this.f11727c == c3462a.f11727c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f11726b * 31) + (this.f11727c ? 1231 : 1237);
    }
}

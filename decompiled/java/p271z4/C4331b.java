package p271z4;

import java.util.Arrays;
import p018b5.AbstractC1312l;
import p124l6.C2982h;
import p261y4.InterfaceC4254b;

public final class C4331b {

    public final int f14685a;

    public final C2982h f14686b;

    public final InterfaceC4254b f14687c;

    public final String f14688d;

    public C4331b(C2982h c2982h, InterfaceC4254b interfaceC4254b, String str) {
        this.f14686b = c2982h;
        this.f14687c = interfaceC4254b;
        this.f14688d = str;
        this.f14685a = Arrays.hashCode(new Object[]{c2982h, interfaceC4254b, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C4331b)) {
            return false;
        }
        C4331b c4331b = (C4331b) obj;
        return AbstractC1312l.m3201h(this.f14686b, c4331b.f14686b) && AbstractC1312l.m3201h(this.f14687c, c4331b.f14687c) && AbstractC1312l.m3201h(this.f14688d, c4331b.f14688d);
    }

    public final int hashCode() {
        return this.f14685a;
    }
}

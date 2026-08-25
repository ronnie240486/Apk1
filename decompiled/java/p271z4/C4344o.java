package p271z4;

import com.google.android.gms.common.Feature;
import com.lzy.okgo.cache.CacheEntity;
import java.util.Arrays;
import p007a7.C0069f;
import p018b5.AbstractC1312l;

public final class C4344o {

    public final C4331b f14733a;

    public final Feature f14734b;

    public C4344o(C4331b c4331b, Feature feature) {
        this.f14733a = c4331b;
        this.f14734b = feature;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof C4344o)) {
            C4344o c4344o = (C4344o) obj;
            if (AbstractC1312l.m3201h(this.f14733a, c4344o.f14733a) && AbstractC1312l.m3201h(this.f14734b, c4344o.f14734b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f14733a, this.f14734b});
    }

    public final String toString() {
        C0069f c0069f = new C0069f(this);
        c0069f.m229c(this.f14733a, CacheEntity.KEY);
        c0069f.m229c(this.f14734b, "feature");
        return c0069f.toString();
    }
}

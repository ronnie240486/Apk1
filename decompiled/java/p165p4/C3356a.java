package p165p4;

import android.os.Bundle;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.internal.cast.C1602k0;
import java.util.Arrays;
import java.util.Set;
import java.util.UUID;
import p002a1.C0026b;
import p018b5.AbstractC1312l;
import p261y4.InterfaceC4254b;

public final class C3356a implements InterfaceC4254b {

    public final CastDevice f11346a;

    public final C1602k0 f11347b;

    public final Bundle f11348c;

    public final String f11349d = UUID.randomUUID().toString();

    public C3356a(C0026b c0026b) {
        this.f11346a = (CastDevice) c0026b.f54b;
        this.f11347b = (C1602k0) c0026b.f55c;
        this.f11348c = (Bundle) c0026b.f56d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3356a)) {
            return false;
        }
        C3356a c3356a = (C3356a) obj;
        if (AbstractC1312l.m3201h(this.f11346a, c3356a.f11346a)) {
            Bundle bundle = this.f11348c;
            Bundle bundle2 = c3356a.f11348c;
            if (bundle == null || bundle2 == null) {
                if (bundle == bundle2) {
                    if (AbstractC1312l.m3201h(this.f11349d, c3356a.f11349d)) {
                        return true;
                    }
                }
            } else if (bundle.size() == bundle2.size()) {
                Set<String> setKeySet = bundle.keySet();
                if (setKeySet.containsAll(bundle2.keySet())) {
                    for (String str : setKeySet) {
                        if (!AbstractC1312l.m3201h(bundle.get(str), bundle2.get(str))) {
                        }
                    }
                    if (AbstractC1312l.m3201h(this.f11349d, c3356a.f11349d)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f11346a, this.f11348c, 0, this.f11349d});
    }
}

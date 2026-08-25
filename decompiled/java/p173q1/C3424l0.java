package p173q1;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class C3424l0 {

    public static final C3424l0 f11567c = new C3424l0(new Bundle(), null);

    public final Bundle f11568a;

    public List f11569b;

    public C3424l0(Bundle bundle, ArrayList arrayList) {
        this.f11568a = bundle;
        this.f11569b = arrayList;
    }

    public static C3424l0 m6999b(Bundle bundle) {
        if (bundle != null) {
            return new C3424l0(bundle, null);
        }
        return null;
    }

    public final void m7000a() {
        if (this.f11569b == null) {
            ArrayList<String> stringArrayList = this.f11568a.getStringArrayList("controlCategories");
            this.f11569b = stringArrayList;
            if (stringArrayList == null || stringArrayList.isEmpty()) {
                this.f11569b = Collections.emptyList();
            }
        }
    }

    public final ArrayList m7001c() {
        m7000a();
        return new ArrayList(this.f11569b);
    }

    public final boolean m7002d() {
        m7000a();
        return this.f11569b.isEmpty();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C3424l0)) {
            return false;
        }
        C3424l0 c3424l0 = (C3424l0) obj;
        m7000a();
        c3424l0.m7000a();
        return this.f11569b.equals(c3424l0.f11569b);
    }

    public final int hashCode() {
        m7000a();
        return this.f11569b.hashCode();
    }

    public final String toString() {
        return "MediaRouteSelector{ controlCategories=" + Arrays.toString(m7001c().toArray()) + " }";
    }
}

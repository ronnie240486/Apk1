package p173q1;

import android.media.MediaRoute2Info;
import android.media.RouteDiscoveryPreference;
import java.util.ArrayList;

public abstract class AbstractC3447t {
    public static MediaRoute2Info.Builder m7040f(String str, String str2) {
        return new MediaRoute2Info.Builder(str, str2);
    }

    public static RouteDiscoveryPreference.Builder m7042h(ArrayList arrayList) {
        return new RouteDiscoveryPreference.Builder(arrayList, false);
    }

    public static RouteDiscoveryPreference.Builder m7043i(ArrayList arrayList, boolean z7) {
        return new RouteDiscoveryPreference.Builder(arrayList, z7);
    }

    public static void m7046l() {
    }
}

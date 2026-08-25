package androidx.mediarouter.app;

import android.media.MediaRoute2Info;
import android.media.MediaRouter2;
import android.media.RouteListingPreference;
import java.util.ArrayList;
import java.util.Set;
import p173q1.C3443r1;
import p173q1.C3446s1;
import p173q1.C3454w;

public abstract class AbstractC1115t0 {
    public static void m2782a(MediaRoute2Info.Builder builder, C3454w c3454w) {
        if (c3454w.f11701a.getBoolean("isVisibilityPublic", true)) {
            builder.setVisibilityPublic();
        } else {
            builder.setVisibilityRestricted(c3454w.m7084a());
        }
    }

    public static Set m2783b(MediaRoute2Info mediaRoute2Info) {
        return mediaRoute2Info.getDeduplicationIds();
    }

    public static int m2784c(MediaRoute2Info mediaRoute2Info) {
        return mediaRoute2Info.getType();
    }

    public static void m2785d(MediaRoute2Info.Builder builder, Set set) {
        builder.setDeduplicationIds(set);
    }

    public static void m2786e(MediaRoute2Info.Builder builder, int i6) {
        builder.setType(i6);
    }

    public static void m2787f(MediaRouter2 mediaRouter2, RouteListingPreference routeListingPreference) {
        mediaRouter2.setRouteListingPreference(routeListingPreference);
    }

    public static boolean m2788g(MediaRouter2 mediaRouter2) {
        return mediaRouter2.showSystemOutputSwitcher();
    }

    public static RouteListingPreference m2789h(C3446s1 c3446s1) {
        ArrayList arrayList = new ArrayList();
        for (C3443r1 c3443r1 : c3446s1.f11674a) {
            arrayList.add(new RouteListingPreference.Item.Builder(c3443r1.f11648a).setFlags(0).setSubText(0).setCustomSubtextMessage(null).setSelectionBehavior(c3443r1.f11649b).build());
        }
        return new RouteListingPreference.Builder().setItems(arrayList).setLinkedItemComponentName(null).setUseSystemOrdering(true).build();
    }
}

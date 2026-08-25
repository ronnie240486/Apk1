package p173q1;

import android.content.ComponentName;
import androidx.appcompat.app.C0157r0;
import java.util.ArrayList;
import p101j7.C2782c;

public final class C3442r0 {

    public final AbstractC3403e0 f11643a;

    public final ArrayList f11644b = new ArrayList();

    public final boolean f11645c;

    public final C2782c f11646d;

    public C0157r0 f11647e;

    public C3442r0(AbstractC3403e0 abstractC3403e0, boolean z7) {
        this.f11643a = abstractC3403e0;
        this.f11646d = abstractC3403e0.f11451b;
        this.f11645c = z7;
    }

    public final String toString() {
        return "MediaRouter.RouteProviderInfo{ packageName=" + ((ComponentName) this.f11646d.f9501b).getPackageName() + " }";
    }
}

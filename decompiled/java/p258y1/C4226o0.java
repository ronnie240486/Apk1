package p258y1;

import android.view.ViewGroup;
import android.view.WindowId;

public final class C4226o0 {

    public final WindowId f14366a;

    public C4226o0(ViewGroup viewGroup) {
        this.f14366a = viewGroup.getWindowId();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C4226o0) && ((C4226o0) obj).f14366a.equals(this.f14366a);
    }

    public final int hashCode() {
        return this.f14366a.hashCode();
    }
}

package p124l6;

import com.google.android.material.bottomappbar.C1760b;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public final class C2983i {

    public final C1760b f10227a;

    public final FloatingActionButton f10228b;

    public C2983i(FloatingActionButton floatingActionButton, C1760b c1760b) {
        this.f10228b = floatingActionButton;
        this.f10227a = c1760b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C2983i) && ((C2983i) obj).f10227a.equals(this.f10227a);
    }

    public final int hashCode() {
        return this.f10227a.hashCode();
    }
}

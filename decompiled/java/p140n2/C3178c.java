package p140n2;

import android.content.Context;
import android.util.DisplayMetrics;
import p025c2.C1388i;
import p103j9.AbstractC2796i;

public final class C3178c implements InterfaceC3184i {

    public final Context f10669a;

    public C3178c(Context context) {
        this.f10669a = context;
    }

    @Override
    public final Object mo6380a(C1388i c1388i) {
        DisplayMetrics displayMetrics = this.f10669a.getResources().getDisplayMetrics();
        C3176a c3176a = new C3176a(Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels));
        return new C3183h(c3176a, c3176a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C3178c) {
            if (AbstractC2796i.m5780a(this.f10669a, ((C3178c) obj).f10669a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f10669a.hashCode();
    }
}

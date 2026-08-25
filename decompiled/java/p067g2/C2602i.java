package p067g2;

import android.net.Uri;
import p103j9.AbstractC2796i;
import p130m2.C3065m;
import p243w8.C4067i;

public final class C2602i implements InterfaceC2599f {

    public final C4067i f9056a;

    public final C4067i f9057b;

    public final boolean f9058c;

    public C2602i(C4067i c4067i, C4067i c4067i2, boolean z7) {
        this.f9056a = c4067i;
        this.f9057b = c4067i2;
        this.f9058c = z7;
    }

    @Override
    public final InterfaceC2600g mo5614a(Object obj, C3065m c3065m) {
        Uri uri = (Uri) obj;
        if (AbstractC2796i.m5780a(uri.getScheme(), "http") || AbstractC2796i.m5780a(uri.getScheme(), "https")) {
            return new C2605l(uri.toString(), c3065m, this.f9056a, this.f9057b, this.f9058c);
        }
        return null;
    }
}

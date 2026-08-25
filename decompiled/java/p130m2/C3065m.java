package p130m2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.os.Build;
import okhttp3.Headers;
import p103j9.AbstractC2796i;
import p140n2.C3183h;
import p140n2.EnumC3182g;

public final class C3065m {

    public final Context f10496a;

    public final Bitmap.Config f10497b;

    public final ColorSpace f10498c;

    public final C3183h f10499d;

    public final EnumC3182g f10500e;

    public final boolean f10501f;

    public final boolean f10502g;

    public final boolean f10503h;

    public final String f10504i;

    public final Headers f10505j;

    public final C3070r f10506k;

    public final C3067o f10507l;

    public final EnumC3054b f10508m;

    public final EnumC3054b f10509n;

    public final EnumC3054b f10510o;

    public C3065m(Context context, Bitmap.Config config, ColorSpace colorSpace, C3183h c3183h, EnumC3182g enumC3182g, boolean z7, boolean z10, boolean z11, String str, Headers headers, C3070r c3070r, C3067o c3067o, EnumC3054b enumC3054b, EnumC3054b enumC3054b2, EnumC3054b enumC3054b3) {
        this.f10496a = context;
        this.f10497b = config;
        this.f10498c = colorSpace;
        this.f10499d = c3183h;
        this.f10500e = enumC3182g;
        this.f10501f = z7;
        this.f10502g = z10;
        this.f10503h = z11;
        this.f10504i = str;
        this.f10505j = headers;
        this.f10506k = c3070r;
        this.f10507l = c3067o;
        this.f10508m = enumC3054b;
        this.f10509n = enumC3054b2;
        this.f10510o = enumC3054b3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C3065m) {
            C3065m c3065m = (C3065m) obj;
            if (AbstractC2796i.m5780a(this.f10496a, c3065m.f10496a) && this.f10497b == c3065m.f10497b && ((Build.VERSION.SDK_INT < 26 || AbstractC2796i.m5780a(this.f10498c, c3065m.f10498c)) && AbstractC2796i.m5780a(this.f10499d, c3065m.f10499d) && this.f10500e == c3065m.f10500e && this.f10501f == c3065m.f10501f && this.f10502g == c3065m.f10502g && this.f10503h == c3065m.f10503h && AbstractC2796i.m5780a(this.f10504i, c3065m.f10504i) && AbstractC2796i.m5780a(this.f10505j, c3065m.f10505j) && AbstractC2796i.m5780a(this.f10506k, c3065m.f10506k) && AbstractC2796i.m5780a(this.f10507l, c3065m.f10507l) && this.f10508m == c3065m.f10508m && this.f10509n == c3065m.f10509n && this.f10510o == c3065m.f10510o)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f10497b.hashCode() + (this.f10496a.hashCode() * 31)) * 31;
        ColorSpace colorSpace = this.f10498c;
        int iHashCode2 = (((((((this.f10500e.hashCode() + ((this.f10499d.hashCode() + ((iHashCode + (colorSpace != null ? colorSpace.hashCode() : 0)) * 31)) * 31)) * 31) + (this.f10501f ? 1231 : 1237)) * 31) + (this.f10502g ? 1231 : 1237)) * 31) + (this.f10503h ? 1231 : 1237)) * 31;
        String str = this.f10504i;
        return this.f10510o.hashCode() + ((this.f10509n.hashCode() + ((this.f10508m.hashCode() + ((this.f10507l.f10513a.hashCode() + ((this.f10506k.f10522a.hashCode() + ((this.f10505j.hashCode() + ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }
}

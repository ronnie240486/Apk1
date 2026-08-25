package p130m2;

import android.graphics.drawable.Drawable;
import coil.memory.MemoryCache$Key;
import p036d2.EnumC2137f;
import p103j9.AbstractC2796i;

public final class C3069q extends AbstractC3062j {

    public final Drawable f10514a;

    public final C3061i f10515b;

    public final EnumC2137f f10516c;

    public final MemoryCache$Key f10517d;

    public final String f10518e;

    public final boolean f10519f;

    public final boolean f10520g;

    public C3069q(Drawable drawable, C3061i c3061i, EnumC2137f enumC2137f, MemoryCache$Key memoryCache$Key, String str, boolean z7, boolean z10) {
        this.f10514a = drawable;
        this.f10515b = c3061i;
        this.f10516c = enumC2137f;
        this.f10517d = memoryCache$Key;
        this.f10518e = str;
        this.f10519f = z7;
        this.f10520g = z10;
    }

    @Override
    public final Drawable mo6107a() {
        return this.f10514a;
    }

    @Override
    public final C3061i mo6108b() {
        return this.f10515b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C3069q) {
            C3069q c3069q = (C3069q) obj;
            if (AbstractC2796i.m5780a(this.f10514a, c3069q.f10514a)) {
                if (AbstractC2796i.m5780a(this.f10515b, c3069q.f10515b) && this.f10516c == c3069q.f10516c && AbstractC2796i.m5780a(this.f10517d, c3069q.f10517d) && AbstractC2796i.m5780a(this.f10518e, c3069q.f10518e) && this.f10519f == c3069q.f10519f && this.f10520g == c3069q.f10520g) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f10516c.hashCode() + ((this.f10515b.hashCode() + (this.f10514a.hashCode() * 31)) * 31)) * 31;
        MemoryCache$Key memoryCache$Key = this.f10517d;
        int iHashCode2 = (iHashCode + (memoryCache$Key != null ? memoryCache$Key.hashCode() : 0)) * 31;
        String str = this.f10518e;
        return ((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + (this.f10519f ? 1231 : 1237)) * 31) + (this.f10520g ? 1231 : 1237);
    }
}

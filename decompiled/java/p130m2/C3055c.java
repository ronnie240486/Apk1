package p130m2;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import p103j9.AbstractC2796i;
import p140n2.EnumC3179d;
import p174q2.C3463b;
import p174q2.InterfaceC3465d;
import p185r2.AbstractC3587f;
import p213t9.AbstractC3819b0;
import p213t9.AbstractC3855p;
import p224u9.C3938c;
import p254x9.AbstractC4172n;
import p275z9.C4362d;
import p275z9.ExecutorC4361c;

public final class C3055c {

    public final AbstractC3855p f10419a;

    public final AbstractC3855p f10420b;

    public final AbstractC3855p f10421c;

    public final AbstractC3855p f10422d;

    public final InterfaceC3465d f10423e;

    public final EnumC3179d f10424f;

    public final Bitmap.Config f10425g;

    public final boolean f10426h;

    public final boolean f10427i;

    public final Drawable f10428j;

    public final Drawable f10429k;

    public final Drawable f10430l;

    public final EnumC3054b f10431m;

    public final EnumC3054b f10432n;

    public final EnumC3054b f10433o;

    public C3055c() {
        C4362d c4362d = AbstractC3819b0.f12901a;
        C3938c c3938c = AbstractC4172n.f14112a.f13237f;
        ExecutorC4361c executorC4361c = AbstractC3819b0.f12902b;
        C3463b c3463b = InterfaceC3465d.f11730a;
        EnumC3179d enumC3179d = EnumC3179d.f10670a;
        Bitmap.Config config = AbstractC3587f.f12066b;
        EnumC3054b enumC3054b = EnumC3054b.ENABLED;
        this.f10419a = c3938c;
        this.f10420b = executorC4361c;
        this.f10421c = executorC4361c;
        this.f10422d = executorC4361c;
        this.f10423e = c3463b;
        this.f10424f = enumC3179d;
        this.f10425g = config;
        this.f10426h = true;
        this.f10427i = false;
        this.f10428j = null;
        this.f10429k = null;
        this.f10430l = null;
        this.f10431m = enumC3054b;
        this.f10432n = enumC3054b;
        this.f10433o = enumC3054b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C3055c) {
            C3055c c3055c = (C3055c) obj;
            if (AbstractC2796i.m5780a(this.f10419a, c3055c.f10419a) && AbstractC2796i.m5780a(this.f10420b, c3055c.f10420b) && AbstractC2796i.m5780a(this.f10421c, c3055c.f10421c) && AbstractC2796i.m5780a(this.f10422d, c3055c.f10422d) && AbstractC2796i.m5780a(this.f10423e, c3055c.f10423e) && this.f10424f == c3055c.f10424f && this.f10425g == c3055c.f10425g && this.f10426h == c3055c.f10426h && this.f10427i == c3055c.f10427i && AbstractC2796i.m5780a(this.f10428j, c3055c.f10428j) && AbstractC2796i.m5780a(this.f10429k, c3055c.f10429k) && AbstractC2796i.m5780a(this.f10430l, c3055c.f10430l) && this.f10431m == c3055c.f10431m && this.f10432n == c3055c.f10432n && this.f10433o == c3055c.f10433o) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((this.f10425g.hashCode() + ((this.f10424f.hashCode() + ((this.f10423e.hashCode() + ((this.f10422d.hashCode() + ((this.f10421c.hashCode() + ((this.f10420b.hashCode() + (this.f10419a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + (this.f10426h ? 1231 : 1237)) * 31) + (this.f10427i ? 1231 : 1237)) * 31;
        Drawable drawable = this.f10428j;
        int iHashCode2 = (iHashCode + (drawable != null ? drawable.hashCode() : 0)) * 31;
        Drawable drawable2 = this.f10429k;
        int iHashCode3 = (iHashCode2 + (drawable2 != null ? drawable2.hashCode() : 0)) * 31;
        Drawable drawable3 = this.f10430l;
        return this.f10433o.hashCode() + ((this.f10432n.hashCode() + ((this.f10431m.hashCode() + ((iHashCode3 + (drawable3 != null ? drawable3.hashCode() : 0)) * 31)) * 31)) * 31);
    }
}

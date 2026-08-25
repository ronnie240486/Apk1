package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import p041d7.C2203g0;
import p049e3.C2390h;
import p049e3.C2391i;
import p049e3.C2396n;
import p049e3.C2403u;
import p068g3.C2608b;
import p109k3.C2888t;
import p116ka.C2921h;
import p141n3.AbstractC3187a;
import p141n3.C3188b;
import p141n3.C3191e;
import p141n3.C3192f;
import p141n3.C3193g;
import p141n3.InterfaceC3189c;
import p141n3.InterfaceC3190d;
import p151o3.C3247a;
import p151o3.InterfaceC3254h;
import p160p.C3341e;
import p186r3.AbstractC3602f;
import p186r3.AbstractC3610n;

public final class C1474l extends AbstractC3187a {

    public C1474l f4458A;

    public C1474l f4459B;

    public boolean f4460C = true;

    public boolean f4461D;

    public boolean f4462E;

    public final Context f4463t;

    public final ComponentCallbacks2C1491o f4464u;

    public final Class f4465v;

    public final C1468f f4466w;

    public AbstractC1492p f4467x;

    public Object f4468y;

    public ArrayList f4469z;

    static {
    }

    public C1474l(ComponentCallbacks2C1464b componentCallbacks2C1464b, ComponentCallbacks2C1491o componentCallbacks2C1491o, Class cls, Context context) {
        C3191e c3191e;
        this.f4464u = componentCallbacks2C1491o;
        this.f4465v = cls;
        this.f4463t = context;
        C3341e c3341e = componentCallbacks2C1491o.f4502a.f4408c.f4436f;
        AbstractC1492p abstractC1492p = (AbstractC1492p) c3341e.get(cls);
        if (abstractC1492p == null) {
            for (Map.Entry entry : (C2203g0) c3341e.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    abstractC1492p = (AbstractC1492p) entry.getValue();
                }
            }
        }
        this.f4467x = abstractC1492p == null ? C1468f.f4430k : abstractC1492p;
        this.f4466w = componentCallbacks2C1464b.f4408c;
        Iterator it = componentCallbacks2C1491o.f4510i.iterator();
        while (it.hasNext()) {
            m3539w((C2921h) it.next());
        }
        synchronized (componentCallbacks2C1491o) {
            c3191e = componentCallbacks2C1491o.f4511j;
        }
        mo3537a(c3191e);
    }

    public final void m3533A(ImageView imageView) {
        AbstractC3187a abstractC3187aM6387i;
        InterfaceC3254h c3247a;
        AbstractC3610n.m7233a();
        AbstractC3602f.m7224b(imageView);
        if (!AbstractC3187a.m6381h(this.f10687a, 2048) && imageView.getScaleType() != null) {
            switch (AbstractC1473k.f4456a[imageView.getScaleType().ordinal()]) {
                case 1:
                    abstractC3187aM6387i = clone().m6387i(C2396n.f8359d, new C2390h());
                    break;
                case 2:
                    abstractC3187aM6387i = clone().m6387i(C2396n.f8358c, new C2391i());
                    abstractC3187aM6387i.f10704r = true;
                    break;
                case 3:
                case 4:
                case 5:
                    abstractC3187aM6387i = clone().m6387i(C2396n.f8357b, new C2403u());
                    abstractC3187aM6387i.f10704r = true;
                    break;
                case 6:
                    abstractC3187aM6387i = clone().m6387i(C2396n.f8358c, new C2391i());
                    abstractC3187aM6387i.f10704r = true;
                    break;
                default:
                    abstractC3187aM6387i = this;
                    break;
            }
        } else {
            abstractC3187aM6387i = this;
        }
        this.f4466w.f4433c.getClass();
        Class cls = this.f4465v;
        if (Bitmap.class.equals(cls)) {
            c3247a = new C3247a(imageView, 0);
        } else {
            if (!Drawable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
            }
            c3247a = new C3247a(imageView, 1);
        }
        m3534B(c3247a, abstractC3187aM6387i);
    }

    public final void m3534B(InterfaceC3254h interfaceC3254h, AbstractC3187a abstractC3187a) {
        AbstractC3602f.m7224b(interfaceC3254h);
        if (!this.f4461D) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        InterfaceC3189c interfaceC3189cM3541y = m3541y(new Object(), interfaceC3254h, null, this.f4467x, abstractC3187a.f10689c, abstractC3187a.f10695i, abstractC3187a.f10694h, abstractC3187a);
        InterfaceC3189c request = interfaceC3254h.getRequest();
        if (interfaceC3189cM3541y.mo6404d(request) && (abstractC3187a.f10693g || !request.mo6409i())) {
            AbstractC3602f.m7225c(request, "Argument must not be null");
            if (request.isRunning()) {
                return;
            }
            request.mo6405e();
            return;
        }
        this.f4464u.m3569l(interfaceC3254h);
        interfaceC3254h.mo3557a(interfaceC3189cM3541y);
        ComponentCallbacks2C1491o componentCallbacks2C1491o = this.f4464u;
        synchronized (componentCallbacks2C1491o) {
            componentCallbacks2C1491o.f4507f.f9834a.add(interfaceC3254h);
            C2888t c2888t = componentCallbacks2C1491o.f4505d;
            ((Set) c2888t.f9832c).add(interfaceC3189cM3541y);
            if (c2888t.f9831b) {
                interfaceC3189cM3541y.clear();
                if (Log.isLoggable("RequestTracker", 2)) {
                    Log.v("RequestTracker", "Paused, delaying request");
                }
                ((HashSet) c2888t.f9833d).add(interfaceC3189cM3541y);
            } else {
                interfaceC3189cM3541y.mo6405e();
            }
        }
    }

    public final C1474l m3535C(Object obj) {
        if (this.f10703q) {
            return clone().m3535C(obj);
        }
        this.f4468y = obj;
        this.f4461D = true;
        m6392n();
        return this;
    }

    public final C1474l m3536D(C2608b c2608b) {
        if (this.f10703q) {
            return clone().m3536D(c2608b);
        }
        this.f4467x = c2608b;
        this.f4460C = false;
        m6392n();
        return this;
    }

    @Override
    public final boolean equals(Object obj) {
        if (!(obj instanceof C1474l)) {
            return false;
        }
        C1474l c1474l = (C1474l) obj;
        if (super.equals(c1474l)) {
            return Objects.equals(this.f4465v, c1474l.f4465v) && this.f4467x.equals(c1474l.f4467x) && Objects.equals(this.f4468y, c1474l.f4468y) && Objects.equals(this.f4469z, c1474l.f4469z) && Objects.equals(this.f4458A, c1474l.f4458A) && Objects.equals(this.f4459B, c1474l.f4459B) && this.f4460C == c1474l.f4460C && this.f4461D == c1474l.f4461D;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return AbstractC3610n.m7239g(this.f4461D ? 1 : 0, AbstractC3610n.m7239g(this.f4460C ? 1 : 0, AbstractC3610n.m7240h(AbstractC3610n.m7240h(AbstractC3610n.m7240h(AbstractC3610n.m7240h(AbstractC3610n.m7240h(AbstractC3610n.m7240h(AbstractC3610n.m7240h(super.hashCode(), this.f4465v), this.f4467x), this.f4468y), this.f4469z), this.f4458A), this.f4459B), null)));
    }

    public final C1474l m3539w(C2921h c2921h) {
        if (this.f10703q) {
            return clone().m3539w(c2921h);
        }
        if (c2921h != null) {
            if (this.f4469z == null) {
                this.f4469z = new ArrayList();
            }
            this.f4469z.add(c2921h);
        }
        m6392n();
        return this;
    }

    @Override
    public final C1474l mo3537a(AbstractC3187a abstractC3187a) {
        AbstractC3602f.m7224b(abstractC3187a);
        return (C1474l) super.mo3537a(abstractC3187a);
    }

    public final InterfaceC3189c m3541y(Object obj, InterfaceC3254h interfaceC3254h, InterfaceC3190d interfaceC3190d, AbstractC1492p abstractC1492p, EnumC1469g enumC1469g, int i6, int i10, AbstractC3187a abstractC3187a) {
        InterfaceC3190d interfaceC3190d2;
        InterfaceC3190d c3188b;
        InterfaceC3189c c3192f;
        int i11;
        int i12;
        EnumC1469g enumC1469g2;
        int i13;
        int i14;
        if (this.f4459B != null) {
            c3188b = new C3188b(obj, interfaceC3190d);
            interfaceC3190d2 = c3188b;
        } else {
            interfaceC3190d2 = null;
            c3188b = interfaceC3190d;
        }
        C1474l c1474l = this.f4458A;
        if (c1474l == null) {
            Object obj2 = this.f4468y;
            ArrayList arrayList = this.f4469z;
            C1468f c1468f = this.f4466w;
            c3192f = new C3192f(this.f4463t, c1468f, obj, obj2, this.f4465v, abstractC3187a, i6, i10, enumC1469g, interfaceC3254h, arrayList, c3188b, c1468f.f4437g, abstractC1492p.f4512a);
        } else {
            if (this.f4462E) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            AbstractC1492p abstractC1492p2 = c1474l.f4460C ? abstractC1492p : c1474l.f4467x;
            if (AbstractC3187a.m6381h(c1474l.f10687a, 8)) {
                enumC1469g2 = this.f4458A.f10689c;
            } else {
                int iOrdinal = enumC1469g.ordinal();
                if (iOrdinal == 0 || iOrdinal == 1) {
                    enumC1469g2 = EnumC1469g.f4441a;
                } else if (iOrdinal == 2) {
                    enumC1469g2 = EnumC1469g.f4442b;
                } else {
                    if (iOrdinal != 3) {
                        throw new IllegalArgumentException("unknown priority: " + this.f10689c);
                    }
                    enumC1469g2 = EnumC1469g.f4443c;
                }
            }
            EnumC1469g enumC1469g3 = enumC1469g2;
            C1474l c1474l2 = this.f4458A;
            int i15 = c1474l2.f10695i;
            int i16 = c1474l2.f10694h;
            if (AbstractC3610n.m7241i(i6, i10)) {
                C1474l c1474l3 = this.f4458A;
                if (AbstractC3610n.m7241i(c1474l3.f10695i, c1474l3.f10694h)) {
                    i13 = i16;
                    i14 = i15;
                } else {
                    i14 = abstractC3187a.f10695i;
                    i13 = abstractC3187a.f10694h;
                }
            } else {
                i13 = i16;
                i14 = i15;
            }
            C3193g c3193g = new C3193g(obj, c3188b);
            Object obj3 = this.f4468y;
            ArrayList arrayList2 = this.f4469z;
            C1468f c1468f2 = this.f4466w;
            C3192f c3192f2 = new C3192f(this.f4463t, c1468f2, obj, obj3, this.f4465v, abstractC3187a, i6, i10, enumC1469g, interfaceC3254h, arrayList2, c3193g, c1468f2.f4437g, abstractC1492p.f4512a);
            this.f4462E = true;
            C1474l c1474l4 = this.f4458A;
            InterfaceC3189c interfaceC3189cM3541y = c1474l4.m3541y(obj, interfaceC3254h, c3193g, abstractC1492p2, enumC1469g3, i14, i13, c1474l4);
            this.f4462E = false;
            c3193g.f10743c = c3192f2;
            c3193g.f10744d = interfaceC3189cM3541y;
            c3192f = c3193g;
        }
        C3188b c3188b2 = interfaceC3190d2;
        if (c3188b2 == 0) {
            return c3192f;
        }
        C1474l c1474l5 = this.f4459B;
        int i17 = c1474l5.f10695i;
        int i18 = c1474l5.f10694h;
        if (AbstractC3610n.m7241i(i6, i10)) {
            C1474l c1474l6 = this.f4459B;
            if (AbstractC3610n.m7241i(c1474l6.f10695i, c1474l6.f10694h)) {
                i11 = i18;
                i12 = i17;
            } else {
                i12 = abstractC3187a.f10695i;
                i11 = abstractC3187a.f10694h;
            }
        } else {
            i11 = i18;
            i12 = i17;
        }
        C1474l c1474l7 = this.f4459B;
        InterfaceC3189c interfaceC3189cM3541y2 = c1474l7.m3541y(obj, interfaceC3254h, c3188b2, c1474l7.f4467x, c1474l7.f10689c, i12, i11, c1474l7);
        c3188b2.f10708c = c3192f;
        c3188b2.f10709d = interfaceC3189cM3541y2;
        return c3188b2;
    }

    @Override
    public final C1474l clone() {
        C1474l c1474l = (C1474l) super.clone();
        c1474l.f4467x = c1474l.f4467x.clone();
        if (c1474l.f4469z != null) {
            c1474l.f4469z = new ArrayList(c1474l.f4469z);
        }
        C1474l c1474l2 = c1474l.f4458A;
        if (c1474l2 != null) {
            c1474l.f4458A = c1474l2.clone();
        }
        C1474l c1474l3 = c1474l.f4459B;
        if (c1474l3 != null) {
            c1474l.f4459B = c1474l3.clone();
        }
        return c1474l;
    }
}

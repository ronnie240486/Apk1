package p141n3;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import com.bumptech.glide.EnumC1469g;
import p049e3.AbstractC2385e;
import p049e3.C2396n;
import p049e3.C2401s;
import p065g0.C2587g;
import p068g3.C2610d;
import p086i3.C2688d;
import p086i3.C2689e;
import p175q3.C3469c;
import p186r3.AbstractC3602f;
import p186r3.AbstractC3610n;
import p186r3.C3598b;
import p228v2.C3980g;
import p228v2.C3981h;
import p228v2.InterfaceC3978e;
import p228v2.InterfaceC3985l;
import p247x2.C4089k;

public abstract class AbstractC3187a implements Cloneable {

    public int f10687a;

    public Drawable f10690d;

    public int f10691e;

    public C2587g f10692f;

    public boolean f10697k;

    public boolean f10701o;

    public Resources.Theme f10702p;

    public boolean f10703q;

    public boolean f10705s;

    public C4089k f10688b = C4089k.f13831d;

    public EnumC1469g f10689c = EnumC1469g.f4443c;

    public boolean f10693g = true;

    public int f10694h = -1;

    public int f10695i = -1;

    public InterfaceC3978e f10696j = C3469c.f11734b;

    public C3981h f10698l = new C3981h();

    public C3598b f10699m = new C3598b(0);

    public Class f10700n = Object.class;

    public boolean f10704r = true;

    public static boolean m6381h(int i6, int i10) {
        return (i6 & i10) != 0;
    }

    public AbstractC3187a mo3537a(AbstractC3187a abstractC3187a) {
        if (this.f10703q) {
            return clone().mo3537a(abstractC3187a);
        }
        int i6 = abstractC3187a.f10687a;
        if (m6381h(abstractC3187a.f10687a, ProgressiveMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES)) {
            this.f10705s = abstractC3187a.f10705s;
        }
        if (m6381h(abstractC3187a.f10687a, 4)) {
            this.f10688b = abstractC3187a.f10688b;
        }
        if (m6381h(abstractC3187a.f10687a, 8)) {
            this.f10689c = abstractC3187a.f10689c;
        }
        if (m6381h(abstractC3187a.f10687a, 16)) {
            this.f10690d = abstractC3187a.f10690d;
            this.f10691e = 0;
            this.f10687a &= -33;
        }
        if (m6381h(abstractC3187a.f10687a, 32)) {
            this.f10691e = abstractC3187a.f10691e;
            this.f10690d = null;
            this.f10687a &= -17;
        }
        if (m6381h(abstractC3187a.f10687a, 64)) {
            this.f10692f = abstractC3187a.f10692f;
            this.f10687a &= -129;
        }
        if (m6381h(abstractC3187a.f10687a, 128)) {
            this.f10692f = null;
            this.f10687a &= -65;
        }
        if (m6381h(abstractC3187a.f10687a, 256)) {
            this.f10693g = abstractC3187a.f10693g;
        }
        if (m6381h(abstractC3187a.f10687a, 512)) {
            this.f10695i = abstractC3187a.f10695i;
            this.f10694h = abstractC3187a.f10694h;
        }
        if (m6381h(abstractC3187a.f10687a, 1024)) {
            this.f10696j = abstractC3187a.f10696j;
        }
        if (m6381h(abstractC3187a.f10687a, 4096)) {
            this.f10700n = abstractC3187a.f10700n;
        }
        if (m6381h(abstractC3187a.f10687a, 8192)) {
            this.f10687a &= -16385;
        }
        if (m6381h(abstractC3187a.f10687a, 16384)) {
            this.f10687a &= -8193;
        }
        if (m6381h(abstractC3187a.f10687a, 32768)) {
            this.f10702p = abstractC3187a.f10702p;
        }
        if (m6381h(abstractC3187a.f10687a, 131072)) {
            this.f10697k = abstractC3187a.f10697k;
        }
        if (m6381h(abstractC3187a.f10687a, 2048)) {
            this.f10699m.putAll(abstractC3187a.f10699m);
            this.f10704r = abstractC3187a.f10704r;
        }
        this.f10687a |= abstractC3187a.f10687a;
        this.f10698l.f13515b.mo6813g(abstractC3187a.f10698l.f13515b);
        m6392n();
        return this;
    }

    @Override
    public AbstractC3187a clone() {
        try {
            AbstractC3187a abstractC3187a = (AbstractC3187a) super.clone();
            C3981h c3981h = new C3981h();
            abstractC3187a.f10698l = c3981h;
            c3981h.f13515b.mo6813g(this.f10698l.f13515b);
            C3598b c3598b = new C3598b(0);
            abstractC3187a.f10699m = c3598b;
            c3598b.putAll(this.f10699m);
            abstractC3187a.f10701o = false;
            abstractC3187a.f10703q = false;
            return abstractC3187a;
        } catch (CloneNotSupportedException e5) {
            throw new RuntimeException(e5);
        }
    }

    public final AbstractC3187a m6382c(Class cls) {
        if (this.f10703q) {
            return clone().m6382c(cls);
        }
        this.f10700n = cls;
        this.f10687a |= 4096;
        m6392n();
        return this;
    }

    public final AbstractC3187a m6383d(C4089k c4089k) {
        if (this.f10703q) {
            return clone().m6383d(c4089k);
        }
        this.f10688b = c4089k;
        this.f10687a |= 4;
        m6392n();
        return this;
    }

    public final AbstractC3187a m6384e(int i6) {
        if (this.f10703q) {
            return clone().m6384e(i6);
        }
        this.f10691e = i6;
        int i10 = this.f10687a | 32;
        this.f10690d = null;
        this.f10687a = i10 & (-17);
        m6392n();
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof AbstractC3187a) {
            return m6386g((AbstractC3187a) obj);
        }
        return false;
    }

    public final AbstractC3187a m6385f(Drawable drawable) {
        if (this.f10703q) {
            return clone().m6385f(drawable);
        }
        this.f10690d = drawable;
        int i6 = this.f10687a | 16;
        this.f10691e = 0;
        this.f10687a = i6 & (-33);
        m6392n();
        return this;
    }

    public final boolean m6386g(AbstractC3187a abstractC3187a) {
        abstractC3187a.getClass();
        return Float.compare(1.0f, 1.0f) == 0 && this.f10691e == abstractC3187a.f10691e && AbstractC3610n.m7234b(this.f10690d, abstractC3187a.f10690d) && AbstractC3610n.m7234b(this.f10692f, abstractC3187a.f10692f) && AbstractC3610n.m7234b(null, null) && this.f10693g == abstractC3187a.f10693g && this.f10694h == abstractC3187a.f10694h && this.f10695i == abstractC3187a.f10695i && this.f10697k == abstractC3187a.f10697k && this.f10688b.equals(abstractC3187a.f10688b) && this.f10689c == abstractC3187a.f10689c && this.f10698l.equals(abstractC3187a.f10698l) && this.f10699m.equals(abstractC3187a.f10699m) && this.f10700n.equals(abstractC3187a.f10700n) && this.f10696j.equals(abstractC3187a.f10696j) && AbstractC3610n.m7234b(this.f10702p, abstractC3187a.f10702p);
    }

    public int hashCode() {
        char[] cArr = AbstractC3610n.f12112a;
        return AbstractC3610n.m7240h(AbstractC3610n.m7240h(AbstractC3610n.m7240h(AbstractC3610n.m7240h(AbstractC3610n.m7240h(AbstractC3610n.m7240h(AbstractC3610n.m7240h(AbstractC3610n.m7239g(0, AbstractC3610n.m7239g(0, AbstractC3610n.m7239g(1, AbstractC3610n.m7239g(this.f10697k ? 1 : 0, AbstractC3610n.m7239g(this.f10695i, AbstractC3610n.m7239g(this.f10694h, AbstractC3610n.m7239g(this.f10693g ? 1 : 0, AbstractC3610n.m7240h(AbstractC3610n.m7239g(0, AbstractC3610n.m7240h(AbstractC3610n.m7239g(0, AbstractC3610n.m7240h(AbstractC3610n.m7239g(this.f10691e, AbstractC3610n.m7239g(Float.floatToIntBits(1.0f), 17)), this.f10690d)), this.f10692f)), null)))))))), this.f10688b), this.f10689c), this.f10698l), this.f10699m), this.f10700n), this.f10696j), this.f10702p);
    }

    public final AbstractC3187a m6387i(C2396n c2396n, AbstractC2385e abstractC2385e) {
        if (this.f10703q) {
            return clone().m6387i(c2396n, abstractC2385e);
        }
        m6393o(C2396n.f8362g, c2396n);
        return m6399u(abstractC2385e, false);
    }

    public final AbstractC3187a m6388j(int i6, int i10) {
        if (this.f10703q) {
            return clone().m6388j(i6, i10);
        }
        this.f10695i = i6;
        this.f10694h = i10;
        this.f10687a |= 512;
        m6392n();
        return this;
    }

    public final AbstractC3187a m6389k(C2587g c2587g) {
        if (this.f10703q) {
            return clone().m6389k(c2587g);
        }
        this.f10692f = c2587g;
        this.f10687a = (this.f10687a | 64) & (-129);
        m6392n();
        return this;
    }

    public final AbstractC3187a m6390l() {
        EnumC1469g enumC1469g = EnumC1469g.f4444d;
        if (this.f10703q) {
            return clone().m6390l();
        }
        this.f10689c = enumC1469g;
        this.f10687a |= 8;
        m6392n();
        return this;
    }

    public final AbstractC3187a m6391m(C3980g c3980g) {
        if (this.f10703q) {
            return clone().m6391m(c3980g);
        }
        this.f10698l.f13515b.remove(c3980g);
        m6392n();
        return this;
    }

    public final void m6392n() {
        if (this.f10701o) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
    }

    public final AbstractC3187a m6393o(C3980g c3980g, Object obj) {
        if (this.f10703q) {
            return clone().m6393o(c3980g, obj);
        }
        AbstractC3602f.m7224b(c3980g);
        AbstractC3602f.m7224b(obj);
        this.f10698l.f13515b.put(c3980g, obj);
        m6392n();
        return this;
    }

    public final AbstractC3187a m6394p(InterfaceC3978e interfaceC3978e) {
        if (this.f10703q) {
            return clone().m6394p(interfaceC3978e);
        }
        this.f10696j = interfaceC3978e;
        this.f10687a |= 1024;
        m6392n();
        return this;
    }

    public final AbstractC3187a m6395q(boolean z7) {
        if (this.f10703q) {
            return clone().m6395q(true);
        }
        this.f10693g = !z7;
        this.f10687a |= 256;
        m6392n();
        return this;
    }

    public final AbstractC3187a m6396r(Resources.Theme theme) {
        if (this.f10703q) {
            return clone().m6396r(theme);
        }
        this.f10702p = theme;
        if (theme != null) {
            this.f10687a |= 32768;
            return m6393o(C2610d.f9082b, theme);
        }
        this.f10687a &= -32769;
        return m6391m(C2610d.f9082b);
    }

    public final AbstractC3187a m6397s(C2396n c2396n, AbstractC2385e abstractC2385e) {
        if (this.f10703q) {
            return clone().m6397s(c2396n, abstractC2385e);
        }
        m6393o(C2396n.f8362g, c2396n);
        return m6399u(abstractC2385e, true);
    }

    public final AbstractC3187a m6398t(Class cls, InterfaceC3985l interfaceC3985l, boolean z7) {
        if (this.f10703q) {
            return clone().m6398t(cls, interfaceC3985l, z7);
        }
        AbstractC3602f.m7224b(interfaceC3985l);
        this.f10699m.put(cls, interfaceC3985l);
        int i6 = this.f10687a;
        this.f10687a = 67584 | i6;
        this.f10704r = false;
        if (z7) {
            this.f10687a = i6 | 198656;
            this.f10697k = true;
        }
        m6392n();
        return this;
    }

    public final AbstractC3187a m6399u(InterfaceC3985l interfaceC3985l, boolean z7) {
        if (this.f10703q) {
            return clone().m6399u(interfaceC3985l, z7);
        }
        C2401s c2401s = new C2401s(interfaceC3985l, z7);
        m6398t(Bitmap.class, interfaceC3985l, z7);
        m6398t(Drawable.class, c2401s, z7);
        m6398t(BitmapDrawable.class, c2401s, z7);
        m6398t(C2688d.class, new C2689e(interfaceC3985l), z7);
        m6392n();
        return this;
    }

    public final AbstractC3187a m6400v() {
        if (this.f10703q) {
            return clone().m6400v();
        }
        this.f10705s = true;
        this.f10687a |= ProgressiveMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES;
        m6392n();
        return this;
    }
}

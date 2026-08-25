package p008a9;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bumptech.glide.AbstractC1465c;
import com.lzy.okgo.cache.CacheEntity;
import java.io.Serializable;
import p091i9.InterfaceC2728p;
import p103j9.AbstractC2796i;

public final class C0073c implements InterfaceC0079i, Serializable {

    public final InterfaceC0079i f203a;

    public final InterfaceC0077g f204b;

    public C0073c(InterfaceC0077g interfaceC0077g, InterfaceC0079i interfaceC0079i) {
        AbstractC2796i.m5785f(interfaceC0079i, TtmlNode.LEFT);
        this.f203a = interfaceC0079i;
        this.f204b = interfaceC0077g;
    }

    @Override
    public final Object mo250a(Object obj, InterfaceC2728p interfaceC2728p) {
        return interfaceC2728p.invoke(this.f203a.mo250a(obj, interfaceC2728p), this.f204b);
    }

    @Override
    public final InterfaceC0079i mo251c(InterfaceC0078h interfaceC0078h) {
        AbstractC2796i.m5785f(interfaceC0078h, CacheEntity.KEY);
        InterfaceC0077g interfaceC0077g = this.f204b;
        InterfaceC0077g interfaceC0077gMo252e = interfaceC0077g.mo252e(interfaceC0078h);
        InterfaceC0079i interfaceC0079i = this.f203a;
        if (interfaceC0077gMo252e != null) {
            return interfaceC0079i;
        }
        InterfaceC0079i interfaceC0079iMo251c = interfaceC0079i.mo251c(interfaceC0078h);
        if (interfaceC0079iMo251c == interfaceC0079i) {
            return this;
        }
        return interfaceC0079iMo251c == C0080j.f206a ? interfaceC0077g : new C0073c(interfaceC0077g, interfaceC0079iMo251c);
    }

    @Override
    public final InterfaceC0077g mo252e(InterfaceC0078h interfaceC0078h) {
        AbstractC2796i.m5785f(interfaceC0078h, CacheEntity.KEY);
        C0073c c0073c = this;
        while (true) {
            InterfaceC0077g interfaceC0077gMo252e = c0073c.f204b.mo252e(interfaceC0078h);
            if (interfaceC0077gMo252e != null) {
                return interfaceC0077gMo252e;
            }
            InterfaceC0079i interfaceC0079i = c0073c.f203a;
            if (!(interfaceC0079i instanceof C0073c)) {
                return interfaceC0079i.mo252e(interfaceC0078h);
            }
            c0073c = (C0073c) interfaceC0079i;
        }
    }

    public final boolean equals(Object obj) {
        boolean zM5780a;
        if (this != obj) {
            if (!(obj instanceof C0073c)) {
                return false;
            }
            C0073c c0073c = (C0073c) obj;
            c0073c.getClass();
            int i6 = 2;
            C0073c c0073c2 = c0073c;
            int i10 = 2;
            while (true) {
                InterfaceC0079i interfaceC0079i = c0073c2.f203a;
                c0073c2 = interfaceC0079i instanceof C0073c ? (C0073c) interfaceC0079i : null;
                if (c0073c2 == null) {
                    break;
                }
                i10++;
            }
            C0073c c0073c3 = this;
            while (true) {
                InterfaceC0079i interfaceC0079i2 = c0073c3.f203a;
                c0073c3 = interfaceC0079i2 instanceof C0073c ? (C0073c) interfaceC0079i2 : null;
                if (c0073c3 == null) {
                    break;
                }
                i6++;
            }
            if (i10 != i6) {
                return false;
            }
            C0073c c0073c4 = this;
            while (true) {
                InterfaceC0077g interfaceC0077g = c0073c4.f204b;
                if (!AbstractC2796i.m5780a(c0073c.mo252e(interfaceC0077g.getKey()), interfaceC0077g)) {
                    zM5780a = false;
                    break;
                }
                InterfaceC0079i interfaceC0079i3 = c0073c4.f203a;
                if (!(interfaceC0079i3 instanceof C0073c)) {
                    AbstractC2796i.m5783d(interfaceC0079i3, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                    InterfaceC0077g interfaceC0077g2 = (InterfaceC0077g) interfaceC0079i3;
                    zM5780a = AbstractC2796i.m5780a(c0073c.mo252e(interfaceC0077g2.getKey()), interfaceC0077g2);
                    break;
                }
                c0073c4 = (C0073c) interfaceC0079i3;
            }
            if (!zM5780a) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final InterfaceC0079i mo253f(InterfaceC0079i interfaceC0079i) {
        return AbstractC1465c.m3475j(this, interfaceC0079i);
    }

    public final int hashCode() {
        return this.f204b.hashCode() + this.f203a.hashCode();
    }

    public final String toString() {
        return "[" + ((String) mo250a("", new C0072b(0))) + ']';
    }
}

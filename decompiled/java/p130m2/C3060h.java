package p130m2;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.lifecycle.AbstractC0541p;
import androidx.lifecycle.InterfaceC0555w;
import java.util.LinkedHashMap;
import java.util.List;
import okhttp3.Headers;
import p140n2.C3178c;
import p140n2.C3180e;
import p140n2.C3181f;
import p140n2.C3183h;
import p140n2.EnumC3179d;
import p140n2.EnumC3182g;
import p140n2.InterfaceC3184i;
import p150o2.C3246a;
import p156o9.AbstractC3280d;
import p174q2.InterfaceC3465d;
import p185r2.AbstractC3585d;
import p185r2.AbstractC3586e;
import p185r2.AbstractC3587f;
import p213t9.AbstractC3855p;
import p253x8.AbstractC4158u;
import p253x8.C4155r;

public final class C3060h {

    public final Context f10443a;

    public C3055c f10444b;

    public Object f10445c;

    public C3246a f10446d;

    public List f10447e;

    public InterfaceC3465d f10448f;

    public final Headers.Builder f10449g;

    public final LinkedHashMap f10450h;

    public final boolean f10451i;

    public final boolean f10452j;

    public EnumC3054b f10453k;

    public EnumC3054b f10454l;

    public final C3066n f10455m;

    public Integer f10456n;

    public Drawable f10457o;

    public Integer f10458p;

    public Drawable f10459q;

    public EnumC3182g f10460r;

    public AbstractC0541p f10461s;

    public InterfaceC3184i f10462t;

    public EnumC3182g f10463u;

    public C3060h(Context context) {
        this.f10443a = context;
        this.f10444b = AbstractC3585d.f12063a;
        this.f10445c = null;
        this.f10446d = null;
        this.f10447e = C4155r.f14074a;
        this.f10448f = null;
        this.f10449g = null;
        this.f10450h = null;
        this.f10451i = true;
        this.f10452j = true;
        this.f10453k = null;
        this.f10454l = null;
        this.f10455m = null;
        this.f10456n = null;
        this.f10457o = null;
        this.f10458p = null;
        this.f10459q = null;
        this.f10460r = null;
        this.f10461s = null;
        this.f10462t = null;
        this.f10463u = null;
    }

    public final C3061i m6109a() {
        AbstractC3855p abstractC3855p;
        EnumC3182g enumC3182g;
        ImageView.ScaleType scaleType;
        Object obj = this.f10445c;
        if (obj == null) {
            obj = C3063k.f10494b;
        }
        Object obj2 = obj;
        C3246a c3246a = this.f10446d;
        C3055c c3055c = this.f10444b;
        Bitmap.Config config = c3055c.f10425g;
        EnumC3179d enumC3179d = c3055c.f10424f;
        List list = this.f10447e;
        InterfaceC3465d interfaceC3465d = this.f10448f;
        InterfaceC3465d interfaceC3465d2 = interfaceC3465d == null ? c3055c.f10423e : interfaceC3465d;
        Headers.Builder builder = this.f10449g;
        Headers headersBuild = builder != null ? builder.build() : null;
        if (headersBuild == null) {
            headersBuild = AbstractC3587f.f12067c;
        } else {
            Bitmap.Config[] configArr = AbstractC3587f.f12065a;
        }
        Headers headers = headersBuild;
        LinkedHashMap linkedHashMap = this.f10450h;
        C3070r c3070r = linkedHashMap != null ? new C3070r(AbstractC3280d.m6572K(linkedHashMap)) : null;
        C3070r c3070r2 = c3070r == null ? C3070r.f10521b : c3070r;
        C3055c c3055c2 = this.f10444b;
        boolean z7 = c3055c2.f10426h;
        boolean z10 = c3055c2.f10427i;
        EnumC3054b enumC3054b = this.f10453k;
        if (enumC3054b == null) {
            enumC3054b = c3055c2.f10431m;
        }
        EnumC3054b enumC3054b2 = enumC3054b;
        EnumC3054b enumC3054b3 = this.f10454l;
        if (enumC3054b3 == null) {
            enumC3054b3 = c3055c2.f10432n;
        }
        EnumC3054b enumC3054b4 = enumC3054b3;
        EnumC3054b enumC3054b5 = c3055c2.f10433o;
        AbstractC3855p abstractC3855p2 = c3055c2.f10419a;
        AbstractC3855p abstractC3855p3 = c3055c2.f10420b;
        AbstractC3855p abstractC3855p4 = c3055c2.f10421c;
        AbstractC3855p abstractC3855p5 = c3055c2.f10422d;
        AbstractC0541p abstractC0541pMo360f = this.f10461s;
        Context context = this.f10443a;
        if (abstractC0541pMo360f == null) {
            C3246a c3246a2 = this.f10446d;
            abstractC3855p = abstractC3855p3;
            Object context2 = c3246a2 instanceof C3246a ? c3246a2.f10870b.getContext() : context;
            while (true) {
                if (context2 instanceof InterfaceC0555w) {
                    abstractC0541pMo360f = ((InterfaceC0555w) context2).mo360f();
                    break;
                }
                if (!(context2 instanceof ContextWrapper)) {
                    abstractC0541pMo360f = null;
                    break;
                }
                context2 = ((ContextWrapper) context2).getBaseContext();
            }
            if (abstractC0541pMo360f == null) {
                abstractC0541pMo360f = C3059g.f10441b;
            }
        } else {
            abstractC3855p = abstractC3855p3;
        }
        AbstractC0541p abstractC0541p = abstractC0541pMo360f;
        InterfaceC3184i c3178c = this.f10462t;
        if (c3178c == null) {
            C3246a c3246a3 = this.f10446d;
            if (c3246a3 instanceof C3246a) {
                ImageView imageView = c3246a3.f10870b;
                if ((imageView instanceof ImageView) && ((scaleType = imageView.getScaleType()) == ImageView.ScaleType.CENTER || scaleType == ImageView.ScaleType.MATRIX)) {
                    C3183h c3183h = C3183h.f10677c;
                    c3178c = new C3180e();
                } else {
                    c3178c = new C3181f(imageView, true);
                }
            } else {
                c3178c = new C3178c(context);
            }
        }
        InterfaceC3184i interfaceC3184i = c3178c;
        EnumC3182g enumC3182g2 = this.f10460r;
        if (enumC3182g2 == null && (enumC3182g2 = this.f10463u) == null) {
            C3246a c3246a4 = this.f10446d;
            if (!(c3246a4 instanceof C3246a)) {
                c3246a4 = null;
            }
            ImageView imageView2 = c3246a4 != null ? c3246a4.f10870b : null;
            boolean z11 = imageView2 instanceof ImageView;
            EnumC3182g enumC3182g3 = EnumC3182g.f10675b;
            if (z11) {
                Bitmap.Config[] configArr2 = AbstractC3587f.f12065a;
                ImageView.ScaleType scaleType2 = imageView2.getScaleType();
                int i6 = scaleType2 == null ? -1 : AbstractC3586e.f12064a[scaleType2.ordinal()];
                if (i6 != 1 && i6 != 2 && i6 != 3 && i6 != 4) {
                    enumC3182g3 = EnumC3182g.f10674a;
                }
            }
            enumC3182g = enumC3182g3;
        } else {
            enumC3182g = enumC3182g2;
        }
        C3066n c3066n = this.f10455m;
        C3067o c3067o = c3066n != null ? new C3067o(AbstractC3280d.m6572K(c3066n.f10511a)) : null;
        if (c3067o == null) {
            c3067o = C3067o.f10512b;
        }
        return new C3061i(this.f10443a, obj2, c3246a, config, enumC3179d, list, interfaceC3465d2, headers, c3070r2, this.f10451i, z7, z10, this.f10452j, enumC3054b2, enumC3054b4, enumC3054b5, abstractC3855p2, abstractC3855p, abstractC3855p4, abstractC3855p5, abstractC0541p, interfaceC3184i, enumC3182g, c3067o, this.f10456n, this.f10457o, this.f10458p, this.f10459q, new C3056d(this.f10460r, this.f10448f, this.f10453k, this.f10454l), this.f10444b);
    }

    public C3060h(C3061i c3061i, Context context) {
        this.f10443a = context;
        this.f10444b = c3061i.f10467D;
        this.f10445c = c3061i.f10469b;
        this.f10446d = c3061i.f10470c;
        C3056d c3056d = c3061i.f10466C;
        this.f10447e = c3061i.f10473f;
        this.f10448f = c3056d.f10435b;
        this.f10449g = c3061i.f10475h.newBuilder();
        this.f10450h = AbstractC4158u.m8199s(c3061i.f10476i.f10522a);
        this.f10451i = c3061i.f10477j;
        this.f10452j = c3061i.f10480m;
        this.f10453k = c3056d.f10436c;
        this.f10454l = c3056d.f10437d;
        this.f10455m = new C3066n(c3061i.f10491x);
        this.f10456n = c3061i.f10492y;
        this.f10457o = c3061i.f10493z;
        this.f10458p = c3061i.f10464A;
        this.f10459q = c3061i.f10465B;
        this.f10460r = c3056d.f10434a;
        if (c3061i.f10468a == context) {
            this.f10461s = c3061i.f10488u;
            this.f10462t = c3061i.f10489v;
            this.f10463u = c3061i.f10490w;
        } else {
            this.f10461s = null;
            this.f10462t = null;
            this.f10463u = null;
        }
    }
}

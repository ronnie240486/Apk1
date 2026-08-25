package p141n3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.AbstractC1466d;
import com.bumptech.glide.C1468f;
import com.bumptech.glide.EnumC1469g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import p000a.AbstractC0004e;
import p055ea.AbstractC2460q;
import p116ka.C2921h;
import p151o3.InterfaceC3253g;
import p151o3.InterfaceC3254h;
import p156o9.AbstractC3280d;
import p164p3.InterfaceC3355d;
import p186r3.AbstractC3602f;
import p186r3.AbstractC3604h;
import p186r3.AbstractC3610n;
import p186r3.ExecutorC3601e;
import p187r4.C3621k;
import p198s3.C3706d;
import p247x2.C4090l;
import p247x2.C4094p;
import p247x2.C4098t;
import p247x2.InterfaceC4102x;

public final class C3192f implements InterfaceC3189c, InterfaceC3253g {

    public static final boolean f10712C = Log.isLoggable("GlideRequest", 2);

    public final RuntimeException f10713A;

    public int f10714B;

    public final String f10715a;

    public final C3706d f10716b;

    public final Object f10717c;

    public final InterfaceC3190d f10718d;

    public final Context f10719e;

    public final C1468f f10720f;

    public final Object f10721g;

    public final Class f10722h;

    public final AbstractC3187a f10723i;

    public final int f10724j;

    public final int f10725k;

    public final EnumC1469g f10726l;

    public final InterfaceC3254h f10727m;

    public final ArrayList f10728n;

    public final InterfaceC3355d f10729o;

    public final ExecutorC3601e f10730p;

    public InterfaceC4102x f10731q;

    public C3621k f10732r;

    public long f10733s;

    public volatile C4090l f10734t;

    public Drawable f10735u;

    public Drawable f10736v;

    public Drawable f10737w;

    public int f10738x;

    public int f10739y;

    public boolean f10740z;

    public C3192f(Context context, C1468f c1468f, Object obj, Object obj2, Class cls, AbstractC3187a abstractC3187a, int i6, int i10, EnumC1469g enumC1469g, InterfaceC3254h interfaceC3254h, ArrayList arrayList, InterfaceC3190d interfaceC3190d, C4090l c4090l, InterfaceC3355d interfaceC3355d) {
        ExecutorC3601e executorC3601e = AbstractC3602f.f12098a;
        this.f10715a = f10712C ? String.valueOf(hashCode()) : null;
        this.f10716b = new C3706d();
        this.f10717c = obj;
        this.f10719e = context;
        this.f10720f = c1468f;
        this.f10721g = obj2;
        this.f10722h = cls;
        this.f10723i = abstractC3187a;
        this.f10724j = i6;
        this.f10725k = i10;
        this.f10726l = enumC1469g;
        this.f10727m = interfaceC3254h;
        this.f10728n = arrayList;
        this.f10718d = interfaceC3190d;
        this.f10734t = c4090l;
        this.f10729o = interfaceC3355d;
        this.f10730p = executorC3601e;
        this.f10714B = 1;
        if (this.f10713A == null && ((Map) c1468f.f4438h.f38b).containsKey(AbstractC1466d.class)) {
            this.f10713A = new RuntimeException("Glide request origin trace");
        }
    }

    @Override
    public final boolean mo6401a() {
        boolean z7;
        synchronized (this.f10717c) {
            z7 = this.f10714B == 4;
        }
        return z7;
    }

    @Override
    public final boolean mo6402b() {
        boolean z7;
        synchronized (this.f10717c) {
            z7 = this.f10714B == 6;
        }
        return z7;
    }

    public final void m6411c() {
        if (this.f10740z) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
        this.f10716b.m7468a();
        this.f10727m.mo3561e(this);
        C3621k c3621k = this.f10732r;
        if (c3621k != null) {
            synchronized (((C4090l) c3621k.f12172d)) {
                ((C4094p) c3621k.f12170b).m8112j((C3192f) c3621k.f12171c);
            }
            this.f10732r = null;
        }
    }

    @Override
    public final void clear() {
        synchronized (this.f10717c) {
            try {
                if (this.f10740z) {
                    throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
                }
                this.f10716b.m7468a();
                if (this.f10714B == 6) {
                    return;
                }
                m6411c();
                InterfaceC4102x interfaceC4102x = this.f10731q;
                if (interfaceC4102x != null) {
                    this.f10731q = null;
                } else {
                    interfaceC4102x = null;
                }
                InterfaceC3190d interfaceC3190d = this.f10718d;
                if (interfaceC3190d == null || interfaceC3190d.mo6403c(this)) {
                    this.f10727m.mo3564h(m6412f());
                }
                this.f10714B = 6;
                if (interfaceC4102x != null) {
                    this.f10734t.getClass();
                    C4090l.m8096g(interfaceC4102x);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final boolean mo6404d(InterfaceC3189c interfaceC3189c) {
        int i6;
        int i10;
        Object obj;
        Class cls;
        AbstractC3187a abstractC3187a;
        EnumC1469g enumC1469g;
        int size;
        int i11;
        int i12;
        Object obj2;
        Class cls2;
        AbstractC3187a abstractC3187a2;
        EnumC1469g enumC1469g2;
        int size2;
        boolean zEquals;
        boolean zM6386g;
        if (!(interfaceC3189c instanceof C3192f)) {
            return false;
        }
        synchronized (this.f10717c) {
            try {
                i6 = this.f10724j;
                i10 = this.f10725k;
                obj = this.f10721g;
                cls = this.f10722h;
                abstractC3187a = this.f10723i;
                enumC1469g = this.f10726l;
                ArrayList arrayList = this.f10728n;
                size = arrayList != null ? arrayList.size() : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        C3192f c3192f = (C3192f) interfaceC3189c;
        synchronized (c3192f.f10717c) {
            try {
                i11 = c3192f.f10724j;
                i12 = c3192f.f10725k;
                obj2 = c3192f.f10721g;
                cls2 = c3192f.f10722h;
                abstractC3187a2 = c3192f.f10723i;
                enumC1469g2 = c3192f.f10726l;
                ArrayList arrayList2 = c3192f.f10728n;
                size2 = arrayList2 != null ? arrayList2.size() : 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (i6 == i11 && i10 == i12) {
            char[] cArr = AbstractC3610n.f12112a;
            if (obj == null) {
                zEquals = obj2 == null;
            } else {
                zEquals = obj.equals(obj2);
            }
            if (zEquals && cls.equals(cls2)) {
                if (abstractC3187a == null) {
                    zM6386g = abstractC3187a2 == null;
                } else {
                    zM6386g = abstractC3187a.m6386g(abstractC3187a2);
                }
                if (zM6386g && enumC1469g == enumC1469g2 && size == size2) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public final void mo6405e() {
        synchronized (this.f10717c) {
            try {
                if (this.f10740z) {
                    throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
                }
                this.f10716b.m7468a();
                int i6 = AbstractC3604h.f12101b;
                this.f10733s = SystemClock.elapsedRealtimeNanos();
                if (this.f10721g == null) {
                    if (AbstractC3610n.m7241i(this.f10724j, this.f10725k)) {
                        this.f10738x = this.f10724j;
                        this.f10739y = this.f10725k;
                    }
                    if (this.f10737w == null) {
                        this.f10723i.getClass();
                        this.f10737w = null;
                    }
                    m6415j(new C4098t("Received null model"), this.f10737w == null ? 5 : 3);
                    return;
                }
                int i10 = this.f10714B;
                if (i10 == 2) {
                    throw new IllegalArgumentException("Cannot restart a running request");
                }
                if (i10 == 4) {
                    m6416k(this.f10731q, 5, false);
                    return;
                }
                ArrayList<C2921h> arrayList = this.f10728n;
                if (arrayList != null) {
                    for (C2921h c2921h : arrayList) {
                    }
                }
                this.f10714B = 3;
                if (AbstractC3610n.m7241i(this.f10724j, this.f10725k)) {
                    m6418m(this.f10724j, this.f10725k);
                } else {
                    this.f10727m.mo3562f(this);
                }
                int i11 = this.f10714B;
                if (i11 == 2 || i11 == 3) {
                    InterfaceC3190d interfaceC3190d = this.f10718d;
                    if (interfaceC3190d == null || interfaceC3190d.mo6406f(this)) {
                        this.f10727m.mo3563g(m6412f());
                    }
                }
                if (f10712C) {
                    m6414h("finished run method in " + AbstractC3604h.m7226a(this.f10733s));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Drawable m6412f() {
        if (this.f10736v == null) {
            this.f10736v = this.f10723i.f10692f;
        }
        return this.f10736v;
    }

    public final boolean m6413g() {
        InterfaceC3190d interfaceC3190d = this.f10718d;
        return interfaceC3190d == null || !interfaceC3190d.getRoot().mo6401a();
    }

    public final void m6414h(String str) {
        StringBuilder sbM29w = AbstractC0004e.m29w(str, " this: ");
        sbM29w.append(this.f10715a);
        Log.v("GlideRequest", sbM29w.toString());
    }

    @Override
    public final boolean mo6409i() {
        boolean z7;
        synchronized (this.f10717c) {
            z7 = this.f10714B == 4;
        }
        return z7;
    }

    @Override
    public final boolean isRunning() {
        boolean z7;
        synchronized (this.f10717c) {
            int i6 = this.f10714B;
            z7 = i6 == 2 || i6 == 3;
        }
        return z7;
    }

    public final void m6415j(C4098t c4098t, int i6) {
        int i10;
        this.f10716b.m7468a();
        synchronized (this.f10717c) {
            try {
                c4098t.getClass();
                int i11 = this.f10720f.f4439i;
                if (i11 <= i6) {
                    Log.w("Glide", "Load failed for [" + this.f10721g + "] with dimensions [" + this.f10738x + "x" + this.f10739y + "]", c4098t);
                    if (i11 <= 4) {
                        c4098t.m8119d();
                    }
                }
                Drawable drawableM6412f = null;
                this.f10732r = null;
                this.f10714B = 5;
                InterfaceC3190d interfaceC3190d = this.f10718d;
                if (interfaceC3190d != null) {
                    interfaceC3190d.mo6410j(this);
                }
                boolean z7 = true;
                this.f10740z = true;
                try {
                    ArrayList<C2921h> arrayList = this.f10728n;
                    if (arrayList != null) {
                        for (C2921h c2921h : arrayList) {
                            Object obj = this.f10721g;
                            m6413g();
                            c2921h.m5913a(c4098t, obj);
                        }
                    }
                    InterfaceC3190d interfaceC3190d2 = this.f10718d;
                    if (interfaceC3190d2 != null && !interfaceC3190d2.mo6406f(this)) {
                        z7 = false;
                    }
                    if (z7) {
                        if (this.f10721g == null) {
                            if (this.f10737w == null) {
                                this.f10723i.getClass();
                                this.f10737w = null;
                            }
                            drawableM6412f = this.f10737w;
                        }
                        if (drawableM6412f == null) {
                            if (this.f10735u == null) {
                                AbstractC3187a abstractC3187a = this.f10723i;
                                Drawable drawable = abstractC3187a.f10690d;
                                this.f10735u = drawable;
                                if (drawable == null && (i10 = abstractC3187a.f10691e) > 0) {
                                    Resources.Theme theme = abstractC3187a.f10702p;
                                    Context context = this.f10719e;
                                    if (theme == null) {
                                        theme = context.getTheme();
                                    }
                                    this.f10735u = AbstractC3280d.m6596n(context, context, i10, theme);
                                }
                            }
                            drawableM6412f = this.f10735u;
                        }
                        if (drawableM6412f == null) {
                            drawableM6412f = m6412f();
                        }
                        this.f10727m.mo3558b(drawableM6412f);
                    }
                    this.f10740z = false;
                } catch (Throwable th) {
                    this.f10740z = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void m6416k(InterfaceC4102x interfaceC4102x, int i6, boolean z7) {
        this.f10716b.m7468a();
        InterfaceC4102x interfaceC4102x2 = null;
        try {
            synchronized (this.f10717c) {
                try {
                    this.f10732r = null;
                    if (interfaceC4102x == null) {
                        m6415j(new C4098t("Expected to receive a Resource<R> with an object of " + this.f10722h + " inside, but instead got null."), 5);
                        return;
                    }
                    Object obj = interfaceC4102x.get();
                    try {
                        if (obj != null && this.f10722h.isAssignableFrom(obj.getClass())) {
                            InterfaceC3190d interfaceC3190d = this.f10718d;
                            if (interfaceC3190d == null || interfaceC3190d.mo6408h(this)) {
                                m6417l(interfaceC4102x, obj, i6);
                                return;
                            }
                            this.f10731q = null;
                            this.f10714B = 4;
                            this.f10734t.getClass();
                            C4090l.m8096g(interfaceC4102x);
                            return;
                        }
                        this.f10731q = null;
                        StringBuilder sb = new StringBuilder("Expected to receive an object of ");
                        sb.append(this.f10722h);
                        sb.append(" but instead got ");
                        sb.append(obj != null ? obj.getClass() : "");
                        sb.append("{");
                        sb.append(obj);
                        sb.append("} inside Resource{");
                        sb.append(interfaceC4102x);
                        sb.append("}.");
                        sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                        m6415j(new C4098t(sb.toString()), 5);
                        this.f10734t.getClass();
                        C4090l.m8096g(interfaceC4102x);
                    } catch (Throwable th) {
                        interfaceC4102x2 = interfaceC4102x;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (interfaceC4102x2 != null) {
                this.f10734t.getClass();
                C4090l.m8096g(interfaceC4102x2);
            }
            throw th3;
        }
    }

    public final void m6417l(InterfaceC4102x interfaceC4102x, Object obj, int i6) {
        m6413g();
        this.f10714B = 4;
        this.f10731q = interfaceC4102x;
        int i10 = this.f10720f.f4439i;
        Object obj2 = this.f10721g;
        if (i10 <= 3) {
            Log.d("Glide", "Finished loading " + obj.getClass().getSimpleName() + " from " + AbstractC2460q.m5504r(i6) + " for " + obj2 + " with size [" + this.f10738x + "x" + this.f10739y + "] in " + AbstractC3604h.m7226a(this.f10733s) + " ms");
        }
        InterfaceC3190d interfaceC3190d = this.f10718d;
        if (interfaceC3190d != null) {
            interfaceC3190d.mo6407g(this);
        }
        this.f10740z = true;
        try {
            ArrayList arrayList = this.f10728n;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((C2921h) it.next()).m5914b(obj, obj2);
                }
            }
            this.f10727m.mo3560d(obj, this.f10729o.mo5754g(i6));
        } finally {
            this.f10740z = false;
        }
    }

    public final void m6418m(int i6, int i10) {
        Object obj;
        int iRound = i6;
        this.f10716b.m7468a();
        Object obj2 = this.f10717c;
        synchronized (obj2) {
            try {
                try {
                    boolean z7 = f10712C;
                    if (z7) {
                        m6414h("Got onSizeReady in " + AbstractC3604h.m7226a(this.f10733s));
                    }
                    if (this.f10714B == 3) {
                        this.f10714B = 2;
                        this.f10723i.getClass();
                        if (iRound != Integer.MIN_VALUE) {
                            iRound = Math.round(iRound * 1.0f);
                        }
                        this.f10738x = iRound;
                        this.f10739y = i10 == Integer.MIN_VALUE ? i10 : Math.round(1.0f * i10);
                        if (z7) {
                            m6414h("finished setup for calling load in " + AbstractC3604h.m7226a(this.f10733s));
                        }
                        C4090l c4090l = this.f10734t;
                        C1468f c1468f = this.f10720f;
                        Object obj3 = this.f10721g;
                        AbstractC3187a abstractC3187a = this.f10723i;
                        try {
                            obj = obj2;
                            try {
                                this.f10732r = c4090l.m8097a(c1468f, obj3, abstractC3187a.f10696j, this.f10738x, this.f10739y, abstractC3187a.f10700n, this.f10722h, this.f10726l, abstractC3187a.f10688b, abstractC3187a.f10699m, abstractC3187a.f10697k, abstractC3187a.f10704r, abstractC3187a.f10698l, abstractC3187a.f10693g, abstractC3187a.f10705s, this, this.f10730p);
                                if (this.f10714B != 2) {
                                    this.f10732r = null;
                                }
                                if (z7) {
                                    m6414h("finished onSizeReady in " + AbstractC3604h.m7226a(this.f10733s));
                                }
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            obj = obj2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                obj = obj2;
            }
        }
    }

    @Override
    public final void pause() {
        synchronized (this.f10717c) {
            try {
                if (isRunning()) {
                    clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String toString() {
        Object obj;
        Class cls;
        synchronized (this.f10717c) {
            obj = this.f10721g;
            cls = this.f10722h;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }
}

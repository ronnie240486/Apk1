package p109k3;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import androidx.appcompat.widget.C0280v;
import androidx.lifecycle.AbstractC0541p;
import androidx.lifecycle.EnumC0537n;
import androidx.lifecycle.EnumC0539o;
import androidx.lifecycle.InterfaceC0551u;
import androidx.lifecycle.InterfaceC0555w;
import com.bumptech.glide.ComponentCallbacks2C1464b;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import p002a1.C0026b;
import p005a4.C0052k;
import p012b.C1224a;
import p020b7.AbstractC1332b;
import p041d7.C2164a3;
import p041d7.C2220i3;
import p041d7.C2227j3;
import p041d7.C2241l3;
import p041d7.ConcurrentMapC2179c4;
import p041d7.EnumC2234k3;
import p048e2.C2368c;
import p103j9.AbstractC2796i;
import p127m.C3022d;
import p127m.C3024f;
import p141n3.InterfaceC3189c;
import p143n5.AbstractC3198d;
import p156o9.AbstractC3281e;
import p176q4.C3477d;
import p186r3.InterfaceC3603g;
import p227v1.C3969a;
import p227v1.InterfaceC3972d;
import p227v1.InterfaceC3973e;
import p242w5.C4058f;

public final class C2888t implements InterfaceC3603g {

    public static volatile C2888t f9829e;

    public final int f9830a;

    public boolean f9831b;

    public Object f9832c;

    public Object f9833d;

    public C2888t(int i6) {
        this.f9830a = i6;
        switch (i6) {
            case 3:
                this.f9832c = Collections.newSetFromMap(new WeakHashMap());
                this.f9833d = new HashSet();
                break;
            case 5:
                this.f9832c = new Object();
                break;
        }
    }

    public static C2888t m5884b(Context context) {
        if (f9829e == null) {
            synchronized (C2888t.class) {
                try {
                    if (f9829e == null) {
                        f9829e = new C2888t(context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f9829e;
    }

    public boolean m5885a(InterfaceC3189c interfaceC3189c) {
        boolean z7 = true;
        if (interfaceC3189c == null) {
            return true;
        }
        boolean zRemove = ((Set) this.f9832c).remove(interfaceC3189c);
        if (!((HashSet) this.f9833d).remove(interfaceC3189c) && !zRemove) {
            z7 = false;
        }
        if (z7) {
            interfaceC3189c.clear();
        }
        return z7;
    }

    public ConcurrentMap m5886c() {
        if (!this.f9831b) {
            return new ConcurrentHashMap(16, 0.75f, 4);
        }
        C2164a3 c2164a3 = ConcurrentMapC2179c4.f7852j;
        C2227j3 c2227j3 = (C2227j3) this.f9832c;
        C2220i3 c2220i3 = EnumC2234k3.f7974a;
        if (((EnumC2234k3) AbstractC1332b.m3227r(c2227j3, c2220i3)) == c2220i3 && ((EnumC2234k3) AbstractC1332b.m3227r((C2227j3) this.f9833d, c2220i3)) == c2220i3) {
            return new ConcurrentMapC2179c4(this, C2241l3.f7982b);
        }
        EnumC2234k3 enumC2234k3 = (EnumC2234k3) AbstractC1332b.m3227r((C2227j3) this.f9832c, c2220i3);
        C2227j3 c2227j4 = EnumC2234k3.f7975b;
        if (enumC2234k3 == c2220i3 && ((EnumC2234k3) AbstractC1332b.m3227r((C2227j3) this.f9833d, c2220i3)) == c2227j4) {
            return new ConcurrentMapC2179c4(this, C2241l3.f7983c);
        }
        if (((EnumC2234k3) AbstractC1332b.m3227r((C2227j3) this.f9832c, c2220i3)) == c2227j4 && ((EnumC2234k3) AbstractC1332b.m3227r((C2227j3) this.f9833d, c2220i3)) == c2220i3) {
            return new ConcurrentMapC2179c4(this, C2241l3.f7984d);
        }
        if (((EnumC2234k3) AbstractC1332b.m3227r((C2227j3) this.f9832c, c2220i3)) == c2227j4 && ((EnumC2234k3) AbstractC1332b.m3227r((C2227j3) this.f9833d, c2220i3)) == c2227j4) {
            return new ConcurrentMapC2179c4(this, C2241l3.f7985e);
        }
        throw new AssertionError();
    }

    public void m5887d() {
        ?? r10 = this.f9832c;
        AbstractC0541p abstractC0541pMo360f = r10.mo360f();
        if (abstractC0541pMo360f.mo1509b() != EnumC0539o.f2508b) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        abstractC0541pMo360f.mo1508a(new C3969a(0, r10));
        final C0280v c0280v = (C0280v) this.f9833d;
        c0280v.getClass();
        if (c0280v.f1084c) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        abstractC0541pMo360f.mo1508a(new InterfaceC0551u() {
            @Override
            public final void onStateChanged(InterfaceC0555w interfaceC0555w, EnumC0537n enumC0537n) {
                C0280v c0280v2 = c0280v;
                AbstractC2796i.m5785f(c0280v2, "this$0");
                if (enumC0537n == EnumC0537n.ON_START) {
                    c0280v2.f1086e = true;
                } else if (enumC0537n == EnumC0537n.ON_STOP) {
                    c0280v2.f1086e = false;
                }
            }
        });
        c0280v.f1084c = true;
        this.f9831b = true;
    }

    public void m5888e(Bundle bundle) {
        if (!this.f9831b) {
            m5887d();
        }
        AbstractC0541p abstractC0541pMo360f = this.f9832c.mo360f();
        if (abstractC0541pMo360f.mo1509b().compareTo(EnumC0539o.f2510d) >= 0) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + abstractC0541pMo360f.mo1509b()).toString());
        }
        C0280v c0280v = (C0280v) this.f9833d;
        if (!c0280v.f1084c) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if (c0280v.f1085d) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        c0280v.f1082a = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        c0280v.f1085d = true;
    }

    public void m5889f(Bundle bundle) {
        AbstractC2796i.m5785f(bundle, "outBundle");
        C0280v c0280v = (C0280v) this.f9833d;
        c0280v.getClass();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = (Bundle) c0280v.f1082a;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        C3024f c3024f = (C3024f) c0280v.f1087f;
        c3024f.getClass();
        C3022d c3022d = new C3022d(c3024f);
        c3024f.f10352c.put(c3022d, Boolean.FALSE);
        while (c3022d.hasNext()) {
            Map.Entry entry = (Map.Entry) c3022d.next();
            bundle2.putBundle((String) entry.getKey(), ((InterfaceC3972d) entry.getValue()).saveState());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public void m5890g() {
        C2227j3 c2227j3 = EnumC2234k3.f7975b;
        C2227j3 c2227j4 = (C2227j3) this.f9832c;
        AbstractC1332b.m3222m(c2227j4, "Key strength was already set to %s", c2227j4 == null);
        this.f9832c = c2227j3;
        this.f9831b = true;
    }

    @Override
    public Object get() {
        if (this.f9831b) {
            throw new IllegalStateException("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you're using the provided Registry rather calling glide.getRegistry()!");
        }
        Trace.beginSection("Glide registry");
        this.f9831b = true;
        try {
            return AbstractC3281e.m6622l((ComponentCallbacks2C1464b) this.f9832c, (ArrayList) this.f9833d);
        } finally {
            this.f9831b = false;
            Trace.endSection();
        }
    }

    public void m5891h(C4058f c4058f) {
        synchronized (this.f9832c) {
            try {
                if (((ArrayDeque) this.f9833d) == null) {
                    this.f9833d = new ArrayDeque();
                }
                ((ArrayDeque) this.f9833d).add(c4058f);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void m5892i(C3477d c3477d) {
        C4058f c4058f;
        synchronized (this.f9832c) {
            if (((ArrayDeque) this.f9833d) != null && !this.f9831b) {
                this.f9831b = true;
                while (true) {
                    synchronized (this.f9832c) {
                        try {
                            c4058f = (C4058f) ((ArrayDeque) this.f9833d).poll();
                            if (c4058f == null) {
                                this.f9831b = false;
                                return;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    c4058f.m8064a(c3477d);
                }
            }
        }
    }

    public String toString() {
        switch (this.f9830a) {
            case 2:
                C0026b c0026bM3232w = AbstractC1332b.m3232w(this);
                C2227j3 c2227j3 = (C2227j3) this.f9832c;
                if (c2227j3 != null) {
                    c0026bM3232w.m127d(AbstractC1332b.m3231v(c2227j3.toString()), "keyStrength");
                }
                C2227j3 c2227j4 = (C2227j3) this.f9833d;
                if (c2227j4 != null) {
                    c0026bM3232w.m127d(AbstractC1332b.m3231v(c2227j4.toString()), "valueStrength");
                }
                return c0026bM3232w.toString();
            case 3:
                return super.toString() + "{numRequests=" + ((Set) this.f9832c).size() + ", isPaused=" + this.f9831b + "}";
            default:
                return super.toString();
        }
    }

    public C2888t(InterfaceC3973e interfaceC3973e) {
        this.f9830a = 4;
        this.f9832c = interfaceC3973e;
        this.f9833d = new C0280v();
    }

    public C2888t(Context context) {
        Object c2887s;
        this.f9830a = 0;
        this.f9833d = new HashSet();
        C1224a c1224a = new C1224a(new C0052k(context, 2));
        C2882n c2882n = new C2882n(this);
        if (Build.VERSION.SDK_INT >= 24) {
            c2887s = new C2368c(c1224a, c2882n);
        } else {
            c2887s = new C2887s(context, c1224a, c2882n);
        }
        this.f9832c = c2887s;
    }

    public C2888t(ComponentCallbacks2C1464b componentCallbacks2C1464b, ArrayList arrayList, AbstractC3198d abstractC3198d) {
        this.f9830a = 1;
        this.f9832c = componentCallbacks2C1464b;
        this.f9833d = arrayList;
    }
}

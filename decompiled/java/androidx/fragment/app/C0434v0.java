package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import p000a.AbstractC0004e;
import p094j0.C2757e;
import p094j0.InterfaceC2756d;
import p215u.AbstractC3885h;

public final class C0434v0 {

    public int f2007a;

    public int f2008b;

    public final AbstractComponentCallbacksC0427s f2009c;

    public final ArrayList f2010d;

    public final HashSet f2011e;

    public boolean f2012f;

    public boolean f2013g;

    public final C0422p0 f2014h;

    public C0434v0(int i6, int i10, C0422p0 c0422p0, C2757e c2757e) {
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = c0422p0.f1933c;
        this.f2010d = new ArrayList();
        this.f2011e = new HashSet();
        this.f2012f = false;
        this.f2013g = false;
        this.f2007a = i6;
        this.f2008b = i10;
        this.f2009c = abstractComponentCallbacksC0427s;
        c2757e.m5724a(new C0397d(3, this));
        this.f2014h = c0422p0;
    }

    public final void m1336a() {
        if (this.f2012f) {
            return;
        }
        this.f2012f = true;
        HashSet hashSet = this.f2011e;
        if (hashSet.isEmpty()) {
            m1337b();
            return;
        }
        for (C2757e c2757e : new ArrayList(hashSet)) {
            synchronized (c2757e) {
                try {
                    if (!c2757e.f9470a) {
                        c2757e.f9470a = true;
                        c2757e.f9472c = true;
                        InterfaceC2756d interfaceC2756d = c2757e.f9471b;
                        if (interfaceC2756d != null) {
                            try {
                                interfaceC2756d.mo125a();
                            } catch (Throwable th) {
                                synchronized (c2757e) {
                                    c2757e.f9472c = false;
                                    c2757e.notifyAll();
                                    throw th;
                                }
                            }
                        }
                        synchronized (c2757e) {
                            c2757e.f9472c = false;
                            c2757e.notifyAll();
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public final void m1337b() {
        if (!this.f2013g) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f2013g = true;
            Iterator it = this.f2010d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }
        this.f2014h.m1298k();
    }

    public final void m1338c(int i6, int i10) {
        int iM7785a = AbstractC3885h.m7785a(i10);
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = this.f2009c;
        if (iM7785a == 0) {
            if (this.f2007a != 1) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + abstractComponentCallbacksC0427s + " mFinalState = " + AbstractC0004e.m6F(this.f2007a) + " -> " + AbstractC0004e.m6F(i6) + ". ");
                }
                this.f2007a = i6;
                return;
            }
            return;
        }
        if (iM7785a == 1) {
            if (this.f2007a == 1) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + abstractComponentCallbacksC0427s + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + AbstractC0004e.m5E(this.f2008b) + " to ADDING.");
                }
                this.f2007a = 2;
                this.f2008b = 2;
                return;
            }
            return;
        }
        if (iM7785a != 2) {
            return;
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + abstractComponentCallbacksC0427s + " mFinalState = " + AbstractC0004e.m6F(this.f2007a) + " -> REMOVED. mLifecycleImpact  = " + AbstractC0004e.m5E(this.f2008b) + " to REMOVING.");
        }
        this.f2007a = 1;
        this.f2008b = 3;
    }

    public final void m1339d() {
        if (this.f2008b == 2) {
            C0422p0 c0422p0 = this.f2014h;
            AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = c0422p0.f1933c;
            View viewFindFocus = abstractComponentCallbacksC0427s.f1951F.findFocus();
            if (viewFindFocus != null) {
                abstractComponentCallbacksC0427s.m1318g().f1930k = viewFindFocus;
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + abstractComponentCallbacksC0427s);
                }
            }
            View viewM1313L = this.f2009c.m1313L();
            if (viewM1313L.getParent() == null) {
                c0422p0.m1289b();
                viewM1313L.setAlpha(0.0f);
            }
            if (viewM1313L.getAlpha() == 0.0f && viewM1313L.getVisibility() == 0) {
                viewM1313L.setVisibility(4);
            }
            C0421p c0421p = abstractComponentCallbacksC0427s.f1954I;
            viewM1313L.setAlpha(c0421p == null ? 1.0f : c0421p.f1929j);
        }
    }

    public final String toString() {
        return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + AbstractC0004e.m6F(this.f2007a) + "} {mLifecycleImpact = " + AbstractC0004e.m5E(this.f2008b) + "} {mFragment = " + this.f2009c + "}";
    }
}

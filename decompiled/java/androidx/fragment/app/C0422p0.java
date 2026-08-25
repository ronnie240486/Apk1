package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.C0559y;
import androidx.lifecycle.C0562z0;
import androidx.lifecycle.EnumC0537n;
import androidx.lifecycle.EnumC0539o;
import androidx.lifecycle.InterfaceC0512a1;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.WeakHashMap;
import p000a.AbstractC0004e;
import p002a1.C0026b;
import p007a7.C0069f;
import p107k1.AbstractC2861a;
import p107k1.C2862b;
import p109k3.C2888t;
import p138n0.AbstractC3113e0;
import p138n0.AbstractC3155s0;
import p160p.C3348l;

public final class C0422p0 {

    public final C0069f f1931a;

    public final C0026b f1932b;

    public final AbstractComponentCallbacksC0427s f1933c;

    public boolean f1934d = false;

    public int f1935e = -1;

    public C0422p0(C0069f c0069f, C0026b c0026b, AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        this.f1931a = c0069f;
        this.f1932b = c0026b;
        this.f1933c = abstractComponentCallbacksC0427s;
    }

    public final void m1288a() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = this.f1933c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + abstractComponentCallbacksC0427s);
        }
        Bundle bundle = abstractComponentCallbacksC0427s.f1965b;
        abstractComponentCallbacksC0427s.f1984u.m1224K();
        abstractComponentCallbacksC0427s.f1964a = 3;
        abstractComponentCallbacksC0427s.f1949D = true;
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + abstractComponentCallbacksC0427s);
        }
        View view = abstractComponentCallbacksC0427s.f1951F;
        if (view != null) {
            Bundle bundle2 = abstractComponentCallbacksC0427s.f1965b;
            SparseArray<Parcelable> sparseArray = abstractComponentCallbacksC0427s.f1966c;
            if (sparseArray != null) {
                view.restoreHierarchyState(sparseArray);
                abstractComponentCallbacksC0427s.f1966c = null;
            }
            if (abstractComponentCallbacksC0427s.f1951F != null) {
                abstractComponentCallbacksC0427s.f1959N.f1994e.m5888e(abstractComponentCallbacksC0427s.f1967d);
                abstractComponentCallbacksC0427s.f1967d = null;
            }
            abstractComponentCallbacksC0427s.f1949D = false;
            abstractComponentCallbacksC0427s.mo1272E(bundle2);
            if (!abstractComponentCallbacksC0427s.f1949D) {
                throw new C0436w0("Fragment " + abstractComponentCallbacksC0427s + " did not call through to super.onViewStateRestored()");
            }
            if (abstractComponentCallbacksC0427s.f1951F != null) {
                abstractComponentCallbacksC0427s.f1959N.m1333b(EnumC0537n.ON_CREATE);
            }
        }
        abstractComponentCallbacksC0427s.f1965b = null;
        C0412k0 c0412k0 = abstractComponentCallbacksC0427s.f1984u;
        c0412k0.f1885y = false;
        c0412k0.f1886z = false;
        c0412k0.f1859F.f1896i = false;
        c0412k0.m1254p(4);
        this.f1931a.m231g(abstractComponentCallbacksC0427s, abstractComponentCallbacksC0427s.f1965b, false);
    }

    public final void m1289b() {
        View view;
        View view2;
        C0026b c0026b = this.f1932b;
        c0026b.getClass();
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = this.f1933c;
        ViewGroup viewGroup = abstractComponentCallbacksC0427s.f1950E;
        int iIndexOfChild = -1;
        if (viewGroup != null) {
            ArrayList arrayList = (ArrayList) c0026b.f54b;
            int iIndexOf = arrayList.indexOf(abstractComponentCallbacksC0427s);
            for (int i6 = iIndexOf - 1; i6 >= 0; i6--) {
                AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = (AbstractComponentCallbacksC0427s) arrayList.get(i6);
                if (abstractComponentCallbacksC0427s2.f1950E == viewGroup && (view2 = abstractComponentCallbacksC0427s2.f1951F) != null) {
                    iIndexOfChild = viewGroup.indexOfChild(view2) + 1;
                }
            }
            while (true) {
                iIndexOf++;
                if (iIndexOf >= arrayList.size()) {
                    break;
                }
                AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s3 = (AbstractComponentCallbacksC0427s) arrayList.get(iIndexOf);
                if (abstractComponentCallbacksC0427s3.f1950E == viewGroup && (view = abstractComponentCallbacksC0427s3.f1951F) != null) {
                    iIndexOfChild = viewGroup.indexOfChild(view);
                    break;
                }
            }
        }
        abstractComponentCallbacksC0427s.f1950E.addView(abstractComponentCallbacksC0427s.f1951F, iIndexOfChild);
    }

    public final void m1290c() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = this.f1933c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "moveto ATTACHED: " + abstractComponentCallbacksC0427s);
        }
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = abstractComponentCallbacksC0427s.f1971h;
        C0026b c0026b = this.f1932b;
        C0422p0 c0422p0 = null;
        if (abstractComponentCallbacksC0427s2 != null) {
            C0422p0 c0422p1 = (C0422p0) ((HashMap) c0026b.f55c).get(abstractComponentCallbacksC0427s2.f1969f);
            if (c0422p1 == null) {
                throw new IllegalStateException("Fragment " + abstractComponentCallbacksC0427s + " declared target fragment " + abstractComponentCallbacksC0427s.f1971h + " that does not belong to this FragmentManager!");
            }
            abstractComponentCallbacksC0427s.f1972i = abstractComponentCallbacksC0427s.f1971h.f1969f;
            abstractComponentCallbacksC0427s.f1971h = null;
            c0422p0 = c0422p1;
        } else {
            String str = abstractComponentCallbacksC0427s.f1972i;
            if (str != null && (c0422p0 = (C0422p0) ((HashMap) c0026b.f55c).get(str)) == null) {
                StringBuilder sb = new StringBuilder("Fragment ");
                sb.append(abstractComponentCallbacksC0427s);
                sb.append(" declared target fragment ");
                throw new IllegalStateException(AbstractC0004e.m26t(sb, abstractComponentCallbacksC0427s.f1972i, " that does not belong to this FragmentManager!"));
            }
        }
        if (c0422p0 != null) {
            c0422p0.m1298k();
        }
        AbstractC0410j0 abstractC0410j0 = abstractComponentCallbacksC0427s.f1982s;
        abstractComponentCallbacksC0427s.f1983t = abstractC0410j0.f1874n;
        abstractComponentCallbacksC0427s.f1985v = abstractC0410j0.f1876p;
        C0069f c0069f = this.f1931a;
        c0069f.m241r(abstractComponentCallbacksC0427s, false);
        ArrayList arrayList = abstractComponentCallbacksC0427s.f1963R;
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            throw AbstractC0004e.m18l(it);
        }
        arrayList.clear();
        abstractComponentCallbacksC0427s.f1984u.m1240b(abstractComponentCallbacksC0427s.f1983t, abstractComponentCallbacksC0427s.mo1277b(), abstractComponentCallbacksC0427s);
        abstractComponentCallbacksC0427s.f1964a = 0;
        abstractComponentCallbacksC0427s.f1949D = false;
        abstractComponentCallbacksC0427s.mo1278r(abstractComponentCallbacksC0427s.f1983t.f2003g);
        if (!abstractComponentCallbacksC0427s.f1949D) {
            throw new C0436w0("Fragment " + abstractComponentCallbacksC0427s + " did not call through to super.onAttach()");
        }
        Iterator it2 = abstractComponentCallbacksC0427s.f1982s.f1872l.iterator();
        while (it2.hasNext()) {
            ((InterfaceC0416m0) it2.next()).mo1204b();
        }
        C0412k0 c0412k0 = abstractComponentCallbacksC0427s.f1984u;
        c0412k0.f1885y = false;
        c0412k0.f1886z = false;
        c0412k0.f1859F.f1896i = false;
        c0412k0.m1254p(0);
        c0069f.m236m(abstractComponentCallbacksC0427s, false);
    }

    public final int m1291d() {
        C0434v0 c0434v0;
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = this.f1933c;
        if (abstractComponentCallbacksC0427s.f1982s == null) {
            return abstractComponentCallbacksC0427s.f1964a;
        }
        int iMin = this.f1935e;
        int iOrdinal = abstractComponentCallbacksC0427s.f1957L.ordinal();
        int i6 = 0;
        if (iOrdinal == 1) {
            iMin = Math.min(iMin, 0);
        } else if (iOrdinal == 2) {
            iMin = Math.min(iMin, 1);
        } else if (iOrdinal == 3) {
            iMin = Math.min(iMin, 5);
        } else if (iOrdinal != 4) {
            iMin = Math.min(iMin, -1);
        }
        if (abstractComponentCallbacksC0427s.f1977n) {
            if (abstractComponentCallbacksC0427s.f1978o) {
                iMin = Math.max(this.f1935e, 2);
                View view = abstractComponentCallbacksC0427s.f1951F;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.f1935e < 4 ? Math.min(iMin, abstractComponentCallbacksC0427s.f1964a) : Math.min(iMin, 1);
            }
        }
        if (!abstractComponentCallbacksC0427s.f1975l) {
            iMin = Math.min(iMin, 1);
        }
        ViewGroup viewGroup = abstractComponentCallbacksC0427s.f1950E;
        if (viewGroup != null) {
            C0407i c0407iM1206f = C0407i.m1206f(viewGroup, abstractComponentCallbacksC0427s.m1323l().m1220D());
            c0407iM1206f.getClass();
            C0434v0 c0434v0M1210d = c0407iM1206f.m1210d(abstractComponentCallbacksC0427s);
            i6 = c0434v0M1210d != null ? c0434v0M1210d.f2008b : 0;
            Iterator it = c0407iM1206f.f1848c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    c0434v0 = null;
                    break;
                }
                c0434v0 = (C0434v0) it.next();
                if (c0434v0.f2009c.equals(abstractComponentCallbacksC0427s) && !c0434v0.f2012f) {
                    break;
                }
            }
            if (c0434v0 != null && (i6 == 0 || i6 == 1)) {
                i6 = c0434v0.f2008b;
            }
        }
        if (i6 == 2) {
            iMin = Math.min(iMin, 6);
        } else if (i6 == 3) {
            iMin = Math.max(iMin, 3);
        } else if (abstractComponentCallbacksC0427s.f1976m) {
            iMin = abstractComponentCallbacksC0427s.f1981r > 0 ? Math.min(iMin, 1) : Math.min(iMin, -1);
        }
        if (abstractComponentCallbacksC0427s.f1952G && abstractComponentCallbacksC0427s.f1964a < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + abstractComponentCallbacksC0427s);
        }
        return iMin;
    }

    public final void m1292e() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = this.f1933c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "moveto CREATED: " + abstractComponentCallbacksC0427s);
        }
        if (abstractComponentCallbacksC0427s.f1956K) {
            abstractComponentCallbacksC0427s.m1314M(abstractComponentCallbacksC0427s.f1965b);
            abstractComponentCallbacksC0427s.f1964a = 1;
            return;
        }
        Bundle bundle = abstractComponentCallbacksC0427s.f1965b;
        C0069f c0069f = this.f1931a;
        c0069f.m242s(abstractComponentCallbacksC0427s, bundle, false);
        Bundle bundle2 = abstractComponentCallbacksC0427s.f1965b;
        abstractComponentCallbacksC0427s.f1984u.m1224K();
        abstractComponentCallbacksC0427s.f1964a = 1;
        abstractComponentCallbacksC0427s.f1949D = false;
        abstractComponentCallbacksC0427s.f1958M.mo1508a(new C0419o(abstractComponentCallbacksC0427s));
        abstractComponentCallbacksC0427s.f1962Q.m5888e(bundle2);
        abstractComponentCallbacksC0427s.mo1279s(bundle2);
        abstractComponentCallbacksC0427s.f1956K = true;
        if (abstractComponentCallbacksC0427s.f1949D) {
            abstractComponentCallbacksC0427s.f1958M.m1521f(EnumC0537n.ON_CREATE);
            c0069f.m237n(abstractComponentCallbacksC0427s, abstractComponentCallbacksC0427s.f1965b, false);
        } else {
            throw new C0436w0("Fragment " + abstractComponentCallbacksC0427s + " did not call through to super.onCreate()");
        }
    }

    public final void m1293f() {
        String resourceName;
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = this.f1933c;
        if (abstractComponentCallbacksC0427s.f1977n) {
            return;
        }
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + abstractComponentCallbacksC0427s);
        }
        LayoutInflater layoutInflaterMo1282x = abstractComponentCallbacksC0427s.mo1282x(abstractComponentCallbacksC0427s.f1965b);
        ViewGroup viewGroup = abstractComponentCallbacksC0427s.f1950E;
        if (viewGroup == null) {
            int i6 = abstractComponentCallbacksC0427s.f1987x;
            if (i6 == 0) {
                viewGroup = null;
            } else {
                if (i6 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + abstractComponentCallbacksC0427s + " for a container view with no id");
                }
                viewGroup = (ViewGroup) abstractComponentCallbacksC0427s.f1982s.f1875o.mo1265B(i6);
                if (viewGroup == null && !abstractComponentCallbacksC0427s.f1979p) {
                    try {
                        resourceName = abstractComponentCallbacksC0427s.m1324m().getResourceName(abstractComponentCallbacksC0427s.f1987x);
                    } catch (Resources.NotFoundException unused) {
                        resourceName = "unknown";
                    }
                    throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(abstractComponentCallbacksC0427s.f1987x) + " (" + resourceName + ") for fragment " + abstractComponentCallbacksC0427s);
                }
            }
        }
        abstractComponentCallbacksC0427s.f1950E = viewGroup;
        abstractComponentCallbacksC0427s.mo1273F(layoutInflaterMo1282x, viewGroup, abstractComponentCallbacksC0427s.f1965b);
        View view = abstractComponentCallbacksC0427s.f1951F;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            abstractComponentCallbacksC0427s.f1951F.setTag(R.id.fragment_container_view_tag, abstractComponentCallbacksC0427s);
            if (viewGroup != null) {
                m1289b();
            }
            if (abstractComponentCallbacksC0427s.f1989z) {
                abstractComponentCallbacksC0427s.f1951F.setVisibility(8);
            }
            View view2 = abstractComponentCallbacksC0427s.f1951F;
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            if (view2.isAttachedToWindow()) {
                AbstractC3113e0.m6130c(abstractComponentCallbacksC0427s.f1951F);
            } else {
                View view3 = abstractComponentCallbacksC0427s.f1951F;
                view3.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC0420o0(view3));
            }
            abstractComponentCallbacksC0427s.mo1307D();
            abstractComponentCallbacksC0427s.f1984u.m1254p(2);
            this.f1931a.m247x(abstractComponentCallbacksC0427s, abstractComponentCallbacksC0427s.f1951F, abstractComponentCallbacksC0427s.f1965b, false);
            int visibility = abstractComponentCallbacksC0427s.f1951F.getVisibility();
            abstractComponentCallbacksC0427s.m1318g().f1929j = abstractComponentCallbacksC0427s.f1951F.getAlpha();
            if (abstractComponentCallbacksC0427s.f1950E != null && visibility == 0) {
                View viewFindFocus = abstractComponentCallbacksC0427s.f1951F.findFocus();
                if (viewFindFocus != null) {
                    abstractComponentCallbacksC0427s.m1318g().f1930k = viewFindFocus;
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + abstractComponentCallbacksC0427s);
                    }
                }
                abstractComponentCallbacksC0427s.f1951F.setAlpha(0.0f);
            }
        }
        abstractComponentCallbacksC0427s.f1964a = 2;
    }

    public final void m1294g() {
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427sM133l;
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = this.f1933c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom CREATED: " + abstractComponentCallbacksC0427s);
        }
        boolean zIsChangingConfigurations = true;
        boolean z7 = abstractComponentCallbacksC0427s.f1976m && abstractComponentCallbacksC0427s.f1981r <= 0;
        C0026b c0026b = this.f1932b;
        if (!z7) {
            C0414l0 c0414l0 = (C0414l0) c0026b.f56d;
            if (!((c0414l0.f1891d.containsKey(abstractComponentCallbacksC0427s.f1969f) && c0414l0.f1894g) ? c0414l0.f1895h : true)) {
                String str = abstractComponentCallbacksC0427s.f1972i;
                if (str != null && (abstractComponentCallbacksC0427sM133l = c0026b.m133l(str)) != null && abstractComponentCallbacksC0427sM133l.f1947B) {
                    abstractComponentCallbacksC0427s.f1971h = abstractComponentCallbacksC0427sM133l;
                }
                abstractComponentCallbacksC0427s.f1964a = 0;
                return;
            }
        }
        C0433v c0433v = abstractComponentCallbacksC0427s.f1983t;
        if (c0433v instanceof InterfaceC0512a1) {
            zIsChangingConfigurations = ((C0414l0) c0026b.f56d).f1895h;
        } else {
            FragmentActivity fragmentActivity = c0433v.f2003g;
            if (fragmentActivity instanceof Activity) {
                zIsChangingConfigurations = true ^ fragmentActivity.isChangingConfigurations();
            }
        }
        if (z7 || zIsChangingConfigurations) {
            C0414l0 c0414l1 = (C0414l0) c0026b.f56d;
            c0414l1.getClass();
            if (Log.isLoggable("FragmentManager", 3)) {
                Log.d("FragmentManager", "Clearing non-config state for " + abstractComponentCallbacksC0427s);
            }
            HashMap map = c0414l1.f1892e;
            C0414l0 c0414l2 = (C0414l0) map.get(abstractComponentCallbacksC0427s.f1969f);
            if (c0414l2 != null) {
                c0414l2.mo1267b();
                map.remove(abstractComponentCallbacksC0427s.f1969f);
            }
            HashMap map2 = c0414l1.f1893f;
            C0562z0 c0562z0 = (C0562z0) map2.get(abstractComponentCallbacksC0427s.f1969f);
            if (c0562z0 != null) {
                c0562z0.m1527a();
                map2.remove(abstractComponentCallbacksC0427s.f1969f);
            }
        }
        abstractComponentCallbacksC0427s.f1984u.m1249k();
        abstractComponentCallbacksC0427s.f1958M.m1521f(EnumC0537n.ON_DESTROY);
        abstractComponentCallbacksC0427s.f1964a = 0;
        abstractComponentCallbacksC0427s.f1949D = false;
        abstractComponentCallbacksC0427s.f1956K = false;
        abstractComponentCallbacksC0427s.mo1330u();
        if (!abstractComponentCallbacksC0427s.f1949D) {
            throw new C0436w0("Fragment " + abstractComponentCallbacksC0427s + " did not call through to super.onDestroy()");
        }
        this.f1931a.m238o(abstractComponentCallbacksC0427s, false);
        for (C0422p0 c0422p0 : c0026b.m138r()) {
            if (c0422p0 != null) {
                String str2 = abstractComponentCallbacksC0427s.f1969f;
                AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = c0422p0.f1933c;
                if (str2.equals(abstractComponentCallbacksC0427s2.f1972i)) {
                    abstractComponentCallbacksC0427s2.f1971h = abstractComponentCallbacksC0427s;
                    abstractComponentCallbacksC0427s2.f1972i = null;
                }
            }
        }
        String str3 = abstractComponentCallbacksC0427s.f1972i;
        if (str3 != null) {
            abstractComponentCallbacksC0427s.f1971h = c0026b.m133l(str3);
        }
        c0026b.m117A(this);
    }

    public final void m1295h() {
        View view;
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = this.f1933c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + abstractComponentCallbacksC0427s);
        }
        ViewGroup viewGroup = abstractComponentCallbacksC0427s.f1950E;
        if (viewGroup != null && (view = abstractComponentCallbacksC0427s.f1951F) != null) {
            viewGroup.removeView(view);
        }
        abstractComponentCallbacksC0427s.f1984u.m1254p(1);
        if (abstractComponentCallbacksC0427s.f1951F != null) {
            C0428s0 c0428s0 = abstractComponentCallbacksC0427s.f1959N;
            c0428s0.m1334g();
            if (c0428s0.f1993d.f2553d.compareTo(EnumC0539o.f2509c) >= 0) {
                abstractComponentCallbacksC0427s.f1959N.m1333b(EnumC0537n.ON_DESTROY);
            }
        }
        abstractComponentCallbacksC0427s.f1964a = 1;
        abstractComponentCallbacksC0427s.f1949D = false;
        abstractComponentCallbacksC0427s.mo1280v();
        if (!abstractComponentCallbacksC0427s.f1949D) {
            throw new C0436w0("Fragment " + abstractComponentCallbacksC0427s + " did not call through to super.onDestroyView()");
        }
        C3348l c3348l = ((C2862b) new C0026b(abstractComponentCallbacksC0427s.mo359e(), C2862b.f9788e).m136o(C2862b.class)).f9789d;
        int i6 = c3348l.f11337c;
        for (int i10 = 0; i10 < i6; i10++) {
            ((AbstractC2861a) c3348l.f11336b[i10]).getClass();
        }
        abstractComponentCallbacksC0427s.f1980q = false;
        this.f1931a.m248y(abstractComponentCallbacksC0427s, false);
        abstractComponentCallbacksC0427s.f1950E = null;
        abstractComponentCallbacksC0427s.f1951F = null;
        abstractComponentCallbacksC0427s.f1959N = null;
        abstractComponentCallbacksC0427s.f1960O.m1490j(null);
        abstractComponentCallbacksC0427s.f1978o = false;
    }

    public final void m1296i() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = this.f1933c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + abstractComponentCallbacksC0427s);
        }
        abstractComponentCallbacksC0427s.f1964a = -1;
        abstractComponentCallbacksC0427s.f1949D = false;
        abstractComponentCallbacksC0427s.mo1281w();
        if (!abstractComponentCallbacksC0427s.f1949D) {
            throw new C0436w0("Fragment " + abstractComponentCallbacksC0427s + " did not call through to super.onDetach()");
        }
        C0412k0 c0412k0 = abstractComponentCallbacksC0427s.f1984u;
        if (!c0412k0.f1854A) {
            c0412k0.m1249k();
            abstractComponentCallbacksC0427s.f1984u = new C0412k0();
        }
        this.f1931a.m239p(abstractComponentCallbacksC0427s, false);
        abstractComponentCallbacksC0427s.f1964a = -1;
        abstractComponentCallbacksC0427s.f1983t = null;
        abstractComponentCallbacksC0427s.f1985v = null;
        abstractComponentCallbacksC0427s.f1982s = null;
        if (!abstractComponentCallbacksC0427s.f1976m || abstractComponentCallbacksC0427s.f1981r > 0) {
            C0414l0 c0414l0 = (C0414l0) this.f1932b.f56d;
            boolean z7 = true;
            if (c0414l0.f1891d.containsKey(abstractComponentCallbacksC0427s.f1969f) && c0414l0.f1894g) {
                z7 = c0414l0.f1895h;
            }
            if (!z7) {
                return;
            }
        }
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "initState called for fragment: " + abstractComponentCallbacksC0427s);
        }
        abstractComponentCallbacksC0427s.f1958M = new C0559y(abstractComponentCallbacksC0427s);
        abstractComponentCallbacksC0427s.f1962Q = new C2888t(abstractComponentCallbacksC0427s);
        abstractComponentCallbacksC0427s.f1961P = null;
        abstractComponentCallbacksC0427s.f1969f = UUID.randomUUID().toString();
        abstractComponentCallbacksC0427s.f1975l = false;
        abstractComponentCallbacksC0427s.f1976m = false;
        abstractComponentCallbacksC0427s.f1977n = false;
        abstractComponentCallbacksC0427s.f1978o = false;
        abstractComponentCallbacksC0427s.f1979p = false;
        abstractComponentCallbacksC0427s.f1981r = 0;
        abstractComponentCallbacksC0427s.f1982s = null;
        abstractComponentCallbacksC0427s.f1984u = new C0412k0();
        abstractComponentCallbacksC0427s.f1983t = null;
        abstractComponentCallbacksC0427s.f1986w = 0;
        abstractComponentCallbacksC0427s.f1987x = 0;
        abstractComponentCallbacksC0427s.f1988y = null;
        abstractComponentCallbacksC0427s.f1989z = false;
        abstractComponentCallbacksC0427s.f1946A = false;
    }

    public final void m1297j() {
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = this.f1933c;
        if (abstractComponentCallbacksC0427s.f1977n && abstractComponentCallbacksC0427s.f1978o && !abstractComponentCallbacksC0427s.f1980q) {
            if (Log.isLoggable("FragmentManager", 3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + abstractComponentCallbacksC0427s);
            }
            abstractComponentCallbacksC0427s.mo1273F(abstractComponentCallbacksC0427s.mo1282x(abstractComponentCallbacksC0427s.f1965b), null, abstractComponentCallbacksC0427s.f1965b);
            View view = abstractComponentCallbacksC0427s.f1951F;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                abstractComponentCallbacksC0427s.f1951F.setTag(R.id.fragment_container_view_tag, abstractComponentCallbacksC0427s);
                if (abstractComponentCallbacksC0427s.f1989z) {
                    abstractComponentCallbacksC0427s.f1951F.setVisibility(8);
                }
                abstractComponentCallbacksC0427s.mo1307D();
                abstractComponentCallbacksC0427s.f1984u.m1254p(2);
                this.f1931a.m247x(abstractComponentCallbacksC0427s, abstractComponentCallbacksC0427s.f1951F, abstractComponentCallbacksC0427s.f1965b, false);
                abstractComponentCallbacksC0427s.f1964a = 2;
            }
        }
    }

    public final void m1298k() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        boolean z7 = this.f1934d;
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = this.f1933c;
        if (z7) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + abstractComponentCallbacksC0427s);
                return;
            }
            return;
        }
        try {
            this.f1934d = true;
            while (true) {
                int iM1291d = m1291d();
                int i6 = abstractComponentCallbacksC0427s.f1964a;
                if (iM1291d == i6) {
                    if (abstractComponentCallbacksC0427s.f1955J) {
                        if (abstractComponentCallbacksC0427s.f1951F != null && (viewGroup = abstractComponentCallbacksC0427s.f1950E) != null) {
                            C0407i c0407iM1206f = C0407i.m1206f(viewGroup, abstractComponentCallbacksC0427s.m1323l().m1220D());
                            if (abstractComponentCallbacksC0427s.f1989z) {
                                c0407iM1206f.getClass();
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + abstractComponentCallbacksC0427s);
                                }
                                c0407iM1206f.m1207a(3, 1, this);
                            } else {
                                c0407iM1206f.getClass();
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + abstractComponentCallbacksC0427s);
                                }
                                c0407iM1206f.m1207a(2, 1, this);
                            }
                        }
                        AbstractC0410j0 abstractC0410j0 = abstractComponentCallbacksC0427s.f1982s;
                        if (abstractC0410j0 != null && abstractComponentCallbacksC0427s.f1975l && AbstractC0410j0.m1213F(abstractComponentCallbacksC0427s)) {
                            abstractC0410j0.f1884x = true;
                        }
                        abstractComponentCallbacksC0427s.f1955J = false;
                    }
                    return;
                }
                if (iM1291d <= i6) {
                    switch (i6 - 1) {
                        case -1:
                            m1296i();
                            break;
                        case 0:
                            m1294g();
                            break;
                        case 1:
                            m1295h();
                            abstractComponentCallbacksC0427s.f1964a = 1;
                            break;
                        case 2:
                            abstractComponentCallbacksC0427s.f1978o = false;
                            abstractComponentCallbacksC0427s.f1964a = 2;
                            break;
                        case 3:
                            if (Log.isLoggable("FragmentManager", 3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + abstractComponentCallbacksC0427s);
                            }
                            if (abstractComponentCallbacksC0427s.f1951F != null && abstractComponentCallbacksC0427s.f1966c == null) {
                                m1303p();
                            }
                            if (abstractComponentCallbacksC0427s.f1951F != null && (viewGroup3 = abstractComponentCallbacksC0427s.f1950E) != null) {
                                C0407i c0407iM1206f2 = C0407i.m1206f(viewGroup3, abstractComponentCallbacksC0427s.m1323l().m1220D());
                                c0407iM1206f2.getClass();
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + abstractComponentCallbacksC0427s);
                                }
                                c0407iM1206f2.m1207a(1, 3, this);
                            }
                            abstractComponentCallbacksC0427s.f1964a = 3;
                            break;
                        case 4:
                            m1305r();
                            break;
                        case 5:
                            abstractComponentCallbacksC0427s.f1964a = 5;
                            break;
                        case 6:
                            m1299l();
                            break;
                    }
                } else {
                    switch (i6 + 1) {
                        case 0:
                            m1290c();
                            break;
                        case 1:
                            m1292e();
                            break;
                        case 2:
                            m1297j();
                            m1293f();
                            break;
                        case 3:
                            m1288a();
                            break;
                        case 4:
                            if (abstractComponentCallbacksC0427s.f1951F != null && (viewGroup2 = abstractComponentCallbacksC0427s.f1950E) != null) {
                                C0407i c0407iM1206f3 = C0407i.m1206f(viewGroup2, abstractComponentCallbacksC0427s.m1323l().m1220D());
                                int iM8b = AbstractC0004e.m8b(abstractComponentCallbacksC0427s.f1951F.getVisibility());
                                c0407iM1206f3.getClass();
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + abstractComponentCallbacksC0427s);
                                }
                                c0407iM1206f3.m1207a(iM8b, 2, this);
                            }
                            abstractComponentCallbacksC0427s.f1964a = 4;
                            break;
                        case 5:
                            m1304q();
                            break;
                        case 6:
                            abstractComponentCallbacksC0427s.f1964a = 6;
                            break;
                        case 7:
                            m1301n();
                            break;
                    }
                }
            }
        } finally {
            this.f1934d = false;
        }
    }

    public final void m1299l() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = this.f1933c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom RESUMED: " + abstractComponentCallbacksC0427s);
        }
        abstractComponentCallbacksC0427s.f1984u.m1254p(5);
        if (abstractComponentCallbacksC0427s.f1951F != null) {
            abstractComponentCallbacksC0427s.f1959N.m1333b(EnumC0537n.ON_PAUSE);
        }
        abstractComponentCallbacksC0427s.f1958M.m1521f(EnumC0537n.ON_PAUSE);
        abstractComponentCallbacksC0427s.f1964a = 6;
        abstractComponentCallbacksC0427s.f1949D = false;
        abstractComponentCallbacksC0427s.mo1331y();
        if (abstractComponentCallbacksC0427s.f1949D) {
            this.f1931a.m240q(abstractComponentCallbacksC0427s, false);
            return;
        }
        throw new C0436w0("Fragment " + abstractComponentCallbacksC0427s + " did not call through to super.onPause()");
    }

    public final void m1300m(ClassLoader classLoader) {
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = this.f1933c;
        Bundle bundle = abstractComponentCallbacksC0427s.f1965b;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        abstractComponentCallbacksC0427s.f1966c = abstractComponentCallbacksC0427s.f1965b.getSparseParcelableArray("android:view_state");
        abstractComponentCallbacksC0427s.f1967d = abstractComponentCallbacksC0427s.f1965b.getBundle("android:view_registry_state");
        abstractComponentCallbacksC0427s.f1972i = abstractComponentCallbacksC0427s.f1965b.getString("android:target_state");
        if (abstractComponentCallbacksC0427s.f1972i != null) {
            abstractComponentCallbacksC0427s.f1973j = abstractComponentCallbacksC0427s.f1965b.getInt("android:target_req_state", 0);
        }
        Boolean bool = abstractComponentCallbacksC0427s.f1968e;
        if (bool != null) {
            abstractComponentCallbacksC0427s.f1953H = bool.booleanValue();
            abstractComponentCallbacksC0427s.f1968e = null;
        } else {
            abstractComponentCallbacksC0427s.f1953H = abstractComponentCallbacksC0427s.f1965b.getBoolean("android:user_visible_hint", true);
        }
        if (abstractComponentCallbacksC0427s.f1953H) {
            return;
        }
        abstractComponentCallbacksC0427s.f1952G = true;
    }

    public final void m1301n() {
        boolean zRequestFocus;
        String str;
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = this.f1933c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "moveto RESUMED: " + abstractComponentCallbacksC0427s);
        }
        C0421p c0421p = abstractComponentCallbacksC0427s.f1954I;
        View view = c0421p == null ? null : c0421p.f1930k;
        if (view != null) {
            if (view == abstractComponentCallbacksC0427s.f1951F) {
                zRequestFocus = view.requestFocus();
                if (Log.isLoggable("FragmentManager", 2)) {
                    StringBuilder sb = new StringBuilder("requestFocus: Restoring focused view ");
                    sb.append(view);
                    sb.append(" ");
                    if (zRequestFocus) {
                        str = "succeeded";
                    } else {
                        str = "failed";
                    }
                    sb.append(str);
                    sb.append(" on Fragment ");
                    sb.append(abstractComponentCallbacksC0427s);
                    sb.append(" resulting in focused view ");
                    sb.append(abstractComponentCallbacksC0427s.f1951F.findFocus());
                    Log.v("FragmentManager", sb.toString());
                }
            } else {
                ViewParent parent = view.getParent();
                while (true) {
                    if (parent != null) {
                        if (parent == abstractComponentCallbacksC0427s.f1951F) {
                            zRequestFocus = view.requestFocus();
                            if (Log.isLoggable("FragmentManager", 2)) {
                                StringBuilder sb2 = new StringBuilder("requestFocus: Restoring focused view ");
                                sb2.append(view);
                                sb2.append(" ");
                                if (zRequestFocus) {
                                    str = "succeeded";
                                } else {
                                    str = "failed";
                                }
                                sb2.append(str);
                                sb2.append(" on Fragment ");
                                sb2.append(abstractComponentCallbacksC0427s);
                                sb2.append(" resulting in focused view ");
                                sb2.append(abstractComponentCallbacksC0427s.f1951F.findFocus());
                                Log.v("FragmentManager", sb2.toString());
                            }
                        } else {
                            parent = parent.getParent();
                        }
                    }
                }
            }
        }
        abstractComponentCallbacksC0427s.m1318g().f1930k = null;
        abstractComponentCallbacksC0427s.f1984u.m1224K();
        abstractComponentCallbacksC0427s.f1984u.m1259u(true);
        abstractComponentCallbacksC0427s.f1964a = 7;
        abstractComponentCallbacksC0427s.f1949D = false;
        abstractComponentCallbacksC0427s.mo1332z();
        if (!abstractComponentCallbacksC0427s.f1949D) {
            throw new C0436w0("Fragment " + abstractComponentCallbacksC0427s + " did not call through to super.onResume()");
        }
        C0559y c0559y = abstractComponentCallbacksC0427s.f1958M;
        EnumC0537n enumC0537n = EnumC0537n.ON_RESUME;
        c0559y.m1521f(enumC0537n);
        if (abstractComponentCallbacksC0427s.f1951F != null) {
            abstractComponentCallbacksC0427s.f1959N.f1993d.m1521f(enumC0537n);
        }
        C0412k0 c0412k0 = abstractComponentCallbacksC0427s.f1984u;
        c0412k0.f1885y = false;
        c0412k0.f1886z = false;
        c0412k0.f1859F.f1896i = false;
        c0412k0.m1254p(7);
        this.f1931a.m243t(abstractComponentCallbacksC0427s, false);
        abstractComponentCallbacksC0427s.f1965b = null;
        abstractComponentCallbacksC0427s.f1966c = null;
        abstractComponentCallbacksC0427s.f1967d = null;
    }

    public final Bundle m1302o() {
        Bundle bundle = new Bundle();
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = this.f1933c;
        abstractComponentCallbacksC0427s.mo1269A(bundle);
        abstractComponentCallbacksC0427s.f1962Q.m5889f(bundle);
        Parcelable parcelableM1230Q = abstractComponentCallbacksC0427s.f1984u.m1230Q();
        if (parcelableM1230Q != null) {
            bundle.putParcelable("android:support:fragments", parcelableM1230Q);
        }
        this.f1931a.m244u(abstractComponentCallbacksC0427s, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (abstractComponentCallbacksC0427s.f1951F != null) {
            m1303p();
        }
        if (abstractComponentCallbacksC0427s.f1966c != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", abstractComponentCallbacksC0427s.f1966c);
        }
        if (abstractComponentCallbacksC0427s.f1967d != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", abstractComponentCallbacksC0427s.f1967d);
        }
        if (!abstractComponentCallbacksC0427s.f1953H) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", abstractComponentCallbacksC0427s.f1953H);
        }
        return bundle;
    }

    public final void m1303p() {
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = this.f1933c;
        if (abstractComponentCallbacksC0427s.f1951F == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        abstractComponentCallbacksC0427s.f1951F.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            abstractComponentCallbacksC0427s.f1966c = sparseArray;
        }
        Bundle bundle = new Bundle();
        abstractComponentCallbacksC0427s.f1959N.f1994e.m5889f(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        abstractComponentCallbacksC0427s.f1967d = bundle;
    }

    public final void m1304q() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = this.f1933c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "moveto STARTED: " + abstractComponentCallbacksC0427s);
        }
        abstractComponentCallbacksC0427s.f1984u.m1224K();
        abstractComponentCallbacksC0427s.f1984u.m1259u(true);
        abstractComponentCallbacksC0427s.f1964a = 5;
        abstractComponentCallbacksC0427s.f1949D = false;
        abstractComponentCallbacksC0427s.mo1270B();
        if (!abstractComponentCallbacksC0427s.f1949D) {
            throw new C0436w0("Fragment " + abstractComponentCallbacksC0427s + " did not call through to super.onStart()");
        }
        C0559y c0559y = abstractComponentCallbacksC0427s.f1958M;
        EnumC0537n enumC0537n = EnumC0537n.ON_START;
        c0559y.m1521f(enumC0537n);
        if (abstractComponentCallbacksC0427s.f1951F != null) {
            abstractComponentCallbacksC0427s.f1959N.f1993d.m1521f(enumC0537n);
        }
        C0412k0 c0412k0 = abstractComponentCallbacksC0427s.f1984u;
        c0412k0.f1885y = false;
        c0412k0.f1886z = false;
        c0412k0.f1859F.f1896i = false;
        c0412k0.m1254p(5);
        this.f1931a.m245v(abstractComponentCallbacksC0427s, false);
    }

    public final void m1305r() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = this.f1933c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom STARTED: " + abstractComponentCallbacksC0427s);
        }
        C0412k0 c0412k0 = abstractComponentCallbacksC0427s.f1984u;
        c0412k0.f1886z = true;
        c0412k0.f1859F.f1896i = true;
        c0412k0.m1254p(4);
        if (abstractComponentCallbacksC0427s.f1951F != null) {
            abstractComponentCallbacksC0427s.f1959N.m1333b(EnumC0537n.ON_STOP);
        }
        abstractComponentCallbacksC0427s.f1958M.m1521f(EnumC0537n.ON_STOP);
        abstractComponentCallbacksC0427s.f1964a = 4;
        abstractComponentCallbacksC0427s.f1949D = false;
        abstractComponentCallbacksC0427s.mo1271C();
        if (abstractComponentCallbacksC0427s.f1949D) {
            this.f1931a.m246w(abstractComponentCallbacksC0427s, false);
            return;
        }
        throw new C0436w0("Fragment " + abstractComponentCallbacksC0427s + " did not call through to super.onStop()");
    }

    public C0422p0(C0069f c0069f, C0026b c0026b, ClassLoader classLoader, C0398d0 c0398d0, FragmentState fragmentState) {
        this.f1931a = c0069f;
        this.f1932b = c0026b;
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427sM1203a = c0398d0.m1203a(fragmentState.f1784a);
        this.f1933c = abstractComponentCallbacksC0427sM1203a;
        Bundle bundle = fragmentState.f1793j;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        abstractComponentCallbacksC0427sM1203a.m1316O(bundle);
        abstractComponentCallbacksC0427sM1203a.f1969f = fragmentState.f1785b;
        abstractComponentCallbacksC0427sM1203a.f1977n = fragmentState.f1786c;
        abstractComponentCallbacksC0427sM1203a.f1979p = true;
        abstractComponentCallbacksC0427sM1203a.f1986w = fragmentState.f1787d;
        abstractComponentCallbacksC0427sM1203a.f1987x = fragmentState.f1788e;
        abstractComponentCallbacksC0427sM1203a.f1988y = fragmentState.f1789f;
        abstractComponentCallbacksC0427sM1203a.f1947B = fragmentState.f1790g;
        abstractComponentCallbacksC0427sM1203a.f1976m = fragmentState.f1791h;
        abstractComponentCallbacksC0427sM1203a.f1946A = fragmentState.f1792i;
        abstractComponentCallbacksC0427sM1203a.f1989z = fragmentState.f1794k;
        abstractComponentCallbacksC0427sM1203a.f1957L = EnumC0539o.values()[fragmentState.f1795l];
        Bundle bundle2 = fragmentState.f1796m;
        if (bundle2 != null) {
            abstractComponentCallbacksC0427sM1203a.f1965b = bundle2;
        } else {
            abstractComponentCallbacksC0427sM1203a.f1965b = new Bundle();
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Instantiated fragment " + abstractComponentCallbacksC0427sM1203a);
        }
    }

    public C0422p0(C0069f c0069f, C0026b c0026b, AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s, FragmentState fragmentState) {
        this.f1931a = c0069f;
        this.f1932b = c0026b;
        this.f1933c = abstractComponentCallbacksC0427s;
        abstractComponentCallbacksC0427s.f1966c = null;
        abstractComponentCallbacksC0427s.f1967d = null;
        abstractComponentCallbacksC0427s.f1981r = 0;
        abstractComponentCallbacksC0427s.f1978o = false;
        abstractComponentCallbacksC0427s.f1975l = false;
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = abstractComponentCallbacksC0427s.f1971h;
        abstractComponentCallbacksC0427s.f1972i = abstractComponentCallbacksC0427s2 != null ? abstractComponentCallbacksC0427s2.f1969f : null;
        abstractComponentCallbacksC0427s.f1971h = null;
        Bundle bundle = fragmentState.f1796m;
        if (bundle != null) {
            abstractComponentCallbacksC0427s.f1965b = bundle;
        } else {
            abstractComponentCallbacksC0427s.f1965b = new Bundle();
        }
    }
}

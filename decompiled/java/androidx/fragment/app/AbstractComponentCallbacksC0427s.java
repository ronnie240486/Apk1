package androidx.fragment.app;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.C0280v;
import androidx.lifecycle.AbstractC0541p;
import androidx.lifecycle.C0518d0;
import androidx.lifecycle.C0548s0;
import androidx.lifecycle.C0559y;
import androidx.lifecycle.C0562z0;
import androidx.lifecycle.EnumC0539o;
import androidx.lifecycle.InterfaceC0512a1;
import androidx.lifecycle.InterfaceC0529j;
import androidx.lifecycle.InterfaceC0555w;
import androidx.lifecycle.InterfaceC0560y0;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import p041d7.AbstractC2177c2;
import p095j1.C2767a;
import p103j9.AbstractC2796i;
import p109k3.C2888t;
import p156o9.AbstractC3281e;
import p227v1.InterfaceC3973e;

public abstract class AbstractComponentCallbacksC0427s implements ComponentCallbacks, View.OnCreateContextMenuListener, InterfaceC0555w, InterfaceC0512a1, InterfaceC0529j, InterfaceC3973e {

    public static final Object f1945S = new Object();

    public boolean f1946A;

    public boolean f1947B;

    public boolean f1949D;

    public ViewGroup f1950E;

    public View f1951F;

    public boolean f1952G;

    public C0421p f1954I;

    public boolean f1955J;

    public boolean f1956K;

    public C0559y f1958M;

    public C0428s0 f1959N;

    public C0548s0 f1961P;

    public C2888t f1962Q;

    public final ArrayList f1963R;

    public Bundle f1965b;

    public SparseArray f1966c;

    public Bundle f1967d;

    public Boolean f1968e;

    public Bundle f1970g;

    public AbstractComponentCallbacksC0427s f1971h;

    public int f1973j;

    public boolean f1975l;

    public boolean f1976m;

    public boolean f1977n;

    public boolean f1978o;

    public boolean f1979p;

    public boolean f1980q;

    public int f1981r;

    public AbstractC0410j0 f1982s;

    public C0433v f1983t;

    public AbstractComponentCallbacksC0427s f1985v;

    public int f1986w;

    public int f1987x;

    public String f1988y;

    public boolean f1989z;

    public int f1964a = -1;

    public String f1969f = UUID.randomUUID().toString();

    public String f1972i = null;

    public Boolean f1974k = null;

    public C0412k0 f1984u = new C0412k0();

    public boolean f1948C = true;

    public boolean f1953H = true;

    public EnumC0539o f1957L = EnumC0539o.f2511e;

    public final C0518d0 f1960O = new C0518d0();

    public AbstractComponentCallbacksC0427s() {
        new AtomicInteger();
        this.f1963R = new ArrayList();
        this.f1958M = new C0559y(this);
        this.f1962Q = new C2888t(this);
        this.f1961P = null;
    }

    public void mo1270B() {
        this.f1949D = true;
    }

    public void mo1271C() {
        this.f1949D = true;
    }

    public void mo1272E(Bundle bundle) {
        this.f1949D = true;
    }

    public void mo1273F(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1984u.m1224K();
        this.f1980q = true;
        this.f1959N = new C0428s0(this, mo359e());
        View viewMo1329t = mo1329t(layoutInflater, viewGroup, bundle);
        this.f1951F = viewMo1329t;
        if (viewMo1329t == null) {
            if (this.f1959N.f1993d != null) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.f1959N = null;
            return;
        }
        this.f1959N.m1334g();
        View view = this.f1951F;
        C0428s0 c0428s0 = this.f1959N;
        AbstractC2796i.m5785f(view, "<this>");
        view.setTag(R.id.view_tree_lifecycle_owner, c0428s0);
        View view2 = this.f1951F;
        C0428s0 c0428s1 = this.f1959N;
        AbstractC2796i.m5785f(view2, "<this>");
        view2.setTag(R.id.view_tree_view_model_store_owner, c0428s1);
        View view3 = this.f1951F;
        C0428s0 c0428s2 = this.f1959N;
        AbstractC2796i.m5785f(view3, "<this>");
        view3.setTag(R.id.view_tree_saved_state_registry_owner, c0428s2);
        this.f1960O.m1490j(this.f1959N);
    }

    public final void m1308G() {
        this.f1949D = true;
        for (AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s : this.f1984u.f1863c.m143w()) {
            if (abstractComponentCallbacksC0427s != null) {
                abstractComponentCallbacksC0427s.m1308G();
            }
        }
    }

    public final void m1309H(boolean z7) {
        for (AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s : this.f1984u.f1863c.m143w()) {
            if (abstractComponentCallbacksC0427s != null) {
                abstractComponentCallbacksC0427s.m1309H(z7);
            }
        }
    }

    public final void m1310I(boolean z7) {
        for (AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s : this.f1984u.f1863c.m143w()) {
            if (abstractComponentCallbacksC0427s != null) {
                abstractComponentCallbacksC0427s.m1310I(z7);
            }
        }
    }

    public final FragmentActivity m1311J() {
        FragmentActivity fragmentActivityM1319h = m1319h();
        if (fragmentActivityM1319h != null) {
            return fragmentActivityM1319h;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Context m1312K() {
        Context contextM1321j = m1321j();
        if (contextM1321j != null) {
            return contextM1321j;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final View m1313L() {
        View view = this.f1951F;
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public final void m1314M(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.f1984u.m1229P(parcelable);
        C0412k0 c0412k0 = this.f1984u;
        c0412k0.f1885y = false;
        c0412k0.f1886z = false;
        c0412k0.f1859F.f1896i = false;
        c0412k0.m1254p(1);
    }

    public final void m1315N(int i6, int i10, int i11, int i12) {
        if (this.f1954I == null && i6 == 0 && i10 == 0 && i11 == 0 && i12 == 0) {
            return;
        }
        m1318g().f1921b = i6;
        m1318g().f1922c = i10;
        m1318g().f1923d = i11;
        m1318g().f1924e = i12;
    }

    public final void m1316O(Bundle bundle) {
        AbstractC0410j0 abstractC0410j0 = this.f1982s;
        if (abstractC0410j0 != null) {
            if (abstractC0410j0 == null ? false : abstractC0410j0.m1222I()) {
                throw new IllegalStateException("Fragment already added and state has been saved");
            }
        }
        this.f1970g = bundle;
    }

    public final void m1317P(boolean z7) {
        boolean z10 = false;
        if (!this.f1953H && z7 && this.f1964a < 5 && this.f1982s != null && m1326o() && this.f1956K) {
            AbstractC0410j0 abstractC0410j0 = this.f1982s;
            C0422p0 c0422p0M1244f = abstractC0410j0.m1244f(this);
            AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = c0422p0M1244f.f1933c;
            if (abstractComponentCallbacksC0427s.f1952G) {
                if (abstractC0410j0.f1862b) {
                    abstractC0410j0.f1855B = true;
                } else {
                    abstractComponentCallbacksC0427s.f1952G = false;
                    c0422p0M1244f.m1298k();
                }
            }
        }
        this.f1953H = z7;
        if (this.f1964a < 5 && !z7) {
            z10 = true;
        }
        this.f1952G = z10;
        if (this.f1965b != null) {
            this.f1968e = Boolean.valueOf(z7);
        }
    }

    @Override
    public final C0280v mo356a() {
        return (C0280v) this.f1962Q.f9833d;
    }

    public AbstractC3281e mo1277b() {
        return new C0417n(this);
    }

    @Override
    public final InterfaceC0560y0 mo357c() {
        Application application;
        if (this.f1982s == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.f1961P == null) {
            Context applicationContext = m1312K().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            if (application == null && Log.isLoggable("FragmentManager", 3)) {
                Log.d("FragmentManager", "Could not find Application instance from Context " + m1312K().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.f1961P = new C0548s0(application, this, this.f1970g);
        }
        return this.f1961P;
    }

    @Override
    public final AbstractC2177c2 mo358d() {
        return C2767a.f9482b;
    }

    @Override
    public final C0562z0 mo359e() {
        if (this.f1982s == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (m1322k() == 1) {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        HashMap map = this.f1982s.f1859F.f1893f;
        C0562z0 c0562z0 = (C0562z0) map.get(this.f1969f);
        if (c0562z0 != null) {
            return c0562z0;
        }
        C0562z0 c0562z1 = new C0562z0();
        map.put(this.f1969f, c0562z1);
        return c0562z1;
    }

    @Override
    public final AbstractC0541p mo360f() {
        return this.f1958M;
    }

    public final C0421p m1318g() {
        if (this.f1954I == null) {
            C0421p c0421p = new C0421p();
            Object obj = f1945S;
            c0421p.f1926g = obj;
            c0421p.f1927h = obj;
            c0421p.f1928i = obj;
            c0421p.f1929j = 1.0f;
            c0421p.f1930k = null;
            this.f1954I = c0421p;
        }
        return this.f1954I;
    }

    public final FragmentActivity m1319h() {
        C0433v c0433v = this.f1983t;
        if (c0433v == null) {
            return null;
        }
        return c0433v.f2002f;
    }

    public final AbstractC0410j0 m1320i() {
        if (this.f1983t != null) {
            return this.f1984u;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public final Context m1321j() {
        C0433v c0433v = this.f1983t;
        if (c0433v == null) {
            return null;
        }
        return c0433v.f2003g;
    }

    public final int m1322k() {
        EnumC0539o enumC0539o = this.f1957L;
        return (enumC0539o == EnumC0539o.f2508b || this.f1985v == null) ? enumC0539o.ordinal() : Math.min(enumC0539o.ordinal(), this.f1985v.m1322k());
    }

    public final AbstractC0410j0 m1323l() {
        AbstractC0410j0 abstractC0410j0 = this.f1982s;
        if (abstractC0410j0 != null) {
            return abstractC0410j0;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public final Resources m1324m() {
        return m1312K().getResources();
    }

    public final String m1325n(int i6) {
        return m1324m().getString(i6);
    }

    public final boolean m1326o() {
        return this.f1983t != null && this.f1975l;
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
        this.f1949D = true;
    }

    @Override
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        m1311J().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override
    public final void onLowMemory() {
        this.f1949D = true;
    }

    public void m1327p(int i6, int i10, Intent intent) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i6 + " resultCode: " + i10 + " data: " + intent);
        }
    }

    public void mo1328q(Activity activity) {
        this.f1949D = true;
    }

    public void mo1278r(FragmentActivity fragmentActivity) {
        this.f1949D = true;
        C0433v c0433v = this.f1983t;
        FragmentActivity fragmentActivity2 = c0433v == null ? null : c0433v.f2002f;
        if (fragmentActivity2 != null) {
            this.f1949D = false;
            mo1328q(fragmentActivity2);
        }
    }

    public void mo1279s(Bundle bundle) {
        this.f1949D = true;
        m1314M(bundle);
        C0412k0 c0412k0 = this.f1984u;
        if (c0412k0.f1873m >= 1) {
            return;
        }
        c0412k0.f1885y = false;
        c0412k0.f1886z = false;
        c0412k0.f1859F.f1896i = false;
        c0412k0.m1254p(1);
    }

    public View mo1329t(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.f1969f);
        if (this.f1986w != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f1986w));
        }
        if (this.f1988y != null) {
            sb.append(" tag=");
            sb.append(this.f1988y);
        }
        sb.append(")");
        return sb.toString();
    }

    public void mo1330u() {
        this.f1949D = true;
    }

    public void mo1280v() {
        this.f1949D = true;
    }

    public void mo1281w() {
        this.f1949D = true;
    }

    public LayoutInflater mo1282x(Bundle bundle) {
        C0433v c0433v = this.f1983t;
        if (c0433v == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        FragmentActivity fragmentActivity = c0433v.f2006j;
        LayoutInflater layoutInflaterCloneInContext = fragmentActivity.getLayoutInflater().cloneInContext(fragmentActivity);
        layoutInflaterCloneInContext.setFactory2(this.f1984u.f1866f);
        return layoutInflaterCloneInContext;
    }

    public void mo1331y() {
        this.f1949D = true;
    }

    public void mo1332z() {
        this.f1949D = true;
    }

    public void mo1307D() {
    }

    public void mo1269A(Bundle bundle) {
    }
}

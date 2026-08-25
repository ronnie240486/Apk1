package androidx.fragment.app;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.AbstractC0541p;
import androidx.lifecycle.EnumC0539o;
import androidx.lifecycle.InterfaceC0512a1;
import androidx.lifecycle.InterfaceC0555w;
import com.p2serv.android.p032ds.R;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import p000a.AbstractC0004e;
import p000a.C0006g;
import p000a.C0011l;
import p000a.C0014o;
import p000a.C0016q;
import p000a.InterfaceC0000a;
import p000a.InterfaceC0017r;
import p002a1.C0026b;
import p007a7.C0069f;
import p022c.InterfaceC1373b;
import p055ea.AbstractC2460q;
import p094j0.AbstractC2754b;
import p156o9.AbstractC3281e;

public abstract class AbstractC0410j0 {

    public boolean f1854A;

    public boolean f1855B;

    public ArrayList f1856C;

    public ArrayList f1857D;

    public ArrayList f1858E;

    public C0414l0 f1859F;

    public final RunnableC0399e f1860G;

    public boolean f1862b;

    public ArrayList f1864d;

    public ArrayList f1865e;

    public C0016q f1867g;

    public final C0069f f1871k;

    public final CopyOnWriteArrayList f1872l;

    public int f1873m;

    public C0433v f1874n;

    public AbstractC3281e f1875o;

    public AbstractComponentCallbacksC0427s f1876p;

    public AbstractComponentCallbacksC0427s f1877q;

    public final C0398d0 f1878r;

    public final C0396c0 f1879s;

    public C0069f f1880t;

    public C0069f f1881u;

    public C0069f f1882v;

    public ArrayDeque f1883w;

    public boolean f1884x;

    public boolean f1885y;

    public boolean f1886z;

    public final ArrayList f1861a = new ArrayList();

    public final C0026b f1863c = new C0026b(7);

    public final LayoutInflaterFactory2C0438y f1866f = new LayoutInflaterFactory2C0438y(this);

    public final C0394b0 f1868h = new C0394b0(this);

    public final AtomicInteger f1869i = new AtomicInteger();

    public final Map f1870j = Collections.synchronizedMap(new HashMap());

    public AbstractC0410j0() {
        Collections.synchronizedMap(new HashMap());
        Collections.synchronizedMap(new HashMap());
        this.f1871k = new C0069f(this);
        this.f1872l = new CopyOnWriteArrayList();
        this.f1873m = -1;
        this.f1878r = new C0398d0(this);
        this.f1879s = new C0396c0();
        this.f1883w = new ArrayDeque();
        this.f1860G = new RunnableC0399e(2, this);
    }

    public static boolean m1213F(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        abstractComponentCallbacksC0427s.getClass();
        C0026b c0026b = abstractComponentCallbacksC0427s.f1984u.f1863c;
        c0026b.getClass();
        ArrayList<AbstractComponentCallbacksC0427s> arrayList = new ArrayList();
        for (C0422p0 c0422p0 : ((HashMap) c0026b.f55c).values()) {
            if (c0422p0 != null) {
                arrayList.add(c0422p0.f1933c);
            } else {
                arrayList.add(null);
            }
        }
        boolean zM1213F = false;
        for (AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 : arrayList) {
            if (abstractComponentCallbacksC0427s2 != null) {
                zM1213F = m1213F(abstractComponentCallbacksC0427s2);
            }
            if (zM1213F) {
                return true;
            }
        }
        return false;
    }

    public static boolean m1214G(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        if (abstractComponentCallbacksC0427s == null) {
            return true;
        }
        return abstractComponentCallbacksC0427s.f1948C && (abstractComponentCallbacksC0427s.f1982s == null || m1214G(abstractComponentCallbacksC0427s.f1985v));
    }

    public static boolean m1215H(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        if (abstractComponentCallbacksC0427s == null) {
            return true;
        }
        AbstractC0410j0 abstractC0410j0 = abstractComponentCallbacksC0427s.f1982s;
        return abstractComponentCallbacksC0427s.equals(abstractC0410j0.f1877q) && m1215H(abstractC0410j0.f1876p);
    }

    public static void m1216W(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "show: " + abstractComponentCallbacksC0427s);
        }
        if (abstractComponentCallbacksC0427s.f1989z) {
            abstractComponentCallbacksC0427s.f1989z = false;
            abstractComponentCallbacksC0427s.f1955J = !abstractComponentCallbacksC0427s.f1955J;
        }
    }

    public final void m1217A() {
        for (C0407i c0407i : m1243e()) {
            if (c0407i.f1850e) {
                c0407i.f1850e = false;
                c0407i.m1209c();
            }
        }
    }

    public final ViewGroup m1218B(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        ViewGroup viewGroup = abstractComponentCallbacksC0427s.f1950E;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (abstractComponentCallbacksC0427s.f1987x > 0 && this.f1875o.mo1266C()) {
            View viewMo1265B = this.f1875o.mo1265B(abstractComponentCallbacksC0427s.f1987x);
            if (viewMo1265B instanceof ViewGroup) {
                return (ViewGroup) viewMo1265B;
            }
        }
        return null;
    }

    public final C0398d0 m1219C() {
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = this.f1876p;
        return abstractComponentCallbacksC0427s != null ? abstractComponentCallbacksC0427s.f1982s.m1219C() : this.f1878r;
    }

    public final C0396c0 m1220D() {
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = this.f1876p;
        return abstractComponentCallbacksC0427s != null ? abstractComponentCallbacksC0427s.f1982s.m1220D() : this.f1879s;
    }

    public final void m1221E(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "hide: " + abstractComponentCallbacksC0427s);
        }
        if (abstractComponentCallbacksC0427s.f1989z) {
            return;
        }
        abstractComponentCallbacksC0427s.f1989z = true;
        abstractComponentCallbacksC0427s.f1955J = true ^ abstractComponentCallbacksC0427s.f1955J;
        m1235V(abstractComponentCallbacksC0427s);
    }

    public final boolean m1222I() {
        return this.f1885y || this.f1886z;
    }

    public final void m1223J(int i6, boolean z7) {
        HashMap map;
        C0433v c0433v;
        if (this.f1874n == null && i6 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z7 || i6 != this.f1873m) {
            this.f1873m = i6;
            C0026b c0026b = this.f1863c;
            Iterator it = ((ArrayList) c0026b.f54b).iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                map = (HashMap) c0026b.f55c;
                if (!zHasNext) {
                    break;
                }
                C0422p0 c0422p0 = (C0422p0) map.get(((AbstractComponentCallbacksC0427s) it.next()).f1969f);
                if (c0422p0 != null) {
                    c0422p0.m1298k();
                }
            }
            for (C0422p0 c0422p1 : map.values()) {
                if (c0422p1 != null) {
                    c0422p1.m1298k();
                    AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = c0422p1.f1933c;
                    if (abstractComponentCallbacksC0427s.f1976m && abstractComponentCallbacksC0427s.f1981r <= 0) {
                        c0026b.m117A(c0422p1);
                    }
                }
            }
            m1236X();
            if (this.f1884x && (c0433v = this.f1874n) != null && this.f1873m == 7) {
                c0433v.f2006j.mo363g();
                this.f1884x = false;
            }
        }
    }

    public final void m1224K() {
        if (this.f1874n == null) {
            return;
        }
        this.f1885y = false;
        this.f1886z = false;
        this.f1859F.f1896i = false;
        for (AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s : this.f1863c.m143w()) {
            if (abstractComponentCallbacksC0427s != null) {
                abstractComponentCallbacksC0427s.f1984u.m1224K();
            }
        }
    }

    public final boolean m1225L() {
        m1259u(false);
        m1258t(true);
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = this.f1877q;
        if (abstractComponentCallbacksC0427s != null && abstractComponentCallbacksC0427s.m1320i().m1225L()) {
            return true;
        }
        boolean zM1226M = m1226M(this.f1856C, this.f1857D, -1, 0);
        if (zM1226M) {
            this.f1862b = true;
            try {
                m1228O(this.f1856C, this.f1857D);
                m1242d();
            } catch (Throwable th) {
                m1242d();
                throw th;
            }
        }
        m1238Z();
        m1255q();
        ((HashMap) this.f1863c.f55c).values().removeAll(Collections.singleton(null));
        return zM1226M;
    }

    public final boolean m1226M(ArrayList arrayList, ArrayList arrayList2, int i6, int i10) {
        int size;
        C0391a c0391a;
        ArrayList arrayList3 = this.f1864d;
        if (arrayList3 == null) {
            return false;
        }
        if (i6 >= 0 || (i10 & 1) != 0) {
            if (i6 >= 0) {
                size = arrayList3.size() - 1;
                while (size >= 0) {
                    C0391a c0391a2 = (C0391a) this.f1864d.get(size);
                    if (i6 >= 0 && i6 == c0391a2.f1819s) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    return false;
                }
                if ((i10 & 1) != 0) {
                    do {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        c0391a = (C0391a) this.f1864d.get(size);
                        if (i6 < 0) {
                            break;
                        }
                    } while (i6 == c0391a.f1819s);
                }
            } else {
                size = -1;
            }
            if (size == this.f1864d.size() - 1) {
                return false;
            }
            for (int size2 = this.f1864d.size() - 1; size2 > size; size2--) {
                arrayList.add(this.f1864d.remove(size2));
                arrayList2.add(Boolean.TRUE);
            }
        } else {
            int size3 = arrayList3.size() - 1;
            if (size3 < 0) {
                return false;
            }
            arrayList.add(this.f1864d.remove(size3));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void m1227N(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "remove: " + abstractComponentCallbacksC0427s + " nesting=" + abstractComponentCallbacksC0427s.f1981r);
        }
        boolean z7 = abstractComponentCallbacksC0427s.f1981r > 0;
        if (abstractComponentCallbacksC0427s.f1946A && z7) {
            return;
        }
        C0026b c0026b = this.f1863c;
        synchronized (((ArrayList) c0026b.f54b)) {
            ((ArrayList) c0026b.f54b).remove(abstractComponentCallbacksC0427s);
        }
        abstractComponentCallbacksC0427s.f1975l = false;
        if (m1213F(abstractComponentCallbacksC0427s)) {
            this.f1884x = true;
        }
        abstractComponentCallbacksC0427s.f1976m = true;
        m1235V(abstractComponentCallbacksC0427s);
    }

    public final void m1228O(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i6 = 0;
        int i10 = 0;
        while (i6 < size) {
            if (!((C0391a) arrayList.get(i6)).f1816p) {
                if (i10 != i6) {
                    m1261w(arrayList, arrayList2, i10, i6);
                }
                i10 = i6 + 1;
                if (((Boolean) arrayList2.get(i6)).booleanValue()) {
                    while (i10 < size && ((Boolean) arrayList2.get(i10)).booleanValue() && !((C0391a) arrayList.get(i10)).f1816p) {
                        i10++;
                    }
                }
                m1261w(arrayList, arrayList2, i6, i10);
                i6 = i10 - 1;
            }
            i6++;
        }
        if (i10 != size) {
            m1261w(arrayList, arrayList2, i10, size);
        }
    }

    public final void m1229P(Parcelable parcelable) {
        int i6;
        C0069f c0069f;
        int i10;
        C0422p0 c0422p0;
        if (parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.f1776a == null) {
            return;
        }
        C0026b c0026b = this.f1863c;
        ((HashMap) c0026b.f55c).clear();
        Iterator it = fragmentManagerState.f1776a.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            i6 = 2;
            c0069f = this.f1871k;
            if (!zHasNext) {
                break;
            }
            FragmentState fragmentState = (FragmentState) it.next();
            if (fragmentState != null) {
                AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = (AbstractComponentCallbacksC0427s) this.f1859F.f1891d.get(fragmentState.f1785b);
                if (abstractComponentCallbacksC0427s != null) {
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + abstractComponentCallbacksC0427s);
                    }
                    c0422p0 = new C0422p0(c0069f, c0026b, abstractComponentCallbacksC0427s, fragmentState);
                } else {
                    c0422p0 = new C0422p0(this.f1871k, this.f1863c, this.f1874n.f2003g.getClassLoader(), m1219C(), fragmentState);
                }
                AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = c0422p0.f1933c;
                abstractComponentCallbacksC0427s2.f1982s = this;
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + abstractComponentCallbacksC0427s2.f1969f + "): " + abstractComponentCallbacksC0427s2);
                }
                c0422p0.m1300m(this.f1874n.f2003g.getClassLoader());
                c0026b.m145z(c0422p0);
                c0422p0.f1935e = this.f1873m;
            }
        }
        C0414l0 c0414l0 = this.f1859F;
        c0414l0.getClass();
        for (AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s3 : new ArrayList(c0414l0.f1891d.values())) {
            if (!(((HashMap) c0026b.f55c).get(abstractComponentCallbacksC0427s3.f1969f) != null)) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + abstractComponentCallbacksC0427s3 + " that was not found in the set of active Fragments " + fragmentManagerState.f1776a);
                }
                this.f1859F.m1268c(abstractComponentCallbacksC0427s3);
                abstractComponentCallbacksC0427s3.f1982s = this;
                C0422p0 c0422p1 = new C0422p0(c0069f, c0026b, abstractComponentCallbacksC0427s3);
                c0422p1.f1935e = 1;
                c0422p1.m1298k();
                abstractComponentCallbacksC0427s3.f1976m = true;
                c0422p1.m1298k();
            }
        }
        ArrayList<String> arrayList = fragmentManagerState.f1777b;
        ((ArrayList) c0026b.f54b).clear();
        if (arrayList != null) {
            for (String str : arrayList) {
                AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427sM133l = c0026b.m133l(str);
                if (abstractComponentCallbacksC0427sM133l == null) {
                    throw new IllegalStateException(AbstractC0004e.m24r("No instantiated fragment for (", str, ")"));
                }
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + abstractComponentCallbacksC0427sM133l);
                }
                c0026b.m128f(abstractComponentCallbacksC0427sM133l);
            }
        }
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s4 = null;
        if (fragmentManagerState.f1778c != null) {
            this.f1864d = new ArrayList(fragmentManagerState.f1778c.length);
            int i11 = 0;
            while (true) {
                BackStackState[] backStackStateArr = fragmentManagerState.f1778c;
                if (i11 >= backStackStateArr.length) {
                    break;
                }
                BackStackState backStackState = backStackStateArr[i11];
                backStackState.getClass();
                C0391a c0391a = new C0391a(this);
                int i12 = 0;
                int i13 = 0;
                while (true) {
                    int[] iArr = backStackState.f1750a;
                    if (i12 >= iArr.length) {
                        break;
                    }
                    C0426r0 c0426r0 = new C0426r0();
                    int i14 = i12 + 1;
                    c0426r0.f1937a = iArr[i12];
                    if (Log.isLoggable("FragmentManager", i6)) {
                        Log.v("FragmentManager", "Instantiate " + c0391a + " op #" + i13 + " base fragment #" + iArr[i14]);
                    }
                    String str2 = (String) backStackState.f1751b.get(i13);
                    if (str2 != null) {
                        c0426r0.f1938b = c0026b.m133l(str2);
                    } else {
                        c0426r0.f1938b = abstractComponentCallbacksC0427s4;
                    }
                    c0426r0.f1943g = EnumC0539o.values()[backStackState.f1752c[i13]];
                    c0426r0.f1944h = EnumC0539o.values()[backStackState.f1753d[i13]];
                    int i15 = iArr[i14];
                    c0426r0.f1939c = i15;
                    int i16 = iArr[i12 + 2];
                    c0426r0.f1940d = i16;
                    int i17 = i12 + 4;
                    int i18 = iArr[i12 + 3];
                    c0426r0.f1941e = i18;
                    i12 += 5;
                    int i19 = iArr[i17];
                    c0426r0.f1942f = i19;
                    c0391a.f1802b = i15;
                    c0391a.f1803c = i16;
                    c0391a.f1804d = i18;
                    c0391a.f1805e = i19;
                    c0391a.m1187b(c0426r0);
                    i13++;
                    abstractComponentCallbacksC0427s4 = null;
                    i6 = 2;
                }
                c0391a.f1806f = backStackState.f1754e;
                c0391a.f1809i = backStackState.f1755f;
                c0391a.f1819s = backStackState.f1756g;
                c0391a.f1807g = true;
                c0391a.f1810j = backStackState.f1757h;
                c0391a.f1811k = backStackState.f1758i;
                c0391a.f1812l = backStackState.f1759j;
                c0391a.f1813m = backStackState.f1760k;
                c0391a.f1814n = backStackState.f1761l;
                c0391a.f1815o = backStackState.f1762m;
                c0391a.f1816p = backStackState.f1763n;
                c0391a.m1189d(1);
                if (Log.isLoggable("FragmentManager", 2)) {
                    StringBuilder sbM27u = AbstractC0004e.m27u(i11, "restoreAllState: back stack #", " (index ");
                    sbM27u.append(c0391a.f1819s);
                    sbM27u.append("): ");
                    sbM27u.append(c0391a);
                    Log.v("FragmentManager", sbM27u.toString());
                    PrintWriter printWriter = new PrintWriter(new C0430t0());
                    c0391a.m1192g("  ", printWriter, false);
                    printWriter.close();
                }
                this.f1864d.add(c0391a);
                i11++;
                abstractComponentCallbacksC0427s4 = null;
                i6 = 2;
            }
            i10 = 0;
        } else {
            i10 = 0;
            this.f1864d = null;
        }
        this.f1869i.set(fragmentManagerState.f1779d);
        String str3 = fragmentManagerState.f1780e;
        if (str3 != null) {
            AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427sM133l2 = c0026b.m133l(str3);
            this.f1877q = abstractComponentCallbacksC0427sM133l2;
            m1252n(abstractComponentCallbacksC0427sM133l2);
        }
        ArrayList arrayList2 = fragmentManagerState.f1781f;
        if (arrayList2 != null) {
            while (i10 < arrayList2.size()) {
                Bundle bundle = (Bundle) fragmentManagerState.f1782g.get(i10);
                bundle.setClassLoader(this.f1874n.f2003g.getClassLoader());
                this.f1870j.put(arrayList2.get(i10), bundle);
                i10++;
            }
        }
        this.f1883w = new ArrayDeque(fragmentManagerState.f1783h);
    }

    public final Parcelable m1230Q() {
        ArrayList arrayList;
        BackStackState[] backStackStateArr;
        int size;
        m1217A();
        Iterator it = m1243e().iterator();
        while (it.hasNext()) {
            ((C0407i) it.next()).m1211e();
        }
        m1259u(true);
        this.f1885y = true;
        this.f1859F.f1896i = true;
        C0026b c0026b = this.f1863c;
        c0026b.getClass();
        HashMap map = (HashMap) c0026b.f55c;
        ArrayList arrayList2 = new ArrayList(map.size());
        for (C0422p0 c0422p0 : map.values()) {
            if (c0422p0 != null) {
                AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = c0422p0.f1933c;
                FragmentState fragmentState = new FragmentState(abstractComponentCallbacksC0427s);
                if (abstractComponentCallbacksC0427s.f1964a <= -1 || fragmentState.f1796m != null) {
                    fragmentState.f1796m = abstractComponentCallbacksC0427s.f1965b;
                } else {
                    Bundle bundleM1302o = c0422p0.m1302o();
                    fragmentState.f1796m = bundleM1302o;
                    if (abstractComponentCallbacksC0427s.f1972i != null) {
                        if (bundleM1302o == null) {
                            fragmentState.f1796m = new Bundle();
                        }
                        fragmentState.f1796m.putString("android:target_state", abstractComponentCallbacksC0427s.f1972i);
                        int i6 = abstractComponentCallbacksC0427s.f1973j;
                        if (i6 != 0) {
                            fragmentState.f1796m.putInt("android:target_req_state", i6);
                        }
                    }
                }
                arrayList2.add(fragmentState);
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "Saved state of " + abstractComponentCallbacksC0427s + ": " + fragmentState.f1796m);
                }
            }
        }
        if (arrayList2.isEmpty()) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        C0026b c0026b2 = this.f1863c;
        synchronized (((ArrayList) c0026b2.f54b)) {
            try {
                if (((ArrayList) c0026b2.f54b).isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(((ArrayList) c0026b2.f54b).size());
                    for (AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 : (ArrayList) c0026b2.f54b) {
                        arrayList.add(abstractComponentCallbacksC0427s2.f1969f);
                        if (Log.isLoggable("FragmentManager", 2)) {
                            Log.v("FragmentManager", "saveAllState: adding fragment (" + abstractComponentCallbacksC0427s2.f1969f + "): " + abstractComponentCallbacksC0427s2);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ArrayList arrayList3 = this.f1864d;
        if (arrayList3 == null || (size = arrayList3.size()) <= 0) {
            backStackStateArr = null;
        } else {
            backStackStateArr = new BackStackState[size];
            for (int i10 = 0; i10 < size; i10++) {
                backStackStateArr[i10] = new BackStackState((C0391a) this.f1864d.get(i10));
                if (Log.isLoggable("FragmentManager", 2)) {
                    StringBuilder sbM27u = AbstractC0004e.m27u(i10, "saveAllState: adding back stack #", ": ");
                    sbM27u.append(this.f1864d.get(i10));
                    Log.v("FragmentManager", sbM27u.toString());
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f1780e = null;
        ArrayList arrayList4 = new ArrayList();
        fragmentManagerState.f1781f = arrayList4;
        ArrayList arrayList5 = new ArrayList();
        fragmentManagerState.f1782g = arrayList5;
        fragmentManagerState.f1776a = arrayList2;
        fragmentManagerState.f1777b = arrayList;
        fragmentManagerState.f1778c = backStackStateArr;
        fragmentManagerState.f1779d = this.f1869i.get();
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s3 = this.f1877q;
        if (abstractComponentCallbacksC0427s3 != null) {
            fragmentManagerState.f1780e = abstractComponentCallbacksC0427s3.f1969f;
        }
        arrayList4.addAll(this.f1870j.keySet());
        arrayList5.addAll(this.f1870j.values());
        fragmentManagerState.f1783h = new ArrayList(this.f1883w);
        return fragmentManagerState;
    }

    public final void m1231R() {
        synchronized (this.f1861a) {
            try {
                if (this.f1861a.size() == 1) {
                    this.f1874n.f2004h.removeCallbacks(this.f1860G);
                    this.f1874n.f2004h.post(this.f1860G);
                    m1238Z();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m1232S(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s, boolean z7) {
        ViewGroup viewGroupM1218B = m1218B(abstractComponentCallbacksC0427s);
        if (viewGroupM1218B == null || !(viewGroupM1218B instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupM1218B).setDrawDisappearingViewsLast(!z7);
    }

    public final void m1233T(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s, EnumC0539o enumC0539o) {
        if (abstractComponentCallbacksC0427s.equals(this.f1863c.m133l(abstractComponentCallbacksC0427s.f1969f)) && (abstractComponentCallbacksC0427s.f1983t == null || abstractComponentCallbacksC0427s.f1982s == this)) {
            abstractComponentCallbacksC0427s.f1957L = enumC0539o;
            return;
        }
        throw new IllegalArgumentException("Fragment " + abstractComponentCallbacksC0427s + " is not an active fragment of FragmentManager " + this);
    }

    public final void m1234U(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        if (abstractComponentCallbacksC0427s != null) {
            if (!abstractComponentCallbacksC0427s.equals(this.f1863c.m133l(abstractComponentCallbacksC0427s.f1969f)) || (abstractComponentCallbacksC0427s.f1983t != null && abstractComponentCallbacksC0427s.f1982s != this)) {
                throw new IllegalArgumentException("Fragment " + abstractComponentCallbacksC0427s + " is not an active fragment of FragmentManager " + this);
            }
        }
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = this.f1877q;
        this.f1877q = abstractComponentCallbacksC0427s;
        m1252n(abstractComponentCallbacksC0427s2);
        m1252n(this.f1877q);
    }

    public final void m1235V(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        ViewGroup viewGroupM1218B = m1218B(abstractComponentCallbacksC0427s);
        if (viewGroupM1218B != null) {
            C0421p c0421p = abstractComponentCallbacksC0427s.f1954I;
            if ((c0421p == null ? 0 : c0421p.f1924e) + (c0421p == null ? 0 : c0421p.f1923d) + (c0421p == null ? 0 : c0421p.f1922c) + (c0421p == null ? 0 : c0421p.f1921b) > 0) {
                if (viewGroupM1218B.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                    viewGroupM1218B.setTag(R.id.visible_removing_fragment_view_tag, abstractComponentCallbacksC0427s);
                }
                AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = (AbstractComponentCallbacksC0427s) viewGroupM1218B.getTag(R.id.visible_removing_fragment_view_tag);
                C0421p c0421p2 = abstractComponentCallbacksC0427s.f1954I;
                boolean z7 = c0421p2 != null ? c0421p2.f1920a : false;
                if (abstractComponentCallbacksC0427s2.f1954I == null) {
                    return;
                }
                abstractComponentCallbacksC0427s2.m1318g().f1920a = z7;
            }
        }
    }

    public final void m1236X() {
        for (C0422p0 c0422p0 : this.f1863c.m138r()) {
            AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = c0422p0.f1933c;
            if (abstractComponentCallbacksC0427s.f1952G) {
                if (this.f1862b) {
                    this.f1855B = true;
                } else {
                    abstractComponentCallbacksC0427s.f1952G = false;
                    c0422p0.m1298k();
                }
            }
        }
    }

    public final void m1237Y(IllegalStateException illegalStateException) {
        Log.e("FragmentManager", illegalStateException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C0430t0());
        C0433v c0433v = this.f1874n;
        if (c0433v == null) {
            try {
                m1256r("  ", null, printWriter, new String[0]);
                throw illegalStateException;
            } catch (Exception e5) {
                Log.e("FragmentManager", "Failed dumping state", e5);
                throw illegalStateException;
            }
        }
        try {
            c0433v.f2006j.dump("  ", null, printWriter, new String[0]);
            throw illegalStateException;
        } catch (Exception e10) {
            Log.e("FragmentManager", "Failed dumping state", e10);
            throw illegalStateException;
        }
    }

    public final void m1238Z() {
        synchronized (this.f1861a) {
            try {
                if (!this.f1861a.isEmpty()) {
                    C0394b0 c0394b0 = this.f1868h;
                    c0394b0.f1823a = true;
                    C0011l c0011l = c0394b0.f1825c;
                    if (c0011l != null) {
                        c0011l.accept(Boolean.TRUE);
                    }
                    return;
                }
                C0394b0 c0394b1 = this.f1868h;
                ArrayList arrayList = this.f1864d;
                boolean z7 = (arrayList != null ? arrayList.size() : 0) > 0 && m1215H(this.f1876p);
                c0394b1.f1823a = z7;
                C0011l c0011l2 = c0394b1.f1825c;
                if (c0011l2 != null) {
                    c0011l2.accept(Boolean.valueOf(z7));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final C0422p0 m1239a(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "add: " + abstractComponentCallbacksC0427s);
        }
        C0422p0 c0422p0M1244f = m1244f(abstractComponentCallbacksC0427s);
        abstractComponentCallbacksC0427s.f1982s = this;
        C0026b c0026b = this.f1863c;
        c0026b.m145z(c0422p0M1244f);
        if (!abstractComponentCallbacksC0427s.f1946A) {
            c0026b.m128f(abstractComponentCallbacksC0427s);
            abstractComponentCallbacksC0427s.f1976m = false;
            if (abstractComponentCallbacksC0427s.f1951F == null) {
                abstractComponentCallbacksC0427s.f1955J = false;
            }
            if (m1213F(abstractComponentCallbacksC0427s)) {
                this.f1884x = true;
            }
        }
        return c0422p0M1244f;
    }

    public final void m1240b(C0433v c0433v, AbstractC3281e abstractC3281e, AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        if (this.f1874n != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f1874n = c0433v;
        this.f1875o = abstractC3281e;
        this.f1876p = abstractComponentCallbacksC0427s;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f1872l;
        if (abstractComponentCallbacksC0427s != null) {
            copyOnWriteArrayList.add(new C0400e0(abstractComponentCallbacksC0427s));
        } else if (c0433v instanceof InterfaceC0416m0) {
            copyOnWriteArrayList.add(c0433v);
        }
        if (this.f1876p != null) {
            m1238Z();
        }
        if (c0433v instanceof InterfaceC0017r) {
            C0016q c0016q = c0433v.f2006j.f232h;
            this.f1867g = c0016q;
            InterfaceC0555w interfaceC0555w = abstractComponentCallbacksC0427s != null ? abstractComponentCallbacksC0427s : c0433v;
            c0016q.getClass();
            AbstractC0541p abstractC0541pMo360f = interfaceC0555w.mo360f();
            if (abstractC0541pMo360f.mo1509b() != EnumC0539o.f2507a) {
                C0394b0 c0394b0 = this.f1868h;
                c0394b0.f1824b.add(new C0014o(c0016q, abstractC0541pMo360f, c0394b0));
                if (AbstractC2754b.m5721a()) {
                    c0016q.m51d();
                    c0394b0.f1825c = (C0011l) c0016q.f34d;
                }
            }
        }
        if (abstractComponentCallbacksC0427s != null) {
            C0414l0 c0414l0 = abstractComponentCallbacksC0427s.f1982s.f1859F;
            HashMap map = c0414l0.f1892e;
            C0414l0 c0414l1 = (C0414l0) map.get(abstractComponentCallbacksC0427s.f1969f);
            if (c0414l1 == null) {
                c0414l1 = new C0414l0(c0414l0.f1894g);
                map.put(abstractComponentCallbacksC0427s.f1969f, c0414l1);
            }
            this.f1859F = c0414l1;
        } else if (c0433v instanceof InterfaceC0512a1) {
            this.f1859F = (C0414l0) new C0026b(c0433v.f2006j.mo359e(), C0414l0.f1890j).m136o(C0414l0.class);
        } else {
            this.f1859F = new C0414l0(false);
        }
        this.f1859F.f1896i = m1222I();
        this.f1863c.f56d = this.f1859F;
        C0433v c0433v2 = this.f1874n;
        if (c0433v2 instanceof InterfaceC1373b) {
            C0006g c0006g = c0433v2.f2006j.f233i;
            String strM5501o = AbstractC2460q.m5501o("FragmentManager:", abstractComponentCallbacksC0427s != null ? AbstractC0004e.m26t(new StringBuilder(), abstractComponentCallbacksC0427s.f1969f, ":") : "");
            this.f1880t = c0006g.m34b(AbstractC2460q.m5494h(strM5501o, "StartActivityForResult"), new C0402f0(2), new C0392a0(this, 2));
            this.f1881u = c0006g.m34b(AbstractC2460q.m5494h(strM5501o, "StartIntentSenderForResult"), new C0402f0(0), new C0392a0(this, 0));
            this.f1882v = c0006g.m34b(AbstractC2460q.m5494h(strM5501o, "RequestPermissions"), new C0402f0(1), new C0392a0(this, 1));
        }
    }

    public final void m1241c(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "attach: " + abstractComponentCallbacksC0427s);
        }
        if (abstractComponentCallbacksC0427s.f1946A) {
            abstractComponentCallbacksC0427s.f1946A = false;
            if (abstractComponentCallbacksC0427s.f1975l) {
                return;
            }
            this.f1863c.m128f(abstractComponentCallbacksC0427s);
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "add from attach: " + abstractComponentCallbacksC0427s);
            }
            if (m1213F(abstractComponentCallbacksC0427s)) {
                this.f1884x = true;
            }
        }
    }

    public final void m1242d() {
        this.f1862b = false;
        this.f1857D.clear();
        this.f1856C.clear();
    }

    public final HashSet m1243e() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f1863c.m138r().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((C0422p0) it.next()).f1933c.f1950E;
            if (viewGroup != null) {
                hashSet.add(C0407i.m1206f(viewGroup, m1220D()));
            }
        }
        return hashSet;
    }

    public final C0422p0 m1244f(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        String str = abstractComponentCallbacksC0427s.f1969f;
        C0026b c0026b = this.f1863c;
        C0422p0 c0422p0 = (C0422p0) ((HashMap) c0026b.f55c).get(str);
        if (c0422p0 != null) {
            return c0422p0;
        }
        C0422p0 c0422p1 = new C0422p0(this.f1871k, c0026b, abstractComponentCallbacksC0427s);
        c0422p1.m1300m(this.f1874n.f2003g.getClassLoader());
        c0422p1.f1935e = this.f1873m;
        return c0422p1;
    }

    public final void m1245g(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "detach: " + abstractComponentCallbacksC0427s);
        }
        if (abstractComponentCallbacksC0427s.f1946A) {
            return;
        }
        abstractComponentCallbacksC0427s.f1946A = true;
        if (abstractComponentCallbacksC0427s.f1975l) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "remove from detach: " + abstractComponentCallbacksC0427s);
            }
            C0026b c0026b = this.f1863c;
            synchronized (((ArrayList) c0026b.f54b)) {
                ((ArrayList) c0026b.f54b).remove(abstractComponentCallbacksC0427s);
            }
            abstractComponentCallbacksC0427s.f1975l = false;
            if (m1213F(abstractComponentCallbacksC0427s)) {
                this.f1884x = true;
            }
            m1235V(abstractComponentCallbacksC0427s);
        }
    }

    public final void m1246h(Configuration configuration) {
        for (AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s : this.f1863c.m143w()) {
            if (abstractComponentCallbacksC0427s != null) {
                abstractComponentCallbacksC0427s.onConfigurationChanged(configuration);
                abstractComponentCallbacksC0427s.f1984u.m1246h(configuration);
            }
        }
    }

    public final boolean m1247i() {
        if (this.f1873m < 1) {
            return false;
        }
        for (AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s : this.f1863c.m143w()) {
            if (abstractComponentCallbacksC0427s != null) {
                if (!abstractComponentCallbacksC0427s.f1989z ? abstractComponentCallbacksC0427s.f1984u.m1247i() : false) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean m1248j() {
        if (this.f1873m < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z7 = false;
        for (AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s : this.f1863c.m143w()) {
            if (abstractComponentCallbacksC0427s != null && m1214G(abstractComponentCallbacksC0427s)) {
                if (!abstractComponentCallbacksC0427s.f1989z ? abstractComponentCallbacksC0427s.f1984u.m1248j() : false) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(abstractComponentCallbacksC0427s);
                    z7 = true;
                }
            }
        }
        if (this.f1865e != null) {
            for (int i6 = 0; i6 < this.f1865e.size(); i6++) {
                AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = (AbstractComponentCallbacksC0427s) this.f1865e.get(i6);
                if (arrayList == null || !arrayList.contains(abstractComponentCallbacksC0427s2)) {
                    abstractComponentCallbacksC0427s2.getClass();
                }
            }
        }
        this.f1865e = arrayList;
        return z7;
    }

    public final void m1249k() {
        this.f1854A = true;
        m1259u(true);
        Iterator it = m1243e().iterator();
        while (it.hasNext()) {
            ((C0407i) it.next()).m1211e();
        }
        m1254p(-1);
        this.f1874n = null;
        this.f1875o = null;
        this.f1876p = null;
        if (this.f1867g != null) {
            Iterator it2 = this.f1868h.f1824b.iterator();
            while (it2.hasNext()) {
                ((InterfaceC0000a) it2.next()).cancel();
            }
            this.f1867g = null;
        }
        C0069f c0069f = this.f1880t;
        if (c0069f != null) {
            c0069f.m225H();
            this.f1881u.m225H();
            this.f1882v.m225H();
        }
    }

    public final boolean m1250l() {
        if (this.f1873m < 1) {
            return false;
        }
        for (AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s : this.f1863c.m143w()) {
            if (abstractComponentCallbacksC0427s != null) {
                if (!abstractComponentCallbacksC0427s.f1989z ? abstractComponentCallbacksC0427s.f1984u.m1250l() : false) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void m1251m() {
        if (this.f1873m < 1) {
            return;
        }
        for (AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s : this.f1863c.m143w()) {
            if (abstractComponentCallbacksC0427s != null && !abstractComponentCallbacksC0427s.f1989z) {
                abstractComponentCallbacksC0427s.f1984u.m1251m();
            }
        }
    }

    public final void m1252n(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        if (abstractComponentCallbacksC0427s != null) {
            if (abstractComponentCallbacksC0427s.equals(this.f1863c.m133l(abstractComponentCallbacksC0427s.f1969f))) {
                abstractComponentCallbacksC0427s.f1982s.getClass();
                boolean zM1215H = m1215H(abstractComponentCallbacksC0427s);
                Boolean bool = abstractComponentCallbacksC0427s.f1974k;
                if (bool == null || bool.booleanValue() != zM1215H) {
                    abstractComponentCallbacksC0427s.f1974k = Boolean.valueOf(zM1215H);
                    C0412k0 c0412k0 = abstractComponentCallbacksC0427s.f1984u;
                    c0412k0.m1238Z();
                    c0412k0.m1252n(c0412k0.f1877q);
                }
            }
        }
    }

    public final boolean m1253o() {
        boolean z7 = false;
        if (this.f1873m < 1) {
            return false;
        }
        for (AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s : this.f1863c.m143w()) {
            if (abstractComponentCallbacksC0427s != null && m1214G(abstractComponentCallbacksC0427s)) {
                if (!abstractComponentCallbacksC0427s.f1989z ? abstractComponentCallbacksC0427s.f1984u.m1253o() : false) {
                    z7 = true;
                }
            }
        }
        return z7;
    }

    public final void m1254p(int i6) {
        try {
            this.f1862b = true;
            for (C0422p0 c0422p0 : ((HashMap) this.f1863c.f55c).values()) {
                if (c0422p0 != null) {
                    c0422p0.f1935e = i6;
                }
            }
            m1223J(i6, false);
            Iterator it = m1243e().iterator();
            while (it.hasNext()) {
                ((C0407i) it.next()).m1211e();
            }
            this.f1862b = false;
            m1259u(true);
        } catch (Throwable th) {
            this.f1862b = false;
            throw th;
        }
    }

    public final void m1255q() {
        if (this.f1855B) {
            this.f1855B = false;
            m1236X();
        }
    }

    public final void m1256r(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2;
        String strM5494h = AbstractC2460q.m5494h(str, "    ");
        C0026b c0026b = this.f1863c;
        c0026b.getClass();
        String str3 = str + "    ";
        HashMap map = (HashMap) c0026b.f55c;
        if (!map.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (C0422p0 c0422p0 : map.values()) {
                printWriter.print(str);
                if (c0422p0 != null) {
                    AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = c0422p0.f1933c;
                    printWriter.println(abstractComponentCallbacksC0427s);
                    abstractComponentCallbacksC0427s.getClass();
                    printWriter.print(str3);
                    printWriter.print("mFragmentId=#");
                    printWriter.print(Integer.toHexString(abstractComponentCallbacksC0427s.f1986w));
                    printWriter.print(" mContainerId=#");
                    printWriter.print(Integer.toHexString(abstractComponentCallbacksC0427s.f1987x));
                    printWriter.print(" mTag=");
                    printWriter.println(abstractComponentCallbacksC0427s.f1988y);
                    printWriter.print(str3);
                    printWriter.print("mState=");
                    printWriter.print(abstractComponentCallbacksC0427s.f1964a);
                    printWriter.print(" mWho=");
                    printWriter.print(abstractComponentCallbacksC0427s.f1969f);
                    printWriter.print(" mBackStackNesting=");
                    printWriter.println(abstractComponentCallbacksC0427s.f1981r);
                    printWriter.print(str3);
                    printWriter.print("mAdded=");
                    printWriter.print(abstractComponentCallbacksC0427s.f1975l);
                    printWriter.print(" mRemoving=");
                    printWriter.print(abstractComponentCallbacksC0427s.f1976m);
                    printWriter.print(" mFromLayout=");
                    printWriter.print(abstractComponentCallbacksC0427s.f1977n);
                    printWriter.print(" mInLayout=");
                    printWriter.println(abstractComponentCallbacksC0427s.f1978o);
                    printWriter.print(str3);
                    printWriter.print("mHidden=");
                    printWriter.print(abstractComponentCallbacksC0427s.f1989z);
                    printWriter.print(" mDetached=");
                    printWriter.print(abstractComponentCallbacksC0427s.f1946A);
                    printWriter.print(" mMenuVisible=");
                    printWriter.print(abstractComponentCallbacksC0427s.f1948C);
                    printWriter.print(" mHasMenu=");
                    printWriter.println(false);
                    printWriter.print(str3);
                    printWriter.print("mRetainInstance=");
                    printWriter.print(abstractComponentCallbacksC0427s.f1947B);
                    printWriter.print(" mUserVisibleHint=");
                    printWriter.println(abstractComponentCallbacksC0427s.f1953H);
                    if (abstractComponentCallbacksC0427s.f1982s != null) {
                        printWriter.print(str3);
                        printWriter.print("mFragmentManager=");
                        printWriter.println(abstractComponentCallbacksC0427s.f1982s);
                    }
                    if (abstractComponentCallbacksC0427s.f1983t != null) {
                        printWriter.print(str3);
                        printWriter.print("mHost=");
                        printWriter.println(abstractComponentCallbacksC0427s.f1983t);
                    }
                    if (abstractComponentCallbacksC0427s.f1985v != null) {
                        printWriter.print(str3);
                        printWriter.print("mParentFragment=");
                        printWriter.println(abstractComponentCallbacksC0427s.f1985v);
                    }
                    if (abstractComponentCallbacksC0427s.f1970g != null) {
                        printWriter.print(str3);
                        printWriter.print("mArguments=");
                        printWriter.println(abstractComponentCallbacksC0427s.f1970g);
                    }
                    if (abstractComponentCallbacksC0427s.f1965b != null) {
                        printWriter.print(str3);
                        printWriter.print("mSavedFragmentState=");
                        printWriter.println(abstractComponentCallbacksC0427s.f1965b);
                    }
                    if (abstractComponentCallbacksC0427s.f1966c != null) {
                        printWriter.print(str3);
                        printWriter.print("mSavedViewState=");
                        printWriter.println(abstractComponentCallbacksC0427s.f1966c);
                    }
                    if (abstractComponentCallbacksC0427s.f1967d != null) {
                        printWriter.print(str3);
                        printWriter.print("mSavedViewRegistryState=");
                        printWriter.println(abstractComponentCallbacksC0427s.f1967d);
                    }
                    Object objM133l = abstractComponentCallbacksC0427s.f1971h;
                    if (objM133l == null) {
                        AbstractC0410j0 abstractC0410j0 = abstractComponentCallbacksC0427s.f1982s;
                        objM133l = (abstractC0410j0 == null || (str2 = abstractComponentCallbacksC0427s.f1972i) == null) ? null : abstractC0410j0.f1863c.m133l(str2);
                    }
                    if (objM133l != null) {
                        printWriter.print(str3);
                        printWriter.print("mTarget=");
                        printWriter.print(objM133l);
                        printWriter.print(" mTargetRequestCode=");
                        printWriter.println(abstractComponentCallbacksC0427s.f1973j);
                    }
                    printWriter.print(str3);
                    printWriter.print("mPopDirection=");
                    C0421p c0421p = abstractComponentCallbacksC0427s.f1954I;
                    printWriter.println(c0421p == null ? false : c0421p.f1920a);
                    C0421p c0421p2 = abstractComponentCallbacksC0427s.f1954I;
                    if ((c0421p2 == null ? 0 : c0421p2.f1921b) != 0) {
                        printWriter.print(str3);
                        printWriter.print("getEnterAnim=");
                        C0421p c0421p3 = abstractComponentCallbacksC0427s.f1954I;
                        printWriter.println(c0421p3 == null ? 0 : c0421p3.f1921b);
                    }
                    C0421p c0421p4 = abstractComponentCallbacksC0427s.f1954I;
                    if ((c0421p4 == null ? 0 : c0421p4.f1922c) != 0) {
                        printWriter.print(str3);
                        printWriter.print("getExitAnim=");
                        C0421p c0421p5 = abstractComponentCallbacksC0427s.f1954I;
                        printWriter.println(c0421p5 == null ? 0 : c0421p5.f1922c);
                    }
                    C0421p c0421p6 = abstractComponentCallbacksC0427s.f1954I;
                    if ((c0421p6 == null ? 0 : c0421p6.f1923d) != 0) {
                        printWriter.print(str3);
                        printWriter.print("getPopEnterAnim=");
                        C0421p c0421p7 = abstractComponentCallbacksC0427s.f1954I;
                        printWriter.println(c0421p7 == null ? 0 : c0421p7.f1923d);
                    }
                    C0421p c0421p8 = abstractComponentCallbacksC0427s.f1954I;
                    if ((c0421p8 == null ? 0 : c0421p8.f1924e) != 0) {
                        printWriter.print(str3);
                        printWriter.print("getPopExitAnim=");
                        C0421p c0421p9 = abstractComponentCallbacksC0427s.f1954I;
                        printWriter.println(c0421p9 != null ? c0421p9.f1924e : 0);
                    }
                    if (abstractComponentCallbacksC0427s.f1950E != null) {
                        printWriter.print(str3);
                        printWriter.print("mContainer=");
                        printWriter.println(abstractComponentCallbacksC0427s.f1950E);
                    }
                    if (abstractComponentCallbacksC0427s.f1951F != null) {
                        printWriter.print(str3);
                        printWriter.print("mView=");
                        printWriter.println(abstractComponentCallbacksC0427s.f1951F);
                    }
                    if (abstractComponentCallbacksC0427s.m1321j() != null) {
                        new C0069f(abstractComponentCallbacksC0427s, abstractComponentCallbacksC0427s.mo359e()).m249z(str3, printWriter);
                    }
                    printWriter.print(str3);
                    printWriter.println("Child " + abstractComponentCallbacksC0427s.f1984u + ":");
                    abstractComponentCallbacksC0427s.f1984u.m1256r(AbstractC2460q.m5494h(str3, "  "), fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        ArrayList arrayList = (ArrayList) c0026b.f54b;
        int size3 = arrayList.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i6 = 0; i6 < size3; i6++) {
                AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = (AbstractComponentCallbacksC0427s) arrayList.get(i6);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(abstractComponentCallbacksC0427s2.toString());
            }
        }
        ArrayList arrayList2 = this.f1865e;
        if (arrayList2 != null && (size2 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i10 = 0; i10 < size2; i10++) {
                AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s3 = (AbstractComponentCallbacksC0427s) this.f1865e.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(abstractComponentCallbacksC0427s3.toString());
            }
        }
        ArrayList arrayList3 = this.f1864d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i11 = 0; i11 < size; i11++) {
                C0391a c0391a = (C0391a) this.f1864d.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(c0391a.toString());
                c0391a.m1192g(strM5494h, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f1869i.get());
        synchronized (this.f1861a) {
            try {
                int size4 = this.f1861a.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i12 = 0; i12 < size4; i12++) {
                        Object obj = (InterfaceC0406h0) this.f1861a.get(i12);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i12);
                        printWriter.print(": ");
                        printWriter.println(obj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f1874n);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f1875o);
        if (this.f1876p != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f1876p);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f1873m);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f1885y);
        printWriter.print(" mStopped=");
        printWriter.print(this.f1886z);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f1854A);
        if (this.f1884x) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f1884x);
        }
    }

    public final void m1257s(InterfaceC0406h0 interfaceC0406h0, boolean z7) {
        if (!z7) {
            if (this.f1874n == null) {
                if (!this.f1854A) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            if (m1222I()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.f1861a) {
            try {
                if (this.f1874n == null) {
                    if (!z7) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f1861a.add(interfaceC0406h0);
                    m1231R();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m1258t(boolean z7) {
        if (this.f1862b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f1874n == null) {
            if (!this.f1854A) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f1874n.f2004h.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z7 && m1222I()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.f1856C == null) {
            this.f1856C = new ArrayList();
            this.f1857D = new ArrayList();
        }
        this.f1862b = false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = this.f1876p;
        if (abstractComponentCallbacksC0427s != null) {
            sb.append(abstractComponentCallbacksC0427s.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f1876p)));
            sb.append("}");
        } else {
            C0433v c0433v = this.f1874n;
            if (c0433v != null) {
                sb.append(c0433v.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f1874n)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public final boolean m1259u(boolean z7) {
        boolean zMo1186a;
        m1258t(z7);
        boolean z10 = false;
        while (true) {
            ArrayList arrayList = this.f1856C;
            ArrayList arrayList2 = this.f1857D;
            synchronized (this.f1861a) {
                try {
                    if (this.f1861a.isEmpty()) {
                        zMo1186a = false;
                    } else {
                        int size = this.f1861a.size();
                        zMo1186a = false;
                        for (int i6 = 0; i6 < size; i6++) {
                            zMo1186a |= ((InterfaceC0406h0) this.f1861a.get(i6)).mo1186a(arrayList, arrayList2);
                        }
                        this.f1861a.clear();
                        this.f1874n.f2004h.removeCallbacks(this.f1860G);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!zMo1186a) {
                m1238Z();
                m1255q();
                ((HashMap) this.f1863c.f55c).values().removeAll(Collections.singleton(null));
                return z10;
            }
            z10 = true;
            this.f1862b = true;
            try {
                m1228O(this.f1856C, this.f1857D);
                m1242d();
            } catch (Throwable th2) {
                m1242d();
                throw th2;
            }
        }
    }

    public final void m1260v(C0391a c0391a, boolean z7) {
        if (z7 && (this.f1874n == null || this.f1854A)) {
            return;
        }
        m1258t(z7);
        c0391a.mo1186a(this.f1856C, this.f1857D);
        this.f1862b = true;
        try {
            m1228O(this.f1856C, this.f1857D);
            m1242d();
            m1238Z();
            m1255q();
            ((HashMap) this.f1863c.f55c).values().removeAll(Collections.singleton(null));
        } catch (Throwable th) {
            m1242d();
            throw th;
        }
    }

    public final void m1261w(ArrayList arrayList, ArrayList arrayList2, int i6, int i10) {
        ViewGroup viewGroup;
        C0026b c0026b;
        C0026b c0026b2;
        C0026b c0026b3;
        int i11;
        ArrayList arrayList3 = arrayList;
        boolean z7 = ((C0391a) arrayList3.get(i6)).f1816p;
        ArrayList arrayList4 = this.f1858E;
        if (arrayList4 == null) {
            this.f1858E = new ArrayList();
        } else {
            arrayList4.clear();
        }
        ArrayList arrayList5 = this.f1858E;
        C0026b c0026b4 = this.f1863c;
        arrayList5.addAll(c0026b4.m143w());
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = this.f1877q;
        int i12 = i6;
        boolean z10 = false;
        while (true) {
            int i13 = 1;
            if (i12 >= i10) {
                C0026b c0026b5 = c0026b4;
                this.f1858E.clear();
                if (!z7 && this.f1873m >= 1) {
                    for (int i14 = i6; i14 < i10; i14++) {
                        Iterator it = ((C0391a) arrayList.get(i14)).f1801a.iterator();
                        while (it.hasNext()) {
                            AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = ((C0426r0) it.next()).f1938b;
                            if (abstractComponentCallbacksC0427s2 == null || abstractComponentCallbacksC0427s2.f1982s == null) {
                                c0026b = c0026b5;
                            } else {
                                c0026b = c0026b5;
                                c0026b.m145z(m1244f(abstractComponentCallbacksC0427s2));
                            }
                            c0026b5 = c0026b;
                        }
                    }
                }
                for (int i15 = i6; i15 < i10; i15++) {
                    C0391a c0391a = (C0391a) arrayList.get(i15);
                    if (((Boolean) arrayList2.get(i15)).booleanValue()) {
                        c0391a.m1189d(-1);
                        ArrayList arrayList6 = c0391a.f1801a;
                        for (int size = arrayList6.size() - 1; size >= 0; size--) {
                            C0426r0 c0426r0 = (C0426r0) arrayList6.get(size);
                            AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s3 = c0426r0.f1938b;
                            if (abstractComponentCallbacksC0427s3 != null) {
                                if (abstractComponentCallbacksC0427s3.f1954I != null) {
                                    abstractComponentCallbacksC0427s3.m1318g().f1920a = true;
                                }
                                int i16 = c0391a.f1806f;
                                int i17 = 8194;
                                if (i16 != 4097) {
                                    i17 = i16 != 4099 ? i16 != 8194 ? 0 : 4097 : 4099;
                                }
                                if (abstractComponentCallbacksC0427s3.f1954I != null || i17 != 0) {
                                    abstractComponentCallbacksC0427s3.m1318g();
                                    abstractComponentCallbacksC0427s3.f1954I.f1925f = i17;
                                }
                                abstractComponentCallbacksC0427s3.m1318g();
                                abstractComponentCallbacksC0427s3.f1954I.getClass();
                            }
                            int i18 = c0426r0.f1937a;
                            AbstractC0410j0 abstractC0410j0 = c0391a.f1817q;
                            switch (i18) {
                                case 1:
                                    abstractComponentCallbacksC0427s3.m1315N(c0426r0.f1939c, c0426r0.f1940d, c0426r0.f1941e, c0426r0.f1942f);
                                    abstractC0410j0.m1232S(abstractComponentCallbacksC0427s3, true);
                                    abstractC0410j0.m1227N(abstractComponentCallbacksC0427s3);
                                    break;
                                case 2:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + c0426r0.f1937a);
                                case 3:
                                    abstractComponentCallbacksC0427s3.m1315N(c0426r0.f1939c, c0426r0.f1940d, c0426r0.f1941e, c0426r0.f1942f);
                                    abstractC0410j0.m1239a(abstractComponentCallbacksC0427s3);
                                    break;
                                case 4:
                                    abstractComponentCallbacksC0427s3.m1315N(c0426r0.f1939c, c0426r0.f1940d, c0426r0.f1941e, c0426r0.f1942f);
                                    abstractC0410j0.getClass();
                                    m1216W(abstractComponentCallbacksC0427s3);
                                    break;
                                case 5:
                                    abstractComponentCallbacksC0427s3.m1315N(c0426r0.f1939c, c0426r0.f1940d, c0426r0.f1941e, c0426r0.f1942f);
                                    abstractC0410j0.m1232S(abstractComponentCallbacksC0427s3, true);
                                    abstractC0410j0.m1221E(abstractComponentCallbacksC0427s3);
                                    break;
                                case 6:
                                    abstractComponentCallbacksC0427s3.m1315N(c0426r0.f1939c, c0426r0.f1940d, c0426r0.f1941e, c0426r0.f1942f);
                                    abstractC0410j0.m1241c(abstractComponentCallbacksC0427s3);
                                    break;
                                case 7:
                                    abstractComponentCallbacksC0427s3.m1315N(c0426r0.f1939c, c0426r0.f1940d, c0426r0.f1941e, c0426r0.f1942f);
                                    abstractC0410j0.m1232S(abstractComponentCallbacksC0427s3, true);
                                    abstractC0410j0.m1245g(abstractComponentCallbacksC0427s3);
                                    break;
                                case 8:
                                    abstractC0410j0.m1234U(null);
                                    break;
                                case 9:
                                    abstractC0410j0.m1234U(abstractComponentCallbacksC0427s3);
                                    break;
                                case 10:
                                    abstractC0410j0.m1233T(abstractComponentCallbacksC0427s3, c0426r0.f1943g);
                                    break;
                            }
                        }
                    } else {
                        c0391a.m1189d(1);
                        ArrayList arrayList7 = c0391a.f1801a;
                        int size2 = arrayList7.size();
                        for (int i19 = 0; i19 < size2; i19++) {
                            C0426r0 c0426r1 = (C0426r0) arrayList7.get(i19);
                            AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s4 = c0426r1.f1938b;
                            if (abstractComponentCallbacksC0427s4 != null) {
                                if (abstractComponentCallbacksC0427s4.f1954I != null) {
                                    abstractComponentCallbacksC0427s4.m1318g().f1920a = false;
                                }
                                int i20 = c0391a.f1806f;
                                if (abstractComponentCallbacksC0427s4.f1954I != null || i20 != 0) {
                                    abstractComponentCallbacksC0427s4.m1318g();
                                    abstractComponentCallbacksC0427s4.f1954I.f1925f = i20;
                                }
                                abstractComponentCallbacksC0427s4.m1318g();
                                abstractComponentCallbacksC0427s4.f1954I.getClass();
                            }
                            int i21 = c0426r1.f1937a;
                            AbstractC0410j0 abstractC0410j1 = c0391a.f1817q;
                            switch (i21) {
                                case 1:
                                    abstractComponentCallbacksC0427s4.m1315N(c0426r1.f1939c, c0426r1.f1940d, c0426r1.f1941e, c0426r1.f1942f);
                                    abstractC0410j1.m1232S(abstractComponentCallbacksC0427s4, false);
                                    abstractC0410j1.m1239a(abstractComponentCallbacksC0427s4);
                                    break;
                                case 2:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + c0426r1.f1937a);
                                case 3:
                                    abstractComponentCallbacksC0427s4.m1315N(c0426r1.f1939c, c0426r1.f1940d, c0426r1.f1941e, c0426r1.f1942f);
                                    abstractC0410j1.m1227N(abstractComponentCallbacksC0427s4);
                                    break;
                                case 4:
                                    abstractComponentCallbacksC0427s4.m1315N(c0426r1.f1939c, c0426r1.f1940d, c0426r1.f1941e, c0426r1.f1942f);
                                    abstractC0410j1.m1221E(abstractComponentCallbacksC0427s4);
                                    break;
                                case 5:
                                    abstractComponentCallbacksC0427s4.m1315N(c0426r1.f1939c, c0426r1.f1940d, c0426r1.f1941e, c0426r1.f1942f);
                                    abstractC0410j1.m1232S(abstractComponentCallbacksC0427s4, false);
                                    m1216W(abstractComponentCallbacksC0427s4);
                                    break;
                                case 6:
                                    abstractComponentCallbacksC0427s4.m1315N(c0426r1.f1939c, c0426r1.f1940d, c0426r1.f1941e, c0426r1.f1942f);
                                    abstractC0410j1.m1245g(abstractComponentCallbacksC0427s4);
                                    break;
                                case 7:
                                    abstractComponentCallbacksC0427s4.m1315N(c0426r1.f1939c, c0426r1.f1940d, c0426r1.f1941e, c0426r1.f1942f);
                                    abstractC0410j1.m1232S(abstractComponentCallbacksC0427s4, false);
                                    abstractC0410j1.m1241c(abstractComponentCallbacksC0427s4);
                                    break;
                                case 8:
                                    abstractC0410j1.m1234U(abstractComponentCallbacksC0427s4);
                                    break;
                                case 9:
                                    abstractC0410j1.m1234U(null);
                                    break;
                                case 10:
                                    abstractC0410j1.m1233T(abstractComponentCallbacksC0427s4, c0426r1.f1944h);
                                    break;
                            }
                        }
                    }
                }
                boolean zBooleanValue = ((Boolean) arrayList2.get(i10 - 1)).booleanValue();
                for (int i22 = i6; i22 < i10; i22++) {
                    C0391a c0391a2 = (C0391a) arrayList.get(i22);
                    if (zBooleanValue) {
                        for (int size3 = c0391a2.f1801a.size() - 1; size3 >= 0; size3--) {
                            AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s5 = ((C0426r0) c0391a2.f1801a.get(size3)).f1938b;
                            if (abstractComponentCallbacksC0427s5 != null) {
                                m1244f(abstractComponentCallbacksC0427s5).m1298k();
                            }
                        }
                    } else {
                        Iterator it2 = c0391a2.f1801a.iterator();
                        while (it2.hasNext()) {
                            AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s6 = ((C0426r0) it2.next()).f1938b;
                            if (abstractComponentCallbacksC0427s6 != null) {
                                m1244f(abstractComponentCallbacksC0427s6).m1298k();
                            }
                        }
                    }
                }
                m1223J(this.f1873m, true);
                HashSet<C0407i> hashSet = new HashSet();
                for (int i23 = i6; i23 < i10; i23++) {
                    Iterator it3 = ((C0391a) arrayList.get(i23)).f1801a.iterator();
                    while (it3.hasNext()) {
                        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s7 = ((C0426r0) it3.next()).f1938b;
                        if (abstractComponentCallbacksC0427s7 != null && (viewGroup = abstractComponentCallbacksC0427s7.f1950E) != null) {
                            hashSet.add(C0407i.m1206f(viewGroup, m1220D()));
                        }
                    }
                }
                for (C0407i c0407i : hashSet) {
                    c0407i.f1849d = zBooleanValue;
                    synchronized (c0407i.f1847b) {
                        try {
                            c0407i.m1212g();
                            c0407i.f1850e = false;
                            for (int size4 = c0407i.f1847b.size() - 1; size4 >= 0; size4--) {
                                C0434v0 c0434v0 = (C0434v0) c0407i.f1847b.get(size4);
                                int iM9c = AbstractC0004e.m9c(c0434v0.f2009c.f1951F);
                                if (c0434v0.f2007a == 2 && iM9c != 2) {
                                    c0434v0.f2009c.getClass();
                                    c0407i.f1850e = false;
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    c0407i.m1209c();
                }
                for (int i24 = i6; i24 < i10; i24++) {
                    C0391a c0391a3 = (C0391a) arrayList.get(i24);
                    if (((Boolean) arrayList2.get(i24)).booleanValue() && c0391a3.f1819s >= 0) {
                        c0391a3.f1819s = -1;
                    }
                    c0391a3.getClass();
                }
                return;
            }
            C0391a c0391a4 = (C0391a) arrayList3.get(i12);
            if (((Boolean) arrayList2.get(i12)).booleanValue()) {
                c0026b2 = c0026b4;
                int i25 = 1;
                ArrayList arrayList8 = this.f1858E;
                ArrayList arrayList9 = c0391a4.f1801a;
                int size5 = arrayList9.size() - 1;
                while (size5 >= 0) {
                    C0426r0 c0426r2 = (C0426r0) arrayList9.get(size5);
                    int i26 = c0426r2.f1937a;
                    if (i26 != i25) {
                        if (i26 != 3) {
                            switch (i26) {
                                case 6:
                                    arrayList8.add(c0426r2.f1938b);
                                    break;
                                case 8:
                                    abstractComponentCallbacksC0427s = null;
                                    break;
                                case 9:
                                    abstractComponentCallbacksC0427s = c0426r2.f1938b;
                                    break;
                                case 10:
                                    c0426r2.f1944h = c0426r2.f1943g;
                                    break;
                            }
                        } else {
                            arrayList8.add(c0426r2.f1938b);
                        }
                        size5--;
                        i25 = 1;
                    }
                    arrayList8.remove(c0426r2.f1938b);
                    size5--;
                    i25 = 1;
                }
            } else {
                ArrayList arrayList10 = this.f1858E;
                int i27 = 0;
                while (true) {
                    ArrayList arrayList11 = c0391a4.f1801a;
                    if (i27 < arrayList11.size()) {
                        C0426r0 c0426r3 = (C0426r0) arrayList11.get(i27);
                        int i28 = c0426r3.f1937a;
                        if (i28 == i13) {
                            c0026b3 = c0026b4;
                            i11 = 1;
                            arrayList10.add(c0426r3.f1938b);
                        } else if (i28 != 2) {
                            if (i28 == 3 || i28 == 6) {
                                arrayList10.remove(c0426r3.f1938b);
                                AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s8 = c0426r3.f1938b;
                                if (abstractComponentCallbacksC0427s8 == abstractComponentCallbacksC0427s) {
                                    arrayList11.add(i27, new C0426r0(9, abstractComponentCallbacksC0427s8));
                                    i27++;
                                    c0026b3 = c0026b4;
                                    i11 = 1;
                                    abstractComponentCallbacksC0427s = null;
                                }
                            } else if (i28 == 7) {
                                c0026b3 = c0026b4;
                                i11 = 1;
                                arrayList10.add(c0426r3.f1938b);
                            } else if (i28 == 8) {
                                arrayList11.add(i27, new C0426r0(9, abstractComponentCallbacksC0427s));
                                i27++;
                                abstractComponentCallbacksC0427s = c0426r3.f1938b;
                            }
                            c0026b3 = c0026b4;
                            i11 = 1;
                        } else {
                            AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s9 = c0426r3.f1938b;
                            int i29 = abstractComponentCallbacksC0427s9.f1987x;
                            int size6 = arrayList10.size() - 1;
                            boolean z11 = false;
                            while (size6 >= 0) {
                                C0026b c0026b6 = c0026b4;
                                AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s10 = (AbstractComponentCallbacksC0427s) arrayList10.get(size6);
                                if (abstractComponentCallbacksC0427s10.f1987x == i29) {
                                    if (abstractComponentCallbacksC0427s10 == abstractComponentCallbacksC0427s9) {
                                        z11 = true;
                                    } else {
                                        if (abstractComponentCallbacksC0427s10 == abstractComponentCallbacksC0427s) {
                                            arrayList11.add(i27, new C0426r0(9, abstractComponentCallbacksC0427s10));
                                            i27++;
                                            abstractComponentCallbacksC0427s = null;
                                        }
                                        C0426r0 c0426r4 = new C0426r0(3, abstractComponentCallbacksC0427s10);
                                        c0426r4.f1939c = c0426r3.f1939c;
                                        c0426r4.f1941e = c0426r3.f1941e;
                                        c0426r4.f1940d = c0426r3.f1940d;
                                        c0426r4.f1942f = c0426r3.f1942f;
                                        arrayList11.add(i27, c0426r4);
                                        arrayList10.remove(abstractComponentCallbacksC0427s10);
                                        i27++;
                                        abstractComponentCallbacksC0427s = abstractComponentCallbacksC0427s;
                                    }
                                }
                                size6--;
                                c0026b4 = c0026b6;
                            }
                            c0026b3 = c0026b4;
                            i11 = 1;
                            if (z11) {
                                arrayList11.remove(i27);
                                i27--;
                            } else {
                                c0426r3.f1937a = 1;
                                arrayList10.add(abstractComponentCallbacksC0427s9);
                            }
                        }
                        i27 += i11;
                        c0026b4 = c0026b3;
                        i13 = 1;
                    } else {
                        c0026b2 = c0026b4;
                    }
                }
            }
            z10 = z10 || c0391a4.f1807g;
            i12++;
            arrayList3 = arrayList;
            c0026b4 = c0026b2;
        }
    }

    public final AbstractComponentCallbacksC0427s m1263y(int i6) {
        C0026b c0026b = this.f1863c;
        ArrayList arrayList = (ArrayList) c0026b.f54b;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = (AbstractComponentCallbacksC0427s) arrayList.get(size);
            if (abstractComponentCallbacksC0427s != null && abstractComponentCallbacksC0427s.f1986w == i6) {
                return abstractComponentCallbacksC0427s;
            }
        }
        for (C0422p0 c0422p0 : ((HashMap) c0026b.f55c).values()) {
            if (c0422p0 != null) {
                AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = c0422p0.f1933c;
                if (abstractComponentCallbacksC0427s2.f1986w == i6) {
                    return abstractComponentCallbacksC0427s2;
                }
            }
        }
        return null;
    }

    public final AbstractComponentCallbacksC0427s m1264z(String str) {
        C0026b c0026b = this.f1863c;
        if (str != null) {
            ArrayList arrayList = (ArrayList) c0026b.f54b;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = (AbstractComponentCallbacksC0427s) arrayList.get(size);
                if (abstractComponentCallbacksC0427s != null && str.equals(abstractComponentCallbacksC0427s.f1988y)) {
                    return abstractComponentCallbacksC0427s;
                }
            }
        }
        if (str != null) {
            for (C0422p0 c0422p0 : ((HashMap) c0026b.f55c).values()) {
                if (c0422p0 != null) {
                    AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = c0422p0.f1933c;
                    if (str.equals(abstractComponentCallbacksC0427s2.f1988y)) {
                        return abstractComponentCallbacksC0427s2;
                    }
                }
            }
        } else {
            c0026b.getClass();
        }
        return null;
    }

    public final void m1262x(ArrayList arrayList, ArrayList arrayList2) {
    }
}

package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.EnumC0539o;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public final class C0391a implements InterfaceC0406h0 {

    public final ArrayList f1801a;

    public int f1802b;

    public int f1803c;

    public int f1804d;

    public int f1805e;

    public int f1806f;

    public boolean f1807g;

    public boolean f1808h;

    public String f1809i;

    public int f1810j;

    public CharSequence f1811k;

    public int f1812l;

    public CharSequence f1813m;

    public ArrayList f1814n;

    public ArrayList f1815o;

    public boolean f1816p;

    public final AbstractC0410j0 f1817q;

    public boolean f1818r;

    public int f1819s;

    public C0391a(AbstractC0410j0 abstractC0410j0) {
        abstractC0410j0.m1219C();
        C0433v c0433v = abstractC0410j0.f1874n;
        if (c0433v != null) {
            c0433v.f2003g.getClassLoader();
        }
        this.f1801a = new ArrayList();
        this.f1808h = true;
        this.f1816p = false;
        this.f1819s = -1;
        this.f1817q = abstractC0410j0;
    }

    @Override
    public final boolean mo1186a(ArrayList arrayList, ArrayList arrayList2) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f1807g) {
            return true;
        }
        AbstractC0410j0 abstractC0410j0 = this.f1817q;
        if (abstractC0410j0.f1864d == null) {
            abstractC0410j0.f1864d = new ArrayList();
        }
        abstractC0410j0.f1864d.add(this);
        return true;
    }

    public final void m1187b(C0426r0 c0426r0) {
        this.f1801a.add(c0426r0);
        c0426r0.f1939c = this.f1802b;
        c0426r0.f1940d = this.f1803c;
        c0426r0.f1941e = this.f1804d;
        c0426r0.f1942f = this.f1805e;
    }

    public final void m1188c() {
        if (!this.f1808h) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.f1807g = true;
        this.f1809i = null;
    }

    public final void m1189d(int i6) {
        if (this.f1807g) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i6);
            }
            ArrayList arrayList = this.f1801a;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                C0426r0 c0426r0 = (C0426r0) arrayList.get(i10);
                AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = c0426r0.f1938b;
                if (abstractComponentCallbacksC0427s != null) {
                    abstractComponentCallbacksC0427s.f1981r += i6;
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "Bump nesting of " + c0426r0.f1938b + " to " + c0426r0.f1938b.f1981r);
                    }
                }
            }
        }
    }

    public final int m1190e(boolean z7) {
        if (this.f1818r) {
            throw new IllegalStateException("commit already called");
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new C0430t0());
            m1192g("  ", printWriter, true);
            printWriter.close();
        }
        this.f1818r = true;
        boolean z10 = this.f1807g;
        AbstractC0410j0 abstractC0410j0 = this.f1817q;
        if (z10) {
            this.f1819s = abstractC0410j0.f1869i.getAndIncrement();
        } else {
            this.f1819s = -1;
        }
        abstractC0410j0.m1257s(this, z7);
        return this.f1819s;
    }

    public final void m1191f(int i6, AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s, String str, int i10) {
        Class<?> cls = abstractComponentCallbacksC0427s.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = abstractComponentCallbacksC0427s.f1988y;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + abstractComponentCallbacksC0427s + ": was " + abstractComponentCallbacksC0427s.f1988y + " now " + str);
            }
            abstractComponentCallbacksC0427s.f1988y = str;
        }
        if (i6 != 0) {
            if (i6 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + abstractComponentCallbacksC0427s + " with tag " + str + " to container view with no id");
            }
            int i11 = abstractComponentCallbacksC0427s.f1986w;
            if (i11 != 0 && i11 != i6) {
                throw new IllegalStateException("Can't change container ID of fragment " + abstractComponentCallbacksC0427s + ": was " + abstractComponentCallbacksC0427s.f1986w + " now " + i6);
            }
            abstractComponentCallbacksC0427s.f1986w = i6;
            abstractComponentCallbacksC0427s.f1987x = i6;
        }
        m1187b(new C0426r0(i10, abstractComponentCallbacksC0427s));
        abstractComponentCallbacksC0427s.f1982s = this.f1817q;
    }

    public final void m1192g(String str, PrintWriter printWriter, boolean z7) {
        String str2;
        if (z7) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f1809i);
            printWriter.print(" mIndex=");
            printWriter.print(this.f1819s);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f1818r);
            if (this.f1806f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f1806f));
            }
            if (this.f1802b != 0 || this.f1803c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1802b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1803c));
            }
            if (this.f1804d != 0 || this.f1805e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1804d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1805e));
            }
            if (this.f1810j != 0 || this.f1811k != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1810j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f1811k);
            }
            if (this.f1812l != 0 || this.f1813m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1812l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f1813m);
            }
        }
        ArrayList arrayList = this.f1801a;
        if (arrayList.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            C0426r0 c0426r0 = (C0426r0) arrayList.get(i6);
            switch (c0426r0.f1937a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + c0426r0.f1937a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i6);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(c0426r0.f1938b);
            if (z7) {
                if (c0426r0.f1939c != 0 || c0426r0.f1940d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(c0426r0.f1939c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(c0426r0.f1940d));
                }
                if (c0426r0.f1941e != 0 || c0426r0.f1942f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(c0426r0.f1941e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(c0426r0.f1942f));
                }
            }
        }
    }

    public final void m1193h(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        AbstractC0410j0 abstractC0410j0 = abstractComponentCallbacksC0427s.f1982s;
        if (abstractC0410j0 == null || abstractC0410j0 == this.f1817q) {
            m1187b(new C0426r0(3, abstractComponentCallbacksC0427s));
            return;
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + abstractComponentCallbacksC0427s.toString() + " is already attached to a FragmentManager.");
    }

    public final void m1194i(int i6, AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        if (i6 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        m1191f(i6, abstractComponentCallbacksC0427s, null, 2);
    }

    public final void m1195j(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s, EnumC0539o enumC0539o) {
        AbstractC0410j0 abstractC0410j0 = abstractComponentCallbacksC0427s.f1982s;
        AbstractC0410j0 abstractC0410j1 = this.f1817q;
        if (abstractC0410j0 != abstractC0410j1) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + abstractC0410j1);
        }
        if (enumC0539o == EnumC0539o.f2508b && abstractComponentCallbacksC0427s.f1964a > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + enumC0539o + " after the Fragment has been created");
        }
        if (enumC0539o == EnumC0539o.f2507a) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + enumC0539o + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
        C0426r0 c0426r0 = new C0426r0();
        c0426r0.f1937a = 10;
        c0426r0.f1938b = abstractComponentCallbacksC0427s;
        c0426r0.f1943g = abstractComponentCallbacksC0427s.f1957L;
        c0426r0.f1944h = enumC0539o;
        m1187b(c0426r0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f1819s >= 0) {
            sb.append(" #");
            sb.append(this.f1819s);
        }
        if (this.f1809i != null) {
            sb.append(" ");
            sb.append(this.f1809i);
        }
        sb.append("}");
        return sb.toString();
    }
}

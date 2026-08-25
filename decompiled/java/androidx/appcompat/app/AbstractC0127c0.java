package androidx.appcompat.app;

import android.content.Context;
import android.content.IntentFilter;
import android.util.SparseIntArray;
import android.view.MenuItem;
import androidx.fragment.app.C0434v0;
import java.util.HashSet;
import p074h0.InterfaceMenuItemC2638a;
import p094j0.C2757e;
import p105k.MenuItemC2845s;
import p160p.C3347k;

public abstract class AbstractC0127c0 {

    public Object f268a;

    public Object f269b;

    public AbstractC0127c0(Context context) {
        this.f268a = context;
    }

    public void m372c() {
        C0125b0 c0125b0 = (C0125b0) this.f268a;
        if (c0125b0 != null) {
            try {
                ((LayoutInflaterFactory2C0135g0) this.f269b).f341k.unregisterReceiver(c0125b0);
            } catch (IllegalArgumentException unused) {
            }
            this.f268a = null;
        }
    }

    public void m373d() {
        C0434v0 c0434v0 = (C0434v0) this.f268a;
        HashSet hashSet = c0434v0.f2011e;
        if (hashSet.remove((C2757e) this.f269b) && hashSet.isEmpty()) {
            c0434v0.m1337b();
        }
    }

    public abstract IntentFilter mo368e();

    public abstract int mo369f();

    public MenuItem m374g(MenuItem menuItem) {
        if (!(menuItem instanceof InterfaceMenuItemC2638a)) {
            return menuItem;
        }
        InterfaceMenuItemC2638a interfaceMenuItemC2638a = (InterfaceMenuItemC2638a) menuItem;
        if (((C3347k) this.f269b) == null) {
            this.f269b = new C3347k(0);
        }
        MenuItem menuItem2 = (MenuItem) ((C3347k) this.f269b).get(interfaceMenuItemC2638a);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemC2845s menuItemC2845s = new MenuItemC2845s((Context) this.f268a, interfaceMenuItemC2638a);
        ((C3347k) this.f269b).put(interfaceMenuItemC2638a, menuItemC2845s);
        return menuItemC2845s;
    }

    public int m375h(int i6, int i10) {
        int iMo377j = mo377j(i6);
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < i6; i13++) {
            int iMo377j2 = mo377j(i13);
            i11 += iMo377j2;
            if (i11 == i10) {
                i12++;
                i11 = 0;
            } else if (i11 > i10) {
                i12++;
                i11 = iMo377j2;
            }
        }
        return i11 + iMo377j > i10 ? i12 + 1 : i12;
    }

    public int mo376i(int i6, int i10) {
        int iMo377j = mo377j(i6);
        if (iMo377j == i10) {
            return 0;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < i6; i12++) {
            int iMo377j2 = mo377j(i12);
            i11 += iMo377j2;
            if (i11 == i10) {
                i11 = 0;
            } else if (i11 > i10) {
                i11 = iMo377j2;
            }
        }
        if (iMo377j + i11 <= i10) {
            return i11;
        }
        return 0;
    }

    public abstract int mo377j(int i6);

    public void m378k() {
        ((SparseIntArray) this.f268a).clear();
    }

    public abstract void mo370l();

    public void m379m() {
        m372c();
        IntentFilter intentFilterMo368e = mo368e();
        if (intentFilterMo368e.countActions() == 0) {
            return;
        }
        if (((C0125b0) this.f268a) == null) {
            this.f268a = new C0125b0(0, this);
        }
        ((LayoutInflaterFactory2C0135g0) this.f269b).f341k.registerReceiver((C0125b0) this.f268a, intentFilterMo368e);
    }

    public AbstractC0127c0(C0434v0 c0434v0, C2757e c2757e) {
        this.f268a = c0434v0;
        this.f269b = c2757e;
    }

    public AbstractC0127c0() {
        this.f268a = new SparseIntArray();
        this.f269b = new SparseIntArray();
    }

    public AbstractC0127c0(LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0) {
        this.f269b = layoutInflaterFactory2C0135g0;
    }
}

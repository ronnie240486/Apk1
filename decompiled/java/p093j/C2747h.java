package p093j;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import p000a.AbstractC0004e;
import p074h0.InterfaceMenuItemC2638a;
import p105k.C2840n;
import p105k.MenuItemC2845s;
import p138n0.AbstractC3106c;
import p138n0.AbstractC3136m;

public final class C2747h {

    public CharSequence f9426A;

    public CharSequence f9427B;

    public final C2748i f9430E;

    public final Menu f9431a;

    public boolean f9438h;

    public int f9439i;

    public int f9440j;

    public CharSequence f9441k;

    public CharSequence f9442l;

    public int f9443m;

    public char f9444n;

    public int f9445o;

    public char f9446p;

    public int f9447q;

    public int f9448r;

    public boolean f9449s;

    public boolean f9450t;

    public boolean f9451u;

    public int f9452v;

    public int f9453w;

    public String f9454x;

    public String f9455y;

    public AbstractC3106c f9456z;

    public ColorStateList f9428C = null;

    public PorterDuff.Mode f9429D = null;

    public int f9432b = 0;

    public int f9433c = 0;

    public int f9434d = 0;

    public int f9435e = 0;

    public boolean f9436f = true;

    public boolean f9437g = true;

    public C2747h(C2748i c2748i, Menu menu) {
        this.f9430E = c2748i;
        this.f9431a = menu;
    }

    public final Object m5710a(String str, Class[] clsArr, Object[] objArr) {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.f9430E.f9461c.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e5) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e5);
            return null;
        }
    }

    public final void m5711b(MenuItem menuItem) {
        boolean z7 = false;
        menuItem.setChecked(this.f9449s).setVisible(this.f9450t).setEnabled(this.f9451u).setCheckable(this.f9448r >= 1).setTitleCondensed(this.f9442l).setIcon(this.f9443m);
        int i6 = this.f9452v;
        if (i6 >= 0) {
            menuItem.setShowAsAction(i6);
        }
        String str = this.f9455y;
        C2748i c2748i = this.f9430E;
        if (str != null) {
            if (c2748i.f9461c.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            if (c2748i.f9462d == null) {
                c2748i.f9462d = C2748i.m5712a(c2748i.f9461c);
            }
            Object obj = c2748i.f9462d;
            String str2 = this.f9455y;
            MenuItemOnMenuItemClickListenerC2746g menuItemOnMenuItemClickListenerC2746g = new MenuItemOnMenuItemClickListenerC2746g();
            menuItemOnMenuItemClickListenerC2746g.f9424a = obj;
            Class<?> cls = obj.getClass();
            try {
                menuItemOnMenuItemClickListenerC2746g.f9425b = cls.getMethod(str2, MenuItemOnMenuItemClickListenerC2746g.f9423c);
                menuItem.setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC2746g);
            } catch (Exception e5) {
                StringBuilder sbM30x = AbstractC0004e.m30x("Couldn't resolve menu item onClick handler ", str2, " in class ");
                sbM30x.append(cls.getName());
                InflateException inflateException = new InflateException(sbM30x.toString());
                inflateException.initCause(e5);
                throw inflateException;
            }
        }
        if (this.f9448r >= 2) {
            if (menuItem instanceof C2840n) {
                ((C2840n) menuItem).m5845g(true);
            } else if (menuItem instanceof MenuItemC2845s) {
                MenuItemC2845s menuItemC2845s = (MenuItemC2845s) menuItem;
                try {
                    Method method = menuItemC2845s.f9752d;
                    InterfaceMenuItemC2638a interfaceMenuItemC2638a = menuItemC2845s.f9751c;
                    if (method == null) {
                        menuItemC2845s.f9752d = interfaceMenuItemC2638a.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                    }
                    menuItemC2845s.f9752d.invoke(interfaceMenuItemC2638a, Boolean.TRUE);
                } catch (Exception e10) {
                    Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e10);
                }
            }
        }
        String str3 = this.f9454x;
        if (str3 != null) {
            menuItem.setActionView((View) m5710a(str3, C2748i.f9457e, c2748i.f9459a));
            z7 = true;
        }
        int i10 = this.f9453w;
        if (i10 > 0) {
            if (z7) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                menuItem.setActionView(i10);
            }
        }
        AbstractC3106c abstractC3106c = this.f9456z;
        if (abstractC3106c != null) {
            if (menuItem instanceof InterfaceMenuItemC2638a) {
                ((InterfaceMenuItemC2638a) menuItem).mo5660b(abstractC3106c);
            } else {
                Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
            }
        }
        CharSequence charSequence = this.f9426A;
        boolean z10 = menuItem instanceof InterfaceMenuItemC2638a;
        if (z10) {
            ((InterfaceMenuItemC2638a) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            AbstractC3136m.m6260h(menuItem, charSequence);
        }
        CharSequence charSequence2 = this.f9427B;
        if (z10) {
            ((InterfaceMenuItemC2638a) menuItem).setTooltipText(charSequence2);
        } else if (Build.VERSION.SDK_INT >= 26) {
            AbstractC3136m.m6265m(menuItem, charSequence2);
        }
        char c5 = this.f9444n;
        int i11 = this.f9445o;
        if (z10) {
            ((InterfaceMenuItemC2638a) menuItem).setAlphabeticShortcut(c5, i11);
        } else if (Build.VERSION.SDK_INT >= 26) {
            AbstractC3136m.m6259g(menuItem, c5, i11);
        }
        char c8 = this.f9446p;
        int i12 = this.f9447q;
        if (z10) {
            ((InterfaceMenuItemC2638a) menuItem).setNumericShortcut(c8, i12);
        } else if (Build.VERSION.SDK_INT >= 26) {
            AbstractC3136m.m6263k(menuItem, c8, i12);
        }
        PorterDuff.Mode mode = this.f9429D;
        if (mode != null) {
            if (z10) {
                ((InterfaceMenuItemC2638a) menuItem).setIconTintMode(mode);
            } else if (Build.VERSION.SDK_INT >= 26) {
                AbstractC3136m.m6262j(menuItem, mode);
            }
        }
        ColorStateList colorStateList = this.f9428C;
        if (colorStateList != null) {
            if (z10) {
                ((InterfaceMenuItemC2638a) menuItem).setIconTintList(colorStateList);
            } else if (Build.VERSION.SDK_INT >= 26) {
                AbstractC3136m.m6261i(menuItem, colorStateList);
            }
        }
    }
}

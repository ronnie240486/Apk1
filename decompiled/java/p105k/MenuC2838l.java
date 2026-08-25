package p105k;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p034d0.AbstractC2115a;
import p138n0.AbstractC3106c;
import p138n0.AbstractC3161u0;
import p138n0.AbstractC3167w0;

public class MenuC2838l implements Menu {

    public static final int[] f9686y = {1, 4, 5, 3, 2, 0};

    public final Context f9687a;

    public final Resources f9688b;

    public boolean f9689c;

    public final boolean f9690d;

    public InterfaceC2836j f9691e;

    public final ArrayList f9692f;

    public final ArrayList f9693g;

    public boolean f9694h;

    public final ArrayList f9695i;

    public final ArrayList f9696j;

    public boolean f9697k;

    public CharSequence f9699m;

    public Drawable f9700n;

    public View f9701o;

    public C2840n f9708v;

    public boolean f9710x;

    public int f9698l = 0;

    public boolean f9702p = false;

    public boolean f9703q = false;

    public boolean f9704r = false;

    public boolean f9705s = false;

    public final ArrayList f9706t = new ArrayList();

    public final CopyOnWriteArrayList f9707u = new CopyOnWriteArrayList();

    public boolean f9709w = false;

    public MenuC2838l(Context context) {
        boolean zM6356b;
        boolean z7 = false;
        this.f9687a = context;
        Resources resources = context.getResources();
        this.f9688b = resources;
        this.f9692f = new ArrayList();
        this.f9693g = new ArrayList();
        this.f9694h = true;
        this.f9695i = new ArrayList();
        this.f9696j = new ArrayList();
        this.f9697k = true;
        if (resources.getConfiguration().keyboard != 1) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            Method method = AbstractC3167w0.f10655a;
            if (Build.VERSION.SDK_INT >= 28) {
                zM6356b = AbstractC3161u0.m6356b(viewConfiguration);
            } else {
                Resources resources2 = context.getResources();
                int identifier = resources2.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
                zM6356b = identifier != 0 && resources2.getBoolean(identifier);
            }
            if (zM6356b) {
                z7 = true;
            }
        }
        this.f9690d = z7;
    }

    public C2840n mo4297a(int i6, int i10, int i11, CharSequence charSequence) {
        int i12;
        int i13 = ((-65536) & i11) >> 16;
        if (i13 < 0 || i13 >= 6) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i14 = (f9686y[i13] << 16) | (65535 & i11);
        C2840n c2840n = new C2840n(this, i6, i10, i11, i14, charSequence, this.f9698l);
        ArrayList arrayList = this.f9692f;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((C2840n) arrayList.get(size)).f9720d <= i14) {
                i12 = size + 1;
                arrayList.add(i12, c2840n);
                mo4279p(true);
                return c2840n;
            }
        }
        i12 = 0;
        arrayList.add(i12, c2840n);
        mo4279p(true);
        return c2840n;
    }

    @Override
    public final MenuItem add(CharSequence charSequence) {
        return mo4297a(0, 0, 0, charSequence);
    }

    @Override
    public final int addIntentOptions(int i6, int i10, int i11, ComponentName componentName, Intent[] intentArr, Intent intent, int i12, MenuItem[] menuItemArr) {
        int i13;
        PackageManager packageManager = this.f9687a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i12 & 1) == 0) {
            removeGroup(i6);
        }
        for (int i14 = 0; i14 < size; i14++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i14);
            int i15 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i15 < 0 ? intent : intentArr[i15]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            C2840n c2840nMo4297a = mo4297a(i6, i10, i11, resolveInfo.loadLabel(packageManager));
            c2840nMo4297a.setIcon(resolveInfo.loadIcon(packageManager));
            c2840nMo4297a.f9723g = intent2;
            if (menuItemArr != null && (i13 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i13] = c2840nMo4297a;
            }
        }
        return size;
    }

    @Override
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public final void m5826b(InterfaceC2851y interfaceC2851y, Context context) {
        this.f9707u.add(new WeakReference(interfaceC2851y));
        interfaceC2851y.mo713k(context, this);
        this.f9697k = true;
    }

    public final void m5827c(boolean z7) {
        if (this.f9705s) {
            return;
        }
        this.f9705s = true;
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f9707u;
        for (WeakReference weakReference : copyOnWriteArrayList) {
            InterfaceC2851y interfaceC2851y = (InterfaceC2851y) weakReference.get();
            if (interfaceC2851y == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                interfaceC2851y.mo707b(this, z7);
            }
        }
        this.f9705s = false;
    }

    @Override
    public final void clear() {
        C2840n c2840n = this.f9708v;
        if (c2840n != null) {
            mo5813d(c2840n);
        }
        this.f9692f.clear();
        mo4279p(true);
    }

    public final void clearHeader() {
        this.f9700n = null;
        this.f9699m = null;
        this.f9701o = null;
        mo4279p(false);
    }

    @Override
    public final void close() {
        m5827c(true);
    }

    public boolean mo5813d(C2840n c2840n) {
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f9707u;
        boolean zMo764f = false;
        if (!copyOnWriteArrayList.isEmpty() && this.f9708v == c2840n) {
            m5840y();
            for (WeakReference weakReference : copyOnWriteArrayList) {
                InterfaceC2851y interfaceC2851y = (InterfaceC2851y) weakReference.get();
                if (interfaceC2851y != null) {
                    zMo764f = interfaceC2851y.mo764f(c2840n);
                    if (zMo764f) {
                        break;
                    }
                } else {
                    copyOnWriteArrayList.remove(weakReference);
                }
            }
            m5839x();
            if (zMo764f) {
                this.f9708v = null;
            }
        }
        return zMo764f;
    }

    public boolean mo5814e(MenuC2838l menuC2838l, MenuItem menuItem) {
        InterfaceC2836j interfaceC2836j = this.f9691e;
        return interfaceC2836j != null && interfaceC2836j.mo94j(menuC2838l, menuItem);
    }

    public boolean mo5815f(C2840n c2840n) {
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f9707u;
        boolean zMo763d = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        m5840y();
        for (WeakReference weakReference : copyOnWriteArrayList) {
            InterfaceC2851y interfaceC2851y = (InterfaceC2851y) weakReference.get();
            if (interfaceC2851y != null) {
                zMo763d = interfaceC2851y.mo763d(c2840n);
                if (zMo763d) {
                    break;
                }
            } else {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
        m5839x();
        if (zMo763d) {
            this.f9708v = c2840n;
        }
        return zMo763d;
    }

    @Override
    public final MenuItem findItem(int i6) {
        MenuItem menuItemFindItem;
        ArrayList arrayList = this.f9692f;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            C2840n c2840n = (C2840n) arrayList.get(i10);
            if (c2840n.f9717a == i6) {
                return c2840n;
            }
            if (c2840n.hasSubMenu() && (menuItemFindItem = c2840n.f9731o.findItem(i6)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public final C2840n m5828g(int i6, KeyEvent keyEvent) {
        ArrayList arrayList = this.f9706t;
        arrayList.clear();
        m5829h(arrayList, i6, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (C2840n) arrayList.get(0);
        }
        boolean zMo5819n = mo5819n();
        for (int i10 = 0; i10 < size; i10++) {
            C2840n c2840n = (C2840n) arrayList.get(i10);
            char c5 = zMo5819n ? c2840n.f9726j : c2840n.f9724h;
            char[] cArr = keyData.meta;
            if ((c5 == cArr[0] && (metaState & 2) == 0) || ((c5 == cArr[2] && (metaState & 2) != 0) || (zMo5819n && c5 == '\b' && i6 == 67))) {
                return c2840n;
            }
        }
        return null;
    }

    @Override
    public final MenuItem getItem(int i6) {
        return (MenuItem) this.f9692f.get(i6);
    }

    public final void m5829h(ArrayList arrayList, int i6, KeyEvent keyEvent) {
        boolean zMo5819n = mo5819n();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i6 == 67) {
            ArrayList arrayList2 = this.f9692f;
            int size = arrayList2.size();
            for (int i10 = 0; i10 < size; i10++) {
                C2840n c2840n = (C2840n) arrayList2.get(i10);
                if (c2840n.hasSubMenu()) {
                    c2840n.f9731o.m5829h(arrayList, i6, keyEvent);
                }
                char c5 = zMo5819n ? c2840n.f9726j : c2840n.f9724h;
                if ((modifiers & 69647) == ((zMo5819n ? c2840n.f9727k : c2840n.f9725i) & 69647) && c5 != 0) {
                    char[] cArr = keyData.meta;
                    if (c5 != cArr[0] && c5 != cArr[2]) {
                        if (zMo5819n && c5 == '\b') {
                            if (i6 == 67) {
                            }
                        }
                    }
                    if (c2840n.isEnabled()) {
                        arrayList.add(c2840n);
                    }
                }
            }
        }
    }

    @Override
    public final boolean hasVisibleItems() {
        if (this.f9710x) {
            return true;
        }
        ArrayList arrayList = this.f9692f;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (((C2840n) arrayList.get(i6)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void m5830i() {
        ArrayList arrayListM5831l = m5831l();
        if (this.f9697k) {
            CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f9707u;
            boolean zMo714l = false;
            for (WeakReference weakReference : copyOnWriteArrayList) {
                InterfaceC2851y interfaceC2851y = (InterfaceC2851y) weakReference.get();
                if (interfaceC2851y == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    zMo714l |= interfaceC2851y.mo714l();
                }
            }
            ArrayList arrayList = this.f9695i;
            ArrayList arrayList2 = this.f9696j;
            if (zMo714l) {
                arrayList.clear();
                arrayList2.clear();
                int size = arrayListM5831l.size();
                for (int i6 = 0; i6 < size; i6++) {
                    C2840n c2840n = (C2840n) arrayListM5831l.get(i6);
                    if (c2840n.m5844f()) {
                        arrayList.add(c2840n);
                    } else {
                        arrayList2.add(c2840n);
                    }
                }
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList2.addAll(m5831l());
            }
            this.f9697k = false;
        }
    }

    @Override
    public final boolean isShortcutKey(int i6, KeyEvent keyEvent) {
        return m5828g(i6, keyEvent) != null;
    }

    public String mo5816j() {
        return "android:menu:actionviewstates";
    }

    public final ArrayList m5831l() {
        boolean z7 = this.f9694h;
        ArrayList arrayList = this.f9693g;
        if (!z7) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList arrayList2 = this.f9692f;
        int size = arrayList2.size();
        for (int i6 = 0; i6 < size; i6++) {
            C2840n c2840n = (C2840n) arrayList2.get(i6);
            if (c2840n.isVisible()) {
                arrayList.add(c2840n);
            }
        }
        this.f9694h = false;
        this.f9697k = true;
        return arrayList;
    }

    public boolean mo5818m() {
        return this.f9709w;
    }

    public boolean mo5819n() {
        return this.f9689c;
    }

    public boolean mo5820o() {
        return this.f9690d;
    }

    public void mo4279p(boolean z7) {
        if (this.f9702p) {
            this.f9703q = true;
            if (z7) {
                this.f9704r = true;
                return;
            }
            return;
        }
        if (z7) {
            this.f9694h = true;
            this.f9697k = true;
        }
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f9707u;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        m5840y();
        for (WeakReference weakReference : copyOnWriteArrayList) {
            InterfaceC2851y interfaceC2851y = (InterfaceC2851y) weakReference.get();
            if (interfaceC2851y == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                interfaceC2851y.mo712j(z7);
            }
        }
        m5839x();
    }

    @Override
    public final boolean performIdentifierAction(int i6, int i10) {
        return m5832q(findItem(i6), null, i10);
    }

    @Override
    public final boolean performShortcut(int i6, KeyEvent keyEvent, int i10) {
        C2840n c2840nM5828g = m5828g(i6, keyEvent);
        boolean zM5832q = c2840nM5828g != null ? m5832q(c2840nM5828g, null, i10) : false;
        if ((i10 & 2) != 0) {
            m5827c(true);
        }
        return zM5832q;
    }

    public final boolean m5832q(MenuItem menuItem, InterfaceC2851y interfaceC2851y, int i6) {
        AbstractC3106c abstractC3106c;
        boolean zExpandActionView;
        AbstractC3106c abstractC3106c2;
        boolean z7;
        SubMenuC2831e0 subMenuC2831e0;
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList;
        InterfaceC2851y interfaceC2851y2;
        C2840n c2840n = (C2840n) menuItem;
        boolean zMo709e = false;
        if (c2840n == null || !c2840n.isEnabled()) {
            return false;
        }
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = c2840n.f9732p;
        if (onMenuItemClickListener == null || !onMenuItemClickListener.onMenuItemClick(c2840n)) {
            MenuC2838l menuC2838l = c2840n.f9730n;
            if (menuC2838l.mo5814e(menuC2838l, c2840n)) {
                zExpandActionView = true;
            } else {
                Intent intent = c2840n.f9723g;
                if (intent != null) {
                    try {
                        menuC2838l.f9687a.startActivity(intent);
                    } catch (ActivityNotFoundException e5) {
                        Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e5);
                        abstractC3106c = c2840n.f9714A;
                        if (abstractC3106c == null) {
                        }
                        zExpandActionView = false;
                        abstractC3106c2 = c2840n.f9714A;
                        if (abstractC3106c2 == null) {
                            z7 = false;
                        } else {
                            z7 = false;
                        }
                        if (c2840n.m5843e()) {
                            zExpandActionView |= c2840n.expandActionView();
                            if (zExpandActionView) {
                                m5827c(true);
                            }
                        } else if (c2840n.hasSubMenu()) {
                            if ((i6 & 4) == 0) {
                                m5827c(false);
                            }
                            if (!c2840n.hasSubMenu()) {
                                SubMenuC2831e0 subMenuC2831e1 = new SubMenuC2831e0(this.f9687a, this, c2840n);
                                c2840n.f9731o = subMenuC2831e1;
                                subMenuC2831e1.setHeaderTitle(c2840n.f9721e);
                            }
                            subMenuC2831e0 = c2840n.f9731o;
                            if (z7) {
                                ActionProviderVisibilityListenerC2841o actionProviderVisibilityListenerC2841o = (ActionProviderVisibilityListenerC2841o) abstractC3106c2;
                                actionProviderVisibilityListenerC2841o.f9744c.getClass();
                                actionProviderVisibilityListenerC2841o.f9743b.onPrepareSubMenu(subMenuC2831e0);
                            }
                            copyOnWriteArrayList = this.f9707u;
                            if (!copyOnWriteArrayList.isEmpty()) {
                                if (interfaceC2851y != null) {
                                }
                                for (WeakReference weakReference : copyOnWriteArrayList) {
                                    interfaceC2851y2 = (InterfaceC2851y) weakReference.get();
                                    if (interfaceC2851y2 == null) {
                                        copyOnWriteArrayList.remove(weakReference);
                                    } else if (!zMo709e) {
                                        zMo709e = interfaceC2851y2.mo709e(subMenuC2831e0);
                                    }
                                }
                            }
                            zExpandActionView |= zMo709e;
                            if (!zExpandActionView) {
                                m5827c(true);
                            }
                        } else {
                            if ((i6 & 4) == 0) {
                                m5827c(false);
                            }
                            if (!c2840n.hasSubMenu()) {
                                SubMenuC2831e0 subMenuC2831e2 = new SubMenuC2831e0(this.f9687a, this, c2840n);
                                c2840n.f9731o = subMenuC2831e2;
                                subMenuC2831e2.setHeaderTitle(c2840n.f9721e);
                            }
                            subMenuC2831e0 = c2840n.f9731o;
                            if (z7) {
                                ActionProviderVisibilityListenerC2841o actionProviderVisibilityListenerC2841o2 = (ActionProviderVisibilityListenerC2841o) abstractC3106c2;
                                actionProviderVisibilityListenerC2841o2.f9744c.getClass();
                                actionProviderVisibilityListenerC2841o2.f9743b.onPrepareSubMenu(subMenuC2831e0);
                            }
                            copyOnWriteArrayList = this.f9707u;
                            if (!copyOnWriteArrayList.isEmpty()) {
                                zMo709e = interfaceC2851y != null ? interfaceC2851y.mo709e(subMenuC2831e0) : false;
                                while (r8.hasNext()) {
                                    interfaceC2851y2 = (InterfaceC2851y) weakReference.get();
                                    if (interfaceC2851y2 == null) {
                                        copyOnWriteArrayList.remove(weakReference);
                                    } else if (!zMo709e) {
                                        zMo709e = interfaceC2851y2.mo709e(subMenuC2831e0);
                                    }
                                }
                            }
                            zExpandActionView |= zMo709e;
                            if (!zExpandActionView) {
                                m5827c(true);
                            }
                        }
                        return zExpandActionView;
                    }
                    zExpandActionView = true;
                } else {
                    abstractC3106c = c2840n.f9714A;
                    if (abstractC3106c == null && ((ActionProviderVisibilityListenerC2841o) abstractC3106c).f9743b.onPerformDefaultAction()) {
                        zExpandActionView = true;
                    } else {
                        zExpandActionView = false;
                    }
                }
            }
        } else {
            zExpandActionView = true;
        }
        abstractC3106c2 = c2840n.f9714A;
        if (abstractC3106c2 == null && ((ActionProviderVisibilityListenerC2841o) abstractC3106c2).f9743b.hasSubMenu()) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (c2840n.m5843e()) {
            zExpandActionView |= c2840n.expandActionView();
            if (zExpandActionView) {
                m5827c(true);
            }
        } else if (c2840n.hasSubMenu() || z7) {
            if ((i6 & 4) == 0) {
                m5827c(false);
            }
            if (!c2840n.hasSubMenu()) {
                SubMenuC2831e0 subMenuC2831e3 = new SubMenuC2831e0(this.f9687a, this, c2840n);
                c2840n.f9731o = subMenuC2831e3;
                subMenuC2831e3.setHeaderTitle(c2840n.f9721e);
            }
            subMenuC2831e0 = c2840n.f9731o;
            if (z7) {
                ActionProviderVisibilityListenerC2841o actionProviderVisibilityListenerC2841o3 = (ActionProviderVisibilityListenerC2841o) abstractC3106c2;
                actionProviderVisibilityListenerC2841o3.f9744c.getClass();
                actionProviderVisibilityListenerC2841o3.f9743b.onPrepareSubMenu(subMenuC2831e0);
            }
            copyOnWriteArrayList = this.f9707u;
            if (!copyOnWriteArrayList.isEmpty()) {
                if (interfaceC2851y != null) {
                }
                while (r8.hasNext()) {
                    interfaceC2851y2 = (InterfaceC2851y) weakReference.get();
                    if (interfaceC2851y2 == null) {
                        copyOnWriteArrayList.remove(weakReference);
                    } else if (!zMo709e) {
                        zMo709e = interfaceC2851y2.mo709e(subMenuC2831e0);
                    }
                }
            }
            zExpandActionView |= zMo709e;
            if (!zExpandActionView) {
                m5827c(true);
            }
        } else if ((i6 & 1) == 0) {
            m5827c(true);
        }
        return zExpandActionView;
    }

    public final void m5833r(InterfaceC2851y interfaceC2851y) {
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f9707u;
        for (WeakReference weakReference : copyOnWriteArrayList) {
            InterfaceC2851y interfaceC2851y2 = (InterfaceC2851y) weakReference.get();
            if (interfaceC2851y2 == null || interfaceC2851y2 == interfaceC2851y) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
    }

    @Override
    public final void removeGroup(int i6) {
        ArrayList arrayList = this.f9692f;
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                i11 = -1;
                break;
            } else if (((C2840n) arrayList.get(i11)).f9718b == i6) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 >= 0) {
            int size2 = arrayList.size() - i11;
            while (true) {
                int i12 = i10 + 1;
                if (i10 >= size2 || ((C2840n) arrayList.get(i11)).f9718b != i6) {
                    break;
                }
                if (i11 >= 0) {
                    ArrayList arrayList2 = this.f9692f;
                    if (i11 < arrayList2.size()) {
                        arrayList2.remove(i11);
                    }
                }
                i10 = i12;
            }
            mo4279p(true);
        }
    }

    @Override
    public final void removeItem(int i6) {
        ArrayList arrayList = this.f9692f;
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            } else if (((C2840n) arrayList.get(i10)).f9717a == i6) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 >= 0) {
            ArrayList arrayList2 = this.f9692f;
            if (i10 >= arrayList2.size()) {
                return;
            }
            arrayList2.remove(i10);
            mo4279p(true);
        }
    }

    public final void m5834s(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(mo5816j());
        int size = this.f9692f.size();
        for (int i6 = 0; i6 < size; i6++) {
            MenuItem item = getItem(i6);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((SubMenuC2831e0) item.getSubMenu()).m5834s(bundle);
            }
        }
        int i10 = bundle.getInt("android:menu:expandedactionview");
        if (i10 <= 0 || (menuItemFindItem = findItem(i10)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    @Override
    public final void setGroupCheckable(int i6, boolean z7, boolean z10) {
        ArrayList arrayList = this.f9692f;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            C2840n c2840n = (C2840n) arrayList.get(i10);
            if (c2840n.f9718b == i6) {
                c2840n.m5845g(z10);
                c2840n.setCheckable(z7);
            }
        }
    }

    @Override
    public void setGroupDividerEnabled(boolean z7) {
        this.f9709w = z7;
    }

    @Override
    public final void setGroupEnabled(int i6, boolean z7) {
        ArrayList arrayList = this.f9692f;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            C2840n c2840n = (C2840n) arrayList.get(i10);
            if (c2840n.f9718b == i6) {
                c2840n.setEnabled(z7);
            }
        }
    }

    @Override
    public final void setGroupVisible(int i6, boolean z7) {
        ArrayList arrayList = this.f9692f;
        int size = arrayList.size();
        boolean z10 = false;
        for (int i10 = 0; i10 < size; i10++) {
            C2840n c2840n = (C2840n) arrayList.get(i10);
            if (c2840n.f9718b == i6) {
                int i11 = c2840n.f9740x;
                int i12 = (i11 & (-9)) | (z7 ? 0 : 8);
                c2840n.f9740x = i12;
                if (i11 != i12) {
                    z10 = true;
                }
            }
        }
        if (z10) {
            mo4279p(true);
        }
    }

    @Override
    public void setQwertyMode(boolean z7) {
        this.f9689c = z7;
        mo4279p(false);
    }

    @Override
    public final int size() {
        return this.f9692f.size();
    }

    public final void m5835t(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null) {
            CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f9707u;
            if (copyOnWriteArrayList.isEmpty()) {
                return;
            }
            for (WeakReference weakReference : copyOnWriteArrayList) {
                InterfaceC2851y interfaceC2851y = (InterfaceC2851y) weakReference.get();
                if (interfaceC2851y == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    int id = interfaceC2851y.getId();
                    if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                        interfaceC2851y.mo710g(parcelable);
                    }
                }
            }
        }
    }

    public final void m5836u(Bundle bundle) {
        int size = this.f9692f.size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i6 = 0; i6 < size; i6++) {
            MenuItem item = getItem(i6);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((SubMenuC2831e0) item.getSubMenu()).m5836u(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(mo5816j(), sparseArray);
        }
    }

    public final void m5837v(Bundle bundle) {
        Parcelable parcelableMo715m;
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f9707u;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        for (WeakReference weakReference : copyOnWriteArrayList) {
            InterfaceC2851y interfaceC2851y = (InterfaceC2851y) weakReference.get();
            if (interfaceC2851y == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                int id = interfaceC2851y.getId();
                if (id > 0 && (parcelableMo715m = interfaceC2851y.mo715m()) != null) {
                    sparseArray.put(id, parcelableMo715m);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
    }

    public final void m5838w(int i6, CharSequence charSequence, int i10, Drawable drawable, View view) {
        if (view != null) {
            this.f9701o = view;
            this.f9699m = null;
            this.f9700n = null;
        } else {
            if (i6 > 0) {
                this.f9699m = this.f9688b.getText(i6);
            } else if (charSequence != null) {
                this.f9699m = charSequence;
            }
            if (i10 > 0) {
                this.f9700n = AbstractC2115a.m5069b(this.f9687a, i10);
            } else if (drawable != null) {
                this.f9700n = drawable;
            }
            this.f9701o = null;
        }
        mo4279p(false);
    }

    public final void m5839x() {
        this.f9702p = false;
        if (this.f9703q) {
            this.f9703q = false;
            mo4279p(this.f9704r);
        }
    }

    public final void m5840y() {
        if (this.f9702p) {
            return;
        }
        this.f9702p = true;
        this.f9703q = false;
        this.f9704r = false;
    }

    @Override
    public final MenuItem add(int i6) {
        return mo4297a(0, 0, 0, this.f9688b.getString(i6));
    }

    @Override
    public final SubMenu addSubMenu(int i6) {
        return addSubMenu(0, 0, 0, this.f9688b.getString(i6));
    }

    @Override
    public final MenuItem add(int i6, int i10, int i11, CharSequence charSequence) {
        return mo4297a(i6, i10, i11, charSequence);
    }

    @Override
    public SubMenu addSubMenu(int i6, int i10, int i11, CharSequence charSequence) {
        C2840n c2840nMo4297a = mo4297a(i6, i10, i11, charSequence);
        SubMenuC2831e0 subMenuC2831e0 = new SubMenuC2831e0(this.f9687a, this, c2840nMo4297a);
        c2840nMo4297a.f9731o = subMenuC2831e0;
        subMenuC2831e0.setHeaderTitle(c2840nMo4297a.f9721e);
        return subMenuC2831e0;
    }

    @Override
    public final MenuItem add(int i6, int i10, int i11, int i12) {
        return mo4297a(i6, i10, i11, this.f9688b.getString(i12));
    }

    @Override
    public final SubMenu addSubMenu(int i6, int i10, int i11, int i12) {
        return addSubMenu(i6, i10, i11, this.f9688b.getString(i12));
    }

    public MenuC2838l mo5817k() {
        return this;
    }
}

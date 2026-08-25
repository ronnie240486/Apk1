package p105k;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.app.AbstractC0127c0;
import p074h0.InterfaceMenuItemC2638a;
import p160p.C3347k;

public class MenuC2825b0 extends AbstractC0127c0 implements Menu {

    public final MenuC2838l f9608c;

    public MenuC2825b0(Context context, MenuC2838l menuC2838l) {
        super(context);
        if (menuC2838l == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f9608c = menuC2838l;
    }

    @Override
    public final MenuItem add(CharSequence charSequence) {
        return m374g(this.f9608c.mo4297a(0, 0, 0, charSequence));
    }

    @Override
    public final int addIntentOptions(int i6, int i10, int i11, ComponentName componentName, Intent[] intentArr, Intent intent, int i12, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = this.f9608c.addIntentOptions(i6, i10, i11, componentName, intentArr, intent, i12, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i13 = 0; i13 < length; i13++) {
                menuItemArr[i13] = m374g(menuItemArr2[i13]);
            }
        }
        return iAddIntentOptions;
    }

    @Override
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return this.f9608c.addSubMenu(0, 0, 0, charSequence);
    }

    @Override
    public final void clear() {
        C3347k c3347k = (C3347k) this.f269b;
        if (c3347k != null) {
            c3347k.clear();
        }
        this.f9608c.clear();
    }

    @Override
    public final void close() {
        this.f9608c.close();
    }

    @Override
    public final MenuItem findItem(int i6) {
        return m374g(this.f9608c.findItem(i6));
    }

    @Override
    public final MenuItem getItem(int i6) {
        return m374g(this.f9608c.getItem(i6));
    }

    @Override
    public final boolean hasVisibleItems() {
        return this.f9608c.hasVisibleItems();
    }

    @Override
    public final boolean isShortcutKey(int i6, KeyEvent keyEvent) {
        return this.f9608c.isShortcutKey(i6, keyEvent);
    }

    @Override
    public final boolean performIdentifierAction(int i6, int i10) {
        return this.f9608c.performIdentifierAction(i6, i10);
    }

    @Override
    public final boolean performShortcut(int i6, KeyEvent keyEvent, int i10) {
        return this.f9608c.performShortcut(i6, keyEvent, i10);
    }

    @Override
    public final void removeGroup(int i6) {
        if (((C3347k) this.f269b) != null) {
            int i10 = 0;
            while (true) {
                C3347k c3347k = (C3347k) this.f269b;
                if (i10 >= c3347k.f11334c) {
                    break;
                }
                if (((InterfaceMenuItemC2638a) c3347k.m6812f(i10)).getGroupId() == i6) {
                    ((C3347k) this.f269b).mo6814h(i10);
                    i10--;
                }
                i10++;
            }
        }
        this.f9608c.removeGroup(i6);
    }

    @Override
    public final void removeItem(int i6) {
        if (((C3347k) this.f269b) != null) {
            int i10 = 0;
            while (true) {
                C3347k c3347k = (C3347k) this.f269b;
                if (i10 >= c3347k.f11334c) {
                    break;
                }
                if (((InterfaceMenuItemC2638a) c3347k.m6812f(i10)).getItemId() == i6) {
                    ((C3347k) this.f269b).mo6814h(i10);
                    break;
                }
                i10++;
            }
        }
        this.f9608c.removeItem(i6);
    }

    @Override
    public final void setGroupCheckable(int i6, boolean z7, boolean z10) {
        this.f9608c.setGroupCheckable(i6, z7, z10);
    }

    @Override
    public final void setGroupEnabled(int i6, boolean z7) {
        this.f9608c.setGroupEnabled(i6, z7);
    }

    @Override
    public final void setGroupVisible(int i6, boolean z7) {
        this.f9608c.setGroupVisible(i6, z7);
    }

    @Override
    public final void setQwertyMode(boolean z7) {
        this.f9608c.setQwertyMode(z7);
    }

    @Override
    public final int size() {
        return this.f9608c.size();
    }

    @Override
    public final SubMenu addSubMenu(int i6) {
        return this.f9608c.addSubMenu(i6);
    }

    @Override
    public final MenuItem add(int i6) {
        return m374g(this.f9608c.add(i6));
    }

    @Override
    public final SubMenu addSubMenu(int i6, int i10, int i11, CharSequence charSequence) {
        return this.f9608c.addSubMenu(i6, i10, i11, charSequence);
    }

    @Override
    public final MenuItem add(int i6, int i10, int i11, CharSequence charSequence) {
        return m374g(this.f9608c.mo4297a(i6, i10, i11, charSequence));
    }

    @Override
    public final SubMenu addSubMenu(int i6, int i10, int i11, int i12) {
        return this.f9608c.addSubMenu(i6, i10, i11, i12);
    }

    @Override
    public final MenuItem add(int i6, int i10, int i11, int i12) {
        return m374g(this.f9608c.add(i6, i10, i11, i12));
    }
}

package p105k;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bumptech.glide.AbstractC1465c;
import java.util.ArrayList;
import p065g0.AbstractC2581a;
import p074h0.InterfaceMenuItemC2638a;
import p101j7.C2782c;
import p138n0.AbstractC3106c;
import p143n5.AbstractC3198d;

public final class C2840n implements InterfaceMenuItemC2638a {

    public AbstractC3106c f9714A;

    public MenuItem.OnActionExpandListener f9715B;

    public final int f9717a;

    public final int f9718b;

    public final int f9719c;

    public final int f9720d;

    public CharSequence f9721e;

    public CharSequence f9722f;

    public Intent f9723g;

    public char f9724h;

    public char f9726j;

    public Drawable f9728l;

    public final MenuC2838l f9730n;

    public SubMenuC2831e0 f9731o;

    public MenuItem.OnMenuItemClickListener f9732p;

    public CharSequence f9733q;

    public CharSequence f9734r;

    public int f9741y;

    public View f9742z;

    public int f9725i = 4096;

    public int f9727k = 4096;

    public int f9729m = 0;

    public ColorStateList f9735s = null;

    public PorterDuff.Mode f9736t = null;

    public boolean f9737u = false;

    public boolean f9738v = false;

    public boolean f9739w = false;

    public int f9740x = 16;

    public boolean f9716C = false;

    public C2840n(MenuC2838l menuC2838l, int i6, int i10, int i11, int i12, CharSequence charSequence, int i13) {
        this.f9730n = menuC2838l;
        this.f9717a = i10;
        this.f9718b = i6;
        this.f9719c = i11;
        this.f9720d = i12;
        this.f9721e = charSequence;
        this.f9741y = i13;
    }

    public static void m5841c(StringBuilder sb, int i6, int i10, String str) {
        if ((i6 & i10) == i10) {
            sb.append(str);
        }
    }

    @Override
    public final AbstractC3106c mo5659a() {
        return this.f9714A;
    }

    @Override
    public final InterfaceMenuItemC2638a mo5660b(AbstractC3106c abstractC3106c) {
        AbstractC3106c abstractC3106c2 = this.f9714A;
        if (abstractC3106c2 != null) {
            abstractC3106c2.f10578a = null;
        }
        this.f9742z = null;
        this.f9714A = abstractC3106c;
        this.f9730n.mo4279p(true);
        AbstractC3106c abstractC3106c3 = this.f9714A;
        if (abstractC3106c3 != null) {
            abstractC3106c3.mo5850d(new C2782c(2, this));
        }
        return this;
    }

    @Override
    public final boolean collapseActionView() {
        if ((this.f9741y & 8) == 0) {
            return false;
        }
        if (this.f9742z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f9715B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f9730n.mo5813d(this);
        }
        return false;
    }

    public final Drawable m5842d(Drawable drawable) {
        if (drawable != null && this.f9739w && (this.f9737u || this.f9738v)) {
            drawable = AbstractC3198d.m6448W(drawable).mutate();
            if (this.f9737u) {
                AbstractC2581a.m5586h(drawable, this.f9735s);
            }
            if (this.f9738v) {
                AbstractC2581a.m5587i(drawable, this.f9736t);
            }
            this.f9739w = false;
        }
        return drawable;
    }

    public final boolean m5843e() {
        AbstractC3106c abstractC3106c;
        if ((this.f9741y & 8) == 0) {
            return false;
        }
        if (this.f9742z == null && (abstractC3106c = this.f9714A) != null) {
            this.f9742z = abstractC3106c.mo5848b(this);
        }
        return this.f9742z != null;
    }

    @Override
    public final boolean expandActionView() {
        if (!m5843e()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f9715B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f9730n.mo5815f(this);
        }
        return false;
    }

    public final boolean m5844f() {
        return (this.f9740x & 32) == 32;
    }

    public final void m5845g(boolean z7) {
        this.f9740x = (z7 ? 4 : 0) | (this.f9740x & (-5));
    }

    @Override
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override
    public final View getActionView() {
        View view = this.f9742z;
        if (view != null) {
            return view;
        }
        AbstractC3106c abstractC3106c = this.f9714A;
        if (abstractC3106c == null) {
            return null;
        }
        View viewMo5848b = abstractC3106c.mo5848b(this);
        this.f9742z = viewMo5848b;
        return viewMo5848b;
    }

    @Override
    public final int getAlphabeticModifiers() {
        return this.f9727k;
    }

    @Override
    public final char getAlphabeticShortcut() {
        return this.f9726j;
    }

    @Override
    public final CharSequence getContentDescription() {
        return this.f9733q;
    }

    @Override
    public final int getGroupId() {
        return this.f9718b;
    }

    @Override
    public final Drawable getIcon() {
        Drawable drawable = this.f9728l;
        if (drawable != null) {
            return m5842d(drawable);
        }
        int i6 = this.f9729m;
        if (i6 == 0) {
            return null;
        }
        Drawable drawableM3473h = AbstractC1465c.m3473h(this.f9730n.f9687a, i6);
        this.f9729m = 0;
        this.f9728l = drawableM3473h;
        return m5842d(drawableM3473h);
    }

    @Override
    public final ColorStateList getIconTintList() {
        return this.f9735s;
    }

    @Override
    public final PorterDuff.Mode getIconTintMode() {
        return this.f9736t;
    }

    @Override
    public final Intent getIntent() {
        return this.f9723g;
    }

    @Override
    public final int getItemId() {
        return this.f9717a;
    }

    @Override
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override
    public final int getNumericModifiers() {
        return this.f9725i;
    }

    @Override
    public final char getNumericShortcut() {
        return this.f9724h;
    }

    @Override
    public final int getOrder() {
        return this.f9719c;
    }

    @Override
    public final SubMenu getSubMenu() {
        return this.f9731o;
    }

    @Override
    public final CharSequence getTitle() {
        return this.f9721e;
    }

    @Override
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f9722f;
        return charSequence != null ? charSequence : this.f9721e;
    }

    @Override
    public final CharSequence getTooltipText() {
        return this.f9734r;
    }

    public final void m5846h(boolean z7) {
        if (z7) {
            this.f9740x |= 32;
        } else {
            this.f9740x &= -33;
        }
    }

    @Override
    public final boolean hasSubMenu() {
        return this.f9731o != null;
    }

    @Override
    public final boolean isActionViewExpanded() {
        return this.f9716C;
    }

    @Override
    public final boolean isCheckable() {
        return (this.f9740x & 1) == 1;
    }

    @Override
    public final boolean isChecked() {
        return (this.f9740x & 2) == 2;
    }

    @Override
    public final boolean isEnabled() {
        return (this.f9740x & 16) != 0;
    }

    @Override
    public final boolean isVisible() {
        AbstractC3106c abstractC3106c = this.f9714A;
        if (abstractC3106c == null || !abstractC3106c.mo5849c()) {
            return (this.f9740x & 8) == 0;
        }
        return (this.f9740x & 8) == 0 && this.f9714A.mo5847a();
    }

    @Override
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override
    public final MenuItem setActionView(View view) {
        int i6;
        this.f9742z = view;
        this.f9714A = null;
        if (view != null && view.getId() == -1 && (i6 = this.f9717a) > 0) {
            view.setId(i6);
        }
        MenuC2838l menuC2838l = this.f9730n;
        menuC2838l.f9697k = true;
        menuC2838l.mo4279p(true);
        return this;
    }

    @Override
    public final MenuItem setAlphabeticShortcut(char c5) {
        if (this.f9726j == c5) {
            return this;
        }
        this.f9726j = Character.toLowerCase(c5);
        this.f9730n.mo4279p(false);
        return this;
    }

    @Override
    public final MenuItem setCheckable(boolean z7) {
        int i6 = this.f9740x;
        int i10 = (z7 ? 1 : 0) | (i6 & (-2));
        this.f9740x = i10;
        if (i6 != i10) {
            this.f9730n.mo4279p(false);
        }
        return this;
    }

    @Override
    public final MenuItem setChecked(boolean z7) {
        int i6 = this.f9740x;
        if ((i6 & 4) != 0) {
            MenuC2838l menuC2838l = this.f9730n;
            menuC2838l.getClass();
            ArrayList arrayList = menuC2838l.f9692f;
            int size = arrayList.size();
            menuC2838l.m5840y();
            for (int i10 = 0; i10 < size; i10++) {
                C2840n c2840n = (C2840n) arrayList.get(i10);
                if (c2840n.f9718b == this.f9718b && (c2840n.f9740x & 4) != 0 && c2840n.isCheckable()) {
                    boolean z10 = c2840n == this;
                    int i11 = c2840n.f9740x;
                    int i12 = (z10 ? 2 : 0) | (i11 & (-3));
                    c2840n.f9740x = i12;
                    if (i11 != i12) {
                        c2840n.f9730n.mo4279p(false);
                    }
                }
            }
            menuC2838l.m5839x();
        } else {
            int i13 = (i6 & (-3)) | (z7 ? 2 : 0);
            this.f9740x = i13;
            if (i6 != i13) {
                this.f9730n.mo4279p(false);
            }
        }
        return this;
    }

    @Override
    public final MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override
    public final MenuItem setEnabled(boolean z7) {
        if (z7) {
            this.f9740x |= 16;
        } else {
            this.f9740x &= -17;
        }
        this.f9730n.mo4279p(false);
        return this;
    }

    @Override
    public final MenuItem setIcon(Drawable drawable) {
        this.f9729m = 0;
        this.f9728l = drawable;
        this.f9739w = true;
        this.f9730n.mo4279p(false);
        return this;
    }

    @Override
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f9735s = colorStateList;
        this.f9737u = true;
        this.f9739w = true;
        this.f9730n.mo4279p(false);
        return this;
    }

    @Override
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f9736t = mode;
        this.f9738v = true;
        this.f9739w = true;
        this.f9730n.mo4279p(false);
        return this;
    }

    @Override
    public final MenuItem setIntent(Intent intent) {
        this.f9723g = intent;
        return this;
    }

    @Override
    public final MenuItem setNumericShortcut(char c5) {
        if (this.f9724h == c5) {
            return this;
        }
        this.f9724h = c5;
        this.f9730n.mo4279p(false);
        return this;
    }

    @Override
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f9715B = onActionExpandListener;
        return this;
    }

    @Override
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f9732p = onMenuItemClickListener;
        return this;
    }

    @Override
    public final MenuItem setShortcut(char c5, char c8) {
        this.f9724h = c5;
        this.f9726j = Character.toLowerCase(c8);
        this.f9730n.mo4279p(false);
        return this;
    }

    @Override
    public final void setShowAsAction(int i6) {
        int i10 = i6 & 3;
        if (i10 != 0 && i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f9741y = i6;
        MenuC2838l menuC2838l = this.f9730n;
        menuC2838l.f9697k = true;
        menuC2838l.mo4279p(true);
    }

    @Override
    public final MenuItem setShowAsActionFlags(int i6) {
        setShowAsAction(i6);
        return this;
    }

    @Override
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f9721e = charSequence;
        this.f9730n.mo4279p(false);
        SubMenuC2831e0 subMenuC2831e0 = this.f9731o;
        if (subMenuC2831e0 != null) {
            subMenuC2831e0.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f9722f = charSequence;
        this.f9730n.mo4279p(false);
        return this;
    }

    @Override
    public final MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override
    public final MenuItem setVisible(boolean z7) {
        int i6 = this.f9740x;
        int i10 = (z7 ? 0 : 8) | (i6 & (-9));
        this.f9740x = i10;
        if (i6 != i10) {
            MenuC2838l menuC2838l = this.f9730n;
            menuC2838l.f9694h = true;
            menuC2838l.mo4279p(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.f9721e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override
    public final InterfaceMenuItemC2638a setContentDescription(CharSequence charSequence) {
        this.f9733q = charSequence;
        this.f9730n.mo4279p(false);
        return this;
    }

    @Override
    public final InterfaceMenuItemC2638a setTooltipText(CharSequence charSequence) {
        this.f9734r = charSequence;
        this.f9730n.mo4279p(false);
        return this;
    }

    @Override
    public final MenuItem setAlphabeticShortcut(char c5, int i6) {
        if (this.f9726j == c5 && this.f9727k == i6) {
            return this;
        }
        this.f9726j = Character.toLowerCase(c5);
        this.f9727k = KeyEvent.normalizeMetaState(i6);
        this.f9730n.mo4279p(false);
        return this;
    }

    @Override
    public final MenuItem setNumericShortcut(char c5, int i6) {
        if (this.f9724h == c5 && this.f9725i == i6) {
            return this;
        }
        this.f9724h = c5;
        this.f9725i = KeyEvent.normalizeMetaState(i6);
        this.f9730n.mo4279p(false);
        return this;
    }

    @Override
    public final MenuItem setShortcut(char c5, char c8, int i6, int i10) {
        this.f9724h = c5;
        this.f9725i = KeyEvent.normalizeMetaState(i6);
        this.f9726j = Character.toLowerCase(c8);
        this.f9727k = KeyEvent.normalizeMetaState(i10);
        this.f9730n.mo4279p(false);
        return this;
    }

    @Override
    public final MenuItem setIcon(int i6) {
        this.f9728l = null;
        this.f9729m = i6;
        this.f9739w = true;
        this.f9730n.mo4279p(false);
        return this;
    }

    @Override
    public final MenuItem setTitle(int i6) {
        setTitle(this.f9730n.f9687a.getString(i6));
        return this;
    }

    @Override
    public final MenuItem setActionView(int i6) {
        int i10;
        Context context = this.f9730n.f9687a;
        View viewInflate = LayoutInflater.from(context).inflate(i6, (ViewGroup) new LinearLayout(context), false);
        this.f9742z = viewInflate;
        this.f9714A = null;
        if (viewInflate != null && viewInflate.getId() == -1 && (i10 = this.f9717a) > 0) {
            viewInflate.setId(i10);
        }
        MenuC2838l menuC2838l = this.f9730n;
        menuC2838l.f9697k = true;
        menuC2838l.mo4279p(true);
        return this;
    }
}

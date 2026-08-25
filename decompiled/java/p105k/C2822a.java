package p105k;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import p034d0.AbstractC2115a;
import p065g0.AbstractC2581a;
import p074h0.InterfaceMenuItemC2638a;
import p138n0.AbstractC3106c;
import p143n5.AbstractC3198d;

public final class C2822a implements InterfaceMenuItemC2638a {

    public CharSequence f9592a;

    public CharSequence f9593b;

    public Intent f9594c;

    public char f9595d;

    public int f9596e;

    public char f9597f;

    public int f9598g;

    public Drawable f9599h;

    public Context f9600i;

    public CharSequence f9601j;

    public CharSequence f9602k;

    public ColorStateList f9603l;

    public PorterDuff.Mode f9604m;

    public boolean f9605n;

    public boolean f9606o;

    public int f9607p;

    @Override
    public final AbstractC3106c mo5659a() {
        return null;
    }

    @Override
    public final InterfaceMenuItemC2638a mo5660b(AbstractC3106c abstractC3106c) {
        throw new UnsupportedOperationException();
    }

    public final void m5803c() {
        Drawable drawable = this.f9599h;
        if (drawable != null) {
            if (this.f9605n || this.f9606o) {
                Drawable drawableM6448W = AbstractC3198d.m6448W(drawable);
                this.f9599h = drawableM6448W;
                Drawable drawableMutate = drawableM6448W.mutate();
                this.f9599h = drawableMutate;
                if (this.f9605n) {
                    AbstractC2581a.m5586h(drawableMutate, this.f9603l);
                }
                if (this.f9606o) {
                    AbstractC2581a.m5587i(this.f9599h, this.f9604m);
                }
            }
        }
    }

    @Override
    public final boolean collapseActionView() {
        return false;
    }

    @Override
    public final boolean expandActionView() {
        return false;
    }

    @Override
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final View getActionView() {
        return null;
    }

    @Override
    public final int getAlphabeticModifiers() {
        return this.f9598g;
    }

    @Override
    public final char getAlphabeticShortcut() {
        return this.f9597f;
    }

    @Override
    public final CharSequence getContentDescription() {
        return this.f9601j;
    }

    @Override
    public final int getGroupId() {
        return 0;
    }

    @Override
    public final Drawable getIcon() {
        return this.f9599h;
    }

    @Override
    public final ColorStateList getIconTintList() {
        return this.f9603l;
    }

    @Override
    public final PorterDuff.Mode getIconTintMode() {
        return this.f9604m;
    }

    @Override
    public final Intent getIntent() {
        return this.f9594c;
    }

    @Override
    public final int getItemId() {
        return R.id.home;
    }

    @Override
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override
    public final int getNumericModifiers() {
        return this.f9596e;
    }

    @Override
    public final char getNumericShortcut() {
        return this.f9595d;
    }

    @Override
    public final int getOrder() {
        return 0;
    }

    @Override
    public final SubMenu getSubMenu() {
        return null;
    }

    @Override
    public final CharSequence getTitle() {
        return this.f9592a;
    }

    @Override
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f9593b;
        return charSequence != null ? charSequence : this.f9592a;
    }

    @Override
    public final CharSequence getTooltipText() {
        return this.f9602k;
    }

    @Override
    public final boolean hasSubMenu() {
        return false;
    }

    @Override
    public final boolean isActionViewExpanded() {
        return false;
    }

    @Override
    public final boolean isCheckable() {
        return (this.f9607p & 1) != 0;
    }

    @Override
    public final boolean isChecked() {
        return (this.f9607p & 2) != 0;
    }

    @Override
    public final boolean isEnabled() {
        return (this.f9607p & 16) != 0;
    }

    @Override
    public final boolean isVisible() {
        return (this.f9607p & 8) == 0;
    }

    @Override
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final MenuItem setAlphabeticShortcut(char c5) {
        this.f9597f = Character.toLowerCase(c5);
        return this;
    }

    @Override
    public final MenuItem setCheckable(boolean z7) {
        this.f9607p = (z7 ? 1 : 0) | (this.f9607p & (-2));
        return this;
    }

    @Override
    public final MenuItem setChecked(boolean z7) {
        this.f9607p = (z7 ? 2 : 0) | (this.f9607p & (-3));
        return this;
    }

    @Override
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f9601j = charSequence;
        return this;
    }

    @Override
    public final MenuItem setEnabled(boolean z7) {
        this.f9607p = (z7 ? 16 : 0) | (this.f9607p & (-17));
        return this;
    }

    @Override
    public final MenuItem setIcon(Drawable drawable) {
        this.f9599h = drawable;
        m5803c();
        return this;
    }

    @Override
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f9603l = colorStateList;
        this.f9605n = true;
        m5803c();
        return this;
    }

    @Override
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f9604m = mode;
        this.f9606o = true;
        m5803c();
        return this;
    }

    @Override
    public final MenuItem setIntent(Intent intent) {
        this.f9594c = intent;
        return this;
    }

    @Override
    public final MenuItem setNumericShortcut(char c5) {
        this.f9595d = c5;
        return this;
    }

    @Override
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final MenuItem setShortcut(char c5, char c8) {
        this.f9595d = c5;
        this.f9597f = Character.toLowerCase(c8);
        return this;
    }

    @Override
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f9592a = charSequence;
        return this;
    }

    @Override
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f9593b = charSequence;
        return this;
    }

    @Override
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f9602k = charSequence;
        return this;
    }

    @Override
    public final MenuItem setVisible(boolean z7) {
        this.f9607p = (this.f9607p & 8) | (z7 ? 0 : 8);
        return this;
    }

    @Override
    public final MenuItem setActionView(int i6) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final MenuItem setAlphabeticShortcut(char c5, int i6) {
        this.f9597f = Character.toLowerCase(c5);
        this.f9598g = KeyEvent.normalizeMetaState(i6);
        return this;
    }

    @Override
    public final InterfaceMenuItemC2638a setContentDescription(CharSequence charSequence) {
        this.f9601j = charSequence;
        return this;
    }

    @Override
    public final MenuItem setNumericShortcut(char c5, int i6) {
        this.f9595d = c5;
        this.f9596e = KeyEvent.normalizeMetaState(i6);
        return this;
    }

    @Override
    public final MenuItem setTitle(int i6) {
        this.f9592a = this.f9600i.getResources().getString(i6);
        return this;
    }

    @Override
    public final InterfaceMenuItemC2638a setTooltipText(CharSequence charSequence) {
        this.f9602k = charSequence;
        return this;
    }

    @Override
    public final MenuItem setIcon(int i6) {
        this.f9599h = AbstractC2115a.m5069b(this.f9600i, i6);
        m5803c();
        return this;
    }

    @Override
    public final MenuItem setShortcut(char c5, char c8, int i6, int i10) {
        this.f9595d = c5;
        this.f9596e = KeyEvent.normalizeMetaState(i6);
        this.f9597f = Character.toLowerCase(c8);
        this.f9598g = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override
    public final void setShowAsAction(int i6) {
    }

    @Override
    public final MenuItem setShowAsActionFlags(int i6) {
        return this;
    }
}

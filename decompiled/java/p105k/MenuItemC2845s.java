package p105k;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.app.AbstractC0127c0;
import java.lang.reflect.Method;
import p074h0.InterfaceMenuItemC2638a;
import p138n0.AbstractC3106c;

public final class MenuItemC2845s extends AbstractC0127c0 implements MenuItem {

    public final InterfaceMenuItemC2638a f9751c;

    public Method f9752d;

    public MenuItemC2845s(Context context, InterfaceMenuItemC2638a interfaceMenuItemC2638a) {
        super(context);
        if (interfaceMenuItemC2638a == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f9751c = interfaceMenuItemC2638a;
    }

    @Override
    public final boolean collapseActionView() {
        return this.f9751c.collapseActionView();
    }

    @Override
    public final boolean expandActionView() {
        return this.f9751c.expandActionView();
    }

    @Override
    public final ActionProvider getActionProvider() {
        AbstractC3106c abstractC3106cMo5659a = this.f9751c.mo5659a();
        if (abstractC3106cMo5659a instanceof ActionProviderVisibilityListenerC2841o) {
            return ((ActionProviderVisibilityListenerC2841o) abstractC3106cMo5659a).f9743b;
        }
        return null;
    }

    @Override
    public final View getActionView() {
        View actionView = this.f9751c.getActionView();
        return actionView instanceof C2842p ? (View) ((C2842p) actionView).f9746a : actionView;
    }

    @Override
    public final int getAlphabeticModifiers() {
        return this.f9751c.getAlphabeticModifiers();
    }

    @Override
    public final char getAlphabeticShortcut() {
        return this.f9751c.getAlphabeticShortcut();
    }

    @Override
    public final CharSequence getContentDescription() {
        return this.f9751c.getContentDescription();
    }

    @Override
    public final int getGroupId() {
        return this.f9751c.getGroupId();
    }

    @Override
    public final Drawable getIcon() {
        return this.f9751c.getIcon();
    }

    @Override
    public final ColorStateList getIconTintList() {
        return this.f9751c.getIconTintList();
    }

    @Override
    public final PorterDuff.Mode getIconTintMode() {
        return this.f9751c.getIconTintMode();
    }

    @Override
    public final Intent getIntent() {
        return this.f9751c.getIntent();
    }

    @Override
    public final int getItemId() {
        return this.f9751c.getItemId();
    }

    @Override
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f9751c.getMenuInfo();
    }

    @Override
    public final int getNumericModifiers() {
        return this.f9751c.getNumericModifiers();
    }

    @Override
    public final char getNumericShortcut() {
        return this.f9751c.getNumericShortcut();
    }

    @Override
    public final int getOrder() {
        return this.f9751c.getOrder();
    }

    @Override
    public final SubMenu getSubMenu() {
        return this.f9751c.getSubMenu();
    }

    @Override
    public final CharSequence getTitle() {
        return this.f9751c.getTitle();
    }

    @Override
    public final CharSequence getTitleCondensed() {
        return this.f9751c.getTitleCondensed();
    }

    @Override
    public final CharSequence getTooltipText() {
        return this.f9751c.getTooltipText();
    }

    @Override
    public final boolean hasSubMenu() {
        return this.f9751c.hasSubMenu();
    }

    @Override
    public final boolean isActionViewExpanded() {
        return this.f9751c.isActionViewExpanded();
    }

    @Override
    public final boolean isCheckable() {
        return this.f9751c.isCheckable();
    }

    @Override
    public final boolean isChecked() {
        return this.f9751c.isChecked();
    }

    @Override
    public final boolean isEnabled() {
        return this.f9751c.isEnabled();
    }

    @Override
    public final boolean isVisible() {
        return this.f9751c.isVisible();
    }

    @Override
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        ActionProviderVisibilityListenerC2841o actionProviderVisibilityListenerC2841o = new ActionProviderVisibilityListenerC2841o(this, actionProvider);
        if (actionProvider == null) {
            actionProviderVisibilityListenerC2841o = null;
        }
        this.f9751c.mo5660b(actionProviderVisibilityListenerC2841o);
        return this;
    }

    @Override
    public final MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C2842p(view);
        }
        this.f9751c.setActionView(view);
        return this;
    }

    @Override
    public final MenuItem setAlphabeticShortcut(char c5) {
        this.f9751c.setAlphabeticShortcut(c5);
        return this;
    }

    @Override
    public final MenuItem setCheckable(boolean z7) {
        this.f9751c.setCheckable(z7);
        return this;
    }

    @Override
    public final MenuItem setChecked(boolean z7) {
        this.f9751c.setChecked(z7);
        return this;
    }

    @Override
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f9751c.setContentDescription(charSequence);
        return this;
    }

    @Override
    public final MenuItem setEnabled(boolean z7) {
        this.f9751c.setEnabled(z7);
        return this;
    }

    @Override
    public final MenuItem setIcon(Drawable drawable) {
        this.f9751c.setIcon(drawable);
        return this;
    }

    @Override
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f9751c.setIconTintList(colorStateList);
        return this;
    }

    @Override
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f9751c.setIconTintMode(mode);
        return this;
    }

    @Override
    public final MenuItem setIntent(Intent intent) {
        this.f9751c.setIntent(intent);
        return this;
    }

    @Override
    public final MenuItem setNumericShortcut(char c5) {
        this.f9751c.setNumericShortcut(c5);
        return this;
    }

    @Override
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f9751c.setOnActionExpandListener(onActionExpandListener != null ? new MenuItemOnActionExpandListenerC2843q(this, onActionExpandListener) : null);
        return this;
    }

    @Override
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f9751c.setOnMenuItemClickListener(onMenuItemClickListener != null ? new MenuItemOnMenuItemClickListenerC2844r(this, onMenuItemClickListener) : null);
        return this;
    }

    @Override
    public final MenuItem setShortcut(char c5, char c8) {
        this.f9751c.setShortcut(c5, c8);
        return this;
    }

    @Override
    public final void setShowAsAction(int i6) {
        this.f9751c.setShowAsAction(i6);
    }

    @Override
    public final MenuItem setShowAsActionFlags(int i6) {
        this.f9751c.setShowAsActionFlags(i6);
        return this;
    }

    @Override
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f9751c.setTitle(charSequence);
        return this;
    }

    @Override
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f9751c.setTitleCondensed(charSequence);
        return this;
    }

    @Override
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f9751c.setTooltipText(charSequence);
        return this;
    }

    @Override
    public final MenuItem setVisible(boolean z7) {
        return this.f9751c.setVisible(z7);
    }

    @Override
    public final MenuItem setAlphabeticShortcut(char c5, int i6) {
        this.f9751c.setAlphabeticShortcut(c5, i6);
        return this;
    }

    @Override
    public final MenuItem setIcon(int i6) {
        this.f9751c.setIcon(i6);
        return this;
    }

    @Override
    public final MenuItem setNumericShortcut(char c5, int i6) {
        this.f9751c.setNumericShortcut(c5, i6);
        return this;
    }

    @Override
    public final MenuItem setShortcut(char c5, char c8, int i6, int i10) {
        this.f9751c.setShortcut(c5, c8, i6, i10);
        return this;
    }

    @Override
    public final MenuItem setTitle(int i6) {
        this.f9751c.setTitle(i6);
        return this;
    }

    @Override
    public final MenuItem setActionView(int i6) {
        InterfaceMenuItemC2638a interfaceMenuItemC2638a = this.f9751c;
        interfaceMenuItemC2638a.setActionView(i6);
        View actionView = interfaceMenuItemC2638a.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            interfaceMenuItemC2638a.setActionView(new C2842p(actionView));
        }
        return this;
    }
}

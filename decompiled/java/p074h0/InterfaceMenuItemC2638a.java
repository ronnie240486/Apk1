package p074h0;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;
import p138n0.AbstractC3106c;

public interface InterfaceMenuItemC2638a extends MenuItem {
    AbstractC3106c mo5659a();

    InterfaceMenuItemC2638a mo5660b(AbstractC3106c abstractC3106c);

    @Override
    int getAlphabeticModifiers();

    @Override
    CharSequence getContentDescription();

    @Override
    ColorStateList getIconTintList();

    @Override
    PorterDuff.Mode getIconTintMode();

    @Override
    int getNumericModifiers();

    @Override
    CharSequence getTooltipText();

    @Override
    MenuItem setAlphabeticShortcut(char c5, int i6);

    @Override
    InterfaceMenuItemC2638a setContentDescription(CharSequence charSequence);

    @Override
    MenuItem setIconTintList(ColorStateList colorStateList);

    @Override
    MenuItem setIconTintMode(PorterDuff.Mode mode);

    @Override
    MenuItem setNumericShortcut(char c5, int i6);

    @Override
    MenuItem setShortcut(char c5, char c8, int i6, int i10);

    @Override
    InterfaceMenuItemC2638a setTooltipText(CharSequence charSequence);
}

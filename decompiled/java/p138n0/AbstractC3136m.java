package p138n0;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;

public abstract class AbstractC3136m {
    public static int m6253a(MenuItem menuItem) {
        return menuItem.getAlphabeticModifiers();
    }

    public static CharSequence m6254b(MenuItem menuItem) {
        return menuItem.getContentDescription();
    }

    public static ColorStateList m6255c(MenuItem menuItem) {
        return menuItem.getIconTintList();
    }

    public static PorterDuff.Mode m6256d(MenuItem menuItem) {
        return menuItem.getIconTintMode();
    }

    public static int m6257e(MenuItem menuItem) {
        return menuItem.getNumericModifiers();
    }

    public static CharSequence m6258f(MenuItem menuItem) {
        return menuItem.getTooltipText();
    }

    public static MenuItem m6259g(MenuItem menuItem, char c5, int i6) {
        return menuItem.setAlphabeticShortcut(c5, i6);
    }

    public static MenuItem m6260h(MenuItem menuItem, CharSequence charSequence) {
        return menuItem.setContentDescription(charSequence);
    }

    public static MenuItem m6261i(MenuItem menuItem, ColorStateList colorStateList) {
        return menuItem.setIconTintList(colorStateList);
    }

    public static MenuItem m6262j(MenuItem menuItem, PorterDuff.Mode mode) {
        return menuItem.setIconTintMode(mode);
    }

    public static MenuItem m6263k(MenuItem menuItem, char c5, int i6) {
        return menuItem.setNumericShortcut(c5, i6);
    }

    public static MenuItem m6264l(MenuItem menuItem, char c5, char c8, int i6, int i10) {
        return menuItem.setShortcut(c5, c8, i6, i10);
    }

    public static MenuItem m6265m(MenuItem menuItem, CharSequence charSequence) {
        return menuItem.setTooltipText(charSequence);
    }
}

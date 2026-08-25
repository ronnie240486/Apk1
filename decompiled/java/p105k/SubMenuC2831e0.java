package p105k;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import p000a.AbstractC0004e;

public class SubMenuC2831e0 extends MenuC2838l implements SubMenu {

    public final C2840n f9645A;

    public final MenuC2838l f9646z;

    public SubMenuC2831e0(Context context, MenuC2838l menuC2838l, C2840n c2840n) {
        super(context);
        this.f9646z = menuC2838l;
        this.f9645A = c2840n;
    }

    @Override
    public final boolean mo5813d(C2840n c2840n) {
        return this.f9646z.mo5813d(c2840n);
    }

    @Override
    public final boolean mo5814e(MenuC2838l menuC2838l, MenuItem menuItem) {
        return super.mo5814e(menuC2838l, menuItem) || this.f9646z.mo5814e(menuC2838l, menuItem);
    }

    @Override
    public final boolean mo5815f(C2840n c2840n) {
        return this.f9646z.mo5815f(c2840n);
    }

    @Override
    public final MenuItem getItem() {
        return this.f9645A;
    }

    @Override
    public final String mo5816j() {
        C2840n c2840n = this.f9645A;
        int i6 = c2840n != null ? c2840n.f9717a : 0;
        if (i6 == 0) {
            return null;
        }
        return AbstractC0004e.m20n(i6, "android:menu:actionviewstates:");
    }

    @Override
    public final MenuC2838l mo5817k() {
        return this.f9646z.mo5817k();
    }

    @Override
    public final boolean mo5818m() {
        return this.f9646z.mo5818m();
    }

    @Override
    public final boolean mo5819n() {
        return this.f9646z.mo5819n();
    }

    @Override
    public final boolean mo5820o() {
        return this.f9646z.mo5820o();
    }

    @Override
    public final void setGroupDividerEnabled(boolean z7) {
        this.f9646z.setGroupDividerEnabled(z7);
    }

    @Override
    public final SubMenu setHeaderIcon(Drawable drawable) {
        m5838w(0, null, 0, drawable, null);
        return this;
    }

    @Override
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        m5838w(0, charSequence, 0, null, null);
        return this;
    }

    @Override
    public final SubMenu setHeaderView(View view) {
        m5838w(0, null, 0, null, view);
        return this;
    }

    @Override
    public final SubMenu setIcon(Drawable drawable) {
        this.f9645A.setIcon(drawable);
        return this;
    }

    @Override
    public final void setQwertyMode(boolean z7) {
        this.f9646z.setQwertyMode(z7);
    }

    @Override
    public final SubMenu setHeaderIcon(int i6) {
        m5838w(0, null, i6, null, null);
        return this;
    }

    @Override
    public final SubMenu setHeaderTitle(int i6) {
        m5838w(i6, null, 0, null, null);
        return this;
    }

    @Override
    public final SubMenu setIcon(int i6) {
        this.f9645A.setIcon(i6);
        return this;
    }
}

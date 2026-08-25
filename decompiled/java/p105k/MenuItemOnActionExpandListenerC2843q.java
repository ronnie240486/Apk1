package p105k;

import android.view.MenuItem;

public final class MenuItemOnActionExpandListenerC2843q implements MenuItem.OnActionExpandListener {

    public final MenuItem.OnActionExpandListener f9747a;

    public final MenuItemC2845s f9748b;

    public MenuItemOnActionExpandListenerC2843q(MenuItemC2845s menuItemC2845s, MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f9748b = menuItemC2845s;
        this.f9747a = onActionExpandListener;
    }

    @Override
    public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.f9747a.onMenuItemActionCollapse(this.f9748b.m374g(menuItem));
    }

    @Override
    public final boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.f9747a.onMenuItemActionExpand(this.f9748b.m374g(menuItem));
    }
}

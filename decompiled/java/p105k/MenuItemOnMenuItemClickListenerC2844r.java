package p105k;

import android.view.MenuItem;

public final class MenuItemOnMenuItemClickListenerC2844r implements MenuItem.OnMenuItemClickListener {

    public final MenuItem.OnMenuItemClickListener f9749a;

    public final MenuItemC2845s f9750b;

    public MenuItemOnMenuItemClickListenerC2844r(MenuItemC2845s menuItemC2845s, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f9750b = menuItemC2845s;
        this.f9749a = onMenuItemClickListener;
    }

    @Override
    public final boolean onMenuItemClick(MenuItem menuItem) {
        return this.f9749a.onMenuItemClick(this.f9750b.m374g(menuItem));
    }
}

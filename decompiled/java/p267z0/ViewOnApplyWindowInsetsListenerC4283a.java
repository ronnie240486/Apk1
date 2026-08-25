package p267z0;

import android.view.View;
import android.view.WindowInsets;
import androidx.drawerlayout.widget.DrawerLayout;

public final class ViewOnApplyWindowInsetsListenerC4283a implements View.OnApplyWindowInsetsListener {
    @Override
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        DrawerLayout drawerLayout = (DrawerLayout) view;
        boolean z7 = false;
        boolean z10 = windowInsets.getSystemWindowInsetTop() > 0;
        drawerLayout.f1733w = windowInsets;
        drawerLayout.f1734x = z10;
        if (!z10 && drawerLayout.getBackground() == null) {
            z7 = true;
        }
        drawerLayout.setWillNotDraw(z7);
        drawerLayout.requestLayout();
        return windowInsets.consumeSystemWindowInsets();
    }
}

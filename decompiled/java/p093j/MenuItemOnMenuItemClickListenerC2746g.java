package p093j;

import android.view.MenuItem;
import java.lang.reflect.Method;

public final class MenuItemOnMenuItemClickListenerC2746g implements MenuItem.OnMenuItemClickListener {

    public static final Class[] f9423c = {MenuItem.class};

    public Object f9424a;

    public Method f9425b;

    @Override
    public final boolean onMenuItemClick(MenuItem menuItem) {
        Method method = this.f9425b;
        try {
            Class<?> returnType = method.getReturnType();
            Class<?> cls = Boolean.TYPE;
            Object obj = this.f9424a;
            if (returnType == cls) {
                return ((Boolean) method.invoke(obj, menuItem)).booleanValue();
            }
            method.invoke(obj, menuItem);
            return true;
        } catch (Exception e5) {
            throw new RuntimeException(e5);
        }
    }
}

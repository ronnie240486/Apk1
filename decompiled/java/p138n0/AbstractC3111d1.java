package p138n0;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

public abstract class AbstractC3111d1 {

    public static final Field f10581a;

    public static final Field f10582b;

    public static final Field f10583c;

    public static final boolean f10584d;

    static {
        try {
            Field declaredField = View.class.getDeclaredField("mAttachInfo");
            f10581a = declaredField;
            declaredField.setAccessible(true);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            Field declaredField2 = cls.getDeclaredField("mStableInsets");
            f10582b = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("mContentInsets");
            f10583c = declaredField3;
            declaredField3.setAccessible(true);
            f10584d = true;
        } catch (ReflectiveOperationException e5) {
            Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e5.getMessage(), e5);
        }
    }
}

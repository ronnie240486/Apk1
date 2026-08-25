package androidx.appcompat.widget;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;

public abstract class AbstractC0189c4 {

    public static final Method f880a;

    public static final boolean f881b;

    static {
        f881b = Build.VERSION.SDK_INT >= 27;
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
            f880a = declaredMethod;
            if (declaredMethod.isAccessible()) {
                return;
            }
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
        }
    }

    public static boolean m648a(View view) {
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        return view.getLayoutDirection() == 1;
    }
}

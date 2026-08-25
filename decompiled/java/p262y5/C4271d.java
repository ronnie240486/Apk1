package p262y5;

import android.graphics.drawable.Drawable;
import android.util.Property;
import java.util.WeakHashMap;

public final class C4271d extends Property {

    public static final C4271d f14476a;

    static {
        C4271d c4271d = new C4271d(Integer.class, "drawableAlphaCompat");
        new WeakHashMap();
        f14476a = c4271d;
    }

    @Override
    public final Object get(Object obj) {
        return Integer.valueOf(((Drawable) obj).getAlpha());
    }

    @Override
    public final void set(Object obj, Object obj2) {
        ((Drawable) obj).setAlpha(((Integer) obj2).intValue());
    }
}

package p118l0;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public abstract class AbstractC2954e {

    public static final Method f10131a;

    static {
        if (Build.VERSION.SDK_INT < 24) {
            try {
                f10131a = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
            } catch (Exception e5) {
                throw new IllegalStateException(e5);
            }
        }
    }

    public static String m5980a(Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return AbstractC2953d.m5979c(AbstractC2953d.m5977a(AbstractC2953d.m5978b(locale)));
        }
        try {
            return AbstractC2952c.m5976a((Locale) f10131a.invoke(null, locale));
        } catch (IllegalAccessException e5) {
            Log.w("ICUCompat", e5);
            return AbstractC2952c.m5976a(locale);
        } catch (InvocationTargetException e10) {
            Log.w("ICUCompat", e10);
            return AbstractC2952c.m5976a(locale);
        }
    }
}

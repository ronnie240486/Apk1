package p118l0;

import android.icu.util.ULocale;
import java.util.Locale;

public abstract class AbstractC2953d {
    public static ULocale m5977a(Object obj) {
        return ULocale.addLikelySubtags((ULocale) obj);
    }

    public static ULocale m5978b(Locale locale) {
        return ULocale.forLocale(locale);
    }

    public static String m5979c(Object obj) {
        return ((ULocale) obj).getScript();
    }
}

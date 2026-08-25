package androidx.appcompat.app;

import android.app.LocaleManager;
import android.os.LocaleList;

public abstract class AbstractC0152p {
    public static LocaleList m434a(Object obj) {
        return ((LocaleManager) obj).getApplicationLocales();
    }

    public static void m435b(Object obj, LocaleList localeList) {
        ((LocaleManager) obj).setApplicationLocales(localeList);
    }
}

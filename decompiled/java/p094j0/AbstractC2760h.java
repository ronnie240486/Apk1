package p094j0;

import android.os.LocaleList;
import java.util.Locale;

public abstract class AbstractC2760h {
    public static LocaleList m5729a(Locale... localeArr) {
        return new LocaleList(localeArr);
    }

    public static LocaleList m5730b() {
        return LocaleList.getAdjustedDefault();
    }

    public static LocaleList m5731c() {
        return LocaleList.getDefault();
    }
}

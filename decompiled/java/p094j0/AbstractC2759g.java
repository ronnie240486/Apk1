package p094j0;

import java.util.Locale;
import p118l0.AbstractC2954e;

public abstract class AbstractC2759g {

    public static final Locale[] f9473a = {new Locale("en", "XA"), new Locale("ar", "XB")};

    public static Locale m5727a(String str) {
        return Locale.forLanguageTag(str);
    }

    public static boolean m5728b(Locale locale, Locale locale2) {
        if (locale.equals(locale2)) {
            return true;
        }
        if (!locale.getLanguage().equals(locale2.getLanguage())) {
            return false;
        }
        Locale[] localeArr = f9473a;
        for (Locale locale3 : localeArr) {
            if (locale3.equals(locale)) {
                return false;
            }
        }
        for (Locale locale4 : localeArr) {
            if (locale4.equals(locale2)) {
                return false;
            }
        }
        String strM5980a = AbstractC2954e.m5980a(locale);
        if (!strM5980a.isEmpty()) {
            return strM5980a.equals(AbstractC2954e.m5980a(locale2));
        }
        String country = locale.getCountry();
        return country.isEmpty() || country.equals(locale2.getCountry());
    }
}

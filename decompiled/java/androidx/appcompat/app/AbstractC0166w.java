package androidx.appcompat.app;

import android.content.res.Configuration;
import android.os.LocaleList;
import p094j0.C2761i;

public abstract class AbstractC0166w {
    public static void m469a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        LocaleList locales = configuration.getLocales();
        LocaleList locales2 = configuration2.getLocales();
        if (locales.equals(locales2)) {
            return;
        }
        configuration3.setLocales(locales2);
        configuration3.locale = configuration2.locale;
    }

    public static C2761i m470b(Configuration configuration) {
        return C2761i.m5733b(configuration.getLocales().toLanguageTags());
    }

    public static void m471c(C2761i c2761i) {
        LocaleList.setDefault(LocaleList.forLanguageTags(c2761i.f9475a.mo5734a()));
    }

    public static void m472d(Configuration configuration, C2761i c2761i) {
        configuration.setLocales(LocaleList.forLanguageTags(c2761i.f9475a.mo5734a()));
    }
}

package androidx.appcompat.widget;

import android.os.LocaleList;
import android.widget.TextView;

public abstract class AbstractC0276u0 {
    public static LocaleList m783a(String str) {
        return LocaleList.forLanguageTags(str);
    }

    public static void m784b(TextView textView, LocaleList localeList) {
        textView.setTextLocales(localeList);
    }
}

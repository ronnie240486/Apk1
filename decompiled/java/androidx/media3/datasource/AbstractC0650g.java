package androidx.media3.datasource;

import android.text.TextUtils;
import androidx.media3.common.MimeTypes;
import p020b7.AbstractC1332b;

public abstract class AbstractC0650g {
    public static boolean m1781a(String str) {
        if (str == null) {
            return false;
        }
        String strM3231v = AbstractC1332b.m3231v(str);
        if (TextUtils.isEmpty(strM3231v)) {
            return false;
        }
        return ((strM3231v.contains("text") && !strM3231v.contains(MimeTypes.TEXT_VTT)) || strM3231v.contains("html") || strM3231v.contains("xml")) ? false : true;
    }
}

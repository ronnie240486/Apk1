package p094j0;

import android.os.Build;
import androidx.media3.common.PlaybackException;
import java.util.Locale;
import p103j9.AbstractC2796i;

public abstract class AbstractC2754b {
    static {
        int i6 = Build.VERSION.SDK_INT;
        C2753a c2753a = C2753a.f9469a;
        if (i6 >= 30) {
            c2753a.m5720a(30);
        }
        if (i6 >= 30) {
            c2753a.m5720a(31);
        }
        if (i6 >= 30) {
            c2753a.m5720a(33);
        }
        if (i6 >= 30) {
            c2753a.m5720a(PlaybackException.CUSTOM_ERROR_CODE_BASE);
        }
    }

    public static final boolean m5721a() {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 < 33) {
            if (i6 >= 32) {
                String str = Build.VERSION.CODENAME;
                AbstractC2796i.m5784e(str, "CODENAME");
                if (!"REL".equals(str)) {
                    Locale locale = Locale.ROOT;
                    String upperCase = str.toUpperCase(locale);
                    AbstractC2796i.m5784e(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                    String upperCase2 = "Tiramisu".toUpperCase(locale);
                    AbstractC2796i.m5784e(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                    if (upperCase.compareTo(upperCase2) >= 0) {
                    }
                }
            }
            return false;
        }
        return true;
    }
}

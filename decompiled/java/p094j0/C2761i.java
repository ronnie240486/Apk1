package p094j0;

import android.os.Build;
import java.util.Locale;

public final class C2761i {

    public static final C2761i f9474b = m5732a(new Locale[0]);

    public final InterfaceC2763k f9475a;

    public C2761i(InterfaceC2763k interfaceC2763k) {
        this.f9475a = interfaceC2763k;
    }

    public static C2761i m5732a(Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? new C2761i(new C2764l(AbstractC2760h.m5729a(localeArr))) : new C2761i(new C2762j(localeArr));
    }

    public static C2761i m5733b(String str) {
        if (str == null || str.isEmpty()) {
            return f9474b;
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i6 = 0; i6 < length; i6++) {
            localeArr[i6] = AbstractC2759g.m5727a(strArrSplit[i6]);
        }
        return m5732a(localeArr);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C2761i) {
            if (this.f9475a.equals(((C2761i) obj).f9475a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f9475a.hashCode();
    }

    public final String toString() {
        return this.f9475a.toString();
    }
}

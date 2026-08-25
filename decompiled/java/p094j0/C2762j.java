package p094j0;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import p055ea.AbstractC2460q;

public final class C2762j implements InterfaceC2763k {

    public static final Locale[] f9476c = new Locale[0];

    public final Locale[] f9477a;

    public final String f9478b;

    static {
        new Locale("en", "XA");
        new Locale("ar", "XB");
        String[] strArrSplit = "en-Latn".split("-", -1);
        if (strArrSplit.length > 2) {
            new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
        } else if (strArrSplit.length > 1) {
            new Locale(strArrSplit[0], strArrSplit[1]);
        } else {
            if (strArrSplit.length != 1) {
                throw new IllegalArgumentException("Can not parse language tag: [en-Latn]");
            }
            new Locale(strArrSplit[0]);
        }
    }

    public C2762j(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f9477a = f9476c;
            this.f9478b = "";
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < localeArr.length; i6++) {
            Locale locale = localeArr[i6];
            if (locale == null) {
                throw new NullPointerException(AbstractC2460q.m5492f(i6, "list[", "] is null"));
            }
            if (!hashSet.contains(locale)) {
                Locale locale2 = (Locale) locale.clone();
                arrayList.add(locale2);
                sb.append(locale2.getLanguage());
                String country = locale2.getCountry();
                if (country != null && !country.isEmpty()) {
                    sb.append('-');
                    sb.append(locale2.getCountry());
                }
                if (i6 < localeArr.length - 1) {
                    sb.append(',');
                }
                hashSet.add(locale2);
            }
        }
        this.f9477a = (Locale[]) arrayList.toArray(new Locale[0]);
        this.f9478b = sb.toString();
    }

    @Override
    public final String mo5734a() {
        return this.f9478b;
    }

    @Override
    public final Object mo5735b() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2762j)) {
            return false;
        }
        Locale[] localeArr = ((C2762j) obj).f9477a;
        Locale[] localeArr2 = this.f9477a;
        if (localeArr2.length != localeArr.length) {
            return false;
        }
        for (int i6 = 0; i6 < localeArr2.length; i6++) {
            if (!localeArr2[i6].equals(localeArr[i6])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final Locale get(int i6) {
        if (i6 >= 0) {
            Locale[] localeArr = this.f9477a;
            if (i6 < localeArr.length) {
                return localeArr[i6];
            }
        }
        return null;
    }

    public final int hashCode() {
        int iHashCode = 1;
        for (Locale locale : this.f9477a) {
            iHashCode = (iHashCode * 31) + locale.hashCode();
        }
        return iHashCode;
    }

    @Override
    public final boolean isEmpty() {
        return this.f9477a.length == 0;
    }

    @Override
    public final int size() {
        return this.f9477a.length;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        int i6 = 0;
        while (true) {
            Locale[] localeArr = this.f9477a;
            if (i6 >= localeArr.length) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(localeArr[i6]);
            if (i6 < localeArr.length - 1) {
                sb.append(',');
            }
            i6++;
        }
    }
}

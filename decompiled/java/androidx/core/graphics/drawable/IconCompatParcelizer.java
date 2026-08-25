package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import java.nio.charset.Charset;
import p003a2.AbstractC0033b;
import p003a2.C0034c;

public class IconCompatParcelizer {
    public static IconCompat read(AbstractC0033b abstractC0033b) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f1607a = abstractC0033b.m184f(iconCompat.f1607a, 1);
        byte[] bArr = iconCompat.f1609c;
        if (abstractC0033b.mo183e(2)) {
            Parcel parcel = ((C0034c) abstractC0033b).f99e;
            int i6 = parcel.readInt();
            if (i6 < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[i6];
                parcel.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.f1609c = bArr;
        iconCompat.f1610d = abstractC0033b.m185g(iconCompat.f1610d, 3);
        iconCompat.f1611e = abstractC0033b.m184f(iconCompat.f1611e, 4);
        iconCompat.f1612f = abstractC0033b.m184f(iconCompat.f1612f, 5);
        iconCompat.f1613g = (ColorStateList) abstractC0033b.m185g(iconCompat.f1613g, 6);
        String string = iconCompat.f1615i;
        if (abstractC0033b.mo183e(7)) {
            string = ((C0034c) abstractC0033b).f99e.readString();
        }
        iconCompat.f1615i = string;
        String string2 = iconCompat.f1616j;
        if (abstractC0033b.mo183e(8)) {
            string2 = ((C0034c) abstractC0033b).f99e.readString();
        }
        iconCompat.f1616j = string2;
        iconCompat.f1614h = PorterDuff.Mode.valueOf(iconCompat.f1615i);
        switch (iconCompat.f1607a) {
            case -1:
                Parcelable parcelable = iconCompat.f1610d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.f1608b = parcelable;
                return iconCompat;
            case 0:
            default:
                return iconCompat;
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.f1610d;
                if (parcelable2 != null) {
                    iconCompat.f1608b = parcelable2;
                } else {
                    byte[] bArr3 = iconCompat.f1609c;
                    iconCompat.f1608b = bArr3;
                    iconCompat.f1607a = 3;
                    iconCompat.f1611e = 0;
                    iconCompat.f1612f = bArr3.length;
                }
                return iconCompat;
            case 2:
            case 4:
            case 6:
                String str = new String(iconCompat.f1609c, Charset.forName("UTF-16"));
                iconCompat.f1608b = str;
                if (iconCompat.f1607a == 2 && iconCompat.f1616j == null) {
                    iconCompat.f1616j = str.split(":", -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.f1608b = iconCompat.f1609c;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, AbstractC0033b abstractC0033b) {
        abstractC0033b.getClass();
        iconCompat.f1615i = iconCompat.f1614h.name();
        switch (iconCompat.f1607a) {
            case -1:
                iconCompat.f1610d = (Parcelable) iconCompat.f1608b;
                break;
            case 1:
            case 5:
                iconCompat.f1610d = (Parcelable) iconCompat.f1608b;
                break;
            case 2:
                iconCompat.f1609c = ((String) iconCompat.f1608b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f1609c = (byte[]) iconCompat.f1608b;
                break;
            case 4:
            case 6:
                iconCompat.f1609c = iconCompat.f1608b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i6 = iconCompat.f1607a;
        if (-1 != i6) {
            abstractC0033b.m188j(i6, 1);
        }
        byte[] bArr = iconCompat.f1609c;
        if (bArr != null) {
            abstractC0033b.mo187i(2);
            int length = bArr.length;
            Parcel parcel = ((C0034c) abstractC0033b).f99e;
            parcel.writeInt(length);
            parcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.f1610d;
        if (parcelable != null) {
            abstractC0033b.m189k(parcelable, 3);
        }
        int i10 = iconCompat.f1611e;
        if (i10 != 0) {
            abstractC0033b.m188j(i10, 4);
        }
        int i11 = iconCompat.f1612f;
        if (i11 != 0) {
            abstractC0033b.m188j(i11, 5);
        }
        ColorStateList colorStateList = iconCompat.f1613g;
        if (colorStateList != null) {
            abstractC0033b.m189k(colorStateList, 6);
        }
        String str = iconCompat.f1615i;
        if (str != null) {
            abstractC0033b.mo187i(7);
            ((C0034c) abstractC0033b).f99e.writeString(str);
        }
        String str2 = iconCompat.f1616j;
        if (str2 != null) {
            abstractC0033b.mo187i(8);
            ((C0034c) abstractC0033b).f99e.writeString(str2);
        }
    }
}

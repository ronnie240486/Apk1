package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.leanback.widget.C0486o;
import com.google.android.gms.cast.internal.zzaa;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import p156o9.AbstractC3280d;
import p165p4.C3371p;
import p230v4.AbstractC3987a;

public class CastDevice extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CastDevice> CREATOR = new C3371p(3);

    public final String f4600a;

    public final String f4601b;

    public final InetAddress f4602c;

    public final String f4603d;

    public final String f4604e;

    public final String f4605f;

    public final int f4606g;

    public final List f4607h;

    public final C0486o f4608i;

    public final int f4609j;

    public final String f4610k;

    public final String f4611l;

    public final int f4612m;

    public final String f4613n;

    public final byte[] f4614o;

    public final String f4615p;

    public final boolean f4616q;

    public final zzaa f4617r;

    public final Integer f4618s;

    public final Boolean f4619t;

    public CastDevice(String str, String str2, String str3, String str4, String str5, int i6, ArrayList arrayList, int i10, int i11, String str6, String str7, int i12, String str8, byte[] bArr, String str9, boolean z7, zzaa zzaaVar, Integer num, Boolean bool) {
        this.f4600a = str == null ? "" : str;
        String str10 = str2 == null ? "" : str2;
        this.f4601b = str10;
        if (!TextUtils.isEmpty(str10)) {
            try {
                this.f4602c = InetAddress.getByName(str10);
            } catch (UnknownHostException e5) {
                Log.i("CastDevice", "Unable to convert host address (" + this.f4601b + ") to ipaddress: " + e5.getMessage());
            }
        }
        this.f4603d = str3 == null ? "" : str3;
        this.f4604e = str4 == null ? "" : str4;
        this.f4605f = str5 == null ? "" : str5;
        this.f4606g = i6;
        this.f4607h = arrayList == null ? new ArrayList() : arrayList;
        this.f4609j = i11;
        this.f4610k = str6 != null ? str6 : "";
        this.f4611l = str7;
        this.f4612m = i12;
        this.f4613n = str8;
        this.f4614o = bArr;
        this.f4615p = str9;
        this.f4616q = z7;
        this.f4617r = zzaaVar;
        this.f4618s = num;
        this.f4619t = bool;
        this.f4608i = new C0486o(i10);
    }

    public static CastDevice m3584l(Bundle bundle) {
        ClassLoader classLoader;
        if (bundle == null || (classLoader = CastDevice.class.getClassLoader()) == null) {
            return null;
        }
        bundle.setClassLoader(classLoader);
        return (CastDevice) bundle.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
    }

    public final boolean equals(Object obj) {
        int i6;
        int i10;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CastDevice)) {
            return false;
        }
        CastDevice castDevice = (CastDevice) obj;
        String str = this.f4600a;
        if (str == null) {
            return castDevice.f4600a == null;
        }
        if (AbstractC3987a.m7972e(str, castDevice.f4600a) && AbstractC3987a.m7972e(this.f4602c, castDevice.f4602c) && AbstractC3987a.m7972e(this.f4604e, castDevice.f4604e) && AbstractC3987a.m7972e(this.f4603d, castDevice.f4603d)) {
            String str2 = this.f4605f;
            String str3 = castDevice.f4605f;
            if (AbstractC3987a.m7972e(str2, str3) && (i10 = this.f4606g) == (i6 = castDevice.f4606g) && AbstractC3987a.m7972e(this.f4607h, castDevice.f4607h) && this.f4608i.f2374a == castDevice.f4608i.f2374a && this.f4609j == castDevice.f4609j && AbstractC3987a.m7972e(this.f4610k, castDevice.f4610k) && AbstractC3987a.m7972e(Integer.valueOf(this.f4612m), Integer.valueOf(castDevice.f4612m)) && AbstractC3987a.m7972e(this.f4613n, castDevice.f4613n) && AbstractC3987a.m7972e(this.f4611l, castDevice.f4611l) && AbstractC3987a.m7972e(str2, str3) && i10 == i6) {
                byte[] bArr = castDevice.f4614o;
                byte[] bArr2 = this.f4614o;
                if (((bArr2 == null && bArr == null) || Arrays.equals(bArr2, bArr)) && AbstractC3987a.m7972e(this.f4615p, castDevice.f4615p) && this.f4616q == castDevice.f4616q && AbstractC3987a.m7972e(m3587n(), castDevice.m3587n()) && AbstractC3987a.m7972e(Boolean.valueOf(m3588o()), Boolean.valueOf(castDevice.m3588o()))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f4600a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final String m3585j() {
        String str = this.f4600a;
        return str.startsWith("__cast_nearby__") ? str.substring(16) : str;
    }

    public final int m3586m() {
        C0486o c0486o = this.f4608i;
        if (c0486o.m1446a(64)) {
            return 4;
        }
        if (c0486o.m1447b()) {
            return 3;
        }
        if (c0486o.m1448c()) {
            return 5;
        }
        return c0486o.m1446a(1) ? 2 : 1;
    }

    public final zzaa m3587n() {
        zzaa zzaaVar = this.f4617r;
        return (zzaaVar == null && this.f4608i.m1448c()) ? new zzaa(1, false, false, null, null, null, null, null, false) : zzaaVar;
    }

    public final boolean m3588o() {
        Boolean bool = this.f4619t;
        if (bool != null) {
            return bool.booleanValue();
        }
        int i6 = this.f4609j;
        return i6 != -1 && (i6 & 2) > 0;
    }

    public final String toString() {
        String strConcat;
        C0486o c0486o = this.f4608i;
        if (c0486o.m1446a(64)) {
            strConcat = "[dynamic group]";
        } else if (c0486o.m1447b()) {
            strConcat = "[static group]";
        } else {
            strConcat = c0486o.m1448c() ? "[speaker pair]" : "";
        }
        if (c0486o.m1446a(262144)) {
            strConcat = strConcat.concat("[cast connect]");
        }
        Locale locale = Locale.ROOT;
        Pattern pattern = AbstractC3987a.f13519a;
        String str = this.f4603d;
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if (length <= 2) {
                str = length == 2 ? "xx" : "x";
            } else {
                str = String.format(locale, "%c%d%c", Character.valueOf(str.charAt(0)), Integer.valueOf(length - 2), Character.valueOf(str.charAt(length - 1)));
            }
        }
        return "\"" + str + "\" (" + this.f4600a + ") " + strConcat;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6579R(parcel, 2, this.f4600a);
        AbstractC3280d.m6579R(parcel, 3, this.f4601b);
        AbstractC3280d.m6579R(parcel, 4, this.f4603d);
        AbstractC3280d.m6579R(parcel, 5, this.f4604e);
        AbstractC3280d.m6579R(parcel, 6, this.f4605f);
        AbstractC3280d.m6585X(parcel, 7, 4);
        parcel.writeInt(this.f4606g);
        AbstractC3280d.m6582U(parcel, 8, Collections.unmodifiableList(this.f4607h));
        int i10 = this.f4608i.f2374a;
        AbstractC3280d.m6585X(parcel, 9, 4);
        parcel.writeInt(i10);
        AbstractC3280d.m6585X(parcel, 10, 4);
        parcel.writeInt(this.f4609j);
        AbstractC3280d.m6579R(parcel, 11, this.f4610k);
        AbstractC3280d.m6579R(parcel, 12, this.f4611l);
        AbstractC3280d.m6585X(parcel, 13, 4);
        parcel.writeInt(this.f4612m);
        AbstractC3280d.m6579R(parcel, 14, this.f4613n);
        byte[] bArr = this.f4614o;
        if (bArr != null) {
            int iM6583V2 = AbstractC3280d.m6583V(parcel, 15);
            parcel.writeByteArray(bArr);
            AbstractC3280d.m6584W(parcel, iM6583V2);
        }
        AbstractC3280d.m6579R(parcel, 16, this.f4615p);
        AbstractC3280d.m6585X(parcel, 17, 4);
        parcel.writeInt(this.f4616q ? 1 : 0);
        AbstractC3280d.m6578Q(parcel, 18, m3587n(), i6);
        Integer num = this.f4618s;
        if (num != null) {
            AbstractC3280d.m6585X(parcel, 19, 4);
            parcel.writeInt(num.intValue());
        }
        AbstractC3280d.m6573L(parcel, 20, Boolean.valueOf(m3588o()));
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}

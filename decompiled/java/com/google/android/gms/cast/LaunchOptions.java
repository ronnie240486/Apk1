package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;
import p078h5.C2661a;
import p156o9.AbstractC3280d;
import p230v4.AbstractC3987a;

public class LaunchOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LaunchOptions> CREATOR = new C2661a(16);

    public final boolean f4627a;

    public final String f4628b;

    public boolean f4629c;

    public CredentialsData f4630d;

    public LaunchOptions(boolean z7, String str, boolean z10, CredentialsData credentialsData) {
        this.f4627a = z7;
        this.f4628b = str;
        this.f4629c = z10;
        this.f4630d = credentialsData;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LaunchOptions)) {
            return false;
        }
        LaunchOptions launchOptions = (LaunchOptions) obj;
        return this.f4627a == launchOptions.f4627a && AbstractC3987a.m7972e(this.f4628b, launchOptions.f4628b) && this.f4629c == launchOptions.f4629c && AbstractC3987a.m7972e(this.f4630d, launchOptions.f4630d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f4627a), this.f4628b, Boolean.valueOf(this.f4629c), this.f4630d});
    }

    public final String toString() {
        return "LaunchOptions(relaunchIfRunning=" + this.f4627a + ", language=" + this.f4628b + ", androidReceiverCompatible: " + this.f4629c + ")";
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(this.f4627a ? 1 : 0);
        AbstractC3280d.m6579R(parcel, 3, this.f4628b);
        boolean z7 = this.f4629c;
        AbstractC3280d.m6585X(parcel, 4, 4);
        parcel.writeInt(z7 ? 1 : 0);
        AbstractC3280d.m6578Q(parcel, 5, this.f4630d, i6);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }

    public LaunchOptions() {
        Locale locale = Locale.getDefault();
        Pattern pattern = AbstractC3987a.f13519a;
        StringBuilder sb = new StringBuilder(20);
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (!TextUtils.isEmpty(country)) {
            sb.append('-');
            sb.append(country);
        }
        String variant = locale.getVariant();
        if (!TextUtils.isEmpty(variant)) {
            sb.append('-');
            sb.append(variant);
        }
        this(false, sb.toString(), false, null);
    }
}

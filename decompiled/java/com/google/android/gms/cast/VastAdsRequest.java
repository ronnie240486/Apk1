package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
import p156o9.AbstractC3280d;
import p165p4.C3371p;
import p230v4.AbstractC3987a;

public class VastAdsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<VastAdsRequest> CREATOR = new C3371p(1);

    public final String f4754a;

    public final String f4755b;

    public VastAdsRequest(String str, String str2) {
        this.f4754a = str;
        this.f4755b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VastAdsRequest)) {
            return false;
        }
        VastAdsRequest vastAdsRequest = (VastAdsRequest) obj;
        return AbstractC3987a.m7972e(this.f4754a, vastAdsRequest.f4754a) && AbstractC3987a.m7972e(this.f4755b, vastAdsRequest.f4755b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4754a, this.f4755b});
    }

    public final JSONObject m3608j() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.f4754a;
            if (str != null) {
                jSONObject.put("adTagUrl", str);
            }
            String str2 = this.f4755b;
            if (str2 != null) {
                jSONObject.put("adsResponse", str2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6579R(parcel, 2, this.f4754a);
        AbstractC3280d.m6579R(parcel, 3, this.f4755b);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}

package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import p078h5.C2661a;
import p156o9.AbstractC3280d;
import p230v4.AbstractC3987a;

public class AdBreakClipInfo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AdBreakClipInfo> CREATOR = new C2661a(10);

    public final String f4564a;

    public final String f4565b;

    public final long f4566c;

    public final String f4567d;

    public final String f4568e;

    public final String f4569f;

    public final String f4570g;

    public final String f4571h;

    public final String f4572i;

    public final long f4573j;

    public final String f4574k;

    public final VastAdsRequest f4575l;

    public final JSONObject f4576m;

    public AdBreakClipInfo(String str, String str2, long j10, String str3, String str4, String str5, String str6, String str7, String str8, long j11, String str9, VastAdsRequest vastAdsRequest) {
        this.f4564a = str;
        this.f4565b = str2;
        this.f4566c = j10;
        this.f4567d = str3;
        this.f4568e = str4;
        this.f4569f = str5;
        this.f4570g = str6;
        this.f4571h = str7;
        this.f4572i = str8;
        this.f4573j = j11;
        this.f4574k = str9;
        this.f4575l = vastAdsRequest;
        if (TextUtils.isEmpty(str6)) {
            this.f4576m = new JSONObject();
            return;
        }
        try {
            this.f4576m = new JSONObject(str6);
        } catch (JSONException e5) {
            Locale locale = Locale.ROOT;
            Log.w("AdBreakClipInfo", "Error creating AdBreakClipInfo: " + e5.getMessage());
            this.f4570g = null;
            this.f4576m = new JSONObject();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdBreakClipInfo)) {
            return false;
        }
        AdBreakClipInfo adBreakClipInfo = (AdBreakClipInfo) obj;
        return AbstractC3987a.m7972e(this.f4564a, adBreakClipInfo.f4564a) && AbstractC3987a.m7972e(this.f4565b, adBreakClipInfo.f4565b) && this.f4566c == adBreakClipInfo.f4566c && AbstractC3987a.m7972e(this.f4567d, adBreakClipInfo.f4567d) && AbstractC3987a.m7972e(this.f4568e, adBreakClipInfo.f4568e) && AbstractC3987a.m7972e(this.f4569f, adBreakClipInfo.f4569f) && AbstractC3987a.m7972e(this.f4570g, adBreakClipInfo.f4570g) && AbstractC3987a.m7972e(this.f4571h, adBreakClipInfo.f4571h) && AbstractC3987a.m7972e(this.f4572i, adBreakClipInfo.f4572i) && this.f4573j == adBreakClipInfo.f4573j && AbstractC3987a.m7972e(this.f4574k, adBreakClipInfo.f4574k) && AbstractC3987a.m7972e(this.f4575l, adBreakClipInfo.f4575l);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4564a, this.f4565b, Long.valueOf(this.f4566c), this.f4567d, this.f4568e, this.f4569f, this.f4570g, this.f4571h, this.f4572i, Long.valueOf(this.f4573j), this.f4574k, this.f4575l});
    }

    public final JSONObject m3582j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TtmlNode.ATTR_ID, this.f4564a);
            long j10 = this.f4566c;
            Pattern pattern = AbstractC3987a.f13519a;
            jSONObject.put("duration", j10 / 1000.0d);
            long j11 = this.f4573j;
            if (j11 != -1) {
                jSONObject.put("whenSkippable", j11 / 1000.0d);
            }
            String str = this.f4571h;
            if (str != null) {
                jSONObject.put("contentId", str);
            }
            String str2 = this.f4568e;
            if (str2 != null) {
                jSONObject.put("contentType", str2);
            }
            String str3 = this.f4565b;
            if (str3 != null) {
                jSONObject.put("title", str3);
            }
            String str4 = this.f4567d;
            if (str4 != null) {
                jSONObject.put("contentUrl", str4);
            }
            String str5 = this.f4569f;
            if (str5 != null) {
                jSONObject.put("clickThroughUrl", str5);
            }
            JSONObject jSONObject2 = this.f4576m;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
            String str6 = this.f4572i;
            if (str6 != null) {
                jSONObject.put("posterUrl", str6);
            }
            String str7 = this.f4574k;
            if (str7 != null) {
                jSONObject.put("hlsSegmentFormat", str7);
            }
            VastAdsRequest vastAdsRequest = this.f4575l;
            if (vastAdsRequest != null) {
                jSONObject.put("vastAdsRequest", vastAdsRequest.m3608j());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6579R(parcel, 2, this.f4564a);
        AbstractC3280d.m6579R(parcel, 3, this.f4565b);
        AbstractC3280d.m6585X(parcel, 4, 8);
        parcel.writeLong(this.f4566c);
        AbstractC3280d.m6579R(parcel, 5, this.f4567d);
        AbstractC3280d.m6579R(parcel, 6, this.f4568e);
        AbstractC3280d.m6579R(parcel, 7, this.f4569f);
        AbstractC3280d.m6579R(parcel, 8, this.f4570g);
        AbstractC3280d.m6579R(parcel, 9, this.f4571h);
        AbstractC3280d.m6579R(parcel, 10, this.f4572i);
        AbstractC3280d.m6585X(parcel, 11, 8);
        parcel.writeLong(this.f4573j);
        AbstractC3280d.m6579R(parcel, 12, this.f4574k);
        AbstractC3280d.m6578Q(parcel, 13, this.f4575l, i6);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}

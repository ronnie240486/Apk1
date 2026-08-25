package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p078h5.C2661a;
import p156o9.AbstractC3280d;
import p230v4.AbstractC3987a;

public class AdBreakInfo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AdBreakInfo> CREATOR = new C2661a(14);

    public final long f4577a;

    public final String f4578b;

    public final long f4579c;

    public final boolean f4580d;

    public final String[] f4581e;

    public final boolean f4582f;

    public final boolean f4583g;

    public AdBreakInfo(long j10, String str, long j11, boolean z7, String[] strArr, boolean z10, boolean z11) {
        this.f4577a = j10;
        this.f4578b = str;
        this.f4579c = j11;
        this.f4580d = z7;
        this.f4581e = strArr;
        this.f4582f = z10;
        this.f4583g = z11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdBreakInfo)) {
            return false;
        }
        AdBreakInfo adBreakInfo = (AdBreakInfo) obj;
        return AbstractC3987a.m7972e(this.f4578b, adBreakInfo.f4578b) && this.f4577a == adBreakInfo.f4577a && this.f4579c == adBreakInfo.f4579c && this.f4580d == adBreakInfo.f4580d && Arrays.equals(this.f4581e, adBreakInfo.f4581e) && this.f4582f == adBreakInfo.f4582f && this.f4583g == adBreakInfo.f4583g;
    }

    public final int hashCode() {
        return this.f4578b.hashCode();
    }

    public final JSONObject m3583j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TtmlNode.ATTR_ID, this.f4578b);
            long j10 = this.f4577a;
            Pattern pattern = AbstractC3987a.f13519a;
            jSONObject.put("position", j10 / 1000.0d);
            jSONObject.put("isWatched", this.f4580d);
            jSONObject.put("isEmbedded", this.f4582f);
            jSONObject.put("duration", this.f4579c / 1000.0d);
            jSONObject.put("expanded", this.f4583g);
            String[] strArr = this.f4581e;
            if (strArr != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : strArr) {
                    jSONArray.put(str);
                }
                jSONObject.put("breakClipIds", jSONArray);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 2, 8);
        parcel.writeLong(this.f4577a);
        AbstractC3280d.m6579R(parcel, 3, this.f4578b);
        AbstractC3280d.m6585X(parcel, 4, 8);
        parcel.writeLong(this.f4579c);
        AbstractC3280d.m6585X(parcel, 5, 4);
        parcel.writeInt(this.f4580d ? 1 : 0);
        String[] strArr = this.f4581e;
        if (strArr != null) {
            int iM6583V2 = AbstractC3280d.m6583V(parcel, 6);
            parcel.writeStringArray(strArr);
            AbstractC3280d.m6584W(parcel, iM6583V2);
        }
        AbstractC3280d.m6585X(parcel, 7, 4);
        parcel.writeInt(this.f4582f ? 1 : 0);
        AbstractC3280d.m6585X(parcel, 8, 4);
        parcel.writeInt(this.f4583g ? 1 : 0);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}

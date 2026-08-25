package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import org.json.JSONObject;
import p078h5.C2661a;
import p156o9.AbstractC3280d;
import p230v4.AbstractC3987a;

public class MediaError extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<MediaError> CREATOR = new C2661a(17);

    public final String f4631a;

    public final long f4632b;

    public final Integer f4633c;

    public final String f4634d;

    public String f4635e;

    public final JSONObject f4636f;

    public MediaError(String str, long j10, Integer num, String str2, JSONObject jSONObject) {
        this.f4631a = str;
        this.f4632b = j10;
        this.f4633c = num;
        this.f4634d = str2;
        this.f4636f = jSONObject;
    }

    public static MediaError m3590j(JSONObject jSONObject) {
        return new MediaError(jSONObject.optString(SessionDescription.ATTR_TYPE, "ERROR"), jSONObject.optLong("requestId"), jSONObject.has("detailedErrorCode") ? Integer.valueOf(jSONObject.optInt("detailedErrorCode")) : null, AbstractC3987a.m7969b(jSONObject, "reason"), jSONObject.has("customData") ? jSONObject.optJSONObject("customData") : null);
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        JSONObject jSONObject = this.f4636f;
        this.f4635e = jSONObject == null ? null : jSONObject.toString();
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6579R(parcel, 2, this.f4631a);
        AbstractC3280d.m6585X(parcel, 3, 8);
        parcel.writeLong(this.f4632b);
        Integer num = this.f4633c;
        if (num != null) {
            AbstractC3280d.m6585X(parcel, 4, 4);
            parcel.writeInt(num.intValue());
        }
        AbstractC3280d.m6579R(parcel, 5, this.f4634d);
        AbstractC3280d.m6579R(parcel, 6, this.f4635e);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}

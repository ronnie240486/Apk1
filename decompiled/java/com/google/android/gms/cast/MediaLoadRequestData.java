package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import org.json.JSONObject;
import p018b5.AbstractC1312l;
import p078h5.C2661a;
import p111k5.AbstractC2891a;
import p156o9.AbstractC3280d;
import p230v4.C3988b;

public class MediaLoadRequestData extends AbstractSafeParcelable {

    public final MediaInfo f4662a;

    public final MediaQueueData f4663b;

    public final Boolean f4664c;

    public final long f4665d;

    public final double f4666e;

    public final long[] f4667f;

    public String f4668g;

    public final JSONObject f4669h;

    public final String f4670i;

    public final String f4671j;

    public final String f4672k;

    public final String f4673l;

    public final long f4674m;

    public static final C3988b f4661n = new C3988b("MediaLoadRequestData", null);
    public static final Parcelable.Creator<MediaLoadRequestData> CREATOR = new C2661a(21);

    public MediaLoadRequestData(MediaInfo mediaInfo, MediaQueueData mediaQueueData, Boolean bool, long j10, double d, long[] jArr, JSONObject jSONObject, String str, String str2, String str3, String str4, long j11) {
        this.f4662a = mediaInfo;
        this.f4663b = mediaQueueData;
        this.f4664c = bool;
        this.f4665d = j10;
        this.f4666e = d;
        this.f4667f = jArr;
        this.f4669h = jSONObject;
        this.f4670i = str;
        this.f4671j = str2;
        this.f4672k = str3;
        this.f4673l = str4;
        this.f4674m = j11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaLoadRequestData)) {
            return false;
        }
        MediaLoadRequestData mediaLoadRequestData = (MediaLoadRequestData) obj;
        return AbstractC2891a.m5894a(this.f4669h, mediaLoadRequestData.f4669h) && AbstractC1312l.m3201h(this.f4662a, mediaLoadRequestData.f4662a) && AbstractC1312l.m3201h(this.f4663b, mediaLoadRequestData.f4663b) && AbstractC1312l.m3201h(this.f4664c, mediaLoadRequestData.f4664c) && this.f4665d == mediaLoadRequestData.f4665d && this.f4666e == mediaLoadRequestData.f4666e && Arrays.equals(this.f4667f, mediaLoadRequestData.f4667f) && AbstractC1312l.m3201h(this.f4670i, mediaLoadRequestData.f4670i) && AbstractC1312l.m3201h(this.f4671j, mediaLoadRequestData.f4671j) && AbstractC1312l.m3201h(this.f4672k, mediaLoadRequestData.f4672k) && AbstractC1312l.m3201h(this.f4673l, mediaLoadRequestData.f4673l) && this.f4674m == mediaLoadRequestData.f4674m;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4662a, this.f4663b, this.f4664c, Long.valueOf(this.f4665d), Double.valueOf(this.f4666e), this.f4667f, String.valueOf(this.f4669h), this.f4670i, this.f4671j, this.f4672k, this.f4673l, Long.valueOf(this.f4674m)});
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        JSONObject jSONObject = this.f4669h;
        this.f4668g = jSONObject == null ? null : jSONObject.toString();
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6578Q(parcel, 2, this.f4662a, i6);
        AbstractC3280d.m6578Q(parcel, 3, this.f4663b, i6);
        AbstractC3280d.m6573L(parcel, 4, this.f4664c);
        AbstractC3280d.m6585X(parcel, 5, 8);
        parcel.writeLong(this.f4665d);
        AbstractC3280d.m6585X(parcel, 6, 8);
        parcel.writeDouble(this.f4666e);
        AbstractC3280d.m6577P(parcel, 7, this.f4667f);
        AbstractC3280d.m6579R(parcel, 8, this.f4668g);
        AbstractC3280d.m6579R(parcel, 9, this.f4670i);
        AbstractC3280d.m6579R(parcel, 10, this.f4671j);
        AbstractC3280d.m6579R(parcel, 11, this.f4672k);
        AbstractC3280d.m6579R(parcel, 12, this.f4673l);
        AbstractC3280d.m6585X(parcel, 13, 8);
        parcel.writeLong(this.f4674m);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}

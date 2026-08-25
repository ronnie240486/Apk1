package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p078h5.C2661a;
import p111k5.AbstractC2891a;
import p156o9.AbstractC3280d;
import p230v4.AbstractC3987a;

public class MediaQueueItem extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MediaQueueItem> CREATOR = new C2661a(25);

    public MediaInfo f4695a;

    public int f4696b;

    public boolean f4697c;

    public double f4698d;

    public double f4699e;

    public double f4700f;

    public long[] f4701g;

    public String f4702h;

    public JSONObject f4703i;

    public MediaQueueItem(MediaInfo mediaInfo, int i6, boolean z7, double d, double d10, double d11, long[] jArr, String str) {
        this.f4695a = mediaInfo;
        this.f4696b = i6;
        this.f4697c = z7;
        this.f4698d = d;
        this.f4699e = d10;
        this.f4700f = d11;
        this.f4701g = jArr;
        this.f4702h = str;
        if (str == null) {
            this.f4703i = null;
            return;
        }
        try {
            this.f4703i = new JSONObject(this.f4702h);
        } catch (JSONException unused) {
            this.f4703i = null;
            this.f4702h = null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaQueueItem)) {
            return false;
        }
        MediaQueueItem mediaQueueItem = (MediaQueueItem) obj;
        JSONObject jSONObject = this.f4703i;
        boolean z7 = jSONObject == null;
        JSONObject jSONObject2 = mediaQueueItem.f4703i;
        if (z7 != (jSONObject2 == null)) {
            return false;
        }
        return (jSONObject == null || jSONObject2 == null || AbstractC2891a.m5894a(jSONObject, jSONObject2)) && AbstractC3987a.m7972e(this.f4695a, mediaQueueItem.f4695a) && this.f4696b == mediaQueueItem.f4696b && this.f4697c == mediaQueueItem.f4697c && ((Double.isNaN(this.f4698d) && Double.isNaN(mediaQueueItem.f4698d)) || this.f4698d == mediaQueueItem.f4698d) && this.f4699e == mediaQueueItem.f4699e && this.f4700f == mediaQueueItem.f4700f && Arrays.equals(this.f4701g, mediaQueueItem.f4701g);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4695a, Integer.valueOf(this.f4696b), Boolean.valueOf(this.f4697c), Double.valueOf(this.f4698d), Double.valueOf(this.f4699e), Double.valueOf(this.f4700f), Integer.valueOf(Arrays.hashCode(this.f4701g)), String.valueOf(this.f4703i)});
    }

    public final boolean m3599j(JSONObject jSONObject) {
        boolean z7;
        long[] jArr;
        boolean z10;
        int i6;
        boolean z11 = false;
        if (jSONObject.has("media")) {
            this.f4695a = new MediaInfo(jSONObject.getJSONObject("media"));
            z7 = true;
        } else {
            z7 = false;
        }
        if (jSONObject.has("itemId") && this.f4696b != (i6 = jSONObject.getInt("itemId"))) {
            this.f4696b = i6;
            z7 = true;
        }
        if (jSONObject.has("autoplay") && this.f4697c != (z10 = jSONObject.getBoolean("autoplay"))) {
            this.f4697c = z10;
            z7 = true;
        }
        double dOptDouble = jSONObject.optDouble("startTime");
        if (Double.isNaN(dOptDouble) != Double.isNaN(this.f4698d) || (!Double.isNaN(dOptDouble) && Math.abs(dOptDouble - this.f4698d) > 1.0E-7d)) {
            this.f4698d = dOptDouble;
            z7 = true;
        }
        if (jSONObject.has("playbackDuration")) {
            double d = jSONObject.getDouble("playbackDuration");
            if (Math.abs(d - this.f4699e) > 1.0E-7d) {
                this.f4699e = d;
                z7 = true;
            }
        }
        if (jSONObject.has("preloadTime")) {
            double d10 = jSONObject.getDouble("preloadTime");
            if (Math.abs(d10 - this.f4700f) > 1.0E-7d) {
                this.f4700f = d10;
                z7 = true;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            jArr = new long[length];
            for (int i10 = 0; i10 < length; i10++) {
                jArr[i10] = jSONArray.getLong(i10);
            }
            long[] jArr2 = this.f4701g;
            if (jArr2 == null || jArr2.length != length) {
                z11 = true;
                break;
            }
            for (int i11 = 0; i11 < length; i11++) {
                if (this.f4701g[i11] != jArr[i11]) {
                    z11 = true;
                    break;
                }
            }
        } else {
            jArr = null;
        }
        if (z11) {
            this.f4701g = jArr;
            z7 = true;
        }
        if (!jSONObject.has("customData")) {
            return z7;
        }
        this.f4703i = jSONObject.getJSONObject("customData");
        return true;
    }

    public final JSONObject m3600l() {
        JSONObject jSONObject = new JSONObject();
        try {
            MediaInfo mediaInfo = this.f4695a;
            if (mediaInfo != null) {
                jSONObject.put("media", mediaInfo.m3591j());
            }
            int i6 = this.f4696b;
            if (i6 != 0) {
                jSONObject.put("itemId", i6);
            }
            jSONObject.put("autoplay", this.f4697c);
            if (!Double.isNaN(this.f4698d)) {
                jSONObject.put("startTime", this.f4698d);
            }
            double d = this.f4699e;
            if (d != Double.POSITIVE_INFINITY) {
                jSONObject.put("playbackDuration", d);
            }
            jSONObject.put("preloadTime", this.f4700f);
            if (this.f4701g != null) {
                JSONArray jSONArray = new JSONArray();
                for (long j10 : this.f4701g) {
                    jSONArray.put(j10);
                }
                jSONObject.put("activeTrackIds", jSONArray);
            }
            JSONObject jSONObject2 = this.f4703i;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        JSONObject jSONObject = this.f4703i;
        this.f4702h = jSONObject == null ? null : jSONObject.toString();
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6578Q(parcel, 2, this.f4695a, i6);
        int i10 = this.f4696b;
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(i10);
        boolean z7 = this.f4697c;
        AbstractC3280d.m6585X(parcel, 4, 4);
        parcel.writeInt(z7 ? 1 : 0);
        double d = this.f4698d;
        AbstractC3280d.m6585X(parcel, 5, 8);
        parcel.writeDouble(d);
        double d10 = this.f4699e;
        AbstractC3280d.m6585X(parcel, 6, 8);
        parcel.writeDouble(d10);
        double d11 = this.f4700f;
        AbstractC3280d.m6585X(parcel, 7, 8);
        parcel.writeDouble(d11);
        AbstractC3280d.m6577P(parcel, 8, this.f4701g);
        AbstractC3280d.m6579R(parcel, 9, this.f4702h);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }

    public MediaQueueItem(JSONObject jSONObject) {
        this(null, 0, true, Double.NaN, Double.POSITIVE_INFINITY, 0.0d, null, null);
        m3599j(jSONObject);
    }
}

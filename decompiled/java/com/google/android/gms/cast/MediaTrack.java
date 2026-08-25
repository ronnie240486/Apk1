package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.lzy.okgo.cookie.SerializableCookie;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p078h5.C2661a;
import p111k5.AbstractC2891a;
import p156o9.AbstractC3280d;
import p230v4.AbstractC3987a;

public final class MediaTrack extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<MediaTrack> CREATOR = new C2661a(27);

    public final long f4728a;

    public final int f4729b;

    public final String f4730c;

    public final String f4731d;

    public final String f4732e;

    public final String f4733f;

    public final int f4734g;

    public final AbstractCollection f4735h;

    public String f4736i;

    public final JSONObject f4737j;

    public MediaTrack(long j10, int i6, String str, String str2, String str3, String str4, int i10, List list, JSONObject jSONObject) {
        this.f4728a = j10;
        this.f4729b = i6;
        this.f4730c = str;
        this.f4731d = str2;
        this.f4732e = str3;
        this.f4733f = str4;
        this.f4734g = i10;
        this.f4735h = (AbstractCollection) list;
        this.f4737j = jSONObject;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaTrack)) {
            return false;
        }
        MediaTrack mediaTrack = (MediaTrack) obj;
        JSONObject jSONObject = this.f4737j;
        boolean z7 = jSONObject == null;
        JSONObject jSONObject2 = mediaTrack.f4737j;
        if (z7 != (jSONObject2 == null)) {
            return false;
        }
        return (jSONObject == null || jSONObject2 == null || AbstractC2891a.m5894a(jSONObject, jSONObject2)) && this.f4728a == mediaTrack.f4728a && this.f4729b == mediaTrack.f4729b && AbstractC3987a.m7972e(this.f4730c, mediaTrack.f4730c) && AbstractC3987a.m7972e(this.f4731d, mediaTrack.f4731d) && AbstractC3987a.m7972e(this.f4732e, mediaTrack.f4732e) && AbstractC3987a.m7972e(this.f4733f, mediaTrack.f4733f) && this.f4734g == mediaTrack.f4734g && AbstractC3987a.m7972e(this.f4735h, mediaTrack.f4735h);
    }

    public final int hashCode() {
        Long lValueOf = Long.valueOf(this.f4728a);
        Integer numValueOf = Integer.valueOf(this.f4729b);
        Integer numValueOf2 = Integer.valueOf(this.f4734g);
        String strValueOf = String.valueOf(this.f4737j);
        return Arrays.hashCode(new Object[]{lValueOf, numValueOf, this.f4730c, this.f4731d, this.f4732e, this.f4733f, numValueOf2, this.f4735h, strValueOf});
    }

    public final JSONObject m3604j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trackId", this.f4728a);
            int i6 = this.f4729b;
            if (i6 == 1) {
                jSONObject.put(SessionDescription.ATTR_TYPE, "TEXT");
            } else if (i6 == 2) {
                jSONObject.put(SessionDescription.ATTR_TYPE, "AUDIO");
            } else if (i6 == 3) {
                jSONObject.put(SessionDescription.ATTR_TYPE, "VIDEO");
            }
            String str = this.f4730c;
            if (str != null) {
                jSONObject.put("trackContentId", str);
            }
            String str2 = this.f4731d;
            if (str2 != null) {
                jSONObject.put("trackContentType", str2);
            }
            String str3 = this.f4732e;
            if (str3 != null) {
                jSONObject.put(SerializableCookie.NAME, str3);
            }
            String str4 = this.f4733f;
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("language", str4);
            }
            int i10 = this.f4734g;
            if (i10 == 1) {
                jSONObject.put("subtype", "SUBTITLES");
            } else if (i10 == 2) {
                jSONObject.put("subtype", "CAPTIONS");
            } else if (i10 == 3) {
                jSONObject.put("subtype", "DESCRIPTIONS");
            } else if (i10 == 4) {
                jSONObject.put("subtype", "CHAPTERS");
            } else if (i10 == 5) {
                jSONObject.put("subtype", "METADATA");
            }
            AbstractCollection abstractCollection = this.f4735h;
            if (abstractCollection != null) {
                jSONObject.put("roles", new JSONArray((Collection) abstractCollection));
            }
            JSONObject jSONObject2 = this.f4737j;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        JSONObject jSONObject = this.f4737j;
        this.f4736i = jSONObject == null ? null : jSONObject.toString();
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 2, 8);
        parcel.writeLong(this.f4728a);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(this.f4729b);
        AbstractC3280d.m6579R(parcel, 4, this.f4730c);
        AbstractC3280d.m6579R(parcel, 5, this.f4731d);
        AbstractC3280d.m6579R(parcel, 6, this.f4732e);
        AbstractC3280d.m6579R(parcel, 7, this.f4733f);
        AbstractC3280d.m6585X(parcel, 8, 4);
        parcel.writeInt(this.f4734g);
        AbstractC3280d.m6580S(parcel, 9, this.f4735h);
        AbstractC3280d.m6579R(parcel, 10, this.f4736i);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}

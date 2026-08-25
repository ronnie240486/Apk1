package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.lzy.okgo.cookie.SerializableCookie;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p018b5.AbstractC1312l;
import p078h5.C2661a;
import p156o9.AbstractC3280d;
import p230v4.AbstractC3987a;

public class MediaQueueData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MediaQueueData> CREATOR = new C2661a(24);

    public String f4685a;

    public String f4686b;

    public int f4687c;

    public String f4688d;

    public MediaQueueContainerMetadata f4689e;

    public int f4690f;

    public ArrayList f4691g;

    public int f4692h;

    public long f4693i;

    public boolean f4694j;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaQueueData)) {
            return false;
        }
        MediaQueueData mediaQueueData = (MediaQueueData) obj;
        return TextUtils.equals(this.f4685a, mediaQueueData.f4685a) && TextUtils.equals(this.f4686b, mediaQueueData.f4686b) && this.f4687c == mediaQueueData.f4687c && TextUtils.equals(this.f4688d, mediaQueueData.f4688d) && AbstractC1312l.m3201h(this.f4689e, mediaQueueData.f4689e) && this.f4690f == mediaQueueData.f4690f && AbstractC1312l.m3201h(this.f4691g, mediaQueueData.f4691g) && this.f4692h == mediaQueueData.f4692h && this.f4693i == mediaQueueData.f4693i && this.f4694j == mediaQueueData.f4694j;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4685a, this.f4686b, Integer.valueOf(this.f4687c), this.f4688d, this.f4689e, Integer.valueOf(this.f4690f), this.f4691g, Integer.valueOf(this.f4692h), Long.valueOf(this.f4693i), Boolean.valueOf(this.f4694j)});
    }

    public final JSONObject m3598j() {
        String str;
        ArrayList arrayList;
        long j10;
        JSONArray jSONArray;
        Iterator it;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f4685a)) {
                jSONObject.put(TtmlNode.ATTR_ID, this.f4685a);
            }
            if (!TextUtils.isEmpty(this.f4686b)) {
                jSONObject.put("entity", this.f4686b);
            }
            switch (this.f4687c) {
                case 1:
                    jSONObject.put("queueType", "ALBUM");
                    break;
                case 2:
                    jSONObject.put("queueType", "PLAYLIST");
                    break;
                case 3:
                    jSONObject.put("queueType", "AUDIOBOOK");
                    break;
                case 4:
                    jSONObject.put("queueType", "RADIO_STATION");
                    break;
                case 5:
                    jSONObject.put("queueType", "PODCAST_SERIES");
                    break;
                case 6:
                    jSONObject.put("queueType", "TV_SERIES");
                    break;
                case 7:
                    jSONObject.put("queueType", "VIDEO_PLAYLIST");
                    break;
                case 8:
                    jSONObject.put("queueType", "LIVE_TV");
                    break;
                case 9:
                    jSONObject.put("queueType", "MOVIE");
                    break;
            }
            if (!TextUtils.isEmpty(this.f4688d)) {
                jSONObject.put(SerializableCookie.NAME, this.f4688d);
            }
            MediaQueueContainerMetadata mediaQueueContainerMetadata = this.f4689e;
            if (mediaQueueContainerMetadata != null) {
                jSONObject.put("containerMetadata", mediaQueueContainerMetadata.m3597j());
            }
            Integer numValueOf = Integer.valueOf(this.f4690f);
            if (numValueOf != null) {
                int iIntValue = numValueOf.intValue();
                if (iIntValue == 0) {
                    str = "REPEAT_OFF";
                } else if (iIntValue == 1) {
                    str = "REPEAT_ALL";
                } else if (iIntValue == 2) {
                    str = "REPEAT_SINGLE";
                } else if (iIntValue == 3) {
                    str = "REPEAT_ALL_AND_SHUFFLE";
                }
                if (str != null) {
                    jSONObject.put("repeatMode", str);
                }
                arrayList = this.f4691g;
                if (arrayList != null && !arrayList.isEmpty()) {
                    jSONArray = new JSONArray();
                    it = this.f4691g.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(((MediaQueueItem) it.next()).m3600l());
                    }
                    jSONObject.put("items", jSONArray);
                }
                jSONObject.put("startIndex", this.f4692h);
                j10 = this.f4693i;
                if (j10 != -1) {
                    Pattern pattern = AbstractC3987a.f13519a;
                    jSONObject.put("startTime", j10 / 1000.0d);
                }
                jSONObject.put("shuffle", this.f4694j);
                return jSONObject;
            }
            str = null;
            if (str != null) {
                jSONObject.put("repeatMode", str);
            }
            arrayList = this.f4691g;
            if (arrayList != null) {
                jSONArray = new JSONArray();
                it = this.f4691g.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((MediaQueueItem) it.next()).m3600l());
                }
                jSONObject.put("items", jSONArray);
            }
            jSONObject.put("startIndex", this.f4692h);
            j10 = this.f4693i;
            if (j10 != -1) {
                Pattern pattern2 = AbstractC3987a.f13519a;
                jSONObject.put("startTime", j10 / 1000.0d);
            }
            jSONObject.put("shuffle", this.f4694j);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6579R(parcel, 2, this.f4685a);
        AbstractC3280d.m6579R(parcel, 3, this.f4686b);
        int i10 = this.f4687c;
        AbstractC3280d.m6585X(parcel, 4, 4);
        parcel.writeInt(i10);
        AbstractC3280d.m6579R(parcel, 5, this.f4688d);
        AbstractC3280d.m6578Q(parcel, 6, this.f4689e, i6);
        int i11 = this.f4690f;
        AbstractC3280d.m6585X(parcel, 7, 4);
        parcel.writeInt(i11);
        ArrayList arrayList = this.f4691g;
        AbstractC3280d.m6582U(parcel, 8, arrayList == null ? null : Collections.unmodifiableList(arrayList));
        int i12 = this.f4692h;
        AbstractC3280d.m6585X(parcel, 9, 4);
        parcel.writeInt(i12);
        long j10 = this.f4693i;
        AbstractC3280d.m6585X(parcel, 10, 8);
        parcel.writeLong(j10);
        boolean z7 = this.f4694j;
        AbstractC3280d.m6585X(parcel, 11, 4);
        parcel.writeInt(z7 ? 1 : 0);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}

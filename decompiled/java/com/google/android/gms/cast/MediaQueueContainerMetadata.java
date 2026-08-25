package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p018b5.AbstractC1312l;
import p078h5.C2661a;
import p156o9.AbstractC3280d;
import p241w4.AbstractC4052a;

public class MediaQueueContainerMetadata extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MediaQueueContainerMetadata> CREATOR = new C2661a(23);

    public int f4680a;

    public String f4681b;

    public ArrayList f4682c;

    public ArrayList f4683d;

    public double f4684e;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaQueueContainerMetadata)) {
            return false;
        }
        MediaQueueContainerMetadata mediaQueueContainerMetadata = (MediaQueueContainerMetadata) obj;
        return this.f4680a == mediaQueueContainerMetadata.f4680a && TextUtils.equals(this.f4681b, mediaQueueContainerMetadata.f4681b) && AbstractC1312l.m3201h(this.f4682c, mediaQueueContainerMetadata.f4682c) && AbstractC1312l.m3201h(this.f4683d, mediaQueueContainerMetadata.f4683d) && this.f4684e == mediaQueueContainerMetadata.f4684e;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f4680a), this.f4681b, this.f4682c, this.f4683d, Double.valueOf(this.f4684e)});
    }

    public final JSONObject m3597j() {
        JSONObject jSONObject = new JSONObject();
        try {
            int i6 = this.f4680a;
            if (i6 == 0) {
                jSONObject.put("containerType", "GENERIC_CONTAINER");
            } else if (i6 == 1) {
                jSONObject.put("containerType", "AUDIOBOOK_CONTAINER");
            }
            if (!TextUtils.isEmpty(this.f4681b)) {
                jSONObject.put("title", this.f4681b);
            }
            ArrayList arrayList = this.f4682c;
            if (arrayList != null && !arrayList.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = this.f4682c.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((MediaMetadata) it.next()).m3595l());
                }
                jSONObject.put("sections", jSONArray);
            }
            ArrayList arrayList2 = this.f4683d;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                jSONObject.put("containerImages", AbstractC4052a.m8056b(this.f4683d));
            }
            jSONObject.put("containerDuration", this.f4684e);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        int i10 = this.f4680a;
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(i10);
        AbstractC3280d.m6579R(parcel, 3, this.f4681b);
        ArrayList arrayList = this.f4682c;
        AbstractC3280d.m6582U(parcel, 4, arrayList == null ? null : Collections.unmodifiableList(arrayList));
        ArrayList arrayList2 = this.f4683d;
        AbstractC3280d.m6582U(parcel, 5, arrayList2 != null ? Collections.unmodifiableList(arrayList2) : null);
        double d = this.f4684e;
        AbstractC3280d.m6585X(parcel, 6, 8);
        parcel.writeDouble(d);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}

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

public class SessionState extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SessionState> CREATOR = new C2661a(29);

    public final MediaLoadRequestData f4738a;

    public String f4739b;

    public final JSONObject f4740c;

    public SessionState(MediaLoadRequestData mediaLoadRequestData, JSONObject jSONObject) {
        this.f4738a = mediaLoadRequestData;
        this.f4740c = jSONObject;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionState)) {
            return false;
        }
        SessionState sessionState = (SessionState) obj;
        if (AbstractC2891a.m5894a(this.f4740c, sessionState.f4740c)) {
            return AbstractC1312l.m3201h(this.f4738a, sessionState.f4738a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4738a, String.valueOf(this.f4740c)});
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        JSONObject jSONObject = this.f4740c;
        this.f4739b = jSONObject == null ? null : jSONObject.toString();
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6578Q(parcel, 2, this.f4738a, i6);
        AbstractC3280d.m6579R(parcel, 3, this.f4739b);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}

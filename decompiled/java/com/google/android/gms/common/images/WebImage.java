package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.lzy.okgo.model.Progress;
import java.util.Arrays;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import p018b5.AbstractC1312l;
import p156o9.AbstractC3280d;
import p237w0.C4043d;

public final class WebImage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new C4043d(20);

    public final int f5022a;

    public final Uri f5023b;

    public final int f5024c;

    public final int f5025d;

    public WebImage(int i6, Uri uri, int i10, int i11) {
        this.f5022a = i6;
        this.f5023b = uri;
        this.f5024c = i10;
        this.f5025d = i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof WebImage)) {
            WebImage webImage = (WebImage) obj;
            if (AbstractC1312l.m3201h(this.f5023b, webImage.f5023b) && this.f5024c == webImage.f5024c && this.f5025d == webImage.f5025d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5023b, Integer.valueOf(this.f5024c), Integer.valueOf(this.f5025d)});
    }

    public final String toString() {
        Locale locale = Locale.US;
        return "Image " + this.f5024c + "x" + this.f5025d + " " + this.f5023b.toString();
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 1, 4);
        parcel.writeInt(this.f5022a);
        AbstractC3280d.m6578Q(parcel, 2, this.f5023b, i6);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(this.f5024c);
        AbstractC3280d.m6585X(parcel, 4, 4);
        parcel.writeInt(this.f5025d);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }

    public WebImage(JSONObject jSONObject) {
        Uri uri = Uri.EMPTY;
        if (jSONObject.has(Progress.URL)) {
            try {
                uri = Uri.parse(jSONObject.getString(Progress.URL));
            } catch (JSONException unused) {
            }
        }
        int iOptInt = jSONObject.optInt("width", 0);
        int iOptInt2 = jSONObject.optInt("height", 0);
        this(1, uri, iOptInt, iOptInt2);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        }
        if (iOptInt < 0 || iOptInt2 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }
}

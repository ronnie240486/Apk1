package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p156o9.AbstractC3280d;
import p165p4.C3371p;
import p230v4.C3988b;

public final class VideoInfo extends AbstractSafeParcelable {

    public final int f4757a;

    public final int f4758b;

    public final int f4759c;

    public static final C3988b f4756d = new C3988b("VideoInfo", null);
    public static final Parcelable.Creator<VideoInfo> CREATOR = new C3371p(2);

    public VideoInfo(int i6, int i10, int i11) {
        this.f4757a = i6;
        this.f4758b = i10;
        this.f4759c = i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoInfo)) {
            return false;
        }
        VideoInfo videoInfo = (VideoInfo) obj;
        return this.f4758b == videoInfo.f4758b && this.f4757a == videoInfo.f4757a && this.f4759c == videoInfo.f4759c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f4758b), Integer.valueOf(this.f4757a), Integer.valueOf(this.f4759c)});
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 2, 4);
        parcel.writeInt(this.f4757a);
        AbstractC3280d.m6585X(parcel, 3, 4);
        parcel.writeInt(this.f4758b);
        AbstractC3280d.m6585X(parcel, 4, 4);
        parcel.writeInt(this.f4759c);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}

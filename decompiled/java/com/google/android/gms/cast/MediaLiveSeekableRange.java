package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p078h5.C2661a;
import p156o9.AbstractC3280d;
import p230v4.C3988b;

public class MediaLiveSeekableRange extends AbstractSafeParcelable {

    public final long f4657a;

    public final long f4658b;

    public final boolean f4659c;

    public final boolean f4660d;

    public static final C3988b f4656e = new C3988b("MediaLiveSeekableRange", null);
    public static final Parcelable.Creator<MediaLiveSeekableRange> CREATOR = new C2661a(19);

    public MediaLiveSeekableRange(long j10, long j11, boolean z7, boolean z10) {
        this.f4657a = Math.max(j10, 0L);
        this.f4658b = Math.max(j11, 0L);
        this.f4659c = z7;
        this.f4660d = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaLiveSeekableRange)) {
            return false;
        }
        MediaLiveSeekableRange mediaLiveSeekableRange = (MediaLiveSeekableRange) obj;
        return this.f4657a == mediaLiveSeekableRange.f4657a && this.f4658b == mediaLiveSeekableRange.f4658b && this.f4659c == mediaLiveSeekableRange.f4659c && this.f4660d == mediaLiveSeekableRange.f4660d;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f4657a), Long.valueOf(this.f4658b), Boolean.valueOf(this.f4659c), Boolean.valueOf(this.f4660d)});
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i6) {
        int iM6583V = AbstractC3280d.m6583V(parcel, 20293);
        AbstractC3280d.m6585X(parcel, 2, 8);
        parcel.writeLong(this.f4657a);
        AbstractC3280d.m6585X(parcel, 3, 8);
        parcel.writeLong(this.f4658b);
        AbstractC3280d.m6585X(parcel, 4, 4);
        parcel.writeInt(this.f4659c ? 1 : 0);
        AbstractC3280d.m6585X(parcel, 5, 4);
        parcel.writeInt(this.f4660d ? 1 : 0);
        AbstractC3280d.m6584W(parcel, iM6583V);
    }
}

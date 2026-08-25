package androidx.media3.exoplayer.source;

import android.os.Bundle;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.BundleCollectionUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.ArrayList;
import p041d7.AbstractC2182d0;
import p041d7.AbstractC2301u1;

@UnstableApi
public final class TrackGroupArray {
    public static final TrackGroupArray EMPTY = new TrackGroupArray(new TrackGroup[0]);
    private static final String FIELD_TRACK_GROUPS = Util.intToStringMaxRadix(0);
    private static final String TAG = "TrackGroupArray";
    private int hashCode;
    public final int length;
    private final AbstractC2301u1 trackGroups;

    public TrackGroupArray(TrackGroup... trackGroupArr) {
        this.trackGroups = AbstractC2301u1.m5273o(trackGroupArr);
        this.length = trackGroupArr.length;
        verifyCorrectness();
    }

    public static TrackGroupArray fromBundle(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(FIELD_TRACK_GROUPS);
        return parcelableArrayList == null ? new TrackGroupArray(new TrackGroup[0]) : new TrackGroupArray((TrackGroup[]) BundleCollectionUtil.fromBundleList(new C0911k(4), parcelableArrayList).toArray(new TrackGroup[0]));
    }

    public static Integer lambda$getTrackTypes$0(TrackGroup trackGroup) {
        return Integer.valueOf(trackGroup.type);
    }

    private void verifyCorrectness() {
        int i6 = 0;
        while (i6 < this.trackGroups.size()) {
            int i10 = i6 + 1;
            for (int i11 = i10; i11 < this.trackGroups.size(); i11++) {
                if (((TrackGroup) this.trackGroups.get(i6)).equals(this.trackGroups.get(i11))) {
                    Log.m1716e(TAG, "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i6 = i10;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroupArray.class != obj.getClass()) {
            return false;
        }
        TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
        return this.length == trackGroupArray.length && this.trackGroups.equals(trackGroupArray.trackGroups);
    }

    public TrackGroup get(int i6) {
        return (TrackGroup) this.trackGroups.get(i6);
    }

    public AbstractC2301u1 getTrackTypes() {
        return AbstractC2301u1.m5272n(AbstractC2182d0.m5136H(this.trackGroups, new C0911k(2)));
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = this.trackGroups.hashCode();
        }
        return this.hashCode;
    }

    public int indexOf(TrackGroup trackGroup) {
        int iIndexOf = this.trackGroups.indexOf(trackGroup);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(FIELD_TRACK_GROUPS, BundleCollectionUtil.toBundleArrayList(this.trackGroups, new C0911k(3)));
        return bundle;
    }

    public String toString() {
        return this.trackGroups.toString();
    }
}

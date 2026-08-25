package androidx.media3.common.text;

import android.os.Bundle;
import androidx.media3.common.C0596g;
import androidx.media3.common.util.BundleCollectionUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.ArrayList;
import java.util.List;
import p041d7.AbstractC2301u1;
import p041d7.C2180c5;
import p041d7.C2204g1;
import p041d7.C2288s1;

public final class CueGroup {

    @UnstableApi
    public static final CueGroup EMPTY_TIME_ZERO;
    private static final String FIELD_CUES;
    private static final String FIELD_PRESENTATION_TIME_US;
    public final AbstractC2301u1 cues;

    @UnstableApi
    public final long presentationTimeUs;

    static {
        C2204g1 c2204g1 = AbstractC2301u1.f8069b;
        EMPTY_TIME_ZERO = new CueGroup(C2180c5.f7862e, 0L);
        FIELD_CUES = Util.intToStringMaxRadix(0);
        FIELD_PRESENTATION_TIME_US = Util.intToStringMaxRadix(1);
    }

    @UnstableApi
    public CueGroup(List<Cue> list, long j10) {
        this.cues = AbstractC2301u1.m5272n(list);
        this.presentationTimeUs = j10;
    }

    private static AbstractC2301u1 filterOutBitmapCues(List<Cue> list) {
        C2288s1 c2288s1M5269k = AbstractC2301u1.m5269k();
        for (int i6 = 0; i6 < list.size(); i6++) {
            if (list.get(i6).bitmap == null) {
                c2288s1M5269k.m5255a(list.get(i6));
            }
        }
        return c2288s1M5269k.m5262g();
    }

    @UnstableApi
    public static CueGroup fromBundle(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(FIELD_CUES);
        return new CueGroup(parcelableArrayList == null ? C2180c5.f7862e : BundleCollectionUtil.fromBundleList(new C0596g(14), parcelableArrayList), bundle.getLong(FIELD_PRESENTATION_TIME_US));
    }

    @UnstableApi
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(FIELD_CUES, BundleCollectionUtil.toBundleArrayList(filterOutBitmapCues(this.cues), new C0596g(15)));
        bundle.putLong(FIELD_PRESENTATION_TIME_US, this.presentationTimeUs);
        return bundle;
    }
}

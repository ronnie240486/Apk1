package androidx.media3.extractor.mp4;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.SniffFailure;
import java.util.Arrays;
import p070g7.C2613a;

@UnstableApi
public final class UnsupportedBrandsSniffFailure implements SniffFailure {
    public final C2613a compatibleBrands;
    public final int majorBrand;

    public UnsupportedBrandsSniffFailure(int i6, int[] iArr) {
        C2613a c2613a;
        this.majorBrand = i6;
        if (iArr != null) {
            C2613a c2613a2 = C2613a.f9090c;
            c2613a = iArr.length == 0 ? C2613a.f9090c : new C2613a(Arrays.copyOf(iArr, iArr.length));
        } else {
            c2613a = C2613a.f9090c;
        }
        this.compatibleBrands = c2613a;
    }
}

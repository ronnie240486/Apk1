package p258y1;

import android.widget.ImageView;

public abstract class AbstractC4207f {

    public static final int[] f14295a;

    static {
        int[] iArr = new int[ImageView.ScaleType.values().length];
        f14295a = iArr;
        try {
            iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f14295a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}

package p228v2;

import com.bumptech.glide.load.ImageHeaderParser$ImageType;

public abstract class AbstractC3976c {

    public static final int[] f13508a;

    static {
        int[] iArr = new int[ImageHeaderParser$ImageType.values().length];
        f13508a = iArr;
        try {
            iArr[ImageHeaderParser$ImageType.WEBP.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f13508a[ImageHeaderParser$ImageType.WEBP_A.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f13508a[ImageHeaderParser$ImageType.ANIMATED_WEBP.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}

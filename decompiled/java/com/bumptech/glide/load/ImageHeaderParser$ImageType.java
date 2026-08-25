package com.bumptech.glide.load;

import p228v2.AbstractC3976c;

public enum ImageHeaderParser$ImageType {
    GIF(0),
    JPEG(1),
    RAW(2),
    PNG_A(3),
    PNG(4),
    WEBP_A(5),
    WEBP(6),
    ANIMATED_WEBP(7),
    AVIF(8),
    ANIMATED_AVIF(9),
    UNKNOWN(10);


    public final boolean f4470a;

    ImageHeaderParser$ImageType(int i6) {
        this.f4470a = z;
    }

    public boolean hasAlpha() {
        return this.f4470a;
    }

    public boolean isWebp() {
        int i6 = AbstractC3976c.f13508a[ordinal()];
        return i6 == 1 || i6 == 2 || i6 == 3;
    }
}

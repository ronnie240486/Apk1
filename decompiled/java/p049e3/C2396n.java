package p049e3;

import p228v2.C3980g;

public final class C2396n {

    public static final C2396n f8357b = new C2396n(2);

    public static final C2396n f8358c = new C2396n(0);

    public static final C2396n f8359d;

    public static final C2396n f8360e;

    public static final C2396n f8361f;

    public static final C3980g f8362g;

    public static final boolean f8363h;

    public final int f8364a;

    static {
        C2396n c2396n = new C2396n(1);
        f8359d = c2396n;
        f8360e = new C2396n(3);
        f8361f = c2396n;
        f8362g = C3980g.m7966a(c2396n, "com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy");
        f8363h = true;
    }

    public C2396n(int i6) {
        this.f8364a = i6;
    }

    public final int m5426a(int i6, int i10, int i11, int i12) {
        switch (this.f8364a) {
            case 0:
                if (m5427b(i6, i10, i11, i12) == 1.0f) {
                    return 2;
                }
                return f8357b.m5426a(i6, i10, i11, i12);
            case 1:
                return 2;
            case 2:
                return f8363h ? 2 : 1;
            default:
                return 2;
        }
    }

    public final float m5427b(int i6, int i10, int i11, int i12) {
        switch (this.f8364a) {
            case 0:
                return Math.min(1.0f, f8357b.m5427b(i6, i10, i11, i12));
            case 1:
                return Math.max(i11 / i6, i12 / i10);
            case 2:
                if (f8363h) {
                    return Math.min(i11 / i6, i12 / i10);
                }
                int iMax = Math.max(i10 / i12, i6 / i11);
                if (iMax == 0) {
                    return 1.0f;
                }
                return 1.0f / Integer.highestOneBit(iMax);
            default:
                return 1.0f;
        }
    }
}

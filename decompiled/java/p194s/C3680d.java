package p194s;

public final class C3680d extends C3681e {

    public final double f12317d;

    public final double f12318e;

    public final double f12319f;

    public final double f12320g;

    public C3680d(String str) {
        this.f12323a = str;
        int iIndexOf = str.indexOf(40);
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        this.f12317d = Double.parseDouble(str.substring(iIndexOf + 1, iIndexOf2).trim());
        int i6 = iIndexOf2 + 1;
        int iIndexOf3 = str.indexOf(44, i6);
        this.f12318e = Double.parseDouble(str.substring(i6, iIndexOf3).trim());
        int i10 = iIndexOf3 + 1;
        int iIndexOf4 = str.indexOf(44, i10);
        this.f12319f = Double.parseDouble(str.substring(i10, iIndexOf4).trim());
        int i11 = iIndexOf4 + 1;
        this.f12320g = Double.parseDouble(str.substring(i11, str.indexOf(41, i11)).trim());
    }

    @Override
    public final double mo7428a(double d) {
        if (d <= 0.0d) {
            return 0.0d;
        }
        if (d >= 1.0d) {
            return 1.0d;
        }
        double d10 = 0.5d;
        double d11 = 0.5d;
        while (d10 > 0.01d) {
            d10 *= 0.5d;
            d11 = m7430d(d11) < d ? d11 + d10 : d11 - d10;
        }
        double d12 = d11 - d10;
        double dM7430d = m7430d(d12);
        double d13 = d11 + d10;
        double dM7430d2 = m7430d(d13);
        double dM7431e = m7431e(d12);
        return (((d - dM7430d) * (m7431e(d13) - dM7431e)) / (dM7430d2 - dM7430d)) + dM7431e;
    }

    @Override
    public final double mo7429b(double d) {
        double d10 = 0.5d;
        double d11 = 0.5d;
        while (d10 > 1.0E-4d) {
            d10 *= 0.5d;
            d11 = m7430d(d11) < d ? d11 + d10 : d11 - d10;
        }
        double d12 = d11 - d10;
        double d13 = d11 + d10;
        return (m7431e(d13) - m7431e(d12)) / (m7430d(d13) - m7430d(d12));
    }

    public final double m7430d(double d) {
        double d10 = 1.0d - d;
        double d11 = 3.0d * d10;
        double d12 = d10 * d11 * d;
        double d13 = d11 * d * d;
        return (this.f12319f * d13) + (this.f12317d * d12) + (d * d * d);
    }

    public final double m7431e(double d) {
        double d10 = 1.0d - d;
        double d11 = 3.0d * d10;
        double d12 = d10 * d11 * d;
        double d13 = d11 * d * d;
        return (this.f12320g * d13) + (this.f12318e * d12) + (d * d * d);
    }
}

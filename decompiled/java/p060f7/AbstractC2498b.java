package p060f7;

import com.bumptech.glide.AbstractC1465c;
import java.math.RoundingMode;
import p020b7.AbstractC1332b;
import p187r4.AbstractC3612b;

public abstract class AbstractC2498b {

    public static final int f8728a = 0;

    static {
        Math.log(2.0d);
    }

    public static boolean m5545a(double d) {
        return AbstractC3612b.m7253C(d) && (d == 0.0d || 52 - Long.numberOfTrailingZeros(AbstractC3612b.m7273t(d)) <= Math.getExponent(d));
    }

    public static boolean m5546b(double d) {
        if (d <= 0.0d || !AbstractC3612b.m7253C(d)) {
            return false;
        }
        long jM7273t = AbstractC3612b.m7273t(d);
        return (jM7273t & (jM7273t - 1)) == 0;
    }

    public static int m5547c(double d, RoundingMode roundingMode) {
        boolean zM5546b;
        boolean z7 = false;
        AbstractC1332b.m3214e("x must be positive and finite", d > 0.0d && AbstractC3612b.m7253C(d));
        int exponent = Math.getExponent(d);
        if (Math.getExponent(d) < -1022) {
            return m5547c(d * 4.503599627370496E15d, roundingMode) - 52;
        }
        switch (AbstractC2497a.f8727a[roundingMode.ordinal()]) {
            case 1:
                AbstractC1465c.m3469d(m5546b(d));
                if (z7) {
                    return exponent + 1;
                }
                return exponent;
            case 2:
                if (z7) {
                    return exponent + 1;
                }
                return exponent;
            case 3:
                z7 = !m5546b(d);
                if (z7) {
                    return exponent + 1;
                }
                return exponent;
            case 4:
                z7 = exponent < 0;
                zM5546b = m5546b(d);
                z7 &= !zM5546b;
                if (z7) {
                    return exponent + 1;
                }
                return exponent;
            case 5:
                z7 = exponent >= 0;
                zM5546b = m5546b(d);
                z7 &= !zM5546b;
                if (z7) {
                    return exponent + 1;
                }
                return exponent;
            case 6:
            case 7:
            case 8:
                double dLongBitsToDouble = Double.longBitsToDouble((Double.doubleToRawLongBits(d) & 4503599627370495L) | 4607182418800017408L);
                if (dLongBitsToDouble * dLongBitsToDouble > 2.0d) {
                    z7 = true;
                }
                if (z7) {
                    return exponent + 1;
                }
                return exponent;
            default:
                throw new AssertionError();
        }
    }
}

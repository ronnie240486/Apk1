package androidx.appcompat.app;

public final class C0161t0 {

    public static C0161t0 f442d;

    public int f443a;

    public long f444b;

    public long f445c;

    public void m465a(double d, double d10, long j10) {
        float f = (j10 - 946728000000L) / 8.64E7f;
        float f3 = (0.01720197f * f) + 6.24006f;
        double d11 = f3;
        double dSin = (Math.sin(f3 * 3.0f) * 5.236000106378924E-6d) + (Math.sin(2.0f * f3) * 3.4906598739326E-4d) + (Math.sin(d11) * 0.03341960161924362d) + d11 + 1.796593063d + 3.141592653589793d;
        double d12 = (-d10) / 360.0d;
        double dSin2 = (Math.sin(2.0d * dSin) * (-0.0069d)) + (Math.sin(d11) * 0.0053d) + ((double) (Math.round(((double) (f - 9.0E-4f)) - d12) + 9.0E-4f)) + d12;
        double dAsin = Math.asin(Math.sin(0.4092797040939331d) * Math.sin(dSin));
        double d13 = 0.01745329238474369d * d;
        double dSin3 = (Math.sin(-0.10471975803375244d) - (Math.sin(dAsin) * Math.sin(d13))) / (Math.cos(dAsin) * Math.cos(d13));
        if (dSin3 >= 1.0d) {
            this.f443a = 1;
            this.f444b = -1L;
            this.f445c = -1L;
        } else {
            if (dSin3 <= -1.0d) {
                this.f443a = 0;
                this.f444b = -1L;
                this.f445c = -1L;
                return;
            }
            double dAcos = (float) (Math.acos(dSin3) / 6.283185307179586d);
            this.f444b = Math.round((dSin2 + dAcos) * 8.64E7d) + 946728000000L;
            long jRound = Math.round((dSin2 - dAcos) * 8.64E7d) + 946728000000L;
            this.f445c = jRound;
            if (jRound >= j10 || this.f444b <= j10) {
                this.f443a = 1;
            } else {
                this.f443a = 0;
            }
        }
    }
}

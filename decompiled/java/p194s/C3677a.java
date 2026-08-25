package p194s;

public final class C3677a {

    public static final double[] f12293s = new double[91];

    public double[] f12294a;

    public double f12295b;

    public double f12296c;

    public double f12297d;

    public double f12298e;

    public double f12299f;

    public double f12300g;

    public double f12301h;

    public double f12302i;

    public double f12303j;

    public double f12304k;

    public double f12305l;

    public double f12306m;

    public double f12307n;

    public double f12308o;

    public double f12309p;

    public boolean f12310q;

    public boolean f12311r;

    public final double m7424a() {
        double d = this.f12303j * this.f12309p;
        double dHypot = this.f12307n / Math.hypot(d, (-this.f12304k) * this.f12308o);
        if (this.f12310q) {
            d = -d;
        }
        return d * dHypot;
    }

    public final double m7425b(double d) {
        double d10 = (d - this.f12296c) * this.f12302i;
        double d11 = this.f12299f;
        double d12 = this.f12298e;
        return ((d11 - d12) * d10) + d12;
    }

    public final double m7426c(double d) {
        double d10 = (d - this.f12296c) * this.f12302i;
        double d11 = this.f12301h;
        double d12 = this.f12300g;
        return ((d11 - d12) * d10) + d12;
    }

    public final void m7427d(double d) {
        double d10 = (this.f12310q ? this.f12297d - d : d - this.f12296c) * this.f12302i;
        double d11 = 0.0d;
        if (d10 > 0.0d) {
            d11 = 1.0d;
            if (d10 < 1.0d) {
                double[] dArr = this.f12294a;
                double length = d10 * ((double) (dArr.length - 1));
                int i6 = (int) length;
                double d12 = dArr[i6];
                d11 = ((dArr[i6 + 1] - d12) * (length - ((double) i6))) + d12;
            }
        }
        double d13 = d11 * 1.5707963267948966d;
        this.f12308o = Math.sin(d13);
        this.f12309p = Math.cos(d13);
    }
}

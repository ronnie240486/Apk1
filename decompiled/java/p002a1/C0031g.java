package p002a1;

public final class C0031g {

    public double f84a;

    public double f85b;

    public boolean f86c;

    public double f87d;

    public double f88e;

    public double f89f;

    public double f90g;

    public double f91h;

    public double f92i;

    public final C0029e f93j;

    public C0031g() {
        this.f84a = Math.sqrt(1500.0d);
        this.f85b = 0.5d;
        this.f86c = false;
        this.f92i = Double.MAX_VALUE;
        this.f93j = new C0029e();
    }

    public final C0029e m148a(double d, double d10, long j10) {
        double dCos;
        double dPow;
        if (!this.f86c) {
            if (this.f92i == Double.MAX_VALUE) {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
            double d11 = this.f85b;
            if (d11 > 1.0d) {
                double d12 = this.f84a;
                this.f89f = (Math.sqrt((d11 * d11) - 1.0d) * d12) + ((-d11) * d12);
                double d13 = this.f85b;
                double d14 = this.f84a;
                this.f90g = ((-d13) * d14) - (Math.sqrt((d13 * d13) - 1.0d) * d14);
            } else if (d11 >= 0.0d && d11 < 1.0d) {
                this.f91h = Math.sqrt(1.0d - (d11 * d11)) * this.f84a;
            }
            this.f86c = true;
        }
        double d15 = j10 / 1000.0d;
        double d16 = d - this.f92i;
        double d17 = this.f85b;
        if (d17 > 1.0d) {
            double d18 = this.f90g;
            double d19 = ((d18 * d16) - d10) / (d18 - this.f89f);
            double d20 = d16 - d19;
            dPow = (Math.pow(2.718281828459045d, this.f89f * d15) * d19) + (Math.pow(2.718281828459045d, d18 * d15) * d20);
            double d21 = this.f90g;
            double dPow2 = Math.pow(2.718281828459045d, d21 * d15) * d20 * d21;
            double d22 = this.f89f;
            dCos = (Math.pow(2.718281828459045d, d22 * d15) * d19 * d22) + dPow2;
        } else if (d17 == 1.0d) {
            double d23 = this.f84a;
            double d24 = (d23 * d16) + d10;
            double d25 = (d24 * d15) + d16;
            double dPow3 = Math.pow(2.718281828459045d, (-d23) * d15) * d25;
            double dPow4 = Math.pow(2.718281828459045d, (-this.f84a) * d15) * d25;
            double d26 = -this.f84a;
            dCos = (Math.pow(2.718281828459045d, d26 * d15) * d24) + (dPow4 * d26);
            dPow = dPow3;
        } else {
            double d27 = 1.0d / this.f91h;
            double d28 = this.f84a;
            double d29 = ((d17 * d28 * d16) + d10) * d27;
            double dSin = ((Math.sin(this.f91h * d15) * d29) + (Math.cos(this.f91h * d15) * d16)) * Math.pow(2.718281828459045d, (-d17) * d28 * d15);
            double d30 = this.f84a;
            double d31 = this.f85b;
            double d32 = (-d30) * dSin * d31;
            double dPow5 = Math.pow(2.718281828459045d, (-d31) * d30 * d15);
            double d33 = this.f91h;
            double dSin2 = Math.sin(d33 * d15) * (-d33) * d16;
            double d34 = this.f91h;
            dCos = (((Math.cos(d34 * d15) * d29 * d34) + dSin2) * dPow5) + d32;
            dPow = dSin;
        }
        float f = (float) (dPow + this.f92i);
        C0029e c0029e = this.f93j;
        c0029e.f63a = f;
        c0029e.f64b = (float) dCos;
        return c0029e;
    }

    public C0031g(float f) {
        this.f84a = Math.sqrt(1500.0d);
        this.f85b = 0.5d;
        this.f86c = false;
        this.f93j = new C0029e();
        this.f92i = f;
    }
}

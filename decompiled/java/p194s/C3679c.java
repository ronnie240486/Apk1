package p194s;

import p187r4.AbstractC3612b;

public final class C3679c extends AbstractC3612b {

    public double f12315c;

    public double[] f12316d;

    @Override
    public final double mo7275q(double d) {
        return this.f12316d[0];
    }

    @Override
    public final void mo7276r(double d, double[] dArr) {
        double[] dArr2 = this.f12316d;
        System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
    }

    @Override
    public final void mo7277s(double d, float[] fArr) {
        int i6 = 0;
        while (true) {
            double[] dArr = this.f12316d;
            if (i6 >= dArr.length) {
                return;
            }
            fArr[i6] = (float) dArr[i6];
            i6++;
        }
    }

    @Override
    public final double mo7278u(double d) {
        return 0.0d;
    }

    @Override
    public final void mo7279v(double d, double[] dArr) {
        for (int i6 = 0; i6 < this.f12316d.length; i6++) {
            dArr[i6] = 0.0d;
        }
    }

    @Override
    public final double[] mo7280w() {
        return new double[]{this.f12315c};
    }
}

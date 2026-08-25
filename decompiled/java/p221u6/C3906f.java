package p221u6;

public final class C3906f extends C3905e {

    public final float f13106c;

    public C3906f(float f) {
        super(0);
        this.f13106c = f - 0.001f;
    }

    @Override
    public final void mo4119g(float f, float f3, float f4, C3923w c3923w) {
        double d = this.f13106c;
        float fSqrt = (float) ((Math.sqrt(2.0d) * d) / 2.0d);
        float fSqrt2 = (float) Math.sqrt(Math.pow(d, 2.0d) - Math.pow(fSqrt, 2.0d));
        c3923w.m7836e(f3 - fSqrt, ((float) (-((Math.sqrt(2.0d) * d) - d))) + fSqrt2, 270.0f, 0.0f);
        c3923w.m7835d(f3, (float) (-((Math.sqrt(2.0d) * d) - d)));
        c3923w.m7835d(f3 + fSqrt, ((float) (-((Math.sqrt(2.0d) * d) - d))) + fSqrt2);
    }
}

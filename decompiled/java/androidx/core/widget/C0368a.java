package androidx.core.widget;

public final class C0368a {

    public int f1652a;

    public int f1653b;

    public float f1654c;

    public float f1655d;

    public long f1656e;

    public long f1657f;

    public long f1658g;

    public float f1659h;

    public int f1660i;

    public final float m1116a(long j10) {
        long j11 = this.f1656e;
        if (j10 < j11) {
            return 0.0f;
        }
        long j12 = this.f1658g;
        if (j12 < 0 || j10 < j12) {
            return ViewOnTouchListenerC0375h.m1130b((j10 - j11) / this.f1652a, 0.0f, 1.0f) * 0.5f;
        }
        float f = this.f1659h;
        return (ViewOnTouchListenerC0375h.m1130b((j10 - j12) / this.f1660i, 0.0f, 1.0f) * f) + (1.0f - f);
    }
}

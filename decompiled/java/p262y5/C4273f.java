package p262y5;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

public final class C4273f {

    public long f14479a;

    public TimeInterpolator f14481c = null;

    public int f14482d = 0;

    public int f14483e = 1;

    public long f14480b = 150;

    public C4273f(long j10) {
        this.f14479a = j10;
    }

    public final void m8321a(Animator animator) {
        animator.setStartDelay(this.f14479a);
        animator.setDuration(this.f14480b);
        animator.setInterpolator(m8322b());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(this.f14482d);
            valueAnimator.setRepeatMode(this.f14483e);
        }
    }

    public final TimeInterpolator m8322b() {
        TimeInterpolator timeInterpolator = this.f14481c;
        return timeInterpolator != null ? timeInterpolator : AbstractC4268a.f14470b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4273f)) {
            return false;
        }
        C4273f c4273f = (C4273f) obj;
        if (this.f14479a == c4273f.f14479a && this.f14480b == c4273f.f14480b && this.f14482d == c4273f.f14482d && this.f14483e == c4273f.f14483e) {
            return m8322b().getClass().equals(c4273f.m8322b().getClass());
        }
        return false;
    }

    public final int hashCode() {
        long j10 = this.f14479a;
        long j11 = this.f14480b;
        return ((((m8322b().getClass().hashCode() + (((((int) (j10 ^ (j10 >>> 32))) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31)) * 31) + this.f14482d) * 31) + this.f14483e;
    }

    public final String toString() {
        return "\n" + C4273f.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + this.f14479a + " duration: " + this.f14480b + " interpolator: " + m8322b().getClass() + " repeatCount: " + this.f14482d + " repeatMode: " + this.f14483e + "}\n";
    }
}

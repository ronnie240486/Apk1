package p064g;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import p073h.AbstractC2635a;
import p123l5.AbstractC2973a;

public final class C2576c extends AbstractC2973a {

    public final ObjectAnimator f8989r;

    public final boolean f8990s;

    public C2576c(AnimationDrawable animationDrawable, boolean z7, boolean z10) {
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        int i6 = z7 ? numberOfFrames - 1 : 0;
        int i10 = z7 ? 0 : numberOfFrames - 1;
        C2577d c2577d = new C2577d();
        int numberOfFrames2 = animationDrawable.getNumberOfFrames();
        c2577d.f8992b = numberOfFrames2;
        int[] iArr = c2577d.f8991a;
        if (iArr == null || iArr.length < numberOfFrames2) {
            c2577d.f8991a = new int[numberOfFrames2];
        }
        int[] iArr2 = c2577d.f8991a;
        int i11 = 0;
        for (int i12 = 0; i12 < numberOfFrames2; i12++) {
            int duration = animationDrawable.getDuration(z7 ? (numberOfFrames2 - i12) - 1 : i12);
            iArr2[i12] = duration;
            i11 += duration;
        }
        c2577d.f8993c = i11;
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i6, i10);
        AbstractC2635a.m5655a(objectAnimatorOfInt, true);
        objectAnimatorOfInt.setDuration(c2577d.f8993c);
        objectAnimatorOfInt.setInterpolator(c2577d);
        this.f8990s = z10;
        this.f8989r = objectAnimatorOfInt;
    }

    @Override
    public final void mo5570I() {
        this.f8989r.reverse();
    }

    @Override
    public final void mo5562S() {
        this.f8989r.start();
    }

    @Override
    public final void mo5563U() {
        this.f8989r.cancel();
    }

    @Override
    public final boolean mo5571f() {
        return this.f8990s;
    }
}

package p007a7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import p059f6.C2495d;
import p059f6.InterfaceC2496e;

public final class C0068e extends AnimatorListenerAdapter {

    public final int f193a;

    public final InterfaceC2496e f194b;

    public C0068e(InterfaceC2496e interfaceC2496e, int i6) {
        this.f193a = i6;
        this.f194b = interfaceC2496e;
    }

    @Override
    public final void onAnimationEnd(Animator animator) {
        switch (this.f193a) {
            case 0:
                InterfaceC2496e interfaceC2496e = this.f194b;
                C2495d revealInfo = interfaceC2496e.getRevealInfo();
                revealInfo.f8726c = Float.MAX_VALUE;
                interfaceC2496e.setRevealInfo(revealInfo);
                break;
            default:
                this.f194b.mo4165c();
                break;
        }
    }

    @Override
    public void onAnimationStart(Animator animator) {
        switch (this.f193a) {
            case 1:
                this.f194b.mo4167e();
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}

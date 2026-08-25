package org.bitspark.android.utils;

import android.animation.Animator;
import android.widget.TextView;
import com.nmmedit.protect.NativeUtil;

public final class C3332n implements Animator.AnimatorListener {

    public final TextView f11248a;

    static {
        NativeUtil.classesInit0(3);
    }

    public C3332n(TextView textView) {
        this.f11248a = textView;
    }

    @Override
    public final native void onAnimationCancel(Animator animator);

    @Override
    public final native void onAnimationEnd(Animator animator);

    @Override
    public final native void onAnimationRepeat(Animator animator);

    @Override
    public final native void onAnimationStart(Animator animator);
}

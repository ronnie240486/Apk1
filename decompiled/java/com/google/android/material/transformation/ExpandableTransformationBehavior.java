package com.google.android.material.transformation;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import p006a6.C0062a;

@Deprecated
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    public AnimatorSet f6952b;

    public ExpandableTransformationBehavior() {
    }

    @Override
    public void mo4413s(View view, View view2, boolean z7, boolean z10) {
        AnimatorSet animatorSet = this.f6952b;
        boolean z11 = animatorSet != null;
        if (z11) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSetMo4414t = mo4414t(view, view2, z7, z11);
        this.f6952b = animatorSetMo4414t;
        animatorSetMo4414t.addListener(new C0062a(1, this));
        this.f6952b.start();
        if (z10) {
            return;
        }
        this.f6952b.end();
    }

    public abstract AnimatorSet mo4414t(View view, View view2, boolean z7, boolean z10);

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

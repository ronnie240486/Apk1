package com.google.android.material.transformation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import p007a7.C0070g;
import p156o9.AbstractC3280d;
import p262y5.C4273f;

@Deprecated
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {

    public final C4273f f6959c;

    public final C4273f f6960d;

    public FabTransformationScrimBehavior() {
        this.f6959c = new C4273f(75L);
        this.f6960d = new C4273f(0L);
    }

    @Override
    public final boolean mo920b(View view, View view2) {
        return view2 instanceof FloatingActionButton;
    }

    @Override
    public final boolean mo936r(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return false;
    }

    @Override
    public final AnimatorSet mo4414t(View view, View view2, boolean z7, boolean z10) {
        ObjectAnimator objectAnimatorOfFloat;
        ArrayList arrayList = new ArrayList();
        new ArrayList();
        C4273f c4273f = z7 ? this.f6959c : this.f6960d;
        if (z7) {
            if (!z10) {
                view2.setAlpha(0.0f);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.ALPHA, 1.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.ALPHA, 0.0f);
        }
        c4273f.m8321a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        AnimatorSet animatorSet = new AnimatorSet();
        AbstractC3280d.m6605x(animatorSet, arrayList);
        animatorSet.addListener(new C0070g(view2, z7));
        return animatorSet;
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6959c = new C4273f(75L);
        this.f6960d = new C4273f(0L);
    }
}

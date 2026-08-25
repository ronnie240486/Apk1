package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.bumptech.glide.AbstractC1465c;
import p075h1.AbstractC2639a;
import p187r4.AbstractC3612b;

public class FadeAndShortSlide extends Visibility {

    public static final DecelerateInterpolator f2025d = new DecelerateInterpolator();

    public static final C0440a f2026e = new C0440a(0);

    public static final C0440a f2027f = new C0440a(1);

    public static final C0440a f2028g = new C0440a(2);

    public static final C0440a f2029h = new C0440a(3);

    public static final C0440a f2030i = new C0440a(4);

    public final AbstractC3612b f2031a;

    public Visibility f2032b;

    public final float f2033c;

    public FadeAndShortSlide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2032b = new Fade();
        this.f2033c = -1.0f;
        C0441b c0441b = new C0441b(this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC2639a.f9167k);
        int i6 = typedArrayObtainStyledAttributes.getInt(3, 8388611);
        if (i6 == 48) {
            this.f2031a = f2030i;
        } else if (i6 == 80) {
            this.f2031a = f2029h;
        } else if (i6 == 112) {
            this.f2031a = c0441b;
        } else if (i6 == 8388611) {
            this.f2031a = f2026e;
        } else if (i6 == 8388613) {
            this.f2031a = f2027f;
        } else {
            if (i6 != 8388615) {
                throw new IllegalArgumentException("Invalid slide direction");
            }
            this.f2031a = f2028g;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final float m1340a(ViewGroup viewGroup) {
        float f = this.f2033c;
        return f >= 0.0f ? f : viewGroup.getWidth() / 4;
    }

    @Override
    public final Transition addListener(Transition.TransitionListener transitionListener) {
        this.f2032b.addListener(transitionListener);
        return super.addListener(transitionListener);
    }

    public final float m1341b(ViewGroup viewGroup) {
        float f = this.f2033c;
        return f >= 0.0f ? f : viewGroup.getHeight() / 4;
    }

    @Override
    public final void captureEndValues(TransitionValues transitionValues) {
        this.f2032b.captureEndValues(transitionValues);
        super.captureEndValues(transitionValues);
        int[] iArr = new int[2];
        transitionValues.view.getLocationOnScreen(iArr);
        transitionValues.values.put("android:fadeAndShortSlideTransition:screenPosition", iArr);
    }

    @Override
    public final void captureStartValues(TransitionValues transitionValues) {
        this.f2032b.captureStartValues(transitionValues);
        super.captureStartValues(transitionValues);
        int[] iArr = new int[2];
        transitionValues.view.getLocationOnScreen(iArr);
        transitionValues.values.put("android:fadeAndShortSlideTransition:screenPosition", iArr);
    }

    @Override
    public final Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null || viewGroup == view) {
            return null;
        }
        int[] iArr = (int[]) transitionValues2.values.get("android:fadeAndShortSlideTransition:screenPosition");
        int i6 = iArr[0];
        int i10 = iArr[1];
        float translationX = view.getTranslationX();
        ObjectAnimator objectAnimatorM3471f = AbstractC1465c.m3471f(view, transitionValues2, i6, i10, this.f2031a.mo1343n(this, viewGroup, view, iArr), this.f2031a.mo1344o(this, viewGroup, view, iArr), translationX, view.getTranslationY(), f2025d, this);
        Animator animatorOnAppear = this.f2032b.onAppear(viewGroup, view, transitionValues, transitionValues2);
        if (objectAnimatorM3471f == null) {
            return animatorOnAppear;
        }
        if (animatorOnAppear == null) {
            return objectAnimatorM3471f;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorM3471f).with(animatorOnAppear);
        return animatorSet;
    }

    @Override
    public final Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || viewGroup == view) {
            return null;
        }
        int[] iArr = (int[]) transitionValues.values.get("android:fadeAndShortSlideTransition:screenPosition");
        ObjectAnimator objectAnimatorM3471f = AbstractC1465c.m3471f(view, transitionValues, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.f2031a.mo1343n(this, viewGroup, view, iArr), this.f2031a.mo1344o(this, viewGroup, view, iArr), f2025d, this);
        Animator animatorOnDisappear = this.f2032b.onDisappear(viewGroup, view, transitionValues, transitionValues2);
        if (objectAnimatorM3471f == null) {
            return animatorOnDisappear;
        }
        if (animatorOnDisappear == null) {
            return objectAnimatorM3471f;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorM3471f).with(animatorOnDisappear);
        return animatorSet;
    }

    @Override
    public final Transition removeListener(Transition.TransitionListener transitionListener) {
        this.f2032b.removeListener(transitionListener);
        return super.removeListener(transitionListener);
    }

    @Override
    public final void setEpicenterCallback(Transition.EpicenterCallback epicenterCallback) {
        this.f2032b.setEpicenterCallback(epicenterCallback);
        super.setEpicenterCallback(epicenterCallback);
    }

    @Override
    public final Transition clone() {
        FadeAndShortSlide fadeAndShortSlide = (FadeAndShortSlide) super.clone();
        fadeAndShortSlide.f2032b = (Visibility) this.f2032b.clone();
        return fadeAndShortSlide;
    }
}

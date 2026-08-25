package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import com.p2serv.android.p032ds.R;
import p075h1.AbstractC2639a;

class SlideKitkat extends Visibility {

    public static final DecelerateInterpolator f2034b = new DecelerateInterpolator();

    public static final AccelerateInterpolator f2035c = new AccelerateInterpolator();

    public static final C0442c f2036d = new C0442c(0);

    public static final C0443d f2037e = new C0443d(0);

    public static final C0442c f2038f = new C0442c(1);

    public static final C0443d f2039g = new C0443d(1);

    public static final C0442c f2040h = new C0442c(2);

    public static final C0442c f2041i = new C0442c(3);

    public final InterfaceC0444e f2042a;

    public SlideKitkat(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC2639a.f9167k);
        int i6 = typedArrayObtainStyledAttributes.getInt(3, 80);
        if (i6 == 3) {
            this.f2042a = f2036d;
        } else if (i6 == 5) {
            this.f2042a = f2038f;
        } else if (i6 == 48) {
            this.f2042a = f2037e;
        } else if (i6 == 80) {
            this.f2042a = f2039g;
        } else if (i6 == 8388611) {
            this.f2042a = f2040h;
        } else {
            if (i6 != 8388613) {
                throw new IllegalArgumentException("Invalid slide direction");
            }
            this.f2042a = f2041i;
        }
        long j10 = typedArrayObtainStyledAttributes.getInt(1, -1);
        if (j10 >= 0) {
            setDuration(j10);
        }
        long j11 = typedArrayObtainStyledAttributes.getInt(2, -1);
        if (j11 > 0) {
            setStartDelay(j11);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        if (resourceId > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static ObjectAnimator m1342a(View view, Property property, float f, float f3, float f4, TimeInterpolator timeInterpolator, int i6) {
        float[] fArr = (float[]) view.getTag(R.id.lb_slide_transition_value);
        if (fArr != null) {
            f = View.TRANSLATION_Y == property ? fArr[1] : fArr[0];
            view.setTag(R.id.lb_slide_transition_value, null);
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, f, f3);
        C0445f c0445f = new C0445f(view, property, f4, f3, i6);
        objectAnimatorOfFloat.addListener(c0445f);
        objectAnimatorOfFloat.addPauseListener(c0445f);
        objectAnimatorOfFloat.setInterpolator(timeInterpolator);
        return objectAnimatorOfFloat;
    }

    @Override
    public final Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i6, TransitionValues transitionValues2, int i10) {
        View view = transitionValues2 != null ? transitionValues2.view : null;
        if (view == null) {
            return null;
        }
        float fMo177j = this.f2042a.mo177j(view);
        return m1342a(view, this.f2042a.mo178l(), this.f2042a.mo1345h(view), fMo177j, fMo177j, f2034b, 0);
    }

    @Override
    public final Animator onDisappear(ViewGroup viewGroup, TransitionValues transitionValues, int i6, TransitionValues transitionValues2, int i10) {
        View view = transitionValues != null ? transitionValues.view : null;
        if (view == null) {
            return null;
        }
        float fMo177j = this.f2042a.mo177j(view);
        return m1342a(view, this.f2042a.mo178l(), fMo177j, this.f2042a.mo1345h(view), fMo177j, f2035c, 4);
    }
}

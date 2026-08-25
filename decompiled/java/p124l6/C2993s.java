package p124l6;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import p201s6.AbstractC3722c;
import p221u6.C3908h;
import p221u6.C3913m;
import p222u7.AbstractC3928d;

public final class C2993s extends AbstractC2991q {
    @Override
    public final float mo6059e() {
        return this.f10284v.getElevation();
    }

    @Override
    public final void mo6060f(Rect rect) {
        if (((FloatingActionButton) this.f10285w.f9501b).f6291k) {
            super.mo6060f(rect);
            return;
        }
        if (this.f10268f) {
            FloatingActionButton floatingActionButton = this.f10284v;
            int sizeDimension = floatingActionButton.getSizeDimension();
            int i6 = this.f10273k;
            if (sizeDimension < i6) {
                int sizeDimension2 = (i6 - floatingActionButton.getSizeDimension()) / 2;
                rect.set(sizeDimension2, sizeDimension2, sizeDimension2, sizeDimension2);
                return;
            }
        }
        rect.set(0, 0, 0, 0);
    }

    @Override
    public final void mo6061g(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i6) {
        Drawable layerDrawable;
        C3913m c3913m = this.f10263a;
        c3913m.getClass();
        C2992r c2992r = new C2992r(c3913m);
        this.f10264b = c2992r;
        c2992r.setTintList(colorStateList);
        if (mode != null) {
            this.f10264b.setTintMode(mode);
        }
        C3908h c3908h = this.f10264b;
        FloatingActionButton floatingActionButton = this.f10284v;
        c3908h.m7806k(floatingActionButton.getContext());
        if (i6 > 0) {
            Context context = floatingActionButton.getContext();
            C3913m c3913m2 = this.f10263a;
            c3913m2.getClass();
            C2977c c2977c = new C2977c(c3913m2);
            int iM7847i = AbstractC3928d.m7847i(context, R.color.design_fab_stroke_top_outer_color);
            int iM7847i2 = AbstractC3928d.m7847i(context, R.color.design_fab_stroke_top_inner_color);
            int iM7847i3 = AbstractC3928d.m7847i(context, R.color.design_fab_stroke_end_inner_color);
            int iM7847i4 = AbstractC3928d.m7847i(context, R.color.design_fab_stroke_end_outer_color);
            c2977c.f10208i = iM7847i;
            c2977c.f10209j = iM7847i2;
            c2977c.f10210k = iM7847i3;
            c2977c.f10211l = iM7847i4;
            float f = i6;
            if (c2977c.f10207h != f) {
                c2977c.f10207h = f;
                c2977c.f10201b.setStrokeWidth(f * 1.3333f);
                c2977c.f10213n = true;
                c2977c.invalidateSelf();
            }
            if (colorStateList != null) {
                c2977c.f10212m = colorStateList.getColorForState(c2977c.getState(), c2977c.f10212m);
            }
            c2977c.f10215p = colorStateList;
            c2977c.f10213n = true;
            c2977c.invalidateSelf();
            this.f10266d = c2977c;
            C2977c c2977c2 = this.f10266d;
            c2977c2.getClass();
            C3908h c3908h2 = this.f10264b;
            c3908h2.getClass();
            layerDrawable = new LayerDrawable(new Drawable[]{c2977c2, c3908h2});
        } else {
            this.f10266d = null;
            layerDrawable = this.f10264b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(AbstractC3722c.m7485b(colorStateList2), layerDrawable, null);
        this.f10265c = rippleDrawable;
        this.f10267e = rippleDrawable;
    }

    @Override
    public final void mo6063i() {
        m6072r();
    }

    @Override
    public final void mo6064j(int[] iArr) {
        if (Build.VERSION.SDK_INT == 21) {
            FloatingActionButton floatingActionButton = this.f10284v;
            if (!floatingActionButton.isEnabled()) {
                floatingActionButton.setElevation(0.0f);
                floatingActionButton.setTranslationZ(0.0f);
                return;
            }
            floatingActionButton.setElevation(this.f10270h);
            if (floatingActionButton.isPressed()) {
                floatingActionButton.setTranslationZ(this.f10272j);
            } else if (floatingActionButton.isFocused() || floatingActionButton.isHovered()) {
                floatingActionButton.setTranslationZ(this.f10271i);
            } else {
                floatingActionButton.setTranslationZ(0.0f);
            }
        }
    }

    @Override
    public final void mo6065k(float f, float f3, float f4) {
        int i6 = Build.VERSION.SDK_INT;
        FloatingActionButton floatingActionButton = this.f10284v;
        if (i6 == 21) {
            floatingActionButton.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(AbstractC2991q.f10255D, m6073s(f, f4));
            stateListAnimator.addState(AbstractC2991q.f10256E, m6073s(f, f3));
            stateListAnimator.addState(AbstractC2991q.f10257F, m6073s(f, f3));
            stateListAnimator.addState(AbstractC2991q.f10258G, m6073s(f, f3));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, "elevation", f).setDuration(0L));
            if (i6 >= 22 && i6 <= 24) {
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(AbstractC2991q.f10254C);
            stateListAnimator.addState(AbstractC2991q.f10259H, animatorSet);
            stateListAnimator.addState(AbstractC2991q.f10260I, m6073s(0.0f, 0.0f));
            floatingActionButton.setStateListAnimator(stateListAnimator);
        }
        if (mo6070p()) {
            m6072r();
        }
    }

    @Override
    public final void mo6068n(ColorStateList colorStateList) {
        Drawable drawable = this.f10265c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(AbstractC3722c.m7485b(colorStateList));
        } else {
            super.mo6068n(colorStateList);
        }
    }

    @Override
    public final boolean mo6070p() {
        return ((FloatingActionButton) this.f10285w.f9501b).f6291k || (this.f10268f && this.f10284v.getSizeDimension() < this.f10273k);
    }

    public final AnimatorSet m6073s(float f, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        float[] fArr = {f};
        FloatingActionButton floatingActionButton = this.f10284v;
        animatorSet.play(ObjectAnimator.ofFloat(floatingActionButton, "elevation", fArr).setDuration(0L)).with(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f3).setDuration(100L));
        animatorSet.setInterpolator(AbstractC2991q.f10254C);
        return animatorSet;
    }

    @Override
    public final void mo6062h() {
    }

    @Override
    public final void mo6071q() {
    }
}

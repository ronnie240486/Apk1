package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.C0311c;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p007a7.C0065b;
import p007a7.C0066c;
import p007a7.C0067d;
import p007a7.C0068e;
import p007a7.C0069f;
import p059f6.C2494c;
import p059f6.C2495d;
import p059f6.InterfaceC2496e;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3155s0;
import p156o9.AbstractC3280d;
import p156o9.AbstractC3281e;
import p160p.C3347k;
import p222u7.AbstractC3928d;
import p262y5.AbstractC4268a;
import p262y5.C4269b;
import p262y5.C4270c;
import p262y5.C4271d;
import p262y5.C4272e;
import p262y5.C4273f;
import p262y5.C4274g;

@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    public final Rect f6953c;

    public final RectF f6954d;

    public final RectF f6955e;

    public final int[] f6956f;

    public float f6957g;

    public float f6958h;

    public FabTransformationBehavior() {
        this.f6953c = new Rect();
        this.f6954d = new RectF();
        this.f6955e = new RectF();
        this.f6956f = new int[2];
    }

    public static Pair m4415u(float f, float f3, boolean z7, C0069f c0069f) {
        C4273f c4273fM8318f;
        C4273f c4273fM8318f2;
        if (f == 0.0f || f3 == 0.0f) {
            c4273fM8318f = ((C4272e) c0069f.f196b).m8318f("translationXLinear");
            c4273fM8318f2 = ((C4272e) c0069f.f196b).m8318f("translationYLinear");
        } else if ((!z7 || f3 >= 0.0f) && (z7 || f3 <= 0.0f)) {
            c4273fM8318f = ((C4272e) c0069f.f196b).m8318f("translationXCurveDownwards");
            c4273fM8318f2 = ((C4272e) c0069f.f196b).m8318f("translationYCurveDownwards");
        } else {
            c4273fM8318f = ((C4272e) c0069f.f196b).m8318f("translationXCurveUpwards");
            c4273fM8318f2 = ((C4272e) c0069f.f196b).m8318f("translationYCurveUpwards");
        }
        return new Pair(c4273fM8318f, c4273fM8318f2);
    }

    public static float m4416x(C0069f c0069f, C4273f c4273f, float f) {
        long j10 = c4273f.f14479a;
        C4273f c4273fM8318f = ((C4272e) c0069f.f196b).m8318f("expansion");
        return AbstractC4268a.m8309a(f, 0.0f, c4273f.m8322b().getInterpolation((((c4273fM8318f.f14479a + c4273fM8318f.f14480b) + 17) - j10) / c4273f.f14480b));
    }

    @Override
    public final boolean mo920b(View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    @Override
    public final void mo921c(C0311c c0311c) {
        if (c0311c.f1449h == 0) {
            c0311c.f1449h = 80;
        }
    }

    @Override
    public final AnimatorSet mo4414t(View view, View view2, boolean z7, boolean z10) {
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        ObjectAnimator objectAnimatorOfFloat3;
        ArrayList arrayList;
        InterfaceC2496e interfaceC2496e;
        boolean z11;
        AnimatorSet animatorSetM6623m;
        boolean z12;
        ObjectAnimator objectAnimatorOfInt;
        ObjectAnimator objectAnimatorOfFloat4;
        int i6;
        ObjectAnimator objectAnimatorOfInt2;
        C0069f c0069fMo4420z = mo4420z(view2.getContext(), z7);
        if (z7) {
            this.f6957g = view.getTranslationX();
            this.f6958h = view.getTranslationY();
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        float fM6170i = AbstractC3119g0.m6170i(view2) - AbstractC3119g0.m6170i(view);
        if (z7) {
            if (!z10) {
                view2.setTranslationZ(-fM6170i);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -fM6170i);
        }
        ((C4272e) c0069fMo4420z.f196b).m8318f("elevation").m8321a(objectAnimatorOfFloat);
        arrayList2.add(objectAnimatorOfFloat);
        RectF rectF = this.f6954d;
        float fM4417v = m4417v(view, view2, (C4274g) c0069fMo4420z.f197c);
        float fM4418w = m4418w(view, view2, (C4274g) c0069fMo4420z.f197c);
        Pair pairM4415u = m4415u(fM4417v, fM4418w, z7, c0069fMo4420z);
        C4273f c4273f = (C4273f) pairM4415u.first;
        C4273f c4273f2 = (C4273f) pairM4415u.second;
        RectF rectF2 = this.f6955e;
        Rect rect = this.f6953c;
        if (z7) {
            if (!z10) {
                view2.setTranslationX(-fM4417v);
                view2.setTranslationY(-fM4418w);
            }
            ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            float fM4416x = m4416x(c0069fMo4420z, c4273f, -fM4417v);
            float fM4416x2 = m4416x(c0069fMo4420z, c4273f2, -fM4418w);
            view2.getWindowVisibleDisplayFrame(rect);
            rectF.set(rect);
            m4419y(view2, rectF2);
            rectF2.offset(fM4416x, fM4416x2);
            rectF2.intersect(rectF);
            rectF.set(rectF2);
            objectAnimatorOfFloat3 = objectAnimatorOfFloat6;
            objectAnimatorOfFloat2 = objectAnimatorOfFloat5;
        } else {
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -fM4417v);
            objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -fM4418w);
        }
        c4273f.m8321a(objectAnimatorOfFloat2);
        c4273f2.m8321a(objectAnimatorOfFloat3);
        arrayList2.add(objectAnimatorOfFloat2);
        arrayList2.add(objectAnimatorOfFloat3);
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        float fM4417v2 = m4417v(view, view2, (C4274g) c0069fMo4420z.f197c);
        float fM4418w2 = m4418w(view, view2, (C4274g) c0069fMo4420z.f197c);
        Pair pairM4415u2 = m4415u(fM4417v2, fM4418w2, z7, c0069fMo4420z);
        C4273f c4273f3 = (C4273f) pairM4415u2.first;
        C4273f c4273f4 = (C4273f) pairM4415u2.second;
        Property property = View.TRANSLATION_X;
        if (!z7) {
            fM4417v2 = this.f6957g;
        }
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fM4417v2);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, z7 ? fM4418w2 : this.f6958h);
        c4273f3.m8321a(objectAnimatorOfFloat7);
        c4273f4.m8321a(objectAnimatorOfFloat8);
        arrayList2.add(objectAnimatorOfFloat7);
        arrayList2.add(objectAnimatorOfFloat8);
        boolean z13 = view2 instanceof InterfaceC2496e;
        if (z13 && (view instanceof ImageView)) {
            InterfaceC2496e interfaceC2496e2 = (InterfaceC2496e) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                arrayList = arrayList3;
            } else {
                drawable.mutate();
                if (z7) {
                    if (!z10) {
                        drawable.setAlpha(255);
                    }
                    i6 = 0;
                    objectAnimatorOfInt2 = ObjectAnimator.ofInt(drawable, C4271d.f14476a, 0);
                } else {
                    i6 = 0;
                    objectAnimatorOfInt2 = ObjectAnimator.ofInt(drawable, C4271d.f14476a, 255);
                }
                objectAnimatorOfInt2.addUpdateListener(new C0066c(i6, view2));
                ((C4272e) c0069fMo4420z.f196b).m8318f("iconFade").m8321a(objectAnimatorOfInt2);
                arrayList2.add(objectAnimatorOfInt2);
                C0067d c0067d = new C0067d(interfaceC2496e2, i6, drawable);
                arrayList = arrayList3;
                arrayList.add(c0067d);
            }
        } else {
            arrayList = arrayList3;
        }
        if (z13) {
            InterfaceC2496e interfaceC2496e3 = (InterfaceC2496e) view2;
            C4274g c4274g = (C4274g) c0069fMo4420z.f197c;
            m4419y(view, rectF);
            rectF.offset(this.f6957g, this.f6958h);
            m4419y(view2, rectF2);
            rectF2.offset(-m4417v(view, view2, c4274g), 0.0f);
            float fCenterX = rectF.centerX() - rectF2.left;
            C4274g c4274g2 = (C4274g) c0069fMo4420z.f197c;
            m4419y(view, rectF);
            rectF.offset(this.f6957g, this.f6958h);
            m4419y(view2, rectF2);
            rectF2.offset(0.0f, -m4418w(view, view2, c4274g2));
            float fCenterY = rectF.centerY() - rectF2.top;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (floatingActionButton.isLaidOut()) {
                rect.set(0, 0, floatingActionButton.getWidth(), floatingActionButton.getHeight());
                floatingActionButton.m4227j(rect);
            }
            float fWidth2 = rect.width() / 2.0f;
            C4273f c4273fM8318f = ((C4272e) c0069fMo4420z.f196b).m8318f("expansion");
            if (z7) {
                if (!z10) {
                    interfaceC2496e3.setRevealInfo(new C2495d(fCenterX, fCenterY, fWidth2));
                }
                if (z10) {
                    fWidth2 = interfaceC2496e3.getRevealInfo().f8726c;
                }
                animatorSetM6623m = AbstractC3281e.m6623m(interfaceC2496e3, fCenterX, fCenterY, AbstractC3928d.m7846g(fCenterX, fCenterY, fWidth, fHeight));
                animatorSetM6623m.addListener(new C0068e(interfaceC2496e3, 0));
                long j10 = c4273fM8318f.f14479a;
                int i10 = (int) fCenterX;
                int i11 = (int) fCenterY;
                if (j10 > 0) {
                    Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view2, i10, i11, fWidth2, fWidth2);
                    animatorCreateCircularReveal.setStartDelay(0L);
                    animatorCreateCircularReveal.setDuration(j10);
                    arrayList2.add(animatorCreateCircularReveal);
                }
                z11 = z13;
                interfaceC2496e = interfaceC2496e3;
            } else {
                float f = interfaceC2496e3.getRevealInfo().f8726c;
                AnimatorSet animatorSetM6623m2 = AbstractC3281e.m6623m(interfaceC2496e3, fCenterX, fCenterY, fWidth2);
                long j11 = c4273fM8318f.f14479a;
                int i12 = (int) fCenterX;
                int i13 = (int) fCenterY;
                boolean z14 = z13;
                long jMax = 0;
                if (j11 > 0) {
                    Animator animatorCreateCircularReveal2 = ViewAnimationUtils.createCircularReveal(view2, i12, i13, f, f);
                    animatorCreateCircularReveal2.setStartDelay(0L);
                    animatorCreateCircularReveal2.setDuration(j11);
                    arrayList2.add(animatorCreateCircularReveal2);
                }
                C3347k c3347k = ((C4272e) c0069fMo4420z.f196b).f14477a;
                int i14 = c3347k.f11334c;
                int i15 = 0;
                while (i15 < i14) {
                    C3347k c3347k2 = c3347k;
                    C4273f c4273f5 = (C4273f) c3347k.m6816j(i15);
                    jMax = Math.max(jMax, c4273f5.f14479a + c4273f5.f14480b);
                    i15++;
                    animatorSetM6623m2 = animatorSetM6623m2;
                    c3347k = c3347k2;
                    i14 = i14;
                    interfaceC2496e3 = interfaceC2496e3;
                    z14 = z14;
                }
                interfaceC2496e = interfaceC2496e3;
                z11 = z14;
                AnimatorSet animatorSet = animatorSetM6623m2;
                long j12 = c4273fM8318f.f14479a + c4273fM8318f.f14480b;
                if (j12 < jMax) {
                    Animator animatorCreateCircularReveal3 = ViewAnimationUtils.createCircularReveal(view2, i12, i13, fWidth2, fWidth2);
                    animatorCreateCircularReveal3.setStartDelay(j12);
                    animatorCreateCircularReveal3.setDuration(jMax - j12);
                    arrayList2.add(animatorCreateCircularReveal3);
                }
                animatorSetM6623m = animatorSet;
            }
            c4273fM8318f.m8321a(animatorSetM6623m);
            arrayList2.add(animatorSetM6623m);
            arrayList.add(new C0068e(interfaceC2496e, 1));
        } else {
            z11 = z13;
        }
        if (z11) {
            InterfaceC2496e interfaceC2496e4 = (InterfaceC2496e) view2;
            WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
            ColorStateList colorStateListM6168g = AbstractC3119g0.m6168g(view);
            int colorForState = colorStateListM6168g != null ? colorStateListM6168g.getColorForState(view.getDrawableState(), colorStateListM6168g.getDefaultColor()) : 0;
            int i16 = 16777215 & colorForState;
            z12 = z7;
            if (z12) {
                if (!z10) {
                    interfaceC2496e4.setCircularRevealScrimColor(colorForState);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(interfaceC2496e4, C2494c.f8723a, i16);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(interfaceC2496e4, C2494c.f8723a, colorForState);
            }
            objectAnimatorOfInt.setEvaluator(C4269b.f14474a);
            ((C4272e) c0069fMo4420z.f196b).m8318f(TtmlNode.ATTR_TTS_COLOR).m8321a(objectAnimatorOfInt);
            arrayList2.add(objectAnimatorOfInt);
        } else {
            z12 = z7;
        }
        if (view2 instanceof ViewGroup) {
            boolean z15 = view2 instanceof InterfaceC2496e;
            View viewFindViewById = view2.findViewById(R.id.mtrl_child_content_container);
            ViewGroup viewGroup = null;
            if (viewFindViewById != null) {
                if (viewFindViewById instanceof ViewGroup) {
                    viewGroup = (ViewGroup) viewFindViewById;
                }
            } else if ((view2 instanceof TransformationChildLayout) || (view2 instanceof TransformationChildCard)) {
                View childAt = ((ViewGroup) view2).getChildAt(0);
                if (childAt instanceof ViewGroup) {
                    viewGroup = (ViewGroup) childAt;
                }
            } else {
                viewGroup = (ViewGroup) view2;
            }
            if (viewGroup != null) {
                if (z12) {
                    if (!z10) {
                        C4270c.f14475a.set(viewGroup, Float.valueOf(0.0f));
                    }
                    objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(viewGroup, C4270c.f14475a, 1.0f);
                } else {
                    objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(viewGroup, C4270c.f14475a, 0.0f);
                }
                ((C4272e) c0069fMo4420z.f196b).m8318f("contentFade").m8321a(objectAnimatorOfFloat4);
                arrayList2.add(objectAnimatorOfFloat4);
            }
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        AbstractC3280d.m6605x(animatorSet2, arrayList2);
        animatorSet2.addListener(new C0065b(z12, view2, view));
        int size = arrayList.size();
        for (int i17 = 0; i17 < size; i17++) {
            animatorSet2.addListener((Animator.AnimatorListener) arrayList.get(i17));
        }
        return animatorSet2;
    }

    public final float m4417v(View view, View view2, C4274g c4274g) {
        RectF rectF = this.f6954d;
        RectF rectF2 = this.f6955e;
        m4419y(view, rectF);
        rectF.offset(this.f6957g, this.f6958h);
        m4419y(view2, rectF2);
        c4274g.getClass();
        return (rectF2.centerX() - rectF.centerX()) + 0.0f;
    }

    public final float m4418w(View view, View view2, C4274g c4274g) {
        RectF rectF = this.f6954d;
        RectF rectF2 = this.f6955e;
        m4419y(view, rectF);
        rectF.offset(this.f6957g, this.f6958h);
        m4419y(view2, rectF2);
        c4274g.getClass();
        return (rectF2.centerY() - rectF.centerY()) + 0.0f;
    }

    public final void m4419y(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        int[] iArr = this.f6956f;
        view.getLocationInWindow(iArr);
        rectF.offsetTo(iArr[0], iArr[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    public abstract C0069f mo4420z(Context context, boolean z7);

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6953c = new Rect();
        this.f6954d = new RectF();
        this.f6955e = new RectF();
        this.f6956f = new int[2];
    }
}

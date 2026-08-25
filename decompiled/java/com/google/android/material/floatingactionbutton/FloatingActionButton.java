package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.appcompat.widget.C0172a;
import androidx.appcompat.widget.C0285w;
import androidx.appcompat.widget.C0300z;
import androidx.coordinatorlayout.widget.C0311c;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.InterfaceC0309a;
import com.bumptech.glide.AbstractC1466d;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomappbar.C1759a;
import com.google.android.material.bottomappbar.C1760b;
import com.google.android.material.bottomappbar.C1761c;
import com.google.android.material.bottomappbar.C1762d;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.AbstractC1811a0;
import com.google.android.material.internal.AbstractC1818e;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.stateful.ExtendableSavedState;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import p001a0.ViewTreeObserverOnPreDrawListenerC0021d;
import p007a7.C0065b;
import p101j7.C2782c;
import p112k6.InterfaceC2893a;
import p124l6.AbstractC2991q;
import p124l6.C2977c;
import p124l6.C2982h;
import p124l6.C2983i;
import p124l6.C2984j;
import p124l6.C2993s;
import p138n0.AbstractC3155s0;
import p143n5.AbstractC3198d;
import p156o9.AbstractC3280d;
import p156o9.AbstractC3281e;
import p160p.C3347k;
import p221u6.C3908h;
import p221u6.C3913m;
import p221u6.InterfaceC3924x;
import p250x5.AbstractC4121a;
import p262y5.C4272e;
import p263y6.AbstractC4275a;

public class FloatingActionButton extends VisibilityAwareImageButton implements InterfaceC2893a, InterfaceC3924x, InterfaceC0309a {

    public ColorStateList f6282b;

    public PorterDuff.Mode f6283c;

    public ColorStateList f6284d;

    public PorterDuff.Mode f6285e;

    public ColorStateList f6286f;

    public int f6287g;

    public int f6288h;

    public int f6289i;

    public int f6290j;

    public boolean f6291k;

    public final Rect f6292l;

    public final Rect f6293m;

    public final C0300z f6294n;

    public final C0172a f6295o;

    public C2993s f6296p;

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.floatingActionButtonStyle);
    }

    private AbstractC2991q getImpl() {
        if (this.f6296p == null) {
            this.f6296p = new C2993s(this, new C2782c(9, this));
        }
        return this.f6296p;
    }

    public static int m4219l(int i6, int i10) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i6, size);
        }
        if (mode == 0) {
            return i6;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }

    public final void m4220c(AnimatorListenerAdapter animatorListenerAdapter) {
        AbstractC2991q impl = getImpl();
        if (impl.f10282t == null) {
            impl.f10282t = new ArrayList();
        }
        impl.f10282t.add(animatorListenerAdapter);
    }

    public final void m4221d(C1759a c1759a) {
        AbstractC2991q impl = getImpl();
        if (impl.f10281s == null) {
            impl.f10281s = new ArrayList();
        }
        impl.f10281s.add(c1759a);
    }

    @Override
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().mo6064j(getDrawableState());
    }

    public final void m4222e(C1760b c1760b) {
        AbstractC2991q impl = getImpl();
        C2983i c2983i = new C2983i(this, c1760b);
        if (impl.f10283u == null) {
            impl.f10283u = new ArrayList();
        }
        impl.f10283u.add(c2983i);
    }

    public final int m4223f(int i6) {
        int i10 = this.f6288h;
        if (i10 != 0) {
            return i10;
        }
        Resources resources = getResources();
        if (i6 != -1) {
            return i6 != 1 ? resources.getDimensionPixelSize(R.dimen.design_fab_size_normal) : resources.getDimensionPixelSize(R.dimen.design_fab_size_mini);
        }
        return Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? m4223f(1) : m4223f(0);
    }

    public final void m4224g(C1762d c1762d, boolean z7) {
        AbstractC2991q impl = getImpl();
        C2982h c2982h = c1762d == null ? null : new C2982h(this, 0, c1762d);
        if (impl.f10284v.getVisibility() == 0) {
            if (impl.f10280r == 1) {
                return;
            }
        } else if (impl.f10280r != 2) {
            return;
        }
        Animator animator = impl.f10274l;
        if (animator != null) {
            animator.cancel();
        }
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        FloatingActionButton floatingActionButton = impl.f10284v;
        if (!floatingActionButton.isLaidOut() || floatingActionButton.isInEditMode()) {
            floatingActionButton.m4235a(z7 ? 8 : 4, z7);
            if (c2982h != null) {
                ((AbstractC3281e) c2982h.f10225b).mo4118D((FloatingActionButton) c2982h.f10226c);
                return;
            }
            return;
        }
        C4272e c4272e = impl.f10276n;
        AnimatorSet animatorSetM6057b = c4272e != null ? impl.m6057b(c4272e, 0.0f, 0.0f, 0.0f) : impl.m6058c(0.0f, 0.4f, 0.4f);
        animatorSetM6057b.addListener(new C2984j(impl, z7, c2982h));
        ArrayList arrayList = impl.f10282t;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetM6057b.addListener((Animator.AnimatorListener) it.next());
            }
        }
        animatorSetM6057b.start();
    }

    @Override
    public ColorStateList getBackgroundTintList() {
        return this.f6282b;
    }

    @Override
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f6283c;
    }

    @Override
    public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().mo6059e();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().f10271i;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().f10272j;
    }

    public Drawable getContentBackground() {
        return getImpl().f10267e;
    }

    public int getCustomSize() {
        return this.f6288h;
    }

    public int getExpandedComponentIdHint() {
        return this.f6295o.f861b;
    }

    public C4272e getHideMotionSpec() {
        return getImpl().f10276n;
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f6286f;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f6286f;
    }

    public C3913m getShapeAppearanceModel() {
        C3913m c3913m = getImpl().f10263a;
        c3913m.getClass();
        return c3913m;
    }

    public C4272e getShowMotionSpec() {
        return getImpl().f10275m;
    }

    public int getSize() {
        return this.f6287g;
    }

    public int getSizeDimension() {
        return m4223f(this.f6287g);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.f6284d;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f6285e;
    }

    public boolean getUseCompatPadding() {
        return this.f6291k;
    }

    public final boolean m4225h() {
        AbstractC2991q impl = getImpl();
        if (impl.f10284v.getVisibility() == 0) {
            if (impl.f10280r != 1) {
                return false;
            }
        } else if (impl.f10280r == 2) {
            return false;
        }
        return true;
    }

    public final boolean m4226i() {
        AbstractC2991q impl = getImpl();
        if (impl.f10284v.getVisibility() != 0) {
            if (impl.f10280r != 2) {
                return false;
            }
        } else if (impl.f10280r == 1) {
            return false;
        }
        return true;
    }

    public final void m4227j(Rect rect) {
        int i6 = rect.left;
        Rect rect2 = this.f6292l;
        rect.left = i6 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    @Override
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().mo6062h();
    }

    public final void m4228k() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f6284d;
        if (colorStateList == null) {
            AbstractC3198d.m6452a(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f6285e;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(C0285w.m802c(colorForState, mode));
    }

    public final void m4229m(C1761c c1761c, boolean z7) {
        int i6 = 0;
        AbstractC2991q impl = getImpl();
        C2982h c2982h = c1761c == null ? null : new C2982h(this, i6, c1761c);
        if (impl.f10284v.getVisibility() != 0) {
            if (impl.f10280r == 2) {
                return;
            }
        } else if (impl.f10280r != 1) {
            return;
        }
        Animator animator = impl.f10274l;
        if (animator != null) {
            animator.cancel();
        }
        boolean z10 = impl.f10275m == null;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        FloatingActionButton floatingActionButton = impl.f10284v;
        boolean z11 = floatingActionButton.isLaidOut() && !floatingActionButton.isInEditMode();
        Matrix matrix = impl.f10261A;
        if (!z11) {
            floatingActionButton.m4235a(0, z7);
            floatingActionButton.setAlpha(1.0f);
            floatingActionButton.setScaleY(1.0f);
            floatingActionButton.setScaleX(1.0f);
            impl.f10278p = 1.0f;
            impl.m6056a(1.0f, matrix);
            floatingActionButton.setImageMatrix(matrix);
            if (c2982h != null) {
                ((AbstractC3281e) c2982h.f10225b).mo4117E();
                return;
            }
            return;
        }
        if (floatingActionButton.getVisibility() != 0) {
            floatingActionButton.setAlpha(0.0f);
            floatingActionButton.setScaleY(z10 ? 0.4f : 0.0f);
            floatingActionButton.setScaleX(z10 ? 0.4f : 0.0f);
            float f = z10 ? 0.4f : 0.0f;
            impl.f10278p = f;
            impl.m6056a(f, matrix);
            floatingActionButton.setImageMatrix(matrix);
        }
        C4272e c4272e = impl.f10275m;
        AnimatorSet animatorSetM6057b = c4272e != null ? impl.m6057b(c4272e, 1.0f, 1.0f, 1.0f) : impl.m6058c(1.0f, 1.0f, 1.0f);
        animatorSetM6057b.addListener(new C0065b(impl, z7, c2982h));
        ArrayList arrayList = impl.f10281s;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetM6057b.addListener((Animator.AnimatorListener) it.next());
            }
        }
        animatorSetM6057b.start();
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC2991q impl = getImpl();
        C3908h c3908h = impl.f10264b;
        FloatingActionButton floatingActionButton = impl.f10284v;
        if (c3908h != null) {
            AbstractC3280d.m6567D(floatingActionButton, c3908h);
        }
        if (impl instanceof C2993s) {
            return;
        }
        ViewTreeObserver viewTreeObserver = floatingActionButton.getViewTreeObserver();
        if (impl.f10262B == null) {
            impl.f10262B = new ViewTreeObserverOnPreDrawListenerC0021d(1, impl);
        }
        viewTreeObserver.addOnPreDrawListener(impl.f10262B);
    }

    @Override
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AbstractC2991q impl = getImpl();
        ViewTreeObserver viewTreeObserver = impl.f10284v.getViewTreeObserver();
        ViewTreeObserverOnPreDrawListenerC0021d viewTreeObserverOnPreDrawListenerC0021d = impl.f10262B;
        if (viewTreeObserverOnPreDrawListenerC0021d != null) {
            viewTreeObserver.removeOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0021d);
            impl.f10262B = null;
        }
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        int sizeDimension = getSizeDimension();
        this.f6289i = (sizeDimension - this.f6290j) / 2;
        getImpl().m6072r();
        int iMin = Math.min(m4219l(sizeDimension, i6), m4219l(sizeDimension, i10));
        Rect rect = this.f6292l;
        setMeasuredDimension(rect.left + iMin + rect.right, iMin + rect.top + rect.bottom);
    }

    @Override
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.f1689a);
        Object obj = extendableSavedState.f6680c.get("expandableWidgetHelper");
        obj.getClass();
        Bundle bundle = (Bundle) obj;
        C0172a c0172a = this.f6295o;
        c0172a.getClass();
        c0172a.f860a = bundle.getBoolean("expanded", false);
        c0172a.f861b = bundle.getInt("expandedComponentIdHint", 0);
        if (c0172a.f860a) {
            View view = c0172a.f862c;
            ViewParent parent = view.getParent();
            if (parent instanceof CoordinatorLayout) {
                ((CoordinatorLayout) parent).m907m(view);
            }
        }
    }

    @Override
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(parcelableOnSaveInstanceState);
        C3347k c3347k = extendableSavedState.f6680c;
        C0172a c0172a = this.f6295o;
        c0172a.getClass();
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", c0172a.f860a);
        bundle.putInt("expandedComponentIdHint", c0172a.f861b);
        c3347k.put("expandableWidgetHelper", bundle);
        return extendableSavedState;
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            if (isLaidOut()) {
                int width = getWidth();
                int height = getHeight();
                Rect rect = this.f6293m;
                rect.set(0, 0, width, height);
                m4227j(rect);
                if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    return false;
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override
    public void setBackgroundColor(int i6) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override
    public void setBackgroundResource(int i6) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f6282b != colorStateList) {
            this.f6282b = colorStateList;
            AbstractC2991q impl = getImpl();
            C3908h c3908h = impl.f10264b;
            if (c3908h != null) {
                c3908h.setTintList(colorStateList);
            }
            C2977c c2977c = impl.f10266d;
            if (c2977c != null) {
                if (colorStateList != null) {
                    c2977c.f10212m = colorStateList.getColorForState(c2977c.getState(), c2977c.f10212m);
                }
                c2977c.f10215p = colorStateList;
                c2977c.f10213n = true;
                c2977c.invalidateSelf();
            }
        }
    }

    @Override
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f6283c != mode) {
            this.f6283c = mode;
            C3908h c3908h = getImpl().f10264b;
            if (c3908h != null) {
                c3908h.setTintMode(mode);
            }
        }
    }

    public void setCompatElevation(float f) {
        AbstractC2991q impl = getImpl();
        if (impl.f10270h != f) {
            impl.f10270h = f;
            impl.mo6065k(f, impl.f10271i, impl.f10272j);
        }
    }

    public void setCompatElevationResource(int i6) {
        setCompatElevation(getResources().getDimension(i6));
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        AbstractC2991q impl = getImpl();
        if (impl.f10271i != f) {
            impl.f10271i = f;
            impl.mo6065k(impl.f10270h, f, impl.f10272j);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(int i6) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i6));
    }

    public void setCompatPressedTranslationZ(float f) {
        AbstractC2991q impl = getImpl();
        if (impl.f10272j != f) {
            impl.f10272j = f;
            impl.mo6065k(impl.f10270h, impl.f10271i, f);
        }
    }

    public void setCompatPressedTranslationZResource(int i6) {
        setCompatPressedTranslationZ(getResources().getDimension(i6));
    }

    public void setCustomSize(int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i6 != this.f6288h) {
            this.f6288h = i6;
            requestLayout();
        }
    }

    @Override
    public void setElevation(float f) {
        super.setElevation(f);
        C3908h c3908h = getImpl().f10264b;
        if (c3908h != null) {
            c3908h.m7808m(f);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z7) {
        if (z7 != getImpl().f10268f) {
            getImpl().f10268f = z7;
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i6) {
        this.f6295o.f861b = i6;
    }

    public void setHideMotionSpec(C4272e c4272e) {
        getImpl().f10276n = c4272e;
    }

    public void setHideMotionSpecResource(int i6) {
        setHideMotionSpec(C4272e.m8314b(getContext(), i6));
    }

    @Override
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            AbstractC2991q impl = getImpl();
            float f = impl.f10278p;
            impl.f10278p = f;
            Matrix matrix = impl.f10261A;
            impl.m6056a(f, matrix);
            impl.f10284v.setImageMatrix(matrix);
            if (this.f6284d != null) {
                m4228k();
            }
        }
    }

    @Override
    public void setImageResource(int i6) {
        this.f6294n.m839c(i6);
        m4228k();
    }

    public void setMaxImageSize(int i6) {
        this.f6290j = i6;
        AbstractC2991q impl = getImpl();
        if (impl.f10279q != i6) {
            impl.f10279q = i6;
            float f = impl.f10278p;
            impl.f10278p = f;
            Matrix matrix = impl.f10261A;
            impl.m6056a(f, matrix);
            impl.f10284v.setImageMatrix(matrix);
        }
    }

    public void setRippleColor(int i6) {
        setRippleColor(ColorStateList.valueOf(i6));
    }

    @Override
    public void setScaleX(float f) {
        super.setScaleX(f);
        getImpl().m6066l();
    }

    @Override
    public void setScaleY(float f) {
        super.setScaleY(f);
        getImpl().m6066l();
    }

    public void setShadowPaddingEnabled(boolean z7) {
        AbstractC2991q impl = getImpl();
        impl.f10269g = z7;
        impl.m6072r();
    }

    @Override
    public void setShapeAppearanceModel(C3913m c3913m) {
        getImpl().m6069o(c3913m);
    }

    public void setShowMotionSpec(C4272e c4272e) {
        getImpl().f10275m = c4272e;
    }

    public void setShowMotionSpecResource(int i6) {
        setShowMotionSpec(C4272e.m8314b(getContext(), i6));
    }

    public void setSize(int i6) {
        this.f6288h = 0;
        if (i6 != this.f6287g) {
            this.f6287g = i6;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f6284d != colorStateList) {
            this.f6284d = colorStateList;
            m4228k();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f6285e != mode) {
            this.f6285e = mode;
            m4228k();
        }
    }

    @Override
    public void setTranslationX(float f) {
        super.setTranslationX(f);
        getImpl().m6067m();
    }

    @Override
    public void setTranslationY(float f) {
        super.setTranslationY(f);
        getImpl().m6067m();
    }

    @Override
    public void setTranslationZ(float f) {
        super.setTranslationZ(f);
        getImpl().m6067m();
    }

    public void setUseCompatPadding(boolean z7) {
        if (this.f6291k != z7) {
            this.f6291k = z7;
            getImpl().mo6063i();
        }
    }

    @Override
    public void setVisibility(int i6) {
        super.setVisibility(i6);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i6) {
        super(AbstractC4275a.m8323a(context, attributeSet, i6, R.style.Widget_Design_FloatingActionButton), attributeSet, i6);
        this.f6292l = new Rect();
        this.f6293m = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayM4250j = AbstractC1811a0.m4250j(context2, attributeSet, AbstractC4121a.f14004r, i6, R.style.Widget_Design_FloatingActionButton, new int[0]);
        this.f6282b = AbstractC1466d.m3493k(context2, typedArrayM4250j, 1);
        this.f6283c = AbstractC1811a0.m4252l(typedArrayM4250j.getInt(2, -1), null);
        this.f6286f = AbstractC1466d.m3493k(context2, typedArrayM4250j, 12);
        this.f6287g = typedArrayM4250j.getInt(7, -1);
        this.f6288h = typedArrayM4250j.getDimensionPixelSize(6, 0);
        int dimensionPixelSize = typedArrayM4250j.getDimensionPixelSize(3, 0);
        float dimension = typedArrayM4250j.getDimension(4, 0.0f);
        float dimension2 = typedArrayM4250j.getDimension(9, 0.0f);
        float dimension3 = typedArrayM4250j.getDimension(11, 0.0f);
        this.f6291k = typedArrayM4250j.getBoolean(16, false);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.mtrl_fab_min_touch_target);
        setMaxImageSize(typedArrayM4250j.getDimensionPixelSize(10, 0));
        C4272e c4272eM8313a = C4272e.m8313a(context2, typedArrayM4250j, 15);
        C4272e c4272eM8313a2 = C4272e.m8313a(context2, typedArrayM4250j, 8);
        C3913m c3913mM7819a = C3913m.m7823c(context2, attributeSet, i6, R.style.Widget_Design_FloatingActionButton, C3913m.f13163m).m7819a();
        boolean z7 = typedArrayM4250j.getBoolean(5, false);
        setEnabled(typedArrayM4250j.getBoolean(0, true));
        typedArrayM4250j.recycle();
        C0300z c0300z = new C0300z(this);
        this.f6294n = c0300z;
        c0300z.m838b(attributeSet, i6);
        this.f6295o = new C0172a(this);
        getImpl().m6069o(c3913mM7819a);
        getImpl().mo6061g(this.f6282b, this.f6283c, this.f6286f, dimensionPixelSize);
        getImpl().f10273k = dimensionPixelSize2;
        AbstractC2991q impl = getImpl();
        if (impl.f10270h != dimension) {
            impl.f10270h = dimension;
            impl.mo6065k(dimension, impl.f10271i, impl.f10272j);
        }
        AbstractC2991q impl2 = getImpl();
        if (impl2.f10271i != dimension2) {
            impl2.f10271i = dimension2;
            impl2.mo6065k(impl2.f10270h, dimension2, impl2.f10272j);
        }
        AbstractC2991q impl3 = getImpl();
        if (impl3.f10272j != dimension3) {
            impl3.f10272j = dimension3;
            impl3.mo6065k(impl3.f10270h, impl3.f10271i, dimension3);
        }
        getImpl().f10275m = c4272eM8313a;
        getImpl().f10276n = c4272eM8313a2;
        getImpl().f10268f = z7;
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f6286f != colorStateList) {
            this.f6286f = colorStateList;
            getImpl().mo6068n(this.f6286f);
        }
    }

    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        public Rect f6297a;

        public final boolean f6298b;

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4121a.f14005s);
            this.f6298b = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override
        public final boolean mo919a(View view, Rect rect) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            int left = floatingActionButton.getLeft();
            Rect rect2 = floatingActionButton.f6292l;
            rect.set(left + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override
        public final void mo921c(C0311c c0311c) {
            if (c0311c.f1449h == 0) {
                c0311c.f1449h = 80;
            }
        }

        @Override
        public final boolean mo922d(CoordinatorLayout coordinatorLayout, View view, View view2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                m4230s(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof C0311c ? ((C0311c) layoutParams).f1442a instanceof BottomSheetBehavior : false) {
                    m4231t(view2, floatingActionButton);
                }
            }
            return false;
        }

        @Override
        public final boolean mo926h(CoordinatorLayout coordinatorLayout, View view, int i6) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            ArrayList arrayListM909o = coordinatorLayout.m909o(floatingActionButton);
            int size = arrayListM909o.size();
            int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                View view2 = (View) arrayListM909o.get(i11);
                if (!(view2 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof C0311c ? ((C0311c) layoutParams).f1442a instanceof BottomSheetBehavior : false) && m4231t(view2, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (m4230s(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.m914v(i6, floatingActionButton);
            Rect rect = floatingActionButton.f6292l;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return true;
            }
            C0311c c0311c = (C0311c) floatingActionButton.getLayoutParams();
            int i12 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) c0311c).rightMargin ? rect.right : floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) c0311c).leftMargin ? -rect.left : 0;
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) c0311c).bottomMargin) {
                i10 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) c0311c).topMargin) {
                i10 = -rect.top;
            }
            if (i10 != 0) {
                AbstractC3155s0.m6340j(i10, floatingActionButton);
            }
            if (i12 == 0) {
                return true;
            }
            AbstractC3155s0.m6339i(i12, floatingActionButton);
            return true;
        }

        public final boolean m4230s(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!(this.f6298b && ((C0311c) floatingActionButton.getLayoutParams()).f1447f == appBarLayout.getId() && floatingActionButton.getUserSetVisibility() == 0)) {
                return false;
            }
            if (this.f6297a == null) {
                this.f6297a = new Rect();
            }
            Rect rect = this.f6297a;
            AbstractC1818e.m4274a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.m4224g(null, false);
            } else {
                floatingActionButton.m4229m(null, false);
            }
            return true;
        }

        public final boolean m4231t(View view, FloatingActionButton floatingActionButton) {
            if (!(this.f6298b && ((C0311c) floatingActionButton.getLayoutParams()).f1447f == view.getId() && floatingActionButton.getUserSetVisibility() == 0)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((C0311c) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.m4224g(null, false);
            } else {
                floatingActionButton.m4229m(null, false);
            }
            return true;
        }

        public BaseBehavior() {
            this.f6298b = true;
        }
    }
}

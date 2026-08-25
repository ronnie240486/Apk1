package com.google.android.material.bottomappbar;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.C0311c;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.InterfaceC0309a;
import androidx.customview.view.AbsSavedState;
import com.bumptech.glide.AbstractC1466d;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.AbstractC1811a0;
import com.google.android.material.internal.C1813b0;
import com.p2serv.android.p032ds.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import p065g0.AbstractC2581a;
import p138n0.AbstractC3155s0;
import p143n5.AbstractC3198d;
import p156o9.AbstractC3280d;
import p160p.C3347k;
import p221u6.C3901a;
import p221u6.C3905e;
import p221u6.C3908h;
import p221u6.C3911k;
import p221u6.C3913m;
import p250x5.AbstractC4121a;
import p263y6.AbstractC4275a;

public class BottomAppBar extends Toolbar implements InterfaceC0309a {

    public static final int f5910r0 = 0;

    public Integer f5911U;

    public final int f5912V;

    public final C3908h f5913W;

    public AnimatorSet f5914b0;

    public AnimatorSet f5915c0;

    public int f5916d0;

    public int f5917e0;

    public boolean f5918f0;

    public final boolean f5919g0;

    public final boolean f5920h0;

    public final boolean f5921i0;

    public boolean f5922j0;

    public boolean f5923k0;

    public Behavior f5924l0;

    public int f5925m0;

    public int f5926n0;

    public int f5927o0;

    public final C1759a f5928p0;

    public final C1760b f5929q0;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1766h();

        public int f5934c;

        public boolean f5935d;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f5934c = parcel.readInt();
            this.f5935d = parcel.readInt() != 0;
        }

        @Override
        public final void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.f5934c);
            parcel.writeInt(this.f5935d ? 1 : 0);
        }
    }

    public BottomAppBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomAppBarStyle);
    }

    private ActionMenuView getActionMenuView() {
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    public int getBottomInset() {
        return this.f5925m0;
    }

    public float getFabTranslationX() {
        return m4111F(this.f5916d0);
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().f5955f;
    }

    public int getLeftInset() {
        return this.f5927o0;
    }

    public int getRightInset() {
        return this.f5926n0;
    }

    public C1767i getTopEdgeTreatment() {
        return (C1767i) this.f5913W.f13126a.f13107a.f13172i;
    }

    public final FloatingActionButton m4108C() {
        View viewM4109D = m4109D();
        if (viewM4109D instanceof FloatingActionButton) {
            return (FloatingActionButton) viewM4109D;
        }
        return null;
    }

    public final View m4109D() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) getParent();
        List list = (List) ((C3347k) coordinatorLayout.f1423b.f45c).get(this);
        ArrayList<View> arrayList = coordinatorLayout.f1425d;
        arrayList.clear();
        if (list != null) {
            arrayList.addAll(list);
        }
        for (View view : arrayList) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    public final int m4110E(ActionMenuView actionMenuView, int i6, boolean z7) {
        if (i6 != 1 || !z7) {
            return 0;
        }
        boolean zM4249i = AbstractC1811a0.m4249i(this);
        int measuredWidth = zM4249i ? getMeasuredWidth() : 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).f247a & 8388615) == 8388611) {
                measuredWidth = zM4249i ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        return measuredWidth - ((zM4249i ? actionMenuView.getRight() : actionMenuView.getLeft()) + (zM4249i ? this.f5926n0 : -this.f5927o0));
    }

    public final float m4111F(int i6) {
        boolean zM4249i = AbstractC1811a0.m4249i(this);
        if (i6 == 1) {
            return ((getMeasuredWidth() / 2) - (this.f5912V + (zM4249i ? this.f5927o0 : this.f5926n0))) * (zM4249i ? -1 : 1);
        }
        return 0.0f;
    }

    public final void m4112G(int i6, boolean z7) {
        int i10 = 2;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        if (!isLaidOut()) {
            this.f5922j0 = false;
            return;
        }
        AnimatorSet animatorSet = this.f5915c0;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        ArrayList arrayList = new ArrayList();
        FloatingActionButton floatingActionButtonM4108C = m4108C();
        if (floatingActionButtonM4108C == null || !floatingActionButtonM4108C.m4226i()) {
            i6 = 0;
            z7 = false;
        }
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
            if (Math.abs(actionMenuView.getTranslationX() - m4110E(actionMenuView, i6, z7)) > 1.0f) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
                objectAnimatorOfFloat2.addListener(new C1763e(this, actionMenuView, i6, z7));
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.setDuration(150L);
                animatorSet2.playSequentially(objectAnimatorOfFloat2, objectAnimatorOfFloat);
                arrayList.add(animatorSet2);
            } else if (actionMenuView.getAlpha() < 1.0f) {
                arrayList.add(objectAnimatorOfFloat);
            }
        }
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playTogether(arrayList);
        this.f5915c0 = animatorSet3;
        animatorSet3.addListener(new C1759a(this, i10));
        this.f5915c0.start();
    }

    public final void m4113H() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.f5915c0 != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        FloatingActionButton floatingActionButtonM4108C = m4108C();
        if (floatingActionButtonM4108C != null && floatingActionButtonM4108C.m4226i()) {
            m4116K(actionMenuView, this.f5916d0, this.f5923k0, false);
        } else {
            m4116K(actionMenuView, 0, false, false);
        }
    }

    public final void m4114I() {
        FloatingActionButton floatingActionButtonM4108C;
        getTopEdgeTreatment().f5956g = getFabTranslationX();
        View viewM4109D = m4109D();
        this.f5913W.m7810o((this.f5923k0 && (floatingActionButtonM4108C = m4108C()) != null && floatingActionButtonM4108C.m4226i()) ? 1.0f : 0.0f);
        if (viewM4109D != null) {
            viewM4109D.setTranslationY(getFabTranslationY());
            viewM4109D.setTranslationX(getFabTranslationX());
        }
    }

    public final void m4115J(int i6) {
        float f = i6;
        if (f != getTopEdgeTreatment().f5954e) {
            getTopEdgeTreatment().f5954e = f;
            this.f5913W.invalidateSelf();
        }
    }

    public final void m4116K(ActionMenuView actionMenuView, int i6, boolean z7, boolean z10) {
        RunnableC1764f runnableC1764f = new RunnableC1764f(this, actionMenuView, i6, z7);
        if (z10) {
            actionMenuView.post(runnableC1764f);
        } else {
            runnableC1764f.run();
        }
    }

    public ColorStateList getBackgroundTint() {
        return this.f5913W.f13126a.f13111e;
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().f5955f;
    }

    public int getFabAlignmentMode() {
        return this.f5916d0;
    }

    public int getFabAnimationMode() {
        return this.f5917e0;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().f5953d;
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().f5952c;
    }

    public boolean getHideOnScroll() {
        return this.f5918f0;
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC3280d.m6567D(this, this.f5913W);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        super.onLayout(z7, i6, i10, i11, i12);
        if (z7) {
            AnimatorSet animatorSet = this.f5915c0;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.f5914b0;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            m4114I();
        }
        m4113H();
    }

    @Override
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f1689a);
        this.f5916d0 = savedState.f5934c;
        this.f5923k0 = savedState.f5935d;
    }

    @Override
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5934c = this.f5916d0;
        savedState.f5935d = this.f5923k0;
        return savedState;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        AbstractC2581a.m5586h(this.f5913W, colorStateList);
    }

    public void setCradleVerticalOffset(float f) {
        if (f != getCradleVerticalOffset()) {
            getTopEdgeTreatment().m4120k(f);
            this.f5913W.invalidateSelf();
            m4114I();
        }
    }

    @Override
    public void setElevation(float f) {
        C3908h c3908h = this.f5913W;
        c3908h.m7808m(f);
        int iM7803h = c3908h.f13126a.f13121o - c3908h.m7803h();
        Behavior behavior = getBehavior();
        behavior.f5902c = iM7803h;
        if (behavior.f5901b == 1) {
            setTranslationY(behavior.f5900a + iM7803h);
        }
    }

    public void setFabAlignmentMode(int i6) {
        int i10 = 1;
        this.f5922j0 = true;
        m4112G(i6, this.f5923k0);
        if (this.f5916d0 != i6) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            if (isLaidOut()) {
                AnimatorSet animatorSet = this.f5914b0;
                if (animatorSet != null) {
                    animatorSet.cancel();
                }
                ArrayList arrayList = new ArrayList();
                if (this.f5917e0 == 1) {
                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(m4108C(), "translationX", m4111F(i6));
                    objectAnimatorOfFloat.setDuration(300L);
                    arrayList.add(objectAnimatorOfFloat);
                } else {
                    FloatingActionButton floatingActionButtonM4108C = m4108C();
                    if (floatingActionButtonM4108C != null && !floatingActionButtonM4108C.m4225h()) {
                        floatingActionButtonM4108C.m4224g(new C1762d(this, i6), true);
                    }
                }
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.playTogether(arrayList);
                this.f5914b0 = animatorSet2;
                animatorSet2.addListener(new C1759a(this, i10));
                this.f5914b0.start();
            }
        }
        this.f5916d0 = i6;
    }

    public void setFabAnimationMode(int i6) {
        this.f5917e0 = i6;
    }

    public void setFabCornerSize(float f) {
        if (f != getTopEdgeTreatment().f5957h) {
            getTopEdgeTreatment().f5957h = f;
            this.f5913W.invalidateSelf();
        }
    }

    public void setFabCradleMargin(float f) {
        if (f != getFabCradleMargin()) {
            getTopEdgeTreatment().f5953d = f;
            this.f5913W.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        if (f != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().f5952c = f;
            this.f5913W.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z7) {
        this.f5918f0 = z7;
    }

    @Override
    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null && this.f5911U != null) {
            drawable = AbstractC3198d.m6448W(drawable.mutate());
            AbstractC2581a.m5585g(drawable, this.f5911U.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i6) {
        this.f5911U = Integer.valueOf(i6);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public BottomAppBar(Context context, AttributeSet attributeSet, int i6) {
        super(AbstractC4275a.m8323a(context, attributeSet, i6, R.style.Widget_MaterialComponents_BottomAppBar), attributeSet, i6);
        C3908h c3908h = new C3908h();
        this.f5913W = c3908h;
        int i10 = 0;
        this.f5922j0 = false;
        this.f5923k0 = true;
        this.f5928p0 = new C1759a(this, i10);
        this.f5929q0 = new C1760b(this);
        Context context2 = getContext();
        TypedArray typedArrayM4250j = AbstractC1811a0.m4250j(context2, attributeSet, AbstractC4121a.f13991e, i6, R.style.Widget_MaterialComponents_BottomAppBar, new int[0]);
        ColorStateList colorStateListM3493k = AbstractC1466d.m3493k(context2, typedArrayM4250j, 0);
        if (typedArrayM4250j.hasValue(8)) {
            setNavigationIconTint(typedArrayM4250j.getColor(8, -1));
        }
        int dimensionPixelSize = typedArrayM4250j.getDimensionPixelSize(1, 0);
        float dimensionPixelOffset = typedArrayM4250j.getDimensionPixelOffset(4, 0);
        float dimensionPixelOffset2 = typedArrayM4250j.getDimensionPixelOffset(5, 0);
        float dimensionPixelOffset3 = typedArrayM4250j.getDimensionPixelOffset(6, 0);
        this.f5916d0 = typedArrayM4250j.getInt(2, 0);
        this.f5917e0 = typedArrayM4250j.getInt(3, 0);
        this.f5918f0 = typedArrayM4250j.getBoolean(7, false);
        this.f5919g0 = typedArrayM4250j.getBoolean(9, false);
        this.f5920h0 = typedArrayM4250j.getBoolean(10, false);
        this.f5921i0 = typedArrayM4250j.getBoolean(11, false);
        typedArrayM4250j.recycle();
        this.f5912V = getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fabOffsetEndMode);
        C1767i c1767i = new C1767i(i10);
        c1767i.f5957h = -1.0f;
        c1767i.f5953d = dimensionPixelOffset;
        c1767i.f5952c = dimensionPixelOffset2;
        c1767i.m4120k(dimensionPixelOffset3);
        c1767i.f5956g = 0.0f;
        C3911k c3911k = new C3911k();
        C3911k c3911k2 = new C3911k();
        C3911k c3911k3 = new C3911k();
        C3911k c3911k4 = new C3911k();
        C3901a c3901a = new C3901a(0.0f);
        C3901a c3901a2 = new C3901a(0.0f);
        C3901a c3901a3 = new C3901a(0.0f);
        C3901a c3901a4 = new C3901a(0.0f);
        int i11 = 0;
        C3905e c3905e = new C3905e(i11);
        C3905e c3905e2 = new C3905e(i11);
        C3905e c3905e3 = new C3905e(i11);
        C3913m c3913m = new C3913m();
        c3913m.f13164a = c3911k;
        c3913m.f13165b = c3911k2;
        c3913m.f13166c = c3911k3;
        c3913m.f13167d = c3911k4;
        c3913m.f13168e = c3901a;
        c3913m.f13169f = c3901a2;
        c3913m.f13170g = c3901a3;
        c3913m.f13171h = c3901a4;
        c3913m.f13172i = c1767i;
        c3913m.f13173j = c3905e;
        c3913m.f13174k = c3905e2;
        c3913m.f13175l = c3905e3;
        c3908h.setShapeAppearanceModel(c3913m);
        c3908h.m7813r();
        c3908h.m7811p(Paint.Style.FILL);
        c3908h.m7806k(context2);
        setElevation(dimensionPixelSize);
        AbstractC2581a.m5586h(c3908h, colorStateListM3493k);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        setBackground(c3908h);
        C1760b c1760b = new C1760b(this);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, AbstractC4121a.f14008v, i6, R.style.Widget_MaterialComponents_BottomAppBar);
        boolean z7 = typedArrayObtainStyledAttributes.getBoolean(3, false);
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(4, false);
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(5, false);
        typedArrayObtainStyledAttributes.recycle();
        AbstractC1811a0.m4244d(this, new C1813b0(z7, z10, z11, c1760b));
    }

    @Override
    public Behavior getBehavior() {
        if (this.f5924l0 == null) {
            this.f5924l0 = new Behavior();
        }
        return this.f5924l0;
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        public final Rect f5930e;

        public WeakReference f5931f;

        public int f5932g;

        public final ViewOnLayoutChangeListenerC1765g f5933h;

        public Behavior() {
            this.f5933h = new ViewOnLayoutChangeListenerC1765g(this);
            this.f5930e = new Rect();
        }

        @Override
        public final boolean mo926h(CoordinatorLayout coordinatorLayout, View view, int i6) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            this.f5931f = new WeakReference(bottomAppBar);
            int i10 = BottomAppBar.f5910r0;
            View viewM4109D = bottomAppBar.m4109D();
            if (viewM4109D != null) {
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                if (!viewM4109D.isLaidOut()) {
                    C0311c c0311c = (C0311c) viewM4109D.getLayoutParams();
                    c0311c.f1445d = 49;
                    this.f5932g = ((ViewGroup.MarginLayoutParams) c0311c).bottomMargin;
                    if (viewM4109D instanceof FloatingActionButton) {
                        FloatingActionButton floatingActionButton = (FloatingActionButton) viewM4109D;
                        if (floatingActionButton.getShowMotionSpec() == null) {
                            floatingActionButton.setShowMotionSpecResource(R.animator.mtrl_fab_show_motion_spec);
                        }
                        if (floatingActionButton.getHideMotionSpec() == null) {
                            floatingActionButton.setHideMotionSpecResource(R.animator.mtrl_fab_hide_motion_spec);
                        }
                        floatingActionButton.addOnLayoutChangeListener(this.f5933h);
                        floatingActionButton.m4220c(bottomAppBar.f5928p0);
                        floatingActionButton.m4221d(new C1759a(bottomAppBar, 3));
                        floatingActionButton.m4222e(bottomAppBar.f5929q0);
                    }
                    bottomAppBar.m4114I();
                }
            }
            coordinatorLayout.m914v(i6, bottomAppBar);
            super.mo926h(coordinatorLayout, bottomAppBar, i6);
            return false;
        }

        @Override
        public final boolean mo934p(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i6, int i10) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            return bottomAppBar.getHideOnScroll() && super.mo934p(coordinatorLayout, bottomAppBar, view2, view3, i6, i10);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f5933h = new ViewOnLayoutChangeListenerC1765g(this);
            this.f5930e = new Rect();
        }
    }

    @Override
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override
    public void setTitle(CharSequence charSequence) {
    }
}

package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.C0209g3;
import androidx.coordinatorlayout.widget.C0311c;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.InterfaceC0309a;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.AbstractC1811a0;
import com.google.android.material.internal.AbstractC1818e;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import p006a6.C0062a;
import p101j7.C2782c;
import p124l6.AbstractC2976b;
import p124l6.C2978d;
import p124l6.C2979e;
import p124l6.C2980f;
import p124l6.C2981g;
import p138n0.AbstractC3155s0;
import p221u6.C3913m;
import p250x5.AbstractC4121a;
import p262y5.C4272e;
import p263y6.AbstractC4275a;

public class ExtendedFloatingActionButton extends MaterialButton implements InterfaceC0309a {

    public static final C0209g3 f6262F;

    public static final C0209g3 f6263G;

    public static final C0209g3 f6264H;

    public static final C0209g3 f6265I;

    public final ExtendedFloatingActionButtonBehavior f6266A;

    public boolean f6267B;

    public boolean f6268C;

    public boolean f6269D;

    public ColorStateList f6270E;

    public int f6271s;

    public final C2979e f6272t;

    public final C2979e f6273u;

    public final C2981g f6274v;

    public final C2980f f6275w;

    public final int f6276x;

    public int f6277y;

    public int f6278z;

    static {
        Class<Float> cls = Float.class;
        f6262F = new C0209g3("width", cls, 1);
        f6263G = new C0209g3("height", cls, 2);
        f6264H = new C0209g3("paddingStart", cls, 3);
        f6265I = new C0209g3("paddingEnd", cls, 4);
    }

    public ExtendedFloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.extendedFloatingActionButtonStyle);
    }

    public static void m4214f(ExtendedFloatingActionButton extendedFloatingActionButton, AbstractC2976b abstractC2976b) {
        AnimatorSet animatorSetMo6026a;
        Iterator it;
        if (abstractC2976b.mo6033h()) {
            return;
        }
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        if (extendedFloatingActionButton.isLaidOut()) {
            if (!extendedFloatingActionButton.isInEditMode()) {
                extendedFloatingActionButton.measure(0, 0);
                animatorSetMo6026a = abstractC2976b.mo6026a();
                animatorSetMo6026a.addListener(new C0062a(5, abstractC2976b));
                it = abstractC2976b.f10196c.iterator();
                while (it.hasNext()) {
                    animatorSetMo6026a.addListener((Animator.AnimatorListener) it.next());
                }
                animatorSetMo6026a.start();
                return;
            }
        } else if (extendedFloatingActionButton.getVisibility() != 0) {
            if (extendedFloatingActionButton.f6269D) {
                if (!extendedFloatingActionButton.isInEditMode()) {
                    extendedFloatingActionButton.measure(0, 0);
                    animatorSetMo6026a = abstractC2976b.mo6026a();
                    animatorSetMo6026a.addListener(new C0062a(5, abstractC2976b));
                    it = abstractC2976b.f10196c.iterator();
                    while (it.hasNext()) {
                        animatorSetMo6026a.addListener((Animator.AnimatorListener) it.next());
                    }
                    animatorSetMo6026a.start();
                    return;
                }
            }
        } else if (extendedFloatingActionButton.f6269D) {
            if (!extendedFloatingActionButton.isInEditMode()) {
                extendedFloatingActionButton.measure(0, 0);
                animatorSetMo6026a = abstractC2976b.mo6026a();
                animatorSetMo6026a.addListener(new C0062a(5, abstractC2976b));
                it = abstractC2976b.f10196c.iterator();
                while (it.hasNext()) {
                    animatorSetMo6026a.addListener((Animator.AnimatorListener) it.next());
                }
                animatorSetMo6026a.start();
                return;
            }
        }
        abstractC2976b.mo6032g();
    }

    public final void m4215g(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    @Override
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.f6266A;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    public int getCollapsedSize() {
        int i6 = this.f6276x;
        if (i6 >= 0) {
            return i6;
        }
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        return (Math.min(getPaddingStart(), getPaddingEnd()) * 2) + getIconSize();
    }

    public C4272e getExtendMotionSpec() {
        return this.f6273u.f10199f;
    }

    public C4272e getHideMotionSpec() {
        return this.f6275w.f10199f;
    }

    public C4272e getShowMotionSpec() {
        return this.f6274v.f10199f;
    }

    public C4272e getShrinkMotionSpec() {
        return this.f6272t.f10199f;
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f6267B && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.f6267B = false;
            this.f6272t.mo6032g();
        }
    }

    public void setAnimateShowBeforeLayout(boolean z7) {
        this.f6269D = z7;
    }

    public void setExtendMotionSpec(C4272e c4272e) {
        this.f6273u.f10199f = c4272e;
    }

    public void setExtendMotionSpecResource(int i6) {
        setExtendMotionSpec(C4272e.m8314b(getContext(), i6));
    }

    public void setExtended(boolean z7) {
        if (this.f6267B == z7) {
            return;
        }
        C2979e c2979e = z7 ? this.f6273u : this.f6272t;
        if (c2979e.mo6033h()) {
            return;
        }
        c2979e.mo6032g();
    }

    public void setHideMotionSpec(C4272e c4272e) {
        this.f6275w.f10199f = c4272e;
    }

    public void setHideMotionSpecResource(int i6) {
        setHideMotionSpec(C4272e.m8314b(getContext(), i6));
    }

    @Override
    public final void setPadding(int i6, int i10, int i11, int i12) {
        super.setPadding(i6, i10, i11, i12);
        if (!this.f6267B || this.f6268C) {
            return;
        }
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        this.f6277y = getPaddingStart();
        this.f6278z = getPaddingEnd();
    }

    @Override
    public final void setPaddingRelative(int i6, int i10, int i11, int i12) {
        super.setPaddingRelative(i6, i10, i11, i12);
        if (!this.f6267B || this.f6268C) {
            return;
        }
        this.f6277y = i6;
        this.f6278z = i11;
    }

    public void setShowMotionSpec(C4272e c4272e) {
        this.f6274v.f10199f = c4272e;
    }

    public void setShowMotionSpecResource(int i6) {
        setShowMotionSpec(C4272e.m8314b(getContext(), i6));
    }

    public void setShrinkMotionSpec(C4272e c4272e) {
        this.f6272t.f10199f = c4272e;
    }

    public void setShrinkMotionSpecResource(int i6) {
        setShrinkMotionSpec(C4272e.m8314b(getContext(), i6));
    }

    @Override
    public void setTextColor(int i6) {
        super.setTextColor(i6);
        this.f6270E = getTextColors();
    }

    public ExtendedFloatingActionButton(Context context, AttributeSet attributeSet, int i6) {
        super(AbstractC4275a.m8323a(context, attributeSet, i6, R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon), attributeSet, i6);
        int i10 = 8;
        boolean z7 = false;
        this.f6271s = 0;
        C2782c c2782c = new C2782c(i10, z7);
        C2981g c2981g = new C2981g(this, c2782c);
        this.f6274v = c2981g;
        C2980f c2980f = new C2980f(this, c2782c);
        this.f6275w = c2980f;
        this.f6267B = true;
        this.f6268C = false;
        this.f6269D = false;
        Context context2 = getContext();
        this.f6266A = new ExtendedFloatingActionButtonBehavior(context2, attributeSet);
        TypedArray typedArrayM4250j = AbstractC1811a0.m4250j(context2, attributeSet, AbstractC4121a.f14002p, i6, R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon, new int[0]);
        C4272e c4272eM8313a = C4272e.m8313a(context2, typedArrayM4250j, 4);
        C4272e c4272eM8313a2 = C4272e.m8313a(context2, typedArrayM4250j, 3);
        C4272e c4272eM8313a3 = C4272e.m8313a(context2, typedArrayM4250j, 2);
        C4272e c4272eM8313a4 = C4272e.m8313a(context2, typedArrayM4250j, 5);
        this.f6276x = typedArrayM4250j.getDimensionPixelSize(0, -1);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        this.f6277y = getPaddingStart();
        this.f6278z = getPaddingEnd();
        C2782c c2782c2 = new C2782c(i10, z7);
        C2979e c2979e = new C2979e(this, c2782c2, new C2978d(this, 0), true);
        this.f6273u = c2979e;
        C2979e c2979e2 = new C2979e(this, c2782c2, new C2978d(this, 1), false);
        this.f6272t = c2979e2;
        c2981g.f10199f = c4272eM8313a;
        c2980f.f10199f = c4272eM8313a2;
        c2979e.f10199f = c4272eM8313a3;
        c2979e2.f10199f = c4272eM8313a4;
        typedArrayM4250j.recycle();
        setShapeAppearanceModel(C3913m.m7823c(context2, attributeSet, i6, R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon, C3913m.f13163m).m7819a());
        this.f6270E = getTextColors();
    }

    @Override
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        this.f6270E = getTextColors();
    }

    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        public Rect f6279a;

        public final boolean f6280b;

        public final boolean f6281c;

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4121a.f14003q);
            this.f6280b = typedArrayObtainStyledAttributes.getBoolean(0, false);
            this.f6281c = typedArrayObtainStyledAttributes.getBoolean(1, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override
        public final boolean mo919a(View view, Rect rect) {
            return false;
        }

        @Override
        public final void mo921c(C0311c c0311c) {
            if (c0311c.f1449h == 0) {
                c0311c.f1449h = 80;
            }
        }

        @Override
        public final boolean mo922d(CoordinatorLayout coordinatorLayout, View view, View view2) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                m4216s(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof C0311c ? ((C0311c) layoutParams).f1442a instanceof BottomSheetBehavior : false) {
                    m4217t(view2, extendedFloatingActionButton);
                }
            }
            return false;
        }

        @Override
        public final boolean mo926h(CoordinatorLayout coordinatorLayout, View view, int i6) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            ArrayList arrayListM909o = coordinatorLayout.m909o(extendedFloatingActionButton);
            int size = arrayListM909o.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view2 = (View) arrayListM909o.get(i10);
                if (!(view2 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof C0311c ? ((C0311c) layoutParams).f1442a instanceof BottomSheetBehavior : false) && m4217t(view2, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (m4216s(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.m914v(i6, extendedFloatingActionButton);
            return true;
        }

        public final boolean m4216s(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            C0311c c0311c = (C0311c) extendedFloatingActionButton.getLayoutParams();
            if ((!this.f6280b && !this.f6281c) || c0311c.f1447f != appBarLayout.getId()) {
                return false;
            }
            if (this.f6279a == null) {
                this.f6279a = new Rect();
            }
            Rect rect = this.f6279a;
            AbstractC1818e.m4274a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                ExtendedFloatingActionButton.m4214f(extendedFloatingActionButton, this.f6281c ? extendedFloatingActionButton.f6272t : extendedFloatingActionButton.f6275w);
                return true;
            }
            ExtendedFloatingActionButton.m4214f(extendedFloatingActionButton, this.f6281c ? extendedFloatingActionButton.f6273u : extendedFloatingActionButton.f6274v);
            return true;
        }

        public final boolean m4217t(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            C0311c c0311c = (C0311c) extendedFloatingActionButton.getLayoutParams();
            if ((!this.f6280b && !this.f6281c) || c0311c.f1447f != view.getId()) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((C0311c) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                ExtendedFloatingActionButton.m4214f(extendedFloatingActionButton, this.f6281c ? extendedFloatingActionButton.f6272t : extendedFloatingActionButton.f6275w);
                return true;
            }
            ExtendedFloatingActionButton.m4214f(extendedFloatingActionButton, this.f6281c ? extendedFloatingActionButton.f6273u : extendedFloatingActionButton.f6274v);
            return true;
        }

        public ExtendedFloatingActionButtonBehavior() {
            this.f6280b = false;
            this.f6281c = true;
        }
    }
}

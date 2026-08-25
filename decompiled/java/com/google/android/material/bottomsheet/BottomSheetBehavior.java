package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.app.C0157r0;
import androidx.appcompat.widget.RunnableC0261r0;
import androidx.coordinatorlayout.widget.C0311c;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import com.bumptech.glide.AbstractC1466d;
import com.google.android.material.internal.AbstractC1811a0;
import com.p2serv.android.p032ds.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;
import p000a.AbstractC0004e;
import p007a7.C0066c;
import p028c6.C1398a;
import p028c6.C1399b;
import p028c6.C1400c;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3155s0;
import p138n0.C3100a;
import p138n0.C3103b;
import p148o0.C3228c;
import p221u6.C3908h;
import p221u6.C3913m;
import p226v0.C3968d;
import p250x5.AbstractC4121a;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    public final int f5958A;

    public int f5959B;

    public int f5960C;

    public final float f5961D;

    public int f5962E;

    public final float f5963F;

    public boolean f5964G;

    public boolean f5965H;

    public final boolean f5966I;

    public int f5967J;

    public C3968d f5968K;

    public boolean f5969L;

    public int f5970M;

    public boolean f5971N;

    public int f5972O;

    public int f5973P;

    public int f5974Q;

    public WeakReference f5975R;

    public WeakReference f5976S;

    public final ArrayList f5977T;

    public VelocityTracker f5978U;

    public int f5979V;

    public int f5980W;

    public boolean f5981X;

    public HashMap f5982Y;

    public int f5983Z;

    public final int f5984a;

    public final C1398a f5985a0;

    public boolean f5986b;

    public final float f5987c;

    public int f5988d;

    public boolean f5989e;

    public int f5990f;

    public final int f5991g;

    public final C3908h f5992h;

    public final ColorStateList f5993i;

    public final int f5994j;

    public final int f5995k;

    public int f5996l;

    public final boolean f5997m;

    public final boolean f5998n;

    public final boolean f5999o;

    public final boolean f6000p;

    public final boolean f6001q;

    public final boolean f6002r;

    public final boolean f6003s;

    public final boolean f6004t;

    public int f6005u;

    public int f6006v;

    public final C3913m f6007w;

    public boolean f6008x;

    public final C1400c f6009y;

    public final ValueAnimator f6010z;

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i6;
        super(context, attributeSet);
        this.f5984a = 0;
        int i10 = 1;
        this.f5986b = true;
        this.f5994j = -1;
        this.f5995k = -1;
        this.f6009y = new C1400c(this);
        this.f5961D = 0.5f;
        this.f5963F = -1.0f;
        this.f5966I = true;
        this.f5967J = 4;
        this.f5977T = new ArrayList();
        this.f5983Z = -1;
        this.f5985a0 = new C1398a(this);
        this.f5991g = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4121a.f13993g);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            this.f5993i = AbstractC1466d.m3493k(context, typedArrayObtainStyledAttributes, 3);
        }
        if (typedArrayObtainStyledAttributes.hasValue(20)) {
            this.f6007w = C3913m.m7822b(context, attributeSet, R.attr.bottomSheetStyle, R.style.Widget_Design_BottomSheet_Modal).m7819a();
        }
        C3913m c3913m = this.f6007w;
        if (c3913m != null) {
            C3908h c3908h = new C3908h(c3913m);
            this.f5992h = c3908h;
            c3908h.m7806k(context);
            ColorStateList colorStateList = this.f5993i;
            if (colorStateList != null) {
                this.f5992h.m7809n(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.f5992h.setTint(typedValue.data);
            }
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f6010z = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.f6010z.addUpdateListener(new C0066c(i10, this));
        this.f5963F = typedArrayObtainStyledAttributes.getDimension(2, -1.0f);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            this.f5994j = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            this.f5995k = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, -1);
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(9);
        if (typedValuePeekValue == null || (i6 = typedValuePeekValue.data) != -1) {
            m4137z(typedArrayObtainStyledAttributes.getDimensionPixelSize(9, -1));
        } else {
            m4137z(i6);
        }
        boolean z7 = typedArrayObtainStyledAttributes.getBoolean(8, false);
        if (this.f5964G != z7) {
            this.f5964G = z7;
            if (!z7 && this.f5967J == 5) {
                m4124A(4);
            }
            m4128E();
        }
        this.f5997m = typedArrayObtainStyledAttributes.getBoolean(12, false);
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(6, true);
        if (this.f5986b != z10) {
            this.f5986b = z10;
            if (this.f5975R != null) {
                m4132s();
            }
            m4125B((this.f5986b && this.f5967J == 6) ? 3 : this.f5967J);
            m4128E();
        }
        this.f5965H = typedArrayObtainStyledAttributes.getBoolean(11, false);
        this.f5966I = typedArrayObtainStyledAttributes.getBoolean(4, true);
        this.f5984a = typedArrayObtainStyledAttributes.getInt(10, 0);
        float f = typedArrayObtainStyledAttributes.getFloat(7, 0.5f);
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.f5961D = f;
        if (this.f5975R != null) {
            this.f5960C = (int) ((1.0f - f) * this.f5974Q);
        }
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(5);
        if (typedValuePeekValue2 == null || typedValuePeekValue2.type != 16) {
            int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(5, 0);
            if (dimensionPixelOffset < 0) {
                throw new IllegalArgumentException("offset must be greater than or equal to 0");
            }
            this.f5958A = dimensionPixelOffset;
        } else {
            int i11 = typedValuePeekValue2.data;
            if (i11 < 0) {
                throw new IllegalArgumentException("offset must be greater than or equal to 0");
            }
            this.f5958A = i11;
        }
        this.f5998n = typedArrayObtainStyledAttributes.getBoolean(16, false);
        this.f5999o = typedArrayObtainStyledAttributes.getBoolean(17, false);
        this.f6000p = typedArrayObtainStyledAttributes.getBoolean(18, false);
        this.f6001q = typedArrayObtainStyledAttributes.getBoolean(19, true);
        this.f6002r = typedArrayObtainStyledAttributes.getBoolean(13, false);
        this.f6003s = typedArrayObtainStyledAttributes.getBoolean(14, false);
        this.f6004t = typedArrayObtainStyledAttributes.getBoolean(15, false);
        typedArrayObtainStyledAttributes.recycle();
        this.f5987c = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public static View m4122v(View view) {
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        if (AbstractC3119g0.m6177p(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View viewM4122v = m4122v(viewGroup.getChildAt(i6));
            if (viewM4122v != null) {
                return viewM4122v;
            }
        }
        return null;
    }

    public static int m4123w(int i6, int i10, int i11, int i12) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i6, i10, i12);
        if (i11 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i11), 1073741824);
        }
        if (size != 0) {
            i11 = Math.min(size, i11);
        }
        return View.MeasureSpec.makeMeasureSpec(i11, Integer.MIN_VALUE);
    }

    public final void m4124A(int i6) {
        if (i6 == 1 || i6 == 2) {
            throw new IllegalArgumentException(AbstractC0004e.m26t(new StringBuilder("STATE_"), i6 == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        if (!this.f5964G && i6 == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i6);
            return;
        }
        int i10 = (i6 == 6 && this.f5986b && m4136y(i6) <= this.f5959B) ? 3 : i6;
        WeakReference weakReference = this.f5975R;
        if (weakReference == null || weakReference.get() == null) {
            m4125B(i6);
            return;
        }
        View view = (View) this.f5975R.get();
        RunnableC0261r0 runnableC0261r0 = new RunnableC0261r0(this, view, i10, 2, false);
        ViewParent parent = view.getParent();
        if (parent != null && parent.isLayoutRequested()) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            if (view.isAttachedToWindow()) {
                view.post(runnableC0261r0);
                return;
            }
        }
        runnableC0261r0.run();
    }

    public final void m4125B(int i6) {
        if (this.f5967J == i6) {
            return;
        }
        this.f5967J = i6;
        if (i6 != 4 && i6 != 3 && i6 != 6) {
            boolean z7 = this.f5964G;
        }
        WeakReference weakReference = this.f5975R;
        if (weakReference == null || ((View) weakReference.get()) == null) {
            return;
        }
        if (i6 == 3) {
            m4130G(true);
        } else if (i6 == 6 || i6 == 5 || i6 == 4) {
            m4130G(false);
        }
        m4129F(i6);
        ArrayList arrayList = this.f5977T;
        if (arrayList.size() > 0) {
            throw AbstractC0004e.m17k(0, arrayList);
        }
        m4128E();
    }

    public final boolean m4126C(View view, float f) {
        if (this.f5965H) {
            return true;
        }
        if (view.getTop() < this.f5962E) {
            return false;
        }
        return Math.abs(((f * 0.1f) + ((float) view.getTop())) - ((float) this.f5962E)) / ((float) m4133t()) > 0.5f;
    }

    public final void m4127D(View view, int i6, boolean z7) {
        int iM4136y = m4136y(i6);
        C3968d c3968d = this.f5968K;
        if (c3968d == null || (!z7 ? c3968d.m7964s(view, view.getLeft(), iM4136y) : c3968d.m7962q(view.getLeft(), iM4136y))) {
            m4125B(i6);
            return;
        }
        m4125B(2);
        m4129F(i6);
        this.f6009y.m3276d(i6);
    }

    public final void m4128E() {
        View view;
        int iM6512a;
        WeakReference weakReference = this.f5975R;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        AbstractC3155s0.m6344n(524288, view);
        AbstractC3155s0.m6338h(0, view);
        AbstractC3155s0.m6344n(262144, view);
        AbstractC3155s0.m6338h(0, view);
        AbstractC3155s0.m6344n(ProgressiveMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES, view);
        AbstractC3155s0.m6338h(0, view);
        int i6 = this.f5983Z;
        if (i6 != -1) {
            AbstractC3155s0.m6344n(i6, view);
            AbstractC3155s0.m6338h(0, view);
        }
        if (!this.f5986b && this.f5967J != 6) {
            String string = view.getResources().getString(R.string.bottomsheet_action_expand_halfway);
            C1399b c1399b = new C1399b(6, this);
            ArrayList arrayListM6335e = AbstractC3155s0.m6335e(view);
            int i10 = 0;
            while (true) {
                if (i10 >= arrayListM6335e.size()) {
                    int i11 = -1;
                    for (int i12 = 0; i12 < 32 && i11 == -1; i12++) {
                        int i13 = AbstractC3155s0.f10646e[i12];
                        boolean z7 = true;
                        for (int i14 = 0; i14 < arrayListM6335e.size(); i14++) {
                            z7 &= ((C3228c) arrayListM6335e.get(i14)).m6512a() != i13;
                        }
                        if (z7) {
                            i11 = i13;
                        }
                    }
                    iM6512a = i11;
                    break;
                }
                if (TextUtils.equals(string, ((AccessibilityNodeInfo.AccessibilityAction) ((C3228c) arrayListM6335e.get(i10)).f10856a).getLabel())) {
                    iM6512a = ((C3228c) arrayListM6335e.get(i10)).m6512a();
                    break;
                }
                i10++;
            }
            if (iM6512a != -1) {
                C3228c c3228c = new C3228c(null, iM6512a, string, c1399b, null);
                View.AccessibilityDelegate accessibilityDelegateM6334d = AbstractC3155s0.m6334d(view);
                C3103b c3103b = accessibilityDelegateM6334d == null ? null : accessibilityDelegateM6334d instanceof C3100a ? ((C3100a) accessibilityDelegateM6334d).f10568a : new C3103b(accessibilityDelegateM6334d);
                if (c3103b == null) {
                    c3103b = new C3103b();
                }
                AbstractC3155s0.m6347q(view, c3103b);
                AbstractC3155s0.m6344n(c3228c.m6512a(), view);
                AbstractC3155s0.m6335e(view).add(c3228c);
                AbstractC3155s0.m6338h(0, view);
            }
            this.f5983Z = iM6512a;
        }
        if (this.f5964G && this.f5967J != 5) {
            AbstractC3155s0.m6345o(view, C3228c.f10848l, new C1399b(5, this));
        }
        int i15 = this.f5967J;
        if (i15 == 3) {
            AbstractC3155s0.m6345o(view, C3228c.f10847k, new C1399b(this.f5986b ? 4 : 6, this));
            return;
        }
        if (i15 == 4) {
            AbstractC3155s0.m6345o(view, C3228c.f10846j, new C1399b(this.f5986b ? 3 : 6, this));
        } else {
            if (i15 != 6) {
                return;
            }
            AbstractC3155s0.m6345o(view, C3228c.f10847k, new C1399b(4, this));
            AbstractC3155s0.m6345o(view, C3228c.f10846j, new C1399b(3, this));
        }
    }

    public final void m4129F(int i6) {
        ValueAnimator valueAnimator = this.f6010z;
        if (i6 == 2) {
            return;
        }
        boolean z7 = i6 == 3;
        if (this.f6008x != z7) {
            this.f6008x = z7;
            if (this.f5992h == null || valueAnimator == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                valueAnimator.reverse();
                return;
            }
            float f = z7 ? 0.0f : 1.0f;
            valueAnimator.setFloatValues(1.0f - f, f);
            valueAnimator.start();
        }
    }

    public final void m4130G(boolean z7) {
        WeakReference weakReference = this.f5975R;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z7) {
                if (this.f5982Y != null) {
                    return;
                } else {
                    this.f5982Y = new HashMap(childCount);
                }
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = coordinatorLayout.getChildAt(i6);
                if (childAt != this.f5975R.get() && z7) {
                    this.f5982Y.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z7) {
                return;
            }
            this.f5982Y = null;
        }
    }

    public final void m4131H() {
        View view;
        if (this.f5975R != null) {
            m4132s();
            if (this.f5967J != 4 || (view = (View) this.f5975R.get()) == null) {
                return;
            }
            view.requestLayout();
        }
    }

    @Override
    public final void mo921c(C0311c c0311c) {
        this.f5975R = null;
        this.f5968K = null;
    }

    @Override
    public final void mo924f() {
        this.f5975R = null;
        this.f5968K = null;
    }

    @Override
    public final boolean mo925g(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        C3968d c3968d;
        if (!view.isShown() || !this.f5966I) {
            this.f5969L = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f5979V = -1;
            VelocityTracker velocityTracker = this.f5978U;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f5978U = null;
            }
        }
        if (this.f5978U == null) {
            this.f5978U = VelocityTracker.obtain();
        }
        this.f5978U.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x10 = (int) motionEvent.getX();
            this.f5980W = (int) motionEvent.getY();
            if (this.f5967J != 2) {
                WeakReference weakReference = this.f5976S;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.m912t(view2, x10, this.f5980W)) {
                    this.f5979V = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f5981X = true;
                }
            }
            this.f5969L = this.f5979V == -1 && !coordinatorLayout.m912t(view, x10, this.f5980W);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f5981X = false;
            this.f5979V = -1;
            if (this.f5969L) {
                this.f5969L = false;
                return false;
            }
        }
        if (!this.f5969L && (c3968d = this.f5968K) != null && c3968d.m7963r(motionEvent)) {
            return true;
        }
        WeakReference weakReference2 = this.f5976S;
        View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
        return (actionMasked != 2 || view3 == null || this.f5969L || this.f5967J == 1 || coordinatorLayout.m912t(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.f5968K == null || Math.abs(((float) this.f5980W) - motionEvent.getY()) <= ((float) this.f5968K.f13479b)) ? false : true;
    }

    @Override
    public final boolean mo926h(CoordinatorLayout coordinatorLayout, View view, int i6) {
        int i10 = 2;
        C3908h c3908h = this.f5992h;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        if (this.f5975R == null) {
            this.f5990f = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            boolean z7 = (Build.VERSION.SDK_INT < 29 || this.f5997m || this.f5989e) ? false : true;
            if (this.f5998n || this.f5999o || this.f6000p || this.f6002r || this.f6003s || this.f6004t || z7) {
                AbstractC1811a0.m4244d(view, new C0157r0(i10, this, z7));
            }
            this.f5975R = new WeakReference(view);
            if (c3908h != null) {
                view.setBackground(c3908h);
                float fM6170i = this.f5963F;
                if (fM6170i == -1.0f) {
                    fM6170i = AbstractC3119g0.m6170i(view);
                }
                c3908h.m7808m(fM6170i);
                boolean z10 = this.f5967J == 3;
                this.f6008x = z10;
                c3908h.m7810o(z10 ? 0.0f : 1.0f);
            } else {
                ColorStateList colorStateList = this.f5993i;
                if (colorStateList != null) {
                    AbstractC3155s0.m6349s(view, colorStateList);
                }
            }
            m4128E();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
        }
        if (this.f5968K == null) {
            this.f5968K = new C3968d(coordinatorLayout.getContext(), coordinatorLayout, this.f5985a0);
        }
        int top = view.getTop();
        coordinatorLayout.m914v(i6, view);
        this.f5973P = coordinatorLayout.getWidth();
        this.f5974Q = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.f5972O = height;
        int i11 = this.f5974Q;
        int i12 = i11 - height;
        int i13 = this.f6006v;
        if (i12 < i13) {
            if (this.f6001q) {
                this.f5972O = i11;
            } else {
                this.f5972O = i11 - i13;
            }
        }
        this.f5959B = Math.max(0, i11 - this.f5972O);
        this.f5960C = (int) ((1.0f - this.f5961D) * this.f5974Q);
        m4132s();
        int i14 = this.f5967J;
        if (i14 == 3) {
            AbstractC3155s0.m6340j(m4135x(), view);
        } else if (i14 == 6) {
            AbstractC3155s0.m6340j(this.f5960C, view);
        } else if (this.f5964G && i14 == 5) {
            AbstractC3155s0.m6340j(this.f5974Q, view);
        } else if (i14 == 4) {
            AbstractC3155s0.m6340j(this.f5962E, view);
        } else if (i14 == 1 || i14 == 2) {
            AbstractC3155s0.m6340j(top - view.getTop(), view);
        }
        this.f5976S = new WeakReference(m4122v(view));
        ArrayList arrayList = this.f5977T;
        if (arrayList.size() <= 0) {
            return true;
        }
        throw AbstractC0004e.m17k(0, arrayList);
    }

    @Override
    public final boolean mo927i(CoordinatorLayout coordinatorLayout, View view, int i6, int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(m4123w(i6, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i10, this.f5994j, marginLayoutParams.width), m4123w(i11, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, this.f5995k, marginLayoutParams.height));
        return true;
    }

    @Override
    public final boolean mo928j(View view) {
        WeakReference weakReference = this.f5976S;
        return (weakReference == null || view != weakReference.get() || this.f5967J == 3) ? false : true;
    }

    @Override
    public final void mo929k(CoordinatorLayout coordinatorLayout, View view, View view2, int i6, int i10, int[] iArr, int i11) {
        if (i11 == 1) {
            return;
        }
        WeakReference weakReference = this.f5976S;
        if (view2 != (weakReference != null ? (View) weakReference.get() : null)) {
            return;
        }
        int top = view.getTop();
        int i12 = top - i10;
        if (i10 > 0) {
            if (i12 < m4135x()) {
                int iM4135x = top - m4135x();
                iArr[1] = iM4135x;
                AbstractC3155s0.m6340j(-iM4135x, view);
                m4125B(3);
            } else {
                if (!this.f5966I) {
                    return;
                }
                iArr[1] = i10;
                AbstractC3155s0.m6340j(-i10, view);
                m4125B(1);
            }
        } else if (i10 < 0 && !view2.canScrollVertically(-1)) {
            int i13 = this.f5962E;
            if (i12 > i13 && !this.f5964G) {
                int i14 = top - i13;
                iArr[1] = i14;
                AbstractC3155s0.m6340j(-i14, view);
                m4125B(4);
            } else {
                if (!this.f5966I) {
                    return;
                }
                iArr[1] = i10;
                AbstractC3155s0.m6340j(-i10, view);
                m4125B(1);
            }
        }
        m4134u(view.getTop());
        this.f5970M = i10;
        this.f5971N = true;
    }

    @Override
    public final void mo932n(View view, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        int i6 = this.f5984a;
        if (i6 != 0) {
            if (i6 == -1 || (i6 & 1) == 1) {
                this.f5988d = savedState.f6012d;
            }
            if (i6 == -1 || (i6 & 2) == 2) {
                this.f5986b = savedState.f6013e;
            }
            if (i6 == -1 || (i6 & 4) == 4) {
                this.f5964G = savedState.f6014f;
            }
            if (i6 == -1 || (i6 & 8) == 8) {
                this.f5965H = savedState.f6015g;
            }
        }
        int i10 = savedState.f6011c;
        if (i10 == 1 || i10 == 2) {
            this.f5967J = 4;
        } else {
            this.f5967J = i10;
        }
    }

    @Override
    public final Parcelable mo933o(View view) {
        return new SavedState(View.BaseSavedState.EMPTY_STATE, this);
    }

    @Override
    public final boolean mo934p(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i6, int i10) {
        this.f5970M = 0;
        this.f5971N = false;
        return (i6 & 2) != 0;
    }

    @Override
    public final void mo935q(CoordinatorLayout coordinatorLayout, View view, View view2, int i6) {
        int top;
        int top2;
        int i10;
        float yVelocity;
        int i11 = 3;
        if (view.getTop() == m4135x()) {
            m4125B(3);
            return;
        }
        WeakReference weakReference = this.f5976S;
        if (weakReference != null && view2 == weakReference.get() && this.f5971N) {
            if (this.f5970M > 0) {
                if (!this.f5986b && view.getTop() > this.f5960C) {
                    i11 = 6;
                }
            } else if (this.f5964G) {
                VelocityTracker velocityTracker = this.f5978U;
                if (velocityTracker == null) {
                    yVelocity = 0.0f;
                } else {
                    velocityTracker.computeCurrentVelocity(1000, this.f5987c);
                    yVelocity = this.f5978U.getYVelocity(this.f5979V);
                }
                if (m4126C(view, yVelocity)) {
                    i11 = 5;
                } else if (this.f5970M == 0) {
                    top2 = view.getTop();
                    if (this.f5986b) {
                        i10 = this.f5960C;
                        if (top2 < i10) {
                            if (top2 >= Math.abs(top2 - this.f5962E)) {
                            }
                        } else if (Math.abs(top2 - i10) < Math.abs(top2 - this.f5962E)) {
                            i11 = 4;
                        }
                        i11 = 6;
                    } else if (Math.abs(top2 - this.f5959B) >= Math.abs(top2 - this.f5962E)) {
                        i11 = 4;
                    }
                } else {
                    if (!this.f5986b) {
                        top = view.getTop();
                        if (Math.abs(top - this.f5960C) < Math.abs(top - this.f5962E)) {
                            i11 = 6;
                        }
                    }
                    i11 = 4;
                }
            } else if (this.f5970M == 0) {
                top2 = view.getTop();
                if (this.f5986b) {
                    i10 = this.f5960C;
                    if (top2 < i10) {
                        if (top2 >= Math.abs(top2 - this.f5962E)) {
                        }
                    } else if (Math.abs(top2 - i10) < Math.abs(top2 - this.f5962E)) {
                        i11 = 4;
                    }
                    i11 = 6;
                } else if (Math.abs(top2 - this.f5959B) >= Math.abs(top2 - this.f5962E)) {
                    i11 = 4;
                }
            } else {
                if (!this.f5986b) {
                    top = view.getTop();
                    if (Math.abs(top - this.f5960C) < Math.abs(top - this.f5962E)) {
                        i11 = 6;
                    }
                }
                i11 = 4;
            }
            m4127D(view, i11, false);
            this.f5971N = false;
        }
    }

    @Override
    public final boolean mo936r(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i6 = this.f5967J;
        if (i6 == 1 && actionMasked == 0) {
            return true;
        }
        C3968d c3968d = this.f5968K;
        if (c3968d != null && (this.f5966I || i6 == 1)) {
            c3968d.m7956k(motionEvent);
        }
        if (actionMasked == 0) {
            this.f5979V = -1;
            VelocityTracker velocityTracker = this.f5978U;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f5978U = null;
            }
        }
        if (this.f5978U == null) {
            this.f5978U = VelocityTracker.obtain();
        }
        this.f5978U.addMovement(motionEvent);
        if (this.f5968K != null && ((this.f5966I || this.f5967J == 1) && actionMasked == 2 && !this.f5969L)) {
            float fAbs = Math.abs(this.f5980W - motionEvent.getY());
            C3968d c3968d2 = this.f5968K;
            if (fAbs > c3968d2.f13479b) {
                c3968d2.m7947b(motionEvent.getPointerId(motionEvent.getActionIndex()), view);
            }
        }
        return !this.f5969L;
    }

    public final void m4132s() {
        int iM4133t = m4133t();
        if (this.f5986b) {
            this.f5962E = Math.max(this.f5974Q - iM4133t, this.f5959B);
        } else {
            this.f5962E = this.f5974Q - iM4133t;
        }
    }

    public final int m4133t() {
        int i6;
        if (this.f5989e) {
            return Math.min(Math.max(this.f5990f, this.f5974Q - ((this.f5973P * 9) / 16)), this.f5972O) + this.f6005u;
        }
        return (this.f5997m || this.f5998n || (i6 = this.f5996l) <= 0) ? this.f5988d + this.f6005u : Math.max(this.f5988d, i6 + this.f5991g);
    }

    public final void m4134u(int i6) {
        if (((View) this.f5975R.get()) != null) {
            ArrayList arrayList = this.f5977T;
            if (arrayList.isEmpty()) {
                return;
            }
            int i10 = this.f5962E;
            if (i6 <= i10 && i10 != m4135x()) {
                m4135x();
            }
            if (arrayList.size() > 0) {
                throw AbstractC0004e.m17k(0, arrayList);
            }
        }
    }

    public final int m4135x() {
        if (this.f5986b) {
            return this.f5959B;
        }
        return Math.max(this.f5958A, this.f6001q ? 0 : this.f6006v);
    }

    public final int m4136y(int i6) {
        if (i6 == 3) {
            return m4135x();
        }
        if (i6 == 4) {
            return this.f5962E;
        }
        if (i6 == 5) {
            return this.f5974Q;
        }
        if (i6 == 6) {
            return this.f5960C;
        }
        throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "Invalid state to get top offset: "));
    }

    public final void m4137z(int i6) {
        if (i6 == -1) {
            if (this.f5989e) {
                return;
            } else {
                this.f5989e = true;
            }
        } else {
            if (!this.f5989e && this.f5988d == i6) {
                return;
            }
            this.f5989e = false;
            this.f5988d = Math.max(0, i6);
        }
        m4131H();
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1768a();

        public final int f6011c;

        public final int f6012d;

        public final boolean f6013e;

        public final boolean f6014f;

        public final boolean f6015g;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f6011c = parcel.readInt();
            this.f6012d = parcel.readInt();
            this.f6013e = parcel.readInt() == 1;
            this.f6014f = parcel.readInt() == 1;
            this.f6015g = parcel.readInt() == 1;
        }

        @Override
        public final void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.f6011c);
            parcel.writeInt(this.f6012d);
            parcel.writeInt(this.f6013e ? 1 : 0);
            parcel.writeInt(this.f6014f ? 1 : 0);
            parcel.writeInt(this.f6015g ? 1 : 0);
        }

        public SavedState(android.view.AbsSavedState absSavedState, BottomSheetBehavior bottomSheetBehavior) {
            super(absSavedState);
            this.f6011c = bottomSheetBehavior.f5967J;
            this.f6012d = bottomSheetBehavior.f5988d;
            this.f6013e = bottomSheetBehavior.f5986b;
            this.f6014f = bottomSheetBehavior.f5964G;
            this.f6015g = bottomSheetBehavior.f5965H;
        }
    }

    public BottomSheetBehavior() {
        this.f5984a = 0;
        this.f5986b = true;
        this.f5994j = -1;
        this.f5995k = -1;
        this.f6009y = new C1400c(this);
        this.f5961D = 0.5f;
        this.f5963F = -1.0f;
        this.f5966I = true;
        this.f5967J = 4;
        this.f5977T = new ArrayList();
        this.f5983Z = -1;
        this.f5985a0 = new C1398a(this);
    }

    @Override
    public final void mo930l(CoordinatorLayout coordinatorLayout, View view, int i6, int i10, int i11, int[] iArr) {
    }
}

package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import com.bumptech.glide.AbstractC1466d;
import com.google.android.material.internal.AbstractC1811a0;
import com.google.android.material.internal.AbstractC1818e;
import com.google.android.material.internal.C1816d;
import com.p2serv.android.p032ds.R;
import com.youth.banner.config.BannerConfig;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p001a0.C0019b;
import p007a7.C0066c;
import p034d0.AbstractC2115a;
import p100j6.C2779a;
import p138n0.AbstractC3113e0;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3155s0;
import p138n0.C3153r1;
import p143n5.AbstractC3198d;
import p250x5.AbstractC4121a;
import p262y5.AbstractC4268a;
import p263y6.AbstractC4275a;

public class CollapsingToolbarLayout extends FrameLayout {

    public boolean f5810A;

    public int f5811B;

    public boolean f5812C;

    public boolean f5813a;

    public final int f5814b;

    public ViewGroup f5815c;

    public View f5816d;

    public View f5817e;

    public int f5818f;

    public int f5819g;

    public int f5820h;

    public int f5821i;

    public final Rect f5822j;

    public final C1816d f5823k;

    public final C2779a f5824l;

    public boolean f5825m;

    public boolean f5826n;

    public Drawable f5827o;

    public Drawable f5828p;

    public int f5829q;

    public boolean f5830r;

    public ValueAnimator f5831s;

    public long f5832t;

    public int f5833u;

    public C1755h f5834v;

    public int f5835w;

    public int f5836x;

    public C3153r1 f5837y;

    public int f5838z;

    public static class LayoutParams extends FrameLayout.LayoutParams {

        public int f5839a;

        public float f5840b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f5839a = 0;
            this.f5840b = 0.5f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4121a.f14001o);
            this.f5839a = typedArrayObtainStyledAttributes.getInt(0, 0);
            this.f5840b = typedArrayObtainStyledAttributes.getFloat(1, 0.5f);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.collapsingToolbarLayoutStyle);
    }

    public static C1757j m4088b(View view) {
        C1757j c1757j = (C1757j) view.getTag(R.id.view_offset_helper);
        if (c1757j != null) {
            return c1757j;
        }
        C1757j c1757j2 = new C1757j(view);
        view.setTag(R.id.view_offset_helper, c1757j2);
        return c1757j2;
    }

    public final void m4089a() {
        View view;
        if (this.f5813a) {
            ViewGroup viewGroup = null;
            this.f5815c = null;
            this.f5816d = null;
            int i6 = this.f5814b;
            if (i6 != -1) {
                ViewGroup viewGroup2 = (ViewGroup) findViewById(i6);
                this.f5815c = viewGroup2;
                if (viewGroup2 != null) {
                    ViewParent parent = viewGroup2.getParent();
                    while (true) {
                        if (parent == this) {
                            view = viewGroup2;
                            break;
                        } else {
                            if (parent == null) {
                                break;
                            }
                            if (parent instanceof View) {
                                view = (View) parent;
                            }
                            parent = parent.getParent();
                            view = view;
                        }
                    }
                    this.f5816d = view;
                }
            }
            if (this.f5815c == null) {
                int childCount = getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = getChildAt(i10);
                    if ((childAt instanceof Toolbar) || (childAt instanceof android.widget.Toolbar)) {
                        viewGroup = (ViewGroup) childAt;
                        break;
                    }
                }
                this.f5815c = viewGroup;
            }
            m4090c();
            this.f5813a = false;
        }
    }

    public final void m4090c() {
        View view;
        if (!this.f5825m && (view = this.f5817e) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f5817e);
            }
        }
        if (!this.f5825m || this.f5815c == null) {
            return;
        }
        if (this.f5817e == null) {
            this.f5817e = new View(getContext());
        }
        if (this.f5817e.getParent() == null) {
            this.f5815c.addView(this.f5817e, -1, -1);
        }
    }

    @Override
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final void m4091d() {
        if (this.f5827o == null && this.f5828p == null) {
            return;
        }
        setScrimsShown(getHeight() + this.f5835w < getScrimVisibleHeightTrigger());
    }

    @Override
    public final void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        m4089a();
        if (this.f5815c == null && (drawable = this.f5827o) != null && this.f5829q > 0) {
            drawable.mutate().setAlpha(this.f5829q);
            this.f5827o.draw(canvas);
        }
        if (this.f5825m && this.f5826n) {
            ViewGroup viewGroup = this.f5815c;
            C1816d c1816d = this.f5823k;
            if (viewGroup == null || this.f5827o == null || this.f5829q <= 0 || this.f5836x != 1 || c1816d.f6395c >= c1816d.f6401f) {
                c1816d.m4260d(canvas);
            } else {
                int iSave = canvas.save();
                canvas.clipRect(this.f5827o.getBounds(), Region.Op.DIFFERENCE);
                c1816d.m4260d(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        if (this.f5828p == null || this.f5829q <= 0) {
            return;
        }
        C3153r1 c3153r1 = this.f5837y;
        int iM6328d = c3153r1 != null ? c3153r1.m6328d() : 0;
        if (iM6328d > 0) {
            this.f5828p.setBounds(0, -this.f5835w, getWidth(), iM6328d - this.f5835w);
            this.f5828p.mutate().setAlpha(this.f5829q);
            this.f5828p.draw(canvas);
        }
    }

    @Override
    public final boolean drawChild(Canvas canvas, View view, long j10) {
        boolean z7;
        View view2;
        Drawable drawable = this.f5827o;
        if (drawable == null || this.f5829q <= 0 || ((view2 = this.f5816d) == null || view2 == this ? view != this.f5815c : view != view2)) {
            z7 = false;
        } else {
            int width = getWidth();
            int height = getHeight();
            if (this.f5836x == 1 && view != null && this.f5825m) {
                height = view.getBottom();
            }
            drawable.setBounds(0, 0, width, height);
            this.f5827o.mutate().setAlpha(this.f5829q);
            this.f5827o.draw(canvas);
            z7 = true;
        }
        return super.drawChild(canvas, view, j10) || z7;
    }

    @Override
    public final void drawableStateChanged() {
        ColorStateList colorStateList;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f5828p;
        boolean z7 = false;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f5827o;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        C1816d c1816d = this.f5823k;
        if (c1816d != null) {
            c1816d.f6382R = drawableState;
            ColorStateList colorStateList2 = c1816d.f6421p;
            if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = c1816d.f6419o) != null && colorStateList.isStateful())) {
                c1816d.m4265j(false);
                z7 = true;
            }
            state |= z7;
        }
        if (state) {
            invalidate();
        }
    }

    public final void m4092e(int i6, int i10, int i11, int i12, boolean z7) {
        View view;
        int titleMarginBottom;
        int titleMarginEnd;
        int titleMarginTop;
        if (!this.f5825m || (view = this.f5817e) == null) {
            return;
        }
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        int titleMarginStart = 0;
        boolean z10 = view.isAttachedToWindow() && this.f5817e.getVisibility() == 0;
        this.f5826n = z10;
        if (z10 || z7) {
            boolean z11 = getLayoutDirection() == 1;
            View view2 = this.f5816d;
            if (view2 == null) {
                view2 = this.f5815c;
            }
            int height = ((getHeight() - m4088b(view2).f5878b) - view2.getHeight()) - ((FrameLayout.LayoutParams) ((LayoutParams) view2.getLayoutParams())).bottomMargin;
            View view3 = this.f5817e;
            Rect rect = this.f5822j;
            AbstractC1818e.m4274a(this, view3, rect);
            ViewGroup viewGroup = this.f5815c;
            if (viewGroup instanceof Toolbar) {
                Toolbar toolbar = (Toolbar) viewGroup;
                titleMarginStart = toolbar.getTitleMarginStart();
                titleMarginEnd = toolbar.getTitleMarginEnd();
                titleMarginTop = toolbar.getTitleMarginTop();
                titleMarginBottom = toolbar.getTitleMarginBottom();
            } else if (Build.VERSION.SDK_INT < 24 || !(viewGroup instanceof android.widget.Toolbar)) {
                titleMarginBottom = 0;
                titleMarginEnd = 0;
                titleMarginTop = 0;
            } else {
                android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
                titleMarginStart = toolbar2.getTitleMarginStart();
                titleMarginEnd = toolbar2.getTitleMarginEnd();
                titleMarginTop = toolbar2.getTitleMarginTop();
                titleMarginBottom = toolbar2.getTitleMarginBottom();
            }
            int i13 = rect.left + (z11 ? titleMarginEnd : titleMarginStart);
            int i14 = rect.top + height + titleMarginTop;
            int i15 = rect.right;
            if (!z11) {
                titleMarginStart = titleMarginEnd;
            }
            int i16 = i15 - titleMarginStart;
            int i17 = (rect.bottom + height) - titleMarginBottom;
            C1816d c1816d = this.f5823k;
            Rect rect2 = c1816d.f6407i;
            if (rect2.left != i13 || rect2.top != i14 || rect2.right != i16 || rect2.bottom != i17) {
                rect2.set(i13, i14, i16, i17);
                c1816d.f6383S = true;
                c1816d.m4264i();
            }
            int i18 = z11 ? this.f5820h : this.f5818f;
            int i19 = rect.top + this.f5819g;
            int i20 = (i11 - i6) - (z11 ? this.f5818f : this.f5820h);
            int i21 = (i12 - i10) - this.f5821i;
            Rect rect3 = c1816d.f6405h;
            if (rect3.left != i18 || rect3.top != i19 || rect3.right != i20 || rect3.bottom != i21) {
                rect3.set(i18, i19, i20, i21);
                c1816d.f6383S = true;
                c1816d.m4264i();
            }
            c1816d.m4265j(z7);
        }
    }

    public final void m4093f() {
        CharSequence title;
        if (this.f5815c != null && this.f5825m && TextUtils.isEmpty(this.f5823k.f6371G)) {
            ViewGroup viewGroup = this.f5815c;
            if (viewGroup instanceof Toolbar) {
                title = ((Toolbar) viewGroup).getTitle();
            } else {
                title = viewGroup instanceof android.widget.Toolbar ? ((android.widget.Toolbar) viewGroup).getTitle() : null;
            }
            setTitle(title);
        }
    }

    @Override
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.f5839a = 0;
        layoutParams.f5840b = 0.5f;
        return layoutParams;
    }

    public int getCollapsedTitleGravity() {
        return this.f5823k.f6413l;
    }

    public Typeface getCollapsedTitleTypeface() {
        Typeface typeface = this.f5823k.f6431x;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public Drawable getContentScrim() {
        return this.f5827o;
    }

    public int getExpandedTitleGravity() {
        return this.f5823k.f6411k;
    }

    public int getExpandedTitleMarginBottom() {
        return this.f5821i;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f5820h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f5818f;
    }

    public int getExpandedTitleMarginTop() {
        return this.f5819g;
    }

    public Typeface getExpandedTitleTypeface() {
        Typeface typeface = this.f5823k.f6365A;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public int getHyphenationFrequency() {
        return this.f5823k.f6424q0;
    }

    public int getLineCount() {
        StaticLayout staticLayout = this.f5823k.f6408i0;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    public float getLineSpacingAdd() {
        return this.f5823k.f6408i0.getSpacingAdd();
    }

    public float getLineSpacingMultiplier() {
        return this.f5823k.f6408i0.getSpacingMultiplier();
    }

    public int getMaxLines() {
        return this.f5823k.f6418n0;
    }

    public int getScrimAlpha() {
        return this.f5829q;
    }

    public long getScrimAnimationDuration() {
        return this.f5832t;
    }

    public int getScrimVisibleHeightTrigger() {
        int i6 = this.f5833u;
        if (i6 >= 0) {
            return i6 + this.f5838z + this.f5811B;
        }
        C3153r1 c3153r1 = this.f5837y;
        int iM6328d = c3153r1 != null ? c3153r1.m6328d() : 0;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        int minimumHeight = getMinimumHeight();
        return minimumHeight > 0 ? Math.min((minimumHeight * 2) + iM6328d, getHeight()) : getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.f5828p;
    }

    public CharSequence getTitle() {
        if (this.f5825m) {
            return this.f5823k.f6371G;
        }
        return null;
    }

    public int getTitleCollapseMode() {
        return this.f5836x;
    }

    public TimeInterpolator getTitlePositionInterpolator() {
        return this.f5823k.f6386V;
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            if (this.f5836x == 1) {
                appBarLayout.setLiftOnScroll(false);
            }
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            setFitsSystemWindows(appBarLayout.getFitsSystemWindows());
            if (this.f5834v == null) {
                this.f5834v = new C1755h(this);
            }
            C1755h c1755h = this.f5834v;
            if (appBarLayout.f5784h == null) {
                appBarLayout.f5784h = new ArrayList();
            }
            if (c1755h != null && !appBarLayout.f5784h.contains(c1755h)) {
                appBarLayout.f5784h.add(c1755h);
            }
            AbstractC3113e0.m6130c(this);
        }
    }

    @Override
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f5823k.m4263h(configuration);
    }

    @Override
    public final void onDetachedFromWindow() {
        ArrayList arrayList;
        ViewParent parent = getParent();
        C1755h c1755h = this.f5834v;
        if (c1755h != null && (parent instanceof AppBarLayout) && (arrayList = ((AppBarLayout) parent).f5784h) != null) {
            arrayList.remove(c1755h);
        }
        super.onDetachedFromWindow();
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        super.onLayout(z7, i6, i10, i11, i12);
        C3153r1 c3153r1 = this.f5837y;
        if (c3153r1 != null) {
            int iM6328d = c3153r1.m6328d();
            int childCount = getChildCount();
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = getChildAt(i13);
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                if (!childAt.getFitsSystemWindows() && childAt.getTop() < iM6328d) {
                    AbstractC3155s0.m6340j(iM6328d, childAt);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i14 = 0; i14 < childCount2; i14++) {
            C1757j c1757jM4088b = m4088b(getChildAt(i14));
            View view = c1757jM4088b.f5877a;
            c1757jM4088b.f5878b = view.getTop();
            c1757jM4088b.f5879c = view.getLeft();
        }
        m4092e(i6, i10, i11, i12, false);
        m4093f();
        m4091d();
        int childCount3 = getChildCount();
        for (int i15 = 0; i15 < childCount3; i15++) {
            m4088b(getChildAt(i15)).m4099a();
        }
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        int measuredHeight;
        int measuredHeight2;
        m4089a();
        super.onMeasure(i6, i10);
        int mode = View.MeasureSpec.getMode(i10);
        C3153r1 c3153r1 = this.f5837y;
        int iM6328d = c3153r1 != null ? c3153r1.m6328d() : 0;
        if ((mode == 0 || this.f5810A) && iM6328d > 0) {
            this.f5838z = iM6328d;
            super.onMeasure(i6, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + iM6328d, 1073741824));
        }
        if (this.f5812C) {
            C1816d c1816d = this.f5823k;
            if (c1816d.f6418n0 > 1) {
                m4093f();
                m4092e(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
                int i11 = c1816d.f6423q;
                if (i11 > 1) {
                    TextPaint textPaint = c1816d.f6385U;
                    textPaint.setTextSize(c1816d.f6415m);
                    textPaint.setTypeface(c1816d.f6365A);
                    textPaint.setLetterSpacing(c1816d.f6404g0);
                    this.f5811B = (i11 - 1) * Math.round(textPaint.descent() + (-textPaint.ascent()));
                    super.onMeasure(i6, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.f5811B, 1073741824));
                }
            }
        }
        ViewGroup viewGroup = this.f5815c;
        if (viewGroup != null) {
            View view = this.f5816d;
            if (view == null || view == this) {
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    measuredHeight = viewGroup.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                } else {
                    measuredHeight = viewGroup.getMeasuredHeight();
                }
                setMinimumHeight(measuredHeight);
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                measuredHeight2 = view.getMeasuredHeight() + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
            } else {
                measuredHeight2 = view.getMeasuredHeight();
            }
            setMinimumHeight(measuredHeight2);
        }
    }

    @Override
    public final void onSizeChanged(int i6, int i10, int i11, int i12) {
        super.onSizeChanged(i6, i10, i11, i12);
        Drawable drawable = this.f5827o;
        if (drawable != null) {
            ViewGroup viewGroup = this.f5815c;
            if (this.f5836x == 1 && viewGroup != null && this.f5825m) {
                i10 = viewGroup.getBottom();
            }
            drawable.setBounds(0, 0, i6, i10);
        }
    }

    public void setCollapsedTitleGravity(int i6) {
        this.f5823k.m4268m(i6);
    }

    public void setCollapsedTitleTextAppearance(int i6) {
        this.f5823k.m4266k(i6);
    }

    public void setCollapsedTitleTextColor(int i6) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i6));
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        C1816d c1816d = this.f5823k;
        if (c1816d.m4269n(typeface)) {
            c1816d.m4265j(false);
        }
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.f5827o;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f5827o = drawableMutate;
            if (drawableMutate != null) {
                int width = getWidth();
                int height = getHeight();
                ViewGroup viewGroup = this.f5815c;
                if (this.f5836x == 1 && viewGroup != null && this.f5825m) {
                    height = viewGroup.getBottom();
                }
                drawableMutate.setBounds(0, 0, width, height);
                this.f5827o.setCallback(this);
                this.f5827o.setAlpha(this.f5829q);
            }
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            postInvalidateOnAnimation();
        }
    }

    public void setContentScrimColor(int i6) {
        setContentScrim(new ColorDrawable(i6));
    }

    public void setContentScrimResource(int i6) {
        setContentScrim(AbstractC2115a.m5069b(getContext(), i6));
    }

    public void setExpandedTitleColor(int i6) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i6));
    }

    public void setExpandedTitleGravity(int i6) {
        C1816d c1816d = this.f5823k;
        if (c1816d.f6411k != i6) {
            c1816d.f6411k = i6;
            c1816d.m4265j(false);
        }
    }

    public void setExpandedTitleMarginBottom(int i6) {
        this.f5821i = i6;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i6) {
        this.f5820h = i6;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i6) {
        this.f5818f = i6;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i6) {
        this.f5819g = i6;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i6) {
        this.f5823k.m4270o(i6);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        C1816d c1816d = this.f5823k;
        if (c1816d.f6419o != colorStateList) {
            c1816d.f6419o = colorStateList;
            c1816d.m4265j(false);
        }
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        C1816d c1816d = this.f5823k;
        if (c1816d.m4271p(typeface)) {
            c1816d.m4265j(false);
        }
    }

    public void setExtraMultilineHeightEnabled(boolean z7) {
        this.f5812C = z7;
    }

    public void setForceApplySystemWindowInsetTop(boolean z7) {
        this.f5810A = z7;
    }

    public void setHyphenationFrequency(int i6) {
        this.f5823k.f6424q0 = i6;
    }

    public void setLineSpacingAdd(float f) {
        this.f5823k.f6420o0 = f;
    }

    public void setLineSpacingMultiplier(float f) {
        this.f5823k.f6422p0 = f;
    }

    public void setMaxLines(int i6) {
        C1816d c1816d = this.f5823k;
        if (i6 != c1816d.f6418n0) {
            c1816d.f6418n0 = i6;
            Bitmap bitmap = c1816d.f6375K;
            if (bitmap != null) {
                bitmap.recycle();
                c1816d.f6375K = null;
            }
            c1816d.m4265j(false);
        }
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean z7) {
        this.f5823k.f6374J = z7;
    }

    public void setScrimAlpha(int i6) {
        ViewGroup viewGroup;
        if (i6 != this.f5829q) {
            if (this.f5827o != null && (viewGroup = this.f5815c) != null) {
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                viewGroup.postInvalidateOnAnimation();
            }
            this.f5829q = i6;
            WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
            postInvalidateOnAnimation();
        }
    }

    public void setScrimAnimationDuration(long j10) {
        this.f5832t = j10;
    }

    public void setScrimVisibleHeightTrigger(int i6) {
        if (this.f5833u != i6) {
            this.f5833u = i6;
            m4091d();
        }
    }

    public void setScrimsShown(boolean z7) {
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        boolean z10 = isLaidOut() && !isInEditMode();
        if (this.f5830r != z7) {
            if (z10) {
                int i6 = z7 ? 255 : 0;
                m4089a();
                ValueAnimator valueAnimator = this.f5831s;
                if (valueAnimator == null) {
                    ValueAnimator valueAnimator2 = new ValueAnimator();
                    this.f5831s = valueAnimator2;
                    valueAnimator2.setInterpolator(i6 > this.f5829q ? AbstractC4268a.f14471c : AbstractC4268a.f14472d);
                    this.f5831s.addUpdateListener(new C0066c(2, this));
                } else if (valueAnimator.isRunning()) {
                    this.f5831s.cancel();
                }
                this.f5831s.setDuration(this.f5832t);
                this.f5831s.setIntValues(this.f5829q, i6);
                this.f5831s.start();
            } else {
                setScrimAlpha(z7 ? 255 : 0);
            }
            this.f5830r = z7;
        }
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.f5828p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f5828p = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f5828p.setState(getDrawableState());
                }
                Drawable drawable3 = this.f5828p;
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                AbstractC3198d.m6442Q(drawable3, getLayoutDirection());
                this.f5828p.setVisible(getVisibility() == 0, false);
                this.f5828p.setCallback(this);
                this.f5828p.setAlpha(this.f5829q);
            }
            WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarScrimColor(int i6) {
        setStatusBarScrim(new ColorDrawable(i6));
    }

    public void setStatusBarScrimResource(int i6) {
        setStatusBarScrim(AbstractC2115a.m5069b(getContext(), i6));
    }

    public void setTitle(CharSequence charSequence) {
        C1816d c1816d = this.f5823k;
        if (charSequence == null || !TextUtils.equals(c1816d.f6371G, charSequence)) {
            c1816d.f6371G = charSequence;
            c1816d.f6372H = null;
            Bitmap bitmap = c1816d.f6375K;
            if (bitmap != null) {
                bitmap.recycle();
                c1816d.f6375K = null;
            }
            c1816d.m4265j(false);
        }
        setContentDescription(getTitle());
    }

    public void setTitleCollapseMode(int i6) {
        this.f5836x = i6;
        boolean z7 = i6 == 1;
        this.f5823k.f6397d = z7;
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            if (this.f5836x == 1) {
                appBarLayout.setLiftOnScroll(false);
            }
        }
        if (z7 && this.f5827o == null) {
            float dimension = getResources().getDimension(R.dimen.design_appbar_elevation);
            C2779a c2779a = this.f5824l;
            setContentScrimColor(c2779a.m5749a(c2779a.f9496d, dimension));
        }
    }

    public void setTitleEnabled(boolean z7) {
        if (z7 != this.f5825m) {
            this.f5825m = z7;
            setContentDescription(getTitle());
            m4090c();
            requestLayout();
        }
    }

    public void setTitlePositionInterpolator(TimeInterpolator timeInterpolator) {
        C1816d c1816d = this.f5823k;
        c1816d.f6386V = timeInterpolator;
        c1816d.m4265j(false);
    }

    @Override
    public void setVisibility(int i6) {
        super.setVisibility(i6);
        boolean z7 = i6 == 0;
        Drawable drawable = this.f5828p;
        if (drawable != null && drawable.isVisible() != z7) {
            this.f5828p.setVisible(z7, false);
        }
        Drawable drawable2 = this.f5827o;
        if (drawable2 == null || drawable2.isVisible() == z7) {
            return;
        }
        this.f5827o.setVisible(z7, false);
    }

    @Override
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f5827o || drawable == this.f5828p;
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i6) {
        int i10;
        ColorStateList colorStateListM3493k;
        super(AbstractC4275a.m8323a(context, attributeSet, i6, R.style.Widget_Design_CollapsingToolbar), attributeSet, i6);
        int i11 = 14;
        this.f5813a = true;
        this.f5822j = new Rect();
        this.f5833u = -1;
        this.f5838z = 0;
        this.f5811B = 0;
        Context context2 = getContext();
        C1816d c1816d = new C1816d(this);
        this.f5823k = c1816d;
        c1816d.f6387W = AbstractC4268a.f14473e;
        c1816d.m4265j(false);
        c1816d.f6374J = false;
        this.f5824l = new C2779a(context2);
        int[] iArr = AbstractC4121a.f14000n;
        AbstractC1811a0.m4241a(context2, attributeSet, i6, R.style.Widget_Design_CollapsingToolbar);
        AbstractC1811a0.m4242b(context2, attributeSet, iArr, i6, R.style.Widget_Design_CollapsingToolbar, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i6, R.style.Widget_Design_CollapsingToolbar);
        int i12 = typedArrayObtainStyledAttributes.getInt(4, 8388691);
        if (c1816d.f6411k != i12) {
            c1816d.f6411k = i12;
            c1816d.m4265j(false);
        }
        c1816d.m4268m(typedArrayObtainStyledAttributes.getInt(0, 8388627));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.f5821i = dimensionPixelSize;
        this.f5820h = dimensionPixelSize;
        this.f5819g = dimensionPixelSize;
        this.f5818f = dimensionPixelSize;
        if (typedArrayObtainStyledAttributes.hasValue(8)) {
            this.f5818f = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(7)) {
            this.f5820h = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(9)) {
            this.f5819g = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, 0);
        }
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            this.f5821i = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0);
        }
        this.f5825m = typedArrayObtainStyledAttributes.getBoolean(20, true);
        setTitle(typedArrayObtainStyledAttributes.getText(18));
        c1816d.m4270o(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        c1816d.m4266k(R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (typedArrayObtainStyledAttributes.hasValue(10)) {
            c1816d.m4270o(typedArrayObtainStyledAttributes.getResourceId(10, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            c1816d.m4266k(typedArrayObtainStyledAttributes.getResourceId(1, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(11) && c1816d.f6419o != (colorStateListM3493k = AbstractC1466d.m3493k(context2, typedArrayObtainStyledAttributes, 11))) {
            c1816d.f6419o = colorStateListM3493k;
            c1816d.m4265j(false);
        }
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            c1816d.m4267l(AbstractC1466d.m3493k(context2, typedArrayObtainStyledAttributes, 2));
        }
        this.f5833u = typedArrayObtainStyledAttributes.getDimensionPixelSize(16, -1);
        if (typedArrayObtainStyledAttributes.hasValue(14) && (i10 = typedArrayObtainStyledAttributes.getInt(14, 1)) != c1816d.f6418n0) {
            c1816d.f6418n0 = i10;
            Bitmap bitmap = c1816d.f6375K;
            if (bitmap != null) {
                bitmap.recycle();
                c1816d.f6375K = null;
            }
            c1816d.m4265j(false);
        }
        if (typedArrayObtainStyledAttributes.hasValue(21)) {
            c1816d.f6386V = AnimationUtils.loadInterpolator(context2, typedArrayObtainStyledAttributes.getResourceId(21, 0));
            c1816d.m4265j(false);
        }
        this.f5832t = typedArrayObtainStyledAttributes.getInt(15, BannerConfig.SCROLL_TIME);
        setContentScrim(typedArrayObtainStyledAttributes.getDrawable(3));
        setStatusBarScrim(typedArrayObtainStyledAttributes.getDrawable(17));
        setTitleCollapseMode(typedArrayObtainStyledAttributes.getInt(19, 0));
        this.f5814b = typedArrayObtainStyledAttributes.getResourceId(22, -1);
        this.f5810A = typedArrayObtainStyledAttributes.getBoolean(13, false);
        this.f5812C = typedArrayObtainStyledAttributes.getBoolean(12, false);
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(false);
        C0019b c0019b = new C0019b(i11, this);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        AbstractC3119g0.m6182u(this, c0019b);
    }

    @Override
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.f5823k.m4267l(colorStateList);
    }

    @Override
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2 = new LayoutParams(layoutParams);
        layoutParams2.f5839a = 0;
        layoutParams2.f5840b = 0.5f;
        return layoutParams2;
    }

    @Override
    public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.f5839a = 0;
        layoutParams.f5840b = 0.5f;
        return layoutParams;
    }
}

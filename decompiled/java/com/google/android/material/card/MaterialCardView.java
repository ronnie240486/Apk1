package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.cardview.widget.CardView;
import com.bumptech.glide.AbstractC1465c;
import com.bumptech.glide.AbstractC1466d;
import com.google.android.material.internal.AbstractC1811a0;
import p040d6.C2159c;
import p040d6.InterfaceC2157a;
import p065g0.AbstractC2581a;
import p156o9.AbstractC3280d;
import p156o9.AbstractC3281e;
import p201s6.AbstractC3722c;
import p221u6.C3908h;
import p221u6.C3912l;
import p221u6.C3913m;
import p221u6.InterfaceC3924x;
import p222u7.AbstractC3928d;
import p250x5.AbstractC4121a;
import p263y6.AbstractC4275a;

public class MaterialCardView extends CardView implements Checkable, InterfaceC3924x {

    public static final int[] f6070l = {R.attr.state_checkable};

    public static final int[] f6071m = {R.attr.state_checked};

    public static final int[] f6072n = {com.p2serv.android.p032ds.R.attr.state_dragged};

    public final C2159c f6073h;

    public final boolean f6074i;

    public boolean f6075j;

    public boolean f6076k;

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.p2serv.android.p032ds.R.attr.materialCardViewStyle);
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f6073h.f7805c.getBounds());
        return rectF;
    }

    public final void m4154b() {
        C2159c c2159c;
        RippleDrawable rippleDrawable;
        if (Build.VERSION.SDK_INT <= 26 || (rippleDrawable = (c2159c = this.f6073h).f7817o) == null) {
            return;
        }
        Rect bounds = rippleDrawable.getBounds();
        int i6 = bounds.bottom;
        c2159c.f7817o.setBounds(bounds.left, bounds.top, bounds.right, i6 - 1);
        c2159c.f7817o.setBounds(bounds.left, bounds.top, bounds.right, i6);
    }

    @Override
    public ColorStateList getCardBackgroundColor() {
        return this.f6073h.f7805c.f13126a.f13109c;
    }

    public ColorStateList getCardForegroundColor() {
        return this.f6073h.f7806d.f13126a.f13109c;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.f6073h.f7812j;
    }

    public int getCheckedIconGravity() {
        return this.f6073h.f7809g;
    }

    public int getCheckedIconMargin() {
        return this.f6073h.f7807e;
    }

    public int getCheckedIconSize() {
        return this.f6073h.f7808f;
    }

    public ColorStateList getCheckedIconTint() {
        return this.f6073h.f7814l;
    }

    @Override
    public int getContentPaddingBottom() {
        return this.f6073h.f7804b.bottom;
    }

    @Override
    public int getContentPaddingLeft() {
        return this.f6073h.f7804b.left;
    }

    @Override
    public int getContentPaddingRight() {
        return this.f6073h.f7804b.right;
    }

    @Override
    public int getContentPaddingTop() {
        return this.f6073h.f7804b.top;
    }

    public float getProgress() {
        return this.f6073h.f7805c.f13126a.f13115i;
    }

    @Override
    public float getRadius() {
        return this.f6073h.f7805c.m7804i();
    }

    public ColorStateList getRippleColor() {
        return this.f6073h.f7813k;
    }

    public C3913m getShapeAppearanceModel() {
        return this.f6073h.f7815m;
    }

    @Deprecated
    public int getStrokeColor() {
        ColorStateList colorStateList = this.f6073h.f7816n;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.f6073h.f7816n;
    }

    public int getStrokeWidth() {
        return this.f6073h.f7810h;
    }

    @Override
    public final boolean isChecked() {
        return this.f6075j;
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC3280d.m6567D(this, this.f6073h.f7805c);
    }

    @Override
    public final int[] onCreateDrawableState(int i6) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i6 + 3);
        C2159c c2159c = this.f6073h;
        if (c2159c != null && c2159c.f7821s) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f6070l);
        }
        if (this.f6075j) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f6071m);
        }
        if (this.f6076k) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f6072n);
        }
        return iArrOnCreateDrawableState;
    }

    @Override
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(this.f6075j);
    }

    @Override
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        C2159c c2159c = this.f6073h;
        accessibilityNodeInfo.setCheckable(c2159c != null && c2159c.f7821s);
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(this.f6075j);
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        super.onMeasure(i6, i10);
        this.f6073h.m5092e(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f6074i) {
            C2159c c2159c = this.f6073h;
            if (!c2159c.f7820r) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                c2159c.f7820r = true;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.f6073h.f7805c.m7809n(colorStateList);
    }

    @Override
    public void setCardElevation(float f) {
        super.setCardElevation(f);
        C2159c c2159c = this.f6073h;
        c2159c.f7805c.m7808m(c2159c.f7803a.getCardElevation());
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        C3908h c3908h = this.f6073h.f7806d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        c3908h.m7809n(colorStateList);
    }

    public void setCheckable(boolean z7) {
        this.f6073h.f7821s = z7;
    }

    @Override
    public void setChecked(boolean z7) {
        if (this.f6075j != z7) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.f6073h.m5093f(drawable);
    }

    public void setCheckedIconGravity(int i6) {
        C2159c c2159c = this.f6073h;
        if (c2159c.f7809g != i6) {
            c2159c.f7809g = i6;
            MaterialCardView materialCardView = c2159c.f7803a;
            c2159c.m5092e(materialCardView.getMeasuredWidth(), materialCardView.getMeasuredHeight());
        }
    }

    public void setCheckedIconMargin(int i6) {
        this.f6073h.f7807e = i6;
    }

    public void setCheckedIconMarginResource(int i6) {
        if (i6 != -1) {
            this.f6073h.f7807e = getResources().getDimensionPixelSize(i6);
        }
    }

    public void setCheckedIconResource(int i6) {
        this.f6073h.m5093f(AbstractC1465c.m3473h(getContext(), i6));
    }

    public void setCheckedIconSize(int i6) {
        this.f6073h.f7808f = i6;
    }

    public void setCheckedIconSizeResource(int i6) {
        if (i6 != 0) {
            this.f6073h.f7808f = getResources().getDimensionPixelSize(i6);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        C2159c c2159c = this.f6073h;
        c2159c.f7814l = colorStateList;
        Drawable drawable = c2159c.f7812j;
        if (drawable != null) {
            AbstractC2581a.m5586h(drawable, colorStateList);
        }
    }

    @Override
    public void setClickable(boolean z7) {
        super.setClickable(z7);
        C2159c c2159c = this.f6073h;
        if (c2159c != null) {
            Drawable drawable = c2159c.f7811i;
            MaterialCardView materialCardView = c2159c.f7803a;
            Drawable drawableM5090c = materialCardView.isClickable() ? c2159c.m5090c() : c2159c.f7806d;
            c2159c.f7811i = drawableM5090c;
            if (drawable != drawableM5090c) {
                if (Build.VERSION.SDK_INT < 23 || !(materialCardView.getForeground() instanceof InsetDrawable)) {
                    materialCardView.setForeground(c2159c.m5091d(drawableM5090c));
                } else {
                    ((InsetDrawable) materialCardView.getForeground()).setDrawable(drawableM5090c);
                }
            }
        }
    }

    public void setDragged(boolean z7) {
        if (this.f6076k != z7) {
            this.f6076k = z7;
            refreshDrawableState();
            m4154b();
            invalidate();
        }
    }

    @Override
    public void setMaxCardElevation(float f) {
        super.setMaxCardElevation(f);
        this.f6073h.m5097j();
    }

    @Override
    public void setPreventCornerOverlap(boolean z7) {
        super.setPreventCornerOverlap(z7);
        C2159c c2159c = this.f6073h;
        c2159c.m5097j();
        c2159c.m5096i();
    }

    public void setProgress(float f) {
        C2159c c2159c = this.f6073h;
        c2159c.f7805c.m7810o(f);
        C3908h c3908h = c2159c.f7806d;
        if (c3908h != null) {
            c3908h.m7810o(f);
        }
        C3908h c3908h2 = c2159c.f7819q;
        if (c3908h2 != null) {
            c3908h2.m7810o(f);
        }
    }

    @Override
    public void setRadius(float f) {
        super.setRadius(f);
        C2159c c2159c = this.f6073h;
        C3912l c3912lM7826f = c2159c.f7815m.m7826f();
        c3912lM7826f.m7820c(f);
        c2159c.m5094g(c3912lM7826f.m7819a());
        c2159c.f7811i.invalidateSelf();
        if (c2159c.m5095h() || (c2159c.f7803a.getPreventCornerOverlap() && !c2159c.f7805c.m7807l())) {
            c2159c.m5096i();
        }
        if (c2159c.m5095h()) {
            c2159c.m5097j();
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        C2159c c2159c = this.f6073h;
        c2159c.f7813k = colorStateList;
        int[] iArr = AbstractC3722c.f12475a;
        RippleDrawable rippleDrawable = c2159c.f7817o;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(colorStateList);
        }
    }

    public void setRippleColorResource(int i6) {
        ColorStateList colorStateListM7848k = AbstractC3928d.m7848k(getContext(), i6);
        C2159c c2159c = this.f6073h;
        c2159c.f7813k = colorStateListM7848k;
        int[] iArr = AbstractC3722c.f12475a;
        RippleDrawable rippleDrawable = c2159c.f7817o;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(colorStateListM7848k);
        }
    }

    @Override
    public void setShapeAppearanceModel(C3913m c3913m) {
        setClipToOutline(c3913m.m7825e(getBoundsAsRectF()));
        this.f6073h.m5094g(c3913m);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        C2159c c2159c = this.f6073h;
        if (c2159c.f7816n != colorStateList) {
            c2159c.f7816n = colorStateList;
            C3908h c3908h = c2159c.f7806d;
            c3908h.f13126a.f13116j = c2159c.f7810h;
            c3908h.invalidateSelf();
            c3908h.m7814s(colorStateList);
        }
        invalidate();
    }

    public void setStrokeWidth(int i6) {
        C2159c c2159c = this.f6073h;
        if (i6 != c2159c.f7810h) {
            c2159c.f7810h = i6;
            C3908h c3908h = c2159c.f7806d;
            ColorStateList colorStateList = c2159c.f7816n;
            c3908h.f13126a.f13116j = i6;
            c3908h.invalidateSelf();
            c3908h.m7814s(colorStateList);
        }
        invalidate();
    }

    @Override
    public void setUseCompatPadding(boolean z7) {
        super.setUseCompatPadding(z7);
        C2159c c2159c = this.f6073h;
        c2159c.m5097j();
        c2159c.m5096i();
    }

    @Override
    public final void toggle() {
        C2159c c2159c = this.f6073h;
        if (c2159c != null && c2159c.f7821s && isEnabled()) {
            this.f6075j = !this.f6075j;
            refreshDrawableState();
            m4154b();
            boolean z7 = this.f6075j;
            Drawable drawable = c2159c.f7812j;
            if (drawable != null) {
                drawable.setAlpha(z7 ? 255 : 0);
            }
        }
    }

    public MaterialCardView(Context context, AttributeSet attributeSet, int i6) {
        super(AbstractC4275a.m8323a(context, attributeSet, i6, com.p2serv.android.p032ds.R.style.Widget_MaterialComponents_CardView), attributeSet, i6);
        this.f6075j = false;
        this.f6076k = false;
        this.f6074i = true;
        TypedArray typedArrayM4250j = AbstractC1811a0.m4250j(getContext(), attributeSet, AbstractC4121a.f13959C, i6, com.p2serv.android.p032ds.R.style.Widget_MaterialComponents_CardView, new int[0]);
        C2159c c2159c = new C2159c(this, attributeSet, i6);
        this.f6073h = c2159c;
        ColorStateList cardBackgroundColor = super.getCardBackgroundColor();
        C3908h c3908h = c2159c.f7805c;
        c3908h.m7809n(cardBackgroundColor);
        c2159c.f7804b.set(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        c2159c.m5096i();
        MaterialCardView materialCardView = c2159c.f7803a;
        ColorStateList colorStateListM3493k = AbstractC1466d.m3493k(materialCardView.getContext(), typedArrayM4250j, 11);
        c2159c.f7816n = colorStateListM3493k;
        if (colorStateListM3493k == null) {
            c2159c.f7816n = ColorStateList.valueOf(-1);
        }
        c2159c.f7810h = typedArrayM4250j.getDimensionPixelSize(12, 0);
        boolean z7 = typedArrayM4250j.getBoolean(0, false);
        c2159c.f7821s = z7;
        materialCardView.setLongClickable(z7);
        c2159c.f7814l = AbstractC1466d.m3493k(materialCardView.getContext(), typedArrayM4250j, 6);
        c2159c.m5093f(AbstractC1466d.m3496n(materialCardView.getContext(), typedArrayM4250j, 2));
        c2159c.f7808f = typedArrayM4250j.getDimensionPixelSize(5, 0);
        c2159c.f7807e = typedArrayM4250j.getDimensionPixelSize(4, 0);
        c2159c.f7809g = typedArrayM4250j.getInteger(3, 8388661);
        ColorStateList colorStateListM3493k2 = AbstractC1466d.m3493k(materialCardView.getContext(), typedArrayM4250j, 7);
        c2159c.f7813k = colorStateListM3493k2;
        if (colorStateListM3493k2 == null) {
            c2159c.f7813k = ColorStateList.valueOf(AbstractC3281e.m6626p(com.p2serv.android.p032ds.R.attr.colorControlHighlight, materialCardView));
        }
        ColorStateList colorStateListM3493k3 = AbstractC1466d.m3493k(materialCardView.getContext(), typedArrayM4250j, 1);
        C3908h c3908h2 = c2159c.f7806d;
        c3908h2.m7809n(colorStateListM3493k3 == null ? ColorStateList.valueOf(0) : colorStateListM3493k3);
        int[] iArr = AbstractC3722c.f12475a;
        RippleDrawable rippleDrawable = c2159c.f7817o;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(c2159c.f7813k);
        }
        c3908h.m7808m(materialCardView.getCardElevation());
        float f = c2159c.f7810h;
        ColorStateList colorStateList = c2159c.f7816n;
        c3908h2.f13126a.f13116j = f;
        c3908h2.invalidateSelf();
        c3908h2.m7814s(colorStateList);
        materialCardView.setBackgroundInternal(c2159c.m5091d(c3908h));
        Drawable drawableM5090c = materialCardView.isClickable() ? c2159c.m5090c() : c3908h2;
        c2159c.f7811i = drawableM5090c;
        materialCardView.setForeground(c2159c.m5091d(drawableM5090c));
        typedArrayM4250j.recycle();
    }

    @Override
    public void setCardBackgroundColor(int i6) {
        this.f6073h.f7805c.m7809n(ColorStateList.valueOf(i6));
    }

    public void setStrokeColor(int i6) {
        setStrokeColor(ColorStateList.valueOf(i6));
    }

    public void setOnCheckedChangeListener(InterfaceC2157a interfaceC2157a) {
    }
}

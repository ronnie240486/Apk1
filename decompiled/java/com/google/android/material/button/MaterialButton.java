package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatButton;
import androidx.customview.view.AbsSavedState;
import com.bumptech.glide.AbstractC1465c;
import com.bumptech.glide.AbstractC1466d;
import com.google.android.material.internal.AbstractC1811a0;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import p000a.AbstractC0004e;
import p001a0.C0019b;
import p065g0.AbstractC2581a;
import p138n0.AbstractC3155s0;
import p143n5.AbstractC3198d;
import p156o9.AbstractC3280d;
import p201s6.AbstractC3722c;
import p201s6.C3721b;
import p221u6.C3912l;
import p221u6.C3913m;
import p221u6.InterfaceC3924x;
import p222u7.AbstractC3928d;
import p250x5.AbstractC4121a;
import p263y6.AbstractC4275a;

public class MaterialButton extends AppCompatButton implements Checkable, InterfaceC3924x {

    public static final int[] f6016q = {R.attr.state_checkable};

    public static final int[] f6017r = {R.attr.state_checked};

    public final C1771c f6018d;

    public final LinkedHashSet f6019e;

    public InterfaceC1769a f6020f;

    public PorterDuff.Mode f6021g;

    public ColorStateList f6022h;

    public Drawable f6023i;

    public int f6024j;

    public int f6025k;

    public int f6026l;

    public int f6027m;

    public boolean f6028n;

    public boolean f6029o;

    public int f6030p;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1770b();

        public boolean f6031c;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            this.f6031c = parcel.readInt() == 1;
        }

        @Override
        public final void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.f6031c ? 1 : 0);
        }
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.p2serv.android.p032ds.R.attr.materialButtonStyle);
    }

    private String getA11yClassName() {
        return (m4138a() ? CompoundButton.class : Button.class).getName();
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        if (textAlignment == 1) {
            return getGravityTextAlignment();
        }
        if (textAlignment == 6 || textAlignment == 3) {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        if (gravity != 1) {
            return (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
        }
        return Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        return Math.min((int) paint.measureText(string), getLayout().getEllipsizedWidth());
    }

    public final boolean m4138a() {
        C1771c c1771c = this.f6018d;
        return c1771c != null && c1771c.f6061q;
    }

    public final boolean m4139b() {
        C1771c c1771c = this.f6018d;
        return (c1771c == null || c1771c.f6059o) ? false : true;
    }

    public final void m4140c() {
        int i6 = this.f6030p;
        boolean z7 = true;
        if (i6 != 1 && i6 != 2) {
            z7 = false;
        }
        if (z7) {
            setCompoundDrawablesRelative(this.f6023i, null, null, null);
            return;
        }
        if (i6 == 3 || i6 == 4) {
            setCompoundDrawablesRelative(null, null, this.f6023i, null);
        } else if (i6 == 16 || i6 == 32) {
            setCompoundDrawablesRelative(null, this.f6023i, null, null);
        }
    }

    public final void m4141d(boolean z7) {
        Drawable drawable = this.f6023i;
        if (drawable != null) {
            Drawable drawableMutate = AbstractC3198d.m6448W(drawable).mutate();
            this.f6023i = drawableMutate;
            AbstractC2581a.m5586h(drawableMutate, this.f6022h);
            PorterDuff.Mode mode = this.f6021g;
            if (mode != null) {
                AbstractC2581a.m5587i(this.f6023i, mode);
            }
            int intrinsicWidth = this.f6024j;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.f6023i.getIntrinsicWidth();
            }
            int intrinsicHeight = this.f6024j;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.f6023i.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f6023i;
            int i6 = this.f6025k;
            int i10 = this.f6026l;
            drawable2.setBounds(i6, i10, intrinsicWidth + i6, intrinsicHeight + i10);
            this.f6023i.setVisible(true, z7);
        }
        if (z7) {
            m4140c();
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        int i11 = this.f6030p;
        if (((i11 == 1 || i11 == 2) && drawable3 != this.f6023i) || (((i11 == 3 || i11 == 4) && drawable5 != this.f6023i) || ((i11 == 16 || i11 == 32) && drawable4 != this.f6023i))) {
            m4140c();
        }
    }

    public final void m4142e(int i6, int i10) {
        if (this.f6023i == null || getLayout() == null) {
            return;
        }
        int i11 = this.f6030p;
        if (!(i11 == 1 || i11 == 2) && i11 != 3 && i11 != 4) {
            if (i11 == 16 || i11 == 32) {
                this.f6025k = 0;
                if (i11 == 16) {
                    this.f6026l = 0;
                    m4141d(false);
                    return;
                }
                int intrinsicHeight = this.f6024j;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.f6023i.getIntrinsicHeight();
                }
                int textHeight = (((((i10 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.f6027m) - getPaddingBottom()) / 2;
                if (this.f6026l != textHeight) {
                    this.f6026l = textHeight;
                    m4141d(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f6026l = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i12 = this.f6030p;
        if (i12 == 1 || i12 == 3 || ((i12 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i12 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.f6025k = 0;
            m4141d(false);
            return;
        }
        int intrinsicWidth = this.f6024j;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.f6023i.getIntrinsicWidth();
        }
        int textWidth = i6 - getTextWidth();
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        int paddingEnd = (((textWidth - getPaddingEnd()) - intrinsicWidth) - this.f6027m) - getPaddingStart();
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            paddingEnd /= 2;
        }
        if ((getLayoutDirection() == 1) != (this.f6030p == 4)) {
            paddingEnd = -paddingEnd;
        }
        if (this.f6025k != paddingEnd) {
            this.f6025k = paddingEnd;
            m4141d(false);
        }
    }

    @Override
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (m4139b()) {
            return this.f6018d.f6051g;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f6023i;
    }

    public int getIconGravity() {
        return this.f6030p;
    }

    public int getIconPadding() {
        return this.f6027m;
    }

    public int getIconSize() {
        return this.f6024j;
    }

    public ColorStateList getIconTint() {
        return this.f6022h;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f6021g;
    }

    public int getInsetBottom() {
        return this.f6018d.f6050f;
    }

    public int getInsetTop() {
        return this.f6018d.f6049e;
    }

    public ColorStateList getRippleColor() {
        if (m4139b()) {
            return this.f6018d.f6056l;
        }
        return null;
    }

    public C3913m getShapeAppearanceModel() {
        if (m4139b()) {
            return this.f6018d.f6046b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (m4139b()) {
            return this.f6018d.f6055k;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (m4139b()) {
            return this.f6018d.f6052h;
        }
        return 0;
    }

    @Override
    public ColorStateList getSupportBackgroundTintList() {
        return m4139b() ? this.f6018d.f6054j : super.getSupportBackgroundTintList();
    }

    @Override
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return m4139b() ? this.f6018d.f6053i : super.getSupportBackgroundTintMode();
    }

    @Override
    public final boolean isChecked() {
        return this.f6028n;
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (m4139b()) {
            AbstractC3280d.m6567D(this, this.f6018d.m4149b(false));
        }
    }

    @Override
    public final int[] onCreateDrawableState(int i6) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i6 + 2);
        if (m4138a()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f6016q);
        }
        if (this.f6028n) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f6017r);
        }
        return iArrOnCreateDrawableState;
    }

    @Override
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(this.f6028n);
    }

    @Override
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(m4138a());
        accessibilityNodeInfo.setChecked(this.f6028n);
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        C1771c c1771c;
        super.onLayout(z7, i6, i10, i11, i12);
        if (Build.VERSION.SDK_INT == 21 && (c1771c = this.f6018d) != null) {
            int i13 = i12 - i10;
            int i14 = i11 - i6;
            Drawable drawable = c1771c.f6057m;
            if (drawable != null) {
                drawable.setBounds(c1771c.f6047c, c1771c.f6049e, i14 - c1771c.f6048d, i13 - c1771c.f6050f);
            }
        }
        m4142e(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f1689a);
        setChecked(savedState.f6031c);
    }

    @Override
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f6031c = this.f6028n;
        return savedState;
    }

    @Override
    public final void onTextChanged(CharSequence charSequence, int i6, int i10, int i11) {
        super.onTextChanged(charSequence, i6, i10, i11);
        m4142e(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override
    public final boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f6023i != null) {
            if (this.f6023i.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    @Override
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override
    public void setBackgroundColor(int i6) {
        if (!m4139b()) {
            super.setBackgroundColor(i6);
            return;
        }
        C1771c c1771c = this.f6018d;
        if (c1771c.m4149b(false) != null) {
            c1771c.m4149b(false).setTint(i6);
        }
    }

    @Override
    public void setBackgroundDrawable(Drawable drawable) {
        if (!m4139b()) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        if (drawable == getBackground()) {
            getBackground().setState(drawable.getState());
            return;
        }
        Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        C1771c c1771c = this.f6018d;
        c1771c.f6059o = true;
        ColorStateList colorStateList = c1771c.f6054j;
        MaterialButton materialButton = c1771c.f6045a;
        materialButton.setSupportBackgroundTintList(colorStateList);
        materialButton.setSupportBackgroundTintMode(c1771c.f6053i);
        super.setBackgroundDrawable(drawable);
    }

    @Override
    public void setBackgroundResource(int i6) {
        setBackgroundDrawable(i6 != 0 ? AbstractC1465c.m3473h(getContext(), i6) : null);
    }

    @Override
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z7) {
        if (m4139b()) {
            this.f6018d.f6061q = z7;
        }
    }

    @Override
    public void setChecked(boolean z7) {
        if (m4138a() && isEnabled() && this.f6028n != z7) {
            this.f6028n = z7;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) getParent();
                boolean z10 = this.f6028n;
                if (!materialButtonToggleGroup.f6038f) {
                    materialButtonToggleGroup.m4144b(getId(), z10);
                }
            }
            if (this.f6029o) {
                return;
            }
            this.f6029o = true;
            Iterator it = this.f6019e.iterator();
            if (it.hasNext()) {
                throw AbstractC0004e.m18l(it);
            }
            this.f6029o = false;
        }
    }

    public void setCornerRadius(int i6) {
        if (m4139b()) {
            C1771c c1771c = this.f6018d;
            if (c1771c.f6060p && c1771c.f6051g == i6) {
                return;
            }
            c1771c.f6051g = i6;
            c1771c.f6060p = true;
            C3912l c3912lM7826f = c1771c.f6046b.m7826f();
            c3912lM7826f.m7820c(i6);
            c1771c.m4150c(c3912lM7826f.m7819a());
        }
    }

    public void setCornerRadiusResource(int i6) {
        if (m4139b()) {
            setCornerRadius(getResources().getDimensionPixelSize(i6));
        }
    }

    @Override
    public void setElevation(float f) {
        super.setElevation(f);
        if (m4139b()) {
            this.f6018d.m4149b(false).m7808m(f);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f6023i != drawable) {
            this.f6023i = drawable;
            m4141d(true);
            m4142e(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i6) {
        if (this.f6030p != i6) {
            this.f6030p = i6;
            m4142e(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i6) {
        if (this.f6027m != i6) {
            this.f6027m = i6;
            setCompoundDrawablePadding(i6);
        }
    }

    public void setIconResource(int i6) {
        setIcon(i6 != 0 ? AbstractC1465c.m3473h(getContext(), i6) : null);
    }

    public void setIconSize(int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f6024j != i6) {
            this.f6024j = i6;
            m4141d(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f6022h != colorStateList) {
            this.f6022h = colorStateList;
            m4141d(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f6021g != mode) {
            this.f6021g = mode;
            m4141d(false);
        }
    }

    public void setIconTintResource(int i6) {
        setIconTint(AbstractC3928d.m7848k(getContext(), i6));
    }

    public void setInsetBottom(int i6) {
        C1771c c1771c = this.f6018d;
        c1771c.m4151d(c1771c.f6049e, i6);
    }

    public void setInsetTop(int i6) {
        C1771c c1771c = this.f6018d;
        c1771c.m4151d(i6, c1771c.f6050f);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(InterfaceC1769a interfaceC1769a) {
        this.f6020f = interfaceC1769a;
    }

    @Override
    public void setPressed(boolean z7) {
        InterfaceC1769a interfaceC1769a = this.f6020f;
        if (interfaceC1769a != null) {
            ((MaterialButtonToggleGroup) ((C0019b) interfaceC1769a).f38b).invalidate();
        }
        super.setPressed(z7);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (m4139b()) {
            C1771c c1771c = this.f6018d;
            if (c1771c.f6056l != colorStateList) {
                c1771c.f6056l = colorStateList;
                boolean z7 = C1771c.f6043t;
                MaterialButton materialButton = c1771c.f6045a;
                if (z7 && (materialButton.getBackground() instanceof RippleDrawable)) {
                    ((RippleDrawable) materialButton.getBackground()).setColor(AbstractC3722c.m7485b(colorStateList));
                } else {
                    if (z7 || !(materialButton.getBackground() instanceof C3721b)) {
                        return;
                    }
                    ((C3721b) materialButton.getBackground()).setTintList(AbstractC3722c.m7485b(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(int i6) {
        if (m4139b()) {
            setRippleColor(AbstractC3928d.m7848k(getContext(), i6));
        }
    }

    @Override
    public void setShapeAppearanceModel(C3913m c3913m) {
        if (!m4139b()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f6018d.m4150c(c3913m);
    }

    public void setShouldDrawSurfaceColorStroke(boolean z7) {
        if (m4139b()) {
            C1771c c1771c = this.f6018d;
            c1771c.f6058n = z7;
            c1771c.m4153f();
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (m4139b()) {
            C1771c c1771c = this.f6018d;
            if (c1771c.f6055k != colorStateList) {
                c1771c.f6055k = colorStateList;
                c1771c.m4153f();
            }
        }
    }

    public void setStrokeColorResource(int i6) {
        if (m4139b()) {
            setStrokeColor(AbstractC3928d.m7848k(getContext(), i6));
        }
    }

    public void setStrokeWidth(int i6) {
        if (m4139b()) {
            C1771c c1771c = this.f6018d;
            if (c1771c.f6052h != i6) {
                c1771c.f6052h = i6;
                c1771c.m4153f();
            }
        }
    }

    public void setStrokeWidthResource(int i6) {
        if (m4139b()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i6));
        }
    }

    @Override
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (!m4139b()) {
            super.setSupportBackgroundTintList(colorStateList);
            return;
        }
        C1771c c1771c = this.f6018d;
        if (c1771c.f6054j != colorStateList) {
            c1771c.f6054j = colorStateList;
            if (c1771c.m4149b(false) != null) {
                AbstractC2581a.m5586h(c1771c.m4149b(false), c1771c.f6054j);
            }
        }
    }

    @Override
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (!m4139b()) {
            super.setSupportBackgroundTintMode(mode);
            return;
        }
        C1771c c1771c = this.f6018d;
        if (c1771c.f6053i != mode) {
            c1771c.f6053i = mode;
            if (c1771c.m4149b(false) == null || c1771c.f6053i == null) {
                return;
            }
            AbstractC2581a.m5587i(c1771c.m4149b(false), c1771c.f6053i);
        }
    }

    @Override
    public void setTextAlignment(int i6) {
        super.setTextAlignment(i6);
        m4142e(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override
    public final void toggle() {
        setChecked(!this.f6028n);
    }

    public MaterialButton(Context context, AttributeSet attributeSet, int i6) {
        super(AbstractC4275a.m8323a(context, attributeSet, i6, com.p2serv.android.p032ds.R.style.Widget_MaterialComponents_Button), attributeSet, i6);
        this.f6019e = new LinkedHashSet();
        this.f6028n = false;
        this.f6029o = false;
        Context context2 = getContext();
        TypedArray typedArrayM4250j = AbstractC1811a0.m4250j(context2, attributeSet, AbstractC4121a.f14011y, i6, com.p2serv.android.p032ds.R.style.Widget_MaterialComponents_Button, new int[0]);
        this.f6027m = typedArrayM4250j.getDimensionPixelSize(12, 0);
        int i10 = typedArrayM4250j.getInt(15, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.f6021g = AbstractC1811a0.m4252l(i10, mode);
        this.f6022h = AbstractC1466d.m3493k(getContext(), typedArrayM4250j, 14);
        this.f6023i = AbstractC1466d.m3496n(getContext(), typedArrayM4250j, 10);
        this.f6030p = typedArrayM4250j.getInteger(11, 1);
        this.f6024j = typedArrayM4250j.getDimensionPixelSize(13, 0);
        C1771c c1771c = new C1771c(this, C3913m.m7822b(context2, attributeSet, i6, com.p2serv.android.p032ds.R.style.Widget_MaterialComponents_Button).m7819a());
        this.f6018d = c1771c;
        c1771c.f6047c = typedArrayM4250j.getDimensionPixelOffset(1, 0);
        c1771c.f6048d = typedArrayM4250j.getDimensionPixelOffset(2, 0);
        c1771c.f6049e = typedArrayM4250j.getDimensionPixelOffset(3, 0);
        c1771c.f6050f = typedArrayM4250j.getDimensionPixelOffset(4, 0);
        if (typedArrayM4250j.hasValue(8)) {
            int dimensionPixelSize = typedArrayM4250j.getDimensionPixelSize(8, -1);
            c1771c.f6051g = dimensionPixelSize;
            C3912l c3912lM7826f = c1771c.f6046b.m7826f();
            c3912lM7826f.m7820c(dimensionPixelSize);
            c1771c.m4150c(c3912lM7826f.m7819a());
            c1771c.f6060p = true;
        }
        c1771c.f6052h = typedArrayM4250j.getDimensionPixelSize(20, 0);
        c1771c.f6053i = AbstractC1811a0.m4252l(typedArrayM4250j.getInt(7, -1), mode);
        c1771c.f6054j = AbstractC1466d.m3493k(getContext(), typedArrayM4250j, 6);
        c1771c.f6055k = AbstractC1466d.m3493k(getContext(), typedArrayM4250j, 19);
        c1771c.f6056l = AbstractC1466d.m3493k(getContext(), typedArrayM4250j, 16);
        c1771c.f6061q = typedArrayM4250j.getBoolean(5, false);
        c1771c.f6063s = typedArrayM4250j.getDimensionPixelSize(9, 0);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        int paddingStart = getPaddingStart();
        int paddingTop = getPaddingTop();
        int paddingEnd = getPaddingEnd();
        int paddingBottom = getPaddingBottom();
        if (typedArrayM4250j.hasValue(0)) {
            c1771c.f6059o = true;
            setSupportBackgroundTintList(c1771c.f6054j);
            setSupportBackgroundTintMode(c1771c.f6053i);
        } else {
            c1771c.m4152e();
        }
        setPaddingRelative(paddingStart + c1771c.f6047c, paddingTop + c1771c.f6049e, paddingEnd + c1771c.f6048d, paddingBottom + c1771c.f6050f);
        typedArrayM4250j.recycle();
        setCompoundDrawablePadding(this.f6027m);
        m4141d(this.f6023i != null);
    }
}

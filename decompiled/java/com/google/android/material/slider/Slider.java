package com.google.android.material.slider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.p2serv.android.p032ds.R;
import p221u6.C3908h;
import p222u7.AbstractC3928d;

public class Slider extends BaseSlider<Slider, Object, Object> {
    public Slider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sliderStyle);
    }

    @Override
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    public int getActiveThumbIndex() {
        return this.f6614H;
    }

    public int getFocusedThumbIndex() {
        return this.f6615I;
    }

    public int getHaloRadius() {
        return this.f6657z;
    }

    public ColorStateList getHaloTintList() {
        return this.f6622P;
    }

    public int getLabelBehavior() {
        return this.f6652u;
    }

    public float getStepSize() {
        return this.f6616J;
    }

    public float getThumbElevation() {
        return this.f6627U.f13126a.f13119m;
    }

    public int getThumbRadius() {
        return this.f6656y;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.f6627U.f13126a.f13110d;
    }

    public float getThumbStrokeWidth() {
        return this.f6627U.f13126a.f13116j;
    }

    public ColorStateList getThumbTintList() {
        return this.f6627U.f13126a.f13109c;
    }

    public ColorStateList getTickActiveTintList() {
        return this.f6623Q;
    }

    public ColorStateList getTickInactiveTintList() {
        return this.f6624R;
    }

    public ColorStateList getTickTintList() {
        if (this.f6624R.equals(this.f6623Q)) {
            return this.f6623Q;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    public ColorStateList getTrackActiveTintList() {
        return this.f6625S;
    }

    public int getTrackHeight() {
        return this.f6653v;
    }

    public ColorStateList getTrackInactiveTintList() {
        return this.f6626T;
    }

    public int getTrackSidePadding() {
        return this.f6654w;
    }

    public ColorStateList getTrackTintList() {
        if (this.f6626T.equals(this.f6625S)) {
            return this.f6625S;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    public int getTrackWidth() {
        return this.f6619M;
    }

    public float getValue() {
        return getValues().get(0).floatValue();
    }

    @Override
    public float getValueFrom() {
        return this.f6611E;
    }

    @Override
    public float getValueTo() {
        return this.f6612F;
    }

    @Override
    public final boolean mo4321q() {
        if (getActiveThumbIndex() != -1) {
            return true;
        }
        setActiveThumbIndex(0);
        return true;
    }

    @Override
    public void setCustomThumbDrawable(Drawable drawable) {
        super.setCustomThumbDrawable(drawable);
    }

    @Override
    public void setEnabled(boolean z7) {
        super.setEnabled(z7);
    }

    @Override
    public void setFocusedThumbIndex(int i6) {
        super.setFocusedThumbIndex(i6);
    }

    @Override
    public void setHaloRadius(int i6) {
        super.setHaloRadius(i6);
    }

    public void setHaloRadiusResource(int i6) {
        setHaloRadius(getResources().getDimensionPixelSize(i6));
    }

    @Override
    public void setHaloTintList(ColorStateList colorStateList) {
        super.setHaloTintList(colorStateList);
    }

    @Override
    public void setLabelBehavior(int i6) {
        super.setLabelBehavior(i6);
    }

    @Override
    public void setStepSize(float f) {
        super.setStepSize(f);
    }

    @Override
    public void setThumbElevation(float f) {
        super.setThumbElevation(f);
    }

    public void setThumbElevationResource(int i6) {
        setThumbElevation(getResources().getDimension(i6));
    }

    @Override
    public void setThumbRadius(int i6) {
        super.setThumbRadius(i6);
    }

    public void setThumbRadiusResource(int i6) {
        setThumbRadius(getResources().getDimensionPixelSize(i6));
    }

    @Override
    public void setThumbStrokeColor(ColorStateList colorStateList) {
        super.setThumbStrokeColor(colorStateList);
    }

    public void setThumbStrokeColorResource(int i6) {
        if (i6 != 0) {
            setThumbStrokeColor(AbstractC3928d.m7848k(getContext(), i6));
        }
    }

    @Override
    public void setThumbStrokeWidth(float f) {
        super.setThumbStrokeWidth(f);
    }

    public void setThumbStrokeWidthResource(int i6) {
        if (i6 != 0) {
            setThumbStrokeWidth(getResources().getDimension(i6));
        }
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        C3908h c3908h = this.f6627U;
        if (colorStateList.equals(c3908h.f13126a.f13109c)) {
            return;
        }
        c3908h.m7809n(colorStateList);
        invalidate();
    }

    @Override
    public void setTickActiveTintList(ColorStateList colorStateList) {
        super.setTickActiveTintList(colorStateList);
    }

    @Override
    public void setTickInactiveTintList(ColorStateList colorStateList) {
        super.setTickInactiveTintList(colorStateList);
    }

    public void setTickTintList(ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z7) {
        if (this.f6618L != z7) {
            this.f6618L = z7;
            postInvalidate();
        }
    }

    @Override
    public void setTrackActiveTintList(ColorStateList colorStateList) {
        super.setTrackActiveTintList(colorStateList);
    }

    @Override
    public void setTrackHeight(int i6) {
        super.setTrackHeight(i6);
    }

    @Override
    public void setTrackInactiveTintList(ColorStateList colorStateList) {
        super.setTrackInactiveTintList(colorStateList);
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValue(float f) {
        setValues(Float.valueOf(f));
    }

    public void setValueFrom(float f) {
        this.f6611E = f;
        this.f6621O = true;
        postInvalidate();
    }

    public void setValueTo(float f) {
        this.f6612F = f;
        this.f6621O = true;
        postInvalidate();
    }

    public Slider(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{android.R.attr.value});
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            setValue(typedArrayObtainStyledAttributes.getFloat(0, 0.0f));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setCustomThumbDrawable(int i6) {
        setCustomThumbDrawable(getResources().getDrawable(i6));
    }

    public void setLabelFormatter(InterfaceC1861g interfaceC1861g) {
    }
}

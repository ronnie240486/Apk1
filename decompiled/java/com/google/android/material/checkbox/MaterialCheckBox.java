package com.google.android.material.checkbox;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.widget.AbstractC0369b;
import com.bumptech.glide.AbstractC1465c;
import com.bumptech.glide.AbstractC1466d;
import com.google.android.material.internal.AbstractC1811a0;
import p065g0.AbstractC2581a;
import p156o9.AbstractC3281e;
import p250x5.AbstractC4121a;
import p263y6.AbstractC4275a;

public class MaterialCheckBox extends AppCompatCheckBox {

    public static final int[][] f6077h = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    public ColorStateList f6078e;

    public boolean f6079f;

    public boolean f6080g;

    public MaterialCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.p2serv.android.p032ds.R.attr.checkboxStyle);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f6078e == null) {
            int iM6626p = AbstractC3281e.m6626p(com.p2serv.android.p032ds.R.attr.colorControlActivated, this);
            int iM6626p2 = AbstractC3281e.m6626p(com.p2serv.android.p032ds.R.attr.colorSurface, this);
            int iM6626p3 = AbstractC3281e.m6626p(com.p2serv.android.p032ds.R.attr.colorOnSurface, this);
            this.f6078e = new ColorStateList(f6077h, new int[]{AbstractC3281e.m6634x(1.0f, iM6626p2, iM6626p), AbstractC3281e.m6634x(0.54f, iM6626p2, iM6626p3), AbstractC3281e.m6634x(0.38f, iM6626p2, iM6626p3), AbstractC3281e.m6634x(0.38f, iM6626p2, iM6626p3)});
        }
        return this.f6078e;
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f6079f && AbstractC0369b.m1117a(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override
    public final void onDraw(Canvas canvas) {
        Drawable drawableM3472g;
        if (!this.f6080g || !TextUtils.isEmpty(getText()) || (drawableM3472g = AbstractC1465c.m3472g(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - drawableM3472g.getIntrinsicWidth()) / 2) * (AbstractC1811a0.m4249i(this) ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = drawableM3472g.getBounds();
            AbstractC2581a.m5584f(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    public void setCenterIfNoTextEnabled(boolean z7) {
        this.f6080g = z7;
    }

    public void setUseMaterialThemeColors(boolean z7) {
        this.f6079f = z7;
        if (z7) {
            AbstractC0369b.m1119c(this, getMaterialThemeColorsTintList());
        } else {
            AbstractC0369b.m1119c(this, null);
        }
    }

    public MaterialCheckBox(Context context, AttributeSet attributeSet, int i6) {
        super(AbstractC4275a.m8323a(context, attributeSet, i6, com.p2serv.android.p032ds.R.style.Widget_MaterialComponents_CompoundButton_CheckBox), attributeSet, i6);
        Context context2 = getContext();
        TypedArray typedArrayM4250j = AbstractC1811a0.m4250j(context2, attributeSet, AbstractC4121a.f13960D, i6, com.p2serv.android.p032ds.R.style.Widget_MaterialComponents_CompoundButton_CheckBox, new int[0]);
        if (typedArrayM4250j.hasValue(0)) {
            AbstractC0369b.m1119c(this, AbstractC1466d.m3493k(context2, typedArrayM4250j, 0));
        }
        this.f6079f = typedArrayM4250j.getBoolean(2, false);
        this.f6080g = typedArrayM4250j.getBoolean(1, true);
        typedArrayM4250j.recycle();
    }
}

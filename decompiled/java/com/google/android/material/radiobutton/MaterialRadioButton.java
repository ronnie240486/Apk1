package com.google.android.material.radiobutton;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.AbstractC0369b;
import com.bumptech.glide.AbstractC1466d;
import com.google.android.material.internal.AbstractC1811a0;
import p156o9.AbstractC3281e;
import p250x5.AbstractC4121a;
import p263y6.AbstractC4275a;

public class MaterialRadioButton extends AppCompatRadioButton {

    public static final int[][] f6603g = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    public ColorStateList f6604e;

    public boolean f6605f;

    public MaterialRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.p2serv.android.p032ds.R.attr.radioButtonStyle);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f6604e == null) {
            int iM6626p = AbstractC3281e.m6626p(com.p2serv.android.p032ds.R.attr.colorControlActivated, this);
            int iM6626p2 = AbstractC3281e.m6626p(com.p2serv.android.p032ds.R.attr.colorOnSurface, this);
            int iM6626p3 = AbstractC3281e.m6626p(com.p2serv.android.p032ds.R.attr.colorSurface, this);
            this.f6604e = new ColorStateList(f6603g, new int[]{AbstractC3281e.m6634x(1.0f, iM6626p3, iM6626p), AbstractC3281e.m6634x(0.54f, iM6626p3, iM6626p2), AbstractC3281e.m6634x(0.38f, iM6626p3, iM6626p2), AbstractC3281e.m6634x(0.38f, iM6626p3, iM6626p2)});
        }
        return this.f6604e;
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f6605f && AbstractC0369b.m1117a(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z7) {
        this.f6605f = z7;
        if (z7) {
            AbstractC0369b.m1119c(this, getMaterialThemeColorsTintList());
        } else {
            AbstractC0369b.m1119c(this, null);
        }
    }

    public MaterialRadioButton(Context context, AttributeSet attributeSet, int i6) {
        super(AbstractC4275a.m8323a(context, attributeSet, i6, com.p2serv.android.p032ds.R.style.Widget_MaterialComponents_CompoundButton_RadioButton), attributeSet, i6);
        Context context2 = getContext();
        TypedArray typedArrayM4250j = AbstractC1811a0.m4250j(context2, attributeSet, AbstractC4121a.f13962F, i6, com.p2serv.android.p032ds.R.style.Widget_MaterialComponents_CompoundButton_RadioButton, new int[0]);
        if (typedArrayM4250j.hasValue(0)) {
            AbstractC0369b.m1119c(this, AbstractC1466d.m3493k(context2, typedArrayM4250j, 0));
        }
        this.f6605f = typedArrayM4250j.getBoolean(1, false);
        typedArrayM4250j.recycle();
    }
}

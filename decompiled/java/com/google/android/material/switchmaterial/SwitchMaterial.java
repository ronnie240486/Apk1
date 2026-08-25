package com.google.android.material.switchmaterial;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.internal.AbstractC1811a0;
import java.util.WeakHashMap;
import p100j6.C2779a;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3155s0;
import p156o9.AbstractC3281e;
import p250x5.AbstractC4121a;
import p263y6.AbstractC4275a;

public class SwitchMaterial extends SwitchCompat {

    public static final int[][] f6681b0 = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    public final C2779a f6682T;

    public ColorStateList f6683U;

    public ColorStateList f6684V;

    public boolean f6685W;

    public SwitchMaterial(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.p2serv.android.p032ds.R.attr.switchStyle);
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.f6683U == null) {
            int iM6626p = AbstractC3281e.m6626p(com.p2serv.android.p032ds.R.attr.colorSurface, this);
            int iM6626p2 = AbstractC3281e.m6626p(com.p2serv.android.p032ds.R.attr.colorControlActivated, this);
            float dimension = getResources().getDimension(com.p2serv.android.p032ds.R.dimen.mtrl_switch_thumb_elevation);
            C2779a c2779a = this.f6682T;
            if (c2779a.f9493a) {
                float fM6170i = 0.0f;
                for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
                    WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                    fM6170i += AbstractC3119g0.m6170i((View) parent);
                }
                dimension += fM6170i;
            }
            int iM5749a = c2779a.m5749a(iM6626p, dimension);
            this.f6683U = new ColorStateList(f6681b0, new int[]{AbstractC3281e.m6634x(1.0f, iM6626p, iM6626p2), iM5749a, AbstractC3281e.m6634x(0.38f, iM6626p, iM6626p2), iM5749a});
        }
        return this.f6683U;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.f6684V == null) {
            int iM6626p = AbstractC3281e.m6626p(com.p2serv.android.p032ds.R.attr.colorSurface, this);
            int iM6626p2 = AbstractC3281e.m6626p(com.p2serv.android.p032ds.R.attr.colorControlActivated, this);
            int iM6626p3 = AbstractC3281e.m6626p(com.p2serv.android.p032ds.R.attr.colorOnSurface, this);
            this.f6684V = new ColorStateList(f6681b0, new int[]{AbstractC3281e.m6634x(0.54f, iM6626p, iM6626p2), AbstractC3281e.m6634x(0.32f, iM6626p, iM6626p3), AbstractC3281e.m6634x(0.12f, iM6626p, iM6626p2), AbstractC3281e.m6634x(0.12f, iM6626p, iM6626p3)});
        }
        return this.f6684V;
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f6685W && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.f6685W && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z7) {
        this.f6685W = z7;
        if (z7) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        } else {
            setThumbTintList(null);
            setTrackTintList(null);
        }
    }

    public SwitchMaterial(Context context, AttributeSet attributeSet, int i6) {
        super(AbstractC4275a.m8323a(context, attributeSet, i6, com.p2serv.android.p032ds.R.style.Widget_MaterialComponents_CompoundButton_Switch), attributeSet, i6);
        Context context2 = getContext();
        this.f6682T = new C2779a(context2);
        int[] iArr = AbstractC4121a.f13979W;
        AbstractC1811a0.m4241a(context2, attributeSet, i6, com.p2serv.android.p032ds.R.style.Widget_MaterialComponents_CompoundButton_Switch);
        AbstractC1811a0.m4242b(context2, attributeSet, iArr, i6, com.p2serv.android.p032ds.R.style.Widget_MaterialComponents_CompoundButton_Switch, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i6, com.p2serv.android.p032ds.R.style.Widget_MaterialComponents_CompoundButton_Switch);
        this.f6685W = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
    }
}

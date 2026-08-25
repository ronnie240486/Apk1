package com.google.android.gms.common;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zaaa;
import com.p2serv.android.p032ds.R;
import p000a.AbstractC0004e;
import p018b5.AbstractC1312l;
import p018b5.C1304d;
import p065g0.AbstractC2581a;
import p132m5.C3080c;
import p143n5.AbstractC3198d;
import p152o4.AbstractC3256a;
import p156o9.AbstractC3281e;

public final class SignInButton extends FrameLayout implements View.OnClickListener {

    public int f4977a;

    public int f4978b;

    public View f4979c;

    public View.OnClickListener f4980d;

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void m3636a(int i6, int i10) {
        this.f4977a = i6;
        this.f4978b = i10;
        Context context = getContext();
        View view = this.f4979c;
        if (view != null) {
            removeView(view);
        }
        try {
            this.f4979c = C1304d.m3177e(context, this.f4977a, this.f4978b);
        } catch (C3080c unused) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            int i11 = this.f4977a;
            int i12 = this.f4978b;
            zaaa zaaaVar = new zaaa(context, null);
            Resources resources = context.getResources();
            zaaaVar.setTypeface(Typeface.DEFAULT_BOLD);
            zaaaVar.setTextSize(14.0f);
            int i13 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
            zaaaVar.setMinHeight(i13);
            zaaaVar.setMinWidth(i13);
            int iM3671a = zaaa.m3671a(i12, R.drawable.common_google_signin_btn_icon_dark, R.drawable.common_google_signin_btn_icon_light, R.drawable.common_google_signin_btn_icon_light);
            int iM3671a2 = zaaa.m3671a(i12, R.drawable.common_google_signin_btn_text_dark, R.drawable.common_google_signin_btn_text_light, R.drawable.common_google_signin_btn_text_light);
            if (i11 == 0 || i11 == 1) {
                iM3671a = iM3671a2;
            } else if (i11 != 2) {
                throw new IllegalStateException(AbstractC0004e.m20n(i11, "Unknown button size: "));
            }
            Drawable drawableM6448W = AbstractC3198d.m6448W(resources.getDrawable(iM3671a));
            AbstractC2581a.m5586h(drawableM6448W, resources.getColorStateList(R.color.common_google_signin_btn_tint));
            AbstractC2581a.m5587i(drawableM6448W, PorterDuff.Mode.SRC_ATOP);
            zaaaVar.setBackgroundDrawable(drawableM6448W);
            ColorStateList colorStateList = resources.getColorStateList(zaaa.m3671a(i12, R.color.common_google_signin_btn_text_dark, R.color.common_google_signin_btn_text_light, R.color.common_google_signin_btn_text_light));
            AbstractC1312l.m3198e(colorStateList);
            zaaaVar.setTextColor(colorStateList);
            if (i11 == 0) {
                zaaaVar.setText(resources.getString(R.string.common_signin_button_text));
            } else if (i11 == 1) {
                zaaaVar.setText(resources.getString(R.string.common_signin_button_text_long));
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException(AbstractC0004e.m20n(i11, "Unknown button size: "));
                }
                zaaaVar.setText((CharSequence) null);
            }
            zaaaVar.setTransformationMethod(null);
            if (AbstractC3281e.m6632v(zaaaVar.getContext())) {
                zaaaVar.setGravity(19);
            }
            this.f4979c = zaaaVar;
        }
        addView(this.f4979c);
        this.f4979c.setEnabled(isEnabled());
        this.f4979c.setOnClickListener(this);
    }

    @Override
    public final void onClick(View view) {
        View.OnClickListener onClickListener = this.f4980d;
        if (onClickListener == null || view != this.f4979c) {
            return;
        }
        onClickListener.onClick(this);
    }

    public void setColorScheme(int i6) {
        m3636a(this.f4977a, i6);
    }

    @Override
    public void setEnabled(boolean z7) {
        super.setEnabled(z7);
        this.f4979c.setEnabled(z7);
    }

    @Override
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f4980d = onClickListener;
        View view = this.f4979c;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    @Deprecated
    public void setScopes(Scope[] scopeArr) {
        m3636a(this.f4977a, this.f4978b);
    }

    public void setSize(int i6) {
        m3636a(i6, this.f4978b);
    }

    public SignInButton(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f4980d = null;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, AbstractC3256a.f10891a, 0, 0);
        try {
            this.f4977a = typedArrayObtainStyledAttributes.getInt(0, 0);
            this.f4978b = typedArrayObtainStyledAttributes.getInt(1, 2);
            typedArrayObtainStyledAttributes.recycle();
            m3636a(this.f4977a, this.f4978b);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }
}

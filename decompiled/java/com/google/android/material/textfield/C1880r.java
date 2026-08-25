package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.bumptech.glide.AbstractC1466d;
import com.google.android.material.internal.AbstractC1811a0;
import com.google.android.material.internal.CheckableImageButton;
import com.p2serv.android.p032ds.R;
import java.util.WeakHashMap;
import p002a1.C0026b;
import p138n0.AbstractC3155s0;
import p143n5.AbstractC3198d;
import p222u7.AbstractC3928d;

public final class C1880r extends LinearLayout {

    public final TextInputLayout f6897a;

    public final AppCompatTextView f6898b;

    public CharSequence f6899c;

    public final CheckableImageButton f6900d;

    public ColorStateList f6901e;

    public PorterDuff.Mode f6902f;

    public View.OnLongClickListener f6903g;

    public boolean f6904h;

    public C1880r(TextInputLayout textInputLayout, C0026b c0026b) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.f6897a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.f6900d = checkableImageButton;
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null);
        this.f6898b = appCompatTextView;
        if (AbstractC1466d.m3501u(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginEnd(0);
        }
        View.OnLongClickListener onLongClickListener = this.f6903g;
        checkableImageButton.setOnClickListener(null);
        AbstractC3928d.m7860y(checkableImageButton, onLongClickListener);
        this.f6903g = null;
        checkableImageButton.setOnLongClickListener(null);
        AbstractC3928d.m7860y(checkableImageButton, null);
        TypedArray typedArray = (TypedArray) c0026b.f55c;
        if (typedArray.hasValue(62)) {
            this.f6901e = AbstractC1466d.m3492j(getContext(), c0026b, 62);
        }
        if (typedArray.hasValue(63)) {
            this.f6902f = AbstractC1811a0.m4252l(typedArray.getInt(63, -1), null);
        }
        if (typedArray.hasValue(61)) {
            m4404a(c0026b.m140t(61));
            if (typedArray.hasValue(60) && checkableImageButton.getContentDescription() != (text = typedArray.getText(60))) {
                checkableImageButton.setContentDescription(text);
            }
            checkableImageButton.setCheckable(typedArray.getBoolean(59, true));
        }
        appCompatTextView.setVisibility(8);
        appCompatTextView.setId(R.id.textinput_prefix_text);
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        appCompatTextView.setAccessibilityLiveRegion(1);
        AbstractC3198d.m6443R(appCompatTextView, typedArray.getResourceId(55, 0));
        if (typedArray.hasValue(56)) {
            appCompatTextView.setTextColor(c0026b.m139s(56));
        }
        CharSequence text2 = typedArray.getText(54);
        this.f6899c = TextUtils.isEmpty(text2) ? null : text2;
        appCompatTextView.setText(text2);
        m4407d();
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    public final void m4404a(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f6900d;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = this.f6901e;
            PorterDuff.Mode mode = this.f6902f;
            TextInputLayout textInputLayout = this.f6897a;
            AbstractC3928d.m7840a(textInputLayout, checkableImageButton, colorStateList, mode);
            m4405b(true);
            AbstractC3928d.m7859x(textInputLayout, checkableImageButton, this.f6901e);
            return;
        }
        m4405b(false);
        View.OnLongClickListener onLongClickListener = this.f6903g;
        checkableImageButton.setOnClickListener(null);
        AbstractC3928d.m7860y(checkableImageButton, onLongClickListener);
        this.f6903g = null;
        checkableImageButton.setOnLongClickListener(null);
        AbstractC3928d.m7860y(checkableImageButton, null);
        if (checkableImageButton.getContentDescription() != null) {
            checkableImageButton.setContentDescription(null);
        }
    }

    public final void m4405b(boolean z7) {
        CheckableImageButton checkableImageButton = this.f6900d;
        if ((checkableImageButton.getVisibility() == 0) != z7) {
            checkableImageButton.setVisibility(z7 ? 0 : 8);
            m4406c();
            m4407d();
        }
    }

    public final void m4406c() {
        int paddingStart;
        EditText editText = this.f6897a.f6778e;
        if (editText == null) {
            return;
        }
        if (this.f6900d.getVisibility() == 0) {
            paddingStart = 0;
        } else {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            paddingStart = editText.getPaddingStart();
        }
        int compoundPaddingTop = editText.getCompoundPaddingTop();
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
        int compoundPaddingBottom = editText.getCompoundPaddingBottom();
        WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
        this.f6898b.setPaddingRelative(paddingStart, compoundPaddingTop, dimensionPixelSize, compoundPaddingBottom);
    }

    public final void m4407d() {
        int i6 = (this.f6899c == null || this.f6904h) ? 8 : 0;
        setVisibility((this.f6900d.getVisibility() == 0 || i6 == 0) ? 0 : 8);
        this.f6898b.setVisibility(i6);
        this.f6897a.m4366o();
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        super.onMeasure(i6, i10);
        m4406c();
    }
}

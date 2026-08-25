package com.google.android.material.textfield;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bumptech.glide.AbstractC1466d;
import com.google.android.gms.internal.cast.C1603k1;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p138n0.AbstractC3155s0;
import p156o9.AbstractC3280d;
import p262y5.AbstractC4268a;

public final class C1878p {

    public final Context f6873a;

    public final TextInputLayout f6874b;

    public LinearLayout f6875c;

    public int f6876d;

    public FrameLayout f6877e;

    public AnimatorSet f6878f;

    public final float f6879g;

    public int f6880h;

    public int f6881i;

    public CharSequence f6882j;

    public boolean f6883k;

    public AppCompatTextView f6884l;

    public CharSequence f6885m;

    public int f6886n;

    public ColorStateList f6887o;

    public CharSequence f6888p;

    public boolean f6889q;

    public AppCompatTextView f6890r;

    public int f6891s;

    public ColorStateList f6892t;

    public Typeface f6893u;

    public C1878p(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f6873a = context;
        this.f6874b = textInputLayout;
        this.f6879g = context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
    }

    public final void m4393a(AppCompatTextView appCompatTextView, int i6) {
        if (this.f6875c == null && this.f6877e == null) {
            Context context = this.f6873a;
            LinearLayout linearLayout = new LinearLayout(context);
            this.f6875c = linearLayout;
            linearLayout.setOrientation(0);
            LinearLayout linearLayout2 = this.f6875c;
            TextInputLayout textInputLayout = this.f6874b;
            textInputLayout.addView(linearLayout2, -1, -2);
            this.f6877e = new FrameLayout(context);
            this.f6875c.addView(this.f6877e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (textInputLayout.getEditText() != null) {
                m4394b();
            }
        }
        if (i6 == 0 || i6 == 1) {
            this.f6877e.setVisibility(0);
            this.f6877e.addView(appCompatTextView);
        } else {
            this.f6875c.addView(appCompatTextView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f6875c.setVisibility(0);
        this.f6876d++;
    }

    public final void m4394b() {
        if (this.f6875c != null) {
            TextInputLayout textInputLayout = this.f6874b;
            if (textInputLayout.getEditText() != null) {
                EditText editText = textInputLayout.getEditText();
                Context context = this.f6873a;
                boolean zM3501u = AbstractC1466d.m3501u(context);
                LinearLayout linearLayout = this.f6875c;
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                int paddingStart = editText.getPaddingStart();
                if (zM3501u) {
                    paddingStart = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top);
                if (zM3501u) {
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_top);
                }
                int paddingEnd = editText.getPaddingEnd();
                if (zM3501u) {
                    paddingEnd = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                linearLayout.setPaddingRelative(paddingStart, dimensionPixelSize, paddingEnd, 0);
            }
        }
    }

    public final void m4395c() {
        AnimatorSet animatorSet = this.f6878f;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public final void m4396d(ArrayList arrayList, boolean z7, AppCompatTextView appCompatTextView, int i6, int i10, int i11) {
        if (appCompatTextView == null || !z7) {
            return;
        }
        if (i6 == i11 || i6 == i10) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(appCompatTextView, (Property<AppCompatTextView, Float>) View.ALPHA, i11 == i6 ? 1.0f : 0.0f);
            objectAnimatorOfFloat.setDuration(167L);
            objectAnimatorOfFloat.setInterpolator(AbstractC4268a.f14469a);
            arrayList.add(objectAnimatorOfFloat);
            if (i11 == i6) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(appCompatTextView, (Property<AppCompatTextView, Float>) View.TRANSLATION_Y, -this.f6879g, 0.0f);
                objectAnimatorOfFloat2.setDuration(217L);
                objectAnimatorOfFloat2.setInterpolator(AbstractC4268a.f14472d);
                arrayList.add(objectAnimatorOfFloat2);
            }
        }
    }

    public final boolean m4397e() {
        return (this.f6881i != 1 || this.f6884l == null || TextUtils.isEmpty(this.f6882j)) ? false : true;
    }

    public final TextView m4398f(int i6) {
        if (i6 == 1) {
            return this.f6884l;
        }
        if (i6 != 2) {
            return null;
        }
        return this.f6890r;
    }

    public final void m4399g() {
        this.f6882j = null;
        m4395c();
        if (this.f6880h == 1) {
            if (!this.f6889q || TextUtils.isEmpty(this.f6888p)) {
                this.f6881i = 0;
            } else {
                this.f6881i = 2;
            }
        }
        m4402j(this.f6880h, this.f6881i, m4401i(this.f6884l, ""));
    }

    public final void m4400h(AppCompatTextView appCompatTextView, int i6) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.f6875c;
        if (linearLayout == null) {
            return;
        }
        if ((i6 == 0 || i6 == 1) && (frameLayout = this.f6877e) != null) {
            frameLayout.removeView(appCompatTextView);
        } else {
            linearLayout.removeView(appCompatTextView);
        }
        int i10 = this.f6876d - 1;
        this.f6876d = i10;
        LinearLayout linearLayout2 = this.f6875c;
        if (i10 == 0) {
            linearLayout2.setVisibility(8);
        }
    }

    public final boolean m4401i(AppCompatTextView appCompatTextView, CharSequence charSequence) {
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        TextInputLayout textInputLayout = this.f6874b;
        return textInputLayout.isLaidOut() && textInputLayout.isEnabled() && !(this.f6881i == this.f6880h && appCompatTextView != null && TextUtils.equals(appCompatTextView.getText(), charSequence));
    }

    public final void m4402j(int i6, int i10, boolean z7) {
        TextView textViewM4398f;
        TextView textViewM4398f2;
        if (i6 == i10) {
            return;
        }
        if (z7) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f6878f = animatorSet;
            ArrayList arrayList = new ArrayList();
            m4396d(arrayList, this.f6889q, this.f6890r, 2, i6, i10);
            m4396d(arrayList, this.f6883k, this.f6884l, 1, i6, i10);
            AbstractC3280d.m6605x(animatorSet, arrayList);
            animatorSet.addListener(new C1603k1(this, i10, m4398f(i6), i6, m4398f(i10)));
            animatorSet.start();
        } else if (i6 != i10) {
            if (i10 != 0 && (textViewM4398f2 = m4398f(i10)) != null) {
                textViewM4398f2.setVisibility(0);
                textViewM4398f2.setAlpha(1.0f);
            }
            if (i6 != 0 && (textViewM4398f = m4398f(i6)) != null) {
                textViewM4398f.setVisibility(4);
                if (i6 == 1) {
                    textViewM4398f.setText((CharSequence) null);
                }
            }
            this.f6880h = i10;
        }
        TextInputLayout textInputLayout = this.f6874b;
        textInputLayout.m4367p();
        textInputLayout.m4371t(z7, false);
        textInputLayout.m4376y();
    }
}

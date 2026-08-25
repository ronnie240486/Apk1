package com.google.android.material.textfield;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import androidx.appcompat.app.ViewOnClickListenerC0122a;
import androidx.appcompat.widget.C0253p2;
import androidx.appcompat.widget.ViewOnFocusChangeListenerC0263r2;
import com.p2serv.android.p032ds.R;
import java.util.LinkedHashSet;
import p262y5.AbstractC4268a;

public final class C1867e extends AbstractC1876n {

    public final C0253p2 f6835e;

    public final ViewOnFocusChangeListenerC0263r2 f6836f;

    public final C1863a f6837g;

    public final C1864b f6838h;

    public AnimatorSet f6839i;

    public ValueAnimator f6840j;

    public C1867e(TextInputLayout textInputLayout, int i6) {
        super(textInputLayout, i6);
        this.f6835e = new C0253p2(1, this);
        this.f6836f = new ViewOnFocusChangeListenerC0263r2(1, this);
        this.f6837g = new C1863a(this, 0);
        this.f6838h = new C1864b(this, 0);
    }

    public static boolean m4378d(C1867e c1867e) {
        EditText editText = c1867e.f6867a.getEditText();
        return editText != null && (editText.hasFocus() || c1867e.f6869c.hasFocus()) && editText.getText().length() > 0;
    }

    @Override
    public final void mo4379a() {
        int i6 = 1;
        int i10 = 0;
        int i11 = this.f6870d;
        if (i11 == 0) {
            i11 = R.drawable.mtrl_ic_cancel;
        }
        TextInputLayout textInputLayout = this.f6867a;
        textInputLayout.setEndIconDrawable(i11);
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.clear_text_end_icon_content_description));
        textInputLayout.setEndIconCheckable(false);
        textInputLayout.setEndIconOnClickListener(new ViewOnClickListenerC0122a(6, this));
        LinkedHashSet linkedHashSet = textInputLayout.f6775c0;
        C1863a c1863a = this.f6837g;
        linkedHashSet.add(c1863a);
        if (textInputLayout.f6778e != null) {
            c1863a.m4377a(textInputLayout);
        }
        textInputLayout.f6783g0.add(this.f6838h);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(AbstractC4268a.f14472d);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.addUpdateListener(new C1866d(this, 1));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        LinearInterpolator linearInterpolator = AbstractC4268a.f14469a;
        valueAnimatorOfFloat2.setInterpolator(linearInterpolator);
        valueAnimatorOfFloat2.setDuration(100L);
        valueAnimatorOfFloat2.addUpdateListener(new C1866d(this, 0));
        AnimatorSet animatorSet = new AnimatorSet();
        this.f6839i = animatorSet;
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.f6839i.addListener(new C1865c(this, i10));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setInterpolator(linearInterpolator);
        valueAnimatorOfFloat3.setDuration(100L);
        valueAnimatorOfFloat3.addUpdateListener(new C1866d(this, 0));
        this.f6840j = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.addListener(new C1865c(this, i6));
    }

    @Override
    public final void mo4380c(boolean z7) {
        if (this.f6867a.getSuffixText() == null) {
            return;
        }
        m4381e(z7);
    }

    public final void m4381e(boolean z7) {
        boolean z10 = this.f6867a.m4360g() == z7;
        if (z7 && !this.f6839i.isRunning()) {
            this.f6840j.cancel();
            this.f6839i.start();
            if (z10) {
                this.f6839i.end();
                return;
            }
            return;
        }
        if (z7) {
            return;
        }
        this.f6839i.cancel();
        this.f6840j.start();
        if (z10) {
            this.f6840j.end();
        }
    }
}

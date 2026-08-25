package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.widget.AbstractC0381n;
import androidx.core.widget.InterfaceC0386s;
import com.bumptech.glide.AbstractC1465c;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import p001a0.C0019b;
import p003a2.AbstractC0032a;
import p056f0.AbstractC2484g;
import p118l0.AbstractC2957h;
import p118l0.C2956g;
import p123l5.AbstractC2973a;
import p143n5.AbstractC3198d;
import p156o9.AbstractC3281e;

public class AppCompatTextView extends TextView implements InterfaceC0386s {

    public final C0275u f652a;

    public final C0291x0 f653b;

    public final C0179b0 f654c;

    public C0295y f655d;

    public boolean f656e;

    public C0019b f657f;

    public Future f658g;

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    private C0295y getEmojiTextViewHelper() {
        if (this.f655d == null) {
            this.f655d = new C0295y(this);
        }
        return this.f655d;
    }

    @Override
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0275u c0275u = this.f652a;
        if (c0275u != null) {
            c0275u.m773a();
        }
        C0291x0 c0291x0 = this.f653b;
        if (c0291x0 != null) {
            c0291x0.m816b();
        }
    }

    public final void m572f() {
        Future future = this.f658g;
        if (future == null) {
            return;
        }
        try {
            this.f658g = null;
            if (future.get() != null) {
                throw new ClassCastException();
            }
            if (Build.VERSION.SDK_INT >= 29) {
                throw null;
            }
            AbstractC3198d.m6476y(this);
            throw null;
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    @Override
    public int getAutoSizeMaxTextSize() {
        if (AbstractC0189c4.f881b) {
            return super.getAutoSizeMaxTextSize();
        }
        C0291x0 c0291x0 = this.f653b;
        if (c0291x0 != null) {
            return Math.round(c0291x0.f1127i.f929e);
        }
        return -1;
    }

    @Override
    public int getAutoSizeMinTextSize() {
        if (AbstractC0189c4.f881b) {
            return super.getAutoSizeMinTextSize();
        }
        C0291x0 c0291x0 = this.f653b;
        if (c0291x0 != null) {
            return Math.round(c0291x0.f1127i.f928d);
        }
        return -1;
    }

    @Override
    public int getAutoSizeStepGranularity() {
        if (AbstractC0189c4.f881b) {
            return super.getAutoSizeStepGranularity();
        }
        C0291x0 c0291x0 = this.f653b;
        if (c0291x0 != null) {
            return Math.round(c0291x0.f1127i.f927c);
        }
        return -1;
    }

    @Override
    public int[] getAutoSizeTextAvailableSizes() {
        if (AbstractC0189c4.f881b) {
            return super.getAutoSizeTextAvailableSizes();
        }
        C0291x0 c0291x0 = this.f653b;
        return c0291x0 != null ? c0291x0.f1127i.f930f : new int[0];
    }

    @Override
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (AbstractC0189c4.f881b) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        C0291x0 c0291x0 = this.f653b;
        if (c0291x0 != null) {
            return c0291x0.f1127i.f925a;
        }
        return 0;
    }

    @Override
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return AbstractC3198d.m6446U(super.getCustomSelectionActionModeCallback());
    }

    @Override
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public InterfaceC0296y0 getSuperCaller() {
        if (this.f657f == null) {
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 28) {
                this.f657f = new C0301z0(this);
            } else if (i6 >= 26) {
                this.f657f = new C0019b(6, this);
            }
        }
        return this.f657f;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0275u c0275u = this.f652a;
        if (c0275u != null) {
            return c0275u.m774c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0275u c0275u = this.f652a;
        if (c0275u != null) {
            return c0275u.m775d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f653b.m817d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f653b.m818e();
    }

    @Override
    public CharSequence getText() {
        m572f();
        return super.getText();
    }

    @Override
    public TextClassifier getTextClassifier() {
        C0179b0 c0179b0;
        if (Build.VERSION.SDK_INT >= 28 || (c0179b0 = this.f654c) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = (TextClassifier) c0179b0.f873c;
        return textClassifier == null ? AbstractC0251p0.m740a((TextView) c0179b0.f872b) : textClassifier;
    }

    public C2956g getTextMetricsParamsCompat() {
        return AbstractC3198d.m6476y(this);
    }

    @Override
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f653b.getClass();
        C0291x0.m814h(editorInfo, inputConnectionOnCreateInputConnection, this);
        AbstractC3281e.m6611A(editorInfo, inputConnectionOnCreateInputConnection, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        super.onLayout(z7, i6, i10, i11, i12);
        C0291x0 c0291x0 = this.f653b;
        if (c0291x0 == null || AbstractC0189c4.f881b) {
            return;
        }
        c0291x0.f1127i.m677a();
    }

    @Override
    public void onMeasure(int i6, int i10) {
        m572f();
        super.onMeasure(i6, i10);
    }

    @Override
    public final void onTextChanged(CharSequence charSequence, int i6, int i10, int i11) {
        super.onTextChanged(charSequence, i6, i10, i11);
        C0291x0 c0291x0 = this.f653b;
        if (c0291x0 == null || AbstractC0189c4.f881b) {
            return;
        }
        C0207g1 c0207g1 = c0291x0.f1127i;
        if (c0207g1.m679f()) {
            c0207g1.m677a();
        }
    }

    @Override
    public void setAllCaps(boolean z7) {
        super.setAllCaps(z7);
        getEmojiTextViewHelper().m830c(z7);
    }

    @Override
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i6, int i10, int i11, int i12) {
        if (AbstractC0189c4.f881b) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i6, i10, i11, i12);
            return;
        }
        C0291x0 c0291x0 = this.f653b;
        if (c0291x0 != null) {
            c0291x0.m821i(i6, i10, i11, i12);
        }
    }

    @Override
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i6) {
        if (AbstractC0189c4.f881b) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i6);
            return;
        }
        C0291x0 c0291x0 = this.f653b;
        if (c0291x0 != null) {
            c0291x0.m822j(iArr, i6);
        }
    }

    @Override
    public void setAutoSizeTextTypeWithDefaults(int i6) {
        if (AbstractC0189c4.f881b) {
            super.setAutoSizeTextTypeWithDefaults(i6);
            return;
        }
        C0291x0 c0291x0 = this.f653b;
        if (c0291x0 != null) {
            c0291x0.m823k(i6);
        }
    }

    @Override
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0275u c0275u = this.f652a;
        if (c0275u != null) {
            c0275u.m777f();
        }
    }

    @Override
    public void setBackgroundResource(int i6) {
        super.setBackgroundResource(i6);
        C0275u c0275u = this.f652a;
        if (c0275u != null) {
            c0275u.m778g(i6);
        }
    }

    @Override
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0291x0 c0291x0 = this.f653b;
        if (c0291x0 != null) {
            c0291x0.m816b();
        }
    }

    @Override
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0291x0 c0291x0 = this.f653b;
        if (c0291x0 != null) {
            c0291x0.m816b();
        }
    }

    @Override
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C0291x0 c0291x0 = this.f653b;
        if (c0291x0 != null) {
            c0291x0.m816b();
        }
    }

    @Override
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C0291x0 c0291x0 = this.f653b;
        if (c0291x0 != null) {
            c0291x0.m816b();
        }
    }

    @Override
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(AbstractC3198d.m6449X(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z7) {
        getEmojiTextViewHelper().m831d(z7);
    }

    @Override
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().m828a(inputFilterArr));
    }

    @Override
    public void setFirstBaselineToTopHeight(int i6) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().mo95k(i6);
        } else {
            AbstractC3198d.m6440O(this, i6);
        }
    }

    @Override
    public void setLastBaselineToBottomHeight(int i6) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().mo85a(i6);
        } else {
            AbstractC3198d.m6441P(this, i6);
        }
    }

    @Override
    public void setLineHeight(int i6) {
        AbstractC0032a.m161o(i6);
        int fontMetricsInt = getPaint().getFontMetricsInt(null);
        if (i6 != fontMetricsInt) {
            setLineSpacing(i6 - fontMetricsInt, 1.0f);
        }
    }

    public void setPrecomputedText(AbstractC2957h abstractC2957h) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        AbstractC3198d.m6476y(this);
        throw null;
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0275u c0275u = this.f652a;
        if (c0275u != null) {
            c0275u.m780i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0275u c0275u = this.f652a;
        if (c0275u != null) {
            c0275u.m781j(mode);
        }
    }

    @Override
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C0291x0 c0291x0 = this.f653b;
        c0291x0.m824l(colorStateList);
        c0291x0.m816b();
    }

    @Override
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C0291x0 c0291x0 = this.f653b;
        c0291x0.m825m(mode);
        c0291x0.m816b();
    }

    @Override
    public void setTextAppearance(Context context, int i6) {
        super.setTextAppearance(context, i6);
        C0291x0 c0291x0 = this.f653b;
        if (c0291x0 != null) {
            c0291x0.m820g(context, i6);
        }
    }

    @Override
    public void setTextClassifier(TextClassifier textClassifier) {
        C0179b0 c0179b0;
        if (Build.VERSION.SDK_INT >= 28 || (c0179b0 = this.f654c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            c0179b0.f873c = textClassifier;
        }
    }

    public void setTextFuture(Future<AbstractC2957h> future) {
        this.f658g = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(C2956g c2956g) {
        TextDirectionHeuristic textDirectionHeuristic;
        TextDirectionHeuristic textDirectionHeuristic2 = c2956g.f10133b;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        int i6 = 1;
        if (textDirectionHeuristic2 != textDirectionHeuristic3 && textDirectionHeuristic2 != (textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            if (textDirectionHeuristic2 == TextDirectionHeuristics.ANYRTL_LTR) {
                i6 = 2;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LTR) {
                i6 = 3;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.RTL) {
                i6 = 4;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LOCALE) {
                i6 = 5;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic) {
                i6 = 6;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic3) {
                i6 = 7;
            }
        }
        setTextDirection(i6);
        int i10 = Build.VERSION.SDK_INT;
        TextPaint textPaint = c2956g.f10132a;
        if (i10 >= 23) {
            getPaint().set(textPaint);
            AbstractC0381n.m1148e(this, c2956g.f10134c);
            AbstractC0381n.m1151h(this, c2956g.f10135d);
        } else {
            float textScaleX = textPaint.getTextScaleX();
            getPaint().set(textPaint);
            if (textScaleX == getTextScaleX()) {
                setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            setTextScaleX(textScaleX);
        }
    }

    @Override
    public final void setTextSize(int i6, float f) {
        boolean z7 = AbstractC0189c4.f881b;
        if (z7) {
            super.setTextSize(i6, f);
            return;
        }
        C0291x0 c0291x0 = this.f653b;
        if (c0291x0 == null || z7) {
            return;
        }
        C0207g1 c0207g1 = c0291x0.f1127i;
        if (c0207g1.m679f()) {
            return;
        }
        c0207g1.m680g(i6, f);
    }

    @Override
    public final void setTypeface(Typeface typeface, int i6) {
        Typeface typefaceCreate;
        if (this.f656e) {
            return;
        }
        if (typeface == null || i6 <= 0) {
            typefaceCreate = null;
        } else {
            Context context = getContext();
            AbstractC2973a abstractC2973a = AbstractC2484g.f8688a;
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null");
            }
            typefaceCreate = Typeface.create(typeface, i6);
        }
        this.f656e = true;
        if (typefaceCreate != null) {
            typeface = typefaceCreate;
        }
        try {
            super.setTypeface(typeface, i6);
        } finally {
            this.f656e = false;
        }
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        AbstractC0229k3.m718a(context);
        this.f656e = false;
        this.f657f = null;
        AbstractC0224j3.m702a(this, getContext());
        C0275u c0275u = new C0275u(this);
        this.f652a = c0275u;
        c0275u.m776e(attributeSet, i6);
        C0291x0 c0291x0 = new C0291x0(this);
        this.f653b = c0291x0;
        c0291x0.m819f(attributeSet, i6);
        c0291x0.m816b();
        C0179b0 c0179b0 = new C0179b0();
        c0179b0.f872b = this;
        this.f654c = c0179b0;
        getEmojiTextViewHelper().m829b(attributeSet, i6);
    }

    @Override
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i6, int i10, int i11, int i12) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i6 != 0 ? AbstractC1465c.m3473h(context, i6) : null, i10 != 0 ? AbstractC1465c.m3473h(context, i10) : null, i11 != 0 ? AbstractC1465c.m3473h(context, i11) : null, i12 != 0 ? AbstractC1465c.m3473h(context, i12) : null);
        C0291x0 c0291x0 = this.f653b;
        if (c0291x0 != null) {
            c0291x0.m816b();
        }
    }

    @Override
    public final void setCompoundDrawablesWithIntrinsicBounds(int i6, int i10, int i11, int i12) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i6 != 0 ? AbstractC1465c.m3473h(context, i6) : null, i10 != 0 ? AbstractC1465c.m3473h(context, i10) : null, i11 != 0 ? AbstractC1465c.m3473h(context, i11) : null, i12 != 0 ? AbstractC1465c.m3473h(context, i12) : null);
        C0291x0 c0291x0 = this.f653b;
        if (c0291x0 != null) {
            c0291x0.m816b();
        }
    }
}

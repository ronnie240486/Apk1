package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.core.widget.InterfaceC0386s;
import com.p2serv.android.p032ds.R;
import p143n5.AbstractC3198d;

public class AppCompatButton extends Button implements InterfaceC0386s {

    public final C0275u f609a;

    public final C0291x0 f610b;

    public C0295y f611c;

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyle);
    }

    private C0295y getEmojiTextViewHelper() {
        if (this.f611c == null) {
            this.f611c = new C0295y(this);
        }
        return this.f611c;
    }

    @Override
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0275u c0275u = this.f609a;
        if (c0275u != null) {
            c0275u.m773a();
        }
        C0291x0 c0291x0 = this.f610b;
        if (c0291x0 != null) {
            c0291x0.m816b();
        }
    }

    @Override
    public int getAutoSizeMaxTextSize() {
        if (AbstractC0189c4.f881b) {
            return super.getAutoSizeMaxTextSize();
        }
        C0291x0 c0291x0 = this.f610b;
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
        C0291x0 c0291x0 = this.f610b;
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
        C0291x0 c0291x0 = this.f610b;
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
        C0291x0 c0291x0 = this.f610b;
        return c0291x0 != null ? c0291x0.f1127i.f930f : new int[0];
    }

    @Override
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (AbstractC0189c4.f881b) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        C0291x0 c0291x0 = this.f610b;
        if (c0291x0 != null) {
            return c0291x0.f1127i.f925a;
        }
        return 0;
    }

    @Override
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return AbstractC3198d.m6446U(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0275u c0275u = this.f609a;
        if (c0275u != null) {
            return c0275u.m774c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0275u c0275u = this.f609a;
        if (c0275u != null) {
            return c0275u.m775d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f610b.m817d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f610b.m818e();
    }

    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override
    public void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        super.onLayout(z7, i6, i10, i11, i12);
        C0291x0 c0291x0 = this.f610b;
        if (c0291x0 == null || AbstractC0189c4.f881b) {
            return;
        }
        c0291x0.f1127i.m677a();
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i6, int i10, int i11) {
        super.onTextChanged(charSequence, i6, i10, i11);
        C0291x0 c0291x0 = this.f610b;
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
        C0291x0 c0291x0 = this.f610b;
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
        C0291x0 c0291x0 = this.f610b;
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
        C0291x0 c0291x0 = this.f610b;
        if (c0291x0 != null) {
            c0291x0.m823k(i6);
        }
    }

    @Override
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0275u c0275u = this.f609a;
        if (c0275u != null) {
            c0275u.m777f();
        }
    }

    @Override
    public void setBackgroundResource(int i6) {
        super.setBackgroundResource(i6);
        C0275u c0275u = this.f609a;
        if (c0275u != null) {
            c0275u.m778g(i6);
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

    public void setSupportAllCaps(boolean z7) {
        C0291x0 c0291x0 = this.f610b;
        if (c0291x0 != null) {
            c0291x0.f1119a.setAllCaps(z7);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0275u c0275u = this.f609a;
        if (c0275u != null) {
            c0275u.m780i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0275u c0275u = this.f609a;
        if (c0275u != null) {
            c0275u.m781j(mode);
        }
    }

    @Override
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C0291x0 c0291x0 = this.f610b;
        c0291x0.m824l(colorStateList);
        c0291x0.m816b();
    }

    @Override
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C0291x0 c0291x0 = this.f610b;
        c0291x0.m825m(mode);
        c0291x0.m816b();
    }

    @Override
    public final void setTextAppearance(Context context, int i6) {
        super.setTextAppearance(context, i6);
        C0291x0 c0291x0 = this.f610b;
        if (c0291x0 != null) {
            c0291x0.m820g(context, i6);
        }
    }

    @Override
    public final void setTextSize(int i6, float f) {
        boolean z7 = AbstractC0189c4.f881b;
        if (z7) {
            super.setTextSize(i6, f);
            return;
        }
        C0291x0 c0291x0 = this.f610b;
        if (c0291x0 == null || z7) {
            return;
        }
        C0207g1 c0207g1 = c0291x0.f1127i;
        if (c0207g1.m679f()) {
            return;
        }
        c0207g1.m680g(i6, f);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        AbstractC0229k3.m718a(context);
        AbstractC0224j3.m702a(this, getContext());
        C0275u c0275u = new C0275u(this);
        this.f609a = c0275u;
        c0275u.m776e(attributeSet, i6);
        C0291x0 c0291x0 = new C0291x0(this);
        this.f610b = c0291x0;
        c0291x0.m819f(attributeSet, i6);
        c0291x0.m816b();
        getEmojiTextViewHelper().m829b(attributeSet, i6);
    }
}

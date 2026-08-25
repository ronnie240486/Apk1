package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.core.widget.InterfaceC0386s;
import com.bumptech.glide.AbstractC1465c;
import com.p2serv.android.p032ds.R;
import p002a1.C0026b;
import p045e.AbstractC2341a;
import p138n0.AbstractC3155s0;
import p143n5.AbstractC3198d;
import p156o9.AbstractC3281e;

public class AppCompatCheckedTextView extends CheckedTextView implements InterfaceC0386s {

    public final C0280v f616a;

    public final C0275u f617b;

    public final C0291x0 f618c;

    public C0295y f619d;

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkedTextViewStyle);
    }

    private C0295y getEmojiTextViewHelper() {
        if (this.f619d == null) {
            this.f619d = new C0295y(this);
        }
        return this.f619d;
    }

    @Override
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0291x0 c0291x0 = this.f618c;
        if (c0291x0 != null) {
            c0291x0.m816b();
        }
        C0275u c0275u = this.f617b;
        if (c0275u != null) {
            c0275u.m773a();
        }
        C0280v c0280v = this.f616a;
        if (c0280v != null) {
            c0280v.m786b();
        }
    }

    @Override
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return AbstractC3198d.m6446U(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0275u c0275u = this.f617b;
        if (c0275u != null) {
            return c0275u.m774c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0275u c0275u = this.f617b;
        if (c0275u != null) {
            return c0275u.m775d();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        C0280v c0280v = this.f616a;
        if (c0280v != null) {
            return (ColorStateList) c0280v.f1082a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        C0280v c0280v = this.f616a;
        if (c0280v != null) {
            return (PorterDuff.Mode) c0280v.f1083b;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f618c.m817d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f618c.m818e();
    }

    @Override
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        AbstractC3281e.m6611A(editorInfo, inputConnectionOnCreateInputConnection, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override
    public void setAllCaps(boolean z7) {
        super.setAllCaps(z7);
        getEmojiTextViewHelper().m830c(z7);
    }

    @Override
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0275u c0275u = this.f617b;
        if (c0275u != null) {
            c0275u.m777f();
        }
    }

    @Override
    public void setBackgroundResource(int i6) {
        super.setBackgroundResource(i6);
        C0275u c0275u = this.f617b;
        if (c0275u != null) {
            c0275u.m778g(i6);
        }
    }

    @Override
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        C0280v c0280v = this.f616a;
        if (c0280v != null) {
            if (c0280v.f1086e) {
                c0280v.f1086e = false;
            } else {
                c0280v.f1086e = true;
                c0280v.m786b();
            }
        }
    }

    @Override
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0291x0 c0291x0 = this.f618c;
        if (c0291x0 != null) {
            c0291x0.m816b();
        }
    }

    @Override
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0291x0 c0291x0 = this.f618c;
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

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0275u c0275u = this.f617b;
        if (c0275u != null) {
            c0275u.m780i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0275u c0275u = this.f617b;
        if (c0275u != null) {
            c0275u.m781j(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        C0280v c0280v = this.f616a;
        if (c0280v != null) {
            c0280v.f1082a = colorStateList;
            c0280v.f1084c = true;
            c0280v.m786b();
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        C0280v c0280v = this.f616a;
        if (c0280v != null) {
            c0280v.f1083b = mode;
            c0280v.f1085d = true;
            c0280v.m786b();
        }
    }

    @Override
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C0291x0 c0291x0 = this.f618c;
        c0291x0.m824l(colorStateList);
        c0291x0.m816b();
    }

    @Override
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C0291x0 c0291x0 = this.f618c;
        c0291x0.m825m(mode);
        c0291x0.m816b();
    }

    @Override
    public final void setTextAppearance(Context context, int i6) {
        super.setTextAppearance(context, i6);
        C0291x0 c0291x0 = this.f618c;
        if (c0291x0 != null) {
            c0291x0.m820g(context, i6);
        }
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i6) {
        int resourceId;
        int resourceId2;
        super(context, attributeSet, i6);
        AbstractC0229k3.m718a(context);
        AbstractC0224j3.m702a(this, getContext());
        C0291x0 c0291x0 = new C0291x0(this);
        this.f618c = c0291x0;
        c0291x0.m819f(attributeSet, i6);
        c0291x0.m816b();
        C0275u c0275u = new C0275u(this);
        this.f617b = c0275u;
        c0275u.m776e(attributeSet, i6);
        this.f616a = new C0280v(this);
        Context context2 = getContext();
        int[] iArr = AbstractC2341a.f8165m;
        C0026b c0026bM111C = C0026b.m111C(context2, attributeSet, iArr, i6);
        TypedArray typedArray = (TypedArray) c0026bM111C.f55c;
        AbstractC3155s0.m6346p(this, getContext(), iArr, attributeSet, (TypedArray) c0026bM111C.f55c, i6, 0);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    setCheckMarkDrawable(AbstractC1465c.m3473h(getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                    if (typedArray.hasValue(0)) {
                        setCheckMarkDrawable(AbstractC1465c.m3473h(getContext(), resourceId));
                    }
                }
            } else if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                setCheckMarkDrawable(AbstractC1465c.m3473h(getContext(), resourceId));
            }
            if (typedArray.hasValue(2)) {
                setCheckMarkTintList(c0026bM111C.m139s(2));
            }
            if (typedArray.hasValue(3)) {
                setCheckMarkTintMode(AbstractC0237m1.m737c(typedArray.getInt(3, -1), null));
            }
            c0026bM111C.m120F();
            getEmojiTextViewHelper().m829b(attributeSet, i6);
        } catch (Throwable th) {
            c0026bM111C.m120F();
            throw th;
        }
    }

    @Override
    public void setCheckMarkDrawable(int i6) {
        setCheckMarkDrawable(AbstractC1465c.m3473h(getContext(), i6));
    }
}

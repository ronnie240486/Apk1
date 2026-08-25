package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.core.widget.InterfaceC0386s;
import com.bumptech.glide.AbstractC1465c;
import p002a1.C0026b;
import p156o9.AbstractC3281e;

public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements InterfaceC0386s {

    public static final int[] f632d = {R.attr.popupBackground};

    public final C0275u f633a;

    public final C0291x0 f634b;

    public final C0179b0 f635c;

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.p2serv.android.p032ds.R.attr.autoCompleteTextViewStyle);
    }

    @Override
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0275u c0275u = this.f633a;
        if (c0275u != null) {
            c0275u.m773a();
        }
        C0291x0 c0291x0 = this.f634b;
        if (c0291x0 != null) {
            c0291x0.m816b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0275u c0275u = this.f633a;
        if (c0275u != null) {
            return c0275u.m774c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0275u c0275u = this.f633a;
        if (c0275u != null) {
            return c0275u.m775d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f634b.m817d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f634b.m818e();
    }

    @Override
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        AbstractC3281e.m6611A(editorInfo, inputConnectionOnCreateInputConnection, this);
        return this.f635c.m641c(inputConnectionOnCreateInputConnection, editorInfo);
    }

    @Override
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0275u c0275u = this.f633a;
        if (c0275u != null) {
            c0275u.m777f();
        }
    }

    @Override
    public void setBackgroundResource(int i6) {
        super.setBackgroundResource(i6);
        C0275u c0275u = this.f633a;
        if (c0275u != null) {
            c0275u.m778g(i6);
        }
    }

    @Override
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0291x0 c0291x0 = this.f634b;
        if (c0291x0 != null) {
            c0291x0.m816b();
        }
    }

    @Override
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0291x0 c0291x0 = this.f634b;
        if (c0291x0 != null) {
            c0291x0.m816b();
        }
    }

    @Override
    public void setDropDownBackgroundResource(int i6) {
        setDropDownBackgroundDrawable(AbstractC1465c.m3473h(getContext(), i6));
    }

    public void setEmojiCompatEnabled(boolean z7) {
        this.f635c.m642d(z7);
    }

    @Override
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f635c.m639a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0275u c0275u = this.f633a;
        if (c0275u != null) {
            c0275u.m780i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0275u c0275u = this.f633a;
        if (c0275u != null) {
            c0275u.m781j(mode);
        }
    }

    @Override
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C0291x0 c0291x0 = this.f634b;
        c0291x0.m824l(colorStateList);
        c0291x0.m816b();
    }

    @Override
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C0291x0 c0291x0 = this.f634b;
        c0291x0.m825m(mode);
        c0291x0.m816b();
    }

    @Override
    public final void setTextAppearance(Context context, int i6) {
        super.setTextAppearance(context, i6);
        C0291x0 c0291x0 = this.f634b;
        if (c0291x0 != null) {
            c0291x0.m820g(context, i6);
        }
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        AbstractC0229k3.m718a(context);
        AbstractC0224j3.m702a(this, getContext());
        C0026b c0026bM111C = C0026b.m111C(getContext(), attributeSet, f632d, i6);
        if (((TypedArray) c0026bM111C.f55c).hasValue(0)) {
            setDropDownBackgroundDrawable(c0026bM111C.m140t(0));
        }
        c0026bM111C.m120F();
        C0275u c0275u = new C0275u(this);
        this.f633a = c0275u;
        c0275u.m776e(attributeSet, i6);
        C0291x0 c0291x0 = new C0291x0(this);
        this.f634b = c0291x0;
        c0291x0.m819f(attributeSet, i6);
        c0291x0.m816b();
        C0179b0 c0179b0 = new C0179b0(this);
        this.f635c = c0179b0;
        c0179b0.mo640b(attributeSet, i6);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean zIsFocusable = super.isFocusable();
        boolean zIsClickable = super.isClickable();
        boolean zIsLongClickable = super.isLongClickable();
        int inputType = super.getInputType();
        KeyListener keyListenerM639a = c0179b0.m639a(keyListener);
        if (keyListenerM639a == keyListener) {
            return;
        }
        super.setKeyListener(keyListenerM639a);
        super.setRawInputType(inputType);
        super.setFocusable(zIsFocusable);
        super.setClickable(zIsClickable);
        super.setLongClickable(zIsLongClickable);
    }
}

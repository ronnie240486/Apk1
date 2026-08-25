package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.widget.C0385r;
import androidx.core.widget.InterfaceC0386s;
import androidx.media3.common.C0628x;
import com.p2serv.android.p032ds.R;
import p101j7.C2782c;
import p138n0.AbstractC3155s0;
import p138n0.C3112e;
import p138n0.C3118g;
import p138n0.InterfaceC3109d;
import p138n0.InterfaceC3160u;
import p143n5.AbstractC3198d;
import p156o9.AbstractC3281e;
import p195s0.AbstractC3686c;
import p195s0.C3687d;
import p195s0.C3688e;

public class AppCompatEditText extends EditText implements InterfaceC3160u, InterfaceC0386s {

    public final C0275u f620a;

    public final C0291x0 f621b;

    public final C0179b0 f622c;

    public final C0385r f623d;

    public final C0179b0 f624e;

    public C0290x f625f;

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    private C0290x getSuperCaller() {
        if (this.f625f == null) {
            this.f625f = new C0290x(this);
        }
        return this.f625f;
    }

    @Override
    public final C3118g mo567a(C3118g c3118g) {
        return this.f623d.m1157a(this, c3118g);
    }

    @Override
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0275u c0275u = this.f620a;
        if (c0275u != null) {
            c0275u.m773a();
        }
        C0291x0 c0291x0 = this.f621b;
        if (c0291x0 != null) {
            c0291x0.m816b();
        }
    }

    @Override
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return AbstractC3198d.m6446U(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0275u c0275u = this.f620a;
        if (c0275u != null) {
            return c0275u.m774c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0275u c0275u = this.f620a;
        if (c0275u != null) {
            return c0275u.m775d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f621b.m817d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f621b.m818e();
    }

    @Override
    public TextClassifier getTextClassifier() {
        C0179b0 c0179b0;
        if (Build.VERSION.SDK_INT >= 28 || (c0179b0 = this.f622c) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = (TextClassifier) c0179b0.f873c;
        return textClassifier == null ? AbstractC0251p0.m740a((TextView) c0179b0.f872b) : textClassifier;
    }

    @Override
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        int i6;
        String[] strArrM6337g;
        String[] stringArray;
        InputConnection c3688e;
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f621b.getClass();
        C0291x0.m814h(editorInfo, inputConnectionOnCreateInputConnection, this);
        AbstractC3281e.m6611A(editorInfo, inputConnectionOnCreateInputConnection, this);
        if (inputConnectionOnCreateInputConnection != null && (i6 = Build.VERSION.SDK_INT) <= 30 && (strArrM6337g = AbstractC3155s0.m6337g(this)) != null) {
            if (i6 >= 25) {
                editorInfo.contentMimeTypes = strArrM6337g;
            } else {
                if (editorInfo.extras == null) {
                    editorInfo.extras = new Bundle();
                }
                editorInfo.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArrM6337g);
                editorInfo.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArrM6337g);
            }
            C0628x c0628x = new C0628x(20, this);
            if (i6 >= 25) {
                c3688e = new C3687d(inputConnectionOnCreateInputConnection, c0628x);
            } else {
                String[] strArr = AbstractC3686c.f12340a;
                if (i6 >= 25) {
                    stringArray = editorInfo.contentMimeTypes;
                    if (stringArray != null) {
                        strArr = stringArray;
                    }
                } else {
                    Bundle bundle = editorInfo.extras;
                    if (bundle != null) {
                        stringArray = bundle.getStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
                        if (stringArray == null) {
                            stringArray = editorInfo.extras.getStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
                        }
                        if (stringArray != null) {
                            strArr = stringArray;
                        }
                    }
                }
                if (strArr.length != 0) {
                    c3688e = new C3688e(inputConnectionOnCreateInputConnection, c0628x);
                }
            }
            inputConnectionOnCreateInputConnection = c3688e;
        }
        return this.f624e.m641c(inputConnectionOnCreateInputConnection, editorInfo);
    }

    @Override
    public final boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        int i6 = Build.VERSION.SDK_INT;
        boolean zM645a = false;
        if (i6 < 31 && i6 >= 24 && dragEvent.getLocalState() == null && AbstractC3155s0.m6337g(this) != null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                }
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (activity == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + this);
            } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                zM645a = AbstractC0185c0.m645a(dragEvent, this, activity);
            }
        }
        if (zM645a) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override
    public final boolean onTextContextMenuItem(int i6) {
        C3112e c3112e;
        InterfaceC3109d interfaceC3109d;
        int i10;
        C2782c c2782c;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 31 || AbstractC3155s0.m6337g(this) == null || !(i6 == 16908322 || i6 == 16908337)) {
            return super.onTextContextMenuItem(i6);
        }
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            if (i11 >= 31) {
                c2782c = new C2782c(primaryClip, 1);
            } else {
                c3112e = new C3112e();
                c3112e.f10586b = primaryClip;
                c3112e.f10587c = 1;
            }
            if (i6 == 16908322) {
                interfaceC3109d = c3112e;
                interfaceC3109d = c2782c;
                i10 = 0;
            } else {
                interfaceC3109d = c3112e;
                interfaceC3109d = c2782c;
                i10 = 1;
            }
            interfaceC3109d.setFlags(i10);
            AbstractC3155s0.m6342l(this, interfaceC3109d.mo5753f());
        }
        return true;
    }

    @Override
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0275u c0275u = this.f620a;
        if (c0275u != null) {
            c0275u.m777f();
        }
    }

    @Override
    public void setBackgroundResource(int i6) {
        super.setBackgroundResource(i6);
        C0275u c0275u = this.f620a;
        if (c0275u != null) {
            c0275u.m778g(i6);
        }
    }

    @Override
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0291x0 c0291x0 = this.f621b;
        if (c0291x0 != null) {
            c0291x0.m816b();
        }
    }

    @Override
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0291x0 c0291x0 = this.f621b;
        if (c0291x0 != null) {
            c0291x0.m816b();
        }
    }

    @Override
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(AbstractC3198d.m6449X(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z7) {
        this.f624e.m642d(z7);
    }

    @Override
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f624e.m639a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0275u c0275u = this.f620a;
        if (c0275u != null) {
            c0275u.m780i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0275u c0275u = this.f620a;
        if (c0275u != null) {
            c0275u.m781j(mode);
        }
    }

    @Override
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C0291x0 c0291x0 = this.f621b;
        c0291x0.m824l(colorStateList);
        c0291x0.m816b();
    }

    @Override
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C0291x0 c0291x0 = this.f621b;
        c0291x0.m825m(mode);
        c0291x0.m816b();
    }

    @Override
    public final void setTextAppearance(Context context, int i6) {
        super.setTextAppearance(context, i6);
        C0291x0 c0291x0 = this.f621b;
        if (c0291x0 != null) {
            c0291x0.m820g(context, i6);
        }
    }

    @Override
    public void setTextClassifier(TextClassifier textClassifier) {
        C0179b0 c0179b0;
        if (Build.VERSION.SDK_INT >= 28 || (c0179b0 = this.f622c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            c0179b0.f873c = textClassifier;
        }
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        AbstractC0229k3.m718a(context);
        AbstractC0224j3.m702a(this, getContext());
        C0275u c0275u = new C0275u(this);
        this.f620a = c0275u;
        c0275u.m776e(attributeSet, i6);
        C0291x0 c0291x0 = new C0291x0(this);
        this.f621b = c0291x0;
        c0291x0.m819f(attributeSet, i6);
        c0291x0.m816b();
        C0179b0 c0179b0 = new C0179b0();
        c0179b0.f872b = this;
        this.f622c = c0179b0;
        this.f623d = new C0385r();
        C0179b0 c0179b1 = new C0179b0(this);
        this.f624e = c0179b1;
        c0179b1.mo640b(attributeSet, i6);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean zIsFocusable = super.isFocusable();
        boolean zIsClickable = super.isClickable();
        boolean zIsLongClickable = super.isLongClickable();
        int inputType = super.getInputType();
        KeyListener keyListenerM639a = c0179b1.m639a(keyListener);
        if (keyListenerM639a == keyListener) {
            return;
        }
        super.setKeyListener(keyListenerM639a);
        super.setRawInputType(inputType);
        super.setFocusable(zIsFocusable);
        super.setClickable(zIsClickable);
        super.setLongClickable(zIsLongClickable);
    }

    @Override
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }
}

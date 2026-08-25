package androidx.leanback.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.TextView;
import p143n5.AbstractC3198d;

@SuppressLint({"AppCompatCustomView"})
public class GuidedActionEditText extends EditText {

    public final Drawable f2137a;

    public final C0504x f2138b;

    public GuidedActionEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    @Override
    public int getAutofillType() {
        return 1;
    }

    @Override
    public final void onFocusChanged(boolean z7, int i6, Rect rect) {
        super.onFocusChanged(z7, i6, rect);
        if (z7) {
            setBackground(this.f2137a);
        } else {
            setBackground(this.f2138b);
        }
        if (z7) {
            return;
        }
        setFocusable(false);
    }

    @Override
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((isFocused() ? EditText.class : TextView.class).getName());
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isInTouchMode() || isFocusableInTouchMode() || isTextSelectable()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(AbstractC3198d.m6449X(callback, this));
    }

    public GuidedActionEditText(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f2137a = getBackground();
        C0504x c0504x = new C0504x();
        this.f2138b = c0504x;
        setBackground(c0504x);
    }

    public void setImeKeyListener(InterfaceC0506y interfaceC0506y) {
    }

    public void setOnAutofillListener(InterfaceC0502w interfaceC0502w) {
    }
}

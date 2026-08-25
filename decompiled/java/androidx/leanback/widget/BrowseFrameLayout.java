package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;

public class BrowseFrameLayout extends FrameLayout {

    public View.OnKeyListener f2082a;

    public BrowseFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean zDispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        View.OnKeyListener onKeyListener = this.f2082a;
        return (onKeyListener == null || zDispatchKeyEvent) ? zDispatchKeyEvent : onKeyListener.onKey(getRootView(), keyEvent.getKeyCode(), keyEvent);
    }

    public InterfaceC0477k getOnChildFocusListener() {
        return null;
    }

    public InterfaceC0480l getOnFocusSearchListener() {
        return null;
    }

    @Override
    public final boolean onRequestFocusInDescendants(int i6, Rect rect) {
        return super.onRequestFocusInDescendants(i6, rect);
    }

    public void setOnDispatchKeyListener(View.OnKeyListener onKeyListener) {
        this.f2082a = onKeyListener;
    }

    public BrowseFrameLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }

    public void setOnChildFocusListener(InterfaceC0477k interfaceC0477k) {
    }

    public void setOnFocusSearchListener(InterfaceC0480l interfaceC0480l) {
    }
}

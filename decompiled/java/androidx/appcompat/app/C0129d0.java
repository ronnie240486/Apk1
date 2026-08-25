package androidx.appcompat.app;

import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.widget.ContentFrameLayout;
import com.bumptech.glide.AbstractC1465c;
import p093j.C2743d;

public final class C0129d0 extends ContentFrameLayout {

    public final LayoutInflaterFactory2C0135g0 f272i;

    public C0129d0(LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0, C2743d c2743d) {
        super(c2743d, null);
        this.f272i = layoutInflaterFactory2C0135g0;
    }

    @Override
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f272i.m407u(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int x10 = (int) motionEvent.getX();
            int y7 = (int) motionEvent.getY();
            if (x10 < -5 || y7 < -5 || x10 > getWidth() + 5 || y7 > getHeight() + 5) {
                LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0 = this.f272i;
                layoutInflaterFactory2C0135g0.m406s(layoutInflaterFactory2C0135g0.m383A(0), true);
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override
    public final void setBackgroundResource(int i6) {
        setBackgroundDrawable(AbstractC1465c.m3473h(getContext(), i6));
    }
}

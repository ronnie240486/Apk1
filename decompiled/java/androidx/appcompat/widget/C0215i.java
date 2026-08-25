package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.p2serv.android.p032ds.R;
import p065g0.AbstractC2581a;
import p187r4.AbstractC3612b;

public final class C0215i extends AppCompatImageView implements InterfaceC0230l {

    public final C0225k f943d;

    public C0215i(C0225k c0225k, Context context) {
        super(context, null, R.attr.actionOverflowButtonStyle);
        this.f943d = c0225k;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        AbstractC3612b.m7256L(this, getContentDescription());
        setOnTouchListener(new C0210h(this, this, 0));
    }

    @Override
    public final boolean mo530a() {
        return false;
    }

    @Override
    public final boolean mo531b() {
        return false;
    }

    @Override
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        this.f943d.m716n();
        return true;
    }

    @Override
    public final boolean setFrame(int i6, int i10, int i11, int i12) {
        boolean frame = super.setFrame(i6, i10, i11, i12);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (drawable != null && background != null) {
            int width = getWidth();
            int height = getHeight();
            int iMax = Math.max(width, height) / 2;
            int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            AbstractC2581a.m5584f(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
        }
        return frame;
    }
}

package androidx.leanback.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

class NonOverlappingLinearLayoutWithForeground extends LinearLayout {

    public final Drawable f2176a;

    public boolean f2177b;

    public final Rect f2178c;

    public NonOverlappingLinearLayoutWithForeground(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f2176a;
        if (drawable != null) {
            if (this.f2177b) {
                this.f2177b = false;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                Rect rect = this.f2178c;
                rect.set(0, 0, right, bottom);
                drawable.setBounds(rect);
            }
            drawable.draw(canvas);
        }
    }

    @Override
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f2176a;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.f2176a.setState(getDrawableState());
    }

    @Override
    public final boolean hasOverlappingRendering() {
        return false;
    }

    @Override
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2176a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        super.onLayout(z7, i6, i10, i11, i12);
        this.f2177b = z7 | this.f2177b;
    }

    @Override
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2176a;
    }

    public NonOverlappingLinearLayoutWithForeground(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f2178c = new Rect();
        if (context.getApplicationInfo().targetSdkVersion < 23 || Build.VERSION.SDK_INT < 23) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.foreground});
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
            if (drawable != null) {
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 23) {
                    if (i10 >= 23) {
                        setForeground(drawable);
                    }
                } else if (this.f2176a != drawable) {
                    this.f2176a = drawable;
                    this.f2177b = true;
                    setWillNotDraw(false);
                    this.f2176a.setCallback(this);
                    if (this.f2176a.isStateful()) {
                        this.f2176a.setState(getDrawableState());
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}

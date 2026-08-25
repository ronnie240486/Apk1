package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

public final class C0178b extends Drawable {

    public final ActionBarContainer f869a;

    public C0178b(ActionBarContainer actionBarContainer) {
        this.f869a = actionBarContainer;
    }

    @Override
    public final void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f869a;
        if (actionBarContainer.f523g) {
            Drawable drawable = actionBarContainer.f522f;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f520d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Drawable drawable3 = actionBarContainer.f521e;
        if (drawable3 == null || !actionBarContainer.f524h) {
            return;
        }
        drawable3.draw(canvas);
    }

    @Override
    public final int getOpacity() {
        return 0;
    }

    @Override
    public final void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f869a;
        if (actionBarContainer.f523g) {
            if (actionBarContainer.f522f != null) {
                actionBarContainer.f520d.getOutline(outline);
            }
        } else {
            Drawable drawable = actionBarContainer.f520d;
            if (drawable != null) {
                drawable.getOutline(outline);
            }
        }
    }

    @Override
    public final void setAlpha(int i6) {
    }

    @Override
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}

package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.p2serv.android.p032ds.R;

final class RowContainerView extends LinearLayout {

    public Drawable f2218a;

    public boolean f2219b;

    public RowContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f2218a;
        if (drawable != null) {
            if (this.f2219b) {
                this.f2219b = false;
                drawable.setBounds(0, 0, getWidth(), getHeight());
            }
            this.f2218a.draw(canvas);
        }
    }

    @Override
    public final Drawable getForeground() {
        return this.f2218a;
    }

    @Override
    public final boolean hasOverlappingRendering() {
        return false;
    }

    @Override
    public final void onSizeChanged(int i6, int i10, int i11, int i12) {
        super.onSizeChanged(i6, i10, i11, i12);
        this.f2219b = true;
    }

    @Override
    public final void setForeground(Drawable drawable) {
        this.f2218a = drawable;
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public RowContainerView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f2219b = true;
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.lb_row_container, this);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    }
}

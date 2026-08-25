package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.p2serv.android.p032ds.R;

public final class SeekBar extends View {

    public final RectF f2267a;

    public final RectF f2268b;

    public final RectF f2269c;

    public final Paint f2270d;

    public final Paint f2271e;

    public final Paint f2272f;

    public final Paint f2273g;

    public int f2274h;

    public int f2275i;

    public int f2276j;

    public int f2277k;

    public int f2278l;

    public int f2279m;

    public int f2280n;

    public SeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2267a = new RectF();
        this.f2268b = new RectF();
        this.f2269c = new RectF();
        Paint paint = new Paint(1);
        this.f2270d = paint;
        Paint paint2 = new Paint(1);
        this.f2271e = paint2;
        Paint paint3 = new Paint(1);
        this.f2272f = paint3;
        Paint paint4 = new Paint(1);
        this.f2273g = paint4;
        setWillNotDraw(false);
        paint3.setColor(-7829368);
        paint.setColor(-3355444);
        paint2.setColor(-65536);
        paint4.setColor(-1);
        this.f2279m = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_progressbar_bar_height);
        this.f2280n = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_progressbar_active_bar_height);
        this.f2278l = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_progressbar_active_radius);
    }

    public final void m1401a() {
        int i6 = isFocused() ? this.f2280n : this.f2279m;
        int width = getWidth();
        int height = getHeight();
        int i10 = (height - i6) / 2;
        RectF rectF = this.f2269c;
        int i11 = this.f2279m;
        float f = i10;
        float f3 = height - i10;
        rectF.set(i11 / 2, f, width - (i11 / 2), f3);
        int i12 = isFocused() ? this.f2278l : this.f2279m / 2;
        float f4 = width - (i12 * 2);
        float f5 = (this.f2274h / this.f2276j) * f4;
        RectF rectF2 = this.f2267a;
        int i13 = this.f2279m;
        rectF2.set(i13 / 2, f, (i13 / 2) + f5, f3);
        this.f2268b.set(rectF2.right, f, (this.f2279m / 2) + ((this.f2275i / this.f2276j) * f4), f3);
        this.f2277k = i12 + ((int) f5);
        invalidate();
    }

    @Override
    public CharSequence getAccessibilityClassName() {
        return android.widget.SeekBar.class.getName();
    }

    public int getMax() {
        return this.f2276j;
    }

    public int getProgress() {
        return this.f2274h;
    }

    public int getSecondProgress() {
        return this.f2275i;
    }

    public int getSecondaryProgressColor() {
        return this.f2270d.getColor();
    }

    @Override
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = isFocused() ? this.f2278l : this.f2279m / 2;
        canvas.drawRoundRect(this.f2269c, f, f, this.f2272f);
        RectF rectF = this.f2268b;
        if (rectF.right > rectF.left) {
            canvas.drawRoundRect(rectF, f, f, this.f2270d);
        }
        canvas.drawRoundRect(this.f2267a, f, f, this.f2271e);
        canvas.drawCircle(this.f2277k, getHeight() / 2, f, this.f2273g);
    }

    @Override
    public final void onFocusChanged(boolean z7, int i6, Rect rect) {
        super.onFocusChanged(z7, i6, rect);
        m1401a();
    }

    @Override
    public final void onSizeChanged(int i6, int i10, int i11, int i12) {
        super.onSizeChanged(i6, i10, i11, i12);
        m1401a();
    }

    public void setActiveBarHeight(int i6) {
        this.f2280n = i6;
        m1401a();
    }

    public void setActiveRadius(int i6) {
        this.f2278l = i6;
        m1401a();
    }

    public void setBarHeight(int i6) {
        this.f2279m = i6;
        m1401a();
    }

    public void setMax(int i6) {
        this.f2276j = i6;
        m1401a();
    }

    public void setProgress(int i6) {
        int i10 = this.f2276j;
        if (i6 > i10) {
            i6 = i10;
        } else if (i6 < 0) {
            i6 = 0;
        }
        this.f2274h = i6;
        m1401a();
    }

    public void setProgressColor(int i6) {
        this.f2271e.setColor(i6);
    }

    public void setSecondaryProgress(int i6) {
        int i10 = this.f2276j;
        if (i6 > i10) {
            i6 = i10;
        } else if (i6 < 0) {
            i6 = 0;
        }
        this.f2275i = i6;
        m1401a();
    }

    public void setSecondaryProgressColor(int i6) {
        this.f2270d.setColor(i6);
    }

    public void setAccessibilitySeekListener(AbstractC0509z0 abstractC0509z0) {
    }
}

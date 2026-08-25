package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;
import p015b2.ViewOnClickListenerC1250b;
import p222u7.AbstractC3928d;

public class PagerTabStrip extends PagerTitleStrip {

    public boolean f3819A;

    public final int f3820B;

    public boolean f3821C;

    public float f3822D;

    public float f3823E;

    public final int f3824F;

    public int f3825q;

    public final int f3826r;

    public final int f3827s;

    public final int f3828t;

    public final int f3829u;

    public final int f3830v;

    public final Paint f3831w;

    public final Rect f3832x;

    public int f3833y;

    public boolean f3834z;

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f3831w = paint;
        this.f3832x = new Rect();
        this.f3833y = 255;
        this.f3834z = false;
        this.f3819A = false;
        int i6 = this.f3850n;
        this.f3825q = i6;
        paint.setColor(i6);
        float f = context.getResources().getDisplayMetrics().density;
        this.f3826r = (int) ((3.0f * f) + 0.5f);
        this.f3827s = (int) ((6.0f * f) + 0.5f);
        this.f3828t = (int) (64.0f * f);
        this.f3830v = (int) ((16.0f * f) + 0.5f);
        this.f3820B = (int) ((1.0f * f) + 0.5f);
        this.f3829u = (int) ((f * 32.0f) + 0.5f);
        this.f3824F = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.f3838b.setFocusable(true);
        this.f3838b.setOnClickListener(new ViewOnClickListenerC1250b(this, 0));
        this.f3840d.setFocusable(true);
        this.f3840d.setOnClickListener(new ViewOnClickListenerC1250b(this, 1));
        if (getBackground() == null) {
            this.f3834z = true;
        }
    }

    @Override
    public final void mo3078c(float f, int i6, boolean z7) {
        int height = getHeight();
        TextView textView = this.f3839c;
        int left = textView.getLeft();
        int i10 = this.f3830v;
        int right = textView.getRight() + i10;
        int i11 = height - this.f3826r;
        Rect rect = this.f3832x;
        rect.set(left - i10, i11, right, height);
        super.mo3078c(f, i6, z7);
        this.f3833y = (int) (Math.abs(f - 0.5f) * 2.0f * 255.0f);
        rect.union(textView.getLeft() - i10, i11, textView.getRight() + i10, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.f3834z;
    }

    @Override
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.f3829u);
    }

    public int getTabIndicatorColor() {
        return this.f3825q;
    }

    @Override
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        TextView textView = this.f3839c;
        int left = textView.getLeft();
        int i6 = this.f3830v;
        int i10 = left - i6;
        int right = textView.getRight() + i6;
        int i11 = height - this.f3826r;
        Paint paint = this.f3831w;
        paint.setColor((this.f3833y << 24) | (this.f3825q & 16777215));
        float f = right;
        float f3 = height;
        canvas.drawRect(i10, i11, f, f3, paint);
        if (this.f3834z) {
            paint.setColor((this.f3825q & 16777215) | (-16777216));
            canvas.drawRect(getPaddingLeft(), height - this.f3820B, getWidth() - getPaddingRight(), f3, paint);
        }
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.f3821C) {
            return false;
        }
        float x10 = motionEvent.getX();
        float y7 = motionEvent.getY();
        if (action == 0) {
            this.f3822D = x10;
            this.f3823E = y7;
            this.f3821C = false;
        } else if (action == 1) {
            TextView textView = this.f3839c;
            int left = textView.getLeft();
            int i6 = this.f3830v;
            if (x10 < left - i6) {
                ViewPager viewPager = this.f3837a;
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            } else if (x10 > textView.getRight() + i6) {
                ViewPager viewPager2 = this.f3837a;
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            }
        } else if (action == 2) {
            float fAbs = Math.abs(x10 - this.f3822D);
            float f = this.f3824F;
            if (fAbs > f || Math.abs(y7 - this.f3823E) > f) {
                this.f3821C = true;
            }
        }
        return true;
    }

    @Override
    public void setBackgroundColor(int i6) {
        super.setBackgroundColor(i6);
        if (this.f3819A) {
            return;
        }
        this.f3834z = (i6 & (-16777216)) == 0;
    }

    @Override
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f3819A) {
            return;
        }
        this.f3834z = drawable == null;
    }

    @Override
    public void setBackgroundResource(int i6) {
        super.setBackgroundResource(i6);
        if (this.f3819A) {
            return;
        }
        this.f3834z = i6 == 0;
    }

    public void setDrawFullUnderline(boolean z7) {
        this.f3834z = z7;
        this.f3819A = true;
        invalidate();
    }

    @Override
    public final void setPadding(int i6, int i10, int i11, int i12) {
        int i13 = this.f3827s;
        if (i12 < i13) {
            i12 = i13;
        }
        super.setPadding(i6, i10, i11, i12);
    }

    public void setTabIndicatorColor(int i6) {
        this.f3825q = i6;
        this.f3831w.setColor(i6);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i6) {
        setTabIndicatorColor(AbstractC3928d.m7847i(getContext(), i6));
    }

    @Override
    public void setTextSpacing(int i6) {
        int i10 = this.f3828t;
        if (i6 < i10) {
            i6 = i10;
        }
        super.setTextSpacing(i6);
    }
}

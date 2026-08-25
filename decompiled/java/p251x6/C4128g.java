package p251x6;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.internal.AbstractC1811a0;
import com.google.android.material.tabs.TabLayout;
import java.util.WeakHashMap;
import p065g0.AbstractC2581a;
import p138n0.AbstractC3155s0;
import p143n5.AbstractC3198d;
import p171q.C3388b;
import p262y5.AbstractC4268a;

public final class C4128g extends LinearLayout {

    public static final int f14021f = 0;

    public ValueAnimator f14022a;

    public int f14023b;

    public float f14024c;

    public int f14025d;

    public final TabLayout f14026e;

    public C4128g(TabLayout tabLayout, Context context) {
        super(context);
        this.f14026e = tabLayout;
        this.f14023b = -1;
        this.f14025d = -1;
        setWillNotDraw(false);
    }

    public final void m8141a() {
        View childAt = getChildAt(this.f14023b);
        TabLayout tabLayout = this.f14026e;
        C3388b c3388b = tabLayout.f6695F;
        Drawable drawable = tabLayout.f6718l;
        c3388b.getClass();
        RectF rectFM6878c = C3388b.m6878c(tabLayout, childAt);
        drawable.setBounds((int) rectFM6878c.left, drawable.getBounds().top, (int) rectFM6878c.right, drawable.getBounds().bottom);
    }

    public final void m8142b(int i6) {
        TabLayout tabLayout = this.f14026e;
        Rect bounds = tabLayout.f6718l.getBounds();
        tabLayout.f6718l.setBounds(bounds.left, 0, bounds.right, i6);
        requestLayout();
    }

    public final void m8143c(View view, View view2, float f) {
        TabLayout tabLayout = this.f14026e;
        if (view == null || view.getWidth() <= 0) {
            Drawable drawable = tabLayout.f6718l;
            drawable.setBounds(-1, drawable.getBounds().top, -1, tabLayout.f6718l.getBounds().bottom);
        } else {
            tabLayout.f6695F.mo6881e(tabLayout, view, view2, f, tabLayout.f6718l);
        }
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        postInvalidateOnAnimation();
    }

    public final void m8144d(int i6, int i10, boolean z7) {
        View childAt = getChildAt(this.f14023b);
        View childAt2 = getChildAt(i6);
        if (childAt2 == null) {
            m8141a();
            return;
        }
        C4126e c4126e = new C4126e(this, childAt, childAt2);
        if (!z7) {
            this.f14022a.removeAllUpdateListeners();
            this.f14022a.addUpdateListener(c4126e);
            return;
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f14022a = valueAnimator;
        valueAnimator.setInterpolator(AbstractC4268a.f14470b);
        valueAnimator.setDuration(i10);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.addUpdateListener(c4126e);
        valueAnimator.addListener(new C4127f(this, i6));
        valueAnimator.start();
    }

    @Override
    public final void draw(Canvas canvas) {
        int height;
        TabLayout tabLayout = this.f14026e;
        int iHeight = tabLayout.f6718l.getBounds().height();
        if (iHeight < 0) {
            iHeight = tabLayout.f6718l.getIntrinsicHeight();
        }
        int i6 = tabLayout.f6731y;
        if (i6 == 0) {
            height = getHeight() - iHeight;
            iHeight = getHeight();
        } else if (i6 != 1) {
            height = 0;
            if (i6 != 2) {
                iHeight = i6 != 3 ? 0 : getHeight();
            }
        } else {
            height = (getHeight() - iHeight) / 2;
            iHeight = (getHeight() + iHeight) / 2;
        }
        if (tabLayout.f6718l.getBounds().width() > 0) {
            Rect bounds = tabLayout.f6718l.getBounds();
            tabLayout.f6718l.setBounds(bounds.left, height, bounds.right, iHeight);
            Drawable drawableM6448W = tabLayout.f6718l;
            if (tabLayout.f6719m != 0) {
                drawableM6448W = AbstractC3198d.m6448W(drawableM6448W);
                if (Build.VERSION.SDK_INT == 21) {
                    drawableM6448W.setColorFilter(tabLayout.f6719m, PorterDuff.Mode.SRC_IN);
                } else {
                    AbstractC2581a.m5585g(drawableM6448W, tabLayout.f6719m);
                }
            } else if (Build.VERSION.SDK_INT == 21) {
                drawableM6448W.setColorFilter(null);
            } else {
                AbstractC2581a.m5586h(drawableM6448W, null);
            }
            drawableM6448W.draw(canvas);
        }
        super.draw(canvas);
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        super.onLayout(z7, i6, i10, i11, i12);
        ValueAnimator valueAnimator = this.f14022a;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            m8141a();
        } else {
            m8144d(this.f14023b, -1, false);
        }
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        super.onMeasure(i6, i10);
        if (View.MeasureSpec.getMode(i6) != 1073741824) {
            return;
        }
        TabLayout tabLayout = this.f14026e;
        boolean z7 = true;
        if (tabLayout.f6729w == 1 || tabLayout.f6732z == 2) {
            int childCount = getChildCount();
            int iMax = 0;
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (childAt.getVisibility() == 0) {
                    iMax = Math.max(iMax, childAt.getMeasuredWidth());
                }
            }
            if (iMax <= 0) {
                return;
            }
            if (iMax * childCount <= getMeasuredWidth() - (((int) AbstractC1811a0.m4245e(getContext(), 16)) * 2)) {
                boolean z10 = false;
                for (int i12 = 0; i12 < childCount; i12++) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i12).getLayoutParams();
                    if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                        layoutParams.width = iMax;
                        layoutParams.weight = 0.0f;
                        z10 = true;
                    }
                }
                z7 = z10;
            } else {
                tabLayout.f6729w = 0;
                tabLayout.m4349p(false);
            }
            if (z7) {
                super.onMeasure(i6, i10);
            }
        }
    }

    @Override
    public final void onRtlPropertiesChanged(int i6) {
        super.onRtlPropertiesChanged(i6);
        if (Build.VERSION.SDK_INT >= 23 || this.f14025d == i6) {
            return;
        }
        requestLayout();
        this.f14025d = i6;
    }
}

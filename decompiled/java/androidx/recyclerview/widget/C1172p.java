package androidx.recyclerview.widget;

import android.R;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import p007a7.C0070g;

public final class C1172p extends AbstractC1185t0 implements InterfaceC1124a1 {

    public static final int[] f3642C = {R.attr.state_pressed};

    public static final int[] f3643D = new int[0];

    public int f3644A;

    public final RunnableC1163m f3645B;

    public final int f3646a;

    public final int f3647b;

    public final StateListDrawable f3648c;

    public final Drawable f3649d;

    public final int f3650e;

    public final int f3651f;

    public final StateListDrawable f3652g;

    public final Drawable f3653h;

    public final int f3654i;

    public final int f3655j;

    public int f3656k;

    public int f3657l;

    public float f3658m;

    public int f3659n;

    public int f3660o;

    public float f3661p;

    public final RecyclerView f3664s;

    public final ValueAnimator f3671z;

    public int f3662q = 0;

    public int f3663r = 0;

    public boolean f3665t = false;

    public boolean f3666u = false;

    public int f3667v = 0;

    public int f3668w = 0;

    public final int[] f3669x = new int[2];

    public final int[] f3670y = new int[2];

    public C1172p(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i6, int i10, int i11) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f3671z = valueAnimatorOfFloat;
        this.f3644A = 0;
        RunnableC1163m runnableC1163m = new RunnableC1163m(0, this);
        this.f3645B = runnableC1163m;
        C1166n c1166n = new C1166n(this);
        this.f3648c = stateListDrawable;
        this.f3649d = drawable;
        this.f3652g = stateListDrawable2;
        this.f3653h = drawable2;
        this.f3650e = Math.max(i6, stateListDrawable.getIntrinsicWidth());
        this.f3651f = Math.max(i6, drawable.getIntrinsicWidth());
        this.f3654i = Math.max(i6, stateListDrawable2.getIntrinsicWidth());
        this.f3655j = Math.max(i6, drawable2.getIntrinsicWidth());
        this.f3646a = i10;
        this.f3647b = i11;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new C0070g(this));
        valueAnimatorOfFloat.addUpdateListener(new C1169o(this));
        RecyclerView recyclerView2 = this.f3664s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            recyclerView2.removeItemDecoration(this);
            this.f3664s.removeOnItemTouchListener(this);
            this.f3664s.removeOnScrollListener(c1166n);
            this.f3664s.removeCallbacks(runnableC1163m);
        }
        this.f3664s = recyclerView;
        if (recyclerView != null) {
            recyclerView.addItemDecoration(this);
            this.f3664s.addOnItemTouchListener(this);
            this.f3664s.addOnScrollListener(c1166n);
        }
    }

    public static int m2975c(float f, float f3, int[] iArr, int i6, int i10, int i11) {
        int i12 = iArr[1] - iArr[0];
        if (i12 == 0) {
            return 0;
        }
        int i13 = i6 - i11;
        int i14 = (int) (((f3 - f) / i12) * i13);
        int i15 = i10 + i14;
        if (i15 >= i13 || i15 < 0) {
            return 0;
        }
        return i14;
    }

    public final boolean m2976a(float f, float f3) {
        if (f3 >= this.f3663r - this.f3654i) {
            int i6 = this.f3660o;
            int i10 = this.f3659n;
            if (f >= i6 - (i10 / 2) && f <= (i10 / 2) + i6) {
                return true;
            }
        }
        return false;
    }

    public final boolean m2977b(float f, float f3) {
        boolean z7 = this.f3664s.getLayoutDirection() == 1;
        int i6 = this.f3650e;
        if (z7) {
            if (f > i6) {
                return false;
            }
        } else if (f < this.f3662q - i6) {
            return false;
        }
        int i10 = this.f3657l;
        int i11 = this.f3656k / 2;
        return f3 >= ((float) (i10 - i11)) && f3 <= ((float) (i11 + i10));
    }

    public final void m2978d(int i6) {
        RunnableC1163m runnableC1163m = this.f3645B;
        StateListDrawable stateListDrawable = this.f3648c;
        if (i6 == 2 && this.f3667v != 2) {
            stateListDrawable.setState(f3642C);
            this.f3664s.removeCallbacks(runnableC1163m);
        }
        if (i6 == 0) {
            this.f3664s.invalidate();
        } else {
            m2979e();
        }
        if (this.f3667v == 2 && i6 != 2) {
            stateListDrawable.setState(f3643D);
            this.f3664s.removeCallbacks(runnableC1163m);
            this.f3664s.postDelayed(runnableC1163m, 1200);
        } else if (i6 == 1) {
            this.f3664s.removeCallbacks(runnableC1163m);
            this.f3664s.postDelayed(runnableC1163m, 1500);
        }
        this.f3667v = i6;
    }

    public final void m2979e() {
        int i6 = this.f3644A;
        ValueAnimator valueAnimator = this.f3671z;
        if (i6 != 0) {
            if (i6 != 3) {
                return;
            } else {
                valueAnimator.cancel();
            }
        }
        this.f3644A = 1;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.setStartDelay(0L);
        valueAnimator.start();
    }

    @Override
    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, C1162l1 c1162l1) {
        if (this.f3662q != this.f3664s.getWidth() || this.f3663r != this.f3664s.getHeight()) {
            this.f3662q = this.f3664s.getWidth();
            this.f3663r = this.f3664s.getHeight();
            m2978d(0);
            return;
        }
        if (this.f3644A != 0) {
            if (this.f3665t) {
                int i6 = this.f3662q;
                int i10 = this.f3650e;
                int i11 = i6 - i10;
                int i12 = this.f3657l;
                int i13 = this.f3656k;
                int i14 = i12 - (i13 / 2);
                StateListDrawable stateListDrawable = this.f3648c;
                stateListDrawable.setBounds(0, 0, i10, i13);
                int i15 = this.f3663r;
                int i16 = this.f3651f;
                Drawable drawable = this.f3649d;
                drawable.setBounds(0, 0, i16, i15);
                if (this.f3664s.getLayoutDirection() == 1) {
                    drawable.draw(canvas);
                    canvas.translate(i10, i14);
                    canvas.scale(-1.0f, 1.0f);
                    stateListDrawable.draw(canvas);
                    canvas.scale(-1.0f, 1.0f);
                    canvas.translate(-i10, -i14);
                } else {
                    canvas.translate(i11, 0.0f);
                    drawable.draw(canvas);
                    canvas.translate(0.0f, i14);
                    stateListDrawable.draw(canvas);
                    canvas.translate(-i11, -i14);
                }
            }
            if (this.f3666u) {
                int i17 = this.f3663r;
                int i18 = this.f3654i;
                int i19 = i17 - i18;
                int i20 = this.f3660o;
                int i21 = this.f3659n;
                int i22 = i20 - (i21 / 2);
                StateListDrawable stateListDrawable2 = this.f3652g;
                stateListDrawable2.setBounds(0, 0, i21, i18);
                int i23 = this.f3662q;
                int i24 = this.f3655j;
                Drawable drawable2 = this.f3653h;
                drawable2.setBounds(0, 0, i23, i24);
                canvas.translate(0.0f, i19);
                drawable2.draw(canvas);
                canvas.translate(i22, 0.0f);
                stateListDrawable2.draw(canvas);
                canvas.translate(-i22, -i19);
            }
        }
    }
}

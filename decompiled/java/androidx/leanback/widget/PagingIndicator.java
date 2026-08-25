package androidx.leanback.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.p2serv.android.p032ds.R;
import p075h1.AbstractC2639a;
import p138n0.AbstractC3155s0;

public class PagingIndicator extends View {

    public static final DecelerateInterpolator f2179w = new DecelerateInterpolator();

    public static final C0464f1 f2180x;

    public static final C0464f1 f2181y;

    public static final C0464f1 f2182z;

    public boolean f2183a;

    public final int f2184b;

    public final int f2185c;

    public final int f2186d;

    public final int f2187e;

    public final int f2188f;

    public final int f2189g;

    public final int f2190h;

    public C0472i0[] f2191i;

    public int[] f2192j;

    public int[] f2193k;

    public int[] f2194l;

    public int f2195m;

    public int f2196n;

    public int f2197o;

    public int f2198p;

    public final Paint f2199q;

    public final Paint f2200r;

    public Bitmap f2201s;

    public Paint f2202t;

    public final Rect f2203u;

    public final float f2204v;

    static {
        Class<Float> cls = Float.class;
        f2180x = new C0464f1("alpha", cls, 1);
        f2181y = new C0464f1("diameter", cls, 2);
        f2182z = new C0464f1("translation_x", cls, 3);
    }

    public PagingIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int getDesiredHeight() {
        return getPaddingBottom() + getPaddingTop() + this.f2187e + this.f2190h;
    }

    private int getDesiredWidth() {
        return getPaddingRight() + getPaddingLeft() + getRequiredWidth();
    }

    private int getRequiredWidth() {
        return ((this.f2196n - 3) * this.f2186d) + (this.f2189g * 2) + (this.f2185c * 2);
    }

    private void setSelectedPage(int i6) {
        if (i6 == this.f2197o) {
            return;
        }
        this.f2197o = i6;
        m1390a();
    }

    public final void m1390a() {
        int i6;
        int i10 = 0;
        while (true) {
            i6 = this.f2197o;
            float f = -1.0f;
            if (i10 >= i6) {
                break;
            }
            this.f2191i[i10].m1439b();
            C0472i0 c0472i0 = this.f2191i[i10];
            if (i10 != 0) {
                f = 1.0f;
            }
            c0472i0.f2342h = f;
            c0472i0.f2338d = this.f2193k[i10];
            i10++;
        }
        C0472i0 c0472i1 = this.f2191i[i6];
        c0472i1.f2337c = 0.0f;
        c0472i1.f2338d = 0.0f;
        PagingIndicator pagingIndicator = c0472i1.f2344j;
        c0472i1.f2339e = pagingIndicator.f2187e;
        float f3 = pagingIndicator.f2188f;
        c0472i1.f2340f = f3;
        c0472i1.f2341g = f3 * pagingIndicator.f2204v;
        c0472i1.f2335a = 1.0f;
        c0472i1.m1438a();
        C0472i0[] c0472i0Arr = this.f2191i;
        int i11 = this.f2197o;
        C0472i0 c0472i2 = c0472i0Arr[i11];
        c0472i2.f2342h = i11 <= 0 ? 1.0f : -1.0f;
        c0472i2.f2338d = this.f2192j[i11];
        while (true) {
            i11++;
            if (i11 >= this.f2196n) {
                return;
            }
            this.f2191i[i11].m1439b();
            C0472i0 c0472i3 = this.f2191i[i11];
            c0472i3.f2342h = 1.0f;
            c0472i3.f2338d = this.f2194l[i11];
        }
    }

    public final void m1391b() {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int requiredWidth = getRequiredWidth();
        int i6 = (paddingLeft + width) / 2;
        int i10 = this.f2196n;
        int[] iArr = new int[i10];
        this.f2192j = iArr;
        int[] iArr2 = new int[i10];
        this.f2193k = iArr2;
        int[] iArr3 = new int[i10];
        this.f2194l = iArr3;
        boolean z7 = this.f2183a;
        int i11 = this.f2185c;
        int i12 = this.f2189g;
        int i13 = this.f2186d;
        int i14 = 1;
        if (z7) {
            int i15 = i6 - (requiredWidth / 2);
            iArr[0] = ((i15 + i11) - i13) + i12;
            iArr2[0] = i15 + i11;
            iArr3[0] = (i12 * 2) + ((i15 + i11) - (i13 * 2));
            while (i14 < this.f2196n) {
                int[] iArr4 = this.f2192j;
                int[] iArr5 = this.f2193k;
                int i16 = i14 - 1;
                iArr4[i14] = iArr5[i16] + i12;
                iArr5[i14] = iArr5[i16] + i13;
                this.f2194l[i14] = iArr4[i16] + i12;
                i14++;
            }
        } else {
            int i17 = (requiredWidth / 2) + i6;
            iArr[0] = ((i17 - i11) + i13) - i12;
            iArr2[0] = i17 - i11;
            iArr3[0] = ((i13 * 2) + (i17 - i11)) - (i12 * 2);
            while (i14 < this.f2196n) {
                int[] iArr6 = this.f2192j;
                int[] iArr7 = this.f2193k;
                int i18 = i14 - 1;
                iArr6[i14] = iArr7[i18] - i12;
                iArr7[i14] = iArr7[i18] - i13;
                this.f2194l[i14] = iArr6[i18] - i12;
                i14++;
            }
        }
        this.f2195m = paddingTop + this.f2188f;
        m1390a();
    }

    public final ObjectAnimator m1392c() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat((Object) null, f2182z, (-this.f2189g) + this.f2186d, 0.0f);
        objectAnimatorOfFloat.setDuration(417L);
        objectAnimatorOfFloat.setInterpolator(f2179w);
        return objectAnimatorOfFloat;
    }

    public final Bitmap m1393d() {
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.lb_ic_nav_arrow);
        if (this.f2183a) {
            return bitmapDecodeResource;
        }
        Matrix matrix = new Matrix();
        matrix.preScale(-1.0f, 1.0f);
        return Bitmap.createBitmap(bitmapDecodeResource, 0, 0, bitmapDecodeResource.getWidth(), bitmapDecodeResource.getHeight(), matrix, false);
    }

    public int[] getDotSelectedLeftX() {
        return this.f2193k;
    }

    public int[] getDotSelectedRightX() {
        return this.f2194l;
    }

    public int[] getDotSelectedX() {
        return this.f2192j;
    }

    public int getPageCount() {
        return this.f2196n;
    }

    @Override
    public final void onDraw(Canvas canvas) {
        for (int i6 = 0; i6 < this.f2196n; i6++) {
            C0472i0 c0472i0 = this.f2191i[i6];
            float f = c0472i0.f2338d + c0472i0.f2337c;
            PagingIndicator pagingIndicator = c0472i0.f2344j;
            canvas.drawCircle(f, pagingIndicator.f2195m, c0472i0.f2340f, pagingIndicator.f2199q);
            if (c0472i0.f2335a > 0.0f) {
                Paint paint = pagingIndicator.f2200r;
                paint.setColor(c0472i0.f2336b);
                canvas.drawCircle(f, pagingIndicator.f2195m, c0472i0.f2340f, paint);
                Bitmap bitmap = pagingIndicator.f2201s;
                float f3 = c0472i0.f2341g;
                float f4 = pagingIndicator.f2195m;
                canvas.drawBitmap(bitmap, pagingIndicator.f2203u, new Rect((int) (f - f3), (int) (f4 - f3), (int) (f + f3), (int) (f4 + f3)), pagingIndicator.f2202t);
            }
        }
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        int desiredHeight = getDesiredHeight();
        int mode = View.MeasureSpec.getMode(i10);
        if (mode == Integer.MIN_VALUE) {
            desiredHeight = Math.min(desiredHeight, View.MeasureSpec.getSize(i10));
        } else if (mode == 1073741824) {
            desiredHeight = View.MeasureSpec.getSize(i10);
        }
        int desiredWidth = getDesiredWidth();
        int mode2 = View.MeasureSpec.getMode(i6);
        if (mode2 == Integer.MIN_VALUE) {
            desiredWidth = Math.min(desiredWidth, View.MeasureSpec.getSize(i6));
        } else if (mode2 == 1073741824) {
            desiredWidth = View.MeasureSpec.getSize(i6);
        }
        setMeasuredDimension(desiredWidth, desiredHeight);
    }

    @Override
    public final void onRtlPropertiesChanged(int i6) {
        super.onRtlPropertiesChanged(i6);
        boolean z7 = i6 == 0;
        if (this.f2183a != z7) {
            this.f2183a = z7;
            this.f2201s = m1393d();
            C0472i0[] c0472i0Arr = this.f2191i;
            if (c0472i0Arr != null) {
                for (C0472i0 c0472i0 : c0472i0Arr) {
                    c0472i0.f2343i = c0472i0.f2344j.f2183a ? 1.0f : -1.0f;
                }
            }
            m1391b();
            invalidate();
        }
    }

    @Override
    public final void onSizeChanged(int i6, int i10, int i11, int i12) {
        setMeasuredDimension(i6, i10);
        m1391b();
    }

    public void setArrowBackgroundColor(int i6) {
        this.f2198p = i6;
    }

    public void setArrowColor(int i6) {
        if (this.f2202t == null) {
            this.f2202t = new Paint();
        }
        this.f2202t.setColorFilter(new PorterDuffColorFilter(i6, PorterDuff.Mode.SRC_IN));
    }

    public void setDotBackgroundColor(int i6) {
        this.f2199q.setColor(i6);
    }

    public void setPageCount(int i6) {
        if (i6 <= 0) {
            throw new IllegalArgumentException("The page count should be a positive integer");
        }
        this.f2196n = i6;
        this.f2191i = new C0472i0[i6];
        for (int i10 = 0; i10 < this.f2196n; i10++) {
            this.f2191i[i10] = new C0472i0(this);
        }
        m1391b();
        setSelectedPage(0);
    }

    public PagingIndicator(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        AnimatorSet animatorSet = new AnimatorSet();
        Resources resources = getResources();
        int[] iArr = AbstractC2639a.f9158b;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i6, 0);
        AbstractC3155s0.m6346p(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i6, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(6, getResources().getDimensionPixelOffset(R.dimen.lb_page_indicator_dot_radius));
        this.f2185c = dimensionPixelOffset;
        int i10 = dimensionPixelOffset * 2;
        this.f2184b = i10;
        int dimensionPixelOffset2 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, getResources().getDimensionPixelOffset(R.dimen.lb_page_indicator_arrow_radius));
        this.f2188f = dimensionPixelOffset2;
        int i11 = dimensionPixelOffset2 * 2;
        this.f2187e = i11;
        this.f2186d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(5, getResources().getDimensionPixelOffset(R.dimen.lb_page_indicator_dot_gap));
        this.f2189g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(4, getResources().getDimensionPixelOffset(R.dimen.lb_page_indicator_arrow_gap));
        int color = typedArrayObtainStyledAttributes.getColor(3, getResources().getColor(R.color.lb_page_indicator_dot));
        Paint paint = new Paint(1);
        this.f2199q = paint;
        paint.setColor(color);
        this.f2198p = typedArrayObtainStyledAttributes.getColor(0, getResources().getColor(R.color.lb_page_indicator_arrow_background));
        if (this.f2202t == null && typedArrayObtainStyledAttributes.hasValue(1)) {
            setArrowColor(typedArrayObtainStyledAttributes.getColor(1, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f2183a = resources.getConfiguration().getLayoutDirection() == 0;
        int color2 = resources.getColor(R.color.lb_page_indicator_arrow_shadow);
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.lb_page_indicator_arrow_shadow_radius);
        this.f2190h = dimensionPixelSize;
        Paint paint2 = new Paint(1);
        this.f2200r = paint2;
        float dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.lb_page_indicator_arrow_shadow_offset);
        paint2.setShadowLayer(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2, color2);
        this.f2201s = m1393d();
        this.f2203u = new Rect(0, 0, this.f2201s.getWidth(), this.f2201s.getHeight());
        float f = i11;
        this.f2204v = this.f2201s.getWidth() / f;
        AnimatorSet animatorSet2 = new AnimatorSet();
        C0464f1 c0464f1 = f2180x;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat((Object) null, c0464f1, 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(167L);
        DecelerateInterpolator decelerateInterpolator = f2179w;
        objectAnimatorOfFloat.setInterpolator(decelerateInterpolator);
        float f3 = i10;
        C0464f1 c0464f2 = f2181y;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat((Object) null, c0464f2, f3, f);
        objectAnimatorOfFloat2.setDuration(417L);
        objectAnimatorOfFloat2.setInterpolator(decelerateInterpolator);
        animatorSet2.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, m1392c());
        AnimatorSet animatorSet3 = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat((Object) null, c0464f1, 1.0f, 0.0f);
        objectAnimatorOfFloat3.setDuration(167L);
        objectAnimatorOfFloat3.setInterpolator(decelerateInterpolator);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat((Object) null, c0464f2, f, f3);
        objectAnimatorOfFloat4.setDuration(417L);
        objectAnimatorOfFloat4.setInterpolator(decelerateInterpolator);
        animatorSet3.playTogether(objectAnimatorOfFloat3, objectAnimatorOfFloat4, m1392c());
        animatorSet.playTogether(animatorSet2, animatorSet3);
        setLayerType(1, null);
    }
}

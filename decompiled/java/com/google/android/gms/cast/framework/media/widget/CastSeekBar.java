package com.google.android.gms.cast.framework.media.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.cast.C1650p0;
import com.google.android.material.textfield.C1877o;
import com.p2serv.android.p032ds.R;
import java.util.ArrayList;
import java.util.regex.Pattern;
import p018b5.AbstractC1312l;
import p138n0.C3151r;
import p173q1.RunnableC3431n1;
import p176q4.AbstractC3480f;
import p187r4.C3624n;
import p210t4.C3809b;
import p219u4.C3893a;
import p219u4.C3894b;
import p230v4.AbstractC3987a;

public class CastSeekBar extends View {

    public static final int f4882t = 0;

    public C3894b f4883a;

    public boolean f4884b;

    public Integer f4885c;

    public C3151r f4886d;

    public ArrayList f4887e;

    public C3624n f4888f;

    public final float f4889g;

    public final float f4890h;

    public final float f4891i;

    public final float f4892j;

    public final float f4893k;

    public final Paint f4894l;

    public final int f4895m;

    public final int f4896n;

    public final int f4897o;

    public final int f4898p;

    public int[] f4899q;

    public Point f4900r;

    public RunnableC3431n1 f4901s;

    public CastSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void m3623a(ArrayList arrayList) {
        if (AbstractC1312l.m3201h(this.f4887e, arrayList)) {
            return;
        }
        this.f4887e = arrayList == null ? null : new ArrayList(arrayList);
        postInvalidate();
    }

    public final int m3624b(int i6) {
        return (int) ((((double) i6) / ((double) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()))) * ((double) this.f4883a.f13089b));
    }

    public final void m3625c(Canvas canvas, int i6, int i10, int i11, int i12, int i13) {
        Paint paint = this.f4894l;
        paint.setColor(i13);
        float f = i11;
        float f3 = i10 / f;
        float f4 = i6 / f;
        float f5 = i12;
        float f10 = this.f4891i;
        canvas.drawRect(f4 * f5, -f10, f3 * f5, f10, paint);
    }

    public final void m3626d(int i6) {
        C3894b c3894b = this.f4883a;
        if (c3894b.f13093f) {
            int i10 = c3894b.f13091d;
            int i11 = c3894b.f13092e;
            Pattern pattern = AbstractC3987a.f13519a;
            this.f4885c = Integer.valueOf(Math.min(Math.max(i6, i10), i11));
            C3624n c3624n = this.f4888f;
            if (c3624n != null) {
                getProgress();
                c3624n.m7342j(true);
            }
            RunnableC3431n1 runnableC3431n1 = this.f4901s;
            if (runnableC3431n1 == null) {
                this.f4901s = new RunnableC3431n1(2, this);
            } else {
                removeCallbacks(runnableC3431n1);
            }
            postDelayed(this.f4901s, 200L);
            postInvalidate();
        }
    }

    public final void m3627e() {
        this.f4884b = true;
        C3624n c3624n = this.f4888f;
        if (c3624n != null) {
            for (C1650p0 c1650p0 : ((C3809b) c3624n.f12182b).f12854d) {
                c1650p0.f5532b = false;
                c1650p0.m3968f();
            }
        }
    }

    public int getMaxProgress() {
        return this.f4883a.f13089b;
    }

    public int getProgress() {
        Integer num = this.f4885c;
        return num != null ? num.intValue() : this.f4883a.f13088a;
    }

    @Override
    public final void onDetachedFromWindow() {
        RunnableC3431n1 runnableC3431n1 = this.f4901s;
        if (runnableC3431n1 != null) {
            removeCallbacks(runnableC3431n1);
        }
        super.onDetachedFromWindow();
    }

    @Override
    public final void onDraw(Canvas canvas) {
        int iSave = canvas.save();
        canvas.translate(getPaddingLeft(), getPaddingTop());
        C3151r c3151r = this.f4886d;
        if (c3151r == null) {
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int progress = getProgress();
            int iSave2 = canvas.save();
            canvas.translate(0.0f, measuredHeight / 2);
            C3894b c3894b = this.f4883a;
            if (c3894b.f13093f) {
                int i6 = c3894b.f13091d;
                if (i6 > 0) {
                    m3625c(canvas, 0, i6, c3894b.f13089b, measuredWidth, this.f4897o);
                }
                C3894b c3894b2 = this.f4883a;
                int i10 = c3894b2.f13091d;
                if (progress > i10) {
                    m3625c(canvas, i10, progress, c3894b2.f13089b, measuredWidth, this.f4895m);
                }
                C3894b c3894b3 = this.f4883a;
                int i11 = c3894b3.f13092e;
                if (i11 > progress) {
                    m3625c(canvas, progress, i11, c3894b3.f13089b, measuredWidth, this.f4896n);
                }
                C3894b c3894b4 = this.f4883a;
                int i12 = c3894b4.f13089b;
                int i13 = c3894b4.f13092e;
                if (i12 > i13) {
                    m3625c(canvas, i13, i12, i12, measuredWidth, this.f4897o);
                }
            } else {
                int iMax = Math.max(c3894b.f13090c, 0);
                if (iMax > 0) {
                    m3625c(canvas, 0, iMax, this.f4883a.f13089b, measuredWidth, this.f4897o);
                }
                if (progress > iMax) {
                    m3625c(canvas, iMax, progress, this.f4883a.f13089b, measuredWidth, this.f4895m);
                }
                int i14 = this.f4883a.f13089b;
                if (i14 > progress) {
                    m3625c(canvas, progress, i14, i14, measuredWidth, this.f4897o);
                }
            }
            canvas.restoreToCount(iSave2);
            ArrayList<C3893a> arrayList = this.f4887e;
            Paint paint = this.f4894l;
            if (arrayList != null && !arrayList.isEmpty()) {
                paint.setColor(this.f4898p);
                int measuredWidth2 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                int measuredHeight2 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
                int iSave3 = canvas.save();
                canvas.translate(0.0f, measuredHeight2 / 2);
                for (C3893a c3893a : arrayList) {
                    if (c3893a != null) {
                        int iMin = Math.min(c3893a.f13085a, this.f4883a.f13089b);
                        int i15 = (c3893a.f13087c ? c3893a.f13086b : 1) + iMin;
                        float f = measuredWidth2;
                        float f3 = this.f4883a.f13089b;
                        float f4 = (i15 * f) / f3;
                        float f5 = (iMin * f) / f3;
                        float f10 = f4 - f5;
                        float f11 = this.f4893k;
                        if (f10 < f11) {
                            f4 = f5 + f11;
                        }
                        if (f4 > f) {
                            f4 = f;
                        }
                        if (f4 - f5 < f11) {
                            f5 = f4 - f11;
                        }
                        float f12 = this.f4891i;
                        canvas.drawRect(f5, -f12, f4, f12, paint);
                    }
                }
                canvas.restoreToCount(iSave3);
            }
            if (isEnabled() && this.f4883a.f13093f) {
                paint.setColor(this.f4895m);
                int measuredWidth3 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                int measuredHeight3 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
                double progress2 = getProgress();
                double d = this.f4883a.f13089b;
                int iSave4 = canvas.save();
                canvas.drawCircle((int) ((progress2 / d) * ((double) measuredWidth3)), measuredHeight3 / 2.0f, this.f4892j, paint);
                canvas.restoreToCount(iSave4);
            }
        } else {
            int measuredWidth4 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight4 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int iSave5 = canvas.save();
            canvas.translate(0.0f, measuredHeight4 / 2);
            int i16 = this.f4898p;
            int i17 = c3151r.f10634a;
            int i18 = c3151r.f10635b;
            m3625c(canvas, 0, i17, i18, measuredWidth4, i16);
            m3625c(canvas, i17, i18, i18, measuredWidth4, this.f4897o);
            canvas.restoreToCount(iSave5);
        }
        canvas.restoreToCount(iSave);
    }

    @Override
    public final synchronized void onMeasure(int i6, int i10) {
        float paddingLeft = getPaddingLeft();
        setMeasuredDimension(View.resolveSizeAndState((int) (this.f4889g + paddingLeft + getPaddingRight()), i6, 0), View.resolveSizeAndState((int) (this.f4890h + getPaddingTop() + getPaddingBottom()), i10, 0));
    }

    @Override
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && this.f4883a.f13093f) {
            if (this.f4900r == null) {
                this.f4900r = new Point();
            }
            if (this.f4899q == null) {
                this.f4899q = new int[2];
            }
            getLocationOnScreen(this.f4899q);
            this.f4900r.set((((int) motionEvent.getRawX()) - this.f4899q[0]) - getPaddingLeft(), ((int) motionEvent.getRawY()) - this.f4899q[1]);
            int action = motionEvent.getAction();
            if (action == 0) {
                m3627e();
                m3626d(m3624b(this.f4900r.x));
                return true;
            }
            if (action == 1) {
                m3626d(m3624b(this.f4900r.x));
                this.f4884b = false;
                C3624n c3624n = this.f4888f;
                if (c3624n != null) {
                    c3624n.m7343k(this);
                }
                return true;
            }
            if (action == 2) {
                m3626d(m3624b(this.f4900r.x));
                return true;
            }
            if (action == 3) {
                this.f4884b = false;
                this.f4885c = null;
                C3624n c3624n2 = this.f4888f;
                if (c3624n2 != null) {
                    getProgress();
                    c3624n2.m7342j(true);
                    this.f4888f.m7343k(this);
                }
                postInvalidate();
                return true;
            }
        }
        return false;
    }

    public CastSeekBar(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f4887e = new ArrayList();
        setAccessibilityDelegate(new C1877o(1, this));
        Paint paint = new Paint(1);
        this.f4894l = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f4889g = context.getResources().getDimension(R.dimen.cast_seek_bar_minimum_width);
        this.f4890h = context.getResources().getDimension(R.dimen.cast_seek_bar_minimum_height);
        this.f4891i = context.getResources().getDimension(R.dimen.cast_seek_bar_progress_height) / 2.0f;
        this.f4892j = context.getResources().getDimension(R.dimen.cast_seek_bar_thumb_size) / 2.0f;
        this.f4893k = context.getResources().getDimension(R.dimen.cast_seek_bar_ad_break_minimum_width);
        C3894b c3894b = new C3894b();
        this.f4883a = c3894b;
        c3894b.f13089b = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, AbstractC3480f.f11774a, R.attr.castExpandedControllerStyle, R.style.CastExpandedController);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(18, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(20, 0);
        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(23, 0);
        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        this.f4895m = context.getResources().getColor(resourceId);
        this.f4896n = context.getResources().getColor(resourceId2);
        this.f4897o = context.getResources().getColor(resourceId3);
        this.f4898p = context.getResources().getColor(resourceId4);
        typedArrayObtainStyledAttributes.recycle();
    }
}

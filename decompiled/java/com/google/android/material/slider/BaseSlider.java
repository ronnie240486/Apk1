package com.google.android.material.slider;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import com.alibaba.fastjson.asm.Opcodes;
import com.bumptech.glide.AbstractC1465c;
import com.bumptech.glide.AbstractC1466d;
import com.google.android.material.internal.AbstractC1811a0;
import com.google.android.material.internal.AbstractC1818e;
import com.google.android.material.internal.C1838x;
import com.google.android.material.slider.BaseSlider;
import com.p2serv.android.p032ds.R;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import p000a.AbstractC0004e;
import p001a0.C0019b;
import p055ea.AbstractC2460q;
import p056f0.AbstractC2478a;
import p065g0.AbstractC2581a;
import p138n0.AbstractC3155s0;
import p143n5.AbstractC3198d;
import p156o9.AbstractC3280d;
import p189r6.C3639d;
import p221u6.C3901a;
import p221u6.C3905e;
import p221u6.C3908h;
import p221u6.C3912l;
import p221u6.C3913m;
import p222u7.AbstractC3928d;
import p250x5.AbstractC4121a;
import p262y5.AbstractC4268a;
import p263y6.AbstractC4275a;
import p273z6.C4357a;

abstract class BaseSlider<S extends BaseSlider<S, L, T>, L, T> extends View {

    public static final int f6606d0 = 0;

    public final int f6607A;

    public float f6608B;

    public MotionEvent f6609C;

    public boolean f6610D;

    public float f6611E;

    public float f6612F;

    public ArrayList f6613G;

    public int f6614H;

    public int f6615I;

    public float f6616J;

    public float[] f6617K;

    public boolean f6618L;

    public int f6619M;

    public boolean f6620N;

    public boolean f6621O;

    public ColorStateList f6622P;

    public ColorStateList f6623Q;

    public ColorStateList f6624R;

    public ColorStateList f6625S;

    public ColorStateList f6626T;

    public final C3908h f6627U;

    public Drawable f6628V;

    public List f6629W;

    public final Paint f6630a;

    public final Paint f6631b;

    public float f6632b0;

    public final Paint f6633c;

    public int f6634c0;

    public final Paint f6635d;

    public final Paint f6636e;

    public final Paint f6637f;

    public final C1859e f6638g;

    public final AccessibilityManager f6639h;

    public RunnableC1858d f6640i;

    public final C1855a f6641j;

    public final ArrayList f6642k;

    public final ArrayList f6643l;

    public final ArrayList f6644m;

    public boolean f6645n;

    public ValueAnimator f6646o;

    public ValueAnimator f6647p;

    public final int f6648q;

    public final int f6649r;

    public final int f6650s;

    public final int f6651t;

    public int f6652u;

    public int f6653v;

    public int f6654w;

    public final int f6655x;

    public int f6656y;

    public int f6657z;

    public static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new C1860f();

        public float f6658a;

        public float f6659b;

        public ArrayList f6660c;

        public float f6661d;

        public boolean f6662e;

        @Override
        public final void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeFloat(this.f6658a);
            parcel.writeFloat(this.f6659b);
            parcel.writeList(this.f6660c);
            parcel.writeFloat(this.f6661d);
            parcel.writeBooleanArray(new boolean[]{this.f6662e});
        }
    }

    public BaseSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sliderStyle);
    }

    public final void m4305a(Drawable drawable) {
        int i6 = this.f6656y * 2;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == -1 && intrinsicHeight == -1) {
            drawable.setBounds(0, 0, i6, i6);
        } else {
            float fMax = i6 / Math.max(intrinsicWidth, intrinsicHeight);
            drawable.setBounds(0, 0, (int) (intrinsicWidth * fMax), (int) (intrinsicHeight * fMax));
        }
    }

    public final int m4306b() {
        int i6 = this.f6655x;
        int i10 = this.f6652u;
        return i6 + ((i10 == 1 || i10 == 3) ? ((C4357a) this.f6642k.get(0)).getIntrinsicHeight() : 0);
    }

    public final ValueAnimator m4307c(boolean z7) {
        float fFloatValue = z7 ? 0.0f : 1.0f;
        ValueAnimator valueAnimator = z7 ? this.f6647p : this.f6646o;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, z7 ? 1.0f : 0.0f);
        valueAnimatorOfFloat.setDuration(z7 ? 83L : 117L);
        valueAnimatorOfFloat.setInterpolator(z7 ? AbstractC4268a.f14473e : AbstractC4268a.f14471c);
        valueAnimatorOfFloat.addUpdateListener(new C1856b(this));
        return valueAnimatorOfFloat;
    }

    public final void m4308d(Canvas canvas, int i6, int i10, float f, Drawable drawable) {
        canvas.save();
        canvas.translate((this.f6654w + ((int) (m4319o(f) * i6))) - (drawable.getBounds().width() / 2.0f), i10 - (drawable.getBounds().height() / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.f6638g.m7940m(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        this.f6630a.setColor(m4312h(this.f6626T));
        this.f6631b.setColor(m4312h(this.f6625S));
        this.f6636e.setColor(m4312h(this.f6624R));
        this.f6637f.setColor(m4312h(this.f6623Q));
        for (C4357a c4357a : this.f6642k) {
            if (c4357a.isStateful()) {
                c4357a.setState(getDrawableState());
            }
        }
        C3908h c3908h = this.f6627U;
        if (c3908h.isStateful()) {
            c3908h.setState(getDrawableState());
        }
        Paint paint = this.f6635d;
        paint.setColor(m4312h(this.f6622P));
        paint.setAlpha(63);
    }

    public final void m4309e() {
        if (this.f6645n) {
            this.f6645n = false;
            ValueAnimator valueAnimatorM4307c = m4307c(false);
            this.f6647p = valueAnimatorM4307c;
            this.f6646o = null;
            valueAnimatorM4307c.addListener(new C1857c(this));
            this.f6647p.start();
        }
    }

    public final String m4310f(float f) {
        return String.format(((float) ((int) f)) == f ? "%.0f" : "%.2f", Float.valueOf(f));
    }

    public final float[] m4311g() {
        float fFloatValue = ((Float) Collections.max(getValues())).floatValue();
        float fFloatValue2 = ((Float) Collections.min(getValues())).floatValue();
        if (this.f6613G.size() == 1) {
            fFloatValue2 = this.f6611E;
        }
        float fM4319o = m4319o(fFloatValue2);
        float fM4319o2 = m4319o(fFloatValue);
        return m4315k() ? new float[]{fM4319o2, fM4319o} : new float[]{fM4319o, fM4319o2};
    }

    @Override
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.f6638g.f13470k;
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    public float getValueFrom() {
        return this.f6611E;
    }

    public float getValueTo() {
        return this.f6612F;
    }

    public List<Float> getValues() {
        return new ArrayList(this.f6613G);
    }

    public final int m4312h(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    public final boolean m4313i() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    public final boolean m4314j(float f) {
        double dDoubleValue = new BigDecimal(Float.toString(f)).divide(new BigDecimal(Float.toString(this.f6616J)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(dDoubleValue)) - dDoubleValue) < 1.0E-4d;
    }

    public final boolean m4315k() {
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        return getLayoutDirection() == 1;
    }

    public final void m4316l() {
        if (this.f6616J <= 0.0f) {
            return;
        }
        m4328x();
        int iMin = Math.min((int) (((this.f6612F - this.f6611E) / this.f6616J) + 1.0f), (this.f6619M / (this.f6653v * 2)) + 1);
        float[] fArr = this.f6617K;
        if (fArr == null || fArr.length != iMin * 2) {
            this.f6617K = new float[iMin * 2];
        }
        float f = this.f6619M / (iMin - 1);
        for (int i6 = 0; i6 < iMin * 2; i6 += 2) {
            float[] fArr2 = this.f6617K;
            fArr2[i6] = ((i6 / 2) * f) + this.f6654w;
            fArr2[i6 + 1] = m4306b();
        }
    }

    public final boolean m4317m(int i6) {
        int i10 = this.f6615I;
        long j10 = ((long) i10) + ((long) i6);
        long size = this.f6613G.size() - 1;
        if (j10 < 0) {
            j10 = 0;
        } else if (j10 > size) {
            j10 = size;
        }
        int i11 = (int) j10;
        this.f6615I = i11;
        if (i11 == i10) {
            return false;
        }
        if (this.f6614H != -1) {
            this.f6614H = i11;
        }
        m4327w();
        postInvalidate();
        return true;
    }

    public final void m4318n(int i6) {
        if (m4315k()) {
            i6 = i6 == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i6;
        }
        m4317m(i6);
    }

    public final float m4319o(float f) {
        float f3 = this.f6611E;
        float f4 = (f - f3) / (this.f6612F - f3);
        return m4315k() ? 1.0f - f4 : f4;
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (C4357a c4357a : this.f6642k) {
            ViewGroup viewGroupM4246f = AbstractC1811a0.m4246f(this);
            if (viewGroupM4246f == null) {
                c4357a.getClass();
            } else {
                c4357a.getClass();
                int[] iArr = new int[2];
                viewGroupM4246f.getLocationOnScreen(iArr);
                c4357a.f14791I = iArr[0];
                viewGroupM4246f.getWindowVisibleDisplayFrame(c4357a.f14785C);
                viewGroupM4246f.addOnLayoutChangeListener(c4357a.f14784B);
            }
        }
    }

    @Override
    public final void onDetachedFromWindow() {
        RunnableC1858d runnableC1858d = this.f6640i;
        if (runnableC1858d != null) {
            removeCallbacks(runnableC1858d);
        }
        this.f6645n = false;
        for (C4357a c4357a : this.f6642k) {
            ViewGroup viewGroupM4246f = AbstractC1811a0.m4246f(this);
            C0019b c0019b = viewGroupM4246f == null ? null : new C0019b(viewGroupM4246f);
            if (c0019b != null) {
                ((ViewOverlay) c0019b.f38b).remove(c4357a);
                ViewGroup viewGroupM4246f2 = AbstractC1811a0.m4246f(this);
                if (viewGroupM4246f2 == null) {
                    c4357a.getClass();
                } else {
                    viewGroupM4246f2.removeOnLayoutChangeListener(c4357a.f14784B);
                }
            }
        }
        super.onDetachedFromWindow();
    }

    @Override
    public final void onDraw(Canvas canvas) {
        if (this.f6621O) {
            m4328x();
            m4316l();
        }
        super.onDraw(canvas);
        int iM4306b = m4306b();
        int i6 = this.f6619M;
        float[] fArrM4311g = m4311g();
        int i10 = this.f6654w;
        float f = i6;
        float f3 = i10 + (fArrM4311g[1] * f);
        float f4 = i10 + i6;
        Paint paint = this.f6630a;
        if (f3 < f4) {
            float f5 = iM4306b;
            canvas.drawLine(f3, f5, f4, f5, paint);
        }
        float f10 = this.f6654w;
        float f11 = (fArrM4311g[0] * f) + f10;
        if (f11 > f10) {
            float f12 = iM4306b;
            canvas.drawLine(f10, f12, f11, f12, paint);
        }
        if (((Float) Collections.max(getValues())).floatValue() > this.f6611E) {
            int i11 = this.f6619M;
            float[] fArrM4311g2 = m4311g();
            float f13 = this.f6654w;
            float f14 = i11;
            float f15 = iM4306b;
            canvas.drawLine((fArrM4311g2[0] * f14) + f13, f15, (fArrM4311g2[1] * f14) + f13, f15, this.f6631b);
        }
        if (this.f6618L && this.f6616J > 0.0f) {
            float[] fArrM4311g3 = m4311g();
            int iRound = Math.round(fArrM4311g3[0] * ((this.f6617K.length / 2) - 1));
            int iRound2 = Math.round(fArrM4311g3[1] * ((this.f6617K.length / 2) - 1));
            float[] fArr = this.f6617K;
            int i12 = iRound * 2;
            Paint paint2 = this.f6636e;
            canvas.drawPoints(fArr, 0, i12, paint2);
            int i13 = iRound2 * 2;
            canvas.drawPoints(this.f6617K, i12, i13 - i12, this.f6637f);
            float[] fArr2 = this.f6617K;
            canvas.drawPoints(fArr2, i13, fArr2.length - i13, paint2);
        }
        if ((this.f6610D || isFocused() || this.f6652u == 3) && isEnabled()) {
            int i14 = this.f6619M;
            if (!(getBackground() instanceof RippleDrawable)) {
                int iM4319o = (int) ((m4319o(((Float) this.f6613G.get(this.f6615I)).floatValue()) * i14) + this.f6654w);
                if (Build.VERSION.SDK_INT < 28) {
                    int i15 = this.f6657z;
                    canvas.clipRect(iM4319o - i15, iM4306b - i15, iM4319o + i15, i15 + iM4306b, Region.Op.UNION);
                }
                canvas.drawCircle(iM4319o, iM4306b, this.f6657z, this.f6635d);
            }
            if (this.f6614H == -1 && this.f6652u != 3) {
                m4309e();
            } else if (this.f6652u != 2) {
                if (!this.f6645n) {
                    this.f6645n = true;
                    ValueAnimator valueAnimatorM4307c = m4307c(true);
                    this.f6646o = valueAnimatorM4307c;
                    this.f6647p = null;
                    valueAnimatorM4307c.start();
                }
                ArrayList arrayList = this.f6642k;
                Iterator it = arrayList.iterator();
                for (int i16 = 0; i16 < this.f6613G.size() && it.hasNext(); i16++) {
                    if (i16 != this.f6615I) {
                        m4322r((C4357a) it.next(), ((Float) this.f6613G.get(i16)).floatValue());
                    }
                }
                if (!it.hasNext()) {
                    throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(arrayList.size()), Integer.valueOf(this.f6613G.size())));
                }
                m4322r((C4357a) it.next(), ((Float) this.f6613G.get(this.f6615I)).floatValue());
            }
        } else {
            m4309e();
        }
        int i17 = this.f6619M;
        for (int i18 = 0; i18 < this.f6613G.size(); i18++) {
            float fFloatValue = ((Float) this.f6613G.get(i18)).floatValue();
            Drawable drawable = this.f6628V;
            if (drawable != null) {
                m4308d(canvas, i17, iM4306b, fFloatValue, drawable);
            } else if (i18 < this.f6629W.size()) {
                m4308d(canvas, i17, iM4306b, fFloatValue, (Drawable) this.f6629W.get(i18));
            } else {
                if (!isEnabled()) {
                    canvas.drawCircle((m4319o(fFloatValue) * i17) + this.f6654w, iM4306b, this.f6656y, this.f6633c);
                }
                m4308d(canvas, i17, iM4306b, fFloatValue, this.f6627U);
            }
        }
    }

    @Override
    public final void onFocusChanged(boolean z7, int i6, Rect rect) {
        super.onFocusChanged(z7, i6, rect);
        C1859e c1859e = this.f6638g;
        if (!z7) {
            this.f6614H = -1;
            c1859e.m7937j(this.f6615I);
            return;
        }
        if (i6 == 1) {
            m4317m(Integer.MAX_VALUE);
        } else if (i6 == 2) {
            m4317m(Integer.MIN_VALUE);
        } else if (i6 == 17) {
            m4318n(Integer.MAX_VALUE);
        } else if (i6 == 66) {
            m4318n(Integer.MIN_VALUE);
        }
        c1859e.m7944w(this.f6615I);
    }

    @Override
    public boolean onKeyDown(int i6, KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i6, keyEvent);
        }
        if (this.f6613G.size() == 1) {
            this.f6614H = 0;
        }
        Float fValueOf = null;
        Boolean boolValueOf = null;
        if (this.f6614H == -1) {
            if (i6 != 61) {
                if (i6 == 66) {
                    this.f6614H = this.f6615I;
                    postInvalidate();
                    boolValueOf = Boolean.TRUE;
                } else if (i6 == 81) {
                    m4317m(1);
                    boolValueOf = Boolean.TRUE;
                } else if (i6 == 69) {
                    m4317m(-1);
                    boolValueOf = Boolean.TRUE;
                } else if (i6 != 70) {
                    switch (i6) {
                        case 21:
                            m4318n(-1);
                            boolValueOf = Boolean.TRUE;
                            break;
                        case 22:
                            m4318n(1);
                            boolValueOf = Boolean.TRUE;
                            break;
                        case 23:
                            this.f6614H = this.f6615I;
                            postInvalidate();
                            boolValueOf = Boolean.TRUE;
                            break;
                    }
                } else {
                    m4317m(1);
                    boolValueOf = Boolean.TRUE;
                }
            } else if (keyEvent.hasNoModifiers()) {
                boolValueOf = Boolean.valueOf(m4317m(1));
            } else {
                boolValueOf = keyEvent.isShiftPressed() ? Boolean.valueOf(m4317m(-1)) : Boolean.FALSE;
            }
            return boolValueOf != null ? boolValueOf.booleanValue() : super.onKeyDown(i6, keyEvent);
        }
        boolean zIsLongPress = this.f6620N | keyEvent.isLongPress();
        this.f6620N = zIsLongPress;
        float fRound = 1.0f;
        if (zIsLongPress) {
            float f = this.f6616J;
            fRound = f != 0.0f ? f : 1.0f;
            float f3 = (this.f6612F - this.f6611E) / fRound;
            float f4 = 20;
            if (f3 > f4) {
                fRound *= Math.round(f3 / f4);
            }
        } else {
            float f5 = this.f6616J;
            if (f5 != 0.0f) {
                fRound = f5;
            }
        }
        if (i6 == 21) {
            if (!m4315k()) {
                fRound = -fRound;
            }
            fValueOf = Float.valueOf(fRound);
        } else if (i6 == 22) {
            if (m4315k()) {
                fRound = -fRound;
            }
            fValueOf = Float.valueOf(fRound);
        } else if (i6 == 69) {
            fValueOf = Float.valueOf(-fRound);
        } else if (i6 == 70 || i6 == 81) {
            fValueOf = Float.valueOf(fRound);
        }
        if (fValueOf != null) {
            if (m4324t(this.f6614H, fValueOf.floatValue() + ((Float) this.f6613G.get(this.f6614H)).floatValue())) {
                m4327w();
                postInvalidate();
            }
            return true;
        }
        if (i6 != 23) {
            if (i6 == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return m4317m(1);
                }
                if (keyEvent.isShiftPressed()) {
                    return m4317m(-1);
                }
                return false;
            }
            if (i6 != 66) {
                return super.onKeyDown(i6, keyEvent);
            }
        }
        this.f6614H = -1;
        postInvalidate();
        return true;
    }

    @Override
    public boolean onKeyUp(int i6, KeyEvent keyEvent) {
        this.f6620N = false;
        return super.onKeyUp(i6, keyEvent);
    }

    @Override
    public final void onMeasure(int i6, int i10) {
        int i11 = this.f6651t;
        int i12 = this.f6652u;
        super.onMeasure(i6, View.MeasureSpec.makeMeasureSpec(i11 + ((i12 == 1 || i12 == 3) ? ((C4357a) this.f6642k.get(0)).getIntrinsicHeight() : 0), 1073741824));
    }

    @Override
    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.f6611E = sliderState.f6658a;
        this.f6612F = sliderState.f6659b;
        m4323s(sliderState.f6660c);
        this.f6616J = sliderState.f6661d;
        if (sliderState.f6662e) {
            requestFocus();
        }
    }

    @Override
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.f6658a = this.f6611E;
        sliderState.f6659b = this.f6612F;
        sliderState.f6660c = new ArrayList(this.f6613G);
        sliderState.f6661d = this.f6616J;
        sliderState.f6662e = hasFocus();
        return sliderState;
    }

    @Override
    public final void onSizeChanged(int i6, int i10, int i11, int i12) {
        this.f6619M = Math.max(i6 - (this.f6654w * 2), 0);
        m4316l();
        m4327w();
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float x10 = motionEvent.getX();
        float f = (x10 - this.f6654w) / this.f6619M;
        this.f6632b0 = f;
        float fMax = Math.max(0.0f, f);
        this.f6632b0 = fMax;
        this.f6632b0 = Math.min(1.0f, fMax);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            int i6 = this.f6648q;
            if (actionMasked == 1) {
                this.f6610D = false;
                MotionEvent motionEvent2 = this.f6609C;
                if (motionEvent2 != null && motionEvent2.getActionMasked() == 0) {
                    float f3 = i6;
                    if (Math.abs(this.f6609C.getX() - motionEvent.getX()) <= f3 && Math.abs(this.f6609C.getY() - motionEvent.getY()) <= f3 && mo4321q()) {
                        m4320p();
                    }
                }
                if (this.f6614H != -1) {
                    m4325u();
                    this.f6614H = -1;
                    Iterator it = this.f6644m.iterator();
                    if (it.hasNext()) {
                        throw AbstractC0004e.m18l(it);
                    }
                }
                invalidate();
            } else if (actionMasked == 2) {
                if (!this.f6610D) {
                    if (m4313i() && Math.abs(x10 - this.f6608B) < i6) {
                        return false;
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                    m4320p();
                }
                if (mo4321q()) {
                    this.f6610D = true;
                    m4325u();
                    m4327w();
                    invalidate();
                }
            }
        } else {
            this.f6608B = x10;
            if (!m4313i()) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (mo4321q()) {
                    requestFocus();
                    this.f6610D = true;
                    m4325u();
                    m4327w();
                    invalidate();
                    m4320p();
                }
            }
        }
        setPressed(this.f6610D);
        this.f6609C = MotionEvent.obtain(motionEvent);
        return true;
    }

    public final void m4320p() {
        Iterator it = this.f6644m.iterator();
        if (it.hasNext()) {
            throw AbstractC0004e.m18l(it);
        }
    }

    public boolean mo4321q() {
        if (this.f6614H != -1) {
            return true;
        }
        float f = this.f6632b0;
        if (m4315k()) {
            f = 1.0f - f;
        }
        float f3 = this.f6612F;
        float f4 = this.f6611E;
        float fM5490d = AbstractC2460q.m5490d(f3, f4, f, f4);
        float fM4319o = (m4319o(fM5490d) * this.f6619M) + this.f6654w;
        this.f6614H = 0;
        float fAbs = Math.abs(((Float) this.f6613G.get(0)).floatValue() - fM5490d);
        for (int i6 = 1; i6 < this.f6613G.size(); i6++) {
            float fAbs2 = Math.abs(((Float) this.f6613G.get(i6)).floatValue() - fM5490d);
            float fM4319o2 = (m4319o(((Float) this.f6613G.get(i6)).floatValue()) * this.f6619M) + this.f6654w;
            if (Float.compare(fAbs2, fAbs) > 1) {
                break;
            }
            boolean z7 = !m4315k() ? fM4319o2 - fM4319o >= 0.0f : fM4319o2 - fM4319o <= 0.0f;
            if (Float.compare(fAbs2, fAbs) < 0) {
                this.f6614H = i6;
            } else {
                if (Float.compare(fAbs2, fAbs) != 0) {
                    continue;
                } else {
                    if (Math.abs(fM4319o2 - fM4319o) < this.f6648q) {
                        this.f6614H = -1;
                        return false;
                    }
                    if (z7) {
                        this.f6614H = i6;
                    }
                }
            }
            fAbs = fAbs2;
        }
        return this.f6614H != -1;
    }

    public final void m4322r(C4357a c4357a, float f) {
        String strM4310f = m4310f(f);
        if (!TextUtils.equals(c4357a.f14796x, strM4310f)) {
            c4357a.f14796x = strM4310f;
            c4357a.f14783A.f6497d = true;
            c4357a.invalidateSelf();
        }
        int iM4319o = (this.f6654w + ((int) (m4319o(f) * this.f6619M))) - (c4357a.getIntrinsicWidth() / 2);
        int iM4306b = m4306b() - (this.f6607A + this.f6656y);
        c4357a.setBounds(iM4319o, iM4306b - c4357a.getIntrinsicHeight(), c4357a.getIntrinsicWidth() + iM4319o, iM4306b);
        Rect rect = new Rect(c4357a.getBounds());
        AbstractC1818e.m4276c(AbstractC1811a0.m4246f(this), this, rect);
        c4357a.setBounds(rect);
        ViewGroup viewGroupM4246f = AbstractC1811a0.m4246f(this);
        ((ViewOverlay) (viewGroupM4246f == null ? null : new C0019b(viewGroupM4246f)).f38b).add(c4357a);
    }

    public final void m4323s(ArrayList arrayList) {
        ViewGroup viewGroupM4246f;
        int resourceId;
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("At least one value must be set");
        }
        Collections.sort(arrayList);
        if (this.f6613G.size() == arrayList.size() && this.f6613G.equals(arrayList)) {
            return;
        }
        this.f6613G = arrayList;
        this.f6621O = true;
        this.f6615I = 0;
        m4327w();
        ArrayList<C4357a> arrayList2 = this.f6642k;
        if (arrayList2.size() > this.f6613G.size()) {
            List<C4357a> listSubList = arrayList2.subList(this.f6613G.size(), arrayList2.size());
            for (C4357a c4357a : listSubList) {
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                if (isAttachedToWindow()) {
                    ViewGroup viewGroupM4246f2 = AbstractC1811a0.m4246f(this);
                    C0019b c0019b = viewGroupM4246f2 == null ? null : new C0019b(viewGroupM4246f2);
                    if (c0019b != null) {
                        ((ViewOverlay) c0019b.f38b).remove(c4357a);
                        ViewGroup viewGroupM4246f3 = AbstractC1811a0.m4246f(this);
                        if (viewGroupM4246f3 == null) {
                            c4357a.getClass();
                        } else {
                            viewGroupM4246f3.removeOnLayoutChangeListener(c4357a.f14784B);
                        }
                    }
                }
            }
            listSubList.clear();
        }
        while (arrayList2.size() < this.f6613G.size()) {
            C1855a c1855a = this.f6641j;
            BaseSlider baseSlider = c1855a.f6669c;
            TypedArray typedArrayM4250j = AbstractC1811a0.m4250j(baseSlider.getContext(), c1855a.f6667a, AbstractC4121a.f13977U, c1855a.f6668b, R.style.Widget_MaterialComponents_Slider, new int[0]);
            Context context = baseSlider.getContext();
            int resourceId2 = typedArrayM4250j.getResourceId(8, R.style.Widget_MaterialComponents_Tooltip);
            C4357a c4357a2 = new C4357a(context, resourceId2);
            TypedArray typedArrayM4250j2 = AbstractC1811a0.m4250j(c4357a2.f14797y, null, AbstractC4121a.f13990d0, 0, resourceId2, new int[0]);
            Context context2 = c4357a2.f14797y;
            c4357a2.f14790H = context2.getResources().getDimensionPixelSize(R.dimen.mtrl_tooltip_arrowSize);
            C3912l c3912lM7826f = c4357a2.f13126a.f13107a.m7826f();
            c3912lM7826f.f13161k = c4357a2.m8400x();
            c4357a2.setShapeAppearanceModel(c3912lM7826f.m7819a());
            CharSequence text = typedArrayM4250j2.getText(6);
            boolean zEquals = TextUtils.equals(c4357a2.f14796x, text);
            C1838x c1838x = c4357a2.f14783A;
            if (!zEquals) {
                c4357a2.f14796x = text;
                c1838x.f6497d = true;
                c4357a2.invalidateSelf();
            }
            C3639d c3639d = (!typedArrayM4250j2.hasValue(0) || (resourceId = typedArrayM4250j2.getResourceId(0, 0)) == 0) ? null : new C3639d(context2, resourceId);
            if (c3639d != null && typedArrayM4250j2.hasValue(1)) {
                c3639d.f12222j = AbstractC1466d.m3493k(context2, typedArrayM4250j2, 1);
            }
            c1838x.m4286b(c3639d, context2);
            c4357a2.m7809n(ColorStateList.valueOf(typedArrayM4250j2.getColor(7, AbstractC2478a.m5511f(AbstractC2478a.m5513h(AbstractC1465c.m3478m(context2, R.attr.colorOnBackground, C4357a.class.getCanonicalName()), Opcodes.IFEQ), AbstractC2478a.m5513h(AbstractC1465c.m3478m(context2, android.R.attr.colorBackground, C4357a.class.getCanonicalName()), 229)))));
            c4357a2.m7814s(ColorStateList.valueOf(AbstractC1465c.m3478m(context2, R.attr.colorSurface, C4357a.class.getCanonicalName())));
            c4357a2.f14786D = typedArrayM4250j2.getDimensionPixelSize(2, 0);
            c4357a2.f14787E = typedArrayM4250j2.getDimensionPixelSize(4, 0);
            c4357a2.f14788F = typedArrayM4250j2.getDimensionPixelSize(5, 0);
            c4357a2.f14789G = typedArrayM4250j2.getDimensionPixelSize(3, 0);
            typedArrayM4250j2.recycle();
            typedArrayM4250j.recycle();
            arrayList2.add(c4357a2);
            WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
            if (isAttachedToWindow() && (viewGroupM4246f = AbstractC1811a0.m4246f(this)) != null) {
                int[] iArr = new int[2];
                viewGroupM4246f.getLocationOnScreen(iArr);
                c4357a2.f14791I = iArr[0];
                viewGroupM4246f.getWindowVisibleDisplayFrame(c4357a2.f14785C);
                viewGroupM4246f.addOnLayoutChangeListener(c4357a2.f14784B);
            }
        }
        int i6 = arrayList2.size() == 1 ? 0 : 1;
        for (C4357a c4357a3 : arrayList2) {
            c4357a3.f13126a.f13116j = i6;
            c4357a3.invalidateSelf();
        }
        Iterator it = this.f6643l.iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            Iterator it2 = this.f6613G.iterator();
            if (it2.hasNext()) {
                ((Float) it2.next()).getClass();
                throw null;
            }
        }
        postInvalidate();
    }

    public void setActiveThumbIndex(int i6) {
        this.f6614H = i6;
    }

    public void setCustomThumbDrawable(Drawable drawable) {
        Drawable drawableNewDrawable = drawable.mutate().getConstantState().newDrawable();
        m4305a(drawableNewDrawable);
        this.f6628V = drawableNewDrawable;
        this.f6629W.clear();
        postInvalidate();
    }

    public void setCustomThumbDrawablesForValues(int... iArr) {
        Drawable[] drawableArr = new Drawable[iArr.length];
        for (int i6 = 0; i6 < iArr.length; i6++) {
            drawableArr[i6] = getResources().getDrawable(iArr[i6]);
        }
        setCustomThumbDrawablesForValues(drawableArr);
    }

    @Override
    public void setEnabled(boolean z7) {
        super.setEnabled(z7);
        setLayerType(z7 ? 0 : 2, null);
    }

    public void setFocusedThumbIndex(int i6) {
        if (i6 < 0 || i6 >= this.f6613G.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.f6615I = i6;
        this.f6638g.m7944w(i6);
        postInvalidate();
    }

    public void setHaloRadius(int i6) {
        if (i6 == this.f6657z) {
            return;
        }
        this.f6657z = i6;
        Drawable background = getBackground();
        if (!(getBackground() instanceof RippleDrawable) || !(background instanceof RippleDrawable)) {
            postInvalidate();
            return;
        }
        RippleDrawable rippleDrawable = (RippleDrawable) background;
        int i10 = this.f6657z;
        if (Build.VERSION.SDK_INT >= 23) {
            rippleDrawable.setRadius(i10);
            return;
        }
        try {
            RippleDrawable.class.getDeclaredMethod("setMaxRadius", Integer.TYPE).invoke(rippleDrawable, Integer.valueOf(i10));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e5) {
            throw new IllegalStateException("Couldn't set RippleDrawable radius", e5);
        }
    }

    public void setHaloTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f6622P)) {
            return;
        }
        this.f6622P = colorStateList;
        Drawable background = getBackground();
        if ((getBackground() instanceof RippleDrawable) && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        int iM4312h = m4312h(colorStateList);
        Paint paint = this.f6635d;
        paint.setColor(iM4312h);
        paint.setAlpha(63);
        invalidate();
    }

    public void setLabelBehavior(int i6) {
        if (this.f6652u != i6) {
            this.f6652u = i6;
            requestLayout();
        }
    }

    public void setSeparationUnit(int i6) {
        this.f6634c0 = i6;
        this.f6621O = true;
        postInvalidate();
    }

    public void setStepSize(float f) {
        if (f >= 0.0f) {
            if (this.f6616J != f) {
                this.f6616J = f;
                this.f6621O = true;
                postInvalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("The stepSize(" + f + ") must be 0, or a factor of the valueFrom(" + this.f6611E + ")-valueTo(" + this.f6612F + ") range");
    }

    public void setThumbElevation(float f) {
        this.f6627U.m7808m(f);
    }

    public void setThumbRadius(int i6) {
        int i10 = 0;
        if (i6 == this.f6656y) {
            return;
        }
        this.f6656y = i6;
        this.f6654w = this.f6649r + Math.max(i6 - this.f6650s, 0);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        if (isLaidOut()) {
            this.f6619M = Math.max(getWidth() - (this.f6654w * 2), 0);
            m4316l();
        }
        C3905e c3905e = new C3905e(i10);
        C3905e c3905e2 = new C3905e(i10);
        C3905e c3905e3 = new C3905e(i10);
        C3905e c3905e4 = new C3905e(i10);
        float f = this.f6656y;
        AbstractC3198d abstractC3198dM6587e = AbstractC3280d.m6587e(0);
        C3912l.m7818b(abstractC3198dM6587e);
        C3912l.m7818b(abstractC3198dM6587e);
        C3912l.m7818b(abstractC3198dM6587e);
        C3912l.m7818b(abstractC3198dM6587e);
        C3901a c3901a = new C3901a(f);
        C3901a c3901a2 = new C3901a(f);
        C3901a c3901a3 = new C3901a(f);
        C3901a c3901a4 = new C3901a(f);
        C3913m c3913m = new C3913m();
        c3913m.f13164a = abstractC3198dM6587e;
        c3913m.f13165b = abstractC3198dM6587e;
        c3913m.f13166c = abstractC3198dM6587e;
        c3913m.f13167d = abstractC3198dM6587e;
        c3913m.f13168e = c3901a;
        c3913m.f13169f = c3901a2;
        c3913m.f13170g = c3901a3;
        c3913m.f13171h = c3901a4;
        c3913m.f13172i = c3905e;
        c3913m.f13173j = c3905e2;
        c3913m.f13174k = c3905e3;
        c3913m.f13175l = c3905e4;
        C3908h c3908h = this.f6627U;
        c3908h.setShapeAppearanceModel(c3913m);
        int i11 = this.f6656y * 2;
        c3908h.setBounds(0, 0, i11, i11);
        Drawable drawable = this.f6628V;
        if (drawable != null) {
            m4305a(drawable);
        }
        Iterator it = this.f6629W.iterator();
        while (it.hasNext()) {
            m4305a((Drawable) it.next());
        }
        postInvalidate();
    }

    public void setThumbStrokeColor(ColorStateList colorStateList) {
        this.f6627U.m7814s(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeWidth(float f) {
        C3908h c3908h = this.f6627U;
        c3908h.f13126a.f13116j = f;
        c3908h.invalidateSelf();
        postInvalidate();
    }

    public void setTickActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f6623Q)) {
            return;
        }
        this.f6623Q = colorStateList;
        this.f6637f.setColor(m4312h(colorStateList));
        invalidate();
    }

    public void setTickInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f6624R)) {
            return;
        }
        this.f6624R = colorStateList;
        this.f6636e.setColor(m4312h(colorStateList));
        invalidate();
    }

    public void setTrackActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f6625S)) {
            return;
        }
        this.f6625S = colorStateList;
        this.f6631b.setColor(m4312h(colorStateList));
        invalidate();
    }

    public void setTrackHeight(int i6) {
        if (this.f6653v != i6) {
            this.f6653v = i6;
            this.f6630a.setStrokeWidth(i6);
            this.f6631b.setStrokeWidth(this.f6653v);
            this.f6636e.setStrokeWidth(this.f6653v / 2.0f);
            this.f6637f.setStrokeWidth(this.f6653v / 2.0f);
            postInvalidate();
        }
    }

    public void setTrackInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f6626T)) {
            return;
        }
        this.f6626T = colorStateList;
        this.f6630a.setColor(m4312h(colorStateList));
        invalidate();
    }

    public void setValues(Float... fArr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, fArr);
        m4323s(arrayList);
    }

    public final boolean m4324t(int i6, float f) {
        this.f6615I = i6;
        if (Math.abs(f - ((Float) this.f6613G.get(i6)).floatValue()) < 1.0E-4d) {
            return false;
        }
        float minSeparation = getMinSeparation();
        if (this.f6634c0 == 0) {
            if (minSeparation == 0.0f) {
                minSeparation = 0.0f;
            } else {
                float f3 = (minSeparation - this.f6654w) / this.f6619M;
                float f4 = this.f6611E;
                minSeparation = AbstractC2460q.m5490d(f4, this.f6612F, f3, f4);
            }
        }
        if (m4315k()) {
            minSeparation = -minSeparation;
        }
        int i10 = i6 + 1;
        float fFloatValue = i10 >= this.f6613G.size() ? this.f6612F : ((Float) this.f6613G.get(i10)).floatValue() - minSeparation;
        int i11 = i6 - 1;
        float fFloatValue2 = i11 < 0 ? this.f6611E : minSeparation + ((Float) this.f6613G.get(i11)).floatValue();
        if (f < fFloatValue2) {
            f = fFloatValue2;
        } else if (f > fFloatValue) {
            f = fFloatValue;
        }
        this.f6613G.set(i6, Float.valueOf(f));
        Iterator it = this.f6643l.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            ((Float) this.f6613G.get(i6)).getClass();
            throw null;
        }
        AccessibilityManager accessibilityManager = this.f6639h;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return true;
        }
        RunnableC1858d runnableC1858d = this.f6640i;
        if (runnableC1858d == null) {
            this.f6640i = new RunnableC1858d(this);
        } else {
            removeCallbacks(runnableC1858d);
        }
        RunnableC1858d runnableC1858d2 = this.f6640i;
        runnableC1858d2.f6672a = i6;
        postDelayed(runnableC1858d2, 200L);
        return true;
    }

    public final void m4325u() {
        double dRound;
        float f = this.f6632b0;
        float f3 = this.f6616J;
        if (f3 > 0.0f) {
            int i6 = (int) ((this.f6612F - this.f6611E) / f3);
            dRound = ((double) Math.round(f * i6)) / ((double) i6);
        } else {
            dRound = f;
        }
        if (m4315k()) {
            dRound = 1.0d - dRound;
        }
        float f4 = this.f6612F;
        float f5 = this.f6611E;
        m4324t(this.f6614H, (float) ((dRound * ((double) (f4 - f5))) + ((double) f5)));
    }

    public final void m4326v(int i6, Rect rect) {
        int iM4319o = this.f6654w + ((int) (m4319o(getValues().get(i6).floatValue()) * this.f6619M));
        int iM4306b = m4306b();
        int i10 = this.f6656y;
        rect.set(iM4319o - i10, iM4306b - i10, iM4319o + i10, iM4306b + i10);
    }

    public final void m4327w() {
        if (!(getBackground() instanceof RippleDrawable) || getMeasuredWidth() <= 0) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof RippleDrawable) {
            int iM4319o = (int) ((m4319o(((Float) this.f6613G.get(this.f6615I)).floatValue()) * this.f6619M) + this.f6654w);
            int iM4306b = m4306b();
            int i6 = this.f6657z;
            AbstractC2581a.m5584f(background, iM4319o - i6, iM4306b - i6, iM4319o + i6, iM4306b + i6);
        }
    }

    public final void m4328x() {
        if (this.f6621O) {
            float f = this.f6611E;
            float f3 = this.f6612F;
            if (f >= f3) {
                throw new IllegalStateException("valueFrom(" + this.f6611E + ") must be smaller than valueTo(" + this.f6612F + ")");
            }
            if (f3 <= f) {
                throw new IllegalStateException("valueTo(" + this.f6612F + ") must be greater than valueFrom(" + this.f6611E + ")");
            }
            if (this.f6616J > 0.0f && !m4314j(f3 - f)) {
                throw new IllegalStateException("The stepSize(" + this.f6616J + ") must be 0, or a factor of the valueFrom(" + this.f6611E + ")-valueTo(" + this.f6612F + ") range");
            }
            for (Float f4 : this.f6613G) {
                if (f4.floatValue() < this.f6611E || f4.floatValue() > this.f6612F) {
                    throw new IllegalStateException("Slider value(" + f4 + ") must be greater or equal to valueFrom(" + this.f6611E + "), and lower or equal to valueTo(" + this.f6612F + ")");
                }
                if (this.f6616J > 0.0f && !m4314j(f4.floatValue() - this.f6611E)) {
                    float f5 = this.f6611E;
                    float f10 = this.f6616J;
                    throw new IllegalStateException("Value(" + f4 + ") must be equal to valueFrom(" + f5 + ") plus a multiple of stepSize(" + f10 + ") when using stepSize(" + f10 + ")");
                }
            }
            float minSeparation = getMinSeparation();
            if (minSeparation < 0.0f) {
                throw new IllegalStateException("minSeparation(" + minSeparation + ") must be greater or equal to 0");
            }
            float f11 = this.f6616J;
            if (f11 > 0.0f && minSeparation > 0.0f) {
                if (this.f6634c0 != 1) {
                    throw new IllegalStateException("minSeparation(" + minSeparation + ") cannot be set as a dimension when using stepSize(" + this.f6616J + ")");
                }
                if (minSeparation < f11 || !m4314j(minSeparation)) {
                    float f12 = this.f6616J;
                    throw new IllegalStateException("minSeparation(" + minSeparation + ") must be greater or equal and a multiple of stepSize(" + f12 + ") when using stepSize(" + f12 + ")");
                }
            }
            float f13 = this.f6616J;
            if (f13 != 0.0f) {
                if (((int) f13) != f13) {
                    Log.w("BaseSlider", "Floating point value used for stepSize(" + f13 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
                }
                float f14 = this.f6611E;
                if (((int) f14) != f14) {
                    Log.w("BaseSlider", "Floating point value used for valueFrom(" + f14 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
                }
                float f15 = this.f6612F;
                if (((int) f15) != f15) {
                    Log.w("BaseSlider", "Floating point value used for valueTo(" + f15 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
                }
            }
            this.f6621O = false;
        }
    }

    public BaseSlider(Context context, AttributeSet attributeSet, int i6) {
        super(AbstractC4275a.m8323a(context, attributeSet, i6, R.style.Widget_MaterialComponents_Slider), attributeSet, i6);
        this.f6642k = new ArrayList();
        this.f6643l = new ArrayList();
        this.f6644m = new ArrayList();
        this.f6645n = false;
        this.f6610D = false;
        this.f6613G = new ArrayList();
        this.f6614H = -1;
        this.f6615I = -1;
        this.f6616J = 0.0f;
        this.f6618L = true;
        this.f6620N = false;
        C3908h c3908h = new C3908h();
        this.f6627U = c3908h;
        this.f6629W = Collections.emptyList();
        this.f6634c0 = 0;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.f6630a = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        Paint paint2 = new Paint();
        this.f6631b = paint2;
        paint2.setStyle(style);
        paint2.setStrokeCap(cap);
        Paint paint3 = new Paint(1);
        this.f6633c = paint3;
        Paint.Style style2 = Paint.Style.FILL;
        paint3.setStyle(style2);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint4 = new Paint(1);
        this.f6635d = paint4;
        paint4.setStyle(style2);
        Paint paint5 = new Paint();
        this.f6636e = paint5;
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        Paint paint6 = new Paint();
        this.f6637f = paint6;
        paint6.setStyle(style);
        paint6.setStrokeCap(cap);
        Resources resources = context2.getResources();
        this.f6651t = resources.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
        this.f6649r = dimensionPixelOffset;
        this.f6654w = dimensionPixelOffset;
        this.f6650s = resources.getDimensionPixelSize(R.dimen.mtrl_slider_thumb_radius);
        this.f6655x = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_top);
        this.f6607A = resources.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
        this.f6641j = new C1855a(this, attributeSet, i6);
        int[] iArr = AbstractC4121a.f13977U;
        AbstractC1811a0.m4241a(context2, attributeSet, i6, R.style.Widget_MaterialComponents_Slider);
        AbstractC1811a0.m4242b(context2, attributeSet, iArr, i6, R.style.Widget_MaterialComponents_Slider, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i6, R.style.Widget_MaterialComponents_Slider);
        this.f6611E = typedArrayObtainStyledAttributes.getFloat(3, 0.0f);
        this.f6612F = typedArrayObtainStyledAttributes.getFloat(4, 1.0f);
        setValues(Float.valueOf(this.f6611E));
        this.f6616J = typedArrayObtainStyledAttributes.getFloat(2, 0.0f);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(18);
        int i10 = zHasValue ? 18 : 20;
        int i11 = zHasValue ? 18 : 19;
        ColorStateList colorStateListM3493k = AbstractC1466d.m3493k(context2, typedArrayObtainStyledAttributes, i10);
        setTrackInactiveTintList(colorStateListM3493k == null ? AbstractC3928d.m7848k(context2, R.color.material_slider_inactive_track_color) : colorStateListM3493k);
        ColorStateList colorStateListM3493k2 = AbstractC1466d.m3493k(context2, typedArrayObtainStyledAttributes, i11);
        setTrackActiveTintList(colorStateListM3493k2 == null ? AbstractC3928d.m7848k(context2, R.color.material_slider_active_track_color) : colorStateListM3493k2);
        c3908h.m7809n(AbstractC1466d.m3493k(context2, typedArrayObtainStyledAttributes, 9));
        if (typedArrayObtainStyledAttributes.hasValue(12)) {
            setThumbStrokeColor(AbstractC1466d.m3493k(context2, typedArrayObtainStyledAttributes, 12));
        }
        setThumbStrokeWidth(typedArrayObtainStyledAttributes.getDimension(13, 0.0f));
        ColorStateList colorStateListM3493k3 = AbstractC1466d.m3493k(context2, typedArrayObtainStyledAttributes, 5);
        setHaloTintList(colorStateListM3493k3 == null ? AbstractC3928d.m7848k(context2, R.color.material_slider_halo_color) : colorStateListM3493k3);
        this.f6618L = typedArrayObtainStyledAttributes.getBoolean(17, true);
        boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(14);
        int i12 = zHasValue2 ? 14 : 16;
        int i13 = zHasValue2 ? 14 : 15;
        ColorStateList colorStateListM3493k4 = AbstractC1466d.m3493k(context2, typedArrayObtainStyledAttributes, i12);
        setTickInactiveTintList(colorStateListM3493k4 == null ? AbstractC3928d.m7848k(context2, R.color.material_slider_inactive_tick_marks_color) : colorStateListM3493k4);
        ColorStateList colorStateListM3493k5 = AbstractC1466d.m3493k(context2, typedArrayObtainStyledAttributes, i13);
        setTickActiveTintList(colorStateListM3493k5 == null ? AbstractC3928d.m7848k(context2, R.color.material_slider_active_tick_marks_color) : colorStateListM3493k5);
        setThumbRadius(typedArrayObtainStyledAttributes.getDimensionPixelSize(11, 0));
        setHaloRadius(typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0));
        setThumbElevation(typedArrayObtainStyledAttributes.getDimension(10, 0.0f));
        setTrackHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(21, 0));
        setLabelBehavior(typedArrayObtainStyledAttributes.getInt(7, 0));
        if (!typedArrayObtainStyledAttributes.getBoolean(0, true)) {
            setEnabled(false);
        }
        typedArrayObtainStyledAttributes.recycle();
        setFocusable(true);
        setClickable(true);
        c3908h.m7813r();
        this.f6648q = ViewConfiguration.get(context2).getScaledTouchSlop();
        C1859e c1859e = new C1859e(this);
        this.f6638g = c1859e;
        AbstractC3155s0.m6347q(this, c1859e);
        this.f6639h = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    public void setValues(List<Float> list) {
        m4323s(new ArrayList(list));
    }

    public void setCustomThumbDrawablesForValues(Drawable... drawableArr) {
        this.f6628V = null;
        this.f6629W = new ArrayList();
        for (Drawable drawable : drawableArr) {
            List list = this.f6629W;
            Drawable drawableNewDrawable = drawable.mutate().getConstantState().newDrawable();
            m4305a(drawableNewDrawable);
            list.add(drawableNewDrawable);
        }
        postInvalidate();
    }
}

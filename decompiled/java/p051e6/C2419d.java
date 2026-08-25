package p051e6;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.AbstractC1811a0;
import com.google.android.material.internal.C1838x;
import com.google.android.material.internal.InterfaceC1837w;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import p056f0.AbstractC2478a;
import p065g0.AbstractC2581a;
import p065g0.C2590j;
import p065g0.InterfaceC2589i;
import p143n5.AbstractC3198d;
import p189r6.C3639d;
import p201s6.AbstractC3722c;
import p221u6.C3907g;
import p221u6.C3908h;
import p221u6.C3912l;
import p262y5.C4272e;

public final class C2419d extends C3908h implements Drawable.Callback, InterfaceC1837w {

    public static final int[] f8426G0 = {R.attr.state_enabled};

    public static final ShapeDrawable f8427H0 = new ShapeDrawable(new OvalShape());

    public float f8428A;

    public ColorStateList f8429A0;

    public ColorStateList f8430B;

    public WeakReference f8431B0;

    public float f8432C;

    public TextUtils.TruncateAt f8433C0;

    public ColorStateList f8434D;

    public boolean f8435D0;

    public CharSequence f8436E;

    public int f8437E0;

    public boolean f8438F;

    public boolean f8439F0;

    public Drawable f8440G;

    public ColorStateList f8441H;

    public float f8442I;

    public boolean f8443J;

    public boolean f8444K;

    public Drawable f8445L;

    public RippleDrawable f8446M;

    public ColorStateList f8447N;

    public float f8448O;

    public SpannableStringBuilder f8449P;

    public boolean f8450Q;

    public boolean f8451R;

    public Drawable f8452S;

    public ColorStateList f8453T;

    public C4272e f8454U;

    public C4272e f8455V;

    public float f8456W;

    public float f8457X;

    public float f8458Y;

    public float f8459Z;

    public float f8460b0;

    public float f8461c0;

    public float f8462d0;

    public float f8463e0;

    public final Context f8464f0;

    public final Paint f8465g0;

    public final Paint.FontMetrics f8466h0;

    public final RectF f8467i0;

    public final PointF f8468j0;

    public final Path f8469k0;

    public final C1838x f8470l0;

    public int f8471m0;

    public int f8472n0;

    public int f8473o0;

    public int f8474p0;

    public int f8475q0;

    public int f8476r0;

    public boolean f8477s0;

    public int f8478t0;

    public int f8479u0;

    public ColorFilter f8480v0;

    public PorterDuffColorFilter f8481w0;

    public ColorStateList f8482x;

    public ColorStateList f8483x0;

    public ColorStateList f8484y;

    public PorterDuff.Mode f8485y0;

    public float f8486z;

    public int[] f8487z0;

    public C2419d(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6, com.p2serv.android.p032ds.R.style.Widget_MaterialComponents_Chip_Action);
        this.f8428A = -1.0f;
        this.f8465g0 = new Paint(1);
        this.f8466h0 = new Paint.FontMetrics();
        this.f8467i0 = new RectF();
        this.f8468j0 = new PointF();
        this.f8469k0 = new Path();
        this.f8479u0 = 255;
        this.f8485y0 = PorterDuff.Mode.SRC_IN;
        this.f8431B0 = new WeakReference(null);
        m7806k(context);
        this.f8464f0 = context;
        C1838x c1838x = new C1838x(this);
        this.f8470l0 = c1838x;
        this.f8436E = "";
        c1838x.f6494a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = f8426G0;
        setState(iArr);
        if (!Arrays.equals(this.f8487z0, iArr)) {
            this.f8487z0 = iArr;
            if (m5475b0()) {
                m5452E(getState(), iArr);
            }
        }
        this.f8435D0 = true;
        int[] iArr2 = AbstractC3722c.f12475a;
        f8427H0.setTint(-1);
    }

    public static boolean m5447B(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean m5448C(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public static void m5449c0(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public final float m5450A() {
        return this.f8439F0 ? m7804i() : this.f8428A;
    }

    public final void m5451D() {
        InterfaceC2418c interfaceC2418c = (InterfaceC2418c) this.f8431B0.get();
        if (interfaceC2418c != null) {
            Chip chip = (Chip) interfaceC2418c;
            chip.m4157c(chip.f6096q);
            chip.requestLayout();
            chip.invalidateOutline();
        }
    }

    public final boolean m5452E(int[] iArr, int[] iArr2) {
        boolean z7;
        boolean z10;
        ColorStateList colorStateList;
        boolean state = true;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList2 = this.f8482x;
        int iM7799c = m7799c(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.f8471m0) : 0);
        if (this.f8471m0 != iM7799c) {
            this.f8471m0 = iM7799c;
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.f8484y;
        int iM7799c2 = m7799c(colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.f8472n0) : 0);
        if (this.f8472n0 != iM7799c2) {
            this.f8472n0 = iM7799c2;
            zOnStateChange = true;
        }
        int iM5511f = AbstractC2478a.m5511f(iM7799c2, iM7799c);
        if ((this.f8473o0 != iM5511f) | (this.f13126a.f13109c == null)) {
            this.f8473o0 = iM5511f;
            m7809n(ColorStateList.valueOf(iM5511f));
            zOnStateChange = true;
        }
        ColorStateList colorStateList4 = this.f8430B;
        int colorForState = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.f8474p0) : 0;
        if (this.f8474p0 != colorForState) {
            this.f8474p0 = colorForState;
            zOnStateChange = true;
        }
        int colorForState2 = (this.f8429A0 == null || !AbstractC3722c.m7486c(iArr)) ? 0 : this.f8429A0.getColorForState(iArr, this.f8475q0);
        if (this.f8475q0 != colorForState2) {
            this.f8475q0 = colorForState2;
        }
        C3639d c3639d = this.f8470l0.f6499f;
        int colorForState3 = (c3639d == null || (colorStateList = c3639d.f12222j) == null) ? 0 : colorStateList.getColorForState(iArr, this.f8476r0);
        if (this.f8476r0 != colorForState3) {
            this.f8476r0 = colorForState3;
            zOnStateChange = true;
        }
        int[] state2 = getState();
        if (state2 != null) {
            int length = state2.length;
            int i6 = 0;
            while (true) {
                if (i6 < length) {
                    if (state2[i6] != 16842912) {
                        i6++;
                    } else if (this.f8450Q) {
                        z7 = true;
                        break;
                    }
                }
                z7 = false;
                break;
            }
        } else {
            z7 = false;
            break;
        }
        if (this.f8477s0 == z7 || this.f8452S == null) {
            z10 = false;
        } else {
            float fM5478y = m5478y();
            this.f8477s0 = z7;
            if (fM5478y != m5478y()) {
                zOnStateChange = true;
                z10 = true;
            } else {
                zOnStateChange = true;
                z10 = false;
            }
        }
        ColorStateList colorStateList5 = this.f8483x0;
        int colorForState4 = colorStateList5 != null ? colorStateList5.getColorForState(iArr, this.f8478t0) : 0;
        if (this.f8478t0 != colorForState4) {
            this.f8478t0 = colorForState4;
            ColorStateList colorStateList6 = this.f8483x0;
            PorterDuff.Mode mode = this.f8485y0;
            this.f8481w0 = (colorStateList6 == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList6.getColorForState(getState(), 0), mode);
        } else {
            state = zOnStateChange;
        }
        if (m5448C(this.f8440G)) {
            state |= this.f8440G.setState(iArr);
        }
        if (m5448C(this.f8452S)) {
            state |= this.f8452S.setState(iArr);
        }
        if (m5448C(this.f8445L)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            state |= this.f8445L.setState(iArr3);
        }
        int[] iArr4 = AbstractC3722c.f12475a;
        if (m5448C(this.f8446M)) {
            state |= this.f8446M.setState(iArr2);
        }
        if (state) {
            invalidateSelf();
        }
        if (z10) {
            m5451D();
        }
        return state;
    }

    public final void m5453F(boolean z7) {
        if (this.f8450Q != z7) {
            this.f8450Q = z7;
            float fM5478y = m5478y();
            if (!z7 && this.f8477s0) {
                this.f8477s0 = false;
            }
            float fM5478y2 = m5478y();
            invalidateSelf();
            if (fM5478y != fM5478y2) {
                m5451D();
            }
        }
    }

    public final void m5454G(Drawable drawable) {
        if (this.f8452S != drawable) {
            float fM5478y = m5478y();
            this.f8452S = drawable;
            float fM5478y2 = m5478y();
            m5449c0(this.f8452S);
            m5476w(this.f8452S);
            invalidateSelf();
            if (fM5478y != fM5478y2) {
                m5451D();
            }
        }
    }

    public final void m5455H(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.f8453T != colorStateList) {
            this.f8453T = colorStateList;
            if (this.f8451R && (drawable = this.f8452S) != null && this.f8450Q) {
                AbstractC2581a.m5586h(drawable, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void m5456I(boolean z7) {
        if (this.f8451R != z7) {
            boolean zM5473Z = m5473Z();
            this.f8451R = z7;
            boolean zM5473Z2 = m5473Z();
            if (zM5473Z != zM5473Z2) {
                if (zM5473Z2) {
                    m5476w(this.f8452S);
                } else {
                    m5449c0(this.f8452S);
                }
                invalidateSelf();
                m5451D();
            }
        }
    }

    public final void m5457J(float f) {
        if (this.f8428A != f) {
            this.f8428A = f;
            C3912l c3912lM7826f = this.f13126a.f13107a.m7826f();
            c3912lM7826f.m7820c(f);
            setShapeAppearanceModel(c3912lM7826f.m7819a());
        }
    }

    public final void m5458K(Drawable drawable) {
        ?? r10;
        Object obj = this.f8440G;
        if (obj == null) {
            r10 = 0;
        } else if (obj instanceof InterfaceC2589i) {
            r10 = obj;
            r10 = ((C2590j) ((InterfaceC2589i) obj)).f9035f;
        }
        if (r10 != drawable) {
            float fM5478y = m5478y();
            this.f8440G = drawable != null ? AbstractC3198d.m6448W(drawable).mutate() : null;
            float fM5478y2 = m5478y();
            m5449c0(r10);
            if (m5474a0()) {
                m5476w(this.f8440G);
            }
            invalidateSelf();
            if (fM5478y != fM5478y2) {
                m5451D();
            }
        }
    }

    public final void m5459L(float f) {
        if (this.f8442I != f) {
            float fM5478y = m5478y();
            this.f8442I = f;
            float fM5478y2 = m5478y();
            invalidateSelf();
            if (fM5478y != fM5478y2) {
                m5451D();
            }
        }
    }

    public final void m5460M(ColorStateList colorStateList) {
        this.f8443J = true;
        if (this.f8441H != colorStateList) {
            this.f8441H = colorStateList;
            if (m5474a0()) {
                AbstractC2581a.m5586h(this.f8440G, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void m5461N(boolean z7) {
        if (this.f8438F != z7) {
            boolean zM5474a0 = m5474a0();
            this.f8438F = z7;
            boolean zM5474a1 = m5474a0();
            if (zM5474a0 != zM5474a1) {
                if (zM5474a1) {
                    m5476w(this.f8440G);
                } else {
                    m5449c0(this.f8440G);
                }
                invalidateSelf();
                m5451D();
            }
        }
    }

    public final void m5462O(ColorStateList colorStateList) {
        if (this.f8430B != colorStateList) {
            this.f8430B = colorStateList;
            if (this.f8439F0) {
                m7814s(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void m5463P(float f) {
        if (this.f8432C != f) {
            this.f8432C = f;
            this.f8465g0.setStrokeWidth(f);
            if (this.f8439F0) {
                this.f13126a.f13116j = f;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    public final void m5464Q(Drawable drawable) {
        ?? r10;
        Object obj = this.f8445L;
        if (obj == null) {
            r10 = 0;
        } else if (obj instanceof InterfaceC2589i) {
            r10 = obj;
            r10 = ((C2590j) ((InterfaceC2589i) obj)).f9035f;
        }
        if (r10 != drawable) {
            float fM5479z = m5479z();
            this.f8445L = drawable != null ? AbstractC3198d.m6448W(drawable).mutate() : null;
            int[] iArr = AbstractC3722c.f12475a;
            this.f8446M = new RippleDrawable(AbstractC3722c.m7485b(this.f8434D), this.f8445L, f8427H0);
            float fM5479z2 = m5479z();
            m5449c0(r10);
            if (m5475b0()) {
                m5476w(this.f8445L);
            }
            invalidateSelf();
            if (fM5479z != fM5479z2) {
                m5451D();
            }
        }
    }

    public final void m5465R(float f) {
        if (this.f8462d0 != f) {
            this.f8462d0 = f;
            invalidateSelf();
            if (m5475b0()) {
                m5451D();
            }
        }
    }

    public final void m5466S(float f) {
        if (this.f8448O != f) {
            this.f8448O = f;
            invalidateSelf();
            if (m5475b0()) {
                m5451D();
            }
        }
    }

    public final void m5467T(float f) {
        if (this.f8461c0 != f) {
            this.f8461c0 = f;
            invalidateSelf();
            if (m5475b0()) {
                m5451D();
            }
        }
    }

    public final void m5468U(ColorStateList colorStateList) {
        if (this.f8447N != colorStateList) {
            this.f8447N = colorStateList;
            if (m5475b0()) {
                AbstractC2581a.m5586h(this.f8445L, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void m5469V(boolean z7) {
        if (this.f8444K != z7) {
            boolean zM5475b0 = m5475b0();
            this.f8444K = z7;
            boolean zM5475b1 = m5475b0();
            if (zM5475b0 != zM5475b1) {
                if (zM5475b1) {
                    m5476w(this.f8445L);
                } else {
                    m5449c0(this.f8445L);
                }
                invalidateSelf();
                m5451D();
            }
        }
    }

    public final void m5470W(float f) {
        if (this.f8458Y != f) {
            float fM5478y = m5478y();
            this.f8458Y = f;
            float fM5478y2 = m5478y();
            invalidateSelf();
            if (fM5478y != fM5478y2) {
                m5451D();
            }
        }
    }

    public final void m5471X(float f) {
        if (this.f8457X != f) {
            float fM5478y = m5478y();
            this.f8457X = f;
            float fM5478y2 = m5478y();
            invalidateSelf();
            if (fM5478y != fM5478y2) {
                m5451D();
            }
        }
    }

    public final void m5472Y(ColorStateList colorStateList) {
        if (this.f8434D != colorStateList) {
            this.f8434D = colorStateList;
            this.f8429A0 = null;
            onStateChange(getState());
        }
    }

    public final boolean m5473Z() {
        return this.f8451R && this.f8452S != null && this.f8477s0;
    }

    @Override
    public final void mo4284a() {
        m5451D();
        invalidateSelf();
    }

    public final boolean m5474a0() {
        return this.f8438F && this.f8440G != null;
    }

    public final boolean m5475b0() {
        return this.f8444K && this.f8445L != null;
    }

    @Override
    public final void draw(Canvas canvas) {
        int i6;
        int iSaveLayerAlpha;
        int i10;
        RectF rectF;
        int i11;
        int i12;
        int iSave;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i6 = this.f8479u0) == 0) {
            return;
        }
        if (i6 < 255) {
            float f = bounds.left;
            float f3 = bounds.top;
            float f4 = bounds.right;
            float f5 = bounds.bottom;
            iSaveLayerAlpha = Build.VERSION.SDK_INT > 21 ? canvas.saveLayerAlpha(f, f3, f4, f5, i6) : canvas.saveLayerAlpha(f, f3, f4, f5, i6, 31);
        } else {
            iSaveLayerAlpha = 0;
        }
        boolean z7 = this.f8439F0;
        Paint paint = this.f8465g0;
        RectF rectF2 = this.f8467i0;
        if (!z7) {
            paint.setColor(this.f8471m0);
            paint.setStyle(Paint.Style.FILL);
            rectF2.set(bounds);
            canvas.drawRoundRect(rectF2, m5450A(), m5450A(), paint);
        }
        if (!this.f8439F0) {
            paint.setColor(this.f8472n0);
            paint.setStyle(Paint.Style.FILL);
            ColorFilter colorFilter = this.f8480v0;
            if (colorFilter == null) {
                colorFilter = this.f8481w0;
            }
            paint.setColorFilter(colorFilter);
            rectF2.set(bounds);
            canvas.drawRoundRect(rectF2, m5450A(), m5450A(), paint);
        }
        if (this.f8439F0) {
            super.draw(canvas);
        }
        if (this.f8432C > 0.0f && !this.f8439F0) {
            paint.setColor(this.f8474p0);
            paint.setStyle(Paint.Style.STROKE);
            if (!this.f8439F0) {
                ColorFilter colorFilter2 = this.f8480v0;
                if (colorFilter2 == null) {
                    colorFilter2 = this.f8481w0;
                }
                paint.setColorFilter(colorFilter2);
            }
            float f10 = bounds.left;
            float f11 = this.f8432C / 2.0f;
            rectF2.set(f10 + f11, bounds.top + f11, bounds.right - f11, bounds.bottom - f11);
            float f12 = this.f8428A - (this.f8432C / 2.0f);
            canvas.drawRoundRect(rectF2, f12, f12, paint);
        }
        paint.setColor(this.f8475q0);
        paint.setStyle(Paint.Style.FILL);
        rectF2.set(bounds);
        if (this.f8439F0) {
            RectF rectF3 = new RectF(bounds);
            Path path = this.f8469k0;
            C3907g c3907g = this.f13126a;
            this.f13143r.m7827a(c3907g.f13107a, c3907g.f13115i, rectF3, this.f13142q, path);
            i10 = 0;
            m7801e(canvas, paint, path, this.f13126a.f13107a, m7802g());
        } else {
            canvas.drawRoundRect(rectF2, m5450A(), m5450A(), paint);
            i10 = 0;
        }
        if (m5474a0()) {
            m5477x(bounds, rectF2);
            float f13 = rectF2.left;
            float f14 = rectF2.top;
            canvas.translate(f13, f14);
            this.f8440G.setBounds(i10, i10, (int) rectF2.width(), (int) rectF2.height());
            this.f8440G.draw(canvas);
            canvas.translate(-f13, -f14);
        }
        if (m5473Z()) {
            m5477x(bounds, rectF2);
            float f15 = rectF2.left;
            float f16 = rectF2.top;
            canvas.translate(f15, f16);
            this.f8452S.setBounds(i10, i10, (int) rectF2.width(), (int) rectF2.height());
            this.f8452S.draw(canvas);
            canvas.translate(-f15, -f16);
        }
        if (!this.f8435D0 || this.f8436E == null) {
            rectF = rectF2;
            i11 = iSaveLayerAlpha;
            i12 = 255;
        } else {
            PointF pointF = this.f8468j0;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            CharSequence charSequence = this.f8436E;
            C1838x c1838x = this.f8470l0;
            if (charSequence != null) {
                float fM5478y = m5478y() + this.f8456W + this.f8459Z;
                if (AbstractC3198d.m6474w(this) == 0) {
                    pointF.x = bounds.left + fM5478y;
                } else {
                    pointF.x = bounds.right - fM5478y;
                    align = Paint.Align.RIGHT;
                }
                float fCenterY = bounds.centerY();
                TextPaint textPaint = c1838x.f6494a;
                Paint.FontMetrics fontMetrics = this.f8466h0;
                textPaint.getFontMetrics(fontMetrics);
                pointF.y = fCenterY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
            }
            rectF2.setEmpty();
            if (this.f8436E != null) {
                float fM5478y2 = m5478y() + this.f8456W + this.f8459Z;
                float fM5479z = m5479z() + this.f8463e0 + this.f8460b0;
                if (AbstractC3198d.m6474w(this) == 0) {
                    rectF2.left = bounds.left + fM5478y2;
                    rectF2.right = bounds.right - fM5479z;
                } else {
                    rectF2.left = bounds.left + fM5479z;
                    rectF2.right = bounds.right - fM5478y2;
                }
                rectF2.top = bounds.top;
                rectF2.bottom = bounds.bottom;
            }
            C3639d c3639d = c1838x.f6499f;
            TextPaint textPaint2 = c1838x.f6494a;
            if (c3639d != null) {
                textPaint2.drawableState = getState();
                c1838x.f6499f.m7367e(this.f8464f0, textPaint2, c1838x.f6495b);
            }
            textPaint2.setTextAlign(align);
            boolean z10 = Math.round(c1838x.m4285a(this.f8436E.toString())) > Math.round(rectF2.width());
            if (z10) {
                iSave = canvas.save();
                canvas.clipRect(rectF2);
            } else {
                iSave = 0;
            }
            CharSequence charSequenceEllipsize = this.f8436E;
            if (z10 && this.f8433C0 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint2, rectF2.width(), this.f8433C0);
            }
            CharSequence charSequence2 = charSequenceEllipsize;
            int length = charSequence2.length();
            float f17 = pointF.x;
            float f18 = pointF.y;
            i12 = 255;
            rectF = rectF2;
            i11 = iSaveLayerAlpha;
            canvas.drawText(charSequence2, 0, length, f17, f18, textPaint2);
            if (z10) {
                canvas.restoreToCount(iSave);
            }
        }
        if (m5475b0()) {
            rectF.setEmpty();
            if (m5475b0()) {
                float f19 = this.f8463e0 + this.f8462d0;
                if (AbstractC3198d.m6474w(this) == 0) {
                    float f20 = bounds.right - f19;
                    rectF.right = f20;
                    rectF.left = f20 - this.f8448O;
                } else {
                    float f21 = bounds.left + f19;
                    rectF.left = f21;
                    rectF.right = f21 + this.f8448O;
                }
                float fExactCenterY = bounds.exactCenterY();
                float f22 = this.f8448O;
                float f23 = fExactCenterY - (f22 / 2.0f);
                rectF.top = f23;
                rectF.bottom = f23 + f22;
            }
            float f24 = rectF.left;
            float f25 = rectF.top;
            canvas.translate(f24, f25);
            this.f8445L.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            int[] iArr = AbstractC3722c.f12475a;
            this.f8446M.setBounds(this.f8445L.getBounds());
            this.f8446M.jumpToCurrentState();
            this.f8446M.draw(canvas);
            canvas.translate(-f24, -f25);
        }
        if (this.f8479u0 < i12) {
            canvas.restoreToCount(i11);
        }
    }

    @Override
    public final int getAlpha() {
        return this.f8479u0;
    }

    @Override
    public final ColorFilter getColorFilter() {
        return this.f8480v0;
    }

    @Override
    public final int getIntrinsicHeight() {
        return (int) this.f8486z;
    }

    @Override
    public final int getIntrinsicWidth() {
        return Math.min(Math.round(m5479z() + this.f8470l0.m4285a(this.f8436E.toString()) + m5478y() + this.f8456W + this.f8459Z + this.f8460b0 + this.f8463e0), this.f8437E0);
    }

    @Override
    public final int getOpacity() {
        return -3;
    }

    @Override
    public final void getOutline(Outline outline) {
        if (this.f8439F0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.f8486z, this.f8428A);
        } else {
            outline.setRoundRect(bounds, this.f8428A);
        }
        outline.setAlpha(this.f8479u0 / 255.0f);
    }

    @Override
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override
    public final boolean isStateful() {
        C3639d c3639d;
        ColorStateList colorStateList;
        return m5447B(this.f8482x) || m5447B(this.f8484y) || m5447B(this.f8430B) || !((c3639d = this.f8470l0.f6499f) == null || (colorStateList = c3639d.f12222j) == null || !colorStateList.isStateful()) || ((this.f8451R && this.f8452S != null && this.f8450Q) || m5448C(this.f8440G) || m5448C(this.f8452S) || m5447B(this.f8483x0));
    }

    @Override
    public final boolean onLayoutDirectionChanged(int i6) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i6);
        if (m5474a0()) {
            zOnLayoutDirectionChanged |= AbstractC3198d.m6442Q(this.f8440G, i6);
        }
        if (m5473Z()) {
            zOnLayoutDirectionChanged |= AbstractC3198d.m6442Q(this.f8452S, i6);
        }
        if (m5475b0()) {
            zOnLayoutDirectionChanged |= AbstractC3198d.m6442Q(this.f8445L, i6);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override
    public final boolean onLevelChange(int i6) {
        boolean zOnLevelChange = super.onLevelChange(i6);
        if (m5474a0()) {
            zOnLevelChange |= this.f8440G.setLevel(i6);
        }
        if (m5473Z()) {
            zOnLevelChange |= this.f8452S.setLevel(i6);
        }
        if (m5475b0()) {
            zOnLevelChange |= this.f8445L.setLevel(i6);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override
    public final boolean onStateChange(int[] iArr) {
        if (this.f8439F0) {
            super.onStateChange(iArr);
        }
        return m5452E(iArr, this.f8487z0);
    }

    @Override
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j10);
        }
    }

    @Override
    public final void setAlpha(int i6) {
        if (this.f8479u0 != i6) {
            this.f8479u0 = i6;
            invalidateSelf();
        }
    }

    @Override
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.f8480v0 != colorFilter) {
            this.f8480v0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override
    public final void setTintList(ColorStateList colorStateList) {
        if (this.f8483x0 != colorStateList) {
            this.f8483x0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override
    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.f8485y0 != mode) {
            this.f8485y0 = mode;
            ColorStateList colorStateList = this.f8483x0;
            this.f8481w0 = (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            invalidateSelf();
        }
    }

    @Override
    public final boolean setVisible(boolean z7, boolean z10) {
        boolean visible = super.setVisible(z7, z10);
        if (m5474a0()) {
            visible |= this.f8440G.setVisible(z7, z10);
        }
        if (m5473Z()) {
            visible |= this.f8452S.setVisible(z7, z10);
        }
        if (m5475b0()) {
            visible |= this.f8445L.setVisible(z7, z10);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    @Override
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final void m5476w(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        AbstractC3198d.m6442Q(drawable, AbstractC3198d.m6474w(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.f8445L) {
            if (drawable.isStateful()) {
                drawable.setState(this.f8487z0);
            }
            AbstractC2581a.m5586h(drawable, this.f8447N);
            return;
        }
        Drawable drawable2 = this.f8440G;
        if (drawable == drawable2 && this.f8443J) {
            AbstractC2581a.m5586h(drawable2, this.f8441H);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    public final void m5477x(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (m5474a0() || m5473Z()) {
            float f = this.f8456W + this.f8457X;
            Drawable drawable = this.f8477s0 ? this.f8452S : this.f8440G;
            float intrinsicWidth = this.f8442I;
            if (intrinsicWidth <= 0.0f && drawable != null) {
                intrinsicWidth = drawable.getIntrinsicWidth();
            }
            if (AbstractC3198d.m6474w(this) == 0) {
                float f3 = rect.left + f;
                rectF.left = f3;
                rectF.right = f3 + intrinsicWidth;
            } else {
                float f4 = rect.right - f;
                rectF.right = f4;
                rectF.left = f4 - intrinsicWidth;
            }
            Drawable drawable2 = this.f8477s0 ? this.f8452S : this.f8440G;
            float fCeil = this.f8442I;
            if (fCeil <= 0.0f && drawable2 != null) {
                fCeil = (float) Math.ceil(AbstractC1811a0.m4245e(this.f8464f0, 24));
                if (drawable2.getIntrinsicHeight() <= fCeil) {
                    fCeil = drawable2.getIntrinsicHeight();
                }
            }
            float fExactCenterY = rect.exactCenterY() - (fCeil / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fCeil;
        }
    }

    public final float m5478y() {
        if (!m5474a0() && !m5473Z()) {
            return 0.0f;
        }
        float f = this.f8457X;
        Drawable drawable = this.f8477s0 ? this.f8452S : this.f8440G;
        float intrinsicWidth = this.f8442I;
        if (intrinsicWidth <= 0.0f && drawable != null) {
            intrinsicWidth = drawable.getIntrinsicWidth();
        }
        return intrinsicWidth + f + this.f8458Y;
    }

    public final float m5479z() {
        if (m5475b0()) {
            return this.f8461c0 + this.f8448O + this.f8462d0;
        }
        return 0.0f;
    }
}

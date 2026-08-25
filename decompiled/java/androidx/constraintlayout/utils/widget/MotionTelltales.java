package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.util.HashMap;
import p046e0.C2342a;
import p194s.C3678b;
import p205t.AbstractC3761h0;
import p205t.AbstractC3762i;
import p205t.AbstractInterpolatorC3776p;
import p205t.C3774o;
import p205t.C3785y;
import p256y.AbstractC4193j;

public class MotionTelltales extends MockView {

    public final Paint f1282l;

    public MotionLayout f1283m;

    public final float[] f1284n;

    public final Matrix f1285o;

    public int f1286p;

    public int f1287q;

    public float f1288r;

    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1282l = new Paint();
        this.f1284n = new float[2];
        this.f1285o = new Matrix();
        this.f1286p = 0;
        this.f1287q = -65281;
        this.f1288r = 0.25f;
        m868b(context, attributeSet);
    }

    public final void m868b(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4193j.f14247m);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i6 = 0; i6 < indexCount; i6++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i6);
                if (index == 0) {
                    this.f1287q = typedArrayObtainStyledAttributes.getColor(index, this.f1287q);
                } else if (index == 2) {
                    this.f1286p = typedArrayObtainStyledAttributes.getInt(index, this.f1286p);
                } else if (index == 1) {
                    this.f1288r = typedArrayObtainStyledAttributes.getFloat(index, this.f1288r);
                }
            }
        }
        int i10 = this.f1287q;
        Paint paint = this.f1282l;
        paint.setColor(i10);
        paint.setStrokeWidth(5.0f);
    }

    @Override
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    public final void onDraw(Canvas canvas) {
        int i6;
        float[] fArr;
        int i10;
        float[] fArr2;
        int i11;
        float f;
        double[] dArr;
        MotionTelltales motionTelltales = this;
        int i12 = 5;
        super.onDraw(canvas);
        Matrix matrix = getMatrix();
        Matrix matrix2 = motionTelltales.f1285o;
        matrix.invert(matrix2);
        if (motionTelltales.f1283m == null) {
            ViewParent parent = getParent();
            if (parent instanceof MotionLayout) {
                motionTelltales.f1283m = (MotionLayout) parent;
                return;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float[] fArr3 = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        int i13 = 0;
        while (i13 < i12) {
            float f3 = fArr3[i13];
            int i14 = 0;
            while (i14 < i12) {
                float f4 = fArr3[i14];
                MotionLayout motionLayout = motionTelltales.f1283m;
                int i15 = motionTelltales.f1286p;
                float fMo7435a = motionLayout.f1235s;
                float interpolation = motionLayout.f1196D;
                if (motionLayout.f1233r != null) {
                    float fSignum = Math.signum(motionLayout.f1198F - interpolation);
                    float interpolation2 = motionLayout.f1233r.getInterpolation(motionLayout.f1196D + 1.0E-5f);
                    interpolation = motionLayout.f1233r.getInterpolation(motionLayout.f1196D);
                    fMo7435a = (((interpolation2 - interpolation) / 1.0E-5f) * fSignum) / motionLayout.f1194B;
                }
                Interpolator interpolator = motionLayout.f1233r;
                if (interpolator instanceof AbstractInterpolatorC3776p) {
                    fMo7435a = ((AbstractInterpolatorC3776p) interpolator).mo7435a();
                }
                float f5 = fMo7435a;
                C3774o c3774o = (C3774o) motionLayout.f1249z.get(motionTelltales);
                int i16 = i15 & 1;
                float[] fArr4 = motionTelltales.f1284n;
                if (i16 == 0) {
                    int width2 = getWidth();
                    int height2 = getHeight();
                    float[] fArr5 = c3774o.f12667t;
                    float fM7517a = c3774o.m7517a(fArr5, interpolation);
                    HashMap map = c3774o.f12670w;
                    fArr = fArr3;
                    AbstractC3761h0 abstractC3761h0 = map == null ? null : (AbstractC3761h0) map.get("translationX");
                    HashMap map2 = c3774o.f12670w;
                    AbstractC3761h0 abstractC3761h1 = map2 == null ? null : (AbstractC3761h0) map2.get("translationY");
                    HashMap map3 = c3774o.f12670w;
                    i10 = i13;
                    AbstractC3761h0 abstractC3761h2 = map3 == null ? null : (AbstractC3761h0) map3.get("rotation");
                    HashMap map4 = c3774o.f12670w;
                    i6 = width;
                    AbstractC3761h0 abstractC3761h3 = map4 == null ? null : (AbstractC3761h0) map4.get("scaleX");
                    HashMap map5 = c3774o.f12670w;
                    AbstractC3761h0 abstractC3761h4 = map5 == null ? null : (AbstractC3761h0) map5.get("scaleY");
                    HashMap map6 = c3774o.f12671x;
                    AbstractC3762i abstractC3762i = map6 == null ? null : (AbstractC3762i) map6.get("translationX");
                    HashMap map7 = c3774o.f12671x;
                    AbstractC3762i abstractC3762i2 = map7 == null ? null : (AbstractC3762i) map7.get("translationY");
                    HashMap map8 = c3774o.f12671x;
                    AbstractC3762i abstractC3762i3 = map8 == null ? null : (AbstractC3762i) map8.get("rotation");
                    HashMap map9 = c3774o.f12671x;
                    AbstractC3762i abstractC3762i4 = map9 == null ? null : (AbstractC3762i) map9.get("scaleX");
                    HashMap map10 = c3774o.f12671x;
                    AbstractC3762i abstractC3762i5 = map10 != null ? (AbstractC3762i) map10.get("scaleY") : null;
                    C2342a c2342a = new C2342a();
                    c2342a.f8183e = 0.0f;
                    c2342a.f8182d = 0.0f;
                    c2342a.f8181c = 0.0f;
                    c2342a.f8180b = 0.0f;
                    c2342a.f8179a = 0.0f;
                    if (abstractC3761h2 != null) {
                        c2342a.f8183e = (float) abstractC3761h2.f12608a.mo7278u(fM7517a);
                        c2342a.f8184f = abstractC3761h2.m7507a(fM7517a);
                    }
                    if (abstractC3761h0 != null) {
                        c2342a.f8181c = (float) abstractC3761h0.f12608a.mo7278u(fM7517a);
                    }
                    if (abstractC3761h1 != null) {
                        c2342a.f8182d = (float) abstractC3761h1.f12608a.mo7278u(fM7517a);
                    }
                    if (abstractC3761h3 != null) {
                        c2342a.f8179a = (float) abstractC3761h3.f12608a.mo7278u(fM7517a);
                    }
                    if (abstractC3761h4 != null) {
                        c2342a.f8180b = (float) abstractC3761h4.f12608a.mo7278u(fM7517a);
                    }
                    if (abstractC3762i3 != null) {
                        c2342a.f8183e = abstractC3762i3.m7509b(fM7517a);
                    }
                    if (abstractC3762i != null) {
                        c2342a.f8181c = abstractC3762i.m7509b(fM7517a);
                    }
                    AbstractC3762i abstractC3762i6 = abstractC3762i2;
                    if (abstractC3762i2 != null) {
                        c2342a.f8182d = abstractC3762i6.m7509b(fM7517a);
                    }
                    if (abstractC3762i4 != null || abstractC3762i5 != null) {
                        if (abstractC3762i4 == null) {
                            c2342a.f8179a = abstractC3762i4.m7509b(fM7517a);
                        }
                        if (abstractC3762i5 == null) {
                            c2342a.f8180b = abstractC3762i5.m7509b(fM7517a);
                        }
                    }
                    C3678b c3678b = c3774o.f12656i;
                    if (c3678b != null) {
                        double[] dArr2 = c3774o.f12661n;
                        if (dArr2.length > 0) {
                            double d = fM7517a;
                            c3678b.mo7276r(d, dArr2);
                            c3774o.f12656i.mo7279v(d, c3774o.f12662o);
                            int[] iArr = c3774o.f12660m;
                            double[] dArr3 = c3774o.f12662o;
                            double[] dArr4 = c3774o.f12661n;
                            c3774o.f12651d.getClass();
                            fArr2 = fArr4;
                            C3785y.m7537d(f4, f3, fArr2, iArr, dArr3, dArr4);
                        } else {
                            fArr2 = fArr4;
                        }
                        c2342a.m5314a(f4, f3, width2, height2, fArr2);
                        f = f4;
                        i11 = i15;
                    } else {
                        fArr2 = fArr4;
                        i14 = i14;
                        if (c3774o.f12655h != null) {
                            double dM7517a = c3774o.m7517a(fArr5, fM7517a);
                            c3774o.f12655h[0].mo7279v(dM7517a, c3774o.f12662o);
                            c3774o.f12655h[0].mo7276r(dM7517a, c3774o.f12661n);
                            float f10 = fArr5[0];
                            int i17 = 0;
                            while (true) {
                                dArr = c3774o.f12662o;
                                if (i17 >= dArr.length) {
                                    break;
                                }
                                dArr[i17] = dArr[i17] * ((double) f10);
                                i17++;
                            }
                            int[] iArr2 = c3774o.f12660m;
                            double[] dArr5 = c3774o.f12661n;
                            c3774o.f12651d.getClass();
                            C3785y.m7537d(f4, f3, fArr2, iArr2, dArr, dArr5);
                            c2342a.m5314a(f4, f3, width2, height2, fArr2);
                            i11 = i15;
                            f = f4;
                        } else {
                            C3785y c3785y = c3774o.f12652e;
                            float f11 = c3785y.f12739e;
                            C3785y c3785y2 = c3774o.f12651d;
                            AbstractC3762i abstractC3762i7 = abstractC3762i4;
                            float f12 = f11 - c3785y2.f12739e;
                            float f13 = c3785y.f12740f - c3785y2.f12740f;
                            AbstractC3762i abstractC3762i8 = abstractC3762i;
                            float f14 = c3785y.f12741g - c3785y2.f12741g;
                            float f15 = (c3785y.f12742h - c3785y2.f12742h) + f13;
                            fArr2[0] = ((f14 + f12) * f4) + ((1.0f - f4) * f12);
                            fArr2[1] = (f15 * f3) + ((1.0f - f3) * f13);
                            c2342a.f8183e = 0.0f;
                            c2342a.f8182d = 0.0f;
                            c2342a.f8181c = 0.0f;
                            c2342a.f8180b = 0.0f;
                            c2342a.f8179a = 0.0f;
                            if (abstractC3761h2 != 0) {
                                c2342a.f8183e = (float) abstractC3761h2.f12608a.mo7278u(fM7517a);
                                c2342a.f8184f = abstractC3761h2.m7507a(fM7517a);
                            }
                            if (abstractC3761h0 != null) {
                                c2342a.f8181c = (float) abstractC3761h0.f12608a.mo7278u(fM7517a);
                            }
                            if (abstractC3761h1 != null) {
                                c2342a.f8182d = (float) abstractC3761h1.f12608a.mo7278u(fM7517a);
                            }
                            if (abstractC3761h3 != null) {
                                c2342a.f8179a = (float) abstractC3761h3.f12608a.mo7278u(fM7517a);
                            }
                            if (abstractC3761h4 != null) {
                                c2342a.f8180b = (float) abstractC3761h4.f12608a.mo7278u(fM7517a);
                            }
                            if (abstractC3762i3 != null) {
                                c2342a.f8183e = abstractC3762i3.m7509b(fM7517a);
                            }
                            if (abstractC3762i8 != null) {
                                c2342a.f8181c = abstractC3762i8.m7509b(fM7517a);
                            }
                            if (abstractC3762i6 != null) {
                                c2342a.f8182d = abstractC3762i6.m7509b(fM7517a);
                            }
                            if (abstractC3762i7 != null || abstractC3762i5 != null) {
                                if (abstractC3762i7 == null) {
                                    c2342a.f8179a = abstractC3762i7.m7509b(fM7517a);
                                }
                                if (abstractC3762i5 == null) {
                                    c2342a.f8180b = abstractC3762i5.m7509b(fM7517a);
                                }
                            }
                            i11 = i15;
                            f = f4;
                            c2342a.m5314a(f4, f3, width2, height2, fArr2);
                        }
                    }
                    fArr2 = fArr2;
                } else {
                    f5 = f5;
                    i6 = width;
                    matrix2 = matrix2;
                    height = height;
                    fArr = fArr3;
                    i10 = i13;
                    fArr2 = fArr4;
                    i11 = i15;
                    f = f4;
                    i14 = i14;
                    f3 = f3;
                    c3774o.m7518b(interpolation, f, f3, fArr2);
                }
                if (i11 < 2) {
                    fArr2[0] = fArr2[0] * f5;
                    fArr2[1] = fArr2[1] * f5;
                }
                motionTelltales = this;
                float[] fArr6 = motionTelltales.f1284n;
                Matrix matrix3 = matrix2;
                matrix3.mapVectors(fArr6);
                int i18 = i6;
                float f16 = i18 * f;
                int i19 = height;
                float f17 = i19 * f3;
                float f18 = fArr6[0];
                float f19 = motionTelltales.f1288r;
                float f20 = f17 - (fArr6[1] * f19);
                matrix3.mapVectors(fArr6);
                canvas.drawLine(f16, f17, f16 - (f18 * f19), f20, motionTelltales.f1282l);
                i14++;
                height = i19;
                f3 = f3;
                fArr3 = fArr;
                i13 = i10;
                i12 = 5;
                matrix2 = matrix3;
                width = i18;
            }
            i13++;
            height = height;
            i12 = 5;
            matrix2 = matrix2;
            width = width;
        }
    }

    @Override
    public final void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        super.onLayout(z7, i6, i10, i11, i12);
        postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        this.f1276f = charSequence.toString();
        requestLayout();
    }

    public MotionTelltales(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f1282l = new Paint();
        this.f1284n = new float[2];
        this.f1285o = new Matrix();
        this.f1286p = 0;
        this.f1287q = -65281;
        this.f1288r = 0.25f;
        m868b(context, attributeSet);
    }
}

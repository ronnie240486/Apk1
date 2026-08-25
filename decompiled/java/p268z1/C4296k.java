package p268z1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import com.google.android.gms.internal.cast.C1552f0;
import java.util.ArrayList;
import p056f0.C2483f;
import p160p.C3341e;

public final class C4296k {

    public static final Matrix f14555p = new Matrix();

    public final Path f14556a;

    public final Path f14557b;

    public final Matrix f14558c;

    public Paint f14559d;

    public Paint f14560e;

    public PathMeasure f14561f;

    public final C4293h f14562g;

    public float f14563h;

    public float f14564i;

    public float f14565j;

    public float f14566k;

    public int f14567l;

    public String f14568m;

    public Boolean f14569n;

    public final C3341e f14570o;

    public C4296k() {
        this.f14558c = new Matrix();
        this.f14563h = 0.0f;
        this.f14564i = 0.0f;
        this.f14565j = 0.0f;
        this.f14566k = 0.0f;
        this.f14567l = 255;
        this.f14568m = null;
        this.f14569n = null;
        this.f14570o = new C3341e(0);
        this.f14562g = new C4293h();
        this.f14556a = new Path();
        this.f14557b = new Path();
    }

    public final void m8351a(C4293h c4293h, Matrix matrix, Canvas canvas, int i6, int i10) {
        Matrix matrix2;
        float f;
        float f3;
        C1552f0 c1552f0;
        boolean z7;
        C1552f0 c1552f1;
        Paint paint;
        Paint.Join join;
        Paint.Cap cap;
        Shader shader;
        Paint paint2;
        Shader shader2;
        Path.FillType fillType;
        char c5 = 1;
        c4293h.f14541a.set(matrix);
        Matrix matrix3 = c4293h.f14550j;
        Matrix matrix4 = c4293h.f14541a;
        matrix4.preConcat(matrix3);
        canvas.save();
        ?? r11 = 0;
        int i11 = 0;
        while (true) {
            ArrayList arrayList = c4293h.f14542b;
            if (i11 >= arrayList.size()) {
                canvas.restore();
                return;
            }
            AbstractC4294i abstractC4294i = (AbstractC4294i) arrayList.get(i11);
            if (abstractC4294i instanceof C4293h) {
                m8351a((C4293h) abstractC4294i, matrix4, canvas, i6, i10);
            } else {
                if (abstractC4294i instanceof AbstractC4295j) {
                    AbstractC4295j abstractC4295j = (AbstractC4295j) abstractC4294i;
                    float f4 = i6 / this.f14565j;
                    float f5 = i10 / this.f14566k;
                    float fMin = Math.min(f4, f5);
                    Matrix matrix5 = this.f14558c;
                    matrix5.set(matrix4);
                    matrix5.postScale(f4, f5);
                    float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                    matrix4.mapVectors(fArr);
                    float fHypot = (float) Math.hypot(fArr[r11], fArr[c5]);
                    matrix2 = matrix4;
                    float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
                    float f10 = (fArr[r11] * fArr[3]) - (fArr[1] * fArr[2]);
                    float fMax = Math.max(fHypot, fHypot2);
                    float fAbs = fMax > 0.0f ? Math.abs(f10) / fMax : 0.0f;
                    if (fAbs != 0.0f) {
                        abstractC4295j.getClass();
                        Path path = this.f14556a;
                        path.reset();
                        C2483f[] c2483fArr = abstractC4295j.f14552a;
                        if (c2483fArr != null) {
                            C2483f.m5520b(c2483fArr, path);
                        }
                        Path path2 = this.f14557b;
                        path2.reset();
                        if (abstractC4295j instanceof C4291f) {
                            path2.setFillType(abstractC4295j.f14554c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                            path2.addPath(path, matrix5);
                            canvas.clipPath(path2);
                        } else {
                            C4292g c4292g = (C4292g) abstractC4295j;
                            float f11 = c4292g.f14535i;
                            if (f11 == 0.0f) {
                                f = 1.0f;
                                if (c4292g.f14536j != 1.0f) {
                                }
                                path2.addPath(path, matrix5);
                                c1552f0 = c4292g.f14532f;
                                if (((Shader) c1552f0.f5292b) != null && c1552f0.f5291a == 0) {
                                    z7 = false;
                                } else {
                                    z7 = true;
                                }
                                if (z7) {
                                    if (this.f14560e == null) {
                                        Paint paint3 = new Paint(1);
                                        this.f14560e = paint3;
                                        paint3.setStyle(Paint.Style.FILL);
                                    }
                                    paint2 = this.f14560e;
                                    shader2 = (Shader) c1552f0.f5292b;
                                    if (shader2 != null) {
                                        shader2.setLocalMatrix(matrix5);
                                        paint2.setShader(shader2);
                                        paint2.setAlpha(Math.round(c4292g.f14534h * 255.0f));
                                    } else {
                                        paint2.setShader(null);
                                        paint2.setAlpha(255);
                                        int i12 = c1552f0.f5291a;
                                        float f12 = c4292g.f14534h;
                                        PorterDuff.Mode mode = C4299n.f14584j;
                                        paint2.setColor((i12 & 16777215) | (((int) (Color.alpha(i12) * f12)) << 24));
                                    }
                                    paint2.setColorFilter(null);
                                    if (c4292g.f14554c == 0) {
                                        fillType = Path.FillType.WINDING;
                                    } else {
                                        fillType = Path.FillType.EVEN_ODD;
                                    }
                                    path2.setFillType(fillType);
                                    canvas.drawPath(path2, paint2);
                                }
                                c1552f1 = c4292g.f14530d;
                                if (((Shader) c1552f1.f5292b) == null || c1552f1.f5291a != 0) {
                                    if (this.f14559d == null) {
                                        Paint paint4 = new Paint(1);
                                        this.f14559d = paint4;
                                        paint4.setStyle(Paint.Style.STROKE);
                                    }
                                    paint = this.f14559d;
                                    join = c4292g.f14539m;
                                    if (join != null) {
                                        paint.setStrokeJoin(join);
                                    }
                                    cap = c4292g.f14538l;
                                    if (cap != null) {
                                        paint.setStrokeCap(cap);
                                    }
                                    paint.setStrokeMiter(c4292g.f14540n);
                                    shader = (Shader) c1552f1.f5292b;
                                    if (shader != null) {
                                        shader.setLocalMatrix(matrix5);
                                        paint.setShader(shader);
                                        paint.setAlpha(Math.round(c4292g.f14533g * 255.0f));
                                    } else {
                                        paint.setShader(null);
                                        paint.setAlpha(255);
                                        int i13 = c1552f1.f5291a;
                                        float f13 = c4292g.f14533g;
                                        PorterDuff.Mode mode2 = C4299n.f14584j;
                                        paint.setColor((i13 & 16777215) | (((int) (Color.alpha(i13) * f13)) << 24));
                                    }
                                    paint.setColorFilter(null);
                                    paint.setStrokeWidth(c4292g.f14531e * fAbs * fMin);
                                    canvas.drawPath(path2, paint);
                                }
                            } else {
                                f = 1.0f;
                            }
                            float f14 = c4292g.f14537k;
                            float f15 = (f11 + f14) % f;
                            float f16 = (c4292g.f14536j + f14) % f;
                            if (this.f14561f == null) {
                                this.f14561f = new PathMeasure();
                            }
                            this.f14561f.setPath(path, r11);
                            float length = this.f14561f.getLength();
                            float f17 = f15 * length;
                            float f18 = f16 * length;
                            path.reset();
                            if (f17 > f18) {
                                this.f14561f.getSegment(f17, length, path, true);
                                f3 = 0.0f;
                                this.f14561f.getSegment(0.0f, f18, path, true);
                            } else {
                                f3 = 0.0f;
                                this.f14561f.getSegment(f17, f18, path, true);
                            }
                            path.rLineTo(f3, f3);
                            path2.addPath(path, matrix5);
                            c1552f0 = c4292g.f14532f;
                            if (((Shader) c1552f0.f5292b) != null) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            if (z7) {
                                if (this.f14560e == null) {
                                    Paint paint5 = new Paint(1);
                                    this.f14560e = paint5;
                                    paint5.setStyle(Paint.Style.FILL);
                                }
                                paint2 = this.f14560e;
                                shader2 = (Shader) c1552f0.f5292b;
                                if (shader2 != null) {
                                    shader2.setLocalMatrix(matrix5);
                                    paint2.setShader(shader2);
                                    paint2.setAlpha(Math.round(c4292g.f14534h * 255.0f));
                                } else {
                                    paint2.setShader(null);
                                    paint2.setAlpha(255);
                                    int i14 = c1552f0.f5291a;
                                    float f19 = c4292g.f14534h;
                                    PorterDuff.Mode mode3 = C4299n.f14584j;
                                    paint2.setColor((i14 & 16777215) | (((int) (Color.alpha(i14) * f19)) << 24));
                                }
                                paint2.setColorFilter(null);
                                if (c4292g.f14554c == 0) {
                                    fillType = Path.FillType.WINDING;
                                } else {
                                    fillType = Path.FillType.EVEN_ODD;
                                }
                                path2.setFillType(fillType);
                                canvas.drawPath(path2, paint2);
                            }
                            c1552f1 = c4292g.f14530d;
                            if (((Shader) c1552f1.f5292b) == null) {
                                if (this.f14559d == null) {
                                    Paint paint6 = new Paint(1);
                                    this.f14559d = paint6;
                                    paint6.setStyle(Paint.Style.STROKE);
                                }
                                paint = this.f14559d;
                                join = c4292g.f14539m;
                                if (join != null) {
                                    paint.setStrokeJoin(join);
                                }
                                cap = c4292g.f14538l;
                                if (cap != null) {
                                    paint.setStrokeCap(cap);
                                }
                                paint.setStrokeMiter(c4292g.f14540n);
                                shader = (Shader) c1552f1.f5292b;
                                if (shader != null) {
                                    shader.setLocalMatrix(matrix5);
                                    paint.setShader(shader);
                                    paint.setAlpha(Math.round(c4292g.f14533g * 255.0f));
                                } else {
                                    paint.setShader(null);
                                    paint.setAlpha(255);
                                    int i15 = c1552f1.f5291a;
                                    float f110 = c4292g.f14533g;
                                    PorterDuff.Mode mode4 = C4299n.f14584j;
                                    paint.setColor((i15 & 16777215) | (((int) (Color.alpha(i15) * f110)) << 24));
                                }
                                paint.setColorFilter(null);
                                paint.setStrokeWidth(c4292g.f14531e * fAbs * fMin);
                                canvas.drawPath(path2, paint);
                            } else {
                                if (this.f14559d == null) {
                                    Paint paint7 = new Paint(1);
                                    this.f14559d = paint7;
                                    paint7.setStyle(Paint.Style.STROKE);
                                }
                                paint = this.f14559d;
                                join = c4292g.f14539m;
                                if (join != null) {
                                    paint.setStrokeJoin(join);
                                }
                                cap = c4292g.f14538l;
                                if (cap != null) {
                                    paint.setStrokeCap(cap);
                                }
                                paint.setStrokeMiter(c4292g.f14540n);
                                shader = (Shader) c1552f1.f5292b;
                                if (shader != null) {
                                    shader.setLocalMatrix(matrix5);
                                    paint.setShader(shader);
                                    paint.setAlpha(Math.round(c4292g.f14533g * 255.0f));
                                } else {
                                    paint.setShader(null);
                                    paint.setAlpha(255);
                                    int i16 = c1552f1.f5291a;
                                    float f111 = c4292g.f14533g;
                                    PorterDuff.Mode mode5 = C4299n.f14584j;
                                    paint.setColor((i16 & 16777215) | (((int) (Color.alpha(i16) * f111)) << 24));
                                }
                                paint.setColorFilter(null);
                                paint.setStrokeWidth(c4292g.f14531e * fAbs * fMin);
                                canvas.drawPath(path2, paint);
                            }
                        }
                    }
                }
                i11++;
                matrix4 = matrix2;
                c5 = 1;
                r11 = 0;
            }
            matrix2 = matrix4;
            i11++;
            matrix4 = matrix2;
            c5 = 1;
            r11 = 0;
        }
    }

    public float getAlpha() {
        return getRootAlpha() / 255.0f;
    }

    public int getRootAlpha() {
        return this.f14567l;
    }

    public void setAlpha(float f) {
        setRootAlpha((int) (f * 255.0f));
    }

    public void setRootAlpha(int i6) {
        this.f14567l = i6;
    }

    public C4296k(C4296k c4296k) {
        this.f14558c = new Matrix();
        this.f14563h = 0.0f;
        this.f14564i = 0.0f;
        this.f14565j = 0.0f;
        this.f14566k = 0.0f;
        this.f14567l = 255;
        this.f14568m = null;
        this.f14569n = null;
        C3341e c3341e = new C3341e(0);
        this.f14570o = c3341e;
        this.f14562g = new C4293h(c4296k.f14562g, c3341e);
        this.f14556a = new Path(c4296k.f14556a);
        this.f14557b = new Path(c4296k.f14557b);
        this.f14563h = c4296k.f14563h;
        this.f14564i = c4296k.f14564i;
        this.f14565j = c4296k.f14565j;
        this.f14566k = c4296k.f14566k;
        this.f14567l = c4296k.f14567l;
        this.f14568m = c4296k.f14568m;
        String str = c4296k.f14568m;
        if (str != null) {
            c3341e.put(str, this);
        }
        this.f14569n = c4296k.f14569n;
    }
}

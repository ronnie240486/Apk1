package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import androidx.media3.extractor.p010ts.TsExtractor;
import java.util.WeakHashMap;
import p055ea.AbstractC2460q;
import p066g1.C2592a;
import p118l0.AbstractC2959j;
import p138n0.AbstractC3155s0;
import p143n5.AbstractC3198d;
import p156o9.AbstractC3281e;
import p189r6.C3636a;
import p189r6.C3639d;
import p262y5.AbstractC4268a;

public final class C1816d {

    public Typeface f6365A;

    public Typeface f6366B;

    public Typeface f6367C;

    public Typeface f6368D;

    public C3636a f6369E;

    public C3636a f6370F;

    public CharSequence f6371G;

    public CharSequence f6372H;

    public boolean f6373I;

    public Bitmap f6375K;

    public float f6376L;

    public float f6377M;

    public float f6378N;

    public float f6379O;

    public float f6380P;

    public int f6381Q;

    public int[] f6382R;

    public boolean f6383S;

    public final TextPaint f6384T;

    public final TextPaint f6385U;

    public TimeInterpolator f6386V;

    public TimeInterpolator f6387W;

    public float f6388X;

    public float f6389Y;

    public float f6390Z;

    public final ViewGroup f6391a;

    public ColorStateList f6392a0;

    public boolean f6393b;

    public float f6394b0;

    public float f6395c;

    public float f6396c0;

    public boolean f6397d;

    public float f6398d0;

    public float f6399e;

    public ColorStateList f6400e0;

    public float f6401f;

    public float f6402f0;

    public int f6403g;

    public float f6404g0;

    public final Rect f6405h;

    public float f6406h0;

    public final Rect f6407i;

    public StaticLayout f6408i0;

    public final RectF f6409j;

    public float f6410j0;

    public float f6412k0;

    public float f6414l0;

    public CharSequence f6416m0;

    public ColorStateList f6419o;

    public ColorStateList f6421p;

    public int f6423q;

    public float f6425r;

    public float f6426s;

    public float f6427t;

    public float f6428u;

    public float f6429v;

    public float f6430w;

    public Typeface f6431x;

    public Typeface f6432y;

    public Typeface f6433z;

    public int f6411k = 16;

    public int f6413l = 16;

    public float f6415m = 15.0f;

    public float f6417n = 15.0f;

    public boolean f6374J = true;

    public int f6418n0 = 1;

    public float f6420o0 = 0.0f;

    public float f6422p0 = 1.0f;

    public int f6424q0 = C1835u.f6476m;

    public C1816d(ViewGroup viewGroup) {
        this.f6391a = viewGroup;
        TextPaint textPaint = new TextPaint(TsExtractor.TS_STREAM_TYPE_AC3);
        this.f6384T = textPaint;
        this.f6385U = new TextPaint(textPaint);
        this.f6407i = new Rect();
        this.f6405h = new Rect();
        this.f6409j = new RectF();
        float f = this.f6399e;
        this.f6401f = AbstractC2460q.m5490d(1.0f, f, 0.5f, f);
        m4263h(viewGroup.getContext().getResources().getConfiguration());
    }

    public static int m4256a(float f, int i6, int i10) {
        float f3 = 1.0f - f;
        return Color.argb(Math.round((Color.alpha(i10) * f) + (Color.alpha(i6) * f3)), Math.round((Color.red(i10) * f) + (Color.red(i6) * f3)), Math.round((Color.green(i10) * f) + (Color.green(i6) * f3)), Math.round((Color.blue(i10) * f) + (Color.blue(i6) * f3)));
    }

    public static float m4257g(float f, float f3, float f4, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return AbstractC4268a.m8309a(f, f3, f4);
    }

    public final boolean m4258b(CharSequence charSequence) {
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        boolean z7 = this.f6391a.getLayoutDirection() == 1;
        if (this.f6374J) {
            return (z7 ? AbstractC2959j.f10140d : AbstractC2959j.f10139c).m441d(charSequence, charSequence.length());
        }
        return z7;
    }

    public final void m4259c(float f, boolean z7) {
        boolean z10;
        float f3;
        float f4;
        boolean z11;
        StaticLayout staticLayoutM4280a;
        Layout.Alignment alignment;
        if (this.f6371G == null) {
            return;
        }
        float fWidth = this.f6407i.width();
        float fWidth2 = this.f6405h.width();
        if (Math.abs(f - 1.0f) < 1.0E-5f) {
            f3 = this.f6417n;
            f4 = this.f6402f0;
            this.f6376L = 1.0f;
            Typeface typeface = this.f6368D;
            Typeface typeface2 = this.f6431x;
            if (typeface != typeface2) {
                this.f6368D = typeface2;
                z11 = true;
            } else {
                z11 = false;
            }
        } else {
            float f5 = this.f6415m;
            float f10 = this.f6404g0;
            Typeface typeface3 = this.f6368D;
            Typeface typeface4 = this.f6365A;
            if (typeface3 != typeface4) {
                this.f6368D = typeface4;
                z10 = true;
            } else {
                z10 = false;
            }
            if (Math.abs(f - 0.0f) < 1.0E-5f) {
                this.f6376L = 1.0f;
            } else {
                this.f6376L = m4257g(this.f6415m, this.f6417n, f, this.f6387W) / this.f6415m;
            }
            float f11 = this.f6417n / this.f6415m;
            fWidth = (!z7 && fWidth2 * f11 > fWidth) ? Math.min(fWidth / f11, fWidth2) : fWidth2;
            f3 = f5;
            f4 = f10;
            z11 = z10;
        }
        if (fWidth > 0.0f) {
            z11 = ((this.f6377M > f3 ? 1 : (this.f6377M == f3 ? 0 : -1)) != 0) || ((this.f6406h0 > f4 ? 1 : (this.f6406h0 == f4 ? 0 : -1)) != 0) || this.f6383S || z11;
            this.f6377M = f3;
            this.f6406h0 = f4;
            this.f6383S = false;
        }
        if (this.f6372H == null || z11) {
            float f12 = this.f6377M;
            TextPaint textPaint = this.f6384T;
            textPaint.setTextSize(f12);
            textPaint.setTypeface(this.f6368D);
            textPaint.setLetterSpacing(this.f6406h0);
            textPaint.setLinearText(this.f6376L != 1.0f);
            boolean zM4258b = m4258b(this.f6371G);
            this.f6373I = zM4258b;
            int i6 = this.f6418n0;
            if (i6 <= 1 || (zM4258b && !this.f6397d)) {
                i6 = 1;
            }
            try {
                if (i6 == 1) {
                    alignment = Layout.Alignment.ALIGN_NORMAL;
                } else {
                    int absoluteGravity = Gravity.getAbsoluteGravity(this.f6411k, zM4258b ? 1 : 0) & 7;
                    if (absoluteGravity == 1) {
                        alignment = Layout.Alignment.ALIGN_CENTER;
                    } else if (absoluteGravity != 5) {
                        alignment = this.f6373I ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
                    } else {
                        alignment = this.f6373I ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE;
                    }
                }
                C1835u c1835u = new C1835u(this.f6371G, textPaint, (int) fWidth);
                c1835u.f6491l = TextUtils.TruncateAt.END;
                c1835u.f6490k = zM4258b;
                c1835u.f6484e = alignment;
                c1835u.f6489j = false;
                c1835u.f6485f = i6;
                float f13 = this.f6420o0;
                float f14 = this.f6422p0;
                c1835u.f6486g = f13;
                c1835u.f6487h = f14;
                c1835u.f6488i = this.f6424q0;
                staticLayoutM4280a = c1835u.m4280a();
            } catch (C1834t e5) {
                Log.e("CollapsingTextHelper", e5.getCause().getMessage(), e5);
                staticLayoutM4280a = null;
            }
            staticLayoutM4280a.getClass();
            this.f6408i0 = staticLayoutM4280a;
            this.f6372H = staticLayoutM4280a.getText();
        }
    }

    public final void m4260d(Canvas canvas) {
        int iSave = canvas.save();
        if (this.f6372H == null || !this.f6393b) {
            return;
        }
        TextPaint textPaint = this.f6384T;
        textPaint.setTextSize(this.f6377M);
        float f = this.f6429v;
        float f3 = this.f6430w;
        float f4 = this.f6376L;
        if (f4 != 1.0f && !this.f6397d) {
            canvas.scale(f4, f4, f, f3);
        }
        if (this.f6418n0 <= 1 || ((this.f6373I && !this.f6397d) || (this.f6397d && this.f6395c <= this.f6401f))) {
            canvas.translate(f, f3);
            this.f6408i0.draw(canvas);
        } else {
            float lineStart = this.f6429v - this.f6408i0.getLineStart(0);
            int alpha = textPaint.getAlpha();
            canvas.translate(lineStart, f3);
            float f5 = alpha;
            textPaint.setAlpha((int) (this.f6414l0 * f5));
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 31) {
                textPaint.setShadowLayer(this.f6378N, this.f6379O, this.f6380P, AbstractC3281e.m6620j(this.f6381Q, textPaint.getAlpha()));
            }
            this.f6408i0.draw(canvas);
            textPaint.setAlpha((int) (this.f6412k0 * f5));
            if (i6 >= 31) {
                textPaint.setShadowLayer(this.f6378N, this.f6379O, this.f6380P, AbstractC3281e.m6620j(this.f6381Q, textPaint.getAlpha()));
            }
            int lineBaseline = this.f6408i0.getLineBaseline(0);
            CharSequence charSequence = this.f6416m0;
            float f10 = lineBaseline;
            canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f10, textPaint);
            if (i6 >= 31) {
                textPaint.setShadowLayer(this.f6378N, this.f6379O, this.f6380P, this.f6381Q);
            }
            if (!this.f6397d) {
                String strTrim = this.f6416m0.toString().trim();
                if (strTrim.endsWith("…")) {
                    strTrim = strTrim.substring(0, strTrim.length() - 1);
                }
                String str = strTrim;
                textPaint.setAlpha(alpha);
                canvas.drawText(str, 0, Math.min(this.f6408i0.getLineEnd(0), str.length()), 0.0f, f10, (Paint) textPaint);
            }
        }
        canvas.restoreToCount(iSave);
    }

    public final float m4261e() {
        TextPaint textPaint = this.f6385U;
        textPaint.setTextSize(this.f6417n);
        textPaint.setTypeface(this.f6431x);
        textPaint.setLetterSpacing(this.f6402f0);
        return -textPaint.ascent();
    }

    public final int m4262f(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.f6382R;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final void m4263h(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f6433z;
            if (typeface != null) {
                this.f6432y = AbstractC3198d.m6428C(configuration, typeface);
            }
            Typeface typeface2 = this.f6367C;
            if (typeface2 != null) {
                this.f6366B = AbstractC3198d.m6428C(configuration, typeface2);
            }
            Typeface typeface3 = this.f6432y;
            if (typeface3 == null) {
                typeface3 = this.f6433z;
            }
            this.f6431x = typeface3;
            Typeface typeface4 = this.f6366B;
            if (typeface4 == null) {
                typeface4 = this.f6367C;
            }
            this.f6365A = typeface4;
            m4265j(true);
        }
    }

    public final void m4264i() {
        boolean z7;
        Rect rect = this.f6407i;
        if (rect.width() <= 0 || rect.height() <= 0) {
            z7 = false;
        } else {
            Rect rect2 = this.f6405h;
            if (rect2.width() <= 0 || rect2.height() <= 0) {
                z7 = false;
            } else {
                z7 = true;
            }
        }
        this.f6393b = z7;
    }

    public final void m4265j(boolean z7) {
        float fMeasureText;
        float f;
        StaticLayout staticLayout;
        ViewGroup viewGroup = this.f6391a;
        if ((viewGroup.getHeight() <= 0 || viewGroup.getWidth() <= 0) && !z7) {
            return;
        }
        m4259c(1.0f, z7);
        CharSequence charSequence = this.f6372H;
        TextPaint textPaint = this.f6384T;
        if (charSequence != null && (staticLayout = this.f6408i0) != null) {
            this.f6416m0 = TextUtils.ellipsize(charSequence, textPaint, staticLayout.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.f6416m0;
        if (charSequence2 != null) {
            this.f6410j0 = textPaint.measureText(charSequence2, 0, charSequence2.length());
        } else {
            this.f6410j0 = 0.0f;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(this.f6413l, this.f6373I ? 1 : 0);
        int i6 = absoluteGravity & 112;
        Rect rect = this.f6407i;
        if (i6 == 48) {
            this.f6426s = rect.top;
        } else if (i6 != 80) {
            this.f6426s = rect.centerY() - ((textPaint.descent() - textPaint.ascent()) / 2.0f);
        } else {
            this.f6426s = textPaint.ascent() + rect.bottom;
        }
        int i10 = absoluteGravity & 8388615;
        if (i10 == 1) {
            this.f6428u = rect.centerX() - (this.f6410j0 / 2.0f);
        } else if (i10 != 5) {
            this.f6428u = rect.left;
        } else {
            this.f6428u = rect.right - this.f6410j0;
        }
        m4259c(0.0f, z7);
        StaticLayout staticLayout2 = this.f6408i0;
        float height = staticLayout2 != null ? staticLayout2.getHeight() : 0.0f;
        StaticLayout staticLayout3 = this.f6408i0;
        if (staticLayout3 == null || this.f6418n0 <= 1) {
            CharSequence charSequence3 = this.f6372H;
            fMeasureText = charSequence3 != null ? textPaint.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        } else {
            fMeasureText = staticLayout3.getWidth();
        }
        StaticLayout staticLayout4 = this.f6408i0;
        this.f6423q = staticLayout4 != null ? staticLayout4.getLineCount() : 0;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f6411k, this.f6373I ? 1 : 0);
        int i11 = absoluteGravity2 & 112;
        Rect rect2 = this.f6405h;
        if (i11 == 48) {
            this.f6425r = rect2.top;
        } else if (i11 != 80) {
            this.f6425r = rect2.centerY() - (height / 2.0f);
        } else {
            this.f6425r = textPaint.descent() + (rect2.bottom - height);
        }
        int i12 = absoluteGravity2 & 8388615;
        if (i12 == 1) {
            this.f6427t = rect2.centerX() - (fMeasureText / 2.0f);
        } else if (i12 != 5) {
            this.f6427t = rect2.left;
        } else {
            this.f6427t = rect2.right - fMeasureText;
        }
        Bitmap bitmap = this.f6375K;
        if (bitmap != null) {
            bitmap.recycle();
            this.f6375K = null;
        }
        m4273r(this.f6395c);
        float f3 = this.f6395c;
        boolean z10 = this.f6397d;
        RectF rectF = this.f6409j;
        if (z10) {
            if (f3 < this.f6401f) {
                rect = rect2;
            }
            rectF.set(rect);
        } else {
            rectF.left = m4257g(rect2.left, rect.left, f3, this.f6386V);
            rectF.top = m4257g(this.f6425r, this.f6426s, f3, this.f6386V);
            rectF.right = m4257g(rect2.right, rect.right, f3, this.f6386V);
            rectF.bottom = m4257g(rect2.bottom, rect.bottom, f3, this.f6386V);
        }
        if (!this.f6397d) {
            this.f6429v = m4257g(this.f6427t, this.f6428u, f3, this.f6386V);
            this.f6430w = m4257g(this.f6425r, this.f6426s, f3, this.f6386V);
            m4273r(f3);
            f = f3;
        } else if (f3 < this.f6401f) {
            this.f6429v = this.f6427t;
            this.f6430w = this.f6425r;
            m4273r(0.0f);
            f = 0.0f;
        } else {
            this.f6429v = this.f6428u;
            this.f6430w = this.f6426s - Math.max(0, this.f6403g);
            m4273r(1.0f);
            f = 1.0f;
        }
        C2592a c2592a = AbstractC4268a.f14470b;
        this.f6412k0 = 1.0f - m4257g(0.0f, 1.0f, 1.0f - f3, c2592a);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        viewGroup.postInvalidateOnAnimation();
        this.f6414l0 = m4257g(1.0f, 0.0f, f3, c2592a);
        viewGroup.postInvalidateOnAnimation();
        ColorStateList colorStateList = this.f6421p;
        ColorStateList colorStateList2 = this.f6419o;
        if (colorStateList != colorStateList2) {
            textPaint.setColor(m4256a(f, m4262f(colorStateList2), m4262f(this.f6421p)));
        } else {
            textPaint.setColor(m4262f(colorStateList));
        }
        float f4 = this.f6402f0;
        float f5 = this.f6404g0;
        if (f4 != f5) {
            textPaint.setLetterSpacing(m4257g(f5, f4, f3, c2592a));
        } else {
            textPaint.setLetterSpacing(f4);
        }
        this.f6378N = AbstractC4268a.m8309a(this.f6394b0, this.f6388X, f3);
        this.f6379O = AbstractC4268a.m8309a(this.f6396c0, this.f6389Y, f3);
        this.f6380P = AbstractC4268a.m8309a(this.f6398d0, this.f6390Z, f3);
        int iM4256a = m4256a(f3, m4262f(this.f6400e0), m4262f(this.f6392a0));
        this.f6381Q = iM4256a;
        textPaint.setShadowLayer(this.f6378N, this.f6379O, this.f6380P, iM4256a);
        if (this.f6397d) {
            int alpha = textPaint.getAlpha();
            float f10 = this.f6401f;
            textPaint.setAlpha((int) ((f3 <= f10 ? AbstractC4268a.m8310b(1.0f, 0.0f, this.f6399e, f10, f3) : AbstractC4268a.m8310b(0.0f, 1.0f, f10, 1.0f, f3)) * alpha));
        }
        viewGroup.postInvalidateOnAnimation();
    }

    public final void m4266k(int i6) {
        ViewGroup viewGroup = this.f6391a;
        C3639d c3639d = new C3639d(viewGroup.getContext(), i6);
        ColorStateList colorStateList = c3639d.f12222j;
        if (colorStateList != null) {
            this.f6421p = colorStateList;
        }
        float f = c3639d.f12223k;
        if (f != 0.0f) {
            this.f6417n = f;
        }
        ColorStateList colorStateList2 = c3639d.f12213a;
        if (colorStateList2 != null) {
            this.f6392a0 = colorStateList2;
        }
        this.f6389Y = c3639d.f12217e;
        this.f6390Z = c3639d.f12218f;
        this.f6388X = c3639d.f12219g;
        this.f6402f0 = c3639d.f12221i;
        C3636a c3636a = this.f6370F;
        if (c3636a != null) {
            c3636a.f12206t = true;
        }
        C1814c c1814c = new C1814c(this, 0);
        c3639d.m7363a();
        this.f6370F = new C3636a(c1814c, c3639d.f12226n);
        c3639d.m7365c(viewGroup.getContext(), this.f6370F);
        m4265j(false);
    }

    public final void m4267l(ColorStateList colorStateList) {
        if (this.f6421p != colorStateList) {
            this.f6421p = colorStateList;
            m4265j(false);
        }
    }

    public final void m4268m(int i6) {
        if (this.f6413l != i6) {
            this.f6413l = i6;
            m4265j(false);
        }
    }

    public final boolean m4269n(Typeface typeface) {
        C3636a c3636a = this.f6370F;
        if (c3636a != null) {
            c3636a.f12206t = true;
        }
        if (this.f6433z == typeface) {
            return false;
        }
        this.f6433z = typeface;
        Typeface typefaceM6428C = AbstractC3198d.m6428C(this.f6391a.getContext().getResources().getConfiguration(), typeface);
        this.f6432y = typefaceM6428C;
        if (typefaceM6428C == null) {
            typefaceM6428C = this.f6433z;
        }
        this.f6431x = typefaceM6428C;
        return true;
    }

    public final void m4270o(int i6) {
        ViewGroup viewGroup = this.f6391a;
        C3639d c3639d = new C3639d(viewGroup.getContext(), i6);
        ColorStateList colorStateList = c3639d.f12222j;
        if (colorStateList != null) {
            this.f6419o = colorStateList;
        }
        float f = c3639d.f12223k;
        if (f != 0.0f) {
            this.f6415m = f;
        }
        ColorStateList colorStateList2 = c3639d.f12213a;
        if (colorStateList2 != null) {
            this.f6400e0 = colorStateList2;
        }
        this.f6396c0 = c3639d.f12217e;
        this.f6398d0 = c3639d.f12218f;
        this.f6394b0 = c3639d.f12219g;
        this.f6404g0 = c3639d.f12221i;
        C3636a c3636a = this.f6369E;
        if (c3636a != null) {
            c3636a.f12206t = true;
        }
        C1814c c1814c = new C1814c(this, 1);
        c3639d.m7363a();
        this.f6369E = new C3636a(c1814c, c3639d.f12226n);
        c3639d.m7365c(viewGroup.getContext(), this.f6369E);
        m4265j(false);
    }

    public final boolean m4271p(Typeface typeface) {
        C3636a c3636a = this.f6369E;
        if (c3636a != null) {
            c3636a.f12206t = true;
        }
        if (this.f6367C == typeface) {
            return false;
        }
        this.f6367C = typeface;
        Typeface typefaceM6428C = AbstractC3198d.m6428C(this.f6391a.getContext().getResources().getConfiguration(), typeface);
        this.f6366B = typefaceM6428C;
        if (typefaceM6428C == null) {
            typefaceM6428C = this.f6367C;
        }
        this.f6365A = typefaceM6428C;
        return true;
    }

    public final void m4272q(float f) {
        float f3;
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (f != this.f6395c) {
            this.f6395c = f;
            boolean z7 = this.f6397d;
            RectF rectF = this.f6409j;
            Rect rect = this.f6407i;
            Rect rect2 = this.f6405h;
            if (z7) {
                if (f < this.f6401f) {
                    rect = rect2;
                }
                rectF.set(rect);
            } else {
                rectF.left = m4257g(rect2.left, rect.left, f, this.f6386V);
                rectF.top = m4257g(this.f6425r, this.f6426s, f, this.f6386V);
                rectF.right = m4257g(rect2.right, rect.right, f, this.f6386V);
                rectF.bottom = m4257g(rect2.bottom, rect.bottom, f, this.f6386V);
            }
            if (!this.f6397d) {
                this.f6429v = m4257g(this.f6427t, this.f6428u, f, this.f6386V);
                this.f6430w = m4257g(this.f6425r, this.f6426s, f, this.f6386V);
                m4273r(f);
                f3 = f;
            } else if (f < this.f6401f) {
                this.f6429v = this.f6427t;
                this.f6430w = this.f6425r;
                m4273r(0.0f);
                f3 = 0.0f;
            } else {
                this.f6429v = this.f6428u;
                this.f6430w = this.f6426s - Math.max(0, this.f6403g);
                m4273r(1.0f);
                f3 = 1.0f;
            }
            C2592a c2592a = AbstractC4268a.f14470b;
            this.f6412k0 = 1.0f - m4257g(0.0f, 1.0f, 1.0f - f, c2592a);
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            ViewGroup viewGroup = this.f6391a;
            viewGroup.postInvalidateOnAnimation();
            this.f6414l0 = m4257g(1.0f, 0.0f, f, c2592a);
            viewGroup.postInvalidateOnAnimation();
            ColorStateList colorStateList = this.f6421p;
            ColorStateList colorStateList2 = this.f6419o;
            TextPaint textPaint = this.f6384T;
            if (colorStateList != colorStateList2) {
                textPaint.setColor(m4256a(f3, m4262f(colorStateList2), m4262f(this.f6421p)));
            } else {
                textPaint.setColor(m4262f(colorStateList));
            }
            float f4 = this.f6402f0;
            float f5 = this.f6404g0;
            if (f4 != f5) {
                textPaint.setLetterSpacing(m4257g(f5, f4, f, c2592a));
            } else {
                textPaint.setLetterSpacing(f4);
            }
            this.f6378N = AbstractC4268a.m8309a(this.f6394b0, this.f6388X, f);
            this.f6379O = AbstractC4268a.m8309a(this.f6396c0, this.f6389Y, f);
            this.f6380P = AbstractC4268a.m8309a(this.f6398d0, this.f6390Z, f);
            int iM4256a = m4256a(f, m4262f(this.f6400e0), m4262f(this.f6392a0));
            this.f6381Q = iM4256a;
            textPaint.setShadowLayer(this.f6378N, this.f6379O, this.f6380P, iM4256a);
            if (this.f6397d) {
                int alpha = textPaint.getAlpha();
                float f10 = this.f6401f;
                textPaint.setAlpha((int) ((f <= f10 ? AbstractC4268a.m8310b(1.0f, 0.0f, this.f6399e, f10, f) : AbstractC4268a.m8310b(0.0f, 1.0f, f10, 1.0f, f)) * alpha));
            }
            viewGroup.postInvalidateOnAnimation();
        }
    }

    public final void m4273r(float f) {
        m4259c(f, false);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        this.f6391a.postInvalidateOnAnimation();
    }
}

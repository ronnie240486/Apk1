package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.reflect.Constructor;

public final class C1835u {

    public static final int f6476m;

    public static boolean f6477n;

    public static Constructor f6478o;

    public static TextDirectionHeuristic f6479p;

    public CharSequence f6480a;

    public final TextPaint f6481b;

    public final int f6482c;

    public int f6483d;

    public boolean f6490k;

    public Layout.Alignment f6484e = Layout.Alignment.ALIGN_NORMAL;

    public int f6485f = Integer.MAX_VALUE;

    public float f6486g = 0.0f;

    public float f6487h = 1.0f;

    public int f6488i = f6476m;

    public boolean f6489j = true;

    public TextUtils.TruncateAt f6491l = null;

    static {
        f6476m = Build.VERSION.SDK_INT >= 23 ? 1 : 0;
    }

    public C1835u(CharSequence charSequence, TextPaint textPaint, int i6) {
        this.f6480a = charSequence;
        this.f6481b = textPaint;
        this.f6482c = i6;
        this.f6483d = charSequence.length();
    }

    public final StaticLayout m4280a() throws C1834t {
        if (this.f6480a == null) {
            this.f6480a = "";
        }
        int iMax = Math.max(0, this.f6482c);
        CharSequence charSequenceEllipsize = this.f6480a;
        int i6 = this.f6485f;
        TextPaint textPaint = this.f6481b;
        if (i6 == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint, iMax, this.f6491l);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f6483d);
        this.f6483d = iMin;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 23) {
            if (this.f6490k && this.f6485f == 1) {
                this.f6484e = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, 0, iMin, textPaint, iMax);
            builderObtain.setAlignment(this.f6484e);
            builderObtain.setIncludePad(this.f6489j);
            builderObtain.setTextDirection(this.f6490k ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            TextUtils.TruncateAt truncateAt = this.f6491l;
            if (truncateAt != null) {
                builderObtain.setEllipsize(truncateAt);
            }
            builderObtain.setMaxLines(this.f6485f);
            float f = this.f6486g;
            if (f != 0.0f || this.f6487h != 1.0f) {
                builderObtain.setLineSpacing(f, this.f6487h);
            }
            if (this.f6485f > 1) {
                builderObtain.setHyphenationFrequency(this.f6488i);
            }
            return builderObtain.build();
        }
        if (!f6477n) {
            try {
                f6479p = this.f6490k && i10 >= 23 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
                Class cls = Integer.TYPE;
                Class cls2 = Float.TYPE;
                Constructor declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls);
                f6478o = declaredConstructor;
                declaredConstructor.setAccessible(true);
                f6477n = true;
            } catch (Exception e5) {
                throw new C1834t(e5);
            }
        }
        try {
            Constructor constructor = f6478o;
            constructor.getClass();
            Integer numValueOf = Integer.valueOf(this.f6483d);
            Integer numValueOf2 = Integer.valueOf(iMax);
            Layout.Alignment alignment = this.f6484e;
            TextDirectionHeuristic textDirectionHeuristic = f6479p;
            textDirectionHeuristic.getClass();
            return (StaticLayout) constructor.newInstance(charSequenceEllipsize, 0, numValueOf, textPaint, numValueOf2, alignment, textDirectionHeuristic, Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f6489j), null, Integer.valueOf(iMax), Integer.valueOf(this.f6485f));
        } catch (Exception e10) {
            throw new C1834t(e10);
        }
    }
}

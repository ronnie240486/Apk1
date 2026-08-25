package p189r6;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import android.util.TypedValue;
import com.bumptech.glide.AbstractC1466d;
import p046e0.AbstractC2355n;
import p123l5.AbstractC2973a;
import p143n5.AbstractC3198d;
import p250x5.AbstractC4121a;

public final class C3639d {

    public final ColorStateList f12213a;

    public final String f12214b;

    public final int f12215c;

    public final int f12216d;

    public final float f12217e;

    public final float f12218f;

    public final float f12219g;

    public final boolean f12220h;

    public final float f12221i;

    public ColorStateList f12222j;

    public float f12223k;

    public final int f12224l;

    public boolean f12225m = false;

    public Typeface f12226n;

    public C3639d(Context context, int i6) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i6, AbstractC4121a.f13982Z);
        this.f12223k = typedArrayObtainStyledAttributes.getDimension(0, 0.0f);
        this.f12222j = AbstractC1466d.m3493k(context, typedArrayObtainStyledAttributes, 3);
        AbstractC1466d.m3493k(context, typedArrayObtainStyledAttributes, 4);
        AbstractC1466d.m3493k(context, typedArrayObtainStyledAttributes, 5);
        this.f12215c = typedArrayObtainStyledAttributes.getInt(2, 0);
        this.f12216d = typedArrayObtainStyledAttributes.getInt(1, 1);
        int i10 = typedArrayObtainStyledAttributes.hasValue(12) ? 12 : 10;
        this.f12224l = typedArrayObtainStyledAttributes.getResourceId(i10, 0);
        this.f12214b = typedArrayObtainStyledAttributes.getString(i10);
        typedArrayObtainStyledAttributes.getBoolean(14, false);
        this.f12213a = AbstractC1466d.m3493k(context, typedArrayObtainStyledAttributes, 6);
        this.f12217e = typedArrayObtainStyledAttributes.getFloat(7, 0.0f);
        this.f12218f = typedArrayObtainStyledAttributes.getFloat(8, 0.0f);
        this.f12219g = typedArrayObtainStyledAttributes.getFloat(9, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i6, AbstractC4121a.f13964H);
        this.f12220h = typedArrayObtainStyledAttributes2.hasValue(0);
        this.f12221i = typedArrayObtainStyledAttributes2.getFloat(0, 0.0f);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final void m7363a() {
        String str;
        Typeface typeface = this.f12226n;
        int i6 = this.f12215c;
        if (typeface == null && (str = this.f12214b) != null) {
            this.f12226n = Typeface.create(str, i6);
        }
        if (this.f12226n == null) {
            int i10 = this.f12216d;
            if (i10 == 1) {
                this.f12226n = Typeface.SANS_SERIF;
            } else if (i10 == 2) {
                this.f12226n = Typeface.SERIF;
            } else if (i10 != 3) {
                this.f12226n = Typeface.DEFAULT;
            } else {
                this.f12226n = Typeface.MONOSPACE;
            }
            this.f12226n = Typeface.create(this.f12226n, i6);
        }
    }

    public final Typeface m7364b(Context context) {
        if (this.f12225m) {
            return this.f12226n;
        }
        if (!context.isRestricted()) {
            try {
                Typeface typefaceM5338b = AbstractC2355n.m5338b(context, this.f12224l);
                this.f12226n = typefaceM5338b;
                if (typefaceM5338b != null) {
                    this.f12226n = Typeface.create(typefaceM5338b, this.f12215c);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e5) {
                Log.d("TextAppearance", "Error loading font " + this.f12214b, e5);
            }
        }
        m7363a();
        this.f12225m = true;
        return this.f12226n;
    }

    public final void m7365c(Context context, AbstractC2973a abstractC2973a) {
        if (m7366d(context)) {
            m7364b(context);
        } else {
            m7363a();
        }
        int i6 = this.f12224l;
        if (i6 == 0) {
            this.f12225m = true;
        }
        if (this.f12225m) {
            abstractC2973a.mo4283E(this.f12226n, true);
            return;
        }
        try {
            C3637b c3637b = new C3637b(this, abstractC2973a);
            ThreadLocal threadLocal = AbstractC2355n.f8209a;
            if (context.isRestricted()) {
                c3637b.m5328a(-4);
            } else {
                AbstractC2355n.m5339c(context, i6, new TypedValue(), 0, c3637b, false, false);
            }
        } catch (Resources.NotFoundException unused) {
            this.f12225m = true;
            abstractC2973a.mo4282D(1);
        } catch (Exception e5) {
            Log.d("TextAppearance", "Error loading font " + this.f12214b, e5);
            this.f12225m = true;
            abstractC2973a.mo4282D(-3);
        }
    }

    public final boolean m7366d(Context context) {
        Typeface typefaceM5339c = null;
        int i6 = this.f12224l;
        if (i6 != 0) {
            ThreadLocal threadLocal = AbstractC2355n.f8209a;
            if (!context.isRestricted()) {
                typefaceM5339c = AbstractC2355n.m5339c(context, i6, new TypedValue(), 0, null, false, true);
            }
        }
        return typefaceM5339c != null;
    }

    public final void m7367e(Context context, TextPaint textPaint, AbstractC2973a abstractC2973a) {
        m7368f(context, textPaint, abstractC2973a);
        ColorStateList colorStateList = this.f12222j;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        ColorStateList colorStateList2 = this.f12213a;
        textPaint.setShadowLayer(this.f12219g, this.f12217e, this.f12218f, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public final void m7368f(Context context, TextPaint textPaint, AbstractC2973a abstractC2973a) {
        if (m7366d(context)) {
            m7369g(context, textPaint, m7364b(context));
            return;
        }
        m7363a();
        m7369g(context, textPaint, this.f12226n);
        m7365c(context, new C3638c(this, context, textPaint, abstractC2973a));
    }

    public final void m7369g(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceM6428C = AbstractC3198d.m6428C(context.getResources().getConfiguration(), typeface);
        if (typefaceM6428C != null) {
            typeface = typefaceM6428C;
        }
        textPaint.setTypeface(typeface);
        int i6 = (~typeface.getStyle()) & this.f12215c;
        textPaint.setFakeBoldText((i6 & 1) != 0);
        textPaint.setTextSkewX((i6 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f12223k);
        if (this.f12220h) {
            textPaint.setLetterSpacing(this.f12221i);
        }
    }
}

package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.core.widget.AbstractC0381n;
import androidx.core.widget.InterfaceC0386s;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import p000a.AbstractC0004e;
import p002a1.C0026b;
import p003a2.AbstractC0032a;
import p045e.AbstractC2341a;
import p138n0.AbstractC3155s0;
import p143n5.AbstractC3198d;
import p195s0.AbstractC3685b;
import p195s0.AbstractC3686c;
import p222u7.AbstractC3928d;

public final class C0291x0 {

    public final TextView f1119a;

    public C0234l3 f1120b;

    public C0234l3 f1121c;

    public C0234l3 f1122d;

    public C0234l3 f1123e;

    public C0234l3 f1124f;

    public C0234l3 f1125g;

    public C0234l3 f1126h;

    public final C0207g1 f1127i;

    public int f1128j = 0;

    public int f1129k = -1;

    public Typeface f1130l;

    public boolean f1131m;

    public C0291x0(TextView textView) {
        this.f1119a = textView;
        this.f1127i = new C0207g1(textView);
    }

    public static C0234l3 m813c(Context context, C0285w c0285w, int i6) {
        ColorStateList colorStateListM729i;
        synchronized (c0285w) {
            colorStateListM729i = c0285w.f1115a.m729i(context, i6);
        }
        if (colorStateListM729i == null) {
            return null;
        }
        C0234l3 c0234l3 = new C0234l3();
        c0234l3.f1002d = true;
        c0234l3.f999a = colorStateListM729i;
        return c0234l3;
    }

    public static void m814h(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 30 || inputConnection == null) {
            return;
        }
        CharSequence text = textView.getText();
        if (i6 >= 30) {
            AbstractC3685b.m7440a(editorInfo, text);
            return;
        }
        text.getClass();
        if (i6 >= 30) {
            AbstractC3685b.m7440a(editorInfo, text);
            return;
        }
        int i10 = editorInfo.initialSelStart;
        int i11 = editorInfo.initialSelEnd;
        int i12 = i10 > i11 ? i11 : i10;
        if (i10 <= i11) {
            i10 = i11;
        }
        int length = text.length();
        if (i12 < 0 || i10 > length) {
            AbstractC3686c.m7441a(editorInfo, null, 0, 0);
            return;
        }
        int i13 = editorInfo.inputType & 4095;
        if (i13 == 129 || i13 == 225 || i13 == 18) {
            AbstractC3686c.m7441a(editorInfo, null, 0, 0);
            return;
        }
        if (length <= 2048) {
            AbstractC3686c.m7441a(editorInfo, text, i12, i10);
            return;
        }
        int i14 = i10 - i12;
        int i15 = i14 > 1024 ? 0 : i14;
        int i16 = 2048 - i15;
        int iMin = Math.min(text.length() - i10, i16 - Math.min(i12, (int) (((double) i16) * 0.8d)));
        int iMin2 = Math.min(i12, i16 - iMin);
        int i17 = i12 - iMin2;
        if (Character.isLowSurrogate(text.charAt(i17))) {
            i17++;
            iMin2--;
        }
        if (Character.isHighSurrogate(text.charAt((i10 + iMin) - 1))) {
            iMin--;
        }
        int i18 = iMin2 + i15;
        AbstractC3686c.m7441a(editorInfo, i15 != i14 ? TextUtils.concat(text.subSequence(i17, i17 + iMin2), text.subSequence(i10, iMin + i10)) : text.subSequence(i17, i18 + iMin + i17), iMin2, i18);
    }

    public final void m815a(Drawable drawable, C0234l3 c0234l3) {
        if (drawable == null || c0234l3 == null) {
            return;
        }
        C0285w.m804e(drawable, c0234l3, this.f1119a.getDrawableState());
    }

    public final void m816b() {
        C0234l3 c0234l3 = this.f1120b;
        TextView textView = this.f1119a;
        if (c0234l3 != null || this.f1121c != null || this.f1122d != null || this.f1123e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            m815a(compoundDrawables[0], this.f1120b);
            m815a(compoundDrawables[1], this.f1121c);
            m815a(compoundDrawables[2], this.f1122d);
            m815a(compoundDrawables[3], this.f1123e);
        }
        if (this.f1124f == null && this.f1125g == null) {
            return;
        }
        Drawable[] drawableArrM766a = AbstractC0266s0.m766a(textView);
        m815a(drawableArrM766a[0], this.f1124f);
        m815a(drawableArrM766a[2], this.f1125g);
    }

    public final ColorStateList m817d() {
        C0234l3 c0234l3 = this.f1126h;
        if (c0234l3 != null) {
            return c0234l3.f999a;
        }
        return null;
    }

    public final PorterDuff.Mode m818e() {
        C0234l3 c0234l3 = this.f1126h;
        if (c0234l3 != null) {
            return c0234l3.f1000b;
        }
        return null;
    }

    public final void m819f(AttributeSet attributeSet, int i6) {
        String string;
        String string2;
        boolean z7;
        boolean z10;
        ColorStateList colorStateListM139s;
        ColorStateList colorStateListM139s2;
        ColorStateList colorStateListM139s3;
        boolean z11;
        C0285w c0285w;
        int i10;
        Paint.FontMetricsInt fontMetricsInt;
        ColorStateList colorStateList;
        int resourceId;
        int i11;
        int resourceId2;
        int i12;
        int i13;
        int i14;
        TextView textView = this.f1119a;
        Context context = textView.getContext();
        C0285w c0285wM801a = C0285w.m801a();
        int[] iArr = AbstractC2341a.f8161i;
        C0026b c0026bM111C = C0026b.m111C(context, attributeSet, iArr, i6);
        AbstractC3155s0.m6346p(textView, textView.getContext(), iArr, attributeSet, (TypedArray) c0026bM111C.f55c, i6, 0);
        TypedArray typedArray = (TypedArray) c0026bM111C.f55c;
        int resourceId3 = typedArray.getResourceId(0, -1);
        if (typedArray.hasValue(3)) {
            this.f1120b = m813c(context, c0285wM801a, typedArray.getResourceId(3, 0));
        }
        if (typedArray.hasValue(1)) {
            this.f1121c = m813c(context, c0285wM801a, typedArray.getResourceId(1, 0));
        }
        if (typedArray.hasValue(4)) {
            this.f1122d = m813c(context, c0285wM801a, typedArray.getResourceId(4, 0));
        }
        if (typedArray.hasValue(2)) {
            this.f1123e = m813c(context, c0285wM801a, typedArray.getResourceId(2, 0));
        }
        int i15 = Build.VERSION.SDK_INT;
        if (typedArray.hasValue(5)) {
            this.f1124f = m813c(context, c0285wM801a, typedArray.getResourceId(5, 0));
        }
        if (typedArray.hasValue(6)) {
            this.f1125g = m813c(context, c0285wM801a, typedArray.getResourceId(6, 0));
        }
        c0026bM111C.m120F();
        boolean z12 = textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        int[] iArr2 = AbstractC2341a.f8177y;
        if (resourceId3 != -1) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(resourceId3, iArr2);
            C0026b c0026b = new C0026b(context, typedArrayObtainStyledAttributes);
            if (z12 || !typedArrayObtainStyledAttributes.hasValue(14)) {
                z7 = false;
                z10 = false;
            } else {
                z7 = typedArrayObtainStyledAttributes.getBoolean(14, false);
                z10 = true;
            }
            m826n(context, c0026b);
            if (i15 < 23) {
                if (typedArrayObtainStyledAttributes.hasValue(3)) {
                    colorStateListM139s = c0026b.m139s(3);
                    i13 = 4;
                } else {
                    i13 = 4;
                    colorStateListM139s = null;
                }
                if (typedArrayObtainStyledAttributes.hasValue(i13)) {
                    colorStateListM139s2 = c0026b.m139s(i13);
                    i14 = 5;
                } else {
                    i14 = 5;
                    colorStateListM139s2 = null;
                }
                colorStateListM139s3 = typedArrayObtainStyledAttributes.hasValue(i14) ? c0026b.m139s(i14) : null;
                if (typedArrayObtainStyledAttributes.hasValue(15)) {
                    string2 = typedArrayObtainStyledAttributes.getString(15);
                    i12 = 26;
                } else {
                    i12 = 26;
                    string2 = null;
                }
                if (i15 >= i12 || !typedArrayObtainStyledAttributes.hasValue(13)) {
                    string = null;
                } else {
                    string = typedArrayObtainStyledAttributes.getString(13);
                }
                c0026b.m120F();
            } else {
                colorStateListM139s = null;
                colorStateListM139s2 = null;
            }
            if (typedArrayObtainStyledAttributes.hasValue(15)) {
                string2 = typedArrayObtainStyledAttributes.getString(15);
                i12 = 26;
            } else {
                i12 = 26;
                string2 = null;
            }
            if (i15 >= i12) {
                string = null;
            } else {
                string = null;
            }
            c0026b.m120F();
        } else {
            string = null;
            string2 = null;
            z7 = false;
            z10 = false;
            colorStateListM139s = null;
            colorStateListM139s2 = null;
            colorStateListM139s3 = null;
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i6, 0);
        C0026b c0026b2 = new C0026b(context, typedArrayObtainStyledAttributes2);
        if (z12 || !typedArrayObtainStyledAttributes2.hasValue(14)) {
            z11 = z7;
        } else {
            z11 = typedArrayObtainStyledAttributes2.getBoolean(14, false);
            z10 = true;
        }
        if (i15 < 23) {
            if (typedArrayObtainStyledAttributes2.hasValue(3)) {
                colorStateListM139s = c0026b2.m139s(3);
            }
            if (typedArrayObtainStyledAttributes2.hasValue(4)) {
                colorStateListM139s2 = c0026b2.m139s(4);
            }
            if (typedArrayObtainStyledAttributes2.hasValue(5)) {
                colorStateListM139s3 = c0026b2.m139s(5);
            }
        }
        ColorStateList colorStateList2 = colorStateListM139s;
        ColorStateList colorStateList3 = colorStateListM139s2;
        ColorStateList colorStateList4 = colorStateListM139s3;
        if (typedArrayObtainStyledAttributes2.hasValue(15)) {
            string2 = typedArrayObtainStyledAttributes2.getString(15);
        }
        if (i15 >= 26 && typedArrayObtainStyledAttributes2.hasValue(13)) {
            string = typedArrayObtainStyledAttributes2.getString(13);
        }
        if (i15 < 28 || !typedArrayObtainStyledAttributes2.hasValue(0)) {
            c0285w = c0285wM801a;
        } else {
            c0285w = c0285wM801a;
            if (typedArrayObtainStyledAttributes2.getDimensionPixelSize(0, -1) == 0) {
                textView.setTextSize(0, 0.0f);
            }
        }
        m826n(context, c0026b2);
        c0026b2.m120F();
        if (colorStateList2 != null) {
            textView.setTextColor(colorStateList2);
        }
        if (colorStateList3 != null) {
            textView.setHintTextColor(colorStateList3);
        }
        if (colorStateList4 != null) {
            textView.setLinkTextColor(colorStateList4);
        }
        if (!z12 && z10) {
            textView.setAllCaps(z11);
        }
        Typeface typeface = this.f1130l;
        if (typeface != null) {
            if (this.f1129k == -1) {
                textView.setTypeface(typeface, this.f1128j);
            } else {
                textView.setTypeface(typeface);
            }
        }
        if (string != null) {
            AbstractC0281v0.m795d(textView, string);
        }
        if (string2 == null) {
            i10 = 0;
        } else if (i15 >= 24) {
            AbstractC0276u0.m784b(textView, AbstractC0276u0.m783a(string2));
            i10 = 0;
        } else {
            i10 = 0;
            AbstractC0266s0.m768c(textView, AbstractC0271t0.m771a(string2.split(",")[0]));
        }
        int[] iArr3 = AbstractC2341a.f8162j;
        C0207g1 c0207g1 = this.f1127i;
        Context context2 = c0207g1.f934j;
        TypedArray typedArrayObtainStyledAttributes3 = context2.obtainStyledAttributes(attributeSet, iArr3, i6, i10);
        TextView textView2 = c0207g1.f933i;
        AbstractC3155s0.m6346p(textView2, textView2.getContext(), iArr3, attributeSet, typedArrayObtainStyledAttributes3, i6, 0);
        if (typedArrayObtainStyledAttributes3.hasValue(5)) {
            c0207g1.f925a = typedArrayObtainStyledAttributes3.getInt(5, 0);
        }
        float dimension = typedArrayObtainStyledAttributes3.hasValue(4) ? typedArrayObtainStyledAttributes3.getDimension(4, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes3.hasValue(2) ? typedArrayObtainStyledAttributes3.getDimension(2, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes3.hasValue(1) ? typedArrayObtainStyledAttributes3.getDimension(1, -1.0f) : -1.0f;
        if (typedArrayObtainStyledAttributes3.hasValue(3) && (resourceId2 = typedArrayObtainStyledAttributes3.getResourceId(3, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes3.getResources().obtainTypedArray(resourceId2);
            int length = typedArrayObtainTypedArray.length();
            int[] iArr4 = new int[length];
            if (length > 0) {
                for (int i16 = 0; i16 < length; i16++) {
                    iArr4[i16] = typedArrayObtainTypedArray.getDimensionPixelSize(i16, -1);
                }
                c0207g1.f930f = C0207g1.m674b(iArr4);
                c0207g1.m682i();
            }
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes3.recycle();
        if (!c0207g1.m683j()) {
            c0207g1.f925a = 0;
        } else if (c0207g1.f925a == 1) {
            if (!c0207g1.f931g) {
                DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    i11 = 2;
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                } else {
                    i11 = 2;
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(i11, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                c0207g1.m684k(dimension2, dimension3, dimension);
            }
            c0207g1.m681h();
        }
        if (AbstractC0189c4.f881b && c0207g1.f925a != 0) {
            int[] iArr5 = c0207g1.f930f;
            if (iArr5.length > 0) {
                if (AbstractC0281v0.m792a(textView) != -1.0f) {
                    AbstractC0281v0.m793b(textView, Math.round(c0207g1.f928d), Math.round(c0207g1.f929e), Math.round(c0207g1.f927c), 0);
                } else {
                    AbstractC0281v0.m794c(textView, iArr5, 0);
                }
            }
        }
        TypedArray typedArrayObtainStyledAttributes4 = context.obtainStyledAttributes(attributeSet, iArr3);
        int resourceId4 = typedArrayObtainStyledAttributes4.getResourceId(8, -1);
        C0285w c0285w2 = c0285w;
        Drawable drawableM805b = resourceId4 != -1 ? c0285w2.m805b(context, resourceId4) : null;
        int resourceId5 = typedArrayObtainStyledAttributes4.getResourceId(13, -1);
        Drawable drawableM805b2 = resourceId5 != -1 ? c0285w2.m805b(context, resourceId5) : null;
        int resourceId6 = typedArrayObtainStyledAttributes4.getResourceId(9, -1);
        Drawable drawableM805b3 = resourceId6 != -1 ? c0285w2.m805b(context, resourceId6) : null;
        int resourceId7 = typedArrayObtainStyledAttributes4.getResourceId(6, -1);
        Drawable drawableM805b4 = resourceId7 != -1 ? c0285w2.m805b(context, resourceId7) : null;
        int resourceId8 = typedArrayObtainStyledAttributes4.getResourceId(10, -1);
        Drawable drawableM805b5 = resourceId8 != -1 ? c0285w2.m805b(context, resourceId8) : null;
        int resourceId9 = typedArrayObtainStyledAttributes4.getResourceId(7, -1);
        Drawable drawableM805b6 = resourceId9 != -1 ? c0285w2.m805b(context, resourceId9) : null;
        if (drawableM805b5 != null || drawableM805b6 != null) {
            Drawable[] drawableArrM766a = AbstractC0266s0.m766a(textView);
            if (drawableM805b5 == null) {
                drawableM805b5 = drawableArrM766a[0];
            }
            if (drawableM805b2 == null) {
                drawableM805b2 = drawableArrM766a[1];
            }
            if (drawableM805b6 == null) {
                drawableM805b6 = drawableArrM766a[2];
            }
            if (drawableM805b4 == null) {
                drawableM805b4 = drawableArrM766a[3];
            }
            AbstractC0266s0.m767b(textView, drawableM805b5, drawableM805b2, drawableM805b6, drawableM805b4);
        } else if (drawableM805b != null || drawableM805b2 != null || drawableM805b3 != null || drawableM805b4 != null) {
            Drawable[] drawableArrM766a2 = AbstractC0266s0.m766a(textView);
            Drawable drawable = drawableArrM766a2[0];
            if (drawable == null && drawableArrM766a2[2] == null) {
                Drawable[] compoundDrawables = textView.getCompoundDrawables();
                if (drawableM805b == null) {
                    drawableM805b = compoundDrawables[0];
                }
                if (drawableM805b2 == null) {
                    drawableM805b2 = compoundDrawables[1];
                }
                if (drawableM805b3 == null) {
                    drawableM805b3 = compoundDrawables[2];
                }
                if (drawableM805b4 == null) {
                    drawableM805b4 = compoundDrawables[3];
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(drawableM805b, drawableM805b2, drawableM805b3, drawableM805b4);
            } else {
                if (drawableM805b2 == null) {
                    drawableM805b2 = drawableArrM766a2[1];
                }
                Drawable drawable2 = drawableArrM766a2[2];
                if (drawableM805b4 == null) {
                    drawableM805b4 = drawableArrM766a2[3];
                }
                AbstractC0266s0.m767b(textView, drawable, drawableM805b2, drawable2, drawableM805b4);
            }
        }
        if (typedArrayObtainStyledAttributes4.hasValue(11)) {
            if (!typedArrayObtainStyledAttributes4.hasValue(11) || (resourceId = typedArrayObtainStyledAttributes4.getResourceId(11, 0)) == 0 || (colorStateList = AbstractC3928d.m7848k(context, resourceId)) == null) {
                colorStateList = typedArrayObtainStyledAttributes4.getColorStateList(11);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                AbstractC0381n.m1149f(textView, colorStateList);
            } else if (textView instanceof InterfaceC0386s) {
                ((InterfaceC0386s) textView).setSupportCompoundDrawablesTintList(colorStateList);
            }
        }
        if (typedArrayObtainStyledAttributes4.hasValue(12)) {
            fontMetricsInt = null;
            PorterDuff.Mode modeM737c = AbstractC0237m1.m737c(typedArrayObtainStyledAttributes4.getInt(12, -1), null);
            if (Build.VERSION.SDK_INT >= 24) {
                AbstractC0381n.m1150g(textView, modeM737c);
            } else if (textView instanceof InterfaceC0386s) {
                ((InterfaceC0386s) textView).setSupportCompoundDrawablesTintMode(modeM737c);
            }
        } else {
            fontMetricsInt = null;
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes4.getDimensionPixelSize(15, -1);
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes4.getDimensionPixelSize(18, -1);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes4.getDimensionPixelSize(19, -1);
        typedArrayObtainStyledAttributes4.recycle();
        if (dimensionPixelSize != -1) {
            AbstractC3198d.m6440O(textView, dimensionPixelSize);
        }
        if (dimensionPixelSize2 != -1) {
            AbstractC3198d.m6441P(textView, dimensionPixelSize2);
        }
        if (dimensionPixelSize3 != -1) {
            AbstractC0032a.m161o(dimensionPixelSize3);
            int fontMetricsInt2 = textView.getPaint().getFontMetricsInt(fontMetricsInt);
            if (dimensionPixelSize3 != fontMetricsInt2) {
                textView.setLineSpacing(dimensionPixelSize3 - fontMetricsInt2, 1.0f);
            }
        }
    }

    public final void m820g(Context context, int i6) {
        String string;
        ColorStateList colorStateListM139s;
        ColorStateList colorStateListM139s2;
        ColorStateList colorStateListM139s3;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i6, AbstractC2341a.f8177y);
        C0026b c0026b = new C0026b(context, typedArrayObtainStyledAttributes);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(14);
        TextView textView = this.f1119a;
        if (zHasValue) {
            textView.setAllCaps(typedArrayObtainStyledAttributes.getBoolean(14, false));
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 23) {
            if (typedArrayObtainStyledAttributes.hasValue(3) && (colorStateListM139s3 = c0026b.m139s(3)) != null) {
                textView.setTextColor(colorStateListM139s3);
            }
            if (typedArrayObtainStyledAttributes.hasValue(5) && (colorStateListM139s2 = c0026b.m139s(5)) != null) {
                textView.setLinkTextColor(colorStateListM139s2);
            }
            if (typedArrayObtainStyledAttributes.hasValue(4) && (colorStateListM139s = c0026b.m139s(4)) != null) {
                textView.setHintTextColor(colorStateListM139s);
            }
        }
        if (typedArrayObtainStyledAttributes.hasValue(0) && typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        m826n(context, c0026b);
        if (i10 >= 26 && typedArrayObtainStyledAttributes.hasValue(13) && (string = typedArrayObtainStyledAttributes.getString(13)) != null) {
            AbstractC0281v0.m795d(textView, string);
        }
        c0026b.m120F();
        Typeface typeface = this.f1130l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.f1128j);
        }
    }

    public final void m821i(int i6, int i10, int i11, int i12) {
        C0207g1 c0207g1 = this.f1127i;
        if (c0207g1.m683j()) {
            DisplayMetrics displayMetrics = c0207g1.f934j.getResources().getDisplayMetrics();
            c0207g1.m684k(TypedValue.applyDimension(i12, i6, displayMetrics), TypedValue.applyDimension(i12, i10, displayMetrics), TypedValue.applyDimension(i12, i11, displayMetrics));
            if (c0207g1.m681h()) {
                c0207g1.m677a();
            }
        }
    }

    public final void m822j(int[] iArr, int i6) {
        C0207g1 c0207g1 = this.f1127i;
        if (c0207g1.m683j()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i6 == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = c0207g1.f934j.getResources().getDisplayMetrics();
                    for (int i10 = 0; i10 < length; i10++) {
                        iArrCopyOf[i10] = Math.round(TypedValue.applyDimension(i6, iArr[i10], displayMetrics));
                    }
                }
                c0207g1.f930f = C0207g1.m674b(iArrCopyOf);
                if (!c0207g1.m682i()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                c0207g1.f931g = false;
            }
            if (c0207g1.m681h()) {
                c0207g1.m677a();
            }
        }
    }

    public final void m823k(int i6) {
        C0207g1 c0207g1 = this.f1127i;
        if (c0207g1.m683j()) {
            if (i6 == 0) {
                c0207g1.f925a = 0;
                c0207g1.f928d = -1.0f;
                c0207g1.f929e = -1.0f;
                c0207g1.f927c = -1.0f;
                c0207g1.f930f = new int[0];
                c0207g1.f926b = false;
                return;
            }
            if (i6 != 1) {
                throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "Unknown auto-size text type: "));
            }
            DisplayMetrics displayMetrics = c0207g1.f934j.getResources().getDisplayMetrics();
            c0207g1.m684k(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (c0207g1.m681h()) {
                c0207g1.m677a();
            }
        }
    }

    public final void m824l(ColorStateList colorStateList) {
        if (this.f1126h == null) {
            this.f1126h = new C0234l3();
        }
        C0234l3 c0234l3 = this.f1126h;
        c0234l3.f999a = colorStateList;
        c0234l3.f1002d = colorStateList != null;
        this.f1120b = c0234l3;
        this.f1121c = c0234l3;
        this.f1122d = c0234l3;
        this.f1123e = c0234l3;
        this.f1124f = c0234l3;
        this.f1125g = c0234l3;
    }

    public final void m825m(PorterDuff.Mode mode) {
        if (this.f1126h == null) {
            this.f1126h = new C0234l3();
        }
        C0234l3 c0234l3 = this.f1126h;
        c0234l3.f1000b = mode;
        c0234l3.f1001c = mode != null;
        this.f1120b = c0234l3;
        this.f1121c = c0234l3;
        this.f1122d = c0234l3;
        this.f1123e = c0234l3;
        this.f1124f = c0234l3;
        this.f1125g = c0234l3;
    }

    public final void m826n(Context context, C0026b c0026b) {
        String string;
        int i6 = this.f1128j;
        TypedArray typedArray = (TypedArray) c0026b.f55c;
        this.f1128j = typedArray.getInt(2, i6);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            int i11 = typedArray.getInt(11, -1);
            this.f1129k = i11;
            if (i11 != -1) {
                this.f1128j &= 2;
            }
        }
        if (!typedArray.hasValue(10) && !typedArray.hasValue(12)) {
            if (typedArray.hasValue(1)) {
                this.f1131m = false;
                int i12 = typedArray.getInt(1, 1);
                if (i12 == 1) {
                    this.f1130l = Typeface.SANS_SERIF;
                    return;
                } else if (i12 == 2) {
                    this.f1130l = Typeface.SERIF;
                    return;
                } else {
                    if (i12 != 3) {
                        return;
                    }
                    this.f1130l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f1130l = null;
        int i13 = typedArray.hasValue(12) ? 12 : 10;
        int i14 = this.f1129k;
        int i15 = this.f1128j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceM142v = c0026b.m142v(i13, this.f1128j, new C0256q0(this, i14, i15, new WeakReference(this.f1119a)));
                if (typefaceM142v != null) {
                    if (i10 < 28 || this.f1129k == -1) {
                        this.f1130l = typefaceM142v;
                    } else {
                        this.f1130l = AbstractC0286w0.m806a(Typeface.create(typefaceM142v, 0), this.f1129k, (this.f1128j & 2) != 0);
                    }
                }
                this.f1131m = this.f1130l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f1130l != null || (string = typedArray.getString(i13)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f1129k == -1) {
            this.f1130l = Typeface.create(string, this.f1128j);
        } else {
            this.f1130l = AbstractC0286w0.m806a(Typeface.create(string, 0), this.f1129k, (this.f1128j & 2) != 0);
        }
    }
}

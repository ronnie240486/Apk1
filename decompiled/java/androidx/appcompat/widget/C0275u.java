package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.bumptech.glide.AbstractC1466d;
import java.util.WeakHashMap;
import p002a1.C0026b;
import p003a2.AbstractC0032a;
import p045e.AbstractC2341a;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3155s0;
import p221u6.C3901a;
import p221u6.C3908h;
import p221u6.C3913m;
import p250x5.AbstractC4121a;

public final class C0275u {

    public int f1069a;

    public final Object f1070b;

    public final Object f1071c;

    public Object f1072d;

    public Object f1073e;

    public Object f1074f;

    public C0275u(View view) {
        this.f1069a = -1;
        this.f1070b = view;
        this.f1071c = C0285w.m801a();
    }

    public static C0275u m772b(Context context, int i6) {
        AbstractC0032a.m160n("Cannot create a CalendarItemStyle with a styleResId of 0", i6 != 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i6, AbstractC4121a.f13958B);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0));
        ColorStateList colorStateListM3493k = AbstractC1466d.m3493k(context, typedArrayObtainStyledAttributes, 4);
        ColorStateList colorStateListM3493k2 = AbstractC1466d.m3493k(context, typedArrayObtainStyledAttributes, 9);
        ColorStateList colorStateListM3493k3 = AbstractC1466d.m3493k(context, typedArrayObtainStyledAttributes, 7);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        C3913m c3913mM7819a = C3913m.m7821a(context, typedArrayObtainStyledAttributes.getResourceId(5, 0), typedArrayObtainStyledAttributes.getResourceId(6, 0), new C3901a(0)).m7819a();
        typedArrayObtainStyledAttributes.recycle();
        return new C0275u(colorStateListM3493k, colorStateListM3493k2, colorStateListM3493k3, dimensionPixelSize, c3913mM7819a, rect);
    }

    public void m773a() {
        View view = (View) this.f1070b;
        Drawable background = view.getBackground();
        if (background != null) {
            int i6 = Build.VERSION.SDK_INT;
            if (i6 <= 21 ? i6 == 21 : ((C0234l3) this.f1072d) != null) {
                if (((C0234l3) this.f1074f) == null) {
                    this.f1074f = new C0234l3();
                }
                C0234l3 c0234l3 = (C0234l3) this.f1074f;
                c0234l3.f999a = null;
                c0234l3.f1002d = false;
                c0234l3.f1000b = null;
                c0234l3.f1001c = false;
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                ColorStateList colorStateListM6168g = AbstractC3119g0.m6168g(view);
                if (colorStateListM6168g != null) {
                    c0234l3.f1002d = true;
                    c0234l3.f999a = colorStateListM6168g;
                }
                PorterDuff.Mode modeM6169h = AbstractC3119g0.m6169h(view);
                if (modeM6169h != null) {
                    c0234l3.f1001c = true;
                    c0234l3.f1000b = modeM6169h;
                }
                if (c0234l3.f1002d || c0234l3.f1001c) {
                    C0285w.m804e(background, c0234l3, view.getDrawableState());
                    return;
                }
            }
            C0234l3 c0234l4 = (C0234l3) this.f1073e;
            if (c0234l4 != null) {
                C0285w.m804e(background, c0234l4, view.getDrawableState());
                return;
            }
            C0234l3 c0234l5 = (C0234l3) this.f1072d;
            if (c0234l5 != null) {
                C0285w.m804e(background, c0234l5, view.getDrawableState());
            }
        }
    }

    public ColorStateList m774c() {
        C0234l3 c0234l3 = (C0234l3) this.f1073e;
        if (c0234l3 != null) {
            return c0234l3.f999a;
        }
        return null;
    }

    public PorterDuff.Mode m775d() {
        C0234l3 c0234l3 = (C0234l3) this.f1073e;
        if (c0234l3 != null) {
            return c0234l3.f1000b;
        }
        return null;
    }

    public void m776e(AttributeSet attributeSet, int i6) {
        ColorStateList colorStateListM729i;
        View view = (View) this.f1070b;
        Context context = view.getContext();
        int[] iArr = AbstractC2341a.f8151B;
        C0026b c0026bM111C = C0026b.m111C(context, attributeSet, iArr, i6);
        TypedArray typedArray = (TypedArray) c0026bM111C.f55c;
        View view2 = (View) this.f1070b;
        AbstractC3155s0.m6346p(view2, view2.getContext(), iArr, attributeSet, (TypedArray) c0026bM111C.f55c, i6, 0);
        try {
            if (typedArray.hasValue(0)) {
                this.f1069a = typedArray.getResourceId(0, -1);
                C0285w c0285w = (C0285w) this.f1071c;
                Context context2 = view.getContext();
                int i10 = this.f1069a;
                synchronized (c0285w) {
                    colorStateListM729i = c0285w.f1115a.m729i(context2, i10);
                }
                if (colorStateListM729i != null) {
                    m779h(colorStateListM729i);
                }
            }
            if (typedArray.hasValue(1)) {
                AbstractC3155s0.m6349s(view, c0026bM111C.m139s(1));
            }
            if (typedArray.hasValue(2)) {
                PorterDuff.Mode modeM737c = AbstractC0237m1.m737c(typedArray.getInt(2, -1), null);
                int i11 = Build.VERSION.SDK_INT;
                AbstractC3119g0.m6179r(view, modeM737c);
                if (i11 == 21) {
                    Drawable background = view.getBackground();
                    boolean z7 = (AbstractC3119g0.m6168g(view) == null && AbstractC3119g0.m6169h(view) == null) ? false : true;
                    if (background != null && z7) {
                        if (background.isStateful()) {
                            background.setState(view.getDrawableState());
                        }
                        view.setBackground(background);
                    }
                }
            }
            c0026bM111C.m120F();
        } catch (Throwable th) {
            c0026bM111C.m120F();
            throw th;
        }
    }

    public void m777f() {
        this.f1069a = -1;
        m779h(null);
        m773a();
    }

    public void m778g(int i6) {
        ColorStateList colorStateListM729i;
        this.f1069a = i6;
        C0285w c0285w = (C0285w) this.f1071c;
        if (c0285w != null) {
            Context context = ((View) this.f1070b).getContext();
            synchronized (c0285w) {
                colorStateListM729i = c0285w.f1115a.m729i(context, i6);
            }
        } else {
            colorStateListM729i = null;
        }
        m779h(colorStateListM729i);
        m773a();
    }

    public void m779h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (((C0234l3) this.f1072d) == null) {
                this.f1072d = new C0234l3();
            }
            C0234l3 c0234l3 = (C0234l3) this.f1072d;
            c0234l3.f999a = colorStateList;
            c0234l3.f1002d = true;
        } else {
            this.f1072d = null;
        }
        m773a();
    }

    public void m780i(ColorStateList colorStateList) {
        if (((C0234l3) this.f1073e) == null) {
            this.f1073e = new C0234l3();
        }
        C0234l3 c0234l3 = (C0234l3) this.f1073e;
        c0234l3.f999a = colorStateList;
        c0234l3.f1002d = true;
        m773a();
    }

    public void m781j(PorterDuff.Mode mode) {
        if (((C0234l3) this.f1073e) == null) {
            this.f1073e = new C0234l3();
        }
        C0234l3 c0234l3 = (C0234l3) this.f1073e;
        c0234l3.f1000b = mode;
        c0234l3.f1001c = true;
        m773a();
    }

    public void m782k(TextView textView) {
        C3908h c3908h = new C3908h();
        C3908h c3908h2 = new C3908h();
        C3913m c3913m = (C3913m) this.f1074f;
        c3908h.setShapeAppearanceModel(c3913m);
        c3908h2.setShapeAppearanceModel(c3913m);
        c3908h.m7809n((ColorStateList) this.f1072d);
        c3908h.f13126a.f13116j = this.f1069a;
        c3908h.invalidateSelf();
        c3908h.m7814s((ColorStateList) this.f1073e);
        ColorStateList colorStateList = (ColorStateList) this.f1071c;
        textView.setTextColor(colorStateList);
        RippleDrawable rippleDrawable = new RippleDrawable(colorStateList.withAlpha(30), c3908h, c3908h2);
        Rect rect = (Rect) this.f1070b;
        InsetDrawable insetDrawable = new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom);
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        textView.setBackground(insetDrawable);
    }

    public C0275u(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i6, C3913m c3913m, Rect rect) {
        AbstractC0032a.m161o(rect.left);
        AbstractC0032a.m161o(rect.top);
        AbstractC0032a.m161o(rect.right);
        AbstractC0032a.m161o(rect.bottom);
        this.f1070b = rect;
        this.f1071c = colorStateList2;
        this.f1072d = colorStateList;
        this.f1073e = colorStateList3;
        this.f1069a = i6;
        this.f1074f = c3913m;
    }
}

package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import p002a1.C0026b;
import p045e.AbstractC2341a;
import p056f0.AbstractC2478a;

public abstract class AbstractC0224j3 {

    public static final ThreadLocal f954a = new ThreadLocal();

    public static final int[] f955b = {-16842910};

    public static final int[] f956c = {R.attr.state_focused};

    public static final int[] f957d = {R.attr.state_pressed};

    public static final int[] f958e = {R.attr.state_checked};

    public static final int[] f959f = new int[0];

    public static final int[] f960g = new int[1];

    public static void m702a(View view, Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(AbstractC2341a.f8163k);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(117)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int m703b(Context context, int i6) {
        ColorStateList colorStateListM705d = m705d(context, i6);
        if (colorStateListM705d != null && colorStateListM705d.isStateful()) {
            return colorStateListM705d.getColorForState(f955b, colorStateListM705d.getDefaultColor());
        }
        ThreadLocal threadLocal = f954a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValue, true);
        float f = typedValue.getFloat();
        int iM704c = m704c(context, i6);
        return AbstractC2478a.m5513h(iM704c, Math.round(Color.alpha(iM704c) * f));
    }

    public static int m704c(Context context, int i6) {
        int[] iArr = f960g;
        iArr[0] = i6;
        C0026b c0026bM110B = C0026b.m110B(context, null, iArr);
        try {
            return ((TypedArray) c0026bM110B.f55c).getColor(0, 0);
        } finally {
            c0026bM110B.m120F();
        }
    }

    public static ColorStateList m705d(Context context, int i6) {
        int[] iArr = f960g;
        iArr[0] = i6;
        C0026b c0026bM110B = C0026b.m110B(context, null, iArr);
        try {
            return c0026bM110B.m139s(0);
        } finally {
            c0026bM110B.m120F();
        }
    }
}

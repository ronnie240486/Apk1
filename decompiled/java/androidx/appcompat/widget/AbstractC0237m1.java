package androidx.appcompat.widget;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import p065g0.C2590j;
import p065g0.InterfaceC2589i;

public abstract class AbstractC0237m1 {

    public static final int[] f1008a = {R.attr.state_checked};

    public static final int[] f1009b = new int[0];

    public static final Rect f1010c = new Rect();

    public static void m735a(Drawable drawable) {
        String name = drawable.getClass().getName();
        int i6 = Build.VERSION.SDK_INT;
        int[] iArr = f1008a;
        int[] iArr2 = f1009b;
        if (i6 == 21 && "android.graphics.drawable.VectorDrawable".equals(name)) {
            int[] state = drawable.getState();
            if (state == null || state.length == 0) {
                drawable.setState(iArr);
            } else {
                drawable.setState(iArr2);
            }
            drawable.setState(state);
            return;
        }
        if (i6 < 29 || i6 >= 31 || !"android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            return;
        }
        int[] state2 = drawable.getState();
        if (state2 == null || state2.length == 0) {
            drawable.setState(iArr);
        } else {
            drawable.setState(iArr2);
        }
        drawable.setState(state2);
    }

    public static Rect m736b(Drawable drawable) {
        Object obj;
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 29) {
            Insets insetsM719a = AbstractC0232l1.m719a(drawable);
            return new Rect(insetsM719a.left, insetsM719a.top, insetsM719a.right, insetsM719a.bottom);
        }
        if (drawable instanceof InterfaceC2589i) {
            obj = drawable;
            obj = ((C2590j) ((InterfaceC2589i) drawable)).f9035f;
        }
        if (i6 >= 29) {
            boolean z7 = AbstractC0227k1.f979a;
        } else if (AbstractC0227k1.f979a) {
            try {
                Object objInvoke = AbstractC0227k1.f980b.invoke(obj, null);
                if (objInvoke != null) {
                    return new Rect(AbstractC0227k1.f981c.getInt(objInvoke), AbstractC0227k1.f982d.getInt(objInvoke), AbstractC0227k1.f983e.getInt(objInvoke), AbstractC0227k1.f984f.getInt(objInvoke));
                }
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        return f1010c;
    }

    public static PorterDuff.Mode m737c(int i6, PorterDuff.Mode mode) {
        if (i6 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i6 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i6 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i6) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}

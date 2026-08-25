package p138n0;

import android.graphics.Rect;
import android.util.Log;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import p056f0.C2480c;

public final class C3114e1 extends AbstractC3126i1 {

    public static Field f10591c;

    public static boolean f10592d;

    public static Constructor f10593e;

    public static boolean f10594f;

    public WindowInsets f10595a;

    public C2480c f10596b;

    public C3114e1() {
        this.f10595a = m6131e();
    }

    private static WindowInsets m6131e() {
        if (!f10592d) {
            try {
                f10591c = WindowInsets.class.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException e5) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e5);
            }
            f10592d = true;
        }
        Field field = f10591c;
        if (field != null) {
            try {
                WindowInsets windowInsets = (WindowInsets) field.get(null);
                if (windowInsets != null) {
                    return new WindowInsets(windowInsets);
                }
            } catch (ReflectiveOperationException e10) {
                Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e10);
            }
        }
        if (!f10594f) {
            try {
                f10593e = WindowInsets.class.getConstructor(Rect.class);
            } catch (ReflectiveOperationException e11) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e11);
            }
            f10594f = true;
        }
        Constructor constructor = f10593e;
        if (constructor != null) {
            try {
                return (WindowInsets) constructor.newInstance(new Rect());
            } catch (ReflectiveOperationException e12) {
                Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e12);
            }
        }
        return null;
    }

    @Override
    public C3153r1 mo6132b() {
        m6199a();
        C3153r1 c3153r1M6324h = C3153r1.m6324h(this.f10595a, null);
        C3144o1 c3144o1 = c3153r1M6324h.f10641a;
        c3144o1.mo6232p(null);
        c3144o1.mo6240s(this.f10596b);
        return c3153r1M6324h;
    }

    @Override
    public void mo6133c(C2480c c2480c) {
        this.f10596b = c2480c;
    }

    @Override
    public void mo6134d(C2480c c2480c) {
        WindowInsets windowInsets = this.f10595a;
        if (windowInsets != null) {
            this.f10595a = windowInsets.replaceSystemWindowInsets(c2480c.f8681a, c2480c.f8682b, c2480c.f8683c, c2480c.f8684d);
        }
    }

    public C3114e1(C3153r1 c3153r1) {
        super(c3153r1);
        this.f10595a = c3153r1.m6330g();
    }
}

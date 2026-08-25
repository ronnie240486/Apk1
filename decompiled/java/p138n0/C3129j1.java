package p138n0;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import p056f0.C2480c;

public class C3129j1 extends C3144o1 {

    public static boolean f10610h;

    public static Method f10611i;

    public static Class f10612j;

    public static Field f10613k;

    public static Field f10614l;

    public final WindowInsets f10615c;

    public C2480c[] f10616d;

    public C2480c f10617e;

    public C3153r1 f10618f;

    public C2480c f10619g;

    public C3129j1(C3153r1 c3153r1, WindowInsets windowInsets) {
        super(c3153r1);
        this.f10617e = null;
        this.f10615c = windowInsets;
    }

    @SuppressLint({"WrongConstant"})
    private C2480c m6222t(int i6, boolean z7) {
        C2480c c2480cM5515a = C2480c.f8680e;
        for (int i10 = 1; i10 <= 256; i10 <<= 1) {
            if ((i6 & i10) != 0) {
                C2480c c2480cM6235u = m6235u(i10, z7);
                c2480cM5515a = C2480c.m5515a(Math.max(c2480cM5515a.f8681a, c2480cM6235u.f8681a), Math.max(c2480cM5515a.f8682b, c2480cM6235u.f8682b), Math.max(c2480cM5515a.f8683c, c2480cM6235u.f8683c), Math.max(c2480cM5515a.f8684d, c2480cM6235u.f8684d));
            }
        }
        return c2480cM5515a;
    }

    private C2480c m6223v() {
        C3153r1 c3153r1 = this.f10618f;
        return c3153r1 != null ? c3153r1.f10641a.mo6238i() : C2480c.f8680e;
    }

    private C2480c m6224w(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }
        if (!f10610h) {
            m6225x();
        }
        Method method = f10611i;
        if (method != null && f10612j != null && f10613k != null) {
            try {
                Object objInvoke = method.invoke(view, null);
                if (objInvoke == null) {
                    Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                    return null;
                }
                Rect rect = (Rect) f10613k.get(f10614l.get(objInvoke));
                if (rect != null) {
                    return C2480c.m5515a(rect.left, rect.top, rect.right, rect.bottom);
                }
                return null;
            } catch (ReflectiveOperationException e5) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e5.getMessage(), e5);
            }
        }
        return null;
    }

    @SuppressLint({"PrivateApi"})
    private static void m6225x() {
        try {
            f10611i = View.class.getDeclaredMethod("getViewRootImpl", null);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            f10612j = cls;
            f10613k = cls.getDeclaredField("mVisibleInsets");
            f10614l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            f10613k.setAccessible(true);
            f10614l.setAccessible(true);
        } catch (ReflectiveOperationException e5) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e5.getMessage(), e5);
        }
        f10610h = true;
    }

    @Override
    public void mo6226d(View view) {
        C2480c c2480cM6224w = m6224w(view);
        if (c2480cM6224w == null) {
            c2480cM6224w = C2480c.f8680e;
        }
        mo6233q(c2480cM6224w);
    }

    @Override
    public void mo6227e(C3153r1 c3153r1) {
        c3153r1.f10641a.mo6234r(this.f10618f);
        c3153r1.f10641a.mo6233q(this.f10619g);
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return Objects.equals(this.f10619g, ((C3129j1) obj).f10619g);
        }
        return false;
    }

    @Override
    public C2480c mo6228g(int i6) {
        return m6222t(i6, false);
    }

    @Override
    public final C2480c mo6229k() {
        if (this.f10617e == null) {
            WindowInsets windowInsets = this.f10615c;
            this.f10617e = C2480c.m5515a(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.f10617e;
    }

    @Override
    public C3153r1 mo6230m(int i6, int i10, int i11, int i12) {
        AbstractC3126i1 c3120g1;
        C3153r1 c3153r1M6324h = C3153r1.m6324h(this.f10615c, null);
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 30) {
            c3120g1 = new C3123h1(c3153r1M6324h);
        } else {
            c3120g1 = i13 >= 29 ? new C3120g1(c3153r1M6324h) : new C3114e1(c3153r1M6324h);
        }
        c3120g1.mo6134d(C3153r1.m6323e(mo6229k(), i6, i10, i11, i12));
        c3120g1.mo6133c(C3153r1.m6323e(mo6238i(), i6, i10, i11, i12));
        return c3120g1.mo6132b();
    }

    @Override
    public boolean mo6231o() {
        return this.f10615c.isRound();
    }

    @Override
    public void mo6232p(C2480c[] c2480cArr) {
        this.f10616d = c2480cArr;
    }

    @Override
    public void mo6233q(C2480c c2480c) {
        this.f10619g = c2480c;
    }

    @Override
    public void mo6234r(C3153r1 c3153r1) {
        this.f10618f = c3153r1;
    }

    public C2480c m6235u(int i6, boolean z7) {
        C2480c c2480cMo6238i;
        int i10;
        if (i6 == 1) {
            return z7 ? C2480c.m5515a(0, Math.max(m6223v().f8682b, mo6229k().f8682b), 0, 0) : C2480c.m5515a(0, mo6229k().f8682b, 0, 0);
        }
        if (i6 == 2) {
            if (z7) {
                C2480c c2480cM6223v = m6223v();
                C2480c c2480cMo6238i2 = mo6238i();
                return C2480c.m5515a(Math.max(c2480cM6223v.f8681a, c2480cMo6238i2.f8681a), 0, Math.max(c2480cM6223v.f8683c, c2480cMo6238i2.f8683c), Math.max(c2480cM6223v.f8684d, c2480cMo6238i2.f8684d));
            }
            C2480c c2480cMo6229k = mo6229k();
            C3153r1 c3153r1 = this.f10618f;
            c2480cMo6238i = c3153r1 != null ? c3153r1.f10641a.mo6238i() : null;
            int iMin = c2480cMo6229k.f8684d;
            if (c2480cMo6238i != null) {
                iMin = Math.min(iMin, c2480cMo6238i.f8684d);
            }
            return C2480c.m5515a(c2480cMo6229k.f8681a, 0, c2480cMo6229k.f8683c, iMin);
        }
        C2480c c2480c = C2480c.f8680e;
        if (i6 == 8) {
            C2480c[] c2480cArr = this.f10616d;
            c2480cMo6238i = c2480cArr != null ? c2480cArr[3] : null;
            if (c2480cMo6238i != null) {
                return c2480cMo6238i;
            }
            C2480c c2480cMo6229k2 = mo6229k();
            C2480c c2480cM6223v2 = m6223v();
            int i11 = c2480cMo6229k2.f8684d;
            if (i11 > c2480cM6223v2.f8684d) {
                return C2480c.m5515a(0, 0, 0, i11);
            }
            C2480c c2480c2 = this.f10619g;
            return (c2480c2 == null || c2480c2.equals(c2480c) || (i10 = this.f10619g.f8684d) <= c2480cM6223v2.f8684d) ? c2480c : C2480c.m5515a(0, 0, 0, i10);
        }
        if (i6 == 16) {
            return mo6273j();
        }
        if (i6 == 32) {
            return mo6272h();
        }
        if (i6 == 64) {
            return mo6274l();
        }
        if (i6 != 128) {
            return c2480c;
        }
        C3153r1 c3153r2 = this.f10618f;
        C3130k c3130kMo6252f = c3153r2 != null ? c3153r2.f10641a.mo6252f() : mo6252f();
        if (c3130kMo6252f == null) {
            return c2480c;
        }
        int i12 = Build.VERSION.SDK_INT;
        return C2480c.m5515a(i12 >= 28 ? AbstractC3127j.m6203d(c3130kMo6252f.f10620a) : 0, i12 >= 28 ? AbstractC3127j.m6205f(c3130kMo6252f.f10620a) : 0, i12 >= 28 ? AbstractC3127j.m6204e(c3130kMo6252f.f10620a) : 0, i12 >= 28 ? AbstractC3127j.m6202c(c3130kMo6252f.f10620a) : 0);
    }

    public C3129j1(C3153r1 c3153r1, C3129j1 c3129j1) {
        this(c3153r1, new WindowInsets(c3129j1.f10615c));
    }
}

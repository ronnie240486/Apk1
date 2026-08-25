package androidx.appcompat.app;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AbstractC0189c4;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.InterfaceC0212h1;
import com.p2serv.android.p032ds.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import p105k.InterfaceC2850x;
import p105k.MenuC2838l;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3122h0;
import p138n0.AbstractC3155s0;
import p138n0.C3153r1;
import p138n0.InterfaceC3154s;
import p222u7.AbstractC3928d;

public final class C0158s implements InterfaceC3154s, InterfaceC0212h1, InterfaceC2850x {

    public final int f430a;

    public final LayoutInflaterFactory2C0135g0 f431b;

    public C0158s(LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0, int i6) {
        this.f430a = i6;
        this.f431b = layoutInflaterFactory2C0135g0;
    }

    @Override
    public void mo86b(MenuC2838l menuC2838l, boolean z7) {
        C0133f0 c0133f0;
        switch (this.f430a) {
            case 2:
                this.f431b.m405r(menuC2838l);
                break;
            default:
                MenuC2838l menuC2838lMo5817k = menuC2838l.mo5817k();
                int i6 = 0;
                boolean z10 = menuC2838lMo5817k != menuC2838l;
                if (z10) {
                    menuC2838l = menuC2838lMo5817k;
                }
                LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0 = this.f431b;
                C0133f0[] c0133f0Arr = layoutInflaterFactory2C0135g0.f318M;
                int length = c0133f0Arr != null ? c0133f0Arr.length : 0;
                while (true) {
                    if (i6 >= length) {
                        c0133f0 = null;
                    } else {
                        c0133f0 = c0133f0Arr[i6];
                        if (c0133f0 == null || c0133f0.f293h != menuC2838l) {
                            i6++;
                        }
                    }
                }
                if (c0133f0 != null) {
                    if (!z10) {
                        layoutInflaterFactory2C0135g0.m406s(c0133f0, z7);
                    } else {
                        layoutInflaterFactory2C0135g0.m404q(c0133f0.f286a, c0133f0, menuC2838lMo5817k);
                        layoutInflaterFactory2C0135g0.m406s(c0133f0, true);
                    }
                }
                break;
        }
    }

    @Override
    public boolean mo90f(MenuC2838l menuC2838l) {
        Window.Callback callback;
        switch (this.f430a) {
            case 2:
                Window.Callback callback2 = this.f431b.f342l.getCallback();
                if (callback2 != null) {
                    callback2.onMenuOpened(108, menuC2838l);
                }
                break;
            default:
                if (menuC2838l == menuC2838l.mo5817k()) {
                    LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0 = this.f431b;
                    if (layoutInflaterFactory2C0135g0.f312G && (callback = layoutInflaterFactory2C0135g0.f342l.getCallback()) != null && !layoutInflaterFactory2C0135g0.f323R) {
                        callback.onMenuOpened(108, menuC2838l);
                        break;
                    }
                }
                break;
        }
        return true;
    }

    @Override
    public C3153r1 onApplyWindowInsets(View view, C3153r1 c3153r1) {
        boolean z7;
        boolean z10;
        boolean z11 = true;
        int iM6328d = c3153r1.m6328d();
        LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0 = this.f431b;
        layoutInflaterFactory2C0135g0.getClass();
        int iM6328d2 = c3153r1.m6328d();
        ActionBarContextView actionBarContextView = layoutInflaterFactory2C0135g0.f352v;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z7 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutInflaterFactory2C0135g0.f352v.getLayoutParams();
            if (layoutInflaterFactory2C0135g0.f352v.isShown()) {
                if (layoutInflaterFactory2C0135g0.f335e0 == null) {
                    layoutInflaterFactory2C0135g0.f335e0 = new Rect();
                    layoutInflaterFactory2C0135g0.f336f0 = new Rect();
                }
                Rect rect = layoutInflaterFactory2C0135g0.f335e0;
                Rect rect2 = layoutInflaterFactory2C0135g0.f336f0;
                rect.set(c3153r1.m6326b(), c3153r1.m6328d(), c3153r1.m6327c(), c3153r1.m6325a());
                ViewGroup viewGroup = layoutInflaterFactory2C0135g0.f307B;
                Method method = AbstractC0189c4.f880a;
                if (method != null) {
                    try {
                        method.invoke(viewGroup, rect, rect2);
                    } catch (Exception e5) {
                        Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e5);
                    }
                }
                int i6 = rect.top;
                int i10 = rect.left;
                int i11 = rect.right;
                ViewGroup viewGroup2 = layoutInflaterFactory2C0135g0.f307B;
                WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
                C3153r1 c3153r1M6189a = Build.VERSION.SDK_INT >= 23 ? AbstractC3122h0.m6189a(viewGroup2) : AbstractC3119g0.m6171j(viewGroup2);
                int iM6326b = c3153r1M6189a == null ? 0 : c3153r1M6189a.m6326b();
                int iM6327c = c3153r1M6189a == null ? 0 : c3153r1M6189a.m6327c();
                if (marginLayoutParams.topMargin == i6 && marginLayoutParams.leftMargin == i10 && marginLayoutParams.rightMargin == i11) {
                    z10 = false;
                } else {
                    marginLayoutParams.topMargin = i6;
                    marginLayoutParams.leftMargin = i10;
                    marginLayoutParams.rightMargin = i11;
                    z10 = true;
                }
                Context context = layoutInflaterFactory2C0135g0.f341k;
                if (i6 <= 0 || layoutInflaterFactory2C0135g0.f309D != null) {
                    View view2 = layoutInflaterFactory2C0135g0.f309D;
                    if (view2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                        int i12 = marginLayoutParams2.height;
                        int i13 = marginLayoutParams.topMargin;
                        if (i12 != i13 || marginLayoutParams2.leftMargin != iM6326b || marginLayoutParams2.rightMargin != iM6327c) {
                            marginLayoutParams2.height = i13;
                            marginLayoutParams2.leftMargin = iM6326b;
                            marginLayoutParams2.rightMargin = iM6327c;
                            layoutInflaterFactory2C0135g0.f309D.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view3 = new View(context);
                    layoutInflaterFactory2C0135g0.f309D = view3;
                    view3.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = iM6326b;
                    layoutParams.rightMargin = iM6327c;
                    layoutInflaterFactory2C0135g0.f307B.addView(layoutInflaterFactory2C0135g0.f309D, -1, layoutParams);
                }
                View view4 = layoutInflaterFactory2C0135g0.f309D;
                z11 = view4 != null;
                if (z11 && view4.getVisibility() != 0) {
                    View view5 = layoutInflaterFactory2C0135g0.f309D;
                    view5.setBackgroundColor((view5.getWindowSystemUiVisibility() & 8192) != 0 ? AbstractC3928d.m7847i(context, R.color.abc_decor_view_status_guard_light) : AbstractC3928d.m7847i(context, R.color.abc_decor_view_status_guard));
                }
                if (!layoutInflaterFactory2C0135g0.f314I && z11) {
                    iM6328d2 = 0;
                }
                z7 = z11;
                z11 = z10;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z7 = false;
            } else {
                z7 = false;
                z11 = false;
            }
            if (z11) {
                layoutInflaterFactory2C0135g0.f352v.setLayoutParams(marginLayoutParams);
            }
        }
        View view6 = layoutInflaterFactory2C0135g0.f309D;
        if (view6 != null) {
            view6.setVisibility(z7 ? 0 : 8);
        }
        return AbstractC3155s0.m6341k(view, iM6328d != iM6328d2 ? c3153r1.m6329f(c3153r1.m6326b(), iM6328d2, c3153r1.m6327c(), c3153r1.m6325a()) : c3153r1);
    }
}

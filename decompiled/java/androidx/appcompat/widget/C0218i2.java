package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Method;
import p101j7.C2782c;
import p105k.C2840n;
import p105k.MenuC2838l;

public final class C0218i2 extends ListPopupWindow implements InterfaceC0193d2 {

    public static final Method f948D;

    public C2782c f949C;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                f948D = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    @Override
    public final C0267s1 mo577b(Context context, boolean z7) {
        C0213h2 c0213h2 = new C0213h2(context, z7);
        c0213h2.setHoverListener(this);
        return c0213h2;
    }

    @Override
    public final void mo652d(MenuC2838l menuC2838l, C2840n c2840n) {
        C2782c c2782c = this.f949C;
        if (c2782c != null) {
            c2782c.mo652d(menuC2838l, c2840n);
        }
    }

    @Override
    public final void mo653k(MenuC2838l menuC2838l, C2840n c2840n) {
        C2782c c2782c = this.f949C;
        if (c2782c != null) {
            c2782c.mo653k(menuC2838l, c2840n);
        }
    }
}

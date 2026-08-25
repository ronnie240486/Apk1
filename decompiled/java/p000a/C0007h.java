package p000a;

import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.C0562z0;
import androidx.lifecycle.EnumC0537n;
import androidx.lifecycle.InterfaceC0551u;
import androidx.lifecycle.InterfaceC0555w;
import java.lang.reflect.Field;

public final class C0007h implements InterfaceC0551u {

    public static int f15c;

    public static Field f16d;

    public static Field f17e;

    public static Field f18f;

    public final int f19a;

    public ComponentActivity f20b;

    public C0007h() {
        this.f19a = 3;
    }

    @Override
    public final void onStateChanged(InterfaceC0555w interfaceC0555w, EnumC0537n enumC0537n) {
        switch (this.f19a) {
            case 0:
                if (enumC0537n == EnumC0537n.ON_STOP) {
                    Window window = this.f20b.getWindow();
                    View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                    if (viewPeekDecorView != null) {
                        viewPeekDecorView.cancelPendingInputEvents();
                        return;
                    }
                    return;
                }
                return;
            case 1:
                if (enumC0537n == EnumC0537n.ON_DESTROY) {
                    this.f20b.f226b.f3908a = null;
                    if (this.f20b.isChangingConfigurations()) {
                        return;
                    }
                    this.f20b.mo359e().m1527a();
                    return;
                }
                return;
            case 2:
                ComponentActivity componentActivity = this.f20b;
                if (componentActivity.f230f == null) {
                    C0009j c0009j = (C0009j) componentActivity.getLastNonConfigurationInstance();
                    if (c0009j != null) {
                        componentActivity.f230f = c0009j.f21a;
                    }
                    if (componentActivity.f230f == null) {
                        componentActivity.f230f = new C0562z0();
                    }
                }
                componentActivity.f228d.mo1510c(this);
                return;
            default:
                if (enumC0537n != EnumC0537n.ON_DESTROY) {
                    return;
                }
                if (f15c == 0) {
                    try {
                        f15c = 2;
                        Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
                        f17e = declaredField;
                        declaredField.setAccessible(true);
                        Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
                        f18f = declaredField2;
                        declaredField2.setAccessible(true);
                        Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
                        f16d = declaredField3;
                        declaredField3.setAccessible(true);
                        f15c = 1;
                        break;
                    } catch (NoSuchFieldException unused) {
                    }
                }
                if (f15c == 1) {
                    InputMethodManager inputMethodManager = (InputMethodManager) this.f20b.getSystemService("input_method");
                    try {
                        Object obj = f16d.get(inputMethodManager);
                        if (obj == null) {
                            return;
                        }
                        synchronized (obj) {
                            try {
                                try {
                                    View view = (View) f17e.get(inputMethodManager);
                                    if (view != null) {
                                        if (!view.isAttachedToWindow()) {
                                            try {
                                                f18f.set(inputMethodManager, null);
                                                inputMethodManager.isActive();
                                            } catch (IllegalAccessException unused2) {
                                            }
                                        }
                                    }
                                } catch (ClassCastException unused3) {
                                } catch (IllegalAccessException unused4) {
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return;
                    } catch (IllegalAccessException unused5) {
                        return;
                    }
                }
                return;
        }
    }

    public C0007h(ComponentActivity componentActivity, int i6) {
        this.f19a = i6;
        this.f20b = componentActivity;
    }
}

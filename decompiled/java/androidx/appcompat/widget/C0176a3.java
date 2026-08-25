package androidx.appcompat.widget;

import android.os.Build;
import java.lang.reflect.Method;

public final class C0176a3 {

    public Method f865a;

    public Method f866b;

    public Method f867c;

    public C0176a3(Method method, Method method2, Method method3) {
        this.f865a = method;
        this.f866b = method2;
        this.f867c = method3;
    }

    public static void m638a() {
        if (Build.VERSION.SDK_INT >= 29) {
            throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
        }
    }
}

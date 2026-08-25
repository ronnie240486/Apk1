package p224u9;

import android.os.Build;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import p008a9.AbstractC0071a;
import p008a9.InterfaceC0079i;
import p213t9.C3857q;
import p213t9.InterfaceC3859r;

public final class C3937b extends AbstractC0071a implements InterfaceC3859r {
    private volatile Object _preHandler;

    public C3937b() {
        super(C3857q.f12951a);
        this._preHandler = this;
    }

    @Override
    public void mo3263b(InterfaceC0079i interfaceC0079i, Throwable th) {
        Method declaredMethod;
        int i6 = Build.VERSION.SDK_INT;
        if (26 > i6 || i6 >= 28) {
            return;
        }
        Object obj = this._preHandler;
        if (obj != this) {
            declaredMethod = (Method) obj;
        } else {
            try {
                declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", null);
                if (!Modifier.isPublic(declaredMethod.getModifiers()) || !Modifier.isStatic(declaredMethod.getModifiers())) {
                    declaredMethod = null;
                }
            } catch (Throwable unused) {
            }
            this._preHandler = declaredMethod;
        }
        Object objInvoke = declaredMethod != null ? declaredMethod.invoke(null, null) : null;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = objInvoke instanceof Thread.UncaughtExceptionHandler ? (Thread.UncaughtExceptionHandler) objInvoke : null;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        }
    }
}

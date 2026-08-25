package p030c9;

import androidx.appcompat.widget.C0176a3;
import com.lzy.okgo.cookie.SerializableCookie;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import p008a9.InterfaceC0074d;
import p021b9.EnumC1367a;
import p103j9.AbstractC2796i;
import p156o9.AbstractC3280d;
import p243w8.C4070l;

public abstract class AbstractC1431a implements InterfaceC0074d, InterfaceC1434d, Serializable {
    private final InterfaceC0074d<Object> completion;

    public AbstractC1431a(InterfaceC0074d interfaceC0074d) {
        this.completion = interfaceC0074d;
    }

    public InterfaceC0074d<C4070l> create(InterfaceC0074d<?> interfaceC0074d) {
        AbstractC2796i.m5785f(interfaceC0074d, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override
    public InterfaceC1434d getCallerFrame() {
        InterfaceC0074d<Object> interfaceC0074d = this.completion;
        if (interfaceC0074d instanceof InterfaceC1434d) {
            return (InterfaceC1434d) interfaceC0074d;
        }
        return null;
    }

    public final InterfaceC0074d<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        int iIntValue;
        String strM3333c;
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        InterfaceC1435e interfaceC1435e = (InterfaceC1435e) getClass().getAnnotation(InterfaceC1435e.class);
        String str = null;
        if (interfaceC1435e == null) {
            return null;
        }
        int iM3337v = interfaceC1435e.m3337v();
        if (iM3337v > 1) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + iM3337v + ". Please update the Kotlin standard library.").toString());
        }
        try {
            Field declaredField = getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            iIntValue = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            iIntValue = -1;
        }
        int i6 = iIntValue >= 0 ? interfaceC1435e.m3335l()[iIntValue] : -1;
        C0176a3 c0176a3 = AbstractC1436f.f4369b;
        C0176a3 c0176a4 = AbstractC1436f.f4368a;
        if (c0176a3 == null) {
            try {
                C0176a3 c0176a5 = new C0176a3(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod(SerializableCookie.NAME, null));
                AbstractC1436f.f4369b = c0176a5;
                c0176a3 = c0176a5;
            } catch (Exception unused2) {
                AbstractC1436f.f4369b = c0176a4;
                c0176a3 = c0176a4;
            }
        }
        if (c0176a3 != c0176a4 && (method = c0176a3.f865a) != null && (objInvoke = method.invoke(getClass(), null)) != null && (method2 = c0176a3.f866b) != null && (objInvoke2 = method2.invoke(objInvoke, null)) != null) {
            Method method3 = c0176a3.f867c;
            Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
            if (objInvoke3 instanceof String) {
                str = (String) objInvoke3;
            }
        }
        if (str == null) {
            strM3333c = interfaceC1435e.m3333c();
        } else {
            strM3333c = str + '/' + interfaceC1435e.m3333c();
        }
        return new StackTraceElement(strM3333c, interfaceC1435e.m3336m(), interfaceC1435e.m3334f(), i6);
    }

    public abstract Object invokeSuspend(Object obj);

    @Override
    public final void resumeWith(Object obj) {
        InterfaceC0074d<Object> interfaceC0074d = this;
        while (true) {
            AbstractC1431a abstractC1431a = (AbstractC1431a) interfaceC0074d;
            InterfaceC0074d<Object> interfaceC0074d2 = abstractC1431a.completion;
            AbstractC2796i.m5782c(interfaceC0074d2);
            try {
                obj = abstractC1431a.invokeSuspend(obj);
                if (obj == EnumC1367a.f4179a) {
                    return;
                }
            } catch (Throwable th) {
                obj = AbstractC3280d.m6588f(th);
            }
            abstractC1431a.releaseIntercepted();
            if (!(interfaceC0074d2 instanceof AbstractC1431a)) {
                interfaceC0074d2.resumeWith(obj);
                return;
            }
            interfaceC0074d = interfaceC0074d2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public InterfaceC0074d<C4070l> create(Object obj, InterfaceC0074d<?> interfaceC0074d) {
        AbstractC2796i.m5785f(interfaceC0074d, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public void releaseIntercepted() {
    }
}

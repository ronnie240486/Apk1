package p132m5;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.cast.AbstractBinderC1694u;
import java.lang.reflect.Field;
import p000a.AbstractC0004e;
import p018b5.AbstractC1312l;

public final class BinderC3079b extends AbstractBinderC1694u implements InterfaceC3078a {

    public final Object f10544d;

    public BinderC3079b(Object obj) {
        super("com.google.android.gms.dynamic.IObjectWrapper", 1);
        this.f10544d = obj;
    }

    public static InterfaceC3078a m6111x(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
        return iInterfaceQueryLocalInterface instanceof InterfaceC3078a ? (InterfaceC3078a) iInterfaceQueryLocalInterface : new C3081d(iBinder, "com.google.android.gms.dynamic.IObjectWrapper", 2);
    }

    public static Object m6112y(InterfaceC3078a interfaceC3078a) {
        if (interfaceC3078a instanceof BinderC3079b) {
            return ((BinderC3079b) interfaceC3078a).f10544d;
        }
        IBinder iBinderAsBinder = interfaceC3078a.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        Field field = null;
        int i6 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i6++;
                field = field2;
            }
        }
        if (i6 != 1) {
            throw new IllegalArgumentException(AbstractC0004e.m20n(declaredFields.length, "Unexpected number of IObjectWrapper declared fields: "));
        }
        AbstractC1312l.m3198e(field);
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return field.get(iBinderAsBinder);
        } catch (IllegalAccessException e5) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e5);
        } catch (NullPointerException e10) {
            throw new IllegalArgumentException("Binder object is null.", e10);
        }
    }
}

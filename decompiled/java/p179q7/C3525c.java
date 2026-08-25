package p179q7;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import p125l7.C3007n;

public final class C3525c extends AbstractC3524b {

    public static Class f11884d;

    public final Object f11885b;

    public final Field f11886c;

    public C3525c() {
        Object obj;
        Field declaredField = null;
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            f11884d = cls;
            Field declaredField2 = cls.getDeclaredField("theUnsafe");
            declaredField2.setAccessible(true);
            obj = declaredField2.get(null);
        } catch (Exception unused) {
            obj = null;
        }
        this.f11885b = obj;
        try {
            declaredField = AccessibleObject.class.getDeclaredField("override");
        } catch (Exception unused2) {
        }
        this.f11886c = declaredField;
    }

    @Override
    public final void mo7168a(AccessibleObject accessibleObject) {
        Field field;
        Object obj = this.f11885b;
        if (obj != null && (field = this.f11886c) != null) {
            try {
                Long l9 = (Long) f11884d.getMethod("objectFieldOffset", Field.class).invoke(obj, field);
                l9.getClass();
                f11884d.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(obj, accessibleObject, l9, Boolean.TRUE);
                return;
            } catch (Exception unused) {
            }
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e5) {
            throw new C3007n("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e5);
        }
    }
}

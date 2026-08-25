package p154o7;

import java.lang.reflect.Field;
import java.security.PrivilegedAction;

public final class C3274o implements PrivilegedAction {

    public final Field f10937a;

    public C3274o(Field field) {
        this.f10937a = field;
    }

    @Override
    public final Object run() {
        this.f10937a.setAccessible(true);
        return null;
    }
}

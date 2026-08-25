package p056f0;

import android.graphics.Typeface;
import androidx.media3.common.C0565C;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class C2488k extends C2487j {
    @Override
    public final Typeface mo5532Z(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.f8702w, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f8701C.invoke(null, objNewInstance, C0565C.SANS_SERIF_NAME, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    @Override
    public final Method mo5536e0(Class cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance((Class<?>) cls, 1).getClass(), String.class, cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}

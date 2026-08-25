package p034d0;

import android.content.Context;

public abstract class AbstractC2116b {
    public static int m5071a(Context context, int i6) {
        return context.getColor(i6);
    }

    public static <T> T m5072b(Context context, Class<T> cls) {
        return (T) context.getSystemService(cls);
    }

    public static String m5073c(Context context, Class<?> cls) {
        return context.getSystemServiceName(cls);
    }
}

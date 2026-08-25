package androidx.appcompat.widget;

import android.graphics.drawable.Drawable;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class AbstractC0227k1 {

    public static final boolean f979a;

    public static final Method f980b;

    public static final Field f981c;

    public static final Field f982d;

    public static final Field f983e;

    public static final Field f984f;

    static {
        Method method;
        Field field;
        Field field2;
        Field field3;
        Field field4;
        boolean z7;
        try {
            Class<?> cls = Class.forName("android.graphics.Insets");
            method = Drawable.class.getMethod("getOpticalInsets", null);
            try {
                field = cls.getField(TtmlNode.LEFT);
                try {
                    field2 = cls.getField("top");
                    try {
                        field3 = cls.getField(TtmlNode.RIGHT);
                        try {
                            field4 = cls.getField("bottom");
                            z7 = true;
                        } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused) {
                            field4 = null;
                            z7 = false;
                        }
                    } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused2) {
                        field3 = null;
                    }
                } catch (ClassNotFoundException unused3) {
                    field2 = null;
                    field3 = field2;
                    field4 = null;
                    z7 = false;
                    if (z7) {
                        f980b = method;
                        f981c = field;
                        f982d = field2;
                        f983e = field3;
                        f984f = field4;
                        f979a = true;
                        return;
                    }
                    f980b = null;
                    f981c = null;
                    f982d = null;
                    f983e = null;
                    f984f = null;
                    f979a = false;
                } catch (NoSuchFieldException unused4) {
                    field2 = null;
                    field3 = field2;
                    field4 = null;
                    z7 = false;
                    if (z7) {
                        f980b = method;
                        f981c = field;
                        f982d = field2;
                        f983e = field3;
                        f984f = field4;
                        f979a = true;
                        return;
                    }
                    f980b = null;
                    f981c = null;
                    f982d = null;
                    f983e = null;
                    f984f = null;
                    f979a = false;
                } catch (NoSuchMethodException unused5) {
                    field2 = null;
                    field3 = field2;
                    field4 = null;
                    z7 = false;
                    if (z7) {
                        f980b = method;
                        f981c = field;
                        f982d = field2;
                        f983e = field3;
                        f984f = field4;
                        f979a = true;
                        return;
                    }
                    f980b = null;
                    f981c = null;
                    f982d = null;
                    f983e = null;
                    f984f = null;
                    f979a = false;
                }
            } catch (ClassNotFoundException unused6) {
                field = null;
                field2 = field;
                field3 = field2;
                field4 = null;
                z7 = false;
                if (z7) {
                    f980b = method;
                    f981c = field;
                    f982d = field2;
                    f983e = field3;
                    f984f = field4;
                    f979a = true;
                    return;
                }
                f980b = null;
                f981c = null;
                f982d = null;
                f983e = null;
                f984f = null;
                f979a = false;
            } catch (NoSuchFieldException unused7) {
                field = null;
                field2 = field;
                field3 = field2;
                field4 = null;
                z7 = false;
                if (z7) {
                    f980b = method;
                    f981c = field;
                    f982d = field2;
                    f983e = field3;
                    f984f = field4;
                    f979a = true;
                    return;
                }
                f980b = null;
                f981c = null;
                f982d = null;
                f983e = null;
                f984f = null;
                f979a = false;
            } catch (NoSuchMethodException unused8) {
                field = null;
                field2 = field;
                field3 = field2;
                field4 = null;
                z7 = false;
                if (z7) {
                    f980b = method;
                    f981c = field;
                    f982d = field2;
                    f983e = field3;
                    f984f = field4;
                    f979a = true;
                    return;
                }
                f980b = null;
                f981c = null;
                f982d = null;
                f983e = null;
                f984f = null;
                f979a = false;
            }
        } catch (ClassNotFoundException unused9) {
            method = null;
            field = null;
        } catch (NoSuchFieldException unused10) {
            method = null;
            field = null;
        } catch (NoSuchMethodException unused11) {
            method = null;
            field = null;
        }
        if (z7) {
            f980b = method;
            f981c = field;
            f982d = field2;
            f983e = field3;
            f984f = field4;
            f979a = true;
            return;
        }
        f980b = null;
        f981c = null;
        f982d = null;
        f983e = null;
        f984f = null;
        f979a = false;
    }
}

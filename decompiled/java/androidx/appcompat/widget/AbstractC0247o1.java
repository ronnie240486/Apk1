package androidx.appcompat.widget;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import java.lang.reflect.Method;

public abstract class AbstractC0247o1 {

    public static final Method f1021a;

    public static final Method f1022b;

    public static final Method f1023c;

    public static final boolean f1024d;

    static {
        try {
            Class cls = Integer.TYPE;
            Class cls2 = Float.TYPE;
            Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, Boolean.TYPE, cls2, cls2);
            f1021a = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
            f1022b = declaredMethod2;
            declaredMethod2.setAccessible(true);
            Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
            f1023c = declaredMethod3;
            declaredMethod3.setAccessible(true);
            f1024d = true;
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
        }
    }
}

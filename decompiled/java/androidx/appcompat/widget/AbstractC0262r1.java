package androidx.appcompat.widget;

import android.widget.AbsListView;
import java.lang.reflect.Field;

public abstract class AbstractC0262r1 {

    public static final Field f1047a;

    static {
        Field declaredField = null;
        try {
            declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e5) {
            e5.printStackTrace();
        }
        f1047a = declaredField;
    }
}

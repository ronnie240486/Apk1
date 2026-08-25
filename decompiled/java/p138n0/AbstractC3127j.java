package p138n0;

import android.graphics.Rect;
import android.view.DisplayCutout;
import java.util.List;

public abstract class AbstractC3127j {
    public static DisplayCutout m6200a(Rect rect, List<Rect> list) {
        return new DisplayCutout(rect, list);
    }

    public static List<Rect> m6201b(DisplayCutout displayCutout) {
        return displayCutout.getBoundingRects();
    }

    public static int m6202c(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetBottom();
    }

    public static int m6203d(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetLeft();
    }

    public static int m6204e(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetRight();
    }

    public static int m6205f(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetTop();
    }
}

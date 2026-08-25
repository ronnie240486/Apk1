package p138n0;

import android.content.ClipData;
import android.view.PointerIcon;
import android.view.View;

public abstract class AbstractC3125i0 {
    public static void m6193a(View view) {
        view.cancelDragAndDrop();
    }

    public static void m6194b(View view) {
        view.dispatchFinishTemporaryDetach();
    }

    public static void m6195c(View view) {
        view.dispatchStartTemporaryDetach();
    }

    public static void m6196d(View view, PointerIcon pointerIcon) {
        view.setPointerIcon(pointerIcon);
    }

    public static boolean m6197e(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i6) {
        return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i6);
    }

    public static void m6198f(View view, View.DragShadowBuilder dragShadowBuilder) {
        view.updateDragShadow(dragShadowBuilder);
    }
}

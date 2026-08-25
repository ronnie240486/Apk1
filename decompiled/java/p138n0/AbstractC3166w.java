package p138n0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.PointerIcon;

public abstract class AbstractC3166w {
    public static PointerIcon m6361a(Bitmap bitmap, float f, float f3) {
        return PointerIcon.create(bitmap, f, f3);
    }

    public static PointerIcon m6362b(Context context, int i6) {
        return PointerIcon.getSystemIcon(context, i6);
    }

    public static PointerIcon m6363c(Resources resources, int i6) {
        return PointerIcon.load(resources, i6);
    }
}

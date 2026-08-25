package p151o3;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import java.util.ArrayList;
import p186r3.AbstractC3602f;

public final class C3250d {

    public static Integer f10880d;

    public final ImageView f10881a;

    public final ArrayList f10882b = new ArrayList();

    public ViewTreeObserverOnPreDrawListenerC3249c f10883c;

    public C3250d(ImageView imageView) {
        this.f10881a = imageView;
    }

    public final int m6557a(int i6, int i10, int i11) {
        int i12 = i10 - i11;
        if (i12 > 0) {
            return i12;
        }
        int i13 = i6 - i11;
        if (i13 > 0) {
            return i13;
        }
        ImageView imageView = this.f10881a;
        if (imageView.isLayoutRequested() || i10 != -2) {
            return 0;
        }
        if (Log.isLoggable("CustomViewTarget", 4)) {
            Log.i("CustomViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
        }
        Context context = imageView.getContext();
        if (f10880d == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            AbstractC3602f.m7225c(windowManager, "Argument must not be null");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            f10880d = Integer.valueOf(Math.max(point.x, point.y));
        }
        return f10880d.intValue();
    }
}

package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.ImageView;

public abstract class AbstractC0374g {
    public static ColorStateList m1126a(ImageView imageView) {
        return imageView.getImageTintList();
    }

    public static PorterDuff.Mode m1127b(ImageView imageView) {
        return imageView.getImageTintMode();
    }

    public static void m1128c(ImageView imageView, ColorStateList colorStateList) {
        imageView.setImageTintList(colorStateList);
    }

    public static void m1129d(ImageView imageView, PorterDuff.Mode mode) {
        imageView.setImageTintMode(mode);
    }
}

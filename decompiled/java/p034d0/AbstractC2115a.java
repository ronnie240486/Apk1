package p034d0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.File;

public abstract class AbstractC2115a {
    public static File m5068a(Context context) {
        return context.getCodeCacheDir();
    }

    public static Drawable m5069b(Context context, int i6) {
        return context.getDrawable(i6);
    }

    public static File m5070c(Context context) {
        return context.getNoBackupFilesDir();
    }
}

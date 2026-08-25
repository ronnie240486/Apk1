package p065g0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.core.graphics.drawable.IconCompat;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

public abstract class AbstractC2583c {
    public static int m5590a(Object obj) {
        if (Build.VERSION.SDK_INT >= 28) {
            return AbstractC2585e.m5598a(obj);
        }
        try {
            return ((Integer) obj.getClass().getMethod("getResId", null).invoke(obj, null)).intValue();
        } catch (IllegalAccessException e5) {
            Log.e("IconCompat", "Unable to get icon resource", e5);
            return 0;
        } catch (NoSuchMethodException e10) {
            Log.e("IconCompat", "Unable to get icon resource", e10);
            return 0;
        } catch (InvocationTargetException e11) {
            Log.e("IconCompat", "Unable to get icon resource", e11);
            return 0;
        }
    }

    public static String m5591b(Object obj) {
        if (Build.VERSION.SDK_INT >= 28) {
            return AbstractC2585e.m5599b(obj);
        }
        try {
            return (String) obj.getClass().getMethod("getResPackage", null).invoke(obj, null);
        } catch (IllegalAccessException e5) {
            Log.e("IconCompat", "Unable to get icon package", e5);
            return null;
        } catch (NoSuchMethodException e10) {
            Log.e("IconCompat", "Unable to get icon package", e10);
            return null;
        } catch (InvocationTargetException e11) {
            Log.e("IconCompat", "Unable to get icon package", e11);
            return null;
        }
    }

    public static int m5592c(Object obj) {
        if (Build.VERSION.SDK_INT >= 28) {
            return AbstractC2585e.m5600c(obj);
        }
        try {
            return ((Integer) obj.getClass().getMethod("getType", null).invoke(obj, null)).intValue();
        } catch (IllegalAccessException e5) {
            Log.e("IconCompat", "Unable to get icon type " + obj, e5);
            return -1;
        } catch (NoSuchMethodException e10) {
            Log.e("IconCompat", "Unable to get icon type " + obj, e10);
            return -1;
        } catch (InvocationTargetException e11) {
            Log.e("IconCompat", "Unable to get icon type " + obj, e11);
            return -1;
        }
    }

    public static Uri m5593d(Object obj) {
        if (Build.VERSION.SDK_INT >= 28) {
            return AbstractC2585e.m5601d(obj);
        }
        try {
            return (Uri) obj.getClass().getMethod("getUri", null).invoke(obj, null);
        } catch (IllegalAccessException e5) {
            Log.e("IconCompat", "Unable to get icon uri", e5);
            return null;
        } catch (NoSuchMethodException e10) {
            Log.e("IconCompat", "Unable to get icon uri", e10);
            return null;
        } catch (InvocationTargetException e11) {
            Log.e("IconCompat", "Unable to get icon uri", e11);
            return null;
        }
    }

    public static Drawable m5594e(Icon icon, Context context) {
        return icon.loadDrawable(context);
    }

    public static Icon m5595f(IconCompat iconCompat, Context context) {
        Icon iconCreateWithBitmap;
        switch (iconCompat.f1607a) {
            case -1:
                return (Icon) iconCompat.f1608b;
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f1608b);
                break;
            case 2:
                iconCreateWithBitmap = Icon.createWithResource(iconCompat.m1091h(), iconCompat.f1611e);
                break;
            case 3:
                iconCreateWithBitmap = Icon.createWithData((byte[]) iconCompat.f1608b, iconCompat.f1611e, iconCompat.f1612f);
                break;
            case 4:
                iconCreateWithBitmap = Icon.createWithContentUri((String) iconCompat.f1608b);
                break;
            case 5:
                iconCreateWithBitmap = Build.VERSION.SDK_INT < 26 ? Icon.createWithBitmap(IconCompat.m1086d((Bitmap) iconCompat.f1608b, false)) : AbstractC2584d.m5597b((Bitmap) iconCompat.f1608b);
                break;
            case 6:
                int i6 = Build.VERSION.SDK_INT;
                if (i6 >= 30) {
                    iconCreateWithBitmap = AbstractC2586f.m5602a(iconCompat.m1093k());
                } else {
                    if (context == null) {
                        throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.m1093k());
                    }
                    InputStream inputStreamM1094l = iconCompat.m1094l(context);
                    if (inputStreamM1094l == null) {
                        throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.m1093k());
                    }
                    if (i6 < 26) {
                        iconCreateWithBitmap = Icon.createWithBitmap(IconCompat.m1086d(BitmapFactory.decodeStream(inputStreamM1094l), false));
                    } else {
                        iconCreateWithBitmap = AbstractC2584d.m5597b(BitmapFactory.decodeStream(inputStreamM1094l));
                    }
                }
                break;
        }
        ColorStateList colorStateList = iconCompat.f1613g;
        if (colorStateList != null) {
            iconCreateWithBitmap.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = iconCompat.f1614h;
        if (mode != IconCompat.f1606k) {
            iconCreateWithBitmap.setTintMode(mode);
        }
        return iconCreateWithBitmap;
    }
}

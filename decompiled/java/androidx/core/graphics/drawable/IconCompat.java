package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import p065g0.AbstractC2583c;

public class IconCompat extends CustomVersionedParcelable {

    public static final PorterDuff.Mode f1606k = PorterDuff.Mode.SRC_IN;

    public int f1607a;

    public Object f1608b;

    public byte[] f1609c;

    public Parcelable f1610d;

    public int f1611e;

    public int f1612f;

    public ColorStateList f1613g;

    public PorterDuff.Mode f1614h;

    public String f1615i;

    public String f1616j;

    public IconCompat() {
        this.f1607a = -1;
        this.f1609c = null;
        this.f1610d = null;
        this.f1611e = 0;
        this.f1612f = 0;
        this.f1613g = null;
        this.f1614h = f1606k;
        this.f1615i = null;
    }

    public static IconCompat m1084b(Bundle bundle) {
        int i6 = bundle.getInt(SessionDescription.ATTR_TYPE);
        IconCompat iconCompat = new IconCompat(i6);
        iconCompat.f1611e = bundle.getInt("int1");
        iconCompat.f1612f = bundle.getInt("int2");
        iconCompat.f1616j = bundle.getString("string1");
        if (bundle.containsKey("tint_list")) {
            iconCompat.f1613g = (ColorStateList) bundle.getParcelable("tint_list");
        }
        if (bundle.containsKey("tint_mode")) {
            iconCompat.f1614h = PorterDuff.Mode.valueOf(bundle.getString("tint_mode"));
        }
        switch (i6) {
            case -1:
            case 1:
            case 5:
                iconCompat.f1608b = bundle.getParcelable("obj");
                return iconCompat;
            case 0:
            default:
                Log.w("IconCompat", "Unknown type " + i6);
                return null;
            case 2:
            case 4:
            case 6:
                iconCompat.f1608b = bundle.getString("obj");
                return iconCompat;
            case 3:
                iconCompat.f1608b = bundle.getByteArray("obj");
                return iconCompat;
        }
    }

    public static IconCompat m1085c(Icon icon) {
        icon.getClass();
        int iM5592c = AbstractC2583c.m5592c(icon);
        if (iM5592c == 2) {
            return m1087e(null, AbstractC2583c.m5591b(icon), AbstractC2583c.m5590a(icon));
        }
        if (iM5592c == 4) {
            Uri uriM5593d = AbstractC2583c.m5593d(icon);
            uriM5593d.getClass();
            String string = uriM5593d.toString();
            string.getClass();
            IconCompat iconCompat = new IconCompat(4);
            iconCompat.f1608b = string;
            return iconCompat;
        }
        if (iM5592c != 6) {
            IconCompat iconCompat2 = new IconCompat(-1);
            iconCompat2.f1608b = icon;
            return iconCompat2;
        }
        Uri uriM5593d2 = AbstractC2583c.m5593d(icon);
        uriM5593d2.getClass();
        String string2 = uriM5593d2.toString();
        string2.getClass();
        IconCompat iconCompat3 = new IconCompat(6);
        iconCompat3.f1608b = string2;
        return iconCompat3;
    }

    public static Bitmap m1086d(Bitmap bitmap, boolean z7) {
        int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        float f = iMin;
        float f3 = 0.5f * f;
        float f4 = 0.9166667f * f3;
        if (z7) {
            float f5 = 0.010416667f * f;
            paint.setColor(0);
            paint.setShadowLayer(f5, 0.0f, f * 0.020833334f, 1023410176);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.setShadowLayer(f5, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2.0f, (-(bitmap.getHeight() - iMin)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f3, f3, f4, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    public static IconCompat m1087e(Resources resources, String str, int i6) {
        str.getClass();
        if (i6 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f1611e = i6;
        if (resources != null) {
            try {
                iconCompat.f1608b = resources.getResourceName(i6);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f1608b = str;
        }
        iconCompat.f1616j = str;
        return iconCompat;
    }

    public static Resources m1088i(Context context, String str) {
        if ("android".equals(str)) {
            return Resources.getSystem();
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 8192);
            if (applicationInfo != null) {
                return packageManager.getResourcesForApplication(applicationInfo);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e5) {
            Log.e("IconCompat", "Unable to find pkg=" + str + " for icon", e5);
            return null;
        }
    }

    public final Bitmap m1089f() {
        int i6 = this.f1607a;
        if (i6 == -1 && Build.VERSION.SDK_INT >= 23) {
            Object obj = this.f1608b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        }
        if (i6 == 1) {
            return (Bitmap) this.f1608b;
        }
        if (i6 == 5) {
            return m1086d((Bitmap) this.f1608b, true);
        }
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    public final int m1090g() {
        int i6 = this.f1607a;
        if (i6 == -1 && Build.VERSION.SDK_INT >= 23) {
            return AbstractC2583c.m5590a(this.f1608b);
        }
        if (i6 == 2) {
            return this.f1611e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public final String m1091h() {
        int i6 = this.f1607a;
        if (i6 == -1 && Build.VERSION.SDK_INT >= 23) {
            return AbstractC2583c.m5591b(this.f1608b);
        }
        if (i6 == 2) {
            String str = this.f1616j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f1608b).split(":", -1)[0] : this.f1616j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public final int m1092j() {
        int i6 = this.f1607a;
        return (i6 != -1 || Build.VERSION.SDK_INT < 23) ? i6 : AbstractC2583c.m5592c(this.f1608b);
    }

    public final Uri m1093k() {
        int i6 = this.f1607a;
        if (i6 == -1 && Build.VERSION.SDK_INT >= 23) {
            return AbstractC2583c.m5593d(this.f1608b);
        }
        if (i6 == 4 || i6 == 6) {
            return Uri.parse((String) this.f1608b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public final InputStream m1094l(Context context) {
        Uri uriM1093k = m1093k();
        String scheme = uriM1093k.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(uriM1093k);
            } catch (Exception e5) {
                Log.w("IconCompat", "Unable to load image from URI: " + uriM1093k, e5);
                return null;
            }
        }
        try {
            return new FileInputStream(new File((String) this.f1608b));
        } catch (FileNotFoundException e10) {
            Log.w("IconCompat", "Unable to load image from path: " + uriM1093k, e10);
            return null;
        }
    }

    public final Bundle m1095m() {
        Bundle bundle = new Bundle();
        switch (this.f1607a) {
            case -1:
                bundle.putParcelable("obj", (Parcelable) this.f1608b);
                break;
            case 0:
            default:
                throw new IllegalArgumentException("Invalid icon");
            case 1:
            case 5:
                bundle.putParcelable("obj", (Bitmap) this.f1608b);
                break;
            case 2:
            case 4:
            case 6:
                bundle.putString("obj", (String) this.f1608b);
                break;
            case 3:
                bundle.putByteArray("obj", (byte[]) this.f1608b);
                break;
        }
        bundle.putInt(SessionDescription.ATTR_TYPE, this.f1607a);
        bundle.putInt("int1", this.f1611e);
        bundle.putInt("int2", this.f1612f);
        bundle.putString("string1", this.f1616j);
        ColorStateList colorStateList = this.f1613g;
        if (colorStateList != null) {
            bundle.putParcelable("tint_list", colorStateList);
        }
        PorterDuff.Mode mode = this.f1614h;
        if (mode != f1606k) {
            bundle.putString("tint_mode", mode.name());
        }
        return bundle;
    }

    public final Icon m1096n(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return AbstractC2583c.m5595f(this, context);
        }
        throw new UnsupportedOperationException("This method is only supported on API level 23+");
    }

    public final String toString() {
        String str;
        if (this.f1607a == -1) {
            return String.valueOf(this.f1608b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.f1607a) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = "URI";
                break;
            case 5:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = "URI_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb.append(str);
        switch (this.f1607a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f1608b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f1608b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f1616j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(m1090g())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f1611e);
                if (this.f1612f != 0) {
                    sb.append(" off=");
                    sb.append(this.f1612f);
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f1608b);
                break;
        }
        if (this.f1613g != null) {
            sb.append(" tint=");
            sb.append(this.f1613g);
        }
        if (this.f1614h != f1606k) {
            sb.append(" mode=");
            sb.append(this.f1614h);
        }
        sb.append(")");
        return sb.toString();
    }

    public IconCompat(int i6) {
        this.f1609c = null;
        this.f1610d = null;
        this.f1611e = 0;
        this.f1612f = 0;
        this.f1613g = null;
        this.f1614h = f1606k;
        this.f1615i = null;
        this.f1607a = i6;
    }
}

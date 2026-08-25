package p185r2;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import androidx.fragment.app.C0423q;
import com.p2serv.android.p032ds.R;
import java.io.Closeable;
import okhttp3.Headers;
import p103j9.AbstractC2796i;
import p130m2.ViewOnAttachStateChangeListenerC3073u;
import p140n2.C3176a;
import p140n2.EnumC3182g;
import p187r4.AbstractC3612b;
import p192r9.AbstractC3648f;
import p253x8.AbstractC4147j;

public abstract class AbstractC3587f {

    public static final Bitmap.Config[] f12065a;

    public static final Bitmap.Config f12066b;

    public static final Headers f12067c;

    static {
        int i6 = Build.VERSION.SDK_INT;
        f12065a = i6 >= 26 ? new Bitmap.Config[]{Bitmap.Config.ARGB_8888, Bitmap.Config.RGBA_F16} : new Bitmap.Config[]{Bitmap.Config.ARGB_8888};
        f12066b = i6 >= 26 ? Bitmap.Config.HARDWARE : Bitmap.Config.ARGB_8888;
        f12067c = new Headers.Builder().build();
    }

    public static final void m7208a(Closeable closeable) {
        try {
            closeable.close();
        } catch (RuntimeException e5) {
            throw e5;
        } catch (Exception unused) {
        }
    }

    public static final String m7209b(MimeTypeMap mimeTypeMap, String str) {
        if (str == null || AbstractC3648f.m7383e0(str)) {
            return null;
        }
        String strM7390l0 = AbstractC3648f.m7390l0(AbstractC3648f.m7390l0(str, '#'), '?');
        return mimeTypeMap.getMimeTypeFromExtension(AbstractC3648f.m7389k0('.', AbstractC3648f.m7389k0('/', strM7390l0, strM7390l0), ""));
    }

    public static final ViewOnAttachStateChangeListenerC3073u m7210c(ImageView imageView) {
        Object tag = imageView.getTag(R.id.coil_request_manager);
        ViewOnAttachStateChangeListenerC3073u viewOnAttachStateChangeListenerC3073u = tag instanceof ViewOnAttachStateChangeListenerC3073u ? (ViewOnAttachStateChangeListenerC3073u) tag : null;
        if (viewOnAttachStateChangeListenerC3073u == null) {
            synchronized (imageView) {
                try {
                    Object tag2 = imageView.getTag(R.id.coil_request_manager);
                    ViewOnAttachStateChangeListenerC3073u viewOnAttachStateChangeListenerC3073u2 = tag2 instanceof ViewOnAttachStateChangeListenerC3073u ? (ViewOnAttachStateChangeListenerC3073u) tag2 : null;
                    if (viewOnAttachStateChangeListenerC3073u2 != null) {
                        viewOnAttachStateChangeListenerC3073u = viewOnAttachStateChangeListenerC3073u2;
                    } else {
                        viewOnAttachStateChangeListenerC3073u = new ViewOnAttachStateChangeListenerC3073u(imageView);
                        imageView.addOnAttachStateChangeListener(viewOnAttachStateChangeListenerC3073u);
                        imageView.setTag(R.id.coil_request_manager, viewOnAttachStateChangeListenerC3073u);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return viewOnAttachStateChangeListenerC3073u;
    }

    public static final boolean m7211d(Uri uri) {
        return AbstractC2796i.m5780a(uri.getScheme(), "file") && AbstractC2796i.m5780a((String) AbstractC4147j.m8182V(uri.getPathSegments()), "android_asset");
    }

    public static final int m7212e(AbstractC3612b abstractC3612b, EnumC3182g enumC3182g) {
        if (abstractC3612b instanceof C3176a) {
            return ((C3176a) abstractC3612b).f10667c;
        }
        int iOrdinal = enumC3182g.ordinal();
        if (iOrdinal == 0) {
            return Integer.MIN_VALUE;
        }
        if (iOrdinal == 1) {
            return Integer.MAX_VALUE;
        }
        throw new C0423q(13);
    }
}

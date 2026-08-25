package p068g3;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import java.util.List;
import p156o9.AbstractC3280d;
import p228v2.C3980g;
import p228v2.C3981h;
import p228v2.InterfaceC3983j;
import p247x2.InterfaceC4102x;

public final class C2610d implements InterfaceC3983j {

    public static final C3980g f9082b = new C3980g("com.bumptech.glide.load.resource.bitmap.Downsampler.Theme", null, C3980g.f13510e);

    public final Context f9083a;

    public C2610d(Context context) {
        this.f9083a = context.getApplicationContext();
    }

    @Override
    public final InterfaceC4102x mo5398a(Object obj, int i6, int i10, C3981h c3981h) {
        return m5624c((Uri) obj, c3981h);
    }

    @Override
    public final boolean mo5399b(Object obj, C3981h c3981h) {
        String scheme = ((Uri) obj).getScheme();
        return scheme != null && scheme.equals("android.resource");
    }

    public final InterfaceC4102x m5624c(Uri uri, C3981h c3981h) {
        Context contextCreatePackageContext;
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new IllegalStateException("Package name for " + uri + " is null or empty");
        }
        Context context = this.f9083a;
        if (authority.equals(context.getPackageName())) {
            contextCreatePackageContext = context;
        } else {
            try {
                contextCreatePackageContext = context.createPackageContext(authority, 0);
            } catch (PackageManager.NameNotFoundException e5) {
                if (!authority.contains(context.getPackageName())) {
                    throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e5);
                }
                contextCreatePackageContext = context;
            }
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            List<String> pathSegments2 = uri.getPathSegments();
            String authority2 = uri.getAuthority();
            String str = pathSegments2.get(0);
            String str2 = pathSegments2.get(1);
            identifier = contextCreatePackageContext.getResources().getIdentifier(str2, str, authority2);
            if (identifier == 0) {
                identifier = Resources.getSystem().getIdentifier(str2, str, "android");
            }
            if (identifier == 0) {
                throw new IllegalArgumentException("Failed to find resource id for: " + uri);
            }
        } else {
            if (pathSegments.size() != 1) {
                throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
            }
            try {
                identifier = Integer.parseInt(uri.getPathSegments().get(0));
            } catch (NumberFormatException e10) {
                throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e10);
            }
        }
        Resources.Theme theme = authority.equals(context.getPackageName()) ? (Resources.Theme) c3981h.m7967c(f9082b) : null;
        Drawable drawableM6596n = theme == null ? AbstractC3280d.m6596n(context, contextCreatePackageContext, identifier, null) : AbstractC3280d.m6596n(context, context, identifier, theme);
        if (drawableM6596n != null) {
            return new C2609c(drawableM6596n, 0);
        }
        return null;
    }
}

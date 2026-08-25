package p096j2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.List;
import okhttp3.HttpUrl;
import p103j9.AbstractC2796i;
import p130m2.C3065m;
import p156o9.AbstractC3280d;
import p185r2.AbstractC3587f;
import p192r9.AbstractC3648f;
import p253x8.AbstractC4147j;

public final class C2769a {

    public final int f9483a;

    public C2769a(int i6) {
        this.f9483a = i6;
    }

    public final Object m5741a(Object obj, C3065m c3065m) throws PackageManager.NameNotFoundException {
        String authority;
        switch (this.f9483a) {
            case 0:
                return ByteBuffer.wrap((byte[]) obj);
            case 1:
                Uri uri = (Uri) obj;
                if (AbstractC3587f.m7211d(uri)) {
                    return null;
                }
                String scheme = uri.getScheme();
                if (scheme != null && !scheme.equals("file")) {
                    return null;
                }
                String path = uri.getPath();
                if (path == null) {
                    path = "";
                }
                if (path.length() <= 0 || !AbstractC3280d.m6592j(path.charAt(0), '/', false) || ((String) AbstractC4147j.m8182V(uri.getPathSegments())) == null) {
                    return null;
                }
                if (!AbstractC2796i.m5780a(uri.getScheme(), "file")) {
                    return new File(uri.toString());
                }
                String path2 = uri.getPath();
                if (path2 != null) {
                    return new File(path2);
                }
                return null;
            case 2:
                return ((HttpUrl) obj).toString();
            case 3:
                Context context = c3065m.f10496a;
                int iIntValue = ((Number) obj).intValue();
                try {
                    if (context.getResources().getResourceEntryName(iIntValue) != null) {
                        return Uri.parse("android.resource://" + context.getPackageName() + '/' + iIntValue);
                    }
                } catch (Resources.NotFoundException unused) {
                }
                return null;
            case 4:
                Uri uri2 = (Uri) obj;
                if (!AbstractC2796i.m5780a(uri2.getScheme(), "android.resource") || (authority = uri2.getAuthority()) == null || AbstractC3648f.m7383e0(authority) || uri2.getPathSegments().size() != 2) {
                    return null;
                }
                String authority2 = uri2.getAuthority();
                if (authority2 == null) {
                    authority2 = "";
                }
                Resources resourcesForApplication = c3065m.f10496a.getPackageManager().getResourcesForApplication(authority2);
                List<String> pathSegments = uri2.getPathSegments();
                int identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority2);
                if (identifier == 0) {
                    throw new IllegalStateException(("Invalid android.resource URI: " + uri2).toString());
                }
                return Uri.parse("android.resource://" + authority2 + '/' + identifier);
            default:
                return Uri.parse((String) obj);
        }
    }
}

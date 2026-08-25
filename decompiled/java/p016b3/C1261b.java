package p016b3;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.load.data.C1485k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import p068g3.C2610d;
import p175q3.C3470d;
import p187r4.C3621k;
import p228v2.C3981h;
import p228v2.InterfaceC3978e;

public final class C1261b implements InterfaceC1288u {

    public final int f3990a;

    public final Object f3991b;

    public final Object f3992c;

    public C1261b(Object obj, int i6, Object obj2) {
        this.f3990a = i6;
        this.f3992c = obj;
        this.f3991b = obj2;
    }

    @Override
    public final C1287t mo3137a(Object obj, int i6, int i10, C3981h c3981h) {
        C1485k c1485k;
        C1287t c1287tMo3137a;
        Uri uri;
        switch (this.f3990a) {
            case 0:
                Uri uri2 = (Uri) obj;
                String strSubstring = uri2.toString().substring(22);
                C3470d c3470d = new C3470d(uri2);
                Object obj2 = this.f3991b;
                AssetManager assetManager = (AssetManager) this.f3992c;
                switch (((C1259a) obj2).f3985a) {
                    case 0:
                        c1485k = new C1485k(assetManager, strSubstring, 0);
                        break;
                    default:
                        c1485k = new C1485k(assetManager, strSubstring, 1);
                        break;
                }
                return new C1287t(c3470d, c1485k);
            case 1:
                Integer num = (Integer) obj;
                Resources.Theme theme = (Resources.Theme) c3981h.m7967c(C2610d.f9082b);
                return new C1287t(new C3470d(num), new C1275i(theme, theme != null ? theme.getResources() : ((Context) this.f3992c).getResources(), (C1273h) this.f3991b, num.intValue()));
            case 2:
                ArrayList arrayList = (ArrayList) this.f3992c;
                int size = arrayList.size();
                ArrayList arrayList2 = new ArrayList(size);
                InterfaceC3978e interfaceC3978e = null;
                for (int i11 = 0; i11 < size; i11++) {
                    InterfaceC1288u interfaceC1288u = (InterfaceC1288u) arrayList.get(i11);
                    if (interfaceC1288u.mo3138b(obj) && (c1287tMo3137a = interfaceC1288u.mo3137a(obj, i6, i10, c3981h)) != null) {
                        arrayList2.add(c1287tMo3137a.f4054c);
                        interfaceC3978e = c1287tMo3137a.f4052a;
                    }
                }
                if (arrayList2.isEmpty() || interfaceC3978e == null) {
                    return null;
                }
                return new C1287t(interfaceC3978e, new C1293z(arrayList2, (C3621k) this.f3991b));
            case 3:
                Integer num2 = (Integer) obj;
                Resources resources = (Resources) this.f3991b;
                try {
                    uri = Uri.parse("android.resource://" + resources.getResourcePackageName(num2.intValue()) + '/' + resources.getResourceTypeName(num2.intValue()) + '/' + resources.getResourceEntryName(num2.intValue()));
                    break;
                } catch (Resources.NotFoundException e5) {
                    if (Log.isLoggable("ResourceLoader", 5)) {
                        Log.w("ResourceLoader", "Received invalid resource id: " + num2, e5);
                    }
                    uri = null;
                }
                if (uri == null) {
                    return null;
                }
                return ((InterfaceC1288u) this.f3992c).mo3137a(uri, i6, i10, c3981h);
            default:
                Uri uri3 = (Uri) obj;
                List<String> pathSegments = uri3.getPathSegments();
                int size2 = pathSegments.size();
                InterfaceC1288u interfaceC1288u2 = (InterfaceC1288u) this.f3991b;
                C1287t c1287tMo3137a2 = null;
                if (size2 == 1) {
                    try {
                        int i12 = Integer.parseInt(uri3.getPathSegments().get(0));
                        if (i12 != 0) {
                            c1287tMo3137a2 = interfaceC1288u2.mo3137a(Integer.valueOf(i12), i6, i10, c3981h);
                        } else if (Log.isLoggable("ResourceUriLoader", 5)) {
                            Log.w("ResourceUriLoader", "Failed to parse a valid non-0 resource id from: " + uri3);
                        }
                        return c1287tMo3137a2;
                    } catch (NumberFormatException e10) {
                        if (!Log.isLoggable("ResourceUriLoader", 5)) {
                            return c1287tMo3137a2;
                        }
                        Log.w("ResourceUriLoader", "Failed to parse resource id from: " + uri3, e10);
                        return c1287tMo3137a2;
                    }
                }
                if (pathSegments.size() != 2) {
                    if (!Log.isLoggable("ResourceUriLoader", 5)) {
                        return null;
                    }
                    Log.w("ResourceUriLoader", "Failed to parse resource uri: " + uri3);
                    return null;
                }
                List<String> pathSegments2 = uri3.getPathSegments();
                String str = pathSegments2.get(0);
                String str2 = pathSegments2.get(1);
                Context context = (Context) this.f3992c;
                int identifier = context.getResources().getIdentifier(str2, str, context.getPackageName());
                if (identifier != 0) {
                    return interfaceC1288u2.mo3137a(Integer.valueOf(identifier), i6, i10, c3981h);
                }
                if (!Log.isLoggable("ResourceUriLoader", 5)) {
                    return null;
                }
                Log.w("ResourceUriLoader", "Failed to find resource id for: " + uri3);
                return null;
        }
    }

    @Override
    public final boolean mo3138b(Object obj) {
        switch (this.f3990a) {
            case 0:
                Uri uri = (Uri) obj;
                return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
            case 1:
                return true;
            case 2:
                Iterator it = ((ArrayList) this.f3992c).iterator();
                while (it.hasNext()) {
                    if (((InterfaceC1288u) it.next()).mo3138b(obj)) {
                        return true;
                    }
                }
                return false;
            case 3:
                return true;
            default:
                Uri uri2 = (Uri) obj;
                return "android.resource".equals(uri2.getScheme()) && ((Context) this.f3992c).getPackageName().equals(uri2.getAuthority());
        }
    }

    public String toString() {
        switch (this.f3990a) {
            case 2:
                return "MultiModelLoader{modelLoaders=" + Arrays.toString(((ArrayList) this.f3992c).toArray()) + '}';
            default:
                return super.toString();
        }
    }

    public C1261b(Resources resources, InterfaceC1288u interfaceC1288u) {
        this.f3990a = 3;
        this.f3991b = resources;
        this.f3992c = interfaceC1288u;
    }

    public C1261b(Context context, C1273h c1273h) {
        this.f3990a = 1;
        this.f3992c = context.getApplicationContext();
        this.f3991b = c1273h;
    }

    public C1261b(Context context, InterfaceC1288u interfaceC1288u) {
        this.f3990a = 4;
        this.f3992c = context.getApplicationContext();
        this.f3991b = interfaceC1288u;
    }
}

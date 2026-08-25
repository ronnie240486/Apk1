package p016b3;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.net.URL;
import p228v2.C3981h;

public final class C1266d0 implements InterfaceC1288u {

    public final int f4004a;

    public final InterfaceC1288u f4005b;

    public C1266d0(InterfaceC1288u interfaceC1288u, int i6) {
        this.f4004a = i6;
        this.f4005b = interfaceC1288u;
    }

    @Override
    public final C1287t mo3137a(Object obj, int i6, int i10, C3981h c3981h) {
        Uri uriFromFile;
        switch (this.f4004a) {
            case 0:
                String str = (String) obj;
                if (TextUtils.isEmpty(str)) {
                    uriFromFile = null;
                } else if (str.charAt(0) == '/') {
                    uriFromFile = Uri.fromFile(new File(str));
                } else {
                    Uri uri = Uri.parse(str);
                    uriFromFile = uri.getScheme() == null ? Uri.fromFile(new File(str)) : uri;
                }
                if (uriFromFile == null) {
                    return null;
                }
                InterfaceC1288u interfaceC1288u = this.f4005b;
                if (interfaceC1288u.mo3138b(uriFromFile)) {
                    return interfaceC1288u.mo3137a(uriFromFile, i6, i10, c3981h);
                }
                return null;
            default:
                return this.f4005b.mo3137a(new C1278k((URL) obj), i6, i10, c3981h);
        }
    }

    @Override
    public final boolean mo3138b(Object obj) {
        switch (this.f4004a) {
            case 0:
                break;
            default:
                break;
        }
        return true;
    }
}

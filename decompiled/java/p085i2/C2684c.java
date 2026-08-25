package p085i2;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import p103j9.AbstractC2796i;
import p130m2.C3065m;
import p185r2.AbstractC3587f;

public final class C2684c implements InterfaceC2683b {
    @Override
    public final String mo5684a(Object obj, C3065m c3065m) {
        Uri uri = (Uri) obj;
        if (!AbstractC2796i.m5780a(uri.getScheme(), "android.resource")) {
            return uri.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(uri);
        sb.append('-');
        Configuration configuration = c3065m.f10496a.getResources().getConfiguration();
        Bitmap.Config[] configArr = AbstractC3587f.f12065a;
        sb.append(configuration.uiMode & 48);
        return sb.toString();
    }
}

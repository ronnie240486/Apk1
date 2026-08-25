package p067g2;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.io.File;
import java.nio.ByteBuffer;
import p103j9.AbstractC2796i;
import p130m2.C3065m;
import p185r2.AbstractC3587f;

public final class C2594a implements InterfaceC2599f {

    public final int f9045a;

    public C2594a(int i6) {
        this.f9045a = i6;
    }

    @Override
    public final InterfaceC2600g mo5614a(Object obj, C3065m c3065m) {
        switch (this.f9045a) {
            case 0:
                Uri uri = (Uri) obj;
                if (AbstractC3587f.m7211d(uri)) {
                    return new C2595b(uri, c3065m, 0);
                }
                return null;
            case 1:
                return new C2596c((Bitmap) obj, c3065m, 0);
            case 2:
                return new C2596c((ByteBuffer) obj, c3065m, 1);
            case 3:
                Uri uri2 = (Uri) obj;
                if (AbstractC2796i.m5780a(uri2.getScheme(), "content")) {
                    return new C2595b(uri2, c3065m, 1);
                }
                return null;
            case 4:
                return new C2596c((Drawable) obj, c3065m, 2);
            case 5:
                return new C2601h((File) obj);
            default:
                Uri uri3 = (Uri) obj;
                if (AbstractC2796i.m5780a(uri3.getScheme(), "android.resource")) {
                    return new C2595b(uri3, c3065m, 2);
                }
                return null;
        }
    }
}

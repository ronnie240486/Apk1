package p016b3;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.AbstractC1465c;
import p049e3.C2388f0;
import p175q3.C3470d;
import p228v2.C3981h;
import p239w2.C4048a;

public final class C1284q implements InterfaceC1288u {

    public final int f4048a;

    public final Context f4049b;

    public C1284q(Context context, int i6) {
        this.f4048a = i6;
        switch (i6) {
            case 1:
                this.f4049b = context.getApplicationContext();
                break;
            case 2:
                this.f4049b = context.getApplicationContext();
                break;
            default:
                this.f4049b = context;
                break;
        }
    }

    @Override
    public final C1287t mo3137a(Object obj, int i6, int i10, C3981h c3981h) {
        Long l9;
        switch (this.f4048a) {
            case 0:
                Uri uri = (Uri) obj;
                return new C1287t(new C3470d(uri), new C1283p(this.f4049b, 0, uri));
            case 1:
                Uri uri2 = (Uri) obj;
                if (i6 == Integer.MIN_VALUE || i10 == Integer.MIN_VALUE || i6 > 512 || i10 > 384) {
                    return null;
                }
                C3470d c3470d = new C3470d(uri2);
                Context context = this.f4049b;
                return new C1287t(c3470d, C1269f.m3155c(context, uri2, new C4048a(context.getContentResolver(), 0)));
            default:
                Uri uri3 = (Uri) obj;
                if (i6 == Integer.MIN_VALUE || i10 == Integer.MIN_VALUE || i6 > 512 || i10 > 384 || (l9 = (Long) c3981h.m7967c(C2388f0.f8342d)) == null || l9.longValue() != -1) {
                    return null;
                }
                C3470d c3470d2 = new C3470d(uri3);
                Context context2 = this.f4049b;
                return new C1287t(c3470d2, C1269f.m3155c(context2, uri3, new C4048a(context2.getContentResolver(), 1)));
        }
    }

    @Override
    public final boolean mo3138b(Object obj) {
        switch (this.f4048a) {
            case 0:
                return AbstractC1465c.m3474i((Uri) obj);
            case 1:
                Uri uri = (Uri) obj;
                return AbstractC1465c.m3474i(uri) && !uri.getPathSegments().contains("video");
            default:
                Uri uri2 = (Uri) obj;
                return AbstractC1465c.m3474i(uri2) && uri2.getPathSegments().contains("video");
        }
    }
}

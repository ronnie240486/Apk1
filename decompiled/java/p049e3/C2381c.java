package p049e3;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.support.v4.media.session.AbstractC0120b;
import android.util.Log;
import java.io.IOException;
import p037d3.C2149b;
import p173q1.C3406f0;
import p208t2.C3803d;
import p228v2.C3981h;
import p228v2.InterfaceC3983j;
import p247x2.InterfaceC4102x;
import p259y2.InterfaceC4238a;

public final class C2381c implements InterfaceC3983j {

    public final int f8334a;

    public final InterfaceC4238a f8335b;

    public C2381c() {
        this.f8334a = 0;
        this.f8335b = new C3406f0(10);
    }

    @Override
    public final InterfaceC4102x mo5398a(Object obj, int i6, int i10, C3981h c3981h) {
        switch (this.f8334a) {
            case 0:
                return m5406c(AbstractC0120b.m335g(obj), i6, i10, c3981h);
            default:
                return C2383d.m5410b(((C3803d) obj).m7578b(), this.f8335b);
        }
    }

    @Override
    public final boolean mo5399b(Object obj, C3981h c3981h) {
        switch (this.f8334a) {
            case 0:
                AbstractC0120b.m351w(obj);
                break;
            default:
                break;
        }
        return true;
    }

    public C2383d m5406c(ImageDecoder.Source source, int i6, int i10, C3981h c3981h) throws IOException {
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, new C2149b(i6, i10, c3981h));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            Log.v("BitmapImageDecoder", "Decoded [" + bitmapDecodeBitmap.getWidth() + "x" + bitmapDecodeBitmap.getHeight() + "] for [" + i6 + "x" + i10 + "]");
        }
        return new C2383d(bitmapDecodeBitmap, (C3406f0) this.f8335b);
    }

    public C2381c(InterfaceC4238a interfaceC4238a) {
        this.f8334a = 1;
        this.f8335b = interfaceC4238a;
    }
}

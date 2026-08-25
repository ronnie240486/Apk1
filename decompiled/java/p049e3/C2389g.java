package p049e3;

import android.graphics.ImageDecoder;
import java.io.InputStream;
import java.nio.ByteBuffer;
import p186r3.AbstractC3597a;
import p228v2.C3981h;
import p228v2.InterfaceC3983j;
import p247x2.InterfaceC4102x;

public final class C2389g implements InterfaceC3983j {

    public final int f8349a;

    public final C2381c f8350b;

    public C2389g(int i6) {
        this.f8349a = i6;
        switch (i6) {
            case 1:
                this.f8350b = new C2381c();
                break;
            default:
                this.f8350b = new C2381c();
                break;
        }
    }

    @Override
    public final InterfaceC4102x mo5398a(Object obj, int i6, int i10, C3981h c3981h) {
        switch (this.f8349a) {
            case 0:
                return this.f8350b.m5406c(ImageDecoder.createSource((ByteBuffer) obj), i6, i10, c3981h);
            default:
                return this.f8350b.m5406c(ImageDecoder.createSource(AbstractC3597a.m7218b((InputStream) obj)), i6, i10, c3981h);
        }
    }

    @Override
    public final boolean mo5399b(Object obj, C3981h c3981h) {
        switch (this.f8349a) {
            case 0:
                break;
            default:
                break;
        }
        return true;
    }
}

package p049e3;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.io.File;
import p068g3.C2609c;
import p228v2.C3981h;
import p228v2.InterfaceC3983j;
import p247x2.InterfaceC4102x;

public final class C2380b0 implements InterfaceC3983j {

    public final int f8333a;

    public C2380b0(int i6) {
        this.f8333a = i6;
    }

    @Override
    public final InterfaceC4102x mo5398a(Object obj, int i6, int i10, C3981h c3981h) {
        switch (this.f8333a) {
            case 0:
                return new C2378a0(0, (Bitmap) obj);
            case 1:
                Drawable drawable = (Drawable) obj;
                if (drawable != null) {
                    return new C2609c(drawable, 0);
                }
                return null;
            default:
                return new C2378a0((File) obj);
        }
    }

    @Override
    public final boolean mo5399b(Object obj, C3981h c3981h) {
        switch (this.f8333a) {
            case 0:
                break;
            case 1:
                break;
            default:
                break;
        }
        return true;
    }
}

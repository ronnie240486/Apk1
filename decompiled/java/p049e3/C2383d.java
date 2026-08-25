package p049e3;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import p186r3.AbstractC3602f;
import p186r3.AbstractC3610n;
import p247x2.InterfaceC4099u;
import p247x2.InterfaceC4102x;
import p259y2.InterfaceC4238a;

public final class C2383d implements InterfaceC4102x, InterfaceC4099u {

    public final int f8336a = 1;

    public final Object f8337b;

    public final Object f8338c;

    public C2383d(Bitmap bitmap, InterfaceC4238a interfaceC4238a) {
        AbstractC3602f.m7225c(bitmap, "Bitmap must not be null");
        this.f8337b = bitmap;
        AbstractC3602f.m7225c(interfaceC4238a, "BitmapPool must not be null");
        this.f8338c = interfaceC4238a;
    }

    public static C2383d m5410b(Bitmap bitmap, InterfaceC4238a interfaceC4238a) {
        if (bitmap == null) {
            return null;
        }
        return new C2383d(bitmap, interfaceC4238a);
    }

    @Override
    public final int mo5403a() {
        switch (this.f8336a) {
            case 0:
                return AbstractC3610n.m7235c((Bitmap) this.f8337b);
            default:
                return ((InterfaceC4102x) this.f8338c).mo5403a();
        }
    }

    @Override
    public final Class mo5404c() {
        switch (this.f8336a) {
            case 0:
                return Bitmap.class;
            default:
                return BitmapDrawable.class;
        }
    }

    @Override
    public final void mo5405d() {
        switch (this.f8336a) {
            case 0:
                ((InterfaceC4238a) this.f8338c).mo5434f((Bitmap) this.f8337b);
                break;
            default:
                ((InterfaceC4102x) this.f8338c).mo5405d();
                break;
        }
    }

    @Override
    public final Object get() {
        switch (this.f8336a) {
            case 0:
                return (Bitmap) this.f8337b;
            default:
                return new BitmapDrawable((Resources) this.f8337b, (Bitmap) ((InterfaceC4102x) this.f8338c).get());
        }
    }

    @Override
    public final void initialize() {
        switch (this.f8336a) {
            case 0:
                ((Bitmap) this.f8337b).prepareToDraw();
                break;
            default:
                InterfaceC4102x interfaceC4102x = (InterfaceC4102x) this.f8338c;
                if (interfaceC4102x instanceof InterfaceC4099u) {
                    ((InterfaceC4099u) interfaceC4102x).initialize();
                }
                break;
        }
    }

    public C2383d(Resources resources, InterfaceC4102x interfaceC4102x) {
        AbstractC3602f.m7225c(resources, "Argument must not be null");
        this.f8337b = resources;
        AbstractC3602f.m7225c(interfaceC4102x, "Argument must not be null");
        this.f8338c = interfaceC4102x;
    }
}

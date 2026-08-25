package p049e3;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.ComponentCallbacks2C1464b;
import p186r3.AbstractC3610n;
import p228v2.InterfaceC3985l;
import p247x2.InterfaceC4102x;
import p259y2.InterfaceC4238a;

public abstract class AbstractC2385e implements InterfaceC3985l {
    @Override
    public final InterfaceC4102x mo5086b(Context context, InterfaceC4102x interfaceC4102x, int i6, int i10) {
        if (!AbstractC3610n.m7241i(i6, i10)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i6 + " or height: " + i10 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        InterfaceC4238a interfaceC4238a = ComponentCallbacks2C1464b.m3461a(context).f4406a;
        Bitmap bitmap = (Bitmap) interfaceC4102x.get();
        if (i6 == Integer.MIN_VALUE) {
            i6 = bitmap.getWidth();
        }
        if (i10 == Integer.MIN_VALUE) {
            i10 = bitmap.getHeight();
        }
        Bitmap bitmapMo5411c = mo5411c(interfaceC4238a, bitmap, i6, i10);
        return bitmap.equals(bitmapMo5411c) ? interfaceC4102x : C2383d.m5410b(bitmapMo5411c, interfaceC4238a);
    }

    public abstract Bitmap mo5411c(InterfaceC4238a interfaceC4238a, Bitmap bitmap, int i6, int i10);
}

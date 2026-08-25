package p049e3;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.ComponentCallbacks2C1464b;
import java.security.MessageDigest;
import p228v2.InterfaceC3985l;
import p247x2.InterfaceC4102x;
import p259y2.InterfaceC4238a;

public final class C2401s implements InterfaceC3985l {

    public final InterfaceC3985l f8378b;

    public final boolean f8379c;

    public C2401s(InterfaceC3985l interfaceC3985l, boolean z7) {
        this.f8378b = interfaceC3985l;
        this.f8379c = z7;
    }

    @Override
    public final void mo3160a(MessageDigest messageDigest) {
        this.f8378b.mo3160a(messageDigest);
    }

    @Override
    public final InterfaceC4102x mo5086b(Context context, InterfaceC4102x interfaceC4102x, int i6, int i10) {
        InterfaceC4238a interfaceC4238a = ComponentCallbacks2C1464b.m3461a(context).f4406a;
        Drawable drawable = (Drawable) interfaceC4102x.get();
        C2383d c2383dM5435a = AbstractC2400r.m5435a(interfaceC4238a, drawable, i6, i10);
        if (c2383dM5435a != null) {
            InterfaceC4102x interfaceC4102xMo5086b = this.f8378b.mo5086b(context, c2383dM5435a, i6, i10);
            if (!interfaceC4102xMo5086b.equals(c2383dM5435a)) {
                return new C2383d(context.getResources(), interfaceC4102xMo5086b);
            }
            interfaceC4102xMo5086b.mo5405d();
            return interfaceC4102x;
        }
        if (!this.f8379c) {
            return interfaceC4102x;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj instanceof C2401s) {
            return this.f8378b.equals(((C2401s) obj).f8378b);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.f8378b.hashCode();
    }
}

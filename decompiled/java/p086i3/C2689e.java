package p086i3;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.ComponentCallbacks2C1464b;
import java.security.MessageDigest;
import p049e3.C2383d;
import p186r3.AbstractC3602f;
import p228v2.InterfaceC3985l;
import p247x2.InterfaceC4102x;

public final class C2689e implements InterfaceC3985l {

    public final InterfaceC3985l f9347b;

    public C2689e(InterfaceC3985l interfaceC3985l) {
        AbstractC3602f.m7225c(interfaceC3985l, "Argument must not be null");
        this.f9347b = interfaceC3985l;
    }

    @Override
    public final void mo3160a(MessageDigest messageDigest) {
        this.f9347b.mo3160a(messageDigest);
    }

    @Override
    public final InterfaceC4102x mo5086b(Context context, InterfaceC4102x interfaceC4102x, int i6, int i10) {
        C2688d c2688d = (C2688d) interfaceC4102x.get();
        InterfaceC4102x c2383d = new C2383d(((C2693i) c2688d.f9337a.f9336b).f9365l, ComponentCallbacks2C1464b.m3461a(context).f4406a);
        InterfaceC3985l interfaceC3985l = this.f9347b;
        InterfaceC4102x interfaceC4102xMo5086b = interfaceC3985l.mo5086b(context, c2383d, i6, i10);
        if (!c2383d.equals(interfaceC4102xMo5086b)) {
            c2383d.mo5405d();
        }
        ((C2693i) c2688d.f9337a.f9336b).m5693c(interfaceC3985l, (Bitmap) interfaceC4102xMo5086b.get());
        return interfaceC4102x;
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj instanceof C2689e) {
            return this.f9347b.equals(((C2689e) obj).f9347b);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.f9347b.hashCode();
    }
}

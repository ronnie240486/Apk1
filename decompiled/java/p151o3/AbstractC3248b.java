package p151o3;

import android.graphics.drawable.Drawable;
import p141n3.C3192f;
import p141n3.InterfaceC3189c;
import p186r3.AbstractC3610n;

public abstract class AbstractC3248b implements InterfaceC3254h {

    public final int f10875a;

    public final int f10876b;

    public InterfaceC3189c f10877c;

    public AbstractC3248b() {
        if (!AbstractC3610n.m7241i(Integer.MIN_VALUE, Integer.MIN_VALUE)) {
            throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: -2147483648 and height: -2147483648");
        }
        this.f10875a = Integer.MIN_VALUE;
        this.f10876b = Integer.MIN_VALUE;
    }

    @Override
    public final void mo3557a(InterfaceC3189c interfaceC3189c) {
        this.f10877c = interfaceC3189c;
    }

    @Override
    public final void mo3562f(C3192f c3192f) {
        c3192f.m6418m(this.f10875a, this.f10876b);
    }

    @Override
    public final InterfaceC3189c getRequest() {
        return this.f10877c;
    }

    @Override
    public final void mo3559c() {
    }

    @Override
    public final void mo3565i() {
    }

    @Override
    public final void mo3566j() {
    }

    @Override
    public final void mo3558b(Drawable drawable) {
    }

    @Override
    public final void mo3561e(C3192f c3192f) {
    }

    @Override
    public final void mo3563g(Drawable drawable) {
    }
}

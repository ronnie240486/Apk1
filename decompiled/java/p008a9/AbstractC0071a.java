package p008a9;

import com.bumptech.glide.AbstractC1466d;
import p091i9.InterfaceC2728p;

public abstract class AbstractC0071a implements InterfaceC0077g {

    public final InterfaceC0078h f201a;

    public AbstractC0071a(InterfaceC0078h interfaceC0078h) {
        this.f201a = interfaceC0078h;
    }

    @Override
    public final Object mo250a(Object obj, InterfaceC2728p interfaceC2728p) {
        return interfaceC2728p.invoke(obj, this);
    }

    @Override
    public InterfaceC0079i mo251c(InterfaceC0078h interfaceC0078h) {
        return AbstractC1466d.m3504x(this, interfaceC0078h);
    }

    @Override
    public InterfaceC0077g mo252e(InterfaceC0078h interfaceC0078h) {
        return AbstractC1466d.m3491i(this, interfaceC0078h);
    }

    @Override
    public final InterfaceC0079i mo253f(InterfaceC0079i interfaceC0079i) {
        return AbstractC1466d.m3482A(this, interfaceC0079i);
    }

    @Override
    public final InterfaceC0078h getKey() {
        return this.f201a;
    }
}

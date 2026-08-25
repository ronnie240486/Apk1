package p008a9;

import com.lzy.okgo.cache.CacheEntity;
import java.io.Serializable;
import p091i9.InterfaceC2728p;
import p103j9.AbstractC2796i;

public final class C0080j implements InterfaceC0079i, Serializable {

    public static final C0080j f206a = new C0080j();

    @Override
    public final InterfaceC0079i mo251c(InterfaceC0078h interfaceC0078h) {
        AbstractC2796i.m5785f(interfaceC0078h, CacheEntity.KEY);
        return this;
    }

    @Override
    public final InterfaceC0077g mo252e(InterfaceC0078h interfaceC0078h) {
        AbstractC2796i.m5785f(interfaceC0078h, CacheEntity.KEY);
        return null;
    }

    @Override
    public final InterfaceC0079i mo253f(InterfaceC0079i interfaceC0079i) {
        AbstractC2796i.m5785f(interfaceC0079i, "context");
        return interfaceC0079i;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }

    @Override
    public final Object mo250a(Object obj, InterfaceC2728p interfaceC2728p) {
        return obj;
    }
}

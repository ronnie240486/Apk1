package p135m8;

import com.bumptech.glide.AbstractC1466d;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import p102j8.InterfaceC2787b;
import p114k8.C2904d;

public final class EnumC3085a implements InterfaceC2787b {

    public static final EnumC3085a f10547a;

    public static final EnumC3085a[] f10548b;

    static {
        EnumC3085a enumC3085a = new EnumC3085a("DISPOSED", 0);
        f10547a = enumC3085a;
        f10548b = new EnumC3085a[]{enumC3085a};
    }

    public static void m6113b(AtomicReference atomicReference) {
        InterfaceC2787b interfaceC2787b;
        InterfaceC2787b interfaceC2787b2 = (InterfaceC2787b) atomicReference.get();
        EnumC3085a enumC3085a = f10547a;
        if (interfaceC2787b2 == enumC3085a || (interfaceC2787b = (InterfaceC2787b) atomicReference.getAndSet(enumC3085a)) == enumC3085a || interfaceC2787b == null) {
            return;
        }
        interfaceC2787b.mo5675a();
    }

    public static boolean m6114c(AtomicReference atomicReference, InterfaceC2787b interfaceC2787b) {
        Objects.requireNonNull(interfaceC2787b, "d is null");
        while (!atomicReference.compareAndSet(null, interfaceC2787b)) {
            if (atomicReference.get() != null) {
                interfaceC2787b.mo5675a();
                if (atomicReference.get() == f10547a) {
                    return false;
                }
                AbstractC1466d.m3505y(new C2904d("Disposable already set!"));
                return false;
            }
        }
        return true;
    }

    public static EnumC3085a valueOf(String str) {
        return (EnumC3085a) Enum.valueOf(EnumC3085a.class, str);
    }

    public static EnumC3085a[] values() {
        return (EnumC3085a[]) f10548b.clone();
    }

    @Override
    public final void mo5675a() {
    }
}

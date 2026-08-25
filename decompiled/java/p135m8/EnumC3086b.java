package p135m8;

import p203s8.InterfaceC3724a;

public final class EnumC3086b implements InterfaceC3724a {

    public static final EnumC3086b f10549a;

    public static final EnumC3086b[] f10550b;

    static {
        EnumC3086b enumC3086b = new EnumC3086b("INSTANCE", 0);
        f10549a = enumC3086b;
        f10550b = new EnumC3086b[]{enumC3086b, new EnumC3086b("NEVER", 1)};
    }

    public static EnumC3086b valueOf(String str) {
        return (EnumC3086b) Enum.valueOf(EnumC3086b.class, str);
    }

    public static EnumC3086b[] values() {
        return (EnumC3086b[]) f10550b.clone();
    }

    @Override
    public final int mo6115e() {
        return 2;
    }

    @Override
    public final boolean isEmpty() {
        return true;
    }

    @Override
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override
    public final Object poll() {
        return null;
    }

    @Override
    public final void mo5675a() {
    }

    @Override
    public final void clear() {
    }
}

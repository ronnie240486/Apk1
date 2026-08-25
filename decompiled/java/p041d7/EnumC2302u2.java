package p041d7;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p020b7.AbstractC1332b;

public final class EnumC2302u2 implements Iterator {

    public static final EnumC2302u2 f8070a;

    public static final EnumC2302u2[] f8071b;

    static {
        EnumC2302u2 enumC2302u2 = new EnumC2302u2("INSTANCE", 0);
        f8070a = enumC2302u2;
        f8071b = new EnumC2302u2[]{enumC2302u2};
    }

    public static EnumC2302u2 valueOf(String str) {
        return (EnumC2302u2) Enum.valueOf(EnumC2302u2.class, str);
    }

    public static EnumC2302u2[] values() {
        return (EnumC2302u2[]) f8071b.clone();
    }

    @Override
    public final boolean hasNext() {
        return false;
    }

    @Override
    public final Object next() {
        throw new NoSuchElementException();
    }

    @Override
    public final void remove() {
        AbstractC1332b.m3223n("no calls to next() since the last call to remove()", false);
    }
}

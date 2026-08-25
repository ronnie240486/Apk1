package okio;

import java.util.concurrent.locks.ReentrantLock;
import p091i9.InterfaceC2713a;
import p103j9.AbstractC2796i;
import p192r9.AbstractC3643a;

public final class _JvmPlatformKt {
    public static final byte[] asUtf8ToByteArray(String str) {
        AbstractC2796i.m5785f(str, "<this>");
        byte[] bytes = str.getBytes(AbstractC3643a.f12236a);
        AbstractC2796i.m5784e(bytes, "getBytes(...)");
        return bytes;
    }

    public static final ReentrantLock newLock() {
        return new ReentrantLock();
    }

    public static final String toUtf8String(byte[] bArr) {
        AbstractC2796i.m5785f(bArr, "<this>");
        return new String(bArr, AbstractC3643a.f12236a);
    }

    public static final <T> T withLock(ReentrantLock reentrantLock, InterfaceC2713a interfaceC2713a) {
        AbstractC2796i.m5785f(reentrantLock, "<this>");
        AbstractC2796i.m5785f(interfaceC2713a, "action");
        reentrantLock.lock();
        try {
            return (T) interfaceC2713a.invoke();
        } finally {
            reentrantLock.unlock();
        }
    }
}

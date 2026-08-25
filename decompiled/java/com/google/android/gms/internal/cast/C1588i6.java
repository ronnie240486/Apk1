package com.google.android.gms.internal.cast;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

public final class C1588i6 extends AbstractC1503a1 {

    public static final Unsafe f5344d;

    public static final long f5345e;

    public static final long f5346f;

    public static final long f5347g;

    public static final long f5348h;

    public static final long f5349i;

    static {
        Unsafe unsafe;
        try {
            try {
                unsafe = Unsafe.getUnsafe();
            } catch (PrivilegedActionException e5) {
                throw new RuntimeException("Could not initialize intrinsics", e5.getCause());
            }
        } catch (SecurityException unused) {
            unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction() {
                @Override
                public final Object run() throws IllegalAccessException {
                    Unsafe unsafe2 = C1588i6.f5344d;
                    for (Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    throw new NoSuchFieldError("the Unsafe");
                }
            });
        }
        try {
            f5346f = unsafe.objectFieldOffset(AbstractC1608k6.class.getDeclaredField("f"));
            f5345e = unsafe.objectFieldOffset(AbstractC1608k6.class.getDeclaredField("e"));
            f5347g = unsafe.objectFieldOffset(AbstractC1608k6.class.getDeclaredField("d"));
            f5348h = unsafe.objectFieldOffset(C1598j6.class.getDeclaredField(CmcdData.OBJECT_TYPE_AUDIO_ONLY));
            f5349i = unsafe.objectFieldOffset(C1598j6.class.getDeclaredField("b"));
            f5344d = unsafe;
        } catch (NoSuchFieldException e10) {
            throw new RuntimeException(e10);
        }
    }

    @Override
    public final C1548e6 mo3703d(AbstractC1558f6 abstractC1558f6) {
        C1548e6 c1548e6;
        C1548e6 c1548e7 = C1548e6.f5282d;
        do {
            c1548e6 = abstractC1558f6.f5392e;
            if (c1548e7 == c1548e6) {
                break;
            }
        } while (!mo3707q(abstractC1558f6, c1548e6, c1548e7));
        return c1548e6;
    }

    @Override
    public final C1598j6 mo3704k(AbstractC1558f6 abstractC1558f6) {
        C1598j6 c1598j6;
        C1598j6 c1598j7 = C1598j6.f5365c;
        do {
            c1598j6 = abstractC1558f6.f5393f;
            if (c1598j7 == c1598j6) {
                break;
            }
        } while (!mo3709s(abstractC1558f6, c1598j6, c1598j7));
        return c1598j6;
    }

    @Override
    public final void mo3705m(C1598j6 c1598j6, C1598j6 c1598j7) {
        f5344d.putObject(c1598j6, f5349i, c1598j7);
    }

    @Override
    public final void mo3706o(C1598j6 c1598j6, Thread thread) {
        f5344d.putObject(c1598j6, f5348h, thread);
    }

    @Override
    public final boolean mo3707q(AbstractC1558f6 abstractC1558f6, C1548e6 c1548e6, C1548e6 c1548e7) {
        return AbstractC1628m6.m3951a(f5344d, abstractC1558f6, f5345e, c1548e6, c1548e7);
    }

    @Override
    public final boolean mo3708r(AbstractC1608k6 abstractC1608k6, Object obj, Object obj2) {
        return AbstractC1628m6.m3951a(f5344d, abstractC1608k6, f5347g, obj, obj2);
    }

    @Override
    public final boolean mo3709s(AbstractC1608k6 abstractC1608k6, C1598j6 c1598j6, C1598j6 c1598j7) {
        return AbstractC1628m6.m3951a(f5344d, abstractC1608k6, f5346f, c1598j6, c1598j7);
    }
}

package com.google.android.gms.internal.cast;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

public abstract class AbstractC1600j8 {

    public static final Unsafe f5372a;

    public static final Class f5373b;

    public static final AbstractC1590i8 f5374c;

    public static final boolean f5375d;

    public static final boolean f5376e;

    public static final long f5377f;

    public static final boolean f5378g;

    static {
        AbstractC1590i8 c1570g8;
        Field declaredField;
        boolean z7;
        boolean z10;
        Field declaredField2;
        Field field;
        AbstractC1590i8 abstractC1590i8;
        Unsafe unsafeM3890j = m3890j();
        f5372a = unsafeM3890j;
        int i6 = AbstractC1746z6.f5745a;
        f5373b = Memory.class;
        Class<?> cls = Long.TYPE;
        boolean zM3896p = m3896p(cls);
        boolean zM3896p2 = m3896p(Integer.TYPE);
        if (unsafeM3890j == null) {
            c1570g8 = null;
        } else if (zM3896p) {
            c1570g8 = new C1580h8(unsafeM3890j);
        } else if (zM3896p2) {
            c1570g8 = new C1570g8(unsafeM3890j);
        } else {
            c1570g8 = null;
        }
        f5374c = c1570g8;
        if (c1570g8 == null) {
            z7 = false;
        } else {
            try {
                Class<?> cls2 = c1570g8.f5350a.getClass();
                cls2.getMethod("objectFieldOffset", Field.class);
                cls2.getMethod("getLong", Object.class, cls);
                try {
                    declaredField = Buffer.class.getDeclaredField("effectiveDirectAddress");
                } catch (Throwable unused) {
                    declaredField = null;
                }
                if (declaredField == null) {
                    try {
                        declaredField = Buffer.class.getDeclaredField("address");
                    } catch (Throwable unused2) {
                        declaredField = null;
                    }
                    if (declaredField == null || declaredField.getType() != Long.TYPE) {
                        declaredField = null;
                    }
                }
                if (declaredField == null) {
                    z7 = false;
                } else {
                    z7 = true;
                }
            } catch (Throwable th) {
                Logger.getLogger(AbstractC1600j8.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
            }
        }
        f5375d = z7;
        AbstractC1590i8 abstractC1590i9 = f5374c;
        if (abstractC1590i9 == null) {
            z10 = false;
        } else {
            try {
                Class<?> cls3 = abstractC1590i9.f5350a.getClass();
                cls3.getMethod("objectFieldOffset", Field.class);
                cls3.getMethod("arrayBaseOffset", Class.class);
                cls3.getMethod("arrayIndexScale", Class.class);
                Class<?> cls4 = Long.TYPE;
                cls3.getMethod("getInt", Object.class, cls4);
                cls3.getMethod("putInt", Object.class, cls4, Integer.TYPE);
                cls3.getMethod("getLong", Object.class, cls4);
                cls3.getMethod("putLong", Object.class, cls4, cls4);
                cls3.getMethod("getObject", Object.class, cls4);
                cls3.getMethod("putObject", Object.class, cls4, Object.class);
                z10 = true;
            } catch (Throwable th2) {
                Logger.getLogger(AbstractC1600j8.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th2.toString()));
                z10 = false;
            }
        }
        f5376e = z10;
        f5377f = m3898r(byte[].class);
        m3898r(boolean[].class);
        m3881a(boolean[].class);
        m3898r(int[].class);
        m3881a(int[].class);
        m3898r(long[].class);
        m3881a(long[].class);
        m3898r(float[].class);
        m3881a(float[].class);
        m3898r(double[].class);
        m3881a(double[].class);
        m3898r(Object[].class);
        m3881a(Object[].class);
        int i10 = AbstractC1746z6.f5745a;
        try {
            declaredField2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
        } catch (Throwable unused3) {
            declaredField2 = null;
        }
        if (declaredField2 == null) {
            try {
                declaredField2 = Buffer.class.getDeclaredField("address");
            } catch (Throwable unused4) {
                declaredField2 = null;
            }
            if (declaredField2 == null || declaredField2.getType() != Long.TYPE) {
                field = null;
            } else {
                field = declaredField2;
            }
        } else {
            field = declaredField2;
        }
        if (field != null && (abstractC1590i8 = f5374c) != null) {
            abstractC1590i8.f5350a.objectFieldOffset(field);
        }
        f5378g = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static void m3881a(Class cls) {
        if (f5376e) {
            f5374c.f5350a.arrayIndexScale(cls);
        }
    }

    public static void m3882b(Object obj, long j10, byte b8) {
        Unsafe unsafe = f5374c.f5350a;
        long j11 = (-4) & j10;
        int i6 = unsafe.getInt(obj, j11);
        int i10 = ((~((int) j10)) & 3) << 3;
        unsafe.putInt(obj, j11, ((255 & b8) << i10) | (i6 & (~(255 << i10))));
    }

    public static void m3883c(Object obj, long j10, byte b8) {
        Unsafe unsafe = f5374c.f5350a;
        long j11 = (-4) & j10;
        int i6 = (((int) j10) & 3) << 3;
        unsafe.putInt(obj, j11, ((255 & b8) << i6) | (unsafe.getInt(obj, j11) & (~(255 << i6))));
    }

    public static double m3884d(long j10, Object obj) {
        return f5374c.mo3825a(j10, obj);
    }

    public static float m3885e(long j10, Object obj) {
        return f5374c.mo3826b(j10, obj);
    }

    public static int m3886f(long j10, Object obj) {
        return f5374c.f5350a.getInt(obj, j10);
    }

    public static long m3887g(long j10, Object obj) {
        return f5374c.f5350a.getLong(obj, j10);
    }

    public static Object m3888h(Class cls) {
        try {
            return f5372a.allocateInstance(cls);
        } catch (InstantiationException e5) {
            throw new IllegalStateException(e5);
        }
    }

    public static Object m3889i(long j10, Object obj) {
        return f5374c.f5350a.getObject(obj, j10);
    }

    public static Unsafe m3890j() {
        try {
            return (Unsafe) AccessController.doPrivileged(new C1560f8());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void m3891k(int i6, long j10, Object obj) {
        f5374c.f5350a.putInt(obj, j10, i6);
    }

    public static void m3892l(Object obj, long j10, long j11) {
        f5374c.f5350a.putLong(obj, j10, j11);
    }

    public static void m3893m(long j10, Object obj, Object obj2) {
        f5374c.f5350a.putObject(obj, j10, obj2);
    }

    public static boolean m3894n(long j10, Object obj) {
        return ((byte) ((f5374c.f5350a.getInt(obj, (-4) & j10) >>> ((int) (((~j10) & 3) << 3))) & 255)) != 0;
    }

    public static boolean m3895o(long j10, Object obj) {
        return ((byte) ((f5374c.f5350a.getInt(obj, (-4) & j10) >>> ((int) ((j10 & 3) << 3))) & 255)) != 0;
    }

    public static boolean m3896p(Class cls) {
        int i6 = AbstractC1746z6.f5745a;
        try {
            Class cls2 = f5373b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean m3897q(long j10, Object obj) {
        return f5374c.mo3831g(j10, obj);
    }

    public static int m3898r(Class cls) {
        if (f5376e) {
            return f5374c.f5350a.arrayBaseOffset(cls);
        }
        return -1;
    }
}

package com.google.android.gms.internal.cast;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p000a.AbstractC0004e;

public abstract class AbstractC1589i7 extends AbstractC1728x6 {
    private static final Map zzb = new ConcurrentHashMap();
    protected C1550e8 zzc;
    private int zzd;

    public AbstractC1589i7() {
        this.zza = 0;
        this.zzd = -1;
        this.zzc = C1550e8.f5286e;
    }

    public static Object m3863c(Method method, AbstractC1728x6 abstractC1728x6, Object... objArr) {
        try {
            return method.invoke(abstractC1728x6, objArr);
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e5);
        } catch (InvocationTargetException e10) {
            Throwable cause = e10.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static void m3864e(Class cls, AbstractC1589i7 abstractC1589i7) {
        abstractC1589i7.m3867d();
        zzb.put(cls, abstractC1589i7);
    }

    public static AbstractC1589i7 m3865k(Class cls) {
        Map map = zzb;
        AbstractC1589i7 abstractC1589i7 = (AbstractC1589i7) map.get(cls);
        if (abstractC1589i7 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                abstractC1589i7 = (AbstractC1589i7) map.get(cls);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException("Class initialization cannot fail.", e5);
            }
        }
        if (abstractC1589i7 == null) {
            abstractC1589i7 = (AbstractC1589i7) ((AbstractC1589i7) AbstractC1600j8.m3888h(cls)).mo3714h(6, null);
            if (abstractC1589i7 == null) {
                throw new IllegalStateException();
            }
            map.put(cls, abstractC1589i7);
        }
        return abstractC1589i7;
    }

    @Override
    public final int mo3866a(InterfaceC1520b8 interfaceC1520b8) {
        if (m3869g()) {
            int iMo3739e = interfaceC1520b8.mo3739e(this);
            if (iMo3739e >= 0) {
                return iMo3739e;
            }
            throw new IllegalStateException(AbstractC0004e.m20n(iMo3739e, "serialized size must be non-negative, was "));
        }
        int i6 = this.zzd & Integer.MAX_VALUE;
        if (i6 != Integer.MAX_VALUE) {
            return i6;
        }
        int iMo3739e2 = interfaceC1520b8.mo3739e(this);
        if (iMo3739e2 < 0) {
            throw new IllegalStateException(AbstractC0004e.m20n(iMo3739e2, "serialized size must be non-negative, was "));
        }
        this.zzd = (this.zzd & Integer.MIN_VALUE) | iMo3739e2;
        return iMo3739e2;
    }

    public final void m3867d() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return C1738y7.f5738c.m4060a(getClass()).mo3737c(this, (AbstractC1589i7) obj);
    }

    public final void m3868f() {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final boolean m3869g() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public abstract Object mo3714h(int i6, AbstractC1589i7 abstractC1589i7);

    public final int hashCode() {
        if (m3869g()) {
            return C1738y7.f5738c.m4060a(getClass()).mo3742h(this);
        }
        int i6 = this.zza;
        if (i6 != 0) {
            return i6;
        }
        int iMo3742h = C1738y7.f5738c.m4060a(getClass()).mo3742h(this);
        this.zza = iMo3742h;
        return iMo3742h;
    }

    public final int m3870i() {
        int iMo3739e;
        if (m3869g()) {
            iMo3739e = C1738y7.f5738c.m4060a(getClass()).mo3739e(this);
            if (iMo3739e < 0) {
                throw new IllegalStateException(AbstractC0004e.m20n(iMo3739e, "serialized size must be non-negative, was "));
            }
        } else {
            iMo3739e = this.zzd & Integer.MAX_VALUE;
            if (iMo3739e == Integer.MAX_VALUE) {
                iMo3739e = C1738y7.f5738c.m4060a(getClass()).mo3739e(this);
                if (iMo3739e < 0) {
                    throw new IllegalStateException(AbstractC0004e.m20n(iMo3739e, "serialized size must be non-negative, was "));
                }
                this.zzd = (this.zzd & Integer.MIN_VALUE) | iMo3739e;
            }
        }
        return iMo3739e;
    }

    public final AbstractC1579h7 m3871j() {
        return (AbstractC1579h7) mo3714h(5, null);
    }

    public final String toString() {
        String string = super.toString();
        char[] cArr = AbstractC1702u7.f5690a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        AbstractC1702u7.m4027c(this, sb, 0);
        return sb.toString();
    }
}

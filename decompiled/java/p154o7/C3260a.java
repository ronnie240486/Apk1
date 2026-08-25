package p154o7;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import p125l7.AbstractC3011r;
import p125l7.C3004k;
import p125l7.InterfaceC3012s;
import p144n7.AbstractC3206d;
import p190r7.C3640a;
import p202s7.C3723a;

public final class C3260a implements InterfaceC3012s {

    public final int f10893a;

    public C3260a(int i6) {
        this.f10893a = i6;
    }

    @Override
    public final AbstractC3011r mo6089a(C3004k c3004k, C3723a c3723a) {
        switch (this.f10893a) {
            case 0:
                Type type = c3723a.f12481b;
                boolean z7 = type instanceof GenericArrayType;
                if (!z7 && (!(type instanceof Class) || !((Class) type).isArray())) {
                    return null;
                }
                Type genericComponentType = z7 ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
                return new C3261b(c3004k, c3004k.m6081c(new C3723a(genericComponentType)), AbstractC3206d.m6492h(genericComponentType));
            case 1:
                if (c3723a.f12480a == Date.class) {
                    return new C3263d();
                }
                return null;
            case 2:
                if (c3723a.f12480a == Object.class) {
                    return new C3267h(c3004k);
                }
                return null;
            case 3:
                Class superclass = c3723a.f12480a;
                if (!Enum.class.isAssignableFrom(superclass) || superclass == Enum.class) {
                    return null;
                }
                if (!superclass.isEnum()) {
                    superclass = superclass.getSuperclass();
                }
                return new C3261b(superclass);
            case 4:
                if (c3723a.f12480a == java.sql.Date.class) {
                    return new C3640a(0);
                }
                return null;
            case 5:
                if (c3723a.f12480a == Time.class) {
                    return new C3640a(1);
                }
                return null;
            default:
                if (c3723a.f12480a != Timestamp.class) {
                    return null;
                }
                c3004k.getClass();
                return new C3640a(c3004k.m6081c(new C3723a(Date.class)));
        }
    }
}

package p154o7;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import p124l6.C2982h;
import p125l7.AbstractC3011r;
import p125l7.C3002i;
import p125l7.C3004k;
import p125l7.InterfaceC3012s;
import p134m7.InterfaceC3083a;
import p144n7.AbstractC3206d;
import p202s7.C3723a;

public final class C3262c implements InterfaceC3012s {

    public final int f10898a;

    public final C2982h f10899b;

    public C3262c(C2982h c2982h, int i6) {
        this.f10898a = i6;
        this.f10899b = c2982h;
    }

    public static AbstractC3011r m6559b(C2982h c2982h, C3004k c3004k, C3723a c3723a, InterfaceC3083a interfaceC3083a) {
        AbstractC3011r abstractC3011rMo6089a;
        Object objMo135n = c2982h.m6045r(new C3723a(interfaceC3083a.value())).mo135n();
        if (objMo135n instanceof AbstractC3011r) {
            abstractC3011rMo6089a = (AbstractC3011r) objMo135n;
        } else {
            if (!(objMo135n instanceof InterfaceC3012s)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objMo135n.getClass().getName() + " as a @JsonAdapter for " + AbstractC3206d.m6494k(c3723a.f12481b) + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            abstractC3011rMo6089a = ((InterfaceC3012s) objMo135n).mo6089a(c3004k, c3723a);
        }
        return (abstractC3011rMo6089a == null || !interfaceC3083a.nullSafe()) ? abstractC3011rMo6089a : new C3002i(abstractC3011rMo6089a, 2);
    }

    @Override
    public final AbstractC3011r mo6089a(C3004k c3004k, C3723a c3723a) {
        Type[] actualTypeArguments;
        Type type = Object.class;
        C2982h c2982h = this.f10899b;
        switch (this.f10898a) {
            case 0:
                Class cls = c3723a.f12480a;
                if (!Collection.class.isAssignableFrom(cls)) {
                    return null;
                }
                Type type2 = c3723a.f12481b;
                if (type2 instanceof WildcardType) {
                    type2 = ((WildcardType) type2).getUpperBounds()[0];
                }
                AbstractC3206d.m6487c(Collection.class.isAssignableFrom(cls));
                Type typeM6493j = AbstractC3206d.m6493j(type2, cls, AbstractC3206d.m6491g(type2, cls, Collection.class), new HashMap());
                if (typeM6493j instanceof WildcardType) {
                    typeM6493j = ((WildcardType) typeM6493j).getUpperBounds()[0];
                }
                type = typeM6493j instanceof ParameterizedType ? ((ParameterizedType) typeM6493j).getActualTypeArguments()[0] : Object.class;
                return new C3261b(c3004k, type, c3004k.m6081c(new C3723a(type)), c2982h.m6045r(c3723a));
            case 1:
                InterfaceC3083a interfaceC3083a = (InterfaceC3083a) c3723a.f12480a.getAnnotation(InterfaceC3083a.class);
                if (interfaceC3083a == null) {
                    return null;
                }
                return m6559b(c2982h, c3004k, c3723a, interfaceC3083a);
            default:
                if (!Map.class.isAssignableFrom(c3723a.f12480a)) {
                    return null;
                }
                Type type3 = c3723a.f12481b;
                Class clsM6492h = AbstractC3206d.m6492h(type3);
                if (type3 == Properties.class) {
                    actualTypeArguments = new Type[]{String.class, String.class};
                } else {
                    if (type3 instanceof WildcardType) {
                        type3 = ((WildcardType) type3).getUpperBounds()[0];
                    }
                    AbstractC3206d.m6487c(Map.class.isAssignableFrom(clsM6492h));
                    Type typeM6493j2 = AbstractC3206d.m6493j(type3, clsM6492h, AbstractC3206d.m6491g(type3, clsM6492h, Map.class), new HashMap());
                    actualTypeArguments = typeM6493j2 instanceof ParameterizedType ? ((ParameterizedType) typeM6493j2).getActualTypeArguments() : new Type[]{type, type};
                }
                Type type4 = actualTypeArguments[0];
                return new C3264e(this, c3004k, actualTypeArguments[0], (type4 == Boolean.TYPE || type4 == Boolean.class) ? AbstractC3275p.f10940c : c3004k.m6081c(new C3723a(type4)), actualTypeArguments[1], c3004k.m6081c(new C3723a(actualTypeArguments[1])), c2982h.m6045r(c3723a));
        }
    }
}

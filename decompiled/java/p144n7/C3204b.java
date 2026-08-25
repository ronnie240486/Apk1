package p144n7;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public final class C3204b implements ParameterizedType, Serializable {

    public final Type f10775a;

    public final Type f10776b;

    public final Type[] f10777c;

    public C3204b(Type type, Type type2, Type... typeArr) {
        if (type2 instanceof Class) {
            Class cls = (Class) type2;
            boolean z7 = true;
            boolean z10 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
            if (type == null && !z10) {
                z7 = false;
            }
            AbstractC3206d.m6487c(z7);
        }
        this.f10775a = type == null ? null : AbstractC3206d.m6486b(type);
        this.f10776b = AbstractC3206d.m6486b(type2);
        Type[] typeArr2 = (Type[]) typeArr.clone();
        this.f10777c = typeArr2;
        int length = typeArr2.length;
        for (int i6 = 0; i6 < length; i6++) {
            this.f10777c[i6].getClass();
            AbstractC3206d.m6488d(this.f10777c[i6]);
            Type[] typeArr3 = this.f10777c;
            typeArr3[i6] = AbstractC3206d.m6486b(typeArr3[i6]);
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && AbstractC3206d.m6490f(this, (ParameterizedType) obj);
    }

    @Override
    public final Type[] getActualTypeArguments() {
        return (Type[]) this.f10777c.clone();
    }

    @Override
    public final Type getOwnerType() {
        return this.f10775a;
    }

    @Override
    public final Type getRawType() {
        return this.f10776b;
    }

    public final int hashCode() {
        int iHashCode = Arrays.hashCode(this.f10777c) ^ this.f10776b.hashCode();
        Type type = this.f10775a;
        return iHashCode ^ (type != null ? type.hashCode() : 0);
    }

    public final String toString() {
        Type[] typeArr = this.f10777c;
        int length = typeArr.length;
        Type type = this.f10776b;
        if (length == 0) {
            return AbstractC3206d.m6494k(type);
        }
        StringBuilder sb = new StringBuilder((length + 1) * 30);
        sb.append(AbstractC3206d.m6494k(type));
        sb.append("<");
        sb.append(AbstractC3206d.m6494k(typeArr[0]));
        for (int i6 = 1; i6 < length; i6++) {
            sb.append(", ");
            sb.append(AbstractC3206d.m6494k(typeArr[i6]));
        }
        sb.append(">");
        return sb.toString();
    }
}

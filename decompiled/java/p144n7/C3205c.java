package p144n7;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

public final class C3205c implements WildcardType, Serializable {

    public final Type f10778a;

    public final Type f10779b;

    public C3205c(Type[] typeArr, Type[] typeArr2) {
        AbstractC3206d.m6487c(typeArr2.length <= 1);
        AbstractC3206d.m6487c(typeArr.length == 1);
        if (typeArr2.length != 1) {
            typeArr[0].getClass();
            AbstractC3206d.m6488d(typeArr[0]);
            this.f10779b = null;
            this.f10778a = AbstractC3206d.m6486b(typeArr[0]);
            return;
        }
        typeArr2[0].getClass();
        AbstractC3206d.m6488d(typeArr2[0]);
        AbstractC3206d.m6487c(typeArr[0] == Object.class);
        this.f10779b = AbstractC3206d.m6486b(typeArr2[0]);
        this.f10778a = Object.class;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof WildcardType) && AbstractC3206d.m6490f(this, (WildcardType) obj);
    }

    @Override
    public final Type[] getLowerBounds() {
        Type type = this.f10779b;
        return type != null ? new Type[]{type} : AbstractC3206d.f10780a;
    }

    @Override
    public final Type[] getUpperBounds() {
        return new Type[]{this.f10778a};
    }

    public final int hashCode() {
        Type type = this.f10779b;
        return (type != null ? type.hashCode() + 31 : 1) ^ (this.f10778a.hashCode() + 31);
    }

    public final String toString() {
        Type type = this.f10779b;
        if (type != null) {
            return "? super " + AbstractC3206d.m6494k(type);
        }
        Type type2 = this.f10778a;
        if (type2 == Object.class) {
            return "?";
        }
        return "? extends " + AbstractC3206d.m6494k(type2);
    }
}

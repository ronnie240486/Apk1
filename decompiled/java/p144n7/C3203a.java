package p144n7;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import okhttp3.HttpUrl;

public final class C3203a implements GenericArrayType, Serializable {

    public final Type f10774a;

    public C3203a(Type type) {
        this.f10774a = AbstractC3206d.m6486b(type);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && AbstractC3206d.m6490f(this, (GenericArrayType) obj);
    }

    @Override
    public final Type getGenericComponentType() {
        return this.f10774a;
    }

    public final int hashCode() {
        return this.f10774a.hashCode();
    }

    public final String toString() {
        return AbstractC3206d.m6494k(this.f10774a) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }
}

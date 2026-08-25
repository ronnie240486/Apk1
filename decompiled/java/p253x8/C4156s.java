package p253x8;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import p103j9.AbstractC2796i;
import p115k9.InterfaceC2905a;

public final class C4156s implements Map, Serializable, InterfaceC2905a {

    public static final C4156s f14075a = new C4156s();

    @Override
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean containsKey(Object obj) {
        return false;
    }

    @Override
    public final boolean containsValue(Object obj) {
        if (!(obj instanceof Void)) {
            return false;
        }
        AbstractC2796i.m5785f((Void) obj, "value");
        return false;
    }

    @Override
    public final Set entrySet() {
        return C4157t.f14076a;
    }

    @Override
    public final boolean equals(Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    @Override
    public final Object get(Object obj) {
        return null;
    }

    @Override
    public final int hashCode() {
        return 0;
    }

    @Override
    public final boolean isEmpty() {
        return true;
    }

    @Override
    public final Set keySet() {
        return C4157t.f14076a;
    }

    @Override
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final int size() {
        return 0;
    }

    public final String toString() {
        return "{}";
    }

    @Override
    public final Collection values() {
        return C4155r.f14074a;
    }
}

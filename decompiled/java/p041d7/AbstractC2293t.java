package p041d7;

import java.util.Map;
import p020b7.AbstractC1332b;

public abstract class AbstractC2293t implements Map.Entry {
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return AbstractC1332b.m3225p(getKey(), entry.getKey()) && AbstractC1332b.m3225p(getValue(), entry.getValue());
    }

    @Override
    public int hashCode() {
        Object key = getKey();
        Object value = getValue();
        return (key == null ? 0 : key.hashCode()) ^ (value != null ? value.hashCode() : 0);
    }

    @Override
    public Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}

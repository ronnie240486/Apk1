package p252x7;

import java.util.LinkedHashMap;
import java.util.Map;

public final class C4137a extends LinkedHashMap {

    public int f14062a;

    @Override
    public final boolean removeEldestEntry(Map.Entry entry) {
        return size() > this.f14062a;
    }
}

package p253x8;

import com.bumptech.glide.AbstractC1465c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import p103j9.AbstractC2796i;
import p243w8.C4064f;

public abstract class AbstractC4158u extends AbstractC1465c {
    public static int m8196p(int i6) {
        if (i6 < 0) {
            return i6;
        }
        if (i6 < 3) {
            return i6 + 1;
        }
        if (i6 < 1073741824) {
            return (int) ((i6 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map m8197q(ArrayList arrayList) {
        C4156s c4156s = C4156s.f14075a;
        int size = arrayList.size();
        if (size == 0) {
            return c4156s;
        }
        if (size == 1) {
            C4064f c4064f = (C4064f) arrayList.get(0);
            AbstractC2796i.m5785f(c4064f, "pair");
            Map mapSingletonMap = Collections.singletonMap(c4064f.f13727a, c4064f.f13728b);
            AbstractC2796i.m5784e(mapSingletonMap, "singletonMap(...)");
            return mapSingletonMap;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(m8196p(arrayList.size()));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C4064f c4064f2 = (C4064f) it.next();
            linkedHashMap.put(c4064f2.f13727a, c4064f2.f13728b);
        }
        return linkedHashMap;
    }

    public static Map m8198r(Map map) {
        AbstractC2796i.m5785f(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return C4156s.f14075a;
        }
        if (size != 1) {
            return m8199s(map);
        }
        AbstractC2796i.m5785f(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        AbstractC2796i.m5784e(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }

    public static LinkedHashMap m8199s(Map map) {
        AbstractC2796i.m5785f(map, "<this>");
        return new LinkedHashMap(map);
    }
}

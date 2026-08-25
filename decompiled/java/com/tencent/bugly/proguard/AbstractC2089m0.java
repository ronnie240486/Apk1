package com.tencent.bugly.proguard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractC2089m0 {

    protected HashMap<String, HashMap<String, byte[]>> f7645a = new HashMap<>();

    protected HashMap<String, Object> f7646b = new HashMap<>();

    private HashMap<String, Object> f7649e = new HashMap<>();

    protected String f7647c = "GBK";

    C2084k f7648d = new C2084k();

    public void mo4856a(String str, Object obj) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (obj == null) {
            throw new IllegalArgumentException("put value can not is null");
        }
        if (obj instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        }
        C2086l c2086l = new C2086l();
        c2086l.m4928a(this.f7647c);
        c2086l.m4933a(obj, 0);
        byte[] bArrM4944a = C2090n.m4944a(c2086l.f7641a);
        HashMap<String, byte[]> map = new HashMap<>(1);
        ArrayList arrayList = new ArrayList(1);
        while (true) {
            if (obj.getClass().isArray()) {
                if (!obj.getClass().getComponentType().toString().equals("byte")) {
                    throw new IllegalArgumentException("only byte[] is supported");
                }
                if (Array.getLength(obj) <= 0) {
                    arrayList.add("Array");
                    arrayList.add("?");
                    map.put(C2016a.m4500a(arrayList), bArrM4944a);
                    this.f7649e.remove(str);
                    this.f7645a.put(str, map);
                    return;
                }
                arrayList.add("java.util.List");
                obj = Array.get(obj, 0);
            } else {
                if (obj instanceof Array) {
                    throw new IllegalArgumentException("can not support Array, please use List");
                }
                if (!(obj instanceof List)) {
                    if (obj instanceof Map) {
                        arrayList.add("java.util.Map");
                        Map map2 = (Map) obj;
                        if (map2.size() > 0) {
                            Object next = map2.keySet().iterator().next();
                            obj = map2.get(next);
                            arrayList.add(next.getClass().getName());
                        } else {
                            arrayList.add("?");
                            arrayList.add("?");
                        }
                    } else {
                        arrayList.add(obj.getClass().getName());
                    }
                    map.put(C2016a.m4500a(arrayList), bArrM4944a);
                    this.f7649e.remove(str);
                    this.f7645a.put(str, map);
                    return;
                }
                arrayList.add("java.util.List");
                List list = (List) obj;
                if (list.size() <= 0) {
                    arrayList.add("?");
                    map.put(C2016a.m4500a(arrayList), bArrM4944a);
                    this.f7649e.remove(str);
                    this.f7645a.put(str, map);
                    return;
                }
                obj = list.get(0);
            }
        }
    }

    public void mo4857a(byte[] bArr) {
        this.f7648d.m4913a(bArr);
        this.f7648d.m4907a(this.f7647c);
        HashMap map = new HashMap(1);
        HashMap map2 = new HashMap(1);
        map2.put("", new byte[0]);
        map.put("", map2);
        this.f7645a = this.f7648d.m4911a((Map) map, 0, false);
    }
}

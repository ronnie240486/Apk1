package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class C2067bv extends AbstractC2088m implements Cloneable {

    static ArrayList<C2066bu> f7584f;

    static Map<String, String> f7585g;

    public byte f7586a = 0;

    public String f7587b = "";

    public String f7588c = "";

    public ArrayList<C2066bu> f7589d = null;

    public Map<String, String> f7590e = null;

    @Override
    public final void mo4853a(StringBuilder sb, int i6) {
    }

    @Override
    public final void mo4852a(C2086l c2086l) {
        c2086l.m4929a(this.f7586a, 0);
        String str = this.f7587b;
        if (str != null) {
            c2086l.m4934a(str, 1);
        }
        String str2 = this.f7588c;
        if (str2 != null) {
            c2086l.m4934a(str2, 2);
        }
        ArrayList<C2066bu> arrayList = this.f7589d;
        if (arrayList != null) {
            c2086l.m4935a((Collection) arrayList, 3);
        }
        Map<String, String> map = this.f7590e;
        if (map != null) {
            c2086l.m4936a((Map) map, 4);
        }
    }

    @Override
    public final void mo4851a(C2084k c2084k) {
        this.f7586a = c2084k.m4905a(this.f7586a, 0, true);
        this.f7587b = c2084k.m4915b(1, false);
        this.f7588c = c2084k.m4915b(2, false);
        if (f7584f == null) {
            f7584f = new ArrayList<>();
            f7584f.add(new C2066bu());
        }
        this.f7589d = (ArrayList) c2084k.m4910a(f7584f, 3, false);
        if (f7585g == null) {
            HashMap map = new HashMap();
            f7585g = map;
            map.put("", "");
        }
        this.f7590e = (Map) c2084k.m4910a(f7585g, 4, false);
    }
}

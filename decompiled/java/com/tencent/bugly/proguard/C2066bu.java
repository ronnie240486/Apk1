package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

public final class C2066bu extends AbstractC2088m {

    static Map<String, String> f7575i;

    public long f7576a = 0;

    public byte f7577b = 0;

    public String f7578c = "";

    public String f7579d = "";

    public String f7580e = "";

    public Map<String, String> f7581f = null;

    public String f7582g = "";

    public boolean f7583h = true;

    static {
        HashMap map = new HashMap();
        f7575i = map;
        map.put("", "");
    }

    @Override
    public final void mo4852a(C2086l c2086l) {
        c2086l.m4931a(this.f7576a, 0);
        c2086l.m4929a(this.f7577b, 1);
        String str = this.f7578c;
        if (str != null) {
            c2086l.m4934a(str, 2);
        }
        String str2 = this.f7579d;
        if (str2 != null) {
            c2086l.m4934a(str2, 3);
        }
        String str3 = this.f7580e;
        if (str3 != null) {
            c2086l.m4934a(str3, 4);
        }
        Map<String, String> map = this.f7581f;
        if (map != null) {
            c2086l.m4936a((Map) map, 5);
        }
        String str4 = this.f7582g;
        if (str4 != null) {
            c2086l.m4934a(str4, 6);
        }
        c2086l.m4938a(this.f7583h, 7);
    }

    @Override
    public final void mo4851a(C2084k c2084k) {
        this.f7576a = c2084k.m4908a(this.f7576a, 0, true);
        this.f7577b = c2084k.m4905a(this.f7577b, 1, true);
        this.f7578c = c2084k.m4915b(2, false);
        this.f7579d = c2084k.m4915b(3, false);
        this.f7580e = c2084k.m4915b(4, false);
        this.f7581f = (Map) c2084k.m4910a(f7575i, 5, false);
        this.f7582g = c2084k.m4915b(6, false);
        this.f7583h = c2084k.m4914a(7, false);
    }
}

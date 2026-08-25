package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

public final class C2063br extends AbstractC2088m {

    static byte[] f7548i = {0};

    static Map<String, String> f7549j;

    public byte f7550a = 0;

    public int f7551b = 0;

    public byte[] f7552c = null;

    public String f7553d = "";

    public long f7554e = 0;

    public String f7555f = "";

    public String f7556g = "";

    public Map<String, String> f7557h = null;

    static {
        HashMap map = new HashMap();
        f7549j = map;
        map.put("", "");
    }

    @Override
    public final void mo4852a(C2086l c2086l) {
        c2086l.m4929a(this.f7550a, 0);
        c2086l.m4930a(this.f7551b, 1);
        byte[] bArr = this.f7552c;
        if (bArr != null) {
            c2086l.m4939a(bArr, 2);
        }
        String str = this.f7553d;
        if (str != null) {
            c2086l.m4934a(str, 3);
        }
        c2086l.m4931a(this.f7554e, 4);
        String str2 = this.f7555f;
        if (str2 != null) {
            c2086l.m4934a(str2, 5);
        }
        String str3 = this.f7556g;
        if (str3 != null) {
            c2086l.m4934a(str3, 6);
        }
        Map<String, String> map = this.f7557h;
        if (map != null) {
            c2086l.m4936a((Map) map, 7);
        }
    }

    @Override
    public final void mo4851a(C2084k c2084k) {
        this.f7550a = c2084k.m4905a(this.f7550a, 0, true);
        this.f7551b = c2084k.m4906a(this.f7551b, 1, true);
        this.f7552c = c2084k.m4916c(2, false);
        this.f7553d = c2084k.m4915b(3, false);
        this.f7554e = c2084k.m4908a(this.f7554e, 4, false);
        this.f7555f = c2084k.m4915b(5, false);
        this.f7556g = c2084k.m4915b(6, false);
        this.f7557h = (Map) c2084k.m4910a(f7549j, 7, false);
    }
}

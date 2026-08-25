package com.tencent.bugly.proguard;

import com.lzy.okgo.model.Progress;
import java.util.HashMap;
import java.util.Map;

public final class C2065bt extends AbstractC2088m implements Cloneable {

    static C2064bs f7560m = new C2064bs();

    static Map<String, String> f7561n = null;

    static final boolean f7562o = true;

    public boolean f7563a = true;

    public boolean f7564b = true;

    public boolean f7565c = true;

    public String f7566d = "";

    public String f7567e = "";

    public C2064bs f7568f = null;

    public Map<String, String> f7569g = null;

    public long f7570h = 0;

    public String f7571i = "";

    public String f7572j = "";

    public int f7573k = 0;

    public int f7574l = 0;

    static {
        HashMap map = new HashMap();
        f7561n = map;
        map.put("", "");
    }

    @Override
    public final void mo4852a(C2086l c2086l) {
        c2086l.m4938a(this.f7563a, 0);
        c2086l.m4938a(this.f7564b, 1);
        c2086l.m4938a(this.f7565c, 2);
        String str = this.f7566d;
        if (str != null) {
            c2086l.m4934a(str, 3);
        }
        String str2 = this.f7567e;
        if (str2 != null) {
            c2086l.m4934a(str2, 4);
        }
        C2064bs c2064bs = this.f7568f;
        if (c2064bs != null) {
            c2086l.m4932a((AbstractC2088m) c2064bs, 5);
        }
        Map<String, String> map = this.f7569g;
        if (map != null) {
            c2086l.m4936a((Map) map, 6);
        }
        c2086l.m4931a(this.f7570h, 7);
        String str3 = this.f7571i;
        if (str3 != null) {
            c2086l.m4934a(str3, 8);
        }
        String str4 = this.f7572j;
        if (str4 != null) {
            c2086l.m4934a(str4, 9);
        }
        c2086l.m4930a(this.f7573k, 10);
        c2086l.m4930a(this.f7574l, 11);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f7562o) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C2065bt c2065bt = (C2065bt) obj;
        return C2090n.m4943a(this.f7563a, c2065bt.f7563a) && C2090n.m4943a(this.f7564b, c2065bt.f7564b) && C2090n.m4943a(this.f7565c, c2065bt.f7565c) && C2090n.m4942a(this.f7566d, c2065bt.f7566d) && C2090n.m4942a(this.f7567e, c2065bt.f7567e) && C2090n.m4942a(this.f7568f, c2065bt.f7568f) && C2090n.m4942a(this.f7569g, c2065bt.f7569g) && C2090n.m4941a(this.f7570h, c2065bt.f7570h) && C2090n.m4942a(this.f7571i, c2065bt.f7571i) && C2090n.m4942a(this.f7572j, c2065bt.f7572j) && C2090n.m4940a(this.f7573k, c2065bt.f7573k) && C2090n.m4940a(this.f7574l, c2065bt.f7574l);
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    @Override
    public final void mo4851a(C2084k c2084k) {
        this.f7563a = c2084k.m4914a(0, true);
        this.f7564b = c2084k.m4914a(1, true);
        this.f7565c = c2084k.m4914a(2, true);
        this.f7566d = c2084k.m4915b(3, false);
        this.f7567e = c2084k.m4915b(4, false);
        this.f7568f = (C2064bs) c2084k.m4909a((AbstractC2088m) f7560m, 5, false);
        this.f7569g = (Map) c2084k.m4910a(f7561n, 6, false);
        this.f7570h = c2084k.m4908a(this.f7570h, 7, false);
        this.f7571i = c2084k.m4915b(8, false);
        this.f7572j = c2084k.m4915b(9, false);
        this.f7573k = c2084k.m4906a(this.f7573k, 10, false);
        this.f7574l = c2084k.m4906a(this.f7574l, 11, false);
    }

    @Override
    public final void mo4853a(StringBuilder sb, int i6) {
        C2080i c2080i = new C2080i(sb, i6);
        c2080i.m4884a(this.f7563a, "enable");
        c2080i.m4884a(this.f7564b, "enableUserInfo");
        c2080i.m4884a(this.f7565c, "enableQuery");
        c2080i.m4881a(this.f7566d, Progress.URL);
        c2080i.m4881a(this.f7567e, "expUrl");
        c2080i.m4880a((AbstractC2088m) this.f7568f, "security");
        c2080i.m4882a((Map) this.f7569g, "valueMap");
        c2080i.m4879a(this.f7570h, "strategylastUpdateTime");
        c2080i.m4881a(this.f7571i, "httpsUrl");
        c2080i.m4881a(this.f7572j, "httpsExpUrl");
        c2080i.m4878a(this.f7573k, "eventRecordCount");
        c2080i.m4878a(this.f7574l, "eventTimeInterval");
    }
}

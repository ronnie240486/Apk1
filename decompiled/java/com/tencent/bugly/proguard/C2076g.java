package com.tencent.bugly.proguard;

import com.lzy.okgo.model.Progress;
import java.util.HashMap;
import java.util.Map;

public final class C2076g extends AbstractC2088m {

    static byte[] f7607k = null;

    static Map<String, String> f7608l = null;

    static final boolean f7609m = true;

    public byte[] f7616g;

    public Map<String, String> f7618i;

    public Map<String, String> f7619j;

    public short f7610a = 0;

    public byte f7611b = 0;

    public int f7612c = 0;

    public int f7613d = 0;

    public String f7614e = null;

    public String f7615f = null;

    public int f7617h = 0;

    @Override
    public final void mo4852a(C2086l c2086l) {
        c2086l.m4937a(this.f7610a, 1);
        c2086l.m4929a(this.f7611b, 2);
        c2086l.m4930a(this.f7612c, 3);
        c2086l.m4930a(this.f7613d, 4);
        c2086l.m4934a(this.f7614e, 5);
        c2086l.m4934a(this.f7615f, 6);
        c2086l.m4939a(this.f7616g, 7);
        c2086l.m4930a(this.f7617h, 8);
        c2086l.m4936a((Map) this.f7618i, 9);
        c2086l.m4936a((Map) this.f7619j, 10);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f7609m) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        C2076g c2076g = (C2076g) obj;
        return C2090n.m4940a(1, (int) c2076g.f7610a) && C2090n.m4940a(1, (int) c2076g.f7611b) && C2090n.m4940a(1, c2076g.f7612c) && C2090n.m4940a(1, c2076g.f7613d) && C2090n.m4942a((Object) 1, (Object) c2076g.f7614e) && C2090n.m4942a((Object) 1, (Object) c2076g.f7615f) && C2090n.m4942a((Object) 1, (Object) c2076g.f7616g) && C2090n.m4940a(1, c2076g.f7617h) && C2090n.m4942a((Object) 1, (Object) c2076g.f7618i) && C2090n.m4942a((Object) 1, (Object) c2076g.f7619j);
    }

    @Override
    public final void mo4851a(C2084k c2084k) {
        try {
            this.f7610a = c2084k.m4912a(this.f7610a, 1, true);
            this.f7611b = c2084k.m4905a(this.f7611b, 2, true);
            this.f7612c = c2084k.m4906a(this.f7612c, 3, true);
            this.f7613d = c2084k.m4906a(this.f7613d, 4, true);
            this.f7614e = c2084k.m4915b(5, true);
            this.f7615f = c2084k.m4915b(6, true);
            if (f7607k == null) {
                f7607k = new byte[]{0};
            }
            this.f7616g = c2084k.m4916c(7, true);
            this.f7617h = c2084k.m4906a(this.f7617h, 8, true);
            if (f7608l == null) {
                HashMap map = new HashMap();
                f7608l = map;
                map.put("", "");
            }
            this.f7618i = (Map) c2084k.m4910a(f7608l, 9, true);
            if (f7608l == null) {
                HashMap map2 = new HashMap();
                f7608l = map2;
                map2.put("", "");
            }
            this.f7619j = (Map) c2084k.m4910a(f7608l, 10, true);
        } catch (Exception e5) {
            e5.printStackTrace();
            System.out.println("RequestPacket decode error " + C2074f.m4864a(this.f7616g));
            throw new RuntimeException(e5);
        }
    }

    @Override
    public final void mo4853a(StringBuilder sb, int i6) {
        C2080i c2080i = new C2080i(sb, i6);
        c2080i.m4883a(this.f7610a, "iVersion");
        c2080i.m4877a(this.f7611b, "cPacketType");
        c2080i.m4878a(this.f7612c, "iMessageType");
        c2080i.m4878a(this.f7613d, "iRequestId");
        c2080i.m4881a(this.f7614e, "sServantName");
        c2080i.m4881a(this.f7615f, "sFuncName");
        c2080i.m4885a(this.f7616g, "sBuffer");
        c2080i.m4878a(this.f7617h, "iTimeout");
        c2080i.m4882a((Map) this.f7618i, "context");
        c2080i.m4882a((Map) this.f7619j, Progress.STATUS);
    }
}

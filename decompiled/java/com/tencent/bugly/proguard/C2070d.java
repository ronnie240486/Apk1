package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class C2070d extends AbstractC2089m0 {

    protected HashMap<String, byte[]> f7592e = null;

    private HashMap<String, Object> f7594g = new HashMap<>();

    C2084k f7593f = new C2084k();

    private void m4854c(String str, Object obj) {
        this.f7594g.put(str, obj);
    }

    public final void m4855a(String str) {
        this.f7647c = str;
    }

    public void mo4860b() {
        this.f7592e = new HashMap<>();
    }

    @Override
    public <T> void mo4856a(String str, T t5) {
        if (this.f7592e == null) {
            super.mo4856a(str, t5);
            return;
        }
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t5 == null) {
            throw new IllegalArgumentException("put value can not is null");
        }
        if (t5 instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        }
        C2086l c2086l = new C2086l();
        c2086l.m4928a(this.f7647c);
        c2086l.m4933a(t5, 0);
        this.f7592e.put(str, C2090n.m4944a(c2086l.f7641a));
    }

    public final <T> T m4859b(String str, T t5) throws C2044b {
        HashMap<String, byte[]> map = this.f7592e;
        if (map != null) {
            if (!map.containsKey(str)) {
                return null;
            }
            if (this.f7594g.containsKey(str)) {
                return (T) this.f7594g.get(str);
            }
            try {
                this.f7593f.m4913a(this.f7592e.get(str));
                this.f7593f.m4907a(this.f7647c);
                T t8 = (T) this.f7593f.m4910a((Object) t5, 0, true);
                if (t8 != null) {
                    m4854c(str, t8);
                }
                return t8;
            } catch (Exception e5) {
                throw new C2044b(e5);
            }
        }
        if (!this.f7645a.containsKey(str)) {
            return null;
        }
        if (this.f7594g.containsKey(str)) {
            return (T) this.f7594g.get(str);
        }
        byte[] value = new byte[0];
        Iterator<Map.Entry<String, byte[]>> it = this.f7645a.get(str).entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<String, byte[]> next = it.next();
            next.getKey();
            value = next.getValue();
        }
        try {
            this.f7593f.m4913a(value);
            this.f7593f.m4907a(this.f7647c);
            T t10 = (T) this.f7593f.m4910a((Object) t5, 0, true);
            m4854c(str, t10);
            return t10;
        } catch (Exception e10) {
            throw new C2044b(e10);
        }
    }

    public byte[] mo4858a() {
        if (this.f7592e != null) {
            C2086l c2086l = new C2086l(0);
            c2086l.m4928a(this.f7647c);
            c2086l.m4936a((Map) this.f7592e, 0);
            return C2090n.m4944a(c2086l.f7641a);
        }
        C2086l c2086l2 = new C2086l(0);
        c2086l2.m4928a(this.f7647c);
        c2086l2.m4936a((Map) this.f7645a, 0);
        return C2090n.m4944a(c2086l2.f7641a);
    }

    @Override
    public void mo4857a(byte[] bArr) {
        try {
            super.mo4857a(bArr);
        } catch (Exception unused) {
            this.f7593f.m4913a(bArr);
            this.f7593f.m4907a(this.f7647c);
            HashMap map = new HashMap(1);
            map.put("", new byte[0]);
            this.f7592e = this.f7593f.m4911a((Map) map, 0, false);
        }
    }
}

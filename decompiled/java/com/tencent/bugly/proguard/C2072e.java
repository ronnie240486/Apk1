package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public final class C2072e extends C2070d {

    static HashMap<String, byte[]> f7597h;

    static HashMap<String, HashMap<String, byte[]>> f7598i;

    protected C2076g f7599g;

    private int f7600j;

    public C2072e() {
        C2076g c2076g = new C2076g();
        this.f7599g = c2076g;
        this.f7600j = 0;
        c2076g.f7610a = (short) 2;
    }

    @Override
    public final <T> void mo4856a(String str, T t5) {
        if (str.startsWith(".")) {
            throw new IllegalArgumentException("put name can not startwith . , now is ".concat(str));
        }
        super.mo4856a(str, t5);
    }

    @Override
    public final void mo4860b() {
        super.mo4860b();
        this.f7599g.f7610a = (short) 3;
    }

    public final void m4863c(String str) {
        this.f7599g.f7615f = str;
    }

    public final void m4862c() {
        this.f7599g.f7613d = 1;
    }

    public final void m4861b(String str) {
        this.f7599g.f7614e = str;
    }

    @Override
    public final byte[] mo4858a() {
        C2076g c2076g = this.f7599g;
        if (c2076g.f7610a == 2) {
            if (!c2076g.f7614e.equals("")) {
                if (this.f7599g.f7615f.equals("")) {
                    throw new IllegalArgumentException("funcName can not is null");
                }
            } else {
                throw new IllegalArgumentException("servantName can not is null");
            }
        } else {
            if (c2076g.f7614e == null) {
                c2076g.f7614e = "";
            }
            if (c2076g.f7615f == null) {
                c2076g.f7615f = "";
            }
        }
        C2086l c2086l = new C2086l(0);
        c2086l.m4928a(this.f7647c);
        if (this.f7599g.f7610a == 2) {
            c2086l.m4936a((Map) this.f7645a, 0);
        } else {
            c2086l.m4936a((Map) ((C2070d) this).f7592e, 0);
        }
        this.f7599g.f7616g = C2090n.m4944a(c2086l.f7641a);
        C2086l c2086l2 = new C2086l(0);
        c2086l2.m4928a(this.f7647c);
        this.f7599g.mo4852a(c2086l2);
        byte[] bArrM4944a = C2090n.m4944a(c2086l2.f7641a);
        int length = bArrM4944a.length + 4;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        byteBufferAllocate.putInt(length).put(bArrM4944a).flip();
        return byteBufferAllocate.array();
    }

    @Override
    public final void mo4857a(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                C2084k c2084k = new C2084k(bArr, (byte) 0);
                c2084k.m4907a(this.f7647c);
                this.f7599g.mo4851a(c2084k);
                C2076g c2076g = this.f7599g;
                if (c2076g.f7610a == 3) {
                    C2084k c2084k2 = new C2084k(c2076g.f7616g);
                    c2084k2.m4907a(this.f7647c);
                    if (f7597h == null) {
                        HashMap<String, byte[]> map = new HashMap<>();
                        f7597h = map;
                        map.put("", new byte[0]);
                    }
                    ((C2070d) this).f7592e = c2084k2.m4911a((Map) f7597h, 0, false);
                    return;
                }
                C2084k c2084k3 = new C2084k(c2076g.f7616g);
                c2084k3.m4907a(this.f7647c);
                if (f7598i == null) {
                    f7598i = new HashMap<>();
                    HashMap<String, byte[]> map2 = new HashMap<>();
                    map2.put("", new byte[0]);
                    f7598i.put("", map2);
                }
                this.f7645a = c2084k3.m4911a((Map) f7598i, 0, false);
                this.f7646b = new HashMap<>();
                return;
            } catch (Exception e5) {
                throw new RuntimeException(e5);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }
}

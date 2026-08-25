package com.tencent.bugly.proguard;

public final class C2059bn extends AbstractC2088m implements Cloneable {

    static byte[] f7487d;

    public byte f7488a;

    public String f7489b;

    public byte[] f7490c;

    public C2059bn() {
        this.f7488a = (byte) 0;
        this.f7489b = "";
        this.f7490c = null;
    }

    @Override
    public final void mo4853a(StringBuilder sb, int i6) {
    }

    @Override
    public final void mo4852a(C2086l c2086l) {
        c2086l.m4929a(this.f7488a, 0);
        c2086l.m4934a(this.f7489b, 1);
        byte[] bArr = this.f7490c;
        if (bArr != null) {
            c2086l.m4939a(bArr, 2);
        }
    }

    public C2059bn(byte b8, String str, byte[] bArr) {
        this.f7488a = b8;
        this.f7489b = str;
        this.f7490c = bArr;
    }

    @Override
    public final void mo4851a(C2084k c2084k) {
        this.f7488a = c2084k.m4905a(this.f7488a, 0, true);
        this.f7489b = c2084k.m4915b(1, true);
        if (f7487d == null) {
            f7487d = new byte[]{0};
        }
        this.f7490c = c2084k.m4916c(2, false);
    }
}

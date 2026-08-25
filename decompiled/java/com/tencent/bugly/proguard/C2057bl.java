package com.tencent.bugly.proguard;

public final class C2057bl extends AbstractC2088m implements Cloneable {

    public String f7479a = "";

    public String f7480b = "";

    public String f7481c = "";

    public String f7482d = "";

    public String f7483e = "";

    @Override
    public final void mo4853a(StringBuilder sb, int i6) {
    }

    @Override
    public final void mo4852a(C2086l c2086l) {
        c2086l.m4934a(this.f7479a, 0);
        String str = this.f7480b;
        if (str != null) {
            c2086l.m4934a(str, 1);
        }
        String str2 = this.f7481c;
        if (str2 != null) {
            c2086l.m4934a(str2, 2);
        }
        String str3 = this.f7482d;
        if (str3 != null) {
            c2086l.m4934a(str3, 3);
        }
        String str4 = this.f7483e;
        if (str4 != null) {
            c2086l.m4934a(str4, 4);
        }
    }

    @Override
    public final void mo4851a(C2084k c2084k) {
        this.f7479a = c2084k.m4915b(0, true);
        this.f7480b = c2084k.m4915b(1, false);
        this.f7481c = c2084k.m4915b(2, false);
        this.f7482d = c2084k.m4915b(3, false);
        this.f7483e = c2084k.m4915b(4, false);
    }
}

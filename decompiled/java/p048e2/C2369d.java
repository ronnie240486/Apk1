package p048e2;

import java.io.IOException;
import java.util.ArrayList;
import okio.Path;

public final class C2369d {

    public final String f8290a;

    public final long[] f8291b;

    public final ArrayList f8292c;

    public final ArrayList f8293d;

    public boolean f8294e;

    public boolean f8295f;

    public C2368c f8296g;

    public int f8297h;

    public final C2373h f8298i;

    public C2369d(C2373h c2373h, String str) {
        this.f8298i = c2373h;
        this.f8290a = str;
        c2373h.getClass();
        this.f8291b = new long[2];
        this.f8292c = new ArrayList(2);
        this.f8293d = new ArrayList(2);
        StringBuilder sb = new StringBuilder(str);
        sb.append('.');
        int length = sb.length();
        for (int i6 = 0; i6 < 2; i6++) {
            sb.append(i6);
            this.f8292c.add(this.f8298i.f8304a.resolve(sb.toString()));
            sb.append(".tmp");
            this.f8293d.add(this.f8298i.f8304a.resolve(sb.toString()));
            sb.setLength(length);
        }
    }

    public final C2370e m5385a() {
        if (!this.f8294e || this.f8296g != null || this.f8295f) {
            return null;
        }
        ArrayList arrayList = this.f8292c;
        int size = arrayList.size();
        int i6 = 0;
        while (true) {
            C2373h c2373h = this.f8298i;
            if (i6 >= size) {
                this.f8297h++;
                return new C2370e(c2373h, this);
            }
            if (!c2373h.f8319p.exists((Path) arrayList.get(i6))) {
                try {
                    c2373h.m5395i(this);
                } catch (IOException unused) {
                }
                return null;
            }
            i6++;
        }
    }
}

package p197s2;

import java.io.File;
import p048e2.C2368c;

public final class C3698b {

    public final String f12383a;

    public final long[] f12384b;

    public final File[] f12385c;

    public final File[] f12386d;

    public boolean f12387e;

    public C2368c f12388f;

    public final C3699c f12389g;

    public C3698b(C3699c c3699c, String str) {
        this.f12389g = c3699c;
        this.f12383a = str;
        int i6 = c3699c.f12396g;
        this.f12384b = new long[i6];
        this.f12385c = new File[i6];
        this.f12386d = new File[i6];
        StringBuilder sb = new StringBuilder(str);
        sb.append('.');
        int length = sb.length();
        for (int i10 = 0; i10 < c3699c.f12396g; i10++) {
            sb.append(i10);
            File[] fileArr = this.f12385c;
            String string = sb.toString();
            File file = c3699c.f12390a;
            fileArr[i10] = new File(file, string);
            sb.append(".tmp");
            this.f12386d[i10] = new File(file, sb.toString());
            sb.setLength(length);
        }
    }

    public final String m7449a() {
        StringBuilder sb = new StringBuilder();
        for (long j10 : this.f12384b) {
            sb.append(' ');
            sb.append(j10);
        }
        return sb.toString();
    }
}

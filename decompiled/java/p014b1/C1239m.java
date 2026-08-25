package p014b1;

import java.nio.ByteBuffer;
import p001a0.C0023f;
import p024c1.C1377a;
import p024c1.C1378b;

public final class C1239m {

    public static final ThreadLocal f3937d = new ThreadLocal();

    public final int f3938a;

    public final C0023f f3939b;

    public volatile int f3940c = 0;

    public C1239m(C0023f c0023f, int i6) {
        this.f3939b = c0023f;
        this.f3938a = i6;
    }

    public final int m3113a(int i6) {
        C1377a c1377aM3115c = m3115c();
        int iM3244a = c1377aM3115c.m3244a(16);
        if (iM3244a == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = (ByteBuffer) c1377aM3115c.f4194d;
        int i10 = iM3244a + c1377aM3115c.f4191a;
        return byteBuffer.getInt((i6 * 4) + byteBuffer.getInt(i10) + i10 + 4);
    }

    public final int m3114b() {
        C1377a c1377aM3115c = m3115c();
        int iM3244a = c1377aM3115c.m3244a(16);
        if (iM3244a == 0) {
            return 0;
        }
        int i6 = iM3244a + c1377aM3115c.f4191a;
        return ((ByteBuffer) c1377aM3115c.f4194d).getInt(((ByteBuffer) c1377aM3115c.f4194d).getInt(i6) + i6);
    }

    public final C1377a m3115c() {
        ThreadLocal threadLocal = f3937d;
        C1377a c1377a = (C1377a) threadLocal.get();
        if (c1377a == null) {
            c1377a = new C1377a();
            threadLocal.set(c1377a);
        }
        C1378b c1378b = (C1378b) this.f3939b.f44b;
        int iM3244a = c1378b.m3244a(6);
        if (iM3244a != 0) {
            int i6 = iM3244a + c1378b.f4191a;
            int i10 = (this.f3938a * 4) + ((ByteBuffer) c1378b.f4194d).getInt(i6) + i6 + 4;
            int i11 = ((ByteBuffer) c1378b.f4194d).getInt(i10) + i10;
            ByteBuffer byteBuffer = (ByteBuffer) c1378b.f4194d;
            c1377a.f4194d = byteBuffer;
            if (byteBuffer != null) {
                c1377a.f4191a = i11;
                int i12 = i11 - byteBuffer.getInt(i11);
                c1377a.f4192b = i12;
                c1377a.f4193c = ((ByteBuffer) c1377a.f4194d).getShort(i12);
            } else {
                c1377a.f4191a = 0;
                c1377a.f4192b = 0;
                c1377a.f4193c = 0;
            }
        }
        return c1377a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        C1377a c1377aM3115c = m3115c();
        int iM3244a = c1377aM3115c.m3244a(4);
        sb.append(Integer.toHexString(iM3244a != 0 ? ((ByteBuffer) c1377aM3115c.f4194d).getInt(iM3244a + c1377aM3115c.f4191a) : 0));
        sb.append(", codepoints:");
        int iM3114b = m3114b();
        for (int i6 = 0; i6 < iM3114b; i6++) {
            sb.append(Integer.toHexString(m3113a(i6)));
            sb.append(" ");
        }
        return sb.toString();
    }
}

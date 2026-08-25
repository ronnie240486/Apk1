package p048e2;

import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.bumptech.glide.AbstractC1465c;
import java.io.Closeable;
import java.io.EOFException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import p008a9.InterfaceC0079i;
import p009aa.C0083c;
import p103j9.AbstractC2796i;
import p123l5.AbstractC2973a;
import p156o9.AbstractC3281e;
import p185r2.AbstractC3587f;
import p192r9.AbstractC3648f;
import p192r9.AbstractC3656n;
import p192r9.C3647e;
import p213t9.AbstractC3865u;
import p213t9.C3826d1;
import p213t9.C3857q;
import p213t9.C3864t0;
import p243w8.C4070l;
import p254x9.C4162d;
import p275z9.C4369k;
import p275z9.ExecutorC4361c;

public final class C2373h implements Closeable, Flushable {

    public static final C3647e f8303q = new C3647e("[a-z0-9_-]{1,120}");

    public final Path f8304a;

    public final long f8305b;

    public final Path f8306c;

    public final Path f8307d;

    public final Path f8308e;

    public final LinkedHashMap f8309f;

    public final C4162d f8310g;

    public long f8311h;

    public int f8312i;

    public BufferedSink f8313j;

    public boolean f8314k;

    public boolean f8315l;

    public boolean f8316m;

    public boolean f8317n;

    public boolean f8318o;

    public final C2371f f8319p;

    public C2373h(long j10, FileSystem fileSystem, Path path, ExecutorC4361c executorC4361c) {
        this.f8304a = path;
        this.f8305b = j10;
        if (j10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f8306c = path.resolve("journal");
        this.f8307d = path.resolve("journal.tmp");
        this.f8308e = path.resolve("journal.bkp");
        this.f8309f = new LinkedHashMap(0, 0.75f, true);
        C3826d1 c3826d1 = new C3826d1(null);
        executorC4361c.getClass();
        InterfaceC0079i interfaceC0079iM3475j = AbstractC1465c.m3475j(c3826d1, C4369k.f14838c.m8415h(1));
        this.f8310g = new C4162d(interfaceC0079iM3475j.mo252e(C3857q.f12952b) == null ? interfaceC0079iM3475j.mo253f(new C3864t0(null)) : interfaceC0079iM3475j);
        this.f8319p = new C2371f(fileSystem);
    }

    public static final void m5386a(C2373h c2373h, C2368c c2368c, boolean z7) {
        synchronized (c2373h) {
            C2369d c2369d = (C2369d) c2368c.f8287b;
            if (!AbstractC2796i.m5780a(c2369d.f8296g, c2368c)) {
                throw new IllegalStateException("Check failed.");
            }
            if (!z7 || c2369d.f8295f) {
                for (int i6 = 0; i6 < 2; i6++) {
                    c2373h.f8319p.delete((Path) c2369d.f8293d.get(i6));
                }
            } else {
                for (int i10 = 0; i10 < 2; i10++) {
                    if (((boolean[]) c2368c.f8288c)[i10] && !c2373h.f8319p.exists((Path) c2369d.f8293d.get(i10))) {
                        c2368c.m5382d(false);
                        return;
                    }
                }
                for (int i11 = 0; i11 < 2; i11++) {
                    Path path = (Path) c2369d.f8293d.get(i11);
                    Path path2 = (Path) c2369d.f8292c.get(i11);
                    if (c2373h.f8319p.exists(path)) {
                        c2373h.f8319p.atomicMove(path, path2);
                    } else {
                        C2371f c2371f = c2373h.f8319p;
                        Path path3 = (Path) c2369d.f8292c.get(i11);
                        if (!c2371f.exists(path3)) {
                            AbstractC3587f.m7208a(c2371f.sink(path3));
                        }
                    }
                    long j10 = c2369d.f8291b[i11];
                    Long size = c2373h.f8319p.metadata(path2).getSize();
                    long jLongValue = size != null ? size.longValue() : 0L;
                    c2369d.f8291b[i11] = jLongValue;
                    c2373h.f8311h = (c2373h.f8311h - j10) + jLongValue;
                }
            }
            c2369d.f8296g = null;
            if (c2369d.f8295f) {
                c2373h.m5395i(c2369d);
                return;
            }
            c2373h.f8312i++;
            BufferedSink bufferedSink = c2373h.f8313j;
            AbstractC2796i.m5782c(bufferedSink);
            if (z7 || c2369d.f8294e) {
                c2369d.f8294e = true;
                bufferedSink.writeUtf8("CLEAN");
                bufferedSink.writeByte(32);
                bufferedSink.writeUtf8(c2369d.f8290a);
                for (long j11 : c2369d.f8291b) {
                    bufferedSink.writeByte(32).writeDecimalLong(j11);
                }
                bufferedSink.writeByte(10);
            } else {
                c2373h.f8309f.remove(c2369d.f8290a);
                bufferedSink.writeUtf8("REMOVE");
                bufferedSink.writeByte(32);
                bufferedSink.writeUtf8(c2369d.f8290a);
                bufferedSink.writeByte(10);
            }
            bufferedSink.flush();
            if (c2373h.f8311h > c2373h.f8305b) {
                c2373h.m5391e();
            } else if (c2373h.f8312i >= 2000) {
                c2373h.m5391e();
            }
        }
    }

    public static void m5387k(String str) {
        C3647e c3647e = f8303q;
        c3647e.getClass();
        AbstractC2796i.m5785f(str, "input");
        if (c3647e.f12254a.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + '\"').toString());
    }

    public final synchronized C2368c m5388b(String str) {
        try {
            if (this.f8316m) {
                throw new IllegalStateException("cache is closed");
            }
            m5387k(str);
            m5390d();
            C2369d c2369d = (C2369d) this.f8309f.get(str);
            if ((c2369d != null ? c2369d.f8296g : null) != null) {
                return null;
            }
            if (c2369d != null && c2369d.f8297h != 0) {
                return null;
            }
            if (!this.f8317n && !this.f8318o) {
                BufferedSink bufferedSink = this.f8313j;
                AbstractC2796i.m5782c(bufferedSink);
                bufferedSink.writeUtf8("DIRTY");
                bufferedSink.writeByte(32);
                bufferedSink.writeUtf8(str);
                bufferedSink.writeByte(10);
                bufferedSink.flush();
                if (this.f8314k) {
                    return null;
                }
                if (c2369d == null) {
                    c2369d = new C2369d(this, str);
                    this.f8309f.put(str, c2369d);
                }
                C2368c c2368c = new C2368c(this, c2369d);
                c2369d.f8296g = c2368c;
                return c2368c;
            }
            m5391e();
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized C2370e m5389c(String str) {
        C2370e c2370eM5385a;
        if (this.f8316m) {
            throw new IllegalStateException("cache is closed");
        }
        m5387k(str);
        m5390d();
        C2369d c2369d = (C2369d) this.f8309f.get(str);
        if (c2369d != null && (c2370eM5385a = c2369d.m5385a()) != null) {
            boolean z7 = true;
            this.f8312i++;
            BufferedSink bufferedSink = this.f8313j;
            AbstractC2796i.m5782c(bufferedSink);
            bufferedSink.writeUtf8("READ");
            bufferedSink.writeByte(32);
            bufferedSink.writeUtf8(str);
            bufferedSink.writeByte(10);
            if (this.f8312i < 2000) {
                z7 = false;
            }
            if (z7) {
                m5391e();
            }
            return c2370eM5385a;
        }
        return null;
    }

    @Override
    public final synchronized void close() {
        try {
            if (this.f8315l && !this.f8316m) {
                for (C2369d c2369d : (C2369d[]) this.f8309f.values().toArray(new C2369d[0])) {
                    C2368c c2368c = c2369d.f8296g;
                    if (c2368c != null) {
                        C2369d c2369d2 = (C2369d) c2368c.f8287b;
                        if (AbstractC2796i.m5780a(c2369d2.f8296g, c2368c)) {
                            c2369d2.f8295f = true;
                        }
                    }
                }
                m5396j();
                AbstractC3865u.m7689d(this.f8310g);
                BufferedSink bufferedSink = this.f8313j;
                AbstractC2796i.m5782c(bufferedSink);
                bufferedSink.close();
                this.f8313j = null;
                this.f8316m = true;
                return;
            }
            this.f8316m = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void m5390d() {
        try {
            if (this.f8315l) {
                return;
            }
            this.f8319p.delete(this.f8307d);
            if (this.f8319p.exists(this.f8308e)) {
                if (this.f8319p.exists(this.f8306c)) {
                    this.f8319p.delete(this.f8308e);
                } else {
                    this.f8319p.atomicMove(this.f8308e, this.f8306c);
                }
            }
            if (this.f8319p.exists(this.f8306c)) {
                try {
                    m5393g();
                    m5392f();
                    this.f8315l = true;
                    return;
                } catch (IOException unused) {
                    try {
                        close();
                        AbstractC3281e.m6625o(this.f8319p, this.f8304a);
                        this.f8316m = false;
                        m5397l();
                        this.f8315l = true;
                    } catch (Throwable th) {
                        this.f8316m = false;
                        throw th;
                    }
                }
            }
            m5397l();
            this.f8315l = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void m5391e() {
        AbstractC3865u.m7696k(this.f8310g, null, new C2372g(this, null), 3);
    }

    public final void m5392f() throws IOException {
        Iterator it = this.f8309f.values().iterator();
        long j10 = 0;
        while (it.hasNext()) {
            C2369d c2369d = (C2369d) it.next();
            int i6 = 0;
            if (c2369d.f8296g == null) {
                while (i6 < 2) {
                    j10 += c2369d.f8291b[i6];
                    i6++;
                }
            } else {
                c2369d.f8296g = null;
                while (i6 < 2) {
                    Path path = (Path) c2369d.f8292c.get(i6);
                    C2371f c2371f = this.f8319p;
                    c2371f.delete(path);
                    c2371f.delete((Path) c2369d.f8293d.get(i6));
                    i6++;
                }
                it.remove();
            }
        }
        this.f8311h = j10;
    }

    @Override
    public final synchronized void flush() {
        if (this.f8315l) {
            if (this.f8316m) {
                throw new IllegalStateException("cache is closed");
            }
            m5396j();
            BufferedSink bufferedSink = this.f8313j;
            AbstractC2796i.m5782c(bufferedSink);
            bufferedSink.flush();
        }
    }

    public final void m5393g() throws Throwable {
        C4070l c4070l;
        C2371f c2371f = this.f8319p;
        Path path = this.f8306c;
        BufferedSource bufferedSourceBuffer = Okio.buffer(c2371f.source(path));
        Throwable th = null;
        try {
            String utf8LineStrict = bufferedSourceBuffer.readUtf8LineStrict();
            String utf8LineStrict2 = bufferedSourceBuffer.readUtf8LineStrict();
            String utf8LineStrict3 = bufferedSourceBuffer.readUtf8LineStrict();
            String utf8LineStrict4 = bufferedSourceBuffer.readUtf8LineStrict();
            String utf8LineStrict5 = bufferedSourceBuffer.readUtf8LineStrict();
            if (!"libcore.io.DiskLruCache".equals(utf8LineStrict) || !IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(utf8LineStrict2) || !AbstractC2796i.m5780a(String.valueOf(1), utf8LineStrict3) || !AbstractC2796i.m5780a(String.valueOf(2), utf8LineStrict4) || utf8LineStrict5.length() > 0) {
                throw new IOException("unexpected journal header: [" + utf8LineStrict + ", " + utf8LineStrict2 + ", " + utf8LineStrict3 + ", " + utf8LineStrict4 + ", " + utf8LineStrict5 + ']');
            }
            int i6 = 0;
            while (true) {
                try {
                    m5394h(bufferedSourceBuffer.readUtf8LineStrict());
                    i6++;
                } catch (EOFException unused) {
                    this.f8312i = i6 - this.f8309f.size();
                    if (bufferedSourceBuffer.exhausted()) {
                        this.f8313j = Okio.buffer(new C2374i(c2371f.appendingSink(path), new C0083c(1, this)));
                    } else {
                        m5397l();
                    }
                    c4070l = C4070l.f13734a;
                    try {
                        bufferedSourceBuffer.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    if (th == null) {
                        throw th;
                    }
                    AbstractC2796i.m5782c(c4070l);
                }
            }
        } catch (Throwable th3) {
            if (bufferedSourceBuffer != null) {
                try {
                    bufferedSourceBuffer.close();
                } catch (Throwable th4) {
                    AbstractC2973a.m6013a(th3, th4);
                }
            }
            th = th3;
            c4070l = null;
            if (th == null) {
                throw th;
            }
            AbstractC2796i.m5782c(c4070l);
        }
    }

    public final void m5394h(String str) throws IOException {
        String strSubstring;
        int iM7380b0 = AbstractC3648f.m7380b0(str, ' ', 0, false, 6);
        if (iM7380b0 == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i6 = iM7380b0 + 1;
        int iM7380b1 = AbstractC3648f.m7380b0(str, ' ', i6, false, 4);
        LinkedHashMap linkedHashMap = this.f8309f;
        if (iM7380b1 == -1) {
            strSubstring = str.substring(i6);
            AbstractC2796i.m5784e(strSubstring, "substring(...)");
            if (iM7380b0 == 6 && AbstractC3656n.m7404V(str, "REMOVE", false)) {
                linkedHashMap.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i6, iM7380b1);
            AbstractC2796i.m5784e(strSubstring, "substring(...)");
        }
        Object c2369d = linkedHashMap.get(strSubstring);
        if (c2369d == null) {
            c2369d = new C2369d(this, strSubstring);
            linkedHashMap.put(strSubstring, c2369d);
        }
        C2369d c2369d2 = (C2369d) c2369d;
        if (iM7380b1 == -1 || iM7380b0 != 5 || !AbstractC3656n.m7404V(str, "CLEAN", false)) {
            if (iM7380b1 == -1 && iM7380b0 == 5 && AbstractC3656n.m7404V(str, "DIRTY", false)) {
                c2369d2.f8296g = new C2368c(this, c2369d2);
                return;
            } else {
                if (iM7380b1 != -1 || iM7380b0 != 4 || !AbstractC3656n.m7404V(str, "READ", false)) {
                    throw new IOException("unexpected journal line: ".concat(str));
                }
                return;
            }
        }
        String strSubstring2 = str.substring(iM7380b1 + 1);
        AbstractC2796i.m5784e(strSubstring2, "substring(...)");
        List listM7386h0 = AbstractC3648f.m7386h0(strSubstring2, new char[]{' '});
        c2369d2.f8294e = true;
        c2369d2.f8296g = null;
        int size = listM7386h0.size();
        c2369d2.f8298i.getClass();
        if (size != 2) {
            throw new IOException("unexpected journal line: " + listM7386h0);
        }
        try {
            int size2 = listM7386h0.size();
            for (int i10 = 0; i10 < size2; i10++) {
                c2369d2.f8291b[i10] = Long.parseLong((String) listM7386h0.get(i10));
            }
        } catch (NumberFormatException unused) {
            throw new IOException("unexpected journal line: " + listM7386h0);
        }
    }

    public final void m5395i(C2369d c2369d) {
        BufferedSink bufferedSink;
        int i6 = c2369d.f8297h;
        String str = c2369d.f8290a;
        if (i6 > 0 && (bufferedSink = this.f8313j) != null) {
            bufferedSink.writeUtf8("DIRTY");
            bufferedSink.writeByte(32);
            bufferedSink.writeUtf8(str);
            bufferedSink.writeByte(10);
            bufferedSink.flush();
        }
        if (c2369d.f8297h > 0 || c2369d.f8296g != null) {
            c2369d.f8295f = true;
            return;
        }
        for (int i10 = 0; i10 < 2; i10++) {
            this.f8319p.delete((Path) c2369d.f8292c.get(i10));
            long j10 = this.f8311h;
            long[] jArr = c2369d.f8291b;
            this.f8311h = j10 - jArr[i10];
            jArr[i10] = 0;
        }
        this.f8312i++;
        BufferedSink bufferedSink2 = this.f8313j;
        if (bufferedSink2 != null) {
            bufferedSink2.writeUtf8("REMOVE");
            bufferedSink2.writeByte(32);
            bufferedSink2.writeUtf8(str);
            bufferedSink2.writeByte(10);
        }
        this.f8309f.remove(str);
        if (this.f8312i >= 2000) {
            m5391e();
        }
    }

    public final void m5396j() {
        while (this.f8311h > this.f8305b) {
            for (C2369d c2369d : this.f8309f.values()) {
                if (!c2369d.f8295f) {
                    m5395i(c2369d);
                }
            }
            return;
        }
        this.f8317n = false;
    }

    public final synchronized void m5397l() {
        C4070l c4070l;
        try {
            BufferedSink bufferedSink = this.f8313j;
            if (bufferedSink != null) {
                bufferedSink.close();
            }
            BufferedSink bufferedSinkBuffer = Okio.buffer(this.f8319p.sink(this.f8307d, false));
            Throwable th = null;
            try {
                bufferedSinkBuffer.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
                bufferedSinkBuffer.writeUtf8(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE).writeByte(10);
                bufferedSinkBuffer.writeDecimalLong(1).writeByte(10);
                bufferedSinkBuffer.writeDecimalLong(2).writeByte(10);
                bufferedSinkBuffer.writeByte(10);
                for (C2369d c2369d : this.f8309f.values()) {
                    if (c2369d.f8296g != null) {
                        bufferedSinkBuffer.writeUtf8("DIRTY");
                        bufferedSinkBuffer.writeByte(32);
                        bufferedSinkBuffer.writeUtf8(c2369d.f8290a);
                        bufferedSinkBuffer.writeByte(10);
                    } else {
                        bufferedSinkBuffer.writeUtf8("CLEAN");
                        bufferedSinkBuffer.writeByte(32);
                        bufferedSinkBuffer.writeUtf8(c2369d.f8290a);
                        for (long j10 : c2369d.f8291b) {
                            bufferedSinkBuffer.writeByte(32).writeDecimalLong(j10);
                        }
                        bufferedSinkBuffer.writeByte(10);
                    }
                }
                c4070l = C4070l.f13734a;
                try {
                    bufferedSinkBuffer.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                if (bufferedSinkBuffer != null) {
                    try {
                        bufferedSinkBuffer.close();
                    } catch (Throwable th4) {
                        AbstractC2973a.m6013a(th3, th4);
                    }
                }
                c4070l = null;
                th = th3;
            }
            if (th != null) {
                throw th;
            }
            AbstractC2796i.m5782c(c4070l);
            if (this.f8319p.exists(this.f8306c)) {
                this.f8319p.atomicMove(this.f8306c, this.f8308e);
                this.f8319p.atomicMove(this.f8307d, this.f8306c);
                this.f8319p.delete(this.f8308e);
            } else {
                this.f8319p.atomicMove(this.f8307d, this.f8306c);
            }
            this.f8313j = Okio.buffer(new C2374i(this.f8319p.appendingSink(this.f8306c), new C0083c(1, this)));
            this.f8312i = 0;
            this.f8314k = false;
            this.f8318o = false;
        } catch (Throwable th5) {
            throw th5;
        }
    }
}

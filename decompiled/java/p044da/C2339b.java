package p044da;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p000a.RunnableC0005f;

public final class C2339b {

    public final File f8146f;

    public final Map f8145e = Collections.synchronizedMap(new HashMap());

    public final long f8143c = 20000000;

    public final int f8144d = 1000;

    public final AtomicLong f8141a = new AtomicLong();

    public final AtomicInteger f8142b = new AtomicInteger();

    public C2339b(File file) {
        this.f8146f = file;
        new Thread(new RunnableC0005f(13, this)).start();
    }

    public static void m5301a(C2339b c2339b, File file) {
        AtomicLong atomicLong;
        long jM5304d;
        AtomicInteger atomicInteger = c2339b.f8142b;
        int iAddAndGet = atomicInteger.get();
        do {
            int i6 = iAddAndGet + 1;
            atomicLong = c2339b.f8141a;
            if (i6 <= c2339b.f8144d) {
                break;
            }
            jM5304d = c2339b.m5304d();
            atomicLong.addAndGet(-jM5304d);
            iAddAndGet = atomicInteger.addAndGet(-1);
        } while (jM5304d != 0);
        atomicInteger.addAndGet(1);
        long length = file.length();
        long j10 = atomicLong.get();
        while (true) {
            long j11 = c2339b.f8143c;
            if (j11 <= 0 || j10 + length <= j11) {
                break;
            }
            long jM5304d2 = c2339b.m5304d();
            long jAddAndGet = atomicLong.addAndGet(-jM5304d2);
            if (jM5304d2 == 0) {
                break;
            } else {
                j10 = jAddAndGet;
            }
        }
        atomicLong.addAndGet(length);
        long jCurrentTimeMillis = System.currentTimeMillis();
        Long lValueOf = Long.valueOf(jCurrentTimeMillis);
        file.setLastModified(jCurrentTimeMillis);
        c2339b.f8145e.put(file, lValueOf);
    }

    public final File m5302b(String str) {
        File fileM5303c = m5303c(str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        Long lValueOf = Long.valueOf(jCurrentTimeMillis);
        fileM5303c.setLastModified(jCurrentTimeMillis);
        this.f8145e.put(fileM5303c, lValueOf);
        return fileM5303c;
    }

    public final File m5303c(String str) {
        return new File(this.f8146f, str.hashCode() + "");
    }

    public final long m5304d() {
        File file;
        if (this.f8145e.isEmpty()) {
            return 0L;
        }
        Set<Map.Entry> setEntrySet = this.f8145e.entrySet();
        synchronized (this.f8145e) {
            try {
                file = null;
                Long l9 = null;
                for (Map.Entry entry : setEntrySet) {
                    if (file == null) {
                        file = (File) entry.getKey();
                        l9 = (Long) entry.getValue();
                    } else {
                        Long l10 = (Long) entry.getValue();
                        if (l10.longValue() < l9.longValue()) {
                            file = (File) entry.getKey();
                            l9 = l10;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        long length = file != null ? file.length() : 0L;
        if (file != null && file.delete()) {
            this.f8145e.remove(file);
        }
        return length;
    }
}

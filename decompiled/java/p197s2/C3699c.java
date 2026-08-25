package p197s2;

import android.os.Build;
import android.os.StrictMode;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p048e2.C2368c;
import p119l1.CallableC2961b;
import p187r4.C3624n;

public final class C3699c implements Closeable {

    public final File f12390a;

    public final File f12391b;

    public final File f12392c;

    public final File f12393d;

    public final long f12395f;

    public BufferedWriter f12398i;

    public int f12400k;

    public long f12397h = 0;

    public final LinkedHashMap f12399j = new LinkedHashMap(0, 0.75f, true);

    public long f12401l = 0;

    public final ThreadPoolExecutor f12402m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC3697a());

    public final CallableC2961b f12403n = new CallableC2961b(2, this);

    public final int f12394e = 1;

    public final int f12396g = 1;

    public C3699c(File file, long j10) {
        this.f12390a = file;
        this.f12391b = new File(file, "journal");
        this.f12392c = new File(file, "journal.tmp");
        this.f12393d = new File(file, "journal.bkp");
        this.f12395f = j10;
    }

    public static void m7450a(C3699c c3699c, C2368c c2368c, boolean z7) {
        synchronized (c3699c) {
            C3698b c3698b = (C3698b) c2368c.f8287b;
            if (c3698b.f12388f != c2368c) {
                throw new IllegalStateException();
            }
            if (z7 && !c3698b.f12387e) {
                for (int i6 = 0; i6 < c3699c.f12396g; i6++) {
                    if (!((boolean[]) c2368c.f8288c)[i6]) {
                        c2368c.m5381c();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i6);
                    }
                    if (!c3698b.f12386d[i6].exists()) {
                        c2368c.m5381c();
                        return;
                    }
                }
            }
            for (int i10 = 0; i10 < c3699c.f12396g; i10++) {
                File file = c3698b.f12386d[i10];
                if (!z7) {
                    m7452c(file);
                } else if (file.exists()) {
                    File file2 = c3698b.f12385c[i10];
                    file.renameTo(file2);
                    long j10 = c3698b.f12384b[i10];
                    long length = file2.length();
                    c3698b.f12384b[i10] = length;
                    c3699c.f12397h = (c3699c.f12397h - j10) + length;
                }
            }
            c3699c.f12400k++;
            c3698b.f12388f = null;
            if (c3698b.f12387e || z7) {
                c3698b.f12387e = true;
                c3699c.f12398i.append((CharSequence) "CLEAN");
                c3699c.f12398i.append(' ');
                c3699c.f12398i.append((CharSequence) c3698b.f12383a);
                c3699c.f12398i.append((CharSequence) c3698b.m7449a());
                c3699c.f12398i.append('\n');
                if (z7) {
                    c3699c.f12401l++;
                }
            } else {
                c3699c.f12399j.remove(c3698b.f12383a);
                c3699c.f12398i.append((CharSequence) "REMOVE");
                c3699c.f12398i.append(' ');
                c3699c.f12398i.append((CharSequence) c3698b.f12383a);
                c3699c.f12398i.append('\n');
            }
            m7453e(c3699c.f12398i);
            if (c3699c.f12397h > c3699c.f12395f || c3699c.m7458g()) {
                c3699c.f12402m.submit(c3699c.f12403n);
            }
        }
    }

    public static void m7451b(BufferedWriter bufferedWriter) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            bufferedWriter.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            bufferedWriter.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void m7452c(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void m7453e(BufferedWriter bufferedWriter) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            bufferedWriter.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            bufferedWriter.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static C3699c m7454h(File file, long j10) throws IOException {
        if (j10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                m7455m(file2, file3, false);
            }
        }
        C3699c c3699c = new C3699c(file, j10);
        if (c3699c.f12391b.exists()) {
            try {
                c3699c.m7460j();
                c3699c.m7459i();
                return c3699c;
            } catch (IOException e5) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e5.getMessage() + ", removing");
                c3699c.close();
                AbstractC3702f.m7465a(c3699c.f12390a);
            }
        }
        file.mkdirs();
        C3699c c3699c2 = new C3699c(file, j10);
        c3699c2.m7462l();
        return c3699c2;
    }

    public static void m7455m(File file, File file2, boolean z7) throws IOException {
        if (z7) {
            m7452c(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    @Override
    public final synchronized void close() {
        try {
            if (this.f12398i == null) {
                return;
            }
            Iterator it = new ArrayList(this.f12399j.values()).iterator();
            while (it.hasNext()) {
                C2368c c2368c = ((C3698b) it.next()).f12388f;
                if (c2368c != null) {
                    c2368c.m5381c();
                }
            }
            m7463n();
            m7451b(this.f12398i);
            this.f12398i = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final C2368c m7456d(String str) {
        synchronized (this) {
            try {
                if (this.f12398i == null) {
                    throw new IllegalStateException("cache is closed");
                }
                C3698b c3698b = (C3698b) this.f12399j.get(str);
                if (c3698b == null) {
                    c3698b = new C3698b(this, str);
                    this.f12399j.put(str, c3698b);
                } else if (c3698b.f12388f != null) {
                    return null;
                }
                C2368c c2368c = new C2368c(this, c3698b);
                c3698b.f12388f = c2368c;
                this.f12398i.append((CharSequence) "DIRTY");
                this.f12398i.append(' ');
                this.f12398i.append((CharSequence) str);
                this.f12398i.append('\n');
                m7453e(this.f12398i);
                return c2368c;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized C3624n m7457f(String str) {
        if (this.f12398i == null) {
            throw new IllegalStateException("cache is closed");
        }
        C3698b c3698b = (C3698b) this.f12399j.get(str);
        if (c3698b == null) {
            return null;
        }
        if (!c3698b.f12387e) {
            return null;
        }
        for (File file : c3698b.f12385c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.f12400k++;
        this.f12398i.append((CharSequence) "READ");
        this.f12398i.append(' ');
        this.f12398i.append((CharSequence) str);
        this.f12398i.append('\n');
        if (m7458g()) {
            this.f12402m.submit(this.f12403n);
        }
        return new C3624n(2, c3698b.f12385c);
    }

    public final boolean m7458g() {
        int i6 = this.f12400k;
        return i6 >= 2000 && i6 >= this.f12399j.size();
    }

    public final void m7459i() throws IOException {
        m7452c(this.f12392c);
        Iterator it = this.f12399j.values().iterator();
        while (it.hasNext()) {
            C3698b c3698b = (C3698b) it.next();
            C2368c c2368c = c3698b.f12388f;
            int i6 = this.f12396g;
            int i10 = 0;
            if (c2368c == null) {
                while (i10 < i6) {
                    this.f12397h += c3698b.f12384b[i10];
                    i10++;
                }
            } else {
                c3698b.f12388f = null;
                while (i10 < i6) {
                    m7452c(c3698b.f12385c[i10]);
                    m7452c(c3698b.f12386d[i10]);
                    i10++;
                }
                it.remove();
            }
        }
    }

    public final void m7460j() {
        File file = this.f12391b;
        C3701e c3701e = new C3701e(new FileInputStream(file), AbstractC3702f.f12410a);
        try {
            String strM7464a = c3701e.m7464a();
            String strM7464a2 = c3701e.m7464a();
            String strM7464a3 = c3701e.m7464a();
            String strM7464a4 = c3701e.m7464a();
            String strM7464a5 = c3701e.m7464a();
            if (!"libcore.io.DiskLruCache".equals(strM7464a) || !IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(strM7464a2) || !Integer.toString(this.f12394e).equals(strM7464a3) || !Integer.toString(this.f12396g).equals(strM7464a4) || !"".equals(strM7464a5)) {
                throw new IOException("unexpected journal header: [" + strM7464a + ", " + strM7464a2 + ", " + strM7464a4 + ", " + strM7464a5 + "]");
            }
            int i6 = 0;
            while (true) {
                try {
                    m7461k(c3701e.m7464a());
                    i6++;
                } catch (EOFException unused) {
                    this.f12400k = i6 - this.f12399j.size();
                    if (c3701e.f12409e == -1) {
                        m7462l();
                    } else {
                        this.f12398i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), AbstractC3702f.f12410a));
                    }
                    try {
                        c3701e.close();
                        return;
                    } catch (RuntimeException e5) {
                        throw e5;
                    } catch (Exception unused2) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            try {
                c3701e.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    public final void m7461k(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i6 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i6);
        LinkedHashMap linkedHashMap = this.f12399j;
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i6);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                linkedHashMap.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i6, iIndexOf2);
        }
        C3698b c3698b = (C3698b) linkedHashMap.get(strSubstring);
        if (c3698b == null) {
            c3698b = new C3698b(this, strSubstring);
            linkedHashMap.put(strSubstring, c3698b);
        }
        if (iIndexOf2 == -1 || iIndexOf != 5 || !str.startsWith("CLEAN")) {
            if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
                c3698b.f12388f = new C2368c(this, c3698b);
                return;
            } else {
                if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
                    throw new IOException("unexpected journal line: ".concat(str));
                }
                return;
            }
        }
        String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
        c3698b.f12387e = true;
        c3698b.f12388f = null;
        if (strArrSplit.length != c3698b.f12389g.f12396g) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArrSplit));
        }
        for (int i10 = 0; i10 < strArrSplit.length; i10++) {
            try {
                c3698b.f12384b[i10] = Long.parseLong(strArrSplit[i10]);
            } catch (NumberFormatException unused) {
                throw new IOException("unexpected journal line: " + Arrays.toString(strArrSplit));
            }
        }
    }

    public final synchronized void m7462l() {
        try {
            BufferedWriter bufferedWriter = this.f12398i;
            if (bufferedWriter != null) {
                m7451b(bufferedWriter);
            }
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f12392c), AbstractC3702f.f12410a));
            try {
                bufferedWriter2.write("libcore.io.DiskLruCache");
                bufferedWriter2.write("\n");
                bufferedWriter2.write(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
                bufferedWriter2.write("\n");
                bufferedWriter2.write(Integer.toString(this.f12394e));
                bufferedWriter2.write("\n");
                bufferedWriter2.write(Integer.toString(this.f12396g));
                bufferedWriter2.write("\n");
                bufferedWriter2.write("\n");
                for (C3698b c3698b : this.f12399j.values()) {
                    if (c3698b.f12388f != null) {
                        bufferedWriter2.write("DIRTY " + c3698b.f12383a + '\n');
                    } else {
                        bufferedWriter2.write("CLEAN " + c3698b.f12383a + c3698b.m7449a() + '\n');
                    }
                }
                m7451b(bufferedWriter2);
                if (this.f12391b.exists()) {
                    m7455m(this.f12391b, this.f12393d, true);
                }
                m7455m(this.f12392c, this.f12391b, false);
                this.f12393d.delete();
                this.f12398i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f12391b, true), AbstractC3702f.f12410a));
            } catch (Throwable th) {
                m7451b(bufferedWriter2);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void m7463n() {
        while (this.f12397h > this.f12395f) {
            String str = (String) ((Map.Entry) this.f12399j.entrySet().iterator().next()).getKey();
            synchronized (this) {
                try {
                    if (this.f12398i == null) {
                        throw new IllegalStateException("cache is closed");
                    }
                    C3698b c3698b = (C3698b) this.f12399j.get(str);
                    if (c3698b != null && c3698b.f12388f == null) {
                        for (int i6 = 0; i6 < this.f12396g; i6++) {
                            File file = c3698b.f12385c[i6];
                            if (file.exists() && !file.delete()) {
                                throw new IOException("failed to delete " + file);
                            }
                            long j10 = this.f12397h;
                            long[] jArr = c3698b.f12384b;
                            this.f12397h = j10 - jArr[i6];
                            jArr[i6] = 0;
                        }
                        this.f12400k++;
                        this.f12398i.append((CharSequence) "REMOVE");
                        this.f12398i.append(' ');
                        this.f12398i.append((CharSequence) str);
                        this.f12398i.append('\n');
                        this.f12399j.remove(str);
                        if (m7458g()) {
                            this.f12402m.submit(this.f12403n);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}

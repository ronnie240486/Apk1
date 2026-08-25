package p184r1;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import p000a.AbstractC0004e;
import p055ea.AbstractC2460q;
import p123l5.AbstractC2973a;

public final class C3580d implements Closeable {

    public final File f12049a;

    public final long f12050b;

    public final File f12051c;

    public final RandomAccessFile f12052d;

    public final FileChannel f12053e;

    public final FileLock f12054f;

    public C3580d(File file, File file2) throws Throwable {
        Log.i("MultiDex", "MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + ")");
        this.f12049a = file;
        this.f12051c = file2;
        this.f12050b = m7201c(file);
        File file3 = new File(file2, "MultiDex.lock");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.f12052d = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.f12053e = channel;
            try {
                Log.i("MultiDex", "Blocking on lock " + file3.getPath());
                this.f12054f = channel.lock();
                Log.i("MultiDex", file3.getPath() + " locked");
            } catch (IOException e5) {
                e = e5;
                m7199a(this.f12053e);
                throw e;
            } catch (Error e10) {
                e = e10;
                m7199a(this.f12053e);
                throw e;
            } catch (RuntimeException e11) {
                e = e11;
                m7199a(this.f12053e);
                throw e;
            }
        } catch (IOException e12) {
            e = e12;
            m7199a(this.f12052d);
            throw e;
        } catch (Error e13) {
            e = e13;
            m7199a(this.f12052d);
            throw e;
        } catch (RuntimeException e14) {
            e = e14;
            m7199a(this.f12052d);
            throw e;
        }
    }

    public static void m7199a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e5) {
            Log.w("MultiDex", "Failed to close resource", e5);
        }
    }

    public static void m7200b(ZipFile zipFile, ZipEntry zipEntry, C3579c c3579c, String str) throws IOException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File fileCreateTempFile = File.createTempFile(AbstractC2460q.m5501o("tmp-", str), ".zip", c3579c.getParentFile());
        Log.i("MultiDex", "Extracting " + fileCreateTempFile.getPath());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(fileCreateTempFile)));
            try {
                ZipEntry zipEntry2 = new ZipEntry("classes.dex");
                zipEntry2.setTime(zipEntry.getTime());
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[16384];
                for (int i6 = inputStream.read(bArr); i6 != -1; i6 = inputStream.read(bArr)) {
                    zipOutputStream.write(bArr, 0, i6);
                }
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                if (!fileCreateTempFile.setReadOnly()) {
                    throw new IOException("Failed to mark readonly \"" + fileCreateTempFile.getAbsolutePath() + "\" (tmp of \"" + c3579c.getAbsolutePath() + "\")");
                }
                Log.i("MultiDex", "Renaming to " + c3579c.getPath());
                if (fileCreateTempFile.renameTo(c3579c)) {
                    m7199a(inputStream);
                    fileCreateTempFile.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + fileCreateTempFile.getAbsolutePath() + "\" to \"" + c3579c.getAbsolutePath() + "\"");
            } catch (Throwable th) {
                zipOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            m7199a(inputStream);
            fileCreateTempFile.delete();
            throw th2;
        }
    }

    public static long m7201c(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            C3581e c3581eM6021t = AbstractC2973a.m6021t(randomAccessFile);
            CRC32 crc32 = new CRC32();
            long j10 = c3581eM6021t.f12056b;
            randomAccessFile.seek(c3581eM6021t.f12055a);
            byte[] bArr = new byte[16384];
            int i6 = randomAccessFile.read(bArr, 0, (int) Math.min(16384L, j10));
            while (i6 != -1) {
                crc32.update(bArr, 0, i6);
                j10 -= (long) i6;
                if (j10 == 0) {
                    break;
                }
                i6 = randomAccessFile.read(bArr, 0, (int) Math.min(16384L, j10));
            }
            long value = crc32.getValue();
            randomAccessFile.close();
            return value == -1 ? value - 1 : value;
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    public static void m7202g(Application application, long j10, long j11, ArrayList arrayList) {
        SharedPreferences.Editor editorEdit = application.getSharedPreferences("multidex.version", 4).edit();
        editorEdit.putLong("timestamp", j10);
        editorEdit.putLong("crc", j11);
        editorEdit.putInt("dex.number", arrayList.size() + 1);
        Iterator it = arrayList.iterator();
        int i6 = 2;
        while (it.hasNext()) {
            C3579c c3579c = (C3579c) it.next();
            editorEdit.putLong(AbstractC0004e.m20n(i6, "dex.crc."), c3579c.f12048a);
            editorEdit.putLong("dex.time." + i6, c3579c.lastModified());
            i6++;
        }
        editorEdit.commit();
    }

    @Override
    public final void close() throws IOException {
        this.f12054f.release();
        this.f12053e.close();
        this.f12052d.close();
    }

    public final ArrayList m7203d(Application application, boolean z7) throws Throwable {
        ArrayList arrayListM7205f;
        long jLastModified;
        ArrayList arrayListM7204e;
        StringBuilder sb = new StringBuilder("MultiDexExtractor.load(");
        File file = this.f12049a;
        sb.append(file.getPath());
        sb.append(", ");
        sb.append(z7);
        sb.append(", )");
        Log.i("MultiDex", sb.toString());
        if (!this.f12054f.isValid()) {
            throw new IllegalStateException("MultiDexExtractor was closed");
        }
        if (z7) {
            if (z7) {
                Log.i("MultiDex", "Forced extraction must be performed.");
            } else {
                Log.i("MultiDex", "Detected that extraction must be performed.");
            }
            arrayListM7205f = m7205f();
            jLastModified = file.lastModified();
            if (jLastModified == -1) {
                jLastModified--;
            }
            m7202g(application, jLastModified, this.f12050b, arrayListM7205f);
            arrayListM7204e = arrayListM7205f;
        } else {
            SharedPreferences sharedPreferences = application.getSharedPreferences("multidex.version", 4);
            long j10 = sharedPreferences.getLong("timestamp", -1L);
            long jLastModified2 = file.lastModified();
            if (jLastModified2 == -1) {
                jLastModified2--;
            }
            if (j10 == jLastModified2 && sharedPreferences.getLong("crc", -1L) == this.f12050b) {
                try {
                    arrayListM7204e = m7204e(application);
                } catch (IOException e5) {
                    Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e5);
                    arrayListM7205f = m7205f();
                    long jLastModified3 = file.lastModified();
                    if (jLastModified3 == -1) {
                        jLastModified3--;
                    }
                    m7202g(application, jLastModified3, this.f12050b, arrayListM7205f);
                    arrayListM7204e = arrayListM7205f;
                }
            } else {
                if (z7) {
                    Log.i("MultiDex", "Forced extraction must be performed.");
                } else {
                    Log.i("MultiDex", "Detected that extraction must be performed.");
                }
                arrayListM7205f = m7205f();
                jLastModified = file.lastModified();
                if (jLastModified == -1) {
                    jLastModified--;
                }
                m7202g(application, jLastModified, this.f12050b, arrayListM7205f);
            }
            arrayListM7204e = arrayListM7205f;
        }
        Log.i("MultiDex", "load found " + arrayListM7204e.size() + " secondary dex files");
        return arrayListM7204e;
    }

    public final ArrayList m7204e(Application application) throws IOException {
        Log.i("MultiDex", "loading existing secondary dex files");
        String str = this.f12049a.getName() + ".classes";
        SharedPreferences sharedPreferences = application.getSharedPreferences("multidex.version", 4);
        int i6 = sharedPreferences.getInt("dex.number", 1);
        ArrayList arrayList = new ArrayList(i6 - 1);
        for (int i10 = 2; i10 <= i6; i10++) {
            C3579c c3579c = new C3579c(this.f12051c, str + i10 + ".zip");
            if (!c3579c.isFile()) {
                throw new IOException("Missing extracted secondary dex file '" + c3579c.getPath() + "'");
            }
            c3579c.f12048a = m7201c(c3579c);
            long j10 = sharedPreferences.getLong("dex.crc." + i10, -1L);
            long j11 = sharedPreferences.getLong("dex.time." + i10, -1L);
            long jLastModified = c3579c.lastModified();
            if (j11 != jLastModified || j10 != c3579c.f12048a) {
                throw new IOException("Invalid extracted dex: " + c3579c + " (key \"\"), expected modification time: " + j11 + ", modification time: " + jLastModified + ", expected crc: " + j10 + ", file crc: " + c3579c.f12048a);
            }
            arrayList.add(c3579c);
        }
        return arrayList;
    }

    public final ArrayList m7205f() throws Throwable {
        Throwable th;
        boolean z7;
        StringBuilder sb = new StringBuilder();
        File file = this.f12049a;
        sb.append(file.getName());
        sb.append(".classes");
        String string = sb.toString();
        C3578b c3578b = new C3578b();
        File file2 = this.f12051c;
        File[] fileArrListFiles = file2.listFiles(c3578b);
        String str = "MultiDex";
        if (fileArrListFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + file2.getPath() + ").");
        } else {
            for (File file3 : fileArrListFiles) {
                Log.i("MultiDex", "Trying to delete old file " + file3.getPath() + " of size " + file3.length());
                if (file3.delete()) {
                    Log.i("MultiDex", "Deleted old file " + file3.getPath());
                } else {
                    Log.w("MultiDex", "Failed to delete old file " + file3.getPath());
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        try {
            ZipEntry entry = zipFile.getEntry("classes2.dex");
            int i6 = 2;
            while (entry != null) {
                C3579c c3579c = new C3579c(file2, string + i6 + ".zip");
                arrayList.add(c3579c);
                Log.i(str, "Extraction is needed for file " + c3579c);
                int i10 = 0;
                boolean z10 = false;
                while (i10 < 3 && !z10) {
                    int i11 = i10 + 1;
                    m7200b(zipFile, entry, c3579c, string);
                    String str2 = str;
                    try {
                        c3579c.f12048a = m7201c(c3579c);
                        z7 = true;
                        str = str2;
                    } catch (IOException e5) {
                        try {
                            str = str2;
                            Log.w(str, "Failed to read crc from " + c3579c.getAbsolutePath(), e5);
                            z7 = false;
                        } catch (Throwable th2) {
                            th = th2;
                            str = str2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str = str2;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Extraction ");
                    sb2.append(z7 ? "succeeded" : "failed");
                    sb2.append(" '");
                    sb2.append(c3579c.getAbsolutePath());
                    sb2.append("': length ");
                    ZipEntry zipEntry = entry;
                    String str3 = string;
                    sb2.append(c3579c.length());
                    sb2.append(" - crc: ");
                    sb2.append(c3579c.f12048a);
                    Log.i(str, sb2.toString());
                    if (!z7) {
                        c3579c.delete();
                        if (c3579c.exists()) {
                            Log.w(str, "Failed to delete corrupted secondary dex '" + c3579c.getPath() + "'");
                        }
                    }
                    string = str3;
                    entry = zipEntry;
                    z10 = z7;
                    i10 = i11;
                }
                String str4 = string;
                if (!z10) {
                    throw new IOException("Could not create zip file " + c3579c.getAbsolutePath() + " for secondary dex (" + i6 + ")");
                }
                i6++;
                entry = zipFile.getEntry("classes" + i6 + ".dex");
                string = str4;
                th = th;
                try {
                    zipFile.close();
                    throw th;
                } catch (IOException e10) {
                    Log.w(str, "Failed to close resource", e10);
                    throw th;
                }
            }
            try {
                zipFile.close();
            } catch (IOException e11) {
                Log.w(str, "Failed to close resource", e11);
            }
            return arrayList;
        } catch (Throwable th4) {
            th = th4;
        }
    }
}

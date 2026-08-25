package p207t1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import p000a.AbstractC0004e;
import p055ea.AbstractC2460q;
import p171q.C3388b;

public abstract class AbstractC3792d {

    public static final C3388b f12774a = new C3388b(3);

    public static final byte[] f12775b = {112, 114, 111, 0};

    public static final byte[] f12776c = {112, 114, 109, 0};

    public static final byte[] f12777d = {48, 49, 53, 0};

    public static final byte[] f12778e = {48, 49, 48, 0};

    public static final byte[] f12779f = {48, 48, 57, 0};

    public static final byte[] f12780g = {48, 48, 53, 0};

    public static final byte[] f12781h = {48, 48, 49, 0};

    public static final byte[] f12782i = {48, 48, 49, 0};

    public static final byte[] f12783j = {48, 48, 50, 0};

    public static byte[] m7542a(byte[] bArr) {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            try {
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                try {
                    deflaterOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            deflater.end();
            throw th3;
        }
    }

    public static byte[] m7543b(C3790b[] c3790bArr, byte[] bArr) throws IOException {
        int length = 0;
        for (C3790b c3790b : c3790bArr) {
            length += ((((c3790b.f12771g * 2) + 7) & (-8)) / 8) + (c3790b.f12769e * 2) + m7545d(bArr, c3790b.f12765a, c3790b.f12766b).getBytes(StandardCharsets.UTF_8).length + 16 + c3790b.f12770f;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        if (Arrays.equals(bArr, f12779f)) {
            for (C3790b c3790b2 : c3790bArr) {
                m7557p(byteArrayOutputStream, c3790b2, m7545d(bArr, c3790b2.f12765a, c3790b2.f12766b));
                m7559r(byteArrayOutputStream, c3790b2);
                int[] iArr = c3790b2.f12772h;
                int length2 = iArr.length;
                int i6 = 0;
                int i10 = 0;
                while (i6 < length2) {
                    int i11 = iArr[i6];
                    m7562u(byteArrayOutputStream, i11 - i10);
                    i6++;
                    i10 = i11;
                }
                m7558q(byteArrayOutputStream, c3790b2);
            }
        } else {
            for (C3790b c3790b3 : c3790bArr) {
                m7557p(byteArrayOutputStream, c3790b3, m7545d(bArr, c3790b3.f12765a, c3790b3.f12766b));
            }
            for (C3790b c3790b4 : c3790bArr) {
                m7559r(byteArrayOutputStream, c3790b4);
                int[] iArr2 = c3790b4.f12772h;
                int length3 = iArr2.length;
                int i12 = 0;
                int i13 = 0;
                while (i12 < length3) {
                    int i14 = iArr2[i12];
                    m7562u(byteArrayOutputStream, i14 - i13);
                    i12++;
                    i13 = i14;
                }
                m7558q(byteArrayOutputStream, c3790b4);
            }
        }
        if (byteArrayOutputStream.size() == length) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalStateException("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + length);
    }

    public static boolean m7544c(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z7 = true;
        for (File file2 : fileArrListFiles) {
            z7 = m7544c(file2) && z7;
        }
        return z7;
    }

    public static String m7545d(byte[] bArr, String str, String str2) {
        byte[] bArr2 = f12781h;
        boolean zEquals = Arrays.equals(bArr, bArr2);
        byte[] bArr3 = f12780g;
        Object obj = (zEquals || Arrays.equals(bArr, bArr3)) ? ":" : "!";
        if (str.length() <= 0) {
            if ("!".equals(obj)) {
                return str2.replace(":", "!");
            }
            return ":".equals(obj) ? str2.replace("!", ":") : str2;
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(":")) {
            if ("!".equals(obj)) {
                return str2.replace(":", "!");
            }
            return ":".equals(obj) ? str2.replace("!", ":") : str2;
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return AbstractC0004e.m26t(AbstractC2460q.m5498l(str), (Arrays.equals(bArr, bArr2) || Arrays.equals(bArr, bArr3)) ? ":" : "!", str2);
    }

    public static void m7546e(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused) {
        }
    }

    public static byte[] m7547f(InputStream inputStream, int i6) throws IOException {
        byte[] bArr = new byte[i6];
        int i10 = 0;
        while (i10 < i6) {
            int i11 = inputStream.read(bArr, i10, i6 - i10);
            if (i11 < 0) {
                throw new IllegalStateException(AbstractC0004e.m20n(i6, "Not enough bytes to read: "));
            }
            i10 += i11;
        }
        return bArr;
    }

    public static int[] m7548g(ByteArrayInputStream byteArrayInputStream, int i6) {
        int[] iArr = new int[i6];
        int iM7554m = 0;
        for (int i10 = 0; i10 < i6; i10++) {
            iM7554m += (int) m7554m(byteArrayInputStream, 2);
            iArr[i10] = iM7554m;
        }
        return iArr;
    }

    public static byte[] m7549h(FileInputStream fileInputStream, int i6, int i10) {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i10];
            byte[] bArr2 = new byte[2048];
            int i11 = 0;
            int iInflate = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i11 < i6) {
                int i12 = fileInputStream.read(bArr2);
                if (i12 < 0) {
                    throw new IllegalStateException("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + i6 + " bytes");
                }
                inflater.setInput(bArr2, 0, i12);
                try {
                    iInflate += inflater.inflate(bArr, iInflate, i10 - iInflate);
                    i11 += i12;
                } catch (DataFormatException e5) {
                    throw new IllegalStateException(e5.getMessage());
                }
            }
            if (i11 == i6) {
                if (!inflater.finished()) {
                    throw new IllegalStateException("Inflater did not finish");
                }
                inflater.end();
                return bArr;
            }
            throw new IllegalStateException("Didn't read enough bytes during decompression. expected=" + i6 + " actual=" + i11);
        } catch (Throwable th) {
            inflater.end();
            throw th;
        }
    }

    public static C3790b[] m7550i(FileInputStream fileInputStream, byte[] bArr, byte[] bArr2, C3790b[] c3790bArr) throws IOException {
        byte[] bArr3 = f12782i;
        if (!Arrays.equals(bArr, bArr3)) {
            if (!Arrays.equals(bArr, f12783j)) {
                throw new IllegalStateException("Unsupported meta version");
            }
            int iM7554m = (int) m7554m(fileInputStream, 2);
            byte[] bArrM7549h = m7549h(fileInputStream, (int) m7554m(fileInputStream, 4), (int) m7554m(fileInputStream, 4));
            if (fileInputStream.read() > 0) {
                throw new IllegalStateException("Content found after the end of file");
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrM7549h);
            try {
                C3790b[] c3790bArrM7552k = m7552k(byteArrayInputStream, bArr2, iM7554m, c3790bArr);
                byteArrayInputStream.close();
                return c3790bArrM7552k;
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (Arrays.equals(f12777d, bArr2)) {
            throw new IllegalStateException("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        }
        if (!Arrays.equals(bArr, bArr3)) {
            throw new IllegalStateException("Unsupported meta version");
        }
        int iM7554m2 = (int) m7554m(fileInputStream, 1);
        byte[] bArrM7549h2 = m7549h(fileInputStream, (int) m7554m(fileInputStream, 4), (int) m7554m(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            throw new IllegalStateException("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArrM7549h2);
        try {
            C3790b[] c3790bArrM7551j = m7551j(byteArrayInputStream2, iM7554m2, c3790bArr);
            byteArrayInputStream2.close();
            return c3790bArrM7551j;
        } catch (Throwable th3) {
            try {
                byteArrayInputStream2.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public static C3790b[] m7551j(ByteArrayInputStream byteArrayInputStream, int i6, C3790b[] c3790bArr) {
        if (byteArrayInputStream.available() == 0) {
            return new C3790b[0];
        }
        if (i6 != c3790bArr.length) {
            throw new IllegalStateException("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i6];
        int[] iArr = new int[i6];
        for (int i10 = 0; i10 < i6; i10++) {
            int iM7554m = (int) m7554m(byteArrayInputStream, 2);
            iArr[i10] = (int) m7554m(byteArrayInputStream, 2);
            strArr[i10] = new String(m7547f(byteArrayInputStream, iM7554m), StandardCharsets.UTF_8);
        }
        for (int i11 = 0; i11 < i6; i11++) {
            C3790b c3790b = c3790bArr[i11];
            if (!c3790b.f12766b.equals(strArr[i11])) {
                throw new IllegalStateException("Order of dexfiles in metadata did not match baseline");
            }
            int i12 = iArr[i11];
            c3790b.f12769e = i12;
            c3790b.f12772h = m7548g(byteArrayInputStream, i12);
        }
        return c3790bArr;
    }

    public static C3790b[] m7552k(ByteArrayInputStream byteArrayInputStream, byte[] bArr, int i6, C3790b[] c3790bArr) throws IOException {
        if (byteArrayInputStream.available() == 0) {
            return new C3790b[0];
        }
        if (i6 != c3790bArr.length) {
            throw new IllegalStateException("Mismatched number of dex files found in metadata");
        }
        for (int i10 = 0; i10 < i6; i10++) {
            m7554m(byteArrayInputStream, 2);
            String str = new String(m7547f(byteArrayInputStream, (int) m7554m(byteArrayInputStream, 2)), StandardCharsets.UTF_8);
            long jM7554m = m7554m(byteArrayInputStream, 4);
            int iM7554m = (int) m7554m(byteArrayInputStream, 2);
            C3790b c3790b = null;
            if (c3790bArr.length > 0) {
                int iIndexOf = str.indexOf("!");
                if (iIndexOf < 0) {
                    iIndexOf = str.indexOf(":");
                }
                String strSubstring = iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
                for (int i11 = 0; i11 < c3790bArr.length; i11++) {
                    if (c3790bArr[i11].f12766b.equals(strSubstring)) {
                        c3790b = c3790bArr[i11];
                        break;
                    }
                }
            }
            if (c3790b == null) {
                throw new IllegalStateException("Missing profile key: ".concat(str));
            }
            c3790b.f12768d = jM7554m;
            int[] iArrM7548g = m7548g(byteArrayInputStream, iM7554m);
            if (Arrays.equals(bArr, f12781h)) {
                c3790b.f12769e = iM7554m;
                c3790b.f12772h = iArrM7548g;
            }
        }
        return c3790bArr;
    }

    public static C3790b[] m7553l(FileInputStream fileInputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, f12778e)) {
            throw new IllegalStateException("Unsupported version");
        }
        int iM7554m = (int) m7554m(fileInputStream, 1);
        byte[] bArrM7549h = m7549h(fileInputStream, (int) m7554m(fileInputStream, 4), (int) m7554m(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            throw new IllegalStateException("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrM7549h);
        try {
            C3790b[] c3790bArrM7555n = m7555n(byteArrayInputStream, str, iM7554m);
            byteArrayInputStream.close();
            return c3790bArrM7555n;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static long m7554m(InputStream inputStream, int i6) throws IOException {
        byte[] bArrM7547f = m7547f(inputStream, i6);
        long j10 = 0;
        for (int i10 = 0; i10 < i6; i10++) {
            j10 += ((long) (bArrM7547f[i10] & 255)) << (i10 * 8);
        }
        return j10;
    }

    public static C3790b[] m7555n(ByteArrayInputStream byteArrayInputStream, String str, int i6) throws IOException {
        TreeMap treeMap;
        if (byteArrayInputStream.available() == 0) {
            return new C3790b[0];
        }
        C3790b[] c3790bArr = new C3790b[i6];
        for (int i10 = 0; i10 < i6; i10++) {
            int iM7554m = (int) m7554m(byteArrayInputStream, 2);
            int iM7554m2 = (int) m7554m(byteArrayInputStream, 2);
            c3790bArr[i10] = new C3790b(str, new String(m7547f(byteArrayInputStream, iM7554m), StandardCharsets.UTF_8), m7554m(byteArrayInputStream, 4), iM7554m2, (int) m7554m(byteArrayInputStream, 4), (int) m7554m(byteArrayInputStream, 4), new int[iM7554m2], new TreeMap());
        }
        for (int i11 = 0; i11 < i6; i11++) {
            C3790b c3790b = c3790bArr[i11];
            int iAvailable = byteArrayInputStream.available() - c3790b.f12770f;
            int iM7554m3 = 0;
            while (true) {
                int iAvailable2 = byteArrayInputStream.available();
                treeMap = c3790b.f12773i;
                if (iAvailable2 <= iAvailable) {
                    break;
                }
                iM7554m3 += (int) m7554m(byteArrayInputStream, 2);
                treeMap.put(Integer.valueOf(iM7554m3), 1);
                for (int iM7554m4 = (int) m7554m(byteArrayInputStream, 2); iM7554m4 > 0; iM7554m4--) {
                    m7554m(byteArrayInputStream, 2);
                    int iM7554m5 = (int) m7554m(byteArrayInputStream, 1);
                    if (iM7554m5 != 6 && iM7554m5 != 7) {
                        while (iM7554m5 > 0) {
                            m7554m(byteArrayInputStream, 1);
                            for (int iM7554m6 = (int) m7554m(byteArrayInputStream, 1); iM7554m6 > 0; iM7554m6--) {
                                m7554m(byteArrayInputStream, 2);
                            }
                            iM7554m5--;
                        }
                    }
                }
            }
            if (byteArrayInputStream.available() != iAvailable) {
                throw new IllegalStateException("Read too much data during profile line parse");
            }
            c3790b.f12772h = m7548g(byteArrayInputStream, c3790b.f12769e);
            int i12 = c3790b.f12771g;
            BitSet bitSetValueOf = BitSet.valueOf(m7547f(byteArrayInputStream, (((i12 * 2) + 7) & (-8)) / 8));
            for (int i13 = 0; i13 < i12; i13++) {
                int i14 = bitSetValueOf.get(i13) ? 2 : 0;
                if (bitSetValueOf.get(i13 + i12)) {
                    i14 |= 4;
                }
                if (i14 != 0) {
                    Integer num = (Integer) treeMap.get(Integer.valueOf(i13));
                    if (num == null) {
                        num = 0;
                    }
                    treeMap.put(Integer.valueOf(i13), Integer.valueOf(i14 | num.intValue()));
                }
            }
        }
        return c3790bArr;
    }

    public static boolean m7556o(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, C3790b[] c3790bArr) throws IOException {
        long j10;
        ArrayList arrayList;
        int length;
        byte[] bArr2 = f12777d;
        int i6 = 0;
        if (!Arrays.equals(bArr, bArr2)) {
            byte[] bArr3 = f12778e;
            if (Arrays.equals(bArr, bArr3)) {
                byte[] bArrM7543b = m7543b(c3790bArr, bArr3);
                m7561t(byteArrayOutputStream, c3790bArr.length, 1);
                m7561t(byteArrayOutputStream, bArrM7543b.length, 4);
                byte[] bArrM7542a = m7542a(bArrM7543b);
                m7561t(byteArrayOutputStream, bArrM7542a.length, 4);
                byteArrayOutputStream.write(bArrM7542a);
                return true;
            }
            byte[] bArr4 = f12780g;
            if (Arrays.equals(bArr, bArr4)) {
                m7561t(byteArrayOutputStream, c3790bArr.length, 1);
                for (C3790b c3790b : c3790bArr) {
                    int size = c3790b.f12773i.size() * 4;
                    String strM7545d = m7545d(bArr4, c3790b.f12765a, c3790b.f12766b);
                    Charset charset = StandardCharsets.UTF_8;
                    m7562u(byteArrayOutputStream, strM7545d.getBytes(charset).length);
                    m7562u(byteArrayOutputStream, c3790b.f12772h.length);
                    m7561t(byteArrayOutputStream, size, 4);
                    m7561t(byteArrayOutputStream, c3790b.f12767c, 4);
                    byteArrayOutputStream.write(strM7545d.getBytes(charset));
                    Iterator it = c3790b.f12773i.keySet().iterator();
                    while (it.hasNext()) {
                        m7562u(byteArrayOutputStream, ((Integer) it.next()).intValue());
                        m7562u(byteArrayOutputStream, 0);
                    }
                    for (int i10 : c3790b.f12772h) {
                        m7562u(byteArrayOutputStream, i10);
                    }
                }
                return true;
            }
            byte[] bArr5 = f12779f;
            if (Arrays.equals(bArr, bArr5)) {
                byte[] bArrM7543b2 = m7543b(c3790bArr, bArr5);
                m7561t(byteArrayOutputStream, c3790bArr.length, 1);
                m7561t(byteArrayOutputStream, bArrM7543b2.length, 4);
                byte[] bArrM7542a2 = m7542a(bArrM7543b2);
                m7561t(byteArrayOutputStream, bArrM7542a2.length, 4);
                byteArrayOutputStream.write(bArrM7542a2);
                return true;
            }
            byte[] bArr6 = f12781h;
            if (!Arrays.equals(bArr, bArr6)) {
                return false;
            }
            m7562u(byteArrayOutputStream, c3790bArr.length);
            for (C3790b c3790b2 : c3790bArr) {
                String strM7545d2 = m7545d(bArr6, c3790b2.f12765a, c3790b2.f12766b);
                Charset charset2 = StandardCharsets.UTF_8;
                m7562u(byteArrayOutputStream, strM7545d2.getBytes(charset2).length);
                TreeMap treeMap = c3790b2.f12773i;
                m7562u(byteArrayOutputStream, treeMap.size());
                m7562u(byteArrayOutputStream, c3790b2.f12772h.length);
                m7561t(byteArrayOutputStream, c3790b2.f12767c, 4);
                byteArrayOutputStream.write(strM7545d2.getBytes(charset2));
                Iterator it2 = treeMap.keySet().iterator();
                while (it2.hasNext()) {
                    m7562u(byteArrayOutputStream, ((Integer) it2.next()).intValue());
                }
                for (int i11 : c3790b2.f12772h) {
                    m7562u(byteArrayOutputStream, i11);
                }
            }
            return true;
        }
        ArrayList arrayList2 = new ArrayList(3);
        ArrayList arrayList3 = new ArrayList(3);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        try {
            m7562u(byteArrayOutputStream2, c3790bArr.length);
            int i12 = 2;
            int i13 = 2;
            for (C3790b c3790b3 : c3790bArr) {
                m7561t(byteArrayOutputStream2, c3790b3.f12767c, 4);
                m7561t(byteArrayOutputStream2, c3790b3.f12768d, 4);
                m7561t(byteArrayOutputStream2, c3790b3.f12771g, 4);
                String strM7545d3 = m7545d(bArr2, c3790b3.f12765a, c3790b3.f12766b);
                Charset charset3 = StandardCharsets.UTF_8;
                int length2 = strM7545d3.getBytes(charset3).length;
                m7562u(byteArrayOutputStream2, length2);
                i13 = i13 + 14 + length2;
                byteArrayOutputStream2.write(strM7545d3.getBytes(charset3));
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            if (i13 != byteArray.length) {
                throw new IllegalStateException("Expected size " + i13 + ", does not match actual size " + byteArray.length);
            }
            C3799k c3799k = new C3799k(byteArray, 1, false);
            byteArrayOutputStream2.close();
            arrayList2.add(c3799k);
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i14 = 0;
            int i15 = 0;
            while (i14 < c3790bArr.length) {
                try {
                    C3790b c3790b4 = c3790bArr[i14];
                    m7562u(byteArrayOutputStream3, i14);
                    m7562u(byteArrayOutputStream3, c3790b4.f12769e);
                    i15 = i15 + 4 + (c3790b4.f12769e * 2);
                    int[] iArr = c3790b4.f12772h;
                    int length3 = iArr.length;
                    int i16 = 0;
                    while (i6 < length3) {
                        int i17 = iArr[i6];
                        m7562u(byteArrayOutputStream3, i17 - i16);
                        i6++;
                        i16 = i17;
                    }
                    i14++;
                    i6 = 0;
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream3.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            }
            byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
            if (i15 != byteArray2.length) {
                throw new IllegalStateException("Expected size " + i15 + ", does not match actual size " + byteArray2.length);
            }
            C3799k c3799k2 = new C3799k(byteArray2, 3, true);
            byteArrayOutputStream3.close();
            arrayList2.add(c3799k2);
            ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
            int i18 = 0;
            int i19 = 0;
            while (i18 < c3790bArr.length) {
                try {
                    C3790b c3790b5 = c3790bArr[i18];
                    Iterator it3 = c3790b5.f12773i.entrySet().iterator();
                    int iIntValue = 0;
                    while (it3.hasNext()) {
                        iIntValue |= ((Integer) ((Map.Entry) it3.next()).getValue()).intValue();
                    }
                    ByteArrayOutputStream byteArrayOutputStream5 = new ByteArrayOutputStream();
                    try {
                        m7558q(byteArrayOutputStream5, c3790b5);
                        byte[] byteArray3 = byteArrayOutputStream5.toByteArray();
                        byteArrayOutputStream5.close();
                        ByteArrayOutputStream byteArrayOutputStream6 = new ByteArrayOutputStream();
                        try {
                            m7559r(byteArrayOutputStream6, c3790b5);
                            byte[] byteArray4 = byteArrayOutputStream6.toByteArray();
                            byteArrayOutputStream6.close();
                            m7562u(byteArrayOutputStream4, i18);
                            int length4 = byteArray3.length + i12 + byteArray4.length;
                            int i20 = i19 + 6;
                            ArrayList arrayList4 = arrayList3;
                            m7561t(byteArrayOutputStream4, length4, 4);
                            m7562u(byteArrayOutputStream4, iIntValue);
                            byteArrayOutputStream4.write(byteArray3);
                            byteArrayOutputStream4.write(byteArray4);
                            i19 = i20 + length4;
                            i18++;
                            arrayList3 = arrayList4;
                            i12 = 2;
                        } catch (Throwable th3) {
                            try {
                                byteArrayOutputStream6.close();
                                throw th3;
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                                throw th3;
                            }
                        }
                    } catch (Throwable th5) {
                        try {
                            byteArrayOutputStream5.close();
                            throw th5;
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                            throw th5;
                        }
                    }
                } catch (Throwable th7) {
                    try {
                        byteArrayOutputStream4.close();
                        throw th7;
                    } catch (Throwable th8) {
                        th7.addSuppressed(th8);
                        throw th7;
                    }
                }
            }
            ArrayList arrayList5 = arrayList3;
            byte[] byteArray5 = byteArrayOutputStream4.toByteArray();
            if (i19 != byteArray5.length) {
                throw new IllegalStateException("Expected size " + i19 + ", does not match actual size " + byteArray5.length);
            }
            C3799k c3799k3 = new C3799k(byteArray5, 4, true);
            byteArrayOutputStream4.close();
            arrayList2.add(c3799k3);
            long j11 = 4;
            long size2 = j11 + j11 + 4 + ((long) (arrayList2.size() * 16));
            m7561t(byteArrayOutputStream, arrayList2.size(), 4);
            int i21 = 0;
            while (i21 < arrayList2.size()) {
                C3799k c3799k4 = (C3799k) arrayList2.get(i21);
                int i22 = c3799k4.f12792a;
                if (i22 == 1) {
                    j10 = 0;
                } else if (i22 == 2) {
                    j10 = 1;
                } else if (i22 == 3) {
                    j10 = 2;
                } else if (i22 == 4) {
                    j10 = 3;
                } else {
                    if (i22 != 5) {
                        throw null;
                    }
                    j10 = 4;
                }
                m7561t(byteArrayOutputStream, j10, 4);
                m7561t(byteArrayOutputStream, size2, 4);
                byte[] bArr7 = c3799k4.f12793b;
                if (c3799k4.f12794c) {
                    long length5 = bArr7.length;
                    byte[] bArrM7542a3 = m7542a(bArr7);
                    arrayList = arrayList5;
                    arrayList.add(bArrM7542a3);
                    m7561t(byteArrayOutputStream, bArrM7542a3.length, 4);
                    m7561t(byteArrayOutputStream, length5, 4);
                    length = bArrM7542a3.length;
                } else {
                    arrayList = arrayList5;
                    arrayList.add(bArr7);
                    m7561t(byteArrayOutputStream, bArr7.length, 4);
                    m7561t(byteArrayOutputStream, 0L, 4);
                    length = bArr7.length;
                }
                size2 += (long) length;
                i21++;
                arrayList5 = arrayList;
            }
            ArrayList arrayList6 = arrayList5;
            for (int i23 = 0; i23 < arrayList6.size(); i23++) {
                byteArrayOutputStream.write((byte[]) arrayList6.get(i23));
            }
            return true;
        } catch (Throwable th9) {
            try {
                byteArrayOutputStream2.close();
                throw th9;
            } catch (Throwable th10) {
                th9.addSuppressed(th10);
                throw th9;
            }
        }
    }

    public static void m7557p(ByteArrayOutputStream byteArrayOutputStream, C3790b c3790b, String str) throws IOException {
        Charset charset = StandardCharsets.UTF_8;
        m7562u(byteArrayOutputStream, str.getBytes(charset).length);
        m7562u(byteArrayOutputStream, c3790b.f12769e);
        m7561t(byteArrayOutputStream, c3790b.f12770f, 4);
        m7561t(byteArrayOutputStream, c3790b.f12767c, 4);
        m7561t(byteArrayOutputStream, c3790b.f12771g, 4);
        byteArrayOutputStream.write(str.getBytes(charset));
    }

    public static void m7558q(ByteArrayOutputStream byteArrayOutputStream, C3790b c3790b) throws IOException {
        byte[] bArr = new byte[(((c3790b.f12771g * 2) + 7) & (-8)) / 8];
        for (Map.Entry entry : c3790b.f12773i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            if ((iIntValue2 & 2) != 0) {
                int i6 = iIntValue / 8;
                bArr[i6] = (byte) (bArr[i6] | (1 << (iIntValue % 8)));
            }
            if ((iIntValue2 & 4) != 0) {
                int i10 = iIntValue + c3790b.f12771g;
                int i11 = i10 / 8;
                bArr[i11] = (byte) ((1 << (i10 % 8)) | bArr[i11]);
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void m7559r(ByteArrayOutputStream byteArrayOutputStream, C3790b c3790b) throws IOException {
        int i6 = 0;
        for (Map.Entry entry : c3790b.f12773i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                m7562u(byteArrayOutputStream, iIntValue - i6);
                m7562u(byteArrayOutputStream, 0);
                i6 = iIntValue;
            }
        }
    }

    public static void m7560s(Context context, Executor executor, InterfaceC3791c interfaceC3791c, boolean z7) throws Throwable {
        byte[] bArr;
        FileInputStream fileInputStreamM7540a;
        IOException iOException;
        int i6;
        C3790b[] c3790bArrM7553l;
        C3790b[] c3790bArr;
        C3789a c3789a;
        InterfaceC3791c interfaceC3791c2;
        C3790b[] c3790bArr2;
        byte[] bArr2;
        boolean z10;
        ByteArrayInputStream byteArrayInputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        byte[] bArr3;
        int i10;
        byte[] bArr4;
        ByteArrayOutputStream byteArrayOutputStream;
        int i11;
        FileInputStream fileInputStreamM7540a2;
        boolean z11;
        boolean z12;
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (!z7) {
                File file = new File(filesDir, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
                if (file.exists()) {
                    try {
                        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
                        try {
                            long j10 = dataInputStream.readLong();
                            dataInputStream.close();
                            z12 = j10 == packageInfo.lastUpdateTime;
                            if (z12) {
                                interfaceC3791c.mo6880b(2, null);
                            }
                        } catch (Throwable th2) {
                            try {
                                dataInputStream.close();
                                throw th2;
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                                throw th2;
                            }
                        }
                    } catch (IOException unused) {
                        z12 = false;
                    }
                } else {
                    z12 = false;
                }
                if (z12) {
                    Log.d("ProfileInstaller", "Skipping profile installation for " + context.getPackageName());
                    AbstractC3798j.m7570c(context, false);
                    return;
                }
            }
            Log.d("ProfileInstaller", "Installing profile for " + context.getPackageName());
            int i12 = Build.VERSION.SDK_INT;
            File file2 = new File(new File("/data/misc/profiles/cur/0", packageName), "primary.prof");
            C3789a c3789a2 = new C3789a(assets, executor, interfaceC3791c, name, file2);
            byte[] bArr5 = c3789a2.f12759c;
            if (bArr5 == null) {
                c3789a2.m7541b(3, Integer.valueOf(i12));
            } else {
                try {
                    try {
                        if (file2.exists()) {
                            if (!file2.canWrite()) {
                                c3789a2.m7541b(4, null);
                            }
                            if (z10 || !z7) {
                                z11 = false;
                            } else {
                                z11 = true;
                            }
                            AbstractC3798j.m7570c(context, z11);
                        }
                        try {
                            file2.createNewFile();
                        } catch (IOException unused2) {
                            c3789a2.m7541b(4, null);
                            z10 = false;
                        }
                        fileInputStreamM7540a = c3789a2.m7540a(assets, "dexopt/baseline.prof");
                    } catch (FileNotFoundException e5) {
                        interfaceC3791c.mo6880b(6, e5);
                        fileInputStreamM7540a = null;
                    } catch (IOException e10) {
                        interfaceC3791c.mo6880b(7, e10);
                        fileInputStreamM7540a = null;
                    }
                    if (fileInputStreamM7540a != null) {
                        try {
                            if (!Arrays.equals(bArr, m7547f(fileInputStreamM7540a, 4))) {
                                throw new IllegalStateException("Invalid magic");
                            }
                            c3790bArrM7553l = m7553l(fileInputStreamM7540a, m7547f(fileInputStreamM7540a, 4), c3789a2.f12761e);
                            try {
                                fileInputStreamM7540a.close();
                            } catch (IOException e11) {
                                interfaceC3791c.mo6880b(7, e11);
                            }
                            c3789a2.f12763g = c3790bArrM7553l;
                        } catch (IOException e12) {
                            i6 = 7;
                            interfaceC3791c.mo6880b(7, e12);
                            try {
                                fileInputStreamM7540a.close();
                            } catch (IOException e13) {
                                iOException = e13;
                                interfaceC3791c.mo6880b(i6, iOException);
                                c3790bArrM7553l = null;
                                c3789a2.f12763g = c3790bArrM7553l;
                                c3790bArr = c3789a2.f12763g;
                                if (c3790bArr != null) {
                                    c3789a = c3789a2;
                                } else {
                                    c3789a = c3789a2;
                                }
                                interfaceC3791c2 = c3789a.f12758b;
                                c3790bArr2 = c3789a.f12763g;
                                if (c3790bArr2 != null) {
                                    if (!c3789a.f12762f) {
                                        throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                                    }
                                    try {
                                        byteArrayOutputStream = new ByteArrayOutputStream();
                                        try {
                                            byteArrayOutputStream.write(bArr);
                                            byteArrayOutputStream.write(bArr4);
                                            if (m7556o(byteArrayOutputStream, bArr4, c3790bArr2)) {
                                                c3789a.f12764h = byteArrayOutputStream.toByteArray();
                                                byteArrayOutputStream.close();
                                                c3789a.f12763g = null;
                                            } else {
                                                interfaceC3791c2.mo6880b(5, null);
                                                c3789a.f12763g = null;
                                                byteArrayOutputStream.close();
                                            }
                                        } catch (Throwable th4) {
                                            try {
                                                byteArrayOutputStream.close();
                                                throw th4;
                                            } catch (Throwable th5) {
                                                th4.addSuppressed(th5);
                                                throw th4;
                                            }
                                        }
                                    } catch (IOException e14) {
                                        interfaceC3791c2.mo6880b(7, e14);
                                    } catch (IllegalStateException e15) {
                                        interfaceC3791c2.mo6880b(8, e15);
                                    }
                                }
                                bArr2 = c3789a.f12764h;
                                if (bArr2 == null) {
                                    z10 = false;
                                } else {
                                    try {
                                        if (!c3789a.f12762f) {
                                            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                                        }
                                        try {
                                            try {
                                                byteArrayInputStream = new ByteArrayInputStream(bArr2);
                                                try {
                                                    fileOutputStream = new FileOutputStream(c3789a.f12760d);
                                                    try {
                                                        try {
                                                            bArr3 = new byte[512];
                                                            while (true) {
                                                                i10 = byteArrayInputStream.read(bArr3);
                                                                if (i10 > 0) {
                                                                    fileOutputStream.write(bArr3, 0, i10);
                                                                } else {
                                                                    try {
                                                                        c3789a.m7541b(1, null);
                                                                        fileOutputStream.close();
                                                                        byteArrayInputStream.close();
                                                                        c3789a.f12764h = null;
                                                                        c3789a.f12763g = null;
                                                                        z10 = true;
                                                                    } catch (Throwable th6) {
                                                                        th = th6;
                                                                    }
                                                                }
                                                                th = th;
                                                                try {
                                                                    fileOutputStream.close();
                                                                    throw th;
                                                                } catch (Throwable th7) {
                                                                    th.addSuppressed(th7);
                                                                    throw th;
                                                                }
                                                            }
                                                        } catch (Throwable th8) {
                                                            th = th8;
                                                            Throwable th9 = th;
                                                            try {
                                                                byteArrayInputStream.close();
                                                                throw th9;
                                                            } catch (Throwable th10) {
                                                                th9.addSuppressed(th10);
                                                                throw th9;
                                                            }
                                                        }
                                                    } catch (Throwable th11) {
                                                        th = th11;
                                                    }
                                                } catch (Throwable th12) {
                                                    th = th12;
                                                }
                                            } catch (FileNotFoundException e16) {
                                                e = e16;
                                                c3789a.m7541b(6, e);
                                                c3789a.f12764h = null;
                                                c3789a.f12763g = null;
                                                z10 = false;
                                            } catch (IOException e17) {
                                                e = e17;
                                                c3789a.m7541b(7, e);
                                                c3789a.f12764h = null;
                                                c3789a.f12763g = null;
                                                z10 = false;
                                            }
                                        } catch (FileNotFoundException e18) {
                                            e = e18;
                                            c3789a.m7541b(6, e);
                                            c3789a.f12764h = null;
                                            c3789a.f12763g = null;
                                            z10 = false;
                                        } catch (IOException e19) {
                                            e = e19;
                                            c3789a.m7541b(7, e);
                                            c3789a.f12764h = null;
                                            c3789a.f12763g = null;
                                            z10 = false;
                                        }
                                    } catch (Throwable th13) {
                                        c3789a.f12764h = null;
                                        c3789a.f12763g = null;
                                        throw th13;
                                    }
                                }
                                if (z10) {
                                    m7546e(packageInfo, filesDir);
                                }
                                if (z10) {
                                    z11 = false;
                                } else {
                                    z11 = false;
                                }
                                AbstractC3798j.m7570c(context, z11);
                            }
                            c3790bArrM7553l = null;
                        } catch (IllegalStateException e20) {
                            try {
                                interfaceC3791c.mo6880b(8, e20);
                                try {
                                    fileInputStreamM7540a.close();
                                } catch (IOException e21) {
                                    iOException = e21;
                                    i6 = 7;
                                    interfaceC3791c.mo6880b(i6, iOException);
                                    c3790bArrM7553l = null;
                                    c3789a2.f12763g = c3790bArrM7553l;
                                    c3790bArr = c3789a2.f12763g;
                                    if (c3790bArr != null) {
                                        c3789a = c3789a2;
                                    } else {
                                        c3789a = c3789a2;
                                    }
                                    interfaceC3791c2 = c3789a.f12758b;
                                    c3790bArr2 = c3789a.f12763g;
                                    if (c3790bArr2 != null) {
                                        if (!c3789a.f12762f) {
                                            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                                        }
                                        byteArrayOutputStream = new ByteArrayOutputStream();
                                        byteArrayOutputStream.write(bArr);
                                        byteArrayOutputStream.write(bArr4);
                                        if (m7556o(byteArrayOutputStream, bArr4, c3790bArr2)) {
                                            interfaceC3791c2.mo6880b(5, null);
                                            c3789a.f12763g = null;
                                            byteArrayOutputStream.close();
                                        } else {
                                            c3789a.f12764h = byteArrayOutputStream.toByteArray();
                                            byteArrayOutputStream.close();
                                            c3789a.f12763g = null;
                                        }
                                    }
                                    bArr2 = c3789a.f12764h;
                                    if (bArr2 == null) {
                                        if (!c3789a.f12762f) {
                                            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                                        }
                                        byteArrayInputStream = new ByteArrayInputStream(bArr2);
                                        fileOutputStream = new FileOutputStream(c3789a.f12760d);
                                        bArr3 = new byte[512];
                                        while (true) {
                                            i10 = byteArrayInputStream.read(bArr3);
                                            if (i10 > 0) {
                                                fileOutputStream.write(bArr3, 0, i10);
                                            } else {
                                                c3789a.m7541b(1, null);
                                                fileOutputStream.close();
                                                byteArrayInputStream.close();
                                                c3789a.f12764h = null;
                                                c3789a.f12763g = null;
                                                z10 = true;
                                            }
                                            th = th;
                                            fileOutputStream.close();
                                            throw th;
                                        }
                                    }
                                    z10 = false;
                                    if (z10) {
                                        m7546e(packageInfo, filesDir);
                                    }
                                    if (z10) {
                                        z11 = false;
                                    } else {
                                        z11 = false;
                                    }
                                    AbstractC3798j.m7570c(context, z11);
                                }
                                c3790bArrM7553l = null;
                            } catch (Throwable th14) {
                                th = th14;
                                Throwable th15 = th;
                                try {
                                    fileInputStreamM7540a.close();
                                    throw th15;
                                } catch (IOException e22) {
                                    interfaceC3791c.mo6880b(7, e22);
                                    throw th15;
                                }
                            }
                        }
                    }
                    c3790bArr = c3789a2.f12763g;
                    if (c3790bArr != null || (i11 = Build.VERSION.SDK_INT) < 24 || i11 > 34) {
                        c3789a = c3789a2;
                    } else if (i11 != 24 && i11 != 25) {
                        switch (i11) {
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                                fileInputStreamM7540a2 = c3789a2.m7540a(assets, "dexopt/baseline.profm");
                                if (fileInputStreamM7540a2 == null) {
                                    if (fileInputStreamM7540a2 != null) {
                                        fileInputStreamM7540a2.close();
                                    }
                                    c3789a = null;
                                } else {
                                    if (Arrays.equals(f12776c, m7547f(fileInputStreamM7540a2, 4))) {
                                        throw new IllegalStateException("Invalid magic");
                                    }
                                    c3789a2.f12763g = m7550i(fileInputStreamM7540a2, m7547f(fileInputStreamM7540a2, 4), bArr5, c3790bArr);
                                    fileInputStreamM7540a2.close();
                                    c3789a = c3789a2;
                                }
                                if (c3789a == null) {
                                    c3789a = c3789a2;
                                }
                                break;
                            default:
                                c3789a = c3789a2;
                                break;
                        }
                    } else {
                        try {
                            fileInputStreamM7540a2 = c3789a2.m7540a(assets, "dexopt/baseline.profm");
                            if (fileInputStreamM7540a2 == null) {
                                try {
                                    if (Arrays.equals(f12776c, m7547f(fileInputStreamM7540a2, 4))) {
                                        throw new IllegalStateException("Invalid magic");
                                    }
                                    c3789a2.f12763g = m7550i(fileInputStreamM7540a2, m7547f(fileInputStreamM7540a2, 4), bArr5, c3790bArr);
                                    fileInputStreamM7540a2.close();
                                    c3789a = c3789a2;
                                } catch (Throwable th16) {
                                    try {
                                        fileInputStreamM7540a2.close();
                                        throw th16;
                                    } catch (Throwable th17) {
                                        th16.addSuppressed(th17);
                                        throw th16;
                                    }
                                }
                            } else {
                                if (fileInputStreamM7540a2 != null) {
                                    fileInputStreamM7540a2.close();
                                }
                                c3789a = null;
                            }
                        } catch (FileNotFoundException e23) {
                            interfaceC3791c.mo6880b(9, e23);
                        } catch (IOException e24) {
                            interfaceC3791c.mo6880b(7, e24);
                        } catch (IllegalStateException e25) {
                            c3789a2.f12763g = null;
                            interfaceC3791c.mo6880b(8, e25);
                        }
                        if (c3789a == null) {
                            c3789a = c3789a2;
                        }
                    }
                    interfaceC3791c2 = c3789a.f12758b;
                    c3790bArr2 = c3789a.f12763g;
                    if (c3790bArr2 != null && (bArr4 = c3789a.f12759c) != null) {
                        if (!c3789a.f12762f) {
                            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                        }
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        byteArrayOutputStream.write(bArr);
                        byteArrayOutputStream.write(bArr4);
                        if (m7556o(byteArrayOutputStream, bArr4, c3790bArr2)) {
                            interfaceC3791c2.mo6880b(5, null);
                            c3789a.f12763g = null;
                            byteArrayOutputStream.close();
                        } else {
                            c3789a.f12764h = byteArrayOutputStream.toByteArray();
                            byteArrayOutputStream.close();
                            c3789a.f12763g = null;
                        }
                    }
                    bArr2 = c3789a.f12764h;
                    if (bArr2 == null) {
                        if (!c3789a.f12762f) {
                            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                        }
                        byteArrayInputStream = new ByteArrayInputStream(bArr2);
                        fileOutputStream = new FileOutputStream(c3789a.f12760d);
                        bArr3 = new byte[512];
                        while (true) {
                            i10 = byteArrayInputStream.read(bArr3);
                            if (i10 > 0) {
                                fileOutputStream.write(bArr3, 0, i10);
                            } else {
                                c3789a.m7541b(1, null);
                                fileOutputStream.close();
                                byteArrayInputStream.close();
                                c3789a.f12764h = null;
                                c3789a.f12763g = null;
                                z10 = true;
                            }
                            th = th;
                            fileOutputStream.close();
                            throw th;
                        }
                    }
                    z10 = false;
                    if (z10) {
                        m7546e(packageInfo, filesDir);
                    }
                    if (z10) {
                        z11 = false;
                    } else {
                        z11 = false;
                    }
                    AbstractC3798j.m7570c(context, z11);
                } catch (Throwable th18) {
                    th = th18;
                }
                c3789a2.f12762f = true;
                bArr = f12775b;
            }
            z10 = false;
            if (z10) {
                z11 = false;
            } else {
                z11 = false;
            }
            AbstractC3798j.m7570c(context, z11);
        } catch (PackageManager.NameNotFoundException e26) {
            interfaceC3791c.mo6880b(7, e26);
            AbstractC3798j.m7570c(context, false);
        }
    }

    public static void m7561t(ByteArrayOutputStream byteArrayOutputStream, long j10, int i6) throws IOException {
        byte[] bArr = new byte[i6];
        for (int i10 = 0; i10 < i6; i10++) {
            bArr[i10] = (byte) ((j10 >> (i10 * 8)) & 255);
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void m7562u(ByteArrayOutputStream byteArrayOutputStream, int i6) throws IOException {
        m7561t(byteArrayOutputStream, i6, 2);
    }
}

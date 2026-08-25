package okhttp3.internal.publicsuffix;

import com.lzy.okgo.cookie.SerializableCookie;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import p003a2.AbstractC0032a;
import p055ea.AbstractC2460q;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;
import p156o9.AbstractC3281e;
import p181q9.C3544b;
import p181q9.C3549g;
import p181q9.InterfaceC3545c;
import p192r9.AbstractC3648f;
import p253x8.AbstractC4147j;
import p253x8.C4155r;

public final class PublicSuffixDatabase {
    private static final char EXCEPTION_MARKER = '!';
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    public static final Companion Companion = new Companion(null);
    private static final byte[] WILDCARD_LABEL = {42};
    private static final List<String> PREVAILING_RULE = AbstractC0032a.m154F("*");
    private static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        public final String binarySearch(byte[] bArr, byte[][] bArr2, int i6) {
            int i10;
            int iAnd;
            boolean z7;
            int iAnd2;
            int length = bArr.length;
            int i11 = 0;
            while (i11 < length) {
                int i12 = (i11 + length) / 2;
                while (i12 > -1 && bArr[i12] != 10) {
                    i12--;
                }
                int i13 = i12 + 1;
                int i14 = 1;
                while (true) {
                    i10 = i13 + i14;
                    if (bArr[i10] == 10) {
                        break;
                    }
                    i14++;
                }
                int i15 = i10 - i13;
                int i16 = i6;
                boolean z10 = false;
                int i17 = 0;
                int i18 = 0;
                while (true) {
                    if (z10) {
                        iAnd = 46;
                        z7 = false;
                    } else {
                        boolean z11 = z10;
                        iAnd = Util.and(bArr2[i16][i17], 255);
                        z7 = z11;
                    }
                    iAnd2 = iAnd - Util.and(bArr[i13 + i18], 255);
                    if (iAnd2 != 0) {
                        break;
                    }
                    i18++;
                    i17++;
                    if (i18 == i15) {
                        break;
                    }
                    if (bArr2[i16].length != i17) {
                        z10 = z7;
                    } else {
                        if (i16 == bArr2.length - 1) {
                            break;
                        }
                        i16++;
                        z10 = true;
                        i17 = -1;
                    }
                }
                if (iAnd2 >= 0) {
                    if (iAnd2 <= 0) {
                        int i19 = i15 - i18;
                        int length2 = bArr2[i16].length - i17;
                        int length3 = bArr2.length;
                        for (int i20 = i16 + 1; i20 < length3; i20++) {
                            length2 += bArr2[i20].length;
                        }
                        if (length2 >= i19) {
                            if (length2 <= i19) {
                                Charset charset = StandardCharsets.UTF_8;
                                AbstractC2796i.m5784e(charset, "UTF_8");
                                return new String(bArr, i13, i15, charset);
                            }
                        }
                    }
                    i11 = i10 + 1;
                }
                length = i12;
            }
            return null;
        }

        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }

        private Companion() {
        }
    }

    private final List<String> findMatchingRule(List<String> list) {
        String str;
        String strBinarySearch;
        String strBinarySearch2;
        if (this.listRead.get() || !this.listRead.compareAndSet(false, true)) {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            readTheListUninterruptibly();
        }
        if (this.publicSuffixListBytes == null) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
        }
        int size = list.size();
        byte[][] bArr = new byte[size][];
        for (int i6 = 0; i6 < size; i6++) {
            String str2 = list.get(i6);
            Charset charset = StandardCharsets.UTF_8;
            AbstractC2796i.m5784e(charset, "UTF_8");
            byte[] bytes = str2.getBytes(charset);
            AbstractC2796i.m5784e(bytes, "this as java.lang.String).getBytes(charset)");
            bArr[i6] = bytes;
        }
        int i10 = 0;
        while (true) {
            str = null;
            if (i10 >= size) {
                strBinarySearch = null;
                break;
            }
            Companion companion = Companion;
            byte[] bArr2 = this.publicSuffixListBytes;
            if (bArr2 == null) {
                AbstractC2796i.m5791l("publicSuffixListBytes");
                throw null;
            }
            strBinarySearch = companion.binarySearch(bArr2, bArr, i10);
            if (strBinarySearch != null) {
                break;
            }
            i10++;
        }
        if (size <= 1) {
            strBinarySearch2 = null;
            break;
        }
        byte[][] bArr3 = (byte[][]) bArr.clone();
        int length = bArr3.length - 1;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                strBinarySearch2 = null;
                break;
            }
            bArr3[i11] = WILDCARD_LABEL;
            Companion companion2 = Companion;
            byte[] bArr4 = this.publicSuffixListBytes;
            if (bArr4 == null) {
                AbstractC2796i.m5791l("publicSuffixListBytes");
                throw null;
            }
            strBinarySearch2 = companion2.binarySearch(bArr4, bArr3, i11);
            if (strBinarySearch2 != null) {
                break;
            }
            i11++;
        }
        if (strBinarySearch2 != null) {
            int i12 = size - 1;
            for (int i13 = 0; i13 < i12; i13++) {
                Companion companion3 = Companion;
                byte[] bArr5 = this.publicSuffixExceptionListBytes;
                if (bArr5 == null) {
                    AbstractC2796i.m5791l("publicSuffixExceptionListBytes");
                    throw null;
                }
                String strBinarySearch3 = companion3.binarySearch(bArr5, bArr, i13);
                if (strBinarySearch3 != null) {
                    str = strBinarySearch3;
                    break;
                }
            }
        }
        if (str != null) {
            return AbstractC3648f.m7386h0("!".concat(str), new char[]{'.'});
        }
        if (strBinarySearch == null && strBinarySearch2 == null) {
            return PREVAILING_RULE;
        }
        List<String> listM7386h0 = C4155r.f14074a;
        List<String> listM7386h1 = strBinarySearch != null ? AbstractC3648f.m7386h0(strBinarySearch, new char[]{'.'}) : listM7386h0;
        if (strBinarySearch2 != null) {
            listM7386h0 = AbstractC3648f.m7386h0(strBinarySearch2, new char[]{'.'});
        }
        return listM7386h1.size() > listM7386h0.size() ? listM7386h1 : listM7386h0;
    }

    private final void readTheList() throws IOException {
        try {
            InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
            if (resourceAsStream == null) {
                this.readCompleteLatch.countDown();
                return;
            }
            BufferedSource bufferedSourceBuffer = Okio.buffer(new GzipSource(Okio.source(resourceAsStream)));
            try {
                byte[] byteArray = bufferedSourceBuffer.readByteArray(bufferedSourceBuffer.readInt());
                byte[] byteArray2 = bufferedSourceBuffer.readByteArray(bufferedSourceBuffer.readInt());
                AbstractC0032a.m164r(bufferedSourceBuffer, null);
                synchronized (this) {
                    AbstractC2796i.m5782c(byteArray);
                    this.publicSuffixListBytes = byteArray;
                    AbstractC2796i.m5782c(byteArray2);
                    this.publicSuffixExceptionListBytes = byteArray2;
                }
                this.readCompleteLatch.countDown();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AbstractC0032a.m164r(bufferedSourceBuffer, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            this.readCompleteLatch.countDown();
            throw th3;
        }
    }

    private final void readTheListUninterruptibly() {
        boolean z7 = false;
        while (true) {
            try {
                try {
                    readTheList();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z7 = true;
                } catch (IOException e5) {
                    Platform.Companion.get().log("Failed to read public suffix list", 5, e5);
                    if (z7) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z7) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z7) {
            Thread.currentThread().interrupt();
        }
    }

    private final List<String> splitDomain(String str) {
        List<String> listM7386h0 = AbstractC3648f.m7386h0(str, new char[]{'.'});
        if (!AbstractC2796i.m5780a(AbstractC4147j.m8185Y(listM7386h0), "")) {
            return listM7386h0;
        }
        int size = listM7386h0.size() - 1;
        if (size < 0) {
            size = 0;
        }
        if (size < 0) {
            throw new IllegalArgumentException(AbstractC2460q.m5492f(size, "Requested element count ", " is less than zero.").toString());
        }
        C4155r c4155r = C4155r.f14074a;
        if (size == 0) {
            return c4155r;
        }
        if (size >= listM7386h0.size()) {
            return AbstractC4147j.m8189c0(listM7386h0);
        }
        if (size == 1) {
            return AbstractC0032a.m154F(AbstractC4147j.m8180T(listM7386h0));
        }
        ArrayList arrayList = new ArrayList(size);
        Iterator<T> it = listM7386h0.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i6++;
            if (i6 == size) {
                break;
            }
        }
        int size2 = arrayList.size();
        if (size2 != 0) {
            return size2 != 1 ? arrayList : AbstractC0032a.m154F(arrayList.get(0));
        }
        return c4155r;
    }

    public final String getEffectiveTldPlusOne(String str) {
        int size;
        int size2;
        AbstractC2796i.m5785f(str, SerializableCookie.DOMAIN);
        String unicode = IDN.toUnicode(str);
        AbstractC2796i.m5784e(unicode, "unicodeDomain");
        List<String> listSplitDomain = splitDomain(unicode);
        List<String> listFindMatchingRule = findMatchingRule(listSplitDomain);
        int i6 = 0;
        if (listSplitDomain.size() == listFindMatchingRule.size() && listFindMatchingRule.get(0).charAt(0) != '!') {
            return null;
        }
        if (listFindMatchingRule.get(0).charAt(0) == '!') {
            size = listSplitDomain.size();
            size2 = listFindMatchingRule.size();
        } else {
            size = listSplitDomain.size();
            size2 = listFindMatchingRule.size() + 1;
        }
        int i10 = size - size2;
        List<String> listSplitDomain2 = splitDomain(str);
        AbstractC2796i.m5785f(listSplitDomain2, "<this>");
        InterfaceC3545c c3549g = new C3549g(2, listSplitDomain2);
        if (i10 < 0) {
            throw new IllegalArgumentException(AbstractC2460q.m5492f(i10, "Requested element count ", " is less than zero.").toString());
        }
        if (i10 != 0) {
            c3549g = new C3544b(c3549g, i10);
        }
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        for (Object obj : c3549g) {
            i6++;
            if (i6 > 1) {
                sb.append((CharSequence) ".");
            }
            AbstractC3281e.m6617g(sb, obj, null);
        }
        sb.append((CharSequence) "");
        return sb.toString();
    }

    public final void setListBytes(byte[] bArr, byte[] bArr2) {
        AbstractC2796i.m5785f(bArr, "publicSuffixListBytes");
        AbstractC2796i.m5785f(bArr2, "publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = bArr;
        this.publicSuffixExceptionListBytes = bArr2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}

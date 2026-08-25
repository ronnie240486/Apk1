package p233v7;

import java.io.IOException;
import java.net.IDN;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import p000a.AbstractC0004e;
import p173q1.C3440q1;
import p222u7.C3930f;

public final class C4019f extends AbstractC4014a {

    public final long f13631e;

    public final int f13632f;

    public final String f13633g;

    public final C4015b f13634h;

    public final byte[] f13635i;

    public final int f13636j;

    public final int f13637k;

    public final ArrayList f13638l;

    public final ArrayList f13639m;

    public final ArrayList f13640n;

    public C4019f(String str, int i6, C4015b c4015b, byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            throw new IOException("response data is empty");
        }
        this.f13633g = str;
        this.f13632f = i6;
        this.f13634h = c4015b;
        this.f13635i = bArr;
        this.f13631e = new Date().getTime() / 1000;
        int i10 = 12;
        if (bArr.length < 12) {
            throw new IOException("response data too small");
        }
        short sM8010c = m8010c(0);
        this.f13612a = sM8010c;
        if (sM8010c != c4015b.f13612a) {
            throw new IOException("question id error");
        }
        int iM8011d = m8011d(2);
        if ((m8011d(2) & 128) == 0) {
            throw new IOException("not a response data");
        }
        this.f13613b = (iM8011d >> 3) & 7;
        this.f13636j = (iM8011d >> 2) & 1;
        this.f13614c = iM8011d & 1;
        int iM8011d2 = m8011d(3);
        this.f13615d = (iM8011d2 >> 7) & 1;
        this.f13637k = iM8011d2 & 15;
        for (int iM8010c = m8010c(4); iM8010c > 0; iM8010c--) {
            C3440q1 c3440q1M8008a = m8008a(i10);
            if (c3440q1M8008a == null) {
                throw new IOException("read Question error");
            }
            i10 += c3440q1M8008a.f11639a + 4;
        }
        C4018e c4018e = new C4018e("answer", m8010c(6), i10);
        m8009b(c4018e);
        this.f13638l = c4018e.f13630e;
        int i11 = i10 + c4018e.f13629d;
        C4018e c4018e2 = new C4018e("authority", m8010c(8), i11);
        m8009b(c4018e2);
        this.f13639m = c4018e2.f13630e;
        C4018e c4018e3 = new C4018e("additional", m8010c(10), i11 + c4018e2.f13629d);
        m8009b(c4018e3);
        this.f13640n = c4018e3.f13630e;
    }

    public final C3440q1 m8008a(int i6) throws IOException {
        StringBuilder sb = new StringBuilder();
        C3440q1 c3440q1 = new C3440q1();
        int i10 = 128;
        int iM8011d = i6;
        do {
            int iM8011d2 = m8011d(iM8011d);
            int i11 = iM8011d2 & 192;
            if (i11 == 192) {
                if (c3440q1.f11639a < 1) {
                    c3440q1.f11639a = (iM8011d + 2) - i6;
                }
                iM8011d = m8011d(iM8011d + 1) | ((iM8011d2 & 63) << 8);
            } else {
                if (i11 > 0) {
                    return null;
                }
                iM8011d++;
                if (iM8011d2 > 0) {
                    if (sb.length() > 0) {
                        sb.append(".");
                    }
                    int i12 = iM8011d + iM8011d2;
                    sb.append(IDN.toUnicode(new String(Arrays.copyOfRange(this.f13635i, iM8011d, i12))));
                    iM8011d = i12;
                }
            }
            if (iM8011d2 <= 0) {
                break;
            }
            i10--;
        } while (i10 > 0);
        c3440q1.f11640b = sb.toString();
        if (c3440q1.f11639a < 1) {
            c3440q1.f11639a = iM8011d - i6;
        }
        return c3440q1;
    }

    public final void m8009b(C4018e c4018e) throws IOException {
        String string;
        int i6;
        int i10 = c4018e.f13628c;
        int i11 = i10;
        for (int i12 = c4018e.f13627b; i12 > 0; i12--) {
            C3440q1 c3440q1M8008a = m8008a(i11);
            if (c3440q1M8008a == null) {
                throw new IOException(AbstractC0004e.m26t(new StringBuilder("read "), c4018e.f13626a, " error"));
            }
            int i13 = i11 + c3440q1M8008a.f11639a;
            short sM8010c = m8010c(i13);
            short sM8010c2 = m8010c(i13 + 2);
            int i14 = i13 + 4;
            int i15 = i13 + 7;
            byte[] bArr = this.f13635i;
            if (i15 >= bArr.length) {
                throw new IOException("read response data out of range");
            }
            int i16 = (bArr[i15] & 255) + ((bArr[i14] & 255) << 24) + ((bArr[i13 + 5] & 255) << 16) + ((bArr[i13 + 6] & 255) << 8);
            short sM8010c3 = m8010c(i13 + 8);
            int i17 = i13 + 10;
            if (sM8010c != 1) {
                if (sM8010c != 5) {
                    if (sM8010c != 16) {
                        if (sM8010c == 28 && sM8010c3 == 16) {
                            StringBuilder sb = new StringBuilder();
                            int i18 = 0;
                            while (i18 < 16) {
                                sb.append(i18 > 0 ? ":" : "");
                                int i19 = i17 + i18;
                                sb.append(m8011d(i19));
                                sb.append(m8011d(i19 + 1));
                                i18 += 2;
                            }
                            string = sb.toString();
                        } else {
                            string = null;
                        }
                    } else if (sM8010c3 <= 0 || (i6 = i17 + sM8010c3) >= bArr.length) {
                        string = null;
                    } else {
                        string = IDN.toUnicode(new String(Arrays.copyOfRange(bArr, i17, i6)));
                    }
                } else if (sM8010c3 > 1) {
                    string = m8008a(i17).f11640b;
                } else {
                    string = null;
                }
            } else if (sM8010c3 == 4) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(m8011d(i17));
                for (int i20 = 1; i20 < 4; i20++) {
                    sb2.append(".");
                    sb2.append(m8011d(i17 + i20));
                }
                string = sb2.toString();
            } else {
                string = null;
            }
            if (sM8010c2 == 1 && (sM8010c == 5 || sM8010c == 1)) {
                c4018e.f13630e.add(new C3930f(string, sM8010c, i16, this.f13631e, this.f13632f, this.f13633g));
            }
            i11 = i17 + sM8010c3;
        }
        c4018e.f13629d = i11 - i10;
    }

    public final short m8010c(int i6) throws IOException {
        int i10 = i6 + 1;
        byte[] bArr = this.f13635i;
        if (i10 < bArr.length) {
            return (short) (((bArr[i6] & 255) << 8) + (bArr[i10] & 255));
        }
        throw new IOException("read response data out of range");
    }

    public final int m8011d(int i6) throws IOException {
        byte[] bArr = this.f13635i;
        if (i6 < bArr.length) {
            return bArr[i6] & 255;
        }
        throw new IOException("read response data out of range");
    }

    public final String toString() {
        return String.format(Locale.getDefault(), "{messageId:%d, rd:%d, ra:%d, aa:%d, rCode:%d, server:%s, request:%s, answerArray:%s, authorityArray:%s, additionalArray:%s}", Short.valueOf(this.f13612a), Integer.valueOf(this.f13614c), Integer.valueOf(this.f13615d), Integer.valueOf(this.f13636j), Integer.valueOf(this.f13637k), this.f13633g, this.f13634h, this.f13638l, this.f13639m, this.f13640n);
    }
}

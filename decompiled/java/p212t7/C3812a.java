package p212t7;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import okio.internal.Buffer;
import p000a.AbstractC0004e;
import p055ea.AbstractC2460q;
import p171q.C3388b;

public class C3812a implements Closeable {

    public final Reader f12872a;

    public long f12880i;

    public int f12881j;

    public String f12882k;

    public int[] f12883l;

    public String[] f12885n;

    public int[] f12886o;

    public boolean f12873b = false;

    public final char[] f12874c = new char[1024];

    public int f12875d = 0;

    public int f12876e = 0;

    public int f12877f = 0;

    public int f12878g = 0;

    public int f12879h = 0;

    public int f12884m = 1;

    static {
        C3388b.f11424b = new C3388b(5);
    }

    public C3812a(Reader reader) {
        int[] iArr = new int[32];
        this.f12883l = iArr;
        iArr[0] = 6;
        this.f12885n = new String[32];
        this.f12886o = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f12872a = reader;
    }

    public final void m7591A(String str) throws C3814c {
        StringBuilder sbM5498l = AbstractC2460q.m5498l(str);
        sbM5498l.append(m7601j());
        throw new C3814c(sbM5498l.toString());
    }

    public final void m7592a() throws IOException {
        int iM7595d = this.f12879h;
        if (iM7595d == 0) {
            iM7595d = m7595d();
        }
        if (iM7595d == 3) {
            m7613v(1);
            this.f12886o[this.f12884m - 1] = 0;
            this.f12879h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + AbstractC2460q.m5503q(m7612u()) + m7601j());
        }
    }

    public final void m7593b() throws IOException {
        int iM7595d = this.f12879h;
        if (iM7595d == 0) {
            iM7595d = m7595d();
        }
        if (iM7595d == 1) {
            m7613v(3);
            this.f12879h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + AbstractC2460q.m5503q(m7612u()) + m7601j());
        }
    }

    public final void m7594c() throws C3814c {
        if (this.f12873b) {
            return;
        }
        m7591A("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    @Override
    public final void close() throws IOException {
        this.f12879h = 0;
        this.f12883l[0] = 8;
        this.f12884m = 1;
        this.f12872a.close();
    }

    public final int m7595d() throws IOException {
        int iM7607p;
        int iM7607p2;
        int i6;
        String str;
        String str2;
        int i10;
        char c5;
        int i11;
        int i12;
        char c8;
        int i13;
        boolean z7;
        char c10;
        int i14;
        int i15;
        char c11;
        int[] iArr = this.f12883l;
        boolean z10 = true;
        int i16 = this.f12884m - 1;
        int i17 = iArr[i16];
        char[] cArr = this.f12874c;
        if (i17 == 1) {
            iArr[i16] = 2;
        } else if (i17 == 2) {
            int iM7607p3 = m7607p(true);
            if (iM7607p3 != 44) {
                if (iM7607p3 != 59) {
                    if (iM7607p3 == 93) {
                        this.f12879h = 4;
                        return 4;
                    }
                    m7591A("Unterminated array");
                    throw null;
                }
                m7594c();
            }
        } else {
            if (i17 == 3 || i17 == 5) {
                iArr[i16] = 4;
                if (i17 == 5 && (iM7607p = m7607p(true)) != 44) {
                    if (iM7607p != 59) {
                        if (iM7607p == 125) {
                            this.f12879h = 2;
                            return 2;
                        }
                        m7591A("Unterminated object");
                        throw null;
                    }
                    m7594c();
                }
                int iM7607p4 = m7607p(true);
                if (iM7607p4 == 34) {
                    this.f12879h = 13;
                    return 13;
                }
                if (iM7607p4 == 39) {
                    m7594c();
                    this.f12879h = 12;
                    return 12;
                }
                if (iM7607p4 == 125) {
                    if (i17 != 5) {
                        this.f12879h = 2;
                        return 2;
                    }
                    m7591A("Expected name");
                    throw null;
                }
                m7594c();
                this.f12875d--;
                if (m7600i((char) iM7607p4)) {
                    this.f12879h = 14;
                    return 14;
                }
                m7591A("Expected name");
                throw null;
            }
            if (i17 != 4) {
                if (i17 == 6) {
                    if (this.f12873b) {
                        m7607p(true);
                        int i18 = this.f12875d;
                        int i19 = i18 - 1;
                        this.f12875d = i19;
                        if ((i18 + 4 <= this.f12876e || m7598g(5)) && cArr[i19] == ')' && cArr[i18] == ']' && cArr[i18 + 1] == '}' && cArr[i18 + 2] == '\'' && cArr[i18 + 3] == '\n') {
                            this.f12875d += 5;
                        }
                    }
                    this.f12883l[this.f12884m - 1] = 7;
                } else if (i17 == 7) {
                    if (m7607p(false) == -1) {
                        this.f12879h = 17;
                        return 17;
                    }
                    m7594c();
                    this.f12875d--;
                } else if (i17 == 8) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                iM7607p2 = m7607p(true);
                if (iM7607p2 != 34) {
                    this.f12879h = 9;
                    return 9;
                }
                if (iM7607p2 != 39) {
                    m7594c();
                    this.f12879h = 8;
                    return 8;
                }
                if (iM7607p2 != 44 || iM7607p2 == 59) {
                    i6 = 1;
                } else {
                    if (iM7607p2 == 91) {
                        this.f12879h = 3;
                        return 3;
                    }
                    if (iM7607p2 != 93) {
                        if (iM7607p2 == 123) {
                            this.f12879h = 1;
                            return 1;
                        }
                        int i20 = this.f12875d - 1;
                        this.f12875d = i20;
                        char c12 = cArr[i20];
                        if (c12 == 't' || c12 == 'T') {
                            str = "true";
                            str2 = "TRUE";
                            i10 = 5;
                        } else {
                            if (c12 != 'f' && c12 != 'F') {
                                if (c12 != 'n' && c12 != 'N') {
                                    i10 = 0;
                                    break;
                                }
                                str = "null";
                                str2 = "NULL";
                                i10 = 7;
                                if (i10 != 0) {
                                    return i10;
                                }
                                i11 = this.f12875d;
                                i12 = this.f12876e;
                                long j10 = 0;
                                c8 = 0;
                                i13 = 0;
                                z7 = true;
                                boolean z11 = false;
                                while (true) {
                                    if (i11 + i13 != i12) {
                                        c10 = cArr[i11 + i13];
                                        if (c10 != '+') {
                                            if (c10 != 'E' || c10 == 'e') {
                                                i14 = i12;
                                                if (c8 != 2 || c8 == 4) {
                                                    c8 = 5;
                                                    i13++;
                                                    i12 = i14;
                                                    z10 = true;
                                                }
                                            } else if (c10 == '-') {
                                                i14 = i12;
                                                if (c8 == 0) {
                                                    c8 = 1;
                                                    z11 = true;
                                                } else {
                                                    if (c8 != 5) {
                                                    }
                                                    c8 = 6;
                                                }
                                                i13++;
                                                i12 = i14;
                                                z10 = true;
                                            } else if (c10 == '.') {
                                                i14 = i12;
                                                if (c8 == 2) {
                                                    c8 = 3;
                                                    i13++;
                                                    i12 = i14;
                                                    z10 = true;
                                                }
                                            } else if (c10 >= '0' && c10 <= '9') {
                                                if (c8 == z10 || c8 == 0) {
                                                    i14 = i12;
                                                    j10 = -(c10 - '0');
                                                    c8 = 2;
                                                } else if (c8 != 2) {
                                                    i14 = i12;
                                                    if (c8 == 3) {
                                                        c8 = 4;
                                                    } else if (c8 == 5 || c8 == 6) {
                                                        c8 = 7;
                                                    }
                                                } else if (j10 != 0) {
                                                    i14 = i12;
                                                    long j11 = (10 * j10) - ((long) (c10 - '0'));
                                                    z7 &= j10 > Buffer.OVERFLOW_ZONE || (j10 == Buffer.OVERFLOW_ZONE && j11 < j10);
                                                    j10 = j11;
                                                }
                                                i13++;
                                                i12 = i14;
                                                z10 = true;
                                            } else if (!m7600i(c10)) {
                                                c11 = 2;
                                                if (c8 != 2) {
                                                    if (c8 != c11 || c8 == 4 || c8 == 7) {
                                                        this.f12881j = i13;
                                                        i15 = 16;
                                                        this.f12879h = 16;
                                                    }
                                                } else if (z7 || ((j10 == Long.MIN_VALUE && !z11) || (j10 == 0 && z11))) {
                                                    c11 = 2;
                                                    if (c8 != c11) {
                                                    }
                                                    this.f12881j = i13;
                                                    i15 = 16;
                                                    this.f12879h = 16;
                                                } else {
                                                    if (!z11) {
                                                        j10 = -j10;
                                                    }
                                                    this.f12880i = j10;
                                                    this.f12875d += i13;
                                                    i15 = 15;
                                                    this.f12879h = 15;
                                                }
                                            }
                                            if (i15 != 0) {
                                                return i15;
                                            }
                                            if (m7600i(cArr[this.f12875d])) {
                                                m7591A("Expected value");
                                                throw null;
                                            }
                                            m7594c();
                                            this.f12879h = 10;
                                            return 10;
                                        }
                                        i14 = i12;
                                        if (c8 != 5) {
                                        }
                                        c8 = 6;
                                        i13++;
                                        i12 = i14;
                                        z10 = true;
                                    } else if (i13 != cArr.length) {
                                        if (!m7598g(i13 + 1)) {
                                            int i21 = this.f12875d;
                                            i12 = this.f12876e;
                                            i11 = i21;
                                            c10 = cArr[i11 + i13];
                                            if (c10 != '+') {
                                                if (c10 != 'E') {
                                                    i14 = i12;
                                                    if (c8 != 2) {
                                                    }
                                                    c8 = 5;
                                                    i13++;
                                                    i12 = i14;
                                                    z10 = true;
                                                } else {
                                                    i14 = i12;
                                                    if (c8 != 2) {
                                                    }
                                                    c8 = 5;
                                                    i13++;
                                                    i12 = i14;
                                                    z10 = true;
                                                }
                                                if (i15 != 0) {
                                                    return i15;
                                                }
                                                if (m7600i(cArr[this.f12875d])) {
                                                    m7591A("Expected value");
                                                    throw null;
                                                }
                                                m7594c();
                                                this.f12879h = 10;
                                                return 10;
                                            }
                                            i14 = i12;
                                            if (c8 != 5) {
                                            }
                                            c8 = 6;
                                            i13++;
                                            i12 = i14;
                                            z10 = true;
                                        }
                                        c11 = 2;
                                        if (c8 != 2) {
                                            if (c8 != c11) {
                                            }
                                            this.f12881j = i13;
                                            i15 = 16;
                                            this.f12879h = 16;
                                        } else {
                                            if (z7) {
                                            }
                                            c11 = 2;
                                            if (c8 != c11) {
                                            }
                                            this.f12881j = i13;
                                            i15 = 16;
                                            this.f12879h = 16;
                                        }
                                        if (i15 != 0) {
                                            return i15;
                                        }
                                        if (m7600i(cArr[this.f12875d])) {
                                            m7591A("Expected value");
                                            throw null;
                                        }
                                        m7594c();
                                        this.f12879h = 10;
                                        return 10;
                                    }
                                    i15 = 0;
                                    if (i15 != 0) {
                                        return i15;
                                    }
                                    if (m7600i(cArr[this.f12875d])) {
                                        m7591A("Expected value");
                                        throw null;
                                    }
                                    m7594c();
                                    this.f12879h = 10;
                                    return 10;
                                }
                            }
                            str = "false";
                            str2 = "FALSE";
                            i10 = 6;
                        }
                        int length = str.length();
                        int i22 = 1;
                        while (true) {
                            if (i22 >= length) {
                                if ((this.f12875d + length >= this.f12876e && !m7598g(length + 1)) || !m7600i(cArr[this.f12875d + length])) {
                                    this.f12875d += length;
                                    this.f12879h = i10;
                                    break;
                                }
                                break;
                            }
                            if ((this.f12875d + i22 < this.f12876e || m7598g(i22 + 1)) && ((c5 = cArr[this.f12875d + i22]) == str.charAt(i22) || c5 == str2.charAt(i22))) {
                                i22++;
                            }
                            i10 = 0;
                            break;
                        }
                        if (i10 != 0) {
                            return i10;
                        }
                        i11 = this.f12875d;
                        i12 = this.f12876e;
                        long j12 = 0;
                        c8 = 0;
                        i13 = 0;
                        z7 = true;
                        boolean z12 = false;
                        while (true) {
                            if (i11 + i13 != i12) {
                                c10 = cArr[i11 + i13];
                                if (c10 != '+') {
                                    if (c10 != 'E') {
                                        i14 = i12;
                                        if (c8 != 2) {
                                        }
                                        c8 = 5;
                                        i13++;
                                        i12 = i14;
                                        z10 = true;
                                    } else {
                                        i14 = i12;
                                        if (c8 != 2) {
                                        }
                                        c8 = 5;
                                        i13++;
                                        i12 = i14;
                                        z10 = true;
                                    }
                                    if (i15 != 0) {
                                        return i15;
                                    }
                                    if (m7600i(cArr[this.f12875d])) {
                                        m7591A("Expected value");
                                        throw null;
                                    }
                                    m7594c();
                                    this.f12879h = 10;
                                    return 10;
                                }
                                i14 = i12;
                                if (c8 != 5) {
                                }
                                c8 = 6;
                                i13++;
                                i12 = i14;
                                z10 = true;
                            } else if (i13 != cArr.length) {
                                if (!m7598g(i13 + 1)) {
                                    int i23 = this.f12875d;
                                    i12 = this.f12876e;
                                    i11 = i23;
                                    c10 = cArr[i11 + i13];
                                    if (c10 != '+') {
                                        if (c10 != 'E') {
                                            i14 = i12;
                                            if (c8 != 2) {
                                            }
                                            c8 = 5;
                                            i13++;
                                            i12 = i14;
                                            z10 = true;
                                        } else {
                                            i14 = i12;
                                            if (c8 != 2) {
                                            }
                                            c8 = 5;
                                            i13++;
                                            i12 = i14;
                                            z10 = true;
                                        }
                                        if (i15 != 0) {
                                            return i15;
                                        }
                                        if (m7600i(cArr[this.f12875d])) {
                                            m7591A("Expected value");
                                            throw null;
                                        }
                                        m7594c();
                                        this.f12879h = 10;
                                        return 10;
                                    }
                                    i14 = i12;
                                    if (c8 != 5) {
                                    }
                                    c8 = 6;
                                    i13++;
                                    i12 = i14;
                                    z10 = true;
                                }
                                c11 = 2;
                                if (c8 != 2) {
                                    if (c8 != c11) {
                                    }
                                    this.f12881j = i13;
                                    i15 = 16;
                                    this.f12879h = 16;
                                } else {
                                    if (z7) {
                                    }
                                    c11 = 2;
                                    if (c8 != c11) {
                                    }
                                    this.f12881j = i13;
                                    i15 = 16;
                                    this.f12879h = 16;
                                }
                                if (i15 != 0) {
                                    return i15;
                                }
                                if (m7600i(cArr[this.f12875d])) {
                                    m7591A("Expected value");
                                    throw null;
                                }
                                m7594c();
                                this.f12879h = 10;
                                return 10;
                            }
                            i15 = 0;
                            if (i15 != 0) {
                                return i15;
                            }
                            if (m7600i(cArr[this.f12875d])) {
                                m7591A("Expected value");
                                throw null;
                            }
                            m7594c();
                            this.f12879h = 10;
                            return 10;
                        }
                    }
                    i6 = 1;
                    if (i17 == 1) {
                        this.f12879h = 4;
                        return 4;
                    }
                }
                if (i17 == i6 && i17 != 2) {
                    m7591A("Unexpected value");
                    throw null;
                }
                m7594c();
                this.f12875d -= i6;
                this.f12879h = 7;
                return 7;
            }
            iArr[i16] = 5;
            int iM7607p5 = m7607p(true);
            if (iM7607p5 != 58) {
                if (iM7607p5 != 61) {
                    m7591A("Expected ':'");
                    throw null;
                }
                m7594c();
                if (this.f12875d < this.f12876e || m7598g(1)) {
                    int i24 = this.f12875d;
                    if (cArr[i24] == '>') {
                        this.f12875d = i24 + 1;
                    }
                }
            }
        }
        iM7607p2 = m7607p(true);
        if (iM7607p2 != 34) {
            this.f12879h = 9;
            return 9;
        }
        if (iM7607p2 != 39) {
            m7594c();
            this.f12879h = 8;
            return 8;
        }
        if (iM7607p2 != 44) {
            i6 = 1;
        } else {
            i6 = 1;
        }
        if (i17 == i6) {
        }
        m7594c();
        this.f12875d -= i6;
        this.f12879h = 7;
        return 7;
    }

    public final void m7596e() throws IOException {
        int iM7595d = this.f12879h;
        if (iM7595d == 0) {
            iM7595d = m7595d();
        }
        if (iM7595d != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + AbstractC2460q.m5503q(m7612u()) + m7601j());
        }
        int i6 = this.f12884m;
        this.f12884m = i6 - 1;
        int[] iArr = this.f12886o;
        int i10 = i6 - 2;
        iArr[i10] = iArr[i10] + 1;
        this.f12879h = 0;
    }

    public final void m7597f() throws IOException {
        int iM7595d = this.f12879h;
        if (iM7595d == 0) {
            iM7595d = m7595d();
        }
        if (iM7595d != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + AbstractC2460q.m5503q(m7612u()) + m7601j());
        }
        int i6 = this.f12884m;
        int i10 = i6 - 1;
        this.f12884m = i10;
        this.f12885n[i10] = null;
        int[] iArr = this.f12886o;
        int i11 = i6 - 2;
        iArr[i11] = iArr[i11] + 1;
        this.f12879h = 0;
    }

    public final boolean m7598g(int i6) throws IOException {
        int i10;
        int i11;
        int i12 = this.f12878g;
        int i13 = this.f12875d;
        this.f12878g = i12 - i13;
        int i14 = this.f12876e;
        char[] cArr = this.f12874c;
        if (i14 != i13) {
            int i15 = i14 - i13;
            this.f12876e = i15;
            System.arraycopy(cArr, i13, cArr, 0, i15);
        } else {
            this.f12876e = 0;
        }
        this.f12875d = 0;
        do {
            int i16 = this.f12876e;
            int i17 = this.f12872a.read(cArr, i16, cArr.length - i16);
            if (i17 == -1) {
                return false;
            }
            i10 = this.f12876e + i17;
            this.f12876e = i10;
            if (this.f12877f == 0 && (i11 = this.f12878g) == 0 && i10 > 0 && cArr[0] == 65279) {
                this.f12875d++;
                this.f12878g = i11 + 1;
                i6++;
            }
        } while (i10 < i6);
        return true;
    }

    public final boolean m7599h() throws IOException {
        int iM7595d = this.f12879h;
        if (iM7595d == 0) {
            iM7595d = m7595d();
        }
        return (iM7595d == 2 || iM7595d == 4) ? false : true;
    }

    public final boolean m7600i(char c5) throws C3814c {
        if (c5 == '\t' || c5 == '\n' || c5 == '\f' || c5 == '\r' || c5 == ' ') {
            return false;
        }
        if (c5 != '#') {
            if (c5 == ',') {
                return false;
            }
            if (c5 != '/' && c5 != '=') {
                if (c5 == '{' || c5 == '}' || c5 == ':') {
                    return false;
                }
                if (c5 != ';') {
                    switch (c5) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        m7594c();
        return false;
    }

    public final String m7601j() {
        StringBuilder sbM28v = AbstractC0004e.m28v(" at line ", this.f12877f + 1, " column ", (this.f12875d - this.f12878g) + 1, " path ");
        StringBuilder sb = new StringBuilder("$");
        int i6 = this.f12884m;
        for (int i10 = 0; i10 < i6; i10++) {
            int i11 = this.f12883l[i10];
            if (i11 == 1 || i11 == 2) {
                sb.append('[');
                sb.append(this.f12886o[i10]);
                sb.append(']');
            } else if (i11 == 3 || i11 == 4 || i11 == 5) {
                sb.append('.');
                String str = this.f12885n[i10];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        sbM28v.append(sb.toString());
        return sbM28v.toString();
    }

    public final boolean m7602k() throws IOException {
        int iM7595d = this.f12879h;
        if (iM7595d == 0) {
            iM7595d = m7595d();
        }
        if (iM7595d == 5) {
            this.f12879h = 0;
            int[] iArr = this.f12886o;
            int i6 = this.f12884m - 1;
            iArr[i6] = iArr[i6] + 1;
            return true;
        }
        if (iM7595d != 6) {
            throw new IllegalStateException("Expected a boolean but was " + AbstractC2460q.m5503q(m7612u()) + m7601j());
        }
        this.f12879h = 0;
        int[] iArr2 = this.f12886o;
        int i10 = this.f12884m - 1;
        iArr2[i10] = iArr2[i10] + 1;
        return false;
    }

    public final double m7603l() throws IOException {
        int iM7595d = this.f12879h;
        if (iM7595d == 0) {
            iM7595d = m7595d();
        }
        if (iM7595d == 15) {
            this.f12879h = 0;
            int[] iArr = this.f12886o;
            int i6 = this.f12884m - 1;
            iArr[i6] = iArr[i6] + 1;
            return this.f12880i;
        }
        if (iM7595d == 16) {
            this.f12882k = new String(this.f12874c, this.f12875d, this.f12881j);
            this.f12875d += this.f12881j;
        } else if (iM7595d == 8 || iM7595d == 9) {
            this.f12882k = m7609r(iM7595d == 8 ? '\'' : '\"');
        } else if (iM7595d == 10) {
            this.f12882k = m7611t();
        } else if (iM7595d != 11) {
            throw new IllegalStateException("Expected a double but was " + AbstractC2460q.m5503q(m7612u()) + m7601j());
        }
        this.f12879h = 11;
        double d = Double.parseDouble(this.f12882k);
        if (!this.f12873b && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new C3814c("JSON forbids NaN and infinities: " + d + m7601j());
        }
        this.f12882k = null;
        this.f12879h = 0;
        int[] iArr2 = this.f12886o;
        int i10 = this.f12884m - 1;
        iArr2[i10] = iArr2[i10] + 1;
        return d;
    }

    public final int m7604m() throws IOException {
        int iM7595d = this.f12879h;
        if (iM7595d == 0) {
            iM7595d = m7595d();
        }
        if (iM7595d == 15) {
            long j10 = this.f12880i;
            int i6 = (int) j10;
            if (j10 != i6) {
                throw new NumberFormatException("Expected an int but was " + this.f12880i + m7601j());
            }
            this.f12879h = 0;
            int[] iArr = this.f12886o;
            int i10 = this.f12884m - 1;
            iArr[i10] = iArr[i10] + 1;
            return i6;
        }
        if (iM7595d == 16) {
            this.f12882k = new String(this.f12874c, this.f12875d, this.f12881j);
            this.f12875d += this.f12881j;
        } else {
            if (iM7595d != 8 && iM7595d != 9 && iM7595d != 10) {
                throw new IllegalStateException("Expected an int but was " + AbstractC2460q.m5503q(m7612u()) + m7601j());
            }
            if (iM7595d == 10) {
                this.f12882k = m7611t();
            } else {
                this.f12882k = m7609r(iM7595d == 8 ? '\'' : '\"');
            }
            try {
                int i11 = Integer.parseInt(this.f12882k);
                this.f12879h = 0;
                int[] iArr2 = this.f12886o;
                int i12 = this.f12884m - 1;
                iArr2[i12] = iArr2[i12] + 1;
                return i11;
            } catch (NumberFormatException unused) {
            }
        }
        this.f12879h = 11;
        double d = Double.parseDouble(this.f12882k);
        int i13 = (int) d;
        if (i13 != d) {
            throw new NumberFormatException("Expected an int but was " + this.f12882k + m7601j());
        }
        this.f12882k = null;
        this.f12879h = 0;
        int[] iArr3 = this.f12886o;
        int i14 = this.f12884m - 1;
        iArr3[i14] = iArr3[i14] + 1;
        return i13;
    }

    public final long m7605n() throws IOException {
        int iM7595d = this.f12879h;
        if (iM7595d == 0) {
            iM7595d = m7595d();
        }
        if (iM7595d == 15) {
            this.f12879h = 0;
            int[] iArr = this.f12886o;
            int i6 = this.f12884m - 1;
            iArr[i6] = iArr[i6] + 1;
            return this.f12880i;
        }
        if (iM7595d == 16) {
            this.f12882k = new String(this.f12874c, this.f12875d, this.f12881j);
            this.f12875d += this.f12881j;
        } else {
            if (iM7595d != 8 && iM7595d != 9 && iM7595d != 10) {
                throw new IllegalStateException("Expected a long but was " + AbstractC2460q.m5503q(m7612u()) + m7601j());
            }
            if (iM7595d == 10) {
                this.f12882k = m7611t();
            } else {
                this.f12882k = m7609r(iM7595d == 8 ? '\'' : '\"');
            }
            try {
                long j10 = Long.parseLong(this.f12882k);
                this.f12879h = 0;
                int[] iArr2 = this.f12886o;
                int i10 = this.f12884m - 1;
                iArr2[i10] = iArr2[i10] + 1;
                return j10;
            } catch (NumberFormatException unused) {
            }
        }
        this.f12879h = 11;
        double d = Double.parseDouble(this.f12882k);
        long j11 = (long) d;
        if (j11 != d) {
            throw new NumberFormatException("Expected a long but was " + this.f12882k + m7601j());
        }
        this.f12882k = null;
        this.f12879h = 0;
        int[] iArr3 = this.f12886o;
        int i11 = this.f12884m - 1;
        iArr3[i11] = iArr3[i11] + 1;
        return j11;
    }

    public final String m7606o() throws IOException {
        String strM7609r;
        int iM7595d = this.f12879h;
        if (iM7595d == 0) {
            iM7595d = m7595d();
        }
        if (iM7595d == 14) {
            strM7609r = m7611t();
        } else if (iM7595d == 12) {
            strM7609r = m7609r('\'');
        } else {
            if (iM7595d != 13) {
                throw new IllegalStateException("Expected a name but was " + AbstractC2460q.m5503q(m7612u()) + m7601j());
            }
            strM7609r = m7609r('\"');
        }
        this.f12879h = 0;
        this.f12885n[this.f12884m - 1] = strM7609r;
        return strM7609r;
    }

    public final int m7607p(boolean z7) throws IOException {
        int i6 = this.f12875d;
        int i10 = this.f12876e;
        while (true) {
            if (i6 == i10) {
                this.f12875d = i6;
                if (!m7598g(1)) {
                    if (!z7) {
                        return -1;
                    }
                    throw new EOFException("End of input" + m7601j());
                }
                i6 = this.f12875d;
                i10 = this.f12876e;
            }
            int i11 = i6 + 1;
            char[] cArr = this.f12874c;
            char c5 = cArr[i6];
            if (c5 == '\n') {
                this.f12877f++;
                this.f12878g = i11;
            } else if (c5 != ' ' && c5 != '\r' && c5 != '\t') {
                if (c5 == '/') {
                    this.f12875d = i11;
                    if (i11 == i10) {
                        this.f12875d = i6;
                        boolean zM7598g = m7598g(2);
                        this.f12875d++;
                        if (!zM7598g) {
                            return c5;
                        }
                    }
                    m7594c();
                    int i12 = this.f12875d;
                    char c8 = cArr[i12];
                    if (c8 == '*') {
                        this.f12875d = i12 + 1;
                        while (true) {
                            if (this.f12875d + 2 > this.f12876e && !m7598g(2)) {
                                m7591A("Unterminated comment");
                                throw null;
                            }
                            int i13 = this.f12875d;
                            if (cArr[i13] != '\n') {
                                int i14 = 0;
                                while (true) {
                                    if (i14 >= 2) {
                                        i6 = this.f12875d + 2;
                                        i10 = this.f12876e;
                                        break;
                                    }
                                    if (cArr[this.f12875d + i14] != "*/".charAt(i14)) {
                                        break;
                                    }
                                    i14++;
                                }
                            } else {
                                this.f12877f++;
                                this.f12878g = i13 + 1;
                            }
                            this.f12875d++;
                        }
                    } else {
                        if (c8 != '/') {
                            return c5;
                        }
                        this.f12875d = i12 + 1;
                        m7616y();
                        i6 = this.f12875d;
                        i10 = this.f12876e;
                    }
                } else {
                    if (c5 != '#') {
                        this.f12875d = i11;
                        return c5;
                    }
                    this.f12875d = i11;
                    m7594c();
                    m7616y();
                    i6 = this.f12875d;
                    i10 = this.f12876e;
                }
            }
            i6 = i11;
        }
    }

    public final void m7608q() throws IOException {
        int iM7595d = this.f12879h;
        if (iM7595d == 0) {
            iM7595d = m7595d();
        }
        if (iM7595d != 7) {
            throw new IllegalStateException("Expected null but was " + AbstractC2460q.m5503q(m7612u()) + m7601j());
        }
        this.f12879h = 0;
        int[] iArr = this.f12886o;
        int i6 = this.f12884m - 1;
        iArr[i6] = iArr[i6] + 1;
    }

    public final String m7609r(char c5) throws C3814c {
        int i6;
        char[] cArr;
        StringBuilder sb = null;
        do {
            int i10 = this.f12875d;
            int i11 = this.f12876e;
            while (true) {
                int i12 = i11;
                i6 = i10;
                while (true) {
                    cArr = this.f12874c;
                    if (i10 < i12) {
                        int i13 = i10 + 1;
                        char c8 = cArr[i10];
                        if (c8 == c5) {
                            this.f12875d = i13;
                            int i14 = (i13 - i6) - 1;
                            if (sb == null) {
                                return new String(cArr, i6, i14);
                            }
                            sb.append(cArr, i6, i14);
                            return sb.toString();
                        }
                        if (c8 == '\\') {
                            this.f12875d = i13;
                            int i15 = i13 - i6;
                            int i16 = i15 - 1;
                            if (sb == null) {
                                sb = new StringBuilder(Math.max(i15 * 2, 16));
                            }
                            sb.append(cArr, i6, i16);
                            sb.append(m7614w());
                            i10 = this.f12875d;
                            i11 = this.f12876e;
                        } else {
                            if (c8 == '\n') {
                                this.f12877f++;
                                this.f12878g = i13;
                            }
                            i10 = i13;
                        }
                    }
                }
            }
            if (sb == null) {
                sb = new StringBuilder(Math.max((i10 - i6) * 2, 16));
            }
            sb.append(cArr, i6, i10 - i6);
            this.f12875d = i10;
        } while (m7598g(1));
        m7591A("Unterminated string");
        throw null;
    }

    public final String m7610s() throws IOException {
        String str;
        int iM7595d = this.f12879h;
        if (iM7595d == 0) {
            iM7595d = m7595d();
        }
        if (iM7595d == 10) {
            str = m7611t();
        } else if (iM7595d == 8) {
            str = m7609r('\'');
        } else if (iM7595d == 9) {
            str = m7609r('\"');
        } else if (iM7595d == 11) {
            str = this.f12882k;
            this.f12882k = null;
        } else if (iM7595d == 15) {
            str = Long.toString(this.f12880i);
        } else {
            if (iM7595d != 16) {
                throw new IllegalStateException("Expected a string but was " + AbstractC2460q.m5503q(m7612u()) + m7601j());
            }
            str = new String(this.f12874c, this.f12875d, this.f12881j);
            this.f12875d += this.f12881j;
        }
        this.f12879h = 0;
        int[] iArr = this.f12886o;
        int i6 = this.f12884m - 1;
        iArr[i6] = iArr[i6] + 1;
        return str;
    }

    public final String m7611t() throws C3814c {
        String string;
        StringBuilder sb = null;
        int i6 = 0;
        while (true) {
            int i10 = 0;
            while (true) {
                int i11 = this.f12875d;
                int i12 = i11 + i10;
                int i13 = this.f12876e;
                char[] cArr = this.f12874c;
                if (i12 < i13) {
                    char c5 = cArr[i11 + i10];
                    if (c5 != '\t' && c5 != '\n' && c5 != '\f' && c5 != '\r' && c5 != ' ') {
                        if (c5 != '#') {
                            if (c5 != ',') {
                                if (c5 != '/' && c5 != '=') {
                                    if (c5 != '{' && c5 != '}' && c5 != ':') {
                                        if (c5 != ';') {
                                            switch (c5) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i10++;
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        m7594c();
                    }
                    i6 = i10;
                } else if (i10 >= cArr.length) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i10, 16));
                    }
                    sb.append(cArr, this.f12875d, i10);
                    this.f12875d += i10;
                    if (!m7598g(1)) {
                    }
                } else if (!m7598g(i10 + 1)) {
                    i6 = i10;
                }
                if (sb == null) {
                    string = new String(cArr, this.f12875d, i6);
                } else {
                    sb.append(cArr, this.f12875d, i6);
                    string = sb.toString();
                }
                this.f12875d += i6;
                return string;
            }
        }
    }

    public final String toString() {
        return C3812a.class.getSimpleName() + m7601j();
    }

    public final int m7612u() throws IOException {
        int iM7595d = this.f12879h;
        if (iM7595d == 0) {
            iM7595d = m7595d();
        }
        switch (iM7595d) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
                return 5;
            case 15:
            case 16:
                return 7;
            case 17:
                return 10;
            default:
                throw new AssertionError();
        }
    }

    public final void m7613v(int i6) {
        int i10 = this.f12884m;
        int[] iArr = this.f12883l;
        if (i10 == iArr.length) {
            int i11 = i10 * 2;
            this.f12883l = Arrays.copyOf(iArr, i11);
            this.f12886o = Arrays.copyOf(this.f12886o, i11);
            this.f12885n = (String[]) Arrays.copyOf(this.f12885n, i11);
        }
        int[] iArr2 = this.f12883l;
        int i12 = this.f12884m;
        this.f12884m = i12 + 1;
        iArr2[i12] = i6;
    }

    public final char m7614w() throws C3814c {
        int i6;
        if (this.f12875d == this.f12876e && !m7598g(1)) {
            m7591A("Unterminated escape sequence");
            throw null;
        }
        int i10 = this.f12875d;
        int i11 = i10 + 1;
        this.f12875d = i11;
        char[] cArr = this.f12874c;
        char c5 = cArr[i10];
        if (c5 == '\n') {
            this.f12877f++;
            this.f12878g = i11;
        } else if (c5 != '\"' && c5 != '\'' && c5 != '/' && c5 != '\\') {
            if (c5 == 'b') {
                return '\b';
            }
            if (c5 == 'f') {
                return '\f';
            }
            if (c5 == 'n') {
                return '\n';
            }
            if (c5 == 'r') {
                return '\r';
            }
            if (c5 == 't') {
                return '\t';
            }
            if (c5 != 'u') {
                m7591A("Invalid escape sequence");
                throw null;
            }
            if (i10 + 5 > this.f12876e && !m7598g(4)) {
                m7591A("Unterminated escape sequence");
                throw null;
            }
            int i12 = this.f12875d;
            int i13 = i12 + 4;
            char c8 = 0;
            while (i12 < i13) {
                char c10 = cArr[i12];
                char c11 = (char) (c8 << 4);
                if (c10 >= '0' && c10 <= '9') {
                    i6 = c10 - '0';
                } else if (c10 >= 'a' && c10 <= 'f') {
                    i6 = c10 - 'W';
                } else {
                    if (c10 < 'A' || c10 > 'F') {
                        throw new NumberFormatException("\\u".concat(new String(cArr, this.f12875d, 4)));
                    }
                    i6 = c10 - '7';
                }
                c8 = (char) (i6 + c11);
                i12++;
            }
            this.f12875d += 4;
            return c8;
        }
        return c5;
    }

    public final void m7615x(char c5) throws C3814c {
        do {
            int i6 = this.f12875d;
            int i10 = this.f12876e;
            while (i6 < i10) {
                int i11 = i6 + 1;
                char c8 = this.f12874c[i6];
                if (c8 == c5) {
                    this.f12875d = i11;
                    return;
                }
                if (c8 == '\\') {
                    this.f12875d = i11;
                    m7614w();
                    i6 = this.f12875d;
                    i10 = this.f12876e;
                } else {
                    if (c8 == '\n') {
                        this.f12877f++;
                        this.f12878g = i11;
                    }
                    i6 = i11;
                }
            }
            this.f12875d = i6;
        } while (m7598g(1));
        m7591A("Unterminated string");
        throw null;
    }

    public final void m7616y() {
        char c5;
        do {
            if (this.f12875d >= this.f12876e && !m7598g(1)) {
                return;
            }
            int i6 = this.f12875d;
            int i10 = i6 + 1;
            this.f12875d = i10;
            c5 = this.f12874c[i6];
            if (c5 == '\n') {
                this.f12877f++;
                this.f12878g = i10;
                return;
            }
        } while (c5 != '\r');
    }

    public final void m7617z() throws IOException {
        int i6 = 0;
        do {
            int iM7595d = this.f12879h;
            if (iM7595d == 0) {
                iM7595d = m7595d();
            }
            if (iM7595d == 3) {
                m7613v(1);
            } else {
                if (iM7595d == 1) {
                    m7613v(3);
                } else if (iM7595d == 4 || iM7595d == 2) {
                    this.f12884m--;
                    i6--;
                } else if (iM7595d == 14 || iM7595d == 10) {
                    while (true) {
                        int i10 = 0;
                        while (true) {
                            int i11 = this.f12875d + i10;
                            if (i11 < this.f12876e) {
                                char c5 = this.f12874c[i11];
                                if (c5 != '\t' && c5 != '\n' && c5 != '\f' && c5 != '\r' && c5 != ' ') {
                                    if (c5 != '#') {
                                        if (c5 != ',') {
                                            if (c5 != '/' && c5 != '=') {
                                                if (c5 != '{' && c5 != '}' && c5 != ':') {
                                                    if (c5 != ';') {
                                                        switch (c5) {
                                                            case '[':
                                                            case ']':
                                                                break;
                                                            case '\\':
                                                                break;
                                                            default:
                                                                i10++;
                                                                break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    m7594c();
                                }
                                this.f12875d += i10;
                            } else {
                                this.f12875d = i11;
                                if (!m7598g(1)) {
                                }
                            }
                        }
                    }
                } else if (iM7595d == 8 || iM7595d == 12) {
                    m7615x('\'');
                } else if (iM7595d == 9 || iM7595d == 13) {
                    m7615x('\"');
                } else if (iM7595d == 16) {
                    this.f12875d += this.f12881j;
                }
                this.f12879h = 0;
            }
            i6++;
            this.f12879h = 0;
        } while (i6 != 0);
        int[] iArr = this.f12886o;
        int i12 = this.f12884m;
        int i13 = i12 - 1;
        iArr[i13] = iArr[i13] + 1;
        this.f12885n[i12 - 1] = "null";
    }
}

package p212t7;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

public class C3813b implements Closeable, Flushable {

    public static final String[] f12887i = new String[128];

    public static final String[] f12888j;

    public final Writer f12889a;

    public int[] f12890b;

    public int f12891c;

    public final String f12892d;

    public boolean f12893e;

    public boolean f12894f;

    public String f12895g;

    public boolean f12896h;

    static {
        for (int i6 = 0; i6 <= 31; i6++) {
            f12887i[i6] = String.format("\\u%04x", Integer.valueOf(i6));
        }
        String[] strArr = f12887i;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f12888j = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public C3813b(Writer writer) {
        int[] iArr = new int[32];
        this.f12890b = iArr;
        this.f12891c = 0;
        if (iArr.length == 0) {
            this.f12890b = Arrays.copyOf(iArr, 0);
        }
        int[] iArr2 = this.f12890b;
        int i6 = this.f12891c;
        this.f12891c = i6 + 1;
        iArr2[i6] = 6;
        this.f12892d = ":";
        this.f12896h = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f12889a = writer;
    }

    public final void m7618a() throws IOException {
        int iM7627j = m7627j();
        if (iM7627j == 1) {
            this.f12890b[this.f12891c - 1] = 2;
            m7625h();
            return;
        }
        Writer writer = this.f12889a;
        if (iM7627j == 2) {
            writer.append(',');
            m7625h();
        } else {
            if (iM7627j == 4) {
                writer.append((CharSequence) this.f12892d);
                this.f12890b[this.f12891c - 1] = 5;
                return;
            }
            if (iM7627j != 6) {
                if (iM7627j != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.f12893e) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            this.f12890b[this.f12891c - 1] = 7;
        }
    }

    public void m7619b() throws IOException {
        m7633p();
        m7618a();
        int i6 = this.f12891c;
        int[] iArr = this.f12890b;
        if (i6 == iArr.length) {
            this.f12890b = Arrays.copyOf(iArr, i6 * 2);
        }
        int[] iArr2 = this.f12890b;
        int i10 = this.f12891c;
        this.f12891c = i10 + 1;
        iArr2[i10] = 1;
        this.f12889a.write(91);
    }

    public void m7620c() throws IOException {
        m7633p();
        m7618a();
        int i6 = this.f12891c;
        int[] iArr = this.f12890b;
        if (i6 == iArr.length) {
            this.f12890b = Arrays.copyOf(iArr, i6 * 2);
        }
        int[] iArr2 = this.f12890b;
        int i10 = this.f12891c;
        this.f12891c = i10 + 1;
        iArr2[i10] = 3;
        this.f12889a.write(123);
    }

    @Override
    public void close() throws IOException {
        this.f12889a.close();
        int i6 = this.f12891c;
        if (i6 > 1 || (i6 == 1 && this.f12890b[i6 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f12891c = 0;
    }

    public final void m7621d(int i6, int i10, char c5) throws IOException {
        int iM7627j = m7627j();
        if (iM7627j != i10 && iM7627j != i6) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f12895g != null) {
            throw new IllegalStateException("Dangling name: " + this.f12895g);
        }
        this.f12891c--;
        if (iM7627j == i10) {
            m7625h();
        }
        this.f12889a.write(c5);
    }

    public void m7622e() throws IOException {
        m7621d(1, 2, ']');
    }

    public void m7623f() throws IOException {
        m7621d(3, 5, '}');
    }

    @Override
    public void flush() throws IOException {
        if (this.f12891c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f12889a.flush();
    }

    public void m7624g(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.f12895g != null) {
            throw new IllegalStateException();
        }
        if (this.f12891c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f12895g = str;
    }

    public C3813b m7626i() throws IOException {
        if (this.f12895g != null) {
            if (!this.f12896h) {
                this.f12895g = null;
                return this;
            }
            m7633p();
        }
        m7618a();
        this.f12889a.write("null");
        return this;
    }

    public final int m7627j() {
        int i6 = this.f12891c;
        if (i6 != 0) {
            return this.f12890b[i6 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void m7628k(String str) throws IOException {
        String str2;
        String[] strArr = this.f12894f ? f12888j : f12887i;
        Writer writer = this.f12889a;
        writer.write(34);
        int length = str.length();
        int i6 = 0;
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i6 < i10) {
                        writer.write(str, i6, i10 - i6);
                    }
                    writer.write(str2);
                    i6 = i10 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i6 < i10) {
                    writer.write(str, i6, i10 - i6);
                }
                writer.write(str2);
                i6 = i10 + 1;
            }
        }
        if (i6 < length) {
            writer.write(str, i6, length - i6);
        }
        writer.write(34);
    }

    public void m7629l(long j10) throws IOException {
        m7633p();
        m7618a();
        this.f12889a.write(Long.toString(j10));
    }

    public void m7630m(Number number) throws IOException {
        if (number == null) {
            m7626i();
            return;
        }
        m7633p();
        String string = number.toString();
        if (this.f12893e || !(string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            m7618a();
            this.f12889a.append((CharSequence) string);
        } else {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
    }

    public void m7631n(String str) throws IOException {
        if (str == null) {
            m7626i();
            return;
        }
        m7633p();
        m7618a();
        m7628k(str);
    }

    public void m7632o(boolean z7) throws IOException {
        m7633p();
        m7618a();
        this.f12889a.write(z7 ? "true" : "false");
    }

    public final void m7633p() throws IOException {
        if (this.f12895g != null) {
            int iM7627j = m7627j();
            if (iM7627j == 5) {
                this.f12889a.write(44);
            } else if (iM7627j != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            m7625h();
            this.f12890b[this.f12891c - 1] = 4;
            m7628k(this.f12895g);
            this.f12895g = null;
        }
    }

    public final void m7625h() {
    }
}

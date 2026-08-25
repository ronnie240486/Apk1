package com.alibaba.fastjson.parser;

import androidx.media3.common.C0565C;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.asm.Opcodes;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import me.jessyan.autosize.BuildConfig;
import p000a.AbstractC0004e;

public abstract class JSONLexerBase implements JSONLexer, Closeable {
    protected static final int INT_MULTMIN_RADIX_TEN = -214748364;
    protected static final long MULTMIN_RADIX_TEN = -922337203685477580L;

    protected int f4395bp;

    protected char f4396ch;
    protected int eofPos;
    protected int features;
    protected boolean hasSpecial;

    protected int f4397np;
    protected int pos;
    protected char[] sbuf;

    protected int f4398sp;
    protected String stringDefaultValue;
    protected int token;
    private static final ThreadLocal<char[]> SBUF_LOCAL = new ThreadLocal<>();
    protected static final char[] typeFieldName = ("\"" + JSON.DEFAULT_TYPE_KEY + "\":\"").toCharArray();
    protected static final int[] digits = new int[103];
    protected Calendar calendar = null;
    protected TimeZone timeZone = JSON.defaultTimeZone;
    protected Locale locale = JSON.defaultLocale;
    public int matchStat = 0;
    protected int nanos = 0;

    static {
        for (int i6 = 48; i6 <= 57; i6++) {
            digits[i6] = i6 - 48;
        }
        for (int i10 = 97; i10 <= 102; i10++) {
            digits[i10] = i10 - 87;
        }
        for (int i11 = 65; i11 <= 70; i11++) {
            digits[i11] = i11 - 55;
        }
    }

    public JSONLexerBase(int i6) {
        this.stringDefaultValue = null;
        this.features = i6;
        if ((i6 & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
        char[] cArr = SBUF_LOCAL.get();
        this.sbuf = cArr;
        if (cArr == null) {
            this.sbuf = new char[512];
        }
    }

    public static boolean isWhitespace(char c5) {
        return c5 <= ' ' && (c5 == ' ' || c5 == '\n' || c5 == '\r' || c5 == '\t' || c5 == '\f' || c5 == '\b');
    }

    public static String readString(char[] cArr, int i6) {
        int i10;
        int i11;
        int i12 = 5;
        char[] cArr2 = new char[i6];
        int i13 = 0;
        int i14 = 0;
        while (i13 < i6) {
            char c5 = cArr[i13];
            if (c5 != '\\') {
                cArr2[i14] = c5;
                i14++;
            } else {
                int i15 = i13 + 1;
                char c8 = cArr[i15];
                if (c8 == '\"') {
                    i10 = i14 + 1;
                    cArr2[i14] = '\"';
                } else if (c8 != '\'') {
                    if (c8 == 'F') {
                        i10 = i14 + 1;
                        cArr2[i14] = '\f';
                    } else if (c8 == '\\') {
                        i10 = i14 + 1;
                        cArr2[i14] = '\\';
                    } else if (c8 == 'b') {
                        i10 = i14 + 1;
                        cArr2[i14] = '\b';
                    } else if (c8 == 'f') {
                        i10 = i14 + 1;
                        cArr2[i14] = '\f';
                    } else if (c8 == 'n') {
                        i10 = i14 + 1;
                        cArr2[i14] = '\n';
                    } else if (c8 == 'r') {
                        i10 = i14 + 1;
                        cArr2[i14] = '\r';
                    } else if (c8 != 'x') {
                        switch (c8) {
                            case '/':
                                i10 = i14 + 1;
                                cArr2[i14] = '/';
                                break;
                            case NalUnitUtil.H265_NAL_UNIT_TYPE_UNSPECIFIED:
                                i10 = i14 + 1;
                                cArr2[i14] = 0;
                                break;
                            case Opcodes.V1_5:
                                i10 = i14 + 1;
                                cArr2[i14] = 1;
                                break;
                            case DefaultRenderersFactory.MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY:
                                i10 = i14 + 1;
                                cArr2[i14] = 2;
                                break;
                            case '3':
                                i10 = i14 + 1;
                                cArr2[i14] = 3;
                                break;
                            case '4':
                                i10 = i14 + 1;
                                cArr2[i14] = 4;
                                break;
                            case '5':
                                i10 = i14 + 1;
                                cArr2[i14] = 5;
                                break;
                            case Opcodes.ISTORE:
                                i11 = i14 + 1;
                                cArr2[i14] = 6;
                                i14 = i11;
                                i13 = i15;
                                break;
                            case Opcodes.LSTORE:
                                i11 = i14 + 1;
                                cArr2[i14] = 7;
                                i14 = i11;
                                i13 = i15;
                                break;
                            default:
                                switch (c8) {
                                    case AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID:
                                        i11 = i14 + 1;
                                        cArr2[i14] = '\t';
                                        i14 = i11;
                                        i13 = i15;
                                        break;
                                    case 'u':
                                        char c10 = cArr[i13 + 2];
                                        char c11 = cArr[i13 + 3];
                                        char c12 = cArr[i13 + 4];
                                        i13 += i12;
                                        cArr2[i14] = (char) Integer.parseInt(new String(new char[]{c10, c11, c12, cArr[i13]}), 16);
                                        i14++;
                                        break;
                                    case 'v':
                                        cArr2[i14] = 11;
                                        i14++;
                                        i13 = i15;
                                        break;
                                    default:
                                        throw new JSONException("unclosed.str.lit");
                                }
                                break;
                        }
                    } else {
                        int[] iArr = digits;
                        int i16 = iArr[cArr[i13 + 2]] * 16;
                        i13 += 3;
                        cArr2[i14] = (char) (i16 + iArr[cArr[i13]]);
                        i14++;
                    }
                    i13++;
                    i12 = 5;
                } else {
                    i10 = i14 + 1;
                    cArr2[i14] = '\'';
                }
                i14 = i10;
                i13 = i15;
                i13++;
                i12 = 5;
            }
            i13++;
            i12 = 5;
        }
        return new String(cArr2, 0, i14);
    }

    private void scanStringSingleQuote() {
        this.f4397np = this.f4395bp;
        this.hasSpecial = false;
        while (true) {
            char next = next();
            if (next == '\'') {
                this.token = 4;
                next();
                return;
            }
            if (next == 26) {
                if (isEOF()) {
                    throw new JSONException("unclosed single-quote string");
                }
                putChar(JSONLexer.EOI);
            } else if (next == '\\') {
                if (!this.hasSpecial) {
                    this.hasSpecial = true;
                    int i6 = this.f4398sp;
                    char[] cArr = this.sbuf;
                    if (i6 > cArr.length) {
                        char[] cArr2 = new char[i6 * 2];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.sbuf = cArr2;
                    }
                    copyTo(this.f4397np + 1, this.f4398sp, this.sbuf);
                }
                char next2 = next();
                if (next2 == '\"') {
                    putChar('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            putChar('\\');
                        } else if (next2 == 'b') {
                            putChar('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                putChar('\n');
                            } else if (next2 == 'r') {
                                putChar('\r');
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        putChar('/');
                                        break;
                                    case NalUnitUtil.H265_NAL_UNIT_TYPE_UNSPECIFIED:
                                        putChar((char) 0);
                                        break;
                                    case Opcodes.V1_5:
                                        putChar((char) 1);
                                        break;
                                    case DefaultRenderersFactory.MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY:
                                        putChar((char) 2);
                                        break;
                                    case '3':
                                        putChar((char) 3);
                                        break;
                                    case '4':
                                        putChar((char) 4);
                                        break;
                                    case '5':
                                        putChar((char) 5);
                                        break;
                                    case Opcodes.ISTORE:
                                        putChar((char) 6);
                                        break;
                                    case Opcodes.LSTORE:
                                        putChar((char) 7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID:
                                                putChar('\t');
                                                break;
                                            case 'u':
                                                putChar((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                break;
                                            case 'v':
                                                putChar((char) 11);
                                                break;
                                            default:
                                                this.f4396ch = next2;
                                                throw new JSONException("unclosed single-quote string");
                                        }
                                        break;
                                }
                            } else {
                                char next3 = next();
                                char next4 = next();
                                boolean z7 = (next3 >= '0' && next3 <= '9') || (next3 >= 'a' && next3 <= 'f') || (next3 >= 'A' && next3 <= 'F');
                                boolean z10 = (next4 >= '0' && next4 <= '9') || (next4 >= 'a' && next4 <= 'f') || (next4 >= 'A' && next4 <= 'F');
                                if (!z7 || !z10) {
                                    throw new JSONException("invalid escape character \\x" + next3 + next4);
                                }
                                int[] iArr = digits;
                                putChar((char) ((iArr[next3] * 16) + iArr[next4]));
                            }
                        }
                    }
                    putChar('\f');
                } else {
                    putChar('\'');
                }
            } else if (this.hasSpecial) {
                int i10 = this.f4398sp;
                char[] cArr3 = this.sbuf;
                if (i10 == cArr3.length) {
                    putChar(next);
                } else {
                    this.f4398sp = i10 + 1;
                    cArr3[i10] = next;
                }
            } else {
                this.f4398sp++;
            }
        }
    }

    public abstract String addSymbol(int i6, int i10, int i11, SymbolTable symbolTable);

    public abstract void arrayCopy(int i6, char[] cArr, int i10, int i11);

    @Override
    public abstract byte[] bytesValue();

    public abstract boolean charArrayCompare(char[] cArr);

    public abstract char charAt(int i6);

    @Override
    public void close() {
        char[] cArr = this.sbuf;
        if (cArr.length <= 8192) {
            SBUF_LOCAL.set(cArr);
        }
        this.sbuf = null;
    }

    @Override
    public void config(Feature feature, boolean z7) {
        int iConfig = Feature.config(this.features, feature, z7);
        this.features = iConfig;
        if ((iConfig & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
    }

    public abstract void copyTo(int i6, int i10, char[] cArr);

    @Override
    public final Number decimalValue(boolean z7) {
        char cCharAt = charAt((this.f4397np + this.f4398sp) - 1);
        try {
            if (cCharAt == 'F') {
                return Float.valueOf(Float.parseFloat(numberString()));
            }
            if (cCharAt == 'D') {
                return Double.valueOf(Double.parseDouble(numberString()));
            }
            return z7 ? decimalValue() : Double.valueOf(doubleValue());
        } catch (NumberFormatException e5) {
            throw new JSONException(e5.getMessage() + ", " + info());
        }
    }

    @Override
    public abstract BigDecimal decimalValue();

    public double doubleValue() {
        return Double.parseDouble(numberString());
    }

    @Override
    public float floatValue() {
        char cCharAt;
        String strNumberString = numberString();
        float f = Float.parseFloat(strNumberString);
        if ((f == 0.0f || f == Float.POSITIVE_INFINITY) && (cCharAt = strNumberString.charAt(0)) > '0' && cCharAt <= '9') {
            throw new JSONException("float overflow : ".concat(strNumberString));
        }
        return f;
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    @Override
    public final char getCurrent() {
        return this.f4396ch;
    }

    @Override
    public int getFeatures() {
        return this.features;
    }

    @Override
    public Locale getLocale() {
        return this.locale;
    }

    @Override
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public abstract int indexOf(char c5, int i6);

    @Override
    public String info() {
        return "";
    }

    @Override
    public final int intValue() {
        int i6;
        boolean z7;
        int i10 = 0;
        if (this.f4397np == -1) {
            this.f4397np = 0;
        }
        int i11 = this.f4397np;
        int i12 = this.f4398sp + i11;
        if (charAt(i11) == '-') {
            i11++;
            i6 = Integer.MIN_VALUE;
            z7 = true;
        } else {
            i6 = C0565C.RATE_UNSET_INT;
            z7 = false;
        }
        if (i11 < i12) {
            i10 = -(charAt(i11) - '0');
            i11++;
        }
        while (i11 < i12) {
            int i13 = i11 + 1;
            char cCharAt = charAt(i11);
            if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B') {
                i11 = i13;
                break;
            }
            int i14 = cCharAt - '0';
            if (i10 < -214748364) {
                throw new NumberFormatException(numberString());
            }
            int i15 = i10 * 10;
            if (i15 < i6 + i14) {
                throw new NumberFormatException(numberString());
            }
            i10 = i15 - i14;
            i11 = i13;
        }
        if (!z7) {
            return -i10;
        }
        if (i11 > this.f4397np + 1) {
            return i10;
        }
        throw new NumberFormatException(numberString());
    }

    @Override
    public final Number integerValue() throws NumberFormatException {
        char c5;
        long j10;
        long j11;
        boolean z7 = false;
        if (this.f4397np == -1) {
            this.f4397np = 0;
        }
        int i6 = this.f4397np;
        int i10 = this.f4398sp + i6;
        char cCharAt = charAt(i10 - 1);
        if (cCharAt == 'B') {
            i10--;
            c5 = 'B';
        } else if (cCharAt == 'L') {
            i10--;
            c5 = 'L';
        } else if (cCharAt != 'S') {
            c5 = ' ';
        } else {
            i10--;
            c5 = 'S';
        }
        if (charAt(this.f4397np) == '-') {
            i6++;
            j10 = Long.MIN_VALUE;
            z7 = true;
        } else {
            j10 = C0565C.TIME_UNSET;
        }
        if (i6 < i10) {
            j11 = -(charAt(i6) - '0');
            i6++;
        } else {
            j11 = 0;
        }
        while (i6 < i10) {
            int i11 = i6 + 1;
            int iCharAt = charAt(i6) - '0';
            if (j11 < -922337203685477580L) {
                return new BigInteger(numberString(), 10);
            }
            long j12 = j11 * 10;
            long j13 = iCharAt;
            if (j12 < j10 + j13) {
                return new BigInteger(numberString(), 10);
            }
            j11 = j12 - j13;
            i6 = i11;
        }
        if (!z7) {
            long j14 = -j11;
            if (j14 > 2147483647L || c5 == 'L') {
                return Long.valueOf(j14);
            }
            if (c5 == 'S') {
                return Short.valueOf((short) j14);
            }
            return c5 == 'B' ? Byte.valueOf((byte) j14) : Integer.valueOf((int) j14);
        }
        if (i6 <= this.f4397np + 1) {
            throw new JSONException("illegal number format : " + numberString());
        }
        if (j11 < -2147483648L || c5 == 'L') {
            return Long.valueOf(j11);
        }
        if (c5 == 'S') {
            return Short.valueOf((short) j11);
        }
        return c5 == 'B' ? Byte.valueOf((byte) j11) : Integer.valueOf((int) j11);
    }

    @Override
    public boolean isBlankInput() {
        int i6 = 0;
        while (true) {
            char cCharAt = charAt(i6);
            if (cCharAt == 26) {
                this.token = 20;
                return true;
            }
            if (!isWhitespace(cCharAt)) {
                return false;
            }
            i6++;
        }
    }

    public abstract boolean isEOF();

    @Override
    public final boolean isEnabled(Feature feature) {
        return isEnabled(feature.mask);
    }

    @Override
    public final boolean isRef() {
        return this.f4398sp == 4 && charAt(this.f4397np + 1) == '$' && charAt(this.f4397np + 2) == 'r' && charAt(this.f4397np + 3) == 'e' && charAt(this.f4397np + 4) == 'f';
    }

    public void lexError(String str, Object... objArr) {
        this.token = 1;
    }

    @Override
    public final long longValue() throws NumberFormatException {
        long j10;
        long j11;
        int i6;
        char cCharAt;
        boolean z7 = false;
        if (this.f4397np == -1) {
            this.f4397np = 0;
        }
        int i10 = this.f4397np;
        int i11 = this.f4398sp + i10;
        if (charAt(i10) == '-') {
            i10++;
            j10 = Long.MIN_VALUE;
            z7 = true;
        } else {
            j10 = C0565C.TIME_UNSET;
        }
        if (i10 >= i11) {
            j11 = 0;
            if (i10 < i11) {
                i6 = i10 + 1;
                cCharAt = charAt(i10);
                if (cCharAt != 'L' || cCharAt == 'S' || cCharAt == 'B') {
                    i10 = i6;
                } else {
                    int i12 = cCharAt - '0';
                    if (j11 < -922337203685477580L) {
                        throw new NumberFormatException(numberString());
                    }
                    long j12 = j11 * 10;
                    long j13 = i12;
                    if (j12 < j10 + j13) {
                        throw new NumberFormatException(numberString());
                    }
                    j11 = j12 - j13;
                }
            }
            if (z7) {
                return -j11;
            }
            if (i10 > this.f4397np + 1) {
                return j11;
            }
            throw new NumberFormatException(numberString());
        }
        i6 = i10 + 1;
        j11 = -(charAt(i10) - '0');
        i10 = i6;
        if (i10 < i11) {
            i6 = i10 + 1;
            cCharAt = charAt(i10);
            if (cCharAt != 'L') {
            }
            i10 = i6;
        }
        if (z7) {
            return -j11;
        }
        if (i10 > this.f4397np + 1) {
            return j11;
        }
        throw new NumberFormatException(numberString());
    }

    public final boolean matchField(char[] cArr) {
        while (!charArrayCompare(cArr)) {
            if (!isWhitespace(this.f4396ch)) {
                return false;
            }
            next();
        }
        int length = this.f4395bp + cArr.length;
        this.f4395bp = length;
        char cCharAt = charAt(length);
        this.f4396ch = cCharAt;
        if (cCharAt == '{') {
            next();
            this.token = 12;
        } else if (cCharAt == '[') {
            next();
            this.token = 14;
        } else if (cCharAt == 'S' && charAt(this.f4395bp + 1) == 'e' && charAt(this.f4395bp + 2) == 't' && charAt(this.f4395bp + 3) == '[') {
            int i6 = this.f4395bp + 3;
            this.f4395bp = i6;
            this.f4396ch = charAt(i6);
            this.token = 21;
        } else {
            nextToken();
        }
        return true;
    }

    public boolean matchField2(char[] cArr) {
        throw new UnsupportedOperationException();
    }

    public final int matchStat() {
        return this.matchStat;
    }

    public Collection<String> newCollectionByType(Class<?> cls) {
        if (cls.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (cls.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        if (cls.isAssignableFrom(LinkedList.class)) {
            return new LinkedList();
        }
        try {
            return (Collection) cls.newInstance();
        } catch (Exception e5) {
            throw new JSONException(e5.getMessage(), e5);
        }
    }

    @Override
    public abstract char next();

    public final void nextIdent() {
        while (isWhitespace(this.f4396ch)) {
            next();
        }
        char c5 = this.f4396ch;
        if (c5 == '_' || c5 == '$' || Character.isLetter(c5)) {
            scanIdent();
        } else {
            nextToken();
        }
    }

    @Override
    public final void nextToken() {
        this.f4398sp = 0;
        while (true) {
            this.pos = this.f4395bp;
            char c5 = this.f4396ch;
            if (c5 == '/') {
                skipComment();
            } else {
                if (c5 == '\"') {
                    scanString();
                    return;
                }
                if (c5 == ',') {
                    next();
                    this.token = 16;
                    return;
                }
                if (c5 >= '0' && c5 <= '9') {
                    scanNumber();
                    return;
                }
                if (c5 == '-') {
                    scanNumber();
                    return;
                }
                switch (c5) {
                    case '\b':
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                        next();
                        break;
                    case NalUnitUtil.H265_NAL_UNIT_TYPE_PREFIX_SEI:
                        if (!isEnabled(Feature.AllowSingleQuotes)) {
                            throw new JSONException("Feature.AllowSingleQuotes is false");
                        }
                        scanStringSingleQuote();
                        return;
                    case NalUnitUtil.H265_NAL_UNIT_TYPE_SUFFIX_SEI:
                        next();
                        this.token = 10;
                        return;
                    case BuildConfig.VERSION_CODE:
                        next();
                        this.token = 11;
                        return;
                    case '+':
                        next();
                        scanNumber();
                        return;
                    case '.':
                        next();
                        this.token = 25;
                        return;
                    case Opcodes.ASTORE:
                        next();
                        this.token = 17;
                        return;
                    case ';':
                        next();
                        this.token = 24;
                        return;
                    case MdtaMetadataEntry.TYPE_INDICATOR_UNSIGNED_INT64:
                    case 'S':
                    case 'T':
                    case 'u':
                        scanIdent();
                        return;
                    case '[':
                        next();
                        this.token = 14;
                        return;
                    case ']':
                        next();
                        this.token = 15;
                        return;
                    case 'f':
                        scanFalse();
                        return;
                    case 'n':
                        scanNullOrNew();
                        return;
                    case AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID:
                        scanTrue();
                        return;
                    case 'x':
                        scanHex();
                        return;
                    case '{':
                        next();
                        this.token = 12;
                        return;
                    case '}':
                        next();
                        this.token = 13;
                        return;
                    default:
                        if (isEOF()) {
                            if (this.token == 20) {
                                throw new JSONException("EOF error");
                            }
                            this.token = 20;
                            int i6 = this.f4395bp;
                            this.pos = i6;
                            this.eofPos = i6;
                            return;
                        }
                        char c8 = this.f4396ch;
                        if (c8 > 31 && c8 != 127) {
                            lexError("illegal.char", String.valueOf((int) c8));
                            next();
                            return;
                        }
                        next();
                        break;
                        break;
                }
            }
        }
    }

    public final void nextTokenWithChar(char c5) {
        this.f4398sp = 0;
        while (true) {
            char c8 = this.f4396ch;
            if (c8 == c5) {
                next();
                nextToken();
                return;
            }
            if (c8 != ' ' && c8 != '\n' && c8 != '\r' && c8 != '\t' && c8 != '\f' && c8 != '\b') {
                throw new JSONException("not match " + c5 + " - " + this.f4396ch + ", info : " + info());
            }
            next();
        }
    }

    @Override
    public final void nextTokenWithColon() {
        nextTokenWithChar(':');
    }

    @Override
    public abstract String numberString();

    @Override
    public final int pos() {
        return this.pos;
    }

    public final void putChar(char c5) {
        int i6 = this.f4398sp;
        char[] cArr = this.sbuf;
        if (i6 >= cArr.length) {
            int length = cArr.length * 2;
            if (length < i6) {
                length = i6 + 1;
            }
            char[] cArr2 = new char[length];
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            this.sbuf = cArr2;
        }
        char[] cArr3 = this.sbuf;
        int i10 = this.f4398sp;
        this.f4398sp = i10 + 1;
        cArr3[i10] = c5;
    }

    @Override
    public final void resetStringPosition() {
        this.f4398sp = 0;
    }

    @Override
    public boolean scanBoolean(char c5) {
        boolean z7 = false;
        this.matchStat = 0;
        char cCharAt = charAt(this.f4395bp);
        int i6 = 5;
        if (cCharAt == 't') {
            if (charAt(this.f4395bp + 1) != 'r' || charAt(this.f4395bp + 2) != 'u' || charAt(this.f4395bp + 3) != 'e') {
                this.matchStat = -1;
                return false;
            }
            cCharAt = charAt(this.f4395bp + 4);
            z7 = true;
        } else if (cCharAt != 'f') {
            if (cCharAt == '1') {
                cCharAt = charAt(this.f4395bp + 1);
                z7 = true;
            } else if (cCharAt == '0') {
                cCharAt = charAt(this.f4395bp + 1);
            } else {
                i6 = 1;
            }
            i6 = 2;
        } else {
            if (charAt(this.f4395bp + 1) != 'a' || charAt(this.f4395bp + 2) != 'l' || charAt(this.f4395bp + 3) != 's' || charAt(this.f4395bp + 4) != 'e') {
                this.matchStat = -1;
                return false;
            }
            cCharAt = charAt(this.f4395bp + 5);
            i6 = 6;
        }
        while (cCharAt != c5) {
            if (!isWhitespace(cCharAt)) {
                this.matchStat = -1;
                return z7;
            }
            cCharAt = charAt(this.f4395bp + i6);
            i6++;
        }
        int i10 = this.f4395bp + i6;
        this.f4395bp = i10;
        this.f4396ch = charAt(i10);
        this.matchStat = 3;
        return z7;
    }

    public Date scanDate(char c5) {
        long j10;
        char cCharAt;
        int i6;
        Date date;
        int i10;
        char cCharAt2;
        boolean z7 = false;
        this.matchStat = 0;
        char cCharAt3 = charAt(this.f4395bp);
        int i11 = 1;
        if (cCharAt3 == '\"') {
            int iIndexOf = indexOf('\"', this.f4395bp + 1);
            if (iIndexOf == -1) {
                throw new JSONException("unclosed str");
            }
            int i12 = this.f4395bp + 1;
            String strSubString = subString(i12, iIndexOf - i12);
            if (strSubString.indexOf(92) != -1) {
                while (true) {
                    int i13 = 0;
                    for (int i14 = iIndexOf - 1; i14 >= 0 && charAt(i14) == '\\'; i14--) {
                        i13++;
                    }
                    if (i13 % 2 == 0) {
                        break;
                    }
                    iIndexOf = indexOf('\"', iIndexOf + 1);
                }
                int i15 = this.f4395bp;
                int i16 = iIndexOf - (i15 + 1);
                strSubString = readString(sub_chars(i15 + 1, i16), i16);
            }
            int i17 = this.f4395bp;
            int i18 = iIndexOf - (i17 + 1);
            int i19 = i18 + 2;
            i6 = i18 + 3;
            cCharAt = charAt(i17 + i19);
            JSONScanner jSONScanner = new JSONScanner(strSubString);
            try {
                if (!jSONScanner.scanISO8601DateIfMatch(false)) {
                    this.matchStat = -1;
                    jSONScanner.close();
                    return null;
                }
                date = jSONScanner.getCalendar().getTime();
                jSONScanner.close();
            } catch (Throwable th) {
                jSONScanner.close();
                throw th;
            }
        } else {
            char c8 = '9';
            if (cCharAt3 == '-' || (cCharAt3 >= '0' && cCharAt3 <= '9')) {
                if (cCharAt3 == '-') {
                    cCharAt3 = charAt(this.f4395bp + 1);
                    z7 = true;
                    i11 = 2;
                }
                if (cCharAt3 < '0' || cCharAt3 > '9') {
                    j10 = 0;
                    int i20 = i11;
                    cCharAt = cCharAt3;
                    i6 = i20;
                } else {
                    j10 = cCharAt3 - '0';
                    while (true) {
                        i10 = i11 + 1;
                        cCharAt2 = charAt(this.f4395bp + i11);
                        if (cCharAt2 < '0' || cCharAt2 > c8) {
                            break;
                        }
                        j10 = (j10 * 10) + ((long) (cCharAt2 - '0'));
                        i11 = i10;
                        c8 = '9';
                    }
                    cCharAt = cCharAt2;
                    i6 = i10;
                }
                if (j10 < 0) {
                    this.matchStat = -1;
                    return null;
                }
                if (z7) {
                    j10 = -j10;
                }
                date = new Date(j10);
            } else {
                if (cCharAt3 != 'n' || charAt(this.f4395bp + 1) != 'u' || charAt(this.f4395bp + 2) != 'l' || charAt(this.f4395bp + 3) != 'l') {
                    this.matchStat = -1;
                    return null;
                }
                i6 = 5;
                this.matchStat = 5;
                cCharAt = charAt(this.f4395bp + 4);
                date = null;
            }
        }
        if (cCharAt == ',') {
            int i21 = this.f4395bp + i6;
            this.f4395bp = i21;
            this.f4396ch = charAt(i21);
            this.matchStat = 3;
            this.token = 16;
            return date;
        }
        if (cCharAt != ']') {
            this.matchStat = -1;
            return null;
        }
        int i22 = i6 + 1;
        char cCharAt4 = charAt(this.f4395bp + i6);
        if (cCharAt4 == ',') {
            this.token = 16;
            int i23 = this.f4395bp + i22;
            this.f4395bp = i23;
            this.f4396ch = charAt(i23);
        } else if (cCharAt4 == ']') {
            this.token = 15;
            int i24 = this.f4395bp + i22;
            this.f4395bp = i24;
            this.f4396ch = charAt(i24);
        } else if (cCharAt4 == '}') {
            this.token = 13;
            int i25 = this.f4395bp + i22;
            this.f4395bp = i25;
            this.f4396ch = charAt(i25);
        } else {
            if (cCharAt4 != 26) {
                this.matchStat = -1;
                return null;
            }
            this.token = 20;
            this.f4395bp += i6;
            this.f4396ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return date;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override
    public java.math.BigDecimal scanDecimal(char r18) {
        /*
            Method dump skipped, instruction units count: 461
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanDecimal(char):java.math.BigDecimal");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override
    public double scanDouble(char r22) {
        /*
            Method dump skipped, instruction units count: 431
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanDouble(char):double");
    }

    @Override
    public Enum<?> scanEnum(Class<?> cls, SymbolTable symbolTable, char c5) {
        String strScanSymbolWithSeperator = scanSymbolWithSeperator(symbolTable, c5);
        if (strScanSymbolWithSeperator == null) {
            return null;
        }
        return Enum.valueOf(cls, strScanSymbolWithSeperator);
    }

    public long scanEnumSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i6 = length + 1;
        if (charAt(this.f4395bp + length) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j10 = TypeUtils.fnv1a_64_magic_hashcode;
        while (true) {
            int i10 = i6 + 1;
            char cCharAt = charAt(this.f4395bp + i6);
            if (cCharAt == '\"') {
                int i11 = i6 + 2;
                char cCharAt2 = charAt(this.f4395bp + i10);
                if (cCharAt2 == ',') {
                    int i12 = this.f4395bp + i11;
                    this.f4395bp = i12;
                    this.f4396ch = charAt(i12);
                    this.matchStat = 3;
                    return j10;
                }
                if (cCharAt2 != '}') {
                    this.matchStat = -1;
                    return 0L;
                }
                int i13 = i6 + 3;
                char cCharAt3 = charAt(this.f4395bp + i11);
                if (cCharAt3 == ',') {
                    this.token = 16;
                    int i14 = this.f4395bp + i13;
                    this.f4395bp = i14;
                    this.f4396ch = charAt(i14);
                } else if (cCharAt3 == ']') {
                    this.token = 15;
                    int i15 = this.f4395bp + i13;
                    this.f4395bp = i15;
                    this.f4396ch = charAt(i15);
                } else if (cCharAt3 == '}') {
                    this.token = 13;
                    int i16 = this.f4395bp + i13;
                    this.f4395bp = i16;
                    this.f4396ch = charAt(i16);
                } else {
                    if (cCharAt3 != 26) {
                        this.matchStat = -1;
                        return 0L;
                    }
                    this.token = 20;
                    this.f4395bp = i6 + 2 + this.f4395bp;
                    this.f4396ch = JSONLexer.EOI;
                }
                this.matchStat = 4;
                return j10;
            }
            j10 = (j10 ^ ((long) ((cCharAt < 'A' || cCharAt > 'Z') ? cCharAt : cCharAt + ' '))) * TypeUtils.fnv1a_64_magic_prime;
            if (cCharAt == '\\') {
                this.matchStat = -1;
                return 0L;
            }
            i6 = i10;
        }
    }

    public final void scanFalse() {
        if (this.f4396ch != 'f') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.f4396ch != 'a') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.f4396ch != 'l') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.f4396ch != 's') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.f4396ch != 'e') {
            throw new JSONException("error parse false");
        }
        next();
        char c5 = this.f4396ch;
        if (c5 != ' ' && c5 != ',' && c5 != '}' && c5 != ']' && c5 != '\n' && c5 != '\r' && c5 != '\t' && c5 != 26 && c5 != '\f' && c5 != '\b' && c5 != ':' && c5 != '/') {
            throw new JSONException("scan false error");
        }
        this.token = 7;
    }

    public BigInteger scanFieldBigInteger(char[] cArr) {
        int i6;
        char cCharAt;
        boolean z7;
        int length;
        int iM13g;
        BigInteger bigInteger;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length2 = cArr.length;
        int i10 = length2 + 1;
        char cCharAt2 = charAt(this.f4395bp + length2);
        boolean z10 = cCharAt2 == '\"';
        if (z10) {
            cCharAt2 = charAt(this.f4395bp + i10);
            i10 = length2 + 2;
        }
        boolean z11 = cCharAt2 == '-';
        if (z11) {
            cCharAt2 = charAt(this.f4395bp + i10);
            i10++;
        }
        if (cCharAt2 >= '0') {
            char c5 = '9';
            if (cCharAt2 <= '9') {
                long j10 = cCharAt2 - '0';
                while (true) {
                    i6 = i10 + 1;
                    cCharAt = charAt(this.f4395bp + i10);
                    if (cCharAt < '0' || cCharAt > c5) {
                        z7 = false;
                        break;
                    }
                    long j11 = (10 * j10) + ((long) (cCharAt - '0'));
                    if (j11 < j10) {
                        z7 = true;
                        break;
                    }
                    j10 = j11;
                    i10 = i6;
                    c5 = '9';
                }
                if (!z10) {
                    int i11 = this.f4395bp;
                    length = cArr.length + i11;
                    iM13g = AbstractC0004e.m13g(i11, i6, length, 1);
                } else {
                    if (cCharAt != '\"') {
                        this.matchStat = -1;
                        return null;
                    }
                    int i12 = i10 + 2;
                    cCharAt = charAt(this.f4395bp + i6);
                    int i13 = this.f4395bp;
                    length = cArr.length + i13 + 1;
                    iM13g = AbstractC0004e.m13g(i13, i12, length, 2);
                    i6 = i12;
                }
                if (!z7 && (iM13g < 20 || (z11 && iM13g < 21))) {
                    if (z11) {
                        j10 = -j10;
                    }
                    bigInteger = BigInteger.valueOf(j10);
                } else {
                    if (iM13g > 65535) {
                        throw new JSONException("scanInteger overflow");
                    }
                    bigInteger = new BigInteger(subString(length, iM13g), 10);
                }
                if (cCharAt == ',') {
                    int i14 = this.f4395bp + i6;
                    this.f4395bp = i14;
                    this.f4396ch = charAt(i14);
                    this.matchStat = 3;
                    this.token = 16;
                    return bigInteger;
                }
                if (cCharAt != '}') {
                    this.matchStat = -1;
                    return null;
                }
                int i15 = i6 + 1;
                char cCharAt3 = charAt(this.f4395bp + i6);
                if (cCharAt3 == ',') {
                    this.token = 16;
                    int i16 = this.f4395bp + i15;
                    this.f4395bp = i16;
                    this.f4396ch = charAt(i16);
                } else if (cCharAt3 == ']') {
                    this.token = 15;
                    int i17 = this.f4395bp + i15;
                    this.f4395bp = i17;
                    this.f4396ch = charAt(i17);
                } else if (cCharAt3 == '}') {
                    this.token = 13;
                    int i18 = this.f4395bp + i15;
                    this.f4395bp = i18;
                    this.f4396ch = charAt(i18);
                } else {
                    if (cCharAt3 != 26) {
                        this.matchStat = -1;
                        return null;
                    }
                    this.token = 20;
                    this.f4395bp += i6;
                    this.f4396ch = JSONLexer.EOI;
                }
                this.matchStat = 4;
                return bigInteger;
            }
        }
        if (cCharAt2 != 'n' || charAt(this.f4395bp + i10) != 'u' || AbstractC0004e.m10d(this.f4395bp, i10, 1, this) != 'l' || AbstractC0004e.m10d(this.f4395bp, i10, 2, this) != 'l') {
            this.matchStat = -1;
            return null;
        }
        this.matchStat = 5;
        int i19 = i10 + 4;
        char cCharAt4 = charAt(this.f4395bp + i10 + 3);
        if (z10 && cCharAt4 == '\"') {
            cCharAt4 = charAt(this.f4395bp + i19);
            i19 = i10 + 5;
        }
        while (cCharAt4 != ',') {
            if (cCharAt4 == '}') {
                int i20 = this.f4395bp + i19;
                this.f4395bp = i20;
                this.f4396ch = charAt(i20);
                this.matchStat = 5;
                this.token = 13;
                return null;
            }
            if (!isWhitespace(cCharAt4)) {
                this.matchStat = -1;
                return null;
            }
            cCharAt4 = charAt(this.f4395bp + i19);
            i19++;
        }
        int i21 = this.f4395bp + i19;
        this.f4395bp = i21;
        this.f4396ch = charAt(i21);
        this.matchStat = 5;
        this.token = 16;
        return null;
    }

    public boolean scanFieldBoolean(char[] cArr) {
        int i6;
        boolean z7;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = cArr.length;
        int i10 = length + 1;
        char cCharAt = charAt(this.f4395bp + length);
        if (cCharAt == 't') {
            int i11 = length + 2;
            if (charAt(this.f4395bp + i10) != 'r') {
                this.matchStat = -1;
                return false;
            }
            int i12 = length + 3;
            if (charAt(this.f4395bp + i11) != 'u') {
                this.matchStat = -1;
                return false;
            }
            i6 = length + 4;
            if (charAt(this.f4395bp + i12) != 'e') {
                this.matchStat = -1;
                return false;
            }
            z7 = true;
        } else {
            if (cCharAt != 'f') {
                this.matchStat = -1;
                return false;
            }
            int i13 = length + 2;
            if (charAt(this.f4395bp + i10) != 'a') {
                this.matchStat = -1;
                return false;
            }
            int i14 = length + 3;
            if (charAt(this.f4395bp + i13) != 'l') {
                this.matchStat = -1;
                return false;
            }
            int i15 = length + 4;
            if (charAt(this.f4395bp + i14) != 's') {
                this.matchStat = -1;
                return false;
            }
            i6 = length + 5;
            if (charAt(this.f4395bp + i15) != 'e') {
                this.matchStat = -1;
                return false;
            }
            z7 = false;
        }
        int i16 = i6 + 1;
        char cCharAt2 = charAt(this.f4395bp + i6);
        if (cCharAt2 == ',') {
            int i17 = this.f4395bp + i16;
            this.f4395bp = i17;
            this.f4396ch = charAt(i17);
            this.matchStat = 3;
            this.token = 16;
            return z7;
        }
        if (cCharAt2 != '}') {
            this.matchStat = -1;
            return false;
        }
        int i18 = i6 + 2;
        char cCharAt3 = charAt(this.f4395bp + i16);
        if (cCharAt3 == ',') {
            this.token = 16;
            int i19 = this.f4395bp + i18;
            this.f4395bp = i19;
            this.f4396ch = charAt(i19);
        } else if (cCharAt3 == ']') {
            this.token = 15;
            int i20 = this.f4395bp + i18;
            this.f4395bp = i20;
            this.f4396ch = charAt(i20);
        } else if (cCharAt3 == '}') {
            this.token = 13;
            int i21 = this.f4395bp + i18;
            this.f4395bp = i21;
            this.f4396ch = charAt(i21);
        } else {
            if (cCharAt3 != 26) {
                this.matchStat = -1;
                return false;
            }
            this.token = 20;
            this.f4395bp = i6 + 1 + this.f4395bp;
            this.f4396ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return z7;
    }

    public Date scanFieldDate(char[] cArr) {
        char cCharAt;
        int i6;
        long j10;
        Date date;
        int i10;
        char cCharAt2;
        boolean z7 = false;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i11 = length + 1;
        char cCharAt3 = charAt(this.f4395bp + length);
        if (cCharAt3 == '\"') {
            int iIndexOf = indexOf('\"', this.f4395bp + cArr.length + 1);
            if (iIndexOf == -1) {
                throw new JSONException("unclosed str");
            }
            int length2 = this.f4395bp + cArr.length + 1;
            String strSubString = subString(length2, iIndexOf - length2);
            if (strSubString.indexOf(92) != -1) {
                while (true) {
                    int i12 = 0;
                    for (int i13 = iIndexOf - 1; i13 >= 0 && charAt(i13) == '\\'; i13--) {
                        i12++;
                    }
                    if (i12 % 2 == 0) {
                        break;
                    }
                    iIndexOf = indexOf('\"', iIndexOf + 1);
                }
                int i14 = this.f4395bp;
                int length3 = iIndexOf - ((cArr.length + i14) + 1);
                strSubString = readString(sub_chars(i14 + cArr.length + 1, length3), length3);
            }
            int i15 = this.f4395bp;
            int length4 = (iIndexOf - ((cArr.length + i15) + 1)) + 1 + i11;
            i6 = length4 + 1;
            cCharAt = charAt(i15 + length4);
            JSONScanner jSONScanner = new JSONScanner(strSubString);
            try {
                if (!jSONScanner.scanISO8601DateIfMatch(false)) {
                    this.matchStat = -1;
                    jSONScanner.close();
                    return null;
                }
                date = jSONScanner.getCalendar().getTime();
                jSONScanner.close();
            } catch (Throwable th) {
                jSONScanner.close();
                throw th;
            }
        } else {
            if (cCharAt3 != '-' && (cCharAt3 < '0' || cCharAt3 > '9')) {
                this.matchStat = -1;
                return null;
            }
            if (cCharAt3 == '-') {
                cCharAt3 = charAt(this.f4395bp + i11);
                i11 = length + 2;
                z7 = true;
            }
            if (cCharAt3 < '0' || cCharAt3 > '9') {
                cCharAt = cCharAt3;
                i6 = i11;
                j10 = 0;
            } else {
                j10 = cCharAt3 - '0';
                while (true) {
                    i10 = i11 + 1;
                    cCharAt2 = charAt(this.f4395bp + i11);
                    if (cCharAt2 < '0' || cCharAt2 > '9') {
                        break;
                    }
                    j10 = (j10 * 10) + ((long) (cCharAt2 - '0'));
                    i11 = i10;
                }
                cCharAt = cCharAt2;
                i6 = i10;
            }
            if (j10 < 0) {
                this.matchStat = -1;
                return null;
            }
            if (z7) {
                j10 = -j10;
            }
            date = new Date(j10);
        }
        if (cCharAt == ',') {
            int i16 = this.f4395bp + i6;
            this.f4395bp = i16;
            this.f4396ch = charAt(i16);
            this.matchStat = 3;
            return date;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return null;
        }
        int i17 = i6 + 1;
        char cCharAt4 = charAt(this.f4395bp + i6);
        if (cCharAt4 == ',') {
            this.token = 16;
            int i18 = this.f4395bp + i17;
            this.f4395bp = i18;
            this.f4396ch = charAt(i18);
        } else if (cCharAt4 == ']') {
            this.token = 15;
            int i19 = this.f4395bp + i17;
            this.f4395bp = i19;
            this.f4396ch = charAt(i19);
        } else if (cCharAt4 == '}') {
            this.token = 13;
            int i20 = this.f4395bp + i17;
            this.f4395bp = i20;
            this.f4396ch = charAt(i20);
        } else {
            if (cCharAt4 != 26) {
                this.matchStat = -1;
                return null;
            }
            this.token = 20;
            this.f4395bp += i6;
            this.f4396ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return date;
    }

    public BigDecimal scanFieldDecimal(char[] cArr) {
        int i6;
        char cCharAt;
        int length;
        int i10;
        int iM13g;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length2 = cArr.length;
        int i11 = length2 + 1;
        char cCharAt2 = charAt(this.f4395bp + length2);
        boolean z7 = cCharAt2 == '\"';
        if (z7) {
            cCharAt2 = charAt(this.f4395bp + i11);
            i11 = length2 + 2;
        }
        if (cCharAt2 == '-') {
            cCharAt2 = charAt(this.f4395bp + i11);
            i11++;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            if (cCharAt2 != 'n' || charAt(this.f4395bp + i11) != 'u' || AbstractC0004e.m10d(this.f4395bp, i11, 1, this) != 'l' || AbstractC0004e.m10d(this.f4395bp, i11, 2, this) != 'l') {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 5;
            int i12 = i11 + 4;
            char cCharAt3 = charAt(this.f4395bp + i11 + 3);
            if (z7 && cCharAt3 == '\"') {
                cCharAt3 = charAt(this.f4395bp + i12);
                i12 = i11 + 5;
            }
            while (cCharAt3 != ',') {
                if (cCharAt3 == '}') {
                    int i13 = this.f4395bp + i12;
                    this.f4395bp = i13;
                    this.f4396ch = charAt(i13);
                    this.matchStat = 5;
                    this.token = 13;
                    return null;
                }
                if (!isWhitespace(cCharAt3)) {
                    this.matchStat = -1;
                    return null;
                }
                cCharAt3 = charAt(this.f4395bp + i12);
                i12++;
            }
            int i14 = this.f4395bp + i12;
            this.f4395bp = i14;
            this.f4396ch = charAt(i14);
            this.matchStat = 5;
            this.token = 16;
            return null;
        }
        while (true) {
            i6 = i11 + 1;
            cCharAt = charAt(this.f4395bp + i11);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            i11 = i6;
        }
        if (cCharAt == '.') {
            int i15 = i11 + 2;
            char cCharAt4 = charAt(this.f4395bp + i6);
            if (cCharAt4 < '0' || cCharAt4 > '9') {
                this.matchStat = -1;
                return null;
            }
            while (true) {
                i6 = i15 + 1;
                cCharAt = charAt(this.f4395bp + i15);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                i15 = i6;
            }
        }
        if (cCharAt == 'e' || cCharAt == 'E') {
            int i16 = i6 + 1;
            cCharAt = charAt(this.f4395bp + i6);
            if (cCharAt == '+' || cCharAt == '-') {
                i6 += 2;
                cCharAt = charAt(this.f4395bp + i16);
            } else {
                i6 = i16;
            }
            while (cCharAt >= '0' && cCharAt <= '9') {
                char cCharAt5 = charAt(this.f4395bp + i6);
                i6++;
                cCharAt = cCharAt5;
            }
        }
        int i17 = i6;
        if (!z7) {
            int i18 = this.f4395bp;
            length = cArr.length + i18;
            int iM13g2 = AbstractC0004e.m13g(i18, i17, length, 1);
            i10 = i17;
            iM13g = iM13g2;
        } else {
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return null;
            }
            i10 = i17 + 1;
            cCharAt = charAt(this.f4395bp + i17);
            int i19 = this.f4395bp;
            length = cArr.length + i19 + 1;
            iM13g = AbstractC0004e.m13g(i19, i10, length, 2);
        }
        if (iM13g > 65535) {
            throw new JSONException("scan decimal overflow");
        }
        char[] cArrSub_chars = sub_chars(length, iM13g);
        BigDecimal bigDecimal = new BigDecimal(cArrSub_chars, 0, cArrSub_chars.length, MathContext.UNLIMITED);
        if (cCharAt == ',') {
            int i20 = this.f4395bp + i10;
            this.f4395bp = i20;
            this.f4396ch = charAt(i20);
            this.matchStat = 3;
            this.token = 16;
            return bigDecimal;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return null;
        }
        int i21 = i10 + 1;
        char cCharAt6 = charAt(this.f4395bp + i10);
        if (cCharAt6 == ',') {
            this.token = 16;
            int i22 = this.f4395bp + i21;
            this.f4395bp = i22;
            this.f4396ch = charAt(i22);
        } else if (cCharAt6 == ']') {
            this.token = 15;
            int i23 = this.f4395bp + i21;
            this.f4395bp = i23;
            this.f4396ch = charAt(i23);
        } else if (cCharAt6 == '}') {
            this.token = 13;
            int i24 = this.f4395bp + i21;
            this.f4395bp = i24;
            this.f4396ch = charAt(i24);
        } else {
            if (cCharAt6 != 26) {
                this.matchStat = -1;
                return null;
            }
            this.token = 20;
            this.f4395bp += i10;
            this.f4396ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return bigDecimal;
    }

    public final double scanFieldDouble(char[] cArr) {
        int i6;
        char cCharAt;
        boolean z7;
        long j10;
        int length;
        int i10;
        int iM13g;
        double d;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0.0d;
        }
        int length2 = cArr.length;
        int i11 = length2 + 1;
        char cCharAt2 = charAt(this.f4395bp + length2);
        boolean z10 = cCharAt2 == '\"';
        if (z10) {
            cCharAt2 = charAt(this.f4395bp + i11);
            i11 = length2 + 2;
        }
        boolean z11 = cCharAt2 == '-';
        if (z11) {
            cCharAt2 = charAt(this.f4395bp + i11);
            i11++;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            if (cCharAt2 != 'n' || charAt(this.f4395bp + i11) != 'u' || AbstractC0004e.m10d(this.f4395bp, i11, 1, this) != 'l' || AbstractC0004e.m10d(this.f4395bp, i11, 2, this) != 'l') {
                this.matchStat = -1;
                return 0.0d;
            }
            this.matchStat = 5;
            int i12 = i11 + 4;
            char cCharAt3 = charAt(this.f4395bp + i11 + 3);
            if (z10 && cCharAt3 == '\"') {
                cCharAt3 = charAt(this.f4395bp + i12);
                i12 = i11 + 5;
            }
            while (cCharAt3 != ',') {
                if (cCharAt3 == '}') {
                    int i13 = this.f4395bp + i12;
                    this.f4395bp = i13;
                    this.f4396ch = charAt(i13);
                    this.matchStat = 5;
                    this.token = 13;
                    return 0.0d;
                }
                if (!isWhitespace(cCharAt3)) {
                    this.matchStat = -1;
                    return 0.0d;
                }
                cCharAt3 = charAt(this.f4395bp + i12);
                i12++;
            }
            int i14 = this.f4395bp + i12;
            this.f4395bp = i14;
            this.f4396ch = charAt(i14);
            this.matchStat = 5;
            this.token = 16;
            return 0.0d;
        }
        long j11 = cCharAt2 - '0';
        while (true) {
            i6 = i11 + 1;
            cCharAt = charAt(this.f4395bp + i11);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            j11 = (j11 * 10) + ((long) (cCharAt - '0'));
            i11 = i6;
        }
        if (cCharAt == '.') {
            int i15 = i11 + 2;
            char cCharAt4 = charAt(this.f4395bp + i6);
            if (cCharAt4 < '0' || cCharAt4 > '9') {
                this.matchStat = -1;
                return 0.0d;
            }
            z7 = z11;
            j11 = (j11 * 10) + ((long) (cCharAt4 - '0'));
            j10 = 10;
            while (true) {
                i6 = i15 + 1;
                cCharAt = charAt(this.f4395bp + i15);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                j11 = (j11 * 10) + ((long) (cCharAt - '0'));
                j10 *= 10;
                i15 = i6;
            }
        } else {
            z7 = z11;
            j10 = 1;
        }
        boolean z12 = cCharAt == 'e' || cCharAt == 'E';
        if (z12) {
            int i16 = i6 + 1;
            cCharAt = charAt(this.f4395bp + i6);
            if (cCharAt == '+' || cCharAt == '-') {
                i6 += 2;
                cCharAt = charAt(this.f4395bp + i16);
            } else {
                i6 = i16;
            }
            while (cCharAt >= '0' && cCharAt <= '9') {
                cCharAt = charAt(this.f4395bp + i6);
                i6++;
            }
        }
        int i17 = i6;
        if (!z10) {
            int i18 = this.f4395bp;
            length = cArr.length + i18;
            int iM13g2 = AbstractC0004e.m13g(i18, i17, length, 1);
            i10 = i17;
            iM13g = iM13g2;
        } else {
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return 0.0d;
            }
            i10 = i17 + 1;
            cCharAt = charAt(this.f4395bp + i17);
            int i19 = this.f4395bp;
            length = cArr.length + i19 + 1;
            iM13g = AbstractC0004e.m13g(i19, i10, length, 2);
        }
        if (z12 || iM13g >= 17) {
            d = Double.parseDouble(subString(length, iM13g));
        } else {
            d = j11 / j10;
            if (z7) {
                d = -d;
            }
        }
        if (cCharAt == ',') {
            int i20 = this.f4395bp + i10;
            this.f4395bp = i20;
            this.f4396ch = charAt(i20);
            this.matchStat = 3;
            this.token = 16;
            return d;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return 0.0d;
        }
        int i21 = i10 + 1;
        char cCharAt5 = charAt(this.f4395bp + i10);
        if (cCharAt5 == ',') {
            this.token = 16;
            int i22 = this.f4395bp + i21;
            this.f4395bp = i22;
            this.f4396ch = charAt(i22);
        } else if (cCharAt5 == ']') {
            this.token = 15;
            int i23 = this.f4395bp + i21;
            this.f4395bp = i23;
            this.f4396ch = charAt(i23);
        } else if (cCharAt5 == '}') {
            this.token = 13;
            int i24 = this.f4395bp + i21;
            this.f4395bp = i24;
            this.f4396ch = charAt(i24);
        } else {
            if (cCharAt5 != 26) {
                this.matchStat = -1;
                return 0.0d;
            }
            this.token = 20;
            this.f4395bp += i10;
            this.f4396ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return d;
    }

    public final float scanFieldFloat(char[] cArr) {
        int i6;
        char cCharAt;
        boolean z7;
        long j10;
        int length;
        int i10;
        int iM13g;
        float f;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0.0f;
        }
        int length2 = cArr.length;
        int i11 = length2 + 1;
        char cCharAt2 = charAt(this.f4395bp + length2);
        boolean z10 = cCharAt2 == '\"';
        if (z10) {
            cCharAt2 = charAt(this.f4395bp + i11);
            i11 = length2 + 2;
        }
        boolean z11 = cCharAt2 == '-';
        if (z11) {
            cCharAt2 = charAt(this.f4395bp + i11);
            i11++;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            if (cCharAt2 != 'n' || charAt(this.f4395bp + i11) != 'u' || AbstractC0004e.m10d(this.f4395bp, i11, 1, this) != 'l' || AbstractC0004e.m10d(this.f4395bp, i11, 2, this) != 'l') {
                this.matchStat = -1;
                return 0.0f;
            }
            this.matchStat = 5;
            int i12 = i11 + 4;
            char cCharAt3 = charAt(this.f4395bp + i11 + 3);
            if (z10 && cCharAt3 == '\"') {
                cCharAt3 = charAt(this.f4395bp + i12);
                i12 = i11 + 5;
            }
            while (cCharAt3 != ',') {
                if (cCharAt3 == '}') {
                    int i13 = this.f4395bp + i12;
                    this.f4395bp = i13;
                    this.f4396ch = charAt(i13);
                    this.matchStat = 5;
                    this.token = 13;
                    return 0.0f;
                }
                if (!isWhitespace(cCharAt3)) {
                    this.matchStat = -1;
                    return 0.0f;
                }
                cCharAt3 = charAt(this.f4395bp + i12);
                i12++;
            }
            int i14 = this.f4395bp + i12;
            this.f4395bp = i14;
            this.f4396ch = charAt(i14);
            this.matchStat = 5;
            this.token = 16;
            return 0.0f;
        }
        long j11 = cCharAt2 - '0';
        while (true) {
            i6 = i11 + 1;
            cCharAt = charAt(this.f4395bp + i11);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            j11 = (j11 * 10) + ((long) (cCharAt - '0'));
            i11 = i6;
        }
        if (cCharAt == '.') {
            int i15 = i11 + 2;
            char cCharAt4 = charAt(this.f4395bp + i6);
            if (cCharAt4 < '0' || cCharAt4 > '9') {
                this.matchStat = -1;
                return 0.0f;
            }
            z7 = z11;
            j11 = (j11 * 10) + ((long) (cCharAt4 - '0'));
            j10 = 10;
            while (true) {
                i6 = i15 + 1;
                cCharAt = charAt(this.f4395bp + i15);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                j11 = (j11 * 10) + ((long) (cCharAt - '0'));
                j10 *= 10;
                i15 = i6;
            }
        } else {
            z7 = z11;
            j10 = 1;
        }
        boolean z12 = cCharAt == 'e' || cCharAt == 'E';
        if (z12) {
            int i16 = i6 + 1;
            cCharAt = charAt(this.f4395bp + i6);
            if (cCharAt == '+' || cCharAt == '-') {
                i6 += 2;
                cCharAt = charAt(this.f4395bp + i16);
            } else {
                i6 = i16;
            }
            while (cCharAt >= '0' && cCharAt <= '9') {
                char cCharAt5 = charAt(this.f4395bp + i6);
                i6++;
                cCharAt = cCharAt5;
            }
        }
        int i17 = i6;
        if (!z10) {
            int i18 = this.f4395bp;
            length = cArr.length + i18;
            int iM13g2 = AbstractC0004e.m13g(i18, i17, length, 1);
            i10 = i17;
            iM13g = iM13g2;
        } else {
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return 0.0f;
            }
            i10 = i17 + 1;
            cCharAt = charAt(this.f4395bp + i17);
            int i19 = this.f4395bp;
            length = cArr.length + i19 + 1;
            iM13g = AbstractC0004e.m13g(i19, i10, length, 2);
        }
        if (z12 || iM13g >= 17) {
            f = Float.parseFloat(subString(length, iM13g));
        } else {
            f = (float) (j11 / j10);
            if (z7) {
                f = -f;
            }
        }
        if (cCharAt == ',') {
            int i20 = this.f4395bp + i10;
            this.f4395bp = i20;
            this.f4396ch = charAt(i20);
            this.matchStat = 3;
            this.token = 16;
            return f;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return 0.0f;
        }
        int i21 = i10 + 1;
        char cCharAt6 = charAt(this.f4395bp + i10);
        if (cCharAt6 == ',') {
            this.token = 16;
            int i22 = this.f4395bp + i21;
            this.f4395bp = i22;
            this.f4396ch = charAt(i22);
        } else if (cCharAt6 == ']') {
            this.token = 15;
            int i23 = this.f4395bp + i21;
            this.f4395bp = i23;
            this.f4396ch = charAt(i23);
        } else if (cCharAt6 == '}') {
            this.token = 13;
            int i24 = this.f4395bp + i21;
            this.f4395bp = i24;
            this.f4396ch = charAt(i24);
        } else {
            if (cCharAt6 != 26) {
                this.matchStat = -1;
                return 0.0f;
            }
            this.f4395bp += i10;
            this.token = 20;
            this.f4396ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return f;
    }

    public final float[] scanFieldFloatArray(char[] cArr) {
        int i6;
        char cCharAt;
        int i10;
        float f;
        float[] fArr;
        this.matchStat = 0;
        float[] fArr2 = null;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i11 = length + 1;
        if (charAt(this.f4395bp + length) != '[') {
            this.matchStat = -2;
            return null;
        }
        int i12 = length + 2;
        char cCharAt2 = charAt(this.f4395bp + i11);
        float[] fArr3 = new float[16];
        int i13 = 0;
        while (true) {
            int i14 = this.f4395bp;
            int i15 = (i14 + i12) - 1;
            boolean z7 = cCharAt2 == '-';
            if (z7) {
                cCharAt2 = charAt(i14 + i12);
                i12++;
            }
            if (cCharAt2 < '0' || cCharAt2 > '9') {
                break;
            }
            int i16 = cCharAt2 - '0';
            while (true) {
                i6 = i12 + 1;
                cCharAt = charAt(this.f4395bp + i12);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                i16 = (i16 * 10) + (cCharAt - '0');
                i12 = i6;
            }
            if (cCharAt == '.') {
                int i17 = i12 + 2;
                char cCharAt3 = charAt(this.f4395bp + i6);
                if (cCharAt3 < '0' || cCharAt3 > '9') {
                    this.matchStat = -1;
                    return fArr2;
                }
                i16 = (cCharAt3 - '0') + (i16 * 10);
                i10 = 10;
                while (true) {
                    i6 = i17 + 1;
                    cCharAt = charAt(this.f4395bp + i17);
                    if (cCharAt < '0' || cCharAt > '9') {
                        break;
                    }
                    i16 = (i16 * 10) + (cCharAt - '0');
                    i10 *= 10;
                    i17 = i6;
                }
            } else {
                i10 = 1;
            }
            boolean z10 = cCharAt == 'e' || cCharAt == 'E';
            if (z10) {
                int i18 = i6 + 1;
                cCharAt = charAt(this.f4395bp + i6);
                if (cCharAt == '+' || cCharAt == '-') {
                    i6 += 2;
                    cCharAt = charAt(this.f4395bp + i18);
                } else {
                    i6 = i18;
                }
                while (cCharAt >= '0' && cCharAt <= '9') {
                    cCharAt = charAt(this.f4395bp + i6);
                    i6++;
                }
            }
            int i19 = i6;
            int iM13g = AbstractC0004e.m13g(this.f4395bp, i19, i15, 1);
            if (z10 || iM13g >= 10) {
                f = Float.parseFloat(subString(i15, iM13g));
            } else {
                f = i16 / i10;
                if (z7) {
                    f = -f;
                }
            }
            if (i13 >= fArr3.length) {
                float[] fArr4 = new float[(fArr3.length * 3) / 2];
                System.arraycopy(fArr3, 0, fArr4, 0, i13);
                fArr3 = fArr4;
            }
            int i20 = i13 + 1;
            fArr3[i13] = f;
            if (cCharAt == ',') {
                i12 = i19 + 1;
                cCharAt = charAt(this.f4395bp + i19);
                fArr = null;
            } else {
                if (cCharAt == ']') {
                    int i21 = i19 + 1;
                    char cCharAt4 = charAt(this.f4395bp + i19);
                    if (i20 != fArr3.length) {
                        float[] fArr5 = new float[i20];
                        System.arraycopy(fArr3, 0, fArr5, 0, i20);
                        fArr3 = fArr5;
                    }
                    if (cCharAt4 == ',') {
                        this.f4395bp += i19;
                        next();
                        this.matchStat = 3;
                        this.token = 16;
                        return fArr3;
                    }
                    if (cCharAt4 != '}') {
                        this.matchStat = -1;
                        return null;
                    }
                    char cCharAt5 = charAt(this.f4395bp + i21);
                    if (cCharAt5 == ',') {
                        this.token = 16;
                        this.f4395bp = i19 + 1 + this.f4395bp;
                        next();
                    } else if (cCharAt5 == ']') {
                        this.token = 15;
                        this.f4395bp = i19 + 1 + this.f4395bp;
                        next();
                    } else if (cCharAt5 == '}') {
                        this.token = 13;
                        this.f4395bp = i19 + 1 + this.f4395bp;
                        next();
                    } else {
                        if (cCharAt5 != 26) {
                            this.matchStat = -1;
                            return null;
                        }
                        this.f4395bp = i19 + 1 + this.f4395bp;
                        this.token = 20;
                        this.f4396ch = JSONLexer.EOI;
                    }
                    this.matchStat = 4;
                    return fArr3;
                }
                fArr = null;
                i12 = i19;
            }
            fArr2 = fArr;
            i13 = i20;
            cCharAt2 = cCharAt;
        }
        float[] fArr6 = fArr2;
        this.matchStat = -1;
        return fArr6;
    }

    public final float[][] scanFieldFloatArray2(char[] cArr) {
        int i6;
        char cCharAt;
        int i10;
        int i11;
        int i12;
        float f;
        int i13;
        int i14;
        char cCharAt2;
        this.matchStat = 0;
        float[][] fArr = null;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i15 = length + 1;
        if (charAt(this.f4395bp + length) != '[') {
            this.matchStat = -2;
            return null;
        }
        int i16 = length + 2;
        char cCharAt3 = charAt(this.f4395bp + i15);
        int i17 = 16;
        float[][] fArr2 = new float[16][];
        int i18 = 0;
        for (char c5 = '['; cCharAt3 == c5; c5 = '[') {
            int i19 = i16 + 1;
            char cCharAt4 = charAt(this.f4395bp + i16);
            float[] fArr3 = new float[i17];
            int i20 = 0;
            while (true) {
                int i21 = this.f4395bp;
                int i22 = (i21 + i19) - 1;
                boolean z7 = cCharAt4 == '-';
                if (z7) {
                    char cCharAt5 = charAt(i21 + i19);
                    i19++;
                    cCharAt4 = cCharAt5;
                }
                if (cCharAt4 < '0' || cCharAt4 > '9') {
                    this.matchStat = -1;
                    return null;
                }
                int i23 = cCharAt4 - '0';
                while (true) {
                    i6 = i19 + 1;
                    cCharAt = charAt(this.f4395bp + i19);
                    if (cCharAt < '0' || cCharAt > '9') {
                        break;
                    }
                    i23 = (i23 * 10) + (cCharAt - '0');
                    i19 = i6;
                }
                if (cCharAt == '.') {
                    int i24 = i19 + 2;
                    char cCharAt6 = charAt(this.f4395bp + i6);
                    if (cCharAt6 < '0' || cCharAt6 > '9') {
                        this.matchStat = -1;
                        return fArr;
                    }
                    int i25 = (cCharAt6 - '0') + (i23 * 10);
                    int i26 = 10;
                    while (true) {
                        i6 = i24 + 1;
                        cCharAt2 = charAt(this.f4395bp + i24);
                        if (cCharAt2 < '0' || cCharAt2 > '9') {
                            break;
                        }
                        i25 = (i25 * 10) + (cCharAt2 - '0');
                        i26 *= 10;
                        i24 = i6;
                    }
                    int i27 = i25;
                    i11 = i26;
                    cCharAt = cCharAt2;
                    i10 = i27;
                } else {
                    i10 = i23;
                    i11 = 1;
                }
                boolean z10 = cCharAt == 'e' || cCharAt == 'E';
                if (z10) {
                    int i28 = i6 + 1;
                    cCharAt = charAt(this.f4395bp + i6);
                    if (cCharAt == '+' || cCharAt == '-') {
                        i6 += 2;
                        cCharAt = charAt(this.f4395bp + i28);
                    } else {
                        i6 = i28;
                    }
                    while (cCharAt >= '0' && cCharAt <= '9') {
                        cCharAt = charAt(this.f4395bp + i6);
                        i6++;
                    }
                }
                i12 = i6;
                int iM13g = AbstractC0004e.m13g(this.f4395bp, i12, i22, 1);
                if (z10 || iM13g >= 10) {
                    f = Float.parseFloat(subString(i22, iM13g));
                } else {
                    f = i10 / i11;
                    if (z7) {
                        f = -f;
                    }
                }
                if (i20 >= fArr3.length) {
                    float[] fArr4 = new float[(fArr3.length * 3) / 2];
                    System.arraycopy(fArr3, 0, fArr4, 0, i20);
                    fArr3 = fArr4;
                }
                i13 = i20 + 1;
                fArr3[i20] = f;
                if (cCharAt == ',') {
                    cCharAt = charAt(this.f4395bp + i12);
                    i19 = i12 + 1;
                } else {
                    if (cCharAt == ']') {
                        break;
                    }
                    i19 = i12;
                }
                i20 = i13;
                fArr = null;
                cCharAt4 = cCharAt;
            }
            int i29 = i12 + 1;
            char cCharAt7 = charAt(this.f4395bp + i12);
            if (i13 != fArr3.length) {
                float[] fArr5 = new float[i13];
                i14 = 0;
                System.arraycopy(fArr3, 0, fArr5, 0, i13);
                fArr3 = fArr5;
            } else {
                i14 = 0;
            }
            if (i18 >= fArr2.length) {
                fArr2 = new float[(fArr2.length * 3) / 2][];
                System.arraycopy(fArr3, i14, fArr2, i14, i13);
            }
            int i30 = i18 + 1;
            fArr2[i18] = fArr3;
            if (cCharAt7 == ',') {
                cCharAt3 = charAt(this.f4395bp + i29);
                i16 = i12 + 2;
            } else {
                if (cCharAt7 == ']') {
                    i16 = i12 + 2;
                    cCharAt3 = charAt(this.f4395bp + i29);
                    i18 = i30;
                    break;
                }
                cCharAt3 = cCharAt7;
                i16 = i29;
            }
            i18 = i30;
            fArr = null;
            i17 = 16;
        }
        if (i18 != fArr2.length) {
            float[][] fArr6 = new float[i18][];
            System.arraycopy(fArr2, 0, fArr6, 0, i18);
            fArr2 = fArr6;
        }
        if (cCharAt3 == ',') {
            this.f4395bp = (i16 - 1) + this.f4395bp;
            next();
            this.matchStat = 3;
            this.token = 16;
            return fArr2;
        }
        if (cCharAt3 != '}') {
            this.matchStat = -1;
            return null;
        }
        char cCharAt8 = charAt(this.f4395bp + i16);
        if (cCharAt8 == ',') {
            this.token = 16;
            this.f4395bp += i16;
            next();
        } else if (cCharAt8 == ']') {
            this.token = 15;
            this.f4395bp += i16;
            next();
        } else if (cCharAt8 == '}') {
            this.token = 13;
            this.f4395bp += i16;
            next();
        } else {
            if (cCharAt8 != 26) {
                this.matchStat = -1;
                return null;
            }
            this.f4395bp += i16;
            this.token = 20;
            this.f4396ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return fArr2;
    }

    public int scanFieldInt(char[] cArr) {
        int i6;
        char cCharAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr.length;
        int i10 = length + 1;
        char cCharAt2 = charAt(this.f4395bp + length);
        boolean z7 = cCharAt2 == '-';
        if (z7) {
            cCharAt2 = charAt(this.f4395bp + i10);
            i10 = length + 2;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i11 = cCharAt2 - '0';
        while (true) {
            i6 = i10 + 1;
            cCharAt = charAt(this.f4395bp + i10);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            i11 = (i11 * 10) + (cCharAt - '0');
            i10 = i6;
        }
        if (cCharAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if ((i11 < 0 || i6 > cArr.length + 14) && !(i11 == Integer.MIN_VALUE && i6 == 17 && z7)) {
            this.matchStat = -1;
            return 0;
        }
        if (cCharAt == ',') {
            int i12 = this.f4395bp + i6;
            this.f4395bp = i12;
            this.f4396ch = charAt(i12);
            this.matchStat = 3;
            this.token = 16;
            return z7 ? -i11 : i11;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return 0;
        }
        int i13 = i10 + 2;
        char cCharAt3 = charAt(this.f4395bp + i6);
        if (cCharAt3 == ',') {
            this.token = 16;
            int i14 = this.f4395bp + i13;
            this.f4395bp = i14;
            this.f4396ch = charAt(i14);
        } else if (cCharAt3 == ']') {
            this.token = 15;
            int i15 = this.f4395bp + i13;
            this.f4395bp = i15;
            this.f4396ch = charAt(i15);
        } else if (cCharAt3 == '}') {
            this.token = 13;
            int i16 = this.f4395bp + i13;
            this.f4395bp = i16;
            this.f4396ch = charAt(i16);
        } else {
            if (cCharAt3 != 26) {
                this.matchStat = -1;
                return 0;
            }
            this.token = 20;
            this.f4395bp = i10 + 1 + this.f4395bp;
            this.f4396ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return z7 ? -i11 : i11;
    }

    public final int[] scanFieldIntArray(char[] cArr) {
        boolean z7;
        int i6;
        char cCharAt;
        int i10;
        char cCharAt2;
        int i11;
        int[] iArr;
        this.matchStat = 0;
        int[] iArr2 = null;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i12 = length + 1;
        if (charAt(this.f4395bp + length) != '[') {
            this.matchStat = -2;
            return null;
        }
        int i13 = length + 2;
        char cCharAt3 = charAt(this.f4395bp + i12);
        int[] iArr3 = new int[16];
        if (cCharAt3 == ']') {
            i11 = length + 3;
            cCharAt2 = charAt(this.f4395bp + i13);
            i10 = 0;
        } else {
            int i14 = 0;
            while (true) {
                if (cCharAt3 == '-') {
                    cCharAt3 = charAt(this.f4395bp + i13);
                    i13++;
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (cCharAt3 < '0' || cCharAt3 > '9') {
                    int[] iArr4 = iArr2;
                    this.matchStat = -1;
                    return iArr4;
                }
                int i15 = cCharAt3 - '0';
                while (true) {
                    i6 = i13 + 1;
                    cCharAt = charAt(this.f4395bp + i13);
                    if (cCharAt < '0' || cCharAt > '9') {
                        break;
                    }
                    i15 = (i15 * 10) + (cCharAt - '0');
                    i13 = i6;
                }
                if (i14 >= iArr3.length) {
                    int[] iArr5 = new int[(iArr3.length * 3) / 2];
                    System.arraycopy(iArr3, 0, iArr5, 0, i14);
                    iArr3 = iArr5;
                }
                i10 = i14 + 1;
                if (z7) {
                    i15 = -i15;
                }
                iArr3[i14] = i15;
                if (cCharAt == ',') {
                    i13 += 2;
                    cCharAt3 = charAt(this.f4395bp + i6);
                    iArr = null;
                } else {
                    if (cCharAt == ']') {
                        cCharAt2 = charAt(this.f4395bp + i6);
                        i11 = i13 + 2;
                        break;
                    }
                    iArr = null;
                    cCharAt3 = cCharAt;
                    i13 = i6;
                }
                iArr2 = iArr;
                i14 = i10;
            }
        }
        if (i10 != iArr3.length) {
            int[] iArr6 = new int[i10];
            System.arraycopy(iArr3, 0, iArr6, 0, i10);
            iArr3 = iArr6;
        }
        if (cCharAt2 == ',') {
            this.f4395bp = (i11 - 1) + this.f4395bp;
            next();
            this.matchStat = 3;
            this.token = 16;
            return iArr3;
        }
        if (cCharAt2 != '}') {
            this.matchStat = -1;
            return null;
        }
        char cCharAt4 = charAt(this.f4395bp + i11);
        if (cCharAt4 == ',') {
            this.token = 16;
            this.f4395bp += i11;
            next();
        } else if (cCharAt4 == ']') {
            this.token = 15;
            this.f4395bp += i11;
            next();
        } else if (cCharAt4 == '}') {
            this.token = 13;
            this.f4395bp += i11;
            next();
        } else {
            if (cCharAt4 != 26) {
                this.matchStat = -1;
                return null;
            }
            this.f4395bp += i11;
            this.token = 20;
            this.f4396ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return iArr3;
    }

    public long scanFieldLong(char[] cArr) {
        int i6;
        char cCharAt;
        boolean z7 = false;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i10 = length + 1;
        char cCharAt2 = charAt(this.f4395bp + length);
        if (cCharAt2 == '-') {
            cCharAt2 = charAt(this.f4395bp + i10);
            i10 = length + 2;
            z7 = true;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            this.matchStat = -1;
            return 0L;
        }
        long j10 = cCharAt2 - '0';
        while (true) {
            i6 = i10 + 1;
            cCharAt = charAt(this.f4395bp + i10);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            j10 = (j10 * 10) + ((long) (cCharAt - '0'));
            i10 = i6;
        }
        if (cCharAt == '.') {
            this.matchStat = -1;
            return 0L;
        }
        if (i6 - cArr.length >= 21 || (j10 < 0 && !(j10 == Long.MIN_VALUE && z7))) {
            this.matchStat = -1;
            return 0L;
        }
        if (cCharAt == ',') {
            int i11 = this.f4395bp + i6;
            this.f4395bp = i11;
            this.f4396ch = charAt(i11);
            this.matchStat = 3;
            this.token = 16;
            return z7 ? -j10 : j10;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return 0L;
        }
        int i12 = i10 + 2;
        char cCharAt3 = charAt(this.f4395bp + i6);
        if (cCharAt3 == ',') {
            this.token = 16;
            int i13 = this.f4395bp + i12;
            this.f4395bp = i13;
            this.f4396ch = charAt(i13);
        } else if (cCharAt3 == ']') {
            this.token = 15;
            int i14 = this.f4395bp + i12;
            this.f4395bp = i14;
            this.f4396ch = charAt(i14);
        } else if (cCharAt3 == '}') {
            this.token = 13;
            int i15 = this.f4395bp + i12;
            this.f4395bp = i15;
            this.f4396ch = charAt(i15);
        } else {
            if (cCharAt3 != 26) {
                this.matchStat = -1;
                return 0L;
            }
            this.token = 20;
            this.f4395bp = i10 + 1 + this.f4395bp;
            this.f4396ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return z7 ? -j10 : j10;
    }

    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return stringDefaultValue();
        }
        int length = cArr.length;
        int i6 = length + 1;
        if (charAt(this.f4395bp + length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int iIndexOf = indexOf('\"', this.f4395bp + cArr.length + 1);
        if (iIndexOf == -1) {
            throw new JSONException("unclosed str");
        }
        int length2 = this.f4395bp + cArr.length + 1;
        String strSubString = subString(length2, iIndexOf - length2);
        if (strSubString.indexOf(92) != -1) {
            while (true) {
                int i10 = 0;
                for (int i11 = iIndexOf - 1; i11 >= 0 && charAt(i11) == '\\'; i11--) {
                    i10++;
                }
                if (i10 % 2 == 0) {
                    break;
                }
                iIndexOf = indexOf('\"', iIndexOf + 1);
            }
            int i12 = this.f4395bp;
            int length3 = iIndexOf - ((cArr.length + i12) + 1);
            strSubString = readString(sub_chars(i12 + cArr.length + 1, length3), length3);
        }
        int i13 = this.f4395bp;
        int length4 = (iIndexOf - ((cArr.length + i13) + 1)) + 1 + i6;
        int i14 = length4 + 1;
        char cCharAt = charAt(i13 + length4);
        if (cCharAt == ',') {
            int i15 = this.f4395bp + i14;
            this.f4395bp = i15;
            this.f4396ch = charAt(i15);
            this.matchStat = 3;
            return strSubString;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int i16 = length4 + 2;
        char cCharAt2 = charAt(this.f4395bp + i14);
        if (cCharAt2 == ',') {
            this.token = 16;
            int i17 = this.f4395bp + i16;
            this.f4395bp = i17;
            this.f4396ch = charAt(i17);
        } else if (cCharAt2 == ']') {
            this.token = 15;
            int i18 = this.f4395bp + i16;
            this.f4395bp = i18;
            this.f4396ch = charAt(i18);
        } else if (cCharAt2 == '}') {
            this.token = 13;
            int i19 = this.f4395bp + i16;
            this.f4395bp = i19;
            this.f4396ch = charAt(i19);
        } else {
            if (cCharAt2 != 26) {
                this.matchStat = -1;
                return stringDefaultValue();
            }
            this.token = 20;
            this.f4395bp = length4 + 1 + this.f4395bp;
            this.f4396ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return strSubString;
    }

    public Collection<String> scanFieldStringArray(char[] cArr, Class<?> cls) {
        int i6;
        char cCharAt;
        int i10;
        char cCharAt2;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        Collection<String> collectionNewCollectionByType = newCollectionByType(cls);
        int length = cArr.length;
        int i11 = length + 1;
        if (charAt(this.f4395bp + length) != '[') {
            this.matchStat = -1;
            return null;
        }
        int i12 = length + 2;
        char cCharAt3 = charAt(this.f4395bp + i11);
        while (true) {
            if (cCharAt3 == '\"') {
                int iIndexOf = indexOf('\"', this.f4395bp + i12);
                if (iIndexOf == -1) {
                    throw new JSONException("unclosed str");
                }
                int i13 = this.f4395bp + i12;
                String strSubString = subString(i13, iIndexOf - i13);
                if (strSubString.indexOf(92) != -1) {
                    while (true) {
                        int i14 = 0;
                        for (int i15 = iIndexOf - 1; i15 >= 0 && charAt(i15) == '\\'; i15--) {
                            i14++;
                        }
                        if (i14 % 2 == 0) {
                            break;
                        }
                        iIndexOf = indexOf('\"', iIndexOf + 1);
                    }
                    int i16 = this.f4395bp;
                    int i17 = iIndexOf - (i16 + i12);
                    strSubString = readString(sub_chars(i16 + i12, i17), i17);
                }
                int i18 = this.f4395bp;
                int i19 = (iIndexOf - (i18 + i12)) + 1 + i12;
                i10 = i19 + 1;
                cCharAt2 = charAt(i18 + i19);
                collectionNewCollectionByType.add(strSubString);
            } else {
                if (cCharAt3 != 'n' || charAt(this.f4395bp + i12) != 'u' || AbstractC0004e.m10d(this.f4395bp, i12, 1, this) != 'l' || AbstractC0004e.m10d(this.f4395bp, i12, 2, this) != 'l') {
                    if (cCharAt3 != ']' || collectionNewCollectionByType.size() != 0) {
                        throw new JSONException("illega str");
                    }
                    i6 = i12 + 1;
                    cCharAt = charAt(this.f4395bp + i12);
                    break;
                }
                int i20 = i12 + 3;
                i10 = i12 + 4;
                cCharAt2 = charAt(this.f4395bp + i20);
                collectionNewCollectionByType.add(null);
            }
            if (cCharAt2 != ',') {
                if (cCharAt2 != ']') {
                    this.matchStat = -1;
                    return null;
                }
                i6 = i10 + 1;
                cCharAt = charAt(this.f4395bp + i10);
                break;
            }
            cCharAt3 = charAt(this.f4395bp + i10);
            i12 = i10 + 1;
        }
        if (cCharAt == ',') {
            int i21 = this.f4395bp + i6;
            this.f4395bp = i21;
            this.f4396ch = charAt(i21);
            this.matchStat = 3;
            return collectionNewCollectionByType;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return null;
        }
        int i22 = i6 + 1;
        char cCharAt4 = charAt(this.f4395bp + i6);
        if (cCharAt4 == ',') {
            this.token = 16;
            int i23 = this.f4395bp + i22;
            this.f4395bp = i23;
            this.f4396ch = charAt(i23);
        } else if (cCharAt4 == ']') {
            this.token = 15;
            int i24 = this.f4395bp + i22;
            this.f4395bp = i24;
            this.f4396ch = charAt(i24);
        } else if (cCharAt4 == '}') {
            this.token = 13;
            int i25 = this.f4395bp + i22;
            this.f4395bp = i25;
            this.f4396ch = charAt(i25);
        } else {
            if (cCharAt4 != 26) {
                this.matchStat = -1;
                return null;
            }
            this.f4395bp += i6;
            this.token = 20;
            this.f4396ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return collectionNewCollectionByType;
    }

    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i6 = length + 1;
        if (charAt(this.f4395bp + length) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j10 = TypeUtils.fnv1a_64_magic_hashcode;
        while (true) {
            int i10 = i6 + 1;
            char cCharAt = charAt(this.f4395bp + i6);
            if (cCharAt == '\"') {
                int i11 = i6 + 2;
                char cCharAt2 = charAt(this.f4395bp + i10);
                if (cCharAt2 == ',') {
                    int i12 = this.f4395bp + i11;
                    this.f4395bp = i12;
                    this.f4396ch = charAt(i12);
                    this.matchStat = 3;
                    return j10;
                }
                if (cCharAt2 != '}') {
                    this.matchStat = -1;
                    return 0L;
                }
                int i13 = i6 + 3;
                char cCharAt3 = charAt(this.f4395bp + i11);
                if (cCharAt3 == ',') {
                    this.token = 16;
                    int i14 = this.f4395bp + i13;
                    this.f4395bp = i14;
                    this.f4396ch = charAt(i14);
                } else if (cCharAt3 == ']') {
                    this.token = 15;
                    int i15 = this.f4395bp + i13;
                    this.f4395bp = i15;
                    this.f4396ch = charAt(i15);
                } else if (cCharAt3 == '}') {
                    this.token = 13;
                    int i16 = this.f4395bp + i13;
                    this.f4395bp = i16;
                    this.f4396ch = charAt(i16);
                } else {
                    if (cCharAt3 != 26) {
                        this.matchStat = -1;
                        return 0L;
                    }
                    this.token = 20;
                    this.f4395bp = i6 + 2 + this.f4395bp;
                    this.f4396ch = JSONLexer.EOI;
                }
                this.matchStat = 4;
                return j10;
            }
            j10 = (j10 ^ ((long) cCharAt)) * TypeUtils.fnv1a_64_magic_prime;
            if (cCharAt == '\\') {
                this.matchStat = -1;
                return 0L;
            }
            i6 = i10;
        }
    }

    public UUID scanFieldUUID(char[] cArr) {
        int i6;
        char cCharAt;
        UUID uuid;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i17 = length + 1;
        char cCharAt2 = charAt(this.f4395bp + length);
        char c5 = 4;
        if (cCharAt2 != '\"') {
            if (cCharAt2 == 'n') {
                int i18 = length + 2;
                if (charAt(this.f4395bp + i17) == 'u') {
                    int i19 = length + 3;
                    if (charAt(this.f4395bp + i18) == 'l') {
                        int i20 = length + 4;
                        if (charAt(this.f4395bp + i19) == 'l') {
                            i6 = length + 5;
                            cCharAt = charAt(this.f4395bp + i20);
                            uuid = null;
                        }
                    }
                }
            }
            this.matchStat = -1;
            return null;
        }
        int iIndexOf = indexOf('\"', this.f4395bp + cArr.length + 1);
        if (iIndexOf == -1) {
            throw new JSONException("unclosed str");
        }
        int length2 = this.f4395bp + cArr.length + 1;
        int i21 = iIndexOf - length2;
        char c8 = 'F';
        char c10 = 'A';
        char c11 = 'f';
        char c12 = 'a';
        char c13 = '9';
        if (i21 == 36) {
            int i22 = 0;
            long j10 = 0;
            while (i22 < 8) {
                char cCharAt3 = charAt(length2 + i22);
                if (cCharAt3 >= '0' && cCharAt3 <= '9') {
                    i16 = cCharAt3 - '0';
                } else if (cCharAt3 >= 'a' && cCharAt3 <= 'f') {
                    i16 = cCharAt3 - 'W';
                } else {
                    if (cCharAt3 < 'A' || cCharAt3 > 'F') {
                        this.matchStat = -2;
                        return null;
                    }
                    i16 = cCharAt3 - '7';
                }
                j10 = (j10 << c5) | ((long) i16);
                i22++;
                c5 = 4;
            }
            for (int i23 = 9; i23 < 13; i23++) {
                char cCharAt4 = charAt(length2 + i23);
                if (cCharAt4 >= '0' && cCharAt4 <= '9') {
                    i15 = cCharAt4 - '0';
                } else if (cCharAt4 >= 'a' && cCharAt4 <= 'f') {
                    i15 = cCharAt4 - 'W';
                } else {
                    if (cCharAt4 < 'A' || cCharAt4 > 'F') {
                        this.matchStat = -2;
                        return null;
                    }
                    i15 = cCharAt4 - '7';
                }
                j10 = (j10 << 4) | ((long) i15);
            }
            int i24 = 14;
            long j11 = j10;
            while (i24 < 18) {
                char cCharAt5 = charAt(length2 + i24);
                if (cCharAt5 >= '0' && cCharAt5 <= '9') {
                    i14 = cCharAt5 - '0';
                } else if (cCharAt5 >= 'a' && cCharAt5 <= 'f') {
                    i14 = cCharAt5 - 'W';
                } else {
                    if (cCharAt5 < 'A' || cCharAt5 > c8) {
                        this.matchStat = -2;
                        return null;
                    }
                    i14 = cCharAt5 - '7';
                }
                j11 = (j11 << 4) | ((long) i14);
                i24++;
                iIndexOf = iIndexOf;
                c8 = 'F';
            }
            int i25 = iIndexOf;
            int i26 = 19;
            long j12 = 0;
            while (i26 < 23) {
                char cCharAt6 = charAt(length2 + i26);
                if (cCharAt6 >= '0' && cCharAt6 <= '9') {
                    i13 = cCharAt6 - '0';
                } else if (cCharAt6 >= 'a' && cCharAt6 <= c11) {
                    i13 = cCharAt6 - 'W';
                } else {
                    if (cCharAt6 < c10 || cCharAt6 > 'F') {
                        this.matchStat = -2;
                        return null;
                    }
                    i13 = cCharAt6 - '7';
                }
                j12 = (j12 << 4) | ((long) i13);
                i26++;
                c10 = 'A';
                c11 = 'f';
            }
            int i27 = 24;
            long j13 = j12;
            int i28 = 36;
            while (i27 < i28) {
                char cCharAt7 = charAt(length2 + i27);
                if (cCharAt7 >= '0' && cCharAt7 <= c13) {
                    i12 = cCharAt7 - '0';
                } else if (cCharAt7 >= c12 && cCharAt7 <= 'f') {
                    i12 = cCharAt7 - 'W';
                } else {
                    if (cCharAt7 < 'A' || cCharAt7 > 'F') {
                        this.matchStat = -2;
                        return null;
                    }
                    i12 = cCharAt7 - '7';
                }
                j13 = (j13 << 4) | ((long) i12);
                i27++;
                i28 = 36;
                c13 = '9';
                c12 = 'a';
            }
            uuid = new UUID(j11, j13);
            int i29 = this.f4395bp;
            int length3 = (i25 - ((cArr.length + i29) + 1)) + 1 + i17;
            i6 = length3 + 1;
            cCharAt = charAt(i29 + length3);
        } else {
            if (i21 != 32) {
                this.matchStat = -1;
                return null;
            }
            int i30 = 0;
            long j14 = 0;
            for (int i31 = 16; i30 < i31; i31 = 16) {
                char cCharAt8 = charAt(length2 + i30);
                if (cCharAt8 >= '0' && cCharAt8 <= '9') {
                    i11 = cCharAt8 - '0';
                } else if (cCharAt8 >= 'a' && cCharAt8 <= 'f') {
                    i11 = cCharAt8 - 'W';
                } else {
                    if (cCharAt8 < 'A' || cCharAt8 > 'F') {
                        this.matchStat = -2;
                        return null;
                    }
                    i11 = cCharAt8 - '7';
                }
                j14 = (j14 << 4) | ((long) i11);
                i30++;
            }
            int i32 = 16;
            long j15 = 0;
            for (int i33 = 32; i32 < i33; i33 = 32) {
                char cCharAt9 = charAt(length2 + i32);
                if (cCharAt9 < '0' || cCharAt9 > '9') {
                    if (cCharAt9 >= 'a' && cCharAt9 <= 'f') {
                        i10 = cCharAt9 - 'W';
                    } else {
                        if (cCharAt9 < 'A' || cCharAt9 > 'F') {
                            this.matchStat = -2;
                            return null;
                        }
                        i10 = cCharAt9 - '7';
                    }
                    j15 = (j15 << 4) | ((long) i10);
                    i32++;
                } else {
                    i10 = cCharAt9 - '0';
                }
                j15 = (j15 << 4) | ((long) i10);
                i32++;
            }
            uuid = new UUID(j14, j15);
            int i34 = this.f4395bp;
            int length4 = (iIndexOf - ((cArr.length + i34) + 1)) + 1 + i17;
            i6 = length4 + 1;
            cCharAt = charAt(i34 + length4);
        }
        if (cCharAt == ',') {
            int i35 = this.f4395bp + i6;
            this.f4395bp = i35;
            this.f4396ch = charAt(i35);
            this.matchStat = 3;
            return uuid;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return null;
        }
        int i36 = i6 + 1;
        char cCharAt10 = charAt(this.f4395bp + i6);
        if (cCharAt10 == ',') {
            this.token = 16;
            int i37 = this.f4395bp + i36;
            this.f4395bp = i37;
            this.f4396ch = charAt(i37);
        } else if (cCharAt10 == ']') {
            this.token = 15;
            int i38 = this.f4395bp + i36;
            this.f4395bp = i38;
            this.f4396ch = charAt(i38);
        } else if (cCharAt10 == '}') {
            this.token = 13;
            int i39 = this.f4395bp + i36;
            this.f4395bp = i39;
            this.f4396ch = charAt(i39);
        } else {
            if (cCharAt10 != 26) {
                this.matchStat = -1;
                return null;
            }
            this.token = 20;
            this.f4395bp += i6;
            this.f4396ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return uuid;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override
    public final float scanFloat(char r22) {
        /*
            Method dump skipped, instruction units count: 427
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFloat(char):float");
    }

    public final void scanHex() {
        char next;
        if (this.f4396ch != 'x') {
            throw new JSONException("illegal state. " + this.f4396ch);
        }
        next();
        if (this.f4396ch != '\'') {
            throw new JSONException("illegal state. " + this.f4396ch);
        }
        this.f4397np = this.f4395bp;
        next();
        if (this.f4396ch == '\'') {
            next();
            this.token = 26;
            return;
        }
        while (true) {
            next = next();
            if ((next < '0' || next > '9') && (next < 'A' || next > 'F')) {
                break;
            } else {
                this.f4398sp++;
            }
        }
        if (next != '\'') {
            throw new JSONException("illegal state. " + next);
        }
        this.f4398sp++;
        next();
        this.token = 26;
    }

    public final void scanIdent() {
        this.f4397np = this.f4395bp - 1;
        this.hasSpecial = false;
        do {
            this.f4398sp++;
            next();
        } while (Character.isLetterOrDigit(this.f4396ch));
        String strStringVal = stringVal();
        if ("null".equalsIgnoreCase(strStringVal)) {
            this.token = 8;
            return;
        }
        if ("new".equals(strStringVal)) {
            this.token = 9;
            return;
        }
        if ("true".equals(strStringVal)) {
            this.token = 6;
            return;
        }
        if ("false".equals(strStringVal)) {
            this.token = 7;
            return;
        }
        if ("undefined".equals(strStringVal)) {
            this.token = 23;
            return;
        }
        if ("Set".equals(strStringVal)) {
            this.token = 21;
        } else if ("TreeSet".equals(strStringVal)) {
            this.token = 22;
        } else {
            this.token = 18;
        }
    }

    @Override
    public int scanInt(char c5) {
        int i6;
        int i10;
        char cCharAt;
        this.matchStat = 0;
        char cCharAt2 = charAt(this.f4395bp);
        boolean z7 = cCharAt2 == '\"';
        if (z7) {
            cCharAt2 = charAt(this.f4395bp + 1);
            i6 = 2;
        } else {
            i6 = 1;
        }
        boolean z10 = cCharAt2 == '-';
        if (z10) {
            cCharAt2 = charAt(this.f4395bp + i6);
            i6++;
        }
        if (cCharAt2 >= '0' && cCharAt2 <= '9') {
            int i11 = cCharAt2 - '0';
            while (true) {
                i10 = i6 + 1;
                cCharAt = charAt(this.f4395bp + i6);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                i11 = (i11 * 10) + (cCharAt - '0');
                i6 = i10;
            }
            if (cCharAt == '.') {
                this.matchStat = -1;
                return 0;
            }
            if (i11 < 0) {
                this.matchStat = -1;
                return 0;
            }
            while (cCharAt != c5) {
                if (!isWhitespace(cCharAt)) {
                    this.matchStat = -1;
                    return z10 ? -i11 : i11;
                }
                char cCharAt3 = charAt(this.f4395bp + i10);
                i10++;
                cCharAt = cCharAt3;
            }
            int i12 = this.f4395bp + i10;
            this.f4395bp = i12;
            this.f4396ch = charAt(i12);
            this.matchStat = 3;
            this.token = 16;
            return z10 ? -i11 : i11;
        }
        if (cCharAt2 != 'n' || charAt(this.f4395bp + i6) != 'u' || AbstractC0004e.m10d(this.f4395bp, i6, 1, this) != 'l' || AbstractC0004e.m10d(this.f4395bp, i6, 2, this) != 'l') {
            this.matchStat = -1;
            return 0;
        }
        this.matchStat = 5;
        int i13 = i6 + 4;
        char cCharAt4 = charAt(this.f4395bp + i6 + 3);
        if (z7 && cCharAt4 == '\"') {
            cCharAt4 = charAt(this.f4395bp + i13);
            i13 = i6 + 5;
        }
        while (cCharAt4 != ',') {
            if (cCharAt4 == ']') {
                int i14 = this.f4395bp + i13;
                this.f4395bp = i14;
                this.f4396ch = charAt(i14);
                this.matchStat = 5;
                this.token = 15;
                return 0;
            }
            if (!isWhitespace(cCharAt4)) {
                this.matchStat = -1;
                return 0;
            }
            cCharAt4 = charAt(this.f4395bp + i13);
            i13++;
        }
        int i15 = this.f4395bp + i13;
        this.f4395bp = i15;
        this.f4396ch = charAt(i15);
        this.matchStat = 5;
        this.token = 16;
        return 0;
    }

    @Override
    public long scanLong(char c5) {
        int i6;
        int i10;
        char cCharAt;
        this.matchStat = 0;
        char cCharAt2 = charAt(this.f4395bp);
        boolean z7 = cCharAt2 == '\"';
        if (z7) {
            cCharAt2 = charAt(this.f4395bp + 1);
            i6 = 2;
        } else {
            i6 = 1;
        }
        boolean z10 = cCharAt2 == '-';
        if (z10) {
            cCharAt2 = charAt(this.f4395bp + i6);
            i6++;
        }
        if (cCharAt2 >= '0') {
            char c8 = '9';
            if (cCharAt2 <= '9') {
                long j10 = cCharAt2 - '0';
                while (true) {
                    i10 = i6 + 1;
                    cCharAt = charAt(this.f4395bp + i6);
                    if (cCharAt < '0' || cCharAt > c8) {
                        break;
                    }
                    j10 = (j10 * 10) + ((long) (cCharAt - '0'));
                    i6 = i10;
                    c8 = '9';
                }
                if (cCharAt == '.') {
                    this.matchStat = -1;
                    return 0L;
                }
                if (j10 < 0 && (j10 != Long.MIN_VALUE || !z10)) {
                    throw new NumberFormatException(subString(this.f4395bp, i6));
                }
                if (z7) {
                    if (cCharAt != '\"') {
                        this.matchStat = -1;
                        return 0L;
                    }
                    cCharAt = charAt(this.f4395bp + i10);
                    i10 = i6 + 2;
                }
                while (cCharAt != c5) {
                    if (!isWhitespace(cCharAt)) {
                        this.matchStat = -1;
                        return j10;
                    }
                    cCharAt = charAt(this.f4395bp + i10);
                    i10++;
                }
                int i11 = this.f4395bp + i10;
                this.f4395bp = i11;
                this.f4396ch = charAt(i11);
                this.matchStat = 3;
                this.token = 16;
                return z10 ? -j10 : j10;
            }
        }
        if (cCharAt2 != 'n' || charAt(this.f4395bp + i6) != 'u' || AbstractC0004e.m10d(this.f4395bp, i6, 1, this) != 'l' || AbstractC0004e.m10d(this.f4395bp, i6, 2, this) != 'l') {
            this.matchStat = -1;
            return 0L;
        }
        this.matchStat = 5;
        int i12 = i6 + 4;
        char cCharAt3 = charAt(this.f4395bp + i6 + 3);
        if (z7 && cCharAt3 == '\"') {
            cCharAt3 = charAt(this.f4395bp + i12);
            i12 = i6 + 5;
        }
        while (cCharAt3 != ',') {
            if (cCharAt3 == ']') {
                int i13 = this.f4395bp + i12;
                this.f4395bp = i13;
                this.f4396ch = charAt(i13);
                this.matchStat = 5;
                this.token = 15;
                return 0L;
            }
            if (!isWhitespace(cCharAt3)) {
                this.matchStat = -1;
                return 0L;
            }
            cCharAt3 = charAt(this.f4395bp + i12);
            i12++;
        }
        int i14 = this.f4395bp + i12;
        this.f4395bp = i14;
        this.f4396ch = charAt(i14);
        this.matchStat = 5;
        this.token = 16;
        return 0L;
    }

    public final void scanNullOrNew() {
        scanNullOrNew(true);
    }

    @Override
    public final void scanNumber() {
        char c5;
        boolean z7;
        char c8;
        this.f4397np = this.f4395bp;
        boolean z10 = true;
        if (this.f4396ch == '-') {
            this.f4398sp++;
            next();
        }
        while (true) {
            c5 = this.f4396ch;
            if (c5 < '0' || c5 > '9') {
                break;
            }
            this.f4398sp++;
            next();
        }
        if (c5 == '.') {
            this.f4398sp++;
            next();
            while (true) {
                char c10 = this.f4396ch;
                if (c10 < '0' || c10 > '9') {
                    break;
                }
                this.f4398sp++;
                next();
            }
            z7 = true;
        } else {
            z7 = false;
        }
        int i6 = this.f4398sp;
        if (i6 > 65535) {
            throw new JSONException("scanNumber overflow");
        }
        char c11 = this.f4396ch;
        if (c11 != 'L' && c11 != 'S' && c11 != 'B') {
            if (c11 == 'F' || c11 == 'D') {
                this.f4398sp = i6 + 1;
                next();
            } else if (c11 == 'e' || c11 == 'E') {
                this.f4398sp = i6 + 1;
                next();
                char c12 = this.f4396ch;
                if (c12 == '+' || c12 == '-') {
                    this.f4398sp++;
                    next();
                }
                while (true) {
                    c8 = this.f4396ch;
                    if (c8 < '0' || c8 > '9') {
                        break;
                    }
                    this.f4398sp++;
                    next();
                }
                if (c8 == 'D' || c8 == 'F') {
                    this.f4398sp++;
                    next();
                }
            }
            if (z10) {
                this.token = 3;
            } else {
                this.token = 2;
            }
        }
        this.f4398sp = i6 + 1;
        next();
        z10 = z7;
        if (z10) {
            this.token = 3;
        } else {
            this.token = 2;
        }
    }

    @Override
    public final void scanString() {
        this.f4397np = this.f4395bp;
        this.hasSpecial = false;
        while (true) {
            char next = next();
            if (next == '\"') {
                this.token = 4;
                this.f4396ch = next();
                return;
            }
            if (next == 26) {
                if (isEOF()) {
                    throw new JSONException("unclosed string : " + next);
                }
                putChar(JSONLexer.EOI);
            } else if (next == '\\') {
                if (!this.hasSpecial) {
                    this.hasSpecial = true;
                    int i6 = this.f4398sp;
                    char[] cArr = this.sbuf;
                    if (i6 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i6 <= length) {
                            i6 = length;
                        }
                        char[] cArr2 = new char[i6];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.sbuf = cArr2;
                    }
                    copyTo(this.f4397np + 1, this.f4398sp, this.sbuf);
                }
                char next2 = next();
                if (next2 == '\"') {
                    putChar('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            putChar('\\');
                        } else if (next2 == 'b') {
                            putChar('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                putChar('\n');
                            } else if (next2 == 'r') {
                                putChar('\r');
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        putChar('/');
                                        break;
                                    case NalUnitUtil.H265_NAL_UNIT_TYPE_UNSPECIFIED:
                                        putChar((char) 0);
                                        break;
                                    case Opcodes.V1_5:
                                        putChar((char) 1);
                                        break;
                                    case DefaultRenderersFactory.MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY:
                                        putChar((char) 2);
                                        break;
                                    case '3':
                                        putChar((char) 3);
                                        break;
                                    case '4':
                                        putChar((char) 4);
                                        break;
                                    case '5':
                                        putChar((char) 5);
                                        break;
                                    case Opcodes.ISTORE:
                                        putChar((char) 6);
                                        break;
                                    case Opcodes.LSTORE:
                                        putChar((char) 7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID:
                                                putChar('\t');
                                                break;
                                            case 'u':
                                                putChar((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                break;
                                            case 'v':
                                                putChar((char) 11);
                                                break;
                                            default:
                                                this.f4396ch = next2;
                                                throw new JSONException("unclosed string : " + next2);
                                        }
                                        break;
                                }
                            } else {
                                char next3 = next();
                                char next4 = next();
                                boolean z7 = (next3 >= '0' && next3 <= '9') || (next3 >= 'a' && next3 <= 'f') || (next3 >= 'A' && next3 <= 'F');
                                boolean z10 = (next4 >= '0' && next4 <= '9') || (next4 >= 'a' && next4 <= 'f') || (next4 >= 'A' && next4 <= 'F');
                                if (!z7 || !z10) {
                                    throw new JSONException("invalid escape character \\x" + next3 + next4);
                                }
                                int[] iArr = digits;
                                putChar((char) ((iArr[next3] * 16) + iArr[next4]));
                            }
                        }
                    }
                    putChar('\f');
                } else {
                    putChar('\'');
                }
            } else if (this.hasSpecial) {
                int i10 = this.f4398sp;
                char[] cArr3 = this.sbuf;
                if (i10 == cArr3.length) {
                    putChar(next);
                } else {
                    this.f4398sp = i10 + 1;
                    cArr3[i10] = next;
                }
            } else {
                this.f4398sp++;
            }
        }
    }

    @Override
    public void scanStringArray(Collection<String> collection, char c5) {
        int i6;
        char cCharAt;
        int i10;
        char cCharAt2;
        this.matchStat = 0;
        char cCharAt3 = charAt(this.f4395bp);
        char c8 = 'u';
        char c10 = 'l';
        int i11 = 2;
        if (cCharAt3 == 'n' && charAt(this.f4395bp + 1) == 'u' && charAt(this.f4395bp + 2) == 'l' && charAt(this.f4395bp + 3) == 'l' && charAt(this.f4395bp + 4) == c5) {
            int i12 = this.f4395bp + 5;
            this.f4395bp = i12;
            this.f4396ch = charAt(i12);
            this.matchStat = 5;
            return;
        }
        if (cCharAt3 != '[') {
            this.matchStat = -1;
            return;
        }
        char cCharAt4 = charAt(this.f4395bp + 1);
        int i13 = 2;
        while (true) {
            if (cCharAt4 == 'n' && charAt(this.f4395bp + i13) == c8 && AbstractC0004e.m10d(this.f4395bp, i13, 1, this) == c10 && AbstractC0004e.m10d(this.f4395bp, i13, i11, this) == c10) {
                int i14 = i13 + 3;
                i6 = i13 + 4;
                cCharAt = charAt(this.f4395bp + i14);
                collection.add(null);
            } else {
                if (cCharAt4 == ']' && collection.size() == 0) {
                    i10 = i13 + 1;
                    cCharAt2 = charAt(this.f4395bp + i13);
                    break;
                }
                if (cCharAt4 != '\"') {
                    this.matchStat = -1;
                    return;
                }
                int i15 = this.f4395bp + i13;
                int iIndexOf = indexOf('\"', i15);
                if (iIndexOf == -1) {
                    throw new JSONException("unclosed str");
                }
                String strSubString = subString(this.f4395bp + i13, iIndexOf - i15);
                if (strSubString.indexOf(92) != -1) {
                    while (true) {
                        int i16 = 0;
                        for (int i17 = iIndexOf - 1; i17 >= 0 && charAt(i17) == '\\'; i17--) {
                            i16++;
                        }
                        if (i16 % 2 == 0) {
                            break;
                        } else {
                            iIndexOf = indexOf('\"', iIndexOf + 1);
                        }
                    }
                    int i18 = iIndexOf - i15;
                    strSubString = readString(sub_chars(this.f4395bp + i13, i18), i18);
                }
                int i19 = this.f4395bp;
                int i20 = (iIndexOf - (i19 + i13)) + 1 + i13;
                i6 = i20 + 1;
                cCharAt = charAt(i19 + i20);
                collection.add(strSubString);
            }
            if (cCharAt != ',') {
                if (cCharAt == ']') {
                    i10 = i6 + 1;
                    cCharAt2 = charAt(this.f4395bp + i6);
                    break;
                } else {
                    this.matchStat = -1;
                    return;
                }
            }
            char cCharAt5 = charAt(this.f4395bp + i6);
            i13 = i6 + 1;
            c8 = 'u';
            c10 = 'l';
            i11 = 2;
            cCharAt4 = cCharAt5;
        }
        if (cCharAt2 != c5) {
            this.matchStat = -1;
            return;
        }
        int i21 = this.f4395bp + i10;
        this.f4395bp = i21;
        this.f4396ch = charAt(i21);
        this.matchStat = 3;
    }

    @Override
    public final String scanSymbol(SymbolTable symbolTable) {
        skipWhitespace();
        char c5 = this.f4396ch;
        if (c5 == '\"') {
            return scanSymbol(symbolTable, '\"');
        }
        if (c5 == '\'') {
            if (isEnabled(Feature.AllowSingleQuotes)) {
                return scanSymbol(symbolTable, '\'');
            }
            throw new JSONException("syntax error");
        }
        if (c5 == '}') {
            next();
            this.token = 13;
            return null;
        }
        if (c5 == ',') {
            next();
            this.token = 16;
            return null;
        }
        if (c5 == 26) {
            this.token = 20;
            return null;
        }
        if (isEnabled(Feature.AllowUnQuotedFieldNames)) {
            return scanSymbolUnQuoted(symbolTable);
        }
        throw new JSONException("syntax error");
    }

    @Override
    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        if (this.token == 1 && this.pos == 0 && this.f4395bp == 1) {
            this.f4395bp = 0;
        }
        boolean[] zArr = IOUtils.firstIdentifierFlags;
        int i6 = this.f4396ch;
        if (i6 < zArr.length && !zArr[i6]) {
            throw new JSONException("illegal identifier : " + this.f4396ch + info());
        }
        boolean[] zArr2 = IOUtils.identifierFlags;
        this.f4397np = this.f4395bp;
        this.f4398sp = 1;
        while (true) {
            char next = next();
            if (next < zArr2.length && !zArr2[next]) {
                break;
            }
            i6 = (i6 * 31) + next;
            this.f4398sp++;
        }
        this.f4396ch = charAt(this.f4395bp);
        this.token = 18;
        if (this.f4398sp == 4 && i6 == 3392903 && charAt(this.f4397np) == 'n' && charAt(this.f4397np + 1) == 'u' && charAt(this.f4397np + 2) == 'l' && charAt(this.f4397np + 3) == 'l') {
            return null;
        }
        return symbolTable == null ? subString(this.f4397np, this.f4398sp) : addSymbol(this.f4397np, this.f4398sp, i6, symbolTable);
    }

    @Override
    public String scanSymbolWithSeperator(SymbolTable symbolTable, char c5) {
        int i6 = 0;
        this.matchStat = 0;
        char cCharAt = charAt(this.f4395bp);
        if (cCharAt == 'n') {
            if (charAt(this.f4395bp + 1) != 'u' || charAt(this.f4395bp + 2) != 'l' || charAt(this.f4395bp + 3) != 'l') {
                this.matchStat = -1;
                return null;
            }
            if (charAt(this.f4395bp + 4) != c5) {
                this.matchStat = -1;
                return null;
            }
            int i10 = this.f4395bp + 5;
            this.f4395bp = i10;
            this.f4396ch = charAt(i10);
            this.matchStat = 3;
            return null;
        }
        if (cCharAt != '\"') {
            this.matchStat = -1;
            return null;
        }
        int i11 = 1;
        while (true) {
            int i12 = i11 + 1;
            char cCharAt2 = charAt(this.f4395bp + i11);
            if (cCharAt2 == '\"') {
                int i13 = this.f4395bp;
                int i14 = i13 + 1;
                String strAddSymbol = addSymbol(i14, AbstractC0004e.m13g(i13, i12, i14, 1), i6, symbolTable);
                int i15 = i11 + 2;
                char cCharAt3 = charAt(this.f4395bp + i12);
                while (cCharAt3 != c5) {
                    if (!isWhitespace(cCharAt3)) {
                        this.matchStat = -1;
                        return strAddSymbol;
                    }
                    cCharAt3 = charAt(this.f4395bp + i15);
                    i15++;
                }
                int i16 = this.f4395bp + i15;
                this.f4395bp = i16;
                this.f4396ch = charAt(i16);
                this.matchStat = 3;
                return strAddSymbol;
            }
            i6 = (i6 * 31) + cCharAt2;
            if (cCharAt2 == '\\') {
                this.matchStat = -1;
                return null;
            }
            i11 = i12;
        }
    }

    public final void scanTrue() {
        if (this.f4396ch != 't') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.f4396ch != 'r') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.f4396ch != 'u') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.f4396ch != 'e') {
            throw new JSONException("error parse true");
        }
        next();
        char c5 = this.f4396ch;
        if (c5 != ' ' && c5 != ',' && c5 != '}' && c5 != ']' && c5 != '\n' && c5 != '\r' && c5 != '\t' && c5 != 26 && c5 != '\f' && c5 != '\b' && c5 != ':' && c5 != '/') {
            throw new JSONException("scan true error");
        }
        this.token = 6;
    }

    public final int scanType(String str) {
        int i6;
        this.matchStat = 0;
        char[] cArr = typeFieldName;
        if (!charArrayCompare(cArr)) {
            return -2;
        }
        int length = this.f4395bp + cArr.length;
        int length2 = str.length();
        for (int i10 = 0; i10 < length2; i10++) {
            if (str.charAt(i10) != charAt(length + i10)) {
                return -1;
            }
        }
        int i11 = length + length2;
        if (charAt(i11) != '\"') {
            return -1;
        }
        int i12 = i11 + 1;
        char cCharAt = charAt(i12);
        this.f4396ch = cCharAt;
        if (cCharAt == ',') {
            int i13 = i11 + 2;
            this.f4396ch = charAt(i13);
            this.f4395bp = i13;
            this.token = 16;
            return 3;
        }
        if (cCharAt == '}') {
            i12 = i11 + 2;
            char cCharAt2 = charAt(i12);
            this.f4396ch = cCharAt2;
            if (cCharAt2 == ',') {
                this.token = 16;
                i6 = i11 + 3;
                this.f4396ch = charAt(i6);
            } else if (cCharAt2 == ']') {
                this.token = 15;
                i6 = i11 + 3;
                this.f4396ch = charAt(i6);
            } else {
                if (cCharAt2 == '}') {
                    this.token = 13;
                    i6 = i11 + 3;
                    this.f4396ch = charAt(i6);
                } else {
                    if (cCharAt2 != 26) {
                        return -1;
                    }
                    this.token = 20;
                }
                this.matchStat = 4;
            }
            i12 = i6;
            this.matchStat = 4;
        }
        this.f4395bp = i12;
        return this.matchStat;
    }

    @Override
    public String scanTypeName(SymbolTable symbolTable) {
        return null;
    }

    public UUID scanUUID(char c5) {
        char cCharAt;
        int i6;
        UUID uuid;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        this.matchStat = 0;
        char cCharAt2 = charAt(this.f4395bp);
        if (cCharAt2 == '\"') {
            int iIndexOf = indexOf('\"', this.f4395bp + 1);
            if (iIndexOf == -1) {
                throw new JSONException("unclosed str");
            }
            int i17 = this.f4395bp + 1;
            int i18 = iIndexOf - i17;
            char c8 = 'A';
            char c10 = 'f';
            char c11 = 'a';
            char c12 = '9';
            if (i18 == 36) {
                int i19 = 0;
                long j10 = 0;
                while (i19 < 8) {
                    char cCharAt3 = charAt(i17 + i19);
                    if (cCharAt3 >= '0' && cCharAt3 <= '9') {
                        i16 = cCharAt3 - '0';
                    } else if (cCharAt3 >= 'a' && cCharAt3 <= 'f') {
                        i16 = cCharAt3 - 'W';
                    } else {
                        if (cCharAt3 < c8 || cCharAt3 > 'F') {
                            this.matchStat = -2;
                            return null;
                        }
                        i16 = cCharAt3 - '7';
                    }
                    j10 = (j10 << 4) | ((long) i16);
                    i19++;
                    iIndexOf = iIndexOf;
                    c8 = 'A';
                }
                int i20 = iIndexOf;
                int i21 = 9;
                while (i21 < 13) {
                    char cCharAt4 = charAt(i17 + i21);
                    if (cCharAt4 >= '0' && cCharAt4 <= '9') {
                        i15 = cCharAt4 - '0';
                    } else if (cCharAt4 >= 'a' && cCharAt4 <= c10) {
                        i15 = cCharAt4 - 'W';
                    } else {
                        if (cCharAt4 < 'A' || cCharAt4 > 'F') {
                            this.matchStat = -2;
                            return null;
                        }
                        i15 = cCharAt4 - '7';
                    }
                    j10 = (j10 << 4) | ((long) i15);
                    i21++;
                    c10 = 'f';
                }
                int i22 = 14;
                long j11 = j10;
                while (i22 < 18) {
                    char cCharAt5 = charAt(i17 + i22);
                    if (cCharAt5 >= '0' && cCharAt5 <= c12) {
                        i14 = cCharAt5 - '0';
                    } else if (cCharAt5 >= 'a' && cCharAt5 <= 'f') {
                        i14 = cCharAt5 - 'W';
                    } else {
                        if (cCharAt5 < 'A' || cCharAt5 > 'F') {
                            this.matchStat = -2;
                            return null;
                        }
                        i14 = cCharAt5 - '7';
                    }
                    j11 = (j11 << 4) | ((long) i14);
                    i22++;
                    c12 = '9';
                }
                int i23 = 19;
                long j12 = 0;
                while (i23 < 23) {
                    char cCharAt6 = charAt(i17 + i23);
                    if (cCharAt6 >= '0' && cCharAt6 <= '9') {
                        i13 = cCharAt6 - '0';
                    } else if (cCharAt6 >= c11 && cCharAt6 <= 'f') {
                        i13 = cCharAt6 - 'W';
                    } else {
                        if (cCharAt6 < 'A' || cCharAt6 > 'F') {
                            this.matchStat = -2;
                            return null;
                        }
                        i13 = cCharAt6 - '7';
                    }
                    j12 = (j12 << 4) | ((long) i13);
                    i23++;
                    c11 = 'a';
                }
                long j13 = j12;
                for (int i24 = 24; i24 < 36; i24++) {
                    char cCharAt7 = charAt(i17 + i24);
                    if (cCharAt7 >= '0' && cCharAt7 <= '9') {
                        i12 = cCharAt7 - '0';
                    } else if (cCharAt7 >= 'a' && cCharAt7 <= 'f') {
                        i12 = cCharAt7 - 'W';
                    } else {
                        if (cCharAt7 < 'A' || cCharAt7 > 'F') {
                            this.matchStat = -2;
                            return null;
                        }
                        i12 = cCharAt7 - '7';
                    }
                    j13 = (j13 << 4) | ((long) i12);
                }
                uuid = new UUID(j11, j13);
                int i25 = this.f4395bp;
                int i26 = i20 - (i25 + 1);
                int i27 = i26 + 2;
                i6 = i26 + 3;
                cCharAt = charAt(i25 + i27);
            } else {
                if (i18 != 32) {
                    this.matchStat = -1;
                    return null;
                }
                int i28 = 0;
                long j14 = 0;
                for (int i29 = 16; i28 < i29; i29 = 16) {
                    char cCharAt8 = charAt(i17 + i28);
                    if (cCharAt8 >= '0' && cCharAt8 <= '9') {
                        i11 = cCharAt8 - '0';
                    } else if (cCharAt8 >= 'a' && cCharAt8 <= 'f') {
                        i11 = cCharAt8 - 'W';
                    } else {
                        if (cCharAt8 < 'A' || cCharAt8 > 'F') {
                            this.matchStat = -2;
                            return null;
                        }
                        i11 = cCharAt8 - '7';
                    }
                    j14 = (j14 << 4) | ((long) i11);
                    i28++;
                }
                int i30 = 16;
                long j15 = 0;
                for (int i31 = 32; i30 < i31; i31 = 32) {
                    char cCharAt9 = charAt(i17 + i30);
                    if (cCharAt9 < '0' || cCharAt9 > '9') {
                        if (cCharAt9 >= 'a' && cCharAt9 <= 'f') {
                            i10 = cCharAt9 - 'W';
                        } else {
                            if (cCharAt9 < 'A' || cCharAt9 > 'F') {
                                this.matchStat = -2;
                                return null;
                            }
                            i10 = cCharAt9 - '7';
                        }
                        j15 = (j15 << 4) | ((long) i10);
                        i30++;
                    } else {
                        i10 = cCharAt9 - '0';
                    }
                    j15 = (j15 << 4) | ((long) i10);
                    i30++;
                }
                uuid = new UUID(j14, j15);
                int i32 = this.f4395bp;
                int i33 = iIndexOf - (i32 + 1);
                int i34 = i33 + 2;
                i6 = i33 + 3;
                cCharAt = charAt(i32 + i34);
            }
        } else {
            if (cCharAt2 != 'n' || charAt(this.f4395bp + 1) != 'u' || charAt(this.f4395bp + 2) != 'l' || charAt(this.f4395bp + 3) != 'l') {
                this.matchStat = -1;
                return null;
            }
            cCharAt = charAt(this.f4395bp + 4);
            i6 = 5;
            uuid = null;
        }
        if (cCharAt == ',') {
            int i35 = this.f4395bp + i6;
            this.f4395bp = i35;
            this.f4396ch = charAt(i35);
            this.matchStat = 3;
            return uuid;
        }
        if (cCharAt != ']') {
            this.matchStat = -1;
            return null;
        }
        int i36 = i6 + 1;
        char cCharAt10 = charAt(this.f4395bp + i6);
        if (cCharAt10 == ',') {
            this.token = 16;
            int i37 = this.f4395bp + i36;
            this.f4395bp = i37;
            this.f4396ch = charAt(i37);
        } else if (cCharAt10 == ']') {
            this.token = 15;
            int i38 = this.f4395bp + i36;
            this.f4395bp = i38;
            this.f4396ch = charAt(i38);
        } else if (cCharAt10 == '}') {
            this.token = 13;
            int i39 = this.f4395bp + i36;
            this.f4395bp = i39;
            this.f4396ch = charAt(i39);
        } else {
            if (cCharAt10 != 26) {
                this.matchStat = -1;
                return null;
            }
            this.token = 20;
            this.f4395bp += i6;
            this.f4396ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return uuid;
    }

    public boolean seekArrayToItem(int i6) {
        throw new UnsupportedOperationException();
    }

    public int seekObjectToField(long j10, boolean z7) {
        throw new UnsupportedOperationException();
    }

    public int seekObjectToFieldDeepScan(long j10) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setFeatures(int i6) {
        this.features = i6;
    }

    @Override
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override
    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public void setToken(int i6) {
        this.token = i6;
    }

    public void skipArray() {
        throw new UnsupportedOperationException();
    }

    public void skipComment() {
        char c5;
        next();
        char c8 = this.f4396ch;
        if (c8 == '/') {
            do {
                next();
                c5 = this.f4396ch;
                if (c5 == '\n') {
                    next();
                    return;
                }
            } while (c5 != 26);
            return;
        }
        if (c8 != '*') {
            throw new JSONException("invalid comment");
        }
        next();
        while (true) {
            char c10 = this.f4396ch;
            if (c10 == 26) {
                return;
            }
            if (c10 == '*') {
                next();
                if (this.f4396ch == '/') {
                    next();
                    return;
                }
            } else {
                next();
            }
        }
    }

    public void skipObject() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void skipWhitespace() {
        while (true) {
            char c5 = this.f4396ch;
            if (c5 > '/') {
                return;
            }
            if (c5 == ' ' || c5 == '\r' || c5 == '\n' || c5 == '\t' || c5 == '\f' || c5 == '\b') {
                next();
            } else if (c5 != '/') {
                return;
            } else {
                skipComment();
            }
        }
    }

    public final String stringDefaultValue() {
        return this.stringDefaultValue;
    }

    @Override
    public abstract String stringVal();

    public abstract String subString(int i6, int i10);

    public abstract char[] sub_chars(int i6, int i10);

    @Override
    public final int token() {
        return this.token;
    }

    @Override
    public final String tokenName() {
        return JSONToken.name(this.token);
    }

    @Override
    public final boolean isEnabled(int i6) {
        return (i6 & this.features) != 0;
    }

    @Override
    public final void nextTokenWithColon(int i6) {
        nextTokenWithChar(':');
    }

    public final void scanNullOrNew(boolean z7) {
        if (this.f4396ch != 'n') {
            throw new JSONException("error parse null or new");
        }
        next();
        char c5 = this.f4396ch;
        if (c5 != 'u') {
            if (c5 != 'e') {
                throw new JSONException("error parse new");
            }
            next();
            if (this.f4396ch != 'w') {
                throw new JSONException("error parse new");
            }
            next();
            char c8 = this.f4396ch;
            if (c8 != ' ' && c8 != ',' && c8 != '}' && c8 != ']' && c8 != '\n' && c8 != '\r' && c8 != '\t' && c8 != 26 && c8 != '\f' && c8 != '\b') {
                throw new JSONException("scan new error");
            }
            this.token = 9;
            return;
        }
        next();
        if (this.f4396ch != 'l') {
            throw new JSONException("error parse null");
        }
        next();
        if (this.f4396ch != 'l') {
            throw new JSONException("error parse null");
        }
        next();
        char c10 = this.f4396ch;
        if (c10 != ' ' && c10 != ',' && c10 != '}' && c10 != ']' && c10 != '\n' && c10 != '\r' && c10 != '\t' && c10 != 26 && ((c10 != ':' || !z7) && c10 != '\f' && c10 != '\b')) {
            throw new JSONException("scan null error");
        }
        this.token = 8;
    }

    public int seekObjectToField(long[] jArr) {
        throw new UnsupportedOperationException();
    }

    public void skipObject(boolean z7) {
        throw new UnsupportedOperationException();
    }

    public final boolean isEnabled(int i6, int i10) {
        return ((this.features & i10) == 0 && (i6 & i10) == 0) ? false : true;
    }

    public int matchField(long j10) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final String scanSymbol(SymbolTable symbolTable, char c5) {
        String strAddSymbol;
        this.f4397np = this.f4395bp;
        this.f4398sp = 0;
        boolean z7 = false;
        int i6 = 0;
        while (true) {
            char next = next();
            if (next == c5) {
                this.token = 4;
                if (!z7) {
                    int i10 = this.f4397np;
                    strAddSymbol = addSymbol(i10 == -1 ? 0 : i10 + 1, this.f4398sp, i6, symbolTable);
                } else {
                    strAddSymbol = symbolTable.addSymbol(this.sbuf, 0, this.f4398sp, i6);
                }
                this.f4398sp = 0;
                next();
                return strAddSymbol;
            }
            if (next == 26) {
                throw new JSONException("unclosed.str");
            }
            if (next == '\\') {
                if (!z7) {
                    int i11 = this.f4398sp;
                    char[] cArr = this.sbuf;
                    if (i11 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i11 <= length) {
                            i11 = length;
                        }
                        char[] cArr2 = new char[i11];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.sbuf = cArr2;
                    }
                    arrayCopy(this.f4397np + 1, this.sbuf, 0, this.f4398sp);
                    z7 = true;
                }
                char next2 = next();
                if (next2 == '\"') {
                    i6 = (i6 * 31) + 34;
                    putChar('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            i6 = (i6 * 31) + 92;
                            putChar('\\');
                        } else if (next2 == 'b') {
                            i6 = (i6 * 31) + 8;
                            putChar('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                i6 = (i6 * 31) + 10;
                                putChar('\n');
                            } else if (next2 == 'r') {
                                i6 = (i6 * 31) + 13;
                                putChar('\r');
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        i6 = (i6 * 31) + 47;
                                        putChar('/');
                                        break;
                                    case NalUnitUtil.H265_NAL_UNIT_TYPE_UNSPECIFIED:
                                        i6 = (i6 * 31) + next2;
                                        putChar((char) 0);
                                        break;
                                    case Opcodes.V1_5:
                                        i6 = (i6 * 31) + next2;
                                        putChar((char) 1);
                                        break;
                                    case DefaultRenderersFactory.MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY:
                                        i6 = (i6 * 31) + next2;
                                        putChar((char) 2);
                                        break;
                                    case '3':
                                        i6 = (i6 * 31) + next2;
                                        putChar((char) 3);
                                        break;
                                    case '4':
                                        i6 = (i6 * 31) + next2;
                                        putChar((char) 4);
                                        break;
                                    case '5':
                                        i6 = (i6 * 31) + next2;
                                        putChar((char) 5);
                                        break;
                                    case Opcodes.ISTORE:
                                        i6 = (i6 * 31) + next2;
                                        putChar((char) 6);
                                        break;
                                    case Opcodes.LSTORE:
                                        i6 = (i6 * 31) + next2;
                                        putChar((char) 7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID:
                                                i6 = (i6 * 31) + 9;
                                                putChar('\t');
                                                break;
                                            case 'u':
                                                int i12 = Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
                                                i6 = (i6 * 31) + i12;
                                                putChar((char) i12);
                                                break;
                                            case 'v':
                                                i6 = (i6 * 31) + 11;
                                                putChar((char) 11);
                                                break;
                                            default:
                                                this.f4396ch = next2;
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                        break;
                                }
                            } else {
                                char next3 = next();
                                this.f4396ch = next3;
                                char next4 = next();
                                this.f4396ch = next4;
                                int[] iArr = digits;
                                char c8 = (char) ((iArr[next3] * 16) + iArr[next4]);
                                i6 = (i6 * 31) + c8;
                                putChar(c8);
                            }
                        }
                    }
                    i6 = (i6 * 31) + 12;
                    putChar('\f');
                } else {
                    i6 = (i6 * 31) + 39;
                    putChar('\'');
                }
            } else {
                i6 = (i6 * 31) + next;
                if (!z7) {
                    this.f4398sp++;
                } else {
                    int i13 = this.f4398sp;
                    char[] cArr3 = this.sbuf;
                    if (i13 == cArr3.length) {
                        putChar(next);
                    } else {
                        this.f4398sp = i13 + 1;
                        cArr3[i13] = next;
                    }
                }
            }
        }
    }

    @Override
    public final void nextToken(int i6) {
        this.f4398sp = 0;
        while (true) {
            if (i6 == 2) {
                char c5 = this.f4396ch;
                if (c5 >= '0' && c5 <= '9') {
                    this.pos = this.f4395bp;
                    scanNumber();
                    return;
                }
                if (c5 == '\"') {
                    this.pos = this.f4395bp;
                    scanString();
                    return;
                } else if (c5 == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c5 == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            } else if (i6 == 4) {
                char c8 = this.f4396ch;
                if (c8 == '\"') {
                    this.pos = this.f4395bp;
                    scanString();
                    return;
                }
                if (c8 >= '0' && c8 <= '9') {
                    this.pos = this.f4395bp;
                    scanNumber();
                    return;
                } else if (c8 == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c8 == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            } else if (i6 != 12) {
                if (i6 == 18) {
                    nextIdent();
                    return;
                }
                if (i6 != 20) {
                    switch (i6) {
                        case 14:
                            char c10 = this.f4396ch;
                            if (c10 == '[') {
                                this.token = 14;
                                next();
                            } else if (c10 == '{') {
                                this.token = 12;
                                next();
                            }
                            break;
                        case 15:
                            if (this.f4396ch == ']') {
                                this.token = 15;
                                next();
                            }
                            if (this.f4396ch == 26) {
                                this.token = 20;
                            }
                            break;
                        case 16:
                            char c11 = this.f4396ch;
                            if (c11 == ',') {
                                this.token = 16;
                                next();
                            } else if (c11 == '}') {
                                this.token = 13;
                                next();
                            } else if (c11 == ']') {
                                this.token = 15;
                                next();
                            } else if (c11 == 26) {
                                this.token = 20;
                            } else if (c11 == 'n') {
                                scanNullOrNew(false);
                            }
                            break;
                    }
                    return;
                }
                if (this.f4396ch == 26) {
                    this.token = 20;
                    return;
                }
            } else {
                char c12 = this.f4396ch;
                if (c12 == '{') {
                    this.token = 12;
                    next();
                    return;
                } else if (c12 == '[') {
                    this.token = 14;
                    next();
                    return;
                }
            }
            char c13 = this.f4396ch;
            if (c13 != ' ' && c13 != '\n' && c13 != '\r' && c13 != '\t' && c13 != '\f' && c13 != '\b') {
                nextToken();
                return;
            }
            next();
        }
    }

    @Override
    public String scanString(char c5) {
        this.matchStat = 0;
        char cCharAt = charAt(this.f4395bp);
        if (cCharAt == 'n') {
            if (charAt(this.f4395bp + 1) == 'u' && charAt(this.f4395bp + 2) == 'l' && charAt(this.f4395bp + 3) == 'l') {
                if (charAt(this.f4395bp + 4) == c5) {
                    int i6 = this.f4395bp + 5;
                    this.f4395bp = i6;
                    this.f4396ch = charAt(i6);
                    this.matchStat = 3;
                    return null;
                }
                this.matchStat = -1;
                return null;
            }
            this.matchStat = -1;
            return null;
        }
        int i10 = 1;
        while (cCharAt != '\"') {
            if (isWhitespace(cCharAt)) {
                cCharAt = charAt(this.f4395bp + i10);
                i10++;
            } else {
                this.matchStat = -1;
                return stringDefaultValue();
            }
        }
        int i11 = this.f4395bp + i10;
        int iIndexOf = indexOf('\"', i11);
        if (iIndexOf != -1) {
            String strSubString = subString(this.f4395bp + i10, iIndexOf - i11);
            if (strSubString.indexOf(92) != -1) {
                while (true) {
                    int i12 = 0;
                    for (int i13 = iIndexOf - 1; i13 >= 0 && charAt(i13) == '\\'; i13--) {
                        i12++;
                    }
                    if (i12 % 2 == 0) {
                        break;
                    }
                    iIndexOf = indexOf('\"', iIndexOf + 1);
                }
                int i14 = iIndexOf - i11;
                strSubString = readString(sub_chars(this.f4395bp + 1, i14), i14);
            }
            int i15 = (iIndexOf - i11) + 1 + i10;
            int i16 = i15 + 1;
            char cCharAt2 = charAt(this.f4395bp + i15);
            while (cCharAt2 != c5) {
                if (!isWhitespace(cCharAt2)) {
                    if (cCharAt2 == ']') {
                        int i17 = this.f4395bp + i16;
                        this.f4395bp = i17;
                        this.f4396ch = charAt(i17);
                        this.matchStat = -1;
                    }
                    return strSubString;
                }
                cCharAt2 = charAt(this.f4395bp + i16);
                i16++;
            }
            int i18 = this.f4395bp + i16;
            this.f4395bp = i18;
            this.f4396ch = charAt(i18);
            this.matchStat = 3;
            this.token = 16;
            return strSubString;
        }
        throw new JSONException("unclosed str");
    }

    public String[] scanFieldStringArray(char[] cArr, int i6, SymbolTable symbolTable) {
        throw new UnsupportedOperationException();
    }
}

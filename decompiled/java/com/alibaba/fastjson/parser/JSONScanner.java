package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import p000a.AbstractC0004e;

public final class JSONScanner extends JSONLexerBase {
    private final int len;
    private final String text;

    public JSONScanner(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    public static boolean charArrayCompare(String str, int i6, char[] cArr) {
        int length = cArr.length;
        if (length + i6 > str.length()) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            if (cArr[i10] != str.charAt(i6 + i10)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDate(char c5, char c8, char c10, char c11, char c12, char c13, int i6, int i10) {
        if (c5 >= '0' && c5 <= '9' && c8 >= '0' && c8 <= '9' && c10 >= '0' && c10 <= '9' && c11 >= '0' && c11 <= '9') {
            if (c12 == '0') {
                if (c13 < '1' || c13 > '9') {
                    return false;
                }
            } else if (c12 != '1' || (c13 != '0' && c13 != '1' && c13 != '2')) {
                return false;
            }
            if (i6 == 48) {
                return i10 >= 49 && i10 <= 57;
            }
            if (i6 != 49 && i6 != 50) {
                return i6 == 51 && (i10 == 48 || i10 == 49);
            }
            if (i10 >= 48 && i10 <= 57) {
                return true;
            }
        }
        return false;
    }

    private boolean checkTime(char c5, char c8, char c10, char c11, char c12, char c13) {
        if (c5 == '0') {
            if (c8 < '0' || c8 > '9') {
                return false;
            }
        } else {
            if (c5 != '1') {
                if (c5 == '2' && c8 >= '0' && c8 <= '4') {
                }
                return false;
            }
            if (c8 < '0' || c8 > '9') {
                return false;
            }
        }
        if (c10 < '0' || c10 > '5') {
            if (c10 != '6' || c11 != '0') {
                return false;
            }
        } else if (c11 < '0' || c11 > '9') {
            return false;
        }
        if (c12 < '0' || c12 > '5') {
            return c12 == '6' && c13 == '0';
        }
        return c13 >= '0' && c13 <= '9';
    }

    private void setCalendar(char c5, char c8, char c10, char c11, char c12, char c13, char c14, char c15) {
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar = calendar;
        int i6 = c11 - '0';
        calendar.set(1, i6 + ((c10 - '0') * 10) + ((c8 - '0') * 100) + ((c5 - '0') * 1000));
        this.calendar.set(2, ((c13 - '0') + ((c12 - '0') * 10)) - 1);
        this.calendar.set(5, (c15 - '0') + ((c14 - '0') * 10));
    }

    @Override
    public final String addSymbol(int i6, int i10, int i11, SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.text, i6, i10, i11);
    }

    @Override
    public final void arrayCopy(int i6, char[] cArr, int i10, int i11) {
        this.text.getChars(i6, i11 + i6, cArr, i10);
    }

    @Override
    public byte[] bytesValue() {
        if (this.token != 26) {
            return !this.hasSpecial ? IOUtils.decodeBase64(this.text, this.f4397np + 1, this.f4398sp) : IOUtils.decodeBase64(new String(this.sbuf, 0, this.f4398sp));
        }
        int i6 = this.f4397np + 1;
        int i10 = this.f4398sp;
        if (i10 % 2 != 0) {
            throw new JSONException(AbstractC0004e.m20n(i10, "illegal state. "));
        }
        int i11 = i10 / 2;
        byte[] bArr = new byte[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = (i12 * 2) + i6;
            char cCharAt = this.text.charAt(i13);
            char cCharAt2 = this.text.charAt(i13 + 1);
            char c5 = '7';
            int i14 = cCharAt - (cCharAt <= '9' ? '0' : '7');
            if (cCharAt2 <= '9') {
                c5 = '0';
            }
            bArr[i12] = (byte) ((i14 << 4) | (cCharAt2 - c5));
        }
        return bArr;
    }

    @Override
    public final char charAt(int i6) {
        return i6 >= this.len ? JSONLexer.EOI : this.text.charAt(i6);
    }

    @Override
    public final void copyTo(int i6, int i10, char[] cArr) {
        this.text.getChars(i6, i10 + i6, cArr, 0);
    }

    @Override
    public final BigDecimal decimalValue() {
        char cCharAt = charAt((this.f4397np + this.f4398sp) - 1);
        int i6 = this.f4398sp;
        if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B' || cCharAt == 'F' || cCharAt == 'D') {
            i6--;
        }
        if (i6 > 65535) {
            throw new JSONException("decimal overflow");
        }
        int i10 = this.f4397np;
        char[] cArr = this.sbuf;
        if (i6 < cArr.length) {
            this.text.getChars(i10, i10 + i6, cArr, 0);
            return new BigDecimal(this.sbuf, 0, i6, MathContext.UNLIMITED);
        }
        char[] cArr2 = new char[i6];
        this.text.getChars(i10, i10 + i6, cArr2, 0);
        return new BigDecimal(cArr2, 0, i6, MathContext.UNLIMITED);
    }

    @Override
    public final int indexOf(char c5, int i6) {
        return this.text.indexOf(c5, i6);
    }

    @Override
    public String info() {
        StringBuilder sb = new StringBuilder();
        int i6 = 0;
        int i10 = 1;
        int i11 = 1;
        while (i6 < this.f4395bp) {
            if (this.text.charAt(i6) == '\n') {
                i10++;
                i11 = 1;
            }
            i6++;
            i11++;
        }
        sb.append("pos ");
        sb.append(this.f4395bp);
        sb.append(", line ");
        sb.append(i10);
        sb.append(", column ");
        sb.append(i11);
        if (this.text.length() < 65535) {
            sb.append(this.text);
        } else {
            sb.append(this.text.substring(0, 65535));
        }
        return sb.toString();
    }

    @Override
    public boolean isEOF() {
        int i6 = this.f4395bp;
        int i10 = this.len;
        if (i6 != i10) {
            return this.f4396ch == 26 && i6 + 1 >= i10;
        }
        return true;
    }

    @Override
    public boolean matchField2(char[] cArr) {
        while (JSONLexerBase.isWhitespace(this.f4396ch)) {
            next();
        }
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = this.f4395bp + cArr.length;
        int i6 = length + 1;
        char cCharAt = this.text.charAt(length);
        while (JSONLexerBase.isWhitespace(cCharAt)) {
            cCharAt = this.text.charAt(i6);
            i6++;
        }
        if (cCharAt != ':') {
            this.matchStat = -2;
            return false;
        }
        this.f4395bp = i6;
        this.f4396ch = charAt(i6);
        return true;
    }

    @Override
    public final char next() {
        int i6 = this.f4395bp + 1;
        this.f4395bp = i6;
        char cCharAt = i6 >= this.len ? JSONLexer.EOI : this.text.charAt(i6);
        this.f4396ch = cCharAt;
        return cCharAt;
    }

    @Override
    public final String numberString() {
        char cCharAt = charAt((this.f4397np + this.f4398sp) - 1);
        int i6 = this.f4398sp;
        if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B' || cCharAt == 'F' || cCharAt == 'D') {
            i6--;
        }
        return subString(this.f4397np, i6);
    }

    @Override
    public Date scanDate(char c5) {
        char cCharAt;
        long j10;
        Date date;
        char cCharAt2;
        boolean z7 = false;
        this.matchStat = 0;
        int i6 = this.f4395bp;
        char c8 = this.f4396ch;
        int i10 = i6 + 1;
        char cCharAt3 = charAt(i6);
        if (cCharAt3 == '\"') {
            int iIndexOf = indexOf('\"', i10);
            if (iIndexOf == -1) {
                throw new JSONException("unclosed str");
            }
            this.f4395bp = i10;
            if (!scanISO8601DateIfMatch(false, iIndexOf - i10)) {
                this.f4395bp = i6;
                this.f4396ch = c8;
                this.matchStat = -1;
                return null;
            }
            date = this.calendar.getTime();
            cCharAt = charAt(iIndexOf + 1);
            this.f4395bp = i6;
            while (cCharAt != ',' && cCharAt != ']') {
                if (!JSONLexerBase.isWhitespace(cCharAt)) {
                    this.f4395bp = i6;
                    this.f4396ch = c8;
                    this.matchStat = -1;
                    return null;
                }
                int i11 = iIndexOf + 1;
                char cCharAt4 = charAt(iIndexOf + 2);
                iIndexOf = i11;
                cCharAt = cCharAt4;
            }
            this.f4395bp = iIndexOf + 1;
            this.f4396ch = cCharAt;
        } else {
            char c10 = '9';
            char c11 = '0';
            if (cCharAt3 != '-' && (cCharAt3 < '0' || cCharAt3 > '9')) {
                if (cCharAt3 == 'n') {
                    int i12 = i6 + 2;
                    if (charAt(i10) == 'u') {
                        int i13 = i6 + 3;
                        if (charAt(i12) == 'l') {
                            int i14 = i6 + 4;
                            if (charAt(i13) == 'l') {
                                cCharAt = charAt(i14);
                                this.f4395bp = i14;
                                date = null;
                            }
                        }
                    }
                }
                this.f4395bp = i6;
                this.f4396ch = c8;
                this.matchStat = -1;
                return null;
            }
            if (cCharAt3 == '-') {
                cCharAt3 = charAt(i10);
                i10 = i6 + 2;
                z7 = true;
            }
            if (cCharAt3 < '0' || cCharAt3 > '9') {
                cCharAt = cCharAt3;
                j10 = 0;
            } else {
                j10 = cCharAt3 - '0';
                while (true) {
                    int i15 = i10 + 1;
                    cCharAt2 = charAt(i10);
                    if (cCharAt2 < c11 || cCharAt2 > c10) {
                        break;
                    }
                    j10 = (j10 * 10) + ((long) (cCharAt2 - '0'));
                    i10 = i15;
                    c10 = '9';
                    c11 = '0';
                }
                if (cCharAt2 == ',' || cCharAt2 == ']') {
                    this.f4395bp = i10;
                }
                cCharAt = cCharAt2;
            }
            if (j10 < 0) {
                this.f4395bp = i6;
                this.f4396ch = c8;
                this.matchStat = -1;
                return null;
            }
            if (z7) {
                j10 = -j10;
            }
            date = new Date(j10);
        }
        if (cCharAt == ',') {
            int i16 = this.f4395bp + 1;
            this.f4395bp = i16;
            this.f4396ch = charAt(i16);
            this.matchStat = 3;
            return date;
        }
        int i17 = this.f4395bp + 1;
        this.f4395bp = i17;
        char cCharAt5 = charAt(i17);
        if (cCharAt5 == ',') {
            this.token = 16;
            int i18 = this.f4395bp + 1;
            this.f4395bp = i18;
            this.f4396ch = charAt(i18);
        } else if (cCharAt5 == ']') {
            this.token = 15;
            int i19 = this.f4395bp + 1;
            this.f4395bp = i19;
            this.f4396ch = charAt(i19);
        } else if (cCharAt5 == '}') {
            this.token = 13;
            int i20 = this.f4395bp + 1;
            this.f4395bp = i20;
            this.f4396ch = charAt(i20);
        } else {
            if (cCharAt5 != 26) {
                this.f4395bp = i6;
                this.f4396ch = c8;
                this.matchStat = -1;
                return null;
            }
            this.f4396ch = JSONLexer.EOI;
            this.token = 20;
        }
        this.matchStat = 4;
        return date;
    }

    @Override
    public double scanDouble(char c5) {
        int i6;
        char cCharAt;
        long j10;
        int i10;
        int i11;
        double d;
        char cCharAt2;
        this.matchStat = 0;
        int i12 = this.f4395bp;
        int i13 = i12 + 1;
        char cCharAt3 = charAt(i12);
        boolean z7 = cCharAt3 == '\"';
        if (z7) {
            cCharAt3 = charAt(i13);
            i13 = i12 + 2;
        }
        boolean z10 = cCharAt3 == '-';
        if (z10) {
            cCharAt3 = charAt(i13);
            i13++;
        }
        if (cCharAt3 >= '0') {
            char c8 = '9';
            if (cCharAt3 <= '9') {
                long j11 = cCharAt3 - '0';
                while (true) {
                    i6 = i13 + 1;
                    cCharAt = charAt(i13);
                    if (cCharAt < '0' || cCharAt > '9') {
                        break;
                    }
                    j11 = (j11 * 10) + ((long) (cCharAt - '0'));
                    i13 = i6;
                }
                if (cCharAt == '.') {
                    int i14 = i13 + 2;
                    char cCharAt4 = charAt(i6);
                    if (cCharAt4 < '0' || cCharAt4 > '9') {
                        this.matchStat = -1;
                        return 0.0d;
                    }
                    j11 = (j11 * 10) + ((long) (cCharAt4 - '0'));
                    long j12 = 10;
                    while (true) {
                        i6 = i14 + 1;
                        cCharAt2 = charAt(i14);
                        if (cCharAt2 < '0' || cCharAt2 > c8) {
                            break;
                        }
                        j11 = (j11 * 10) + ((long) (cCharAt2 - '0'));
                        j12 *= 10;
                        i14 = i6;
                        c8 = '9';
                    }
                    long j13 = j12;
                    cCharAt = cCharAt2;
                    j10 = j13;
                } else {
                    j10 = 1;
                }
                boolean z11 = cCharAt == 'e' || cCharAt == 'E';
                if (z11) {
                    int i15 = i6 + 1;
                    char cCharAt5 = charAt(i6);
                    if (cCharAt5 == '+' || cCharAt5 == '-') {
                        i6 += 2;
                        cCharAt = charAt(i15);
                    } else {
                        i6 = i15;
                        cCharAt = cCharAt5;
                    }
                    while (cCharAt >= '0' && cCharAt <= '9') {
                        int i16 = i6 + 1;
                        char cCharAt6 = charAt(i6);
                        i6 = i16;
                        cCharAt = cCharAt6;
                    }
                }
                if (!z7) {
                    i10 = this.f4395bp;
                    i11 = (i6 - i10) - 1;
                } else {
                    if (cCharAt != '\"') {
                        this.matchStat = -1;
                        return 0.0d;
                    }
                    int i17 = i6 + 1;
                    char cCharAt7 = charAt(i6);
                    i10 = this.f4395bp + 1;
                    i11 = (i17 - i10) - 2;
                    i6 = i17;
                    cCharAt = cCharAt7;
                }
                if (z11 || i11 >= 18) {
                    d = Double.parseDouble(subString(i10, i11));
                } else {
                    d = j11 / j10;
                    if (z10) {
                        d = -d;
                    }
                }
                if (cCharAt != c5) {
                    this.matchStat = -1;
                    return d;
                }
                this.f4395bp = i6;
                this.f4396ch = charAt(i6);
                this.matchStat = 3;
                this.token = 16;
                return d;
            }
        }
        if (cCharAt3 == 'n') {
            int i18 = i13 + 1;
            if (charAt(i13) == 'u') {
                int i19 = i13 + 2;
                if (charAt(i18) == 'l') {
                    int i20 = i13 + 3;
                    if (charAt(i19) == 'l') {
                        this.matchStat = 5;
                        int i21 = i13 + 4;
                        char cCharAt8 = charAt(i20);
                        if (z7 && cCharAt8 == '\"') {
                            cCharAt8 = charAt(i21);
                            i21 = i13 + 5;
                        }
                        while (cCharAt8 != ',') {
                            if (cCharAt8 == ']') {
                                this.f4395bp = i21;
                                this.f4396ch = charAt(i21);
                                this.matchStat = 5;
                                this.token = 15;
                                return 0.0d;
                            }
                            if (!JSONLexerBase.isWhitespace(cCharAt8)) {
                                this.matchStat = -1;
                                return 0.0d;
                            }
                            char cCharAt9 = charAt(i21);
                            i21++;
                            cCharAt8 = cCharAt9;
                        }
                        this.f4395bp = i21;
                        this.f4396ch = charAt(i21);
                        this.matchStat = 5;
                        this.token = 16;
                        return 0.0d;
                    }
                }
            }
        }
        this.matchStat = -1;
        return 0.0d;
    }

    @Override
    public boolean scanFieldBoolean(char[] cArr) {
        char cCharAt;
        boolean z7;
        char cCharAt2;
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.f4395bp, cArr)) {
            this.matchStat = -2;
            return false;
        }
        int i6 = this.f4395bp;
        int length = cArr.length + i6;
        int i10 = length + 1;
        char cCharAt3 = charAt(length);
        boolean z10 = cCharAt3 == '\"';
        if (z10) {
            cCharAt3 = charAt(i10);
            i10 = length + 2;
        }
        if (cCharAt3 != 't') {
            if (cCharAt3 == 'f') {
                int i11 = i10 + 1;
                if (charAt(i10) != 'a') {
                    this.matchStat = -1;
                    return false;
                }
                int i12 = i10 + 2;
                if (charAt(i11) != 'l') {
                    this.matchStat = -1;
                    return false;
                }
                int i13 = i10 + 3;
                if (charAt(i12) != 's') {
                    this.matchStat = -1;
                    return false;
                }
                int i14 = i10 + 4;
                if (charAt(i13) != 'e') {
                    this.matchStat = -1;
                    return false;
                }
                if (z10) {
                    int i15 = i10 + 5;
                    if (charAt(i14) != '\"') {
                        this.matchStat = -1;
                        return false;
                    }
                    i14 = i15;
                }
                this.f4395bp = i14;
                cCharAt = charAt(i14);
            } else if (cCharAt3 == '1') {
                if (z10) {
                    int i16 = i10 + 1;
                    if (charAt(i10) != '\"') {
                        this.matchStat = -1;
                        return false;
                    }
                    i10 = i16;
                }
                this.f4395bp = i10;
                cCharAt = charAt(i10);
            } else {
                if (cCharAt3 != '0') {
                    this.matchStat = -1;
                    return false;
                }
                if (z10) {
                    int i17 = i10 + 1;
                    if (charAt(i10) != '\"') {
                        this.matchStat = -1;
                        return false;
                    }
                    i10 = i17;
                }
                this.f4395bp = i10;
                cCharAt = charAt(i10);
            }
            z7 = false;
            while (cCharAt != ',') {
                if (cCharAt == '}') {
                    int i18 = this.f4395bp + 1;
                    this.f4395bp = i18;
                    cCharAt2 = charAt(i18);
                    while (cCharAt2 != ',') {
                        if (cCharAt2 == ']') {
                            this.token = 15;
                            int i19 = this.f4395bp + 1;
                            this.f4395bp = i19;
                            this.f4396ch = charAt(i19);
                        } else if (cCharAt2 == '}') {
                            this.token = 13;
                            int i20 = this.f4395bp + 1;
                            this.f4395bp = i20;
                            this.f4396ch = charAt(i20);
                        } else if (cCharAt2 == 26) {
                            this.token = 20;
                        } else {
                            if (JSONLexerBase.isWhitespace(cCharAt2)) {
                                this.matchStat = -1;
                                return false;
                            }
                            int i21 = this.f4395bp + 1;
                            this.f4395bp = i21;
                            cCharAt2 = charAt(i21);
                        }
                        this.matchStat = 4;
                        return z7;
                    }
                    this.token = 16;
                    int i22 = this.f4395bp + 1;
                    this.f4395bp = i22;
                    this.f4396ch = charAt(i22);
                    this.matchStat = 4;
                    return z7;
                }
                if (JSONLexerBase.isWhitespace(cCharAt)) {
                    this.f4395bp = i6;
                    charAt(i6);
                    this.matchStat = -1;
                    return false;
                }
                int i23 = this.f4395bp + 1;
                this.f4395bp = i23;
                cCharAt = charAt(i23);
            }
            int i24 = this.f4395bp + 1;
            this.f4395bp = i24;
            this.f4396ch = charAt(i24);
            this.matchStat = 3;
            this.token = 16;
            return z7;
        }
        int i25 = i10 + 1;
        if (charAt(i10) != 'r') {
            this.matchStat = -1;
            return false;
        }
        int i26 = i10 + 2;
        if (charAt(i25) != 'u') {
            this.matchStat = -1;
            return false;
        }
        int i27 = i10 + 3;
        if (charAt(i26) != 'e') {
            this.matchStat = -1;
            return false;
        }
        if (z10) {
            int i28 = i10 + 4;
            if (charAt(i27) != '\"') {
                this.matchStat = -1;
                return false;
            }
            i27 = i28;
        }
        this.f4395bp = i27;
        cCharAt = charAt(i27);
        z7 = true;
        while (cCharAt != ',') {
            if (cCharAt == '}') {
                int i110 = this.f4395bp + 1;
                this.f4395bp = i110;
                cCharAt2 = charAt(i110);
                while (cCharAt2 != ',') {
                    if (cCharAt2 == ']') {
                        this.token = 15;
                        int i111 = this.f4395bp + 1;
                        this.f4395bp = i111;
                        this.f4396ch = charAt(i111);
                    } else if (cCharAt2 == '}') {
                        this.token = 13;
                        int i29 = this.f4395bp + 1;
                        this.f4395bp = i29;
                        this.f4396ch = charAt(i29);
                    } else if (cCharAt2 == 26) {
                        this.token = 20;
                    } else {
                        if (JSONLexerBase.isWhitespace(cCharAt2)) {
                            this.matchStat = -1;
                            return false;
                        }
                        int i210 = this.f4395bp + 1;
                        this.f4395bp = i210;
                        cCharAt2 = charAt(i210);
                    }
                    this.matchStat = 4;
                    return z7;
                }
                this.token = 16;
                int i211 = this.f4395bp + 1;
                this.f4395bp = i211;
                this.f4396ch = charAt(i211);
                this.matchStat = 4;
                return z7;
            }
            if (JSONLexerBase.isWhitespace(cCharAt)) {
                this.f4395bp = i6;
                charAt(i6);
                this.matchStat = -1;
                return false;
            }
            int i212 = this.f4395bp + 1;
            this.f4395bp = i212;
            cCharAt = charAt(i212);
        }
        int i213 = this.f4395bp + 1;
        this.f4395bp = i213;
        this.f4396ch = charAt(i213);
        this.matchStat = 3;
        this.token = 16;
        return z7;
    }

    @Override
    public Date scanFieldDate(char[] cArr) {
        long j10;
        Date date;
        char cCharAt;
        char cCharAt2;
        boolean z7 = false;
        this.matchStat = 0;
        int i6 = this.f4395bp;
        char c5 = this.f4396ch;
        if (!charArrayCompare(this.text, i6, cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = this.f4395bp + cArr.length;
        int i10 = length + 1;
        char cCharAt3 = charAt(length);
        if (cCharAt3 == '\"') {
            int iIndexOf = indexOf('\"', i10);
            if (iIndexOf == -1) {
                throw new JSONException("unclosed str");
            }
            this.f4395bp = i10;
            if (!scanISO8601DateIfMatch(false, iIndexOf - i10)) {
                this.f4395bp = i6;
                this.matchStat = -1;
                return null;
            }
            date = this.calendar.getTime();
            cCharAt = charAt(iIndexOf + 1);
            this.f4395bp = i6;
            while (cCharAt != ',' && cCharAt != '}') {
                if (!JSONLexerBase.isWhitespace(cCharAt)) {
                    this.matchStat = -1;
                    return null;
                }
                int i11 = iIndexOf + 1;
                char cCharAt4 = charAt(iIndexOf + 2);
                iIndexOf = i11;
                cCharAt = cCharAt4;
            }
            this.f4395bp = iIndexOf + 1;
            this.f4396ch = cCharAt;
        } else {
            char c8 = '9';
            char c10 = '0';
            if (cCharAt3 != '-' && (cCharAt3 < '0' || cCharAt3 > '9')) {
                this.matchStat = -1;
                return null;
            }
            if (cCharAt3 == '-') {
                cCharAt3 = charAt(i10);
                i10 = length + 2;
                z7 = true;
            }
            if (cCharAt3 < '0' || cCharAt3 > '9') {
                j10 = 0;
            } else {
                long j11 = cCharAt3 - '0';
                while (true) {
                    int i12 = i10 + 1;
                    cCharAt2 = charAt(i10);
                    if (cCharAt2 < c10 || cCharAt2 > c8) {
                        break;
                    }
                    j11 = (j11 * 10) + ((long) (cCharAt2 - '0'));
                    i10 = i12;
                    c8 = '9';
                    c10 = '0';
                }
                if (cCharAt2 == ',' || cCharAt2 == '}') {
                    this.f4395bp = i10;
                }
                long j12 = j11;
                cCharAt3 = cCharAt2;
                j10 = j12;
            }
            if (j10 < 0) {
                this.matchStat = -1;
                return null;
            }
            if (z7) {
                j10 = -j10;
            }
            date = new Date(j10);
            cCharAt = cCharAt3;
        }
        if (cCharAt == ',') {
            int i13 = this.f4395bp + 1;
            this.f4395bp = i13;
            this.f4396ch = charAt(i13);
            this.matchStat = 3;
            this.token = 16;
            return date;
        }
        int i14 = this.f4395bp + 1;
        this.f4395bp = i14;
        char cCharAt5 = charAt(i14);
        if (cCharAt5 == ',') {
            this.token = 16;
            int i15 = this.f4395bp + 1;
            this.f4395bp = i15;
            this.f4396ch = charAt(i15);
        } else if (cCharAt5 == ']') {
            this.token = 15;
            int i16 = this.f4395bp + 1;
            this.f4395bp = i16;
            this.f4396ch = charAt(i16);
        } else if (cCharAt5 == '}') {
            this.token = 13;
            int i17 = this.f4395bp + 1;
            this.f4395bp = i17;
            this.f4396ch = charAt(i17);
        } else {
            if (cCharAt5 != 26) {
                this.f4395bp = i6;
                this.f4396ch = c5;
                this.matchStat = -1;
                return null;
            }
            this.token = 20;
        }
        this.matchStat = 4;
        return date;
    }

    @Override
    public int scanFieldInt(char[] cArr) {
        int i6;
        char cCharAt;
        this.matchStat = 0;
        int i10 = this.f4395bp;
        char c5 = this.f4396ch;
        if (!charArrayCompare(this.text, i10, cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = this.f4395bp + cArr.length;
        int i11 = length + 1;
        char cCharAt2 = charAt(length);
        boolean z7 = cCharAt2 == '\"';
        if (z7) {
            cCharAt2 = charAt(i11);
            i11 = length + 2;
        }
        boolean z10 = cCharAt2 == '-';
        if (z10) {
            cCharAt2 = charAt(i11);
            i11++;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i12 = cCharAt2 - '0';
        while (true) {
            i6 = i11 + 1;
            cCharAt = charAt(i11);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            int i13 = i12 * 10;
            if (i13 < i12) {
                this.matchStat = -1;
                return 0;
            }
            i12 = (cCharAt - '0') + i13;
            i11 = i6;
        }
        if (cCharAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (i12 < 0) {
            this.matchStat = -1;
            return 0;
        }
        if (z7) {
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return 0;
            }
            int i14 = i11 + 2;
            cCharAt = charAt(i6);
            i6 = i14;
        }
        while (cCharAt != ',' && cCharAt != '}') {
            if (!JSONLexerBase.isWhitespace(cCharAt)) {
                this.matchStat = -1;
                return 0;
            }
            int i15 = i6 + 1;
            cCharAt = charAt(i6);
            i6 = i15;
        }
        this.f4395bp = i6 - 1;
        if (cCharAt == ',') {
            this.f4395bp = i6;
            this.f4396ch = charAt(i6);
            this.matchStat = 3;
            this.token = 16;
            return z10 ? -i12 : i12;
        }
        if (cCharAt == '}') {
            this.f4395bp = i6;
            char cCharAt3 = charAt(i6);
            while (true) {
                if (cCharAt3 == ',') {
                    this.token = 16;
                    int i16 = this.f4395bp + 1;
                    this.f4395bp = i16;
                    this.f4396ch = charAt(i16);
                    break;
                }
                if (cCharAt3 == ']') {
                    this.token = 15;
                    int i17 = this.f4395bp + 1;
                    this.f4395bp = i17;
                    this.f4396ch = charAt(i17);
                    break;
                }
                if (cCharAt3 == '}') {
                    this.token = 13;
                    int i18 = this.f4395bp + 1;
                    this.f4395bp = i18;
                    this.f4396ch = charAt(i18);
                    break;
                }
                if (cCharAt3 == 26) {
                    this.token = 20;
                    break;
                }
                if (!JSONLexerBase.isWhitespace(cCharAt3)) {
                    this.f4395bp = i10;
                    this.f4396ch = c5;
                    this.matchStat = -1;
                    return 0;
                }
                int i19 = this.f4395bp + 1;
                this.f4395bp = i19;
                cCharAt3 = charAt(i19);
            }
            this.matchStat = 4;
        }
        return z10 ? -i12 : i12;
    }

    @Override
    public long scanFieldLong(char[] cArr) {
        int i6;
        char cCharAt;
        boolean z7 = false;
        this.matchStat = 0;
        int i10 = this.f4395bp;
        char c5 = this.f4396ch;
        if (!charArrayCompare(this.text, i10, cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = this.f4395bp + cArr.length;
        int i11 = length + 1;
        char cCharAt2 = charAt(length);
        boolean z10 = cCharAt2 == '\"';
        if (z10) {
            cCharAt2 = charAt(i11);
            i11 = length + 2;
        }
        if (cCharAt2 == '-') {
            cCharAt2 = charAt(i11);
            i11++;
            z7 = true;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            this.f4395bp = i10;
            this.f4396ch = c5;
            this.matchStat = -1;
            return 0L;
        }
        long j10 = cCharAt2 - '0';
        while (true) {
            i6 = i11 + 1;
            cCharAt = charAt(i11);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            j10 = (j10 * 10) + ((long) (cCharAt - '0'));
            i11 = i6;
        }
        if (cCharAt == '.') {
            this.matchStat = -1;
            return 0L;
        }
        if (z10) {
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return 0L;
            }
            cCharAt = charAt(i6);
            i6 = i11 + 2;
        }
        if (cCharAt == ',' || cCharAt == '}') {
            this.f4395bp = i6 - 1;
        }
        if (j10 < 0 && (j10 != Long.MIN_VALUE || !z7)) {
            this.f4395bp = i10;
            this.f4396ch = c5;
            this.matchStat = -1;
            return 0L;
        }
        while (cCharAt != ',') {
            if (cCharAt == '}') {
                int i12 = 1;
                int i13 = this.f4395bp + 1;
                this.f4395bp = i13;
                char cCharAt3 = charAt(i13);
                while (true) {
                    if (cCharAt3 == ',') {
                        this.token = 16;
                        int i14 = this.f4395bp + i12;
                        this.f4395bp = i14;
                        this.f4396ch = charAt(i14);
                        break;
                    }
                    if (cCharAt3 == ']') {
                        this.token = 15;
                        int i15 = this.f4395bp + i12;
                        this.f4395bp = i15;
                        this.f4396ch = charAt(i15);
                        break;
                    }
                    if (cCharAt3 == '}') {
                        this.token = 13;
                        int i16 = this.f4395bp + i12;
                        this.f4395bp = i16;
                        this.f4396ch = charAt(i16);
                        break;
                    }
                    if (cCharAt3 == 26) {
                        this.token = 20;
                        break;
                    }
                    if (!JSONLexerBase.isWhitespace(cCharAt3)) {
                        this.f4395bp = i10;
                        this.f4396ch = c5;
                        this.matchStat = -1;
                        return 0L;
                    }
                    int i17 = this.f4395bp + 1;
                    this.f4395bp = i17;
                    cCharAt3 = charAt(i17);
                    i12 = 1;
                }
                this.matchStat = 4;
                return z7 ? -j10 : j10;
            }
            if (!JSONLexerBase.isWhitespace(cCharAt)) {
                this.matchStat = -1;
                return 0L;
            }
            this.f4395bp = i6;
            cCharAt = charAt(i6);
            i6++;
        }
        int i18 = this.f4395bp + 1;
        this.f4395bp = i18;
        this.f4396ch = charAt(i18);
        this.matchStat = 3;
        this.token = 16;
        return z7 ? -j10 : j10;
    }

    @Override
    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        int i6 = this.f4395bp;
        char c5 = this.f4396ch;
        while (!charArrayCompare(this.text, this.f4395bp, cArr)) {
            if (!JSONLexerBase.isWhitespace(this.f4396ch)) {
                this.matchStat = -2;
                return stringDefaultValue();
            }
            next();
            while (JSONLexerBase.isWhitespace(this.f4396ch)) {
                next();
            }
        }
        int length = this.f4395bp + cArr.length;
        int i10 = length + 1;
        char cCharAt = charAt(length);
        int i11 = 0;
        if (cCharAt != '\"') {
            while (JSONLexerBase.isWhitespace(cCharAt)) {
                i11++;
                int i12 = i10 + 1;
                char cCharAt2 = charAt(i10);
                i10 = i12;
                cCharAt = cCharAt2;
            }
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return stringDefaultValue();
            }
        }
        int iIndexOf = indexOf('\"', i10);
        if (iIndexOf == -1) {
            throw new JSONException("unclosed str");
        }
        String strSubString = subString(i10, iIndexOf - i10);
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
            int length2 = iIndexOf - (((cArr.length + i15) + 1) + i11);
            strSubString = JSONLexerBase.readString(sub_chars(i15 + cArr.length + 1 + i11, length2), length2);
        }
        if ((this.features & Feature.TrimStringFieldValue.mask) != 0) {
            strSubString = strSubString.trim();
        }
        char cCharAt3 = charAt(iIndexOf + 1);
        while (cCharAt3 != ',' && cCharAt3 != '}') {
            if (!JSONLexerBase.isWhitespace(cCharAt3)) {
                this.matchStat = -1;
                return stringDefaultValue();
            }
            char cCharAt4 = charAt(iIndexOf + 2);
            iIndexOf++;
            cCharAt3 = cCharAt4;
        }
        this.f4395bp = iIndexOf + 1;
        this.f4396ch = cCharAt3;
        if (cCharAt3 == ',') {
            int i16 = iIndexOf + 2;
            this.f4395bp = i16;
            this.f4396ch = charAt(i16);
            this.matchStat = 3;
            return strSubString;
        }
        int i17 = iIndexOf + 2;
        this.f4395bp = i17;
        char cCharAt5 = charAt(i17);
        if (cCharAt5 == ',') {
            this.token = 16;
            int i18 = this.f4395bp + 1;
            this.f4395bp = i18;
            this.f4396ch = charAt(i18);
        } else if (cCharAt5 == ']') {
            this.token = 15;
            int i19 = this.f4395bp + 1;
            this.f4395bp = i19;
            this.f4396ch = charAt(i19);
        } else if (cCharAt5 == '}') {
            this.token = 13;
            int i20 = this.f4395bp + 1;
            this.f4395bp = i20;
            this.f4396ch = charAt(i20);
        } else {
            if (cCharAt5 != 26) {
                this.f4395bp = i6;
                this.f4396ch = c5;
                this.matchStat = -1;
                return stringDefaultValue();
            }
            this.token = 20;
        }
        this.matchStat = 4;
        return strSubString;
    }

    @Override
    public Collection<String> scanFieldStringArray(char[] cArr, Class<?> cls) {
        int i6;
        char cCharAt;
        int i10;
        char cCharAt2;
        this.matchStat = 0;
        while (true) {
            char c5 = this.f4396ch;
            if (c5 != '\n' && c5 != ' ') {
                break;
            }
            int i11 = this.f4395bp + 1;
            this.f4395bp = i11;
            this.f4396ch = i11 >= this.len ? JSONLexer.EOI : this.text.charAt(i11);
        }
        if (!charArrayCompare(this.text, this.f4395bp, cArr)) {
            this.matchStat = -2;
            return null;
        }
        Collection<String> collectionNewCollectionByType = newCollectionByType(cls);
        int i12 = this.f4395bp;
        char c8 = this.f4396ch;
        int length = cArr.length + i12;
        int i13 = length + 1;
        if (charAt(length) == '[') {
            int i14 = length + 2;
            char cCharAt3 = charAt(i13);
            while (true) {
                if (cCharAt3 == '\"') {
                    int iIndexOf = indexOf('\"', i14);
                    if (iIndexOf == -1) {
                        throw new JSONException("unclosed str");
                    }
                    String strSubString = subString(i14, iIndexOf - i14);
                    if (strSubString.indexOf(92) != -1) {
                        while (true) {
                            int i15 = 0;
                            for (int i16 = iIndexOf - 1; i16 >= 0 && charAt(i16) == '\\'; i16--) {
                                i15++;
                            }
                            if (i15 % 2 == 0) {
                                break;
                            }
                            iIndexOf = indexOf('\"', iIndexOf + 1);
                        }
                        int i17 = iIndexOf - i14;
                        strSubString = JSONLexerBase.readString(sub_chars(i14, i17), i17);
                    }
                    int i18 = iIndexOf + 1;
                    i10 = iIndexOf + 2;
                    cCharAt2 = charAt(i18);
                    collectionNewCollectionByType.add(strSubString);
                } else {
                    if (cCharAt3 != 'n' || !this.text.startsWith("ull", i14)) {
                        if (cCharAt3 != ']' || collectionNewCollectionByType.size() != 0) {
                            this.matchStat = -1;
                            return null;
                        }
                        cCharAt = charAt(i14);
                        i6 = i14 + 1;
                        break;
                    }
                    i10 = i14 + 4;
                    cCharAt2 = charAt(i14 + 3);
                    collectionNewCollectionByType.add(null);
                }
                if (cCharAt2 != ',') {
                    if (cCharAt2 != ']') {
                        this.matchStat = -1;
                        return null;
                    }
                    i6 = i10 + 1;
                    cCharAt = charAt(i10);
                    while (JSONLexerBase.isWhitespace(cCharAt)) {
                        cCharAt = charAt(i6);
                        i6++;
                    }
                    break;
                }
                i14 = i10 + 1;
                cCharAt3 = charAt(i10);
            }
        } else {
            if (!this.text.startsWith("ull", i13)) {
                this.matchStat = -1;
                return null;
            }
            int i19 = length + 4;
            i6 = length + 5;
            cCharAt = charAt(i19);
            collectionNewCollectionByType = null;
        }
        this.f4395bp = i6;
        if (cCharAt == ',') {
            this.f4396ch = charAt(i6);
            this.matchStat = 3;
            return collectionNewCollectionByType;
        }
        if (cCharAt != '}') {
            this.f4396ch = c8;
            this.f4395bp = i12;
            this.matchStat = -1;
            return null;
        }
        char cCharAt4 = charAt(i6);
        while (cCharAt4 != ',') {
            if (cCharAt4 == ']') {
                this.token = 15;
                int i20 = this.f4395bp + 1;
                this.f4395bp = i20;
                this.f4396ch = charAt(i20);
            } else if (cCharAt4 == '}') {
                this.token = 13;
                int i21 = this.f4395bp + 1;
                this.f4395bp = i21;
                this.f4396ch = charAt(i21);
            } else if (cCharAt4 == 26) {
                this.token = 20;
                this.f4396ch = cCharAt4;
            } else {
                boolean z7 = false;
                while (JSONLexerBase.isWhitespace(cCharAt4)) {
                    int i22 = i6 + 1;
                    char cCharAt5 = charAt(i6);
                    this.f4395bp = i22;
                    z7 = true;
                    cCharAt4 = cCharAt5;
                    i6 = i22;
                }
                if (!z7) {
                    this.matchStat = -1;
                    return null;
                }
            }
            this.matchStat = 4;
            return collectionNewCollectionByType;
        }
        this.token = 16;
        int i23 = this.f4395bp + 1;
        this.f4395bp = i23;
        this.f4396ch = charAt(i23);
        this.matchStat = 4;
        return collectionNewCollectionByType;
    }

    @Override
    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        while (!charArrayCompare(this.text, this.f4395bp, cArr)) {
            if (!JSONLexerBase.isWhitespace(this.f4396ch)) {
                this.matchStat = -2;
                return 0L;
            }
            next();
            while (JSONLexerBase.isWhitespace(this.f4396ch)) {
                next();
            }
        }
        int length = this.f4395bp + cArr.length;
        int i6 = length + 1;
        char cCharAt = charAt(length);
        if (cCharAt != '\"') {
            while (JSONLexerBase.isWhitespace(cCharAt)) {
                cCharAt = charAt(i6);
                i6++;
            }
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return 0L;
            }
        }
        long j10 = TypeUtils.fnv1a_64_magic_hashcode;
        while (true) {
            int i10 = i6 + 1;
            char cCharAt2 = charAt(i6);
            if (cCharAt2 == '\"') {
                this.f4395bp = i10;
                char cCharAt3 = charAt(i10);
                this.f4396ch = cCharAt3;
                while (cCharAt3 != ',') {
                    if (cCharAt3 == '}') {
                        next();
                        skipWhitespace();
                        char current = getCurrent();
                        if (current == ',') {
                            this.token = 16;
                            int i11 = this.f4395bp + 1;
                            this.f4395bp = i11;
                            this.f4396ch = charAt(i11);
                        } else if (current == ']') {
                            this.token = 15;
                            int i12 = this.f4395bp + 1;
                            this.f4395bp = i12;
                            this.f4396ch = charAt(i12);
                        } else if (current == '}') {
                            this.token = 13;
                            int i13 = this.f4395bp + 1;
                            this.f4395bp = i13;
                            this.f4396ch = charAt(i13);
                        } else {
                            if (current != 26) {
                                this.matchStat = -1;
                                return 0L;
                            }
                            this.token = 20;
                        }
                        this.matchStat = 4;
                        return j10;
                    }
                    if (!JSONLexerBase.isWhitespace(cCharAt3)) {
                        this.matchStat = -1;
                        return 0L;
                    }
                    int i14 = this.f4395bp + 1;
                    this.f4395bp = i14;
                    cCharAt3 = charAt(i14);
                }
                int i15 = this.f4395bp + 1;
                this.f4395bp = i15;
                this.f4396ch = charAt(i15);
                this.matchStat = 3;
                return j10;
            }
            if (i10 > this.len) {
                this.matchStat = -1;
                return 0L;
            }
            j10 = (j10 ^ ((long) cCharAt2)) * TypeUtils.fnv1a_64_magic_prime;
            i6 = i10;
        }
    }

    public boolean scanISO8601DateIfMatch() {
        return scanISO8601DateIfMatch(true);
    }

    @Override
    public final int scanInt(char c5) {
        int i6;
        char cCharAt;
        this.matchStat = 0;
        int i10 = this.f4395bp;
        int i11 = i10 + 1;
        char cCharAt2 = charAt(i10);
        while (JSONLexerBase.isWhitespace(cCharAt2)) {
            cCharAt2 = charAt(i11);
            i11++;
        }
        boolean z7 = cCharAt2 == '\"';
        if (z7) {
            cCharAt2 = charAt(i11);
            i11++;
        }
        boolean z10 = cCharAt2 == '-';
        if (z10) {
            cCharAt2 = charAt(i11);
            i11++;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            if (cCharAt2 == 'n') {
                int i12 = i11 + 1;
                if (charAt(i11) == 'u') {
                    int i13 = i11 + 2;
                    if (charAt(i12) == 'l') {
                        int i14 = i11 + 3;
                        if (charAt(i13) == 'l') {
                            this.matchStat = 5;
                            int i15 = i11 + 4;
                            char cCharAt3 = charAt(i14);
                            if (z7 && cCharAt3 == '\"') {
                                cCharAt3 = charAt(i15);
                                i15 = i11 + 5;
                            }
                            while (cCharAt3 != ',') {
                                if (cCharAt3 == ']') {
                                    this.f4395bp = i15;
                                    this.f4396ch = charAt(i15);
                                    this.matchStat = 5;
                                    this.token = 15;
                                    return 0;
                                }
                                if (!JSONLexerBase.isWhitespace(cCharAt3)) {
                                    this.matchStat = -1;
                                    return 0;
                                }
                                char cCharAt4 = charAt(i15);
                                i15++;
                                cCharAt3 = cCharAt4;
                            }
                            this.f4395bp = i15;
                            this.f4396ch = charAt(i15);
                            this.matchStat = 5;
                            this.token = 16;
                            return 0;
                        }
                    }
                }
            }
            this.matchStat = -1;
            return 0;
        }
        int i16 = cCharAt2 - '0';
        while (true) {
            i6 = i11 + 1;
            cCharAt = charAt(i11);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            int i17 = i16 * 10;
            if (i17 < i16) {
                throw new JSONException("parseInt error : " + subString(i10, i11));
            }
            i16 = (cCharAt - '0') + i17;
            i11 = i6;
        }
        if (cCharAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (z7) {
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return 0;
            }
            cCharAt = charAt(i6);
            i6 = i11 + 2;
        }
        if (i16 < 0) {
            this.matchStat = -1;
            return 0;
        }
        while (cCharAt != c5) {
            if (!JSONLexerBase.isWhitespace(cCharAt)) {
                this.matchStat = -1;
                return z10 ? -i16 : i16;
            }
            cCharAt = charAt(i6);
            i6++;
        }
        this.f4395bp = i6;
        this.f4396ch = charAt(i6);
        this.matchStat = 3;
        this.token = 16;
        return z10 ? -i16 : i16;
    }

    @Override
    public long scanLong(char c5) {
        int i6;
        char cCharAt;
        this.matchStat = 0;
        int i10 = this.f4395bp;
        int i11 = i10 + 1;
        char cCharAt2 = charAt(i10);
        boolean z7 = cCharAt2 == '\"';
        if (z7) {
            cCharAt2 = charAt(i11);
            i11 = i10 + 2;
        }
        boolean z10 = cCharAt2 == '-';
        if (z10) {
            cCharAt2 = charAt(i11);
            i11++;
        }
        if (cCharAt2 >= '0' && cCharAt2 <= '9') {
            long j10 = cCharAt2 - '0';
            while (true) {
                i6 = i11 + 1;
                cCharAt = charAt(i11);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                j10 = (j10 * 10) + ((long) (cCharAt - '0'));
                i11 = i6;
            }
            if (cCharAt == '.') {
                this.matchStat = -1;
                return 0L;
            }
            if (z7) {
                if (cCharAt != '\"') {
                    this.matchStat = -1;
                    return 0L;
                }
                cCharAt = charAt(i6);
                i6 = i11 + 2;
            }
            if (j10 < 0 && (j10 != Long.MIN_VALUE || !z10)) {
                this.matchStat = -1;
                return 0L;
            }
            while (cCharAt != c5) {
                if (!JSONLexerBase.isWhitespace(cCharAt)) {
                    this.matchStat = -1;
                    return j10;
                }
                cCharAt = charAt(i6);
                i6++;
            }
            this.f4395bp = i6;
            this.f4396ch = charAt(i6);
            this.matchStat = 3;
            this.token = 16;
            return z10 ? -j10 : j10;
        }
        if (cCharAt2 == 'n') {
            int i12 = i11 + 1;
            if (charAt(i11) == 'u') {
                int i13 = i11 + 2;
                if (charAt(i12) == 'l') {
                    int i14 = i11 + 3;
                    if (charAt(i13) == 'l') {
                        this.matchStat = 5;
                        int i15 = i11 + 4;
                        char cCharAt3 = charAt(i14);
                        if (z7 && cCharAt3 == '\"') {
                            cCharAt3 = charAt(i15);
                            i15 = i11 + 5;
                        }
                        while (cCharAt3 != ',') {
                            if (cCharAt3 == ']') {
                                this.f4395bp = i15;
                                this.f4396ch = charAt(i15);
                                this.matchStat = 5;
                                this.token = 15;
                                return 0L;
                            }
                            if (!JSONLexerBase.isWhitespace(cCharAt3)) {
                                this.matchStat = -1;
                                return 0L;
                            }
                            char cCharAt4 = charAt(i15);
                            i15++;
                            cCharAt3 = cCharAt4;
                        }
                        this.f4395bp = i15;
                        this.f4396ch = charAt(i15);
                        this.matchStat = 5;
                        this.token = 16;
                        return 0L;
                    }
                }
            }
        }
        this.matchStat = -1;
        return 0L;
    }

    @Override
    public String scanTypeName(SymbolTable symbolTable) {
        int iIndexOf;
        if (!this.text.startsWith("\"@type\":\"", this.f4395bp) || (iIndexOf = this.text.indexOf(34, this.f4395bp + 9)) == -1) {
            return null;
        }
        int i6 = this.f4395bp + 9;
        this.f4395bp = i6;
        int iCharAt = 0;
        while (i6 < iIndexOf) {
            iCharAt = (iCharAt * 31) + this.text.charAt(i6);
            i6++;
        }
        int i10 = this.f4395bp;
        String strAddSymbol = addSymbol(i10, iIndexOf - i10, iCharAt, symbolTable);
        char cCharAt = this.text.charAt(iIndexOf + 1);
        if (cCharAt != ',' && cCharAt != ']') {
            return null;
        }
        int i11 = iIndexOf + 2;
        this.f4395bp = i11;
        this.f4396ch = this.text.charAt(i11);
        return strAddSymbol;
    }

    @Override
    public boolean seekArrayToItem(int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "index must > 0, but "));
        }
        int i10 = this.token;
        if (i10 == 20) {
            return false;
        }
        if (i10 != 14) {
            throw new UnsupportedOperationException();
        }
        for (int i11 = 0; i11 < i6; i11++) {
            skipWhitespace();
            char c5 = this.f4396ch;
            if (c5 == '\"' || c5 == '\'') {
                skipString();
                char c8 = this.f4396ch;
                if (c8 != ',') {
                    if (c8 != ']') {
                        throw new JSONException("illegal json.");
                    }
                    next();
                    nextToken(16);
                    return false;
                }
                next();
            } else {
                if (c5 == '{') {
                    next();
                    this.token = 12;
                    skipObject(false);
                } else if (c5 == '[') {
                    next();
                    this.token = 14;
                    skipArray(false);
                } else {
                    int i12 = this.f4395bp + 1;
                    while (true) {
                        if (i12 >= this.text.length()) {
                            throw new JSONException("illegal json.");
                        }
                        char cCharAt = this.text.charAt(i12);
                        if (cCharAt == ',') {
                            int i13 = i12 + 1;
                            this.f4395bp = i13;
                            this.f4396ch = charAt(i13);
                            break;
                        }
                        if (cCharAt == ']') {
                            int i14 = i12 + 1;
                            this.f4395bp = i14;
                            this.f4396ch = charAt(i14);
                            nextToken();
                            return false;
                        }
                        i12++;
                    }
                }
                int i15 = this.token;
                if (i15 != 16) {
                    if (i15 == 15) {
                        return false;
                    }
                    throw new UnsupportedOperationException();
                }
            }
        }
        nextToken();
        return true;
    }

    @Override
    public int seekObjectToField(long j10, boolean z7) {
        char c5;
        int i6 = this.token;
        int i10 = -1;
        if (i6 == 20) {
            return -1;
        }
        if (i6 != 13) {
            int i11 = 15;
            if (i6 != 15) {
                int i12 = 16;
                if (i6 != 12 && i6 != 16) {
                    throw new UnsupportedOperationException(JSONToken.name(this.token));
                }
                while (true) {
                    char c8 = this.f4396ch;
                    if (c8 == '}') {
                        next();
                        nextToken();
                        return i10;
                    }
                    if (c8 == 26) {
                        return i10;
                    }
                    if (c8 != '\"') {
                        skipWhitespace();
                    }
                    if (this.f4396ch != '\"') {
                        throw new UnsupportedOperationException();
                    }
                    int i13 = this.f4395bp + 1;
                    long j11 = TypeUtils.fnv1a_64_magic_hashcode;
                    while (i13 < this.text.length()) {
                        char cCharAt = this.text.charAt(i13);
                        if (cCharAt == '\\') {
                            i13++;
                            if (i13 == this.text.length()) {
                                throw new JSONException("unclosed str, " + info());
                            }
                            cCharAt = this.text.charAt(i13);
                        }
                        if (cCharAt == '\"') {
                            int i14 = i13 + 1;
                            this.f4395bp = i14;
                            this.f4396ch = i14 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(this.f4395bp);
                            break;
                        }
                        j11 = (j11 ^ ((long) cCharAt)) * TypeUtils.fnv1a_64_magic_prime;
                        i13++;
                    }
                    if (j11 == j10) {
                        if (this.f4396ch != ':') {
                            skipWhitespace();
                        }
                        if (this.f4396ch != ':') {
                            return 3;
                        }
                        int i15 = this.f4395bp + 1;
                        this.f4395bp = i15;
                        char cCharAt2 = i15 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i15);
                        this.f4396ch = cCharAt2;
                        if (cCharAt2 == ',') {
                            int i16 = this.f4395bp + 1;
                            this.f4395bp = i16;
                            this.f4396ch = i16 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i16);
                            this.token = i12;
                            return 3;
                        }
                        if (cCharAt2 == ']') {
                            int i17 = this.f4395bp + 1;
                            this.f4395bp = i17;
                            this.f4396ch = i17 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i17);
                            this.token = i11;
                            return 3;
                        }
                        if (cCharAt2 == '}') {
                            int i18 = this.f4395bp + 1;
                            this.f4395bp = i18;
                            this.f4396ch = i18 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i18);
                            this.token = 13;
                            return 3;
                        }
                        if (cCharAt2 < '0' || cCharAt2 > '9') {
                            nextToken(2);
                            return 3;
                        }
                        this.f4398sp = 0;
                        this.pos = this.f4395bp;
                        scanNumber();
                        return 3;
                    }
                    if (this.f4396ch != ':') {
                        skipWhitespace();
                    }
                    if (this.f4396ch != ':') {
                        throw new JSONException("illegal json, " + info());
                    }
                    int i19 = this.f4395bp + 1;
                    this.f4395bp = i19;
                    char cCharAt3 = i19 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i19);
                    this.f4396ch = cCharAt3;
                    if (cCharAt3 != '\"' && cCharAt3 != '\'' && cCharAt3 != '{' && cCharAt3 != '[' && cCharAt3 != '0' && cCharAt3 != '1' && cCharAt3 != '2' && cCharAt3 != '3' && cCharAt3 != '4' && cCharAt3 != '5' && cCharAt3 != '6' && cCharAt3 != '7' && cCharAt3 != '8' && cCharAt3 != '9' && cCharAt3 != '+' && cCharAt3 != '-') {
                        skipWhitespace();
                    }
                    char c10 = this.f4396ch;
                    if (c10 == '-' || c10 == '+' || (c10 >= '0' && c10 <= '9')) {
                        next();
                        while (true) {
                            c5 = this.f4396ch;
                            if (c5 < '0' || c5 > '9') {
                                break;
                            }
                            next();
                        }
                        if (c5 == '.') {
                            next();
                            while (true) {
                                char c11 = this.f4396ch;
                                if (c11 < '0' || c11 > '9') {
                                    break;
                                }
                                next();
                            }
                        }
                        char c12 = this.f4396ch;
                        if (c12 == 'E' || c12 == 'e') {
                            next();
                            char c13 = this.f4396ch;
                            if (c13 == '-' || c13 == '+') {
                                next();
                            }
                            while (true) {
                                char c14 = this.f4396ch;
                                if (c14 < '0' || c14 > '9') {
                                    break;
                                }
                                next();
                            }
                        }
                        if (this.f4396ch != ',') {
                            skipWhitespace();
                        }
                        if (this.f4396ch == ',') {
                            next();
                        }
                    } else if (c10 == '\"') {
                        skipString();
                        char c15 = this.f4396ch;
                        if (c15 != ',' && c15 != '}') {
                            skipWhitespace();
                        }
                        if (this.f4396ch == ',') {
                            next();
                        }
                    } else if (c10 == 't') {
                        next();
                        if (this.f4396ch == 'r') {
                            next();
                            if (this.f4396ch == 'u') {
                                next();
                                if (this.f4396ch == 'e') {
                                    next();
                                }
                            }
                        }
                        char c16 = this.f4396ch;
                        if (c16 != ',' && c16 != '}') {
                            skipWhitespace();
                        }
                        if (this.f4396ch == ',') {
                            next();
                        }
                    } else if (c10 == 'n') {
                        next();
                        if (this.f4396ch == 'u') {
                            next();
                            if (this.f4396ch == 'l') {
                                next();
                                if (this.f4396ch == 'l') {
                                    next();
                                }
                            }
                        }
                        char c17 = this.f4396ch;
                        if (c17 != ',' && c17 != '}') {
                            skipWhitespace();
                        }
                        if (this.f4396ch == ',') {
                            next();
                        }
                    } else if (c10 == 'f') {
                        next();
                        if (this.f4396ch == 'a') {
                            next();
                            if (this.f4396ch == 'l') {
                                next();
                                if (this.f4396ch == 's') {
                                    next();
                                    if (this.f4396ch == 'e') {
                                        next();
                                    }
                                }
                            }
                        }
                        char c18 = this.f4396ch;
                        if (c18 != ',' && c18 != '}') {
                            skipWhitespace();
                        }
                        if (this.f4396ch == ',') {
                            next();
                        }
                    } else if (c10 == '{') {
                        int i20 = this.f4395bp + 1;
                        this.f4395bp = i20;
                        this.f4396ch = i20 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i20);
                        if (z7) {
                            this.token = 12;
                            return 1;
                        }
                        skipObject(false);
                        if (this.token == 13) {
                            return -1;
                        }
                    } else {
                        if (c10 != '[') {
                            throw new UnsupportedOperationException();
                        }
                        next();
                        if (z7) {
                            this.token = 14;
                            return 2;
                        }
                        skipArray(false);
                        if (this.token == 13) {
                            return -1;
                        }
                    }
                    i10 = -1;
                    i11 = 15;
                    i12 = 16;
                }
            }
        }
        nextToken();
        return -1;
    }

    public void setTime(char c5, char c8, char c10, char c11, char c12, char c13) {
        this.calendar.set(11, (c8 - '0') + ((c5 - '0') * 10));
        this.calendar.set(12, (c11 - '0') + ((c10 - '0') * 10));
        this.calendar.set(13, (c13 - '0') + ((c12 - '0') * 10));
    }

    public void setTimeZone(char c5, char c8, char c10) {
        setTimeZone(c5, c8, c10, '0', '0');
    }

    @Override
    public final void skipArray() {
        skipArray(false);
    }

    @Override
    public final void skipObject() {
        skipObject(false);
    }

    public final void skipString() {
        if (this.f4396ch != '\"') {
            throw new UnsupportedOperationException();
        }
        int i6 = this.f4395bp;
        while (true) {
            i6++;
            if (i6 >= this.text.length()) {
                throw new JSONException("unclosed str");
            }
            char cCharAt = this.text.charAt(i6);
            if (cCharAt == '\\') {
                if (i6 < this.len - 1) {
                    i6++;
                }
            } else if (cCharAt == '\"') {
                String str = this.text;
                int i10 = i6 + 1;
                this.f4395bp = i10;
                this.f4396ch = str.charAt(i10);
                return;
            }
        }
    }

    @Override
    public final String stringVal() {
        return !this.hasSpecial ? subString(this.f4397np + 1, this.f4398sp) : new String(this.sbuf, 0, this.f4398sp);
    }

    @Override
    public final String subString(int i6, int i10) {
        if (!ASMUtils.IS_ANDROID) {
            return this.text.substring(i6, i10 + i6);
        }
        char[] cArr = this.sbuf;
        if (i10 < cArr.length) {
            this.text.getChars(i6, i6 + i10, cArr, 0);
            return new String(this.sbuf, 0, i10);
        }
        char[] cArr2 = new char[i10];
        this.text.getChars(i6, i10 + i6, cArr2, 0);
        return new String(cArr2);
    }

    @Override
    public final char[] sub_chars(int i6, int i10) {
        if (ASMUtils.IS_ANDROID) {
            char[] cArr = this.sbuf;
            if (i10 < cArr.length) {
                this.text.getChars(i6, i10 + i6, cArr, 0);
                return this.sbuf;
            }
        }
        char[] cArr2 = new char[i10];
        this.text.getChars(i6, i10 + i6, cArr2, 0);
        return cArr2;
    }

    public JSONScanner(String str, int i6) {
        super(i6);
        this.text = str;
        this.len = str.length();
        this.f4395bp = -1;
        next();
        if (this.f4396ch == 65279) {
            next();
        }
    }

    public boolean scanISO8601DateIfMatch(boolean z7) {
        return scanISO8601DateIfMatch(z7, this.len - this.f4395bp);
    }

    public void setTimeZone(char c5, char c8, char c10, char c11, char c12) {
        int i6 = (((c12 - '0') + ((c11 - '0') * 10)) * 60000) + (((c10 - '0') + ((c8 - '0') * 10)) * 3600000);
        if (c5 == '-') {
            i6 = -i6;
        }
        if (this.calendar.getTimeZone().getRawOffset() != i6) {
            this.calendar.setTimeZone(new SimpleTimeZone(i6, Integer.toString(i6)));
        }
    }

    public final void skipArray(boolean z7) {
        int i6 = this.f4395bp;
        boolean z10 = false;
        int i10 = 0;
        while (i6 < this.text.length()) {
            char cCharAt = this.text.charAt(i6);
            if (cCharAt == '\\') {
                if (i6 >= this.len - 1) {
                    this.f4396ch = cCharAt;
                    this.f4395bp = i6;
                    throw new JSONException("illegal str, " + info());
                }
                i6++;
            } else if (cCharAt == '\"') {
                z10 = !z10;
            } else if (cCharAt != '[') {
                char cCharAt2 = JSONLexer.EOI;
                if (cCharAt == '{' && z7) {
                    int i11 = this.f4395bp + 1;
                    this.f4395bp = i11;
                    if (i11 < this.text.length()) {
                        cCharAt2 = this.text.charAt(i11);
                    }
                    this.f4396ch = cCharAt2;
                    skipObject(z7);
                } else if (cCharAt == ']' && !z10 && (i10 = i10 - 1) == -1) {
                    int i12 = i6 + 1;
                    this.f4395bp = i12;
                    if (i12 == this.text.length()) {
                        this.f4396ch = JSONLexer.EOI;
                        this.token = 20;
                        return;
                    } else {
                        this.f4396ch = this.text.charAt(this.f4395bp);
                        nextToken(16);
                        return;
                    }
                }
            } else if (!z10) {
                i10++;
            }
            i6++;
        }
        if (i6 != this.text.length()) {
            return;
        }
        throw new JSONException("illegal str, " + info());
    }

    @Override
    public final void skipObject(boolean z7) {
        int i6 = this.f4395bp;
        boolean z10 = false;
        int i10 = 0;
        while (i6 < this.text.length()) {
            char cCharAt = this.text.charAt(i6);
            if (cCharAt == '\\') {
                if (i6 >= this.len - 1) {
                    this.f4396ch = cCharAt;
                    this.f4395bp = i6;
                    throw new JSONException("illegal str, " + info());
                }
                i6++;
            } else if (cCharAt == '\"') {
                z10 = !z10;
            } else if (cCharAt != '{') {
                if (cCharAt == '}' && !z10 && (i10 = i10 - 1) == -1) {
                    int i11 = i6 + 1;
                    this.f4395bp = i11;
                    int length = this.text.length();
                    char cCharAt2 = JSONLexer.EOI;
                    if (i11 == length) {
                        this.f4396ch = JSONLexer.EOI;
                        this.token = 20;
                        return;
                    }
                    char cCharAt3 = this.text.charAt(this.f4395bp);
                    this.f4396ch = cCharAt3;
                    if (cCharAt3 == ',') {
                        this.token = 16;
                        int i12 = this.f4395bp + 1;
                        this.f4395bp = i12;
                        if (i12 < this.text.length()) {
                            cCharAt2 = this.text.charAt(i12);
                        }
                        this.f4396ch = cCharAt2;
                        return;
                    }
                    if (cCharAt3 == '}') {
                        this.token = 13;
                        next();
                        return;
                    } else if (cCharAt3 != ']') {
                        nextToken(16);
                        return;
                    } else {
                        this.token = 15;
                        next();
                        return;
                    }
                }
            } else if (!z10) {
                i10++;
            }
            i6++;
        }
        for (int i13 = 0; i13 < this.f4395bp; i13++) {
            if (i13 < this.text.length() && this.text.charAt(i13) == ' ') {
                i6++;
            }
        }
        if (i6 != this.text.length()) {
            return;
        }
        throw new JSONException("illegal str, " + info());
    }

    private boolean scanISO8601DateIfMatch(boolean z7, int i6) {
        char cCharAt;
        char c5;
        char c8;
        char c10;
        int i10;
        int i11;
        int i12;
        int i13;
        char c11;
        char c12;
        char cCharAt2;
        char c13;
        char c14;
        char c15;
        int i14;
        int i15;
        int i16;
        char cCharAt3;
        char c16;
        char c17;
        char cM11e;
        char cM11e2;
        char cM11e3;
        char cCharAt4;
        if (i6 < 8) {
            return false;
        }
        char cCharAt5 = charAt(this.f4395bp);
        char cCharAt6 = charAt(this.f4395bp + 1);
        char cCharAt7 = charAt(this.f4395bp + 2);
        char cCharAt8 = charAt(this.f4395bp + 3);
        char cCharAt9 = charAt(this.f4395bp + 4);
        char cCharAt10 = charAt(this.f4395bp + 5);
        cCharAt10 = charAt(this.f4395bp + 6);
        char cCharAt11 = charAt(this.f4395bp + 7);
        if (!z7 && i6 > 13) {
            char cCharAt12 = charAt((this.f4395bp + i6) - 1);
            char cCharAt13 = charAt((this.f4395bp + i6) - 2);
            if (cCharAt5 == '/' && cCharAt6 == 'D' && cCharAt7 == 'a' && cCharAt8 == 't' && cCharAt9 == 'e' && cCharAt10 == '(' && cCharAt12 == '/' && cCharAt13 == ')') {
                int i17 = -1;
                for (int i18 = 6; i18 < i6; i18++) {
                    char cCharAt14 = charAt(this.f4395bp + i18);
                    if (cCharAt14 != '+') {
                        if (cCharAt14 < '0' || cCharAt14 > '9') {
                            break;
                        }
                    } else {
                        i17 = i18;
                    }
                }
                if (i17 == -1) {
                    return false;
                }
                int i19 = this.f4395bp;
                int i20 = i19 + 6;
                long j10 = Long.parseLong(subString(i20, (i19 + i17) - i20));
                Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
                this.calendar = calendar;
                calendar.setTimeInMillis(j10);
                this.token = 5;
                return true;
            }
        }
        int i21 = 10;
        if (i6 == 8 || i6 == 14 || ((i6 == 16 && ((cCharAt4 = charAt(this.f4395bp + 10)) == 'T' || cCharAt4 == ' ')) || (i6 == 17 && charAt(this.f4395bp + 6) != '-'))) {
            if (z7) {
                return false;
            }
            char cCharAt15 = charAt(this.f4395bp + 8);
            boolean z10 = cCharAt9 == '-' && cCharAt11 == '-';
            boolean z11 = z10 && i6 == 16;
            boolean z12 = z10 && i6 == 17;
            if (z12 || z11) {
                cCharAt = charAt(this.f4395bp + 9);
                c5 = cCharAt10;
                c8 = cCharAt10;
                c10 = cCharAt15;
            } else if (cCharAt9 == '-' && cCharAt10 == '-') {
                c8 = cCharAt10;
                cCharAt = cCharAt11;
                c5 = '0';
                c10 = '0';
            } else {
                c5 = cCharAt9;
                c8 = cCharAt10;
                c10 = cCharAt10;
                cCharAt = cCharAt11;
            }
            if (!checkDate(cCharAt5, cCharAt6, cCharAt7, cCharAt8, c5, c8, c10, cCharAt)) {
                return false;
            }
            setCalendar(cCharAt5, cCharAt6, cCharAt7, cCharAt8, c5, c8, c10, cCharAt);
            if (i6 != 8) {
                char cCharAt16 = charAt(this.f4395bp + 9);
                char cCharAt17 = charAt(this.f4395bp + 10);
                char cCharAt18 = charAt(this.f4395bp + 11);
                char cCharAt19 = charAt(this.f4395bp + 12);
                char cCharAt20 = charAt(this.f4395bp + 13);
                if ((z12 && cCharAt17 == 'T' && cCharAt20 == ':' && charAt(this.f4395bp + 16) == 'Z') || (z11 && ((cCharAt17 == ' ' || cCharAt17 == 'T') && cCharAt20 == ':'))) {
                    char cCharAt21 = charAt(this.f4395bp + 14);
                    cCharAt2 = charAt(this.f4395bp + 15);
                    c12 = cCharAt21;
                    c14 = cCharAt18;
                    c11 = cCharAt19;
                    c15 = '0';
                    c13 = '0';
                } else {
                    c11 = cCharAt16;
                    c12 = cCharAt17;
                    cCharAt2 = cCharAt18;
                    c13 = cCharAt20;
                    c14 = cCharAt15;
                    c15 = cCharAt19;
                }
                if (!checkTime(c14, c11, c12, cCharAt2, c15, c13)) {
                    return false;
                }
                if (i6 != 17 || z12) {
                    i14 = 0;
                } else {
                    char cCharAt22 = charAt(this.f4395bp + 14);
                    char cCharAt23 = charAt(this.f4395bp + 15);
                    char cCharAt24 = charAt(this.f4395bp + 16);
                    if (cCharAt22 < '0' || cCharAt22 > '9' || cCharAt23 < '0' || cCharAt23 > '9' || cCharAt24 < '0' || cCharAt24 > '9') {
                        return false;
                    }
                    i14 = (cCharAt24 - '0') + ((cCharAt23 - '0') * 10) + ((cCharAt22 - '0') * 100);
                }
                i11 = (c13 - '0') + ((c15 - '0') * 10);
                i12 = i14;
                i10 = (cCharAt2 - '0') + ((c12 - '0') * 10);
                i13 = (c11 - '0') + ((c14 - '0') * 10);
            } else {
                i10 = 0;
                i11 = 0;
                i12 = 0;
                i13 = 0;
            }
            this.calendar.set(11, i13);
            this.calendar.set(12, i10);
            this.calendar.set(13, i11);
            this.calendar.set(14, i12);
            this.token = 5;
            return true;
        }
        if (i6 < 9) {
            return false;
        }
        char cCharAt25 = charAt(this.f4395bp + 8);
        cCharAt8 = charAt(this.f4395bp + 9);
        if ((cCharAt9 == '-' && cCharAt11 == '-') || (cCharAt9 == '/' && cCharAt11 == '/')) {
            if (cCharAt8 == ' ') {
                i21 = 9;
                cCharAt6 = cCharAt25;
                cCharAt25 = '0';
                cCharAt7 = cCharAt7;
            } else {
                cCharAt6 = cCharAt8;
                cCharAt8 = cCharAt8;
                cCharAt7 = cCharAt7;
            }
        } else if (cCharAt9 == '-' && cCharAt10 == '-') {
            if (cCharAt25 == ' ') {
                cCharAt25 = '0';
                i21 = 8;
                cCharAt6 = cCharAt11;
                cCharAt10 = '0';
            } else {
                i21 = 9;
                cCharAt6 = cCharAt25;
                cCharAt25 = cCharAt11;
                cCharAt10 = '0';
            }
        } else if ((cCharAt7 == '.' && cCharAt10 == '.') || (cCharAt7 == '-' && cCharAt10 == '-')) {
            cCharAt6 = cCharAt11;
            cCharAt10 = cCharAt8;
            i21 = 10;
            cCharAt10 = cCharAt9;
            cCharAt5 = cCharAt10;
            cCharAt7 = cCharAt25;
            cCharAt25 = cCharAt5;
        } else if (cCharAt25 == 'T') {
            cCharAt25 = cCharAt10;
            cCharAt8 = cCharAt8;
            i21 = 8;
            cCharAt7 = cCharAt7;
            cCharAt10 = cCharAt10;
            cCharAt6 = cCharAt6;
            cCharAt6 = cCharAt11;
            cCharAt10 = cCharAt9;
            cCharAt5 = cCharAt5;
        } else {
            if (cCharAt9 != 24180 && cCharAt9 != 45380) {
                return false;
            }
            if (cCharAt11 != 26376 && cCharAt11 != 50900) {
                if (cCharAt10 != 26376 && cCharAt10 != 50900) {
                    return false;
                }
                if (cCharAt25 == 26085 || cCharAt25 == 51068) {
                    cCharAt25 = '0';
                    i21 = 10;
                    cCharAt6 = cCharAt11;
                    cCharAt10 = '0';
                } else {
                    if (cCharAt8 != 26085 && cCharAt8 != 51068) {
                        return false;
                    }
                    i21 = 10;
                    cCharAt6 = cCharAt25;
                    cCharAt25 = cCharAt11;
                    cCharAt10 = '0';
                }
            } else if (cCharAt8 == 26085 || cCharAt8 == 51068) {
                i21 = 10;
                cCharAt6 = cCharAt25;
                cCharAt25 = '0';
                cCharAt7 = cCharAt7;
            } else {
                if (charAt(this.f4395bp + 10) != 26085 && charAt(this.f4395bp + 10) != 51068) {
                    return false;
                }
                i21 = 11;
                cCharAt6 = cCharAt8;
                cCharAt8 = cCharAt8;
                cCharAt7 = cCharAt7;
            }
        }
        if (!checkDate(cCharAt5, cCharAt6, cCharAt7, cCharAt8, cCharAt10, cCharAt10, cCharAt25, cCharAt6)) {
            return false;
        }
        setCalendar(cCharAt5, cCharAt6, cCharAt7, cCharAt8, cCharAt10, cCharAt10, cCharAt25, cCharAt6);
        char cCharAt26 = charAt(this.f4395bp + i21);
        char c18 = 'T';
        if (cCharAt26 == 'T') {
            if (i6 == 16 && i21 == 8 && charAt(this.f4395bp + 15) == 'Z') {
                char cM11e4 = AbstractC0004e.m11e(this.f4395bp, i21, 1, this);
                char cM11e5 = AbstractC0004e.m11e(this.f4395bp, i21, 2, this);
                char cM11e6 = AbstractC0004e.m11e(this.f4395bp, i21, 3, this);
                char cM11e7 = AbstractC0004e.m11e(this.f4395bp, i21, 4, this);
                char cM11e8 = AbstractC0004e.m11e(this.f4395bp, i21, 5, this);
                char cM11e9 = AbstractC0004e.m11e(this.f4395bp, i21, 6, this);
                if (!checkTime(cM11e4, cM11e5, cM11e6, cM11e7, cM11e8, cM11e9)) {
                    return false;
                }
                setTime(cM11e4, cM11e5, cM11e6, cM11e7, cM11e8, cM11e9);
                this.calendar.set(14, 0);
                if (this.calendar.getTimeZone().getRawOffset() != 0) {
                    String[] availableIDs = TimeZone.getAvailableIDs(0);
                    if (availableIDs.length > 0) {
                        this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                    }
                }
                this.token = 5;
                return true;
            }
            c18 = 'T';
        }
        if (cCharAt26 != c18 && (cCharAt26 != ' ' || z7)) {
            if (cCharAt26 != '\"' && cCharAt26 != 26 && cCharAt26 != 26085 && cCharAt26 != 51068) {
                if ((cCharAt26 != '+' && cCharAt26 != '-') || this.len != i21 + 6 || AbstractC0004e.m11e(this.f4395bp, i21, 3, this) != ':' || AbstractC0004e.m11e(this.f4395bp, i21, 4, this) != '0' || AbstractC0004e.m11e(this.f4395bp, i21, 5, this) != '0') {
                    return false;
                }
                setTime('0', '0', '0', '0', '0', '0');
                this.calendar.set(14, 0);
                setTimeZone(cCharAt26, AbstractC0004e.m11e(this.f4395bp, i21, 1, this), AbstractC0004e.m11e(this.f4395bp, i21, 2, this));
                return true;
            }
            this.calendar.set(11, 0);
            this.calendar.set(12, 0);
            this.calendar.set(13, 0);
            this.calendar.set(14, 0);
            int i22 = this.f4395bp + i21;
            this.f4395bp = i22;
            this.f4396ch = charAt(i22);
            this.token = 5;
            return true;
        }
        if (i6 < i21 + 9 || AbstractC0004e.m11e(this.f4395bp, i21, 3, this) != ':') {
            return false;
        }
        int i23 = 6;
        if (AbstractC0004e.m11e(this.f4395bp, i21, 6, this) != ':') {
            return false;
        }
        char cM11e10 = AbstractC0004e.m11e(this.f4395bp, i21, 1, this);
        char cM11e11 = AbstractC0004e.m11e(this.f4395bp, i21, 2, this);
        char cM11e12 = AbstractC0004e.m11e(this.f4395bp, i21, 4, this);
        char cM11e13 = AbstractC0004e.m11e(this.f4395bp, i21, 5, this);
        char cM11e14 = AbstractC0004e.m11e(this.f4395bp, i21, 7, this);
        char cM11e15 = AbstractC0004e.m11e(this.f4395bp, i21, 8, this);
        if (!checkTime(cM11e10, cM11e11, cM11e12, cM11e13, cM11e14, cM11e15)) {
            return false;
        }
        setTime(cM11e10, cM11e11, cM11e12, cM11e13, cM11e14, cM11e15);
        if (AbstractC0004e.m11e(this.f4395bp, i21, 9, this) == '.') {
            int i24 = i21 + 11;
            if (i6 < i24 || (cM11e = AbstractC0004e.m11e(this.f4395bp, i21, 10, this)) < '0' || cM11e > '9') {
                return false;
            }
            i16 = cM11e - '0';
            if (i6 <= i24 || (cM11e3 = AbstractC0004e.m11e(this.f4395bp, i21, 11, this)) < '0' || cM11e3 > '9') {
                i15 = 1;
            } else {
                i16 = (cM11e3 - '0') + (i16 * 10);
                i15 = 2;
            }
            if (i15 == 2 && (cM11e2 = AbstractC0004e.m11e(this.f4395bp, i21, 12, this)) >= '0' && cM11e2 <= '9') {
                i16 = (cM11e2 - '0') + (i16 * 10);
                i15 = 3;
            }
        } else {
            i15 = -1;
            i16 = 0;
        }
        this.calendar.set(14, i16);
        char cCharAt27 = charAt(this.f4395bp + i21 + 10 + i15);
        if (cCharAt27 == ' ') {
            i15++;
            cCharAt27 = charAt(this.f4395bp + i21 + 10 + i15);
        }
        int i25 = i15;
        if (cCharAt27 == '+' || cCharAt27 == '-') {
            char cCharAt28 = charAt(this.f4395bp + i21 + 10 + i25 + 1);
            if (cCharAt28 < '0' || cCharAt28 > '1' || (cCharAt3 = charAt(this.f4395bp + i21 + 10 + i25 + 2)) < '0' || cCharAt3 > '9') {
                return false;
            }
            char cCharAt29 = charAt(this.f4395bp + i21 + 10 + i25 + 3);
            if (cCharAt29 == ':') {
                char cCharAt30 = charAt(this.f4395bp + i21 + 10 + i25 + 4);
                char cCharAt31 = charAt(this.f4395bp + i21 + 10 + i25 + 5);
                if (cCharAt30 == '4' && cCharAt31 == '5') {
                    if (cCharAt28 != '1' || (cCharAt3 != '2' && cCharAt3 != '3')) {
                        if (cCharAt28 != '0') {
                            return false;
                        }
                        if (cCharAt3 != '5' && cCharAt3 != '8') {
                            return false;
                        }
                    }
                } else if ((cCharAt30 != '0' && cCharAt30 != '3') || cCharAt31 != '0') {
                    return false;
                }
                c17 = cCharAt30;
                c16 = cCharAt31;
            } else if (cCharAt29 == '0') {
                char cCharAt32 = charAt(this.f4395bp + i21 + 10 + i25 + 4);
                if (cCharAt32 != '0' && cCharAt32 != '3') {
                    return false;
                }
                c17 = cCharAt32;
                c16 = '0';
                i23 = 5;
            } else if (cCharAt29 == '3' && charAt(this.f4395bp + i21 + 10 + i25 + 4) == '0') {
                c16 = '0';
                i23 = 5;
                c17 = '3';
            } else if (cCharAt29 == '4' && charAt(this.f4395bp + i21 + 10 + i25 + 4) == '5') {
                c16 = '5';
                i23 = 5;
                c17 = '4';
            } else {
                c16 = '0';
                i23 = 3;
                c17 = '0';
            }
            setTimeZone(cCharAt27, cCharAt28, cCharAt3, c17, c16);
        } else if (cCharAt27 == 'Z') {
            if (this.calendar.getTimeZone().getRawOffset() != 0) {
                String[] availableIDs2 = TimeZone.getAvailableIDs(0);
                if (availableIDs2.length > 0) {
                    this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs2[0]));
                }
            }
            i23 = 1;
        } else {
            i23 = 0;
        }
        int i26 = i21 + 10 + i25 + i23;
        char cCharAt33 = charAt(this.f4395bp + i26);
        if (cCharAt33 != 26 && cCharAt33 != '\"') {
            return false;
        }
        int i27 = this.f4395bp + i26;
        this.f4395bp = i27;
        this.f4396ch = charAt(i27);
        this.token = 5;
        return true;
    }

    @Override
    public final boolean charArrayCompare(char[] cArr) {
        return charArrayCompare(this.text, this.f4395bp, cArr);
    }

    public JSONScanner(char[] cArr, int i6) {
        this(cArr, i6, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(char[] cArr, int i6, int i10) {
        this(new String(cArr, 0, i6), i10);
    }

    @Override
    public String[] scanFieldStringArray(char[] cArr, int i6, SymbolTable symbolTable) {
        int i10;
        char cCharAt;
        int i11 = this.f4395bp;
        char c5 = this.f4396ch;
        while (JSONLexerBase.isWhitespace(this.f4396ch)) {
            next();
        }
        if (cArr != null) {
            this.matchStat = 0;
            if (!charArrayCompare(cArr)) {
                this.matchStat = -2;
                return null;
            }
            int length = this.f4395bp + cArr.length;
            int i12 = length + 1;
            char cCharAt2 = this.text.charAt(length);
            while (JSONLexerBase.isWhitespace(cCharAt2)) {
                cCharAt2 = this.text.charAt(i12);
                i12++;
            }
            if (cCharAt2 == ':') {
                i10 = i12 + 1;
                cCharAt = this.text.charAt(i12);
                while (JSONLexerBase.isWhitespace(cCharAt)) {
                    cCharAt = this.text.charAt(i10);
                    i10++;
                }
            } else {
                this.matchStat = -1;
                return null;
            }
        } else {
            i10 = this.f4395bp + 1;
            cCharAt = this.f4396ch;
        }
        if (cCharAt == '[') {
            this.f4395bp = i10;
            this.f4396ch = this.text.charAt(i10);
            String[] strArr = i6 >= 0 ? new String[i6] : new String[4];
            int i13 = 0;
            while (true) {
                if (JSONLexerBase.isWhitespace(this.f4396ch)) {
                    next();
                } else {
                    if (this.f4396ch != '\"') {
                        this.f4395bp = i11;
                        this.f4396ch = c5;
                        this.matchStat = -1;
                        return null;
                    }
                    String strScanSymbol = scanSymbol(symbolTable, '\"');
                    if (i13 == strArr.length) {
                        String[] strArr2 = new String[strArr.length + (strArr.length >> 1) + 1];
                        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                        strArr = strArr2;
                    }
                    int i14 = i13 + 1;
                    strArr[i13] = strScanSymbol;
                    while (JSONLexerBase.isWhitespace(this.f4396ch)) {
                        next();
                    }
                    if (this.f4396ch == ',') {
                        next();
                        i13 = i14;
                    } else {
                        if (strArr.length != i14) {
                            String[] strArr3 = new String[i14];
                            System.arraycopy(strArr, 0, strArr3, 0, i14);
                            strArr = strArr3;
                        }
                        while (JSONLexerBase.isWhitespace(this.f4396ch)) {
                            next();
                        }
                        if (this.f4396ch == ']') {
                            next();
                            return strArr;
                        }
                        this.f4395bp = i11;
                        this.f4396ch = c5;
                        this.matchStat = -1;
                        return null;
                    }
                }
            }
        } else {
            if (cCharAt == 'n' && this.text.startsWith("ull", this.f4395bp + 1)) {
                int i15 = this.f4395bp + 4;
                this.f4395bp = i15;
                this.f4396ch = this.text.charAt(i15);
                return null;
            }
            this.matchStat = -1;
            return null;
        }
    }

    @Override
    public int seekObjectToField(long[] jArr) {
        char c5;
        int i6 = this.token;
        if (i6 != 12 && i6 != 16) {
            throw new UnsupportedOperationException();
        }
        while (true) {
            char c8 = this.f4396ch;
            if (c8 == '}') {
                next();
                nextToken();
                this.matchStat = -1;
                return -1;
            }
            char cCharAt = JSONLexer.EOI;
            if (c8 == 26) {
                this.matchStat = -1;
                return -1;
            }
            if (c8 != '\"') {
                skipWhitespace();
            }
            if (this.f4396ch == '\"') {
                int i10 = this.f4395bp + 1;
                long j10 = TypeUtils.fnv1a_64_magic_hashcode;
                while (i10 < this.text.length()) {
                    char cCharAt2 = this.text.charAt(i10);
                    if (cCharAt2 == '\\') {
                        i10++;
                        if (i10 != this.text.length()) {
                            cCharAt2 = this.text.charAt(i10);
                        } else {
                            throw new JSONException("unclosed str, " + info());
                        }
                    }
                    if (cCharAt2 == '\"') {
                        int i11 = i10 + 1;
                        this.f4395bp = i11;
                        this.f4396ch = i11 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(this.f4395bp);
                        break;
                    }
                    j10 = (j10 ^ ((long) cCharAt2)) * TypeUtils.fnv1a_64_magic_prime;
                    i10++;
                }
                int i12 = 0;
                while (true) {
                    if (i12 >= jArr.length) {
                        i12 = -1;
                        break;
                    }
                    if (j10 == jArr[i12]) {
                        break;
                    }
                    i12++;
                }
                if (i12 != -1) {
                    if (this.f4396ch != ':') {
                        skipWhitespace();
                    }
                    if (this.f4396ch == ':') {
                        int i13 = this.f4395bp + 1;
                        this.f4395bp = i13;
                        char cCharAt3 = i13 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i13);
                        this.f4396ch = cCharAt3;
                        if (cCharAt3 == ',') {
                            int i14 = this.f4395bp + 1;
                            this.f4395bp = i14;
                            if (i14 < this.text.length()) {
                                cCharAt = this.text.charAt(i14);
                            }
                            this.f4396ch = cCharAt;
                            this.token = 16;
                        } else if (cCharAt3 == ']') {
                            int i15 = this.f4395bp + 1;
                            this.f4395bp = i15;
                            if (i15 < this.text.length()) {
                                cCharAt = this.text.charAt(i15);
                            }
                            this.f4396ch = cCharAt;
                            this.token = 15;
                        } else if (cCharAt3 == '}') {
                            int i16 = this.f4395bp + 1;
                            this.f4395bp = i16;
                            if (i16 < this.text.length()) {
                                cCharAt = this.text.charAt(i16);
                            }
                            this.f4396ch = cCharAt;
                            this.token = 13;
                        } else if (cCharAt3 >= '0' && cCharAt3 <= '9') {
                            this.f4398sp = 0;
                            this.pos = this.f4395bp;
                            scanNumber();
                        } else {
                            nextToken(2);
                        }
                    }
                    this.matchStat = 3;
                    return i12;
                }
                if (this.f4396ch != ':') {
                    skipWhitespace();
                }
                if (this.f4396ch == ':') {
                    int i17 = this.f4395bp + 1;
                    this.f4395bp = i17;
                    char cCharAt4 = i17 >= this.text.length() ? JSONLexer.EOI : this.text.charAt(i17);
                    this.f4396ch = cCharAt4;
                    if (cCharAt4 != '\"' && cCharAt4 != '\'' && cCharAt4 != '{' && cCharAt4 != '[' && cCharAt4 != '0' && cCharAt4 != '1' && cCharAt4 != '2' && cCharAt4 != '3' && cCharAt4 != '4' && cCharAt4 != '5' && cCharAt4 != '6' && cCharAt4 != '7' && cCharAt4 != '8' && cCharAt4 != '9' && cCharAt4 != '+' && cCharAt4 != '-') {
                        skipWhitespace();
                    }
                    char c10 = this.f4396ch;
                    if (c10 == '-' || c10 == '+' || (c10 >= '0' && c10 <= '9')) {
                        next();
                        while (true) {
                            c5 = this.f4396ch;
                            if (c5 < '0' || c5 > '9') {
                                break;
                            }
                            next();
                        }
                        if (c5 == '.') {
                            next();
                            while (true) {
                                char c11 = this.f4396ch;
                                if (c11 < '0' || c11 > '9') {
                                    break;
                                }
                                next();
                            }
                        }
                        char c12 = this.f4396ch;
                        if (c12 == 'E' || c12 == 'e') {
                            next();
                            char c13 = this.f4396ch;
                            if (c13 == '-' || c13 == '+') {
                                next();
                            }
                            while (true) {
                                char c14 = this.f4396ch;
                                if (c14 < '0' || c14 > '9') {
                                    break;
                                }
                                next();
                            }
                        }
                        if (this.f4396ch != ',') {
                            skipWhitespace();
                        }
                        if (this.f4396ch == ',') {
                            next();
                        }
                    } else if (c10 == '\"') {
                        skipString();
                        char c15 = this.f4396ch;
                        if (c15 != ',' && c15 != '}') {
                            skipWhitespace();
                        }
                        if (this.f4396ch == ',') {
                            next();
                        }
                    } else if (c10 == '{') {
                        int i18 = this.f4395bp + 1;
                        this.f4395bp = i18;
                        if (i18 < this.text.length()) {
                            cCharAt = this.text.charAt(i18);
                        }
                        this.f4396ch = cCharAt;
                        skipObject(false);
                    } else if (c10 == '[') {
                        next();
                        skipArray(false);
                    } else {
                        throw new UnsupportedOperationException();
                    }
                } else {
                    throw new JSONException("illegal json, " + info());
                }
            } else {
                throw new UnsupportedOperationException();
            }
        }
    }
}

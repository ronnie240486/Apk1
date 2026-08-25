package com.alibaba.fastjson;

import androidx.media3.container.NalUnitUtil;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import com.alibaba.fastjson.asm.Opcodes;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public abstract class JSONValidator implements Cloneable, Closeable {

    protected char f4390ch;
    protected boolean eof;
    protected Type type;
    private Boolean validateResult;
    protected int pos = -1;
    protected int count = 0;
    protected boolean supportMultiValue = false;

    public static class ReaderValidator extends JSONValidator {
        private static final ThreadLocal<char[]> bufLocal = new ThreadLocal<>();
        private char[] buf;

        final Reader f4391r;
        private int end = -1;
        private int readCount = 0;

        public ReaderValidator(Reader reader) {
            this.f4391r = reader;
            ThreadLocal<char[]> threadLocal = bufLocal;
            char[] cArr = threadLocal.get();
            this.buf = cArr;
            if (cArr != null) {
                threadLocal.set(null);
            } else {
                this.buf = new char[8192];
            }
            next();
            skipWhiteSpace();
        }

        @Override
        public void close() throws IOException {
            bufLocal.set(this.buf);
            this.f4391r.close();
        }

        @Override
        public void next() {
            int i6 = this.pos;
            if (i6 < this.end) {
                char[] cArr = this.buf;
                int i10 = i6 + 1;
                this.pos = i10;
                this.f4390ch = cArr[i10];
                return;
            }
            if (this.eof) {
                return;
            }
            try {
                Reader reader = this.f4391r;
                char[] cArr2 = this.buf;
                int i11 = reader.read(cArr2, 0, cArr2.length);
                this.readCount++;
                if (i11 > 0) {
                    this.f4390ch = this.buf[0];
                    this.pos = 0;
                    this.end = i11 - 1;
                } else {
                    if (i11 == -1) {
                        this.pos = 0;
                        this.end = 0;
                        this.buf = null;
                        this.f4390ch = (char) 0;
                        this.eof = true;
                        return;
                    }
                    this.pos = 0;
                    this.end = 0;
                    this.buf = null;
                    this.f4390ch = (char) 0;
                    this.eof = true;
                    throw new JSONException("read error");
                }
            } catch (IOException unused) {
                throw new JSONException("read error");
            }
        }
    }

    public enum Type {
        Object,
        Array,
        Value
    }

    public static class UTF16Validator extends JSONValidator {
        private final String str;

        public UTF16Validator(String str) {
            this.str = str;
            next();
            skipWhiteSpace();
        }

        @Override
        public final void fieldName() {
            char cCharAt;
            int i6 = this.pos;
            do {
                i6++;
                if (i6 >= this.str.length() || (cCharAt = this.str.charAt(i6)) == '\\') {
                    next();
                    while (true) {
                        char c5 = this.f4390ch;
                        if (c5 == '\\') {
                            next();
                            if (this.f4390ch == 'u') {
                                next();
                                next();
                                next();
                                next();
                                next();
                            } else {
                                next();
                            }
                        } else if (c5 == '\"') {
                            next();
                            return;
                        } else if (this.eof) {
                            return;
                        } else {
                            next();
                        }
                    }
                }
            } while (cCharAt != '\"');
            int i10 = i6 + 1;
            this.f4390ch = this.str.charAt(i10);
            this.pos = i10;
        }

        @Override
        public void next() {
            int i6 = this.pos + 1;
            this.pos = i6;
            if (i6 < this.str.length()) {
                this.f4390ch = this.str.charAt(this.pos);
            } else {
                this.f4390ch = (char) 0;
                this.eof = true;
            }
        }
    }

    public static class UTF8InputStreamValidator extends JSONValidator {
        private static final ThreadLocal<byte[]> bufLocal = new ThreadLocal<>();
        private byte[] buf;

        private final InputStream f4392is;
        private int end = -1;
        private int readCount = 0;

        public UTF8InputStreamValidator(InputStream inputStream) {
            this.f4392is = inputStream;
            ThreadLocal<byte[]> threadLocal = bufLocal;
            byte[] bArr = threadLocal.get();
            this.buf = bArr;
            if (bArr != null) {
                threadLocal.set(null);
            } else {
                this.buf = new byte[8192];
            }
            next();
            skipWhiteSpace();
        }

        @Override
        public void close() throws IOException {
            bufLocal.set(this.buf);
            this.f4392is.close();
        }

        @Override
        public void next() {
            int i6 = this.pos;
            if (i6 < this.end) {
                byte[] bArr = this.buf;
                int i10 = i6 + 1;
                this.pos = i10;
                this.f4390ch = (char) bArr[i10];
                return;
            }
            if (this.eof) {
                return;
            }
            try {
                InputStream inputStream = this.f4392is;
                byte[] bArr2 = this.buf;
                int i11 = inputStream.read(bArr2, 0, bArr2.length);
                this.readCount++;
                if (i11 > 0) {
                    this.f4390ch = (char) this.buf[0];
                    this.pos = 0;
                    this.end = i11 - 1;
                } else {
                    if (i11 == -1) {
                        this.pos = 0;
                        this.end = 0;
                        this.buf = null;
                        this.f4390ch = (char) 0;
                        this.eof = true;
                        return;
                    }
                    this.pos = 0;
                    this.end = 0;
                    this.buf = null;
                    this.f4390ch = (char) 0;
                    this.eof = true;
                    throw new JSONException("read error");
                }
            } catch (IOException unused) {
                throw new JSONException("read error");
            }
        }
    }

    public static class UTF8Validator extends JSONValidator {
        private final byte[] bytes;

        public UTF8Validator(byte[] bArr) {
            this.bytes = bArr;
            next();
            skipWhiteSpace();
        }

        @Override
        public void next() {
            int i6 = this.pos + 1;
            this.pos = i6;
            byte[] bArr = this.bytes;
            if (i6 < bArr.length) {
                this.f4390ch = (char) bArr[i6];
            } else {
                this.f4390ch = (char) 0;
                this.eof = true;
            }
        }
    }

    private boolean any() {
        char c5;
        char c8;
        char c10;
        char c11;
        char c12;
        char c13;
        char c14;
        char c15;
        char c16;
        char c17 = this.f4390ch;
        if (c17 == '\"') {
            next();
            while (!this.eof) {
                char c18 = this.f4390ch;
                if (c18 == '\\') {
                    next();
                    if (this.f4390ch == 'u') {
                        next();
                        next();
                        next();
                        next();
                        next();
                    } else {
                        next();
                    }
                } else {
                    if (c18 == '\"') {
                        next();
                        this.type = Type.Value;
                        return true;
                    }
                    next();
                }
            }
            return false;
        }
        if (c17 != '+' && c17 != '-') {
            if (c17 == '[') {
                next();
                skipWhiteSpace();
                if (this.f4390ch == ']') {
                    next();
                    this.type = Type.Array;
                    return true;
                }
                while (any()) {
                    skipWhiteSpace();
                    char c19 = this.f4390ch;
                    if (c19 != ',') {
                        if (c19 != ']') {
                            return false;
                        }
                        next();
                        this.type = Type.Array;
                        return true;
                    }
                    next();
                    skipWhiteSpace();
                }
                return false;
            }
            if (c17 == 'f') {
                next();
                if (this.f4390ch != 'a') {
                    return false;
                }
                next();
                if (this.f4390ch != 'l') {
                    return false;
                }
                next();
                if (this.f4390ch != 's') {
                    return false;
                }
                next();
                if (this.f4390ch != 'e') {
                    return false;
                }
                next();
                if (!isWhiteSpace(this.f4390ch) && (c14 = this.f4390ch) != ',' && c14 != ']' && c14 != '}' && c14 != 0) {
                    return false;
                }
                this.type = Type.Value;
                return true;
            }
            if (c17 == 'n') {
                next();
                if (this.f4390ch != 'u') {
                    return false;
                }
                next();
                if (this.f4390ch != 'l') {
                    return false;
                }
                next();
                if (this.f4390ch != 'l') {
                    return false;
                }
                next();
                if (!isWhiteSpace(this.f4390ch) && (c15 = this.f4390ch) != ',' && c15 != ']' && c15 != '}' && c15 != 0) {
                    return false;
                }
                this.type = Type.Value;
                return true;
            }
            if (c17 == 't') {
                next();
                if (this.f4390ch != 'r') {
                    return false;
                }
                next();
                if (this.f4390ch != 'u') {
                    return false;
                }
                next();
                if (this.f4390ch != 'e') {
                    return false;
                }
                next();
                if (!isWhiteSpace(this.f4390ch) && (c16 = this.f4390ch) != ',' && c16 != ']' && c16 != '}' && c16 != 0) {
                    return false;
                }
                this.type = Type.Value;
                return true;
            }
            if (c17 == '{') {
                next();
                while (isWhiteSpace(this.f4390ch)) {
                    next();
                }
                if (this.f4390ch == '}') {
                    next();
                    this.type = Type.Object;
                    return true;
                }
                while (this.f4390ch == '\"') {
                    fieldName();
                    skipWhiteSpace();
                    if (this.f4390ch != ':') {
                        break;
                    }
                    next();
                    skipWhiteSpace();
                    if (!any()) {
                        return false;
                    }
                    skipWhiteSpace();
                    char c20 = this.f4390ch;
                    if (c20 != ',') {
                        if (c20 != '}') {
                            break;
                        }
                        next();
                        this.type = Type.Object;
                        return true;
                    }
                    next();
                    skipWhiteSpace();
                }
                return false;
            }
            switch (c17) {
                case NalUnitUtil.H265_NAL_UNIT_TYPE_UNSPECIFIED:
                case Opcodes.V1_5:
                case DefaultRenderersFactory.MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY:
                case '3':
                case '4':
                case '5':
                case Opcodes.ISTORE:
                case Opcodes.LSTORE:
                case Opcodes.FSTORE:
                case Opcodes.DSTORE:
                    break;
                default:
                    return false;
            }
        }
        if (c17 == '-' || c17 == '+') {
            next();
            skipWhiteSpace();
            char c21 = this.f4390ch;
            if (c21 >= '0' && c21 <= '9') {
                do {
                    next();
                    c5 = this.f4390ch;
                    if (c5 >= '0') {
                    }
                    if (c5 == '.') {
                        next();
                        c13 = this.f4390ch;
                        if (c13 >= '0' || c13 > '9') {
                            return false;
                        }
                        while (true) {
                            char c22 = this.f4390ch;
                            if (c22 >= '0' && c22 <= '9') {
                                next();
                            }
                        }
                    }
                    c8 = this.f4390ch;
                    if (c8 != 'e' || c8 == 'E') {
                        next();
                        c10 = this.f4390ch;
                        if (c10 != '-' || c10 == '+') {
                            next();
                        }
                        c11 = this.f4390ch;
                        if (c11 >= '0' && c11 <= '9') {
                            next();
                            while (true) {
                                c12 = this.f4390ch;
                                if (c12 < '0' && c12 <= '9') {
                                    next();
                                }
                            }
                        }
                    }
                    this.type = Type.Value;
                    return true;
                } while (c5 <= '9');
                if (c5 == '.') {
                    next();
                    c13 = this.f4390ch;
                    if (c13 >= '0') {
                    }
                    return false;
                }
                c8 = this.f4390ch;
                if (c8 != 'e') {
                }
                next();
                c10 = this.f4390ch;
                if (c10 != '-') {
                    next();
                } else {
                    next();
                }
                c11 = this.f4390ch;
                if (c11 >= '0') {
                    next();
                    while (true) {
                        c12 = this.f4390ch;
                        if (c12 < '0') {
                        }
                        this.type = Type.Value;
                        return true;
                        next();
                    }
                }
            }
        } else {
            do {
                next();
                c5 = this.f4390ch;
                if (c5 >= '0') {
                }
                if (c5 == '.') {
                    next();
                    c13 = this.f4390ch;
                    if (c13 >= '0') {
                    }
                    return false;
                }
                c8 = this.f4390ch;
                if (c8 != 'e') {
                }
                next();
                c10 = this.f4390ch;
                if (c10 != '-') {
                    next();
                } else {
                    next();
                }
                c11 = this.f4390ch;
                if (c11 >= '0') {
                    next();
                    while (true) {
                        c12 = this.f4390ch;
                        if (c12 < '0') {
                        }
                        this.type = Type.Value;
                        return true;
                        next();
                    }
                }
            } while (c5 <= '9');
            if (c5 == '.') {
                next();
                c13 = this.f4390ch;
                if (c13 >= '0') {
                }
                return false;
            }
            c8 = this.f4390ch;
            if (c8 != 'e') {
            }
            next();
            c10 = this.f4390ch;
            if (c10 != '-') {
                next();
            } else {
                next();
            }
            c11 = this.f4390ch;
            if (c11 >= '0') {
                next();
                while (true) {
                    c12 = this.f4390ch;
                    if (c12 < '0') {
                    }
                    this.type = Type.Value;
                    return true;
                    next();
                }
            }
        }
        return false;
    }

    public static JSONValidator from(String str) {
        return new UTF16Validator(str);
    }

    public static JSONValidator fromUtf8(byte[] bArr) {
        return new UTF8Validator(bArr);
    }

    public static final boolean isWhiteSpace(char c5) {
        return c5 == ' ' || c5 == '\t' || c5 == '\r' || c5 == '\n' || c5 == '\f' || c5 == '\b';
    }

    public void fieldName() {
        next();
        while (true) {
            char c5 = this.f4390ch;
            if (c5 == '\\') {
                next();
                if (this.f4390ch == 'u') {
                    next();
                    next();
                    next();
                    next();
                    next();
                } else {
                    next();
                }
            } else {
                if (c5 == '\"') {
                    next();
                    return;
                }
                next();
            }
        }
    }

    public Type getType() {
        if (this.type == null) {
            validate();
        }
        return this.type;
    }

    public boolean isSupportMultiValue() {
        return this.supportMultiValue;
    }

    public abstract void next();

    public JSONValidator setSupportMultiValue(boolean z7) {
        this.supportMultiValue = z7;
        return this;
    }

    public void skipWhiteSpace() {
        while (isWhiteSpace(this.f4390ch)) {
            next();
        }
    }

    public boolean string() {
        next();
        while (!this.eof) {
            char c5 = this.f4390ch;
            if (c5 == '\\') {
                next();
                if (this.f4390ch == 'u') {
                    next();
                    next();
                    next();
                    next();
                    next();
                } else {
                    next();
                }
            } else {
                if (c5 == '\"') {
                    next();
                    return true;
                }
                next();
            }
        }
        return false;
    }

    public boolean validate() {
        Boolean bool = this.validateResult;
        if (bool != null) {
            return bool.booleanValue();
        }
        while (any()) {
            skipWhiteSpace();
            this.count++;
            if (this.eof) {
                this.validateResult = Boolean.TRUE;
                return true;
            }
            if (!this.supportMultiValue) {
                this.validateResult = Boolean.FALSE;
                return false;
            }
            skipWhiteSpace();
            if (this.eof) {
                this.validateResult = Boolean.TRUE;
                return true;
            }
        }
        this.validateResult = Boolean.FALSE;
        return false;
    }

    public static JSONValidator from(Reader reader) {
        return new ReaderValidator(reader);
    }

    public static JSONValidator fromUtf8(InputStream inputStream) {
        return new UTF8InputStreamValidator(inputStream);
    }

    @Override
    public void close() throws IOException {
    }
}

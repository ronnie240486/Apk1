package okio;

import com.lzy.okgo.cache.CacheEntity;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import p000a.AbstractC0004e;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;
import p192r9.AbstractC3643a;
import p192r9.AbstractC3656n;
import p253x8.AbstractC4146i;

public class ByteString implements Serializable, Comparable<ByteString> {
    public static final Companion Companion = new Companion(null);
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;
    private final byte[] data;
    private transient int hashCode;
    private transient String utf8;

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        public static ByteString encodeString$default(Companion companion, String str, Charset charset, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                charset = AbstractC3643a.f12236a;
            }
            return companion.encodeString(str, charset);
        }

        public static ByteString of$default(Companion companion, byte[] bArr, int i6, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i6 = 0;
            }
            if ((i11 & 2) != 0) {
                i10 = SegmentedByteString.getDEFAULT__ByteString_size();
            }
            return companion.m6648of(bArr, i6, i10);
        }

        public final ByteString m8563deprecated_decodeBase64(String str) {
            AbstractC2796i.m5785f(str, "string");
            return decodeBase64(str);
        }

        public final ByteString m8564deprecated_decodeHex(String str) {
            AbstractC2796i.m5785f(str, "string");
            return decodeHex(str);
        }

        public final ByteString m8565deprecated_encodeString(String str, Charset charset) {
            AbstractC2796i.m5785f(str, "string");
            AbstractC2796i.m5785f(charset, "charset");
            return encodeString(str, charset);
        }

        public final ByteString m8566deprecated_encodeUtf8(String str) {
            AbstractC2796i.m5785f(str, "string");
            return encodeUtf8(str);
        }

        public final ByteString m8567deprecated_of(ByteBuffer byteBuffer) {
            AbstractC2796i.m5785f(byteBuffer, "buffer");
            return m6646of(byteBuffer);
        }

        public final ByteString m8569deprecated_read(InputStream inputStream, int i6) {
            AbstractC2796i.m5785f(inputStream, "inputstream");
            return read(inputStream, i6);
        }

        public final ByteString decodeBase64(String str) {
            AbstractC2796i.m5785f(str, "<this>");
            byte[] bArrDecodeBase64ToArray = Base64.decodeBase64ToArray(str);
            if (bArrDecodeBase64ToArray != null) {
                return new ByteString(bArrDecodeBase64ToArray);
            }
            return null;
        }

        public final ByteString decodeHex(String str) {
            AbstractC2796i.m5785f(str, "<this>");
            if (str.length() % 2 != 0) {
                throw new IllegalArgumentException("Unexpected hex string: ".concat(str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i6 = 0; i6 < length; i6++) {
                int i10 = i6 * 2;
                bArr[i6] = (byte) (okio.internal.ByteString.decodeHexDigit(str.charAt(i10 + 1)) + (okio.internal.ByteString.decodeHexDigit(str.charAt(i10)) << 4));
            }
            return new ByteString(bArr);
        }

        public final ByteString encodeString(String str, Charset charset) {
            AbstractC2796i.m5785f(str, "<this>");
            AbstractC2796i.m5785f(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            AbstractC2796i.m5784e(bytes, "getBytes(...)");
            return new ByteString(bytes);
        }

        public final ByteString encodeUtf8(String str) {
            AbstractC2796i.m5785f(str, "<this>");
            ByteString byteString = new ByteString(_JvmPlatformKt.asUtf8ToByteArray(str));
            byteString.setUtf8$okio(str);
            return byteString;
        }

        public final ByteString m6646of(ByteBuffer byteBuffer) {
            AbstractC2796i.m5785f(byteBuffer, "<this>");
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new ByteString(bArr);
        }

        public final ByteString read(InputStream inputStream, int i6) throws IOException {
            AbstractC2796i.m5785f(inputStream, "<this>");
            if (i6 < 0) {
                throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "byteCount < 0: ").toString());
            }
            byte[] bArr = new byte[i6];
            int i10 = 0;
            while (i10 < i6) {
                int i11 = inputStream.read(bArr, i10, i6 - i10);
                if (i11 == -1) {
                    throw new EOFException();
                }
                i10 += i11;
            }
            return new ByteString(bArr);
        }

        private Companion() {
        }

        public final ByteString m8568deprecated_of(byte[] bArr, int i6, int i10) {
            AbstractC2796i.m5785f(bArr, "array");
            return m6648of(bArr, i6, i10);
        }

        public final ByteString m6647of(byte... bArr) {
            AbstractC2796i.m5785f(bArr, "data");
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            AbstractC2796i.m5784e(bArrCopyOf, "copyOf(...)");
            return new ByteString(bArrCopyOf);
        }

        public final ByteString m6648of(byte[] bArr, int i6, int i10) {
            AbstractC2796i.m5785f(bArr, "<this>");
            int iResolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(bArr, i10);
            SegmentedByteString.checkOffsetAndCount(bArr.length, i6, iResolveDefaultParameter);
            return new ByteString(AbstractC4146i.m8174G(bArr, i6, iResolveDefaultParameter + i6));
        }
    }

    public ByteString(byte[] bArr) {
        AbstractC2796i.m5785f(bArr, "data");
        this.data = bArr;
    }

    public static void copyInto$default(ByteString byteString, int i6, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyInto");
        }
        if ((i12 & 1) != 0) {
            i6 = 0;
        }
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        byteString.copyInto(i6, bArr, i10, i11);
    }

    public static final ByteString decodeBase64(String str) {
        return Companion.decodeBase64(str);
    }

    public static final ByteString decodeHex(String str) {
        return Companion.decodeHex(str);
    }

    public static final ByteString encodeString(String str, Charset charset) {
        return Companion.encodeString(str, charset);
    }

    public static final ByteString encodeUtf8(String str) {
        return Companion.encodeUtf8(str);
    }

    public static int indexOf$default(ByteString byteString, ByteString byteString2, int i6, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i10 & 2) != 0) {
            i6 = 0;
        }
        return byteString.indexOf(byteString2, i6);
    }

    public static int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i6, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i10 & 2) != 0) {
            i6 = SegmentedByteString.getDEFAULT__ByteString_size();
        }
        return byteString.lastIndexOf(byteString2, i6);
    }

    public static final ByteString m6643of(ByteBuffer byteBuffer) {
        return Companion.m6646of(byteBuffer);
    }

    public static final ByteString read(InputStream inputStream, int i6) throws IOException {
        return Companion.read(inputStream, i6);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IllegalAccessException, NoSuchFieldException, IOException {
        ByteString byteString = Companion.read(objectInputStream, objectInputStream.readInt());
        Field declaredField = ByteString.class.getDeclaredField("data");
        declaredField.setAccessible(true);
        declaredField.set(this, byteString.data);
    }

    public static ByteString substring$default(ByteString byteString, int i6, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        }
        if ((i11 & 1) != 0) {
            i6 = 0;
        }
        if ((i11 & 2) != 0) {
            i10 = SegmentedByteString.getDEFAULT__ByteString_size();
        }
        return byteString.substring(i6, i10);
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    public final byte m8561deprecated_getByte(int i6) {
        return getByte(i6);
    }

    public final int m8562deprecated_size() {
        return size();
    }

    public ByteBuffer asByteBuffer() {
        ByteBuffer byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        AbstractC2796i.m5784e(byteBufferAsReadOnlyBuffer, "asReadOnlyBuffer(...)");
        return byteBufferAsReadOnlyBuffer;
    }

    public String base64() {
        return Base64.encodeBase64$default(getData$okio(), null, 1, null);
    }

    public String base64Url() {
        return Base64.encodeBase64(getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    public void copyInto(int i6, byte[] bArr, int i10, int i11) {
        AbstractC2796i.m5785f(bArr, "target");
        AbstractC4146i.m8172E(getData$okio(), i10, i6, bArr, i11 + i6);
    }

    public ByteString digest$okio(String str) throws NoSuchAlgorithmException {
        AbstractC2796i.m5785f(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(this.data, 0, size());
        byte[] bArrDigest = messageDigest.digest();
        AbstractC2796i.m5782c(bArrDigest);
        return new ByteString(bArrDigest);
    }

    public final boolean endsWith(ByteString byteString) {
        AbstractC2796i.m5785f(byteString, "suffix");
        return rangeEquals(size() - byteString.size(), byteString, 0, byteString.size());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == getData$okio().length && byteString.rangeEquals(0, getData$okio(), 0, getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public final byte getByte(int i6) {
        return internalGet$okio(i6);
    }

    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    public final String getUtf8$okio() {
        return this.utf8;
    }

    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int iHashCode = Arrays.hashCode(getData$okio());
        setHashCode$okio(iHashCode);
        return iHashCode;
    }

    public String hex() {
        char[] cArr = new char[getData$okio().length * 2];
        int i6 = 0;
        for (byte b8 : getData$okio()) {
            int i10 = i6 + 1;
            cArr[i6] = okio.internal.ByteString.getHEX_DIGIT_CHARS()[(b8 >> 4) & 15];
            i6 += 2;
            cArr[i10] = okio.internal.ByteString.getHEX_DIGIT_CHARS()[b8 & 15];
        }
        return new String(cArr);
    }

    public ByteString hmac$okio(String str, ByteString byteString) throws NoSuchAlgorithmException {
        AbstractC2796i.m5785f(str, "algorithm");
        AbstractC2796i.m5785f(byteString, CacheEntity.KEY);
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            byte[] bArrDoFinal = mac.doFinal(this.data);
            AbstractC2796i.m5784e(bArrDoFinal, "doFinal(...)");
            return new ByteString(bArrDoFinal);
        } catch (InvalidKeyException e5) {
            throw new IllegalArgumentException(e5);
        }
    }

    public ByteString hmacSha1(ByteString byteString) {
        AbstractC2796i.m5785f(byteString, CacheEntity.KEY);
        return hmac$okio("HmacSHA1", byteString);
    }

    public ByteString hmacSha256(ByteString byteString) {
        AbstractC2796i.m5785f(byteString, CacheEntity.KEY);
        return hmac$okio("HmacSHA256", byteString);
    }

    public ByteString hmacSha512(ByteString byteString) {
        AbstractC2796i.m5785f(byteString, CacheEntity.KEY);
        return hmac$okio("HmacSHA512", byteString);
    }

    public final int indexOf(ByteString byteString) {
        AbstractC2796i.m5785f(byteString, "other");
        return indexOf$default(this, byteString, 0, 2, (Object) null);
    }

    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public byte internalGet$okio(int i6) {
        return getData$okio()[i6];
    }

    public final int lastIndexOf(ByteString byteString) {
        AbstractC2796i.m5785f(byteString, "other");
        return lastIndexOf$default(this, byteString, 0, 2, (Object) null);
    }

    public final ByteString md5() {
        return digest$okio("MD5");
    }

    public boolean rangeEquals(int i6, ByteString byteString, int i10, int i11) {
        AbstractC2796i.m5785f(byteString, "other");
        return byteString.rangeEquals(i10, getData$okio(), i6, i11);
    }

    public final void setHashCode$okio(int i6) {
        this.hashCode = i6;
    }

    public final void setUtf8$okio(String str) {
        this.utf8 = str;
    }

    public final ByteString sha1() {
        return digest$okio("SHA-1");
    }

    public final ByteString sha256() {
        return digest$okio("SHA-256");
    }

    public final ByteString sha512() {
        return digest$okio("SHA-512");
    }

    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(ByteString byteString) {
        AbstractC2796i.m5785f(byteString, "prefix");
        return rangeEquals(0, byteString, 0, byteString.size());
    }

    public String string(Charset charset) {
        AbstractC2796i.m5785f(charset, "charset");
        return new String(this.data, charset);
    }

    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    public ByteString toAsciiLowercase() {
        for (int i6 = 0; i6 < getData$okio().length; i6++) {
            byte b8 = getData$okio()[i6];
            if (b8 >= 65 && b8 <= 90) {
                byte[] data$okio = getData$okio();
                byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
                AbstractC2796i.m5784e(bArrCopyOf, "copyOf(...)");
                bArrCopyOf[i6] = (byte) (b8 + 32);
                for (int i10 = i6 + 1; i10 < bArrCopyOf.length; i10++) {
                    byte b10 = bArrCopyOf[i10];
                    if (b10 >= 65 && b10 <= 90) {
                        bArrCopyOf[i10] = (byte) (b10 + 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return this;
    }

    public ByteString toAsciiUppercase() {
        for (int i6 = 0; i6 < getData$okio().length; i6++) {
            byte b8 = getData$okio()[i6];
            if (b8 >= 97 && b8 <= 122) {
                byte[] data$okio = getData$okio();
                byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
                AbstractC2796i.m5784e(bArrCopyOf, "copyOf(...)");
                bArrCopyOf[i6] = (byte) (b8 - 32);
                for (int i10 = i6 + 1; i10 < bArrCopyOf.length; i10++) {
                    byte b10 = bArrCopyOf[i10];
                    if (b10 >= 97 && b10 <= 122) {
                        bArrCopyOf[i10] = (byte) (b10 - 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return this;
    }

    public byte[] toByteArray() {
        byte[] data$okio = getData$okio();
        byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
        AbstractC2796i.m5784e(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    public String toString() {
        if (getData$okio().length == 0) {
            return "[size=0]";
        }
        int iCodePointIndexToCharIndex = okio.internal.ByteString.codePointIndexToCharIndex(getData$okio(), 64);
        if (iCodePointIndexToCharIndex != -1) {
            String strUtf8 = utf8();
            String strSubstring = strUtf8.substring(0, iCodePointIndexToCharIndex);
            AbstractC2796i.m5784e(strSubstring, "substring(...)");
            String strM7402T = AbstractC3656n.m7402T(AbstractC3656n.m7402T(AbstractC3656n.m7402T(strSubstring, "\\", "\\\\"), "\n", "\\n"), "\r", "\\r");
            if (iCodePointIndexToCharIndex >= strUtf8.length()) {
                return "[text=" + strM7402T + ']';
            }
            return "[size=" + getData$okio().length + " text=" + strM7402T + "…]";
        }
        if (getData$okio().length <= 64) {
            return "[hex=" + hex() + ']';
        }
        StringBuilder sb = new StringBuilder("[size=");
        sb.append(getData$okio().length);
        sb.append(" hex=");
        int iResolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(this, 64);
        if (iResolveDefaultParameter > getData$okio().length) {
            throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
        }
        if (iResolveDefaultParameter < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        sb.append((iResolveDefaultParameter == getData$okio().length ? this : new ByteString(AbstractC4146i.m8174G(getData$okio(), 0, iResolveDefaultParameter))).hex());
        sb.append("…]");
        return sb.toString();
    }

    public String utf8() {
        String utf8$okio = getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = _JvmPlatformKt.toUtf8String(internalArray$okio());
        setUtf8$okio(utf8String);
        return utf8String;
    }

    public void write(OutputStream outputStream) throws IOException {
        AbstractC2796i.m5785f(outputStream, "out");
        outputStream.write(this.data);
    }

    public void write$okio(Buffer buffer, int i6, int i10) {
        AbstractC2796i.m5785f(buffer, "buffer");
        okio.internal.ByteString.commonWrite(this, buffer, i6, i10);
    }

    public static int indexOf$default(ByteString byteString, byte[] bArr, int i6, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i10 & 2) != 0) {
            i6 = 0;
        }
        return byteString.indexOf(bArr, i6);
    }

    public static final ByteString m6644of(byte... bArr) {
        return Companion.m6647of(bArr);
    }

    @Override
    public int compareTo(ByteString byteString) {
        AbstractC2796i.m5785f(byteString, "other");
        int size = size();
        int size2 = byteString.size();
        int iMin = Math.min(size, size2);
        for (int i6 = 0; i6 < iMin; i6++) {
            int i10 = getByte(i6) & 255;
            int i11 = byteString.getByte(i6) & 255;
            if (i10 != i11) {
                if (i10 < i11) {
                    return -1;
                }
                return 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        if (size < size2) {
            return -1;
        }
        return 1;
    }

    public final boolean endsWith(byte[] bArr) {
        AbstractC2796i.m5785f(bArr, "suffix");
        return rangeEquals(size() - bArr.length, bArr, 0, bArr.length);
    }

    public final int indexOf(byte[] bArr) {
        AbstractC2796i.m5785f(bArr, "other");
        return indexOf$default(this, bArr, 0, 2, (Object) null);
    }

    public final int lastIndexOf(byte[] bArr) {
        AbstractC2796i.m5785f(bArr, "other");
        return lastIndexOf$default(this, bArr, 0, 2, (Object) null);
    }

    public boolean rangeEquals(int i6, byte[] bArr, int i10, int i11) {
        AbstractC2796i.m5785f(bArr, "other");
        return i6 >= 0 && i6 <= getData$okio().length - i11 && i10 >= 0 && i10 <= bArr.length - i11 && SegmentedByteString.arrayRangeEquals(getData$okio(), i6, bArr, i10, i11);
    }

    public final boolean startsWith(byte[] bArr) {
        AbstractC2796i.m5785f(bArr, "prefix");
        return rangeEquals(0, bArr, 0, bArr.length);
    }

    public final ByteString substring(int i6) {
        return substring$default(this, i6, 0, 2, null);
    }

    public static int lastIndexOf$default(ByteString byteString, byte[] bArr, int i6, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i10 & 2) != 0) {
            i6 = SegmentedByteString.getDEFAULT__ByteString_size();
        }
        return byteString.lastIndexOf(bArr, i6);
    }

    public static final ByteString m6645of(byte[] bArr, int i6, int i10) {
        return Companion.m6648of(bArr, i6, i10);
    }

    public final int indexOf(ByteString byteString, int i6) {
        AbstractC2796i.m5785f(byteString, "other");
        return indexOf(byteString.internalArray$okio(), i6);
    }

    public final int lastIndexOf(ByteString byteString, int i6) {
        AbstractC2796i.m5785f(byteString, "other");
        return lastIndexOf(byteString.internalArray$okio(), i6);
    }

    public ByteString substring(int i6, int i10) {
        int iResolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(this, i10);
        if (i6 >= 0) {
            if (iResolveDefaultParameter <= getData$okio().length) {
                if (iResolveDefaultParameter - i6 >= 0) {
                    return (i6 == 0 && iResolveDefaultParameter == getData$okio().length) ? this : new ByteString(AbstractC4146i.m8174G(getData$okio(), i6, iResolveDefaultParameter));
                }
                throw new IllegalArgumentException("endIndex < beginIndex");
            }
            throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    public int indexOf(byte[] bArr, int i6) {
        AbstractC2796i.m5785f(bArr, "other");
        int length = getData$okio().length - bArr.length;
        int iMax = Math.max(i6, 0);
        if (iMax <= length) {
            while (!SegmentedByteString.arrayRangeEquals(getData$okio(), iMax, bArr, 0, bArr.length)) {
                if (iMax != length) {
                    iMax++;
                }
            }
            return iMax;
        }
        return -1;
    }

    public int lastIndexOf(byte[] bArr, int i6) {
        AbstractC2796i.m5785f(bArr, "other");
        for (int iMin = Math.min(SegmentedByteString.resolveDefaultParameter(this, i6), getData$okio().length - bArr.length); -1 < iMin; iMin--) {
            if (SegmentedByteString.arrayRangeEquals(getData$okio(), iMin, bArr, 0, bArr.length)) {
                return iMin;
            }
        }
        return -1;
    }
}

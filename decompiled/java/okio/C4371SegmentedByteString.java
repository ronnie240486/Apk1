package okio;

import com.lzy.okgo.cache.CacheEntity;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import p000a.AbstractC0004e;
import p055ea.AbstractC2460q;
import p103j9.AbstractC2796i;
import p253x8.AbstractC4146i;

public final class C4371SegmentedByteString extends ByteString {
    private final transient int[] directory;
    private final transient byte[][] segments;

    public C4371SegmentedByteString(byte[][] bArr, int[] iArr) {
        super(ByteString.EMPTY.getData$okio());
        AbstractC2796i.m5785f(bArr, "segments");
        AbstractC2796i.m5785f(iArr, "directory");
        this.segments = bArr;
        this.directory = iArr;
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private final Object writeReplace() {
        ByteString byteString = toByteString();
        AbstractC2796i.m5783d(byteString, "null cannot be cast to non-null type java.lang.Object");
        return byteString;
    }

    @Override
    public ByteBuffer asByteBuffer() {
        ByteBuffer byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        AbstractC2796i.m5784e(byteBufferAsReadOnlyBuffer, "asReadOnlyBuffer(...)");
        return byteBufferAsReadOnlyBuffer;
    }

    @Override
    public String base64() {
        return toByteString().base64();
    }

    @Override
    public String base64Url() {
        return toByteString().base64Url();
    }

    @Override
    public void copyInto(int i6, byte[] bArr, int i10, int i11) {
        AbstractC2796i.m5785f(bArr, "target");
        long j10 = i11;
        SegmentedByteString.checkOffsetAndCount(size(), i6, j10);
        SegmentedByteString.checkOffsetAndCount(bArr.length, i10, j10);
        int i12 = i11 + i6;
        int iSegment = okio.internal.SegmentedByteString.segment(this, i6);
        while (i6 < i12) {
            int i13 = iSegment == 0 ? 0 : getDirectory$okio()[iSegment - 1];
            int i14 = getDirectory$okio()[iSegment] - i13;
            int i15 = getDirectory$okio()[getSegments$okio().length + iSegment];
            int iMin = Math.min(i12, i14 + i13) - i6;
            int i16 = (i6 - i13) + i15;
            AbstractC4146i.m8172E(getSegments$okio()[iSegment], i10, i16, bArr, i16 + iMin);
            i10 += iMin;
            i6 += iMin;
            iSegment++;
        }
    }

    @Override
    public ByteString digest$okio(String str) throws NoSuchAlgorithmException {
        AbstractC2796i.m5785f(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        int length = getSegments$okio().length;
        int i6 = 0;
        int i10 = 0;
        while (i6 < length) {
            int i11 = getDirectory$okio()[length + i6];
            int i12 = getDirectory$okio()[i6];
            messageDigest.update(getSegments$okio()[i6], i11, i12 - i10);
            i6++;
            i10 = i12;
        }
        byte[] bArrDigest = messageDigest.digest();
        AbstractC2796i.m5782c(bArrDigest);
        return new ByteString(bArrDigest);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    public final int[] getDirectory$okio() {
        return this.directory;
    }

    public final byte[][] getSegments$okio() {
        return this.segments;
    }

    @Override
    public int getSize$okio() {
        return getDirectory$okio()[getSegments$okio().length - 1];
    }

    @Override
    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = getSegments$okio().length;
        int i6 = 0;
        int i10 = 1;
        int i11 = 0;
        while (i6 < length) {
            int i12 = getDirectory$okio()[length + i6];
            int i13 = getDirectory$okio()[i6];
            byte[] bArr = getSegments$okio()[i6];
            int i14 = (i13 - i11) + i12;
            while (i12 < i14) {
                i10 = (i10 * 31) + bArr[i12];
                i12++;
            }
            i6++;
            i11 = i13;
        }
        setHashCode$okio(i10);
        return i10;
    }

    @Override
    public String hex() {
        return toByteString().hex();
    }

    @Override
    public ByteString hmac$okio(String str, ByteString byteString) throws NoSuchAlgorithmException {
        AbstractC2796i.m5785f(str, "algorithm");
        AbstractC2796i.m5785f(byteString, CacheEntity.KEY);
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            int length = getSegments$okio().length;
            int i6 = 0;
            int i10 = 0;
            while (i6 < length) {
                int i11 = getDirectory$okio()[length + i6];
                int i12 = getDirectory$okio()[i6];
                mac.update(getSegments$okio()[i6], i11, i12 - i10);
                i6++;
                i10 = i12;
            }
            byte[] bArrDoFinal = mac.doFinal();
            AbstractC2796i.m5784e(bArrDoFinal, "doFinal(...)");
            return new ByteString(bArrDoFinal);
        } catch (InvalidKeyException e5) {
            throw new IllegalArgumentException(e5);
        }
    }

    @Override
    public int indexOf(byte[] bArr, int i6) {
        AbstractC2796i.m5785f(bArr, "other");
        return toByteString().indexOf(bArr, i6);
    }

    @Override
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override
    public byte internalGet$okio(int i6) {
        SegmentedByteString.checkOffsetAndCount(getDirectory$okio()[getSegments$okio().length - 1], i6, 1L);
        int iSegment = okio.internal.SegmentedByteString.segment(this, i6);
        return getSegments$okio()[iSegment][(i6 - (iSegment == 0 ? 0 : getDirectory$okio()[iSegment - 1])) + getDirectory$okio()[getSegments$okio().length + iSegment]];
    }

    @Override
    public int lastIndexOf(byte[] bArr, int i6) {
        AbstractC2796i.m5785f(bArr, "other");
        return toByteString().lastIndexOf(bArr, i6);
    }

    @Override
    public boolean rangeEquals(int i6, ByteString byteString, int i10, int i11) {
        AbstractC2796i.m5785f(byteString, "other");
        if (i6 < 0 || i6 > size() - i11) {
            return false;
        }
        int i12 = i11 + i6;
        int iSegment = okio.internal.SegmentedByteString.segment(this, i6);
        while (i6 < i12) {
            int i13 = iSegment == 0 ? 0 : getDirectory$okio()[iSegment - 1];
            int i14 = getDirectory$okio()[iSegment] - i13;
            int i15 = getDirectory$okio()[getSegments$okio().length + iSegment];
            int iMin = Math.min(i12, i14 + i13) - i6;
            if (!byteString.rangeEquals(i10, getSegments$okio()[iSegment], (i6 - i13) + i15, iMin)) {
                return false;
            }
            i10 += iMin;
            i6 += iMin;
            iSegment++;
        }
        return true;
    }

    @Override
    public String string(Charset charset) {
        AbstractC2796i.m5785f(charset, "charset");
        return toByteString().string(charset);
    }

    @Override
    public ByteString substring(int i6, int i10) {
        int iResolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(this, i10);
        if (i6 < 0) {
            throw new IllegalArgumentException(AbstractC2460q.m5492f(i6, "beginIndex=", " < 0").toString());
        }
        if (iResolveDefaultParameter > size()) {
            StringBuilder sbM27u = AbstractC0004e.m27u(iResolveDefaultParameter, "endIndex=", " > length(");
            sbM27u.append(size());
            sbM27u.append(')');
            throw new IllegalArgumentException(sbM27u.toString().toString());
        }
        int i11 = iResolveDefaultParameter - i6;
        if (i11 < 0) {
            throw new IllegalArgumentException(AbstractC0004e.m19m(iResolveDefaultParameter, i6, "endIndex=", " < beginIndex=").toString());
        }
        if (i6 == 0 && iResolveDefaultParameter == size()) {
            return this;
        }
        if (i6 == iResolveDefaultParameter) {
            return ByteString.EMPTY;
        }
        int iSegment = okio.internal.SegmentedByteString.segment(this, i6);
        int iSegment2 = okio.internal.SegmentedByteString.segment(this, iResolveDefaultParameter - 1);
        byte[][] bArr = (byte[][]) AbstractC4146i.m8175H(getSegments$okio(), iSegment, iSegment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iSegment <= iSegment2) {
            int i12 = iSegment;
            int i13 = 0;
            while (true) {
                iArr[i13] = Math.min(getDirectory$okio()[i12] - i6, i11);
                int i14 = i13 + 1;
                iArr[i13 + bArr.length] = getDirectory$okio()[getSegments$okio().length + i12];
                if (i12 == iSegment2) {
                    break;
                }
                i12++;
                i13 = i14;
            }
        }
        int i15 = iSegment != 0 ? getDirectory$okio()[iSegment - 1] : 0;
        int length = bArr.length;
        iArr[length] = (i6 - i15) + iArr[length];
        return new C4371SegmentedByteString(bArr, iArr);
    }

    @Override
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override
    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = getSegments$okio().length;
        int i6 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i6 < length) {
            int i12 = getDirectory$okio()[length + i6];
            int i13 = getDirectory$okio()[i6];
            int i14 = i13 - i10;
            AbstractC4146i.m8172E(getSegments$okio()[i6], i11, i12, bArr, i12 + i14);
            i11 += i14;
            i6++;
            i10 = i13;
        }
        return bArr;
    }

    @Override
    public String toString() {
        return toByteString().toString();
    }

    @Override
    public void write(OutputStream outputStream) throws IOException {
        AbstractC2796i.m5785f(outputStream, "out");
        int length = getSegments$okio().length;
        int i6 = 0;
        int i10 = 0;
        while (i6 < length) {
            int i11 = getDirectory$okio()[length + i6];
            int i12 = getDirectory$okio()[i6];
            outputStream.write(getSegments$okio()[i6], i11, i12 - i10);
            i6++;
            i10 = i12;
        }
    }

    @Override
    public void write$okio(Buffer buffer, int i6, int i10) {
        AbstractC2796i.m5785f(buffer, "buffer");
        int i11 = i6 + i10;
        int iSegment = okio.internal.SegmentedByteString.segment(this, i6);
        while (i6 < i11) {
            int i12 = iSegment == 0 ? 0 : getDirectory$okio()[iSegment - 1];
            int i13 = getDirectory$okio()[iSegment] - i12;
            int i14 = getDirectory$okio()[getSegments$okio().length + iSegment];
            int iMin = Math.min(i11, i13 + i12) - i6;
            int i15 = (i6 - i12) + i14;
            Segment segment = new Segment(getSegments$okio()[iSegment], i15, i15 + iMin, true, false);
            Segment segment2 = buffer.head;
            if (segment2 == null) {
                segment.prev = segment;
                segment.next = segment;
                buffer.head = segment;
            } else {
                AbstractC2796i.m5782c(segment2);
                Segment segment3 = segment2.prev;
                AbstractC2796i.m5782c(segment3);
                segment3.push(segment);
            }
            i6 += iMin;
            iSegment++;
        }
        buffer.setSize$okio(buffer.size() + ((long) i10));
    }

    @Override
    public boolean rangeEquals(int i6, byte[] bArr, int i10, int i11) {
        AbstractC2796i.m5785f(bArr, "other");
        if (i6 < 0 || i6 > size() - i11 || i10 < 0 || i10 > bArr.length - i11) {
            return false;
        }
        int i12 = i11 + i6;
        int iSegment = okio.internal.SegmentedByteString.segment(this, i6);
        while (i6 < i12) {
            int i13 = iSegment == 0 ? 0 : getDirectory$okio()[iSegment - 1];
            int i14 = getDirectory$okio()[iSegment] - i13;
            int i15 = getDirectory$okio()[getSegments$okio().length + iSegment];
            int iMin = Math.min(i12, i14 + i13) - i6;
            if (!SegmentedByteString.arrayRangeEquals(getSegments$okio()[iSegment], (i6 - i13) + i15, bArr, i10, iMin)) {
                return false;
            }
            i10 += iMin;
            i6 += iMin;
            iSegment++;
        }
        return true;
    }
}

package okio.internal;

import okio.Buffer;
import okio.ByteString;
import okio.C4371SegmentedByteString;
import okio.Segment;
import p000a.AbstractC0004e;
import p055ea.AbstractC2460q;
import p091i9.InterfaceC2729q;
import p103j9.AbstractC2796i;
import p253x8.AbstractC4146i;
import qa.C3561i;

public final class SegmentedByteString {
    public static final int binarySearch(int[] iArr, int i6, int i10, int i11) {
        AbstractC2796i.m5785f(iArr, "<this>");
        int i12 = i11 - 1;
        while (i10 <= i12) {
            int i13 = (i10 + i12) >>> 1;
            int i14 = iArr[i13];
            if (i14 < i6) {
                i10 = i13 + 1;
            } else {
                if (i14 <= i6) {
                    return i13;
                }
                i12 = i13 - 1;
            }
        }
        return (-i10) - 1;
    }

    public static final void commonCopyInto(C4371SegmentedByteString c4371SegmentedByteString, int i6, byte[] bArr, int i10, int i11) {
        AbstractC2796i.m5785f(c4371SegmentedByteString, "<this>");
        AbstractC2796i.m5785f(bArr, "target");
        long j10 = i11;
        okio.SegmentedByteString.checkOffsetAndCount(c4371SegmentedByteString.size(), i6, j10);
        okio.SegmentedByteString.checkOffsetAndCount(bArr.length, i10, j10);
        int i12 = i11 + i6;
        int iSegment = segment(c4371SegmentedByteString, i6);
        while (i6 < i12) {
            int i13 = iSegment == 0 ? 0 : c4371SegmentedByteString.getDirectory$okio()[iSegment - 1];
            int i14 = c4371SegmentedByteString.getDirectory$okio()[iSegment] - i13;
            int i15 = c4371SegmentedByteString.getDirectory$okio()[c4371SegmentedByteString.getSegments$okio().length + iSegment];
            int iMin = Math.min(i12, i14 + i13) - i6;
            int i16 = (i6 - i13) + i15;
            AbstractC4146i.m8172E(c4371SegmentedByteString.getSegments$okio()[iSegment], i10, i16, bArr, i16 + iMin);
            i10 += iMin;
            i6 += iMin;
            iSegment++;
        }
    }

    public static final boolean commonEquals(C4371SegmentedByteString c4371SegmentedByteString, Object obj) {
        AbstractC2796i.m5785f(c4371SegmentedByteString, "<this>");
        if (obj == c4371SegmentedByteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == c4371SegmentedByteString.size() && c4371SegmentedByteString.rangeEquals(0, byteString, 0, c4371SegmentedByteString.size())) {
                return true;
            }
        }
        return false;
    }

    public static final int commonGetSize(C4371SegmentedByteString c4371SegmentedByteString) {
        AbstractC2796i.m5785f(c4371SegmentedByteString, "<this>");
        return c4371SegmentedByteString.getDirectory$okio()[c4371SegmentedByteString.getSegments$okio().length - 1];
    }

    public static final int commonHashCode(C4371SegmentedByteString c4371SegmentedByteString) {
        AbstractC2796i.m5785f(c4371SegmentedByteString, "<this>");
        int hashCode$okio = c4371SegmentedByteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = c4371SegmentedByteString.getSegments$okio().length;
        int i6 = 0;
        int i10 = 0;
        int i11 = 1;
        while (i6 < length) {
            int i12 = c4371SegmentedByteString.getDirectory$okio()[length + i6];
            int i13 = c4371SegmentedByteString.getDirectory$okio()[i6];
            byte[] bArr = c4371SegmentedByteString.getSegments$okio()[i6];
            int i14 = (i13 - i10) + i12;
            while (i12 < i14) {
                i11 = (i11 * 31) + bArr[i12];
                i12++;
            }
            i6++;
            i10 = i13;
        }
        c4371SegmentedByteString.setHashCode$okio(i11);
        return i11;
    }

    public static final byte commonInternalGet(C4371SegmentedByteString c4371SegmentedByteString, int i6) {
        AbstractC2796i.m5785f(c4371SegmentedByteString, "<this>");
        okio.SegmentedByteString.checkOffsetAndCount(c4371SegmentedByteString.getDirectory$okio()[c4371SegmentedByteString.getSegments$okio().length - 1], i6, 1L);
        int iSegment = segment(c4371SegmentedByteString, i6);
        return c4371SegmentedByteString.getSegments$okio()[iSegment][(i6 - (iSegment == 0 ? 0 : c4371SegmentedByteString.getDirectory$okio()[iSegment - 1])) + c4371SegmentedByteString.getDirectory$okio()[c4371SegmentedByteString.getSegments$okio().length + iSegment]];
    }

    public static final boolean commonRangeEquals(C4371SegmentedByteString c4371SegmentedByteString, int i6, ByteString byteString, int i10, int i11) {
        AbstractC2796i.m5785f(c4371SegmentedByteString, "<this>");
        AbstractC2796i.m5785f(byteString, "other");
        if (i6 < 0 || i6 > c4371SegmentedByteString.size() - i11) {
            return false;
        }
        int i12 = i11 + i6;
        int iSegment = segment(c4371SegmentedByteString, i6);
        while (i6 < i12) {
            int i13 = iSegment == 0 ? 0 : c4371SegmentedByteString.getDirectory$okio()[iSegment - 1];
            int i14 = c4371SegmentedByteString.getDirectory$okio()[iSegment] - i13;
            int i15 = c4371SegmentedByteString.getDirectory$okio()[c4371SegmentedByteString.getSegments$okio().length + iSegment];
            int iMin = Math.min(i12, i14 + i13) - i6;
            if (!byteString.rangeEquals(i10, c4371SegmentedByteString.getSegments$okio()[iSegment], (i6 - i13) + i15, iMin)) {
                return false;
            }
            i10 += iMin;
            i6 += iMin;
            iSegment++;
        }
        return true;
    }

    public static final ByteString commonSubstring(C4371SegmentedByteString c4371SegmentedByteString, int i6, int i10) {
        AbstractC2796i.m5785f(c4371SegmentedByteString, "<this>");
        int iResolveDefaultParameter = okio.SegmentedByteString.resolveDefaultParameter(c4371SegmentedByteString, i10);
        if (i6 < 0) {
            throw new IllegalArgumentException(AbstractC2460q.m5492f(i6, "beginIndex=", " < 0").toString());
        }
        if (iResolveDefaultParameter > c4371SegmentedByteString.size()) {
            StringBuilder sbM27u = AbstractC0004e.m27u(iResolveDefaultParameter, "endIndex=", " > length(");
            sbM27u.append(c4371SegmentedByteString.size());
            sbM27u.append(')');
            throw new IllegalArgumentException(sbM27u.toString().toString());
        }
        int i11 = iResolveDefaultParameter - i6;
        if (i11 < 0) {
            throw new IllegalArgumentException(AbstractC0004e.m19m(iResolveDefaultParameter, i6, "endIndex=", " < beginIndex=").toString());
        }
        if (i6 == 0 && iResolveDefaultParameter == c4371SegmentedByteString.size()) {
            return c4371SegmentedByteString;
        }
        if (i6 == iResolveDefaultParameter) {
            return ByteString.EMPTY;
        }
        int iSegment = segment(c4371SegmentedByteString, i6);
        int iSegment2 = segment(c4371SegmentedByteString, iResolveDefaultParameter - 1);
        byte[][] bArr = (byte[][]) AbstractC4146i.m8175H(c4371SegmentedByteString.getSegments$okio(), iSegment, iSegment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iSegment <= iSegment2) {
            int i12 = iSegment;
            int i13 = 0;
            while (true) {
                iArr[i13] = Math.min(c4371SegmentedByteString.getDirectory$okio()[i12] - i6, i11);
                int i14 = i13 + 1;
                iArr[i13 + bArr.length] = c4371SegmentedByteString.getDirectory$okio()[c4371SegmentedByteString.getSegments$okio().length + i12];
                if (i12 == iSegment2) {
                    break;
                }
                i12++;
                i13 = i14;
            }
        }
        int i15 = iSegment != 0 ? c4371SegmentedByteString.getDirectory$okio()[iSegment - 1] : 0;
        int length = bArr.length;
        iArr[length] = (i6 - i15) + iArr[length];
        return new C4371SegmentedByteString(bArr, iArr);
    }

    public static final byte[] commonToByteArray(C4371SegmentedByteString c4371SegmentedByteString) {
        AbstractC2796i.m5785f(c4371SegmentedByteString, "<this>");
        byte[] bArr = new byte[c4371SegmentedByteString.size()];
        int length = c4371SegmentedByteString.getSegments$okio().length;
        int i6 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i6 < length) {
            int i12 = c4371SegmentedByteString.getDirectory$okio()[length + i6];
            int i13 = c4371SegmentedByteString.getDirectory$okio()[i6];
            int i14 = i13 - i10;
            AbstractC4146i.m8172E(c4371SegmentedByteString.getSegments$okio()[i6], i11, i12, bArr, i12 + i14);
            i11 += i14;
            i6++;
            i10 = i13;
        }
        return bArr;
    }

    public static final void commonWrite(C4371SegmentedByteString c4371SegmentedByteString, Buffer buffer, int i6, int i10) {
        AbstractC2796i.m5785f(c4371SegmentedByteString, "<this>");
        AbstractC2796i.m5785f(buffer, "buffer");
        int i11 = i6 + i10;
        int iSegment = segment(c4371SegmentedByteString, i6);
        while (i6 < i11) {
            int i12 = iSegment == 0 ? 0 : c4371SegmentedByteString.getDirectory$okio()[iSegment - 1];
            int i13 = c4371SegmentedByteString.getDirectory$okio()[iSegment] - i12;
            int i14 = c4371SegmentedByteString.getDirectory$okio()[c4371SegmentedByteString.getSegments$okio().length + iSegment];
            int iMin = Math.min(i11, i13 + i12) - i6;
            int i15 = (i6 - i12) + i14;
            Segment segment = new Segment(c4371SegmentedByteString.getSegments$okio()[iSegment], i15, i15 + iMin, true, false);
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

    public static final void forEachSegment(C4371SegmentedByteString c4371SegmentedByteString, InterfaceC2729q interfaceC2729q) {
        AbstractC2796i.m5785f(c4371SegmentedByteString, "<this>");
        AbstractC2796i.m5785f(interfaceC2729q, "action");
        int length = c4371SegmentedByteString.getSegments$okio().length;
        int i6 = 0;
        int i10 = 0;
        while (i6 < length) {
            int i11 = c4371SegmentedByteString.getDirectory$okio()[length + i6];
            int i12 = c4371SegmentedByteString.getDirectory$okio()[i6];
            ((C3561i) interfaceC2729q).m7174a(c4371SegmentedByteString.getSegments$okio()[i6], Integer.valueOf(i11), Integer.valueOf(i12 - i10));
            i6++;
            i10 = i12;
        }
    }

    public static final int segment(C4371SegmentedByteString c4371SegmentedByteString, int i6) {
        AbstractC2796i.m5785f(c4371SegmentedByteString, "<this>");
        int iBinarySearch = binarySearch(c4371SegmentedByteString.getDirectory$okio(), i6 + 1, 0, c4371SegmentedByteString.getSegments$okio().length);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    private static final void forEachSegment(C4371SegmentedByteString c4371SegmentedByteString, int i6, int i10, InterfaceC2729q interfaceC2729q) {
        int iSegment = segment(c4371SegmentedByteString, i6);
        while (i6 < i10) {
            int i11 = iSegment == 0 ? 0 : c4371SegmentedByteString.getDirectory$okio()[iSegment - 1];
            int i12 = c4371SegmentedByteString.getDirectory$okio()[iSegment] - i11;
            int i13 = c4371SegmentedByteString.getDirectory$okio()[c4371SegmentedByteString.getSegments$okio().length + iSegment];
            int iMin = Math.min(i10, i12 + i11) - i6;
            ((C3561i) interfaceC2729q).m7174a(c4371SegmentedByteString.getSegments$okio()[iSegment], Integer.valueOf((i6 - i11) + i13), Integer.valueOf(iMin));
            i6 += iMin;
            iSegment++;
        }
    }

    public static final boolean commonRangeEquals(C4371SegmentedByteString c4371SegmentedByteString, int i6, byte[] bArr, int i10, int i11) {
        AbstractC2796i.m5785f(c4371SegmentedByteString, "<this>");
        AbstractC2796i.m5785f(bArr, "other");
        if (i6 < 0 || i6 > c4371SegmentedByteString.size() - i11 || i10 < 0 || i10 > bArr.length - i11) {
            return false;
        }
        int i12 = i11 + i6;
        int iSegment = segment(c4371SegmentedByteString, i6);
        while (i6 < i12) {
            int i13 = iSegment == 0 ? 0 : c4371SegmentedByteString.getDirectory$okio()[iSegment - 1];
            int i14 = c4371SegmentedByteString.getDirectory$okio()[iSegment] - i13;
            int i15 = c4371SegmentedByteString.getDirectory$okio()[c4371SegmentedByteString.getSegments$okio().length + iSegment];
            int iMin = Math.min(i12, i14 + i13) - i6;
            if (!okio.SegmentedByteString.arrayRangeEquals(c4371SegmentedByteString.getSegments$okio()[iSegment], (i6 - i13) + i15, bArr, i10, iMin)) {
                return false;
            }
            i10 += iMin;
            i6 += iMin;
            iSegment++;
        }
        return true;
    }
}

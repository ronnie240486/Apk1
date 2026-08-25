package okio;

import java.util.Arrays;
import p103j9.AbstractC2793f;
import p103j9.AbstractC2796i;
import p253x8.AbstractC4146i;

public final class Segment {
    public static final Companion Companion = new Companion(null);
    public static final int SHARE_MINIMUM = 1024;
    public static final int SIZE = 8192;
    public final byte[] data;
    public int limit;
    public Segment next;
    public boolean owner;
    public int pos;
    public Segment prev;
    public boolean shared;

    public static final class Companion {
        public Companion(AbstractC2793f abstractC2793f) {
            this();
        }

        private Companion() {
        }
    }

    public Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public final void compact() {
        int i6;
        Segment segment = this.prev;
        if (segment == this) {
            throw new IllegalStateException("cannot compact");
        }
        AbstractC2796i.m5782c(segment);
        if (segment.owner) {
            int i10 = this.limit - this.pos;
            Segment segment2 = this.prev;
            AbstractC2796i.m5782c(segment2);
            int i11 = 8192 - segment2.limit;
            Segment segment3 = this.prev;
            AbstractC2796i.m5782c(segment3);
            if (segment3.shared) {
                i6 = 0;
            } else {
                Segment segment4 = this.prev;
                AbstractC2796i.m5782c(segment4);
                i6 = segment4.pos;
            }
            if (i10 > i11 + i6) {
                return;
            }
            Segment segment5 = this.prev;
            AbstractC2796i.m5782c(segment5);
            writeTo(segment5, i10);
            pop();
            SegmentPool.recycle(this);
        }
    }

    public final Segment pop() {
        Segment segment = this.next;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.prev;
        AbstractC2796i.m5782c(segment2);
        segment2.next = this.next;
        Segment segment3 = this.next;
        AbstractC2796i.m5782c(segment3);
        segment3.prev = this.prev;
        this.next = null;
        this.prev = null;
        return segment;
    }

    public final Segment push(Segment segment) {
        AbstractC2796i.m5785f(segment, "segment");
        segment.prev = this;
        segment.next = this.next;
        Segment segment2 = this.next;
        AbstractC2796i.m5782c(segment2);
        segment2.prev = segment;
        this.next = segment;
        return segment;
    }

    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    public final Segment split(int i6) {
        Segment segmentTake;
        if (i6 <= 0 || i6 > this.limit - this.pos) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if (i6 >= 1024) {
            segmentTake = sharedCopy();
        } else {
            segmentTake = SegmentPool.take();
            byte[] bArr = this.data;
            byte[] bArr2 = segmentTake.data;
            int i10 = this.pos;
            AbstractC4146i.m8172E(bArr, 0, i10, bArr2, i10 + i6);
        }
        segmentTake.limit = segmentTake.pos + i6;
        this.pos += i6;
        Segment segment = this.prev;
        AbstractC2796i.m5782c(segment);
        segment.push(segmentTake);
        return segmentTake;
    }

    public final Segment unsharedCopy() {
        byte[] bArr = this.data;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        AbstractC2796i.m5784e(bArrCopyOf, "copyOf(...)");
        return new Segment(bArrCopyOf, this.pos, this.limit, false, true);
    }

    public final void writeTo(Segment segment, int i6) {
        AbstractC2796i.m5785f(segment, "sink");
        if (!segment.owner) {
            throw new IllegalStateException("only owner can write");
        }
        int i10 = segment.limit;
        int i11 = i10 + i6;
        if (i11 > 8192) {
            if (segment.shared) {
                throw new IllegalArgumentException();
            }
            int i12 = segment.pos;
            if (i11 - i12 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = segment.data;
            AbstractC4146i.m8172E(bArr, 0, i12, bArr, i10);
            segment.limit -= segment.pos;
            segment.pos = 0;
        }
        byte[] bArr2 = this.data;
        byte[] bArr3 = segment.data;
        int i13 = segment.limit;
        int i14 = this.pos;
        AbstractC4146i.m8172E(bArr2, i13, i14, bArr3, i14 + i6);
        segment.limit += i6;
        this.pos += i6;
    }

    public Segment(byte[] bArr, int i6, int i10, boolean z7, boolean z10) {
        AbstractC2796i.m5785f(bArr, "data");
        this.data = bArr;
        this.pos = i6;
        this.limit = i10;
        this.shared = z7;
        this.owner = z10;
    }
}

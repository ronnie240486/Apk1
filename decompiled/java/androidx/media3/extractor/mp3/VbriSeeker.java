package androidx.media3.extractor.mp3;

import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.MpegAudioUtil;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;

final class VbriSeeker implements Seeker {
    private static final String TAG = "VbriSeeker";
    private final int bitrate;
    private final long dataEndPosition;
    private final long durationUs;
    private final long[] positions;
    private final long[] timesUs;

    private VbriSeeker(long[] jArr, long[] jArr2, long j10, long j11, int i6) {
        this.timesUs = jArr;
        this.positions = jArr2;
        this.durationUs = j10;
        this.dataEndPosition = j11;
        this.bitrate = i6;
    }

    public static VbriSeeker create(long j10, long j11, MpegAudioUtil.Header header, ParsableByteArray parsableByteArray) {
        int unsignedByte;
        parsableByteArray.skipBytes(6);
        long jMax = j11 + ((long) header.frameSize) + ((long) parsableByteArray.readInt());
        int i6 = parsableByteArray.readInt();
        if (i6 <= 0) {
            return null;
        }
        long jSampleCountToDurationUs = Util.sampleCountToDurationUs((((long) i6) * ((long) header.samplesPerFrame)) - 1, header.sampleRate);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int unsignedShort2 = parsableByteArray.readUnsignedShort();
        int unsignedShort3 = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(2);
        long j12 = j11 + ((long) header.frameSize);
        long[] jArr = new long[unsignedShort];
        long[] jArr2 = new long[unsignedShort];
        int i10 = 0;
        while (i10 < unsignedShort) {
            long j13 = jSampleCountToDurationUs;
            jArr[i10] = (((long) i10) * jSampleCountToDurationUs) / ((long) unsignedShort);
            jArr2[i10] = j12;
            if (unsignedShort3 == 1) {
                unsignedByte = parsableByteArray.readUnsignedByte();
            } else if (unsignedShort3 == 2) {
                unsignedByte = parsableByteArray.readUnsignedShort();
            } else if (unsignedShort3 == 3) {
                unsignedByte = parsableByteArray.readUnsignedInt24();
            } else {
                if (unsignedShort3 != 4) {
                    return null;
                }
                unsignedByte = parsableByteArray.readUnsignedIntToInt();
            }
            j12 += ((long) unsignedByte) * ((long) unsignedShort2);
            i10++;
            jSampleCountToDurationUs = j13;
        }
        long j14 = jSampleCountToDurationUs;
        if (j10 != -1 && j10 != jMax) {
            Log.m1719w(TAG, "VBRI data size mismatch: " + j10 + ", " + jMax);
        }
        if (jMax != j12) {
            Log.m1719w(TAG, "VBRI bytes and ToC mismatch (using max): " + jMax + ", " + j12 + "\nSeeking will be inaccurate.");
            jMax = Math.max(jMax, j12);
        }
        return new VbriSeeker(jArr, jArr2, j14, jMax, header.bitrate);
    }

    @Override
    public int getAverageBitrate() {
        return this.bitrate;
    }

    @Override
    public long getDataEndPosition() {
        return this.dataEndPosition;
    }

    @Override
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override
    public SeekMap.SeekPoints getSeekPoints(long j10) {
        int iBinarySearchFloor = Util.binarySearchFloor(this.timesUs, j10, true, true);
        SeekPoint seekPoint = new SeekPoint(this.timesUs[iBinarySearchFloor], this.positions[iBinarySearchFloor]);
        if (seekPoint.timeUs >= j10 || iBinarySearchFloor == this.timesUs.length - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i6 = iBinarySearchFloor + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.timesUs[i6], this.positions[i6]));
    }

    @Override
    public long getTimeUs(long j10) {
        return this.timesUs[Util.binarySearchFloor(this.positions, j10, true, true)];
    }

    @Override
    public boolean isSeekable() {
        return true;
    }
}

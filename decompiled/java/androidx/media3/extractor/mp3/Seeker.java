package androidx.media3.extractor.mp3;

import androidx.media3.common.C0565C;
import androidx.media3.extractor.SeekMap;

interface Seeker extends SeekMap {

    public static class UnseekableSeeker extends SeekMap.Unseekable implements Seeker {
        public UnseekableSeeker() {
            super(C0565C.TIME_UNSET);
        }

        @Override
        public int getAverageBitrate() {
            return C0565C.RATE_UNSET_INT;
        }

        @Override
        public long getDataEndPosition() {
            return -1L;
        }

        @Override
        public long getTimeUs(long j10) {
            return 0L;
        }
    }

    int getAverageBitrate();

    long getDataEndPosition();

    long getTimeUs(long j10);
}

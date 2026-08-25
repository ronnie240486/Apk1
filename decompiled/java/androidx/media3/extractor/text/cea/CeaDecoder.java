package androidx.media3.extractor.text.cea;

import androidx.media3.common.C0565C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderOutputBuffer;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleDecoder;
import androidx.media3.extractor.text.SubtitleDecoderException;
import androidx.media3.extractor.text.SubtitleInputBuffer;
import androidx.media3.extractor.text.SubtitleOutputBuffer;
import java.util.ArrayDeque;

abstract class CeaDecoder implements SubtitleDecoder {
    private static final int NUM_INPUT_BUFFERS = 10;
    private static final int NUM_OUTPUT_BUFFERS = 2;
    private final ArrayDeque<CeaInputBuffer> availableInputBuffers = new ArrayDeque<>();
    private final ArrayDeque<SubtitleOutputBuffer> availableOutputBuffers;
    private CeaInputBuffer dequeuedInputBuffer;
    private long outputStartTimeUs;
    private long playbackPositionUs;
    private long queuedInputBufferCount;
    private final ArrayDeque<CeaInputBuffer> queuedInputBuffers;

    public static final class CeaInputBuffer extends SubtitleInputBuffer implements Comparable<CeaInputBuffer> {
        private long queuedInputBufferCount;

        private CeaInputBuffer() {
        }

        @Override
        public int compareTo(CeaInputBuffer ceaInputBuffer) {
            if (isEndOfStream() != ceaInputBuffer.isEndOfStream()) {
                return isEndOfStream() ? 1 : -1;
            }
            long j10 = this.timeUs - ceaInputBuffer.timeUs;
            if (j10 == 0) {
                j10 = this.queuedInputBufferCount - ceaInputBuffer.queuedInputBufferCount;
                if (j10 == 0) {
                    return 0;
                }
            }
            return j10 > 0 ? 1 : -1;
        }
    }

    public static final class CeaOutputBuffer extends SubtitleOutputBuffer {
        private DecoderOutputBuffer.Owner<CeaOutputBuffer> owner;

        public CeaOutputBuffer(DecoderOutputBuffer.Owner<CeaOutputBuffer> owner) {
            this.owner = owner;
        }

        @Override
        public final void release() {
            this.owner.releaseOutputBuffer(this);
        }
    }

    public CeaDecoder() {
        for (int i6 = 0; i6 < 10; i6++) {
            this.availableInputBuffers.add(new CeaInputBuffer());
        }
        this.availableOutputBuffers = new ArrayDeque<>();
        for (int i10 = 0; i10 < 2; i10++) {
            this.availableOutputBuffers.add(new CeaOutputBuffer(new DecoderOutputBuffer.Owner() {
                @Override
                public final void releaseOutputBuffer(DecoderOutputBuffer decoderOutputBuffer) {
                    this.f3105a.releaseOutputBuffer((CeaDecoder.CeaOutputBuffer) decoderOutputBuffer);
                }
            }));
        }
        this.queuedInputBuffers = new ArrayDeque<>();
        this.outputStartTimeUs = C0565C.TIME_UNSET;
    }

    private void releaseInputBuffer(CeaInputBuffer ceaInputBuffer) {
        ceaInputBuffer.clear();
        this.availableInputBuffers.add(ceaInputBuffer);
    }

    public abstract Subtitle createSubtitle();

    public abstract void decode(SubtitleInputBuffer subtitleInputBuffer);

    @Override
    public void flush() {
        this.queuedInputBufferCount = 0L;
        this.playbackPositionUs = 0L;
        while (!this.queuedInputBuffers.isEmpty()) {
            releaseInputBuffer((CeaInputBuffer) Util.castNonNull(this.queuedInputBuffers.poll()));
        }
        CeaInputBuffer ceaInputBuffer = this.dequeuedInputBuffer;
        if (ceaInputBuffer != null) {
            releaseInputBuffer(ceaInputBuffer);
            this.dequeuedInputBuffer = null;
        }
    }

    public final SubtitleOutputBuffer getAvailableOutputBuffer() {
        return this.availableOutputBuffers.pollFirst();
    }

    @Override
    public abstract String getName();

    public final long getPositionUs() {
        return this.playbackPositionUs;
    }

    public abstract boolean isNewSubtitleDataAvailable();

    public void releaseOutputBuffer(SubtitleOutputBuffer subtitleOutputBuffer) {
        subtitleOutputBuffer.clear();
        this.availableOutputBuffers.add(subtitleOutputBuffer);
    }

    @Override
    public final void setOutputStartTimeUs(long j10) {
        this.outputStartTimeUs = j10;
    }

    @Override
    public void setPositionUs(long j10) {
        this.playbackPositionUs = j10;
    }

    @Override
    public SubtitleInputBuffer dequeueInputBuffer() throws SubtitleDecoderException {
        Assertions.checkState(this.dequeuedInputBuffer == null);
        if (this.availableInputBuffers.isEmpty()) {
            return null;
        }
        CeaInputBuffer ceaInputBufferPollFirst = this.availableInputBuffers.pollFirst();
        this.dequeuedInputBuffer = ceaInputBufferPollFirst;
        return ceaInputBufferPollFirst;
    }

    @Override
    public SubtitleOutputBuffer dequeueOutputBuffer() throws SubtitleDecoderException {
        if (this.availableOutputBuffers.isEmpty()) {
            return null;
        }
        while (!this.queuedInputBuffers.isEmpty() && ((CeaInputBuffer) Util.castNonNull(this.queuedInputBuffers.peek())).timeUs <= this.playbackPositionUs) {
            CeaInputBuffer ceaInputBuffer = (CeaInputBuffer) Util.castNonNull(this.queuedInputBuffers.poll());
            if (ceaInputBuffer.isEndOfStream()) {
                SubtitleOutputBuffer subtitleOutputBuffer = (SubtitleOutputBuffer) Util.castNonNull(this.availableOutputBuffers.pollFirst());
                subtitleOutputBuffer.addFlag(4);
                releaseInputBuffer(ceaInputBuffer);
                return subtitleOutputBuffer;
            }
            decode(ceaInputBuffer);
            if (isNewSubtitleDataAvailable()) {
                Subtitle subtitleCreateSubtitle = createSubtitle();
                SubtitleOutputBuffer subtitleOutputBuffer2 = (SubtitleOutputBuffer) Util.castNonNull(this.availableOutputBuffers.pollFirst());
                subtitleOutputBuffer2.setContent(ceaInputBuffer.timeUs, subtitleCreateSubtitle, Long.MAX_VALUE);
                releaseInputBuffer(ceaInputBuffer);
                return subtitleOutputBuffer2;
            }
            releaseInputBuffer(ceaInputBuffer);
        }
        return null;
    }

    @Override
    public void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        Assertions.checkArgument(subtitleInputBuffer == this.dequeuedInputBuffer);
        CeaInputBuffer ceaInputBuffer = (CeaInputBuffer) subtitleInputBuffer;
        if (ceaInputBuffer.isEndOfStream()) {
            long j10 = this.queuedInputBufferCount;
            this.queuedInputBufferCount = 1 + j10;
            ceaInputBuffer.queuedInputBufferCount = j10;
            this.queuedInputBuffers.add(ceaInputBuffer);
        } else {
            long j11 = ceaInputBuffer.timeUs;
            if (j11 != Long.MIN_VALUE) {
                long j12 = this.outputStartTimeUs;
                if (j12 == C0565C.TIME_UNSET || j11 >= j12) {
                    long j13 = this.queuedInputBufferCount;
                    this.queuedInputBufferCount = 1 + j13;
                    ceaInputBuffer.queuedInputBufferCount = j13;
                    this.queuedInputBuffers.add(ceaInputBuffer);
                } else {
                    releaseInputBuffer(ceaInputBuffer);
                }
            } else {
                long j14 = this.queuedInputBufferCount;
                this.queuedInputBufferCount = 1 + j14;
                ceaInputBuffer.queuedInputBufferCount = j14;
                this.queuedInputBuffers.add(ceaInputBuffer);
            }
        }
        this.dequeuedInputBuffer = null;
    }

    @Override
    public void release() {
    }
}

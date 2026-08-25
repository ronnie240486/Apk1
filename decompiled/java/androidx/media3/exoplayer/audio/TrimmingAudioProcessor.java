package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;

final class TrimmingAudioProcessor extends androidx.media3.common.audio.BaseAudioProcessor {
    private byte[] endBuffer = Util.EMPTY_BYTE_ARRAY;
    private int endBufferSize;
    private int pendingTrimStartBytes;
    private boolean reconfigurationPending;
    private int trimEndFrames;
    private int trimStartFrames;
    private long trimmedFrameCount;

    @Override
    public long getDurationAfterProcessorApplied(long j10) {
        return j10 - Util.sampleCountToDurationUs(this.trimEndFrames + this.trimStartFrames, this.inputAudioFormat.sampleRate);
    }

    @Override
    public ByteBuffer getOutput() {
        int i6;
        if (super.isEnded() && (i6 = this.endBufferSize) > 0) {
            replaceOutputBuffer(i6).put(this.endBuffer, 0, this.endBufferSize).flip();
            this.endBufferSize = 0;
        }
        return super.getOutput();
    }

    public long getTrimmedFrameCount() {
        return this.trimmedFrameCount;
    }

    @Override
    public boolean isEnded() {
        return super.isEnded() && this.endBufferSize == 0;
    }

    @Override
    public AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        int i6 = audioFormat.encoding;
        if (i6 != 2 && i6 != 4) {
            throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
        }
        this.reconfigurationPending = true;
        return (this.trimStartFrames == 0 && this.trimEndFrames == 0) ? AudioProcessor.AudioFormat.NOT_SET : audioFormat;
    }

    @Override
    public void onFlush() {
        if (this.reconfigurationPending) {
            this.reconfigurationPending = false;
            int i6 = this.trimEndFrames;
            int i10 = this.inputAudioFormat.bytesPerFrame;
            this.endBuffer = new byte[i6 * i10];
            this.pendingTrimStartBytes = this.trimStartFrames * i10;
        }
        this.endBufferSize = 0;
    }

    @Override
    public void onQueueEndOfStream() {
        if (this.reconfigurationPending) {
            int i6 = this.endBufferSize;
            if (i6 > 0) {
                this.trimmedFrameCount += (long) (i6 / this.inputAudioFormat.bytesPerFrame);
            }
            this.endBufferSize = 0;
        }
    }

    @Override
    public void onReset() {
        this.endBuffer = Util.EMPTY_BYTE_ARRAY;
    }

    @Override
    public void queueInput(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i6 = iLimit - iPosition;
        if (i6 == 0) {
            return;
        }
        int iMin = Math.min(i6, this.pendingTrimStartBytes);
        this.trimmedFrameCount += (long) (iMin / this.inputAudioFormat.bytesPerFrame);
        this.pendingTrimStartBytes -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.pendingTrimStartBytes > 0) {
            return;
        }
        int i10 = i6 - iMin;
        int length = (this.endBufferSize + i10) - this.endBuffer.length;
        ByteBuffer byteBufferReplaceOutputBuffer = replaceOutputBuffer(length);
        int iConstrainValue = Util.constrainValue(length, 0, this.endBufferSize);
        byteBufferReplaceOutputBuffer.put(this.endBuffer, 0, iConstrainValue);
        int iConstrainValue2 = Util.constrainValue(length - iConstrainValue, 0, i10);
        byteBuffer.limit(byteBuffer.position() + iConstrainValue2);
        byteBufferReplaceOutputBuffer.put(byteBuffer);
        byteBuffer.limit(iLimit);
        int i11 = i10 - iConstrainValue2;
        int i12 = this.endBufferSize - iConstrainValue;
        this.endBufferSize = i12;
        byte[] bArr = this.endBuffer;
        System.arraycopy(bArr, iConstrainValue, bArr, 0, i12);
        byteBuffer.get(this.endBuffer, this.endBufferSize, i11);
        this.endBufferSize += i11;
        byteBufferReplaceOutputBuffer.flip();
    }

    public void resetTrimmedFrameCount() {
        this.trimmedFrameCount = 0L;
    }

    public void setTrimFrameCount(int i6, int i10) {
        this.trimStartFrames = i6;
        this.trimEndFrames = i10;
    }
}

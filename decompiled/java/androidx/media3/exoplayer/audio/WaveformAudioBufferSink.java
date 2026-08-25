package androidx.media3.exoplayer.audio;

import android.util.SparseArray;
import androidx.media3.common.audio.AudioMixingUtil;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.ChannelMixingMatrix;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;
import p020b7.AbstractC1332b;

@UnstableApi
public class WaveformAudioBufferSink implements TeeAudioProcessor.AudioBufferSink {
    private final int barsPerSecond;
    private ChannelMixingMatrix channelMixingMatrix;
    private AudioProcessor.AudioFormat inputAudioFormat;
    private final Listener listener;
    private AudioProcessor.AudioFormat mixingAudioFormat;
    private final ByteBuffer mixingBuffer;
    private final SparseArray<WaveformBar> outputChannels;
    private int samplesPerBar;

    public interface Listener {
        void onNewWaveformBar(int i6, WaveformBar waveformBar);
    }

    public static class WaveformBar {
        private int sampleCount;
        private double squareSum;
        private float minSampleValue = 1.0f;
        private float maxSampleValue = -1.0f;

        public void addSample(float f) {
            AbstractC1332b.m3215f(f >= -1.0f && f <= 1.0f);
            this.minSampleValue = Math.min(this.minSampleValue, f);
            this.maxSampleValue = Math.max(this.maxSampleValue, f);
            double d = f;
            this.squareSum = (d * d) + this.squareSum;
            this.sampleCount++;
        }

        public double getMaxSampleValue() {
            return this.maxSampleValue;
        }

        public double getMinSampleValue() {
            return this.minSampleValue;
        }

        public double getRootMeanSquare() {
            return Math.sqrt(this.squareSum / ((double) this.sampleCount));
        }

        public int getSampleCount() {
            return this.sampleCount;
        }
    }

    public WaveformAudioBufferSink(int i6, int i10, Listener listener) {
        this.barsPerSecond = i6;
        this.listener = listener;
        this.mixingBuffer = ByteBuffer.allocate(Util.getPcmFrameSize(4, i10));
        this.outputChannels = new SparseArray<>(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            this.outputChannels.append(i11, new WaveformBar());
        }
    }

    @Override
    public void flush(int i6, int i10, int i11) {
        this.samplesPerBar = i6 / this.barsPerSecond;
        this.inputAudioFormat = new AudioProcessor.AudioFormat(i6, i10, i11);
        this.mixingAudioFormat = new AudioProcessor.AudioFormat(i6, this.outputChannels.size(), 4);
        this.channelMixingMatrix = ChannelMixingMatrix.create(i10, this.outputChannels.size());
    }

    @Override
    public void handleBuffer(ByteBuffer byteBuffer) {
        Assertions.checkStateNotNull(this.inputAudioFormat);
        Assertions.checkStateNotNull(this.mixingAudioFormat);
        Assertions.checkStateNotNull(this.channelMixingMatrix);
        while (byteBuffer.hasRemaining()) {
            this.mixingBuffer.rewind();
            AudioMixingUtil.mix(byteBuffer, this.inputAudioFormat, this.mixingBuffer, this.mixingAudioFormat, this.channelMixingMatrix, 1, false, true);
            this.mixingBuffer.rewind();
            for (int i6 = 0; i6 < this.outputChannels.size(); i6++) {
                WaveformBar waveformBar = this.outputChannels.get(i6);
                waveformBar.addSample(this.mixingBuffer.getFloat());
                if (waveformBar.getSampleCount() >= this.samplesPerBar) {
                    this.listener.onNewWaveformBar(i6, waveformBar);
                    this.outputChannels.put(i6, new WaveformBar());
                }
            }
        }
    }
}

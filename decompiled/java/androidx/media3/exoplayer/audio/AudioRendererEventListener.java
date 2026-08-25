package androidx.media3.exoplayer.audio;

import android.os.Handler;
import androidx.appcompat.app.RunnableC0147m0;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.RunnableC0624i;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;

@UnstableApi
public interface AudioRendererEventListener {

    public static final class EventDispatcher {
        private final Handler handler;
        private final AudioRendererEventListener listener;

        public EventDispatcher(Handler handler, AudioRendererEventListener audioRendererEventListener) {
            this.handler = audioRendererEventListener != null ? (Handler) Assertions.checkNotNull(handler) : null;
            this.listener = audioRendererEventListener;
        }

        public void lambda$audioCodecError$9(Exception exc) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioCodecError(exc);
        }

        public void lambda$audioSinkError$8(Exception exc) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioSinkError(exc);
        }

        public void lambda$audioTrackInitialized$10(AudioSink.AudioTrackConfig audioTrackConfig) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioTrackInitialized(audioTrackConfig);
        }

        public void lambda$audioTrackReleased$11(AudioSink.AudioTrackConfig audioTrackConfig) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioTrackReleased(audioTrackConfig);
        }

        public void lambda$decoderInitialized$1(String str, long j10, long j11) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioDecoderInitialized(str, j10, j11);
        }

        public void lambda$decoderReleased$5(String str) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioDecoderReleased(str);
        }

        public void lambda$disabled$6(DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioDisabled(decoderCounters);
        }

        public void lambda$enabled$0(DecoderCounters decoderCounters) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioEnabled(decoderCounters);
        }

        public void lambda$inputFormatChanged$2(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioInputFormatChanged(format, decoderReuseEvaluation);
        }

        public void lambda$positionAdvancing$3(long j10) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioPositionAdvancing(j10);
        }

        public void lambda$skipSilenceEnabledChanged$7(boolean z7) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onSkipSilenceEnabledChanged(z7);
        }

        public void lambda$underrun$4(int i6, long j10, long j11) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioUnderrun(i6, j10, j11);
        }

        public void audioCodecError(Exception exc) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new RunnableC0723g(this, exc, 0));
            }
        }

        public void audioSinkError(Exception exc) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new RunnableC0723g(this, exc, 1));
            }
        }

        public void audioTrackInitialized(AudioSink.AudioTrackConfig audioTrackConfig) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new RunnableC0722f(this, audioTrackConfig, 0));
            }
        }

        public void audioTrackReleased(AudioSink.AudioTrackConfig audioTrackConfig) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new RunnableC0722f(this, audioTrackConfig, 1));
            }
        }

        public void decoderInitialized(String str, long j10, long j11) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new RunnableC0725i(this, str, j10, j11, 0));
            }
        }

        public void decoderReleased(String str) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new RunnableC0147m0(this, 8, str));
            }
        }

        public void disabled(DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new RunnableC0719c(this, decoderCounters, 1));
            }
        }

        public void enabled(DecoderCounters decoderCounters) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new RunnableC0719c(this, decoderCounters, 0));
            }
        }

        public void inputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new RunnableC0624i(this, format, decoderReuseEvaluation, 2));
            }
        }

        public void positionAdvancing(long j10) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new RunnableC0720d(this, j10, 0));
            }
        }

        public void skipSilenceEnabledChanged(final boolean z7) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() {
                    @Override
                    public final void run() {
                        this.f2786a.lambda$skipSilenceEnabledChanged$7(z7);
                    }
                });
            }
        }

        public void underrun(final int i6, final long j10, final long j11) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() {
                    @Override
                    public final void run() {
                        this.f2776a.lambda$underrun$4(i6, j10, j11);
                    }
                });
            }
        }
    }

    void onAudioCodecError(Exception exc);

    void onAudioDecoderInitialized(String str, long j10, long j11);

    void onAudioDecoderReleased(String str);

    void onAudioDisabled(DecoderCounters decoderCounters);

    void onAudioEnabled(DecoderCounters decoderCounters);

    void onAudioInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation);

    void onAudioPositionAdvancing(long j10);

    void onAudioSinkError(Exception exc);

    void onAudioTrackInitialized(AudioSink.AudioTrackConfig audioTrackConfig);

    void onAudioTrackReleased(AudioSink.AudioTrackConfig audioTrackConfig);

    void onAudioUnderrun(int i6, long j10, long j11);

    void onSkipSilenceEnabledChanged(boolean z7);
}

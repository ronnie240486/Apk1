package androidx.media3.exoplayer;

import android.content.Context;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.audio.AbstractC0718b;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.video.AbstractC0986i;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import java.util.Arrays;

@UnstableApi
public final class DefaultRendererCapabilitiesList implements RendererCapabilitiesList {
    private final Renderer[] renderers;

    public static final class Factory implements RendererCapabilitiesList.Factory {
        private final RenderersFactory renderersFactory;

        public Factory(Context context) {
            this.renderersFactory = new DefaultRenderersFactory(context);
        }

        @Override
        public DefaultRendererCapabilitiesList createRendererCapabilitiesList() {
            return new DefaultRendererCapabilitiesList(this.renderersFactory.createRenderers(Util.createHandlerForCurrentOrMainLooper(), new VideoRendererEventListener() {
                @Override
                public final void onDroppedFrames(int i6, long j10) {
                    AbstractC0986i.m2627a(this, i6, j10);
                }

                @Override
                public final void onRenderedFirstFrame(Object obj, long j10) {
                    AbstractC0986i.m2628b(this, obj, j10);
                }

                @Override
                public final void onVideoCodecError(Exception exc) {
                    AbstractC0986i.m2629c(this, exc);
                }

                @Override
                public final void onVideoDecoderInitialized(String str, long j10, long j11) {
                    AbstractC0986i.m2630d(this, str, j10, j11);
                }

                @Override
                public final void onVideoDecoderReleased(String str) {
                    AbstractC0986i.m2631e(this, str);
                }

                @Override
                public final void onVideoDisabled(DecoderCounters decoderCounters) {
                    AbstractC0986i.m2632f(this, decoderCounters);
                }

                @Override
                public final void onVideoEnabled(DecoderCounters decoderCounters) {
                    AbstractC0986i.m2633g(this, decoderCounters);
                }

                @Override
                public final void onVideoFrameProcessingOffset(long j10, int i6) {
                    AbstractC0986i.m2634h(this, j10, i6);
                }

                @Override
                public final void onVideoInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
                    AbstractC0986i.m2635i(this, format, decoderReuseEvaluation);
                }

                @Override
                public final void onVideoSizeChanged(VideoSize videoSize) {
                    AbstractC0986i.m2636j(this, videoSize);
                }
            }, new AudioRendererEventListener() {
                @Override
                public final void onAudioCodecError(Exception exc) {
                    AbstractC0718b.m2157a(this, exc);
                }

                @Override
                public final void onAudioDecoderInitialized(String str, long j10, long j11) {
                    AbstractC0718b.m2158b(this, str, j10, j11);
                }

                @Override
                public final void onAudioDecoderReleased(String str) {
                    AbstractC0718b.m2159c(this, str);
                }

                @Override
                public final void onAudioDisabled(DecoderCounters decoderCounters) {
                    AbstractC0718b.m2160d(this, decoderCounters);
                }

                @Override
                public final void onAudioEnabled(DecoderCounters decoderCounters) {
                    AbstractC0718b.m2161e(this, decoderCounters);
                }

                @Override
                public final void onAudioInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
                    AbstractC0718b.m2162f(this, format, decoderReuseEvaluation);
                }

                @Override
                public final void onAudioPositionAdvancing(long j10) {
                    AbstractC0718b.m2163g(this, j10);
                }

                @Override
                public final void onAudioSinkError(Exception exc) {
                    AbstractC0718b.m2164h(this, exc);
                }

                @Override
                public final void onAudioTrackInitialized(AudioSink.AudioTrackConfig audioTrackConfig) {
                    AbstractC0718b.m2165i(this, audioTrackConfig);
                }

                @Override
                public final void onAudioTrackReleased(AudioSink.AudioTrackConfig audioTrackConfig) {
                    AbstractC0718b.m2166j(this, audioTrackConfig);
                }

                @Override
                public final void onAudioUnderrun(int i6, long j10, long j11) {
                    AbstractC0718b.m2167k(this, i6, j10, j11);
                }

                @Override
                public final void onSkipSilenceEnabledChanged(boolean z7) {
                    AbstractC0718b.m2168l(this, z7);
                }
            }, new C0759e(), new C0761f()));
        }

        public Factory(RenderersFactory renderersFactory) {
            this.renderersFactory = renderersFactory;
        }

        public static void lambda$createRendererCapabilitiesList$0(CueGroup cueGroup) {
        }

        public static void lambda$createRendererCapabilitiesList$1(Metadata metadata) {
        }
    }

    @Override
    public RendererCapabilities[] getRendererCapabilities() {
        RendererCapabilities[] rendererCapabilitiesArr = new RendererCapabilities[this.renderers.length];
        int i6 = 0;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i6 >= rendererArr.length) {
                return rendererCapabilitiesArr;
            }
            rendererCapabilitiesArr[i6] = rendererArr[i6].getCapabilities();
            i6++;
        }
    }

    @Override
    public void release() {
        for (Renderer renderer : this.renderers) {
            renderer.release();
        }
    }

    @Override
    public int size() {
        return this.renderers.length;
    }

    private DefaultRendererCapabilitiesList(Renderer[] rendererArr) {
        this.renderers = (Renderer[]) Arrays.copyOf(rendererArr, rendererArr.length);
        for (int i6 = 0; i6 < rendererArr.length; i6++) {
            this.renderers[i6].init(i6, PlayerId.UNSET, Clock.DEFAULT);
        }
    }
}

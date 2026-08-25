package androidx.media3.exoplayer.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Surface;
import androidx.media3.common.C0565C;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DebugViewProvider;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.PreviewingVideoGraph;
import androidx.media3.common.SurfaceInfo;
import androidx.media3.common.VideoCompositorSettings;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.VideoGraph;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.TimedValueQueue;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.Renderer;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import p000a.AbstractC0004e;
import p020b7.AbstractC1332b;
import p020b7.InterfaceC1339e0;
import p041d7.AbstractC2301u1;
import p041d7.C2180c5;
import p041d7.C2204g1;
import p041d7.C2288s1;

@UnstableApi
public final class PlaybackVideoGraphWrapper implements VideoSinkProvider, VideoGraph.Listener {
    private static final Executor NO_OP_EXECUTOR = new ExecutorC0978a(1);
    private static final int PRIMARY_SEQUENCE_INDEX = 0;
    private static final int STATE_CREATED = 0;
    private static final int STATE_INITIALIZED = 1;
    private static final int STATE_RELEASED = 2;
    private long bufferTimestampAdjustmentUs;
    private final Clock clock;
    private final List<Effect> compositionEffects;
    private final VideoCompositorSettings compositorSettings;
    private final Context context;
    private Pair<Surface, Size> currentSurfaceAndSize;
    private final VideoSink defaultVideoSink;
    private long finalBufferPresentationTimeUs;
    private HandlerWrapper handler;
    private boolean hasSignaledEndOfCurrentInputStream;
    private final SparseArray<InputVideoSink> inputVideoSinks;
    private long lastOutputBufferPresentationTimeUs;
    private final CopyOnWriteArraySet<Listener> listeners;
    private long outputStreamStartPositionUs;
    private int pendingFlushCount;
    private final PreviewingVideoGraph.Factory previewingVideoGraphFactory;
    private int registeredVideoInputCount;
    private final boolean requestOpenGlToneMapping;
    private int state;
    private final TimedValueQueue<Long> streamStartPositionsUs;
    private int totalVideoInputCount;
    private final VideoSink.VideoFrameHandler videoFrameHandler;
    private PreviewingVideoGraph videoGraph;
    private Format videoGraphOutputFormat;
    private Renderer.WakeupListener wakeupListener;

    public static final class Builder {
        private boolean built;
        private Clock clock;
        private List<Effect> compositionEffects;
        private VideoCompositorSettings compositorSettings;
        private final Context context;
        private PreviewingVideoGraph.Factory previewingVideoGraphFactory;
        private boolean requestOpenGlToneMapping;
        private VideoFrameProcessor.Factory videoFrameProcessorFactory;
        private final VideoFrameReleaseControl videoFrameReleaseControl;

        public Builder(Context context, VideoFrameReleaseControl videoFrameReleaseControl) {
            this.context = context.getApplicationContext();
            this.videoFrameReleaseControl = videoFrameReleaseControl;
            C2204g1 c2204g1 = AbstractC2301u1.f8069b;
            this.compositionEffects = C2180c5.f7862e;
            this.compositorSettings = VideoCompositorSettings.DEFAULT;
            this.clock = Clock.DEFAULT;
        }

        public PlaybackVideoGraphWrapper build() {
            Assertions.checkState(!this.built);
            if (this.previewingVideoGraphFactory == null) {
                if (this.videoFrameProcessorFactory == null) {
                    this.videoFrameProcessorFactory = new ReflectiveDefaultVideoFrameProcessorFactory();
                }
                this.previewingVideoGraphFactory = new ReflectivePreviewingSingleInputVideoGraphFactory(this.videoFrameProcessorFactory);
            }
            PlaybackVideoGraphWrapper playbackVideoGraphWrapper = new PlaybackVideoGraphWrapper(this);
            this.built = true;
            return playbackVideoGraphWrapper;
        }

        public Builder setClock(Clock clock) {
            this.clock = clock;
            return this;
        }

        public Builder setCompositionEffects(List<Effect> list) {
            this.compositionEffects = list;
            return this;
        }

        public Builder setCompositorSettings(VideoCompositorSettings videoCompositorSettings) {
            this.compositorSettings = videoCompositorSettings;
            return this;
        }

        public Builder setPreviewingVideoGraphFactory(PreviewingVideoGraph.Factory factory) {
            this.previewingVideoGraphFactory = factory;
            return this;
        }

        public Builder setRequestOpenGlToneMapping(boolean z7) {
            this.requestOpenGlToneMapping = z7;
            return this;
        }

        public Builder setVideoFrameProcessorFactory(VideoFrameProcessor.Factory factory) {
            this.videoFrameProcessorFactory = factory;
            return this;
        }
    }

    public final class DefaultVideoSinkListener implements VideoSink.Listener {
        private DefaultVideoSinkListener() {
        }

        @Override
        public void onError(VideoSink videoSink, VideoSink.VideoSinkException videoSinkException) {
            Iterator it = PlaybackVideoGraphWrapper.this.listeners.iterator();
            while (it.hasNext()) {
                ((Listener) it.next()).onError(PlaybackVideoGraphWrapper.this, VideoFrameProcessingException.from(videoSinkException));
            }
        }

        @Override
        public void onFirstFrameRendered(VideoSink videoSink) {
            Iterator it = PlaybackVideoGraphWrapper.this.listeners.iterator();
            while (it.hasNext()) {
                ((Listener) it.next()).onFirstFrameRendered(PlaybackVideoGraphWrapper.this);
            }
        }

        @Override
        public void onFrameDropped(VideoSink videoSink) {
            Iterator it = PlaybackVideoGraphWrapper.this.listeners.iterator();
            while (it.hasNext()) {
                ((Listener) it.next()).onFrameDropped(PlaybackVideoGraphWrapper.this);
            }
        }

        @Override
        public void onVideoSizeChanged(VideoSink videoSink, VideoSize videoSize) {
            Iterator it = PlaybackVideoGraphWrapper.this.listeners.iterator();
            while (it.hasNext()) {
                ((Listener) it.next()).onVideoSizeChanged(PlaybackVideoGraphWrapper.this, videoSize);
            }
        }
    }

    public final class InputVideoSink implements VideoSink, Listener {
        private long inputBufferTimestampAdjustmentUs;
        private Format inputFormat;
        private final int inputIndex;
        private int inputType;
        private long lastBufferPresentationTimeUs;
        private VideoSink.Listener listener;
        private Executor listenerExecutor;
        private boolean signaledEndOfStream;
        private AbstractC2301u1 videoEffects;
        private VideoFrameProcessor videoFrameProcessor;
        private final int videoFrameProcessorMaxPendingFrameCount;

        public InputVideoSink(Context context, int i6) {
            this.inputIndex = i6;
            this.videoFrameProcessorMaxPendingFrameCount = Util.getMaxPendingFramesCountForMediaCodecDecoders(context);
            C2204g1 c2204g1 = AbstractC2301u1.f8069b;
            this.videoEffects = C2180c5.f7862e;
            this.lastBufferPresentationTimeUs = C0565C.TIME_UNSET;
            this.listener = VideoSink.Listener.NO_OP;
            this.listenerExecutor = PlaybackVideoGraphWrapper.NO_OP_EXECUTOR;
        }

        public void lambda$onError$3(VideoSink.Listener listener, VideoFrameProcessingException videoFrameProcessingException) {
            listener.onError(this, new VideoSink.VideoSinkException(videoFrameProcessingException, (Format) Assertions.checkStateNotNull(this.inputFormat)));
        }

        public void lambda$onFirstFrameRendered$0(VideoSink.Listener listener) {
            listener.onFirstFrameRendered(this);
        }

        public void lambda$onFrameDropped$1(VideoSink.Listener listener) {
            listener.onFrameDropped((VideoSink) Assertions.checkStateNotNull(this));
        }

        public void lambda$onVideoSizeChanged$2(VideoSink.Listener listener, VideoSize videoSize) {
            listener.onVideoSizeChanged(this, videoSize);
        }

        private void registerInputStream(Format format) {
            ((VideoFrameProcessor) Assertions.checkStateNotNull(this.videoFrameProcessor)).registerInputStream(this.inputType, format.buildUpon().setColorInfo(PlaybackVideoGraphWrapper.getAdjustedInputColorInfo(format.colorInfo)).build(), this.videoEffects, 0L);
        }

        private void setPendingVideoEffects(List<Effect> list) {
            if (PlaybackVideoGraphWrapper.this.previewingVideoGraphFactory.supportsMultipleInputs()) {
                this.videoEffects = AbstractC2301u1.m5272n(list);
                return;
            }
            C2288s1 c2288s1 = new C2288s1(4);
            c2288s1.m5257d(list);
            c2288s1.m5257d(PlaybackVideoGraphWrapper.this.compositionEffects);
            this.videoEffects = c2288s1.m5262g();
        }

        @Override
        public void clearOutputSurfaceInfo() {
            PlaybackVideoGraphWrapper.this.clearOutputSurfaceInfo();
        }

        @Override
        public void enableMayRenderStartOfStream() {
            PlaybackVideoGraphWrapper.this.defaultVideoSink.enableMayRenderStartOfStream();
        }

        @Override
        public void flush(boolean z7) {
            if (isInitialized()) {
                this.videoFrameProcessor.flush();
            }
            this.lastBufferPresentationTimeUs = C0565C.TIME_UNSET;
            PlaybackVideoGraphWrapper.this.flush(z7);
            this.signaledEndOfStream = false;
        }

        @Override
        public Surface getInputSurface() {
            Assertions.checkState(isInitialized());
            return ((VideoFrameProcessor) Assertions.checkStateNotNull(this.videoFrameProcessor)).getInputSurface();
        }

        @Override
        public boolean handleInputBitmap(Bitmap bitmap, TimestampIterator timestampIterator) {
            Assertions.checkState(isInitialized());
            if (!PlaybackVideoGraphWrapper.this.shouldRenderToInputVideoSink() || !((VideoFrameProcessor) Assertions.checkNotNull(this.videoFrameProcessor)).queueInputBitmap(bitmap, timestampIterator)) {
                return false;
            }
            long lastTimestampUs = timestampIterator.getLastTimestampUs() - this.inputBufferTimestampAdjustmentUs;
            Assertions.checkState(lastTimestampUs != C0565C.TIME_UNSET);
            this.lastBufferPresentationTimeUs = lastTimestampUs;
            return true;
        }

        @Override
        public boolean handleInputFrame(long j10, boolean z7, VideoSink.VideoFrameHandler videoFrameHandler) {
            Assertions.checkState(isInitialized());
            if (!PlaybackVideoGraphWrapper.this.shouldRenderToInputVideoSink() || ((VideoFrameProcessor) Assertions.checkStateNotNull(this.videoFrameProcessor)).getPendingInputFrameCount() >= this.videoFrameProcessorMaxPendingFrameCount || !((VideoFrameProcessor) Assertions.checkStateNotNull(this.videoFrameProcessor)).registerInputFrame()) {
                return false;
            }
            this.lastBufferPresentationTimeUs = j10 - this.inputBufferTimestampAdjustmentUs;
            videoFrameHandler.render(j10 * 1000);
            return true;
        }

        @Override
        public boolean initialize(Format format) throws VideoSink.VideoSinkException {
            Assertions.checkState(!isInitialized());
            VideoFrameProcessor videoFrameProcessorRegisterInput = PlaybackVideoGraphWrapper.this.registerInput(format, this.inputIndex);
            this.videoFrameProcessor = videoFrameProcessorRegisterInput;
            return videoFrameProcessorRegisterInput != null;
        }

        @Override
        public boolean isEnded() {
            return isInitialized() && PlaybackVideoGraphWrapper.this.isEnded();
        }

        @Override
        public boolean isInitialized() {
            return this.videoFrameProcessor != null;
        }

        @Override
        public boolean isReady(boolean z7) {
            return PlaybackVideoGraphWrapper.this.isReady(z7 && isInitialized());
        }

        @Override
        public void join(boolean z7) {
            PlaybackVideoGraphWrapper.this.defaultVideoSink.join(z7);
        }

        @Override
        public void onError(PlaybackVideoGraphWrapper playbackVideoGraphWrapper, VideoFrameProcessingException videoFrameProcessingException) {
            this.listenerExecutor.execute(new RunnableC0983f(this, this.listener, videoFrameProcessingException, 1));
        }

        @Override
        public void onFirstFrameRendered(PlaybackVideoGraphWrapper playbackVideoGraphWrapper) {
            this.listenerExecutor.execute(new RunnableC0984g(this, this.listener, 0));
        }

        @Override
        public void onFrameDropped(PlaybackVideoGraphWrapper playbackVideoGraphWrapper) {
            this.listenerExecutor.execute(new RunnableC0984g(this, this.listener, 1));
        }

        @Override
        public void onInputStreamChanged(int i6, Format format, List<Effect> list) {
            Assertions.checkState(isInitialized());
            if (i6 != 1 && i6 != 2) {
                throw new UnsupportedOperationException(AbstractC0004e.m20n(i6, "Unsupported input type "));
            }
            setPendingVideoEffects(list);
            this.inputType = i6;
            this.inputFormat = format;
            PlaybackVideoGraphWrapper.this.finalBufferPresentationTimeUs = C0565C.TIME_UNSET;
            PlaybackVideoGraphWrapper.this.hasSignaledEndOfCurrentInputStream = false;
            registerInputStream(format);
        }

        @Override
        public void onRendererDisabled() {
            PlaybackVideoGraphWrapper.this.defaultVideoSink.onRendererDisabled();
        }

        @Override
        public void onRendererEnabled(boolean z7) {
            PlaybackVideoGraphWrapper.this.defaultVideoSink.onRendererEnabled(z7);
        }

        @Override
        public void onRendererStarted() {
            PlaybackVideoGraphWrapper.this.defaultVideoSink.onRendererStarted();
        }

        @Override
        public void onRendererStopped() {
            PlaybackVideoGraphWrapper.this.defaultVideoSink.onRendererStopped();
        }

        @Override
        public void onVideoSizeChanged(PlaybackVideoGraphWrapper playbackVideoGraphWrapper, VideoSize videoSize) {
            this.listenerExecutor.execute(new RunnableC0983f(this, this.listener, videoSize, 0));
        }

        @Override
        public void release() {
            PlaybackVideoGraphWrapper.this.release();
        }

        @Override
        public void render(long j10, long j11) throws VideoSink.VideoSinkException {
            PlaybackVideoGraphWrapper.this.render(j10, j11);
        }

        @Override
        public void setChangeFrameRateStrategy(int i6) {
            PlaybackVideoGraphWrapper.this.defaultVideoSink.setChangeFrameRateStrategy(i6);
        }

        @Override
        public void setListener(VideoSink.Listener listener, Executor executor) {
            this.listener = listener;
            this.listenerExecutor = executor;
        }

        @Override
        public void setOutputSurfaceInfo(Surface surface, Size size) {
            PlaybackVideoGraphWrapper.this.setOutputSurfaceInfo(surface, size);
        }

        @Override
        public void setPlaybackSpeed(float f) {
            PlaybackVideoGraphWrapper.this.setPlaybackSpeed(f);
        }

        @Override
        public void setStreamTimestampInfo(long j10, long j11) {
            TimedValueQueue timedValueQueue = PlaybackVideoGraphWrapper.this.streamStartPositionsUs;
            long j12 = this.lastBufferPresentationTimeUs;
            timedValueQueue.add(j12 == C0565C.TIME_UNSET ? 0L : j12 + 1, Long.valueOf(j10));
            this.inputBufferTimestampAdjustmentUs = j11;
            PlaybackVideoGraphWrapper.this.setBufferTimestampAdjustment(j11);
        }

        @Override
        public void setVideoEffects(List<Effect> list) {
            if (this.videoEffects.equals(list)) {
                return;
            }
            setPendingVideoEffects(list);
            Format format = this.inputFormat;
            if (format != null) {
                registerInputStream(format);
            }
        }

        @Override
        public void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener) {
            PlaybackVideoGraphWrapper.this.setVideoFrameMetadataListener(videoFrameMetadataListener);
        }

        @Override
        public void setWakeupListener(Renderer.WakeupListener wakeupListener) {
            PlaybackVideoGraphWrapper.this.wakeupListener = wakeupListener;
        }

        @Override
        public void signalEndOfCurrentInputStream() {
            PlaybackVideoGraphWrapper.this.finalBufferPresentationTimeUs = this.lastBufferPresentationTimeUs;
            if (PlaybackVideoGraphWrapper.this.lastOutputBufferPresentationTimeUs >= PlaybackVideoGraphWrapper.this.finalBufferPresentationTimeUs) {
                PlaybackVideoGraphWrapper.this.defaultVideoSink.signalEndOfCurrentInputStream();
                PlaybackVideoGraphWrapper.this.hasSignaledEndOfCurrentInputStream = true;
            }
        }

        @Override
        public void signalEndOfInput() {
            if (!this.signaledEndOfStream && isInitialized()) {
                this.videoFrameProcessor.signalEndOfInput();
                this.signaledEndOfStream = true;
            }
        }
    }

    public interface Listener {
        void onError(PlaybackVideoGraphWrapper playbackVideoGraphWrapper, VideoFrameProcessingException videoFrameProcessingException);

        void onFirstFrameRendered(PlaybackVideoGraphWrapper playbackVideoGraphWrapper);

        void onFrameDropped(PlaybackVideoGraphWrapper playbackVideoGraphWrapper);

        void onVideoSizeChanged(PlaybackVideoGraphWrapper playbackVideoGraphWrapper, VideoSize videoSize);
    }

    public static final class ReflectiveDefaultVideoFrameProcessorFactory implements VideoFrameProcessor.Factory {
        private static final InterfaceC1339e0 VIDEO_FRAME_PROCESSOR_FACTORY_SUPPLIER = AbstractC1332b.m3229t(new C0985h());

        private ReflectiveDefaultVideoFrameProcessorFactory() {
        }

        public static VideoFrameProcessor.Factory lambda$static$0() {
            try {
                Class<?> cls = Class.forName("androidx.media3.effect.DefaultVideoFrameProcessor$Factory$Builder");
                return (VideoFrameProcessor.Factory) Assertions.checkNotNull(cls.getMethod("build", null).invoke(cls.getConstructor(null).newInstance(null), null));
            } catch (Exception e5) {
                throw new IllegalStateException(e5);
            }
        }

        @Override
        public VideoFrameProcessor create(Context context, DebugViewProvider debugViewProvider, ColorInfo colorInfo, boolean z7, Executor executor, VideoFrameProcessor.Listener listener) throws VideoFrameProcessingException {
            return ((VideoFrameProcessor.Factory) VIDEO_FRAME_PROCESSOR_FACTORY_SUPPLIER.get()).create(context, debugViewProvider, colorInfo, z7, executor, listener);
        }
    }

    public static final class ReflectivePreviewingSingleInputVideoGraphFactory implements PreviewingVideoGraph.Factory {
        private final VideoFrameProcessor.Factory videoFrameProcessorFactory;

        public ReflectivePreviewingSingleInputVideoGraphFactory(VideoFrameProcessor.Factory factory) {
            this.videoFrameProcessorFactory = factory;
        }

        @Override
        public PreviewingVideoGraph create(Context context, ColorInfo colorInfo, DebugViewProvider debugViewProvider, VideoGraph.Listener listener, Executor executor, VideoCompositorSettings videoCompositorSettings, List<Effect> list, long j10) throws VideoFrameProcessingException {
            try {
                try {
                    return ((PreviewingVideoGraph.Factory) Class.forName("androidx.media3.effect.PreviewingSingleInputVideoGraph$Factory").getConstructor(VideoFrameProcessor.Factory.class).newInstance(this.videoFrameProcessorFactory)).create(context, colorInfo, debugViewProvider, listener, executor, videoCompositorSettings, list, j10);
                } catch (Exception e5) {
                    e = e5;
                    throw VideoFrameProcessingException.from(e);
                }
            } catch (Exception e10) {
                e = e10;
            }
        }

        @Override
        public boolean supportsMultipleInputs() {
            return false;
        }
    }

    public void flush(boolean z7) {
        if (isInitialized()) {
            this.pendingFlushCount++;
            this.defaultVideoSink.flush(z7);
            while (this.streamStartPositionsUs.size() > 1) {
                this.streamStartPositionsUs.pollFirst();
            }
            if (this.streamStartPositionsUs.size() == 1) {
                this.defaultVideoSink.setStreamTimestampInfo(((Long) Assertions.checkNotNull(this.streamStartPositionsUs.pollFirst())).longValue(), this.bufferTimestampAdjustmentUs);
            }
            this.lastOutputBufferPresentationTimeUs = C0565C.TIME_UNSET;
            this.finalBufferPresentationTimeUs = C0565C.TIME_UNSET;
            this.hasSignaledEndOfCurrentInputStream = false;
            ((HandlerWrapper) Assertions.checkStateNotNull(this.handler)).post(new RunnableC0980c(2, this));
        }
    }

    public static ColorInfo getAdjustedInputColorInfo(ColorInfo colorInfo) {
        return (colorInfo == null || !colorInfo.isDataSpaceValid()) ? ColorInfo.SDR_BT709_LIMITED : colorInfo;
    }

    public boolean isEnded() {
        return this.pendingFlushCount == 0 && this.hasSignaledEndOfCurrentInputStream && this.defaultVideoSink.isEnded();
    }

    private boolean isInitialized() {
        return this.state == 1;
    }

    public boolean isReady(boolean z7) {
        return this.defaultVideoSink.isReady(z7 && this.pendingFlushCount == 0);
    }

    public void lambda$flush$1() {
        this.pendingFlushCount--;
    }

    private void maybeSetOutputSurfaceInfo(Surface surface, int i6, int i10) {
        PreviewingVideoGraph previewingVideoGraph = this.videoGraph;
        if (previewingVideoGraph == null) {
            return;
        }
        if (surface != null) {
            previewingVideoGraph.setOutputSurfaceInfo(new SurfaceInfo(surface, i6, i10));
            this.defaultVideoSink.setOutputSurfaceInfo(surface, new Size(i6, i10));
        } else {
            previewingVideoGraph.setOutputSurfaceInfo(null);
            this.defaultVideoSink.clearOutputSurfaceInfo();
        }
    }

    public VideoFrameProcessor registerInput(Format format, int i6) throws VideoSink.VideoSinkException {
        if (i6 == 0) {
            Assertions.checkState(this.state == 0);
            ColorInfo adjustedInputColorInfo = getAdjustedInputColorInfo(format.colorInfo);
            if (this.requestOpenGlToneMapping) {
                adjustedInputColorInfo = ColorInfo.SDR_BT709_LIMITED;
            } else if (adjustedInputColorInfo.colorTransfer == 7 && Util.SDK_INT < 34) {
                adjustedInputColorInfo = adjustedInputColorInfo.buildUpon().setColorTransfer(6).build();
            }
            ColorInfo colorInfo = adjustedInputColorInfo;
            final HandlerWrapper handlerWrapperCreateHandler = this.clock.createHandler((Looper) Assertions.checkStateNotNull(Looper.myLooper()), null);
            this.handler = handlerWrapperCreateHandler;
            try {
                PreviewingVideoGraph.Factory factory = this.previewingVideoGraphFactory;
                Context context = this.context;
                DebugViewProvider debugViewProvider = DebugViewProvider.NONE;
                Objects.requireNonNull(handlerWrapperCreateHandler);
                PreviewingVideoGraph previewingVideoGraphCreate = factory.create(context, colorInfo, debugViewProvider, this, new Executor() {
                    @Override
                    public final void execute(Runnable runnable) {
                        handlerWrapperCreateHandler.post(runnable);
                    }
                }, this.compositorSettings, this.compositionEffects, 0L);
                this.videoGraph = previewingVideoGraphCreate;
                previewingVideoGraphCreate.initialize();
                Pair<Surface, Size> pair = this.currentSurfaceAndSize;
                if (pair != null) {
                    Surface surface = (Surface) pair.first;
                    Size size = (Size) pair.second;
                    maybeSetOutputSurfaceInfo(surface, size.getWidth(), size.getHeight());
                }
                this.defaultVideoSink.initialize(format);
                this.state = 1;
            } catch (VideoFrameProcessingException e5) {
                throw new VideoSink.VideoSinkException(e5, format);
            }
        } else if (!isInitialized()) {
            return null;
        }
        try {
            ((PreviewingVideoGraph) Assertions.checkNotNull(this.videoGraph)).registerInput(i6);
            this.registeredVideoInputCount++;
            VideoSink videoSink = this.defaultVideoSink;
            DefaultVideoSinkListener defaultVideoSinkListener = new DefaultVideoSinkListener();
            final HandlerWrapper handlerWrapper = (HandlerWrapper) Assertions.checkNotNull(this.handler);
            Objects.requireNonNull(handlerWrapper);
            videoSink.setListener(defaultVideoSinkListener, new Executor() {
                @Override
                public final void execute(Runnable runnable) {
                    handlerWrapper.post(runnable);
                }
            });
            return this.videoGraph.getProcessor(i6);
        } catch (VideoFrameProcessingException e10) {
            throw new VideoSink.VideoSinkException(e10, format);
        }
    }

    public void render(long j10, long j11) throws VideoSink.VideoSinkException {
        this.defaultVideoSink.render(j10, j11);
    }

    public void setBufferTimestampAdjustment(long j10) {
        this.bufferTimestampAdjustmentUs = j10;
        this.defaultVideoSink.setStreamTimestampInfo(this.outputStreamStartPositionUs, j10);
    }

    public void setPlaybackSpeed(float f) {
        this.defaultVideoSink.setPlaybackSpeed(f);
    }

    public void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener) {
        this.defaultVideoSink.setVideoFrameMetadataListener(videoFrameMetadataListener);
    }

    public boolean shouldRenderToInputVideoSink() {
        int i6 = this.totalVideoInputCount;
        return i6 != -1 && i6 == this.registeredVideoInputCount;
    }

    public void addListener(Listener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void clearOutputSurfaceInfo() {
        Size size = Size.UNKNOWN;
        maybeSetOutputSurfaceInfo(null, size.getWidth(), size.getHeight());
        this.currentSurfaceAndSize = null;
    }

    @Override
    public VideoSink getSink(int i6) {
        Assertions.checkState(!Util.contains(this.inputVideoSinks, i6));
        InputVideoSink inputVideoSink = new InputVideoSink(this.context, i6);
        addListener(inputVideoSink);
        this.inputVideoSinks.put(i6, inputVideoSink);
        return inputVideoSink;
    }

    @Override
    public void onError(VideoFrameProcessingException videoFrameProcessingException) {
        Iterator<Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onError(this, videoFrameProcessingException);
        }
    }

    @Override
    public void onOutputFrameAvailableForRendering(long j10) {
        if (this.pendingFlushCount > 0) {
            return;
        }
        Renderer.WakeupListener wakeupListener = this.wakeupListener;
        if (wakeupListener != null) {
            wakeupListener.onWakeup();
        }
        long j11 = j10 - this.bufferTimestampAdjustmentUs;
        this.lastOutputBufferPresentationTimeUs = j11;
        Long lPollFloor = this.streamStartPositionsUs.pollFloor(j11);
        if (lPollFloor != null && lPollFloor.longValue() != this.outputStreamStartPositionUs) {
            this.defaultVideoSink.setStreamTimestampInfo(lPollFloor.longValue(), this.bufferTimestampAdjustmentUs);
            this.outputStreamStartPositionUs = lPollFloor.longValue();
        }
        long j12 = this.finalBufferPresentationTimeUs;
        boolean z7 = j12 != C0565C.TIME_UNSET && j11 >= j12;
        this.defaultVideoSink.handleInputFrame(j10, z7, this.videoFrameHandler);
        if (z7) {
            this.defaultVideoSink.signalEndOfCurrentInputStream();
            this.hasSignaledEndOfCurrentInputStream = true;
        }
    }

    @Override
    public void onOutputFrameRateChanged(float f) {
        Format formatBuild = this.videoGraphOutputFormat.buildUpon().setFrameRate(f).build();
        this.videoGraphOutputFormat = formatBuild;
        VideoSink videoSink = this.defaultVideoSink;
        C2204g1 c2204g1 = AbstractC2301u1.f8069b;
        videoSink.onInputStreamChanged(1, formatBuild, C2180c5.f7862e);
    }

    @Override
    public void onOutputSizeChanged(int i6, int i10) {
        Format formatBuild = this.videoGraphOutputFormat.buildUpon().setWidth(i6).setHeight(i10).build();
        this.videoGraphOutputFormat = formatBuild;
        VideoSink videoSink = this.defaultVideoSink;
        C2204g1 c2204g1 = AbstractC2301u1.f8069b;
        videoSink.onInputStreamChanged(1, formatBuild, C2180c5.f7862e);
    }

    @Override
    public void release() {
        if (this.state == 2) {
            return;
        }
        HandlerWrapper handlerWrapper = this.handler;
        if (handlerWrapper != null) {
            handlerWrapper.removeCallbacksAndMessages(null);
        }
        PreviewingVideoGraph previewingVideoGraph = this.videoGraph;
        if (previewingVideoGraph != null) {
            previewingVideoGraph.release();
        }
        this.currentSurfaceAndSize = null;
        this.state = 2;
    }

    public void removeListener(Listener listener) {
        this.listeners.remove(listener);
    }

    @Override
    public void setOutputSurfaceInfo(Surface surface, Size size) {
        Pair<Surface, Size> pair = this.currentSurfaceAndSize;
        if (pair != null && ((Surface) pair.first).equals(surface) && ((Size) this.currentSurfaceAndSize.second).equals(size)) {
            return;
        }
        this.currentSurfaceAndSize = Pair.create(surface, size);
        maybeSetOutputSurfaceInfo(surface, size.getWidth(), size.getHeight());
    }

    public void setTotalVideoInputCount(int i6) {
        this.totalVideoInputCount = i6;
    }

    private PlaybackVideoGraphWrapper(Builder builder) {
        this.context = builder.context;
        this.streamStartPositionsUs = new TimedValueQueue<>();
        this.previewingVideoGraphFactory = (PreviewingVideoGraph.Factory) Assertions.checkStateNotNull(builder.previewingVideoGraphFactory);
        this.inputVideoSinks = new SparseArray<>();
        this.compositionEffects = builder.compositionEffects;
        this.compositorSettings = builder.compositorSettings;
        Clock clock = builder.clock;
        this.clock = clock;
        this.defaultVideoSink = new DefaultVideoSink(builder.videoFrameReleaseControl, clock);
        this.videoFrameHandler = new VideoSink.VideoFrameHandler() {
            @Override
            public void render(long j10) {
                ((PreviewingVideoGraph) Assertions.checkStateNotNull(PlaybackVideoGraphWrapper.this.videoGraph)).renderOutputFrame(j10);
            }

            @Override
            public void skip() {
                ((PreviewingVideoGraph) Assertions.checkStateNotNull(PlaybackVideoGraphWrapper.this.videoGraph)).renderOutputFrame(-2L);
            }
        };
        this.listeners = new CopyOnWriteArraySet<>();
        this.requestOpenGlToneMapping = builder.requestOpenGlToneMapping;
        this.videoGraphOutputFormat = new Format.Builder().build();
        this.lastOutputBufferPresentationTimeUs = C0565C.TIME_UNSET;
        this.finalBufferPresentationTimeUs = C0565C.TIME_UNSET;
        this.totalVideoInputCount = -1;
        this.state = 0;
    }

    public static void lambda$static$0(Runnable runnable) {
    }

    @Override
    public void onEnded(long j10) {
    }
}

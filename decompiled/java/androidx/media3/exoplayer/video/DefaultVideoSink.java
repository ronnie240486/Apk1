package androidx.media3.exoplayer.video;

import android.graphics.Bitmap;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.media3.common.C0565C;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.Renderer;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;

final class DefaultVideoSink implements VideoSink {
    private long bufferTimestampAdjustmentUs;
    private final Clock clock;
    private Format inputFormat;
    private VideoSink.Listener listener;
    private Executor listenerExecutor;
    private Surface outputSurface;
    private long streamStartPositionUs;
    private final Queue<VideoSink.VideoFrameHandler> videoFrameHandlers;
    private VideoFrameMetadataListener videoFrameMetadataListener;
    private final VideoFrameReleaseControl videoFrameReleaseControl;
    private final VideoFrameRenderControl videoFrameRenderControl;

    public final class FrameRendererImpl implements VideoFrameRenderControl.FrameRenderer {
        private Format outputFormat;

        private FrameRendererImpl() {
        }

        public void lambda$dropFrame$2() {
            DefaultVideoSink.this.listener.onFrameDropped(DefaultVideoSink.this);
        }

        public void lambda$onVideoSizeChanged$0(VideoSize videoSize) {
            DefaultVideoSink.this.listener.onVideoSizeChanged(DefaultVideoSink.this, videoSize);
        }

        public void lambda$renderFrame$1() {
            DefaultVideoSink.this.listener.onFirstFrameRendered(DefaultVideoSink.this);
        }

        @Override
        public void dropFrame() {
            DefaultVideoSink.this.listenerExecutor.execute(new RunnableC0980c(1, this));
            ((VideoSink.VideoFrameHandler) DefaultVideoSink.this.videoFrameHandlers.remove()).skip();
        }

        @Override
        public void onVideoSizeChanged(VideoSize videoSize) {
            this.outputFormat = new Format.Builder().setWidth(videoSize.width).setHeight(videoSize.height).setSampleMimeType(MimeTypes.VIDEO_RAW).build();
            DefaultVideoSink.this.listenerExecutor.execute(new RunnableC0981d(this, 0, videoSize));
        }

        @Override
        public void renderFrame(long j10, long j11, boolean z7) {
            if (z7 && DefaultVideoSink.this.outputSurface != null) {
                DefaultVideoSink.this.listenerExecutor.execute(new RunnableC0980c(0, this));
            }
            Format formatBuild = this.outputFormat;
            if (formatBuild == null) {
                formatBuild = new Format.Builder().build();
            }
            DefaultVideoSink.this.videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j11, DefaultVideoSink.this.clock.nanoTime(), formatBuild, null);
            ((VideoSink.VideoFrameHandler) DefaultVideoSink.this.videoFrameHandlers.remove()).render(j10);
        }
    }

    public DefaultVideoSink(VideoFrameReleaseControl videoFrameReleaseControl, Clock clock) {
        this.videoFrameReleaseControl = videoFrameReleaseControl;
        videoFrameReleaseControl.setClock(clock);
        this.clock = clock;
        this.videoFrameRenderControl = new VideoFrameRenderControl(new FrameRendererImpl(), videoFrameReleaseControl);
        this.videoFrameHandlers = new ArrayDeque();
        this.inputFormat = new Format.Builder().build();
        this.streamStartPositionUs = C0565C.TIME_UNSET;
        this.listener = VideoSink.Listener.NO_OP;
        this.listenerExecutor = new ExecutorC0978a(0);
        this.videoFrameMetadataListener = new C0979b();
    }

    @Override
    public void clearOutputSurfaceInfo() {
        this.outputSurface = null;
        this.videoFrameReleaseControl.setOutputSurface(null);
    }

    @Override
    public void enableMayRenderStartOfStream() {
        this.videoFrameReleaseControl.allowReleaseFirstFrameBeforeStarted();
    }

    @Override
    public void flush(boolean z7) {
        if (z7) {
            this.videoFrameReleaseControl.reset();
        }
        this.videoFrameRenderControl.flush();
        this.videoFrameHandlers.clear();
    }

    @Override
    public Surface getInputSurface() {
        return (Surface) Assertions.checkStateNotNull(this.outputSurface);
    }

    @Override
    public boolean handleInputBitmap(Bitmap bitmap, TimestampIterator timestampIterator) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean handleInputFrame(long j10, boolean z7, VideoSink.VideoFrameHandler videoFrameHandler) {
        this.videoFrameHandlers.add(videoFrameHandler);
        this.videoFrameRenderControl.onFrameAvailableForRendering(j10 - this.bufferTimestampAdjustmentUs);
        return true;
    }

    @Override
    public boolean initialize(Format format) {
        return true;
    }

    @Override
    public boolean isEnded() {
        return this.videoFrameRenderControl.isEnded();
    }

    @Override
    public boolean isInitialized() {
        return true;
    }

    @Override
    public boolean isReady(boolean z7) {
        return this.videoFrameReleaseControl.isReady(z7);
    }

    @Override
    public void join(boolean z7) {
        this.videoFrameReleaseControl.join(z7);
    }

    @Override
    public void onInputStreamChanged(int i6, Format format, List<Effect> list) {
        Assertions.checkState(list.isEmpty());
        int i10 = format.width;
        Format format2 = this.inputFormat;
        if (i10 != format2.width || format.height != format2.height) {
            this.videoFrameRenderControl.onVideoSizeChanged(i10, format.height);
        }
        float f = format.frameRate;
        if (f != this.inputFormat.frameRate) {
            this.videoFrameReleaseControl.setFrameRate(f);
        }
        this.inputFormat = format;
    }

    @Override
    public void onRendererDisabled() {
        this.videoFrameReleaseControl.onDisabled();
    }

    @Override
    public void onRendererEnabled(boolean z7) {
        this.videoFrameReleaseControl.onEnabled(z7);
    }

    @Override
    public void onRendererStarted() {
        this.videoFrameReleaseControl.onStarted();
    }

    @Override
    public void onRendererStopped() {
        this.videoFrameReleaseControl.onStopped();
    }

    @Override
    public void render(long j10, long j11) throws VideoSink.VideoSinkException {
        try {
            this.videoFrameRenderControl.render(j10, j11);
        } catch (ExoPlaybackException e5) {
            throw new VideoSink.VideoSinkException(e5, this.inputFormat);
        }
    }

    @Override
    public void setChangeFrameRateStrategy(int i6) {
        this.videoFrameReleaseControl.setChangeFrameRateStrategy(i6);
    }

    @Override
    public void setListener(VideoSink.Listener listener, Executor executor) {
        this.listener = listener;
        this.listenerExecutor = executor;
    }

    @Override
    public void setOutputSurfaceInfo(Surface surface, Size size) {
        this.outputSurface = surface;
        this.videoFrameReleaseControl.setOutputSurface(surface);
    }

    @Override
    public void setPlaybackSpeed(float f) {
        this.videoFrameReleaseControl.setPlaybackSpeed(f);
    }

    @Override
    public void setStreamTimestampInfo(long j10, long j11) {
        if (j10 != this.streamStartPositionUs) {
            this.videoFrameRenderControl.onStreamStartPositionChanged(j10);
            this.streamStartPositionUs = j10;
        }
        this.bufferTimestampAdjustmentUs = j11;
    }

    @Override
    public void setVideoEffects(List<Effect> list) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener) {
        this.videoFrameMetadataListener = videoFrameMetadataListener;
    }

    @Override
    public void setWakeupListener(Renderer.WakeupListener wakeupListener) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void signalEndOfCurrentInputStream() {
        this.videoFrameRenderControl.signalEndOfInput();
    }

    @Override
    public void release() {
    }

    @Override
    public void signalEndOfInput() {
    }

    public static void lambda$new$0(Runnable runnable) {
    }

    public static void lambda$new$1(long j10, long j11, Format format, MediaFormat mediaFormat) {
    }
}

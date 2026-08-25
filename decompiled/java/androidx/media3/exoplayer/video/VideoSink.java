package androidx.media3.exoplayer.video;

import android.graphics.Bitmap;
import android.view.Surface;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.Renderer;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.concurrent.Executor;

@UnstableApi
public interface VideoSink {
    public static final int INPUT_TYPE_BITMAP = 2;
    public static final int INPUT_TYPE_SURFACE = 1;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface InputType {
    }

    public interface Listener {
        public static final Listener NO_OP = new Listener() {
            @Override
            public void onFirstFrameRendered(VideoSink videoSink) {
            }

            @Override
            public void onFrameDropped(VideoSink videoSink) {
            }

            @Override
            public void onError(VideoSink videoSink, VideoSinkException videoSinkException) {
            }

            @Override
            public void onVideoSizeChanged(VideoSink videoSink, VideoSize videoSize) {
            }
        };

        void onError(VideoSink videoSink, VideoSinkException videoSinkException);

        void onFirstFrameRendered(VideoSink videoSink);

        void onFrameDropped(VideoSink videoSink);

        void onVideoSizeChanged(VideoSink videoSink, VideoSize videoSize);
    }

    public interface VideoFrameHandler {
        void render(long j10);

        void skip();
    }

    public static final class VideoSinkException extends Exception {
        public final Format format;

        public VideoSinkException(Throwable th, Format format) {
            super(th);
            this.format = format;
        }
    }

    void clearOutputSurfaceInfo();

    void enableMayRenderStartOfStream();

    void flush(boolean z7);

    Surface getInputSurface();

    boolean handleInputBitmap(Bitmap bitmap, TimestampIterator timestampIterator);

    boolean handleInputFrame(long j10, boolean z7, VideoFrameHandler videoFrameHandler);

    boolean initialize(Format format) throws VideoSinkException;

    boolean isEnded();

    boolean isInitialized();

    boolean isReady(boolean z7);

    void join(boolean z7);

    void onInputStreamChanged(int i6, Format format, List<Effect> list);

    void onRendererDisabled();

    void onRendererEnabled(boolean z7);

    void onRendererStarted();

    void onRendererStopped();

    void release();

    void render(long j10, long j11) throws VideoSinkException;

    void setChangeFrameRateStrategy(int i6);

    void setListener(Listener listener, Executor executor);

    void setOutputSurfaceInfo(Surface surface, Size size);

    void setPlaybackSpeed(float f);

    void setStreamTimestampInfo(long j10, long j11);

    void setVideoEffects(List<Effect> list);

    void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

    void setWakeupListener(Renderer.WakeupListener wakeupListener);

    void signalEndOfCurrentInputStream();

    void signalEndOfInput();
}

package androidx.media3.common;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface VideoGraph {

    @UnstableApi
    public interface Listener {
        void onEnded(long j10);

        void onError(VideoFrameProcessingException videoFrameProcessingException);

        void onOutputFrameAvailableForRendering(long j10);

        void onOutputFrameRateChanged(float f);

        void onOutputSizeChanged(int i6, int i10);
    }

    VideoFrameProcessor getProcessor(int i6);

    boolean hasProducedFrameWithTimestampZero();

    void initialize() throws VideoFrameProcessingException;

    void registerInput(int i6) throws VideoFrameProcessingException;

    void release();

    void setOutputSurfaceInfo(SurfaceInfo surfaceInfo);
}

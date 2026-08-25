package androidx.media3.exoplayer;

import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.SampleStream;
import java.io.IOException;

@UnstableApi
public abstract class NoSampleRenderer implements Renderer, RendererCapabilities {
    private RendererConfiguration configuration;
    private int index;
    private int state;
    private SampleStream stream;
    private boolean streamIsFinal;

    @Override
    public final void clearListener() {
        AbstractC0947u0.m2575a(this);
    }

    @Override
    public final void disable() {
        Assertions.checkState(this.state == 1);
        this.state = 0;
        this.stream = null;
        this.streamIsFinal = false;
        onDisabled();
    }

    @Override
    public final void enable(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j10, boolean z7, boolean z10, long j11, long j12, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException {
        Assertions.checkState(this.state == 0);
        this.configuration = rendererConfiguration;
        this.state = 1;
        onEnabled(z7);
        replaceStream(formatArr, sampleStream, j11, j12, mediaPeriodId);
        onPositionReset(j10, z7);
    }

    @Override
    public final void enableMayRenderStartOfStream() {
        AbstractC0933t0.m2552a(this);
    }

    public final RendererConfiguration getConfiguration() {
        return this.configuration;
    }

    @Override
    public final long getDurationToProgressUs(long j10, long j11) {
        return AbstractC0933t0.m2553b(this, j10, j11);
    }

    public final int getIndex() {
        return this.index;
    }

    @Override
    public MediaClock getMediaClock() {
        return null;
    }

    @Override
    public long getReadingPositionUs() {
        return Long.MIN_VALUE;
    }

    @Override
    public final int getState() {
        return this.state;
    }

    @Override
    public final SampleStream getStream() {
        return this.stream;
    }

    @Override
    public final int getTrackType() {
        return -2;
    }

    @Override
    public final boolean hasReadStreamToEnd() {
        return true;
    }

    @Override
    public final void init(int i6, PlayerId playerId, Clock clock) {
        this.index = i6;
    }

    @Override
    public final boolean isCurrentStreamFinal() {
        return this.streamIsFinal;
    }

    @Override
    public boolean isEnded() {
        return true;
    }

    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public final void release() {
        AbstractC0933t0.m2554c(this);
    }

    @Override
    public final void replaceStream(Format[] formatArr, SampleStream sampleStream, long j10, long j11, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException {
        Assertions.checkState(!this.streamIsFinal);
        this.stream = sampleStream;
        onRendererOffsetChanged(j11);
    }

    @Override
    public final void reset() {
        Assertions.checkState(this.state == 0);
        onReset();
    }

    @Override
    public final void resetPosition(long j10) throws ExoPlaybackException {
        this.streamIsFinal = false;
        onPositionReset(j10, false);
    }

    @Override
    public final void setCurrentStreamFinal() {
        this.streamIsFinal = true;
    }

    @Override
    public final void setListener(RendererCapabilities.Listener listener) {
        AbstractC0947u0.m2576b(this, listener);
    }

    @Override
    public final void setPlaybackSpeed(float f, float f3) {
        AbstractC0933t0.m2555d(this, f, f3);
    }

    @Override
    public final void start() throws ExoPlaybackException {
        Assertions.checkState(this.state == 1);
        this.state = 2;
        onStarted();
    }

    @Override
    public final void stop() {
        Assertions.checkState(this.state == 2);
        this.state = 1;
        onStopped();
    }

    @Override
    public int supportsFormat(Format format) throws ExoPlaybackException {
        return AbstractC0947u0.m2577c(0);
    }

    @Override
    public int supportsMixedMimeTypeAdaptation() throws ExoPlaybackException {
        return 0;
    }

    @Override
    public final RendererCapabilities getCapabilities() {
        return this;
    }

    @Override
    public final void maybeThrowStreamError() throws IOException {
    }

    public void onDisabled() {
    }

    public void onReset() {
    }

    public void onStarted() throws ExoPlaybackException {
    }

    public void onStopped() {
    }

    public void onEnabled(boolean z7) throws ExoPlaybackException {
    }

    public void onRendererOffsetChanged(long j10) throws ExoPlaybackException {
    }

    @Override
    public void setTimeline(Timeline timeline) {
    }

    @Override
    public void handleMessage(int i6, Object obj) throws ExoPlaybackException {
    }

    public void onPositionReset(long j10, boolean z7) throws ExoPlaybackException {
    }
}

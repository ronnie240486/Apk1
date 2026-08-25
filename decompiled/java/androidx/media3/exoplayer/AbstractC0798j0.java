package androidx.media3.exoplayer;

import androidx.media3.common.Timeline;
import androidx.media3.common.util.Log;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;

public abstract class AbstractC0798j0 {
    public static long m2287a(LoadControl loadControl) {
        throw new IllegalStateException("getBackBufferDurationUs not implemented");
    }

    public static long m2288b(LoadControl loadControl, PlayerId playerId) {
        return loadControl.getBackBufferDurationUs();
    }

    public static void m2289c(LoadControl loadControl) {
        throw new IllegalStateException("onPrepared not implemented");
    }

    public static void m2290d(LoadControl loadControl, PlayerId playerId) {
        loadControl.onPrepared();
    }

    public static void m2291e(LoadControl loadControl) {
        throw new IllegalStateException("onReleased not implemented");
    }

    public static void m2292f(LoadControl loadControl, PlayerId playerId) {
        loadControl.onReleased();
    }

    public static void m2293g(LoadControl loadControl) {
        throw new IllegalStateException("onStopped not implemented");
    }

    public static void m2294h(LoadControl loadControl, PlayerId playerId) {
        loadControl.onStopped();
    }

    public static void m2295i(LoadControl loadControl, Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, Renderer[] rendererArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr) {
        loadControl.onTracksSelected(rendererArr, trackGroupArray, exoTrackSelectionArr);
    }

    public static void m2296j(LoadControl loadControl, LoadControl.Parameters parameters, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr) {
        throw new IllegalStateException("onTracksSelected not implemented");
    }

    public static void m2297k(LoadControl loadControl, PlayerId playerId, Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, Renderer[] rendererArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr) {
        loadControl.onTracksSelected(timeline, mediaPeriodId, rendererArr, trackGroupArray, exoTrackSelectionArr);
    }

    public static void m2298l(LoadControl loadControl, Renderer[] rendererArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr) {
        throw new IllegalStateException("onTracksSelected not implemented");
    }

    public static boolean m2299m(LoadControl loadControl) {
        throw new IllegalStateException("retainBackBufferFromKeyframe not implemented");
    }

    public static boolean m2300n(LoadControl loadControl, PlayerId playerId) {
        return loadControl.retainBackBufferFromKeyframe();
    }

    public static boolean m2301o(LoadControl loadControl, long j10, long j11, float f) {
        throw new IllegalStateException("shouldContinueLoading not implemented");
    }

    public static boolean m2302p(LoadControl loadControl, LoadControl.Parameters parameters) {
        return loadControl.shouldContinueLoading(parameters.playbackPositionUs, parameters.bufferedDurationUs, parameters.playbackSpeed);
    }

    public static boolean m2303q(LoadControl loadControl, Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j10) {
        Log.m1719w("LoadControl", "shouldContinuePreloading needs to be implemented when playlist preloading is enabled");
        return false;
    }

    public static boolean m2304r(LoadControl loadControl, long j10, float f, boolean z7, long j11) {
        throw new IllegalStateException("shouldStartPlayback not implemented");
    }

    public static boolean m2305s(LoadControl loadControl, Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j10, float f, boolean z7, long j11) {
        return loadControl.shouldStartPlayback(j10, f, z7, j11);
    }

    public static boolean m2306t(LoadControl loadControl, LoadControl.Parameters parameters) {
        return loadControl.shouldStartPlayback(parameters.timeline, parameters.mediaPeriodId, parameters.bufferedDurationUs, parameters.playbackSpeed, parameters.rebuffering, parameters.targetLiveOffsetUs);
    }
}

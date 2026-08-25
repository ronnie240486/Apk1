package androidx.media3.exoplayer.source.preload;

import android.content.Context;
import androidx.media3.common.FlagSet;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.trackselection.AbstractC0945g;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelector;

public final class C0923b implements ListenerSet.IterationFinishedEvent, TrackSelector.InvalidationListener, TrackSelector.Factory {
    @Override
    public TrackSelector createTrackSelector(Context context) {
        return new DefaultTrackSelector(context);
    }

    @Override
    public void invoke(Object obj, FlagSet flagSet) {
        BasePreloadManager.lambda$new$0((PreloadManagerListener) obj, flagSet);
    }

    @Override
    public void onRendererCapabilitiesChanged(Renderer renderer) {
        AbstractC0945g.m2574a(this, renderer);
    }

    @Override
    public void onTrackSelectionsInvalidated() {
        DefaultPreloadManager.lambda$new$0();
    }
}

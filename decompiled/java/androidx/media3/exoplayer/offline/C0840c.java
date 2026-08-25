package androidx.media3.exoplayer.offline;

import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.trackselection.AbstractC0945g;
import androidx.media3.exoplayer.trackselection.TrackSelector;

public final class C0840c implements TrackSelector.InvalidationListener {
    @Override
    public final void onRendererCapabilitiesChanged(Renderer renderer) {
        AbstractC0945g.m2574a(this, renderer);
    }

    @Override
    public final void onTrackSelectionsInvalidated() {
        DownloadHelper.lambda$new$0();
    }
}

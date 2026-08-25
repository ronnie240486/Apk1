package androidx.media3.common;

import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.media3.common.util.Size;
import p020b7.InterfaceC1339e0;

public final class C0608q implements InterfaceC1339e0 {

    public final int f2620a;

    public final SimpleBasePlayer.State f2621b;

    public final Object f2622c;

    public C0608q(SimpleBasePlayer.State state, Object obj, int i6) {
        this.f2620a = i6;
        this.f2621b = state;
        this.f2622c = obj;
    }

    @Override
    public final Object get() {
        switch (this.f2620a) {
            case 0:
                return SimpleBasePlayer.lambda$setVideoTextureView$20(this.f2621b, (Size) this.f2622c);
            case 1:
                return SimpleBasePlayer.lambda$setPlaylistMetadata$15(this.f2621b, (MediaMetadata) this.f2622c);
            case 2:
                return SimpleBasePlayer.lambda$setVideoSurfaceHolder$18(this.f2621b, (SurfaceHolder) this.f2622c);
            case 3:
                return SimpleBasePlayer.lambda$setVideoSurfaceView$19(this.f2621b, (SurfaceView) this.f2622c);
            case 4:
                return SimpleBasePlayer.lambda$setAudioAttributes$30(this.f2621b, (AudioAttributes) this.f2622c);
            case 5:
                return ((SimpleBasePlayer) this.f2622c).lambda$stop$12(this.f2621b);
            case 6:
                return SimpleBasePlayer.lambda$setPlaybackParameters$11(this.f2621b, (PlaybackParameters) this.f2622c);
            default:
                return SimpleBasePlayer.lambda$setTrackSelectionParameters$14(this.f2621b, (TrackSelectionParameters) this.f2622c);
        }
    }

    public C0608q(SimpleBasePlayer simpleBasePlayer, SimpleBasePlayer.State state) {
        this.f2620a = 5;
        this.f2622c = simpleBasePlayer;
        this.f2621b = state;
    }
}

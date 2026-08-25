package androidx.media3.exoplayer;

import androidx.media3.common.FlagSet;
import androidx.media3.common.Player;
import androidx.media3.common.util.BackgroundThreadStateHandler;
import androidx.media3.common.util.ListenerSet;

public final class C0738d0 implements ListenerSet.Event, ListenerSet.IterationFinishedEvent, ExoPlayerImplInternal.PlaybackInfoUpdateListener, BackgroundThreadStateHandler.StateChangeListener, SuitableOutputChecker.Callback {

    public final int f2809a;

    public final ExoPlayerImpl f2810b;

    public C0738d0(ExoPlayerImpl exoPlayerImpl, int i6) {
        this.f2809a = i6;
        this.f2810b = exoPlayerImpl;
    }

    @Override
    public void invoke(Object obj) {
        switch (this.f2809a) {
            case 0:
                this.f2810b.lambda$setPlaylistMetadata$8((Player.Listener) obj);
                break;
            default:
                this.f2810b.lambda$updateAvailableCommands$28((Player.Listener) obj);
                break;
        }
    }

    @Override
    public void onPlaybackInfoUpdate(ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        this.f2810b.lambda$new$2(playbackInfoUpdate);
    }

    @Override
    public void onSelectedOutputSuitabilityChanged(boolean z7) {
        this.f2810b.onSelectedOutputSuitabilityChanged(z7);
    }

    @Override
    public void onStateChanged(Object obj, Object obj2) {
        this.f2810b.onAudioSessionIdChanged(((Integer) obj).intValue(), ((Integer) obj2).intValue());
    }

    @Override
    public void invoke(Object obj, FlagSet flagSet) {
        this.f2810b.lambda$new$0((Player.Listener) obj, flagSet);
    }
}

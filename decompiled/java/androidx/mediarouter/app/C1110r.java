package androidx.mediarouter.app;

import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.PlaybackStateCompat;

public final class C1110r extends MediaControllerCompat.Callback {

    public final DialogC1116u f3348a;

    public C1110r(DialogC1116u dialogC1116u) {
        this.f3348a = dialogC1116u;
    }

    @Override
    public final void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
        MediaDescriptionCompat description = mediaMetadataCompat == null ? null : mediaMetadataCompat.getDescription();
        DialogC1116u dialogC1116u = this.f3348a;
        dialogC1116u.f3386U = description;
        dialogC1116u.m2800t();
        dialogC1116u.m2799s(false);
    }

    @Override
    public final void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
        DialogC1116u dialogC1116u = this.f3348a;
        dialogC1116u.f3385T = playbackStateCompat;
        dialogC1116u.m2799s(false);
    }

    @Override
    public final void onSessionDestroyed() {
        DialogC1116u dialogC1116u = this.f3348a;
        MediaControllerCompat mediaControllerCompat = dialogC1116u.f3383R;
        if (mediaControllerCompat != null) {
            mediaControllerCompat.unregisterCallback(dialogC1116u.f3384S);
            dialogC1116u.f3383R = null;
        }
    }
}

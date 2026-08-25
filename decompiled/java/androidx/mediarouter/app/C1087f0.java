package androidx.mediarouter.app;

import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;

public final class C1087f0 extends MediaControllerCompat.Callback {

    public final DialogC1109q0 f3239a;

    public C1087f0(DialogC1109q0 dialogC1109q0) {
        this.f3239a = dialogC1109q0;
    }

    @Override
    public final void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
        MediaDescriptionCompat description = mediaMetadataCompat == null ? null : mediaMetadataCompat.getDescription();
        DialogC1109q0 dialogC1109q0 = this.f3239a;
        dialogC1109q0.f3318K = description;
        dialogC1109q0.m2773j();
        dialogC1109q0.m2777n();
    }

    @Override
    public final void onSessionDestroyed() {
        DialogC1109q0 dialogC1109q0 = this.f3239a;
        MediaControllerCompat mediaControllerCompat = dialogC1109q0.f3316I;
        if (mediaControllerCompat != null) {
            mediaControllerCompat.unregisterCallback(dialogC1109q0.f3317J);
            dialogC1109q0.f3316I = null;
        }
    }
}

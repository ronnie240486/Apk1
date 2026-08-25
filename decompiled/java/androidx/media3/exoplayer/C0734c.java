package androidx.media3.exoplayer;

import android.media.AudioManager;

public final class C0734c implements AudioManager.OnAudioFocusChangeListener {

    public final AudioFocusManager f2801a;

    public C0734c(AudioFocusManager audioFocusManager) {
        this.f2801a = audioFocusManager;
    }

    @Override
    public final void onAudioFocusChange(int i6) {
        this.f2801a.handlePlatformAudioFocusChange(i6);
    }
}

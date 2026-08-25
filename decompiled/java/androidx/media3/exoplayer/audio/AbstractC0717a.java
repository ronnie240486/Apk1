package androidx.media3.exoplayer.audio;

import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.media.MediaDrm;
import android.media.PlaybackParams;

public abstract class AbstractC0717a {
    public static AudioDeviceInfo m2137g(Object obj) {
        return (AudioDeviceInfo) obj;
    }

    public static AudioTrack.Builder m2138h() {
        return new AudioTrack.Builder();
    }

    public static MediaDrm.KeyStatus m2144n(Object obj) {
        return (MediaDrm.KeyStatus) obj;
    }

    public static PlaybackParams m2145o() {
        return new PlaybackParams();
    }
}

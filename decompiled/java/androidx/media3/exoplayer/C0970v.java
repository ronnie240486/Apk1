package androidx.media3.exoplayer;

import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.Player;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.BackgroundThreadStateHandler;
import androidx.media3.common.util.ListenerSet;
import java.util.List;

public final class C0970v implements ListenerSet.Event, MediaPeriodHolder.Factory, BackgroundThreadStateHandler.StateChangeListener {

    public final int f3041a;

    public final Object f3042b;

    public C0970v(int i6, Object obj) {
        this.f3041a = i6;
        this.f3042b = obj;
    }

    @Override
    public MediaPeriodHolder create(MediaPeriodInfo mediaPeriodInfo, long j10) {
        return ((ExoPlayerImplInternal) this.f3042b).createMediaPeriodHolder(mediaPeriodInfo, j10);
    }

    @Override
    public void invoke(Object obj) {
        switch (this.f3041a) {
            case 0:
                ((Player.Listener) obj).onMediaMetadataChanged((MediaMetadata) this.f3042b);
                break;
            case 1:
                ((Player.Listener) obj).onAudioAttributesChanged((AudioAttributes) this.f3042b);
                break;
            case 2:
                ((Player.Listener) obj).onTrackSelectionParametersChanged((TrackSelectionParameters) this.f3042b);
                break;
            case 3:
                ((Player.Listener) obj).onCues((CueGroup) this.f3042b);
                break;
            case 4:
                ((ExoPlayerImpl.ComponentListener) this.f3042b).lambda$onMetadata$4((Player.Listener) obj);
                break;
            case 5:
                ((Player.Listener) obj).onMetadata((Metadata) this.f3042b);
                break;
            case 6:
                ((Player.Listener) obj).onCues((List<Cue>) this.f3042b);
                break;
            case 7:
                ((Player.Listener) obj).onVideoSizeChanged((VideoSize) this.f3042b);
                break;
            default:
                ((Player.Listener) obj).onDeviceInfoChanged((DeviceInfo) this.f3042b);
                break;
        }
    }

    @Override
    public void onStateChanged(Object obj, Object obj2) {
        ((StreamVolumeManager) this.f3042b).onStreamVolumeStateChanged((StreamVolumeManager.StreamVolumeState) obj, (StreamVolumeManager.StreamVolumeState) obj2);
    }
}

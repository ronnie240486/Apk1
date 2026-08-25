package androidx.media3.exoplayer.audio;

import android.media.AudioTrack;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
public class DefaultAudioTrackProvider implements DefaultAudioSink.AudioTrackProvider {
    private AudioTrack createAudioTrackV21(AudioSink.AudioTrackConfig audioTrackConfig, AudioAttributes audioAttributes, int i6) {
        return new AudioTrack(getAudioTrackAttributesV21(audioAttributes, audioTrackConfig.tunneling), Util.getAudioFormat(audioTrackConfig.sampleRate, audioTrackConfig.channelConfig, audioTrackConfig.encoding), audioTrackConfig.bufferSize, 1, i6);
    }

    private AudioTrack createAudioTrackV23(AudioSink.AudioTrackConfig audioTrackConfig, AudioAttributes audioAttributes, int i6) {
        AudioTrack.Builder sessionId = AbstractC0717a.m2138h().setAudioAttributes(getAudioTrackAttributesV21(audioAttributes, audioTrackConfig.tunneling)).setAudioFormat(Util.getAudioFormat(audioTrackConfig.sampleRate, audioTrackConfig.channelConfig, audioTrackConfig.encoding)).setTransferMode(1).setBufferSizeInBytes(audioTrackConfig.bufferSize).setSessionId(i6);
        if (Util.SDK_INT >= 29) {
            setOffloadedPlaybackV29(sessionId, audioTrackConfig.offload);
        }
        return customizeAudioTrackBuilder(sessionId).build();
    }

    private android.media.AudioAttributes getAudioTrackAttributesV21(AudioAttributes audioAttributes, boolean z7) {
        return z7 ? getAudioTrackTunnelingAttributesV21() : audioAttributes.getAudioAttributesV21().audioAttributes;
    }

    private android.media.AudioAttributes getAudioTrackTunnelingAttributesV21() {
        return new android.media.AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
    }

    private void setOffloadedPlaybackV29(AudioTrack.Builder builder, boolean z7) {
        builder.setOffloadedPlayback(z7);
    }

    @Override
    public final AudioTrack getAudioTrack(AudioSink.AudioTrackConfig audioTrackConfig, AudioAttributes audioAttributes, int i6) {
        return Util.SDK_INT >= 23 ? createAudioTrackV23(audioTrackConfig, audioAttributes, i6) : createAudioTrackV21(audioTrackConfig, audioAttributes, i6);
    }

    public AudioTrack.Builder customizeAudioTrackBuilder(AudioTrack.Builder builder) {
        return builder;
    }
}

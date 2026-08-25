package androidx.media3.common.audio;

import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface AudioProcessorChain {
    PlaybackParameters applyPlaybackParameters(PlaybackParameters playbackParameters);

    boolean applySkipSilenceEnabled(boolean z7);

    AudioProcessor[] getAudioProcessors();

    long getMediaDuration(long j10);

    long getSkippedOutputFrameCount();
}

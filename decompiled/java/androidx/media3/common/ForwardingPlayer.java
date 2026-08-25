package androidx.media3.common;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.UnstableApi;
import java.util.List;

@UnstableApi
public class ForwardingPlayer implements Player {
    private final Player player;

    public static final class ForwardingListener implements Player.Listener {
        private final ForwardingPlayer forwardingPlayer;
        private final Player.Listener listener;

        public ForwardingListener(ForwardingPlayer forwardingPlayer, Player.Listener listener) {
            this.forwardingPlayer = forwardingPlayer;
            this.listener = listener;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ForwardingListener)) {
                return false;
            }
            ForwardingListener forwardingListener = (ForwardingListener) obj;
            if (this.forwardingPlayer.equals(forwardingListener.forwardingPlayer)) {
                return this.listener.equals(forwardingListener.listener);
            }
            return false;
        }

        public int hashCode() {
            return this.listener.hashCode() + (this.forwardingPlayer.hashCode() * 31);
        }

        @Override
        public void onAudioAttributesChanged(AudioAttributes audioAttributes) {
            this.listener.onAudioAttributesChanged(audioAttributes);
        }

        @Override
        public void onAudioSessionIdChanged(int i6) {
            this.listener.onAudioSessionIdChanged(i6);
        }

        @Override
        public void onAvailableCommandsChanged(Player.Commands commands) {
            this.listener.onAvailableCommandsChanged(commands);
        }

        @Override
        public void onCues(List<Cue> list) {
            this.listener.onCues(list);
        }

        @Override
        public void onDeviceInfoChanged(DeviceInfo deviceInfo) {
            this.listener.onDeviceInfoChanged(deviceInfo);
        }

        @Override
        public void onDeviceVolumeChanged(int i6, boolean z7) {
            this.listener.onDeviceVolumeChanged(i6, z7);
        }

        @Override
        public void onEvents(Player player, Player.Events events) {
            this.listener.onEvents(this.forwardingPlayer, events);
        }

        @Override
        public void onIsLoadingChanged(boolean z7) {
            this.listener.onIsLoadingChanged(z7);
        }

        @Override
        public void onIsPlayingChanged(boolean z7) {
            this.listener.onIsPlayingChanged(z7);
        }

        @Override
        public void onLoadingChanged(boolean z7) {
            this.listener.onIsLoadingChanged(z7);
        }

        @Override
        public void onMaxSeekToPreviousPositionChanged(long j10) {
            this.listener.onMaxSeekToPreviousPositionChanged(j10);
        }

        @Override
        public void onMediaItemTransition(MediaItem mediaItem, int i6) {
            this.listener.onMediaItemTransition(mediaItem, i6);
        }

        @Override
        public void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
            this.listener.onMediaMetadataChanged(mediaMetadata);
        }

        @Override
        public void onMetadata(Metadata metadata) {
            this.listener.onMetadata(metadata);
        }

        @Override
        public void onPlayWhenReadyChanged(boolean z7, int i6) {
            this.listener.onPlayWhenReadyChanged(z7, i6);
        }

        @Override
        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            this.listener.onPlaybackParametersChanged(playbackParameters);
        }

        @Override
        public void onPlaybackStateChanged(int i6) {
            this.listener.onPlaybackStateChanged(i6);
        }

        @Override
        public void onPlaybackSuppressionReasonChanged(int i6) {
            this.listener.onPlaybackSuppressionReasonChanged(i6);
        }

        @Override
        public void onPlayerError(PlaybackException playbackException) {
            this.listener.onPlayerError(playbackException);
        }

        @Override
        public void onPlayerErrorChanged(PlaybackException playbackException) {
            this.listener.onPlayerErrorChanged(playbackException);
        }

        @Override
        public void onPlayerStateChanged(boolean z7, int i6) {
            this.listener.onPlayerStateChanged(z7, i6);
        }

        @Override
        public void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
            this.listener.onPlaylistMetadataChanged(mediaMetadata);
        }

        @Override
        public void onPositionDiscontinuity(int i6) {
            this.listener.onPositionDiscontinuity(i6);
        }

        @Override
        public void onRenderedFirstFrame() {
            this.listener.onRenderedFirstFrame();
        }

        @Override
        public void onRepeatModeChanged(int i6) {
            this.listener.onRepeatModeChanged(i6);
        }

        @Override
        public void onSeekBackIncrementChanged(long j10) {
            this.listener.onSeekBackIncrementChanged(j10);
        }

        @Override
        public void onSeekForwardIncrementChanged(long j10) {
            this.listener.onSeekForwardIncrementChanged(j10);
        }

        @Override
        public void onShuffleModeEnabledChanged(boolean z7) {
            this.listener.onShuffleModeEnabledChanged(z7);
        }

        @Override
        public void onSkipSilenceEnabledChanged(boolean z7) {
            this.listener.onSkipSilenceEnabledChanged(z7);
        }

        @Override
        public void onSurfaceSizeChanged(int i6, int i10) {
            this.listener.onSurfaceSizeChanged(i6, i10);
        }

        @Override
        public void onTimelineChanged(Timeline timeline, int i6) {
            this.listener.onTimelineChanged(timeline, i6);
        }

        @Override
        public void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
            this.listener.onTrackSelectionParametersChanged(trackSelectionParameters);
        }

        @Override
        public void onTracksChanged(Tracks tracks) {
            this.listener.onTracksChanged(tracks);
        }

        @Override
        public void onVideoSizeChanged(VideoSize videoSize) {
            this.listener.onVideoSizeChanged(videoSize);
        }

        @Override
        public void onVolumeChanged(float f) {
            this.listener.onVolumeChanged(f);
        }

        @Override
        public void onCues(CueGroup cueGroup) {
            this.listener.onCues(cueGroup);
        }

        @Override
        public void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i6) {
            this.listener.onPositionDiscontinuity(positionInfo, positionInfo2, i6);
        }
    }

    public ForwardingPlayer(Player player) {
        this.player = player;
    }

    @Override
    public void addListener(Player.Listener listener) {
        this.player.addListener(new ForwardingListener(this, listener));
    }

    @Override
    public void addMediaItem(MediaItem mediaItem) {
        this.player.addMediaItem(mediaItem);
    }

    @Override
    public void addMediaItems(List<MediaItem> list) {
        this.player.addMediaItems(list);
    }

    @Override
    public boolean canAdvertiseSession() {
        return this.player.canAdvertiseSession();
    }

    @Override
    public void clearMediaItems() {
        this.player.clearMediaItems();
    }

    @Override
    public void clearVideoSurface() {
        this.player.clearVideoSurface();
    }

    @Override
    public void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        this.player.clearVideoSurfaceHolder(surfaceHolder);
    }

    @Override
    public void clearVideoSurfaceView(SurfaceView surfaceView) {
        this.player.clearVideoSurfaceView(surfaceView);
    }

    @Override
    public void clearVideoTextureView(TextureView textureView) {
        this.player.clearVideoTextureView(textureView);
    }

    @Override
    @Deprecated
    public void decreaseDeviceVolume() {
        this.player.decreaseDeviceVolume();
    }

    @Override
    public Looper getApplicationLooper() {
        return this.player.getApplicationLooper();
    }

    @Override
    public AudioAttributes getAudioAttributes() {
        return this.player.getAudioAttributes();
    }

    @Override
    public Player.Commands getAvailableCommands() {
        return this.player.getAvailableCommands();
    }

    @Override
    public int getBufferedPercentage() {
        return this.player.getBufferedPercentage();
    }

    @Override
    public long getBufferedPosition() {
        return this.player.getBufferedPosition();
    }

    @Override
    public long getContentBufferedPosition() {
        return this.player.getContentBufferedPosition();
    }

    @Override
    public long getContentDuration() {
        return this.player.getContentDuration();
    }

    @Override
    public long getContentPosition() {
        return this.player.getContentPosition();
    }

    @Override
    public int getCurrentAdGroupIndex() {
        return this.player.getCurrentAdGroupIndex();
    }

    @Override
    public int getCurrentAdIndexInAdGroup() {
        return this.player.getCurrentAdIndexInAdGroup();
    }

    @Override
    public CueGroup getCurrentCues() {
        return this.player.getCurrentCues();
    }

    @Override
    public long getCurrentLiveOffset() {
        return this.player.getCurrentLiveOffset();
    }

    @Override
    public Object getCurrentManifest() {
        return this.player.getCurrentManifest();
    }

    @Override
    public MediaItem getCurrentMediaItem() {
        return this.player.getCurrentMediaItem();
    }

    @Override
    public int getCurrentMediaItemIndex() {
        return this.player.getCurrentMediaItemIndex();
    }

    @Override
    public int getCurrentPeriodIndex() {
        return this.player.getCurrentPeriodIndex();
    }

    @Override
    public long getCurrentPosition() {
        return this.player.getCurrentPosition();
    }

    @Override
    public Timeline getCurrentTimeline() {
        return this.player.getCurrentTimeline();
    }

    @Override
    public Tracks getCurrentTracks() {
        return this.player.getCurrentTracks();
    }

    @Override
    @Deprecated
    public int getCurrentWindowIndex() {
        return this.player.getCurrentWindowIndex();
    }

    @Override
    public DeviceInfo getDeviceInfo() {
        return this.player.getDeviceInfo();
    }

    @Override
    public int getDeviceVolume() {
        return this.player.getDeviceVolume();
    }

    @Override
    public long getDuration() {
        return this.player.getDuration();
    }

    @Override
    public long getMaxSeekToPreviousPosition() {
        return this.player.getMaxSeekToPreviousPosition();
    }

    @Override
    public MediaItem getMediaItemAt(int i6) {
        return this.player.getMediaItemAt(i6);
    }

    @Override
    public int getMediaItemCount() {
        return this.player.getMediaItemCount();
    }

    @Override
    public MediaMetadata getMediaMetadata() {
        return this.player.getMediaMetadata();
    }

    @Override
    public int getNextMediaItemIndex() {
        return this.player.getNextMediaItemIndex();
    }

    @Override
    @Deprecated
    public int getNextWindowIndex() {
        return this.player.getNextWindowIndex();
    }

    @Override
    public boolean getPlayWhenReady() {
        return this.player.getPlayWhenReady();
    }

    @Override
    public PlaybackParameters getPlaybackParameters() {
        return this.player.getPlaybackParameters();
    }

    @Override
    public int getPlaybackState() {
        return this.player.getPlaybackState();
    }

    @Override
    public int getPlaybackSuppressionReason() {
        return this.player.getPlaybackSuppressionReason();
    }

    @Override
    public PlaybackException getPlayerError() {
        return this.player.getPlayerError();
    }

    @Override
    public MediaMetadata getPlaylistMetadata() {
        return this.player.getPlaylistMetadata();
    }

    @Override
    public int getPreviousMediaItemIndex() {
        return this.player.getPreviousMediaItemIndex();
    }

    @Override
    @Deprecated
    public int getPreviousWindowIndex() {
        return this.player.getPreviousWindowIndex();
    }

    @Override
    public int getRepeatMode() {
        return this.player.getRepeatMode();
    }

    @Override
    public long getSeekBackIncrement() {
        return this.player.getSeekBackIncrement();
    }

    @Override
    public long getSeekForwardIncrement() {
        return this.player.getSeekForwardIncrement();
    }

    @Override
    public boolean getShuffleModeEnabled() {
        return this.player.getShuffleModeEnabled();
    }

    @Override
    public Size getSurfaceSize() {
        return this.player.getSurfaceSize();
    }

    @Override
    public long getTotalBufferedDuration() {
        return this.player.getTotalBufferedDuration();
    }

    @Override
    public TrackSelectionParameters getTrackSelectionParameters() {
        return this.player.getTrackSelectionParameters();
    }

    @Override
    public VideoSize getVideoSize() {
        return this.player.getVideoSize();
    }

    @Override
    public float getVolume() {
        return this.player.getVolume();
    }

    public Player getWrappedPlayer() {
        return this.player;
    }

    @Override
    @Deprecated
    public boolean hasNext() {
        return this.player.hasNext();
    }

    @Override
    public boolean hasNextMediaItem() {
        return this.player.hasNextMediaItem();
    }

    @Override
    @Deprecated
    public boolean hasNextWindow() {
        return this.player.hasNextWindow();
    }

    @Override
    public boolean hasPreviousMediaItem() {
        return this.player.hasPreviousMediaItem();
    }

    @Override
    @Deprecated
    public void increaseDeviceVolume() {
        this.player.increaseDeviceVolume();
    }

    @Override
    public boolean isCommandAvailable(int i6) {
        return this.player.isCommandAvailable(i6);
    }

    @Override
    public boolean isCurrentMediaItemDynamic() {
        return this.player.isCurrentMediaItemDynamic();
    }

    @Override
    public boolean isCurrentMediaItemLive() {
        return this.player.isCurrentMediaItemLive();
    }

    @Override
    public boolean isCurrentMediaItemSeekable() {
        return this.player.isCurrentMediaItemSeekable();
    }

    @Override
    @Deprecated
    public boolean isCurrentWindowDynamic() {
        return this.player.isCurrentWindowDynamic();
    }

    @Override
    @Deprecated
    public boolean isCurrentWindowLive() {
        return this.player.isCurrentWindowLive();
    }

    @Override
    @Deprecated
    public boolean isCurrentWindowSeekable() {
        return this.player.isCurrentWindowSeekable();
    }

    @Override
    public boolean isDeviceMuted() {
        return this.player.isDeviceMuted();
    }

    @Override
    public boolean isLoading() {
        return this.player.isLoading();
    }

    @Override
    public boolean isPlaying() {
        return this.player.isPlaying();
    }

    @Override
    public boolean isPlayingAd() {
        return this.player.isPlayingAd();
    }

    @Override
    public void moveMediaItem(int i6, int i10) {
        this.player.moveMediaItem(i6, i10);
    }

    @Override
    public void moveMediaItems(int i6, int i10, int i11) {
        this.player.moveMediaItems(i6, i10, i11);
    }

    @Override
    @Deprecated
    public void next() {
        this.player.next();
    }

    @Override
    public void pause() {
        this.player.pause();
    }

    @Override
    public void play() {
        this.player.play();
    }

    @Override
    public void prepare() {
        this.player.prepare();
    }

    @Override
    public void release() {
        this.player.release();
    }

    @Override
    public void removeListener(Player.Listener listener) {
        this.player.removeListener(new ForwardingListener(this, listener));
    }

    @Override
    public void removeMediaItem(int i6) {
        this.player.removeMediaItem(i6);
    }

    @Override
    public void removeMediaItems(int i6, int i10) {
        this.player.removeMediaItems(i6, i10);
    }

    @Override
    public void replaceMediaItem(int i6, MediaItem mediaItem) {
        this.player.replaceMediaItem(i6, mediaItem);
    }

    @Override
    public void replaceMediaItems(int i6, int i10, List<MediaItem> list) {
        this.player.replaceMediaItems(i6, i10, list);
    }

    @Override
    public void seekBack() {
        this.player.seekBack();
    }

    @Override
    public void seekForward() {
        this.player.seekForward();
    }

    @Override
    public void seekTo(long j10) {
        this.player.seekTo(j10);
    }

    @Override
    public void seekToDefaultPosition() {
        this.player.seekToDefaultPosition();
    }

    @Override
    public void seekToNext() {
        this.player.seekToNext();
    }

    @Override
    public void seekToNextMediaItem() {
        this.player.seekToNextMediaItem();
    }

    @Override
    @Deprecated
    public void seekToNextWindow() {
        this.player.seekToNextWindow();
    }

    @Override
    public void seekToPrevious() {
        this.player.seekToPrevious();
    }

    @Override
    public void seekToPreviousMediaItem() {
        this.player.seekToPreviousMediaItem();
    }

    @Override
    @Deprecated
    public void seekToPreviousWindow() {
        this.player.seekToPreviousWindow();
    }

    @Override
    public void setAudioAttributes(AudioAttributes audioAttributes, boolean z7) {
        this.player.setAudioAttributes(audioAttributes, z7);
    }

    @Override
    @Deprecated
    public void setDeviceMuted(boolean z7) {
        this.player.setDeviceMuted(z7);
    }

    @Override
    @Deprecated
    public void setDeviceVolume(int i6) {
        this.player.setDeviceVolume(i6);
    }

    @Override
    public void setMediaItem(MediaItem mediaItem) {
        this.player.setMediaItem(mediaItem);
    }

    @Override
    public void setMediaItems(List<MediaItem> list) {
        this.player.setMediaItems(list);
    }

    @Override
    public void setPlayWhenReady(boolean z7) {
        this.player.setPlayWhenReady(z7);
    }

    @Override
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.player.setPlaybackParameters(playbackParameters);
    }

    @Override
    public void setPlaybackSpeed(float f) {
        this.player.setPlaybackSpeed(f);
    }

    @Override
    public void setPlaylistMetadata(MediaMetadata mediaMetadata) {
        this.player.setPlaylistMetadata(mediaMetadata);
    }

    @Override
    public void setRepeatMode(int i6) {
        this.player.setRepeatMode(i6);
    }

    @Override
    public void setShuffleModeEnabled(boolean z7) {
        this.player.setShuffleModeEnabled(z7);
    }

    @Override
    public void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        this.player.setTrackSelectionParameters(trackSelectionParameters);
    }

    @Override
    public void setVideoSurface(Surface surface) {
        this.player.setVideoSurface(surface);
    }

    @Override
    public void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        this.player.setVideoSurfaceHolder(surfaceHolder);
    }

    @Override
    public void setVideoSurfaceView(SurfaceView surfaceView) {
        this.player.setVideoSurfaceView(surfaceView);
    }

    @Override
    public void setVideoTextureView(TextureView textureView) {
        this.player.setVideoTextureView(textureView);
    }

    @Override
    public void setVolume(float f) {
        this.player.setVolume(f);
    }

    @Override
    public void stop() {
        this.player.stop();
    }

    @Override
    public void addMediaItem(int i6, MediaItem mediaItem) {
        this.player.addMediaItem(i6, mediaItem);
    }

    @Override
    public void addMediaItems(int i6, List<MediaItem> list) {
        this.player.addMediaItems(i6, list);
    }

    @Override
    public void clearVideoSurface(Surface surface) {
        this.player.clearVideoSurface(surface);
    }

    @Override
    public void decreaseDeviceVolume(int i6) {
        this.player.decreaseDeviceVolume(i6);
    }

    @Override
    public void increaseDeviceVolume(int i6) {
        this.player.increaseDeviceVolume(i6);
    }

    @Override
    public void seekTo(int i6, long j10) {
        this.player.seekTo(i6, j10);
    }

    @Override
    public void seekToDefaultPosition(int i6) {
        this.player.seekToDefaultPosition(i6);
    }

    @Override
    public void setDeviceMuted(boolean z7, int i6) {
        this.player.setDeviceMuted(z7, i6);
    }

    @Override
    public void setDeviceVolume(int i6, int i10) {
        this.player.setDeviceVolume(i6, i10);
    }

    @Override
    public void setMediaItem(MediaItem mediaItem, long j10) {
        this.player.setMediaItem(mediaItem, j10);
    }

    @Override
    public void setMediaItems(List<MediaItem> list, boolean z7) {
        this.player.setMediaItems(list, z7);
    }

    @Override
    public void setMediaItem(MediaItem mediaItem, boolean z7) {
        this.player.setMediaItem(mediaItem, z7);
    }

    @Override
    public void setMediaItems(List<MediaItem> list, int i6, long j10) {
        this.player.setMediaItems(list, i6, j10);
    }
}

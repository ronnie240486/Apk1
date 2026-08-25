package androidx.media3.common;

import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.UnstableApi;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Objects;

@UnstableApi
public class ForwardingSimpleBasePlayer extends SimpleBasePlayer {
    private Metadata lastTimedMetadata;
    private LivePositionSuppliers livePositionSuppliers;
    private int pendingDiscontinuityReason;
    private boolean pendingFirstFrameRendered;
    private long pendingPositionDiscontinuityNewPositionMs;
    private int playWhenReadyChangeReason;
    private final Player player;

    public static final class LivePositionSuppliers {
        public final SimpleBasePlayer.LivePositionSupplier bufferedPositionSupplier;
        public final SimpleBasePlayer.LivePositionSupplier contentBufferedPositionSupplier;
        public final SimpleBasePlayer.LivePositionSupplier contentPositionSupplier;
        public final SimpleBasePlayer.LivePositionSupplier currentPositionSupplier;
        public final SimpleBasePlayer.LivePositionSupplier totalBufferedPositionSupplier;

        public LivePositionSuppliers(final Player player) {
            Objects.requireNonNull(player);
            final int i6 = 0;
            this.currentPositionSupplier = new SimpleBasePlayer.LivePositionSupplier(new SimpleBasePlayer.PositionSupplier() {
                @Override
                public final long get() {
                    switch (i6) {
                        case 0:
                            return player.getCurrentPosition();
                        case 1:
                            return player.getBufferedPosition();
                        case 2:
                            return player.getContentPosition();
                        case 3:
                            return player.getContentBufferedPosition();
                        default:
                            return player.getTotalBufferedDuration();
                    }
                }
            });
            final int i10 = 1;
            this.bufferedPositionSupplier = new SimpleBasePlayer.LivePositionSupplier(new SimpleBasePlayer.PositionSupplier() {
                @Override
                public final long get() {
                    switch (i10) {
                        case 0:
                            return player.getCurrentPosition();
                        case 1:
                            return player.getBufferedPosition();
                        case 2:
                            return player.getContentPosition();
                        case 3:
                            return player.getContentBufferedPosition();
                        default:
                            return player.getTotalBufferedDuration();
                    }
                }
            });
            final int i11 = 2;
            this.contentPositionSupplier = new SimpleBasePlayer.LivePositionSupplier(new SimpleBasePlayer.PositionSupplier() {
                @Override
                public final long get() {
                    switch (i11) {
                        case 0:
                            return player.getCurrentPosition();
                        case 1:
                            return player.getBufferedPosition();
                        case 2:
                            return player.getContentPosition();
                        case 3:
                            return player.getContentBufferedPosition();
                        default:
                            return player.getTotalBufferedDuration();
                    }
                }
            });
            final int i12 = 3;
            this.contentBufferedPositionSupplier = new SimpleBasePlayer.LivePositionSupplier(new SimpleBasePlayer.PositionSupplier() {
                @Override
                public final long get() {
                    switch (i12) {
                        case 0:
                            return player.getCurrentPosition();
                        case 1:
                            return player.getBufferedPosition();
                        case 2:
                            return player.getContentPosition();
                        case 3:
                            return player.getContentBufferedPosition();
                        default:
                            return player.getTotalBufferedDuration();
                    }
                }
            });
            final int i13 = 4;
            this.totalBufferedPositionSupplier = new SimpleBasePlayer.LivePositionSupplier(new SimpleBasePlayer.PositionSupplier() {
                @Override
                public final long get() {
                    switch (i13) {
                        case 0:
                            return player.getCurrentPosition();
                        case 1:
                            return player.getBufferedPosition();
                        case 2:
                            return player.getContentPosition();
                        case 3:
                            return player.getContentBufferedPosition();
                        default:
                            return player.getTotalBufferedDuration();
                    }
                }
            });
        }

        public void disconnect(long j10, long j11) {
            this.currentPositionSupplier.disconnect(j10);
            this.bufferedPositionSupplier.disconnect(j10);
            this.contentPositionSupplier.disconnect(j11);
            this.contentBufferedPositionSupplier.disconnect(j11);
            this.totalBufferedPositionSupplier.disconnect(0L);
        }
    }

    public ForwardingSimpleBasePlayer(final Player player) {
        super(player.getApplicationLooper());
        this.player = player;
        this.lastTimedMetadata = new Metadata(C0565C.TIME_UNSET, new Metadata.Entry[0]);
        this.playWhenReadyChangeReason = 1;
        this.pendingDiscontinuityReason = 5;
        this.livePositionSuppliers = new LivePositionSuppliers(player);
        player.addListener(new Player.Listener() {
            @Override
            public final void onAudioAttributesChanged(AudioAttributes audioAttributes) {
                AbstractC0602k.m1682a(this, audioAttributes);
            }

            @Override
            public final void onAudioSessionIdChanged(int i6) {
                AbstractC0602k.m1683b(this, i6);
            }

            @Override
            public final void onAvailableCommandsChanged(Player.Commands commands) {
                AbstractC0602k.m1684c(this, commands);
            }

            @Override
            public final void onCues(CueGroup cueGroup) {
                AbstractC0602k.m1685d(this, cueGroup);
            }

            @Override
            public final void onDeviceInfoChanged(DeviceInfo deviceInfo) {
                AbstractC0602k.m1687f(this, deviceInfo);
            }

            @Override
            public final void onDeviceVolumeChanged(int i6, boolean z7) {
                AbstractC0602k.m1688g(this, i6, z7);
            }

            @Override
            public void onEvents(Player player2, Player.Events events) {
                ForwardingSimpleBasePlayer.this.invalidateState();
            }

            @Override
            public final void onIsLoadingChanged(boolean z7) {
                AbstractC0602k.m1690i(this, z7);
            }

            @Override
            public final void onIsPlayingChanged(boolean z7) {
                AbstractC0602k.m1691j(this, z7);
            }

            @Override
            public final void onLoadingChanged(boolean z7) {
                AbstractC0602k.m1692k(this, z7);
            }

            @Override
            public final void onMaxSeekToPreviousPositionChanged(long j10) {
                AbstractC0602k.m1693l(this, j10);
            }

            @Override
            public final void onMediaItemTransition(MediaItem mediaItem, int i6) {
                AbstractC0602k.m1694m(this, mediaItem, i6);
            }

            @Override
            public final void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
                AbstractC0602k.m1695n(this, mediaMetadata);
            }

            @Override
            public void onMetadata(Metadata metadata) {
                ForwardingSimpleBasePlayer.this.lastTimedMetadata = metadata;
            }

            @Override
            public void onPlayWhenReadyChanged(boolean z7, int i6) {
                ForwardingSimpleBasePlayer.this.playWhenReadyChangeReason = i6;
            }

            @Override
            public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
                AbstractC0602k.m1698q(this, playbackParameters);
            }

            @Override
            public final void onPlaybackStateChanged(int i6) {
                AbstractC0602k.m1699r(this, i6);
            }

            @Override
            public final void onPlaybackSuppressionReasonChanged(int i6) {
                AbstractC0602k.m1700s(this, i6);
            }

            @Override
            public final void onPlayerError(PlaybackException playbackException) {
                AbstractC0602k.m1701t(this, playbackException);
            }

            @Override
            public final void onPlayerErrorChanged(PlaybackException playbackException) {
                AbstractC0602k.m1702u(this, playbackException);
            }

            @Override
            public final void onPlayerStateChanged(boolean z7, int i6) {
                AbstractC0602k.m1703v(this, z7, i6);
            }

            @Override
            public final void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
                AbstractC0602k.m1704w(this, mediaMetadata);
            }

            @Override
            public final void onPositionDiscontinuity(int i6) {
                AbstractC0602k.m1705x(this, i6);
            }

            @Override
            public void onRenderedFirstFrame() {
                ForwardingSimpleBasePlayer.this.pendingFirstFrameRendered = true;
            }

            @Override
            public final void onRepeatModeChanged(int i6) {
                AbstractC0602k.m1671A(this, i6);
            }

            @Override
            public final void onSeekBackIncrementChanged(long j10) {
                AbstractC0602k.m1672B(this, j10);
            }

            @Override
            public final void onSeekForwardIncrementChanged(long j10) {
                AbstractC0602k.m1673C(this, j10);
            }

            @Override
            public final void onShuffleModeEnabledChanged(boolean z7) {
                AbstractC0602k.m1674D(this, z7);
            }

            @Override
            public final void onSkipSilenceEnabledChanged(boolean z7) {
                AbstractC0602k.m1675E(this, z7);
            }

            @Override
            public final void onSurfaceSizeChanged(int i6, int i10) {
                AbstractC0602k.m1676F(this, i6, i10);
            }

            @Override
            public final void onTimelineChanged(Timeline timeline, int i6) {
                AbstractC0602k.m1677G(this, timeline, i6);
            }

            @Override
            public final void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
                AbstractC0602k.m1678H(this, trackSelectionParameters);
            }

            @Override
            public final void onTracksChanged(Tracks tracks) {
                AbstractC0602k.m1679I(this, tracks);
            }

            @Override
            public final void onVideoSizeChanged(VideoSize videoSize) {
                AbstractC0602k.m1680J(this, videoSize);
            }

            @Override
            public final void onVolumeChanged(float f) {
                AbstractC0602k.m1681K(this, f);
            }

            @Override
            public final void onCues(List list) {
                AbstractC0602k.m1686e(this, list);
            }

            @Override
            public void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i6) {
                ForwardingSimpleBasePlayer.this.pendingDiscontinuityReason = i6;
                ForwardingSimpleBasePlayer.this.pendingPositionDiscontinuityNewPositionMs = positionInfo2.positionMs;
                ForwardingSimpleBasePlayer.this.livePositionSuppliers.disconnect(positionInfo.positionMs, positionInfo.contentPositionMs);
                ForwardingSimpleBasePlayer.this.livePositionSuppliers = new LivePositionSuppliers(player);
            }
        });
    }

    public final Player getPlayer() {
        return this.player;
    }

    @Override
    public SimpleBasePlayer.State getState() {
        SimpleBasePlayer.State.Builder builder = new SimpleBasePlayer.State.Builder();
        LivePositionSuppliers livePositionSuppliers = this.livePositionSuppliers;
        if (this.player.isCommandAvailable(16)) {
            builder.setAdBufferedPositionMs(livePositionSuppliers.bufferedPositionSupplier);
            builder.setAdPositionMs(livePositionSuppliers.currentPositionSupplier);
        }
        if (this.player.isCommandAvailable(21)) {
            builder.setAudioAttributes(this.player.getAudioAttributes());
        }
        builder.setAvailableCommands(this.player.getAvailableCommands());
        if (this.player.isCommandAvailable(16)) {
            builder.setContentBufferedPositionMs(livePositionSuppliers.contentBufferedPositionSupplier);
            builder.setContentPositionMs(livePositionSuppliers.contentPositionSupplier);
            if (this.player.isCommandAvailable(17)) {
                builder.setCurrentAd(this.player.getCurrentAdGroupIndex(), this.player.getCurrentAdIndexInAdGroup());
            }
        }
        if (this.player.isCommandAvailable(28)) {
            builder.setCurrentCues(this.player.getCurrentCues());
        }
        if (this.player.isCommandAvailable(17)) {
            builder.setCurrentMediaItemIndex(this.player.getCurrentMediaItemIndex());
        }
        builder.setDeviceInfo(this.player.getDeviceInfo());
        if (this.player.isCommandAvailable(23)) {
            builder.setDeviceVolume(this.player.getDeviceVolume());
            builder.setIsDeviceMuted(this.player.isDeviceMuted());
        }
        builder.setIsLoading(this.player.isLoading());
        builder.setMaxSeekToPreviousPositionMs(this.player.getMaxSeekToPreviousPosition());
        if (this.pendingFirstFrameRendered) {
            builder.setNewlyRenderedFirstFrame(true);
            this.pendingFirstFrameRendered = false;
        }
        builder.setPlaybackParameters(this.player.getPlaybackParameters());
        builder.setPlaybackState(this.player.getPlaybackState());
        builder.setPlaybackSuppressionReason(this.player.getPlaybackSuppressionReason());
        builder.setPlayerError(this.player.getPlayerError());
        if (this.player.isCommandAvailable(17)) {
            builder.setPlaylist(this.player.getCurrentTimeline(), this.player.isCommandAvailable(30) ? this.player.getCurrentTracks() : Tracks.EMPTY, this.player.isCommandAvailable(18) ? this.player.getMediaMetadata() : null);
        }
        if (this.player.isCommandAvailable(18)) {
            builder.setPlaylistMetadata(this.player.getPlaylistMetadata());
        }
        builder.setPlayWhenReady(this.player.getPlayWhenReady(), this.playWhenReadyChangeReason);
        long j10 = this.pendingPositionDiscontinuityNewPositionMs;
        if (j10 != C0565C.TIME_UNSET) {
            builder.setPositionDiscontinuity(this.pendingDiscontinuityReason, j10);
            this.pendingPositionDiscontinuityNewPositionMs = C0565C.TIME_UNSET;
        }
        builder.setRepeatMode(this.player.getRepeatMode());
        builder.setSeekBackIncrementMs(this.player.getSeekBackIncrement());
        builder.setSeekForwardIncrementMs(this.player.getSeekForwardIncrement());
        builder.setShuffleModeEnabled(this.player.getShuffleModeEnabled());
        builder.setSurfaceSize(this.player.getSurfaceSize());
        builder.setTimedMetadata(this.lastTimedMetadata);
        if (this.player.isCommandAvailable(16)) {
            builder.setTotalBufferedDurationMs(livePositionSuppliers.totalBufferedPositionSupplier);
        }
        builder.setTrackSelectionParameters(this.player.getTrackSelectionParameters());
        builder.setVideoSize(this.player.getVideoSize());
        if (this.player.isCommandAvailable(22)) {
            builder.setVolume(this.player.getVolume());
        }
        return builder.build();
    }

    @Override
    public ListenableFuture<?> handleAddMediaItems(int i6, List<MediaItem> list) {
        if (list.size() == 1) {
            this.player.addMediaItem(i6, list.get(0));
        } else {
            this.player.addMediaItems(i6, list);
        }
        return Futures.immediateVoidFuture();
    }

    @Override
    public ListenableFuture<?> handleClearVideoOutput(Object obj) {
        if (obj instanceof SurfaceView) {
            this.player.clearVideoSurfaceView((SurfaceView) obj);
        } else if (obj instanceof TextureView) {
            this.player.clearVideoTextureView((TextureView) obj);
        } else if (obj instanceof SurfaceHolder) {
            this.player.clearVideoSurfaceHolder((SurfaceHolder) obj);
        } else if (obj instanceof Surface) {
            this.player.clearVideoSurface((Surface) obj);
        } else {
            if (obj != null) {
                throw new IllegalStateException();
            }
            this.player.clearVideoSurface();
        }
        return Futures.immediateVoidFuture();
    }

    @Override
    public ListenableFuture<?> handleDecreaseDeviceVolume(int i6) {
        if (this.player.isCommandAvailable(34)) {
            this.player.decreaseDeviceVolume(i6);
        } else {
            this.player.decreaseDeviceVolume();
        }
        return Futures.immediateVoidFuture();
    }

    @Override
    public ListenableFuture<?> handleIncreaseDeviceVolume(int i6) {
        if (this.player.isCommandAvailable(34)) {
            this.player.increaseDeviceVolume(i6);
        } else {
            this.player.increaseDeviceVolume();
        }
        return Futures.immediateVoidFuture();
    }

    @Override
    public ListenableFuture<?> handleMoveMediaItems(int i6, int i10, int i11) {
        if (i10 == i6 + 1) {
            this.player.moveMediaItem(i6, i11);
        } else {
            this.player.moveMediaItems(i6, i10, i11);
        }
        return Futures.immediateVoidFuture();
    }

    @Override
    public ListenableFuture<?> handlePrepare() {
        this.player.prepare();
        return Futures.immediateVoidFuture();
    }

    @Override
    public ListenableFuture<?> handleRelease() {
        this.player.release();
        return Futures.immediateVoidFuture();
    }

    @Override
    public ListenableFuture<?> handleRemoveMediaItems(int i6, int i10) {
        if (i10 == i6 + 1) {
            this.player.removeMediaItem(i6);
        } else {
            this.player.removeMediaItems(i6, i10);
        }
        return Futures.immediateVoidFuture();
    }

    @Override
    public ListenableFuture<?> handleReplaceMediaItems(int i6, int i10, List<MediaItem> list) {
        if (i10 == i6 + 1 && list.size() == 1) {
            this.player.replaceMediaItem(i6, list.get(0));
        } else {
            this.player.replaceMediaItems(i6, i10, list);
        }
        return Futures.immediateVoidFuture();
    }

    @Override
    public ListenableFuture<?> handleSeek(int i6, long j10, int i10) {
        switch (i10) {
            case 4:
                this.player.seekToDefaultPosition();
                break;
            case 5:
                this.player.seekTo(j10);
                break;
            case 6:
                this.player.seekToPreviousMediaItem();
                break;
            case 7:
                this.player.seekToPrevious();
                break;
            case 8:
                this.player.seekToNextMediaItem();
                break;
            case 9:
                this.player.seekToNext();
                break;
            case 10:
                if (i6 != -1) {
                    this.player.seekTo(i6, j10);
                }
                break;
            case 11:
                this.player.seekBack();
                break;
            case 12:
                this.player.seekForward();
                break;
            default:
                throw new IllegalStateException();
        }
        return Futures.immediateVoidFuture();
    }

    @Override
    public ListenableFuture<?> handleSetAudioAttributes(AudioAttributes audioAttributes, boolean z7) {
        this.player.setAudioAttributes(audioAttributes, z7);
        return Futures.immediateVoidFuture();
    }

    @Override
    public ListenableFuture<?> handleSetDeviceMuted(boolean z7, int i6) {
        if (this.player.isCommandAvailable(34)) {
            this.player.setDeviceMuted(z7, i6);
        } else {
            this.player.setDeviceMuted(z7);
        }
        return Futures.immediateVoidFuture();
    }

    @Override
    public ListenableFuture<?> handleSetDeviceVolume(int i6, int i10) {
        if (this.player.isCommandAvailable(33)) {
            this.player.setDeviceVolume(i6, i10);
        } else {
            this.player.setDeviceVolume(i6);
        }
        return Futures.immediateVoidFuture();
    }

    @Override
    public ListenableFuture<?> handleSetMediaItems(List<MediaItem> list, int i6, long j10) {
        boolean z7 = list.size() == 1 && this.player.isCommandAvailable(31);
        if (i6 == -1) {
            if (z7) {
                this.player.setMediaItem(list.get(0));
            } else {
                this.player.setMediaItems(list);
            }
        } else if (z7) {
            this.player.setMediaItem(list.get(0), j10);
        } else {
            this.player.setMediaItems(list, i6, j10);
        }
        return Futures.immediateVoidFuture();
    }

    @Override
    public ListenableFuture<?> handleSetPlayWhenReady(boolean z7) {
        this.player.setPlayWhenReady(z7);
        return Futures.immediateVoidFuture();
    }

    @Override
    public ListenableFuture<?> handleSetPlaybackParameters(PlaybackParameters playbackParameters) {
        this.player.setPlaybackParameters(playbackParameters);
        return Futures.immediateVoidFuture();
    }

    @Override
    public ListenableFuture<?> handleSetPlaylistMetadata(MediaMetadata mediaMetadata) {
        this.player.setPlaylistMetadata(mediaMetadata);
        return Futures.immediateVoidFuture();
    }

    @Override
    public ListenableFuture<?> handleSetRepeatMode(int i6) {
        this.player.setRepeatMode(i6);
        return Futures.immediateVoidFuture();
    }

    @Override
    public ListenableFuture<?> handleSetShuffleModeEnabled(boolean z7) {
        this.player.setShuffleModeEnabled(z7);
        return Futures.immediateVoidFuture();
    }

    @Override
    public ListenableFuture<?> handleSetTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        this.player.setTrackSelectionParameters(trackSelectionParameters);
        return Futures.immediateVoidFuture();
    }

    @Override
    public ListenableFuture<?> handleSetVideoOutput(Object obj) {
        if (obj instanceof SurfaceView) {
            this.player.setVideoSurfaceView((SurfaceView) obj);
        } else if (obj instanceof TextureView) {
            this.player.setVideoTextureView((TextureView) obj);
        } else if (obj instanceof SurfaceHolder) {
            this.player.setVideoSurfaceHolder((SurfaceHolder) obj);
        } else {
            if (!(obj instanceof Surface)) {
                throw new IllegalStateException();
            }
            this.player.setVideoSurface((Surface) obj);
        }
        return Futures.immediateVoidFuture();
    }

    @Override
    public ListenableFuture<?> handleSetVolume(float f) {
        this.player.setVolume(f);
        return Futures.immediateVoidFuture();
    }

    @Override
    public ListenableFuture<?> handleStop() {
        this.player.stop();
        return Futures.immediateVoidFuture();
    }
}

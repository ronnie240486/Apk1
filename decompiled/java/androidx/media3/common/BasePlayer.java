package androidx.media3.common;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.List;
import p041d7.AbstractC2301u1;

@UnstableApi
public abstract class BasePlayer implements Player {
    protected final Timeline.Window window = new Timeline.Window();

    private int getRepeatModeForNavigation() {
        int repeatMode = getRepeatMode();
        if (repeatMode == 1) {
            return 0;
        }
        return repeatMode;
    }

    private void ignoreSeek(int i6) {
        seekTo(-1, C0565C.TIME_UNSET, i6, false);
    }

    private void repeatCurrentMediaItem(int i6) {
        seekTo(getCurrentMediaItemIndex(), C0565C.TIME_UNSET, i6, true);
    }

    private void seekToCurrentItem(long j10, int i6) {
        seekTo(getCurrentMediaItemIndex(), j10, i6, false);
    }

    private void seekToDefaultPositionInternal(int i6, int i10) {
        seekTo(i6, C0565C.TIME_UNSET, i10, false);
    }

    private void seekToNextMediaItemInternal(int i6) {
        int nextMediaItemIndex = getNextMediaItemIndex();
        if (nextMediaItemIndex == -1) {
            ignoreSeek(i6);
        } else if (nextMediaItemIndex == getCurrentMediaItemIndex()) {
            repeatCurrentMediaItem(i6);
        } else {
            seekToDefaultPositionInternal(nextMediaItemIndex, i6);
        }
    }

    private void seekToOffset(long j10, int i6) {
        long currentPosition = getCurrentPosition() + j10;
        long duration = getDuration();
        if (duration != C0565C.TIME_UNSET) {
            currentPosition = Math.min(currentPosition, duration);
        }
        seekToCurrentItem(Math.max(currentPosition, 0L), i6);
    }

    private void seekToPreviousMediaItemInternal(int i6) {
        int previousMediaItemIndex = getPreviousMediaItemIndex();
        if (previousMediaItemIndex == -1) {
            ignoreSeek(i6);
        } else if (previousMediaItemIndex == getCurrentMediaItemIndex()) {
            repeatCurrentMediaItem(i6);
        } else {
            seekToDefaultPositionInternal(previousMediaItemIndex, i6);
        }
    }

    @Override
    public final void addMediaItem(int i6, MediaItem mediaItem) {
        addMediaItems(i6, AbstractC2301u1.m5275r(mediaItem));
    }

    @Override
    public final void addMediaItems(List<MediaItem> list) {
        addMediaItems(Integer.MAX_VALUE, list);
    }

    @Override
    public final boolean canAdvertiseSession() {
        return true;
    }

    @Override
    public final void clearMediaItems() {
        removeMediaItems(0, Integer.MAX_VALUE);
    }

    @Override
    public final int getBufferedPercentage() {
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == C0565C.TIME_UNSET || duration == C0565C.TIME_UNSET) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return Util.constrainValue((int) ((bufferedPosition * 100) / duration), 0, 100);
    }

    @Override
    public final long getContentDuration() {
        Timeline currentTimeline = getCurrentTimeline();
        return currentTimeline.isEmpty() ? C0565C.TIME_UNSET : currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).getDurationMs();
    }

    @Override
    public final long getCurrentLiveOffset() {
        Timeline currentTimeline = getCurrentTimeline();
        return (currentTimeline.isEmpty() || currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).windowStartTimeMs == C0565C.TIME_UNSET) ? C0565C.TIME_UNSET : (this.window.getCurrentUnixTimeMs() - this.window.windowStartTimeMs) - getContentPosition();
    }

    @Override
    public final Object getCurrentManifest() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return null;
        }
        return currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).manifest;
    }

    @Override
    public final MediaItem getCurrentMediaItem() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return null;
        }
        return currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).mediaItem;
    }

    @Override
    @Deprecated
    public final int getCurrentWindowIndex() {
        return getCurrentMediaItemIndex();
    }

    @Override
    public final MediaItem getMediaItemAt(int i6) {
        return getCurrentTimeline().getWindow(i6, this.window).mediaItem;
    }

    @Override
    public final int getMediaItemCount() {
        return getCurrentTimeline().getWindowCount();
    }

    @Override
    public final int getNextMediaItemIndex() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -1;
        }
        return currentTimeline.getNextWindowIndex(getCurrentMediaItemIndex(), getRepeatModeForNavigation(), getShuffleModeEnabled());
    }

    @Override
    @Deprecated
    public final int getNextWindowIndex() {
        return getNextMediaItemIndex();
    }

    @Override
    public final int getPreviousMediaItemIndex() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -1;
        }
        return currentTimeline.getPreviousWindowIndex(getCurrentMediaItemIndex(), getRepeatModeForNavigation(), getShuffleModeEnabled());
    }

    @Override
    @Deprecated
    public final int getPreviousWindowIndex() {
        return getPreviousMediaItemIndex();
    }

    @Override
    @Deprecated
    public final boolean hasNext() {
        return hasNextMediaItem();
    }

    @Override
    public final boolean hasNextMediaItem() {
        return getNextMediaItemIndex() != -1;
    }

    @Override
    @Deprecated
    public final boolean hasNextWindow() {
        return hasNextMediaItem();
    }

    @Override
    public final boolean hasPreviousMediaItem() {
        return getPreviousMediaItemIndex() != -1;
    }

    @Override
    public final boolean isCommandAvailable(int i6) {
        return getAvailableCommands().contains(i6);
    }

    @Override
    public final boolean isCurrentMediaItemDynamic() {
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).isDynamic;
    }

    @Override
    public final boolean isCurrentMediaItemLive() {
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).isLive();
    }

    @Override
    public final boolean isCurrentMediaItemSeekable() {
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).isSeekable;
    }

    @Override
    @Deprecated
    public final boolean isCurrentWindowDynamic() {
        return isCurrentMediaItemDynamic();
    }

    @Override
    @Deprecated
    public final boolean isCurrentWindowLive() {
        return isCurrentMediaItemLive();
    }

    @Override
    @Deprecated
    public final boolean isCurrentWindowSeekable() {
        return isCurrentMediaItemSeekable();
    }

    @Override
    public final boolean isPlaying() {
        return getPlaybackState() == 3 && getPlayWhenReady() && getPlaybackSuppressionReason() == 0;
    }

    @Override
    public final void moveMediaItem(int i6, int i10) {
        if (i6 != i10) {
            moveMediaItems(i6, i6 + 1, i10);
        }
    }

    @Override
    @Deprecated
    public final void next() {
        seekToNextMediaItem();
    }

    @Override
    public final void pause() {
        setPlayWhenReady(false);
    }

    @Override
    public final void play() {
        setPlayWhenReady(true);
    }

    @Override
    public final void removeMediaItem(int i6) {
        removeMediaItems(i6, i6 + 1);
    }

    @Override
    public final void replaceMediaItem(int i6, MediaItem mediaItem) {
        replaceMediaItems(i6, i6 + 1, AbstractC2301u1.m5275r(mediaItem));
    }

    @Override
    public final void seekBack() {
        seekToOffset(-getSeekBackIncrement(), 11);
    }

    @Override
    public final void seekForward() {
        seekToOffset(getSeekForwardIncrement(), 12);
    }

    public abstract void seekTo(int i6, long j10, int i10, boolean z7);

    @Override
    public final void seekTo(long j10) {
        seekToCurrentItem(j10, 5);
    }

    @Override
    public final void seekToDefaultPosition() {
        seekToDefaultPositionInternal(getCurrentMediaItemIndex(), 4);
    }

    @Override
    public final void seekToNext() {
        if (getCurrentTimeline().isEmpty() || isPlayingAd()) {
            ignoreSeek(9);
            return;
        }
        if (hasNextMediaItem()) {
            seekToNextMediaItemInternal(9);
        } else if (isCurrentMediaItemLive() && isCurrentMediaItemDynamic()) {
            seekToDefaultPositionInternal(getCurrentMediaItemIndex(), 9);
        } else {
            ignoreSeek(9);
        }
    }

    @Override
    public final void seekToNextMediaItem() {
        seekToNextMediaItemInternal(8);
    }

    @Override
    @Deprecated
    public final void seekToNextWindow() {
        seekToNextMediaItem();
    }

    @Override
    public final void seekToPrevious() {
        if (getCurrentTimeline().isEmpty() || isPlayingAd()) {
            ignoreSeek(7);
            return;
        }
        boolean zHasPreviousMediaItem = hasPreviousMediaItem();
        if (isCurrentMediaItemLive() && !isCurrentMediaItemSeekable()) {
            if (zHasPreviousMediaItem) {
                seekToPreviousMediaItemInternal(7);
                return;
            } else {
                ignoreSeek(7);
                return;
            }
        }
        if (!zHasPreviousMediaItem || getCurrentPosition() > getMaxSeekToPreviousPosition()) {
            seekToCurrentItem(0L, 7);
        } else {
            seekToPreviousMediaItemInternal(7);
        }
    }

    @Override
    public final void seekToPreviousMediaItem() {
        seekToPreviousMediaItemInternal(6);
    }

    @Override
    @Deprecated
    public final void seekToPreviousWindow() {
        seekToPreviousMediaItem();
    }

    @Override
    public final void setMediaItem(MediaItem mediaItem) {
        setMediaItems(AbstractC2301u1.m5275r(mediaItem));
    }

    @Override
    public final void setMediaItems(List<MediaItem> list) {
        setMediaItems(list, true);
    }

    @Override
    public final void setPlaybackSpeed(float f) {
        setPlaybackParameters(getPlaybackParameters().withSpeed(f));
    }

    @Override
    public final void addMediaItem(MediaItem mediaItem) {
        addMediaItems(AbstractC2301u1.m5275r(mediaItem));
    }

    @Override
    public final void seekTo(int i6, long j10) {
        seekTo(i6, j10, 10, false);
    }

    @Override
    public final void setMediaItem(MediaItem mediaItem, long j10) {
        setMediaItems(AbstractC2301u1.m5275r(mediaItem), 0, j10);
    }

    @Override
    public final void seekToDefaultPosition(int i6) {
        seekToDefaultPositionInternal(i6, 10);
    }

    @Override
    public final void setMediaItem(MediaItem mediaItem, boolean z7) {
        setMediaItems(AbstractC2301u1.m5275r(mediaItem), z7);
    }
}

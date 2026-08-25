package androidx.media3.p011ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.media3.common.AbstractC0602k;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C0565C;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.TrackSelectionOverride;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.RepeatModeUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.recyclerview.widget.AbstractC1158k0;
import androidx.recyclerview.widget.AbstractC1174p1;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import p041d7.AbstractC2182d0;
import p041d7.AbstractC2267p1;
import p041d7.AbstractC2301u1;
import p041d7.C2180c5;
import p041d7.C2204g1;

@UnstableApi
public class PlayerControlView extends FrameLayout {
    public static final int DEFAULT_REPEAT_TOGGLE_MODES = 0;
    public static final int DEFAULT_SHOW_TIMEOUT_MS = 5000;
    public static final int DEFAULT_TIME_BAR_MIN_UPDATE_INTERVAL_MS = 200;
    private static final int MAX_UPDATE_INTERVAL_MS = 1000;
    public static final int MAX_WINDOWS_FOR_MULTI_WINDOW_TIME_BAR = 100;
    private static final float[] PLAYBACK_SPEEDS;
    private static final int SETTINGS_AUDIO_TRACK_SELECTION_POSITION = 1;
    private static final int SETTINGS_PLAYBACK_SPEED_POSITION = 0;
    private long[] adGroupTimesMs;
    private final View audioTrackButton;
    private final AudioTrackSelectionAdapter audioTrackSelectionAdapter;
    private final float buttonAlphaDisabled;
    private final float buttonAlphaEnabled;
    private final ComponentListener componentListener;
    private final PlayerControlViewLayoutManager controlViewLayoutManager;
    private long currentWindowOffset;
    private final TextView durationView;
    private long[] extraAdGroupTimesMs;
    private boolean[] extraPlayedAdGroups;
    private final View fastForwardButton;
    private final TextView fastForwardButtonTextView;
    private final StringBuilder formatBuilder;
    private final Formatter formatter;
    private final ImageView fullscreenButton;
    private final String fullscreenEnterContentDescription;
    private final Drawable fullscreenEnterDrawable;
    private final String fullscreenExitContentDescription;
    private final Drawable fullscreenExitDrawable;
    private boolean isAttachedToWindow;
    private boolean isFullscreen;
    private final ImageView minimalFullscreenButton;
    private boolean multiWindowTimeBar;
    private boolean needToHideBars;
    private final ImageView nextButton;
    private OnFullScreenModeChangedListener onFullScreenModeChangedListener;
    private final Drawable pauseButtonDrawable;
    private final Timeline.Period period;
    private final Drawable playButtonDrawable;
    private final ImageView playPauseButton;
    private final PlaybackSpeedAdapter playbackSpeedAdapter;
    private final View playbackSpeedButton;
    private boolean[] playedAdGroups;
    private Player player;
    private final TextView positionView;
    private final ImageView previousButton;
    private ProgressUpdateListener progressUpdateListener;
    private final String repeatAllButtonContentDescription;
    private final Drawable repeatAllButtonDrawable;
    private final String repeatOffButtonContentDescription;
    private final Drawable repeatOffButtonDrawable;
    private final String repeatOneButtonContentDescription;
    private final Drawable repeatOneButtonDrawable;
    private final ImageView repeatToggleButton;
    private int repeatToggleModes;
    private final Resources resources;
    private final View rewindButton;
    private final TextView rewindButtonTextView;
    private boolean scrubbing;
    private final SettingsAdapter settingsAdapter;
    private final View settingsButton;
    private final RecyclerView settingsView;
    private final PopupWindow settingsWindow;
    private final int settingsWindowMargin;
    private boolean showMultiWindowTimeBar;
    private boolean showPlayButtonIfSuppressed;
    private int showTimeoutMs;
    private final ImageView shuffleButton;
    private final Drawable shuffleOffButtonDrawable;
    private final String shuffleOffContentDescription;
    private final Drawable shuffleOnButtonDrawable;
    private final String shuffleOnContentDescription;
    private final ImageView subtitleButton;
    private final Drawable subtitleOffButtonDrawable;
    private final String subtitleOffContentDescription;
    private final Drawable subtitleOnButtonDrawable;
    private final String subtitleOnContentDescription;
    private final TextTrackSelectionAdapter textTrackSelectionAdapter;
    private final TimeBar timeBar;
    private int timeBarMinUpdateIntervalMs;
    private final TrackNameProvider trackNameProvider;
    private final Runnable updateProgressAction;
    private final CopyOnWriteArrayList<VisibilityListener> visibilityListeners;
    private final ImageView vrButton;
    private final Timeline.Window window;

    public final class AudioTrackSelectionAdapter extends TrackSelectionAdapter {
        private AudioTrackSelectionAdapter() {
            super();
        }

        private boolean hasSelectionOverride(TrackSelectionParameters trackSelectionParameters) {
            for (int i6 = 0; i6 < this.tracks.size(); i6++) {
                if (trackSelectionParameters.overrides.containsKey(this.tracks.get(i6).trackGroup.getMediaTrackGroup())) {
                    return true;
                }
            }
            return false;
        }

        public void lambda$onBindViewHolderAtZeroPosition$0(View view) {
            if (PlayerControlView.this.player == null || !PlayerControlView.this.player.isCommandAvailable(29)) {
                return;
            }
            ((Player) Util.castNonNull(PlayerControlView.this.player)).setTrackSelectionParameters(PlayerControlView.this.player.getTrackSelectionParameters().buildUpon().clearOverridesOfType(1).setTrackTypeDisabled(1, false).build());
            PlayerControlView.this.settingsAdapter.setSubTextAtPosition(1, PlayerControlView.this.getResources().getString(C1051R.string.exo_track_selection_auto));
            PlayerControlView.this.settingsWindow.dismiss();
        }

        @Override
        public void init(List<TrackInformation> list) {
            this.tracks = list;
            TrackSelectionParameters trackSelectionParameters = ((Player) Assertions.checkNotNull(PlayerControlView.this.player)).getTrackSelectionParameters();
            if (list.isEmpty()) {
                PlayerControlView.this.settingsAdapter.setSubTextAtPosition(1, PlayerControlView.this.getResources().getString(C1051R.string.exo_track_selection_none));
                return;
            }
            if (!hasSelectionOverride(trackSelectionParameters)) {
                PlayerControlView.this.settingsAdapter.setSubTextAtPosition(1, PlayerControlView.this.getResources().getString(C1051R.string.exo_track_selection_auto));
                return;
            }
            for (int i6 = 0; i6 < list.size(); i6++) {
                TrackInformation trackInformation = list.get(i6);
                if (trackInformation.isSelected()) {
                    PlayerControlView.this.settingsAdapter.setSubTextAtPosition(1, trackInformation.trackName);
                    return;
                }
            }
        }

        @Override
        public void onBindViewHolderAtZeroPosition(SubSettingViewHolder subSettingViewHolder) {
            subSettingViewHolder.textView.setText(C1051R.string.exo_track_selection_auto);
            subSettingViewHolder.checkView.setVisibility(hasSelectionOverride(((Player) Assertions.checkNotNull(PlayerControlView.this.player)).getTrackSelectionParameters()) ? 4 : 0);
            subSettingViewHolder.itemView.setOnClickListener(new ViewOnClickListenerC1058c(0, this));
        }

        @Override
        public void onTrackSelection(String str) {
            PlayerControlView.this.settingsAdapter.setSubTextAtPosition(1, str);
        }
    }

    public final class ComponentListener implements Player.Listener, TimeBar.OnScrubListener, View.OnClickListener, PopupWindow.OnDismissListener {
        private ComponentListener() {
        }

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
        public void onClick(View view) {
            Player player = PlayerControlView.this.player;
            if (player == null) {
                return;
            }
            PlayerControlView.this.controlViewLayoutManager.resetHideCallbacks();
            if (PlayerControlView.this.nextButton == view) {
                if (player.isCommandAvailable(9)) {
                    player.seekToNext();
                    return;
                }
                return;
            }
            if (PlayerControlView.this.previousButton == view) {
                if (player.isCommandAvailable(7)) {
                    player.seekToPrevious();
                    return;
                }
                return;
            }
            if (PlayerControlView.this.fastForwardButton == view) {
                if (player.getPlaybackState() == 4 || !player.isCommandAvailable(12)) {
                    return;
                }
                player.seekForward();
                return;
            }
            if (PlayerControlView.this.rewindButton == view) {
                if (player.isCommandAvailable(11)) {
                    player.seekBack();
                    return;
                }
                return;
            }
            if (PlayerControlView.this.playPauseButton == view) {
                Util.handlePlayPauseButtonAction(player, PlayerControlView.this.showPlayButtonIfSuppressed);
                return;
            }
            if (PlayerControlView.this.repeatToggleButton == view) {
                if (player.isCommandAvailable(15)) {
                    player.setRepeatMode(RepeatModeUtil.getNextRepeatMode(player.getRepeatMode(), PlayerControlView.this.repeatToggleModes));
                    return;
                }
                return;
            }
            if (PlayerControlView.this.shuffleButton == view) {
                if (player.isCommandAvailable(14)) {
                    player.setShuffleModeEnabled(!player.getShuffleModeEnabled());
                    return;
                }
                return;
            }
            if (PlayerControlView.this.settingsButton == view) {
                PlayerControlView.this.controlViewLayoutManager.removeHideCallbacks();
                PlayerControlView playerControlView = PlayerControlView.this;
                playerControlView.displaySettingsWindow(playerControlView.settingsAdapter, PlayerControlView.this.settingsButton);
                return;
            }
            if (PlayerControlView.this.playbackSpeedButton == view) {
                PlayerControlView.this.controlViewLayoutManager.removeHideCallbacks();
                PlayerControlView playerControlView2 = PlayerControlView.this;
                playerControlView2.displaySettingsWindow(playerControlView2.playbackSpeedAdapter, PlayerControlView.this.playbackSpeedButton);
            } else if (PlayerControlView.this.audioTrackButton == view) {
                PlayerControlView.this.controlViewLayoutManager.removeHideCallbacks();
                PlayerControlView playerControlView3 = PlayerControlView.this;
                playerControlView3.displaySettingsWindow(playerControlView3.audioTrackSelectionAdapter, PlayerControlView.this.audioTrackButton);
            } else if (PlayerControlView.this.subtitleButton == view) {
                PlayerControlView.this.controlViewLayoutManager.removeHideCallbacks();
                PlayerControlView playerControlView4 = PlayerControlView.this;
                playerControlView4.displaySettingsWindow(playerControlView4.textTrackSelectionAdapter, PlayerControlView.this.subtitleButton);
            }
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
        public void onDismiss() {
            if (PlayerControlView.this.needToHideBars) {
                PlayerControlView.this.controlViewLayoutManager.resetHideCallbacks();
            }
        }

        @Override
        public void onEvents(Player player, Player.Events events) {
            if (events.containsAny(4, 5, 13)) {
                PlayerControlView.this.updatePlayPauseButton();
            }
            if (events.containsAny(4, 5, 7, 13)) {
                PlayerControlView.this.updateProgress();
            }
            if (events.containsAny(8, 13)) {
                PlayerControlView.this.updateRepeatModeButton();
            }
            if (events.containsAny(9, 13)) {
                PlayerControlView.this.updateShuffleButton();
            }
            if (events.containsAny(8, 9, 11, 0, 16, 17, 13)) {
                PlayerControlView.this.updateNavigation();
            }
            if (events.containsAny(11, 0, 13)) {
                PlayerControlView.this.updateTimeline();
            }
            if (events.containsAny(12, 13)) {
                PlayerControlView.this.updatePlaybackSpeedList();
            }
            if (events.containsAny(2, 13)) {
                PlayerControlView.this.updateTrackLists();
            }
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
        public final void onMetadata(Metadata metadata) {
            AbstractC0602k.m1696o(this, metadata);
        }

        @Override
        public final void onPlayWhenReadyChanged(boolean z7, int i6) {
            AbstractC0602k.m1697p(this, z7, i6);
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
        public final void onRenderedFirstFrame() {
            AbstractC0602k.m1707z(this);
        }

        @Override
        public final void onRepeatModeChanged(int i6) {
            AbstractC0602k.m1671A(this, i6);
        }

        @Override
        public void onScrubMove(TimeBar timeBar, long j10) {
            if (PlayerControlView.this.positionView != null) {
                PlayerControlView.this.positionView.setText(Util.getStringForTime(PlayerControlView.this.formatBuilder, PlayerControlView.this.formatter, j10));
            }
        }

        @Override
        public void onScrubStart(TimeBar timeBar, long j10) {
            PlayerControlView.this.scrubbing = true;
            if (PlayerControlView.this.positionView != null) {
                PlayerControlView.this.positionView.setText(Util.getStringForTime(PlayerControlView.this.formatBuilder, PlayerControlView.this.formatter, j10));
            }
            PlayerControlView.this.controlViewLayoutManager.removeHideCallbacks();
        }

        @Override
        public void onScrubStop(TimeBar timeBar, long j10, boolean z7) {
            PlayerControlView.this.scrubbing = false;
            if (!z7 && PlayerControlView.this.player != null) {
                PlayerControlView playerControlView = PlayerControlView.this;
                playerControlView.seekToTimeBarPosition(playerControlView.player, j10);
            }
            PlayerControlView.this.controlViewLayoutManager.resetHideCallbacks();
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
        public final void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i6) {
            AbstractC0602k.m1706y(this, positionInfo, positionInfo2, i6);
        }
    }

    @Deprecated
    public interface OnFullScreenModeChangedListener {
        void onFullScreenModeChanged(boolean z7);
    }

    public final class PlaybackSpeedAdapter extends AbstractC1158k0 {
        private final String[] playbackSpeedTexts;
        private final float[] playbackSpeeds;
        private int selectedIndex;

        public PlaybackSpeedAdapter(String[] strArr, float[] fArr) {
            this.playbackSpeedTexts = strArr;
            this.playbackSpeeds = fArr;
        }

        public void lambda$onBindViewHolder$0(int i6, View view) {
            if (i6 != this.selectedIndex) {
                PlayerControlView.this.setPlaybackSpeed(this.playbackSpeeds[i6]);
            }
            PlayerControlView.this.settingsWindow.dismiss();
        }

        @Override
        public int getItemCount() {
            return this.playbackSpeedTexts.length;
        }

        public String getSelectedText() {
            return this.playbackSpeedTexts[this.selectedIndex];
        }

        public void updateSelectedIndex(float f) {
            int i6 = 0;
            int i10 = 0;
            float f3 = Float.MAX_VALUE;
            while (true) {
                float[] fArr = this.playbackSpeeds;
                if (i6 >= fArr.length) {
                    this.selectedIndex = i10;
                    return;
                }
                float fAbs = Math.abs(f - fArr[i6]);
                if (fAbs < f3) {
                    i10 = i6;
                    f3 = fAbs;
                }
                i6++;
            }
        }

        @Override
        public void onBindViewHolder(SubSettingViewHolder subSettingViewHolder, final int i6) {
            String[] strArr = this.playbackSpeedTexts;
            if (i6 < strArr.length) {
                subSettingViewHolder.textView.setText(strArr[i6]);
            }
            if (i6 == this.selectedIndex) {
                subSettingViewHolder.itemView.setSelected(true);
                subSettingViewHolder.checkView.setVisibility(0);
            } else {
                subSettingViewHolder.itemView.setSelected(false);
                subSettingViewHolder.checkView.setVisibility(4);
            }
            subSettingViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    this.f3121a.lambda$onBindViewHolder$0(i6, view);
                }
            });
        }

        @Override
        public SubSettingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i6) {
            return new SubSettingViewHolder(LayoutInflater.from(PlayerControlView.this.getContext()).inflate(C1051R.layout.exo_styled_sub_settings_list_item, viewGroup, false));
        }
    }

    public interface ProgressUpdateListener {
        void onProgressUpdate(long j10, long j11);
    }

    public final class SettingViewHolder extends AbstractC1174p1 {
        private final ImageView iconView;
        private final TextView mainTextView;
        private final TextView subTextView;

        public SettingViewHolder(View view) {
            super(view);
            if (Util.SDK_INT < 26) {
                view.setFocusable(true);
            }
            this.mainTextView = (TextView) view.findViewById(C1051R.id.exo_main_text);
            this.subTextView = (TextView) view.findViewById(C1051R.id.exo_sub_text);
            this.iconView = (ImageView) view.findViewById(C1051R.id.exo_icon);
            view.setOnClickListener(new ViewOnClickListenerC1058c(1, this));
        }

        public void lambda$new$0(View view) {
            PlayerControlView.this.onSettingViewClicked(getBindingAdapterPosition());
        }
    }

    public class SettingsAdapter extends AbstractC1158k0 {
        private final Drawable[] iconIds;
        private final String[] mainTexts;
        private final String[] subTexts;

        public SettingsAdapter(String[] strArr, Drawable[] drawableArr) {
            this.mainTexts = strArr;
            this.subTexts = new String[strArr.length];
            this.iconIds = drawableArr;
        }

        private boolean shouldShowSetting(int i6) {
            if (PlayerControlView.this.player == null) {
                return false;
            }
            if (i6 == 0) {
                return PlayerControlView.this.player.isCommandAvailable(13);
            }
            if (i6 != 1) {
                return true;
            }
            return PlayerControlView.this.player.isCommandAvailable(30) && PlayerControlView.this.player.isCommandAvailable(29);
        }

        @Override
        public int getItemCount() {
            return this.mainTexts.length;
        }

        @Override
        public long getItemId(int i6) {
            return i6;
        }

        public boolean hasSettingsToShow() {
            return shouldShowSetting(1) || shouldShowSetting(0);
        }

        public void setSubTextAtPosition(int i6, String str) {
            this.subTexts[i6] = str;
        }

        @Override
        public void onBindViewHolder(SettingViewHolder settingViewHolder, int i6) {
            if (shouldShowSetting(i6)) {
                settingViewHolder.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                settingViewHolder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
            }
            settingViewHolder.mainTextView.setText(this.mainTexts[i6]);
            if (this.subTexts[i6] == null) {
                settingViewHolder.subTextView.setVisibility(8);
            } else {
                settingViewHolder.subTextView.setText(this.subTexts[i6]);
            }
            if (this.iconIds[i6] == null) {
                settingViewHolder.iconView.setVisibility(8);
            } else {
                settingViewHolder.iconView.setImageDrawable(this.iconIds[i6]);
            }
        }

        @Override
        public SettingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i6) {
            return PlayerControlView.this.new SettingViewHolder(LayoutInflater.from(PlayerControlView.this.getContext()).inflate(C1051R.layout.exo_styled_settings_list_item, viewGroup, false));
        }
    }

    public static class SubSettingViewHolder extends AbstractC1174p1 {
        public final View checkView;
        public final TextView textView;

        public SubSettingViewHolder(View view) {
            super(view);
            if (Util.SDK_INT < 26) {
                view.setFocusable(true);
            }
            this.textView = (TextView) view.findViewById(C1051R.id.exo_text);
            this.checkView = view.findViewById(C1051R.id.exo_check);
        }
    }

    public final class TextTrackSelectionAdapter extends TrackSelectionAdapter {
        private TextTrackSelectionAdapter() {
            super();
        }

        public void lambda$onBindViewHolderAtZeroPosition$0(View view) {
            if (PlayerControlView.this.player == null || !PlayerControlView.this.player.isCommandAvailable(29)) {
                return;
            }
            PlayerControlView.this.player.setTrackSelectionParameters(PlayerControlView.this.player.getTrackSelectionParameters().buildUpon().clearOverridesOfType(3).setIgnoredTextSelectionFlags(-3).setPreferredTextLanguage(null).setPreferredTextRoleFlags(0).build());
            PlayerControlView.this.settingsWindow.dismiss();
        }

        @Override
        public void init(List<TrackInformation> list) {
            boolean z7 = false;
            for (int i6 = 0; i6 < list.size(); i6++) {
                if (list.get(i6).isSelected()) {
                    z7 = true;
                    break;
                }
            }
            if (PlayerControlView.this.subtitleButton != null) {
                ImageView imageView = PlayerControlView.this.subtitleButton;
                PlayerControlView playerControlView = PlayerControlView.this;
                imageView.setImageDrawable(z7 ? playerControlView.subtitleOnButtonDrawable : playerControlView.subtitleOffButtonDrawable);
                PlayerControlView.this.subtitleButton.setContentDescription(z7 ? PlayerControlView.this.subtitleOnContentDescription : PlayerControlView.this.subtitleOffContentDescription);
            }
            this.tracks = list;
        }

        @Override
        public void onBindViewHolderAtZeroPosition(SubSettingViewHolder subSettingViewHolder) {
            boolean z7;
            subSettingViewHolder.textView.setText(C1051R.string.exo_track_selection_none);
            int i6 = 0;
            while (true) {
                if (i6 >= this.tracks.size()) {
                    z7 = true;
                    break;
                } else {
                    if (this.tracks.get(i6).isSelected()) {
                        z7 = false;
                        break;
                    }
                    i6++;
                }
            }
            subSettingViewHolder.checkView.setVisibility(z7 ? 0 : 4);
            subSettingViewHolder.itemView.setOnClickListener(new ViewOnClickListenerC1058c(2, this));
        }

        @Override
        public void onBindViewHolder(SubSettingViewHolder subSettingViewHolder, int i6) {
            super.onBindViewHolder(subSettingViewHolder, i6);
            if (i6 > 0) {
                subSettingViewHolder.checkView.setVisibility(this.tracks.get(i6 + (-1)).isSelected() ? 0 : 4);
            }
        }

        @Override
        public void onTrackSelection(String str) {
        }
    }

    public static final class TrackInformation {
        public final Tracks.Group trackGroup;
        public final int trackIndex;
        public final String trackName;

        public TrackInformation(Tracks tracks, int i6, int i10, String str) {
            this.trackGroup = (Tracks.Group) tracks.getGroups().get(i6);
            this.trackIndex = i10;
            this.trackName = str;
        }

        public boolean isSelected() {
            return this.trackGroup.isTrackSelected(this.trackIndex);
        }
    }

    public abstract class TrackSelectionAdapter extends AbstractC1158k0 {
        protected List<TrackInformation> tracks = new ArrayList();

        public TrackSelectionAdapter() {
        }

        public void lambda$onBindViewHolder$0(Player player, TrackGroup trackGroup, TrackInformation trackInformation, View view) {
            if (player.isCommandAvailable(29)) {
                player.setTrackSelectionParameters(player.getTrackSelectionParameters().buildUpon().setOverrideForType(new TrackSelectionOverride(trackGroup, AbstractC2301u1.m5275r(Integer.valueOf(trackInformation.trackIndex)))).setTrackTypeDisabled(trackInformation.trackGroup.getType(), false).build());
                onTrackSelection(trackInformation.trackName);
                PlayerControlView.this.settingsWindow.dismiss();
            }
        }

        public void clear() {
            this.tracks = Collections.emptyList();
        }

        @Override
        public int getItemCount() {
            if (this.tracks.isEmpty()) {
                return 0;
            }
            return this.tracks.size() + 1;
        }

        public abstract void init(List<TrackInformation> list);

        public abstract void onBindViewHolderAtZeroPosition(SubSettingViewHolder subSettingViewHolder);

        public abstract void onTrackSelection(String str);

        @Override
        public void onBindViewHolder(SubSettingViewHolder subSettingViewHolder, int i6) {
            final Player player = PlayerControlView.this.player;
            if (player == null) {
                return;
            }
            if (i6 == 0) {
                onBindViewHolderAtZeroPosition(subSettingViewHolder);
                return;
            }
            final TrackInformation trackInformation = this.tracks.get(i6 - 1);
            final TrackGroup mediaTrackGroup = trackInformation.trackGroup.getMediaTrackGroup();
            boolean z7 = player.getTrackSelectionParameters().overrides.get(mediaTrackGroup) != null && trackInformation.isSelected();
            subSettingViewHolder.textView.setText(trackInformation.trackName);
            subSettingViewHolder.checkView.setVisibility(z7 ? 0 : 4);
            subSettingViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    PlayerControlView.TrackInformation trackInformation2 = trackInformation;
                    this.f3123a.lambda$onBindViewHolder$0(player, mediaTrackGroup, trackInformation2, view);
                }
            });
        }

        @Override
        public SubSettingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i6) {
            return new SubSettingViewHolder(LayoutInflater.from(PlayerControlView.this.getContext()).inflate(C1051R.layout.exo_styled_sub_settings_list_item, viewGroup, false));
        }
    }

    @Deprecated
    public interface VisibilityListener {
        void onVisibilityChange(int i6);
    }

    static {
        MediaLibraryInfo.registerModule("media3.ui");
        PLAYBACK_SPEEDS = new float[]{0.25f, 0.5f, 0.75f, 1.0f, 1.25f, 1.5f, 2.0f};
    }

    public PlayerControlView(Context context) {
        this(context, null);
    }

    private static boolean canShowMultiWindowTimeBar(Player player, Timeline.Window window) {
        Timeline currentTimeline;
        int windowCount;
        if (!player.isCommandAvailable(17) || (windowCount = (currentTimeline = player.getCurrentTimeline()).getWindowCount()) <= 1 || windowCount > 100) {
            return false;
        }
        for (int i6 = 0; i6 < windowCount; i6++) {
            if (currentTimeline.getWindow(i6, window).durationUs == C0565C.TIME_UNSET) {
                return false;
            }
        }
        return true;
    }

    public void displaySettingsWindow(AbstractC1158k0 abstractC1158k0, View view) {
        this.settingsView.setAdapter(abstractC1158k0);
        updateSettingsWindowSize();
        this.needToHideBars = false;
        this.settingsWindow.dismiss();
        this.needToHideBars = true;
        this.settingsWindow.showAsDropDown(view, (getWidth() - this.settingsWindow.getWidth()) - this.settingsWindowMargin, (-this.settingsWindow.getHeight()) - this.settingsWindowMargin);
    }

    private AbstractC2301u1 gatherSupportedTrackInfosOfType(Tracks tracks, int i6) {
        AbstractC2182d0.m5141d(4, "initialCapacity");
        Object[] objArrCopyOf = new Object[4];
        AbstractC2301u1 groups = tracks.getGroups();
        int i10 = 0;
        for (int i11 = 0; i11 < groups.size(); i11++) {
            Tracks.Group group = (Tracks.Group) groups.get(i11);
            if (group.getType() == i6) {
                for (int i12 = 0; i12 < group.length; i12++) {
                    if (group.isTrackSupported(i12)) {
                        Format trackFormat = group.getTrackFormat(i12);
                        if ((trackFormat.selectionFlags & 2) == 0) {
                            TrackInformation trackInformation = new TrackInformation(tracks, i11, i12, this.trackNameProvider.getTrackName(trackFormat));
                            int i13 = i10 + 1;
                            int iM5254f = AbstractC2267p1.m5254f(objArrCopyOf.length, i13);
                            if (iM5254f > objArrCopyOf.length) {
                                objArrCopyOf = Arrays.copyOf(objArrCopyOf, iM5254f);
                            }
                            objArrCopyOf[i10] = trackInformation;
                            i10 = i13;
                        }
                    }
                }
            }
        }
        return AbstractC2301u1.m5268j(objArrCopyOf, i10);
    }

    private void initTrackSelectionAdapter() {
        this.textTrackSelectionAdapter.clear();
        this.audioTrackSelectionAdapter.clear();
        Player player = this.player;
        if (player != null && player.isCommandAvailable(30) && this.player.isCommandAvailable(29)) {
            Tracks currentTracks = this.player.getCurrentTracks();
            this.audioTrackSelectionAdapter.init(gatherSupportedTrackInfosOfType(currentTracks, 1));
            if (this.controlViewLayoutManager.getShowButton(this.subtitleButton)) {
                this.textTrackSelectionAdapter.init(gatherSupportedTrackInfosOfType(currentTracks, 3));
                return;
            }
            TextTrackSelectionAdapter textTrackSelectionAdapter = this.textTrackSelectionAdapter;
            C2204g1 c2204g1 = AbstractC2301u1.f8069b;
            textTrackSelectionAdapter.init(C2180c5.f7862e);
        }
    }

    private static void initializeFullscreenButton(View view, View.OnClickListener onClickListener) {
        if (view == null) {
            return;
        }
        view.setVisibility(8);
        view.setOnClickListener(onClickListener);
    }

    @SuppressLint({"InlinedApi"})
    private static boolean isHandledMediaKey(int i6) {
        return i6 == 90 || i6 == 89 || i6 == 85 || i6 == 79 || i6 == 126 || i6 == 127 || i6 == 87 || i6 == 88;
    }

    public void onFullscreenButtonClicked(View view) {
        updateIsFullscreen(!this.isFullscreen);
    }

    public void onLayoutChange(View view, int i6, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        int i17 = i12 - i10;
        int i18 = i16 - i14;
        if (!(i11 - i6 == i15 - i13 && i17 == i18) && this.settingsWindow.isShowing()) {
            updateSettingsWindowSize();
            this.settingsWindow.update(view, (getWidth() - this.settingsWindow.getWidth()) - this.settingsWindowMargin, (-this.settingsWindow.getHeight()) - this.settingsWindowMargin, -1, -1);
        }
    }

    public void onSettingViewClicked(int i6) {
        if (i6 == 0) {
            displaySettingsWindow(this.playbackSpeedAdapter, (View) Assertions.checkNotNull(this.settingsButton));
        } else if (i6 == 1) {
            displaySettingsWindow(this.audioTrackSelectionAdapter, (View) Assertions.checkNotNull(this.settingsButton));
        } else {
            this.settingsWindow.dismiss();
        }
    }

    public void seekToTimeBarPosition(Player player, long j10) {
        if (this.multiWindowTimeBar) {
            if (player.isCommandAvailable(17) && player.isCommandAvailable(10)) {
                Timeline currentTimeline = player.getCurrentTimeline();
                int windowCount = currentTimeline.getWindowCount();
                int i6 = 0;
                while (true) {
                    long durationMs = currentTimeline.getWindow(i6, this.window).getDurationMs();
                    if (j10 < durationMs) {
                        break;
                    }
                    if (i6 == windowCount - 1) {
                        j10 = durationMs;
                        break;
                    } else {
                        j10 -= durationMs;
                        i6++;
                    }
                }
                player.seekTo(i6, j10);
            }
        } else if (player.isCommandAvailable(5)) {
            player.seekTo(j10);
        }
        updateProgress();
    }

    public void setPlaybackSpeed(float f) {
        Player player = this.player;
        if (player == null || !player.isCommandAvailable(13)) {
            return;
        }
        Player player2 = this.player;
        player2.setPlaybackParameters(player2.getPlaybackParameters().withSpeed(f));
    }

    private void updateButton(boolean z7, View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z7);
        view.setAlpha(z7 ? this.buttonAlphaEnabled : this.buttonAlphaDisabled);
    }

    private void updateFastForwardButton() {
        Player player = this.player;
        int seekForwardIncrement = (int) ((player != null ? player.getSeekForwardIncrement() : C0565C.DEFAULT_SEEK_FORWARD_INCREMENT_MS) / 1000);
        TextView textView = this.fastForwardButtonTextView;
        if (textView != null) {
            textView.setText(String.valueOf(seekForwardIncrement));
        }
        View view = this.fastForwardButton;
        if (view != null) {
            view.setContentDescription(this.resources.getQuantityString(C1051R.plurals.exo_controls_fastforward_by_amount_description, seekForwardIncrement, Integer.valueOf(seekForwardIncrement)));
        }
    }

    private void updateFullscreenButtonForState(ImageView imageView, boolean z7) {
        if (imageView == null) {
            return;
        }
        if (z7) {
            imageView.setImageDrawable(this.fullscreenExitDrawable);
            imageView.setContentDescription(this.fullscreenExitContentDescription);
        } else {
            imageView.setImageDrawable(this.fullscreenEnterDrawable);
            imageView.setContentDescription(this.fullscreenEnterContentDescription);
        }
    }

    private static void updateFullscreenButtonVisibility(View view, boolean z7) {
        if (view == null) {
            return;
        }
        if (z7) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public void updateNavigation() {
        boolean zIsCommandAvailable;
        boolean zIsCommandAvailable2;
        boolean zIsCommandAvailable3;
        boolean zIsCommandAvailable4;
        boolean zIsCommandAvailable5;
        if (isVisible() && this.isAttachedToWindow) {
            Player player = this.player;
            if (player != null) {
                zIsCommandAvailable = (this.showMultiWindowTimeBar && canShowMultiWindowTimeBar(player, this.window)) ? player.isCommandAvailable(10) : player.isCommandAvailable(5);
                zIsCommandAvailable3 = player.isCommandAvailable(7);
                zIsCommandAvailable4 = player.isCommandAvailable(11);
                zIsCommandAvailable5 = player.isCommandAvailable(12);
                zIsCommandAvailable2 = player.isCommandAvailable(9);
            } else {
                zIsCommandAvailable = false;
                zIsCommandAvailable2 = false;
                zIsCommandAvailable3 = false;
                zIsCommandAvailable4 = false;
                zIsCommandAvailable5 = false;
            }
            if (zIsCommandAvailable4) {
                updateRewindButton();
            }
            if (zIsCommandAvailable5) {
                updateFastForwardButton();
            }
            updateButton(zIsCommandAvailable3, this.previousButton);
            updateButton(zIsCommandAvailable4, this.rewindButton);
            updateButton(zIsCommandAvailable5, this.fastForwardButton);
            updateButton(zIsCommandAvailable2, this.nextButton);
            TimeBar timeBar = this.timeBar;
            if (timeBar != null) {
                timeBar.setEnabled(zIsCommandAvailable);
            }
        }
    }

    public void updatePlayPauseButton() {
        if (isVisible() && this.isAttachedToWindow && this.playPauseButton != null) {
            boolean zShouldShowPlayButton = Util.shouldShowPlayButton(this.player, this.showPlayButtonIfSuppressed);
            Drawable drawable = zShouldShowPlayButton ? this.playButtonDrawable : this.pauseButtonDrawable;
            int i6 = zShouldShowPlayButton ? C1051R.string.exo_controls_play_description : C1051R.string.exo_controls_pause_description;
            this.playPauseButton.setImageDrawable(drawable);
            this.playPauseButton.setContentDescription(this.resources.getString(i6));
            updateButton(Util.shouldEnablePlayPauseButton(this.player), this.playPauseButton);
        }
    }

    public void updatePlaybackSpeedList() {
        Player player = this.player;
        if (player == null) {
            return;
        }
        this.playbackSpeedAdapter.updateSelectedIndex(player.getPlaybackParameters().speed);
        this.settingsAdapter.setSubTextAtPosition(0, this.playbackSpeedAdapter.getSelectedText());
        updateSettingsButton();
    }

    public void updateProgress() {
        long contentPosition;
        long contentBufferedPosition;
        if (isVisible() && this.isAttachedToWindow) {
            Player player = this.player;
            if (player == null || !player.isCommandAvailable(16)) {
                contentPosition = 0;
                contentBufferedPosition = 0;
            } else {
                contentPosition = player.getContentPosition() + this.currentWindowOffset;
                contentBufferedPosition = player.getContentBufferedPosition() + this.currentWindowOffset;
            }
            TextView textView = this.positionView;
            if (textView != null && !this.scrubbing) {
                textView.setText(Util.getStringForTime(this.formatBuilder, this.formatter, contentPosition));
            }
            TimeBar timeBar = this.timeBar;
            if (timeBar != null) {
                timeBar.setPosition(contentPosition);
                this.timeBar.setBufferedPosition(contentBufferedPosition);
            }
            ProgressUpdateListener progressUpdateListener = this.progressUpdateListener;
            if (progressUpdateListener != null) {
                progressUpdateListener.onProgressUpdate(contentPosition, contentBufferedPosition);
            }
            removeCallbacks(this.updateProgressAction);
            int playbackState = player == null ? 1 : player.getPlaybackState();
            if (player == null || !player.isPlaying()) {
                if (playbackState == 4 || playbackState == 1) {
                    return;
                }
                postDelayed(this.updateProgressAction, 1000L);
                return;
            }
            TimeBar timeBar2 = this.timeBar;
            long jMin = Math.min(timeBar2 != null ? timeBar2.getPreferredUpdateDelay() : 1000L, 1000 - (contentPosition % 1000));
            float f = player.getPlaybackParameters().speed;
            postDelayed(this.updateProgressAction, Util.constrainValue(f > 0.0f ? (long) (jMin / f) : 1000L, this.timeBarMinUpdateIntervalMs, 1000L));
        }
    }

    public void updateRepeatModeButton() {
        ImageView imageView;
        if (isVisible() && this.isAttachedToWindow && (imageView = this.repeatToggleButton) != null) {
            if (this.repeatToggleModes == 0) {
                updateButton(false, imageView);
                return;
            }
            Player player = this.player;
            if (player == null || !player.isCommandAvailable(15)) {
                updateButton(false, this.repeatToggleButton);
                this.repeatToggleButton.setImageDrawable(this.repeatOffButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatOffButtonContentDescription);
                return;
            }
            updateButton(true, this.repeatToggleButton);
            int repeatMode = player.getRepeatMode();
            if (repeatMode == 0) {
                this.repeatToggleButton.setImageDrawable(this.repeatOffButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatOffButtonContentDescription);
            } else if (repeatMode == 1) {
                this.repeatToggleButton.setImageDrawable(this.repeatOneButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatOneButtonContentDescription);
            } else {
                if (repeatMode != 2) {
                    return;
                }
                this.repeatToggleButton.setImageDrawable(this.repeatAllButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatAllButtonContentDescription);
            }
        }
    }

    private void updateRewindButton() {
        Player player = this.player;
        int seekBackIncrement = (int) ((player != null ? player.getSeekBackIncrement() : 5000L) / 1000);
        TextView textView = this.rewindButtonTextView;
        if (textView != null) {
            textView.setText(String.valueOf(seekBackIncrement));
        }
        View view = this.rewindButton;
        if (view != null) {
            view.setContentDescription(this.resources.getQuantityString(C1051R.plurals.exo_controls_rewind_by_amount_description, seekBackIncrement, Integer.valueOf(seekBackIncrement)));
        }
    }

    private void updateSettingsButton() {
        updateButton(this.settingsAdapter.hasSettingsToShow(), this.settingsButton);
    }

    private void updateSettingsWindowSize() {
        this.settingsView.measure(0, 0);
        this.settingsWindow.setWidth(Math.min(this.settingsView.getMeasuredWidth(), getWidth() - (this.settingsWindowMargin * 2)));
        this.settingsWindow.setHeight(Math.min(getHeight() - (this.settingsWindowMargin * 2), this.settingsView.getMeasuredHeight()));
    }

    public void updateShuffleButton() {
        ImageView imageView;
        if (isVisible() && this.isAttachedToWindow && (imageView = this.shuffleButton) != null) {
            Player player = this.player;
            if (!this.controlViewLayoutManager.getShowButton(imageView)) {
                updateButton(false, this.shuffleButton);
                return;
            }
            if (player == null || !player.isCommandAvailable(14)) {
                updateButton(false, this.shuffleButton);
                this.shuffleButton.setImageDrawable(this.shuffleOffButtonDrawable);
                this.shuffleButton.setContentDescription(this.shuffleOffContentDescription);
            } else {
                updateButton(true, this.shuffleButton);
                this.shuffleButton.setImageDrawable(player.getShuffleModeEnabled() ? this.shuffleOnButtonDrawable : this.shuffleOffButtonDrawable);
                this.shuffleButton.setContentDescription(player.getShuffleModeEnabled() ? this.shuffleOnContentDescription : this.shuffleOffContentDescription);
            }
        }
    }

    public void updateTimeline() {
        long jMsToUs;
        int i6;
        Timeline.Window window;
        long positionInWindowUs;
        long[] jArr;
        int length;
        Player player = this.player;
        if (player == null) {
            return;
        }
        boolean z7 = true;
        this.multiWindowTimeBar = this.showMultiWindowTimeBar && canShowMultiWindowTimeBar(player, this.window);
        this.currentWindowOffset = 0L;
        Timeline currentTimeline = player.isCommandAvailable(17) ? player.getCurrentTimeline() : Timeline.EMPTY;
        boolean zIsEmpty = currentTimeline.isEmpty();
        long j10 = C0565C.TIME_UNSET;
        if (zIsEmpty) {
            if (player.isCommandAvailable(16)) {
                long contentDuration = player.getContentDuration();
                if (contentDuration != C0565C.TIME_UNSET) {
                    jMsToUs = Util.msToUs(contentDuration);
                } else {
                    jMsToUs = 0;
                }
            } else {
                jMsToUs = 0;
            }
            i6 = 0;
        } else {
            int currentMediaItemIndex = player.getCurrentMediaItemIndex();
            boolean z10 = this.multiWindowTimeBar;
            int i10 = z10 ? 0 : currentMediaItemIndex;
            int windowCount = z10 ? currentTimeline.getWindowCount() - 1 : currentMediaItemIndex;
            long j11 = 0;
            i6 = 0;
            while (i10 <= windowCount) {
                if (i10 == currentMediaItemIndex) {
                    this.currentWindowOffset = Util.usToMs(j11);
                }
                currentTimeline.getWindow(i10, this.window);
                Timeline.Window window2 = this.window;
                if (window2.durationUs == j10) {
                    Assertions.checkState(this.multiWindowTimeBar ^ z7);
                    break;
                }
                int i11 = window2.firstPeriodIndex;
                while (true) {
                    window = this.window;
                    if (i11 <= window.lastPeriodIndex) {
                        currentTimeline.getPeriod(i11, this.period);
                        int removedAdGroupCount = this.period.getRemovedAdGroupCount();
                        int adGroupCount = this.period.getAdGroupCount();
                        while (removedAdGroupCount < adGroupCount) {
                            long adGroupTimeUs = this.period.getAdGroupTimeUs(removedAdGroupCount);
                            if (adGroupTimeUs == Long.MIN_VALUE) {
                                long j12 = this.period.durationUs;
                                if (j12 != j10) {
                                    adGroupTimeUs = j12;
                                    positionInWindowUs = this.period.getPositionInWindowUs() + adGroupTimeUs;
                                    if (positionInWindowUs >= 0) {
                                        jArr = this.adGroupTimesMs;
                                        if (i6 == jArr.length) {
                                            if (jArr.length == 0) {
                                                length = 1;
                                            } else {
                                                length = jArr.length * 2;
                                            }
                                            this.adGroupTimesMs = Arrays.copyOf(jArr, length);
                                            this.playedAdGroups = Arrays.copyOf(this.playedAdGroups, length);
                                        }
                                        this.adGroupTimesMs[i6] = Util.usToMs(positionInWindowUs + j11);
                                        this.playedAdGroups[i6] = this.period.hasPlayedAdGroup(removedAdGroupCount);
                                        i6++;
                                    }
                                }
                            } else {
                                positionInWindowUs = this.period.getPositionInWindowUs() + adGroupTimeUs;
                                if (positionInWindowUs >= 0) {
                                    jArr = this.adGroupTimesMs;
                                    if (i6 == jArr.length) {
                                        if (jArr.length == 0) {
                                            length = 1;
                                        } else {
                                            length = jArr.length * 2;
                                        }
                                        this.adGroupTimesMs = Arrays.copyOf(jArr, length);
                                        this.playedAdGroups = Arrays.copyOf(this.playedAdGroups, length);
                                    }
                                    this.adGroupTimesMs[i6] = Util.usToMs(positionInWindowUs + j11);
                                    this.playedAdGroups[i6] = this.period.hasPlayedAdGroup(removedAdGroupCount);
                                    i6++;
                                }
                            }
                            removedAdGroupCount++;
                            j10 = C0565C.TIME_UNSET;
                        }
                        i11++;
                        j10 = C0565C.TIME_UNSET;
                    }
                }
                j11 += window.durationUs;
                i10++;
                z7 = true;
                j10 = C0565C.TIME_UNSET;
            }
            jMsToUs = j11;
        }
        long jUsToMs = Util.usToMs(jMsToUs);
        TextView textView = this.durationView;
        if (textView != null) {
            textView.setText(Util.getStringForTime(this.formatBuilder, this.formatter, jUsToMs));
        }
        TimeBar timeBar = this.timeBar;
        if (timeBar != null) {
            timeBar.setDuration(jUsToMs);
            int length2 = this.extraAdGroupTimesMs.length;
            int i12 = i6 + length2;
            long[] jArr2 = this.adGroupTimesMs;
            if (i12 > jArr2.length) {
                this.adGroupTimesMs = Arrays.copyOf(jArr2, i12);
                this.playedAdGroups = Arrays.copyOf(this.playedAdGroups, i12);
            }
            System.arraycopy(this.extraAdGroupTimesMs, 0, this.adGroupTimesMs, i6, length2);
            System.arraycopy(this.extraPlayedAdGroups, 0, this.playedAdGroups, i6, length2);
            this.timeBar.setAdGroupTimesMs(this.adGroupTimesMs, this.playedAdGroups, i12);
        }
        updateProgress();
    }

    public void updateTrackLists() {
        initTrackSelectionAdapter();
        updateButton(this.textTrackSelectionAdapter.getItemCount() > 0, this.subtitleButton);
        updateSettingsButton();
    }

    @Deprecated
    public void addVisibilityListener(VisibilityListener visibilityListener) {
        Assertions.checkNotNull(visibilityListener);
        this.visibilityListeners.add(visibilityListener);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        Player player = this.player;
        if (player == null || !isHandledMediaKey(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (player.getPlaybackState() == 4 || !player.isCommandAvailable(12)) {
                return true;
            }
            player.seekForward();
            return true;
        }
        if (keyCode == 89 && player.isCommandAvailable(11)) {
            player.seekBack();
            return true;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            Util.handlePlayPauseButtonAction(player, this.showPlayButtonIfSuppressed);
            return true;
        }
        if (keyCode == 87) {
            if (!player.isCommandAvailable(9)) {
                return true;
            }
            player.seekToNext();
            return true;
        }
        if (keyCode == 88) {
            if (!player.isCommandAvailable(7)) {
                return true;
            }
            player.seekToPrevious();
            return true;
        }
        if (keyCode == 126) {
            Util.handlePlayButtonAction(player);
            return true;
        }
        if (keyCode != 127) {
            return true;
        }
        Util.handlePauseButtonAction(player);
        return true;
    }

    public Player getPlayer() {
        return this.player;
    }

    public int getRepeatToggleModes() {
        return this.repeatToggleModes;
    }

    public boolean getShowShuffleButton() {
        return this.controlViewLayoutManager.getShowButton(this.shuffleButton);
    }

    public boolean getShowSubtitleButton() {
        return this.controlViewLayoutManager.getShowButton(this.subtitleButton);
    }

    public int getShowTimeoutMs() {
        return this.showTimeoutMs;
    }

    public boolean getShowVrButton() {
        return this.controlViewLayoutManager.getShowButton(this.vrButton);
    }

    public void hide() {
        this.controlViewLayoutManager.hide();
    }

    public void hideImmediately() {
        this.controlViewLayoutManager.hideImmediately();
    }

    public boolean isAnimationEnabled() {
        return this.controlViewLayoutManager.isAnimationEnabled();
    }

    public boolean isFullyVisible() {
        return this.controlViewLayoutManager.isFullyVisible();
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public void notifyOnVisibilityChange() {
        Iterator<VisibilityListener> it = this.visibilityListeners.iterator();
        while (it.hasNext()) {
            it.next().onVisibilityChange(getVisibility());
        }
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.controlViewLayoutManager.onAttachedToWindow();
        this.isAttachedToWindow = true;
        if (isFullyVisible()) {
            this.controlViewLayoutManager.resetHideCallbacks();
        }
        updateAll();
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.controlViewLayoutManager.onDetachedFromWindow();
        this.isAttachedToWindow = false;
        removeCallbacks(this.updateProgressAction);
        this.controlViewLayoutManager.removeHideCallbacks();
    }

    @Override
    public void onLayout(boolean z7, int i6, int i10, int i11, int i12) {
        super.onLayout(z7, i6, i10, i11, i12);
        this.controlViewLayoutManager.onLayout(z7, i6, i10, i11, i12);
    }

    @Deprecated
    public void removeVisibilityListener(VisibilityListener visibilityListener) {
        this.visibilityListeners.remove(visibilityListener);
    }

    public void requestPlayPauseFocus() {
        ImageView imageView = this.playPauseButton;
        if (imageView != null) {
            imageView.requestFocus();
        }
    }

    public void setAnimationEnabled(boolean z7) {
        this.controlViewLayoutManager.setAnimationEnabled(z7);
    }

    public void setExtraAdGroupMarkers(long[] jArr, boolean[] zArr) {
        if (jArr == null) {
            this.extraAdGroupTimesMs = new long[0];
            this.extraPlayedAdGroups = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) Assertions.checkNotNull(zArr);
            Assertions.checkArgument(jArr.length == zArr2.length);
            this.extraAdGroupTimesMs = jArr;
            this.extraPlayedAdGroups = zArr2;
        }
        updateTimeline();
    }

    @Deprecated
    public void setOnFullScreenModeChangedListener(OnFullScreenModeChangedListener onFullScreenModeChangedListener) {
        this.onFullScreenModeChangedListener = onFullScreenModeChangedListener;
        updateFullscreenButtonVisibility(this.fullscreenButton, onFullScreenModeChangedListener != null);
        updateFullscreenButtonVisibility(this.minimalFullscreenButton, onFullScreenModeChangedListener != null);
    }

    public void setPlayer(Player player) {
        Assertions.checkState(Looper.myLooper() == Looper.getMainLooper());
        Assertions.checkArgument(player == null || player.getApplicationLooper() == Looper.getMainLooper());
        Player player2 = this.player;
        if (player2 == player) {
            return;
        }
        if (player2 != null) {
            player2.removeListener(this.componentListener);
        }
        this.player = player;
        if (player != null) {
            player.addListener(this.componentListener);
        }
        updateAll();
    }

    public void setProgressUpdateListener(ProgressUpdateListener progressUpdateListener) {
        this.progressUpdateListener = progressUpdateListener;
    }

    public void setRepeatToggleModes(int i6) {
        this.repeatToggleModes = i6;
        Player player = this.player;
        if (player != null && player.isCommandAvailable(15)) {
            int repeatMode = this.player.getRepeatMode();
            if (i6 == 0 && repeatMode != 0) {
                this.player.setRepeatMode(0);
            } else if (i6 == 1 && repeatMode == 2) {
                this.player.setRepeatMode(1);
            } else if (i6 == 2 && repeatMode == 1) {
                this.player.setRepeatMode(2);
            }
        }
        this.controlViewLayoutManager.setShowButton(this.repeatToggleButton, i6 != 0);
        updateRepeatModeButton();
    }

    public void setShowFastForwardButton(boolean z7) {
        this.controlViewLayoutManager.setShowButton(this.fastForwardButton, z7);
        updateNavigation();
    }

    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z7) {
        this.showMultiWindowTimeBar = z7;
        updateTimeline();
    }

    public void setShowNextButton(boolean z7) {
        this.controlViewLayoutManager.setShowButton(this.nextButton, z7);
        updateNavigation();
    }

    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z7) {
        this.showPlayButtonIfSuppressed = z7;
        updatePlayPauseButton();
    }

    public void setShowPreviousButton(boolean z7) {
        this.controlViewLayoutManager.setShowButton(this.previousButton, z7);
        updateNavigation();
    }

    public void setShowRewindButton(boolean z7) {
        this.controlViewLayoutManager.setShowButton(this.rewindButton, z7);
        updateNavigation();
    }

    public void setShowShuffleButton(boolean z7) {
        this.controlViewLayoutManager.setShowButton(this.shuffleButton, z7);
        updateShuffleButton();
    }

    public void setShowSubtitleButton(boolean z7) {
        this.controlViewLayoutManager.setShowButton(this.subtitleButton, z7);
    }

    public void setShowTimeoutMs(int i6) {
        this.showTimeoutMs = i6;
        if (isFullyVisible()) {
            this.controlViewLayoutManager.resetHideCallbacks();
        }
    }

    public void setShowVrButton(boolean z7) {
        this.controlViewLayoutManager.setShowButton(this.vrButton, z7);
    }

    public void setTimeBarMinUpdateInterval(int i6) {
        this.timeBarMinUpdateIntervalMs = Util.constrainValue(i6, 16, 1000);
    }

    public void setVrButtonListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.vrButton;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
            updateButton(onClickListener != null, this.vrButton);
        }
    }

    public void show() {
        this.controlViewLayoutManager.show();
    }

    public void updateAll() {
        updatePlayPauseButton();
        updateNavigation();
        updateRepeatModeButton();
        updateShuffleButton();
        updateTrackLists();
        updatePlaybackSpeedList();
        updateTimeline();
    }

    public void updateIsFullscreen(boolean z7) {
        if (this.isFullscreen == z7) {
            return;
        }
        this.isFullscreen = z7;
        updateFullscreenButtonForState(this.fullscreenButton, z7);
        updateFullscreenButtonForState(this.minimalFullscreenButton, z7);
        OnFullScreenModeChangedListener onFullScreenModeChangedListener = this.onFullScreenModeChangedListener;
        if (onFullScreenModeChangedListener != null) {
            onFullScreenModeChangedListener.onFullScreenModeChanged(z7);
        }
    }

    public PlayerControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private static int getRepeatToggleModes(TypedArray typedArray, int i6) {
        return typedArray.getInt(C1051R.styleable.PlayerControlView_repeat_toggle_modes, i6);
    }

    public PlayerControlView(Context context, AttributeSet attributeSet, int i6) {
        this(context, attributeSet, i6, attributeSet);
    }

    public PlayerControlView(Context context, AttributeSet attributeSet, int i6, AttributeSet attributeSet2) throws Throwable {
        int i10;
        PlayerControlView playerControlView;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        boolean z7;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        int i22;
        int i23;
        int i24;
        int i25;
        PlayerControlView playerControlView2;
        ImageView imageView;
        boolean z17;
        super(context, attributeSet, i6);
        int resourceId = C1051R.layout.exo_player_control_view;
        int i26 = C1051R.drawable.exo_styled_controls_play;
        int i27 = C1051R.drawable.exo_styled_controls_pause;
        int i28 = C1051R.drawable.exo_styled_controls_next;
        int i29 = C1051R.drawable.exo_styled_controls_simple_fastforward;
        int i30 = C1051R.drawable.exo_styled_controls_previous;
        int i31 = C1051R.drawable.exo_styled_controls_simple_rewind;
        int i32 = C1051R.drawable.exo_styled_controls_fullscreen_exit;
        int i33 = C1051R.drawable.exo_styled_controls_fullscreen_enter;
        int i34 = C1051R.drawable.exo_styled_controls_repeat_off;
        int i35 = C1051R.drawable.exo_styled_controls_repeat_one;
        int i36 = C1051R.drawable.exo_styled_controls_repeat_all;
        int i37 = C1051R.drawable.exo_styled_controls_shuffle_on;
        int i38 = C1051R.drawable.exo_styled_controls_shuffle_off;
        int i39 = C1051R.drawable.exo_styled_controls_subtitle_on;
        int i40 = C1051R.drawable.exo_styled_controls_subtitle_off;
        int i41 = C1051R.drawable.exo_styled_controls_vr;
        this.showPlayButtonIfSuppressed = true;
        this.showTimeoutMs = 5000;
        this.repeatToggleModes = 0;
        this.timeBarMinUpdateIntervalMs = 200;
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, C1051R.styleable.PlayerControlView, i6, 0);
            try {
                resourceId = typedArrayObtainStyledAttributes.getResourceId(C1051R.styleable.PlayerControlView_controller_layout_id, resourceId);
                int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(C1051R.styleable.PlayerControlView_play_icon, i26);
                int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(C1051R.styleable.PlayerControlView_pause_icon, i27);
                int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(C1051R.styleable.PlayerControlView_next_icon, i28);
                int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(C1051R.styleable.PlayerControlView_fastforward_icon, i29);
                int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(C1051R.styleable.PlayerControlView_previous_icon, i30);
                int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(C1051R.styleable.PlayerControlView_rewind_icon, i31);
                int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(C1051R.styleable.PlayerControlView_fullscreen_exit_icon, i32);
                int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(C1051R.styleable.PlayerControlView_fullscreen_enter_icon, i33);
                int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(C1051R.styleable.PlayerControlView_repeat_off_icon, i34);
                int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(C1051R.styleable.PlayerControlView_repeat_one_icon, i35);
                int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(C1051R.styleable.PlayerControlView_repeat_all_icon, i36);
                int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(C1051R.styleable.PlayerControlView_shuffle_on_icon, i37);
                int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(C1051R.styleable.PlayerControlView_shuffle_off_icon, i38);
                int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(C1051R.styleable.PlayerControlView_subtitle_on_icon, i39);
                int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(C1051R.styleable.PlayerControlView_subtitle_off_icon, i40);
                int resourceId17 = typedArrayObtainStyledAttributes.getResourceId(C1051R.styleable.PlayerControlView_vr_icon, i41);
                playerControlView = this;
                try {
                    playerControlView.showTimeoutMs = typedArrayObtainStyledAttributes.getInt(C1051R.styleable.PlayerControlView_show_timeout, playerControlView.showTimeoutMs);
                    playerControlView.repeatToggleModes = getRepeatToggleModes(typedArrayObtainStyledAttributes, playerControlView.repeatToggleModes);
                    boolean z18 = typedArrayObtainStyledAttributes.getBoolean(C1051R.styleable.PlayerControlView_show_rewind_button, true);
                    boolean z19 = typedArrayObtainStyledAttributes.getBoolean(C1051R.styleable.PlayerControlView_show_fastforward_button, true);
                    boolean z20 = typedArrayObtainStyledAttributes.getBoolean(C1051R.styleable.PlayerControlView_show_previous_button, true);
                    boolean z21 = typedArrayObtainStyledAttributes.getBoolean(C1051R.styleable.PlayerControlView_show_next_button, true);
                    boolean z22 = typedArrayObtainStyledAttributes.getBoolean(C1051R.styleable.PlayerControlView_show_shuffle_button, false);
                    boolean z23 = typedArrayObtainStyledAttributes.getBoolean(C1051R.styleable.PlayerControlView_show_subtitle_button, false);
                    boolean z24 = typedArrayObtainStyledAttributes.getBoolean(C1051R.styleable.PlayerControlView_show_vr_button, false);
                    playerControlView.setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(C1051R.styleable.PlayerControlView_time_bar_min_update_interval, playerControlView.timeBarMinUpdateIntervalMs));
                    boolean z25 = typedArrayObtainStyledAttributes.getBoolean(C1051R.styleable.PlayerControlView_animation_enabled, true);
                    typedArrayObtainStyledAttributes.recycle();
                    i25 = resourceId14;
                    z16 = z25;
                    i11 = resourceId5;
                    i12 = resourceId6;
                    i13 = resourceId7;
                    i14 = resourceId8;
                    i15 = resourceId9;
                    i16 = resourceId10;
                    i17 = resourceId11;
                    i18 = resourceId12;
                    i20 = resourceId15;
                    i21 = resourceId16;
                    i10 = resourceId17;
                    z7 = z18;
                    z10 = z19;
                    z11 = z20;
                    z12 = z21;
                    z13 = z22;
                    z14 = z23;
                    z15 = z24;
                    i19 = resourceId13;
                    i22 = resourceId2;
                    i23 = resourceId4;
                    i24 = resourceId3;
                } catch (Throwable th) {
                    th = th;
                    typedArrayObtainStyledAttributes.recycle();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            i10 = i41;
            playerControlView = this;
            i11 = i29;
            i12 = i30;
            i13 = i31;
            i14 = i32;
            i15 = i33;
            i16 = i34;
            i17 = i35;
            i18 = i36;
            i19 = i37;
            i20 = i39;
            i21 = i40;
            z7 = true;
            z10 = true;
            z11 = true;
            z12 = true;
            z13 = false;
            z14 = false;
            z15 = false;
            z16 = true;
            i22 = i26;
            i23 = i28;
            i24 = i27;
            i25 = i38;
        }
        LayoutInflater.from(context).inflate(resourceId, playerControlView);
        playerControlView.setDescendantFocusability(262144);
        ComponentListener componentListener = new ComponentListener();
        playerControlView.componentListener = componentListener;
        playerControlView.visibilityListeners = new CopyOnWriteArrayList<>();
        playerControlView.period = new Timeline.Period();
        playerControlView.window = new Timeline.Window();
        StringBuilder sb = new StringBuilder();
        playerControlView.formatBuilder = sb;
        int i42 = i23;
        playerControlView.formatter = new Formatter(sb, Locale.getDefault());
        playerControlView.adGroupTimesMs = new long[0];
        playerControlView.playedAdGroups = new boolean[0];
        playerControlView.extraAdGroupTimesMs = new long[0];
        playerControlView.extraPlayedAdGroups = new boolean[0];
        playerControlView.updateProgressAction = new RunnableC1056a(playerControlView, 1);
        playerControlView.durationView = (TextView) playerControlView.findViewById(C1051R.id.exo_duration);
        playerControlView.positionView = (TextView) playerControlView.findViewById(C1051R.id.exo_position);
        ImageView imageView2 = (ImageView) playerControlView.findViewById(C1051R.id.exo_subtitle);
        playerControlView.subtitleButton = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(componentListener);
        }
        ImageView imageView3 = (ImageView) playerControlView.findViewById(C1051R.id.exo_fullscreen);
        playerControlView.fullscreenButton = imageView3;
        int i43 = 4;
        initializeFullscreenButton(imageView3, new ViewOnClickListenerC1058c(i43, playerControlView));
        ImageView imageView4 = (ImageView) playerControlView.findViewById(C1051R.id.exo_minimal_fullscreen);
        playerControlView.minimalFullscreenButton = imageView4;
        initializeFullscreenButton(imageView4, new ViewOnClickListenerC1058c(i43, playerControlView));
        View viewFindViewById = playerControlView.findViewById(C1051R.id.exo_settings);
        playerControlView.settingsButton = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(componentListener);
        }
        View viewFindViewById2 = playerControlView.findViewById(C1051R.id.exo_playback_speed);
        playerControlView.playbackSpeedButton = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(componentListener);
        }
        View viewFindViewById3 = playerControlView.findViewById(C1051R.id.exo_audio_track);
        playerControlView.audioTrackButton = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(componentListener);
        }
        TimeBar timeBar = (TimeBar) playerControlView.findViewById(C1051R.id.exo_progress);
        View viewFindViewById4 = playerControlView.findViewById(C1051R.id.exo_progress_placeholder);
        if (timeBar != null) {
            playerControlView.timeBar = timeBar;
            playerControlView2 = playerControlView;
        } else if (viewFindViewById4 != null) {
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2, C1051R.style.ExoStyledControls_TimeBar);
            defaultTimeBar.setId(C1051R.id.exo_progress);
            defaultTimeBar.setLayoutParams(viewFindViewById4.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById4.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById4);
            viewGroup.removeView(viewFindViewById4);
            viewGroup.addView(defaultTimeBar, iIndexOfChild);
            playerControlView2 = this;
            playerControlView2.timeBar = defaultTimeBar;
        } else {
            playerControlView2 = playerControlView;
            playerControlView2.timeBar = null;
        }
        TimeBar timeBar2 = playerControlView2.timeBar;
        if (timeBar2 != null) {
            timeBar2.addListener(componentListener);
        }
        Resources resources = context.getResources();
        playerControlView2.resources = resources;
        ImageView imageView5 = (ImageView) playerControlView2.findViewById(C1051R.id.exo_play_pause);
        playerControlView2.playPauseButton = imageView5;
        if (imageView5 != null) {
            imageView5.setOnClickListener(componentListener);
        }
        ImageView imageView6 = (ImageView) playerControlView2.findViewById(C1051R.id.exo_prev);
        playerControlView2.previousButton = imageView6;
        if (imageView6 != null) {
            imageView6.setImageDrawable(Util.getDrawable(context, resources, i12));
            imageView6.setOnClickListener(componentListener);
        }
        ImageView imageView7 = (ImageView) playerControlView2.findViewById(C1051R.id.exo_next);
        playerControlView2.nextButton = imageView7;
        if (imageView7 != null) {
            imageView7.setImageDrawable(Util.getDrawable(context, resources, i42));
            imageView7.setOnClickListener(componentListener);
        }
        ImageView imageView8 = (ImageView) playerControlView2.findViewById(C1051R.id.exo_rew);
        TextView textView = (TextView) playerControlView2.findViewById(C1051R.id.exo_rew_with_amount);
        if (imageView8 != null) {
            imageView = imageView7;
            imageView8.setImageDrawable(Util.getDrawable(context, resources, i13));
            playerControlView2.rewindButton = imageView8;
            playerControlView2.rewindButtonTextView = null;
        } else {
            imageView = imageView7;
            if (textView != null) {
                playerControlView2.rewindButtonTextView = textView;
                playerControlView2.rewindButton = textView;
            } else {
                playerControlView2.rewindButtonTextView = null;
                playerControlView2.rewindButton = null;
            }
        }
        View view = playerControlView2.rewindButton;
        if (view != null) {
            view.setOnClickListener(componentListener);
        }
        ImageView imageView9 = (ImageView) playerControlView2.findViewById(C1051R.id.exo_ffwd);
        TextView textView2 = (TextView) playerControlView2.findViewById(C1051R.id.exo_ffwd_with_amount);
        if (imageView9 != null) {
            imageView9.setImageDrawable(Util.getDrawable(context, resources, i11));
            playerControlView2.fastForwardButton = imageView9;
            playerControlView2.fastForwardButtonTextView = null;
        } else if (textView2 != null) {
            playerControlView2.fastForwardButtonTextView = textView2;
            playerControlView2.fastForwardButton = textView2;
        } else {
            playerControlView2.fastForwardButtonTextView = null;
            playerControlView2.fastForwardButton = null;
        }
        View view2 = playerControlView2.fastForwardButton;
        if (view2 != null) {
            view2.setOnClickListener(componentListener);
        }
        ImageView imageView10 = (ImageView) playerControlView2.findViewById(C1051R.id.exo_repeat_toggle);
        playerControlView2.repeatToggleButton = imageView10;
        if (imageView10 != null) {
            imageView10.setOnClickListener(componentListener);
        }
        ImageView imageView11 = (ImageView) playerControlView2.findViewById(C1051R.id.exo_shuffle);
        playerControlView2.shuffleButton = imageView11;
        if (imageView11 != null) {
            imageView11.setOnClickListener(componentListener);
        }
        playerControlView2.buttonAlphaEnabled = resources.getInteger(C1051R.integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        playerControlView2.buttonAlphaDisabled = resources.getInteger(C1051R.integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        ImageView imageView12 = (ImageView) playerControlView2.findViewById(C1051R.id.exo_vr);
        playerControlView2.vrButton = imageView12;
        if (imageView12 != null) {
            imageView12.setImageDrawable(Util.getDrawable(context, resources, i10));
            playerControlView2.updateButton(false, imageView12);
        }
        PlayerControlViewLayoutManager playerControlViewLayoutManager = new PlayerControlViewLayoutManager(playerControlView2);
        playerControlView2.controlViewLayoutManager = playerControlViewLayoutManager;
        playerControlViewLayoutManager.setAnimationEnabled(z16);
        SettingsAdapter settingsAdapter = playerControlView2.new SettingsAdapter(new String[]{resources.getString(C1051R.string.exo_controls_playback_speed), resources.getString(C1051R.string.exo_track_selection_title_audio)}, new Drawable[]{Util.getDrawable(context, resources, C1051R.drawable.exo_styled_controls_speed), Util.getDrawable(context, resources, C1051R.drawable.exo_styled_controls_audiotrack)});
        playerControlView2.settingsAdapter = settingsAdapter;
        playerControlView2.settingsWindowMargin = resources.getDimensionPixelSize(C1051R.dimen.exo_settings_offset);
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(C1051R.layout.exo_styled_settings_list, (ViewGroup) null);
        playerControlView2.settingsView = recyclerView;
        recyclerView.setAdapter(settingsAdapter);
        getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(1));
        PopupWindow popupWindow = new PopupWindow((View) recyclerView, -2, -2, true);
        playerControlView2.settingsWindow = popupWindow;
        if (Util.SDK_INT < 23) {
            z17 = false;
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        } else {
            z17 = false;
        }
        popupWindow.setOnDismissListener(componentListener);
        playerControlView2.needToHideBars = true;
        playerControlView2.trackNameProvider = new DefaultTrackNameProvider(getResources());
        playerControlView2.subtitleOnButtonDrawable = Util.getDrawable(context, resources, i20);
        playerControlView2.subtitleOffButtonDrawable = Util.getDrawable(context, resources, i21);
        playerControlView2.subtitleOnContentDescription = resources.getString(C1051R.string.exo_controls_cc_enabled_description);
        playerControlView2.subtitleOffContentDescription = resources.getString(C1051R.string.exo_controls_cc_disabled_description);
        playerControlView2.textTrackSelectionAdapter = new TextTrackSelectionAdapter();
        playerControlView2.audioTrackSelectionAdapter = new AudioTrackSelectionAdapter();
        playerControlView2.playbackSpeedAdapter = playerControlView2.new PlaybackSpeedAdapter(resources.getStringArray(C1051R.array.exo_controls_playback_speeds), PLAYBACK_SPEEDS);
        playerControlView2.playButtonDrawable = Util.getDrawable(context, resources, i22);
        playerControlView2.pauseButtonDrawable = Util.getDrawable(context, resources, i24);
        playerControlView2.fullscreenExitDrawable = Util.getDrawable(context, resources, i14);
        playerControlView2.fullscreenEnterDrawable = Util.getDrawable(context, resources, i15);
        playerControlView2.repeatOffButtonDrawable = Util.getDrawable(context, resources, i16);
        playerControlView2.repeatOneButtonDrawable = Util.getDrawable(context, resources, i17);
        playerControlView2.repeatAllButtonDrawable = Util.getDrawable(context, resources, i18);
        playerControlView2.shuffleOnButtonDrawable = Util.getDrawable(context, resources, i19);
        playerControlView2.shuffleOffButtonDrawable = Util.getDrawable(context, resources, i25);
        playerControlView2.fullscreenExitContentDescription = resources.getString(C1051R.string.exo_controls_fullscreen_exit_description);
        playerControlView2.fullscreenEnterContentDescription = resources.getString(C1051R.string.exo_controls_fullscreen_enter_description);
        playerControlView2.repeatOffButtonContentDescription = resources.getString(C1051R.string.exo_controls_repeat_off_description);
        playerControlView2.repeatOneButtonContentDescription = resources.getString(C1051R.string.exo_controls_repeat_one_description);
        playerControlView2.repeatAllButtonContentDescription = resources.getString(C1051R.string.exo_controls_repeat_all_description);
        playerControlView2.shuffleOnContentDescription = resources.getString(C1051R.string.exo_controls_shuffle_on_description);
        playerControlView2.shuffleOffContentDescription = resources.getString(C1051R.string.exo_controls_shuffle_off_description);
        playerControlViewLayoutManager.setShowButton((ViewGroup) playerControlView2.findViewById(C1051R.id.exo_bottom_bar), true);
        playerControlViewLayoutManager.setShowButton(playerControlView2.fastForwardButton, z10);
        playerControlViewLayoutManager.setShowButton(playerControlView2.rewindButton, z7);
        playerControlViewLayoutManager.setShowButton(imageView6, z11);
        playerControlViewLayoutManager.setShowButton(imageView, z12);
        playerControlViewLayoutManager.setShowButton(imageView11, z13);
        playerControlViewLayoutManager.setShowButton(imageView2, z14);
        playerControlViewLayoutManager.setShowButton(imageView12, z15);
        playerControlViewLayoutManager.setShowButton(imageView10, playerControlView2.repeatToggleModes != 0 ? true : z17);
        playerControlView2.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC1063h(1, playerControlView2));
    }
}

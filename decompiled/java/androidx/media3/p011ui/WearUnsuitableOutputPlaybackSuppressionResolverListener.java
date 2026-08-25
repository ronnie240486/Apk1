package androidx.media3.p011ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.PowerManager;
import androidx.media3.common.AbstractC0602k;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C0565C;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.p010ts.TsExtractor;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@UnstableApi
public final class WearUnsuitableOutputPlaybackSuppressionResolverListener implements Player.Listener {
    public static final long DEFAULT_PLAYBACK_SUPPRESSION_AUTO_RESUME_TIMEOUT_MS = TimeUnit.MINUTES.toMillis(5);
    private static final String EXTRA_BLUETOOTH_SETTINGS_CLOSE_ON_CONNECT = "EXTRA_CLOSE_ON_CONNECT";
    private static final String EXTRA_BLUETOOTH_SETTINGS_CONNECTION_ONLY = "EXTRA_CONNECTION_ONLY";
    private static final String EXTRA_BLUETOOTH_SETTINGS_FILTER_TYPE = "android.bluetooth.devicepicker.extra.FILTER_TYPE";
    private static final String EXTRA_OUTPUT_SWITCHER_PACKAGE_NAME = "com.android.settings.panel.extra.PACKAGE_NAME";
    private static final int FILTER_TYPE_AUDIO = 1;
    private static final String OUTPUT_SWITCHER_INTENT_ACTION_NAME = "com.android.settings.panel.action.MEDIA_OUTPUT";
    private static final String WAKE_LOCK_TAG = "WearUnsuitableOutputPlaybackSuppressionResolverListener:WakeLock";
    private final Context applicationContext;
    private final long autoResumeTimeoutAfterUnsuitableOutputSuppressionMs;
    private final Clock clock;
    private long unsuitableOutputPlaybackSuppressionStartRealtimeMs;
    private final PowerManager.WakeLock wakeLock;

    public WearUnsuitableOutputPlaybackSuppressionResolverListener(Context context) {
        this(context, DEFAULT_PLAYBACK_SUPPRESSION_AUTO_RESUME_TIMEOUT_MS);
    }

    private static ComponentName getSystemOrSystemUpdatedAppComponent(Context context, Intent intent) {
        ApplicationInfo applicationInfo;
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 0).iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (activityInfo != null && (applicationInfo = activityInfo.applicationInfo) != null && (applicationInfo.flags & TsExtractor.TS_STREAM_TYPE_AC3) != 0) {
                return new ComponentName(activityInfo.packageName, activityInfo.name);
            }
        }
        return null;
    }

    private static void launchSystemMediaOutputSwitcherUi(Context context) {
        Intent intentPutExtra = new Intent(OUTPUT_SWITCHER_INTENT_ACTION_NAME).addFlags(268435456).putExtra(EXTRA_OUTPUT_SWITCHER_PACKAGE_NAME, context.getPackageName());
        ComponentName systemOrSystemUpdatedAppComponent = getSystemOrSystemUpdatedAppComponent(context, intentPutExtra);
        if (systemOrSystemUpdatedAppComponent != null) {
            intentPutExtra.setComponent(systemOrSystemUpdatedAppComponent);
            context.startActivity(intentPutExtra);
            return;
        }
        Intent intentPutExtra2 = new Intent("android.settings.BLUETOOTH_SETTINGS").addFlags(268468224).putExtra(EXTRA_BLUETOOTH_SETTINGS_CLOSE_ON_CONNECT, true).putExtra(EXTRA_BLUETOOTH_SETTINGS_CONNECTION_ONLY, true).putExtra(EXTRA_BLUETOOTH_SETTINGS_FILTER_TYPE, 1);
        ComponentName systemOrSystemUpdatedAppComponent2 = getSystemOrSystemUpdatedAppComponent(context, intentPutExtra2);
        if (systemOrSystemUpdatedAppComponent2 != null) {
            intentPutExtra2.setComponent(systemOrSystemUpdatedAppComponent2);
            context.startActivity(intentPutExtra2);
        }
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
    public void onEvents(Player player, Player.Events events) {
        if (Util.isWear(this.applicationContext)) {
            if ((events.contains(6) || events.contains(5)) && player.getPlayWhenReady() && player.getPlaybackSuppressionReason() == 3) {
                player.pause();
                this.unsuitableOutputPlaybackSuppressionStartRealtimeMs = this.clock.elapsedRealtime();
                PowerManager.WakeLock wakeLock = this.wakeLock;
                if (wakeLock != null && !wakeLock.isHeld()) {
                    this.wakeLock.acquire(this.autoResumeTimeoutAfterUnsuitableOutputSuppressionMs);
                }
                if (events.contains(5)) {
                    launchSystemMediaOutputSwitcherUi(this.applicationContext);
                    return;
                }
                return;
            }
            if (!events.contains(6) || player.getPlaybackSuppressionReason() != 0 || this.unsuitableOutputPlaybackSuppressionStartRealtimeMs == C0565C.TIME_UNSET || this.clock.elapsedRealtime() - this.unsuitableOutputPlaybackSuppressionStartRealtimeMs >= this.autoResumeTimeoutAfterUnsuitableOutputSuppressionMs) {
                return;
            }
            this.unsuitableOutputPlaybackSuppressionStartRealtimeMs = C0565C.TIME_UNSET;
            player.play();
            PowerManager.WakeLock wakeLock2 = this.wakeLock;
            if (wakeLock2 != null) {
                wakeLock2.release();
            }
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

    public WearUnsuitableOutputPlaybackSuppressionResolverListener(Context context, long j10) {
        this(context, j10, Clock.DEFAULT);
    }

    @Override
    public final void onCues(List list) {
        AbstractC0602k.m1686e(this, list);
    }

    @Override
    public final void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i6) {
        AbstractC0602k.m1706y(this, positionInfo, positionInfo2, i6);
    }

    public WearUnsuitableOutputPlaybackSuppressionResolverListener(Context context, long j10, Clock clock) {
        PowerManager.WakeLock wakeLockNewWakeLock;
        Assertions.checkArgument(j10 >= 0);
        Context applicationContext = context.getApplicationContext();
        this.applicationContext = applicationContext;
        this.autoResumeTimeoutAfterUnsuitableOutputSuppressionMs = j10;
        this.clock = clock;
        this.unsuitableOutputPlaybackSuppressionStartRealtimeMs = C0565C.TIME_UNSET;
        PowerManager powerManager = (PowerManager) applicationContext.getSystemService("power");
        if (powerManager != null) {
            wakeLockNewWakeLock = powerManager.newWakeLock(1, WAKE_LOCK_TAG);
            wakeLockNewWakeLock.setReferenceCounted(false);
        } else {
            wakeLockNewWakeLock = null;
        }
        this.wakeLock = wakeLockNewWakeLock;
    }
}

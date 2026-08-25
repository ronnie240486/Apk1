package androidx.media3.p011ui;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.AbstractC0337k0;
import androidx.core.app.C0346p;
import androidx.core.app.C0355t0;
import androidx.core.app.C0356u;
import androidx.core.app.C0359v0;
import androidx.core.app.C0367z0;
import androidx.core.app.InterfaceC0342n;
import androidx.core.app.ServiceConnectionC0365y0;
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
import androidx.media3.common.util.NotificationUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@UnstableApi
public class PlayerNotificationManager {
    private static final String ACTION_DISMISS = "androidx.media3.ui.notification.dismiss";
    public static final String ACTION_FAST_FORWARD = "androidx.media3.ui.notification.ffwd";
    public static final String ACTION_NEXT = "androidx.media3.ui.notification.next";
    public static final String ACTION_PAUSE = "androidx.media3.ui.notification.pause";
    public static final String ACTION_PLAY = "androidx.media3.ui.notification.play";
    public static final String ACTION_PREVIOUS = "androidx.media3.ui.notification.prev";
    public static final String ACTION_REWIND = "androidx.media3.ui.notification.rewind";
    public static final String ACTION_STOP = "androidx.media3.ui.notification.stop";
    public static final String EXTRA_INSTANCE_ID = "INSTANCE_ID";
    private static final int MSG_START_OR_UPDATE_NOTIFICATION = 1;
    private static final int MSG_UPDATE_NOTIFICATION_BITMAP = 2;
    private static int instanceIdCounter;
    private int badgeIconType;
    private C0356u builder;
    private List<C0346p> builderActions;
    private final String channelId;
    private int color;
    private boolean colorized;
    private final Context context;
    private int currentNotificationTag;
    private final CustomActionReceiver customActionReceiver;
    private final Map<String, C0346p> customActions;
    private int defaults;
    private final PendingIntent dismissPendingIntent;
    private String groupKey;
    private final int instanceId;
    private final IntentFilter intentFilter;
    private boolean isNotificationStarted;
    private final Handler mainHandler;
    private final MediaDescriptionAdapter mediaDescriptionAdapter;
    private MediaSession.Token mediaSessionToken;
    private final NotificationBroadcastReceiver notificationBroadcastReceiver;
    private final int notificationId;
    private final NotificationListener notificationListener;
    private final C0367z0 notificationManager;
    private final Map<String, C0346p> playbackActions;
    private Player player;
    private final Player.Listener playerListener;
    private int priority;
    private boolean showPlayButtonIfSuppressed;
    private int smallIconResourceId;
    private boolean useChronometer;
    private boolean useFastForwardAction;
    private boolean useFastForwardActionInCompactView;
    private boolean useNextAction;
    private boolean useNextActionInCompactView;
    private boolean usePlayPauseActions;
    private boolean usePreviousAction;
    private boolean usePreviousActionInCompactView;
    private boolean useRewindAction;
    private boolean useRewindActionInCompactView;
    private boolean useStopAction;
    private int visibility;

    public final class BitmapCallback {
        private final int notificationTag;

        public void onBitmap(Bitmap bitmap) {
            if (bitmap != null) {
                PlayerNotificationManager.this.postUpdateNotificationBitmap(bitmap, this.notificationTag);
            }
        }

        private BitmapCallback(int i6) {
            this.notificationTag = i6;
        }
    }

    public interface CustomActionReceiver {
        Map<String, C0346p> createCustomActions(Context context, int i6);

        List<String> getCustomActions(Player player);

        void onCustomAction(Player player, String str, Intent intent);
    }

    public interface MediaDescriptionAdapter {
        PendingIntent createCurrentContentIntent(Player player);

        CharSequence getCurrentContentText(Player player);

        CharSequence getCurrentContentTitle(Player player);

        Bitmap getCurrentLargeIcon(Player player, BitmapCallback bitmapCallback);

        CharSequence getCurrentSubText(Player player);
    }

    public static final class MediaStyle extends AbstractC0337k0 {
        private final int[] actionsToShowInCompact;
        private final MediaSession.Token token;

        public MediaStyle(MediaSession.Token token, int[] iArr) {
            this.token = token;
            this.actionsToShowInCompact = iArr;
        }

        @Override
        public void apply(InterfaceC0342n interfaceC0342n) {
            Notification.MediaStyle mediaStyle = new Notification.MediaStyle();
            mediaStyle.setShowActionsInCompactView(this.actionsToShowInCompact);
            MediaSession.Token token = this.token;
            if (token != null) {
                mediaStyle.setMediaSession(token);
            }
            ((C0355t0) interfaceC0342n).f1546b.setStyle(mediaStyle);
        }
    }

    public class NotificationBroadcastReceiver extends BroadcastReceiver {
        private NotificationBroadcastReceiver() {
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            Player player = PlayerNotificationManager.this.player;
            if (player != null && PlayerNotificationManager.this.isNotificationStarted && intent.getIntExtra(PlayerNotificationManager.EXTRA_INSTANCE_ID, PlayerNotificationManager.this.instanceId) == PlayerNotificationManager.this.instanceId) {
                String action = intent.getAction();
                if (PlayerNotificationManager.ACTION_PLAY.equals(action)) {
                    Util.handlePlayButtonAction(player);
                    return;
                }
                if (PlayerNotificationManager.ACTION_PAUSE.equals(action)) {
                    Util.handlePauseButtonAction(player);
                    return;
                }
                if (PlayerNotificationManager.ACTION_PREVIOUS.equals(action)) {
                    if (player.isCommandAvailable(7)) {
                        player.seekToPrevious();
                        return;
                    }
                    return;
                }
                if (PlayerNotificationManager.ACTION_REWIND.equals(action)) {
                    if (player.isCommandAvailable(11)) {
                        player.seekBack();
                        return;
                    }
                    return;
                }
                if (PlayerNotificationManager.ACTION_FAST_FORWARD.equals(action)) {
                    if (player.isCommandAvailable(12)) {
                        player.seekForward();
                        return;
                    }
                    return;
                }
                if (PlayerNotificationManager.ACTION_NEXT.equals(action)) {
                    if (player.isCommandAvailable(9)) {
                        player.seekToNext();
                        return;
                    }
                    return;
                }
                if (PlayerNotificationManager.ACTION_STOP.equals(action)) {
                    if (player.isCommandAvailable(3)) {
                        player.stop();
                    }
                    if (player.isCommandAvailable(20)) {
                        player.clearMediaItems();
                        return;
                    }
                    return;
                }
                if (PlayerNotificationManager.ACTION_DISMISS.equals(action)) {
                    PlayerNotificationManager.this.stopNotification(true);
                } else {
                    if (action == null || PlayerNotificationManager.this.customActionReceiver == null || !PlayerNotificationManager.this.customActions.containsKey(action)) {
                        return;
                    }
                    PlayerNotificationManager.this.customActionReceiver.onCustomAction(player, action, intent);
                }
            }
        }
    }

    public interface NotificationListener {
        void onNotificationCancelled(int i6, boolean z7);

        void onNotificationPosted(int i6, Notification notification, boolean z7);
    }

    public class PlayerListener implements Player.Listener {
        private PlayerListener() {
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
            if (events.containsAny(4, 5, 7, 0, 12, 11, 8, 9, 14)) {
                PlayerNotificationManager.this.postStartOrUpdateNotification();
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

        @Override
        public final void onCues(List list) {
            AbstractC0602k.m1686e(this, list);
        }

        @Override
        public final void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i6) {
            AbstractC0602k.m1706y(this, positionInfo, positionInfo2, i6);
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Priority {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Visibility {
    }

    public PlayerNotificationManager(Context context, String str, int i6, MediaDescriptionAdapter mediaDescriptionAdapter, NotificationListener notificationListener, CustomActionReceiver customActionReceiver, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, String str2) {
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        this.channelId = str;
        this.notificationId = i6;
        this.mediaDescriptionAdapter = mediaDescriptionAdapter;
        this.notificationListener = notificationListener;
        this.customActionReceiver = customActionReceiver;
        this.smallIconResourceId = i10;
        this.groupKey = str2;
        int i18 = instanceIdCounter;
        instanceIdCounter = i18 + 1;
        this.instanceId = i18;
        this.mainHandler = Util.createHandler(Looper.getMainLooper(), new Handler.Callback() {
            @Override
            public final boolean handleMessage(Message message) {
                return this.f3133a.handleMessage(message);
            }
        });
        this.notificationManager = new C0367z0(applicationContext);
        this.playerListener = new PlayerListener();
        this.notificationBroadcastReceiver = new NotificationBroadcastReceiver();
        this.intentFilter = new IntentFilter();
        this.usePreviousAction = true;
        this.useNextAction = true;
        this.usePlayPauseActions = true;
        this.showPlayButtonIfSuppressed = true;
        this.useRewindAction = true;
        this.useFastForwardAction = true;
        this.colorized = true;
        this.useChronometer = true;
        this.color = 0;
        this.defaults = 0;
        this.priority = -1;
        this.badgeIconType = 1;
        this.visibility = 1;
        Map<String, C0346p> mapCreatePlaybackActions = createPlaybackActions(applicationContext, i18, i11, i12, i13, i14, i15, i16, i17);
        this.playbackActions = mapCreatePlaybackActions;
        Iterator<String> it = mapCreatePlaybackActions.keySet().iterator();
        while (it.hasNext()) {
            this.intentFilter.addAction(it.next());
        }
        Map<String, C0346p> mapCreateCustomActions = customActionReceiver != null ? customActionReceiver.createCustomActions(applicationContext, this.instanceId) : Collections.emptyMap();
        this.customActions = mapCreateCustomActions;
        Iterator<String> it2 = mapCreateCustomActions.keySet().iterator();
        while (it2.hasNext()) {
            this.intentFilter.addAction(it2.next());
        }
        this.dismissPendingIntent = createBroadcastIntent(ACTION_DISMISS, applicationContext, this.instanceId);
        this.intentFilter.addAction(ACTION_DISMISS);
    }

    private static PendingIntent createBroadcastIntent(String str, Context context, int i6) {
        Intent intent = new Intent(str).setPackage(context.getPackageName());
        intent.putExtra(EXTRA_INSTANCE_ID, i6);
        return PendingIntent.getBroadcast(context, i6, intent, Util.SDK_INT >= 23 ? 201326592 : C0565C.BUFFER_FLAG_FIRST_SAMPLE);
    }

    private static Map<String, C0346p> createPlaybackActions(Context context, int i6, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        HashMap map = new HashMap();
        map.put(ACTION_PLAY, new C0346p(i10, context.getString(C1051R.string.exo_controls_play_description), createBroadcastIntent(ACTION_PLAY, context, i6)));
        map.put(ACTION_PAUSE, new C0346p(i11, context.getString(C1051R.string.exo_controls_pause_description), createBroadcastIntent(ACTION_PAUSE, context, i6)));
        map.put(ACTION_STOP, new C0346p(i12, context.getString(C1051R.string.exo_controls_stop_description), createBroadcastIntent(ACTION_STOP, context, i6)));
        map.put(ACTION_REWIND, new C0346p(i13, context.getString(C1051R.string.exo_controls_rewind_description), createBroadcastIntent(ACTION_REWIND, context, i6)));
        map.put(ACTION_FAST_FORWARD, new C0346p(i14, context.getString(C1051R.string.exo_controls_fastforward_description), createBroadcastIntent(ACTION_FAST_FORWARD, context, i6)));
        map.put(ACTION_PREVIOUS, new C0346p(i15, context.getString(C1051R.string.exo_controls_previous_description), createBroadcastIntent(ACTION_PREVIOUS, context, i6)));
        map.put(ACTION_NEXT, new C0346p(i16, context.getString(C1051R.string.exo_controls_next_description), createBroadcastIntent(ACTION_NEXT, context, i6)));
        return map;
    }

    public boolean handleMessage(Message message) {
        int i6 = message.what;
        if (i6 == 1) {
            Player player = this.player;
            if (player != null) {
                startOrUpdateNotification(player, null);
            }
        } else {
            if (i6 != 2) {
                return false;
            }
            Player player2 = this.player;
            if (player2 != null && this.isNotificationStarted && this.currentNotificationTag == message.arg1) {
                startOrUpdateNotification(player2, (Bitmap) message.obj);
            }
        }
        return true;
    }

    public void postStartOrUpdateNotification() {
        if (this.mainHandler.hasMessages(1)) {
            return;
        }
        this.mainHandler.sendEmptyMessage(1);
    }

    public void postUpdateNotificationBitmap(Bitmap bitmap, int i6) {
        this.mainHandler.obtainMessage(2, i6, -1, bitmap).sendToTarget();
    }

    private static void setLargeIcon(C0356u c0356u, Bitmap bitmap) {
        c0356u.m1027d(bitmap);
    }

    @SuppressLint({"MissingPermission"})
    private void startOrUpdateNotification(Player player, Bitmap bitmap) {
        boolean ongoing = getOngoing(player);
        C0356u c0356uCreateNotification = createNotification(player, this.builder, ongoing, bitmap);
        this.builder = c0356uCreateNotification;
        if (c0356uCreateNotification == null) {
            stopNotification(false);
            return;
        }
        Notification notificationM1025a = c0356uCreateNotification.m1025a();
        C0367z0 c0367z0 = this.notificationManager;
        int i6 = this.notificationId;
        c0367z0.getClass();
        Bundle bundle = notificationM1025a.extras;
        NotificationManager notificationManager = c0367z0.f1598b;
        if (bundle == null || !bundle.getBoolean("android.support.useSideChannel")) {
            notificationManager.notify(null, i6, notificationM1025a);
        } else {
            C0359v0 c0359v0 = new C0359v0(c0367z0.f1597a.getPackageName(), i6, notificationM1025a);
            synchronized (C0367z0.f1595f) {
                try {
                    if (C0367z0.f1596g == null) {
                        C0367z0.f1596g = new ServiceConnectionC0365y0(c0367z0.f1597a.getApplicationContext());
                    }
                    C0367z0.f1596g.f1589b.obtainMessage(0, c0359v0).sendToTarget();
                } catch (Throwable th) {
                    throw th;
                }
            }
            notificationManager.cancel(null, i6);
        }
        if (!this.isNotificationStarted) {
            Util.registerReceiverNotExported(this.context, this.notificationBroadcastReceiver, this.intentFilter);
        }
        NotificationListener notificationListener = this.notificationListener;
        if (notificationListener != null) {
            notificationListener.onNotificationPosted(this.notificationId, notificationM1025a, ongoing || !this.isNotificationStarted);
        }
        this.isNotificationStarted = true;
    }

    public void stopNotification(boolean z7) {
        if (this.isNotificationStarted) {
            this.isNotificationStarted = false;
            this.mainHandler.removeMessages(1);
            C0367z0 c0367z0 = this.notificationManager;
            c0367z0.f1598b.cancel(null, this.notificationId);
            this.context.unregisterReceiver(this.notificationBroadcastReceiver);
            NotificationListener notificationListener = this.notificationListener;
            if (notificationListener != null) {
                notificationListener.onNotificationCancelled(this.notificationId, z7);
            }
        }
    }

    public C0356u createNotification(Player player, C0356u c0356u, boolean z7, Bitmap bitmap) {
        if (player.getPlaybackState() == 1 && player.isCommandAvailable(17) && player.getCurrentTimeline().isEmpty()) {
            this.builderActions = null;
            return null;
        }
        List<String> actions = getActions(player);
        ArrayList arrayList = new ArrayList(actions.size());
        for (int i6 = 0; i6 < actions.size(); i6++) {
            String str = actions.get(i6);
            C0346p c0346p = this.playbackActions.containsKey(str) ? this.playbackActions.get(str) : this.customActions.get(str);
            if (c0346p != null) {
                arrayList.add(c0346p);
            }
        }
        if (c0356u == null || !arrayList.equals(this.builderActions)) {
            c0356u = new C0356u(this.context, this.channelId);
            this.builderActions = arrayList;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                C0346p c0346p2 = (C0346p) arrayList.get(i10);
                if (c0346p2 != null) {
                    c0356u.f1553b.add(c0346p2);
                }
            }
        }
        c0356u.m1028e(new MediaStyle(this.mediaSessionToken, getActionIndicesForCompactView(actions, player)));
        PendingIntent pendingIntent = this.dismissPendingIntent;
        Notification notification = c0356u.f1550B;
        notification.deleteIntent = pendingIntent;
        c0356u.f1576y = this.badgeIconType;
        c0356u.m1026c(2, z7);
        c0356u.f1573v = this.color;
        c0356u.f1570s = this.colorized;
        c0356u.f1571t = true;
        notification.icon = this.smallIconResourceId;
        c0356u.f1574w = this.visibility;
        c0356u.f1560i = this.priority;
        int i11 = this.defaults;
        notification.defaults = i11;
        if ((i11 & 4) != 0) {
            notification.flags |= 1;
        }
        if (this.useChronometer && player.isCommandAvailable(16) && player.isPlaying() && !player.isPlayingAd() && !player.isCurrentMediaItemDynamic() && player.getPlaybackParameters().speed == 1.0f) {
            notification.when = System.currentTimeMillis() - player.getContentPosition();
            c0356u.f1561j = true;
            c0356u.f1562k = true;
        } else {
            c0356u.f1561j = false;
            c0356u.f1562k = false;
        }
        c0356u.f1556e = C0356u.m1024b(this.mediaDescriptionAdapter.getCurrentContentTitle(player));
        c0356u.f1557f = C0356u.m1024b(this.mediaDescriptionAdapter.getCurrentContentText(player));
        c0356u.f1564m = C0356u.m1024b(this.mediaDescriptionAdapter.getCurrentSubText(player));
        if (bitmap == null) {
            MediaDescriptionAdapter mediaDescriptionAdapter = this.mediaDescriptionAdapter;
            int i12 = this.currentNotificationTag + 1;
            this.currentNotificationTag = i12;
            bitmap = mediaDescriptionAdapter.getCurrentLargeIcon(player, new BitmapCallback(i12));
        }
        setLargeIcon(c0356u, bitmap);
        c0356u.f1558g = this.mediaDescriptionAdapter.createCurrentContentIntent(player);
        String str2 = this.groupKey;
        if (str2 != null) {
            c0356u.f1568q = str2;
        }
        c0356u.m1026c(8, true);
        return c0356u;
    }

    public int[] getActionIndicesForCompactView(List<String> list, Player player) {
        int iIndexOf;
        int iIndexOf2;
        int i6;
        int iIndexOf3 = list.indexOf(ACTION_PAUSE);
        int iIndexOf4 = list.indexOf(ACTION_PLAY);
        if (this.usePreviousActionInCompactView) {
            iIndexOf = list.indexOf(ACTION_PREVIOUS);
        } else {
            iIndexOf = this.useRewindActionInCompactView ? list.indexOf(ACTION_REWIND) : -1;
        }
        if (this.useNextActionInCompactView) {
            iIndexOf2 = list.indexOf(ACTION_NEXT);
        } else {
            iIndexOf2 = this.useFastForwardActionInCompactView ? list.indexOf(ACTION_FAST_FORWARD) : -1;
        }
        int[] iArr = new int[3];
        int i10 = 0;
        if (iIndexOf != -1) {
            iArr[0] = iIndexOf;
            i10 = 1;
        }
        boolean zShouldShowPlayButton = Util.shouldShowPlayButton(player, this.showPlayButtonIfSuppressed);
        if (iIndexOf3 == -1 || zShouldShowPlayButton) {
            if (iIndexOf4 != -1 && zShouldShowPlayButton) {
                i6 = i10 + 1;
                iArr[i10] = iIndexOf4;
            }
            if (iIndexOf2 != -1) {
                iArr[i10] = iIndexOf2;
                i10++;
            }
            return Arrays.copyOf(iArr, i10);
        }
        i6 = i10 + 1;
        iArr[i10] = iIndexOf3;
        i10 = i6;
        if (iIndexOf2 != -1) {
            iArr[i10] = iIndexOf2;
            i10++;
        }
        return Arrays.copyOf(iArr, i10);
    }

    public List<String> getActions(Player player) {
        boolean zIsCommandAvailable = player.isCommandAvailable(7);
        boolean zIsCommandAvailable2 = player.isCommandAvailable(11);
        boolean zIsCommandAvailable3 = player.isCommandAvailable(12);
        boolean zIsCommandAvailable4 = player.isCommandAvailable(9);
        ArrayList arrayList = new ArrayList();
        if (this.usePreviousAction && zIsCommandAvailable) {
            arrayList.add(ACTION_PREVIOUS);
        }
        if (this.useRewindAction && zIsCommandAvailable2) {
            arrayList.add(ACTION_REWIND);
        }
        if (this.usePlayPauseActions) {
            if (Util.shouldShowPlayButton(player, this.showPlayButtonIfSuppressed)) {
                arrayList.add(ACTION_PLAY);
            } else {
                arrayList.add(ACTION_PAUSE);
            }
        }
        if (this.useFastForwardAction && zIsCommandAvailable3) {
            arrayList.add(ACTION_FAST_FORWARD);
        }
        if (this.useNextAction && zIsCommandAvailable4) {
            arrayList.add(ACTION_NEXT);
        }
        CustomActionReceiver customActionReceiver = this.customActionReceiver;
        if (customActionReceiver != null) {
            arrayList.addAll(customActionReceiver.getCustomActions(player));
        }
        if (this.useStopAction) {
            arrayList.add(ACTION_STOP);
        }
        return arrayList;
    }

    public boolean getOngoing(Player player) {
        int playbackState = player.getPlaybackState();
        return (playbackState == 2 || playbackState == 3) && player.getPlayWhenReady();
    }

    public final void invalidate() {
        if (this.isNotificationStarted) {
            postStartOrUpdateNotification();
        }
    }

    public final void setBadgeIconType(int i6) {
        if (this.badgeIconType == i6) {
            return;
        }
        if (i6 != 0 && i6 != 1 && i6 != 2) {
            throw new IllegalArgumentException();
        }
        this.badgeIconType = i6;
        invalidate();
    }

    public final void setColor(int i6) {
        if (this.color != i6) {
            this.color = i6;
            invalidate();
        }
    }

    public final void setColorized(boolean z7) {
        if (this.colorized != z7) {
            this.colorized = z7;
            invalidate();
        }
    }

    public final void setDefaults(int i6) {
        if (this.defaults != i6) {
            this.defaults = i6;
            invalidate();
        }
    }

    public final void setMediaSessionToken(MediaSession.Token token) {
        if (Objects.equals(this.mediaSessionToken, token)) {
            return;
        }
        this.mediaSessionToken = token;
        invalidate();
    }

    public final void setPlayer(Player player) {
        boolean z7 = true;
        Assertions.checkState(Looper.myLooper() == Looper.getMainLooper());
        if (player != null && player.getApplicationLooper() != Looper.getMainLooper()) {
            z7 = false;
        }
        Assertions.checkArgument(z7);
        Player player2 = this.player;
        if (player2 == player) {
            return;
        }
        if (player2 != null) {
            player2.removeListener(this.playerListener);
            if (player == null) {
                stopNotification(false);
            }
        }
        this.player = player;
        if (player != null) {
            player.addListener(this.playerListener);
            postStartOrUpdateNotification();
        }
    }

    public final void setPriority(int i6) {
        if (this.priority == i6) {
            return;
        }
        if (i6 != -2 && i6 != -1 && i6 != 0 && i6 != 1 && i6 != 2) {
            throw new IllegalArgumentException();
        }
        this.priority = i6;
        invalidate();
    }

    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z7) {
        if (this.showPlayButtonIfSuppressed != z7) {
            this.showPlayButtonIfSuppressed = z7;
            invalidate();
        }
    }

    public final void setSmallIcon(int i6) {
        if (this.smallIconResourceId != i6) {
            this.smallIconResourceId = i6;
            invalidate();
        }
    }

    public final void setUseChronometer(boolean z7) {
        if (this.useChronometer != z7) {
            this.useChronometer = z7;
            invalidate();
        }
    }

    public final void setUseFastForwardAction(boolean z7) {
        if (this.useFastForwardAction != z7) {
            this.useFastForwardAction = z7;
            invalidate();
        }
    }

    public final void setUseFastForwardActionInCompactView(boolean z7) {
        if (this.useFastForwardActionInCompactView != z7) {
            this.useFastForwardActionInCompactView = z7;
            if (z7) {
                this.useNextActionInCompactView = false;
            }
            invalidate();
        }
    }

    public final void setUseNextAction(boolean z7) {
        if (this.useNextAction != z7) {
            this.useNextAction = z7;
            invalidate();
        }
    }

    public final void setUseNextActionInCompactView(boolean z7) {
        if (this.useNextActionInCompactView != z7) {
            this.useNextActionInCompactView = z7;
            if (z7) {
                this.useFastForwardActionInCompactView = false;
            }
            invalidate();
        }
    }

    public final void setUsePlayPauseActions(boolean z7) {
        if (this.usePlayPauseActions != z7) {
            this.usePlayPauseActions = z7;
            invalidate();
        }
    }

    public final void setUsePreviousAction(boolean z7) {
        if (this.usePreviousAction != z7) {
            this.usePreviousAction = z7;
            invalidate();
        }
    }

    public final void setUsePreviousActionInCompactView(boolean z7) {
        if (this.usePreviousActionInCompactView != z7) {
            this.usePreviousActionInCompactView = z7;
            if (z7) {
                this.useRewindActionInCompactView = false;
            }
            invalidate();
        }
    }

    public final void setUseRewindAction(boolean z7) {
        if (this.useRewindAction != z7) {
            this.useRewindAction = z7;
            invalidate();
        }
    }

    public final void setUseRewindActionInCompactView(boolean z7) {
        if (this.useRewindActionInCompactView != z7) {
            this.useRewindActionInCompactView = z7;
            if (z7) {
                this.usePreviousActionInCompactView = false;
            }
            invalidate();
        }
    }

    public final void setUseStopAction(boolean z7) {
        if (this.useStopAction == z7) {
            return;
        }
        this.useStopAction = z7;
        invalidate();
    }

    public final void setVisibility(int i6) {
        if (this.visibility == i6) {
            return;
        }
        if (i6 != -1 && i6 != 0 && i6 != 1) {
            throw new IllegalStateException();
        }
        this.visibility = i6;
        invalidate();
    }

    public static class Builder {
        protected int channelDescriptionResourceId;
        protected final String channelId;
        protected int channelImportance;
        protected int channelNameResourceId;
        protected final Context context;
        protected CustomActionReceiver customActionReceiver;
        protected int fastForwardActionIconResourceId;
        protected String groupKey;
        protected MediaDescriptionAdapter mediaDescriptionAdapter;
        protected int nextActionIconResourceId;
        protected final int notificationId;
        protected NotificationListener notificationListener;
        protected int pauseActionIconResourceId;
        protected int playActionIconResourceId;
        protected int previousActionIconResourceId;
        protected int rewindActionIconResourceId;
        protected int smallIconResourceId;
        protected int stopActionIconResourceId;

        @Deprecated
        public Builder(Context context, int i6, String str, MediaDescriptionAdapter mediaDescriptionAdapter) {
            this(context, i6, str);
            this.mediaDescriptionAdapter = mediaDescriptionAdapter;
        }

        public PlayerNotificationManager build() {
            int i6 = this.channelNameResourceId;
            if (i6 != 0) {
                NotificationUtil.createNotificationChannel(this.context, this.channelId, i6, this.channelDescriptionResourceId, this.channelImportance);
            }
            return new PlayerNotificationManager(this.context, this.channelId, this.notificationId, this.mediaDescriptionAdapter, this.notificationListener, this.customActionReceiver, this.smallIconResourceId, this.playActionIconResourceId, this.pauseActionIconResourceId, this.stopActionIconResourceId, this.rewindActionIconResourceId, this.fastForwardActionIconResourceId, this.previousActionIconResourceId, this.nextActionIconResourceId, this.groupKey);
        }

        public Builder setChannelDescriptionResourceId(int i6) {
            this.channelDescriptionResourceId = i6;
            return this;
        }

        public Builder setChannelImportance(int i6) {
            this.channelImportance = i6;
            return this;
        }

        public Builder setChannelNameResourceId(int i6) {
            this.channelNameResourceId = i6;
            return this;
        }

        public Builder setCustomActionReceiver(CustomActionReceiver customActionReceiver) {
            this.customActionReceiver = customActionReceiver;
            return this;
        }

        public Builder setFastForwardActionIconResourceId(int i6) {
            this.fastForwardActionIconResourceId = i6;
            return this;
        }

        public Builder setGroup(String str) {
            this.groupKey = str;
            return this;
        }

        public Builder setMediaDescriptionAdapter(MediaDescriptionAdapter mediaDescriptionAdapter) {
            this.mediaDescriptionAdapter = mediaDescriptionAdapter;
            return this;
        }

        public Builder setNextActionIconResourceId(int i6) {
            this.nextActionIconResourceId = i6;
            return this;
        }

        public Builder setNotificationListener(NotificationListener notificationListener) {
            this.notificationListener = notificationListener;
            return this;
        }

        public Builder setPauseActionIconResourceId(int i6) {
            this.pauseActionIconResourceId = i6;
            return this;
        }

        public Builder setPlayActionIconResourceId(int i6) {
            this.playActionIconResourceId = i6;
            return this;
        }

        public Builder setPreviousActionIconResourceId(int i6) {
            this.previousActionIconResourceId = i6;
            return this;
        }

        public Builder setRewindActionIconResourceId(int i6) {
            this.rewindActionIconResourceId = i6;
            return this;
        }

        public Builder setSmallIconResourceId(int i6) {
            this.smallIconResourceId = i6;
            return this;
        }

        public Builder setStopActionIconResourceId(int i6) {
            this.stopActionIconResourceId = i6;
            return this;
        }

        public Builder(Context context, int i6, String str) {
            Assertions.checkArgument(i6 > 0);
            this.context = context;
            this.notificationId = i6;
            this.channelId = str;
            this.channelImportance = 2;
            this.mediaDescriptionAdapter = new DefaultMediaDescriptionAdapter(null);
            this.smallIconResourceId = C1051R.drawable.exo_notification_small_icon;
            this.playActionIconResourceId = C1051R.drawable.exo_notification_play;
            this.pauseActionIconResourceId = C1051R.drawable.exo_notification_pause;
            this.stopActionIconResourceId = C1051R.drawable.exo_notification_stop;
            this.rewindActionIconResourceId = C1051R.drawable.exo_notification_rewind;
            this.fastForwardActionIconResourceId = C1051R.drawable.exo_notification_fastforward;
            this.previousActionIconResourceId = C1051R.drawable.exo_notification_previous;
            this.nextActionIconResourceId = C1051R.drawable.exo_notification_next;
        }
    }
}

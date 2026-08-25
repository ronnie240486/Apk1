package androidx.media3.p011ui;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.AttachedSurfaceControl;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.SurfaceSyncGroup;
import androidx.appcompat.app.RunnableC0147m0;
import androidx.media3.common.AbstractC0602k;
import androidx.media3.common.AdOverlayInfo;
import androidx.media3.common.AdViewProvider;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.ErrorMessageProvider;
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
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.image.ImageOutput;
import androidx.media3.exoplayer.mediacodec.AbstractC0819i;
import androidx.media3.exoplayer.video.VideoDecoderGLSurfaceView;
import androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import p034d0.AbstractC2115a;
import p041d7.AbstractC2301u1;

public class PlayerView extends FrameLayout implements AdViewProvider {

    @UnstableApi
    public static final int ARTWORK_DISPLAY_MODE_FILL = 2;

    @UnstableApi
    public static final int ARTWORK_DISPLAY_MODE_FIT = 1;

    @UnstableApi
    public static final int ARTWORK_DISPLAY_MODE_OFF = 0;

    @UnstableApi
    public static final int IMAGE_DISPLAY_MODE_FILL = 1;

    @UnstableApi
    public static final int IMAGE_DISPLAY_MODE_FIT = 0;

    @UnstableApi
    public static final int SHOW_BUFFERING_ALWAYS = 2;

    @UnstableApi
    public static final int SHOW_BUFFERING_NEVER = 0;

    @UnstableApi
    public static final int SHOW_BUFFERING_WHEN_PLAYING = 1;
    private static final int SURFACE_TYPE_NONE = 0;
    private static final int SURFACE_TYPE_SPHERICAL_GL_SURFACE_VIEW = 3;
    private static final int SURFACE_TYPE_SURFACE_VIEW = 1;
    private static final int SURFACE_TYPE_TEXTURE_VIEW = 2;
    private static final int SURFACE_TYPE_VIDEO_DECODER_GL_SURFACE_VIEW = 4;
    private final FrameLayout adOverlayFrameLayout;
    private int artworkDisplayMode;
    private final ImageView artworkView;
    private final View bufferingView;
    private final ComponentListener componentListener;
    private final AspectRatioFrameLayout contentFrame;
    private final PlayerControlView controller;
    private boolean controllerAutoShow;
    private boolean controllerHideDuringAds;
    private boolean controllerHideOnTouch;
    private int controllerShowTimeoutMs;
    private ControllerVisibilityListener controllerVisibilityListener;
    private CharSequence customErrorMessage;
    private Drawable defaultArtwork;
    private boolean enableComposeSurfaceSyncWorkaround;
    private ErrorMessageProvider<? super PlaybackException> errorMessageProvider;
    private final TextView errorMessageView;
    private final Class<?> exoPlayerClazz;
    private FullscreenButtonClickListener fullscreenButtonClickListener;
    private int imageDisplayMode;
    private final Object imageOutput;
    private final ImageView imageView;
    private boolean keepContentOnPlayerReset;
    private PlayerControlView.VisibilityListener legacyControllerVisibilityListener;
    private final Handler mainLooperHandler;
    private final FrameLayout overlayFrameLayout;
    private Player player;
    private final Method setImageOutputMethod;
    private int showBuffering;
    private final View shutterView;
    private final SubtitleView subtitleView;
    private final SurfaceSyncGroupCompatV34 surfaceSyncGroupV34;
    private final View surfaceView;
    private final boolean surfaceViewIgnoresVideoAspectRatio;
    private boolean useController;

    public static class Api34 {
        private Api34() {
        }

        public static void setSurfaceLifecycleToFollowsAttachment(SurfaceView surfaceView) {
            surfaceView.setSurfaceLifecycle(2);
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @UnstableApi
    public @interface ArtworkDisplayMode {
    }

    public final class ComponentListener implements Player.Listener, View.OnClickListener, PlayerControlView.VisibilityListener, PlayerControlView.OnFullScreenModeChangedListener {
        private Object lastPeriodUidWithTracks;
        private final Timeline.Period period = new Timeline.Period();

        public ComponentListener() {
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
            PlayerView.this.toggleControllerVisibility();
        }

        @Override
        public final void onCues(List list) {
            AbstractC0602k.m1686e(this, list);
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
        public final void onEvents(Player player, Player.Events events) {
            AbstractC0602k.m1689h(this, player, events);
        }

        @Override
        public void onFullScreenModeChanged(boolean z7) {
            if (PlayerView.this.fullscreenButtonClickListener != null) {
                PlayerView.this.fullscreenButtonClickListener.onFullscreenButtonClick(z7);
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
        public void onPlayWhenReadyChanged(boolean z7, int i6) {
            PlayerView.this.updateBuffering();
            PlayerView.this.updateControllerVisibility();
        }

        @Override
        public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            AbstractC0602k.m1698q(this, playbackParameters);
        }

        @Override
        public void onPlaybackStateChanged(int i6) {
            PlayerView.this.updateBuffering();
            PlayerView.this.updateErrorMessage();
            PlayerView.this.updateControllerVisibility();
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
            if (PlayerView.this.shutterView != null) {
                PlayerView.this.shutterView.setVisibility(4);
                if (PlayerView.this.hasSelectedImageTrack()) {
                    PlayerView.this.hideImage();
                } else {
                    PlayerView.this.hideAndClearImage();
                }
            }
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
        public void onSurfaceSizeChanged(int i6, int i10) {
            if (Util.SDK_INT == 34 && (PlayerView.this.surfaceView instanceof SurfaceView) && PlayerView.this.enableComposeSurfaceSyncWorkaround) {
                ((SurfaceSyncGroupCompatV34) Assertions.checkNotNull(PlayerView.this.surfaceSyncGroupV34)).postRegister(PlayerView.this.mainLooperHandler, (SurfaceView) PlayerView.this.surfaceView, new RunnableC1056a(PlayerView.this, 2));
            }
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
        public void onTracksChanged(Tracks tracks) {
            Player player = (Player) Assertions.checkNotNull(PlayerView.this.player);
            Timeline currentTimeline = player.isCommandAvailable(17) ? player.getCurrentTimeline() : Timeline.EMPTY;
            if (currentTimeline.isEmpty()) {
                this.lastPeriodUidWithTracks = null;
            } else if (!player.isCommandAvailable(30) || player.getCurrentTracks().isEmpty()) {
                Object obj = this.lastPeriodUidWithTracks;
                if (obj != null) {
                    int indexOfPeriod = currentTimeline.getIndexOfPeriod(obj);
                    if (indexOfPeriod != -1) {
                        if (player.getCurrentMediaItemIndex() == currentTimeline.getPeriod(indexOfPeriod, this.period).windowIndex) {
                            return;
                        }
                    }
                    this.lastPeriodUidWithTracks = null;
                }
            } else {
                this.lastPeriodUidWithTracks = currentTimeline.getPeriod(player.getCurrentPeriodIndex(), this.period, true).uid;
            }
            PlayerView.this.updateForCurrentTrackSelections(false);
        }

        @Override
        public void onVideoSizeChanged(VideoSize videoSize) {
            if (videoSize.equals(VideoSize.UNKNOWN) || PlayerView.this.player == null || PlayerView.this.player.getPlaybackState() == 1) {
                return;
            }
            PlayerView.this.updateAspectRatio();
        }

        @Override
        public void onVisibilityChange(int i6) {
            PlayerView.this.updateContentDescription();
            if (PlayerView.this.controllerVisibilityListener != null) {
                PlayerView.this.controllerVisibilityListener.onVisibilityChanged(i6);
            }
        }

        @Override
        public final void onVolumeChanged(float f) {
            AbstractC0602k.m1681K(this, f);
        }

        @Override
        public void onCues(CueGroup cueGroup) {
            if (PlayerView.this.subtitleView != null) {
                PlayerView.this.subtitleView.setCues(cueGroup.cues);
            }
        }

        @Override
        public void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i6) {
            if (PlayerView.this.isPlayingAd() && PlayerView.this.controllerHideDuringAds) {
                PlayerView.this.hideController();
            }
        }
    }

    public interface ControllerVisibilityListener {
        void onVisibilityChanged(int i6);
    }

    public interface FullscreenButtonClickListener {
        void onFullscreenButtonClick(boolean z7);
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @UnstableApi
    public @interface ImageDisplayMode {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @UnstableApi
    public @interface ShowBuffering {
    }

    public PlayerView(Context context) {
        this(context, null);
    }

    private void clearImageOutput(Player player) {
        Class<?> cls = this.exoPlayerClazz;
        if (cls == null || !cls.isAssignableFrom(player.getClass())) {
            return;
        }
        try {
            ((Method) Assertions.checkNotNull(this.setImageOutputMethod)).invoke(player, null);
        } catch (IllegalAccessException | InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    private void closeShutter() {
        View view = this.shutterView;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private static void configureEditModeLogo(Context context, Resources resources, ImageView imageView) {
        imageView.setImageDrawable(Util.getDrawable(context, resources, C1051R.drawable.exo_edit_mode_logo));
        imageView.setBackgroundColor(resources.getColor(C1051R.color.exo_edit_mode_background_color));
    }

    private static void configureEditModeLogoV23(Context context, Resources resources, ImageView imageView) {
        imageView.setImageDrawable(Util.getDrawable(context, resources, C1051R.drawable.exo_edit_mode_logo));
        imageView.setBackgroundColor(resources.getColor(C1051R.color.exo_edit_mode_background_color, null));
    }

    public boolean hasSelectedImageTrack() {
        Player player = this.player;
        return player != null && this.imageOutput != null && player.isCommandAvailable(30) && player.getCurrentTracks().isTypeSelected(4);
    }

    private boolean hasSelectedVideoTrack() {
        Player player = this.player;
        return player != null && player.isCommandAvailable(30) && player.getCurrentTracks().isTypeSelected(2);
    }

    public void hideAndClearImage() {
        hideImage();
        ImageView imageView = this.imageView;
        if (imageView != null) {
            imageView.setImageResource(R.color.transparent);
        }
    }

    private void hideArtwork() {
        ImageView imageView = this.artworkView;
        if (imageView != null) {
            imageView.setImageResource(R.color.transparent);
            this.artworkView.setVisibility(4);
        }
    }

    public void hideImage() {
        ImageView imageView = this.imageView;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
    }

    @SuppressLint({"InlinedApi"})
    private boolean isDpadKey(int i6) {
        return i6 == 19 || i6 == 270 || i6 == 22 || i6 == 271 || i6 == 20 || i6 == 269 || i6 == 21 || i6 == 268 || i6 == 23;
    }

    private boolean isImageSet() {
        Drawable drawable;
        ImageView imageView = this.imageView;
        return (imageView == null || (drawable = imageView.getDrawable()) == null || drawable.getAlpha() == 0) ? false : true;
    }

    public boolean isPlayingAd() {
        Player player = this.player;
        return player != null && player.isCommandAvailable(16) && this.player.isPlayingAd() && this.player.getPlayWhenReady();
    }

    public Object lambda$new$0(Object obj, Method method, Object[] objArr) throws Throwable {
        if (!method.getName().equals("onImageAvailable")) {
            return null;
        }
        onImageAvailable((Bitmap) objArr[1]);
        return null;
    }

    public void lambda$onImageAvailable$1(Bitmap bitmap) {
        setImage(new BitmapDrawable(getResources(), bitmap));
        if (hasSelectedVideoTrack()) {
            return;
        }
        showImage();
        closeShutter();
    }

    private void maybeShowController(boolean z7) {
        if (!(isPlayingAd() && this.controllerHideDuringAds) && useController()) {
            boolean z10 = this.controller.isFullyVisible() && this.controller.getShowTimeoutMs() <= 0;
            boolean zShouldShowControllerIndefinitely = shouldShowControllerIndefinitely();
            if (z7 || z10 || zShouldShowControllerIndefinitely) {
                showController(zShouldShowControllerIndefinitely);
            }
        }
    }

    private void onImageAvailable(Bitmap bitmap) {
        this.mainLooperHandler.post(new RunnableC0147m0(this, 11, bitmap));
    }

    private boolean setArtworkFromMediaMetadata(Player player) {
        byte[] bArr;
        if (player == null || !player.isCommandAvailable(18) || (bArr = player.getMediaMetadata().artworkData) == null) {
            return false;
        }
        return setDrawableArtwork(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
    }

    private boolean setDrawableArtwork(Drawable drawable) {
        if (this.artworkView != null && drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                float width = intrinsicWidth / intrinsicHeight;
                ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
                if (this.artworkDisplayMode == 2) {
                    width = getWidth() / getHeight();
                    scaleType = ImageView.ScaleType.CENTER_CROP;
                }
                onContentAspectRatioChanged(this.contentFrame, width);
                this.artworkView.setScaleType(scaleType);
                this.artworkView.setImageDrawable(drawable);
                this.artworkView.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    private void setImage(Drawable drawable) {
        ImageView imageView = this.imageView;
        if (imageView == null) {
            return;
        }
        imageView.setImageDrawable(drawable);
        updateImageViewAspectRatio();
    }

    private void setImageOutput(Player player) {
        Class<?> cls = this.exoPlayerClazz;
        if (cls == null || !cls.isAssignableFrom(player.getClass())) {
            return;
        }
        try {
            ((Method) Assertions.checkNotNull(this.setImageOutputMethod)).invoke(player, Assertions.checkNotNull(this.imageOutput));
        } catch (IllegalAccessException | InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    private static void setResizeModeRaw(AspectRatioFrameLayout aspectRatioFrameLayout, int i6) {
        aspectRatioFrameLayout.setResizeMode(i6);
    }

    private boolean shouldShowControllerIndefinitely() {
        Player player = this.player;
        if (player == null) {
            return true;
        }
        int playbackState = player.getPlaybackState();
        return this.controllerAutoShow && !(this.player.isCommandAvailable(17) && this.player.getCurrentTimeline().isEmpty()) && (playbackState == 1 || playbackState == 4 || !((Player) Assertions.checkNotNull(this.player)).getPlayWhenReady());
    }

    private void showImage() {
        ImageView imageView = this.imageView;
        if (imageView != null) {
            imageView.setVisibility(0);
            updateImageViewAspectRatio();
        }
    }

    @UnstableApi
    public static void switchTargetView(Player player, PlayerView playerView, PlayerView playerView2) {
        if (playerView == playerView2) {
            return;
        }
        if (playerView2 != null) {
            playerView2.setPlayer(player);
        }
        if (playerView != null) {
            playerView.setPlayer(null);
        }
    }

    public void toggleControllerVisibility() {
        if (!useController() || this.player == null) {
            return;
        }
        if (!this.controller.isFullyVisible()) {
            maybeShowController(true);
        } else if (this.controllerHideOnTouch) {
            this.controller.hide();
        }
    }

    public void updateAspectRatio() {
        Player player = this.player;
        VideoSize videoSize = player != null ? player.getVideoSize() : VideoSize.UNKNOWN;
        int i6 = videoSize.width;
        int i10 = videoSize.height;
        onContentAspectRatioChanged(this.contentFrame, this.surfaceViewIgnoresVideoAspectRatio ? 0.0f : (i10 == 0 || i6 == 0) ? 0.0f : (i6 * videoSize.pixelWidthHeightRatio) / i10);
    }

    public void updateBuffering() {
        boolean z7;
        if (this.bufferingView != null) {
            Player player = this.player;
            if (player == null || player.getPlaybackState() != 2) {
                z7 = false;
            } else {
                int i6 = this.showBuffering;
                z7 = true;
                if (i6 != 2 && (i6 != 1 || !this.player.getPlayWhenReady())) {
                    z7 = false;
                }
            }
            this.bufferingView.setVisibility(z7 ? 0 : 8);
        }
    }

    public void updateContentDescription() {
        PlayerControlView playerControlView = this.controller;
        if (playerControlView == null || !this.useController) {
            setContentDescription(null);
        } else if (playerControlView.isFullyVisible()) {
            setContentDescription(this.controllerHideOnTouch ? getResources().getString(C1051R.string.exo_controls_hide) : null);
        } else {
            setContentDescription(getResources().getString(C1051R.string.exo_controls_show));
        }
    }

    public void updateControllerVisibility() {
        if (isPlayingAd() && this.controllerHideDuringAds) {
            hideController();
        } else {
            maybeShowController(false);
        }
    }

    public void updateErrorMessage() {
        ErrorMessageProvider<? super PlaybackException> errorMessageProvider;
        TextView textView = this.errorMessageView;
        if (textView != null) {
            CharSequence charSequence = this.customErrorMessage;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.errorMessageView.setVisibility(0);
                return;
            }
            Player player = this.player;
            PlaybackException playerError = player != null ? player.getPlayerError() : null;
            if (playerError == null || (errorMessageProvider = this.errorMessageProvider) == null) {
                this.errorMessageView.setVisibility(8);
            } else {
                this.errorMessageView.setText((CharSequence) errorMessageProvider.getErrorMessage(playerError).second);
                this.errorMessageView.setVisibility(0);
            }
        }
    }

    public void updateForCurrentTrackSelections(boolean z7) {
        Player player = this.player;
        boolean z10 = false;
        boolean z11 = (player == null || !player.isCommandAvailable(30) || player.getCurrentTracks().isEmpty()) ? false : true;
        if (!this.keepContentOnPlayerReset && (!z11 || z7)) {
            hideArtwork();
            closeShutter();
            hideAndClearImage();
        }
        if (z11) {
            boolean zHasSelectedVideoTrack = hasSelectedVideoTrack();
            boolean zHasSelectedImageTrack = hasSelectedImageTrack();
            if (!zHasSelectedVideoTrack && !zHasSelectedImageTrack) {
                closeShutter();
                hideAndClearImage();
            }
            View view = this.shutterView;
            if (view != null && view.getVisibility() == 4 && isImageSet()) {
                z10 = true;
            }
            if (zHasSelectedImageTrack && !zHasSelectedVideoTrack && z10) {
                closeShutter();
                showImage();
            } else if (zHasSelectedVideoTrack && !zHasSelectedImageTrack && z10) {
                hideAndClearImage();
            }
            if (zHasSelectedVideoTrack || zHasSelectedImageTrack || !useArtwork() || !(setArtworkFromMediaMetadata(player) || setDrawableArtwork(this.defaultArtwork))) {
                hideArtwork();
            }
        }
    }

    private void updateImageViewAspectRatio() {
        Drawable drawable;
        ImageView imageView = this.imageView;
        if (imageView == null || (drawable = imageView.getDrawable()) == null) {
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return;
        }
        float width = intrinsicWidth / intrinsicHeight;
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        if (this.imageDisplayMode == 1) {
            width = getWidth() / getHeight();
            scaleType = ImageView.ScaleType.CENTER_CROP;
        }
        if (this.imageView.getVisibility() == 0) {
            onContentAspectRatioChanged(this.contentFrame, width);
        }
        this.imageView.setScaleType(scaleType);
    }

    private boolean useArtwork() {
        if (this.artworkDisplayMode == 0) {
            return false;
        }
        Assertions.checkStateNotNull(this.artworkView);
        return true;
    }

    private boolean useController() {
        if (!this.useController) {
            return false;
        }
        Assertions.checkStateNotNull(this.controller);
        return true;
    }

    @Override
    public void dispatchDraw(Canvas canvas) {
        SurfaceSyncGroupCompatV34 surfaceSyncGroupCompatV34;
        super.dispatchDraw(canvas);
        if (Util.SDK_INT == 34 && (surfaceSyncGroupCompatV34 = this.surfaceSyncGroupV34) != null && this.enableComposeSurfaceSyncWorkaround) {
            surfaceSyncGroupCompatV34.maybeMarkSyncReadyAndClear();
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Player player = this.player;
        if (player != null && player.isCommandAvailable(16) && this.player.isPlayingAd()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean zIsDpadKey = isDpadKey(keyEvent.getKeyCode());
        if (zIsDpadKey && useController() && !this.controller.isFullyVisible()) {
            maybeShowController(true);
            return true;
        }
        if (dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
            maybeShowController(true);
            return true;
        }
        if (zIsDpadKey && useController()) {
            maybeShowController(true);
        }
        return false;
    }

    @UnstableApi
    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        return useController() && this.controller.dispatchMediaKeyEvent(keyEvent);
    }

    @Override
    public List<AdOverlayInfo> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.overlayFrameLayout;
        if (frameLayout != null) {
            arrayList.add(new AdOverlayInfo.Builder(frameLayout, 4).setDetailedReason("Transparent overlay does not impact viewability").build());
        }
        PlayerControlView playerControlView = this.controller;
        if (playerControlView != null) {
            arrayList.add(new AdOverlayInfo.Builder(playerControlView, 1).build());
        }
        return AbstractC2301u1.m5272n(arrayList);
    }

    @Override
    public ViewGroup getAdViewGroup() {
        return (ViewGroup) Assertions.checkStateNotNull(this.adOverlayFrameLayout, "exo_ad_overlay must be present for ad playback");
    }

    @UnstableApi
    public int getArtworkDisplayMode() {
        return this.artworkDisplayMode;
    }

    @UnstableApi
    public boolean getControllerAutoShow() {
        return this.controllerAutoShow;
    }

    @UnstableApi
    public boolean getControllerHideOnTouch() {
        return this.controllerHideOnTouch;
    }

    @UnstableApi
    public int getControllerShowTimeoutMs() {
        return this.controllerShowTimeoutMs;
    }

    @UnstableApi
    public Drawable getDefaultArtwork() {
        return this.defaultArtwork;
    }

    @UnstableApi
    public int getImageDisplayMode() {
        return this.imageDisplayMode;
    }

    @UnstableApi
    public FrameLayout getOverlayFrameLayout() {
        return this.overlayFrameLayout;
    }

    public Player getPlayer() {
        return this.player;
    }

    @UnstableApi
    public int getResizeMode() {
        Assertions.checkStateNotNull(this.contentFrame);
        return this.contentFrame.getResizeMode();
    }

    @UnstableApi
    public SubtitleView getSubtitleView() {
        return this.subtitleView;
    }

    @UnstableApi
    @Deprecated
    public boolean getUseArtwork() {
        return this.artworkDisplayMode != 0;
    }

    public boolean getUseController() {
        return this.useController;
    }

    @UnstableApi
    public View getVideoSurfaceView() {
        return this.surfaceView;
    }

    @UnstableApi
    public void hideController() {
        PlayerControlView playerControlView = this.controller;
        if (playerControlView != null) {
            playerControlView.hide();
        }
    }

    @UnstableApi
    public boolean isControllerFullyVisible() {
        PlayerControlView playerControlView = this.controller;
        return playerControlView != null && playerControlView.isFullyVisible();
    }

    @UnstableApi
    public void onContentAspectRatioChanged(AspectRatioFrameLayout aspectRatioFrameLayout, float f) {
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f);
        }
    }

    public void onPause() {
        View view = this.surfaceView;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).onPause();
        }
    }

    public void onResume() {
        View view = this.surfaceView;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).onResume();
        }
    }

    @Override
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!useController() || this.player == null) {
            return false;
        }
        maybeShowController(true);
        return true;
    }

    @Override
    public boolean performClick() {
        toggleControllerVisibility();
        return super.performClick();
    }

    @UnstableApi
    public void setArtworkDisplayMode(int i6) {
        Assertions.checkState(i6 == 0 || this.artworkView != null);
        if (this.artworkDisplayMode != i6) {
            this.artworkDisplayMode = i6;
            updateForCurrentTrackSelections(false);
        }
    }

    @UnstableApi
    public void setAspectRatioListener(AspectRatioFrameLayout.AspectRatioListener aspectRatioListener) {
        Assertions.checkStateNotNull(this.contentFrame);
        this.contentFrame.setAspectRatioListener(aspectRatioListener);
    }

    @UnstableApi
    public void setControllerAnimationEnabled(boolean z7) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.setAnimationEnabled(z7);
    }

    @UnstableApi
    public void setControllerAutoShow(boolean z7) {
        this.controllerAutoShow = z7;
    }

    @UnstableApi
    public void setControllerHideDuringAds(boolean z7) {
        this.controllerHideDuringAds = z7;
    }

    @UnstableApi
    public void setControllerHideOnTouch(boolean z7) {
        Assertions.checkStateNotNull(this.controller);
        this.controllerHideOnTouch = z7;
        updateContentDescription();
    }

    @UnstableApi
    @Deprecated
    public void setControllerOnFullScreenModeChangedListener(PlayerControlView.OnFullScreenModeChangedListener onFullScreenModeChangedListener) {
        Assertions.checkStateNotNull(this.controller);
        this.fullscreenButtonClickListener = null;
        this.controller.setOnFullScreenModeChangedListener(onFullScreenModeChangedListener);
    }

    @UnstableApi
    public void setControllerShowTimeoutMs(int i6) {
        Assertions.checkStateNotNull(this.controller);
        this.controllerShowTimeoutMs = i6;
        if (this.controller.isFullyVisible()) {
            showController();
        }
    }

    public void setControllerVisibilityListener(ControllerVisibilityListener controllerVisibilityListener) {
        this.controllerVisibilityListener = controllerVisibilityListener;
        if (controllerVisibilityListener != null) {
            setControllerVisibilityListener((PlayerControlView.VisibilityListener) null);
        }
    }

    @UnstableApi
    public void setCustomErrorMessage(CharSequence charSequence) {
        Assertions.checkState(this.errorMessageView != null);
        this.customErrorMessage = charSequence;
        updateErrorMessage();
    }

    @UnstableApi
    public void setDefaultArtwork(Drawable drawable) {
        if (this.defaultArtwork != drawable) {
            this.defaultArtwork = drawable;
            updateForCurrentTrackSelections(false);
        }
    }

    @UnstableApi
    public void setEnableComposeSurfaceSyncWorkaround(boolean z7) {
        this.enableComposeSurfaceSyncWorkaround = z7;
    }

    public void setErrorMessageProvider(ErrorMessageProvider<? super PlaybackException> errorMessageProvider) {
        if (this.errorMessageProvider != errorMessageProvider) {
            this.errorMessageProvider = errorMessageProvider;
            updateErrorMessage();
        }
    }

    @UnstableApi
    public void setExtraAdGroupMarkers(long[] jArr, boolean[] zArr) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.setExtraAdGroupMarkers(jArr, zArr);
    }

    public void setFullscreenButtonClickListener(FullscreenButtonClickListener fullscreenButtonClickListener) {
        Assertions.checkStateNotNull(this.controller);
        this.fullscreenButtonClickListener = fullscreenButtonClickListener;
        this.controller.setOnFullScreenModeChangedListener(this.componentListener);
    }

    @UnstableApi
    public void setFullscreenButtonState(boolean z7) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.updateIsFullscreen(z7);
    }

    @UnstableApi
    public void setImageDisplayMode(int i6) {
        Assertions.checkState(this.imageView != null);
        if (this.imageDisplayMode != i6) {
            this.imageDisplayMode = i6;
            updateImageViewAspectRatio();
        }
    }

    @UnstableApi
    public void setKeepContentOnPlayerReset(boolean z7) {
        if (this.keepContentOnPlayerReset != z7) {
            this.keepContentOnPlayerReset = z7;
            updateForCurrentTrackSelections(false);
        }
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
            if (player2.isCommandAvailable(27)) {
                View view = this.surfaceView;
                if (view instanceof TextureView) {
                    player2.clearVideoTextureView((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    player2.clearVideoSurfaceView((SurfaceView) view);
                }
            }
            clearImageOutput(player2);
        }
        SubtitleView subtitleView = this.subtitleView;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        this.player = player;
        if (useController()) {
            this.controller.setPlayer(player);
        }
        updateBuffering();
        updateErrorMessage();
        updateForCurrentTrackSelections(true);
        if (player == null) {
            hideController();
            return;
        }
        if (player.isCommandAvailable(27)) {
            View view2 = this.surfaceView;
            if (view2 instanceof TextureView) {
                player.setVideoTextureView((TextureView) view2);
            } else if (view2 instanceof SurfaceView) {
                player.setVideoSurfaceView((SurfaceView) view2);
            }
            if (!player.isCommandAvailable(30) || player.getCurrentTracks().isTypeSupported(2)) {
                updateAspectRatio();
            }
        }
        if (this.subtitleView != null && player.isCommandAvailable(28)) {
            this.subtitleView.setCues(player.getCurrentCues().cues);
        }
        player.addListener(this.componentListener);
        setImageOutput(player);
        maybeShowController(false);
    }

    @UnstableApi
    public void setRepeatToggleModes(int i6) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.setRepeatToggleModes(i6);
    }

    @UnstableApi
    public void setResizeMode(int i6) {
        Assertions.checkStateNotNull(this.contentFrame);
        this.contentFrame.setResizeMode(i6);
    }

    @UnstableApi
    public void setShowBuffering(int i6) {
        if (this.showBuffering != i6) {
            this.showBuffering = i6;
            updateBuffering();
        }
    }

    @UnstableApi
    public void setShowFastForwardButton(boolean z7) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.setShowFastForwardButton(z7);
    }

    @UnstableApi
    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z7) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.setShowMultiWindowTimeBar(z7);
    }

    @UnstableApi
    public void setShowNextButton(boolean z7) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.setShowNextButton(z7);
    }

    @UnstableApi
    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z7) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.setShowPlayButtonIfPlaybackIsSuppressed(z7);
    }

    @UnstableApi
    public void setShowPreviousButton(boolean z7) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.setShowPreviousButton(z7);
    }

    @UnstableApi
    public void setShowRewindButton(boolean z7) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.setShowRewindButton(z7);
    }

    @UnstableApi
    public void setShowShuffleButton(boolean z7) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.setShowShuffleButton(z7);
    }

    @UnstableApi
    public void setShowSubtitleButton(boolean z7) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.setShowSubtitleButton(z7);
    }

    @UnstableApi
    public void setShowVrButton(boolean z7) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.setShowVrButton(z7);
    }

    @UnstableApi
    public void setShutterBackgroundColor(int i6) {
        View view = this.shutterView;
        if (view != null) {
            view.setBackgroundColor(i6);
        }
    }

    @UnstableApi
    @Deprecated
    public void setUseArtwork(boolean z7) {
        setArtworkDisplayMode(!z7 ? 1 : 0);
    }

    public void setUseController(boolean z7) {
        boolean z10 = true;
        Assertions.checkState((z7 && this.controller == null) ? false : true);
        if (!z7 && !hasOnClickListeners()) {
            z10 = false;
        }
        setClickable(z10);
        if (this.useController == z7) {
            return;
        }
        this.useController = z7;
        if (useController()) {
            this.controller.setPlayer(this.player);
        } else {
            PlayerControlView playerControlView = this.controller;
            if (playerControlView != null) {
                playerControlView.hide();
                this.controller.setPlayer(null);
            }
        }
        updateContentDescription();
    }

    @Override
    public void setVisibility(int i6) {
        super.setVisibility(i6);
        View view = this.surfaceView;
        if (view instanceof SurfaceView) {
            view.setVisibility(i6);
        }
    }

    @UnstableApi
    public void showController() {
        showController(shouldShowControllerIndefinitely());
    }

    public PlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void showController(boolean z7) {
        if (useController()) {
            this.controller.setShowTimeoutMs(z7 ? 0 : this.controllerShowTimeoutMs);
            this.controller.show();
        }
    }

    public PlayerView(Context context, AttributeSet attributeSet, int i6) {
        int i10;
        boolean z7;
        int i11;
        boolean z10;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z11;
        int i16;
        boolean z12;
        int i17;
        int i18;
        boolean z13;
        boolean z14;
        C10501 c10501;
        boolean z15;
        Class<ExoPlayer> cls;
        Object objNewProxyInstance;
        Method method;
        boolean z16;
        super(context, attributeSet, i6);
        ComponentListener componentListener = new ComponentListener();
        this.componentListener = componentListener;
        this.mainLooperHandler = new Handler(Looper.getMainLooper());
        if (isInEditMode()) {
            this.contentFrame = null;
            this.shutterView = null;
            this.surfaceView = null;
            this.surfaceViewIgnoresVideoAspectRatio = false;
            this.surfaceSyncGroupV34 = null;
            this.imageView = null;
            this.artworkView = null;
            this.subtitleView = null;
            this.bufferingView = null;
            this.errorMessageView = null;
            this.controller = null;
            this.adOverlayFrameLayout = null;
            this.overlayFrameLayout = null;
            this.exoPlayerClazz = null;
            this.setImageOutputMethod = null;
            this.imageOutput = null;
            ImageView imageView = new ImageView(context);
            if (Util.SDK_INT >= 23) {
                configureEditModeLogoV23(context, getResources(), imageView);
            } else {
                configureEditModeLogo(context, getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i19 = C1051R.layout.exo_player_view;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1051R.styleable.PlayerView, i6, 0);
            try {
                boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(C1051R.styleable.PlayerView_shutter_background_color);
                int color = typedArrayObtainStyledAttributes.getColor(C1051R.styleable.PlayerView_shutter_background_color, 0);
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(C1051R.styleable.PlayerView_player_layout_id, i19);
                boolean z17 = typedArrayObtainStyledAttributes.getBoolean(C1051R.styleable.PlayerView_use_artwork, true);
                int i20 = typedArrayObtainStyledAttributes.getInt(C1051R.styleable.PlayerView_artwork_display_mode, 1);
                int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(C1051R.styleable.PlayerView_default_artwork, 0);
                int i21 = typedArrayObtainStyledAttributes.getInt(C1051R.styleable.PlayerView_image_display_mode, 0);
                boolean z18 = typedArrayObtainStyledAttributes.getBoolean(C1051R.styleable.PlayerView_use_controller, true);
                int i22 = typedArrayObtainStyledAttributes.getInt(C1051R.styleable.PlayerView_surface_type, 1);
                int i23 = typedArrayObtainStyledAttributes.getInt(C1051R.styleable.PlayerView_resize_mode, 0);
                i18 = typedArrayObtainStyledAttributes.getInt(C1051R.styleable.PlayerView_show_timeout, 5000);
                z10 = typedArrayObtainStyledAttributes.getBoolean(C1051R.styleable.PlayerView_hide_on_touch, true);
                z14 = typedArrayObtainStyledAttributes.getBoolean(C1051R.styleable.PlayerView_auto_show, true);
                int integer = typedArrayObtainStyledAttributes.getInteger(C1051R.styleable.PlayerView_show_buffering, 0);
                this.keepContentOnPlayerReset = typedArrayObtainStyledAttributes.getBoolean(C1051R.styleable.PlayerView_keep_content_on_player_reset, this.keepContentOnPlayerReset);
                boolean z19 = typedArrayObtainStyledAttributes.getBoolean(C1051R.styleable.PlayerView_hide_during_ads, true);
                typedArrayObtainStyledAttributes.recycle();
                i13 = integer;
                i11 = i23;
                z7 = z18;
                i12 = i21;
                i17 = i20;
                i16 = color;
                i15 = i22;
                i10 = resourceId;
                z13 = z19;
                z11 = zHasValue;
                i14 = resourceId2;
                z12 = z17;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            i10 = i19;
            z7 = true;
            i11 = 0;
            z10 = true;
            i12 = 0;
            i13 = 0;
            i14 = 0;
            i15 = 1;
            z11 = false;
            i16 = 0;
            z12 = true;
            i17 = 1;
            i18 = 5000;
            z13 = true;
            z14 = true;
        }
        LayoutInflater.from(context).inflate(i10, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(C1051R.id.exo_content_frame);
        this.contentFrame = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            setResizeModeRaw(aspectRatioFrameLayout, i11);
        }
        View viewFindViewById = findViewById(C1051R.id.exo_shutter);
        this.shutterView = viewFindViewById;
        if (viewFindViewById != null && z11) {
            viewFindViewById.setBackgroundColor(i16);
        }
        if (aspectRatioFrameLayout != null && i15 != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i15 == 2) {
                this.surfaceView = new TextureView(context);
            } else {
                if (i15 == 3) {
                    try {
                        int i24 = SphericalGLSurfaceView.f3068a;
                        this.surfaceView = (View) SphericalGLSurfaceView.class.getConstructor(Context.class).newInstance(context);
                        z16 = true;
                    } catch (Exception e5) {
                        throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e5);
                    }
                } else if (i15 != 4) {
                    SurfaceView surfaceView = new SurfaceView(context);
                    if (Util.SDK_INT >= 34) {
                        Api34.setSurfaceLifecycleToFollowsAttachment(surfaceView);
                    }
                    this.surfaceView = surfaceView;
                } else {
                    try {
                        int i25 = VideoDecoderGLSurfaceView.f3043a;
                        this.surfaceView = (View) VideoDecoderGLSurfaceView.class.getConstructor(Context.class).newInstance(context);
                    } catch (Exception e10) {
                        throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e10);
                    }
                }
                this.surfaceView.setLayoutParams(layoutParams);
                this.surfaceView.setOnClickListener(componentListener);
                this.surfaceView.setClickable(false);
                aspectRatioFrameLayout.addView(this.surfaceView, 0);
                z15 = z16;
                c10501 = null;
            }
            z16 = false;
            this.surfaceView.setLayoutParams(layoutParams);
            this.surfaceView.setOnClickListener(componentListener);
            this.surfaceView.setClickable(false);
            aspectRatioFrameLayout.addView(this.surfaceView, 0);
            z15 = z16;
            c10501 = null;
        } else {
            c10501 = null;
            this.surfaceView = null;
            z15 = false;
        }
        this.surfaceViewIgnoresVideoAspectRatio = z15;
        this.surfaceSyncGroupV34 = Util.SDK_INT == 34 ? new SurfaceSyncGroupCompatV34() : null;
        this.adOverlayFrameLayout = (FrameLayout) findViewById(C1051R.id.exo_ad_overlay);
        this.overlayFrameLayout = (FrameLayout) findViewById(C1051R.id.exo_overlay);
        this.imageView = (ImageView) findViewById(C1051R.id.exo_image);
        this.imageDisplayMode = i12;
        try {
            cls = ExoPlayer.class;
            ImageOutput imageOutput = ImageOutput.NO_OP;
            method = cls.getMethod("setImageOutput", ImageOutput.class);
            objNewProxyInstance = Proxy.newProxyInstance(ImageOutput.class.getClassLoader(), new Class[]{ImageOutput.class}, new InvocationHandler() {
                @Override
                public final Object invoke(Object obj, Method method2, Object[] objArr) {
                    return this.f3134a.lambda$new$0(obj, method2, objArr);
                }
            });
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            cls = null;
            objNewProxyInstance = null;
            method = null;
        }
        this.exoPlayerClazz = cls;
        this.setImageOutputMethod = method;
        this.imageOutput = objNewProxyInstance;
        ImageView imageView2 = (ImageView) findViewById(C1051R.id.exo_artwork);
        this.artworkView = imageView2;
        this.artworkDisplayMode = (!z12 || i17 == 0 || imageView2 == null) ? 0 : i17;
        if (i14 != 0) {
            this.defaultArtwork = AbstractC2115a.m5069b(getContext(), i14);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(C1051R.id.exo_subtitles);
        this.subtitleView = subtitleView;
        if (subtitleView != null) {
            subtitleView.setUserDefaultStyle();
            subtitleView.setUserDefaultTextSize();
        }
        View viewFindViewById2 = findViewById(C1051R.id.exo_buffering);
        this.bufferingView = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        this.showBuffering = i13;
        TextView textView = (TextView) findViewById(C1051R.id.exo_error_message);
        this.errorMessageView = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        PlayerControlView playerControlView = (PlayerControlView) findViewById(C1051R.id.exo_controller);
        View viewFindViewById3 = findViewById(C1051R.id.exo_controller_placeholder);
        if (playerControlView != null) {
            this.controller = playerControlView;
        } else if (viewFindViewById3 != null) {
            PlayerControlView playerControlView2 = new PlayerControlView(context, null, 0, attributeSet);
            this.controller = playerControlView2;
            playerControlView2.setId(C1051R.id.exo_controller);
            playerControlView2.setLayoutParams(viewFindViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById3.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById3);
            viewGroup.removeView(viewFindViewById3);
            viewGroup.addView(playerControlView2, iIndexOfChild);
        } else {
            this.controller = null;
        }
        PlayerControlView playerControlView3 = this.controller;
        this.controllerShowTimeoutMs = playerControlView3 != null ? i18 : 0;
        this.controllerHideOnTouch = z10;
        this.controllerAutoShow = z14;
        this.controllerHideDuringAds = z13;
        this.useController = z7 && playerControlView3 != null;
        if (playerControlView3 != null) {
            playerControlView3.hideImmediately();
            this.controller.addVisibilityListener(this.componentListener);
        }
        if (z7) {
            setClickable(true);
        }
        updateContentDescription();
    }

    @UnstableApi
    @Deprecated
    public void setControllerVisibilityListener(PlayerControlView.VisibilityListener visibilityListener) {
        Assertions.checkStateNotNull(this.controller);
        PlayerControlView.VisibilityListener visibilityListener2 = this.legacyControllerVisibilityListener;
        if (visibilityListener2 == visibilityListener) {
            return;
        }
        if (visibilityListener2 != null) {
            this.controller.removeVisibilityListener(visibilityListener2);
        }
        this.legacyControllerVisibilityListener = visibilityListener;
        if (visibilityListener != null) {
            this.controller.addVisibilityListener(visibilityListener);
            setControllerVisibilityListener((ControllerVisibilityListener) null);
        }
    }

    public static final class SurfaceSyncGroupCompatV34 {
        SurfaceSyncGroup surfaceSyncGroup;

        private SurfaceSyncGroupCompatV34() {
        }

        public void lambda$postRegister$1(SurfaceView surfaceView, Runnable runnable) {
            AttachedSurfaceControl rootSurfaceControl = surfaceView.getRootSurfaceControl();
            if (rootSurfaceControl == null) {
                return;
            }
            SurfaceSyncGroup surfaceSyncGroupM2729d = AbstractC1068m.m2729d();
            this.surfaceSyncGroup = surfaceSyncGroupM2729d;
            Assertions.checkState(surfaceSyncGroupM2729d.add(rootSurfaceControl, new RunnableC1070o()));
            runnable.run();
            rootSurfaceControl.applyTransactionOnDraw(AbstractC0819i.m2368h());
        }

        public void maybeMarkSyncReadyAndClear() {
            SurfaceSyncGroup surfaceSyncGroup = this.surfaceSyncGroup;
            if (surfaceSyncGroup != null) {
                surfaceSyncGroup.markSyncReady();
                this.surfaceSyncGroup = null;
            }
        }

        public void postRegister(Handler handler, final SurfaceView surfaceView, final Runnable runnable) {
            handler.post(new Runnable() {
                @Override
                public final void run() {
                    this.f3135a.lambda$postRegister$1(surfaceView, runnable);
                }
            });
        }

        public static void lambda$postRegister$0() {
        }
    }
}

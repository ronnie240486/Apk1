package androidx.media3.exoplayer.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import android.view.Display;
import android.view.Surface;
import androidx.media3.common.C0565C;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Timeline;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.MediaFormatUtil;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.AbstractC0947u0;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.mediacodec.AbstractC0816f;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecDecoderException;
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecRenderer;
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.flac.FlacConstants;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import androidx.media3.extractor.p010ts.TsExtractor;
import com.alibaba.fastjson.asm.Opcodes;
import com.google.common.util.concurrent.MoreExecutors;
import com.lzy.okgo.model.Progress;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.PriorityQueue;
import me.jessyan.autosize.BuildConfig;
import okio.Utf8;
import p041d7.AbstractC2301u1;
import p041d7.C2180c5;
import p041d7.C2204g1;

@UnstableApi
public class MediaCodecVideoRenderer extends MediaCodecRenderer implements VideoFrameReleaseControl.FrameTimingEvaluator {
    private static final int HEVC_MAX_INPUT_SIZE_THRESHOLD = 2097152;
    private static final float INITIAL_FORMAT_MAX_INPUT_SIZE_SCALE_FACTOR = 1.5f;
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int MAX_CONSECUTIVE_DROPPED_INPUT_BUFFERS_COUNT_TO_DISCARD_HEADER = 0;
    private static final long MIN_EARLY_US_LATE_THRESHOLD = -30000;
    private static final long MIN_EARLY_US_VERY_LATE_THRESHOLD = -500000;
    private static final long OFFSET_FROM_PERIOD_END_TO_TREAT_AS_LAST_US = 100000;
    private static final long OFFSET_FROM_RESET_POSITION_TO_ALLOW_INPUT_BUFFER_DROPPING_US = 200000;
    private static final int[] STANDARD_LONG_EDGE_VIDEO_PX = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static final String TAG = "MediaCodecVideoRenderer";
    private static final long TUNNELING_EOS_PRESENTATION_TIME_US = Long.MAX_VALUE;
    private static boolean deviceNeedsSetOutputSurfaceWorkaround;
    private static boolean evaluatedDeviceNeedsSetOutputSurfaceWorkaround;
    private final Av1SampleDependencyParser av1SampleDependencyParser;
    private int buffersInCodecCount;
    private int changeFrameRateStrategy;
    private boolean codecHandlesHdr10PlusOutOfBandMetadata;
    private CodecMaxValues codecMaxValues;
    private boolean codecNeedsSetOutputSurfaceWorkaround;
    private int consecutiveDroppedFrameCount;
    private int consecutiveDroppedInputBufferCount;
    private final Context context;
    private VideoSize decodedVideoSize;
    private final boolean deviceNeedsNoPostProcessWorkaround;
    private Surface displaySurface;
    private final PriorityQueue<Long> droppedDecoderInputBufferTimestamps;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    private VideoFrameMetadataListener frameMetadataListener;
    private boolean hasSetVideoSink;
    private boolean haveReportedFirstFrameRenderedForCurrentSurface;
    private long lastFrameReleaseTimeNs;
    private final int maxDroppedFramesToNotify;
    private final long minEarlyUsToDropDecoderInput;
    private Size outputResolution;
    private final boolean ownsVideoSink;
    private boolean pendingVideoSinkInputStreamChange;
    private long periodDurationUs;
    private PlaceholderSurface placeholderSurface;
    private int rendererPriority;
    private VideoSize reportedVideoSize;
    private int scalingMode;
    private boolean shouldDropDecoderInputBuffers;
    private long startPositionUs;
    private long totalVideoFrameProcessingOffsetUs;
    private boolean tunneling;
    private int tunnelingAudioSessionId;
    OnFrameRenderedListenerV23 tunnelingOnFrameRenderedListener;
    private List<Effect> videoEffects;
    private int videoFrameProcessingOffsetCount;
    private final VideoFrameReleaseControl videoFrameReleaseControl;
    private final VideoFrameReleaseControl.FrameReleaseInfo videoFrameReleaseInfo;
    private VideoSink videoSink;

    public static final class Api26 {
        private Api26() {
        }

        public static boolean doesDisplaySupportDolbyVision(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            Display display = displayManager != null ? displayManager.getDisplay(0) : null;
            if (display == null || !display.isHdr()) {
                return false;
            }
            for (int i6 : display.getHdrCapabilities().getSupportedHdrTypes()) {
                if (i6 == 1) {
                    return true;
                }
            }
            return false;
        }
    }

    public static final class Builder {
        private long allowedJoiningTimeMs;
        private boolean buildCalled;
        private MediaCodecAdapter.Factory codecAdapterFactory;
        private final Context context;
        private boolean enableDecoderFallback;
        private Handler eventHandler;
        private VideoRendererEventListener eventListener;
        private int maxDroppedFramesToNotify;
        private boolean parseAv1SampleDependencies;
        private VideoSink videoSink;
        private MediaCodecSelector mediaCodecSelector = MediaCodecSelector.DEFAULT;
        private float assumedMinimumCodecOperatingRate = 30.0f;
        private long lateThresholdToDropDecoderInputUs = C0565C.TIME_UNSET;

        public Builder(Context context) {
            this.context = context;
            this.codecAdapterFactory = AbstractC0816f.m2324a(context);
        }

        public MediaCodecVideoRenderer build() {
            Assertions.checkState(!this.buildCalled);
            Handler handler = this.eventHandler;
            Assertions.checkState((handler == null && this.eventListener == null) || !(handler == null || this.eventListener == null));
            this.buildCalled = true;
            return new MediaCodecVideoRenderer(this);
        }

        public Builder experimentalSetLateThresholdToDropDecoderInputUs(long j10) {
            this.lateThresholdToDropDecoderInputUs = j10;
            return this;
        }

        public Builder experimentalSetParseAv1SampleDependencies(boolean z7) {
            this.parseAv1SampleDependencies = z7;
            return this;
        }

        public Builder setAllowedJoiningTimeMs(long j10) {
            this.allowedJoiningTimeMs = j10;
            return this;
        }

        public Builder setAssumedMinimumCodecOperatingRate(float f) {
            this.assumedMinimumCodecOperatingRate = f;
            return this;
        }

        public Builder setCodecAdapterFactory(MediaCodecAdapter.Factory factory) {
            this.codecAdapterFactory = factory;
            return this;
        }

        public Builder setEnableDecoderFallback(boolean z7) {
            this.enableDecoderFallback = z7;
            return this;
        }

        public Builder setEventHandler(Handler handler) {
            this.eventHandler = handler;
            return this;
        }

        public Builder setEventListener(VideoRendererEventListener videoRendererEventListener) {
            this.eventListener = videoRendererEventListener;
            return this;
        }

        public Builder setMaxDroppedFramesToNotify(int i6) {
            this.maxDroppedFramesToNotify = i6;
            return this;
        }

        public Builder setMediaCodecSelector(MediaCodecSelector mediaCodecSelector) {
            this.mediaCodecSelector = mediaCodecSelector;
            return this;
        }

        public Builder setVideoSink(VideoSink videoSink) {
            this.videoSink = videoSink;
            return this;
        }
    }

    public static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int i6, int i10, int i11) {
            this.width = i6;
            this.height = i10;
            this.inputSize = i11;
        }
    }

    public final class OnFrameRenderedListenerV23 implements MediaCodecAdapter.OnFrameRenderedListener, Handler.Callback {
        private static final int HANDLE_FRAME_RENDERED = 0;
        private final Handler handler;

        public OnFrameRenderedListenerV23(MediaCodecAdapter mediaCodecAdapter) {
            Handler handlerCreateHandlerForCurrentLooper = Util.createHandlerForCurrentLooper(this);
            this.handler = handlerCreateHandlerForCurrentLooper;
            mediaCodecAdapter.setOnFrameRenderedListener(this, handlerCreateHandlerForCurrentLooper);
        }

        private void handleFrameRendered(long j10) {
            MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
            if (this != mediaCodecVideoRenderer.tunnelingOnFrameRenderedListener || mediaCodecVideoRenderer.getCodec() == null) {
                return;
            }
            if (j10 == Long.MAX_VALUE) {
                MediaCodecVideoRenderer.this.onProcessedTunneledEndOfStream();
                return;
            }
            try {
                MediaCodecVideoRenderer.this.onProcessedTunneledBuffer(j10);
            } catch (ExoPlaybackException e5) {
                MediaCodecVideoRenderer.this.setPendingPlaybackException(e5);
            }
        }

        @Override
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            handleFrameRendered(Util.toLong(message.arg1, message.arg2));
            return true;
        }

        @Override
        public void onFrameRendered(MediaCodecAdapter mediaCodecAdapter, long j10, long j11) {
            if (Util.SDK_INT >= 30) {
                handleFrameRendered(j10);
            } else {
                this.handler.sendMessageAtFrontOfQueue(Message.obtain(this.handler, 0, (int) (j10 >> 32), (int) j10));
            }
        }
    }

    @Deprecated
    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector) {
        this(new Builder(context).setMediaCodecSelector(mediaCodecSelector));
    }

    private static boolean deviceNeedsNoPostProcessWorkaround() {
        return "NVIDIA".equals(Build.MANUFACTURER);
    }

    private static boolean evaluateDeviceNeedsSetOutputSurfaceWorkaround() {
        byte b8 = 26;
        int i6 = Util.SDK_INT;
        if (i6 <= 28) {
            String str = Build.DEVICE;
            str.getClass();
            switch (str) {
                case "dangal":
                case "dangalFHD":
                case "dangalUHD":
                case "oneday":
                case "aquaman":
                case "magnolia":
                case "once":
                case "machuca":
                    return true;
            }
        }
        if (i6 <= 27 && "HWEML".equals(Build.DEVICE)) {
            return true;
        }
        String str2 = Build.MODEL;
        str2.getClass();
        switch (str2) {
            case "AFTJMST12":
            case "AFTKMST12":
            case "AFTA":
            case "AFTN":
            case "AFTR":
            case "AFTEU011":
            case "AFTEU014":
            case "AFTSO001":
            case "AFTEUFF014":
                return true;
            default:
                if (i6 <= 26) {
                    String str3 = Build.DEVICE;
                    str3.getClass();
                    switch (str3.hashCode()) {
                        case -2144781245:
                            if (!str3.equals("GIONEE_SWW1609")) {
                                b8 = -1;
                            } else {
                                b8 = 0;
                            }
                            break;
                        case -2144781185:
                            if (!str3.equals("GIONEE_SWW1627")) {
                                b8 = -1;
                            } else {
                                b8 = 1;
                            }
                            break;
                        case -2144781160:
                            if (!str3.equals("GIONEE_SWW1631")) {
                                b8 = -1;
                            } else {
                                b8 = 2;
                            }
                            break;
                        case -2097309513:
                            if (!str3.equals("K50a40")) {
                                b8 = -1;
                            } else {
                                b8 = 3;
                            }
                            break;
                        case -2022874474:
                            if (!str3.equals("CP8676_I02")) {
                                b8 = -1;
                            } else {
                                b8 = 4;
                            }
                            break;
                        case -1978993182:
                            if (!str3.equals("NX541J")) {
                                b8 = -1;
                            } else {
                                b8 = 5;
                            }
                            break;
                        case -1978990237:
                            if (!str3.equals("NX573J")) {
                                b8 = -1;
                            } else {
                                b8 = 6;
                            }
                            break;
                        case -1936688988:
                            if (!str3.equals("PGN528")) {
                                b8 = -1;
                            } else {
                                b8 = 7;
                            }
                            break;
                        case -1936688066:
                            if (!str3.equals("PGN610")) {
                                b8 = -1;
                            } else {
                                b8 = 8;
                            }
                            break;
                        case -1936688065:
                            if (!str3.equals("PGN611")) {
                                b8 = -1;
                            } else {
                                b8 = 9;
                            }
                            break;
                        case -1931988508:
                            if (!str3.equals("AquaPowerM")) {
                                b8 = -1;
                            } else {
                                b8 = 10;
                            }
                            break;
                        case -1885099851:
                            if (!str3.equals("RAIJIN")) {
                                b8 = -1;
                            } else {
                                b8 = 11;
                            }
                            break;
                        case -1696512866:
                            if (!str3.equals("XT1663")) {
                                b8 = -1;
                            } else {
                                b8 = 12;
                            }
                            break;
                        case -1680025915:
                            if (!str3.equals("ComioS1")) {
                                b8 = -1;
                            } else {
                                b8 = 13;
                            }
                            break;
                        case -1615810839:
                            if (!str3.equals("Phantom6")) {
                                b8 = -1;
                            } else {
                                b8 = 14;
                            }
                            break;
                        case -1600724499:
                            if (!str3.equals("pacificrim")) {
                                b8 = -1;
                            } else {
                                b8 = 15;
                            }
                            break;
                        case -1554255044:
                            if (!str3.equals("vernee_M5")) {
                                b8 = -1;
                            } else {
                                b8 = 16;
                            }
                            break;
                        case -1481772737:
                            if (!str3.equals("panell_dl")) {
                                b8 = -1;
                            } else {
                                b8 = 17;
                            }
                            break;
                        case -1481772730:
                            if (!str3.equals("panell_ds")) {
                                b8 = -1;
                            } else {
                                b8 = 18;
                            }
                            break;
                        case -1481772729:
                            if (!str3.equals("panell_dt")) {
                                b8 = -1;
                            } else {
                                b8 = 19;
                            }
                            break;
                        case -1320080169:
                            if (!str3.equals("GiONEE_GBL7319")) {
                                b8 = -1;
                            } else {
                                b8 = 20;
                            }
                            break;
                        case -1217592143:
                            if (!str3.equals("BRAVIA_ATV2")) {
                                b8 = -1;
                            } else {
                                b8 = 21;
                            }
                            break;
                        case -1180384755:
                            if (!str3.equals("iris60")) {
                                b8 = -1;
                            } else {
                                b8 = 22;
                            }
                            break;
                        case -1139198265:
                            if (!str3.equals("Slate_Pro")) {
                                b8 = -1;
                            } else {
                                b8 = 23;
                            }
                            break;
                        case -1052835013:
                            if (!str3.equals("namath")) {
                                b8 = -1;
                            } else {
                                b8 = 24;
                            }
                            break;
                        case -993250464:
                            if (!str3.equals("A10-70F")) {
                                b8 = -1;
                            } else {
                                b8 = 25;
                            }
                            break;
                        case -993250458:
                            if (!str3.equals("A10-70L")) {
                                b8 = -1;
                            }
                            break;
                        case -965403638:
                            if (!str3.equals("s905x018")) {
                                b8 = -1;
                            } else {
                                b8 = 27;
                            }
                            break;
                        case -958336948:
                            if (!str3.equals("ELUGA_Ray_X")) {
                                b8 = -1;
                            } else {
                                b8 = 28;
                            }
                            break;
                        case -879245230:
                            if (!str3.equals("tcl_eu")) {
                                b8 = -1;
                            } else {
                                b8 = 29;
                            }
                            break;
                        case -842500323:
                            if (!str3.equals("nicklaus_f")) {
                                b8 = -1;
                            } else {
                                b8 = 30;
                            }
                            break;
                        case -821392978:
                            if (!str3.equals("A7000-a")) {
                                b8 = -1;
                            } else {
                                b8 = 31;
                            }
                            break;
                        case -797483286:
                            if (!str3.equals("SVP-DTV15")) {
                                b8 = -1;
                            } else {
                                b8 = 32;
                            }
                            break;
                        case -794946968:
                            if (!str3.equals("watson")) {
                                b8 = -1;
                            } else {
                                b8 = 33;
                            }
                            break;
                        case -788334647:
                            if (!str3.equals("whyred")) {
                                b8 = -1;
                            } else {
                                b8 = 34;
                            }
                            break;
                        case -782144577:
                            if (!str3.equals("OnePlus5T")) {
                                b8 = -1;
                            } else {
                                b8 = 35;
                            }
                            break;
                        case -575125681:
                            if (!str3.equals("GiONEE_CBL7513")) {
                                b8 = -1;
                            } else {
                                b8 = 36;
                            }
                            break;
                        case -521118391:
                            if (!str3.equals("GIONEE_GBL7360")) {
                                b8 = -1;
                            } else {
                                b8 = 37;
                            }
                            break;
                        case -430914369:
                            if (!str3.equals("Pixi4-7_3G")) {
                                b8 = -1;
                            } else {
                                b8 = 38;
                            }
                            break;
                        case -290434366:
                            if (!str3.equals("taido_row")) {
                                b8 = -1;
                            } else {
                                b8 = 39;
                            }
                            break;
                        case -282781963:
                            if (!str3.equals("BLACK-1X")) {
                                b8 = -1;
                            } else {
                                b8 = 40;
                            }
                            break;
                        case -277133239:
                            if (!str3.equals("Z12_PRO")) {
                                b8 = -1;
                            } else {
                                b8 = 41;
                            }
                            break;
                        case -173639913:
                            if (!str3.equals("ELUGA_A3_Pro")) {
                                b8 = -1;
                            } else {
                                b8 = 42;
                            }
                            break;
                        case -56598463:
                            if (!str3.equals("woods_fn")) {
                                b8 = -1;
                            } else {
                                b8 = 43;
                            }
                            break;
                        case 2126:
                            if (!str3.equals("C1")) {
                                b8 = -1;
                            } else {
                                b8 = 44;
                            }
                            break;
                        case 2564:
                            if (!str3.equals("Q5")) {
                                b8 = -1;
                            } else {
                                b8 = 45;
                            }
                            break;
                        case 2715:
                            if (!str3.equals("V1")) {
                                b8 = -1;
                            } else {
                                b8 = 46;
                            }
                            break;
                        case 2719:
                            if (!str3.equals("V5")) {
                                b8 = -1;
                            } else {
                                b8 = 47;
                            }
                            break;
                        case 3091:
                            if (!str3.equals("b5")) {
                                b8 = -1;
                            } else {
                                b8 = 48;
                            }
                            break;
                        case 3483:
                            if (!str3.equals("mh")) {
                                b8 = -1;
                            } else {
                                b8 = 49;
                            }
                            break;
                        case 73405:
                            if (!str3.equals("JGZ")) {
                                b8 = -1;
                            } else {
                                b8 = 50;
                            }
                            break;
                        case 75537:
                            if (!str3.equals("M04")) {
                                b8 = -1;
                            } else {
                                b8 = 51;
                            }
                            break;
                        case 75739:
                            if (!str3.equals("M5c")) {
                                b8 = -1;
                            } else {
                                b8 = 52;
                            }
                            break;
                        case 76779:
                            if (!str3.equals("MX6")) {
                                b8 = -1;
                            } else {
                                b8 = 53;
                            }
                            break;
                        case 78669:
                            if (!str3.equals("P85")) {
                                b8 = -1;
                            } else {
                                b8 = 54;
                            }
                            break;
                        case 79305:
                            if (!str3.equals("PLE")) {
                                b8 = -1;
                            } else {
                                b8 = 55;
                            }
                            break;
                        case 80618:
                            if (!str3.equals("QX1")) {
                                b8 = -1;
                            } else {
                                b8 = 56;
                            }
                            break;
                        case 88274:
                            if (!str3.equals("Z80")) {
                                b8 = -1;
                            } else {
                                b8 = 57;
                            }
                            break;
                        case 98846:
                            if (!str3.equals("cv1")) {
                                b8 = -1;
                            } else {
                                b8 = 58;
                            }
                            break;
                        case 98848:
                            if (!str3.equals("cv3")) {
                                b8 = -1;
                            } else {
                                b8 = 59;
                            }
                            break;
                        case 99329:
                            if (!str3.equals("deb")) {
                                b8 = -1;
                            } else {
                                b8 = 60;
                            }
                            break;
                        case 101481:
                            if (!str3.equals("flo")) {
                                b8 = -1;
                            } else {
                                b8 = 61;
                            }
                            break;
                        case 1513190:
                            if (!str3.equals("1601")) {
                                b8 = -1;
                            } else {
                                b8 = 62;
                            }
                            break;
                        case 1514184:
                            if (!str3.equals("1713")) {
                                b8 = -1;
                            } else {
                                b8 = Utf8.REPLACEMENT_BYTE;
                            }
                            break;
                        case 1514185:
                            if (!str3.equals("1714")) {
                                b8 = -1;
                            } else {
                                b8 = 64;
                            }
                            break;
                        case 2133089:
                            if (!str3.equals("F01H")) {
                                b8 = -1;
                            } else {
                                b8 = 65;
                            }
                            break;
                        case 2133091:
                            if (!str3.equals("F01J")) {
                                b8 = -1;
                            } else {
                                b8 = 66;
                            }
                            break;
                        case 2133120:
                            if (!str3.equals("F02H")) {
                                b8 = -1;
                            } else {
                                b8 = 67;
                            }
                            break;
                        case 2133151:
                            if (!str3.equals("F03H")) {
                                b8 = -1;
                            } else {
                                b8 = 68;
                            }
                            break;
                        case 2133182:
                            if (!str3.equals("F04H")) {
                                b8 = -1;
                            } else {
                                b8 = 69;
                            }
                            break;
                        case 2133184:
                            if (!str3.equals("F04J")) {
                                b8 = -1;
                            } else {
                                b8 = 70;
                            }
                            break;
                        case 2436959:
                            if (!str3.equals("P681")) {
                                b8 = -1;
                            } else {
                                b8 = 71;
                            }
                            break;
                        case 2463773:
                            if (!str3.equals("Q350")) {
                                b8 = -1;
                            } else {
                                b8 = 72;
                            }
                            break;
                        case 2464648:
                            if (!str3.equals("Q427")) {
                                b8 = -1;
                            } else {
                                b8 = 73;
                            }
                            break;
                        case 2689555:
                            if (!str3.equals("XE2X")) {
                                b8 = -1;
                            } else {
                                b8 = 74;
                            }
                            break;
                        case 3154429:
                            if (!str3.equals("fugu")) {
                                b8 = -1;
                            } else {
                                b8 = 75;
                            }
                            break;
                        case 3284551:
                            if (!str3.equals("kate")) {
                                b8 = -1;
                            } else {
                                b8 = 76;
                            }
                            break;
                        case 3351335:
                            if (!str3.equals("mido")) {
                                b8 = -1;
                            } else {
                                b8 = 77;
                            }
                            break;
                        case 3386211:
                            if (!str3.equals("p212")) {
                                b8 = -1;
                            } else {
                                b8 = 78;
                            }
                            break;
                        case 41325051:
                            if (!str3.equals("MEIZU_M5")) {
                                b8 = -1;
                            } else {
                                b8 = 79;
                            }
                            break;
                        case 51349633:
                            if (!str3.equals("601LV")) {
                                b8 = -1;
                            } else {
                                b8 = 80;
                            }
                            break;
                        case 51350594:
                            if (!str3.equals("602LV")) {
                                b8 = -1;
                            } else {
                                b8 = 81;
                            }
                            break;
                        case 55178625:
                            if (!str3.equals("Aura_Note_2")) {
                                b8 = -1;
                            } else {
                                b8 = 82;
                            }
                            break;
                        case 61542055:
                            if (!str3.equals("A1601")) {
                                b8 = -1;
                            } else {
                                b8 = 83;
                            }
                            break;
                        case 65355429:
                            if (!str3.equals("E5643")) {
                                b8 = -1;
                            } else {
                                b8 = 84;
                            }
                            break;
                        case 66214468:
                            if (!str3.equals("F3111")) {
                                b8 = -1;
                            } else {
                                b8 = 85;
                            }
                            break;
                        case 66214470:
                            if (!str3.equals("F3113")) {
                                b8 = -1;
                            } else {
                                b8 = 86;
                            }
                            break;
                        case 66214473:
                            if (!str3.equals("F3116")) {
                                b8 = -1;
                            } else {
                                b8 = 87;
                            }
                            break;
                        case 66215429:
                            if (!str3.equals("F3211")) {
                                b8 = -1;
                            } else {
                                b8 = 88;
                            }
                            break;
                        case 66215431:
                            if (!str3.equals("F3213")) {
                                b8 = -1;
                            } else {
                                b8 = 89;
                            }
                            break;
                        case 66215433:
                            if (!str3.equals("F3215")) {
                                b8 = -1;
                            } else {
                                b8 = 90;
                            }
                            break;
                        case 66216390:
                            if (!str3.equals("F3311")) {
                                b8 = -1;
                            } else {
                                b8 = 91;
                            }
                            break;
                        case 76402249:
                            if (!str3.equals("PRO7S")) {
                                b8 = -1;
                            } else {
                                b8 = 92;
                            }
                            break;
                        case 76404105:
                            if (!str3.equals("Q4260")) {
                                b8 = -1;
                            } else {
                                b8 = 93;
                            }
                            break;
                        case 76404911:
                            if (!str3.equals("Q4310")) {
                                b8 = -1;
                            } else {
                                b8 = 94;
                            }
                            break;
                        case 80963634:
                            if (!str3.equals("V23GB")) {
                                b8 = -1;
                            } else {
                                b8 = 95;
                            }
                            break;
                        case 82882791:
                            if (!str3.equals("X3_HK")) {
                                b8 = -1;
                            } else {
                                b8 = 96;
                            }
                            break;
                        case 98715550:
                            if (!str3.equals("i9031")) {
                                b8 = -1;
                            } else {
                                b8 = 97;
                            }
                            break;
                        case 101370885:
                            if (!str3.equals("l5460")) {
                                b8 = -1;
                            } else {
                                b8 = 98;
                            }
                            break;
                        case 102844228:
                            if (!str3.equals("le_x6")) {
                                b8 = -1;
                            } else {
                                b8 = 99;
                            }
                            break;
                        case 165221241:
                            if (!str3.equals("A2016a40")) {
                                b8 = -1;
                            } else {
                                b8 = 100;
                            }
                            break;
                        case 182191441:
                            if (!str3.equals("CPY83_I00")) {
                                b8 = -1;
                            } else {
                                b8 = 101;
                            }
                            break;
                        case 245388979:
                            if (!str3.equals("marino_f")) {
                                b8 = -1;
                            } else {
                                b8 = 102;
                            }
                            break;
                        case 287431619:
                            if (!str3.equals("griffin")) {
                                b8 = -1;
                            } else {
                                b8 = 103;
                            }
                            break;
                        case 307593612:
                            if (!str3.equals("A7010a48")) {
                                b8 = -1;
                            } else {
                                b8 = 104;
                            }
                            break;
                        case 308517133:
                            if (!str3.equals("A7020a48")) {
                                b8 = -1;
                            } else {
                                b8 = 105;
                            }
                            break;
                        case 316215098:
                            if (!str3.equals("TB3-730F")) {
                                b8 = -1;
                            } else {
                                b8 = 106;
                            }
                            break;
                        case 316215116:
                            if (!str3.equals("TB3-730X")) {
                                b8 = -1;
                            } else {
                                b8 = 107;
                            }
                            break;
                        case 316246811:
                            if (!str3.equals("TB3-850F")) {
                                b8 = -1;
                            } else {
                                b8 = 108;
                            }
                            break;
                        case 316246818:
                            if (!str3.equals("TB3-850M")) {
                                b8 = -1;
                            } else {
                                b8 = 109;
                            }
                            break;
                        case 407160593:
                            if (!str3.equals("Pixi5-10_4G")) {
                                b8 = -1;
                            } else {
                                b8 = 110;
                            }
                            break;
                        case 507412548:
                            if (!str3.equals("QM16XE_U")) {
                                b8 = -1;
                            } else {
                                b8 = 111;
                            }
                            break;
                        case 793982701:
                            if (!str3.equals("GIONEE_WBL5708")) {
                                b8 = -1;
                            } else {
                                b8 = 112;
                            }
                            break;
                        case 794038622:
                            if (!str3.equals("GIONEE_WBL7365")) {
                                b8 = -1;
                            } else {
                                b8 = 113;
                            }
                            break;
                        case 794040393:
                            if (!str3.equals("GIONEE_WBL7519")) {
                                b8 = -1;
                            } else {
                                b8 = 114;
                            }
                            break;
                        case 835649806:
                            if (!str3.equals("manning")) {
                                b8 = -1;
                            } else {
                                b8 = 115;
                            }
                            break;
                        case 917340916:
                            if (!str3.equals("A7000plus")) {
                                b8 = -1;
                            } else {
                                b8 = 116;
                            }
                            break;
                        case 958008161:
                            if (!str3.equals("j2xlteins")) {
                                b8 = -1;
                            } else {
                                b8 = 117;
                            }
                            break;
                        case 1060579533:
                            if (!str3.equals("panell_d")) {
                                b8 = -1;
                            } else {
                                b8 = 118;
                            }
                            break;
                        case 1150207623:
                            if (!str3.equals("LS-5017")) {
                                b8 = -1;
                            } else {
                                b8 = 119;
                            }
                            break;
                        case 1176899427:
                            if (!str3.equals("itel_S41")) {
                                b8 = -1;
                            } else {
                                b8 = 120;
                            }
                            break;
                        case 1280332038:
                            if (!str3.equals("hwALE-H")) {
                                b8 = -1;
                            } else {
                                b8 = 121;
                            }
                            break;
                        case 1306947716:
                            if (!str3.equals("EverStar_S")) {
                                b8 = -1;
                            } else {
                                b8 = 122;
                            }
                            break;
                        case 1349174697:
                            if (!str3.equals("htc_e56ml_dtul")) {
                                b8 = -1;
                            } else {
                                b8 = 123;
                            }
                            break;
                        case 1522194893:
                            if (!str3.equals("woods_f")) {
                                b8 = -1;
                            } else {
                                b8 = 124;
                            }
                            break;
                        case 1691543273:
                            if (!str3.equals("CPH1609")) {
                                b8 = -1;
                            } else {
                                b8 = 125;
                            }
                            break;
                        case 1691544261:
                            if (!str3.equals("CPH1715")) {
                                b8 = -1;
                            } else {
                                b8 = 126;
                            }
                            break;
                        case 1709443163:
                            if (!str3.equals("iball8735_9806")) {
                                b8 = -1;
                            } else {
                                b8 = 127;
                            }
                            break;
                        case 1865889110:
                            if (!str3.equals("santoni")) {
                                b8 = -1;
                            } else {
                                b8 = 128;
                            }
                            break;
                        case 1906253259:
                            if (!str3.equals("PB2-670M")) {
                                b8 = -1;
                            } else {
                                b8 = 129;
                            }
                            break;
                        case 1977196784:
                            if (!str3.equals("Infinix-X572")) {
                                b8 = -1;
                            } else {
                                b8 = 130;
                            }
                            break;
                        case 2006372676:
                            if (!str3.equals("BRAVIA_ATV3_4K")) {
                                b8 = -1;
                            } else {
                                b8 = 131;
                            }
                            break;
                        case 2019281702:
                            if (!str3.equals("DM-01K")) {
                                b8 = -1;
                            } else {
                                b8 = 132;
                            }
                            break;
                        case 2029784656:
                            if (!str3.equals("HWBLN-H")) {
                                b8 = -1;
                            } else {
                                b8 = 133;
                            }
                            break;
                        case 2030379515:
                            if (!str3.equals("HWCAM-H")) {
                                b8 = -1;
                            } else {
                                b8 = 134;
                            }
                            break;
                        case 2033393791:
                            if (!str3.equals("ASUS_X00AD_2")) {
                                b8 = -1;
                            } else {
                                b8 = 135;
                            }
                            break;
                        case 2047190025:
                            if (!str3.equals("ELUGA_Note")) {
                                b8 = -1;
                            } else {
                                b8 = 136;
                            }
                            break;
                        case 2047252157:
                            if (!str3.equals("ELUGA_Prim")) {
                                b8 = -1;
                            } else {
                                b8 = 137;
                            }
                            break;
                        case 2048319463:
                            if (!str3.equals("HWVNS-H")) {
                                b8 = -1;
                            } else {
                                b8 = 138;
                            }
                            break;
                        case 2048855701:
                            if (!str3.equals("HWWAS-H")) {
                                b8 = -1;
                            } else {
                                b8 = 139;
                            }
                            break;
                        default:
                            b8 = -1;
                            break;
                    }
                    switch (b8) {
                        default:
                            str2.getClass();
                            if (!str2.equals("JSN-L21")) {
                            }
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case TsExtractor.TS_STREAM_TYPE_H265:
                        case 37:
                        case FlacConstants.STREAM_INFO_BLOCK_SIZE:
                        case NalUnitUtil.H265_NAL_UNIT_TYPE_PREFIX_SEI:
                        case NalUnitUtil.H265_NAL_UNIT_TYPE_SUFFIX_SEI:
                        case BuildConfig.VERSION_CODE:
                        case AacUtil.AUDIO_OBJECT_TYPE_AAC_XHE:
                        case 43:
                        case 44:
                        case TsExtractor.TS_STREAM_TYPE_MHAS:
                        case 46:
                        case 47:
                        case NalUnitUtil.H265_NAL_UNIT_TYPE_UNSPECIFIED:
                        case Opcodes.V1_5:
                        case DefaultRenderersFactory.MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY:
                        case 51:
                        case 52:
                        case 53:
                        case Opcodes.ISTORE:
                        case Opcodes.LSTORE:
                        case Opcodes.FSTORE:
                        case Opcodes.DSTORE:
                        case Opcodes.ASTORE:
                        case 59:
                        case 60:
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                        case 65:
                        case 66:
                        case MdtaMetadataEntry.TYPE_INDICATOR_INT32:
                        case 68:
                        case 69:
                        case 70:
                        case TsExtractor.TS_SYNC_BYTE:
                        case 72:
                        case 73:
                        case 74:
                        case MdtaMetadataEntry.TYPE_INDICATOR_8_BIT_UNSIGNED_INT:
                        case 76:
                        case 77:
                        case MdtaMetadataEntry.TYPE_INDICATOR_UNSIGNED_INT64:
                        case Opcodes.IASTORE:
                        case 80:
                        case 81:
                        case 82:
                        case 83:
                        case 84:
                        case 85:
                        case 86:
                        case Opcodes.POP:
                        case 88:
                        case 89:
                        case 90:
                        case 91:
                        case 92:
                        case 93:
                        case 94:
                        case 95:
                        case Opcodes.IADD:
                        case 97:
                        case 98:
                        case 99:
                        case 100:
                        case 101:
                        case 102:
                        case 103:
                        case 104:
                        case 105:
                        case 106:
                        case 107:
                        case 108:
                        case 109:
                        case 110:
                        case 111:
                        case 112:
                        case 113:
                        case 114:
                        case 115:
                        case AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID:
                        case 117:
                        case 118:
                        case 119:
                        case 120:
                        case 121:
                        case 122:
                        case 123:
                        case 124:
                        case 125:
                        case 126:
                        case 127:
                        case 128:
                        case TsExtractor.TS_STREAM_TYPE_AC3:
                        case TsExtractor.TS_STREAM_TYPE_HDMV_DTS:
                        case 131:
                        case 132:
                        case 133:
                        case TsExtractor.TS_STREAM_TYPE_SPLICE_INFO:
                        case TsExtractor.TS_STREAM_TYPE_E_AC3:
                        case TsExtractor.TS_STREAM_TYPE_DTS_HD:
                        case 137:
                        case TsExtractor.TS_STREAM_TYPE_DTS:
                        case TsExtractor.TS_STREAM_TYPE_DTS_UHD:
                            return true;
                    }
                }
                return false;
        }
    }

    public static int getCodecMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        byte b8 = 1;
        int i6 = format.width;
        int i10 = format.height;
        if (i6 == -1 || i10 == -1) {
            return -1;
        }
        String str = (String) Assertions.checkNotNull(format.sampleMimeType);
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(str)) {
            Pair<Integer, Integer> codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format);
            if (codecProfileAndLevel == null) {
                str = MimeTypes.VIDEO_H265;
            } else {
                int iIntValue = ((Integer) codecProfileAndLevel.first).intValue();
                if (iIntValue == 512 || iIntValue == 1 || iIntValue == 2) {
                    str = MimeTypes.VIDEO_H264;
                } else if (iIntValue == 1024) {
                    str = MimeTypes.VIDEO_AV1;
                } else {
                    str = MimeTypes.VIDEO_H265;
                }
            }
        }
        str.getClass();
        switch (str.hashCode()) {
            case -1664118616:
                if (!str.equals(MimeTypes.VIDEO_H263)) {
                    b8 = -1;
                } else {
                    b8 = 0;
                }
                break;
            case -1662735862:
                if (!str.equals(MimeTypes.VIDEO_AV1)) {
                    b8 = -1;
                }
                break;
            case -1662541442:
                if (!str.equals(MimeTypes.VIDEO_H265)) {
                    b8 = -1;
                } else {
                    b8 = 2;
                }
                break;
            case 1187890754:
                if (!str.equals(MimeTypes.VIDEO_MP4V)) {
                    b8 = -1;
                } else {
                    b8 = 3;
                }
                break;
            case 1331836730:
                if (!str.equals(MimeTypes.VIDEO_H264)) {
                    b8 = -1;
                } else {
                    b8 = 4;
                }
                break;
            case 1599127256:
                if (!str.equals(MimeTypes.VIDEO_VP8)) {
                    b8 = -1;
                } else {
                    b8 = 5;
                }
                break;
            case 1599127257:
                if (!str.equals(MimeTypes.VIDEO_VP9)) {
                    b8 = -1;
                } else {
                    b8 = 6;
                }
                break;
            default:
                b8 = -1;
                break;
        }
        switch (b8) {
            case 0:
            case 1:
            case 3:
            case 5:
                return getMaxSampleSize(i6 * i10, 2);
            case 2:
                return Math.max(HEVC_MAX_INPUT_SIZE_THRESHOLD, getMaxSampleSize(i6 * i10, 2));
            case 4:
                String str2 = Build.MODEL;
                if ("BRAVIA 4K 2015".equals(str2) || ("Amazon".equals(Build.MANUFACTURER) && ("KFSOWI".equals(str2) || ("AFTS".equals(str2) && mediaCodecInfo.secure)))) {
                    return -1;
                }
                return getMaxSampleSize(Util.ceilDivide(i10, 16) * Util.ceilDivide(i6, 16) * 256, 2);
            case 6:
                return getMaxSampleSize(i6 * i10, 4);
            default:
                return -1;
        }
    }

    private static Point getCodecMaxSize(MediaCodecInfo mediaCodecInfo, Format format) {
        int i6 = format.height;
        int i10 = format.width;
        boolean z7 = i6 > i10;
        int i11 = z7 ? i6 : i10;
        if (z7) {
            i6 = i10;
        }
        float f = i6 / i11;
        for (int i12 : STANDARD_LONG_EDGE_VIDEO_PX) {
            int i13 = (int) (i12 * f);
            if (i12 <= i11 || i13 <= i6) {
                break;
            }
            int i14 = z7 ? i13 : i12;
            if (!z7) {
                i12 = i13;
            }
            Point pointAlignVideoSizeV21 = mediaCodecInfo.alignVideoSizeV21(i14, i12);
            float f3 = format.frameRate;
            if (pointAlignVideoSizeV21 != null && mediaCodecInfo.isVideoSizeAndRateSupportedV21(pointAlignVideoSizeV21.x, pointAlignVideoSizeV21.y, f3)) {
                return pointAlignVideoSizeV21;
            }
        }
        return null;
    }

    public static int getMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        if (format.maxInputSize == -1) {
            return getCodecMaxInputSize(mediaCodecInfo, format);
        }
        int size = format.initializationData.size();
        int length = 0;
        for (int i6 = 0; i6 < size; i6++) {
            length += format.initializationData.get(i6).length;
        }
        return format.maxInputSize + length;
    }

    private static int getMaxSampleSize(int i6, int i10) {
        return (i6 * 3) / (i10 * 2);
    }

    private Surface getSurfaceForCodec(MediaCodecInfo mediaCodecInfo) {
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            return videoSink.getInputSurface();
        }
        Surface surface = this.displaySurface;
        if (surface != null) {
            return surface;
        }
        if (shouldUseDetachedSurface(mediaCodecInfo)) {
            return null;
        }
        Assertions.checkState(shouldUsePlaceholderSurface(mediaCodecInfo));
        PlaceholderSurface placeholderSurface = this.placeholderSurface;
        if (placeholderSurface != null && placeholderSurface.secure != mediaCodecInfo.secure) {
            releasePlaceholderSurface();
        }
        if (this.placeholderSurface == null) {
            this.placeholderSurface = PlaceholderSurface.newInstance(this.context, mediaCodecInfo.secure);
        }
        return this.placeholderSurface;
    }

    private boolean hasSurfaceForCodec(MediaCodecInfo mediaCodecInfo) {
        Surface surface;
        return this.videoSink != null || ((surface = this.displaySurface) != null && surface.isValid()) || shouldUseDetachedSurface(mediaCodecInfo) || shouldUsePlaceholderSurface(mediaCodecInfo);
    }

    private boolean isBufferBeforeStartTime(DecoderInputBuffer decoderInputBuffer) {
        return decoderInputBuffer.timeUs < getLastResetPositionUs();
    }

    private boolean isBufferProbablyLastSample(DecoderInputBuffer decoderInputBuffer) {
        if (hasReadStreamToEnd() || decoderInputBuffer.isLastSample() || this.periodDurationUs == C0565C.TIME_UNSET) {
            return true;
        }
        return this.periodDurationUs - (decoderInputBuffer.timeUs - getOutputStreamOffsetUs()) <= 100000;
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long jElapsedRealtime = getClock().elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, jElapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = jElapsedRealtime;
        }
    }

    private void maybeNotifyRenderedFirstFrame() {
        if (!this.videoFrameReleaseControl.onFrameReleasedIsFirstFrame() || this.displaySurface == null) {
            return;
        }
        notifyRenderedFirstFrame();
    }

    private void maybeNotifyVideoFrameProcessingOffset() {
        int i6 = this.videoFrameProcessingOffsetCount;
        if (i6 != 0) {
            this.eventDispatcher.reportVideoFrameProcessingOffset(this.totalVideoFrameProcessingOffsetUs, i6);
            this.totalVideoFrameProcessingOffsetUs = 0L;
            this.videoFrameProcessingOffsetCount = 0;
        }
    }

    private void maybeNotifyVideoSizeChanged(VideoSize videoSize) {
        if (videoSize.equals(VideoSize.UNKNOWN) || videoSize.equals(this.reportedVideoSize)) {
            return;
        }
        this.reportedVideoSize = videoSize;
        this.eventDispatcher.videoSizeChanged(videoSize);
    }

    private void maybeRenotifyRenderedFirstFrame() {
        Surface surface = this.displaySurface;
        if (surface == null || !this.haveReportedFirstFrameRenderedForCurrentSurface) {
            return;
        }
        this.eventDispatcher.renderedFirstFrame(surface);
    }

    private void maybeRenotifyVideoSizeChanged() {
        VideoSize videoSize = this.reportedVideoSize;
        if (videoSize != null) {
            this.eventDispatcher.videoSizeChanged(videoSize);
        }
    }

    private void maybeSetKeyAllowFrameDrop(MediaFormat mediaFormat) {
        if (this.videoSink == null || Util.isFrameDropAllowedOnSurfaceInput(this.context)) {
            return;
        }
        mediaFormat.setInteger("allow-frame-drop", 0);
    }

    private void maybeSetupTunnelingForFirstFrame() {
        int i6;
        MediaCodecAdapter codec;
        if (!this.tunneling || (i6 = Util.SDK_INT) < 23 || (codec = getCodec()) == null) {
            return;
        }
        this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(codec);
        if (i6 >= 33) {
            Bundle bundle = new Bundle();
            bundle.putInt("tunnel-peek", 1);
            codec.setParameters(bundle);
        }
    }

    private void notifyFrameMetadataListener(long j10, long j11, Format format) {
        VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j10, j11, format, getCodecOutputMediaFormat());
        }
    }

    public void notifyRenderedFirstFrame() {
        this.eventDispatcher.renderedFirstFrame(this.displaySurface);
        this.haveReportedFirstFrameRenderedForCurrentSurface = true;
    }

    public void onProcessedTunneledEndOfStream() {
        setPendingOutputEndOfStream();
    }

    private void releaseFrame(MediaCodecAdapter mediaCodecAdapter, int i6, long j10, Format format) {
        long releaseTimeNs = this.videoFrameReleaseInfo.getReleaseTimeNs();
        long earlyUs = this.videoFrameReleaseInfo.getEarlyUs();
        if (shouldSkipBuffersWithIdenticalReleaseTime() && releaseTimeNs == this.lastFrameReleaseTimeNs) {
            skipOutputBuffer(mediaCodecAdapter, i6, j10);
        } else {
            notifyFrameMetadataListener(j10, releaseTimeNs, format);
            renderOutputBufferV21(mediaCodecAdapter, i6, j10, releaseTimeNs);
        }
        updateVideoFrameProcessingOffsetCounters(earlyUs);
        this.lastFrameReleaseTimeNs = releaseTimeNs;
    }

    private void releasePlaceholderSurface() {
        PlaceholderSurface placeholderSurface = this.placeholderSurface;
        if (placeholderSurface != null) {
            placeholderSurface.release();
            this.placeholderSurface = null;
        }
    }

    public void renderOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i6, long j10, long j11) {
        renderOutputBufferV21(mediaCodecAdapter, i6, j10, j11);
    }

    private static void setHdr10PlusInfoV29(MediaCodecAdapter mediaCodecAdapter, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        mediaCodecAdapter.setParameters(bundle);
    }

    private void setOutput(Object obj) throws ExoPlaybackException {
        Surface surface = obj instanceof Surface ? (Surface) obj : null;
        if (this.displaySurface == surface) {
            if (surface != null) {
                maybeRenotifyVideoSizeChanged();
                maybeRenotifyRenderedFirstFrame();
                return;
            }
            return;
        }
        this.displaySurface = surface;
        if (this.videoSink == null) {
            this.videoFrameReleaseControl.setOutputSurface(surface);
        }
        this.haveReportedFirstFrameRenderedForCurrentSurface = false;
        int state = getState();
        MediaCodecAdapter codec = getCodec();
        if (codec != null && this.videoSink == null) {
            MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) Assertions.checkNotNull(getCodecInfo());
            boolean zHasSurfaceForCodec = hasSurfaceForCodec(mediaCodecInfo);
            if (Util.SDK_INT < 23 || !zHasSurfaceForCodec || this.codecNeedsSetOutputSurfaceWorkaround) {
                releaseCodec();
                maybeInitCodecOrBypass();
            } else {
                setOutputSurface(codec, getSurfaceForCodec(mediaCodecInfo));
            }
        }
        if (surface != null) {
            maybeRenotifyVideoSizeChanged();
        } else {
            this.reportedVideoSize = null;
            VideoSink videoSink = this.videoSink;
            if (videoSink != null) {
                videoSink.clearOutputSurfaceInfo();
            }
        }
        if (state == 2) {
            VideoSink videoSink2 = this.videoSink;
            if (videoSink2 != null) {
                videoSink2.join(true);
            } else {
                this.videoFrameReleaseControl.join(true);
            }
        }
        maybeSetupTunnelingForFirstFrame();
    }

    private void setOutputSurface(MediaCodecAdapter mediaCodecAdapter, Surface surface) {
        int i6 = Util.SDK_INT;
        if (i6 >= 23 && surface != null) {
            setOutputSurfaceV23(mediaCodecAdapter, surface);
        } else {
            if (i6 < 35) {
                throw new IllegalStateException();
            }
            detachOutputSurfaceV35(mediaCodecAdapter);
        }
    }

    public static int supportsFormat(Context context, MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        return supportsFormatInternal(context, mediaCodecSelector, format);
    }

    private static int supportsFormatInternal(Context context, MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        boolean z7;
        int i6 = 0;
        if (!MimeTypes.isVideo(format.sampleMimeType)) {
            return AbstractC0947u0.m2577c(0);
        }
        boolean z10 = format.drmInitData != null;
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(context, mediaCodecSelector, format, z10, false);
        if (z10 && decoderInfos.isEmpty()) {
            decoderInfos = getDecoderInfos(context, mediaCodecSelector, format, false, false);
        }
        if (decoderInfos.isEmpty()) {
            return AbstractC0947u0.m2577c(1);
        }
        if (!MediaCodecRenderer.supportsFormatDrm(format)) {
            return AbstractC0947u0.m2577c(2);
        }
        MediaCodecInfo mediaCodecInfo = decoderInfos.get(0);
        boolean zIsFormatSupported = mediaCodecInfo.isFormatSupported(format);
        if (!zIsFormatSupported) {
            int i10 = 1;
            while (true) {
                if (i10 >= decoderInfos.size()) {
                    z7 = true;
                    break;
                }
                MediaCodecInfo mediaCodecInfo2 = decoderInfos.get(i10);
                if (mediaCodecInfo2.isFormatSupported(format)) {
                    mediaCodecInfo = mediaCodecInfo2;
                    z7 = false;
                    zIsFormatSupported = true;
                    break;
                }
                i10++;
            }
        } else {
            z7 = true;
            break;
        }
        int i11 = zIsFormatSupported ? 4 : 3;
        int i12 = mediaCodecInfo.isSeamlessAdaptationSupported(format) ? 16 : 8;
        int i13 = mediaCodecInfo.hardwareAccelerated ? 64 : 0;
        int i14 = z7 ? 128 : 0;
        if (Util.SDK_INT >= 26 && MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType) && !Api26.doesDisplaySupportDolbyVision(context)) {
            i14 = 256;
        }
        if (zIsFormatSupported) {
            List<MediaCodecInfo> decoderInfos2 = getDecoderInfos(context, mediaCodecSelector, format, z10, true);
            if (!decoderInfos2.isEmpty()) {
                MediaCodecInfo mediaCodecInfo3 = MediaCodecUtil.getDecoderInfosSortedByFormatSupport(decoderInfos2, format).get(0);
                if (mediaCodecInfo3.isFormatSupported(format) && mediaCodecInfo3.isSeamlessAdaptationSupported(format)) {
                    i6 = 32;
                }
            }
        }
        return AbstractC0947u0.m2580f(i11, i12, i6, i13, i14);
    }

    private void updateCodecImportance() {
        MediaCodecAdapter codec = getCodec();
        if (codec != null && Util.SDK_INT >= 35) {
            Bundle bundle = new Bundle();
            bundle.putInt("importance", Math.max(0, -this.rendererPriority));
            codec.setParameters(bundle);
        }
    }

    private void updateDroppedBufferCountersWithInputBuffers(long j10) {
        int i6 = 0;
        while (true) {
            Long lPeek = this.droppedDecoderInputBufferTimestamps.peek();
            if (lPeek == null || lPeek.longValue() >= j10) {
                break;
            }
            i6++;
            this.droppedDecoderInputBufferTimestamps.poll();
        }
        updateDroppedBufferCounters(i6, 0);
    }

    private void updatePeriodDurationUs(MediaSource.MediaPeriodId mediaPeriodId) {
        Timeline timeline = getTimeline();
        if (timeline.isEmpty()) {
            this.periodDurationUs = C0565C.TIME_UNSET;
        } else {
            this.periodDurationUs = timeline.getPeriodByUid(((MediaSource.MediaPeriodId) Assertions.checkNotNull(mediaPeriodId)).periodUid, new Timeline.Period()).getDurationUs();
        }
    }

    @Override
    public DecoderReuseEvaluation canReuseCodec(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        DecoderReuseEvaluation decoderReuseEvaluationCanReuseCodec = mediaCodecInfo.canReuseCodec(format, format2);
        int i6 = decoderReuseEvaluationCanReuseCodec.discardReasons;
        CodecMaxValues codecMaxValues = (CodecMaxValues) Assertions.checkNotNull(this.codecMaxValues);
        if (format2.width > codecMaxValues.width || format2.height > codecMaxValues.height) {
            i6 |= 256;
        }
        if (getMaxInputSize(mediaCodecInfo, format2) > codecMaxValues.inputSize) {
            i6 |= 64;
        }
        int i10 = i6;
        return new DecoderReuseEvaluation(mediaCodecInfo.name, format, format2, i10 != 0 ? 0 : decoderReuseEvaluationCanReuseCodec.result, i10);
    }

    public void changeVideoSinkInputStream(VideoSink videoSink, int i6, Format format) {
        List<Effect> list = this.videoEffects;
        if (list == null) {
            C2204g1 c2204g1 = AbstractC2301u1.f8069b;
            list = C2180c5.f7862e;
        }
        videoSink.onInputStreamChanged(i6, format, list);
    }

    public boolean codecNeedsSetOutputSurfaceWorkaround(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (MediaCodecVideoRenderer.class) {
            try {
                if (!evaluatedDeviceNeedsSetOutputSurfaceWorkaround) {
                    deviceNeedsSetOutputSurfaceWorkaround = evaluateDeviceNeedsSetOutputSurfaceWorkaround();
                    evaluatedDeviceNeedsSetOutputSurfaceWorkaround = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return deviceNeedsSetOutputSurfaceWorkaround;
    }

    @Override
    public MediaCodecDecoderException createDecoderException(Throwable th, MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecVideoDecoderException(th, mediaCodecInfo, this.displaySurface);
    }

    public void detachOutputSurfaceV35(MediaCodecAdapter mediaCodecAdapter) {
        mediaCodecAdapter.detachOutputSurface();
    }

    public void dropOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i6, long j10) {
        TraceUtil.beginSection("dropVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i6, false);
        TraceUtil.endSection();
        updateDroppedBufferCounters(0, 1);
    }

    @Override
    public void enableMayRenderStartOfStream() {
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.enableMayRenderStartOfStream();
        } else {
            this.videoFrameReleaseControl.allowReleaseFirstFrameBeforeStarted();
        }
    }

    public long getBufferTimestampAdjustmentUs() {
        return -this.startPositionUs;
    }

    @Override
    public int getCodecBufferFlags(DecoderInputBuffer decoderInputBuffer) {
        return (Util.SDK_INT >= 34 && this.tunneling && isBufferBeforeStartTime(decoderInputBuffer)) ? 32 : 0;
    }

    public CodecMaxValues getCodecMaxValues(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        int codecMaxInputSize;
        int iMax = format.width;
        int iMax2 = format.height;
        int maxInputSize = getMaxInputSize(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            if (maxInputSize != -1 && (codecMaxInputSize = getCodecMaxInputSize(mediaCodecInfo, format)) != -1) {
                maxInputSize = Math.min((int) (maxInputSize * INITIAL_FORMAT_MAX_INPUT_SIZE_SCALE_FACTOR), codecMaxInputSize);
            }
            return new CodecMaxValues(iMax, iMax2, maxInputSize);
        }
        int length = formatArr.length;
        boolean z7 = false;
        for (int i6 = 0; i6 < length; i6++) {
            Format formatBuild = formatArr[i6];
            if (format.colorInfo != null && formatBuild.colorInfo == null) {
                formatBuild = formatBuild.buildUpon().setColorInfo(format.colorInfo).build();
            }
            if (mediaCodecInfo.canReuseCodec(format, formatBuild).result != 0) {
                int i10 = formatBuild.width;
                z7 |= i10 == -1 || formatBuild.height == -1;
                iMax = Math.max(iMax, i10);
                iMax2 = Math.max(iMax2, formatBuild.height);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(mediaCodecInfo, formatBuild));
            }
        }
        if (z7) {
            Log.m1719w(TAG, "Resolutions unknown. Codec max resolution: " + iMax + "x" + iMax2);
            Point codecMaxSize = getCodecMaxSize(mediaCodecInfo, format);
            if (codecMaxSize != null) {
                iMax = Math.max(iMax, codecMaxSize.x);
                iMax2 = Math.max(iMax2, codecMaxSize.y);
                maxInputSize = Math.max(maxInputSize, getCodecMaxInputSize(mediaCodecInfo, format.buildUpon().setWidth(iMax).setHeight(iMax2).build()));
                Log.m1719w(TAG, "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
            }
        }
        return new CodecMaxValues(iMax, iMax2, maxInputSize);
    }

    @Override
    public boolean getCodecNeedsEosPropagation() {
        return this.tunneling && Util.SDK_INT < 23;
    }

    @Override
    public float getCodecOperatingRateV23(float f, Format format, Format[] formatArr) {
        float fMax = -1.0f;
        for (Format format2 : formatArr) {
            float f3 = format2.frameRate;
            if (f3 != -1.0f) {
                fMax = Math.max(fMax, f3);
            }
        }
        if (fMax == -1.0f) {
            return -1.0f;
        }
        return fMax * f;
    }

    @Override
    public List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z7) throws MediaCodecUtil.DecoderQueryException {
        return MediaCodecUtil.getDecoderInfosSortedByFormatSupport(getDecoderInfos(this.context, mediaCodecSelector, format, z7, this.tunneling), format);
    }

    @Override
    public MediaCodecAdapter.Configuration getMediaCodecConfiguration(MediaCodecInfo mediaCodecInfo, Format format, MediaCrypto mediaCrypto, float f) {
        String str = mediaCodecInfo.codecMimeType;
        CodecMaxValues codecMaxValues = getCodecMaxValues(mediaCodecInfo, format, getStreamFormats());
        this.codecMaxValues = codecMaxValues;
        MediaFormat mediaFormat = getMediaFormat(format, str, codecMaxValues, f, this.deviceNeedsNoPostProcessWorkaround, this.tunneling ? this.tunnelingAudioSessionId : 0);
        Surface surfaceForCodec = getSurfaceForCodec(mediaCodecInfo);
        maybeSetKeyAllowFrameDrop(mediaFormat);
        return MediaCodecAdapter.Configuration.createForVideoDecoding(mediaCodecInfo, mediaFormat, format, surfaceForCodec, mediaCrypto);
    }

    @SuppressLint({"InlinedApi"})
    public MediaFormat getMediaFormat(Format format, String str, CodecMaxValues codecMaxValues, float f, boolean z7, int i6) {
        Pair<Integer, Integer> codecProfileAndLevel;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", format.width);
        mediaFormat.setInteger("height", format.height);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetFloat(mediaFormat, "frame-rate", format.frameRate);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "rotation-degrees", format.rotationDegrees);
        MediaFormatUtil.maybeSetColorInfo(mediaFormat, format.colorInfo);
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType) && (codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format)) != null) {
            MediaFormatUtil.maybeSetInteger(mediaFormat, "profile", ((Integer) codecProfileAndLevel.first).intValue());
        }
        mediaFormat.setInteger("max-width", codecMaxValues.width);
        mediaFormat.setInteger("max-height", codecMaxValues.height);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", codecMaxValues.inputSize);
        int i10 = Util.SDK_INT;
        if (i10 >= 23) {
            mediaFormat.setInteger(Progress.PRIORITY, 0);
            if (f != -1.0f) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (z7) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i6 != 0) {
            mediaFormat.setFeatureEnabled("tunneled-playback", true);
            mediaFormat.setInteger("audio-session-id", i6);
        }
        if (i10 >= 35) {
            mediaFormat.setInteger("importance", Math.max(0, -this.rendererPriority));
        }
        return mediaFormat;
    }

    @Override
    public String getName() {
        return TAG;
    }

    public Surface getSurface() {
        return this.displaySurface;
    }

    @Override
    @TargetApi(29)
    public void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (this.codecHandlesHdr10PlusOutOfBandMetadata) {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(decoderInputBuffer.supplementalData);
            if (byteBuffer.remaining() >= 7) {
                byte b8 = byteBuffer.get();
                short s10 = byteBuffer.getShort();
                short s11 = byteBuffer.getShort();
                byte b10 = byteBuffer.get();
                byte b11 = byteBuffer.get();
                byteBuffer.position(0);
                if (b8 == -75 && s10 == 60 && s11 == 1 && b10 == 4) {
                    if (b11 == 0 || b11 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        setHdr10PlusInfoV29((MediaCodecAdapter) Assertions.checkNotNull(getCodec()), bArr);
                    }
                }
            }
        }
    }

    @Override
    public void handleMessage(int i6, Object obj) throws ExoPlaybackException {
        if (i6 == 1) {
            setOutput(obj);
            return;
        }
        if (i6 == 7) {
            VideoFrameMetadataListener videoFrameMetadataListener = (VideoFrameMetadataListener) Assertions.checkNotNull(obj);
            this.frameMetadataListener = videoFrameMetadataListener;
            VideoSink videoSink = this.videoSink;
            if (videoSink != null) {
                videoSink.setVideoFrameMetadataListener(videoFrameMetadataListener);
                return;
            }
            return;
        }
        if (i6 == 10) {
            int iIntValue = ((Integer) Assertions.checkNotNull(obj)).intValue();
            if (this.tunnelingAudioSessionId != iIntValue) {
                this.tunnelingAudioSessionId = iIntValue;
                if (this.tunneling) {
                    releaseCodec();
                    return;
                }
                return;
            }
            return;
        }
        if (i6 == 4) {
            this.scalingMode = ((Integer) Assertions.checkNotNull(obj)).intValue();
            MediaCodecAdapter codec = getCodec();
            if (codec != null) {
                codec.setVideoScalingMode(this.scalingMode);
                return;
            }
            return;
        }
        if (i6 == 5) {
            int iIntValue2 = ((Integer) Assertions.checkNotNull(obj)).intValue();
            this.changeFrameRateStrategy = iIntValue2;
            VideoSink videoSink2 = this.videoSink;
            if (videoSink2 != null) {
                videoSink2.setChangeFrameRateStrategy(iIntValue2);
                return;
            } else {
                this.videoFrameReleaseControl.setChangeFrameRateStrategy(iIntValue2);
                return;
            }
        }
        if (i6 == 13) {
            setVideoEffects((List) Assertions.checkNotNull(obj));
            return;
        }
        if (i6 == 14) {
            Size size = (Size) Assertions.checkNotNull(obj);
            if (size.getWidth() == 0 || size.getHeight() == 0) {
                return;
            }
            this.outputResolution = size;
            VideoSink videoSink3 = this.videoSink;
            if (videoSink3 != null) {
                videoSink3.setOutputSurfaceInfo((Surface) Assertions.checkStateNotNull(this.displaySurface), size);
                return;
            }
            return;
        }
        if (i6 == 16) {
            this.rendererPriority = ((Integer) Assertions.checkNotNull(obj)).intValue();
            updateCodecImportance();
        } else {
            if (i6 != 17) {
                super.handleMessage(i6, obj);
                return;
            }
            Surface surface = this.displaySurface;
            setOutput(null);
            ((MediaCodecVideoRenderer) Assertions.checkNotNull(obj)).handleMessage(1, surface);
        }
    }

    @Override
    public boolean isEnded() {
        VideoSink videoSink;
        return super.isEnded() && ((videoSink = this.videoSink) == null || videoSink.isEnded());
    }

    @Override
    public boolean isReady() {
        boolean zIsReady = super.isReady();
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            return videoSink.isReady(zIsReady);
        }
        if (zIsReady && (getCodec() == null || this.tunneling)) {
            return true;
        }
        return this.videoFrameReleaseControl.isReady(zIsReady);
    }

    public boolean maybeDropBuffersToKeyframe(long j10, boolean z7) throws ExoPlaybackException {
        int iSkipSource = skipSource(j10);
        if (iSkipSource == 0) {
            return false;
        }
        if (z7) {
            DecoderCounters decoderCounters = this.decoderCounters;
            int i6 = decoderCounters.skippedInputBufferCount + iSkipSource;
            decoderCounters.skippedInputBufferCount = i6;
            decoderCounters.skippedOutputBufferCount += this.buffersInCodecCount;
            decoderCounters.skippedInputBufferCount = this.droppedDecoderInputBufferTimestamps.size() + i6;
        } else {
            this.decoderCounters.droppedToKeyframeCount++;
            updateDroppedBufferCounters(this.droppedDecoderInputBufferTimestamps.size() + iSkipSource, this.buffersInCodecCount);
        }
        flushOrReinitializeCodec();
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.flush(false);
        }
        return true;
    }

    @Override
    public boolean maybeInitializeProcessingPipeline(Format format) throws ExoPlaybackException {
        VideoSink videoSink = this.videoSink;
        if (videoSink == null || videoSink.isInitialized()) {
            return true;
        }
        try {
            return this.videoSink.initialize(format);
        } catch (VideoSink.VideoSinkException e5) {
            throw createRendererException(e5, format, 7000);
        }
    }

    @Override
    public void onCodecError(Exception exc) {
        Log.m1716e(TAG, "Video codec error", exc);
        this.eventDispatcher.videoCodecError(exc);
    }

    @Override
    public void onCodecInitialized(String str, MediaCodecAdapter.Configuration configuration, long j10, long j11) {
        this.eventDispatcher.decoderInitialized(str, j10, j11);
        this.codecNeedsSetOutputSurfaceWorkaround = codecNeedsSetOutputSurfaceWorkaround(str);
        this.codecHandlesHdr10PlusOutOfBandMetadata = ((MediaCodecInfo) Assertions.checkNotNull(getCodecInfo())).isHdr10PlusOutOfBandMetadataSupported();
        maybeSetupTunnelingForFirstFrame();
    }

    @Override
    public void onCodecReleased(String str) {
        this.eventDispatcher.decoderReleased(str);
    }

    @Override
    public void onDisabled() {
        this.reportedVideoSize = null;
        this.periodDurationUs = C0565C.TIME_UNSET;
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.onRendererDisabled();
        } else {
            this.videoFrameReleaseControl.onDisabled();
        }
        maybeSetupTunnelingForFirstFrame();
        this.haveReportedFirstFrameRenderedForCurrentSurface = false;
        this.tunnelingOnFrameRenderedListener = null;
        try {
            super.onDisabled();
        } finally {
            this.eventDispatcher.disabled(this.decoderCounters);
            this.eventDispatcher.videoSizeChanged(VideoSize.UNKNOWN);
        }
    }

    @Override
    public void onEnabled(boolean z7, boolean z10) throws ExoPlaybackException {
        super.onEnabled(z7, z10);
        boolean z11 = getConfiguration().tunneling;
        Assertions.checkState((z11 && this.tunnelingAudioSessionId == 0) ? false : true);
        if (this.tunneling != z11) {
            this.tunneling = z11;
            releaseCodec();
        }
        this.eventDispatcher.enabled(this.decoderCounters);
        if (!this.hasSetVideoSink) {
            if (this.videoEffects != null && this.videoSink == null) {
                PlaybackVideoGraphWrapper playbackVideoGraphWrapperBuild = new PlaybackVideoGraphWrapper.Builder(this.context, this.videoFrameReleaseControl).setClock(getClock()).build();
                playbackVideoGraphWrapperBuild.setTotalVideoInputCount(1);
                this.videoSink = playbackVideoGraphWrapperBuild.getSink(0);
            }
            this.hasSetVideoSink = true;
        }
        VideoSink videoSink = this.videoSink;
        if (videoSink == null) {
            this.videoFrameReleaseControl.setClock(getClock());
            this.videoFrameReleaseControl.onEnabled(z10);
            return;
        }
        videoSink.setListener(new VideoSink.Listener() {
            @Override
            public void onError(VideoSink videoSink2, VideoSink.VideoSinkException videoSinkException) {
                MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
                mediaCodecVideoRenderer.setPendingPlaybackException(mediaCodecVideoRenderer.createRendererException(videoSinkException, videoSinkException.format, PlaybackException.ERROR_CODE_VIDEO_FRAME_PROCESSING_FAILED));
            }

            @Override
            public void onFirstFrameRendered(VideoSink videoSink2) {
                if (MediaCodecVideoRenderer.this.displaySurface != null) {
                    MediaCodecVideoRenderer.this.notifyRenderedFirstFrame();
                }
            }

            @Override
            public void onFrameDropped(VideoSink videoSink2) {
                if (MediaCodecVideoRenderer.this.displaySurface != null) {
                    MediaCodecVideoRenderer.this.updateDroppedBufferCounters(0, 1);
                }
            }

            @Override
            public void onVideoSizeChanged(VideoSink videoSink2, VideoSize videoSize) {
            }
        }, MoreExecutors.directExecutor());
        VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
        if (videoFrameMetadataListener != null) {
            this.videoSink.setVideoFrameMetadataListener(videoFrameMetadataListener);
        }
        if (this.displaySurface != null && !this.outputResolution.equals(Size.UNKNOWN)) {
            this.videoSink.setOutputSurfaceInfo(this.displaySurface, this.outputResolution);
        }
        this.videoSink.setChangeFrameRateStrategy(this.changeFrameRateStrategy);
        this.videoSink.setPlaybackSpeed(getPlaybackSpeed());
        List<Effect> list = this.videoEffects;
        if (list != null) {
            this.videoSink.setVideoEffects(list);
        }
        this.videoSink.onRendererEnabled(z10);
        Renderer.WakeupListener wakeupListener = getWakeupListener();
        if (wakeupListener != null) {
            this.videoSink.setWakeupListener(wakeupListener);
        }
    }

    @Override
    public void onInit() {
        super.onInit();
    }

    @Override
    public DecoderReuseEvaluation onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
        DecoderReuseEvaluation decoderReuseEvaluationOnInputFormatChanged = super.onInputFormatChanged(formatHolder);
        this.eventDispatcher.inputFormatChanged((Format) Assertions.checkNotNull(formatHolder.format), decoderReuseEvaluationOnInputFormatChanged);
        return decoderReuseEvaluationOnInputFormatChanged;
    }

    @Override
    public void onOutputFormatChanged(Format format, MediaFormat mediaFormat) {
        int integer;
        int i6;
        MediaCodecAdapter codec = getCodec();
        if (codec != null) {
            codec.setVideoScalingMode(this.scalingMode);
        }
        if (this.tunneling) {
            i6 = format.width;
            integer = format.height;
        } else {
            Assertions.checkNotNull(mediaFormat);
            boolean z7 = mediaFormat.containsKey(KEY_CROP_RIGHT) && mediaFormat.containsKey(KEY_CROP_LEFT) && mediaFormat.containsKey(KEY_CROP_BOTTOM) && mediaFormat.containsKey(KEY_CROP_TOP);
            int integer2 = z7 ? (mediaFormat.getInteger(KEY_CROP_RIGHT) - mediaFormat.getInteger(KEY_CROP_LEFT)) + 1 : mediaFormat.getInteger("width");
            integer = z7 ? (mediaFormat.getInteger(KEY_CROP_BOTTOM) - mediaFormat.getInteger(KEY_CROP_TOP)) + 1 : mediaFormat.getInteger("height");
            i6 = integer2;
        }
        float f = format.pixelWidthHeightRatio;
        int i10 = format.rotationDegrees;
        if (i10 == 90 || i10 == 270) {
            f = 1.0f / f;
            int i11 = integer;
            integer = i6;
            i6 = i11;
        }
        this.decodedVideoSize = new VideoSize(i6, integer, f);
        VideoSink videoSink = this.videoSink;
        if (videoSink == null || !this.pendingVideoSinkInputStreamChange) {
            this.videoFrameReleaseControl.setFrameRate(format.frameRate);
        } else {
            changeVideoSinkInputStream(videoSink, 1, format.buildUpon().setWidth(i6).setHeight(integer).setPixelWidthHeightRatio(f).build());
        }
        this.pendingVideoSinkInputStreamChange = false;
    }

    @Override
    public void onPositionReset(long j10, boolean z7) throws ExoPlaybackException {
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            if (!z7) {
                videoSink.flush(true);
            }
            this.videoSink.setStreamTimestampInfo(getOutputStreamStartPositionUs(), getBufferTimestampAdjustmentUs());
            this.pendingVideoSinkInputStreamChange = true;
        }
        super.onPositionReset(j10, z7);
        if (this.videoSink == null) {
            this.videoFrameReleaseControl.reset();
        }
        if (z7) {
            VideoSink videoSink2 = this.videoSink;
            if (videoSink2 != null) {
                videoSink2.join(false);
            } else {
                this.videoFrameReleaseControl.join(false);
            }
        }
        maybeSetupTunnelingForFirstFrame();
        this.consecutiveDroppedFrameCount = 0;
    }

    @Override
    public void onProcessedOutputBuffer(long j10) {
        super.onProcessedOutputBuffer(j10);
        if (this.tunneling) {
            return;
        }
        this.buffersInCodecCount--;
    }

    @Override
    public void onProcessedStreamChange() {
        super.onProcessedStreamChange();
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.signalEndOfCurrentInputStream();
            this.videoSink.setStreamTimestampInfo(getOutputStreamStartPositionUs(), getBufferTimestampAdjustmentUs());
        } else {
            this.videoFrameReleaseControl.onProcessedStreamChange();
        }
        this.pendingVideoSinkInputStreamChange = true;
        maybeSetupTunnelingForFirstFrame();
    }

    public void onProcessedTunneledBuffer(long j10) throws ExoPlaybackException {
        updateOutputFormatForTime(j10);
        maybeNotifyVideoSizeChanged(this.decodedVideoSize);
        this.decoderCounters.renderedOutputBufferCount++;
        maybeNotifyRenderedFirstFrame();
        onProcessedOutputBuffer(j10);
    }

    @Override
    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        ByteBuffer byteBuffer;
        if (this.av1SampleDependencyParser != null && ((MediaCodecInfo) Assertions.checkNotNull(getCodecInfo())).mimeType.equals(MimeTypes.VIDEO_AV1) && (byteBuffer = decoderInputBuffer.data) != null) {
            this.av1SampleDependencyParser.queueInputBuffer(byteBuffer);
        }
        this.consecutiveDroppedInputBufferCount = 0;
        boolean z7 = this.tunneling;
        if (!z7) {
            this.buffersInCodecCount++;
        }
        if (Util.SDK_INT >= 23 || !z7) {
            return;
        }
        onProcessedTunneledBuffer(decoderInputBuffer.timeUs);
    }

    @Override
    public void onRelease() {
        super.onRelease();
        VideoSink videoSink = this.videoSink;
        if (videoSink == null || !this.ownsVideoSink) {
            return;
        }
        videoSink.release();
    }

    @Override
    public void onReset() {
        try {
            super.onReset();
        } finally {
            this.hasSetVideoSink = false;
            this.startPositionUs = C0565C.TIME_UNSET;
            releasePlaceholderSurface();
        }
    }

    @Override
    public void onStarted() {
        super.onStarted();
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = getClock().elapsedRealtime();
        this.totalVideoFrameProcessingOffsetUs = 0L;
        this.videoFrameProcessingOffsetCount = 0;
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.onRendererStarted();
        } else {
            this.videoFrameReleaseControl.onStarted();
        }
    }

    @Override
    public void onStopped() {
        maybeNotifyDroppedFrames();
        maybeNotifyVideoFrameProcessingOffset();
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.onRendererStopped();
        } else {
            this.videoFrameReleaseControl.onStopped();
        }
        super.onStopped();
    }

    @Override
    public void onStreamChanged(Format[] formatArr, long j10, long j11, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException {
        super.onStreamChanged(formatArr, j10, j11, mediaPeriodId);
        if (this.startPositionUs == C0565C.TIME_UNSET) {
            this.startPositionUs = j10;
        }
        updatePeriodDurationUs(mediaPeriodId);
    }

    @Override
    public void onWakeupListenerSet(Renderer.WakeupListener wakeupListener) {
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.setWakeupListener(wakeupListener);
        }
    }

    @Override
    public boolean processOutputBuffer(long j10, long j11, final MediaCodecAdapter mediaCodecAdapter, ByteBuffer byteBuffer, final int i6, int i10, int i11, long j12, boolean z7, boolean z10, Format format) throws ExoPlaybackException {
        Assertions.checkNotNull(mediaCodecAdapter);
        final long outputStreamOffsetUs = j12 - getOutputStreamOffsetUs();
        updateDroppedBufferCountersWithInputBuffers(j12);
        if (this.videoSink != null) {
            if (!z7 || z10) {
                return this.videoSink.handleInputFrame(getBufferTimestampAdjustmentUs() + j12, z10, new VideoSink.VideoFrameHandler() {
                    @Override
                    public void render(long j13) {
                        MediaCodecVideoRenderer.this.renderOutputBuffer(mediaCodecAdapter, i6, outputStreamOffsetUs, j13);
                    }

                    @Override
                    public void skip() {
                        MediaCodecVideoRenderer.this.skipOutputBuffer(mediaCodecAdapter, i6, outputStreamOffsetUs);
                    }
                });
            }
            skipOutputBuffer(mediaCodecAdapter, i6, outputStreamOffsetUs);
            return true;
        }
        int frameReleaseAction = this.videoFrameReleaseControl.getFrameReleaseAction(j12, j10, j11, getOutputStreamStartPositionUs(), z7, z10, this.videoFrameReleaseInfo);
        if (frameReleaseAction == 0) {
            long jNanoTime = getClock().nanoTime();
            notifyFrameMetadataListener(outputStreamOffsetUs, jNanoTime, format);
            renderOutputBuffer(mediaCodecAdapter, i6, outputStreamOffsetUs, jNanoTime);
            updateVideoFrameProcessingOffsetCounters(this.videoFrameReleaseInfo.getEarlyUs());
            return true;
        }
        if (frameReleaseAction == 1) {
            releaseFrame((MediaCodecAdapter) Assertions.checkStateNotNull(mediaCodecAdapter), i6, outputStreamOffsetUs, format);
            return true;
        }
        if (frameReleaseAction == 2) {
            dropOutputBuffer(mediaCodecAdapter, i6, outputStreamOffsetUs);
            updateVideoFrameProcessingOffsetCounters(this.videoFrameReleaseInfo.getEarlyUs());
            return true;
        }
        if (frameReleaseAction == 3) {
            skipOutputBuffer(mediaCodecAdapter, i6, outputStreamOffsetUs);
            updateVideoFrameProcessingOffsetCounters(this.videoFrameReleaseInfo.getEarlyUs());
            return true;
        }
        if (frameReleaseAction == 4 || frameReleaseAction == 5) {
            return false;
        }
        throw new IllegalStateException(String.valueOf(frameReleaseAction));
    }

    @Override
    public void render(long j10, long j11) throws ExoPlaybackException {
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            try {
                videoSink.render(j10, j11);
            } catch (VideoSink.VideoSinkException e5) {
                throw createRendererException(e5, e5.format, PlaybackException.ERROR_CODE_VIDEO_FRAME_PROCESSING_FAILED);
            }
        }
        super.render(j10, j11);
    }

    public void renderOutputBufferV21(MediaCodecAdapter mediaCodecAdapter, int i6, long j10, long j11) {
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i6, j11);
        TraceUtil.endSection();
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        if (this.videoSink == null) {
            maybeNotifyVideoSizeChanged(this.decodedVideoSize);
            maybeNotifyRenderedFirstFrame();
        }
    }

    @Override
    public void renderToEndOfStream() {
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.signalEndOfCurrentInputStream();
        }
    }

    @Override
    public void resetCodecStateForFlush() {
        super.resetCodecStateForFlush();
        this.droppedDecoderInputBufferTimestamps.clear();
        this.shouldDropDecoderInputBuffers = false;
        this.buffersInCodecCount = 0;
        this.consecutiveDroppedInputBufferCount = 0;
        Av1SampleDependencyParser av1SampleDependencyParser = this.av1SampleDependencyParser;
        if (av1SampleDependencyParser != null) {
            av1SampleDependencyParser.reset();
        }
    }

    public void setOutputSurfaceV23(MediaCodecAdapter mediaCodecAdapter, Surface surface) {
        mediaCodecAdapter.setOutputSurface(surface);
    }

    @Override
    public void setPlaybackSpeed(float f, float f3) throws ExoPlaybackException {
        super.setPlaybackSpeed(f, f3);
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.setPlaybackSpeed(f);
        } else {
            this.videoFrameReleaseControl.setPlaybackSpeed(f);
        }
    }

    public void setVideoEffects(List<Effect> list) {
        this.videoEffects = list;
        VideoSink videoSink = this.videoSink;
        if (videoSink != null) {
            videoSink.setVideoEffects(list);
        }
    }

    @Override
    public boolean shouldDiscardDecoderInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        if (isBufferProbablyLastSample(decoderInputBuffer) || decoderInputBuffer.isEncrypted()) {
            return false;
        }
        boolean zIsBufferBeforeStartTime = isBufferBeforeStartTime(decoderInputBuffer);
        if ((!zIsBufferBeforeStartTime && !this.shouldDropDecoderInputBuffers) || decoderInputBuffer.hasSupplementalData()) {
            return false;
        }
        if (decoderInputBuffer.notDependedOn()) {
            decoderInputBuffer.clear();
            if (zIsBufferBeforeStartTime) {
                this.decoderCounters.skippedInputBufferCount++;
            } else if (this.shouldDropDecoderInputBuffers) {
                this.droppedDecoderInputBufferTimestamps.add(Long.valueOf(decoderInputBuffer.timeUs));
                this.consecutiveDroppedInputBufferCount++;
            }
            return true;
        }
        if (this.av1SampleDependencyParser != null && ((MediaCodecInfo) Assertions.checkNotNull(getCodecInfo())).mimeType.equals(MimeTypes.VIDEO_AV1) && (byteBuffer = decoderInputBuffer.data) != null) {
            boolean z7 = zIsBufferBeforeStartTime || this.consecutiveDroppedInputBufferCount <= 0;
            ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            byteBufferAsReadOnlyBuffer.flip();
            int iSampleLimitAfterSkippingNonReferenceFrame = this.av1SampleDependencyParser.sampleLimitAfterSkippingNonReferenceFrame(byteBufferAsReadOnlyBuffer, z7);
            boolean z10 = ((CodecMaxValues) Assertions.checkNotNull(this.codecMaxValues)).inputSize + iSampleLimitAfterSkippingNonReferenceFrame < byteBufferAsReadOnlyBuffer.capacity();
            if (iSampleLimitAfterSkippingNonReferenceFrame != byteBufferAsReadOnlyBuffer.limit() && z10) {
                ((ByteBuffer) Assertions.checkNotNull(decoderInputBuffer.data)).position(iSampleLimitAfterSkippingNonReferenceFrame);
                if (zIsBufferBeforeStartTime) {
                    this.decoderCounters.skippedInputBufferCount++;
                } else if (this.shouldDropDecoderInputBuffers) {
                    this.droppedDecoderInputBufferTimestamps.add(Long.valueOf(decoderInputBuffer.timeUs));
                    this.consecutiveDroppedInputBufferCount++;
                }
                return true;
            }
        }
        return false;
    }

    public boolean shouldDropBuffersToKeyframe(long j10, long j11, boolean z7) {
        return j10 < MIN_EARLY_US_VERY_LATE_THRESHOLD && !z7;
    }

    @Override
    public boolean shouldDropFrame(long j10, long j11, boolean z7) {
        return shouldDropOutputBuffer(j10, j11, z7);
    }

    public boolean shouldDropOutputBuffer(long j10, long j11, boolean z7) {
        return j10 < MIN_EARLY_US_LATE_THRESHOLD && !z7;
    }

    @Override
    public boolean shouldForceReleaseFrame(long j10, long j11) {
        return shouldForceRenderOutputBuffer(j10, j11);
    }

    public boolean shouldForceRenderOutputBuffer(long j10, long j11) {
        return j10 < MIN_EARLY_US_LATE_THRESHOLD && j11 > 100000;
    }

    @Override
    public boolean shouldIgnoreFrame(long j10, long j11, long j12, boolean z7, boolean z10) throws ExoPlaybackException {
        if (this.minEarlyUsToDropDecoderInput != C0565C.TIME_UNSET) {
            this.shouldDropDecoderInputBuffers = j11 > getLastResetPositionUs() + OFFSET_FROM_RESET_POSITION_TO_ALLOW_INPUT_BUFFER_DROPPING_US && j10 < this.minEarlyUsToDropDecoderInput;
        }
        return shouldDropBuffersToKeyframe(j10, j12, z7) && maybeDropBuffersToKeyframe(j11, z10);
    }

    @Override
    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return hasSurfaceForCodec(mediaCodecInfo);
    }

    public boolean shouldSkipBuffersWithIdenticalReleaseTime() {
        return true;
    }

    public boolean shouldUseDetachedSurface(MediaCodecInfo mediaCodecInfo) {
        return Util.SDK_INT >= 35 && mediaCodecInfo.detachedSurfaceSupported;
    }

    public boolean shouldUsePlaceholderSurface(MediaCodecInfo mediaCodecInfo) {
        return Util.SDK_INT >= 23 && !this.tunneling && !codecNeedsSetOutputSurfaceWorkaround(mediaCodecInfo.name) && (!mediaCodecInfo.secure || PlaceholderSurface.isSecureSupported(this.context));
    }

    public void skipOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i6, long j10) {
        TraceUtil.beginSection("skipVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i6, false);
        TraceUtil.endSection();
        this.decoderCounters.skippedOutputBufferCount++;
    }

    public void updateDroppedBufferCounters(int i6, int i10) {
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedInputBufferCount += i6;
        int i11 = i6 + i10;
        decoderCounters.droppedBufferCount += i11;
        this.droppedFrames += i11;
        int i12 = this.consecutiveDroppedFrameCount + i11;
        this.consecutiveDroppedFrameCount = i12;
        decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(i12, decoderCounters.maxConsecutiveDroppedBufferCount);
        int i13 = this.maxDroppedFramesToNotify;
        if (i13 <= 0 || this.droppedFrames < i13) {
            return;
        }
        maybeNotifyDroppedFrames();
    }

    public void updateVideoFrameProcessingOffsetCounters(long j10) {
        this.decoderCounters.addVideoFrameProcessingOffset(j10);
        this.totalVideoFrameProcessingOffsetUs += j10;
        this.videoFrameProcessingOffsetCount++;
    }

    @Deprecated
    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j10) {
        this(new Builder(context).setMediaCodecSelector(mediaCodecSelector).setAllowedJoiningTimeMs(j10));
    }

    @Deprecated
    public void renderOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i6, long j10) {
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i6, true);
        TraceUtil.endSection();
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        if (this.videoSink == null) {
            maybeNotifyVideoSizeChanged(this.decodedVideoSize);
            maybeNotifyRenderedFirstFrame();
        }
    }

    @Override
    public int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        return supportsFormatInternal(this.context, mediaCodecSelector, format);
    }

    private static List<MediaCodecInfo> getDecoderInfos(Context context, MediaCodecSelector mediaCodecSelector, Format format, boolean z7, boolean z10) throws MediaCodecUtil.DecoderQueryException {
        String str = format.sampleMimeType;
        if (str == null) {
            C2204g1 c2204g1 = AbstractC2301u1.f8069b;
            return C2180c5.f7862e;
        }
        if (Util.SDK_INT >= 26 && MimeTypes.VIDEO_DOLBY_VISION.equals(str) && !Api26.doesDisplaySupportDolbyVision(context)) {
            List<MediaCodecInfo> alternativeDecoderInfos = MediaCodecUtil.getAlternativeDecoderInfos(mediaCodecSelector, format, z7, z10);
            if (!alternativeDecoderInfos.isEmpty()) {
                return alternativeDecoderInfos;
            }
        }
        return MediaCodecUtil.getDecoderInfosSoftMatch(mediaCodecSelector, format, z7, z10);
    }

    @Deprecated
    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j10, Handler handler, VideoRendererEventListener videoRendererEventListener, int i6) {
        this(new Builder(context).setMediaCodecSelector(mediaCodecSelector).setAllowedJoiningTimeMs(j10).setEventHandler(handler).setEventListener(videoRendererEventListener).setMaxDroppedFramesToNotify(i6));
    }

    @Deprecated
    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j10, boolean z7, Handler handler, VideoRendererEventListener videoRendererEventListener, int i6) {
        this(new Builder(context).setMediaCodecSelector(mediaCodecSelector).setAllowedJoiningTimeMs(j10).setEnableDecoderFallback(z7).setEventHandler(handler).setEventListener(videoRendererEventListener).setMaxDroppedFramesToNotify(i6));
    }

    @Deprecated
    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j10, boolean z7, Handler handler, VideoRendererEventListener videoRendererEventListener, int i6) {
        this(new Builder(context).setMediaCodecSelector(mediaCodecSelector).setCodecAdapterFactory(factory).setAllowedJoiningTimeMs(j10).setEnableDecoderFallback(z7).setEventHandler(handler).setEventListener(videoRendererEventListener).setMaxDroppedFramesToNotify(i6));
    }

    @Deprecated
    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j10, boolean z7, Handler handler, VideoRendererEventListener videoRendererEventListener, int i6, float f) {
        this(new Builder(context).setMediaCodecSelector(mediaCodecSelector).setCodecAdapterFactory(factory).setAllowedJoiningTimeMs(j10).setEnableDecoderFallback(z7).setEventHandler(handler).setEventListener(videoRendererEventListener).setMaxDroppedFramesToNotify(i6).setAssumedMinimumCodecOperatingRate(f));
    }

    @Deprecated
    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j10, boolean z7, Handler handler, VideoRendererEventListener videoRendererEventListener, int i6, float f, VideoSinkProvider videoSinkProvider) {
        this(new Builder(context).setMediaCodecSelector(mediaCodecSelector).setCodecAdapterFactory(factory).setAllowedJoiningTimeMs(j10).setEnableDecoderFallback(z7).setEventHandler(handler).setEventListener(videoRendererEventListener).setMaxDroppedFramesToNotify(i6).setAssumedMinimumCodecOperatingRate(f).setVideoSink(videoSinkProvider == null ? null : videoSinkProvider.getSink(0)));
    }

    @Deprecated
    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j10, boolean z7, Handler handler, VideoRendererEventListener videoRendererEventListener, int i6, float f, VideoSink videoSink) {
        this(new Builder(context).setMediaCodecSelector(mediaCodecSelector).setCodecAdapterFactory(factory).setAllowedJoiningTimeMs(j10).setEnableDecoderFallback(z7).setEventHandler(handler).setEventListener(videoRendererEventListener).setMaxDroppedFramesToNotify(i6).setAssumedMinimumCodecOperatingRate(f).setVideoSink(videoSink));
    }

    public MediaCodecVideoRenderer(Builder builder) {
        super(2, builder.codecAdapterFactory, builder.mediaCodecSelector, builder.enableDecoderFallback, builder.assumedMinimumCodecOperatingRate);
        Context applicationContext = builder.context.getApplicationContext();
        this.context = applicationContext;
        this.maxDroppedFramesToNotify = builder.maxDroppedFramesToNotify;
        this.videoSink = builder.videoSink;
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(builder.eventHandler, builder.eventListener);
        this.ownsVideoSink = this.videoSink == null;
        this.videoFrameReleaseControl = new VideoFrameReleaseControl(applicationContext, this, builder.allowedJoiningTimeMs);
        this.videoFrameReleaseInfo = new VideoFrameReleaseControl.FrameReleaseInfo();
        this.deviceNeedsNoPostProcessWorkaround = deviceNeedsNoPostProcessWorkaround();
        this.outputResolution = Size.UNKNOWN;
        this.scalingMode = 1;
        this.changeFrameRateStrategy = 0;
        this.decodedVideoSize = VideoSize.UNKNOWN;
        this.tunnelingAudioSessionId = 0;
        this.reportedVideoSize = null;
        this.rendererPriority = -1000;
        long j10 = C0565C.TIME_UNSET;
        this.startPositionUs = C0565C.TIME_UNSET;
        this.periodDurationUs = C0565C.TIME_UNSET;
        this.av1SampleDependencyParser = builder.parseAv1SampleDependencies ? new Av1SampleDependencyParser() : null;
        this.droppedDecoderInputBufferTimestamps = new PriorityQueue<>();
        this.minEarlyUsToDropDecoderInput = builder.lateThresholdToDropDecoderInputUs != C0565C.TIME_UNSET ? -builder.lateThresholdToDropDecoderInputUs : j10;
    }
}

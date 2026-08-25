package p055ea;

import android.text.TextUtils;
import androidx.media3.common.AbstractC0602k;
import androidx.media3.common.AudioAttributes;
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
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.trackselection.MappingTrackSelector;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import java.util.Arrays;
import java.util.List;
import org.bitspark.android.Constants$VIDEO_TYPE;
import org.bitspark.android.Spark;
import org.bitspark.android.beans.ChannelBean;
import org.bitspark.android.beans.SubtitleMenu;
import org.bitspark.android.beans.VodMenu;
import org.bitspark.android.utils.AbstractC3331m;
import org.bitspark.android.utils.C3333o;
import p003a2.AbstractC0032a;
import p193ra.C3663f;
import p214ta.C3877a;

public final class C2453m0 implements Player.Listener {

    public final Spark f8637a;

    public C2453m0(Spark spark) {
        this.f8637a = spark;
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
    public final void onEvents(Player player, Player.Events events) {
        AbstractC0602k.m1689h(this, player, events);
    }

    @Override
    public final void onIsLoadingChanged(boolean z7) {
        AbstractC0602k.m1690i(this, z7);
    }

    @Override
    public final void onIsPlayingChanged(boolean z7) {
        String strM165s = AbstractC0032a.m165s("0HMUTTdv\n", "kiBZLF4Bx+s=\n");
        String str = AbstractC0032a.m165s("FdPY+GrO6P8Ci9jGT9zB9hHS3sZh7Pn7HszSzDyP\n", "cKu3qAavkZo=\n") + z7;
        boolean z10 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, str);
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
        String strM165s = AbstractC0032a.m165s("u+k8gJ40\n", "+bpx4fdaELo=\n");
        String str = AbstractC0032a.m165s("y9KaI9Dhkr/cipod7OyKo8vYpgfd9I6ZxsubFNnky/rexpQK3uGIsf3elAfZug==\n", "rqr1c7yA69o=\n") + i6;
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, str);
        Spark spark = this.f8637a;
        if (i6 == 4) {
            Log.m5049i(AbstractC0032a.m165s("BRJs/AEk\n", "R0EhnWhKxUU=\n"), AbstractC0032a.m165s("8HJbLdM/sQTnKlsT/DGlEflvQBTQMOhPuyQa\n", "lQo0fb9eyGE=\n"));
            spark.f11121i1 = System.currentTimeMillis();
            if (spark.m6712c0()) {
                spark.f11121i1 = System.currentTimeMillis();
            } else {
                Constants$VIDEO_TYPE constants$VIDEO_TYPE = spark.f11044E1;
                if (constants$VIDEO_TYPE == Constants$VIDEO_TYPE.BSPALYBACK || constants$VIDEO_TYPE == Constants$VIDEO_TYPE.BSVOD || constants$VIDEO_TYPE == Constants$VIDEO_TYPE.STATIC) {
                    Log.m5049i(AbstractC0032a.m165s("LWczrycE\n", "bzR+zk5q3MM=\n"), AbstractC0032a.m165s("rZbZU8m6+dO8g9VIuYDR7put6XfAht2K\n", "3uK2I5nWmKo=\n") + spark.f11044E1);
                    spark.m6729v0();
                    spark.f11059J1.stop();
                    spark.m6726q0();
                    if (Spark.m6658F(spark, spark.f11101Y)) {
                        return;
                    } else {
                        spark.m6697M0(true);
                    }
                }
            }
        }
        Constants$VIDEO_TYPE constants$VIDEO_TYPE2 = spark.f11044E1;
        if (constants$VIDEO_TYPE2 == Constants$VIDEO_TYPE.BSPALYBACK || constants$VIDEO_TYPE2 == Constants$VIDEO_TYPE.BSVOD || constants$VIDEO_TYPE2 == Constants$VIDEO_TYPE.STATIC) {
            spark.m6726q0();
        }
        if (spark.f11059J1.getPlayWhenReady()) {
            Log.m5049i(AbstractC0032a.m165s("KWVfIhbg\n", "azYSQ3+OlLQ=\n"), AbstractC0032a.m165s("c3BAWLaOonpPanFAsrSvaXJ5dVDt1w==\n", "HB4QNNf3xwg=\n") + spark.m6712c0() + AbstractC0032a.m165s("rzle/nGw8BivOQ==\n", "kgRjw0yNzSU=\n") + spark.f11049G0);
            if (spark.m6712c0() || spark.f11049G0 || Spark.f11011g2) {
                return;
            }
            spark.m6691G0(5000);
        }
    }

    @Override
    public final void onPlaybackSuppressionReasonChanged(int i6) {
        AbstractC0602k.m1700s(this, i6);
    }

    @Override
    public final void onPlayerError(PlaybackException playbackException) {
        int iLastIndexOf;
        String strM165s = AbstractC0032a.m165s("vL181McP\n", "/u4xta5hnMY=\n");
        String str = AbstractC0032a.m165s("9QkQ0HpfRE/iURDuRlJcU/UDOvJkUU8Q\n", "kHF/gBY+PSo=\n") + playbackException;
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, str);
        Log.m5049i(AbstractC0032a.m165s("QqDtrxrx\n", "APOgznOfre8=\n"), AbstractC0032a.m165s("7a+rrWz9hHb696uTUPCcau2lgY9y848p\n", "iNfE/QCc/RM=\n") + Arrays.toString(playbackException.getStackTrace()));
        Spark spark = this.f8637a;
        C2459p0 c2459p0 = spark.f11077P1;
        long j10 = c2459p0 != null ? c2459p0.f8649a : 0L;
        Log.m5049i(AbstractC0032a.m165s("T18cDyfJ\n", "DQxRbk6nXNU=\n"), AbstractC0032a.m165s("gIuhvRRGSmKX06GDKEtSfoCBi58KSEE9xd7j01hDUnOE06mCDB0=\n", "5fPO7XgnMwc=\n") + j10);
        if (((ExoPlaybackException) playbackException).type == 1) {
            Spark.m6678t0(1, AbstractC0032a.m165s("6nacr8HOie7aeoz9gsuCv8c5jbiCxYj9k22BtJKKn+zBfIiwzw==\n", "sxnp3eGq7Jg=\n"));
            return;
        }
        String string = playbackException.toString();
        if (spark.f11044E1 != Constants$VIDEO_TYPE.STATIC) {
            spark.f11121i1 = System.currentTimeMillis() + 4000;
            return;
        }
        int iLastIndexOf2 = string.lastIndexOf(58);
        if (iLastIndexOf2 != -1) {
            String strSubstring = string.substring(iLastIndexOf2 + 1);
            string = (strSubstring.length() >= 20 || (iLastIndexOf = string.substring(0, iLastIndexOf2).lastIndexOf(58)) == -1) ? strSubstring : string.substring(iLastIndexOf + 1).trim();
        }
        if (string.length() > 20) {
            string = string.substring(string.length() - 20);
        }
        Spark.m6678t0(1, AbstractC0032a.m165s("esJ6VQUo4Q==\n", "P7AIOncSwQA=\n") + string);
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
        Spark spark = this.f8637a;
        C2459p0 c2459p0 = spark.f11077P1;
        long j10 = c2459p0 != null ? c2459p0.f8649a : 0L;
        String strM165s = AbstractC0032a.m165s("C+MzEB1i\n", "SbB+cXQMFjY=\n");
        String str = AbstractC0032a.m165s("SGAQ8rPHxYhfOBDMjcPSiUhqGsaZz86eWV4Nw7LDnMAAJl/GvtLdzUp3C5g=\n", "LRh/ot+mvO0=\n") + j10;
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, str);
        spark.f11049G0 = true;
        spark.f11121i1 = System.currentTimeMillis();
        System.currentTimeMillis();
        if (Spark.f11011g2) {
            spark.m6688D0(0.9f);
        }
        spark.f11149w1.setVisibility(8);
        spark.m6725p0();
        C2446j c2446j = spark.f11083R1;
        if (c2446j != null) {
            switch (c2446j.f8625a) {
                case 0:
                    HandlerC2468u handlerC2468u = Spark.f11002X1;
                    Spark spark2 = c2446j.f8626b;
                    spark2.m6705U();
                    spark2.m6727r0(c2446j.f8627c, spark2.f11120i0.f12985B);
                    break;
                default:
                    HandlerC2468u handlerC2468u2 = Spark.f11002X1;
                    Spark spark3 = c2446j.f8626b;
                    spark3.m6705U();
                    spark3.m6727r0(c2446j.f8627c, spark3.f11120i0.f12986C);
                    break;
            }
            spark.f11083R1 = null;
        }
        Log.m5049i(AbstractC0032a.m165s("M0GpmfHR\n", "cRLk+Ji/Q9Q=\n"), AbstractC0032a.m165s("LeOIBFtCCcAn6eITRl043iP0vQQeXQbgJ+O8E0xXDPQr/6sCeEAJ3yetqARRVRrXMf74EVFcDQ==\n", "Qo3Ydj4yaLI=\n"));
    }

    @Override
    public final void onRepeatModeChanged(int i6) {
        String strM165s = AbstractC0032a.m165s("iK1xLg1q\n", "yv48T2QERhE=\n");
        String str = AbstractC0032a.m165s("cbvjo6ahBTBm4+OdmKUMMHW3wZyupT89da3rlq76\n", "FMOM88rAfFU=\n") + i6;
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, str);
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
        String strM165s = AbstractC0032a.m165s("xnLgIQgj\n", "hCGtQGFNdQc=\n");
        String str = AbstractC0032a.m165s("5Vr3M2BY/RzyAvcNX1HxH+ZO/S5jXeE87kP6D2ldxxHhTP8GaAM=\n", "gCKYYww5hHk=\n") + z7;
        boolean z10 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, str);
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
        String strM165s = AbstractC0032a.m165s("Z09DKLd8\n", "JRwOSd4SOj0=\n");
        String str = AbstractC0032a.m165s("wnm0AtwWQTTVIbQ85B5VNMtotTfzH1k/wGS/csISWSLIb+Fy\n", "pwHbUrB3OFE=\n") + i6;
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, str);
    }

    @Override
    public final void onTracksChanged(Tracks tracks) {
        boolean zIsEmpty;
        int size;
        String strM165s = AbstractC0032a.m165s("Wi9cb+0D\n", "GHwRDoRt3S4=\n");
        StringBuilder sb = new StringBuilder();
        sb.append(AbstractC0032a.m165s("TvEDtFlPzjwbs371FRuLK0OzQM0GA40yEJ9G+BoFiz1Dskv8EC6HLwaPW/sAC5o1Bvw=\n", "Y9wumXRi7lk=\n"));
        Spark spark = this.f8637a;
        sb.append(spark.f11120i0.f12990G);
        sb.append(AbstractC0032a.m165s("qIdiLhbvryHm9hZFbg==\n", "lbpfEyvSkkg=\n"));
        sb.append(spark.m6712c0());
        String string = sb.toString();
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, string);
        if (spark.f11120i0.f12990G) {
            boolean zM6712c0 = spark.m6712c0();
            String str = spark.f11150x;
            if (zM6712c0) {
                if (Spark.f11017m2 != 1) {
                    String str2 = AbstractC0032a.m165s("BwP/Xc/ML7YVBP940tYvxQwP/XT1zyiRCRLndOrTOZFaRg==\n", "YGaLEaa6SuU=\n") + spark.f11120i0.f12986C.size();
                    boolean z10 = AbstractC3331m.f11244b;
                    Log.m5049i(str, str2);
                } else {
                    ChannelBean channelBean = C3663f.m7415b().f12272e;
                    if (channelBean != null) {
                        String str3 = (String) C3663f.m7415b().f12271d.get(String.valueOf(channelBean.getChid()));
                        spark.f11120i0.f12986C.clear();
                        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = spark.f11074O1.getCurrentMappedTrackInfo();
                        if (currentMappedTrackInfo != null) {
                            for (int i6 = 0; i6 < currentMappedTrackInfo.getRendererCount(); i6++) {
                                if (currentMappedTrackInfo.getRendererType(i6) == 3) {
                                    Spark.m6670R(i6, currentMappedTrackInfo, spark.f11120i0.f12986C);
                                }
                            }
                            if (spark.f11120i0.f12986C.isEmpty()) {
                                size = -1;
                                break;
                            }
                            String string2 = spark.getResources().getString(R.string.close);
                            SubtitleMenu subtitleMenu = new SubtitleMenu(string2, string2, 0, 0, 0, false);
                            spark.f11120i0.f12986C.add(subtitleMenu);
                            if (TextUtils.isEmpty(str3)) {
                                size = -1;
                                break;
                            }
                            if (str3.equals(subtitleMenu.getLanguage()) && str3.equals(spark.getString(R.string.close))) {
                                spark.m6705U();
                                size = spark.f11120i0.f12986C.size() - 1;
                            } else {
                                int i10 = 0;
                                while (true) {
                                    if (i10 >= spark.f11120i0.f12986C.size()) {
                                        size = -1;
                                        break;
                                    } else {
                                        if (str3.equalsIgnoreCase(((SubtitleMenu) spark.f11120i0.f12986C.get(i10)).getLanguage())) {
                                            size = i10;
                                            break;
                                        }
                                        i10++;
                                    }
                                }
                            }
                            if (!spark.f11120i0.f12986C.isEmpty() && size == -1) {
                                size = TextUtils.isEmpty(AbstractC2442h.f8585G) ? spark.f11120i0.f12986C.size() - 1 : C3333o.m6768b(spark.f11120i0.f12986C, AbstractC2442h.f8585G);
                            }
                            int i11 = 0;
                            while (i11 < spark.f11120i0.f12986C.size()) {
                                ((SubtitleMenu) spark.f11120i0.f12986C.get(i11)).setSelected(i11 == size);
                                i11++;
                            }
                            spark.f11120i0.f13007t = size;
                            spark.f11083R1 = new C2446j(spark, size, 1);
                            String str4 = AbstractC0032a.m165s("BwP/Xc/ML7YVBP940tYvxQwP/XT1zyiRCRLndOrTOZFaRg==\n", "YGaLEaa6SuU=\n") + spark.f11120i0.f12986C.size();
                            boolean z11 = AbstractC3331m.f11244b;
                            Log.m5049i(str, str4);
                        }
                    }
                }
                if (spark.f11120i0.f12986C.isEmpty()) {
                    return;
                }
                spark.f11120i0.f12990G = false;
                return;
            }
            C3877a c3877a = spark.f11120i0;
            c3877a.f12990G = false;
            c3877a.f12985B.clear();
            spark.f11120i0.f12987D.clear();
            boolean z12 = Spark.f11017m2 == 1;
            if (z12) {
                MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo2 = spark.f11074O1.getCurrentMappedTrackInfo();
                if (currentMappedTrackInfo2 == null) {
                    spark.f11120i0.f12990G = true;
                } else {
                    for (int i12 = 0; i12 < currentMappedTrackInfo2.getRendererCount(); i12++) {
                        if (currentMappedTrackInfo2.getRendererType(i12) == 3) {
                            Spark.m6670R(i12, currentMappedTrackInfo2, spark.f11120i0.f12985B);
                        } else if (currentMappedTrackInfo2.getRendererType(i12) == 1) {
                            Spark.m6670R(i12, currentMappedTrackInfo2, spark.f11120i0.f12987D);
                        }
                    }
                    zIsEmpty = spark.f11120i0.f12985B.isEmpty();
                    if (!zIsEmpty) {
                        String string3 = spark.getResources().getString(R.string.close);
                        spark.f11120i0.f12985B.add(new SubtitleMenu(string3, string3, 0, 0, 0, false));
                    }
                    spark.f11154y0.mo5549a(spark.f11120i0.f12985B);
                    spark.f11151x0.mo5549a(spark.f11120i0.f12987D);
                    int size2 = TextUtils.isEmpty(AbstractC2442h.f8585G) ? spark.f11120i0.f12985B.size() - 1 : C3333o.m6768b(spark.f11120i0.f12985B, AbstractC2442h.f8585G);
                    C3877a c3877a2 = spark.f11120i0;
                    c3877a2.f13007t = size2;
                    spark.f11154y0.f8752e = size2;
                    int iM6768b = C3333o.m6768b(c3877a2.f12987D, AbstractC2442h.f8584F);
                    spark.f11120i0.f13008u = iM6768b;
                    spark.f11151x0.f8752e = iM6768b;
                    if (!zIsEmpty) {
                        spark.f11083R1 = new C2446j(spark, size2, 0);
                    }
                }
                spark.m6700P0();
                if (spark.f11120i0.f12987D.isEmpty() || !spark.f11120i0.f12985B.isEmpty()) {
                    spark.f11120i0.f12990G = false;
                }
                return;
            }
            spark.f11154y0.mo5549a(spark.f11120i0.f12985B);
            spark.f11151x0.mo5549a(spark.f11120i0.f12987D);
            zIsEmpty = false;
            if (zIsEmpty) {
                spark.f11120i0.f12990G = true;
            }
            ((VodMenu) spark.f11120i0.f12989F.get(2)).setEnable(!zIsEmpty && z12);
            ((VodMenu) spark.f11120i0.f12989F.get(1)).setEnable(!spark.f11120i0.f12987D.isEmpty() && z12);
            String str5 = AbstractC0032a.m165s("Rj9MW7OCBg5Sekt6o5cMEU0/Ai8=\n", "IVo4D8HjZWU=\n") + spark.f11120i0.f12985B.size();
            boolean z13 = AbstractC3331m.f11244b;
            Log.m5049i(str, str5);
            Log.m5049i(str, AbstractC0032a.m165s("G+2bOHZTQeAPqI4ZYFtNxxX7m1Yk\n", "fIjvbAQyIos=\n") + spark.f11120i0.f12987D.size());
            spark.m6700P0();
            if (spark.f11120i0.f12987D.isEmpty()) {
            }
            spark.f11120i0.f12990G = false;
        }
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

    @Override
    public final void onLoadingChanged(boolean z7) {
    }

    @Override
    public final void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
    }
}

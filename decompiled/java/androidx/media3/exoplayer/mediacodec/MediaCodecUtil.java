package androidx.media3.exoplayer.mediacodec;

import android.annotation.SuppressLint;
import android.media.MediaCodecList;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import androidx.media3.common.C0565C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import p000a.AbstractC0004e;
import p020b7.AbstractC1332b;
import p041d7.AbstractC2301u1;
import p041d7.C2180c5;
import p041d7.C2204g1;
import p041d7.C2288s1;

@SuppressLint({"InlinedApi"})
@UnstableApi
public final class MediaCodecUtil {
    private static final String TAG = "MediaCodecUtil";
    private static final HashMap<CodecKey, List<MediaCodecInfo>> decoderInfosCache = new HashMap<>();
    private static int maxH264DecodableFrameSize = -1;

    public static final class CodecKey {
        public final String mimeType;
        public final boolean secure;
        public final boolean tunneling;

        public CodecKey(String str, boolean z7, boolean z10) {
            this.mimeType = str;
            this.secure = z7;
            this.tunneling = z10;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != CodecKey.class) {
                return false;
            }
            CodecKey codecKey = (CodecKey) obj;
            return TextUtils.equals(this.mimeType, codecKey.mimeType) && this.secure == codecKey.secure && this.tunneling == codecKey.tunneling;
        }

        public int hashCode() {
            return ((AbstractC0004e.m14h(31, 31, this.mimeType) + (this.secure ? 1231 : 1237)) * 31) + (this.tunneling ? 1231 : 1237);
        }
    }

    public static class DecoderQueryException extends Exception {
        private DecoderQueryException(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    public interface MediaCodecListCompat {
        int getCodecCount();

        android.media.MediaCodecInfo getCodecInfoAt(int i6);

        boolean isFeatureRequired(String str, String str2, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean isFeatureSupported(String str, String str2, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean secureDecodersExplicit();
    }

    public static final class MediaCodecListCompatV16 implements MediaCodecListCompat {
        private MediaCodecListCompatV16() {
        }

        @Override
        public int getCodecCount() {
            return MediaCodecList.getCodecCount();
        }

        @Override
        public android.media.MediaCodecInfo getCodecInfoAt(int i6) {
            return MediaCodecList.getCodecInfoAt(i6);
        }

        @Override
        public boolean isFeatureRequired(String str, String str2, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        @Override
        public boolean isFeatureSupported(String str, String str2, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && MimeTypes.VIDEO_H264.equals(str2);
        }

        @Override
        public boolean secureDecodersExplicit() {
            return false;
        }
    }

    public static final class MediaCodecListCompatV21 implements MediaCodecListCompat {
        private final int codecKind;
        private android.media.MediaCodecInfo[] mediaCodecInfos;

        public MediaCodecListCompatV21(boolean z7, boolean z10, boolean z11) {
            this.codecKind = (z7 || z10 || z11) ? 1 : 0;
        }

        private void ensureMediaCodecInfosInitialized() {
            if (this.mediaCodecInfos == null) {
                this.mediaCodecInfos = new MediaCodecList(this.codecKind).getCodecInfos();
            }
        }

        @Override
        public int getCodecCount() {
            ensureMediaCodecInfosInitialized();
            return this.mediaCodecInfos.length;
        }

        @Override
        public android.media.MediaCodecInfo getCodecInfoAt(int i6) {
            ensureMediaCodecInfosInitialized();
            return this.mediaCodecInfos[i6];
        }

        @Override
        public boolean isFeatureRequired(String str, String str2, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        @Override
        public boolean isFeatureSupported(String str, String str2, android.media.MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        @Override
        public boolean secureDecodersExplicit() {
            return true;
        }
    }

    public interface ScoreProvider<T> {
        int getScore(T t5);
    }

    private MediaCodecUtil() {
    }

    private static void applyWorkarounds(String str, List<MediaCodecInfo> list) {
        if (MimeTypes.AUDIO_RAW.equals(str)) {
            if (Util.SDK_INT < 26 && Build.DEVICE.equals("R9") && list.size() == 1 && list.get(0).name.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(MediaCodecInfo.newInstance("OMX.google.raw.decoder", MimeTypes.AUDIO_RAW, MimeTypes.AUDIO_RAW, null, false, true, false, false, false));
            }
            sortByScore(list, new C0822l(1));
        }
        if (Util.SDK_INT >= 32 || list.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(list.get(0).name)) {
            return;
        }
        list.add(list.remove(0));
    }

    private static int avcLevelToMaxFrameSize(int i6) {
        if (i6 == 1 || i6 == 2) {
            return 25344;
        }
        switch (i6) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case C0565C.DEFAULT_BUFFER_SEGMENT_SIZE:
                return 9437184;
            case 131072:
            case 262144:
            case 524288:
                return 35651584;
            default:
                return -1;
        }
    }

    public static synchronized void clearDecoderInfoCache() {
        decoderInfosCache.clear();
    }

    public static String getAlternativeCodecMimeType(Format format) {
        Pair<Integer, Integer> codecProfileAndLevel;
        if (MimeTypes.AUDIO_E_AC3_JOC.equals(format.sampleMimeType)) {
            return MimeTypes.AUDIO_E_AC3;
        }
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType) && (codecProfileAndLevel = getCodecProfileAndLevel(format)) != null) {
            int iIntValue = ((Integer) codecProfileAndLevel.first).intValue();
            if (iIntValue == 16 || iIntValue == 256) {
                return MimeTypes.VIDEO_H265;
            }
            if (iIntValue == 512) {
                return MimeTypes.VIDEO_H264;
            }
            if (iIntValue == 1024) {
                return MimeTypes.VIDEO_AV1;
            }
        }
        if (MimeTypes.VIDEO_MV_HEVC.equals(format.sampleMimeType)) {
            return MimeTypes.VIDEO_H265;
        }
        return null;
    }

    public static List<MediaCodecInfo> getAlternativeDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z7, boolean z10) throws DecoderQueryException {
        String alternativeCodecMimeType = getAlternativeCodecMimeType(format);
        if (alternativeCodecMimeType != null) {
            return mediaCodecSelector.getDecoderInfos(alternativeCodecMimeType, z7, z10);
        }
        C2204g1 c2204g1 = AbstractC2301u1.f8069b;
        return C2180c5.f7862e;
    }

    private static String getCodecMimeType(android.media.MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals(MimeTypes.VIDEO_DOLBY_VISION)) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        }
        if (str2.equals(MimeTypes.VIDEO_MV_HEVC)) {
            if ("c2.qti.mvhevc.decoder".equals(str) || "c2.qti.mvhevc.decoder.secure".equals(str)) {
                return "video/x-mvhevc";
            }
            return null;
        }
        if (str2.equals(MimeTypes.AUDIO_ALAC) && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals(MimeTypes.AUDIO_FLAC) && "OMX.lge.flac.decoder".equals(str)) {
            return "audio/x-lg-flac";
        }
        if (str2.equals(MimeTypes.AUDIO_AC3) && "OMX.lge.ac3.decoder".equals(str)) {
            return "audio/lg-ac3";
        }
        return null;
    }

    @Deprecated
    public static Pair<Integer, Integer> getCodecProfileAndLevel(Format format) {
        return CodecSpecificDataUtil.getCodecProfileAndLevel(format);
    }

    public static MediaCodecInfo getDecoderInfo(String str, boolean z7, boolean z10) throws DecoderQueryException {
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(str, z7, z10);
        if (decoderInfos.isEmpty()) {
            return null;
        }
        return decoderInfos.get(0);
    }

    public static synchronized List<MediaCodecInfo> getDecoderInfos(String str, boolean z7, boolean z10) throws DecoderQueryException {
        try {
            CodecKey codecKey = new CodecKey(str, z7, z10);
            HashMap<CodecKey, List<MediaCodecInfo>> map = decoderInfosCache;
            List<MediaCodecInfo> list = map.get(codecKey);
            if (list != null) {
                return list;
            }
            ArrayList<MediaCodecInfo> decoderInfosInternal = getDecoderInfosInternal(codecKey, new MediaCodecListCompatV21(z7, z10, str.equals(MimeTypes.VIDEO_MV_HEVC)));
            if (z7 && decoderInfosInternal.isEmpty() && Util.SDK_INT <= 23) {
                decoderInfosInternal = getDecoderInfosInternal(codecKey, new MediaCodecListCompatV16());
                if (!decoderInfosInternal.isEmpty()) {
                    Log.m1719w(TAG, "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + decoderInfosInternal.get(0).name);
                }
            }
            applyWorkarounds(str, decoderInfosInternal);
            AbstractC2301u1 abstractC2301u1M5272n = AbstractC2301u1.m5272n(decoderInfosInternal);
            map.put(codecKey, abstractC2301u1M5272n);
            return abstractC2301u1M5272n;
        } catch (Throwable th) {
            throw th;
        }
    }

    private static ArrayList<MediaCodecInfo> getDecoderInfosInternal(CodecKey codecKey, MediaCodecListCompat mediaCodecListCompat) throws DecoderQueryException {
        String codecMimeType;
        String str;
        int i6;
        boolean z7;
        int i10;
        CodecKey codecKey2 = codecKey;
        try {
            ArrayList<MediaCodecInfo> arrayList = new ArrayList<>();
            String str2 = codecKey2.mimeType;
            int codecCount = mediaCodecListCompat.getCodecCount();
            boolean zSecureDecodersExplicit = mediaCodecListCompat.secureDecodersExplicit();
            int i11 = 0;
            while (i11 < codecCount) {
                android.media.MediaCodecInfo codecInfoAt = mediaCodecListCompat.getCodecInfoAt(i11);
                if (isAlias(codecInfoAt)) {
                    i6 = i11;
                    z7 = zSecureDecodersExplicit;
                    i10 = codecCount;
                } else {
                    String name = codecInfoAt.getName();
                    if (isCodecUsableDecoder(codecInfoAt, name, zSecureDecodersExplicit, str2) && (codecMimeType = getCodecMimeType(codecInfoAt, name, str2)) != null) {
                        try {
                            android.media.MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(codecMimeType);
                            boolean zIsFeatureSupported = mediaCodecListCompat.isFeatureSupported("tunneled-playback", codecMimeType, capabilitiesForType);
                            boolean zIsFeatureRequired = mediaCodecListCompat.isFeatureRequired("tunneled-playback", codecMimeType, capabilitiesForType);
                            boolean z10 = codecKey2.tunneling;
                            if ((z10 || !zIsFeatureRequired) && (!z10 || zIsFeatureSupported)) {
                                boolean zIsFeatureSupported2 = mediaCodecListCompat.isFeatureSupported("secure-playback", codecMimeType, capabilitiesForType);
                                boolean zIsFeatureRequired2 = mediaCodecListCompat.isFeatureRequired("secure-playback", codecMimeType, capabilitiesForType);
                                boolean z11 = codecKey2.secure;
                                if ((z11 || !zIsFeatureRequired2) && (!z11 || zIsFeatureSupported2)) {
                                    boolean zIsHardwareAccelerated = isHardwareAccelerated(codecInfoAt, str2);
                                    boolean zIsSoftwareOnly = isSoftwareOnly(codecInfoAt, str2);
                                    boolean zIsVendor = isVendor(codecInfoAt);
                                    if (zSecureDecodersExplicit && codecKey2.secure == zIsFeatureSupported2) {
                                        i6 = i11;
                                        z7 = zSecureDecodersExplicit;
                                        i10 = codecCount;
                                        arrayList.add(MediaCodecInfo.newInstance(name, str2, codecMimeType, capabilitiesForType, zIsHardwareAccelerated, zIsSoftwareOnly, zIsVendor, false, false));
                                    } else {
                                        if (!zSecureDecodersExplicit) {
                                            try {
                                                if (!codecKey2.secure) {
                                                    i6 = i11;
                                                    z7 = zSecureDecodersExplicit;
                                                    i10 = codecCount;
                                                    try {
                                                        arrayList.add(MediaCodecInfo.newInstance(name, str2, codecMimeType, capabilitiesForType, zIsHardwareAccelerated, zIsSoftwareOnly, zIsVendor, false, false));
                                                    } catch (Exception e5) {
                                                        e = e5;
                                                        str = name;
                                                        if (Util.SDK_INT <= 23) {
                                                        }
                                                        Log.m1715e(TAG, "Failed to query codec " + str + " (" + codecMimeType + ")");
                                                        throw e;
                                                    }
                                                }
                                            } catch (Exception e10) {
                                                e = e10;
                                                i6 = i11;
                                                z7 = zSecureDecodersExplicit;
                                                i10 = codecCount;
                                                str = name;
                                                if (Util.SDK_INT <= 23 || arrayList.isEmpty()) {
                                                    Log.m1715e(TAG, "Failed to query codec " + str + " (" + codecMimeType + ")");
                                                    throw e;
                                                }
                                                Log.m1715e(TAG, "Skipping codec " + str + " (failed to query capabilities)");
                                                i11 = i6 + 1;
                                                codecKey2 = codecKey;
                                                codecCount = i10;
                                                zSecureDecodersExplicit = z7;
                                            }
                                        }
                                        codecMimeType = codecMimeType;
                                        i6 = i11;
                                        z7 = zSecureDecodersExplicit;
                                        i10 = codecCount;
                                        if (!z7 && zIsFeatureSupported2) {
                                            StringBuilder sb = new StringBuilder();
                                            try {
                                                sb.append(name);
                                                sb.append(".secure");
                                                str = name;
                                                try {
                                                    arrayList.add(MediaCodecInfo.newInstance(sb.toString(), str2, codecMimeType, capabilitiesForType, zIsHardwareAccelerated, zIsSoftwareOnly, zIsVendor, false, true));
                                                    return arrayList;
                                                } catch (Exception e11) {
                                                    e = e11;
                                                    if (Util.SDK_INT <= 23) {
                                                    }
                                                    Log.m1715e(TAG, "Failed to query codec " + str + " (" + codecMimeType + ")");
                                                    throw e;
                                                }
                                            } catch (Exception e12) {
                                                e = e12;
                                                str = name;
                                            }
                                        }
                                    }
                                } else {
                                    i6 = i11;
                                    z7 = zSecureDecodersExplicit;
                                    i10 = codecCount;
                                }
                            } else {
                                i6 = i11;
                                z7 = zSecureDecodersExplicit;
                                i10 = codecCount;
                            }
                        } catch (Exception e13) {
                            e = e13;
                            codecMimeType = codecMimeType;
                            str = name;
                            i6 = i11;
                            z7 = zSecureDecodersExplicit;
                            i10 = codecCount;
                        }
                    } else {
                        i6 = i11;
                        z7 = zSecureDecodersExplicit;
                        i10 = codecCount;
                    }
                }
                i11 = i6 + 1;
                codecKey2 = codecKey;
                codecCount = i10;
                zSecureDecodersExplicit = z7;
            }
            return arrayList;
        } catch (Exception e14) {
            throw new DecoderQueryException(e14);
        }
    }

    public static List<MediaCodecInfo> getDecoderInfosSoftMatch(MediaCodecSelector mediaCodecSelector, Format format, boolean z7, boolean z10) throws DecoderQueryException {
        List<MediaCodecInfo> decoderInfos = mediaCodecSelector.getDecoderInfos(format.sampleMimeType, z7, z10);
        List<MediaCodecInfo> alternativeDecoderInfos = getAlternativeDecoderInfos(mediaCodecSelector, format, z7, z10);
        C2288s1 c2288s1M5269k = AbstractC2301u1.m5269k();
        c2288s1M5269k.m5257d(decoderInfos);
        c2288s1M5269k.m5257d(alternativeDecoderInfos);
        return c2288s1M5269k.m5262g();
    }

    public static List<MediaCodecInfo> getDecoderInfosSortedByFormatSupport(List<MediaCodecInfo> list, Format format) {
        ArrayList arrayList = new ArrayList(list);
        sortByScore(arrayList, new C0823m(format, 1));
        return arrayList;
    }

    public static List<MediaCodecInfo> getDecoderInfosSortedByFullFormatSupport(List<MediaCodecInfo> list, Format format) {
        ArrayList arrayList = new ArrayList(list);
        sortByScore(arrayList, new C0823m(format, 0));
        return arrayList;
    }

    public static List<MediaCodecInfo> getDecoderInfosSortedBySoftwareOnly(List<MediaCodecInfo> list) {
        ArrayList arrayList = new ArrayList(list);
        sortByScore(arrayList, new C0822l(0));
        return AbstractC2301u1.m5272n(arrayList);
    }

    public static MediaCodecInfo getDecryptOnlyDecoderInfo() throws DecoderQueryException {
        return getDecoderInfo(MimeTypes.AUDIO_RAW, false, false);
    }

    public static Pair<Integer, Integer> getHevcBaseLayerCodecProfileAndLevel(Format format) {
        String h265BaseLayerCodecsString = NalUnitUtil.getH265BaseLayerCodecsString(format.initializationData);
        if (h265BaseLayerCodecsString == null) {
            return null;
        }
        return CodecSpecificDataUtil.getHevcProfileAndLevel(h265BaseLayerCodecsString, Util.split(h265BaseLayerCodecsString.trim(), "\\."), format.colorInfo);
    }

    private static boolean isAlias(android.media.MediaCodecInfo mediaCodecInfo) {
        return Util.SDK_INT >= 29 && isAliasV29(mediaCodecInfo);
    }

    private static boolean isAliasV29(android.media.MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isAlias();
    }

    private static boolean isCodecUsableDecoder(android.media.MediaCodecInfo mediaCodecInfo, String str, boolean z7, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z7 && str.endsWith(".secure"))) {
            return false;
        }
        int i6 = Util.SDK_INT;
        if (i6 < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(Build.MANUFACTURER))) {
            String str3 = Build.DEVICE;
            if (str3.startsWith("zeroflte") || str3.startsWith("zerolte") || str3.startsWith("zenlte") || "SC-05G".equals(str3) || "marinelteatt".equals(str3) || "404SC".equals(str3) || "SC-04G".equals(str3) || "SCV31".equals(str3)) {
                return false;
            }
        }
        return (i6 <= 23 && MimeTypes.AUDIO_E_AC3_JOC.equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }

    private static boolean isHardwareAccelerated(android.media.MediaCodecInfo mediaCodecInfo, String str) {
        return Util.SDK_INT >= 29 ? isHardwareAcceleratedV29(mediaCodecInfo) : !isSoftwareOnly(mediaCodecInfo, str);
    }

    private static boolean isHardwareAcceleratedV29(android.media.MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }

    private static boolean isSoftwareOnly(android.media.MediaCodecInfo mediaCodecInfo, String str) {
        if (Util.SDK_INT >= 29) {
            return isSoftwareOnlyV29(mediaCodecInfo);
        }
        if (MimeTypes.isAudio(str)) {
            return true;
        }
        String strM3231v = AbstractC1332b.m3231v(mediaCodecInfo.getName());
        if (strM3231v.startsWith("arc.")) {
            return false;
        }
        if (strM3231v.startsWith("omx.google.") || strM3231v.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((strM3231v.startsWith("omx.sec.") && strM3231v.contains(".sw.")) || strM3231v.equals("omx.qcom.video.decoder.hevcswvdec") || strM3231v.startsWith("c2.android.") || strM3231v.startsWith("c2.google.")) {
            return true;
        }
        return (strM3231v.startsWith("omx.") || strM3231v.startsWith("c2.")) ? false : true;
    }

    private static boolean isSoftwareOnlyV29(android.media.MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }

    private static boolean isVendor(android.media.MediaCodecInfo mediaCodecInfo) {
        if (Util.SDK_INT >= 29) {
            return isVendorV29(mediaCodecInfo);
        }
        String strM3231v = AbstractC1332b.m3231v(mediaCodecInfo.getName());
        return (strM3231v.startsWith("omx.google.") || strM3231v.startsWith("c2.android.") || strM3231v.startsWith("c2.google.")) ? false : true;
    }

    private static boolean isVendorV29(android.media.MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isVendor();
    }

    public static int lambda$applyWorkarounds$3(MediaCodecInfo mediaCodecInfo) {
        String str = mediaCodecInfo.name;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (Util.SDK_INT >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }

    public static int lambda$getDecoderInfosSortedByFormatSupport$0(Format format, MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isFormatFunctionallySupported(format) ? 1 : 0;
    }

    public static int lambda$getDecoderInfosSortedByFullFormatSupport$1(Format format, MediaCodecInfo mediaCodecInfo) {
        try {
            return mediaCodecInfo.isFormatSupported(format) ? 1 : 0;
        } catch (DecoderQueryException unused) {
            return -1;
        }
    }

    public static int lambda$getDecoderInfosSortedBySoftwareOnly$2(MediaCodecInfo mediaCodecInfo) {
        return (mediaCodecInfo.softwareOnly ? 2 : 0) + (!mediaCodecInfo.vendor ? 1 : 0);
    }

    public static int lambda$sortByScore$4(ScoreProvider scoreProvider, Object obj, Object obj2) {
        return scoreProvider.getScore(obj2) - scoreProvider.getScore(obj);
    }

    public static int maxH264DecodableFrameSize() throws DecoderQueryException {
        if (maxH264DecodableFrameSize == -1) {
            int iMax = 0;
            MediaCodecInfo decoderInfo = getDecoderInfo(MimeTypes.VIDEO_H264, false, false);
            if (decoderInfo != null) {
                android.media.MediaCodecInfo.CodecProfileLevel[] profileLevels = decoderInfo.getProfileLevels();
                int length = profileLevels.length;
                int iMax2 = 0;
                while (iMax < length) {
                    iMax2 = Math.max(avcLevelToMaxFrameSize(profileLevels[iMax].level), iMax2);
                    iMax++;
                }
                iMax = Math.max(iMax2, 345600);
            }
            maxH264DecodableFrameSize = iMax;
        }
        return maxH264DecodableFrameSize;
    }

    private static <T> void sortByScore(List<T> list, final ScoreProvider<T> scoreProvider) {
        Collections.sort(list, new Comparator() {
            @Override
            public final int compare(Object obj, Object obj2) {
                return MediaCodecUtil.lambda$sortByScore$4(scoreProvider, obj, obj2);
            }
        });
    }

    public static void warmDecoderInfoCache(String str, boolean z7, boolean z10) {
        try {
            getDecoderInfos(str, z7, z10);
        } catch (DecoderQueryException e5) {
            Log.m1716e(TAG, "Codec warming failed", e5);
        }
    }
}

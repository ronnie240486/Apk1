package androidx.media3.common.util;

import android.annotation.SuppressLint;
import android.util.Pair;
import androidx.media3.common.C0565C;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.jessyan.autosize.BuildConfig;
import okhttp3.internal.http2.Http2Connection;
import p000a.AbstractC0004e;
import p041d7.AbstractC2301u1;

@SuppressLint({"InlinedApi"})
@UnstableApi
public final class CodecSpecificDataUtil {
    private static final String CODEC_ID_AV01 = "av01";
    private static final String CODEC_ID_AVC1 = "avc1";
    private static final String CODEC_ID_AVC2 = "avc2";
    private static final String CODEC_ID_H263 = "s263";
    private static final String CODEC_ID_HEV1 = "hev1";
    private static final String CODEC_ID_HVC1 = "hvc1";
    private static final String CODEC_ID_MP4A = "mp4a";
    private static final String CODEC_ID_VP09 = "vp09";
    private static final int EXTENDED_PAR = 15;
    private static final int RECTANGULAR = 0;
    private static final String TAG = "CodecSpecificDataUtil";
    private static final int VISUAL_OBJECT_LAYER = 1;
    private static final int VISUAL_OBJECT_LAYER_START = 32;
    private static final byte[] NAL_START_CODE = {0, 0, 0, 1};
    private static final String[] HEVC_GENERAL_PROFILE_SPACE_STRINGS = {"", "A", "B", "C"};
    private static final Pattern PROFILE_PATTERN = Pattern.compile("^\\D?(\\d+)$");

    private CodecSpecificDataUtil() {
    }

    private static int av1LevelNumberToConst(int i6) {
        switch (i6) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return 4096;
            case 13:
                return 8192;
            case 14:
                return 16384;
            case 15:
                return 32768;
            case 16:
                return C0565C.DEFAULT_BUFFER_SEGMENT_SIZE;
            case 17:
                return 131072;
            case 18:
                return 262144;
            case 19:
                return 524288;
            case 20:
                return ProgressiveMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES;
            case 21:
                return 2097152;
            case 22:
                return 4194304;
            case 23:
                return 8388608;
            default:
                return -1;
        }
    }

    private static int avcLevelNumberToConst(int i6) {
        switch (i6) {
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 8;
            case 13:
                return 16;
            default:
                switch (i6) {
                    case 20:
                        return 32;
                    case 21:
                        return 64;
                    case 22:
                        return 128;
                    default:
                        switch (i6) {
                            case 30:
                                return 256;
                            case 31:
                                return 512;
                            case 32:
                                return 1024;
                            default:
                                switch (i6) {
                                    case NalUnitUtil.H265_NAL_UNIT_TYPE_SUFFIX_SEI:
                                        return 2048;
                                    case BuildConfig.VERSION_CODE:
                                        return 4096;
                                    case AacUtil.AUDIO_OBJECT_TYPE_AAC_XHE:
                                        return 8192;
                                    default:
                                        switch (i6) {
                                            case DefaultRenderersFactory.MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY:
                                                return 16384;
                                            case 51:
                                                return 32768;
                                            case 52:
                                                return C0565C.DEFAULT_BUFFER_SEGMENT_SIZE;
                                            default:
                                                return -1;
                                        }
                                }
                        }
                }
        }
    }

    private static int avcProfileNumberToConst(int i6) {
        if (i6 == 66) {
            return 1;
        }
        if (i6 == 77) {
            return 2;
        }
        if (i6 == 88) {
            return 4;
        }
        if (i6 == 100) {
            return 8;
        }
        if (i6 == 110) {
            return 16;
        }
        if (i6 != 122) {
            return i6 != 244 ? -1 : 64;
        }
        return 32;
    }

    public static String buildAvcCodecString(int i6, int i10, int i11) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i6), Integer.valueOf(i10), Integer.valueOf(i11));
    }

    public static List<byte[]> buildCea708InitializationData(boolean z7) {
        return Collections.singletonList(z7 ? new byte[]{1} : new byte[]{0});
    }

    public static String buildH263CodecString(int i6, int i10) {
        return Util.formatInvariant("s263.%d.%d", Integer.valueOf(i6), Integer.valueOf(i10));
    }

    public static String buildHevcCodecString(int i6, boolean z7, int i10, int i11, int[] iArr, int i12) {
        StringBuilder sb = new StringBuilder(Util.formatInvariant("hvc1.%s%d.%X.%c%d", HEVC_GENERAL_PROFILE_SPACE_STRINGS[i6], Integer.valueOf(i10), Integer.valueOf(i11), Character.valueOf(z7 ? 'H' : 'L'), Integer.valueOf(i12)));
        int length = iArr.length;
        while (length > 0 && iArr[length - 1] == 0) {
            length--;
        }
        for (int i13 = 0; i13 < length; i13++) {
            sb.append(String.format(".%02X", Integer.valueOf(iArr[i13])));
        }
        return sb.toString();
    }

    public static byte[] buildNalUnit(byte[] bArr, int i6, int i10) {
        byte[] bArr2 = NAL_START_CODE;
        byte[] bArr3 = new byte[bArr2.length + i10];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i6, bArr3, bArr2.length, i10);
        return bArr3;
    }

    public static AbstractC2301u1 buildVp9CodecPrivateInitializationData(byte b8, byte b10, byte b11, byte b12) {
        return AbstractC2301u1.m5275r(new byte[]{1, 1, b8, 2, 1, b10, 3, 1, b11, 4, 1, b12});
    }

    private static Integer dolbyVisionStringToLevel(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
            case "01":
                return 1;
            case "02":
                return 2;
            case "03":
                return 4;
            case "04":
                return 8;
            case "05":
                return 16;
            case "06":
                return 32;
            case "07":
                return 64;
            case "08":
                return 128;
            case "09":
                return 256;
            case "10":
                return 512;
            case "11":
                return 1024;
            case "12":
                return 2048;
            case "13":
                return 4096;
            default:
                return null;
        }
    }

    private static Integer dolbyVisionStringToProfile(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
            case "00":
                return 1;
            case "01":
                return 2;
            case "02":
                return 4;
            case "03":
                return 8;
            case "04":
                return 16;
            case "05":
                return 32;
            case "06":
                return 64;
            case "07":
                return 128;
            case "08":
                return 256;
            case "09":
                return 512;
            case "10":
                return 1024;
            default:
                return null;
        }
    }

    private static int findNalStartCode(byte[] bArr, int i6) {
        int length = bArr.length - NAL_START_CODE.length;
        while (i6 <= length) {
            if (isNalStartCode(bArr, i6)) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    private static Pair<Integer, Integer> getAacCodecProfileAndLevel(String str, String[] strArr) {
        int iMp4aAudioObjectTypeToProfile;
        if (strArr.length != 3) {
            AbstractC0004e.m4D("Ignoring malformed MP4A codec string: ", str, TAG);
            return null;
        }
        try {
            if (MimeTypes.AUDIO_AAC.equals(MimeTypes.getMimeTypeFromMp4ObjectType(Integer.parseInt(strArr[1], 16))) && (iMp4aAudioObjectTypeToProfile = mp4aAudioObjectTypeToProfile(Integer.parseInt(strArr[2]))) != -1) {
                return new Pair<>(Integer.valueOf(iMp4aAudioObjectTypeToProfile), 0);
            }
        } catch (NumberFormatException unused) {
            AbstractC0004e.m4D("Ignoring malformed MP4A codec string: ", str, TAG);
        }
        return null;
    }

    private static Pair<Integer, Integer> getAv1ProfileAndLevel(String str, String[] strArr, ColorInfo colorInfo) {
        int i6;
        if (strArr.length < 4) {
            AbstractC0004e.m4D("Ignoring malformed AV1 codec string: ", str, TAG);
            return null;
        }
        int i10 = 1;
        try {
            int i11 = Integer.parseInt(strArr[1]);
            int i12 = Integer.parseInt(strArr[2].substring(0, 2));
            int i13 = Integer.parseInt(strArr[3]);
            if (i11 != 0) {
                AbstractC0004e.m31y(i11, "Unknown AV1 profile: ", TAG);
                return null;
            }
            if (i13 != 8 && i13 != 10) {
                AbstractC0004e.m31y(i13, "Unknown AV1 bit depth: ", TAG);
                return null;
            }
            if (i13 != 8) {
                i10 = (colorInfo == null || !(colorInfo.hdrStaticInfo != null || (i6 = colorInfo.colorTransfer) == 7 || i6 == 6)) ? 2 : 4096;
            }
            int iAv1LevelNumberToConst = av1LevelNumberToConst(i12);
            if (iAv1LevelNumberToConst != -1) {
                return new Pair<>(Integer.valueOf(i10), Integer.valueOf(iAv1LevelNumberToConst));
            }
            AbstractC0004e.m31y(i12, "Unknown AV1 level: ", TAG);
            return null;
        } catch (NumberFormatException unused) {
            AbstractC0004e.m4D("Ignoring malformed AV1 codec string: ", str, TAG);
            return null;
        }
    }

    private static Pair<Integer, Integer> getAvcProfileAndLevel(String str, String[] strArr) {
        int i6;
        int i10;
        if (strArr.length < 2) {
            AbstractC0004e.m4D("Ignoring malformed AVC codec string: ", str, TAG);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                i10 = Integer.parseInt(strArr[1].substring(0, 2), 16);
                i6 = Integer.parseInt(strArr[1].substring(4), 16);
            } else {
                if (strArr.length < 3) {
                    Log.m1719w(TAG, "Ignoring malformed AVC codec string: " + str);
                    return null;
                }
                int i11 = Integer.parseInt(strArr[1]);
                i6 = Integer.parseInt(strArr[2]);
                i10 = i11;
            }
            int iAvcProfileNumberToConst = avcProfileNumberToConst(i10);
            if (iAvcProfileNumberToConst == -1) {
                AbstractC0004e.m31y(i10, "Unknown AVC profile: ", TAG);
                return null;
            }
            int iAvcLevelNumberToConst = avcLevelNumberToConst(i6);
            if (iAvcLevelNumberToConst != -1) {
                return new Pair<>(Integer.valueOf(iAvcProfileNumberToConst), Integer.valueOf(iAvcLevelNumberToConst));
            }
            AbstractC0004e.m31y(i6, "Unknown AVC level: ", TAG);
            return null;
        } catch (NumberFormatException unused) {
            AbstractC0004e.m4D("Ignoring malformed AVC codec string: ", str, TAG);
            return null;
        }
    }

    public static Pair<Integer, Integer> getCodecProfileAndLevel(Format format) {
        byte b8 = 0;
        String str = format.codecs;
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split("\\.");
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType)) {
            return getDolbyVisionProfileAndLevel(format.codecs, strArrSplit);
        }
        String str2 = strArrSplit[0];
        str2.getClass();
        switch (str2.hashCode()) {
            case 3004662:
                if (!str2.equals(CODEC_ID_AV01)) {
                    b8 = -1;
                }
                break;
            case 3006243:
                if (!str2.equals(CODEC_ID_AVC1)) {
                    b8 = -1;
                } else {
                    b8 = 1;
                }
                break;
            case 3006244:
                if (!str2.equals(CODEC_ID_AVC2)) {
                    b8 = -1;
                } else {
                    b8 = 2;
                }
                break;
            case 3199032:
                if (!str2.equals(CODEC_ID_HEV1)) {
                    b8 = -1;
                } else {
                    b8 = 3;
                }
                break;
            case 3214780:
                if (!str2.equals(CODEC_ID_HVC1)) {
                    b8 = -1;
                } else {
                    b8 = 4;
                }
                break;
            case 3356560:
                if (!str2.equals(CODEC_ID_MP4A)) {
                    b8 = -1;
                } else {
                    b8 = 5;
                }
                break;
            case 3475740:
                if (!str2.equals(CODEC_ID_H263)) {
                    b8 = -1;
                } else {
                    b8 = 6;
                }
                break;
            case 3624515:
                if (!str2.equals(CODEC_ID_VP09)) {
                    b8 = -1;
                } else {
                    b8 = 7;
                }
                break;
            default:
                b8 = -1;
                break;
        }
        switch (b8) {
            case 0:
                return getAv1ProfileAndLevel(format.codecs, strArrSplit, format.colorInfo);
            case 1:
            case 2:
                return getAvcProfileAndLevel(format.codecs, strArrSplit);
            case 3:
            case 4:
                return getHevcProfileAndLevel(format.codecs, strArrSplit, format.colorInfo);
            case 5:
                return getAacCodecProfileAndLevel(format.codecs, strArrSplit);
            case 6:
                return getH263ProfileAndLevel(format.codecs, strArrSplit);
            case 7:
                return getVp9ProfileAndLevel(format.codecs, strArrSplit);
            default:
                return null;
        }
    }

    private static Pair<Integer, Integer> getDolbyVisionProfileAndLevel(String str, String[] strArr) {
        if (strArr.length < 3) {
            AbstractC0004e.m4D("Ignoring malformed Dolby Vision codec string: ", str, TAG);
            return null;
        }
        Matcher matcher = PROFILE_PATTERN.matcher(strArr[1]);
        if (!matcher.matches()) {
            AbstractC0004e.m4D("Ignoring malformed Dolby Vision codec string: ", str, TAG);
            return null;
        }
        String strGroup = matcher.group(1);
        Integer numDolbyVisionStringToProfile = dolbyVisionStringToProfile(strGroup);
        if (numDolbyVisionStringToProfile == null) {
            AbstractC0004e.m4D("Unknown Dolby Vision profile string: ", strGroup, TAG);
            return null;
        }
        String str2 = strArr[2];
        Integer numDolbyVisionStringToLevel = dolbyVisionStringToLevel(str2);
        if (numDolbyVisionStringToLevel != null) {
            return new Pair<>(numDolbyVisionStringToProfile, numDolbyVisionStringToLevel);
        }
        AbstractC0004e.m4D("Unknown Dolby Vision level string: ", str2, TAG);
        return null;
    }

    private static Pair<Integer, Integer> getH263ProfileAndLevel(String str, String[] strArr) {
        Pair<Integer, Integer> pair = new Pair<>(1, 1);
        if (strArr.length < 3) {
            AbstractC0004e.m4D("Ignoring malformed H263 codec string: ", str, TAG);
            return pair;
        }
        try {
            return new Pair<>(Integer.valueOf(Integer.parseInt(strArr[1])), Integer.valueOf(Integer.parseInt(strArr[2])));
        } catch (NumberFormatException unused) {
            AbstractC0004e.m4D("Ignoring malformed H263 codec string: ", str, TAG);
            return pair;
        }
    }

    public static Pair<Integer, Integer> getHevcProfileAndLevel(String str, String[] strArr, ColorInfo colorInfo) {
        if (strArr.length < 4) {
            AbstractC0004e.m4D("Ignoring malformed HEVC codec string: ", str, TAG);
            return null;
        }
        int i6 = 1;
        Matcher matcher = PROFILE_PATTERN.matcher(strArr[1]);
        if (!matcher.matches()) {
            AbstractC0004e.m4D("Ignoring malformed HEVC codec string: ", str, TAG);
            return null;
        }
        String strGroup = matcher.group(1);
        if (!IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(strGroup)) {
            i6 = 6;
            if ("2".equals(strGroup)) {
                i6 = (colorInfo == null || colorInfo.colorTransfer != 6) ? 2 : 4096;
            } else if (!"6".equals(strGroup)) {
                AbstractC0004e.m4D("Unknown HEVC profile string: ", strGroup, TAG);
                return null;
            }
        }
        String str2 = strArr[3];
        Integer numHevcCodecStringToProfileLevel = hevcCodecStringToProfileLevel(str2);
        if (numHevcCodecStringToProfileLevel != null) {
            return new Pair<>(Integer.valueOf(i6), numHevcCodecStringToProfileLevel);
        }
        AbstractC0004e.m4D("Unknown HEVC level string: ", str2, TAG);
        return null;
    }

    public static Pair<Integer, Integer> getVideoResolutionFromMpeg4VideoConfig(byte[] bArr) {
        boolean z7;
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        int i6 = 0;
        int i10 = 0;
        while (true) {
            int i11 = i10 + 3;
            if (i11 >= bArr.length) {
                z7 = false;
                break;
            }
            if (parsableByteArray.readUnsignedInt24() == 1 && (bArr[i11] & 240) == 32) {
                z7 = true;
                break;
            }
            parsableByteArray.setPosition(parsableByteArray.getPosition() - 2);
            i10++;
        }
        Assertions.checkArgument(z7, "Invalid input: VOL not found.");
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        parsableBitArray.skipBits((i10 + 4) * 8);
        parsableBitArray.skipBits(1);
        parsableBitArray.skipBits(8);
        if (parsableBitArray.readBit()) {
            parsableBitArray.skipBits(4);
            parsableBitArray.skipBits(3);
        }
        if (parsableBitArray.readBits(4) == 15) {
            parsableBitArray.skipBits(8);
            parsableBitArray.skipBits(8);
        }
        if (parsableBitArray.readBit()) {
            parsableBitArray.skipBits(2);
            parsableBitArray.skipBits(1);
            if (parsableBitArray.readBit()) {
                parsableBitArray.skipBits(79);
            }
        }
        Assertions.checkArgument(parsableBitArray.readBits(2) == 0, "Only supports rectangular video object layer shape.");
        Assertions.checkArgument(parsableBitArray.readBit());
        int bits = parsableBitArray.readBits(16);
        Assertions.checkArgument(parsableBitArray.readBit());
        if (parsableBitArray.readBit()) {
            Assertions.checkArgument(bits > 0);
            for (int i12 = bits - 1; i12 > 0; i12 >>= 1) {
                i6++;
            }
            parsableBitArray.skipBits(i6);
        }
        Assertions.checkArgument(parsableBitArray.readBit());
        int bits2 = parsableBitArray.readBits(13);
        Assertions.checkArgument(parsableBitArray.readBit());
        int bits3 = parsableBitArray.readBits(13);
        Assertions.checkArgument(parsableBitArray.readBit());
        parsableBitArray.skipBits(1);
        return Pair.create(Integer.valueOf(bits2), Integer.valueOf(bits3));
    }

    private static Pair<Integer, Integer> getVp9ProfileAndLevel(String str, String[] strArr) {
        if (strArr.length < 3) {
            AbstractC0004e.m4D("Ignoring malformed VP9 codec string: ", str, TAG);
            return null;
        }
        try {
            int i6 = Integer.parseInt(strArr[1]);
            int i10 = Integer.parseInt(strArr[2]);
            int iVp9ProfileNumberToConst = vp9ProfileNumberToConst(i6);
            if (iVp9ProfileNumberToConst == -1) {
                AbstractC0004e.m31y(i6, "Unknown VP9 profile: ", TAG);
                return null;
            }
            int iVp9LevelNumberToConst = vp9LevelNumberToConst(i10);
            if (iVp9LevelNumberToConst != -1) {
                return new Pair<>(Integer.valueOf(iVp9ProfileNumberToConst), Integer.valueOf(iVp9LevelNumberToConst));
            }
            AbstractC0004e.m31y(i10, "Unknown VP9 level: ", TAG);
            return null;
        } catch (NumberFormatException unused) {
            AbstractC0004e.m4D("Ignoring malformed VP9 codec string: ", str, TAG);
            return null;
        }
    }

    private static Integer hevcCodecStringToProfileLevel(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
            case "H30":
                return 2;
            case "H60":
                return 8;
            case "H63":
                return 32;
            case "H90":
                return 128;
            case "H93":
                return 512;
            case "L30":
                return 1;
            case "L60":
                return 4;
            case "L63":
                return 16;
            case "L90":
                return 64;
            case "L93":
                return 256;
            case "H120":
                return 2048;
            case "H123":
                return 8192;
            case "H150":
                return 32768;
            case "H153":
                return 131072;
            case "H156":
                return 524288;
            case "H180":
                return 2097152;
            case "H183":
                return 8388608;
            case "H186":
                return 33554432;
            case "L120":
                return 1024;
            case "L123":
                return 4096;
            case "L150":
                return 16384;
            case "L153":
                return Integer.valueOf(C0565C.DEFAULT_BUFFER_SEGMENT_SIZE);
            case "L156":
                return 262144;
            case "L180":
                return Integer.valueOf(ProgressiveMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES);
            case "L183":
                return 4194304;
            case "L186":
                return Integer.valueOf(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
            default:
                return null;
        }
    }

    private static boolean isNalStartCode(byte[] bArr, int i6) {
        if (bArr.length - i6 <= NAL_START_CODE.length) {
            return false;
        }
        int i10 = 0;
        while (true) {
            byte[] bArr2 = NAL_START_CODE;
            if (i10 >= bArr2.length) {
                return true;
            }
            if (bArr[i6 + i10] != bArr2[i10]) {
                return false;
            }
            i10++;
        }
    }

    private static int mp4aAudioObjectTypeToProfile(int i6) {
        int i10 = 17;
        if (i6 != 17) {
            i10 = 20;
            if (i6 != 20) {
                i10 = 23;
                if (i6 != 23) {
                    i10 = 29;
                    if (i6 != 29) {
                        i10 = 39;
                        if (i6 != 39) {
                            i10 = 42;
                            if (i6 != 42) {
                                switch (i6) {
                                    case 1:
                                        return 1;
                                    case 2:
                                        return 2;
                                    case 3:
                                        return 3;
                                    case 4:
                                        return 4;
                                    case 5:
                                        return 5;
                                    case 6:
                                        return 6;
                                    default:
                                        return -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i10;
    }

    public static Pair<Integer, Integer> parseAlacAudioSpecificConfig(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        parsableByteArray.setPosition(9);
        int unsignedByte = parsableByteArray.readUnsignedByte();
        parsableByteArray.setPosition(20);
        return Pair.create(Integer.valueOf(parsableByteArray.readUnsignedIntToInt()), Integer.valueOf(unsignedByte));
    }

    public static boolean parseCea708InitializationData(List<byte[]> list) {
        return list.size() == 1 && list.get(0).length == 1 && list.get(0)[0] == 1;
    }

    public static byte[][] splitNalUnits(byte[] bArr) {
        if (!isNalStartCode(bArr, 0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int iFindNalStartCode = 0;
        do {
            arrayList.add(Integer.valueOf(iFindNalStartCode));
            iFindNalStartCode = findNalStartCode(bArr, iFindNalStartCode + NAL_START_CODE.length);
        } while (iFindNalStartCode != -1);
        byte[][] bArr2 = new byte[arrayList.size()][];
        int i6 = 0;
        while (i6 < arrayList.size()) {
            int iIntValue = ((Integer) arrayList.get(i6)).intValue();
            int iIntValue2 = (i6 < arrayList.size() + (-1) ? ((Integer) arrayList.get(i6 + 1)).intValue() : bArr.length) - iIntValue;
            byte[] bArr3 = new byte[iIntValue2];
            System.arraycopy(bArr, iIntValue, bArr3, 0, iIntValue2);
            bArr2[i6] = bArr3;
            i6++;
        }
        return bArr2;
    }

    private static int vp9LevelNumberToConst(int i6) {
        if (i6 == 10) {
            return 1;
        }
        if (i6 == 11) {
            return 2;
        }
        if (i6 == 20) {
            return 4;
        }
        if (i6 == 21) {
            return 8;
        }
        if (i6 == 30) {
            return 16;
        }
        if (i6 == 31) {
            return 32;
        }
        if (i6 == 40) {
            return 64;
        }
        if (i6 == 41) {
            return 128;
        }
        if (i6 == 50) {
            return 256;
        }
        if (i6 == 51) {
            return 512;
        }
        switch (i6) {
            case 60:
                return 2048;
            case 61:
                return 4096;
            case 62:
                return 8192;
            default:
                return -1;
        }
    }

    private static int vp9ProfileNumberToConst(int i6) {
        if (i6 == 0) {
            return 1;
        }
        if (i6 == 1) {
            return 2;
        }
        if (i6 != 2) {
            return i6 != 3 ? -1 : 8;
        }
        return 4;
    }
}

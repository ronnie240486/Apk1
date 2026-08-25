package androidx.media3.container;

import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.UnstableApi;
import java.lang.reflect.Array;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import p000a.AbstractC0004e;
import p041d7.AbstractC2301u1;
import p041d7.C2180c5;
import p041d7.C2204g1;
import p041d7.C2288s1;
import p060f7.AbstractC2498b;

@UnstableApi
public final class NalUnitUtil {
    public static final int EXTENDED_SAR = 255;
    public static final int H264_NAL_UNIT_TYPE_AUD = 9;
    public static final int H264_NAL_UNIT_TYPE_IDR = 5;
    public static final int H264_NAL_UNIT_TYPE_NON_IDR = 1;
    public static final int H264_NAL_UNIT_TYPE_PARTITION_A = 2;
    public static final int H264_NAL_UNIT_TYPE_PPS = 8;
    public static final int H264_NAL_UNIT_TYPE_PREFIX = 14;
    public static final int H264_NAL_UNIT_TYPE_SEI = 6;
    public static final int H264_NAL_UNIT_TYPE_SPS = 7;
    public static final int H264_NAL_UNIT_TYPE_UNSPECIFIED = 24;
    public static final int H265_NAL_UNIT_TYPE_AUD = 35;
    public static final int H265_NAL_UNIT_TYPE_BLA_W_LP = 16;
    public static final int H265_NAL_UNIT_TYPE_CRA = 21;
    public static final int H265_NAL_UNIT_TYPE_PPS = 34;
    public static final int H265_NAL_UNIT_TYPE_PREFIX_SEI = 39;
    public static final int H265_NAL_UNIT_TYPE_RASL_R = 9;
    public static final int H265_NAL_UNIT_TYPE_SPS = 33;
    public static final int H265_NAL_UNIT_TYPE_SUFFIX_SEI = 40;
    public static final int H265_NAL_UNIT_TYPE_UNSPECIFIED = 48;
    public static final int H265_NAL_UNIT_TYPE_VPS = 32;
    private static final int INVALID_ID = -1;

    @Deprecated
    public static final int NAL_UNIT_TYPE_AUD = 9;

    @Deprecated
    public static final int NAL_UNIT_TYPE_IDR = 5;

    @Deprecated
    public static final int NAL_UNIT_TYPE_NON_IDR = 1;

    @Deprecated
    public static final int NAL_UNIT_TYPE_PARTITION_A = 2;

    @Deprecated
    public static final int NAL_UNIT_TYPE_PPS = 8;

    @Deprecated
    public static final int NAL_UNIT_TYPE_PREFIX = 14;

    @Deprecated
    public static final int NAL_UNIT_TYPE_SEI = 6;

    @Deprecated
    public static final int NAL_UNIT_TYPE_SPS = 7;
    private static final String TAG = "NalUnitUtil";
    public static final byte[] NAL_START_CODE = {0, 0, 0, 1};
    public static final float[] ASPECT_RATIO_IDC_VALUES = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object scratchEscapePositionsLock = new Object();
    private static int[] scratchEscapePositions = new int[10];

    public static final class H265LayerInfo {
        public final int layerIdInVps;
        public final int viewId;

        public H265LayerInfo(int i6, int i10) {
            this.layerIdInVps = i6;
            this.viewId = i10;
        }
    }

    public static final class H265NalHeader {
        public final int layerId;
        public final int nalUnitType;
        public final int temporalId;

        public H265NalHeader(int i6, int i10, int i11) {
            this.nalUnitType = i6;
            this.layerId = i10;
            this.temporalId = i11;
        }
    }

    public static final class H265ProfileTierLevel {
        public final int[] constraintBytes;
        public final int generalLevelIdc;
        public final int generalProfileCompatibilityFlags;
        public final int generalProfileIdc;
        public final int generalProfileSpace;
        public final boolean generalTierFlag;

        public H265ProfileTierLevel(int i6, boolean z7, int i10, int i11, int[] iArr, int i12) {
            this.generalProfileSpace = i6;
            this.generalTierFlag = z7;
            this.generalProfileIdc = i10;
            this.generalProfileCompatibilityFlags = i11;
            this.constraintBytes = iArr;
            this.generalLevelIdc = i12;
        }
    }

    public static final class H265ProfileTierLevelsAndIndices {
        public final int[] indices;
        public final AbstractC2301u1 profileTierLevels;

        public H265ProfileTierLevelsAndIndices(List<H265ProfileTierLevel> list, int[] iArr) {
            this.profileTierLevels = AbstractC2301u1.m5272n(list);
            this.indices = iArr;
        }
    }

    public static final class H265RepFormat {
        public final int bitDepthChromaMinus8;
        public final int bitDepthLumaMinus8;
        public final int chromaFormatIdc;
        public final int height;
        public final int width;

        public H265RepFormat(int i6, int i10, int i11, int i12, int i13) {
            this.chromaFormatIdc = i6;
            this.bitDepthLumaMinus8 = i10;
            this.bitDepthChromaMinus8 = i11;
            this.width = i12;
            this.height = i13;
        }
    }

    public static final class H265RepFormatsAndIndices {
        public final int[] indices;
        public final AbstractC2301u1 repFormats;

        public H265RepFormatsAndIndices(List<H265RepFormat> list, int[] iArr) {
            this.repFormats = AbstractC2301u1.m5272n(list);
            this.indices = iArr;
        }
    }

    public static final class H265Sei3dRefDisplayInfoData {
        public final int exponentRefDisplayWidth;
        public final int exponentRefViewingDist;
        public final int leftViewId;
        public final int mantissaRefDisplayWidth;
        public final int mantissaRefViewingDist;
        public final int numRefDisplays;
        public final int precRefDisplayWidth;
        public final int precRefViewingDist;
        public final int rightViewId;

        public H265Sei3dRefDisplayInfoData(int i6, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            this.precRefDisplayWidth = i6;
            this.precRefViewingDist = i10;
            this.numRefDisplays = i11;
            this.leftViewId = i12;
            this.rightViewId = i13;
            this.exponentRefDisplayWidth = i14;
            this.mantissaRefDisplayWidth = i15;
            this.exponentRefViewingDist = i16;
            this.mantissaRefViewingDist = i17;
        }
    }

    public static final class H265SpsData {
        public final int bitDepthChromaMinus8;
        public final int bitDepthLumaMinus8;
        public final int chromaFormatIdc;
        public final int colorRange;
        public final int colorSpace;
        public final int colorTransfer;
        public final int height;
        public final int maxNumReorderPics;
        public final int maxSubLayersMinus1;
        public final H265NalHeader nalHeader;
        public final float pixelWidthHeightRatio;
        public final H265ProfileTierLevel profileTierLevel;
        public final int seqParameterSetId;
        public final int width;

        public H265SpsData(H265NalHeader h265NalHeader, int i6, H265ProfileTierLevel h265ProfileTierLevel, int i10, int i11, int i12, int i13, int i14, int i15, float f, int i16, int i17, int i18, int i19) {
            this.nalHeader = h265NalHeader;
            this.maxSubLayersMinus1 = i6;
            this.profileTierLevel = h265ProfileTierLevel;
            this.chromaFormatIdc = i10;
            this.bitDepthLumaMinus8 = i11;
            this.bitDepthChromaMinus8 = i12;
            this.seqParameterSetId = i13;
            this.width = i14;
            this.height = i15;
            this.pixelWidthHeightRatio = f;
            this.maxNumReorderPics = i16;
            this.colorSpace = i17;
            this.colorRange = i18;
            this.colorTransfer = i19;
        }
    }

    public static final class H265VideoSignalInfo {
        public final int colorRange;
        public final int colorSpace;
        public final int colorTransfer;

        public H265VideoSignalInfo(int i6, int i10, int i11) {
            this.colorSpace = i6;
            this.colorRange = i10;
            this.colorTransfer = i11;
        }
    }

    public static final class H265VideoSignalInfosAndIndices {
        public final int[] indices;
        public final AbstractC2301u1 videoSignalInfos;

        public H265VideoSignalInfosAndIndices(List<H265VideoSignalInfo> list, int[] iArr) {
            this.videoSignalInfos = AbstractC2301u1.m5272n(list);
            this.indices = iArr;
        }
    }

    public static final class H265VpsData {
        public final AbstractC2301u1 layerInfos;
        public final H265NalHeader nalHeader;
        public final H265ProfileTierLevelsAndIndices profileTierLevelsAndIndices;
        public final H265RepFormatsAndIndices repFormatsAndIndices;
        public final H265VideoSignalInfosAndIndices videoSignalInfosAndIndices;

        public H265VpsData(H265NalHeader h265NalHeader, List<H265LayerInfo> list, H265ProfileTierLevelsAndIndices h265ProfileTierLevelsAndIndices, H265RepFormatsAndIndices h265RepFormatsAndIndices, H265VideoSignalInfosAndIndices h265VideoSignalInfosAndIndices) {
            AbstractC2301u1 abstractC2301u1M5272n;
            this.nalHeader = h265NalHeader;
            if (list != null) {
                abstractC2301u1M5272n = AbstractC2301u1.m5272n(list);
            } else {
                C2204g1 c2204g1 = AbstractC2301u1.f8069b;
                abstractC2301u1M5272n = C2180c5.f7862e;
            }
            this.layerInfos = abstractC2301u1M5272n;
            this.profileTierLevelsAndIndices = h265ProfileTierLevelsAndIndices;
            this.repFormatsAndIndices = h265RepFormatsAndIndices;
            this.videoSignalInfosAndIndices = h265VideoSignalInfosAndIndices;
        }
    }

    public static final class PpsData {
        public final boolean bottomFieldPicOrderInFramePresentFlag;
        public final int picParameterSetId;
        public final int seqParameterSetId;

        public PpsData(int i6, int i10, boolean z7) {
            this.picParameterSetId = i6;
            this.seqParameterSetId = i10;
            this.bottomFieldPicOrderInFramePresentFlag = z7;
        }
    }

    public static final class SpsData {
        public final int bitDepthChromaMinus8;
        public final int bitDepthLumaMinus8;
        public final int colorRange;
        public final int colorSpace;
        public final int colorTransfer;
        public final int constraintsFlagsAndReservedZero2Bits;
        public final boolean deltaPicOrderAlwaysZeroFlag;
        public final boolean frameMbsOnlyFlag;
        public final int frameNumLength;
        public final int height;
        public final int levelIdc;
        public final int maxNumRefFrames;
        public final int maxNumReorderFrames;
        public final int picOrderCntLsbLength;
        public final int picOrderCountType;
        public final float pixelWidthHeightRatio;
        public final int profileIdc;
        public final boolean separateColorPlaneFlag;
        public final int seqParameterSetId;
        public final int width;

        public SpsData(int i6, int i10, int i11, int i12, int i13, int i14, int i15, float f, int i16, int i17, boolean z7, boolean z10, int i18, int i19, int i20, boolean z11, int i21, int i22, int i23, int i24) {
            this.profileIdc = i6;
            this.constraintsFlagsAndReservedZero2Bits = i10;
            this.levelIdc = i11;
            this.seqParameterSetId = i12;
            this.maxNumRefFrames = i13;
            this.width = i14;
            this.height = i15;
            this.pixelWidthHeightRatio = f;
            this.bitDepthLumaMinus8 = i16;
            this.bitDepthChromaMinus8 = i17;
            this.separateColorPlaneFlag = z7;
            this.frameMbsOnlyFlag = z10;
            this.frameNumLength = i18;
            this.picOrderCountType = i19;
            this.picOrderCntLsbLength = i20;
            this.deltaPicOrderAlwaysZeroFlag = z11;
            this.colorSpace = i21;
            this.colorRange = i22;
            this.colorTransfer = i23;
            this.maxNumReorderFrames = i24;
        }
    }

    private NalUnitUtil() {
    }

    private static int applyConformanceWindowToHeight(int i6, int i10, int i11, int i12) {
        return i6 - ((i11 + i12) * (i10 == 1 ? 2 : 1));
    }

    private static int applyConformanceWindowToWidth(int i6, int i10, int i11, int i12) {
        int i13 = 2;
        if (i10 != 1 && i10 != 2) {
            i13 = 1;
        }
        return i6 - ((i11 + i12) * i13);
    }

    public static void clearPrefixFlags(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    private static String createCodecStringFromH265SpsPalyoad(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        parsableNalUnitBitArray.skipBits(4);
        int bits = parsableNalUnitBitArray.readBits(3);
        parsableNalUnitBitArray.skipBit();
        H265ProfileTierLevel h265ProfileTierLevel = parseH265ProfileTierLevel(parsableNalUnitBitArray, true, bits, null);
        return CodecSpecificDataUtil.buildHevcCodecString(h265ProfileTierLevel.generalProfileSpace, h265ProfileTierLevel.generalTierFlag, h265ProfileTierLevel.generalProfileIdc, h265ProfileTierLevel.generalProfileCompatibilityFlags, h265ProfileTierLevel.constraintBytes, h265ProfileTierLevel.generalLevelIdc);
    }

    public static void discardToSps(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int i6 = 0;
        int i10 = 0;
        while (true) {
            int i11 = i6 + 1;
            if (i11 >= iPosition) {
                byteBuffer.clear();
                return;
            }
            int i12 = byteBuffer.get(i6) & 255;
            if (i10 == 3) {
                if (i12 == 1 && (byteBuffer.get(i11) & 31) == 7) {
                    ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
                    byteBufferDuplicate.position(i6 - 3);
                    byteBufferDuplicate.limit(iPosition);
                    byteBuffer.position(0);
                    byteBuffer.put(byteBufferDuplicate);
                    return;
                }
            } else if (i12 == 0) {
                i10++;
            }
            if (i12 != 0) {
                i10 = 0;
            }
            i6 = i11;
        }
    }

    public static int findNalUnit(byte[] bArr, int i6, int i10, boolean[] zArr) {
        int i11 = i10 - i6;
        Assertions.checkState(i11 >= 0);
        if (i11 == 0) {
            return i10;
        }
        if (zArr[0]) {
            clearPrefixFlags(zArr);
            return i6 - 3;
        }
        if (i11 > 1 && zArr[1] && bArr[i6] == 1) {
            clearPrefixFlags(zArr);
            return i6 - 2;
        }
        if (i11 > 2 && zArr[2] && bArr[i6] == 0 && bArr[i6 + 1] == 1) {
            clearPrefixFlags(zArr);
            return i6 - 1;
        }
        int i12 = i10 - 1;
        int i13 = i6 + 2;
        while (i13 < i12) {
            byte b8 = bArr[i13];
            if ((b8 & 254) == 0) {
                int i14 = i13 - 2;
                if (bArr[i14] == 0 && bArr[i13 - 1] == 0 && b8 == 1) {
                    clearPrefixFlags(zArr);
                    return i14;
                }
                i13 -= 2;
            }
            i13 += 3;
        }
        zArr[0] = i11 <= 2 ? !(i11 != 2 ? !(zArr[1] && bArr[i12] == 1) : !(zArr[2] && bArr[i10 + (-2)] == 0 && bArr[i12] == 1)) : bArr[i10 + (-3)] == 0 && bArr[i10 + (-2)] == 0 && bArr[i12] == 1;
        zArr[1] = i11 <= 1 ? zArr[2] && bArr[i12] == 0 : bArr[i10 + (-2)] == 0 && bArr[i12] == 0;
        zArr[2] = bArr[i12] == 0;
        return i10;
    }

    private static AbstractC2301u1 findNalUnitPositions(byte[] bArr) {
        boolean[] zArr = new boolean[3];
        C2288s1 c2288s1M5269k = AbstractC2301u1.m5269k();
        int i6 = 0;
        while (i6 < bArr.length) {
            int iFindNalUnit = findNalUnit(bArr, i6, bArr.length, zArr);
            if (iFindNalUnit != bArr.length) {
                c2288s1M5269k.m5255a(Integer.valueOf(iFindNalUnit));
            }
            i6 = iFindNalUnit + 3;
        }
        return c2288s1M5269k.m5262g();
    }

    private static int findNextUnescapeIndex(byte[] bArr, int i6, int i10) {
        while (i6 < i10 - 2) {
            if (bArr[i6] == 0 && bArr[i6 + 1] == 0 && bArr[i6 + 2] == 3) {
                return i6;
            }
            i6++;
        }
        return i10;
    }

    public static String getH265BaseLayerCodecsString(List<byte[]> list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            byte[] bArr = list.get(i6);
            int length = bArr.length;
            if (length > 3) {
                AbstractC2301u1 abstractC2301u1FindNalUnitPositions = findNalUnitPositions(bArr);
                for (int i10 = 0; i10 < abstractC2301u1FindNalUnitPositions.size(); i10++) {
                    if (((Integer) abstractC2301u1FindNalUnitPositions.get(i10)).intValue() + 3 < length) {
                        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, ((Integer) abstractC2301u1FindNalUnitPositions.get(i10)).intValue() + 3, length);
                        H265NalHeader h265NalHeader = parseH265NalHeader(parsableNalUnitBitArray);
                        if (h265NalHeader.nalUnitType == 33 && h265NalHeader.layerId == 0) {
                            return createCodecStringFromH265SpsPalyoad(parsableNalUnitBitArray);
                        }
                    }
                }
            }
        }
        return null;
    }

    public static int getH265NalUnitType(byte[] bArr, int i6) {
        return (bArr[i6 + 3] & 126) >> 1;
    }

    public static int getNalUnitType(byte[] bArr, int i6) {
        return bArr[i6 + 3] & 31;
    }

    public static boolean isDependedOn(byte[] bArr, int i6, int i10, Format format) {
        if (Objects.equals(format.sampleMimeType, MimeTypes.VIDEO_H264)) {
            return isH264NalUnitDependedOn(bArr[i6]);
        }
        if (Objects.equals(format.sampleMimeType, MimeTypes.VIDEO_H265)) {
            return isH265NalUnitDependedOn(bArr, i6, i10, format);
        }
        return true;
    }

    public static boolean isH264NalUnitDependedOn(byte b8) {
        if (((b8 & 96) >> 5) != 0) {
            return true;
        }
        int i6 = b8 & 31;
        return (i6 == 1 || i6 == 9 || i6 == 14) ? false : true;
    }

    private static boolean isH265NalUnitDependedOn(byte[] bArr, int i6, int i10, Format format) {
        H265NalHeader h265NalHeader = parseH265NalHeader(new ParsableNalUnitBitArray(bArr, i6, i10 + i6));
        int i11 = h265NalHeader.nalUnitType;
        if (i11 == 35) {
            return false;
        }
        return (i11 <= 14 && i11 % 2 == 0 && h265NalHeader.temporalId == format.maxSubLayers - 1) ? false : true;
    }

    @Deprecated
    public static boolean isNalUnitSei(String str, byte b8) {
        if (MimeTypes.VIDEO_H264.equals(str) && (b8 & 31) == 6) {
            return true;
        }
        return MimeTypes.VIDEO_H265.equals(str) && ((b8 & 126) >> 1) == 39;
    }

    public static int numberOfBytesInNalUnitHeader(Format format) {
        if (Objects.equals(format.sampleMimeType, MimeTypes.VIDEO_H264)) {
            return 1;
        }
        return (Objects.equals(format.sampleMimeType, MimeTypes.VIDEO_H265) || MimeTypes.containsCodecsCorrespondingToMimeType(format.codecs, MimeTypes.VIDEO_H265)) ? 2 : 0;
    }

    private static H265NalHeader parseH265NalHeader(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        parsableNalUnitBitArray.skipBit();
        return new H265NalHeader(parsableNalUnitBitArray.readBits(6), parsableNalUnitBitArray.readBits(6), parsableNalUnitBitArray.readBits(3) - 1);
    }

    private static H265ProfileTierLevel parseH265ProfileTierLevel(ParsableNalUnitBitArray parsableNalUnitBitArray, boolean z7, int i6, H265ProfileTierLevel h265ProfileTierLevel) {
        int[] iArr;
        int i10;
        boolean z10;
        int i11;
        int i12;
        boolean bit;
        int bits;
        int i13;
        int i14;
        int[] iArr2 = new int[6];
        if (!z7) {
            if (h265ProfileTierLevel != null) {
                int i15 = h265ProfileTierLevel.generalProfileSpace;
                bit = h265ProfileTierLevel.generalTierFlag;
                bits = h265ProfileTierLevel.generalProfileIdc;
                i13 = h265ProfileTierLevel.generalProfileCompatibilityFlags;
                iArr2 = h265ProfileTierLevel.constraintBytes;
                i10 = i15;
            } else {
                iArr = iArr2;
                i10 = 0;
                z10 = false;
                i11 = 0;
                i12 = 0;
            }
            int bits2 = parsableNalUnitBitArray.readBits(8);
            i14 = 0;
            for (int i16 = 0; i16 < i6; i16++) {
                if (parsableNalUnitBitArray.readBit()) {
                    i14 += 88;
                }
                if (parsableNalUnitBitArray.readBit()) {
                    i14 += 8;
                }
            }
            parsableNalUnitBitArray.skipBits(i14);
            if (i6 > 0) {
                parsableNalUnitBitArray.skipBits((8 - i6) * 2);
            }
            return new H265ProfileTierLevel(i10, z10, i11, i12, iArr, bits2);
        }
        int bits3 = parsableNalUnitBitArray.readBits(2);
        bit = parsableNalUnitBitArray.readBit();
        bits = parsableNalUnitBitArray.readBits(5);
        i13 = 0;
        for (int i17 = 0; i17 < 32; i17++) {
            if (parsableNalUnitBitArray.readBit()) {
                i13 |= 1 << i17;
            }
        }
        for (int i18 = 0; i18 < 6; i18++) {
            iArr2[i18] = parsableNalUnitBitArray.readBits(8);
        }
        i10 = bits3;
        iArr = iArr2;
        z10 = bit;
        i11 = bits;
        i12 = i13;
        int bits4 = parsableNalUnitBitArray.readBits(8);
        i14 = 0;
        while (i16 < i6) {
            if (parsableNalUnitBitArray.readBit()) {
                i14 += 88;
            }
            if (parsableNalUnitBitArray.readBit()) {
                i14 += 8;
            }
        }
        parsableNalUnitBitArray.skipBits(i14);
        if (i6 > 0) {
            parsableNalUnitBitArray.skipBits((8 - i6) * 2);
        }
        return new H265ProfileTierLevel(i10, z10, i11, i12, iArr, bits4);
    }

    private static H265RepFormat parseH265RepFormat(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        int i6;
        int i10;
        int bits;
        int bits2 = parsableNalUnitBitArray.readBits(16);
        int bits3 = parsableNalUnitBitArray.readBits(16);
        if (parsableNalUnitBitArray.readBit()) {
            int bits4 = parsableNalUnitBitArray.readBits(2);
            if (bits4 == 3) {
                parsableNalUnitBitArray.skipBit();
            }
            int bits5 = parsableNalUnitBitArray.readBits(4);
            bits = parsableNalUnitBitArray.readBits(4);
            i10 = bits5;
            i6 = bits4;
        } else {
            i6 = 0;
            i10 = 0;
            bits = 0;
        }
        if (parsableNalUnitBitArray.readBit()) {
            int unsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int unsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int unsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int unsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            bits2 = applyConformanceWindowToWidth(bits2, i6, unsignedExpGolombCodedInt, unsignedExpGolombCodedInt2);
            bits3 = applyConformanceWindowToHeight(bits3, i6, unsignedExpGolombCodedInt3, unsignedExpGolombCodedInt4);
        }
        return new H265RepFormat(i6, i10, bits, bits2, bits3);
    }

    private static H265RepFormatsAndIndices parseH265RepFormatsAndIndices(ParsableNalUnitBitArray parsableNalUnitBitArray, int i6) {
        int unsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int i10 = unsignedExpGolombCodedInt + 1;
        C2288s1 c2288s1M5270l = AbstractC2301u1.m5270l(i10);
        int[] iArr = new int[i6];
        for (int i11 = 0; i11 < i10; i11++) {
            c2288s1M5270l.m5255a(parseH265RepFormat(parsableNalUnitBitArray));
        }
        int i12 = 1;
        if (i10 <= 1 || !parsableNalUnitBitArray.readBit()) {
            while (i12 < i6) {
                iArr[i12] = Math.min(i12, unsignedExpGolombCodedInt);
                i12++;
            }
        } else {
            int iM5547c = AbstractC2498b.m5547c(i10, RoundingMode.CEILING);
            while (i12 < i6) {
                iArr[i12] = parsableNalUnitBitArray.readBits(iM5547c);
                i12++;
            }
        }
        return new H265RepFormatsAndIndices(c2288s1M5270l.m5262g(), iArr);
    }

    public static H265Sei3dRefDisplayInfoData parseH265Sei3dRefDisplayInfo(byte[] bArr, int i6, int i10) {
        byte b8;
        int i11 = i6 + 2;
        do {
            i10--;
            b8 = bArr[i10];
            if (b8 != 0) {
                break;
            }
        } while (i10 > i11);
        if (b8 != 0 && i10 > i11) {
            ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i11, i10 + 1);
            while (parsableNalUnitBitArray.canReadBits(16)) {
                int bits = parsableNalUnitBitArray.readBits(8);
                int i12 = 0;
                while (bits == 255) {
                    i12 += 255;
                    bits = parsableNalUnitBitArray.readBits(8);
                }
                int i13 = i12 + bits;
                int bits2 = parsableNalUnitBitArray.readBits(8);
                int i14 = 0;
                while (bits2 == 255) {
                    i14 += 255;
                    bits2 = parsableNalUnitBitArray.readBits(8);
                }
                int i15 = i14 + bits2;
                if (i15 == 0 || !parsableNalUnitBitArray.canReadBits(i15)) {
                    break;
                }
                if (i13 == 176) {
                    int unsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    boolean bit = parsableNalUnitBitArray.readBit();
                    int unsignedExpGolombCodedInt2 = bit ? parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() : 0;
                    int unsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    int unsignedExpGolombCodedInt4 = -1;
                    int unsignedExpGolombCodedInt5 = -1;
                    int bits3 = -1;
                    int bits4 = -1;
                    int bits5 = -1;
                    int bits6 = -1;
                    for (int i16 = 0; i16 <= unsignedExpGolombCodedInt3; i16++) {
                        unsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        unsignedExpGolombCodedInt5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        bits3 = parsableNalUnitBitArray.readBits(6);
                        if (bits3 == 63) {
                            return null;
                        }
                        bits4 = parsableNalUnitBitArray.readBits(bits3 == 0 ? Math.max(0, unsignedExpGolombCodedInt - 30) : Math.max(0, (bits3 + unsignedExpGolombCodedInt) - 31));
                        if (bit) {
                            bits5 = parsableNalUnitBitArray.readBits(6);
                            if (bits5 == 63) {
                                return null;
                            }
                            bits6 = parsableNalUnitBitArray.readBits(bits5 == 0 ? Math.max(0, unsignedExpGolombCodedInt2 - 30) : Math.max(0, (bits5 + unsignedExpGolombCodedInt2) - 31));
                        }
                        if (parsableNalUnitBitArray.readBit()) {
                            parsableNalUnitBitArray.skipBits(10);
                        }
                    }
                    return new H265Sei3dRefDisplayInfoData(unsignedExpGolombCodedInt, unsignedExpGolombCodedInt2, unsignedExpGolombCodedInt3 + 1, unsignedExpGolombCodedInt4, unsignedExpGolombCodedInt5, bits3, bits4, bits5, bits6);
                }
            }
        }
        return null;
    }

    public static H265SpsData parseH265SpsNalUnit(byte[] bArr, int i6, int i10, H265VpsData h265VpsData) {
        return parseH265SpsNalUnitPayload(bArr, i6 + 2, i10, parseH265NalHeader(new ParsableNalUnitBitArray(bArr, i6, i10)), h265VpsData);
    }

    public static H265SpsData parseH265SpsNalUnitPayload(byte[] bArr, int i6, int i10, H265NalHeader h265NalHeader, H265VpsData h265VpsData) {
        int unsignedExpGolombCodedInt;
        int i11;
        int i12;
        int i13;
        int i14;
        int iMax;
        int i15;
        float f;
        int i16;
        int i17;
        int i18;
        int i19;
        H265VideoSignalInfosAndIndices h265VideoSignalInfosAndIndices;
        int i20;
        int iIsoColorPrimariesToColorSpace;
        int iIsoTransferCharacteristicsToColorTransfer;
        H265RepFormatsAndIndices h265RepFormatsAndIndices;
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i6, i10);
        parsableNalUnitBitArray.skipBits(4);
        int bits = parsableNalUnitBitArray.readBits(3);
        boolean z7 = h265NalHeader.layerId != 0 && bits == 7;
        int i21 = (h265VpsData == null || h265VpsData.layerInfos.isEmpty()) ? 0 : ((H265LayerInfo) h265VpsData.layerInfos.get(Math.min(h265NalHeader.layerId, h265VpsData.layerInfos.size() - 1))).layerIdInVps;
        H265ProfileTierLevel h265ProfileTierLevel = null;
        if (!z7) {
            parsableNalUnitBitArray.skipBit();
            h265ProfileTierLevel = parseH265ProfileTierLevel(parsableNalUnitBitArray, true, bits, null);
        } else if (h265VpsData != null) {
            H265ProfileTierLevelsAndIndices h265ProfileTierLevelsAndIndices = h265VpsData.profileTierLevelsAndIndices;
            int i22 = h265ProfileTierLevelsAndIndices.indices[i21];
            if (h265ProfileTierLevelsAndIndices.profileTierLevels.size() > i22) {
                h265ProfileTierLevel = (H265ProfileTierLevel) h265VpsData.profileTierLevelsAndIndices.profileTierLevels.get(i22);
            }
        }
        int unsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (z7) {
            int bits2 = parsableNalUnitBitArray.readBit() ? parsableNalUnitBitArray.readBits(8) : -1;
            if (h265VpsData == null || (h265RepFormatsAndIndices = h265VpsData.repFormatsAndIndices) == null) {
                i13 = 0;
                i14 = 0;
                unsignedExpGolombCodedInt = 0;
                i11 = 0;
                i12 = 0;
            } else {
                if (bits2 == -1) {
                    bits2 = h265RepFormatsAndIndices.indices[i21];
                }
                if (bits2 == -1 || h265RepFormatsAndIndices.repFormats.size() <= bits2) {
                    i13 = 0;
                    i14 = 0;
                    unsignedExpGolombCodedInt = 0;
                    i11 = 0;
                    i12 = 0;
                } else {
                    H265RepFormat h265RepFormat = (H265RepFormat) h265VpsData.repFormatsAndIndices.repFormats.get(bits2);
                    i11 = h265RepFormat.chromaFormatIdc;
                    i12 = h265RepFormat.width;
                    i13 = h265RepFormat.height;
                    i14 = h265RepFormat.bitDepthLumaMinus8;
                    unsignedExpGolombCodedInt = h265RepFormat.bitDepthChromaMinus8;
                }
            }
        } else {
            int unsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            if (unsignedExpGolombCodedInt3 == 3) {
                parsableNalUnitBitArray.skipBit();
            }
            int unsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int unsignedExpGolombCodedInt5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            if (parsableNalUnitBitArray.readBit()) {
                int unsignedExpGolombCodedInt6 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int unsignedExpGolombCodedInt7 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int unsignedExpGolombCodedInt8 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int unsignedExpGolombCodedInt9 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                unsignedExpGolombCodedInt4 = applyConformanceWindowToWidth(unsignedExpGolombCodedInt4, unsignedExpGolombCodedInt3, unsignedExpGolombCodedInt6, unsignedExpGolombCodedInt7);
                unsignedExpGolombCodedInt5 = applyConformanceWindowToHeight(unsignedExpGolombCodedInt5, unsignedExpGolombCodedInt3, unsignedExpGolombCodedInt8, unsignedExpGolombCodedInt9);
            }
            int unsignedExpGolombCodedInt10 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            unsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            i11 = unsignedExpGolombCodedInt3;
            i12 = unsignedExpGolombCodedInt4;
            i13 = unsignedExpGolombCodedInt5;
            i14 = unsignedExpGolombCodedInt10;
        }
        int unsignedExpGolombCodedInt11 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (z7) {
            iMax = -1;
        } else {
            iMax = -1;
            for (int i23 = parsableNalUnitBitArray.readBit() ? 0 : bits; i23 <= bits; i23++) {
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                iMax = Math.max(parsableNalUnitBitArray.readUnsignedExpGolombCodedInt(), iMax);
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            }
        }
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (parsableNalUnitBitArray.readBit()) {
            if (z7 ? parsableNalUnitBitArray.readBit() : false) {
                parsableNalUnitBitArray.skipBits(6);
            } else if (parsableNalUnitBitArray.readBit()) {
                skipH265ScalingList(parsableNalUnitBitArray);
            }
        }
        int i24 = 2;
        parsableNalUnitBitArray.skipBits(2);
        if (parsableNalUnitBitArray.readBit()) {
            parsableNalUnitBitArray.skipBits(8);
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.skipBit();
        }
        skipH265ShortTermReferencePictureSets(parsableNalUnitBitArray);
        if (parsableNalUnitBitArray.readBit()) {
            int unsignedExpGolombCodedInt12 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int i25 = 0;
            while (i25 < unsignedExpGolombCodedInt12) {
                parsableNalUnitBitArray.skipBits(unsignedExpGolombCodedInt11 + 5);
                i25++;
                i24 = 2;
            }
        }
        parsableNalUnitBitArray.skipBits(i24);
        float f3 = 1.0f;
        if (parsableNalUnitBitArray.readBit()) {
            if (parsableNalUnitBitArray.readBit()) {
                int bits3 = parsableNalUnitBitArray.readBits(8);
                if (bits3 == 255) {
                    int bits4 = parsableNalUnitBitArray.readBits(16);
                    int bits5 = parsableNalUnitBitArray.readBits(16);
                    if (bits4 != 0 && bits5 != 0) {
                        f3 = bits4 / bits5;
                    }
                } else {
                    float[] fArr = ASPECT_RATIO_IDC_VALUES;
                    if (bits3 < fArr.length) {
                        f3 = fArr[bits3];
                    } else {
                        AbstractC0004e.m31y(bits3, "Unexpected aspect_ratio_idc value: ", TAG);
                    }
                }
            }
            if (parsableNalUnitBitArray.readBit()) {
                parsableNalUnitBitArray.skipBit();
            }
            if (parsableNalUnitBitArray.readBit()) {
                parsableNalUnitBitArray.skipBits(3);
                i19 = parsableNalUnitBitArray.readBit() ? 1 : 2;
                if (parsableNalUnitBitArray.readBit()) {
                    int bits6 = parsableNalUnitBitArray.readBits(8);
                    int bits7 = parsableNalUnitBitArray.readBits(8);
                    parsableNalUnitBitArray.skipBits(8);
                    iIsoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace(bits6);
                    iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(bits7);
                } else {
                    iIsoColorPrimariesToColorSpace = -1;
                    iIsoTransferCharacteristicsToColorTransfer = -1;
                }
            } else if (h265VpsData == null || (h265VideoSignalInfosAndIndices = h265VpsData.videoSignalInfosAndIndices) == null || h265VideoSignalInfosAndIndices.videoSignalInfos.size() <= (i20 = h265VideoSignalInfosAndIndices.indices[i21])) {
                i19 = -1;
                iIsoColorPrimariesToColorSpace = -1;
                iIsoTransferCharacteristicsToColorTransfer = -1;
            } else {
                H265VideoSignalInfo h265VideoSignalInfo = (H265VideoSignalInfo) h265VpsData.videoSignalInfosAndIndices.videoSignalInfos.get(i20);
                iIsoColorPrimariesToColorSpace = h265VideoSignalInfo.colorSpace;
                int i26 = h265VideoSignalInfo.colorRange;
                iIsoTransferCharacteristicsToColorTransfer = h265VideoSignalInfo.colorTransfer;
                i19 = i26;
            }
            if (parsableNalUnitBitArray.readBit()) {
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            }
            parsableNalUnitBitArray.skipBit();
            if (parsableNalUnitBitArray.readBit()) {
                i13 *= 2;
            }
            i17 = i19;
            i16 = iIsoColorPrimariesToColorSpace;
            i18 = iIsoTransferCharacteristicsToColorTransfer;
            f = f3;
            i15 = i13;
        } else {
            i15 = i13;
            f = 1.0f;
            i16 = -1;
            i17 = -1;
            i18 = -1;
        }
        return new H265SpsData(h265NalHeader, bits, h265ProfileTierLevel, i11, i14, unsignedExpGolombCodedInt, unsignedExpGolombCodedInt2, i12, i15, f, iMax, i16, i17, i18);
    }

    private static H265VideoSignalInfo parseH265VideoSignalInfo(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        parsableNalUnitBitArray.skipBits(3);
        int i6 = parsableNalUnitBitArray.readBit() ? 1 : 2;
        int iIsoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace(parsableNalUnitBitArray.readBits(8));
        int iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(parsableNalUnitBitArray.readBits(8));
        parsableNalUnitBitArray.skipBits(8);
        return new H265VideoSignalInfo(iIsoColorPrimariesToColorSpace, i6, iIsoTransferCharacteristicsToColorTransfer);
    }

    private static H265VideoSignalInfosAndIndices parseH265VideoSignalInfosAndIndices(ParsableNalUnitBitArray parsableNalUnitBitArray, int i6, int i10, int[] iArr) {
        if (!parsableNalUnitBitArray.readBit() ? parsableNalUnitBitArray.readBit() : true) {
            parsableNalUnitBitArray.skipBit();
        }
        boolean bit = parsableNalUnitBitArray.readBit();
        boolean bit2 = parsableNalUnitBitArray.readBit();
        if (bit || bit2) {
            for (int i11 = 0; i11 < i10; i11++) {
                for (int i12 = 0; i12 < iArr[i11]; i12++) {
                    boolean bit3 = bit ? parsableNalUnitBitArray.readBit() : false;
                    boolean bit4 = bit2 ? parsableNalUnitBitArray.readBit() : false;
                    if (bit3) {
                        parsableNalUnitBitArray.skipBits(32);
                    }
                    if (bit4) {
                        parsableNalUnitBitArray.skipBits(18);
                    }
                }
            }
        }
        boolean bit5 = parsableNalUnitBitArray.readBit();
        int bits = bit5 ? parsableNalUnitBitArray.readBits(4) + 1 : i6;
        C2288s1 c2288s1M5270l = AbstractC2301u1.m5270l(bits);
        int[] iArr2 = new int[i6];
        for (int i13 = 0; i13 < bits; i13++) {
            c2288s1M5270l.m5255a(parseH265VideoSignalInfo(parsableNalUnitBitArray));
        }
        if (bit5 && bits > 1) {
            for (int i14 = 0; i14 < i6; i14++) {
                iArr2[i14] = parsableNalUnitBitArray.readBits(4);
            }
        }
        return new H265VideoSignalInfosAndIndices(c2288s1M5270l.m5262g(), iArr2);
    }

    public static H265VpsData parseH265VpsNalUnit(byte[] bArr, int i6, int i10) {
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i6, i10);
        return parseH265VpsNalUnitPayload(parsableNalUnitBitArray, parseH265NalHeader(parsableNalUnitBitArray));
    }

    private static H265VpsData parseH265VpsNalUnitPayload(ParsableNalUnitBitArray parsableNalUnitBitArray, H265NalHeader h265NalHeader) {
        int[][] iArr;
        int i6;
        int i10;
        int i11;
        H265VideoSignalInfosAndIndices h265VideoSignalInfosAndIndices;
        int i12;
        int i13;
        boolean[][] zArr;
        int i14;
        boolean[][] zArr2;
        int[] iArr2;
        int[] iArr3;
        parsableNalUnitBitArray.skipBits(4);
        boolean bit = parsableNalUnitBitArray.readBit();
        boolean bit2 = parsableNalUnitBitArray.readBit();
        int bits = parsableNalUnitBitArray.readBits(6);
        int i15 = bits + 1;
        int bits2 = parsableNalUnitBitArray.readBits(3);
        parsableNalUnitBitArray.skipBits(17);
        boolean z7 = true;
        H265ProfileTierLevel h265ProfileTierLevel = parseH265ProfileTierLevel(parsableNalUnitBitArray, true, bits2, null);
        for (int i16 = parsableNalUnitBitArray.readBit() ? 0 : bits2; i16 <= bits2; i16++) {
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        }
        int bits3 = parsableNalUnitBitArray.readBits(6);
        int unsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
        H265ProfileTierLevelsAndIndices h265ProfileTierLevelsAndIndices = new H265ProfileTierLevelsAndIndices(AbstractC2301u1.m5275r(h265ProfileTierLevel), new int[1]);
        boolean z10 = i15 >= 2 && unsignedExpGolombCodedInt >= 2;
        boolean z11 = bit && bit2;
        int i17 = bits3 + 1;
        boolean z12 = i17 >= i15;
        if (!z10 || !z11 || !z12) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices, null, null);
        }
        int[][] iArr4 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, unsignedExpGolombCodedInt, i17);
        int[] iArr5 = new int[unsignedExpGolombCodedInt];
        int[] iArr6 = new int[unsignedExpGolombCodedInt];
        iArr4[0][0] = 0;
        iArr5[0] = 1;
        iArr6[0] = 0;
        for (int i18 = 1; i18 < unsignedExpGolombCodedInt; i18++) {
            int i19 = 0;
            for (int i20 = 0; i20 <= bits3; i20++) {
                if (parsableNalUnitBitArray.readBit()) {
                    iArr4[i18][i19] = i20;
                    iArr6[i18] = i20;
                    i19++;
                }
                iArr5[i18] = i19;
            }
        }
        if (parsableNalUnitBitArray.readBit()) {
            parsableNalUnitBitArray.skipBits(64);
            if (parsableNalUnitBitArray.readBit()) {
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            }
            int unsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int i21 = 0;
            while (i21 < unsignedExpGolombCodedInt2) {
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                if (i21 != 0 && !parsableNalUnitBitArray.readBit()) {
                    z7 = false;
                }
                skipH265HrdParameters(parsableNalUnitBitArray, z7, bits2);
                i21++;
                z7 = true;
            }
        }
        if (!parsableNalUnitBitArray.readBit()) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices, null, null);
        }
        parsableNalUnitBitArray.byteAlign();
        H265ProfileTierLevel h265ProfileTierLevel2 = parseH265ProfileTierLevel(parsableNalUnitBitArray, false, bits2, h265ProfileTierLevel);
        boolean bit3 = parsableNalUnitBitArray.readBit();
        boolean[] zArr3 = new boolean[16];
        int i22 = 0;
        for (int i23 = 0; i23 < 16; i23++) {
            boolean bit4 = parsableNalUnitBitArray.readBit();
            zArr3[i23] = bit4;
            if (bit4) {
                i22++;
            }
        }
        if (i22 == 0 || !zArr3[1]) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices, null, null);
        }
        int[] iArr7 = new int[i22];
        for (int i24 = 0; i24 < i22 - (bit3 ? 1 : 0); i24++) {
            iArr7[i24] = parsableNalUnitBitArray.readBits(3);
        }
        int[] iArr8 = new int[i22 + 1];
        if (bit3) {
            int i25 = 1;
            while (i25 < i22) {
                int[][] iArr9 = iArr4;
                for (int i26 = 0; i26 < i25; i26++) {
                    iArr8[i25] = iArr7[i26] + 1 + iArr8[i25];
                }
                i25++;
                iArr4 = iArr9;
            }
            iArr = iArr4;
            iArr8[i22] = 6;
        } else {
            iArr = iArr4;
        }
        int[][] iArr10 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i15, i22);
        int[] iArr11 = new int[i15];
        iArr11[0] = 0;
        boolean bit5 = parsableNalUnitBitArray.readBit();
        int i27 = 1;
        while (i27 < i15) {
            if (bit5) {
                iArr11[i27] = parsableNalUnitBitArray.readBits(6);
            } else {
                iArr11[i27] = i27;
            }
            if (bit3) {
                iArr3 = iArr7;
                int i28 = 0;
                while (i28 < i22) {
                    int i29 = i28 + 1;
                    iArr10[i27][i28] = (iArr11[i27] & ((1 << iArr8[i29]) - 1)) >> iArr8[i28];
                    i28 = i29;
                }
            } else {
                int i30 = 0;
                while (i30 < i22) {
                    iArr10[i27][i30] = parsableNalUnitBitArray.readBits(iArr7[i30] + 1);
                    i30++;
                    iArr7 = iArr7;
                }
                iArr3 = iArr7;
            }
            i27++;
            bits2 = bits2;
            iArr7 = iArr3;
        }
        int i31 = bits2;
        int[] iArr12 = new int[i17];
        int i32 = 1;
        for (int i33 = 0; i33 < i15; i33++) {
            iArr12[iArr11[i33]] = -1;
            int i34 = 0;
            for (int i35 = 0; i35 < 16; i35++) {
                if (zArr3[i35]) {
                    if (i35 == 1) {
                        iArr12[iArr11[i33]] = iArr10[i33][i34];
                    }
                    i34++;
                }
            }
            if (i33 > 0) {
                int i36 = 0;
                while (true) {
                    if (i36 >= i33) {
                        i32++;
                        break;
                    }
                    if (iArr12[iArr11[i33]] == iArr12[iArr11[i36]]) {
                        break;
                    }
                    i36++;
                }
            }
        }
        int bits4 = parsableNalUnitBitArray.readBits(4);
        if (i32 < 2 || bits4 == 0) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices, null, null);
        }
        int[] iArr13 = new int[i32];
        for (int i37 = 0; i37 < i32; i37++) {
            iArr13[i37] = parsableNalUnitBitArray.readBits(bits4);
        }
        int[] iArr14 = new int[i17];
        for (int i38 = 0; i38 < i15; i38++) {
            iArr14[Math.min(iArr11[i38], bits3)] = i38;
        }
        C2288s1 c2288s1M5269k = AbstractC2301u1.m5269k();
        int i39 = 0;
        while (i39 <= bits3) {
            int iMin = Math.min(iArr12[i39], i32 - 1);
            c2288s1M5269k.m5256c(new H265LayerInfo(iArr14[i39], iMin >= 0 ? iArr13[iMin] : -1));
            i39++;
            iArr12 = iArr12;
        }
        C2180c5 c2180c5M5262g = c2288s1M5269k.m5262g();
        if (((H265LayerInfo) c2180c5M5262g.get(0)).viewId == -1) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices, null, null);
        }
        int i40 = 1;
        while (true) {
            if (i40 > bits3) {
                i6 = -1;
                i10 = -1;
                break;
            }
            i6 = -1;
            if (((H265LayerInfo) c2180c5M5262g.get(i40)).viewId != -1) {
                i10 = i40;
                break;
            }
            i40++;
        }
        if (i10 == i6) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices, null, null);
        }
        Class cls = Boolean.TYPE;
        boolean[][] zArr4 = (boolean[][]) Array.newInstance((Class<?>) cls, i15, i15);
        boolean[][] zArr5 = (boolean[][]) Array.newInstance((Class<?>) cls, i15, i15);
        for (int i41 = 1; i41 < i15; i41++) {
            for (int i42 = 0; i42 < i41; i42++) {
                boolean[] zArr6 = zArr4[i41];
                boolean[] zArr7 = zArr5[i41];
                boolean bit6 = parsableNalUnitBitArray.readBit();
                zArr7[i42] = bit6;
                zArr6[i42] = bit6;
            }
        }
        for (int i43 = 1; i43 < i15; i43++) {
            for (int i44 = 0; i44 < bits; i44++) {
                for (int i45 = 0; i45 < i43; i45++) {
                    boolean[] zArr8 = zArr5[i43];
                    if (zArr8[i45] && zArr5[i45][i44]) {
                        zArr8[i44] = true;
                        break;
                    }
                }
            }
        }
        int[] iArr15 = new int[i17];
        for (int i46 = 0; i46 < i15; i46++) {
            int i47 = 0;
            for (int i48 = 0; i48 < i46; i48++) {
                i47 += zArr4[i46][i48] ? 1 : 0;
            }
            iArr15[iArr11[i46]] = i47;
        }
        int i49 = 0;
        for (int i50 = 0; i50 < i15; i50++) {
            if (iArr15[iArr11[i50]] == 0) {
                i49++;
            }
        }
        if (i49 > 1) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices, null, null);
        }
        int[] iArr16 = new int[i15];
        int[] iArr17 = new int[unsignedExpGolombCodedInt];
        if (parsableNalUnitBitArray.readBit()) {
            for (int i51 = 0; i51 < i15; i51++) {
                iArr16[i51] = parsableNalUnitBitArray.readBits(3);
            }
            i11 = i31;
        } else {
            i11 = i31;
            Arrays.fill(iArr16, 0, i15, i11);
        }
        int i52 = 0;
        while (i52 < unsignedExpGolombCodedInt) {
            boolean[][] zArr9 = zArr5;
            int[] iArr18 = iArr15;
            int[] iArr19 = iArr11;
            int iMax = 0;
            for (int i53 = 0; i53 < iArr5[i52]; i53++) {
                iMax = Math.max(iMax, iArr16[((H265LayerInfo) c2180c5M5262g.get(iArr[i52][i53])).layerIdInVps]);
            }
            iArr17[i52] = iMax + 1;
            i52++;
            iArr11 = iArr19;
            iArr15 = iArr18;
            zArr5 = zArr9;
        }
        boolean[][] zArr10 = zArr5;
        int[] iArr20 = iArr15;
        int[] iArr21 = iArr11;
        if (parsableNalUnitBitArray.readBit()) {
            int i54 = 0;
            while (i54 < bits) {
                int i55 = i54 + 1;
                for (int i56 = i55; i56 < i15; i56++) {
                    if (zArr4[i56][i54]) {
                        parsableNalUnitBitArray.skipBits(3);
                    }
                }
                i54 = i55;
            }
        }
        parsableNalUnitBitArray.skipBit();
        int unsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
        C2288s1 c2288s1M5269k2 = AbstractC2301u1.m5269k();
        c2288s1M5269k2.m5256c(h265ProfileTierLevel);
        if (unsignedExpGolombCodedInt3 > 1) {
            H265ProfileTierLevel h265ProfileTierLevel3 = h265ProfileTierLevel2;
            c2288s1M5269k2.m5256c(h265ProfileTierLevel3);
            for (int i57 = 2; i57 < unsignedExpGolombCodedInt3; i57++) {
                h265ProfileTierLevel3 = parseH265ProfileTierLevel(parsableNalUnitBitArray, parsableNalUnitBitArray.readBit(), i11, h265ProfileTierLevel3);
                c2288s1M5269k2.m5256c(h265ProfileTierLevel3);
            }
        }
        C2180c5 c2180c5M5262g2 = c2288s1M5269k2.m5262g();
        int unsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + unsignedExpGolombCodedInt;
        if (unsignedExpGolombCodedInt4 > unsignedExpGolombCodedInt) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices, null, null);
        }
        int bits5 = parsableNalUnitBitArray.readBits(2);
        boolean[][] zArr11 = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, unsignedExpGolombCodedInt4, i17);
        int[] iArr22 = new int[unsignedExpGolombCodedInt4];
        int[] iArr23 = new int[unsignedExpGolombCodedInt4];
        int i58 = 0;
        while (i58 < unsignedExpGolombCodedInt) {
            int i59 = unsignedExpGolombCodedInt;
            iArr22[i58] = 0;
            iArr23[i58] = iArr6[i58];
            if (bits5 == 0) {
                zArr2 = zArr4;
                iArr2 = iArr17;
                i14 = i15;
                Arrays.fill(zArr11[i58], 0, iArr5[i58], true);
                iArr22[i58] = iArr5[i58];
            } else {
                i14 = i15;
                zArr2 = zArr4;
                iArr2 = iArr17;
                if (bits5 == 1) {
                    int i60 = iArr6[i58];
                    for (int i61 = 0; i61 < iArr5[i58]; i61++) {
                        zArr11[i58][i61] = iArr[i58][i61] == i60;
                    }
                    iArr22[i58] = 1;
                } else {
                    zArr11[0][0] = true;
                    iArr22[0] = 1;
                }
            }
            i58++;
            unsignedExpGolombCodedInt = i59;
            zArr4 = zArr2;
            iArr17 = iArr2;
            i15 = i14;
        }
        int i62 = i15;
        boolean[][] zArr12 = zArr4;
        int[] iArr24 = iArr17;
        int i63 = unsignedExpGolombCodedInt;
        int[] iArr25 = new int[i17];
        int i64 = 2;
        boolean[][] zArr13 = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, unsignedExpGolombCodedInt4, i17);
        int i65 = 1;
        int i66 = 0;
        while (i65 < unsignedExpGolombCodedInt4) {
            if (bits5 == i64) {
                for (int i67 = 0; i67 < iArr5[i65]; i67++) {
                    zArr11[i65][i67] = parsableNalUnitBitArray.readBit();
                    int i68 = iArr22[i65];
                    boolean z13 = zArr11[i65][i67];
                    iArr22[i65] = i68 + (z13 ? 1 : 0);
                    if (z13) {
                        iArr23[i65] = iArr[i65][i67];
                    }
                }
            }
            if (i66 == 0 && iArr[i65][0] == 0 && zArr11[i65][0]) {
                for (int i69 = 1; i69 < iArr5[i65]; i69++) {
                    if (iArr[i65][i69] == i10 && zArr11[i65][i10]) {
                        i66 = i65;
                    }
                }
            }
            int i70 = 0;
            while (i70 < iArr5[i65]) {
                if (unsignedExpGolombCodedInt3 > 1) {
                    zArr13[i65][i70] = zArr11[i65][i70];
                    zArr = zArr11;
                    i12 = unsignedExpGolombCodedInt3;
                    int iM5547c = AbstractC2498b.m5547c(unsignedExpGolombCodedInt3, RoundingMode.CEILING);
                    if (zArr13[i65][i70]) {
                        i13 = i10;
                        break;
                    }
                    int i71 = ((H265LayerInfo) c2180c5M5262g.get(iArr[i65][i70])).layerIdInVps;
                    int i72 = 0;
                    while (true) {
                        if (i72 >= i70) {
                            i13 = i10;
                            break;
                        }
                        i13 = i10;
                        if (zArr10[i71][((H265LayerInfo) c2180c5M5262g.get(iArr[i65][i72])).layerIdInVps]) {
                            zArr13[i65][i70] = true;
                            break;
                        }
                        i72++;
                        i10 = i13;
                    }
                    if (zArr13[i65][i70]) {
                        if (i66 <= 0 || i65 != i66) {
                            parsableNalUnitBitArray.skipBits(iM5547c);
                        } else {
                            iArr25[i70] = parsableNalUnitBitArray.readBits(iM5547c);
                        }
                    }
                } else {
                    i12 = unsignedExpGolombCodedInt3;
                    i13 = i10;
                    zArr = zArr11;
                }
                i70++;
                zArr11 = zArr;
                unsignedExpGolombCodedInt3 = i12;
                i10 = i13;
            }
            int i73 = unsignedExpGolombCodedInt3;
            int i74 = i10;
            boolean[][] zArr14 = zArr11;
            if (iArr22[i65] == 1 && iArr20[iArr23[i65]] > 0) {
                parsableNalUnitBitArray.skipBit();
            }
            i65++;
            zArr11 = zArr14;
            unsignedExpGolombCodedInt3 = i73;
            i10 = i74;
            i64 = 2;
        }
        if (i66 == 0) {
            return new H265VpsData(h265NalHeader, null, h265ProfileTierLevelsAndIndices, null, null);
        }
        H265RepFormatsAndIndices h265RepFormatsAndIndices = parseH265RepFormatsAndIndices(parsableNalUnitBitArray, i62);
        parsableNalUnitBitArray.skipBits(2);
        for (int i75 = 1; i75 < i62; i75++) {
            if (iArr20[iArr21[i75]] == 0) {
                parsableNalUnitBitArray.skipBit();
            }
        }
        skipH265DpbSize(parsableNalUnitBitArray, unsignedExpGolombCodedInt4, iArr24, iArr5, zArr13);
        skipToH265VuiPresentFlagAfterDpbSize(parsableNalUnitBitArray, i62, zArr12);
        if (parsableNalUnitBitArray.readBit()) {
            parsableNalUnitBitArray.byteAlign();
            h265VideoSignalInfosAndIndices = parseH265VideoSignalInfosAndIndices(parsableNalUnitBitArray, i62, i63, iArr24);
        } else {
            h265VideoSignalInfosAndIndices = null;
        }
        return new H265VpsData(h265NalHeader, c2180c5M5262g, new H265ProfileTierLevelsAndIndices(c2180c5M5262g2, iArr25), h265RepFormatsAndIndices, h265VideoSignalInfosAndIndices);
    }

    public static PpsData parsePpsNalUnit(byte[] bArr, int i6, int i10) {
        return parsePpsNalUnitPayload(bArr, i6 + 1, i10);
    }

    public static PpsData parsePpsNalUnitPayload(byte[] bArr, int i6, int i10) {
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i6, i10);
        int unsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int unsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.skipBit();
        return new PpsData(unsignedExpGolombCodedInt, unsignedExpGolombCodedInt2, parsableNalUnitBitArray.readBit());
    }

    public static SpsData parseSpsNalUnit(byte[] bArr, int i6, int i10) {
        return parseSpsNalUnitPayload(bArr, i6 + 1, i10);
    }

    public static SpsData parseSpsNalUnitPayload(byte[] bArr, int i6, int i10) {
        int unsignedExpGolombCodedInt;
        boolean bit;
        int unsignedExpGolombCodedInt2;
        int unsignedExpGolombCodedInt3;
        int unsignedExpGolombCodedInt4;
        boolean z7;
        boolean bit2;
        int i11;
        int i12;
        int unsignedExpGolombCodedInt5;
        int iIsoColorPrimariesToColorSpace;
        float f;
        int i13;
        float f3;
        int i14;
        int i15;
        int iIsoTransferCharacteristicsToColorTransfer;
        int i16;
        boolean bit3;
        boolean bit4;
        int bits;
        float[] fArr;
        int bits2;
        int bits3;
        int i17;
        int i18;
        int i19;
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i6, i10);
        int bits4 = parsableNalUnitBitArray.readBits(8);
        int bits5 = parsableNalUnitBitArray.readBits(8);
        int bits6 = parsableNalUnitBitArray.readBits(8);
        int unsignedExpGolombCodedInt6 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (bits4 == 100 || bits4 == 110 || bits4 == 122 || bits4 == 244 || bits4 == 44 || bits4 == 83 || bits4 == 86 || bits4 == 118 || bits4 == 128 || bits4 == 138) {
            unsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            bit = unsignedExpGolombCodedInt == 3 ? parsableNalUnitBitArray.readBit() : false;
            unsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            unsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.skipBit();
            if (parsableNalUnitBitArray.readBit()) {
                int i20 = unsignedExpGolombCodedInt == 3 ? 12 : 8;
                int i21 = 0;
                while (i21 < i20) {
                    if (parsableNalUnitBitArray.readBit()) {
                        skipScalingList(parsableNalUnitBitArray, i21 < 6 ? 16 : 64);
                    }
                    i21++;
                }
            }
        } else {
            unsignedExpGolombCodedInt = 1;
            bit = false;
            unsignedExpGolombCodedInt2 = 0;
            unsignedExpGolombCodedInt3 = 0;
        }
        int unsignedExpGolombCodedInt7 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 4;
        int unsignedExpGolombCodedInt8 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (unsignedExpGolombCodedInt8 != 0) {
            if (unsignedExpGolombCodedInt8 == 1) {
                boolean bit5 = parsableNalUnitBitArray.readBit();
                parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                bits4 = bits4;
                long unsignedExpGolombCodedInt9 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                for (int i22 = 0; i22 < unsignedExpGolombCodedInt9; i22++) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                }
                z7 = bit5;
                unsignedExpGolombCodedInt4 = 0;
            } else {
                unsignedExpGolombCodedInt4 = 0;
            }
            int unsignedExpGolombCodedInt10 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.skipBit();
            int unsignedExpGolombCodedInt11 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
            int unsignedExpGolombCodedInt12 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
            bit2 = parsableNalUnitBitArray.readBit();
            int i23 = (2 - (bit2 ? 1 : 0)) * unsignedExpGolombCodedInt12;
            if (!bit2) {
                parsableNalUnitBitArray.skipBit();
            }
            parsableNalUnitBitArray.skipBit();
            i11 = unsignedExpGolombCodedInt11 * 16;
            i12 = i23 * 16;
            if (parsableNalUnitBitArray.readBit()) {
                int unsignedExpGolombCodedInt13 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int unsignedExpGolombCodedInt14 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int unsignedExpGolombCodedInt15 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int unsignedExpGolombCodedInt16 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                if (unsignedExpGolombCodedInt == 0) {
                    i19 = 2 - (bit2 ? 1 : 0);
                    i17 = 1;
                } else {
                    if (unsignedExpGolombCodedInt == 3) {
                        i17 = 1;
                    } else {
                        i17 = 2;
                    }
                    if (unsignedExpGolombCodedInt == 1) {
                        i18 = 2;
                    } else {
                        i18 = 1;
                    }
                    i19 = i18 * (2 - (bit2 ? 1 : 0));
                }
                i11 -= (unsignedExpGolombCodedInt13 + unsignedExpGolombCodedInt14) * i17;
                i12 -= (unsignedExpGolombCodedInt15 + unsignedExpGolombCodedInt16) * i19;
            }
            int i24 = i12;
            int i25 = bits4;
            int i26 = i11;
            unsignedExpGolombCodedInt5 = ((i25 != 44 || i25 == 86 || i25 == 100 || i25 == 110 || i25 == 122 || i25 == 244) && (bits5 & 16) != 0) ? 0 : 16;
            iIsoColorPrimariesToColorSpace = -1;
            f = 1.0f;
            if (parsableNalUnitBitArray.readBit()) {
                if (parsableNalUnitBitArray.readBit()) {
                    bits = parsableNalUnitBitArray.readBits(8);
                    if (bits == 255) {
                        bits2 = parsableNalUnitBitArray.readBits(16);
                        bits3 = parsableNalUnitBitArray.readBits(16);
                        if (bits2 != 0 && bits3 != 0) {
                            f = bits2 / bits3;
                        }
                    } else {
                        fArr = ASPECT_RATIO_IDC_VALUES;
                        if (bits < fArr.length) {
                            f = fArr[bits];
                        } else {
                            AbstractC0004e.m31y(bits, "Unexpected aspect_ratio_idc value: ", TAG);
                        }
                    }
                }
                if (parsableNalUnitBitArray.readBit()) {
                    parsableNalUnitBitArray.skipBit();
                }
                if (parsableNalUnitBitArray.readBit()) {
                    parsableNalUnitBitArray.skipBits(3);
                    i16 = parsableNalUnitBitArray.readBit() ? 1 : 2;
                    if (parsableNalUnitBitArray.readBit()) {
                        int bits7 = parsableNalUnitBitArray.readBits(8);
                        int bits8 = parsableNalUnitBitArray.readBits(8);
                        parsableNalUnitBitArray.skipBits(8);
                        iIsoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace(bits7);
                        iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(bits8);
                    } else {
                        iIsoTransferCharacteristicsToColorTransfer = -1;
                    }
                } else {
                    iIsoTransferCharacteristicsToColorTransfer = -1;
                    i16 = -1;
                }
                if (parsableNalUnitBitArray.readBit()) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                }
                if (parsableNalUnitBitArray.readBit()) {
                    parsableNalUnitBitArray.skipBits(65);
                }
                bit3 = parsableNalUnitBitArray.readBit();
                if (bit3) {
                    skipHrdParameters(parsableNalUnitBitArray);
                }
                bit4 = parsableNalUnitBitArray.readBit();
                if (bit4) {
                    skipHrdParameters(parsableNalUnitBitArray);
                }
                if (bit3 || bit4) {
                    parsableNalUnitBitArray.skipBit();
                }
                parsableNalUnitBitArray.skipBit();
                if (parsableNalUnitBitArray.readBit()) {
                    parsableNalUnitBitArray.skipBit();
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    unsignedExpGolombCodedInt5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                }
                i13 = unsignedExpGolombCodedInt5;
                i15 = iIsoTransferCharacteristicsToColorTransfer;
                f3 = f;
                i14 = i16;
            } else {
                i13 = unsignedExpGolombCodedInt5;
                f3 = 1.0f;
                i14 = -1;
                i15 = -1;
            }
            return new SpsData(i25, bits5, bits6, unsignedExpGolombCodedInt6, unsignedExpGolombCodedInt10, i26, i24, f3, unsignedExpGolombCodedInt2, unsignedExpGolombCodedInt3, bit, bit2, unsignedExpGolombCodedInt7, unsignedExpGolombCodedInt8, unsignedExpGolombCodedInt4, z7, iIsoColorPrimariesToColorSpace, i14, i15, i13);
        }
        unsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 4;
        z7 = false;
        int unsignedExpGolombCodedInt17 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.skipBit();
        int unsignedExpGolombCodedInt18 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
        int unsignedExpGolombCodedInt19 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
        bit2 = parsableNalUnitBitArray.readBit();
        int i27 = (2 - (bit2 ? 1 : 0)) * unsignedExpGolombCodedInt19;
        if (!bit2) {
            parsableNalUnitBitArray.skipBit();
        }
        parsableNalUnitBitArray.skipBit();
        i11 = unsignedExpGolombCodedInt18 * 16;
        i12 = i27 * 16;
        if (parsableNalUnitBitArray.readBit()) {
            int unsignedExpGolombCodedInt110 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int unsignedExpGolombCodedInt111 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int unsignedExpGolombCodedInt112 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int unsignedExpGolombCodedInt113 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            if (unsignedExpGolombCodedInt == 0) {
                i19 = 2 - (bit2 ? 1 : 0);
                i17 = 1;
            } else {
                if (unsignedExpGolombCodedInt == 3) {
                    i17 = 1;
                } else {
                    i17 = 2;
                }
                if (unsignedExpGolombCodedInt == 1) {
                    i18 = 2;
                } else {
                    i18 = 1;
                }
                i19 = i18 * (2 - (bit2 ? 1 : 0));
            }
            i11 -= (unsignedExpGolombCodedInt110 + unsignedExpGolombCodedInt111) * i17;
            i12 -= (unsignedExpGolombCodedInt112 + unsignedExpGolombCodedInt113) * i19;
        }
        int i28 = i12;
        int i29 = bits4;
        int i210 = i11;
        if (i29 != 44) {
        }
        iIsoColorPrimariesToColorSpace = -1;
        f = 1.0f;
        if (parsableNalUnitBitArray.readBit()) {
            if (parsableNalUnitBitArray.readBit()) {
                bits = parsableNalUnitBitArray.readBits(8);
                if (bits == 255) {
                    bits2 = parsableNalUnitBitArray.readBits(16);
                    bits3 = parsableNalUnitBitArray.readBits(16);
                    if (bits2 != 0) {
                        f = bits2 / bits3;
                    }
                } else {
                    fArr = ASPECT_RATIO_IDC_VALUES;
                    if (bits < fArr.length) {
                        f = fArr[bits];
                    } else {
                        AbstractC0004e.m31y(bits, "Unexpected aspect_ratio_idc value: ", TAG);
                    }
                }
            }
            if (parsableNalUnitBitArray.readBit()) {
                parsableNalUnitBitArray.skipBit();
            }
            if (parsableNalUnitBitArray.readBit()) {
                parsableNalUnitBitArray.skipBits(3);
                if (parsableNalUnitBitArray.readBit()) {
                }
                if (parsableNalUnitBitArray.readBit()) {
                    int bits9 = parsableNalUnitBitArray.readBits(8);
                    int bits10 = parsableNalUnitBitArray.readBits(8);
                    parsableNalUnitBitArray.skipBits(8);
                    iIsoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace(bits9);
                    iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(bits10);
                } else {
                    iIsoTransferCharacteristicsToColorTransfer = -1;
                }
            } else {
                iIsoTransferCharacteristicsToColorTransfer = -1;
                i16 = -1;
            }
            if (parsableNalUnitBitArray.readBit()) {
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            }
            if (parsableNalUnitBitArray.readBit()) {
                parsableNalUnitBitArray.skipBits(65);
            }
            bit3 = parsableNalUnitBitArray.readBit();
            if (bit3) {
                skipHrdParameters(parsableNalUnitBitArray);
            }
            bit4 = parsableNalUnitBitArray.readBit();
            if (bit4) {
                skipHrdParameters(parsableNalUnitBitArray);
            }
            if (bit3) {
                parsableNalUnitBitArray.skipBit();
            } else {
                parsableNalUnitBitArray.skipBit();
            }
            parsableNalUnitBitArray.skipBit();
            if (parsableNalUnitBitArray.readBit()) {
                parsableNalUnitBitArray.skipBit();
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                unsignedExpGolombCodedInt5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            }
            i13 = unsignedExpGolombCodedInt5;
            i15 = iIsoTransferCharacteristicsToColorTransfer;
            f3 = f;
            i14 = i16;
        } else {
            i13 = unsignedExpGolombCodedInt5;
            f3 = 1.0f;
            i14 = -1;
            i15 = -1;
        }
        return new SpsData(i29, bits5, bits6, unsignedExpGolombCodedInt6, unsignedExpGolombCodedInt17, i210, i28, f3, unsignedExpGolombCodedInt2, unsignedExpGolombCodedInt3, bit, bit2, unsignedExpGolombCodedInt7, unsignedExpGolombCodedInt8, unsignedExpGolombCodedInt4, z7, iIsoColorPrimariesToColorSpace, i14, i15, i13);
    }

    private static void skipH265DpbSize(ParsableNalUnitBitArray parsableNalUnitBitArray, int i6, int[] iArr, int[] iArr2, boolean[][] zArr) {
        for (int i10 = 1; i10 < i6; i10++) {
            boolean bit = parsableNalUnitBitArray.readBit();
            int i11 = 0;
            while (i11 < iArr[i10]) {
                if ((i11 <= 0 || !bit) ? i11 == 0 : parsableNalUnitBitArray.readBit()) {
                    for (int i12 = 0; i12 < iArr2[i10]; i12++) {
                        if (zArr[i10][i12]) {
                            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        }
                    }
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                }
                i11++;
            }
        }
    }

    private static void skipH265HrdParameters(ParsableNalUnitBitArray parsableNalUnitBitArray, boolean z7, int i6) {
        boolean z10;
        boolean z11;
        int i10;
        boolean bit;
        int i11;
        int i12;
        boolean bit2;
        boolean bit3;
        int unsignedExpGolombCodedInt;
        int i13;
        int i14;
        int i15;
        if (z7) {
            boolean bit4 = parsableNalUnitBitArray.readBit();
            boolean bit5 = parsableNalUnitBitArray.readBit();
            if (bit4 || bit5) {
                z11 = bit5;
                z10 = bit4;
                bit = parsableNalUnitBitArray.readBit();
                if (bit) {
                    parsableNalUnitBitArray.skipBits(19);
                }
                parsableNalUnitBitArray.skipBits(8);
                if (bit) {
                    parsableNalUnitBitArray.skipBits(4);
                }
                parsableNalUnitBitArray.skipBits(15);
                i11 = bit5;
                i10 = bit4;
            }
            for (i12 = 0; i12 <= i6; i12++) {
                bit2 = parsableNalUnitBitArray.readBit();
                if (!bit2) {
                    bit2 = parsableNalUnitBitArray.readBit();
                }
                if (bit2) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    bit3 = false;
                } else {
                    bit3 = parsableNalUnitBitArray.readBit();
                }
                if (bit3) {
                    unsignedExpGolombCodedInt = 0;
                } else {
                    unsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                }
                i13 = i10 + i11;
                for (i14 = 0; i14 < i13; i14++) {
                    for (i15 = 0; i15 <= unsignedExpGolombCodedInt; i15++) {
                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        if (bit) {
                            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        }
                        parsableNalUnitBitArray.skipBit();
                    }
                }
            }
        }
        z10 = false;
        z11 = false;
        bit = false;
        i11 = z11;
        i10 = z10;
        while (i12 <= i6) {
            bit2 = parsableNalUnitBitArray.readBit();
            if (!bit2) {
                bit2 = parsableNalUnitBitArray.readBit();
            }
            if (bit2) {
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                bit3 = false;
            } else {
                bit3 = parsableNalUnitBitArray.readBit();
            }
            if (bit3) {
                unsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            } else {
                unsignedExpGolombCodedInt = 0;
            }
            i13 = i10 + i11;
            while (i14 < i13) {
                while (i15 <= unsignedExpGolombCodedInt) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    if (bit) {
                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    }
                    parsableNalUnitBitArray.skipBit();
                }
            }
        }
    }

    private static void skipH265ScalingList(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        for (int i6 = 0; i6 < 4; i6++) {
            int i10 = 0;
            while (i10 < 6) {
                int i11 = 1;
                if (parsableNalUnitBitArray.readBit()) {
                    int iMin = Math.min(64, 1 << ((i6 << 1) + 4));
                    if (i6 > 1) {
                        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                    }
                    for (int i12 = 0; i12 < iMin; i12++) {
                        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                    }
                } else {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                }
                if (i6 == 3) {
                    i11 = 3;
                }
                i10 += i11;
            }
        }
    }

    private static void skipH265ShortTermReferencePictureSets(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        int unsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int[] iArr = new int[0];
        int[] iArrCopyOf = new int[0];
        int i6 = -1;
        int i10 = -1;
        for (int i11 = 0; i11 < unsignedExpGolombCodedInt; i11++) {
            if (i11 == 0 || !parsableNalUnitBitArray.readBit()) {
                int unsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int unsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int[] iArr2 = new int[unsignedExpGolombCodedInt2];
                int i12 = 0;
                while (i12 < unsignedExpGolombCodedInt2) {
                    iArr2[i12] = (i12 > 0 ? iArr2[i12 - 1] : 0) - (parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1);
                    parsableNalUnitBitArray.skipBit();
                    i12++;
                }
                int[] iArr3 = new int[unsignedExpGolombCodedInt3];
                int i13 = 0;
                while (i13 < unsignedExpGolombCodedInt3) {
                    iArr3[i13] = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1 + (i13 > 0 ? iArr3[i13 - 1] : 0);
                    parsableNalUnitBitArray.skipBit();
                    i13++;
                }
                i6 = unsignedExpGolombCodedInt2;
                iArr = iArr2;
                i10 = unsignedExpGolombCodedInt3;
                iArrCopyOf = iArr3;
            } else {
                int i14 = i6 + i10;
                int unsignedExpGolombCodedInt4 = (1 - ((parsableNalUnitBitArray.readBit() ? 1 : 0) * 2)) * (parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1);
                int i15 = i14 + 1;
                boolean[] zArr = new boolean[i15];
                for (int i16 = 0; i16 <= i14; i16++) {
                    if (parsableNalUnitBitArray.readBit()) {
                        zArr[i16] = true;
                    } else {
                        zArr[i16] = parsableNalUnitBitArray.readBit();
                    }
                }
                int[] iArr4 = new int[i15];
                int[] iArr5 = new int[i15];
                int i17 = 0;
                for (int i18 = i10 - 1; i18 >= 0; i18--) {
                    int i19 = iArrCopyOf[i18] + unsignedExpGolombCodedInt4;
                    if (i19 < 0 && zArr[i6 + i18]) {
                        iArr4[i17] = i19;
                        i17++;
                    }
                }
                if (unsignedExpGolombCodedInt4 < 0 && zArr[i14]) {
                    iArr4[i17] = unsignedExpGolombCodedInt4;
                    i17++;
                }
                for (int i20 = 0; i20 < i6; i20++) {
                    int i21 = iArr[i20] + unsignedExpGolombCodedInt4;
                    if (i21 < 0 && zArr[i20]) {
                        iArr4[i17] = i21;
                        i17++;
                    }
                }
                int[] iArrCopyOf2 = Arrays.copyOf(iArr4, i17);
                int i22 = 0;
                for (int i23 = i6 - 1; i23 >= 0; i23--) {
                    int i24 = iArr[i23] + unsignedExpGolombCodedInt4;
                    if (i24 > 0 && zArr[i23]) {
                        iArr5[i22] = i24;
                        i22++;
                    }
                }
                if (unsignedExpGolombCodedInt4 > 0 && zArr[i14]) {
                    iArr5[i22] = unsignedExpGolombCodedInt4;
                    i22++;
                }
                for (int i25 = 0; i25 < i10; i25++) {
                    int i26 = iArrCopyOf[i25] + unsignedExpGolombCodedInt4;
                    if (i26 > 0 && zArr[i6 + i25]) {
                        iArr5[i22] = i26;
                        i22++;
                    }
                }
                iArrCopyOf = Arrays.copyOf(iArr5, i22);
                iArr = iArrCopyOf2;
                i6 = i17;
                i10 = i22;
            }
        }
    }

    private static void skipHrdParameters(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        int unsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
        parsableNalUnitBitArray.skipBits(8);
        for (int i6 = 0; i6 < unsignedExpGolombCodedInt; i6++) {
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.skipBit();
        }
        parsableNalUnitBitArray.skipBits(20);
    }

    private static void skipScalingList(ParsableNalUnitBitArray parsableNalUnitBitArray, int i6) {
        int signedExpGolombCodedInt = 8;
        int i10 = 8;
        for (int i11 = 0; i11 < i6; i11++) {
            if (signedExpGolombCodedInt != 0) {
                signedExpGolombCodedInt = ((parsableNalUnitBitArray.readSignedExpGolombCodedInt() + i10) + 256) % 256;
            }
            if (signedExpGolombCodedInt != 0) {
                i10 = signedExpGolombCodedInt;
            }
        }
    }

    private static void skipToH265VuiPresentFlagAfterDpbSize(ParsableNalUnitBitArray parsableNalUnitBitArray, int i6, boolean[][] zArr) {
        int unsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 2;
        if (parsableNalUnitBitArray.readBit()) {
            parsableNalUnitBitArray.skipBits(unsignedExpGolombCodedInt);
        } else {
            for (int i10 = 1; i10 < i6; i10++) {
                for (int i11 = 0; i11 < i10; i11++) {
                    if (zArr[i10][i11]) {
                        parsableNalUnitBitArray.skipBits(unsignedExpGolombCodedInt);
                    }
                }
            }
        }
        int unsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        for (int i12 = 1; i12 <= unsignedExpGolombCodedInt2; i12++) {
            parsableNalUnitBitArray.skipBits(8);
        }
    }

    public static int unescapeStream(byte[] bArr, int i6) {
        int i10;
        synchronized (scratchEscapePositionsLock) {
            int iFindNextUnescapeIndex = 0;
            int i11 = 0;
            while (iFindNextUnescapeIndex < i6) {
                try {
                    iFindNextUnescapeIndex = findNextUnescapeIndex(bArr, iFindNextUnescapeIndex, i6);
                    if (iFindNextUnescapeIndex < i6) {
                        int[] iArr = scratchEscapePositions;
                        if (iArr.length <= i11) {
                            scratchEscapePositions = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        scratchEscapePositions[i11] = iFindNextUnescapeIndex;
                        iFindNextUnescapeIndex += 3;
                        i11++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            i10 = i6 - i11;
            int i12 = 0;
            int i13 = 0;
            for (int i14 = 0; i14 < i11; i14++) {
                int i15 = scratchEscapePositions[i14] - i13;
                System.arraycopy(bArr, i13, bArr, i12, i15);
                int i16 = i12 + i15;
                int i17 = i16 + 1;
                bArr[i16] = 0;
                i12 = i16 + 2;
                bArr[i17] = 0;
                i13 += i15 + 3;
            }
            System.arraycopy(bArr, i13, bArr, i12, i10 - i12);
        }
        return i10;
    }

    public static boolean isNalUnitSei(Format format, byte b8) {
        if ((Objects.equals(format.sampleMimeType, MimeTypes.VIDEO_H264) || MimeTypes.containsCodecsCorrespondingToMimeType(format.codecs, MimeTypes.VIDEO_H264)) && (b8 & 31) == 6) {
            return true;
        }
        return (Objects.equals(format.sampleMimeType, MimeTypes.VIDEO_H265) || MimeTypes.containsCodecsCorrespondingToMimeType(format.codecs, MimeTypes.VIDEO_H265)) && ((b8 & 126) >> 1) == 39;
    }
}

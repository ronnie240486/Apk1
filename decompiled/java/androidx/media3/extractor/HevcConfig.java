package androidx.media3.extractor;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.container.NalUnitUtil;
import java.util.Collections;
import java.util.List;

@UnstableApi
public final class HevcConfig {
    public final int bitdepthChroma;
    public final int bitdepthLuma;
    public final String codecs;
    public final int colorRange;
    public final int colorSpace;
    public final int colorTransfer;
    public final int height;
    public final List<byte[]> initializationData;
    public final int maxNumReorderPics;
    public final int maxSubLayers;
    public final int nalUnitLengthFieldLength;
    public final float pixelWidthHeightRatio;
    public final int stereoMode;
    public final NalUnitUtil.H265VpsData vpsData;
    public final int width;

    private HevcConfig(List<byte[]> list, int i6, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, float f, int i19, String str, NalUnitUtil.H265VpsData h265VpsData) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i6;
        this.maxSubLayers = i10;
        this.width = i11;
        this.height = i12;
        this.bitdepthLuma = i13;
        this.bitdepthChroma = i14;
        this.colorSpace = i15;
        this.colorRange = i16;
        this.colorTransfer = i17;
        this.stereoMode = i18;
        this.pixelWidthHeightRatio = f;
        this.maxNumReorderPics = i19;
        this.codecs = str;
        this.vpsData = h265VpsData;
    }

    public static HevcConfig parse(ParsableByteArray parsableByteArray) throws ParserException {
        return parseImpl(parsableByteArray, false, null);
    }

    private static HevcConfig parseImpl(ParsableByteArray parsableByteArray, boolean z7, NalUnitUtil.H265VpsData h265VpsData) throws ParserException {
        NalUnitUtil.H265Sei3dRefDisplayInfoData h265Sei3dRefDisplayInfo;
        try {
            if (z7) {
                parsableByteArray.skipBytes(4);
            } else {
                parsableByteArray.skipBytes(21);
            }
            int unsignedByte = parsableByteArray.readUnsignedByte() & 3;
            int unsignedByte2 = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition();
            int i6 = 0;
            int i10 = 0;
            for (int i11 = 0; i11 < unsignedByte2; i11++) {
                parsableByteArray.skipBytes(1);
                int unsignedShort = parsableByteArray.readUnsignedShort();
                for (int i12 = 0; i12 < unsignedShort; i12++) {
                    int unsignedShort2 = parsableByteArray.readUnsignedShort();
                    i10 += unsignedShort2 + 4;
                    parsableByteArray.skipBytes(unsignedShort2);
                }
            }
            parsableByteArray.setPosition(position);
            byte[] bArr = new byte[i10];
            NalUnitUtil.H265VpsData h265VpsData2 = h265VpsData;
            String strBuildHevcCodecString = null;
            int i13 = 0;
            int i14 = 0;
            int i15 = -1;
            int i16 = -1;
            int i17 = -1;
            int i18 = -1;
            int i19 = -1;
            int i20 = -1;
            int i21 = -1;
            int i22 = -1;
            int i23 = -1;
            float f = 1.0f;
            int i24 = -1;
            while (i13 < unsignedByte2) {
                int unsignedByte3 = parsableByteArray.readUnsignedByte() & 63;
                int unsignedShort3 = parsableByteArray.readUnsignedShort();
                NalUnitUtil.H265VpsData h265VpsNalUnit = h265VpsData2;
                int i25 = 0;
                while (i25 < unsignedShort3) {
                    int unsignedShort4 = parsableByteArray.readUnsignedShort();
                    byte[] bArr2 = NalUnitUtil.NAL_START_CODE;
                    int i26 = unsignedByte2;
                    System.arraycopy(bArr2, i6, bArr, i14, bArr2.length);
                    int length = i14 + bArr2.length;
                    System.arraycopy(parsableByteArray.getData(), parsableByteArray.getPosition(), bArr, length, unsignedShort4);
                    if (unsignedByte3 == 32 && i25 == 0) {
                        h265VpsNalUnit = NalUnitUtil.parseH265VpsNalUnit(bArr, length, length + unsignedShort4);
                        unsignedShort3 = unsignedShort3;
                    } else {
                        if (unsignedByte3 == 33 && i25 == 0) {
                            NalUnitUtil.H265SpsData h265SpsNalUnit = NalUnitUtil.parseH265SpsNalUnit(bArr, length, length + unsignedShort4, h265VpsNalUnit);
                            int i27 = h265SpsNalUnit.maxSubLayersMinus1 + 1;
                            int i28 = h265SpsNalUnit.width;
                            int i29 = h265SpsNalUnit.height;
                            i18 = h265SpsNalUnit.bitDepthLumaMinus8 + 8;
                            i19 = h265SpsNalUnit.bitDepthChromaMinus8 + 8;
                            int i30 = h265SpsNalUnit.colorSpace;
                            int i31 = h265SpsNalUnit.colorRange;
                            int i32 = h265SpsNalUnit.colorTransfer;
                            float f3 = h265SpsNalUnit.pixelWidthHeightRatio;
                            int i33 = h265SpsNalUnit.maxNumReorderPics;
                            NalUnitUtil.H265ProfileTierLevel h265ProfileTierLevel = h265SpsNalUnit.profileTierLevel;
                            if (h265ProfileTierLevel != null) {
                                strBuildHevcCodecString = CodecSpecificDataUtil.buildHevcCodecString(h265ProfileTierLevel.generalProfileSpace, h265ProfileTierLevel.generalTierFlag, h265ProfileTierLevel.generalProfileIdc, h265ProfileTierLevel.generalProfileCompatibilityFlags, h265ProfileTierLevel.constraintBytes, h265ProfileTierLevel.generalLevelIdc);
                            }
                            i15 = i27;
                            i16 = i28;
                            i20 = i30;
                            i17 = i29;
                            i24 = i33;
                            f = f3;
                            i22 = i32;
                            i21 = i31;
                        } else {
                            unsignedShort3 = unsignedShort3;
                            if (unsignedByte3 == 39 && i25 == 0 && (h265Sei3dRefDisplayInfo = NalUnitUtil.parseH265Sei3dRefDisplayInfo(bArr, length, length + unsignedShort4)) != null && h265VpsNalUnit != null) {
                                i23 = h265Sei3dRefDisplayInfo.leftViewId == ((NalUnitUtil.H265LayerInfo) h265VpsNalUnit.layerInfos.get(0)).viewId ? 4 : 5;
                            }
                        }
                        i14 = length + unsignedShort4;
                        parsableByteArray.skipBytes(unsignedShort4);
                        i25++;
                        unsignedByte2 = i26;
                        unsignedShort3 = unsignedShort3;
                        i6 = 0;
                    }
                    i14 = length + unsignedShort4;
                    parsableByteArray.skipBytes(unsignedShort4);
                    i25++;
                    unsignedByte2 = i26;
                    unsignedShort3 = unsignedShort3;
                    i6 = 0;
                }
                i13++;
                h265VpsData2 = h265VpsNalUnit;
                i6 = 0;
            }
            return new HevcConfig(i10 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), unsignedByte + 1, i15, i16, i17, i18, i19, i20, i21, i22, i23, f, i24, strBuildHevcCodecString, h265VpsData2);
        } catch (ArrayIndexOutOfBoundsException e5) {
            throw ParserException.createForMalformedContainer("Error parsing".concat(z7 ? "L-HEVC config" : "HEVC config"), e5);
        }
    }

    public static HevcConfig parseLayered(ParsableByteArray parsableByteArray, NalUnitUtil.H265VpsData h265VpsData) throws ParserException {
        return parseImpl(parsableByteArray, true, h265VpsData);
    }
}

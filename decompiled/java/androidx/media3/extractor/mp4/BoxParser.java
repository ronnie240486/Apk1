package androidx.media3.extractor.mp4;

import android.util.Pair;
import androidx.media3.common.C0565C;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.Mp4AlternateGroupData;
import androidx.media3.container.Mp4Box;
import androidx.media3.container.Mp4LocationData;
import androidx.media3.container.Mp4TimestampData;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.Ac3Util;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.AvcConfig;
import androidx.media3.extractor.DolbyVisionConfig;
import androidx.media3.extractor.ExtractorUtil;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.HevcConfig;
import androidx.media3.extractor.OpusUtil;
import androidx.media3.extractor.VorbisUtil;
import androidx.media3.extractor.p010ts.PsExtractor;
import com.alibaba.fastjson.asm.Opcodes;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import p000a.AbstractC0004e;
import p020b7.InterfaceC1346i;
import p041d7.AbstractC2301u1;
import p041d7.C2180c5;
import p041d7.C2288s1;
import p187r4.AbstractC3612b;

@UnstableApi
public final class BoxParser {
    private static final int MAX_GAPLESS_TRIM_SIZE_SAMPLES = 4;
    private static final int SAMPLE_RATE_AMR_NB = 8000;
    private static final int SAMPLE_RATE_AMR_WB = 16000;
    private static final String TAG = "BoxParsers";
    private static final int TYPE_clcp = 1668047728;
    private static final int TYPE_mdta = 1835299937;
    private static final int TYPE_meta = 1835365473;
    private static final int TYPE_nclc = 1852009571;
    private static final int TYPE_nclx = 1852009592;
    private static final int TYPE_sbtl = 1935832172;
    private static final int TYPE_soun = 1936684398;
    private static final int TYPE_subt = 1937072756;
    private static final int TYPE_text = 1952807028;
    private static final int TYPE_vide = 1986618469;
    private static final byte[] opusMagic = Util.getUtf8Bytes("OpusHead");

    public static final class BtrtData {
        private final long avgBitrate;
        private final long maxBitrate;

        public BtrtData(long j10, long j11) {
            this.avgBitrate = j10;
            this.maxBitrate = j11;
        }
    }

    public static final class ChunkIterator {
        private final ParsableByteArray chunkOffsets;
        private final boolean chunkOffsetsAreLongs;
        public int index;
        public final int length;
        private int nextSamplesPerChunkChangeIndex;
        public int numSamples;
        public long offset;
        private int remainingSamplesPerChunkChanges;
        private final ParsableByteArray stsc;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z7) throws ParserException {
            this.stsc = parsableByteArray;
            this.chunkOffsets = parsableByteArray2;
            this.chunkOffsetsAreLongs = z7;
            parsableByteArray2.setPosition(12);
            this.length = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray.readUnsignedIntToInt();
            ExtractorUtil.checkContainerInput(parsableByteArray.readInt() == 1, "first_chunk must be 1");
            this.index = -1;
        }

        public boolean moveNext() {
            int i6 = this.index + 1;
            this.index = i6;
            if (i6 == this.length) {
                return false;
            }
            this.offset = this.chunkOffsetsAreLongs ? this.chunkOffsets.readUnsignedLongToLong() : this.chunkOffsets.readUnsignedInt();
            if (this.index == this.nextSamplesPerChunkChangeIndex) {
                this.numSamples = this.stsc.readUnsignedIntToInt();
                this.stsc.skipBytes(4);
                int i10 = this.remainingSamplesPerChunkChanges - 1;
                this.remainingSamplesPerChunkChanges = i10;
                this.nextSamplesPerChunkChangeIndex = i10 > 0 ? this.stsc.readUnsignedIntToInt() - 1 : -1;
            }
            return true;
        }
    }

    public static final class EsdsData {
        private final long bitrate;
        private final byte[] initializationData;
        private final String mimeType;
        private final long peakBitrate;

        public EsdsData(String str, byte[] bArr, long j10, long j11) {
            this.mimeType = str;
            this.initializationData = bArr;
            this.bitrate = j10;
            this.peakBitrate = j11;
        }
    }

    public static final class EyesData {
        private final StriData striData;

        public EyesData(StriData striData) {
            this.striData = striData;
        }
    }

    public static final class MdhdData {
        private final String language;
        private final long mediaDurationUs;
        private final long timescale;

        public MdhdData(long j10, long j11, String str) {
            this.timescale = j10;
            this.mediaDurationUs = j11;
            this.language = str;
        }
    }

    public interface SampleSizeBox {
        int getFixedSampleSize();

        int getSampleCount();

        int readNextSampleSize();
    }

    public static final class StriData {
        private final boolean eyeViewsReversed;
        private final boolean hasLeftEyeView;
        private final boolean hasRightEyeView;

        public StriData(boolean z7, boolean z10, boolean z11) {
            this.hasLeftEyeView = z7;
            this.hasRightEyeView = z10;
            this.eyeViewsReversed = z11;
        }
    }

    public static final class StsdData {
        public static final int STSD_HEADER_SIZE = 8;
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation = 0;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int i6) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[i6];
        }
    }

    public static final class StszSampleSizeBox implements SampleSizeBox {
        private final ParsableByteArray data;
        private final int fixedSampleSize;
        private final int sampleCount;

        public StszSampleSizeBox(Mp4Box.LeafBox leafBox, Format format) {
            ParsableByteArray parsableByteArray = leafBox.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            if (MimeTypes.AUDIO_RAW.equals(format.sampleMimeType)) {
                int pcmFrameSize = Util.getPcmFrameSize(format.pcmEncoding, format.channelCount);
                if (unsignedIntToInt == 0 || unsignedIntToInt % pcmFrameSize != 0) {
                    Log.m1719w(BoxParser.TAG, "Audio sample size mismatch. stsd sample size: " + pcmFrameSize + ", stsz sample size: " + unsignedIntToInt);
                    unsignedIntToInt = pcmFrameSize;
                }
            }
            this.fixedSampleSize = unsignedIntToInt == 0 ? -1 : unsignedIntToInt;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override
        public int getFixedSampleSize() {
            return this.fixedSampleSize;
        }

        @Override
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override
        public int readNextSampleSize() {
            int i6 = this.fixedSampleSize;
            return i6 == -1 ? this.data.readUnsignedIntToInt() : i6;
        }
    }

    public static final class Stz2SampleSizeBox implements SampleSizeBox {
        private int currentByte;
        private final ParsableByteArray data;
        private final int fieldSize;
        private final int sampleCount;
        private int sampleIndex;

        public Stz2SampleSizeBox(Mp4Box.LeafBox leafBox) {
            ParsableByteArray parsableByteArray = leafBox.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fieldSize = parsableByteArray.readUnsignedIntToInt() & 255;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override
        public int getFixedSampleSize() {
            return -1;
        }

        @Override
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override
        public int readNextSampleSize() {
            int i6 = this.fieldSize;
            if (i6 == 8) {
                return this.data.readUnsignedByte();
            }
            if (i6 == 16) {
                return this.data.readUnsignedShort();
            }
            int i10 = this.sampleIndex;
            this.sampleIndex = i10 + 1;
            if (i10 % 2 != 0) {
                return this.currentByte & 15;
            }
            int unsignedByte = this.data.readUnsignedByte();
            this.currentByte = unsignedByte;
            return (unsignedByte & PsExtractor.VIDEO_STREAM_MASK) >> 4;
        }
    }

    public static final class TkhdData {
        private final int alternateGroup;
        private final long duration;

        private final int f3099id;
        private final int rotationDegrees;

        public TkhdData(int i6, long j10, int i10, int i11) {
            this.f3099id = i6;
            this.duration = j10;
            this.alternateGroup = i10;
            this.rotationDegrees = i11;
        }
    }

    public static final class VexuData {
        private final EyesData eyesData;

        public VexuData(EyesData eyesData) {
            this.eyesData = eyesData;
        }

        public boolean hasBothEyeViews() {
            EyesData eyesData = this.eyesData;
            return eyesData != null && eyesData.striData.hasLeftEyeView && this.eyesData.striData.hasRightEyeView;
        }
    }

    private BoxParser() {
    }

    private static ByteBuffer allocateHdrStaticInfo() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static boolean canApplyEditWithGaplessInfo(long[] jArr, long j10, long j11, long j12) {
        int length = jArr.length - 1;
        return jArr[0] <= j11 && j11 < jArr[Util.constrainValue(4, 0, length)] && jArr[Util.constrainValue(jArr.length - 4, 0, length)] < j12 && j12 <= j10;
    }

    private static int findBoxPosition(ParsableByteArray parsableByteArray, int i6, int i10, int i11) throws ParserException {
        int position = parsableByteArray.getPosition();
        ExtractorUtil.checkContainerInput(position >= i10, null);
        while (position - i10 < i11) {
            parsableByteArray.setPosition(position);
            int i12 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i12 > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == i6) {
                return position;
            }
            position += i12;
        }
        return -1;
    }

    private static String getLanguageFromCode(int i6) {
        char[] cArr = {(char) (((i6 >> 10) & 31) + 96), (char) (((i6 >> 5) & 31) + 96), (char) ((i6 & 31) + 96)};
        for (int i10 = 0; i10 < 3; i10++) {
            char c5 = cArr[i10];
            if (c5 < 'a' || c5 > 'z') {
                return null;
            }
        }
        return new String(cArr);
    }

    private static int getTrackTypeForHdlr(int i6) {
        if (i6 == TYPE_soun) {
            return 1;
        }
        if (i6 == TYPE_vide) {
            return 2;
        }
        if (i6 == TYPE_text || i6 == TYPE_sbtl || i6 == TYPE_subt || i6 == TYPE_clcp) {
            return 3;
        }
        return i6 == 1835365473 ? 5 : -1;
    }

    public static void maybeSkipRemainingMetaBoxHeaderBytes(ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(4);
        if (parsableByteArray.readInt() != 1751411826) {
            position += 4;
        }
        parsableByteArray.setPosition(position);
    }

    private static ColorInfo parseApvc(ParsableByteArray parsableByteArray) {
        ColorInfo.Builder builder = new ColorInfo.Builder();
        ParsableBitArray parsableBitArray = new ParsableBitArray(parsableByteArray.getData());
        parsableBitArray.setPosition(parsableByteArray.getPosition() * 8);
        parsableBitArray.skipBytes(1);
        int bits = parsableBitArray.readBits(8);
        for (int i6 = 0; i6 < bits; i6++) {
            parsableBitArray.skipBytes(1);
            int bits2 = parsableBitArray.readBits(8);
            for (int i10 = 0; i10 < bits2; i10++) {
                parsableBitArray.skipBits(6);
                boolean bit = parsableBitArray.readBit();
                parsableBitArray.skipBit();
                parsableBitArray.skipBytes(11);
                parsableBitArray.skipBits(4);
                int bits3 = parsableBitArray.readBits(4) + 8;
                builder.setLumaBitdepth(bits3);
                builder.setChromaBitdepth(bits3);
                parsableBitArray.skipBytes(1);
                if (bit) {
                    int bits4 = parsableBitArray.readBits(8);
                    int bits5 = parsableBitArray.readBits(8);
                    parsableBitArray.skipBytes(1);
                    builder.setColorSpace(ColorInfo.isoColorPrimariesToColorSpace(bits4)).setColorRange(parsableBitArray.readBit() ? 1 : 2).setColorTransfer(ColorInfo.isoTransferCharacteristicsToColorTransfer(bits5));
                }
            }
        }
        return builder.build();
    }

    private static void parseAudioSampleEntry(ParsableByteArray parsableByteArray, int i6, int i10, int i11, int i12, String str, boolean z7, DrmInitData drmInitData, StsdData stsdData, int i13) throws ParserException {
        int unsignedShort;
        int unsignedShort2;
        int unsignedFixedPoint1616;
        int i14;
        int i15;
        String str2;
        int i16;
        String str3;
        List<byte[]> listM5275r;
        EsdsData esdsFromParent;
        int i17;
        boolean z10;
        int i18;
        int iFindBoxPosition;
        byte[] bArr;
        int unsignedByte;
        byte[] bArr2;
        int unsignedByte2;
        int i19;
        byte[] bArr3;
        int iIntValue = i6;
        int i20 = i10;
        int i21 = i11;
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        parsableByteArray.setPosition(i20 + 16);
        if (z7) {
            unsignedShort = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
        } else {
            parsableByteArray.skipBytes(8);
            unsignedShort = 0;
        }
        if (unsignedShort == 0 || unsignedShort == 1) {
            unsignedShort2 = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
            unsignedFixedPoint1616 = parsableByteArray.readUnsignedFixedPoint1616();
            parsableByteArray.setPosition(parsableByteArray.getPosition() - 4);
            int i22 = parsableByteArray.readInt();
            if (unsignedShort == 1) {
                parsableByteArray.skipBytes(16);
            }
            i14 = i22;
            i15 = -1;
        } else {
            if (unsignedShort != 2) {
                return;
            }
            parsableByteArray.skipBytes(16);
            unsignedFixedPoint1616 = (int) Math.round(parsableByteArray.readDouble());
            unsignedShort2 = parsableByteArray.readUnsignedIntToInt();
            parsableByteArray.skipBytes(4);
            int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            int unsignedIntToInt2 = parsableByteArray.readUnsignedIntToInt();
            boolean z11 = (unsignedIntToInt2 & 1) != 0;
            boolean z12 = (unsignedIntToInt2 & 2) != 0;
            if (z11) {
                if (unsignedIntToInt == 32) {
                    i15 = 4;
                } else {
                    i15 = -1;
                }
            } else if (unsignedIntToInt == 8) {
                i15 = 3;
            } else if (unsignedIntToInt == 16) {
                i15 = z12 ? 268435456 : 2;
            } else if (unsignedIntToInt == 24) {
                i15 = z12 ? C0565C.ENCODING_PCM_24BIT_BIG_ENDIAN : 21;
            } else if (unsignedIntToInt == 32) {
                i15 = z12 ? C0565C.ENCODING_PCM_32BIT_BIG_ENDIAN : 22;
            } else {
                i15 = -1;
            }
            parsableByteArray.skipBytes(8);
            i14 = 0;
        }
        if (iIntValue == 1767992678) {
            unsignedShort2 = -1;
            unsignedFixedPoint1616 = -1;
        } else if (iIntValue == 1935764850) {
            unsignedShort2 = 1;
            unsignedFixedPoint1616 = 8000;
        } else if (iIntValue == 1935767394) {
            unsignedShort2 = 1;
            unsignedFixedPoint1616 = 16000;
        }
        int position = parsableByteArray.getPosition();
        if (iIntValue == 1701733217) {
            Pair<Integer, TrackEncryptionBox> sampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i20, i21);
            if (sampleEntryEncryptionData != null) {
                iIntValue = ((Integer) sampleEntryEncryptionData.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((TrackEncryptionBox) sampleEntryEncryptionData.second).schemeType);
                stsdData.trackEncryptionBoxes[i13] = (TrackEncryptionBox) sampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        String str4 = MimeTypes.AUDIO_MPEGH_MHM1;
        if (iIntValue == 1633889587) {
            str2 = MimeTypes.AUDIO_AC3;
        } else if (iIntValue == 1700998451) {
            str2 = MimeTypes.AUDIO_E_AC3;
        } else if (iIntValue == 1633889588) {
            str2 = MimeTypes.AUDIO_AC4;
        } else if (iIntValue == 1685353315) {
            str2 = MimeTypes.AUDIO_DTS;
        } else if (iIntValue == 1685353320 || iIntValue == 1685353324) {
            str2 = MimeTypes.AUDIO_DTS_HD;
        } else if (iIntValue == 1685353317) {
            str2 = MimeTypes.AUDIO_DTS_EXPRESS;
        } else if (iIntValue == 1685353336) {
            str2 = MimeTypes.AUDIO_DTS_X;
        } else if (iIntValue == 1935764850) {
            str2 = MimeTypes.AUDIO_AMR_NB;
        } else {
            if (iIntValue != 1935767394) {
                if (iIntValue == 1936684916) {
                    str2 = MimeTypes.AUDIO_RAW;
                    i16 = 2;
                } else if (iIntValue == 1953984371) {
                    str2 = MimeTypes.AUDIO_RAW;
                    i16 = 268435456;
                } else if (iIntValue == 1819304813) {
                    if (i15 == -1) {
                        str2 = MimeTypes.AUDIO_RAW;
                        i16 = 2;
                    } else {
                        str2 = MimeTypes.AUDIO_RAW;
                    }
                } else if (iIntValue == 778924082 || iIntValue == 778924083) {
                    str2 = MimeTypes.AUDIO_MPEG;
                } else if (iIntValue == 1835557169) {
                    str2 = MimeTypes.AUDIO_MPEGH_MHA1;
                } else if (iIntValue == 1835560241) {
                    i16 = i15;
                    str2 = MimeTypes.AUDIO_MPEGH_MHM1;
                } else if (iIntValue == 1634492771) {
                    str2 = MimeTypes.AUDIO_ALAC;
                } else if (iIntValue == 1634492791) {
                    str2 = MimeTypes.AUDIO_ALAW;
                } else if (iIntValue == 1970037111) {
                    str2 = MimeTypes.AUDIO_MLAW;
                } else if (iIntValue == 1332770163) {
                    str2 = MimeTypes.AUDIO_OPUS;
                } else if (iIntValue == 1716281667) {
                    str2 = MimeTypes.AUDIO_FLAC;
                } else if (iIntValue == 1835823201) {
                    str2 = MimeTypes.AUDIO_TRUEHD;
                } else if (iIntValue == 1767992678) {
                    str2 = MimeTypes.AUDIO_IAMF;
                } else {
                    i16 = i15;
                    str2 = null;
                }
                int i23 = i16;
                str3 = null;
                listM5275r = null;
                esdsFromParent = null;
                BtrtData btrtFromParent = null;
                while (position - i20 < i21) {
                    parsableByteArray.setPosition(position);
                    i17 = parsableByteArray.readInt();
                    if (i17 > 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    ExtractorUtil.checkContainerInput(z10, "childAtomSize must be positive");
                    i18 = parsableByteArray.readInt();
                    if (i18 == 1835557187) {
                        parsableByteArray.setPosition(position + 8);
                        parsableByteArray.skipBytes(1);
                        unsignedByte2 = parsableByteArray.readUnsignedByte();
                        parsableByteArray.skipBytes(1);
                        if (Objects.equals(str2, str4)) {
                            i19 = 0;
                            str3 = String.format("mhm1.%02X", Integer.valueOf(unsignedByte2));
                        } else {
                            i19 = 0;
                            str3 = String.format("mha1.%02X", Integer.valueOf(unsignedByte2));
                        }
                        int unsignedShort3 = parsableByteArray.readUnsignedShort();
                        bArr3 = new byte[unsignedShort3];
                        parsableByteArray.readBytes(bArr3, i19, unsignedShort3);
                        if (listM5275r == null) {
                            listM5275r = AbstractC2301u1.m5275r(bArr3);
                        } else {
                            listM5275r = AbstractC2301u1.m5276s(bArr3, listM5275r.get(i19));
                        }
                    } else {
                        str4 = str4;
                        if (i18 == 1835557200) {
                            parsableByteArray.setPosition(position + 8);
                            unsignedByte = parsableByteArray.readUnsignedByte();
                            if (unsignedByte > 0) {
                                bArr2 = new byte[unsignedByte];
                                parsableByteArray.readBytes(bArr2, 0, unsignedByte);
                                if (listM5275r == null) {
                                    listM5275r = AbstractC2301u1.m5275r(bArr2);
                                } else {
                                    listM5275r = AbstractC2301u1.m5276s(listM5275r.get(0), bArr2);
                                }
                            }
                        } else {
                            if (i18 != 1702061171 || (z7 && i18 == 2002876005)) {
                                if (i18 == 1702061171) {
                                    iFindBoxPosition = position;
                                } else {
                                    iFindBoxPosition = findBoxPosition(parsableByteArray, Mp4Box.TYPE_esds, position, i17);
                                }
                                if (iFindBoxPosition != -1) {
                                    esdsFromParent = parseEsdsFromParent(parsableByteArray, iFindBoxPosition);
                                    str2 = esdsFromParent.mimeType;
                                    bArr = esdsFromParent.initializationData;
                                    if (bArr != null) {
                                        if (MimeTypes.AUDIO_VORBIS.equals(str2)) {
                                            listM5275r = VorbisUtil.parseVorbisCsdFromEsdsInitializationData(bArr);
                                        } else {
                                            if (MimeTypes.AUDIO_AAC.equals(str2)) {
                                                AacUtil.Config audioSpecificConfig = AacUtil.parseAudioSpecificConfig(bArr);
                                                unsignedFixedPoint1616 = audioSpecificConfig.sampleRateHz;
                                                unsignedShort2 = audioSpecificConfig.channelCount;
                                                str3 = audioSpecificConfig.codecs;
                                            }
                                            listM5275r = AbstractC2301u1.m5275r(bArr);
                                        }
                                    }
                                }
                            } else if (i18 == 1651798644) {
                                btrtFromParent = parseBtrtFromParent(parsableByteArray, position);
                            } else if (i18 == 1684103987) {
                                parsableByteArray.setPosition(position + 8);
                                stsdData.format = Ac3Util.parseAc3AnnexFFormat(parsableByteArray, Integer.toString(i12), str, drmInitDataCopyWithSchemeType);
                            } else if (i18 == 1684366131) {
                                parsableByteArray.setPosition(position + 8);
                                stsdData.format = Ac3Util.parseEAc3AnnexFFormat(parsableByteArray, Integer.toString(i12), str, drmInitDataCopyWithSchemeType);
                            } else if (i18 == 1684103988) {
                                parsableByteArray.setPosition(position + 8);
                                stsdData.format = Ac4Util.parseAc4AnnexEFormat(parsableByteArray, Integer.toString(i12), str, drmInitDataCopyWithSchemeType);
                            } else if (i18 == 1684892784) {
                                if (i14 <= 0) {
                                    throw ParserException.createForMalformedContainer("Invalid sample rate for Dolby TrueHD MLP stream: " + i14, null);
                                }
                                unsignedFixedPoint1616 = i14;
                                unsignedShort2 = 2;
                            } else if (i18 == 1684305011 || i18 == 1969517683) {
                                stsdData.format = new Format.Builder().setId(i12).setSampleMimeType(str2).setChannelCount(unsignedShort2).setSampleRate(unsignedFixedPoint1616).setDrmInitData(drmInitDataCopyWithSchemeType).setLanguage(str).build();
                            } else if (i18 == 1682927731) {
                                int i24 = i17 - 8;
                                byte[] bArr4 = opusMagic;
                                byte[] bArrCopyOf = Arrays.copyOf(bArr4, bArr4.length + i24);
                                parsableByteArray.setPosition(position + 8);
                                parsableByteArray.readBytes(bArrCopyOf, bArr4.length, i24);
                                listM5275r = OpusUtil.buildInitializationData(bArrCopyOf);
                            } else if (i18 == 1684425825) {
                                byte[] bArr5 = new byte[i17 - 8];
                                bArr5[0] = 102;
                                bArr5[1] = 76;
                                bArr5[2] = 97;
                                bArr5[3] = 67;
                                parsableByteArray.setPosition(position + 12);
                                parsableByteArray.readBytes(bArr5, 4, i17 - 12);
                                listM5275r = AbstractC2301u1.m5275r(bArr5);
                            } else if (i18 == 1634492771) {
                                int i25 = i17 - 12;
                                byte[] bArr6 = new byte[i25];
                                parsableByteArray.setPosition(position + 12);
                                parsableByteArray.readBytes(bArr6, 0, i25);
                                Pair<Integer, Integer> alacAudioSpecificConfig = CodecSpecificDataUtil.parseAlacAudioSpecificConfig(bArr6);
                                unsignedFixedPoint1616 = ((Integer) alacAudioSpecificConfig.first).intValue();
                                int iIntValue2 = ((Integer) alacAudioSpecificConfig.second).intValue();
                                listM5275r = AbstractC2301u1.m5275r(bArr6);
                                unsignedShort2 = iIntValue2;
                            } else if (i18 == 1767990114) {
                                parsableByteArray.setPosition(position + 9);
                                int unsignedLeb128ToInt = parsableByteArray.readUnsignedLeb128ToInt();
                                byte[] bArr7 = new byte[unsignedLeb128ToInt];
                                parsableByteArray.readBytes(bArr7, 0, unsignedLeb128ToInt);
                                listM5275r = AbstractC2301u1.m5275r(bArr7);
                            }
                            position += i17;
                            i20 = i10;
                            i21 = i11;
                            str4 = str4;
                        }
                    }
                    position += i17;
                    i20 = i10;
                    i21 = i11;
                    str4 = str4;
                }
                if (stsdData.format == null || str2 == null) {
                }
                Format.Builder language = new Format.Builder().setId(i12).setSampleMimeType(str2).setCodecs(str3).setChannelCount(unsignedShort2).setSampleRate(unsignedFixedPoint1616).setPcmEncoding(i23).setInitializationData(listM5275r).setDrmInitData(drmInitDataCopyWithSchemeType).setLanguage(str);
                if (esdsFromParent != null) {
                    language.setAverageBitrate(AbstractC3612b.m7255K(esdsFromParent.bitrate)).setPeakBitrate(AbstractC3612b.m7255K(esdsFromParent.peakBitrate));
                } else if (btrtFromParent != null) {
                    language.setAverageBitrate(AbstractC3612b.m7255K(btrtFromParent.avgBitrate)).setPeakBitrate(AbstractC3612b.m7255K(btrtFromParent.maxBitrate));
                }
                stsdData.format = language.build();
                return;
            }
            str2 = MimeTypes.AUDIO_AMR_WB;
        }
        i16 = i15;
        int i26 = i16;
        str3 = null;
        listM5275r = null;
        esdsFromParent = null;
        BtrtData btrtFromParent2 = null;
        while (position - i20 < i21) {
            parsableByteArray.setPosition(position);
            i17 = parsableByteArray.readInt();
            if (i17 > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            ExtractorUtil.checkContainerInput(z10, "childAtomSize must be positive");
            i18 = parsableByteArray.readInt();
            if (i18 == 1835557187) {
                parsableByteArray.setPosition(position + 8);
                parsableByteArray.skipBytes(1);
                unsignedByte2 = parsableByteArray.readUnsignedByte();
                parsableByteArray.skipBytes(1);
                if (Objects.equals(str2, str4)) {
                    i19 = 0;
                    str3 = String.format("mhm1.%02X", Integer.valueOf(unsignedByte2));
                } else {
                    i19 = 0;
                    str3 = String.format("mha1.%02X", Integer.valueOf(unsignedByte2));
                }
                int unsignedShort4 = parsableByteArray.readUnsignedShort();
                bArr3 = new byte[unsignedShort4];
                parsableByteArray.readBytes(bArr3, i19, unsignedShort4);
                if (listM5275r == null) {
                    listM5275r = AbstractC2301u1.m5275r(bArr3);
                } else {
                    listM5275r = AbstractC2301u1.m5276s(bArr3, listM5275r.get(i19));
                }
            } else {
                str4 = str4;
                if (i18 == 1835557200) {
                    parsableByteArray.setPosition(position + 8);
                    unsignedByte = parsableByteArray.readUnsignedByte();
                    if (unsignedByte > 0) {
                        bArr2 = new byte[unsignedByte];
                        parsableByteArray.readBytes(bArr2, 0, unsignedByte);
                        if (listM5275r == null) {
                            listM5275r = AbstractC2301u1.m5275r(bArr2);
                        } else {
                            listM5275r = AbstractC2301u1.m5276s(listM5275r.get(0), bArr2);
                        }
                    }
                } else {
                    if (i18 != 1702061171) {
                        if (i18 == 1702061171) {
                            iFindBoxPosition = position;
                        } else {
                            iFindBoxPosition = findBoxPosition(parsableByteArray, Mp4Box.TYPE_esds, position, i17);
                        }
                        if (iFindBoxPosition != -1) {
                            esdsFromParent = parseEsdsFromParent(parsableByteArray, iFindBoxPosition);
                            str2 = esdsFromParent.mimeType;
                            bArr = esdsFromParent.initializationData;
                            if (bArr != null) {
                                if (MimeTypes.AUDIO_VORBIS.equals(str2)) {
                                    listM5275r = VorbisUtil.parseVorbisCsdFromEsdsInitializationData(bArr);
                                } else {
                                    if (MimeTypes.AUDIO_AAC.equals(str2)) {
                                        AacUtil.Config audioSpecificConfig2 = AacUtil.parseAudioSpecificConfig(bArr);
                                        unsignedFixedPoint1616 = audioSpecificConfig2.sampleRateHz;
                                        unsignedShort2 = audioSpecificConfig2.channelCount;
                                        str3 = audioSpecificConfig2.codecs;
                                    }
                                    listM5275r = AbstractC2301u1.m5275r(bArr);
                                }
                            }
                        }
                    } else {
                        if (i18 == 1702061171) {
                            iFindBoxPosition = position;
                        } else {
                            iFindBoxPosition = findBoxPosition(parsableByteArray, Mp4Box.TYPE_esds, position, i17);
                        }
                        if (iFindBoxPosition != -1) {
                            esdsFromParent = parseEsdsFromParent(parsableByteArray, iFindBoxPosition);
                            str2 = esdsFromParent.mimeType;
                            bArr = esdsFromParent.initializationData;
                            if (bArr != null) {
                                if (MimeTypes.AUDIO_VORBIS.equals(str2)) {
                                    listM5275r = VorbisUtil.parseVorbisCsdFromEsdsInitializationData(bArr);
                                } else {
                                    if (MimeTypes.AUDIO_AAC.equals(str2)) {
                                        AacUtil.Config audioSpecificConfig3 = AacUtil.parseAudioSpecificConfig(bArr);
                                        unsignedFixedPoint1616 = audioSpecificConfig3.sampleRateHz;
                                        unsignedShort2 = audioSpecificConfig3.channelCount;
                                        str3 = audioSpecificConfig3.codecs;
                                    }
                                    listM5275r = AbstractC2301u1.m5275r(bArr);
                                }
                            }
                        }
                    }
                    position += i17;
                    i20 = i10;
                    i21 = i11;
                    str4 = str4;
                }
            }
            position += i17;
            i20 = i10;
            i21 = i11;
            str4 = str4;
        }
        if (stsdData.format == null) {
        }
    }

    private static ColorInfo parseAv1c(ParsableByteArray parsableByteArray) {
        ColorInfo.Builder builder = new ColorInfo.Builder();
        ParsableBitArray parsableBitArray = new ParsableBitArray(parsableByteArray.getData());
        parsableBitArray.setPosition(parsableByteArray.getPosition() * 8);
        parsableBitArray.skipBytes(1);
        int bits = parsableBitArray.readBits(3);
        parsableBitArray.skipBits(6);
        boolean bit = parsableBitArray.readBit();
        boolean bit2 = parsableBitArray.readBit();
        if (bits == 2 && bit) {
            builder.setLumaBitdepth(bit2 ? 12 : 10);
            builder.setChromaBitdepth(bit2 ? 12 : 10);
        } else if (bits <= 2) {
            builder.setLumaBitdepth(bit ? 10 : 8);
            builder.setChromaBitdepth(bit ? 10 : 8);
        }
        parsableBitArray.skipBits(13);
        parsableBitArray.skipBit();
        int bits2 = parsableBitArray.readBits(4);
        if (bits2 != 1) {
            Log.m1717i(TAG, "Unsupported obu_type: " + bits2);
            return builder.build();
        }
        if (parsableBitArray.readBit()) {
            Log.m1717i(TAG, "Unsupported obu_extension_flag");
            return builder.build();
        }
        boolean bit3 = parsableBitArray.readBit();
        parsableBitArray.skipBit();
        if (bit3 && parsableBitArray.readBits(8) > 127) {
            Log.m1717i(TAG, "Excessive obu_size");
            return builder.build();
        }
        int bits3 = parsableBitArray.readBits(3);
        parsableBitArray.skipBit();
        if (parsableBitArray.readBit()) {
            Log.m1717i(TAG, "Unsupported reduced_still_picture_header");
            return builder.build();
        }
        if (parsableBitArray.readBit()) {
            Log.m1717i(TAG, "Unsupported timing_info_present_flag");
            return builder.build();
        }
        if (parsableBitArray.readBit()) {
            Log.m1717i(TAG, "Unsupported initial_display_delay_present_flag");
            return builder.build();
        }
        int bits4 = parsableBitArray.readBits(5);
        boolean z7 = false;
        for (int i6 = 0; i6 <= bits4; i6++) {
            parsableBitArray.skipBits(12);
            if (parsableBitArray.readBits(5) > 7) {
                parsableBitArray.skipBit();
            }
        }
        int bits5 = parsableBitArray.readBits(4);
        int bits6 = parsableBitArray.readBits(4);
        parsableBitArray.skipBits(bits5 + 1);
        parsableBitArray.skipBits(bits6 + 1);
        if (parsableBitArray.readBit()) {
            parsableBitArray.skipBits(7);
        }
        parsableBitArray.skipBits(7);
        boolean bit4 = parsableBitArray.readBit();
        if (bit4) {
            parsableBitArray.skipBits(2);
        }
        if ((parsableBitArray.readBit() ? 2 : parsableBitArray.readBits(1)) > 0 && !parsableBitArray.readBit()) {
            parsableBitArray.skipBits(1);
        }
        if (bit4) {
            parsableBitArray.skipBits(3);
        }
        parsableBitArray.skipBits(3);
        boolean bit5 = parsableBitArray.readBit();
        if (bits3 == 2 && bit5) {
            parsableBitArray.skipBit();
        }
        if (bits3 != 1 && parsableBitArray.readBit()) {
            z7 = true;
        }
        if (parsableBitArray.readBit()) {
            int bits7 = parsableBitArray.readBits(8);
            int bits8 = parsableBitArray.readBits(8);
            builder.setColorSpace(ColorInfo.isoColorPrimariesToColorSpace(bits7)).setColorRange(((z7 || bits7 != 1 || bits8 != 13 || parsableBitArray.readBits(8) != 0) ? parsableBitArray.readBits(1) : 1) != 1 ? 2 : 1).setColorTransfer(ColorInfo.isoTransferCharacteristicsToColorTransfer(bits8));
        }
        return builder.build();
    }

    private static BtrtData parseBtrtFromParent(ParsableByteArray parsableByteArray, int i6) {
        parsableByteArray.setPosition(i6 + 8);
        parsableByteArray.skipBytes(4);
        return new BtrtData(parsableByteArray.readUnsignedInt(), parsableByteArray.readUnsignedInt());
    }

    public static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray parsableByteArray, int i6, int i10) throws ParserException {
        int i11 = i6 + 8;
        String string = null;
        Integer numValueOf = null;
        int i12 = -1;
        int i13 = 0;
        while (i11 - i6 < i10) {
            parsableByteArray.setPosition(i11);
            int i14 = parsableByteArray.readInt();
            int i15 = parsableByteArray.readInt();
            if (i15 == 1718775137) {
                numValueOf = Integer.valueOf(parsableByteArray.readInt());
            } else if (i15 == 1935894637) {
                parsableByteArray.skipBytes(4);
                string = parsableByteArray.readString(4);
            } else if (i15 == 1935894633) {
                i12 = i11;
                i13 = i14;
            }
            i11 += i14;
        }
        if (!C0565C.CENC_TYPE_cenc.equals(string) && !C0565C.CENC_TYPE_cbc1.equals(string) && !C0565C.CENC_TYPE_cens.equals(string) && !C0565C.CENC_TYPE_cbcs.equals(string)) {
            return null;
        }
        ExtractorUtil.checkContainerInput(numValueOf != null, "frma atom is mandatory");
        ExtractorUtil.checkContainerInput(i12 != -1, "schi atom is mandatory");
        TrackEncryptionBox schiFromParent = parseSchiFromParent(parsableByteArray, i12, i13, string);
        ExtractorUtil.checkContainerInput(schiFromParent != null, "tenc atom is mandatory");
        return Pair.create(numValueOf, (TrackEncryptionBox) Util.castNonNull(schiFromParent));
    }

    private static Pair<long[], long[]> parseEdts(Mp4Box.ContainerBox containerBox) {
        Mp4Box.LeafBox leafBoxOfType = containerBox.getLeafBoxOfType(Mp4Box.TYPE_elst);
        if (leafBoxOfType == null) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafBoxOfType.data;
        parsableByteArray.setPosition(8);
        int fullBoxVersion = parseFullBoxVersion(parsableByteArray.readInt());
        int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[unsignedIntToInt];
        long[] jArr2 = new long[unsignedIntToInt];
        for (int i6 = 0; i6 < unsignedIntToInt; i6++) {
            jArr[i6] = fullBoxVersion == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
            jArr2[i6] = fullBoxVersion == 1 ? parsableByteArray.readLong() : parsableByteArray.readInt();
            if (parsableByteArray.readShort() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            parsableByteArray.skipBytes(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static EsdsData parseEsdsFromParent(ParsableByteArray parsableByteArray, int i6) {
        parsableByteArray.setPosition(i6 + 12);
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int unsignedByte = parsableByteArray.readUnsignedByte();
        if ((unsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((unsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedByte());
        }
        if ((unsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        String mimeTypeFromMp4ObjectType = MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray.readUnsignedByte());
        if (MimeTypes.AUDIO_MPEG.equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS.equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS_HD.equals(mimeTypeFromMp4ObjectType)) {
            return new EsdsData(mimeTypeFromMp4ObjectType, null, -1L, -1L);
        }
        parsableByteArray.skipBytes(4);
        long unsignedInt = parsableByteArray.readUnsignedInt();
        long unsignedInt2 = parsableByteArray.readUnsignedInt();
        parsableByteArray.skipBytes(1);
        int expandableClassSize = parseExpandableClassSize(parsableByteArray);
        byte[] bArr = new byte[expandableClassSize];
        parsableByteArray.readBytes(bArr, 0, expandableClassSize);
        return new EsdsData(mimeTypeFromMp4ObjectType, bArr, unsignedInt2 > 0 ? unsignedInt2 : -1L, unsignedInt > 0 ? unsignedInt : -1L);
    }

    private static int parseExpandableClassSize(ParsableByteArray parsableByteArray) {
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int i6 = unsignedByte & 127;
        while ((unsignedByte & 128) == 128) {
            unsignedByte = parsableByteArray.readUnsignedByte();
            i6 = (i6 << 7) | (unsignedByte & 127);
        }
        return i6;
    }

    public static int parseFullBoxFlags(int i6) {
        return i6 & 16777215;
    }

    public static int parseFullBoxVersion(int i6) {
        return (i6 >> 24) & 255;
    }

    private static int parseHdlr(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(16);
        return parsableByteArray.readInt();
    }

    private static Metadata parseIlst(ParsableByteArray parsableByteArray, int i6) {
        parsableByteArray.skipBytes(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.getPosition() < i6) {
            Metadata.Entry ilstElement = MetadataUtil.parseIlstElement(parsableByteArray);
            if (ilstElement != null) {
                arrayList.add(ilstElement);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static MdhdData parseMdhd(ParsableByteArray parsableByteArray) {
        long jScaleLargeTimestamp;
        parsableByteArray.setPosition(8);
        int fullBoxVersion = parseFullBoxVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(fullBoxVersion == 0 ? 8 : 16);
        long unsignedInt = parsableByteArray.readUnsignedInt();
        int position = parsableByteArray.getPosition();
        int i6 = fullBoxVersion == 0 ? 4 : 8;
        int i10 = 0;
        while (true) {
            if (i10 >= i6) {
                parsableByteArray.skipBytes(i6);
                break;
            }
            if (parsableByteArray.getData()[position + i10] != -1) {
                long unsignedInt2 = fullBoxVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
                if (unsignedInt2 == 0) {
                    break;
                }
                jScaleLargeTimestamp = Util.scaleLargeTimestamp(unsignedInt2, 1000000L, unsignedInt);
                return new MdhdData(unsignedInt, jScaleLargeTimestamp, getLanguageFromCode(parsableByteArray.readUnsignedShort()));
            }
            i10++;
        }
        jScaleLargeTimestamp = -9223372036854775807L;
        return new MdhdData(unsignedInt, jScaleLargeTimestamp, getLanguageFromCode(parsableByteArray.readUnsignedShort()));
    }

    public static Metadata parseMdtaFromMeta(Mp4Box.ContainerBox containerBox) {
        Mp4Box.LeafBox leafBoxOfType = containerBox.getLeafBoxOfType(Mp4Box.TYPE_hdlr);
        Mp4Box.LeafBox leafBoxOfType2 = containerBox.getLeafBoxOfType(Mp4Box.TYPE_keys);
        Mp4Box.LeafBox leafBoxOfType3 = containerBox.getLeafBoxOfType(Mp4Box.TYPE_ilst);
        if (leafBoxOfType == null || leafBoxOfType2 == null || leafBoxOfType3 == null || parseHdlr(leafBoxOfType.data) != TYPE_mdta) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafBoxOfType2.data;
        parsableByteArray.setPosition(12);
        int i6 = parsableByteArray.readInt();
        String[] strArr = new String[i6];
        for (int i10 = 0; i10 < i6; i10++) {
            int i11 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            strArr[i10] = parsableByteArray.readString(i11 - 8);
        }
        ParsableByteArray parsableByteArray2 = leafBoxOfType3.data;
        parsableByteArray2.setPosition(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray2.bytesLeft() > 8) {
            int position = parsableByteArray2.getPosition();
            int i12 = parsableByteArray2.readInt();
            int i13 = parsableByteArray2.readInt() - 1;
            if (i13 < 0 || i13 >= i6) {
                AbstractC0004e.m31y(i13, "Skipped metadata with unknown key index: ", TAG);
            } else {
                MdtaMetadataEntry mdtaMetadataEntryFromIlst = MetadataUtil.parseMdtaMetadataEntryFromIlst(parsableByteArray2, position + i12, strArr[i13]);
                if (mdtaMetadataEntryFromIlst != null) {
                    arrayList.add(mdtaMetadataEntryFromIlst);
                }
            }
            parsableByteArray2.setPosition(position + i12);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static void parseMetaDataSampleEntry(ParsableByteArray parsableByteArray, int i6, int i10, int i11, StsdData stsdData) {
        parsableByteArray.setPosition(i10 + 16);
        if (i6 == 1835365492) {
            parsableByteArray.readNullTerminatedString();
            String nullTerminatedString = parsableByteArray.readNullTerminatedString();
            if (nullTerminatedString != null) {
                stsdData.format = new Format.Builder().setId(i11).setSampleMimeType(nullTerminatedString).build();
            }
        }
    }

    public static Mp4TimestampData parseMvhd(ParsableByteArray parsableByteArray) {
        long unsignedInt;
        long unsignedInt2;
        parsableByteArray.setPosition(8);
        if (parseFullBoxVersion(parsableByteArray.readInt()) == 0) {
            unsignedInt = parsableByteArray.readUnsignedInt();
            unsignedInt2 = parsableByteArray.readUnsignedInt();
        } else {
            unsignedInt = parsableByteArray.readLong();
            unsignedInt2 = parsableByteArray.readLong();
        }
        return new Mp4TimestampData(unsignedInt, unsignedInt2, parsableByteArray.readUnsignedInt());
    }

    private static float parsePaspFromParent(ParsableByteArray parsableByteArray, int i6) {
        parsableByteArray.setPosition(i6 + 8);
        return parsableByteArray.readUnsignedIntToInt() / parsableByteArray.readUnsignedIntToInt();
    }

    private static byte[] parseProjFromParent(ParsableByteArray parsableByteArray, int i6, int i10) {
        int i11 = i6 + 8;
        while (i11 - i6 < i10) {
            parsableByteArray.setPosition(i11);
            int i12 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1886547818) {
                return Arrays.copyOfRange(parsableByteArray.getData(), i11, i12 + i11);
            }
            i11 += i12;
        }
        return null;
    }

    private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i6, int i10) throws ParserException {
        Pair<Integer, TrackEncryptionBox> commonEncryptionSinfFromParent;
        int position = parsableByteArray.getPosition();
        while (position - i6 < i10) {
            parsableByteArray.setPosition(position);
            int i11 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i11 > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == 1936289382 && (commonEncryptionSinfFromParent = parseCommonEncryptionSinfFromParent(parsableByteArray, position, i11)) != null) {
                return commonEncryptionSinfFromParent;
            }
            position += i11;
        }
        return null;
    }

    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsableByteArray, int i6, int i10, String str) {
        int i11;
        int i12;
        int i13 = i6 + 8;
        while (true) {
            byte[] bArr = null;
            if (i13 - i6 >= i10) {
                return null;
            }
            parsableByteArray.setPosition(i13);
            int i14 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1952804451) {
                int fullBoxVersion = parseFullBoxVersion(parsableByteArray.readInt());
                parsableByteArray.skipBytes(1);
                if (fullBoxVersion == 0) {
                    parsableByteArray.skipBytes(1);
                    i12 = 0;
                    i11 = 0;
                } else {
                    int unsignedByte = parsableByteArray.readUnsignedByte();
                    i11 = unsignedByte & 15;
                    i12 = (unsignedByte & PsExtractor.VIDEO_STREAM_MASK) >> 4;
                }
                boolean z7 = parsableByteArray.readUnsignedByte() == 1;
                int unsignedByte2 = parsableByteArray.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                parsableByteArray.readBytes(bArr2, 0, 16);
                if (z7 && unsignedByte2 == 0) {
                    int unsignedByte3 = parsableByteArray.readUnsignedByte();
                    bArr = new byte[unsignedByte3];
                    parsableByteArray.readBytes(bArr, 0, unsignedByte3);
                }
                return new TrackEncryptionBox(z7, str, unsignedByte2, bArr2, i12, i11, bArr);
            }
            i13 += i14;
        }
    }

    public static TrackSampleTable parseStbl(Track track, Mp4Box.ContainerBox containerBox, GaplessInfoHolder gaplessInfoHolder) throws ParserException {
        SampleSizeBox stz2SampleSizeBox;
        boolean z7;
        int unsignedIntToInt;
        int unsignedIntToInt2;
        int unsignedIntToInt3;
        int fixedSampleSize;
        boolean z10;
        long[] jArr;
        int[] iArr;
        long[] jArr2;
        int[] iArr2;
        int i6;
        int unsignedIntToInt4;
        int i10;
        int i11;
        int i12;
        int i13;
        int unsignedIntToInt5;
        long j10;
        long j11;
        long j12;
        int i14;
        int i15;
        long[] jArr3;
        int[] iArr3;
        long[] jArrCopyOf;
        int[] iArrCopyOf;
        int i16;
        boolean z11;
        int i17;
        Track trackCopyWithFormat;
        String str;
        int[] iArr4;
        long[] jArr4;
        long j13;
        long j14;
        long j15;
        int i18;
        boolean zMoveNext;
        int i19;
        int i20;
        int nextSampleSize;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        long j16;
        int[] iArr5;
        long jScaleLargeTimestamp;
        long[] jArr5;
        long[] jArr6;
        boolean z12;
        int[] iArr6;
        int[] iArr7;
        long[] jArr7;
        int i26;
        boolean z13;
        int i27;
        int i28;
        long[] jArr8;
        int[] iArr8;
        int i29;
        int i30;
        int[] iArr9;
        boolean z14;
        boolean z15;
        long[] jArr9;
        int[] iArr10;
        int i31;
        int[] iArr11;
        long[] jArr10;
        int i32;
        int i33;
        int i34;
        long j17;
        boolean z16;
        long j18;
        int i35;
        int i36;
        long jScaleLargeTimestamp2;
        long j19;
        int[] iArr12;
        boolean z17;
        int i37;
        int i38;
        int i39;
        int i40;
        boolean z18;
        int i41;
        int i42;
        long j20;
        long jScaleLargeTimestamp3;
        long jScaleLargeTimestamp4;
        long jScaleLargeTimestamp5;
        long jScaleLargeValue;
        long[] jArr11;
        int[] iArr13;
        Track trackCopyWithFormat2 = track;
        Mp4Box.LeafBox leafBoxOfType = containerBox.getLeafBoxOfType(Mp4Box.TYPE_stsz);
        if (leafBoxOfType != null) {
            stz2SampleSizeBox = new StszSampleSizeBox(leafBoxOfType, trackCopyWithFormat2.format);
        } else {
            Mp4Box.LeafBox leafBoxOfType2 = containerBox.getLeafBoxOfType(Mp4Box.TYPE_stz2);
            if (leafBoxOfType2 == null) {
                throw ParserException.createForMalformedContainer("Track has no sample table size information", null);
            }
            stz2SampleSizeBox = new Stz2SampleSizeBox(leafBoxOfType2);
        }
        int sampleCount = stz2SampleSizeBox.getSampleCount();
        if (sampleCount == 0) {
            return new TrackSampleTable(track, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        if (trackCopyWithFormat2.type == 2) {
            long j21 = trackCopyWithFormat2.mediaDurationUs;
            if (j21 > 0) {
                trackCopyWithFormat2 = trackCopyWithFormat2.copyWithFormat(trackCopyWithFormat2.format.buildUpon().setFrameRate(sampleCount / (j21 / 1000000.0f)).build());
            }
        }
        Mp4Box.LeafBox leafBoxOfType3 = containerBox.getLeafBoxOfType(Mp4Box.TYPE_stco);
        if (leafBoxOfType3 == null) {
            leafBoxOfType3 = (Mp4Box.LeafBox) Assertions.checkNotNull(containerBox.getLeafBoxOfType(Mp4Box.TYPE_co64));
            z7 = true;
        } else {
            z7 = false;
        }
        ParsableByteArray parsableByteArray = leafBoxOfType3.data;
        ParsableByteArray parsableByteArray2 = ((Mp4Box.LeafBox) Assertions.checkNotNull(containerBox.getLeafBoxOfType(Mp4Box.TYPE_stsc))).data;
        ParsableByteArray parsableByteArray3 = ((Mp4Box.LeafBox) Assertions.checkNotNull(containerBox.getLeafBoxOfType(Mp4Box.TYPE_stts))).data;
        Mp4Box.LeafBox leafBoxOfType4 = containerBox.getLeafBoxOfType(Mp4Box.TYPE_stss);
        ParsableByteArray parsableByteArray4 = leafBoxOfType4 != null ? leafBoxOfType4.data : null;
        Mp4Box.LeafBox leafBoxOfType5 = containerBox.getLeafBoxOfType(Mp4Box.TYPE_ctts);
        ParsableByteArray parsableByteArray5 = leafBoxOfType5 != null ? leafBoxOfType5.data : null;
        ChunkIterator chunkIterator = new ChunkIterator(parsableByteArray2, parsableByteArray, z7);
        parsableByteArray3.setPosition(12);
        int unsignedIntToInt6 = parsableByteArray3.readUnsignedIntToInt() - 1;
        int unsignedIntToInt7 = parsableByteArray3.readUnsignedIntToInt();
        int unsignedIntToInt8 = parsableByteArray3.readUnsignedIntToInt();
        if (parsableByteArray5 != null) {
            parsableByteArray5.setPosition(12);
            unsignedIntToInt = parsableByteArray5.readUnsignedIntToInt();
        } else {
            unsignedIntToInt = 0;
        }
        if (parsableByteArray4 != null) {
            parsableByteArray4.setPosition(12);
            unsignedIntToInt2 = parsableByteArray4.readUnsignedIntToInt();
            if (unsignedIntToInt2 > 0) {
                unsignedIntToInt3 = parsableByteArray4.readUnsignedIntToInt() - 1;
            } else {
                parsableByteArray4 = null;
            }
            fixedSampleSize = stz2SampleSizeBox.getFixedSampleSize();
            String str2 = trackCopyWithFormat2.format.sampleMimeType;
            if (fixedSampleSize == -1 && ((MimeTypes.AUDIO_RAW.equals(str2) || MimeTypes.AUDIO_MLAW.equals(str2) || MimeTypes.AUDIO_ALAW.equals(str2)) && unsignedIntToInt6 == 0 && unsignedIntToInt == 0 && unsignedIntToInt2 == 0)) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                int i43 = chunkIterator.length;
                jArr11 = new long[i43];
                iArr13 = new int[i43];
                while (chunkIterator.moveNext()) {
                    int i44 = chunkIterator.index;
                    jArr11[i44] = chunkIterator.offset;
                    iArr13[i44] = chunkIterator.numSamples;
                }
                FixedSampleSizeRechunker.Results resultsRechunk = FixedSampleSizeRechunker.rechunk(fixedSampleSize, jArr11, iArr13, unsignedIntToInt8);
                jArr3 = resultsRechunk.offsets;
                int[] iArr14 = resultsRechunk.sizes;
                int i45 = resultsRechunk.maximumSize;
                long[] jArr12 = resultsRechunk.timestamps;
                iArrCopyOf = resultsRechunk.flags;
                long j22 = resultsRechunk.duration;
                j14 = resultsRechunk.totalSize;
                trackCopyWithFormat = trackCopyWithFormat2;
                iArr4 = iArr14;
                i11 = i45;
                jArr4 = jArr12;
                j13 = j22;
            } else {
                jArr = new long[sampleCount];
                iArr = new int[sampleCount];
                jArr2 = new long[sampleCount];
                iArr2 = new int[sampleCount];
                i6 = unsignedIntToInt6;
                unsignedIntToInt4 = unsignedIntToInt3;
                i10 = unsignedIntToInt;
                i11 = 0;
                i12 = 0;
                i13 = 0;
                unsignedIntToInt5 = 0;
                j10 = 0;
                j11 = 0;
                j12 = 0;
                Track track2 = trackCopyWithFormat2;
                i14 = 0;
                while (true) {
                    if (i14 < sampleCount) {
                        i15 = unsignedIntToInt2;
                        jArr3 = jArr;
                        iArr3 = iArr;
                        jArrCopyOf = jArr2;
                        iArrCopyOf = iArr2;
                        i16 = i12;
                        break;
                    }
                    j15 = j12;
                    i18 = i12;
                    zMoveNext = true;
                    while (i18 == 0) {
                        zMoveNext = chunkIterator.moveNext();
                        if (zMoveNext) {
                            break;
                        }
                        int i46 = unsignedIntToInt8;
                        long j23 = chunkIterator.offset;
                        i18 = chunkIterator.numSamples;
                        j15 = j23;
                        unsignedIntToInt8 = i46;
                        unsignedIntToInt2 = unsignedIntToInt2;
                        sampleCount = sampleCount;
                    }
                    i19 = sampleCount;
                    i20 = unsignedIntToInt8;
                    i15 = unsignedIntToInt2;
                    if (!zMoveNext) {
                        Log.m1719w(TAG, "Unexpected end of chunk data");
                        long[] jArrCopyOf2 = Arrays.copyOf(jArr, i14);
                        int[] iArrCopyOf2 = Arrays.copyOf(iArr, i14);
                        jArrCopyOf = Arrays.copyOf(jArr2, i14);
                        iArrCopyOf = Arrays.copyOf(iArr2, i14);
                        jArr3 = jArrCopyOf2;
                        iArr3 = iArrCopyOf2;
                        sampleCount = i14;
                        i16 = i18;
                        break;
                    }
                    if (parsableByteArray5 != null) {
                        while (unsignedIntToInt5 == 0 && i10 > 0) {
                            unsignedIntToInt5 = parsableByteArray5.readUnsignedIntToInt();
                            i13 = parsableByteArray5.readInt();
                            i10--;
                        }
                        unsignedIntToInt5--;
                    }
                    int i47 = i13;
                    jArr[i14] = j15;
                    nextSampleSize = stz2SampleSizeBox.readNextSampleSize();
                    iArr[i14] = nextSampleSize;
                    ChunkIterator chunkIterator2 = chunkIterator;
                    SampleSizeBox sampleSizeBox = stz2SampleSizeBox;
                    j11 += (long) nextSampleSize;
                    if (nextSampleSize > i11) {
                        i11 = nextSampleSize;
                    }
                    jArr2[i14] = j10 + ((long) i47);
                    if (parsableByteArray4 == null) {
                        i21 = 1;
                    } else {
                        i21 = 0;
                    }
                    iArr2[i14] = i21;
                    if (i14 == unsignedIntToInt4) {
                        iArr2[i14] = 1;
                        i23 = i15 - 1;
                        if (i23 > 0) {
                            unsignedIntToInt4 = ((ParsableByteArray) Assertions.checkNotNull(parsableByteArray4)).readUnsignedIntToInt() - 1;
                        }
                        i22 = unsignedIntToInt4;
                    } else {
                        i22 = unsignedIntToInt4;
                        i23 = i15;
                    }
                    j10 += (long) i20;
                    unsignedIntToInt7--;
                    if (unsignedIntToInt7 == 0 || i6 <= 0) {
                        i24 = i20;
                        i25 = i6;
                    } else {
                        int unsignedIntToInt9 = parsableByteArray3.readUnsignedIntToInt();
                        i24 = parsableByteArray3.readInt();
                        i25 = i6 - 1;
                        unsignedIntToInt7 = unsignedIntToInt9;
                    }
                    int i48 = i24;
                    long j24 = j15 + ((long) iArr[i14]);
                    i12 = i18 - 1;
                    i14++;
                    j12 = j24;
                    i13 = i47;
                    unsignedIntToInt4 = i22;
                    sampleCount = i19;
                    chunkIterator = chunkIterator2;
                    int i49 = i25;
                    unsignedIntToInt8 = i48;
                    i6 = i49;
                    unsignedIntToInt2 = i23;
                    stz2SampleSizeBox = sampleSizeBox;
                }
                long j25 = j10 + ((long) i13);
                if (parsableByteArray5 != null) {
                    z11 = true;
                    break;
                }
                while (true) {
                    if (i10 > 0) {
                        z11 = true;
                        break;
                    }
                    if (parsableByteArray5.readUnsignedIntToInt() != 0) {
                        z11 = false;
                        break;
                    }
                    parsableByteArray5.readInt();
                    i10--;
                }
                if (i15 != 0 && unsignedIntToInt7 == 0 && i16 == 0 && i6 == 0) {
                    i17 = unsignedIntToInt5;
                    if (i17 == 0 && z11) {
                        trackCopyWithFormat = track2;
                    }
                    iArr4 = iArr3;
                    jArr4 = jArrCopyOf;
                    j13 = j25;
                    j14 = j11;
                } else {
                    i17 = unsignedIntToInt5;
                }
                StringBuilder sb = new StringBuilder("Inconsistent stbl box for track ");
                trackCopyWithFormat = track2;
                sb.append(trackCopyWithFormat.f3100id);
                sb.append(": remainingSynchronizationSamples ");
                sb.append(i15);
                sb.append(", remainingSamplesAtTimestampDelta ");
                sb.append(unsignedIntToInt7);
                sb.append(", remainingSamplesInChunk ");
                sb.append(i16);
                sb.append(", remainingTimestampDeltaChanges ");
                sb.append(i6);
                sb.append(", remainingSamplesAtTimestampOffset ");
                sb.append(i17);
                if (z11) {
                    str = "";
                } else {
                    str = ", ctts invalid";
                }
                sb.append(str);
                Log.m1719w(TAG, sb.toString());
                iArr4 = iArr3;
                jArr4 = jArrCopyOf;
                j13 = j25;
                j14 = j11;
            }
            int[] iArr15 = iArrCopyOf;
            j16 = trackCopyWithFormat.mediaDurationUs;
            if (j16 > 0) {
                jScaleLargeValue = Util.scaleLargeValue(j14 * 8, 1000000L, j16, RoundingMode.HALF_DOWN);
                if (jScaleLargeValue > 0 && jScaleLargeValue < 2147483647L) {
                    trackCopyWithFormat = trackCopyWithFormat.copyWithFormat(trackCopyWithFormat.format.buildUpon().setAverageBitrate((int) jScaleLargeValue).build());
                }
            }
            iArr5 = iArr15;
            jScaleLargeTimestamp = Util.scaleLargeTimestamp(j13, 1000000L, trackCopyWithFormat.timescale);
            jArr5 = trackCopyWithFormat.editListDurations;
            if (jArr5 == null) {
                Util.scaleLargeTimestampsInPlace(jArr4, 1000000L, trackCopyWithFormat.timescale);
                return new TrackSampleTable(trackCopyWithFormat, jArr3, iArr4, i11, jArr4, iArr5, jScaleLargeTimestamp);
            }
            if (jArr5.length == 1 && trackCopyWithFormat.type == 1 && jArr4.length >= 2) {
                j20 = ((long[]) Assertions.checkNotNull(trackCopyWithFormat.editListMediaTimes))[0];
                jScaleLargeTimestamp3 = Util.scaleLargeTimestamp(trackCopyWithFormat.editListDurations[0], trackCopyWithFormat.timescale, trackCopyWithFormat.movieTimescale) + j20;
                if (canApplyEditWithGaplessInfo(jArr4, j13, j20, jScaleLargeTimestamp3)) {
                    long j26 = j13 - jScaleLargeTimestamp3;
                    jScaleLargeTimestamp4 = Util.scaleLargeTimestamp(j20 - jArr4[0], trackCopyWithFormat.format.sampleRate, trackCopyWithFormat.timescale);
                    jScaleLargeTimestamp5 = Util.scaleLargeTimestamp(j26, trackCopyWithFormat.format.sampleRate, trackCopyWithFormat.timescale);
                    if ((jScaleLargeTimestamp4 == 0 || jScaleLargeTimestamp5 != 0) && jScaleLargeTimestamp4 <= 2147483647L && jScaleLargeTimestamp5 <= 2147483647L) {
                        gaplessInfoHolder.encoderDelay = (int) jScaleLargeTimestamp4;
                        gaplessInfoHolder.encoderPadding = (int) jScaleLargeTimestamp5;
                        Util.scaleLargeTimestampsInPlace(jArr4, 1000000L, trackCopyWithFormat.timescale);
                        return new TrackSampleTable(trackCopyWithFormat, jArr3, iArr4, i11, jArr4, iArr5, Util.scaleLargeTimestamp(trackCopyWithFormat.editListDurations[0], 1000000L, trackCopyWithFormat.movieTimescale));
                    }
                }
            }
            jArr6 = trackCopyWithFormat.editListDurations;
            if (jArr6.length != 1 && jArr6[0] == 0) {
                long j27 = ((long[]) Assertions.checkNotNull(trackCopyWithFormat.editListMediaTimes))[0];
                for (int i50 = 0; i50 < jArr4.length; i50++) {
                    jArr4[i50] = Util.scaleLargeTimestamp(jArr4[i50] - j27, 1000000L, trackCopyWithFormat.timescale);
                }
                return new TrackSampleTable(trackCopyWithFormat, jArr3, iArr4, i11, jArr4, iArr5, Util.scaleLargeTimestamp(j13 - j27, 1000000L, trackCopyWithFormat.timescale));
            }
            if (trackCopyWithFormat.type == 1) {
                z12 = true;
            } else {
                z12 = false;
            }
            iArr6 = new int[jArr6.length];
            iArr7 = new int[jArr6.length];
            jArr7 = (long[]) Assertions.checkNotNull(trackCopyWithFormat.editListMediaTimes);
            i26 = 0;
            z13 = false;
            i27 = 0;
            i28 = 0;
            while (true) {
                jArr8 = trackCopyWithFormat.editListDurations;
                if (i26 < jArr8.length) {
                    break;
                }
                int i51 = i11;
                j19 = jArr7[i26];
                if (j19 != -1) {
                    boolean z19 = z13;
                    int i52 = i27;
                    long jScaleLargeTimestamp6 = Util.scaleLargeTimestamp(jArr8[i26], trackCopyWithFormat.timescale, trackCopyWithFormat.movieTimescale);
                    iArr6[i26] = Util.binarySearchFloor(jArr4, j19, true, true);
                    long j28 = j19 + jScaleLargeTimestamp6;
                    iArr7[i26] = Util.binarySearchCeil(jArr4, j28, z12, false);
                    i38 = iArr6[i26];
                    while (true) {
                        i39 = iArr6[i26];
                        iArr12 = iArr5;
                        if (i39 < 0 || (iArr12[i39] & 1) != 0) {
                            break;
                        }
                        iArr6[i26] = i39 - 1;
                        iArr5 = iArr12;
                    }
                    if (i39 < 0) {
                        iArr6[i26] = i38;
                        while (true) {
                            i42 = iArr6[i26];
                            if (i42 >= iArr7[i26] || (iArr12[i42] & 1) != 0) {
                                break;
                            }
                            iArr6[i26] = i42 + 1;
                        }
                    }
                    if (trackCopyWithFormat.type == 2 && iArr6[i26] != iArr7[i26]) {
                        while (true) {
                            i41 = iArr7[i26];
                            if (i41 >= jArr4.length - 1 || jArr4[i41 + 1] > j28) {
                                break;
                            }
                            iArr7[i26] = i41 + 1;
                        }
                    }
                    int i53 = iArr7[i26];
                    i40 = iArr6[i26];
                    i37 = (i53 - i40) + i52;
                    if (i28 != i40) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    z17 = z19 | z18;
                    i28 = i53;
                } else {
                    int i54 = i27;
                    iArr12 = iArr5;
                    z17 = z13;
                    i37 = i54;
                }
                i26++;
                iArr5 = iArr12;
                z13 = z17;
                iArr4 = iArr4;
                i27 = i37;
                i11 = i51;
                sampleCount = sampleCount;
            }
            iArr8 = iArr4;
            boolean z20 = z13;
            i29 = i27;
            i30 = i11;
            iArr9 = iArr5;
            if (i29 != sampleCount) {
                z14 = true;
            } else {
                z14 = false;
            }
            z15 = z20 | z14;
            if (z15) {
                jArr9 = new long[i29];
            } else {
                jArr9 = jArr3;
            }
            if (z15) {
                iArr10 = new int[i29];
            } else {
                iArr10 = iArr8;
            }
            if (z15) {
                i31 = 0;
            } else {
                i31 = i30;
            }
            if (z15) {
                iArr11 = new int[i29];
            } else {
                iArr11 = iArr9;
            }
            jArr10 = new long[i29];
            i32 = i31;
            i33 = 0;
            i34 = 0;
            j17 = 0;
            z16 = false;
            while (i33 < trackCopyWithFormat.editListDurations.length) {
                j18 = trackCopyWithFormat.editListMediaTimes[i33];
                i35 = iArr6[i33];
                int[] iArr16 = iArr6;
                i36 = iArr7[i33];
                int[] iArr17 = iArr7;
                if (z15) {
                    int i55 = i36 - i35;
                    System.arraycopy(jArr3, i35, jArr9, i34, i55);
                    System.arraycopy(iArr8, i35, iArr10, i34, i55);
                    System.arraycopy(iArr9, i35, iArr11, i34, i55);
                }
                int i56 = i32;
                while (i35 < i36) {
                    int i57 = i36;
                    int[] iArr18 = iArr9;
                    long jScaleLargeTimestamp7 = Util.scaleLargeTimestamp(j17, 1000000L, trackCopyWithFormat.movieTimescale);
                    long[] jArr13 = jArr9;
                    long[] jArr14 = jArr3;
                    jScaleLargeTimestamp2 = Util.scaleLargeTimestamp(jArr4[i35] - j18, 1000000L, trackCopyWithFormat.timescale);
                    if (jScaleLargeTimestamp2 < 0) {
                        z16 = true;
                    }
                    jArr10[i34] = jScaleLargeTimestamp7 + jScaleLargeTimestamp2;
                    if (!z15 && iArr10[i34] > i56) {
                        i56 = iArr8[i35];
                    }
                    i34++;
                    i35++;
                    iArr9 = iArr18;
                    i36 = i57;
                    jArr3 = jArr14;
                    jArr9 = jArr13;
                }
                j17 += trackCopyWithFormat.editListDurations[i33];
                i33++;
                iArr9 = iArr9;
                i32 = i56;
                iArr6 = iArr16;
                iArr7 = iArr17;
                jArr9 = jArr9;
            }
            long[] jArr15 = jArr9;
            long jScaleLargeTimestamp8 = Util.scaleLargeTimestamp(j17, 1000000L, trackCopyWithFormat.movieTimescale);
            if (z16) {
                trackCopyWithFormat = trackCopyWithFormat.copyWithFormat(trackCopyWithFormat.format.buildUpon().setHasPrerollSamples(true).build());
            }
            return new TrackSampleTable(trackCopyWithFormat, jArr15, iArr10, i32, jArr10, iArr11, jScaleLargeTimestamp8);
        }
        unsignedIntToInt2 = 0;
        unsignedIntToInt3 = -1;
        fixedSampleSize = stz2SampleSizeBox.getFixedSampleSize();
        String str3 = trackCopyWithFormat2.format.sampleMimeType;
        if (fixedSampleSize == -1) {
            z10 = false;
        } else {
            z10 = false;
        }
        if (z10) {
            int i410 = chunkIterator.length;
            jArr11 = new long[i410];
            iArr13 = new int[i410];
            while (chunkIterator.moveNext()) {
                int i411 = chunkIterator.index;
                jArr11[i411] = chunkIterator.offset;
                iArr13[i411] = chunkIterator.numSamples;
            }
            FixedSampleSizeRechunker.Results resultsRechunk2 = FixedSampleSizeRechunker.rechunk(fixedSampleSize, jArr11, iArr13, unsignedIntToInt8);
            jArr3 = resultsRechunk2.offsets;
            int[] iArr19 = resultsRechunk2.sizes;
            int i412 = resultsRechunk2.maximumSize;
            long[] jArr16 = resultsRechunk2.timestamps;
            iArrCopyOf = resultsRechunk2.flags;
            long j29 = resultsRechunk2.duration;
            j14 = resultsRechunk2.totalSize;
            trackCopyWithFormat = trackCopyWithFormat2;
            iArr4 = iArr19;
            i11 = i412;
            jArr4 = jArr16;
            j13 = j29;
        } else {
            jArr = new long[sampleCount];
            iArr = new int[sampleCount];
            jArr2 = new long[sampleCount];
            iArr2 = new int[sampleCount];
            i6 = unsignedIntToInt6;
            unsignedIntToInt4 = unsignedIntToInt3;
            i10 = unsignedIntToInt;
            i11 = 0;
            i12 = 0;
            i13 = 0;
            unsignedIntToInt5 = 0;
            j10 = 0;
            j11 = 0;
            j12 = 0;
            Track track3 = trackCopyWithFormat2;
            i14 = 0;
            while (true) {
                if (i14 < sampleCount) {
                    i15 = unsignedIntToInt2;
                    jArr3 = jArr;
                    iArr3 = iArr;
                    jArrCopyOf = jArr2;
                    iArrCopyOf = iArr2;
                    i16 = i12;
                    break;
                }
                j15 = j12;
                i18 = i12;
                zMoveNext = true;
                while (i18 == 0) {
                    zMoveNext = chunkIterator.moveNext();
                    if (zMoveNext) {
                        break;
                        break;
                    }
                    int i413 = unsignedIntToInt8;
                    long j210 = chunkIterator.offset;
                    i18 = chunkIterator.numSamples;
                    j15 = j210;
                    unsignedIntToInt8 = i413;
                    unsignedIntToInt2 = unsignedIntToInt2;
                    sampleCount = sampleCount;
                }
                i19 = sampleCount;
                i20 = unsignedIntToInt8;
                i15 = unsignedIntToInt2;
                if (!zMoveNext) {
                    Log.m1719w(TAG, "Unexpected end of chunk data");
                    long[] jArrCopyOf3 = Arrays.copyOf(jArr, i14);
                    int[] iArrCopyOf3 = Arrays.copyOf(iArr, i14);
                    jArrCopyOf = Arrays.copyOf(jArr2, i14);
                    iArrCopyOf = Arrays.copyOf(iArr2, i14);
                    jArr3 = jArrCopyOf3;
                    iArr3 = iArrCopyOf3;
                    sampleCount = i14;
                    i16 = i18;
                    break;
                }
                if (parsableByteArray5 != null) {
                    while (unsignedIntToInt5 == 0) {
                        unsignedIntToInt5 = parsableByteArray5.readUnsignedIntToInt();
                        i13 = parsableByteArray5.readInt();
                        i10--;
                    }
                    unsignedIntToInt5--;
                }
                int i414 = i13;
                jArr[i14] = j15;
                nextSampleSize = stz2SampleSizeBox.readNextSampleSize();
                iArr[i14] = nextSampleSize;
                ChunkIterator chunkIterator3 = chunkIterator;
                SampleSizeBox sampleSizeBox2 = stz2SampleSizeBox;
                j11 += (long) nextSampleSize;
                if (nextSampleSize > i11) {
                    i11 = nextSampleSize;
                }
                jArr2[i14] = j10 + ((long) i414);
                if (parsableByteArray4 == null) {
                    i21 = 1;
                } else {
                    i21 = 0;
                }
                iArr2[i14] = i21;
                if (i14 == unsignedIntToInt4) {
                    iArr2[i14] = 1;
                    i23 = i15 - 1;
                    if (i23 > 0) {
                        unsignedIntToInt4 = ((ParsableByteArray) Assertions.checkNotNull(parsableByteArray4)).readUnsignedIntToInt() - 1;
                    }
                    i22 = unsignedIntToInt4;
                } else {
                    i22 = unsignedIntToInt4;
                    i23 = i15;
                }
                j10 += (long) i20;
                unsignedIntToInt7--;
                if (unsignedIntToInt7 == 0) {
                    i24 = i20;
                    i25 = i6;
                } else {
                    i24 = i20;
                    i25 = i6;
                }
                int i415 = i24;
                long j211 = j15 + ((long) iArr[i14]);
                i12 = i18 - 1;
                i14++;
                j12 = j211;
                i13 = i414;
                unsignedIntToInt4 = i22;
                sampleCount = i19;
                chunkIterator = chunkIterator3;
                int i416 = i25;
                unsignedIntToInt8 = i415;
                i6 = i416;
                unsignedIntToInt2 = i23;
                stz2SampleSizeBox = sampleSizeBox2;
            }
            long j212 = j10 + ((long) i13);
            if (parsableByteArray5 != null) {
                z11 = true;
                break;
            }
            while (true) {
                if (i10 > 0) {
                    z11 = true;
                    break;
                }
                if (parsableByteArray5.readUnsignedIntToInt() != 0) {
                    z11 = false;
                    break;
                }
                parsableByteArray5.readInt();
                i10--;
            }
            if (i15 != 0) {
                i17 = unsignedIntToInt5;
                StringBuilder sb2 = new StringBuilder("Inconsistent stbl box for track ");
                trackCopyWithFormat = track3;
                sb2.append(trackCopyWithFormat.f3100id);
                sb2.append(": remainingSynchronizationSamples ");
                sb2.append(i15);
                sb2.append(", remainingSamplesAtTimestampDelta ");
                sb2.append(unsignedIntToInt7);
                sb2.append(", remainingSamplesInChunk ");
                sb2.append(i16);
                sb2.append(", remainingTimestampDeltaChanges ");
                sb2.append(i6);
                sb2.append(", remainingSamplesAtTimestampOffset ");
                sb2.append(i17);
                if (z11) {
                    str = ", ctts invalid";
                } else {
                    str = "";
                }
                sb2.append(str);
                Log.m1719w(TAG, sb2.toString());
            } else {
                i17 = unsignedIntToInt5;
                StringBuilder sb3 = new StringBuilder("Inconsistent stbl box for track ");
                trackCopyWithFormat = track3;
                sb3.append(trackCopyWithFormat.f3100id);
                sb3.append(": remainingSynchronizationSamples ");
                sb3.append(i15);
                sb3.append(", remainingSamplesAtTimestampDelta ");
                sb3.append(unsignedIntToInt7);
                sb3.append(", remainingSamplesInChunk ");
                sb3.append(i16);
                sb3.append(", remainingTimestampDeltaChanges ");
                sb3.append(i6);
                sb3.append(", remainingSamplesAtTimestampOffset ");
                sb3.append(i17);
                if (z11) {
                    str = ", ctts invalid";
                } else {
                    str = "";
                }
                sb3.append(str);
                Log.m1719w(TAG, sb3.toString());
            }
            iArr4 = iArr3;
            jArr4 = jArrCopyOf;
            j13 = j212;
            j14 = j11;
        }
        int[] iArr110 = iArrCopyOf;
        j16 = trackCopyWithFormat.mediaDurationUs;
        if (j16 > 0) {
            jScaleLargeValue = Util.scaleLargeValue(j14 * 8, 1000000L, j16, RoundingMode.HALF_DOWN);
            if (jScaleLargeValue > 0) {
                trackCopyWithFormat = trackCopyWithFormat.copyWithFormat(trackCopyWithFormat.format.buildUpon().setAverageBitrate((int) jScaleLargeValue).build());
            }
        }
        iArr5 = iArr110;
        jScaleLargeTimestamp = Util.scaleLargeTimestamp(j13, 1000000L, trackCopyWithFormat.timescale);
        jArr5 = trackCopyWithFormat.editListDurations;
        if (jArr5 == null) {
            Util.scaleLargeTimestampsInPlace(jArr4, 1000000L, trackCopyWithFormat.timescale);
            return new TrackSampleTable(trackCopyWithFormat, jArr3, iArr4, i11, jArr4, iArr5, jScaleLargeTimestamp);
        }
        if (jArr5.length == 1) {
            j20 = ((long[]) Assertions.checkNotNull(trackCopyWithFormat.editListMediaTimes))[0];
            jScaleLargeTimestamp3 = Util.scaleLargeTimestamp(trackCopyWithFormat.editListDurations[0], trackCopyWithFormat.timescale, trackCopyWithFormat.movieTimescale) + j20;
            if (canApplyEditWithGaplessInfo(jArr4, j13, j20, jScaleLargeTimestamp3)) {
                long j213 = j13 - jScaleLargeTimestamp3;
                jScaleLargeTimestamp4 = Util.scaleLargeTimestamp(j20 - jArr4[0], trackCopyWithFormat.format.sampleRate, trackCopyWithFormat.timescale);
                jScaleLargeTimestamp5 = Util.scaleLargeTimestamp(j213, trackCopyWithFormat.format.sampleRate, trackCopyWithFormat.timescale);
                if (jScaleLargeTimestamp4 == 0) {
                    gaplessInfoHolder.encoderDelay = (int) jScaleLargeTimestamp4;
                    gaplessInfoHolder.encoderPadding = (int) jScaleLargeTimestamp5;
                    Util.scaleLargeTimestampsInPlace(jArr4, 1000000L, trackCopyWithFormat.timescale);
                    return new TrackSampleTable(trackCopyWithFormat, jArr3, iArr4, i11, jArr4, iArr5, Util.scaleLargeTimestamp(trackCopyWithFormat.editListDurations[0], 1000000L, trackCopyWithFormat.movieTimescale));
                }
                gaplessInfoHolder.encoderDelay = (int) jScaleLargeTimestamp4;
                gaplessInfoHolder.encoderPadding = (int) jScaleLargeTimestamp5;
                Util.scaleLargeTimestampsInPlace(jArr4, 1000000L, trackCopyWithFormat.timescale);
                return new TrackSampleTable(trackCopyWithFormat, jArr3, iArr4, i11, jArr4, iArr5, Util.scaleLargeTimestamp(trackCopyWithFormat.editListDurations[0], 1000000L, trackCopyWithFormat.movieTimescale));
            }
        }
        jArr6 = trackCopyWithFormat.editListDurations;
        if (jArr6.length != 1) {
        }
        if (trackCopyWithFormat.type == 1) {
            z12 = true;
        } else {
            z12 = false;
        }
        iArr6 = new int[jArr6.length];
        iArr7 = new int[jArr6.length];
        jArr7 = (long[]) Assertions.checkNotNull(trackCopyWithFormat.editListMediaTimes);
        i26 = 0;
        z13 = false;
        i27 = 0;
        i28 = 0;
        while (true) {
            jArr8 = trackCopyWithFormat.editListDurations;
            if (i26 < jArr8.length) {
                break;
                break;
            }
            int i58 = i11;
            j19 = jArr7[i26];
            if (j19 != -1) {
                boolean z110 = z13;
                int i59 = i27;
                long jScaleLargeTimestamp9 = Util.scaleLargeTimestamp(jArr8[i26], trackCopyWithFormat.timescale, trackCopyWithFormat.movieTimescale);
                iArr6[i26] = Util.binarySearchFloor(jArr4, j19, true, true);
                long j214 = j19 + jScaleLargeTimestamp9;
                iArr7[i26] = Util.binarySearchCeil(jArr4, j214, z12, false);
                i38 = iArr6[i26];
                while (true) {
                    i39 = iArr6[i26];
                    iArr12 = iArr5;
                    if (i39 < 0) {
                        break;
                    }
                    break;
                    break;
                    iArr6[i26] = i39 - 1;
                    iArr5 = iArr12;
                }
                if (i39 < 0) {
                    iArr6[i26] = i38;
                    while (true) {
                        i42 = iArr6[i26];
                        if (i42 >= iArr7[i26]) {
                            break;
                        }
                        break;
                        break;
                        iArr6[i26] = i42 + 1;
                    }
                }
                if (trackCopyWithFormat.type == 2) {
                    while (true) {
                        i41 = iArr7[i26];
                        if (i41 >= jArr4.length - 1) {
                            break;
                        }
                        break;
                        break;
                        iArr7[i26] = i41 + 1;
                    }
                }
                int i510 = iArr7[i26];
                i40 = iArr6[i26];
                i37 = (i510 - i40) + i59;
                if (i28 != i40) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                z17 = z110 | z18;
                i28 = i510;
            } else {
                int i511 = i27;
                iArr12 = iArr5;
                z17 = z13;
                i37 = i511;
            }
            i26++;
            iArr5 = iArr12;
            z13 = z17;
            iArr4 = iArr4;
            i27 = i37;
            i11 = i58;
            sampleCount = sampleCount;
        }
        iArr8 = iArr4;
        boolean z21 = z13;
        i29 = i27;
        i30 = i11;
        iArr9 = iArr5;
        if (i29 != sampleCount) {
            z14 = true;
        } else {
            z14 = false;
        }
        z15 = z21 | z14;
        if (z15) {
            jArr9 = new long[i29];
        } else {
            jArr9 = jArr3;
        }
        if (z15) {
            iArr10 = new int[i29];
        } else {
            iArr10 = iArr8;
        }
        if (z15) {
            i31 = 0;
        } else {
            i31 = i30;
        }
        if (z15) {
            iArr11 = new int[i29];
        } else {
            iArr11 = iArr9;
        }
        jArr10 = new long[i29];
        i32 = i31;
        i33 = 0;
        i34 = 0;
        j17 = 0;
        z16 = false;
        while (i33 < trackCopyWithFormat.editListDurations.length) {
            j18 = trackCopyWithFormat.editListMediaTimes[i33];
            i35 = iArr6[i33];
            int[] iArr111 = iArr6;
            i36 = iArr7[i33];
            int[] iArr112 = iArr7;
            if (z15) {
                int i512 = i36 - i35;
                System.arraycopy(jArr3, i35, jArr9, i34, i512);
                System.arraycopy(iArr8, i35, iArr10, i34, i512);
                System.arraycopy(iArr9, i35, iArr11, i34, i512);
            }
            int i513 = i32;
            while (i35 < i36) {
                int i514 = i36;
                int[] iArr113 = iArr9;
                long jScaleLargeTimestamp10 = Util.scaleLargeTimestamp(j17, 1000000L, trackCopyWithFormat.movieTimescale);
                long[] jArr17 = jArr9;
                long[] jArr18 = jArr3;
                jScaleLargeTimestamp2 = Util.scaleLargeTimestamp(jArr4[i35] - j18, 1000000L, trackCopyWithFormat.timescale);
                if (jScaleLargeTimestamp2 < 0) {
                    z16 = true;
                }
                jArr10[i34] = jScaleLargeTimestamp10 + jScaleLargeTimestamp2;
                if (!z15) {
                }
                i34++;
                i35++;
                iArr9 = iArr113;
                i36 = i514;
                jArr3 = jArr18;
                jArr9 = jArr17;
            }
            j17 += trackCopyWithFormat.editListDurations[i33];
            i33++;
            iArr9 = iArr9;
            i32 = i513;
            iArr6 = iArr111;
            iArr7 = iArr112;
            jArr9 = jArr9;
        }
        long[] jArr19 = jArr9;
        long jScaleLargeTimestamp11 = Util.scaleLargeTimestamp(j17, 1000000L, trackCopyWithFormat.movieTimescale);
        if (z16) {
            trackCopyWithFormat = trackCopyWithFormat.copyWithFormat(trackCopyWithFormat.format.buildUpon().setHasPrerollSamples(true).build());
        }
        return new TrackSampleTable(trackCopyWithFormat, jArr19, iArr10, i32, jArr10, iArr11, jScaleLargeTimestamp11);
    }

    private static EyesData parseStereoViewBox(ParsableByteArray parsableByteArray, int i6, int i10) throws ParserException {
        parsableByteArray.setPosition(i6 + 8);
        int position = parsableByteArray.getPosition();
        while (position - i6 < i10) {
            parsableByteArray.setPosition(position);
            int i11 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i11 > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == 1937011305) {
                parsableByteArray.skipBytes(4);
                int unsignedByte = parsableByteArray.readUnsignedByte();
                return new EyesData(new StriData((unsignedByte & 1) == 1, (unsignedByte & 2) == 2, (unsignedByte & 8) == 8));
            }
            position += i11;
        }
        return null;
    }

    private static StsdData parseStsd(ParsableByteArray parsableByteArray, int i6, int i10, String str, DrmInitData drmInitData, boolean z7) throws ParserException {
        int i11;
        parsableByteArray.setPosition(12);
        int i12 = parsableByteArray.readInt();
        StsdData stsdData = new StsdData(i12);
        for (int i13 = 0; i13 < i12; i13++) {
            int position = parsableByteArray.getPosition();
            int i14 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i14 > 0, "childAtomSize must be positive");
            int i15 = parsableByteArray.readInt();
            if (i15 == 1635148593 || i15 == 1635148595 || i15 == 1701733238 || i15 == 1831958048 || i15 == 1836070006 || i15 == 1752589105 || i15 == 1751479857 || i15 == 1932670515 || i15 == 1211250227 || i15 == 1748121139 || i15 == 1987063864 || i15 == 1987063865 || i15 == 1635135537 || i15 == 1685479798 || i15 == 1685479729 || i15 == 1685481573 || i15 == 1685481521 || i15 == 1634760241) {
                i11 = position;
                parseVideoSampleEntry(parsableByteArray, i15, i11, i14, i6, str, i10, drmInitData, stsdData, i13);
            } else if (i15 == 1836069985 || i15 == 1701733217 || i15 == 1633889587 || i15 == 1700998451 || i15 == 1633889588 || i15 == 1835823201 || i15 == 1685353315 || i15 == 1685353317 || i15 == 1685353320 || i15 == 1685353324 || i15 == 1685353336 || i15 == 1935764850 || i15 == 1935767394 || i15 == 1819304813 || i15 == 1936684916 || i15 == 1953984371 || i15 == 778924082 || i15 == 778924083 || i15 == 1835557169 || i15 == 1835560241 || i15 == 1634492771 || i15 == 1634492791 || i15 == 1970037111 || i15 == 1332770163 || i15 == 1716281667 || i15 == 1767992678) {
                i11 = position;
                parseAudioSampleEntry(parsableByteArray, i15, position, i14, i6, str, z7, drmInitData, stsdData, i13);
            } else {
                if (i15 == 1414810956 || i15 == 1954034535 || i15 == 2004251764 || i15 == 1937010800 || i15 == 1664495672) {
                    parseTextSampleEntry(parsableByteArray, i15, position, i14, i6, str, stsdData);
                } else if (i15 == 1835365492) {
                    parseMetaDataSampleEntry(parsableByteArray, i15, position, i6, stsdData);
                } else if (i15 == 1667329389) {
                    stsdData.format = new Format.Builder().setId(i6).setSampleMimeType(MimeTypes.APPLICATION_CAMERA_MOTION).build();
                }
                i11 = position;
            }
            parsableByteArray.setPosition(i11 + i14);
        }
        return stsdData;
    }

    private static void parseTextSampleEntry(ParsableByteArray parsableByteArray, int i6, int i10, int i11, int i12, String str, StsdData stsdData) {
        parsableByteArray.setPosition(i10 + 16);
        String str2 = MimeTypes.APPLICATION_TTML;
        C2180c5 c2180c5M5275r = null;
        long j10 = Long.MAX_VALUE;
        if (i6 != 1414810956) {
            if (i6 == 1954034535) {
                int i13 = i11 - 16;
                byte[] bArr = new byte[i13];
                parsableByteArray.readBytes(bArr, 0, i13);
                c2180c5M5275r = AbstractC2301u1.m5275r(bArr);
                str2 = MimeTypes.APPLICATION_TX3G;
            } else if (i6 == 2004251764) {
                str2 = MimeTypes.APPLICATION_MP4VTT;
            } else if (i6 == 1937010800) {
                j10 = 0;
            } else {
                if (i6 != 1664495672) {
                    throw new IllegalStateException();
                }
                stsdData.requiredSampleTransformation = 1;
                str2 = MimeTypes.APPLICATION_MP4CEA608;
            }
        }
        stsdData.format = new Format.Builder().setId(i12).setSampleMimeType(str2).setLanguage(str).setSubsampleOffsetUs(j10).setInitializationData(c2180c5M5275r).build();
    }

    private static TkhdData parseTkhd(ParsableByteArray parsableByteArray) {
        long j10;
        int i6;
        parsableByteArray.setPosition(8);
        int fullBoxVersion = parseFullBoxVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(fullBoxVersion == 0 ? 8 : 16);
        int i10 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int position = parsableByteArray.getPosition();
        int i11 = fullBoxVersion == 0 ? 4 : 8;
        int i12 = 0;
        while (true) {
            j10 = C0565C.TIME_UNSET;
            if (i12 >= i11) {
                parsableByteArray.skipBytes(i11);
                break;
            }
            if (parsableByteArray.getData()[position + i12] != -1) {
                long unsignedInt = fullBoxVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
                if (unsignedInt == 0) {
                    break;
                }
                j10 = unsignedInt;
                break;
            }
            i12++;
        }
        parsableByteArray.skipBytes(10);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(4);
        int i13 = parsableByteArray.readInt();
        int i14 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int i15 = parsableByteArray.readInt();
        int i16 = parsableByteArray.readInt();
        if (i13 == 0 && i14 == 65536 && i15 == -65536 && i16 == 0) {
            i6 = 90;
        } else if (i13 == 0 && i14 == -65536 && i15 == 65536 && i16 == 0) {
            i6 = 270;
        } else {
            i6 = (i13 == -65536 && i14 == 0 && i15 == 0 && i16 == -65536) ? Opcodes.GETFIELD : 0;
        }
        return new TkhdData(i10, j10, unsignedShort, i6);
    }

    public static Track parseTrak(Mp4Box.ContainerBox containerBox, Mp4Box.LeafBox leafBox, long j10, DrmInitData drmInitData, boolean z7, boolean z10) throws ParserException {
        long[] jArr;
        long[] jArr2;
        Format formatBuild;
        Mp4Box.ContainerBox containerBoxOfType;
        Pair<long[], long[]> edts;
        Mp4Box.ContainerBox containerBox2 = (Mp4Box.ContainerBox) Assertions.checkNotNull(containerBox.getContainerBoxOfType(Mp4Box.TYPE_mdia));
        int trackTypeForHdlr = getTrackTypeForHdlr(parseHdlr(((Mp4Box.LeafBox) Assertions.checkNotNull(containerBox2.getLeafBoxOfType(Mp4Box.TYPE_hdlr))).data));
        if (trackTypeForHdlr == -1) {
            return null;
        }
        TkhdData tkhd = parseTkhd(((Mp4Box.LeafBox) Assertions.checkNotNull(containerBox.getLeafBoxOfType(Mp4Box.TYPE_tkhd))).data);
        long jScaleLargeTimestamp = C0565C.TIME_UNSET;
        long j11 = j10 == C0565C.TIME_UNSET ? tkhd.duration : j10;
        long j12 = parseMvhd(leafBox.data).timescale;
        if (j11 != C0565C.TIME_UNSET) {
            jScaleLargeTimestamp = Util.scaleLargeTimestamp(j11, 1000000L, j12);
        }
        long j13 = jScaleLargeTimestamp;
        Mp4Box.ContainerBox containerBox3 = (Mp4Box.ContainerBox) Assertions.checkNotNull(((Mp4Box.ContainerBox) Assertions.checkNotNull(containerBox2.getContainerBoxOfType(Mp4Box.TYPE_minf))).getContainerBoxOfType(Mp4Box.TYPE_stbl));
        MdhdData mdhd = parseMdhd(((Mp4Box.LeafBox) Assertions.checkNotNull(containerBox2.getLeafBoxOfType(Mp4Box.TYPE_mdhd))).data);
        Mp4Box.LeafBox leafBoxOfType = containerBox3.getLeafBoxOfType(Mp4Box.TYPE_stsd);
        if (leafBoxOfType == null) {
            throw ParserException.createForMalformedContainer("Malformed sample table (stbl) missing sample description (stsd)", null);
        }
        StsdData stsd = parseStsd(leafBoxOfType.data, tkhd.f3099id, tkhd.rotationDegrees, mdhd.language, drmInitData, z10);
        if (z7 || (containerBoxOfType = containerBox.getContainerBoxOfType(Mp4Box.TYPE_edts)) == null || (edts = parseEdts(containerBoxOfType)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) edts.first;
            jArr2 = (long[]) edts.second;
            jArr = jArr3;
        }
        if (stsd.format == null) {
            return null;
        }
        if (tkhd.alternateGroup != 0) {
            Mp4AlternateGroupData mp4AlternateGroupData = new Mp4AlternateGroupData(tkhd.alternateGroup);
            Format.Builder builderBuildUpon = stsd.format.buildUpon();
            Metadata metadata = stsd.format.metadata;
            formatBuild = builderBuildUpon.setMetadata(metadata != null ? metadata.copyWithAppendedEntries(mp4AlternateGroupData) : new Metadata(mp4AlternateGroupData)).build();
        } else {
            formatBuild = stsd.format;
        }
        return new Track(tkhd.f3099id, trackTypeForHdlr, mdhd.timescale, j12, j13, mdhd.mediaDurationUs, formatBuild, stsd.requiredSampleTransformation, stsd.trackEncryptionBoxes, stsd.nalUnitLengthFieldLength, jArr, jArr2);
    }

    public static List<TrackSampleTable> parseTraks(Mp4Box.ContainerBox containerBox, GaplessInfoHolder gaplessInfoHolder, long j10, DrmInitData drmInitData, boolean z7, boolean z10, InterfaceC1346i interfaceC1346i) throws ParserException {
        Track track;
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < containerBox.containerChildren.size(); i6++) {
            Mp4Box.ContainerBox containerBox2 = containerBox.containerChildren.get(i6);
            if (containerBox2.type == 1953653099 && (track = (Track) interfaceC1346i.apply(parseTrak(containerBox2, (Mp4Box.LeafBox) Assertions.checkNotNull(containerBox.getLeafBoxOfType(Mp4Box.TYPE_mvhd)), j10, drmInitData, z7, z10))) != null) {
                arrayList.add(parseStbl(track, (Mp4Box.ContainerBox) Assertions.checkNotNull(((Mp4Box.ContainerBox) Assertions.checkNotNull(((Mp4Box.ContainerBox) Assertions.checkNotNull(containerBox2.getContainerBoxOfType(Mp4Box.TYPE_mdia))).getContainerBoxOfType(Mp4Box.TYPE_minf))).getContainerBoxOfType(Mp4Box.TYPE_stbl)), gaplessInfoHolder));
            }
        }
        return arrayList;
    }

    public static Metadata parseUdta(Mp4Box.LeafBox leafBox) {
        ParsableByteArray parsableByteArray = leafBox.data;
        parsableByteArray.setPosition(8);
        Metadata metadata = new Metadata(new Metadata.Entry[0]);
        while (parsableByteArray.bytesLeft() >= 8) {
            int position = parsableByteArray.getPosition();
            int i6 = parsableByteArray.readInt();
            int i10 = parsableByteArray.readInt();
            if (i10 == 1835365473) {
                parsableByteArray.setPosition(position);
                metadata = metadata.copyWithAppendedEntriesFrom(parseUdtaMeta(parsableByteArray, position + i6));
            } else if (i10 == 1936553057) {
                parsableByteArray.setPosition(position);
                metadata = metadata.copyWithAppendedEntriesFrom(SmtaAtomUtil.parseSmta(parsableByteArray, position + i6));
            } else if (i10 == -1451722374) {
                metadata = metadata.copyWithAppendedEntriesFrom(parseXyz(parsableByteArray));
            }
            parsableByteArray.setPosition(position + i6);
        }
        return metadata;
    }

    private static Metadata parseUdtaMeta(ParsableByteArray parsableByteArray, int i6) {
        parsableByteArray.skipBytes(8);
        maybeSkipRemainingMetaBoxHeaderBytes(parsableByteArray);
        while (parsableByteArray.getPosition() < i6) {
            int position = parsableByteArray.getPosition();
            int i10 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1768715124) {
                parsableByteArray.setPosition(position);
                return parseIlst(parsableByteArray, position + i10);
            }
            parsableByteArray.setPosition(position + i10);
        }
        return null;
    }

    public static VexuData parseVideoExtendedUsageBox(ParsableByteArray parsableByteArray, int i6, int i10) throws ParserException {
        parsableByteArray.setPosition(i6 + 8);
        int position = parsableByteArray.getPosition();
        EyesData stereoViewBox = null;
        while (position - i6 < i10) {
            parsableByteArray.setPosition(position);
            int i11 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i11 > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == 1702454643) {
                stereoViewBox = parseStereoViewBox(parsableByteArray, position, i11);
            }
            position += i11;
        }
        if (stereoViewBox == null) {
            return null;
        }
        return new VexuData(stereoViewBox);
    }

    private static void parseVideoSampleEntry(ParsableByteArray parsableByteArray, int i6, int i10, int i11, int i12, String str, int i13, DrmInitData drmInitData, StsdData stsdData, int i14) throws ParserException {
        String str2;
        DrmInitData drmInitData2;
        int i15;
        int i16;
        int i17;
        int i18;
        List<byte[]> list;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23 = i10;
        int i24 = i11;
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        StsdData stsdData2 = stsdData;
        parsableByteArray.setPosition(i23 + 16);
        parsableByteArray.skipBytes(16);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int unsignedShort2 = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(50);
        int position = parsableByteArray.getPosition();
        int iIntValue = i6;
        if (iIntValue == 1701733238) {
            Pair<Integer, TrackEncryptionBox> sampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i23, i24);
            if (sampleEntryEncryptionData != null) {
                iIntValue = ((Integer) sampleEntryEncryptionData.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((TrackEncryptionBox) sampleEntryEncryptionData.second).schemeType);
                stsdData2.trackEncryptionBoxes[i14] = (TrackEncryptionBox) sampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        String str3 = MimeTypes.VIDEO_H263;
        if (iIntValue == 1831958048) {
            str2 = MimeTypes.VIDEO_MPEG;
        } else {
            str2 = iIntValue == 1211250227 ? MimeTypes.VIDEO_H263 : null;
        }
        int i25 = 8;
        List<byte[]> listM5275r = null;
        int i26 = 8;
        float paspFromParent = 1.0f;
        String str4 = null;
        byte[] projFromParent = null;
        int i27 = -1;
        int i28 = -1;
        int i29 = -1;
        int iIsoColorPrimariesToColorSpace = -1;
        int i30 = -1;
        int iIsoTransferCharacteristicsToColorTransfer = -1;
        ByteBuffer byteBufferAllocateHdrStaticInfo = null;
        BtrtData btrtFromParent = null;
        EsdsData esdsFromParent = null;
        NalUnitUtil.H265VpsData h265VpsData = null;
        boolean z7 = false;
        while (position - i23 < i24) {
            parsableByteArray.setPosition(position);
            int position2 = parsableByteArray.getPosition();
            int i31 = parsableByteArray.readInt();
            if (i31 == 0 && parsableByteArray.getPosition() - i23 == i24) {
                break;
            }
            ExtractorUtil.checkContainerInput(i31 > 0, "childAtomSize must be positive");
            int i32 = parsableByteArray.readInt();
            if (i32 == 1635148611) {
                ExtractorUtil.checkContainerInput(str2 == null, null);
                parsableByteArray.setPosition(position2 + 8);
                AvcConfig avcConfig = AvcConfig.parse(parsableByteArray);
                listM5275r = avcConfig.initializationData;
                stsdData2.nalUnitLengthFieldLength = avcConfig.nalUnitLengthFieldLength;
                if (!z7) {
                    paspFromParent = avcConfig.pixelWidthHeightRatio;
                }
                String str5 = avcConfig.codecs;
                int i33 = avcConfig.maxNumReorderFrames;
                int i34 = avcConfig.colorSpace;
                int i35 = avcConfig.colorRange;
                int i36 = avcConfig.colorTransfer;
                int i37 = avcConfig.bitdepthLuma;
                drmInitData2 = drmInitDataCopyWithSchemeType;
                i17 = unsignedShort2;
                i18 = iIntValue;
                i28 = i33;
                iIsoColorPrimariesToColorSpace = i34;
                i15 = i35;
                iIsoTransferCharacteristicsToColorTransfer = i36;
                i26 = avcConfig.bitdepthChroma;
                i25 = i37;
                str4 = str5;
                str2 = MimeTypes.VIDEO_H264;
            } else if (i32 == 1752589123) {
                ExtractorUtil.checkContainerInput(str2 == null, null);
                parsableByteArray.setPosition(position2 + 8);
                HevcConfig hevcConfig = HevcConfig.parse(parsableByteArray);
                listM5275r = hevcConfig.initializationData;
                stsdData2.nalUnitLengthFieldLength = hevcConfig.nalUnitLengthFieldLength;
                if (!z7) {
                    paspFromParent = hevcConfig.pixelWidthHeightRatio;
                }
                int i38 = hevcConfig.maxNumReorderPics;
                int i39 = hevcConfig.maxSubLayers;
                String str6 = hevcConfig.codecs;
                int i40 = hevcConfig.stereoMode;
                if (i40 != -1) {
                    i27 = i40;
                }
                int i41 = hevcConfig.colorSpace;
                int i42 = hevcConfig.colorRange;
                int i43 = hevcConfig.colorTransfer;
                int i44 = hevcConfig.bitdepthLuma;
                int i45 = hevcConfig.bitdepthChroma;
                h265VpsData = hevcConfig.vpsData;
                drmInitData2 = drmInitDataCopyWithSchemeType;
                i17 = unsignedShort2;
                i18 = iIntValue;
                iIsoColorPrimariesToColorSpace = i41;
                i15 = i42;
                iIsoTransferCharacteristicsToColorTransfer = i43;
                i26 = i45;
                i28 = i38;
                str4 = str6;
                i25 = i44;
                i29 = i39;
                str2 = MimeTypes.VIDEO_H265;
            } else {
                drmInitData2 = drmInitDataCopyWithSchemeType;
                if (i32 == 1818785347) {
                    ExtractorUtil.checkContainerInput(MimeTypes.VIDEO_H265.equals(str2), "lhvC must follow hvcC atom");
                    NalUnitUtil.H265VpsData h265VpsData2 = h265VpsData;
                    ExtractorUtil.checkContainerInput(h265VpsData2 != null && h265VpsData2.layerInfos.size() >= 2, "must have at least two layers");
                    parsableByteArray.setPosition(position2 + 8);
                    HevcConfig layered = HevcConfig.parseLayered(parsableByteArray, (NalUnitUtil.H265VpsData) Assertions.checkNotNull(h265VpsData2));
                    ExtractorUtil.checkContainerInput(stsdData2.nalUnitLengthFieldLength == layered.nalUnitLengthFieldLength, "nalUnitLengthFieldLength must be same for both hvcC and lhvC atoms");
                    int i46 = layered.colorSpace;
                    int i47 = iIsoColorPrimariesToColorSpace;
                    if (i46 != -1) {
                        ExtractorUtil.checkContainerInput(i47 == i46, "colorSpace must be the same for both views");
                    }
                    int i48 = layered.colorRange;
                    int i49 = i30;
                    if (i48 != -1) {
                        ExtractorUtil.checkContainerInput(i49 == i48, "colorRange must be the same for both views");
                    }
                    int i50 = layered.colorTransfer;
                    if (i50 != -1) {
                        int i51 = iIsoTransferCharacteristicsToColorTransfer;
                        i22 = i51;
                        ExtractorUtil.checkContainerInput(i51 == i50, "colorTransfer must be the same for both views");
                    } else {
                        i22 = iIsoTransferCharacteristicsToColorTransfer;
                    }
                    ExtractorUtil.checkContainerInput(i25 == layered.bitdepthLuma, "bitdepthLuma must be the same for both views");
                    ExtractorUtil.checkContainerInput(i26 == layered.bitdepthChroma, "bitdepthChroma must be the same for both views");
                    if (listM5275r != null) {
                        C2288s1 c2288s1M5269k = AbstractC2301u1.m5269k();
                        c2288s1M5269k.m5257d(listM5275r);
                        c2288s1M5269k.m5257d(layered.initializationData);
                        listM5275r = c2288s1M5269k.m5262g();
                    } else {
                        ExtractorUtil.checkContainerInput(false, "initializationData must be already set from hvcC atom");
                    }
                    String str7 = layered.codecs;
                    h265VpsData = h265VpsData2;
                    str2 = MimeTypes.VIDEO_MV_HEVC;
                    i17 = unsignedShort2;
                    i18 = iIntValue;
                    iIsoColorPrimariesToColorSpace = i47;
                    i15 = i49;
                    iIsoTransferCharacteristicsToColorTransfer = i22;
                    str4 = str7;
                } else {
                    iIsoColorPrimariesToColorSpace = iIsoColorPrimariesToColorSpace;
                    i15 = i30;
                    iIsoTransferCharacteristicsToColorTransfer = iIsoTransferCharacteristicsToColorTransfer;
                    NalUnitUtil.H265VpsData h265VpsData3 = h265VpsData;
                    if (i32 == 1986361461) {
                        VexuData videoExtendedUsageBox = parseVideoExtendedUsageBox(parsableByteArray, position2, i31);
                        if (videoExtendedUsageBox == null || videoExtendedUsageBox.eyesData == null) {
                            i21 = i27;
                            i27 = i21;
                        } else if (h265VpsData3 == null || h265VpsData3.layerInfos.size() < 2) {
                            i21 = i27;
                            if (i21 == -1) {
                                i27 = videoExtendedUsageBox.eyesData.striData.eyeViewsReversed ? 5 : 4;
                            } else {
                                i27 = i21;
                            }
                        } else {
                            ExtractorUtil.checkContainerInput(videoExtendedUsageBox.hasBothEyeViews(), "both eye views must be marked as available");
                            ExtractorUtil.checkContainerInput(!videoExtendedUsageBox.eyesData.striData.eyeViewsReversed, "for MV-HEVC, eye_views_reversed must be set to false");
                            i21 = i27;
                            i27 = i21;
                        }
                        h265VpsData = h265VpsData3;
                        i17 = unsignedShort2;
                        i18 = iIntValue;
                        iIsoColorPrimariesToColorSpace = iIsoColorPrimariesToColorSpace;
                        iIsoTransferCharacteristicsToColorTransfer = iIsoTransferCharacteristicsToColorTransfer;
                    } else {
                        int i52 = i27;
                        if (i32 == 1685480259 || i32 == 1685485123) {
                            i16 = i52;
                            i17 = unsignedShort2;
                            i18 = iIntValue;
                            i25 = i25;
                            list = listM5275r;
                            i26 = i26;
                            i19 = iIsoTransferCharacteristicsToColorTransfer;
                            DolbyVisionConfig dolbyVisionConfig = DolbyVisionConfig.parse(parsableByteArray);
                            if (dolbyVisionConfig != null) {
                                String str8 = dolbyVisionConfig.codecs;
                                str2 = MimeTypes.VIDEO_DOLBY_VISION;
                                str4 = str8;
                            }
                        } else if (i32 == 1987076931) {
                            ExtractorUtil.checkContainerInput(str2 == null, null);
                            String str9 = iIntValue == 1987063864 ? MimeTypes.VIDEO_VP8 : MimeTypes.VIDEO_VP9;
                            parsableByteArray.setPosition(position2 + 12);
                            byte unsignedByte = (byte) parsableByteArray.readUnsignedByte();
                            byte unsignedByte2 = (byte) parsableByteArray.readUnsignedByte();
                            int unsignedByte3 = parsableByteArray.readUnsignedByte();
                            int i53 = unsignedByte3 >> 4;
                            byte b8 = (byte) ((unsignedByte3 >> 1) & 7);
                            if (str9.equals(MimeTypes.VIDEO_VP9)) {
                                listM5275r = CodecSpecificDataUtil.buildVp9CodecPrivateInitializationData(unsignedByte, unsignedByte2, (byte) i53, b8);
                            }
                            boolean z10 = (unsignedByte3 & 1) != 0;
                            int unsignedByte4 = parsableByteArray.readUnsignedByte();
                            int unsignedByte5 = parsableByteArray.readUnsignedByte();
                            int iIsoColorPrimariesToColorSpace2 = ColorInfo.isoColorPrimariesToColorSpace(unsignedByte4);
                            int i54 = z10 ? 1 : 2;
                            iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(unsignedByte5);
                            i17 = unsignedShort2;
                            iIsoColorPrimariesToColorSpace = iIsoColorPrimariesToColorSpace2;
                            i25 = i53;
                            i26 = i25;
                            h265VpsData = h265VpsData3;
                            i15 = i54;
                            str2 = str9;
                            i27 = i52;
                            i18 = iIntValue;
                        } else if (i32 == 1635135811) {
                            int i55 = i31 - 8;
                            byte[] bArr = new byte[i55];
                            parsableByteArray.readBytes(bArr, 0, i55);
                            listM5275r = AbstractC2301u1.m5275r(bArr);
                            parsableByteArray.setPosition(position2 + 8);
                            ColorInfo av1c = parseAv1c(parsableByteArray);
                            int i56 = av1c.lumaBitdepth;
                            int i57 = av1c.chromaBitdepth;
                            int i58 = av1c.colorSpace;
                            int i59 = av1c.colorRange;
                            iIsoTransferCharacteristicsToColorTransfer = av1c.colorTransfer;
                            i17 = unsignedShort2;
                            i26 = i57;
                            i18 = iIntValue;
                            iIsoColorPrimariesToColorSpace = i58;
                            i15 = i59;
                            str2 = MimeTypes.VIDEO_AV1;
                            h265VpsData = h265VpsData3;
                            i25 = i56;
                            i27 = i52;
                        } else if (i32 == 1668050025) {
                            if (byteBufferAllocateHdrStaticInfo == null) {
                                byteBufferAllocateHdrStaticInfo = allocateHdrStaticInfo();
                            }
                            ByteBuffer byteBuffer = byteBufferAllocateHdrStaticInfo;
                            byteBuffer.position(21);
                            byteBuffer.putShort(parsableByteArray.readShort());
                            byteBuffer.putShort(parsableByteArray.readShort());
                            byteBufferAllocateHdrStaticInfo = byteBuffer;
                            i17 = unsignedShort2;
                            i18 = iIntValue;
                            iIsoColorPrimariesToColorSpace = iIsoColorPrimariesToColorSpace;
                            h265VpsData = h265VpsData3;
                            iIsoTransferCharacteristicsToColorTransfer = iIsoTransferCharacteristicsToColorTransfer;
                            i27 = i52;
                        } else {
                            if (i32 == 1835295606) {
                                if (byteBufferAllocateHdrStaticInfo == null) {
                                    byteBufferAllocateHdrStaticInfo = allocateHdrStaticInfo();
                                }
                                ByteBuffer byteBuffer2 = byteBufferAllocateHdrStaticInfo;
                                short s10 = parsableByteArray.readShort();
                                short s11 = parsableByteArray.readShort();
                                i18 = iIntValue;
                                short s12 = parsableByteArray.readShort();
                                short s13 = parsableByteArray.readShort();
                                int i60 = i26;
                                short s14 = parsableByteArray.readShort();
                                int i61 = i25;
                                short s15 = parsableByteArray.readShort();
                                List<byte[]> list2 = listM5275r;
                                short s16 = parsableByteArray.readShort();
                                i16 = i52;
                                short s17 = parsableByteArray.readShort();
                                long unsignedInt = parsableByteArray.readUnsignedInt();
                                long unsignedInt2 = parsableByteArray.readUnsignedInt();
                                i17 = unsignedShort2;
                                byteBuffer2.position(1);
                                byteBuffer2.putShort(s14);
                                byteBuffer2.putShort(s15);
                                byteBuffer2.putShort(s10);
                                byteBuffer2.putShort(s11);
                                byteBuffer2.putShort(s12);
                                byteBuffer2.putShort(s13);
                                byteBuffer2.putShort(s16);
                                byteBuffer2.putShort(s17);
                                byteBuffer2.putShort((short) (unsignedInt / Renderer.DEFAULT_DURATION_TO_PROGRESS_US));
                                byteBuffer2.putShort((short) (unsignedInt2 / Renderer.DEFAULT_DURATION_TO_PROGRESS_US));
                                byteBufferAllocateHdrStaticInfo = byteBuffer2;
                                iIsoColorPrimariesToColorSpace = iIsoColorPrimariesToColorSpace;
                                i26 = i60;
                                i25 = i61;
                                iIsoTransferCharacteristicsToColorTransfer = iIsoTransferCharacteristicsToColorTransfer;
                                listM5275r = list2;
                            } else {
                                i16 = i52;
                                i17 = unsignedShort2;
                                i18 = iIntValue;
                                i25 = i25;
                                list = listM5275r;
                                i26 = i26;
                                if (i32 == 1681012275) {
                                    ExtractorUtil.checkContainerInput(str2 == null, null);
                                    str2 = str3;
                                } else if (i32 == 1702061171) {
                                    ExtractorUtil.checkContainerInput(str2 == null, null);
                                    esdsFromParent = parseEsdsFromParent(parsableByteArray, position2);
                                    String str10 = esdsFromParent.mimeType;
                                    byte[] bArr2 = esdsFromParent.initializationData;
                                    listM5275r = bArr2 != null ? AbstractC2301u1.m5275r(bArr2) : list;
                                    str2 = str10;
                                } else if (i32 == 1651798644) {
                                    btrtFromParent = parseBtrtFromParent(parsableByteArray, position2);
                                } else {
                                    if (i32 == 1885434736) {
                                        paspFromParent = parsePaspFromParent(parsableByteArray, position2);
                                        iIsoColorPrimariesToColorSpace = iIsoColorPrimariesToColorSpace;
                                        i26 = i26;
                                        i25 = i25;
                                        iIsoTransferCharacteristicsToColorTransfer = iIsoTransferCharacteristicsToColorTransfer;
                                        listM5275r = list;
                                        z7 = true;
                                    } else if (i32 == 1937126244) {
                                        projFromParent = parseProjFromParent(parsableByteArray, position2, i31);
                                    } else if (i32 == 1936995172) {
                                        int unsignedByte6 = parsableByteArray.readUnsignedByte();
                                        parsableByteArray.skipBytes(3);
                                        if (unsignedByte6 != 0) {
                                            i20 = i16;
                                        } else {
                                            int unsignedByte7 = parsableByteArray.readUnsignedByte();
                                            if (unsignedByte7 == 0) {
                                                i20 = 0;
                                            } else if (unsignedByte7 == 1) {
                                                i20 = 1;
                                            } else if (unsignedByte7 == 2) {
                                                i20 = 2;
                                            } else if (unsignedByte7 != 3) {
                                                i20 = i16;
                                            } else {
                                                i20 = 3;
                                            }
                                        }
                                        i26 = i26;
                                        i25 = i25;
                                        iIsoTransferCharacteristicsToColorTransfer = iIsoTransferCharacteristicsToColorTransfer;
                                        listM5275r = list;
                                        h265VpsData = h265VpsData3;
                                        i27 = i20;
                                        iIsoColorPrimariesToColorSpace = iIsoColorPrimariesToColorSpace;
                                    } else if (i32 == 1634760259) {
                                        int i62 = i31 - 12;
                                        byte[] bArr3 = new byte[i62];
                                        parsableByteArray.setPosition(position2 + 12);
                                        parsableByteArray.readBytes(bArr3, 0, i62);
                                        listM5275r = AbstractC2301u1.m5275r(bArr3);
                                        ColorInfo apvc = parseApvc(new ParsableByteArray(bArr3));
                                        int i63 = apvc.lumaBitdepth;
                                        int i64 = apvc.chromaBitdepth;
                                        int i65 = apvc.colorSpace;
                                        int i66 = apvc.colorRange;
                                        iIsoTransferCharacteristicsToColorTransfer = apvc.colorTransfer;
                                        i25 = i63;
                                        i26 = i64;
                                        iIsoColorPrimariesToColorSpace = i65;
                                        i15 = i66;
                                        str2 = MimeTypes.VIDEO_APV;
                                        h265VpsData = h265VpsData3;
                                        i27 = i16;
                                    } else if (i32 == 1668246642) {
                                        i19 = iIsoTransferCharacteristicsToColorTransfer;
                                        if (iIsoColorPrimariesToColorSpace == -1 && i19 == -1) {
                                            int i67 = parsableByteArray.readInt();
                                            if (i67 == TYPE_nclx || i67 == TYPE_nclc) {
                                                int unsignedShort3 = parsableByteArray.readUnsignedShort();
                                                int unsignedShort4 = parsableByteArray.readUnsignedShort();
                                                parsableByteArray.skipBytes(2);
                                                boolean z11 = i31 == 19 && (parsableByteArray.readUnsignedByte() & 128) != 0;
                                                iIsoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace(unsignedShort3);
                                                i15 = z11 ? 1 : 2;
                                                i26 = i26;
                                                i25 = i25;
                                                listM5275r = list;
                                                iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(unsignedShort4);
                                            } else {
                                                Log.m1719w(TAG, "Unsupported color type: " + Mp4Box.getBoxTypeString(i67));
                                            }
                                        }
                                    } else {
                                        i19 = iIsoTransferCharacteristicsToColorTransfer;
                                    }
                                    h265VpsData = h265VpsData3;
                                    i27 = i16;
                                }
                                listM5275r = list;
                            }
                            h265VpsData = h265VpsData3;
                            i27 = i16;
                        }
                        iIsoColorPrimariesToColorSpace = iIsoColorPrimariesToColorSpace;
                        i26 = i26;
                        i25 = i25;
                        listM5275r = list;
                        iIsoTransferCharacteristicsToColorTransfer = i19;
                        h265VpsData = h265VpsData3;
                        i27 = i16;
                    }
                }
            }
            position += i31;
            i23 = i10;
            i24 = i11;
            stsdData2 = stsdData;
            str3 = str3;
            iIntValue = i18;
            drmInitDataCopyWithSchemeType = drmInitData2;
            i30 = i15;
            unsignedShort2 = i17;
        }
        DrmInitData drmInitData3 = drmInitDataCopyWithSchemeType;
        int i68 = unsignedShort2;
        int i69 = i25;
        List<byte[]> list3 = listM5275r;
        int i70 = i27;
        int i71 = iIsoColorPrimariesToColorSpace;
        int i72 = i30;
        int i73 = iIsoTransferCharacteristicsToColorTransfer;
        int i74 = i26;
        if (str2 == null) {
            return;
        }
        Format.Builder colorInfo = new Format.Builder().setId(i12).setSampleMimeType(str2).setCodecs(str4).setWidth(unsignedShort).setHeight(i68).setPixelWidthHeightRatio(paspFromParent).setRotationDegrees(i13).setProjectionData(projFromParent).setStereoMode(i70).setInitializationData(list3).setMaxNumReorderSamples(i28).setMaxSubLayers(i29).setDrmInitData(drmInitData3).setLanguage(str).setColorInfo(new ColorInfo.Builder().setColorSpace(i71).setColorRange(i72).setColorTransfer(i73).setHdrStaticInfo(byteBufferAllocateHdrStaticInfo != null ? byteBufferAllocateHdrStaticInfo.array() : null).setLumaBitdepth(i69).setChromaBitdepth(i74).build());
        if (btrtFromParent != null) {
            colorInfo.setAverageBitrate(AbstractC3612b.m7255K(btrtFromParent.avgBitrate)).setPeakBitrate(AbstractC3612b.m7255K(btrtFromParent.maxBitrate));
        } else if (esdsFromParent != null) {
            colorInfo.setAverageBitrate(AbstractC3612b.m7255K(esdsFromParent.bitrate)).setPeakBitrate(AbstractC3612b.m7255K(esdsFromParent.peakBitrate));
        }
        stsdData.format = colorInfo.build();
    }

    private static Metadata parseXyz(ParsableByteArray parsableByteArray) {
        short s10 = parsableByteArray.readShort();
        parsableByteArray.skipBytes(2);
        String string = parsableByteArray.readString(s10);
        int iMax = Math.max(string.lastIndexOf(43), string.lastIndexOf(45));
        try {
            return new Metadata(new Mp4LocationData(Float.parseFloat(string.substring(0, iMax)), Float.parseFloat(string.substring(iMax, string.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }
}

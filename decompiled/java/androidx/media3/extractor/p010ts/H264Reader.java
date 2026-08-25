package androidx.media3.extractor.p010ts;

import android.util.SparseArray;
import androidx.media3.common.C0565C;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.container.ParsableNalUnitBitArray;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import java.util.ArrayList;
import java.util.Arrays;

@UnstableApi
public final class H264Reader implements ElementaryStreamReader {
    private final boolean allowNonIdrKeyframes;
    private final String containerMimeType;
    private final boolean detectAccessUnits;
    private String formatId;
    private boolean hasOutputFormat;
    private TrackOutput output;
    private boolean randomAccessIndicator;
    private SampleReader sampleReader;
    private final SeiReader seiReader;
    private long totalBytesWritten;
    private final boolean[] prefixFlags = new boolean[3];
    private final NalUnitTargetBuffer sps = new NalUnitTargetBuffer(7, 128);
    private final NalUnitTargetBuffer pps = new NalUnitTargetBuffer(8, 128);
    private final NalUnitTargetBuffer sei = new NalUnitTargetBuffer(6, 128);
    private long pesTimeUs = C0565C.TIME_UNSET;
    private final ParsableByteArray seiWrapper = new ParsableByteArray();

    public static final class SampleReader {
        private static final int DEFAULT_BUFFER_SIZE = 128;
        private final boolean allowNonIdrKeyframes;
        private final ParsableNalUnitBitArray bitArray;
        private byte[] buffer;
        private int bufferLength;
        private final boolean detectAccessUnits;
        private boolean isFilling;
        private long nalUnitStartPosition;
        private long nalUnitTimeUs;
        private int nalUnitType;
        private final TrackOutput output;
        private SliceHeaderData previousSliceHeader;
        private boolean randomAccessIndicator;
        private boolean readingSample;
        private boolean sampleIsKeyframe;
        private long samplePosition;
        private long sampleTimeUs;
        private SliceHeaderData sliceHeader;
        private final SparseArray<NalUnitUtil.SpsData> sps = new SparseArray<>();
        private final SparseArray<NalUnitUtil.PpsData> pps = new SparseArray<>();

        public static final class SliceHeaderData {
            private static final int SLICE_TYPE_ALL_I = 7;
            private static final int SLICE_TYPE_I = 2;
            private boolean bottomFieldFlag;
            private boolean bottomFieldFlagPresent;
            private int deltaPicOrderCnt0;
            private int deltaPicOrderCnt1;
            private int deltaPicOrderCntBottom;
            private boolean fieldPicFlag;
            private int frameNum;
            private boolean hasSliceType;
            private boolean idrPicFlag;
            private int idrPicId;
            private boolean isComplete;
            private int nalRefIdc;
            private int picOrderCntLsb;
            private int picParameterSetId;
            private int sliceType;
            private NalUnitUtil.SpsData spsData;

            private SliceHeaderData() {
            }

            public boolean isFirstVclNalUnitOfPicture(SliceHeaderData sliceHeaderData) {
                int i6;
                int i10;
                int i11;
                boolean z7;
                if (!this.isComplete) {
                    return false;
                }
                if (!sliceHeaderData.isComplete) {
                    return true;
                }
                NalUnitUtil.SpsData spsData = (NalUnitUtil.SpsData) Assertions.checkStateNotNull(this.spsData);
                NalUnitUtil.SpsData spsData2 = (NalUnitUtil.SpsData) Assertions.checkStateNotNull(sliceHeaderData.spsData);
                return (this.frameNum == sliceHeaderData.frameNum && this.picParameterSetId == sliceHeaderData.picParameterSetId && this.fieldPicFlag == sliceHeaderData.fieldPicFlag && (!this.bottomFieldFlagPresent || !sliceHeaderData.bottomFieldFlagPresent || this.bottomFieldFlag == sliceHeaderData.bottomFieldFlag) && (((i6 = this.nalRefIdc) == (i10 = sliceHeaderData.nalRefIdc) || (i6 != 0 && i10 != 0)) && (((i11 = spsData.picOrderCountType) != 0 || spsData2.picOrderCountType != 0 || (this.picOrderCntLsb == sliceHeaderData.picOrderCntLsb && this.deltaPicOrderCntBottom == sliceHeaderData.deltaPicOrderCntBottom)) && ((i11 != 1 || spsData2.picOrderCountType != 1 || (this.deltaPicOrderCnt0 == sliceHeaderData.deltaPicOrderCnt0 && this.deltaPicOrderCnt1 == sliceHeaderData.deltaPicOrderCnt1)) && (z7 = this.idrPicFlag) == sliceHeaderData.idrPicFlag && (!z7 || this.idrPicId == sliceHeaderData.idrPicId))))) ? false : true;
            }

            public void clear() {
                this.hasSliceType = false;
                this.isComplete = false;
            }

            public boolean isISlice() {
                int i6;
                return this.hasSliceType && ((i6 = this.sliceType) == 7 || i6 == 2);
            }

            public void setAll(NalUnitUtil.SpsData spsData, int i6, int i10, int i11, int i12, boolean z7, boolean z10, boolean z11, boolean z12, int i13, int i14, int i15, int i16, int i17) {
                this.spsData = spsData;
                this.nalRefIdc = i6;
                this.sliceType = i10;
                this.frameNum = i11;
                this.picParameterSetId = i12;
                this.fieldPicFlag = z7;
                this.bottomFieldFlagPresent = z10;
                this.bottomFieldFlag = z11;
                this.idrPicFlag = z12;
                this.idrPicId = i13;
                this.picOrderCntLsb = i14;
                this.deltaPicOrderCntBottom = i15;
                this.deltaPicOrderCnt0 = i16;
                this.deltaPicOrderCnt1 = i17;
                this.isComplete = true;
                this.hasSliceType = true;
            }

            public void setSliceType(int i6) {
                this.sliceType = i6;
                this.hasSliceType = true;
            }
        }

        public SampleReader(TrackOutput trackOutput, boolean z7, boolean z10) {
            this.output = trackOutput;
            this.allowNonIdrKeyframes = z7;
            this.detectAccessUnits = z10;
            this.previousSliceHeader = new SliceHeaderData();
            this.sliceHeader = new SliceHeaderData();
            byte[] bArr = new byte[128];
            this.buffer = bArr;
            this.bitArray = new ParsableNalUnitBitArray(bArr, 0, 0);
            reset();
        }

        private void outputSample(int i6) {
            long j10 = this.sampleTimeUs;
            if (j10 != C0565C.TIME_UNSET) {
                long j11 = this.nalUnitStartPosition;
                long j12 = this.samplePosition;
                if (j11 == j12) {
                    return;
                }
                boolean z7 = this.sampleIsKeyframe;
                this.output.sampleMetadata(j10, z7 ? 1 : 0, (int) (j11 - j12), i6, null);
            }
        }

        private void setSampleIsKeyframe() {
            boolean zIsISlice = this.allowNonIdrKeyframes ? this.sliceHeader.isISlice() : this.randomAccessIndicator;
            boolean z7 = this.sampleIsKeyframe;
            int i6 = this.nalUnitType;
            boolean z10 = true;
            if (i6 != 5 && (!zIsISlice || i6 != 1)) {
                z10 = false;
            }
            this.sampleIsKeyframe = z7 | z10;
        }

        public void appendToNalUnit(byte[] bArr, int i6, int i10) {
            boolean z7;
            boolean z10;
            boolean bit;
            boolean z11;
            int unsignedExpGolombCodedInt;
            int i11;
            int i12;
            int i13;
            int signedExpGolombCodedInt;
            int signedExpGolombCodedInt2;
            int bits;
            if (this.isFilling) {
                int i14 = i10 - i6;
                byte[] bArr2 = this.buffer;
                int length = bArr2.length;
                int i15 = this.bufferLength;
                if (length < i15 + i14) {
                    this.buffer = Arrays.copyOf(bArr2, (i15 + i14) * 2);
                }
                System.arraycopy(bArr, i6, this.buffer, this.bufferLength, i14);
                int i16 = this.bufferLength + i14;
                this.bufferLength = i16;
                this.bitArray.reset(this.buffer, 0, i16);
                if (this.bitArray.canReadBits(8)) {
                    this.bitArray.skipBit();
                    int bits2 = this.bitArray.readBits(2);
                    this.bitArray.skipBits(5);
                    if (this.bitArray.canReadExpGolombCodedNum()) {
                        this.bitArray.readUnsignedExpGolombCodedInt();
                        if (this.bitArray.canReadExpGolombCodedNum()) {
                            int unsignedExpGolombCodedInt2 = this.bitArray.readUnsignedExpGolombCodedInt();
                            if (!this.detectAccessUnits) {
                                this.isFilling = false;
                                this.sliceHeader.setSliceType(unsignedExpGolombCodedInt2);
                                return;
                            }
                            if (this.bitArray.canReadExpGolombCodedNum()) {
                                int unsignedExpGolombCodedInt3 = this.bitArray.readUnsignedExpGolombCodedInt();
                                if (this.pps.indexOfKey(unsignedExpGolombCodedInt3) < 0) {
                                    this.isFilling = false;
                                    return;
                                }
                                NalUnitUtil.PpsData ppsData = this.pps.get(unsignedExpGolombCodedInt3);
                                NalUnitUtil.SpsData spsData = this.sps.get(ppsData.seqParameterSetId);
                                if (spsData.separateColorPlaneFlag) {
                                    if (!this.bitArray.canReadBits(2)) {
                                        return;
                                    } else {
                                        this.bitArray.skipBits(2);
                                    }
                                }
                                if (this.bitArray.canReadBits(spsData.frameNumLength)) {
                                    int bits3 = this.bitArray.readBits(spsData.frameNumLength);
                                    if (!spsData.frameMbsOnlyFlag) {
                                        if (this.bitArray.canReadBits(1)) {
                                            boolean bit2 = this.bitArray.readBit();
                                            if (!bit2) {
                                                z7 = bit2;
                                            } else {
                                                if (!this.bitArray.canReadBits(1)) {
                                                    return;
                                                }
                                                z7 = bit2;
                                                bit = this.bitArray.readBit();
                                                z10 = true;
                                            }
                                            if (this.nalUnitType == 5) {
                                                z11 = true;
                                            } else {
                                                z11 = false;
                                            }
                                            if (z11) {
                                                unsignedExpGolombCodedInt = 0;
                                            } else if (!this.bitArray.canReadExpGolombCodedNum()) {
                                                return;
                                            } else {
                                                unsignedExpGolombCodedInt = this.bitArray.readUnsignedExpGolombCodedInt();
                                            }
                                            i11 = spsData.picOrderCountType;
                                            if (i11 != 0) {
                                                if (this.bitArray.canReadBits(spsData.picOrderCntLsbLength)) {
                                                    bits = this.bitArray.readBits(spsData.picOrderCntLsbLength);
                                                    if (ppsData.bottomFieldPicOrderInFramePresentFlag || z7) {
                                                        i12 = bits;
                                                    } else {
                                                        if (!this.bitArray.canReadExpGolombCodedNum()) {
                                                            return;
                                                        }
                                                        signedExpGolombCodedInt = this.bitArray.readSignedExpGolombCodedInt();
                                                        i12 = bits;
                                                    }
                                                    i13 = 0;
                                                    signedExpGolombCodedInt2 = 0;
                                                    this.sliceHeader.setAll(spsData, bits2, unsignedExpGolombCodedInt2, bits3, unsignedExpGolombCodedInt3, z7, z10, bit, z11, unsignedExpGolombCodedInt, i12, signedExpGolombCodedInt, i13, signedExpGolombCodedInt2);
                                                    this.isFilling = false;
                                                }
                                                return;
                                            }
                                            if (i11 == 1 || spsData.deltaPicOrderAlwaysZeroFlag) {
                                                i12 = 0;
                                            } else {
                                                if (!this.bitArray.canReadExpGolombCodedNum()) {
                                                    return;
                                                }
                                                int signedExpGolombCodedInt3 = this.bitArray.readSignedExpGolombCodedInt();
                                                if (!ppsData.bottomFieldPicOrderInFramePresentFlag || z7) {
                                                    i13 = signedExpGolombCodedInt3;
                                                    i12 = 0;
                                                    signedExpGolombCodedInt = 0;
                                                    signedExpGolombCodedInt2 = 0;
                                                } else {
                                                    if (!this.bitArray.canReadExpGolombCodedNum()) {
                                                        return;
                                                    }
                                                    signedExpGolombCodedInt2 = this.bitArray.readSignedExpGolombCodedInt();
                                                    i13 = signedExpGolombCodedInt3;
                                                    i12 = 0;
                                                    signedExpGolombCodedInt = 0;
                                                }
                                            }
                                            this.sliceHeader.setAll(spsData, bits2, unsignedExpGolombCodedInt2, bits3, unsignedExpGolombCodedInt3, z7, z10, bit, z11, unsignedExpGolombCodedInt, i12, signedExpGolombCodedInt, i13, signedExpGolombCodedInt2);
                                            this.isFilling = false;
                                            signedExpGolombCodedInt = 0;
                                            i13 = 0;
                                            signedExpGolombCodedInt2 = 0;
                                            this.sliceHeader.setAll(spsData, bits2, unsignedExpGolombCodedInt2, bits3, unsignedExpGolombCodedInt3, z7, z10, bit, z11, unsignedExpGolombCodedInt, i12, signedExpGolombCodedInt, i13, signedExpGolombCodedInt2);
                                            this.isFilling = false;
                                        }
                                        return;
                                    }
                                    z7 = false;
                                    z10 = false;
                                    bit = false;
                                    if (this.nalUnitType == 5) {
                                        z11 = true;
                                    } else {
                                        z11 = false;
                                    }
                                    if (z11) {
                                        unsignedExpGolombCodedInt = 0;
                                    } else if (!this.bitArray.canReadExpGolombCodedNum()) {
                                        return;
                                    } else {
                                        unsignedExpGolombCodedInt = this.bitArray.readUnsignedExpGolombCodedInt();
                                    }
                                    i11 = spsData.picOrderCountType;
                                    if (i11 != 0) {
                                        if (i11 == 1) {
                                        }
                                        i12 = 0;
                                    } else {
                                        if (this.bitArray.canReadBits(spsData.picOrderCntLsbLength)) {
                                            return;
                                        }
                                        bits = this.bitArray.readBits(spsData.picOrderCntLsbLength);
                                        if (ppsData.bottomFieldPicOrderInFramePresentFlag) {
                                        }
                                        i12 = bits;
                                    }
                                    signedExpGolombCodedInt = 0;
                                    i13 = 0;
                                    signedExpGolombCodedInt2 = 0;
                                    this.sliceHeader.setAll(spsData, bits2, unsignedExpGolombCodedInt2, bits3, unsignedExpGolombCodedInt3, z7, z10, bit, z11, unsignedExpGolombCodedInt, i12, signedExpGolombCodedInt, i13, signedExpGolombCodedInt2);
                                    this.isFilling = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        public boolean endNalUnit(long j10, int i6, boolean z7) {
            if (this.nalUnitType == 9 || (this.detectAccessUnits && this.sliceHeader.isFirstVclNalUnitOfPicture(this.previousSliceHeader))) {
                if (z7 && this.readingSample) {
                    outputSample(i6 + ((int) (j10 - this.nalUnitStartPosition)));
                }
                this.samplePosition = this.nalUnitStartPosition;
                this.sampleTimeUs = this.nalUnitTimeUs;
                this.sampleIsKeyframe = false;
                this.readingSample = true;
            }
            setSampleIsKeyframe();
            this.nalUnitType = 24;
            return this.sampleIsKeyframe;
        }

        public boolean needsSpsPps() {
            return this.detectAccessUnits;
        }

        public void putPps(NalUnitUtil.PpsData ppsData) {
            this.pps.append(ppsData.picParameterSetId, ppsData);
        }

        public void putSps(NalUnitUtil.SpsData spsData) {
            this.sps.append(spsData.seqParameterSetId, spsData);
        }

        public void reset() {
            this.isFilling = false;
            this.readingSample = false;
            this.sliceHeader.clear();
        }

        public void startNalUnit(long j10, int i6, long j11, boolean z7) {
            this.nalUnitType = i6;
            this.nalUnitTimeUs = j11;
            this.nalUnitStartPosition = j10;
            this.randomAccessIndicator = z7;
            if (!this.allowNonIdrKeyframes || i6 != 1) {
                if (!this.detectAccessUnits) {
                    return;
                }
                if (i6 != 5 && i6 != 1 && i6 != 2) {
                    return;
                }
            }
            SliceHeaderData sliceHeaderData = this.previousSliceHeader;
            this.previousSliceHeader = this.sliceHeader;
            this.sliceHeader = sliceHeaderData;
            sliceHeaderData.clear();
            this.bufferLength = 0;
            this.isFilling = true;
        }
    }

    public H264Reader(SeiReader seiReader, boolean z7, boolean z10, String str) {
        this.seiReader = seiReader;
        this.allowNonIdrKeyframes = z7;
        this.detectAccessUnits = z10;
        this.containerMimeType = str;
    }

    private void assertTracksCreated() {
        Assertions.checkStateNotNull(this.output);
        Util.castNonNull(this.sampleReader);
    }

    private void endNalUnit(long j10, int i6, int i10, long j11) {
        if (!this.hasOutputFormat || this.sampleReader.needsSpsPps()) {
            this.sps.endNalUnit(i10);
            this.pps.endNalUnit(i10);
            if (this.hasOutputFormat) {
                if (this.sps.isCompleted()) {
                    NalUnitTargetBuffer nalUnitTargetBuffer = this.sps;
                    NalUnitUtil.SpsData spsNalUnit = NalUnitUtil.parseSpsNalUnit(nalUnitTargetBuffer.nalData, 3, nalUnitTargetBuffer.nalLength);
                    this.seiReader.setReorderingQueueSize(spsNalUnit.maxNumReorderFrames);
                    this.sampleReader.putSps(spsNalUnit);
                    this.sps.reset();
                } else if (this.pps.isCompleted()) {
                    NalUnitTargetBuffer nalUnitTargetBuffer2 = this.pps;
                    this.sampleReader.putPps(NalUnitUtil.parsePpsNalUnit(nalUnitTargetBuffer2.nalData, 3, nalUnitTargetBuffer2.nalLength));
                    this.pps.reset();
                }
            } else if (this.sps.isCompleted() && this.pps.isCompleted()) {
                ArrayList arrayList = new ArrayList();
                NalUnitTargetBuffer nalUnitTargetBuffer3 = this.sps;
                arrayList.add(Arrays.copyOf(nalUnitTargetBuffer3.nalData, nalUnitTargetBuffer3.nalLength));
                NalUnitTargetBuffer nalUnitTargetBuffer4 = this.pps;
                arrayList.add(Arrays.copyOf(nalUnitTargetBuffer4.nalData, nalUnitTargetBuffer4.nalLength));
                NalUnitTargetBuffer nalUnitTargetBuffer5 = this.sps;
                NalUnitUtil.SpsData spsNalUnit2 = NalUnitUtil.parseSpsNalUnit(nalUnitTargetBuffer5.nalData, 3, nalUnitTargetBuffer5.nalLength);
                NalUnitTargetBuffer nalUnitTargetBuffer6 = this.pps;
                NalUnitUtil.PpsData ppsNalUnit = NalUnitUtil.parsePpsNalUnit(nalUnitTargetBuffer6.nalData, 3, nalUnitTargetBuffer6.nalLength);
                this.output.format(new Format.Builder().setId(this.formatId).setContainerMimeType(this.containerMimeType).setSampleMimeType(MimeTypes.VIDEO_H264).setCodecs(CodecSpecificDataUtil.buildAvcCodecString(spsNalUnit2.profileIdc, spsNalUnit2.constraintsFlagsAndReservedZero2Bits, spsNalUnit2.levelIdc)).setWidth(spsNalUnit2.width).setHeight(spsNalUnit2.height).setColorInfo(new ColorInfo.Builder().setColorSpace(spsNalUnit2.colorSpace).setColorRange(spsNalUnit2.colorRange).setColorTransfer(spsNalUnit2.colorTransfer).setLumaBitdepth(spsNalUnit2.bitDepthLumaMinus8 + 8).setChromaBitdepth(spsNalUnit2.bitDepthChromaMinus8 + 8).build()).setPixelWidthHeightRatio(spsNalUnit2.pixelWidthHeightRatio).setInitializationData(arrayList).setMaxNumReorderSamples(spsNalUnit2.maxNumReorderFrames).build());
                this.hasOutputFormat = true;
                this.seiReader.setReorderingQueueSize(spsNalUnit2.maxNumReorderFrames);
                this.sampleReader.putSps(spsNalUnit2);
                this.sampleReader.putPps(ppsNalUnit);
                this.sps.reset();
                this.pps.reset();
            }
        }
        if (this.sei.endNalUnit(i10)) {
            NalUnitTargetBuffer nalUnitTargetBuffer7 = this.sei;
            this.seiWrapper.reset(this.sei.nalData, NalUnitUtil.unescapeStream(nalUnitTargetBuffer7.nalData, nalUnitTargetBuffer7.nalLength));
            this.seiWrapper.setPosition(4);
            this.seiReader.consume(j11, this.seiWrapper);
        }
        if (this.sampleReader.endNalUnit(j10, i6, this.hasOutputFormat)) {
            this.randomAccessIndicator = false;
        }
    }

    private void nalUnitData(byte[] bArr, int i6, int i10) {
        if (!this.hasOutputFormat || this.sampleReader.needsSpsPps()) {
            this.sps.appendToNalUnit(bArr, i6, i10);
            this.pps.appendToNalUnit(bArr, i6, i10);
        }
        this.sei.appendToNalUnit(bArr, i6, i10);
        this.sampleReader.appendToNalUnit(bArr, i6, i10);
    }

    private void startNalUnit(long j10, int i6, long j11) {
        if (!this.hasOutputFormat || this.sampleReader.needsSpsPps()) {
            this.sps.startNalUnit(i6);
            this.pps.startNalUnit(i6);
        }
        this.sei.startNalUnit(i6);
        this.sampleReader.startNalUnit(j10, i6, j11, this.randomAccessIndicator);
    }

    @Override
    public void consume(ParsableByteArray parsableByteArray) {
        int i6;
        int i10;
        assertTracksCreated();
        int position = parsableByteArray.getPosition();
        int iLimit = parsableByteArray.limit();
        byte[] data = parsableByteArray.getData();
        this.totalBytesWritten += (long) parsableByteArray.bytesLeft();
        this.output.sampleData(parsableByteArray, parsableByteArray.bytesLeft());
        while (true) {
            int iFindNalUnit = NalUnitUtil.findNalUnit(data, position, iLimit, this.prefixFlags);
            if (iFindNalUnit == iLimit) {
                nalUnitData(data, position, iLimit);
                return;
            }
            int nalUnitType = NalUnitUtil.getNalUnitType(data, iFindNalUnit);
            if (iFindNalUnit <= 0 || data[iFindNalUnit - 1] != 0) {
                i6 = iFindNalUnit;
                i10 = 3;
            } else {
                i6 = iFindNalUnit - 1;
                i10 = 4;
            }
            int i11 = i6 - position;
            if (i11 > 0) {
                nalUnitData(data, position, i6);
            }
            int i12 = iLimit - i6;
            long j10 = this.totalBytesWritten - ((long) i12);
            endNalUnit(j10, i12, i11 < 0 ? -i11 : 0, this.pesTimeUs);
            startNalUnit(j10, nalUnitType, this.pesTimeUs);
            position = i6 + i10;
        }
    }

    @Override
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        TrackOutput trackOutputTrack = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        this.output = trackOutputTrack;
        this.sampleReader = new SampleReader(trackOutputTrack, this.allowNonIdrKeyframes, this.detectAccessUnits);
        this.seiReader.createTracks(extractorOutput, trackIdGenerator);
    }

    @Override
    public void packetFinished(boolean z7) {
        assertTracksCreated();
        if (z7) {
            this.seiReader.flush();
            endNalUnit(this.totalBytesWritten, 0, 0, this.pesTimeUs);
            startNalUnit(this.totalBytesWritten, 9, this.pesTimeUs);
            endNalUnit(this.totalBytesWritten, 0, 0, this.pesTimeUs);
        }
    }

    @Override
    public void packetStarted(long j10, int i6) {
        this.pesTimeUs = j10;
        this.randomAccessIndicator |= (i6 & 2) != 0;
    }

    @Override
    public void seek() {
        this.totalBytesWritten = 0L;
        this.randomAccessIndicator = false;
        this.pesTimeUs = C0565C.TIME_UNSET;
        NalUnitUtil.clearPrefixFlags(this.prefixFlags);
        this.sps.reset();
        this.pps.reset();
        this.sei.reset();
        this.seiReader.clear();
        SampleReader sampleReader = this.sampleReader;
        if (sampleReader != null) {
            sampleReader.reset();
        }
    }
}

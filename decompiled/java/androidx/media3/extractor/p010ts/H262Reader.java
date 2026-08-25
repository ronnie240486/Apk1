package androidx.media3.extractor.p010ts;

import android.util.Pair;
import androidx.media3.common.C0565C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import java.util.Arrays;
import java.util.Collections;

@UnstableApi
public final class H262Reader implements ElementaryStreamReader {
    private static final double[] FRAME_RATE_VALUES = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private static final int START_EXTENSION = 181;
    private static final int START_GROUP = 184;
    private static final int START_PICTURE = 0;
    private static final int START_SEQUENCE_HEADER = 179;
    private static final int START_USER_DATA = 178;
    private final String containerMimeType;
    private final CsdBuffer csdBuffer;
    private String formatId;
    private long frameDurationUs;
    private boolean hasOutputFormat;
    private TrackOutput output;
    private long pesTimeUs;
    private final boolean[] prefixFlags;
    private boolean sampleHasPicture;
    private boolean sampleIsKeyframe;
    private long samplePosition;
    private long sampleTimeUs;
    private boolean startedFirstSample;
    private long totalBytesWritten;
    private final NalUnitTargetBuffer userData;
    private final ParsableByteArray userDataParsable;
    private final UserDataReader userDataReader;

    public static final class CsdBuffer {
        private static final byte[] START_CODE = {0, 0, 1};
        public byte[] data;
        private boolean isFilling;
        public int length;
        public int sequenceExtensionPosition;

        public CsdBuffer(int i6) {
            this.data = new byte[i6];
        }

        public void onData(byte[] bArr, int i6, int i10) {
            if (this.isFilling) {
                int i11 = i10 - i6;
                byte[] bArr2 = this.data;
                int length = bArr2.length;
                int i12 = this.length;
                if (length < i12 + i11) {
                    this.data = Arrays.copyOf(bArr2, (i12 + i11) * 2);
                }
                System.arraycopy(bArr, i6, this.data, this.length, i11);
                this.length += i11;
            }
        }

        public boolean onStartCode(int i6, int i10) {
            if (this.isFilling) {
                int i11 = this.length - i10;
                this.length = i11;
                if (this.sequenceExtensionPosition != 0 || i6 != 181) {
                    this.isFilling = false;
                    return true;
                }
                this.sequenceExtensionPosition = i11;
            } else if (i6 == H262Reader.START_SEQUENCE_HEADER) {
                this.isFilling = true;
            }
            byte[] bArr = START_CODE;
            onData(bArr, 0, bArr.length);
            return false;
        }

        public void reset() {
            this.isFilling = false;
            this.length = 0;
            this.sequenceExtensionPosition = 0;
        }
    }

    public H262Reader(String str) {
        this(null, str);
    }

    private static Pair<Format, Long> parseCsdBuffer(CsdBuffer csdBuffer, String str, String str2) {
        float f;
        int i6;
        float f3;
        int i10;
        long j10;
        double[] dArr;
        double d;
        int i11;
        int i12;
        byte[] bArrCopyOf = Arrays.copyOf(csdBuffer.data, csdBuffer.length);
        int i13 = bArrCopyOf[4] & 255;
        byte b8 = bArrCopyOf[5];
        int i14 = (i13 << 4) | ((b8 & 255) >> 4);
        int i15 = ((b8 & 15) << 8) | (bArrCopyOf[6] & 255);
        int i16 = (bArrCopyOf[7] & 240) >> 4;
        if (i16 == 2) {
            f = i15 * 4;
            i6 = i14 * 3;
        } else {
            if (i16 != 3) {
                if (i16 != 4) {
                    f3 = 1.0f;
                } else {
                    f = i15 * 121;
                    i6 = i14 * 100;
                }
                Format formatBuild = new Format.Builder().setId(str).setContainerMimeType(str2).setSampleMimeType(MimeTypes.VIDEO_MPEG2).setWidth(i14).setHeight(i15).setPixelWidthHeightRatio(f3).setInitializationData(Collections.singletonList(bArrCopyOf)).build();
                i10 = (bArrCopyOf[7] & 15) - 1;
                if (i10 >= 0) {
                    dArr = FRAME_RATE_VALUES;
                    if (i10 < dArr.length) {
                        d = dArr[i10];
                        byte b10 = bArrCopyOf[csdBuffer.sequenceExtensionPosition + 9];
                        i11 = (b10 & 96) >> 5;
                        i12 = b10 & 31;
                        if (i11 != i12) {
                            d *= (((double) i11) + 1.0d) / ((double) (i12 + 1));
                        }
                        j10 = (long) (1000000.0d / d);
                    } else {
                        j10 = 0;
                    }
                } else {
                    j10 = 0;
                }
                return Pair.create(formatBuild, Long.valueOf(j10));
            }
            f = i15 * 16;
            i6 = i14 * 9;
        }
        f3 = f / i6;
        Format formatBuild2 = new Format.Builder().setId(str).setContainerMimeType(str2).setSampleMimeType(MimeTypes.VIDEO_MPEG2).setWidth(i14).setHeight(i15).setPixelWidthHeightRatio(f3).setInitializationData(Collections.singletonList(bArrCopyOf)).build();
        i10 = (bArrCopyOf[7] & 15) - 1;
        if (i10 >= 0) {
            dArr = FRAME_RATE_VALUES;
            if (i10 < dArr.length) {
                d = dArr[i10];
                byte b11 = bArrCopyOf[csdBuffer.sequenceExtensionPosition + 9];
                i11 = (b11 & 96) >> 5;
                i12 = b11 & 31;
                if (i11 != i12) {
                    d *= (((double) i11) + 1.0d) / ((double) (i12 + 1));
                }
                j10 = (long) (1000000.0d / d);
            } else {
                j10 = 0;
            }
        } else {
            j10 = 0;
        }
        return Pair.create(formatBuild2, Long.valueOf(j10));
    }

    @Override
    public void consume(ParsableByteArray parsableByteArray) {
        int i6;
        Assertions.checkStateNotNull(this.output);
        int position = parsableByteArray.getPosition();
        int iLimit = parsableByteArray.limit();
        byte[] data = parsableByteArray.getData();
        this.totalBytesWritten += (long) parsableByteArray.bytesLeft();
        this.output.sampleData(parsableByteArray, parsableByteArray.bytesLeft());
        while (true) {
            int iFindNalUnit = NalUnitUtil.findNalUnit(data, position, iLimit, this.prefixFlags);
            if (iFindNalUnit == iLimit) {
                break;
            }
            int i10 = iFindNalUnit + 3;
            int i11 = parsableByteArray.getData()[i10] & 255;
            int i12 = iFindNalUnit - position;
            if (!this.hasOutputFormat) {
                if (i12 > 0) {
                    this.csdBuffer.onData(data, position, iFindNalUnit);
                }
                if (this.csdBuffer.onStartCode(i11, i12 < 0 ? -i12 : 0)) {
                    Pair<Format, Long> csdBuffer = parseCsdBuffer(this.csdBuffer, (String) Assertions.checkNotNull(this.formatId), this.containerMimeType);
                    this.output.format((Format) csdBuffer.first);
                    this.frameDurationUs = ((Long) csdBuffer.second).longValue();
                    this.hasOutputFormat = true;
                }
            }
            NalUnitTargetBuffer nalUnitTargetBuffer = this.userData;
            if (nalUnitTargetBuffer != null) {
                if (i12 > 0) {
                    nalUnitTargetBuffer.appendToNalUnit(data, position, iFindNalUnit);
                    i6 = 0;
                } else {
                    i6 = -i12;
                }
                if (this.userData.endNalUnit(i6)) {
                    NalUnitTargetBuffer nalUnitTargetBuffer2 = this.userData;
                    ((ParsableByteArray) Util.castNonNull(this.userDataParsable)).reset(this.userData.nalData, NalUnitUtil.unescapeStream(nalUnitTargetBuffer2.nalData, nalUnitTargetBuffer2.nalLength));
                    ((UserDataReader) Util.castNonNull(this.userDataReader)).consume(this.sampleTimeUs, this.userDataParsable);
                }
                if (i11 == 178 && parsableByteArray.getData()[iFindNalUnit + 2] == 1) {
                    this.userData.startNalUnit(i11);
                }
            }
            if (i11 == 0 || i11 == START_SEQUENCE_HEADER) {
                int i13 = iLimit - iFindNalUnit;
                if (this.sampleHasPicture && this.hasOutputFormat) {
                    long j10 = this.sampleTimeUs;
                    if (j10 != C0565C.TIME_UNSET) {
                        this.output.sampleMetadata(j10, this.sampleIsKeyframe ? 1 : 0, ((int) (this.totalBytesWritten - this.samplePosition)) - i13, i13, null);
                    }
                }
                if (!this.startedFirstSample || this.sampleHasPicture) {
                    this.samplePosition = this.totalBytesWritten - ((long) i13);
                    long j11 = this.pesTimeUs;
                    if (j11 == C0565C.TIME_UNSET) {
                        long j12 = this.sampleTimeUs;
                        j11 = j12 != C0565C.TIME_UNSET ? j12 + this.frameDurationUs : -9223372036854775807L;
                    }
                    this.sampleTimeUs = j11;
                    this.sampleIsKeyframe = false;
                    this.pesTimeUs = C0565C.TIME_UNSET;
                    this.startedFirstSample = true;
                }
                this.sampleHasPicture = i11 == 0;
            } else if (i11 == 184) {
                this.sampleIsKeyframe = true;
            }
            position = i10;
        }
        if (!this.hasOutputFormat) {
            this.csdBuffer.onData(data, position, iLimit);
        }
        NalUnitTargetBuffer nalUnitTargetBuffer3 = this.userData;
        if (nalUnitTargetBuffer3 != null) {
            nalUnitTargetBuffer3.appendToNalUnit(data, position, iLimit);
        }
    }

    @Override
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        UserDataReader userDataReader = this.userDataReader;
        if (userDataReader != null) {
            userDataReader.createTracks(extractorOutput, trackIdGenerator);
        }
    }

    @Override
    public void packetFinished(boolean z7) {
        Assertions.checkStateNotNull(this.output);
        if (z7) {
            boolean z10 = this.sampleIsKeyframe;
            this.output.sampleMetadata(this.sampleTimeUs, z10 ? 1 : 0, (int) (this.totalBytesWritten - this.samplePosition), 0, null);
        }
    }

    @Override
    public void packetStarted(long j10, int i6) {
        this.pesTimeUs = j10;
    }

    @Override
    public void seek() {
        NalUnitUtil.clearPrefixFlags(this.prefixFlags);
        this.csdBuffer.reset();
        NalUnitTargetBuffer nalUnitTargetBuffer = this.userData;
        if (nalUnitTargetBuffer != null) {
            nalUnitTargetBuffer.reset();
        }
        this.totalBytesWritten = 0L;
        this.startedFirstSample = false;
        this.pesTimeUs = C0565C.TIME_UNSET;
        this.sampleTimeUs = C0565C.TIME_UNSET;
    }

    public H262Reader(UserDataReader userDataReader, String str) {
        this.userDataReader = userDataReader;
        this.containerMimeType = str;
        this.prefixFlags = new boolean[4];
        this.csdBuffer = new CsdBuffer(128);
        if (userDataReader != null) {
            this.userData = new NalUnitTargetBuffer(178, 128);
            this.userDataParsable = new ParsableByteArray();
        } else {
            this.userData = null;
            this.userDataParsable = null;
        }
        this.pesTimeUs = C0565C.TIME_UNSET;
        this.sampleTimeUs = C0565C.TIME_UNSET;
    }
}

package androidx.media3.extractor.mkv;

import android.util.Pair;
import android.util.SparseArray;
import androidx.media3.common.C0565C;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DataReader;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.LongArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.AbstractC1009b;
import androidx.media3.extractor.AvcConfig;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.DolbyVisionConfig;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.HevcConfig;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.TrueHdSampleRechunker;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractorOutput;
import com.alibaba.fastjson.asm.Opcodes;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import p005a4.C0060s;
import p041d7.AbstractC2301u1;
import p041d7.C2180c5;

@UnstableApi
public class MatroskaExtractor implements Extractor {
    private static final int BLOCK_ADDITIONAL_ID_VP9_ITU_T_35 = 4;
    private static final int BLOCK_ADD_ID_TYPE_DVCC = 1685480259;
    private static final int BLOCK_ADD_ID_TYPE_DVVC = 1685485123;
    private static final int BLOCK_STATE_DATA = 2;
    private static final int BLOCK_STATE_HEADER = 1;
    private static final int BLOCK_STATE_START = 0;
    private static final String CODEC_ID_AAC = "A_AAC";
    private static final String CODEC_ID_AC3 = "A_AC3";
    private static final String CODEC_ID_ACM = "A_MS/ACM";
    private static final String CODEC_ID_ASS = "S_TEXT/ASS";
    private static final String CODEC_ID_AV1 = "V_AV1";
    private static final String CODEC_ID_DTS = "A_DTS";
    private static final String CODEC_ID_DTS_EXPRESS = "A_DTS/EXPRESS";
    private static final String CODEC_ID_DTS_LOSSLESS = "A_DTS/LOSSLESS";
    private static final String CODEC_ID_DVBSUB = "S_DVBSUB";
    private static final String CODEC_ID_E_AC3 = "A_EAC3";
    private static final String CODEC_ID_FLAC = "A_FLAC";
    private static final String CODEC_ID_FOURCC = "V_MS/VFW/FOURCC";
    private static final String CODEC_ID_H264 = "V_MPEG4/ISO/AVC";
    private static final String CODEC_ID_H265 = "V_MPEGH/ISO/HEVC";
    private static final String CODEC_ID_MP2 = "A_MPEG/L2";
    private static final String CODEC_ID_MP3 = "A_MPEG/L3";
    private static final String CODEC_ID_MPEG2 = "V_MPEG2";
    private static final String CODEC_ID_MPEG4_AP = "V_MPEG4/ISO/AP";
    private static final String CODEC_ID_MPEG4_ASP = "V_MPEG4/ISO/ASP";
    private static final String CODEC_ID_MPEG4_SP = "V_MPEG4/ISO/SP";
    private static final String CODEC_ID_OPUS = "A_OPUS";
    private static final String CODEC_ID_PCM_FLOAT = "A_PCM/FLOAT/IEEE";
    private static final String CODEC_ID_PCM_INT_BIG = "A_PCM/INT/BIG";
    private static final String CODEC_ID_PCM_INT_LIT = "A_PCM/INT/LIT";
    private static final String CODEC_ID_PGS = "S_HDMV/PGS";
    private static final String CODEC_ID_SUBRIP = "S_TEXT/UTF8";
    private static final String CODEC_ID_THEORA = "V_THEORA";
    private static final String CODEC_ID_TRUEHD = "A_TRUEHD";
    private static final String CODEC_ID_VOBSUB = "S_VOBSUB";
    private static final String CODEC_ID_VORBIS = "A_VORBIS";
    private static final String CODEC_ID_VP8 = "V_VP8";
    private static final String CODEC_ID_VP9 = "V_VP9";
    private static final String CODEC_ID_VTT = "S_TEXT/WEBVTT";
    private static final String DOC_TYPE_MATROSKA = "matroska";
    private static final String DOC_TYPE_WEBM = "webm";
    private static final int ENCRYPTION_IV_SIZE = 8;
    public static final int FLAG_DISABLE_SEEK_FOR_CUES = 1;
    public static final int FLAG_EMIT_RAW_SUBTITLE_DATA = 2;
    private static final int FOURCC_COMPRESSION_DIVX = 1482049860;
    private static final int FOURCC_COMPRESSION_H263 = 859189832;
    private static final int FOURCC_COMPRESSION_VC1 = 826496599;
    private static final int ID_AUDIO = 225;
    private static final int ID_AUDIO_BIT_DEPTH = 25188;
    private static final int ID_BLOCK = 161;
    private static final int ID_BLOCK_ADDITIONAL = 165;
    private static final int ID_BLOCK_ADDITIONS = 30113;
    private static final int ID_BLOCK_ADDITION_MAPPING = 16868;
    private static final int ID_BLOCK_ADD_ID = 238;
    private static final int ID_BLOCK_ADD_ID_EXTRA_DATA = 16877;
    private static final int ID_BLOCK_ADD_ID_TYPE = 16871;
    private static final int ID_BLOCK_DURATION = 155;
    private static final int ID_BLOCK_GROUP = 160;
    private static final int ID_BLOCK_MORE = 166;
    private static final int ID_CHANNELS = 159;
    private static final int ID_CLUSTER = 524531317;
    private static final int ID_CODEC_DELAY = 22186;
    private static final int ID_CODEC_ID = 134;
    private static final int ID_CODEC_PRIVATE = 25506;
    private static final int ID_COLOUR = 21936;
    private static final int ID_COLOUR_BITS_PER_CHANNEL = 21938;
    private static final int ID_COLOUR_PRIMARIES = 21947;
    private static final int ID_COLOUR_RANGE = 21945;
    private static final int ID_COLOUR_TRANSFER = 21946;
    private static final int ID_CONTENT_COMPRESSION = 20532;
    private static final int ID_CONTENT_COMPRESSION_ALGORITHM = 16980;
    private static final int ID_CONTENT_COMPRESSION_SETTINGS = 16981;
    private static final int ID_CONTENT_ENCODING = 25152;
    private static final int ID_CONTENT_ENCODINGS = 28032;
    private static final int ID_CONTENT_ENCODING_ORDER = 20529;
    private static final int ID_CONTENT_ENCODING_SCOPE = 20530;
    private static final int ID_CONTENT_ENCRYPTION = 20533;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS = 18407;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE = 18408;
    private static final int ID_CONTENT_ENCRYPTION_ALGORITHM = 18401;
    private static final int ID_CONTENT_ENCRYPTION_KEY_ID = 18402;
    private static final int ID_CUES = 475249515;
    private static final int ID_CUE_CLUSTER_POSITION = 241;
    private static final int ID_CUE_POINT = 187;
    private static final int ID_CUE_TIME = 179;
    private static final int ID_CUE_TRACK_POSITIONS = 183;
    private static final int ID_DEFAULT_DURATION = 2352003;
    private static final int ID_DISCARD_PADDING = 30114;
    private static final int ID_DISPLAY_HEIGHT = 21690;
    private static final int ID_DISPLAY_UNIT = 21682;
    private static final int ID_DISPLAY_WIDTH = 21680;
    private static final int ID_DOC_TYPE = 17026;
    private static final int ID_DOC_TYPE_READ_VERSION = 17029;
    private static final int ID_DURATION = 17545;
    private static final int ID_EBML = 440786851;
    private static final int ID_EBML_READ_VERSION = 17143;
    private static final int ID_FLAG_DEFAULT = 136;
    private static final int ID_FLAG_FORCED = 21930;
    private static final int ID_INFO = 357149030;
    private static final int ID_LANGUAGE = 2274716;
    private static final int ID_LUMNINANCE_MAX = 21977;
    private static final int ID_LUMNINANCE_MIN = 21978;
    private static final int ID_MASTERING_METADATA = 21968;
    private static final int ID_MAX_BLOCK_ADDITION_ID = 21998;
    private static final int ID_MAX_CLL = 21948;
    private static final int ID_MAX_FALL = 21949;
    private static final int ID_NAME = 21358;
    private static final int ID_PIXEL_HEIGHT = 186;
    private static final int ID_PIXEL_WIDTH = 176;
    private static final int ID_PRIMARY_B_CHROMATICITY_X = 21973;
    private static final int ID_PRIMARY_B_CHROMATICITY_Y = 21974;
    private static final int ID_PRIMARY_G_CHROMATICITY_X = 21971;
    private static final int ID_PRIMARY_G_CHROMATICITY_Y = 21972;
    private static final int ID_PRIMARY_R_CHROMATICITY_X = 21969;
    private static final int ID_PRIMARY_R_CHROMATICITY_Y = 21970;
    private static final int ID_PROJECTION = 30320;
    private static final int ID_PROJECTION_POSE_PITCH = 30324;
    private static final int ID_PROJECTION_POSE_ROLL = 30325;
    private static final int ID_PROJECTION_POSE_YAW = 30323;
    private static final int ID_PROJECTION_PRIVATE = 30322;
    private static final int ID_PROJECTION_TYPE = 30321;
    private static final int ID_REFERENCE_BLOCK = 251;
    private static final int ID_SAMPLING_FREQUENCY = 181;
    private static final int ID_SEEK = 19899;
    private static final int ID_SEEK_HEAD = 290298740;
    private static final int ID_SEEK_ID = 21419;
    private static final int ID_SEEK_POSITION = 21420;
    private static final int ID_SEEK_PRE_ROLL = 22203;
    private static final int ID_SEGMENT = 408125543;
    private static final int ID_SEGMENT_INFO = 357149030;
    private static final int ID_SIMPLE_BLOCK = 163;
    private static final int ID_STEREO_MODE = 21432;
    private static final int ID_TIMECODE_SCALE = 2807729;
    private static final int ID_TIME_CODE = 231;
    private static final int ID_TRACKS = 374648427;
    private static final int ID_TRACK_ENTRY = 174;
    private static final int ID_TRACK_NUMBER = 215;
    private static final int ID_TRACK_TYPE = 131;
    private static final int ID_VIDEO = 224;
    private static final int ID_WHITE_POINT_CHROMATICITY_X = 21975;
    private static final int ID_WHITE_POINT_CHROMATICITY_Y = 21976;
    private static final int LACING_EBML = 3;
    private static final int LACING_FIXED_SIZE = 2;
    private static final int LACING_NONE = 0;
    private static final int LACING_XIPH = 1;
    private static final int OPUS_MAX_INPUT_SIZE = 5760;
    private static final int SSA_PREFIX_END_TIMECODE_OFFSET = 21;
    private static final String SSA_TIMECODE_FORMAT = "%01d:%02d:%02d:%02d";
    private static final long SSA_TIMECODE_LAST_VALUE_SCALING_FACTOR = 10000;
    private static final int SUBRIP_PREFIX_END_TIMECODE_OFFSET = 19;
    private static final String SUBRIP_TIMECODE_FORMAT = "%02d:%02d:%02d,%03d";
    private static final long SUBRIP_TIMECODE_LAST_VALUE_SCALING_FACTOR = 1000;
    private static final String TAG = "MatroskaExtractor";
    private static final Map<String, Integer> TRACK_NAME_TO_ROTATION_DEGREES;
    private static final int TRACK_TYPE_AUDIO = 2;
    private static final int UNSET_ENTRY_ID = -1;
    private static final int VORBIS_MAX_INPUT_SIZE = 8192;
    private static final int VTT_PREFIX_END_TIMECODE_OFFSET = 25;
    private static final String VTT_TIMECODE_FORMAT = "%02d:%02d:%02d.%03d";
    private static final long VTT_TIMECODE_LAST_VALUE_SCALING_FACTOR = 1000;
    private static final int WAVE_FORMAT_EXTENSIBLE = 65534;
    private static final int WAVE_FORMAT_PCM = 1;
    private static final int WAVE_FORMAT_SIZE = 18;
    private int blockAdditionalId;
    private long blockDurationUs;
    private int blockFlags;
    private long blockGroupDiscardPaddingNs;
    private boolean blockHasReferenceBlock;
    private int blockSampleCount;
    private int blockSampleIndex;
    private int[] blockSampleSizes;
    private int blockState;
    private long blockTimeUs;
    private int blockTrackNumber;
    private int blockTrackNumberLength;
    private long clusterTimecodeUs;
    private LongArray cueClusterPositions;
    private LongArray cueTimesUs;
    private long cuesContentPosition;
    private Track currentTrack;
    private long durationTimecode;
    private long durationUs;
    private final ParsableByteArray encryptionInitializationVector;
    private final ParsableByteArray encryptionSubsampleData;
    private ByteBuffer encryptionSubsampleDataBuffer;
    private ExtractorOutput extractorOutput;
    private boolean haveOutputSample;
    private boolean isWebm;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private final boolean parseSubtitlesDuringExtraction;
    private final EbmlReader reader;
    private int sampleBytesRead;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private boolean sampleEncodingHandled;
    private boolean sampleInitializationVectorRead;
    private int samplePartitionCount;
    private boolean samplePartitionCountRead;
    private byte sampleSignalByte;
    private boolean sampleSignalByteRead;
    private final ParsableByteArray sampleStrippedBytes;
    private final ParsableByteArray scratch;
    private int seekEntryId;
    private final ParsableByteArray seekEntryIdBytes;
    private long seekEntryPosition;
    private boolean seekForCues;
    private final boolean seekForCuesEnabled;
    private long seekPositionAfterBuildingCues;
    private boolean seenClusterPositionForCurrentCuePoint;
    private long segmentContentPosition;
    private long segmentContentSize;
    private boolean sentSeekMap;
    private final SubtitleParser.Factory subtitleParserFactory;
    private final ParsableByteArray subtitleSample;
    private final ParsableByteArray supplementalData;
    private long timecodeScale;
    private final SparseArray<Track> tracks;
    private final VarintReader varintReader;
    private final ParsableByteArray vorbisNumPageSamples;

    @Deprecated
    public static final ExtractorsFactory FACTORY = new C0060s(13);
    private static final byte[] SUBRIP_PREFIX = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] SSA_DIALOGUE_FORMAT = Util.getUtf8Bytes("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] SSA_PREFIX = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final byte[] VTT_PREFIX = {87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
    private static final UUID WAVE_SUBFORMAT_PCM = new UUID(72057594037932032L, -9223371306706625679L);

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public final class InnerEbmlProcessor implements EbmlProcessor {
        private InnerEbmlProcessor() {
        }

        @Override
        public void binaryElement(int i6, int i10, ExtractorInput extractorInput) throws IOException {
            MatroskaExtractor.this.binaryElement(i6, i10, extractorInput);
        }

        @Override
        public void endMasterElement(int i6) throws ParserException {
            MatroskaExtractor.this.endMasterElement(i6);
        }

        @Override
        public void floatElement(int i6, double d) throws ParserException {
            MatroskaExtractor.this.floatElement(i6, d);
        }

        @Override
        public int getElementType(int i6) {
            return MatroskaExtractor.this.getElementType(i6);
        }

        @Override
        public void integerElement(int i6, long j10) throws ParserException {
            MatroskaExtractor.this.integerElement(i6, j10);
        }

        @Override
        public boolean isLevel1Element(int i6) {
            return MatroskaExtractor.this.isLevel1Element(i6);
        }

        @Override
        public void startMasterElement(int i6, long j10, long j11) throws ParserException {
            MatroskaExtractor.this.startMasterElement(i6, j10, j11);
        }

        @Override
        public void stringElement(int i6, String str) throws ParserException {
            MatroskaExtractor.this.stringElement(i6, str);
        }
    }

    public static final class Track {
        private static final int DEFAULT_MAX_CLL = 1000;
        private static final int DEFAULT_MAX_FALL = 200;
        private static final int DISPLAY_UNIT_PIXELS = 0;
        private static final int MAX_CHROMATICITY = 50000;
        private int blockAddIdType;
        public String codecId;
        public byte[] codecPrivate;
        public TrackOutput.CryptoData cryptoData;
        public int defaultSampleDurationNs;
        public byte[] dolbyVisionConfigBytes;
        public DrmInitData drmInitData;
        public boolean flagForced;
        public boolean hasContentEncryption;
        public boolean isWebm;
        public int maxBlockAdditionId;
        public int nalUnitLengthFieldLength;
        public String name;
        public int number;
        public TrackOutput output;
        public byte[] sampleStrippedBytes;
        public TrueHdSampleRechunker trueHdSampleRechunker;
        public int type;
        public int width = -1;
        public int height = -1;
        public int bitsPerChannel = -1;
        public int displayWidth = -1;
        public int displayHeight = -1;
        public int displayUnit = 0;
        public int projectionType = -1;
        public float projectionPoseYaw = 0.0f;
        public float projectionPosePitch = 0.0f;
        public float projectionPoseRoll = 0.0f;
        public byte[] projectionData = null;
        public int stereoMode = -1;
        public boolean hasColorInfo = false;
        public int colorSpace = -1;
        public int colorTransfer = -1;
        public int colorRange = -1;
        public int maxContentLuminance = 1000;
        public int maxFrameAverageLuminance = 200;
        public float primaryRChromaticityX = -1.0f;
        public float primaryRChromaticityY = -1.0f;
        public float primaryGChromaticityX = -1.0f;
        public float primaryGChromaticityY = -1.0f;
        public float primaryBChromaticityX = -1.0f;
        public float primaryBChromaticityY = -1.0f;
        public float whitePointChromaticityX = -1.0f;
        public float whitePointChromaticityY = -1.0f;
        public float maxMasteringLuminance = -1.0f;
        public float minMasteringLuminance = -1.0f;
        public int channelCount = 1;
        public int audioBitDepth = -1;
        public int sampleRate = 8000;
        public long codecDelayNs = 0;
        public long seekPreRollNs = 0;
        public boolean flagDefault = true;
        private String language = "eng";

        public void assertOutputInitialized() {
            Assertions.checkNotNull(this.output);
        }

        private byte[] getCodecPrivate(String str) throws ParserException {
            byte[] bArr = this.codecPrivate;
            if (bArr != null) {
                return bArr;
            }
            throw ParserException.createForMalformedContainer("Missing CodecPrivate for codec " + str, null);
        }

        private byte[] getHdrStaticInfo() {
            if (this.primaryRChromaticityX == -1.0f || this.primaryRChromaticityY == -1.0f || this.primaryGChromaticityX == -1.0f || this.primaryGChromaticityY == -1.0f || this.primaryBChromaticityX == -1.0f || this.primaryBChromaticityY == -1.0f || this.whitePointChromaticityX == -1.0f || this.whitePointChromaticityY == -1.0f || this.maxMasteringLuminance == -1.0f || this.minMasteringLuminance == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.put((byte) 0);
            byteBufferOrder.putShort((short) ((this.primaryRChromaticityX * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.primaryRChromaticityY * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.primaryGChromaticityX * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.primaryGChromaticityY * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.primaryBChromaticityX * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.primaryBChromaticityY * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.whitePointChromaticityX * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.whitePointChromaticityY * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) (this.maxMasteringLuminance + 0.5f));
            byteBufferOrder.putShort((short) (this.minMasteringLuminance + 0.5f));
            byteBufferOrder.putShort((short) this.maxContentLuminance);
            byteBufferOrder.putShort((short) this.maxFrameAverageLuminance);
            return bArr;
        }

        private static Pair<String, List<byte[]>> parseFourCcPrivate(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                parsableByteArray.skipBytes(16);
                long littleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
                if (littleEndianUnsignedInt == 1482049860) {
                    return new Pair<>(MimeTypes.VIDEO_DIVX, null);
                }
                if (littleEndianUnsignedInt == 859189832) {
                    return new Pair<>(MimeTypes.VIDEO_H263, null);
                }
                if (littleEndianUnsignedInt != 826496599) {
                    Log.m1719w(MatroskaExtractor.TAG, "Unknown FourCC. Setting mimeType to video/x-unknown");
                    return new Pair<>(MimeTypes.VIDEO_UNKNOWN, null);
                }
                byte[] data = parsableByteArray.getData();
                for (int position = parsableByteArray.getPosition() + 20; position < data.length - 4; position++) {
                    if (data[position] == 0 && data[position + 1] == 0 && data[position + 2] == 1 && data[position + 3] == 15) {
                        return new Pair<>(MimeTypes.VIDEO_VC1, Collections.singletonList(Arrays.copyOfRange(data, position, data.length)));
                    }
                }
                throw ParserException.createForMalformedContainer("Failed to find FourCC VC1 initialization data", null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing FourCC private data", null);
            }
        }

        private static boolean parseMsAcmCodecPrivate(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                int littleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
                if (littleEndianUnsignedShort == 1) {
                    return true;
                }
                if (littleEndianUnsignedShort != 65534) {
                    return false;
                }
                parsableByteArray.setPosition(24);
                return parsableByteArray.readLong() == MatroskaExtractor.WAVE_SUBFORMAT_PCM.getMostSignificantBits() && parsableByteArray.readLong() == MatroskaExtractor.WAVE_SUBFORMAT_PCM.getLeastSignificantBits();
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing MS/ACM codec private", null);
            }
        }

        private static List<byte[]> parseVorbisCodecPrivate(byte[] bArr) throws ParserException {
            int i6;
            int i10;
            try {
                if (bArr[0] != 2) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                int i11 = 1;
                int i12 = 0;
                while (true) {
                    i6 = bArr[i11];
                    if ((i6 & 255) != 255) {
                        break;
                    }
                    i12 += 255;
                    i11++;
                }
                int i13 = i11 + 1;
                int i14 = i12 + (i6 & 255);
                int i15 = 0;
                while (true) {
                    i10 = bArr[i13];
                    if ((i10 & 255) != 255) {
                        break;
                    }
                    i15 += 255;
                    i13++;
                }
                int i16 = i13 + 1;
                int i17 = i15 + (i10 & 255);
                if (bArr[i16] != 1) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                byte[] bArr2 = new byte[i14];
                System.arraycopy(bArr, i16, bArr2, 0, i14);
                int i18 = i16 + i14;
                if (bArr[i18] != 3) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                int i19 = i18 + i17;
                if (bArr[i19] != 5) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                byte[] bArr3 = new byte[bArr.length - i19];
                System.arraycopy(bArr, i19, bArr3, 0, bArr.length - i19);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
            }
        }

        public boolean samplesHaveSupplementalData(boolean z7) {
            if (MatroskaExtractor.CODEC_ID_OPUS.equals(this.codecId)) {
                return z7;
            }
            return this.maxBlockAdditionId > 0;
        }

        public void initializeOutput(ExtractorOutput extractorOutput, int i6) throws ParserException {
            int i10;
            List<byte[]> list;
            String str;
            int i11;
            List<byte[]> list2;
            int i12;
            List<byte[]> list3;
            List<byte[]> list4;
            List<byte[]> list5;
            String str2;
            List<byte[]> list6;
            List<byte[]> list7;
            List<byte[]> list8;
            String str3;
            int i13;
            Format.Builder builder;
            int i14;
            int iIntValue;
            int i15;
            float f;
            int i16;
            int i17;
            int i18;
            String str4;
            DolbyVisionConfig dolbyVisionConfig;
            String str5 = this.codecId;
            str5.getClass();
            String str6 = MimeTypes.AUDIO_RAW;
            switch (str5) {
                case "V_MPEG4/ISO/AP":
                case "V_MPEG4/ISO/SP":
                case "V_MPEG4/ISO/ASP":
                    i10 = 0;
                    byte[] bArr = this.codecPrivate;
                    List<byte[]> listSingletonList = bArr == null ? null : Collections.singletonList(bArr);
                    str6 = MimeTypes.VIDEO_MP4V;
                    list4 = listSingletonList;
                    str = null;
                    list = list4;
                    i11 = -1;
                    list2 = list;
                    i12 = -1;
                    list3 = list2;
                    if (this.dolbyVisionConfigBytes != null && (dolbyVisionConfig = DolbyVisionConfig.parse(new ParsableByteArray(this.dolbyVisionConfigBytes))) != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z7 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i19 = i13 | (z7 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    } else if (MimeTypes.isVideo(str3)) {
                        if (this.displayUnit == 0) {
                            i17 = this.displayWidth;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.width;
                            }
                            this.displayWidth = i17;
                            i18 = this.displayHeight;
                            if (i18 == -1) {
                                i18 = this.height;
                            }
                            this.displayHeight = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i15 = this.displayWidth;
                        if (i15 != iIntValue || (i16 = this.displayHeight) == iIntValue) {
                            f = -1.0f;
                        } else {
                            f = (this.height * i15) / (this.width * i16);
                        }
                        ColorInfo colorInfoBuild = this.hasColorInfo ? new ColorInfo.Builder().setColorSpace(this.colorSpace).setColorRange(this.colorRange).setColorTransfer(this.colorTransfer).setHdrStaticInfo(getHdrStaticInfo()).setLumaBitdepth(this.bitsPerChannel).setChromaBitdepth(this.bitsPerChannel).build() : null;
                        if (this.name != null && MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.containsKey(this.name)) {
                            iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                        }
                        if (this.projectionType == 0 || Float.compare(this.projectionPoseYaw, 0.0f) != 0 || Float.compare(this.projectionPosePitch, 0.0f) != 0) {
                            i10 = iIntValue;
                        } else if (Float.compare(this.projectionPoseRoll, 0.0f) != 0) {
                            if (Float.compare(this.projectionPoseRoll, 90.0f) == 0) {
                                i10 = 90;
                            } else if (Float.compare(this.projectionPoseRoll, -180.0f) == 0 || Float.compare(this.projectionPoseRoll, 180.0f) == 0) {
                                i10 = Opcodes.GETFIELD;
                            } else if (Float.compare(this.projectionPoseRoll, -90.0f) == 0) {
                                i10 = 270;
                            } else {
                                i10 = iIntValue;
                            }
                        }
                        builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                        i14 = 2;
                    } else {
                        if (MimeTypes.APPLICATION_SUBRIP.equals(str3) && !MimeTypes.TEXT_SSA.equals(str3) && !MimeTypes.TEXT_VTT.equals(str3) && !MimeTypes.APPLICATION_VOBSUB.equals(str3) && !MimeTypes.APPLICATION_PGS.equals(str3) && !MimeTypes.APPLICATION_DVBSUBS.equals(str3)) {
                            throw ParserException.createForMalformedContainer("Unexpected MIME type.", null);
                        }
                        i14 = 3;
                    }
                    if (this.name != null && !MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.containsKey(this.name)) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild = id.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i19).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack;
                    trackOutputTrack.format(formatBuild);
                    return;
                case "A_MS/ACM":
                    i10 = 0;
                    if (parseMsAcmCodecPrivate(new ParsableByteArray(getCodecPrivate(this.codecId)))) {
                        int pcmEncoding = Util.getPcmEncoding(this.audioBitDepth);
                        if (pcmEncoding == 0) {
                            Log.m1719w(MatroskaExtractor.TAG, "Unsupported PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to audio/x-unknown");
                        } else {
                            i11 = pcmEncoding;
                            list2 = null;
                            str = null;
                        }
                        i12 = -1;
                        list3 = list2;
                        if (this.dolbyVisionConfigBytes != null) {
                            str = dolbyVisionConfig.codecs;
                            str6 = MimeTypes.VIDEO_DOLBY_VISION;
                        }
                        str3 = str6;
                        boolean z10 = this.flagDefault;
                        if (this.flagForced) {
                            i13 = 2;
                        } else {
                            i13 = 0;
                        }
                        int i110 = i13 | (z10 ? 1 : 0);
                        builder = new Format.Builder();
                        if (MimeTypes.isAudio(str3)) {
                            if (MimeTypes.isVideo(str3)) {
                                if (this.displayUnit == 0) {
                                    i17 = this.displayWidth;
                                    iIntValue = -1;
                                    if (i17 == -1) {
                                        i17 = this.width;
                                    }
                                    this.displayWidth = i17;
                                    i18 = this.displayHeight;
                                    if (i18 == -1) {
                                        i18 = this.height;
                                    }
                                    this.displayHeight = i18;
                                } else {
                                    iIntValue = -1;
                                }
                                i15 = this.displayWidth;
                                if (i15 != iIntValue) {
                                    f = -1.0f;
                                } else {
                                    f = -1.0f;
                                }
                                if (this.hasColorInfo) {
                                }
                                if (this.name != null) {
                                    iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                                }
                                if (this.projectionType == 0) {
                                    i10 = iIntValue;
                                } else {
                                    i10 = iIntValue;
                                }
                                builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                                i14 = 2;
                            } else {
                                if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                                }
                                i14 = 3;
                            }
                            break;
                        } else {
                            builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                            i14 = 1;
                        }
                        if (this.name != null) {
                            builder.setLabel(this.name);
                        }
                        Format.Builder id2 = builder.setId(i6);
                        if (this.isWebm) {
                            str4 = MimeTypes.VIDEO_WEBM;
                        } else {
                            str4 = MimeTypes.VIDEO_MATROSKA;
                        }
                        Format formatBuild2 = id2.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i110).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                        TrackOutput trackOutputTrack2 = extractorOutput.track(this.number, i14);
                        this.output = trackOutputTrack2;
                        trackOutputTrack2.format(formatBuild2);
                        return;
                    }
                    Log.m1719w(MatroskaExtractor.TAG, "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                    list = null;
                    str = null;
                    str6 = MimeTypes.AUDIO_UNKNOWN;
                    i11 = -1;
                    list2 = list;
                    i12 = -1;
                    list3 = list2;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z11 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i111 = i13 | (z11 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id3 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild3 = id3.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i111).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack3 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack3;
                    trackOutputTrack3.format(formatBuild3);
                    return;
                case "A_TRUEHD":
                    i10 = 0;
                    this.trueHdSampleRechunker = new TrueHdSampleRechunker();
                    str6 = MimeTypes.AUDIO_TRUEHD;
                    list = null;
                    str = null;
                    i11 = -1;
                    list2 = list;
                    i12 = -1;
                    list3 = list2;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z12 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i112 = i13 | (z12 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id4 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild4 = id4.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i112).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack4 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack4;
                    trackOutputTrack4.format(formatBuild4);
                    return;
                case "A_VORBIS":
                    i10 = 0;
                    List<byte[]> vorbisCodecPrivate = parseVorbisCodecPrivate(getCodecPrivate(this.codecId));
                    str6 = MimeTypes.AUDIO_VORBIS;
                    i12 = 8192;
                    str = null;
                    i11 = -1;
                    list3 = vorbisCodecPrivate;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z13 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i113 = i13 | (z13 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id5 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild5 = id5.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i113).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack5 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack5;
                    trackOutputTrack5.format(formatBuild5);
                    return;
                case "A_MPEG/L2":
                    i10 = 0;
                    str6 = MimeTypes.AUDIO_MPEG_L2;
                    list3 = null;
                    str = null;
                    i11 = -1;
                    i12 = 4096;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z14 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i114 = i13 | (z14 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id6 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild6 = id6.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i114).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack6 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack6;
                    trackOutputTrack6.format(formatBuild6);
                    return;
                case "A_MPEG/L3":
                    i10 = 0;
                    str6 = MimeTypes.AUDIO_MPEG;
                    list3 = null;
                    str = null;
                    i11 = -1;
                    i12 = 4096;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z15 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i115 = i13 | (z15 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id7 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild7 = id7.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i115).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack7 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack7;
                    trackOutputTrack7.format(formatBuild7);
                    return;
                case "V_MS/VFW/FOURCC":
                    i10 = 0;
                    Pair<String, List<byte[]>> fourCcPrivate = parseFourCcPrivate(new ParsableByteArray(getCodecPrivate(this.codecId)));
                    str6 = (String) fourCcPrivate.first;
                    list4 = (List) fourCcPrivate.second;
                    str = null;
                    list = list4;
                    i11 = -1;
                    list2 = list;
                    i12 = -1;
                    list3 = list2;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z16 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i116 = i13 | (z16 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id8 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild8 = id8.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i116).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack8 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack8;
                    trackOutputTrack8.format(formatBuild8);
                    return;
                case "S_DVBSUB":
                    byte[] bArr2 = new byte[4];
                    i10 = 0;
                    System.arraycopy(getCodecPrivate(this.codecId), 0, bArr2, 0, 4);
                    C2180c5 c2180c5M5275r = AbstractC2301u1.m5275r(bArr2);
                    str6 = MimeTypes.APPLICATION_DVBSUBS;
                    list4 = c2180c5M5275r;
                    str = null;
                    list = list4;
                    i11 = -1;
                    list2 = list;
                    i12 = -1;
                    list3 = list2;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z17 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i117 = i13 | (z17 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id9 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild9 = id9.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i117).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack9 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack9;
                    trackOutputTrack9.format(formatBuild9);
                    return;
                case "V_MPEG4/ISO/AVC":
                    AvcConfig avcConfig = AvcConfig.parse(new ParsableByteArray(getCodecPrivate(this.codecId)));
                    list5 = avcConfig.initializationData;
                    this.nalUnitLengthFieldLength = avcConfig.nalUnitLengthFieldLength;
                    str2 = avcConfig.codecs;
                    str6 = MimeTypes.VIDEO_H264;
                    i11 = -1;
                    i10 = 0;
                    i12 = -1;
                    List<byte[]> list9 = list5;
                    str = str2;
                    list3 = list9;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z18 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i118 = i13 | (z18 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id10 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild10 = id10.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i118).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack10 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack10;
                    trackOutputTrack10.format(formatBuild10);
                    return;
                case "S_VOBSUB":
                    C2180c5 c2180c5M5275r2 = AbstractC2301u1.m5275r(getCodecPrivate(this.codecId));
                    str6 = MimeTypes.APPLICATION_VOBSUB;
                    list8 = c2180c5M5275r2;
                    str = null;
                    list7 = list8;
                    i11 = -1;
                    list6 = list7;
                    i10 = 0;
                    list2 = list6;
                    i12 = -1;
                    list3 = list2;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z19 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i119 = i13 | (z19 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id11 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild11 = id11.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i119).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack11 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack11;
                    trackOutputTrack11.format(formatBuild11);
                    return;
                case "A_DTS/LOSSLESS":
                    str6 = MimeTypes.AUDIO_DTS_HD;
                    list7 = null;
                    str = null;
                    i11 = -1;
                    list6 = list7;
                    i10 = 0;
                    list2 = list6;
                    i12 = -1;
                    list3 = list2;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z110 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i1110 = i13 | (z110 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id12 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild12 = id12.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i1110).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack12 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack12;
                    trackOutputTrack12.format(formatBuild12);
                    return;
                case "A_AAC":
                    List<byte[]> listSingletonList2 = Collections.singletonList(getCodecPrivate(this.codecId));
                    AacUtil.Config audioSpecificConfig = AacUtil.parseAudioSpecificConfig(this.codecPrivate);
                    this.sampleRate = audioSpecificConfig.sampleRateHz;
                    this.channelCount = audioSpecificConfig.channelCount;
                    str = audioSpecificConfig.codecs;
                    str6 = MimeTypes.AUDIO_AAC;
                    list7 = listSingletonList2;
                    i11 = -1;
                    list6 = list7;
                    i10 = 0;
                    list2 = list6;
                    i12 = -1;
                    list3 = list2;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z111 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i1111 = i13 | (z111 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id13 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild13 = id13.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i1111).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack13 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack13;
                    trackOutputTrack13.format(formatBuild13);
                    return;
                case "A_AC3":
                    str6 = MimeTypes.AUDIO_AC3;
                    list7 = null;
                    str = null;
                    i11 = -1;
                    list6 = list7;
                    i10 = 0;
                    list2 = list6;
                    i12 = -1;
                    list3 = list2;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z112 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i1112 = i13 | (z112 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id14 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild14 = id14.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i1112).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack14 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack14;
                    trackOutputTrack14.format(formatBuild14);
                    return;
                case "A_DTS":
                case "A_DTS/EXPRESS":
                    str6 = MimeTypes.AUDIO_DTS;
                    list7 = null;
                    str = null;
                    i11 = -1;
                    list6 = list7;
                    i10 = 0;
                    list2 = list6;
                    i12 = -1;
                    list3 = list2;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z113 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i1113 = i13 | (z113 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id15 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild15 = id15.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i1113).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack15 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack15;
                    trackOutputTrack15.format(formatBuild15);
                    return;
                case "V_AV1":
                    byte[] bArr3 = this.codecPrivate;
                    C2180c5 c2180c5M5275r3 = bArr3 == null ? null : AbstractC2301u1.m5275r(bArr3);
                    str6 = MimeTypes.VIDEO_AV1;
                    list8 = c2180c5M5275r3;
                    str = null;
                    list7 = list8;
                    i11 = -1;
                    list6 = list7;
                    i10 = 0;
                    list2 = list6;
                    i12 = -1;
                    list3 = list2;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z114 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i1114 = i13 | (z114 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id16 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild16 = id16.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i1114).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack16 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack16;
                    trackOutputTrack16.format(formatBuild16);
                    return;
                case "V_VP8":
                    str6 = MimeTypes.VIDEO_VP8;
                    list7 = null;
                    str = null;
                    i11 = -1;
                    list6 = list7;
                    i10 = 0;
                    list2 = list6;
                    i12 = -1;
                    list3 = list2;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z115 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i1115 = i13 | (z115 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id17 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild17 = id17.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i1115).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack17 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack17;
                    trackOutputTrack17.format(formatBuild17);
                    return;
                case "V_VP9":
                    byte[] bArr4 = this.codecPrivate;
                    C2180c5 c2180c5M5275r4 = bArr4 == null ? null : AbstractC2301u1.m5275r(bArr4);
                    str6 = MimeTypes.VIDEO_VP9;
                    list8 = c2180c5M5275r4;
                    str = null;
                    list7 = list8;
                    i11 = -1;
                    list6 = list7;
                    i10 = 0;
                    list2 = list6;
                    i12 = -1;
                    list3 = list2;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z116 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i1116 = i13 | (z116 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id18 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild18 = id18.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i1116).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack18 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack18;
                    trackOutputTrack18.format(formatBuild18);
                    return;
                case "S_HDMV/PGS":
                    str6 = MimeTypes.APPLICATION_PGS;
                    list7 = null;
                    str = null;
                    i11 = -1;
                    list6 = list7;
                    i10 = 0;
                    list2 = list6;
                    i12 = -1;
                    list3 = list2;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z117 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i1117 = i13 | (z117 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id19 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild19 = id19.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i1117).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack19 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack19;
                    trackOutputTrack19.format(formatBuild19);
                    return;
                case "V_THEORA":
                    str6 = MimeTypes.VIDEO_UNKNOWN;
                    list7 = null;
                    str = null;
                    i11 = -1;
                    list6 = list7;
                    i10 = 0;
                    list2 = list6;
                    i12 = -1;
                    list3 = list2;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z118 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i1118 = i13 | (z118 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id110 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild110 = id110.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i1118).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack110 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack110;
                    trackOutputTrack110.format(formatBuild110);
                    return;
                case "A_PCM/FLOAT/IEEE":
                    if (this.audioBitDepth == 32) {
                        list6 = null;
                        str = null;
                        i11 = 4;
                    } else {
                        Log.m1719w(MatroskaExtractor.TAG, "Unsupported floating point PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to audio/x-unknown");
                        list7 = null;
                        str = null;
                        str6 = MimeTypes.AUDIO_UNKNOWN;
                        i11 = -1;
                        list6 = list7;
                    }
                    i10 = 0;
                    list2 = list6;
                    i12 = -1;
                    list3 = list2;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z119 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i1119 = i13 | (z119 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id111 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild111 = id111.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i1119).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack111 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack111;
                    trackOutputTrack111.format(formatBuild111);
                    return;
                case "A_PCM/INT/BIG":
                    int i20 = this.audioBitDepth;
                    if (i20 == 8) {
                        list6 = null;
                        str = null;
                        i11 = 3;
                    } else if (i20 == 16) {
                        list6 = null;
                        str = null;
                        i11 = 268435456;
                    } else if (i20 == 24) {
                        list6 = null;
                        str = null;
                        i11 = C0565C.ENCODING_PCM_24BIT_BIG_ENDIAN;
                    } else if (i20 == 32) {
                        list6 = null;
                        str = null;
                        i11 = C0565C.ENCODING_PCM_32BIT_BIG_ENDIAN;
                    } else {
                        Log.m1719w(MatroskaExtractor.TAG, "Unsupported big endian PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to audio/x-unknown");
                        list7 = null;
                        str = null;
                        str6 = MimeTypes.AUDIO_UNKNOWN;
                        i11 = -1;
                        list6 = list7;
                    }
                    i10 = 0;
                    list2 = list6;
                    i12 = -1;
                    list3 = list2;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z1110 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i11110 = i13 | (z1110 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id112 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild112 = id112.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i11110).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack112 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack112;
                    trackOutputTrack112.format(formatBuild112);
                    return;
                case "A_PCM/INT/LIT":
                    int pcmEncoding2 = Util.getPcmEncoding(this.audioBitDepth);
                    if (pcmEncoding2 == 0) {
                        Log.m1719w(MatroskaExtractor.TAG, "Unsupported little endian PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to audio/x-unknown");
                        list7 = null;
                        str = null;
                        str6 = MimeTypes.AUDIO_UNKNOWN;
                        i11 = -1;
                        list6 = list7;
                    } else {
                        i11 = pcmEncoding2;
                        list6 = null;
                        str = null;
                    }
                    i10 = 0;
                    list2 = list6;
                    i12 = -1;
                    list3 = list2;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z1111 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i11111 = i13 | (z1111 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id113 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild113 = id113.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i11111).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack113 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack113;
                    trackOutputTrack113.format(formatBuild113);
                    return;
                case "S_TEXT/ASS":
                    C2180c5 c2180c5M5276s = AbstractC2301u1.m5276s(MatroskaExtractor.SSA_DIALOGUE_FORMAT, getCodecPrivate(this.codecId));
                    str6 = MimeTypes.TEXT_SSA;
                    list8 = c2180c5M5276s;
                    str = null;
                    list7 = list8;
                    i11 = -1;
                    list6 = list7;
                    i10 = 0;
                    list2 = list6;
                    i12 = -1;
                    list3 = list2;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z1112 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i11112 = i13 | (z1112 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id114 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild114 = id114.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i11112).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack114 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack114;
                    trackOutputTrack114.format(formatBuild114);
                    return;
                case "V_MPEGH/ISO/HEVC":
                    HevcConfig hevcConfig = HevcConfig.parse(new ParsableByteArray(getCodecPrivate(this.codecId)));
                    list5 = hevcConfig.initializationData;
                    this.nalUnitLengthFieldLength = hevcConfig.nalUnitLengthFieldLength;
                    str2 = hevcConfig.codecs;
                    str6 = MimeTypes.VIDEO_H265;
                    i11 = -1;
                    i10 = 0;
                    i12 = -1;
                    List<byte[]> list10 = list5;
                    str = str2;
                    list3 = list10;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z1113 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i11113 = i13 | (z1113 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id115 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild115 = id115.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i11113).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack115 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack115;
                    trackOutputTrack115.format(formatBuild115);
                    return;
                case "S_TEXT/WEBVTT":
                    str6 = MimeTypes.TEXT_VTT;
                    list7 = null;
                    str = null;
                    i11 = -1;
                    list6 = list7;
                    i10 = 0;
                    list2 = list6;
                    i12 = -1;
                    list3 = list2;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z1114 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i11114 = i13 | (z1114 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id116 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild116 = id116.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i11114).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack116 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack116;
                    trackOutputTrack116.format(formatBuild116);
                    return;
                case "S_TEXT/UTF8":
                    str6 = MimeTypes.APPLICATION_SUBRIP;
                    list7 = null;
                    str = null;
                    i11 = -1;
                    list6 = list7;
                    i10 = 0;
                    list2 = list6;
                    i12 = -1;
                    list3 = list2;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z1115 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i11115 = i13 | (z1115 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id117 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild117 = id117.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i11115).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack117 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack117;
                    trackOutputTrack117.format(formatBuild117);
                    return;
                case "V_MPEG2":
                    str6 = MimeTypes.VIDEO_MPEG2;
                    list7 = null;
                    str = null;
                    i11 = -1;
                    list6 = list7;
                    i10 = 0;
                    list2 = list6;
                    i12 = -1;
                    list3 = list2;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z1116 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i11116 = i13 | (z1116 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id118 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild118 = id118.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i11116).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack118 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack118;
                    trackOutputTrack118.format(formatBuild118);
                    return;
                case "A_EAC3":
                    str6 = MimeTypes.AUDIO_E_AC3;
                    list7 = null;
                    str = null;
                    i11 = -1;
                    list6 = list7;
                    i10 = 0;
                    list2 = list6;
                    i12 = -1;
                    list3 = list2;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z1117 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i11117 = i13 | (z1117 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id119 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild119 = id119.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i11117).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack119 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack119;
                    trackOutputTrack119.format(formatBuild119);
                    return;
                case "A_FLAC":
                    List<byte[]> listSingletonList3 = Collections.singletonList(getCodecPrivate(this.codecId));
                    str6 = MimeTypes.AUDIO_FLAC;
                    list8 = listSingletonList3;
                    str = null;
                    list7 = list8;
                    i11 = -1;
                    list6 = list7;
                    i10 = 0;
                    list2 = list6;
                    i12 = -1;
                    list3 = list2;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z1118 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i11118 = i13 | (z1118 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id1110 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild1110 = id1110.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i11118).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack1110 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack1110;
                    trackOutputTrack1110.format(formatBuild1110);
                    return;
                case "A_OPUS":
                    ArrayList arrayList = new ArrayList(3);
                    arrayList.add(getCodecPrivate(this.codecId));
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    arrayList.add(byteBufferAllocate.order(byteOrder).putLong(this.codecDelayNs).array());
                    arrayList.add(ByteBuffer.allocate(8).order(byteOrder).putLong(this.seekPreRollNs).array());
                    str6 = MimeTypes.AUDIO_OPUS;
                    i12 = MatroskaExtractor.OPUS_MAX_INPUT_SIZE;
                    str = null;
                    i11 = -1;
                    i10 = 0;
                    list3 = arrayList;
                    if (this.dolbyVisionConfigBytes != null) {
                        str = dolbyVisionConfig.codecs;
                        str6 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                    str3 = str6;
                    boolean z1119 = this.flagDefault;
                    if (this.flagForced) {
                        i13 = 2;
                    } else {
                        i13 = 0;
                    }
                    int i11119 = i13 | (z1119 ? 1 : 0);
                    builder = new Format.Builder();
                    if (MimeTypes.isAudio(str3)) {
                        if (MimeTypes.isVideo(str3)) {
                            if (this.displayUnit == 0) {
                                i17 = this.displayWidth;
                                iIntValue = -1;
                                if (i17 == -1) {
                                    i17 = this.width;
                                }
                                this.displayWidth = i17;
                                i18 = this.displayHeight;
                                if (i18 == -1) {
                                    i18 = this.height;
                                }
                                this.displayHeight = i18;
                            } else {
                                iIntValue = -1;
                            }
                            i15 = this.displayWidth;
                            if (i15 != iIntValue) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.hasColorInfo) {
                            }
                            if (this.name != null) {
                                iIntValue = ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                            }
                            if (this.projectionType == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i10).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(colorInfoBuild);
                            i14 = 2;
                        } else {
                            if (MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                            }
                            i14 = 3;
                        }
                        break;
                    } else {
                        builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i11);
                        i14 = 1;
                    }
                    if (this.name != null) {
                        builder.setLabel(this.name);
                    }
                    Format.Builder id1111 = builder.setId(i6);
                    if (this.isWebm) {
                        str4 = MimeTypes.VIDEO_WEBM;
                    } else {
                        str4 = MimeTypes.VIDEO_MATROSKA;
                    }
                    Format formatBuild1111 = id1111.setContainerMimeType(str4).setSampleMimeType(str3).setMaxInputSize(i12).setLanguage(this.language).setSelectionFlags(i11119).setInitializationData(list3).setCodecs(str).setDrmInitData(this.drmInitData).build();
                    TrackOutput trackOutputTrack1111 = extractorOutput.track(this.number, i14);
                    this.output = trackOutputTrack1111;
                    trackOutputTrack1111.format(formatBuild1111);
                    return;
                default:
                    throw ParserException.createForMalformedContainer("Unrecognized codec identifier.", null);
            }
        }

        public void outputPendingSampleMetadata() {
            TrueHdSampleRechunker trueHdSampleRechunker = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.outputPendingSampleMetadata(this.output, this.cryptoData);
            }
        }

        public void reset() {
            TrueHdSampleRechunker trueHdSampleRechunker = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.reset();
            }
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", Integer.valueOf(Opcodes.GETFIELD));
        map.put("htc_video_rotA-270", 270);
        TRACK_NAME_TO_ROTATION_DEGREES = Collections.unmodifiableMap(map);
    }

    @Deprecated
    public MatroskaExtractor() {
        this(new DefaultEbmlReader(), 2, SubtitleParser.Factory.UNSUPPORTED);
    }

    private void assertInCues(int i6) throws ParserException {
        if (this.cueTimesUs == null || this.cueClusterPositions == null) {
            throw ParserException.createForMalformedContainer("Element " + i6 + " must be in a Cues", null);
        }
    }

    private void assertInTrackEntry(int i6) throws ParserException {
        if (this.currentTrack != null) {
            return;
        }
        throw ParserException.createForMalformedContainer("Element " + i6 + " must be in a TrackEntry", null);
    }

    private void assertInitialized() {
        Assertions.checkStateNotNull(this.extractorOutput);
    }

    private SeekMap buildSeekMap(LongArray longArray, LongArray longArray2) {
        int i6;
        if (this.segmentContentPosition == -1 || this.durationUs == C0565C.TIME_UNSET || longArray == null || longArray.size() == 0 || longArray2 == null || longArray2.size() != longArray.size()) {
            return new SeekMap.Unseekable(this.durationUs);
        }
        int size = longArray.size();
        int[] iArrCopyOf = new int[size];
        long[] jArrCopyOf = new long[size];
        long[] jArrCopyOf2 = new long[size];
        long[] jArrCopyOf3 = new long[size];
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            jArrCopyOf3[i11] = longArray.get(i11);
            jArrCopyOf[i11] = longArray2.get(i11) + this.segmentContentPosition;
        }
        while (true) {
            i6 = size - 1;
            if (i10 >= i6) {
                break;
            }
            int i12 = i10 + 1;
            iArrCopyOf[i10] = (int) (jArrCopyOf[i12] - jArrCopyOf[i10]);
            jArrCopyOf2[i10] = jArrCopyOf3[i12] - jArrCopyOf3[i10];
            i10 = i12;
        }
        int i13 = i6;
        while (i13 > 0 && jArrCopyOf3[i13] > this.durationUs) {
            i13--;
        }
        iArrCopyOf[i13] = (int) ((this.segmentContentPosition + this.segmentContentSize) - jArrCopyOf[i13]);
        jArrCopyOf2[i13] = this.durationUs - jArrCopyOf3[i13];
        if (i13 < i6) {
            Log.m1719w(TAG, "Discarding trailing cue points with timestamps greater than total duration");
            int i14 = i13 + 1;
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, i14);
            jArrCopyOf = Arrays.copyOf(jArrCopyOf, i14);
            jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i14);
            jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i14);
        }
        return new ChunkIndex(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
    }

    private void commitSampleToOutput(Track track, long j10, int i6, int i10, int i11) {
        TrueHdSampleRechunker trueHdSampleRechunker = track.trueHdSampleRechunker;
        if (trueHdSampleRechunker != null) {
            trueHdSampleRechunker.sampleMetadata(track.output, j10, i6, i10, i11, track.cryptoData);
        } else {
            if (CODEC_ID_SUBRIP.equals(track.codecId) || CODEC_ID_ASS.equals(track.codecId) || CODEC_ID_VTT.equals(track.codecId)) {
                if (this.blockSampleCount > 1) {
                    Log.m1719w(TAG, "Skipping subtitle sample in laced block.");
                } else {
                    long j11 = this.blockDurationUs;
                    if (j11 == C0565C.TIME_UNSET) {
                        Log.m1719w(TAG, "Skipping subtitle sample with no duration.");
                    } else {
                        setSubtitleEndTime(track.codecId, j11, this.subtitleSample.getData());
                        for (int position = this.subtitleSample.getPosition(); position < this.subtitleSample.limit(); position++) {
                            if (this.subtitleSample.getData()[position] == 0) {
                                this.subtitleSample.setLimit(position);
                                break;
                            }
                        }
                        TrackOutput trackOutput = track.output;
                        ParsableByteArray parsableByteArray = this.subtitleSample;
                        trackOutput.sampleData(parsableByteArray, parsableByteArray.limit());
                        i10 += this.subtitleSample.limit();
                    }
                }
            }
            if ((268435456 & i6) != 0) {
                if (this.blockSampleCount > 1) {
                    this.supplementalData.reset(0);
                } else {
                    int iLimit = this.supplementalData.limit();
                    track.output.sampleData(this.supplementalData, iLimit, 2);
                    i10 += iLimit;
                }
            }
            track.output.sampleMetadata(j10, i6, i10, i11, track.cryptoData);
        }
        this.haveOutputSample = true;
    }

    private static int[] ensureArrayCapacity(int[] iArr, int i6) {
        if (iArr == null) {
            return new int[i6];
        }
        return iArr.length >= i6 ? iArr : new int[Math.max(iArr.length * 2, i6)];
    }

    private int finishWriteSampleData() {
        int i6 = this.sampleBytesWritten;
        resetWriteSampleData();
        return i6;
    }

    private static byte[] formatSubtitleTimecode(long j10, String str, long j11) {
        Assertions.checkArgument(j10 != C0565C.TIME_UNSET);
        int i6 = (int) (j10 / 3600000000L);
        long j12 = j10 - (((long) i6) * 3600000000L);
        int i10 = (int) (j12 / 60000000);
        long j13 = j12 - (((long) i10) * 60000000);
        int i11 = (int) (j13 / 1000000);
        return Util.getUtf8Bytes(String.format(Locale.US, str, Integer.valueOf(i6), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf((int) ((j13 - (((long) i11) * 1000000)) / j11))));
    }

    private static boolean isCodecSupported(String str) {
        str.getClass();
        switch (str) {
            case "V_MPEG4/ISO/AP":
            case "V_MPEG4/ISO/SP":
            case "A_MS/ACM":
            case "A_TRUEHD":
            case "A_VORBIS":
            case "A_MPEG/L2":
            case "A_MPEG/L3":
            case "V_MS/VFW/FOURCC":
            case "S_DVBSUB":
            case "V_MPEG4/ISO/ASP":
            case "V_MPEG4/ISO/AVC":
            case "S_VOBSUB":
            case "A_DTS/LOSSLESS":
            case "A_AAC":
            case "A_AC3":
            case "A_DTS":
            case "V_AV1":
            case "V_VP8":
            case "V_VP9":
            case "S_HDMV/PGS":
            case "V_THEORA":
            case "A_DTS/EXPRESS":
            case "A_PCM/FLOAT/IEEE":
            case "A_PCM/INT/BIG":
            case "A_PCM/INT/LIT":
            case "S_TEXT/ASS":
            case "V_MPEGH/ISO/HEVC":
            case "S_TEXT/WEBVTT":
            case "S_TEXT/UTF8":
            case "V_MPEG2":
            case "A_EAC3":
            case "A_FLAC":
            case "A_OPUS":
                return true;
            default:
                return false;
        }
    }

    public static Extractor[] lambda$newFactory$0(SubtitleParser.Factory factory) {
        return new Extractor[]{new MatroskaExtractor(factory)};
    }

    public static Extractor[] lambda$static$1() {
        return new Extractor[]{new MatroskaExtractor(SubtitleParser.Factory.UNSUPPORTED, 2)};
    }

    private boolean maybeSeekForCues(PositionHolder positionHolder, long j10) {
        if (this.seekForCues) {
            this.seekPositionAfterBuildingCues = j10;
            positionHolder.position = this.cuesContentPosition;
            this.seekForCues = false;
            return true;
        }
        if (this.sentSeekMap) {
            long j11 = this.seekPositionAfterBuildingCues;
            if (j11 != -1) {
                positionHolder.position = j11;
                this.seekPositionAfterBuildingCues = -1L;
                return true;
            }
        }
        return false;
    }

    public static ExtractorsFactory newFactory(SubtitleParser.Factory factory) {
        return new C1018a(factory, 0);
    }

    private void readScratch(ExtractorInput extractorInput, int i6) throws IOException {
        if (this.scratch.limit() >= i6) {
            return;
        }
        if (this.scratch.capacity() < i6) {
            ParsableByteArray parsableByteArray = this.scratch;
            parsableByteArray.ensureCapacity(Math.max(parsableByteArray.capacity() * 2, i6));
        }
        extractorInput.readFully(this.scratch.getData(), this.scratch.limit(), i6 - this.scratch.limit());
        this.scratch.setLimit(i6);
    }

    private void resetWriteSampleData() {
        this.sampleBytesRead = 0;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        this.sampleEncodingHandled = false;
        this.sampleSignalByteRead = false;
        this.samplePartitionCountRead = false;
        this.samplePartitionCount = 0;
        this.sampleSignalByte = (byte) 0;
        this.sampleInitializationVectorRead = false;
        this.sampleStrippedBytes.reset(0);
    }

    private long scaleTimecodeToUs(long j10) throws ParserException {
        long j11 = this.timecodeScale;
        if (j11 != C0565C.TIME_UNSET) {
            return Util.scaleLargeTimestamp(j10, j11, 1000L);
        }
        throw ParserException.createForMalformedContainer("Can't scale timecode prior to timecodeScale being set.", null);
    }

    private static void setSubtitleEndTime(String str, long j10, byte[] bArr) {
        byte[] subtitleTimecode;
        int i6;
        str.getClass();
        switch (str) {
            case "S_TEXT/ASS":
                subtitleTimecode = formatSubtitleTimecode(j10, SSA_TIMECODE_FORMAT, 10000L);
                i6 = 21;
                break;
            case "S_TEXT/WEBVTT":
                subtitleTimecode = formatSubtitleTimecode(j10, VTT_TIMECODE_FORMAT, 1000L);
                i6 = 25;
                break;
            case "S_TEXT/UTF8":
                subtitleTimecode = formatSubtitleTimecode(j10, SUBRIP_TIMECODE_FORMAT, 1000L);
                i6 = 19;
                break;
            default:
                throw new IllegalArgumentException();
        }
        System.arraycopy(subtitleTimecode, 0, bArr, i6, subtitleTimecode.length);
    }

    private int writeSampleData(ExtractorInput extractorInput, Track track, int i6, boolean z7) throws IOException {
        int i10;
        if (CODEC_ID_SUBRIP.equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, SUBRIP_PREFIX, i6);
            return finishWriteSampleData();
        }
        if (CODEC_ID_ASS.equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, SSA_PREFIX, i6);
            return finishWriteSampleData();
        }
        if (CODEC_ID_VTT.equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, VTT_PREFIX, i6);
            return finishWriteSampleData();
        }
        TrackOutput trackOutput = track.output;
        if (!this.sampleEncodingHandled) {
            if (track.hasContentEncryption) {
                this.blockFlags &= -1073741825;
                if (!this.sampleSignalByteRead) {
                    extractorInput.readFully(this.scratch.getData(), 0, 1);
                    this.sampleBytesRead++;
                    if ((this.scratch.getData()[0] & 128) == 128) {
                        throw ParserException.createForMalformedContainer("Extension bit is set in signal byte", null);
                    }
                    this.sampleSignalByte = this.scratch.getData()[0];
                    this.sampleSignalByteRead = true;
                }
                byte b8 = this.sampleSignalByte;
                if ((b8 & 1) == 1) {
                    boolean z10 = (b8 & 2) == 2;
                    this.blockFlags |= 1073741824;
                    if (!this.sampleInitializationVectorRead) {
                        extractorInput.readFully(this.encryptionInitializationVector.getData(), 0, 8);
                        this.sampleBytesRead += 8;
                        this.sampleInitializationVectorRead = true;
                        this.scratch.getData()[0] = (byte) ((z10 ? 128 : 0) | 8);
                        this.scratch.setPosition(0);
                        trackOutput.sampleData(this.scratch, 1, 1);
                        this.sampleBytesWritten++;
                        this.encryptionInitializationVector.setPosition(0);
                        trackOutput.sampleData(this.encryptionInitializationVector, 8, 1);
                        this.sampleBytesWritten += 8;
                    }
                    if (z10) {
                        if (!this.samplePartitionCountRead) {
                            extractorInput.readFully(this.scratch.getData(), 0, 1);
                            this.sampleBytesRead++;
                            this.scratch.setPosition(0);
                            this.samplePartitionCount = this.scratch.readUnsignedByte();
                            this.samplePartitionCountRead = true;
                        }
                        int i11 = this.samplePartitionCount * 4;
                        this.scratch.reset(i11);
                        extractorInput.readFully(this.scratch.getData(), 0, i11);
                        this.sampleBytesRead += i11;
                        short s10 = (short) ((this.samplePartitionCount / 2) + 1);
                        int i12 = (s10 * 6) + 2;
                        ByteBuffer byteBuffer = this.encryptionSubsampleDataBuffer;
                        if (byteBuffer == null || byteBuffer.capacity() < i12) {
                            this.encryptionSubsampleDataBuffer = ByteBuffer.allocate(i12);
                        }
                        this.encryptionSubsampleDataBuffer.position(0);
                        this.encryptionSubsampleDataBuffer.putShort(s10);
                        int i13 = 0;
                        int i14 = 0;
                        while (true) {
                            i10 = this.samplePartitionCount;
                            if (i13 >= i10) {
                                break;
                            }
                            int unsignedIntToInt = this.scratch.readUnsignedIntToInt();
                            if (i13 % 2 == 0) {
                                this.encryptionSubsampleDataBuffer.putShort((short) (unsignedIntToInt - i14));
                            } else {
                                this.encryptionSubsampleDataBuffer.putInt(unsignedIntToInt - i14);
                            }
                            i13++;
                            i14 = unsignedIntToInt;
                        }
                        int i15 = (i6 - this.sampleBytesRead) - i14;
                        if (i10 % 2 == 1) {
                            this.encryptionSubsampleDataBuffer.putInt(i15);
                        } else {
                            this.encryptionSubsampleDataBuffer.putShort((short) i15);
                            this.encryptionSubsampleDataBuffer.putInt(0);
                        }
                        this.encryptionSubsampleData.reset(this.encryptionSubsampleDataBuffer.array(), i12);
                        trackOutput.sampleData(this.encryptionSubsampleData, i12, 1);
                        this.sampleBytesWritten += i12;
                    }
                }
            } else {
                byte[] bArr = track.sampleStrippedBytes;
                if (bArr != null) {
                    this.sampleStrippedBytes.reset(bArr, bArr.length);
                }
            }
            if (track.samplesHaveSupplementalData(z7)) {
                this.blockFlags |= 268435456;
                this.supplementalData.reset(0);
                int iLimit = (this.sampleStrippedBytes.limit() + i6) - this.sampleBytesRead;
                this.scratch.reset(4);
                this.scratch.getData()[0] = (byte) ((iLimit >> 24) & 255);
                this.scratch.getData()[1] = (byte) ((iLimit >> 16) & 255);
                this.scratch.getData()[2] = (byte) ((iLimit >> 8) & 255);
                this.scratch.getData()[3] = (byte) (iLimit & 255);
                trackOutput.sampleData(this.scratch, 4, 2);
                this.sampleBytesWritten += 4;
            }
            this.sampleEncodingHandled = true;
        }
        int iLimit2 = this.sampleStrippedBytes.limit() + i6;
        if (!CODEC_ID_H264.equals(track.codecId) && !CODEC_ID_H265.equals(track.codecId)) {
            if (track.trueHdSampleRechunker != null) {
                Assertions.checkState(this.sampleStrippedBytes.limit() == 0);
                track.trueHdSampleRechunker.startSample(extractorInput);
            }
            while (true) {
                int i16 = this.sampleBytesRead;
                if (i16 >= iLimit2) {
                    break;
                }
                int iWriteToOutput = writeToOutput(extractorInput, trackOutput, iLimit2 - i16);
                this.sampleBytesRead += iWriteToOutput;
                this.sampleBytesWritten += iWriteToOutput;
            }
        } else {
            byte[] data = this.nalLength.getData();
            data[0] = 0;
            data[1] = 0;
            data[2] = 0;
            int i17 = track.nalUnitLengthFieldLength;
            int i18 = 4 - i17;
            while (this.sampleBytesRead < iLimit2) {
                int i19 = this.sampleCurrentNalBytesRemaining;
                if (i19 == 0) {
                    writeToTarget(extractorInput, data, i18, i17);
                    this.sampleBytesRead += i17;
                    this.nalLength.setPosition(0);
                    this.sampleCurrentNalBytesRemaining = this.nalLength.readUnsignedIntToInt();
                    this.nalStartCode.setPosition(0);
                    trackOutput.sampleData(this.nalStartCode, 4);
                    this.sampleBytesWritten += 4;
                } else {
                    int iWriteToOutput2 = writeToOutput(extractorInput, trackOutput, i19);
                    this.sampleBytesRead += iWriteToOutput2;
                    this.sampleBytesWritten += iWriteToOutput2;
                    this.sampleCurrentNalBytesRemaining -= iWriteToOutput2;
                }
            }
        }
        if (CODEC_ID_VORBIS.equals(track.codecId)) {
            this.vorbisNumPageSamples.setPosition(0);
            trackOutput.sampleData(this.vorbisNumPageSamples, 4);
            this.sampleBytesWritten += 4;
        }
        return finishWriteSampleData();
    }

    private void writeSubtitleSampleData(ExtractorInput extractorInput, byte[] bArr, int i6) throws IOException {
        int length = bArr.length + i6;
        if (this.subtitleSample.capacity() < length) {
            this.subtitleSample.reset(Arrays.copyOf(bArr, length + i6));
        } else {
            System.arraycopy(bArr, 0, this.subtitleSample.getData(), 0, bArr.length);
        }
        extractorInput.readFully(this.subtitleSample.getData(), bArr.length, i6);
        this.subtitleSample.setPosition(0);
        this.subtitleSample.setLimit(length);
    }

    private int writeToOutput(ExtractorInput extractorInput, TrackOutput trackOutput, int i6) throws IOException {
        int iBytesLeft = this.sampleStrippedBytes.bytesLeft();
        if (iBytesLeft <= 0) {
            return trackOutput.sampleData((DataReader) extractorInput, i6, false);
        }
        int iMin = Math.min(i6, iBytesLeft);
        trackOutput.sampleData(this.sampleStrippedBytes, iMin);
        return iMin;
    }

    private void writeToTarget(ExtractorInput extractorInput, byte[] bArr, int i6, int i10) throws IOException {
        int iMin = Math.min(i10, this.sampleStrippedBytes.bytesLeft());
        extractorInput.readFully(bArr, i6 + iMin, i10 - iMin);
        if (iMin > 0) {
            this.sampleStrippedBytes.readBytes(bArr, i6, iMin);
        }
    }

    public void binaryElement(int i6, int i10, ExtractorInput extractorInput) throws IOException {
        Track track;
        Track track2;
        Track track3;
        long j10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15 = 0;
        int i16 = 1;
        if (i6 != 161 && i6 != 163) {
            if (i6 == 165) {
                if (this.blockState != 2) {
                    return;
                }
                handleBlockAdditionalData(this.tracks.get(this.blockTrackNumber), this.blockAdditionalId, extractorInput, i10);
                return;
            }
            if (i6 == ID_BLOCK_ADD_ID_EXTRA_DATA) {
                handleBlockAddIDExtraData(getCurrentTrack(i6), extractorInput, i10);
                return;
            }
            if (i6 == ID_CONTENT_COMPRESSION_SETTINGS) {
                assertInTrackEntry(i6);
                byte[] bArr = new byte[i10];
                this.currentTrack.sampleStrippedBytes = bArr;
                extractorInput.readFully(bArr, 0, i10);
                return;
            }
            if (i6 == ID_CONTENT_ENCRYPTION_KEY_ID) {
                byte[] bArr2 = new byte[i10];
                extractorInput.readFully(bArr2, 0, i10);
                getCurrentTrack(i6).cryptoData = new TrackOutput.CryptoData(1, bArr2, 0, 0);
                return;
            }
            if (i6 == ID_SEEK_ID) {
                Arrays.fill(this.seekEntryIdBytes.getData(), (byte) 0);
                extractorInput.readFully(this.seekEntryIdBytes.getData(), 4 - i10, i10);
                this.seekEntryIdBytes.setPosition(0);
                this.seekEntryId = (int) this.seekEntryIdBytes.readUnsignedInt();
                return;
            }
            if (i6 == ID_CODEC_PRIVATE) {
                assertInTrackEntry(i6);
                byte[] bArr3 = new byte[i10];
                this.currentTrack.codecPrivate = bArr3;
                extractorInput.readFully(bArr3, 0, i10);
                return;
            }
            if (i6 != ID_PROJECTION_PRIVATE) {
                throw ParserException.createForMalformedContainer("Unexpected id: " + i6, null);
            }
            assertInTrackEntry(i6);
            byte[] bArr4 = new byte[i10];
            this.currentTrack.projectionData = bArr4;
            extractorInput.readFully(bArr4, 0, i10);
            return;
        }
        if (this.blockState == 0) {
            this.blockTrackNumber = (int) this.varintReader.readUnsignedVarint(extractorInput, false, true, 8);
            this.blockTrackNumberLength = this.varintReader.getLastLength();
            this.blockDurationUs = C0565C.TIME_UNSET;
            this.blockState = 1;
            this.scratch.reset(0);
        }
        Track track4 = this.tracks.get(this.blockTrackNumber);
        if (track4 == null) {
            extractorInput.skipFully(i10 - this.blockTrackNumberLength);
            this.blockState = 0;
            return;
        }
        track4.assertOutputInitialized();
        if (this.blockState == 1) {
            readScratch(extractorInput, 3);
            int i17 = (this.scratch.getData()[2] & 6) >> 1;
            byte b8 = 255;
            if (i17 == 0) {
                this.blockSampleCount = 1;
                int[] iArrEnsureArrayCapacity = ensureArrayCapacity(this.blockSampleSizes, 1);
                this.blockSampleSizes = iArrEnsureArrayCapacity;
                iArrEnsureArrayCapacity[0] = (i10 - this.blockTrackNumberLength) - 3;
            } else {
                int i18 = 4;
                readScratch(extractorInput, 4);
                int i19 = (this.scratch.getData()[3] & 255) + 1;
                this.blockSampleCount = i19;
                int[] iArrEnsureArrayCapacity2 = ensureArrayCapacity(this.blockSampleSizes, i19);
                this.blockSampleSizes = iArrEnsureArrayCapacity2;
                if (i17 == 2) {
                    int i20 = (i10 - this.blockTrackNumberLength) - 4;
                    int i21 = this.blockSampleCount;
                    Arrays.fill(iArrEnsureArrayCapacity2, 0, i21, i20 / i21);
                } else {
                    if (i17 == 1) {
                        int i22 = 0;
                        int i23 = 0;
                        while (true) {
                            i11 = this.blockSampleCount;
                            if (i22 >= i11 - 1) {
                                break;
                            }
                            this.blockSampleSizes[i22] = 0;
                            while (true) {
                                i12 = i18 + 1;
                                readScratch(extractorInput, i12);
                                int i24 = this.scratch.getData()[i18] & 255;
                                int[] iArr = this.blockSampleSizes;
                                i13 = iArr[i22] + i24;
                                iArr[i22] = i13;
                                if (i24 != 255) {
                                    break;
                                } else {
                                    i18 = i12;
                                }
                            }
                            i23 += i13;
                            i22++;
                            i18 = i12;
                        }
                        this.blockSampleSizes[i11 - 1] = ((i10 - this.blockTrackNumberLength) - i18) - i23;
                    } else {
                        if (i17 != 3) {
                            throw ParserException.createForMalformedContainer("Unexpected lacing value: " + i17, null);
                        }
                        int i25 = 0;
                        int i26 = 0;
                        while (true) {
                            int i27 = this.blockSampleCount;
                            if (i25 >= i27 - 1) {
                                track2 = track4;
                                this.blockSampleSizes[i27 - 1] = ((i10 - this.blockTrackNumberLength) - i18) - i26;
                                break;
                            }
                            this.blockSampleSizes[i25] = i15;
                            int i28 = i18 + 1;
                            readScratch(extractorInput, i28);
                            if (this.scratch.getData()[i18] == 0) {
                                throw ParserException.createForMalformedContainer("No valid varint length mask found", null);
                            }
                            int i29 = 0;
                            while (true) {
                                if (i29 >= 8) {
                                    track3 = track4;
                                    j10 = 0;
                                    break;
                                }
                                int i30 = i16 << (7 - i29);
                                if ((this.scratch.getData()[i18] & i30) != 0) {
                                    i28 += i29;
                                    readScratch(extractorInput, i28);
                                    track3 = track4;
                                    j10 = (~i30) & this.scratch.getData()[i18] & b8;
                                    int i31 = i18 + 1;
                                    while (i31 < i28) {
                                        j10 = (j10 << 8) | ((long) (this.scratch.getData()[i31] & b8));
                                        i31++;
                                        b8 = 255;
                                    }
                                    if (i25 <= 0) {
                                        break;
                                    }
                                    j10 -= (1 << ((i29 * 7) + 6)) - 1;
                                    break;
                                }
                                i29++;
                                i16 = 1;
                                b8 = 255;
                            }
                            i18 = i28;
                            if (j10 < -2147483648L || j10 > 2147483647L) {
                                throw ParserException.createForMalformedContainer("EBML lacing sample size out of range.", null);
                            }
                            int i32 = (int) j10;
                            int[] iArr2 = this.blockSampleSizes;
                            if (i25 != 0) {
                                i32 += iArr2[i25 - 1];
                            }
                            iArr2[i25] = i32;
                            i26 += i32;
                            i25++;
                            track4 = track3;
                            i15 = 0;
                            i16 = 1;
                            b8 = 255;
                        }
                    }
                    this.blockTimeUs = this.clusterTimecodeUs + scaleTimecodeToUs((this.scratch.getData()[0] << 8) | (this.scratch.getData()[1] & 255));
                    track = track2;
                    if (track.type != 2 || (i6 == 163 && (this.scratch.getData()[2] & 128) == 128)) {
                        i14 = 1;
                    } else {
                        i14 = 0;
                    }
                    this.blockFlags = i14;
                    this.blockState = 2;
                    this.blockSampleIndex = 0;
                }
            }
            track2 = track4;
            this.blockTimeUs = this.clusterTimecodeUs + scaleTimecodeToUs((this.scratch.getData()[0] << 8) | (this.scratch.getData()[1] & 255));
            track = track2;
            if (track.type != 2) {
                i14 = 1;
            } else {
                i14 = 1;
            }
            this.blockFlags = i14;
            this.blockState = 2;
            this.blockSampleIndex = 0;
        } else {
            track = track4;
        }
        if (i6 == 163) {
            while (true) {
                int i33 = this.blockSampleIndex;
                if (i33 >= this.blockSampleCount) {
                    this.blockState = 0;
                    return;
                }
                commitSampleToOutput(track, ((long) ((this.blockSampleIndex * track.defaultSampleDurationNs) / 1000)) + this.blockTimeUs, this.blockFlags, writeSampleData(extractorInput, track, this.blockSampleSizes[i33], false), 0);
                this.blockSampleIndex++;
            }
        } else {
            while (true) {
                int i34 = this.blockSampleIndex;
                if (i34 >= this.blockSampleCount) {
                    return;
                }
                int[] iArr3 = this.blockSampleSizes;
                iArr3[i34] = writeSampleData(extractorInput, track, iArr3[i34], true);
                this.blockSampleIndex++;
            }
        }
    }

    public void endMasterElement(int i6) throws ParserException {
        assertInitialized();
        if (i6 == 160) {
            if (this.blockState != 2) {
                return;
            }
            Track track = this.tracks.get(this.blockTrackNumber);
            track.assertOutputInitialized();
            if (this.blockGroupDiscardPaddingNs > 0 && CODEC_ID_OPUS.equals(track.codecId)) {
                this.supplementalData.reset(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.blockGroupDiscardPaddingNs).array());
            }
            int i10 = 0;
            for (int i11 = 0; i11 < this.blockSampleCount; i11++) {
                i10 += this.blockSampleSizes[i11];
            }
            int i12 = 0;
            while (i12 < this.blockSampleCount) {
                long j10 = this.blockTimeUs + ((long) ((track.defaultSampleDurationNs * i12) / 1000));
                int i13 = this.blockFlags;
                if (i12 == 0 && !this.blockHasReferenceBlock) {
                    i13 |= 1;
                }
                int i14 = this.blockSampleSizes[i12];
                int i15 = i10 - i14;
                commitSampleToOutput(track, j10, i13, i14, i15);
                i12++;
                i10 = i15;
            }
            this.blockState = 0;
            return;
        }
        if (i6 == ID_TRACK_ENTRY) {
            Track track2 = (Track) Assertions.checkStateNotNull(this.currentTrack);
            String str = track2.codecId;
            if (str == null) {
                throw ParserException.createForMalformedContainer("CodecId is missing in TrackEntry element", null);
            }
            if (isCodecSupported(str)) {
                track2.initializeOutput(this.extractorOutput, track2.number);
                this.tracks.put(track2.number, track2);
            }
            this.currentTrack = null;
            return;
        }
        if (i6 == ID_SEEK) {
            int i16 = this.seekEntryId;
            if (i16 != -1) {
                long j11 = this.seekEntryPosition;
                if (j11 != -1) {
                    if (i16 == ID_CUES) {
                        this.cuesContentPosition = j11;
                        return;
                    }
                    return;
                }
            }
            throw ParserException.createForMalformedContainer("Mandatory element SeekID or SeekPosition not found", null);
        }
        if (i6 == ID_CONTENT_ENCODING) {
            assertInTrackEntry(i6);
            Track track3 = this.currentTrack;
            if (track3.hasContentEncryption) {
                if (track3.cryptoData == null) {
                    throw ParserException.createForMalformedContainer("Encrypted Track found but ContentEncKeyID was not found", null);
                }
                track3.drmInitData = new DrmInitData(new DrmInitData.SchemeData(C0565C.UUID_NIL, MimeTypes.VIDEO_WEBM, this.currentTrack.cryptoData.encryptionKey));
                return;
            }
            return;
        }
        if (i6 == ID_CONTENT_ENCODINGS) {
            assertInTrackEntry(i6);
            Track track4 = this.currentTrack;
            if (track4.hasContentEncryption && track4.sampleStrippedBytes != null) {
                throw ParserException.createForMalformedContainer("Combining encryption and compression is not supported", null);
            }
            return;
        }
        if (i6 == 357149030) {
            if (this.timecodeScale == C0565C.TIME_UNSET) {
                this.timecodeScale = 1000000L;
            }
            long j12 = this.durationTimecode;
            if (j12 != C0565C.TIME_UNSET) {
                this.durationUs = scaleTimecodeToUs(j12);
                return;
            }
            return;
        }
        if (i6 == ID_TRACKS) {
            if (this.tracks.size() == 0) {
                throw ParserException.createForMalformedContainer("No valid tracks were found", null);
            }
            this.extractorOutput.endTracks();
        } else {
            if (i6 != ID_CUES) {
                return;
            }
            if (!this.sentSeekMap) {
                this.extractorOutput.seekMap(buildSeekMap(this.cueTimesUs, this.cueClusterPositions));
                this.sentSeekMap = true;
            }
            this.cueTimesUs = null;
            this.cueClusterPositions = null;
        }
    }

    public void floatElement(int i6, double d) throws ParserException {
        if (i6 == 181) {
            getCurrentTrack(i6).sampleRate = (int) d;
        }
        if (i6 == ID_DURATION) {
            this.durationTimecode = (long) d;
            return;
        }
        switch (i6) {
            case ID_PRIMARY_R_CHROMATICITY_X:
                getCurrentTrack(i6).primaryRChromaticityX = (float) d;
                break;
            case ID_PRIMARY_R_CHROMATICITY_Y:
                getCurrentTrack(i6).primaryRChromaticityY = (float) d;
                break;
            case ID_PRIMARY_G_CHROMATICITY_X:
                getCurrentTrack(i6).primaryGChromaticityX = (float) d;
                break;
            case ID_PRIMARY_G_CHROMATICITY_Y:
                getCurrentTrack(i6).primaryGChromaticityY = (float) d;
                break;
            case ID_PRIMARY_B_CHROMATICITY_X:
                getCurrentTrack(i6).primaryBChromaticityX = (float) d;
                break;
            case ID_PRIMARY_B_CHROMATICITY_Y:
                getCurrentTrack(i6).primaryBChromaticityY = (float) d;
                break;
            case ID_WHITE_POINT_CHROMATICITY_X:
                getCurrentTrack(i6).whitePointChromaticityX = (float) d;
                break;
            case ID_WHITE_POINT_CHROMATICITY_Y:
                getCurrentTrack(i6).whitePointChromaticityY = (float) d;
                break;
            case ID_LUMNINANCE_MAX:
                getCurrentTrack(i6).maxMasteringLuminance = (float) d;
                break;
            case ID_LUMNINANCE_MIN:
                getCurrentTrack(i6).minMasteringLuminance = (float) d;
                break;
            default:
                switch (i6) {
                    case ID_PROJECTION_POSE_YAW:
                        getCurrentTrack(i6).projectionPoseYaw = (float) d;
                        break;
                    case ID_PROJECTION_POSE_PITCH:
                        getCurrentTrack(i6).projectionPosePitch = (float) d;
                        break;
                    case ID_PROJECTION_POSE_ROLL:
                        getCurrentTrack(i6).projectionPoseRoll = (float) d;
                        break;
                }
                break;
        }
    }

    public Track getCurrentTrack(int i6) throws ParserException {
        assertInTrackEntry(i6);
        return this.currentTrack;
    }

    public int getElementType(int i6) {
        switch (i6) {
            case ID_TRACK_TYPE:
            case 136:
            case ID_BLOCK_DURATION:
            case 159:
            case 176:
            case ID_CUE_TIME:
            case ID_PIXEL_HEIGHT:
            case ID_TRACK_NUMBER:
            case ID_TIME_CODE:
            case ID_BLOCK_ADD_ID:
            case ID_CUE_CLUSTER_POSITION:
            case ID_REFERENCE_BLOCK:
            case ID_BLOCK_ADD_ID_TYPE:
            case ID_CONTENT_COMPRESSION_ALGORITHM:
            case ID_DOC_TYPE_READ_VERSION:
            case ID_EBML_READ_VERSION:
            case ID_CONTENT_ENCRYPTION_ALGORITHM:
            case ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE:
            case ID_CONTENT_ENCODING_ORDER:
            case ID_CONTENT_ENCODING_SCOPE:
            case ID_SEEK_POSITION:
            case ID_STEREO_MODE:
            case ID_DISPLAY_WIDTH:
            case ID_DISPLAY_UNIT:
            case ID_DISPLAY_HEIGHT:
            case ID_FLAG_FORCED:
            case ID_COLOUR_BITS_PER_CHANNEL:
            case ID_COLOUR_RANGE:
            case ID_COLOUR_TRANSFER:
            case ID_COLOUR_PRIMARIES:
            case ID_MAX_CLL:
            case ID_MAX_FALL:
            case ID_MAX_BLOCK_ADDITION_ID:
            case ID_CODEC_DELAY:
            case ID_SEEK_PRE_ROLL:
            case ID_AUDIO_BIT_DEPTH:
            case ID_DISCARD_PADDING:
            case ID_PROJECTION_TYPE:
            case ID_DEFAULT_DURATION:
            case ID_TIMECODE_SCALE:
                return 2;
            case 134:
            case ID_DOC_TYPE:
            case ID_NAME:
            case ID_LANGUAGE:
                return 3;
            case 160:
            case 166:
            case ID_TRACK_ENTRY:
            case 183:
            case 187:
            case 224:
            case ID_AUDIO:
            case ID_BLOCK_ADDITION_MAPPING:
            case ID_CONTENT_ENCRYPTION_AES_SETTINGS:
            case ID_SEEK:
            case ID_CONTENT_COMPRESSION:
            case ID_CONTENT_ENCRYPTION:
            case ID_COLOUR:
            case ID_MASTERING_METADATA:
            case ID_CONTENT_ENCODING:
            case ID_CONTENT_ENCODINGS:
            case ID_BLOCK_ADDITIONS:
            case ID_PROJECTION:
            case ID_SEEK_HEAD:
            case 357149030:
            case ID_TRACKS:
            case ID_SEGMENT:
            case ID_EBML:
            case ID_CUES:
            case ID_CLUSTER:
                return 1;
            case 161:
            case 163:
            case 165:
            case ID_BLOCK_ADD_ID_EXTRA_DATA:
            case ID_CONTENT_COMPRESSION_SETTINGS:
            case ID_CONTENT_ENCRYPTION_KEY_ID:
            case ID_SEEK_ID:
            case ID_CODEC_PRIVATE:
            case ID_PROJECTION_PRIVATE:
                return 4;
            case 181:
            case ID_DURATION:
            case ID_PRIMARY_R_CHROMATICITY_X:
            case ID_PRIMARY_R_CHROMATICITY_Y:
            case ID_PRIMARY_G_CHROMATICITY_X:
            case ID_PRIMARY_G_CHROMATICITY_Y:
            case ID_PRIMARY_B_CHROMATICITY_X:
            case ID_PRIMARY_B_CHROMATICITY_Y:
            case ID_WHITE_POINT_CHROMATICITY_X:
            case ID_WHITE_POINT_CHROMATICITY_Y:
            case ID_LUMNINANCE_MAX:
            case ID_LUMNINANCE_MIN:
            case ID_PROJECTION_POSE_YAW:
            case ID_PROJECTION_POSE_PITCH:
            case ID_PROJECTION_POSE_ROLL:
                return 5;
            default:
                return 0;
        }
    }

    @Override
    public final List getSniffFailureDetails() {
        return AbstractC1009b.m2645a(this);
    }

    @Override
    public final Extractor getUnderlyingImplementation() {
        return AbstractC1009b.m2646b(this);
    }

    public void handleBlockAddIDExtraData(Track track, ExtractorInput extractorInput, int i6) throws IOException {
        if (track.blockAddIdType != 1685485123 && track.blockAddIdType != 1685480259) {
            extractorInput.skipFully(i6);
            return;
        }
        byte[] bArr = new byte[i6];
        track.dolbyVisionConfigBytes = bArr;
        extractorInput.readFully(bArr, 0, i6);
    }

    public void handleBlockAdditionalData(Track track, int i6, ExtractorInput extractorInput, int i10) throws IOException {
        if (i6 != 4 || !CODEC_ID_VP9.equals(track.codecId)) {
            extractorInput.skipFully(i10);
        } else {
            this.supplementalData.reset(i10);
            extractorInput.readFully(this.supplementalData.getData(), 0, i10);
        }
    }

    @Override
    public final void init(ExtractorOutput extractorOutput) {
        if (this.parseSubtitlesDuringExtraction) {
            extractorOutput = new SubtitleTranscodingExtractorOutput(extractorOutput, this.subtitleParserFactory);
        }
        this.extractorOutput = extractorOutput;
    }

    public void integerElement(int i6, long j10) throws ParserException {
        if (i6 == ID_CONTENT_ENCODING_ORDER) {
            if (j10 == 0) {
                return;
            }
            throw ParserException.createForMalformedContainer("ContentEncodingOrder " + j10 + " not supported", null);
        }
        if (i6 == ID_CONTENT_ENCODING_SCOPE) {
            if (j10 == 1) {
                return;
            }
            throw ParserException.createForMalformedContainer("ContentEncodingScope " + j10 + " not supported", null);
        }
        switch (i6) {
            case ID_TRACK_TYPE:
                getCurrentTrack(i6).type = (int) j10;
                return;
            case 136:
                getCurrentTrack(i6).flagDefault = j10 == 1;
                return;
            case ID_BLOCK_DURATION:
                this.blockDurationUs = scaleTimecodeToUs(j10);
                return;
            case 159:
                getCurrentTrack(i6).channelCount = (int) j10;
                return;
            case 176:
                getCurrentTrack(i6).width = (int) j10;
                return;
            case ID_CUE_TIME:
                assertInCues(i6);
                this.cueTimesUs.add(scaleTimecodeToUs(j10));
                return;
            case ID_PIXEL_HEIGHT:
                getCurrentTrack(i6).height = (int) j10;
                return;
            case ID_TRACK_NUMBER:
                getCurrentTrack(i6).number = (int) j10;
                return;
            case ID_TIME_CODE:
                this.clusterTimecodeUs = scaleTimecodeToUs(j10);
                return;
            case ID_BLOCK_ADD_ID:
                this.blockAdditionalId = (int) j10;
                return;
            case ID_CUE_CLUSTER_POSITION:
                if (this.seenClusterPositionForCurrentCuePoint) {
                    return;
                }
                assertInCues(i6);
                this.cueClusterPositions.add(j10);
                this.seenClusterPositionForCurrentCuePoint = true;
                return;
            case ID_REFERENCE_BLOCK:
                this.blockHasReferenceBlock = true;
                return;
            case ID_BLOCK_ADD_ID_TYPE:
                getCurrentTrack(i6).blockAddIdType = (int) j10;
                return;
            case ID_CONTENT_COMPRESSION_ALGORITHM:
                if (j10 == 3) {
                    return;
                }
                throw ParserException.createForMalformedContainer("ContentCompAlgo " + j10 + " not supported", null);
            case ID_DOC_TYPE_READ_VERSION:
                if (j10 < 1 || j10 > 2) {
                    throw ParserException.createForMalformedContainer("DocTypeReadVersion " + j10 + " not supported", null);
                }
                return;
            case ID_EBML_READ_VERSION:
                if (j10 == 1) {
                    return;
                }
                throw ParserException.createForMalformedContainer("EBMLReadVersion " + j10 + " not supported", null);
            case ID_CONTENT_ENCRYPTION_ALGORITHM:
                if (j10 == 5) {
                    return;
                }
                throw ParserException.createForMalformedContainer("ContentEncAlgo " + j10 + " not supported", null);
            case ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE:
                if (j10 == 1) {
                    return;
                }
                throw ParserException.createForMalformedContainer("AESSettingsCipherMode " + j10 + " not supported", null);
            case ID_SEEK_POSITION:
                this.seekEntryPosition = j10 + this.segmentContentPosition;
                return;
            case ID_STEREO_MODE:
                int i10 = (int) j10;
                assertInTrackEntry(i6);
                if (i10 == 0) {
                    this.currentTrack.stereoMode = 0;
                    return;
                }
                if (i10 == 1) {
                    this.currentTrack.stereoMode = 2;
                    return;
                } else if (i10 == 3) {
                    this.currentTrack.stereoMode = 1;
                    return;
                } else {
                    if (i10 != 15) {
                        return;
                    }
                    this.currentTrack.stereoMode = 3;
                    return;
                }
            case ID_DISPLAY_WIDTH:
                getCurrentTrack(i6).displayWidth = (int) j10;
                return;
            case ID_DISPLAY_UNIT:
                getCurrentTrack(i6).displayUnit = (int) j10;
                return;
            case ID_DISPLAY_HEIGHT:
                getCurrentTrack(i6).displayHeight = (int) j10;
                return;
            case ID_FLAG_FORCED:
                getCurrentTrack(i6).flagForced = j10 == 1;
                return;
            case ID_COLOUR_BITS_PER_CHANNEL:
                assertInTrackEntry(i6);
                Track track = this.currentTrack;
                track.hasColorInfo = true;
                track.bitsPerChannel = (int) j10;
                return;
            case ID_MAX_BLOCK_ADDITION_ID:
                getCurrentTrack(i6).maxBlockAdditionId = (int) j10;
                return;
            case ID_CODEC_DELAY:
                getCurrentTrack(i6).codecDelayNs = j10;
                return;
            case ID_SEEK_PRE_ROLL:
                getCurrentTrack(i6).seekPreRollNs = j10;
                return;
            case ID_AUDIO_BIT_DEPTH:
                getCurrentTrack(i6).audioBitDepth = (int) j10;
                return;
            case ID_DISCARD_PADDING:
                this.blockGroupDiscardPaddingNs = j10;
                return;
            case ID_PROJECTION_TYPE:
                assertInTrackEntry(i6);
                int i11 = (int) j10;
                if (i11 == 0) {
                    this.currentTrack.projectionType = 0;
                    return;
                }
                if (i11 == 1) {
                    this.currentTrack.projectionType = 1;
                    return;
                } else if (i11 == 2) {
                    this.currentTrack.projectionType = 2;
                    return;
                } else {
                    if (i11 != 3) {
                        return;
                    }
                    this.currentTrack.projectionType = 3;
                    return;
                }
            case ID_DEFAULT_DURATION:
                getCurrentTrack(i6).defaultSampleDurationNs = (int) j10;
                return;
            case ID_TIMECODE_SCALE:
                this.timecodeScale = j10;
                return;
            default:
                switch (i6) {
                    case ID_COLOUR_RANGE:
                        assertInTrackEntry(i6);
                        int i12 = (int) j10;
                        if (i12 == 1) {
                            this.currentTrack.colorRange = 2;
                            return;
                        } else {
                            if (i12 != 2) {
                                return;
                            }
                            this.currentTrack.colorRange = 1;
                            return;
                        }
                    case ID_COLOUR_TRANSFER:
                        assertInTrackEntry(i6);
                        int iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer((int) j10);
                        if (iIsoTransferCharacteristicsToColorTransfer != -1) {
                            this.currentTrack.colorTransfer = iIsoTransferCharacteristicsToColorTransfer;
                            return;
                        }
                        return;
                    case ID_COLOUR_PRIMARIES:
                        assertInTrackEntry(i6);
                        this.currentTrack.hasColorInfo = true;
                        int iIsoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace((int) j10);
                        if (iIsoColorPrimariesToColorSpace != -1) {
                            this.currentTrack.colorSpace = iIsoColorPrimariesToColorSpace;
                            return;
                        }
                        return;
                    case ID_MAX_CLL:
                        getCurrentTrack(i6).maxContentLuminance = (int) j10;
                        return;
                    case ID_MAX_FALL:
                        getCurrentTrack(i6).maxFrameAverageLuminance = (int) j10;
                        return;
                    default:
                        return;
                }
        }
    }

    public boolean isLevel1Element(int i6) {
        return i6 == 357149030 || i6 == ID_CLUSTER || i6 == ID_CUES || i6 == ID_TRACKS;
    }

    @Override
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        this.haveOutputSample = false;
        boolean z7 = true;
        while (z7 && !this.haveOutputSample) {
            z7 = this.reader.read(extractorInput);
            if (z7 && maybeSeekForCues(positionHolder, extractorInput.getPosition())) {
                return 1;
            }
        }
        if (z7) {
            return 0;
        }
        for (int i6 = 0; i6 < this.tracks.size(); i6++) {
            Track trackValueAt = this.tracks.valueAt(i6);
            trackValueAt.assertOutputInitialized();
            trackValueAt.outputPendingSampleMetadata();
        }
        return -1;
    }

    @Override
    public void seek(long j10, long j11) {
        this.clusterTimecodeUs = C0565C.TIME_UNSET;
        this.blockState = 0;
        this.reader.reset();
        this.varintReader.reset();
        resetWriteSampleData();
        for (int i6 = 0; i6 < this.tracks.size(); i6++) {
            this.tracks.valueAt(i6).reset();
        }
    }

    @Override
    public final boolean sniff(ExtractorInput extractorInput) throws IOException {
        return new Sniffer().sniff(extractorInput);
    }

    public void startMasterElement(int i6, long j10, long j11) throws ParserException {
        assertInitialized();
        if (i6 == 160) {
            this.blockHasReferenceBlock = false;
            this.blockGroupDiscardPaddingNs = 0L;
            return;
        }
        if (i6 == ID_TRACK_ENTRY) {
            Track track = new Track();
            this.currentTrack = track;
            track.isWebm = this.isWebm;
            return;
        }
        if (i6 == 187) {
            this.seenClusterPositionForCurrentCuePoint = false;
            return;
        }
        if (i6 == ID_SEEK) {
            this.seekEntryId = -1;
            this.seekEntryPosition = -1L;
            return;
        }
        if (i6 == ID_CONTENT_ENCRYPTION) {
            getCurrentTrack(i6).hasContentEncryption = true;
            return;
        }
        if (i6 == ID_MASTERING_METADATA) {
            getCurrentTrack(i6).hasColorInfo = true;
            return;
        }
        if (i6 == ID_SEGMENT) {
            long j12 = this.segmentContentPosition;
            if (j12 != -1 && j12 != j10) {
                throw ParserException.createForMalformedContainer("Multiple Segment elements not supported", null);
            }
            this.segmentContentPosition = j10;
            this.segmentContentSize = j11;
            return;
        }
        if (i6 == ID_CUES) {
            this.cueTimesUs = new LongArray();
            this.cueClusterPositions = new LongArray();
        } else if (i6 == ID_CLUSTER && !this.sentSeekMap) {
            if (this.seekForCuesEnabled && this.cuesContentPosition != -1) {
                this.seekForCues = true;
            } else {
                this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs));
                this.sentSeekMap = true;
            }
        }
    }

    public void stringElement(int i6, String str) throws ParserException {
        if (i6 == 134) {
            getCurrentTrack(i6).codecId = str;
            return;
        }
        if (i6 != ID_DOC_TYPE) {
            if (i6 == ID_NAME) {
                getCurrentTrack(i6).name = str;
                return;
            } else {
                if (i6 != ID_LANGUAGE) {
                    return;
                }
                getCurrentTrack(i6).language = str;
                return;
            }
        }
        if (DOC_TYPE_WEBM.equals(str) || DOC_TYPE_MATROSKA.equals(str)) {
            this.isWebm = Objects.equals(str, DOC_TYPE_WEBM);
            return;
        }
        throw ParserException.createForMalformedContainer("DocType " + str + " not supported", null);
    }

    @Deprecated
    public MatroskaExtractor(int i6) {
        this(new DefaultEbmlReader(), i6 | 2, SubtitleParser.Factory.UNSUPPORTED);
    }

    public MatroskaExtractor(SubtitleParser.Factory factory) {
        this(new DefaultEbmlReader(), 0, factory);
    }

    public MatroskaExtractor(SubtitleParser.Factory factory, int i6) {
        this(new DefaultEbmlReader(), i6, factory);
    }

    public MatroskaExtractor(EbmlReader ebmlReader, int i6, SubtitleParser.Factory factory) {
        this.segmentContentPosition = -1L;
        this.timecodeScale = C0565C.TIME_UNSET;
        this.durationTimecode = C0565C.TIME_UNSET;
        this.durationUs = C0565C.TIME_UNSET;
        this.cuesContentPosition = -1L;
        this.seekPositionAfterBuildingCues = -1L;
        this.clusterTimecodeUs = C0565C.TIME_UNSET;
        this.reader = ebmlReader;
        ebmlReader.init(new InnerEbmlProcessor());
        this.subtitleParserFactory = factory;
        this.seekForCuesEnabled = (i6 & 1) == 0;
        this.parseSubtitlesDuringExtraction = (i6 & 2) == 0;
        this.varintReader = new VarintReader();
        this.tracks = new SparseArray<>();
        this.scratch = new ParsableByteArray(4);
        this.vorbisNumPageSamples = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.seekEntryIdBytes = new ParsableByteArray(4);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
        this.sampleStrippedBytes = new ParsableByteArray();
        this.subtitleSample = new ParsableByteArray();
        this.encryptionInitializationVector = new ParsableByteArray(8);
        this.encryptionSubsampleData = new ParsableByteArray();
        this.supplementalData = new ParsableByteArray();
        this.blockSampleSizes = new int[1];
    }

    @Override
    public final void release() {
    }
}

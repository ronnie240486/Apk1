package androidx.media3.extractor;

import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.p010ts.TsExtractor;
import com.alibaba.fastjson.asm.Opcodes;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import okio.Utf8;

@UnstableApi
public final class Ac3Util {
    public static final int AC3_MAX_RATE_BYTES_PER_SECOND = 80000;
    private static final int AC3_SYNCFRAME_AUDIO_SAMPLE_COUNT = 1536;
    private static final int AUDIO_SAMPLES_PER_AUDIO_BLOCK = 256;
    public static final int E_AC3_MAX_RATE_BYTES_PER_SECOND = 768000;
    public static final int TRUEHD_MAX_RATE_BYTES_PER_SECOND = 3062500;
    public static final int TRUEHD_RECHUNK_SAMPLE_COUNT = 16;
    public static final int TRUEHD_SYNCFRAME_PREFIX_LENGTH = 10;
    private static final int[] BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD = {1, 2, 3, 6};
    private static final int[] SAMPLE_RATE_BY_FSCOD = {OpusUtil.SAMPLE_RATE, 44100, 32000};
    private static final int[] SAMPLE_RATE_BY_FSCOD2 = {24000, 22050, AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND};
    private static final int[] CHANNEL_COUNT_BY_ACMOD = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] BITRATE_BY_HALF_FRMSIZECOD = {32, 40, 48, 56, 64, 80, 96, 112, 128, Opcodes.IF_ICMPNE, 192, 224, 256, 320, RendererCapabilities.DECODER_SUPPORT_MASK, 448, 512, 576, 640};
    private static final int[] SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1 = {69, 87, 104, 121, TsExtractor.TS_STREAM_TYPE_DTS_UHD, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static final class SyncFrameInfo {
        public static final int STREAM_TYPE_TYPE0 = 0;
        public static final int STREAM_TYPE_TYPE1 = 1;
        public static final int STREAM_TYPE_TYPE2 = 2;
        public static final int STREAM_TYPE_UNDEFINED = -1;
        public final int bitrate;
        public final int channelCount;
        public final int frameSize;
        public final String mimeType;
        public final int sampleCount;
        public final int sampleRate;
        public final int streamType;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface StreamType {
        }

        private SyncFrameInfo(String str, int i6, int i10, int i11, int i12, int i13, int i14) {
            this.mimeType = str;
            this.streamType = i6;
            this.channelCount = i10;
            this.sampleRate = i11;
            this.frameSize = i12;
            this.sampleCount = i13;
            this.bitrate = i14;
        }
    }

    private Ac3Util() {
    }

    private static int calculateEac3Bitrate(int i6, int i10, int i11) {
        return (i6 * i10) / (i11 * 32);
    }

    public static int findTrueHdSyncframeOffset(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit() - 10;
        for (int i6 = iPosition; i6 <= iLimit; i6++) {
            if ((Util.getBigEndianInt(byteBuffer, i6 + 4) & (-2)) == -126718022) {
                return i6 - iPosition;
            }
        }
        return -1;
    }

    private static int getAc3SyncframeSize(int i6, int i10) {
        int i11 = i10 / 2;
        if (i6 < 0) {
            return -1;
        }
        int[] iArr = SAMPLE_RATE_BY_FSCOD;
        if (i6 >= iArr.length || i10 < 0) {
            return -1;
        }
        int[] iArr2 = SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1;
        if (i11 >= iArr2.length) {
            return -1;
        }
        int i12 = iArr[i6];
        if (i12 == 44100) {
            return ((i10 % 2) + iArr2[i11]) * 2;
        }
        int i13 = BITRATE_BY_HALF_FRMSIZECOD[i11];
        return i12 == 32000 ? i13 * 6 : i13 * 4;
    }

    public static Format parseAc3AnnexFFormat(ParsableByteArray parsableByteArray, String str, String str2, DrmInitData drmInitData) {
        ParsableBitArray parsableBitArray = new ParsableBitArray();
        parsableBitArray.reset(parsableByteArray);
        int i6 = SAMPLE_RATE_BY_FSCOD[parsableBitArray.readBits(2)];
        parsableBitArray.skipBits(8);
        int i10 = CHANNEL_COUNT_BY_ACMOD[parsableBitArray.readBits(3)];
        if (parsableBitArray.readBits(1) != 0) {
            i10++;
        }
        int i11 = BITRATE_BY_HALF_FRMSIZECOD[parsableBitArray.readBits(5)] * 1000;
        parsableBitArray.byteAlign();
        parsableByteArray.setPosition(parsableBitArray.getBytePosition());
        return new Format.Builder().setId(str).setSampleMimeType(MimeTypes.AUDIO_AC3).setChannelCount(i10).setSampleRate(i6).setDrmInitData(drmInitData).setLanguage(str2).setAverageBitrate(i11).setPeakBitrate(i11).build();
    }

    public static int parseAc3SyncframeAudioSampleCount(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
        }
        return AC3_SYNCFRAME_AUDIO_SAMPLE_COUNT;
    }

    public static SyncFrameInfo parseAc3SyncframeInfo(ParsableBitArray parsableBitArray) {
        String str;
        int i6;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int position = parsableBitArray.getPosition();
        parsableBitArray.skipBits(40);
        boolean z7 = parsableBitArray.readBits(5) > 10;
        parsableBitArray.setPosition(position);
        int i21 = -1;
        if (z7) {
            parsableBitArray.skipBits(16);
            int bits = parsableBitArray.readBits(2);
            if (bits == 0) {
                i21 = 0;
            } else if (bits == 1) {
                i21 = 1;
            } else if (bits == 2) {
                i21 = 2;
            }
            parsableBitArray.skipBits(3);
            int bits2 = (parsableBitArray.readBits(11) + 1) * 2;
            int bits3 = parsableBitArray.readBits(2);
            if (bits3 == 3) {
                i16 = SAMPLE_RATE_BY_FSCOD2[parsableBitArray.readBits(2)];
                i15 = 3;
                i17 = 6;
            } else {
                int bits4 = parsableBitArray.readBits(2);
                int i22 = BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[bits4];
                i15 = bits4;
                i16 = SAMPLE_RATE_BY_FSCOD[bits3];
                i17 = i22;
            }
            int i23 = i17 * 256;
            int iCalculateEac3Bitrate = calculateEac3Bitrate(bits2, i16, i17);
            int bits5 = parsableBitArray.readBits(3);
            boolean bit = parsableBitArray.readBit();
            int i24 = CHANNEL_COUNT_BY_ACMOD[bits5] + (bit ? 1 : 0);
            parsableBitArray.skipBits(10);
            if (parsableBitArray.readBit()) {
                parsableBitArray.skipBits(8);
            }
            if (bits5 == 0) {
                parsableBitArray.skipBits(5);
                if (parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(8);
                }
            }
            if (i21 == 1 && parsableBitArray.readBit()) {
                parsableBitArray.skipBits(16);
            }
            if (parsableBitArray.readBit()) {
                if (bits5 > 2) {
                    parsableBitArray.skipBits(2);
                }
                if ((bits5 & 1) == 0 || bits5 <= 2) {
                    i19 = 6;
                } else {
                    i19 = 6;
                    parsableBitArray.skipBits(6);
                }
                if ((bits5 & 4) != 0) {
                    parsableBitArray.skipBits(i19);
                }
                if (bit && parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(5);
                }
                if (i21 == 0) {
                    if (parsableBitArray.readBit()) {
                        i20 = 6;
                        parsableBitArray.skipBits(6);
                    } else {
                        i20 = 6;
                    }
                    if (bits5 == 0 && parsableBitArray.readBit()) {
                        parsableBitArray.skipBits(i20);
                    }
                    if (parsableBitArray.readBit()) {
                        parsableBitArray.skipBits(i20);
                    }
                    int bits6 = parsableBitArray.readBits(2);
                    if (bits6 == 1) {
                        parsableBitArray.skipBits(5);
                    } else if (bits6 == 2) {
                        parsableBitArray.skipBits(12);
                    } else if (bits6 == 3) {
                        int bits7 = parsableBitArray.readBits(5);
                        if (parsableBitArray.readBit()) {
                            parsableBitArray.skipBits(5);
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(4);
                                }
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(4);
                                }
                            }
                        }
                        if (parsableBitArray.readBit()) {
                            parsableBitArray.skipBits(5);
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(7);
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(8);
                                }
                            }
                        }
                        parsableBitArray.skipBits((bits7 + 2) * 8);
                        parsableBitArray.byteAlign();
                    }
                    if (bits5 < 2) {
                        if (parsableBitArray.readBit()) {
                            parsableBitArray.skipBits(14);
                        }
                        if (bits5 == 0 && parsableBitArray.readBit()) {
                            parsableBitArray.skipBits(14);
                        }
                    }
                    if (parsableBitArray.readBit()) {
                        if (i15 == 0) {
                            parsableBitArray.skipBits(5);
                        } else {
                            for (int i25 = 0; i25 < i17; i25++) {
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(5);
                                }
                            }
                        }
                    }
                }
            }
            if (parsableBitArray.readBit()) {
                parsableBitArray.skipBits(5);
                if (bits5 == 2) {
                    parsableBitArray.skipBits(4);
                }
                if (bits5 >= 6) {
                    parsableBitArray.skipBits(2);
                }
                if (parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(8);
                }
                if (bits5 == 0 && parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(8);
                }
                if (bits3 < 3) {
                    parsableBitArray.skipBit();
                }
            }
            if (i21 == 0 && i15 != 3) {
                parsableBitArray.skipBit();
            }
            if (i21 == 2 && (i15 == 3 || parsableBitArray.readBit())) {
                i18 = 6;
                parsableBitArray.skipBits(6);
            } else {
                i18 = 6;
            }
            str = (parsableBitArray.readBit() && parsableBitArray.readBits(i18) == 1 && parsableBitArray.readBits(8) == 1) ? MimeTypes.AUDIO_E_AC3_JOC : MimeTypes.AUDIO_E_AC3;
            i13 = i21;
            i14 = i23;
            i10 = bits2;
            i11 = i16;
            i6 = iCalculateEac3Bitrate;
            i12 = i24;
        } else {
            parsableBitArray.skipBits(32);
            int bits8 = parsableBitArray.readBits(2);
            String str2 = bits8 == 3 ? null : MimeTypes.AUDIO_AC3;
            int bits9 = parsableBitArray.readBits(6);
            int i26 = BITRATE_BY_HALF_FRMSIZECOD[bits9 / 2] * 1000;
            int ac3SyncframeSize = getAc3SyncframeSize(bits8, bits9);
            parsableBitArray.skipBits(8);
            int bits10 = parsableBitArray.readBits(3);
            if ((bits10 & 1) != 0 && bits10 != 1) {
                parsableBitArray.skipBits(2);
            }
            if ((bits10 & 4) != 0) {
                parsableBitArray.skipBits(2);
            }
            if (bits10 == 2) {
                parsableBitArray.skipBits(2);
            }
            int[] iArr = SAMPLE_RATE_BY_FSCOD;
            str = str2;
            i6 = i26;
            i10 = ac3SyncframeSize;
            i11 = bits8 < iArr.length ? iArr[bits8] : -1;
            i12 = CHANNEL_COUNT_BY_ACMOD[bits10] + (parsableBitArray.readBit() ? 1 : 0);
            i13 = -1;
            i14 = AC3_SYNCFRAME_AUDIO_SAMPLE_COUNT;
        }
        return new SyncFrameInfo(str, i13, i12, i11, i10, i14, i6);
    }

    public static int parseAc3SyncframeSize(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        byte b8 = bArr[4];
        return getAc3SyncframeSize((b8 & 192) >> 6, b8 & Utf8.REPLACEMENT_BYTE);
    }

    public static Format parseEAc3AnnexFFormat(ParsableByteArray parsableByteArray, String str, String str2, DrmInitData drmInitData) {
        String str3;
        ParsableBitArray parsableBitArray = new ParsableBitArray();
        parsableBitArray.reset(parsableByteArray);
        int bits = parsableBitArray.readBits(13) * 1000;
        parsableBitArray.skipBits(3);
        int i6 = SAMPLE_RATE_BY_FSCOD[parsableBitArray.readBits(2)];
        parsableBitArray.skipBits(10);
        int i10 = CHANNEL_COUNT_BY_ACMOD[parsableBitArray.readBits(3)];
        if (parsableBitArray.readBits(1) != 0) {
            i10++;
        }
        parsableBitArray.skipBits(3);
        int bits2 = parsableBitArray.readBits(4);
        parsableBitArray.skipBits(1);
        if (bits2 > 0) {
            parsableBitArray.skipBits(6);
            if (parsableBitArray.readBits(1) != 0) {
                i10 += 2;
            }
            parsableBitArray.skipBits(1);
        }
        if (parsableBitArray.bitsLeft() > 7) {
            parsableBitArray.skipBits(7);
            if (parsableBitArray.readBits(1) != 0) {
                str3 = MimeTypes.AUDIO_E_AC3_JOC;
            } else {
                str3 = MimeTypes.AUDIO_E_AC3;
            }
        } else {
            str3 = MimeTypes.AUDIO_E_AC3;
        }
        parsableBitArray.byteAlign();
        parsableByteArray.setPosition(parsableBitArray.getBytePosition());
        return new Format.Builder().setId(str).setSampleMimeType(str3).setChannelCount(i10).setSampleRate(i6).setDrmInitData(drmInitData).setLanguage(str2).setPeakBitrate(bits).build();
    }

    public static int parseTrueHdSyncframeAudioSampleCount(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b8 = bArr[7];
            if ((b8 & 254) == 186) {
                return 40 << ((bArr[(b8 & 255) == 187 ? '\t' : '\b'] >> 4) & 7);
            }
        }
        return 0;
    }

    public static int parseTrueHdSyncframeAudioSampleCount(ByteBuffer byteBuffer, int i6) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i6) + ((byteBuffer.get((byteBuffer.position() + i6) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }
}

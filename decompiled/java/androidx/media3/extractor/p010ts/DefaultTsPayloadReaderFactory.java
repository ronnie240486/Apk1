package androidx.media3.extractor.p010ts;

import android.util.SparseArray;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import p041d7.AbstractC2301u1;
import p041d7.C2180c5;
import p041d7.C2204g1;

@UnstableApi
public final class DefaultTsPayloadReaderFactory implements TsPayloadReader.Factory {
    private static final int DESCRIPTOR_TAG_CAPTION_SERVICE = 134;
    public static final int FLAG_ALLOW_NON_IDR_KEYFRAMES = 1;
    public static final int FLAG_DETECT_ACCESS_UNITS = 8;
    public static final int FLAG_ENABLE_HDMV_DTS_AUDIO_STREAMS = 64;
    public static final int FLAG_IGNORE_AAC_STREAM = 2;
    public static final int FLAG_IGNORE_H264_STREAM = 4;
    public static final int FLAG_IGNORE_SPLICE_INFO_STREAM = 16;
    public static final int FLAG_OVERRIDE_CAPTION_DESCRIPTORS = 32;
    private final List<Format> closedCaptionFormats;
    private final int flags;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public DefaultTsPayloadReaderFactory() {
        this(0);
    }

    private SeiReader buildSeiReader(TsPayloadReader.EsInfo esInfo) {
        return new SeiReader(getClosedCaptionFormats(esInfo), MimeTypes.VIDEO_MP2T);
    }

    private UserDataReader buildUserDataReader(TsPayloadReader.EsInfo esInfo) {
        return new UserDataReader(getClosedCaptionFormats(esInfo), MimeTypes.VIDEO_MP2T);
    }

    private List<Format> getClosedCaptionFormats(TsPayloadReader.EsInfo esInfo) {
        String str;
        int i6;
        if (isSet(32)) {
            return this.closedCaptionFormats;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(esInfo.descriptorBytes);
        ArrayList arrayList = this.closedCaptionFormats;
        while (parsableByteArray.bytesLeft() > 0) {
            int unsignedByte = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition() + parsableByteArray.readUnsignedByte();
            if (unsignedByte == 134) {
                arrayList = new ArrayList();
                int unsignedByte2 = parsableByteArray.readUnsignedByte() & 31;
                for (int i10 = 0; i10 < unsignedByte2; i10++) {
                    String string = parsableByteArray.readString(3);
                    int unsignedByte3 = parsableByteArray.readUnsignedByte();
                    boolean z7 = (unsignedByte3 & 128) != 0;
                    if (z7) {
                        i6 = unsignedByte3 & 63;
                        str = MimeTypes.APPLICATION_CEA708;
                    } else {
                        str = MimeTypes.APPLICATION_CEA608;
                        i6 = 1;
                    }
                    byte unsignedByte4 = (byte) parsableByteArray.readUnsignedByte();
                    parsableByteArray.skipBytes(1);
                    arrayList.add(new Format.Builder().setSampleMimeType(str).setLanguage(string).setAccessibilityChannel(i6).setInitializationData(z7 ? CodecSpecificDataUtil.buildCea708InitializationData((unsignedByte4 & 64) != 0) : null).build());
                }
            }
            parsableByteArray.setPosition(position);
            arrayList = arrayList;
        }
        return arrayList;
    }

    private boolean isSet(int i6) {
        return (i6 & this.flags) != 0;
    }

    @Override
    public SparseArray<TsPayloadReader> createInitialPayloadReaders() {
        return new SparseArray<>();
    }

    @Override
    public TsPayloadReader createPayloadReader(int i6, TsPayloadReader.EsInfo esInfo) {
        if (i6 != 2) {
            if (i6 == 3 || i6 == 4) {
                return new PesReader(new MpegAudioReader(esInfo.language, esInfo.getRoleFlags(), MimeTypes.VIDEO_MP2T));
            }
            if (i6 == 21) {
                return new PesReader(new Id3Reader(MimeTypes.VIDEO_MP2T));
            }
            if (i6 == 27) {
                if (isSet(4)) {
                    return null;
                }
                return new PesReader(new H264Reader(buildSeiReader(esInfo), isSet(1), isSet(8), MimeTypes.VIDEO_MP2T));
            }
            if (i6 == 36) {
                return new PesReader(new H265Reader(buildSeiReader(esInfo), MimeTypes.VIDEO_MP2T));
            }
            if (i6 == 45) {
                return new PesReader(new MpeghReader(MimeTypes.VIDEO_MP2T));
            }
            if (i6 == 89) {
                return new PesReader(new DvbSubtitleReader(esInfo.dvbSubtitleInfos, MimeTypes.VIDEO_MP2T));
            }
            if (i6 == 172) {
                return new PesReader(new Ac4Reader(esInfo.language, esInfo.getRoleFlags(), MimeTypes.VIDEO_MP2T));
            }
            if (i6 == 257) {
                return new SectionReader(new PassthroughSectionPayloadReader(MimeTypes.APPLICATION_AIT, MimeTypes.VIDEO_MP2T));
            }
            if (i6 != 138) {
                if (i6 == 139) {
                    return new PesReader(new DtsReader(esInfo.language, esInfo.getRoleFlags(), 5408, MimeTypes.VIDEO_MP2T));
                }
                switch (i6) {
                    case 15:
                        if (isSet(2)) {
                            return null;
                        }
                        return new PesReader(new AdtsReader(false, esInfo.language, esInfo.getRoleFlags(), MimeTypes.VIDEO_MP2T));
                    case 16:
                        return new PesReader(new H263Reader(buildUserDataReader(esInfo), MimeTypes.VIDEO_MP2T));
                    case 17:
                        if (isSet(2)) {
                            return null;
                        }
                        return new PesReader(new LatmReader(esInfo.language, esInfo.getRoleFlags(), MimeTypes.VIDEO_MP2T));
                    default:
                        switch (i6) {
                            case 128:
                                break;
                            case TsExtractor.TS_STREAM_TYPE_AC3:
                                return new PesReader(new Ac3Reader(esInfo.language, esInfo.getRoleFlags(), MimeTypes.VIDEO_MP2T));
                            case TsExtractor.TS_STREAM_TYPE_HDMV_DTS:
                                if (!isSet(64)) {
                                    return null;
                                }
                                break;
                            default:
                                switch (i6) {
                                    case 134:
                                        if (isSet(16)) {
                                            return null;
                                        }
                                        return new SectionReader(new PassthroughSectionPayloadReader(MimeTypes.APPLICATION_SCTE35, MimeTypes.VIDEO_MP2T));
                                    case TsExtractor.TS_STREAM_TYPE_E_AC3:
                                        return new PesReader(new Ac3Reader(esInfo.language, esInfo.getRoleFlags(), MimeTypes.VIDEO_MP2T));
                                    case TsExtractor.TS_STREAM_TYPE_DTS_HD:
                                        break;
                                    default:
                                        return null;
                                }
                                break;
                        }
                        break;
                }
            }
            return new PesReader(new DtsReader(esInfo.language, esInfo.getRoleFlags(), 4096, MimeTypes.VIDEO_MP2T));
        }
        return new PesReader(new H262Reader(buildUserDataReader(esInfo), MimeTypes.VIDEO_MP2T));
    }

    public DefaultTsPayloadReaderFactory(int i6) {
        this(i6, C2180c5.f7862e);
        C2204g1 c2204g1 = AbstractC2301u1.f8069b;
    }

    public DefaultTsPayloadReaderFactory(int i6, List<Format> list) {
        this.flags = i6;
        this.closedCaptionFormats = list;
    }
}

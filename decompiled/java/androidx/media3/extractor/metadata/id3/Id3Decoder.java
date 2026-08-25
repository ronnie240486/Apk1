package androidx.media3.extractor.metadata.id3;

import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import androidx.media3.extractor.metadata.SimpleMetadataDecoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import p000a.AbstractC0004e;
import p005a4.C0060s;
import p020b7.AbstractC1332b;
import p041d7.AbstractC2301u1;
import p041d7.C2180c5;
import p041d7.C2288s1;

@UnstableApi
public final class Id3Decoder extends SimpleMetadataDecoder {
    private static final int FRAME_FLAG_V3_HAS_GROUP_IDENTIFIER = 32;
    private static final int FRAME_FLAG_V3_IS_COMPRESSED = 128;
    private static final int FRAME_FLAG_V3_IS_ENCRYPTED = 64;
    private static final int FRAME_FLAG_V4_HAS_DATA_LENGTH = 1;
    private static final int FRAME_FLAG_V4_HAS_GROUP_IDENTIFIER = 64;
    private static final int FRAME_FLAG_V4_IS_COMPRESSED = 8;
    private static final int FRAME_FLAG_V4_IS_ENCRYPTED = 4;
    private static final int FRAME_FLAG_V4_IS_UNSYNCHRONIZED = 2;
    public static final int ID3_HEADER_LENGTH = 10;
    public static final int ID3_TAG = 4801587;
    private static final int ID3_TEXT_ENCODING_ISO_8859_1 = 0;
    private static final int ID3_TEXT_ENCODING_UTF_16 = 1;
    private static final int ID3_TEXT_ENCODING_UTF_16BE = 2;
    private static final int ID3_TEXT_ENCODING_UTF_8 = 3;
    public static final FramePredicate NO_FRAMES_PREDICATE = new C0060s(12);
    private static final String TAG = "Id3Decoder";
    private final FramePredicate framePredicate;

    public interface FramePredicate {
        boolean evaluate(int i6, int i10, int i11, int i12, int i13);
    }

    public static final class Id3Header {
        private final int framesSize;
        private final boolean isUnsynchronized;
        private final int majorVersion;

        public Id3Header(int i6, boolean z7, int i10) {
            this.majorVersion = i6;
            this.isUnsynchronized = z7;
            this.framesSize = i10;
        }
    }

    public Id3Decoder() {
        this(null);
    }

    private static byte[] copyOfRangeIfValid(byte[] bArr, int i6, int i10) {
        return i10 <= i6 ? Util.EMPTY_BYTE_ARRAY : Arrays.copyOfRange(bArr, i6, i10);
    }

    private static ApicFrame decodeApicFrame(ParsableByteArray parsableByteArray, int i6, int i10) {
        int iIndexOfZeroByte;
        String strConcat;
        int unsignedByte = parsableByteArray.readUnsignedByte();
        Charset charset = getCharset(unsignedByte);
        int i11 = i6 - 1;
        byte[] bArr = new byte[i11];
        parsableByteArray.readBytes(bArr, 0, i11);
        if (i10 == 2) {
            strConcat = "image/" + AbstractC1332b.m3231v(new String(bArr, 0, 3, StandardCharsets.ISO_8859_1));
            if ("image/jpg".equals(strConcat)) {
                strConcat = MimeTypes.IMAGE_JPEG;
            }
            iIndexOfZeroByte = 2;
        } else {
            iIndexOfZeroByte = indexOfZeroByte(bArr, 0);
            String strM3231v = AbstractC1332b.m3231v(new String(bArr, 0, iIndexOfZeroByte, StandardCharsets.ISO_8859_1));
            strConcat = strM3231v.indexOf(47) == -1 ? "image/".concat(strM3231v) : strM3231v;
        }
        int i12 = bArr[iIndexOfZeroByte + 1] & 255;
        int i13 = iIndexOfZeroByte + 2;
        int iIndexOfTerminator = indexOfTerminator(bArr, i13, unsignedByte);
        return new ApicFrame(strConcat, new String(bArr, i13, iIndexOfTerminator - i13, charset), i12, copyOfRangeIfValid(bArr, iIndexOfTerminator + delimiterLength(unsignedByte), i11));
    }

    private static BinaryFrame decodeBinaryFrame(ParsableByteArray parsableByteArray, int i6, String str) {
        byte[] bArr = new byte[i6];
        parsableByteArray.readBytes(bArr, 0, i6);
        return new BinaryFrame(str, bArr);
    }

    private static ChapterFrame decodeChapterFrame(ParsableByteArray parsableByteArray, int i6, int i10, boolean z7, int i11, FramePredicate framePredicate) {
        int position = parsableByteArray.getPosition();
        int iIndexOfZeroByte = indexOfZeroByte(parsableByteArray.getData(), position);
        String str = new String(parsableByteArray.getData(), position, iIndexOfZeroByte - position, StandardCharsets.ISO_8859_1);
        parsableByteArray.setPosition(iIndexOfZeroByte + 1);
        int i12 = parsableByteArray.readInt();
        int i13 = parsableByteArray.readInt();
        long unsignedInt = parsableByteArray.readUnsignedInt();
        long j10 = unsignedInt == 4294967295L ? -1L : unsignedInt;
        long unsignedInt2 = parsableByteArray.readUnsignedInt();
        long j11 = unsignedInt2 == 4294967295L ? -1L : unsignedInt2;
        ArrayList arrayList = new ArrayList();
        int i14 = position + i6;
        while (parsableByteArray.getPosition() < i14) {
            Id3Frame id3FrameDecodeFrame = decodeFrame(i10, parsableByteArray, z7, i11, framePredicate);
            if (id3FrameDecodeFrame != null) {
                arrayList.add(id3FrameDecodeFrame);
            }
        }
        return new ChapterFrame(str, i12, i13, j10, j11, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    private static ChapterTocFrame decodeChapterTOCFrame(ParsableByteArray parsableByteArray, int i6, int i10, boolean z7, int i11, FramePredicate framePredicate) {
        int position = parsableByteArray.getPosition();
        int iIndexOfZeroByte = indexOfZeroByte(parsableByteArray.getData(), position);
        String str = new String(parsableByteArray.getData(), position, iIndexOfZeroByte - position, StandardCharsets.ISO_8859_1);
        parsableByteArray.setPosition(iIndexOfZeroByte + 1);
        int unsignedByte = parsableByteArray.readUnsignedByte();
        boolean z10 = (unsignedByte & 2) != 0;
        boolean z11 = (unsignedByte & 1) != 0;
        int unsignedByte2 = parsableByteArray.readUnsignedByte();
        String[] strArr = new String[unsignedByte2];
        for (int i12 = 0; i12 < unsignedByte2; i12++) {
            int position2 = parsableByteArray.getPosition();
            int iIndexOfZeroByte2 = indexOfZeroByte(parsableByteArray.getData(), position2);
            strArr[i12] = new String(parsableByteArray.getData(), position2, iIndexOfZeroByte2 - position2, StandardCharsets.ISO_8859_1);
            parsableByteArray.setPosition(iIndexOfZeroByte2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i13 = position + i6;
        while (parsableByteArray.getPosition() < i13) {
            Id3Frame id3FrameDecodeFrame = decodeFrame(i10, parsableByteArray, z7, i11, framePredicate);
            if (id3FrameDecodeFrame != null) {
                arrayList.add(id3FrameDecodeFrame);
            }
        }
        return new ChapterTocFrame(str, z10, z11, strArr, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    private static CommentFrame decodeCommentFrame(ParsableByteArray parsableByteArray, int i6) {
        if (i6 < 4) {
            return null;
        }
        int unsignedByte = parsableByteArray.readUnsignedByte();
        Charset charset = getCharset(unsignedByte);
        byte[] bArr = new byte[3];
        parsableByteArray.readBytes(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i10 = i6 - 4;
        byte[] bArr2 = new byte[i10];
        parsableByteArray.readBytes(bArr2, 0, i10);
        int iIndexOfTerminator = indexOfTerminator(bArr2, 0, unsignedByte);
        String str2 = new String(bArr2, 0, iIndexOfTerminator, charset);
        int iDelimiterLength = iIndexOfTerminator + delimiterLength(unsignedByte);
        return new CommentFrame(str, str2, decodeStringIfValid(bArr2, iDelimiterLength, indexOfTerminator(bArr2, iDelimiterLength, unsignedByte), charset));
    }

    private static Id3Frame decodeFrame(int i6, ParsableByteArray parsableByteArray, boolean z7, int i10, FramePredicate framePredicate) {
        int unsignedIntToInt;
        int i11;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        Id3Frame id3FrameDecodeBinaryFrame;
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int unsignedByte2 = parsableByteArray.readUnsignedByte();
        int unsignedByte3 = parsableByteArray.readUnsignedByte();
        int unsignedByte4 = i6 >= 3 ? parsableByteArray.readUnsignedByte() : 0;
        if (i6 == 4) {
            unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            if (!z7) {
                unsignedIntToInt = (((unsignedIntToInt >> 24) & 255) << 21) | (unsignedIntToInt & 255) | (((unsignedIntToInt >> 8) & 255) << 7) | (((unsignedIntToInt >> 16) & 255) << 14);
            }
        } else {
            unsignedIntToInt = i6 == 3 ? parsableByteArray.readUnsignedIntToInt() : parsableByteArray.readUnsignedInt24();
        }
        int iRemoveUnsynchronization = unsignedIntToInt;
        int unsignedShort = i6 >= 3 ? parsableByteArray.readUnsignedShort() : 0;
        Id3Frame id3Frame = null;
        if (unsignedByte == 0 && unsignedByte2 == 0 && unsignedByte3 == 0 && unsignedByte4 == 0 && iRemoveUnsynchronization == 0 && unsignedShort == 0) {
            parsableByteArray.setPosition(parsableByteArray.limit());
            return null;
        }
        int position = parsableByteArray.getPosition() + iRemoveUnsynchronization;
        if (position > parsableByteArray.limit()) {
            Log.m1719w(TAG, "Frame size exceeds remaining tag data");
            parsableByteArray.setPosition(parsableByteArray.limit());
            return null;
        }
        if (framePredicate != null) {
            i11 = position;
            if (!framePredicate.evaluate(i6, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4)) {
                parsableByteArray.setPosition(i11);
                return null;
            }
        } else {
            i11 = position;
        }
        if (i6 == 3) {
            boolean z15 = (unsignedShort & 128) != 0;
            z12 = (unsignedShort & 64) != 0;
            z14 = z15;
            z13 = false;
            z11 = (unsignedShort & 32) != 0;
            z10 = z14;
        } else if (i6 == 4) {
            z11 = (unsignedShort & 64) != 0;
            boolean z16 = (unsignedShort & 8) != 0;
            boolean z17 = (unsignedShort & 4) != 0;
            z13 = (unsignedShort & 2) != 0;
            z14 = (unsignedShort & 1) != 0;
            z10 = z16;
            z12 = z17;
        } else {
            z10 = false;
            z11 = false;
            z12 = false;
            z13 = false;
            z14 = false;
        }
        if (z10 || z12) {
            Log.m1719w(TAG, "Skipping unsupported compressed or encrypted frame");
            parsableByteArray.setPosition(i11);
            return null;
        }
        if (z11) {
            iRemoveUnsynchronization--;
            parsableByteArray.skipBytes(1);
        }
        if (z14) {
            iRemoveUnsynchronization -= 4;
            parsableByteArray.skipBytes(4);
        }
        if (z13) {
            iRemoveUnsynchronization = removeUnsynchronization(parsableByteArray, iRemoveUnsynchronization);
        }
        try {
            if (unsignedByte == 84 && unsignedByte2 == 88 && unsignedByte3 == 88 && (i6 == 2 || unsignedByte4 == 88)) {
                id3FrameDecodeBinaryFrame = decodeTxxxFrame(parsableByteArray, iRemoveUnsynchronization);
            } else if (unsignedByte == 84) {
                id3FrameDecodeBinaryFrame = decodeTextInformationFrame(parsableByteArray, iRemoveUnsynchronization, getFrameId(i6, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4));
            } else if (unsignedByte == 87 && unsignedByte2 == 88 && unsignedByte3 == 88 && (i6 == 2 || unsignedByte4 == 88)) {
                id3FrameDecodeBinaryFrame = decodeWxxxFrame(parsableByteArray, iRemoveUnsynchronization);
            } else if (unsignedByte == 87) {
                id3FrameDecodeBinaryFrame = decodeUrlLinkFrame(parsableByteArray, iRemoveUnsynchronization, getFrameId(i6, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4));
            } else if (unsignedByte == 80 && unsignedByte2 == 82 && unsignedByte3 == 73 && unsignedByte4 == 86) {
                id3FrameDecodeBinaryFrame = decodePrivFrame(parsableByteArray, iRemoveUnsynchronization);
            } else if (unsignedByte == 71 && unsignedByte2 == 69 && unsignedByte3 == 79 && (unsignedByte4 == 66 || i6 == 2)) {
                id3FrameDecodeBinaryFrame = decodeGeobFrame(parsableByteArray, iRemoveUnsynchronization);
            } else if (i6 == 2) {
                if (unsignedByte == 80 && unsignedByte2 == 73 && unsignedByte3 == 67) {
                    id3FrameDecodeBinaryFrame = decodeApicFrame(parsableByteArray, iRemoveUnsynchronization, i6);
                } else if (unsignedByte != 67 && unsignedByte2 == 79 && unsignedByte3 == 77 && (unsignedByte4 == 77 || i6 == 2)) {
                    id3FrameDecodeBinaryFrame = decodeCommentFrame(parsableByteArray, iRemoveUnsynchronization);
                } else if (unsignedByte != 67 && unsignedByte2 == 72 && unsignedByte3 == 65 && unsignedByte4 == 80) {
                    id3FrameDecodeBinaryFrame = decodeChapterFrame(parsableByteArray, iRemoveUnsynchronization, i6, z7, i10, framePredicate);
                } else if (unsignedByte != 67 && unsignedByte2 == 84 && unsignedByte3 == 79 && unsignedByte4 == 67) {
                    id3FrameDecodeBinaryFrame = decodeChapterTOCFrame(parsableByteArray, iRemoveUnsynchronization, i6, z7, i10, framePredicate);
                } else if (unsignedByte != 77 && unsignedByte2 == 76 && unsignedByte3 == 76 && unsignedByte4 == 84) {
                    id3FrameDecodeBinaryFrame = decodeMlltFrame(parsableByteArray, iRemoveUnsynchronization);
                } else {
                    id3FrameDecodeBinaryFrame = decodeBinaryFrame(parsableByteArray, iRemoveUnsynchronization, getFrameId(i6, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4));
                }
            } else if (unsignedByte == 65 && unsignedByte2 == 80 && unsignedByte3 == 73 && unsignedByte4 == 67) {
                id3FrameDecodeBinaryFrame = decodeApicFrame(parsableByteArray, iRemoveUnsynchronization, i6);
            } else if (unsignedByte != 67) {
                if (unsignedByte != 67) {
                    if (unsignedByte != 67) {
                        if (unsignedByte != 77) {
                            id3FrameDecodeBinaryFrame = decodeBinaryFrame(parsableByteArray, iRemoveUnsynchronization, getFrameId(i6, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4));
                        } else {
                            id3FrameDecodeBinaryFrame = decodeBinaryFrame(parsableByteArray, iRemoveUnsynchronization, getFrameId(i6, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4));
                        }
                    } else if (unsignedByte != 77) {
                        id3FrameDecodeBinaryFrame = decodeBinaryFrame(parsableByteArray, iRemoveUnsynchronization, getFrameId(i6, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4));
                    } else {
                        id3FrameDecodeBinaryFrame = decodeBinaryFrame(parsableByteArray, iRemoveUnsynchronization, getFrameId(i6, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4));
                    }
                } else if (unsignedByte != 67) {
                    if (unsignedByte != 77) {
                        id3FrameDecodeBinaryFrame = decodeBinaryFrame(parsableByteArray, iRemoveUnsynchronization, getFrameId(i6, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4));
                    } else {
                        id3FrameDecodeBinaryFrame = decodeBinaryFrame(parsableByteArray, iRemoveUnsynchronization, getFrameId(i6, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4));
                    }
                } else if (unsignedByte != 77) {
                    id3FrameDecodeBinaryFrame = decodeBinaryFrame(parsableByteArray, iRemoveUnsynchronization, getFrameId(i6, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4));
                } else {
                    id3FrameDecodeBinaryFrame = decodeBinaryFrame(parsableByteArray, iRemoveUnsynchronization, getFrameId(i6, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4));
                }
            } else if (unsignedByte != 67) {
                if (unsignedByte != 67) {
                    if (unsignedByte != 77) {
                        id3FrameDecodeBinaryFrame = decodeBinaryFrame(parsableByteArray, iRemoveUnsynchronization, getFrameId(i6, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4));
                    } else {
                        id3FrameDecodeBinaryFrame = decodeBinaryFrame(parsableByteArray, iRemoveUnsynchronization, getFrameId(i6, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4));
                    }
                } else if (unsignedByte != 77) {
                    id3FrameDecodeBinaryFrame = decodeBinaryFrame(parsableByteArray, iRemoveUnsynchronization, getFrameId(i6, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4));
                } else {
                    id3FrameDecodeBinaryFrame = decodeBinaryFrame(parsableByteArray, iRemoveUnsynchronization, getFrameId(i6, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4));
                }
            } else if (unsignedByte != 67) {
                if (unsignedByte != 77) {
                    id3FrameDecodeBinaryFrame = decodeBinaryFrame(parsableByteArray, iRemoveUnsynchronization, getFrameId(i6, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4));
                } else {
                    id3FrameDecodeBinaryFrame = decodeBinaryFrame(parsableByteArray, iRemoveUnsynchronization, getFrameId(i6, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4));
                }
            } else if (unsignedByte != 77) {
                id3FrameDecodeBinaryFrame = decodeBinaryFrame(parsableByteArray, iRemoveUnsynchronization, getFrameId(i6, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4));
            } else {
                id3FrameDecodeBinaryFrame = decodeBinaryFrame(parsableByteArray, iRemoveUnsynchronization, getFrameId(i6, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4));
            }
            parsableByteArray.setPosition(i11);
            id3Frame = id3FrameDecodeBinaryFrame;
            e = null;
        } catch (Exception e5) {
            e = e5;
        } catch (OutOfMemoryError e10) {
            e = e10;
        } finally {
            parsableByteArray.setPosition(i11);
        }
        if (id3Frame == null) {
            Log.m1720w(TAG, "Failed to decode frame: id=" + getFrameId(i6, unsignedByte, unsignedByte2, unsignedByte3, unsignedByte4) + ", frameSize=" + iRemoveUnsynchronization, e);
        }
        return id3Frame;
    }

    private static GeobFrame decodeGeobFrame(ParsableByteArray parsableByteArray, int i6) {
        int unsignedByte = parsableByteArray.readUnsignedByte();
        Charset charset = getCharset(unsignedByte);
        int i10 = i6 - 1;
        byte[] bArr = new byte[i10];
        parsableByteArray.readBytes(bArr, 0, i10);
        int iIndexOfZeroByte = indexOfZeroByte(bArr, 0);
        String strNormalizeMimeType = MimeTypes.normalizeMimeType(new String(bArr, 0, iIndexOfZeroByte, StandardCharsets.ISO_8859_1));
        int i11 = iIndexOfZeroByte + 1;
        int iIndexOfTerminator = indexOfTerminator(bArr, i11, unsignedByte);
        String strDecodeStringIfValid = decodeStringIfValid(bArr, i11, iIndexOfTerminator, charset);
        int iDelimiterLength = iIndexOfTerminator + delimiterLength(unsignedByte);
        int iIndexOfTerminator2 = indexOfTerminator(bArr, iDelimiterLength, unsignedByte);
        return new GeobFrame(strNormalizeMimeType, strDecodeStringIfValid, decodeStringIfValid(bArr, iDelimiterLength, iIndexOfTerminator2, charset), copyOfRangeIfValid(bArr, iIndexOfTerminator2 + delimiterLength(unsignedByte), i10));
    }

    private static Id3Header decodeHeader(ParsableByteArray parsableByteArray) {
        boolean z7 = false;
        if (parsableByteArray.bytesLeft() < 10) {
            Log.m1719w(TAG, "Data too short to be an ID3 tag");
            return null;
        }
        int unsignedInt24 = parsableByteArray.readUnsignedInt24();
        if (unsignedInt24 != 4801587) {
            Log.m1719w(TAG, "Unexpected first three bytes of ID3 tag header: 0x".concat(String.format("%06X", Integer.valueOf(unsignedInt24))));
            return null;
        }
        int unsignedByte = parsableByteArray.readUnsignedByte();
        parsableByteArray.skipBytes(1);
        int unsignedByte2 = parsableByteArray.readUnsignedByte();
        int synchSafeInt = parsableByteArray.readSynchSafeInt();
        if (unsignedByte == 2) {
            if ((unsignedByte2 & 64) != 0) {
                Log.m1719w(TAG, "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (unsignedByte == 3) {
            if ((unsignedByte2 & 64) != 0) {
                int i6 = parsableByteArray.readInt();
                parsableByteArray.skipBytes(i6);
                synchSafeInt -= i6 + 4;
            }
        } else {
            if (unsignedByte != 4) {
                AbstractC0004e.m31y(unsignedByte, "Skipped ID3 tag with unsupported majorVersion=", TAG);
                return null;
            }
            if ((unsignedByte2 & 64) != 0) {
                int synchSafeInt2 = parsableByteArray.readSynchSafeInt();
                parsableByteArray.skipBytes(synchSafeInt2 - 4);
                synchSafeInt -= synchSafeInt2;
            }
            if ((unsignedByte2 & 16) != 0) {
                synchSafeInt -= 10;
            }
        }
        if (unsignedByte < 4 && (unsignedByte2 & 128) != 0) {
            z7 = true;
        }
        return new Id3Header(unsignedByte, z7, synchSafeInt);
    }

    private static MlltFrame decodeMlltFrame(ParsableByteArray parsableByteArray, int i6) {
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int unsignedInt24 = parsableByteArray.readUnsignedInt24();
        int unsignedInt25 = parsableByteArray.readUnsignedInt24();
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int unsignedByte2 = parsableByteArray.readUnsignedByte();
        ParsableBitArray parsableBitArray = new ParsableBitArray();
        parsableBitArray.reset(parsableByteArray);
        int i10 = ((i6 - 10) * 8) / (unsignedByte + unsignedByte2);
        int[] iArr = new int[i10];
        int[] iArr2 = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            int bits = parsableBitArray.readBits(unsignedByte);
            int bits2 = parsableBitArray.readBits(unsignedByte2);
            iArr[i11] = bits;
            iArr2[i11] = bits2;
        }
        return new MlltFrame(unsignedShort, unsignedInt24, unsignedInt25, iArr, iArr2);
    }

    private static PrivFrame decodePrivFrame(ParsableByteArray parsableByteArray, int i6) {
        byte[] bArr = new byte[i6];
        parsableByteArray.readBytes(bArr, 0, i6);
        int iIndexOfZeroByte = indexOfZeroByte(bArr, 0);
        return new PrivFrame(new String(bArr, 0, iIndexOfZeroByte, StandardCharsets.ISO_8859_1), copyOfRangeIfValid(bArr, iIndexOfZeroByte + 1, i6));
    }

    private static String decodeStringIfValid(byte[] bArr, int i6, int i10, Charset charset) {
        return (i10 <= i6 || i10 > bArr.length) ? "" : new String(bArr, i6, i10 - i6, charset);
    }

    private static TextInformationFrame decodeTextInformationFrame(ParsableByteArray parsableByteArray, int i6, String str) {
        if (i6 < 1) {
            return null;
        }
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int i10 = i6 - 1;
        byte[] bArr = new byte[i10];
        parsableByteArray.readBytes(bArr, 0, i10);
        return new TextInformationFrame(str, (String) null, decodeTextInformationFrameValues(bArr, unsignedByte, 0));
    }

    private static AbstractC2301u1 decodeTextInformationFrameValues(byte[] bArr, int i6, int i10) {
        if (i10 >= bArr.length) {
            return AbstractC2301u1.m5275r("");
        }
        C2288s1 c2288s1M5269k = AbstractC2301u1.m5269k();
        int iIndexOfTerminator = indexOfTerminator(bArr, i10, i6);
        while (i10 < iIndexOfTerminator) {
            c2288s1M5269k.m5255a(new String(bArr, i10, iIndexOfTerminator - i10, getCharset(i6)));
            i10 = delimiterLength(i6) + iIndexOfTerminator;
            iIndexOfTerminator = indexOfTerminator(bArr, i10, i6);
        }
        C2180c5 c2180c5M5262g = c2288s1M5269k.m5262g();
        return c2180c5M5262g.isEmpty() ? AbstractC2301u1.m5275r("") : c2180c5M5262g;
    }

    private static TextInformationFrame decodeTxxxFrame(ParsableByteArray parsableByteArray, int i6) {
        if (i6 < 1) {
            return null;
        }
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int i10 = i6 - 1;
        byte[] bArr = new byte[i10];
        parsableByteArray.readBytes(bArr, 0, i10);
        int iIndexOfTerminator = indexOfTerminator(bArr, 0, unsignedByte);
        return new TextInformationFrame("TXXX", new String(bArr, 0, iIndexOfTerminator, getCharset(unsignedByte)), decodeTextInformationFrameValues(bArr, unsignedByte, iIndexOfTerminator + delimiterLength(unsignedByte)));
    }

    private static UrlLinkFrame decodeUrlLinkFrame(ParsableByteArray parsableByteArray, int i6, String str) {
        byte[] bArr = new byte[i6];
        parsableByteArray.readBytes(bArr, 0, i6);
        return new UrlLinkFrame(str, null, new String(bArr, 0, indexOfZeroByte(bArr, 0), StandardCharsets.ISO_8859_1));
    }

    private static UrlLinkFrame decodeWxxxFrame(ParsableByteArray parsableByteArray, int i6) {
        if (i6 < 1) {
            return null;
        }
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int i10 = i6 - 1;
        byte[] bArr = new byte[i10];
        parsableByteArray.readBytes(bArr, 0, i10);
        int iIndexOfTerminator = indexOfTerminator(bArr, 0, unsignedByte);
        String str = new String(bArr, 0, iIndexOfTerminator, getCharset(unsignedByte));
        int iDelimiterLength = iIndexOfTerminator + delimiterLength(unsignedByte);
        return new UrlLinkFrame("WXXX", str, decodeStringIfValid(bArr, iDelimiterLength, indexOfZeroByte(bArr, iDelimiterLength), StandardCharsets.ISO_8859_1));
    }

    private static int delimiterLength(int i6) {
        return (i6 == 0 || i6 == 3) ? 1 : 2;
    }

    private static Charset getCharset(int i6) {
        if (i6 == 1) {
            return StandardCharsets.UTF_16;
        }
        if (i6 != 2) {
            return i6 != 3 ? StandardCharsets.ISO_8859_1 : StandardCharsets.UTF_8;
        }
        return StandardCharsets.UTF_16BE;
    }

    private static String getFrameId(int i6, int i10, int i11, int i12, int i13) {
        return i6 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13));
    }

    private static int indexOfTerminator(byte[] bArr, int i6, int i10) {
        int iIndexOfZeroByte = indexOfZeroByte(bArr, i6);
        if (i10 == 0 || i10 == 3) {
            return iIndexOfZeroByte;
        }
        while (iIndexOfZeroByte < bArr.length - 1) {
            if ((iIndexOfZeroByte - i6) % 2 == 0 && bArr[iIndexOfZeroByte + 1] == 0) {
                return iIndexOfZeroByte;
            }
            iIndexOfZeroByte = indexOfZeroByte(bArr, iIndexOfZeroByte + 1);
        }
        return bArr.length;
    }

    private static int indexOfZeroByte(byte[] bArr, int i6) {
        while (i6 < bArr.length) {
            if (bArr[i6] == 0) {
                return i6;
            }
            i6++;
        }
        return bArr.length;
    }

    public static boolean lambda$static$0(int i6, int i10, int i11, int i12, int i13) {
        return false;
    }

    private static int removeUnsynchronization(ParsableByteArray parsableByteArray, int i6) {
        byte[] data = parsableByteArray.getData();
        int position = parsableByteArray.getPosition();
        int i10 = position;
        while (true) {
            int i11 = i10 + 1;
            if (i11 >= position + i6) {
                return i6;
            }
            if ((data[i10] & 255) == 255 && data[i11] == 0) {
                System.arraycopy(data, i10 + 2, data, i11, (i6 - (i10 - position)) - 2);
                i6--;
            }
            i10 = i11;
        }
    }

    private static boolean validateFrames(ParsableByteArray parsableByteArray, int i6, int i10, boolean z7) {
        int unsignedInt24;
        long unsignedInt25;
        int unsignedShort;
        int i11;
        int position = parsableByteArray.getPosition();
        while (true) {
            try {
                boolean z10 = true;
                if (parsableByteArray.bytesLeft() < i10) {
                    parsableByteArray.setPosition(position);
                    return true;
                }
                if (i6 >= 3) {
                    unsignedInt24 = parsableByteArray.readInt();
                    unsignedInt25 = parsableByteArray.readUnsignedInt();
                    unsignedShort = parsableByteArray.readUnsignedShort();
                } else {
                    unsignedInt24 = parsableByteArray.readUnsignedInt24();
                    unsignedInt25 = parsableByteArray.readUnsignedInt24();
                    unsignedShort = 0;
                }
                if (unsignedInt24 == 0 && unsignedInt25 == 0 && unsignedShort == 0) {
                    parsableByteArray.setPosition(position);
                    return true;
                }
                if (i6 == 4 && !z7) {
                    if ((8421504 & unsignedInt25) != 0) {
                        parsableByteArray.setPosition(position);
                        return false;
                    }
                    unsignedInt25 = (((unsignedInt25 >> 24) & 255) << 21) | (unsignedInt25 & 255) | (((unsignedInt25 >> 8) & 255) << 7) | (((unsignedInt25 >> 16) & 255) << 14);
                }
                if (i6 == 4) {
                    i11 = (unsignedShort & 64) != 0 ? 1 : 0;
                    if ((unsignedShort & 1) == 0) {
                        z10 = false;
                    }
                } else {
                    if (i6 == 3) {
                        i11 = (unsignedShort & 32) != 0 ? 1 : 0;
                        if ((unsignedShort & 128) == 0) {
                        }
                    } else {
                        i11 = 0;
                    }
                    z10 = false;
                }
                if (z10) {
                    i11 += 4;
                }
                if (unsignedInt25 < i11) {
                    parsableByteArray.setPosition(position);
                    return false;
                }
                if (parsableByteArray.bytesLeft() < unsignedInt25) {
                    parsableByteArray.setPosition(position);
                    return false;
                }
                parsableByteArray.skipBytes((int) unsignedInt25);
            } catch (Throwable th) {
                parsableByteArray.setPosition(position);
                throw th;
            }
        }
    }

    @Override
    public Metadata decode(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        return decode(byteBuffer.array(), byteBuffer.limit());
    }

    public Id3Decoder(FramePredicate framePredicate) {
        this.framePredicate = framePredicate;
    }

    public Metadata decode(byte[] bArr, int i6) {
        ArrayList arrayList = new ArrayList();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i6);
        Id3Header id3HeaderDecodeHeader = decodeHeader(parsableByteArray);
        if (id3HeaderDecodeHeader == null) {
            return null;
        }
        int position = parsableByteArray.getPosition();
        int i10 = id3HeaderDecodeHeader.majorVersion == 2 ? 6 : 10;
        int iRemoveUnsynchronization = id3HeaderDecodeHeader.framesSize;
        if (id3HeaderDecodeHeader.isUnsynchronized) {
            iRemoveUnsynchronization = removeUnsynchronization(parsableByteArray, id3HeaderDecodeHeader.framesSize);
        }
        parsableByteArray.setLimit(position + iRemoveUnsynchronization);
        boolean z7 = false;
        if (!validateFrames(parsableByteArray, id3HeaderDecodeHeader.majorVersion, i10, false)) {
            if (id3HeaderDecodeHeader.majorVersion != 4 || !validateFrames(parsableByteArray, 4, i10, true)) {
                Log.m1719w(TAG, "Failed to validate ID3 tag with majorVersion=" + id3HeaderDecodeHeader.majorVersion);
                return null;
            }
            z7 = true;
        }
        while (parsableByteArray.bytesLeft() >= i10) {
            Id3Frame id3FrameDecodeFrame = decodeFrame(id3HeaderDecodeHeader.majorVersion, parsableByteArray, z7, i10, this.framePredicate);
            if (id3FrameDecodeFrame != null) {
                arrayList.add(id3FrameDecodeFrame);
            }
        }
        return new Metadata(arrayList);
    }
}

package androidx.media3.extractor.mp4;

import androidx.media3.common.C0565C;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.Mp4Box;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.metadata.id3.ApicFrame;
import androidx.media3.extractor.metadata.id3.CommentFrame;
import androidx.media3.extractor.metadata.id3.Id3Frame;
import androidx.media3.extractor.metadata.id3.Id3Util;
import androidx.media3.extractor.metadata.id3.InternalFrame;
import androidx.media3.extractor.metadata.id3.TextInformationFrame;
import p000a.AbstractC0004e;
import p041d7.AbstractC2301u1;

final class MetadataUtil {
    private static final int PICTURE_TYPE_FRONT_COVER = 3;
    private static final int SHORT_TYPE_ALBUM = 6384738;
    private static final int SHORT_TYPE_ARTIST = 4280916;
    private static final int SHORT_TYPE_COMMENT = 6516084;
    private static final int SHORT_TYPE_COMPOSER_1 = 6516589;
    private static final int SHORT_TYPE_COMPOSER_2 = 7828084;
    private static final int SHORT_TYPE_ENCODER = 7630703;
    private static final int SHORT_TYPE_GENRE = 6776174;
    private static final int SHORT_TYPE_LYRICS = 7108978;
    private static final int SHORT_TYPE_NAME_1 = 7233901;
    private static final int SHORT_TYPE_NAME_2 = 7631467;
    private static final int SHORT_TYPE_YEAR = 6578553;
    private static final String TAG = "MetadataUtil";
    private static final int TYPE_ALBUM_ARTIST = 1631670868;
    private static final int TYPE_COMPILATION = 1668311404;
    private static final int TYPE_COVER_ART = 1668249202;
    private static final int TYPE_DISK_NUMBER = 1684632427;
    private static final int TYPE_GAPLESS_ALBUM = 1885823344;
    private static final int TYPE_GENRE = 1735291493;
    private static final int TYPE_GROUPING = 6779504;
    private static final int TYPE_INTERNAL = 757935405;
    private static final int TYPE_RATING = 1920233063;
    private static final int TYPE_SORT_ALBUM = 1936679276;
    private static final int TYPE_SORT_ALBUM_ARTIST = 1936679265;
    private static final int TYPE_SORT_ARTIST = 1936679282;
    private static final int TYPE_SORT_COMPOSER = 1936679791;
    private static final int TYPE_SORT_TRACK_NAME = 1936682605;
    private static final int TYPE_TEMPO = 1953329263;
    private static final int TYPE_TOP_BYTE_COPYRIGHT = 169;
    private static final int TYPE_TOP_BYTE_REPLACEMENT = 253;
    private static final int TYPE_TRACK_NUMBER = 1953655662;
    private static final int TYPE_TV_SHOW = 1953919848;
    private static final int TYPE_TV_SORT_SHOW = 1936683886;

    private MetadataUtil() {
    }

    public static MdtaMetadataEntry findMdtaMetadataEntryWithKey(Metadata metadata, String str) {
        for (int i6 = 0; i6 < metadata.length(); i6++) {
            Metadata.Entry entry = metadata.get(i6);
            if (entry instanceof MdtaMetadataEntry) {
                MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) entry;
                if (mdtaMetadataEntry.key.equals(str)) {
                    return mdtaMetadataEntry;
                }
            }
        }
        return null;
    }

    private static CommentFrame parseCommentAttribute(int i6, ParsableByteArray parsableByteArray) {
        int i10 = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385) {
            parsableByteArray.skipBytes(8);
            String nullTerminatedString = parsableByteArray.readNullTerminatedString(i10 - 16);
            return new CommentFrame(C0565C.LANGUAGE_UNDETERMINED, nullTerminatedString, nullTerminatedString);
        }
        Log.m1719w(TAG, "Failed to parse comment attribute: " + Mp4Box.getBoxTypeString(i6));
        return null;
    }

    private static ApicFrame parseCoverArt(ParsableByteArray parsableByteArray) {
        String str;
        int i6 = parsableByteArray.readInt();
        if (parsableByteArray.readInt() != 1684108385) {
            Log.m1719w(TAG, "Failed to parse cover art attribute");
            return null;
        }
        int fullBoxFlags = BoxParser.parseFullBoxFlags(parsableByteArray.readInt());
        if (fullBoxFlags == 13) {
            str = MimeTypes.IMAGE_JPEG;
        } else {
            str = fullBoxFlags == 14 ? MimeTypes.IMAGE_PNG : null;
        }
        if (str == null) {
            AbstractC0004e.m31y(fullBoxFlags, "Unrecognized cover art flags: ", TAG);
            return null;
        }
        parsableByteArray.skipBytes(4);
        int i10 = i6 - 16;
        byte[] bArr = new byte[i10];
        parsableByteArray.readBytes(bArr, 0, i10);
        return new ApicFrame(str, null, 3, bArr);
    }

    public static Metadata.Entry parseIlstElement(ParsableByteArray parsableByteArray) {
        int i6 = parsableByteArray.readInt() + parsableByteArray.getPosition();
        int i10 = parsableByteArray.readInt();
        int i11 = (i10 >> 24) & 255;
        try {
            if (i11 == 169 || i11 == TYPE_TOP_BYTE_REPLACEMENT) {
                int i12 = 16777215 & i10;
                if (i12 == SHORT_TYPE_COMMENT) {
                    CommentFrame commentAttribute = parseCommentAttribute(i10, parsableByteArray);
                    parsableByteArray.setPosition(i6);
                    return commentAttribute;
                }
                if (i12 == SHORT_TYPE_NAME_1 || i12 == SHORT_TYPE_NAME_2) {
                    TextInformationFrame textAttribute = parseTextAttribute(i10, "TIT2", parsableByteArray);
                    parsableByteArray.setPosition(i6);
                    return textAttribute;
                }
                if (i12 == SHORT_TYPE_COMPOSER_1 || i12 == SHORT_TYPE_COMPOSER_2) {
                    TextInformationFrame textAttribute2 = parseTextAttribute(i10, "TCOM", parsableByteArray);
                    parsableByteArray.setPosition(i6);
                    return textAttribute2;
                }
                if (i12 == SHORT_TYPE_YEAR) {
                    TextInformationFrame textAttribute3 = parseTextAttribute(i10, "TDRC", parsableByteArray);
                    parsableByteArray.setPosition(i6);
                    return textAttribute3;
                }
                if (i12 == SHORT_TYPE_ARTIST) {
                    TextInformationFrame textAttribute4 = parseTextAttribute(i10, "TPE1", parsableByteArray);
                    parsableByteArray.setPosition(i6);
                    return textAttribute4;
                }
                if (i12 == SHORT_TYPE_ENCODER) {
                    TextInformationFrame textAttribute5 = parseTextAttribute(i10, "TSSE", parsableByteArray);
                    parsableByteArray.setPosition(i6);
                    return textAttribute5;
                }
                if (i12 == SHORT_TYPE_ALBUM) {
                    TextInformationFrame textAttribute6 = parseTextAttribute(i10, "TALB", parsableByteArray);
                    parsableByteArray.setPosition(i6);
                    return textAttribute6;
                }
                if (i12 == SHORT_TYPE_LYRICS) {
                    TextInformationFrame textAttribute7 = parseTextAttribute(i10, "USLT", parsableByteArray);
                    parsableByteArray.setPosition(i6);
                    return textAttribute7;
                }
                if (i12 == SHORT_TYPE_GENRE) {
                    TextInformationFrame textAttribute8 = parseTextAttribute(i10, "TCON", parsableByteArray);
                    parsableByteArray.setPosition(i6);
                    return textAttribute8;
                }
                if (i12 == TYPE_GROUPING) {
                    TextInformationFrame textAttribute9 = parseTextAttribute(i10, "TIT1", parsableByteArray);
                    parsableByteArray.setPosition(i6);
                    return textAttribute9;
                }
            } else {
                if (i10 == TYPE_GENRE) {
                    TextInformationFrame standardGenreAttribute = parseStandardGenreAttribute(parsableByteArray);
                    parsableByteArray.setPosition(i6);
                    return standardGenreAttribute;
                }
                if (i10 == TYPE_DISK_NUMBER) {
                    TextInformationFrame indexAndCountAttribute = parseIndexAndCountAttribute(i10, "TPOS", parsableByteArray);
                    parsableByteArray.setPosition(i6);
                    return indexAndCountAttribute;
                }
                if (i10 == TYPE_TRACK_NUMBER) {
                    TextInformationFrame indexAndCountAttribute2 = parseIndexAndCountAttribute(i10, "TRCK", parsableByteArray);
                    parsableByteArray.setPosition(i6);
                    return indexAndCountAttribute2;
                }
                if (i10 == TYPE_TEMPO) {
                    Id3Frame integerAttribute = parseIntegerAttribute(i10, "TBPM", parsableByteArray, true, false);
                    parsableByteArray.setPosition(i6);
                    return integerAttribute;
                }
                if (i10 == TYPE_COMPILATION) {
                    Id3Frame integerAttribute2 = parseIntegerAttribute(i10, "TCMP", parsableByteArray, true, true);
                    parsableByteArray.setPosition(i6);
                    return integerAttribute2;
                }
                if (i10 == TYPE_COVER_ART) {
                    ApicFrame coverArt = parseCoverArt(parsableByteArray);
                    parsableByteArray.setPosition(i6);
                    return coverArt;
                }
                if (i10 == TYPE_ALBUM_ARTIST) {
                    TextInformationFrame textAttribute10 = parseTextAttribute(i10, "TPE2", parsableByteArray);
                    parsableByteArray.setPosition(i6);
                    return textAttribute10;
                }
                if (i10 == TYPE_SORT_TRACK_NAME) {
                    TextInformationFrame textAttribute11 = parseTextAttribute(i10, "TSOT", parsableByteArray);
                    parsableByteArray.setPosition(i6);
                    return textAttribute11;
                }
                if (i10 == TYPE_SORT_ALBUM) {
                    TextInformationFrame textAttribute12 = parseTextAttribute(i10, "TSOA", parsableByteArray);
                    parsableByteArray.setPosition(i6);
                    return textAttribute12;
                }
                if (i10 == TYPE_SORT_ARTIST) {
                    TextInformationFrame textAttribute13 = parseTextAttribute(i10, "TSOP", parsableByteArray);
                    parsableByteArray.setPosition(i6);
                    return textAttribute13;
                }
                if (i10 == TYPE_SORT_ALBUM_ARTIST) {
                    TextInformationFrame textAttribute14 = parseTextAttribute(i10, "TSO2", parsableByteArray);
                    parsableByteArray.setPosition(i6);
                    return textAttribute14;
                }
                if (i10 == TYPE_SORT_COMPOSER) {
                    TextInformationFrame textAttribute15 = parseTextAttribute(i10, "TSOC", parsableByteArray);
                    parsableByteArray.setPosition(i6);
                    return textAttribute15;
                }
                if (i10 == TYPE_RATING) {
                    Id3Frame integerAttribute3 = parseIntegerAttribute(i10, "ITUNESADVISORY", parsableByteArray, false, false);
                    parsableByteArray.setPosition(i6);
                    return integerAttribute3;
                }
                if (i10 == TYPE_GAPLESS_ALBUM) {
                    Id3Frame integerAttribute4 = parseIntegerAttribute(i10, "ITUNESGAPLESS", parsableByteArray, false, true);
                    parsableByteArray.setPosition(i6);
                    return integerAttribute4;
                }
                if (i10 == TYPE_TV_SORT_SHOW) {
                    TextInformationFrame textAttribute16 = parseTextAttribute(i10, "TVSHOWSORT", parsableByteArray);
                    parsableByteArray.setPosition(i6);
                    return textAttribute16;
                }
                if (i10 == TYPE_TV_SHOW) {
                    TextInformationFrame textAttribute17 = parseTextAttribute(i10, "TVSHOW", parsableByteArray);
                    parsableByteArray.setPosition(i6);
                    return textAttribute17;
                }
                if (i10 == TYPE_INTERNAL) {
                    Id3Frame internalAttribute = parseInternalAttribute(parsableByteArray, i6);
                    parsableByteArray.setPosition(i6);
                    return internalAttribute;
                }
            }
            Log.m1713d(TAG, "Skipped unknown metadata entry: " + Mp4Box.getBoxTypeString(i10));
            parsableByteArray.setPosition(i6);
            return null;
        } catch (Throwable th) {
            parsableByteArray.setPosition(i6);
            throw th;
        }
    }

    private static TextInformationFrame parseIndexAndCountAttribute(int i6, String str, ParsableByteArray parsableByteArray) {
        int i10 = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385 && i10 >= 22) {
            parsableByteArray.skipBytes(10);
            int unsignedShort = parsableByteArray.readUnsignedShort();
            if (unsignedShort > 0) {
                String strM20n = AbstractC0004e.m20n(unsignedShort, "");
                int unsignedShort2 = parsableByteArray.readUnsignedShort();
                if (unsignedShort2 > 0) {
                    strM20n = strM20n + "/" + unsignedShort2;
                }
                return new TextInformationFrame(str, (String) null, AbstractC2301u1.m5275r(strM20n));
            }
        }
        Log.m1719w(TAG, "Failed to parse index/count attribute: " + Mp4Box.getBoxTypeString(i6));
        return null;
    }

    private static Id3Frame parseIntegerAttribute(int i6, String str, ParsableByteArray parsableByteArray, boolean z7, boolean z10) {
        int integerAttribute = parseIntegerAttribute(parsableByteArray);
        if (z10) {
            integerAttribute = Math.min(1, integerAttribute);
        }
        if (integerAttribute >= 0) {
            return z7 ? new TextInformationFrame(str, (String) null, AbstractC2301u1.m5275r(Integer.toString(integerAttribute))) : new CommentFrame(C0565C.LANGUAGE_UNDETERMINED, str, Integer.toString(integerAttribute));
        }
        Log.m1719w(TAG, "Failed to parse uint8 attribute: " + Mp4Box.getBoxTypeString(i6));
        return null;
    }

    private static Id3Frame parseInternalAttribute(ParsableByteArray parsableByteArray, int i6) {
        String nullTerminatedString = null;
        String nullTerminatedString2 = null;
        int i10 = -1;
        int i11 = -1;
        while (parsableByteArray.getPosition() < i6) {
            int position = parsableByteArray.getPosition();
            int i12 = parsableByteArray.readInt();
            int i13 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            if (i13 == 1835360622) {
                nullTerminatedString = parsableByteArray.readNullTerminatedString(i12 - 12);
            } else if (i13 == 1851878757) {
                nullTerminatedString2 = parsableByteArray.readNullTerminatedString(i12 - 12);
            } else {
                if (i13 == 1684108385) {
                    i10 = position;
                    i11 = i12;
                }
                parsableByteArray.skipBytes(i12 - 12);
            }
        }
        if (nullTerminatedString == null || nullTerminatedString2 == null || i10 == -1) {
            return null;
        }
        parsableByteArray.setPosition(i10);
        parsableByteArray.skipBytes(16);
        return new InternalFrame(nullTerminatedString, nullTerminatedString2, parsableByteArray.readNullTerminatedString(i11 - 16));
    }

    public static MdtaMetadataEntry parseMdtaMetadataEntryFromIlst(ParsableByteArray parsableByteArray, int i6, String str) {
        while (true) {
            int position = parsableByteArray.getPosition();
            if (position >= i6) {
                return null;
            }
            int i10 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1684108385) {
                int i11 = parsableByteArray.readInt();
                int i12 = parsableByteArray.readInt();
                int i13 = i10 - 16;
                byte[] bArr = new byte[i13];
                parsableByteArray.readBytes(bArr, 0, i13);
                return new MdtaMetadataEntry(str, bArr, i12, i11);
            }
            parsableByteArray.setPosition(position + i10);
        }
    }

    private static TextInformationFrame parseStandardGenreAttribute(ParsableByteArray parsableByteArray) {
        String strResolveV1Genre = Id3Util.resolveV1Genre(parseIntegerAttribute(parsableByteArray) - 1);
        if (strResolveV1Genre != null) {
            return new TextInformationFrame("TCON", (String) null, AbstractC2301u1.m5275r(strResolveV1Genre));
        }
        Log.m1719w(TAG, "Failed to parse standard genre code");
        return null;
    }

    private static TextInformationFrame parseTextAttribute(int i6, String str, ParsableByteArray parsableByteArray) {
        int i10 = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385) {
            parsableByteArray.skipBytes(8);
            return new TextInformationFrame(str, (String) null, AbstractC2301u1.m5275r(parsableByteArray.readNullTerminatedString(i10 - 16)));
        }
        Log.m1719w(TAG, "Failed to parse text attribute: " + Mp4Box.getBoxTypeString(i6));
        return null;
    }

    public static void setFormatGaplessInfo(int i6, GaplessInfoHolder gaplessInfoHolder, Format.Builder builder) {
        if (i6 == 1 && gaplessInfoHolder.hasGaplessInfo()) {
            builder.setEncoderDelay(gaplessInfoHolder.encoderDelay).setEncoderPadding(gaplessInfoHolder.encoderPadding);
        }
    }

    public static void setFormatMetadata(int i6, Metadata metadata, Format.Builder builder, Metadata metadata2, Metadata... metadataArr) {
        if (metadata2 == null) {
            metadata2 = new Metadata(new Metadata.Entry[0]);
        }
        if (metadata != null) {
            for (int i10 = 0; i10 < metadata.length(); i10++) {
                Metadata.Entry entry = metadata.get(i10);
                if (entry instanceof MdtaMetadataEntry) {
                    MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) entry;
                    if (!mdtaMetadataEntry.key.equals(MdtaMetadataEntry.KEY_ANDROID_CAPTURE_FPS)) {
                        metadata2 = metadata2.copyWithAppendedEntries(mdtaMetadataEntry);
                    } else if (i6 == 2) {
                        metadata2 = metadata2.copyWithAppendedEntries(mdtaMetadataEntry);
                    }
                }
            }
        }
        for (Metadata metadata3 : metadataArr) {
            metadata2 = metadata2.copyWithAppendedEntriesFrom(metadata3);
        }
        if (metadata2.length() > 0) {
            builder.setMetadata(metadata2);
        }
    }

    private static int parseIntegerAttribute(ParsableByteArray parsableByteArray) {
        int i6 = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385) {
            parsableByteArray.skipBytes(8);
            int i10 = i6 - 16;
            if (i10 == 1) {
                return parsableByteArray.readUnsignedByte();
            }
            if (i10 == 2) {
                return parsableByteArray.readUnsignedShort();
            }
            if (i10 != 3) {
                if (i10 == 4 && (parsableByteArray.peekUnsignedByte() & 128) == 0) {
                    return parsableByteArray.readUnsignedIntToInt();
                }
            } else {
                return parsableByteArray.readUnsignedInt24();
            }
        }
        Log.m1719w(TAG, "Failed to parse data atom to int");
        return -1;
    }
}

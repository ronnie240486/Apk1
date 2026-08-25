package androidx.media3.exoplayer.hls.playlist;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.media3.common.C0565C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.UriUtil;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.hls.HlsTrackMetadataEntry;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.media3.extractor.mp4.PsshAtomUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p041d7.AbstractC2182d0;
import p041d7.AbstractC2267p1;
import p041d7.AbstractC2301u1;
import p055ea.AbstractC2460q;

@UnstableApi
public final class HlsPlaylistParser implements ParsingLoadable.Parser<HlsPlaylist> {
    private static final String ATTR_CLOSED_CAPTIONS_NONE = "CLOSED-CAPTIONS=NONE";
    private static final String BOOLEAN_FALSE = "NO";
    private static final String BOOLEAN_TRUE = "YES";
    private static final String DATERANGE_CLASS_INTERSTITIALS = "com.apple.hls.interstitial";
    private static final String KEYFORMAT_IDENTITY = "identity";
    private static final String KEYFORMAT_PLAYREADY = "com.microsoft.playready";
    private static final String KEYFORMAT_WIDEVINE_PSSH_BINARY = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed";
    private static final String KEYFORMAT_WIDEVINE_PSSH_JSON = "com.widevine";
    private static final String LOG_TAG = "HlsPlaylistParser";
    private static final String METHOD_AES_128 = "AES-128";
    private static final String METHOD_NONE = "NONE";
    private static final String METHOD_SAMPLE_AES = "SAMPLE-AES";
    private static final String METHOD_SAMPLE_AES_CENC = "SAMPLE-AES-CENC";
    private static final String METHOD_SAMPLE_AES_CTR = "SAMPLE-AES-CTR";
    private static final String PLAYLIST_HEADER = "#EXTM3U";
    private static final String TAG_BYTERANGE = "#EXT-X-BYTERANGE";
    private static final String TAG_DATERANGE = "#EXT-X-DATERANGE";
    private static final String TAG_DEFINE = "#EXT-X-DEFINE";
    private static final String TAG_DISCONTINUITY = "#EXT-X-DISCONTINUITY";
    private static final String TAG_DISCONTINUITY_SEQUENCE = "#EXT-X-DISCONTINUITY-SEQUENCE";
    private static final String TAG_ENDLIST = "#EXT-X-ENDLIST";
    private static final String TAG_GAP = "#EXT-X-GAP";
    private static final String TAG_IFRAME = "#EXT-X-I-FRAMES-ONLY";
    private static final String TAG_INDEPENDENT_SEGMENTS = "#EXT-X-INDEPENDENT-SEGMENTS";
    private static final String TAG_INIT_SEGMENT = "#EXT-X-MAP";
    private static final String TAG_I_FRAME_STREAM_INF = "#EXT-X-I-FRAME-STREAM-INF";
    private static final String TAG_KEY = "#EXT-X-KEY";
    private static final String TAG_MEDIA = "#EXT-X-MEDIA";
    private static final String TAG_MEDIA_DURATION = "#EXTINF";
    private static final String TAG_MEDIA_SEQUENCE = "#EXT-X-MEDIA-SEQUENCE";
    private static final String TAG_PART = "#EXT-X-PART";
    private static final String TAG_PART_INF = "#EXT-X-PART-INF";
    private static final String TAG_PLAYLIST_TYPE = "#EXT-X-PLAYLIST-TYPE";
    private static final String TAG_PREFIX = "#EXT";
    private static final String TAG_PRELOAD_HINT = "#EXT-X-PRELOAD-HINT";
    private static final String TAG_PROGRAM_DATE_TIME = "#EXT-X-PROGRAM-DATE-TIME";
    private static final String TAG_RENDITION_REPORT = "#EXT-X-RENDITION-REPORT";
    private static final String TAG_SERVER_CONTROL = "#EXT-X-SERVER-CONTROL";
    private static final String TAG_SESSION_KEY = "#EXT-X-SESSION-KEY";
    private static final String TAG_SKIP = "#EXT-X-SKIP";
    private static final String TAG_START = "#EXT-X-START";
    private static final String TAG_STREAM_INF = "#EXT-X-STREAM-INF";
    private static final String TAG_TARGET_DURATION = "#EXT-X-TARGETDURATION";
    private static final String TAG_VERSION = "#EXT-X-VERSION";
    private static final String TYPE_AUDIO = "AUDIO";
    private static final String TYPE_CLOSED_CAPTIONS = "CLOSED-CAPTIONS";
    private static final String TYPE_MAP = "MAP";
    private static final String TYPE_PART = "PART";
    private static final String TYPE_SUBTITLES = "SUBTITLES";
    private static final String TYPE_VIDEO = "VIDEO";
    private final HlsMultivariantPlaylist multivariantPlaylist;
    private final HlsMediaPlaylist previousMediaPlaylist;
    private static final Pattern REGEX_AVERAGE_BANDWIDTH = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    private static final Pattern REGEX_VIDEO = Pattern.compile("VIDEO=\"(.+?)\"");
    private static final Pattern REGEX_AUDIO = Pattern.compile("AUDIO=\"(.+?)\"");
    private static final Pattern REGEX_SUBTITLES = Pattern.compile("SUBTITLES=\"(.+?)\"");
    private static final Pattern REGEX_CLOSED_CAPTIONS = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");
    private static final Pattern REGEX_BANDWIDTH = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    private static final Pattern REGEX_CHANNELS = Pattern.compile("CHANNELS=\"(.+?)\"");
    private static final Pattern REGEX_VIDEO_RANGE = Pattern.compile("VIDEO-RANGE=(SDR|PQ|HLG)");
    private static final Pattern REGEX_CODECS = Pattern.compile("CODECS=\"(.+?)\"");
    private static final Pattern REGEX_SUPPLEMENTAL_CODECS = Pattern.compile("SUPPLEMENTAL-CODECS=\"(.+?)\"");
    private static final Pattern REGEX_RESOLUTION = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    private static final Pattern REGEX_FRAME_RATE = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
    private static final Pattern REGEX_TARGET_DURATION = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    private static final Pattern REGEX_ATTR_DURATION = Pattern.compile("DURATION=([\\d\\.]+)\\b");
    private static final Pattern REGEX_ATTR_DURATION_PREFIXED = Pattern.compile("[:,]DURATION=([\\d\\.]+)\\b");
    private static final Pattern REGEX_PART_TARGET_DURATION = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");
    private static final Pattern REGEX_VERSION = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    private static final Pattern REGEX_PLAYLIST_TYPE = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    private static final Pattern REGEX_CAN_SKIP_UNTIL = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");
    private static final Pattern REGEX_CAN_SKIP_DATE_RANGES = compileBooleanAttrPattern("CAN-SKIP-DATERANGES");
    private static final Pattern REGEX_SKIPPED_SEGMENTS = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");
    private static final Pattern REGEX_HOLD_BACK = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");
    private static final Pattern REGEX_PART_HOLD_BACK = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");
    private static final Pattern REGEX_CAN_BLOCK_RELOAD = compileBooleanAttrPattern("CAN-BLOCK-RELOAD");
    private static final Pattern REGEX_MEDIA_SEQUENCE = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final Pattern REGEX_MEDIA_DURATION = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    private static final Pattern REGEX_MEDIA_TITLE = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    private static final Pattern REGEX_LAST_MSN = Pattern.compile("LAST-MSN=(\\d+)\\b");
    private static final Pattern REGEX_LAST_PART = Pattern.compile("LAST-PART=(\\d+)\\b");
    private static final Pattern REGEX_TIME_OFFSET = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern REGEX_BYTERANGE = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern REGEX_ATTR_BYTERANGE = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final Pattern REGEX_BYTERANGE_START = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
    private static final Pattern REGEX_BYTERANGE_LENGTH = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
    private static final Pattern REGEX_METHOD = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    private static final Pattern REGEX_KEYFORMAT = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    private static final Pattern REGEX_KEYFORMATVERSIONS = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    private static final Pattern REGEX_URI = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern REGEX_IV = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern REGEX_TYPE = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern REGEX_PRELOAD_HINT_TYPE = Pattern.compile("TYPE=(PART|MAP)");
    private static final Pattern REGEX_LANGUAGE = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern REGEX_NAME = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern REGEX_GROUP_ID = Pattern.compile("GROUP-ID=\"(.+?)\"");
    private static final Pattern REGEX_CHARACTERISTICS = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    private static final Pattern REGEX_INSTREAM_ID = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final Pattern REGEX_AUTOSELECT = compileBooleanAttrPattern("AUTOSELECT");
    private static final Pattern REGEX_DEFAULT = compileBooleanAttrPattern("DEFAULT");
    private static final Pattern REGEX_FORCED = compileBooleanAttrPattern("FORCED");
    private static final Pattern REGEX_INDEPENDENT = compileBooleanAttrPattern("INDEPENDENT");
    private static final Pattern REGEX_GAP = compileBooleanAttrPattern("GAP");
    private static final Pattern REGEX_PRECISE = compileBooleanAttrPattern("PRECISE");
    private static final Pattern REGEX_VALUE = Pattern.compile("VALUE=\"(.+?)\"");
    private static final Pattern REGEX_IMPORT = Pattern.compile("IMPORT=\"(.+?)\"");
    private static final Pattern REGEX_ID = Pattern.compile("[:,]ID=\"(.+?)\"");
    private static final Pattern REGEX_CLASS = Pattern.compile("CLASS=\"(.+?)\"");
    private static final Pattern REGEX_START_DATE = Pattern.compile("START-DATE=\"(.+?)\"");
    private static final Pattern REGEX_CUE = Pattern.compile("CUE=\"(.+?)\"");
    private static final Pattern REGEX_END_DATE = Pattern.compile("END-DATE=\"(.+?)\"");
    private static final Pattern REGEX_PLANNED_DURATION = Pattern.compile("PLANNED-DURATION=([\\d\\.]+)\\b");
    private static final Pattern REGEX_END_ON_NEXT = compileBooleanAttrPattern("END-ON-NEXT");
    private static final Pattern REGEX_ASSET_URI = Pattern.compile("X-ASSET-URI=\"(.+?)\"");
    private static final Pattern REGEX_ASSET_LIST_URI = Pattern.compile("X-ASSET-LIST=\"(.+?)\"");
    private static final Pattern REGEX_RESUME_OFFSET = Pattern.compile("X-RESUME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern REGEX_PLAYOUT_LIMIT = Pattern.compile("X-PLAYOUT-LIMIT=([\\d\\.]+)\\b");
    private static final Pattern REGEX_SNAP = Pattern.compile("X-SNAP=\"(.+?)\"");
    private static final Pattern REGEX_RESTRICT = Pattern.compile("X-RESTRICT=\"(.+?)\"");
    private static final Pattern REGEX_VARIABLE_REFERENCE = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");
    private static final Pattern REGEX_CLIENT_DEFINED_ATTRIBUTE_PREFIX = Pattern.compile("\\b(X-[A-Z0-9-]+)=");

    public static final class DeltaUpdateException extends IOException {
    }

    public static class LineIterator {
        private final Queue<String> extraLines;
        private String next;
        private final BufferedReader reader;

        public LineIterator(Queue<String> queue, BufferedReader bufferedReader) {
            this.extraLines = queue;
            this.reader = bufferedReader;
        }

        public boolean hasNext() throws IOException {
            String strTrim;
            if (this.next != null) {
                return true;
            }
            if (!this.extraLines.isEmpty()) {
                this.next = (String) Assertions.checkNotNull(this.extraLines.poll());
                return true;
            }
            do {
                String line = this.reader.readLine();
                this.next = line;
                if (line == null) {
                    return false;
                }
                strTrim = line.trim();
                this.next = strTrim;
            } while (strTrim.isEmpty());
            return true;
        }

        public String next() throws IOException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.next;
            this.next = null;
            return str;
        }
    }

    public HlsPlaylistParser() {
        this(HlsMultivariantPlaylist.EMPTY, null);
    }

    private static boolean checkPlaylistHeader(BufferedReader bufferedReader) throws IOException {
        int i6 = bufferedReader.read();
        if (i6 == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            i6 = bufferedReader.read();
        }
        int iSkipIgnorableWhitespace = skipIgnorableWhitespace(bufferedReader, true, i6);
        for (int i10 = 0; i10 < 7; i10++) {
            if (iSkipIgnorableWhitespace != PLAYLIST_HEADER.charAt(i10)) {
                return false;
            }
            iSkipIgnorableWhitespace = bufferedReader.read();
        }
        return Util.isLinebreak(skipIgnorableWhitespace(bufferedReader, false, iSkipIgnorableWhitespace));
    }

    private static Pattern compileBooleanAttrPattern(String str) {
        return Pattern.compile(str + "=(NO|YES)");
    }

    private static DrmInitData getPlaylistProtectionSchemes(String str, DrmInitData.SchemeData[] schemeDataArr) {
        DrmInitData.SchemeData[] schemeDataArr2 = new DrmInitData.SchemeData[schemeDataArr.length];
        for (int i6 = 0; i6 < schemeDataArr.length; i6++) {
            schemeDataArr2[i6] = schemeDataArr[i6].copyWithData(null);
        }
        return new DrmInitData(str, schemeDataArr2);
    }

    private static String getSegmentEncryptionIV(long j10, String str, String str2) {
        if (str == null) {
            return null;
        }
        return str2 != null ? str2 : Long.toHexString(j10);
    }

    private static HlsMultivariantPlaylist.Variant getVariantWithAudioGroup(ArrayList<HlsMultivariantPlaylist.Variant> arrayList, String str) {
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            HlsMultivariantPlaylist.Variant variant = arrayList.get(i6);
            if (str.equals(variant.audioGroupId)) {
                return variant;
            }
        }
        return null;
    }

    private static HlsMultivariantPlaylist.Variant getVariantWithSubtitleGroup(ArrayList<HlsMultivariantPlaylist.Variant> arrayList, String str) {
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            HlsMultivariantPlaylist.Variant variant = arrayList.get(i6);
            if (str.equals(variant.subtitleGroupId)) {
                return variant;
            }
        }
        return null;
    }

    private static HlsMultivariantPlaylist.Variant getVariantWithVideoGroup(ArrayList<HlsMultivariantPlaylist.Variant> arrayList, String str) {
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            HlsMultivariantPlaylist.Variant variant = arrayList.get(i6);
            if (str.equals(variant.videoGroupId)) {
                return variant;
            }
        }
        return null;
    }

    private static boolean isDolbyVisionFormat(String str, String str2, String str3, String str4) {
        if (!MimeTypes.isDolbyVisionCodec(str2, str3)) {
            return false;
        }
        if (str3 == null) {
            return true;
        }
        if (str == null || str4 == null) {
            return false;
        }
        return (!str.equals("PQ") || str4.equals("db1p")) && (!str.equals("SDR") || str4.equals("db2g")) && (!str.equals("HLG") || str4.startsWith("db4"));
    }

    private static HlsMediaPlaylist.ClientDefinedAttribute parseClientDefinedAttribute(String str, String str2, Map<String, String> map) throws ParserException {
        String strM5494h = AbstractC2460q.m5494h(str2, "=");
        int length = strM5494h.length() + str.indexOf(strM5494h);
        String strSubstring = str.substring(length, (str.length() == length + 1 ? 1 : 2) + length);
        if (strSubstring.startsWith("\"")) {
            return new HlsMediaPlaylist.ClientDefinedAttribute(str2, parseStringAttr(str, Pattern.compile(str2 + "=\"(.+?)\""), map), 0);
        }
        if (strSubstring.equals("0x") || strSubstring.equals("0X")) {
            return new HlsMediaPlaylist.ClientDefinedAttribute(str2, parseStringAttr(str, Pattern.compile(str2 + "=(0[xX][A-F0-9]+)"), map), 1);
        }
        return new HlsMediaPlaylist.ClientDefinedAttribute(str2, parseDoubleAttr(str, Pattern.compile(str2 + "=([\\d\\.]+)\\b")));
    }

    private static double parseDoubleAttr(String str, Pattern pattern) throws ParserException {
        return Double.parseDouble(parseStringAttr(str, pattern, Collections.emptyMap()));
    }

    private static DrmInitData.SchemeData parseDrmSchemeData(String str, String str2, Map<String, String> map) throws ParserException {
        String optionalStringAttr = parseOptionalStringAttr(str, REGEX_KEYFORMATVERSIONS, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, map);
        if (KEYFORMAT_WIDEVINE_PSSH_BINARY.equals(str2)) {
            String stringAttr = parseStringAttr(str, REGEX_URI, map);
            return new DrmInitData.SchemeData(C0565C.WIDEVINE_UUID, MimeTypes.VIDEO_MP4, Base64.decode(stringAttr.substring(stringAttr.indexOf(44)), 0));
        }
        if (KEYFORMAT_WIDEVINE_PSSH_JSON.equals(str2)) {
            return new DrmInitData.SchemeData(C0565C.WIDEVINE_UUID, "hls", Util.getUtf8Bytes(str));
        }
        if (!KEYFORMAT_PLAYREADY.equals(str2) || !IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(optionalStringAttr)) {
            return null;
        }
        String stringAttr2 = parseStringAttr(str, REGEX_URI, map);
        byte[] bArrDecode = Base64.decode(stringAttr2.substring(stringAttr2.indexOf(44)), 0);
        UUID uuid = C0565C.PLAYREADY_UUID;
        return new DrmInitData.SchemeData(uuid, MimeTypes.VIDEO_MP4, PsshAtomUtil.buildPsshAtom(uuid, bArrDecode));
    }

    private static String parseEncryptionScheme(String str) {
        return (METHOD_SAMPLE_AES_CENC.equals(str) || METHOD_SAMPLE_AES_CTR.equals(str)) ? C0565C.CENC_TYPE_cenc : C0565C.CENC_TYPE_cbcs;
    }

    private static int parseIntAttr(String str, Pattern pattern) throws ParserException {
        return Integer.parseInt(parseStringAttr(str, pattern, Collections.emptyMap()));
    }

    private static long parseLongAttr(String str, Pattern pattern) throws ParserException {
        return Long.parseLong(parseStringAttr(str, pattern, Collections.emptyMap()));
    }

    private static HlsMediaPlaylist parseMediaPlaylist(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist, LineIterator lineIterator, String str) throws IOException {
        int i6;
        ArrayList arrayList;
        String str2;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        long j10;
        DrmInitData drmInitData;
        Matcher matcher;
        byte b8;
        String[] strArr;
        byte b10;
        long j11;
        long j12;
        String optionalStringAttr;
        String stringAttr;
        hlsMultivariantPlaylist = hlsMultivariantPlaylist;
        hlsMediaPlaylist = hlsMediaPlaylist;
        boolean z7 = hlsMultivariantPlaylist.hasIndependentSegments;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        ArrayList arrayList10 = new ArrayList();
        HlsMediaPlaylist.ServerControl serverControl = new HlsMediaPlaylist.ServerControl(C0565C.TIME_UNSET, false, C0565C.TIME_UNSET, C0565C.TIME_UNSET, false);
        TreeMap treeMap = new TreeMap();
        String str3 = "";
        String optionalStringAttr2 = "";
        boolean z10 = z7;
        HlsMediaPlaylist.ServerControl serverControl2 = serverControl;
        long doubleAttr = -9223372036854775807L;
        long intAttr = -9223372036854775807L;
        long doubleAttr2 = -9223372036854775807L;
        long jMsToUs = 0;
        long j13 = 0;
        long j14 = 0;
        long j15 = 0;
        long j16 = 0;
        long longAttr = 0;
        long timeSecondsToUs = 0;
        long j17 = 0;
        int i10 = 0;
        boolean optionalBooleanAttribute = false;
        boolean z11 = false;
        int i11 = 0;
        int intAttr2 = 1;
        boolean z12 = false;
        DrmInitData playlistProtectionSchemes = null;
        DrmInitData drmInitData2 = null;
        boolean z13 = false;
        String str4 = null;
        long j18 = -1;
        String str5 = null;
        String encryptionScheme = null;
        int i12 = 0;
        boolean z14 = false;
        HlsMediaPlaylist.Segment segment = null;
        ArrayList arrayList11 = arrayList7;
        HlsMediaPlaylist.Part part = null;
        while (lineIterator.hasNext()) {
            String next = lineIterator.next();
            if (next.startsWith(TAG_PREFIX)) {
                arrayList9.add(next);
            }
            if (next.startsWith(TAG_PLAYLIST_TYPE)) {
                String stringAttr2 = parseStringAttr(next, REGEX_PLAYLIST_TYPE, map);
                if ("VOD".equals(stringAttr2)) {
                    i10 = 1;
                } else if ("EVENT".equals(stringAttr2)) {
                    i10 = 2;
                }
            } else if (next.equals(TAG_IFRAME)) {
                z14 = true;
            } else {
                if (next.startsWith(TAG_START)) {
                    arrayList = arrayList10;
                    doubleAttr = (long) (parseDoubleAttr(next, REGEX_TIME_OFFSET) * 1000000.0d);
                    optionalBooleanAttribute = parseOptionalBooleanAttribute(next, REGEX_PRECISE, false);
                } else {
                    arrayList = arrayList10;
                    if (next.startsWith(TAG_SERVER_CONTROL)) {
                        serverControl2 = parseServerControl(next);
                    } else if (next.startsWith(TAG_PART_INF)) {
                        doubleAttr2 = (long) (parseDoubleAttr(next, REGEX_PART_TARGET_DURATION) * 1000000.0d);
                    } else if (next.startsWith(TAG_INIT_SEGMENT)) {
                        String stringAttr3 = parseStringAttr(next, REGEX_URI, map);
                        String optionalStringAttr3 = parseOptionalStringAttr(next, REGEX_ATTR_BYTERANGE, map);
                        if (optionalStringAttr3 != null) {
                            String[] strArrSplit = Util.split(optionalStringAttr3, "@");
                            j18 = Long.parseLong(strArrSplit[0]);
                            if (strArrSplit.length > 1) {
                                j14 = Long.parseLong(strArrSplit[1]);
                            }
                        }
                        if (j18 == -1) {
                            j14 = 0;
                        }
                        String str6 = str4;
                        String str7 = str5;
                        if (str6 != null && str7 == null) {
                            throw ParserException.createForMalformedManifest("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.", null);
                        }
                        segment = new HlsMediaPlaylist.Segment(stringAttr3, j14, j18, str6, str7);
                        if (j18 != -1) {
                            j14 += j18;
                        }
                        str4 = str6;
                        str5 = str7;
                        j18 = -1;
                    } else {
                        String str8 = str4;
                        ArrayList arrayList12 = arrayList9;
                        String str9 = str5;
                        i10 = i10;
                        if (next.startsWith(TAG_TARGET_DURATION)) {
                            arrayList10 = arrayList;
                            intAttr = 1000000 * ((long) parseIntAttr(next, REGEX_TARGET_DURATION));
                        } else {
                            arrayList10 = arrayList;
                            if (next.startsWith(TAG_MEDIA_SEQUENCE)) {
                                longAttr = parseLongAttr(next, REGEX_MEDIA_SEQUENCE);
                                arrayList10 = arrayList10;
                                j13 = longAttr;
                            } else if (next.startsWith(TAG_VERSION)) {
                                intAttr2 = parseIntAttr(next, REGEX_VERSION);
                            } else {
                                if (next.startsWith(TAG_DEFINE)) {
                                    String optionalStringAttr4 = parseOptionalStringAttr(next, REGEX_IMPORT, map);
                                    if (optionalStringAttr4 != null) {
                                        String str10 = hlsMultivariantPlaylist.variableDefinitions.get(optionalStringAttr4);
                                        if (str10 != null) {
                                            map.put(optionalStringAttr4, str10);
                                        }
                                    } else {
                                        map.put(parseStringAttr(next, REGEX_NAME, map), parseStringAttr(next, REGEX_VALUE, map));
                                    }
                                    str2 = str3;
                                    arrayList2 = arrayList11;
                                    treeMap = treeMap;
                                    arrayList3 = arrayList6;
                                    encryptionScheme = encryptionScheme;
                                    part = part;
                                } else if (next.startsWith(TAG_MEDIA_DURATION)) {
                                    timeSecondsToUs = parseTimeSecondsToUs(next, REGEX_MEDIA_DURATION);
                                    optionalStringAttr2 = parseOptionalStringAttr(next, REGEX_MEDIA_TITLE, str3, map);
                                } else if (next.startsWith(TAG_SKIP)) {
                                    int intAttr3 = parseIntAttr(next, REGEX_SKIPPED_SEGMENTS);
                                    Assertions.checkState(hlsMediaPlaylist != null && arrayList6.isEmpty());
                                    String str11 = str3;
                                    int i13 = (int) (j13 - ((HlsMediaPlaylist) Util.castNonNull(hlsMediaPlaylist)).mediaSequence);
                                    int i14 = intAttr3 + i13;
                                    if (i13 < 0 || i14 > hlsMediaPlaylist.segments.size()) {
                                        throw new DeltaUpdateException();
                                    }
                                    String str12 = str8;
                                    long j19 = j16;
                                    while (i13 < i14) {
                                        HlsMediaPlaylist.Segment segmentCopyWith = hlsMediaPlaylist.segments.get(i13);
                                        ArrayList arrayList13 = arrayList11;
                                        String str13 = str9;
                                        if (j13 != hlsMediaPlaylist.mediaSequence) {
                                            segmentCopyWith = segmentCopyWith.copyWith(j19, (hlsMediaPlaylist.discontinuitySequence - i11) + segmentCopyWith.relativeDiscontinuitySequence);
                                        }
                                        arrayList6.add(segmentCopyWith);
                                        j19 += segmentCopyWith.durationUs;
                                        long j20 = segmentCopyWith.byteRangeLength;
                                        if (j20 != -1) {
                                            j14 = segmentCopyWith.byteRangeOffset + j20;
                                        }
                                        int i15 = segmentCopyWith.relativeDiscontinuitySequence;
                                        HlsMediaPlaylist.Segment segment2 = segmentCopyWith.initializationSegment;
                                        DrmInitData drmInitData3 = segmentCopyWith.drmInitData;
                                        String str14 = segmentCopyWith.fullSegmentEncryptionKeyUri;
                                        String str15 = segmentCopyWith.encryptionIV;
                                        if (str15 == null || !str15.equals(Long.toHexString(longAttr))) {
                                            str13 = segmentCopyWith.encryptionIV;
                                        }
                                        longAttr++;
                                        i13++;
                                        hlsMediaPlaylist = hlsMediaPlaylist;
                                        str12 = str14;
                                        j15 = j19;
                                        i12 = i15;
                                        str9 = str13;
                                        segment = segment2;
                                        drmInitData2 = drmInitData3;
                                        arrayList11 = arrayList13;
                                    }
                                    String str16 = str9;
                                    hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                    hlsMediaPlaylist = hlsMediaPlaylist;
                                    j16 = j19;
                                    arrayList9 = arrayList12;
                                    str3 = str11;
                                    str4 = str12;
                                    arrayList10 = arrayList10;
                                    i10 = i10;
                                    str5 = str16;
                                } else {
                                    String str17 = str3;
                                    arrayList2 = arrayList11;
                                    if (next.startsWith(TAG_KEY)) {
                                        String stringAttr4 = parseStringAttr(next, REGEX_METHOD, map);
                                        String optionalStringAttr5 = parseOptionalStringAttr(next, REGEX_KEYFORMAT, KEYFORMAT_IDENTITY, map);
                                        if (METHOD_NONE.equals(stringAttr4)) {
                                            treeMap.clear();
                                            stringAttr = null;
                                            optionalStringAttr = null;
                                            drmInitData2 = null;
                                        } else {
                                            optionalStringAttr = parseOptionalStringAttr(next, REGEX_IV, map);
                                            if (!KEYFORMAT_IDENTITY.equals(optionalStringAttr5)) {
                                                String str18 = encryptionScheme;
                                                encryptionScheme = str18 == null ? parseEncryptionScheme(stringAttr4) : str18;
                                                DrmInitData.SchemeData drmSchemeData = parseDrmSchemeData(next, optionalStringAttr5, map);
                                                if (drmSchemeData != null) {
                                                    treeMap.put(optionalStringAttr5, drmSchemeData);
                                                    stringAttr = null;
                                                    drmInitData2 = null;
                                                } else {
                                                    stringAttr = null;
                                                }
                                            } else if (METHOD_AES_128.equals(stringAttr4)) {
                                                stringAttr = parseStringAttr(next, REGEX_URI, map);
                                            } else {
                                                stringAttr = null;
                                            }
                                        }
                                        hlsMediaPlaylist = hlsMediaPlaylist;
                                        arrayList10 = arrayList10;
                                        arrayList11 = arrayList2;
                                        arrayList9 = arrayList12;
                                        i10 = i10;
                                        str4 = stringAttr;
                                        str5 = optionalStringAttr;
                                        str3 = str17;
                                        hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                    } else {
                                        encryptionScheme = encryptionScheme;
                                        if (next.startsWith(TAG_BYTERANGE)) {
                                            String[] strArrSplit2 = Util.split(parseStringAttr(next, REGEX_BYTERANGE, map), "@");
                                            j18 = Long.parseLong(strArrSplit2[0]);
                                            if (strArrSplit2.length > 1) {
                                                j14 = Long.parseLong(strArrSplit2[1]);
                                            }
                                        } else if (next.startsWith(TAG_DISCONTINUITY_SEQUENCE)) {
                                            i11 = Integer.parseInt(next.substring(next.indexOf(58) + 1));
                                            hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                            hlsMediaPlaylist = hlsMediaPlaylist;
                                            encryptionScheme = encryptionScheme;
                                            arrayList10 = arrayList10;
                                            arrayList11 = arrayList2;
                                            str3 = str17;
                                            z11 = true;
                                        } else if (next.equals(TAG_DISCONTINUITY)) {
                                            i12++;
                                        } else {
                                            if (next.startsWith(TAG_PROGRAM_DATE_TIME)) {
                                                if (jMsToUs == 0) {
                                                    jMsToUs = Util.msToUs(Util.parseXsDateTime(next.substring(next.indexOf(58) + 1))) - j16;
                                                } else {
                                                    arrayList3 = arrayList6;
                                                }
                                            } else if (next.equals(TAG_GAP)) {
                                                hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                                hlsMediaPlaylist = hlsMediaPlaylist;
                                                encryptionScheme = encryptionScheme;
                                                arrayList10 = arrayList10;
                                                arrayList11 = arrayList2;
                                                str3 = str17;
                                                z13 = true;
                                            } else if (next.equals(TAG_INDEPENDENT_SEGMENTS)) {
                                                hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                                hlsMediaPlaylist = hlsMediaPlaylist;
                                                encryptionScheme = encryptionScheme;
                                                arrayList10 = arrayList10;
                                                arrayList11 = arrayList2;
                                                str3 = str17;
                                                z10 = true;
                                            } else if (next.equals(TAG_ENDLIST)) {
                                                hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                                hlsMediaPlaylist = hlsMediaPlaylist;
                                                encryptionScheme = encryptionScheme;
                                                arrayList10 = arrayList10;
                                                arrayList11 = arrayList2;
                                                str3 = str17;
                                                z12 = true;
                                            } else {
                                                if (next.startsWith(TAG_RENDITION_REPORT)) {
                                                    arrayList5 = arrayList6;
                                                    arrayList8.add(new HlsMediaPlaylist.RenditionReport(Uri.parse(UriUtil.resolve(str, parseStringAttr(next, REGEX_URI, map))), parseOptionalLongAttr(next, REGEX_LAST_MSN, -1L), parseOptionalIntAttr(next, REGEX_LAST_PART, -1)));
                                                } else {
                                                    arrayList5 = arrayList6;
                                                    if (!next.startsWith(TAG_PRELOAD_HINT)) {
                                                        longAttr = longAttr;
                                                        if (next.startsWith(TAG_PART)) {
                                                            String segmentEncryptionIV = getSegmentEncryptionIV(longAttr, str8, str9);
                                                            String stringAttr5 = parseStringAttr(next, REGEX_URI, map);
                                                            HlsMediaPlaylist.Part part2 = part;
                                                            ArrayList arrayList14 = arrayList8;
                                                            long doubleAttr3 = (long) (parseDoubleAttr(next, REGEX_ATTR_DURATION) * 1000000.0d);
                                                            boolean optionalBooleanAttribute2 = parseOptionalBooleanAttribute(next, REGEX_INDEPENDENT, false) | (z10 && arrayList2.isEmpty());
                                                            boolean optionalBooleanAttribute3 = parseOptionalBooleanAttribute(next, REGEX_GAP, false);
                                                            String optionalStringAttr6 = parseOptionalStringAttr(next, REGEX_ATTR_BYTERANGE, map);
                                                            if (optionalStringAttr6 != null) {
                                                                String[] strArrSplit3 = Util.split(optionalStringAttr6, "@");
                                                                j12 = Long.parseLong(strArrSplit3[0]);
                                                                if (strArrSplit3.length > 1) {
                                                                    j17 = Long.parseLong(strArrSplit3[1]);
                                                                }
                                                                j11 = -1;
                                                            } else {
                                                                j11 = -1;
                                                                j12 = -1;
                                                            }
                                                            if (j12 == j11) {
                                                                j17 = 0;
                                                            }
                                                            if (drmInitData2 == null && !treeMap.isEmpty()) {
                                                                DrmInitData.SchemeData[] schemeDataArr = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                                DrmInitData drmInitData4 = new DrmInitData(encryptionScheme, schemeDataArr);
                                                                if (playlistProtectionSchemes == null) {
                                                                    playlistProtectionSchemes = getPlaylistProtectionSchemes(encryptionScheme, schemeDataArr);
                                                                }
                                                                drmInitData2 = drmInitData4;
                                                            }
                                                            arrayList2.add(new HlsMediaPlaylist.Part(stringAttr5, segment, doubleAttr3, i12, j15, drmInitData2, str8, segmentEncryptionIV, j17, j12, optionalBooleanAttribute3, optionalBooleanAttribute2, false));
                                                            j15 += doubleAttr3;
                                                            if (j12 != j11) {
                                                                j17 += j12;
                                                            }
                                                            arrayList6 = arrayList5;
                                                            arrayList11 = arrayList2;
                                                            part = part2;
                                                            arrayList8 = arrayList14;
                                                            str3 = str17;
                                                            longAttr = longAttr;
                                                            encryptionScheme = encryptionScheme;
                                                            arrayList10 = arrayList10;
                                                            hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                                            hlsMediaPlaylist = hlsMediaPlaylist;
                                                        } else {
                                                            part = part;
                                                            arrayList4 = arrayList8;
                                                            if (next.startsWith(TAG_DATERANGE)) {
                                                                str2 = str17;
                                                                if (parseOptionalStringAttr(next, REGEX_CLASS, str2, map).equals(DATERANGE_CLASS_INTERSTITIALS)) {
                                                                    String stringAttr6 = parseStringAttr(next, REGEX_ID, map);
                                                                    String optionalStringAttr7 = parseOptionalStringAttr(next, REGEX_ASSET_URI, map);
                                                                    Uri uri = optionalStringAttr7 != null ? Uri.parse(optionalStringAttr7) : null;
                                                                    String optionalStringAttr8 = parseOptionalStringAttr(next, REGEX_ASSET_LIST_URI, map);
                                                                    Uri uri2 = optionalStringAttr8 != null ? Uri.parse(optionalStringAttr8) : null;
                                                                    long jMsToUs2 = Util.msToUs(Util.parseXsDateTime(parseStringAttr(next, REGEX_START_DATE, map)));
                                                                    String optionalStringAttr9 = parseOptionalStringAttr(next, REGEX_END_DATE, map);
                                                                    long jMsToUs3 = optionalStringAttr9 != null ? Util.msToUs(Util.parseXsDateTime(optionalStringAttr9)) : -9223372036854775807L;
                                                                    ArrayList arrayList15 = new ArrayList();
                                                                    String optionalStringAttr10 = parseOptionalStringAttr(next, REGEX_CUE, map);
                                                                    if (optionalStringAttr10 != null) {
                                                                        String[] strArrSplit4 = Util.split(optionalStringAttr10, ",");
                                                                        int length = strArrSplit4.length;
                                                                        int i16 = 0;
                                                                        while (i16 < length) {
                                                                            int i17 = length;
                                                                            String strTrim = strArrSplit4[i16].trim();
                                                                            strTrim.getClass();
                                                                            switch (strTrim.hashCode()) {
                                                                                case 79491:
                                                                                    strArr = strArrSplit4;
                                                                                    if (!strTrim.equals(HlsMediaPlaylist.Interstitial.CUE_TRIGGER_PRE)) {
                                                                                        b10 = -1;
                                                                                    } else {
                                                                                        b10 = 0;
                                                                                    }
                                                                                    break;
                                                                                case 2430593:
                                                                                    strArr = strArrSplit4;
                                                                                    if (!strTrim.equals(HlsMediaPlaylist.Interstitial.CUE_TRIGGER_ONCE)) {
                                                                                        b10 = -1;
                                                                                    } else {
                                                                                        b10 = 1;
                                                                                    }
                                                                                    break;
                                                                                case 2461856:
                                                                                    strArr = strArrSplit4;
                                                                                    if (!strTrim.equals(HlsMediaPlaylist.Interstitial.CUE_TRIGGER_POST)) {
                                                                                        b10 = -1;
                                                                                    } else {
                                                                                        b10 = 2;
                                                                                    }
                                                                                    break;
                                                                                default:
                                                                                    strArr = strArrSplit4;
                                                                                    b10 = -1;
                                                                                    break;
                                                                            }
                                                                            switch (b10) {
                                                                                case 0:
                                                                                case 1:
                                                                                case 2:
                                                                                    arrayList15.add(strTrim);
                                                                                    break;
                                                                            }
                                                                            i16++;
                                                                            strArrSplit4 = strArr;
                                                                            length = i17;
                                                                        }
                                                                    }
                                                                    double optionalDoubleAttr = parseOptionalDoubleAttr(next, REGEX_ATTR_DURATION_PREFIXED, -1.0d);
                                                                    long j21 = optionalDoubleAttr >= 0.0d ? (long) (optionalDoubleAttr * 1000000.0d) : -9223372036854775807L;
                                                                    double optionalDoubleAttr2 = parseOptionalDoubleAttr(next, REGEX_PLANNED_DURATION, -1.0d);
                                                                    long j22 = optionalDoubleAttr2 >= 0.0d ? (long) (optionalDoubleAttr2 * 1000000.0d) : -9223372036854775807L;
                                                                    boolean optionalBooleanAttribute4 = parseOptionalBooleanAttribute(next, REGEX_END_ON_NEXT, false);
                                                                    double optionalDoubleAttr3 = parseOptionalDoubleAttr(next, REGEX_RESUME_OFFSET, Double.MIN_VALUE);
                                                                    long j23 = optionalDoubleAttr3 != Double.MIN_VALUE ? (long) (optionalDoubleAttr3 * 1000000.0d) : -9223372036854775807L;
                                                                    double optionalDoubleAttr4 = parseOptionalDoubleAttr(next, REGEX_PLAYOUT_LIMIT, -1.0d);
                                                                    long j24 = optionalDoubleAttr4 >= 0.0d ? (long) (optionalDoubleAttr4 * 1000000.0d) : -9223372036854775807L;
                                                                    ArrayList arrayList16 = new ArrayList();
                                                                    String optionalStringAttr11 = parseOptionalStringAttr(next, REGEX_SNAP, map);
                                                                    if (optionalStringAttr11 != null) {
                                                                        String[] strArrSplit5 = Util.split(optionalStringAttr11, ",");
                                                                        int length2 = strArrSplit5.length;
                                                                        int i18 = 0;
                                                                        while (i18 < length2) {
                                                                            String[] strArr2 = strArrSplit5;
                                                                            String strTrim2 = strArrSplit5[i18].trim();
                                                                            strTrim2.getClass();
                                                                            int i19 = length2;
                                                                            if (strTrim2.equals(HlsMediaPlaylist.Interstitial.SNAP_TYPE_IN) || strTrim2.equals(HlsMediaPlaylist.Interstitial.SNAP_TYPE_OUT)) {
                                                                                arrayList16.add(strTrim2);
                                                                            }
                                                                            i18++;
                                                                            length2 = i19;
                                                                            strArrSplit5 = strArr2;
                                                                        }
                                                                    }
                                                                    ArrayList arrayList17 = new ArrayList();
                                                                    String optionalStringAttr12 = parseOptionalStringAttr(next, REGEX_RESTRICT, map);
                                                                    if (optionalStringAttr12 != null) {
                                                                        String[] strArrSplit6 = Util.split(optionalStringAttr12, ",");
                                                                        int length3 = strArrSplit6.length;
                                                                        int i20 = 0;
                                                                        while (i20 < length3) {
                                                                            String[] strArr3 = strArrSplit6;
                                                                            String strTrim3 = strArrSplit6[i20].trim();
                                                                            strTrim3.getClass();
                                                                            int i21 = length3;
                                                                            if (strTrim3.equals(HlsMediaPlaylist.Interstitial.NAVIGATION_RESTRICTION_JUMP) || strTrim3.equals(HlsMediaPlaylist.Interstitial.NAVIGATION_RESTRICTION_SKIP)) {
                                                                                arrayList17.add(strTrim3);
                                                                            }
                                                                            i20++;
                                                                            length3 = i21;
                                                                            strArrSplit6 = strArr3;
                                                                        }
                                                                    }
                                                                    AbstractC2182d0.m5141d(4, "initialCapacity");
                                                                    Object[] objArrCopyOf = new Object[4];
                                                                    String strSubstring = next.substring(17);
                                                                    Matcher matcher2 = REGEX_CLIENT_DEFINED_ATTRIBUTE_PREFIX.matcher(strSubstring);
                                                                    int i22 = 0;
                                                                    while (matcher2.find()) {
                                                                        String str19 = encryptionScheme;
                                                                        String strGroup = matcher2.group();
                                                                        strGroup.getClass();
                                                                        switch (strGroup.hashCode()) {
                                                                            case -2136701954:
                                                                                matcher = matcher2;
                                                                                if (!strGroup.equals("X-SNAP=")) {
                                                                                    b8 = -1;
                                                                                } else {
                                                                                    b8 = 0;
                                                                                }
                                                                                break;
                                                                            case -148960310:
                                                                                matcher = matcher2;
                                                                                if (!strGroup.equals("X-PLAYOUT-LIMIT=")) {
                                                                                    b8 = -1;
                                                                                } else {
                                                                                    b8 = 1;
                                                                                }
                                                                                break;
                                                                            case 397239341:
                                                                                matcher = matcher2;
                                                                                if (!strGroup.equals("X-ASSET-LIST=")) {
                                                                                    b8 = -1;
                                                                                } else {
                                                                                    b8 = 2;
                                                                                }
                                                                                break;
                                                                            case 1472528844:
                                                                                matcher = matcher2;
                                                                                if (!strGroup.equals("X-RESTRICT=")) {
                                                                                    b8 = -1;
                                                                                } else {
                                                                                    b8 = 3;
                                                                                }
                                                                                break;
                                                                            case 1748487807:
                                                                                matcher = matcher2;
                                                                                if (!strGroup.equals("X-RESUME-OFFSET=")) {
                                                                                    b8 = -1;
                                                                                } else {
                                                                                    b8 = 4;
                                                                                }
                                                                                break;
                                                                            case 1814205923:
                                                                                matcher = matcher2;
                                                                                if (!strGroup.equals("X-ASSET-URI=")) {
                                                                                    b8 = -1;
                                                                                } else {
                                                                                    b8 = 5;
                                                                                }
                                                                                break;
                                                                            default:
                                                                                matcher = matcher2;
                                                                                b8 = -1;
                                                                                break;
                                                                        }
                                                                        switch (b8) {
                                                                            case 0:
                                                                            case 1:
                                                                            case 2:
                                                                            case 3:
                                                                            case 4:
                                                                            case 5:
                                                                                break;
                                                                            default:
                                                                                HlsMediaPlaylist.ClientDefinedAttribute clientDefinedAttribute = parseClientDefinedAttribute(strSubstring, strGroup.substring(0, strGroup.length() - 1), map);
                                                                                clientDefinedAttribute.getClass();
                                                                                int i23 = i22 + 1;
                                                                                int iM5254f = AbstractC2267p1.m5254f(objArrCopyOf.length, i23);
                                                                                if (iM5254f > objArrCopyOf.length) {
                                                                                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, iM5254f);
                                                                                }
                                                                                objArrCopyOf[i22] = clientDefinedAttribute;
                                                                                i22 = i23;
                                                                                break;
                                                                        }
                                                                        matcher2 = matcher;
                                                                        strSubstring = strSubstring;
                                                                        encryptionScheme = str19;
                                                                        treeMap = treeMap;
                                                                    }
                                                                    encryptionScheme = encryptionScheme;
                                                                    treeMap = treeMap;
                                                                    if ((uri2 == null && uri != null) || (uri2 != null && uri == null)) {
                                                                        arrayList10.add(new HlsMediaPlaylist.Interstitial(stringAttr6, uri, uri2, jMsToUs2, jMsToUs3, j21, j22, arrayList15, optionalBooleanAttribute4, j23, j24, arrayList16, arrayList17, AbstractC2301u1.m5268j(objArrCopyOf, i22)));
                                                                    }
                                                                } else {
                                                                    str2 = str2;
                                                                }
                                                                arrayList3 = arrayList5;
                                                                encryptionScheme = encryptionScheme;
                                                                arrayList6 = arrayList3;
                                                                arrayList11 = arrayList2;
                                                                str3 = str2;
                                                                treeMap = treeMap;
                                                                part = part;
                                                                arrayList8 = arrayList4;
                                                                longAttr = longAttr;
                                                                encryptionScheme = encryptionScheme;
                                                                hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                                                hlsMediaPlaylist = hlsMediaPlaylist;
                                                            } else {
                                                                str2 = str17;
                                                            }
                                                            if (next.startsWith("#")) {
                                                                arrayList3 = arrayList5;
                                                                encryptionScheme = encryptionScheme;
                                                                arrayList6 = arrayList3;
                                                                arrayList11 = arrayList2;
                                                                str3 = str2;
                                                                treeMap = treeMap;
                                                                part = part;
                                                                arrayList8 = arrayList4;
                                                                longAttr = longAttr;
                                                            } else {
                                                                String segmentEncryptionIV2 = getSegmentEncryptionIV(longAttr, str8, str9);
                                                                long j25 = longAttr + 1;
                                                                String strReplaceVariableReferences = replaceVariableReferences(next, map);
                                                                HlsMediaPlaylist.Segment segment3 = (HlsMediaPlaylist.Segment) map2.get(strReplaceVariableReferences);
                                                                if (j18 == -1) {
                                                                    j10 = 0;
                                                                } else {
                                                                    if (z14 && segment == null && segment3 == null) {
                                                                        segment3 = new HlsMediaPlaylist.Segment(strReplaceVariableReferences, 0L, j14, null, null);
                                                                        map2.put(strReplaceVariableReferences, segment3);
                                                                    }
                                                                    j10 = j14;
                                                                }
                                                                if (drmInitData2 != null || treeMap.isEmpty()) {
                                                                    encryptionScheme = encryptionScheme;
                                                                    drmInitData = drmInitData2;
                                                                } else {
                                                                    DrmInitData.SchemeData[] schemeDataArr2 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                                    encryptionScheme = encryptionScheme;
                                                                    drmInitData = new DrmInitData(encryptionScheme, schemeDataArr2);
                                                                    if (playlistProtectionSchemes == null) {
                                                                        playlistProtectionSchemes = getPlaylistProtectionSchemes(encryptionScheme, schemeDataArr2);
                                                                    }
                                                                }
                                                                arrayList5.add(new HlsMediaPlaylist.Segment(strReplaceVariableReferences, segment != null ? segment : segment3, optionalStringAttr2, timeSecondsToUs, i12, j16, drmInitData, str8, segmentEncryptionIV2, j10, j18, z13, arrayList2));
                                                                j15 = j16 + timeSecondsToUs;
                                                                ArrayList arrayList18 = new ArrayList();
                                                                if (j18 != -1) {
                                                                    j10 += j18;
                                                                }
                                                                j14 = j10;
                                                                arrayList11 = arrayList18;
                                                                drmInitData2 = drmInitData;
                                                                timeSecondsToUs = 0;
                                                                j16 = j15;
                                                                str3 = str2;
                                                                optionalStringAttr2 = str3;
                                                                treeMap = treeMap;
                                                                part = part;
                                                                arrayList8 = arrayList4;
                                                                z13 = false;
                                                                j18 = -1;
                                                                longAttr = j25;
                                                                arrayList6 = arrayList5;
                                                            }
                                                            encryptionScheme = encryptionScheme;
                                                            hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                                            hlsMediaPlaylist = hlsMediaPlaylist;
                                                        }
                                                    } else if (part == null && TYPE_PART.equals(parseStringAttr(next, REGEX_PRELOAD_HINT_TYPE, map))) {
                                                        String stringAttr7 = parseStringAttr(next, REGEX_URI, map);
                                                        long optionalLongAttr = parseOptionalLongAttr(next, REGEX_BYTERANGE_START, -1L);
                                                        long optionalLongAttr2 = parseOptionalLongAttr(next, REGEX_BYTERANGE_LENGTH, -1L);
                                                        long j26 = longAttr;
                                                        String segmentEncryptionIV3 = getSegmentEncryptionIV(j26, str8, str9);
                                                        if (drmInitData2 == null && !treeMap.isEmpty()) {
                                                            DrmInitData.SchemeData[] schemeDataArr3 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                            DrmInitData drmInitData5 = new DrmInitData(encryptionScheme, schemeDataArr3);
                                                            if (playlistProtectionSchemes == null) {
                                                                playlistProtectionSchemes = getPlaylistProtectionSchemes(encryptionScheme, schemeDataArr3);
                                                            }
                                                            drmInitData2 = drmInitData5;
                                                        }
                                                        if (optionalLongAttr == -1 || optionalLongAttr2 != -1) {
                                                            part = new HlsMediaPlaylist.Part(stringAttr7, segment, 0L, i12, j15, drmInitData2, str8, segmentEncryptionIV3, optionalLongAttr != -1 ? optionalLongAttr : 0L, optionalLongAttr2, false, false, true);
                                                        }
                                                        arrayList6 = arrayList5;
                                                        longAttr = j26;
                                                        arrayList11 = arrayList2;
                                                        str3 = str17;
                                                    }
                                                }
                                                arrayList3 = arrayList5;
                                            }
                                            str2 = str17;
                                        }
                                        arrayList11 = arrayList2;
                                        str3 = str17;
                                    }
                                }
                                arrayList4 = arrayList8;
                                arrayList6 = arrayList3;
                                arrayList11 = arrayList2;
                                str3 = str2;
                                treeMap = treeMap;
                                part = part;
                                arrayList8 = arrayList4;
                                longAttr = longAttr;
                                encryptionScheme = encryptionScheme;
                                hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                hlsMediaPlaylist = hlsMediaPlaylist;
                            }
                            str5 = str9;
                            arrayList9 = arrayList12;
                            str4 = str8;
                        }
                        arrayList10 = arrayList10;
                        str5 = str9;
                        arrayList9 = arrayList12;
                        str4 = str8;
                    }
                }
                arrayList10 = arrayList;
            }
        }
        int i24 = i10;
        HlsMediaPlaylist.Part part3 = part;
        ArrayList arrayList19 = arrayList8;
        ArrayList arrayList20 = arrayList11;
        ArrayList arrayList21 = arrayList9;
        ArrayList arrayList22 = arrayList10;
        ArrayList arrayList23 = arrayList6;
        HashMap map3 = new HashMap();
        int i25 = 0;
        while (i25 < arrayList19.size()) {
            ArrayList arrayList24 = arrayList19;
            HlsMediaPlaylist.RenditionReport renditionReport = (HlsMediaPlaylist.RenditionReport) arrayList24.get(i25);
            long size = renditionReport.lastMediaSequence;
            if (size == -1) {
                size = (j13 + ((long) arrayList23.size())) - (arrayList20.isEmpty() ? 1L : 0L);
            }
            int size2 = renditionReport.lastPartIndex;
            if (size2 != -1 || doubleAttr2 == C0565C.TIME_UNSET) {
                i6 = 1;
            } else {
                i6 = 1;
                size2 = (arrayList20.isEmpty() ? ((HlsMediaPlaylist.Segment) AbstractC2182d0.m5151n(arrayList23)).parts : arrayList20).size() - 1;
            }
            Uri uri3 = renditionReport.playlistUri;
            map3.put(uri3, new HlsMediaPlaylist.RenditionReport(uri3, size, size2));
            i25 += i6;
            arrayList19 = arrayList24;
        }
        if (part3 != null) {
            arrayList20.add(part3);
        }
        return new HlsMediaPlaylist(i24, str, arrayList21, doubleAttr, optionalBooleanAttribute, jMsToUs, z11, i11, j13, intAttr2, intAttr, doubleAttr2, z10, z12, jMsToUs != 0, playlistProtectionSchemes, arrayList23, arrayList20, serverControl2, map3, arrayList22);
    }

    private static HlsMultivariantPlaylist parseMultivariantPlaylist(LineIterator lineIterator, String str) throws IOException {
        ArrayList arrayList;
        String mediaMimeType;
        int i6;
        String str2;
        Format formatBuild;
        int i10;
        String mediaMimeType2;
        int i11;
        ArrayList arrayList2;
        String strM5495i;
        String str3;
        String codecsOfType;
        String optionalStringAttr;
        int i12;
        int i13;
        String optionalStringAttr2;
        float f;
        Uri uriResolveToUri;
        HashMap map;
        ArrayList arrayList3;
        String codecsWithoutType;
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList();
        boolean z7 = false;
        boolean zContains = false;
        while (true) {
            boolean zHasNext = lineIterator.hasNext();
            String str4 = MimeTypes.APPLICATION_M3U8;
            if (!zHasNext) {
                HashMap map4 = map2;
                ArrayList arrayList12 = arrayList5;
                ArrayList arrayList13 = arrayList6;
                ArrayList arrayList14 = arrayList7;
                ArrayList arrayList15 = arrayList8;
                ArrayList arrayList16 = arrayList9;
                ArrayList arrayList17 = arrayList10;
                ArrayList arrayList18 = arrayList11;
                ArrayList arrayList19 = new ArrayList();
                HashSet hashSet = new HashSet();
                int i14 = 0;
                while (i14 < arrayList4.size()) {
                    HlsMultivariantPlaylist.Variant variant = (HlsMultivariantPlaylist.Variant) arrayList4.get(i14);
                    if (hashSet.add(variant.url)) {
                        Assertions.checkState(variant.format.metadata == null);
                        i11 = 1;
                        arrayList19.add(variant.copyWithFormat(variant.format.buildUpon().setMetadata(new Metadata(new HlsTrackMetadataEntry(null, null, (List) Assertions.checkNotNull((ArrayList) map4.get(variant.url))))).build()));
                    } else {
                        i11 = 1;
                    }
                    i14 += i11;
                }
                Uri uri = null;
                ArrayList arrayList20 = null;
                Format format = null;
                int i15 = 0;
                while (i15 < arrayList16.size()) {
                    ArrayList arrayList21 = arrayList16;
                    String str5 = (String) arrayList21.get(i15);
                    String stringAttr = parseStringAttr(str5, REGEX_GROUP_ID, map3);
                    String stringAttr2 = parseStringAttr(str5, REGEX_NAME, map3);
                    Format.Builder language = new Format.Builder().setId(stringAttr + ":" + stringAttr2).setLabel(stringAttr2).setContainerMimeType(str4).setSelectionFlags(parseSelectionFlags(str5)).setRoleFlags(parseRoleFlags(str5, map3)).setLanguage(parseOptionalStringAttr(str5, REGEX_LANGUAGE, map3));
                    String optionalStringAttr3 = parseOptionalStringAttr(str5, REGEX_URI, map3);
                    Uri uriResolveToUri2 = optionalStringAttr3 == null ? uri : UriUtil.resolveToUri(str, optionalStringAttr3);
                    String str6 = str4;
                    arrayList16 = arrayList21;
                    Metadata metadata = new Metadata(new HlsTrackMetadataEntry(stringAttr, stringAttr2, Collections.emptyList()));
                    String stringAttr3 = parseStringAttr(str5, REGEX_TYPE, map3);
                    stringAttr3.getClass();
                    switch (stringAttr3) {
                        case "SUBTITLES":
                            format = format;
                            arrayList13 = arrayList13;
                            arrayList = arrayList12;
                            HlsMultivariantPlaylist.Variant variantWithSubtitleGroup = getVariantWithSubtitleGroup(arrayList4, stringAttr);
                            if (variantWithSubtitleGroup != null) {
                                String codecsOfType2 = Util.getCodecsOfType(variantWithSubtitleGroup.format.codecs, 3);
                                language.setCodecs(codecsOfType2);
                                mediaMimeType = MimeTypes.getMediaMimeType(codecsOfType2);
                            } else {
                                mediaMimeType = null;
                            }
                            if (mediaMimeType == null) {
                                mediaMimeType = MimeTypes.TEXT_VTT;
                            }
                            language.setSampleMimeType(mediaMimeType).setMetadata(metadata);
                            if (uriResolveToUri2 != null) {
                                HlsMultivariantPlaylist.Rendition rendition = new HlsMultivariantPlaylist.Rendition(uriResolveToUri2, language.build(), stringAttr, stringAttr2);
                                arrayList14 = arrayList14;
                                arrayList14.add(rendition);
                            } else {
                                arrayList14 = arrayList14;
                                Log.m1719w(LOG_TAG, "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping");
                            }
                            formatBuild = format;
                            i10 = 1;
                            break;
                        case "CLOSED-CAPTIONS":
                            Format format2 = format;
                            arrayList13 = arrayList13;
                            arrayList = arrayList12;
                            String stringAttr4 = parseStringAttr(str5, REGEX_INSTREAM_ID, map3);
                            if (stringAttr4.startsWith("CC")) {
                                i6 = Integer.parseInt(stringAttr4.substring(2));
                                str2 = MimeTypes.APPLICATION_CEA608;
                            } else {
                                i6 = Integer.parseInt(stringAttr4.substring(7));
                                str2 = MimeTypes.APPLICATION_CEA708;
                            }
                            if (arrayList20 == null) {
                                arrayList20 = new ArrayList();
                            }
                            language.setSampleMimeType(str2).setAccessibilityChannel(i6);
                            arrayList20.add(language.build());
                            formatBuild = format2;
                            i10 = 1;
                            break;
                        case "AUDIO":
                            arrayList = arrayList12;
                            HlsMultivariantPlaylist.Variant variantWithAudioGroup = getVariantWithAudioGroup(arrayList4, stringAttr);
                            if (variantWithAudioGroup != null) {
                                String codecsOfType3 = Util.getCodecsOfType(variantWithAudioGroup.format.codecs, 1);
                                language.setCodecs(codecsOfType3);
                                mediaMimeType2 = MimeTypes.getMediaMimeType(codecsOfType3);
                            } else {
                                mediaMimeType2 = null;
                            }
                            String optionalStringAttr4 = parseOptionalStringAttr(str5, REGEX_CHANNELS, map3);
                            if (optionalStringAttr4 != null) {
                                language.setChannelCount(Integer.parseInt(Util.splitAtFirst(optionalStringAttr4, "/")[0]));
                                if (MimeTypes.AUDIO_E_AC3.equals(mediaMimeType2) && optionalStringAttr4.endsWith("/JOC")) {
                                    language.setCodecs(MimeTypes.CODEC_E_AC3_JOC);
                                    mediaMimeType2 = MimeTypes.AUDIO_E_AC3_JOC;
                                }
                            }
                            language.setSampleMimeType(mediaMimeType2);
                            if (uriResolveToUri2 == null) {
                                arrayList13 = arrayList13;
                                if (variantWithAudioGroup != null) {
                                    formatBuild = language.build();
                                    i10 = 1;
                                }
                                break;
                            } else {
                                language.setMetadata(metadata);
                                arrayList13 = arrayList13;
                                arrayList13.add(new HlsMultivariantPlaylist.Rendition(uriResolveToUri2, language.build(), stringAttr, stringAttr2));
                            }
                            arrayList14 = arrayList14;
                            formatBuild = format;
                            i10 = 1;
                            break;
                        case "VIDEO":
                            HlsMultivariantPlaylist.Variant variantWithVideoGroup = getVariantWithVideoGroup(arrayList4, stringAttr);
                            if (variantWithVideoGroup != null) {
                                Format format3 = variantWithVideoGroup.format;
                                String codecsOfType4 = Util.getCodecsOfType(format3.codecs, 2);
                                language.setCodecs(codecsOfType4).setSampleMimeType(MimeTypes.getMediaMimeType(codecsOfType4)).setWidth(format3.width).setHeight(format3.height).setFrameRate(format3.frameRate);
                            }
                            if (uriResolveToUri2 != null) {
                                language.setMetadata(metadata);
                                arrayList = arrayList12;
                                arrayList.add(new HlsMultivariantPlaylist.Rendition(uriResolveToUri2, language.build(), stringAttr, stringAttr2));
                            }
                            formatBuild = format;
                            i10 = 1;
                        default:
                            arrayList = arrayList12;
                            formatBuild = format;
                            i10 = 1;
                            break;
                    }
                    i15 += i10;
                    arrayList12 = arrayList;
                    arrayList13 = arrayList13;
                    arrayList14 = arrayList14;
                    uri = null;
                    format = formatBuild;
                    str4 = str6;
                }
                return new HlsMultivariantPlaylist(str, arrayList18, arrayList19, arrayList12, arrayList13, arrayList14, arrayList15, format, zContains ? Collections.emptyList() : arrayList20, z7, map3, arrayList17);
            }
            String next = lineIterator.next();
            if (next.startsWith(TAG_PREFIX)) {
                arrayList11.add(next);
            }
            boolean zStartsWith = next.startsWith(TAG_I_FRAME_STREAM_INF);
            if (next.startsWith(TAG_DEFINE)) {
                map3.put(parseStringAttr(next, REGEX_NAME, map3), parseStringAttr(next, REGEX_VALUE, map3));
            } else {
                if (next.equals(TAG_INDEPENDENT_SEGMENTS)) {
                    map = map2;
                    arrayList2 = arrayList9;
                    arrayList10 = arrayList10;
                    z7 = true;
                } else if (next.startsWith(TAG_MEDIA)) {
                    arrayList9.add(next);
                } else if (next.startsWith(TAG_SESSION_KEY)) {
                    DrmInitData.SchemeData drmSchemeData = parseDrmSchemeData(next, parseOptionalStringAttr(next, REGEX_KEYFORMAT, KEYFORMAT_IDENTITY, map3), map3);
                    if (drmSchemeData != null) {
                        arrayList10.add(new DrmInitData(parseEncryptionScheme(parseStringAttr(next, REGEX_METHOD, map3)), drmSchemeData));
                    }
                } else if (next.startsWith(TAG_STREAM_INF) || zStartsWith) {
                    zContains |= next.contains(ATTR_CLOSED_CAPTIONS_NONE);
                    int i16 = zStartsWith ? 16384 : 0;
                    int intAttr = parseIntAttr(next, REGEX_BANDWIDTH);
                    int optionalIntAttr = parseOptionalIntAttr(next, REGEX_AVERAGE_BANDWIDTH, -1);
                    String optionalStringAttr5 = parseOptionalStringAttr(next, REGEX_VIDEO_RANGE, map3);
                    String optionalStringAttr6 = parseOptionalStringAttr(next, REGEX_CODECS, map3);
                    String optionalStringAttr7 = parseOptionalStringAttr(next, REGEX_SUPPLEMENTAL_CODECS, map3);
                    if (optionalStringAttr7 != null) {
                        String[] strArrSplit = Util.split(Util.splitAtFirst(optionalStringAttr7, ",")[0], "/");
                        String str7 = strArrSplit[0];
                        arrayList2 = arrayList9;
                        if (strArrSplit.length > 1) {
                            str3 = strArrSplit[1];
                            map2 = map2;
                            strM5495i = str7;
                        } else {
                            strM5495i = str7;
                        }
                        codecsOfType = Util.getCodecsOfType(optionalStringAttr6, 2);
                        if (isDolbyVisionFormat(optionalStringAttr5, codecsOfType, strM5495i, str3)) {
                            if (strM5495i == null) {
                                strM5495i = codecsOfType;
                            }
                            codecsWithoutType = Util.getCodecsWithoutType(optionalStringAttr6, 2);
                            if (codecsWithoutType != null) {
                                strM5495i = AbstractC2460q.m5495i(strM5495i, ",", codecsWithoutType);
                            }
                            optionalStringAttr6 = strM5495i;
                        }
                        optionalStringAttr = parseOptionalStringAttr(next, REGEX_RESOLUTION, map3);
                        if (optionalStringAttr != null) {
                            String[] strArrSplit2 = Util.split(optionalStringAttr, "x");
                            i13 = Integer.parseInt(strArrSplit2[0]);
                            i12 = Integer.parseInt(strArrSplit2[1]);
                            if (i13 > 0 || i12 <= 0) {
                                i12 = -1;
                                i13 = -1;
                            }
                        } else {
                            i12 = -1;
                            i13 = -1;
                        }
                        optionalStringAttr2 = parseOptionalStringAttr(next, REGEX_FRAME_RATE, map3);
                        if (optionalStringAttr2 != null) {
                            f = Float.parseFloat(optionalStringAttr2);
                        } else {
                            f = -1.0f;
                        }
                        String optionalStringAttr8 = parseOptionalStringAttr(next, REGEX_VIDEO, map3);
                        String optionalStringAttr9 = parseOptionalStringAttr(next, REGEX_AUDIO, map3);
                        String optionalStringAttr10 = parseOptionalStringAttr(next, REGEX_SUBTITLES, map3);
                        String optionalStringAttr11 = parseOptionalStringAttr(next, REGEX_CLOSED_CAPTIONS, map3);
                        if (zStartsWith) {
                            uriResolveToUri = UriUtil.resolveToUri(str, parseStringAttr(next, REGEX_URI, map3));
                        } else {
                            if (lineIterator.hasNext()) {
                                throw ParserException.createForMalformedManifest("#EXT-X-STREAM-INF must be followed by another line", null);
                            }
                            uriResolveToUri = UriUtil.resolveToUri(str, replaceVariableReferences(lineIterator.next(), map3));
                        }
                        arrayList4.add(new HlsMultivariantPlaylist.Variant(uriResolveToUri, new Format.Builder().setId(arrayList4.size()).setContainerMimeType(MimeTypes.APPLICATION_M3U8).setCodecs(optionalStringAttr6).setAverageBitrate(optionalIntAttr).setPeakBitrate(intAttr).setWidth(i13).setHeight(i12).setFrameRate(f).setRoleFlags(i16).build(), optionalStringAttr8, optionalStringAttr9, optionalStringAttr10, optionalStringAttr11));
                        map = map2;
                        arrayList3 = (ArrayList) map.get(uriResolveToUri);
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                            map.put(uriResolveToUri, arrayList3);
                        }
                        arrayList3.add(new HlsTrackMetadataEntry.VariantInfo(optionalIntAttr, intAttr, optionalStringAttr8, optionalStringAttr9, optionalStringAttr10, optionalStringAttr11));
                    } else {
                        arrayList2 = arrayList9;
                        strM5495i = null;
                    }
                    str3 = null;
                    codecsOfType = Util.getCodecsOfType(optionalStringAttr6, 2);
                    if (isDolbyVisionFormat(optionalStringAttr5, codecsOfType, strM5495i, str3)) {
                        if (strM5495i == null) {
                            strM5495i = codecsOfType;
                        }
                        codecsWithoutType = Util.getCodecsWithoutType(optionalStringAttr6, 2);
                        if (codecsWithoutType != null) {
                            strM5495i = AbstractC2460q.m5495i(strM5495i, ",", codecsWithoutType);
                        }
                        optionalStringAttr6 = strM5495i;
                    }
                    optionalStringAttr = parseOptionalStringAttr(next, REGEX_RESOLUTION, map3);
                    if (optionalStringAttr != null) {
                        String[] strArrSplit3 = Util.split(optionalStringAttr, "x");
                        i13 = Integer.parseInt(strArrSplit3[0]);
                        i12 = Integer.parseInt(strArrSplit3[1]);
                        if (i13 > 0) {
                            i12 = -1;
                            i13 = -1;
                        } else {
                            i12 = -1;
                            i13 = -1;
                        }
                    } else {
                        i12 = -1;
                        i13 = -1;
                    }
                    optionalStringAttr2 = parseOptionalStringAttr(next, REGEX_FRAME_RATE, map3);
                    if (optionalStringAttr2 != null) {
                        f = Float.parseFloat(optionalStringAttr2);
                    } else {
                        f = -1.0f;
                    }
                    String optionalStringAttr12 = parseOptionalStringAttr(next, REGEX_VIDEO, map3);
                    String optionalStringAttr13 = parseOptionalStringAttr(next, REGEX_AUDIO, map3);
                    String optionalStringAttr14 = parseOptionalStringAttr(next, REGEX_SUBTITLES, map3);
                    String optionalStringAttr15 = parseOptionalStringAttr(next, REGEX_CLOSED_CAPTIONS, map3);
                    if (zStartsWith) {
                        uriResolveToUri = UriUtil.resolveToUri(str, parseStringAttr(next, REGEX_URI, map3));
                    } else {
                        if (lineIterator.hasNext()) {
                            throw ParserException.createForMalformedManifest("#EXT-X-STREAM-INF must be followed by another line", null);
                        }
                        uriResolveToUri = UriUtil.resolveToUri(str, replaceVariableReferences(lineIterator.next(), map3));
                    }
                    arrayList4.add(new HlsMultivariantPlaylist.Variant(uriResolveToUri, new Format.Builder().setId(arrayList4.size()).setContainerMimeType(MimeTypes.APPLICATION_M3U8).setCodecs(optionalStringAttr6).setAverageBitrate(optionalIntAttr).setPeakBitrate(intAttr).setWidth(i13).setHeight(i12).setFrameRate(f).setRoleFlags(i16).build(), optionalStringAttr12, optionalStringAttr13, optionalStringAttr14, optionalStringAttr15));
                    map = map2;
                    arrayList3 = (ArrayList) map.get(uriResolveToUri);
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                        map.put(uriResolveToUri, arrayList3);
                    }
                    arrayList3.add(new HlsTrackMetadataEntry.VariantInfo(optionalIntAttr, intAttr, optionalStringAttr12, optionalStringAttr13, optionalStringAttr14, optionalStringAttr15));
                }
                map2 = map;
                arrayList10 = arrayList10;
                arrayList8 = arrayList8;
                arrayList11 = arrayList11;
                arrayList7 = arrayList7;
                arrayList6 = arrayList6;
                arrayList5 = arrayList5;
                arrayList9 = arrayList2;
            }
            map = map2;
            arrayList2 = arrayList9;
            arrayList10 = arrayList10;
            map2 = map;
            arrayList10 = arrayList10;
            arrayList8 = arrayList8;
            arrayList11 = arrayList11;
            arrayList7 = arrayList7;
            arrayList6 = arrayList6;
            arrayList5 = arrayList5;
            arrayList9 = arrayList2;
        }
    }

    private static boolean parseOptionalBooleanAttribute(String str, Pattern pattern, boolean z7) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? BOOLEAN_TRUE.equals(matcher.group(1)) : z7;
    }

    private static double parseOptionalDoubleAttr(String str, Pattern pattern, double d) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Double.parseDouble((String) Assertions.checkNotNull(matcher.group(1))) : d;
    }

    private static int parseOptionalIntAttr(String str, Pattern pattern, int i6) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1))) : i6;
    }

    private static long parseOptionalLongAttr(String str, Pattern pattern, long j10) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Long.parseLong((String) Assertions.checkNotNull(matcher.group(1))) : j10;
    }

    private static String parseOptionalStringAttr(String str, Pattern pattern, Map<String, String> map) {
        return parseOptionalStringAttr(str, pattern, null, map);
    }

    private static int parseRoleFlags(String str, Map<String, String> map) {
        String optionalStringAttr = parseOptionalStringAttr(str, REGEX_CHARACTERISTICS, map);
        if (TextUtils.isEmpty(optionalStringAttr)) {
            return 0;
        }
        String[] strArrSplit = Util.split(optionalStringAttr, ",");
        int i6 = Util.contains(strArrSplit, "public.accessibility.describes-video") ? 512 : 0;
        if (Util.contains(strArrSplit, "public.accessibility.transcribes-spoken-dialog")) {
            i6 |= 4096;
        }
        if (Util.contains(strArrSplit, "public.accessibility.describes-music-and-sound")) {
            i6 |= 1024;
        }
        return Util.contains(strArrSplit, "public.easy-to-read") ? i6 | 8192 : i6;
    }

    private static int parseSelectionFlags(String str) {
        boolean optionalBooleanAttribute = parseOptionalBooleanAttribute(str, REGEX_DEFAULT, false);
        ?? r10 = optionalBooleanAttribute;
        if (parseOptionalBooleanAttribute(str, REGEX_FORCED, false)) {
            r10 = (optionalBooleanAttribute ? 1 : 0) | 2;
        }
        return parseOptionalBooleanAttribute(str, REGEX_AUTOSELECT, false) ? r10 | 4 : r10;
    }

    private static HlsMediaPlaylist.ServerControl parseServerControl(String str) {
        double optionalDoubleAttr = parseOptionalDoubleAttr(str, REGEX_CAN_SKIP_UNTIL, -9.223372036854776E18d);
        long j10 = C0565C.TIME_UNSET;
        long j11 = optionalDoubleAttr == -9.223372036854776E18d ? -9223372036854775807L : (long) (optionalDoubleAttr * 1000000.0d);
        boolean optionalBooleanAttribute = parseOptionalBooleanAttribute(str, REGEX_CAN_SKIP_DATE_RANGES, false);
        double optionalDoubleAttr2 = parseOptionalDoubleAttr(str, REGEX_HOLD_BACK, -9.223372036854776E18d);
        long j12 = optionalDoubleAttr2 == -9.223372036854776E18d ? -9223372036854775807L : (long) (optionalDoubleAttr2 * 1000000.0d);
        double optionalDoubleAttr3 = parseOptionalDoubleAttr(str, REGEX_PART_HOLD_BACK, -9.223372036854776E18d);
        if (optionalDoubleAttr3 != -9.223372036854776E18d) {
            j10 = (long) (optionalDoubleAttr3 * 1000000.0d);
        }
        return new HlsMediaPlaylist.ServerControl(j11, optionalBooleanAttribute, j12, j10, parseOptionalBooleanAttribute(str, REGEX_CAN_BLOCK_RELOAD, false));
    }

    private static String parseStringAttr(String str, Pattern pattern, Map<String, String> map) throws ParserException {
        String optionalStringAttr = parseOptionalStringAttr(str, pattern, map);
        if (optionalStringAttr != null) {
            return optionalStringAttr;
        }
        throw ParserException.createForMalformedManifest("Couldn't match " + pattern.pattern() + " in " + str, null);
    }

    private static long parseTimeSecondsToUs(String str, Pattern pattern) throws ParserException {
        return new BigDecimal(parseStringAttr(str, pattern, Collections.emptyMap())).multiply(new BigDecimal(1000000L)).longValue();
    }

    private static String replaceVariableReferences(String str, Map<String, String> map) {
        Matcher matcher = REGEX_VARIABLE_REFERENCE.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            if (map.containsKey(strGroup)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(map.get(strGroup)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private static int skipIgnorableWhitespace(BufferedReader bufferedReader, boolean z7, int i6) throws IOException {
        while (i6 != -1 && Character.isWhitespace(i6) && (z7 || !Util.isLinebreak(i6))) {
            i6 = bufferedReader.read();
        }
        return i6;
    }

    public HlsPlaylistParser(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist) {
        this.multivariantPlaylist = hlsMultivariantPlaylist;
        this.previousMediaPlaylist = hlsMediaPlaylist;
    }

    private static String parseOptionalStringAttr(String str, Pattern pattern, String str2, Map<String, String> map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = (String) Assertions.checkNotNull(matcher.group(1));
        }
        return (map.isEmpty() || str2 == null) ? str2 : replaceVariableReferences(str2, map);
    }

    @Override
    public HlsPlaylist parse(Uri uri, InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (!checkPlaylistHeader(bufferedReader)) {
                throw ParserException.createForMalformedManifest("Input does not start with the #EXTM3U header.", null);
            }
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    Util.closeQuietly(bufferedReader);
                    throw ParserException.createForMalformedManifest("Failed to parse the playlist, could not identify any tags.", null);
                }
                String strTrim = line.trim();
                if (!strTrim.isEmpty()) {
                    if (strTrim.startsWith(TAG_STREAM_INF)) {
                        arrayDeque.add(strTrim);
                        HlsMultivariantPlaylist multivariantPlaylist = parseMultivariantPlaylist(new LineIterator(arrayDeque, bufferedReader), uri.toString());
                        Util.closeQuietly(bufferedReader);
                        return multivariantPlaylist;
                    }
                    if (!strTrim.startsWith(TAG_TARGET_DURATION) && !strTrim.startsWith(TAG_MEDIA_SEQUENCE) && !strTrim.startsWith(TAG_MEDIA_DURATION) && !strTrim.startsWith(TAG_KEY) && !strTrim.startsWith(TAG_BYTERANGE) && !strTrim.equals(TAG_DISCONTINUITY) && !strTrim.equals(TAG_DISCONTINUITY_SEQUENCE) && !strTrim.equals(TAG_ENDLIST)) {
                        arrayDeque.add(strTrim);
                    }
                    arrayDeque.add(strTrim);
                    HlsMediaPlaylist mediaPlaylist = parseMediaPlaylist(this.multivariantPlaylist, this.previousMediaPlaylist, new LineIterator(arrayDeque, bufferedReader), uri.toString());
                    Util.closeQuietly(bufferedReader);
                    return mediaPlaylist;
                }
            }
        } catch (Throwable th) {
            Util.closeQuietly(bufferedReader);
            throw th;
        }
    }
}

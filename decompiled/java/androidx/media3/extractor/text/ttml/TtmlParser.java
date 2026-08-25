package androidx.media3.extractor.text.ttml;

import android.text.Layout;
import androidx.media3.common.C0565C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ColorParser;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.common.util.XmlPullParserUtil;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import androidx.media3.extractor.text.AbstractC1026a;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.LegacySubtitleUtil;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleDecoderException;
import androidx.media3.extractor.text.SubtitleParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import p000a.AbstractC0004e;
import p020b7.AbstractC1332b;
import p055ea.AbstractC2460q;

@UnstableApi
public final class TtmlParser implements SubtitleParser {
    private static final String ATTR_BEGIN = "begin";
    private static final String ATTR_DURATION = "dur";
    private static final String ATTR_END = "end";
    private static final String ATTR_IMAGE = "backgroundImage";
    private static final String ATTR_REGION = "region";
    private static final String ATTR_STYLE = "style";
    public static final int CUE_REPLACEMENT_BEHAVIOR = 1;
    private static final int DEFAULT_CELL_ROWS = 15;
    private static final int DEFAULT_FRAME_RATE = 30;
    private static final String TAG = "TtmlParser";
    private static final String TTP = "http://www.w3.org/ns/ttml#parameter";
    private final XmlPullParserFactory xmlParserFactory;
    private static final Pattern CLOCK_TIME = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern OFFSET_TIME = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern FONT_SIZE = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    static final Pattern SIGNED_PERCENTAGE = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    static final Pattern PERCENTAGE_COORDINATES = Pattern.compile("^([-+]?\\d+\\.?\\d*?)% ([-+]?\\d+\\.?\\d*?)%$");
    private static final Pattern PIXEL_COORDINATES = Pattern.compile("^([-+]?\\d+\\.?\\d*?)px ([-+]?\\d+\\.?\\d*?)px$");
    private static final Pattern CELL_RESOLUTION = Pattern.compile("^(\\d+) (\\d+)$");
    private static final FrameAndTickRate DEFAULT_FRAME_AND_TICK_RATE = new FrameAndTickRate(30.0f, 1, 1);

    public static final class FrameAndTickRate {
        final float effectiveFrameRate;
        final int subFrameRate;
        final int tickRate;

        public FrameAndTickRate(float f, int i6, int i10) {
            this.effectiveFrameRate = f;
            this.subFrameRate = i6;
            this.tickRate = i10;
        }
    }

    public static final class TtsExtent {
        final int height;
        final int width;

        public TtsExtent(int i6, int i10) {
            this.width = i6;
            this.height = i10;
        }
    }

    public TtmlParser() {
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.xmlParserFactory = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e5) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e5);
        }
    }

    private static TtmlStyle createIfNull(TtmlStyle ttmlStyle) {
        return ttmlStyle == null ? new TtmlStyle() : ttmlStyle;
    }

    private static boolean isSupportedTag(String str) {
        return str.equals(TtmlNode.TAG_TT) || str.equals("head") || str.equals(TtmlNode.TAG_BODY) || str.equals(TtmlNode.TAG_DIV) || str.equals(TtmlNode.TAG_P) || str.equals(TtmlNode.TAG_SPAN) || str.equals("br") || str.equals("style") || str.equals(TtmlNode.TAG_STYLING) || str.equals(TtmlNode.TAG_LAYOUT) || str.equals("region") || str.equals(TtmlNode.TAG_METADATA) || str.equals("image") || str.equals("data") || str.equals(TtmlNode.TAG_INFORMATION);
    }

    private static Layout.Alignment parseAlignment(String str) {
        String strM3231v = AbstractC1332b.m3231v(str);
        strM3231v.getClass();
        switch (strM3231v) {
            case "center":
                return Layout.Alignment.ALIGN_CENTER;
            case "end":
            case "right":
                return Layout.Alignment.ALIGN_OPPOSITE;
            case "left":
            case "start":
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
    }

    private static int parseCellRows(XmlPullParser xmlPullParser, int i6) {
        String attributeValue = xmlPullParser.getAttributeValue(TTP, "cellResolution");
        if (attributeValue == null) {
            return i6;
        }
        Matcher matcher = CELL_RESOLUTION.matcher(attributeValue);
        if (!matcher.matches()) {
            Log.m1719w(TAG, "Ignoring malformed cell resolution: ".concat(attributeValue));
            return i6;
        }
        boolean z7 = true;
        try {
            int i10 = Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1)));
            int i11 = Integer.parseInt((String) Assertions.checkNotNull(matcher.group(2)));
            if (i10 == 0 || i11 == 0) {
                z7 = false;
            }
            Assertions.checkArgument(z7, "Invalid cell resolution " + i10 + " " + i11);
            return i11;
        } catch (NumberFormatException unused) {
            Log.m1719w(TAG, "Ignoring malformed cell resolution: ".concat(attributeValue));
            return i6;
        }
    }

    private static void parseFontSize(String str, TtmlStyle ttmlStyle) throws SubtitleDecoderException {
        Matcher matcher;
        String[] strArrSplit = Util.split(str, "\\s+");
        if (strArrSplit.length == 1) {
            matcher = FONT_SIZE.matcher(str);
        } else {
            if (strArrSplit.length != 2) {
                throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + strArrSplit.length + ".");
            }
            matcher = FONT_SIZE.matcher(strArrSplit[1]);
            Log.m1719w(TAG, "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new SubtitleDecoderException(AbstractC0004e.m24r("Invalid expression for fontSize: '", str, "'."));
        }
        String str2 = (String) Assertions.checkNotNull(matcher.group(3));
        str2.getClass();
        switch (str2) {
            case "%":
                ttmlStyle.setFontSizeUnit(3);
                break;
            case "em":
                ttmlStyle.setFontSizeUnit(2);
                break;
            case "px":
                ttmlStyle.setFontSizeUnit(1);
                break;
            default:
                throw new SubtitleDecoderException(AbstractC0004e.m24r("Invalid unit for fontSize: '", str2, "'."));
        }
        ttmlStyle.setFontSize(Float.parseFloat((String) Assertions.checkNotNull(matcher.group(1))));
    }

    private static FrameAndTickRate parseFrameAndTickRates(XmlPullParser xmlPullParser) {
        float f;
        String attributeValue = xmlPullParser.getAttributeValue(TTP, "frameRate");
        int i6 = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue(TTP, "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] strArrSplit = Util.split(attributeValue2, " ");
            Assertions.checkArgument(strArrSplit.length == 2, "frameRateMultiplier doesn't have 2 parts");
            f = Integer.parseInt(strArrSplit[0]) / Integer.parseInt(strArrSplit[1]);
        } else {
            f = 1.0f;
        }
        FrameAndTickRate frameAndTickRate = DEFAULT_FRAME_AND_TICK_RATE;
        int i10 = frameAndTickRate.subFrameRate;
        String attributeValue3 = xmlPullParser.getAttributeValue(TTP, "subFrameRate");
        if (attributeValue3 != null) {
            i10 = Integer.parseInt(attributeValue3);
        }
        int i11 = frameAndTickRate.tickRate;
        String attributeValue4 = xmlPullParser.getAttributeValue(TTP, "tickRate");
        if (attributeValue4 != null) {
            i11 = Integer.parseInt(attributeValue4);
        }
        return new FrameAndTickRate(i6 * f, i10, i11);
    }

    private static Map<String, TtmlStyle> parseHeader(XmlPullParser xmlPullParser, Map<String, TtmlStyle> map, int i6, TtsExtent ttsExtent, Map<String, TtmlRegion> map2, Map<String, String> map3) throws XmlPullParserException, IOException {
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "style")) {
                String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "style");
                TtmlStyle styleAttributes = parseStyleAttributes(xmlPullParser, new TtmlStyle());
                if (attributeValue != null) {
                    for (String str : parseStyleIds(attributeValue)) {
                        styleAttributes.chain(map.get(str));
                    }
                }
                String id = styleAttributes.getId();
                if (id != null) {
                    map.put(id, styleAttributes);
                }
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "region")) {
                TtmlRegion regionAttributes = parseRegionAttributes(xmlPullParser, i6, ttsExtent, map);
                if (regionAttributes != null) {
                    map2.put(regionAttributes.f3109id, regionAttributes);
                }
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, TtmlNode.TAG_METADATA)) {
                parseMetadata(xmlPullParser, map3);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "head"));
        return map;
    }

    private static void parseMetadata(XmlPullParser xmlPullParser, Map<String, String> map) throws XmlPullParserException, IOException {
        String attributeValue;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "image") && (attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, TtmlNode.ATTR_ID)) != null) {
                map.put(attributeValue, xmlPullParser.nextText());
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, TtmlNode.TAG_METADATA));
    }

    private static TtmlNode parseNode(XmlPullParser xmlPullParser, TtmlNode ttmlNode, Map<String, TtmlRegion> map, FrameAndTickRate frameAndTickRate) throws SubtitleDecoderException {
        long j10;
        long j11;
        int attributeCount = xmlPullParser.getAttributeCount();
        TtmlStyle styleAttributes = parseStyleAttributes(xmlPullParser, null);
        String strSubstring = null;
        String str = "";
        long timeExpression = C0565C.TIME_UNSET;
        long timeExpression2 = C0565C.TIME_UNSET;
        long timeExpression3 = C0565C.TIME_UNSET;
        String[] strArr = null;
        for (int i6 = 0; i6 < attributeCount; i6++) {
            String attributeName = xmlPullParser.getAttributeName(i6);
            String attributeValue = xmlPullParser.getAttributeValue(i6);
            attributeName.getClass();
            switch (attributeName) {
                case "region":
                    if (map.containsKey(attributeValue)) {
                        str = attributeValue;
                        continue;
                    }
                    break;
                case "dur":
                    timeExpression3 = parseTimeExpression(attributeValue, frameAndTickRate);
                    break;
                case "end":
                    timeExpression2 = parseTimeExpression(attributeValue, frameAndTickRate);
                    break;
                case "begin":
                    timeExpression = parseTimeExpression(attributeValue, frameAndTickRate);
                    break;
                case "style":
                    String[] styleIds = parseStyleIds(attributeValue);
                    if (styleIds.length > 0) {
                        strArr = styleIds;
                    }
                    break;
                case "backgroundImage":
                    if (attributeValue.startsWith("#")) {
                        strSubstring = attributeValue.substring(1);
                        break;
                    }
                    break;
            }
        }
        if (ttmlNode != null) {
            long j12 = ttmlNode.startTimeUs;
            j10 = C0565C.TIME_UNSET;
            if (j12 != C0565C.TIME_UNSET) {
                if (timeExpression != C0565C.TIME_UNSET) {
                    timeExpression += j12;
                }
                if (timeExpression2 != C0565C.TIME_UNSET) {
                    timeExpression2 += j12;
                }
            }
        } else {
            j10 = C0565C.TIME_UNSET;
        }
        long j13 = timeExpression;
        if (timeExpression2 != j10) {
            j11 = timeExpression2;
        } else if (timeExpression3 != j10) {
            j11 = j13 + timeExpression3;
        } else if (ttmlNode != null) {
            long j14 = ttmlNode.endTimeUs;
            if (j14 != j10) {
                j11 = j14;
            } else {
                j11 = timeExpression2;
            }
        } else {
            j11 = timeExpression2;
        }
        return TtmlNode.buildNode(xmlPullParser.getName(), j13, j11, styleAttributes, strArr, str, strSubstring, ttmlNode);
    }

    private static TtmlRegion parseRegionAttributes(XmlPullParser xmlPullParser, int i6, TtsExtent ttsExtent, Map<String, TtmlStyle> map) {
        float f;
        float f3;
        float f4;
        float f5;
        float f10;
        int i10;
        int i11;
        float f11;
        String attributeValue;
        TtmlStyle ttmlStyle;
        String attributeValue2;
        TtmlStyle ttmlStyle2;
        String attributeValue3 = XmlPullParserUtil.getAttributeValue(xmlPullParser, TtmlNode.ATTR_ID);
        if (attributeValue3 == null) {
            return null;
        }
        String attributeValue4 = XmlPullParserUtil.getAttributeValue(xmlPullParser, TtmlNode.ATTR_TTS_ORIGIN);
        if (attributeValue4 == null && (attributeValue2 = XmlPullParserUtil.getAttributeValue(xmlPullParser, "style")) != null && (ttmlStyle2 = map.get(attributeValue2)) != null) {
            attributeValue4 = ttmlStyle2.getOrigin();
        }
        if (attributeValue4 != null) {
            Matcher matcher = PERCENTAGE_COORDINATES.matcher(attributeValue4);
            Matcher matcher2 = PIXEL_COORDINATES.matcher(attributeValue4);
            if (matcher.matches()) {
                try {
                    f3 = Float.parseFloat((String) Assertions.checkNotNull(matcher.group(1))) / 100.0f;
                    f = Float.parseFloat((String) Assertions.checkNotNull(matcher.group(2))) / 100.0f;
                } catch (NumberFormatException unused) {
                    Log.m1719w(TAG, "Ignoring region with malformed origin: ".concat(attributeValue4));
                    return null;
                }
            } else {
                if (!matcher2.matches()) {
                    Log.m1719w(TAG, "Ignoring region with unsupported origin: ".concat(attributeValue4));
                    return null;
                }
                if (ttsExtent == null) {
                    Log.m1719w(TAG, "Ignoring region with missing tts:extent: ".concat(attributeValue4));
                    return null;
                }
                try {
                    int i12 = Integer.parseInt((String) Assertions.checkNotNull(matcher2.group(1)));
                    int i13 = Integer.parseInt((String) Assertions.checkNotNull(matcher2.group(2)));
                    float f12 = i12 / ttsExtent.width;
                    f = i13 / ttsExtent.height;
                    f3 = f12;
                } catch (NumberFormatException unused2) {
                    Log.m1719w(TAG, "Ignoring region with malformed origin: ".concat(attributeValue4));
                    return null;
                }
            }
        } else {
            f = 0.0f;
            f3 = 0.0f;
        }
        String attributeValue5 = XmlPullParserUtil.getAttributeValue(xmlPullParser, TtmlNode.ATTR_TTS_EXTENT);
        if (attributeValue5 == null && (attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "style")) != null && (ttmlStyle = map.get(attributeValue)) != null) {
            attributeValue5 = ttmlStyle.getExtent();
        }
        if (attributeValue5 != null) {
            Matcher matcher3 = PERCENTAGE_COORDINATES.matcher(attributeValue5);
            Matcher matcher4 = PIXEL_COORDINATES.matcher(attributeValue5);
            if (matcher3.matches()) {
                try {
                    f11 = Float.parseFloat((String) Assertions.checkNotNull(matcher3.group(1))) / 100.0f;
                    f4 = Float.parseFloat((String) Assertions.checkNotNull(matcher3.group(2))) / 100.0f;
                } catch (NumberFormatException unused3) {
                    AbstractC0004e.m4D("Ignoring region with malformed extent: ", attributeValue4, TAG);
                    return null;
                }
            } else {
                if (!matcher4.matches()) {
                    AbstractC0004e.m4D("Ignoring region with unsupported extent: ", attributeValue4, TAG);
                    return null;
                }
                if (ttsExtent == null) {
                    AbstractC0004e.m4D("Ignoring region with missing tts:extent: ", attributeValue4, TAG);
                    return null;
                }
                try {
                    int i14 = Integer.parseInt((String) Assertions.checkNotNull(matcher4.group(1)));
                    int i15 = Integer.parseInt((String) Assertions.checkNotNull(matcher4.group(2)));
                    float f13 = i14 / ttsExtent.width;
                    f4 = i15 / ttsExtent.height;
                    f11 = f13;
                } catch (NumberFormatException unused4) {
                    AbstractC0004e.m4D("Ignoring region with malformed extent: ", attributeValue4, TAG);
                    return null;
                }
            }
            f5 = f11;
        } else {
            f4 = 1.0f;
            f5 = 1.0f;
        }
        String attributeValue6 = XmlPullParserUtil.getAttributeValue(xmlPullParser, TtmlNode.ATTR_TTS_DISPLAY_ALIGN);
        if (attributeValue6 != null) {
            String strM3231v = AbstractC1332b.m3231v(attributeValue6);
            strM3231v.getClass();
            if (strM3231v.equals(TtmlNode.CENTER)) {
                f10 = (f4 / 2.0f) + f;
                i10 = 1;
            } else if (strM3231v.equals(TtmlNode.ANNOTATION_POSITION_AFTER)) {
                f10 = f + f4;
                i10 = 2;
            } else {
                f10 = f;
                i10 = 0;
            }
        } else {
            f10 = f;
            i10 = 0;
        }
        float f14 = 1.0f / i6;
        String attributeValue7 = XmlPullParserUtil.getAttributeValue(xmlPullParser, TtmlNode.ATTR_TTS_WRITING_MODE);
        if (attributeValue7 != null) {
            String strM3231v2 = AbstractC1332b.m3231v(attributeValue7);
            strM3231v2.getClass();
            switch (strM3231v2) {
                case "tb":
                case "tblr":
                    i11 = 2;
                    break;
                case "tbrl":
                    i11 = 1;
                    break;
                default:
                    i11 = Integer.MIN_VALUE;
                    break;
            }
        } else {
            i11 = Integer.MIN_VALUE;
        }
        return new TtmlRegion(attributeValue3, f3, f10, 0, i10, f5, f4, 1, f14, i11);
    }

    private static float parseShear(String str) {
        Matcher matcher = SIGNED_PERCENTAGE.matcher(str);
        if (!matcher.matches()) {
            AbstractC0004e.m4D("Invalid value for shear: ", str, TAG);
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) Assertions.checkNotNull(matcher.group(1)))));
        } catch (NumberFormatException e5) {
            Log.m1720w(TAG, "Failed to parse shear: " + str, e5);
            return Float.MAX_VALUE;
        }
    }

    private static TtmlStyle parseStyleAttributes(XmlPullParser xmlPullParser, TtmlStyle ttmlStyle) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i6 = 0; i6 < attributeCount; i6++) {
            String attributeValue = xmlPullParser.getAttributeValue(i6);
            String attributeName = xmlPullParser.getAttributeName(i6);
            attributeName.getClass();
            switch (attributeName) {
                case "fontStyle":
                    ttmlStyle = createIfNull(ttmlStyle).setItalic(TtmlNode.ITALIC.equalsIgnoreCase(attributeValue));
                    break;
                case "extent":
                    ttmlStyle = createIfNull(ttmlStyle).setExtent(attributeValue);
                    break;
                case "fontFamily":
                    ttmlStyle = createIfNull(ttmlStyle).setFontFamily(attributeValue);
                    break;
                case "textAlign":
                    ttmlStyle = createIfNull(ttmlStyle).setTextAlign(parseAlignment(attributeValue));
                    break;
                case "origin":
                    ttmlStyle = createIfNull(ttmlStyle).setOrigin(attributeValue);
                    break;
                case "textDecoration":
                    String strM3231v = AbstractC1332b.m3231v(attributeValue);
                    strM3231v.getClass();
                    switch (strM3231v) {
                        case "nounderline":
                            ttmlStyle = createIfNull(ttmlStyle).setUnderline(false);
                            break;
                        case "underline":
                            ttmlStyle = createIfNull(ttmlStyle).setUnderline(true);
                            break;
                        case "nolinethrough":
                            ttmlStyle = createIfNull(ttmlStyle).setLinethrough(false);
                            break;
                        case "linethrough":
                            ttmlStyle = createIfNull(ttmlStyle).setLinethrough(true);
                            break;
                    }
                    break;
                case "fontWeight":
                    ttmlStyle = createIfNull(ttmlStyle).setBold(TtmlNode.BOLD.equalsIgnoreCase(attributeValue));
                    break;
                case "id":
                    if (!"style".equals(xmlPullParser.getName())) {
                        break;
                    } else {
                        ttmlStyle = createIfNull(ttmlStyle).setId(attributeValue);
                        break;
                    }
                    break;
                case "ruby":
                    String strM3231v2 = AbstractC1332b.m3231v(attributeValue);
                    strM3231v2.getClass();
                    switch (strM3231v2) {
                        case "baseContainer":
                        case "base":
                            ttmlStyle = createIfNull(ttmlStyle).setRubyType(2);
                            break;
                        case "container":
                            ttmlStyle = createIfNull(ttmlStyle).setRubyType(1);
                            break;
                        case "delimiter":
                            ttmlStyle = createIfNull(ttmlStyle).setRubyType(4);
                            break;
                        case "textContainer":
                        case "text":
                            ttmlStyle = createIfNull(ttmlStyle).setRubyType(3);
                            break;
                    }
                    break;
                case "color":
                    ttmlStyle = createIfNull(ttmlStyle);
                    try {
                        ttmlStyle.setFontColor(ColorParser.parseTtmlColor(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused) {
                        AbstractC0004e.m4D("Failed parsing color value: ", attributeValue, TAG);
                        break;
                    }
                    break;
                case "shear":
                    ttmlStyle = createIfNull(ttmlStyle).setShearPercentage(parseShear(attributeValue));
                    break;
                case "textCombine":
                    String strM3231v3 = AbstractC1332b.m3231v(attributeValue);
                    strM3231v3.getClass();
                    if (!strM3231v3.equals(TtmlNode.COMBINE_ALL)) {
                        if (strM3231v3.equals("none")) {
                            ttmlStyle = createIfNull(ttmlStyle).setTextCombine(false);
                        }
                        break;
                    } else {
                        ttmlStyle = createIfNull(ttmlStyle).setTextCombine(true);
                        break;
                    }
                    break;
                case "fontSize":
                    try {
                        ttmlStyle = createIfNull(ttmlStyle);
                        parseFontSize(attributeValue, ttmlStyle);
                        break;
                    } catch (SubtitleDecoderException unused2) {
                        AbstractC0004e.m4D("Failed parsing fontSize value: ", attributeValue, TAG);
                        break;
                    }
                    break;
                case "textEmphasis":
                    ttmlStyle = createIfNull(ttmlStyle).setTextEmphasis(TextEmphasis.parse(attributeValue));
                    break;
                case "rubyPosition":
                    String strM3231v4 = AbstractC1332b.m3231v(attributeValue);
                    strM3231v4.getClass();
                    if (!strM3231v4.equals(TtmlNode.ANNOTATION_POSITION_BEFORE)) {
                        if (strM3231v4.equals(TtmlNode.ANNOTATION_POSITION_AFTER)) {
                            ttmlStyle = createIfNull(ttmlStyle).setRubyPosition(2);
                        }
                        break;
                    } else {
                        ttmlStyle = createIfNull(ttmlStyle).setRubyPosition(1);
                        break;
                    }
                    break;
                case "backgroundColor":
                    ttmlStyle = createIfNull(ttmlStyle);
                    try {
                        ttmlStyle.setBackgroundColor(ColorParser.parseTtmlColor(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused3) {
                        AbstractC0004e.m4D("Failed parsing background value: ", attributeValue, TAG);
                        break;
                    }
                    break;
                case "multiRowAlign":
                    ttmlStyle = createIfNull(ttmlStyle).setMultiRowAlign(parseAlignment(attributeValue));
                    break;
            }
        }
        return ttmlStyle;
    }

    private static String[] parseStyleIds(String str) {
        String strTrim = str.trim();
        return strTrim.isEmpty() ? new String[0] : Util.split(strTrim, "\\s+");
    }

    private static long parseTimeExpression(String str, FrameAndTickRate frameAndTickRate) throws SubtitleDecoderException {
        double d;
        double d10;
        byte b8 = 4;
        Matcher matcher = CLOCK_TIME.matcher(str);
        if (matcher.matches()) {
            double d11 = (Long.parseLong((String) Assertions.checkNotNull(matcher.group(1))) * 3600) + (Long.parseLong((String) Assertions.checkNotNull(matcher.group(2))) * 60) + Long.parseLong((String) Assertions.checkNotNull(matcher.group(3)));
            String strGroup = matcher.group(4);
            double d12 = d11 + (strGroup != null ? Double.parseDouble(strGroup) : 0.0d);
            String strGroup2 = matcher.group(5);
            double d13 = d12 + (strGroup2 != null ? Long.parseLong(strGroup2) / frameAndTickRate.effectiveFrameRate : 0.0d);
            String strGroup3 = matcher.group(6);
            return (long) ((d13 + (strGroup3 != null ? (Long.parseLong(strGroup3) / ((double) frameAndTickRate.subFrameRate)) / ((double) frameAndTickRate.effectiveFrameRate) : 0.0d)) * 1000000.0d);
        }
        Matcher matcher2 = OFFSET_TIME.matcher(str);
        if (!matcher2.matches()) {
            throw new SubtitleDecoderException(AbstractC2460q.m5501o("Malformed time expression: ", str));
        }
        double d14 = Double.parseDouble((String) Assertions.checkNotNull(matcher2.group(1)));
        String str2 = (String) Assertions.checkNotNull(matcher2.group(2));
        str2.getClass();
        switch (str2.hashCode()) {
            case 102:
                if (!str2.equals("f")) {
                    b8 = -1;
                } else {
                    b8 = 0;
                }
                break;
            case 104:
                if (!str2.equals(CmcdData.STREAMING_FORMAT_HLS)) {
                    b8 = -1;
                } else {
                    b8 = 1;
                }
                break;
            case 109:
                if (!str2.equals(CmcdData.OBJECT_TYPE_MANIFEST)) {
                    b8 = -1;
                } else {
                    b8 = 2;
                }
                break;
            case AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID:
                if (!str2.equals("t")) {
                    b8 = -1;
                } else {
                    b8 = 3;
                }
                break;
            case 3494:
                if (!str2.equals("ms")) {
                    b8 = -1;
                }
                break;
            default:
                b8 = -1;
                break;
        }
        switch (b8) {
            case 0:
                d = frameAndTickRate.effectiveFrameRate;
                d14 /= d;
                return (long) (d14 * 1000000.0d);
            case 1:
                d10 = 3600.0d;
                break;
            case 2:
                d10 = 60.0d;
                break;
            case 3:
                d = frameAndTickRate.tickRate;
                d14 /= d;
                return (long) (d14 * 1000000.0d);
            case 4:
                d = 1000.0d;
                d14 /= d;
                return (long) (d14 * 1000000.0d);
            default:
                return (long) (d14 * 1000000.0d);
        }
        d14 *= d10;
        return (long) (d14 * 1000000.0d);
    }

    private static TtsExtent parseTtsExtent(XmlPullParser xmlPullParser) {
        String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, TtmlNode.ATTR_TTS_EXTENT);
        if (attributeValue == null) {
            return null;
        }
        Matcher matcher = PIXEL_COORDINATES.matcher(attributeValue);
        if (!matcher.matches()) {
            Log.m1719w(TAG, "Ignoring non-pixel tts extent: ".concat(attributeValue));
            return null;
        }
        try {
            return new TtsExtent(Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1))), Integer.parseInt((String) Assertions.checkNotNull(matcher.group(2))));
        } catch (NumberFormatException unused) {
            Log.m1719w(TAG, "Ignoring malformed tts extent: ".concat(attributeValue));
            return null;
        }
    }

    @Override
    public int getCueReplacementBehavior() {
        return 1;
    }

    @Override
    public final void parse(byte[] bArr, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        AbstractC1026a.m2673a(this, bArr, outputOptions, consumer);
    }

    @Override
    public Subtitle parseToLegacySubtitle(byte[] bArr, int i6, int i10) {
        FrameAndTickRate frameAndTickRate;
        try {
            XmlPullParser xmlPullParserNewPullParser = this.xmlParserFactory.newPullParser();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            map2.put("", new TtmlRegion(""));
            TtsExtent ttsExtent = null;
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, i6, i10), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            FrameAndTickRate frameAndTickRates = DEFAULT_FRAME_AND_TICK_RATE;
            TtmlSubtitle ttmlSubtitle = null;
            int cellRows = 15;
            int i11 = 0;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.getEventType()) {
                TtmlNode ttmlNode = (TtmlNode) arrayDeque.peek();
                if (i11 == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (eventType == 2) {
                        if (TtmlNode.TAG_TT.equals(name)) {
                            frameAndTickRates = parseFrameAndTickRates(xmlPullParserNewPullParser);
                            cellRows = parseCellRows(xmlPullParserNewPullParser, 15);
                            ttsExtent = parseTtsExtent(xmlPullParserNewPullParser);
                        }
                        TtsExtent ttsExtent2 = ttsExtent;
                        FrameAndTickRate frameAndTickRate2 = frameAndTickRates;
                        int i12 = cellRows;
                        if (isSupportedTag(name)) {
                            if ("head".equals(name)) {
                                frameAndTickRate = frameAndTickRate2;
                                parseHeader(xmlPullParserNewPullParser, map, i12, ttsExtent2, map2, map3);
                            } else {
                                frameAndTickRate = frameAndTickRate2;
                                try {
                                    TtmlNode node = parseNode(xmlPullParserNewPullParser, ttmlNode, map2, frameAndTickRate);
                                    arrayDeque.push(node);
                                    if (ttmlNode != null) {
                                        ttmlNode.addChild(node);
                                    }
                                } catch (SubtitleDecoderException e5) {
                                    Log.m1720w(TAG, "Suppressing parser error", e5);
                                    i11++;
                                }
                            }
                            frameAndTickRates = frameAndTickRate;
                        } else {
                            Log.m1717i(TAG, "Ignoring unsupported tag: " + xmlPullParserNewPullParser.getName());
                            i11++;
                            frameAndTickRates = frameAndTickRate2;
                        }
                        ttsExtent = ttsExtent2;
                        cellRows = i12;
                    } else if (eventType == 4) {
                        ((TtmlNode) Assertions.checkNotNull(ttmlNode)).addChild(TtmlNode.buildTextNode(xmlPullParserNewPullParser.getText()));
                    } else if (eventType == 3) {
                        if (xmlPullParserNewPullParser.getName().equals(TtmlNode.TAG_TT)) {
                            ttmlSubtitle = new TtmlSubtitle((TtmlNode) Assertions.checkNotNull((TtmlNode) arrayDeque.peek()), map, map2, map3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i11++;
                } else if (eventType == 3) {
                    i11--;
                }
                xmlPullParserNewPullParser.next();
            }
            return (Subtitle) Assertions.checkNotNull(ttmlSubtitle);
        } catch (IOException e10) {
            throw new IllegalStateException("Unexpected error when reading input.", e10);
        } catch (XmlPullParserException e11) {
            throw new IllegalStateException("Unable to decode source", e11);
        }
    }

    @Override
    public final void reset() {
        AbstractC1026a.m2675c(this);
    }

    @Override
    public void parse(byte[] bArr, int i6, int i10, SubtitleParser.OutputOptions outputOptions, Consumer<CuesWithTiming> consumer) {
        LegacySubtitleUtil.toCuesWithTiming(parseToLegacySubtitle(bArr, i6, i10), outputOptions, consumer);
    }
}

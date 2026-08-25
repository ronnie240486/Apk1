package androidx.media3.extractor.jpeg;

import androidx.media3.common.C0565C;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.XmlPullParserUtil;
import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import p041d7.AbstractC2301u1;
import p041d7.C2180c5;
import p041d7.C2204g1;
import p041d7.C2288s1;
import p055ea.AbstractC2460q;

final class XmpMotionPhotoDescriptionParser {
    private static final String TAG = "MotionPhotoXmpParser";
    private static final String[] MOTION_PHOTO_ATTRIBUTE_NAMES = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};
    private static final String[] DESCRIPTION_MOTION_PHOTO_PRESENTATION_TIMESTAMP_ATTRIBUTE_NAMES = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    private static final String[] DESCRIPTION_MICRO_VIDEO_OFFSET_ATTRIBUTE_NAMES = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    private XmpMotionPhotoDescriptionParser() {
    }

    public static MotionPhotoDescription parse(String str) throws IOException {
        try {
            return parseInternal(str);
        } catch (ParserException | NumberFormatException | XmlPullParserException unused) {
            Log.m1719w(TAG, "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    private static MotionPhotoDescription parseInternal(String str) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParserNewPullParser.setInput(new StringReader(str));
        xmlPullParserNewPullParser.next();
        if (!XmlPullParserUtil.isStartTag(xmlPullParserNewPullParser, "x:xmpmeta")) {
            throw ParserException.createForMalformedContainer("Couldn't find xmp metadata", null);
        }
        C2204g1 c2204g1 = AbstractC2301u1.f8069b;
        AbstractC2301u1 motionPhotoV1Directory = C2180c5.f7862e;
        long motionPhotoPresentationTimestampUsFromDescription = C0565C.TIME_UNSET;
        do {
            xmlPullParserNewPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParserNewPullParser, "rdf:Description")) {
                if (!parseMotionPhotoFlagFromDescription(xmlPullParserNewPullParser)) {
                    return null;
                }
                motionPhotoPresentationTimestampUsFromDescription = parseMotionPhotoPresentationTimestampUsFromDescription(xmlPullParserNewPullParser);
                motionPhotoV1Directory = parseMicroVideoOffsetFromDescription(xmlPullParserNewPullParser);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParserNewPullParser, "Container:Directory")) {
                motionPhotoV1Directory = parseMotionPhotoV1Directory(xmlPullParserNewPullParser, "Container", "Item");
            } else if (XmlPullParserUtil.isStartTag(xmlPullParserNewPullParser, "GContainer:Directory")) {
                motionPhotoV1Directory = parseMotionPhotoV1Directory(xmlPullParserNewPullParser, "GContainer", "GContainerItem");
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParserNewPullParser, "x:xmpmeta"));
        if (motionPhotoV1Directory.isEmpty()) {
            return null;
        }
        return new MotionPhotoDescription(motionPhotoPresentationTimestampUsFromDescription, motionPhotoV1Directory);
    }

    private static AbstractC2301u1 parseMicroVideoOffsetFromDescription(XmlPullParser xmlPullParser) {
        for (String str : DESCRIPTION_MICRO_VIDEO_OFFSET_ATTRIBUTE_NAMES) {
            String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, str);
            if (attributeValue != null) {
                return AbstractC2301u1.m5276s(new MotionPhotoDescription.ContainerItem(MimeTypes.IMAGE_JPEG, "Primary", 0L, 0L), new MotionPhotoDescription.ContainerItem(MimeTypes.VIDEO_MP4, "MotionPhoto", Long.parseLong(attributeValue), 0L));
            }
        }
        C2204g1 c2204g1 = AbstractC2301u1.f8069b;
        return C2180c5.f7862e;
    }

    private static boolean parseMotionPhotoFlagFromDescription(XmlPullParser xmlPullParser) {
        for (String str : MOTION_PHOTO_ATTRIBUTE_NAMES) {
            String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, str);
            if (attributeValue != null) {
                return Integer.parseInt(attributeValue) == 1;
            }
        }
        return false;
    }

    private static long parseMotionPhotoPresentationTimestampUsFromDescription(XmlPullParser xmlPullParser) {
        for (String str : DESCRIPTION_MOTION_PHOTO_PRESENTATION_TIMESTAMP_ATTRIBUTE_NAMES) {
            String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, str);
            if (attributeValue != null) {
                long j10 = Long.parseLong(attributeValue);
                return j10 == -1 ? C0565C.TIME_UNSET : j10;
            }
        }
        return C0565C.TIME_UNSET;
    }

    private static AbstractC2301u1 parseMotionPhotoV1Directory(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        C2288s1 c2288s1M5269k = AbstractC2301u1.m5269k();
        String strM5494h = AbstractC2460q.m5494h(str, ":Item");
        String strM5494h2 = AbstractC2460q.m5494h(str, ":Directory");
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, strM5494h)) {
                String strM5494h3 = AbstractC2460q.m5494h(str2, ":Mime");
                String strM5494h4 = AbstractC2460q.m5494h(str2, ":Semantic");
                String strM5494h5 = AbstractC2460q.m5494h(str2, ":Length");
                String strM5494h6 = AbstractC2460q.m5494h(str2, ":Padding");
                String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, strM5494h3);
                String attributeValue2 = XmlPullParserUtil.getAttributeValue(xmlPullParser, strM5494h4);
                String attributeValue3 = XmlPullParserUtil.getAttributeValue(xmlPullParser, strM5494h5);
                String attributeValue4 = XmlPullParserUtil.getAttributeValue(xmlPullParser, strM5494h6);
                if (attributeValue == null || attributeValue2 == null) {
                    return C2180c5.f7862e;
                }
                c2288s1M5269k.m5255a(new MotionPhotoDescription.ContainerItem(attributeValue, attributeValue2, attributeValue3 != null ? Long.parseLong(attributeValue3) : 0L, attributeValue4 != null ? Long.parseLong(attributeValue4) : 0L));
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, strM5494h2));
        return c2288s1M5269k.m5262g();
    }
}

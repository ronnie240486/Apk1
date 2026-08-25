package androidx.media3.extractor.text.ttml;

import android.text.TextUtils;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Pattern;
import p020b7.AbstractC1332b;
import p041d7.AbstractC2182d0;
import p041d7.AbstractC2233k2;
import p041d7.C2222i5;
import p041d7.C2247m2;
import p041d7.C2250m5;
import p041d7.C2287s0;

final class TextEmphasis {
    public static final int MARK_SHAPE_AUTO = -1;
    public static final int POSITION_OUTSIDE = -2;
    public final int markFill;
    public final int markShape;
    public final int position;
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s+");
    private static final AbstractC2233k2 SINGLE_STYLE_VALUES = AbstractC2233k2.m5235k(new Object[]{TtmlNode.TEXT_EMPHASIS_AUTO, "none"}, 2);
    private static final AbstractC2233k2 MARK_SHAPE_VALUES = AbstractC2233k2.m5235k(new Object[]{TtmlNode.TEXT_EMPHASIS_MARK_DOT, TtmlNode.TEXT_EMPHASIS_MARK_SESAME, TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE}, 3);
    private static final AbstractC2233k2 MARK_FILL_VALUES = AbstractC2233k2.m5235k(new Object[]{TtmlNode.TEXT_EMPHASIS_MARK_FILLED, TtmlNode.TEXT_EMPHASIS_MARK_OPEN}, 2);
    private static final AbstractC2233k2 POSITION_VALUES = AbstractC2233k2.m5235k(new Object[]{TtmlNode.ANNOTATION_POSITION_AFTER, TtmlNode.ANNOTATION_POSITION_BEFORE, TtmlNode.ANNOTATION_POSITION_OUTSIDE}, 3);

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Position {
    }

    private TextEmphasis(int i6, int i10, int i11) {
        this.markShape = i6;
        this.markFill = i10;
        this.position = i11;
    }

    public static TextEmphasis parse(String str) {
        AbstractC2233k2 c2247m2;
        if (str == null) {
            return null;
        }
        String strM3231v = AbstractC1332b.m3231v(str.trim());
        if (strM3231v.isEmpty()) {
            return null;
        }
        String[] strArrSplit = TextUtils.split(strM3231v, WHITESPACE_PATTERN);
        int length = strArrSplit.length;
        if (length == 0) {
            c2247m2 = C2222i5.f7947j;
        } else if (length != 1) {
            c2247m2 = AbstractC2233k2.m5235k((Object[]) strArrSplit.clone(), strArrSplit.length);
        } else {
            c2247m2 = new C2247m2(strArrSplit[0]);
        }
        return parseWords(c2247m2);
    }

    private static TextEmphasis parseWords(AbstractC2233k2 abstractC2233k2) {
        byte b8;
        int i6;
        C2287s0 c2287s0;
        Object next;
        String str;
        int iHashCode;
        C2287s0 c2287s1 = new C2287s0(AbstractC2182d0.m5154q(POSITION_VALUES, abstractC2233k2));
        String str2 = (String) (c2287s1.hasNext() ? c2287s1.next() : TtmlNode.ANNOTATION_POSITION_OUTSIDE);
        int iHashCode2 = str2.hashCode();
        int i10 = 2;
        byte b10 = 0;
        int i11 = -1;
        if (iHashCode2 != -1392885889) {
            if (iHashCode2 != -1106037339) {
                if (iHashCode2 == 92734940 && str2.equals(TtmlNode.ANNOTATION_POSITION_AFTER)) {
                    b8 = 0;
                } else {
                    b8 = -1;
                }
            } else if (str2.equals(TtmlNode.ANNOTATION_POSITION_OUTSIDE)) {
                b8 = 1;
            } else {
                b8 = -1;
            }
        } else if (str2.equals(TtmlNode.ANNOTATION_POSITION_BEFORE)) {
            b8 = 2;
        } else {
            b8 = -1;
        }
        if (b8 != 0) {
            i6 = b8 != 1 ? 1 : -2;
        } else {
            i6 = 2;
        }
        C2250m5 c2250m5M5154q = AbstractC2182d0.m5154q(SINGLE_STYLE_VALUES, abstractC2233k2);
        if (!c2250m5M5154q.isEmpty()) {
            String str3 = (String) new C2287s0(c2250m5M5154q).next();
            int iHashCode3 = str3.hashCode();
            if (iHashCode3 == 3005871) {
                str3.equals(TtmlNode.TEXT_EMPHASIS_AUTO);
            } else if (iHashCode3 == 3387192 && str3.equals("none")) {
                i11 = 0;
            }
            return new TextEmphasis(i11, 0, i6);
        }
        C2250m5 c2250m5M5154q2 = AbstractC2182d0.m5154q(MARK_FILL_VALUES, abstractC2233k2);
        C2250m5 c2250m5M5154q3 = AbstractC2182d0.m5154q(MARK_SHAPE_VALUES, abstractC2233k2);
        if (c2250m5M5154q2.isEmpty() && c2250m5M5154q3.isEmpty()) {
            return new TextEmphasis(-1, 0, i6);
        }
        C2287s0 c2287s2 = new C2287s0(c2250m5M5154q2);
        String str4 = (String) (c2287s2.hasNext() ? c2287s2.next() : TtmlNode.TEXT_EMPHASIS_MARK_FILLED);
        int iHashCode4 = str4.hashCode();
        if (iHashCode4 != -1274499742) {
            int i12 = (iHashCode4 == 3417674 && str4.equals(TtmlNode.TEXT_EMPHASIS_MARK_OPEN)) ? 2 : 1;
            c2287s0 = new C2287s0(c2250m5M5154q3);
            if (c2287s0.hasNext()) {
                next = c2287s0.next();
            } else {
                next = TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE;
            }
            str = (String) next;
            iHashCode = str.hashCode();
            if (iHashCode != -1360216880) {
                if (iHashCode != -905816648) {
                    if (iHashCode == 99657 || !str.equals(TtmlNode.TEXT_EMPHASIS_MARK_DOT)) {
                        b10 = -1;
                    }
                } else if (str.equals(TtmlNode.TEXT_EMPHASIS_MARK_SESAME)) {
                    b10 = 1;
                } else {
                    b10 = -1;
                }
            } else if (str.equals(TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE)) {
                b10 = 2;
            } else {
                b10 = -1;
            }
            if (b10 != 0) {
                if (b10 != 1) {
                    i10 = 1;
                } else {
                    i10 = 3;
                }
            }
            return new TextEmphasis(i10, i12, i6);
        }
        str4.equals(TtmlNode.TEXT_EMPHASIS_MARK_FILLED);
        c2287s0 = new C2287s0(c2250m5M5154q3);
        if (c2287s0.hasNext()) {
            next = c2287s0.next();
        } else {
            next = TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE;
        }
        str = (String) next;
        iHashCode = str.hashCode();
        if (iHashCode != -1360216880) {
            if (iHashCode != -905816648) {
                if (iHashCode == 99657) {
                    b10 = -1;
                } else {
                    b10 = -1;
                }
            } else if (str.equals(TtmlNode.TEXT_EMPHASIS_MARK_SESAME)) {
                b10 = 1;
            } else {
                b10 = -1;
            }
        } else if (str.equals(TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE)) {
            b10 = 2;
        } else {
            b10 = -1;
        }
        if (b10 != 0) {
            if (b10 != 1) {
                i10 = 1;
            } else {
                i10 = 3;
            }
        }
        return new TextEmphasis(i10, i12, i6);
    }
}

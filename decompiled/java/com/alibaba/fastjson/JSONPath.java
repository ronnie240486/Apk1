package com.alibaba.fastjson;

import androidx.media3.exoplayer.rtsp.SessionDescription;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.FieldSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;
import p000a.AbstractC0004e;
import p055ea.AbstractC2460q;

public class JSONPath implements JSONAware {
    static final long LENGTH = -1580386065683472715L;
    static final long SIZE = 5614464919154503228L;
    private static ConcurrentMap<String, JSONPath> pathCache = new ConcurrentHashMap(128, 0.75f, 1);
    private boolean hasRefSegment;
    private boolean ignoreNullValue;
    private ParserConfig parserConfig;
    private final String path;
    private Segment[] segments;
    private SerializeConfig serializeConfig;

    public static class C14421 {
        static final int[] $SwitchMap$com$alibaba$fastjson$JSONPath$Operator;

        static {
            int[] iArr = new int[Operator.values().length];
            $SwitchMap$com$alibaba$fastjson$JSONPath$Operator = iArr;
            try {
                iArr[Operator.EQ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[Operator.NE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[Operator.GE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[Operator.GT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[Operator.LE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[Operator.LT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static class ArrayAccessSegment implements Segment {
        private final int index;

        public ArrayAccessSegment(int i6) {
            this.index = i6;
        }

        @Override
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.getArrayItem(obj2, this.index);
        }

        @Override
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            if (((JSONLexerBase) defaultJSONParser.lexer).seekArrayToItem(this.index) && context.eval) {
                context.object = defaultJSONParser.parse();
            }
        }

        public boolean remove(JSONPath jSONPath, Object obj) {
            return jSONPath.removeArrayItem(jSONPath, obj, this.index);
        }

        public boolean setValue(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.setArrayItem(jSONPath, obj, this.index, obj2);
        }
    }

    public static class Context {
        final boolean eval;
        Object object;
        final Context parent;

        public Context(Context context, boolean z7) {
            this.parent = context;
            this.eval = z7;
        }
    }

    public static class DoubleOpSegement extends PropertyFilter {

        private final Operator f4375op;
        private final double value;

        public DoubleOpSegement(String str, boolean z7, double d, Operator operator) {
            super(str, z7);
            this.value = d;
            this.f4375op = operator;
        }

        @Override
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object obj4 = get(jSONPath, obj, obj3);
            if (obj4 == null || !(obj4 instanceof Number)) {
                return false;
            }
            double dDoubleValue = ((Number) obj4).doubleValue();
            switch (C14421.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.f4375op.ordinal()]) {
                case 1:
                    return dDoubleValue == this.value;
                case 2:
                    return dDoubleValue != this.value;
                case 3:
                    return dDoubleValue >= this.value;
                case 4:
                    return dDoubleValue > this.value;
                case 5:
                    return dDoubleValue <= this.value;
                case 6:
                    return dDoubleValue < this.value;
                default:
                    return false;
            }
        }
    }

    public interface Filter {
        boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3);
    }

    public static class FilterGroup implements Filter {
        private boolean and;
        private List<Filter> fitlers;

        public FilterGroup(Filter filter, Filter filter2, boolean z7) {
            ArrayList arrayList = new ArrayList(2);
            this.fitlers = arrayList;
            arrayList.add(filter);
            this.fitlers.add(filter2);
            this.and = z7;
        }

        @Override
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            if (this.and) {
                Iterator<Filter> it = this.fitlers.iterator();
                while (it.hasNext()) {
                    if (!it.next().apply(jSONPath, obj, obj2, obj3)) {
                        return false;
                    }
                }
                return true;
            }
            Iterator<Filter> it2 = this.fitlers.iterator();
            while (it2.hasNext()) {
                if (it2.next().apply(jSONPath, obj, obj2, obj3)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class FilterSegment implements Segment {
        private final Filter filter;

        public FilterSegment(Filter filter) {
            this.filter = filter;
        }

        @Override
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (obj2 == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            if (!(obj2 instanceof Iterable)) {
                if (this.filter.apply(jSONPath, obj, obj2, obj2)) {
                    return obj2;
                }
                return null;
            }
            for (Object obj3 : (Iterable) obj2) {
                if (this.filter.apply(jSONPath, obj, obj2, obj3)) {
                    jSONArray.add(obj3);
                }
            }
            return jSONArray;
        }

        @Override
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            Object obj = defaultJSONParser.parse();
            context.object = eval(jSONPath, obj, obj);
        }

        public boolean remove(JSONPath jSONPath, Object obj, Object obj2) {
            if (obj2 == null || !(obj2 instanceof Iterable)) {
                return false;
            }
            Iterator it = ((Iterable) obj2).iterator();
            while (it.hasNext()) {
                if (this.filter.apply(jSONPath, obj, obj2, it.next())) {
                    it.remove();
                }
            }
            return true;
        }
    }

    public static class FloorSegment implements Segment {
        public static final FloorSegment instance = new FloorSegment();

        private static Object floor(Object obj) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Float) {
                return Double.valueOf(Math.floor(((Float) obj).floatValue()));
            }
            if (obj instanceof Double) {
                return Double.valueOf(Math.floor(((Double) obj).doubleValue()));
            }
            if (obj instanceof BigDecimal) {
                return ((BigDecimal) obj).setScale(0, RoundingMode.FLOOR);
            }
            if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof BigInteger)) {
                return obj;
            }
            throw new UnsupportedOperationException();
        }

        @Override
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (!(obj2 instanceof JSONArray)) {
                return floor(obj2);
            }
            JSONArray jSONArray = (JSONArray) ((JSONArray) obj2).clone();
            for (int i6 = 0; i6 < jSONArray.size(); i6++) {
                Object obj3 = jSONArray.get(i6);
                Object objFloor = floor(obj3);
                if (objFloor != obj3) {
                    jSONArray.set(i6, objFloor);
                }
            }
            return jSONArray;
        }

        @Override
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }
    }

    public static class IntBetweenSegement extends PropertyFilter {
        private final long endValue;
        private final boolean not;
        private final long startValue;

        public IntBetweenSegement(String str, boolean z7, long j10, long j11, boolean z10) {
            super(str, z7);
            this.startValue = j10;
            this.endValue = j11;
            this.not = z10;
        }

        @Override
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object obj4 = get(jSONPath, obj, obj3);
            if (obj4 == null) {
                return false;
            }
            if (obj4 instanceof Number) {
                long jLongExtractValue = TypeUtils.longExtractValue((Number) obj4);
                if (jLongExtractValue >= this.startValue && jLongExtractValue <= this.endValue) {
                    return !this.not;
                }
            }
            return this.not;
        }
    }

    public static class IntInSegement extends PropertyFilter {
        private final boolean not;
        private final long[] values;

        public IntInSegement(String str, boolean z7, long[] jArr, boolean z10) {
            super(str, z7);
            this.values = jArr;
            this.not = z10;
        }

        @Override
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object obj4 = get(jSONPath, obj, obj3);
            if (obj4 == null) {
                return false;
            }
            if (obj4 instanceof Number) {
                long jLongExtractValue = TypeUtils.longExtractValue((Number) obj4);
                for (long j10 : this.values) {
                    if (j10 == jLongExtractValue) {
                        return !this.not;
                    }
                }
            }
            return this.not;
        }
    }

    public static class IntObjInSegement extends PropertyFilter {
        private final boolean not;
        private final Long[] values;

        public IntObjInSegement(String str, boolean z7, Long[] lArr, boolean z10) {
            super(str, z7);
            this.values = lArr;
            this.not = z10;
        }

        @Override
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object obj4 = get(jSONPath, obj, obj3);
            int i6 = 0;
            if (obj4 == null) {
                Long[] lArr = this.values;
                int length = lArr.length;
                while (i6 < length) {
                    if (lArr[i6] == null) {
                        return !this.not;
                    }
                    i6++;
                }
                return this.not;
            }
            if (obj4 instanceof Number) {
                long jLongExtractValue = TypeUtils.longExtractValue((Number) obj4);
                Long[] lArr2 = this.values;
                int length2 = lArr2.length;
                while (i6 < length2) {
                    Long l9 = lArr2[i6];
                    if (l9 != null && l9.longValue() == jLongExtractValue) {
                        return !this.not;
                    }
                    i6++;
                }
            }
            return this.not;
        }
    }

    public static class IntOpSegement extends PropertyFilter {

        private final Operator f4376op;
        private final long value;
        private BigDecimal valueDecimal;
        private Double valueDouble;
        private Float valueFloat;

        public IntOpSegement(String str, boolean z7, long j10, Operator operator) {
            super(str, z7);
            this.value = j10;
            this.f4376op = operator;
        }

        @Override
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object obj4 = get(jSONPath, obj, obj3);
            if (obj4 == null || !(obj4 instanceof Number)) {
                return false;
            }
            if (obj4 instanceof BigDecimal) {
                if (this.valueDecimal == null) {
                    this.valueDecimal = BigDecimal.valueOf(this.value);
                }
                int iCompareTo = this.valueDecimal.compareTo((BigDecimal) obj4);
                switch (C14421.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.f4376op.ordinal()]) {
                    case 1:
                        return iCompareTo == 0;
                    case 2:
                        return iCompareTo != 0;
                    case 3:
                        return iCompareTo <= 0;
                    case 4:
                        return iCompareTo < 0;
                    case 5:
                        return iCompareTo >= 0;
                    case 6:
                        return iCompareTo > 0;
                    default:
                        return false;
                }
            }
            if (obj4 instanceof Float) {
                if (this.valueFloat == null) {
                    this.valueFloat = Float.valueOf(this.value);
                }
                int iCompareTo2 = this.valueFloat.compareTo((Float) obj4);
                switch (C14421.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.f4376op.ordinal()]) {
                    case 1:
                        return iCompareTo2 == 0;
                    case 2:
                        return iCompareTo2 != 0;
                    case 3:
                        return iCompareTo2 <= 0;
                    case 4:
                        return iCompareTo2 < 0;
                    case 5:
                        return iCompareTo2 >= 0;
                    case 6:
                        return iCompareTo2 > 0;
                    default:
                        return false;
                }
            }
            if (!(obj4 instanceof Double)) {
                long jLongExtractValue = TypeUtils.longExtractValue((Number) obj4);
                switch (C14421.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.f4376op.ordinal()]) {
                    case 1:
                        return jLongExtractValue == this.value;
                    case 2:
                        return jLongExtractValue != this.value;
                    case 3:
                        return jLongExtractValue >= this.value;
                    case 4:
                        return jLongExtractValue > this.value;
                    case 5:
                        return jLongExtractValue <= this.value;
                    case 6:
                        return jLongExtractValue < this.value;
                    default:
                        return false;
                }
            }
            if (this.valueDouble == null) {
                this.valueDouble = Double.valueOf(this.value);
            }
            int iCompareTo3 = this.valueDouble.compareTo((Double) obj4);
            switch (C14421.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.f4376op.ordinal()]) {
                case 1:
                    return iCompareTo3 == 0;
                case 2:
                    return iCompareTo3 != 0;
                case 3:
                    return iCompareTo3 <= 0;
                case 4:
                    return iCompareTo3 < 0;
                case 5:
                    return iCompareTo3 >= 0;
                case 6:
                    return iCompareTo3 > 0;
                default:
                    return false;
            }
        }
    }

    public static class JSONPathParser {

        private char f4377ch;
        private boolean hasRefSegment;
        private int level;
        private final String path;
        private int pos;
        private static final String strArrayRegex = "'\\s*,\\s*'";
        private static final Pattern strArrayPatternx = Pattern.compile(strArrayRegex);

        public JSONPathParser(String str) {
            this.path = str;
            next();
        }

        public static boolean isDigitFirst(char c5) {
            return c5 == '-' || c5 == '+' || (c5 >= '0' && c5 <= '9');
        }

        public void accept(char c5) {
            if (this.f4377ch == ' ') {
                next();
            }
            if (this.f4377ch == c5) {
                if (isEOF()) {
                    return;
                }
                next();
            } else {
                throw new JSONPathException("expect '" + c5 + ", but '" + this.f4377ch + "'");
            }
        }

        public Segment buildArraySegement(String str) {
            int length = str.length();
            char cCharAt = str.charAt(0);
            int i6 = length - 1;
            char cCharAt2 = str.charAt(i6);
            int iIndexOf = str.indexOf(44);
            if (str.length() > 2 && cCharAt == '\'' && cCharAt2 == '\'') {
                String strSubstring = str.substring(1, i6);
                return (iIndexOf == -1 || !strArrayPatternx.matcher(str).find()) ? new PropertySegment(strSubstring, false) : new MultiPropertySegment(strSubstring.split(strArrayRegex));
            }
            int iIndexOf2 = str.indexOf(58);
            if (iIndexOf == -1 && iIndexOf2 == -1) {
                if (TypeUtils.isNumber(str)) {
                    try {
                        return new ArrayAccessSegment(Integer.parseInt(str));
                    } catch (NumberFormatException unused) {
                        return new PropertySegment(str, false);
                    }
                }
                if (str.charAt(0) == '\"' && str.charAt(str.length() - 1) == '\"') {
                    str = str.substring(1, str.length() - 1);
                }
                return new PropertySegment(str, false);
            }
            if (iIndexOf != -1) {
                String[] strArrSplit = str.split(",");
                int[] iArr = new int[strArrSplit.length];
                for (int i10 = 0; i10 < strArrSplit.length; i10++) {
                    iArr[i10] = Integer.parseInt(strArrSplit[i10]);
                }
                return new MultiIndexSegment(iArr);
            }
            if (iIndexOf2 == -1) {
                throw new UnsupportedOperationException();
            }
            String[] strArrSplit2 = str.split(":");
            int length2 = strArrSplit2.length;
            int[] iArr2 = new int[length2];
            for (int i11 = 0; i11 < strArrSplit2.length; i11++) {
                String str2 = strArrSplit2[i11];
                if (str2.length() != 0) {
                    iArr2[i11] = Integer.parseInt(str2);
                } else {
                    if (i11 != 0) {
                        throw new UnsupportedOperationException();
                    }
                    iArr2[i11] = 0;
                }
            }
            int i12 = iArr2[0];
            int i13 = length2 > 1 ? iArr2[1] : -1;
            int i14 = length2 == 3 ? iArr2[2] : 1;
            if (i13 >= 0 && i13 < i12) {
                throw new UnsupportedOperationException(AbstractC0004e.m19m(i12, i13, "end must greater than or equals start. start ", ",  end "));
            }
            if (i14 > 0) {
                return new RangeSegment(i12, i13, i14);
            }
            throw new UnsupportedOperationException(AbstractC0004e.m20n(i14, "step must greater than zero : "));
        }

        public Segment[] explain() {
            String str = this.path;
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException();
            }
            Segment[] segmentArr = new Segment[8];
            while (true) {
                Segment segement = readSegement();
                if (segement == null) {
                    break;
                }
                if (segement instanceof PropertySegment) {
                    PropertySegment propertySegment = (PropertySegment) segement;
                    if (propertySegment.deep || !propertySegment.propertyName.equals("*")) {
                    }
                }
                int i6 = this.level;
                if (i6 == segmentArr.length) {
                    Segment[] segmentArr2 = new Segment[(i6 * 3) / 2];
                    System.arraycopy(segmentArr, 0, segmentArr2, 0, i6);
                    segmentArr = segmentArr2;
                }
                int i10 = this.level;
                this.level = i10 + 1;
                segmentArr[i10] = segement;
            }
            int i11 = this.level;
            if (i11 == segmentArr.length) {
                return segmentArr;
            }
            Segment[] segmentArr3 = new Segment[i11];
            System.arraycopy(segmentArr, 0, segmentArr3, 0, i11);
            return segmentArr3;
        }

        public Filter filterRest(Filter filter) {
            char c5 = this.f4377ch;
            boolean z7 = true;
            boolean z10 = c5 == '&';
            if ((c5 != '&' || getNextChar() != '&') && (this.f4377ch != '|' || getNextChar() != '|')) {
                return filter;
            }
            next();
            next();
            if (this.f4377ch == '(') {
                next();
            } else {
                z7 = false;
            }
            while (this.f4377ch == ' ') {
                next();
            }
            FilterGroup filterGroup = new FilterGroup(filter, (Filter) parseArrayAccessFilter(false), z10);
            if (z7 && this.f4377ch == ')') {
                next();
            }
            return filterGroup;
        }

        public char getNextChar() {
            return this.path.charAt(this.pos);
        }

        public boolean isEOF() {
            return this.pos >= this.path.length();
        }

        public void next() {
            String str = this.path;
            int i6 = this.pos;
            this.pos = i6 + 1;
            this.f4377ch = str.charAt(i6);
        }

        public Segment parseArrayAccess(boolean z7) {
            Object arrayAccessFilter = parseArrayAccessFilter(z7);
            return arrayAccessFilter instanceof Segment ? (Segment) arrayAccessFilter : new FilterSegment((Filter) arrayAccessFilter);
        }

        public Object parseArrayAccessFilter(boolean z7) {
            int i6;
            boolean z10;
            boolean z11;
            char c5;
            char c8;
            char c10;
            char c11;
            char c12;
            char c13;
            String str;
            String[] strArr;
            String str2;
            String str3;
            Filter matchSegement;
            Filter stringOpSegement;
            char c14;
            char c15;
            char c16;
            char c17;
            int i10;
            char c18;
            char c19;
            char c20;
            char c21;
            char c22;
            int i11;
            String strReplaceAll;
            int i12;
            char cCharAt;
            char c23;
            if (z7) {
                accept('[');
            }
            if (this.f4377ch == '?') {
                next();
                accept('(');
                i6 = 1;
                while (this.f4377ch == '(') {
                    next();
                    i6++;
                }
                z10 = true;
            } else {
                i6 = 0;
                z10 = false;
            }
            skipWhitespace();
            if (!z10 && !IOUtils.firstIdentifier(this.f4377ch) && !Character.isJavaIdentifierStart(this.f4377ch) && (c21 = this.f4377ch) != '\\' && c21 != '@') {
                int i13 = this.pos - 1;
                while (true) {
                    char c24 = this.f4377ch;
                    if (c24 == ']' || c24 == '/' || isEOF() || !((c23 = this.f4377ch) != '.' || z10 || z10 || c21 == '\'')) {
                        break;
                    }
                    if (c23 == '\\') {
                        next();
                    }
                    next();
                }
                if (z7 || (c22 = this.f4377ch) == '/' || c22 == '.') {
                    int i14 = this.pos;
                    i11 = i14 - 1;
                } else {
                    i11 = this.pos;
                }
                String strSubstring = this.path.substring(i13, i11);
                if (strSubstring.indexOf(92) != 0) {
                    StringBuilder sb = new StringBuilder(strSubstring.length());
                    int i15 = 0;
                    while (i15 < strSubstring.length()) {
                        char cCharAt2 = strSubstring.charAt(i15);
                        if (cCharAt2 == '\\' && i15 < strSubstring.length() - 1 && ((cCharAt = strSubstring.charAt((i12 = i15 + 1))) == '@' || cCharAt2 == '\\' || cCharAt2 == '\"')) {
                            sb.append(cCharAt);
                            i15 = i12;
                        } else {
                            sb.append(cCharAt2);
                        }
                        i15++;
                    }
                    strSubstring = sb.toString();
                }
                if (strSubstring.indexOf("\\.") == -1) {
                    Segment segmentBuildArraySegement = buildArraySegement(strSubstring);
                    if (z7 && !isEOF()) {
                        accept(']');
                    }
                    return segmentBuildArraySegement;
                }
                if (c21 == '\'' && strSubstring.length() > 2 && strSubstring.charAt(strSubstring.length() - 1) == c21) {
                    strReplaceAll = strSubstring.substring(1, strSubstring.length() - 1);
                } else {
                    strReplaceAll = strSubstring.replaceAll("\\\\\\.", "\\.");
                    if (strReplaceAll.indexOf("\\-") != -1) {
                        strReplaceAll = strReplaceAll.replaceAll("\\\\-", "-");
                    }
                }
                if (z10) {
                    accept(')');
                }
                return new PropertySegment(strReplaceAll, false);
            }
            if (this.f4377ch == '@') {
                next();
                accept('.');
            }
            String name = readName();
            skipWhitespace();
            if (z10 && this.f4377ch == ')') {
                next();
                Filter notNullSegement = new NotNullSegement(name, false);
                while (true) {
                    c20 = this.f4377ch;
                    if (c20 != ' ') {
                        break;
                    }
                    next();
                }
                if (c20 == '&' || c20 == '|') {
                    notNullSegement = filterRest(notNullSegement);
                }
                if (z7) {
                    accept(']');
                }
                return notNullSegement;
            }
            if (z7 && this.f4377ch == ']') {
                if (isEOF() && name.equals("last")) {
                    return new MultiIndexSegment(new int[]{-1});
                }
                next();
                Filter notNullSegement2 = new NotNullSegement(name, false);
                while (true) {
                    c19 = this.f4377ch;
                    if (c19 != ' ') {
                        break;
                    }
                    next();
                }
                if (c19 == '&' || c19 == '|') {
                    notNullSegement2 = filterRest(notNullSegement2);
                }
                accept(')');
                if (z10) {
                    accept(')');
                }
                if (z7) {
                    accept(']');
                }
                return notNullSegement2;
            }
            skipWhitespace();
            if (this.f4377ch == '(') {
                next();
                accept(')');
                skipWhitespace();
                z11 = true;
            } else {
                z11 = false;
            }
            Operator op = readOp();
            skipWhitespace();
            if (op == Operator.BETWEEN || op == Operator.NOT_BETWEEN) {
                boolean z12 = op == Operator.NOT_BETWEEN;
                Object value = readValue();
                if (!"and".equalsIgnoreCase(readName())) {
                    throw new JSONPathException(this.path);
                }
                Object value2 = readValue();
                if (value == null || value2 == null) {
                    throw new JSONPathException(this.path);
                }
                if (JSONPath.isInt(value.getClass()) && JSONPath.isInt(value2.getClass())) {
                    return new IntBetweenSegement(name, z11, TypeUtils.longExtractValue((Number) value), TypeUtils.longExtractValue((Number) value2), z12);
                }
                throw new JSONPathException(this.path);
            }
            if (op == Operator.IN || op == Operator.NOT_IN) {
                boolean z13 = op == Operator.NOT_IN;
                accept('(');
                JSONArray jSONArray = new JSONArray();
                jSONArray.add(readValue());
                while (true) {
                    skipWhitespace();
                    if (this.f4377ch != ',') {
                        break;
                    }
                    next();
                    jSONArray.add(readValue());
                }
                boolean z14 = true;
                boolean z15 = true;
                boolean z16 = true;
                for (Object obj : jSONArray) {
                    if (obj != null) {
                        Class<?> cls = obj.getClass();
                        if (z14 && cls != Byte.class && cls != Short.class && cls != Integer.class && cls != Long.class) {
                            z14 = false;
                            z16 = false;
                        }
                        if (z15 && cls != String.class) {
                            z15 = false;
                        }
                    } else if (z14) {
                        z14 = false;
                    }
                }
                if (jSONArray.size() == 1 && jSONArray.get(0) == null) {
                    Filter notNullSegement3 = z13 ? new NotNullSegement(name, z11) : new NullSegement(name, z11);
                    while (true) {
                        c13 = this.f4377ch;
                        if (c13 != ' ') {
                            break;
                        }
                        next();
                    }
                    if (c13 == '&' || c13 == '|') {
                        notNullSegement3 = filterRest(notNullSegement3);
                    }
                    accept(')');
                    if (z10) {
                        accept(')');
                    }
                    if (z7) {
                        accept(']');
                    }
                    return notNullSegement3;
                }
                if (z14) {
                    if (jSONArray.size() == 1) {
                        Filter intOpSegement = new IntOpSegement(name, z11, TypeUtils.longExtractValue((Number) jSONArray.get(0)), z13 ? Operator.NE : Operator.EQ);
                        while (true) {
                            c12 = this.f4377ch;
                            if (c12 != ' ') {
                                break;
                            }
                            next();
                        }
                        if (c12 == '&' || c12 == '|') {
                            intOpSegement = filterRest(intOpSegement);
                        }
                        accept(')');
                        if (z10) {
                            accept(')');
                        }
                        if (z7) {
                            accept(']');
                        }
                        return intOpSegement;
                    }
                    int size = jSONArray.size();
                    long[] jArr = new long[size];
                    for (int i16 = 0; i16 < size; i16++) {
                        jArr[i16] = TypeUtils.longExtractValue((Number) jSONArray.get(i16));
                    }
                    Filter intInSegement = new IntInSegement(name, z11, jArr, z13);
                    while (true) {
                        c11 = this.f4377ch;
                        if (c11 != ' ') {
                            break;
                        }
                        next();
                    }
                    if (c11 == '&' || c11 == '|') {
                        intInSegement = filterRest(intInSegement);
                    }
                    accept(')');
                    if (z10) {
                        accept(')');
                    }
                    if (z7) {
                        accept(']');
                    }
                    return intInSegement;
                }
                if (!z15) {
                    if (!z16) {
                        throw new UnsupportedOperationException();
                    }
                    int size2 = jSONArray.size();
                    Long[] lArr = new Long[size2];
                    for (int i17 = 0; i17 < size2; i17++) {
                        Number number = (Number) jSONArray.get(i17);
                        if (number != null) {
                            lArr[i17] = Long.valueOf(TypeUtils.longExtractValue(number));
                        }
                    }
                    Filter intObjInSegement = new IntObjInSegement(name, z11, lArr, z13);
                    while (true) {
                        c5 = this.f4377ch;
                        if (c5 != ' ') {
                            break;
                        }
                        next();
                    }
                    if (c5 == '&' || c5 == '|') {
                        intObjInSegement = filterRest(intObjInSegement);
                    }
                    accept(')');
                    if (z10) {
                        accept(')');
                    }
                    if (z7) {
                        accept(']');
                    }
                    return intObjInSegement;
                }
                if (jSONArray.size() == 1) {
                    Filter stringOpSegement2 = new StringOpSegement(name, z11, (String) jSONArray.get(0), z13 ? Operator.NE : Operator.EQ);
                    while (true) {
                        c10 = this.f4377ch;
                        if (c10 != ' ') {
                            break;
                        }
                        next();
                    }
                    if (c10 == '&' || c10 == '|') {
                        stringOpSegement2 = filterRest(stringOpSegement2);
                    }
                    accept(')');
                    if (z10) {
                        accept(')');
                    }
                    if (z7) {
                        accept(']');
                    }
                    return stringOpSegement2;
                }
                String[] strArr2 = new String[jSONArray.size()];
                jSONArray.toArray(strArr2);
                Filter stringInSegement = new StringInSegement(name, z11, strArr2, z13);
                while (true) {
                    c8 = this.f4377ch;
                    if (c8 != ' ') {
                        break;
                    }
                    next();
                }
                if (c8 == '&' || c8 == '|') {
                    stringInSegement = filterRest(stringInSegement);
                }
                accept(')');
                if (z10) {
                    accept(')');
                }
                if (z7) {
                    accept(']');
                }
                return stringInSegement;
            }
            char c25 = this.f4377ch;
            if (c25 == '\'' || c25 == '\"') {
                String string = readString();
                if (op == Operator.RLIKE) {
                    matchSegement = new RlikeSegement(name, z11, string, false);
                } else {
                    if (op == Operator.NOT_RLIKE) {
                        stringOpSegement = new RlikeSegement(name, z11, string, true);
                    } else if (op == Operator.LIKE || op == Operator.NOT_LIKE) {
                        while (string.indexOf("%%") != -1) {
                            string = string.replaceAll("%%", "%");
                        }
                        boolean z17 = op == Operator.NOT_LIKE;
                        int iIndexOf = string.indexOf(37);
                        if (iIndexOf == -1) {
                            stringOpSegement = new StringOpSegement(name, z11, string, op == Operator.LIKE ? Operator.EQ : Operator.NE);
                        } else {
                            String[] strArrSplit = string.split("%");
                            if (iIndexOf != 0) {
                                if (string.charAt(string.length() - 1) == '%') {
                                    if (strArrSplit.length == 1) {
                                        str3 = strArrSplit[0];
                                    } else {
                                        strArr = strArrSplit;
                                        str = null;
                                        str2 = null;
                                    }
                                } else if (strArrSplit.length == 1) {
                                    str3 = strArrSplit[0];
                                } else if (strArrSplit.length == 2) {
                                    str = strArrSplit[0];
                                    str2 = strArrSplit[1];
                                    strArr = null;
                                } else {
                                    String str4 = strArrSplit[0];
                                    String str5 = strArrSplit[strArrSplit.length - 1];
                                    int length = strArrSplit.length - 2;
                                    String[] strArr3 = new String[length];
                                    System.arraycopy(strArrSplit, 1, strArr3, 0, length);
                                    str = str4;
                                    strArr = strArr3;
                                    str2 = str5;
                                }
                                str = str3;
                                str2 = null;
                                strArr = null;
                            } else if (string.charAt(string.length() - 1) == '%') {
                                int length2 = strArrSplit.length - 1;
                                String[] strArr4 = new String[length2];
                                System.arraycopy(strArrSplit, 1, strArr4, 0, length2);
                                strArr = strArr4;
                                str = null;
                                str2 = null;
                            } else {
                                String str6 = strArrSplit[strArrSplit.length - 1];
                                if (strArrSplit.length > 2) {
                                    int length3 = strArrSplit.length - 2;
                                    String[] strArr5 = new String[length3];
                                    System.arraycopy(strArrSplit, 1, strArr5, 0, length3);
                                    str2 = str6;
                                    strArr = strArr5;
                                    str = null;
                                } else {
                                    str2 = str6;
                                    str = null;
                                    strArr = null;
                                }
                            }
                            matchSegement = new MatchSegement(name, z11, str, str2, strArr, z17);
                        }
                    } else {
                        matchSegement = new StringOpSegement(name, z11, string, op);
                    }
                    matchSegement = stringOpSegement;
                }
                while (true) {
                    c14 = this.f4377ch;
                    if (c14 != ' ') {
                        break;
                    }
                    next();
                }
                if (c14 == '&' || c14 == '|') {
                    matchSegement = filterRest(matchSegement);
                }
                if (z10) {
                    accept(')');
                }
                if (z7) {
                    accept(']');
                }
                return matchSegement;
            }
            if (isDigitFirst(c25)) {
                long longValue = readLongValue();
                double doubleValue = this.f4377ch == '.' ? readDoubleValue(longValue) : 0.0d;
                Filter intOpSegement2 = doubleValue == 0.0d ? new IntOpSegement(name, z11, longValue, op) : new DoubleOpSegement(name, z11, doubleValue, op);
                while (true) {
                    c18 = this.f4377ch;
                    if (c18 != ' ') {
                        break;
                    }
                    next();
                }
                if (i6 > 1 && c18 == ')') {
                    next();
                }
                char c26 = this.f4377ch;
                if (c26 == '&' || c26 == '|') {
                    intOpSegement2 = filterRest(intOpSegement2);
                }
                if (z10) {
                    accept(')');
                }
                if (z7) {
                    accept(']');
                }
                return intOpSegement2;
            }
            char c27 = this.f4377ch;
            if (c27 == '$') {
                RefOpSegement refOpSegement = new RefOpSegement(name, z11, readSegement(), op);
                this.hasRefSegment = true;
                while (this.f4377ch == ' ') {
                    next();
                }
                if (z10) {
                    accept(')');
                }
                if (z7) {
                    accept(']');
                }
                return refOpSegement;
            }
            if (c27 == '/') {
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    next();
                    char c28 = this.f4377ch;
                    if (c28 == '/') {
                        break;
                    }
                    if (c28 == '\\') {
                        next();
                        sb2.append(this.f4377ch);
                    } else {
                        sb2.append(c28);
                    }
                }
                next();
                if (this.f4377ch == 'i') {
                    next();
                    i10 = 2;
                } else {
                    i10 = 0;
                }
                RegMatchSegement regMatchSegement = new RegMatchSegement(name, z11, Pattern.compile(sb2.toString(), i10), op);
                if (z10) {
                    accept(')');
                }
                if (z7) {
                    accept(']');
                }
                return regMatchSegement;
            }
            if (c27 == 'n') {
                if ("null".equals(readName())) {
                    Filter nullSegement = op == Operator.EQ ? new NullSegement(name, z11) : op == Operator.NE ? new NotNullSegement(name, z11) : null;
                    if (nullSegement != null) {
                        while (true) {
                            c17 = this.f4377ch;
                            if (c17 != ' ') {
                                break;
                            }
                            next();
                        }
                        if (c17 == '&' || c17 == '|') {
                            nullSegement = filterRest(nullSegement);
                        }
                    }
                    if (z10) {
                        accept(')');
                    }
                    accept(']');
                    if (nullSegement != null) {
                        return nullSegement;
                    }
                    throw new UnsupportedOperationException();
                }
            } else if (c27 == 't') {
                if ("true".equals(readName())) {
                    Filter valueSegment = op == Operator.EQ ? new ValueSegment(name, z11, Boolean.TRUE, true) : op == Operator.NE ? new ValueSegment(name, z11, Boolean.TRUE, false) : null;
                    if (valueSegment != null) {
                        while (true) {
                            c16 = this.f4377ch;
                            if (c16 != ' ') {
                                break;
                            }
                            next();
                        }
                        if (c16 == '&' || c16 == '|') {
                            valueSegment = filterRest(valueSegment);
                        }
                    }
                    if (z10) {
                        accept(')');
                    }
                    accept(']');
                    if (valueSegment != null) {
                        return valueSegment;
                    }
                    throw new UnsupportedOperationException();
                }
            } else if (c27 == 'f' && "false".equals(readName())) {
                Filter valueSegment2 = op == Operator.EQ ? new ValueSegment(name, z11, Boolean.FALSE, true) : op == Operator.NE ? new ValueSegment(name, z11, Boolean.FALSE, false) : null;
                if (valueSegment2 != null) {
                    while (true) {
                        c15 = this.f4377ch;
                        if (c15 != ' ') {
                            break;
                        }
                        next();
                    }
                    if (c15 == '&' || c15 == '|') {
                        valueSegment2 = filterRest(valueSegment2);
                    }
                }
                if (z10) {
                    accept(')');
                }
                accept(']');
                if (valueSegment2 != null) {
                    return valueSegment2;
                }
                throw new UnsupportedOperationException();
            }
            throw new UnsupportedOperationException();
        }

        public double readDoubleValue(long j10) {
            int i6 = this.pos - 1;
            next();
            while (true) {
                char c5 = this.f4377ch;
                if (c5 < '0' || c5 > '9') {
                    break;
                }
                next();
            }
            return Double.parseDouble(this.path.substring(i6, this.pos - 1)) + j10;
        }

        public long readLongValue() {
            int i6 = this.pos - 1;
            char c5 = this.f4377ch;
            if (c5 == '+' || c5 == '-') {
                next();
            }
            while (true) {
                char c8 = this.f4377ch;
                if (c8 < '0' || c8 > '9') {
                    break;
                }
                next();
            }
            return Long.parseLong(this.path.substring(i6, this.pos - 1));
        }

        public String readName() {
            skipWhitespace();
            char c5 = this.f4377ch;
            if (c5 != '\\' && !Character.isJavaIdentifierStart(c5)) {
                throw new JSONPathException("illeal jsonpath syntax. " + this.path);
            }
            StringBuilder sb = new StringBuilder();
            while (!isEOF()) {
                char c8 = this.f4377ch;
                if (c8 == '\\') {
                    next();
                    sb.append(this.f4377ch);
                    if (isEOF()) {
                        return sb.toString();
                    }
                    next();
                } else {
                    if (!Character.isJavaIdentifierPart(c8)) {
                        break;
                    }
                    sb.append(this.f4377ch);
                    next();
                }
            }
            if (isEOF() && Character.isJavaIdentifierPart(this.f4377ch)) {
                sb.append(this.f4377ch);
            }
            return sb.toString();
        }

        public Operator readOp() {
            Operator operator;
            char c5 = this.f4377ch;
            if (c5 == '=') {
                next();
                char c8 = this.f4377ch;
                if (c8 == '~') {
                    next();
                    operator = Operator.REG_MATCH;
                } else if (c8 == '=') {
                    next();
                    operator = Operator.EQ;
                } else {
                    operator = Operator.EQ;
                }
            } else if (c5 == '!') {
                next();
                accept('=');
                operator = Operator.NE;
            } else if (c5 == '<') {
                next();
                if (this.f4377ch == '=') {
                    next();
                    operator = Operator.LE;
                } else {
                    operator = Operator.LT;
                }
            } else if (c5 == '>') {
                next();
                if (this.f4377ch == '=') {
                    next();
                    operator = Operator.GE;
                } else {
                    operator = Operator.GT;
                }
            } else {
                operator = null;
            }
            if (operator != null) {
                return operator;
            }
            String name = readName();
            if ("not".equalsIgnoreCase(name)) {
                skipWhitespace();
                String name2 = readName();
                if ("like".equalsIgnoreCase(name2)) {
                    return Operator.NOT_LIKE;
                }
                if ("rlike".equalsIgnoreCase(name2)) {
                    return Operator.NOT_RLIKE;
                }
                if ("in".equalsIgnoreCase(name2)) {
                    return Operator.NOT_IN;
                }
                if ("between".equalsIgnoreCase(name2)) {
                    return Operator.NOT_BETWEEN;
                }
                throw new UnsupportedOperationException();
            }
            if ("nin".equalsIgnoreCase(name)) {
                return Operator.NOT_IN;
            }
            if ("like".equalsIgnoreCase(name)) {
                return Operator.LIKE;
            }
            if ("rlike".equalsIgnoreCase(name)) {
                return Operator.RLIKE;
            }
            if ("in".equalsIgnoreCase(name)) {
                return Operator.IN;
            }
            if ("between".equalsIgnoreCase(name)) {
                return Operator.BETWEEN;
            }
            throw new UnsupportedOperationException();
        }

        public Segment readSegement() {
            boolean z7;
            if (this.level == 0 && this.path.length() == 1) {
                if (isDigitFirst(this.f4377ch)) {
                    return new ArrayAccessSegment(this.f4377ch - '0');
                }
                char c5 = this.f4377ch;
                if ((c5 >= 'a' && c5 <= 'z') || (c5 >= 'A' && c5 <= 'Z')) {
                    return new PropertySegment(Character.toString(c5), false);
                }
            }
            while (!isEOF()) {
                skipWhitespace();
                char c8 = this.f4377ch;
                if (c8 != '$') {
                    if (c8 != '.' && c8 != '/') {
                        if (c8 == '[') {
                            return parseArrayAccess(true);
                        }
                        if (this.level == 0) {
                            return new PropertySegment(readName(), false);
                        }
                        if (c8 == '?') {
                            return new FilterSegment((Filter) parseArrayAccessFilter(false));
                        }
                        throw new JSONPathException("not support jsonpath : " + this.path);
                    }
                    next();
                    if (c8 == '.' && this.f4377ch == '.') {
                        next();
                        int length = this.path.length();
                        int i6 = this.pos;
                        if (length > i6 + 3 && this.f4377ch == '[' && this.path.charAt(i6) == '*' && this.path.charAt(this.pos + 1) == ']' && this.path.charAt(this.pos + 2) == '.') {
                            next();
                            next();
                            next();
                            next();
                        }
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    char c10 = this.f4377ch;
                    if (c10 == '*' || (z7 && c10 == '[')) {
                        boolean z10 = c10 == '[';
                        if (!isEOF()) {
                            next();
                        }
                        if (z7) {
                            return z10 ? WildCardSegment.instance_deep_objectOnly : WildCardSegment.instance_deep;
                        }
                        return WildCardSegment.instance;
                    }
                    if (isDigitFirst(c10)) {
                        return parseArrayAccess(false);
                    }
                    String name = readName();
                    if (this.f4377ch != '(') {
                        return new PropertySegment(name, z7);
                    }
                    next();
                    if (this.f4377ch != ')') {
                        throw new JSONPathException("not support jsonpath : " + this.path);
                    }
                    if (!isEOF()) {
                        next();
                    }
                    if ("size".equals(name) || SessionDescription.ATTR_LENGTH.equals(name)) {
                        return SizeSegment.instance;
                    }
                    if ("max".equals(name)) {
                        return MaxSegment.instance;
                    }
                    if ("min".equals(name)) {
                        return MinSegment.instance;
                    }
                    if ("keySet".equals(name)) {
                        return KeySetSegment.instance;
                    }
                    if (SessionDescription.ATTR_TYPE.equals(name)) {
                        return TypeSegment.instance;
                    }
                    if ("floor".equals(name)) {
                        return FloorSegment.instance;
                    }
                    throw new JSONPathException("not support jsonpath : " + this.path);
                }
                next();
                skipWhitespace();
                if (this.f4377ch == '?') {
                    return new FilterSegment((Filter) parseArrayAccessFilter(false));
                }
            }
            return null;
        }

        public String readString() {
            char c5 = this.f4377ch;
            next();
            int i6 = this.pos - 1;
            while (this.f4377ch != c5 && !isEOF()) {
                next();
            }
            String strSubstring = this.path.substring(i6, isEOF() ? this.pos : this.pos - 1);
            accept(c5);
            return strSubstring;
        }

        public Object readValue() {
            skipWhitespace();
            if (isDigitFirst(this.f4377ch)) {
                return Long.valueOf(readLongValue());
            }
            char c5 = this.f4377ch;
            if (c5 == '\"' || c5 == '\'') {
                return readString();
            }
            if (c5 != 'n') {
                throw new UnsupportedOperationException();
            }
            if ("null".equals(readName())) {
                return null;
            }
            throw new JSONPathException(this.path);
        }

        public final void skipWhitespace() {
            while (true) {
                char c5 = this.f4377ch;
                if (c5 > ' ') {
                    return;
                }
                if (c5 != ' ' && c5 != '\r' && c5 != '\n' && c5 != '\t' && c5 != '\f' && c5 != '\b') {
                    return;
                } else {
                    next();
                }
            }
        }
    }

    public static class KeySetSegment implements Segment {
        public static final KeySetSegment instance = new KeySetSegment();

        @Override
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.evalKeySet(obj2);
        }

        @Override
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }
    }

    public static class MatchSegement extends PropertyFilter {
        private final String[] containsValues;
        private final String endsWithValue;
        private final int minLength;
        private final boolean not;
        private final String startsWithValue;

        public MatchSegement(String str, boolean z7, String str2, String str3, String[] strArr, boolean z10) {
            super(str, z7);
            this.startsWithValue = str2;
            this.endsWithValue = str3;
            this.containsValues = strArr;
            this.not = z10;
            int length = str2 != null ? str2.length() : 0;
            length = str3 != null ? length + str3.length() : length;
            if (strArr != null) {
                for (String str4 : strArr) {
                    length += str4.length();
                }
            }
            this.minLength = length;
        }

        @Override
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            int length;
            Object obj4 = get(jSONPath, obj, obj3);
            if (obj4 == null) {
                return false;
            }
            String string = obj4.toString();
            if (string.length() < this.minLength) {
                return this.not;
            }
            String str = this.startsWithValue;
            if (str == null) {
                length = 0;
            } else {
                if (!string.startsWith(str)) {
                    return this.not;
                }
                length = this.startsWithValue.length();
            }
            String[] strArr = this.containsValues;
            if (strArr != null) {
                for (String str2 : strArr) {
                    int iIndexOf = string.indexOf(str2, length);
                    if (iIndexOf == -1) {
                        return this.not;
                    }
                    length = iIndexOf + str2.length();
                }
            }
            String str3 = this.endsWithValue;
            return (str3 == null || string.endsWith(str3)) ? !this.not : this.not;
        }
    }

    public static class MaxSegment implements Segment {
        public static final MaxSegment instance = new MaxSegment();

        @Override
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (!(obj2 instanceof Collection)) {
                throw new UnsupportedOperationException();
            }
            Object obj3 = null;
            for (Object obj4 : (Collection) obj2) {
                if (obj4 != null && (obj3 == null || JSONPath.compare(obj3, obj4) < 0)) {
                    obj3 = obj4;
                }
            }
            return obj3;
        }

        @Override
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }
    }

    public static class MinSegment implements Segment {
        public static final MinSegment instance = new MinSegment();

        @Override
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (!(obj2 instanceof Collection)) {
                throw new UnsupportedOperationException();
            }
            Object obj3 = null;
            for (Object obj4 : (Collection) obj2) {
                if (obj4 != null && (obj3 == null || JSONPath.compare(obj3, obj4) > 0)) {
                    obj3 = obj4;
                }
            }
            return obj3;
        }

        @Override
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }
    }

    public static class MultiIndexSegment implements Segment {
        private final int[] indexes;

        public MultiIndexSegment(int[] iArr) {
            this.indexes = iArr;
        }

        @Override
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            JSONArray jSONArray = new JSONArray(this.indexes.length);
            int i6 = 0;
            while (true) {
                int[] iArr = this.indexes;
                if (i6 >= iArr.length) {
                    return jSONArray;
                }
                jSONArray.add(jSONPath.getArrayItem(obj2, iArr[i6]));
                i6++;
            }
        }

        @Override
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            if (context.eval) {
                Object obj = defaultJSONParser.parse();
                if (obj instanceof List) {
                    int[] iArr = this.indexes;
                    int length = iArr.length;
                    int[] iArr2 = new int[length];
                    System.arraycopy(iArr, 0, iArr2, 0, length);
                    List list = (List) obj;
                    if (iArr2[0] >= 0) {
                        for (int size = list.size() - 1; size >= 0; size--) {
                            if (Arrays.binarySearch(iArr2, size) < 0) {
                                list.remove(size);
                            }
                        }
                        context.object = list;
                        return;
                    }
                }
            }
            throw new UnsupportedOperationException();
        }
    }

    public static class MultiPropertySegment implements Segment {
        private final String[] propertyNames;
        private final long[] propertyNamesHash;

        public MultiPropertySegment(String[] strArr) {
            this.propertyNames = strArr;
            this.propertyNamesHash = new long[strArr.length];
            int i6 = 0;
            while (true) {
                long[] jArr = this.propertyNamesHash;
                if (i6 >= jArr.length) {
                    return;
                }
                jArr[i6] = TypeUtils.fnv1a_64(strArr[i6]);
                i6++;
            }
        }

        @Override
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            ArrayList arrayList = new ArrayList(this.propertyNames.length);
            int i6 = 0;
            while (true) {
                String[] strArr = this.propertyNames;
                if (i6 >= strArr.length) {
                    return arrayList;
                }
                arrayList.add(jSONPath.getPropertyValue(obj2, strArr[i6], this.propertyNamesHash[i6]));
                i6++;
            }
        }

        @Override
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            JSONArray jSONArray;
            Object objIntegerValue;
            JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
            Object obj = context.object;
            if (obj == null) {
                jSONArray = new JSONArray();
                context.object = jSONArray;
            } else {
                jSONArray = (JSONArray) obj;
            }
            for (int size = jSONArray.size(); size < this.propertyNamesHash.length; size++) {
                jSONArray.add(null);
            }
            do {
                int iSeekObjectToField = jSONLexerBase.seekObjectToField(this.propertyNamesHash);
                if (jSONLexerBase.matchStat != 3) {
                    return;
                }
                int i6 = jSONLexerBase.token();
                if (i6 == 2) {
                    objIntegerValue = jSONLexerBase.integerValue();
                    jSONLexerBase.nextToken(16);
                } else if (i6 == 3) {
                    objIntegerValue = jSONLexerBase.decimalValue();
                    jSONLexerBase.nextToken(16);
                } else if (i6 != 4) {
                    objIntegerValue = defaultJSONParser.parse();
                } else {
                    objIntegerValue = jSONLexerBase.stringVal();
                    jSONLexerBase.nextToken(16);
                }
                jSONArray.set(iSeekObjectToField, objIntegerValue);
            } while (jSONLexerBase.token() == 16);
        }
    }

    public static class NotNullSegement extends PropertyFilter {
        public NotNullSegement(String str, boolean z7) {
            super(str, z7);
        }

        @Override
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            return jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash) != null;
        }
    }

    public static class NullSegement extends PropertyFilter {
        public NullSegement(String str, boolean z7) {
            super(str, z7);
        }

        @Override
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            return get(jSONPath, obj, obj3) == null;
        }
    }

    public enum Operator {
        EQ,
        NE,
        GT,
        GE,
        LT,
        LE,
        LIKE,
        NOT_LIKE,
        RLIKE,
        NOT_RLIKE,
        IN,
        NOT_IN,
        BETWEEN,
        NOT_BETWEEN,
        And,
        Or,
        REG_MATCH
    }

    public static abstract class PropertyFilter implements Filter {
        static long TYPE = TypeUtils.fnv1a_64(SessionDescription.ATTR_TYPE);
        protected final boolean function;
        protected Segment functionExpr;
        protected final String propertyName;
        protected final long propertyNameHash;

        public PropertyFilter(String str, boolean z7) {
            this.propertyName = str;
            long jFnv1a_64 = TypeUtils.fnv1a_64(str);
            this.propertyNameHash = jFnv1a_64;
            this.function = z7;
            if (z7) {
                if (jFnv1a_64 == TYPE) {
                    this.functionExpr = TypeSegment.instance;
                } else {
                    if (jFnv1a_64 != JSONPath.SIZE) {
                        throw new JSONPathException(AbstractC2460q.m5501o("unsupported funciton : ", str));
                    }
                    this.functionExpr = SizeSegment.instance;
                }
            }
        }

        public Object get(JSONPath jSONPath, Object obj, Object obj2) {
            Segment segment = this.functionExpr;
            return segment != null ? segment.eval(jSONPath, obj, obj2) : jSONPath.getPropertyValue(obj2, this.propertyName, this.propertyNameHash);
        }
    }

    public static class PropertySegment implements Segment {
        private final boolean deep;
        private final String propertyName;
        private final long propertyNameHash;

        public PropertySegment(String str, boolean z7) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.deep = z7;
        }

        @Override
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (!this.deep) {
                return jSONPath.getPropertyValue(obj2, this.propertyName, this.propertyNameHash);
            }
            ArrayList arrayList = new ArrayList();
            jSONPath.deepScan(obj2, this.propertyName, arrayList);
            return arrayList;
        }

        @Override
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            Object objIntegerValue;
            Object objIntegerValue2;
            Object objIntegerValue3;
            JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
            if (this.deep && context.object == null) {
                context.object = new JSONArray();
            }
            if (jSONLexerBase.token() != 14) {
                boolean z7 = this.deep;
                if (!z7) {
                    if (jSONLexerBase.seekObjectToField(this.propertyNameHash, z7) == 3 && context.eval) {
                        int i6 = jSONLexerBase.token();
                        if (i6 == 2) {
                            objIntegerValue2 = jSONLexerBase.integerValue();
                            jSONLexerBase.nextToken(16);
                        } else if (i6 == 3) {
                            objIntegerValue2 = jSONLexerBase.decimalValue();
                            jSONLexerBase.nextToken(16);
                        } else if (i6 != 4) {
                            objIntegerValue2 = defaultJSONParser.parse();
                        } else {
                            objIntegerValue2 = jSONLexerBase.stringVal();
                            jSONLexerBase.nextToken(16);
                        }
                        if (context.eval) {
                            context.object = objIntegerValue2;
                            return;
                        }
                        return;
                    }
                    return;
                }
                while (true) {
                    int iSeekObjectToField = jSONLexerBase.seekObjectToField(this.propertyNameHash, this.deep);
                    if (iSeekObjectToField == -1) {
                        return;
                    }
                    if (iSeekObjectToField == 3) {
                        if (context.eval) {
                            int i10 = jSONLexerBase.token();
                            if (i10 == 2) {
                                objIntegerValue = jSONLexerBase.integerValue();
                                jSONLexerBase.nextToken(16);
                            } else if (i10 == 3) {
                                objIntegerValue = jSONLexerBase.decimalValue();
                                jSONLexerBase.nextToken(16);
                            } else if (i10 != 4) {
                                objIntegerValue = defaultJSONParser.parse();
                            } else {
                                objIntegerValue = jSONLexerBase.stringVal();
                                jSONLexerBase.nextToken(16);
                            }
                            if (context.eval) {
                                Object obj = context.object;
                                if (obj instanceof List) {
                                    List list = (List) obj;
                                    if (list.size() == 0 && (objIntegerValue instanceof List)) {
                                        context.object = objIntegerValue;
                                    } else {
                                        list.add(objIntegerValue);
                                    }
                                } else {
                                    context.object = objIntegerValue;
                                }
                            }
                        }
                    } else if (iSeekObjectToField == 1 || iSeekObjectToField == 2) {
                        extract(jSONPath, defaultJSONParser, context);
                    }
                }
            } else {
                if ("*".equals(this.propertyName)) {
                    return;
                }
                jSONLexerBase.nextToken();
                JSONArray jSONArray = this.deep ? (JSONArray) context.object : new JSONArray();
                while (true) {
                    int i11 = jSONLexerBase.token();
                    if (i11 == 12) {
                        boolean z10 = this.deep;
                        if (z10) {
                            extract(jSONPath, defaultJSONParser, context);
                        } else {
                            int iSeekObjectToField2 = jSONLexerBase.seekObjectToField(this.propertyNameHash, z10);
                            if (iSeekObjectToField2 == 3) {
                                int i12 = jSONLexerBase.token();
                                if (i12 == 2) {
                                    objIntegerValue3 = jSONLexerBase.integerValue();
                                    jSONLexerBase.nextToken();
                                } else if (i12 != 4) {
                                    objIntegerValue3 = defaultJSONParser.parse();
                                } else {
                                    objIntegerValue3 = jSONLexerBase.stringVal();
                                    jSONLexerBase.nextToken();
                                }
                                jSONArray.add(objIntegerValue3);
                                if (jSONLexerBase.token() == 13) {
                                    jSONLexerBase.nextToken();
                                } else {
                                    jSONLexerBase.skipObject(false);
                                }
                            } else if (iSeekObjectToField2 == -1) {
                                continue;
                            } else {
                                if (this.deep) {
                                    throw new UnsupportedOperationException(jSONLexerBase.info());
                                }
                                jSONLexerBase.skipObject(false);
                            }
                        }
                    } else if (i11 != 14) {
                        switch (i11) {
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                jSONLexerBase.nextToken();
                                break;
                        }
                    } else if (this.deep) {
                        extract(jSONPath, defaultJSONParser, context);
                    } else {
                        jSONLexerBase.skipObject(false);
                    }
                    if (jSONLexerBase.token() == 15) {
                        jSONLexerBase.nextToken();
                        if (this.deep || jSONArray.size() <= 0) {
                            return;
                        }
                        context.object = jSONArray;
                        return;
                    }
                    if (jSONLexerBase.token() != 16) {
                        throw new JSONException("illegal json : " + jSONLexerBase.info());
                    }
                    jSONLexerBase.nextToken();
                }
            }
        }

        public boolean remove(JSONPath jSONPath, Object obj) {
            return jSONPath.removePropertyValue(obj, this.propertyName, this.deep);
        }

        public void setValue(JSONPath jSONPath, Object obj, Object obj2) {
            if (this.deep) {
                jSONPath.deepSet(obj, this.propertyName, this.propertyNameHash, obj2);
            } else {
                jSONPath.setPropertyValue(obj, this.propertyName, this.propertyNameHash, obj2);
            }
        }
    }

    public static class RangeSegment implements Segment {
        private final int end;
        private final int start;
        private final int step;

        public RangeSegment(int i6, int i10, int i11) {
            this.start = i6;
            this.end = i10;
            this.step = i11;
        }

        @Override
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            int iIntValue = SizeSegment.instance.eval(jSONPath, obj, obj2).intValue();
            int i6 = this.start;
            if (i6 < 0) {
                i6 += iIntValue;
            }
            int i10 = this.end;
            if (i10 < 0) {
                i10 += iIntValue;
            }
            int i11 = ((i10 - i6) / this.step) + 1;
            if (i11 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i11);
            while (i6 <= i10 && i6 < iIntValue) {
                arrayList.add(jSONPath.getArrayItem(obj2, i6));
                i6 += this.step;
            }
            return arrayList;
        }

        @Override
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }
    }

    public static class RefOpSegement extends PropertyFilter {

        private final Operator f4386op;
        private final Segment refSgement;

        public RefOpSegement(String str, boolean z7, Segment segment, Operator operator) {
            super(str, z7);
            this.refSgement = segment;
            this.f4386op = operator;
        }

        @Override
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object obj4 = get(jSONPath, obj, obj3);
            if (obj4 == null || !(obj4 instanceof Number)) {
                return false;
            }
            Object objEval = this.refSgement.eval(jSONPath, obj, obj);
            if ((objEval instanceof Integer) || (objEval instanceof Long) || (objEval instanceof Short) || (objEval instanceof Byte)) {
                long jLongExtractValue = TypeUtils.longExtractValue((Number) objEval);
                if ((obj4 instanceof Integer) || (obj4 instanceof Long) || (obj4 instanceof Short) || (obj4 instanceof Byte)) {
                    long jLongExtractValue2 = TypeUtils.longExtractValue((Number) obj4);
                    switch (C14421.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.f4386op.ordinal()]) {
                        case 1:
                            return jLongExtractValue2 == jLongExtractValue;
                        case 2:
                            return jLongExtractValue2 != jLongExtractValue;
                        case 3:
                            return jLongExtractValue2 >= jLongExtractValue;
                        case 4:
                            return jLongExtractValue2 > jLongExtractValue;
                        case 5:
                            return jLongExtractValue2 <= jLongExtractValue;
                        case 6:
                            return jLongExtractValue2 < jLongExtractValue;
                    }
                }
                if (obj4 instanceof BigDecimal) {
                    int iCompareTo = BigDecimal.valueOf(jLongExtractValue).compareTo((BigDecimal) obj4);
                    switch (C14421.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.f4386op.ordinal()]) {
                        case 1:
                            return iCompareTo == 0;
                        case 2:
                            return iCompareTo != 0;
                        case 3:
                            return iCompareTo <= 0;
                        case 4:
                            return iCompareTo < 0;
                        case 5:
                            return iCompareTo >= 0;
                        case 6:
                            return iCompareTo > 0;
                        default:
                            return false;
                    }
                }
            }
            throw new UnsupportedOperationException();
        }
    }

    public static class RegMatchSegement extends PropertyFilter {

        private final Operator f4387op;
        private final Pattern pattern;

        public RegMatchSegement(String str, boolean z7, Pattern pattern, Operator operator) {
            super(str, z7);
            this.pattern = pattern;
            this.f4387op = operator;
        }

        @Override
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object obj4 = get(jSONPath, obj, obj3);
            if (obj4 == null) {
                return false;
            }
            return this.pattern.matcher(obj4.toString()).matches();
        }
    }

    public static class RlikeSegement extends PropertyFilter {
        private final boolean not;
        private final Pattern pattern;

        public RlikeSegement(String str, boolean z7, String str2, boolean z10) {
            super(str, z7);
            this.pattern = Pattern.compile(str2);
            this.not = z10;
        }

        @Override
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object obj4 = get(jSONPath, obj, obj3);
            if (obj4 == null) {
                return false;
            }
            boolean zMatches = this.pattern.matcher(obj4.toString()).matches();
            return this.not ? !zMatches : zMatches;
        }
    }

    public interface Segment {
        Object eval(JSONPath jSONPath, Object obj, Object obj2);

        void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context);
    }

    public static class SizeSegment implements Segment {
        public static final SizeSegment instance = new SizeSegment();

        @Override
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            context.object = Integer.valueOf(jSONPath.evalSize(defaultJSONParser.parse()));
        }

        @Override
        public Integer eval(JSONPath jSONPath, Object obj, Object obj2) {
            return Integer.valueOf(jSONPath.evalSize(obj2));
        }
    }

    public static class StringInSegement extends PropertyFilter {
        private final boolean not;
        private final String[] values;

        public StringInSegement(String str, boolean z7, String[] strArr, boolean z10) {
            super(str, z7);
            this.values = strArr;
            this.not = z10;
        }

        @Override
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object obj4 = get(jSONPath, obj, obj3);
            for (String str : this.values) {
                if (str == obj4) {
                    return !this.not;
                }
                if (str != null && str.equals(obj4)) {
                    return !this.not;
                }
            }
            return this.not;
        }
    }

    public static class StringOpSegement extends PropertyFilter {

        private final Operator f4388op;
        private final String value;

        public StringOpSegement(String str, boolean z7, String str2, Operator operator) {
            super(str, z7);
            this.value = str2;
            this.f4388op = operator;
        }

        @Override
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object obj4 = get(jSONPath, obj, obj3);
            Operator operator = this.f4388op;
            if (operator == Operator.EQ) {
                return this.value.equals(obj4);
            }
            if (operator == Operator.NE) {
                return !this.value.equals(obj4);
            }
            if (obj4 == null) {
                return false;
            }
            int iCompareTo = this.value.compareTo(obj4.toString());
            Operator operator2 = this.f4388op;
            if (operator2 == Operator.GE) {
                return iCompareTo <= 0;
            }
            if (operator2 == Operator.GT) {
                return iCompareTo < 0;
            }
            if (operator2 == Operator.LE) {
                return iCompareTo >= 0;
            }
            return operator2 == Operator.LT && iCompareTo > 0;
        }
    }

    public static class TypeSegment implements Segment {
        public static final TypeSegment instance = new TypeSegment();

        @Override
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }

        @Override
        public String eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (obj2 == null) {
                return "null";
            }
            if (obj2 instanceof Collection) {
                return "array";
            }
            if (obj2 instanceof Number) {
                return "number";
            }
            if (obj2 instanceof Boolean) {
                return "boolean";
            }
            return ((obj2 instanceof String) || (obj2 instanceof UUID) || (obj2 instanceof Enum)) ? "string" : "object";
        }
    }

    public static class ValueSegment extends PropertyFilter {

        private boolean f4389eq;
        private final Object value;

        public ValueSegment(String str, boolean z7, Object obj, boolean z10) {
            super(str, z7);
            this.f4389eq = true;
            if (obj == null) {
                throw new IllegalArgumentException("value is null");
            }
            this.value = obj;
            this.f4389eq = z10;
        }

        @Override
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            boolean zEquals = this.value.equals(get(jSONPath, obj, obj3));
            return !this.f4389eq ? !zEquals : zEquals;
        }
    }

    public static class WildCardSegment implements Segment {
        public static final WildCardSegment instance = new WildCardSegment(false, false);
        public static final WildCardSegment instance_deep = new WildCardSegment(true, false);
        public static final WildCardSegment instance_deep_objectOnly = new WildCardSegment(true, true);
        private boolean deep;
        private boolean objectOnly;

        private WildCardSegment(boolean z7, boolean z10) {
            this.deep = z7;
            this.objectOnly = z10;
        }

        @Override
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (!this.deep) {
                return jSONPath.getPropertyValues(obj2);
            }
            ArrayList arrayList = new ArrayList();
            jSONPath.deepGetPropertyValues(obj2, arrayList);
            return arrayList;
        }

        @Override
        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            if (context.eval) {
                Object obj = defaultJSONParser.parse();
                if (this.deep) {
                    ArrayList arrayList = new ArrayList();
                    if (this.objectOnly) {
                        jSONPath.deepGetObjects(obj, arrayList);
                    } else {
                        jSONPath.deepGetPropertyValues(obj, arrayList);
                    }
                    context.object = arrayList;
                    return;
                }
                if (obj instanceof JSONObject) {
                    Collection<?> collectionValues = ((JSONObject) obj).values();
                    JSONArray jSONArray = new JSONArray(collectionValues.size());
                    jSONArray.addAll(collectionValues);
                    context.object = jSONArray;
                    return;
                }
                if (obj instanceof JSONArray) {
                    context.object = obj;
                    return;
                }
            }
            throw new JSONException("TODO");
        }
    }

    public JSONPath(String str) {
        this(str, SerializeConfig.getGlobalInstance(), ParserConfig.getGlobalInstance(), true);
    }

    public static int compare(Object obj, Object obj2) {
        Object d;
        Object f;
        if (obj.getClass() == obj2.getClass()) {
            return ((Comparable) obj).compareTo(obj2);
        }
        Class<?> cls = obj.getClass();
        Class<?> cls2 = obj2.getClass();
        if (cls == BigDecimal.class) {
            if (cls2 == Integer.class) {
                f = new BigDecimal(((Integer) obj2).intValue());
            } else if (cls2 == Long.class) {
                f = new BigDecimal(((Long) obj2).longValue());
            } else if (cls2 == Float.class) {
                f = new BigDecimal(((Float) obj2).floatValue());
            } else if (cls2 == Double.class) {
                f = new BigDecimal(((Double) obj2).doubleValue());
            }
            obj2 = f;
        } else if (cls == Long.class) {
            if (cls2 == Integer.class) {
                f = new Long(((Integer) obj2).intValue());
                obj2 = f;
            } else {
                if (cls2 == BigDecimal.class) {
                    d = new BigDecimal(((Long) obj).longValue());
                } else if (cls2 == Float.class) {
                    d = new Float(((Long) obj).longValue());
                } else if (cls2 == Double.class) {
                    d = new Double(((Long) obj).longValue());
                }
                obj = d;
            }
        } else if (cls == Integer.class) {
            if (cls2 == Long.class) {
                d = new Long(((Integer) obj).intValue());
            } else if (cls2 == BigDecimal.class) {
                d = new BigDecimal(((Integer) obj).intValue());
            } else if (cls2 == Float.class) {
                d = new Float(((Integer) obj).intValue());
            } else if (cls2 == Double.class) {
                d = new Double(((Integer) obj).intValue());
            }
            obj = d;
        } else if (cls == Double.class) {
            if (cls2 == Integer.class) {
                f = new Double(((Integer) obj2).intValue());
            } else if (cls2 == Long.class) {
                f = new Double(((Long) obj2).longValue());
            } else if (cls2 == Float.class) {
                f = new Double(((Float) obj2).floatValue());
            }
            obj2 = f;
        } else if (cls == Float.class) {
            if (cls2 == Integer.class) {
                f = new Float(((Integer) obj2).intValue());
            } else if (cls2 == Long.class) {
                f = new Float(((Long) obj2).longValue());
            } else if (cls2 == Double.class) {
                d = new Double(((Float) obj).floatValue());
                obj = d;
            }
            obj2 = f;
        }
        return ((Comparable) obj).compareTo(obj2);
    }

    public static JSONPath compile(String str) {
        if (str == null) {
            throw new JSONPathException("jsonpath can not be null");
        }
        JSONPath jSONPath = pathCache.get(str);
        if (jSONPath != null) {
            return jSONPath;
        }
        JSONPath jSONPath2 = new JSONPath(str);
        if (pathCache.size() >= 1024) {
            return jSONPath2;
        }
        pathCache.putIfAbsent(str, jSONPath2);
        return pathCache.get(str);
    }

    public static boolean m3338eq(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        if (obj.getClass() == obj2.getClass()) {
            return obj.equals(obj2);
        }
        if (!(obj instanceof Number)) {
            return obj.equals(obj2);
        }
        if (obj2 instanceof Number) {
            return eqNotNull((Number) obj, (Number) obj2);
        }
        return false;
    }

    public static boolean eqNotNull(Number number, Number number2) {
        Class<?> cls = number.getClass();
        boolean zIsInt = isInt(cls);
        Class<?> cls2 = number2.getClass();
        boolean zIsInt2 = isInt(cls2);
        if (number instanceof BigDecimal) {
            BigDecimal bigDecimal = (BigDecimal) number;
            if (zIsInt2) {
                return bigDecimal.equals(BigDecimal.valueOf(TypeUtils.longExtractValue(number2)));
            }
        }
        if (zIsInt) {
            if (zIsInt2) {
                return number.longValue() == number2.longValue();
            }
            if (number2 instanceof BigInteger) {
                return BigInteger.valueOf(number.longValue()).equals((BigInteger) number);
            }
        }
        if (zIsInt2 && (number instanceof BigInteger)) {
            return ((BigInteger) number).equals(BigInteger.valueOf(TypeUtils.longExtractValue(number2)));
        }
        boolean zIsDouble = isDouble(cls);
        boolean zIsDouble2 = isDouble(cls2);
        return ((zIsDouble && zIsDouble2) || ((zIsDouble && zIsInt2) || (zIsDouble2 && zIsInt))) && number.doubleValue() == number2.doubleValue();
    }

    public static boolean isDouble(Class<?> cls) {
        return cls == Float.class || cls == Double.class;
    }

    public static boolean isInt(Class<?> cls) {
        return cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class;
    }

    public static Map<String, Object> paths(Object obj) {
        return paths(obj, SerializeConfig.globalInstance);
    }

    public static Object read(String str, String str2) {
        return compile(str2).eval(JSON.parse(str));
    }

    public static Object reserveToArray(Object obj, String... strArr) {
        JSONArray jSONArray = new JSONArray();
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                JSONPath jSONPathCompile = compile(str);
                jSONPathCompile.init();
                jSONArray.add(jSONPathCompile.eval(obj));
            }
        }
        return jSONArray;
    }

    public static Object reserveToObject(Object obj, String... strArr) {
        Object objEval;
        if (strArr == null || strArr.length == 0) {
            return obj;
        }
        JSONObject jSONObject = new JSONObject(true);
        for (String str : strArr) {
            JSONPath jSONPathCompile = compile(str);
            jSONPathCompile.init();
            Segment[] segmentArr = jSONPathCompile.segments;
            if ((segmentArr[segmentArr.length - 1] instanceof PropertySegment) && (objEval = jSONPathCompile.eval(obj)) != null) {
                jSONPathCompile.set(jSONObject, objEval);
            }
        }
        return jSONObject;
    }

    public void arrayAdd(Object obj, Object... objArr) {
        if (objArr == null || objArr.length == 0 || obj == null) {
            return;
        }
        init();
        int i6 = 0;
        Object obj2 = null;
        Object objEval = obj;
        int i10 = 0;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i10 >= segmentArr.length) {
                break;
            }
            if (i10 == segmentArr.length - 1) {
                obj2 = objEval;
            }
            objEval = segmentArr[i10].eval(this, obj, objEval);
            i10++;
        }
        if (objEval == null) {
            throw new JSONPathException("value not found in path " + this.path);
        }
        if (objEval instanceof Collection) {
            Collection collection = (Collection) objEval;
            int length = objArr.length;
            while (i6 < length) {
                collection.add(objArr[i6]);
                i6++;
            }
            return;
        }
        Class<?> cls = objEval.getClass();
        if (!cls.isArray()) {
            throw new JSONException(AbstractC0004e.m23q(cls, "unsupported array put operation. "));
        }
        int length2 = Array.getLength(objEval);
        Object objNewInstance = Array.newInstance(cls.getComponentType(), objArr.length + length2);
        System.arraycopy(objEval, 0, objNewInstance, 0, length2);
        while (i6 < objArr.length) {
            Array.set(objNewInstance, length2 + i6, objArr[i6]);
            i6++;
        }
        Segment[] segmentArr2 = this.segments;
        Segment segment = segmentArr2[segmentArr2.length - 1];
        if (segment instanceof PropertySegment) {
            ((PropertySegment) segment).setValue(this, obj2, objNewInstance);
        } else {
            if (!(segment instanceof ArrayAccessSegment)) {
                throw new UnsupportedOperationException();
            }
            ((ArrayAccessSegment) segment).setValue(this, obj2, objNewInstance);
        }
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        init();
        Object obj2 = obj;
        int i6 = 0;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i6 >= segmentArr.length) {
                return true;
            }
            Object objEval = segmentArr[i6].eval(this, obj, obj2);
            if (objEval == null) {
                return false;
            }
            if (objEval == Collections.EMPTY_LIST && (obj2 instanceof List)) {
                return ((List) obj2).contains(objEval);
            }
            i6++;
            obj2 = objEval;
        }
    }

    public boolean containsValue(Object obj, Object obj2) {
        Object objEval = eval(obj);
        if (objEval == obj2) {
            return true;
        }
        if (objEval == null) {
            return false;
        }
        if (!(objEval instanceof Iterable)) {
            return m3338eq(objEval, obj2);
        }
        Iterator it = ((Iterable) objEval).iterator();
        while (it.hasNext()) {
            if (m3338eq(it.next(), obj2)) {
                return true;
            }
        }
        return false;
    }

    public void deepGetObjects(Object obj, List<Object> list) {
        Collection fieldValues;
        Class<?> cls = obj.getClass();
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(cls);
        if (javaBeanSerializer != null) {
            try {
                fieldValues = javaBeanSerializer.getFieldValues(obj);
                list.add(obj);
            } catch (Exception e5) {
                throw new JSONPathException("jsonpath error, path " + this.path, e5);
            }
        } else if (obj instanceof Map) {
            list.add(obj);
            fieldValues = ((Map) obj).values();
        } else {
            fieldValues = obj instanceof Collection ? (Collection) obj : null;
        }
        if (fieldValues == null) {
            throw new UnsupportedOperationException(cls.getName());
        }
        for (Object obj2 : fieldValues) {
            if (obj2 != null && !ParserConfig.isPrimitive2(obj2.getClass())) {
                deepGetObjects(obj2, list);
            }
        }
    }

    public void deepGetPropertyValues(Object obj, List<Object> list) {
        Collection fieldValues;
        Class<?> cls = obj.getClass();
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(cls);
        if (javaBeanSerializer != null) {
            try {
                fieldValues = javaBeanSerializer.getFieldValues(obj);
            } catch (Exception e5) {
                throw new JSONPathException("jsonpath error, path " + this.path, e5);
            }
        } else if (obj instanceof Map) {
            fieldValues = ((Map) obj).values();
        } else {
            fieldValues = obj instanceof Collection ? (Collection) obj : null;
        }
        if (fieldValues == null) {
            throw new UnsupportedOperationException(cls.getName());
        }
        for (Object obj2 : fieldValues) {
            if (obj2 == null || ParserConfig.isPrimitive2(obj2.getClass())) {
                list.add(obj2);
            } else {
                deepGetPropertyValues(obj2, list);
            }
        }
    }

    public void deepScan(Object obj, String str, List<Object> list) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object value = entry.getValue();
                if (str.equals(entry.getKey())) {
                    if (value instanceof Collection) {
                        list.addAll((Collection) value);
                    } else {
                        list.add(value);
                    }
                } else if (value != null && !ParserConfig.isPrimitive2(value.getClass())) {
                    deepScan(value, str, list);
                }
            }
            return;
        }
        if (obj instanceof Collection) {
            for (Object obj2 : (Collection) obj) {
                if (!ParserConfig.isPrimitive2(obj2.getClass())) {
                    deepScan(obj2, str, list);
                }
            }
            return;
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer == null) {
            if (obj instanceof List) {
                List list2 = (List) obj;
                for (int i6 = 0; i6 < list2.size(); i6++) {
                    deepScan(list2.get(i6), str, list);
                }
                return;
            }
            return;
        }
        try {
            FieldSerializer fieldSerializer = javaBeanSerializer.getFieldSerializer(str);
            if (fieldSerializer == null) {
                Iterator<Object> it = javaBeanSerializer.getFieldValues(obj).iterator();
                while (it.hasNext()) {
                    deepScan(it.next(), str, list);
                }
                return;
            }
            try {
                try {
                    list.add(fieldSerializer.getPropertyValueDirect(obj));
                } catch (IllegalAccessException e5) {
                    throw new JSONException("getFieldValue error." + str, e5);
                }
            } catch (InvocationTargetException e10) {
                throw new JSONException("getFieldValue error." + str, e10);
            }
        } catch (Exception e11) {
            throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e11);
        }
    }

    public void deepSet(Object obj, String str, long j10, Object obj2) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.containsKey(str)) {
                map.get(str);
                map.put(str, obj2);
                return;
            } else {
                Iterator it = map.values().iterator();
                while (it.hasNext()) {
                    deepSet(it.next(), str, j10, obj2);
                }
                return;
            }
        }
        Class<?> cls = obj.getClass();
        JavaBeanDeserializer javaBeanDeserializer = getJavaBeanDeserializer(cls);
        if (javaBeanDeserializer == null) {
            if (obj instanceof List) {
                List list = (List) obj;
                for (int i6 = 0; i6 < list.size(); i6++) {
                    deepSet(list.get(i6), str, j10, obj2);
                }
                return;
            }
            return;
        }
        try {
            FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(str);
            if (fieldDeserializer != null) {
                fieldDeserializer.setValue(obj, obj2);
                return;
            }
            Iterator<Object> it2 = getJavaBeanSerializer(cls).getObjectFieldValues(obj).iterator();
            while (it2.hasNext()) {
                deepSet(it2.next(), str, j10, obj2);
            }
        } catch (Exception e5) {
            throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e5);
        }
    }

    public Object eval(Object obj) {
        if (obj == null) {
            return null;
        }
        init();
        int i6 = 0;
        Object objEval = obj;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i6 >= segmentArr.length) {
                return objEval;
            }
            objEval = segmentArr[i6].eval(this, obj, objEval);
            i6++;
        }
    }

    public Set<?> evalKeySet(Object obj) {
        JavaBeanSerializer javaBeanSerializer;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return ((Map) obj).keySet();
        }
        if ((obj instanceof Collection) || (obj instanceof Object[]) || obj.getClass().isArray() || (javaBeanSerializer = getJavaBeanSerializer(obj.getClass())) == null) {
            return null;
        }
        try {
            return javaBeanSerializer.getFieldNames(obj);
        } catch (Exception e5) {
            throw new JSONPathException("evalKeySet error : " + this.path, e5);
        }
    }

    public int evalSize(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).size();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj);
        }
        if (obj instanceof Map) {
            Iterator it = ((Map) obj).values().iterator();
            int i6 = 0;
            while (it.hasNext()) {
                if (it.next() != null) {
                    i6++;
                }
            }
            return i6;
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer == null) {
            return -1;
        }
        try {
            return javaBeanSerializer.getSize(obj);
        } catch (Exception e5) {
            throw new JSONPathException("evalSize error : " + this.path, e5);
        }
    }

    public Object extract(DefaultJSONParser defaultJSONParser) {
        boolean z7;
        Object obj;
        if (defaultJSONParser == null) {
            return null;
        }
        init();
        if (this.hasRefSegment) {
            return eval(defaultJSONParser.parse());
        }
        Segment[] segmentArr = this.segments;
        if (segmentArr.length == 0) {
            return defaultJSONParser.parse();
        }
        Segment segment = segmentArr[segmentArr.length - 1];
        if ((segment instanceof TypeSegment) || (segment instanceof FloorSegment) || (segment instanceof MultiIndexSegment)) {
            return eval(defaultJSONParser.parse());
        }
        Context context = null;
        int i6 = 0;
        while (true) {
            Segment[] segmentArr2 = this.segments;
            if (i6 >= segmentArr2.length) {
                return context.object;
            }
            Segment segment2 = segmentArr2[i6];
            boolean z10 = i6 == segmentArr2.length - 1;
            if (context == null || (obj = context.object) == null) {
                if (z10) {
                    z7 = true;
                } else {
                    Segment segment3 = segmentArr2[i6 + 1];
                    if (((segment2 instanceof PropertySegment) && ((PropertySegment) segment2).deep && ((segment3 instanceof ArrayAccessSegment) || (segment3 instanceof MultiIndexSegment) || (segment3 instanceof MultiPropertySegment) || (segment3 instanceof SizeSegment) || (segment3 instanceof PropertySegment) || (segment3 instanceof FilterSegment))) || (((segment3 instanceof ArrayAccessSegment) && ((ArrayAccessSegment) segment3).index < 0) || (segment3 instanceof FilterSegment) || (segment2 instanceof WildCardSegment) || (segment2 instanceof MultiIndexSegment))) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                }
                Context context2 = new Context(context, z7);
                segment2.extract(this, defaultJSONParser, context2);
                context = context2;
            } else {
                context.object = segment2.eval(this, null, obj);
            }
            i6++;
        }
    }

    public Object getArrayItem(Object obj, int i6) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (i6 >= 0) {
                if (i6 < list.size()) {
                    return list.get(i6);
                }
                return null;
            }
            if (Math.abs(i6) <= list.size()) {
                return list.get(list.size() + i6);
            }
            return null;
        }
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            if (i6 >= 0) {
                if (i6 < length) {
                    return Array.get(obj, i6);
                }
                return null;
            }
            if (Math.abs(i6) <= length) {
                return Array.get(obj, length + i6);
            }
            return null;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            Object obj2 = map.get(Integer.valueOf(i6));
            return obj2 == null ? map.get(Integer.toString(i6)) : obj2;
        }
        if (!(obj instanceof Collection)) {
            if (i6 == 0) {
                return obj;
            }
            throw new UnsupportedOperationException();
        }
        int i10 = 0;
        for (Object obj3 : (Collection) obj) {
            if (i10 == i6) {
                return obj3;
            }
            i10++;
        }
        return null;
    }

    public JavaBeanDeserializer getJavaBeanDeserializer(Class<?> cls) {
        ObjectDeserializer deserializer = this.parserConfig.getDeserializer(cls);
        if (deserializer instanceof JavaBeanDeserializer) {
            return (JavaBeanDeserializer) deserializer;
        }
        return null;
    }

    public JavaBeanSerializer getJavaBeanSerializer(Class<?> cls) {
        ObjectSerializer objectWriter = this.serializeConfig.getObjectWriter(cls);
        if (objectWriter instanceof JavaBeanSerializer) {
            return (JavaBeanSerializer) objectWriter;
        }
        return null;
    }

    public String getPath() {
        return this.path;
    }

    public Object getPropertyValue(Object obj, String str, long j10) {
        Object obj2;
        JSONArray jSONArray = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            try {
                obj2 = (JSONObject) JSON.parse((String) obj, this.parserConfig);
            } catch (Exception unused) {
                obj2 = obj;
            }
        } else {
            obj2 = obj;
        }
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get(str);
            if (obj3 == null) {
                return (SIZE == j10 || LENGTH == j10) ? Integer.valueOf(map.size()) : obj3;
            }
            return obj3;
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj2.getClass());
        if (javaBeanSerializer != null) {
            try {
                return javaBeanSerializer.getFieldValue(obj2, str, j10, false);
            } catch (Exception e5) {
                throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e5);
            }
        }
        int i6 = 0;
        if (obj2 instanceof List) {
            List list = (List) obj2;
            if (SIZE == j10 || LENGTH == j10) {
                return Integer.valueOf(list.size());
            }
            while (i6 < list.size()) {
                Object obj4 = list.get(i6);
                if (obj4 == list) {
                    if (jSONArray == null) {
                        jSONArray = new JSONArray(list.size());
                    }
                    jSONArray.add(obj4);
                } else {
                    Object propertyValue = getPropertyValue(obj4, str, j10);
                    if (propertyValue instanceof Collection) {
                        Collection collection = (Collection) propertyValue;
                        if (jSONArray == null) {
                            jSONArray = new JSONArray(list.size());
                        }
                        jSONArray.addAll(collection);
                    } else if (propertyValue != null || !this.ignoreNullValue) {
                        if (jSONArray == null) {
                            jSONArray = new JSONArray(list.size());
                        }
                        jSONArray.add(propertyValue);
                    }
                }
                i6++;
            }
            return jSONArray == null ? Collections.emptyList() : jSONArray;
        }
        if (obj2 instanceof Object[]) {
            Object[] objArr = (Object[]) obj2;
            if (SIZE == j10 || LENGTH == j10) {
                return Integer.valueOf(objArr.length);
            }
            JSONArray jSONArray2 = new JSONArray(objArr.length);
            while (i6 < objArr.length) {
                Object[] objArr2 = objArr[i6];
                if (objArr2 == objArr) {
                    jSONArray2.add(objArr2);
                } else {
                    Object propertyValue2 = getPropertyValue(objArr2, str, j10);
                    if (propertyValue2 instanceof Collection) {
                        jSONArray2.addAll((Collection) propertyValue2);
                    } else if (propertyValue2 != null || !this.ignoreNullValue) {
                        jSONArray2.add(propertyValue2);
                    }
                }
                i6++;
            }
            return jSONArray2;
        }
        if (obj2 instanceof Enum) {
            Enum r10 = (Enum) obj2;
            if (-4270347329889690746L == j10) {
                return r10.name();
            }
            if (-1014497654951707614L == j10) {
                return Integer.valueOf(r10.ordinal());
            }
        }
        if (obj2 instanceof Calendar) {
            Calendar calendar = (Calendar) obj2;
            if (8963398325558730460L == j10) {
                return Integer.valueOf(calendar.get(1));
            }
            if (-811277319855450459L == j10) {
                return Integer.valueOf(calendar.get(2));
            }
            if (-3851359326990528739L == j10) {
                return Integer.valueOf(calendar.get(5));
            }
            if (4647432019745535567L == j10) {
                return Integer.valueOf(calendar.get(11));
            }
            if (6607618197526598121L == j10) {
                return Integer.valueOf(calendar.get(12));
            }
            if (-6586085717218287427L == j10) {
                return Integer.valueOf(calendar.get(13));
            }
        }
        return null;
    }

    public Collection<Object> getPropertyValues(Object obj) {
        if (obj == null) {
            return null;
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer != null) {
            try {
                return javaBeanSerializer.getFieldValues(obj);
            } catch (Exception e5) {
                throw new JSONPathException("jsonpath error, path " + this.path, e5);
            }
        }
        if (obj instanceof Map) {
            return ((Map) obj).values();
        }
        if (obj instanceof Collection) {
            return (Collection) obj;
        }
        throw new UnsupportedOperationException();
    }

    public void init() {
        if (this.segments != null) {
            return;
        }
        if ("*".equals(this.path)) {
            this.segments = new Segment[]{WildCardSegment.instance};
            return;
        }
        JSONPathParser jSONPathParser = new JSONPathParser(this.path);
        this.segments = jSONPathParser.explain();
        this.hasRefSegment = jSONPathParser.hasRefSegment;
    }

    public boolean isRef() {
        try {
            init();
            int i6 = 0;
            while (true) {
                Segment[] segmentArr = this.segments;
                if (i6 >= segmentArr.length) {
                    return true;
                }
                Class<?> cls = segmentArr[i6].getClass();
                if (cls != ArrayAccessSegment.class && cls != PropertySegment.class) {
                    return false;
                }
                i6++;
            }
        } catch (JSONPathException unused) {
            return false;
        }
    }

    public Set<?> keySet(Object obj) {
        if (obj == null) {
            return null;
        }
        init();
        int i6 = 0;
        Object objEval = obj;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i6 >= segmentArr.length) {
                return evalKeySet(objEval);
            }
            objEval = segmentArr[i6].eval(this, obj, objEval);
            i6++;
        }
    }

    public void patchAdd(Object obj, Object obj2, boolean z7) {
        if (obj == null) {
            return;
        }
        init();
        Object obj3 = null;
        int i6 = 0;
        Object obj4 = obj;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i6 >= segmentArr.length) {
                break;
            }
            Segment segment = segmentArr[i6];
            Object objEval = segment.eval(this, obj, obj4);
            if (objEval == null && i6 != this.segments.length - 1 && (segment instanceof PropertySegment)) {
                objEval = new JSONObject();
                ((PropertySegment) segment).setValue(this, obj4, objEval);
            }
            i6++;
            obj3 = obj4;
            obj4 = objEval;
        }
        if (!z7 && (obj4 instanceof Collection)) {
            ((Collection) obj4).add(obj2);
            return;
        }
        if (obj4 != null && !z7) {
            Class<?> cls = obj4.getClass();
            if (cls.isArray()) {
                int length = Array.getLength(obj4);
                Object objNewInstance = Array.newInstance(cls.getComponentType(), length + 1);
                System.arraycopy(obj4, 0, objNewInstance, 0, length);
                Array.set(objNewInstance, length, obj2);
                obj2 = objNewInstance;
            } else if (!Map.class.isAssignableFrom(cls)) {
                throw new JSONException(AbstractC0004e.m23q(cls, "unsupported array put operation. "));
            }
        }
        Segment[] segmentArr2 = this.segments;
        Segment segment2 = segmentArr2[segmentArr2.length - 1];
        if (segment2 instanceof PropertySegment) {
            ((PropertySegment) segment2).setValue(this, obj3, obj2);
        } else {
            if (!(segment2 instanceof ArrayAccessSegment)) {
                throw new UnsupportedOperationException();
            }
            ((ArrayAccessSegment) segment2).setValue(this, obj3, obj2);
        }
    }

    public boolean remove(Object obj) {
        boolean z7 = false;
        if (obj == null) {
            return false;
        }
        init();
        Segment[] segmentArr = this.segments;
        Segment segment = segmentArr[segmentArr.length - 1];
        Object objEval = obj;
        int i6 = 0;
        while (true) {
            Segment[] segmentArr2 = this.segments;
            if (i6 < segmentArr2.length) {
                if (i6 == segmentArr2.length - 1) {
                    break;
                }
                Segment segment2 = segmentArr2[i6];
                if (i6 == segmentArr2.length - 2 && (segment instanceof FilterSegment) && (segment2 instanceof PropertySegment)) {
                    FilterSegment filterSegment = (FilterSegment) segment;
                    if (objEval instanceof List) {
                        PropertySegment propertySegment = (PropertySegment) segment2;
                        Iterator it = ((List) objEval).iterator();
                        while (it.hasNext()) {
                            Object objEval2 = propertySegment.eval(this, obj, it.next());
                            if (objEval2 instanceof Iterable) {
                                filterSegment.remove(this, obj, objEval2);
                            } else if ((objEval2 instanceof Map) && filterSegment.filter.apply(this, obj, objEval, objEval2)) {
                                it.remove();
                            }
                        }
                        return true;
                    }
                    if (objEval instanceof Map) {
                        PropertySegment propertySegment2 = (PropertySegment) segment2;
                        Object objEval3 = propertySegment2.eval(this, obj, objEval);
                        if (objEval3 == null) {
                            return false;
                        }
                        if ((objEval3 instanceof Map) && filterSegment.filter.apply(this, obj, objEval, objEval3)) {
                            propertySegment2.remove(this, objEval);
                            return true;
                        }
                    }
                }
                objEval = segment2.eval(this, obj, objEval);
                if (objEval != null) {
                    i6++;
                }
            }
            objEval = null;
            break;
        }
        if (objEval == null) {
            return false;
        }
        if (!(segment instanceof PropertySegment)) {
            if (segment instanceof ArrayAccessSegment) {
                return ((ArrayAccessSegment) segment).remove(this, objEval);
            }
            if (segment instanceof FilterSegment) {
                return ((FilterSegment) segment).remove(this, obj, objEval);
            }
            throw new UnsupportedOperationException();
        }
        PropertySegment propertySegment3 = (PropertySegment) segment;
        if (objEval instanceof Collection) {
            Segment[] segmentArr3 = this.segments;
            if (segmentArr3.length > 1) {
                Segment segment3 = segmentArr3[segmentArr3.length - 2];
                if ((segment3 instanceof RangeSegment) || (segment3 instanceof MultiIndexSegment)) {
                    Iterator it2 = ((Collection) objEval).iterator();
                    while (it2.hasNext()) {
                        if (propertySegment3.remove(this, it2.next())) {
                            z7 = true;
                        }
                    }
                    return z7;
                }
            }
        }
        return propertySegment3.remove(this, objEval);
    }

    public boolean removeArrayItem(JSONPath jSONPath, Object obj, int i6) {
        if (!(obj instanceof List)) {
            throw new JSONPathException(AbstractC0004e.m23q(obj.getClass(), "unsupported set operation."));
        }
        List list = (List) obj;
        if (i6 >= 0) {
            if (i6 >= list.size()) {
                return false;
            }
            list.remove(i6);
            return true;
        }
        int size = list.size() + i6;
        if (size < 0) {
            return false;
        }
        list.remove(size);
        return true;
    }

    public boolean removePropertyValue(Object obj, String str, boolean z7) {
        boolean z10 = true;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            z10 = map.remove(str) != null;
            if (z7) {
                Iterator it = map.values().iterator();
                while (it.hasNext()) {
                    removePropertyValue(it.next(), str, z7);
                }
            }
            return z10;
        }
        ObjectDeserializer deserializer = this.parserConfig.getDeserializer(obj.getClass());
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        if (javaBeanDeserializer == null) {
            if (z7) {
                return false;
            }
            throw new UnsupportedOperationException();
        }
        FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(str);
        if (fieldDeserializer != null) {
            fieldDeserializer.setValue(obj, (String) null);
        } else {
            z10 = false;
        }
        if (z7) {
            for (Object obj2 : getPropertyValues(obj)) {
                if (obj2 != null) {
                    removePropertyValue(obj2, str, z7);
                }
            }
        }
        return z10;
    }

    public boolean set(Object obj, Object obj2) {
        return set(obj, obj2, true);
    }

    public boolean setArrayItem(JSONPath jSONPath, Object obj, int i6, Object obj2) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (i6 >= 0) {
                list.set(i6, obj2);
            } else {
                list.set(list.size() + i6, obj2);
            }
            return true;
        }
        Class<?> cls = obj.getClass();
        if (!cls.isArray()) {
            throw new JSONPathException(AbstractC0004e.m23q(cls, "unsupported set operation."));
        }
        int length = Array.getLength(obj);
        if (i6 >= 0) {
            if (i6 < length) {
                Array.set(obj, i6, obj2);
            }
        } else if (Math.abs(i6) <= length) {
            Array.set(obj, length + i6, obj2);
        }
        return true;
    }

    public boolean setPropertyValue(Object obj, String str, long j10, Object obj2) {
        if (obj instanceof Map) {
            ((Map) obj).put(str, obj2);
            return true;
        }
        if (obj instanceof List) {
            for (Object obj3 : (List) obj) {
                if (obj3 != null) {
                    setPropertyValue(obj3, str, j10, obj2);
                }
            }
            return true;
        }
        ObjectDeserializer deserializer = this.parserConfig.getDeserializer(obj.getClass());
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        if (javaBeanDeserializer == null) {
            throw new UnsupportedOperationException();
        }
        FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(j10);
        if (fieldDeserializer == null) {
            return false;
        }
        if (obj2 != null) {
            Class<?> cls = obj2.getClass();
            FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
            if (cls != fieldInfo.fieldClass) {
                obj2 = TypeUtils.cast(obj2, fieldInfo.fieldType, this.parserConfig);
            }
        }
        fieldDeserializer.setValue(obj, obj2);
        return true;
    }

    public int size(Object obj) {
        if (obj == null) {
            return -1;
        }
        init();
        int i6 = 0;
        Object objEval = obj;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i6 >= segmentArr.length) {
                return evalSize(objEval);
            }
            objEval = segmentArr[i6].eval(this, obj, objEval);
            i6++;
        }
    }

    @Override
    public String toJSONString() {
        return JSON.toJSONString(this.path);
    }

    public JSONPath(String str, boolean z7) {
        this(str, SerializeConfig.getGlobalInstance(), ParserConfig.getGlobalInstance(), z7);
    }

    public static Map<String, Object> paths(Object obj, SerializeConfig serializeConfig) {
        IdentityHashMap identityHashMap = new IdentityHashMap();
        HashMap map = new HashMap();
        paths(identityHashMap, map, "/", obj, serializeConfig);
        return map;
    }

    public boolean set(Object obj, Object obj2, boolean z7) {
        Class<?> cls;
        JavaBeanDeserializer javaBeanDeserializer;
        if (obj == null) {
            return false;
        }
        init();
        Object obj3 = obj;
        Object obj4 = null;
        int i6 = 0;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i6 >= segmentArr.length) {
                obj3 = obj4;
                break;
            }
            Segment segment = segmentArr[i6];
            Object objEval = segment.eval(this, obj, obj3);
            if (objEval == null) {
                Segment[] segmentArr2 = this.segments;
                Segment segment2 = i6 < segmentArr2.length - 1 ? segmentArr2[i6 + 1] : null;
                if (segment2 instanceof PropertySegment) {
                    if (segment instanceof PropertySegment) {
                        String str = ((PropertySegment) segment).propertyName;
                        JavaBeanDeserializer javaBeanDeserializer2 = getJavaBeanDeserializer(obj3.getClass());
                        if (javaBeanDeserializer2 != null) {
                            cls = javaBeanDeserializer2.getFieldDeserializer(str).fieldInfo.fieldClass;
                            javaBeanDeserializer = getJavaBeanDeserializer(cls);
                        } else {
                            cls = null;
                            javaBeanDeserializer = null;
                        }
                    } else {
                        cls = null;
                        javaBeanDeserializer = null;
                    }
                    if (javaBeanDeserializer == null) {
                        objEval = new JSONObject();
                    } else {
                        if (javaBeanDeserializer.beanInfo.defaultConstructor == null) {
                            return false;
                        }
                        objEval = javaBeanDeserializer.createInstance((DefaultJSONParser) null, cls);
                    }
                } else {
                    objEval = segment2 instanceof ArrayAccessSegment ? new JSONArray() : null;
                }
                if (objEval != null) {
                    if (!(segment instanceof PropertySegment)) {
                        if (!(segment instanceof ArrayAccessSegment)) {
                            break;
                        }
                        ((ArrayAccessSegment) segment).setValue(this, obj3, objEval);
                    } else {
                        ((PropertySegment) segment).setValue(this, obj3, objEval);
                    }
                } else {
                    break;
                }
            }
            i6++;
            obj4 = obj3;
            obj3 = objEval;
        }
        if (obj3 == null) {
            return false;
        }
        Segment[] segmentArr3 = this.segments;
        Segment segment3 = segmentArr3[segmentArr3.length - 1];
        if (segment3 instanceof PropertySegment) {
            ((PropertySegment) segment3).setValue(this, obj3, obj2);
            return true;
        }
        if (segment3 instanceof ArrayAccessSegment) {
            return ((ArrayAccessSegment) segment3).setValue(this, obj3, obj2);
        }
        throw new UnsupportedOperationException();
    }

    public JSONPath(String str, SerializeConfig serializeConfig, ParserConfig parserConfig, boolean z7) {
        if (str != null && str.length() != 0) {
            this.path = str;
            this.serializeConfig = serializeConfig;
            this.parserConfig = parserConfig;
            this.ignoreNullValue = z7;
            return;
        }
        throw new JSONPathException("json-path can not be null or empty");
    }

    public static <T> T read(String str, String str2, Type type, ParserConfig parserConfig) {
        return (T) compile(str2).eval(JSON.parse(str), type, parserConfig);
    }

    public static Set<?> keySet(Object obj, String str) {
        JSONPath jSONPathCompile = compile(str);
        return jSONPathCompile.evalKeySet(jSONPathCompile.eval(obj));
    }

    private static void paths(Map<Object, String> map, Map<String, Object> map2, String str, Object obj, SerializeConfig serializeConfig) {
        StringBuilder sb;
        Class<?> cls;
        if (obj == null) {
            return;
        }
        if (map.put(obj, str) == null || (cls = obj.getClass()) == String.class || cls == Boolean.class || cls == Character.class || cls == UUID.class || cls.isEnum() || (obj instanceof Number) || (obj instanceof Date)) {
            map2.put(str, obj);
            if (obj instanceof Map) {
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    if (key instanceof String) {
                        paths(map, map2, str.equals("/") ? AbstractC2460q.m5493g(key, "/") : str + "/" + key, entry.getValue(), serializeConfig);
                    }
                }
                return;
            }
            int i6 = 0;
            if (obj instanceof Collection) {
                for (Object obj2 : (Collection) obj) {
                    paths(map, map2, str.equals("/") ? AbstractC0004e.m20n(i6, "/") : str + "/" + i6, obj2, serializeConfig);
                    i6++;
                }
                return;
            }
            Class<?> cls2 = obj.getClass();
            if (cls2.isArray()) {
                int length = Array.getLength(obj);
                while (i6 < length) {
                    Object obj3 = Array.get(obj, i6);
                    paths(map, map2, str.equals("/") ? AbstractC0004e.m20n(i6, "/") : str + "/" + i6, obj3, serializeConfig);
                    i6++;
                }
                return;
            }
            if (ParserConfig.isPrimitive2(cls2) || cls2.isEnum()) {
                return;
            }
            ObjectSerializer objectWriter = serializeConfig.getObjectWriter(cls2);
            if (objectWriter instanceof JavaBeanSerializer) {
                try {
                    for (Map.Entry<String, Object> entry2 : ((JavaBeanSerializer) objectWriter).getFieldValuesMap(obj).entrySet()) {
                        String key2 = entry2.getKey();
                        if (key2 instanceof String) {
                            if (str.equals("/")) {
                                sb = new StringBuilder();
                                sb.append("/");
                                sb.append(key2);
                            } else {
                                sb = new StringBuilder();
                                sb.append(str);
                                sb.append("/");
                                sb.append(key2);
                            }
                            paths(map, map2, sb.toString(), entry2.getValue(), serializeConfig);
                        }
                    }
                } catch (Exception e5) {
                    throw new JSONException("toJSON error", e5);
                }
            }
        }
    }

    public static <T> T read(String str, String str2, Type type) {
        return (T) read(str, str2, type, null);
    }

    public static int size(Object obj, String str) {
        JSONPath jSONPathCompile = compile(str);
        return jSONPathCompile.evalSize(jSONPathCompile.eval(obj));
    }

    public <T> T eval(Object obj, Type type, ParserConfig parserConfig) {
        return (T) TypeUtils.cast(eval(obj), type, parserConfig);
    }

    public static boolean contains(Object obj, String str) {
        if (obj == null) {
            return false;
        }
        return compile(str).contains(obj);
    }

    public static JSONPath compile(String str, boolean z7) {
        if (str != null) {
            JSONPath jSONPath = pathCache.get(str);
            if (jSONPath != null) {
                return jSONPath;
            }
            JSONPath jSONPath2 = new JSONPath(str, z7);
            if (pathCache.size() >= 1024) {
                return jSONPath2;
            }
            pathCache.putIfAbsent(str, jSONPath2);
            return pathCache.get(str);
        }
        throw new JSONPathException("jsonpath can not be null");
    }

    public <T> T eval(Object obj, Type type) {
        return (T) eval(obj, type, ParserConfig.getGlobalInstance());
    }

    public static boolean containsValue(Object obj, String str, Object obj2) {
        return compile(str).containsValue(obj, obj2);
    }

    public static Object eval(Object obj, String str) {
        return compile(str).eval(obj);
    }

    public static Object eval(Object obj, String str, boolean z7) {
        return compile(str, z7).eval(obj);
    }

    public static Object extract(String str, String str2, ParserConfig parserConfig, int i6, Feature... featureArr) {
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, parserConfig, i6 | Feature.OrderedField.mask);
        Object objExtract = compile(str2).extract(defaultJSONParser);
        defaultJSONParser.lexer.close();
        return objExtract;
    }

    public static void arrayAdd(Object obj, String str, Object... objArr) {
        compile(str).arrayAdd(obj, objArr);
    }

    public static Object extract(String str, String str2) {
        return extract(str, str2, ParserConfig.global, JSON.DEFAULT_PARSER_FEATURE, new Feature[0]);
    }

    public static boolean set(Object obj, String str, Object obj2) {
        return compile(str).set(obj, obj2);
    }

    public static boolean remove(Object obj, String str) {
        return compile(str).remove(obj);
    }
}

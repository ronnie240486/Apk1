package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class EnumDeserializer implements ObjectDeserializer {
    protected final Class<?> enumClass;
    protected long[] enumNameHashCodes;
    protected final Enum[] enums;
    protected final Enum[] ordinalEnums;

    public EnumDeserializer(Class<?> cls) {
        JSONField jSONField;
        this.enumClass = cls;
        this.ordinalEnums = (Enum[]) cls.getEnumConstants();
        HashMap map = new HashMap();
        int i6 = 0;
        while (true) {
            Enum[] enumArr = this.ordinalEnums;
            if (i6 >= enumArr.length) {
                break;
            }
            Enum r10 = enumArr[i6];
            String strName = r10.name();
            JSONField jSONField2 = null;
            try {
                jSONField = (JSONField) TypeUtils.getAnnotation(cls.getField(strName), JSONField.class);
                if (jSONField != null) {
                    try {
                        String strName2 = jSONField.name();
                        if (strName2 != null && strName2.length() > 0) {
                            strName = strName2;
                        }
                    } catch (Exception unused) {
                        jSONField2 = jSONField;
                        jSONField = jSONField2;
                    }
                }
            } catch (Exception unused2) {
            }
            int i10 = 0;
            long j10 = TypeUtils.fnv1a_64_magic_hashcode;
            long j11 = TypeUtils.fnv1a_64_magic_hashcode;
            while (i10 < strName.length()) {
                int iCharAt = strName.charAt(i10);
                long j12 = ((long) iCharAt) ^ j10;
                if (iCharAt >= 65 && iCharAt <= 90) {
                    iCharAt += 32;
                }
                long j13 = j12 * TypeUtils.fnv1a_64_magic_prime;
                j11 = (((long) iCharAt) ^ j11) * TypeUtils.fnv1a_64_magic_prime;
                i10++;
                j10 = j13;
            }
            map.put(Long.valueOf(j10), r10);
            if (j10 != j11) {
                map.put(Long.valueOf(j11), r10);
            }
            if (jSONField != null) {
                String[] strArrAlternateNames = jSONField.alternateNames();
                int length = strArrAlternateNames.length;
                int i11 = 0;
                while (i11 < length) {
                    String str = strArrAlternateNames[i11];
                    int i12 = 0;
                    long jCharAt = TypeUtils.fnv1a_64_magic_hashcode;
                    while (i12 < str.length()) {
                        jCharAt = (jCharAt ^ ((long) str.charAt(i12))) * TypeUtils.fnv1a_64_magic_prime;
                        i12++;
                        i6 = i6;
                    }
                    int i13 = i6;
                    if (jCharAt != j10 && jCharAt != j11) {
                        map.put(Long.valueOf(jCharAt), r10);
                    }
                    i11++;
                    i6 = i13;
                }
            }
            i6++;
        }
        this.enumNameHashCodes = new long[map.size()];
        Iterator it = map.keySet().iterator();
        int i14 = 0;
        while (it.hasNext()) {
            this.enumNameHashCodes[i14] = ((Long) it.next()).longValue();
            i14++;
        }
        Arrays.sort(this.enumNameHashCodes);
        this.enums = new Enum[this.enumNameHashCodes.length];
        int i15 = 0;
        while (true) {
            long[] jArr = this.enumNameHashCodes;
            if (i15 >= jArr.length) {
                return;
            }
            this.enums[i15] = (Enum) map.get(Long.valueOf(jArr[i15]));
            i15++;
        }
    }

    @Override
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        try {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            int i6 = jSONLexer.token();
            if (i6 == 2) {
                int iIntValue = jSONLexer.intValue();
                jSONLexer.nextToken(16);
                if (iIntValue >= 0) {
                    Object[] objArr = this.ordinalEnums;
                    if (iIntValue < objArr.length) {
                        return (T) objArr[iIntValue];
                    }
                }
                throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + iIntValue);
            }
            if (i6 != 4) {
                if (i6 == 8) {
                    jSONLexer.nextToken(16);
                    return null;
                }
                throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + defaultJSONParser.parse());
            }
            String strStringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            if (strStringVal.length() == 0) {
                return null;
            }
            long j10 = TypeUtils.fnv1a_64_magic_hashcode;
            long j11 = -3750763034362895579L;
            for (int i10 = 0; i10 < strStringVal.length(); i10++) {
                int iCharAt = strStringVal.charAt(i10);
                long j12 = j10 ^ ((long) iCharAt);
                if (iCharAt >= 65 && iCharAt <= 90) {
                    iCharAt += 32;
                }
                j10 = j12 * TypeUtils.fnv1a_64_magic_prime;
                j11 = (j11 ^ ((long) iCharAt)) * TypeUtils.fnv1a_64_magic_prime;
            }
            T t5 = (T) getEnumByHashCode(j10);
            if (t5 == null && j11 != j10) {
                t5 = (T) getEnumByHashCode(j11);
            }
            if (t5 == null && jSONLexer.isEnabled(Feature.ErrorOnEnumNotMatch)) {
                throw new JSONException("not match enum value, " + this.enumClass.getName() + " : " + strStringVal);
            }
            return t5;
        } catch (JSONException e5) {
            throw e5;
        } catch (Exception e10) {
            throw new JSONException(e10.getMessage(), e10);
        }
    }

    public Enum getEnumByHashCode(long j10) {
        int iBinarySearch;
        if (this.enums != null && (iBinarySearch = Arrays.binarySearch(this.enumNameHashCodes, j10)) >= 0) {
            return this.enums[iBinarySearch];
        }
        return null;
    }

    @Override
    public int getFastMatchToken() {
        return 2;
    }

    public Enum<?> valueOf(int i6) {
        return this.ordinalEnums[i6];
    }
}

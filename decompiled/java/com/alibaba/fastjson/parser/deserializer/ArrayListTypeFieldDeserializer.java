package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class ArrayListTypeFieldDeserializer extends FieldDeserializer {
    private ObjectDeserializer deserializer;
    private int itemFastMatchToken;
    private final Type itemType;

    public ArrayListTypeFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        super(cls, fieldInfo);
        Type type = fieldInfo.fieldType;
        if (!(type instanceof ParameterizedType)) {
            this.itemType = Object.class;
            return;
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
            if (upperBounds.length == 1) {
                type2 = upperBounds[0];
            }
        }
        this.itemType = type2;
    }

    @Override
    public int getFastMatchToken() {
        return 14;
    }

    public final void parseArray(DefaultJSONParser defaultJSONParser, Type type, Collection collection) {
        Class cls;
        int i6;
        int i10;
        Type typeIntern = this.itemType;
        ObjectDeserializer deserializer = this.deserializer;
        int i11 = 0;
        if (type instanceof ParameterizedType) {
            if (typeIntern instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) typeIntern;
                ParameterizedType parameterizedType = (ParameterizedType) type;
                cls = parameterizedType.getRawType() instanceof Class ? (Class) parameterizedType.getRawType() : null;
                if (cls == null) {
                    i10 = -1;
                    break;
                }
                int length = cls.getTypeParameters().length;
                i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        i10 = -1;
                        break;
                    } else if (cls.getTypeParameters()[i10].getName().equals(typeVariable.getName())) {
                        break;
                    } else {
                        i10++;
                    }
                }
                if (i10 != -1) {
                    typeIntern = parameterizedType.getActualTypeArguments()[i10];
                    if (!typeIntern.equals(this.itemType)) {
                        deserializer = defaultJSONParser.getConfig().getDeserializer(typeIntern);
                    }
                }
            } else if (typeIntern instanceof ParameterizedType) {
                ParameterizedType parameterizedType2 = (ParameterizedType) typeIntern;
                Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
                if (actualTypeArguments.length == 1) {
                    Type type2 = actualTypeArguments[0];
                    if (type2 instanceof TypeVariable) {
                        TypeVariable typeVariable2 = (TypeVariable) type2;
                        ParameterizedType parameterizedType3 = (ParameterizedType) type;
                        cls = parameterizedType3.getRawType() instanceof Class ? (Class) parameterizedType3.getRawType() : null;
                        if (cls == null) {
                            i6 = -1;
                            break;
                        }
                        int length2 = cls.getTypeParameters().length;
                        i6 = 0;
                        while (true) {
                            if (i6 >= length2) {
                                i6 = -1;
                                break;
                            } else if (cls.getTypeParameters()[i6].getName().equals(typeVariable2.getName())) {
                                break;
                            } else {
                                i6++;
                            }
                        }
                        if (i6 != -1) {
                            actualTypeArguments[0] = parameterizedType3.getActualTypeArguments()[i6];
                            typeIntern = TypeReference.intern(new ParameterizedTypeImpl(actualTypeArguments, parameterizedType2.getOwnerType(), parameterizedType2.getRawType()));
                        }
                    }
                }
            }
        } else if ((typeIntern instanceof TypeVariable) && (type instanceof Class)) {
            Class cls2 = (Class) type;
            TypeVariable typeVariable3 = (TypeVariable) typeIntern;
            cls2.getTypeParameters();
            int length3 = cls2.getTypeParameters().length;
            for (int i12 = 0; i12 < length3; i12++) {
                TypeVariable typeVariable4 = cls2.getTypeParameters()[i12];
                if (typeVariable4.getName().equals(typeVariable3.getName())) {
                    Type[] bounds = typeVariable4.getBounds();
                    if (bounds.length != 1) {
                        break;
                    }
                    typeIntern = bounds[0];
                    break;
                }
            }
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i13 = jSONLexer.token();
        if (i13 != 14) {
            if (i13 == 4 && this.fieldInfo.unwrapped) {
                String strStringVal = jSONLexer.stringVal();
                jSONLexer.nextToken();
                new DefaultJSONParser(strStringVal).parseArray(collection);
                return;
            } else {
                if (deserializer == null) {
                    deserializer = defaultJSONParser.getConfig().getDeserializer(typeIntern);
                    this.deserializer = deserializer;
                }
                collection.add(deserializer.deserialze(defaultJSONParser, typeIntern, 0));
                defaultJSONParser.checkListResolve(collection);
                return;
            }
        }
        if (deserializer == null) {
            deserializer = defaultJSONParser.getConfig().getDeserializer(typeIntern);
            this.deserializer = deserializer;
            this.itemFastMatchToken = deserializer.getFastMatchToken();
        }
        ObjectDeserializer objectDeserializer = deserializer;
        jSONLexer.nextToken(this.itemFastMatchToken);
        while (true) {
            if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                while (jSONLexer.token() == 16) {
                    jSONLexer.nextToken();
                }
            }
            if (jSONLexer.token() == 15) {
                jSONLexer.nextToken(16);
                return;
            }
            collection.add(objectDeserializer.deserialze(defaultJSONParser, typeIntern, Integer.valueOf(i11)));
            defaultJSONParser.checkListResolve(collection);
            if (jSONLexer.token() == 16) {
                jSONLexer.nextToken(this.itemFastMatchToken);
            }
            i11++;
        }
    }

    @Override
    public void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i6 = jSONLexer.token();
        if (i6 == 8 || (i6 == 4 && jSONLexer.stringVal().length() == 0)) {
            if (obj == null) {
                map.put(this.fieldInfo.name, null);
                return;
            } else {
                setValue(obj, (String) null);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        ParseContext context = defaultJSONParser.getContext();
        defaultJSONParser.setContext(context, obj, this.fieldInfo.name);
        parseArray(defaultJSONParser, type, arrayList);
        defaultJSONParser.setContext(context);
        if (obj == null) {
            map.put(this.fieldInfo.name, arrayList);
        } else {
            setValue(obj, arrayList);
        }
    }
}

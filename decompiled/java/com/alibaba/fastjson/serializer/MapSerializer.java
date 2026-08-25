package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapSerializer extends SerializeFilterable implements ObjectSerializer {
    public static MapSerializer instance = new MapSerializer();
    private static final int NON_STRINGKEY_AS_STRING = SerializerFeature.m3460of(new SerializerFeature[]{SerializerFeature.BrowserCompatible, SerializerFeature.WriteNonStringKeyAsString, SerializerFeature.BrowserSecure});

    @Override
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i6) throws IOException {
        write(jSONSerializer, obj, obj2, type, i6, false);
    }

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i6, boolean z7) throws IOException {
        Map<String, Object> treeMap;
        boolean z10;
        List<PropertyPreFilter> list;
        List<PropertyFilter> list2;
        List<PropertyFilter> list3;
        List<NameFilter> list4;
        List<NameFilter> list5;
        String str;
        String str2;
        boolean z11;
        Object objProcessValue;
        Object obj3;
        ?? r10;
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        ObjectSerializer objectWriter;
        Type type2;
        obj = obj;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        Map<String, Object> innerMap = (Map) obj;
        int i10 = SerializerFeature.MapSortField.mask;
        if ((serializeWriter.features & i10) == 0 && (i10 & i6) == 0) {
            treeMap = innerMap;
        } else {
            if (innerMap instanceof JSONObject) {
                innerMap = ((JSONObject) innerMap).getInnerMap();
            }
            if ((innerMap instanceof SortedMap) || (innerMap instanceof LinkedHashMap)) {
                treeMap = innerMap;
            } else {
                try {
                    treeMap = new TreeMap(innerMap);
                } catch (Exception unused) {
                    treeMap = innerMap;
                }
            }
        }
        if (jSONSerializer.containsReference(obj)) {
            jSONSerializer.writeReference(obj);
            return;
        }
        SerialContext serialContext = jSONSerializer.context;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        if (!z7) {
            try {
                serializeWriter.write(123);
            } catch (Throwable th) {
                jSONSerializer.context = serialContext;
                throw th;
            }
        }
        jSONSerializer.incrementIndent();
        if (serializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
            String str3 = jSONSerializer.config.typeKey;
            Class<?> cls4 = treeMap.getClass();
            if ((cls4 == JSONObject.class || cls4 == HashMap.class || cls4 == LinkedHashMap.class) && treeMap.containsKey(str3)) {
                z10 = true;
            } else {
                serializeWriter.writeFieldName(str3);
                serializeWriter.writeString(obj.getClass().getName());
                z10 = false;
            }
        } else {
            z10 = true;
        }
        boolean z12 = z10;
        Class<?> cls5 = null;
        ObjectSerializer objectSerializer = null;
        for (Map.Entry<String, Object> entry : treeMap.entrySet()) {
            Object value = entry.getValue();
            String key = entry.getKey();
            List<PropertyPreFilter> list6 = jSONSerializer.propertyPreFilters;
            if (list6 == null || list6.size() <= 0) {
                list = this.propertyPreFilters;
                if (list != null || list.size() <= 0) {
                    list2 = jSONSerializer.propertyFilters;
                    if (list2 != null || list2.size() <= 0) {
                        list3 = this.propertyFilters;
                        if (list3 != null && list3.size() > 0) {
                            if (key != null || (key instanceof String)) {
                                if (!apply(jSONSerializer, obj, key, value)) {
                                    cls5 = cls5;
                                    obj = obj;
                                    cls5 = cls5;
                                }
                            } else if ((key.getClass().isPrimitive() || (key instanceof Number)) && !apply(jSONSerializer, obj, JSON.toJSONString(key), value)) {
                                cls5 = cls5;
                                obj = obj;
                                cls5 = cls5;
                            }
                        }
                        list4 = jSONSerializer.nameFilters;
                        if (list4 != null && list4.size() > 0) {
                            if (key != null || (key instanceof String)) {
                                key = processKey(jSONSerializer, obj, key, value);
                            } else if (key.getClass().isPrimitive() || (key instanceof Number)) {
                                key = processKey(jSONSerializer, obj, JSON.toJSONString(key), value);
                            }
                        }
                        list5 = this.nameFilters;
                        if (list5 != null && list5.size() > 0) {
                            if (key != null || (key instanceof String)) {
                                key = processKey(jSONSerializer, obj, key, value);
                            } else if (key.getClass().isPrimitive() || (key instanceof Number)) {
                                key = processKey(jSONSerializer, obj, JSON.toJSONString(key), value);
                            }
                        }
                        str = key;
                        if (str != null || (str instanceof String)) {
                            str2 = str;
                            z11 = true;
                            objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                        } else {
                            if ((str instanceof Map) || (str instanceof Collection)) {
                                str2 = str;
                                cls5 = cls5;
                                r10 = 1;
                                obj3 = value;
                            } else {
                                str2 = str;
                                z11 = true;
                                objProcessValue = processValue(jSONSerializer, null, obj, JSON.toJSONString(str), value, i6);
                            }
                            if (obj3 == null || SerializerFeature.isEnabled(serializeWriter.features, i6, SerializerFeature.WriteMapNullValue)) {
                                if (str2 instanceof String) {
                                    String str4 = str2;
                                    if (!z12) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                        jSONSerializer.println();
                                    }
                                    serializeWriter.writeFieldName(str4, r10);
                                } else {
                                    if (!z12) {
                                        serializeWriter.write(44);
                                    }
                                    if ((!serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING) || SerializerFeature.isEnabled(i6, SerializerFeature.WriteNonStringKeyAsString)) && !(str2 instanceof Enum)) {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    } else {
                                        jSONSerializer.write((Object) str2);
                                    }
                                    serializeWriter.write(58);
                                }
                                if (obj3 == null) {
                                    serializeWriter.writeNull();
                                    cls5 = cls5;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        cls3 = cls;
                                        objectWriter = jSONSerializer.getObjectWriter(cls);
                                    } else {
                                        cls3 = cls2;
                                        objectWriter = objectSerializer;
                                    }
                                    if (SerializerFeature.isEnabled(i6, SerializerFeature.WriteClassName) || !(objectWriter instanceof JavaBeanSerializer)) {
                                        objectSerializer = objectWriter;
                                        objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                    } else {
                                        if (type instanceof ParameterizedType) {
                                            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                                            if (actualTypeArguments.length == 2) {
                                                type2 = actualTypeArguments[r10];
                                            } else {
                                                type2 = null;
                                            }
                                        } else {
                                            type2 = null;
                                        }
                                        objectSerializer = objectWriter;
                                        ((JavaBeanSerializer) objectWriter).writeNoneASM(jSONSerializer, obj3, str2, type2, i6);
                                    }
                                    cls5 = cls3;
                                }
                                z12 = false;
                            } else {
                                obj = obj;
                                cls5 = cls5;
                            }
                        }
                        obj3 = objProcessValue;
                        r10 = z11;
                        if (obj3 == null) {
                        }
                        if (str2 instanceof String) {
                            String str5 = str2;
                            if (!z12) {
                                serializeWriter.write(44);
                            }
                            if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                jSONSerializer.println();
                            }
                            serializeWriter.writeFieldName(str5, r10);
                        } else {
                            if (!z12) {
                                serializeWriter.write(44);
                            }
                            if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                jSONSerializer.write(JSON.toJSONString(str2));
                            } else {
                                jSONSerializer.write(JSON.toJSONString(str2));
                            }
                            serializeWriter.write(58);
                        }
                        if (obj3 == null) {
                            serializeWriter.writeNull();
                            cls5 = cls5;
                        } else {
                            cls = obj3.getClass();
                            cls2 = cls5;
                            if (cls != cls2) {
                                cls3 = cls;
                                objectWriter = jSONSerializer.getObjectWriter(cls);
                            } else {
                                cls3 = cls2;
                                objectWriter = objectSerializer;
                            }
                            if (SerializerFeature.isEnabled(i6, SerializerFeature.WriteClassName)) {
                                objectSerializer = objectWriter;
                                objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                            } else {
                                objectSerializer = objectWriter;
                                objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                            }
                            cls5 = cls3;
                        }
                        z12 = false;
                    } else {
                        if (key == null || (key instanceof String)) {
                            if (apply(jSONSerializer, obj, key, value)) {
                                list3 = this.propertyFilters;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!apply(jSONSerializer, obj, key, value)) {
                                        }
                                    } else if (!apply(jSONSerializer, obj, key, value)) {
                                    }
                                }
                                list4 = jSONSerializer.nameFilters;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    }
                                }
                                list5 = this.nameFilters;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    z11 = true;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                    obj3 = objProcessValue;
                                    r10 = z11;
                                } else {
                                    str2 = str;
                                    z11 = true;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                    obj3 = objProcessValue;
                                    r10 = z11;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str6 = str2;
                                    if (!z12) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                        jSONSerializer.println();
                                    }
                                    serializeWriter.writeFieldName(str6, r10);
                                } else {
                                    if (!z12) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    } else {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    }
                                    serializeWriter.write(58);
                                }
                                if (obj3 == null) {
                                    serializeWriter.writeNull();
                                    cls5 = cls5;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        cls3 = cls;
                                        objectWriter = jSONSerializer.getObjectWriter(cls);
                                    } else {
                                        cls3 = cls2;
                                        objectWriter = objectSerializer;
                                    }
                                    if (SerializerFeature.isEnabled(i6, SerializerFeature.WriteClassName)) {
                                        objectSerializer = objectWriter;
                                        objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                    } else {
                                        objectSerializer = objectWriter;
                                        objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                    }
                                    cls5 = cls3;
                                }
                                z12 = false;
                            }
                        } else if ((!key.getClass().isPrimitive() && !(key instanceof Number)) || apply(jSONSerializer, obj, JSON.toJSONString(key), value)) {
                            list3 = this.propertyFilters;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!apply(jSONSerializer, obj, key, value)) {
                                    }
                                } else if (!apply(jSONSerializer, obj, key, value)) {
                                }
                            }
                            list4 = jSONSerializer.nameFilters;
                            if (list4 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj, key, value);
                                }
                            }
                            list5 = this.nameFilters;
                            if (list5 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                z11 = true;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                obj3 = objProcessValue;
                                r10 = z11;
                            } else {
                                str2 = str;
                                z11 = true;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                obj3 = objProcessValue;
                                r10 = z11;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str7 = str2;
                                if (!z12) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                    jSONSerializer.println();
                                }
                                serializeWriter.writeFieldName(str7, r10);
                            } else {
                                if (!z12) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                } else {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                }
                                serializeWriter.write(58);
                            }
                            if (obj3 == null) {
                                serializeWriter.writeNull();
                                cls5 = cls5;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    cls3 = cls;
                                    objectWriter = jSONSerializer.getObjectWriter(cls);
                                } else {
                                    cls3 = cls2;
                                    objectWriter = objectSerializer;
                                }
                                if (SerializerFeature.isEnabled(i6, SerializerFeature.WriteClassName)) {
                                    objectSerializer = objectWriter;
                                    objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                } else {
                                    objectSerializer = objectWriter;
                                    objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                }
                                cls5 = cls3;
                            }
                            z12 = false;
                        }
                        cls5 = cls5;
                        obj = obj;
                        cls5 = cls5;
                    }
                } else {
                    if (key == null || (key instanceof String)) {
                        if (applyName(jSONSerializer, obj, key)) {
                            list2 = jSONSerializer.propertyFilters;
                            if (list2 != null) {
                                list3 = this.propertyFilters;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!apply(jSONSerializer, obj, key, value)) {
                                        }
                                    } else if (!apply(jSONSerializer, obj, key, value)) {
                                    }
                                }
                                list4 = jSONSerializer.nameFilters;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    }
                                }
                                list5 = this.nameFilters;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    z11 = true;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                    obj3 = objProcessValue;
                                    r10 = z11;
                                } else {
                                    str2 = str;
                                    z11 = true;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                    obj3 = objProcessValue;
                                    r10 = z11;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str8 = str2;
                                    if (!z12) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                        jSONSerializer.println();
                                    }
                                    serializeWriter.writeFieldName(str8, r10);
                                } else {
                                    if (!z12) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    } else {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    }
                                    serializeWriter.write(58);
                                }
                                if (obj3 == null) {
                                    serializeWriter.writeNull();
                                    cls5 = cls5;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        cls3 = cls;
                                        objectWriter = jSONSerializer.getObjectWriter(cls);
                                    } else {
                                        cls3 = cls2;
                                        objectWriter = objectSerializer;
                                    }
                                    if (SerializerFeature.isEnabled(i6, SerializerFeature.WriteClassName)) {
                                        objectSerializer = objectWriter;
                                        objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                    } else {
                                        objectSerializer = objectWriter;
                                        objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                    }
                                    cls5 = cls3;
                                }
                                z12 = false;
                            } else {
                                list3 = this.propertyFilters;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!apply(jSONSerializer, obj, key, value)) {
                                        }
                                    } else if (!apply(jSONSerializer, obj, key, value)) {
                                    }
                                }
                                list4 = jSONSerializer.nameFilters;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    }
                                }
                                list5 = this.nameFilters;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    z11 = true;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                    obj3 = objProcessValue;
                                    r10 = z11;
                                } else {
                                    str2 = str;
                                    z11 = true;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                    obj3 = objProcessValue;
                                    r10 = z11;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str9 = str2;
                                    if (!z12) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                        jSONSerializer.println();
                                    }
                                    serializeWriter.writeFieldName(str9, r10);
                                } else {
                                    if (!z12) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    } else {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    }
                                    serializeWriter.write(58);
                                }
                                if (obj3 == null) {
                                    serializeWriter.writeNull();
                                    cls5 = cls5;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        cls3 = cls;
                                        objectWriter = jSONSerializer.getObjectWriter(cls);
                                    } else {
                                        cls3 = cls2;
                                        objectWriter = objectSerializer;
                                    }
                                    if (SerializerFeature.isEnabled(i6, SerializerFeature.WriteClassName)) {
                                        objectSerializer = objectWriter;
                                        objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                    } else {
                                        objectSerializer = objectWriter;
                                        objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                    }
                                    cls5 = cls3;
                                }
                                z12 = false;
                            }
                        }
                    } else if ((!key.getClass().isPrimitive() && !(key instanceof Number)) || applyName(jSONSerializer, obj, JSON.toJSONString(key))) {
                        list2 = jSONSerializer.propertyFilters;
                        if (list2 != null) {
                            list3 = this.propertyFilters;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!apply(jSONSerializer, obj, key, value)) {
                                    }
                                } else if (!apply(jSONSerializer, obj, key, value)) {
                                }
                            }
                            list4 = jSONSerializer.nameFilters;
                            if (list4 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj, key, value);
                                }
                            }
                            list5 = this.nameFilters;
                            if (list5 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                z11 = true;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                obj3 = objProcessValue;
                                r10 = z11;
                            } else {
                                str2 = str;
                                z11 = true;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                obj3 = objProcessValue;
                                r10 = z11;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str10 = str2;
                                if (!z12) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                    jSONSerializer.println();
                                }
                                serializeWriter.writeFieldName(str10, r10);
                            } else {
                                if (!z12) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                } else {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                }
                                serializeWriter.write(58);
                            }
                            if (obj3 == null) {
                                serializeWriter.writeNull();
                                cls5 = cls5;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    cls3 = cls;
                                    objectWriter = jSONSerializer.getObjectWriter(cls);
                                } else {
                                    cls3 = cls2;
                                    objectWriter = objectSerializer;
                                }
                                if (SerializerFeature.isEnabled(i6, SerializerFeature.WriteClassName)) {
                                    objectSerializer = objectWriter;
                                    objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                } else {
                                    objectSerializer = objectWriter;
                                    objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                }
                                cls5 = cls3;
                            }
                            z12 = false;
                        } else {
                            list3 = this.propertyFilters;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!apply(jSONSerializer, obj, key, value)) {
                                    }
                                } else if (!apply(jSONSerializer, obj, key, value)) {
                                }
                            }
                            list4 = jSONSerializer.nameFilters;
                            if (list4 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj, key, value);
                                }
                            }
                            list5 = this.nameFilters;
                            if (list5 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                z11 = true;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                obj3 = objProcessValue;
                                r10 = z11;
                            } else {
                                str2 = str;
                                z11 = true;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                obj3 = objProcessValue;
                                r10 = z11;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str11 = str2;
                                if (!z12) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                    jSONSerializer.println();
                                }
                                serializeWriter.writeFieldName(str11, r10);
                            } else {
                                if (!z12) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                } else {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                }
                                serializeWriter.write(58);
                            }
                            if (obj3 == null) {
                                serializeWriter.writeNull();
                                cls5 = cls5;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    cls3 = cls;
                                    objectWriter = jSONSerializer.getObjectWriter(cls);
                                } else {
                                    cls3 = cls2;
                                    objectWriter = objectSerializer;
                                }
                                if (SerializerFeature.isEnabled(i6, SerializerFeature.WriteClassName)) {
                                    objectSerializer = objectWriter;
                                    objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                } else {
                                    objectSerializer = objectWriter;
                                    objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                }
                                cls5 = cls3;
                            }
                            z12 = false;
                        }
                    }
                    cls5 = cls5;
                    obj = obj;
                    cls5 = cls5;
                }
            } else {
                if (key == null || (key instanceof String)) {
                    if (applyName(jSONSerializer, obj, key)) {
                        list = this.propertyPreFilters;
                        if (list != null) {
                            list2 = jSONSerializer.propertyFilters;
                            if (list2 != null) {
                                list3 = this.propertyFilters;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!apply(jSONSerializer, obj, key, value)) {
                                        }
                                    } else if (!apply(jSONSerializer, obj, key, value)) {
                                    }
                                }
                                list4 = jSONSerializer.nameFilters;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    }
                                }
                                list5 = this.nameFilters;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    z11 = true;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                    obj3 = objProcessValue;
                                    r10 = z11;
                                } else {
                                    str2 = str;
                                    z11 = true;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                    obj3 = objProcessValue;
                                    r10 = z11;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str12 = str2;
                                    if (!z12) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                        jSONSerializer.println();
                                    }
                                    serializeWriter.writeFieldName(str12, r10);
                                } else {
                                    if (!z12) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    } else {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    }
                                    serializeWriter.write(58);
                                }
                                if (obj3 == null) {
                                    serializeWriter.writeNull();
                                    cls5 = cls5;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        cls3 = cls;
                                        objectWriter = jSONSerializer.getObjectWriter(cls);
                                    } else {
                                        cls3 = cls2;
                                        objectWriter = objectSerializer;
                                    }
                                    if (SerializerFeature.isEnabled(i6, SerializerFeature.WriteClassName)) {
                                        objectSerializer = objectWriter;
                                        objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                    } else {
                                        objectSerializer = objectWriter;
                                        objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                    }
                                    cls5 = cls3;
                                }
                                z12 = false;
                            } else {
                                list3 = this.propertyFilters;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!apply(jSONSerializer, obj, key, value)) {
                                        }
                                    } else if (!apply(jSONSerializer, obj, key, value)) {
                                    }
                                }
                                list4 = jSONSerializer.nameFilters;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    }
                                }
                                list5 = this.nameFilters;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    z11 = true;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                    obj3 = objProcessValue;
                                    r10 = z11;
                                } else {
                                    str2 = str;
                                    z11 = true;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                    obj3 = objProcessValue;
                                    r10 = z11;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str13 = str2;
                                    if (!z12) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                        jSONSerializer.println();
                                    }
                                    serializeWriter.writeFieldName(str13, r10);
                                } else {
                                    if (!z12) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    } else {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    }
                                    serializeWriter.write(58);
                                }
                                if (obj3 == null) {
                                    serializeWriter.writeNull();
                                    cls5 = cls5;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        cls3 = cls;
                                        objectWriter = jSONSerializer.getObjectWriter(cls);
                                    } else {
                                        cls3 = cls2;
                                        objectWriter = objectSerializer;
                                    }
                                    if (SerializerFeature.isEnabled(i6, SerializerFeature.WriteClassName)) {
                                        objectSerializer = objectWriter;
                                        objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                    } else {
                                        objectSerializer = objectWriter;
                                        objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                    }
                                    cls5 = cls3;
                                }
                                z12 = false;
                            }
                        } else {
                            list2 = jSONSerializer.propertyFilters;
                            if (list2 != null) {
                                list3 = this.propertyFilters;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!apply(jSONSerializer, obj, key, value)) {
                                        }
                                    } else if (!apply(jSONSerializer, obj, key, value)) {
                                    }
                                }
                                list4 = jSONSerializer.nameFilters;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    }
                                }
                                list5 = this.nameFilters;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    z11 = true;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                    obj3 = objProcessValue;
                                    r10 = z11;
                                } else {
                                    str2 = str;
                                    z11 = true;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                    obj3 = objProcessValue;
                                    r10 = z11;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str14 = str2;
                                    if (!z12) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                        jSONSerializer.println();
                                    }
                                    serializeWriter.writeFieldName(str14, r10);
                                } else {
                                    if (!z12) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    } else {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    }
                                    serializeWriter.write(58);
                                }
                                if (obj3 == null) {
                                    serializeWriter.writeNull();
                                    cls5 = cls5;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        cls3 = cls;
                                        objectWriter = jSONSerializer.getObjectWriter(cls);
                                    } else {
                                        cls3 = cls2;
                                        objectWriter = objectSerializer;
                                    }
                                    if (SerializerFeature.isEnabled(i6, SerializerFeature.WriteClassName)) {
                                        objectSerializer = objectWriter;
                                        objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                    } else {
                                        objectSerializer = objectWriter;
                                        objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                    }
                                    cls5 = cls3;
                                }
                                z12 = false;
                            } else {
                                list3 = this.propertyFilters;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!apply(jSONSerializer, obj, key, value)) {
                                        }
                                    } else if (!apply(jSONSerializer, obj, key, value)) {
                                    }
                                }
                                list4 = jSONSerializer.nameFilters;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    }
                                }
                                list5 = this.nameFilters;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    z11 = true;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                    obj3 = objProcessValue;
                                    r10 = z11;
                                } else {
                                    str2 = str;
                                    z11 = true;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                    obj3 = objProcessValue;
                                    r10 = z11;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str15 = str2;
                                    if (!z12) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                        jSONSerializer.println();
                                    }
                                    serializeWriter.writeFieldName(str15, r10);
                                } else {
                                    if (!z12) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    } else {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    }
                                    serializeWriter.write(58);
                                }
                                if (obj3 == null) {
                                    serializeWriter.writeNull();
                                    cls5 = cls5;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        cls3 = cls;
                                        objectWriter = jSONSerializer.getObjectWriter(cls);
                                    } else {
                                        cls3 = cls2;
                                        objectWriter = objectSerializer;
                                    }
                                    if (SerializerFeature.isEnabled(i6, SerializerFeature.WriteClassName)) {
                                        objectSerializer = objectWriter;
                                        objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                    } else {
                                        objectSerializer = objectWriter;
                                        objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                    }
                                    cls5 = cls3;
                                }
                                z12 = false;
                            }
                        }
                    }
                } else if ((!key.getClass().isPrimitive() && !(key instanceof Number)) || applyName(jSONSerializer, obj, JSON.toJSONString(key))) {
                    list = this.propertyPreFilters;
                    if (list != null) {
                        list2 = jSONSerializer.propertyFilters;
                        if (list2 != null) {
                            list3 = this.propertyFilters;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!apply(jSONSerializer, obj, key, value)) {
                                    }
                                } else if (!apply(jSONSerializer, obj, key, value)) {
                                }
                            }
                            list4 = jSONSerializer.nameFilters;
                            if (list4 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj, key, value);
                                }
                            }
                            list5 = this.nameFilters;
                            if (list5 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                z11 = true;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                obj3 = objProcessValue;
                                r10 = z11;
                            } else {
                                str2 = str;
                                z11 = true;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                obj3 = objProcessValue;
                                r10 = z11;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str16 = str2;
                                if (!z12) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                    jSONSerializer.println();
                                }
                                serializeWriter.writeFieldName(str16, r10);
                            } else {
                                if (!z12) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                } else {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                }
                                serializeWriter.write(58);
                            }
                            if (obj3 == null) {
                                serializeWriter.writeNull();
                                cls5 = cls5;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    cls3 = cls;
                                    objectWriter = jSONSerializer.getObjectWriter(cls);
                                } else {
                                    cls3 = cls2;
                                    objectWriter = objectSerializer;
                                }
                                if (SerializerFeature.isEnabled(i6, SerializerFeature.WriteClassName)) {
                                    objectSerializer = objectWriter;
                                    objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                } else {
                                    objectSerializer = objectWriter;
                                    objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                }
                                cls5 = cls3;
                            }
                            z12 = false;
                        } else {
                            list3 = this.propertyFilters;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!apply(jSONSerializer, obj, key, value)) {
                                    }
                                } else if (!apply(jSONSerializer, obj, key, value)) {
                                }
                            }
                            list4 = jSONSerializer.nameFilters;
                            if (list4 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj, key, value);
                                }
                            }
                            list5 = this.nameFilters;
                            if (list5 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                z11 = true;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                obj3 = objProcessValue;
                                r10 = z11;
                            } else {
                                str2 = str;
                                z11 = true;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                obj3 = objProcessValue;
                                r10 = z11;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str17 = str2;
                                if (!z12) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                    jSONSerializer.println();
                                }
                                serializeWriter.writeFieldName(str17, r10);
                            } else {
                                if (!z12) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                } else {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                }
                                serializeWriter.write(58);
                            }
                            if (obj3 == null) {
                                serializeWriter.writeNull();
                                cls5 = cls5;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    cls3 = cls;
                                    objectWriter = jSONSerializer.getObjectWriter(cls);
                                } else {
                                    cls3 = cls2;
                                    objectWriter = objectSerializer;
                                }
                                if (SerializerFeature.isEnabled(i6, SerializerFeature.WriteClassName)) {
                                    objectSerializer = objectWriter;
                                    objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                } else {
                                    objectSerializer = objectWriter;
                                    objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                }
                                cls5 = cls3;
                            }
                            z12 = false;
                        }
                    } else {
                        list2 = jSONSerializer.propertyFilters;
                        if (list2 != null) {
                            list3 = this.propertyFilters;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!apply(jSONSerializer, obj, key, value)) {
                                    }
                                } else if (!apply(jSONSerializer, obj, key, value)) {
                                }
                            }
                            list4 = jSONSerializer.nameFilters;
                            if (list4 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj, key, value);
                                }
                            }
                            list5 = this.nameFilters;
                            if (list5 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                z11 = true;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                obj3 = objProcessValue;
                                r10 = z11;
                            } else {
                                str2 = str;
                                z11 = true;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                obj3 = objProcessValue;
                                r10 = z11;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str18 = str2;
                                if (!z12) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                    jSONSerializer.println();
                                }
                                serializeWriter.writeFieldName(str18, r10);
                            } else {
                                if (!z12) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                } else {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                }
                                serializeWriter.write(58);
                            }
                            if (obj3 == null) {
                                serializeWriter.writeNull();
                                cls5 = cls5;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    cls3 = cls;
                                    objectWriter = jSONSerializer.getObjectWriter(cls);
                                } else {
                                    cls3 = cls2;
                                    objectWriter = objectSerializer;
                                }
                                if (SerializerFeature.isEnabled(i6, SerializerFeature.WriteClassName)) {
                                    objectSerializer = objectWriter;
                                    objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                } else {
                                    objectSerializer = objectWriter;
                                    objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                }
                                cls5 = cls3;
                            }
                            z12 = false;
                        } else {
                            list3 = this.propertyFilters;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!apply(jSONSerializer, obj, key, value)) {
                                    }
                                } else if (!apply(jSONSerializer, obj, key, value)) {
                                }
                            }
                            list4 = jSONSerializer.nameFilters;
                            if (list4 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj, key, value);
                                }
                            }
                            list5 = this.nameFilters;
                            if (list5 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                z11 = true;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                obj3 = objProcessValue;
                                r10 = z11;
                            } else {
                                str2 = str;
                                z11 = true;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i6);
                                obj3 = objProcessValue;
                                r10 = z11;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str19 = str2;
                                if (!z12) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                    jSONSerializer.println();
                                }
                                serializeWriter.writeFieldName(str19, r10);
                            } else {
                                if (!z12) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                } else {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                }
                                serializeWriter.write(58);
                            }
                            if (obj3 == null) {
                                serializeWriter.writeNull();
                                cls5 = cls5;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    cls3 = cls;
                                    objectWriter = jSONSerializer.getObjectWriter(cls);
                                } else {
                                    cls3 = cls2;
                                    objectWriter = objectSerializer;
                                }
                                if (SerializerFeature.isEnabled(i6, SerializerFeature.WriteClassName)) {
                                    objectSerializer = objectWriter;
                                    objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                } else {
                                    objectSerializer = objectWriter;
                                    objectSerializer.write(jSONSerializer, obj3, str2, null, i6);
                                }
                                cls5 = cls3;
                            }
                            z12 = false;
                        }
                    }
                }
                cls5 = cls5;
                obj = obj;
                cls5 = cls5;
            }
        }
        jSONSerializer.context = serialContext;
        jSONSerializer.decrementIdent();
        if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat) && treeMap.size() > 0) {
            jSONSerializer.println();
        }
        if (z7) {
            return;
        }
        serializeWriter.write(125);
    }
}

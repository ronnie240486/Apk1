package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONPOJOBuilder;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p000a.AbstractC0004e;

public class JavaBeanInfo {
    public final Method buildMethod;
    public final Class<?> builderClass;
    public final Class<?> clazz;
    public final Constructor<?> creatorConstructor;
    public Type[] creatorConstructorParameterTypes;
    public String[] creatorConstructorParameters;
    public final Constructor<?> defaultConstructor;
    public final int defaultConstructorParameterSize;
    public final Method factoryMethod;
    public final FieldInfo[] fields;
    public final JSONType jsonType;

    public boolean f14845kotlin;
    public Constructor<?> kotlinDefaultConstructor;
    public String[] orders;
    public final int parserFeatures;
    public final FieldInfo[] sortedFields;
    public final String typeKey;
    public final String typeName;

    public JavaBeanInfo(Class<?> cls, Class<?> cls2, Constructor<?> constructor, Constructor<?> constructor2, Method method, Method method2, JSONType jSONType, List<FieldInfo> list) {
        JSONField jSONField;
        this.clazz = cls;
        this.builderClass = cls2;
        this.defaultConstructor = constructor;
        this.creatorConstructor = constructor2;
        this.factoryMethod = method;
        this.parserFeatures = TypeUtils.getParserFeatures(cls);
        this.buildMethod = method2;
        this.jsonType = jSONType;
        if (jSONType != null) {
            String strTypeName = jSONType.typeName();
            String strTypeKey = jSONType.typeKey();
            this.typeKey = strTypeKey.length() <= 0 ? null : strTypeKey;
            if (strTypeName.length() != 0) {
                this.typeName = strTypeName;
            } else {
                this.typeName = cls.getName();
            }
            String[] strArrOrders = jSONType.orders();
            this.orders = strArrOrders.length == 0 ? null : strArrOrders;
        } else {
            this.typeName = cls.getName();
            this.typeKey = null;
            this.orders = null;
        }
        FieldInfo[] fieldInfoArr = new FieldInfo[list.size()];
        this.fields = fieldInfoArr;
        list.toArray(fieldInfoArr);
        FieldInfo[] fieldInfoArr2 = new FieldInfo[fieldInfoArr.length];
        int i6 = 0;
        if (this.orders != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
            for (FieldInfo fieldInfo : fieldInfoArr) {
                linkedHashMap.put(fieldInfo.name, fieldInfo);
            }
            int i10 = 0;
            for (String str : this.orders) {
                FieldInfo fieldInfo2 = (FieldInfo) linkedHashMap.get(str);
                if (fieldInfo2 != null) {
                    fieldInfoArr2[i10] = fieldInfo2;
                    linkedHashMap.remove(str);
                    i10++;
                }
            }
            Iterator it = linkedHashMap.values().iterator();
            while (it.hasNext()) {
                fieldInfoArr2[i10] = (FieldInfo) it.next();
                i10++;
            }
        } else {
            System.arraycopy(fieldInfoArr, 0, fieldInfoArr2, 0, fieldInfoArr.length);
            Arrays.sort(fieldInfoArr2);
        }
        this.sortedFields = Arrays.equals(this.fields, fieldInfoArr2) ? this.fields : fieldInfoArr2;
        if (constructor != null) {
            this.defaultConstructorParameterSize = constructor.getParameterTypes().length;
        } else if (method != null) {
            this.defaultConstructorParameterSize = method.getParameterTypes().length;
        } else {
            this.defaultConstructorParameterSize = 0;
        }
        if (constructor2 != null) {
            this.creatorConstructorParameterTypes = constructor2.getParameterTypes();
            boolean zIsKotlin = TypeUtils.isKotlin(cls);
            this.f14845kotlin = zIsKotlin;
            if (!zIsKotlin) {
                if (this.creatorConstructorParameterTypes.length == this.fields.length) {
                    while (true) {
                        Type[] typeArr = this.creatorConstructorParameterTypes;
                        if (i6 >= typeArr.length) {
                            return;
                        }
                        if (typeArr[i6] == this.fields[i6].fieldClass) {
                            i6++;
                        }
                    }
                }
                this.creatorConstructorParameters = ASMUtils.lookupParameterNames(constructor2);
                return;
            }
            this.creatorConstructorParameters = TypeUtils.getKoltinConstructorParameters(cls);
            try {
                this.kotlinDefaultConstructor = cls.getConstructor(null);
            } catch (Throwable unused) {
            }
            Annotation[][] parameterAnnotations = TypeUtils.getParameterAnnotations(constructor2);
            for (int i11 = 0; i11 < this.creatorConstructorParameters.length && i11 < parameterAnnotations.length; i11++) {
                Annotation[] annotationArr = parameterAnnotations[i11];
                int length = annotationArr.length;
                int i12 = 0;
                while (true) {
                    if (i12 >= length) {
                        jSONField = null;
                        break;
                    }
                    Annotation annotation = annotationArr[i12];
                    if (annotation instanceof JSONField) {
                        jSONField = (JSONField) annotation;
                        break;
                    }
                    i12++;
                }
                if (jSONField != null) {
                    String strName = jSONField.name();
                    if (strName.length() > 0) {
                        this.creatorConstructorParameters[i11] = strName;
                    }
                }
            }
        }
    }

    public static boolean add(List<FieldInfo> list, FieldInfo fieldInfo) {
        for (int size = list.size() - 1; size >= 0; size--) {
            FieldInfo fieldInfo2 = list.get(size);
            if (fieldInfo2.name.equals(fieldInfo.name) && (!fieldInfo2.getOnly || fieldInfo.getOnly)) {
                if (fieldInfo2.fieldClass.isAssignableFrom(fieldInfo.fieldClass)) {
                    list.set(size, fieldInfo);
                    return true;
                }
                if (fieldInfo2.compareTo(fieldInfo) >= 0) {
                    return false;
                }
                list.set(size, fieldInfo);
                return true;
            }
        }
        list.add(fieldInfo);
        return true;
    }

    public static JavaBeanInfo build(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy) {
        return build(cls, type, propertyNamingStrategy, false, TypeUtils.compatibleWithJavaBean, false);
    }

    private static Map<TypeVariable, Type> buildGenericInfo(Class<?> cls) {
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap map = null;
        if (superclass == null) {
            return null;
        }
        while (true) {
            Class<? super Object> cls2 = superclass;
            Class<?> cls3 = cls;
            cls = cls2;
            if (cls == null || cls == Object.class) {
                break;
            }
            if (cls3.getGenericSuperclass() instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) cls3.getGenericSuperclass()).getActualTypeArguments();
                TypeVariable<Class<?>>[] typeParameters = cls.getTypeParameters();
                for (int i6 = 0; i6 < actualTypeArguments.length; i6++) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    if (map.containsKey(actualTypeArguments[i6])) {
                        map.put(typeParameters[i6], map.get(actualTypeArguments[i6]));
                    } else {
                        map.put(typeParameters[i6], actualTypeArguments[i6]);
                    }
                }
            }
            superclass = cls.getSuperclass();
        }
        return map;
    }

    private static void computeFields(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy, List<FieldInfo> list, Field[] fieldArr) {
        Iterator<FieldInfo> it;
        String name;
        JSONField jSONField;
        int i6;
        int i10;
        int i11;
        Map<TypeVariable, Type> mapBuildGenericInfo = buildGenericInfo(cls);
        int i12 = 0;
        for (int length = fieldArr.length; i12 < length; length = length) {
            Field field = fieldArr[i12];
            int modifiers = field.getModifiers();
            if ((modifiers & 8) != 0) {
                break;
                break;
            }
            if ((modifiers & 16) == 0) {
                it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        name = field.getName();
                        jSONField = (JSONField) TypeUtils.getAnnotation(field, JSONField.class);
                        if (jSONField != null) {
                            i6 = 0;
                            i10 = 0;
                            i11 = 0;
                        } else if (!jSONField.deserialize()) {
                            int iOrdinal = jSONField.ordinal();
                            int iM3460of = SerializerFeature.m3460of(jSONField.serialzeFeatures());
                            int iM3339of = Feature.m3339of(jSONField.parseFeatures());
                            if (jSONField.name().length() != 0) {
                                name = jSONField.name();
                            }
                            i6 = iOrdinal;
                            i10 = iM3460of;
                            i11 = iM3339of;
                        }
                        if (propertyNamingStrategy != null) {
                            name = propertyNamingStrategy.translate(name);
                        }
                        add(list, new FieldInfo(name, null, field, cls, type, i6, i10, i11, null, jSONField, null, mapBuildGenericInfo));
                        break;
                        break;
                    }
                    if (it.next().name.equals(field.getName())) {
                    }
                    break;
                    break;
                }
            }
            Class<?> type2 = field.getType();
            if (!Map.class.isAssignableFrom(type2) && !Collection.class.isAssignableFrom(type2) && !AtomicLong.class.equals(type2) && !AtomicInteger.class.equals(type2) && !AtomicBoolean.class.equals(type2)) {
                break;
                break;
            }
            it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    name = field.getName();
                    jSONField = (JSONField) TypeUtils.getAnnotation(field, JSONField.class);
                    if (jSONField != null) {
                        i6 = 0;
                        i10 = 0;
                        i11 = 0;
                    } else if (!jSONField.deserialize()) {
                        int iOrdinal2 = jSONField.ordinal();
                        int iM3460of2 = SerializerFeature.m3460of(jSONField.serialzeFeatures());
                        int iM3339of2 = Feature.m3339of(jSONField.parseFeatures());
                        if (jSONField.name().length() != 0) {
                            name = jSONField.name();
                        }
                        i6 = iOrdinal2;
                        i10 = iM3460of2;
                        i11 = iM3339of2;
                    }
                    if (propertyNamingStrategy != null) {
                        name = propertyNamingStrategy.translate(name);
                    }
                    add(list, new FieldInfo(name, null, field, cls, type, i6, i10, i11, null, jSONField, null, mapBuildGenericInfo));
                    break;
                }
                if (it.next().name.equals(field.getName())) {
                }
                break;
            }
            i12++;
        }
    }

    public static Class<?> getBuilderClass(JSONType jSONType) {
        return getBuilderClass(null, jSONType);
    }

    public static Constructor<?> getCreatorConstructor(Constructor[] constructorArr) {
        Constructor constructor = null;
        for (Constructor constructor2 : constructorArr) {
            if (((JSONCreator) constructor2.getAnnotation(JSONCreator.class)) != null) {
                if (constructor != null) {
                    throw new JSONException("multi-JSONCreator");
                }
                constructor = constructor2;
            }
        }
        if (constructor != null) {
            return constructor;
        }
        for (Constructor constructor3 : constructorArr) {
            Annotation[][] parameterAnnotations = TypeUtils.getParameterAnnotations(constructor3);
            if (parameterAnnotations.length != 0) {
                int length = parameterAnnotations.length;
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        if (constructor != null) {
                            throw new JSONException("multi-JSONCreator");
                        }
                        constructor = constructor3;
                        break;
                    }
                    Annotation[] annotationArr = parameterAnnotations[i6];
                    int length2 = annotationArr.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length2) {
                            break;
                        }
                        if (annotationArr[i10] instanceof JSONField) {
                            break;
                        }
                        i10++;
                    }
                    i6++;
                }
            }
        }
        return constructor;
    }

    public static Constructor<?> getDefaultConstructor(Class<?> cls, Constructor<?>[] constructorArr) {
        Constructor<?> constructor = null;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        for (Constructor<?> constructor2 : constructorArr) {
            if (constructor2.getParameterTypes().length == 0) {
                constructor = constructor2;
                break;
            }
        }
        if (constructor != null || !cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
            return constructor;
        }
        for (Constructor<?> constructor3 : constructorArr) {
            Class<?>[] parameterTypes = constructor3.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0].equals(cls.getDeclaringClass())) {
                return constructor3;
            }
        }
        return constructor;
    }

    private static Method getFactoryMethod(Class<?> cls, Method[] methodArr, boolean z7) {
        Method method = null;
        for (Method method2 : methodArr) {
            if (Modifier.isStatic(method2.getModifiers()) && cls.isAssignableFrom(method2.getReturnType()) && ((JSONCreator) TypeUtils.getAnnotation(method2, JSONCreator.class)) != null) {
                if (method != null) {
                    throw new JSONException("multi-JSONCreator");
                }
                method = method2;
            }
        }
        if (method != null || !z7) {
            return method;
        }
        for (Method method3 : methodArr) {
            if (TypeUtils.isJacksonCreator(method3)) {
                return method3;
            }
        }
        return method;
    }

    private static FieldInfo getField(List<FieldInfo> list, String str) {
        for (FieldInfo fieldInfo : list) {
            if (fieldInfo.name.equals(str)) {
                return fieldInfo;
            }
            Field field = fieldInfo.field;
            if (field != null && fieldInfo.getAnnotation() != null && field.getName().equals(str)) {
                return fieldInfo;
            }
        }
        return null;
    }

    public static JavaBeanInfo build(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy, boolean z7, boolean z10) {
        return build(cls, type, propertyNamingStrategy, z7, z10, false);
    }

    public static Class<?> getBuilderClass(Class<?> cls, JSONType jSONType) {
        Class<?> clsBuilder;
        if (cls != null && cls.getName().equals("org.springframework.security.web.savedrequest.DefaultSavedRequest")) {
            return TypeUtils.loadClass("org.springframework.security.web.savedrequest.DefaultSavedRequest$Builder");
        }
        if (jSONType == null || (clsBuilder = jSONType.builder()) == Void.class) {
            return null;
        }
        return clsBuilder;
    }

    public static JavaBeanInfo build(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy, boolean z7, boolean z10, boolean z11) {
        Constructor<?> defaultConstructor;
        Constructor<?> constructor;
        Class<?> cls2;
        Class<Collection> cls3;
        ArrayList arrayList;
        Field[] fieldArr;
        Class<String> cls4;
        Class<JSONField> cls5;
        Method[] methodArr;
        Constructor<?> constructor2;
        PropertyNamingStrategy propertyNamingStrategy2;
        String str;
        Class<JSONField> cls6;
        Field[] fieldArr2;
        Class<String> cls7;
        Field field;
        JSONType jSONType;
        Class<?> cls8;
        String str2;
        int i6;
        Class<Collection> cls9;
        Field[] fieldArr3;
        Class<JSONField> cls10;
        String propertyNameByMethodName;
        Field[] fieldArr4;
        Field field2;
        Class<?> cls11;
        Class<String> cls12;
        Class<JSONField> cls13;
        Class<?> cls14;
        JSONField superMethodAnnotation;
        char cCharAt;
        ?? arrayList2;
        Field[] fieldArr5;
        String propertyNameByMethodName2;
        Field field3;
        Field field4;
        int iOrdinal;
        int i10;
        int i11;
        ?? r10;
        PropertyNamingStrategy propertyNamingStrategy3;
        Class<JSONField> cls15;
        JSONField jSONField;
        int iM3460of;
        int iM3339of;
        int i12;
        int iOrdinal2;
        int iM3460of2;
        int iM3339of2;
        int i13;
        int i14;
        int i15;
        String str3;
        StringBuilder sb;
        String str4;
        String str5;
        char cCharAt2;
        Constructor<?> creatorConstructor;
        Class<?> cls16;
        Class<Collection> cls17;
        Class<String> cls18;
        Class<JSONField> cls19;
        Field[] fieldArr6;
        Class<?> cls20;
        Class<String> cls21;
        String[] strArrLookupParameterNames;
        Constructor<?>[] constructorArr;
        String[] strArrLookupParameterNames2;
        JSONField jSONField2;
        Class<JSONField> cls22;
        int iOrdinal3;
        int iM3460of3;
        int iM3339of3;
        JSONField jSONField3;
        String strName;
        int i16;
        int i17;
        int iM3339of4;
        Class<Collection> cls23;
        JSONField jSONField4;
        Field field5;
        String strName2;
        int i18;
        int i19;
        int i20;
        String str6;
        Constructor<?> creatorConstructor2;
        PropertyNamingStrategy propertyNamingStrategyNaming;
        Class<?> cls24 = cls;
        boolean z12 = z11;
        JSONType jSONType2 = (JSONType) TypeUtils.getAnnotation(cls24, JSONType.class);
        PropertyNamingStrategy propertyNamingStrategy4 = (jSONType2 == null || (propertyNamingStrategyNaming = jSONType2.naming()) == null || propertyNamingStrategyNaming == PropertyNamingStrategy.CamelCase) ? propertyNamingStrategy : propertyNamingStrategyNaming;
        Class<?> builderClass = getBuilderClass(cls24, jSONType2);
        Field[] declaredFields = cls.getDeclaredFields();
        Method[] methods = cls.getMethods();
        Map<TypeVariable, Type> mapBuildGenericInfo = buildGenericInfo(cls);
        boolean zIsKotlin = TypeUtils.isKotlin(cls);
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (!zIsKotlin || declaredConstructors.length == 1) {
            if (builderClass == null) {
                defaultConstructor = getDefaultConstructor(cls24, declaredConstructors);
            } else {
                defaultConstructor = getDefaultConstructor(builderClass, builderClass.getDeclaredConstructors());
            }
            constructor = defaultConstructor;
        } else {
            constructor = null;
        }
        ArrayList arrayList3 = new ArrayList();
        Method method = null;
        Method factoryMethod = null;
        if (z7) {
            for (Class<?> superclass = cls24; superclass != null; superclass = superclass.getSuperclass()) {
                computeFields(cls24, type, propertyNamingStrategy4, arrayList3, superclass.getDeclaredFields());
            }
            if (constructor != null) {
                TypeUtils.setAccessible(constructor);
            }
            return new JavaBeanInfo(cls, builderClass, constructor, null, null, null, jSONType2, arrayList3);
        }
        boolean z13 = cls.isInterface() || Modifier.isAbstract(cls.getModifiers());
        Class<Collection> cls25 = Collection.class;
        Class<?> cls26 = Object.class;
        PropertyNamingStrategy propertyNamingStrategy5 = propertyNamingStrategy4;
        Class<String> cls27 = String.class;
        Class<JSONField> cls28 = JSONField.class;
        if ((constructor == null && builderClass == null) || z13) {
            Type mixInAnnotations = JSON.getMixInAnnotations(cls);
            if (!(mixInAnnotations instanceof Class) || (creatorConstructor2 = getCreatorConstructor(((Class) mixInAnnotations).getConstructors())) == null) {
                creatorConstructor = null;
            } else {
                try {
                    creatorConstructor = cls24.getConstructor(creatorConstructor2.getParameterTypes());
                } catch (NoSuchMethodException unused) {
                    creatorConstructor = null;
                }
            }
            if (creatorConstructor == null) {
                creatorConstructor = getCreatorConstructor(declaredConstructors);
            }
            constructor2 = creatorConstructor;
            if (constructor2 != null && !z13) {
                TypeUtils.setAccessible(constructor2);
                Class<?>[] parameterTypes = constructor2.getParameterTypes();
                if (parameterTypes.length > 0) {
                    Annotation[][] parameterAnnotations = TypeUtils.getParameterAnnotations(constructor2);
                    String[] strArrLookupParameterNames3 = null;
                    int i21 = 0;
                    while (i21 < parameterTypes.length && i21 < parameterAnnotations.length) {
                        Annotation[] annotationArr = parameterAnnotations[i21];
                        int length = annotationArr.length;
                        Class<?> cls29 = cls26;
                        int i22 = 0;
                        while (true) {
                            cls23 = cls25;
                            if (i22 >= length) {
                                jSONField4 = null;
                                break;
                            }
                            Annotation annotation = annotationArr[i22];
                            Annotation[] annotationArr2 = annotationArr;
                            if (annotation instanceof JSONField) {
                                jSONField4 = (JSONField) annotation;
                                break;
                            }
                            i22++;
                            annotationArr = annotationArr2;
                            cls25 = cls23;
                        }
                        Class<?> cls30 = parameterTypes[i21];
                        Type type2 = constructor2.getGenericParameterTypes()[i21];
                        if (jSONField4 != null) {
                            field5 = TypeUtils.getField(cls24, jSONField4.name(), declaredFields);
                            int iOrdinal4 = jSONField4.ordinal();
                            int iM3460of4 = SerializerFeature.m3460of(jSONField4.serialzeFeatures());
                            int iM3339of5 = Feature.m3339of(jSONField4.parseFeatures());
                            strName2 = jSONField4.name();
                            i20 = iM3339of5;
                            i19 = iM3460of4;
                            i18 = iOrdinal4;
                        } else {
                            field5 = null;
                            strName2 = null;
                            i18 = 0;
                            i19 = 0;
                            i20 = 0;
                        }
                        if (strName2 == null || strName2.length() == 0) {
                            if (strArrLookupParameterNames3 == null) {
                                strArrLookupParameterNames3 = ASMUtils.lookupParameterNames(constructor2);
                            }
                            str6 = strArrLookupParameterNames3[i21];
                        } else {
                            str6 = strName2;
                        }
                        if (field5 == null) {
                            if (strArrLookupParameterNames3 == null) {
                                if (zIsKotlin) {
                                    strArrLookupParameterNames3 = TypeUtils.getKoltinConstructorParameters(cls);
                                } else {
                                    strArrLookupParameterNames3 = ASMUtils.lookupParameterNames(constructor2);
                                }
                            }
                            if (strArrLookupParameterNames3.length > i21) {
                                field5 = TypeUtils.getField(cls24, strArrLookupParameterNames3[i21], declaredFields);
                            }
                        }
                        ArrayList arrayList4 = arrayList3;
                        add(arrayList4, new FieldInfo(str6, cls, cls30, type2, field5, i18, i19, i20));
                        i21++;
                        parameterTypes = parameterTypes;
                        declaredFields = declaredFields;
                        arrayList3 = arrayList4;
                        methods = methods;
                        parameterAnnotations = parameterAnnotations;
                        cls26 = cls29;
                        cls27 = cls27;
                        strArrLookupParameterNames3 = strArrLookupParameterNames3;
                        cls28 = cls28;
                        cls25 = cls23;
                    }
                }
                cls16 = cls26;
                cls17 = cls25;
                arrayList = arrayList3;
                cls18 = cls27;
                cls19 = cls28;
                methodArr = methods;
                fieldArr6 = declaredFields;
            } else {
                cls16 = cls26;
                cls17 = cls25;
                arrayList = arrayList3;
                cls18 = cls27;
                cls19 = cls28;
                methodArr = methods;
                fieldArr6 = declaredFields;
                factoryMethod = getFactoryMethod(cls24, methodArr, z12);
                if (factoryMethod != null) {
                    TypeUtils.setAccessible(factoryMethod);
                    Class<?>[] parameterTypes2 = factoryMethod.getParameterTypes();
                    if (parameterTypes2.length > 0) {
                        Annotation[][] parameterAnnotations2 = TypeUtils.getParameterAnnotations(factoryMethod);
                        String[] strArrLookupParameterNames4 = null;
                        int i23 = 0;
                        while (i23 < parameterTypes2.length) {
                            Annotation[] annotationArr3 = parameterAnnotations2[i23];
                            int length2 = annotationArr3.length;
                            int i24 = 0;
                            while (true) {
                                if (i24 >= length2) {
                                    jSONField3 = null;
                                    break;
                                }
                                Annotation annotation2 = annotationArr3[i24];
                                if (annotation2 instanceof JSONField) {
                                    jSONField3 = (JSONField) annotation2;
                                    break;
                                }
                                i24++;
                            }
                            if (jSONField3 == null && (!z12 || !TypeUtils.isJacksonCreator(factoryMethod))) {
                                throw new JSONException("illegal json creator");
                            }
                            if (jSONField3 != null) {
                                strName = jSONField3.name();
                                int iOrdinal5 = jSONField3.ordinal();
                                int iM3460of5 = SerializerFeature.m3460of(jSONField3.serialzeFeatures());
                                iM3339of4 = Feature.m3339of(jSONField3.parseFeatures());
                                i16 = iOrdinal5;
                                i17 = iM3460of5;
                            } else {
                                strName = null;
                                i16 = 0;
                                i17 = 0;
                                iM3339of4 = 0;
                            }
                            if (strName == null || strName.length() == 0) {
                                if (strArrLookupParameterNames4 == null) {
                                    strArrLookupParameterNames4 = ASMUtils.lookupParameterNames(factoryMethod);
                                }
                                strName = strArrLookupParameterNames4[i23];
                            }
                            String[] strArr = strArrLookupParameterNames4;
                            add(arrayList, new FieldInfo(strName, cls, parameterTypes2[i23], factoryMethod.getGenericParameterTypes()[i23], TypeUtils.getField(cls24, strName, fieldArr6), i16, i17, iM3339of4));
                            i23++;
                            z12 = z11;
                            parameterTypes2 = parameterTypes2;
                            strArrLookupParameterNames4 = strArr;
                        }
                        return new JavaBeanInfo(cls, builderClass, null, null, factoryMethod, null, jSONType2, arrayList);
                    }
                } else if (!z13) {
                    String name = cls.getName();
                    if (zIsKotlin && declaredConstructors.length > 0) {
                        String[] koltinConstructorParameters = TypeUtils.getKoltinConstructorParameters(cls);
                        Constructor<?> kotlinConstructor = TypeUtils.getKotlinConstructor(declaredConstructors, koltinConstructorParameters);
                        TypeUtils.setAccessible(kotlinConstructor);
                        constructor2 = kotlinConstructor;
                        strArrLookupParameterNames = koltinConstructorParameters;
                        cls20 = cls16;
                        cls21 = cls18;
                    } else {
                        int length3 = declaredConstructors.length;
                        int i25 = 0;
                        String[] strArr2 = null;
                        while (true) {
                            if (i25 >= length3) {
                                cls20 = cls16;
                                cls21 = cls18;
                                strArrLookupParameterNames = strArr2;
                                break;
                            }
                            Constructor<?> constructor3 = declaredConstructors[i25];
                            Class<?>[] parameterTypes3 = constructor3.getParameterTypes();
                            if (name.equals("org.springframework.security.web.authentication.WebAuthenticationDetails")) {
                                if (parameterTypes3.length == 2) {
                                    cls21 = cls18;
                                    if (parameterTypes3[0] == cls21 && parameterTypes3[1] == cls21) {
                                        constructor3.setAccessible(true);
                                        strArrLookupParameterNames = ASMUtils.lookupParameterNames(constructor3);
                                        constructor2 = constructor3;
                                        cls20 = cls16;
                                        break;
                                    }
                                } else {
                                    cls21 = cls18;
                                }
                                constructorArr = declaredConstructors;
                                cls20 = cls16;
                                i25++;
                                cls16 = cls20;
                                cls18 = cls21;
                                declaredConstructors = constructorArr;
                            } else {
                                cls21 = cls18;
                                if (name.equals("org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken")) {
                                    if (parameterTypes3.length == 3) {
                                        cls20 = cls16;
                                        constructorArr = declaredConstructors;
                                        if (parameterTypes3[0] == cls20 && parameterTypes3[1] == cls20) {
                                            Class<Collection> cls31 = cls17;
                                            if (parameterTypes3[2] == cls31) {
                                                constructor3.setAccessible(true);
                                                cls17 = cls31;
                                                constructor2 = constructor3;
                                                strArrLookupParameterNames = new String[]{"principal", "credentials", "authorities"};
                                                break;
                                            }
                                            cls17 = cls31;
                                        }
                                    } else {
                                        constructorArr = declaredConstructors;
                                        cls20 = cls16;
                                    }
                                    i25++;
                                    cls16 = cls20;
                                    cls18 = cls21;
                                    declaredConstructors = constructorArr;
                                } else {
                                    constructorArr = declaredConstructors;
                                    cls20 = cls16;
                                    Class<Collection> cls32 = cls17;
                                    if (name.equals("org.springframework.security.core.authority.SimpleGrantedAuthority")) {
                                        cls17 = cls32;
                                        if (parameterTypes3.length == 1 && parameterTypes3[0] == cls21) {
                                            strArrLookupParameterNames = new String[]{"authority"};
                                            constructor2 = constructor3;
                                            break;
                                        }
                                    } else {
                                        cls17 = cls32;
                                        if ((constructor3.getModifiers() & 1) != 0 && (strArrLookupParameterNames2 = ASMUtils.lookupParameterNames(constructor3)) != null && strArrLookupParameterNames2.length != 0 && (constructor2 == null || strArr2 == null || strArrLookupParameterNames2.length > strArr2.length)) {
                                            strArr2 = strArrLookupParameterNames2;
                                            constructor2 = constructor3;
                                        }
                                    }
                                    i25++;
                                    cls16 = cls20;
                                    cls18 = cls21;
                                    declaredConstructors = constructorArr;
                                }
                            }
                        }
                    }
                    Class<?>[] parameterTypes4 = strArrLookupParameterNames != null ? constructor2.getParameterTypes() : null;
                    if (strArrLookupParameterNames != null && parameterTypes4.length == strArrLookupParameterNames.length) {
                        Annotation[][] parameterAnnotations3 = TypeUtils.getParameterAnnotations(constructor2);
                        int i26 = 0;
                        while (i26 < parameterTypes4.length) {
                            Annotation[] annotationArr4 = parameterAnnotations3[i26];
                            String str7 = strArrLookupParameterNames[i26];
                            int length4 = annotationArr4.length;
                            int i27 = 0;
                            while (true) {
                                if (i27 >= length4) {
                                    jSONField2 = null;
                                    break;
                                }
                                int i28 = length4;
                                Annotation annotation3 = annotationArr4[i27];
                                Annotation[] annotationArr5 = annotationArr4;
                                if (annotation3 instanceof JSONField) {
                                    jSONField2 = (JSONField) annotation3;
                                    break;
                                }
                                i27++;
                                annotationArr4 = annotationArr5;
                                length4 = i28;
                            }
                            Class<?> cls33 = parameterTypes4[i26];
                            Type type3 = constructor2.getGenericParameterTypes()[i26];
                            Field field6 = TypeUtils.getField(cls24, str7, fieldArr6);
                            if (field6 == null || jSONField2 != null) {
                                cls22 = cls19;
                            } else {
                                cls22 = cls19;
                                jSONField2 = (JSONField) TypeUtils.getAnnotation(field6, cls22);
                            }
                            if (jSONField2 == null) {
                                if ("org.springframework.security.core.userdetails.User".equals(name) && "password".equals(str7)) {
                                    iM3339of3 = Feature.InitStringFieldAsEmpty.mask;
                                    iOrdinal3 = 0;
                                    iM3460of3 = 0;
                                } else {
                                    iOrdinal3 = 0;
                                    iM3460of3 = 0;
                                    iM3339of3 = 0;
                                }
                            } else {
                                String strName3 = jSONField2.name();
                                if (strName3.length() != 0) {
                                    str7 = strName3;
                                }
                                iOrdinal3 = jSONField2.ordinal();
                                iM3460of3 = SerializerFeature.m3460of(jSONField2.serialzeFeatures());
                                iM3339of3 = Feature.m3339of(jSONField2.parseFeatures());
                            }
                            add(arrayList, new FieldInfo(str7, cls, cls33, type3, field6, iOrdinal3, iM3460of3, iM3339of3));
                            i26++;
                            cls19 = cls22;
                            parameterTypes4 = parameterTypes4;
                            fieldArr6 = fieldArr6;
                            strArrLookupParameterNames = strArrLookupParameterNames;
                            cls21 = cls21;
                            cls20 = cls20;
                        }
                        cls2 = cls20;
                        cls4 = cls21;
                        fieldArr = fieldArr6;
                        cls5 = cls19;
                        cls3 = cls17;
                        if (!zIsKotlin && !cls.getName().equals("javax.servlet.http.Cookie")) {
                            return new JavaBeanInfo(cls, builderClass, null, constructor2, null, null, jSONType2, arrayList);
                        }
                    } else {
                        throw new JSONException(AbstractC0004e.m23q(cls24, "default constructor not found. "));
                    }
                }
            }
            cls2 = cls16;
            cls4 = cls18;
            cls3 = cls17;
            fieldArr = fieldArr6;
            cls5 = cls19;
        } else {
            cls2 = cls26;
            cls3 = cls25;
            arrayList = arrayList3;
            fieldArr = declaredFields;
            cls4 = cls27;
            cls5 = cls28;
            methodArr = methods;
            constructor2 = null;
        }
        if (constructor != null) {
            TypeUtils.setAccessible(constructor);
        }
        String str8 = "set";
        if (builderClass == null) {
            propertyNamingStrategy2 = propertyNamingStrategy5;
            str = "set";
            cls6 = cls5;
            fieldArr2 = fieldArr;
            cls7 = cls4;
            field = null;
            jSONType = jSONType2;
            cls8 = builderClass;
        } else {
            Class<JSONPOJOBuilder> cls34 = JSONPOJOBuilder.class;
            JSONPOJOBuilder jSONPOJOBuilder = (JSONPOJOBuilder) TypeUtils.getAnnotation(builderClass, cls34);
            String strWithPrefix = jSONPOJOBuilder != null ? jSONPOJOBuilder.withPrefix() : null;
            if (strWithPrefix == null) {
                strWithPrefix = "with";
            }
            String str9 = strWithPrefix;
            Method[] methods2 = builderClass.getMethods();
            int length5 = methods2.length;
            int i29 = 0;
            while (i29 < length5) {
                Method method2 = methods2[i29];
                if (!Modifier.isStatic(method2.getModifiers()) && method2.getReturnType().equals(builderClass)) {
                    JSONField superMethodAnnotation2 = (JSONField) TypeUtils.getAnnotation(method2, cls5);
                    if (superMethodAnnotation2 == null) {
                        superMethodAnnotation2 = TypeUtils.getSuperMethodAnnotation(cls24, method2);
                    }
                    JSONField jSONField5 = superMethodAnnotation2;
                    if (jSONField5 == null) {
                        i13 = 0;
                        i14 = 0;
                        i15 = 0;
                    } else if (jSONField5.deserialize()) {
                        int iOrdinal6 = jSONField5.ordinal();
                        int iM3460of6 = SerializerFeature.m3460of(jSONField5.serialzeFeatures());
                        int iM3339of6 = Feature.m3339of(jSONField5.parseFeatures());
                        if (jSONField5.name().length() != 0) {
                            i29 = i29;
                            length5 = length5;
                            methods2 = methods2;
                            cls34 = cls34;
                            builderClass = builderClass;
                            propertyNamingStrategy5 = propertyNamingStrategy5;
                            cls5 = cls5;
                            fieldArr = fieldArr;
                            cls4 = cls4;
                            jSONType2 = jSONType2;
                            add(arrayList, new FieldInfo(jSONField5.name(), method2, null, cls, type, iOrdinal6, iM3460of6, iM3339of6, jSONField5, null, null, mapBuildGenericInfo));
                            str4 = str9;
                            str5 = str8;
                        } else {
                            i13 = iOrdinal6;
                            i14 = iM3460of6;
                            i15 = iM3339of6;
                        }
                    } else {
                        propertyNamingStrategy5 = propertyNamingStrategy5;
                        i29 = i29;
                        length5 = length5;
                        methods2 = methods2;
                        str4 = str9;
                        cls34 = cls34;
                        str5 = str8;
                        builderClass = builderClass;
                        cls5 = cls5;
                        fieldArr = fieldArr;
                        cls4 = cls4;
                        jSONType2 = jSONType2;
                    }
                    String name2 = method2.getName();
                    String str10 = str8;
                    if (name2.startsWith(str10) && name2.length() > 3) {
                        sb = new StringBuilder(name2.substring(3));
                    } else {
                        if (str9.length() == 0) {
                            sb = new StringBuilder(name2);
                        } else {
                            str3 = str9;
                            if (name2.startsWith(str3) && name2.length() > str3.length()) {
                                sb = new StringBuilder(name2.substring(str3.length()));
                                cCharAt2 = sb.charAt(0);
                                if (str3.length() != 0 || Character.isUpperCase(cCharAt2)) {
                                    sb.setCharAt(0, Character.toLowerCase(cCharAt2));
                                    str4 = str3;
                                    str5 = str10;
                                    add(arrayList, new FieldInfo(sb.toString(), method2, null, cls, type, i13, i14, i15, jSONField5, null, null, mapBuildGenericInfo));
                                }
                            }
                        }
                        str4 = str3;
                        str5 = str10;
                    }
                    str3 = str9;
                    cCharAt2 = sb.charAt(0);
                    if (str3.length() != 0) {
                    }
                    sb.setCharAt(0, Character.toLowerCase(cCharAt2));
                    str4 = str3;
                    str5 = str10;
                    add(arrayList, new FieldInfo(sb.toString(), method2, null, cls, type, i13, i14, i15, jSONField5, null, null, mapBuildGenericInfo));
                } else {
                    propertyNamingStrategy5 = propertyNamingStrategy5;
                    i29 = i29;
                    length5 = length5;
                    methods2 = methods2;
                    str4 = str9;
                    cls34 = cls34;
                    str5 = str8;
                    builderClass = builderClass;
                    cls5 = cls5;
                    fieldArr = fieldArr;
                    cls4 = cls4;
                    jSONType2 = jSONType2;
                }
                i29++;
                str9 = str4;
                jSONType2 = jSONType2;
                length5 = length5;
                methods2 = methods2;
                cls34 = cls34;
                builderClass = builderClass;
                propertyNamingStrategy5 = propertyNamingStrategy5;
                fieldArr = fieldArr;
                cls4 = cls4;
                cls5 = cls5;
                str8 = str5;
            }
            propertyNamingStrategy2 = propertyNamingStrategy5;
            str = str8;
            cls6 = cls5;
            fieldArr2 = fieldArr;
            cls7 = cls4;
            jSONType = jSONType2;
            cls8 = builderClass;
            JSONPOJOBuilder jSONPOJOBuilder2 = (JSONPOJOBuilder) TypeUtils.getAnnotation(cls8, cls34);
            String strBuildMethod = jSONPOJOBuilder2 != null ? jSONPOJOBuilder2.buildMethod() : null;
            if (strBuildMethod == null || strBuildMethod.length() == 0) {
                strBuildMethod = "build";
            }
            field = null;
            try {
                method = cls8.getMethod(strBuildMethod, null);
            } catch (NoSuchMethodException | SecurityException unused2) {
            }
            if (method == null) {
                try {
                    method = cls8.getMethod("create", null);
                } catch (NoSuchMethodException | SecurityException unused3) {
                }
            }
            if (method != null) {
                TypeUtils.setAccessible(method);
            } else {
                throw new JSONException("buildMethod not found.");
            }
        }
        int length6 = methodArr.length;
        int i30 = 0;
        while (true) {
            str2 = "get";
            i6 = 4;
            if (i30 >= length6) {
                break;
            }
            Method method3 = methodArr[i30];
            String name3 = method3.getName();
            if (Modifier.isStatic(method3.getModifiers())) {
                cls11 = cls2;
                cls12 = cls7;
                cls13 = cls6;
                cls14 = cls24;
            } else {
                Class<?> returnType = method3.getReturnType();
                if (returnType.equals(Void.TYPE) || returnType.equals(method3.getDeclaringClass())) {
                    cls11 = cls2;
                    if (method3.getDeclaringClass() != cls11) {
                        Class<?>[] parameterTypes5 = method3.getParameterTypes();
                        if (parameterTypes5.length == 0) {
                            cls11 = cls11;
                            i30 = i30;
                            length6 = length6;
                            field = field;
                            cls8 = cls8;
                            methodArr = methodArr;
                            propertyNamingStrategy2 = propertyNamingStrategy2;
                            cls12 = cls7;
                            cls13 = cls6;
                            str = str;
                            cls14 = cls24;
                        } else if (parameterTypes5.length <= 2) {
                            Class<JSONField> cls35 = cls6;
                            JSONField jSONField6 = (JSONField) TypeUtils.getAnnotation(method3, cls35);
                            int i31 = 0;
                            int i32 = 0;
                            int i33 = 0;
                            if (jSONField6 == null || parameterTypes5.length != 2) {
                                cls12 = cls7;
                            } else {
                                Class<String> cls36 = cls7;
                                if (parameterTypes5[0] != cls36) {
                                    cls12 = cls36;
                                } else if (parameterTypes5[1] == cls11) {
                                    cls12 = cls36;
                                    cls11 = cls11;
                                    cls35 = cls35;
                                    i30 = i30;
                                    length6 = length6;
                                    field = null;
                                    cls8 = cls8;
                                    add(arrayList, new FieldInfo("", method3, null, cls, type, 0, 0, 0, jSONField6, null, null, mapBuildGenericInfo));
                                } else {
                                    cls12 = cls36;
                                    cls35 = cls35;
                                    cls11 = cls11;
                                    i30 = i30;
                                    length6 = length6;
                                    cls8 = cls8;
                                    field = null;
                                    if (parameterTypes5.length == 1) {
                                        if (jSONField6 == null) {
                                            superMethodAnnotation = TypeUtils.getSuperMethodAnnotation(cls24, method3);
                                        } else {
                                            superMethodAnnotation = jSONField6;
                                        }
                                        if (superMethodAnnotation == null || name3.length() >= 4) {
                                            if (superMethodAnnotation != null) {
                                                if (superMethodAnnotation.deserialize()) {
                                                    iOrdinal2 = superMethodAnnotation.ordinal();
                                                    iM3460of2 = SerializerFeature.m3460of(superMethodAnnotation.serialzeFeatures());
                                                    iM3339of2 = Feature.m3339of(superMethodAnnotation.parseFeatures());
                                                    if (superMethodAnnotation.name().length() != 0) {
                                                        add(arrayList, new FieldInfo(superMethodAnnotation.name(), method3, null, cls, type, iOrdinal2, iM3460of2, iM3339of2, superMethodAnnotation, null, null, mapBuildGenericInfo));
                                                        str = str;
                                                    } else {
                                                        i31 = iOrdinal2;
                                                        i32 = iM3460of2;
                                                        i33 = iM3339of2;
                                                        str = str;
                                                        if (superMethodAnnotation == null) {
                                                            cCharAt = name3.charAt(3);
                                                            if (zIsKotlin) {
                                                                arrayList2 = new ArrayList();
                                                                for (i12 = 0; i12 < methodArr.length; i12++) {
                                                                    if (methodArr[i12].getName().startsWith("get")) {
                                                                        arrayList2.add(methodArr[i12].getName());
                                                                    }
                                                                }
                                                            } else {
                                                                arrayList2 = field;
                                                            }
                                                            if (!Character.isUpperCase(cCharAt)) {
                                                                cls14 = cls;
                                                                fieldArr5 = fieldArr2;
                                                                if (zIsKotlin) {
                                                                    propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName("g" + name3.substring(1));
                                                                    field3 = field;
                                                                } else {
                                                                    if (TypeUtils.compatibleWithJavaBean) {
                                                                        propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                                                    } else {
                                                                        propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name3);
                                                                    }
                                                                    field3 = field;
                                                                }
                                                                if (field3 == null) {
                                                                    field3 = TypeUtils.getField(cls14, propertyNameByMethodName2, fieldArr5);
                                                                }
                                                                if (field3 == null) {
                                                                    field4 = field3;
                                                                } else {
                                                                    field4 = field3;
                                                                }
                                                                if (field4 != null) {
                                                                    cls15 = cls35;
                                                                    jSONField = (JSONField) TypeUtils.getAnnotation(field4, cls15);
                                                                    if (jSONField == null) {
                                                                        cls13 = cls15;
                                                                        r10 = jSONField;
                                                                        iOrdinal = i31;
                                                                        i10 = i32;
                                                                        i11 = i33;
                                                                    } else if (jSONField.deserialize()) {
                                                                        iOrdinal = jSONField.ordinal();
                                                                        iM3460of = SerializerFeature.m3460of(jSONField.serialzeFeatures());
                                                                        iM3339of = Feature.m3339of(jSONField.parseFeatures());
                                                                        if (jSONField.name().length() != 0) {
                                                                            cls13 = cls15;
                                                                            str = str;
                                                                            methodArr = methodArr;
                                                                            cls14 = cls14;
                                                                            add(arrayList, new FieldInfo(jSONField.name(), method3, field4, cls, type, iOrdinal, iM3460of, iM3339of, superMethodAnnotation, jSONField, null, mapBuildGenericInfo));
                                                                            fieldArr2 = fieldArr5;
                                                                            propertyNamingStrategy2 = propertyNamingStrategy2;
                                                                        } else {
                                                                            cls13 = cls15;
                                                                            r10 = jSONField;
                                                                            i10 = iM3460of;
                                                                            i11 = iM3339of;
                                                                        }
                                                                    } else {
                                                                        cls13 = cls15;
                                                                        fieldArr2 = fieldArr5;
                                                                    }
                                                                } else {
                                                                    cls13 = cls35;
                                                                    iOrdinal = i31;
                                                                    i10 = i32;
                                                                    i11 = i33;
                                                                    r10 = field;
                                                                }
                                                                propertyNamingStrategy3 = propertyNamingStrategy2;
                                                                if (propertyNamingStrategy3 != null) {
                                                                    propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                                                }
                                                                fieldArr2 = fieldArr5;
                                                                propertyNamingStrategy2 = propertyNamingStrategy3;
                                                                add(arrayList, new FieldInfo(propertyNameByMethodName2, method3, field4, cls, type, iOrdinal, i10, i11, superMethodAnnotation, r10, null, mapBuildGenericInfo));
                                                            } else {
                                                                cls14 = cls;
                                                                fieldArr5 = fieldArr2;
                                                                if (zIsKotlin) {
                                                                    propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName("g" + name3.substring(1));
                                                                    field3 = field;
                                                                } else {
                                                                    if (TypeUtils.compatibleWithJavaBean) {
                                                                        propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                                                    } else {
                                                                        propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name3);
                                                                    }
                                                                    field3 = field;
                                                                }
                                                                if (field3 == null) {
                                                                    field3 = TypeUtils.getField(cls14, propertyNameByMethodName2, fieldArr5);
                                                                }
                                                                if (field3 == null) {
                                                                    field4 = field3;
                                                                } else {
                                                                    field4 = field3;
                                                                }
                                                                if (field4 != null) {
                                                                    cls15 = cls35;
                                                                    jSONField = (JSONField) TypeUtils.getAnnotation(field4, cls15);
                                                                    if (jSONField == null) {
                                                                        cls13 = cls15;
                                                                        r10 = jSONField;
                                                                        iOrdinal = i31;
                                                                        i10 = i32;
                                                                        i11 = i33;
                                                                    } else if (jSONField.deserialize()) {
                                                                        cls13 = cls15;
                                                                        fieldArr2 = fieldArr5;
                                                                    } else {
                                                                        iOrdinal = jSONField.ordinal();
                                                                        iM3460of = SerializerFeature.m3460of(jSONField.serialzeFeatures());
                                                                        iM3339of = Feature.m3339of(jSONField.parseFeatures());
                                                                        if (jSONField.name().length() != 0) {
                                                                            cls13 = cls15;
                                                                            str = str;
                                                                            methodArr = methodArr;
                                                                            cls14 = cls14;
                                                                            add(arrayList, new FieldInfo(jSONField.name(), method3, field4, cls, type, iOrdinal, iM3460of, iM3339of, superMethodAnnotation, jSONField, null, mapBuildGenericInfo));
                                                                            fieldArr2 = fieldArr5;
                                                                            propertyNamingStrategy2 = propertyNamingStrategy2;
                                                                        } else {
                                                                            cls13 = cls15;
                                                                            r10 = jSONField;
                                                                            i10 = iM3460of;
                                                                            i11 = iM3339of;
                                                                        }
                                                                    }
                                                                } else {
                                                                    cls13 = cls35;
                                                                    iOrdinal = i31;
                                                                    i10 = i32;
                                                                    i11 = i33;
                                                                    r10 = field;
                                                                }
                                                                propertyNamingStrategy3 = propertyNamingStrategy2;
                                                                if (propertyNamingStrategy3 != null) {
                                                                    propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                                                }
                                                                fieldArr2 = fieldArr5;
                                                                propertyNamingStrategy2 = propertyNamingStrategy3;
                                                                add(arrayList, new FieldInfo(propertyNameByMethodName2, method3, field4, cls, type, iOrdinal, i10, i11, superMethodAnnotation, r10, null, mapBuildGenericInfo));
                                                            }
                                                            cls14 = cls14;
                                                        } else {
                                                            cCharAt = name3.charAt(3);
                                                            if (zIsKotlin) {
                                                                arrayList2 = new ArrayList();
                                                                while (i12 < methodArr.length) {
                                                                    if (methodArr[i12].getName().startsWith("get")) {
                                                                        arrayList2.add(methodArr[i12].getName());
                                                                    }
                                                                }
                                                            } else {
                                                                arrayList2 = field;
                                                            }
                                                            if (!Character.isUpperCase(cCharAt)) {
                                                                cls14 = cls;
                                                                fieldArr5 = fieldArr2;
                                                                if (zIsKotlin) {
                                                                    propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName("g" + name3.substring(1));
                                                                    field3 = field;
                                                                } else {
                                                                    if (TypeUtils.compatibleWithJavaBean) {
                                                                        propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                                                    } else {
                                                                        propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name3);
                                                                    }
                                                                    field3 = field;
                                                                }
                                                                if (field3 == null) {
                                                                    field3 = TypeUtils.getField(cls14, propertyNameByMethodName2, fieldArr5);
                                                                }
                                                                if (field3 == null) {
                                                                    field4 = field3;
                                                                } else {
                                                                    field4 = field3;
                                                                }
                                                                if (field4 != null) {
                                                                    cls15 = cls35;
                                                                    jSONField = (JSONField) TypeUtils.getAnnotation(field4, cls15);
                                                                    if (jSONField == null) {
                                                                        cls13 = cls15;
                                                                        r10 = jSONField;
                                                                        iOrdinal = i31;
                                                                        i10 = i32;
                                                                        i11 = i33;
                                                                    } else if (jSONField.deserialize()) {
                                                                        cls13 = cls15;
                                                                        fieldArr2 = fieldArr5;
                                                                    } else {
                                                                        iOrdinal = jSONField.ordinal();
                                                                        iM3460of = SerializerFeature.m3460of(jSONField.serialzeFeatures());
                                                                        iM3339of = Feature.m3339of(jSONField.parseFeatures());
                                                                        if (jSONField.name().length() != 0) {
                                                                            cls13 = cls15;
                                                                            str = str;
                                                                            methodArr = methodArr;
                                                                            cls14 = cls14;
                                                                            add(arrayList, new FieldInfo(jSONField.name(), method3, field4, cls, type, iOrdinal, iM3460of, iM3339of, superMethodAnnotation, jSONField, null, mapBuildGenericInfo));
                                                                            fieldArr2 = fieldArr5;
                                                                            propertyNamingStrategy2 = propertyNamingStrategy2;
                                                                        } else {
                                                                            cls13 = cls15;
                                                                            r10 = jSONField;
                                                                            i10 = iM3460of;
                                                                            i11 = iM3339of;
                                                                        }
                                                                    }
                                                                } else {
                                                                    cls13 = cls35;
                                                                    iOrdinal = i31;
                                                                    i10 = i32;
                                                                    i11 = i33;
                                                                    r10 = field;
                                                                }
                                                                propertyNamingStrategy3 = propertyNamingStrategy2;
                                                                if (propertyNamingStrategy3 != null) {
                                                                    propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                                                }
                                                                fieldArr2 = fieldArr5;
                                                                propertyNamingStrategy2 = propertyNamingStrategy3;
                                                                add(arrayList, new FieldInfo(propertyNameByMethodName2, method3, field4, cls, type, iOrdinal, i10, i11, superMethodAnnotation, r10, null, mapBuildGenericInfo));
                                                            } else {
                                                                cls14 = cls;
                                                                fieldArr5 = fieldArr2;
                                                                if (zIsKotlin) {
                                                                    propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName("g" + name3.substring(1));
                                                                    field3 = field;
                                                                } else {
                                                                    if (TypeUtils.compatibleWithJavaBean) {
                                                                        propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                                                    } else {
                                                                        propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name3);
                                                                    }
                                                                    field3 = field;
                                                                }
                                                                if (field3 == null) {
                                                                    field3 = TypeUtils.getField(cls14, propertyNameByMethodName2, fieldArr5);
                                                                }
                                                                if (field3 == null) {
                                                                    field4 = field3;
                                                                } else {
                                                                    field4 = field3;
                                                                }
                                                                if (field4 != null) {
                                                                    cls15 = cls35;
                                                                    jSONField = (JSONField) TypeUtils.getAnnotation(field4, cls15);
                                                                    if (jSONField == null) {
                                                                        cls13 = cls15;
                                                                        r10 = jSONField;
                                                                        iOrdinal = i31;
                                                                        i10 = i32;
                                                                        i11 = i33;
                                                                    } else if (jSONField.deserialize()) {
                                                                        cls13 = cls15;
                                                                        fieldArr2 = fieldArr5;
                                                                    } else {
                                                                        iOrdinal = jSONField.ordinal();
                                                                        iM3460of = SerializerFeature.m3460of(jSONField.serialzeFeatures());
                                                                        iM3339of = Feature.m3339of(jSONField.parseFeatures());
                                                                        if (jSONField.name().length() != 0) {
                                                                            cls13 = cls15;
                                                                            str = str;
                                                                            methodArr = methodArr;
                                                                            cls14 = cls14;
                                                                            add(arrayList, new FieldInfo(jSONField.name(), method3, field4, cls, type, iOrdinal, iM3460of, iM3339of, superMethodAnnotation, jSONField, null, mapBuildGenericInfo));
                                                                            fieldArr2 = fieldArr5;
                                                                            propertyNamingStrategy2 = propertyNamingStrategy2;
                                                                        } else {
                                                                            cls13 = cls15;
                                                                            r10 = jSONField;
                                                                            i10 = iM3460of;
                                                                            i11 = iM3339of;
                                                                        }
                                                                    }
                                                                } else {
                                                                    cls13 = cls35;
                                                                    iOrdinal = i31;
                                                                    i10 = i32;
                                                                    i11 = i33;
                                                                    r10 = field;
                                                                }
                                                                propertyNamingStrategy3 = propertyNamingStrategy2;
                                                                if (propertyNamingStrategy3 != null) {
                                                                    propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                                                }
                                                                fieldArr2 = fieldArr5;
                                                                propertyNamingStrategy2 = propertyNamingStrategy3;
                                                                add(arrayList, new FieldInfo(propertyNameByMethodName2, method3, field4, cls, type, iOrdinal, i10, i11, superMethodAnnotation, r10, null, mapBuildGenericInfo));
                                                            }
                                                            cls14 = cls14;
                                                        }
                                                    }
                                                    cls13 = cls35;
                                                    cls14 = cls;
                                                }
                                            } else {
                                                str = str;
                                                if ((superMethodAnnotation == null || name3.startsWith(str)) && cls8 == null) {
                                                    cCharAt = name3.charAt(3);
                                                    if (zIsKotlin) {
                                                        arrayList2 = new ArrayList();
                                                        while (i12 < methodArr.length) {
                                                            if (methodArr[i12].getName().startsWith("get")) {
                                                                arrayList2.add(methodArr[i12].getName());
                                                            }
                                                        }
                                                    } else {
                                                        arrayList2 = field;
                                                    }
                                                    if (!Character.isUpperCase(cCharAt) || cCharAt > 512) {
                                                        cls14 = cls;
                                                        fieldArr5 = fieldArr2;
                                                        if (zIsKotlin) {
                                                            propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName("g" + name3.substring(1));
                                                        } else {
                                                            if (TypeUtils.compatibleWithJavaBean) {
                                                                propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                                            } else {
                                                                propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name3);
                                                            }
                                                            field3 = field;
                                                        }
                                                        if (field3 == null) {
                                                            field3 = TypeUtils.getField(cls14, propertyNameByMethodName2, fieldArr5);
                                                        }
                                                        if (field3 == null || parameterTypes5[0] != Boolean.TYPE) {
                                                            field4 = field3;
                                                        } else {
                                                            field4 = TypeUtils.getField(cls14, "is" + Character.toUpperCase(propertyNameByMethodName2.charAt(0)) + propertyNameByMethodName2.substring(1), fieldArr5);
                                                        }
                                                        if (field4 != null) {
                                                            cls15 = cls35;
                                                            jSONField = (JSONField) TypeUtils.getAnnotation(field4, cls15);
                                                            if (jSONField == null) {
                                                                cls13 = cls15;
                                                                r10 = jSONField;
                                                                iOrdinal = i31;
                                                                i10 = i32;
                                                                i11 = i33;
                                                            } else if (jSONField.deserialize()) {
                                                                cls13 = cls15;
                                                                fieldArr2 = fieldArr5;
                                                                cls14 = cls14;
                                                            } else {
                                                                iOrdinal = jSONField.ordinal();
                                                                iM3460of = SerializerFeature.m3460of(jSONField.serialzeFeatures());
                                                                iM3339of = Feature.m3339of(jSONField.parseFeatures());
                                                                if (jSONField.name().length() != 0) {
                                                                    cls13 = cls15;
                                                                    str = str;
                                                                    methodArr = methodArr;
                                                                    cls14 = cls14;
                                                                    add(arrayList, new FieldInfo(jSONField.name(), method3, field4, cls, type, iOrdinal, iM3460of, iM3339of, superMethodAnnotation, jSONField, null, mapBuildGenericInfo));
                                                                    fieldArr2 = fieldArr5;
                                                                    propertyNamingStrategy2 = propertyNamingStrategy2;
                                                                } else {
                                                                    cls13 = cls15;
                                                                    r10 = jSONField;
                                                                    i10 = iM3460of;
                                                                    i11 = iM3339of;
                                                                }
                                                            }
                                                        } else {
                                                            cls13 = cls35;
                                                            iOrdinal = i31;
                                                            i10 = i32;
                                                            i11 = i33;
                                                            r10 = field;
                                                        }
                                                        propertyNamingStrategy3 = propertyNamingStrategy2;
                                                        if (propertyNamingStrategy3 != null) {
                                                            propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                                        }
                                                        fieldArr2 = fieldArr5;
                                                        propertyNamingStrategy2 = propertyNamingStrategy3;
                                                        add(arrayList, new FieldInfo(propertyNameByMethodName2, method3, field4, cls, type, iOrdinal, i10, i11, superMethodAnnotation, r10, null, mapBuildGenericInfo));
                                                    } else {
                                                        if (cCharAt != '_') {
                                                            cls14 = cls;
                                                            fieldArr5 = fieldArr2;
                                                            if (cCharAt == 'f') {
                                                                propertyNameByMethodName2 = name3.substring(3);
                                                            } else {
                                                                if (name3.length() >= 5 && Character.isUpperCase(name3.charAt(4))) {
                                                                    propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                                                } else {
                                                                    propertyNameByMethodName2 = name3.substring(3);
                                                                    field3 = TypeUtils.getField(cls14, propertyNameByMethodName2, fieldArr5);
                                                                    if (field3 == null) {
                                                                        fieldArr2 = fieldArr5;
                                                                        cls13 = cls35;
                                                                    }
                                                                }
                                                                cls14 = cls14;
                                                            }
                                                        } else if (zIsKotlin) {
                                                            propertyNameByMethodName2 = arrayList2.contains("g" + name3.substring(1)) ? name3.substring(3) : "is" + name3.substring(3);
                                                            cls14 = cls;
                                                            fieldArr5 = fieldArr2;
                                                            field3 = TypeUtils.getField(cls14, propertyNameByMethodName2, fieldArr5);
                                                        } else {
                                                            cls14 = cls;
                                                            fieldArr5 = fieldArr2;
                                                            String strSubstring = name3.substring(4);
                                                            field3 = TypeUtils.getField(cls14, strSubstring, fieldArr5);
                                                            if (field3 != null || (field3 = TypeUtils.getField(cls14, (propertyNameByMethodName2 = name3.substring(3)), fieldArr5)) == null) {
                                                                propertyNameByMethodName2 = strSubstring;
                                                            }
                                                        }
                                                        if (field3 == null) {
                                                            field3 = TypeUtils.getField(cls14, propertyNameByMethodName2, fieldArr5);
                                                        }
                                                        if (field3 == null) {
                                                            field4 = field3;
                                                        } else {
                                                            field4 = field3;
                                                        }
                                                        if (field4 != null) {
                                                            cls15 = cls35;
                                                            jSONField = (JSONField) TypeUtils.getAnnotation(field4, cls15);
                                                            if (jSONField == null) {
                                                                cls13 = cls15;
                                                                r10 = jSONField;
                                                                iOrdinal = i31;
                                                                i10 = i32;
                                                                i11 = i33;
                                                            } else if (jSONField.deserialize()) {
                                                                cls13 = cls15;
                                                                fieldArr2 = fieldArr5;
                                                                cls14 = cls14;
                                                            } else {
                                                                iOrdinal = jSONField.ordinal();
                                                                iM3460of = SerializerFeature.m3460of(jSONField.serialzeFeatures());
                                                                iM3339of = Feature.m3339of(jSONField.parseFeatures());
                                                                if (jSONField.name().length() != 0) {
                                                                    cls13 = cls15;
                                                                    str = str;
                                                                    methodArr = methodArr;
                                                                    cls14 = cls14;
                                                                    add(arrayList, new FieldInfo(jSONField.name(), method3, field4, cls, type, iOrdinal, iM3460of, iM3339of, superMethodAnnotation, jSONField, null, mapBuildGenericInfo));
                                                                    fieldArr2 = fieldArr5;
                                                                    propertyNamingStrategy2 = propertyNamingStrategy2;
                                                                } else {
                                                                    cls13 = cls15;
                                                                    r10 = jSONField;
                                                                    i10 = iM3460of;
                                                                    i11 = iM3339of;
                                                                }
                                                            }
                                                        } else {
                                                            cls13 = cls35;
                                                            iOrdinal = i31;
                                                            i10 = i32;
                                                            i11 = i33;
                                                            r10 = field;
                                                        }
                                                        propertyNamingStrategy3 = propertyNamingStrategy2;
                                                        if (propertyNamingStrategy3 != null) {
                                                            propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                                        }
                                                        fieldArr2 = fieldArr5;
                                                        propertyNamingStrategy2 = propertyNamingStrategy3;
                                                        add(arrayList, new FieldInfo(propertyNameByMethodName2, method3, field4, cls, type, iOrdinal, i10, i11, superMethodAnnotation, r10, null, mapBuildGenericInfo));
                                                    }
                                                    field3 = field;
                                                    if (field3 == null) {
                                                        field3 = TypeUtils.getField(cls14, propertyNameByMethodName2, fieldArr5);
                                                    }
                                                    if (field3 == null) {
                                                        field4 = field3;
                                                    } else {
                                                        field4 = field3;
                                                    }
                                                    if (field4 != null) {
                                                        cls15 = cls35;
                                                        jSONField = (JSONField) TypeUtils.getAnnotation(field4, cls15);
                                                        if (jSONField == null) {
                                                            cls13 = cls15;
                                                            r10 = jSONField;
                                                            iOrdinal = i31;
                                                            i10 = i32;
                                                            i11 = i33;
                                                        } else if (jSONField.deserialize()) {
                                                            cls13 = cls15;
                                                            fieldArr2 = fieldArr5;
                                                            cls14 = cls14;
                                                        } else {
                                                            iOrdinal = jSONField.ordinal();
                                                            iM3460of = SerializerFeature.m3460of(jSONField.serialzeFeatures());
                                                            iM3339of = Feature.m3339of(jSONField.parseFeatures());
                                                            if (jSONField.name().length() != 0) {
                                                                cls13 = cls15;
                                                                str = str;
                                                                methodArr = methodArr;
                                                                cls14 = cls14;
                                                                add(arrayList, new FieldInfo(jSONField.name(), method3, field4, cls, type, iOrdinal, iM3460of, iM3339of, superMethodAnnotation, jSONField, null, mapBuildGenericInfo));
                                                                fieldArr2 = fieldArr5;
                                                                propertyNamingStrategy2 = propertyNamingStrategy2;
                                                            } else {
                                                                cls13 = cls15;
                                                                r10 = jSONField;
                                                                i10 = iM3460of;
                                                                i11 = iM3339of;
                                                            }
                                                        }
                                                    } else {
                                                        cls13 = cls35;
                                                        iOrdinal = i31;
                                                        i10 = i32;
                                                        i11 = i33;
                                                        r10 = field;
                                                    }
                                                    propertyNamingStrategy3 = propertyNamingStrategy2;
                                                    if (propertyNamingStrategy3 != null) {
                                                        propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                                    }
                                                    fieldArr2 = fieldArr5;
                                                    propertyNamingStrategy2 = propertyNamingStrategy3;
                                                    add(arrayList, new FieldInfo(propertyNameByMethodName2, method3, field4, cls, type, iOrdinal, i10, i11, superMethodAnnotation, r10, null, mapBuildGenericInfo));
                                                } else {
                                                    str = str;
                                                    cls13 = cls35;
                                                    cls14 = cls;
                                                }
                                            }
                                        }
                                    }
                                }
                                methodArr = methodArr;
                                cls13 = cls35;
                                cls14 = cls24;
                            }
                            if (parameterTypes5.length == 1) {
                                if (jSONField6 == null) {
                                    superMethodAnnotation = TypeUtils.getSuperMethodAnnotation(cls24, method3);
                                } else {
                                    superMethodAnnotation = jSONField6;
                                }
                                if (superMethodAnnotation == null) {
                                    if (superMethodAnnotation != null) {
                                        str = str;
                                        if (superMethodAnnotation == null) {
                                            cCharAt = name3.charAt(3);
                                            if (zIsKotlin) {
                                                arrayList2 = new ArrayList();
                                                while (i12 < methodArr.length) {
                                                    if (methodArr[i12].getName().startsWith("get")) {
                                                        arrayList2.add(methodArr[i12].getName());
                                                    }
                                                }
                                            } else {
                                                arrayList2 = field;
                                            }
                                            if (!Character.isUpperCase(cCharAt)) {
                                                cls14 = cls;
                                                fieldArr5 = fieldArr2;
                                                if (zIsKotlin) {
                                                    propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName("g" + name3.substring(1));
                                                    field3 = field;
                                                } else {
                                                    if (TypeUtils.compatibleWithJavaBean) {
                                                        propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                                    } else {
                                                        propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name3);
                                                    }
                                                    field3 = field;
                                                }
                                                if (field3 == null) {
                                                    field3 = TypeUtils.getField(cls14, propertyNameByMethodName2, fieldArr5);
                                                }
                                                if (field3 == null) {
                                                    field4 = field3;
                                                } else {
                                                    field4 = field3;
                                                }
                                                if (field4 != null) {
                                                    cls15 = cls35;
                                                    jSONField = (JSONField) TypeUtils.getAnnotation(field4, cls15);
                                                    if (jSONField == null) {
                                                        cls13 = cls15;
                                                        r10 = jSONField;
                                                        iOrdinal = i31;
                                                        i10 = i32;
                                                        i11 = i33;
                                                    } else if (jSONField.deserialize()) {
                                                        cls13 = cls15;
                                                        fieldArr2 = fieldArr5;
                                                    } else {
                                                        iOrdinal = jSONField.ordinal();
                                                        iM3460of = SerializerFeature.m3460of(jSONField.serialzeFeatures());
                                                        iM3339of = Feature.m3339of(jSONField.parseFeatures());
                                                        if (jSONField.name().length() != 0) {
                                                            cls13 = cls15;
                                                            str = str;
                                                            methodArr = methodArr;
                                                            cls14 = cls14;
                                                            add(arrayList, new FieldInfo(jSONField.name(), method3, field4, cls, type, iOrdinal, iM3460of, iM3339of, superMethodAnnotation, jSONField, null, mapBuildGenericInfo));
                                                            fieldArr2 = fieldArr5;
                                                            propertyNamingStrategy2 = propertyNamingStrategy2;
                                                        } else {
                                                            cls13 = cls15;
                                                            r10 = jSONField;
                                                            i10 = iM3460of;
                                                            i11 = iM3339of;
                                                        }
                                                    }
                                                } else {
                                                    cls13 = cls35;
                                                    iOrdinal = i31;
                                                    i10 = i32;
                                                    i11 = i33;
                                                    r10 = field;
                                                }
                                                propertyNamingStrategy3 = propertyNamingStrategy2;
                                                if (propertyNamingStrategy3 != null) {
                                                    propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                                }
                                                fieldArr2 = fieldArr5;
                                                propertyNamingStrategy2 = propertyNamingStrategy3;
                                                add(arrayList, new FieldInfo(propertyNameByMethodName2, method3, field4, cls, type, iOrdinal, i10, i11, superMethodAnnotation, r10, null, mapBuildGenericInfo));
                                            } else {
                                                cls14 = cls;
                                                fieldArr5 = fieldArr2;
                                                if (zIsKotlin) {
                                                    propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName("g" + name3.substring(1));
                                                    field3 = field;
                                                } else {
                                                    if (TypeUtils.compatibleWithJavaBean) {
                                                        propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                                    } else {
                                                        propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name3);
                                                    }
                                                    field3 = field;
                                                }
                                                if (field3 == null) {
                                                    field3 = TypeUtils.getField(cls14, propertyNameByMethodName2, fieldArr5);
                                                }
                                                if (field3 == null) {
                                                    field4 = field3;
                                                } else {
                                                    field4 = field3;
                                                }
                                                if (field4 != null) {
                                                    cls15 = cls35;
                                                    jSONField = (JSONField) TypeUtils.getAnnotation(field4, cls15);
                                                    if (jSONField == null) {
                                                        cls13 = cls15;
                                                        r10 = jSONField;
                                                        iOrdinal = i31;
                                                        i10 = i32;
                                                        i11 = i33;
                                                    } else if (jSONField.deserialize()) {
                                                        cls13 = cls15;
                                                        fieldArr2 = fieldArr5;
                                                    } else {
                                                        iOrdinal = jSONField.ordinal();
                                                        iM3460of = SerializerFeature.m3460of(jSONField.serialzeFeatures());
                                                        iM3339of = Feature.m3339of(jSONField.parseFeatures());
                                                        if (jSONField.name().length() != 0) {
                                                            cls13 = cls15;
                                                            str = str;
                                                            methodArr = methodArr;
                                                            cls14 = cls14;
                                                            add(arrayList, new FieldInfo(jSONField.name(), method3, field4, cls, type, iOrdinal, iM3460of, iM3339of, superMethodAnnotation, jSONField, null, mapBuildGenericInfo));
                                                            fieldArr2 = fieldArr5;
                                                            propertyNamingStrategy2 = propertyNamingStrategy2;
                                                        } else {
                                                            cls13 = cls15;
                                                            r10 = jSONField;
                                                            i10 = iM3460of;
                                                            i11 = iM3339of;
                                                        }
                                                    }
                                                } else {
                                                    cls13 = cls35;
                                                    iOrdinal = i31;
                                                    i10 = i32;
                                                    i11 = i33;
                                                    r10 = field;
                                                }
                                                propertyNamingStrategy3 = propertyNamingStrategy2;
                                                if (propertyNamingStrategy3 != null) {
                                                    propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                                }
                                                fieldArr2 = fieldArr5;
                                                propertyNamingStrategy2 = propertyNamingStrategy3;
                                                add(arrayList, new FieldInfo(propertyNameByMethodName2, method3, field4, cls, type, iOrdinal, i10, i11, superMethodAnnotation, r10, null, mapBuildGenericInfo));
                                            }
                                            cls14 = cls14;
                                        } else {
                                            cCharAt = name3.charAt(3);
                                            if (zIsKotlin) {
                                                arrayList2 = new ArrayList();
                                                while (i12 < methodArr.length) {
                                                    if (methodArr[i12].getName().startsWith("get")) {
                                                        arrayList2.add(methodArr[i12].getName());
                                                    }
                                                }
                                            } else {
                                                arrayList2 = field;
                                            }
                                            if (!Character.isUpperCase(cCharAt)) {
                                                cls14 = cls;
                                                fieldArr5 = fieldArr2;
                                                if (zIsKotlin) {
                                                    propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName("g" + name3.substring(1));
                                                    field3 = field;
                                                } else {
                                                    if (TypeUtils.compatibleWithJavaBean) {
                                                        propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                                    } else {
                                                        propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name3);
                                                    }
                                                    field3 = field;
                                                }
                                                if (field3 == null) {
                                                    field3 = TypeUtils.getField(cls14, propertyNameByMethodName2, fieldArr5);
                                                }
                                                if (field3 == null) {
                                                    field4 = field3;
                                                } else {
                                                    field4 = field3;
                                                }
                                                if (field4 != null) {
                                                    cls15 = cls35;
                                                    jSONField = (JSONField) TypeUtils.getAnnotation(field4, cls15);
                                                    if (jSONField == null) {
                                                        cls13 = cls15;
                                                        r10 = jSONField;
                                                        iOrdinal = i31;
                                                        i10 = i32;
                                                        i11 = i33;
                                                    } else if (jSONField.deserialize()) {
                                                        cls13 = cls15;
                                                        fieldArr2 = fieldArr5;
                                                    } else {
                                                        iOrdinal = jSONField.ordinal();
                                                        iM3460of = SerializerFeature.m3460of(jSONField.serialzeFeatures());
                                                        iM3339of = Feature.m3339of(jSONField.parseFeatures());
                                                        if (jSONField.name().length() != 0) {
                                                            cls13 = cls15;
                                                            str = str;
                                                            methodArr = methodArr;
                                                            cls14 = cls14;
                                                            add(arrayList, new FieldInfo(jSONField.name(), method3, field4, cls, type, iOrdinal, iM3460of, iM3339of, superMethodAnnotation, jSONField, null, mapBuildGenericInfo));
                                                            fieldArr2 = fieldArr5;
                                                            propertyNamingStrategy2 = propertyNamingStrategy2;
                                                        } else {
                                                            cls13 = cls15;
                                                            r10 = jSONField;
                                                            i10 = iM3460of;
                                                            i11 = iM3339of;
                                                        }
                                                    }
                                                } else {
                                                    cls13 = cls35;
                                                    iOrdinal = i31;
                                                    i10 = i32;
                                                    i11 = i33;
                                                    r10 = field;
                                                }
                                                propertyNamingStrategy3 = propertyNamingStrategy2;
                                                if (propertyNamingStrategy3 != null) {
                                                    propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                                }
                                                fieldArr2 = fieldArr5;
                                                propertyNamingStrategy2 = propertyNamingStrategy3;
                                                add(arrayList, new FieldInfo(propertyNameByMethodName2, method3, field4, cls, type, iOrdinal, i10, i11, superMethodAnnotation, r10, null, mapBuildGenericInfo));
                                            } else {
                                                cls14 = cls;
                                                fieldArr5 = fieldArr2;
                                                if (zIsKotlin) {
                                                    propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName("g" + name3.substring(1));
                                                    field3 = field;
                                                } else {
                                                    if (TypeUtils.compatibleWithJavaBean) {
                                                        propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                                    } else {
                                                        propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name3);
                                                    }
                                                    field3 = field;
                                                }
                                                if (field3 == null) {
                                                    field3 = TypeUtils.getField(cls14, propertyNameByMethodName2, fieldArr5);
                                                }
                                                if (field3 == null) {
                                                    field4 = field3;
                                                } else {
                                                    field4 = field3;
                                                }
                                                if (field4 != null) {
                                                    cls15 = cls35;
                                                    jSONField = (JSONField) TypeUtils.getAnnotation(field4, cls15);
                                                    if (jSONField == null) {
                                                        cls13 = cls15;
                                                        r10 = jSONField;
                                                        iOrdinal = i31;
                                                        i10 = i32;
                                                        i11 = i33;
                                                    } else if (jSONField.deserialize()) {
                                                        cls13 = cls15;
                                                        fieldArr2 = fieldArr5;
                                                    } else {
                                                        iOrdinal = jSONField.ordinal();
                                                        iM3460of = SerializerFeature.m3460of(jSONField.serialzeFeatures());
                                                        iM3339of = Feature.m3339of(jSONField.parseFeatures());
                                                        if (jSONField.name().length() != 0) {
                                                            cls13 = cls15;
                                                            str = str;
                                                            methodArr = methodArr;
                                                            cls14 = cls14;
                                                            add(arrayList, new FieldInfo(jSONField.name(), method3, field4, cls, type, iOrdinal, iM3460of, iM3339of, superMethodAnnotation, jSONField, null, mapBuildGenericInfo));
                                                            fieldArr2 = fieldArr5;
                                                            propertyNamingStrategy2 = propertyNamingStrategy2;
                                                        } else {
                                                            cls13 = cls15;
                                                            r10 = jSONField;
                                                            i10 = iM3460of;
                                                            i11 = iM3339of;
                                                        }
                                                    }
                                                } else {
                                                    cls13 = cls35;
                                                    iOrdinal = i31;
                                                    i10 = i32;
                                                    i11 = i33;
                                                    r10 = field;
                                                }
                                                propertyNamingStrategy3 = propertyNamingStrategy2;
                                                if (propertyNamingStrategy3 != null) {
                                                    propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                                }
                                                fieldArr2 = fieldArr5;
                                                propertyNamingStrategy2 = propertyNamingStrategy3;
                                                add(arrayList, new FieldInfo(propertyNameByMethodName2, method3, field4, cls, type, iOrdinal, i10, i11, superMethodAnnotation, r10, null, mapBuildGenericInfo));
                                            }
                                            cls14 = cls14;
                                        }
                                    } else if (superMethodAnnotation.deserialize()) {
                                        iOrdinal2 = superMethodAnnotation.ordinal();
                                        iM3460of2 = SerializerFeature.m3460of(superMethodAnnotation.serialzeFeatures());
                                        iM3339of2 = Feature.m3339of(superMethodAnnotation.parseFeatures());
                                        if (superMethodAnnotation.name().length() != 0) {
                                            add(arrayList, new FieldInfo(superMethodAnnotation.name(), method3, null, cls, type, iOrdinal2, iM3460of2, iM3339of2, superMethodAnnotation, null, null, mapBuildGenericInfo));
                                            str = str;
                                        } else {
                                            i31 = iOrdinal2;
                                            i32 = iM3460of2;
                                            i33 = iM3339of2;
                                            str = str;
                                            if (superMethodAnnotation == null) {
                                                cCharAt = name3.charAt(3);
                                                if (zIsKotlin) {
                                                    arrayList2 = new ArrayList();
                                                    while (i12 < methodArr.length) {
                                                        if (methodArr[i12].getName().startsWith("get")) {
                                                            arrayList2.add(methodArr[i12].getName());
                                                        }
                                                    }
                                                } else {
                                                    arrayList2 = field;
                                                }
                                                if (!Character.isUpperCase(cCharAt)) {
                                                    cls14 = cls;
                                                    fieldArr5 = fieldArr2;
                                                    if (zIsKotlin) {
                                                        propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName("g" + name3.substring(1));
                                                        field3 = field;
                                                    } else {
                                                        if (TypeUtils.compatibleWithJavaBean) {
                                                            propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                                        } else {
                                                            propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name3);
                                                        }
                                                        field3 = field;
                                                    }
                                                    if (field3 == null) {
                                                        field3 = TypeUtils.getField(cls14, propertyNameByMethodName2, fieldArr5);
                                                    }
                                                    if (field3 == null) {
                                                        field4 = field3;
                                                    } else {
                                                        field4 = field3;
                                                    }
                                                    if (field4 != null) {
                                                        cls15 = cls35;
                                                        jSONField = (JSONField) TypeUtils.getAnnotation(field4, cls15);
                                                        if (jSONField == null) {
                                                            cls13 = cls15;
                                                            r10 = jSONField;
                                                            iOrdinal = i31;
                                                            i10 = i32;
                                                            i11 = i33;
                                                        } else if (jSONField.deserialize()) {
                                                            cls13 = cls15;
                                                            fieldArr2 = fieldArr5;
                                                        } else {
                                                            iOrdinal = jSONField.ordinal();
                                                            iM3460of = SerializerFeature.m3460of(jSONField.serialzeFeatures());
                                                            iM3339of = Feature.m3339of(jSONField.parseFeatures());
                                                            if (jSONField.name().length() != 0) {
                                                                cls13 = cls15;
                                                                str = str;
                                                                methodArr = methodArr;
                                                                cls14 = cls14;
                                                                add(arrayList, new FieldInfo(jSONField.name(), method3, field4, cls, type, iOrdinal, iM3460of, iM3339of, superMethodAnnotation, jSONField, null, mapBuildGenericInfo));
                                                                fieldArr2 = fieldArr5;
                                                                propertyNamingStrategy2 = propertyNamingStrategy2;
                                                            } else {
                                                                cls13 = cls15;
                                                                r10 = jSONField;
                                                                i10 = iM3460of;
                                                                i11 = iM3339of;
                                                            }
                                                        }
                                                    } else {
                                                        cls13 = cls35;
                                                        iOrdinal = i31;
                                                        i10 = i32;
                                                        i11 = i33;
                                                        r10 = field;
                                                    }
                                                    propertyNamingStrategy3 = propertyNamingStrategy2;
                                                    if (propertyNamingStrategy3 != null) {
                                                        propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                                    }
                                                    fieldArr2 = fieldArr5;
                                                    propertyNamingStrategy2 = propertyNamingStrategy3;
                                                    add(arrayList, new FieldInfo(propertyNameByMethodName2, method3, field4, cls, type, iOrdinal, i10, i11, superMethodAnnotation, r10, null, mapBuildGenericInfo));
                                                } else {
                                                    cls14 = cls;
                                                    fieldArr5 = fieldArr2;
                                                    if (zIsKotlin) {
                                                        propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName("g" + name3.substring(1));
                                                        field3 = field;
                                                    } else {
                                                        if (TypeUtils.compatibleWithJavaBean) {
                                                            propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                                        } else {
                                                            propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name3);
                                                        }
                                                        field3 = field;
                                                    }
                                                    if (field3 == null) {
                                                        field3 = TypeUtils.getField(cls14, propertyNameByMethodName2, fieldArr5);
                                                    }
                                                    if (field3 == null) {
                                                        field4 = field3;
                                                    } else {
                                                        field4 = field3;
                                                    }
                                                    if (field4 != null) {
                                                        cls15 = cls35;
                                                        jSONField = (JSONField) TypeUtils.getAnnotation(field4, cls15);
                                                        if (jSONField == null) {
                                                            cls13 = cls15;
                                                            r10 = jSONField;
                                                            iOrdinal = i31;
                                                            i10 = i32;
                                                            i11 = i33;
                                                        } else if (jSONField.deserialize()) {
                                                            cls13 = cls15;
                                                            fieldArr2 = fieldArr5;
                                                        } else {
                                                            iOrdinal = jSONField.ordinal();
                                                            iM3460of = SerializerFeature.m3460of(jSONField.serialzeFeatures());
                                                            iM3339of = Feature.m3339of(jSONField.parseFeatures());
                                                            if (jSONField.name().length() != 0) {
                                                                cls13 = cls15;
                                                                str = str;
                                                                methodArr = methodArr;
                                                                cls14 = cls14;
                                                                add(arrayList, new FieldInfo(jSONField.name(), method3, field4, cls, type, iOrdinal, iM3460of, iM3339of, superMethodAnnotation, jSONField, null, mapBuildGenericInfo));
                                                                fieldArr2 = fieldArr5;
                                                                propertyNamingStrategy2 = propertyNamingStrategy2;
                                                            } else {
                                                                cls13 = cls15;
                                                                r10 = jSONField;
                                                                i10 = iM3460of;
                                                                i11 = iM3339of;
                                                            }
                                                        }
                                                    } else {
                                                        cls13 = cls35;
                                                        iOrdinal = i31;
                                                        i10 = i32;
                                                        i11 = i33;
                                                        r10 = field;
                                                    }
                                                    propertyNamingStrategy3 = propertyNamingStrategy2;
                                                    if (propertyNamingStrategy3 != null) {
                                                        propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                                    }
                                                    fieldArr2 = fieldArr5;
                                                    propertyNamingStrategy2 = propertyNamingStrategy3;
                                                    add(arrayList, new FieldInfo(propertyNameByMethodName2, method3, field4, cls, type, iOrdinal, i10, i11, superMethodAnnotation, r10, null, mapBuildGenericInfo));
                                                }
                                                cls14 = cls14;
                                            } else {
                                                cCharAt = name3.charAt(3);
                                                if (zIsKotlin) {
                                                    arrayList2 = new ArrayList();
                                                    while (i12 < methodArr.length) {
                                                        if (methodArr[i12].getName().startsWith("get")) {
                                                            arrayList2.add(methodArr[i12].getName());
                                                        }
                                                    }
                                                } else {
                                                    arrayList2 = field;
                                                }
                                                if (!Character.isUpperCase(cCharAt)) {
                                                    cls14 = cls;
                                                    fieldArr5 = fieldArr2;
                                                    if (zIsKotlin) {
                                                        propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName("g" + name3.substring(1));
                                                        field3 = field;
                                                    } else {
                                                        if (TypeUtils.compatibleWithJavaBean) {
                                                            propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                                        } else {
                                                            propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name3);
                                                        }
                                                        field3 = field;
                                                    }
                                                    if (field3 == null) {
                                                        field3 = TypeUtils.getField(cls14, propertyNameByMethodName2, fieldArr5);
                                                    }
                                                    if (field3 == null) {
                                                        field4 = field3;
                                                    } else {
                                                        field4 = field3;
                                                    }
                                                    if (field4 != null) {
                                                        cls15 = cls35;
                                                        jSONField = (JSONField) TypeUtils.getAnnotation(field4, cls15);
                                                        if (jSONField == null) {
                                                            cls13 = cls15;
                                                            r10 = jSONField;
                                                            iOrdinal = i31;
                                                            i10 = i32;
                                                            i11 = i33;
                                                        } else if (jSONField.deserialize()) {
                                                            cls13 = cls15;
                                                            fieldArr2 = fieldArr5;
                                                        } else {
                                                            iOrdinal = jSONField.ordinal();
                                                            iM3460of = SerializerFeature.m3460of(jSONField.serialzeFeatures());
                                                            iM3339of = Feature.m3339of(jSONField.parseFeatures());
                                                            if (jSONField.name().length() != 0) {
                                                                cls13 = cls15;
                                                                str = str;
                                                                methodArr = methodArr;
                                                                cls14 = cls14;
                                                                add(arrayList, new FieldInfo(jSONField.name(), method3, field4, cls, type, iOrdinal, iM3460of, iM3339of, superMethodAnnotation, jSONField, null, mapBuildGenericInfo));
                                                                fieldArr2 = fieldArr5;
                                                                propertyNamingStrategy2 = propertyNamingStrategy2;
                                                            } else {
                                                                cls13 = cls15;
                                                                r10 = jSONField;
                                                                i10 = iM3460of;
                                                                i11 = iM3339of;
                                                            }
                                                        }
                                                    } else {
                                                        cls13 = cls35;
                                                        iOrdinal = i31;
                                                        i10 = i32;
                                                        i11 = i33;
                                                        r10 = field;
                                                    }
                                                    propertyNamingStrategy3 = propertyNamingStrategy2;
                                                    if (propertyNamingStrategy3 != null) {
                                                        propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                                    }
                                                    fieldArr2 = fieldArr5;
                                                    propertyNamingStrategy2 = propertyNamingStrategy3;
                                                    add(arrayList, new FieldInfo(propertyNameByMethodName2, method3, field4, cls, type, iOrdinal, i10, i11, superMethodAnnotation, r10, null, mapBuildGenericInfo));
                                                } else {
                                                    cls14 = cls;
                                                    fieldArr5 = fieldArr2;
                                                    if (zIsKotlin) {
                                                        propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName("g" + name3.substring(1));
                                                        field3 = field;
                                                    } else {
                                                        if (TypeUtils.compatibleWithJavaBean) {
                                                            propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                                        } else {
                                                            propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name3);
                                                        }
                                                        field3 = field;
                                                    }
                                                    if (field3 == null) {
                                                        field3 = TypeUtils.getField(cls14, propertyNameByMethodName2, fieldArr5);
                                                    }
                                                    if (field3 == null) {
                                                        field4 = field3;
                                                    } else {
                                                        field4 = field3;
                                                    }
                                                    if (field4 != null) {
                                                        cls15 = cls35;
                                                        jSONField = (JSONField) TypeUtils.getAnnotation(field4, cls15);
                                                        if (jSONField == null) {
                                                            cls13 = cls15;
                                                            r10 = jSONField;
                                                            iOrdinal = i31;
                                                            i10 = i32;
                                                            i11 = i33;
                                                        } else if (jSONField.deserialize()) {
                                                            cls13 = cls15;
                                                            fieldArr2 = fieldArr5;
                                                        } else {
                                                            iOrdinal = jSONField.ordinal();
                                                            iM3460of = SerializerFeature.m3460of(jSONField.serialzeFeatures());
                                                            iM3339of = Feature.m3339of(jSONField.parseFeatures());
                                                            if (jSONField.name().length() != 0) {
                                                                cls13 = cls15;
                                                                str = str;
                                                                methodArr = methodArr;
                                                                cls14 = cls14;
                                                                add(arrayList, new FieldInfo(jSONField.name(), method3, field4, cls, type, iOrdinal, iM3460of, iM3339of, superMethodAnnotation, jSONField, null, mapBuildGenericInfo));
                                                                fieldArr2 = fieldArr5;
                                                                propertyNamingStrategy2 = propertyNamingStrategy2;
                                                            } else {
                                                                cls13 = cls15;
                                                                r10 = jSONField;
                                                                i10 = iM3460of;
                                                                i11 = iM3339of;
                                                            }
                                                        }
                                                    } else {
                                                        cls13 = cls35;
                                                        iOrdinal = i31;
                                                        i10 = i32;
                                                        i11 = i33;
                                                        r10 = field;
                                                    }
                                                    propertyNamingStrategy3 = propertyNamingStrategy2;
                                                    if (propertyNamingStrategy3 != null) {
                                                        propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                                    }
                                                    fieldArr2 = fieldArr5;
                                                    propertyNamingStrategy2 = propertyNamingStrategy3;
                                                    add(arrayList, new FieldInfo(propertyNameByMethodName2, method3, field4, cls, type, iOrdinal, i10, i11, superMethodAnnotation, r10, null, mapBuildGenericInfo));
                                                }
                                                cls14 = cls14;
                                            }
                                        }
                                        cls13 = cls35;
                                        cls14 = cls;
                                    }
                                } else if (superMethodAnnotation != null) {
                                    str = str;
                                    if (superMethodAnnotation == null) {
                                        cCharAt = name3.charAt(3);
                                        if (zIsKotlin) {
                                            arrayList2 = new ArrayList();
                                            while (i12 < methodArr.length) {
                                                if (methodArr[i12].getName().startsWith("get")) {
                                                    arrayList2.add(methodArr[i12].getName());
                                                }
                                            }
                                        } else {
                                            arrayList2 = field;
                                        }
                                        if (!Character.isUpperCase(cCharAt)) {
                                            cls14 = cls;
                                            fieldArr5 = fieldArr2;
                                            if (zIsKotlin) {
                                                propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName("g" + name3.substring(1));
                                                field3 = field;
                                            } else {
                                                if (TypeUtils.compatibleWithJavaBean) {
                                                    propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                                } else {
                                                    propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name3);
                                                }
                                                field3 = field;
                                            }
                                            if (field3 == null) {
                                                field3 = TypeUtils.getField(cls14, propertyNameByMethodName2, fieldArr5);
                                            }
                                            if (field3 == null) {
                                                field4 = field3;
                                            } else {
                                                field4 = field3;
                                            }
                                            if (field4 != null) {
                                                cls15 = cls35;
                                                jSONField = (JSONField) TypeUtils.getAnnotation(field4, cls15);
                                                if (jSONField == null) {
                                                    cls13 = cls15;
                                                    r10 = jSONField;
                                                    iOrdinal = i31;
                                                    i10 = i32;
                                                    i11 = i33;
                                                } else if (jSONField.deserialize()) {
                                                    cls13 = cls15;
                                                    fieldArr2 = fieldArr5;
                                                } else {
                                                    iOrdinal = jSONField.ordinal();
                                                    iM3460of = SerializerFeature.m3460of(jSONField.serialzeFeatures());
                                                    iM3339of = Feature.m3339of(jSONField.parseFeatures());
                                                    if (jSONField.name().length() != 0) {
                                                        cls13 = cls15;
                                                        str = str;
                                                        methodArr = methodArr;
                                                        cls14 = cls14;
                                                        add(arrayList, new FieldInfo(jSONField.name(), method3, field4, cls, type, iOrdinal, iM3460of, iM3339of, superMethodAnnotation, jSONField, null, mapBuildGenericInfo));
                                                        fieldArr2 = fieldArr5;
                                                        propertyNamingStrategy2 = propertyNamingStrategy2;
                                                    } else {
                                                        cls13 = cls15;
                                                        r10 = jSONField;
                                                        i10 = iM3460of;
                                                        i11 = iM3339of;
                                                    }
                                                }
                                            } else {
                                                cls13 = cls35;
                                                iOrdinal = i31;
                                                i10 = i32;
                                                i11 = i33;
                                                r10 = field;
                                            }
                                            propertyNamingStrategy3 = propertyNamingStrategy2;
                                            if (propertyNamingStrategy3 != null) {
                                                propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                            }
                                            fieldArr2 = fieldArr5;
                                            propertyNamingStrategy2 = propertyNamingStrategy3;
                                            add(arrayList, new FieldInfo(propertyNameByMethodName2, method3, field4, cls, type, iOrdinal, i10, i11, superMethodAnnotation, r10, null, mapBuildGenericInfo));
                                        } else {
                                            cls14 = cls;
                                            fieldArr5 = fieldArr2;
                                            if (zIsKotlin) {
                                                propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName("g" + name3.substring(1));
                                                field3 = field;
                                            } else {
                                                if (TypeUtils.compatibleWithJavaBean) {
                                                    propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                                } else {
                                                    propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name3);
                                                }
                                                field3 = field;
                                            }
                                            if (field3 == null) {
                                                field3 = TypeUtils.getField(cls14, propertyNameByMethodName2, fieldArr5);
                                            }
                                            if (field3 == null) {
                                                field4 = field3;
                                            } else {
                                                field4 = field3;
                                            }
                                            if (field4 != null) {
                                                cls15 = cls35;
                                                jSONField = (JSONField) TypeUtils.getAnnotation(field4, cls15);
                                                if (jSONField == null) {
                                                    cls13 = cls15;
                                                    r10 = jSONField;
                                                    iOrdinal = i31;
                                                    i10 = i32;
                                                    i11 = i33;
                                                } else if (jSONField.deserialize()) {
                                                    cls13 = cls15;
                                                    fieldArr2 = fieldArr5;
                                                } else {
                                                    iOrdinal = jSONField.ordinal();
                                                    iM3460of = SerializerFeature.m3460of(jSONField.serialzeFeatures());
                                                    iM3339of = Feature.m3339of(jSONField.parseFeatures());
                                                    if (jSONField.name().length() != 0) {
                                                        cls13 = cls15;
                                                        str = str;
                                                        methodArr = methodArr;
                                                        cls14 = cls14;
                                                        add(arrayList, new FieldInfo(jSONField.name(), method3, field4, cls, type, iOrdinal, iM3460of, iM3339of, superMethodAnnotation, jSONField, null, mapBuildGenericInfo));
                                                        fieldArr2 = fieldArr5;
                                                        propertyNamingStrategy2 = propertyNamingStrategy2;
                                                    } else {
                                                        cls13 = cls15;
                                                        r10 = jSONField;
                                                        i10 = iM3460of;
                                                        i11 = iM3339of;
                                                    }
                                                }
                                            } else {
                                                cls13 = cls35;
                                                iOrdinal = i31;
                                                i10 = i32;
                                                i11 = i33;
                                                r10 = field;
                                            }
                                            propertyNamingStrategy3 = propertyNamingStrategy2;
                                            if (propertyNamingStrategy3 != null) {
                                                propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                            }
                                            fieldArr2 = fieldArr5;
                                            propertyNamingStrategy2 = propertyNamingStrategy3;
                                            add(arrayList, new FieldInfo(propertyNameByMethodName2, method3, field4, cls, type, iOrdinal, i10, i11, superMethodAnnotation, r10, null, mapBuildGenericInfo));
                                        }
                                        cls14 = cls14;
                                    } else {
                                        cCharAt = name3.charAt(3);
                                        if (zIsKotlin) {
                                            arrayList2 = new ArrayList();
                                            while (i12 < methodArr.length) {
                                                if (methodArr[i12].getName().startsWith("get")) {
                                                    arrayList2.add(methodArr[i12].getName());
                                                }
                                            }
                                        } else {
                                            arrayList2 = field;
                                        }
                                        if (!Character.isUpperCase(cCharAt)) {
                                            cls14 = cls;
                                            fieldArr5 = fieldArr2;
                                            if (zIsKotlin) {
                                                propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName("g" + name3.substring(1));
                                                field3 = field;
                                            } else {
                                                if (TypeUtils.compatibleWithJavaBean) {
                                                    propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                                } else {
                                                    propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name3);
                                                }
                                                field3 = field;
                                            }
                                            if (field3 == null) {
                                                field3 = TypeUtils.getField(cls14, propertyNameByMethodName2, fieldArr5);
                                            }
                                            if (field3 == null) {
                                                field4 = field3;
                                            } else {
                                                field4 = field3;
                                            }
                                            if (field4 != null) {
                                                cls15 = cls35;
                                                jSONField = (JSONField) TypeUtils.getAnnotation(field4, cls15);
                                                if (jSONField == null) {
                                                    cls13 = cls15;
                                                    r10 = jSONField;
                                                    iOrdinal = i31;
                                                    i10 = i32;
                                                    i11 = i33;
                                                } else if (jSONField.deserialize()) {
                                                    cls13 = cls15;
                                                    fieldArr2 = fieldArr5;
                                                } else {
                                                    iOrdinal = jSONField.ordinal();
                                                    iM3460of = SerializerFeature.m3460of(jSONField.serialzeFeatures());
                                                    iM3339of = Feature.m3339of(jSONField.parseFeatures());
                                                    if (jSONField.name().length() != 0) {
                                                        cls13 = cls15;
                                                        str = str;
                                                        methodArr = methodArr;
                                                        cls14 = cls14;
                                                        add(arrayList, new FieldInfo(jSONField.name(), method3, field4, cls, type, iOrdinal, iM3460of, iM3339of, superMethodAnnotation, jSONField, null, mapBuildGenericInfo));
                                                        fieldArr2 = fieldArr5;
                                                        propertyNamingStrategy2 = propertyNamingStrategy2;
                                                    } else {
                                                        cls13 = cls15;
                                                        r10 = jSONField;
                                                        i10 = iM3460of;
                                                        i11 = iM3339of;
                                                    }
                                                }
                                            } else {
                                                cls13 = cls35;
                                                iOrdinal = i31;
                                                i10 = i32;
                                                i11 = i33;
                                                r10 = field;
                                            }
                                            propertyNamingStrategy3 = propertyNamingStrategy2;
                                            if (propertyNamingStrategy3 != null) {
                                                propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                            }
                                            fieldArr2 = fieldArr5;
                                            propertyNamingStrategy2 = propertyNamingStrategy3;
                                            add(arrayList, new FieldInfo(propertyNameByMethodName2, method3, field4, cls, type, iOrdinal, i10, i11, superMethodAnnotation, r10, null, mapBuildGenericInfo));
                                        } else {
                                            cls14 = cls;
                                            fieldArr5 = fieldArr2;
                                            if (zIsKotlin) {
                                                propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName("g" + name3.substring(1));
                                                field3 = field;
                                            } else {
                                                if (TypeUtils.compatibleWithJavaBean) {
                                                    propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                                } else {
                                                    propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name3);
                                                }
                                                field3 = field;
                                            }
                                            if (field3 == null) {
                                                field3 = TypeUtils.getField(cls14, propertyNameByMethodName2, fieldArr5);
                                            }
                                            if (field3 == null) {
                                                field4 = field3;
                                            } else {
                                                field4 = field3;
                                            }
                                            if (field4 != null) {
                                                cls15 = cls35;
                                                jSONField = (JSONField) TypeUtils.getAnnotation(field4, cls15);
                                                if (jSONField == null) {
                                                    cls13 = cls15;
                                                    r10 = jSONField;
                                                    iOrdinal = i31;
                                                    i10 = i32;
                                                    i11 = i33;
                                                } else if (jSONField.deserialize()) {
                                                    cls13 = cls15;
                                                    fieldArr2 = fieldArr5;
                                                } else {
                                                    iOrdinal = jSONField.ordinal();
                                                    iM3460of = SerializerFeature.m3460of(jSONField.serialzeFeatures());
                                                    iM3339of = Feature.m3339of(jSONField.parseFeatures());
                                                    if (jSONField.name().length() != 0) {
                                                        cls13 = cls15;
                                                        str = str;
                                                        methodArr = methodArr;
                                                        cls14 = cls14;
                                                        add(arrayList, new FieldInfo(jSONField.name(), method3, field4, cls, type, iOrdinal, iM3460of, iM3339of, superMethodAnnotation, jSONField, null, mapBuildGenericInfo));
                                                        fieldArr2 = fieldArr5;
                                                        propertyNamingStrategy2 = propertyNamingStrategy2;
                                                    } else {
                                                        cls13 = cls15;
                                                        r10 = jSONField;
                                                        i10 = iM3460of;
                                                        i11 = iM3339of;
                                                    }
                                                }
                                            } else {
                                                cls13 = cls35;
                                                iOrdinal = i31;
                                                i10 = i32;
                                                i11 = i33;
                                                r10 = field;
                                            }
                                            propertyNamingStrategy3 = propertyNamingStrategy2;
                                            if (propertyNamingStrategy3 != null) {
                                                propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                            }
                                            fieldArr2 = fieldArr5;
                                            propertyNamingStrategy2 = propertyNamingStrategy3;
                                            add(arrayList, new FieldInfo(propertyNameByMethodName2, method3, field4, cls, type, iOrdinal, i10, i11, superMethodAnnotation, r10, null, mapBuildGenericInfo));
                                        }
                                        cls14 = cls14;
                                    }
                                } else if (superMethodAnnotation.deserialize()) {
                                    iOrdinal2 = superMethodAnnotation.ordinal();
                                    iM3460of2 = SerializerFeature.m3460of(superMethodAnnotation.serialzeFeatures());
                                    iM3339of2 = Feature.m3339of(superMethodAnnotation.parseFeatures());
                                    if (superMethodAnnotation.name().length() != 0) {
                                        add(arrayList, new FieldInfo(superMethodAnnotation.name(), method3, null, cls, type, iOrdinal2, iM3460of2, iM3339of2, superMethodAnnotation, null, null, mapBuildGenericInfo));
                                        str = str;
                                    } else {
                                        i31 = iOrdinal2;
                                        i32 = iM3460of2;
                                        i33 = iM3339of2;
                                        str = str;
                                        if (superMethodAnnotation == null) {
                                            cCharAt = name3.charAt(3);
                                            if (zIsKotlin) {
                                                arrayList2 = new ArrayList();
                                                while (i12 < methodArr.length) {
                                                    if (methodArr[i12].getName().startsWith("get")) {
                                                        arrayList2.add(methodArr[i12].getName());
                                                    }
                                                }
                                            } else {
                                                arrayList2 = field;
                                            }
                                            if (!Character.isUpperCase(cCharAt)) {
                                                cls14 = cls;
                                                fieldArr5 = fieldArr2;
                                                if (zIsKotlin) {
                                                    propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName("g" + name3.substring(1));
                                                    field3 = field;
                                                } else {
                                                    if (TypeUtils.compatibleWithJavaBean) {
                                                        propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                                    } else {
                                                        propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name3);
                                                    }
                                                    field3 = field;
                                                }
                                                if (field3 == null) {
                                                    field3 = TypeUtils.getField(cls14, propertyNameByMethodName2, fieldArr5);
                                                }
                                                if (field3 == null) {
                                                    field4 = field3;
                                                } else {
                                                    field4 = field3;
                                                }
                                                if (field4 != null) {
                                                    cls15 = cls35;
                                                    jSONField = (JSONField) TypeUtils.getAnnotation(field4, cls15);
                                                    if (jSONField == null) {
                                                        cls13 = cls15;
                                                        r10 = jSONField;
                                                        iOrdinal = i31;
                                                        i10 = i32;
                                                        i11 = i33;
                                                    } else if (jSONField.deserialize()) {
                                                        cls13 = cls15;
                                                        fieldArr2 = fieldArr5;
                                                    } else {
                                                        iOrdinal = jSONField.ordinal();
                                                        iM3460of = SerializerFeature.m3460of(jSONField.serialzeFeatures());
                                                        iM3339of = Feature.m3339of(jSONField.parseFeatures());
                                                        if (jSONField.name().length() != 0) {
                                                            cls13 = cls15;
                                                            str = str;
                                                            methodArr = methodArr;
                                                            cls14 = cls14;
                                                            add(arrayList, new FieldInfo(jSONField.name(), method3, field4, cls, type, iOrdinal, iM3460of, iM3339of, superMethodAnnotation, jSONField, null, mapBuildGenericInfo));
                                                            fieldArr2 = fieldArr5;
                                                            propertyNamingStrategy2 = propertyNamingStrategy2;
                                                        } else {
                                                            cls13 = cls15;
                                                            r10 = jSONField;
                                                            i10 = iM3460of;
                                                            i11 = iM3339of;
                                                        }
                                                    }
                                                } else {
                                                    cls13 = cls35;
                                                    iOrdinal = i31;
                                                    i10 = i32;
                                                    i11 = i33;
                                                    r10 = field;
                                                }
                                                propertyNamingStrategy3 = propertyNamingStrategy2;
                                                if (propertyNamingStrategy3 != null) {
                                                    propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                                }
                                                fieldArr2 = fieldArr5;
                                                propertyNamingStrategy2 = propertyNamingStrategy3;
                                                add(arrayList, new FieldInfo(propertyNameByMethodName2, method3, field4, cls, type, iOrdinal, i10, i11, superMethodAnnotation, r10, null, mapBuildGenericInfo));
                                            } else {
                                                cls14 = cls;
                                                fieldArr5 = fieldArr2;
                                                if (zIsKotlin) {
                                                    propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName("g" + name3.substring(1));
                                                    field3 = field;
                                                } else {
                                                    if (TypeUtils.compatibleWithJavaBean) {
                                                        propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                                    } else {
                                                        propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name3);
                                                    }
                                                    field3 = field;
                                                }
                                                if (field3 == null) {
                                                    field3 = TypeUtils.getField(cls14, propertyNameByMethodName2, fieldArr5);
                                                }
                                                if (field3 == null) {
                                                    field4 = field3;
                                                } else {
                                                    field4 = field3;
                                                }
                                                if (field4 != null) {
                                                    cls15 = cls35;
                                                    jSONField = (JSONField) TypeUtils.getAnnotation(field4, cls15);
                                                    if (jSONField == null) {
                                                        cls13 = cls15;
                                                        r10 = jSONField;
                                                        iOrdinal = i31;
                                                        i10 = i32;
                                                        i11 = i33;
                                                    } else if (jSONField.deserialize()) {
                                                        cls13 = cls15;
                                                        fieldArr2 = fieldArr5;
                                                    } else {
                                                        iOrdinal = jSONField.ordinal();
                                                        iM3460of = SerializerFeature.m3460of(jSONField.serialzeFeatures());
                                                        iM3339of = Feature.m3339of(jSONField.parseFeatures());
                                                        if (jSONField.name().length() != 0) {
                                                            cls13 = cls15;
                                                            str = str;
                                                            methodArr = methodArr;
                                                            cls14 = cls14;
                                                            add(arrayList, new FieldInfo(jSONField.name(), method3, field4, cls, type, iOrdinal, iM3460of, iM3339of, superMethodAnnotation, jSONField, null, mapBuildGenericInfo));
                                                            fieldArr2 = fieldArr5;
                                                            propertyNamingStrategy2 = propertyNamingStrategy2;
                                                        } else {
                                                            cls13 = cls15;
                                                            r10 = jSONField;
                                                            i10 = iM3460of;
                                                            i11 = iM3339of;
                                                        }
                                                    }
                                                } else {
                                                    cls13 = cls35;
                                                    iOrdinal = i31;
                                                    i10 = i32;
                                                    i11 = i33;
                                                    r10 = field;
                                                }
                                                propertyNamingStrategy3 = propertyNamingStrategy2;
                                                if (propertyNamingStrategy3 != null) {
                                                    propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                                }
                                                fieldArr2 = fieldArr5;
                                                propertyNamingStrategy2 = propertyNamingStrategy3;
                                                add(arrayList, new FieldInfo(propertyNameByMethodName2, method3, field4, cls, type, iOrdinal, i10, i11, superMethodAnnotation, r10, null, mapBuildGenericInfo));
                                            }
                                            cls14 = cls14;
                                        } else {
                                            cCharAt = name3.charAt(3);
                                            if (zIsKotlin) {
                                                arrayList2 = new ArrayList();
                                                while (i12 < methodArr.length) {
                                                    if (methodArr[i12].getName().startsWith("get")) {
                                                        arrayList2.add(methodArr[i12].getName());
                                                    }
                                                }
                                            } else {
                                                arrayList2 = field;
                                            }
                                            if (!Character.isUpperCase(cCharAt)) {
                                                cls14 = cls;
                                                fieldArr5 = fieldArr2;
                                                if (zIsKotlin) {
                                                    propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName("g" + name3.substring(1));
                                                    field3 = field;
                                                } else {
                                                    if (TypeUtils.compatibleWithJavaBean) {
                                                        propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                                    } else {
                                                        propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name3);
                                                    }
                                                    field3 = field;
                                                }
                                                if (field3 == null) {
                                                    field3 = TypeUtils.getField(cls14, propertyNameByMethodName2, fieldArr5);
                                                }
                                                if (field3 == null) {
                                                    field4 = field3;
                                                } else {
                                                    field4 = field3;
                                                }
                                                if (field4 != null) {
                                                    cls15 = cls35;
                                                    jSONField = (JSONField) TypeUtils.getAnnotation(field4, cls15);
                                                    if (jSONField == null) {
                                                        cls13 = cls15;
                                                        r10 = jSONField;
                                                        iOrdinal = i31;
                                                        i10 = i32;
                                                        i11 = i33;
                                                    } else if (jSONField.deserialize()) {
                                                        cls13 = cls15;
                                                        fieldArr2 = fieldArr5;
                                                    } else {
                                                        iOrdinal = jSONField.ordinal();
                                                        iM3460of = SerializerFeature.m3460of(jSONField.serialzeFeatures());
                                                        iM3339of = Feature.m3339of(jSONField.parseFeatures());
                                                        if (jSONField.name().length() != 0) {
                                                            cls13 = cls15;
                                                            str = str;
                                                            methodArr = methodArr;
                                                            cls14 = cls14;
                                                            add(arrayList, new FieldInfo(jSONField.name(), method3, field4, cls, type, iOrdinal, iM3460of, iM3339of, superMethodAnnotation, jSONField, null, mapBuildGenericInfo));
                                                            fieldArr2 = fieldArr5;
                                                            propertyNamingStrategy2 = propertyNamingStrategy2;
                                                        } else {
                                                            cls13 = cls15;
                                                            r10 = jSONField;
                                                            i10 = iM3460of;
                                                            i11 = iM3339of;
                                                        }
                                                    }
                                                } else {
                                                    cls13 = cls35;
                                                    iOrdinal = i31;
                                                    i10 = i32;
                                                    i11 = i33;
                                                    r10 = field;
                                                }
                                                propertyNamingStrategy3 = propertyNamingStrategy2;
                                                if (propertyNamingStrategy3 != null) {
                                                    propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                                }
                                                fieldArr2 = fieldArr5;
                                                propertyNamingStrategy2 = propertyNamingStrategy3;
                                                add(arrayList, new FieldInfo(propertyNameByMethodName2, method3, field4, cls, type, iOrdinal, i10, i11, superMethodAnnotation, r10, null, mapBuildGenericInfo));
                                            } else {
                                                cls14 = cls;
                                                fieldArr5 = fieldArr2;
                                                if (zIsKotlin) {
                                                    propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName("g" + name3.substring(1));
                                                    field3 = field;
                                                } else {
                                                    if (TypeUtils.compatibleWithJavaBean) {
                                                        propertyNameByMethodName2 = TypeUtils.decapitalize(name3.substring(3));
                                                    } else {
                                                        propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name3);
                                                    }
                                                    field3 = field;
                                                }
                                                if (field3 == null) {
                                                    field3 = TypeUtils.getField(cls14, propertyNameByMethodName2, fieldArr5);
                                                }
                                                if (field3 == null) {
                                                    field4 = field3;
                                                } else {
                                                    field4 = field3;
                                                }
                                                if (field4 != null) {
                                                    cls15 = cls35;
                                                    jSONField = (JSONField) TypeUtils.getAnnotation(field4, cls15);
                                                    if (jSONField == null) {
                                                        cls13 = cls15;
                                                        r10 = jSONField;
                                                        iOrdinal = i31;
                                                        i10 = i32;
                                                        i11 = i33;
                                                    } else if (jSONField.deserialize()) {
                                                        cls13 = cls15;
                                                        fieldArr2 = fieldArr5;
                                                    } else {
                                                        iOrdinal = jSONField.ordinal();
                                                        iM3460of = SerializerFeature.m3460of(jSONField.serialzeFeatures());
                                                        iM3339of = Feature.m3339of(jSONField.parseFeatures());
                                                        if (jSONField.name().length() != 0) {
                                                            cls13 = cls15;
                                                            str = str;
                                                            methodArr = methodArr;
                                                            cls14 = cls14;
                                                            add(arrayList, new FieldInfo(jSONField.name(), method3, field4, cls, type, iOrdinal, iM3460of, iM3339of, superMethodAnnotation, jSONField, null, mapBuildGenericInfo));
                                                            fieldArr2 = fieldArr5;
                                                            propertyNamingStrategy2 = propertyNamingStrategy2;
                                                        } else {
                                                            cls13 = cls15;
                                                            r10 = jSONField;
                                                            i10 = iM3460of;
                                                            i11 = iM3339of;
                                                        }
                                                    }
                                                } else {
                                                    cls13 = cls35;
                                                    iOrdinal = i31;
                                                    i10 = i32;
                                                    i11 = i33;
                                                    r10 = field;
                                                }
                                                propertyNamingStrategy3 = propertyNamingStrategy2;
                                                if (propertyNamingStrategy3 != null) {
                                                    propertyNameByMethodName2 = propertyNamingStrategy3.translate(propertyNameByMethodName2);
                                                }
                                                fieldArr2 = fieldArr5;
                                                propertyNamingStrategy2 = propertyNamingStrategy3;
                                                add(arrayList, new FieldInfo(propertyNameByMethodName2, method3, field4, cls, type, iOrdinal, i10, i11, superMethodAnnotation, r10, null, mapBuildGenericInfo));
                                            }
                                            cls14 = cls14;
                                        }
                                    }
                                    cls13 = cls35;
                                    cls14 = cls;
                                }
                            }
                            methodArr = methodArr;
                            cls13 = cls35;
                            cls14 = cls24;
                        }
                    }
                    cls11 = cls11;
                } else {
                    cls11 = cls2;
                }
                cls12 = cls7;
                cls13 = cls6;
                cls14 = cls24;
            }
            i30++;
            cls24 = cls14;
            methodArr = methodArr;
            field = field;
            cls8 = cls8;
            cls7 = cls12;
            cls2 = cls11;
            length6 = length6;
            str = str;
            cls6 = cls13;
            propertyNamingStrategy2 = propertyNamingStrategy2;
        }
        Field field7 = field;
        Class<?> cls37 = cls8;
        Class<?> cls38 = cls24;
        Class<JSONField> cls39 = cls6;
        PropertyNamingStrategy propertyNamingStrategy6 = propertyNamingStrategy2;
        int i34 = 3;
        computeFields(cls38, type, propertyNamingStrategy6, arrayList, cls.getFields());
        Method[] methods3 = cls.getMethods();
        int length7 = methods3.length;
        int i35 = 0;
        while (i35 < length7) {
            Method method4 = methods3[i35];
            String name4 = method4.getName();
            if (name4.length() < i6 || Modifier.isStatic(method4.getModifiers())) {
                cls9 = cls3;
                fieldArr3 = fieldArr2;
                cls10 = cls39;
            } else if (cls37 == null && name4.startsWith(str2) && Character.isUpperCase(name4.charAt(i34))) {
                if (method4.getParameterTypes().length != 0) {
                    cls9 = cls3;
                } else {
                    Class<Collection> cls40 = cls3;
                    if (cls40.isAssignableFrom(method4.getReturnType()) || Map.class.isAssignableFrom(method4.getReturnType()) || AtomicBoolean.class == method4.getReturnType() || AtomicInteger.class == method4.getReturnType() || AtomicLong.class == method4.getReturnType()) {
                        Class<JSONField> cls41 = cls39;
                        JSONField jSONField7 = (JSONField) TypeUtils.getAnnotation(method4, cls41);
                        if (jSONField7 == null || !jSONField7.deserialize()) {
                            if (jSONField7 != null && jSONField7.name().length() > 0) {
                                propertyNameByMethodName = jSONField7.name();
                                field2 = field7;
                                fieldArr4 = fieldArr2;
                            } else {
                                propertyNameByMethodName = TypeUtils.getPropertyNameByMethodName(name4);
                                fieldArr4 = fieldArr2;
                                Field field8 = TypeUtils.getField(cls38, propertyNameByMethodName, fieldArr4);
                                if (field8 == null) {
                                    field2 = field7;
                                } else {
                                    JSONField jSONField8 = (JSONField) TypeUtils.getAnnotation(field8, cls41);
                                    if (jSONField8 == null || jSONField8.deserialize()) {
                                        if (cls40.isAssignableFrom(method4.getReturnType()) || Map.class.isAssignableFrom(method4.getReturnType())) {
                                            field2 = field8;
                                        } else {
                                            field2 = field7;
                                        }
                                    }
                                }
                                fieldArr3 = fieldArr4;
                                cls10 = cls41;
                                cls9 = cls40;
                                i35 = i35;
                                str2 = str2;
                                length7 = length7;
                                methods3 = methods3;
                                propertyNamingStrategy6 = propertyNamingStrategy6;
                            }
                            if (propertyNamingStrategy6 != null) {
                                propertyNameByMethodName = propertyNamingStrategy6.translate(propertyNameByMethodName);
                            }
                            String str11 = propertyNameByMethodName;
                            if (getField(arrayList, str11) == null) {
                                fieldArr3 = fieldArr4;
                                cls10 = cls41;
                                cls9 = cls40;
                                add(arrayList, new FieldInfo(str11, method4, field2, cls, type, 0, 0, 0, jSONField7, null, null, mapBuildGenericInfo));
                            }
                            fieldArr3 = fieldArr4;
                            cls10 = cls41;
                            cls9 = cls40;
                            i35 = i35;
                            str2 = str2;
                            length7 = length7;
                            methods3 = methods3;
                            propertyNamingStrategy6 = propertyNamingStrategy6;
                        } else {
                            cls10 = cls41;
                            cls9 = cls40;
                            i35 = i35;
                            str2 = str2;
                            length7 = length7;
                            methods3 = methods3;
                            propertyNamingStrategy6 = propertyNamingStrategy6;
                            fieldArr3 = fieldArr2;
                        }
                    } else {
                        cls9 = cls40;
                    }
                }
                fieldArr3 = fieldArr2;
                cls10 = cls39;
            } else {
                cls9 = cls3;
                fieldArr3 = fieldArr2;
                cls10 = cls39;
            }
            i35++;
            methods3 = methods3;
            str2 = str2;
            length7 = length7;
            cls39 = cls10;
            cls3 = cls9;
            fieldArr2 = fieldArr3;
            propertyNamingStrategy6 = propertyNamingStrategy6;
            i6 = 4;
            i34 = 3;
        }
        PropertyNamingStrategy propertyNamingStrategy7 = propertyNamingStrategy6;
        Field[] fieldArr7 = fieldArr2;
        if (arrayList.size() == 0) {
            if (TypeUtils.isXmlField(cls) ? true : z7) {
                for (Class<?> superclass2 = cls38; superclass2 != null; superclass2 = superclass2.getSuperclass()) {
                    computeFields(cls38, type, propertyNamingStrategy7, arrayList, fieldArr7);
                }
            }
        }
        return new JavaBeanInfo(cls, cls37, constructor, constructor2, factoryMethod, method, jSONType, arrayList);
    }
}

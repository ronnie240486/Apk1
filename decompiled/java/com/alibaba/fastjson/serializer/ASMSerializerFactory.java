package com.alibaba.fastjson.serializer;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.asm.ClassWriter;
import com.alibaba.fastjson.asm.FieldWriter;
import com.alibaba.fastjson.asm.Label;
import com.alibaba.fastjson.asm.MethodVisitor;
import com.alibaba.fastjson.asm.MethodWriter;
import com.alibaba.fastjson.asm.Opcodes;
import com.alibaba.fastjson.asm.Type;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.lzy.okgo.cookie.SerializableCookie;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.HttpUrl;
import p000a.AbstractC0004e;
import p055ea.AbstractC2460q;

public class ASMSerializerFactory implements Opcodes {
    static final String JSONSerializer = ASMUtils.type(JSONSerializer.class);
    static final String JavaBeanSerializer;
    static final String JavaBeanSerializer_desc;
    static final String ObjectSerializer;
    static final String ObjectSerializer_desc;
    static final String SerialContext_desc;
    static final String SerializeFilterable_desc;
    static final String SerializeWriter;
    static final String SerializeWriter_desc;
    protected final ASMClassLoader classLoader = new ASMClassLoader();
    private final AtomicLong seed = new AtomicLong();

    static {
        String strType = ASMUtils.type(ObjectSerializer.class);
        ObjectSerializer = strType;
        ObjectSerializer_desc = AbstractC0004e.m24r("L", strType, ";");
        String strType2 = ASMUtils.type(SerializeWriter.class);
        SerializeWriter = strType2;
        SerializeWriter_desc = AbstractC0004e.m24r("L", strType2, ";");
        JavaBeanSerializer = ASMUtils.type(JavaBeanSerializer.class);
        JavaBeanSerializer_desc = "L" + ASMUtils.type(JavaBeanSerializer.class) + ";";
        SerialContext_desc = ASMUtils.desc((Class<?>) SerialContext.class);
        SerializeFilterable_desc = ASMUtils.desc((Class<?>) SerializeFilterable.class);
    }

    private void _after(MethodVisitor methodVisitor, Context context) {
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JavaBeanSerializer, "writeAfter", AbstractC0004e.m26t(new StringBuilder("(L"), JSONSerializer, ";Ljava/lang/Object;C)C"));
        methodVisitor.visitVarInsn(54, context.var("seperator"));
    }

    private void _apply(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Class<?> cls = fieldInfo.fieldClass;
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(25, Context.fieldName);
        if (cls == Byte.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("byte"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (cls == Short.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("short"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (cls == Integer.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("int"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (cls == Character.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("char"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (cls == Long.TYPE) {
            methodVisitor.visitVarInsn(22, context.var("long", 2));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (cls == Float.TYPE) {
            methodVisitor.visitVarInsn(23, context.var("float"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (cls == Double.TYPE) {
            methodVisitor.visitVarInsn(24, context.var("double", 2));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        } else if (cls == Boolean.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("boolean"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (cls == BigDecimal.class) {
            methodVisitor.visitVarInsn(25, context.var("decimal"));
        } else if (cls == String.class) {
            methodVisitor.visitVarInsn(25, context.var("string"));
        } else if (cls.isEnum()) {
            methodVisitor.visitVarInsn(25, context.var("enum"));
        } else if (List.class.isAssignableFrom(cls)) {
            methodVisitor.visitVarInsn(25, context.var("list"));
        } else {
            methodVisitor.visitVarInsn(25, context.var("object"));
        }
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JavaBeanSerializer, "apply", AbstractC0004e.m26t(new StringBuilder("(L"), JSONSerializer, ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z"));
    }

    private void _before(MethodVisitor methodVisitor, Context context) {
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JavaBeanSerializer, "writeBefore", AbstractC0004e.m26t(new StringBuilder("(L"), JSONSerializer, ";Ljava/lang/Object;C)C"));
        methodVisitor.visitVarInsn(54, context.var("seperator"));
    }

    private void _decimal(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(58, context.var("decimal"));
        _filters(methodVisitor, fieldInfo, context, label);
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        methodVisitor.visitLabel(label2);
        methodVisitor.visitVarInsn(25, context.var("decimal"));
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label3);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label4);
        methodVisitor.visitLabel(label3);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(25, context.var("decimal"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;Ljava/math/BigDecimal;)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label4);
        methodVisitor.visitLabel(label4);
        methodVisitor.visitLabel(label);
    }

    private void _double(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(57, context.var("double", 2));
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(24, context.var("double", 2));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;D)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _enum(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label3);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitTypeInsn(192, "java/lang/Enum");
        methodVisitor.visitVarInsn(58, context.var("enum"));
        _filters(methodVisitor, fieldInfo, context, label3);
        methodVisitor.visitVarInsn(25, context.var("enum"));
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label2);
        methodVisitor.visitLabel(label);
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(25, context.var("enum"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Enum", SerializableCookie.NAME, "()Ljava/lang/String;");
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValueStringWithDoubleQuote", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            String str = SerializeWriter;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "write", "(I)V");
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitInsn(3);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "writeFieldName", "(Ljava/lang/String;Z)V");
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var("enum"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
            methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        }
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label2);
        methodVisitor.visitLabel(label3);
    }

    private void _filters(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        if (fieldInfo.fieldTransient) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.SkipTransientField.mask));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor.visitJumpInsn(Opcodes.IFNE, label);
        }
        _notWriteDefault(methodVisitor, fieldInfo, context, label);
        if (context.writeDirect) {
            return;
        }
        _apply(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
        _processKey(methodVisitor, fieldInfo, context);
        _processValue(methodVisitor, fieldInfo, context, label);
    }

    private void _float(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(56, context.var("float"));
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(23, context.var("float"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;F)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _get(MethodVisitor methodVisitor, Context context, FieldInfo fieldInfo) {
        Method method = fieldInfo.method;
        if (method != null) {
            methodVisitor.visitVarInsn(25, context.var("entity"));
            Class<?> declaringClass = method.getDeclaringClass();
            methodVisitor.visitMethodInsn(declaringClass.isInterface() ? Opcodes.INVOKEINTERFACE : Opcodes.INVOKEVIRTUAL, ASMUtils.type(declaringClass), method.getName(), ASMUtils.desc(method));
            if (method.getReturnType().equals(fieldInfo.fieldClass)) {
                return;
            }
            methodVisitor.visitTypeInsn(192, ASMUtils.type(fieldInfo.fieldClass));
            return;
        }
        methodVisitor.visitVarInsn(25, context.var("entity"));
        Field field = fieldInfo.field;
        methodVisitor.visitFieldInsn(Opcodes.GETFIELD, ASMUtils.type(fieldInfo.declaringClass), field.getName(), ASMUtils.desc(field.getType()));
        if (field.getType().equals(fieldInfo.fieldClass)) {
            return;
        }
        methodVisitor.visitTypeInsn(192, ASMUtils.type(fieldInfo.fieldClass));
    }

    private void _getFieldSer(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        String str = context.className;
        String strM26t = AbstractC0004e.m26t(new StringBuilder(), fieldInfo.name, "_asm_ser_");
        String str2 = ObjectSerializer_desc;
        methodVisitor.visitFieldInsn(Opcodes.GETFIELD, str, strM26t, str2);
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "getObjectWriter", AbstractC2460q.m5501o("(Ljava/lang/Class;)", str2));
        methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, context.className, AbstractC0004e.m26t(new StringBuilder(), fieldInfo.name, "_asm_ser_"), str2);
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(Opcodes.GETFIELD, context.className, AbstractC0004e.m26t(new StringBuilder(), fieldInfo.name, "_asm_ser_"), str2);
    }

    private void _getListFieldItemSer(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo, Class<?> cls) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        String str = context.className;
        String strM26t = AbstractC0004e.m26t(new StringBuilder(), fieldInfo.name, "_asm_list_item_ser_");
        String str2 = ObjectSerializer_desc;
        methodVisitor.visitFieldInsn(Opcodes.GETFIELD, str, strM26t, str2);
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls)));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "getObjectWriter", AbstractC2460q.m5501o("(Ljava/lang/Class;)", str2));
        methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, context.className, AbstractC0004e.m26t(new StringBuilder(), fieldInfo.name, "_asm_list_item_ser_"), str2);
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(Opcodes.GETFIELD, context.className, AbstractC0004e.m26t(new StringBuilder(), fieldInfo.name, "_asm_list_item_ser_"), str2);
    }

    private void _if_write_null(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        int i6;
        int mask;
        int mask2;
        Class<?> cls = fieldInfo.fieldClass;
        Label label = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        methodVisitor.visitLabel(label);
        JSONField annotation = fieldInfo.getAnnotation();
        int iM3460of = annotation != null ? SerializerFeature.m3460of(annotation.serialzeFeatures()) : 0;
        JSONType jSONType = context.beanInfo.jsonType;
        if (jSONType != null) {
            iM3460of |= SerializerFeature.m3460of(jSONType.serialzeFeatures());
        }
        if (cls == String.class) {
            mask = SerializerFeature.WriteMapNullValue.getMask();
            mask2 = SerializerFeature.WriteNullStringAsEmpty.getMask();
        } else if (Number.class.isAssignableFrom(cls)) {
            mask = SerializerFeature.WriteMapNullValue.getMask();
            mask2 = SerializerFeature.WriteNullNumberAsZero.getMask();
        } else {
            if (!Collection.class.isAssignableFrom(cls)) {
                if (Boolean.class == cls) {
                    mask = SerializerFeature.WriteMapNullValue.getMask();
                    mask2 = SerializerFeature.WriteNullBooleanAsFalse.getMask();
                } else {
                    i6 = SerializerFeature.WRITE_MAP_NULL_FEATURES;
                }
                if ((iM3460of & i6) == 0) {
                    methodVisitor.visitVarInsn(25, context.var("out"));
                    methodVisitor.visitLdcInsn(Integer.valueOf(i6));
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
                    methodVisitor.visitJumpInsn(Opcodes.IFEQ, label2);
                }
                methodVisitor.visitLabel(label3);
                methodVisitor.visitVarInsn(25, context.var("out"));
                methodVisitor.visitVarInsn(21, context.var("seperator"));
                String str = SerializeWriter;
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "write", "(I)V");
                _writeFieldName(methodVisitor, context);
                methodVisitor.visitVarInsn(25, context.var("out"));
                methodVisitor.visitLdcInsn(Integer.valueOf(iM3460of));
                if (cls != String.class || cls == Character.class) {
                    methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullStringAsEmpty.mask));
                } else if (Number.class.isAssignableFrom(cls)) {
                    methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullNumberAsZero.mask));
                } else if (cls == Boolean.class) {
                    methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullBooleanAsFalse.mask));
                } else if (Collection.class.isAssignableFrom(cls) || cls.isArray()) {
                    methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullListAsEmpty.mask));
                } else {
                    methodVisitor.visitLdcInsn(0);
                }
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "writeNull", "(II)V");
                _seperator(methodVisitor, context);
                methodVisitor.visitJumpInsn(Opcodes.GOTO, label4);
                methodVisitor.visitLabel(label2);
                methodVisitor.visitLabel(label4);
            }
            mask = SerializerFeature.WriteMapNullValue.getMask();
            mask2 = SerializerFeature.WriteNullListAsEmpty.getMask();
        }
        i6 = mask | mask2;
        if ((iM3460of & i6) == 0) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitLdcInsn(Integer.valueOf(i6));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label2);
        }
        methodVisitor.visitLabel(label3);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        String str2 = SerializeWriter;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, "write", "(I)V");
        _writeFieldName(methodVisitor, context);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitLdcInsn(Integer.valueOf(iM3460of));
        if (cls != String.class) {
            methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullStringAsEmpty.mask));
        } else {
            methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.WriteNullStringAsEmpty.mask));
        }
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, "writeNull", "(II)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label4);
        methodVisitor.visitLabel(label2);
        methodVisitor.visitLabel(label4);
    }

    private void _int(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, int i6, char c5) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(54, i6);
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(21, i6);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;" + c5 + ")V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _labelApply(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(fieldInfo.label);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JavaBeanSerializer, "applyLabel", AbstractC0004e.m26t(new StringBuilder("(L"), JSONSerializer, ";Ljava/lang/String;)Z"));
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
    }

    private void _list(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label;
        String str;
        FieldInfo fieldInfo2;
        Label label2;
        int i6;
        int i10;
        int i11;
        java.lang.reflect.Type collectionItemType = TypeUtils.getCollectionItemType(fieldInfo.fieldType);
        Class<?> cls2 = null;
        Class<?> cls3 = collectionItemType instanceof Class ? (Class) collectionItemType : null;
        if (cls3 != Object.class && cls3 != Serializable.class) {
            cls2 = cls3;
        }
        Label label3 = new Label();
        Label label4 = new Label();
        Label label5 = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label3);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitTypeInsn(192, "java/util/List");
        methodVisitor.visitVarInsn(58, context.var("list"));
        _filters(methodVisitor, fieldInfo, context, label3);
        methodVisitor.visitVarInsn(25, context.var("list"));
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label4);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label5);
        methodVisitor.visitLabel(label4);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        String str2 = SerializeWriter;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, "write", "(I)V");
        _writeFieldName(methodVisitor, context);
        methodVisitor.visitVarInsn(25, context.var("list"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/List", "size", "()I");
        methodVisitor.visitVarInsn(54, context.var("size"));
        Label label6 = new Label();
        Label label7 = new Label();
        methodVisitor.visitVarInsn(21, context.var("size"));
        methodVisitor.visitInsn(3);
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label6);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitLdcInsn(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, "write", "(Ljava/lang/String;)V");
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label7);
        methodVisitor.visitLabel(label6);
        if (!context.nonContext) {
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var("list"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)V");
        }
        if (collectionItemType == String.class && context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(25, context.var("list"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, "write", "(Ljava/util/List;)V");
            i6 = 1;
            i10 = 25;
            i11 = Opcodes.INVOKEVIRTUAL;
        } else {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(16, 91);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, "write", "(I)V");
            Label label8 = new Label();
            Label label9 = new Label();
            Label label10 = new Label();
            methodVisitor.visitInsn(3);
            methodVisitor.visitVarInsn(54, context.var(CmcdData.OBJECT_TYPE_INIT_SEGMENT));
            methodVisitor.visitLabel(label8);
            methodVisitor.visitVarInsn(21, context.var(CmcdData.OBJECT_TYPE_INIT_SEGMENT));
            methodVisitor.visitVarInsn(21, context.var("size"));
            methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label10);
            methodVisitor.visitVarInsn(21, context.var(CmcdData.OBJECT_TYPE_INIT_SEGMENT));
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label9);
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(16, 44);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, "write", "(I)V");
            methodVisitor.visitLabel(label9);
            methodVisitor.visitVarInsn(25, context.var("list"));
            methodVisitor.visitVarInsn(21, context.var(CmcdData.OBJECT_TYPE_INIT_SEGMENT));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/List", "get", "(I)Ljava/lang/Object;");
            methodVisitor.visitVarInsn(58, context.var("list_item"));
            Label label11 = new Label();
            Label label12 = new Label();
            methodVisitor.visitVarInsn(25, context.var("list_item"));
            methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label12);
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, "writeNull", "()V");
            methodVisitor.visitJumpInsn(Opcodes.GOTO, label11);
            methodVisitor.visitLabel(label12);
            Label label13 = new Label();
            Label label14 = new Label();
            if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                label11 = label11;
                label = label13;
                str = "write";
                fieldInfo2 = fieldInfo;
                label2 = label14;
            } else {
                methodVisitor.visitVarInsn(25, context.var("list_item"));
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
                methodVisitor.visitJumpInsn(Opcodes.IF_ACMPNE, label14);
                _getListFieldItemSer(context, methodVisitor, fieldInfo, cls2);
                methodVisitor.visitVarInsn(58, context.var("list_item_desc"));
                Label label15 = new Label();
                Label label16 = new Label();
                if (context.writeDirect) {
                    String str3 = (context.nonContext && context.writeDirect) ? "writeDirectNonContext" : "write";
                    methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                    String str4 = JavaBeanSerializer;
                    methodVisitor.visitTypeInsn(Opcodes.INSTANCEOF, str4);
                    methodVisitor.visitJumpInsn(Opcodes.IFEQ, label15);
                    methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                    methodVisitor.visitTypeInsn(192, str4);
                    methodVisitor.visitVarInsn(25, 1);
                    methodVisitor.visitVarInsn(25, context.var("list_item"));
                    if (context.nonContext) {
                        methodVisitor.visitInsn(1);
                    } else {
                        methodVisitor.visitVarInsn(21, context.var(CmcdData.OBJECT_TYPE_INIT_SEGMENT));
                        methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                    }
                    methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
                    methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str4, str3, AbstractC0004e.m26t(new StringBuilder("(L"), JSONSerializer, ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"));
                    methodVisitor.visitJumpInsn(Opcodes.GOTO, label16);
                    methodVisitor.visitLabel(label15);
                } else {
                    label11 = label11;
                    label14 = label14;
                }
                methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitVarInsn(25, context.var("list_item"));
                if (context.nonContext) {
                    methodVisitor.visitInsn(1);
                } else {
                    methodVisitor.visitVarInsn(21, context.var(CmcdData.OBJECT_TYPE_INIT_SEGMENT));
                    methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                }
                methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
                fieldInfo2 = fieldInfo;
                methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo2.serialzeFeatures));
                str = "write";
                methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, ObjectSerializer, str, AbstractC0004e.m26t(new StringBuilder("(L"), JSONSerializer, ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"));
                methodVisitor.visitLabel(label16);
                label = label13;
                methodVisitor.visitJumpInsn(Opcodes.GOTO, label);
                label2 = label14;
            }
            methodVisitor.visitLabel(label2);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var("list_item"));
            if (context.nonContext) {
                methodVisitor.visitInsn(1);
            } else {
                methodVisitor.visitVarInsn(21, context.var(CmcdData.OBJECT_TYPE_INIT_SEGMENT));
                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            }
            if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            } else {
                methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc((Class<?>) collectionItemType)));
                methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo2.serialzeFeatures));
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            }
            methodVisitor.visitLabel(label);
            methodVisitor.visitLabel(label11);
            i6 = 1;
            methodVisitor.visitIincInsn(context.var(CmcdData.OBJECT_TYPE_INIT_SEGMENT), 1);
            methodVisitor.visitJumpInsn(Opcodes.GOTO, label8);
            methodVisitor.visitLabel(label10);
            i10 = 25;
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(16, 93);
            i11 = Opcodes.INVOKEVIRTUAL;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, str, "(I)V");
        }
        methodVisitor.visitVarInsn(i10, i6);
        methodVisitor.visitMethodInsn(i11, JSONSerializer, "popContext", "()V");
        methodVisitor.visitLabel(label7);
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label5);
        methodVisitor.visitLabel(label3);
    }

    private void _long(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(55, context.var("long", 2));
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, Context.fieldName);
        methodVisitor.visitVarInsn(22, context.var("long", 2));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;J)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _nameApply(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        if (!context.writeDirect) {
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JavaBeanSerializer, "applyName", AbstractC0004e.m26t(new StringBuilder("(L"), JSONSerializer, ";Ljava/lang/Object;Ljava/lang/String;)Z"));
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
            _labelApply(methodVisitor, fieldInfo, context, label);
        }
        if (fieldInfo.field == null) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.IgnoreNonFieldGetter.mask));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor.visitJumpInsn(Opcodes.IFNE, label);
        }
    }

    private void _notWriteDefault(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        if (context.writeDirect) {
            return;
        }
        Label label2 = new Label();
        methodVisitor.visitVarInsn(21, context.var("notWriteDefaultValue"));
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label2);
        Class<?> cls = fieldInfo.fieldClass;
        if (cls == Boolean.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("boolean"));
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
        } else if (cls == Byte.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("byte"));
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
        } else if (cls == Short.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("short"));
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
        } else if (cls == Integer.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("int"));
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
        } else if (cls == Long.TYPE) {
            methodVisitor.visitVarInsn(22, context.var("long"));
            methodVisitor.visitInsn(9);
            methodVisitor.visitInsn(Opcodes.LCMP);
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
        } else if (cls == Float.TYPE) {
            methodVisitor.visitVarInsn(23, context.var("float"));
            methodVisitor.visitInsn(11);
            methodVisitor.visitInsn(Opcodes.FCMPL);
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
        } else if (cls == Double.TYPE) {
            methodVisitor.visitVarInsn(24, context.var("double"));
            methodVisitor.visitInsn(14);
            methodVisitor.visitInsn(Opcodes.DCMPL);
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
        }
        methodVisitor.visitLabel(label2);
    }

    private void _object(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(58, context.var("object"));
        _filters(methodVisitor, fieldInfo, context, label);
        _writeObject(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitLabel(label);
    }

    private void _processKey(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        methodVisitor.visitVarInsn(21, context.var("hasNameFilters"));
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
        Class<?> cls = fieldInfo.fieldClass;
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(25, Context.fieldName);
        if (cls == Byte.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("byte"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (cls == Short.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("short"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (cls == Integer.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("int"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (cls == Character.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("char"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (cls == Long.TYPE) {
            methodVisitor.visitVarInsn(22, context.var("long", 2));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (cls == Float.TYPE) {
            methodVisitor.visitVarInsn(23, context.var("float"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (cls == Double.TYPE) {
            methodVisitor.visitVarInsn(24, context.var("double", 2));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        } else if (cls == Boolean.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("boolean"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (cls == BigDecimal.class) {
            methodVisitor.visitVarInsn(25, context.var("decimal"));
        } else if (cls == String.class) {
            methodVisitor.visitVarInsn(25, context.var("string"));
        } else if (cls.isEnum()) {
            methodVisitor.visitVarInsn(25, context.var("enum"));
        } else if (List.class.isAssignableFrom(cls)) {
            methodVisitor.visitVarInsn(25, context.var("list"));
        } else {
            methodVisitor.visitVarInsn(25, context.var("object"));
        }
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JavaBeanSerializer, "processKey", AbstractC0004e.m26t(new StringBuilder("(L"), JSONSerializer, ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;"));
        methodVisitor.visitVarInsn(58, Context.fieldName);
        methodVisitor.visitLabel(label);
    }

    private void _processValue(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        Label label2 = new Label();
        Class<?> cls = fieldInfo.fieldClass;
        if (cls.isPrimitive()) {
            Label label3 = new Label();
            methodVisitor.visitVarInsn(21, context.var("checkValue"));
            methodVisitor.visitJumpInsn(Opcodes.IFNE, label3);
            methodVisitor.visitInsn(1);
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, Context.original);
            methodVisitor.visitVarInsn(58, Context.processValue);
            methodVisitor.visitJumpInsn(Opcodes.GOTO, label2);
            methodVisitor.visitLabel(label3);
        }
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitLdcInsn(Integer.valueOf(context.getFieldOrinal(fieldInfo.name)));
        String str = JavaBeanSerializer;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "getBeanContext", "(I)" + ASMUtils.desc((Class<?>) BeanContext.class));
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(25, Context.fieldName);
        if (cls == Byte.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("byte"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, Context.original);
        } else if (cls == Short.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("short"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, Context.original);
        } else if (cls == Integer.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("int"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, Context.original);
        } else if (cls == Character.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("char"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, Context.original);
        } else if (cls == Long.TYPE) {
            methodVisitor.visitVarInsn(22, context.var("long", 2));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, Context.original);
        } else if (cls == Float.TYPE) {
            methodVisitor.visitVarInsn(23, context.var("float"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, Context.original);
        } else if (cls == Double.TYPE) {
            methodVisitor.visitVarInsn(24, context.var("double", 2));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, Context.original);
        } else if (cls == Boolean.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("boolean"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, Context.original);
        } else if (cls == BigDecimal.class) {
            methodVisitor.visitVarInsn(25, context.var("decimal"));
            methodVisitor.visitVarInsn(58, Context.original);
            methodVisitor.visitVarInsn(25, Context.original);
        } else if (cls == String.class) {
            methodVisitor.visitVarInsn(25, context.var("string"));
            methodVisitor.visitVarInsn(58, Context.original);
            methodVisitor.visitVarInsn(25, Context.original);
        } else if (cls.isEnum()) {
            methodVisitor.visitVarInsn(25, context.var("enum"));
            methodVisitor.visitVarInsn(58, Context.original);
            methodVisitor.visitVarInsn(25, Context.original);
        } else if (List.class.isAssignableFrom(cls)) {
            methodVisitor.visitVarInsn(25, context.var("list"));
            methodVisitor.visitVarInsn(58, Context.original);
            methodVisitor.visitVarInsn(25, Context.original);
        } else {
            methodVisitor.visitVarInsn(25, context.var("object"));
            methodVisitor.visitVarInsn(58, Context.original);
            methodVisitor.visitVarInsn(25, Context.original);
        }
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "processValue", "(L" + JSONSerializer + ";" + ASMUtils.desc((Class<?>) BeanContext.class) + "Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;");
        methodVisitor.visitVarInsn(58, Context.processValue);
        methodVisitor.visitVarInsn(25, Context.original);
        methodVisitor.visitVarInsn(25, Context.processValue);
        methodVisitor.visitJumpInsn(Opcodes.IF_ACMPEQ, label2);
        _writeObject(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label);
        methodVisitor.visitLabel(label2);
    }

    private void _seperator(MethodVisitor methodVisitor, Context context) {
        methodVisitor.visitVarInsn(16, 44);
        methodVisitor.visitVarInsn(54, context.var("seperator"));
    }

    private void _string(Class<?> cls, MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context) {
        Label label = new Label();
        if (fieldInfo.name.equals(context.beanInfo.typeKey)) {
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 4);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
            methodVisitor.visitJumpInsn(Opcodes.IFNE, label);
        }
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(58, context.var("string"));
        _filters(methodVisitor, fieldInfo, context, label);
        Label label2 = new Label();
        Label label3 = new Label();
        methodVisitor.visitVarInsn(25, context.var("string"));
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label2);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label3);
        methodVisitor.visitLabel(label2);
        if ("trim".equals(fieldInfo.format)) {
            methodVisitor.visitVarInsn(25, context.var("string"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "trim", "()Ljava/lang/String;");
            methodVisitor.visitVarInsn(58, context.var("string"));
        }
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(25, context.var("string"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValueStringWithDoubleQuoteCheck", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(25, context.var("string"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;Ljava/lang/String;)V");
        }
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label3);
        methodVisitor.visitLabel(label);
    }

    private void _writeFieldName(MethodVisitor methodVisitor, Context context) {
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldNameDirect", "(Ljava/lang/String;)V");
        } else {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitInsn(3);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldName", "(Ljava/lang/String;Z)V");
        }
    }

    private void _writeObject(MethodVisitor methodVisitor, FieldInfo fieldInfo, Context context, Label label) {
        Label label2;
        Label label3;
        String str;
        String format = fieldInfo.getFormat();
        Class<?> cls = fieldInfo.fieldClass;
        Label label4 = new Label();
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("object"));
        } else {
            methodVisitor.visitVarInsn(25, Context.processValue);
        }
        methodVisitor.visitInsn(89);
        methodVisitor.visitVarInsn(58, context.var("object"));
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label4);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label);
        methodVisitor.visitLabel(label4);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "write", "(I)V");
        _writeFieldName(methodVisitor, context);
        Label label5 = new Label();
        Label label6 = new Label();
        if (!Modifier.isPublic(cls.getModifiers()) || ParserConfig.isPrimitive2(cls)) {
            label2 = label5;
            label3 = label6;
        } else {
            methodVisitor.visitVarInsn(25, context.var("object"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls)));
            methodVisitor.visitJumpInsn(Opcodes.IF_ACMPNE, label6);
            _getFieldSer(context, methodVisitor, fieldInfo);
            methodVisitor.visitVarInsn(58, context.var("fied_ser"));
            Label label7 = new Label();
            Label label8 = new Label();
            methodVisitor.visitVarInsn(25, context.var("fied_ser"));
            String str2 = JavaBeanSerializer;
            methodVisitor.visitTypeInsn(Opcodes.INSTANCEOF, str2);
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label7);
            int i6 = fieldInfo.serialzeFeatures;
            boolean z7 = (SerializerFeature.DisableCircularReferenceDetect.mask & i6) != 0;
            boolean z10 = (SerializerFeature.BeanToArray.mask & i6) != 0;
            if (z7 || (context.nonContext && context.writeDirect)) {
                str = z10 ? "writeAsArrayNonContext" : "writeDirectNonContext";
            } else {
                str = z10 ? "writeAsArray" : "write";
            }
            methodVisitor.visitVarInsn(25, context.var("fied_ser"));
            methodVisitor.visitTypeInsn(192, str2);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var("object"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitFieldInsn(Opcodes.GETFIELD, context.className, AbstractC0004e.m26t(new StringBuilder(), fieldInfo.name, "_asm_fieldType"), "Ljava/lang/reflect/Type;");
            methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
            StringBuilder sb = new StringBuilder("(L");
            String str3 = JSONSerializer;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, str, AbstractC0004e.m26t(sb, str3, ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"));
            methodVisitor.visitJumpInsn(Opcodes.GOTO, label8);
            methodVisitor.visitLabel(label7);
            methodVisitor.visitVarInsn(25, context.var("fied_ser"));
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var("object"));
            methodVisitor.visitVarInsn(25, Context.fieldName);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitFieldInsn(Opcodes.GETFIELD, context.className, AbstractC0004e.m26t(new StringBuilder(), fieldInfo.name, "_asm_fieldType"), "Ljava/lang/reflect/Type;");
            methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, ObjectSerializer, "write", AbstractC0004e.m24r("(L", str3, ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"));
            methodVisitor.visitLabel(label8);
            label2 = label5;
            methodVisitor.visitJumpInsn(Opcodes.GOTO, label2);
            label3 = label6;
        }
        methodVisitor.visitLabel(label3);
        methodVisitor.visitVarInsn(25, 1);
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("object"));
        } else {
            methodVisitor.visitVarInsn(25, Context.processValue);
        }
        if (format != 0) {
            methodVisitor.visitLdcInsn(format);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
        } else {
            methodVisitor.visitVarInsn(25, Context.fieldName);
            java.lang.reflect.Type type = fieldInfo.fieldType;
            if ((type instanceof Class) && ((Class) type).isPrimitive()) {
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            } else {
                if (fieldInfo.fieldClass == String.class) {
                    methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc((Class<?>) String.class)));
                } else {
                    methodVisitor.visitVarInsn(25, 0);
                    methodVisitor.visitFieldInsn(Opcodes.GETFIELD, context.className, AbstractC0004e.m26t(new StringBuilder(), fieldInfo.name, "_asm_fieldType"), "Ljava/lang/reflect/Type;");
                }
                methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            }
        }
        methodVisitor.visitLabel(label2);
        _seperator(methodVisitor, context);
    }

    private void generateWriteAsArray(Class<?> cls, MethodVisitor methodVisitor, FieldInfo[] fieldInfoArr, Context context) throws Exception {
        String str;
        String str2;
        String str3;
        String str4;
        ASMSerializerFactory aSMSerializerFactory;
        int i6;
        Class<?> cls2;
        int i10;
        int i11;
        String str5;
        int i12;
        ASMSerializerFactory aSMSerializerFactory2 = this;
        FieldInfo[] fieldInfoArr2 = fieldInfoArr;
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 0);
        String str6 = JSONSerializer;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str6, "hasPropertyFilters", AbstractC0004e.m26t(new StringBuilder("("), SerializeFilterable_desc, ")Z"));
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(25, 3);
        methodVisitor.visitVarInsn(25, 4);
        methodVisitor.visitVarInsn(21, 5);
        String str7 = "(L";
        String str8 = ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V";
        methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, JavaBeanSerializer, "writeNoneASM", AbstractC0004e.m24r("(L", str6, ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"));
        methodVisitor.visitInsn(Opcodes.RETURN);
        methodVisitor.visitLabel(label);
        String str9 = "out";
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(16, 91);
        String str10 = SerializeWriter;
        String str11 = "(I)V";
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str10, "write", "(I)V");
        int length = fieldInfoArr2.length;
        if (length == 0) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(16, 93);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str10, "write", "(I)V");
            return;
        }
        int i13 = 0;
        while (i13 < length) {
            int i14 = i13 == length + (-1) ? 93 : 44;
            FieldInfo fieldInfo = fieldInfoArr2[i13];
            Class<?> cls3 = fieldInfo.fieldClass;
            methodVisitor.visitLdcInsn(fieldInfo.name);
            methodVisitor.visitVarInsn(58, Context.fieldName);
            if (cls3 == Byte.TYPE || cls3 == Short.TYPE || cls3 == Integer.TYPE) {
                str = str9;
                length = length;
                i13 = i13;
                str2 = str7;
                str3 = str8;
                str4 = str11;
                methodVisitor.visitVarInsn(25, context.var(str));
                methodVisitor.visitInsn(89);
                aSMSerializerFactory = this;
                aSMSerializerFactory._get(methodVisitor, context, fieldInfo);
                String str12 = SerializeWriter;
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str12, "writeInt", str4);
                methodVisitor.visitVarInsn(16, i14);
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str12, "write", str4);
            } else {
                if (cls3 == Long.TYPE) {
                    methodVisitor.visitVarInsn(25, context.var(str9));
                    methodVisitor.visitInsn(89);
                    aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                    String str13 = SerializeWriter;
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str13, "writeLong", "(J)V");
                    methodVisitor.visitVarInsn(16, i14);
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str13, "write", str11);
                } else if (cls3 == Float.TYPE) {
                    methodVisitor.visitVarInsn(25, context.var(str9));
                    methodVisitor.visitInsn(89);
                    aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                    methodVisitor.visitInsn(4);
                    String str14 = SerializeWriter;
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str14, "writeFloat", "(FZ)V");
                    methodVisitor.visitVarInsn(16, i14);
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str14, "write", str11);
                } else if (cls3 == Double.TYPE) {
                    methodVisitor.visitVarInsn(25, context.var(str9));
                    methodVisitor.visitInsn(89);
                    aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                    methodVisitor.visitInsn(4);
                    String str15 = SerializeWriter;
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str15, "writeDouble", "(DZ)V");
                    methodVisitor.visitVarInsn(16, i14);
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str15, "write", str11);
                } else if (cls3 == Boolean.TYPE) {
                    methodVisitor.visitVarInsn(25, context.var(str9));
                    methodVisitor.visitInsn(89);
                    aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                    String str16 = SerializeWriter;
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str16, "write", "(Z)V");
                    methodVisitor.visitVarInsn(16, i14);
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str16, "write", str11);
                    aSMSerializerFactory = aSMSerializerFactory2;
                    str = str9;
                    length = length;
                    i13 = i13;
                    str2 = str7;
                    str3 = str8;
                    str4 = str11;
                } else if (cls3 == Character.TYPE) {
                    methodVisitor.visitVarInsn(25, context.var(str9));
                    aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                    methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Character", "toString", "(C)Ljava/lang/String;");
                    methodVisitor.visitVarInsn(16, i14);
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeString", "(Ljava/lang/String;C)V");
                } else if (cls3 == String.class) {
                    methodVisitor.visitVarInsn(25, context.var(str9));
                    aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                    methodVisitor.visitVarInsn(16, i14);
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeString", "(Ljava/lang/String;C)V");
                } else if (cls3.isEnum()) {
                    methodVisitor.visitVarInsn(25, context.var(str9));
                    methodVisitor.visitInsn(89);
                    aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                    String str17 = SerializeWriter;
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str17, "writeEnum", "(Ljava/lang/Enum;)V");
                    methodVisitor.visitVarInsn(16, i14);
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str17, "write", str11);
                } else if (List.class.isAssignableFrom(cls3)) {
                    java.lang.reflect.Type type = fieldInfo.fieldType;
                    java.lang.reflect.Type type2 = type instanceof Class ? Object.class : ((ParameterizedType) type).getActualTypeArguments()[0];
                    if (!(type2 instanceof Class) || (cls2 = (Class) type2) == Object.class) {
                        cls2 = null;
                    }
                    aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                    methodVisitor.visitTypeInsn(192, "java/util/List");
                    methodVisitor.visitVarInsn(58, context.var("list"));
                    if (cls2 == String.class && context.writeDirect) {
                        methodVisitor.visitVarInsn(25, context.var(str9));
                        methodVisitor.visitVarInsn(25, context.var("list"));
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "write", "(Ljava/util/List;)V");
                        str = str9;
                        str2 = str7;
                        str3 = str8;
                        str5 = str11;
                        i12 = Opcodes.INVOKEVIRTUAL;
                        i10 = 25;
                        i11 = 16;
                    } else {
                        Label label2 = new Label();
                        Label label3 = new Label();
                        methodVisitor.visitVarInsn(25, context.var("list"));
                        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label3);
                        methodVisitor.visitVarInsn(25, context.var(str9));
                        String str18 = SerializeWriter;
                        java.lang.reflect.Type type3 = type2;
                        String str19 = str8;
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str18, "writeNull", "()V");
                        methodVisitor.visitJumpInsn(Opcodes.GOTO, label2);
                        methodVisitor.visitLabel(label3);
                        methodVisitor.visitVarInsn(25, context.var("list"));
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/List", "size", "()I");
                        methodVisitor.visitVarInsn(54, context.var("size"));
                        methodVisitor.visitVarInsn(25, context.var(str9));
                        methodVisitor.visitVarInsn(16, 91);
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str18, "write", str11);
                        Label label4 = new Label();
                        Label label5 = new Label();
                        Label label6 = new Label();
                        methodVisitor.visitInsn(3);
                        String str20 = str7;
                        methodVisitor.visitVarInsn(54, context.var(CmcdData.OBJECT_TYPE_INIT_SEGMENT));
                        methodVisitor.visitLabel(label4);
                        methodVisitor.visitVarInsn(21, context.var(CmcdData.OBJECT_TYPE_INIT_SEGMENT));
                        methodVisitor.visitVarInsn(21, context.var("size"));
                        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label6);
                        methodVisitor.visitVarInsn(21, context.var(CmcdData.OBJECT_TYPE_INIT_SEGMENT));
                        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label5);
                        methodVisitor.visitVarInsn(25, context.var(str9));
                        methodVisitor.visitVarInsn(16, 44);
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str18, "write", str11);
                        methodVisitor.visitLabel(label5);
                        methodVisitor.visitVarInsn(25, context.var("list"));
                        methodVisitor.visitVarInsn(21, context.var(CmcdData.OBJECT_TYPE_INIT_SEGMENT));
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/List", "get", "(I)Ljava/lang/Object;");
                        methodVisitor.visitVarInsn(58, context.var("list_item"));
                        Label label7 = new Label();
                        Label label8 = new Label();
                        String str21 = str11;
                        methodVisitor.visitVarInsn(25, context.var("list_item"));
                        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label8);
                        methodVisitor.visitVarInsn(25, context.var(str9));
                        String str22 = str9;
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str18, "writeNull", "()V");
                        methodVisitor.visitJumpInsn(Opcodes.GOTO, label7);
                        methodVisitor.visitLabel(label8);
                        Label label9 = new Label();
                        Label label10 = new Label();
                        if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                            label4 = label4;
                            label7 = label7;
                            label10 = label10;
                            str3 = str19;
                            str2 = str20;
                        } else {
                            methodVisitor.visitVarInsn(25, context.var("list_item"));
                            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                            methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
                            methodVisitor.visitJumpInsn(Opcodes.IF_ACMPNE, label10);
                            aSMSerializerFactory2._getListFieldItemSer(context, methodVisitor, fieldInfo, cls2);
                            methodVisitor.visitVarInsn(58, context.var("list_item_desc"));
                            Label label11 = new Label();
                            Label label12 = new Label();
                            if (context.writeDirect) {
                                methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                                String str23 = JavaBeanSerializer;
                                methodVisitor.visitTypeInsn(Opcodes.INSTANCEOF, str23);
                                methodVisitor.visitJumpInsn(Opcodes.IFEQ, label11);
                                methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                                methodVisitor.visitTypeInsn(192, str23);
                                methodVisitor.visitVarInsn(25, 1);
                                methodVisitor.visitVarInsn(25, context.var("list_item"));
                                if (context.nonContext) {
                                    methodVisitor.visitInsn(1);
                                } else {
                                    methodVisitor.visitVarInsn(21, context.var(CmcdData.OBJECT_TYPE_INIT_SEGMENT));
                                    methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                }
                                methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
                                methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                                str2 = str20;
                                str3 = str19;
                                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str23, "writeAsArrayNonContext", AbstractC0004e.m26t(new StringBuilder(str2), JSONSerializer, str3));
                                methodVisitor.visitJumpInsn(Opcodes.GOTO, label12);
                                methodVisitor.visitLabel(label11);
                            } else {
                                label7 = label7;
                                label10 = label10;
                                str3 = str19;
                                str2 = str20;
                            }
                            methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                            methodVisitor.visitVarInsn(25, 1);
                            methodVisitor.visitVarInsn(25, context.var("list_item"));
                            if (context.nonContext) {
                                methodVisitor.visitInsn(1);
                            } else {
                                methodVisitor.visitVarInsn(21, context.var(CmcdData.OBJECT_TYPE_INIT_SEGMENT));
                                methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                            }
                            methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
                            methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                            methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, ObjectSerializer, "write", AbstractC0004e.m26t(new StringBuilder(str2), JSONSerializer, str3));
                            methodVisitor.visitLabel(label12);
                            label9 = label9;
                            methodVisitor.visitJumpInsn(Opcodes.GOTO, label9);
                        }
                        methodVisitor.visitLabel(label10);
                        methodVisitor.visitVarInsn(25, 1);
                        methodVisitor.visitVarInsn(25, context.var("list_item"));
                        if (context.nonContext) {
                            methodVisitor.visitInsn(1);
                        } else {
                            methodVisitor.visitVarInsn(21, context.var(CmcdData.OBJECT_TYPE_INIT_SEGMENT));
                            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                        }
                        if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
                        } else {
                            methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc((Class<?>) type3)));
                            methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                        }
                        methodVisitor.visitLabel(label9);
                        methodVisitor.visitLabel(label7);
                        methodVisitor.visitIincInsn(context.var(CmcdData.OBJECT_TYPE_INIT_SEGMENT), 1);
                        methodVisitor.visitJumpInsn(Opcodes.GOTO, label4);
                        methodVisitor.visitLabel(label6);
                        str = str22;
                        i10 = 25;
                        methodVisitor.visitVarInsn(25, context.var(str));
                        i11 = 16;
                        methodVisitor.visitVarInsn(16, 93);
                        str5 = str21;
                        i12 = Opcodes.INVOKEVIRTUAL;
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str18, "write", str5);
                        methodVisitor.visitLabel(label2);
                    }
                    methodVisitor.visitVarInsn(i10, context.var(str));
                    methodVisitor.visitVarInsn(i11, i14);
                    methodVisitor.visitMethodInsn(i12, SerializeWriter, "write", str5);
                    aSMSerializerFactory = this;
                    str4 = str5;
                } else {
                    String str24 = str9;
                    length = length;
                    i13 = i13;
                    str2 = str7;
                    str3 = str8;
                    String str25 = str11;
                    Label label13 = new Label();
                    Label label14 = new Label();
                    _get(methodVisitor, context, fieldInfo);
                    methodVisitor.visitInsn(89);
                    methodVisitor.visitVarInsn(58, context.var("field_".concat(fieldInfo.fieldClass.getName())));
                    methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label14);
                    methodVisitor.visitVarInsn(25, context.var(str24));
                    String str26 = SerializeWriter;
                    int i15 = i14;
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str26, "writeNull", "()V");
                    methodVisitor.visitJumpInsn(Opcodes.GOTO, label13);
                    methodVisitor.visitLabel(label14);
                    Label label15 = new Label();
                    Label label16 = new Label();
                    methodVisitor.visitVarInsn(25, context.var("field_".concat(fieldInfo.fieldClass.getName())));
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                    methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls3)));
                    methodVisitor.visitJumpInsn(Opcodes.IF_ACMPNE, label16);
                    _getFieldSer(context, methodVisitor, fieldInfo);
                    methodVisitor.visitVarInsn(58, context.var("fied_ser"));
                    Label label17 = new Label();
                    Label label18 = new Label();
                    if (context.writeDirect && Modifier.isPublic(cls3.getModifiers())) {
                        methodVisitor.visitVarInsn(25, context.var("fied_ser"));
                        String str27 = JavaBeanSerializer;
                        methodVisitor.visitTypeInsn(Opcodes.INSTANCEOF, str27);
                        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label17);
                        methodVisitor.visitVarInsn(25, context.var("fied_ser"));
                        methodVisitor.visitTypeInsn(192, str27);
                        methodVisitor.visitVarInsn(25, 1);
                        methodVisitor.visitVarInsn(25, context.var("field_".concat(fieldInfo.fieldClass.getName())));
                        methodVisitor.visitVarInsn(25, Context.fieldName);
                        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls3)));
                        methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str27, "writeAsArrayNonContext", AbstractC0004e.m26t(new StringBuilder(str2), JSONSerializer, str3));
                        methodVisitor.visitJumpInsn(Opcodes.GOTO, label18);
                        methodVisitor.visitLabel(label17);
                    }
                    methodVisitor.visitVarInsn(25, context.var("fied_ser"));
                    methodVisitor.visitVarInsn(25, 1);
                    methodVisitor.visitVarInsn(25, context.var("field_".concat(fieldInfo.fieldClass.getName())));
                    methodVisitor.visitVarInsn(25, Context.fieldName);
                    methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls3)));
                    methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                    String str28 = ObjectSerializer;
                    StringBuilder sb = new StringBuilder(str2);
                    String str29 = JSONSerializer;
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, str28, "write", AbstractC0004e.m26t(sb, str29, str3));
                    methodVisitor.visitLabel(label18);
                    methodVisitor.visitJumpInsn(Opcodes.GOTO, label15);
                    methodVisitor.visitLabel(label16);
                    String format = fieldInfo.getFormat();
                    methodVisitor.visitVarInsn(25, 1);
                    methodVisitor.visitVarInsn(25, context.var("field_".concat(fieldInfo.fieldClass.getName())));
                    if (format != null) {
                        methodVisitor.visitLdcInsn(format);
                        i6 = Opcodes.INVOKEVIRTUAL;
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str29, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
                    } else {
                        i6 = Opcodes.INVOKEVIRTUAL;
                        methodVisitor.visitVarInsn(25, Context.fieldName);
                        java.lang.reflect.Type type4 = fieldInfo.fieldType;
                        if ((type4 instanceof Class) && ((Class) type4).isPrimitive()) {
                            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str29, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
                        } else {
                            methodVisitor.visitVarInsn(25, 0);
                            methodVisitor.visitFieldInsn(Opcodes.GETFIELD, context.className, AbstractC0004e.m26t(new StringBuilder(), fieldInfo.name, "_asm_fieldType"), "Ljava/lang/reflect/Type;");
                            methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
                            i6 = Opcodes.INVOKEVIRTUAL;
                            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str29, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                        }
                        methodVisitor.visitLabel(label15);
                        methodVisitor.visitLabel(label13);
                        str = str24;
                        methodVisitor.visitVarInsn(25, context.var(str));
                        methodVisitor.visitVarInsn(16, i15);
                        str4 = str25;
                        methodVisitor.visitMethodInsn(i6, str26, "write", str4);
                        aSMSerializerFactory = this;
                    }
                    methodVisitor.visitLabel(label15);
                    methodVisitor.visitLabel(label13);
                    str = str24;
                    methodVisitor.visitVarInsn(25, context.var(str));
                    methodVisitor.visitVarInsn(16, i15);
                    str4 = str25;
                    methodVisitor.visitMethodInsn(i6, str26, "write", str4);
                    aSMSerializerFactory = this;
                }
                aSMSerializerFactory = aSMSerializerFactory2;
                str = str9;
                str2 = str7;
                str3 = str8;
                str4 = str11;
            }
            str9 = str;
            str11 = str4;
            i13++;
            aSMSerializerFactory2 = aSMSerializerFactory;
            str8 = str3;
            length = length;
            fieldInfoArr2 = fieldInfoArr;
            str7 = str2;
        }
    }

    private void generateWriteMethod(Class<?> cls, MethodVisitor methodVisitor, FieldInfo[] fieldInfoArr, Context context) throws Exception {
        String str;
        int i6;
        int i10;
        String str2;
        Class<?> cls2;
        FieldInfo[] fieldInfoArr2 = fieldInfoArr;
        Label label = new Label();
        int length = fieldInfoArr2.length;
        String str3 = "out";
        if (!context.writeDirect) {
            Label label2 = new Label();
            Label label3 = new Label();
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.PrettyFormat.mask));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor.visitJumpInsn(Opcodes.IFNE, label3);
            int length2 = fieldInfoArr2.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length2) {
                    methodVisitor.visitJumpInsn(Opcodes.GOTO, label2);
                    break;
                }
                int i12 = length2;
                if (fieldInfoArr2[i11].method != null) {
                    methodVisitor.visitVarInsn(25, context.var("out"));
                    methodVisitor.visitLdcInsn(Integer.valueOf(SerializerFeature.IgnoreErrorGetter.mask));
                    methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
                    methodVisitor.visitJumpInsn(Opcodes.IFEQ, label2);
                    break;
                }
                i11++;
                length2 = i12;
            }
            methodVisitor.visitLabel(label3);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitVarInsn(25, 3);
            methodVisitor.visitVarInsn(25, 4);
            methodVisitor.visitVarInsn(21, 5);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, JavaBeanSerializer, "write", AbstractC0004e.m26t(new StringBuilder("(L"), JSONSerializer, ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"));
            methodVisitor.visitInsn(Opcodes.RETURN);
            methodVisitor.visitLabel(label2);
        }
        if (!context.nonContext) {
            Label label4 = new Label();
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitVarInsn(21, 5);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JavaBeanSerializer, "writeReference", AbstractC0004e.m26t(new StringBuilder("(L"), JSONSerializer, ";Ljava/lang/Object;I)Z"));
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label4);
            methodVisitor.visitInsn(Opcodes.RETURN);
            methodVisitor.visitLabel(label4);
        }
        if (context.writeDirect) {
            str = context.nonContext ? "writeAsArrayNonContext" : "writeAsArray";
        } else {
            str = "writeAsArrayNormal";
        }
        int i13 = context.beanInfo.features;
        SerializerFeature serializerFeature = SerializerFeature.BeanToArray;
        if ((i13 & serializerFeature.mask) == 0) {
            Label label5 = new Label();
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitLdcInsn(Integer.valueOf(serializerFeature.mask));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label5);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitVarInsn(25, 3);
            methodVisitor.visitVarInsn(25, 4);
            methodVisitor.visitVarInsn(21, 5);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, context.className, str, AbstractC0004e.m26t(new StringBuilder("(L"), JSONSerializer, ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"));
            methodVisitor.visitInsn(Opcodes.RETURN);
            methodVisitor.visitLabel(label5);
        } else {
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitVarInsn(25, 3);
            methodVisitor.visitVarInsn(25, 4);
            methodVisitor.visitVarInsn(21, 5);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, context.className, str, AbstractC0004e.m26t(new StringBuilder("(L"), JSONSerializer, ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"));
            methodVisitor.visitInsn(Opcodes.RETURN);
        }
        String str4 = "parent";
        if (!context.nonContext) {
            methodVisitor.visitVarInsn(25, 1);
            String str5 = JSONSerializer;
            StringBuilder sb = new StringBuilder("()");
            String str6 = SerialContext_desc;
            sb.append(str6);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "getContext", sb.toString());
            methodVisitor.visitVarInsn(58, context.var("parent"));
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var("parent"));
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitVarInsn(25, 3);
            methodVisitor.visitLdcInsn(Integer.valueOf(context.beanInfo.features));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "setContext", "(" + str6 + "Ljava/lang/Object;Ljava/lang/Object;I)V");
        }
        boolean z7 = (context.beanInfo.features & SerializerFeature.WriteClassName.mask) != 0;
        if (z7 || !context.writeDirect) {
            Label label6 = new Label();
            Label label7 = new Label();
            Label label8 = new Label();
            if (z7) {
                i6 = Opcodes.INVOKEVIRTUAL;
            } else {
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitVarInsn(25, 4);
                methodVisitor.visitVarInsn(25, 2);
                String str7 = JSONSerializer;
                i6 = Opcodes.INVOKEVIRTUAL;
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str7, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
                methodVisitor.visitJumpInsn(Opcodes.IFEQ, label7);
            }
            methodVisitor.visitVarInsn(25, 4);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitMethodInsn(i6, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            methodVisitor.visitJumpInsn(Opcodes.IF_ACMPEQ, label7);
            methodVisitor.visitLabel(label8);
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(16, 123);
            methodVisitor.visitMethodInsn(i6, SerializeWriter, "write", "(I)V");
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            if (context.beanInfo.typeKey != null) {
                methodVisitor.visitLdcInsn(context.beanInfo.typeKey);
            } else {
                methodVisitor.visitInsn(1);
            }
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JavaBeanSerializer, "writeClassName", AbstractC0004e.m26t(new StringBuilder("(L"), JSONSerializer, ";Ljava/lang/String;Ljava/lang/Object;)V"));
            methodVisitor.visitVarInsn(16, 44);
            methodVisitor.visitJumpInsn(Opcodes.GOTO, label6);
            methodVisitor.visitLabel(label7);
            methodVisitor.visitVarInsn(16, 123);
            methodVisitor.visitLabel(label6);
        } else {
            methodVisitor.visitVarInsn(16, 123);
            str4 = "parent";
        }
        methodVisitor.visitVarInsn(54, context.var("seperator"));
        if (!context.writeDirect) {
            _before(methodVisitor, context);
        }
        if (context.writeDirect) {
            i10 = 0;
        } else {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isNotWriteDefaultValue", "()Z");
            methodVisitor.visitVarInsn(54, context.var("notWriteDefaultValue"));
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 0);
            String str8 = JSONSerializer;
            StringBuilder sb2 = new StringBuilder("(");
            String str9 = SerializeFilterable_desc;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str8, "checkValue", AbstractC0004e.m26t(sb2, str9, ")Z"));
            methodVisitor.visitVarInsn(54, context.var("checkValue"));
            methodVisitor.visitVarInsn(25, 1);
            i10 = 0;
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str8, "hasNameFilters", AbstractC0004e.m24r("(", str9, ")Z"));
            methodVisitor.visitVarInsn(54, context.var("hasNameFilters"));
        }
        while (i10 < length) {
            FieldInfo fieldInfo = fieldInfoArr2[i10];
            Class<?> cls3 = fieldInfo.fieldClass;
            methodVisitor.visitLdcInsn(fieldInfo.name);
            methodVisitor.visitVarInsn(58, Context.fieldName);
            if (cls3 == Byte.TYPE || cls3 == Short.TYPE || cls3 == Integer.TYPE) {
                str2 = str3;
                _int(cls, methodVisitor, fieldInfo, context, context.var(cls3.getName()), 'I');
            } else {
                if (cls3 == Long.TYPE) {
                    cls2 = cls;
                    _long(cls2, methodVisitor, fieldInfo, context);
                } else {
                    cls2 = cls;
                    if (cls3 == Float.TYPE) {
                        _float(cls2, methodVisitor, fieldInfo, context);
                    } else if (cls3 == Double.TYPE) {
                        _double(cls2, methodVisitor, fieldInfo, context);
                    } else if (cls3 == Boolean.TYPE) {
                        str2 = str3;
                        _int(cls, methodVisitor, fieldInfo, context, context.var("boolean"), 'Z');
                    } else {
                        str2 = str3;
                        if (cls3 == Character.TYPE) {
                            _int(cls, methodVisitor, fieldInfo, context, context.var("char"), 'C');
                        } else if (cls3 == String.class) {
                            _string(cls2, methodVisitor, fieldInfo, context);
                        } else if (cls3 == BigDecimal.class) {
                            _decimal(cls2, methodVisitor, fieldInfo, context);
                        } else if (List.class.isAssignableFrom(cls3)) {
                            _list(cls2, methodVisitor, fieldInfo, context);
                        } else if (cls3.isEnum()) {
                            _enum(cls2, methodVisitor, fieldInfo, context);
                        } else {
                            _object(cls2, methodVisitor, fieldInfo, context);
                        }
                    }
                }
                str2 = str3;
            }
            i10++;
            fieldInfoArr2 = fieldInfoArr;
            str3 = str2;
        }
        String str10 = str3;
        if (!context.writeDirect) {
            _after(methodVisitor, context);
        }
        Label label9 = new Label();
        Label label10 = new Label();
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitIntInsn(16, 123);
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label9);
        methodVisitor.visitVarInsn(25, context.var(str10));
        methodVisitor.visitVarInsn(16, 123);
        String str11 = SerializeWriter;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str11, "write", "(I)V");
        methodVisitor.visitLabel(label9);
        methodVisitor.visitVarInsn(25, context.var(str10));
        methodVisitor.visitVarInsn(16, 125);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str11, "write", "(I)V");
        methodVisitor.visitLabel(label10);
        methodVisitor.visitLabel(label);
        if (context.nonContext) {
            return;
        }
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, context.var(str4));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONSerializer, "setContext", AbstractC0004e.m26t(new StringBuilder("("), SerialContext_desc, ")V"));
    }

    public JavaBeanSerializer createJavaBeanSerializer(SerializeBeanInfo serializeBeanInfo) throws Exception {
        String str;
        String strM5495i;
        String str2;
        Class<String> cls;
        boolean z7;
        Class<SerializeBeanInfo> cls2;
        boolean z10;
        ASMSerializerFactory aSMSerializerFactory;
        String str3;
        int i6;
        String str4;
        boolean z11;
        boolean z12;
        String str5;
        boolean z13;
        boolean z14;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        Method method;
        Class<?> cls3 = serializeBeanInfo.beanType;
        if (cls3.isPrimitive()) {
            throw new JSONException("unsupportd class ".concat(cls3.getName()));
        }
        JSONType jSONType = (JSONType) TypeUtils.getAnnotation(cls3, JSONType.class);
        FieldInfo[] fieldInfoArr = serializeBeanInfo.fields;
        for (FieldInfo fieldInfo : fieldInfoArr) {
            if (fieldInfo.field == null && (method = fieldInfo.method) != null && method.getDeclaringClass().isInterface()) {
                return new JavaBeanSerializer(serializeBeanInfo);
            }
        }
        FieldInfo[] fieldInfoArr2 = serializeBeanInfo.sortedFields;
        boolean z15 = fieldInfoArr2 == serializeBeanInfo.fields;
        if (fieldInfoArr2.length > 256) {
            return new JavaBeanSerializer(serializeBeanInfo);
        }
        for (FieldInfo fieldInfo2 : fieldInfoArr2) {
            if (!ASMUtils.checkName(fieldInfo2.getMember().getName())) {
                return new JavaBeanSerializer(serializeBeanInfo);
            }
        }
        String str6 = "ASMSerializer_" + this.seed.incrementAndGet() + "_" + cls3.getSimpleName();
        Package r10 = ASMSerializerFactory.class.getPackage();
        if (r10 != null) {
            String name = r10.getName();
            String str7 = name.replace('.', '/') + "/" + str6;
            strM5495i = AbstractC2460q.m5495i(name, ".", str6);
            str = str7;
        } else {
            str = str6;
            strM5495i = str;
        }
        ClassWriter classWriter = new ClassWriter();
        classWriter.visit(49, 33, str, JavaBeanSerializer, new String[]{ObjectSerializer});
        int length = fieldInfoArr2.length;
        int i15 = 0;
        while (true) {
            str2 = strM5495i;
            cls = String.class;
            if (i15 >= length) {
                break;
            }
            int i16 = length;
            FieldInfo fieldInfo3 = fieldInfoArr2[i15];
            FieldInfo[] fieldInfoArr3 = fieldInfoArr;
            if (fieldInfo3.fieldClass.isPrimitive() || fieldInfo3.fieldClass == cls) {
                i14 = 1;
            } else {
                new FieldWriter(classWriter, 1, AbstractC0004e.m26t(new StringBuilder(), fieldInfo3.name, "_asm_fieldType"), "Ljava/lang/reflect/Type;").visitEnd();
                if (List.class.isAssignableFrom(fieldInfo3.fieldClass)) {
                    i14 = 1;
                    new FieldWriter(classWriter, 1, AbstractC0004e.m26t(new StringBuilder(), fieldInfo3.name, "_asm_list_item_ser_"), ObjectSerializer_desc).visitEnd();
                } else {
                    i14 = 1;
                }
                new FieldWriter(classWriter, i14, AbstractC0004e.m26t(new StringBuilder(), fieldInfo3.name, "_asm_ser_"), ObjectSerializer_desc).visitEnd();
            }
            i15 += i14;
            length = i16;
            strM5495i = str2;
            fieldInfoArr = fieldInfoArr3;
        }
        FieldInfo[] fieldInfoArr4 = fieldInfoArr;
        StringBuilder sb = new StringBuilder("(");
        Class<SerializeBeanInfo> cls4 = SerializeBeanInfo.class;
        sb.append(ASMUtils.desc(cls4));
        sb.append(")V");
        MethodWriter methodWriter = new MethodWriter(classWriter, 1, "<init>", sb.toString(), null, null);
        methodWriter.visitVarInsn(25, 0);
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitMethodInsn(Opcodes.INVOKESPECIAL, JavaBeanSerializer, "<init>", "(" + ASMUtils.desc(cls4) + ")V");
        int i17 = 0;
        while (i17 < fieldInfoArr2.length) {
            FieldInfo fieldInfo4 = fieldInfoArr2[i17];
            if (fieldInfo4.fieldClass.isPrimitive()) {
                classWriter = classWriter;
                cls = cls;
            } else {
                if (fieldInfo4.fieldClass == cls) {
                    classWriter = classWriter;
                    cls = cls;
                    i13 = 1;
                } else {
                    methodWriter.visitVarInsn(25, 0);
                    if (fieldInfo4.method != null) {
                        methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo4.declaringClass)));
                        methodWriter.visitLdcInsn(fieldInfo4.method.getName());
                        methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, ASMUtils.type(ASMUtils.class), "getMethodType", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Type;");
                    } else {
                        methodWriter.visitVarInsn(25, 0);
                        methodWriter.visitLdcInsn(Integer.valueOf(i17));
                        methodWriter.visitMethodInsn(Opcodes.INVOKESPECIAL, JavaBeanSerializer, "getFieldType", "(I)Ljava/lang/reflect/Type;");
                    }
                    methodWriter.visitFieldInsn(Opcodes.PUTFIELD, str, AbstractC0004e.m26t(new StringBuilder(), fieldInfo4.name, "_asm_fieldType"), "Ljava/lang/reflect/Type;");
                }
                i17 += i13;
                classWriter = classWriter;
                cls = cls;
            }
            i13 = 1;
            i17 += i13;
            classWriter = classWriter;
            cls = cls;
        }
        ClassWriter classWriter2 = classWriter;
        methodWriter.visitInsn(Opcodes.RETURN);
        methodWriter.visitMaxs(4, 4);
        methodWriter.visitEnd();
        if (jSONType == null) {
            z7 = false;
            break;
        }
        SerializerFeature[] serializerFeatureArrSerialzeFeatures = jSONType.serialzeFeatures();
        int length2 = serializerFeatureArrSerialzeFeatures.length;
        int i18 = 0;
        while (true) {
            if (i18 >= length2) {
                z7 = false;
                break;
            }
            if (serializerFeatureArrSerialzeFeatures[i18] == SerializerFeature.DisableCircularReferenceDetect) {
                z7 = true;
                break;
            }
            i18++;
        }
        int i19 = 0;
        while (true) {
            cls2 = cls4;
            z10 = z7;
            if (i19 >= 3) {
                break;
            }
            if (i19 == 0) {
                str5 = "write";
                z14 = z10;
                z13 = true;
            } else if (i19 == 1) {
                str5 = "writeNormal";
                z14 = z10;
                z13 = false;
            } else {
                str5 = "writeDirectNonContext";
                z13 = true;
                z14 = true;
            }
            FieldInfo[] fieldInfoArr5 = fieldInfoArr2;
            int i20 = i19;
            ClassWriter classWriter3 = classWriter2;
            Context context = new Context(fieldInfoArr2, serializeBeanInfo, str, z13, z14);
            StringBuilder sb2 = new StringBuilder("(L");
            String str8 = JSONSerializer;
            MethodWriter methodWriter2 = new MethodWriter(classWriter2, 1, str5, AbstractC0004e.m26t(sb2, str8, ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"), null, new String[]{"java/io/IOException"});
            Label label = new Label();
            methodWriter2.visitVarInsn(25, 2);
            methodWriter2.visitJumpInsn(Opcodes.IFNONNULL, label);
            methodWriter2.visitVarInsn(25, 1);
            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str8, "writeNull", "()V");
            methodWriter2.visitInsn(Opcodes.RETURN);
            methodWriter2.visitLabel(label);
            methodWriter2.visitVarInsn(25, 1);
            methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str8, "out", SerializeWriter_desc);
            methodWriter2.visitVarInsn(58, context.var("out"));
            if (!z15 && !context.writeDirect && (jSONType == null || jSONType.alphabetic())) {
                Label label2 = new Label();
                methodWriter2.visitVarInsn(25, context.var("out"));
                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isSortField", "()Z");
                methodWriter2.visitJumpInsn(Opcodes.IFNE, label2);
                methodWriter2.visitVarInsn(25, 0);
                methodWriter2.visitVarInsn(25, 1);
                methodWriter2.visitVarInsn(25, 2);
                methodWriter2.visitVarInsn(25, 3);
                methodWriter2.visitVarInsn(25, 4);
                methodWriter2.visitVarInsn(21, 5);
                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "writeUnsorted", AbstractC0004e.m24r("(L", str8, ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"));
                methodWriter2.visitInsn(Opcodes.RETURN);
                methodWriter2.visitLabel(label2);
            }
            if (!context.writeDirect || z14) {
                i10 = Opcodes.RETURN;
                i11 = 2;
                i12 = 25;
            } else {
                Label label3 = new Label();
                Label label4 = new Label();
                methodWriter2.visitVarInsn(25, 0);
                methodWriter2.visitVarInsn(25, 1);
                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JavaBeanSerializer, "writeDirect", AbstractC0004e.m24r("(L", str8, ";)Z"));
                methodWriter2.visitJumpInsn(Opcodes.IFNE, label4);
                i12 = 25;
                methodWriter2.visitVarInsn(25, 0);
                methodWriter2.visitVarInsn(25, 1);
                methodWriter2.visitVarInsn(25, 2);
                methodWriter2.visitVarInsn(25, 3);
                methodWriter2.visitVarInsn(25, 4);
                methodWriter2.visitVarInsn(21, 5);
                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "writeNormal", AbstractC0004e.m24r("(L", str8, ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"));
                methodWriter2.visitInsn(Opcodes.RETURN);
                methodWriter2.visitLabel(label4);
                methodWriter2.visitVarInsn(25, context.var("out"));
                methodWriter2.visitLdcInsn(Integer.valueOf(SerializerFeature.DisableCircularReferenceDetect.mask));
                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
                methodWriter2.visitJumpInsn(Opcodes.IFEQ, label3);
                methodWriter2.visitVarInsn(25, 0);
                methodWriter2.visitVarInsn(25, 1);
                i11 = 2;
                methodWriter2.visitVarInsn(25, 2);
                methodWriter2.visitVarInsn(25, 3);
                methodWriter2.visitVarInsn(25, 4);
                methodWriter2.visitVarInsn(21, 5);
                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "writeDirectNonContext", AbstractC0004e.m24r("(L", str8, ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"));
                i10 = Opcodes.RETURN;
                methodWriter2.visitInsn(Opcodes.RETURN);
                methodWriter2.visitLabel(label3);
            }
            methodWriter2.visitVarInsn(i12, i11);
            methodWriter2.visitTypeInsn(192, ASMUtils.type(cls3));
            methodWriter2.visitVarInsn(58, context.var("entity"));
            generateWriteMethod(cls3, methodWriter2, fieldInfoArr5, context);
            methodWriter2.visitInsn(i10);
            methodWriter2.visitMaxs(7, context.variantIndex + i11);
            methodWriter2.visitEnd();
            i19 = i20 + 1;
            fieldInfoArr2 = fieldInfoArr5;
            jSONType = jSONType;
            cls4 = cls2;
            z7 = z10;
            classWriter2 = classWriter3;
        }
        FieldInfo[] fieldInfoArr6 = fieldInfoArr2;
        ClassWriter classWriter4 = classWriter2;
        if (z15) {
            aSMSerializerFactory = this;
            str3 = "entity";
            i6 = Opcodes.GETFIELD;
        } else {
            aSMSerializerFactory = this;
            i6 = Opcodes.GETFIELD;
            Context context2 = new Context(fieldInfoArr6, serializeBeanInfo, str, false, z10);
            StringBuilder sb3 = new StringBuilder("(L");
            String str9 = JSONSerializer;
            MethodWriter methodWriter3 = new MethodWriter(classWriter4, 1, "writeUnsorted", AbstractC0004e.m26t(sb3, str9, ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"), null, new String[]{"java/io/IOException"});
            methodWriter3.visitVarInsn(25, 1);
            methodWriter3.visitFieldInsn(Opcodes.GETFIELD, str9, "out", SerializeWriter_desc);
            methodWriter3.visitVarInsn(58, context2.var("out"));
            methodWriter3.visitVarInsn(25, 2);
            methodWriter3.visitTypeInsn(192, ASMUtils.type(cls3));
            str3 = "entity";
            methodWriter3.visitVarInsn(58, context2.var(str3));
            aSMSerializerFactory.generateWriteMethod(cls3, methodWriter3, fieldInfoArr4, context2);
            methodWriter3.visitInsn(Opcodes.RETURN);
            methodWriter3.visitMaxs(7, context2.variantIndex + 2);
            methodWriter3.visitEnd();
        }
        int i21 = 0;
        for (int i22 = 3; i21 < i22; i22 = 3) {
            if (i21 == 0) {
                str4 = "writeAsArray";
                z12 = z10;
                z11 = true;
            } else if (i21 == 1) {
                str4 = "writeAsArrayNormal";
                z12 = z10;
                z11 = false;
            } else {
                str4 = "writeAsArrayNonContext";
                z11 = true;
                z12 = true;
            }
            String str10 = str3;
            Context context3 = new Context(fieldInfoArr6, serializeBeanInfo, str, z11, z12);
            StringBuilder sb4 = new StringBuilder("(L");
            String str11 = JSONSerializer;
            MethodWriter methodWriter4 = new MethodWriter(classWriter4, 1, str4, AbstractC0004e.m26t(sb4, str11, ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V"), null, new String[]{"java/io/IOException"});
            methodWriter4.visitVarInsn(25, 1);
            methodWriter4.visitFieldInsn(i6, str11, "out", SerializeWriter_desc);
            methodWriter4.visitVarInsn(58, context3.var("out"));
            methodWriter4.visitVarInsn(25, 2);
            methodWriter4.visitTypeInsn(192, ASMUtils.type(cls3));
            methodWriter4.visitVarInsn(58, context3.var(str10));
            aSMSerializerFactory.generateWriteAsArray(cls3, methodWriter4, fieldInfoArr6, context3);
            methodWriter4.visitInsn(Opcodes.RETURN);
            methodWriter4.visitMaxs(7, context3.variantIndex + 2);
            methodWriter4.visitEnd();
            str3 = str10;
            i21++;
        }
        byte[] byteArray = classWriter4.toByteArray();
        return (JavaBeanSerializer) aSMSerializerFactory.classLoader.defineClassPublic(str2, byteArray, 0, byteArray.length).getConstructor(cls2).newInstance(serializeBeanInfo);
    }

    public static class Context {
        static final int features = 5;
        static int fieldName = 6;
        static final int obj = 2;
        static int original = 7;
        static final int paramFieldName = 3;
        static final int paramFieldType = 4;
        static int processValue = 8;
        static final int serializer = 1;
        private final SerializeBeanInfo beanInfo;
        private final String className;
        private final FieldInfo[] getters;
        private final boolean nonContext;
        private final boolean writeDirect;
        private Map<String, Integer> variants = new HashMap();
        private int variantIndex = 9;

        public Context(FieldInfo[] fieldInfoArr, SerializeBeanInfo serializeBeanInfo, String str, boolean z7, boolean z10) {
            this.getters = fieldInfoArr;
            this.className = str;
            this.beanInfo = serializeBeanInfo;
            this.writeDirect = z7;
            this.nonContext = z10 || serializeBeanInfo.beanType.isEnum();
        }

        public int getFieldOrinal(String str) {
            int length = this.getters.length;
            for (int i6 = 0; i6 < length; i6++) {
                if (this.getters[i6].name.equals(str)) {
                    return i6;
                }
            }
            return -1;
        }

        public int var(String str) {
            if (this.variants.get(str) == null) {
                Map<String, Integer> map = this.variants;
                int i6 = this.variantIndex;
                this.variantIndex = i6 + 1;
                map.put(str, Integer.valueOf(i6));
            }
            return this.variants.get(str).intValue();
        }

        public int var(String str, int i6) {
            if (this.variants.get(str) == null) {
                this.variants.put(str, Integer.valueOf(this.variantIndex));
                this.variantIndex += i6;
            }
            return this.variants.get(str).intValue();
        }
    }
}

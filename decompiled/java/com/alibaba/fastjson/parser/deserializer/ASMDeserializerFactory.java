package com.alibaba.fastjson.parser.deserializer;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.alibaba.fastjson.asm.ClassWriter;
import com.alibaba.fastjson.asm.FieldWriter;
import com.alibaba.fastjson.asm.Label;
import com.alibaba.fastjson.asm.MethodVisitor;
import com.alibaba.fastjson.asm.MethodWriter;
import com.alibaba.fastjson.asm.Opcodes;
import com.alibaba.fastjson.asm.Type;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.SymbolTable;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import p000a.AbstractC0004e;
import p055ea.AbstractC2460q;

public class ASMDeserializerFactory implements Opcodes {
    static final String DefaultJSONParser = ASMUtils.type(DefaultJSONParser.class);
    static final String JSONLexerBase = ASMUtils.type(JSONLexerBase.class);
    public final ASMClassLoader classLoader;
    protected final AtomicLong seed = new AtomicLong();

    public ASMDeserializerFactory(ClassLoader classLoader) {
        this.classLoader = classLoader instanceof ASMClassLoader ? (ASMClassLoader) classLoader : new ASMClassLoader(classLoader);
    }

    private void _batchSet(Context context, MethodVisitor methodVisitor) {
        _batchSet(context, methodVisitor, true);
    }

    private void _createInstance(Context context, MethodVisitor methodVisitor) {
        Constructor<?> constructor = context.beanInfo.defaultConstructor;
        if (Modifier.isPublic(constructor.getModifiers())) {
            methodVisitor.visitTypeInsn(Opcodes.NEW, ASMUtils.type(context.getInstClass()));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, ASMUtils.type(constructor.getDeclaringClass()), "<init>", "()V");
        } else {
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitFieldInsn(Opcodes.GETFIELD, ASMUtils.type(JavaBeanDeserializer.class), "clazz", "Ljava/lang/Class;");
            methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, ASMUtils.type(JavaBeanDeserializer.class), "createInstance", AbstractC0004e.m26t(new StringBuilder("(L"), DefaultJSONParser, ";Ljava/lang/reflect/Type;)Ljava/lang/Object;"));
            methodVisitor.visitTypeInsn(192, ASMUtils.type(context.getInstClass()));
        }
        methodVisitor.visitVarInsn(58, context.var("instance"));
    }

    private void _deserObject(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo, Class<?> cls, int i6) {
        _getFieldDeser(context, methodVisitor, fieldInfo);
        Label label = new Label();
        Label label2 = new Label();
        if ((fieldInfo.parserFeatures & Feature.SupportArrayToBean.mask) != 0) {
            methodVisitor.visitInsn(89);
            methodVisitor.visitTypeInsn(Opcodes.INSTANCEOF, ASMUtils.type(JavaBeanDeserializer.class));
            methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
            methodVisitor.visitTypeInsn(192, ASMUtils.type(JavaBeanDeserializer.class));
            methodVisitor.visitVarInsn(25, 1);
            if (fieldInfo.fieldType instanceof Class) {
                methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
            } else {
                methodVisitor.visitVarInsn(25, 0);
                methodVisitor.visitLdcInsn(Integer.valueOf(i6));
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            }
            methodVisitor.visitLdcInsn(fieldInfo.name);
            methodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.parserFeatures));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(JavaBeanDeserializer.class), "deserialze", AbstractC0004e.m26t(new StringBuilder("(L"), DefaultJSONParser, ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;"));
            methodVisitor.visitTypeInsn(192, ASMUtils.type(cls));
            methodVisitor.visitVarInsn(58, context.var_asm(fieldInfo));
            methodVisitor.visitJumpInsn(Opcodes.GOTO, label2);
            methodVisitor.visitLabel(label);
        }
        methodVisitor.visitVarInsn(25, 1);
        if (fieldInfo.fieldType instanceof Class) {
            methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
        } else {
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitLdcInsn(Integer.valueOf(i6));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
        }
        methodVisitor.visitLdcInsn(fieldInfo.name);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, ASMUtils.type(ObjectDeserializer.class), "deserialze", AbstractC0004e.m26t(new StringBuilder("(L"), DefaultJSONParser, ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;"));
        methodVisitor.visitTypeInsn(192, ASMUtils.type(cls));
        methodVisitor.visitVarInsn(58, context.var_asm(fieldInfo));
        methodVisitor.visitLabel(label2);
    }

    private void _deserialize_endCheck(Context context, MethodVisitor methodVisitor, Label label) {
        methodVisitor.visitIntInsn(21, context.var("matchedCount"));
        methodVisitor.visitJumpInsn(Opcodes.IFLE, label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "token", "()I");
        methodVisitor.visitLdcInsn(13);
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label);
        _quickNextTokenComma(context, methodVisitor);
    }

    private void _deserialze(ClassWriter classWriter, Context context) {
        int i6;
        Label label;
        String str;
        String str2;
        String str3;
        MethodWriter methodWriter;
        Label label2;
        Label label3;
        int i10;
        String str4;
        String str5;
        Label label4;
        if (context.fieldInfoList.length == 0) {
            return;
        }
        for (FieldInfo fieldInfo : context.fieldInfoList) {
            Class<?> cls = fieldInfo.fieldClass;
            java.lang.reflect.Type type = fieldInfo.fieldType;
            if (cls == Character.TYPE) {
                return;
            }
            if (Collection.class.isAssignableFrom(cls) && (!(type instanceof ParameterizedType) || !(((ParameterizedType) type).getActualTypeArguments()[0] instanceof Class))) {
                return;
            }
        }
        JavaBeanInfo javaBeanInfo = context.beanInfo;
        context.fieldInfoList = javaBeanInfo.sortedFields;
        String str6 = "(L";
        StringBuilder sb = new StringBuilder("(L");
        String str7 = DefaultJSONParser;
        MethodWriter methodWriter2 = new MethodWriter(classWriter, 1, "deserialze", AbstractC0004e.m26t(sb, str7, ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;"), null, null);
        Label label5 = new Label();
        Label label6 = new Label();
        Label label7 = new Label();
        Label label8 = new Label();
        defineVarLexer(context, methodWriter2);
        Label label9 = new Label();
        methodWriter2.visitVarInsn(25, context.var("lexer"));
        String str8 = JSONLexerBase;
        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str8, "token", "()I");
        methodWriter2.visitLdcInsn(14);
        methodWriter2.visitJumpInsn(Opcodes.IF_ICMPNE, label9);
        int i11 = javaBeanInfo.parserFeatures;
        Feature feature = Feature.SupportArrayToBean;
        if ((i11 & feature.mask) == 0) {
            methodWriter2.visitVarInsn(25, context.var("lexer"));
            methodWriter2.visitVarInsn(21, 4);
            methodWriter2.visitLdcInsn(Integer.valueOf(feature.mask));
            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str8, "isEnabled", "(II)Z");
            methodWriter2.visitJumpInsn(Opcodes.IFEQ, label9);
        }
        methodWriter2.visitVarInsn(25, 0);
        methodWriter2.visitVarInsn(25, 1);
        methodWriter2.visitVarInsn(25, 2);
        methodWriter2.visitVarInsn(25, 3);
        methodWriter2.visitInsn(1);
        methodWriter2.visitMethodInsn(Opcodes.INVOKESPECIAL, context.className, "deserialzeArrayMapping", AbstractC0004e.m24r("(L", str7, ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"));
        methodWriter2.visitInsn(Opcodes.ARETURN);
        methodWriter2.visitLabel(label9);
        methodWriter2.visitVarInsn(25, context.var("lexer"));
        methodWriter2.visitLdcInsn(Integer.valueOf(Feature.SortFeidFastMatch.mask));
        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str8, "isEnabled", "(I)Z");
        Label label10 = new Label();
        methodWriter2.visitJumpInsn(Opcodes.IFNE, label10);
        methodWriter2.visitJumpInsn(200, label6);
        methodWriter2.visitLabel(label10);
        methodWriter2.visitVarInsn(25, context.var("lexer"));
        methodWriter2.visitLdcInsn(context.clazz.getName());
        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str8, "scanType", "(Ljava/lang/String;)I");
        methodWriter2.visitLdcInsn(-1);
        Label label11 = new Label();
        methodWriter2.visitJumpInsn(Opcodes.IF_ICMPNE, label11);
        methodWriter2.visitJumpInsn(200, label6);
        methodWriter2.visitLabel(label11);
        methodWriter2.visitVarInsn(25, 1);
        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str7, "getContext", "()" + ASMUtils.desc((Class<?>) ParseContext.class));
        methodWriter2.visitVarInsn(58, context.var("mark_context"));
        methodWriter2.visitInsn(3);
        methodWriter2.visitVarInsn(54, context.var("matchedCount"));
        _createInstance(context, methodWriter2);
        methodWriter2.visitVarInsn(25, 1);
        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str7, "getContext", "()" + ASMUtils.desc((Class<?>) ParseContext.class));
        methodWriter2.visitVarInsn(58, context.var("context"));
        methodWriter2.visitVarInsn(25, 1);
        methodWriter2.visitVarInsn(25, context.var("context"));
        methodWriter2.visitVarInsn(25, context.var("instance"));
        methodWriter2.visitVarInsn(25, 3);
        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str7, "setContext", "(" + ASMUtils.desc((Class<?>) ParseContext.class) + "Ljava/lang/Object;Ljava/lang/Object;)" + ASMUtils.desc((Class<?>) ParseContext.class));
        methodWriter2.visitVarInsn(58, context.var("childContext"));
        methodWriter2.visitVarInsn(25, context.var("lexer"));
        String str9 = "matchStat";
        String str10 = "I";
        methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str8, "matchStat", "I");
        methodWriter2.visitLdcInsn(4);
        Label label12 = new Label();
        methodWriter2.visitJumpInsn(Opcodes.IF_ICMPNE, label12);
        methodWriter2.visitJumpInsn(200, label7);
        methodWriter2.visitLabel(label12);
        int i12 = 3;
        methodWriter2.visitInsn(3);
        methodWriter2.visitIntInsn(54, context.var("matchStat"));
        int length = context.fieldInfoList.length;
        int i13 = 0;
        while (i13 < length) {
            methodWriter2.visitInsn(i12);
            methodWriter2.visitVarInsn(54, context.var("_asm_flag_" + (i13 / 32)));
            i13 += 32;
            i12 = 3;
        }
        methodWriter2.visitVarInsn(25, context.var("lexer"));
        methodWriter2.visitLdcInsn(Integer.valueOf(Feature.InitStringFieldAsEmpty.mask));
        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "isEnabled", "(I)Z");
        methodWriter2.visitIntInsn(54, context.var("initStringFieldAsEmpty"));
        int i14 = 0;
        while (i14 < length) {
            FieldInfo fieldInfo2 = context.fieldInfoList[i14];
            Class<?> cls2 = fieldInfo2.fieldClass;
            if (cls2 == Boolean.TYPE || cls2 == Byte.TYPE || cls2 == Short.TYPE || cls2 == Integer.TYPE) {
                str6 = str6;
                label5 = label5;
                label6 = label6;
                label7 = label7;
                methodWriter2.visitInsn(3);
                methodWriter2.visitVarInsn(54, context.var_asm(fieldInfo2));
            } else {
                if (cls2 == Long.TYPE) {
                    methodWriter2.visitInsn(9);
                    methodWriter2.visitVarInsn(55, context.var_asm(fieldInfo2, 2));
                } else if (cls2 == Float.TYPE) {
                    methodWriter2.visitInsn(11);
                    methodWriter2.visitVarInsn(56, context.var_asm(fieldInfo2));
                } else if (cls2 == Double.TYPE) {
                    methodWriter2.visitInsn(14);
                    methodWriter2.visitVarInsn(57, context.var_asm(fieldInfo2, 2));
                } else {
                    if (cls2 == String.class) {
                        Label label13 = new Label();
                        Label label14 = new Label();
                        methodWriter2.visitVarInsn(21, context.var("initStringFieldAsEmpty"));
                        methodWriter2.visitJumpInsn(Opcodes.IFEQ, label14);
                        _setFlag(methodWriter2, context, i14);
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "stringDefaultValue", "()Ljava/lang/String;");
                        methodWriter2.visitJumpInsn(Opcodes.GOTO, label13);
                        methodWriter2.visitLabel(label14);
                        methodWriter2.visitInsn(1);
                        methodWriter2.visitLabel(label13);
                    } else {
                        methodWriter2.visitInsn(1);
                    }
                    methodWriter2.visitTypeInsn(192, ASMUtils.type(cls2));
                    methodWriter2.visitVarInsn(58, context.var_asm(fieldInfo2));
                }
                str6 = str6;
                label5 = label5;
                label6 = label6;
                label7 = label7;
            }
            i14++;
            label6 = label6;
            label7 = label7;
            label5 = label5;
            str6 = str6;
        }
        String str11 = str6;
        Label label15 = label5;
        Label label16 = label6;
        Label label17 = label7;
        int i15 = 0;
        while (i15 < length) {
            FieldInfo fieldInfo3 = context.fieldInfoList[i15];
            Class<?> cls3 = fieldInfo3.fieldClass;
            java.lang.reflect.Type type2 = fieldInfo3.fieldType;
            Label label18 = new Label();
            if (cls3 == Boolean.TYPE) {
                methodWriter2.visitVarInsn(25, context.var("lexer"));
                methodWriter2.visitVarInsn(25, 0);
                methodWriter2.visitFieldInsn(Opcodes.GETFIELD, context.className, context.fieldName(fieldInfo3), "[C");
                methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldBoolean", "([C)Z");
                methodWriter2.visitVarInsn(54, context.var_asm(fieldInfo3));
            } else {
                if (cls3 == Byte.TYPE) {
                    methodWriter2.visitVarInsn(25, context.var("lexer"));
                    methodWriter2.visitVarInsn(25, 0);
                    methodWriter2.visitFieldInsn(Opcodes.GETFIELD, context.className, context.fieldName(fieldInfo3), "[C");
                    methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldInt", "([C)I");
                    methodWriter2.visitVarInsn(54, context.var_asm(fieldInfo3));
                } else {
                    i6 = length;
                    label = label18;
                    if (cls3 == Byte.class) {
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(25, 0);
                        methodWriter2.visitFieldInsn(Opcodes.GETFIELD, context.className, context.fieldName(fieldInfo3), "[C");
                        String str12 = JSONLexerBase;
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str12, "scanFieldInt", "([C)I");
                        methodWriter2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                        methodWriter2.visitVarInsn(58, context.var_asm(fieldInfo3));
                        Label label19 = new Label();
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str12, str9, str10);
                        methodWriter2.visitLdcInsn(5);
                        methodWriter2.visitJumpInsn(Opcodes.IF_ICMPNE, label19);
                        methodWriter2.visitInsn(1);
                        methodWriter2.visitVarInsn(58, context.var_asm(fieldInfo3));
                        methodWriter2.visitLabel(label19);
                    } else if (cls3 == Short.TYPE) {
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(25, 0);
                        methodWriter2.visitFieldInsn(Opcodes.GETFIELD, context.className, context.fieldName(fieldInfo3), "[C");
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldInt", "([C)I");
                        methodWriter2.visitVarInsn(54, context.var_asm(fieldInfo3));
                    } else if (cls3 == Short.class) {
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(25, 0);
                        methodWriter2.visitFieldInsn(Opcodes.GETFIELD, context.className, context.fieldName(fieldInfo3), "[C");
                        String str13 = JSONLexerBase;
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str13, "scanFieldInt", "([C)I");
                        methodWriter2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                        methodWriter2.visitVarInsn(58, context.var_asm(fieldInfo3));
                        Label label20 = new Label();
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str13, str9, str10);
                        methodWriter2.visitLdcInsn(5);
                        methodWriter2.visitJumpInsn(Opcodes.IF_ICMPNE, label20);
                        methodWriter2.visitInsn(1);
                        methodWriter2.visitVarInsn(58, context.var_asm(fieldInfo3));
                        methodWriter2.visitLabel(label20);
                    } else if (cls3 == Integer.TYPE) {
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(25, 0);
                        methodWriter2.visitFieldInsn(Opcodes.GETFIELD, context.className, context.fieldName(fieldInfo3), "[C");
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldInt", "([C)I");
                        methodWriter2.visitVarInsn(54, context.var_asm(fieldInfo3));
                    } else if (cls3 == Integer.class) {
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(25, 0);
                        methodWriter2.visitFieldInsn(Opcodes.GETFIELD, context.className, context.fieldName(fieldInfo3), "[C");
                        String str14 = JSONLexerBase;
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str14, "scanFieldInt", "([C)I");
                        methodWriter2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                        methodWriter2.visitVarInsn(58, context.var_asm(fieldInfo3));
                        Label label21 = new Label();
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str14, str9, str10);
                        methodWriter2.visitLdcInsn(5);
                        methodWriter2.visitJumpInsn(Opcodes.IF_ICMPNE, label21);
                        methodWriter2.visitInsn(1);
                        methodWriter2.visitVarInsn(58, context.var_asm(fieldInfo3));
                        methodWriter2.visitLabel(label21);
                    } else if (cls3 == Long.TYPE) {
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(25, 0);
                        methodWriter2.visitFieldInsn(Opcodes.GETFIELD, context.className, context.fieldName(fieldInfo3), "[C");
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldLong", "([C)J");
                        methodWriter2.visitVarInsn(55, context.var_asm(fieldInfo3, 2));
                    } else if (cls3 == Long.class) {
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(25, 0);
                        methodWriter2.visitFieldInsn(Opcodes.GETFIELD, context.className, context.fieldName(fieldInfo3), "[C");
                        String str15 = JSONLexerBase;
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str15, "scanFieldLong", "([C)J");
                        methodWriter2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                        methodWriter2.visitVarInsn(58, context.var_asm(fieldInfo3));
                        Label label22 = new Label();
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str15, str9, str10);
                        methodWriter2.visitLdcInsn(5);
                        methodWriter2.visitJumpInsn(Opcodes.IF_ICMPNE, label22);
                        methodWriter2.visitInsn(1);
                        methodWriter2.visitVarInsn(58, context.var_asm(fieldInfo3));
                        methodWriter2.visitLabel(label22);
                    } else if (cls3 == Float.TYPE) {
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(25, 0);
                        methodWriter2.visitFieldInsn(Opcodes.GETFIELD, context.className, context.fieldName(fieldInfo3), "[C");
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldFloat", "([C)F");
                        methodWriter2.visitVarInsn(56, context.var_asm(fieldInfo3));
                    } else if (cls3 == Float.class) {
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitVarInsn(25, 0);
                        methodWriter2.visitFieldInsn(Opcodes.GETFIELD, context.className, context.fieldName(fieldInfo3), "[C");
                        String str16 = JSONLexerBase;
                        methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str16, "scanFieldFloat", "([C)F");
                        methodWriter2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                        methodWriter2.visitVarInsn(58, context.var_asm(fieldInfo3));
                        Label label23 = new Label();
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str16, str9, str10);
                        methodWriter2.visitLdcInsn(5);
                        methodWriter2.visitJumpInsn(Opcodes.IF_ICMPNE, label23);
                        methodWriter2.visitInsn(1);
                        methodWriter2.visitVarInsn(58, context.var_asm(fieldInfo3));
                        methodWriter2.visitLabel(label23);
                    } else {
                        if (cls3 == Double.TYPE) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(Opcodes.GETFIELD, context.className, context.fieldName(fieldInfo3), "[C");
                            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldDouble", "([C)D");
                            methodWriter2.visitVarInsn(57, context.var_asm(fieldInfo3, 2));
                        } else if (cls3 == Double.class) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(Opcodes.GETFIELD, context.className, context.fieldName(fieldInfo3), "[C");
                            String str17 = JSONLexerBase;
                            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str17, "scanFieldDouble", "([C)D");
                            methodWriter2.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                            methodWriter2.visitVarInsn(58, context.var_asm(fieldInfo3));
                            Label label24 = new Label();
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str17, str9, str10);
                            methodWriter2.visitLdcInsn(5);
                            methodWriter2.visitJumpInsn(Opcodes.IF_ICMPNE, label24);
                            methodWriter2.visitInsn(1);
                            methodWriter2.visitVarInsn(58, context.var_asm(fieldInfo3));
                            methodWriter2.visitLabel(label24);
                        } else if (cls3 == String.class) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(Opcodes.GETFIELD, context.className, context.fieldName(fieldInfo3), "[C");
                            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldString", "([C)Ljava/lang/String;");
                            methodWriter2.visitVarInsn(58, context.var_asm(fieldInfo3));
                        } else if (cls3 == Date.class) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(Opcodes.GETFIELD, context.className, context.fieldName(fieldInfo3), "[C");
                            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldDate", "([C)Ljava/util/Date;");
                            methodWriter2.visitVarInsn(58, context.var_asm(fieldInfo3));
                        } else if (cls3 == UUID.class) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(Opcodes.GETFIELD, context.className, context.fieldName(fieldInfo3), "[C");
                            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldUUID", "([C)Ljava/util/UUID;");
                            methodWriter2.visitVarInsn(58, context.var_asm(fieldInfo3));
                        } else if (cls3 == BigDecimal.class) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(Opcodes.GETFIELD, context.className, context.fieldName(fieldInfo3), "[C");
                            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldDecimal", "([C)Ljava/math/BigDecimal;");
                            methodWriter2.visitVarInsn(58, context.var_asm(fieldInfo3));
                        } else if (cls3 == BigInteger.class) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(Opcodes.GETFIELD, context.className, context.fieldName(fieldInfo3), "[C");
                            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldBigInteger", "([C)Ljava/math/BigInteger;");
                            methodWriter2.visitVarInsn(58, context.var_asm(fieldInfo3));
                        } else if (cls3 == int[].class) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(Opcodes.GETFIELD, context.className, context.fieldName(fieldInfo3), "[C");
                            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldIntArray", "([C)[I");
                            methodWriter2.visitVarInsn(58, context.var_asm(fieldInfo3));
                        } else if (cls3 == float[].class) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(Opcodes.GETFIELD, context.className, context.fieldName(fieldInfo3), "[C");
                            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldFloatArray", "([C)[F");
                            methodWriter2.visitVarInsn(58, context.var_asm(fieldInfo3));
                        } else if (cls3 == float[][].class) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(Opcodes.GETFIELD, context.className, context.fieldName(fieldInfo3), "[C");
                            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldFloatArray2", "([C)[[F");
                            methodWriter2.visitVarInsn(58, context.var_asm(fieldInfo3));
                        } else if (cls3.isEnum()) {
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitVarInsn(25, 0);
                            methodWriter2.visitFieldInsn(Opcodes.GETFIELD, context.className, context.fieldName(fieldInfo3), "[C");
                            _getFieldDeser(context, methodWriter2, fieldInfo3);
                            str = str11;
                            methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(JavaBeanDeserializer.class), "scanEnum", str + JSONLexerBase + ";[C" + ASMUtils.desc((Class<?>) ObjectDeserializer.class) + ")Ljava/lang/Enum;");
                            methodWriter2.visitTypeInsn(192, ASMUtils.type(cls3));
                            methodWriter2.visitVarInsn(58, context.var_asm(fieldInfo3));
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            str5 = JSONLexerBase;
                            methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str5, str9, str10);
                            Label label25 = new Label();
                            methodWriter2.visitJumpInsn(Opcodes.IFLE, label25);
                            _setFlag(methodWriter2, context, i15);
                            methodWriter2.visitLabel(label25);
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str5, str9, str10);
                            methodWriter2.visitInsn(89);
                            methodWriter2.visitVarInsn(54, context.var(str9));
                            methodWriter2.visitLdcInsn(-1);
                            label4 = label15;
                            methodWriter2.visitJumpInsn(Opcodes.IF_ICMPEQ, label4);
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str5, str9, str10);
                            Label label26 = label;
                            methodWriter2.visitJumpInsn(Opcodes.IFLE, label26);
                            methodWriter2.visitVarInsn(21, context.var("matchedCount"));
                            methodWriter2.visitInsn(4);
                            methodWriter2.visitInsn(96);
                            methodWriter2.visitVarInsn(54, context.var("matchedCount"));
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str5, str9, str10);
                            methodWriter2.visitLdcInsn(4);
                            label2 = label8;
                            methodWriter2.visitJumpInsn(Opcodes.IF_ICMPEQ, label2);
                            methodWriter2.visitLabel(label26);
                            if (i15 == i6 - 1) {
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str5, str9, str10);
                                methodWriter2.visitLdcInsn(4);
                                methodWriter2.visitJumpInsn(Opcodes.IF_ICMPNE, label4);
                            }
                            str4 = str10;
                            str2 = str9;
                            str3 = str;
                            methodWriter = methodWriter2;
                            i10 = i6;
                            label3 = label4;
                        } else {
                            str = str11;
                            if (Collection.class.isAssignableFrom(cls3)) {
                                methodWriter2.visitVarInsn(25, context.var("lexer"));
                                methodWriter2.visitVarInsn(25, 0);
                                methodWriter2.visitFieldInsn(Opcodes.GETFIELD, context.className, context.fieldName(fieldInfo3), "[C");
                                Class<?> collectionItemClass = TypeUtils.getCollectionItemClass(type2);
                                if (collectionItemClass == String.class) {
                                    methodWriter2.visitLdcInsn(Type.getType(ASMUtils.desc(cls3)));
                                    methodWriter2.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFieldStringArray", "([CLjava/lang/Class;)" + ASMUtils.desc((Class<?>) Collection.class));
                                    methodWriter2.visitVarInsn(58, context.var_asm(fieldInfo3));
                                    methodWriter2.visitVarInsn(25, context.var("lexer"));
                                    str5 = JSONLexerBase;
                                    methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str5, str9, str10);
                                    Label label27 = new Label();
                                    methodWriter2.visitJumpInsn(Opcodes.IFLE, label27);
                                    _setFlag(methodWriter2, context, i15);
                                    methodWriter2.visitLabel(label27);
                                    methodWriter2.visitVarInsn(25, context.var("lexer"));
                                    methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str5, str9, str10);
                                    methodWriter2.visitInsn(89);
                                    methodWriter2.visitVarInsn(54, context.var(str9));
                                    methodWriter2.visitLdcInsn(-1);
                                    label4 = label15;
                                    methodWriter2.visitJumpInsn(Opcodes.IF_ICMPEQ, label4);
                                    methodWriter2.visitVarInsn(25, context.var("lexer"));
                                    methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str5, str9, str10);
                                    Label label28 = label;
                                    methodWriter2.visitJumpInsn(Opcodes.IFLE, label28);
                                    methodWriter2.visitVarInsn(21, context.var("matchedCount"));
                                    methodWriter2.visitInsn(4);
                                    methodWriter2.visitInsn(96);
                                    methodWriter2.visitVarInsn(54, context.var("matchedCount"));
                                    methodWriter2.visitVarInsn(25, context.var("lexer"));
                                    methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str5, str9, str10);
                                    methodWriter2.visitLdcInsn(4);
                                    label2 = label8;
                                    methodWriter2.visitJumpInsn(Opcodes.IF_ICMPEQ, label2);
                                    methodWriter2.visitLabel(label28);
                                    if (i15 == i6 - 1) {
                                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                                        methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str5, str9, str10);
                                        methodWriter2.visitLdcInsn(4);
                                        methodWriter2.visitJumpInsn(Opcodes.IF_ICMPNE, label4);
                                    }
                                    str4 = str10;
                                    str2 = str9;
                                    str3 = str;
                                    methodWriter = methodWriter2;
                                    i10 = i6;
                                    label3 = label4;
                                } else {
                                    label2 = label8;
                                    str4 = str10;
                                    str2 = str9;
                                    i10 = i6;
                                    str3 = str;
                                    methodWriter = methodWriter2;
                                    _deserialze_list_obj(context, methodWriter2, label15, fieldInfo3, cls3, collectionItemClass, i15);
                                    label3 = label15;
                                    if (i15 == i10 - 1) {
                                        _deserialize_endCheck(context, methodWriter, label3);
                                    }
                                }
                            } else {
                                str2 = str9;
                                str3 = str;
                                methodWriter = methodWriter2;
                                label2 = label8;
                                label3 = label15;
                                i10 = i6;
                                str4 = str10;
                                _deserialze_obj(context, methodWriter, label3, fieldInfo3, cls3, i15);
                                if (i15 == i10 - 1) {
                                    _deserialize_endCheck(context, methodWriter, label3);
                                }
                            }
                        }
                        str = str11;
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        str5 = JSONLexerBase;
                        methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str5, str9, str10);
                        Label label29 = new Label();
                        methodWriter2.visitJumpInsn(Opcodes.IFLE, label29);
                        _setFlag(methodWriter2, context, i15);
                        methodWriter2.visitLabel(label29);
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str5, str9, str10);
                        methodWriter2.visitInsn(89);
                        methodWriter2.visitVarInsn(54, context.var(str9));
                        methodWriter2.visitLdcInsn(-1);
                        label4 = label15;
                        methodWriter2.visitJumpInsn(Opcodes.IF_ICMPEQ, label4);
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str5, str9, str10);
                        Label label210 = label;
                        methodWriter2.visitJumpInsn(Opcodes.IFLE, label210);
                        methodWriter2.visitVarInsn(21, context.var("matchedCount"));
                        methodWriter2.visitInsn(4);
                        methodWriter2.visitInsn(96);
                        methodWriter2.visitVarInsn(54, context.var("matchedCount"));
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str5, str9, str10);
                        methodWriter2.visitLdcInsn(4);
                        label2 = label8;
                        methodWriter2.visitJumpInsn(Opcodes.IF_ICMPEQ, label2);
                        methodWriter2.visitLabel(label210);
                        if (i15 == i6 - 1) {
                            methodWriter2.visitVarInsn(25, context.var("lexer"));
                            methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str5, str9, str10);
                            methodWriter2.visitLdcInsn(4);
                            methodWriter2.visitJumpInsn(Opcodes.IF_ICMPNE, label4);
                        }
                        str4 = str10;
                        str2 = str9;
                        str3 = str;
                        methodWriter = methodWriter2;
                        i10 = i6;
                        label3 = label4;
                    }
                    str = str11;
                    methodWriter2.visitVarInsn(25, context.var("lexer"));
                    str5 = JSONLexerBase;
                    methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str5, str9, str10);
                    Label label211 = new Label();
                    methodWriter2.visitJumpInsn(Opcodes.IFLE, label211);
                    _setFlag(methodWriter2, context, i15);
                    methodWriter2.visitLabel(label211);
                    methodWriter2.visitVarInsn(25, context.var("lexer"));
                    methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str5, str9, str10);
                    methodWriter2.visitInsn(89);
                    methodWriter2.visitVarInsn(54, context.var(str9));
                    methodWriter2.visitLdcInsn(-1);
                    label4 = label15;
                    methodWriter2.visitJumpInsn(Opcodes.IF_ICMPEQ, label4);
                    methodWriter2.visitVarInsn(25, context.var("lexer"));
                    methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str5, str9, str10);
                    Label label212 = label;
                    methodWriter2.visitJumpInsn(Opcodes.IFLE, label212);
                    methodWriter2.visitVarInsn(21, context.var("matchedCount"));
                    methodWriter2.visitInsn(4);
                    methodWriter2.visitInsn(96);
                    methodWriter2.visitVarInsn(54, context.var("matchedCount"));
                    methodWriter2.visitVarInsn(25, context.var("lexer"));
                    methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str5, str9, str10);
                    methodWriter2.visitLdcInsn(4);
                    label2 = label8;
                    methodWriter2.visitJumpInsn(Opcodes.IF_ICMPEQ, label2);
                    methodWriter2.visitLabel(label212);
                    if (i15 == i6 - 1) {
                        methodWriter2.visitVarInsn(25, context.var("lexer"));
                        methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str5, str9, str10);
                        methodWriter2.visitLdcInsn(4);
                        methodWriter2.visitJumpInsn(Opcodes.IF_ICMPNE, label4);
                    }
                    str4 = str10;
                    str2 = str9;
                    str3 = str;
                    methodWriter = methodWriter2;
                    i10 = i6;
                    label3 = label4;
                }
                i15++;
                label15 = label3;
                methodWriter2 = methodWriter;
                str10 = str4;
                str9 = str2;
                length = i10;
                str11 = str3;
                label8 = label2;
            }
            i6 = length;
            label = label18;
            str = str11;
            methodWriter2.visitVarInsn(25, context.var("lexer"));
            str5 = JSONLexerBase;
            methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str5, str9, str10);
            Label label213 = new Label();
            methodWriter2.visitJumpInsn(Opcodes.IFLE, label213);
            _setFlag(methodWriter2, context, i15);
            methodWriter2.visitLabel(label213);
            methodWriter2.visitVarInsn(25, context.var("lexer"));
            methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str5, str9, str10);
            methodWriter2.visitInsn(89);
            methodWriter2.visitVarInsn(54, context.var(str9));
            methodWriter2.visitLdcInsn(-1);
            label4 = label15;
            methodWriter2.visitJumpInsn(Opcodes.IF_ICMPEQ, label4);
            methodWriter2.visitVarInsn(25, context.var("lexer"));
            methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str5, str9, str10);
            Label label214 = label;
            methodWriter2.visitJumpInsn(Opcodes.IFLE, label214);
            methodWriter2.visitVarInsn(21, context.var("matchedCount"));
            methodWriter2.visitInsn(4);
            methodWriter2.visitInsn(96);
            methodWriter2.visitVarInsn(54, context.var("matchedCount"));
            methodWriter2.visitVarInsn(25, context.var("lexer"));
            methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str5, str9, str10);
            methodWriter2.visitLdcInsn(4);
            label2 = label8;
            methodWriter2.visitJumpInsn(Opcodes.IF_ICMPEQ, label2);
            methodWriter2.visitLabel(label214);
            if (i15 == i6 - 1) {
                methodWriter2.visitVarInsn(25, context.var("lexer"));
                methodWriter2.visitFieldInsn(Opcodes.GETFIELD, str5, str9, str10);
                methodWriter2.visitLdcInsn(4);
                methodWriter2.visitJumpInsn(Opcodes.IF_ICMPNE, label4);
            }
            str4 = str10;
            str2 = str9;
            str3 = str;
            methodWriter = methodWriter2;
            i10 = i6;
            label3 = label4;
            i15++;
            label15 = label3;
            methodWriter2 = methodWriter;
            str10 = str4;
            str9 = str2;
            length = i10;
            str11 = str3;
            label8 = label2;
        }
        int i16 = length;
        MethodWriter methodWriter3 = methodWriter2;
        Label label30 = label15;
        String str18 = str11;
        methodWriter3.visitLabel(label8);
        if (!context.clazz.isInterface() && !Modifier.isAbstract(context.clazz.getModifiers())) {
            _batchSet(context, methodWriter3);
        }
        methodWriter3.visitLabel(label17);
        _setContext(context, methodWriter3);
        methodWriter3.visitVarInsn(25, context.var("instance"));
        Method method = context.beanInfo.buildMethod;
        if (method != null) {
            methodWriter3.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(context.getInstClass()), method.getName(), "()" + ASMUtils.desc(method.getReturnType()));
        }
        methodWriter3.visitInsn(Opcodes.ARETURN);
        methodWriter3.visitLabel(label30);
        _batchSet(context, methodWriter3);
        methodWriter3.visitVarInsn(25, 0);
        methodWriter3.visitVarInsn(25, 1);
        methodWriter3.visitVarInsn(25, 2);
        methodWriter3.visitVarInsn(25, 3);
        methodWriter3.visitVarInsn(25, context.var("instance"));
        methodWriter3.visitVarInsn(21, 4);
        int i17 = i16 / 32;
        if (i16 != 0 && i16 % 32 != 0) {
            i17++;
        }
        if (i17 == 1) {
            methodWriter3.visitInsn(4);
        } else {
            methodWriter3.visitIntInsn(16, i17);
        }
        methodWriter3.visitIntInsn(188, 10);
        for (int i18 = 0; i18 < i17; i18++) {
            methodWriter3.visitInsn(89);
            if (i18 == 0) {
                methodWriter3.visitInsn(3);
            } else if (i18 == 1) {
                methodWriter3.visitInsn(4);
            } else {
                methodWriter3.visitIntInsn(16, i18);
            }
            methodWriter3.visitVarInsn(21, context.var(AbstractC0004e.m20n(i18, "_asm_flag_")));
            methodWriter3.visitInsn(79);
        }
        String strType = ASMUtils.type(JavaBeanDeserializer.class);
        StringBuilder sb2 = new StringBuilder(str18);
        String str19 = DefaultJSONParser;
        methodWriter3.visitMethodInsn(Opcodes.INVOKEVIRTUAL, strType, "parseRest", AbstractC0004e.m26t(sb2, str19, ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;I[I)Ljava/lang/Object;"));
        methodWriter3.visitTypeInsn(192, ASMUtils.type(context.clazz));
        methodWriter3.visitInsn(Opcodes.ARETURN);
        methodWriter3.visitLabel(label16);
        methodWriter3.visitVarInsn(25, 0);
        methodWriter3.visitVarInsn(25, 1);
        methodWriter3.visitVarInsn(25, 2);
        methodWriter3.visitVarInsn(25, 3);
        methodWriter3.visitVarInsn(21, 4);
        methodWriter3.visitMethodInsn(Opcodes.INVOKESPECIAL, ASMUtils.type(JavaBeanDeserializer.class), "deserialze", AbstractC0004e.m24r(str18, str19, ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;"));
        methodWriter3.visitInsn(Opcodes.ARETURN);
        methodWriter3.visitMaxs(10, context.variantIndex);
        methodWriter3.visitEnd();
    }

    private void _deserialzeArrayMapping(ClassWriter classWriter, Context context) {
        int i6;
        Class<JavaBeanDeserializer> cls;
        int i10;
        int i11;
        StringBuilder sb = new StringBuilder("(L");
        String str = DefaultJSONParser;
        MethodWriter methodWriter = new MethodWriter(classWriter, 1, "deserialzeArrayMapping", AbstractC0004e.m26t(sb, str, ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"), null, null);
        defineVarLexer(context, methodWriter);
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "getSymbolTable", "()" + ASMUtils.desc((Class<?>) SymbolTable.class));
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanTypeName", "(" + ASMUtils.desc((Class<?>) SymbolTable.class) + ")Ljava/lang/String;");
        methodWriter.visitVarInsn(58, context.var("typeName"));
        Label label = new Label();
        methodWriter.visitVarInsn(25, context.var("typeName"));
        methodWriter.visitJumpInsn(Opcodes.IFNULL, label);
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "getConfig", "()" + ASMUtils.desc((Class<?>) ParserConfig.class));
        methodWriter.visitVarInsn(25, 0);
        Class<JavaBeanDeserializer> cls2 = JavaBeanDeserializer.class;
        methodWriter.visitFieldInsn(Opcodes.GETFIELD, ASMUtils.type(cls2), "beanInfo", ASMUtils.desc((Class<?>) JavaBeanInfo.class));
        methodWriter.visitVarInsn(25, context.var("typeName"));
        methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, ASMUtils.type(cls2), "getSeeAlso", "(" + ASMUtils.desc((Class<?>) ParserConfig.class) + ASMUtils.desc((Class<?>) JavaBeanInfo.class) + "Ljava/lang/String;)" + ASMUtils.desc(cls2));
        methodWriter.visitVarInsn(58, context.var("userTypeDeser"));
        methodWriter.visitVarInsn(25, context.var("userTypeDeser"));
        methodWriter.visitTypeInsn(Opcodes.INSTANCEOF, ASMUtils.type(cls2));
        methodWriter.visitJumpInsn(Opcodes.IFEQ, label);
        methodWriter.visitVarInsn(25, context.var("userTypeDeser"));
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitVarInsn(25, 2);
        methodWriter.visitVarInsn(25, 3);
        methodWriter.visitVarInsn(25, 4);
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(cls2), "deserialzeArrayMapping", AbstractC0004e.m24r("(L", str, ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"));
        methodWriter.visitInsn(Opcodes.ARETURN);
        methodWriter.visitLabel(label);
        _createInstance(context, methodWriter);
        FieldInfo[] fieldInfoArr = context.beanInfo.sortedFields;
        int length = fieldInfoArr.length;
        int i12 = 0;
        while (i12 < length) {
            boolean z7 = i12 == length + (-1);
            int i13 = z7 ? 93 : 44;
            FieldInfo fieldInfo = fieldInfoArr[i12];
            Class<?> cls3 = fieldInfo.fieldClass;
            java.lang.reflect.Type type = fieldInfo.fieldType;
            int i14 = length;
            FieldInfo[] fieldInfoArr2 = fieldInfoArr;
            if (cls3 == Byte.TYPE || cls3 == Short.TYPE || cls3 == Integer.TYPE) {
                i6 = i12;
                cls = cls2;
                i14 = i14;
                methodWriter.visitVarInsn(25, context.var("lexer"));
                methodWriter.visitVarInsn(16, i13);
                methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanInt", "(C)I");
                methodWriter.visitVarInsn(54, context.var_asm(fieldInfo));
            } else {
                boolean z10 = z7;
                int i15 = i12;
                if (cls3 == Byte.class) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i13);
                    String str2 = JSONLexerBase;
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str2, "scanInt", "(C)I");
                    methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                    methodWriter.visitVarInsn(58, context.var_asm(fieldInfo));
                    Label label2 = new Label();
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitFieldInsn(Opcodes.GETFIELD, str2, "matchStat", "I");
                    methodWriter.visitLdcInsn(5);
                    methodWriter.visitJumpInsn(Opcodes.IF_ICMPNE, label2);
                    methodWriter.visitInsn(1);
                    methodWriter.visitVarInsn(58, context.var_asm(fieldInfo));
                    methodWriter.visitLabel(label2);
                } else if (cls3 == Short.class) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i13);
                    String str3 = JSONLexerBase;
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str3, "scanInt", "(C)I");
                    methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                    methodWriter.visitVarInsn(58, context.var_asm(fieldInfo));
                    Label label3 = new Label();
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitFieldInsn(Opcodes.GETFIELD, str3, "matchStat", "I");
                    methodWriter.visitLdcInsn(5);
                    methodWriter.visitJumpInsn(Opcodes.IF_ICMPNE, label3);
                    methodWriter.visitInsn(1);
                    methodWriter.visitVarInsn(58, context.var_asm(fieldInfo));
                    methodWriter.visitLabel(label3);
                } else if (cls3 == Integer.class) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i13);
                    String str4 = JSONLexerBase;
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str4, "scanInt", "(C)I");
                    methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                    methodWriter.visitVarInsn(58, context.var_asm(fieldInfo));
                    Label label4 = new Label();
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitFieldInsn(Opcodes.GETFIELD, str4, "matchStat", "I");
                    methodWriter.visitLdcInsn(5);
                    methodWriter.visitJumpInsn(Opcodes.IF_ICMPNE, label4);
                    methodWriter.visitInsn(1);
                    methodWriter.visitVarInsn(58, context.var_asm(fieldInfo));
                    methodWriter.visitLabel(label4);
                } else if (cls3 == Long.TYPE) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i13);
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanLong", "(C)J");
                    methodWriter.visitVarInsn(55, context.var_asm(fieldInfo, 2));
                } else if (cls3 == Long.class) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i13);
                    String str5 = JSONLexerBase;
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "scanLong", "(C)J");
                    methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                    methodWriter.visitVarInsn(58, context.var_asm(fieldInfo));
                    Label label5 = new Label();
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitFieldInsn(Opcodes.GETFIELD, str5, "matchStat", "I");
                    methodWriter.visitLdcInsn(5);
                    methodWriter.visitJumpInsn(Opcodes.IF_ICMPNE, label5);
                    methodWriter.visitInsn(1);
                    methodWriter.visitVarInsn(58, context.var_asm(fieldInfo));
                    methodWriter.visitLabel(label5);
                } else if (cls3 == Boolean.TYPE) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i13);
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanBoolean", "(C)Z");
                    methodWriter.visitVarInsn(54, context.var_asm(fieldInfo));
                } else if (cls3 == Float.TYPE) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i13);
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanFloat", "(C)F");
                    methodWriter.visitVarInsn(56, context.var_asm(fieldInfo));
                } else if (cls3 == Float.class) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i13);
                    String str6 = JSONLexerBase;
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str6, "scanFloat", "(C)F");
                    methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                    methodWriter.visitVarInsn(58, context.var_asm(fieldInfo));
                    Label label6 = new Label();
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitFieldInsn(Opcodes.GETFIELD, str6, "matchStat", "I");
                    methodWriter.visitLdcInsn(5);
                    methodWriter.visitJumpInsn(Opcodes.IF_ICMPNE, label6);
                    methodWriter.visitInsn(1);
                    methodWriter.visitVarInsn(58, context.var_asm(fieldInfo));
                    methodWriter.visitLabel(label6);
                } else if (cls3 == Double.TYPE) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i13);
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanDouble", "(C)D");
                    methodWriter.visitVarInsn(57, context.var_asm(fieldInfo, 2));
                } else if (cls3 == Double.class) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i13);
                    String str7 = JSONLexerBase;
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str7, "scanDouble", "(C)D");
                    methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                    methodWriter.visitVarInsn(58, context.var_asm(fieldInfo));
                    Label label7 = new Label();
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitFieldInsn(Opcodes.GETFIELD, str7, "matchStat", "I");
                    methodWriter.visitLdcInsn(5);
                    methodWriter.visitJumpInsn(Opcodes.IF_ICMPNE, label7);
                    methodWriter.visitInsn(1);
                    methodWriter.visitVarInsn(58, context.var_asm(fieldInfo));
                    methodWriter.visitLabel(label7);
                } else if (cls3 == Character.TYPE) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i13);
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanString", "(C)Ljava/lang/String;");
                    methodWriter.visitInsn(3);
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "charAt", "(I)C");
                    methodWriter.visitVarInsn(54, context.var_asm(fieldInfo));
                } else if (cls3 == String.class) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i13);
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanString", "(C)Ljava/lang/String;");
                    methodWriter.visitVarInsn(58, context.var_asm(fieldInfo));
                } else if (cls3 == BigDecimal.class) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i13);
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanDecimal", "(C)Ljava/math/BigDecimal;");
                    methodWriter.visitVarInsn(58, context.var_asm(fieldInfo));
                } else if (cls3 == Date.class) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i13);
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanDate", "(C)Ljava/util/Date;");
                    methodWriter.visitVarInsn(58, context.var_asm(fieldInfo));
                } else if (cls3 == UUID.class) {
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i13);
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "scanUUID", "(C)Ljava/util/UUID;");
                    methodWriter.visitVarInsn(58, context.var_asm(fieldInfo));
                } else if (cls3.isEnum()) {
                    Label label8 = new Label();
                    Label label9 = new Label();
                    Label label10 = new Label();
                    Label label11 = new Label();
                    cls = cls2;
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    String str8 = JSONLexerBase;
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str8, "getCurrent", "()C");
                    methodWriter.visitInsn(89);
                    methodWriter.visitVarInsn(54, context.var("ch"));
                    methodWriter.visitLdcInsn(110);
                    methodWriter.visitJumpInsn(Opcodes.IF_ICMPEQ, label11);
                    methodWriter.visitVarInsn(21, context.var("ch"));
                    methodWriter.visitLdcInsn(34);
                    methodWriter.visitJumpInsn(Opcodes.IF_ICMPNE, label8);
                    methodWriter.visitLabel(label11);
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc(cls3)));
                    methodWriter.visitVarInsn(25, 1);
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "getSymbolTable", "()" + ASMUtils.desc((Class<?>) SymbolTable.class));
                    methodWriter.visitVarInsn(16, i13);
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str8, "scanEnum", "(Ljava/lang/Class;" + ASMUtils.desc((Class<?>) SymbolTable.class) + "C)Ljava/lang/Enum;");
                    methodWriter.visitJumpInsn(Opcodes.GOTO, label10);
                    methodWriter.visitLabel(label8);
                    methodWriter.visitVarInsn(21, context.var("ch"));
                    methodWriter.visitLdcInsn(48);
                    methodWriter.visitJumpInsn(Opcodes.IF_ICMPLT, label9);
                    methodWriter.visitVarInsn(21, context.var("ch"));
                    methodWriter.visitLdcInsn(57);
                    methodWriter.visitJumpInsn(Opcodes.IF_ICMPGT, label9);
                    _getFieldDeser(context, methodWriter, fieldInfo);
                    methodWriter.visitTypeInsn(192, ASMUtils.type(EnumDeserializer.class));
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i13);
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str8, "scanInt", "(C)I");
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(EnumDeserializer.class), "valueOf", "(I)Ljava/lang/Enum;");
                    methodWriter.visitJumpInsn(Opcodes.GOTO, label10);
                    methodWriter.visitLabel(label9);
                    methodWriter.visitVarInsn(25, 0);
                    methodWriter.visitVarInsn(25, context.var("lexer"));
                    methodWriter.visitVarInsn(16, i13);
                    methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(cls), "scanEnum", AbstractC0004e.m24r("(L", str8, ";C)Ljava/lang/Enum;"));
                    methodWriter.visitLabel(label10);
                    methodWriter.visitTypeInsn(192, ASMUtils.type(cls3));
                    methodWriter.visitVarInsn(58, context.var_asm(fieldInfo));
                    i6 = i15;
                } else {
                    cls = cls2;
                    if (Collection.class.isAssignableFrom(cls3)) {
                        Class<?> collectionItemClass = TypeUtils.getCollectionItemClass(type);
                        if (collectionItemClass == String.class) {
                            if (cls3 == List.class || cls3 == Collections.class || cls3 == ArrayList.class) {
                                methodWriter.visitTypeInsn(Opcodes.NEW, ASMUtils.type(ArrayList.class));
                                methodWriter.visitInsn(89);
                                methodWriter.visitMethodInsn(Opcodes.INVOKESPECIAL, ASMUtils.type(ArrayList.class), "<init>", "()V");
                            } else {
                                methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc(cls3)));
                                methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, ASMUtils.type(TypeUtils.class), "createCollection", "(Ljava/lang/Class;)Ljava/util/Collection;");
                            }
                            methodWriter.visitVarInsn(58, context.var_asm(fieldInfo));
                            methodWriter.visitVarInsn(25, context.var("lexer"));
                            methodWriter.visitVarInsn(25, context.var_asm(fieldInfo));
                            methodWriter.visitVarInsn(16, i13);
                            String str9 = JSONLexerBase;
                            methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str9, "scanStringArray", "(Ljava/util/Collection;C)V");
                            Label label12 = new Label();
                            methodWriter.visitVarInsn(25, context.var("lexer"));
                            methodWriter.visitFieldInsn(Opcodes.GETFIELD, str9, "matchStat", "I");
                            methodWriter.visitLdcInsn(5);
                            methodWriter.visitJumpInsn(Opcodes.IF_ICMPNE, label12);
                            methodWriter.visitInsn(1);
                            methodWriter.visitVarInsn(58, context.var_asm(fieldInfo));
                            methodWriter.visitLabel(label12);
                            i11 = i15;
                        } else {
                            Label label13 = new Label();
                            methodWriter.visitVarInsn(25, context.var("lexer"));
                            String str10 = JSONLexerBase;
                            methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str10, "token", "()I");
                            methodWriter.visitVarInsn(54, context.var("token"));
                            methodWriter.visitVarInsn(21, context.var("token"));
                            int i16 = i15 == 0 ? 14 : 16;
                            methodWriter.visitLdcInsn(Integer.valueOf(i16));
                            methodWriter.visitJumpInsn(Opcodes.IF_ICMPEQ, label13);
                            methodWriter.visitVarInsn(25, 1);
                            methodWriter.visitLdcInsn(Integer.valueOf(i16));
                            String str11 = DefaultJSONParser;
                            methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str11, "throwException", "(I)V");
                            methodWriter.visitLabel(label13);
                            Label label14 = new Label();
                            Label label15 = new Label();
                            methodWriter.visitVarInsn(25, context.var("lexer"));
                            methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str10, "getCurrent", "()C");
                            methodWriter.visitVarInsn(16, 91);
                            methodWriter.visitJumpInsn(Opcodes.IF_ICMPNE, label14);
                            methodWriter.visitVarInsn(25, context.var("lexer"));
                            methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str10, "next", "()C");
                            methodWriter.visitInsn(87);
                            methodWriter.visitVarInsn(25, context.var("lexer"));
                            methodWriter.visitLdcInsn(14);
                            methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str10, "setToken", "(I)V");
                            methodWriter.visitJumpInsn(Opcodes.GOTO, label15);
                            methodWriter.visitLabel(label14);
                            methodWriter.visitVarInsn(25, context.var("lexer"));
                            methodWriter.visitLdcInsn(14);
                            methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str10, "nextToken", "(I)V");
                            methodWriter.visitLabel(label15);
                            i11 = i15;
                            _newCollection(methodWriter, cls3, i11, false);
                            methodWriter.visitInsn(89);
                            methodWriter.visitVarInsn(58, context.var_asm(fieldInfo));
                            _getCollectionFieldItemDeser(context, methodWriter, fieldInfo, collectionItemClass);
                            methodWriter.visitVarInsn(25, 1);
                            methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc(collectionItemClass)));
                            methodWriter.visitVarInsn(25, 3);
                            methodWriter.visitMethodInsn(Opcodes.INVOKESTATIC, ASMUtils.type(cls), "parseArray", "(Ljava/util/Collection;" + ASMUtils.desc((Class<?>) ObjectDeserializer.class) + "L" + str11 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)V");
                        }
                        i6 = i11;
                    } else if (cls3.isArray()) {
                        methodWriter.visitVarInsn(25, context.var("lexer"));
                        methodWriter.visitLdcInsn(14);
                        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "nextToken", "(I)V");
                        methodWriter.visitVarInsn(25, 1);
                        methodWriter.visitVarInsn(25, 0);
                        methodWriter.visitLdcInsn(Integer.valueOf(i15));
                        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(cls), "getFieldType", "(I)Ljava/lang/reflect/Type;");
                        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "parseObject", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;");
                        methodWriter.visitTypeInsn(192, ASMUtils.type(cls3));
                        methodWriter.visitVarInsn(58, context.var_asm(fieldInfo));
                        i6 = i15;
                        i14 = i14;
                    } else {
                        Label label16 = new Label();
                        Label label17 = new Label();
                        if (cls3 == Date.class) {
                            methodWriter.visitVarInsn(25, context.var("lexer"));
                            String str12 = JSONLexerBase;
                            methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str12, "getCurrent", "()C");
                            methodWriter.visitLdcInsn(49);
                            methodWriter.visitJumpInsn(Opcodes.IF_ICMPNE, label16);
                            methodWriter.visitTypeInsn(Opcodes.NEW, ASMUtils.type(Date.class));
                            methodWriter.visitInsn(89);
                            methodWriter.visitVarInsn(25, context.var("lexer"));
                            i10 = 16;
                            methodWriter.visitVarInsn(16, i13);
                            methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str12, "scanLong", "(C)J");
                            methodWriter.visitMethodInsn(Opcodes.INVOKESPECIAL, ASMUtils.type(Date.class), "<init>", "(J)V");
                            methodWriter.visitVarInsn(58, context.var_asm(fieldInfo));
                            methodWriter.visitJumpInsn(Opcodes.GOTO, label17);
                        } else {
                            i10 = 16;
                        }
                        methodWriter.visitLabel(label16);
                        _quickNextToken(context, methodWriter, 14);
                        i6 = i15;
                        i14 = i14;
                        _deserObject(context, methodWriter, fieldInfo, cls3, i6);
                        methodWriter.visitVarInsn(25, context.var("lexer"));
                        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "token", "()I");
                        methodWriter.visitLdcInsn(15);
                        methodWriter.visitJumpInsn(Opcodes.IF_ICMPEQ, label17);
                        methodWriter.visitVarInsn(25, 0);
                        methodWriter.visitVarInsn(25, context.var("lexer"));
                        if (z10) {
                            methodWriter.visitLdcInsn(15);
                        } else {
                            methodWriter.visitLdcInsn(Integer.valueOf(i10));
                        }
                        methodWriter.visitMethodInsn(Opcodes.INVOKESPECIAL, ASMUtils.type(cls), "check", "(" + ASMUtils.desc((Class<?>) JSONLexer.class) + "I)V");
                        methodWriter.visitLabel(label17);
                    }
                }
                cls = cls2;
                i6 = i15;
            }
            i12 = i6 + 1;
            length = i14;
            fieldInfoArr = fieldInfoArr2;
            cls2 = cls;
        }
        _batchSet(context, methodWriter, false);
        Label label18 = new Label();
        Label label19 = new Label();
        Label label20 = new Label();
        Label label21 = new Label();
        methodWriter.visitVarInsn(25, context.var("lexer"));
        String str13 = JSONLexerBase;
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str13, "getCurrent", "()C");
        methodWriter.visitInsn(89);
        methodWriter.visitVarInsn(54, context.var("ch"));
        methodWriter.visitVarInsn(16, 44);
        methodWriter.visitJumpInsn(Opcodes.IF_ICMPNE, label19);
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str13, "next", "()C");
        methodWriter.visitInsn(87);
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitLdcInsn(16);
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str13, "setToken", "(I)V");
        methodWriter.visitJumpInsn(Opcodes.GOTO, label21);
        methodWriter.visitLabel(label19);
        methodWriter.visitVarInsn(21, context.var("ch"));
        methodWriter.visitVarInsn(16, 93);
        methodWriter.visitJumpInsn(Opcodes.IF_ICMPNE, label20);
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str13, "next", "()C");
        methodWriter.visitInsn(87);
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitLdcInsn(15);
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str13, "setToken", "(I)V");
        methodWriter.visitJumpInsn(Opcodes.GOTO, label21);
        methodWriter.visitLabel(label20);
        methodWriter.visitVarInsn(21, context.var("ch"));
        methodWriter.visitVarInsn(16, 26);
        methodWriter.visitJumpInsn(Opcodes.IF_ICMPNE, label18);
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str13, "next", "()C");
        methodWriter.visitInsn(87);
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitLdcInsn(20);
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str13, "setToken", "(I)V");
        methodWriter.visitJumpInsn(Opcodes.GOTO, label21);
        methodWriter.visitLabel(label18);
        methodWriter.visitVarInsn(25, context.var("lexer"));
        methodWriter.visitLdcInsn(16);
        methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str13, "nextToken", "(I)V");
        methodWriter.visitLabel(label21);
        methodWriter.visitVarInsn(25, context.var("instance"));
        methodWriter.visitInsn(Opcodes.ARETURN);
        methodWriter.visitMaxs(5, context.variantIndex);
        methodWriter.visitEnd();
    }

    private void _deserialze_list_obj(Context context, MethodVisitor methodVisitor, Label label, FieldInfo fieldInfo, Class<?> cls, Class<?> cls2, int i6) {
        String str;
        String str2;
        String str3;
        int i10;
        int i11;
        int i12;
        Label label2 = new Label();
        String str4 = JSONLexerBase;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str4, "matchField", "([C)Z");
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label2);
        _setFlag(methodVisitor, context, i6);
        Label label3 = new Label();
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str4, "token", "()I");
        methodVisitor.visitLdcInsn(8);
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label3);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(16);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str4, "nextToken", "(I)V");
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label2);
        methodVisitor.visitLabel(label3);
        Label label4 = new Label();
        Label label5 = new Label();
        Label label6 = new Label();
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str4, "token", "()I");
        methodVisitor.visitLdcInsn(21);
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label5);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(14);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str4, "nextToken", "(I)V");
        _newCollection(methodVisitor, cls, i6, true);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label4);
        methodVisitor.visitLabel(label5);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str4, "token", "()I");
        methodVisitor.visitLdcInsn(14);
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPEQ, label6);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str4, "token", "()I");
        methodVisitor.visitLdcInsn(12);
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label);
        _newCollection(methodVisitor, cls, i6, false);
        methodVisitor.visitVarInsn(58, context.var_asm(fieldInfo));
        _getCollectionFieldItemDeser(context, methodVisitor, fieldInfo, cls2);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
        methodVisitor.visitInsn(3);
        methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        String strType = ASMUtils.type(ObjectDeserializer.class);
        StringBuilder sb = new StringBuilder("(L");
        String str5 = DefaultJSONParser;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, strType, "deserialze", AbstractC0004e.m26t(sb, str5, ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;"));
        methodVisitor.visitVarInsn(58, context.var("list_item_value"));
        methodVisitor.visitVarInsn(25, context.var_asm(fieldInfo));
        methodVisitor.visitVarInsn(25, context.var("list_item_value"));
        if (cls.isInterface()) {
            methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, ASMUtils.type(cls), "add", "(Ljava/lang/Object;)Z");
        } else {
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(cls), "add", "(Ljava/lang/Object;)Z");
        }
        methodVisitor.visitInsn(87);
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label2);
        methodVisitor.visitLabel(label6);
        _newCollection(methodVisitor, cls, i6, false);
        methodVisitor.visitLabel(label4);
        methodVisitor.visitVarInsn(58, context.var_asm(fieldInfo));
        boolean zIsPrimitive2 = ParserConfig.isPrimitive2(fieldInfo.fieldClass);
        _getCollectionFieldItemDeser(context, methodVisitor, fieldInfo, cls2);
        if (zIsPrimitive2) {
            methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, ASMUtils.type(ObjectDeserializer.class), "getFastMatchToken", "()I");
            methodVisitor.visitVarInsn(54, context.var("fastMatchToken"));
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitVarInsn(21, context.var("fastMatchToken"));
            str = str4;
            str2 = "nextToken";
            str3 = "(I)V";
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, str2, str3);
        } else {
            str = str4;
            str2 = "nextToken";
            str3 = "(I)V";
            methodVisitor.visitInsn(87);
            methodVisitor.visitLdcInsn(12);
            methodVisitor.visitVarInsn(54, context.var("fastMatchToken"));
            _quickNextToken(context, methodVisitor, 12);
        }
        methodVisitor.visitVarInsn(25, 1);
        String str6 = str3;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "getContext", "()" + ASMUtils.desc((Class<?>) ParseContext.class));
        methodVisitor.visitVarInsn(58, context.var("listContext"));
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, context.var_asm(fieldInfo));
        methodVisitor.visitLdcInsn(fieldInfo.name);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)" + ASMUtils.desc((Class<?>) ParseContext.class));
        methodVisitor.visitInsn(87);
        Label label7 = new Label();
        Label label8 = new Label();
        methodVisitor.visitInsn(3);
        String str7 = str2;
        methodVisitor.visitVarInsn(54, context.var(CmcdData.OBJECT_TYPE_INIT_SEGMENT));
        methodVisitor.visitLabel(label7);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "token", "()I");
        methodVisitor.visitLdcInsn(15);
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPEQ, label8);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(Opcodes.GETFIELD, context.className, AbstractC0004e.m26t(new StringBuilder(), fieldInfo.name, "_asm_list_item_deser__"), ASMUtils.desc((Class<?>) ObjectDeserializer.class));
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls2)));
        methodVisitor.visitVarInsn(21, context.var(CmcdData.OBJECT_TYPE_INIT_SEGMENT));
        methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, ASMUtils.type(ObjectDeserializer.class), "deserialze", AbstractC0004e.m24r("(L", str5, ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;"));
        methodVisitor.visitVarInsn(58, context.var("list_item_value"));
        methodVisitor.visitIincInsn(context.var(CmcdData.OBJECT_TYPE_INIT_SEGMENT), 1);
        methodVisitor.visitVarInsn(25, context.var_asm(fieldInfo));
        methodVisitor.visitVarInsn(25, context.var("list_item_value"));
        if (cls.isInterface()) {
            methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, ASMUtils.type(cls), "add", "(Ljava/lang/Object;)Z");
            i11 = 87;
            i10 = Opcodes.INVOKEVIRTUAL;
        } else {
            String strType2 = ASMUtils.type(cls);
            i10 = Opcodes.INVOKEVIRTUAL;
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, strType2, "add", "(Ljava/lang/Object;)Z");
            i11 = 87;
        }
        methodVisitor.visitInsn(i11);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, context.var_asm(fieldInfo));
        methodVisitor.visitMethodInsn(i10, str5, "checkListResolve", "(Ljava/util/Collection;)V");
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(i10, str, "token", "()I");
        methodVisitor.visitLdcInsn(16);
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label7);
        if (zIsPrimitive2) {
            methodVisitor.visitVarInsn(25, context.var("lexer"));
            methodVisitor.visitVarInsn(21, context.var("fastMatchToken"));
            methodVisitor.visitMethodInsn(i10, str, str7, str6);
            i12 = Opcodes.GOTO;
        } else {
            _quickNextToken(context, methodVisitor, 12);
            i12 = Opcodes.GOTO;
        }
        methodVisitor.visitJumpInsn(i12, label7);
        methodVisitor.visitLabel(label8);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, context.var("listContext"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str5, "setContext", "(" + ASMUtils.desc((Class<?>) ParseContext.class) + ")V");
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "token", "()I");
        methodVisitor.visitLdcInsn(15);
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label);
        _quickNextTokenComma(context, methodVisitor);
        methodVisitor.visitLabel(label2);
    }

    private void _deserialze_obj(Context context, MethodVisitor methodVisitor, Label label, FieldInfo fieldInfo, Class<?> cls, int i6) {
        Label label2 = new Label();
        Label label3 = new Label();
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(Opcodes.GETFIELD, context.className, context.fieldName(fieldInfo), "[C");
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, JSONLexerBase, "matchField", "([C)Z");
        methodVisitor.visitJumpInsn(Opcodes.IFNE, label2);
        methodVisitor.visitInsn(1);
        methodVisitor.visitVarInsn(58, context.var_asm(fieldInfo));
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label3);
        methodVisitor.visitLabel(label2);
        _setFlag(methodVisitor, context, i6);
        methodVisitor.visitVarInsn(21, context.var("matchedCount"));
        methodVisitor.visitInsn(4);
        methodVisitor.visitInsn(96);
        methodVisitor.visitVarInsn(54, context.var("matchedCount"));
        _deserObject(context, methodVisitor, fieldInfo, cls, i6);
        methodVisitor.visitVarInsn(25, 1);
        String str = DefaultJSONParser;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "getResolveStatus", "()I");
        methodVisitor.visitLdcInsn(1);
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label3);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "getLastResolveTask", "()" + ASMUtils.desc((Class<?>) DefaultJSONParser.ResolveTask.class));
        methodVisitor.visitVarInsn(58, context.var("resolveTask"));
        methodVisitor.visitVarInsn(25, context.var("resolveTask"));
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "getContext", "()" + ASMUtils.desc((Class<?>) ParseContext.class));
        methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, ASMUtils.type(DefaultJSONParser.ResolveTask.class), "ownerContext", ASMUtils.desc((Class<?>) ParseContext.class));
        methodVisitor.visitVarInsn(25, context.var("resolveTask"));
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitLdcInsn(fieldInfo.name);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(JavaBeanDeserializer.class), "getFieldDeserializer", "(Ljava/lang/String;)" + ASMUtils.desc((Class<?>) FieldDeserializer.class));
        methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, ASMUtils.type(DefaultJSONParser.ResolveTask.class), "fieldDeserializer", ASMUtils.desc((Class<?>) FieldDeserializer.class));
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(0);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "setResolveStatus", "(I)V");
        methodVisitor.visitLabel(label3);
    }

    private void _getCollectionFieldItemDeser(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo, Class<?> cls) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(Opcodes.GETFIELD, context.className, AbstractC0004e.m26t(new StringBuilder(), fieldInfo.name, "_asm_list_item_deser__"), ASMUtils.desc((Class<?>) ObjectDeserializer.class));
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "getConfig", "()" + ASMUtils.desc((Class<?>) ParserConfig.class));
        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(cls)));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(ParserConfig.class), "getDeserializer", "(Ljava/lang/reflect/Type;)" + ASMUtils.desc((Class<?>) ObjectDeserializer.class));
        methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, context.className, AbstractC0004e.m26t(new StringBuilder(), fieldInfo.name, "_asm_list_item_deser__"), ASMUtils.desc((Class<?>) ObjectDeserializer.class));
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(Opcodes.GETFIELD, context.className, AbstractC0004e.m26t(new StringBuilder(), fieldInfo.name, "_asm_list_item_deser__"), ASMUtils.desc((Class<?>) ObjectDeserializer.class));
    }

    private void _getFieldDeser(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Label label = new Label();
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(Opcodes.GETFIELD, context.className, context.fieldDeserName(fieldInfo), ASMUtils.desc((Class<?>) ObjectDeserializer.class));
        methodVisitor.visitJumpInsn(Opcodes.IFNONNULL, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "getConfig", "()" + ASMUtils.desc((Class<?>) ParserConfig.class));
        methodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.fieldClass)));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(ParserConfig.class), "getDeserializer", "(Ljava/lang/reflect/Type;)" + ASMUtils.desc((Class<?>) ObjectDeserializer.class));
        methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, context.className, context.fieldDeserName(fieldInfo), ASMUtils.desc((Class<?>) ObjectDeserializer.class));
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(Opcodes.GETFIELD, context.className, context.fieldDeserName(fieldInfo), ASMUtils.desc((Class<?>) ObjectDeserializer.class));
    }

    private void _init(ClassWriter classWriter, Context context) {
        int length = context.fieldInfoList.length;
        for (int i6 = 0; i6 < length; i6++) {
            new FieldWriter(classWriter, 1, context.fieldName(context.fieldInfoList[i6]), "[C").visitEnd();
        }
        int length2 = context.fieldInfoList.length;
        for (int i10 = 0; i10 < length2; i10++) {
            FieldInfo fieldInfo = context.fieldInfoList[i10];
            Class<?> cls = fieldInfo.fieldClass;
            if (!cls.isPrimitive()) {
                if (Collection.class.isAssignableFrom(cls)) {
                    new FieldWriter(classWriter, 1, AbstractC0004e.m26t(new StringBuilder(), fieldInfo.name, "_asm_list_item_deser__"), ASMUtils.desc((Class<?>) ObjectDeserializer.class)).visitEnd();
                } else {
                    new FieldWriter(classWriter, 1, context.fieldDeserName(fieldInfo), ASMUtils.desc((Class<?>) ObjectDeserializer.class)).visitEnd();
                }
            }
        }
        MethodWriter methodWriter = new MethodWriter(classWriter, 1, "<init>", "(" + ASMUtils.desc((Class<?>) ParserConfig.class) + ASMUtils.desc((Class<?>) JavaBeanInfo.class) + ")V", null, null);
        methodWriter.visitVarInsn(25, 0);
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitVarInsn(25, 2);
        methodWriter.visitMethodInsn(Opcodes.INVOKESPECIAL, ASMUtils.type(JavaBeanDeserializer.class), "<init>", "(" + ASMUtils.desc((Class<?>) ParserConfig.class) + ASMUtils.desc((Class<?>) JavaBeanInfo.class) + ")V");
        int length3 = context.fieldInfoList.length;
        for (int i11 = 0; i11 < length3; i11++) {
            FieldInfo fieldInfo2 = context.fieldInfoList[i11];
            methodWriter.visitVarInsn(25, 0);
            methodWriter.visitLdcInsn("\"" + fieldInfo2.name + "\":");
            methodWriter.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "toCharArray", "()[C");
            methodWriter.visitFieldInsn(Opcodes.PUTFIELD, context.className, context.fieldName(fieldInfo2), "[C");
        }
        methodWriter.visitInsn(Opcodes.RETURN);
        methodWriter.visitMaxs(4, 4);
        methodWriter.visitEnd();
    }

    private void _isFlag(MethodVisitor methodVisitor, Context context, int i6, Label label) {
        methodVisitor.visitVarInsn(21, context.var("_asm_flag_" + (i6 / 32)));
        methodVisitor.visitLdcInsn(Integer.valueOf(1 << i6));
        methodVisitor.visitInsn(126);
        methodVisitor.visitJumpInsn(Opcodes.IFEQ, label);
    }

    private void _loadAndSet(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Class<?> cls = fieldInfo.fieldClass;
        java.lang.reflect.Type type = fieldInfo.fieldType;
        if (cls == Boolean.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(21, context.var_asm(fieldInfo));
            _set(context, methodVisitor, fieldInfo);
            return;
        }
        if (cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE || cls == Character.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(21, context.var_asm(fieldInfo));
            _set(context, methodVisitor, fieldInfo);
            return;
        }
        if (cls == Long.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(22, context.var_asm(fieldInfo, 2));
            if (fieldInfo.method == null) {
                methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, ASMUtils.type(fieldInfo.declaringClass), fieldInfo.field.getName(), ASMUtils.desc(fieldInfo.fieldClass));
                return;
            }
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(context.getInstClass()), fieldInfo.method.getName(), ASMUtils.desc(fieldInfo.method));
            if (fieldInfo.method.getReturnType().equals(Void.TYPE)) {
                return;
            }
            methodVisitor.visitInsn(87);
            return;
        }
        if (cls == Float.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(23, context.var_asm(fieldInfo));
            _set(context, methodVisitor, fieldInfo);
            return;
        }
        if (cls == Double.TYPE) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(24, context.var_asm(fieldInfo, 2));
            _set(context, methodVisitor, fieldInfo);
            return;
        }
        if (cls == String.class) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(25, context.var_asm(fieldInfo));
            _set(context, methodVisitor, fieldInfo);
            return;
        }
        if (cls.isEnum()) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(25, context.var_asm(fieldInfo));
            _set(context, methodVisitor, fieldInfo);
        } else if (!Collection.class.isAssignableFrom(cls)) {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            methodVisitor.visitVarInsn(25, context.var_asm(fieldInfo));
            _set(context, methodVisitor, fieldInfo);
        } else {
            methodVisitor.visitVarInsn(25, context.var("instance"));
            if (TypeUtils.getCollectionItemClass(type) == String.class) {
                methodVisitor.visitVarInsn(25, context.var_asm(fieldInfo));
                methodVisitor.visitTypeInsn(192, ASMUtils.type(cls));
            } else {
                methodVisitor.visitVarInsn(25, context.var_asm(fieldInfo));
            }
            _set(context, methodVisitor, fieldInfo);
        }
    }

    private void _newCollection(MethodVisitor methodVisitor, Class<?> cls, int i6, boolean z7) {
        if (cls.isAssignableFrom(ArrayList.class) && !z7) {
            methodVisitor.visitTypeInsn(Opcodes.NEW, "java/util/ArrayList");
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/util/ArrayList", "<init>", "()V");
        } else if (cls.isAssignableFrom(LinkedList.class) && !z7) {
            methodVisitor.visitTypeInsn(Opcodes.NEW, ASMUtils.type(LinkedList.class));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, ASMUtils.type(LinkedList.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(HashSet.class)) {
            methodVisitor.visitTypeInsn(Opcodes.NEW, ASMUtils.type(HashSet.class));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, ASMUtils.type(HashSet.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(TreeSet.class)) {
            methodVisitor.visitTypeInsn(Opcodes.NEW, ASMUtils.type(TreeSet.class));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, ASMUtils.type(TreeSet.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(LinkedHashSet.class)) {
            methodVisitor.visitTypeInsn(Opcodes.NEW, ASMUtils.type(LinkedHashSet.class));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, ASMUtils.type(LinkedHashSet.class), "<init>", "()V");
        } else if (z7) {
            methodVisitor.visitTypeInsn(Opcodes.NEW, ASMUtils.type(HashSet.class));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, ASMUtils.type(HashSet.class), "<init>", "()V");
        } else {
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitLdcInsn(Integer.valueOf(i6));
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ASMUtils.type(JavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            methodVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, ASMUtils.type(TypeUtils.class), "createCollection", "(Ljava/lang/reflect/Type;)Ljava/util/Collection;");
        }
        methodVisitor.visitTypeInsn(192, ASMUtils.type(cls));
    }

    private void _quickNextToken(Context context, MethodVisitor methodVisitor, int i6) {
        Label label = new Label();
        Label label2 = new Label();
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        String str = JSONLexerBase;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "getCurrent", "()C");
        if (i6 == 12) {
            methodVisitor.visitVarInsn(16, 123);
        } else {
            if (i6 != 14) {
                throw new IllegalStateException();
            }
            methodVisitor.visitVarInsn(16, 91);
        }
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "next", "()C");
        methodVisitor.visitInsn(87);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(Integer.valueOf(i6));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "setToken", "(I)V");
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label2);
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(Integer.valueOf(i6));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "nextToken", "(I)V");
        methodVisitor.visitLabel(label2);
    }

    private void _quickNextTokenComma(Context context, MethodVisitor methodVisitor) {
        Label label = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        Label label5 = new Label();
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        String str = JSONLexerBase;
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "getCurrent", "()C");
        methodVisitor.visitInsn(89);
        methodVisitor.visitVarInsn(54, context.var("ch"));
        methodVisitor.visitVarInsn(16, 44);
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label2);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "next", "()C");
        methodVisitor.visitInsn(87);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(16);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "setToken", "(I)V");
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label5);
        methodVisitor.visitLabel(label2);
        methodVisitor.visitVarInsn(21, context.var("ch"));
        methodVisitor.visitVarInsn(16, 125);
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label3);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "next", "()C");
        methodVisitor.visitInsn(87);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(13);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "setToken", "(I)V");
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label5);
        methodVisitor.visitLabel(label3);
        methodVisitor.visitVarInsn(21, context.var("ch"));
        methodVisitor.visitVarInsn(16, 93);
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label4);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "next", "()C");
        methodVisitor.visitInsn(87);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(15);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "setToken", "(I)V");
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label5);
        methodVisitor.visitLabel(label4);
        methodVisitor.visitVarInsn(21, context.var("ch"));
        methodVisitor.visitVarInsn(16, 26);
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPNE, label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitLdcInsn(20);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "setToken", "(I)V");
        methodVisitor.visitJumpInsn(Opcodes.GOTO, label5);
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, context.var("lexer"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, str, "nextToken", "()V");
        methodVisitor.visitLabel(label5);
    }

    private void _set(Context context, MethodVisitor methodVisitor, FieldInfo fieldInfo) {
        Method method = fieldInfo.method;
        if (method == null) {
            methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, ASMUtils.type(fieldInfo.declaringClass), fieldInfo.field.getName(), ASMUtils.desc(fieldInfo.fieldClass));
            return;
        }
        methodVisitor.visitMethodInsn(method.getDeclaringClass().isInterface() ? Opcodes.INVOKEINTERFACE : Opcodes.INVOKEVIRTUAL, ASMUtils.type(fieldInfo.declaringClass), method.getName(), ASMUtils.desc(method));
        if (fieldInfo.method.getReturnType().equals(Void.TYPE)) {
            return;
        }
        methodVisitor.visitInsn(87);
    }

    private void _setContext(Context context, MethodVisitor methodVisitor) {
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, context.var("context"));
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, DefaultJSONParser, "setContext", "(" + ASMUtils.desc((Class<?>) ParseContext.class) + ")V");
        Label label = new Label();
        methodVisitor.visitVarInsn(25, context.var("childContext"));
        methodVisitor.visitJumpInsn(Opcodes.IFNULL, label);
        methodVisitor.visitVarInsn(25, context.var("childContext"));
        methodVisitor.visitVarInsn(25, context.var("instance"));
        methodVisitor.visitFieldInsn(Opcodes.PUTFIELD, ASMUtils.type(ParseContext.class), "object", "Ljava/lang/Object;");
        methodVisitor.visitLabel(label);
    }

    private void _setFlag(MethodVisitor methodVisitor, Context context, int i6) {
        String str = "_asm_flag_" + (i6 / 32);
        methodVisitor.visitVarInsn(21, context.var(str));
        methodVisitor.visitLdcInsn(Integer.valueOf(1 << i6));
        methodVisitor.visitInsn(128);
        methodVisitor.visitVarInsn(54, context.var(str));
    }

    private void defineVarLexer(Context context, MethodVisitor methodVisitor) {
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitFieldInsn(Opcodes.GETFIELD, DefaultJSONParser, "lexer", ASMUtils.desc((Class<?>) JSONLexer.class));
        methodVisitor.visitTypeInsn(192, JSONLexerBase);
        methodVisitor.visitVarInsn(58, context.var("lexer"));
    }

    public ObjectDeserializer createJavaBeanDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo) throws Exception {
        String strM5495i;
        Class<?> cls = javaBeanInfo.clazz;
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException("not support type :".concat(cls.getName()));
        }
        String str = "FastjsonASMDeserializer_" + this.seed.incrementAndGet() + "_" + cls.getSimpleName();
        Package r10 = ASMDeserializerFactory.class.getPackage();
        if (r10 != null) {
            String name = r10.getName();
            String str2 = name.replace('.', '/') + "/" + str;
            strM5495i = AbstractC2460q.m5495i(name, ".", str);
            str = str2;
        } else {
            strM5495i = str;
        }
        ClassWriter classWriter = new ClassWriter();
        classWriter.visit(49, 33, str, ASMUtils.type(JavaBeanDeserializer.class), null);
        _init(classWriter, new Context(str, parserConfig, javaBeanInfo, 3));
        _createInstance(classWriter, new Context(str, parserConfig, javaBeanInfo, 3));
        _deserialze(classWriter, new Context(str, parserConfig, javaBeanInfo, 5));
        _deserialzeArrayMapping(classWriter, new Context(str, parserConfig, javaBeanInfo, 4));
        byte[] byteArray = classWriter.toByteArray();
        return (ObjectDeserializer) this.classLoader.defineClassPublic(strM5495i, byteArray, 0, byteArray.length).getConstructor(ParserConfig.class, JavaBeanInfo.class).newInstance(parserConfig, javaBeanInfo);
    }

    private void _batchSet(Context context, MethodVisitor methodVisitor, boolean z7) {
        int length = context.fieldInfoList.length;
        for (int i6 = 0; i6 < length; i6++) {
            Label label = new Label();
            if (z7) {
                _isFlag(methodVisitor, context, i6, label);
            }
            _loadAndSet(context, methodVisitor, context.fieldInfoList[i6]);
            if (z7) {
                methodVisitor.visitLabel(label);
            }
        }
    }

    public static class Context {
        static final int fieldName = 3;
        static final int parser = 1;
        static final int type = 2;
        private final JavaBeanInfo beanInfo;
        private final String className;
        private final Class<?> clazz;
        private FieldInfo[] fieldInfoList;
        private int variantIndex;
        private final Map<String, Integer> variants = new HashMap();

        public Context(String str, ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, int i6) {
            this.variantIndex = -1;
            this.className = str;
            this.clazz = javaBeanInfo.clazz;
            this.variantIndex = i6;
            this.beanInfo = javaBeanInfo;
            this.fieldInfoList = javaBeanInfo.fields;
        }

        public String fieldDeserName(FieldInfo fieldInfo) {
            if (validIdent(fieldInfo.name)) {
                return AbstractC0004e.m26t(new StringBuilder(), fieldInfo.name, "_asm_deser__");
            }
            return "_asm_deser__" + TypeUtils.fnv1a_64_extract(fieldInfo.name);
        }

        public String fieldName(FieldInfo fieldInfo) {
            if (validIdent(fieldInfo.name)) {
                return AbstractC0004e.m26t(new StringBuilder(), fieldInfo.name, "_asm_prefix__");
            }
            return "asm_field_" + TypeUtils.fnv1a_64_extract(fieldInfo.name);
        }

        public Class<?> getInstClass() {
            Class<?> cls = this.beanInfo.builderClass;
            return cls == null ? this.clazz : cls;
        }

        public boolean validIdent(String str) {
            for (int i6 = 0; i6 < str.length(); i6++) {
                char cCharAt = str.charAt(i6);
                if (cCharAt == 0) {
                    if (!IOUtils.firstIdentifier(cCharAt)) {
                        return false;
                    }
                } else if (!IOUtils.isIdent(cCharAt)) {
                    return false;
                }
            }
            return true;
        }

        public int var(String str, int i6) {
            if (this.variants.get(str) == null) {
                this.variants.put(str, Integer.valueOf(this.variantIndex));
                this.variantIndex += i6;
            }
            return this.variants.get(str).intValue();
        }

        public int var_asm(FieldInfo fieldInfo) {
            return var(AbstractC0004e.m26t(new StringBuilder(), fieldInfo.name, "_asm"));
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

        public int var_asm(FieldInfo fieldInfo, int i6) {
            return var(AbstractC0004e.m26t(new StringBuilder(), fieldInfo.name, "_asm"), i6);
        }
    }

    private void _createInstance(ClassWriter classWriter, Context context) {
        if (Modifier.isPublic(context.beanInfo.defaultConstructor.getModifiers())) {
            MethodWriter methodWriter = new MethodWriter(classWriter, 1, "createInstance", AbstractC0004e.m26t(new StringBuilder("(L"), DefaultJSONParser, ";Ljava/lang/reflect/Type;)Ljava/lang/Object;"), null, null);
            methodWriter.visitTypeInsn(Opcodes.NEW, ASMUtils.type(context.getInstClass()));
            methodWriter.visitInsn(89);
            methodWriter.visitMethodInsn(Opcodes.INVOKESPECIAL, ASMUtils.type(context.getInstClass()), "<init>", "()V");
            methodWriter.visitInsn(Opcodes.ARETURN);
            methodWriter.visitMaxs(3, 3);
            methodWriter.visitEnd();
        }
    }
}

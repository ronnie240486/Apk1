package com.google.android.gms.internal.cast;

import com.lzy.okgo.cache.CacheEntity;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class AbstractC1702u7 {

    public static final char[] f5690a;

    static {
        char[] cArr = new char[80];
        f5690a = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static void m4025a(StringBuilder sb, int i6, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                m4025a(sb, i6, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                m4025a(sb, i6, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        m4026b(sb, i6);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i10 = 1; i10 < str.length(); i10++) {
                char cCharAt = str.charAt(i10);
                if (Character.isUpperCase(cCharAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(cCharAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            C1529c7 c1529c7 = C1529c7.f5233c;
            sb.append(AbstractC1503a1.m3694e(new C1529c7(((String) obj).getBytes(AbstractC1639n7.f5472a))));
            sb.append('\"');
            return;
        }
        if (obj instanceof C1529c7) {
            sb.append(": \"");
            sb.append(AbstractC1503a1.m3694e((C1529c7) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof AbstractC1589i7) {
            sb.append(" {");
            m4027c((AbstractC1589i7) obj, sb, i6 + 2);
            sb.append("\n");
            m4026b(sb, i6);
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        int i11 = i6 + 2;
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        m4025a(sb, i11, CacheEntity.KEY, entry.getKey());
        m4025a(sb, i11, "value", entry.getValue());
        sb.append("\n");
        m4026b(sb, i6);
        sb.append("}");
    }

    public static void m4026b(StringBuilder sb, int i6) {
        while (i6 > 0) {
            int i10 = 80;
            if (i6 <= 80) {
                i10 = i6;
            }
            sb.append(f5690a, 0, i10);
            i6 -= i10;
        }
    }

    public static void m4027c(AbstractC1589i7 abstractC1589i7, StringBuilder sb, int i6) {
        int i10;
        boolean zEquals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = abstractC1589i7.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i11 = 0;
        while (true) {
            i10 = 3;
            if (i11 >= length) {
                break;
            }
            Method method3 = declaredMethods[i11];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        map.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i11++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String strSubstring = ((String) entry.getKey()).substring(i10);
            if (strSubstring.endsWith("List") && !strSubstring.endsWith("OrBuilderList") && !strSubstring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                m4025a(sb, i6, strSubstring.substring(0, strSubstring.length() - 4), AbstractC1589i7.m3863c(method2, abstractC1589i7, new Object[0]));
            } else if (strSubstring.endsWith("Map") && !strSubstring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                m4025a(sb, i6, strSubstring.substring(0, strSubstring.length() - 3), AbstractC1589i7.m3863c(method, abstractC1589i7, new Object[0]));
            } else if (hashSet.contains("set".concat(strSubstring)) && (!strSubstring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(strSubstring.substring(0, strSubstring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) map.get("has".concat(strSubstring));
                if (method4 != null) {
                    Object objM3863c = AbstractC1589i7.m3863c(method4, abstractC1589i7, new Object[0]);
                    if (method5 == null) {
                        if (objM3863c instanceof Boolean) {
                            if (((Boolean) objM3863c).booleanValue()) {
                                m4025a(sb, i6, strSubstring, objM3863c);
                            }
                        } else if (objM3863c instanceof Integer) {
                            if (((Integer) objM3863c).intValue() != 0) {
                                m4025a(sb, i6, strSubstring, objM3863c);
                            }
                        } else if (objM3863c instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) objM3863c).floatValue()) != 0) {
                                m4025a(sb, i6, strSubstring, objM3863c);
                            }
                        } else if (!(objM3863c instanceof Double)) {
                            if (objM3863c instanceof String) {
                                zEquals = objM3863c.equals("");
                            } else if (objM3863c instanceof C1529c7) {
                                zEquals = objM3863c.equals(C1529c7.f5233c);
                            } else if (objM3863c instanceof AbstractC1728x6) {
                                if (objM3863c != ((AbstractC1589i7) ((AbstractC1589i7) ((AbstractC1728x6) objM3863c)).mo3714h(6, null))) {
                                    m4025a(sb, i6, strSubstring, objM3863c);
                                }
                            } else if (!(objM3863c instanceof Enum) || ((Enum) objM3863c).ordinal() != 0) {
                                m4025a(sb, i6, strSubstring, objM3863c);
                            }
                            if (!zEquals) {
                                m4025a(sb, i6, strSubstring, objM3863c);
                            }
                        } else if (Double.doubleToRawLongBits(((Double) objM3863c).doubleValue()) != 0) {
                            m4025a(sb, i6, strSubstring, objM3863c);
                        }
                    } else if (((Boolean) AbstractC1589i7.m3863c(method5, abstractC1589i7, new Object[0])).booleanValue()) {
                        m4025a(sb, i6, strSubstring, objM3863c);
                    }
                }
            }
            i10 = 3;
        }
    }
}

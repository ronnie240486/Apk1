package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public final class C2016a {
    public static String m4500a(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        int i6 = 0;
        while (true) {
            String str = "map";
            if (i6 >= arrayList.size()) {
                Collections.reverse(arrayList);
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    String str2 = arrayList.get(i10);
                    if (str2.equals("list")) {
                        int i11 = i10 - 1;
                        arrayList.set(i11, "<" + arrayList.get(i11));
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str2.equals("map")) {
                        int i12 = i10 - 1;
                        arrayList.set(i12, "<" + arrayList.get(i12) + ",");
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str2.equals("Array")) {
                        int i13 = i10 - 1;
                        arrayList.set(i13, "<" + arrayList.get(i13));
                        arrayList.set(0, arrayList.get(0) + ">");
                    }
                }
                Collections.reverse(arrayList);
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(it.next());
                }
                return stringBuffer.toString();
            }
            String str3 = arrayList.get(i6);
            if (str3.equals("java.lang.Integer") || str3.equals("int")) {
                str = "int32";
            } else if (str3.equals("java.lang.Boolean") || str3.equals("boolean")) {
                str = "bool";
            } else if (str3.equals("java.lang.Byte") || str3.equals("byte")) {
                str = "char";
            } else {
                String str4 = "double";
                if (str3.equals("java.lang.Double") || str3.equals("double")) {
                    str = str4;
                } else {
                    str4 = "float";
                    if (str3.equals("java.lang.Float") || str3.equals("float")) {
                        str = str4;
                    } else if (str3.equals("java.lang.Long") || str3.equals("long")) {
                        str = "int64";
                    } else {
                        str4 = "short";
                        if (str3.equals("java.lang.Short") || str3.equals("short")) {
                            str = str4;
                        } else {
                            if (str3.equals("java.lang.Character")) {
                                throw new IllegalArgumentException("can not support java.lang.Character");
                            }
                            if (str3.equals("java.lang.String")) {
                                str = "string";
                            } else if (str3.equals("java.util.List")) {
                                str = "list";
                            } else if (!str3.equals("java.util.Map")) {
                                str = str3;
                            }
                        }
                    }
                }
            }
            arrayList.set(i6, str);
            i6++;
        }
    }
}

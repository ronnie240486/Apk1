package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class C2050be {

    private static List<File> f7462a = new ArrayList();

    public static String m4827a(String str) {
        if (str == null) {
            return "";
        }
        String[] strArrSplit = str.split("\n");
        if (strArrSplit == null || strArrSplit.length == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrSplit) {
            if (!str2.contains("java.lang.Thread.getStackTrace(")) {
                sb.append(str2);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private static String m4834b(String str, String str2) {
        BufferedReader bufferedReaderM4696b = C2033ap.m4696b(str, "reg_record.txt");
        if (bufferedReaderM4696b == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String line = bufferedReaderM4696b.readLine();
            if (line != null && line.startsWith(str2)) {
                int i6 = 18;
                int i10 = 0;
                int length = 0;
                while (true) {
                    String line2 = bufferedReaderM4696b.readLine();
                    if (line2 == null) {
                        break;
                    }
                    if (i10 % 4 == 0) {
                        if (i10 > 0) {
                            sb.append("\n");
                        }
                        sb.append("  ");
                    } else {
                        if (line2.length() > 16) {
                            i6 = 28;
                        }
                        sb.append("                ".substring(0, i6 - length));
                    }
                    length = line2.length();
                    sb.append(line2);
                    i10++;
                }
                sb.append("\n");
                String string = sb.toString();
                try {
                    bufferedReaderM4696b.close();
                } catch (Exception e5) {
                    C2029al.m4641a(e5);
                }
                return string;
            }
            try {
                bufferedReaderM4696b.close();
            } catch (Exception e10) {
                C2029al.m4641a(e10);
            }
            return null;
        } catch (Throwable th) {
            try {
                C2029al.m4641a(th);
                return null;
            } finally {
                try {
                    bufferedReaderM4696b.close();
                } catch (Exception e11) {
                    C2029al.m4641a(e11);
                }
            }
        }
    }

    private static String m4835c(String str, String str2) {
        BufferedReader bufferedReaderM4696b = C2033ap.m4696b(str, "map_record.txt");
        if (bufferedReaderM4696b == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String line = bufferedReaderM4696b.readLine();
            if (line != null && line.startsWith(str2)) {
                while (true) {
                    String line2 = bufferedReaderM4696b.readLine();
                    if (line2 == null) {
                        break;
                    }
                    sb.append("  ");
                    sb.append(line2);
                    sb.append("\n");
                }
                String string = sb.toString();
                try {
                    bufferedReaderM4696b.close();
                } catch (Exception e5) {
                    C2029al.m4641a(e5);
                }
                return string;
            }
            try {
                bufferedReaderM4696b.close();
            } catch (Exception e10) {
                C2029al.m4641a(e10);
            }
            return null;
        } catch (Throwable th) {
            try {
                C2029al.m4641a(th);
                return null;
            } finally {
                try {
                    bufferedReaderM4696b.close();
                } catch (Exception e11) {
                    C2029al.m4641a(e11);
                }
            }
        }
    }

    private static Map<String, Integer> m4837d(String str) {
        if (str == null) {
            return null;
        }
        try {
            HashMap map = new HashMap();
            for (String str2 : str.split(",")) {
                String[] strArrSplit = str2.split(":");
                if (strArrSplit.length != 2) {
                    C2029al.m4646e("error format at %s", str2);
                    return null;
                }
                map.put(strArrSplit[0], Integer.valueOf(Integer.parseInt(strArrSplit[1])));
            }
            return map;
        } catch (Exception e5) {
            C2029al.m4646e("error format intStateStr %s", str);
            e5.printStackTrace();
            return null;
        }
    }

    private static <KeyT, ValueT> ValueT m4825a(Map<KeyT, ValueT> map, KeyT keyt, ValueT valuet) {
        try {
            ValueT valuet2 = map.get(keyt);
            return valuet2 != null ? valuet2 : valuet;
        } catch (Exception e5) {
            C2029al.m4641a(e5);
        }
    }

    private static String m4826a(BufferedInputStream bufferedInputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            while (true) {
                try {
                    int i6 = bufferedInputStream.read();
                    if (i6 == -1) {
                        break;
                    }
                    if (i6 == 0) {
                        String str = new String(byteArrayOutputStream.toByteArray(), "UTf-8");
                        byteArrayOutputStream.close();
                        return str;
                    }
                    byteArrayOutputStream.write(i6);
                } catch (Throwable th) {
                    th = th;
                    try {
                        C2029al.m4641a(th);
                        if (byteArrayOutputStream != null) {
                            break;
                        }
                        return null;
                    } finally {
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
        return null;
    }

    public static CrashDetailBean m4823a(Context context, String str, NativeExceptionHandler nativeExceptionHandler) throws Throwable {
        BufferedInputStream bufferedInputStream;
        String str2;
        String strM4826a;
        BufferedInputStream bufferedInputStream2 = 0;
        if (context != null && str != null && nativeExceptionHandler != null) {
            File file = new File(str, "rqd_record.eup");
            if (file.exists()) {
                ?? CanRead = file.canRead();
                try {
                    if (CanRead != 0) {
                        try {
                            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                            try {
                                String strM4826a2 = m4826a(bufferedInputStream);
                                if (strM4826a2 != null && strM4826a2.equals("NATIVE_RQD_REPORT")) {
                                    HashMap map = new HashMap();
                                    loop0: while (true) {
                                        str2 = null;
                                        while (true) {
                                            strM4826a = m4826a(bufferedInputStream);
                                            if (strM4826a == null) {
                                                break loop0;
                                            }
                                            if (str2 == null) {
                                                str2 = strM4826a;
                                            }
                                        }
                                        map.put(str2, strM4826a);
                                    }
                                    if (str2 != null) {
                                        C2029al.m4646e("record not pair! drop! %s", str2);
                                        try {
                                            bufferedInputStream.close();
                                        } catch (IOException e5) {
                                            e5.printStackTrace();
                                        }
                                        return null;
                                    }
                                    CrashDetailBean crashDetailBeanM4824a = m4824a(context, map, nativeExceptionHandler);
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e10) {
                                        e10.printStackTrace();
                                    }
                                    return crashDetailBeanM4824a;
                                }
                                C2029al.m4646e("record read fail! %s", strM4826a2);
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e11) {
                                    e11.printStackTrace();
                                }
                                return null;
                            } catch (IOException e12) {
                                e = e12;
                                e.printStackTrace();
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e13) {
                                        e13.printStackTrace();
                                    }
                                }
                                return null;
                            }
                        } catch (IOException e14) {
                            e = e14;
                            bufferedInputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            if (bufferedInputStream2 != 0) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e15) {
                                    e15.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = CanRead;
                }
            }
            return null;
        }
        C2029al.m4646e("get eup record file args error", new Object[0]);
        return null;
    }

    public static void m4836c(String str) {
        File[] fileArrListFiles;
        if (str == null) {
            return;
        }
        try {
            File file = new File(str);
            if (file.canRead() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.canRead() && file2.canWrite() && file2.length() == 0) {
                        file2.delete();
                        C2029al.m4644c("Delete empty record file %s", file2.getAbsoluteFile());
                    }
                }
            }
        } catch (Throwable th) {
            C2029al.m4641a(th);
        }
    }

    public static String m4833b(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str, "backup_record.txt");
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    private static long m4832b(Map<String, String> map) {
        String str = map.get("launchTime");
        if (str == null) {
            return -1L;
        }
        C2029al.m4644c("[Native record info] launchTime: %s", str);
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e5) {
            if (C2029al.m4641a(e5)) {
                return -1L;
            }
            e5.printStackTrace();
            return -1L;
        }
    }

    public static String m4829a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String strM4834b = m4834b(str, str2);
        if (strM4834b != null && !strM4834b.isEmpty()) {
            sb.append("Register infos:\n");
            sb.append(strM4834b);
        }
        String strM4835c = m4835c(str, str2);
        if (strM4835c != null && !strM4835c.isEmpty()) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append("System SO infos:\n");
            sb.append(strM4835c);
        }
        return sb.toString();
    }

    public static void m4831a(boolean z7, String str) {
        if (str != null) {
            f7462a.add(new File(str, "rqd_record.eup"));
            f7462a.add(new File(str, "reg_record.txt"));
            f7462a.add(new File(str, "map_record.txt"));
            f7462a.add(new File(str, "backup_record.txt"));
            if (z7) {
                m4836c(str);
            }
        }
        List<File> list = f7462a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (File file : f7462a) {
            if (file.exists() && file.canWrite()) {
                file.delete();
                C2029al.m4644c("Delete record file %s", file.getAbsoluteFile());
            }
        }
    }

    public static String m4828a(String str, int i6, String str2, boolean z7) {
        BufferedReader bufferedReader = null;
        if (str != null && i6 > 0) {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                C2029al.m4640a("Read system log from native record file(length: %s bytes): %s", Long.valueOf(file.length()), file.getAbsolutePath());
                f7462a.add(file);
                C2029al.m4644c("Add this record file to list for cleaning lastly.", new Object[0]);
                if (str2 == null) {
                    return C2033ap.m4678a(new File(str), i6, z7);
                }
                String sb = new StringBuilder();
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
                        while (true) {
                            try {
                                String line = bufferedReader2.readLine();
                                if (line == null) {
                                    break;
                                }
                                if (Pattern.compile(str2 + "[ ]*:").matcher(line).find()) {
                                    sb.append(line);
                                    sb.append("\n");
                                }
                                if (i6 > 0 && sb.length() > i6) {
                                    if (z7) {
                                        sb.delete(i6, sb.length());
                                        break;
                                    }
                                    sb.delete(0, sb.length() - i6);
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                try {
                                    C2029al.m4641a(th);
                                    sb.append("\n[error:" + th.toString() + "]");
                                    String string = sb.toString();
                                    if (bufferedReader == null) {
                                        return string;
                                    }
                                    bufferedReader.close();
                                    sb = string;
                                } catch (Throwable th2) {
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception e5) {
                                            C2029al.m4641a(e5);
                                        }
                                    }
                                    throw th2;
                                }
                            }
                        }
                        String string2 = sb.toString();
                        bufferedReader2.close();
                        sb = string2;
                    } catch (Exception e10) {
                        C2029al.m4641a(e10);
                        return sb;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
                return sb;
            }
        }
        return null;
    }

    private static Map<String, String> m4830a(Map<String, String> map) {
        String str = map.get("key-value");
        if (str == null) {
            return null;
        }
        HashMap map2 = new HashMap();
        for (String str2 : str.split("\n")) {
            String[] strArrSplit = str2.split("=");
            if (strArrSplit.length == 2) {
                map2.put(strArrSplit[0], strArrSplit[1]);
            }
        }
        return map2;
    }

    private static CrashDetailBean m4824a(Context context, Map<String, String> map, NativeExceptionHandler nativeExceptionHandler) {
        String str;
        String str2;
        boolean zEqualsIgnoreCase;
        if (C2018aa.m4507a(context) == null) {
            C2029al.m4646e("abnormal com info not created", new Object[0]);
        } else {
            String str3 = map.get("intStateStr");
            if (str3 != null && str3.trim().length() > 0) {
                Map<String, Integer> mapM4837d = m4837d(map.get("intStateStr"));
                if (mapM4837d == null) {
                    C2029al.m4646e("parse intSateMap fail", Integer.valueOf(map.size()));
                    return null;
                }
                try {
                    mapM4837d.get("sino").getClass();
                    mapM4837d.get("sud").getClass();
                    String str4 = map.get("soVersion");
                    if (!TextUtils.isEmpty(str4)) {
                        String str5 = (String) m4825a(map, "codeMsg", "unknown");
                        String str6 = (String) m4825a(map, "signalName", "unknown");
                        map.get("errnoMsg");
                        String str7 = (String) m4825a(map, "stack", "unknown");
                        String str8 = map.get("jstack");
                        if (str8 != null) {
                            str7 = str7 + "java:\n" + str8;
                        }
                        Integer num = mapM4837d.get("sico");
                        if (num == null || num.intValue() <= 0) {
                            str = str5;
                            str2 = str6;
                        } else {
                            str2 = str6 + "(" + str5 + ")";
                            str = "KERNEL";
                        }
                        String str9 = map.get("nativeLog");
                        byte[] bArrM4693a = (str9 == null || str9.isEmpty()) ? null : C2033ap.m4693a(str9, "BuglyNativeLog.txt");
                        String str10 = (String) m4825a(map, "sendingProcess", "unknown");
                        Integer num2 = mapM4837d.get("spd");
                        if (num2 != null) {
                            str10 = str10 + "(" + num2 + ")";
                        }
                        String str11 = str10;
                        String str12 = (String) m4825a(map, "threadName", "unknown");
                        Integer num3 = mapM4837d.get("et");
                        if (num3 != null) {
                            str12 = str12 + "(" + num3 + ")";
                        }
                        String str13 = str12;
                        String str14 = (String) m4825a(map, "processName", "unknown");
                        Integer num4 = mapM4837d.get("ep");
                        if (num4 != null) {
                            str14 = str14 + "(" + num4 + ")";
                        }
                        CrashDetailBean crashDetailBeanPackageCrashDatas = nativeExceptionHandler.packageCrashDatas(str14, str13, (((long) mapM4837d.get("ets").intValue()) * 1000) + (((long) mapM4837d.get("etms").intValue()) / 1000), str2, (String) m4825a(map, "errorAddr", "unknown"), m4827a(str7), str, str11, (String) m4825a(map, "tombPath", "unknown"), map.get("sysLogPath"), map.get("jniLogPath"), str4, bArrM4693a, m4830a(map), false, false);
                        if (crashDetailBeanPackageCrashDatas != null) {
                            String str15 = (String) m4825a(map, "userId", crashDetailBeanPackageCrashDatas.f7131m);
                            crashDetailBeanPackageCrashDatas.f7131m = str15;
                            C2029al.m4644c("[Native record info] userId: %s", str15);
                            String str16 = (String) m4825a(map, "sysLog", crashDetailBeanPackageCrashDatas.f7141w);
                            crashDetailBeanPackageCrashDatas.f7141w = str16;
                            String str17 = (String) m4825a(map, "appVersion", str16);
                            crashDetailBeanPackageCrashDatas.f7124f = str17;
                            C2029al.m4644c("[Native record info] appVersion: %s", str17);
                            String str18 = map.get("isAppForeground");
                            if (str18 != null) {
                                C2029al.m4644c("[Native record info] isAppForeground: %s", str18);
                                zEqualsIgnoreCase = str18.equalsIgnoreCase("true");
                            } else {
                                zEqualsIgnoreCase = false;
                            }
                            crashDetailBeanPackageCrashDatas.f7109R = zEqualsIgnoreCase;
                            crashDetailBeanPackageCrashDatas.f7108Q = m4832b(map);
                            crashDetailBeanPackageCrashDatas.f7144z = null;
                            crashDetailBeanPackageCrashDatas.f7129k = true;
                        }
                        return crashDetailBeanPackageCrashDatas;
                    }
                    C2029al.m4646e("error format at version", new Object[0]);
                    return null;
                } catch (Throwable th) {
                    C2029al.m4646e("error format", new Object[0]);
                    th.printStackTrace();
                    return null;
                }
            }
            C2029al.m4646e("no intStateStr", new Object[0]);
        }
        return null;
    }
}

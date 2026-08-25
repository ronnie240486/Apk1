package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import p055ea.AbstractC2460q;

public final class C2033ap {

    private static Map<String, String> f7340a;

    public static String m4681a(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.getBuffer().toString();
        } catch (Throwable th2) {
            if (C2029al.m4641a(th2)) {
                return "fail";
            }
            th2.printStackTrace();
            return "fail";
        }
    }

    public static byte[] m4704b(byte[] bArr) {
        if (bArr == null) {
            return bArr;
        }
        C2029al.m4644c("[Util] Unzip %d bytes data with type %s", Integer.valueOf(bArr.length), "Gzip");
        try {
            return C2053bh.m4848a().mo4850b(bArr);
        } catch (Throwable th) {
            if (th.getMessage() != null && th.getMessage().contains("Not in GZIP format")) {
                C2029al.m4645d(th.getMessage(), new Object[0]);
                return null;
            }
            if (C2029al.m4641a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static String m4705c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "NULL";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            if (bArrDigest == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b8 : bArrDigest) {
                String hexString = Integer.toHexString(b8 & 255);
                if (hexString.length() == 1) {
                    stringBuffer.append(SessionDescription.SUPPORTED_SDP_VERSION);
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString().toUpperCase();
        } catch (Throwable th) {
            if (C2029al.m4641a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static long m4709d(byte[] bArr) {
        if (bArr == null) {
            return -1L;
        }
        try {
            return Long.parseLong(new String(bArr, "utf-8"));
        } catch (UnsupportedEncodingException e5) {
            e5.printStackTrace();
            return -1L;
        }
    }

    public static boolean m4711d(String str) {
        if (m4703b(str)) {
            return false;
        }
        if (str.length() > 255) {
            C2029al.m4640a("URL(%s)'s length is larger than 255.", str);
            return false;
        }
        if (str.toLowerCase().startsWith("http")) {
            return true;
        }
        C2029al.m4640a("URL(%s) is not start with \"http\".", str);
        return false;
    }

    public static String m4675a() {
        return m4677a(System.currentTimeMillis());
    }

    public static long m4695b() {
        try {
            return (((System.currentTimeMillis() + ((long) TimeZone.getDefault().getRawOffset())) / 86400000) * 86400000) - ((long) TimeZone.getDefault().getRawOffset());
        } catch (Throwable th) {
            if (C2029al.m4641a(th)) {
                return -1L;
            }
            th.printStackTrace();
            return -1L;
        }
    }

    public static String m4710d(String str, String str2) {
        if (C2018aa.m4509b() != null && C2018aa.m4509b().f7190O != null) {
            return C2018aa.m4509b().f7190O.getString(str, str2);
        }
        return "";
    }

    public static String m4677a(long j10) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(j10));
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    public static String m4682a(Date date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(date);
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    private static boolean m4702b(File file, File file2) {
        if (file != null && file2 != null && !file.equals(file2)) {
            if (file.exists() && file.canRead()) {
                try {
                    if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                } catch (Throwable th) {
                    if (!C2029al.m4641a(th)) {
                        th.printStackTrace();
                    }
                }
                return file2.exists() && file2.canWrite();
            }
            C2029al.m4645d("rqdp{  !sFile.exists() || !sFile.canRead(),pls check ,return!}", new Object[0]);
            return false;
        }
        C2029al.m4645d("rqdp{  err ZF 1R!}", new Object[0]);
        return false;
    }

    public static byte[] m4693a(String str, String str2) {
        ZipOutputStream zipOutputStream;
        if (str == null || str.length() == 0) {
            return null;
        }
        C2029al.m4644c("rqdp{  ZF start}", new Object[0]);
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
            try {
                zipOutputStream.setMethod(8);
                zipOutputStream.putNextEntry(new ZipEntry(str2));
                byte[] bArr = new byte[1024];
                while (true) {
                    int i6 = byteArrayInputStream.read(bArr);
                    if (i6 <= 0) {
                        break;
                    }
                    zipOutputStream.write(bArr, 0, i6);
                }
                zipOutputStream.closeEntry();
                zipOutputStream.flush();
                zipOutputStream.finish();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    zipOutputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                C2029al.m4644c("rqdp{  ZF end}", new Object[0]);
                return byteArray;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!C2029al.m4641a(th)) {
                        th.printStackTrace();
                    }
                    if (zipOutputStream != null) {
                        try {
                            zipOutputStream.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    C2029al.m4644c("rqdp{  ZF end}", new Object[0]);
                    return null;
                } catch (Throwable th2) {
                    if (zipOutputStream != null) {
                        try {
                            zipOutputStream.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                    }
                    C2029al.m4644c("rqdp{  ZF end}", new Object[0]);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            zipOutputStream = null;
        }
    }

    public static void m4706c(String str) {
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (file.isFile() && file.exists() && file.canWrite()) {
            file.delete();
        }
    }

    public static byte[] m4708c(long j10) {
        try {
            return String.valueOf(j10).getBytes("utf-8");
        } catch (UnsupportedEncodingException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public static void m4707c(String str, String str2) {
        if (C2018aa.m4509b() == null || C2018aa.m4509b().f7190O == null) {
            return;
        }
        C2018aa.m4509b().f7190O.edit().putString(str, str2).apply();
    }

    public static void m4699b(long j10) {
        try {
            Thread.sleep(j10);
        } catch (InterruptedException e5) {
            e5.printStackTrace();
        }
    }

    public static boolean m4703b(String str) {
        return str == null || str.trim().length() <= 0;
    }

    public static String m4697b(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static void m4700b(Parcel parcel, Map<String, String> map) {
        if (map != null && map.size() > 0) {
            int size = map.size();
            ArrayList<String> arrayList = new ArrayList<>(size);
            ArrayList<String> arrayList2 = new ArrayList<>(size);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(entry.getKey());
                arrayList2.add(entry.getValue());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("keys", arrayList);
            bundle.putStringArrayList("values", arrayList2);
            parcel.writeBundle(bundle);
            return;
        }
        parcel.writeBundle(null);
    }

    public static byte[] m4694a(byte[] bArr) {
        if (bArr == null) {
            return bArr;
        }
        C2029al.m4644c("[Util] Zip %d bytes data with type %s", Integer.valueOf(bArr.length), "Gzip");
        try {
            return C2053bh.m4848a().mo4849a(bArr);
        } catch (Throwable th) {
            if (C2029al.m4641a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static Map<String, String> m4698b(Parcel parcel) {
        Bundle bundle = parcel.readBundle();
        HashMap map = null;
        if (bundle == null) {
            return null;
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList("keys");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("values");
        if (stringArrayList != null && stringArrayList2 != null && stringArrayList.size() == stringArrayList2.size()) {
            map = new HashMap(stringArrayList.size());
            for (int i6 = 0; i6 < stringArrayList.size(); i6++) {
                map.put(stringArrayList.get(i6), stringArrayList2.get(i6));
            }
        } else {
            C2029al.m4646e("map parcel error!", new Object[0]);
        }
        return map;
    }

    public static boolean m4690a(File file, File file2) {
        ZipOutputStream zipOutputStream;
        C2029al.m4644c("rqdp{  ZF start}", new Object[0]);
        if (!m4702b(file, file2)) {
            return false;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file2)));
                try {
                    zipOutputStream.setMethod(8);
                    zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                    byte[] bArr = new byte[Math.max(5000, 1000)];
                    while (true) {
                        int i6 = fileInputStream2.read(bArr);
                        if (i6 <= 0) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, i6);
                    }
                    zipOutputStream.flush();
                    zipOutputStream.closeEntry();
                    try {
                        fileInputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    try {
                        zipOutputStream.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                    C2029al.m4644c("rqdp{  ZF end}", new Object[0]);
                    return true;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    try {
                        if (!C2029al.m4641a(th)) {
                            th.printStackTrace();
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e11) {
                                e11.printStackTrace();
                            }
                        }
                        if (zipOutputStream != null) {
                            try {
                                zipOutputStream.close();
                            } catch (IOException e12) {
                                e12.printStackTrace();
                            }
                        }
                        C2029al.m4644c("rqdp{  ZF end}", new Object[0]);
                        return false;
                    } catch (Throwable th2) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e13) {
                                e13.printStackTrace();
                            }
                        }
                        if (zipOutputStream != null) {
                            try {
                                zipOutputStream.close();
                            } catch (IOException e14) {
                                e14.printStackTrace();
                            }
                        }
                        C2029al.m4644c("rqdp{  ZF end}", new Object[0]);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                zipOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            zipOutputStream = null;
        }
    }

    public static boolean m4701b(Context context, String str) {
        C2029al.m4644c("[Util] Try to unlock file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (!file.exists()) {
                return true;
            }
            if (!file.delete()) {
                return false;
            }
            C2029al.m4644c("[Util] Successfully unlocked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return true;
        } catch (Throwable th) {
            C2029al.m4641a(th);
            return false;
        }
    }

    public static BufferedReader m4696b(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            File file = new File(str, str2);
            if (file.exists() && file.canRead()) {
                return m4672a(file);
            }
            return null;
        } catch (NullPointerException e5) {
            C2029al.m4641a(e5);
            return null;
        }
    }

    public static String m4679a(String str) {
        if (str.trim().equals("")) {
            return "";
        }
        try {
            if (f7340a == null) {
                f7340a = new HashMap();
            }
            if (f7340a.containsKey(str)) {
                return f7340a.get(str);
            }
            String systemProperty = NativeCrashHandler.getInstance().getSystemProperty(str);
            if (!TextUtils.isEmpty(systemProperty) && !systemProperty.equals("fail")) {
                f7340a.put(str, systemProperty);
            }
            return systemProperty;
        } catch (Throwable th) {
            C2029al.m4643b(th);
            return "fail";
        }
    }

    public static Context m4670a(Context context) {
        Context applicationContext;
        return (context == null || (applicationContext = context.getApplicationContext()) == null) ? context : applicationContext;
    }

    public static void m4688a(Class<?> cls, String str, Object obj) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(null, obj);
        } catch (Exception unused) {
        }
    }

    public static Object m4673a(String str, String str2, Class<?>[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void m4687a(Parcel parcel, Map<String, PlugInBean> map) {
        if (map != null && map.size() > 0) {
            int size = map.size();
            ArrayList arrayList = new ArrayList(size);
            ArrayList arrayList2 = new ArrayList(size);
            for (Map.Entry<String, PlugInBean> entry : map.entrySet()) {
                arrayList.add(entry.getKey());
                arrayList2.add(entry.getValue());
            }
            Bundle bundle = new Bundle();
            bundle.putInt("pluginNum", arrayList.size());
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                bundle.putString("pluginKey".concat(String.valueOf(i6)), (String) arrayList.get(i6));
            }
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                bundle.putString(AbstractC2460q.m5492f(i10, "pluginVal", "plugInId"), ((PlugInBean) arrayList2.get(i10)).f7066a);
                bundle.putString("pluginVal" + i10 + "plugInUUID", ((PlugInBean) arrayList2.get(i10)).f7068c);
                bundle.putString("pluginVal" + i10 + "plugInVersion", ((PlugInBean) arrayList2.get(i10)).f7067b);
            }
            parcel.writeBundle(bundle);
            return;
        }
        parcel.writeBundle(null);
    }

    public static Map<String, PlugInBean> m4685a(Parcel parcel) {
        Bundle bundle = parcel.readBundle();
        HashMap map = null;
        if (bundle == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int iIntValue = ((Integer) bundle.get("pluginNum")).intValue();
        for (int i6 = 0; i6 < iIntValue; i6++) {
            arrayList.add(bundle.getString("pluginKey".concat(String.valueOf(i6))));
        }
        for (int i10 = 0; i10 < iIntValue; i10++) {
            arrayList2.add(new PlugInBean(bundle.getString("pluginVal" + i10 + "plugInId"), bundle.getString("pluginVal" + i10 + "plugInVersion"), bundle.getString("pluginVal" + i10 + "plugInUUID")));
        }
        if (arrayList.size() == arrayList2.size()) {
            map = new HashMap(arrayList.size());
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                map.put(arrayList.get(i11), PlugInBean.class.cast(arrayList2.get(i11)));
            }
        } else {
            C2029al.m4646e("map plugin parcel error!", new Object[0]);
        }
        return map;
    }

    public static byte[] m4692a(Parcelable parcelable) {
        Parcel parcelObtain = Parcel.obtain();
        parcelable.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }

    public static String m4676a(int i6, String str) {
        String[] strArr;
        if (str == null) {
            strArr = new String[]{"logcat", "-d", "-v", "threadtime"};
        } else {
            strArr = new String[]{"logcat", "-d", "-v", "threadtime", "-s", str};
        }
        StringBuilder sb = new StringBuilder();
        Process processExec = null;
        try {
            processExec = Runtime.getRuntime().exec(strArr);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
                sb.append("\n");
                if (i6 > 0 && sb.length() > i6) {
                    sb.delete(0, sb.length() - i6);
                }
            }
            String string = sb.toString();
            try {
                processExec.getOutputStream().close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            try {
                processExec.getInputStream().close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            try {
                processExec.getErrorStream().close();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
            return string;
        } catch (Throwable th) {
            try {
                if (!C2029al.m4641a(th)) {
                    th.printStackTrace();
                }
                sb.append("\n[error:");
                sb.append(th.toString());
                sb.append("]");
                return sb.toString();
            } finally {
                if (processExec != null) {
                    try {
                        processExec.getOutputStream().close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                    try {
                        processExec.getInputStream().close();
                    } catch (IOException e13) {
                        e13.printStackTrace();
                    }
                    try {
                        processExec.getErrorStream().close();
                    } catch (IOException e14) {
                        e14.printStackTrace();
                    }
                }
            }
        }
    }

    public static Map<String, String> m4686a(boolean z7, int i6) {
        if (!z7) {
            C2029al.m4644c("get all thread stack not enable", new Object[0]);
            return new HashMap();
        }
        Map<String, String> mapM4684a = m4684a(i6);
        return mapM4684a == null ? new HashMap() : mapM4684a;
    }

    private static Map<String, String> m4684a(int i6) {
        HashMap map = new HashMap(12);
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces == null) {
            return null;
        }
        Thread thread = Looper.getMainLooper().getThread();
        if (!allStackTraces.containsKey(thread)) {
            allStackTraces.put(thread, thread.getStackTrace());
        }
        Thread.currentThread().getId();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
            sb.setLength(0);
            if (entry.getValue() != null && entry.getValue().length != 0) {
                for (StackTraceElement stackTraceElement : entry.getValue()) {
                    if (i6 > 0 && sb.length() >= i6) {
                        sb.append("\n[Stack over limit size :" + i6 + " , has been cut!]");
                        break;
                    }
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
                map.put(entry.getKey().getName() + "(" + entry.getKey().getId() + ")", sb.toString());
            }
        }
        return map;
    }

    public static String m4680a(Thread thread) {
        if (thread == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : thread.getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static boolean m4689a(Context context, String str) {
        C2029al.m4644c("[Util] Try to lock file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (file.exists()) {
                if (System.currentTimeMillis() - file.lastModified() < Renderer.DEFAULT_DURATION_TO_PROGRESS_US) {
                    return false;
                }
                C2029al.m4644c("[Util] Lock file (%s) is expired, unlock it.", str);
                m4701b(context, str);
            }
            if (file.createNewFile()) {
                C2029al.m4644c("[Util] Successfully locked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                return true;
            }
            C2029al.m4644c("[Util] Failed to locked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return false;
        } catch (Throwable th) {
            C2029al.m4641a(th);
            return false;
        }
    }

    public static String m4678a(File file, int i6, boolean z7) {
        BufferedReader bufferedReader;
        if (file == null || !file.exists() || !file.canRead()) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                    sb.append("\n");
                    if (i6 > 0 && sb.length() > i6) {
                        if (z7) {
                            sb.delete(i6, sb.length());
                            break;
                        }
                        sb.delete(0, sb.length() - i6);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        C2029al.m4641a(th);
                        return null;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e5) {
                                C2029al.m4641a(e5);
                            }
                        }
                    }
                }
            }
            String string = sb.toString();
            try {
                bufferedReader.close();
            } catch (Exception e10) {
                C2029al.m4641a(e10);
            }
            return string;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    public static BufferedReader m4672a(File file) {
        if (file.exists() && file.canRead()) {
            try {
                return new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            } catch (Throwable th) {
                C2029al.m4641a(th);
            }
        }
        return null;
    }

    public static Thread m4683a(Runnable runnable, String str) {
        try {
            Thread thread = new Thread(runnable);
            thread.setName(str);
            thread.start();
            return thread;
        } catch (Throwable th) {
            C2029al.m4646e("[Util] Failed to start a thread to execute task with message: %s", th.getMessage());
            return null;
        }
    }

    public static boolean m4691a(Runnable runnable) {
        C2028ak c2028akM4631a = C2028ak.m4631a();
        if (c2028akM4631a != null) {
            return c2028akM4631a.m4633a(runnable);
        }
        String[] strArrSplit = runnable.getClass().getName().split("\\.");
        return m4683a(runnable, strArrSplit[strArrSplit.length - 1]) != null;
    }

    public static SharedPreferences m4671a(String str, Context context) {
        if (context != null) {
            return context.getSharedPreferences(str, 0);
        }
        return null;
    }

    public static <T> T m4674a(byte[] bArr, Parcelable.Creator<T> creator) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        try {
            T tCreateFromParcel = creator.createFromParcel(parcelObtain);
            parcelObtain.recycle();
            return tCreateFromParcel;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return null;
            } finally {
                parcelObtain.recycle();
            }
        }
    }
}

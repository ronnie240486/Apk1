package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.C2029al;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TraceFileHelper {

    public static class C2010a {

        public long f7145a;

        public String f7146b;

        public long f7147c;

        public Map<String, String[]> f7148d;
    }

    public interface InterfaceC2011b {
        boolean mo4484a(long j10);

        boolean mo4485a(long j10, long j11, String str);

        boolean mo4486a(String str, int i6, String str2, String str3);
    }

    private static Object[] m4482a(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return null;
            }
            for (Pattern pattern : patternArr) {
                if (pattern.matcher(line).matches()) {
                    return new Object[]{pattern, line};
                }
            }
        }
    }

    private static String m4483b(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null || line.trim().length() <= 0) {
                break;
            }
            stringBuffer.append(line.concat("\n"));
        }
        return stringBuffer.toString();
    }

    public static C2010a readFirstDumpInfo(String str, boolean z7) throws Throwable {
        if (str == null) {
            C2029al.m4646e("path:%s", str);
            return null;
        }
        C2010a c2010a = new C2010a();
        readTraceFile(str, new C2013b(c2010a, z7));
        if (c2010a.f7145a > 0 && c2010a.f7147c > 0 && c2010a.f7146b != null) {
            return c2010a;
        }
        C2029al.m4646e("first dump error %s", c2010a.f7145a + " " + c2010a.f7147c + " " + c2010a.f7146b);
        return null;
    }

    public static C2010a readTargetDumpInfo(String str, String str2, boolean z7) {
        if (str != null && str2 != null) {
            C2010a c2010a = new C2010a();
            readTraceFile(str2, new C2012a(c2010a, str, z7));
            if (c2010a.f7145a > 0 && c2010a.f7147c > 0 && c2010a.f7146b != null) {
                return c2010a;
            }
        }
        return null;
    }

    public static void readTraceFile(String str, InterfaceC2011b interfaceC2011b) throws Throwable {
        Throwable th;
        int i6 = 0;
        if (str == null || interfaceC2011b == null) {
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        file.lastModified();
        file.length();
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                try {
                    Pattern patternCompile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                    Pattern patternCompile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                    Pattern patternCompile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                    Pattern patternCompile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                    while (true) {
                        Pattern[] patternArr = new Pattern[1];
                        patternArr[i6] = patternCompile;
                        Object[] objArrM4482a = m4482a(bufferedReader2, patternArr);
                        if (objArrM4482a == null) {
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (IOException e5) {
                                if (C2029al.m4641a(e5)) {
                                    return;
                                }
                                e5.printStackTrace();
                                return;
                            }
                        }
                        Pattern[] patternArr2 = new Pattern[1];
                        patternArr2[i6] = patternCompile3;
                        Object[] objArrM4482a2 = m4482a(bufferedReader2, patternArr2);
                        if (objArrM4482a2 == null) {
                            C2029al.m4645d("Failed to find process name.", new Object[i6]);
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (IOException e10) {
                                if (C2029al.m4641a(e10)) {
                                    return;
                                }
                                e10.printStackTrace();
                                return;
                            }
                        }
                        String[] strArrSplit = objArrM4482a[1].toString().split("\\s");
                        long j10 = Long.parseLong(strArrSplit[2]);
                        long time = simpleDateFormat.parse(strArrSplit[4] + " " + strArrSplit[5]).getTime();
                        Matcher matcher = patternCompile3.matcher(objArrM4482a2[1].toString());
                        matcher.find();
                        matcher.group(1);
                        SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
                        if (!interfaceC2011b.mo4485a(j10, time, matcher.group(1))) {
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (IOException e11) {
                                if (C2029al.m4641a(e11)) {
                                    return;
                                }
                                e11.printStackTrace();
                                return;
                            }
                        }
                        while (true) {
                            Object[] objArrM4482a3 = m4482a(bufferedReader2, patternCompile4, patternCompile2);
                            if (objArrM4482a3 != null) {
                                if (objArrM4482a3[0] != patternCompile4) {
                                    if (interfaceC2011b.mo4484a(Long.parseLong(objArrM4482a3[1].toString().split("\\s")[2]))) {
                                        break;
                                    }
                                    try {
                                        bufferedReader2.close();
                                        return;
                                    } catch (IOException e12) {
                                        if (C2029al.m4641a(e12)) {
                                            return;
                                        }
                                        e12.printStackTrace();
                                        return;
                                    }
                                }
                                String string = objArrM4482a3[1].toString();
                                Matcher matcher2 = Pattern.compile("\".+\"").matcher(string);
                                matcher2.find();
                                String strGroup = matcher2.group();
                                String strSubstring = strGroup.substring(1, strGroup.length() - 1);
                                string.contains("NATIVE");
                                Matcher matcher3 = Pattern.compile("tid=\\d+").matcher(string);
                                matcher3.find();
                                String strGroup2 = matcher3.group();
                                interfaceC2011b.mo4486a(strSubstring, Integer.parseInt(strGroup2.substring(strGroup2.indexOf("=") + 1)), m4481a(bufferedReader2), m4483b(bufferedReader2));
                            } else {
                                break;
                            }
                        }
                        simpleDateFormat = simpleDateFormat2;
                        i6 = 0;
                    }
                } catch (Exception e13) {
                    e = e13;
                    bufferedReader = bufferedReader2;
                    if (!C2029al.m4641a(e)) {
                        e.printStackTrace();
                    }
                    C2029al.m4645d("trace open fail:%s : %s", e.getClass().getName(), e.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e14) {
                            if (C2029al.m4641a(e14)) {
                                return;
                            }
                            e14.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader == null) {
                        throw th;
                    }
                    try {
                        bufferedReader.close();
                        throw th;
                    } catch (IOException e15) {
                        if (C2029al.m4641a(e15)) {
                            throw th;
                        }
                        e15.printStackTrace();
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e16) {
            e = e16;
        }
    }

    private static String m4481a(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i6 = 0; i6 < 3; i6++) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return null;
            }
            stringBuffer.append(line.concat("\n"));
        }
        return stringBuffer.toString();
    }
}

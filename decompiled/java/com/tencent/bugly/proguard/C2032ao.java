package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class C2032ao {

    public static boolean f7318a = true;

    public static boolean f7319b = true;

    private static SimpleDateFormat f7320c = null;

    private static int f7321d = 30720;

    private static StringBuilder f7322e;

    private static StringBuilder f7323f;

    private static boolean f7324g;

    private static a f7325h;

    private static String f7326i;

    private static String f7327j;

    private static Context f7328k;

    private static String f7329l;

    private static boolean f7330m;

    private static boolean f7331n;

    private static ExecutorService f7332o;

    private static int f7333p;

    private static final Object f7334q = new Object();

    static {
        try {
            f7320c = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable th) {
            C2029al.m4643b(th.getCause());
        }
    }

    public static synchronized void m4656a(Context context) {
        if (f7330m || context == null || !f7319b) {
            return;
        }
        try {
            f7332o = Executors.newSingleThreadExecutor();
            f7323f = new StringBuilder(0);
            f7322e = new StringBuilder(0);
            f7328k = context;
            f7326i = C2018aa.m4507a(context).f7228d;
            f7327j = "";
            f7329l = f7328k.getFilesDir().getPath() + "/buglylog_" + f7326i + "_" + f7327j + ".txt";
            f7333p = Process.myPid();
        } catch (Throwable unused) {
        }
        f7330m = true;
    }

    public static boolean m4664d(String str, String str2, String str3) {
        InterfaceC2096q interfaceC2096q;
        try {
            C2018aa c2018aaM4509b = C2018aa.m4509b();
            if (c2018aaM4509b == null || (interfaceC2096q = c2018aaM4509b.f7189N) == null) {
                return false;
            }
            return interfaceC2096q.appendLogToNative(str, str2, str3);
        } catch (Throwable th) {
            if (C2029al.m4641a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    public static synchronized void m4665e(String str, String str2, String str3) {
        if (f7318a) {
            m4666f(str, str2, str3);
        } else {
            m4667g(str, str2, str3);
        }
    }

    private static synchronized void m4666f(String str, String str2, String str3) {
        String strM4654a = m4654a(str, str2, str3, Process.myTid());
        synchronized (f7334q) {
            try {
                f7323f.append(strM4654a);
                if (f7323f.length() >= f7321d) {
                    StringBuilder sb = f7323f;
                    f7323f = sb.delete(0, sb.indexOf("\u0001\r\n") + 1);
                }
            } catch (Throwable th) {
                try {
                    if (!C2029al.m4643b(th)) {
                        th.printStackTrace();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    private static synchronized void m4667g(String str, String str2, String str3) {
        String strM4654a = m4654a(str, str2, str3, Process.myTid());
        try {
            synchronized (f7334q) {
                try {
                    f7323f.append(strM4654a);
                    if (f7323f.length() <= f7321d) {
                        return;
                    }
                    if (f7324g) {
                        return;
                    }
                    f7324g = true;
                    a aVar = f7325h;
                    if (aVar == null) {
                        f7325h = new a(f7329l);
                    } else {
                        File file = aVar.f7336b;
                        if (file == null || file.length() + ((long) f7323f.length()) > f7325h.f7337c) {
                            f7325h.m4668a();
                        }
                    }
                    if (f7325h.m4669a(f7323f.toString())) {
                        f7323f.setLength(0);
                        f7324g = false;
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private static String m4660b() {
        InterfaceC2096q interfaceC2096q;
        try {
            C2018aa c2018aaM4509b = C2018aa.m4509b();
            if (c2018aaM4509b == null || (interfaceC2096q = c2018aaM4509b.f7189N) == null) {
                return null;
            }
            return interfaceC2096q.getLogFromNative();
        } catch (Throwable th) {
            if (C2029al.m4641a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    private static byte[] m4663c() {
        File file;
        if (!f7319b) {
            return null;
        }
        if (f7331n) {
            C2029al.m4640a("[LogUtil] Get user log from native.", new Object[0]);
            String strM4660b = m4660b();
            if (strM4660b != null) {
                C2029al.m4640a("[LogUtil] Got user log from native: %d bytes", Integer.valueOf(strM4660b.length()));
                return C2033ap.m4693a(strM4660b, "BuglyNativeLog.txt");
            }
        }
        StringBuilder sb = new StringBuilder();
        synchronized (f7334q) {
            try {
                a aVar = f7325h;
                if (aVar != null && aVar.f7335a && (file = aVar.f7336b) != null && file.length() > 0) {
                    sb.append(C2033ap.m4678a(f7325h.f7336b, 30720, true));
                }
                StringBuilder sb2 = f7323f;
                if (sb2 != null && sb2.length() > 0) {
                    sb.append(f7323f.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return C2033ap.m4693a(sb.toString(), "BuglyLog.txt");
    }

    public static class a {

        boolean f7335a;

        File f7336b;

        long f7337c = 30720;

        private String f7338d;

        private long f7339e;

        public a(String str) {
            if (str == null || str.equals("")) {
                return;
            }
            this.f7338d = str;
            this.f7335a = m4668a();
        }

        public final boolean m4668a() {
            try {
                File file = new File(this.f7338d);
                this.f7336b = file;
                if (file.exists() && !this.f7336b.delete()) {
                    this.f7335a = false;
                    return false;
                }
                if (this.f7336b.createNewFile()) {
                    return true;
                }
                this.f7335a = false;
                return false;
            } catch (Throwable th) {
                C2029al.m4641a(th);
                this.f7335a = false;
                return false;
            }
        }

        public final boolean m4669a(String str) {
            if (!this.f7335a) {
                return false;
            }
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(this.f7336b, true);
                try {
                    byte[] bytes = str.getBytes("UTF-8");
                    fileOutputStream2.write(bytes);
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    this.f7339e += (long) bytes.length;
                    this.f7335a = true;
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                    }
                    return true;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    try {
                        C2029al.m4641a(th);
                        this.f7335a = false;
                        return false;
                    } finally {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static void m4655a(int i6) {
        synchronized (f7334q) {
            try {
                f7321d = i6;
                if (i6 < 0) {
                    f7321d = 0;
                } else if (i6 > 30720) {
                    f7321d = 30720;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void m4658a(String str, String str2, Throwable th) {
        if (th == null) {
            return;
        }
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        m4657a(str, str2, message + '\n' + C2033ap.m4697b(th));
    }

    public static synchronized void m4657a(String str, String str2, String str3) {
        if (f7330m && f7319b) {
            try {
                if (f7331n) {
                    f7332o.execute(new RunnableC2073e0(0, str, str2, str3));
                } else {
                    f7332o.execute(new RunnableC2073e0(1, str, str2, str3));
                }
            } catch (Exception e5) {
                C2029al.m4643b(e5);
            }
        }
    }

    private static String m4654a(String str, String str2, String str3, long j10) {
        String string;
        f7322e.setLength(0);
        if (str3.length() > 30720) {
            str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = f7320c;
        if (simpleDateFormat != null) {
            string = simpleDateFormat.format(date);
        } else {
            string = date.toString();
        }
        StringBuilder sb = f7322e;
        sb.append(string);
        sb.append(" ");
        sb.append(f7333p);
        sb.append(" ");
        sb.append(j10);
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        sb.append(": ");
        sb.append(str3);
        sb.append("\u0001\r\n");
        return f7322e.toString();
    }

    public static byte[] m4659a() {
        if (f7318a) {
            if (f7319b) {
                return C2033ap.m4693a(f7323f.toString(), "BuglyLog.txt");
            }
            return null;
        }
        return m4663c();
    }
}

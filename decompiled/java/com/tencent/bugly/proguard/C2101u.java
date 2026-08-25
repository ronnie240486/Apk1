package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class C2101u {

    public static final long f7693a = System.currentTimeMillis();

    private static C2101u f7694b;

    private Context f7695c;

    private SharedPreferences f7698f;

    private Map<Integer, Map<String, C2100t>> f7697e = new HashMap();

    private String f7696d = C2018aa.m4509b().f7228d;

    private C2101u(Context context) {
        this.f7695c = context;
        this.f7698f = context.getSharedPreferences("crashrecord", 0);
    }

    public synchronized <T extends List<?>> T m5003d(int i6) {
        ObjectInputStream objectInputStream;
        try {
            File file = new File(this.f7695c.getDir("crashrecord", 0), String.valueOf(i6));
            ?? Exists = file.exists();
            try {
                if (Exists == 0) {
                    return null;
                }
                try {
                    objectInputStream = new ObjectInputStream(new FileInputStream(file));
                    try {
                        T t5 = (T) objectInputStream.readObject();
                        objectInputStream.close();
                        return t5;
                    } catch (IOException unused) {
                        C2029al.m4640a("open record file error", new Object[0]);
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        return null;
                    } catch (ClassNotFoundException unused2) {
                        C2029al.m4640a("get object error", new Object[0]);
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        return null;
                    }
                } catch (IOException unused3) {
                    objectInputStream = null;
                } catch (ClassNotFoundException unused4) {
                    objectInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    Exists = 0;
                    if (Exists != 0) {
                        Exists.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused5) {
            C2029al.m4646e("readCrashRecord error", new Object[0]);
        }
    }

    public synchronized boolean m5002c(int i6) {
        try {
            try {
                List<C2100t> listM5003d = m5003d(i6);
                if (listM5003d == null) {
                    return false;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (C2100t c2100t : listM5003d) {
                    String str = c2100t.f7687b;
                    if (str != null && str.equalsIgnoreCase(this.f7696d) && c2100t.f7689d > 0) {
                        arrayList.add(c2100t);
                    }
                    if (c2100t.f7688c + 86400000 < jCurrentTimeMillis) {
                        arrayList2.add(c2100t);
                    }
                }
                Collections.sort(arrayList);
                if (arrayList.size() < 2) {
                    listM5003d.removeAll(arrayList2);
                    m4995a(i6, listM5003d);
                    return false;
                }
                if (arrayList.size() <= 0 || ((C2100t) arrayList.get(arrayList.size() - 1)).f7688c + 86400000 >= jCurrentTimeMillis) {
                    return true;
                }
                listM5003d.clear();
                m4995a(i6, listM5003d);
                return false;
            } catch (Exception unused) {
                C2029al.m4646e("isFrequentCrash failed", new Object[0]);
                return false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean m5005b(int i6) {
        boolean z7;
        z7 = true;
        try {
            z7 = this.f7698f.getBoolean(i6 + "_" + this.f7696d, true);
            C2028ak.m4631a().m4633a(new RunnableC2095p0(this, i6, 1));
        } catch (Exception unused) {
            C2029al.m4646e("canInit error", new Object[0]);
            return z7;
        }
        return z7;
    }

    public static synchronized C2101u m4992a(Context context) {
        try {
            if (f7694b == null) {
                f7694b = new C2101u(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7694b;
    }

    public static synchronized C2101u m4991a() {
        return f7694b;
    }

    public static boolean m4999b(C2100t c2100t, C2100t c2100t2) {
        String str = c2100t.f7690e;
        if (str != null && !str.equalsIgnoreCase(c2100t2.f7690e)) {
            return true;
        }
        String str2 = c2100t.f7691f;
        return !(str2 == null || str2.equalsIgnoreCase(c2100t2.f7691f)) || c2100t.f7689d <= 0;
    }

    public final void m5004a(int i6) {
        C2028ak.m4631a().m4633a(new RunnableC2095p0(this, i6, 0));
    }

    public synchronized <T extends List<?>> void m4995a(int i6, T t5) {
        Throwable th;
        ObjectOutputStream objectOutputStream;
        IOException e5;
        if (t5 == null) {
            return;
        }
        try {
            ObjectOutputStream dir = this.f7695c.getDir("crashrecord", 0);
            try {
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File((File) dir, String.valueOf(i6))));
                    try {
                        objectOutputStream.writeObject(t5);
                        objectOutputStream.close();
                    } catch (IOException e10) {
                        e5 = e10;
                        e5.printStackTrace();
                        C2029al.m4640a("open record file error", new Object[0]);
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (dir != 0) {
                        dir.close();
                    }
                    throw th;
                }
            } catch (IOException e11) {
                objectOutputStream = null;
                e5 = e11;
            } catch (Throwable th3) {
                dir = 0;
                th = th3;
                if (dir != 0) {
                    dir.close();
                }
                throw th;
            }
        } catch (Exception unused) {
            C2029al.m4646e("writeCrashRecord error", new Object[0]);
        }
    }

    public static boolean m4997a(C2100t c2100t, C2100t c2100t2) {
        String str;
        return c2100t.f7692g == c2100t2.f7692g && (str = c2100t.f7687b) != null && str.equalsIgnoreCase(c2100t2.f7687b);
    }
}

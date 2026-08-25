package p044da;

import android.os.Process;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.HashMap;
import p156o9.AbstractC3281e;

public final class C2340c {

    public static final HashMap f8147c = new HashMap();

    public String f8148a;

    public C2339b f8149b;

    public static String m5305c() {
        return "_" + Process.myPid();
    }

    public final void m5306a() {
        C2339b c2339b = this.f8149b;
        c2339b.f8145e.clear();
        c2339b.f8141a.set(0L);
        File[] fileArrListFiles = c2339b.f8146f.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                file.delete();
            }
        }
    }

    public final Object m5307b(String str) {
        RandomAccessFile randomAccessFile;
        byte[] bArrM6621k;
        ObjectInputStream objectInputStream;
        Throwable th;
        ByteArrayInputStream byteArrayInputStream;
        RandomAccessFile randomAccessFile2 = null;
        try {
            File fileM5302b = this.f8149b.m5302b(str);
            if (fileM5302b.exists()) {
                randomAccessFile = new RandomAccessFile(fileM5302b, "r");
                try {
                    try {
                        int length = (int) randomAccessFile.length();
                        bArrM6621k = new byte[length];
                        randomAccessFile.read(bArrM6621k);
                        if (AbstractC3281e.m6631u(bArrM6621k)) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                            m5311g(str);
                            bArrM6621k = null;
                        } else {
                            if (AbstractC3281e.m6628r(bArrM6621k)) {
                                int i6 = 0;
                                while (true) {
                                    if (i6 >= length) {
                                        i6 = -1;
                                        break;
                                    }
                                    if (bArrM6621k[i6] == 32) {
                                        break;
                                    }
                                    i6++;
                                }
                                bArrM6621k = AbstractC3281e.m6621k(bArrM6621k, i6 + 1, length);
                            }
                            try {
                                randomAccessFile.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                    } catch (Exception e11) {
                        e = e11;
                        e.printStackTrace();
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException e12) {
                                e12.printStackTrace();
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile2 = randomAccessFile;
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (IOException e13) {
                            e13.printStackTrace();
                        }
                    }
                    throw th;
                }
            } else {
                bArrM6621k = null;
            }
        } catch (Exception e14) {
            e = e14;
            randomAccessFile = null;
        } catch (Throwable th3) {
            th = th3;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
        if (bArrM6621k == null) {
            return null;
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArrM6621k);
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    try {
                        Object object = objectInputStream.readObject();
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e15) {
                            e15.printStackTrace();
                        }
                        try {
                            objectInputStream.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                        return object;
                    } catch (Exception e17) {
                        e = e17;
                        e.printStackTrace();
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e19) {
                                e19.printStackTrace();
                            }
                        }
                        return null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e20) {
                            e20.printStackTrace();
                        }
                    }
                    if (objectInputStream != null) {
                        throw th;
                    }
                    try {
                        objectInputStream.close();
                        throw th;
                    } catch (IOException e21) {
                        e21.printStackTrace();
                        throw th;
                    }
                }
            } catch (Exception e22) {
                e = e22;
                objectInputStream = null;
            } catch (Throwable th5) {
                objectInputStream = null;
                th = th5;
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                if (objectInputStream != null) {
                    throw th;
                }
                objectInputStream.close();
                throw th;
            }
        } catch (Exception e23) {
            e = e23;
            byteArrayInputStream = null;
            objectInputStream = null;
        } catch (Throwable th6) {
            objectInputStream = null;
            th = th6;
            byteArrayInputStream = null;
        }
    }

    public final void m5308d(String str, Serializable serializable, int i6) throws Throwable {
        String str2 = this.f8148a;
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream2.writeObject(serializable);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (i6 != -1) {
                        m5310f(str, byteArray, i6);
                    } else {
                        m5309e(str, byteArray);
                    }
                    objectOutputStream2.close();
                } catch (Exception e5) {
                    e = e5;
                    objectOutputStream = objectOutputStream2;
                    e.printStackTrace();
                    objectOutputStream.close();
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    try {
                        objectOutputStream.close();
                    } catch (IOException e10) {
                        Log.e(str2, "Exception", e10);
                    }
                    throw th;
                }
            } catch (IOException e11) {
                Log.e(str2, "Exception", e11);
            }
        } catch (Exception e12) {
            e = e12;
        }
    }

    public final void m5309e(String str, byte[] bArr) throws Throwable {
        C2339b c2339b = this.f8149b;
        File fileM5303c = c2339b.m5303c(str);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(fileM5303c);
                try {
                    fileOutputStream2.write(bArr);
                    try {
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    } catch (IOException e5) {
                        e = e5;
                        e.printStackTrace();
                    }
                } catch (Exception e10) {
                    e = e10;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e11) {
                            e = e11;
                            e.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    C2339b.m5301a(c2339b, fileM5303c);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e13) {
            e = e13;
        }
        C2339b.m5301a(c2339b, fileM5303c);
    }

    public final void m5310f(String str, byte[] bArr, int i6) throws Throwable {
        byte[] bytes = AbstractC3281e.m6624n(i6).getBytes();
        byte[] bArr2 = new byte[bytes.length + bArr.length];
        System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
        System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
        m5309e(str, bArr2);
    }

    public final void m5311g(String str) {
        C2339b c2339b = this.f8149b;
        File fileM5302b = c2339b.m5302b(str);
        c2339b.f8145e.remove(fileM5302b);
        c2339b.f8141a.addAndGet(-fileM5302b.length());
        c2339b.f8142b.addAndGet(-1);
        fileM5302b.delete();
    }
}

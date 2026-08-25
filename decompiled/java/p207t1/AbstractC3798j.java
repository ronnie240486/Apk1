package p207t1;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.File;
import java.io.IOException;
import p173q1.C3406f0;
import p182r.AbstractC3574g;
import p182r.C3575h;

public abstract class AbstractC3798j {

    public static final C3575h f12789a = new C3575h();

    public static final Object f12790b = new Object();

    public static C3406f0 f12791c = null;

    public static long m7568a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? AbstractC3796h.m7565a(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static C3406f0 m7569b() {
        C3406f0 c3406f0 = new C3406f0(4);
        f12791c = c3406f0;
        C3575h c3575h = f12789a;
        c3575h.getClass();
        if (AbstractC3574g.f12041f.mo3513c(c3575h, null, c3406f0)) {
            AbstractC3574g.m7187b(c3575h);
        }
        return f12791c;
    }

    public static void m7570c(Context context, boolean z7) {
        C3797i c3797iM7566a;
        int i6;
        if (z7 || f12791c == null) {
            synchronized (f12790b) {
                if (!z7) {
                    try {
                        if (f12791c != null) {
                            return;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 28 && i10 != 30) {
                    File file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                    long length = file.length();
                    int i11 = 0;
                    boolean z10 = file.exists() && length > 0;
                    File file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                    long length2 = file2.length();
                    boolean z11 = file2.exists() && length2 > 0;
                    try {
                        long jM7568a = m7568a(context);
                        File file3 = new File(context.getFilesDir(), "profileInstalled");
                        if (file3.exists()) {
                            try {
                                c3797iM7566a = C3797i.m7566a(file3);
                            } catch (IOException unused) {
                                m7569b();
                                return;
                            }
                        } else {
                            c3797iM7566a = null;
                        }
                        if (c3797iM7566a != null && c3797iM7566a.f12787c == jM7568a && (i6 = c3797iM7566a.f12786b) != 2) {
                            i11 = i6;
                        } else if (z10) {
                            i11 = 1;
                        } else if (z11) {
                            i11 = 2;
                        }
                        if (z7 && z11 && i11 != 1) {
                            i11 = 2;
                        }
                        C3797i c3797i = new C3797i(jM7568a, 1, (c3797iM7566a == null || c3797iM7566a.f12786b != 2 || i11 != 1 || length >= c3797iM7566a.f12788d) ? i11 : 3, length2);
                        if (c3797iM7566a == null || !c3797iM7566a.equals(c3797i)) {
                            try {
                                c3797i.m7567b(file3);
                            } catch (IOException unused2) {
                            }
                        }
                        m7569b();
                        return;
                    } catch (PackageManager.NameNotFoundException unused3) {
                        m7569b();
                        return;
                    }
                }
                m7569b();
            }
        }
    }
}

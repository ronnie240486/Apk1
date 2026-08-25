package p049e3;

import android.os.Build;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public final class C2404v {

    public static final boolean f8381e;

    public static final boolean f8382f;

    public static final File f8383g;

    public static volatile C2404v f8384h;

    public int f8386b;

    public boolean f8387c = true;

    public final AtomicBoolean f8388d = new AtomicBoolean(false);

    public final int f8385a = 20000;

    static {
        int i6 = Build.VERSION.SDK_INT;
        f8381e = i6 < 29;
        f8382f = i6 >= 28;
        f8383g = new File("/proc/self/fd");
    }

    public static C2404v m5436a() {
        if (f8384h == null) {
            synchronized (C2404v.class) {
                try {
                    if (f8384h == null) {
                        f8384h = new C2404v();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8384h;
    }

    public final int m5437b() {
        if (Build.VERSION.SDK_INT == 28) {
            Iterator it = Arrays.asList("GM1900", "GM1901", "GM1903", "GM1911", "GM1915", "ONEPLUS A3000", "ONEPLUS A3010", "ONEPLUS A5010", "ONEPLUS A5000", "ONEPLUS A3003", "ONEPLUS A6000", "ONEPLUS A6003", "ONEPLUS A6010", "ONEPLUS A6013").iterator();
            while (it.hasNext()) {
                if (Build.MODEL.startsWith((String) it.next())) {
                    return 500;
                }
            }
        }
        return this.f8385a;
    }

    public final boolean m5438c(int i6, int i10, boolean z7, boolean z10) {
        boolean z11;
        if (!z7) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by caller");
            }
            return false;
        }
        if (!f8382f) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by sdk");
            }
            return false;
        }
        if (f8381e && !this.f8388d.get()) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by app state");
            }
            return false;
        }
        if (z10) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
            }
            return false;
        }
        if (i6 < 0 || i10 < 0) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because of invalid dimensions");
            }
            return false;
        }
        synchronized (this) {
            try {
                int i11 = this.f8386b + 1;
                this.f8386b = i11;
                if (i11 >= 50) {
                    this.f8386b = 0;
                    int length = f8383g.list().length;
                    long jM5437b = m5437b();
                    boolean z12 = ((long) length) < jM5437b;
                    this.f8387c = z12;
                    if (!z12 && Log.isLoggable("Downsampler", 5)) {
                        Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + jM5437b);
                    }
                }
                z11 = this.f8387c;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z11) {
            return true;
        }
        if (Log.isLoggable("HardwareConfig", 2)) {
            Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
        }
        return false;
    }
}

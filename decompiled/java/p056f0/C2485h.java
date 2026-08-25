package p056f0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p046e0.C2347f;
import p046e0.C2348g;
import p106k0.C2859g;
import p123l5.AbstractC2973a;
import p143n5.AbstractC3198d;

public class C2485h extends AbstractC2973a {

    public static Class f8690r;

    public static Constructor f8691s;

    public static Method f8692t;

    public static Method f8693u;

    public static boolean f8694v;

    public static boolean m5523V(Object obj, String str, int i6, boolean z7) throws NoSuchMethodException {
        m5524W();
        try {
            return ((Boolean) f8692t.invoke(obj, str, Integer.valueOf(i6), Boolean.valueOf(z7))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    public static void m5524W() throws NoSuchMethodException {
        Method method;
        Class<?> cls;
        Method method2;
        if (f8694v) {
            return;
        }
        f8694v = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e5) {
            Log.e("TypefaceCompatApi21Impl", e5.getClass().getName(), e5);
            method = null;
            cls = null;
            method2 = null;
        }
        f8691s = constructor;
        f8690r = cls;
        f8692t = method2;
        f8693u = method;
    }

    @Override
    public Typeface mo5525l(Context context, C2347f c2347f, Resources resources, int i6) throws NoSuchMethodException {
        m5524W();
        try {
            Object objNewInstance = f8691s.newInstance(null);
            for (C2348g c2348g : c2347f.f8193a) {
                File fileM6475x = AbstractC3198d.m6475x(context);
                if (fileM6475x == null) {
                    return null;
                }
                try {
                    if (!AbstractC3198d.m6455c(fileM6475x, resources, c2348g.f8199f)) {
                        return null;
                    }
                    if (!m5523V(objNewInstance, fileM6475x.getPath(), c2348g.f8195b, c2348g.f8196c)) {
                        return null;
                    }
                    fileM6475x.delete();
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    fileM6475x.delete();
                }
            }
            m5524W();
            try {
                Object objNewInstance2 = Array.newInstance((Class<?>) f8690r, 1);
                Array.set(objNewInstance2, 0, objNewInstance);
                return (Typeface) f8693u.invoke(null, objNewInstance2);
            } catch (IllegalAccessException | InvocationTargetException e5) {
                throw new RuntimeException(e5);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    @Override
    public Typeface mo5526m(Context context, C2859g[] c2859gArr, int i6) {
        File file;
        if (c2859gArr.length < 1) {
            return null;
        }
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(mo5541s(i6, c2859gArr).f9782a, "r", null);
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    parcelFileDescriptorOpenFileDescriptor.close();
                }
                return null;
            }
            try {
                try {
                    String str = Os.readlink("/proc/self/fd/" + parcelFileDescriptorOpenFileDescriptor.getFd());
                    file = OsConstants.S_ISREG(Os.stat(str).st_mode) ? new File(str) : null;
                } catch (ErrnoException unused) {
                }
                if (file != null && file.canRead()) {
                    Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceCreateFromFile;
                }
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                try {
                    Typeface typefaceMo5540n = mo5540n(context, fileInputStream);
                    fileInputStream.close();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceMo5540n;
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    parcelFileDescriptorOpenFileDescriptor.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (IOException unused2) {
            return null;
        }
    }
}

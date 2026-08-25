package p056f0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
import p046e0.C2347f;
import p046e0.C2348g;
import p106k0.C2859g;
import p123l5.AbstractC2973a;
import p143n5.AbstractC3198d;
import p160p.C3347k;

public final class C2486i extends AbstractC2973a {

    public static final Class f8695r;

    public static final Constructor f8696s;

    public static final Method f8697t;

    public static final Method f8698u;

    static {
        Method method;
        Class<?> cls;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e5) {
            Log.e("TypefaceCompatApi24Impl", e5.getClass().getName(), e5);
            method = null;
            cls = null;
            method2 = null;
        }
        f8696s = constructor;
        f8695r = cls;
        f8697t = method2;
        f8698u = method;
    }

    public static boolean m5527V(Object obj, ByteBuffer byteBuffer, int i6, int i10, boolean z7) {
        try {
            return ((Boolean) f8697t.invoke(obj, byteBuffer, Integer.valueOf(i6), null, Integer.valueOf(i10), Boolean.valueOf(z7))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface m5528W(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) f8695r, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f8698u.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override
    public final Typeface mo5525l(Context context, C2347f c2347f, Resources resources, int i6) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        MappedByteBuffer map;
        try {
            objNewInstance = f8696s.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance == null) {
            return null;
        }
        for (C2348g c2348g : c2347f.f8193a) {
            int i10 = c2348g.f8199f;
            File fileM6475x = AbstractC3198d.m6475x(context);
            if (fileM6475x != null) {
                try {
                    if (AbstractC3198d.m6455c(fileM6475x, resources, i10)) {
                        try {
                            FileInputStream fileInputStream = new FileInputStream(fileM6475x);
                            try {
                                FileChannel channel = fileInputStream.getChannel();
                                map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                                fileInputStream.close();
                                fileM6475x.delete();
                            } catch (Throwable th) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        } catch (IOException unused2) {
                            map = null;
                        }
                    } else {
                        fileM6475x.delete();
                    }
                    if (map == null) {
                        return null;
                    }
                    if (!m5527V(objNewInstance, map, c2348g.f8198e, c2348g.f8195b, c2348g.f8196c)) {
                        return null;
                    }
                } catch (Throwable th3) {
                    fileM6475x.delete();
                    throw th3;
                }
            }
            map = null;
            if (map == null) {
                return null;
            }
            if (!m5527V(objNewInstance, map, c2348g.f8198e, c2348g.f8195b, c2348g.f8196c)) {
                return null;
            }
        }
        return m5528W(objNewInstance);
    }

    @Override
    public final Typeface mo5526m(Context context, C2859g[] c2859gArr, int i6) {
        Object objNewInstance;
        try {
            objNewInstance = f8696s.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance == null) {
            return null;
        }
        C3347k c3347k = new C3347k(0);
        for (C2859g c2859g : c2859gArr) {
            Uri uri = c2859g.f9782a;
            ByteBuffer byteBufferM6429D = (ByteBuffer) c3347k.get(uri);
            if (byteBufferM6429D == null) {
                byteBufferM6429D = AbstractC3198d.m6429D(context, uri);
                c3347k.put(uri, byteBufferM6429D);
            }
            if (byteBufferM6429D == null) {
                return null;
            }
            if (!m5527V(objNewInstance, byteBufferM6429D, c2859g.f9783b, c2859g.f9784c, c2859g.f9785d)) {
                return null;
            }
        }
        Typeface typefaceM5528W = m5528W(objNewInstance);
        if (typefaceM5528W == null) {
            return null;
        }
        return Typeface.create(typefaceM5528W, i6);
    }
}

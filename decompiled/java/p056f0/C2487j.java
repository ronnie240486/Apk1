package p056f0;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p046e0.C2347f;
import p046e0.C2348g;
import p106k0.C2859g;
import p143n5.AbstractC3198d;

public class C2487j extends C2485h {

    public final Method f8699A;

    public final Method f8700B;

    public final Method f8701C;

    public final Class f8702w;

    public final Constructor f8703x;

    public final Method f8704y;

    public final Method f8705z;

    public C2487j() throws NoSuchMethodException {
        Method methodMo5536e0;
        Constructor<?> constructor;
        Method methodM5529d0;
        Method method;
        Method method2;
        Method method3;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(null);
            methodM5529d0 = m5529d0(cls2);
            Class<?> cls3 = Integer.TYPE;
            method = cls2.getMethod("addFontFromBuffer", ByteBuffer.class, cls3, FontVariationAxis[].class, cls3, cls3);
            method2 = cls2.getMethod("freeze", null);
            method3 = cls2.getMethod("abortCreation", null);
            methodMo5536e0 = mo5536e0(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e5) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e5.getClass().getName()), e5);
            methodMo5536e0 = null;
            constructor = null;
            methodM5529d0 = null;
            method = null;
            method2 = null;
            method3 = null;
        }
        this.f8702w = cls;
        this.f8703x = constructor;
        this.f8704y = methodM5529d0;
        this.f8705z = method;
        this.f8699A = method2;
        this.f8700B = method3;
        this.f8701C = methodMo5536e0;
    }

    public static Method m5529d0(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    public final void m5530X(Object obj) {
        try {
            this.f8700B.invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean m5531Y(Context context, Object obj, String str, int i6, int i10, int i11, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f8704y.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i6), Integer.valueOf(i10), Integer.valueOf(i11), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface mo5532Z(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.f8702w, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f8701C.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean m5533a0(Object obj) {
        try {
            return ((Boolean) this.f8699A.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean m5534b0() {
        Method method = this.f8704y;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return method != null;
    }

    public final Object m5535c0() {
        try {
            return this.f8703x.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public Method mo5536e0(Class cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance((Class<?>) cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    @Override
    public final Typeface mo5525l(Context context, C2347f c2347f, Resources resources, int i6) {
        if (!m5534b0()) {
            return super.mo5525l(context, c2347f, resources, i6);
        }
        Object objM5535c0 = m5535c0();
        if (objM5535c0 == null) {
            return null;
        }
        for (C2348g c2348g : c2347f.f8193a) {
            if (!m5531Y(context, objM5535c0, c2348g.f8194a, c2348g.f8198e, c2348g.f8195b, c2348g.f8196c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(c2348g.f8197d))) {
                m5530X(objM5535c0);
                return null;
            }
        }
        if (m5533a0(objM5535c0)) {
            return mo5532Z(objM5535c0);
        }
        return null;
    }

    @Override
    public final Typeface mo5526m(Context context, C2859g[] c2859gArr, int i6) {
        Typeface typefaceMo5532Z;
        boolean zBooleanValue;
        if (c2859gArr.length < 1) {
            return null;
        }
        if (!m5534b0()) {
            C2859g c2859gMo5541s = mo5541s(i6, c2859gArr);
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(c2859gMo5541s.f9782a, "r", null);
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(c2859gMo5541s.f9784c).setItalic(c2859gMo5541s.f9785d).build();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceBuild;
                } catch (Throwable th) {
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException unused) {
                return null;
            }
        }
        HashMap map = new HashMap();
        for (C2859g c2859g : c2859gArr) {
            if (c2859g.f9786e == 0) {
                Uri uri = c2859g.f9782a;
                if (!map.containsKey(uri)) {
                    map.put(uri, AbstractC3198d.m6429D(context, uri));
                }
            }
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
        Object objM5535c0 = m5535c0();
        if (objM5535c0 == null) {
            return null;
        }
        boolean z7 = false;
        for (C2859g c2859g2 : c2859gArr) {
            ByteBuffer byteBuffer = (ByteBuffer) mapUnmodifiableMap.get(c2859g2.f9782a);
            if (byteBuffer != null) {
                try {
                    zBooleanValue = ((Boolean) this.f8705z.invoke(objM5535c0, byteBuffer, Integer.valueOf(c2859g2.f9783b), null, Integer.valueOf(c2859g2.f9784c), Integer.valueOf(c2859g2.f9785d ? 1 : 0))).booleanValue();
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                    zBooleanValue = false;
                }
                if (!zBooleanValue) {
                    m5530X(objM5535c0);
                    return null;
                }
                z7 = true;
            }
        }
        if (!z7) {
            m5530X(objM5535c0);
            return null;
        }
        if (m5533a0(objM5535c0) && (typefaceMo5532Z = mo5532Z(objM5535c0)) != null) {
            return Typeface.create(typefaceMo5532Z, i6);
        }
        return null;
    }

    @Override
    public final Typeface mo5537o(Context context, Resources resources, int i6, String str, int i10) {
        if (!m5534b0()) {
            return super.mo5537o(context, resources, i6, str, i10);
        }
        Object objM5535c0 = m5535c0();
        if (objM5535c0 == null) {
            return null;
        }
        if (!m5531Y(context, objM5535c0, str, 0, -1, -1, null)) {
            m5530X(objM5535c0);
            return null;
        }
        if (m5533a0(objM5535c0)) {
            return mo5532Z(objM5535c0);
        }
        return null;
    }
}

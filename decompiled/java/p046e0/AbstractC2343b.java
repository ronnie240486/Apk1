package p046e0;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import com.google.android.gms.internal.cast.C1552f0;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p013b0.AbstractC1226a;
import p025c2.C1381b;
import p056f0.AbstractC2478a;
import p173q1.RunnableC3396c;

public abstract class AbstractC2343b {

    public static final float[][] f8185a = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};

    public static final float[][] f8186b = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    public static final float[] f8187c = {95.047f, 100.0f, 108.883f};

    public static final float[][] f8188d = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};

    public static final Object f8189e = new Object();

    public static Method f8190f;

    public static boolean f8191g;

    public static C1552f0 m5316b(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i6) {
        C1552f0 c1552f0M3814a;
        boolean zM5319e = m5319e(xmlPullParser, str);
        Object obj = null;
        int i10 = 0;
        if (zM5319e) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i6, typedValue);
            int i11 = typedValue.type;
            if (i11 >= 28 && i11 <= 31) {
                return new C1552f0(obj, typedValue.data, obj);
            }
            try {
                c1552f0M3814a = C1552f0.m3814a(typedArray.getResources(), typedArray.getResourceId(i6, 0), theme);
            } catch (Exception e5) {
                Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e5);
                c1552f0M3814a = null;
            }
            if (c1552f0M3814a != null) {
                return c1552f0M3814a;
            }
        }
        return new C1552f0(obj, i10, obj);
    }

    public static int m5317c(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i6, int i10) {
        return !m5319e(xmlPullParser, str) ? i10 : typedArray.getInt(i6, i10);
    }

    public static String m5318d(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i6) {
        if (m5319e(xmlPullParser, str)) {
            return typedArray.getString(i6);
        }
        return null;
    }

    public static boolean m5319e(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static int m5320f(float f) {
        if (f < 1.0f) {
            return -16777216;
        }
        if (f > 99.0f) {
            return -1;
        }
        float f3 = (f + 16.0f) / 116.0f;
        float f4 = f > 8.0f ? f3 * f3 * f3 : f / 903.2963f;
        float f5 = f3 * f3 * f3;
        boolean z7 = f5 > 0.008856452f;
        float f10 = z7 ? f5 : ((f3 * 116.0f) - 16.0f) / 903.2963f;
        if (!z7) {
            f5 = ((f3 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = f8187c;
        return AbstractC2478a.m5507b(f10 * fArr[0], f4 * fArr[1], f5 * fArr[2]);
    }

    public static float m5321g(int i6) {
        float f = i6 / 255.0f;
        return (f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }

    public static TypedArray m5322h(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static InterfaceC2346e m5323k(XmlResourceParser xmlResourceParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlResourceParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        xmlResourceParser.require(2, null, "font-family");
        if (xmlResourceParser.getName().equals("font-family")) {
            TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), AbstractC1226a.f3911b);
            String string = typedArrayObtainAttributes.getString(0);
            String string2 = typedArrayObtainAttributes.getString(4);
            String string3 = typedArrayObtainAttributes.getString(5);
            int resourceId = typedArrayObtainAttributes.getResourceId(1, 0);
            int integer = typedArrayObtainAttributes.getInteger(2, 1);
            int integer2 = typedArrayObtainAttributes.getInteger(3, 500);
            String string4 = typedArrayObtainAttributes.getString(6);
            typedArrayObtainAttributes.recycle();
            if (string != null && string2 != null && string3 != null) {
                while (xmlResourceParser.next() != 3) {
                    m5326n(xmlResourceParser);
                }
                return new C2349h(new C1381b(string, string2, string3, m5324l(resources, resourceId)), integer, integer2, string4);
            }
            ArrayList arrayList = new ArrayList();
            while (xmlResourceParser.next() != 3) {
                if (xmlResourceParser.getEventType() == 2) {
                    if (xmlResourceParser.getName().equals("font")) {
                        TypedArray typedArrayObtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), AbstractC1226a.f3912c);
                        int i6 = typedArrayObtainAttributes2.getInt(typedArrayObtainAttributes2.hasValue(8) ? 8 : 1, 400);
                        boolean z7 = 1 == typedArrayObtainAttributes2.getInt(typedArrayObtainAttributes2.hasValue(6) ? 6 : 2, 0);
                        int i10 = typedArrayObtainAttributes2.hasValue(9) ? 9 : 3;
                        String string5 = typedArrayObtainAttributes2.getString(typedArrayObtainAttributes2.hasValue(7) ? 7 : 4);
                        int i11 = typedArrayObtainAttributes2.getInt(i10, 0);
                        int i12 = typedArrayObtainAttributes2.hasValue(5) ? 5 : 0;
                        int resourceId2 = typedArrayObtainAttributes2.getResourceId(i12, 0);
                        String string6 = typedArrayObtainAttributes2.getString(i12);
                        typedArrayObtainAttributes2.recycle();
                        while (xmlResourceParser.next() != 3) {
                            m5326n(xmlResourceParser);
                        }
                        arrayList.add(new C2348g(string6, string5, i6, i11, resourceId2, z7));
                    } else {
                        m5326n(xmlResourceParser);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                return new C2347f((C2348g[]) arrayList.toArray(new C2348g[0]));
            }
        } else {
            m5326n(xmlResourceParser);
        }
        return null;
    }

    public static List m5324l(Resources resources, int i6) {
        if (i6 == 0) {
            return Collections.emptyList();
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i6);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (AbstractC2345d.m5331a(typedArrayObtainTypedArray, 0) == 1) {
                for (int i10 = 0; i10 < typedArrayObtainTypedArray.length(); i10++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i10, 0);
                    if (resourceId != 0) {
                        String[] stringArray = resources.getStringArray(resourceId);
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : stringArray) {
                            arrayList2.add(Base64.decode(str, 0));
                        }
                        arrayList.add(arrayList2);
                    }
                }
            } else {
                String[] stringArray2 = resources.getStringArray(i6);
                ArrayList arrayList3 = new ArrayList();
                for (String str2 : stringArray2) {
                    arrayList3.add(Base64.decode(str2, 0));
                }
                arrayList.add(arrayList3);
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    public static void m5325m(Resources.Theme theme) {
        Method method;
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 29) {
            AbstractC2354m.m5336a(theme);
            return;
        }
        if (i6 >= 23) {
            synchronized (f8189e) {
                if (f8191g) {
                    method = f8190f;
                    if (method != null) {
                        method.invoke(theme, null);
                    }
                } else {
                    try {
                        Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", null);
                        f8190f = declaredMethod;
                        declaredMethod.setAccessible(true);
                    } catch (NoSuchMethodException e5) {
                        Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e5);
                    }
                    f8191g = true;
                    method = f8190f;
                    if (method != null) {
                        try {
                            method.invoke(theme, null);
                        } catch (IllegalAccessException | InvocationTargetException e10) {
                            Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e10);
                            f8190f = null;
                        }
                    }
                }
                throw th;
            }
        }
    }

    public static void m5326n(XmlResourceParser xmlResourceParser) throws XmlPullParserException, IOException {
        int i6 = 1;
        while (i6 > 0) {
            int next = xmlResourceParser.next();
            if (next == 2) {
                i6++;
            } else if (next == 3) {
                i6--;
            }
        }
    }

    public static float m5327o() {
        return ((float) Math.pow((((double) 50.0f) + 16.0d) / 116.0d, 3.0d)) * 100.0f;
    }

    public void m5328a(int i6) {
        new Handler(Looper.getMainLooper()).post(new RunnableC3396c(i6, 2, this));
    }

    public abstract void mo757i(int i6);

    public abstract void mo758j(Typeface typeface);
}

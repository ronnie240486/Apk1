package p046e0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import com.p2serv.android.p032ds.R;
import java.lang.reflect.Array;
import org.xmlpull.v1.XmlPullParserException;
import p013b0.AbstractC1226a;
import p123l5.AbstractC2973a;

public abstract class AbstractC2344c {

    public static final ThreadLocal f8192a = new ThreadLocal();

    public static ColorStateList m5329a(Resources resources, XmlResourceParser xmlResourceParser, Resources.Theme theme) {
        int next;
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlResourceParser);
        do {
            next = xmlResourceParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return m5330b(resources, xmlResourceParser, attributeSetAsAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList m5330b(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        int color;
        int iM5320f;
        float f;
        TypedValue typedValue;
        resources = resources;
        attributeSet = attributeSet;
        theme = theme;
        String name = xmlResourceParser.getName();
        if (!name.equals("selector")) {
            throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": invalid color state list tag " + name);
        }
        ?? r10 = 1;
        int depth2 = xmlResourceParser.getDepth() + 1;
        Object[] objArr = new int[20][];
        int[] iArr = new int[20];
        int i6 = 0;
        int i10 = 0;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == r10 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlResourceParser.getName().equals("item")) {
                int[] iArr2 = AbstractC1226a.f3910a;
                TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr2) : theme.obtainStyledAttributes(attributeSet, iArr2, i6, i6);
                int resourceId = typedArrayObtainAttributes.getResourceId(i6, -1);
                if (resourceId != -1) {
                    ThreadLocal threadLocal = f8192a;
                    TypedValue typedValue2 = (TypedValue) threadLocal.get();
                    if (typedValue2 == null) {
                        typedValue = new TypedValue();
                        threadLocal.set(typedValue);
                    } else {
                        typedValue = typedValue2;
                    }
                    resources.getValue(resourceId, typedValue, (boolean) r10);
                    int i11 = typedValue.type;
                    if (i11 < 28 || i11 > 31) {
                        try {
                            color = m5329a(resources, resources.getXml(resourceId), theme).getDefaultColor();
                        } catch (Exception unused) {
                            color = typedArrayObtainAttributes.getColor(i6, -65281);
                        }
                    } else {
                        color = typedArrayObtainAttributes.getColor(i6, -65281);
                    }
                } else {
                    color = typedArrayObtainAttributes.getColor(i6, -65281);
                }
                float f3 = typedArrayObtainAttributes.hasValue(r10) ? typedArrayObtainAttributes.getFloat(r10, 1.0f) : typedArrayObtainAttributes.hasValue(3) ? typedArrayObtainAttributes.getFloat(3, 1.0f) : 1.0f;
                float f4 = (Build.VERSION.SDK_INT < 31 || !typedArrayObtainAttributes.hasValue(2)) ? typedArrayObtainAttributes.getFloat(4, -1.0f) : typedArrayObtainAttributes.getFloat(2, -1.0f);
                typedArrayObtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr3 = new int[attributeCount];
                int i12 = 0;
                for (int i13 = 0; i13 < attributeCount; i13++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i13);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != R.attr.alpha && attributeNameResource != R.attr.lStar) {
                        int i14 = i12 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i13, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr3[i12] = attributeNameResource;
                        i12 = i14;
                    }
                }
                int[] iArrTrimStateSet = StateSet.trimStateSet(iArr3, i12);
                boolean z7 = f4 >= 0.0f && f4 <= 100.0f;
                if (f3 != 1.0f || z7) {
                    int iM6016g = AbstractC2973a.m6016g((int) ((Color.alpha(color) * f3) + 0.5f), 0, 255);
                    if (z7) {
                        C2342a c2342aM5312b = C2342a.m5312b(color);
                        C2356o c2356o = C2356o.f8212k;
                        float f5 = c2342aM5312b.f8180b;
                        if (f5 >= 1.0d && Math.round(f4) > 0.0d && Math.round(f4) < 100.0d) {
                            float f10 = c2342aM5312b.f8179a;
                            float fMin = f10 < 0.0f ? 0.0f : Math.min(360.0f, f10);
                            float f11 = f5;
                            C2342a c2342a = null;
                            boolean z10 = true;
                            float f12 = 0.0f;
                            while (true) {
                                if (Math.abs(f12 - f5) < 0.4f) {
                                    depth2 = depth2;
                                    if (c2342a != null) {
                                        iM5320f = c2342a.m5315d(c2356o);
                                        break;
                                    }
                                    iM5320f = AbstractC2343b.m5320f(f4);
                                    break;
                                }
                                float f13 = 1000.0f;
                                float f14 = 1000.0f;
                                float f15 = 0.0f;
                                float f16 = 100.0f;
                                C2342a c2342a2 = null;
                                while (true) {
                                    if (Math.abs(f15 - f16) <= 0.01f) {
                                        depth2 = depth2;
                                        fMin = fMin;
                                        break;
                                    }
                                    float f17 = ((f16 - f15) / 2.0f) + f15;
                                    int iM5315d = C2342a.m5313c(f17, f11, fMin).m5315d(C2356o.f8212k);
                                    float fM5321g = AbstractC2343b.m5321g(Color.red(iM5315d));
                                    float fM5321g2 = AbstractC2343b.m5321g(Color.green(iM5315d));
                                    float fM5321g3 = AbstractC2343b.m5321g(Color.blue(iM5315d));
                                    float[] fArr = AbstractC2343b.f8188d[1];
                                    float f18 = ((fM5321g3 * fArr[2]) + ((fM5321g2 * fArr[1]) + (fM5321g * fArr[0]))) / 100.0f;
                                    float fCbrt = f18 <= 0.008856452f ? f18 * 903.2963f : (((float) Math.cbrt(f18)) * 116.0f) - 16.0f;
                                    float fAbs = Math.abs(f4 - fCbrt);
                                    if (fAbs < 0.2f) {
                                        C2342a c2342aM5312b2 = C2342a.m5312b(iM5315d);
                                        C2342a c2342aM5313c = C2342a.m5313c(c2342aM5312b2.f8181c, c2342aM5312b2.f8180b, fMin);
                                        f = f17;
                                        float f19 = c2342aM5312b2.f8182d - c2342aM5313c.f8182d;
                                        fMin = fMin;
                                        float f20 = c2342aM5312b2.f8183e - c2342aM5313c.f8183e;
                                        float f21 = c2342aM5312b2.f8184f - c2342aM5313c.f8184f;
                                        float fPow = (float) (Math.pow(Math.sqrt((f21 * f21) + (f20 * f20) + (f19 * f19)), 0.63d) * 1.41d);
                                        if (fPow <= 1.0f) {
                                            c2342a2 = c2342aM5312b2;
                                            f14 = fPow;
                                            f13 = fAbs;
                                        }
                                    } else {
                                        f = f17;
                                        fMin = fMin;
                                    }
                                    if (f13 == 0.0f && f14 == 0.0f) {
                                        break;
                                    }
                                    if (fCbrt < f4) {
                                        f15 = f;
                                    } else {
                                        f16 = f;
                                    }
                                    depth2 = depth2;
                                    fMin = fMin;
                                }
                                C2342a c2342a3 = c2342a2;
                                if (!z10) {
                                    if (c2342a3 == null) {
                                        f5 = f11;
                                    } else {
                                        c2342a = c2342a3;
                                        f12 = f11;
                                    }
                                    f11 = ((f5 - f12) / 2.0f) + f12;
                                } else {
                                    if (c2342a3 != null) {
                                        iM5320f = c2342a3.m5315d(c2356o);
                                        break;
                                    }
                                    f11 = ((f5 - f12) / 2.0f) + f12;
                                    z10 = false;
                                }
                            }
                        } else {
                            depth2 = depth2;
                            iM5320f = AbstractC2343b.m5320f(f4);
                        }
                        color = iM5320f;
                    } else {
                        depth2 = depth2;
                    }
                    color = (16777215 & color) | (iM6016g << 24);
                } else {
                    depth2 = depth2;
                }
                int i15 = i10 + 1;
                if (i15 > iArr.length) {
                    int[] iArr4 = new int[i10 <= 4 ? 8 : i10 * 2];
                    System.arraycopy(iArr, 0, iArr4, 0, i10);
                    iArr = iArr4;
                }
                iArr[i10] = color;
                if (i15 > objArr.length) {
                    Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i10 > 4 ? i10 * 2 : 8);
                    System.arraycopy(objArr, 0, objArr2, 0, i10);
                    objArr = objArr2;
                }
                objArr[i10] = iArrTrimStateSet;
                objArr = (int[][]) objArr;
                i10 = i15;
                depth2 = depth2;
                r10 = 1;
                i6 = 0;
            } else {
                depth2 = depth2;
                r10 = 1;
                i6 = 0;
            }
        }
        int[] iArr5 = new int[i10];
        int[][] iArr6 = new int[i10][];
        System.arraycopy(iArr, 0, iArr5, 0, i10);
        System.arraycopy(objArr, 0, iArr6, 0, i10);
        return new ColorStateList(iArr6, iArr5);
    }
}

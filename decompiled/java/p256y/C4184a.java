package p256y;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import p000a.AbstractC0004e;
import p003a2.AbstractC0032a;
import p055ea.AbstractC2460q;
import p215u.AbstractC3885h;

public final class C4184a {

    public String f14128a;

    public int f14129b;

    public int f14130c;

    public float f14131d;

    public String f14132e;

    public boolean f14133f;

    public int f14134g;

    public C4184a(C4184a c4184a, Object obj) {
        this.f14128a = c4184a.f14128a;
        this.f14129b = c4184a.f14129b;
        m8239h(obj);
    }

    public static int m8232a(int i6) {
        int i10 = (i6 & (~(i6 >> 31))) - 255;
        return (i10 & (i10 >> 31)) + 255;
    }

    public static void m8233e(Context context, XmlResourceParser xmlResourceParser, HashMap map) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), AbstractC4193j.f14239e);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        String string = null;
        Object string2 = null;
        int i6 = 0;
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i10);
            if (index == 0) {
                string = typedArrayObtainStyledAttributes.getString(index);
                if (string != null && string.length() > 0) {
                    string = Character.toUpperCase(string.charAt(0)) + string.substring(1);
                }
            } else if (index == 1) {
                string2 = Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(index, false));
                i6 = 6;
            } else if (index == 3) {
                string2 = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                i6 = 3;
            } else if (index == 2) {
                string2 = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                i6 = 4;
            } else {
                if (index == 7) {
                    string2 = Float.valueOf(TypedValue.applyDimension(1, typedArrayObtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == 4) {
                    string2 = Float.valueOf(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == 5) {
                    string2 = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, Float.NaN));
                    i6 = 2;
                } else if (index == 6) {
                    string2 = Integer.valueOf(typedArrayObtainStyledAttributes.getInteger(index, -1));
                    i6 = 1;
                } else if (index == 8) {
                    string2 = typedArrayObtainStyledAttributes.getString(index);
                    i6 = 5;
                }
                i6 = 7;
            }
        }
        if (string != null && string2 != null) {
            C4184a c4184a = new C4184a();
            c4184a.f14128a = string;
            c4184a.f14129b = i6;
            c4184a.m8239h(string2);
            map.put(string, c4184a);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void m8234f(View view, HashMap map) {
        Class<?> cls = view.getClass();
        for (String str : map.keySet()) {
            C4184a c4184a = (C4184a) map.get(str);
            String strM5501o = AbstractC2460q.m5501o("set", str);
            try {
                switch (AbstractC3885h.m7785a(c4184a.f14129b)) {
                    case 0:
                        cls.getMethod(strM5501o, Integer.TYPE).invoke(view, Integer.valueOf(c4184a.f14130c));
                        break;
                    case 1:
                        cls.getMethod(strM5501o, Float.TYPE).invoke(view, Float.valueOf(c4184a.f14131d));
                        break;
                    case 2:
                        cls.getMethod(strM5501o, Integer.TYPE).invoke(view, Integer.valueOf(c4184a.f14134g));
                        break;
                    case 3:
                        Method method = cls.getMethod(strM5501o, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(c4184a.f14134g);
                        method.invoke(view, colorDrawable);
                        break;
                    case 4:
                        cls.getMethod(strM5501o, CharSequence.class).invoke(view, c4184a.f14132e);
                        break;
                    case 5:
                        cls.getMethod(strM5501o, Boolean.TYPE).invoke(view, Boolean.valueOf(c4184a.f14133f));
                        break;
                    case 6:
                        cls.getMethod(strM5501o, Float.TYPE).invoke(view, Float.valueOf(c4184a.f14131d));
                        break;
                }
            } catch (IllegalAccessException e5) {
                StringBuilder sbM30x = AbstractC0004e.m30x(" Custom Attribute \"", str, "\" not found on ");
                sbM30x.append(cls.getName());
                Log.e("TransitionLayout", sbM30x.toString());
                e5.printStackTrace();
            } catch (NoSuchMethodException e10) {
                Log.e("TransitionLayout", e10.getMessage());
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                Log.e("TransitionLayout", cls.getName() + " must have a method " + strM5501o);
            } catch (InvocationTargetException e11) {
                StringBuilder sbM30x2 = AbstractC0004e.m30x(" Custom Attribute \"", str, "\" not found on ");
                sbM30x2.append(cls.getName());
                Log.e("TransitionLayout", sbM30x2.toString());
                e11.printStackTrace();
            }
        }
    }

    public final float m8235b() {
        switch (AbstractC3885h.m7785a(this.f14129b)) {
            case 0:
                return this.f14130c;
            case 1:
                return this.f14131d;
            case 2:
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
                throw new RuntimeException("Cannot interpolate String");
            case 5:
                return this.f14133f ? 0.0f : 1.0f;
            case 6:
                return this.f14131d;
            default:
                return Float.NaN;
        }
    }

    public final void m8236c(float[] fArr) {
        switch (AbstractC3885h.m7785a(this.f14129b)) {
            case 0:
                fArr[0] = this.f14130c;
                return;
            case 1:
                fArr[0] = this.f14131d;
                return;
            case 2:
            case 3:
                int i6 = this.f14134g;
                int i10 = (i6 >> 24) & 255;
                float fPow = (float) Math.pow(((i6 >> 16) & 255) / 255.0f, 2.2d);
                float fPow2 = (float) Math.pow(((i6 >> 8) & 255) / 255.0f, 2.2d);
                float fPow3 = (float) Math.pow((i6 & 255) / 255.0f, 2.2d);
                fArr[0] = fPow;
                fArr[1] = fPow2;
                fArr[2] = fPow3;
                fArr[3] = i10 / 255.0f;
                return;
            case 4:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 5:
                fArr[0] = this.f14133f ? 0.0f : 1.0f;
                return;
            case 6:
                fArr[0] = this.f14131d;
                return;
            default:
                return;
        }
    }

    public final int m8237d() {
        int iM7785a = AbstractC3885h.m7785a(this.f14129b);
        return (iM7785a == 2 || iM7785a == 3) ? 4 : 1;
    }

    public final void m8238g(View view, float[] fArr) {
        Class<?> cls = view.getClass();
        StringBuilder sb = new StringBuilder("set");
        String str = this.f14128a;
        sb.append(str);
        String string = sb.toString();
        try {
            switch (AbstractC3885h.m7785a(this.f14129b)) {
                case 0:
                    cls.getMethod(string, Integer.TYPE).invoke(view, Integer.valueOf((int) fArr[0]));
                    return;
                case 1:
                    cls.getMethod(string, Float.TYPE).invoke(view, Float.valueOf(fArr[0]));
                    return;
                case 2:
                    cls.getMethod(string, Integer.TYPE).invoke(view, Integer.valueOf((m8232a((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (m8232a((int) (fArr[3] * 255.0f)) << 24) | (m8232a((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | m8232a((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f))));
                    return;
                case 3:
                    Method method = cls.getMethod(string, Drawable.class);
                    int iM8232a = m8232a((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f)) | (m8232a((int) (fArr[3] * 255.0f)) << 24) | (m8232a((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (m8232a((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8);
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor(iM8232a);
                    method.invoke(view, colorDrawable);
                    return;
                case 4:
                    throw new RuntimeException("unable to interpolate strings " + str);
                case 5:
                    cls.getMethod(string, Boolean.TYPE).invoke(view, Boolean.valueOf(fArr[0] > 0.5f));
                    return;
                case 6:
                    cls.getMethod(string, Float.TYPE).invoke(view, Float.valueOf(fArr[0]));
                    return;
                default:
                    return;
            }
        } catch (IllegalAccessException e5) {
            StringBuilder sbM30x = AbstractC0004e.m30x("cannot access method ", string, "on View \"");
            sbM30x.append(AbstractC0032a.m171y(view));
            sbM30x.append("\"");
            Log.e("TransitionLayout", sbM30x.toString());
            e5.printStackTrace();
        } catch (NoSuchMethodException e10) {
            StringBuilder sbM30x2 = AbstractC0004e.m30x("no method ", string, "on View \"");
            sbM30x2.append(AbstractC0032a.m171y(view));
            sbM30x2.append("\"");
            Log.e("TransitionLayout", sbM30x2.toString());
            e10.printStackTrace();
        } catch (InvocationTargetException e11) {
            e11.printStackTrace();
        }
    }

    public final void m8239h(Object obj) {
        switch (AbstractC3885h.m7785a(this.f14129b)) {
            case 0:
                this.f14130c = ((Integer) obj).intValue();
                break;
            case 1:
                this.f14131d = ((Float) obj).floatValue();
                break;
            case 2:
            case 3:
                this.f14134g = ((Integer) obj).intValue();
                break;
            case 4:
                this.f14132e = (String) obj;
                break;
            case 5:
                this.f14133f = ((Boolean) obj).booleanValue();
                break;
            case 6:
                this.f14131d = ((Float) obj).floatValue();
                break;
        }
    }
}

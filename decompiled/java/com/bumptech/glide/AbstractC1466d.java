package com.bumptech.glide;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.TypedValue;
import android.view.View;
import android.widget.EdgeEffect;
import android.widget.LinearLayout;
import androidx.core.widget.AbstractC0372e;
import androidx.core.widget.AbstractC0373f;
import androidx.leanback.widget.C0460e0;
import androidx.media3.extractor.p010ts.TsExtractor;
import androidx.recyclerview.widget.AbstractC1174p1;
import androidx.recyclerview.widget.RecyclerView;
import com.lzy.okgo.cache.CacheEntity;
import java.util.ArrayList;
import java.util.Locale;
import org.bitspark.android.utils.C3324f;
import p000a.AbstractC0004e;
import p002a1.C0026b;
import p003a2.AbstractC0032a;
import p008a9.C0080j;
import p008a9.InterfaceC0074d;
import p008a9.InterfaceC0077g;
import p008a9.InterfaceC0078h;
import p008a9.InterfaceC0079i;
import p030c9.AbstractC1433c;
import p056f0.C2483f;
import p103j9.AbstractC2796i;
import p103j9.InterfaceC2791d;
import p114k8.C2902b;
import p114k8.C2903c;
import p114k8.C2904d;
import p170p9.InterfaceC3384b;
import p182r.AbstractC3574g;
import p182r.C3570c;
import p182r.C3573f;
import p191r8.AbstractC3642a;
import p222u7.AbstractC3928d;
import p253x8.AbstractC4148k;

public abstract class AbstractC1466d {
    public static InterfaceC0079i m3482A(InterfaceC0077g interfaceC0077g, InterfaceC0079i interfaceC0079i) {
        AbstractC2796i.m5785f(interfaceC0079i, "context");
        return AbstractC1465c.m3475j(interfaceC0077g, interfaceC0079i);
    }

    public static final void m3483D(RecyclerView recyclerView, int i6) {
        AbstractC2796i.m5785f(recyclerView, AbstractC0032a.m165s("nI2nf1B2\n", "oPnPFiNISUk=\n"));
        AbstractC1174p1 abstractC1174p1FindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i6);
        if (abstractC1174p1FindViewHolderForAdapterPosition == null) {
            recyclerView.smoothScrollToPosition(i6);
            C3324f c3324f = new C3324f(recyclerView, i6);
            recyclerView.clearOnScrollListeners();
            recyclerView.addOnScrollListener(c3324f);
            return;
        }
        View view = abstractC1174p1FindViewHolderForAdapterPosition.itemView;
        if (view != null) {
            view.requestFocus();
        }
    }

    public static void m3484G(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }

    public static final void m3485H(C0026b c0026b, ArrayList arrayList) {
        AbstractC2796i.m5785f(c0026b, AbstractC0032a.m165s("Mk5lk6ApHQ==\n", "UyoE49RMb48=\n"));
        AbstractC2796i.m5785f(arrayList, AbstractC0032a.m165s("GIeo8g==\n", "dO7bhlEdvWA=\n"));
        ArrayList arrayList2 = (ArrayList) c0026b.f56d;
        int size = arrayList2.size();
        int size2 = arrayList.size();
        C0460e0 c0460e0 = (C0460e0) c0026b.f54b;
        int i6 = 0;
        if (size > size2) {
            int size3 = arrayList.size();
            int iMin = Math.min(arrayList2.size(), arrayList2.size() - size3);
            if (iMin > 0) {
                for (int i10 = 0; i10 < iMin; i10++) {
                    arrayList2.remove(size3);
                }
                c0460e0.m1425d(size3, iMin);
            }
        }
        for (Object obj : arrayList) {
            int i11 = i6 + 1;
            if (i6 < 0) {
                AbstractC4148k.m8192P();
                throw null;
            }
            if (i6 < arrayList2.size()) {
                arrayList2.set(i6, obj);
                c0460e0.m1423b(i6);
            } else {
                int size4 = arrayList2.size();
                arrayList2.add(size4, obj);
                c0460e0.m1424c(size4, 1);
            }
            i6 = i11;
        }
    }

    public static boolean m3486a(C2483f[] c2483fArr, C2483f[] c2483fArr2) {
        if (c2483fArr == null || c2483fArr2 == null || c2483fArr.length != c2483fArr2.length) {
            return false;
        }
        for (int i6 = 0; i6 < c2483fArr.length; i6++) {
            C2483f c2483f = c2483fArr[i6];
            char c5 = c2483f.f8686a;
            C2483f c2483f2 = c2483fArr2[i6];
            if (c5 != c2483f2.f8686a || c2483f.f8687b.length != c2483f2.f8687b.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] m3487e(float[] fArr, int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int iMin = Math.min(i6, length);
        float[] fArr2 = new float[i6];
        System.arraycopy(fArr, 0, fArr2, 0, iMin);
        return fArr2;
    }

    public static C2483f[] m3488f(String str) {
        int i6;
        String strTrim;
        float[] fArrM3487e;
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        int i11 = 1;
        int i12 = 0;
        while (i11 < str.length()) {
            while (i11 < str.length()) {
                char cCharAt = str.charAt(i11);
                if ((cCharAt - 'Z') * (cCharAt - 'A') > 0) {
                    if ((cCharAt - 'z') * (cCharAt - 'a') > 0) {
                        continue;
                    } else if (cCharAt != 'e' && cCharAt != 'E') {
                        strTrim = str.substring(i12, i11).trim();
                        if (strTrim.isEmpty()) {
                            if (strTrim.charAt(i10) != 'z' || strTrim.charAt(i10) == 'Z') {
                                fArrM3487e = new float[i10];
                            } else {
                                try {
                                    float[] fArr = new float[strTrim.length()];
                                    int length = strTrim.length();
                                    int i13 = 1;
                                    int i14 = 0;
                                    while (i13 < length) {
                                        boolean z7 = false;
                                        boolean z10 = false;
                                        boolean z11 = false;
                                        boolean z12 = false;
                                        for (int i15 = i13; i15 < strTrim.length(); i15++) {
                                            char cCharAt2 = strTrim.charAt(i15);
                                            if (cCharAt2 == ' ') {
                                                z7 = false;
                                                z11 = true;
                                            } else if (cCharAt2 != 'E' && cCharAt2 != 'e') {
                                                switch (cCharAt2) {
                                                    case ',':
                                                        z7 = false;
                                                        z11 = true;
                                                        break;
                                                    case TsExtractor.TS_STREAM_TYPE_MHAS:
                                                        if (i15 == i13 || z7) {
                                                            z7 = false;
                                                        } else {
                                                            z7 = false;
                                                            z11 = true;
                                                            z12 = true;
                                                        }
                                                        break;
                                                    case '.':
                                                        if (z10) {
                                                            z7 = false;
                                                            z11 = true;
                                                            z12 = true;
                                                        } else {
                                                            z7 = false;
                                                            z10 = true;
                                                        }
                                                        break;
                                                    default:
                                                        z7 = false;
                                                        break;
                                                }
                                            } else {
                                                z7 = true;
                                            }
                                            if (z11) {
                                                if (i13 < i15) {
                                                    fArr[i14] = Float.parseFloat(strTrim.substring(i13, i15));
                                                    i14++;
                                                }
                                                if (z12) {
                                                    i13 = i15;
                                                } else {
                                                    i13 = i15 + 1;
                                                }
                                            }
                                        }
                                        if (i13 < i15) {
                                            fArr[i14] = Float.parseFloat(strTrim.substring(i13, i15));
                                            i14++;
                                        }
                                        if (z12) {
                                            i13 = i15;
                                        } else {
                                            i13 = i15 + 1;
                                        }
                                    }
                                    fArrM3487e = m3487e(fArr, i14);
                                    i10 = 0;
                                } catch (NumberFormatException e5) {
                                    throw new RuntimeException(AbstractC0004e.m24r("error in parsing \"", strTrim, "\""), e5);
                                }
                            }
                            arrayList.add(new C2483f(strTrim.charAt(i10), fArrM3487e));
                        }
                        i12 = i11;
                        i11++;
                        i10 = 0;
                    }
                } else if (cCharAt != 'e') {
                    continue;
                }
                i11++;
            }
            strTrim = str.substring(i12, i11).trim();
            if (strTrim.isEmpty()) {
                if (strTrim.charAt(i10) != 'z') {
                    fArrM3487e = new float[i10];
                } else {
                    fArrM3487e = new float[i10];
                }
                arrayList.add(new C2483f(strTrim.charAt(i10), fArrM3487e));
            }
            i12 = i11;
            i11++;
            i10 = 0;
        }
        if (i11 - i12 != 1 || i12 >= str.length()) {
            i6 = 0;
        } else {
            i6 = 0;
            arrayList.add(new C2483f(str.charAt(i12), new float[0]));
        }
        return (C2483f[]) arrayList.toArray(new C2483f[i6]);
    }

    public static Path m3489g(String str) {
        Path path = new Path();
        try {
            C2483f.m5520b(m3488f(str), path);
            return path;
        } catch (RuntimeException e5) {
            throw new RuntimeException("Error in parsing ".concat(str), e5);
        }
    }

    public static C2483f[] m3490h(C2483f[] c2483fArr) {
        C2483f[] c2483fArr2 = new C2483f[c2483fArr.length];
        for (int i6 = 0; i6 < c2483fArr.length; i6++) {
            c2483fArr2[i6] = new C2483f(c2483fArr[i6]);
        }
        return c2483fArr2;
    }

    public static InterfaceC0077g m3491i(InterfaceC0077g interfaceC0077g, InterfaceC0078h interfaceC0078h) {
        AbstractC2796i.m5785f(interfaceC0078h, CacheEntity.KEY);
        if (AbstractC2796i.m5780a(interfaceC0077g.getKey(), interfaceC0078h)) {
            return interfaceC0077g;
        }
        return null;
    }

    public static ColorStateList m3492j(Context context, C0026b c0026b, int i6) {
        int resourceId;
        ColorStateList colorStateListM7848k;
        TypedArray typedArray = (TypedArray) c0026b.f55c;
        return (!typedArray.hasValue(i6) || (resourceId = typedArray.getResourceId(i6, 0)) == 0 || (colorStateListM7848k = AbstractC3928d.m7848k(context, resourceId)) == null) ? c0026b.m139s(i6) : colorStateListM7848k;
    }

    public static ColorStateList m3493k(Context context, TypedArray typedArray, int i6) {
        int resourceId;
        ColorStateList colorStateListM7848k;
        return (!typedArray.hasValue(i6) || (resourceId = typedArray.getResourceId(i6, 0)) == 0 || (colorStateListM7848k = AbstractC3928d.m7848k(context, resourceId)) == null) ? typedArray.getColorStateList(i6) : colorStateListM7848k;
    }

    public static int m3494l(Context context, TypedArray typedArray, int i6, int i10) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i6, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i6, i10);
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, i10);
        typedArrayObtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static float m3495m(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return AbstractC0373f.m1124b(edgeEffect);
        }
        return 0.0f;
    }

    public static Drawable m3496n(Context context, TypedArray typedArray, int i6) {
        int resourceId;
        Drawable drawableM3473h;
        return (!typedArray.hasValue(i6) || (resourceId = typedArray.getResourceId(i6, 0)) == 0 || (drawableM3473h = AbstractC1465c.m3473h(context, resourceId)) == null) ? typedArray.getDrawable(i6) : drawableM3473h;
    }

    public static final Class m3497p(InterfaceC3384b interfaceC3384b) {
        AbstractC2796i.m5785f(interfaceC3384b, "<this>");
        Class clsMo5777a = ((InterfaceC2791d) interfaceC3384b).mo5777a();
        if (!clsMo5777a.isPrimitive()) {
            return clsMo5777a;
        }
        String name = clsMo5777a.getName();
        switch (name.hashCode()) {
            case -1325958191:
                return !name.equals("double") ? clsMo5777a : Double.class;
            case 104431:
                return !name.equals("int") ? clsMo5777a : Integer.class;
            case 3039496:
                return !name.equals("byte") ? clsMo5777a : Byte.class;
            case 3052374:
                return !name.equals("char") ? clsMo5777a : Character.class;
            case 3327612:
                return !name.equals("long") ? clsMo5777a : Long.class;
            case 3625364:
                return !name.equals("void") ? clsMo5777a : Void.class;
            case 64711720:
                return !name.equals("boolean") ? clsMo5777a : Boolean.class;
            case 97526364:
                return !name.equals("float") ? clsMo5777a : Float.class;
            case 109413500:
                return !name.equals("short") ? clsMo5777a : Short.class;
            default:
                return clsMo5777a;
        }
    }

    public static final Locale m3498q(Configuration configuration) {
        Locale locale;
        String str;
        AbstractC2796i.m5786g(configuration, "$this$getLocaleCompat");
        if (Build.VERSION.SDK_INT >= 24) {
            locale = configuration.getLocales().get(0);
            str = "locales.get(0)";
        } else {
            locale = configuration.locale;
            str = "locale";
        }
        AbstractC2796i.m5781b(locale, str);
        return locale;
    }

    public static InterfaceC0074d m3499r(InterfaceC0074d interfaceC0074d) {
        InterfaceC0074d<Object> interfaceC0074dIntercepted;
        AbstractC2796i.m5785f(interfaceC0074d, "<this>");
        AbstractC1433c abstractC1433c = interfaceC0074d instanceof AbstractC1433c ? (AbstractC1433c) interfaceC0074d : null;
        return (abstractC1433c == null || (interfaceC0074dIntercepted = abstractC1433c.intercepted()) == null) ? interfaceC0074d : interfaceC0074dIntercepted;
    }

    public static boolean m3500s(LinearLayout linearLayout, View view) {
        while (view != null) {
            if (view == linearLayout) {
                return true;
            }
            Object parent = view.getParent();
            if (!(parent instanceof View)) {
                return false;
            }
            view = (View) parent;
        }
        return false;
    }

    public static boolean m3501u(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static Integer m3502v(String str) {
        byte b8;
        if (str == null) {
            return null;
        }
        switch (str) {
            case "REPEAT_ALL_AND_SHUFFLE":
                b8 = 3;
                break;
            case "REPEAT_SINGLE":
                b8 = 2;
                break;
            case "REPEAT_ALL":
                b8 = 1;
                break;
            case "REPEAT_OFF":
                b8 = 0;
                break;
            default:
                b8 = -1;
                break;
        }
        if (b8 == 0) {
            return 0;
        }
        if (b8 == 1) {
            return 1;
        }
        if (b8 != 2) {
            return b8 != 3 ? null : 3;
        }
        return 2;
    }

    public static String m3503w(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str2.length() + str.length());
        for (int i6 = 0; i6 < str.length(); i6++) {
            sb.append(str.charAt(i6));
            if (str2.length() > i6) {
                sb.append(str2.charAt(i6));
            }
        }
        return sb.toString();
    }

    public static InterfaceC0079i m3504x(InterfaceC0077g interfaceC0077g, InterfaceC0078h interfaceC0078h) {
        AbstractC2796i.m5785f(interfaceC0078h, CacheEntity.KEY);
        return AbstractC2796i.m5780a(interfaceC0077g.getKey(), interfaceC0078h) ? C0080j.f206a : interfaceC0077g;
    }

    public static void m3505y(Throwable th) {
        if (th == null) {
            th = AbstractC3642a.m7372a("onError called with a null Throwable.");
        } else if (!(th instanceof C2903c) && !(th instanceof IllegalStateException) && !(th instanceof NullPointerException) && !(th instanceof IllegalArgumentException) && !(th instanceof C2902b)) {
            th = new C2904d("The exception could not be delivered to the consumer because it has already canceled/disposed the flow or the exception has nowhere to go to begin with. Further reading: https://github.com/ReactiveX/RxJava/wiki/What's-different-in-2.0#error-handling | " + th, th);
        }
        th.printStackTrace();
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }

    public static float m3506z(EdgeEffect edgeEffect, float f, float f3) {
        if (Build.VERSION.SDK_INT >= 31) {
            return AbstractC0373f.m1125c(edgeEffect, f, f3);
        }
        AbstractC0372e.m1122a(edgeEffect, f, f3);
        return f;
    }

    public abstract void mo3507B(C3573f c3573f, C3573f c3573f2);

    public abstract void mo3508C(C3573f c3573f, Thread thread);

    public abstract void mo3509E(boolean z7);

    public abstract void mo3510F(boolean z7);

    public abstract TransformationMethod mo3511I(TransformationMethod transformationMethod);

    public abstract boolean mo3512b(AbstractC3574g abstractC3574g, C3570c c3570c, C3570c c3570c2);

    public abstract boolean mo3513c(AbstractC3574g abstractC3574g, Object obj, Object obj2);

    public abstract boolean mo3514d(AbstractC3574g abstractC3574g, C3573f c3573f, C3573f c3573f2);

    public abstract InputFilter[] mo3515o(InputFilter[] inputFilterArr);

    public abstract boolean mo3516t();
}

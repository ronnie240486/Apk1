package p187r4;

import android.content.Context;
import android.icu.text.DateFormat;
import android.icu.util.TimeZone;
import android.os.Build;
import android.os.Trace;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AbstractC0289w3;
import androidx.appcompat.widget.ViewOnLongClickListenerC0299y3;
import androidx.leanback.transition.FadeAndShortSlide;
import androidx.lifecycle.AbstractC0541p;
import androidx.lifecycle.EnumC0539o;
import androidx.lifecycle.InterfaceC0553v;
import androidx.recyclerview.widget.AbstractC1135d0;
import androidx.recyclerview.widget.AbstractC1197x0;
import androidx.recyclerview.widget.C1162l1;
import com.bumptech.glide.AbstractC1466d;
import com.google.android.material.datepicker.AbstractC1787g0;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import p003a2.AbstractC0032a;
import p020b7.AbstractC1332b;
import p021b9.EnumC1367a;
import p030c9.AbstractC1431a;
import p030c9.AbstractC1433c;
import p070g7.AbstractC2616d;
import p070g7.C2615c;
import p091i9.InterfaceC2728p;
import p103j9.C2801n;
import p156o9.AbstractC3280d;
import p185r2.C3583b;
import p185r2.C3584c;
import p194s.C3678b;
import p194s.C3679c;
import p194s.C3682f;
import p213t9.AbstractC3815a;
import p213t9.C3827e;
import p243w8.C4070l;
import p254x9.AbstractC4159a;

public abstract class AbstractC3612b {

    public static long f12128a;

    public static Method f12129b;

    public static int m7251A(int[] iArr, int i6, int i10, int i11) {
        while (i10 < i11) {
            if (iArr[i10] == i6) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static boolean m7252B() {
        try {
            if (f12129b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        try {
            if (f12129b == null) {
                f12128a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f12129b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f12129b.invoke(null, Long.valueOf(f12128a))).booleanValue();
        } catch (Exception e5) {
            if (!(e5 instanceof InvocationTargetException)) {
                Log.v("Trace", "Unable to call isTagEnabled via reflection", e5);
                return false;
            }
            Throwable cause = e5.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
    }

    public static boolean m7253C(double d) {
        return Math.getExponent(d) <= 1023;
    }

    public static int m7254J(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        if (d < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d);
    }

    public static int m7255K(long j10) {
        if (j10 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j10 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j10;
    }

    public static void m7256L(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            AbstractC0289w3.m812a(view, charSequence);
            return;
        }
        ViewOnLongClickListenerC0299y3 viewOnLongClickListenerC0299y3 = ViewOnLongClickListenerC0299y3.f1136k;
        if (viewOnLongClickListenerC0299y3 != null && viewOnLongClickListenerC0299y3.f1138a == view) {
            ViewOnLongClickListenerC0299y3.m834b(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new ViewOnLongClickListenerC0299y3(view, charSequence);
            return;
        }
        ViewOnLongClickListenerC0299y3 viewOnLongClickListenerC0299y4 = ViewOnLongClickListenerC0299y3.f1137l;
        if (viewOnLongClickListenerC0299y4 != null && viewOnLongClickListenerC0299y4.f1138a == view) {
            viewOnLongClickListenerC0299y4.m835a();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public static void m7257M(InterfaceC2728p interfaceC2728p, AbstractC3815a abstractC3815a, AbstractC3815a abstractC3815a2) {
        try {
            AbstractC4159a.m8205f(AbstractC1466d.m3499r(((AbstractC1431a) interfaceC2728p).create(abstractC3815a, abstractC3815a2)), C4070l.f13734a, null);
        } catch (Throwable th) {
            abstractC3815a2.resumeWith(AbstractC3280d.m6588f(th));
            throw th;
        }
    }

    public static int[] m7258N(Collection collection) {
        if (collection instanceof C2615c) {
            C2615c c2615c = (C2615c) collection;
            return Arrays.copyOfRange(c2615c.f9096a, c2615c.f9097b, c2615c.f9098c);
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i6 = 0; i6 < length; i6++) {
            Object obj = array[i6];
            obj.getClass();
            iArr[i6] = ((Number) obj).intValue();
        }
        return iArr;
    }

    public static Integer m7259P(String str) {
        byte b8;
        Long lValueOf;
        byte b10;
        str.getClass();
        if (!str.isEmpty()) {
            int i6 = str.charAt(0) == '-' ? 1 : 0;
            if (i6 != str.length()) {
                int i10 = i6 + 1;
                char cCharAt = str.charAt(i6);
                if (cCharAt < 128) {
                    b8 = AbstractC2616d.f9099a[cCharAt];
                } else {
                    byte[] bArr = AbstractC2616d.f9099a;
                    b8 = -1;
                }
                if (b8 >= 0 && b8 < 10) {
                    long j10 = -b8;
                    long j11 = 10;
                    long j12 = Long.MIN_VALUE / j11;
                    while (true) {
                        if (i10 >= str.length()) {
                            if (i6 == 0) {
                                if (j10 != Long.MIN_VALUE) {
                                    lValueOf = Long.valueOf(-j10);
                                    break;
                                }
                                break;
                            }
                            lValueOf = Long.valueOf(j10);
                            break;
                        }
                        int i11 = i10 + 1;
                        char cCharAt2 = str.charAt(i10);
                        if (cCharAt2 < 128) {
                            b10 = AbstractC2616d.f9099a[cCharAt2];
                        } else {
                            byte[] bArr2 = AbstractC2616d.f9099a;
                            b10 = -1;
                        }
                        if (b10 >= 0 && b10 < 10 && j10 >= j12) {
                            long j13 = j10 * j11;
                            long j14 = b10;
                            if (j13 >= j14 - Long.MIN_VALUE) {
                                j10 = j13 - j14;
                                i10 = i11;
                            }
                        }
                        lValueOf = null;
                        break;
                    }
                }
                lValueOf = null;
                break;
            }
            lValueOf = null;
            break;
        }
        lValueOf = null;
        break;
        if (lValueOf == null || lValueOf.longValue() != lValueOf.intValue()) {
            return null;
        }
        return Integer.valueOf(lValueOf.intValue());
    }

    public static void m7260Q(StringBuilder sb, HashMap map) {
        sb.append("{");
        boolean z7 = true;
        for (String str : map.keySet()) {
            if (!z7) {
                sb.append(",");
            }
            String str2 = (String) map.get(str);
            sb.append("\"");
            sb.append(str);
            sb.append("\":");
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append("\"");
                sb.append(str2);
                sb.append("\"");
            }
            z7 = false;
        }
        sb.append("}");
    }

    public static List m7261a(int... iArr) {
        return iArr.length == 0 ? Collections.emptyList() : new C2615c(0, iArr.length, iArr);
    }

    public static final Object m7262b(AbstractC0541p abstractC0541p, AbstractC1433c abstractC1433c) throws Throwable {
        C3583b c3583b;
        AbstractC0541p abstractC0541p2;
        C2801n c2801n;
        Throwable th;
        InterfaceC0553v interfaceC0553v;
        InterfaceC0553v interfaceC0553v2;
        if (abstractC1433c instanceof C3583b) {
            c3583b = (C3583b) abstractC1433c;
            int i6 = c3583b.f12061d;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                c3583b.f12061d = i6 - Integer.MIN_VALUE;
            } else {
                c3583b = new C3583b(abstractC1433c);
            }
        } else {
            c3583b = new C3583b(abstractC1433c);
        }
        Object obj = c3583b.f12060c;
        EnumC1367a enumC1367a = EnumC1367a.f4179a;
        int i10 = c3583b.f12061d;
        C4070l c4070l = C4070l.f13734a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c2801n = c3583b.f12059b;
            abstractC0541p2 = c3583b.f12058a;
            try {
                AbstractC3280d.m6570I(obj);
                interfaceC0553v2 = (InterfaceC0553v) c2801n.f9540a;
                if (interfaceC0553v2 != null) {
                    abstractC0541p2.mo1510c(interfaceC0553v2);
                }
                return c4070l;
            } catch (Throwable th2) {
                th = th2;
                interfaceC0553v = (InterfaceC0553v) c2801n.f9540a;
                if (interfaceC0553v != null) {
                    abstractC0541p2.mo1510c(interfaceC0553v);
                }
                throw th;
            }
        }
        AbstractC3280d.m6570I(obj);
        if (abstractC0541p.mo1509b().compareTo(EnumC0539o.f2510d) >= 0) {
            return c4070l;
        }
        C2801n c2801n2 = new C2801n();
        try {
            c3583b.f12058a = abstractC0541p;
            c3583b.f12059b = c2801n2;
            c3583b.f12061d = 1;
            C3827e c3827e = new C3827e(AbstractC1466d.m3499r(c3583b), 1);
            c3827e.m7658n();
            C3584c c3584c = new C3584c(c3827e);
            c2801n2.f9540a = c3584c;
            abstractC0541p.mo1508a(c3584c);
            if (c3827e.m7657m() == enumC1367a) {
                return enumC1367a;
            }
            abstractC0541p2 = abstractC0541p;
            c2801n = c2801n2;
            interfaceC0553v2 = (InterfaceC0553v) c2801n.f9540a;
            if (interfaceC0553v2 != null) {
                abstractC0541p2.mo1510c(interfaceC0553v2);
            }
            return c4070l;
        } catch (Throwable th3) {
            abstractC0541p2 = abstractC0541p;
            c2801n = c2801n2;
            th = th3;
            interfaceC0553v = (InterfaceC0553v) c2801n.f9540a;
            if (interfaceC0553v != null) {
                abstractC0541p2.mo1510c(interfaceC0553v);
            }
            throw th;
        }
    }

    public static int m7263c(long j10) {
        int i6 = (int) j10;
        AbstractC1332b.m3216g(((long) i6) == j10, "Out of range: %s", j10);
        return i6;
    }

    public static int m7264f(C1162l1 c1162l1, AbstractC1135d0 abstractC1135d0, View view, View view2, AbstractC1197x0 abstractC1197x0, boolean z7) {
        if (abstractC1197x0.getChildCount() == 0 || c1162l1.m2970b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z7) {
            return Math.abs(abstractC1197x0.getPosition(view) - abstractC1197x0.getPosition(view2)) + 1;
        }
        return Math.min(abstractC1135d0.mo2893l(), abstractC1135d0.mo2883b(view2) - abstractC1135d0.mo2886e(view));
    }

    public static int m7265g(C1162l1 c1162l1, AbstractC1135d0 abstractC1135d0, View view, View view2, AbstractC1197x0 abstractC1197x0, boolean z7, boolean z10) {
        if (abstractC1197x0.getChildCount() == 0 || c1162l1.m2970b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z10 ? Math.max(0, (c1162l1.m2970b() - Math.max(abstractC1197x0.getPosition(view), abstractC1197x0.getPosition(view2))) - 1) : Math.max(0, Math.min(abstractC1197x0.getPosition(view), abstractC1197x0.getPosition(view2)));
        if (z7) {
            return Math.round((iMax * (Math.abs(abstractC1135d0.mo2883b(view2) - abstractC1135d0.mo2886e(view)) / (Math.abs(abstractC1197x0.getPosition(view) - abstractC1197x0.getPosition(view2)) + 1))) + (abstractC1135d0.mo2892k() - abstractC1135d0.mo2886e(view)));
        }
        return iMax;
    }

    public static int m7266h(C1162l1 c1162l1, AbstractC1135d0 abstractC1135d0, View view, View view2, AbstractC1197x0 abstractC1197x0, boolean z7) {
        if (abstractC1197x0.getChildCount() == 0 || c1162l1.m2970b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z7) {
            return c1162l1.m2970b();
        }
        return (int) (((abstractC1135d0.mo2883b(view2) - abstractC1135d0.mo2886e(view)) / (Math.abs(abstractC1197x0.getPosition(view) - abstractC1197x0.getPosition(view2)) + 1)) * c1162l1.m2970b());
    }

    public static int m7267i(int i6, int i10) {
        AbstractC1332b.m3213d("min (%s) must be less than or equal to max (%s)", i10, 1073741823, i10 <= 1073741823);
        return Math.min(Math.max(i6, i10), 1073741823);
    }

    public static long[] m7268j(Serializable serializable) {
        if (!(serializable instanceof int[])) {
            if (serializable instanceof long[]) {
                return (long[]) serializable;
            }
            return null;
        }
        int[] iArr = (int[]) serializable;
        long[] jArr = new long[iArr.length];
        for (int i6 = 0; i6 < iArr.length; i6++) {
            jArr[i6] = iArr[i6];
        }
        return jArr;
    }

    public static AbstractC3612b m7269k(int i6, double[] dArr, double[][] dArr2) {
        int i10 = dArr.length == 1 ? 2 : i6;
        double d = 0.0d;
        if (i10 != 0) {
            if (i10 == 2) {
                double d10 = dArr[0];
                double[] dArr3 = dArr2[0];
                C3679c c3679c = new C3679c();
                c3679c.f12315c = d10;
                c3679c.f12316d = dArr3;
                return c3679c;
            }
            C3678b c3678b = new C3678b();
            int length = dArr2[0].length;
            c3678b.f12313d = dArr;
            c3678b.f12314e = dArr2;
            if (length > 2) {
                double d11 = 0.0d;
                int i11 = 0;
                while (i11 < dArr.length) {
                    double d12 = dArr2[i11][0];
                    if (i11 > 0) {
                        Math.hypot(d12 - d, d12 - d11);
                    }
                    i11++;
                    d11 = d12;
                    d = d11;
                }
            }
            return c3678b;
        }
        C3682f c3682f = new C3682f();
        int length2 = dArr.length;
        int length3 = dArr2[0].length;
        int i12 = length2 - 1;
        Class cls = Double.TYPE;
        double[][] dArr4 = (double[][]) Array.newInstance((Class<?>) cls, i12, length3);
        double[][] dArr5 = (double[][]) Array.newInstance((Class<?>) cls, length2, length3);
        for (int i13 = 0; i13 < length3; i13++) {
            int i14 = 0;
            while (i14 < i12) {
                int i15 = i14 + 1;
                double d13 = dArr[i15] - dArr[i14];
                double[] dArr6 = dArr4[i14];
                double d14 = (dArr2[i15][i13] - dArr2[i14][i13]) / d13;
                dArr6[i13] = d14;
                if (i14 == 0) {
                    dArr5[i14][i13] = d14;
                } else {
                    dArr5[i14][i13] = (dArr4[i14 - 1][i13] + d14) * 0.5d;
                }
                i14 = i15;
            }
            dArr5[i12][i13] = dArr4[length2 - 2][i13];
        }
        int i16 = 0;
        while (i16 < i12) {
            int i17 = 0;
            while (i17 < length3) {
                double d15 = dArr4[i16][i17];
                if (d15 == d) {
                    dArr5[i16][i17] = d;
                    dArr5[i16 + 1][i17] = d;
                } else {
                    double d16 = dArr5[i16][i17] / d15;
                    int i18 = i16 + 1;
                    double d17 = dArr5[i18][i17] / d15;
                    double dHypot = Math.hypot(d16, d17);
                    if (dHypot > 9.0d) {
                        double d18 = 3.0d / dHypot;
                        double[] dArr7 = dArr5[i16];
                        double[] dArr8 = dArr4[i16];
                        dArr7[i17] = d16 * d18 * dArr8[i17];
                        dArr5[i18][i17] = d18 * d17 * dArr8[i17];
                    }
                }
                i17++;
                d = 0.0d;
            }
            i16++;
            d = 0.0d;
        }
        c3682f.f12324c = dArr;
        c3682f.f12325d = dArr2;
        c3682f.f12326e = dArr5;
        return c3682f;
    }

    public static String m7270l(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), AbstractC0032a.m165s("MdRqUyFoK1Y53g==\n", "ULoOIU4BTwk=\n"));
        return (string == null || string.isEmpty()) ? AbstractC0032a.m165s("7/Y4\n", "i59cz71wKwk=\n") : string;
    }

    public static String m7271m(long j10) {
        Calendar calendarM4198g = AbstractC1787g0.m4198g();
        Calendar calendarM4199h = AbstractC1787g0.m4199h(null);
        calendarM4199h.setTimeInMillis(j10);
        return calendarM4198g.get(1) == calendarM4199h.get(1) ? m7272p(j10, Locale.getDefault()) : m7274z(j10, Locale.getDefault());
    }

    public static String m7272p(long j10, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            AtomicReference atomicReference = AbstractC1787g0.f6165a;
            DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton("MMMd", locale);
            instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
            return instanceForSkeleton.format(new Date(j10));
        }
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) AbstractC1787g0.m4195d(2, locale);
        String pattern = simpleDateFormat.toPattern();
        int iM4193b = AbstractC1787g0.m4193b(1, 0, pattern, "yY");
        if (iM4193b < pattern.length()) {
            int iM4193b2 = AbstractC1787g0.m4193b(1, iM4193b, pattern, "EMd");
            pattern = pattern.replace(pattern.substring(AbstractC1787g0.m4193b(-1, iM4193b, pattern, iM4193b2 < pattern.length() ? "EMd," : "EMd") + 1, iM4193b2), " ").trim();
        }
        simpleDateFormat.applyPattern(pattern);
        return simpleDateFormat.format(new Date(j10));
    }

    public static long m7273t(double d) {
        AbstractC1332b.m3214e("not a normal value", m7253C(d));
        int exponent = Math.getExponent(d);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d) & 4503599627370495L;
        return exponent == -1023 ? jDoubleToRawLongBits << 1 : jDoubleToRawLongBits | 4503599627370496L;
    }

    public static String m7274z(long j10, Locale locale) {
        if (Build.VERSION.SDK_INT < 24) {
            return AbstractC1787g0.m4195d(2, locale).format(new Date(j10));
        }
        AtomicReference atomicReference = AbstractC1787g0.f6165a;
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton("yMMMd", locale);
        instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
        return instanceForSkeleton.format(new Date(j10));
    }

    public abstract void mo209G(int i6);

    public abstract void mo210H(View view, int i6, int i10);

    public abstract void mo211I(View view, float f, float f3);

    public abstract boolean mo212O(int i6, View view);

    public abstract int mo213d(int i6, View view);

    public abstract int mo214e(int i6, View view);

    public float mo1343n(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
        return view.getTranslationX();
    }

    public float mo1344o(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
        return view.getTranslationY();
    }

    public abstract double mo7275q(double d);

    public abstract void mo7276r(double d, double[] dArr);

    public abstract void mo7277s(double d, float[] fArr);

    public abstract double mo7278u(double d);

    public abstract void mo7279v(double d, double[] dArr);

    public abstract double[] mo7280w();

    public int mo215x(View view) {
        return 0;
    }

    public int mo3268y() {
        return 0;
    }

    public void mo1179E() {
    }

    public void mo1178D(int i6, int i10) {
    }

    public void mo208F(int i6, View view) {
    }
}

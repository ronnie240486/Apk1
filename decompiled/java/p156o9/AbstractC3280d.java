package p156o9;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.LongSparseArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ProgressBar;
import androidx.appcompat.app.AbstractC0153p0;
import androidx.recyclerview.widget.AbstractC1174p1;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.AbstractC1465c;
import com.bumptech.glide.AbstractC1466d;
import com.p2serv.android.p032ds.R;
import com.tencent.mars.xlog.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.bitspark.android.utils.AbstractC3331m;
import p000a.AbstractC0004e;
import p003a2.AbstractC0032a;
import p034d0.AbstractC2115a;
import p046e0.AbstractC2350i;
import p046e0.AbstractC2355n;
import p055ea.AbstractC2460q;
import p056f0.AbstractC2478a;
import p063fa.AbstractC2531i0;
import p065g0.AbstractC2581a;
import p090i8.AbstractC2707a;
import p090i8.AbstractC2712f;
import p090i8.InterfaceC2709c;
import p093j.C2743d;
import p100j6.C2779a;
import p103j9.AbstractC2796i;
import p121l3.InterfaceC2971a;
import p138n0.AbstractC3119g0;
import p138n0.AbstractC3155s0;
import p138n0.InterfaceC3105b1;
import p143n5.AbstractC3198d;
import p169p8.C3380e;
import p221u6.C3904d;
import p221u6.C3907g;
import p221u6.C3908h;
import p221u6.C3911k;
import p222u7.AbstractC3928d;
import p243w8.C4065g;
import p253x8.AbstractC4147j;
import p253x8.C4155r;
import p253x8.C4156s;

public abstract class AbstractC3280d implements InterfaceC3105b1 {

    public static Field f10975a = null;

    public static boolean f10976b = false;

    public static Class f10977c = null;

    public static boolean f10978d = false;

    public static Field f10979e = null;

    public static boolean f10980f = false;

    public static Field f10981g = null;

    public static boolean f10982h = false;

    public static volatile boolean f10983i = true;

    public static void m6564A(RecyclerView recyclerView, AbstractC2531i0 abstractC2531i0, int i6) {
        recyclerView.scrollToPosition(i6);
        AbstractC1174p1 abstractC1174p1FindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i6);
        String strM165s = AbstractC0032a.m165s("bMp0gfaxPnlf0Q==\n", "OqMR9r7UUgk=\n");
        String str = AbstractC0032a.m165s("dwuZM2CiyOZxC4V8JfE=\n", "BW7oRgXRvK8=\n") + i6 + AbstractC0032a.m165s("Jzk2/wCN8g==\n", "Tkpll2/6nGg=\n") + abstractC1174p1FindViewHolderForAdapterPosition;
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, str);
        if (abstractC1174p1FindViewHolderForAdapterPosition != null) {
            m6606y(abstractC1174p1FindViewHolderForAdapterPosition.itemView);
        } else {
            abstractC2531i0.f8817a = i6;
        }
    }

    public static void m6565B(ViewGroup viewGroup, float f) {
        Drawable background = viewGroup.getBackground();
        if (background instanceof C3908h) {
            ((C3908h) background).m7808m(f);
        }
    }

    public static void m6566C(Context context, ProgressBar progressBar) {
        if (progressBar.isIndeterminate()) {
            progressBar.getIndeterminateDrawable().setColorFilter(AbstractC3928d.m7847i(context, m6602t(context) ? R.color.mr_cast_progressbar_progress_and_thumb_light : R.color.mr_cast_progressbar_progress_and_thumb_dark), PorterDuff.Mode.SRC_IN);
        }
    }

    public static void m6567D(View view, C3908h c3908h) {
        C2779a c2779a = c3908h.f13126a.f13108b;
        if (c2779a == null || !c2779a.f9493a) {
            return;
        }
        float fM6170i = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            fM6170i += AbstractC3119g0.m6170i((View) parent);
        }
        C3907g c3907g = c3908h.f13126a;
        if (c3907g.f13118l != fM6170i) {
            c3907g.f13118l = fM6170i;
            c3908h.m7817v();
        }
    }

    public static void m6568E(ViewGroup viewGroup) {
        Drawable background = viewGroup.getBackground();
        if (background instanceof C3908h) {
            m6567D(viewGroup, (C3908h) background);
        }
    }

    public static void m6569H(Class cls, ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException(AbstractC0004e.m23q(cls, "Unable to instantiate GlideModule implementation for "), reflectiveOperationException);
    }

    public static final void m6570I(Object obj) {
        if (obj instanceof C4065g) {
            throw ((C4065g) obj).f13729a;
        }
    }

    public static final List m6571J(List list) {
        int size = list.size();
        if (size != 0) {
            return size != 1 ? Collections.unmodifiableList(new ArrayList(list)) : Collections.singletonList(AbstractC4147j.m8181U(list));
        }
        return C4155r.f14074a;
    }

    public static final Map m6572K(Map map) {
        int size = map.size();
        if (size == 0) {
            return C4156s.f14075a;
        }
        if (size != 1) {
            return Collections.unmodifiableMap(new LinkedHashMap(map));
        }
        Map.Entry entry = (Map.Entry) AbstractC4147j.m8180T(map.entrySet());
        return Collections.singletonMap(entry.getKey(), entry.getValue());
    }

    public static void m6573L(Parcel parcel, int i6, Boolean bool) {
        if (bool == null) {
            return;
        }
        m6585X(parcel, i6, 4);
        parcel.writeInt(bool.booleanValue() ? 1 : 0);
    }

    public static void m6574M(Parcel parcel, int i6, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        int iM6583V = m6583V(parcel, i6);
        parcel.writeBundle(bundle);
        m6584W(parcel, iM6583V);
    }

    public static void m6575N(Parcel parcel, int i6, IBinder iBinder) {
        if (iBinder == null) {
            return;
        }
        int iM6583V = m6583V(parcel, i6);
        parcel.writeStrongBinder(iBinder);
        m6584W(parcel, iM6583V);
    }

    public static void m6576O(Parcel parcel, int i6, int[] iArr) {
        if (iArr == null) {
            return;
        }
        int iM6583V = m6583V(parcel, i6);
        parcel.writeIntArray(iArr);
        m6584W(parcel, iM6583V);
    }

    public static void m6577P(Parcel parcel, int i6, long[] jArr) {
        if (jArr == null) {
            return;
        }
        int iM6583V = m6583V(parcel, i6);
        parcel.writeLongArray(jArr);
        m6584W(parcel, iM6583V);
    }

    public static void m6578Q(Parcel parcel, int i6, Parcelable parcelable, int i10) {
        if (parcelable == null) {
            return;
        }
        int iM6583V = m6583V(parcel, i6);
        parcelable.writeToParcel(parcel, i10);
        m6584W(parcel, iM6583V);
    }

    public static void m6579R(Parcel parcel, int i6, String str) {
        if (str == null) {
            return;
        }
        int iM6583V = m6583V(parcel, i6);
        parcel.writeString(str);
        m6584W(parcel, iM6583V);
    }

    public static void m6580S(Parcel parcel, int i6, List list) {
        if (list == null) {
            return;
        }
        int iM6583V = m6583V(parcel, i6);
        parcel.writeStringList(list);
        m6584W(parcel, iM6583V);
    }

    public static void m6581T(Parcel parcel, int i6, Parcelable[] parcelableArr, int i10) {
        if (parcelableArr == null) {
            return;
        }
        int iM6583V = m6583V(parcel, i6);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, i10);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        m6584W(parcel, iM6583V);
    }

    public static void m6582U(Parcel parcel, int i6, List list) {
        if (list == null) {
            return;
        }
        int iM6583V = m6583V(parcel, i6);
        int size = list.size();
        parcel.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            Parcelable parcelable = (Parcelable) list.get(i10);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, 0);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        m6584W(parcel, iM6583V);
    }

    public static int m6583V(Parcel parcel, int i6) {
        parcel.writeInt(i6 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void m6584W(Parcel parcel, int i6) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i6 - 4);
        parcel.writeInt(iDataPosition - i6);
        parcel.setDataPosition(iDataPosition);
    }

    public static void m6585X(Parcel parcel, int i6, int i10) {
        parcel.writeInt(i6 | (i10 << 16));
    }

    public static void m6586d(int i6) {
        if (2 > i6 || i6 >= 37) {
            StringBuilder sbM27u = AbstractC0004e.m27u(i6, "radix ", " was not in valid range ");
            sbM27u.append(new C3284h(2, 36, 1));
            throw new IllegalArgumentException(sbM27u.toString());
        }
    }

    public static AbstractC3198d m6587e(int i6) {
        if (i6 != 0) {
            return i6 != 1 ? new C3911k() : new C3904d();
        }
        return new C3911k();
    }

    public static final C4065g m6588f(Throwable th) {
        AbstractC2796i.m5785f(th, "exception");
        return new C4065g(th);
    }

    public static ContextThemeWrapper m6589g(Context context, boolean z7) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, m6601s(context, !z7 ? R.attr.dialogTheme : R.attr.alertDialogTheme));
        return m6601s(contextThemeWrapper, R.attr.mediaRouteTheme) != 0 ? new ContextThemeWrapper(contextThemeWrapper, m6599q(contextThemeWrapper)) : contextThemeWrapper;
    }

    public static int m6590h(ContextThemeWrapper contextThemeWrapper) {
        int iM6601s = m6601s(contextThemeWrapper, R.attr.mediaRouteTheme);
        return iM6601s == 0 ? m6599q(contextThemeWrapper) : iM6601s;
    }

    public static void m6591i(String str, String str2, Object obj) {
        android.util.Log.d("TransportRuntime.".concat(str), String.format(str2, obj));
    }

    public static final boolean m6592j(char c5, char c8, boolean z7) {
        if (c5 == c8) {
            return true;
        }
        if (!z7) {
            return false;
        }
        char upperCase = Character.toUpperCase(c5);
        char upperCase2 = Character.toUpperCase(c8);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static void m6593k(Object obj) {
        LongSparseArray longSparseArray;
        if (!f10978d) {
            try {
                f10977c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e5) {
                android.util.Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e5);
            }
            f10978d = true;
        }
        Class cls = f10977c;
        if (cls == null) {
            return;
        }
        if (!f10980f) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                f10979e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e10) {
                android.util.Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e10);
            }
            f10980f = true;
        }
        Field field = f10979e;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e11) {
            android.util.Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e11);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            AbstractC0153p0.m436a(longSparseArray);
        }
    }

    public static int m6594l(Context context, int i6) {
        return AbstractC2478a.m5508c(-1, m6600r(context, i6, R.attr.colorPrimary)) >= 3.0d ? -1 : -570425344;
    }

    public static float m6595m(Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(android.R.attr.disabledAlpha, typedValue, true)) {
            return typedValue.getFloat();
        }
        return 0.5f;
    }

    public static Drawable m6596n(Context context, Context context2, int i6, Resources.Theme theme) {
        try {
            if (f10983i) {
                return m6603u(context2, i6, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e5) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e5;
            }
            return AbstractC2115a.m5069b(context2, i6);
        } catch (NoClassDefFoundError unused2) {
            f10983i = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        Resources resources = context2.getResources();
        ThreadLocal threadLocal = AbstractC2355n.f8209a;
        return AbstractC2350i.m5332a(resources, i6, theme);
    }

    public static Drawable m6597o(Context context, int i6) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{i6});
        Drawable drawableM6448W = AbstractC3198d.m6448W(AbstractC1465c.m3473h(context, typedArrayObtainStyledAttributes.getResourceId(0, 0)));
        if (m6602t(context)) {
            AbstractC2581a.m5585g(drawableM6448W, AbstractC3928d.m7847i(context, R.color.mr_dynamic_dialog_icon_light));
        }
        typedArrayObtainStyledAttributes.recycle();
        return drawableM6448W;
    }

    public static final int m6598p(int i6, int i10, int i11) {
        if (i11 > 0) {
            if (i6 >= i10) {
                return i10;
            }
            int i12 = i10 % i11;
            if (i12 < 0) {
                i12 += i11;
            }
            int i13 = i6 % i11;
            if (i13 < 0) {
                i13 += i11;
            }
            int i14 = (i12 - i13) % i11;
            if (i14 < 0) {
                i14 += i11;
            }
            return i10 - i14;
        }
        if (i11 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        }
        if (i6 <= i10) {
            return i10;
        }
        int i15 = -i11;
        int i16 = i6 % i15;
        if (i16 < 0) {
            i16 += i15;
        }
        int i17 = i10 % i15;
        if (i17 < 0) {
            i17 += i15;
        }
        int i18 = (i16 - i17) % i15;
        if (i18 < 0) {
            i18 += i15;
        }
        return i10 + i18;
    }

    public static int m6599q(Context context) {
        if (m6602t(context)) {
            return m6594l(context, 0) == -570425344 ? R.style.Theme_MediaRouter_Light : R.style.Theme_MediaRouter_Light_DarkControlPanel;
        }
        return m6594l(context, 0) == -570425344 ? R.style.Theme_MediaRouter_LightControlPanel : R.style.Theme_MediaRouter;
    }

    public static int m6600r(Context context, int i6, int i10) {
        if (i6 != 0) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i6, new int[]{i10});
            int color = typedArrayObtainStyledAttributes.getColor(0, 0);
            typedArrayObtainStyledAttributes.recycle();
            if (color != 0) {
                return color;
            }
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i10, typedValue, true);
        return typedValue.resourceId != 0 ? context.getResources().getColor(typedValue.resourceId) : typedValue.data;
    }

    public static int m6601s(Context context, int i6) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i6, typedValue, true)) {
            return typedValue.resourceId;
        }
        return 0;
    }

    public static boolean m6602t(Context context) {
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(R.attr.isLightTheme, typedValue, true) && typedValue.data != 0;
    }

    public static Drawable m6603u(Context context, int i6, Resources.Theme theme) {
        if (theme != null) {
            C2743d c2743d = new C2743d(context);
            c2743d.f9411b = theme;
            c2743d.m5708a(theme.getResources().getConfiguration());
            context = c2743d;
        }
        return AbstractC1465c.m3473h(context, i6);
    }

    public static InterfaceC2971a m6604w(String str) {
        try {
            Class<?> cls = Class.forName(str);
            try {
                Object objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
                if (objNewInstance instanceof InterfaceC2971a) {
                    return (InterfaceC2971a) objNewInstance;
                }
                throw new RuntimeException(AbstractC2460q.m5493g(objNewInstance, "Expected instanceof GlideModule, but found: "));
            } catch (IllegalAccessException e5) {
                m6569H(cls, e5);
                throw null;
            } catch (InstantiationException e10) {
                m6569H(cls, e10);
                throw null;
            } catch (NoSuchMethodException e11) {
                m6569H(cls, e11);
                throw null;
            } catch (InvocationTargetException e12) {
                m6569H(cls, e12);
                throw null;
            }
        } catch (ClassNotFoundException e13) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e13);
        }
    }

    public static void m6605x(AnimatorSet animatorSet, ArrayList arrayList) {
        int size = arrayList.size();
        long jMax = 0;
        for (int i6 = 0; i6 < size; i6++) {
            Animator animator = (Animator) arrayList.get(i6);
            jMax = Math.max(jMax, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 0);
        valueAnimatorOfInt.setDuration(jMax);
        arrayList.add(0, valueAnimatorOfInt);
        animatorSet.playTogether(arrayList);
    }

    public static boolean m6606y(View view) {
        if (view == null) {
            return false;
        }
        boolean zRequestFocus = view.requestFocus();
        String strM165s = AbstractC0032a.m165s("fPiWAqZnlN9P4w==\n", "KpHzde4C+K8=\n");
        String str = AbstractC0032a.m165s("EsOnJTiw8Owh2OIgFaTp+TfehD0ToO+mZA==\n", "RKrCUnDVnJw=\n") + zRequestFocus + AbstractC0032a.m165s("PTDqLYTmVsE9MOothA==\n", "AA3XELnba/w=\n") + view + AbstractC0032a.m165s("/yBQQIJZHSr/IA==\n", "wh1tfb9kIBc=\n") + view.getId();
        boolean z7 = AbstractC3331m.f11244b;
        Log.m5049i(strM165s, str);
        return zRequestFocus;
    }

    public static void m6607z(RecyclerView recyclerView, int i6) {
        if (i6 < recyclerView.getAdapter().getItemCount()) {
            recyclerView.scrollToPosition(i6);
            AbstractC1174p1 abstractC1174p1FindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i6);
            String strM165s = AbstractC0032a.m165s("wnF6qIFAHkXxag==\n", "lBgf38klcjU=\n");
            String str = AbstractC0032a.m165s("5hOXyal/pefgE4uG7Cw=\n", "lHbmvMwM0a4=\n") + i6 + AbstractC0032a.m165s("QQtq4YHa5g==\n", "KHg5ie6tiDg=\n") + abstractC1174p1FindViewHolderForAdapterPosition;
            boolean z7 = AbstractC3331m.f11244b;
            Log.m5049i(strM165s, str);
            if (abstractC1174p1FindViewHolderForAdapterPosition != null) {
                m6606y(abstractC1174p1FindViewHolderForAdapterPosition.itemView);
            }
        }
    }

    public void m6608F(InterfaceC2709c interfaceC2709c) {
        try {
            mo6609G(interfaceC2709c);
        } catch (NullPointerException e5) {
            throw e5;
        } catch (Throwable th) {
            AbstractC1466d.m3484G(th);
            AbstractC1466d.m3505y(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public abstract void mo6609G(InterfaceC2709c interfaceC2709c);

    public C3380e m6610v(AbstractC2712f abstractC2712f) {
        int i6 = AbstractC2707a.f9398a;
        if (i6 > 0) {
            return new C3380e(this, abstractC2712f, i6);
        }
        throw new IllegalArgumentException(AbstractC0004e.m20n(i6, "bufferSize > 0 required but it was "));
    }

    @Override
    public void mo633b() {
    }

    @Override
    public void mo464c() {
    }
}

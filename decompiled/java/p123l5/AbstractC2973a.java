package p123l5;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import androidx.core.widget.AbstractC0380m;
import androidx.fragment.app.C0423q;
import com.p2serv.android.p032ds.R;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipException;
import org.bitspark.android.Spark;
import p000a.AbstractC0004e;
import p005a4.C0049h;
import p007a7.C0069f;
import p025c2.C1382c;
import p025c2.C1384e;
import p025c2.C1385f;
import p025c2.C1386g;
import p025c2.C1391l;
import p043d9.AbstractC2337a;
import p046e0.C2347f;
import p054e9.AbstractC2427a;
import p093j.AbstractC2740a;
import p103j9.AbstractC2796i;
import p106k0.C2859g;
import p138n0.AbstractC3155s0;
import p138n0.C3152r0;
import p138n0.C3169x0;
import p138n0.InterfaceC3133l;
import p140n2.EnumC3182g;
import p143n5.AbstractC3198d;
import p181q9.C3546d;
import p184r1.C3581e;
import p216u0.C3888a;
import p222u7.AbstractC3928d;
import p243w8.C4067i;
import p249x4.C4112e;
import p253x8.AbstractC4148k;
import p253x8.C4155r;
import p261y4.InterfaceC4255c;
import p261y4.InterfaceC4260h;
import p261y4.InterfaceC4261i;
import p271z4.C4343n;

public abstract class AbstractC2973a {

    public static Context f10173a;

    public static Boolean f10174b;

    public static Method f10175c;

    public static boolean f10176d;

    public static Field f10177e;

    public static boolean f10178f;

    public static Boolean f10179g;

    public static Boolean f10180h;

    public static Boolean f10181i;

    public static Boolean f10182j;

    public static Boolean f10183k;

    public static Boolean f10184l;

    public static Boolean f10185m;

    public static boolean f10186n;

    public static Method f10187o;

    public static boolean f10188p;

    public static Field f10189q;

    public AbstractC2973a() {
        new ConcurrentHashMap();
    }

    public static boolean m6010A(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f10185m == null) {
            f10185m = Boolean.valueOf(packageManager.hasSystemFeature("com.google.android.tv") || packageManager.hasSystemFeature("android.hardware.type.television") || packageManager.hasSystemFeature("android.software.leanback"));
        }
        return f10185m.booleanValue();
    }

    public static void m6011M(PopupWindow popupWindow, boolean z7) {
        if (Build.VERSION.SDK_INT >= 23) {
            AbstractC0380m.m1142c(popupWindow, z7);
            return;
        }
        if (!f10178f) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                f10177e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e5) {
                Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e5);
            }
            f10178f = true;
        }
        Field field = f10177e;
        if (field != null) {
            try {
                field.set(popupWindow, Boolean.valueOf(z7));
            } catch (IllegalAccessException e10) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e10);
            }
        }
    }

    public static void m6012Q(PopupWindow popupWindow, int i6) {
        if (Build.VERSION.SDK_INT >= 23) {
            AbstractC0380m.m1143d(popupWindow, i6);
            return;
        }
        if (!f10176d) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                f10175c = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            f10176d = true;
        }
        Method method = f10175c;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(i6));
            } catch (Exception unused2) {
            }
        }
    }

    public static void m6013a(Throwable th, Throwable th2) {
        AbstractC2796i.m5785f(th, "<this>");
        AbstractC2796i.m5785f(th2, "exception");
        if (th != th2) {
            Integer num = AbstractC2427a.f8492a;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(th2);
                return;
            }
            Method method = AbstractC2337a.f8137a;
            if (method != null) {
                method.invoke(th, th2);
            }
        }
    }

    public static void m6014b(Spark spark, SeekBar seekBar) {
        int iM7847i = AbstractC3928d.m7847i(spark, R.color.seekbar_second);
        int iM7847i2 = AbstractC3928d.m7847i(spark, R.color.player_sub_option_text_color_selected);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        float fM6469q = AbstractC3198d.m6469q(spark, 2);
        gradientDrawable.setCornerRadius(fM6469q);
        gradientDrawable.setColor(iM7847i);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius(fM6469q);
        gradientDrawable2.setColor(iM7847i);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable2, 8388611, 1);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setShape(0);
        gradientDrawable3.setCornerRadius(fM6469q);
        gradientDrawable3.setColor(iM7847i2);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 8388611, 1)});
        layerDrawable.setId(0, android.R.id.background);
        layerDrawable.setId(1, android.R.id.secondaryProgress);
        layerDrawable.setId(2, android.R.id.progress);
        seekBar.setProgressDrawable(layerDrawable);
    }

    public static final void m6015e(View view) {
        AbstractC2796i.m5785f(view, "<this>");
        C3169x0 c3169x0 = new C3169x0(view, null);
        C3546d c3546d = new C3546d();
        c3546d.f11950d = c3169x0.create(c3546d, c3546d);
        while (c3546d.hasNext()) {
            View view2 = (View) c3546d.next();
            C3888a c3888a = (C3888a) view2.getTag(R.id.pooling_container_listener_holder_tag);
            if (c3888a == null) {
                c3888a = new C3888a();
                view2.setTag(R.id.pooling_container_listener_holder_tag, c3888a);
            }
            ArrayList arrayList = c3888a.f13074a;
            int iM8191O = AbstractC4148k.m8191O(arrayList);
            if (-1 < iM8191O) {
                throw AbstractC0004e.m17k(iM8191O, arrayList);
            }
        }
    }

    public static int m6016g(int i6, int i10, int i11) {
        if (i6 < i10) {
            return i10;
        }
        return i6 > i11 ? i11 : i6;
    }

    public static final double m6017j(int i6, int i10, int i11, int i12, EnumC3182g enumC3182g) {
        double d = ((double) i11) / ((double) i6);
        double d10 = ((double) i12) / ((double) i10);
        int iOrdinal = enumC3182g.ordinal();
        if (iOrdinal == 0) {
            return Math.max(d, d10);
        }
        if (iOrdinal == 1) {
            return Math.min(d, d10);
        }
        throw new C0423q(13);
    }

    public static final C1391l m6018k(Context context) {
        C1386g c1386g = new C1386g(context);
        C4067i c4067i = new C4067i(new C1384e(c1386g, 0));
        C4067i c4067i2 = new C4067i(new C1384e(c1386g, 1));
        C4067i c4067i3 = new C4067i(C1385f.f4211a);
        C4155r c4155r = C4155r.f14074a;
        return new C1391l(c1386g.f4212a, c1386g.f4213b, c4067i, c4067i2, c4067i3, new C1382c(c4155r, c4155r, c4155r, c4155r, c4155r), c1386g.f4214c);
    }

    public static boolean m6019p(View view, KeyEvent keyEvent) {
        ArrayList arrayList;
        int size;
        int iIndexOfKey;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList2 = C3152r0.f10636d;
        C3152r0 c3152r0 = (C3152r0) view.getTag(R.id.tag_unhandled_key_event_manager);
        WeakReference weakReference = null;
        if (c3152r0 == null) {
            c3152r0 = new C3152r0();
            c3152r0.f10637a = null;
            c3152r0.f10638b = null;
            c3152r0.f10639c = null;
            view.setTag(R.id.tag_unhandled_key_event_manager, c3152r0);
        }
        WeakReference weakReference2 = c3152r0.f10639c;
        if (weakReference2 != null && weakReference2.get() == keyEvent) {
            return false;
        }
        c3152r0.f10639c = new WeakReference(keyEvent);
        if (c3152r0.f10638b == null) {
            c3152r0.f10638b = new SparseArray();
        }
        SparseArray sparseArray = c3152r0.f10638b;
        if (keyEvent.getAction() == 1 && (iIndexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) >= 0) {
            weakReference = (WeakReference) sparseArray.valueAt(iIndexOfKey);
            sparseArray.removeAt(iIndexOfKey);
        }
        if (weakReference == null) {
            weakReference = (WeakReference) sparseArray.get(keyEvent.getKeyCode());
        }
        if (weakReference == null) {
            return false;
        }
        View view2 = (View) weakReference.get();
        if (view2 == null || !view2.isAttachedToWindow() || (arrayList = (ArrayList) view2.getTag(R.id.tag_unhandled_key_listeners)) == null || (size = arrayList.size() - 1) < 0) {
            return true;
        }
        throw AbstractC0004e.m17k(size, arrayList);
    }

    public static boolean m6020q(InterfaceC3133l interfaceC3133l, View view, Window.Callback callback, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener onKeyListener;
        boolean zBooleanValue = false;
        if (interfaceC3133l == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return interfaceC3133l.mo415b(keyEvent);
        }
        if (callback instanceof Activity) {
            Activity activity = (Activity) callback;
            activity.onUserInteraction();
            Window window = activity.getWindow();
            if (window.hasFeature(8)) {
                ActionBar actionBar = activity.getActionBar();
                if (keyEvent.getKeyCode() == 82 && actionBar != null) {
                    if (!f10186n) {
                        try {
                            f10187o = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
                        } catch (NoSuchMethodException unused) {
                        }
                        f10186n = true;
                    }
                    Method method = f10187o;
                    if (method != null) {
                        try {
                            Object objInvoke = method.invoke(actionBar, keyEvent);
                            if (objInvoke != null) {
                                zBooleanValue = ((Boolean) objInvoke).booleanValue();
                            }
                        } catch (IllegalAccessException | InvocationTargetException unused2) {
                        }
                    }
                    if (zBooleanValue) {
                        return true;
                    }
                }
            }
            if (window.superDispatchKeyEvent(keyEvent)) {
                return true;
            }
            View decorView = window.getDecorView();
            if (AbstractC3155s0.m6333c(decorView, keyEvent)) {
                return true;
            }
            return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
        }
        if (!(callback instanceof Dialog)) {
            return (view != null && AbstractC3155s0.m6333c(view, keyEvent)) || interfaceC3133l.mo415b(keyEvent);
        }
        Dialog dialog = (Dialog) callback;
        if (!f10188p) {
            try {
                Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                f10189q = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused3) {
            }
            f10188p = true;
        }
        Field field = f10189q;
        if (field != null) {
            try {
                onKeyListener = (DialogInterface.OnKeyListener) field.get(dialog);
            } catch (IllegalAccessException unused4) {
                onKeyListener = null;
            }
        } else {
            onKeyListener = null;
        }
        if (onKeyListener != null && onKeyListener.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        Window window2 = dialog.getWindow();
        if (window2.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView2 = window2.getDecorView();
        if (AbstractC3155s0.m6333c(decorView2, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(dialog, decorView2 != null ? decorView2.getKeyDispatcherState() : null, dialog);
    }

    public static C3581e m6021t(RandomAccessFile randomAccessFile) throws IOException {
        long length = randomAccessFile.length();
        long j10 = length - 22;
        if (j10 < 0) {
            throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        long j11 = length - 65558;
        long j12 = j11 >= 0 ? j11 : 0L;
        int iReverseBytes = Integer.reverseBytes(101010256);
        do {
            randomAccessFile.seek(j10);
            if (randomAccessFile.readInt() == iReverseBytes) {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                C3581e c3581e = new C3581e();
                c3581e.f12056b = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                c3581e.f12055a = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                return c3581e;
            }
            j10--;
        } while (j10 >= j12);
        throw new ZipException("End Of Central Directory signature not found");
    }

    public static boolean m6022x(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f10184l == null) {
            f10184l = Boolean.valueOf(Build.VERSION.SDK_INT >= 26 && packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        return f10184l.booleanValue();
    }

    public static boolean m6023y(Resources resources) {
        boolean z7 = false;
        if (resources == null) {
            return false;
        }
        if (f10182j == null) {
            Configuration configuration = resources.getConfiguration();
            if ((configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600) {
                z7 = true;
            }
            f10182j = Boolean.valueOf(z7);
        }
        return f10182j.booleanValue();
    }

    public static boolean m6024z(Context context) {
        Resources resources = context.getResources();
        if (resources == null) {
            return false;
        }
        if (f10180h == null) {
            f10180h = Boolean.valueOf((resources.getConfiguration().screenLayout & 15) > 3 || m6023y(resources));
        }
        return f10180h.booleanValue();
    }

    public abstract void mo444B();

    public abstract void mo4282D(int i6);

    public abstract void mo4283E(Typeface typeface, boolean z7);

    public abstract boolean mo446F(int i6, KeyEvent keyEvent);

    public boolean mo447G(KeyEvent keyEvent) {
        return false;
    }

    public boolean mo448H() {
        return false;
    }

    public abstract void mo449J(boolean z7);

    public abstract void mo450K(boolean z7);

    public abstract void mo451L();

    public abstract void mo452N(boolean z7);

    public abstract void mo453O(String str);

    public abstract void mo454P(String str);

    public abstract void mo455R(CharSequence charSequence);

    public abstract void mo5562S();

    public AbstractC2740a mo517T(C0069f c0069f) {
        return null;
    }

    public abstract void mo5563U();

    public InterfaceC4255c mo3811c(Context context, Looper looper, C0049h c0049h, Object obj, InterfaceC4260h interfaceC4260h, InterfaceC4261i interfaceC4261i) {
        return mo3812d(context, looper, c0049h, obj, (C4343n) interfaceC4260h, (C4343n) interfaceC4261i);
    }

    public InterfaceC4255c mo3812d(Context context, Looper looper, C0049h c0049h, Object obj, C4343n c4343n, C4343n c4343n2) {
        throw new UnsupportedOperationException("buildClient must be implemented");
    }

    public boolean mo5571f() {
        return false;
    }

    public boolean mo457h() {
        return false;
    }

    public abstract boolean mo458i();

    public abstract Typeface mo5525l(Context context, C2347f c2347f, Resources resources, int i6);

    public abstract Typeface mo5526m(Context context, C2859g[] c2859gArr, int i6);

    public Typeface mo5540n(Context context, InputStream inputStream) {
        File fileM6475x = AbstractC3198d.m6475x(context);
        if (fileM6475x == null) {
            return null;
        }
        try {
            if (AbstractC3198d.m6456d(fileM6475x, inputStream)) {
                return Typeface.createFromFile(fileM6475x.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileM6475x.delete();
        }
    }

    public Typeface mo5537o(Context context, Resources resources, int i6, String str, int i10) {
        File fileM6475x = AbstractC3198d.m6475x(context);
        if (fileM6475x == null) {
            return null;
        }
        try {
            if (AbstractC3198d.m6455c(fileM6475x, resources, i6)) {
                return Typeface.createFromFile(fileM6475x.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileM6475x.delete();
        }
    }

    public abstract void mo459r(boolean z7);

    public C2859g mo5541s(int i6, C2859g[] c2859gArr) {
        new C4112e(12);
        int i10 = (i6 & 1) == 0 ? 400 : 700;
        boolean z7 = (i6 & 2) != 0;
        C2859g c2859g = null;
        int i11 = Integer.MAX_VALUE;
        for (C2859g c2859g2 : c2859gArr) {
            int iAbs = (Math.abs(c2859g2.f9784c - i10) * 2) + (c2859g2.f9785d == z7 ? 0 : 1);
            if (c2859g == null || i11 > iAbs) {
                c2859g = c2859g2;
                i11 = iAbs;
            }
        }
        return c2859g;
    }

    public abstract int mo460u();

    public abstract Context mo461v();

    public boolean mo462w() {
        return false;
    }

    public void mo445C() {
    }

    public void mo5570I() {
    }
}

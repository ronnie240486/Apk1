package p222u7;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.util.Property;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.app.C0157r0;
import androidx.core.app.AbstractC0357u0;
import androidx.core.app.C0367z0;
import androidx.leanback.transition.InterfaceC0444e;
import androidx.media3.common.C0565C;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import p003a2.AbstractC0032a;
import p005a4.ExecutorC0059r;
import p014b1.C1229c;
import p014b1.C1241o;
import p014b1.C1242p;
import p021b9.EnumC1367a;
import p025c2.C1381b;
import p034d0.AbstractC2116b;
import p034d0.AbstractC2118d;
import p034d0.AbstractC2119e;
import p046e0.AbstractC2344c;
import p046e0.AbstractC2351j;
import p046e0.AbstractC2355n;
import p046e0.C2352k;
import p046e0.C2353l;
import p049e3.C2405w;
import p055ea.AbstractC2442h;
import p055ea.EnumC2432c;
import p065g0.AbstractC2581a;
import p091i9.InterfaceC2728p;
import p103j9.AbstractC2796i;
import p103j9.AbstractC2804q;
import p123l5.AbstractC2973a;
import p138n0.AbstractC3155s0;
import p140n2.C3183h;
import p140n2.EnumC3182g;
import p143n5.AbstractC3198d;
import p173q1.AbstractC3403e0;
import p185r2.AbstractC3587f;
import p186r3.AbstractC3597a;
import p187r4.AbstractC3612b;
import p213t9.AbstractC3865u;
import p213t9.C3845k;
import p213t9.C3848l0;
import p213t9.InterfaceC3846k0;
import p228v2.InterfaceC3977d;
import p249x4.C4112e;
import p254x9.C4176r;
import p259y2.C4243f;

public abstract class AbstractC3928d implements InterfaceC0444e {

    public static String f13221a = "";

    public static Object m7839A(Callable callable) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
            return callable.call();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void m7840a(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = AbstractC3198d.m6448W(drawable).mutate();
            if (colorStateList == null || !colorStateList.isStateful()) {
                AbstractC2581a.m5586h(drawable, colorStateList);
            } else {
                int[] drawableState = textInputLayout.getDrawableState();
                int[] drawableState2 = checkableImageButton.getDrawableState();
                int length = drawableState.length;
                int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
                System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
                AbstractC2581a.m5586h(drawable, ColorStateList.valueOf(colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor())));
            }
            if (mode != null) {
                AbstractC2581a.m5587i(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public static int m7841b(Context context, String str) {
        boolean zM1029a = true;
        if (str == null) {
            throw new NullPointerException("permission must be non-null");
        }
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        C0367z0 c0367z0 = new C0367z0(context);
        if (i6 >= 24) {
            zM1029a = AbstractC0357u0.m1029a(c0367z0.f1598b);
        } else {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i10 = applicationInfo.uid;
            try {
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                Class<?> cls2 = Integer.TYPE;
                Method method = cls.getMethod("checkOpNoThrow", cls2, cls2, String.class);
                Integer num = (Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class);
                num.getClass();
                if (((Integer) method.invoke(appOpsManager, num, Integer.valueOf(i10), packageName)).intValue() != 0) {
                    zM1029a = false;
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            }
        }
        return zM1029a ? 0 : -1;
    }

    public static int m7842c(int i6, int i10) {
        long j10 = ((long) i6) + ((long) i10);
        int i11 = (int) j10;
        if (j10 == ((long) i11)) {
            return i11;
        }
        throw new ArithmeticException("overflow: checkedAdd(" + i6 + ", " + i10 + ")");
    }

    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap m7843d(Drawable drawable, Bitmap.Config config, C3183h c3183h, EnumC3182g enumC3182g, boolean z7) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap3 = ((BitmapDrawable) drawable).getBitmap();
            if (bitmap3.getConfig() == ((config == null || AbstractC3198d.m6426A(config)) ? Bitmap.Config.ARGB_8888 : config)) {
                if (!z7) {
                    int width = bitmap3.getWidth();
                    int height = bitmap3.getHeight();
                    C3183h c3183h2 = C3183h.f10677c;
                }
                return bitmap3;
            }
        }
        Drawable drawableMutate = drawable.mutate();
        Bitmap.Config[] configArr = AbstractC3587f.f12065a;
        boolean z10 = drawableMutate instanceof BitmapDrawable;
        BitmapDrawable bitmapDrawable = z10 ? (BitmapDrawable) drawableMutate : null;
        int intrinsicWidth = (bitmapDrawable == null || (bitmap2 = bitmapDrawable.getBitmap()) == null) ? drawableMutate.getIntrinsicWidth() : bitmap2.getWidth();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 512;
        }
        BitmapDrawable bitmapDrawable2 = z10 ? (BitmapDrawable) drawableMutate : null;
        int intrinsicHeight = (bitmapDrawable2 == null || (bitmap = bitmapDrawable2.getBitmap()) == null) ? drawableMutate.getIntrinsicHeight() : bitmap.getHeight();
        int i6 = intrinsicHeight > 0 ? intrinsicHeight : 512;
        C3183h c3183h3 = C3183h.f10677c;
        double dM6017j = AbstractC2973a.m6017j(intrinsicWidth, i6, AbstractC2796i.m5780a(c3183h, c3183h3) ? intrinsicWidth : AbstractC3587f.m7212e(c3183h.f10678a, enumC3182g), AbstractC2796i.m5780a(c3183h, c3183h3) ? i6 : AbstractC3587f.m7212e(c3183h.f10679b, enumC3182g), enumC3182g);
        int iM7254J = AbstractC3612b.m7254J(((double) intrinsicWidth) * dM6017j);
        int iM7254J2 = AbstractC3612b.m7254J(dM6017j * ((double) i6));
        if (config == null || AbstractC3198d.m6426A(config)) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iM7254J, iM7254J2, config);
        Rect bounds = drawableMutate.getBounds();
        int i10 = bounds.left;
        int i11 = bounds.top;
        int i12 = bounds.right;
        int i13 = bounds.bottom;
        drawableMutate.setBounds(0, 0, iM7254J, iM7254J2);
        drawableMutate.draw(new Canvas(bitmapCreateBitmap));
        drawableMutate.setBounds(i10, i11, i12, i13);
        return bitmapCreateBitmap;
    }

    public static final void m7844e(int i6, int i10) {
        if (i6 <= i10) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i6 + ") is greater than size (" + i10 + ").");
    }

    public static C1242p m7845f(Context context) {
        ProviderInfo providerInfo;
        C1381b c1381b;
        ApplicationInfo applicationInfo;
        C4112e c1229c = Build.VERSION.SDK_INT >= 28 ? new C1229c(2) : new C4112e(2);
        PackageManager packageManager = context.getPackageManager();
        AbstractC0032a.m162p(packageManager, "Package manager required to locate emoji font provider");
        Iterator<ResolveInfo> it = packageManager.queryIntentContentProviders(new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                providerInfo = null;
                break;
            }
            providerInfo = it.next().providerInfo;
            if (providerInfo != null && (applicationInfo = providerInfo.applicationInfo) != null && (applicationInfo.flags & 1) == 1) {
                break;
            }
        }
        if (providerInfo == null) {
            c1381b = null;
        } else {
            try {
                String str = providerInfo.authority;
                String str2 = providerInfo.packageName;
                Signature[] signatureArrMo3105m = c1229c.mo3105m(packageManager, str2);
                ArrayList arrayList = new ArrayList();
                for (Signature signature : signatureArrMo3105m) {
                    arrayList.add(signature.toByteArray());
                }
                c1381b = new C1381b(str, str2, "emojicompat-emoji-font", Collections.singletonList(arrayList));
            } catch (PackageManager.NameNotFoundException e5) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", e5);
                c1381b = null;
            }
        }
        if (c1381b == null) {
            return null;
        }
        return new C1242p(new C1241o(context, c1381b));
    }

    public static float m7846g(float f, float f3, float f4, float f5) {
        double d = 0.0f - f;
        double d10 = 0.0f - f3;
        float fHypot = (float) Math.hypot(d, d10);
        double d11 = f4 - f;
        float fHypot2 = (float) Math.hypot(d11, d10);
        double d12 = f5 - f3;
        float fHypot3 = (float) Math.hypot(d11, d12);
        float fHypot4 = (float) Math.hypot(d, d12);
        if (fHypot > fHypot2 && fHypot > fHypot3 && fHypot > fHypot4) {
            return fHypot;
        }
        if (fHypot2 <= fHypot3 || fHypot2 <= fHypot4) {
            return fHypot3 > fHypot4 ? fHypot3 : fHypot4;
        }
        return fHypot2;
    }

    public static int m7847i(Context context, int i6) {
        return Build.VERSION.SDK_INT >= 23 ? AbstractC2116b.m5071a(context, i6) : context.getResources().getColor(i6);
    }

    public static ColorStateList m7848k(Context context, int i6) {
        ColorStateList colorStateListM5329a;
        ColorStateList colorStateList;
        C2352k c2352k;
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();
        C2353l c2353l = new C2353l(resources, theme);
        synchronized (AbstractC2355n.f8211c) {
            try {
                SparseArray sparseArray = (SparseArray) AbstractC2355n.f8210b.get(c2353l);
                colorStateListM5329a = null;
                if (sparseArray == null || sparseArray.size() <= 0 || (c2352k = (C2352k) sparseArray.get(i6)) == null) {
                    colorStateList = null;
                } else {
                    if (c2352k.f8205b.equals(resources.getConfiguration())) {
                        if (theme != null || c2352k.f8206c != 0) {
                            if (theme == null || c2352k.f8206c != theme.hashCode()) {
                            }
                        }
                        colorStateList = c2352k.f8204a;
                    }
                    sparseArray.remove(i6);
                    colorStateList = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (colorStateList != null) {
            return colorStateList;
        }
        ThreadLocal threadLocal = AbstractC2355n.f8209a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        resources.getValue(i6, typedValue, true);
        int i10 = typedValue.type;
        if (i10 < 28 || i10 > 31) {
            try {
                colorStateListM5329a = AbstractC2344c.m5329a(resources, resources.getXml(i6), theme);
            } catch (Exception e5) {
                Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e5);
            }
        }
        if (colorStateListM5329a == null) {
            return Build.VERSION.SDK_INT >= 23 ? AbstractC2351j.m5335b(resources, i6, theme) : resources.getColorStateList(i6);
        }
        AbstractC2355n.m5337a(c2353l, i6, colorStateListM5329a, theme);
        return colorStateListM5329a;
    }

    public static Executor m7849m(Context context) {
        return Build.VERSION.SDK_INT >= 28 ? AbstractC2118d.m5076a(context) : new ExecutorC0059r(1, new Handler(context.getMainLooper()));
    }

    public static int m7850n(ArrayList arrayList, InputStream inputStream, C4243f c4243f) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new C2405w(inputStream, c4243f);
        }
        inputStream.mark(5242880);
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            try {
                int iMo5423b = ((InterfaceC3977d) arrayList.get(i6)).mo5423b(inputStream, c4243f);
                inputStream.reset();
                if (iMo5423b != -1) {
                    return iMo5423b;
                }
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return -1;
    }

    public static Object m7851o(Context context, Class cls) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 23) {
            return AbstractC2116b.m5072b(context, cls);
        }
        String strM5073c = i6 >= 23 ? AbstractC2116b.m5073c(context, cls) : (String) AbstractC2119e.f7725a.get(cls);
        if (strM5073c != null) {
            return context.getSystemService(strM5073c);
        }
        return null;
    }

    public static ImageHeaderParser$ImageType m7852p(ArrayList arrayList, InputStream inputStream, C4243f c4243f) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new C2405w(inputStream, c4243f);
        }
        inputStream.mark(5242880);
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            try {
                ImageHeaderParser$ImageType imageHeaderParser$ImageTypeMo5425d = ((InterfaceC3977d) arrayList.get(i6)).mo5425d(inputStream);
                inputStream.reset();
                if (imageHeaderParser$ImageTypeMo5425d != ImageHeaderParser$ImageType.UNKNOWN) {
                    return imageHeaderParser$ImageTypeMo5425d;
                }
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    public static ImageHeaderParser$ImageType m7853q(ArrayList arrayList, ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            try {
                ImageHeaderParser$ImageType imageHeaderParser$ImageTypeMo5422a = ((InterfaceC3977d) arrayList.get(i6)).mo5422a(byteBuffer);
                AtomicReference atomicReference = AbstractC3597a.f12090a;
                if (imageHeaderParser$ImageTypeMo5422a != ImageHeaderParser$ImageType.UNKNOWN) {
                    return imageHeaderParser$ImageTypeMo5422a;
                }
            } catch (Throwable th) {
                AtomicReference atomicReference2 = AbstractC3597a.f12090a;
                throw th;
            }
        }
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    public static int m7854r(long j10) {
        return (int) (j10 ^ (j10 >>> 32));
    }

    public static void m7855s() {
        AbstractC2442h.f8598d = AbstractC0032a.m165s("vrX345uKINQ=\n", "0dORivjjQbg=\n");
        AbstractC2442h.f8595a = AbstractC0032a.m165s("VJRw492WU29dlXD7nYIRL0qFdP/P1VItWc9l48eDCnITkmH0x98IJU4=\n", "POAEk66sfEA=\n");
        AbstractC2442h.f8596b = AbstractC0032a.m165s("1MgG2cSr2uLdyQbBhL+YosrZAsXW6Nug2ZMT2d6+g/+T3Qfd3w==\n", "vLxyqbeR9c0=\n");
        AbstractC2442h.f8597c = AbstractC0032a.m165s("tiFjOZe+RP2EfzIlnw==\n", "9lFRSvLMMpg=\n");
        AbstractC0032a.m165s("eJk4ND5cBy14hiljfV4U\n", "COpIGlMzcUg=\n");
        AbstractC2442h.f8603i = true;
        AbstractC2442h.f8604j = true;
        AbstractC2442h.f8606l = true;
        AbstractC2442h.f8615u = AbstractC0032a.m165s("Zo/ECg==\n", "Vr/0OhFaO24=\n");
        AbstractC2442h.f8613s = EnumC2432c.f8525f;
        AbstractC2442h.f8583E = AbstractC0032a.m165s("xLc=\n", "tMOsYumDY10=\n");
        AbstractC2442h.f8585G = AbstractC0032a.m165s("/Qw=\n", "jXjGQ2cN8yE=\n");
        AbstractC2442h.f8587I = true;
        AbstractC2442h.f8607m = true;
        AbstractC2442h.f8593O = true;
        AbstractC2442h.f8592N = AbstractC0032a.m165s("7Y3exQF13VfkicOEXCKdDuCJxtQLYZ8dqora0Bcrhh32jYWAQgKwVueQxA==\n", "hfmqtXJP8ng=\n");
        AbstractC2442h.f8594P = true;
        AbstractC2442h.f8590L = true;
    }

    public static boolean m7856t() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static synchronized boolean m7857u() {
        String hostAddress;
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            datagramSocket.connect(InetAddress.getByName("3.3.3.3"), 53);
            InetAddress localAddress = datagramSocket.getLocalAddress();
            datagramSocket.close();
            hostAddress = localAddress.getHostAddress();
        } catch (IOException e5) {
            e5.printStackTrace();
            hostAddress = "";
        }
        if (hostAddress.equals(f13221a)) {
            return false;
        }
        f13221a = hostAddress;
        return true;
    }

    public static int m7858v(int i6) {
        int i10 = i6 % C0565C.DEFAULT_BUFFER_SEGMENT_SIZE;
        return i10 >= 0 ? i10 : i10 + C0565C.DEFAULT_BUFFER_SEGMENT_SIZE;
    }

    public static void m7859x(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int[] drawableState = textInputLayout.getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
        int colorForState = colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor());
        Drawable drawableMutate = AbstractC3198d.m6448W(drawable).mutate();
        AbstractC2581a.m5586h(drawableMutate, ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    public static void m7860y(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        boolean zHasOnClickListeners = checkableImageButton.hasOnClickListeners();
        boolean z7 = onLongClickListener != null;
        boolean z10 = zHasOnClickListeners || z7;
        checkableImageButton.setFocusable(z10);
        checkableImageButton.setClickable(zHasOnClickListeners);
        checkableImageButton.setPressable(zHasOnClickListeners);
        checkableImageButton.setLongClickable(z7);
        checkableImageButton.setImportantForAccessibility(z10 ? 1 : 2);
    }

    public static final Object m7861z(C4176r c4176r, C4176r c4176r2, InterfaceC2728p interfaceC2728p) throws Throwable {
        Object c3845k;
        Object objM7714A;
        InterfaceC3846k0 interfaceC3846k0;
        try {
            AbstractC2804q.m5797b(interfaceC2728p);
            c3845k = interfaceC2728p.invoke(c4176r2, c4176r);
        } catch (Throwable th) {
            c3845k = new C3845k(th, false);
        }
        EnumC1367a enumC1367a = EnumC1367a.f4179a;
        if (c3845k == enumC1367a || (objM7714A = c4176r.m7714A(c3845k)) == AbstractC3865u.f12958d) {
            return enumC1367a;
        }
        if (objM7714A instanceof C3845k) {
            throw ((C3845k) objM7714A).f12934a;
        }
        C3848l0 c3848l0 = objM7714A instanceof C3848l0 ? (C3848l0) objM7714A : null;
        return (c3848l0 == null || (interfaceC3846k0 = c3848l0.f12937a) == null) ? objM7714A : interfaceC3846k0;
    }

    @Override
    public float mo177j(View view) {
        return view.getTranslationX();
    }

    @Override
    public Property mo178l() {
        return View.TRANSLATION_X;
    }

    public abstract void mo6921w(AbstractC3403e0 abstractC3403e0, C0157r0 c0157r0);
}

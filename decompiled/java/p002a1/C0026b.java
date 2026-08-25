package p002a1;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.C0163u0;
import androidx.appcompat.widget.C0256q0;
import androidx.appcompat.widget.C0280v;
import androidx.appcompat.widget.C0285w;
import androidx.appcompat.widget.C0304z3;
import androidx.fragment.app.AbstractComponentCallbacksC0427s;
import androidx.fragment.app.C0403g;
import androidx.fragment.app.C0414l0;
import androidx.fragment.app.C0422p0;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.widget.AbstractC0481l0;
import androidx.leanback.widget.C0449a1;
import androidx.leanback.widget.C0460e0;
import androidx.leanback.widget.C0482m;
import androidx.leanback.widget.C0508z;
import androidx.lifecycle.AbstractC0540o0;
import androidx.lifecycle.AbstractC0541p;
import androidx.lifecycle.AbstractC0554v0;
import androidx.lifecycle.C0548s0;
import androidx.lifecycle.C0556w0;
import androidx.lifecycle.C0559y;
import androidx.lifecycle.C0562z0;
import androidx.lifecycle.EnumC0537n;
import androidx.lifecycle.InterfaceC0560y0;
import androidx.lifecycle.LifecycleService;
import androidx.lifecycle.RunnableC0552u0;
import com.bumptech.glide.AbstractC1465c;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.bumptech.glide.load.data.C1483i;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.framework.internal.featurehighlight.C1497e;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.ComplianceOptions;
import com.google.android.gms.internal.cast.AbstractC1542e0;
import com.google.android.gms.internal.cast.C1602k0;
import com.google.android.gms.internal.cast.C1640o;
import com.google.android.gms.internal.cast.C1661q2;
import com.google.android.gms.internal.cast.C1668r0;
import com.lzy.okgo.cache.CacheEntity;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.bitspark.android.Spark;
import p000a.AbstractC0004e;
import p001a0.C0019b;
import p001a0.C0023f;
import p005a4.C0051j;
import p005a4.C0061t;
import p006a6.C0062a;
import p018b5.AbstractC1312l;
import p020b7.C1352l;
import p025c2.C1381b;
import p025c2.C1391l;
import p028c6.C1399b;
import p036d2.C2140i;
import p038d4.C2153c;
import p038d4.InterfaceC2152b;
import p041d7.AbstractC2177c2;
import p046e0.AbstractC2355n;
import p049e3.C2383d;
import p049e3.C2405w;
import p050e4.C2409a;
import p069g4.InterfaceC2612b;
import p077h4.C2652b;
import p077h4.C2654d;
import p077h4.C2659i;
import p077h4.C2660j;
import p080h7.C2664b;
import p080h7.InterfaceC2666d;
import p086i3.C2688d;
import p087i4.InterfaceC2699d;
import p094j0.InterfaceC2756d;
import p095j1.C2767a;
import p095j1.C2768b;
import p097j3.C2773d;
import p097j3.InterfaceC2770a;
import p101j7.C2780a;
import p103j9.AbstractC2796i;
import p113k7.C2898e;
import p120l2.InterfaceC2970g;
import p130m2.C3057e;
import p130m2.C3061i;
import p130m2.C3064l;
import p130m2.C3065m;
import p130m2.EnumC3054b;
import p140n2.C3177b;
import p140n2.C3183h;
import p140n2.EnumC3182g;
import p143n5.AbstractC3198d;
import p144n7.AbstractC3206d;
import p144n7.C3216n;
import p144n7.C3217o;
import p144n7.C3218p;
import p144n7.C3219q;
import p144n7.InterfaceC3215m;
import p150o2.C3246a;
import p165p4.C3370o;
import p165p4.InterfaceC3357b;
import p185r2.AbstractC3582a;
import p185r2.AbstractC3585d;
import p185r2.AbstractC3587f;
import p185r2.C3592k;
import p185r2.C3593l;
import p185r2.ComponentCallbacks2C3594m;
import p185r2.InterfaceC3590i;
import p186r3.AbstractC3597a;
import p186r3.AbstractC3602f;
import p186r3.C3607k;
import p187r4.AbstractC3612b;
import p221u6.C3905e;
import p222u7.AbstractC3928d;
import p228v2.C3981h;
import p228v2.InterfaceC3977d;
import p230v4.C3988b;
import p230v4.C3990d;
import p230v4.C4009w;
import p234v8.InterfaceC4022a;
import p242w5.C4056d;
import p243w8.C4070l;
import p247x2.InterfaceC4102x;
import p248x3.C4106b;
import p248x3.EnumC4107c;
import p249x4.C4112e;
import p253x8.AbstractC4146i;
import p259y2.C4243f;
import p259y2.InterfaceC4238a;
import p271z4.InterfaceC4340k;
import qa.C3565m;

public class C0026b implements InterfaceC2152b, InterfaceC2756d, InterfaceC2770a, InterfaceC2970g, InterfaceC3215m, InterfaceC4340k {

    public static C0026b f52e;

    public final int f53a;

    public Object f54b;

    public Object f55c;

    public Object f56d;

    public C0026b(int i6, boolean z7) {
        this.f53a = i6;
    }

    public static C0026b m110B(Context context, AttributeSet attributeSet, int[] iArr) {
        return new C0026b(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static C0026b m111C(Context context, AttributeSet attributeSet, int[] iArr, int i6) {
        return new C0026b(context, context.obtainStyledAttributes(attributeSet, iArr, i6, 0));
    }

    public static final void m114c(C0026b c0026b, Network network, boolean z7) {
        C4070l c4070l;
        boolean z10;
        boolean z11 = false;
        for (Network network2 : ((ConnectivityManager) c0026b.f54b).getAllNetworks()) {
            if (AbstractC2796i.m5780a(network2, network)) {
                z10 = z7;
            } else {
                NetworkCapabilities networkCapabilities = ((ConnectivityManager) c0026b.f54b).getNetworkCapabilities(network2);
                z10 = networkCapabilities != null && networkCapabilities.hasCapability(12);
            }
            if (z10) {
                z11 = true;
                break;
            }
        }
        ComponentCallbacks2C3594m componentCallbacks2C3594m = (ComponentCallbacks2C3594m) c0026b.f55c;
        synchronized (componentCallbacks2C3594m) {
            try {
                if (((C1391l) componentCallbacks2C3594m.f12083a.get()) != null) {
                    componentCallbacks2C3594m.f12087e = z11;
                    c4070l = C4070l.f13734a;
                } else {
                    c4070l = null;
                }
                if (c4070l == null) {
                    componentCallbacks2C3594m.m7216b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static C3057e m115k(C3061i c3061i, Throwable th) {
        Drawable drawableM7207b;
        if (th instanceof C3064l) {
            drawableM7207b = AbstractC3585d.m7207b(c3061i, null, null, c3061i.f10467D.f10430l);
            if (drawableM7207b == null) {
                drawableM7207b = AbstractC3585d.m7207b(c3061i, c3061i.f10465B, c3061i.f10464A, c3061i.f10467D.f10429k);
            }
        } else {
            drawableM7207b = AbstractC3585d.m7207b(c3061i, c3061i.f10465B, c3061i.f10464A, c3061i.f10467D.f10429k);
        }
        return new C3057e(drawableM7207b, c3061i, th);
    }

    public static boolean m116y(C3061i c3061i, Bitmap.Config config) {
        if (!AbstractC3198d.m6426A(config)) {
            return true;
        }
        if (!c3061i.f10478k) {
            return false;
        }
        C3246a c3246a = c3061i.f10470c;
        if (c3246a instanceof C3246a) {
            ImageView imageView = c3246a.f10870b;
            if (imageView.isAttachedToWindow() && !imageView.isHardwareAccelerated()) {
                return false;
            }
        }
        return true;
    }

    public void m117A(C0422p0 c0422p0) {
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = c0422p0.f1933c;
        if (abstractComponentCallbacksC0427s.f1947B) {
            ((C0414l0) this.f56d).m1268c(abstractComponentCallbacksC0427s);
        }
        if (((C0422p0) ((HashMap) this.f55c).put(abstractComponentCallbacksC0427s.f1969f, null)) != null && Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + abstractComponentCallbacksC0427s);
        }
    }

    public C3065m m118D(C3061i c3061i, C3183h c3183h) {
        boolean zIsEmpty = c3061i.f10473f.isEmpty();
        Bitmap.Config config = c3061i.f10471d;
        if (!zIsEmpty && !AbstractC4146i.m8169B(AbstractC3587f.f12065a, config)) {
            config = Bitmap.Config.ARGB_8888;
        } else if (AbstractC3198d.m6426A(config)) {
            if (m116y(c3061i, config)) {
                if (!((InterfaceC3590i) this.f56d).mo7213a(c3183h)) {
                }
            }
            config = Bitmap.Config.ARGB_8888;
        }
        AbstractC3612b abstractC3612b = c3183h.f10678a;
        C3177b c3177b = C3177b.f10668c;
        return new C3065m(c3061i.f10468a, config, null, c3183h, (abstractC3612b.equals(c3177b) || c3183h.f10679b.equals(c3177b)) ? EnumC3182g.f10675b : c3061i.f10490w, AbstractC3585d.m7206a(c3061i), c3061i.f10479l && c3061i.f10473f.isEmpty() && config != Bitmap.Config.ALPHA_8, c3061i.f10480m, null, c3061i.f10475h, c3061i.f10476i, c3061i.f10491x, c3061i.f10481n, c3061i.f10482o, c3061i.f10483p);
    }

    public void m119E(EnumC0537n enumC0537n) {
        RunnableC0552u0 runnableC0552u0 = (RunnableC0552u0) this.f56d;
        if (runnableC0552u0 != null) {
            runnableC0552u0.run();
        }
        RunnableC0552u0 runnableC0552u1 = new RunnableC0552u0((C0559y) this.f54b, enumC0537n);
        this.f56d = runnableC0552u1;
        ((Handler) this.f55c).postAtFrontOfQueue(runnableC0552u1);
    }

    public void m120F() {
        ((TypedArray) this.f55c).recycle();
    }

    public void m121G(String str) {
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f54b = str;
    }

    public void m122H(AbstractC0481l0 abstractC0481l0) {
        boolean z7 = ((AbstractC0481l0) this.f55c) != null;
        this.f55c = abstractC0481l0;
        if (z7) {
            ((C0460e0) this.f54b).m1422a();
        }
    }

    public C3065m m123K(C3065m c3065m) {
        boolean z7;
        Bitmap.Config config;
        EnumC3054b enumC3054b;
        boolean z10;
        Bitmap.Config config2 = c3065m.f10497b;
        EnumC3054b enumC3054b2 = c3065m.f10510o;
        boolean z11 = true;
        if (!AbstractC3198d.m6426A(config2) || ((InterfaceC3590i) this.f56d).mo7214b()) {
            z7 = false;
            config = config2;
        } else {
            config = Bitmap.Config.ARGB_8888;
            z7 = true;
        }
        if (c3065m.f10510o.f10417a) {
            ComponentCallbacks2C3594m componentCallbacks2C3594m = (ComponentCallbacks2C3594m) this.f55c;
            synchronized (componentCallbacks2C3594m) {
                componentCallbacks2C3594m.m7215a();
                z10 = componentCallbacks2C3594m.f12087e;
            }
            if (z10) {
                enumC3054b = enumC3054b2;
                z11 = z7;
            } else {
                enumC3054b = EnumC3054b.DISABLED;
            }
        } else {
            enumC3054b = enumC3054b2;
            z11 = z7;
        }
        return z11 ? new C3065m(c3065m.f10496a, config, c3065m.f10498c, c3065m.f10499d, c3065m.f10500e, c3065m.f10501f, c3065m.f10502g, c3065m.f10503h, c3065m.f10504i, c3065m.f10505j, c3065m.f10506k, c3065m.f10507l, c3065m.f10508m, c3065m.f10509n, enumC3054b) : c3065m;
    }

    public void m124L(int i6, String str, String str2) {
        ((HashMap) this.f54b).put(str, str2);
        ((HashMap) this.f55c).put(str2, str);
        ((HashMap) this.f56d).put(str, Integer.valueOf(i6));
    }

    @Override
    public void mo125a() {
        View view = (View) this.f54b;
        view.clearAnimation();
        ((ViewGroup) this.f55c).endViewTransition(view);
        ((C0403g) this.f56d).m373d();
    }

    @Override
    public boolean mo126b() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f54b;
        for (Network network : connectivityManager.getAllNetworks()) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            if (networkCapabilities != null && networkCapabilities.hasCapability(12)) {
                return true;
            }
        }
        return false;
    }

    public void m127d(Object obj, String str) {
        C0026b c0026b = new C0026b(13, false);
        ((C0026b) this.f56d).f56d = c0026b;
        this.f56d = c0026b;
        c0026b.f55c = obj;
        c0026b.f54b = str;
    }

    @Override
    public InterfaceC4102x mo89e(InterfaceC4102x interfaceC4102x, C3981h c3981h) {
        Drawable drawable = (Drawable) interfaceC4102x.get();
        if (drawable instanceof BitmapDrawable) {
            return ((C1399b) this.f55c).mo89e(C2383d.m5410b(((BitmapDrawable) drawable).getBitmap(), (InterfaceC4238a) this.f54b), c3981h);
        }
        if (drawable instanceof C2688d) {
            return ((C2773d) this.f56d).mo89e(interfaceC4102x, c3981h);
        }
        return null;
    }

    public void m128f(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s) {
        if (((ArrayList) this.f54b).contains(abstractComponentCallbacksC0427s)) {
            throw new IllegalStateException("Fragment already added: " + abstractComponentCallbacksC0427s);
        }
        synchronized (((ArrayList) this.f54b)) {
            ((ArrayList) this.f54b).add(abstractComponentCallbacksC0427s);
        }
        abstractComponentCallbacksC0427s.f1975l = true;
    }

    public void m129g(int[] iArr, ValueAnimator valueAnimator) {
        C3905e c3905e = new C3905e(iArr, valueAnimator);
        valueAnimator.addListener((C0062a) this.f56d);
        ((ArrayList) this.f54b).add(c3905e);
    }

    @Override
    public Object get() {
        switch (this.f53a) {
            case 3:
                return new C0061t(new C3905e(19), new C4112e(18), (InterfaceC2612b) ((C1381b) this.f54b).get(), (C2659i) ((C0304z3) this.f55c).get(), (C2660j) ((C0023f) this.f56d).get());
            default:
                return new C2654d((Context) ((C2153c) this.f54b).f7798a, (InterfaceC2699d) ((InterfaceC4022a) this.f55c).get(), (C2652b) ((C4112e) this.f56d).get());
        }
    }

    public C0051j m130h() {
        String strConcat = ((String) this.f54b) == null ? " backendName" : "";
        if (((EnumC4107c) this.f56d) == null) {
            strConcat = strConcat.concat(" priority");
        }
        if (strConcat.isEmpty()) {
            return new C0051j((String) this.f54b, (byte[]) this.f55c, (EnumC4107c) this.f56d);
        }
        throw new IllegalStateException("Missing required properties:".concat(strConcat));
    }

    public Bitmap m131i(BitmapFactory.Options options) {
        switch (this.f53a) {
            case 17:
                return BitmapFactory.decodeStream(new C2140i(AbstractC3597a.m7219c((ByteBuffer) this.f54b)), null, options);
            case 18:
                C2405w c2405w = (C2405w) ((C1483i) this.f54b).f4484b;
                c2405w.reset();
                return BitmapFactory.decodeStream(c2405w, null, options);
            default:
                return BitmapFactory.decodeFileDescriptor(((C1483i) this.f56d).m3554d().getFileDescriptor(), null, options);
        }
    }

    public void m132j(C2409a c2409a, ByteArrayOutputStream byteArrayOutputStream) {
        HashMap map = (HashMap) this.f55c;
        HashMap map2 = (HashMap) this.f54b;
        C2898e c2898e = new C2898e(byteArrayOutputStream, map2, map, (C2780a) this.f56d);
        InterfaceC2666d interfaceC2666d = (InterfaceC2666d) map2.get(C2409a.class);
        if (interfaceC2666d == null) {
            throw new C2664b(AbstractC0004e.m23q(C2409a.class, "No encoder for "));
        }
        interfaceC2666d.mo192a(c2409a, c2898e);
    }

    public AbstractComponentCallbacksC0427s m133l(String str) {
        C0422p0 c0422p0 = (C0422p0) ((HashMap) this.f55c).get(str);
        if (c0422p0 != null) {
            return c0422p0.f1933c;
        }
        return null;
    }

    public AbstractComponentCallbacksC0427s m134m(String str) {
        for (C0422p0 c0422p0 : ((HashMap) this.f55c).values()) {
            if (c0422p0 != null) {
                AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427sM134m = c0422p0.f1933c;
                if (!str.equals(abstractComponentCallbacksC0427sM134m.f1969f)) {
                    abstractComponentCallbacksC0427sM134m = abstractComponentCallbacksC0427sM134m.f1984u.f1863c.m134m(str);
                }
                if (abstractComponentCallbacksC0427sM134m != null) {
                    return abstractComponentCallbacksC0427sM134m;
                }
            }
        }
        return null;
    }

    @Override
    public Object mo135n() {
        try {
            return ((AbstractC3206d) this.f54b).mo6496i((Class) this.f55c);
        } catch (Exception e5) {
            throw new RuntimeException("Unable to invoke no-args constructor for " + ((Type) this.f56d) + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e5);
        }
    }

    public AbstractC0554v0 m136o(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return m137q(cls, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName));
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override
    public void mo99p(Object obj, Object obj2) {
        C4009w c4009w = (C4009w) obj;
        C4056d c4056d = (C4056d) obj2;
        switch (this.f53a) {
            case 27:
                C3988b c3988b = C3370o.f11372F;
                C3370o c3370o = (C3370o) this.f54b;
                AbstractC1312l.m3200g("Not connected to device", c3370o.m6865j());
                Context context = c4009w.f5071c;
                ComplianceOptions complianceOptions = new ComplianceOptions(-1, -1, 0, true);
                C3990d c3990d = (C3990d) c4009w.m3663p();
                ApiMetadata apiMetadata = new ApiMetadata(complianceOptions);
                Parcel parcelM3687l = c3990d.m3687l();
                parcelM3687l.writeString((String) this.f55c);
                AbstractC1542e0.m3809c(parcelM3687l, (LaunchOptions) this.f56d);
                AbstractC1542e0.m3809c(parcelM3687l, apiMetadata);
                c3990d.m3690y(parcelM3687l, 13);
                synchronized (c3370o.f11386q) {
                    try {
                        if (c3370o.f11383n != null) {
                            c3370o.m6863h(2477);
                        }
                        c3370o.f11383n = c4056d;
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return;
            default:
                AbstractC1312l.m3200g("Not active connection", ((C3370o) this.f54b).f11378E != 1);
                if (((InterfaceC3357b) this.f55c) != null) {
                    Context context2 = c4009w.f5071c;
                    ComplianceOptions complianceOptions2 = new ComplianceOptions(-1, -1, 0, true);
                    C3990d c3990d2 = (C3990d) c4009w.m3663p();
                    ApiMetadata apiMetadata2 = new ApiMetadata(complianceOptions2);
                    Parcel parcelM3687l2 = c3990d2.m3687l();
                    parcelM3687l2.writeString((String) this.f56d);
                    AbstractC1542e0.m3809c(parcelM3687l2, apiMetadata2);
                    c3990d2.m3690y(parcelM3687l2, 12);
                }
                c4056d.m8059b(null);
                return;
        }
    }

    public AbstractC0554v0 m137q(Class cls, String str) {
        AbstractC0554v0 abstractC0554v0Mo1197a;
        AbstractC2796i.m5785f(str, CacheEntity.KEY);
        C0562z0 c0562z0 = (C0562z0) this.f54b;
        c0562z0.getClass();
        LinkedHashMap linkedHashMap = c0562z0.f2562a;
        AbstractC0554v0 abstractC0554v0 = (AbstractC0554v0) linkedHashMap.get(str);
        boolean zIsInstance = cls.isInstance(abstractC0554v0);
        InterfaceC0560y0 interfaceC0560y0 = (InterfaceC0560y0) this.f55c;
        if (!zIsInstance) {
            C2768b c2768b = new C2768b((AbstractC2177c2) this.f56d);
            ((LinkedHashMap) c2768b.f7850a).put(C0556w0.f2544c, str);
            try {
                abstractC0554v0Mo1197a = interfaceC0560y0.mo1198b(cls, c2768b);
            } catch (AbstractMethodError unused) {
                abstractC0554v0Mo1197a = interfaceC0560y0.mo1197a(cls);
            }
            AbstractC2796i.m5785f(abstractC0554v0Mo1197a, "viewModel");
            AbstractC0554v0 abstractC0554v1 = (AbstractC0554v0) linkedHashMap.put(str, abstractC0554v0Mo1197a);
            if (abstractC0554v1 != null) {
                abstractC0554v1.mo1267b();
            }
            return abstractC0554v0Mo1197a;
        }
        C0548s0 c0548s0 = interfaceC0560y0 instanceof C0548s0 ? (C0548s0) interfaceC0560y0 : null;
        if (c0548s0 != null) {
            AbstractC2796i.m5782c(abstractC0554v0);
            AbstractC0541p abstractC0541p = c0548s0.f2531d;
            if (abstractC0541p != null) {
                C0280v c0280v = c0548s0.f2532e;
                AbstractC2796i.m5782c(c0280v);
                AbstractC0540o0.m1503a(abstractC0554v0, c0280v, abstractC0541p);
            }
        }
        AbstractC2796i.m5783d(abstractC0554v0, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
        return abstractC0554v0;
    }

    public ArrayList m138r() {
        ArrayList arrayList = new ArrayList();
        for (C0422p0 c0422p0 : ((HashMap) this.f55c).values()) {
            if (c0422p0 != null) {
                arrayList.add(c0422p0);
            }
        }
        return arrayList;
    }

    public ColorStateList m139s(int i6) {
        int resourceId;
        ColorStateList colorStateListM7848k;
        TypedArray typedArray = (TypedArray) this.f55c;
        return (!typedArray.hasValue(i6) || (resourceId = typedArray.getResourceId(i6, 0)) == 0 || (colorStateListM7848k = AbstractC3928d.m7848k((Context) this.f54b, resourceId)) == null) ? typedArray.getColorStateList(i6) : colorStateListM7848k;
    }

    @Override
    public void shutdown() {
        ((ConnectivityManager) this.f54b).unregisterNetworkCallback((C1668r0) this.f56d);
    }

    public Drawable m140t(int i6) {
        int resourceId;
        TypedArray typedArray = (TypedArray) this.f55c;
        return (!typedArray.hasValue(i6) || (resourceId = typedArray.getResourceId(i6, 0)) == 0) ? typedArray.getDrawable(i6) : AbstractC1465c.m3473h((Context) this.f54b, resourceId);
    }

    public String toString() {
        switch (this.f53a) {
            case 14:
                StringBuilder sb = new StringBuilder(32);
                sb.append((String) this.f54b);
                sb.append('{');
                C0026b c0026b = (C0026b) ((C0026b) this.f55c).f56d;
                String str = "";
                while (c0026b != null) {
                    Object obj = c0026b.f55c;
                    boolean z7 = c0026b instanceof C1352l;
                    sb.append(str);
                    String str2 = (String) c0026b.f54b;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append('=');
                    }
                    if (obj == null || !obj.getClass().isArray()) {
                        sb.append(obj);
                    } else {
                        String strDeepToString = Arrays.deepToString(new Object[]{obj});
                        sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
                    }
                    c0026b = (C0026b) c0026b.f56d;
                    str = ", ";
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public Drawable m141u(int i6) {
        int resourceId;
        Drawable drawableM728g;
        if (!((TypedArray) this.f55c).hasValue(i6) || (resourceId = ((TypedArray) this.f55c).getResourceId(i6, 0)) == 0) {
            return null;
        }
        C0285w c0285wM801a = C0285w.m801a();
        Context context = (Context) this.f54b;
        synchronized (c0285wM801a) {
            drawableM728g = c0285wM801a.f1115a.m728g(context, resourceId, true);
        }
        return drawableM728g;
    }

    public Typeface m142v(int i6, int i10, C0256q0 c0256q0) {
        int resourceId = ((TypedArray) this.f55c).getResourceId(i6, 0);
        if (resourceId == 0) {
            return null;
        }
        if (((TypedValue) this.f56d) == null) {
            this.f56d = new TypedValue();
        }
        TypedValue typedValue = (TypedValue) this.f56d;
        ThreadLocal threadLocal = AbstractC2355n.f8209a;
        Context context = (Context) this.f54b;
        if (context.isRestricted()) {
            return null;
        }
        return AbstractC2355n.m5339c(context, resourceId, typedValue, i10, c0256q0, true, false);
    }

    public List m143w() {
        ArrayList arrayList;
        if (((ArrayList) this.f54b).isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (((ArrayList) this.f54b)) {
            arrayList = new ArrayList((ArrayList) this.f54b);
        }
        return arrayList;
    }

    public ImageHeaderParser$ImageType m144x() throws Throwable {
        switch (this.f53a) {
            case 17:
                return AbstractC3928d.m7853q((ArrayList) this.f55c, AbstractC3597a.m7219c((ByteBuffer) this.f54b));
            case 18:
                C2405w c2405w = (C2405w) ((C1483i) this.f54b).f4484b;
                c2405w.reset();
                return AbstractC3928d.m7852p((ArrayList) this.f56d, c2405w, (C4243f) this.f55c);
            default:
                C1483i c1483i = (C1483i) this.f56d;
                C4243f c4243f = (C4243f) this.f54b;
                ArrayList arrayList = (ArrayList) this.f55c;
                int size = arrayList.size();
                for (int i6 = 0; i6 < size; i6++) {
                    InterfaceC3977d interfaceC3977d = (InterfaceC3977d) arrayList.get(i6);
                    C2405w c2405w2 = null;
                    try {
                        C2405w c2405w3 = new C2405w(new FileInputStream(c1483i.m3554d().getFileDescriptor()), c4243f);
                        try {
                            ImageHeaderParser$ImageType imageHeaderParser$ImageTypeMo5425d = interfaceC3977d.mo5425d(c2405w3);
                            c2405w3.m5441b();
                            c1483i.m3554d();
                            if (imageHeaderParser$ImageTypeMo5425d != ImageHeaderParser$ImageType.UNKNOWN) {
                                return imageHeaderParser$ImageTypeMo5425d;
                            }
                        } catch (Throwable th) {
                            th = th;
                            c2405w2 = c2405w3;
                            if (c2405w2 != null) {
                                c2405w2.m5441b();
                            }
                            c1483i.m3554d();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                return ImageHeaderParser$ImageType.UNKNOWN;
        }
    }

    public void m145z(C0422p0 c0422p0) {
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s = c0422p0.f1933c;
        String str = abstractComponentCallbacksC0427s.f1969f;
        HashMap map = (HashMap) this.f55c;
        if (map.get(str) != null) {
            return;
        }
        map.put(abstractComponentCallbacksC0427s.f1969f, c0422p0);
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Added fragment to active set " + abstractComponentCallbacksC0427s);
        }
    }

    public C0026b(C1640o c1640o, Spark spark, C1497e c1497e) {
        this.f53a = 15;
        this.f54b = spark;
        this.f55c = c1497e;
        this.f56d = c1640o;
    }

    public C0026b(Object obj, Object obj2, Object obj3, int i6) {
        this.f53a = i6;
        this.f54b = obj;
        this.f55c = obj2;
        this.f56d = obj3;
    }

    public C0026b(CastDevice castDevice, C1602k0 c1602k0) {
        this.f53a = 26;
        AbstractC1312l.m3199f(castDevice, "CastDevice parameter cannot be null");
        this.f54b = castDevice;
        this.f55c = c1602k0;
    }

    public C0026b(C1391l c1391l, ComponentCallbacks2C3594m componentCallbacks2C3594m) {
        Object c3592k;
        this.f53a = 24;
        this.f54b = c1391l;
        this.f55c = componentCallbacks2C3594m;
        int i6 = Build.VERSION.SDK_INT;
        if (i6 < 26) {
            boolean z7 = AbstractC3582a.f12057a;
        } else {
            if (!AbstractC3582a.f12057a) {
                if (i6 != 26 && i6 != 27) {
                    c3592k = new C3592k(true);
                } else {
                    c3592k = new C3593l();
                }
            }
            this.f56d = c3592k;
        }
        c3592k = new C3592k(false);
        this.f56d = c3592k;
    }

    public C0026b(LifecycleService lifecycleService) {
        this.f53a = 10;
        this.f54b = new C0559y(lifecycleService);
        this.f55c = new Handler();
    }

    public C0026b(int i6) {
        this.f53a = i6;
        switch (i6) {
            case 9:
                this.f54b = new C0508z(1);
                C0508z c0508z = new C0508z(0);
                this.f55c = c0508z;
                this.f56d = c0508z;
                break;
            case 16:
                this.f54b = new ArrayList();
                this.f55c = null;
                this.f56d = new C0062a(3, this);
                break;
            case 29:
                this.f54b = new HashMap();
                this.f55c = new HashMap();
                this.f56d = new HashMap();
                break;
            default:
                this.f54b = new ArrayList();
                this.f55c = new HashMap();
                break;
        }
    }

    private final void m112I() {
    }

    private final void m113J() {
    }

    public C0026b(C0051j c0051j, C4106b c4106b, C1661q2 c1661q2, C0061t c0061t) {
        this.f53a = 2;
        this.f54b = c0051j;
        this.f55c = c4106b;
        this.f56d = c0061t;
    }

    public C0026b(C0562z0 c0562z0, InterfaceC0560y0 interfaceC0560y0, AbstractC2177c2 abstractC2177c2) {
        this.f53a = 11;
        AbstractC2796i.m5785f(c0562z0, "store");
        AbstractC2796i.m5785f(interfaceC0560y0, "factory");
        AbstractC2796i.m5785f(abstractC2177c2, "defaultCreationExtras");
        this.f54b = c0562z0;
        this.f55c = interfaceC0560y0;
        this.f56d = abstractC2177c2;
    }

    public C0026b(C0482m c0482m) {
        this.f53a = 8;
        this.f53a = 8;
        this.f54b = new C0460e0();
        m122H(c0482m);
        this.f56d = new ArrayList();
        new ArrayList();
    }

    public C0026b(C0562z0 c0562z0, InterfaceC0560y0 interfaceC0560y0) {
        this(c0562z0, interfaceC0560y0, C2767a.f9482b);
        this.f53a = 11;
        AbstractC2796i.m5785f(c0562z0, "store");
    }

    public C0026b(C3565m c3565m) {
        this.f53a = 8;
        this.f53a = 8;
        this.f54b = new C0460e0();
        m122H(new C0449a1(c3565m));
        this.f56d = new ArrayList();
        new ArrayList();
    }

    public C0026b(Context context, TypedArray typedArray) {
        this.f53a = 5;
        this.f54b = context;
        this.f55c = typedArray;
    }

    public C0026b(Context context, LocationManager locationManager) {
        this.f53a = 4;
        this.f56d = new C0163u0();
        this.f54b = context;
        this.f55c = locationManager;
    }

    public C0026b(ConnectivityManager connectivityManager, ComponentCallbacks2C3594m componentCallbacks2C3594m) {
        this.f53a = 23;
        this.f54b = connectivityManager;
        this.f55c = componentCallbacks2C3594m;
        C1668r0 c1668r0 = new C1668r0(2, this);
        this.f56d = c1668r0;
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), c1668r0);
    }

    public C0026b(FragmentActivity fragmentActivity) {
        this(fragmentActivity.mo359e(), fragmentActivity.mo357c(), fragmentActivity.mo358d());
        this.f53a = 11;
        AbstractC2796i.m5785f(fragmentActivity, "owner");
    }

    public C0026b(String str) {
        this.f53a = 14;
        C0026b c0026b = new C0026b(13, false);
        this.f55c = c0026b;
        this.f56d = c0026b;
        this.f54b = str;
    }

    public C0026b(C3607k c3607k, ArrayList arrayList, C4243f c4243f) {
        this.f53a = 18;
        AbstractC3602f.m7225c(c4243f, "Argument must not be null");
        this.f55c = c4243f;
        AbstractC3602f.m7225c(arrayList, "Argument must not be null");
        this.f56d = arrayList;
        this.f54b = new C1483i(c3607k, c4243f);
    }

    public C0026b(C0019b c0019b) {
        this.f53a = 0;
        this.f53a = 0;
        this.f54b = c0019b;
        this.f55c = Choreographer.getInstance();
        this.f56d = new ChoreographerFrameCallbackC0025a(0, this);
    }

    public C0026b(Class cls, Type type) {
        Object c3219q;
        this.f53a = 25;
        this.f55c = cls;
        this.f56d = type;
        try {
            try {
                try {
                    Class<?> cls2 = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls2.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    c3219q = new C3216n(cls2.getMethod("allocateInstance", Class.class), declaredField.get(null));
                } catch (Exception unused) {
                    c3219q = new C3219q();
                }
            } catch (Exception unused2) {
                Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod.setAccessible(true);
                c3219q = new C3218p(declaredMethod);
            }
        } catch (Exception unused3) {
            Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
            declaredMethod2.setAccessible(true);
            int iIntValue = ((Integer) declaredMethod2.invoke(null, Object.class)).intValue();
            Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
            declaredMethod3.setAccessible(true);
            c3219q = new C3217o(declaredMethod3, iIntValue);
        }
        this.f54b = c3219q;
    }

    public C0026b(ParcelFileDescriptor parcelFileDescriptor, ArrayList arrayList, C4243f c4243f) {
        this.f53a = 19;
        AbstractC3602f.m7225c(c4243f, "Argument must not be null");
        this.f54b = c4243f;
        AbstractC3602f.m7225c(arrayList, "Argument must not be null");
        this.f55c = arrayList;
        this.f56d = new C1483i(parcelFileDescriptor);
    }
}

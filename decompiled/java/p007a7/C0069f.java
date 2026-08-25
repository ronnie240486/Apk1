package p007a7;

import android.animation.Animator;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.media.session.AbstractC0120b;
import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.appcompat.app.C0160t;
import androidx.appcompat.app.LayoutInflaterFactory2C0135g0;
import androidx.fragment.app.AbstractC0410j0;
import androidx.fragment.app.AbstractComponentCallbacksC0427s;
import androidx.fragment.app.C0439z;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.widget.RunnableC0485n0;
import androidx.lifecycle.AbstractC0541p;
import androidx.lifecycle.C0562z0;
import androidx.lifecycle.InterfaceC0555w;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.viewpager.widget.ViewPager;
import coil.memory.MemoryCache$Key;
import com.bumptech.glide.ComponentCallbacks2C1464b;
import com.bumptech.glide.ComponentCallbacks2C1491o;
import com.google.android.datatransport.cct.CctBackendFactory;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import com.google.android.material.internal.C1819e0;
import com.google.android.material.internal.InterfaceC1817d0;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.proguard.C2029al;
import com.tencent.bugly.proguard.C2098r;
import com.tencent.bugly.proguard.InterfaceC2025ah;
import com.youth.banner.listener.OnPageChangeListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.bitspark.android.SpkApplication;
import org.bitspark.android.beans.EventBean;
import org.json.JSONObject;
import p000a.AbstractC0004e;
import p000a.C0006g;
import p001a0.C0019b;
import p001a0.C0023f;
import p002a1.C0026b;
import p003a2.AbstractC0032a;
import p004a3.RunnableC0038c;
import p014b1.C1230d;
import p014b1.C1239m;
import p014b1.C1246t;
import p017b4.C1297d;
import p017b4.C1298e;
import p017b4.C1299f;
import p024c1.C1377a;
import p027c4.InterfaceC1397a;
import p028c6.C1399b;
import p035d1.C2123a;
import p035d1.C2130h;
import p037d3.C2149b;
import p038d4.C2151a;
import p038d4.C2153c;
import p038d4.InterfaceC2152b;
import p049e3.C2378a0;
import p049e3.C2379b;
import p049e3.C2383d;
import p049e3.C2405w;
import p049e3.InterfaceC2397o;
import p055ea.AbstractC2460q;
import p056f0.AbstractC2481d;
import p056f0.AbstractC2482e;
import p063fa.InterfaceC2546n0;
import p087i4.C2696a;
import p087i4.C2702g;
import p087i4.C2704i;
import p093j.AbstractC2740a;
import p093j.C2745f;
import p103j9.AbstractC2796i;
import p105k.MenuC2825b0;
import p105k.MenuC2838l;
import p106k0.C2857e;
import p107k1.AbstractC2861a;
import p107k1.C2862b;
import p108k2.C2863a;
import p108k2.C2865c;
import p108k2.C2866d;
import p108k2.InterfaceC2868f;
import p109k3.C2876h;
import p109k3.C2878j;
import p116ka.ViewOnKeyListenerC2925j;
import p116ka.ViewOnKeyListenerC2932m0;
import p128m0.C3026b;
import p138n0.AbstractC3113e0;
import p138n0.AbstractC3155s0;
import p138n0.C3102a1;
import p138n0.C3153r1;
import p138n0.InterfaceC3154s;
import p143n5.AbstractC3198d;
import p160p.C3347k;
import p160p.C3348l;
import p171q.C3388b;
import p186r3.AbstractC3610n;
import p186r3.C3600d;
import p192r9.AbstractC3648f;
import p214ta.C3877a;
import p221u6.C3905e;
import p228v2.C3981h;
import p228v2.InterfaceC3984k;
import p243w8.C4060b;
import p247x2.InterfaceC4102x;
import p249x4.C4109b;
import p249x4.C4112e;
import p259y2.InterfaceC4238a;

public final class C0069f implements InterfaceC3154s, InterfaceC2152b, InterfaceC2025ah, InterfaceC3984k, InterfaceC2397o, InterfaceC2868f, OnPageChangeListener, InterfaceC2546n0 {

    public final int f195a;

    public Object f196b;

    public Object f197c;

    public C0069f(int i6, Object obj) {
        this.f195a = i6;
        this.f196b = obj;
        this.f197c = null;
    }

    public static C2378a0 m216e(ImageDecoder.Source source, int i6, int i10, C3981h c3981h) throws IOException {
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source, new C2149b(i6, i10, c3981h));
        if (AbstractC0120b.m353y(drawableDecodeDrawable)) {
            return new C2378a0(2, AbstractC0120b.m337i(drawableDecodeDrawable));
        }
        throw new IOException("Received unexpected drawable type for animated image, failing: " + drawableDecodeDrawable);
    }

    public static boolean m217f(Editable editable, KeyEvent keyEvent, boolean z7) {
        C1246t[] c1246tArr;
        if (!KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (c1246tArr = (C1246t[]) editable.getSpans(selectionStart, selectionEnd, C1246t.class)) != null && c1246tArr.length > 0) {
            for (C1246t c1246t : c1246tArr) {
                int spanStart = editable.getSpanStart(c1246t);
                int spanEnd = editable.getSpanEnd(c1246t);
                if ((z7 && spanStart == selectionStart) || ((!z7 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    public CctBackendFactory m218A(String str) {
        Bundle bundle;
        Map mapEmptyMap;
        Object obj;
        if (((Map) this.f197c) == null) {
            Context context = (Context) this.f196b;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                } else {
                    ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) TransportBackendDiscovery.class), 128);
                    if (serviceInfo == null) {
                        Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                    } else {
                        bundle = serviceInfo.metaData;
                    }
                    if (bundle == null) {
                        Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                        mapEmptyMap = Collections.emptyMap();
                    } else {
                        HashMap map = new HashMap();
                        for (String str2 : bundle.keySet()) {
                            obj = bundle.get(str2);
                            if (!(obj instanceof String) && str2.startsWith("backend:")) {
                                for (String str3 : ((String) obj).split(",", -1)) {
                                    String strTrim = str3.trim();
                                    if (!strTrim.isEmpty()) {
                                        map.put(strTrim, str2.substring(8));
                                    }
                                }
                            }
                        }
                        mapEmptyMap = map;
                    }
                    this.f197c = mapEmptyMap;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
            }
            bundle = null;
            if (bundle == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                mapEmptyMap = Collections.emptyMap();
            } else {
                HashMap map2 = new HashMap();
                while (r6.hasNext()) {
                    obj = bundle.get(str2);
                    if (!(obj instanceof String)) {
                    }
                }
                mapEmptyMap = map2;
            }
            this.f197c = mapEmptyMap;
        }
        String str4 = (String) ((Map) this.f197c).get(str);
        if (str4 == null) {
            return null;
        }
        try {
            return (CctBackendFactory) Class.forName(str4).asSubclass(CctBackendFactory.class).getDeclaredConstructor(null).newInstance(null);
        } catch (ClassNotFoundException e5) {
            Log.w("BackendRegistry", "Class " + str4 + " is not found.", e5);
            return null;
        } catch (IllegalAccessException e10) {
            Log.w("BackendRegistry", "Could not instantiate " + str4 + ".", e10);
            return null;
        } catch (InstantiationException e11) {
            Log.w("BackendRegistry", "Could not instantiate " + str4 + ".", e11);
            return null;
        } catch (NoSuchMethodException e12) {
            Log.w("BackendRegistry", "Could not instantiate ".concat(str4), e12);
            return null;
        } catch (InvocationTargetException e13) {
            Log.w("BackendRegistry", "Could not instantiate ".concat(str4), e13);
            return null;
        }
    }

    public Locale m219B() {
        SharedPreferences sharedPreferences = (SharedPreferences) this.f196b;
        String string = sharedPreferences.getString("language_key", null);
        if (string == null || AbstractC3648f.m7383e0(string)) {
            return (Locale) this.f197c;
        }
        String string2 = sharedPreferences.getString("language_key", null);
        if (string2 != null) {
            JSONObject jSONObject = new JSONObject(string2);
            return new Locale(jSONObject.getString("language"), jSONObject.getString("country"), jSONObject.getString("variant"));
        }
        C4060b c4060b = new C4060b();
        AbstractC2796i.m5789j(c4060b, AbstractC2796i.class.getName());
        throw c4060b;
    }

    public ComponentCallbacks2C1491o m220C(Context context, ComponentCallbacks2C1464b componentCallbacks2C1464b, AbstractC0541p abstractC0541p, AbstractC0410j0 abstractC0410j0, boolean z7) {
        AbstractC3610n.m7233a();
        AbstractC3610n.m7233a();
        HashMap map = (HashMap) this.f196b;
        ComponentCallbacks2C1491o componentCallbacks2C1491o = (ComponentCallbacks2C1491o) map.get(abstractC0541p);
        if (componentCallbacks2C1491o != null) {
            return componentCallbacks2C1491o;
        }
        C2876h c2876h = new C2876h(abstractC0541p);
        C4112e c4112e = new C4112e(this, abstractC0410j0);
        ((C3905e) this.f197c).getClass();
        ComponentCallbacks2C1491o componentCallbacks2C1491o2 = new ComponentCallbacks2C1491o(componentCallbacks2C1464b, c2876h, c4112e, context);
        map.put(abstractC0541p, componentCallbacks2C1491o2);
        c2876h.mo5862h(new C2878j(this, abstractC0541p));
        if (z7) {
            componentCallbacks2C1491o2.mo3565i();
        }
        return componentCallbacks2C1491o2;
    }

    public boolean m221D(CharSequence charSequence, int i6, int i10, C1239m c1239m) {
        boolean zM5518a;
        if (c1239m.f3940c == 0) {
            C1230d c1230d = (C1230d) this.f197c;
            C1377a c1377aM3115c = c1239m.m3115c();
            int iM3244a = c1377aM3115c.m3244a(8);
            short s10 = iM3244a != 0 ? ((ByteBuffer) c1377aM3115c.f4194d).getShort(iM3244a + c1377aM3115c.f4191a) : (short) 0;
            c1230d.getClass();
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 23 || s10 <= i11) {
                ThreadLocal threadLocal = C1230d.f3916b;
                if (threadLocal.get() == null) {
                    threadLocal.set(new StringBuilder());
                }
                StringBuilder sb = (StringBuilder) threadLocal.get();
                sb.setLength(0);
                while (i6 < i10) {
                    sb.append(charSequence.charAt(i6));
                    i6++;
                }
                TextPaint textPaint = c1230d.f3917a;
                String string = sb.toString();
                ThreadLocal threadLocal2 = AbstractC2482e.f8685a;
                if (Build.VERSION.SDK_INT >= 23) {
                    zM5518a = AbstractC2481d.m5518a(textPaint, string);
                } else {
                    int length = string.length();
                    if (length == 1 && Character.isWhitespace(string.charAt(0))) {
                        zM5518a = true;
                    } else {
                        float fMeasureText = textPaint.measureText("\udfffd");
                        float fMeasureText2 = textPaint.measureText(CmcdData.OBJECT_TYPE_MANIFEST);
                        float fMeasureText3 = textPaint.measureText(string);
                        float fMeasureText4 = 0.0f;
                        if (fMeasureText3 != 0.0f) {
                            if (string.codePointCount(0, string.length()) > 1) {
                                if (fMeasureText3 <= fMeasureText2 * 2.0f) {
                                    int i12 = 0;
                                    while (i12 < length) {
                                        int iCharCount = Character.charCount(string.codePointAt(i12)) + i12;
                                        fMeasureText4 += textPaint.measureText(string, i12, iCharCount);
                                        i12 = iCharCount;
                                    }
                                    if (fMeasureText3 >= fMeasureText4) {
                                    }
                                }
                                zM5518a = false;
                            }
                            if (fMeasureText3 != fMeasureText) {
                                zM5518a = true;
                            } else {
                                ThreadLocal threadLocal3 = AbstractC2482e.f8685a;
                                C3026b c3026b = (C3026b) threadLocal3.get();
                                if (c3026b == null) {
                                    c3026b = new C3026b(new Rect(), new Rect());
                                    threadLocal3.set(c3026b);
                                } else {
                                    ((Rect) c3026b.f10354a).setEmpty();
                                    ((Rect) c3026b.f10355b).setEmpty();
                                }
                                Rect rect = (Rect) c3026b.f10354a;
                                textPaint.getTextBounds("\udfffd", 0, 2, rect);
                                Object obj = c3026b.f10355b;
                                textPaint.getTextBounds(string, 0, length, (Rect) obj);
                                zM5518a = !rect.equals(obj);
                            }
                        } else {
                            zM5518a = false;
                        }
                    }
                }
            } else {
                zM5518a = false;
            }
            c1239m.f3940c = zM5518a ? 2 : 1;
        }
        return c1239m.f3940c == 2;
    }

    public void m222E(AbstractC2740a abstractC2740a) {
        C0023f c0023f = (C0023f) this.f196b;
        ((ActionMode.Callback) c0023f.f44b).onDestroyActionMode(c0023f.m106f(abstractC2740a));
        LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0 = (LayoutInflaterFactory2C0135g0) this.f197c;
        if (layoutInflaterFactory2C0135g0.f353w != null) {
            layoutInflaterFactory2C0135g0.f342l.getDecorView().removeCallbacks(layoutInflaterFactory2C0135g0.f354x);
        }
        if (layoutInflaterFactory2C0135g0.f352v != null) {
            C3102a1 c3102a1 = layoutInflaterFactory2C0135g0.f355y;
            if (c3102a1 != null) {
                c3102a1.m6122b();
            }
            C3102a1 c3102a1M6331a = AbstractC3155s0.m6331a(layoutInflaterFactory2C0135g0.f352v);
            c3102a1M6331a.m6121a(0.0f);
            layoutInflaterFactory2C0135g0.f355y = c3102a1M6331a;
            c3102a1M6331a.m6124d(new C0160t(2, this));
        }
        layoutInflaterFactory2C0135g0.f351u = null;
        ViewGroup viewGroup = layoutInflaterFactory2C0135g0.f307B;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        AbstractC3113e0.m6130c(viewGroup);
        layoutInflaterFactory2C0135g0.m392J();
    }

    public boolean m223F(AbstractC2740a abstractC2740a, MenuC2838l menuC2838l) {
        ViewGroup viewGroup = ((LayoutInflaterFactory2C0135g0) this.f197c).f307B;
        WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
        AbstractC3113e0.m6130c(viewGroup);
        C0023f c0023f = (C0023f) this.f196b;
        C2745f c2745fM106f = c0023f.m106f(abstractC2740a);
        C3347k c3347k = (C3347k) c0023f.f45c;
        Menu menuC2825b0 = (Menu) c3347k.get(menuC2838l);
        if (menuC2825b0 == null) {
            menuC2825b0 = new MenuC2825b0((Context) c0023f.f47e, menuC2838l);
            c3347k.put(menuC2838l, menuC2825b0);
        }
        return ((ActionMode.Callback) c0023f.f44b).onPrepareActionMode(c2745fM106f, menuC2825b0);
    }

    public void m224G(C2857e c2857e) {
        int i6 = c2857e.f9777b;
        Handler handler = (Handler) this.f197c;
        C0019b c0019b = (C0019b) this.f196b;
        if (i6 != 0) {
            handler.post(new RunnableC0485n0(i6, 4, c0019b));
        } else {
            handler.post(new RunnableC0038c(17, c0019b, c2857e.f9776a, false));
        }
    }

    public void m225H() {
        Integer num;
        C0006g c0006g = (C0006g) this.f197c;
        ArrayList arrayList = c0006g.f11e;
        String str = (String) this.f196b;
        if (!arrayList.contains(str) && (num = (Integer) c0006g.f9c.remove(str)) != null) {
            c0006g.f8b.remove(num);
        }
        c0006g.f12f.remove(str);
        HashMap map = c0006g.f13g;
        if (map.containsKey(str)) {
            StringBuilder sbM30x = AbstractC0004e.m30x("Dropping pending result for request ", str, ": ");
            sbM30x.append(map.get(str));
            Log.w("ActivityResultRegistry", sbM30x.toString());
            map.remove(str);
        }
        Bundle bundle = c0006g.f14h;
        if (bundle.containsKey(str)) {
            StringBuilder sbM30x2 = AbstractC0004e.m30x("Dropping pending result for request ", str, ": ");
            sbM30x2.append(bundle.getParcelable(str));
            Log.w("ActivityResultRegistry", sbM30x2.toString());
            bundle.remove(str);
        }
        if (c0006g.f10d.get(str) != null) {
            throw new ClassCastException();
        }
    }

    @Override
    public void mo226a(int i6) {
        C2866d c2866d = (C2866d) this.f197c;
        if (i6 >= 40) {
            c2866d.m3619i(-1);
        } else {
            if (10 > i6 || i6 >= 20) {
                return;
            }
            c2866d.m3619i(c2866d.m3617g() / 2);
        }
    }

    @Override
    public void mo228b(MemoryCache$Key memoryCache$Key, Bitmap bitmap, Map map) {
        int i6;
        int iM6471s = AbstractC3198d.m6471s(bitmap);
        C2866d c2866d = (C2866d) this.f197c;
        synchronized (((C3388b) c2866d.f4831g)) {
            i6 = c2866d.f4826b;
        }
        if (iM6471s <= i6) {
            c2866d.m3614d(memoryCache$Key, new C2865c(bitmap, map, iM6471s));
        } else {
            c2866d.m3615e(memoryCache$Key);
            ((C1399b) this.f196b).m3270b(memoryCache$Key, bitmap, map, iM6471s);
        }
    }

    public void m229c(Object obj, String str) {
        ((ArrayList) this.f196b).add(AbstractC2460q.m5495i(str, "=", String.valueOf(obj)));
    }

    @Override
    public void mo230d(Bitmap bitmap, InterfaceC4238a interfaceC4238a) throws IOException {
        IOException iOException = ((C3600d) this.f197c).f12096b;
        if (iOException != null) {
            if (bitmap == null) {
                throw iOException;
            }
            interfaceC4238a.mo5434f(bitmap);
            throw iOException;
        }
    }

    public void m231g(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s, Bundle bundle, boolean z7) {
        AbstractC0410j0 abstractC0410j0 = (AbstractC0410j0) this.f197c;
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = abstractC0410j0.f1876p;
        if (abstractComponentCallbacksC0427s2 != null) {
            abstractComponentCallbacksC0427s2.m1323l().f1871k.m231g(abstractComponentCallbacksC0427s, bundle, true);
        }
        for (C0439z c0439z : (CopyOnWriteArrayList) this.f196b) {
            if (!z7 || c0439z.f2024b) {
                c0439z.f2023a.onFragmentActivityCreated(abstractC0410j0, abstractComponentCallbacksC0427s, bundle);
            }
        }
    }

    @Override
    public Object get() {
        switch (this.f195a) {
            case 8:
                return new C1299f((Context) ((C2153c) this.f196b).f7798a, (C1297d) ((C1298e) this.f197c).get());
            default:
                C3905e c3905e = new C3905e(19);
                C4112e c4112e = new C4112e(18);
                C2696a c2696a = C2696a.f9375f;
                Object obj = ((C1298e) this.f196b).get();
                InterfaceC2152b interfaceC2152b = (C1298e) this.f197c;
                return new C2702g(c3905e, c4112e, c2696a, (C2704i) obj, interfaceC2152b instanceof InterfaceC1397a ? (InterfaceC1397a) interfaceC2152b : new C2151a(interfaceC2152b));
        }
    }

    @Override
    public C2863a mo232h(MemoryCache$Key memoryCache$Key) {
        C2865c c2865c = (C2865c) ((C2866d) this.f197c).m3612b(memoryCache$Key);
        if (c2865c != null) {
            return new C2863a(c2865c.f9794a, c2865c.f9795b);
        }
        return null;
    }

    @Override
    public boolean mo93i(Object obj, File file, C3981h c3981h) {
        return ((C2379b) this.f197c).mo93i(new C2383d(((BitmapDrawable) ((InterfaceC4102x) obj).get()).getBitmap(), (InterfaceC4238a) this.f196b), file, c3981h);
    }

    @Override
    public void mo233j() {
        C3877a c3877a = ((ViewOnKeyListenerC2932m0) this.f197c).f9983v0;
        c3877a.f12996i.m1488h((Integer) this.f196b);
    }

    @Override
    public void mo234k() {
        C2405w c2405w = (C2405w) this.f196b;
        synchronized (c2405w) {
            c2405w.f8391c = c2405w.f8389a.length;
        }
    }

    @Override
    public int mo235l(C3981h c3981h) {
        return 2;
    }

    public void m236m(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s, boolean z7) {
        AbstractC0410j0 abstractC0410j0 = (AbstractC0410j0) this.f197c;
        FragmentActivity fragmentActivity = abstractC0410j0.f1874n.f2003g;
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = abstractC0410j0.f1876p;
        if (abstractComponentCallbacksC0427s2 != null) {
            abstractComponentCallbacksC0427s2.m1323l().f1871k.m236m(abstractComponentCallbacksC0427s, true);
        }
        for (C0439z c0439z : (CopyOnWriteArrayList) this.f196b) {
            if (!z7 || c0439z.f2024b) {
                c0439z.f2023a.onFragmentAttached(abstractC0410j0, abstractComponentCallbacksC0427s, fragmentActivity);
            }
        }
    }

    public void m237n(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s, Bundle bundle, boolean z7) {
        AbstractC0410j0 abstractC0410j0 = (AbstractC0410j0) this.f197c;
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = abstractC0410j0.f1876p;
        if (abstractComponentCallbacksC0427s2 != null) {
            abstractComponentCallbacksC0427s2.m1323l().f1871k.m237n(abstractComponentCallbacksC0427s, bundle, true);
        }
        for (C0439z c0439z : (CopyOnWriteArrayList) this.f196b) {
            if (!z7 || c0439z.f2024b) {
                c0439z.f2023a.onFragmentCreated(abstractC0410j0, abstractComponentCallbacksC0427s, bundle);
            }
        }
    }

    public void m238o(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s, boolean z7) {
        AbstractC0410j0 abstractC0410j0 = (AbstractC0410j0) this.f197c;
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = abstractC0410j0.f1876p;
        if (abstractComponentCallbacksC0427s2 != null) {
            abstractComponentCallbacksC0427s2.m1323l().f1871k.m238o(abstractComponentCallbacksC0427s, true);
        }
        for (C0439z c0439z : (CopyOnWriteArrayList) this.f196b) {
            if (!z7 || c0439z.f2024b) {
                c0439z.f2023a.onFragmentDestroyed(abstractC0410j0, abstractComponentCallbacksC0427s);
            }
        }
    }

    @Override
    public C3153r1 onApplyWindowInsets(View view, C3153r1 c3153r1) {
        switch (this.f195a) {
            case 6:
                C3153r1 c3153r1M6341k = AbstractC3155s0.m6341k(view, c3153r1);
                if (c3153r1M6341k.f10641a.mo6239n()) {
                    return c3153r1M6341k;
                }
                int iM6326b = c3153r1M6341k.m6326b();
                Rect rect = (Rect) this.f196b;
                rect.left = iM6326b;
                rect.top = c3153r1M6341k.m6328d();
                rect.right = c3153r1M6341k.m6327c();
                rect.bottom = c3153r1M6341k.m6325a();
                ViewPager viewPager = (ViewPager) this.f197c;
                int childCount = viewPager.getChildCount();
                for (int i6 = 0; i6 < childCount; i6++) {
                    C3153r1 c3153r1M6332b = AbstractC3155s0.m6332b(viewPager.getChildAt(i6), c3153r1M6341k);
                    rect.left = Math.min(c3153r1M6332b.m6326b(), rect.left);
                    rect.top = Math.min(c3153r1M6332b.m6328d(), rect.top);
                    rect.right = Math.min(c3153r1M6332b.m6327c(), rect.right);
                    rect.bottom = Math.min(c3153r1M6332b.m6325a(), rect.bottom);
                }
                return c3153r1M6341k.m6329f(rect.left, rect.top, rect.right, rect.bottom);
            default:
                C1819e0 c1819e0 = new C1819e0();
                C1819e0 c1819e1 = (C1819e0) this.f197c;
                c1819e0.f6436a = c1819e1.f6436a;
                c1819e0.f6437b = c1819e1.f6437b;
                c1819e0.f6438c = c1819e1.f6438c;
                c1819e0.f6439d = c1819e1.f6439d;
                return ((InterfaceC1817d0) this.f196b).mo443o(view, c3153r1, c1819e0);
        }
    }

    @Override
    public void onPageScrolled(int i6, float f, int i10) {
        AbstractC0032a.m165s("Y9cHYIqNlFJG3QRx\n", "K7hqBcz/9TU=\n");
        AbstractC0032a.m165s("ivExJk8kReuX8A0rTSU2\n", "5Z9hRyhBFog=\n");
        String str = ((EventBean) ((ArrayList) this.f196b).get(i6)).title;
    }

    @Override
    public void onPageSelected(int i6) {
        AbstractC0032a.m165s("nsCvjZR81yO7yqyc\n", "1q/C6NIOtkQ=\n");
        AbstractC0032a.m165s("FKwQ8pZsz0cXpyPnlG28\n", "e8JAk/EJnCI=\n");
        ArrayList arrayList = (ArrayList) this.f196b;
        String str = ((EventBean) arrayList.get(i6)).title;
        String str2 = ViewOnKeyListenerC2925j.f9925d0;
        ((ViewOnKeyListenerC2925j) this.f197c).m5925V(i6, arrayList);
    }

    public void m239p(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s, boolean z7) {
        AbstractC0410j0 abstractC0410j0 = (AbstractC0410j0) this.f197c;
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = abstractC0410j0.f1876p;
        if (abstractComponentCallbacksC0427s2 != null) {
            abstractComponentCallbacksC0427s2.m1323l().f1871k.m239p(abstractComponentCallbacksC0427s, true);
        }
        for (C0439z c0439z : (CopyOnWriteArrayList) this.f196b) {
            if (!z7 || c0439z.f2024b) {
                c0439z.f2023a.onFragmentDetached(abstractC0410j0, abstractComponentCallbacksC0427s);
            }
        }
    }

    public void m240q(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s, boolean z7) {
        AbstractC0410j0 abstractC0410j0 = (AbstractC0410j0) this.f197c;
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = abstractC0410j0.f1876p;
        if (abstractComponentCallbacksC0427s2 != null) {
            abstractComponentCallbacksC0427s2.m1323l().f1871k.m240q(abstractComponentCallbacksC0427s, true);
        }
        for (C0439z c0439z : (CopyOnWriteArrayList) this.f196b) {
            if (!z7 || c0439z.f2024b) {
                c0439z.f2023a.onFragmentPaused(abstractC0410j0, abstractComponentCallbacksC0427s);
            }
        }
    }

    public void m241r(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s, boolean z7) {
        AbstractC0410j0 abstractC0410j0 = (AbstractC0410j0) this.f197c;
        FragmentActivity fragmentActivity = abstractC0410j0.f1874n.f2003g;
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = abstractC0410j0.f1876p;
        if (abstractComponentCallbacksC0427s2 != null) {
            abstractComponentCallbacksC0427s2.m1323l().f1871k.m241r(abstractComponentCallbacksC0427s, true);
        }
        for (C0439z c0439z : (CopyOnWriteArrayList) this.f196b) {
            if (!z7 || c0439z.f2024b) {
                c0439z.f2023a.onFragmentPreAttached(abstractC0410j0, abstractComponentCallbacksC0427s, fragmentActivity);
            }
        }
    }

    public void m242s(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s, Bundle bundle, boolean z7) {
        AbstractC0410j0 abstractC0410j0 = (AbstractC0410j0) this.f197c;
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = abstractC0410j0.f1876p;
        if (abstractComponentCallbacksC0427s2 != null) {
            abstractComponentCallbacksC0427s2.m1323l().f1871k.m242s(abstractComponentCallbacksC0427s, bundle, true);
        }
        for (C0439z c0439z : (CopyOnWriteArrayList) this.f196b) {
            if (!z7 || c0439z.f2024b) {
                c0439z.f2023a.onFragmentPreCreated(abstractC0410j0, abstractComponentCallbacksC0427s, bundle);
            }
        }
    }

    public void m243t(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s, boolean z7) {
        AbstractC0410j0 abstractC0410j0 = (AbstractC0410j0) this.f197c;
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = abstractC0410j0.f1876p;
        if (abstractComponentCallbacksC0427s2 != null) {
            abstractComponentCallbacksC0427s2.m1323l().f1871k.m243t(abstractComponentCallbacksC0427s, true);
        }
        for (C0439z c0439z : (CopyOnWriteArrayList) this.f196b) {
            if (!z7 || c0439z.f2024b) {
                c0439z.f2023a.onFragmentResumed(abstractC0410j0, abstractComponentCallbacksC0427s);
            }
        }
    }

    public String toString() {
        int iLastIndexOf;
        switch (this.f195a) {
            case 9:
                StringBuilder sb = new StringBuilder(100);
                sb.append(this.f197c.getClass().getSimpleName());
                sb.append('{');
                ArrayList arrayList = (ArrayList) this.f196b;
                int size = arrayList.size();
                for (int i6 = 0; i6 < size; i6++) {
                    sb.append((String) arrayList.get(i6));
                    if (i6 < size - 1) {
                        sb.append(", ");
                    }
                }
                sb.append('}');
                return sb.toString();
            case 25:
                StringBuilder sb2 = new StringBuilder(128);
                sb2.append("LoaderManager{");
                sb2.append(Integer.toHexString(System.identityHashCode(this)));
                sb2.append(" in ");
                Object obj = this.f196b;
                if (obj == null) {
                    sb2.append("null");
                } else {
                    String simpleName = obj.getClass().getSimpleName();
                    if (simpleName.length() <= 0 && (iLastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
                        simpleName = simpleName.substring(iLastIndexOf + 1);
                    }
                    sb2.append(simpleName);
                    sb2.append('{');
                    sb2.append(Integer.toHexString(System.identityHashCode(obj)));
                }
                sb2.append("}}");
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    public void m244u(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s, Bundle bundle, boolean z7) {
        AbstractC0410j0 abstractC0410j0 = (AbstractC0410j0) this.f197c;
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = abstractC0410j0.f1876p;
        if (abstractComponentCallbacksC0427s2 != null) {
            abstractComponentCallbacksC0427s2.m1323l().f1871k.m244u(abstractComponentCallbacksC0427s, bundle, true);
        }
        for (C0439z c0439z : (CopyOnWriteArrayList) this.f196b) {
            if (!z7 || c0439z.f2024b) {
                c0439z.f2023a.onFragmentSaveInstanceState(abstractC0410j0, abstractComponentCallbacksC0427s, bundle);
            }
        }
    }

    public void m245v(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s, boolean z7) {
        AbstractC0410j0 abstractC0410j0 = (AbstractC0410j0) this.f197c;
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = abstractC0410j0.f1876p;
        if (abstractComponentCallbacksC0427s2 != null) {
            abstractComponentCallbacksC0427s2.m1323l().f1871k.m245v(abstractComponentCallbacksC0427s, true);
        }
        for (C0439z c0439z : (CopyOnWriteArrayList) this.f196b) {
            if (!z7 || c0439z.f2024b) {
                c0439z.f2023a.onFragmentStarted(abstractC0410j0, abstractComponentCallbacksC0427s);
            }
        }
    }

    public void m246w(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s, boolean z7) {
        AbstractC0410j0 abstractC0410j0 = (AbstractC0410j0) this.f197c;
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = abstractC0410j0.f1876p;
        if (abstractComponentCallbacksC0427s2 != null) {
            abstractComponentCallbacksC0427s2.m1323l().f1871k.m246w(abstractComponentCallbacksC0427s, true);
        }
        for (C0439z c0439z : (CopyOnWriteArrayList) this.f196b) {
            if (!z7 || c0439z.f2024b) {
                c0439z.f2023a.onFragmentStopped(abstractC0410j0, abstractComponentCallbacksC0427s);
            }
        }
    }

    public void m247x(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s, View view, Bundle bundle, boolean z7) {
        AbstractC0410j0 abstractC0410j0 = (AbstractC0410j0) this.f197c;
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = abstractC0410j0.f1876p;
        if (abstractComponentCallbacksC0427s2 != null) {
            abstractComponentCallbacksC0427s2.m1323l().f1871k.m247x(abstractComponentCallbacksC0427s, view, bundle, true);
        }
        for (C0439z c0439z : (CopyOnWriteArrayList) this.f196b) {
            if (!z7 || c0439z.f2024b) {
                c0439z.f2023a.onFragmentViewCreated(abstractC0410j0, abstractComponentCallbacksC0427s, view, bundle);
            }
        }
    }

    public void m248y(AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s, boolean z7) {
        AbstractC0410j0 abstractC0410j0 = (AbstractC0410j0) this.f197c;
        AbstractComponentCallbacksC0427s abstractComponentCallbacksC0427s2 = abstractC0410j0.f1876p;
        if (abstractComponentCallbacksC0427s2 != null) {
            abstractComponentCallbacksC0427s2.m1323l().f1871k.m248y(abstractComponentCallbacksC0427s, true);
        }
        for (C0439z c0439z : (CopyOnWriteArrayList) this.f196b) {
            if (!z7 || c0439z.f2024b) {
                c0439z.f2023a.onFragmentViewDestroyed(abstractC0410j0, abstractComponentCallbacksC0427s);
            }
        }
    }

    public void m249z(String str, PrintWriter printWriter) {
        C2862b c2862b = (C2862b) this.f197c;
        if (c2862b.f9789d.f11337c > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            String str2 = str + "    ";
            C3348l c3348l = c2862b.f9789d;
            if (c3348l.f11337c <= 0) {
                return;
            }
            AbstractC2861a abstractC2861a = (AbstractC2861a) c3348l.f11336b[0];
            printWriter.print(str);
            printWriter.print("  #");
            printWriter.print(c2862b.f9789d.f11335a[0]);
            printWriter.print(": ");
            printWriter.println(abstractC2861a.toString());
            printWriter.print(str2);
            printWriter.print("mId=");
            printWriter.print(0);
            printWriter.print(" mArgs=");
            printWriter.println((Object) null);
            printWriter.print(str2);
            printWriter.print("mLoader=");
            printWriter.println((Object) null);
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("  ");
            throw null;
        }
    }

    public C0069f(int i6, Object obj, Object obj2, boolean z7) {
        this.f195a = i6;
        this.f196b = obj;
        this.f197c = obj2;
    }

    public C0069f(Object obj, int i6, Object obj2) {
        this.f195a = i6;
        this.f197c = obj;
        this.f196b = obj2;
    }

    public C0069f(Object obj) {
        this.f195a = 9;
        this.f197c = obj;
        this.f196b = new ArrayList();
    }

    @Override
    public void mo227a(boolean z7, String str) {
        if (z7) {
            C2029al.m4644c("[UserInfo] Successfully uploaded user info.", new Object[0]);
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (UserInfoBean userInfoBean : (List) this.f196b) {
                userInfoBean.f7052f = jCurrentTimeMillis;
                ((C2098r) this.f197c).m4954a(userInfoBean, true);
            }
        }
    }

    public C0069f(C3905e c3905e) {
        this.f195a = 27;
        this.f196b = new HashMap();
        this.f197c = c3905e;
    }

    public C0069f(C0006g c0006g, String str, AbstractC0032a abstractC0032a) {
        this.f195a = 11;
        this.f197c = c0006g;
        this.f196b = str;
    }

    public C0069f(SpkApplication spkApplication, Locale locale) {
        this.f195a = 20;
        this.f197c = locale;
        this.f196b = spkApplication.getSharedPreferences("lingver_preference", 0);
    }

    public C0069f(InterfaceC0555w interfaceC0555w, C0562z0 c0562z0) {
        this.f195a = 25;
        this.f196b = interfaceC0555w;
        this.f197c = (C2862b) new C0026b(c0562z0, C2862b.f9788e).m136o(C2862b.class);
    }

    public C0069f(Locale locale) {
        this.f195a = 21;
        this.f196b = locale;
        this.f197c = DateFormatSymbols.getInstance(locale).getShortMonths();
        Calendar calendar = Calendar.getInstance(locale);
        AbstractC3198d.m6465m(calendar.getMinimum(5), calendar.getMaximum(5));
    }

    @Override
    public void onPageScrollStateChanged(int i6) {
    }

    public C0069f(AbstractC0410j0 abstractC0410j0) {
        this.f195a = 3;
        this.f196b = new CopyOnWriteArrayList();
        this.f197c = abstractC0410j0;
    }

    public C0069f(int i6, C1399b c1399b) {
        this.f195a = 26;
        this.f196b = c1399b;
        this.f197c = new C2866d(i6, this);
    }

    public C0069f(C0023f c0023f, C3905e c3905e, C1230d c1230d) {
        this.f195a = 5;
        this.f196b = c0023f;
        this.f197c = c1230d;
    }

    public C0069f(ArrayList arrayList, ArrayList arrayList2) {
        this.f195a = 16;
        int size = arrayList.size();
        this.f196b = new int[size];
        this.f197c = new float[size];
        for (int i6 = 0; i6 < size; i6++) {
            ((int[]) this.f196b)[i6] = ((Integer) arrayList.get(i6)).intValue();
            ((float[]) this.f197c)[i6] = ((Float) arrayList2.get(i6)).floatValue();
        }
    }

    public C0069f(int i6, int i10) {
        this.f195a = 16;
        this.f196b = new int[]{i6, i10};
        this.f197c = new float[]{0.0f, 1.0f};
    }

    public C0069f(int i6, int i10, int i11) {
        this.f195a = 16;
        this.f196b = new int[]{i6, i10, i11};
        this.f197c = new float[]{0.0f, 0.5f, 1.0f};
    }

    public C0069f(EditText editText) {
        this.f195a = 15;
        this.f196b = editText;
        C2130h c2130h = new C2130h(editText);
        this.f197c = c2130h;
        editText.addTextChangedListener(c2130h);
        if (C2123a.f7730b == null) {
            synchronized (C2123a.f7729a) {
                try {
                    if (C2123a.f7730b == null) {
                        C2123a c2123a = new C2123a();
                        try {
                            C2123a.f7731c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, C2123a.class.getClassLoader());
                        } catch (Throwable unused) {
                        }
                        C2123a.f7730b = c2123a;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        editText.setEditableFactory(C2123a.f7730b);
    }

    public C0069f(Animator animator) {
        this.f195a = 2;
        this.f196b = null;
        this.f197c = animator;
    }

    public C0069f(ViewPager viewPager) {
        this.f195a = 6;
        this.f197c = viewPager;
        this.f196b = new Rect();
    }

    public C0069f(int i6) {
        this.f195a = i6;
        switch (i6) {
            case 10:
                C4109b c4109b = C4109b.f13933d;
                this.f196b = new SparseIntArray();
                this.f197c = c4109b;
                break;
            case 12:
                this.f196b = new Rect();
                this.f197c = new Rect();
                break;
        }
    }
}

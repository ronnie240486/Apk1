package p101j7;

import android.content.ClipData;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.SystemClock;
import android.view.ContentInfo;
import android.view.GestureDetector;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.widget.InterfaceC0193d2;
import androidx.media.AudioAttributesImpl;
import androidx.media.AudioAttributesImplApi21;
import androidx.media3.exoplayer.analytics.AbstractC0685b0;
import coil.memory.MemoryCache$Key;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.ComplianceOptions;
import com.google.android.gms.internal.cast.AbstractC1542e0;
import com.google.android.material.internal.C1819e0;
import com.google.android.material.internal.InterfaceC1817d0;
import com.google.android.material.navigationrail.NavigationRailView;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import la.RunnableC3015b;
import la.ViewOnClickListenerC3017d;
import org.json.JSONObject;
import p000a.AbstractC0004e;
import p002a1.C0026b;
import p025c2.C1383d;
import p025c2.C1391l;
import p028c6.C1399b;
import p036d2.EnumC2137f;
import p063fa.InterfaceC2546n0;
import p076h2.C2650k;
import p085i2.InterfaceC2683b;
import p103j9.AbstractC2796i;
import p105k.C2830e;
import p105k.C2840n;
import p105k.MenuC2838l;
import p105k.RunnableC2828d;
import p105k.ViewOnKeyListenerC2832f;
import p108k2.C2863a;
import p108k2.C2864b;
import p108k2.C2867e;
import p108k2.InterfaceC2868f;
import p116ka.RunnableC2942w;
import p116ka.ViewOnKeyListenerC2907a;
import p116ka.ViewOnKeyListenerC2944y;
import p123l5.AbstractC2973a;
import p125l7.C3007n;
import p130m2.C3061i;
import p130m2.C3065m;
import p130m2.C3069q;
import p138n0.AbstractC3155s0;
import p138n0.C3118g;
import p138n0.C3144o1;
import p138n0.C3153r1;
import p138n0.InterfaceC3109d;
import p138n0.InterfaceC3115f;
import p140n2.C3176a;
import p140n2.C3183h;
import p140n2.EnumC3182g;
import p143n5.AbstractC3198d;
import p144n7.InterfaceC3215m;
import p148o0.C3233h;
import p148o0.C3234i;
import p148o0.C3235j;
import p163p2.C3351a;
import p164p3.C3352a;
import p164p3.C3353b;
import p164p3.InterfaceC3354c;
import p164p3.InterfaceC3355d;
import p165p4.C3370o;
import p173q1.AbstractC3394b0;
import p173q1.C3418j0;
import p173q1.C3454w;
import p173q1.InterfaceC3391a0;
import p185r2.AbstractC3585d;
import p185r2.AbstractC3587f;
import p187r4.AbstractC3612b;
import p230v4.C3990d;
import p230v4.C4009w;
import p242w5.C4056d;
import p243w8.C4064f;
import p253x8.AbstractC4158u;
import p253x8.C4156s;
import p271z4.InterfaceC4340k;

public class C2782c implements InterfaceC0193d2, InterfaceC2868f, InterfaceC2546n0, InterfaceC3109d, InterfaceC3115f, InterfaceC3215m, InterfaceC3355d, InterfaceC4340k, InterfaceC1817d0, InterfaceC3391a0 {

    public final int f9500a;

    public Object f9501b;

    public C2782c(int i6, Object obj) {
        this.f9500a = i6;
        this.f9501b = obj;
    }

    public static C3069q m5750w(C2650k c2650k, C3061i c3061i, MemoryCache$Key memoryCache$Key, C2863a c2863a) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(c3061i.f10468a.getResources(), c2863a.f9790a);
        EnumC2137f enumC2137f = EnumC2137f.f7760a;
        Map map = c2863a.f9791b;
        Object obj = map.get("coil#disk_cache_key");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = map.get("coil#is_sampled");
        Boolean bool = obj2 instanceof Boolean ? (Boolean) obj2 : null;
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        Bitmap.Config[] configArr = AbstractC3587f.f12065a;
        return new C3069q(bitmapDrawable, c3061i, enumC2137f, memoryCache$Key, str, zBooleanValue, (c2650k instanceof C2650k) && c2650k.f9253g);
    }

    public static C2782c m5751x(int i6, int i10, int i11, boolean z7) {
        return new C2782c(20, AccessibilityNodeInfo.CollectionInfo.obtain(i6, i10, z7, i11));
    }

    @Override
    public void mo228b(MemoryCache$Key memoryCache$Key, Bitmap bitmap, Map map) {
        ((C1399b) this.f9501b).m3270b(memoryCache$Key, bitmap, map, AbstractC3198d.m6471s(bitmap));
    }

    @Override
    public void mo1737c(AbstractC3394b0 abstractC3394b0, C3454w c3454w, ArrayList arrayList) {
        ((C3418j0) this.f9501b).mo6933g(abstractC3394b0, c3454w, arrayList);
    }

    @Override
    public void mo652d(MenuC2838l menuC2838l, C2840n c2840n) {
        ViewOnKeyListenerC2832f viewOnKeyListenerC2832f = (ViewOnKeyListenerC2832f) this.f9501b;
        viewOnKeyListenerC2832f.f9651f.removeCallbacksAndMessages(null);
        ArrayList arrayList = viewOnKeyListenerC2832f.f9653h;
        int size = arrayList.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                i6 = -1;
                break;
            } else if (menuC2838l == ((C2830e) arrayList.get(i6)).f9643b) {
                break;
            } else {
                i6++;
            }
        }
        if (i6 == -1) {
            return;
        }
        int i10 = i6 + 1;
        viewOnKeyListenerC2832f.f9651f.postAtTime(new RunnableC2828d(this, i10 < arrayList.size() ? (C2830e) arrayList.get(i10) : null, c2840n, menuC2838l, 0), menuC2838l, SystemClock.uptimeMillis() + 200);
    }

    @Override
    public ClipData mo5752e() {
        return ((ContentInfo) this.f9501b).getClip();
    }

    @Override
    public C3118g mo5753f() {
        return new C3118g(new C2782c(((ContentInfo.Builder) this.f9501b).build()));
    }

    @Override
    public InterfaceC3354c mo5754g(int i6) {
        if (i6 == 5) {
            return C3353b.f11344a;
        }
        if (((C3352a) this.f9501b) == null) {
            this.f9501b = new C3352a();
        }
        return (C3352a) this.f9501b;
    }

    @Override
    public int getFlags() {
        return ((ContentInfo) this.f9501b).getFlags();
    }

    @Override
    public C2863a mo232h(MemoryCache$Key memoryCache$Key) {
        return null;
    }

    @Override
    public ContentInfo mo5755i() {
        return (ContentInfo) this.f9501b;
    }

    @Override
    public void mo233j() {
        ((ViewOnKeyListenerC2907a) this.f9501b).f9864X.f12996i.m1488h(4);
    }

    @Override
    public void mo653k(MenuC2838l menuC2838l, C2840n c2840n) {
        ((ViewOnKeyListenerC2832f) this.f9501b).f9651f.removeCallbacksAndMessages(menuC2838l);
    }

    @Override
    public void mo5756l(Uri uri) {
        ((ContentInfo.Builder) this.f9501b).setLinkUri(uri);
    }

    @Override
    public int mo5757m() {
        return ((ContentInfo) this.f9501b).getSource();
    }

    @Override
    public Object mo135n() {
        switch (this.f9500a) {
            case 18:
                Constructor constructor = (Constructor) this.f9501b;
                try {
                    return constructor.newInstance(null);
                } catch (IllegalAccessException e5) {
                    throw new AssertionError(e5);
                } catch (InstantiationException e10) {
                    throw new RuntimeException("Failed to invoke " + constructor + " with no args", e10);
                } catch (InvocationTargetException e11) {
                    throw new RuntimeException("Failed to invoke " + constructor + " with no args", e11.getTargetException());
                }
            default:
                Type type = (Type) this.f9501b;
                if (!(type instanceof ParameterizedType)) {
                    throw new C3007n("Invalid EnumSet type: " + type.toString());
                }
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return EnumSet.noneOf((Class) type2);
                }
                throw new C3007n("Invalid EnumSet type: " + type.toString());
        }
    }

    @Override
    public C3153r1 mo443o(View view, C3153r1 c3153r1, C1819e0 c1819e0) {
        boolean fitsSystemWindows;
        boolean fitsSystemWindows2;
        NavigationRailView navigationRailView = (NavigationRailView) this.f9501b;
        Boolean bool = navigationRailView.f6593h;
        if (bool != null) {
            fitsSystemWindows = bool.booleanValue();
        } else {
            WeakHashMap weakHashMap = AbstractC3155s0.f10642a;
            fitsSystemWindows = navigationRailView.getFitsSystemWindows();
        }
        C3144o1 c3144o1 = c3153r1.f10641a;
        if (fitsSystemWindows) {
            c1819e0.f6437b += c3144o1.mo6228g(7).f8682b;
        }
        Boolean bool2 = navigationRailView.f6594i;
        if (bool2 != null) {
            fitsSystemWindows2 = bool2.booleanValue();
        } else {
            WeakHashMap weakHashMap2 = AbstractC3155s0.f10642a;
            fitsSystemWindows2 = navigationRailView.getFitsSystemWindows();
        }
        if (fitsSystemWindows2) {
            c1819e0.f6439d += c3144o1.mo6228g(7).f8684d;
        }
        WeakHashMap weakHashMap3 = AbstractC3155s0.f10642a;
        boolean z7 = view.getLayoutDirection() == 1;
        int iM6326b = c3153r1.m6326b();
        int iM6327c = c3153r1.m6327c();
        int i6 = c1819e0.f6436a;
        if (z7) {
            iM6326b = iM6327c;
        }
        int i10 = i6 + iM6326b;
        c1819e0.f6436a = i10;
        view.setPaddingRelative(i10, c1819e0.f6437b, c1819e0.f6438c, c1819e0.f6439d);
        return c3153r1;
    }

    @Override
    public void mo99p(Object obj, Object obj2) {
        C4009w c4009w = (C4009w) obj;
        Context context = c4009w.f5071c;
        ComplianceOptions complianceOptions = new ComplianceOptions(-1, -1, 0, true);
        C3990d c3990d = (C3990d) c4009w.m3663p();
        ApiMetadata apiMetadata = new ApiMetadata(complianceOptions);
        C3370o c3370o = (C3370o) this.f9501b;
        Parcel parcelM3687l = c3990d.m3687l();
        AbstractC1542e0.m3810d(parcelM3687l, c3370o.f11379j);
        AbstractC1542e0.m3809c(parcelM3687l, apiMetadata);
        c3990d.m3690y(parcelM3687l, 18);
        C3990d c3990d2 = (C3990d) c4009w.m3663p();
        ApiMetadata apiMetadata2 = new ApiMetadata(complianceOptions);
        Parcel parcelM3687l2 = c3990d2.m3687l();
        AbstractC1542e0.m3809c(parcelM3687l2, apiMetadata2);
        c3990d2.m3690y(parcelM3687l2, 17);
        ((C4056d) obj2).m8059b(null);
    }

    public AudioAttributesImpl mo5758q() {
        return new AudioAttributesImplApi21(((AudioAttributes.Builder) this.f9501b).build());
    }

    public MediaQueueItem m5759r() {
        MediaQueueItem mediaQueueItem = (MediaQueueItem) this.f9501b;
        if (mediaQueueItem.f4695a == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
        if (!Double.isNaN(mediaQueueItem.f4698d) && mediaQueueItem.f4698d < 0.0d) {
            throw new IllegalArgumentException("startTime cannot be negative or NaN.");
        }
        if (Double.isNaN(mediaQueueItem.f4699e)) {
            throw new IllegalArgumentException("playbackDuration cannot be NaN.");
        }
        if (Double.isNaN(mediaQueueItem.f4700f) || mediaQueueItem.f4700f < 0.0d) {
            throw new IllegalArgumentException("preloadTime cannot be negative or Nan.");
        }
        return mediaQueueItem;
    }

    public C3233h mo5760s(int i6) {
        return null;
    }

    @Override
    public void setExtras(Bundle bundle) {
        ((ContentInfo.Builder) this.f9501b).setExtras(bundle);
    }

    @Override
    public void setFlags(int i6) {
        ((ContentInfo.Builder) this.f9501b).setFlags(i6);
    }

    public C3233h mo5761t(int i6) {
        return null;
    }

    public String toString() {
        switch (this.f9500a) {
            case 15:
                return "ContentInfoCompat{" + ((ContentInfo) this.f9501b) + "}";
            case 27:
                return "ProviderMetadata{ componentName=" + ((ComponentName) this.f9501b).flattenToShortString() + " }";
            default:
                return super.toString();
        }
    }

    public C2863a m5762u(C3061i c3061i, MemoryCache$Key memoryCache$Key, C3183h c3183h, EnumC3182g enumC3182g) {
        C2863a c2863aMo232h;
        boolean zEquals;
        C2863a c2863a;
        if (!c3061i.f10481n.f10417a) {
            return null;
        }
        C2864b c2864b = (C2864b) ((C1391l) this.f9501b).f4235c.getValue();
        if (c2864b != null) {
            c2863aMo232h = c2864b.f9792a.mo232h(memoryCache$Key);
            if (c2863aMo232h == null) {
                C1399b c1399b = c2864b.f9793b;
                synchronized (c1399b) {
                    try {
                        ArrayList arrayList = (ArrayList) ((LinkedHashMap) c1399b.f4262b).get(memoryCache$Key);
                        c2863a = null;
                        if (arrayList != null) {
                            int size = arrayList.size();
                            for (int i6 = 0; i6 < size; i6++) {
                                C2867e c2867e = (C2867e) arrayList.get(i6);
                                Bitmap bitmap = (Bitmap) c2867e.f9799b.get();
                                C2863a c2863a2 = bitmap != null ? new C2863a(bitmap, c2867e.f9800c) : null;
                                if (c2863a2 != null) {
                                    c2863a = c2863a2;
                                    break;
                                }
                            }
                            int i10 = c1399b.f4261a;
                            c1399b.f4261a = i10 + 1;
                            if (i10 >= 10) {
                                c1399b.m3269a();
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                c2863aMo232h = c2863a;
            }
        } else {
            c2863aMo232h = null;
        }
        if (c2863aMo232h != null) {
            Bitmap bitmap2 = c2863aMo232h.f9790a;
            Bitmap.Config config = bitmap2.getConfig();
            if (config == null) {
                config = Bitmap.Config.ARGB_8888;
            }
            if (C0026b.m116y(c3061i, config)) {
                Object obj = c2863aMo232h.f9791b.get("coil#is_sampled");
                Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
                boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                if (!AbstractC2796i.m5780a(c3183h, C3183h.f10677c)) {
                    String str = (String) memoryCache$Key.f4374b.get("coil#transformation_size");
                    if (str != null) {
                        zEquals = str.equals(c3183h.toString());
                    } else {
                        int width = bitmap2.getWidth();
                        int height = bitmap2.getHeight();
                        AbstractC3612b abstractC3612b = c3183h.f10678a;
                        int i11 = abstractC3612b instanceof C3176a ? ((C3176a) abstractC3612b).f10667c : Integer.MAX_VALUE;
                        AbstractC3612b abstractC3612b2 = c3183h.f10679b;
                        int i12 = abstractC3612b2 instanceof C3176a ? ((C3176a) abstractC3612b2).f10667c : Integer.MAX_VALUE;
                        double dM6017j = AbstractC2973a.m6017j(width, height, i11, i12, enumC3182g);
                        boolean zM7206a = AbstractC3585d.m7206a(c3061i);
                        if (zM7206a) {
                            double d = dM6017j > 1.0d ? 1.0d : dM6017j;
                            if (Math.abs(((double) i11) - (((double) width) * d)) > 1.0d && Math.abs(((double) i12) - (d * ((double) height))) > 1.0d) {
                                if ((dM6017j == 1.0d && !zM7206a) || (dM6017j > 1.0d && zBooleanValue)) {
                                    zEquals = false;
                                }
                            }
                        } else if ((i11 != Integer.MIN_VALUE && i11 != Integer.MAX_VALUE && Math.abs(i11 - width) > 1) || (i12 != Integer.MIN_VALUE && i12 != Integer.MAX_VALUE && Math.abs(i12 - height) > 1)) {
                            if (dM6017j == 1.0d) {
                                zEquals = false;
                            } else {
                                zEquals = false;
                            }
                        }
                        zEquals = true;
                    }
                } else if (zBooleanValue) {
                    zEquals = false;
                } else {
                    zEquals = true;
                }
            } else {
                zEquals = false;
            }
            if (zEquals) {
                return c2863aMo232h;
            }
        }
        return null;
    }

    public MemoryCache$Key m5763v(C3061i c3061i, Object obj, C3065m c3065m, C1383d c1383d) {
        String strMo5684a;
        Map linkedHashMap;
        c3061i.getClass();
        List list = ((C1391l) this.f9501b).f4239g.f4205c;
        int size = list.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                strMo5684a = null;
                break;
            }
            C4064f c4064f = (C4064f) list.get(i6);
            InterfaceC2683b interfaceC2683b = (InterfaceC2683b) c4064f.f13727a;
            if (((Class) c4064f.f13728b).isAssignableFrom(obj.getClass())) {
                AbstractC2796i.m5783d(interfaceC2683b, "null cannot be cast to non-null type coil.key.Keyer<kotlin.Any>");
                strMo5684a = interfaceC2683b.mo5684a(obj, c3065m);
                if (strMo5684a != null) {
                    break;
                }
            }
            i6++;
        }
        if (strMo5684a == null) {
            return null;
        }
        Map map = c3061i.f10491x.f10513a;
        boolean zIsEmpty = map.isEmpty();
        C4156s c4156s = C4156s.f14075a;
        if (zIsEmpty) {
            linkedHashMap = c4156s;
        } else {
            linkedHashMap = new LinkedHashMap();
            Iterator it = map.entrySet().iterator();
            if (it.hasNext()) {
                ((Map.Entry) it.next()).getValue().getClass();
                throw new ClassCastException();
            }
        }
        List list2 = c3061i.f10473f;
        if (list2.isEmpty() && linkedHashMap.isEmpty()) {
            return new MemoryCache$Key(strMo5684a, c4156s);
        }
        LinkedHashMap linkedHashMapM8199s = AbstractC4158u.m8199s(linkedHashMap);
        if (!list2.isEmpty()) {
            int size2 = list2.size();
            for (int i10 = 0; i10 < size2; i10++) {
                linkedHashMapM8199s.put(AbstractC0004e.m20n(i10, "coil#transformation_"), ((C3351a) list2.get(i10)).f11343e);
            }
            linkedHashMapM8199s.put("coil#transformation_size", c3065m.f10499d.toString());
        }
        return new MemoryCache$Key(strMo5684a, linkedHashMapM8199s);
    }

    public void m5764y(String str) {
        switch (this.f9500a) {
            case 6:
                RunnableC2942w runnableC2942w = (RunnableC2942w) this.f9501b;
                ViewOnKeyListenerC2944y viewOnKeyListenerC2944y = runnableC2942w.f10028b;
                viewOnKeyListenerC2944y.getClass();
                viewOnKeyListenerC2944y.m5966Q(str);
                runnableC2942w.f10028b.f10098r1.f12552p0.setEnabled(true);
                break;
            default:
                RunnableC3015b runnableC3015b = (RunnableC3015b) this.f9501b;
                ViewOnClickListenerC3017d viewOnClickListenerC3017d = runnableC3015b.f10307b;
                viewOnClickListenerC3017d.getClass();
                viewOnClickListenerC3017d.m6093T(str);
                runnableC3015b.f10307b.f10326k0.f12552p0.setEnabled(true);
                break;
        }
    }

    public boolean mo5765z(int i6, int i10, Bundle bundle) {
        return false;
    }

    public C2782c(int i6, boolean z7) {
        this.f9500a = i6;
    }

    public C2782c(MediaInfo mediaInfo) {
        this.f9500a = 24;
        MediaQueueItem mediaQueueItem = new MediaQueueItem(mediaInfo, 0, true, Double.NaN, Double.POSITIVE_INFINITY, 0.0d, null, null);
        if (mediaInfo != null) {
            this.f9501b = mediaQueueItem;
            return;
        }
        throw new IllegalArgumentException("media cannot be null.");
    }

    public C2782c(JSONObject jSONObject) {
        this.f9500a = 24;
        this.f9501b = new MediaQueueItem(jSONObject);
    }

    public C2782c(C1391l c1391l, C0026b c0026b) {
        this.f9500a = 4;
        this.f9501b = c1391l;
    }

    public C2782c(Context context, GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        this.f9500a = 16;
        this.f9501b = new GestureDetector(context, simpleOnGestureListener, null);
    }

    public C2782c(int i6) {
        this.f9500a = i6;
        switch (i6) {
            case 21:
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f9501b = new C3235j(this);
                } else {
                    this.f9501b = new C3234i(this);
                }
                break;
            default:
                this.f9501b = new AudioAttributes.Builder();
                break;
        }
    }

    public C2782c(ContentInfo contentInfo) {
        this.f9500a = 15;
        contentInfo.getClass();
        this.f9501b = AbstractC0685b0.m2097m(contentInfo);
    }

    public C2782c(ClipData clipData, int i6) {
        this.f9500a = 14;
        this.f9501b = AbstractC0685b0.m2095k(clipData, i6);
    }

    @Override
    public void mo226a(int i6) {
    }
}

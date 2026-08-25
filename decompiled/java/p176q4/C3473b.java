package p176q4;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.C0300z;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.zzl;
import com.google.android.gms.common.Feature;
import com.google.android.gms.internal.cast.AbstractC1503a1;
import com.google.android.gms.internal.cast.AbstractC1542e0;
import com.google.android.gms.internal.cast.AbstractC1581i;
import com.google.android.gms.internal.cast.BinderC1571h;
import com.google.android.gms.internal.cast.BinderC1703v;
import com.google.android.gms.internal.cast.C1512b0;
import com.google.android.gms.internal.cast.C1591j;
import com.google.android.gms.internal.cast.C1636n4;
import com.google.android.gms.internal.cast.C1661q2;
import com.google.android.gms.internal.cast.C1667r;
import com.google.android.gms.internal.cast.C1670r2;
import com.google.android.gms.internal.cast.C1674r6;
import com.google.android.gms.internal.cast.C1677s0;
import com.google.android.gms.internal.cast.C1678s1;
import com.google.android.gms.internal.cast.C1685t;
import com.google.android.gms.internal.cast.C1730y;
import com.google.android.gms.internal.cast.EnumC1679s2;
import com.google.android.gms.internal.cast.HandlerC1731y0;
import com.google.android.gms.internal.cast.InterfaceC1659q0;
import com.google.android.gms.internal.cast.InterfaceExecutorServiceC1665q6;
import com.google.android.gms.internal.cast.RunnableC1721x;
import com.google.android.gms.internal.cast.ScheduledExecutorServiceC1701u6;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.bitspark.android.utils.CastOptionsProvider;
import p000a.AbstractC0004e;
import p002a1.C0026b;
import p005a4.C0051j;
import p005a4.C0052k;
import p005a4.C0061t;
import p005a4.InterfaceC0054m;
import p018b5.AbstractC1312l;
import p028c6.C1400c;
import p055ea.AbstractC2460q;
import p123l5.C2974b;
import p165p4.AbstractC3365j;
import p173q1.C3451u0;
import p230v4.C3988b;
import p230v4.C4002p;
import p230v4.C4004r;
import p242w5.InterfaceC4055c;
import p248x3.C4106b;
import p260y3.C4249a;
import p261y4.C4258f;
import p261y4.InterfaceC4254b;

public final class C3473b {

    public static final C3988b f11740k = new C3988b("CastContext", null);

    public static final Object f11741l = new Object();

    public static volatile C3473b f11742m;

    public final Context f11743a;

    public final InterfaceC3488n f11744b;

    public final C3482h f11745c;

    public final C3485k f11746d;

    public final CastOptions f11747e;

    public final C4004r f11748f;

    public final BinderC1571h f11749g;

    public final C1685t f11750h;

    public final C1730y f11751i;

    public final C1591j f11752j;

    public C3473b(Context context, CastOptions castOptions, List list, BinderC1703v binderC1703v, C4004r c4004r) throws C3479e {
        C3492r c3492r;
        InterfaceC1659q0 c1661q2;
        final int i6 = 1;
        final int i10 = 0;
        this.f11743a = context;
        this.f11747e = castOptions;
        this.f11748f = c4004r;
        this.f11750h = new C1685t(context);
        this.f11751i = binderC1703v.f5695h;
        C3499y c3499y = null;
        if (TextUtils.isEmpty(castOptions.f4763a)) {
            this.f11752j = null;
        } else {
            this.f11752j = new C1591j(context, castOptions, binderC1703v);
        }
        HashMap map = new HashMap();
        C1591j c1591j = this.f11752j;
        if (c1591j != null) {
            map.put(c1591j.f5352b, c1591j.f5353c);
        }
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C1591j c1591j2 = (C1591j) it.next();
                AbstractC1312l.m3199f(c1591j2, "Additional SessionProvider must not be null.");
                String str = c1591j2.f5352b;
                AbstractC1312l.m3197d(str, "Category for SessionProvider must not be null or empty string.");
                boolean zContainsKey = map.containsKey(str);
                String strM24r = AbstractC0004e.m24r("SessionProvider for category ", str, " already added");
                if (zContainsKey) {
                    throw new IllegalArgumentException(String.valueOf(strM24r));
                }
                map.put(str, c1591j2.f5353c);
            }
        }
        castOptions.f4778p = new zzl(1);
        try {
            InterfaceC3488n interfaceC3488nM3842a = AbstractC1581i.m3842a(context, castOptions, binderC1703v, map);
            this.f11744b = interfaceC3488nM3842a;
            try {
                C3486l c3486l = (C3486l) interfaceC3488nM3842a;
                Parcel parcelM3688w = c3486l.m3688w(c3486l.m3687l(), 6);
                IBinder strongBinder = parcelM3688w.readStrongBinder();
                if (strongBinder == null) {
                    c3492r = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.cast.framework.IDiscoveryManager");
                    c3492r = iInterfaceQueryLocalInterface instanceof C3492r ? (C3492r) iInterfaceQueryLocalInterface : new C3492r(strongBinder, "com.google.android.gms.cast.framework.IDiscoveryManager", 0);
                }
                parcelM3688w.recycle();
                this.f11746d = new C3485k(c3492r);
                try {
                    C3486l c3486l2 = (C3486l) interfaceC3488nM3842a;
                    Parcel parcelM3688w2 = c3486l2.m3688w(c3486l2.m3687l(), 5);
                    IBinder strongBinder2 = parcelM3688w2.readStrongBinder();
                    if (strongBinder2 != null) {
                        IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.cast.framework.ISessionManager");
                        c3499y = iInterfaceQueryLocalInterface2 instanceof C3499y ? (C3499y) iInterfaceQueryLocalInterface2 : new C3499y(strongBinder2, "com.google.android.gms.cast.framework.ISessionManager", 0);
                    }
                    parcelM3688w2.recycle();
                    C3482h c3482h = new C3482h(c3499y, context);
                    this.f11745c = c3482h;
                    AbstractC1312l.m3197d("PrecacheManager", "The log tag cannot be null or empty.");
                    C1730y c1730y = this.f11751i;
                    if (c1730y != null) {
                        c1730y.f5733f = c3482h;
                        HandlerC1731y0 handlerC1731y0 = c1730y.f5730c;
                        AbstractC1312l.m3198e(handlerC1731y0);
                        handlerC1731y0.post(new RunnableC1721x(c1730y, 1));
                    }
                    if (Build.VERSION.SDK_INT >= 23) {
                        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(3);
                        c1661q2 = new C1677s0(context, executorServiceNewFixedThreadPool instanceof InterfaceExecutorServiceC1665q6 ? (InterfaceExecutorServiceC1665q6) executorServiceNewFixedThreadPool : executorServiceNewFixedThreadPool instanceof ScheduledExecutorService ? new ScheduledExecutorServiceC1701u6((ScheduledExecutorService) executorServiceNewFixedThreadPool) : new C1674r6(executorServiceNewFixedThreadPool));
                    } else {
                        c1661q2 = new C1661q2(18);
                    }
                    AbstractC1312l.m3197d("BaseNetUtils", "The log tag cannot be null or empty.");
                    c1661q2.mo3972a();
                    BinderC1571h binderC1571h = new BinderC1571h();
                    this.f11749g = binderC1571h;
                    try {
                        C3486l c3486l3 = (C3486l) interfaceC3488nM3842a;
                        Parcel parcelM3687l = c3486l3.m3687l();
                        AbstractC1542e0.m3810d(parcelM3687l, binderC1571h);
                        c3486l3.m3689x(parcelM3687l, 3);
                        binderC1571h.f5331e.add(this.f11750h.f5677a);
                        if (!Collections.unmodifiableList(castOptions.f4774l).isEmpty()) {
                            C3988b c3988b = f11740k;
                            Log.i(c3988b.f13521a, c3988b.m7977d("Setting Route Discovery for appIds: ".concat(String.valueOf(Collections.unmodifiableList(this.f11747e.f4774l))), new Object[0]));
                            C1685t c1685t = this.f11750h;
                            List listUnmodifiableList = Collections.unmodifiableList(this.f11747e.f4774l);
                            c1685t.getClass();
                            C3988b c3988b2 = C1685t.f5676f;
                            c3988b2.m7975b(AbstractC2460q.m5492f(listUnmodifiableList.size(), "SetRouteDiscovery for ", " IDs"), new Object[0]);
                            LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
                            Iterator it2 = listUnmodifiableList.iterator();
                            while (it2.hasNext()) {
                                linkedHashSet.add(AbstractC1503a1.m3695f((String) it2.next()));
                            }
                            Map map2 = c1685t.f5679c;
                            c3988b2.m7975b("resetting routes. appIdToRouteInfo has these appId route keys: ".concat(String.valueOf(map2.keySet())), new Object[0]);
                            HashMap map3 = new HashMap();
                            synchronized (map2) {
                                try {
                                    for (String str2 : linkedHashSet) {
                                        C1667r c1667r = (C1667r) map2.get(AbstractC1503a1.m3695f(str2));
                                        if (c1667r != null) {
                                            map3.put(str2, c1667r);
                                        }
                                    }
                                    map2.clear();
                                    map2.putAll(map3);
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            c3988b2.m7975b("Routes reset. appIdToRouteInfo has these appId route keys: ".concat(String.valueOf(map2.keySet())), new Object[0]);
                            LinkedHashSet linkedHashSet2 = c1685t.f5680d;
                            synchronized (linkedHashSet2) {
                                linkedHashSet2.clear();
                                linkedHashSet2.addAll(linkedHashSet);
                            }
                            c1685t.m4021o();
                        }
                        c4004r.m8001d(new String[]{"com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED", "com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_MODE", "com.google.android.gms.cast.FLAG_FIRELOG_UPLOAD_MODE", "com.google.android.gms.cast.FLAG_ANALYTICS_LOGGING_BUCKET_SIZE", "com.google.android.gms.cast.FLAG_CLIENT_FEATURE_USAGE_ANALYTICS_ENABLED", "com.google.android.gms.cast.FLAG_CLIENT_ANALYTICS_ENABLED", "com.google.android.gms.cast.FLAG_ANALYTICS_CONSENT_TIMEOUT_SECONDS"}).m7129b(new InterfaceC4055c(this) {

                            public final C3473b f11739b;

                            {
                                this.f11739b = this;
                            }

                            @Override
                            public final void onSuccess(Object obj) {
                                Set setSingleton;
                                byte[] bytes;
                                C1670r2 c1670r2;
                                EnumC1679s2 enumC1679s2M3990b;
                                switch (i10) {
                                    case 0:
                                        C3473b c3473b = this.f11739b;
                                        Bundle bundle = (Bundle) obj;
                                        if (C1678s1.f5603k) {
                                            Context context2 = c3473b.f11743a;
                                            C4004r c4004r2 = c3473b.f11748f;
                                            C1678s1 c1678s1 = new C1678s1(context2, c4004r2, c3473b.f11745c, c3473b.f11751i, c3473b.f11749g);
                                            int i11 = bundle.containsKey("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_MODE") ? bundle.getInt("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_MODE", 0) : (bundle.containsKey("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED") && bundle.getBoolean("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED", false)) ? 1 : 0;
                                            boolean z7 = bundle.getBoolean("com.google.android.gms.cast.FLAG_CLIENT_FEATURE_USAGE_ANALYTICS_ENABLED", false);
                                            boolean z10 = bundle.getBoolean("com.google.android.gms.cast.FLAG_CLIENT_ANALYTICS_ENABLED", false);
                                            C1678s1.f5603k = z10;
                                            if (i11 == 0) {
                                                if (!z7 && !z10) {
                                                    return;
                                                } else {
                                                    i11 = 0;
                                                }
                                            }
                                            c1678s1.f5611h = new C1512b0(context2, bundle.getLong("com.google.android.gms.cast.FLAG_ANALYTICS_CONSENT_TIMEOUT_SECONDS", 5L));
                                            String packageName = context2.getPackageName();
                                            Locale locale = Locale.ROOT;
                                            String strM5494h = AbstractC2460q.m5494h(packageName, ".client_cast_analytics_data");
                                            c1678s1.f5612i = bundle.getLong("com.google.android.gms.cast.FLAG_FIRELOG_UPLOAD_MODE") == 0 ? 1 : 2;
                                            C0061t.m207b(context2);
                                            C0061t c0061tM206a = C0061t.m206a();
                                            C4249a c4249a = C4249a.f14436e;
                                            c0061tM206a.getClass();
                                            if (c4249a instanceof InterfaceC0054m) {
                                                c4249a.getClass();
                                                setSingleton = Collections.unmodifiableSet(C4249a.f14435d);
                                            } else {
                                                setSingleton = Collections.singleton(new C4106b("proto"));
                                            }
                                            C0026b c0026bM203a = C0051j.m203a();
                                            c4249a.getClass();
                                            c0026bM203a.f54b = "cct";
                                            String str3 = c4249a.f14437a;
                                            String str4 = c4249a.f14438b;
                                            if (str4 == null && str3 == null) {
                                                bytes = null;
                                            } else {
                                                if (str4 == null) {
                                                    str4 = "";
                                                }
                                                bytes = ("1$" + str3 + "\\" + str4).getBytes(Charset.forName("UTF-8"));
                                            }
                                            c0026bM203a.f55c = bytes;
                                            C0051j c0051jM130h = c0026bM203a.m130h();
                                            C4106b c4106b = new C4106b("proto");
                                            C1661q2 c1661q3 = new C1661q2(19);
                                            if (!setSingleton.contains(c4106b)) {
                                                throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", c4106b, setSingleton));
                                            }
                                            c1678s1.f5610g = new C0026b(c0051jM130h, c4106b, c1661q3, c0061tM206a);
                                            if (bundle.containsKey("com.google.android.gms.cast.FLAG_ANALYTICS_LOGGING_BUCKET_SIZE")) {
                                                c1678s1.f5608e = Long.valueOf(bundle.getLong("com.google.android.gms.cast.FLAG_ANALYTICS_LOGGING_BUCKET_SIZE"));
                                            }
                                            SharedPreferences sharedPreferences = context2.getApplicationContext().getSharedPreferences(strM5494h, 0);
                                            if (i11 != 0) {
                                                C1400c c1400cM3273c = C1400c.m3273c();
                                                c1400cM3273c.f4265c = new C4002p(c4004r2, new String[]{"com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_ERROR", "com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_CHANGE_REASON"}, 0);
                                                c1400cM3273c.f4266d = new Feature[]{AbstractC3365j.f11358c};
                                                c1400cM3273c.f4264b = false;
                                                c1400cM3273c.f4263a = 8426;
                                                c4004r2.m8306c(0, c1400cM3273c.m3275b()).m7129b(new C0300z(c1678s1, packageName, i11, sharedPreferences));
                                            }
                                            if (z7) {
                                                AbstractC1312l.m3198e(sharedPreferences);
                                                C3988b c3988b3 = C1670r2.f5576i;
                                                synchronized (C1670r2.class) {
                                                    try {
                                                        if (C1670r2.f5578k == null) {
                                                            C1670r2.f5578k = new C1670r2(sharedPreferences, c1678s1, packageName);
                                                        }
                                                        c1670r2 = C1670r2.f5578k;
                                                    } catch (Throwable th2) {
                                                        throw th2;
                                                    }
                                                }
                                                HashSet hashSet = c1670r2.f5584f;
                                                SharedPreferences sharedPreferences2 = c1670r2.f5580b;
                                                String string = sharedPreferences2.getString("feature_usage_sdk_version", null);
                                                String string2 = sharedPreferences2.getString("feature_usage_package_name", null);
                                                hashSet.clear();
                                                HashSet hashSet2 = c1670r2.f5585g;
                                                hashSet2.clear();
                                                c1670r2.f5586h = 0L;
                                                String str5 = C1670r2.f5577j;
                                                boolean zEquals = str5.equals(string);
                                                String str6 = c1670r2.f5581c;
                                                if (zEquals && str6.equals(string2)) {
                                                    c1670r2.f5586h = sharedPreferences2.getLong("feature_usage_last_report_time", 0L);
                                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                                    HashSet hashSet3 = new HashSet();
                                                    for (String str7 : sharedPreferences2.getAll().keySet()) {
                                                        if (str7.startsWith("feature_usage_timestamp_")) {
                                                            long j10 = sharedPreferences2.getLong(str7, 0L);
                                                            if (j10 != 0 && jCurrentTimeMillis - j10 > 1209600000) {
                                                                hashSet3.add(str7);
                                                            } else if (str7.startsWith("feature_usage_timestamp_reported_feature_")) {
                                                                EnumC1679s2 enumC1679s2M3990b2 = C1670r2.m3990b(str7.substring(41));
                                                                if (enumC1679s2M3990b2 != null) {
                                                                    hashSet2.add(enumC1679s2M3990b2);
                                                                    hashSet.add(enumC1679s2M3990b2);
                                                                }
                                                            } else if (str7.startsWith("feature_usage_timestamp_detected_feature_") && (enumC1679s2M3990b = C1670r2.m3990b(str7.substring(41))) != null) {
                                                                hashSet.add(enumC1679s2M3990b);
                                                            }
                                                        }
                                                    }
                                                    c1670r2.m3991c(hashSet3);
                                                    AbstractC1312l.m3198e(c1670r2.f5583e);
                                                    AbstractC1312l.m3198e(c1670r2.f5582d);
                                                    c1670r2.f5583e.post(c1670r2.f5582d);
                                                } else {
                                                    HashSet hashSet4 = new HashSet();
                                                    for (String str8 : sharedPreferences2.getAll().keySet()) {
                                                        if (str8.startsWith("feature_usage_timestamp_")) {
                                                            hashSet4.add(str8);
                                                        }
                                                    }
                                                    hashSet4.add("feature_usage_last_report_time");
                                                    c1670r2.m3991c(hashSet4);
                                                    sharedPreferences2.edit().putString("feature_usage_sdk_version", str5).putString("feature_usage_package_name", str6).apply();
                                                }
                                                C1670r2.m3989a(EnumC1679s2.CAST_CONTEXT);
                                            }
                                            if (C1678s1.f5603k) {
                                                C1636n4.m3953a();
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    default:
                                        AbstractC1503a1.m3697h("com.google.android.gms.cast.MAP_CAST_STATUS_CODES_TO_CAST_REASON_CODES", (Bundle) obj);
                                        this.f11739b.getClass();
                                        return;
                                }
                            }
                        });
                        C1400c c1400cM3273c = C1400c.m3273c();
                        c1400cM3273c.f4265c = new C4002p(c4004r, new String[]{"com.google.android.gms.cast.MAP_CAST_STATUS_CODES_TO_CAST_REASON_CODES"}, 2);
                        c1400cM3273c.f4266d = new Feature[]{AbstractC3365j.f11359d};
                        c1400cM3273c.f4264b = false;
                        c1400cM3273c.f4263a = 8427;
                        c4004r.m8306c(0, c1400cM3273c.m3275b()).m7129b(new InterfaceC4055c(this) {

                            public final C3473b f11739b;

                            {
                                this.f11739b = this;
                            }

                            @Override
                            public final void onSuccess(Object obj) {
                                Set setSingleton;
                                byte[] bytes;
                                C1670r2 c1670r2;
                                EnumC1679s2 enumC1679s2M3990b;
                                switch (i6) {
                                    case 0:
                                        C3473b c3473b = this.f11739b;
                                        Bundle bundle = (Bundle) obj;
                                        if (C1678s1.f5603k) {
                                            Context context2 = c3473b.f11743a;
                                            C4004r c4004r2 = c3473b.f11748f;
                                            C1678s1 c1678s1 = new C1678s1(context2, c4004r2, c3473b.f11745c, c3473b.f11751i, c3473b.f11749g);
                                            int i11 = bundle.containsKey("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_MODE") ? bundle.getInt("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_MODE", 0) : (bundle.containsKey("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED") && bundle.getBoolean("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED", false)) ? 1 : 0;
                                            boolean z7 = bundle.getBoolean("com.google.android.gms.cast.FLAG_CLIENT_FEATURE_USAGE_ANALYTICS_ENABLED", false);
                                            boolean z10 = bundle.getBoolean("com.google.android.gms.cast.FLAG_CLIENT_ANALYTICS_ENABLED", false);
                                            C1678s1.f5603k = z10;
                                            if (i11 == 0) {
                                                if (!z7 && !z10) {
                                                    return;
                                                } else {
                                                    i11 = 0;
                                                }
                                            }
                                            c1678s1.f5611h = new C1512b0(context2, bundle.getLong("com.google.android.gms.cast.FLAG_ANALYTICS_CONSENT_TIMEOUT_SECONDS", 5L));
                                            String packageName = context2.getPackageName();
                                            Locale locale = Locale.ROOT;
                                            String strM5494h = AbstractC2460q.m5494h(packageName, ".client_cast_analytics_data");
                                            c1678s1.f5612i = bundle.getLong("com.google.android.gms.cast.FLAG_FIRELOG_UPLOAD_MODE") == 0 ? 1 : 2;
                                            C0061t.m207b(context2);
                                            C0061t c0061tM206a = C0061t.m206a();
                                            C4249a c4249a = C4249a.f14436e;
                                            c0061tM206a.getClass();
                                            if (c4249a instanceof InterfaceC0054m) {
                                                c4249a.getClass();
                                                setSingleton = Collections.unmodifiableSet(C4249a.f14435d);
                                            } else {
                                                setSingleton = Collections.singleton(new C4106b("proto"));
                                            }
                                            C0026b c0026bM203a = C0051j.m203a();
                                            c4249a.getClass();
                                            c0026bM203a.f54b = "cct";
                                            String str3 = c4249a.f14437a;
                                            String str4 = c4249a.f14438b;
                                            if (str4 == null && str3 == null) {
                                                bytes = null;
                                            } else {
                                                if (str4 == null) {
                                                    str4 = "";
                                                }
                                                bytes = ("1$" + str3 + "\\" + str4).getBytes(Charset.forName("UTF-8"));
                                            }
                                            c0026bM203a.f55c = bytes;
                                            C0051j c0051jM130h = c0026bM203a.m130h();
                                            C4106b c4106b = new C4106b("proto");
                                            C1661q2 c1661q3 = new C1661q2(19);
                                            if (!setSingleton.contains(c4106b)) {
                                                throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", c4106b, setSingleton));
                                            }
                                            c1678s1.f5610g = new C0026b(c0051jM130h, c4106b, c1661q3, c0061tM206a);
                                            if (bundle.containsKey("com.google.android.gms.cast.FLAG_ANALYTICS_LOGGING_BUCKET_SIZE")) {
                                                c1678s1.f5608e = Long.valueOf(bundle.getLong("com.google.android.gms.cast.FLAG_ANALYTICS_LOGGING_BUCKET_SIZE"));
                                            }
                                            SharedPreferences sharedPreferences = context2.getApplicationContext().getSharedPreferences(strM5494h, 0);
                                            if (i11 != 0) {
                                                C1400c c1400cM3273c2 = C1400c.m3273c();
                                                c1400cM3273c2.f4265c = new C4002p(c4004r2, new String[]{"com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_ERROR", "com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_CHANGE_REASON"}, 0);
                                                c1400cM3273c2.f4266d = new Feature[]{AbstractC3365j.f11358c};
                                                c1400cM3273c2.f4264b = false;
                                                c1400cM3273c2.f4263a = 8426;
                                                c4004r2.m8306c(0, c1400cM3273c2.m3275b()).m7129b(new C0300z(c1678s1, packageName, i11, sharedPreferences));
                                            }
                                            if (z7) {
                                                AbstractC1312l.m3198e(sharedPreferences);
                                                C3988b c3988b3 = C1670r2.f5576i;
                                                synchronized (C1670r2.class) {
                                                    try {
                                                        if (C1670r2.f5578k == null) {
                                                            C1670r2.f5578k = new C1670r2(sharedPreferences, c1678s1, packageName);
                                                        }
                                                        c1670r2 = C1670r2.f5578k;
                                                    } catch (Throwable th2) {
                                                        throw th2;
                                                    }
                                                }
                                                HashSet hashSet = c1670r2.f5584f;
                                                SharedPreferences sharedPreferences2 = c1670r2.f5580b;
                                                String string = sharedPreferences2.getString("feature_usage_sdk_version", null);
                                                String string2 = sharedPreferences2.getString("feature_usage_package_name", null);
                                                hashSet.clear();
                                                HashSet hashSet2 = c1670r2.f5585g;
                                                hashSet2.clear();
                                                c1670r2.f5586h = 0L;
                                                String str5 = C1670r2.f5577j;
                                                boolean zEquals = str5.equals(string);
                                                String str6 = c1670r2.f5581c;
                                                if (zEquals && str6.equals(string2)) {
                                                    c1670r2.f5586h = sharedPreferences2.getLong("feature_usage_last_report_time", 0L);
                                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                                    HashSet hashSet3 = new HashSet();
                                                    for (String str7 : sharedPreferences2.getAll().keySet()) {
                                                        if (str7.startsWith("feature_usage_timestamp_")) {
                                                            long j10 = sharedPreferences2.getLong(str7, 0L);
                                                            if (j10 != 0 && jCurrentTimeMillis - j10 > 1209600000) {
                                                                hashSet3.add(str7);
                                                            } else if (str7.startsWith("feature_usage_timestamp_reported_feature_")) {
                                                                EnumC1679s2 enumC1679s2M3990b2 = C1670r2.m3990b(str7.substring(41));
                                                                if (enumC1679s2M3990b2 != null) {
                                                                    hashSet2.add(enumC1679s2M3990b2);
                                                                    hashSet.add(enumC1679s2M3990b2);
                                                                }
                                                            } else if (str7.startsWith("feature_usage_timestamp_detected_feature_") && (enumC1679s2M3990b = C1670r2.m3990b(str7.substring(41))) != null) {
                                                                hashSet.add(enumC1679s2M3990b);
                                                            }
                                                        }
                                                    }
                                                    c1670r2.m3991c(hashSet3);
                                                    AbstractC1312l.m3198e(c1670r2.f5583e);
                                                    AbstractC1312l.m3198e(c1670r2.f5582d);
                                                    c1670r2.f5583e.post(c1670r2.f5582d);
                                                } else {
                                                    HashSet hashSet4 = new HashSet();
                                                    for (String str8 : sharedPreferences2.getAll().keySet()) {
                                                        if (str8.startsWith("feature_usage_timestamp_")) {
                                                            hashSet4.add(str8);
                                                        }
                                                    }
                                                    hashSet4.add("feature_usage_last_report_time");
                                                    c1670r2.m3991c(hashSet4);
                                                    sharedPreferences2.edit().putString("feature_usage_sdk_version", str5).putString("feature_usage_package_name", str6).apply();
                                                }
                                                C1670r2.m3989a(EnumC1679s2.CAST_CONTEXT);
                                            }
                                            if (C1678s1.f5603k) {
                                                C1636n4.m3953a();
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    default:
                                        AbstractC1503a1.m3697h("com.google.android.gms.cast.MAP_CAST_STATUS_CODES_TO_CAST_REASON_CODES", (Bundle) obj);
                                        this.f11739b.getClass();
                                        return;
                                }
                            }
                        });
                    } catch (RemoteException e5) {
                        throw new IllegalStateException("Failed to call addAppVisibilityListener", e5);
                    }
                } catch (RemoteException e10) {
                    throw new IllegalStateException("Failed to call getSessionManagerImpl", e10);
                }
            } catch (RemoteException e11) {
                throw new IllegalStateException("Failed to call getDiscoveryManagerImpl", e11);
            }
        } catch (RemoteException e12) {
            throw new IllegalStateException("Failed to call newCastContextImpl", e12);
        }
    }

    public static C3473b m7099b(Context context) {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        if (f11742m == null) {
            synchronized (f11741l) {
                if (f11742m == null) {
                    Context applicationContext = context.getApplicationContext();
                    CastOptionsProvider castOptionsProviderM7101d = m7101d(applicationContext);
                    CastOptions castOptions = castOptionsProviderM7101d.getCastOptions(applicationContext);
                    C4004r c4004r = new C4004r(applicationContext, C4004r.f13565j, InterfaceC4254b.f14452a0, C4258f.f14454c);
                    try {
                        f11742m = new C3473b(applicationContext, castOptions, castOptionsProviderM7101d.getAdditionalSessionProviders(applicationContext), new BinderC1703v(applicationContext, C3451u0.m7069d(applicationContext), castOptions, c4004r), c4004r);
                    } catch (C3479e e5) {
                        throw new RuntimeException(e5);
                    }
                }
            }
        }
        return f11742m;
    }

    public static C3473b m7100c(Activity activity) {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        try {
            return m7099b(activity);
        } catch (RuntimeException e5) {
            Object[] objArr = {e5};
            C3988b c3988b = f11740k;
            Log.e(c3988b.f13521a, c3988b.m7977d("Failed to load module from Google Play services. Cast will not work properly. Might due to outdated Google Play services. Ignoring this failure silently.", objArr));
            return null;
        }
    }

    public static CastOptionsProvider m7101d(Context context) {
        try {
            C0052k c0052kM6025a = C2974b.m6025a(context);
            Bundle bundle = c0052kM6025a.f155b.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                f11740k.m7976c(new Object[0]);
            }
            String string = bundle.getString("com.google.android.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME");
            if (string != null) {
                return (CastOptionsProvider) Class.forName(string).asSubclass(CastOptionsProvider.class).getDeclaredConstructor(null).newInstance(null);
            }
            throw new IllegalStateException("The fully qualified name of the implementation of OptionsProvider must be provided as a metadata in the AndroidManifest.xml with key com.google.android.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME.");
        } catch (PackageManager.NameNotFoundException e5) {
            e = e5;
            throw new IllegalStateException("Failed to initialize CastContext.", e);
        } catch (ClassNotFoundException e10) {
            e = e10;
            throw new IllegalStateException("Failed to initialize CastContext.", e);
        } catch (IllegalAccessException e11) {
            e = e11;
            throw new IllegalStateException("Failed to initialize CastContext.", e);
        } catch (InstantiationException e12) {
            e = e12;
            throw new IllegalStateException("Failed to initialize CastContext.", e);
        } catch (NoSuchMethodException e13) {
            e = e13;
            throw new IllegalStateException("Failed to initialize CastContext.", e);
        } catch (NullPointerException e14) {
            e = e14;
            throw new IllegalStateException("Failed to initialize CastContext.", e);
        } catch (InvocationTargetException e15) {
            e = e15;
            throw new IllegalStateException("Failed to initialize CastContext.", e);
        }
    }

    public final C3482h m7102a() {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        return this.f11745c;
    }
}

package p260y3;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.util.SparseArray;
import androidx.media3.extractor.MpegAudioUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import p005a4.C0049h;
import p005a4.C0050i;
import p017b4.InterfaceC1300g;
import p055ea.AbstractC2460q;
import p101j7.C2782c;
import p101j7.C2784e;
import p110k4.InterfaceC2890a;
import p270z3.AbstractC4307a;
import p270z3.AbstractC4321o;
import p270z3.AbstractC4323q;
import p270z3.AbstractC4324r;
import p270z3.AbstractC4325s;
import p270z3.AbstractC4328v;
import p270z3.C4308b;
import p270z3.C4309c;
import p270z3.C4310d;
import p270z3.C4311e;
import p270z3.C4312f;
import p270z3.C4313g;
import p270z3.C4314h;
import p270z3.C4315i;
import p270z3.C4316j;
import p270z3.C4317k;
import p270z3.C4318l;
import p270z3.C4320n;
import p270z3.EnumC4326t;
import p270z3.EnumC4327u;

public final class C4252d implements InterfaceC1300g {

    public final C2782c f14445a;

    public final ConnectivityManager f14446b;

    public final Context f14447c;

    public final URL f14448d;

    public final InterfaceC2890a f14449e;

    public final InterfaceC2890a f14450f;

    public final int f14451g;

    public C4252d(Context context, InterfaceC2890a interfaceC2890a, InterfaceC2890a interfaceC2890a2) {
        C2784e c2784e = new C2784e();
        C4309c c4309c = C4309c.f14623a;
        c2784e.m5766a(AbstractC4321o.class, c4309c);
        c2784e.m5766a(C4315i.class, c4309c);
        C4312f c4312f = C4312f.f14636a;
        c2784e.m5766a(AbstractC4325s.class, c4312f);
        c2784e.m5766a(C4318l.class, c4312f);
        C4310d c4310d = C4310d.f14625a;
        c2784e.m5766a(AbstractC4323q.class, c4310d);
        c2784e.m5766a(C4316j.class, c4310d);
        C4308b c4308b = C4308b.f14610a;
        c2784e.m5766a(AbstractC4307a.class, c4308b);
        c2784e.m5766a(C4314h.class, c4308b);
        C4311e c4311e = C4311e.f14628a;
        c2784e.m5766a(AbstractC4324r.class, c4311e);
        c2784e.m5766a(C4317k.class, c4311e);
        C4313g c4313g = C4313g.f14644a;
        c2784e.m5766a(AbstractC4328v.class, c4313g);
        c2784e.m5766a(C4320n.class, c4313g);
        c2784e.f9510d = true;
        this.f14445a = new C2782c(0, c2784e);
        this.f14447c = context;
        this.f14446b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f14448d = m8302b(C4249a.f14434c);
        this.f14449e = interfaceC2890a2;
        this.f14450f = interfaceC2890a;
        this.f14451g = MpegAudioUtil.MAX_RATE_BYTES_PER_SECOND;
    }

    public static URL m8302b(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e5) {
            throw new IllegalArgumentException(AbstractC2460q.m5501o("Invalid url: ", str), e5);
        }
    }

    public final C0050i m8303a(C0050i c0050i) {
        int type;
        int subtype;
        HashMap map;
        NetworkInfo activeNetworkInfo = this.f14446b.getActiveNetworkInfo();
        C0049h c0049hM202c = c0050i.m202c();
        int i6 = Build.VERSION.SDK_INT;
        HashMap map2 = (HashMap) c0049hM202c.f144f;
        if (map2 == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        map2.put("sdk-version", String.valueOf(i6));
        c0049hM202c.m197a("model", Build.MODEL);
        c0049hM202c.m197a("hardware", Build.HARDWARE);
        c0049hM202c.m197a("device", Build.DEVICE);
        c0049hM202c.m197a("product", Build.PRODUCT);
        c0049hM202c.m197a("os-uild", Build.ID);
        c0049hM202c.m197a("manufacturer", Build.MANUFACTURER);
        c0049hM202c.m197a("fingerprint", Build.FINGERPRINT);
        Calendar.getInstance();
        long offset = TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
        HashMap map3 = (HashMap) c0049hM202c.f144f;
        if (map3 == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        map3.put("tz-offset", String.valueOf(offset));
        int i10 = -1;
        if (activeNetworkInfo == null) {
            SparseArray sparseArray = EnumC4327u.f14681a;
            type = -1;
        } else {
            type = activeNetworkInfo.getType();
        }
        HashMap map4 = (HashMap) c0049hM202c.f144f;
        if (map4 == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        map4.put("net-type", String.valueOf(type));
        if (activeNetworkInfo != null) {
            subtype = activeNetworkInfo.getSubtype();
            if (subtype == -1) {
                SparseArray sparseArray2 = EnumC4326t.f14679a;
                subtype = 100;
            } else if (((EnumC4326t) EnumC4326t.f14679a.get(subtype)) == null) {
            }
            map = (HashMap) c0049hM202c.f144f;
            if (map != null) {
                throw new IllegalStateException("Property \"autoMetadata\" has not been set");
            }
            map.put("mobile-subtype", String.valueOf(subtype));
            c0049hM202c.m197a("country", Locale.getDefault().getCountry());
            c0049hM202c.m197a("locale", Locale.getDefault().getLanguage());
            Context context = this.f14447c;
            c0049hM202c.m197a("mcc_mnc", ((TelephonyManager) context.getSystemService("phone")).getSimOperator());
            try {
                i10 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException e5) {
                Log.e("TransportRuntime.".concat("CctTransportBackend"), "Unable to find version code for package", e5);
            }
            c0049hM202c.m197a("application_build", Integer.toString(i10));
            return c0049hM202c.m198c();
        }
        SparseArray sparseArray3 = EnumC4326t.f14679a;
        subtype = 0;
        map = (HashMap) c0049hM202c.f144f;
        if (map != null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        map.put("mobile-subtype", String.valueOf(subtype));
        c0049hM202c.m197a("country", Locale.getDefault().getCountry());
        c0049hM202c.m197a("locale", Locale.getDefault().getLanguage());
        Context context2 = this.f14447c;
        c0049hM202c.m197a("mcc_mnc", ((TelephonyManager) context2.getSystemService("phone")).getSimOperator());
        i10 = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionCode;
        c0049hM202c.m197a("application_build", Integer.toString(i10));
        return c0049hM202c.m198c();
    }
}

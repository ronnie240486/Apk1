package p077h4;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.appcompat.widget.C0304z3;
import androidx.media3.common.C0628x;
import androidx.media3.exoplayer.analytics.C0684b;
import androidx.media3.exoplayer.analytics.C0707x;
import androidx.media3.exoplayer.upstream.experimental.C0961a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import p002a1.C0026b;
import p005a4.AbstractC0057p;
import p005a4.C0049h;
import p005a4.C0050i;
import p005a4.C0051j;
import p005a4.C0055n;
import p017b4.C1294a;
import p017b4.C1299f;
import p017b4.InterfaceC1300g;
import p050e4.C2409a;
import p050e4.EnumC2411c;
import p055ea.AbstractC2460q;
import p087i4.C2697b;
import p087i4.C2702g;
import p087i4.InterfaceC2698c;
import p087i4.InterfaceC2699d;
import p098j4.InterfaceC2775b;
import p098j4.InterfaceC2776c;
import p110k4.InterfaceC2890a;
import p156o9.AbstractC3280d;
import p248x3.C4106b;
import p260y3.C4249a;
import p260y3.C4250b;
import p260y3.C4251c;
import p260y3.C4252d;
import p270z3.C4314h;
import p270z3.C4315i;
import p270z3.C4316j;
import p270z3.C4317k;
import p270z3.C4318l;
import p270z3.C4320n;
import p270z3.EnumC4326t;
import p270z3.EnumC4327u;
import p270z3.EnumC4329w;

public final class C2659i {

    public final Context f9277a;

    public final C1299f f9278b;

    public final InterfaceC2699d f9279c;

    public final C2654d f9280d;

    public final Executor f9281e;

    public final InterfaceC2776c f9282f;

    public final InterfaceC2890a f9283g;

    public final InterfaceC2890a f9284h;

    public final InterfaceC2698c f9285i;

    public C2659i(Context context, C1299f c1299f, InterfaceC2699d interfaceC2699d, C2654d c2654d, Executor executor, InterfaceC2776c interfaceC2776c, InterfaceC2890a interfaceC2890a, InterfaceC2890a interfaceC2890a2, InterfaceC2698c interfaceC2698c) {
        this.f9277a = context;
        this.f9278b = c1299f;
        this.f9279c = interfaceC2699d;
        this.f9280d = c2654d;
        this.f9281e = executor;
        this.f9282f = interfaceC2776c;
        this.f9283g = interfaceC2890a;
        this.f9284h = interfaceC2890a2;
        this.f9285i = interfaceC2698c;
    }

    public final void m5669a(final C0051j c0051j, int i6) {
        InterfaceC1300g interfaceC1300g;
        C2702g c2702g;
        C1294a c1294a;
        String str;
        C1294a c1294a2;
        int i10;
        C4251c c4251cM1736b;
        String str2;
        Integer numValueOf;
        String str3;
        C0304z3 c0304z3;
        final C2659i c2659i = this;
        final C0051j c0051j2 = c0051j;
        int i11 = 11;
        final int i12 = 1;
        final int i13 = 0;
        InterfaceC1300g interfaceC1300gM3175a = c2659i.f9278b.m3175a(c0051j2.f151a);
        long jMax = 0;
        while (true) {
            InterfaceC2775b interfaceC2775b = new InterfaceC2775b(c2659i) {

                public final C2659i f9271b;

                {
                    this.f9271b = c2659i;
                }

                @Override
                public final Object execute() {
                    Boolean bool;
                    switch (i13) {
                        case 0:
                            C0051j c0051j3 = c0051j2;
                            C2702g c2702g2 = (C2702g) this.f9271b.f9279c;
                            SQLiteDatabase sQLiteDatabaseM5697a = c2702g2.m5697a();
                            sQLiteDatabaseM5697a.beginTransaction();
                            try {
                                Long lM5694b = C2702g.m5694b(sQLiteDatabaseM5697a, c0051j3);
                                if (lM5694b == null) {
                                    bool = Boolean.FALSE;
                                } else {
                                    Cursor cursorRawQuery = c2702g2.m5697a().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lM5694b.toString()});
                                    try {
                                        Boolean boolValueOf = Boolean.valueOf(cursorRawQuery.moveToNext());
                                        cursorRawQuery.close();
                                        bool = boolValueOf;
                                    } catch (Throwable th) {
                                        cursorRawQuery.close();
                                        throw th;
                                    }
                                }
                                sQLiteDatabaseM5697a.setTransactionSuccessful();
                                sQLiteDatabaseM5697a.endTransaction();
                                return bool;
                            } catch (Throwable th2) {
                                sQLiteDatabaseM5697a.endTransaction();
                                throw th2;
                            }
                        default:
                            C2702g c2702g3 = (C2702g) this.f9271b.f9279c;
                            c2702g3.getClass();
                            return (Iterable) c2702g3.m5698c(new C0684b(c2702g3, 13, c0051j2));
                    }
                }
            };
            C2702g c2702g2 = (C2702g) c2659i.f9282f;
            if (!((Boolean) c2702g2.m5700e(interfaceC2775b)).booleanValue()) {
                c2702g2.m5700e(new C0707x(jMax, c2659i, c0051j2));
                return;
            }
            final Iterable iterable = (Iterable) c2702g2.m5700e(new InterfaceC2775b(c2659i) {

                public final C2659i f9271b;

                {
                    this.f9271b = c2659i;
                }

                @Override
                public final Object execute() {
                    Boolean bool;
                    switch (i12) {
                        case 0:
                            C0051j c0051j3 = c0051j2;
                            C2702g c2702g3 = (C2702g) this.f9271b.f9279c;
                            SQLiteDatabase sQLiteDatabaseM5697a = c2702g3.m5697a();
                            sQLiteDatabaseM5697a.beginTransaction();
                            try {
                                Long lM5694b = C2702g.m5694b(sQLiteDatabaseM5697a, c0051j3);
                                if (lM5694b == null) {
                                    bool = Boolean.FALSE;
                                } else {
                                    Cursor cursorRawQuery = c2702g3.m5697a().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lM5694b.toString()});
                                    try {
                                        Boolean boolValueOf = Boolean.valueOf(cursorRawQuery.moveToNext());
                                        cursorRawQuery.close();
                                        bool = boolValueOf;
                                    } catch (Throwable th) {
                                        cursorRawQuery.close();
                                        throw th;
                                    }
                                }
                                sQLiteDatabaseM5697a.setTransactionSuccessful();
                                sQLiteDatabaseM5697a.endTransaction();
                                return bool;
                            } catch (Throwable th2) {
                                sQLiteDatabaseM5697a.endTransaction();
                                throw th2;
                            }
                        default:
                            C2702g c2702g4 = (C2702g) this.f9271b.f9279c;
                            c2702g4.getClass();
                            return (Iterable) c2702g4.m5698c(new C0684b(c2702g4, 13, c0051j2));
                    }
                }
            });
            if (!iterable.iterator().hasNext()) {
                return;
            }
            byte[] bArr = c0051j2.f152b;
            if (interfaceC1300gM3175a == null) {
                AbstractC3280d.m6591i("Uploader", "Unknown backend for %s, deleting event batch for it...", c0051j2);
                c1294a2 = new C1294a(3, -1L);
                interfaceC1300g = interfaceC1300gM3175a;
                c2702g = c2702g2;
            } else {
                ArrayList<C0050i> arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((C2697b) it.next()).f9383c);
                }
                String str4 = "proto";
                if (bArr != null) {
                    InterfaceC2698c interfaceC2698c = c2659i.f9285i;
                    Objects.requireNonNull(interfaceC2698c);
                    C2409a c2409a = (C2409a) c2702g2.m5700e(new C0628x(i11, interfaceC2698c));
                    C0049h c0049h = new C0049h();
                    c0049h.f144f = new HashMap();
                    c0049h.f142d = Long.valueOf(c2659i.f9283g.mo5893c());
                    c0049h.f143e = Long.valueOf(c2659i.f9284h.mo5893c());
                    c0049h.f139a = "GDT_CLIENT_METRICS";
                    C4106b c4106b = new C4106b("proto");
                    c2409a.getClass();
                    C0026b c0026b = AbstractC0057p.f164a;
                    c0026b.getClass();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        c0026b.m132j(c2409a, byteArrayOutputStream);
                    } catch (IOException unused) {
                    }
                    c0049h.f141c = new C0055n(c4106b, byteArrayOutputStream.toByteArray());
                    arrayList.add(((C4252d) interfaceC1300gM3175a).m8303a(c0049h.m198c()));
                }
                C4252d c4252d = (C4252d) interfaceC1300gM3175a;
                HashMap map = new HashMap();
                for (C0050i c0050i : arrayList) {
                    String str5 = c0050i.f145a;
                    if (map.containsKey(str5)) {
                        ((List) map.get(str5)).add(c0050i);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(c0050i);
                        map.put(str5, arrayList2);
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = map.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry entry = (Map.Entry) it2.next();
                    Iterator it3 = it2;
                    C0050i c0050i2 = (C0050i) ((List) entry.getValue()).get(0);
                    EnumC4329w enumC4329w = EnumC4329w.f14683a;
                    long jMo5893c = c4252d.f14450f.mo5893c();
                    long jMo5893c2 = c4252d.f14449e.mo5893c();
                    C4316j c4316j = new C4316j(new C4314h(Integer.valueOf(c0050i2.m201b("sdk-version")), c0050i2.m200a("model"), c0050i2.m200a("hardware"), c0050i2.m200a("device"), c0050i2.m200a("product"), c0050i2.m200a("os-uild"), c0050i2.m200a("manufacturer"), c0050i2.m200a("fingerprint"), c0050i2.m200a("locale"), c0050i2.m200a("country"), c0050i2.m200a("mcc_mnc"), c0050i2.m200a("application_build")));
                    try {
                        numValueOf = Integer.valueOf(Integer.parseInt((String) entry.getKey()));
                        str2 = null;
                    } catch (NumberFormatException unused2) {
                        str2 = (String) entry.getKey();
                        numValueOf = null;
                    }
                    ArrayList arrayList4 = new ArrayList();
                    Iterator it4 = ((List) entry.getValue()).iterator();
                    while (it4.hasNext()) {
                        InterfaceC1300g interfaceC1300g2 = interfaceC1300gM3175a;
                        C0050i c0050i3 = (C0050i) it4.next();
                        Iterator it5 = it4;
                        C0055n c0055n = c0050i3.f147c;
                        C4106b c4106b2 = c0055n.f161a;
                        boolean zEquals = c4106b2.equals(new C4106b(str4));
                        byte[] bArr2 = c0055n.f162b;
                        if (zEquals) {
                            c0304z3 = new C0304z3();
                            c0304z3.f1158d = bArr2;
                            str3 = str4;
                        } else {
                            str3 = str4;
                            if (c4106b2.equals(new C4106b("json"))) {
                                String str6 = new String(bArr2, Charset.forName("UTF-8"));
                                C0304z3 c0304z4 = new C0304z3();
                                c0304z4.f1159e = str6;
                                c0304z3 = c0304z4;
                            } else {
                                c2702g2 = c2702g2;
                                Log.w("TransportRuntime.".concat("CctTransportBackend"), "Received event of unsupported encoding " + c4106b2 + ". Skipping...");
                            }
                            it4 = it5;
                            interfaceC1300gM3175a = interfaceC1300g2;
                            str4 = str3;
                            c2702g2 = c2702g2;
                        }
                        c0304z3.f1155a = Long.valueOf(c0050i3.f148d);
                        c0304z3.f1157c = Long.valueOf(c0050i3.f149e);
                        String str7 = (String) c0050i3.f150f.get("tz-offset");
                        c0304z3.f1160f = Long.valueOf(str7 == null ? 0L : Long.valueOf(str7).longValue());
                        c0304z3.f1161g = new C4320n((EnumC4327u) EnumC4327u.f14681a.get(c0050i3.m201b("net-type")), (EnumC4326t) EnumC4326t.f14679a.get(c0050i3.m201b("mobile-subtype")));
                        Integer num = c0050i3.f146b;
                        if (num != null) {
                            c0304z3.f1156b = num;
                        }
                        String strM5494h = ((Long) c0304z3.f1155a) == null ? " eventTimeMs" : "";
                        if (((Long) c0304z3.f1157c) == null) {
                            strM5494h = strM5494h.concat(" eventUptimeMs");
                        }
                        if (((Long) c0304z3.f1160f) == null) {
                            strM5494h = AbstractC2460q.m5494h(strM5494h, " timezoneOffsetSeconds");
                        }
                        if (!strM5494h.isEmpty()) {
                            throw new IllegalStateException("Missing required properties:".concat(strM5494h));
                        }
                        arrayList4.add(new C4317k(((Long) c0304z3.f1155a).longValue(), (Integer) c0304z3.f1156b, ((Long) c0304z3.f1157c).longValue(), (byte[]) c0304z3.f1158d, (String) c0304z3.f1159e, ((Long) c0304z3.f1160f).longValue(), (C4320n) c0304z3.f1161g));
                        it4 = it5;
                        interfaceC1300gM3175a = interfaceC1300g2;
                        str4 = str3;
                        c2702g2 = c2702g2;
                    }
                    arrayList3.add(new C4318l(jMo5893c, jMo5893c2, c4316j, numValueOf, str2, arrayList4));
                    it2 = it3;
                    interfaceC1300gM3175a = interfaceC1300gM3175a;
                    str4 = str4;
                    c2702g2 = c2702g2;
                }
                interfaceC1300g = interfaceC1300gM3175a;
                c2702g = c2702g2;
                C4315i c4315i = new C4315i(arrayList3);
                URL urlM8302b = c4252d.f14448d;
                if (bArr != null) {
                    try {
                        C4249a c4249aM8301a = C4249a.m8301a(bArr);
                        str = c4249aM8301a.f14438b;
                        if (str == null) {
                            str = null;
                        }
                        String str8 = c4249aM8301a.f14437a;
                        if (str8 != null) {
                            urlM8302b = C4252d.m8302b(str8);
                        }
                    } catch (IllegalArgumentException unused3) {
                        c1294a = new C1294a(3, -1L);
                    }
                } else {
                    str = null;
                }
                try {
                    C4250b c4250b = new C4250b(urlM8302b, c4315i, str);
                    C0628x c0628x = new C0628x(21, c4252d);
                    int i14 = 5;
                    do {
                        c4251cM1736b = c0628x.m1736b(c4250b);
                        URL url = c4251cM1736b.f14443b;
                        if (url != null) {
                            AbstractC3280d.m6591i("CctTransportBackend", "Following redirect to: %s", url);
                            c4250b = new C4250b(url, c4250b.f14440b, c4250b.f14441c);
                        } else {
                            c4250b = null;
                        }
                        if (c4250b == null) {
                            break;
                        } else {
                            i14--;
                        }
                    } while (i14 >= 1);
                    int i15 = c4251cM1736b.f14442a;
                    if (i15 == 200) {
                        c1294a2 = new C1294a(1, c4251cM1736b.f14444c);
                    } else {
                        if (i15 >= 500 || i15 == 404) {
                            c1294a = new C1294a(2, -1L);
                        } else if (i15 == 400) {
                            try {
                                c1294a = new C1294a(4, -1L);
                            } catch (IOException e5) {
                                e = e5;
                                Log.e("TransportRuntime.".concat("CctTransportBackend"), "Could not make request to the backend", e);
                                i10 = 2;
                                c1294a2 = new C1294a(2, -1L);
                            }
                        } else {
                            c1294a = new C1294a(3, -1L);
                        }
                        c1294a2 = c1294a;
                    }
                } catch (IOException e10) {
                    e = e10;
                }
            }
            i10 = 2;
            int i16 = c1294a2.f4066a;
            if (i16 == i10) {
                final long j10 = jMax;
                c2702g.m5700e(new InterfaceC2775b() {
                    @Override
                    public final Object execute() {
                        C2659i c2659i2 = this.f9273a;
                        C2702g c2702g3 = (C2702g) c2659i2.f9279c;
                        c2702g3.getClass();
                        Iterable iterable2 = iterable;
                        if (iterable2.iterator().hasNext()) {
                            String str9 = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + C2702g.m5695f(iterable2);
                            SQLiteDatabase sQLiteDatabaseM5697a = c2702g3.m5697a();
                            sQLiteDatabaseM5697a.beginTransaction();
                            try {
                                sQLiteDatabaseM5697a.compileStatement(str9).execute();
                                Cursor cursorRawQuery = sQLiteDatabaseM5697a.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name", null);
                                while (cursorRawQuery.moveToNext()) {
                                    try {
                                        c2702g3.m5699d(cursorRawQuery.getInt(0), EnumC2411c.MAX_RETRIES_REACHED, cursorRawQuery.getString(1));
                                    } catch (Throwable th) {
                                        cursorRawQuery.close();
                                        throw th;
                                    }
                                }
                                cursorRawQuery.close();
                                sQLiteDatabaseM5697a.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
                                sQLiteDatabaseM5697a.setTransactionSuccessful();
                                sQLiteDatabaseM5697a.endTransaction();
                            } catch (Throwable th2) {
                                sQLiteDatabaseM5697a.endTransaction();
                                throw th2;
                            }
                        }
                        c2702g3.m5698c(new C0961a(c2659i2.f9283g.mo5893c() + j10, c0051j));
                        return null;
                    }
                });
                this.f9280d.m5668a(c0051j, i6 + 1, true);
                return;
            }
            C2702g c2702g3 = c2702g;
            c2702g3.m5700e(new C0684b(this, 11, iterable));
            if (i16 == 1) {
                jMax = Math.max(jMax, c1294a2.f4067b);
                if (bArr != null) {
                    c2702g3.m5700e(new C0628x(13, this));
                }
            } else {
                if (i16 == 4) {
                    HashMap map2 = new HashMap();
                    Iterator it6 = iterable.iterator();
                    while (it6.hasNext()) {
                        String str9 = ((C2697b) it6.next()).f9383c.f145a;
                        if (map2.containsKey(str9)) {
                            map2.put(str9, Integer.valueOf(((Integer) map2.get(str9)).intValue() + 1));
                        } else {
                            map2.put(str9, 1);
                        }
                    }
                    c2702g3.m5700e(new C0684b(this, 12, map2));
                }
                c0051j2 = c0051j;
                i11 = 11;
                i13 = 0;
                i12 = 1;
                c2659i = this;
                interfaceC1300gM3175a = interfaceC1300g;
            }
            c0051j2 = c0051j;
            i11 = 11;
            i13 = 0;
            i12 = 1;
            c2659i = this;
            interfaceC1300gM3175a = interfaceC1300g;
        }
    }
}

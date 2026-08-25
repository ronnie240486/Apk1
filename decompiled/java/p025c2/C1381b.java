package p025c2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.C0161t0;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.internal.cast.BinderC1571h;
import com.google.android.gms.internal.cast.C1506a4;
import com.google.android.gms.internal.cast.C1507a5;
import com.google.android.gms.internal.cast.C1532d0;
import com.google.android.gms.internal.cast.C1540d8;
import com.google.android.gms.internal.cast.C1561g;
import com.google.android.gms.internal.cast.C1562g0;
import com.google.android.gms.internal.cast.C1575h3;
import com.google.android.gms.internal.cast.C1585i3;
import com.google.android.gms.internal.cast.C1595j3;
import com.google.android.gms.internal.cast.C1605k3;
import com.google.android.gms.internal.cast.C1615l3;
import com.google.android.gms.internal.cast.C1617l5;
import com.google.android.gms.internal.cast.C1625m3;
import com.google.android.gms.internal.cast.C1627m5;
import com.google.android.gms.internal.cast.C1635n3;
import com.google.android.gms.internal.cast.C1644o3;
import com.google.android.gms.internal.cast.C1653p3;
import com.google.android.gms.internal.cast.C1662q3;
import com.google.android.gms.internal.cast.C1671r3;
import com.google.android.gms.internal.cast.C1678s1;
import com.google.android.gms.internal.cast.C1680s3;
import com.google.android.gms.internal.cast.C1733y2;
import com.google.android.gms.internal.cast.C1742z2;
import com.google.android.gms.internal.cast.C1743z3;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.bitspark.android.utils.C3333o;
import p000a.AbstractC0004e;
import p002a1.C0026b;
import p017b4.C1299f;
import p018b5.AbstractC1312l;
import p038d4.InterfaceC2152b;
import p059f6.C2495d;
import p059f6.InterfaceC2496e;
import p067g2.InterfaceC2599f;
import p069g4.C2611a;
import p077h4.C2654d;
import p087i4.InterfaceC2699d;
import p096j2.C2769a;
import p098j4.InterfaceC2776c;
import p116ka.C2909b;
import p176q4.C3475c;
import p199s4.AsyncTaskC3708b;
import p222u7.AbstractC3928d;
import p230v4.C3988b;
import p234v8.InterfaceC4022a;
import p243w8.C4064f;
import p253x8.AbstractC4147j;

public final class C1381b implements InterfaceC2152b {

    public final int f4197a;

    public final Object f4198b;

    public final Object f4199c;

    public Object f4200d;

    public Object f4201e;

    public Object f4202f;

    public C1381b(C1678s1 c1678s1, BinderC1571h binderC1571h, String str) {
        this.f4197a = 1;
        this.f4198b = c1678s1;
        this.f4199c = binderC1571h;
        this.f4200d = str;
        this.f4202f = new C1507a5(this);
    }

    public static void m3250k(C1381b c1381b, C1562g0 c1562g0) {
        int i6 = c1562g0.f5311e;
        if (i6 == 2 && ((C1540d8) c1381b.f4201e) != null) {
            c1381b.m3262m();
        }
        if (i6 == 2) {
            c1381b.f4201e = new C1540d8((C1678s1) c1381b.f4198b, (String) c1381b.f4200d);
        } else {
            c1381b.f4201e = c1381b.m3261l();
        }
        C1540d8 c1540d8 = (C1540d8) c1381b.f4201e;
        AbstractC1312l.m3198e(c1540d8);
        c1562g0.f5310d = c1540d8.f5263h;
        c1540d8.f5257b.add(c1562g0);
    }

    public void m3251a(InterfaceC2599f interfaceC2599f, Class cls) {
        ((ArrayList) this.f4201e).add(new C4064f(interfaceC2599f, cls));
    }

    public void m3252b(C2769a c2769a, Class cls) {
        ((ArrayList) this.f4199c).add(new C4064f(c2769a, cls));
    }

    public void m3253c(Canvas canvas) {
        C2495d c2495d = (C2495d) this.f4201e;
        boolean z7 = c2495d == null || c2495d.f8726c == Float.MAX_VALUE;
        Paint paint = (Paint) this.f4200d;
        ?? r10 = (ViewGroup) this.f4198b;
        View view = (View) this.f4199c;
        if (z7) {
            r10.mo4166d(canvas);
            if (Color.alpha(paint.getColor()) != 0) {
                canvas.drawRect(0.0f, 0.0f, view.getWidth(), view.getHeight(), paint);
            }
        } else {
            r10.mo4166d(canvas);
            if (Color.alpha(paint.getColor()) != 0) {
                canvas.drawRect(0.0f, 0.0f, view.getWidth(), view.getHeight(), paint);
            }
        }
        Drawable drawable = (Drawable) this.f4202f;
        if (drawable == null || ((C2495d) this.f4201e) == null) {
            return;
        }
        Rect bounds = drawable.getBounds();
        float fWidth = ((C2495d) this.f4201e).f8724a - (bounds.width() / 2.0f);
        float fHeight = ((C2495d) this.f4201e).f8725b - (bounds.height() / 2.0f);
        canvas.translate(fWidth, fHeight);
        ((Drawable) this.f4202f).draw(canvas);
        canvas.translate(-fWidth, -fHeight);
    }

    public C2495d m3254d() {
        C2495d c2495d = (C2495d) this.f4201e;
        if (c2495d == null) {
            return null;
        }
        C2495d c2495d2 = new C2495d(c2495d);
        if (c2495d2.f8726c == Float.MAX_VALUE) {
            float f = c2495d2.f8724a;
            float f3 = c2495d2.f8725b;
            View view = (View) this.f4199c;
            c2495d2.f8726c = AbstractC3928d.m7846g(f, f3, view.getWidth(), view.getHeight());
        }
        return c2495d2;
    }

    public boolean m3255e() {
        if (!((ViewGroup) this.f4198b).mo4168h()) {
            return false;
        }
        C2495d c2495d = (C2495d) this.f4201e;
        return c2495d == null || (c2495d.f8726c > Float.MAX_VALUE ? 1 : (c2495d.f8726c == Float.MAX_VALUE ? 0 : -1)) == 0;
    }

    public void m3256f(Drawable drawable) {
        this.f4202f = drawable;
        ((View) this.f4199c).invalidate();
    }

    public void m3257g(int i6) {
        ((Paint) this.f4200d).setColor(i6);
        ((View) this.f4199c).invalidate();
    }

    @Override
    public Object get() {
        return new C2611a((Executor) ((InterfaceC4022a) this.f4198b).get(), (C1299f) ((InterfaceC4022a) this.f4199c).get(), (C2654d) ((C0026b) this.f4200d).get(), (InterfaceC2699d) ((InterfaceC4022a) this.f4201e).get(), (InterfaceC2776c) ((InterfaceC4022a) this.f4202f).get());
    }

    public void m3258h(C2495d c2495d) {
        View view = (View) this.f4199c;
        if (c2495d == null) {
            this.f4201e = null;
        } else {
            C2495d c2495d2 = (C2495d) this.f4201e;
            if (c2495d2 == null) {
                this.f4201e = new C2495d(c2495d);
            } else {
                float f = c2495d.f8724a;
                float f3 = c2495d.f8725b;
                float f4 = c2495d.f8726c;
                c2495d2.f8724a = f;
                c2495d2.f8725b = f3;
                c2495d2.f8726c = f4;
            }
            if (c2495d.f8726c + 1.0E-4f >= AbstractC3928d.m7846g(c2495d.f8724a, c2495d.f8725b, view.getWidth(), view.getHeight())) {
                ((C2495d) this.f4201e).f8726c = Float.MAX_VALUE;
            }
        }
        view.invalidate();
    }

    public void m3259i(Uri uri) {
        int i6;
        if (uri == null) {
            m3260j();
            return;
        }
        if (uri.equals((Uri) this.f4200d)) {
            return;
        }
        m3260j();
        this.f4200d = uri;
        ImageHints imageHints = (ImageHints) this.f4199c;
        int i10 = imageHints.f4840b;
        Context context = (Context) this.f4198b;
        if (i10 == 0 || (i6 = imageHints.f4841c) == 0) {
            this.f4201e = new AsyncTaskC3708b(context, 0, 0, this);
        } else {
            this.f4201e = new AsyncTaskC3708b(context, i10, i6, this);
        }
        AsyncTaskC3708b asyncTaskC3708b = (AsyncTaskC3708b) this.f4201e;
        AbstractC1312l.m3198e(asyncTaskC3708b);
        Uri uri2 = (Uri) this.f4200d;
        AbstractC1312l.m3198e(uri2);
        asyncTaskC3708b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, uri2);
    }

    public void m3260j() {
        AsyncTaskC3708b asyncTaskC3708b = (AsyncTaskC3708b) this.f4201e;
        if (asyncTaskC3708b != null) {
            asyncTaskC3708b.cancel(true);
            this.f4201e = null;
        }
        this.f4200d = null;
    }

    public C1540d8 m3261l() {
        if (((C1540d8) this.f4201e) == null) {
            C1540d8 c1540d8 = new C1540d8((C1678s1) this.f4198b, (String) this.f4200d);
            this.f4201e = c1540d8;
            c1540d8.m3806b(1);
        }
        return (C1540d8) this.f4201e;
    }

    public void m3262m() {
        int i6;
        long jLongValue;
        C1575h3 c1575h3;
        int i10 = 1;
        C1540d8 c1540d8 = (C1540d8) this.f4201e;
        if (c1540d8 != null) {
            C3475c c3475c = c1540d8.f5265j;
            if (c3475c != null) {
                c3475c.f11765l = null;
                c1540d8.f5265j = null;
            }
            C1575h3 c1575h3M3848m = C1585i3.m3848m();
            c1575h3M3848m.m3841c();
            C1585i3.m3861z((C1585i3) c1575h3M3848m.f5338b, c1540d8.f5264i);
            String str = c1540d8.f5267l;
            if (str != null) {
                c1575h3M3848m.m3841c();
                C1585i3.m3858w((C1585i3) c1575h3M3848m.f5338b, str);
            }
            C1617l5 c1617l5M3943l = C1627m5.m3943l();
            if (!TextUtils.isEmpty(c1540d8.f5269n)) {
                String str2 = c1540d8.f5269n;
                c1575h3M3848m.m3841c();
                C1585i3.m3854s((C1585i3) c1575h3M3848m.f5338b, str2);
                String str3 = c1540d8.f5269n;
                c1617l5M3943l.m3841c();
                C1627m5.m3946o((C1627m5) c1617l5M3943l.f5338b, str3);
            }
            if (!TextUtils.isEmpty(c1540d8.f5270o)) {
                String str4 = c1540d8.f5270o;
                c1617l5M3943l.m3841c();
                C1627m5.m3947p((C1627m5) c1617l5M3943l.f5338b, str4);
            }
            if (!TextUtils.isEmpty(c1540d8.f5271p)) {
                String str5 = c1540d8.f5271p;
                c1617l5M3943l.m3841c();
                C1627m5.m3948q((C1627m5) c1617l5M3943l.f5338b, str5);
            }
            if (!TextUtils.isEmpty(c1540d8.f5272q)) {
                String str6 = c1540d8.f5272q;
                c1617l5M3943l.m3841c();
                C1627m5.m3944m((C1627m5) c1617l5M3943l.f5338b, str6);
            }
            if (!TextUtils.isEmpty(c1540d8.f5273r)) {
                String str7 = c1540d8.f5273r;
                c1617l5M3943l.m3841c();
                C1627m5.m3945n((C1627m5) c1617l5M3943l.f5338b, str7);
            }
            if (!TextUtils.isEmpty(c1540d8.f5274s)) {
                String str8 = c1540d8.f5274s;
                c1617l5M3943l.m3841c();
                C1627m5.m3949r((C1627m5) c1617l5M3943l.f5338b, str8);
            }
            int i11 = c1540d8.f5275t;
            if (i11 == 1) {
                i6 = 2;
            } else if (i11 == 2) {
                i6 = 3;
            } else if (i11 == 3) {
                i6 = 4;
            } else if (i11 != 4) {
                i6 = i11 != 5 ? 1 : 6;
            } else {
                i6 = 5;
            }
            c1617l5M3943l.m3841c();
            C1627m5.m3950s((C1627m5) c1617l5M3943l.f5338b, i6);
            C1627m5 c1627m5 = (C1627m5) c1617l5M3943l.m3839a();
            c1575h3M3848m.m3841c();
            C1585i3.m3857v((C1585i3) c1575h3M3848m.f5338b, c1627m5);
            C1733y2 c1733y2M4061l = C1742z2.m4061l();
            String str9 = C1540d8.f5254w;
            c1733y2M4061l.m3841c();
            C1742z2.m4063n((C1742z2) c1733y2M4061l.f5338b, str9);
            c1733y2M4061l.m3841c();
            C1742z2.m4062m((C1742z2) c1733y2M4061l.f5338b, c1540d8.f5262g);
            C1742z2 c1742z2 = (C1742z2) c1733y2M4061l.m3839a();
            c1575h3M3848m.m3841c();
            C1585i3.m3850o((C1585i3) c1575h3M3848m.f5338b, c1742z2);
            C1653p3 c1653p3M3977l = C1662q3.m3977l();
            String str10 = (String) c1540d8.f5256a.mo3969a();
            if (str10 != null) {
                C1743z3 c1743z3M3715l = C1506a4.m3715l();
                c1743z3M3715l.m3841c();
                C1506a4.m3716m((C1506a4) c1743z3M3715l.f5338b, str10);
                C1506a4 c1506a4 = (C1506a4) c1743z3M3715l.m3839a();
                c1653p3M3977l.m3841c();
                C1662q3.m3983r((C1662q3) c1653p3M3977l.f5338b, c1506a4);
            }
            String str11 = c1540d8.f5266k;
            if (str11 != null) {
                try {
                    String strReplace = str11.replace("-", "");
                    jLongValue = new BigInteger(strReplace.substring(0, Math.min(16, strReplace.length())), 16).longValue();
                } catch (NumberFormatException e5) {
                    Object[] objArr = {str11};
                    C3988b c3988b = C1540d8.f5253v;
                    Log.w(c3988b.f13521a, c3988b.m7977d("receiverSessionId %s is not valid for hash", objArr), e5);
                    jLongValue = 0;
                }
                c1653p3M3977l.m3841c();
                C1662q3.m3985t((C1662q3) c1653p3M3977l.f5338b, jLongValue);
            }
            List<C1562g0> list = c1540d8.f5257b;
            if (list.isEmpty()) {
                c1575h3 = c1575h3M3848m;
            } else {
                ArrayList arrayList = new ArrayList();
                for (C1562g0 c1562g0 : list) {
                    c1562g0.getClass();
                    C1635n3 c1635n3M3956l = C1644o3.m3956l();
                    c1635n3M3956l.m3841c();
                    C1644o3.m3961q((C1644o3) c1635n3M3956l.f5338b, c1562g0.f5311e);
                    C1575h3 c1575h4 = c1575h3M3848m;
                    int i12 = (int) (c1562g0.f5308b - c1562g0.f5310d);
                    c1635n3M3956l.m3841c();
                    C1644o3.m3959o((C1644o3) c1635n3M3956l.f5338b, i12);
                    c1635n3M3956l.m3841c();
                    C1644o3.m3960p((C1644o3) c1635n3M3956l.f5338b, i12);
                    Integer num = c1562g0.f5307a;
                    if (num != null) {
                        int iIntValue = num.intValue();
                        c1635n3M3956l.m3841c();
                        C1644o3.m3958n((C1644o3) c1635n3M3956l.f5338b, iIntValue);
                    }
                    Boolean bool = c1562g0.f5309c;
                    if (bool != null) {
                        boolean zBooleanValue = bool.booleanValue();
                        c1635n3M3956l.m3841c();
                        C1644o3.m3957m((C1644o3) c1635n3M3956l.f5338b, zBooleanValue);
                    }
                    arrayList.add((C1644o3) c1635n3M3956l.m3839a());
                    c1575h3M3848m = c1575h4;
                }
                c1575h3 = c1575h3M3848m;
                c1653p3M3977l.m3841c();
                C1662q3.m3978m((C1662q3) c1653p3M3977l.f5338b, arrayList);
            }
            List list2 = c1540d8.f5258c;
            if (!list2.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                Iterator it = list2.iterator();
                if (it.hasNext()) {
                    throw AbstractC0004e.m18l(it);
                }
                c1653p3M3977l.m3841c();
                C1662q3.m3981p((C1662q3) c1653p3M3977l.f5338b, arrayList2);
            }
            List<C1532d0> list3 = c1540d8.f5259d;
            if (!list3.isEmpty()) {
                ArrayList arrayList3 = new ArrayList();
                for (C1532d0 c1532d0 : list3) {
                    c1532d0.getClass();
                    C1595j3 c1595j3M3917l = C1605k3.m3917l();
                    int i13 = 11;
                    switch (c1532d0.f5237a) {
                        case "load":
                            i13 = 2;
                            break;
                        case "play":
                            i13 = 3;
                            break;
                        case "pause":
                            i13 = 4;
                            break;
                        case "stop":
                            i13 = 5;
                            break;
                        case "seek":
                            i13 = 6;
                            break;
                        case "volume":
                            i13 = 7;
                            break;
                        case "mute":
                            i13 = 8;
                            break;
                        case "volume-mute":
                            i13 = 9;
                            break;
                        case "status":
                            i13 = 10;
                            break;
                        case "activeTracks":
                            break;
                        case "trackStyle":
                            i13 = 12;
                            break;
                        case "queueInsert":
                            i13 = 13;
                            break;
                        case "queueUpdate":
                            i13 = 14;
                            break;
                        case "queueRemove":
                            i13 = 15;
                            break;
                        case "queueReorder":
                            i13 = 16;
                            break;
                        case "queueFetchItemIds":
                            i13 = 17;
                            break;
                        case "queueFetchItemRange":
                            i13 = 18;
                            break;
                        case "queueFetchItems":
                            i13 = 19;
                            break;
                        case "setPlaybackRate":
                            i13 = 20;
                            break;
                        case "skipAd":
                            i13 = 21;
                            break;
                        case "launch":
                            i13 = 22;
                            break;
                        case "setPlaybackDevices":
                            i13 = 23;
                            break;
                        default:
                            i13 = 1;
                            break;
                    }
                    c1595j3M3917l.m3841c();
                    C1605k3.m3922q((C1605k3) c1595j3M3917l.f5338b, i13);
                    int i14 = (int) c1532d0.f5238b;
                    c1595j3M3917l.m3841c();
                    C1605k3.m3919n((C1605k3) c1595j3M3917l.f5338b, i14);
                    c1595j3M3917l.m3841c();
                    C1605k3.m3921p((C1605k3) c1595j3M3917l.f5338b, c1532d0.f5239c);
                    int i15 = (int) (c1532d0.f5240d - c1532d0.f5242f);
                    c1595j3M3917l.m3841c();
                    C1605k3.m3920o((C1605k3) c1595j3M3917l.f5338b, i15);
                    int i16 = (int) (c1532d0.f5241e - c1532d0.f5242f);
                    c1595j3M3917l.m3841c();
                    C1605k3.m3918m((C1605k3) c1595j3M3917l.f5338b, i16);
                    arrayList3.add((C1605k3) c1595j3M3917l.m3839a());
                }
                c1653p3M3977l.m3841c();
                C1662q3.m3979n((C1662q3) c1653p3M3977l.f5338b, arrayList3);
            }
            if (c1540d8.f5268m != null) {
                ArrayList arrayList4 = new ArrayList();
                C0161t0 c0161t0 = c1540d8.f5268m;
                c0161t0.getClass();
                C1615l3 c1615l3M3940l = C1625m3.m3940l();
                int i17 = c0161t0.f443a;
                if (i17 == 1) {
                    i10 = 2;
                } else if (i17 == 2) {
                    i10 = 3;
                } else if (i17 == 3) {
                    i10 = 4;
                } else if (i17 == 4) {
                    i10 = 5;
                }
                c1615l3M3940l.m3841c();
                C1625m3.m3942n((C1625m3) c1615l3M3940l.f5338b, i10);
                int i18 = (int) (c0161t0.f444b - c0161t0.f445c);
                c1615l3M3940l.m3841c();
                C1625m3.m3941m((C1625m3) c1615l3M3940l.f5338b, i18);
                arrayList4.add((C1625m3) c1615l3M3940l.m3839a());
                c1653p3M3977l.m3841c();
                C1662q3.m3980o((C1662q3) c1653p3M3977l.f5338b, arrayList4);
            }
            Map map = c1540d8.f5260e;
            if (!map.isEmpty()) {
                ArrayList arrayList5 = new ArrayList();
                for (C1561g c1561g : map.values()) {
                    c1561g.getClass();
                    C1671r3 c1671r3M4016l = C1680s3.m4016l();
                    c1671r3M4016l.m3841c();
                    C1680s3.m4020p((C1680s3) c1671r3M4016l.f5338b, c1561g.f5306e);
                    int i19 = c1561g.f5305d.get();
                    c1671r3M4016l.m3841c();
                    C1680s3.m4017m((C1680s3) c1671r3M4016l.f5338b, i19);
                    int i20 = (int) (c1561g.f5302a - c1561g.f5304c);
                    c1671r3M4016l.m3841c();
                    C1680s3.m4018n((C1680s3) c1671r3M4016l.f5338b, i20);
                    int i21 = (int) (c1561g.f5303b - c1561g.f5304c);
                    c1671r3M4016l.m3841c();
                    C1680s3.m4019o((C1680s3) c1671r3M4016l.f5338b, i21);
                    arrayList5.add((C1680s3) c1671r3M4016l.m3839a());
                }
                c1653p3M3977l.m3841c();
                C1662q3.m3982q((C1662q3) c1653p3M3977l.f5338b, arrayList5);
            }
            int i22 = c1540d8.f5276u;
            c1653p3M3977l.m3841c();
            C1662q3.m3984s((C1662q3) c1653p3M3977l.f5338b, i22);
            C1662q3 c1662q3 = (C1662q3) c1653p3M3977l.m3839a();
            c1575h3.m3841c();
            C1575h3 c1575h5 = c1575h3;
            C1585i3.m3860y((C1585i3) c1575h5.f5338b, c1662q3);
            c1540d8.f5261f.m4015a((C1585i3) c1575h5.m3839a(), 233);
            this.f4201e = null;
        }
    }

    public String toString() {
        switch (this.f4197a) {
            case 4:
                StringBuilder sb = new StringBuilder();
                sb.append("FontRequest {mProviderAuthority: " + ((String) this.f4198b) + ", mProviderPackage: " + ((String) this.f4199c) + ", mQuery: " + ((String) this.f4200d) + ", mCertificates:");
                int i6 = 0;
                while (true) {
                    List list = (List) this.f4201e;
                    if (i6 >= list.size()) {
                        sb.append("}mCertificatesArray: 0");
                        return sb.toString();
                    }
                    sb.append(" [");
                    List list2 = (List) list.get(i6);
                    for (int i10 = 0; i10 < list2.size(); i10++) {
                        sb.append(" \"");
                        sb.append(Base64.encodeToString((byte[]) list2.get(i10), 0));
                        sb.append("\"");
                    }
                    sb.append(" ]");
                    i6++;
                }
                break;
            default:
                return super.toString();
        }
    }

    public C1381b(Context context) {
        this(context, new ImageHints(-1, 0, 0));
        this.f4197a = 6;
    }

    public C1381b(Context context, ImageHints imageHints) {
        this.f4197a = 6;
        this.f4198b = context;
        this.f4199c = imageHints;
        m3260j();
    }

    public C1381b(InterfaceC4022a interfaceC4022a, InterfaceC4022a interfaceC4022a2, C0026b c0026b, InterfaceC4022a interfaceC4022a3, InterfaceC4022a interfaceC4022a4) {
        this.f4197a = 3;
        this.f4198b = interfaceC4022a;
        this.f4199c = interfaceC4022a2;
        this.f4200d = c0026b;
        this.f4201e = interfaceC4022a3;
        this.f4202f = interfaceC4022a4;
    }

    public C1381b(String str, String str2, String str3, List list) {
        this.f4197a = 4;
        str.getClass();
        this.f4198b = str;
        str2.getClass();
        this.f4199c = str2;
        this.f4200d = str3;
        list.getClass();
        this.f4201e = list;
        this.f4202f = str + "-" + str2 + "-" + str3;
    }

    public C1381b(C1382c c1382c) {
        this.f4197a = 0;
        this.f4198b = AbstractC4147j.m8190d0(c1382c.f4203a);
        this.f4199c = AbstractC4147j.m8190d0(c1382c.f4204b);
        this.f4200d = AbstractC4147j.m8190d0(c1382c.f4205c);
        this.f4201e = AbstractC4147j.m8190d0(c1382c.f4206d);
        this.f4202f = AbstractC4147j.m8190d0(c1382c.f4207e);
    }

    public C1381b(InterfaceC2496e interfaceC2496e) {
        this.f4197a = 2;
        this.f4198b = (ViewGroup) interfaceC2496e;
        View view = (View) interfaceC2496e;
        this.f4199c = view;
        view.setWillNotDraw(false);
        new Path();
        new Paint(7);
        Paint paint = new Paint(1);
        this.f4200d = paint;
        paint.setColor(0);
    }

    public C1381b(C3333o c3333o, C2909b c2909b, View view, View view2, View view3) {
        this.f4197a = 5;
        this.f4202f = c3333o;
        this.f4198b = c2909b;
        this.f4199c = view;
        this.f4200d = view2;
        this.f4201e = view3;
    }
}

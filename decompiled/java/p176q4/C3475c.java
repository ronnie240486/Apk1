package p176q4;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.appcompat.app.C0157r0;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.cast.AbstractC1542e0;
import com.google.android.gms.internal.cast.AbstractC1581i;
import com.google.android.gms.internal.cast.BinderC1703v;
import com.google.android.gms.internal.cast.C1507a5;
import com.google.android.gms.internal.cast.C1601k;
import com.google.android.gms.internal.cast.C1602k0;
import com.google.android.gms.internal.cast.HandlerC1731y0;
import java.util.HashSet;
import p002a1.C0026b;
import p018b5.AbstractC1312l;
import p025c2.C1381b;
import p028c6.C1400c;
import p101j7.C2782c;
import p132m5.InterfaceC3078a;
import p165p4.AbstractC3358c;
import p165p4.AbstractC3365j;
import p165p4.C3356a;
import p165p4.C3370o;
import p187r4.C3616f;
import p187r4.C3621k;
import p187r4.C3624n;
import p199s4.C3716j;
import p230v4.C3988b;
import p230v4.C3998l;
import p230v4.C4006t;
import p242w5.C4056d;
import p249x4.C4112e;
import p261y4.C4257e;
import p271z4.C4334e;
import p271z4.C4336g;
import p271z4.C4337h;
import p271z4.C4339j;
import p271z4.C4349t;
import p271z4.C4350u;
import p271z4.C4353x;

public final class C3475c extends AbstractC3481g {

    public static final C3988b f11755m = new C3988b("CastSession", null);

    public final Context f11756c;

    public final HashSet f11757d;

    public final InterfaceC3491q f11758e;

    public final CastOptions f11759f;

    public final BinderC1703v f11760g;

    public final C3716j f11761h;

    public C3370o f11762i;

    public C3616f f11763j;

    public CastDevice f11764k;

    public C1507a5 f11765l;

    public C3475c(Context context, String str, String str2, CastOptions castOptions, BinderC1703v binderC1703v, C3716j c3716j) {
        super(context, str, str2);
        this.f11757d = new HashSet();
        this.f11756c = context.getApplicationContext();
        this.f11759f = castOptions;
        this.f11760g = binderC1703v;
        this.f11761h = c3716j;
        InterfaceC3078a interfaceC3078aM7139d = m7139d();
        BinderC3484j binderC3484j = new BinderC3484j(this);
        C3988b c3988b = AbstractC1581i.f5339a;
        InterfaceC3491q interfaceC3491qM3903z = null;
        if (interfaceC3078aM7139d != null) {
            try {
                interfaceC3491qM3903z = AbstractC1581i.m3843b(context).m3903z(castOptions, interfaceC3078aM7139d, binderC3484j);
            } catch (RemoteException | C3479e e5) {
                AbstractC1581i.f5339a.m7974a(e5, "Unable to call %s on %s.", "newCastSessionImpl", C1601k.class.getSimpleName());
            }
        }
        this.f11758e = interfaceC3491qM3903z;
    }

    public static void m7122h(C3475c c3475c, int i6) {
        C3716j c3716j = c3475c.f11761h;
        if (c3716j.f12465q) {
            c3716j.f12465q = false;
            C3616f c3616f = c3716j.f12462n;
            if (c3616f != null) {
                AbstractC1312l.m3195b("Must be called from the main thread.");
                C3474b0 c3474b0 = c3716j.f12461m;
                if (c3474b0 != null) {
                    c3616f.f12155h.remove(c3474b0);
                }
            }
            c3716j.f12451c.m4029x(null);
            C1381b c1381b = c3716j.f12456h;
            if (c1381b != null) {
                c1381b.m3260j();
                c1381b.f4202f = null;
            }
            C1381b c1381b2 = c3716j.f12457i;
            if (c1381b2 != null) {
                c1381b2.m3260j();
                c1381b2.f4202f = null;
            }
            MediaSessionCompat mediaSessionCompat = c3716j.f12464p;
            if (mediaSessionCompat != null) {
                mediaSessionCompat.setCallback(null);
                c3716j.f12464p.setMetadata(new MediaMetadataCompat.Builder().build());
                c3716j.m7481j(0, null);
            }
            MediaSessionCompat mediaSessionCompat2 = c3716j.f12464p;
            if (mediaSessionCompat2 != null) {
                mediaSessionCompat2.setActive(false);
                c3716j.f12464p.release();
                c3716j.f12464p = null;
            }
            c3716j.f12462n = null;
            c3716j.f12463o = null;
            c3716j.m7479h();
            if (i6 == 0) {
                c3716j.m7480i();
            }
        }
        C3370o c3370o = c3475c.f11762i;
        if (c3370o != null) {
            c3370o.m6864i();
            c3475c.f11762i = null;
        }
        c3475c.f11764k = null;
        C3616f c3616f2 = c3475c.f11763j;
        if (c3616f2 != null) {
            c3616f2.m7321z(null);
            c3475c.f11763j = null;
        }
    }

    public static void m7123i(C3475c c3475c, String str, C3477d c3477d) {
        int i6 = 0;
        C3988b c3988b = f11755m;
        InterfaceC3491q interfaceC3491q = c3475c.f11758e;
        if (interfaceC3491q == null) {
            return;
        }
        try {
            if (!c3477d.m7132e()) {
                Exception excM7130c = c3477d.m7130c();
                if (!(excM7130c instanceof C4257e)) {
                    C3489o c3489o = (C3489o) interfaceC3491q;
                    Parcel parcelM3687l = c3489o.m3687l();
                    parcelM3687l.writeInt(2476);
                    c3489o.m3689x(parcelM3687l, 5);
                    return;
                }
                int i10 = ((C4257e) excM7130c).f14453a.f4994a;
                C3489o c3489o2 = (C3489o) interfaceC3491q;
                Parcel parcelM3687l2 = c3489o2.m3687l();
                parcelM3687l2.writeInt(i10);
                c3489o2.m3689x(parcelM3687l2, 5);
                return;
            }
            C4006t c4006t = (C4006t) c3477d.m7131d();
            Status status = c4006t.f13566a;
            if (!(status.f4994a <= 0)) {
                c3988b.m7975b("%s() -> failure result", str);
                int i11 = status.f4994a;
                C3489o c3489o3 = (C3489o) interfaceC3491q;
                Parcel parcelM3687l3 = c3489o3.m3687l();
                parcelM3687l3.writeInt(i11);
                c3489o3.m3689x(parcelM3687l3, 5);
                return;
            }
            c3988b.m7975b("%s() -> success result", str);
            C3616f c3616f = new C3616f(new C3998l());
            c3475c.f11763j = c3616f;
            c3616f.m7321z(c3475c.f11762i);
            C3616f c3616f2 = c3475c.f11763j;
            C3474b0 c3474b0 = new C3474b0(i6, c3475c);
            c3616f2.getClass();
            AbstractC1312l.m3195b("Must be called from the main thread.");
            c3616f2.f12155h.add(c3474b0);
            c3475c.f11763j.m7320y();
            c3475c.f11761h.m7472a(c3475c.f11763j, c3475c.m7124e());
            ApplicationMetadata applicationMetadata = c4006t.f13567b;
            AbstractC1312l.m3198e(applicationMetadata);
            String str2 = c4006t.f13568c;
            String str3 = c4006t.f13569d;
            AbstractC1312l.m3198e(str3);
            boolean z7 = c4006t.f13570e;
            C3489o c3489o4 = (C3489o) interfaceC3491q;
            Parcel parcelM3687l4 = c3489o4.m3687l();
            AbstractC1542e0.m3809c(parcelM3687l4, applicationMetadata);
            parcelM3687l4.writeString(str2);
            parcelM3687l4.writeString(str3);
            parcelM3687l4.writeInt(z7 ? 1 : 0);
            c3489o4.m3689x(parcelM3687l4, 4);
        } catch (RemoteException e5) {
            c3988b.m7974a(e5, "Unable to call %s on %s.", "methods", InterfaceC3491q.class.getSimpleName());
        }
    }

    public final CastDevice m7124e() {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        return this.f11764k;
    }

    public final C3616f m7125f() {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        return this.f11763j;
    }

    public final void m7126g(boolean z7) {
        AbstractC1312l.m3195b("Must be called from the main thread.");
        C3370o c3370o = this.f11762i;
        if (c3370o == null || !c3370o.m6865j()) {
            return;
        }
        C1400c c1400cM3273c = C1400c.m3273c();
        c1400cM3273c.f4265c = new C0157r0(4, c3370o, z7);
        c1400cM3273c.f4263a = 8412;
        c3370o.m8306c(1, c1400cM3273c.m3275b());
    }

    public final void m7127j(Bundle bundle) {
        boolean z7;
        CastDevice castDeviceM3584l = CastDevice.m3584l(bundle);
        this.f11764k = castDeviceM3584l;
        if (castDeviceM3584l == null) {
            AbstractC1312l.m3195b("Must be called from the main thread.");
            InterfaceC3498x interfaceC3498x = this.f11776a;
            if (interfaceC3498x != null) {
                try {
                    C3496v c3496v = (C3496v) interfaceC3498x;
                    Parcel parcelM3688w = c3496v.m3688w(c3496v.m3687l(), 9);
                    int i6 = AbstractC1542e0.f5277a;
                    z7 = parcelM3688w.readInt() != 0;
                    parcelM3688w.recycle();
                } catch (RemoteException e5) {
                    AbstractC3481g.f11775b.m7974a(e5, "Unable to call %s on %s.", "isResuming", InterfaceC3498x.class.getSimpleName());
                    z7 = false;
                }
            } else {
                z7 = false;
            }
            if (z7) {
                InterfaceC3498x interfaceC3498x2 = this.f11776a;
                if (interfaceC3498x2 == null) {
                    return;
                }
                try {
                    C3496v c3496v2 = (C3496v) interfaceC3498x2;
                    Parcel parcelM3687l = c3496v2.m3687l();
                    parcelM3687l.writeInt(2153);
                    c3496v2.m3689x(parcelM3687l, 15);
                    return;
                } catch (RemoteException e10) {
                    AbstractC3481g.f11775b.m7974a(e10, "Unable to call %s on %s.", "notifyFailedToResumeSession", InterfaceC3498x.class.getSimpleName());
                    return;
                }
            }
            InterfaceC3498x interfaceC3498x3 = this.f11776a;
            if (interfaceC3498x3 == null) {
                return;
            }
            try {
                C3496v c3496v3 = (C3496v) interfaceC3498x3;
                Parcel parcelM3687l2 = c3496v3.m3687l();
                parcelM3687l2.writeInt(2151);
                c3496v3.m3689x(parcelM3687l2, 12);
                return;
            } catch (RemoteException e11) {
                AbstractC3481g.f11775b.m7974a(e11, "Unable to call %s on %s.", "notifyFailedToStartSession", InterfaceC3498x.class.getSimpleName());
                return;
            }
        }
        C3370o c3370o = this.f11762i;
        if (c3370o != null) {
            c3370o.m6864i();
            this.f11762i = null;
        }
        f11755m.m7975b("Acquiring a connection to Google Play Services for %s", this.f11764k);
        CastDevice castDevice = this.f11764k;
        AbstractC1312l.m3198e(castDevice);
        Bundle bundle2 = new Bundle();
        CastOptions castOptions = this.f11759f;
        CastMediaOptions castMediaOptions = castOptions == null ? null : castOptions.f4768f;
        NotificationOptions notificationOptions = castMediaOptions != null ? castMediaOptions.f4836d : null;
        boolean z10 = castMediaOptions != null && castMediaOptions.f4837e;
        bundle2.putBoolean("com.google.android.gms.cast.EXTRA_CAST_FRAMEWORK_NOTIFICATION_ENABLED", notificationOptions != null);
        bundle2.putBoolean("com.google.android.gms.cast.EXTRA_CAST_REMOTE_CONTROL_NOTIFICATION_ENABLED", z10);
        BinderC1703v binderC1703v = this.f11760g;
        bundle2.putBoolean("com.google.android.gms.cast.EXTRA_CAST_ALWAYS_FOLLOW_SESSION_ENABLED", binderC1703v.m4030y());
        bundle2.putBoolean("com.google.android.gms.cast.EXTRA_USE_ROUTE_CONNECTION", binderC1703v.f5698k);
        C0026b c0026b = new C0026b(castDevice, new C1602k0(1, this));
        c0026b.f56d = bundle2;
        C3356a c3356a = new C3356a(c0026b);
        Context context = this.f11756c;
        int i10 = AbstractC3358c.f11350a;
        C3370o c3370o2 = new C3370o(context, c3356a);
        c3370o2.f11377D.add(new C3478d0(this));
        this.f11762i = c3370o2;
        C4337h c4337hM8305b = c3370o2.m8305b(c3370o2.f11379j);
        C4339j c4339j = new C4339j();
        C2782c c2782c = new C2782c(25, c3370o2);
        C4112e c4112e = new C4112e(29);
        c3370o2.f11378E = 2;
        c4339j.f14716c = c4337hM8305b;
        c4339j.f14714a = c2782c;
        c4339j.f14715b = c4112e;
        c4339j.f14717d = new Feature[]{AbstractC3365j.f11356a};
        c4339j.f14718e = 8428;
        C4336g c4336g = c4337hM8305b.f14713a;
        AbstractC1312l.m3199f(c4336g, "Key must not be null");
        C4337h c4337h = c4339j.f14716c;
        Feature[] featureArr = c4339j.f14717d;
        int i11 = c4339j.f14718e;
        C3621k c3621k = new C3621k(c4339j, c4337h, featureArr, i11);
        C3624n c3624n = new C3624n(c4339j, c4336g);
        AbstractC1312l.m3199f(c4337h.f14713a, "Listener has already been released.");
        C4334e c4334e = c3370o2.f14465i;
        c4334e.getClass();
        C4056d c4056d = new C4056d();
        c4334e.m8363e(c4056d, i11, c3370o2);
        C4349t c4349t = new C4349t(new C4353x(new C4350u(c3621k, c3624n), c4056d), c4334e.f14706i.get(), c3370o2);
        HandlerC1731y0 handlerC1731y0 = c4334e.f14710m;
        handlerC1731y0.sendMessage(handlerC1731y0.obtainMessage(8, c4349t));
    }
}

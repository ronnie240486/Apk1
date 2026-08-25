package p176q4;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.mediarouter.app.MediaRouteButton;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.media.widget.ExpandedControllerActivity;
import com.google.android.gms.internal.cast.AbstractBinderC1694u;
import com.google.android.gms.internal.cast.AbstractC1542e0;
import com.google.android.gms.internal.cast.BinderC1703v;
import com.google.android.gms.internal.cast.C1507a5;
import com.google.android.gms.internal.cast.C1591j;
import com.google.android.gms.internal.cast.C1602k0;
import java.util.HashSet;
import org.bitspark.android.Spark;
import org.bitspark.android.utils.C3320b;
import p000a.RunnableC0005f;
import p001a0.C0023f;
import p002a1.C0026b;
import p018b5.AbstractC1312l;
import p028c6.C1400c;
import p116ka.ViewOnKeyListenerC2932m0;
import p132m5.BinderC3079b;
import p132m5.InterfaceC3078a;
import p165p4.C3366k;
import p165p4.C3367l;
import p165p4.C3370o;
import p187r4.C3616f;
import p199s4.AsyncTaskC3708b;
import p199s4.C3716j;
import p230v4.C3988b;
import p242w5.InterfaceC4053a;

public final class BinderC3484j extends AbstractBinderC1694u {

    public final int f11780d = 0;

    public final Object f11781e;

    public BinderC3484j(C0023f c0023f) {
        super("com.google.android.gms.cast.framework.ICastStateListener", 0);
        this.f11781e = c0023f;
    }

    @Override
    public final boolean mo3202w(int i6, Parcel parcel, Parcel parcel2) {
        CastDevice castDevice;
        CastDevice castDevice2;
        int i10 = 27;
        Object obj = this.f11781e;
        final int i11 = 1;
        final int i12 = 0;
        switch (this.f11780d) {
            case 0:
                C0023f c0023f = (C0023f) obj;
                if (i6 == 1) {
                    BinderC3079b binderC3079b = new BinderC3079b(c0023f);
                    parcel2.writeNoException();
                    AbstractC1542e0.m3810d(parcel2, binderC3079b);
                    return true;
                }
                if (i6 != 2) {
                    if (i6 != 3) {
                        return false;
                    }
                    parcel2.writeNoException();
                    parcel2.writeInt(12451000);
                    return true;
                }
                int i13 = parcel.readInt();
                AbstractC1542e0.m3808b(parcel);
                C3320b c3320b = (C3320b) c0023f.f47e;
                if (i13 != 1) {
                    Spark spark = (Spark) c0023f.f44b;
                    C3320b.m6735a(c3320b, spark, (MediaRouteButton) c0023f.f45c);
                    C3320b.m6735a(c3320b, spark, (MediaRouteButton) c0023f.f46d);
                }
                if (i13 == 4 && c3320b.f11207e != null) {
                    ViewOnKeyListenerC2932m0.f9950E0.postDelayed(new RunnableC0005f(i10, c0023f), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                }
                parcel2.writeNoException();
                return true;
            case 1:
                AbstractC3481g abstractC3481g = (AbstractC3481g) obj;
                switch (i6) {
                    case 1:
                        BinderC3079b binderC3079b2 = new BinderC3079b(abstractC3481g);
                        parcel2.writeNoException();
                        AbstractC1542e0.m3810d(parcel2, binderC3079b2);
                        return true;
                    case 2:
                        Bundle bundle = (Bundle) AbstractC1542e0.m3807a(parcel, Bundle.CREATOR);
                        AbstractC1542e0.m3808b(parcel);
                        ((C3475c) abstractC3481g).m7127j(bundle);
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        Bundle bundle2 = (Bundle) AbstractC1542e0.m3807a(parcel, Bundle.CREATOR);
                        AbstractC1542e0.m3808b(parcel);
                        ((C3475c) abstractC3481g).m7127j(bundle2);
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        int i14 = AbstractC1542e0.f5277a;
                        int i15 = parcel.readInt() != 0 ? 1 : 0;
                        AbstractC1542e0.m3808b(parcel);
                        C3475c c3475c = (C3475c) abstractC3481g;
                        InterfaceC3491q interfaceC3491q = c3475c.f11758e;
                        if (interfaceC3491q != null) {
                            try {
                                C3489o c3489o = (C3489o) interfaceC3491q;
                                Parcel parcelM3687l = c3489o.m3687l();
                                parcelM3687l.writeInt(i15);
                                parcelM3687l.writeInt(0);
                                c3489o.m3689x(parcelM3687l, 6);
                            } catch (RemoteException e5) {
                                C3475c.f11755m.m7974a(e5, "Unable to call %s on %s.", "disconnectFromDevice", InterfaceC3491q.class.getSimpleName());
                            }
                            c3475c.m7137b(0);
                            break;
                        }
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        C3475c c3475c2 = (C3475c) abstractC3481g;
                        c3475c2.getClass();
                        AbstractC1312l.m3195b("Must be called from the main thread.");
                        C3616f c3616f = c3475c2.f11763j;
                        long jM7304h = c3616f == null ? 0L : c3616f.m7304h() - c3475c2.f11763j.m7299c();
                        parcel2.writeNoException();
                        parcel2.writeLong(jM7304h);
                        return true;
                    case 6:
                        parcel2.writeNoException();
                        parcel2.writeInt(12451000);
                        return true;
                    case 7:
                        Bundle bundle3 = (Bundle) AbstractC1542e0.m3807a(parcel, Bundle.CREATOR);
                        AbstractC1542e0.m3808b(parcel);
                        C3475c c3475c3 = (C3475c) abstractC3481g;
                        c3475c3.getClass();
                        c3475c3.f11764k = CastDevice.m3584l(bundle3);
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        Bundle bundle4 = (Bundle) AbstractC1542e0.m3807a(parcel, Bundle.CREATOR);
                        AbstractC1542e0.m3808b(parcel);
                        C3475c c3475c4 = (C3475c) abstractC3481g;
                        c3475c4.getClass();
                        c3475c4.f11764k = CastDevice.m3584l(bundle4);
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        Bundle bundle5 = (Bundle) AbstractC1542e0.m3807a(parcel, Bundle.CREATOR);
                        AbstractC1542e0.m3808b(parcel);
                        C3475c c3475c5 = (C3475c) abstractC3481g;
                        c3475c5.getClass();
                        CastDevice castDeviceM3584l = CastDevice.m3584l(bundle5);
                        if (castDeviceM3584l != null && !castDeviceM3584l.equals(c3475c5.f11764k)) {
                            String str = castDeviceM3584l.f4603d;
                            boolean z7 = !TextUtils.isEmpty(str) && ((castDevice2 = c3475c5.f11764k) == null || !TextUtils.equals(castDevice2.f4603d, str));
                            c3475c5.f11764k = castDeviceM3584l;
                            C3475c.f11755m.m7975b("update to device (%s) with name %s", castDeviceM3584l, true != z7 ? "unchanged" : "changed");
                            if (z7 && (castDevice = c3475c5.f11764k) != null) {
                                C3716j c3716j = c3475c5.f11761h;
                                if (c3716j != null) {
                                    C3988b c3988b = C3716j.f12448v;
                                    Log.i(c3988b.f13521a, c3988b.m7977d("update Cast device to %s", castDevice));
                                    c3716j.f12463o = castDevice;
                                    c3716j.m7474c();
                                }
                                for (C1602k0 c1602k0 : new HashSet(c3475c5.f11757d)) {
                                    switch (c1602k0.f5379a) {
                                        case 2:
                                            int i16 = ExpandedControllerActivity.f4902n0;
                                            ((ExpandedControllerActivity) c1602k0.f5380b).m3631s();
                                            break;
                                    }
                                }
                                C1507a5 c1507a5 = c3475c5.f11765l;
                                if (c1507a5 != null) {
                                    c1507a5.f5205a.m3261l().f5276u++;
                                }
                            }
                        }
                        parcel2.writeNoException();
                        return true;
                    default:
                        return false;
                }
            case 2:
                C1591j c1591j = (C1591j) obj;
                if (i6 == 1) {
                    String string = parcel.readString();
                    AbstractC1542e0.m3808b(parcel);
                    c1591j.getClass();
                    Context context = c1591j.f5351a;
                    CastOptions castOptions = c1591j.f5354d;
                    BinderC1703v binderC1703v = c1591j.f5355e;
                    InterfaceC3078a interfaceC3078aM7139d = new C3475c(c1591j.f5351a, c1591j.f5352b, string, castOptions, binderC1703v, new C3716j(context, castOptions, binderC1703v)).m7139d();
                    parcel2.writeNoException();
                    AbstractC1542e0.m3810d(parcel2, interfaceC3078aM7139d);
                    return true;
                }
                if (i6 == 2) {
                    boolean z10 = c1591j.f5354d.f4767e;
                    parcel2.writeNoException();
                    int i17 = AbstractC1542e0.f5277a;
                    parcel2.writeInt(z10 ? 1 : 0);
                    return true;
                }
                if (i6 == 3) {
                    String str2 = c1591j.f5352b;
                    parcel2.writeNoException();
                    parcel2.writeString(str2);
                    return true;
                }
                if (i6 != 4) {
                    return false;
                }
                parcel2.writeNoException();
                parcel2.writeInt(12451000);
                return true;
            case 3:
                C3475c c3475c6 = (C3475c) obj;
                if (i6 == 1) {
                    String string2 = parcel.readString();
                    String string3 = parcel.readString();
                    AbstractC1542e0.m3808b(parcel);
                    C3370o c3370o = c3475c6.f11762i;
                    if (c3370o != null && c3370o.m6865j()) {
                        C3370o c3370o2 = c3475c6.f11762i;
                        C1400c c1400cM3273c = C1400c.m3273c();
                        c1400cM3273c.f4265c = new C3366k(c3370o2, string2, string3, i12);
                        c1400cM3273c.f4263a = 8407;
                        c3370o2.m8306c(1, c1400cM3273c.m3275b()).m7128a(new InterfaceC4053a(this) {

                            public final BinderC3484j f11767b;

                            {
                                this.f11767b = this;
                            }

                            @Override
                            public final void mo3998b(C3477d c3477d) {
                                switch (i11) {
                                    case 0:
                                        C3475c.m7123i((C3475c) this.f11767b.f11781e, "launchApplication", c3477d);
                                        break;
                                    default:
                                        C3475c.m7123i((C3475c) this.f11767b.f11781e, "joinApplication", c3477d);
                                        break;
                                }
                            }
                        });
                    }
                    parcel2.writeNoException();
                    return true;
                }
                if (i6 == 2) {
                    String string4 = parcel.readString();
                    LaunchOptions launchOptions = (LaunchOptions) AbstractC1542e0.m3807a(parcel, LaunchOptions.CREATOR);
                    AbstractC1542e0.m3808b(parcel);
                    C3370o c3370o3 = c3475c6.f11762i;
                    if (c3370o3 != null && c3370o3.m6865j()) {
                        C3370o c3370o4 = c3475c6.f11762i;
                        C1400c c1400cM3273c2 = C1400c.m3273c();
                        c1400cM3273c2.f4265c = new C0026b(c3370o4, string4, launchOptions, i10);
                        c1400cM3273c2.f4263a = 8406;
                        c3370o4.m8306c(1, c1400cM3273c2.m3275b()).m7128a(new InterfaceC4053a(this) {

                            public final BinderC3484j f11767b;

                            {
                                this.f11767b = this;
                            }

                            @Override
                            public final void mo3998b(C3477d c3477d) {
                                switch (i12) {
                                    case 0:
                                        C3475c.m7123i((C3475c) this.f11767b.f11781e, "launchApplication", c3477d);
                                        break;
                                    default:
                                        C3475c.m7123i((C3475c) this.f11767b.f11781e, "joinApplication", c3477d);
                                        break;
                                }
                            }
                        });
                    }
                    parcel2.writeNoException();
                    return true;
                }
                if (i6 != 3) {
                    if (i6 != 4) {
                        if (i6 != 5) {
                            return false;
                        }
                        parcel2.writeNoException();
                        parcel2.writeInt(12451000);
                        return true;
                    }
                    int i18 = parcel.readInt();
                    AbstractC1542e0.m3808b(parcel);
                    C3475c.m7122h(c3475c6, i18);
                    parcel2.writeNoException();
                    return true;
                }
                String string5 = parcel.readString();
                AbstractC1542e0.m3808b(parcel);
                C3370o c3370o5 = c3475c6.f11762i;
                if (c3370o5 != null && c3370o5.m6865j()) {
                    C3370o c3370o6 = c3475c6.f11762i;
                    C1400c c1400cM3273c3 = C1400c.m3273c();
                    c1400cM3273c3.f4265c = new C3367l(c3370o6, string5);
                    c1400cM3273c3.f4263a = 8409;
                    c3370o6.m8306c(1, c1400cM3273c3.m3275b());
                }
                parcel2.writeNoException();
                return true;
            default:
                if (i6 != 1) {
                    if (i6 != 2) {
                        return false;
                    }
                    parcel2.writeNoException();
                    parcel2.writeInt(12451000);
                    return true;
                }
                long j10 = parcel.readLong();
                long j11 = parcel.readLong();
                AbstractC1542e0.m3808b(parcel);
                ((AsyncTaskC3708b) obj).publishProgress(Long.valueOf(j10), Long.valueOf(j11));
                parcel2.writeNoException();
                return true;
        }
    }

    public BinderC3484j(C1591j c1591j) {
        super("com.google.android.gms.cast.framework.ISessionProvider", 0);
        this.f11781e = c1591j;
    }

    public BinderC3484j(C3475c c3475c) {
        super("com.google.android.gms.cast.framework.ICastConnectionController", 0);
        this.f11781e = c3475c;
    }

    public BinderC3484j(AbstractC3481g abstractC3481g) {
        super("com.google.android.gms.cast.framework.ISessionProxy", 0);
        this.f11781e = abstractC3481g;
    }

    public BinderC3484j(AsyncTaskC3708b asyncTaskC3708b) {
        super("com.google.android.gms.cast.framework.media.internal.IFetchBitmapTaskProgressPublisher", 0);
        this.f11781e = asyncTaskC3708b;
    }
}

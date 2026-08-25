package androidx.appcompat.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import androidx.media3.common.C0628x;
import androidx.mediarouter.media.MediaRouteProviderService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Objects;
import p173q1.AbstractC3394b0;
import p173q1.AbstractC3397c0;
import p173q1.AbstractC3433o0;
import p173q1.C3400d0;
import p173q1.C3411h;
import p173q1.C3413h1;
import p173q1.C3415i0;
import p173q1.C3418j0;
import p173q1.C3421k0;
import p173q1.C3422k1;
import p173q1.C3424l0;
import p173q1.C3434o1;
import p173q1.C3454w;
import p173q1.C3456x;
import p173q1.C3460z;
import p173q1.InterfaceC3416i1;
import p173q1.ServiceConnectionC3428m1;

public final class HandlerC0132f extends Handler {

    public final int f284a = 0;

    public WeakReference f285b;

    public HandlerC0132f() {
    }

    @Override
    public final void handleMessage(Message message) {
        C3418j0 c3418j0M6996d;
        AbstractC3397c0 abstractC3397c0M6994e;
        AbstractC3397c0 abstractC3397c0M6994e2;
        C3418j0 c3418j0M6996d2;
        AbstractC3397c0 abstractC3397c0M6994e3;
        C3418j0 c3418j0M6996d3;
        AbstractC3397c0 abstractC3397c0M6994e4;
        AbstractC3397c0 abstractC3397c0M6994e5;
        C3456x c3456x;
        C3456x c3456x2;
        C3418j0 c3418j0M6996d4;
        long jElapsedRealtime;
        C3418j0 c3418j0M6996d5;
        C3418j0 c3418j0M6996d6;
        C3418j0 c3418j0M6996d7;
        C3418j0 c3418j0M6996d8;
        String[] packagesForUid;
        C3460z c3460z;
        C0628x c0628x;
        AbstractC3397c0 abstractC3397c0;
        C3411h c3411h;
        InterfaceC3416i1 interfaceC3416i1 = null;
        InterfaceC3416i1 interfaceC3416i2 = null;
        switch (this.f284a) {
            case 0:
                int i6 = message.what;
                if (i6 == -3 || i6 == -2 || i6 == -1) {
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f285b.get(), message.what);
                    break;
                } else if (i6 == 1) {
                    ((DialogInterface) message.obj).dismiss();
                    break;
                }
                break;
            case 1:
                Messenger messenger = message.replyTo;
                if (messenger != null) {
                    try {
                        if (messenger.getBinder() != null) {
                            int i10 = message.what;
                            int i11 = message.arg1;
                            int i12 = message.arg2;
                            Object obj = message.obj;
                            Bundle bundlePeekData = message.peekData();
                            WeakReference weakReference = this.f285b;
                            String str = (i10 != 1 || (packagesForUid = ((MediaRouteProviderService) weakReference.get()).getPackageManager().getPackagesForUid(message.sendingUid)) == null || packagesForUid.length <= 0) ? null : packagesForUid[0];
                            MediaRouteProviderService mediaRouteProviderService = (MediaRouteProviderService) weakReference.get();
                            if (mediaRouteProviderService != null) {
                                C3421k0 c3421k0 = mediaRouteProviderService.f3442e;
                                switch (i10) {
                                    case 1:
                                        if (i12 < 1) {
                                            c3421k0.getClass();
                                        } else if (c3421k0.m6995c(messenger) < 0) {
                                            C3418j0 c3418j0Mo6951b = c3421k0.mo6951b(messenger, i12, str);
                                            try {
                                                c3418j0Mo6951b.f11528a.getBinder().linkToDeath(c3418j0Mo6951b, 0);
                                                c3421k0.f11539b.add(c3418j0Mo6951b);
                                                c3421k0.m6997e();
                                                int i13 = MediaRouteProviderService.f3437f;
                                                if (i11 != 0) {
                                                    MediaRouteProviderService.m2806e(messenger, 2, i11, 3, MediaRouteProviderService.m2804a(c3421k0.f11538a.f3441d.f11456g, c3418j0Mo6951b.f11529b), null);
                                                }
                                            } catch (RemoteException unused) {
                                                c3418j0Mo6951b.binderDied();
                                            }
                                        }
                                        break;
                                    case 2:
                                        int iM6995c = c3421k0.m6995c(messenger);
                                        if (iM6995c >= 0) {
                                            C3418j0 c3418j0 = (C3418j0) c3421k0.f11539b.remove(iM6995c);
                                            c3421k0.m6997e();
                                            int i14 = MediaRouteProviderService.f3437f;
                                            c3418j0.mo6931d();
                                            MediaRouteProviderService.m2805d(messenger, i11);
                                        }
                                        break;
                                    case 3:
                                        String string = bundlePeekData.getString("routeId");
                                        String string2 = bundlePeekData.getString("routeGroupId");
                                        Bundle bundle = (Bundle) bundlePeekData.getParcelable("routeControllerOptions");
                                        C3400d0 c3400d0 = bundle != null ? new C3400d0(bundle) : C3400d0.f11443b;
                                        if (string != null && (c3418j0M6996d = c3421k0.m6996d(messenger)) != null) {
                                            Bundle bundle2 = new Bundle();
                                            Bundle bundle3 = (Bundle) c3400d0.f11444a.getParcelable("controlHints");
                                            if (bundle3 == null) {
                                                bundle3 = Bundle.EMPTY;
                                            }
                                            bundle2.putParcelable("controlHints", bundle3);
                                            bundle2.putString("clientPackageName", c3400d0.f11444a.getString("clientPackageName", ""));
                                            bundle2.putString("clientPackageName", c3418j0M6996d.f11530c);
                                            if (c3418j0M6996d.mo6930c(string, string2, new C3400d0(bundle2), i12)) {
                                                MediaRouteProviderService.m2805d(messenger, i11);
                                            }
                                        }
                                        break;
                                    case 4:
                                        C3418j0 c3418j0M6996d9 = c3421k0.m6996d(messenger);
                                        if (c3418j0M6996d9 != null && c3418j0M6996d9.mo6932f(i12)) {
                                            MediaRouteProviderService.m2805d(messenger, i11);
                                        }
                                        break;
                                    case 5:
                                        C3418j0 c3418j0M6996d10 = c3421k0.m6996d(messenger);
                                        if (c3418j0M6996d10 != null && (abstractC3397c0M6994e = c3418j0M6996d10.m6994e(i12)) != null) {
                                            abstractC3397c0M6994e.mo6898f();
                                            MediaRouteProviderService.m2805d(messenger, i11);
                                        }
                                        break;
                                    case 6:
                                        int i15 = bundlePeekData == null ? 0 : bundlePeekData.getInt("unselectReason", 0);
                                        C3418j0 c3418j0M6996d11 = c3421k0.m6996d(messenger);
                                        if (c3418j0M6996d11 != null && (abstractC3397c0M6994e2 = c3418j0M6996d11.m6994e(i12)) != null) {
                                            abstractC3397c0M6994e2.mo6900i(i15);
                                            MediaRouteProviderService.m2805d(messenger, i11);
                                        }
                                        break;
                                    case 7:
                                        int i16 = bundlePeekData.getInt("volume", -1);
                                        if (i16 >= 0 && (c3418j0M6996d2 = c3421k0.m6996d(messenger)) != null && (abstractC3397c0M6994e3 = c3418j0M6996d2.m6994e(i12)) != null) {
                                            abstractC3397c0M6994e3.mo6894g(i16);
                                            MediaRouteProviderService.m2805d(messenger, i11);
                                        }
                                        break;
                                    case 8:
                                        int i17 = bundlePeekData.getInt("volume", 0);
                                        if (i17 != 0 && (c3418j0M6996d3 = c3421k0.m6996d(messenger)) != null && (abstractC3397c0M6994e4 = c3418j0M6996d3.m6994e(i12)) != null) {
                                            abstractC3397c0M6994e4.mo6895j(i17);
                                            MediaRouteProviderService.m2805d(messenger, i11);
                                        }
                                        break;
                                    case 9:
                                        if (obj instanceof Intent) {
                                            Intent intent = (Intent) obj;
                                            C3418j0 c3418j0M6996d12 = c3421k0.m6996d(messenger);
                                            if (c3418j0M6996d12 != null && (abstractC3397c0M6994e5 = c3418j0M6996d12.m6994e(i12)) != null) {
                                                if (abstractC3397c0M6994e5.mo6896d(intent, i11 != 0 ? new C3415i0(c3421k0, c3418j0M6996d12, i12, intent, messenger, i11) : null)) {
                                                    int i18 = MediaRouteProviderService.f3437f;
                                                }
                                            }
                                        }
                                        break;
                                    case 10:
                                        if (obj == null || (obj instanceof Bundle)) {
                                            Bundle bundle4 = (Bundle) obj;
                                            C3456x c3456x3 = bundle4 != null ? new C3456x(bundle4) : null;
                                            if (c3456x3 != null) {
                                                c3456x3.m7095a();
                                                C3424l0 c3424l0 = c3456x3.f11707b;
                                                c3424l0.m7000a();
                                                c3456x = null;
                                                if (!c3424l0.f11569b.contains(null)) {
                                                    c3456x2 = c3456x3;
                                                }
                                                c3418j0M6996d4 = c3421k0.m6996d(messenger);
                                                if (c3418j0M6996d4 != null) {
                                                    jElapsedRealtime = SystemClock.elapsedRealtime();
                                                    if (!Objects.equals(c3418j0M6996d4.f11531d, c3456x2)) {
                                                        c3418j0M6996d4.f11531d = c3456x2;
                                                        c3418j0M6996d4.f11532e = jElapsedRealtime;
                                                        c3418j0M6996d4.f11535h.m6998h();
                                                    }
                                                    MediaRouteProviderService.m2805d(messenger, i11);
                                                }
                                            } else {
                                                c3456x = null;
                                            }
                                            c3456x2 = c3456x;
                                            c3418j0M6996d4 = c3421k0.m6996d(messenger);
                                            if (c3418j0M6996d4 != null) {
                                                jElapsedRealtime = SystemClock.elapsedRealtime();
                                                if (!Objects.equals(c3418j0M6996d4.f11531d, c3456x2)) {
                                                    c3418j0M6996d4.f11531d = c3456x2;
                                                    c3418j0M6996d4.f11532e = jElapsedRealtime;
                                                    c3418j0M6996d4.f11535h.m6998h();
                                                }
                                                MediaRouteProviderService.m2805d(messenger, i11);
                                            }
                                        }
                                        break;
                                    case 11:
                                        String string3 = bundlePeekData.getString("memberRouteId");
                                        Bundle bundle5 = (Bundle) bundlePeekData.getParcelable("routeControllerOptions");
                                        C3400d0 c3400d1 = bundle5 != null ? new C3400d0(bundle5) : C3400d0.f11443b;
                                        if (string3 != null && (c3418j0M6996d5 = c3421k0.m6996d(messenger)) != null) {
                                            Bundle bundle6 = new Bundle();
                                            Bundle bundle7 = (Bundle) c3400d1.f11444a.getParcelable("controlHints");
                                            if (bundle7 == null) {
                                                bundle7 = Bundle.EMPTY;
                                            }
                                            bundle6.putParcelable("controlHints", bundle7);
                                            bundle6.putString("clientPackageName", c3400d1.f11444a.getString("clientPackageName", ""));
                                            bundle6.putString("clientPackageName", c3418j0M6996d5.f11530c);
                                            Bundle bundleMo6929b = c3418j0M6996d5.mo6929b(string3, new C3400d0(bundle6), i12);
                                            if (bundleMo6929b != null) {
                                                MediaRouteProviderService.m2806e(messenger, 6, i11, 3, bundleMo6929b, null);
                                            }
                                        }
                                        break;
                                    case 12:
                                        String string4 = bundlePeekData.getString("memberRouteId");
                                        if (string4 != null && (c3418j0M6996d6 = c3421k0.m6996d(messenger)) != null) {
                                            AbstractC3397c0 abstractC3397c0M6994e6 = c3418j0M6996d6.m6994e(i12);
                                            if (abstractC3397c0M6994e6 instanceof AbstractC3394b0) {
                                                ((AbstractC3394b0) abstractC3397c0M6994e6).mo6890n(string4);
                                                MediaRouteProviderService.m2805d(messenger, i11);
                                            }
                                        }
                                        break;
                                    case 13:
                                        String string5 = bundlePeekData.getString("memberRouteId");
                                        if (string5 != null && (c3418j0M6996d7 = c3421k0.m6996d(messenger)) != null) {
                                            AbstractC3397c0 abstractC3397c0M6994e7 = c3418j0M6996d7.m6994e(i12);
                                            if (abstractC3397c0M6994e7 instanceof AbstractC3394b0) {
                                                ((AbstractC3394b0) abstractC3397c0M6994e7).mo6891o(string5);
                                                MediaRouteProviderService.m2805d(messenger, i11);
                                            }
                                        }
                                        break;
                                    case 14:
                                        ArrayList<String> stringArrayList = bundlePeekData.getStringArrayList("memberRouteIds");
                                        if (stringArrayList != null && (c3418j0M6996d8 = c3421k0.m6996d(messenger)) != null) {
                                            AbstractC3397c0 abstractC3397c0M6994e8 = c3418j0M6996d8.m6994e(i12);
                                            if (abstractC3397c0M6994e8 instanceof AbstractC3394b0) {
                                                ((AbstractC3394b0) abstractC3397c0M6994e8).mo6892p(stringArrayList);
                                                MediaRouteProviderService.m2805d(messenger, i11);
                                            }
                                        }
                                        break;
                                }
                            }
                            int i19 = MediaRouteProviderService.f3437f;
                            if (i11 != 0) {
                                MediaRouteProviderService.m2806e(messenger, 0, i11, 0, null, null);
                            }
                        }
                        break;
                    } catch (NullPointerException unused2) {
                    }
                }
                int i20 = MediaRouteProviderService.f3437f;
                break;
            default:
                C3413h1 c3413h1 = (C3413h1) this.f285b.get();
                if (c3413h1 != null) {
                    int i21 = message.what;
                    int i22 = message.arg1;
                    int i23 = message.arg2;
                    Object obj2 = message.obj;
                    Bundle bundlePeekData2 = message.peekData();
                    SparseArray sparseArray = c3413h1.f11523h;
                    ServiceConnectionC3428m1 serviceConnectionC3428m1 = c3413h1.f11524i;
                    switch (i21) {
                        case 0:
                            if (i22 == c3413h1.f11522g) {
                                c3413h1.f11522g = 0;
                                if (serviceConnectionC3428m1.f11587n == c3413h1) {
                                    serviceConnectionC3428m1.m7006k();
                                }
                            }
                            AbstractC3433o0 abstractC3433o0 = (AbstractC3433o0) sparseArray.get(i22);
                            if (abstractC3433o0 != null) {
                                sparseArray.remove(i22);
                                abstractC3433o0.mo6959a(null, null);
                            }
                            break;
                        case 2:
                            if (obj2 == null || (obj2 instanceof Bundle)) {
                                Bundle bundle8 = (Bundle) obj2;
                                if (c3413h1.f11521f == 0 && i22 == c3413h1.f11522g && i23 >= 1) {
                                    c3413h1.f11522g = 0;
                                    c3413h1.f11521f = i23;
                                    C0157r0 c0157r0M439c = C0157r0.m439c(bundle8);
                                    if (serviceConnectionC3428m1.f11587n == c3413h1) {
                                        serviceConnectionC3428m1.m6907f(c0157r0M439c);
                                    }
                                    if (serviceConnectionC3428m1.f11587n == c3413h1) {
                                        serviceConnectionC3428m1.f11588o = true;
                                        ArrayList arrayList = serviceConnectionC3428m1.f11584k;
                                        int size = arrayList.size();
                                        for (int i24 = 0; i24 < size; i24++) {
                                            ((InterfaceC3416i1) arrayList.get(i24)).mo6962b(serviceConnectionC3428m1.f11587n);
                                        }
                                        C3456x c3456x4 = serviceConnectionC3428m1.f11454e;
                                        if (c3456x4 != null) {
                                            C3413h1 c3413h2 = serviceConnectionC3428m1.f11587n;
                                            int i25 = c3413h2.f11519d;
                                            c3413h2.f11519d = 1 + i25;
                                            c3413h2.m6955b(10, i25, 0, c3456x4.f11706a, null);
                                        }
                                    }
                                }
                            }
                            break;
                        case 3:
                            if (obj2 == null || (obj2 instanceof Bundle)) {
                                Bundle bundle9 = (Bundle) obj2;
                                AbstractC3433o0 abstractC3433o1 = (AbstractC3433o0) sparseArray.get(i22);
                                if (abstractC3433o1 != null) {
                                    sparseArray.remove(i22);
                                    abstractC3433o1.mo6960b(bundle9);
                                }
                            }
                            break;
                        case 4:
                            if (obj2 == null || (obj2 instanceof Bundle)) {
                                String string6 = bundlePeekData2 != null ? bundlePeekData2.getString("error") : null;
                                Bundle bundle10 = (Bundle) obj2;
                                AbstractC3433o0 abstractC3433o2 = (AbstractC3433o0) sparseArray.get(i22);
                                if (abstractC3433o2 != null) {
                                    sparseArray.remove(i22);
                                    abstractC3433o2.mo6959a(string6, bundle10);
                                }
                            }
                            break;
                        case 5:
                            if (obj2 == null || (obj2 instanceof Bundle)) {
                                Bundle bundle11 = (Bundle) obj2;
                                if (c3413h1.f11521f != 0) {
                                    C0157r0 c0157r0M439c2 = C0157r0.m439c(bundle11);
                                    if (serviceConnectionC3428m1.f11587n == c3413h1) {
                                        serviceConnectionC3428m1.m6907f(c0157r0M439c2);
                                    }
                                }
                            }
                            break;
                        case 6:
                            if (obj2 instanceof Bundle) {
                                Bundle bundle12 = (Bundle) obj2;
                                AbstractC3433o0 abstractC3433o3 = (AbstractC3433o0) sparseArray.get(i22);
                                if (bundle12 == null || !bundle12.containsKey("routeId")) {
                                    abstractC3433o3.mo6959a("DynamicGroupRouteController is created without valid route id.", bundle12);
                                } else {
                                    sparseArray.remove(i22);
                                    abstractC3433o3.mo6960b(bundle12);
                                }
                            } else {
                                Log.w("MediaRouteProviderProxy", "No further information on the dynamic group controller");
                            }
                            break;
                        case 7:
                            if (obj2 == null || (obj2 instanceof Bundle)) {
                                Bundle bundle13 = (Bundle) obj2;
                                if (c3413h1.f11521f != 0) {
                                    Bundle bundle14 = (Bundle) bundle13.getParcelable("groupRoute");
                                    C3454w c3454w = bundle14 != null ? new C3454w(bundle14) : null;
                                    ArrayList<Bundle> parcelableArrayList = bundle13.getParcelableArrayList("dynamicRoutes");
                                    ArrayList arrayList2 = new ArrayList();
                                    for (Bundle bundle15 : parcelableArrayList) {
                                        if (bundle15 == null) {
                                            c3460z = null;
                                        } else {
                                            Bundle bundle16 = bundle15.getBundle("mrDescriptor");
                                            c3460z = new C3460z(bundle16 != null ? new C3454w(bundle16) : null, bundle15.getInt("selectionState", 1), bundle15.getBoolean("isUnselectable", false), bundle15.getBoolean("isGroupable", false), bundle15.getBoolean("isTransferable", false));
                                        }
                                        arrayList2.add(c3460z);
                                    }
                                    if (serviceConnectionC3428m1.f11587n == c3413h1) {
                                        for (InterfaceC3416i1 interfaceC3416i3 : serviceConnectionC3428m1.f11584k) {
                                            if (interfaceC3416i3.mo6961a() == i23) {
                                                interfaceC3416i2 = interfaceC3416i3;
                                                if (interfaceC3416i2 instanceof C3422k1) {
                                                    ((C3422k1) interfaceC3416i2).m6889m(c3454w, arrayList2);
                                                }
                                                break;
                                            }
                                        }
                                        if (interfaceC3416i2 instanceof C3422k1) {
                                            ((C3422k1) interfaceC3416i2).m6889m(c3454w, arrayList2);
                                        }
                                    }
                                }
                            }
                            break;
                        case 8:
                            if (serviceConnectionC3428m1.f11587n == c3413h1) {
                                ArrayList<InterfaceC3416i1> arrayList3 = serviceConnectionC3428m1.f11584k;
                                for (InterfaceC3416i1 interfaceC3416i4 : arrayList3) {
                                    if (interfaceC3416i4.mo6961a() == i23) {
                                        interfaceC3416i1 = interfaceC3416i4;
                                        c0628x = serviceConnectionC3428m1.f11589p;
                                        if (c0628x != null && (interfaceC3416i1 instanceof AbstractC3397c0)) {
                                            abstractC3397c0 = (AbstractC3397c0) interfaceC3416i1;
                                            c3411h = ((C3434o1) c0628x.f2661b).f11601b;
                                            if (c3411h.f11492e == abstractC3397c0) {
                                                c3411h.m6943j(c3411h.m6936c(), 2, true);
                                            }
                                        }
                                        if (interfaceC3416i1 != null) {
                                            arrayList3.remove(interfaceC3416i1);
                                            interfaceC3416i1.mo6963c();
                                            serviceConnectionC3428m1.m7007l();
                                        }
                                        break;
                                    }
                                }
                                c0628x = serviceConnectionC3428m1.f11589p;
                                if (c0628x != null) {
                                    abstractC3397c0 = (AbstractC3397c0) interfaceC3416i1;
                                    c3411h = ((C3434o1) c0628x.f2661b).f11601b;
                                    if (c3411h.f11492e == abstractC3397c0) {
                                        c3411h.m6943j(c3411h.m6936c(), 2, true);
                                    }
                                }
                                if (interfaceC3416i1 != null) {
                                    arrayList3.remove(interfaceC3416i1);
                                    interfaceC3416i1.mo6963c();
                                    serviceConnectionC3428m1.m7007l();
                                }
                            }
                            break;
                    }
                    int i26 = ServiceConnectionC3428m1.f11581q;
                }
                break;
        }
    }

    public HandlerC0132f(MediaRouteProviderService mediaRouteProviderService) {
        this.f285b = new WeakReference(mediaRouteProviderService);
    }

    public HandlerC0132f(C3413h1 c3413h1) {
        this.f285b = new WeakReference(c3413h1);
    }
}

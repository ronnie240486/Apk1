package p173q1;

import android.media.RoutingSessionInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import androidx.appcompat.app.C0157r0;
import androidx.appcompat.app.RunnableC0147m0;
import androidx.mediarouter.media.MediaRouteProviderService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p160p.C3341e;

public final class C3450u {

    public final AbstractC3394b0 f11677b;

    public final long f11678c;

    public final int f11679d;

    public final WeakReference f11680e;

    public boolean f11682g;

    public RoutingSessionInfo f11683h;

    public String f11684i;

    public String f11685j;

    public final C3452v f11686k;

    public final C3341e f11676a = new C3341e(0);

    public boolean f11681f = false;

    public C3450u(C3452v c3452v, AbstractC3394b0 abstractC3394b0, long j10, int i6, C3409g0 c3409g0) {
        this.f11686k = c3452v;
        this.f11677b = abstractC3394b0;
        this.f11678c = j10;
        this.f11679d = i6;
        this.f11680e = new WeakReference(c3409g0);
    }

    public final void m7063a(boolean z7) {
        C3409g0 c3409g0;
        if (this.f11682g) {
            return;
        }
        int i6 = this.f11679d;
        if ((i6 & 3) == 3) {
            m7065c(null, this.f11683h, null, C3400d0.f11443b);
        }
        if (z7) {
            AbstractC3397c0 abstractC3397c0 = this.f11677b;
            abstractC3397c0.mo6900i(2);
            abstractC3397c0.mo6897e();
            if ((i6 & 1) == 0 && (c3409g0 = (C3409g0) this.f11680e.get()) != null) {
                if (abstractC3397c0 instanceof C3441r) {
                    abstractC3397c0 = ((C3441r) abstractC3397c0).f11642g;
                }
                String str = this.f11685j;
                SparseArray sparseArray = c3409g0.f11533f;
                int iIndexOfValue = sparseArray.indexOfValue(abstractC3397c0);
                int iKeyAt = iIndexOfValue < 0 ? -1 : sparseArray.keyAt(iIndexOfValue);
                c3409g0.mo6932f(iKeyAt);
                if (c3409g0.f11529b < 4) {
                    c3409g0.f11478k.put(str, Integer.valueOf(iKeyAt));
                    c3409g0.f11477j.postDelayed(new RunnableC0147m0(c3409g0, 14, str), 5000L);
                    C0157r0 c0157r0 = c3409g0.f11479l.f11538a.f3441d.f11456g;
                    if (c0157r0 != null) {
                        MediaRouteProviderService.m2806e(c3409g0.f11528a, 5, 0, 0, c3409g0.mo6928a(c0157r0), null);
                    }
                } else if (iKeyAt < 0) {
                    Log.w("MediaRouteProviderSrv", "releaseControllerByProvider: Can't find the controller. route ID=" + str);
                } else {
                    MediaRouteProviderService.m2806e(c3409g0.f11528a, 8, 0, iKeyAt, null, null);
                }
            }
        }
        this.f11682g = true;
        this.f11686k.notifySessionReleased(this.f11684i);
    }

    public final void m7064b(RoutingSessionInfo routingSessionInfo) {
        if (this.f11683h != null) {
            Log.w("MR2ProviderService", "setSessionInfo: This shouldn't be called after sessionInfo is set");
            return;
        }
        Messenger messenger = new Messenger(new HandlerC3444s(this.f11686k, this.f11684i));
        RoutingSessionInfo.Builder builderM6971d = AbstractC3417j.m6971d(routingSessionInfo);
        Bundle bundle = new Bundle();
        bundle.putParcelable("androidx.mediarouter.media.KEY_MESSENGER", messenger);
        bundle.putString("androidx.mediarouter.media.KEY_SESSION_NAME", routingSessionInfo.getName() != null ? routingSessionInfo.getName().toString() : null);
        this.f11683h = builderM6971d.setControlHints(bundle).build();
    }

    public final void m7065c(String str, RoutingSessionInfo routingSessionInfo, RoutingSessionInfo routingSessionInfo2, C3400d0 c3400d0) {
        C3341e c3341e;
        AbstractC3397c0 abstractC3397c0;
        List<String> listEmptyList = routingSessionInfo == null ? Collections.emptyList() : routingSessionInfo.getSelectedRoutes();
        List listEmptyList2 = routingSessionInfo2 == null ? Collections.emptyList() : routingSessionInfo2.getSelectedRoutes();
        Iterator it = listEmptyList2.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            c3341e = this.f11676a;
            if (!zHasNext) {
                break;
            }
            String str2 = (String) it.next();
            C3409g0 c3409g0 = (C3409g0) this.f11680e.get();
            if ((c3409g0 != null ? (AbstractC3397c0) c3409g0.f11476i.get(str2) : (AbstractC3397c0) c3341e.get(str2)) == null) {
                AbstractC3397c0 abstractC3397c0Mo6904c = (AbstractC3397c0) c3341e.get(str2);
                if (abstractC3397c0Mo6904c == null) {
                    C3452v c3452v = this.f11686k;
                    if (str == null) {
                        MediaRouteProviderService mediaRouteProviderService = c3452v.f11692b.f11538a;
                        abstractC3397c0Mo6904c = (mediaRouteProviderService != null ? mediaRouteProviderService.f3441d : null).mo6905d(str2, c3400d0);
                    } else {
                        MediaRouteProviderService mediaRouteProviderService2 = c3452v.f11692b.f11538a;
                        abstractC3397c0Mo6904c = (mediaRouteProviderService2 != null ? mediaRouteProviderService2.f3441d : null).mo6904c(str2, str);
                    }
                    if (abstractC3397c0Mo6904c != null) {
                        c3341e.put(str2, abstractC3397c0Mo6904c);
                    }
                }
                if (abstractC3397c0Mo6904c != null) {
                    abstractC3397c0Mo6904c.mo6898f();
                }
            }
        }
        for (String str3 : listEmptyList) {
            if (!listEmptyList2.contains(str3) && (abstractC3397c0 = (AbstractC3397c0) c3341e.remove(str3)) != null) {
                abstractC3397c0.mo6900i(0);
                abstractC3397c0.mo6897e();
            }
        }
    }

    public final void m7066d(C3454w c3454w, ArrayList arrayList) {
        RoutingSessionInfo routingSessionInfo = this.f11683h;
        if (routingSessionInfo == null) {
            Log.w("MR2ProviderService", "updateSessionInfo: mSessionInfo is null. This shouldn't happen.");
            return;
        }
        C3452v c3452v = this.f11686k;
        if (c3454w != null && !c3454w.f11701a.getBoolean("enabled", true)) {
            c3452v.onReleaseSession(0L, this.f11684i);
            return;
        }
        RoutingSessionInfo.Builder builderM6971d = AbstractC3417j.m6971d(routingSessionInfo);
        if (c3454w != null) {
            this.f11685j = c3454w.m7089f();
            builderM6971d.setName(c3454w.m7090g()).setVolume(c3454w.m7091h()).setVolumeMax(c3454w.m7093j()).setVolumeHandling(c3454w.m7092i());
            builderM6971d.clearSelectedRoutes();
            if (c3454w.m7087d().isEmpty()) {
                builderM6971d.addSelectedRoute(this.f11685j);
            } else {
                Iterator it = c3454w.m7087d().iterator();
                while (it.hasNext()) {
                    builderM6971d.addSelectedRoute((String) it.next());
                }
            }
            Bundle controlHints = routingSessionInfo.getControlHints();
            if (controlHints == null) {
                Log.w("MR2ProviderService", "updateSessionInfo: controlHints is null. This shouldn't happen.");
                controlHints = new Bundle();
            }
            controlHints.putString("androidx.mediarouter.media.KEY_SESSION_NAME", c3454w.m7090g());
            controlHints.putBundle("androidx.mediarouter.media.KEY_GROUP_ROUTE", c3454w.f11701a);
            builderM6971d.setControlHints(controlHints);
        }
        this.f11683h = builderM6971d.build();
        if (arrayList != null && !arrayList.isEmpty()) {
            builderM6971d.clearSelectedRoutes();
            builderM6971d.clearSelectableRoutes();
            builderM6971d.clearDeselectableRoutes();
            builderM6971d.clearTransferableRoutes();
            Iterator it2 = arrayList.iterator();
            boolean z7 = false;
            while (it2.hasNext()) {
                C3460z c3460z = (C3460z) it2.next();
                String strM7089f = c3460z.f11719a.m7089f();
                int i6 = c3460z.f11720b;
                if (i6 == 2 || i6 == 3) {
                    builderM6971d.addSelectedRoute(strM7089f);
                    z7 = true;
                }
                if (c3460z.f11722d) {
                    builderM6971d.addSelectableRoute(strM7089f);
                }
                if (c3460z.f11721c) {
                    builderM6971d.addDeselectableRoute(strM7089f);
                }
                if (c3460z.f11723e) {
                    builderM6971d.addTransferableRoute(strM7089f);
                }
            }
            if (z7) {
                this.f11683h = builderM6971d.build();
            }
        }
        int i10 = C3452v.f11690f;
        if ((this.f11679d & 5) == 5 && c3454w != null) {
            m7065c(c3454w.m7089f(), routingSessionInfo, this.f11683h, C3400d0.f11443b);
        }
        boolean z10 = this.f11681f;
        if (z10) {
            c3452v.notifySessionUpdated(this.f11683h);
        } else if (z10) {
            Log.w("MR2ProviderService", "notifySessionCreated: Routing session is already created.");
        } else {
            this.f11681f = true;
            c3452v.notifySessionCreated(this.f11678c, this.f11683h);
        }
    }
}

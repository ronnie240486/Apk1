package p173q1;

import android.content.Intent;
import android.media.MediaRoute2Info;
import android.media.MediaRouter2;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import androidx.mediarouter.app.HandlerC1080c;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import p000a.RunnableC0001b;

public final class C3423l extends AbstractC3394b0 {

    public final String f11556f;

    public final MediaRouter2.RoutingController f11557g;

    public final Messenger f11558h;

    public final Messenger f11559i;

    public final Handler f11561k;

    public C3454w f11565o;

    public final C3435p f11566p;

    public final SparseArray f11560j = new SparseArray();

    public final AtomicInteger f11562l = new AtomicInteger(1);

    public final RunnableC0001b f11563m = new RunnableC0001b(14, this);

    public int f11564n = -1;

    public C3423l(C3435p c3435p, MediaRouter2.RoutingController routingController, String str) {
        Bundle controlHints;
        this.f11566p = c3435p;
        this.f11557g = routingController;
        this.f11556f = str;
        int i6 = C3435p.f11609s;
        Messenger messenger = (routingController == null || (controlHints = routingController.getControlHints()) == null) ? null : (Messenger) controlHints.getParcelable("androidx.mediarouter.media.KEY_MESSENGER");
        this.f11558h = messenger;
        this.f11559i = messenger != null ? new Messenger(new HandlerC1080c(this)) : null;
        this.f11561k = new Handler(Looper.getMainLooper());
    }

    @Override
    public final boolean mo6896d(Intent intent, AbstractC3433o0 abstractC3433o0) {
        Messenger messenger;
        MediaRouter2.RoutingController routingController = this.f11557g;
        if (routingController != null && !routingController.isReleased() && (messenger = this.f11558h) != null) {
            int andIncrement = this.f11562l.getAndIncrement();
            Message messageObtain = Message.obtain();
            messageObtain.what = 9;
            messageObtain.arg1 = andIncrement;
            messageObtain.obj = intent;
            messageObtain.replyTo = this.f11559i;
            try {
                messenger.send(messageObtain);
                if (abstractC3433o0 == null) {
                    return true;
                }
                this.f11560j.put(andIncrement, abstractC3433o0);
                return true;
            } catch (DeadObjectException unused) {
            } catch (RemoteException e5) {
                Log.e("MR2Provider", "Could not send control request to service.", e5);
            }
        }
        return false;
    }

    @Override
    public final void mo6897e() {
        this.f11557g.release();
    }

    @Override
    public final void mo6894g(int i6) {
        MediaRouter2.RoutingController routingController = this.f11557g;
        if (routingController == null) {
            return;
        }
        routingController.setVolume(i6);
        this.f11564n = i6;
        Handler handler = this.f11561k;
        RunnableC0001b runnableC0001b = this.f11563m;
        handler.removeCallbacks(runnableC0001b);
        handler.postDelayed(runnableC0001b, 1000L);
    }

    @Override
    public final void mo6895j(int i6) {
        MediaRouter2.RoutingController routingController = this.f11557g;
        if (routingController == null) {
            return;
        }
        int volume = this.f11564n;
        if (volume < 0) {
            volume = routingController.getVolume();
        }
        int iMax = Math.max(0, Math.min(volume + i6, this.f11557g.getVolumeMax()));
        this.f11564n = iMax;
        this.f11557g.setVolume(iMax);
        Handler handler = this.f11561k;
        RunnableC0001b runnableC0001b = this.f11563m;
        handler.removeCallbacks(runnableC0001b);
        handler.postDelayed(runnableC0001b, 1000L);
    }

    @Override
    public final void mo6890n(String str) {
        if (str == null || str.isEmpty()) {
            Log.w("MR2Provider", "onAddMemberRoute: Ignoring null or empty routeId.");
            return;
        }
        MediaRoute2Info mediaRoute2InfoM7010h = this.f11566p.m7010h(str);
        if (mediaRoute2InfoM7010h == null) {
            Log.w("MR2Provider", "onAddMemberRoute: Specified route not found. routeId=".concat(str));
        } else {
            this.f11557g.selectRoute(mediaRoute2InfoM7010h);
        }
    }

    @Override
    public final void mo6891o(String str) {
        if (str == null || str.isEmpty()) {
            Log.w("MR2Provider", "onRemoveMemberRoute: Ignoring null or empty routeId.");
            return;
        }
        MediaRoute2Info mediaRoute2InfoM7010h = this.f11566p.m7010h(str);
        if (mediaRoute2InfoM7010h == null) {
            Log.w("MR2Provider", "onRemoveMemberRoute: Specified route not found. routeId=".concat(str));
        } else {
            this.f11557g.deselectRoute(mediaRoute2InfoM7010h);
        }
    }

    @Override
    public final void mo6892p(List list) {
        if (list == null || list.isEmpty()) {
            Log.w("MR2Provider", "onUpdateMemberRoutes: Ignoring null or empty routeIds.");
            return;
        }
        String str = (String) list.get(0);
        C3435p c3435p = this.f11566p;
        MediaRoute2Info mediaRoute2InfoM7010h = c3435p.m7010h(str);
        if (mediaRoute2InfoM7010h != null) {
            c3435p.f11610i.transferTo(mediaRoute2InfoM7010h);
            return;
        }
        Log.w("MR2Provider", "onUpdateMemberRoutes: Specified route not found. routeId=" + str);
    }
}

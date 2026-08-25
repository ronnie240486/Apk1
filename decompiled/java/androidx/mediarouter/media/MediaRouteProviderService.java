package androidx.mediarouter.media;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.appcompat.app.C0157r0;
import androidx.appcompat.app.HandlerC0132f;
import androidx.mediarouter.app.HandlerC1080c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p000a.AbstractC0004e;
import p173q1.AbstractC3403e0;
import p173q1.C3405f;
import p173q1.C3412h0;
import p173q1.C3421k0;
import p173q1.C3451u0;
import p173q1.C3454w;

public abstract class MediaRouteProviderService extends Service {

    public static final int f3437f = 0;

    public final Messenger f3438a = new Messenger(new HandlerC0132f(this));

    public final HandlerC1080c f3439b = new HandlerC1080c(9, this);

    public final C3405f f3440c;

    public AbstractC3403e0 f3441d;

    public final C3421k0 f3442e;

    static {
        Log.isLoggable("MediaRouteProviderSrv", 3);
    }

    public MediaRouteProviderService() {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f3442e = new C3412h0(this);
        } else {
            this.f3442e = new C3421k0(this);
        }
        C3421k0 c3421k0 = this.f3442e;
        c3421k0.getClass();
        this.f3440c = new C3405f(1, c3421k0);
    }

    public static Bundle m2804a(C0157r0 c0157r0, int i6) {
        if (c0157r0 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<C3454w> list = (List) c0157r0.f429c;
        arrayList.addAll(list);
        arrayList.clear();
        boolean z7 = i6 < 4 ? false : c0157r0.f428b;
        for (C3454w c3454w : list) {
            if (i6 >= c3454w.f11701a.getInt("minClientVersion", 1) && i6 <= c3454w.f11701a.getInt("maxClientVersion", Integer.MAX_VALUE)) {
                if (arrayList.contains(c3454w)) {
                    throw new IllegalArgumentException("route descriptor already added");
                }
                arrayList.add(c3454w);
            }
        }
        List listEmptyList = arrayList.isEmpty() ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(arrayList));
        Bundle bundle = new Bundle();
        if (!listEmptyList.isEmpty()) {
            int size = listEmptyList.size();
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(size);
            for (int i10 = 0; i10 < size; i10++) {
                arrayList2.add(((C3454w) listEmptyList.get(i10)).f11701a);
            }
            bundle.putParcelableArrayList("routes", arrayList2);
        }
        bundle.putBoolean("supportsDynamicGroupRoute", z7);
        return bundle;
    }

    public static void m2805d(Messenger messenger, int i6) {
        if (i6 != 0) {
            m2806e(messenger, 1, i6, 0, null, null);
        }
    }

    public static void m2806e(Messenger messenger, int i6, int i10, int i11, Bundle bundle, Bundle bundle2) {
        Message messageObtain = Message.obtain();
        messageObtain.what = i6;
        messageObtain.arg1 = i10;
        messageObtain.arg2 = i11;
        messageObtain.obj = bundle;
        messageObtain.setData(bundle2);
        try {
            messenger.send(messageObtain);
        } catch (DeadObjectException unused) {
        } catch (RemoteException e5) {
            StringBuilder sb = new StringBuilder("Could not send message to ");
            sb.append("Client connection " + messenger.getBinder().toString());
            Log.e("MediaRouteProviderSrv", sb.toString(), e5);
        }
    }

    @Override
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        this.f3442e.mo6950a(context);
    }

    public final void m2807b() {
        AbstractC3403e0 abstractC3403e0M2808c;
        if (this.f3441d != null || (abstractC3403e0M2808c = m2808c()) == null) {
            return;
        }
        String packageName = ((ComponentName) abstractC3403e0M2808c.f11451b.f9501b).getPackageName();
        if (packageName.equals(getPackageName())) {
            this.f3441d = abstractC3403e0M2808c;
            C3451u0.m7067b();
            abstractC3403e0M2808c.f11453d = this.f3440c;
        } else {
            StringBuilder sbM30x = AbstractC0004e.m30x("onCreateMediaRouteProvider() returned a provider whose package name does not match the package name of the service.  A media route provider service can only export its own media route providers.  Provider package name: ", packageName, ".  Service package name: ");
            sbM30x.append(getPackageName());
            sbM30x.append(".");
            throw new IllegalStateException(sbM30x.toString());
        }
    }

    public abstract AbstractC3403e0 m2808c();

    @Override
    public final IBinder onBind(Intent intent) {
        return this.f3442e.mo6952f(intent);
    }

    @Override
    public final void onDestroy() {
        AbstractC3403e0 abstractC3403e0 = this.f3441d;
        if (abstractC3403e0 != null) {
            C3451u0.m7067b();
            abstractC3403e0.f11453d = null;
        }
        C3421k0 c3421k0 = this.f3442e;
        synchronized (c3421k0.f11544g) {
            c3421k0.f11543f.clear();
        }
        super.onDestroy();
    }
}

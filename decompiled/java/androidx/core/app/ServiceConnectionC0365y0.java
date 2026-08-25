package androidx.core.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class ServiceConnectionC0365y0 implements Handler.Callback, ServiceConnection {

    public final Context f1588a;

    public final Handler f1589b;

    public final HashMap f1590c = new HashMap();

    public HashSet f1591d = new HashSet();

    public ServiceConnectionC0365y0(Context context) {
        this.f1588a = context;
        HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
        handlerThread.start();
        this.f1589b = new Handler(handlerThread.getLooper(), this);
    }

    public final void m1068a(C0363x0 c0363x0) {
        boolean z7;
        ArrayDeque arrayDeque;
        boolean zIsLoggable = Log.isLoggable("NotifManCompat", 3);
        ComponentName componentName = c0363x0.f1583a;
        if (zIsLoggable) {
            Log.d("NotifManCompat", "Processing component " + componentName + ", " + c0363x0.f1586d.size() + " queued tasks");
        }
        if (c0363x0.f1586d.isEmpty()) {
            return;
        }
        if (c0363x0.f1584b) {
            z7 = true;
        } else {
            Intent component = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(componentName);
            Context context = this.f1588a;
            boolean zBindService = context.bindService(component, this, 33);
            c0363x0.f1584b = zBindService;
            if (zBindService) {
                c0363x0.f1587e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + componentName);
                context.unbindService(this);
            }
            z7 = c0363x0.f1584b;
        }
        if (!z7 || c0363x0.f1585c == null) {
            m1069b(c0363x0);
            return;
        }
        while (true) {
            arrayDeque = c0363x0.f1586d;
            C0359v0 c0359v0 = (C0359v0) arrayDeque.peek();
            if (c0359v0 == null) {
                break;
            }
            try {
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Sending task " + c0359v0);
                }
                c0363x0.f1585c.notify(c0359v0.f1578a, c0359v0.f1579b, null, c0359v0.f1580c);
                arrayDeque.remove();
            } catch (DeadObjectException unused) {
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Remote service has died: " + componentName);
                }
            } catch (RemoteException e5) {
                Log.w("NotifManCompat", "RemoteException communicating with " + componentName, e5);
            }
        }
        if (arrayDeque.isEmpty()) {
            return;
        }
        m1069b(c0363x0);
    }

    public final void m1069b(C0363x0 c0363x0) {
        Handler handler = this.f1589b;
        ComponentName componentName = c0363x0.f1583a;
        if (handler.hasMessages(3, componentName)) {
            return;
        }
        int i6 = c0363x0.f1587e;
        int i10 = i6 + 1;
        c0363x0.f1587e = i10;
        if (i10 <= 6) {
            int i11 = (1 << i6) * 1000;
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Scheduling retry for " + i11 + " ms");
            }
            handler.sendMessageDelayed(handler.obtainMessage(3, componentName), i11);
            return;
        }
        StringBuilder sb = new StringBuilder("Giving up on delivering ");
        ArrayDeque arrayDeque = c0363x0.f1586d;
        sb.append(arrayDeque.size());
        sb.append(" tasks to ");
        sb.append(componentName);
        sb.append(" after ");
        sb.append(c0363x0.f1587e);
        sb.append(" retries");
        Log.w("NotifManCompat", sb.toString());
        arrayDeque.clear();
    }

    @Override
    public final boolean handleMessage(Message message) {
        HashSet hashSet;
        int i6 = message.what;
        if (i6 != 0) {
            if (i6 == 1) {
                C0361w0 c0361w0 = (C0361w0) message.obj;
                ComponentName componentName = c0361w0.f1581a;
                IBinder iBinder = c0361w0.f1582b;
                C0363x0 c0363x0 = (C0363x0) this.f1590c.get(componentName);
                if (c0363x0 != null) {
                    c0363x0.f1585c = INotificationSideChannel.Stub.asInterface(iBinder);
                    c0363x0.f1587e = 0;
                    m1068a(c0363x0);
                }
                return true;
            }
            if (i6 != 2) {
                if (i6 != 3) {
                    return false;
                }
                C0363x0 c0363x1 = (C0363x0) this.f1590c.get((ComponentName) message.obj);
                if (c0363x1 != null) {
                    m1068a(c0363x1);
                }
                return true;
            }
            C0363x0 c0363x2 = (C0363x0) this.f1590c.get((ComponentName) message.obj);
            if (c0363x2 != null) {
                if (c0363x2.f1584b) {
                    this.f1588a.unbindService(this);
                    c0363x2.f1584b = false;
                }
                c0363x2.f1585c = null;
            }
            return true;
        }
        C0359v0 c0359v0 = (C0359v0) message.obj;
        String string = Settings.Secure.getString(this.f1588a.getContentResolver(), "enabled_notification_listeners");
        synchronized (C0367z0.f1592c) {
            if (string != null) {
                try {
                    if (!string.equals(C0367z0.f1593d)) {
                        String[] strArrSplit = string.split(":", -1);
                        HashSet hashSet2 = new HashSet(strArrSplit.length);
                        for (String str : strArrSplit) {
                            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                            if (componentNameUnflattenFromString != null) {
                                hashSet2.add(componentNameUnflattenFromString.getPackageName());
                            }
                        }
                        C0367z0.f1594e = hashSet2;
                        C0367z0.f1593d = string;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            hashSet = C0367z0.f1594e;
        }
        if (!hashSet.equals(this.f1591d)) {
            this.f1591d = hashSet;
            List<ResolveInfo> listQueryIntentServices = this.f1588a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet<ComponentName> hashSet3 = new HashSet();
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                if (hashSet.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName2 = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName2 + ", not adding listener record.");
                    } else {
                        hashSet3.add(componentName2);
                    }
                }
            }
            for (ComponentName componentName3 : hashSet3) {
                if (!this.f1590c.containsKey(componentName3)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName3);
                    }
                    this.f1590c.put(componentName3, new C0363x0(componentName3));
                }
            }
            Iterator it = this.f1590c.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (!hashSet3.contains(entry.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Removing listener record for " + entry.getKey());
                    }
                    C0363x0 c0363x3 = (C0363x0) entry.getValue();
                    if (c0363x3.f1584b) {
                        this.f1588a.unbindService(this);
                        c0363x3.f1584b = false;
                    }
                    c0363x3.f1585c = null;
                    it.remove();
                }
            }
        }
        for (C0363x0 c0363x4 : this.f1590c.values()) {
            c0363x4.f1586d.add(c0359v0);
            m1068a(c0363x4);
        }
        return true;
    }

    @Override
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Connected to service " + componentName);
        }
        this.f1589b.obtainMessage(1, new C0361w0(componentName, iBinder)).sendToTarget();
    }

    @Override
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Disconnected from service " + componentName);
        }
        this.f1589b.obtainMessage(2, componentName).sendToTarget();
    }
}

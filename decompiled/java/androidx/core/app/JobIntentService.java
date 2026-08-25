package androidx.core.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import java.util.ArrayList;
import java.util.HashMap;

@Deprecated
public abstract class JobIntentService extends Service {

    public static final HashMap f1459f = new HashMap();

    public JobServiceEngineC0340m f1460a;

    public C0332i f1461b;

    public AsyncTaskC0330h f1462c;

    public boolean f1463d = false;

    public final ArrayList f1464e;

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1464e = null;
        } else {
            this.f1464e = new ArrayList();
        }
    }

    public final void m938a(boolean z7) {
        if (this.f1462c == null) {
            this.f1462c = new AsyncTaskC0330h(this);
            C0332i c0332i = this.f1461b;
            if (c0332i != null && z7) {
                synchronized (c0332i) {
                    try {
                        if (!c0332i.f1504c) {
                            c0332i.f1504c = true;
                            c0332i.f1503b.acquire(600000L);
                            c0332i.f1502a.release();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            this.f1462c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public abstract void m939b();

    public final void m940c() {
        ArrayList arrayList = this.f1464e;
        if (arrayList != null) {
            synchronized (arrayList) {
                try {
                    this.f1462c = null;
                    ArrayList arrayList2 = this.f1464e;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        m938a(false);
                    } else if (!this.f1463d) {
                        this.f1461b.m967a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override
    public final IBinder onBind(Intent intent) {
        JobServiceEngineC0340m jobServiceEngineC0340m = this.f1460a;
        if (jobServiceEngineC0340m != null) {
            return jobServiceEngineC0340m.getBinder();
        }
        return null;
    }

    @Override
    public final void onCreate() {
        super.onCreate();
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 26) {
            this.f1460a = new JobServiceEngineC0340m(this);
            this.f1461b = null;
            return;
        }
        this.f1460a = null;
        ComponentName componentName = new ComponentName(this, getClass());
        HashMap map = f1459f;
        C0332i c0332i = (C0332i) map.get(componentName);
        if (c0332i == null) {
            if (i6 >= 26) {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
            c0332i = new C0332i(this, componentName);
            map.put(componentName, c0332i);
        }
        this.f1461b = c0332i;
    }

    @Override
    public final void onDestroy() {
        super.onDestroy();
        ArrayList arrayList = this.f1464e;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f1463d = true;
                this.f1461b.m967a();
            }
        }
    }

    @Override
    public final int onStartCommand(Intent intent, int i6, int i10) {
        if (this.f1464e == null) {
            return 2;
        }
        this.f1461b.m968b();
        synchronized (this.f1464e) {
            ArrayList arrayList = this.f1464e;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new C0334j(this, intent, i10));
            m938a(true);
        }
        return 3;
    }
}

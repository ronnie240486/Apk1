package androidx.core.app;

import android.content.ComponentName;
import android.os.PowerManager;

public final class C0332i {

    public final PowerManager.WakeLock f1502a;

    public final PowerManager.WakeLock f1503b;

    public boolean f1504c;

    public C0332i(JobIntentService jobIntentService, ComponentName componentName) {
        jobIntentService.getApplicationContext();
        PowerManager powerManager = (PowerManager) jobIntentService.getSystemService("power");
        PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
        this.f1502a = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
        PowerManager.WakeLock wakeLockNewWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
        this.f1503b = wakeLockNewWakeLock2;
        wakeLockNewWakeLock2.setReferenceCounted(false);
    }

    public final void m967a() {
        synchronized (this) {
            try {
                if (this.f1504c) {
                    this.f1504c = false;
                    this.f1503b.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m968b() {
        synchronized (this) {
        }
    }
}

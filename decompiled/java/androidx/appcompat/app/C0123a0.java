package androidx.appcompat.app;

import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.os.PowerManager;
import android.util.Log;
import com.bumptech.glide.AbstractC1465c;
import java.util.Calendar;
import p002a1.C0026b;

public final class C0123a0 extends AbstractC0127c0 {

    public final int f257c = 1;

    public final LayoutInflaterFactory2C0135g0 f258d;

    public final Object f259e;

    public C0123a0(LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0, C0026b c0026b) {
        super(layoutInflaterFactory2C0135g0);
        this.f258d = layoutInflaterFactory2C0135g0;
        this.f259e = c0026b;
    }

    @Override
    public final IntentFilter mo368e() {
        switch (this.f257c) {
            case 0:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                return intentFilter;
            default:
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.TIME_SET");
                intentFilter2.addAction("android.intent.action.TIMEZONE_CHANGED");
                intentFilter2.addAction("android.intent.action.TIME_TICK");
                return intentFilter2;
        }
    }

    @Override
    public final int mo369f() {
        Location location;
        boolean z7;
        long j10;
        Location lastKnownLocation;
        switch (this.f257c) {
            case 0:
                return ((PowerManager) this.f259e).isPowerSaveMode() ? 2 : 1;
            default:
                C0026b c0026b = (C0026b) this.f259e;
                C0163u0 c0163u0 = (C0163u0) c0026b.f56d;
                if (c0163u0.f447b <= System.currentTimeMillis()) {
                    Context context = (Context) c0026b.f54b;
                    int iM3470e = AbstractC1465c.m3470e(context, "android.permission.ACCESS_COARSE_LOCATION");
                    Location lastKnownLocation2 = null;
                    LocationManager locationManager = (LocationManager) c0026b.f55c;
                    if (iM3470e == 0) {
                        try {
                            lastKnownLocation = locationManager.isProviderEnabled("network") ? locationManager.getLastKnownLocation("network") : null;
                        } catch (Exception e5) {
                            Log.d("TwilightManager", "Failed to get last known location", e5);
                        }
                        location = lastKnownLocation;
                    } else {
                        location = null;
                    }
                    if (AbstractC1465c.m3470e(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        try {
                            if (locationManager.isProviderEnabled("gps")) {
                                lastKnownLocation2 = locationManager.getLastKnownLocation("gps");
                            }
                        } catch (Exception e10) {
                            Log.d("TwilightManager", "Failed to get last known location", e10);
                        }
                    }
                    if (lastKnownLocation2 == null || location == null ? lastKnownLocation2 != null : lastKnownLocation2.getTime() > location.getTime()) {
                        location = lastKnownLocation2;
                    }
                    z7 = false;
                    if (location != null) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (C0161t0.f442d == null) {
                            C0161t0.f442d = new C0161t0();
                        }
                        C0161t0 c0161t0 = C0161t0.f442d;
                        c0161t0.m465a(location.getLatitude(), location.getLongitude(), jCurrentTimeMillis - 86400000);
                        c0161t0.m465a(location.getLatitude(), location.getLongitude(), jCurrentTimeMillis);
                        z7 = c0161t0.f443a == 1;
                        long j11 = c0161t0.f445c;
                        long j12 = c0161t0.f444b;
                        c0161t0.m465a(location.getLatitude(), location.getLongitude(), 86400000 + jCurrentTimeMillis);
                        long j13 = c0161t0.f445c;
                        if (j11 == -1 || j12 == -1) {
                            j10 = jCurrentTimeMillis + 43200000;
                        } else {
                            if (jCurrentTimeMillis <= j12) {
                                j13 = jCurrentTimeMillis > j11 ? j12 : j11;
                            }
                            j10 = j13 + 60000;
                        }
                        c0163u0.f446a = z7;
                        c0163u0.f447b = j10;
                    } else {
                        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                        int i6 = Calendar.getInstance().get(11);
                        if (i6 < 6 || i6 >= 22) {
                            z7 = true;
                        }
                    }
                    break;
                } else {
                    z7 = c0163u0.f446a;
                }
                return z7 ? 2 : 1;
        }
    }

    @Override
    public final void mo370l() throws IllegalAccessException {
        switch (this.f257c) {
            case 0:
                this.f258d.m402m(true, true);
                break;
            default:
                this.f258d.m402m(true, true);
                break;
        }
    }

    public C0123a0(LayoutInflaterFactory2C0135g0 layoutInflaterFactory2C0135g0, Context context) {
        super(layoutInflaterFactory2C0135g0);
        this.f258d = layoutInflaterFactory2C0135g0;
        this.f259e = (PowerManager) context.getApplicationContext().getSystemService("power");
    }
}

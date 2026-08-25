package p018b5;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import java.util.Arrays;

public final class C1319s {

    public static final Uri f4110d = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    public final String f4111a;

    public final String f4112b;

    public final boolean f4113c;

    public C1319s(String str, boolean z7) {
        AbstractC1312l.m3196c(str);
        this.f4111a = str;
        AbstractC1312l.m3196c("com.google.android.gms");
        this.f4112b = "com.google.android.gms";
        this.f4113c = z7;
    }

    public final Intent m3203a(Context context) throws C1313m {
        Bundle bundleCall;
        PendingIntent pendingIntent;
        Intent intent = null;
        String str = this.f4111a;
        if (str == null) {
            return new Intent().setComponent(null);
        }
        if (this.f4113c) {
            Bundle bundle = new Bundle();
            bundle.putString("serviceActionBundleKey", str);
            try {
                ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f4110d);
                if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                    throw new RemoteException("Failed to acquire ContentProviderClient");
                }
                try {
                    bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call("serviceIntentCall", null, bundle);
                    try {
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                    } catch (RemoteException e5) {
                        e = e5;
                        Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e.toString()));
                    } catch (IllegalArgumentException e10) {
                        e = e10;
                        Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e.toString()));
                    }
                    if (bundleCall == null && (intent = (Intent) bundleCall.getParcelable("serviceResponseIntentKey")) == null && (pendingIntent = (PendingIntent) bundleCall.getParcelable("serviceMissingResolutionIntentKey")) != null) {
                        Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action " + str + " but has possible resolution");
                        throw new C1313m(new ConnectionResult(25, pendingIntent));
                    }
                    if (intent == null) {
                        Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(str));
                    }
                } catch (Throwable th) {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                    throw th;
                }
            } catch (RemoteException e11) {
                e = e11;
                bundleCall = null;
            } catch (IllegalArgumentException e12) {
                e = e12;
                bundleCall = null;
            }
            Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e.toString()));
            if (bundleCall == null) {
            }
            if (intent == null) {
                Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(str));
            }
        }
        return intent == null ? new Intent(str).setPackage(this.f4112b) : intent;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1319s)) {
            return false;
        }
        C1319s c1319s = (C1319s) obj;
        return AbstractC1312l.m3201h(this.f4111a, c1319s.f4111a) && AbstractC1312l.m3201h(this.f4112b, c1319s.f4112b) && AbstractC1312l.m3201h(null, null) && this.f4113c == c1319s.f4113c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4111a, this.f4112b, null, 4225, Boolean.valueOf(this.f4113c)});
    }

    public final String toString() {
        String str = this.f4111a;
        if (str != null) {
            return str;
        }
        AbstractC1312l.m3198e(null);
        throw null;
    }
}

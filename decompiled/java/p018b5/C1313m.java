package p018b5;

import com.google.android.gms.common.ConnectionResult;

public final class C1313m extends Exception {

    public final ConnectionResult f4101a;

    public C1313m(ConnectionResult connectionResult) {
        if (!((connectionResult.f4971b == 0 || connectionResult.f4972c == null) ? false : true)) {
            throw new IllegalArgumentException("ResolvableConnectionException can only be created with a connection result containing a resolution.");
        }
        this.f4101a = connectionResult;
    }
}

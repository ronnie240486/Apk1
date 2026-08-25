package okhttp3.internal.connection;

import java.io.IOException;
import p103j9.AbstractC2796i;
import p123l5.AbstractC2973a;

public final class RouteException extends RuntimeException {
    private final IOException firstConnectException;
    private IOException lastConnectException;

    public RouteException(IOException iOException) {
        super(iOException);
        AbstractC2796i.m5785f(iOException, "firstConnectException");
        this.firstConnectException = iOException;
        this.lastConnectException = iOException;
    }

    public final void addConnectException(IOException iOException) {
        AbstractC2796i.m5785f(iOException, "e");
        AbstractC2973a.m6013a(this.firstConnectException, iOException);
        this.lastConnectException = iOException;
    }

    public final IOException getFirstConnectException() {
        return this.firstConnectException;
    }

    public final IOException getLastConnectException() {
        return this.lastConnectException;
    }
}

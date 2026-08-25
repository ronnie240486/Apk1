package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Route;
import p103j9.AbstractC2796i;

public final class RouteDatabase {
    private final Set<Route> failedRoutes = new LinkedHashSet();

    public final synchronized void connected(Route route) {
        AbstractC2796i.m5785f(route, "route");
        this.failedRoutes.remove(route);
    }

    public final synchronized void failed(Route route) {
        AbstractC2796i.m5785f(route, "failedRoute");
        this.failedRoutes.add(route);
    }

    public final synchronized boolean shouldPostpone(Route route) {
        AbstractC2796i.m5785f(route, "route");
        return this.failedRoutes.contains(route);
    }
}

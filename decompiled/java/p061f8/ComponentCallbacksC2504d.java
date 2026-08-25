package p061f8;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import org.json.JSONException;
import p103j9.AbstractC2796i;

public final class ComponentCallbacksC2504d implements ComponentCallbacks {

    public final C2501a f8738a;

    public ComponentCallbacksC2504d(C2501a c2501a) {
        this.f8738a = c2501a;
    }

    @Override
    public final void onConfigurationChanged(Configuration configuration) throws JSONException {
        AbstractC2796i.m5786g(configuration, "newConfig");
        this.f8738a.invoke(configuration);
    }

    @Override
    public final void onLowMemory() {
    }
}

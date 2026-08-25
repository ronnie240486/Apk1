package androidx.multidex;

import android.app.Application;
import android.content.Context;
import p184r1.AbstractC3577a;

public class MultiDexApplication extends Application {
    @Override
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        AbstractC3577a.m7196d(this);
    }
}

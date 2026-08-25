package com.google.android.gms.internal.cast;

import android.widget.RelativeLayout;
import androidx.mediarouter.app.MediaRouteButton;
import org.bitspark.android.Spark;
import p101j7.C2782c;
import p176q4.C3477d;

public final class C1640o extends RelativeLayout {

    public final boolean f5474a;

    public Spark f5475b;

    public C2782c f5476c;

    public MediaRouteButton f5477d;

    public String f5478e;

    public boolean f5479f;

    public C1640o(C3477d c3477d) {
        Spark spark = (Spark) c3477d.f11769b;
        super(spark);
        this.f5475b = spark;
        this.f5474a = c3477d.f11768a;
        this.f5476c = (C2782c) c3477d.f11772e;
        this.f5477d = (MediaRouteButton) c3477d.f11770c;
        this.f5478e = (String) c3477d.f11771d;
    }

    public final void m3954a() {
        removeAllViews();
        this.f5475b = null;
        this.f5476c = null;
        this.f5477d = null;
        this.f5478e = null;
        this.f5479f = false;
    }
}

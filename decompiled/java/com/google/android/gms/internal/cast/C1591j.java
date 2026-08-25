package com.google.android.gms.internal.cast;

import android.content.Context;
import com.google.android.gms.cast.framework.CastOptions;
import java.util.Collections;
import java.util.List;
import p018b5.AbstractC1312l;
import p124l6.C2982h;
import p165p4.AbstractC3365j;
import p176q4.BinderC3484j;

public final class C1591j {

    public final Context f5351a;

    public final String f5352b;

    public final BinderC3484j f5353c;

    public final CastOptions f5354d;

    public final BinderC1703v f5355e;

    public C1591j(Context context, CastOptions castOptions, BinderC1703v binderC1703v) {
        String strM6037D;
        boolean zIsEmpty = Collections.unmodifiableList(castOptions.f4764b).isEmpty();
        String str = castOptions.f4763a;
        if (zIsEmpty) {
            strM6037D = AbstractC3365j.m6840a(str);
        } else {
            List listUnmodifiableList = Collections.unmodifiableList(castOptions.f4764b);
            if (str == null) {
                throw new IllegalArgumentException("applicationId cannot be null");
            }
            if (listUnmodifiableList == null) {
                throw new IllegalArgumentException("namespaces cannot be null");
            }
            strM6037D = C2982h.m6037D(new C2982h(str, listUnmodifiableList));
        }
        this.f5353c = new BinderC3484j(this);
        this.f5351a = context.getApplicationContext();
        AbstractC1312l.m3196c(strM6037D);
        this.f5352b = strM6037D;
        this.f5354d = castOptions;
        this.f5355e = binderC1703v;
    }
}

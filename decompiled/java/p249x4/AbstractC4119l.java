package p249x4;

import android.content.Context;
import android.util.Log;

public abstract class AbstractC4119l {

    public static final BinderC4115h f13953a;

    public static final BinderC4115h f13954b;

    public static Context f13955c;

    static {
        new BinderC4115h(AbstractBinderC4116i.m8139x("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"), 0);
        new BinderC4115h(AbstractBinderC4116i.m8139x("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"), 1);
        f13953a = new BinderC4115h(AbstractBinderC4116i.m8139x("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"), 2);
        f13954b = new BinderC4115h(AbstractBinderC4116i.m8139x("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"), 3);
    }

    public static synchronized void m8140a(Context context) {
        if (f13955c != null) {
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        } else if (context != null) {
            f13955c = context.getApplicationContext();
        }
    }
}
